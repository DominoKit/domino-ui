# Domino UI Theming

Domino UI styling is built from composable layers. Applications can combine a color mode, accent,
visual identity, character style, density, surface treatments, and component-level appearance
modifiers without changing the component markup.

## Stylesheet loading

Load the core stylesheet first:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/domino-ui.css">
```

The core stylesheet contains component styles and the built-in default, light/dark, primary,
secondary, and accent color-role support. Optional themes are packaged separately in the
`domino-ui-themes.css` aggregate:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/domino-ui-themes.css">
```

Applications can load only the files they use:

```html
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/identity/domino-ui-theme-ocean.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/character/domino-ui-theme-glass.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/density/domino-ui-theme-compact.css">
<link rel="stylesheet" href="/webjars/domino-ui/css/domino-ui/themes/surface/domino-ui-theme-rounded.css">
```

Load the core stylesheet before the optional files, and load each selected stylesheet only once.
The optional resources are available from the `domino-ui-webjar` under:

```text
META-INF/resources/webjars/domino-ui/css/domino-ui/themes/
```

## Applying themes

Theme classes are scoped to a Domino UI root. The root must have the `dui` marker:

```html
<section class="dui dui-colors-light dui-theme-ocean dui-theme-glass dui-theme-compact dui-theme-rounded">
    <!-- Domino UI components -->
</section>
```

This scope allows Domino UI to be embedded in an existing application without requiring the host
application to adopt Domino UI’s colors or styles globally. A theme root can be the document body,
an application layout, or a smaller component subtree.

The class-based approach can be used directly from HTML/CSS. Java applications can use the
descriptor constants described below; the descriptors manage CSS classes but do not load CSS files.
The application is responsible for loading the core stylesheet and the optional theme files.

## Built-in core themes

The core stylesheet provides these categories:

| Category | Examples | Behavior |
| --- | --- | --- |
| Main theme | `dui-theme-default` | Component dimensions, typography, and base tokens. |
| Color mode | `dui-colors-light`, `dui-colors-dark` | Light or dark neutral surfaces and foreground colors. |
| Color roles | `dui-primary`, `dui-secondary`, `dui-accent` | Theme-aware application roles with lighter/darker scales. |
| Accent | `dui-accent-blue`, `dui-accent-teal`, `dui-accent-purple` | The application accent and its lighter/darker scale. |

Additional composable accents are available for identity-aligned palettes:

| Accent | CSS class | Java descriptor | Good identity pairings |
| --- | --- | --- | --- |
| Coral | `dui-accent-coral` | `DominoThemeAccent.CORAL` | Rose, Sunset, Sandstone |
| Emerald | `dui-accent-emerald` | `DominoThemeAccent.EMERALD` | Forest, Jade, Meadow |
| Cobalt | `dui-accent-cobalt` | `DominoThemeAccent.COBALT` | Ocean, Azure, Indigo |
| Plum | `dui-accent-plum` | `DominoThemeAccent.PLUM` | Lavender, Amethyst, Graphite |

The accent system retains five lighter options, the base accent, and four darker options. Accent
values are harmonized at runtime with the selected visual identity so the accent keeps its original
identity while fitting the application’s overall palette. No build-time color generation is
required.

### Theme-aware color roles

Primary and secondary roles are also harmonized with the selected visual identity. Their resolved
scales continue to use the existing `--dui-clr-primary-*` and `--dui-clr-secondary-*` variables,
including five lighter values, the base value, and four darker values. Identity themes use their
own color scales as strong runtime anchors, so switching identity produces an obvious related
primary and secondary family in both color modes. The fixed color-mode fallback palettes are
available as `--dui-palette-primary-*` and `--dui-palette-secondary-*` source tokens.

Identity themes provide these runtime controls:

```css
.dui.dui-theme-example.dui-colors-light {
    --dui-primary-harmony-anchor: #234f68;
    --dui-primary-harmony-strength: 55%;
    --dui-secondary-harmony-anchor: #5c7890;
    --dui-secondary-harmony-strength: 45%;
}
```

For dark mode, identity themes anchor the roles to the darker end of their identity scale. The
default identity profiles use 55% for primary, 45% for secondary, and 18% for accent harmony;
custom themes can tune these scoped strengths when they need a different balance.

Explicit accent choices remain composable and continue to override the accent source before identity
harmony is applied. Warning, info, and error remain stable semantic palettes in the current
implementation; only their mode-aware foreground and component-specific contrast treatment varies.

## Optional theme catalog

The optional themes are grouped by responsibility. A theme from each replacement category can be
active at the same time. Surface themes are independent and can all be combined.

### Density

| Name | CSS class | Java descriptor |
| --- | --- | --- |
| Compact | `dui-theme-compact` | `DominoThemeDensity.COMPACT` |

The compact theme reduces spacing and control dimensions while retaining the selected identity,
character, color mode, and accent.

### Surface

| Name | CSS class | Java descriptor | Responsibility |
| --- | --- | --- | --- |
| Bordered | `dui-theme-bordered` | `DominoThemeSurface.BORDERED` | Adds component boundary borders. |
| Elevated | `dui-theme-elevated` | `DominoThemeSurface.ELEVATED` | Uses elevation instead of component borders where appropriate. |
| Rounded | `dui-theme-rounded` | `DominoThemeSurface.ROUNDED` | Applies the rounded-corner and clipping treatment. |

These are independent categories. For example, an application can use both:

```html
<main class="dui dui-theme-bordered dui-theme-rounded">
    <!-- Bordered and rounded components -->
</main>
```

The clear descriptors remove only their own surface treatment:

```java
DominoThemeSurface.CLEAR_BORDER;
DominoThemeSurface.CLEAR_ELEVATION;
DominoThemeSurface.CLEAR_RADIUS;
```

### Visual identities

Identity themes change the dominant surfaces, neutral palette, and overall application color
personality while keeping accents composable.

| Name | CSS class | Java descriptor |
| --- | --- | --- |
| Ocean | `dui-theme-ocean` | `DominoThemeIdentity.OCEAN` |
| Forest | `dui-theme-forest` | `DominoThemeIdentity.FOREST` |
| Sandstone | `dui-theme-sandstone` | `DominoThemeIdentity.SANDSTONE` |
| Graphite | `dui-theme-graphite` | `DominoThemeIdentity.GRAPHITE` |
| Lavender | `dui-theme-lavender` | `DominoThemeIdentity.LAVENDER` |
| Sunset | `dui-theme-sunset` | `DominoThemeIdentity.SUNSET` |
| Arctic | `dui-theme-arctic` | `DominoThemeIdentity.ARCTIC` |
| Rose | `dui-theme-rose` | `DominoThemeIdentity.ROSE` |
| Crimson | `dui-theme-crimson` | `DominoThemeIdentity.CRIMSON` |
| Amethyst | `dui-theme-amethyst` | `DominoThemeIdentity.AMETHYST` |
| Indigo | `dui-theme-indigo` | `DominoThemeIdentity.INDIGO` |
| Azure | `dui-theme-azure` | `DominoThemeIdentity.AZURE` |
| Lagoon | `dui-theme-lagoon` | `DominoThemeIdentity.LAGOON` |
| Jade | `dui-theme-jade` | `DominoThemeIdentity.JADE` |
| Meadow | `dui-theme-meadow` | `DominoThemeIdentity.MEADOW` |
| Lime | `dui-theme-lime` | `DominoThemeIdentity.LIME` |
| Marigold | `dui-theme-marigold` | `DominoThemeIdentity.MARIGOLD` |
| Amber | `dui-theme-amber` | `DominoThemeIdentity.AMBER` |

### Character styles

Character themes change the material, typography, boundary, and component treatment while preserving
the selected identity, color mode, and accent.

| Name | CSS class | Java descriptor |
| --- | --- | --- |
| Carbon | `dui-theme-carbon` | `DominoThemeCharacter.CARBON` |
| Paper | `dui-theme-paper` | `DominoThemeCharacter.PAPER` |
| Terminal | `dui-theme-terminal` | `DominoThemeCharacter.TERMINAL` |
| Glass | `dui-theme-glass` | `DominoThemeCharacter.GLASS` |
| Blueprint | `dui-theme-blueprint` | `DominoThemeCharacter.BLUEPRINT` |
| High Contrast | `dui-theme-high-contrast` | `DominoThemeCharacter.HIGH_CONTRAST` |
| Editorial | `dui-theme-editorial` | `DominoThemeCharacter.EDITORIAL` |
| Soft UI | `dui-theme-soft-ui` | `DominoThemeCharacter.SOFT_UI` |
| Neon Night | `dui-theme-neon-night` | `DominoThemeCharacter.NEON_NIGHT` |
| Retro Console | `dui-theme-retro-console` | `DominoThemeCharacter.RETRO_CONSOLE` |
| Aurora | `dui-theme-aurora` | `DominoThemeCharacter.AURORA` |

Character themes provide their own visual personality; they do not automatically enable the
bordered surface theme. This keeps border ownership with `dui-theme-bordered` and allows character
styles to be combined with bordered, elevated, or rounded independently.

## Java API and composition

The built-in descriptors are available in `org.dominokit.domino.ui.themes`:

```java
import org.dominokit.domino.ui.themes.DominoThemeCharacter;
import org.dominokit.domino.ui.themes.DominoThemeDensity;
import org.dominokit.domino.ui.themes.DominoThemeAccent;
import org.dominokit.domino.ui.themes.DominoThemeIdentity;
import org.dominokit.domino.ui.themes.DominoThemeManager;
import org.dominokit.domino.ui.themes.DominoThemeSurface;

DominoThemeManager themes = DominoThemeManager.INSTANCE;
themes.apply(DominoThemeIdentity.OCEAN);
themes.apply(DominoThemeAccent.COBALT);
themes.apply(DominoThemeCharacter.GLASS);
themes.apply(DominoThemeDensity.COMPACT);
themes.apply(DominoThemeSurface.ROUNDED);
```

`DominoThemeManager` applies themes to the global Domino UI root. For an isolated subtree, use
`ElementThemeManager`:

```java
ElementThemeManager.INSTANCE.apply(DominoThemeIdentity.FOREST, isolatedRoot);
ElementThemeManager.INSTANCE.apply(DominoThemeSurface.BORDERED, isolatedRoot);
```

Identity, character, and density themes replace the currently active theme in their category.
Applying a new identity does not remove the character, density, accent, or color-mode classes.
Bordered, elevated, and rounded have separate categories, so applying one does not remove either
of the others.

The default/clear descriptors are:

```java
DominoThemeDensity.DEFAULT;
DominoThemeSurface.CLEAR_BORDER;
DominoThemeSurface.CLEAR_ELEVATION;
DominoThemeSurface.CLEAR_RADIUS;
```

Each clear descriptor removes only its category’s active class or surface treatment.

## Emphasis modifiers

Appearance modifiers provide a second, component-level styling dimension:

| Modifier | Meaning |
| --- | --- |
| `dui-emphasis-filled` | The normal filled appearance; also clears subtle/minimal emphasis on a scope. |
| `dui-emphasis-subtle` | Keeps the semantic color as a translucent background and adds a semantic border. |
| `dui-emphasis-minimal` | Uses a transparent background and a semantic border. |

Modifiers can be applied to one component or to a wrapper containing several supported components:

```html
<div class="dui dui-emphasis-subtle">
    <button class="dui dui-btn dui-primary">Subtle button</button>
    <span class="dui dui-badge dui-info">Subtle badge</span>
</div>

<div class="dui dui-card dui-emphasis-minimal">
    Minimal card
</div>
```

The modifiers currently support buttons, badges, chips, alerts, infoboxes, progress bars, and
cards. Tabs and menus intentionally do not participate in the emphasis system.

## Contrast and customization guidance

Light and dark modes provide separate semantic foreground tokens for the neutral and contextual
surfaces. Custom identities and character themes should preserve that relationship instead of
using a fixed foreground color for every mode.

In particular:

- Use `--dui-color` for text placed on a light or transparent surface.
- Use the contextual foreground token for text on a fully filled semantic background.
- Keep borders and focus indicators visibly distinct from their surrounding surface.
- Test accent combinations, especially yellow, amber, orange, lime, and light-green, in light mode.
- Check subtle/minimal modifiers because their backgrounds are intentionally lighter or transparent.
- Keep nested card surfaces distinguishable without creating a strong color jump.

Domino UI’s theme CSS uses custom properties so application themes can override tokens at the
appropriate scoped root. Prefer overriding a component token in a custom theme over adding a long,
component-specific selector.

## WaitMe and animation styles

`domino-ui-waitMe.css` is not a Domino UI visual theme. It is a third-party, ready-to-use animation
stylesheet imported for the Animation feature. It remains part of the existing animation resource
flow and is intentionally not included in the optional visual-theme bundle.

## Resource layout

The optional source files are organized as follows:

```text
domino-ui/src/main/resources/org/dominokit/domino/ui/public/css/domino-ui/themes/
├── density/
├── surface/
├── identity/
└── character/
```

The complete optional bundle is generated as `themes/domino-ui-themes.css`. Individual files remain
available so applications can choose between convenience and a smaller CSS payload.
