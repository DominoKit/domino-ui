# Domino UI Styling and Theming

This is the canonical guide to Domino UI styling. It explains how CSS is packaged and scoped, how
themes compose, how colors and component appearance work, and how to use Dynamic CSS when a layout
value is known only at runtime.

## Contents

- [Design principles](#design-principles)
- [Quick start](#quick-start)
- [CSS delivery and performance](#css-delivery-and-performance)
- [Theme composition](#theme-composition)
- [Colors, roles, and contextual palettes](#colors-roles-and-contextual-palettes)
- [Component appearance and typography](#component-appearance-and-typography)
- [Custom themes and isolated overrides](#custom-themes-and-isolated-overrides)
- [Dynamic CSS utilities](#dynamic-css-utilities)
- [Practical recipes](#practical-recipes)
- [Accessibility and contrast](#accessibility-and-contrast)
- [Troubleshooting](#troubleshooting)
- [Reference](#reference)

## Design principles

### Domino UI stays inside its root

Domino UI styles are deliberately scoped. Add the `dui` marker to the element that owns the
Domino UI subtree:

```html
<body class="dui dui-theme-default dui-colors-light">
  <div id="application"></div>
</body>
```

A theme root can be the document `body`, an application layout, or a smaller embedded subtree.
Domino UI uses selectors and custom properties within that boundary, so a host application's
unrelated content is not asked to adopt Domino UI colors, typography, or component rules.

This makes a useful distinction:

- A **global application** normally uses `body.dui`.
- An **embedded application** uses a nested `.dui` root and loads only the resources it needs.
- A **component subtree** can use a local theme without changing the surrounding application.

### Themes are layers, not one large switch

A visual result is composed from independent responsibilities:

1. the core/default component tokens;
2. a light or dark color mode;
3. an identity that changes dominant application surfaces;
4. an accent that controls interactive emphasis;
5. optional compact density;
6. optional character/material treatment;
7. zero or more independent surface treatments.

This arrangement is intentional. A designer can change the dominant personality from Ocean to
Forest without losing compact controls; a developer can add rounded corners without enabling
borders; and a product can retain its accent while trying different identities.

### Tokens are the customization boundary

Component CSS exposes custom properties such as `--dui-font-family`,
`--dui-card-background`, `--dui-btn-border-radius`, and
`--dui-form-field-wrapper-radius`. Prefer changing a documented component or shared token on a
scoped theme root over writing a long selector that depends on component internals.

This keeps custom CSS easier to discover, easier to compose, and more resilient when component
markup evolves.

## Quick start

### 1. Load stylesheets

Load the core stylesheet first. It contains component CSS, the default theme, light/dark modes,
theme-aware roles, font definitions, and the core color system.

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui.css">
```

For all optional themes, load the optional aggregate after the core stylesheet:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/domino-ui-themes.css">
```

### 2. Establish the scoped root

Use either markup or Java to make the application root a Domino UI root:

```html
<main class="dui dui-theme-default dui-colors-light">
  <!-- Domino UI components -->
</main>
```

### 3. Apply a composed theme in Java

Descriptors manage CSS classes; they do **not** load stylesheets. Load the corresponding CSS first,
then apply the descriptors:

```java
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeDefault;
import org.dominokit.domino.ui.themes.DominoThemeDensity;
import org.dominokit.domino.ui.themes.DominoThemeIdentity;
import org.dominokit.domino.ui.themes.DominoThemeLight;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.DominoThemeSurface;

DominoThemeManager.INSTANCE
    .apply(DominoThemeDefault.INSTANCE)
    .apply(DominoThemeLight.INSTANCE)
    .apply(DominoThemeIdentity.OCEAN)
    .apply(DominoThemeAccent.TEAL)
    .apply(DominoThemeDensity.COMPACT)
    .apply(DominoThemeSurface.ROUNDED);
```

The manager replaces an earlier theme only when both descriptors have the same category. Applying
a different identity replaces the active identity, but does not remove the accent, density, color
mode, or character style. Bordered, elevated, and rounded surfaces intentionally use separate
categories, so they can be combined.

## CSS delivery and performance

### Choose the right resource form

| Need | Recommended resource choice | Why |
| --- | --- | --- |
| Simplest application setup | `domino-ui.css` and `themes/domino-ui-themes.css` | Two stable, readable aggregate URLs. |
| One-request application setup | `domino-ui-css-all.css` or `domino-ui-css-all.min.css` | Includes the core, every optional theme, and modern font definitions in the established cascade order. |
| Development or source inspection | Individual readable CSS files | Easy browser inspection and focused loading. |
| Production application that uses a small subset | Individual `.min.css` files | Avoids downloading optional themes/components that are not used. |
| Third-party MDI assets | Their existing resource flow | They are not part of the new independent minification path. |
| Domino UI loaders | `domino-ui-waitme.css` or its `.min.css` sibling | Owned, scoped loader styles generated through the normal minification path. |

The aggregate URLs remain fully supported:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/domino-ui-themes.css">
```

They are deliberately preserved as readable bundles. Their `.min.css` siblings are also available
when an application wants the same two-bundle layout in production.

For a complete Domino UI installation in one stylesheet request, use the all-in-one aggregate. It
contains the core component bundle, every optional theme, and the modern font definitions in the
same order as the three separate links:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui-css-all.min.css">
```

Use `domino-ui-css-all.css` instead when readable CSS is preferred. These are additional resources;
the core, themes, fonts, and individual resource URLs remain available for applications that need
smaller or more selective delivery.

### Load only selected optional themes

An application that only uses Ocean, Glass, Compact, and Rounded can load those files instead of
the optional aggregate:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/identity/domino-ui-theme-ocean.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/character/domino-ui-theme-glass.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/density/domino-ui-theme-compact.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/surface/domino-ui-theme-rounded.css">
```

For production, choose the same paths with the `.min.css` suffix:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/dui-components/domino-ui-buttons.min.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/identity/domino-ui-theme-ocean.min.css">
```

Each independently minified resource keeps its directory and filename stem. The build creates a
minified sibling only for Domino-owned CSS eligible for this delivery option. Existing MDI files
are intentionally excluded; the owned `domino-ui-waitme.css` loader resource is included.

### Loader CSS is not a visual theme

`domino-ui-waitme.css` is the Domino UI-owned stylesheet used by the loader feature. It is not an
identity, character, density, or surface theme, and it remains outside the optional theme bundle.
Use its generated `domino-ui-waitme.min.css` sibling when loading individual production resources.

## Theme composition

### Core categories

| Category | CSS class examples | Java API | Responsibility |
| --- | --- | --- | --- |
| Main | `dui-theme-default` | `DominoThemeDefault.INSTANCE` | Base dimensions, typography, and component tokens. |
| Color mode | `dui-colors-light`, `dui-colors-dark` | `DominoThemeLight.INSTANCE`, `DominoThemeDark.INSTANCE` | Neutral surfaces and foregrounds. |
| Accent | `dui-accent-teal` | `DominoThemeAccent.TEAL` | Interactive accent scale. |
| Identity | `dui-theme-ocean` | `DominoThemeIdentity.OCEAN` | Dominant surfaces and application personality. |
| Density | `dui-theme-compact` | `DominoThemeDensity.COMPACT` | Spacing and control dimensions. |
| Character | `dui-theme-glass` | `DominoThemeCharacter.GLASS` | Material and visual character. |
| Surface | `dui-theme-bordered` | `DominoThemeSurface.BORDERED` | Borders, elevation, and corner treatment. |

### Density and surface choices

The default density comes from the core stylesheet. Compact reduces spacing and control dimensions
without changing the active identity, mode, character, or accent.

| Option | CSS class | Java descriptor | Effect |
| --- | --- | --- | --- |
| Compact | `dui-theme-compact` | `DominoThemeDensity.COMPACT` | More compact controls and spacing. |
| Default density | — | `DominoThemeDensity.DEFAULT` | Clears the compact density category. |
| Bordered | `dui-theme-bordered` | `DominoThemeSurface.BORDERED` | Adds theme-aware component boundaries. |
| Elevated | `dui-theme-elevated` | `DominoThemeSurface.ELEVATED` | Adds surface elevation where appropriate. |
| Rounded | `dui-theme-rounded` | `DominoThemeSurface.ROUNDED` | Applies the radius and clipping treatment. |

Surface clear descriptors remove only their own treatment:

```java
DominoThemeManager.INSTANCE
    .apply(DominoThemeSurface.CLEAR_BORDER)
    .apply(DominoThemeSurface.CLEAR_ELEVATION)
    .apply(DominoThemeSurface.CLEAR_RADIUS);
```

This means Bordered and Rounded can be active together:

```html
<main class="dui dui-theme-bordered dui-theme-rounded">
  <!-- Rounded components with borders -->
</main>
```

### Visual identities

Identities change dominant surfaces and the overall application palette while allowing accents to
remain independently selectable.

| Identity | Descriptor | Identity | Descriptor |
| --- | --- | --- | --- |
| Ocean | `DominoThemeIdentity.OCEAN` | Forest | `DominoThemeIdentity.FOREST` |
| Sandstone | `DominoThemeIdentity.SANDSTONE` | Graphite | `DominoThemeIdentity.GRAPHITE` |
| Lavender | `DominoThemeIdentity.LAVENDER` | Sunset | `DominoThemeIdentity.SUNSET` |
| Arctic | `DominoThemeIdentity.ARCTIC` | Rose | `DominoThemeIdentity.ROSE` |
| Crimson | `DominoThemeIdentity.CRIMSON` | Amethyst | `DominoThemeIdentity.AMETHYST` |
| Indigo | `DominoThemeIdentity.INDIGO` | Azure | `DominoThemeIdentity.AZURE` |
| Lagoon | `DominoThemeIdentity.LAGOON` | Jade | `DominoThemeIdentity.JADE` |
| Meadow | `DominoThemeIdentity.MEADOW` | Lime | `DominoThemeIdentity.LIME` |
| Marigold | `DominoThemeIdentity.MARIGOLD` | Amber | `DominoThemeIdentity.AMBER` |

Every identity has the CSS class `dui-theme-<name>`, for example
`dui-theme-ocean` and `dui-theme-forest`.

### Character styles

Character themes change material, typography, boundary, and component treatment. They do not
implicitly enable Bordered, Elevated, or Rounded: surface ownership stays with the surface themes.

| Character | Descriptor | Character | Descriptor |
| --- | --- | --- | --- |
| Carbon | `DominoThemeCharacter.CARBON` | Paper | `DominoThemeCharacter.PAPER` |
| Terminal | `DominoThemeCharacter.TERMINAL` | Glass | `DominoThemeCharacter.GLASS` |
| Blueprint | `DominoThemeCharacter.BLUEPRINT` | High Contrast | `DominoThemeCharacter.HIGH_CONTRAST` |
| Editorial | `DominoThemeCharacter.EDITORIAL` | Soft UI | `DominoThemeCharacter.SOFT_UI` |
| Neon Night | `DominoThemeCharacter.NEON_NIGHT` | Retro Console | `DominoThemeCharacter.RETRO_CONSOLE` |
| Aurora | `DominoThemeCharacter.AURORA` |  |  |

### Local instead of global themes

Use `ElementThemeManager` when a theme must stay inside one subtree:

```java
ElementThemeManager.INSTANCE.apply(DominoThemeIdentity.FOREST, isolatedRoot);
ElementThemeManager.INSTANCE.apply(DominoThemeSurface.BORDERED, isolatedRoot);
```

The manager tracks theme category per element. Replacing the local identity on `isolatedRoot`
does not clean up a theme applied to another element or the global application root.

### Listening for theme changes

The global and element-scoped managers can notify an application after a theme is applied or
removed. Each `ThemeChange` identifies the operation, affected category, and target (`document.body`
for global changes). It includes the previous and current theme in that category, plus read-only
snapshots of the **whole selection** before and after the operation, keyed by category.

```java
ThemeChangeListener listener = change -> {
    IsDominoTheme before = change.getPreviousTheme();
    IsDominoTheme after = change.getCurrentTheme();
    System.out.println(change.getScope() + " " + change.getOperation()
        + " on " + change.getTarget() + " in " + change.getCategory() + ": "
        + (before == null ? "none" : before.getName()) + " -> "
        + (after == null ? "none" : after.getName()));
};

DominoThemeManager.INSTANCE.addThemeChangeListener(listener);
ElementThemeManager.INSTANCE.addThemeChangeListener(listener);

// Remove both registrations when this observer is no longer needed.
DominoThemeManager.INSTANCE.removeThemeChangeListener(listener);
ElementThemeManager.INSTANCE.removeThemeChangeListener(listener);
```

For the current state when registering after startup, call `DominoThemeManager.INSTANCE.getThemes()`
or `ElementThemeManager.INSTANCE.getThemes(target)`. These also return read-only snapshots. Applying
persisted themes emits one event per applied theme; applying the same theme again emits an `APPLY`
event with equal before/after selections. Removing a theme that is not active emits nothing. A
surface clear descriptor, such as `CLEAR_BORDER`, remains in the selection snapshot even though it
adds no theme CSS class. Direct `IsDominoTheme.apply()`/`cleanup()` calls and the older `Theme`
change handler are separate from these manager notifications.

Listeners run synchronously after a manager operation completes. A listener may apply or remove
another theme; that notification is queued until all listeners have received the current event, so
events reach every listener in operation order. A theme's own `apply` or `cleanup` callback must not
directly apply or remove themes on the same manager state (or the same target in
`ElementThemeManager`). A persisted-theme restore requested during theme application is deferred
until the current operation completes; this supports Domino UI's lazy base-element initialization.

## Colors, roles, and contextual palettes

### Theme-aware roles

`dui_primary`, `dui_secondary`, and `dui_accent` are roles. Their scales are derived from
the selected identity and mode, so they remain visually related to the application rather than
being fixed colors.

```java
Button.create("Save").addCss(dui_primary);
Button.create("Continue").addCss(dui_secondary);
Button.create("New item").addCss(dui_accent);
```

Primary and secondary retain five light variants, a base value, and four dark variants. Explicit
accent descriptors provide the same scale and are harmonized with the active visual identity at
runtime. No build-time palette generation is needed.

### Contextual palettes

A palette class such as `dui_blue`, `dui_orange`, `dui_success`, `dui_warning`, or
`dui_error` provides a contextual color scale. It sets `--dui-context-color` and the
background/foreground scale consumed by components.

```java
Button.create("Archive").addCss(dui_blue);
Button.create("Complete").addCss(dui_success);
Alert.info("Saved").addCss(dui_info);
```

Use a role when the component should track the application's identity and accent. Use a palette
when the content has a semantic or intentional local color. Warning, info, success, and error keep
their semantic meaning; their foreground treatment adapts to preserve usability across modes.

### Harmony controls for custom identities

Identity themes anchor primary, secondary, and accent harmony through scoped variables. A custom
identity can tune the balance when needed:

```css
.dui.dui-theme-product.dui-colors-light {
  --dui-primary-harmony-anchor: #234f68;
  --dui-primary-harmony-strength: 55%;
  --dui-secondary-harmony-anchor: #5c7890;
  --dui-secondary-harmony-strength: 45%;
}
```

The default profiles use a lower accent-harmony strength than the primary role so an accent keeps
its recognizable color identity. Test a custom choice in both modes; Domino UI does not validate
application-supplied color contrast automatically.

## Component appearance and typography

### Font theming

Source Sans 3 is the default modern font direction. Override the family token on the scoped root
when an application needs another loaded webfont:

```css
.dui.dui-theme-product {
  --dui-font-family: "Inter", "Source Sans 3", sans-serif;
  --dui-font-family-heading: "Inter", "Source Sans 3", sans-serif;
}
```

Load a font from your application or a font provider before using it. A font declaration changes
text rendering; it does not by itself guarantee readable contrast or correct weights. Check labels,
small captions, disabled text, and headings in both color modes.

### Emphasis modifiers

Emphasis is a component-level appearance dimension:

| Modifier | Result |
| --- | --- |
| `dui-emphasis-filled` | Normal filled appearance; clears subtle/minimal in the same scope. |
| `dui-emphasis-subtle` | Translucent semantic background and semantic border. |
| `dui-emphasis-minimal` | Transparent background and semantic border. |

Apply an emphasis class directly or to a wrapper that owns supported children:

```html
<div class="dui dui-emphasis-subtle">
  <button class="dui dui-btn dui-primary">Save</button>
  <span class="dui dui-badge dui-info">New</span>
</div>

<div class="dui dui-card dui-emphasis-minimal">
  Minimal card
</div>
```

Buttons, badges, chips, alerts, infoboxes, progress bars, and cards support emphasis. Tabs, menus,
and submenus intentionally do not. Icons only use emphasis when the modifier is applied directly to
the icon; a parent emphasis scope does not restyle child icons accidentally.

### Icon appearance

Icons can use contextual colors and direct emphasis. Their appearance also supports square,
bordered, and subtle-background variants, with rounding supplied by the active surface theme:

```java
icon.addCss(dui_blue, dui_emphasis_subtle, dui_icon_square);
icon.addCss(dui_icon_bordered);
```

Keep icon-only interactive controls discoverable through accessible labels and visible focus
treatment. Do not rely on a color-only distinction for an action.

### Component surface improvements

Recent CSS work makes component surfaces theme-aware rather than tied to a fixed accent:

- form-field wrappers, placeholders, add-ons, switches, checkboxes, and select/search surfaces
  use mode- and identity-aware tokens;
- popovers, breadcrumbs, menus, trees, lists, thumbnails, media, and carousel surfaces respect
  surface/radius treatments;
- progress bars, alerts, contextual text, and focus states use foreground tokens intended to
  preserve contrast.

Use public component APIs and component tokens first. Deep selectors are appropriate only when a
component does not expose a suitable customization token.

## Custom themes and isolated overrides

Create one application-owned class and scope its overrides beneath `.dui`:

```css
.dui.dui-theme-product {
  --dui-font-family: "Source Sans 3", sans-serif;
  --dui-radius-md: 0.375rem;
  --dui-card-nested-background:
      color-mix(in srgb, var(--dui-card-background) 92%, var(--dui-clr-dominant-l-3) 8%);
}
```

Then compose it with built-in theme classes:

```html
<section class="dui dui-theme-product dui-colors-light dui-theme-ocean dui-theme-compact">
  <!-- Product-specific Domino UI -->
</section>
```

A custom theme should normally:

1. live in application CSS loaded after Domino UI resources;
2. target the same scoped root;
3. override tokens owned by the component or theme layer being adjusted;
4. use mode-specific selectors when a value needs different light/dark behavior;
5. test nested surfaces, disabled controls, focus, and contextual colors.

Avoid assigning a fixed foreground to a broad root. Let `--dui-color` and contextual foreground
tokens follow the active mode unless a component is known to use a filled local background.

## Dynamic CSS utilities

Dynamic CSS creates a reusable Domino UI utility when its value is available only at runtime. Every
factory returns a normal `CssClass`, so it works with every `addCss(...)` API.

```java
import static org.dominokit.domino.ui.utils.Domino.*;

div().addCss(
    dui_p_("10px"),
    dui_gap_(Unit.rem.of(1)),
    dui_w_("calc(100% - 2rem)"));
```

Prefer an existing static utility such as `dui_p_4` or `dui_rounded_lg` when it expresses the
intent. Use Dynamic CSS for application-specific values that should not require a new stylesheet
or a new build.

### What happens at runtime

The first request for a definition/value pair injects one shared document-level rule. For example,
`dui_p_("10px")` creates CSS equivalent to:

```css
body.dui {
  --dui-spc-10px: 10px;
}

.dui.dui-p-10px {
  padding: var(--dui-spc-10px);
}
```

A later identical request reuses the class and rule. Generated rules stay for the document lifetime
and are shared by all elements; detaching an element does not remove its shared rule.

Selectors remain `.dui.dui-*` and variables remain under `body.dui`. Dynamic CSS does not write
to `:root`, create unscoped selectors, or use the existing `DynamicStyleSheet` implementation.

### Lazy predefined utilities

Existing Java utility constants keep their public name and generated class name, but their rules are
created only when used. This includes padding, margin, gap, indent, font size, line height, border
width, width/height and min/max variants, flex basis/grow/shrink/order, offsets, and z-index.

```java
div().addCss(dui_p_4);
```

produces the same theme-aware contract:

```css
.dui.dui-p-4 {
  padding: var(--dui-spc-4);
}
```

In production, using `dui_p_4` does not inject unrelated utilities. In Super Dev Mode, the
migrated predefined set is preloaded to make browser experimentation convenient. The preload is
always off in production and requires no application setting.

Dynamic CSS is not an arbitrary class-attribute parser. Adding `dui-p-4` as plain external
markup does not create its rule; use the Java constant/factory or provide your own CSS.

### Values: strings, units, integers, and variables

Every factory accepts `String` and `int`. Pass raw trusted CSS strings unchanged:

```java
dui_p_("12px");
dui_w_("min(42rem, 100%)");
dui_flex_basis_("18rem");
dui_font_size_("clamp(0.875rem, 1vw, 1.125rem)");
```

`Unit` formats a value for the string overload:

```java
dui_p_x_(Unit.rem.of(1.5));
dui_h_(Unit.px.of(40));
dui_top_(Unit.vh.of(10));
dui_border_(Unit.px.of(1));
```

An integer is exactly the corresponding string, not an implicit pixel value:

```java
dui_p_(2);      // same as dui_p_("2"); reuses --dui-spc-2 when available
dui_z_(100);    // valid unitless z-index
dui_grow_(2);   // valid unitless flex-grow
dui_p_(101);    // invalid CSS padding unless a compatible token exists
dui_p_("101px");
```

A value containing `var(` is already a CSS expression, so Dynamic CSS injects only the utility
rule and does not create an intermediary variable:

```java
panel.addCss(dui_p_("var(--dui-my-app-spc-5, var(--dui-my-app-default-spc))"));
```

The class receives a deterministic hash-like suffix. Do not write that implementation-detail class
name in markup; retain the returned `CssClass` or call the same factory/value pair again.

### Reuse application and Domino tokens

Dynamic CSS reuses a compatible existing class/variable instead of injecting a duplicate:

```java
dui_p_("10");    // reuses dui-p-10 / --dui-spc-10 when available
dui_grow_(2);    // reuses dui-grow-2 / --dui-grow-2 when available
```

Applications can own a matching token and let Dynamic CSS create only the missing utility wrapper:

```css
.workspace {
  --dui-spc-sidebar: 18rem;
}
```

```java
panel.addCss(dui_p_l_("sidebar"));
```

| Family | Variable prefix |
| --- | --- |
| padding, margin, gap, sizing, indent, offsets, flex basis, borders, radius, outline, font metrics | `--dui-spc-` |
| z-index | `--dui-z-` |
| flex grow, shrink, order | `--dui-grow-`, `--dui-shrink-`, `--dui-order-` |
| grid tracks | `--dui-grid-` |
| font weight | `--dui-font-weight-` |

### Factory reference

| Need | Factories |
| --- | --- |
| padding | `dui_p_`, `dui_p_t_`, `dui_p_r_`, `dui_p_b_`, `dui_p_l_`, `dui_p_x_`, `dui_p_y_` |
| margin | `dui_m_`, directional and `dui_m_x_`/`dui_m_y_` variants |
| gap and indent | `dui_gap_`, `dui_gap_x_`, `dui_gap_y_`, `dui_indent_` |
| width and height | `dui_w_`, `dui_h_`, `dui_min_w_`, `dui_min_h_`, `dui_max_w_`, `dui_max_h_` |
| position and stacking | `dui_inset_`, `dui_inset_x_`, `dui_inset_y_`, `dui_top_`, `dui_right_`, `dui_bottom_`, `dui_left_`, `dui_z_` |
| flex and grid | `dui_flex_basis_`, `dui_grow_`, `dui_shrink_`, `dui_order_`, `dui_grid_cols_`, `dui_grid_rows_`, `dui_auto_cols_`, `dui_auto_rows_` |
| borders and radius | `dui_border_`, directional border variants, `dui_rounded_`, side/corner radius variants, `dui_outline_`, `dui_outline_offset_` |
| typography metrics | `dui_font_size_`, `dui_leading_`, `dui_tracking_`, `dui_font_weight_` |

Position factories only set offsets; combine them with a static position class:

```java
button.addCss(
    dui_fixed,
    dui_bottom_(Unit.px.of(24)),
    dui_right_(Unit.px.of(24)),
    dui_z_(100));
```

### Dynamic color schemes

Dynamic colors follow the predefined Domino palette contract. A literal creates five lighter
shades, a base, four darker shades, and foreground/context tokens for light and dark modes:

```java
Button.create("Save").addCss(dui_clr_("#EFEFAA"));
panel.addCss(dui_clr_schm_("#EFEFAA").lighten_2().getBackground());
```

`dui_clr_(...)` returns the ready-to-apply base `CssClass`. `dui_clr_schm_(...)` returns a
`ColorScheme`; use `getBackground()`, `getForeground()`, `getBorderColor()`,
`getAccentColor()`, or `getContextColor()` as with predefined colors.

For an application-owned palette, pass its root variable:

```java
panel.addCss(dui_clr_schm_("var(--dui-clr-app-brand)").getContextColor());
```

The application must provide `--dui-clr-app-brand-l-5` through `-l-1`, the base variable,
`-d-1` through `-d-4`, and `--dui-app-brand-fg-clr`, including mode overrides where needed.

Dynamic CSS deliberately does not validate color syntax, token presence, contrast, or fit with the
active identity. Use only trusted values and test the selected palette yourself.

### Defining an application utility family

Application/extension authors can build a dedicated family with the generic API:

```java
DynamicCssDefinition sectionOffset =
    DynamicCssDefinition.of(
        "dui-app-section-offset",
        "dui-app-section-offset",
        "scroll-margin-top");

CssClass offset = DynamicCss.cssClass(sectionOffset, Unit.px.of(72));
section.addCss(offset);
```

Choose a unique application-owned prefix. The generic definition receives a class prefix, variable
prefix, and one or more CSS properties. It follows the same scoped and deduplicated behavior as
built-in factories.

## Practical recipes

### Compact branded administration application

1. Load core CSS and only the selected theme resources.
2. Set a `.dui` application root.
3. Apply one mode, one identity, one accent, compact density, and the desired surface treatments.
4. Add an application token layer last.

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/identity/domino-ui-theme-ocean.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/density/domino-ui-theme-compact.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/surface/domino-ui-theme-bordered.css">
<link rel="stylesheet" href="/css/product-theme.css">
```

```java
DominoThemeManager.INSTANCE
    .apply(DominoThemeLight.INSTANCE)
    .apply(DominoThemeIdentity.OCEAN)
    .apply(DominoThemeAccent.COBALT)
    .apply(DominoThemeDensity.COMPACT)
    .apply(DominoThemeSurface.BORDERED);
```

Inspect the root in developer tools. You should see each category class and resolved custom
properties. If a visual change is missing, first verify the corresponding stylesheet was loaded.

### Production page with selective minified resources

Choose this when an application controls exactly which resources it needs:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/dui-components/domino-ui-buttons.min.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/dui-components/domino-ui-cards.min.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/identity/domino-ui-theme-ocean.min.css">
```

This is an advanced optimization path. Include every component dependency needed by the page and
load the core color/default resources required by those components. Prefer the aggregate core
stylesheet unless the application owns a complete, tested selected-resource manifest.

### Embedded Domino UI in a host page

Put the marker and theme classes on the embedded root, not the host page:

```html
<div class="host-shell">
  <section class="dui dui-colors-dark dui-theme-graphite dui-theme-rounded">
    <!-- Domino UI subtree -->
  </section>
</div>
```

Use `ElementThemeManager` when the subtree is created in Java. The host can keep its own fonts,
variables, and selectors outside the `.dui` boundary.

### Application token plus Dynamic CSS

Use a token for a value that should be theme/application controlled and Dynamic CSS for the
convenient property wrapper:

```css
.dui.dui-theme-product {
  --dui-spc-dashboard-sidebar: 18rem;
}
```

```java
sidebar.addCss(dui_flex_basis_("dashboard-sidebar"), dui_shrink_(0));
content.addCss(dui_grow_(1), dui_min_w_(0), dui_gap_(4));
```

Inspect the generated stylesheet in developer tools. Rules may appear in a runtime `<style>`
element; use the computed style panel to see the final variable value and cascade winner.

## Accessibility and contrast

Treat visual combinations as a test matrix, not as a single screenshot:

1. Check light and dark modes.
2. Check each identity/accent combination offered to users.
3. Check enabled, hover, focus, disabled, selected, read-only, and invalid states.
4. Check subtle/minimal emphasis independently from filled components.
5. Check placeholders, helper text, progress labels, and all component labels/content surfaces.
6. Keep visible focus treatment even when a theme minimizes elevation.
7. Do not communicate meaning only with color; pair semantic colors with labels, text, or icons.

For custom palette or Dynamic CSS colors, the browser accepts the value but cannot determine whether
it meets contrast requirements. That is an application design responsibility.

## Troubleshooting

| Symptom | Check first |
| --- | --- |
| A theme class has no effect | The optional stylesheet is loaded after core CSS and the target has `dui`. |
| A local theme changes the whole page | Apply it through `ElementThemeManager` or move the class to the intended subtree. |
| Colors look unlike the selected identity | Distinguish theme role classes from fixed contextual palettes. |
| A subtle component is hard to read | Check its contextual foreground and test the active mode/identity combination. |
| A Dynamic CSS class seems absent | Use the Java factory/constant; text classes alone are not parsed into rules. |
| Dynamic rule names are hard to read | Keep the returned `CssClass`; hashed names for expressions are implementation details. |
| An arbitrary length is ignored | Use `Unit` or a CSS unit string; an integer is not automatically pixels. |
| A selected minified file is missing | Run the Maven package build and verify the resource is eligible for independent minification. |
| Loader styling is missing | Load `domino-ui-waitme.css` (or its `.min.css` sibling) separately; it is not included through optional themes. |

## Reference

### Optional resource layout

```text
css/domino-ui/themes/
├── character/
├── density/
├── identity/
└── surface/
```

The complete optional aggregate is `themes/domino-ui-themes.css`. Individual files retain the
same relative paths in the WebJar under:

```text
META-INF/resources/webjars/domino-ui/css/domino-ui/
```

### Safe Dynamic CSS checklist

1. Prefer well-defined Domino UI component classes and static utility classes over arbitrary or
   dynamic CSS values/properties.
2. Use a Domino/application token when a theme should control the value.
3. Use `Unit` or a unit-bearing string for arbitrary lengths.
4. Use integers only for existing tokens or unitless CSS properties.
5. Pass only trusted CSS values; never concatenate untrusted input.
6. Use `var(...)` for application-owned variables and live fallbacks.
7. Avoid creating a unique generated value for every row/item in a large rendered collection.
