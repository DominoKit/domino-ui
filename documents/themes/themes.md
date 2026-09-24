# Domino UI theming study

This document describes the current Domino UI styling and theming architecture, evaluates its
strengths and weaknesses, and records a direction for future improvements. It is an architectural
study; it does not define a new API or replace the current implementation.

## Executive assessment

Domino UI already has a strong CSS foundation:

- component selectors use the `dui-*` namespace;
- design values are centralized in CSS custom properties;
- colors, light/dark mode, accents, typography, spacing, and component defaults are represented as
  separate layers;
- CSS custom-property inheritance makes subtree-level themes possible.

The Java layer is less coherent. Two public theme APIs coexist, global and element-level state are
managed differently, and the element-level manager does not track state per target element. The
current isolation model is also namespace isolation, not hard CSS isolation.

## Current CSS architecture

### Component namespace

Domino UI elements normally receive the `dui` class from the base element wrappers:

- [`BaseElement`](../../domino-ui/src/main/java/org/dominokit/domino/ui/elements/BaseElement.java)
- [`DominoElement`](../../domino-ui/src/main/java/org/dominokit/domino/ui/utils/DominoElement.java)

Component styles use names such as `.dui-button`, `.dui-form-field`, and `.dui-card`. Many rules
also require the `.dui` class. This reduces the chance that ordinary application elements are
styled accidentally.

The Java-side CSS facade is composed through [`DominoCss`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/DominoCss.java),
which aggregates the CSS class families used by components and application code.

### Design tokens

[`domino-ui-theme-default.css`](../../domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-theme-default.css)
contains the default token set, including:

- spacing and sizing values;
- opacity and box-shadow values;
- font families and font shorthands;
- semantic colors;
- component defaults;
- state, border, layout, form, menu, table, dialog, and notification values.

Components consume these variables rather than hard-coding all visual values. A custom theme can
therefore override tokens without replacing every component stylesheet.

Component-specific tokens are the preferred way to customize a component from a custom theme. For
example, button icon sizing can be changed on the themed root with
`--dui-btn-icon-size: 0.875em;`; no component selector or internal utility-class combination is
required.

The token file currently mixes several levels of abstraction:

```text
foundation values
  → palette and semantic values
    → component values
      → state and runtime overrides
```

This works, but the contract between these layers is not formally documented.

The default theme now exposes a shared radius scale through `--dui-radius-none`,
`--dui-radius-xs`, `--dui-radius-sm`, `--dui-radius-md`, `--dui-radius-lg`, `--dui-radius-xl`, and
`--dui-radius-pill`. Component radius tokens use these primitives, with the default theme choosing
a conservative compact mapping for controls and dialogs. Custom themes can override the scale, or
override a component token when a component needs a deliberate exception.

### Colors, modes, and accents

The color implementation is distributed across:

- [`domino-ui-colors.css`](../../domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors.css), which provides color utility mappings;
- [`domino-ui-colors-light.css`](../../domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-light.css), which defines light semantic values;
- [`domino-ui-colors-dark.css`](../../domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/dui-components/domino-ui-colors-dark.css), which defines dark semantic values.

The intended composition is generally:

```html
<div class="dui dui-theme-default dui-colors-light dui-accent-teal">
    ...
</div>
```

The classes have separate responsibilities:

- `dui-theme-default` supplies the base token set;
- `dui-colors-light` or `dui-colors-dark` selects the semantic mode;
- `dui-accent-teal` selects an accent palette;
- `dui` identifies the Domino UI styling context.

Because custom properties inherit, the same classes can be placed on a nested application root to
create a local theme.

### Typography

Typography utilities are declared in [`TypographyCss`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/TypographyCss.java).
The default theme defines body, heading, monospace, and icon font variables. Named font classes
such as `dui-font-source-sans-3`, `dui-font-inter`, and `dui-font-ibm-plex-sans` change the body
font variable.

The `dui-font-scope` utility applies the selected font through a Domino UI subtree. This is the
preferred pattern when an application must keep its own site-wide font while using a different
font for Domino UI samples or an embedded UI area.

### CSS packaging

The Maven build processes the component stylesheets from the `dui-components` directory and
produces the aggregate `domino-ui.css` file. See the CSS configuration in
[`domino-ui/pom.xml`](../../domino-ui/pom.xml).

The webjar copies the generated public resources into the webjar directory. See
[`domino-ui-webjar/pom.xml`](../../domino-ui-webjar/pom.xml).

This provides a convenient complete bundle, while the source directory also contains individual
component stylesheets that can be inspected or used when a more selective integration is needed.

### WaitMe CSS clarification

`domino-ui-waitMe.css` and its minified counterpart are not Domino UI’s own component-theme CSS.
They are a ready-to-use CSS asset imported into the project to support the WaitMe loader used by
the loading/animation-related functionality.

The WaitMe stylesheet belongs to that feature integration and has its own `.waitMe_*` classes and
some `body` selectors. It should therefore be evaluated separately from the Domino UI theme
contract and should not be used as evidence that the normal Domino UI component styles are global.
Applications that do not use the WaitMe loader should treat this stylesheet as optional.

## Current Java architecture

### Legacy `Theme` and `ColorScheme`

The shared [`Theme`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/themes/Theme.java)
class represents a color scheme and:

- exposes predefined `ColorScheme` values;
- stores a global static `currentTheme`;
- applies its CSS class directly to `document.body`;
- removes the previous theme class;
- notifies global theme-change handlers.

[`ColorScheme`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/ColorScheme.java)
contains the predefined palette families and their light/dark color steps.

This API is mainly a global color-switching API. It does not model a complete theme containing
typography, component tokens, layout, or application-specific variables.

### `IsDominoTheme`

The newer [`IsDominoTheme`](../../domino-ui/src/main/java/org/dominokit/domino/ui/themes/IsDominoTheme.java)
contract defines:

- a theme name;
- a theme category;
- apply, cleanup, and `isApplied` operations;
- global and element-targeted convenience methods.

The built-in implementations are:

- `DominoThemeDefault`;
- `DominoThemeLight`;
- `DominoThemeDark`;
- `DominoThemeAccent`.

This is a better foundation for full theming because a theme can own its lifecycle and target a
specific element.

### Global manager

[`DominoThemeManager`](../../domino-ui/src/main/java/org/dominokit/domino/ui/themes/DominoThemeManager.java)
registers built-in themes and allows one active theme per category. It also persists the selected
theme names in local storage under `dui-user-themes`.

When no stored value exists, it applies:

```text
dui-theme-default
dui-colors-light
dui-accent-teal
```

The manager is appropriate for applications that intentionally want one global Domino UI theme.

### Element manager

[`ElementThemeManager`](../../domino-ui/src/main/java/org/dominokit/domino/ui/themes/ElementThemeManager.java)
provides the desired API for applying different themes to different UI areas.

Its current internal map is global by category rather than keyed by target element. This creates a
state-management problem:

1. apply a light theme to element A;
2. apply a dark theme to element B;
3. replace the theme on element A.

The manager may attempt cleanup on the wrong target, leaving stale classes on A or B. The required
state model is conceptually:

```text
target element → theme category → active theme
```

rather than:

```text
theme category → active theme
```

### Startup behavior

`BaseDominoElement` invokes `DominoThemeManager.INSTANCE.applyUserThemes()` from static
initialization. This means loading the base UI element class can read local storage and modify the
document body before application initialization is complete.

Applications such as the showcase applications also call `applyUserThemes()` explicitly. This
creates two initialization paths and can result in duplicate theme application and persistence
work.

## Styling APIs and runtime customization

The shared styling APIs provide two useful extension mechanisms:

- [`CssClass`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/CssClass.java)
  represents a reusable class that can be applied, removed, and checked;
- [`CssProperty`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/CssProperty.java)
  and [`Style`](../../domino-ui-shared/src/main/java/org/dominokit/domino/ui/style/Style.java)
  allow runtime CSS custom properties and ordinary CSS properties to be set on an element.

This gives Java applications a practical escape hatch for custom tokens. The trade-off is that
custom property names and values are mostly strings, so invalid names, missing tokens, and
incompatible values are not detected at compile time.

## Supported theme composition

The implementation now treats a theme as three composable layers applied to the same Domino UI
root:

| Layer | Built-in class/API | Responsibility |
| --- | --- | --- |
| Base | `dui-theme-default` / `DominoThemeDefault` | spacing, typography, shadows, and component fallback tokens |
| Color mode | `dui-colors-light` or `dui-colors-dark` / `DominoThemeLight` or `DominoThemeDark` | semantic foreground, background, and palette values |
| Accent/brand | `dui-accent-*` / `DominoThemeAccent` | accent color steps consumed by components and utilities |

The class order is not a substitute for the selector scope: the target must carry `dui`, and the
theme selectors are scoped to `.dui`. A normal CSS-only root therefore looks like this:

```html
<section class="dui dui-theme-default dui-colors-light dui-accent-teal">
    <!-- Domino UI components -->
</section>
```

Apply the base layer first, one color mode second, and one accent or brand layer third. The Java
managers enforce one active theme per category. A custom CSS class may then override selected
variables without changing the persisted built-in mode or accent selection.

### CSS-only custom themes

`DominoCssTheme` is useful when the application wants manager lifecycle and persistence but does
not need a custom Java class. The equivalent CSS can also be used directly:

```css
.dui.dui-theme-default.acme-theme {
    --dui-clr-primary: #355cde;
    --dui-accent-clr: #355cde;
    --dui-text-color: #1b2430;
    --dui-font-family: "Acme Sans", sans-serif;
}
```

Place `acme-theme` on the same `.dui` root as `dui-theme-default`, or on an ancestor of the
Domino UI subtree. Custom properties are inherited; a class placed on an unrelated sibling cannot
theme the components. `--dui-clr-primary` is a palette token, while `--dui-accent-clr` and
`--dui-text-color` are semantic/component extension points used by the existing component CSS.
The font variable changes body and heading typography through the default font fallbacks.

### Java theme managers

Use the global manager when the entire application intentionally shares one theme:

```java
DominoThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE);
```

Use the element manager for an embedded or subtree-scoped application:

```java
ElementThemeManager.INSTANCE.apply(DominoThemeDark.INSTANCE, applicationRoot);
```

For a CSS-only custom theme, register and apply a category-aware instance:

```java
DominoCssTheme customTheme =
    DominoCssTheme.of("acme-brand", DominoThemeCategories.MAIN, "acme-theme");

DominoThemeManager.INSTANCE
    .registerTheme(customTheme)
    .apply(customTheme);
```

`ElementThemeManager` keeps active state by target element and category, so applying a mode to one
subtree does not clean up the mode on another subtree. The global manager persists only global
themes under `dui-user-themes`; element-scoped themes are intentionally not persisted.

### Token ownership and fallback

The CSS files use the following ownership model:

```text
foundation tokens (spacing, typography, shadows)
  → color-mode semantic tokens
    → accent/palette tokens
      → component defaults and state overrides
        → consumer custom-property overrides
```

The default theme owns the foundation and component fallback variables. The light/dark files own
mode values such as `--dui-color` and `--dui-clr-*`. `domino-ui-colors.css` maps accent classes to
accent steps such as `--dui-accent`, `--dui-accent-l-1`, and `--dui-accent-d-1`. Components may
define more specific variables such as `--dui-text-color` or `--dui-accent-clr` as extension
points. Override only the variables needed by the application and let the remaining layers
inherit their defaults.

The icon font (`Material Design Icons`) is a separate typography role and should not be replaced
by the body font. The WaitMe loader font and selectors belong to the separate imported WaitMe
asset, not to the Domino UI application text-theme contract.

### Isolation and lifecycle guidance

Domino UI provides namespace and custom-property inheritance isolation, not Shadow DOM isolation.
Applying a theme to a container does not modify unrelated siblings. Applying it to `body` is an
explicit global choice and also enables the existing `body.dui` margin, padding, and overflow
reset. Dialogs, popovers, and notifications rendered directly under `body` may not inherit a
subtree theme; either theme their portal root or use an application-wide theme when those overlays
are global.

`Theme` and `ColorScheme` remain available for compatibility. They are the legacy global
color-scheme API and apply one class directly to `document.body`, with global change callbacks.
New code should use `DominoThemeManager` for category composition and `ElementThemeManager` for
scoped applications. Migration can start by replacing `new Theme(scheme).apply()` with the
corresponding built-in `DominoThemeAccent` or color-mode theme and keeping the legacy API only
where existing callbacks or body-level behavior are required.

### Troubleshooting

- A theme class has no effect when the target lacks `dui`; add `dui` to the themed root.
- A class on a sibling does not provide inherited custom properties; move it to the root or an
  ancestor of the components.
- Applying two themes in one manager category replaces the first one. Use distinct roots for
  different modes or categories.
- If startup restores an unexpected global theme, inspect and clear `dui-user-themes` in local
  storage, or explicitly apply the desired theme after initialization.
- If an overlay is unthemed, inspect where it is attached. A portal under `body` cannot inherit
  tokens from an unrelated nested application root.
- Component-specific rules can intentionally override a general variable. Override the documented
  component token on the component or themed root, and load the custom CSS after Domino UI CSS.

### WaitMe boundary

`domino-ui-waitMe.css` and `domino-ui-waitMe.min.css` remain separate ready-to-use resources for
WaitMe-based loaders. They are excluded from the generated `domino-ui.css` aggregate, but remain
available at their existing resource paths. The loader integration may contain narrow `.dui`
bridge rules for layout; those rules do not make the upstream WaitMe stylesheet part of the
Domino UI theme contract. Do not rename or re-scope `waitMe_*` classes as part of theme changes.

## Candidate main-theme directions

The current `domino-theme-default` should remain the compatibility baseline. New main themes can
share its component and semantic-token contract while changing the visual character of the
application. The following directions are suitable for different application families:

| Direction | Suitable applications | Visual language |
| --- | --- | --- |
| Slate Enterprise | administration, finance, healthcare, ERP | restrained navy/indigo accent, neutral surfaces, compact spacing, subtle borders, minimal elevation |
| Oceanic SaaS | dashboards, education, public services, collaboration | blue/teal accent, bright surfaces, clear focus states, moderate density |
| Graphite Pro | monitoring, developer tools, operations, media | graphite surfaces, strong borders, dark-first mode, cyan or violet accent |
| Evergreen | sustainability, logistics, agriculture, wellness | forest/mint semantic palette, calm contrast, low-glare surfaces |
| Warm Paper | documentation, content, booking, consumer workflows | warm off-white surfaces, charcoal text, terracotta/coral accent, editorial hierarchy |

These are product directions rather than final color specifications. Each candidate still needs
contrast checks, light and dark behavior, disabled-state review, and representative component
screens before becoming a built-in theme. The first implementation should stay close to the
default palette and focus on density and hierarchy, which makes it lower risk than introducing a
new brand identity at the same time.

## Proposed first theme: compact and clean

The first new main theme is proposed as a compact-clean variant of `domino-theme-default`. Its
purpose is to make information-dense applications feel calmer and more efficient without
changing the existing Domino UI visual language.

### Design goals

- reduce unnecessary vertical spacing in forms, cards, dialogs, tables, navigation, and layout
  regions;
- replace decorative or redundant shadows with borders, surface contrast, and spacing hierarchy;
- preserve readable line height, keyboard focus visibility, color contrast, and minimum interactive
  hit areas;
- keep the default theme behavior unchanged for existing applications;
- make the theme usable as a complete root-level theme and as a subtree-scoped theme;
- validate generic token changes before adding component-specific exceptions.

The first pass should change foundation and component tokens such as spacing, card/dialog padding,
form-field margins, table-cell padding, layout heights, gaps, and shadow assignments. For example,
the current default includes tokens such as `--dui-card-box-shadow`, `--dui-dialog-box-shadow`,
`--dui-form-field-margin`, `--dui-datatable-cell-padding`, and `--dui-stepper-gap`; these are good
candidate controls for measured, incremental changes.

Elevation should be retained where it communicates an interaction boundary: dialogs, menus,
popovers, temporary notifications, and focused or actively dragged elements. Cards, sections, and
static containers should generally use no shadow or a very subtle shadow, with borders and surface
colors providing the hierarchy instead.

### Implementation constraints

The current main-theme selector owns the complete default token set under
`.dui.dui-theme-default`. A new main theme cannot safely provide only a few overrides if the
manager removes `dui-theme-default` when it applies another main-category theme. Before adding
several themes, choose one of these compatible approaches:

1. publish each main theme as a complete token contract, initially derived from the default; or
2. refactor shared foundation/component defaults into a common base layer and let each main theme
   provide only its differences.

The second approach reduces long-term drift, but the first can be the safer initial delivery if
the CSS is not yet ready for a broad refactor. In either case, theme-specific values should remain
CSS custom-property overrides wherever possible. Component stylesheet edits should be reserved
for cases where a component has no suitable token or where its structure prevents a generic token
from expressing the intended result.

The implementation should be delivered in batches so each change can be visually reviewed:

1. foundation spacing, surfaces, borders, and elevation;
2. layout, navigation, and containers;
3. forms and selection controls;
4. cards, lists, and data tables;
5. dialogs, menus, popovers, notifications, and other overlays;
6. exceptions and component-specific refinements.

The compact theme is successful only if it remains compatible with scoped roots and does not
change unrelated host application content. A representative acceptance check should compare the
same showcase screens under the default and compact themes, measuring density improvements while
confirming focus rings, contrast, disabled states, and touch-target sizes remain usable.

## Fast theme-development loop with Domino Showcases

The current showcase setup already provides a useful split development loop:

| Change | Current fast path | Expected restart behavior |
| --- | --- | --- |
| Java in Domino UI or showcase samples | GWT code server reads the configured Domino UI and sample source roots directly | keep the backend and code server running; let incremental compilation finish and refresh the browser |
| Showcase backend/template/static resource | Quarkus dev mode serves the backend and watches its development resources | normally refresh the browser; avoid manually restarting the backend |
| Domino UI source CSS or generated `domino-ui.css` | currently delivered through the built Domino UI/webjar dependency | generally requires a targeted artifact/webjar refresh; the existing setup has no direct CSS source watcher |

The documented demo commands are:

```text
cd domino-demo/domino-demo-backend
mvn compile quarkus:dev
```

and, in a second terminal:

```text
cd domino-demo
mvn gwt:codeserver -pl domino-demo-frontend -am -Dgwt.persistentunitcache=false
```

The GWT configuration includes direct source roots for both
`demo-samples/demo-samples-ui/src/main/java` and
`domino-ui/domino-ui/src/main/java`. This means Java component and sample changes do not need a
full Maven build or a code-server restart. The browser can remain on the theme showcase page and
be refreshed after each incremental compile.

### Recommended theme laboratory

For rapid visual exploration, add a showcase-only development stylesheet loaded after
`domino-ui.css`, for example `theme-dev.css`, and use it to override the theme variables on the
showcase root. The backend template already loads `app.css` after the Domino UI bundle, so that
file can serve as an initial experiment; a dedicated file is preferable because it keeps
temporary theme work explicit and removable.

The loop then becomes:

```text
edit theme-dev.css
save
refresh the showcase browser page
```

This lets the compact spacing, border, surface, and elevation decisions be evaluated without
rebuilding Domino UI or restarting the GWT code server. Once a value is accepted, move it into the
Domino UI theme source, add or update CSS contract tests, and run the targeted Maven build before
continuing to the next component batch.

During ordinary Java iteration, persistent GWT unit caching should also be evaluated. The current
instructions disable it, which is useful for recovering from stale-cache problems but can make
startup slower. Keeping the cache enabled during normal work, and disabling it only when cache
invalidations are suspected, is a likely improvement that should be verified locally rather than
treated as a guaranteed speedup.

### Longer-term tooling improvement

If theme work becomes frequent, the showcase project could provide a development-only CSS overlay
profile or a small resource-copy watcher that mirrors selected Domino UI CSS into the running demo.
That would preserve the production webjar boundary while removing the manual artifact refresh for
CSS experiments. The watcher should remain opt-in and development-only; the production showcase
must continue to validate the packaged Domino UI resources.

## Isolation evaluation

### Strong points

- Most component selectors use the `dui-*` namespace.
- Many rules require the `dui` marker class as well as the component class.
- CSS custom-property inheritance supports local themed roots.
- There is no general reset that styles every ordinary button, label, or input.
- Fonts can be scoped with `dui-font-scope`.
- Component styles are mostly token-driven rather than fixed-value driven.

### Limitations

This is namespace isolation, not Shadow DOM or guaranteed stylesheet isolation.

The main exceptions are:

- `body.dui` changes body margin, padding, and overflow in the default theme stylesheet;
- app-layout contains body-level selectors;
- spacing defines opacity variables under `:root`;
- WaitMe has its own intentionally global `body` selectors;
- host CSS can still override `.dui`, `.dui-*`, or `--dui-*` names;
- overlays or popovers attached directly to `body` may not inherit a theme placed only on a nested
  root.

The safest integration pattern for an embedded UI is therefore a dedicated themed container:

```html
<div class="dui dui-theme-default dui-colors-light dui-accent-teal">
    <!-- Domino UI application area -->
</div>
```

Applications that use global layouts or body-level overlays need an explicit integration decision
about whether the theme should also be applied to `body`.

## Strengths

1. The CSS custom-property architecture is suitable for incremental visual customization.
2. Color mode and accent selection are separated cleanly.
3. Component-specific defaults can be changed without rewriting component structure.
4. Java CSS classes are discoverable and composable through the shared style interfaces.
5. The newer theme contract supports both global and local application.
6. The `dui-font-scope` work demonstrates a practical way to avoid changing an embedding site's
   font globally.
7. The complete CSS bundle and webjar make standard application setup straightforward.

## Weaknesses and risks

1. The old `Theme` API and the newer `DominoThemeManager` API coexist with different state models
   and class conventions.
2. `ElementThemeManager` does not track active themes per target element.
3. Theme initialization has implicit global side effects and is duplicated by application code.
4. Custom Java themes require manual lifecycle implementation instead of a token-oriented builder
   or theme definition model.
5. Local-storage restoration silently ignores unknown names and can restore an incomplete set of
   theme categories.
6. The CSS token set is large and lacks an authoritative catalog, typing, or compatibility policy.
7. `:root` token declarations and body-level rules weaken the embedded-application isolation goal.
8. The large generated/repetitive CSS files make cascade and token drift harder to review.
9. Numerous `!important` declarations, especially around font scoping, make downstream overrides
   more difficult.
10. Built-in theme mappings need stronger automated coverage. For example, the current orange
    accent declaration maps `ORANGE` to `dui_accent_red` in `DominoThemeAccent`.

## Recommended improvement direction

### Phase 1: establish one canonical API

Make `IsDominoTheme` and `DominoThemeManager` the canonical public theming model. Deprecate or
adapt the older `Theme` API so that both APIs cannot silently maintain different active themes.

### Phase 2: fix state and lifecycle correctness

- Track element themes by target and category.
- Make apply and remove operations idempotent.
- Add tests for every built-in theme and every built-in accent mapping.
- Make stored theme data deterministic and versionable.
- Handle partial or invalid stored values with a safe default.
- Remove implicit static theme initialization, or make it explicitly configurable.

### Phase 3: formalize the token contract

Document the token layers and publish a token reference containing:

- token name;
- purpose;
- default value;
- accepted value type;
- inheritance behavior;
- compatibility expectations.

The intended model should remain:

```text
foundation tokens
  → mode tokens
    → brand/accent tokens
      → component tokens
        → state overrides
```

### Phase 4: make custom themes easier

A CSS-only custom theme should require only a scoped class and token overrides:

```css
.company-ui.dui-theme-company {
    --dui-clr-primary: #2457a6;
    --dui-clr-accent: #e28b22;
    --dui-font-family: "Company Sans", sans-serif;
}
```

For Java users, a typed theme builder or token applier could cover simple variable-based themes
without requiring every user to implement `apply`, `cleanup`, and `isApplied` manually.

### Phase 5: strengthen embedded-app isolation

- Make a dedicated Domino UI root the recommended integration contract.
- Scope token declarations beneath the Domino UI root instead of `:root` where possible.
- Avoid body layout resets by default; provide an explicit full-application mode when needed.
- Keep feature-specific global assets such as WaitMe separate and opt-in.
- Document how body-level portals, dialogs, popovers, and overlays inherit themes.
- Consider a stronger root marker, such as a dedicated root class or data attribute, if `.dui`
  collisions become a practical concern.

### Phase 6: improve packaging and regression coverage

Consider publishing clearly separated entry points for:

- the complete Domino UI bundle;
- theme tokens only;
- light/dark mode layers;
- optional feature assets;
- optional fonts.

Add CSS/Java compatibility tests that verify:

- every built-in theme applies and cleans up its expected class;
- every accent maps to the correct palette;
- multiple element themes do not interfere;
- local theme roots do not alter unrelated host content;
- font and token overrides work inside a scoped root.

## Conclusion

Domino UI’s CSS token system is a good foundation for future theming work. The next improvements
should focus on making the Java lifecycle coherent, fixing per-element state management, formalizing
the token contract, and making the dedicated themed root the default embedded-application pattern.

The WaitMe stylesheet should remain treated as a separate ready-to-use feature asset rather than
being folded into the definition of Domino UI’s own styling and theming isolation guarantees.
