# Dynamic CSS utilities

Dynamic CSS utilities create a reusable Domino UI CSS utility at runtime. They are intended for a
value that is only known while the application is running, without requiring a new stylesheet or a
new application build.

The factories return an ordinary `CssClass`, so they work with every existing `addCss(...)` API:

```java
import static org.dominokit.domino.ui.utils.Domino.*;

div()
    .addCss(
        dui_p_("10px"),
        dui_gap_(Unit.rem.of(1)),
        dui_w_("calc(100% - 2rem)"));
```

Use Dynamic CSS for application-specific layout or presentation values. Continue using Domino UI's
static utility constants, such as `dui_p_4` and `dui_rounded_lg`, when a predefined semantic value
already expresses the intent.

## Lazy predefined value utilities

The existing Java constants for padding, margin, gap, text indent, font size, line height, border
width, width and height, flex basis, numeric flex grow/shrink/order, offsets, and z-index retain
their API and class names, but their matching rule is now created only when the constant is applied.
For example, `dui_p_4` still resolves to `dui-p-4` and produces:

```css
.dui.dui-p-4 {
  padding: var(--dui-spc-4);
}
```

This keeps density and theme overrides of `--dui-spc-4` intact, while avoiding delivery of every
predefined value utility to every production application. In production, resolving `dui_p_4` does
not create rules for `dui_m_4`, `dui_w_4`, or any other utility.

In Super Dev Mode, resolving any migrated Java utility constant preloads the complete migrated
utility set. This makes the full set available for browser experimentation while developing. The
preload is always disabled in production, where only utilities used by the application are
injected. No application setting is required.

The migration covers these Java constant families:

- padding and margin, including directional and axis variants;
- `gap`, `column-gap`, `row-gap`, and text-indent;
- font-size and line-height;
- border width, including directional and axis variants;
- width, height, min/max width, and min/max height;
- flex basis, plus numeric grow, shrink, and order values;
- inset, individual offsets, and z-index.

This is a Java API optimization, not a runtime parser for arbitrary class strings. If application
markup adds a migrated class such as `dui-p-4` as plain text, it must instead use the corresponding
Java constant/factory or provide its own CSS rule. The development-only class observer is a future
phase and is not included here.

## Dynamic color schemes

Dynamic color schemes use the same palette and contextual-color contract as Domino UI predefined
colors. A literal source creates five lighter shades, a base color, four darker shades, and a
foreground token for both light and dark color modes:

```java
Button.create("Save").addCss(dui_clr_("#EFEFAA"));
panel.addCss(dui_clr_schm_("#EFEFAA").lighten_2().getBackground());
```

`dui_clr_(...)` returns the ready-to-apply base `CssClass`. `dui_clr_schm_(...)` returns a scheme
that implements `ColorScheme`; every shade implements `Color`. Use
`getBackground()`, `getForeground()`, `getBorderColor()`, `getAccentColor()`, or
`getContextColor()` exactly as with predefined colors.

Applications can instead supply the palette and reference its root:

```java
panel.addCss(dui_clr_schm_("var(--dui-clr-app-brand)").getContextColor());
```

The reference convention requires `--dui-clr-app-brand-l-5` through `-l-1`, the base token,
`-d-1` through `-d-4`, and `--dui-app-brand-fg-clr`. References inject only utility wrappers;
the application owns all palette values and their light/dark overrides.

Color sources are deliberately not validated. Domino UI does not check syntax, token presence,
contrast, accessibility, or fit with the active identity, accent, or color-mode theme. Repeated
sources share one document-global generated palette for the document lifetime.

## What happens at runtime

The first request for a definition/value pair synchronously creates a shared rule in one
document-level stylesheet. For example:

```java
dui_p_("10px")
```

creates CSS equivalent to:

```css
body.dui {
  --dui-spc-10px: 10px;
}

.dui.dui-p-10px {
  padding: var(--dui-spc-10px);
}
```

A later request for the same utility and value returns the same class and does not add another rule.
The generated stylesheet remains for the document lifetime; rules are shared by all elements and
are not removed when an individual element is detached.

Generated variables are scoped to `body.dui`, and generated selectors use `.dui.dui-*`. This keeps
the feature within Domino UI's CSS isolation boundary: it does not write to `:root`, create global
unscoped selectors, or modify `DynamicStyleSheet`.

## Value forms

Every factory accepts a raw `String` and an `int`.

### Raw CSS strings

Pass any valid CSS value for the target property:

```java
dui_p_("12px");
dui_w_("min(42rem, 100%)");
dui_flex_basis_("18rem");
dui_font_size_("clamp(0.875rem, 1vw, 1.125rem)");
```

The value is passed to the browser unchanged. Dynamic CSS deliberately does not validate, escape,
or normalize it. Supplying an invalid value is a caller error, and values must never be built from
untrusted input.

### `Unit` values

`Unit` formats a number as a CSS string, so it can be passed directly to the string overload:

```java
dui_p_x_(Unit.rem.of(1.5));
dui_h_(Unit.px.of(40));
dui_top_(Unit.vh.of(10));
dui_border_(Unit.px.of(1));
```

### Integer values and Domino tokens

The `int` overload delegates exactly to the string form. Therefore:

```java
dui_p_(2)
```

is identical to:

```java
dui_p_("2")
```

This is most useful for an existing Domino spacing token. For example, `dui_p_(2)` reuses the
theme-controlled `--dui-spc-2` value when it is available.

An integer does **not** mean pixels and does not receive an implicit unit. If no compatible token
exists, `dui_p_(101)` injects `padding: 101`, which is invalid because CSS padding needs a unit.
Use a unit for an arbitrary length instead:

```java
dui_p_(Unit.px.of(101));
// or
dui_p_("101px");
```

Unitless integer values are appropriate for properties that accept them, including:

```java
dui_z_(100);
dui_grow_(2);
dui_shrink_(0);
dui_order_(3);
dui_font_weight_(600);
```

## Reusing Domino and application variables

Dynamic CSS first checks whether the requested class and variable already exist in an accessible
stylesheet. When they are compatible, it reuses them instead of injecting a duplicate. This keeps
existing theme and density overrides effective.

```java
dui_p_("10"); // reuses the existing dui-p-10 / --dui-spc-10 contract
dui_grow_(2);  // reuses the existing dui-grow-2 / --dui-grow-2 contract
```

Applications can also provide their own token using the matching variable prefix. The factory adds
only the missing utility rule:

```css
.workspace {
  --dui-spc-sidebar: 18rem;
}
```

```java
panel.addCss(dui_p_l_("sidebar"));
```

The result uses `padding-left: var(--dui-spc-sidebar)` and does not redeclare the variable. This
allows application CSS and themes to own the value while Dynamic CSS supplies the convenient class.

For application-owned tokens, use the prefix associated with the factory family:

| Factory families | Variable prefix | Example application token |
| --- | --- | --- |
| padding, margin, gap, sizing, indent, offsets, flex basis, border, radius, outline, font size, line height, letter spacing | `--dui-spc-` | `--dui-spc-sidebar: 18rem` |
| z-index | `--dui-z-` | `--dui-z-popover: 1200` |
| flex grow, shrink, order | `--dui-grow-`, `--dui-shrink-`, `--dui-order-` | `--dui-grow-sidebar: 0` |
| grid tracks | `--dui-grid-` | `--dui-grid-dashboard: repeat(3, minmax(0, 1fr))` |
| font weight | `--dui-font-weight-` | `--dui-font-weight-display: 600` |

For example, an application can define `--dui-z-popover` and use `dui_z_("popover")`, or define
`--dui-font-weight-display` and use `dui_font_weight_("display")`.

## CSS variable expressions

A value containing `var(` is already an expression, so Dynamic CSS injects only a utility rule and
does not create an intermediary custom property. Fallbacks and later theme changes remain live:

```java
panel.addCss(
    dui_p_("var(--dui-my-app-spc-5, var(--dui-my-app-default-spc))"));
```

This produces a deterministic hashed class similar to:

```css
.dui.dui-p-var-<stable-hash> {
  padding: var(--dui-my-app-spc-5, var(--dui-my-app-default-spc));
}
```

Use this form when the application already owns the variable name or when the desired fallback is
part of the value.

## Generated names and arbitrary expressions

Simple identifier-safe values create readable class names:

| Value | Example generated class |
| --- | --- |
| `10px` | `dui-p-10px` |
| `sidebar` | `dui-p-l-sidebar` |
| `100` | `dui-z-100` |

Values that cannot safely appear in a CSS class name, such as `calc(100% - 2rem)`, use a stable
hash-based suffix. The original value remains unchanged in the generated CSS:

```java
dui_w_("calc(100% - 2rem)");
// class similar to: dui-w-dyn-<stable-hash>
```

Do not rely on generated hash names in application code. Retain and reuse the `CssClass` returned
by the factory, or call the same factory/value pair again.

## Advanced: define an application utility family

The predefined factories are built on a public generic API. Application or extension authors can
define a family that follows the same scoped, deduplicated behavior:

```java
DynamicCssDefinition sectionOffset =
    DynamicCssDefinition.of("dui-app-section-offset", "dui-app-section-offset", "scroll-margin-top");

CssClass offset = DynamicCss.cssClass(sectionOffset, Unit.px.of(72));
section.addCss(offset);
```

This creates a class similar to `dui-app-section-offset-72px`, scoped with the same
`.dui.dui-*` selector rule. The definition contains:

| Argument | Meaning |
| --- | --- |
| class prefix | The generated class prefix, for example `dui-app-section-offset` |
| variable prefix | The generated custom-property prefix, for example `dui-app-section-offset` |
| CSS properties | One or more properties that consume the generated value |

Use a unique, application-owned prefix for custom definitions. If the definition intentionally
matches an existing Domino or application variable convention, the registry can reuse a compatible
rule; otherwise it creates a dedicated variable and utility class. The generic API has the same
trusted-raw-value requirement as the predefined factories.

## Factory reference

All factories below accept both `String` and `int`; `Unit` values can be passed to the `String`
overload because `Unit` formats to a string.

### Spacing and sizing

| CSS property or properties | Factories |
| --- | --- |
| `padding` | `dui_p_` |
| `padding-top`, `padding-right`, `padding-bottom`, `padding-left` | `dui_p_t_`, `dui_p_r_`, `dui_p_b_`, `dui_p_l_` |
| horizontal / vertical padding | `dui_p_x_`, `dui_p_y_` |
| `margin` | `dui_m_` |
| `margin-top`, `margin-right`, `margin-bottom`, `margin-left` | `dui_m_t_`, `dui_m_r_`, `dui_m_b_`, `dui_m_l_` |
| horizontal / vertical margin | `dui_m_x_`, `dui_m_y_` |
| `gap`, `column-gap`, `row-gap` | `dui_gap_`, `dui_gap_x_`, `dui_gap_y_` |
| `width`, `height` | `dui_w_`, `dui_h_` |
| minimum size | `dui_min_w_`, `dui_min_h_` |
| maximum size | `dui_max_w_`, `dui_max_h_` |
| `text-indent` | `dui_indent_` |

```java
Card.create("Profile")
    .addCss(dui_w_("min(100%, 42rem)"), dui_m_x_("auto"), dui_p_(4));
```

### Position and stacking

| CSS property or properties | Factories |
| --- | --- |
| all inset sides | `dui_inset_` |
| left/right or top/bottom | `dui_inset_x_`, `dui_inset_y_` |
| individual sides | `dui_top_`, `dui_right_`, `dui_bottom_`, `dui_left_` |
| `z-index` | `dui_z_` |

Position utilities set offsets only; they do not set `position`. Combine them with an appropriate
static position class such as `dui_fixed`, `dui_absolute`, or `dui_relative`.

```java
button.addCss(dui_fixed, dui_bottom_(Unit.px.of(24)), dui_right_(Unit.px.of(24)), dui_z_(100));
```

### Flex and grid

| CSS property | Factories |
| --- | --- |
| `flex-basis` | `dui_flex_basis_` |
| `flex-grow`, `flex-shrink`, `order` | `dui_grow_`, `dui_shrink_`, `dui_order_` |
| `grid-template-columns`, `grid-template-rows` | `dui_grid_cols_`, `dui_grid_rows_` |
| `grid-auto-columns`, `grid-auto-rows` | `dui_auto_cols_`, `dui_auto_rows_` |

Grid track factories receive the actual CSS track definition. They are different from static
semantic helpers such as `dui_grid_cols_3`:

```java
grid.addCss(
    dui_grid_cols_("repeat(auto-fit, minmax(18rem, 1fr))"),
    dui_gap_(4));
```

For a flex item:

```java
sidebar.addCss(dui_flex_basis_("18rem"), dui_shrink_(0));
content.addCss(dui_grow_(1), dui_min_w_(0));
```

### Borders, outlines, and radius

| CSS property or properties | Factories |
| --- | --- |
| `border-width` | `dui_border_` |
| horizontal / vertical border width | `dui_border_x_`, `dui_border_y_` |
| side border width | `dui_border_t_`, `dui_border_r_`, `dui_border_b_`, `dui_border_l_` |
| all corner radii | `dui_rounded_` |
| top, right, bottom, left radii | `dui_rounded_t_`, `dui_rounded_r_`, `dui_rounded_b_`, `dui_rounded_l_` |
| individual corner radius | `dui_rounded_tl_`, `dui_rounded_tr_`, `dui_rounded_br_`, `dui_rounded_bl_` |
| `outline-width`, `outline-offset` | `dui_outline_`, `dui_outline_offset_` |

Border-width utilities do not choose a border style or color. Combine them with Domino's static
border style/color classes or component/theme styling:

```java
panel.addCss(dui_border_(Unit.px.of(1)), dui_border_solid, dui_rounded_(Unit.px.of(10)));
```

### Typography metrics

| CSS property | Factories |
| --- | --- |
| `font-size` | `dui_font_size_` |
| `line-height` | `dui_leading_` |
| `letter-spacing` | `dui_tracking_` |
| `font-weight` | `dui_font_weight_` |

```java
heading.addCss(
    dui_font_size_("clamp(1.25rem, 2vw, 2rem)"),
    dui_leading_("1.15"),
    dui_tracking_("0.02em"),
    dui_font_weight_(600));
```

## Combining utilities

Dynamic CSS classes are ordinary classes. They can be combined with components, static utility
classes, contextual colors, and themes:

```java
Button.createPrimary("Save")
    .addCss(
        dui_min_w_("10rem"),
        dui_p_x_(5),
        dui_h_(Unit.px.of(36)),
        dui_font_weight_(600));
```

As with static utilities, avoid assigning conflicting declarations to the same element unless the
CSS cascade is intentional. A generated utility has the standard Domino `.dui.dui-*` specificity,
so normal source order and selector specificity rules still apply.

## Current scope and limitations

- Dynamic CSS currently covers the factories documented here. Dynamic colors, gradients, shadows,
  transforms, animations, and arbitrary component selectors are not part of this feature.
- There is no automatic class-attribute listener in the current release. Adding a text class such
  as `dui-p-10px` manually in external markup does **not** create its rule. Use the Java factory
  or provide the CSS yourself.
- Hash-based classes created for `calc(...)` or `var(...)` expressions are implementation details;
  use the factory rather than writing those names into markup.
- Each unique definition/value pair adds a cached document-level rule. Prefer shared Domino or
  application tokens when rendering a large number of distinct values.
- The browser owns final CSS validation. Invalid values can be ignored at computed-style time even
  though a class was generated successfully.

## Safety checklist

1. Prefer a static Domino utility when one already expresses the intended value.
2. Use an existing token or a `Unit` value for lengths.
3. Use `int` only for an existing token or a CSS property that accepts unitless numbers.
4. Pass only trusted CSS strings; never concatenate user input into a Dynamic CSS value.
5. Use `var(...)` when the application or a theme should control the final value.
