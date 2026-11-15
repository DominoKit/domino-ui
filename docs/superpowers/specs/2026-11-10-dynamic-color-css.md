# Dynamic injection for built-in color utilities

## Intent

Reduce the CSS payload for Domino UI applications while preserving the existing built-in color
palette, shades, class names, and Java `ColorsCss`/`Color` APIs. Applications should receive utility
rules through Domino UI's runtime CSSOM injection when a color `CssClass` is resolved.

## Goals

- Lazily inject only the built-in color utility rules used by an application.
- Preserve the declarations and cascade behavior of existing color utilities, including foreground,
  background, accent, border, context, shadow, outline, divide, and text-decoration rules.
- Keep light/dark palette variable definitions available in the normal CSS bundles.
- Exclude the large static utility matrix from the default aggregate CSS bundles.

## Non-goals

- Adding custom/arbitrary color values.
- Renaming or removing public Java color constants, class tokens, or palette shades.
- Changing the existing `DynamicColor` API for custom runtime palettes.

## Compatibility

Existing Java API use resolves a `CssClass` and can trigger injection. Directly writing a color class
name in HTML/CSS does not invoke Java, so CSS-only color class usage is unsupported while the static
utility stylesheet is removed. The current class names and Java `ColorsCss`/`Color` APIs remain.

## Approach

Use the existing `DynamicCss` lazy class resolution and CSSOM registry. Extend its static utility
resolver with the built-in color class patterns and their declaration recipes. When a color class is
resolved, inject its family shade-variable mappings and its exact utility declarations into the
document stylesheet, with repeated requests reusing the same CSSOM rules. Keep palette color values
in the existing light/dark CSS resources. Exclude the full color utility CSS from the default
`domino-ui.css` and `domino-ui-css-all.css` aggregates. Keep the shared context helpers and runtime
accent/primary/secondary harmonization rules in the generic component stylesheet.

## Constraints and risks

- Runtime rules must match the current static CSS declarations and selector specificity closely
  enough to preserve component states and theme behavior.
- Rule creation must be idempotent, including when several shades from one color family are used.
- Development preloading of spacing/sizing utilities must not eagerly preload every color rule.
- Consumers relying on raw HTML class names will not receive color utility rules without runtime Java
  class resolution.
