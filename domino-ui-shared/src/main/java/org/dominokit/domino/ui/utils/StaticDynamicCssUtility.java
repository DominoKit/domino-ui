/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.utils;

import java.util.LinkedHashMap;
import java.util.Map;
import org.dominokit.domino.ui.style.CssClass;

/** Resolves migrated static utility names to lazy dynamic CSS rules. */
final class StaticDynamicCssUtility {

  private static final String[] SPACING_TOKENS = {
    "0", "0_5", "1", "10", "11", "12", "14", "16", "1_2p", "1_3p", "1_4p", "1_5", "2", "20", "24",
    "28", "2_3p", "2_5", "2px", "3", "32", "36", "3_4p", "3_5", "4", "40", "44", "48", "4px", "5",
    "52", "56", "6", "60", "64", "7", "72", "8", "80", "8px", "9", "96", "full", "px"
  };

  private static final String[] POSITION_TOKENS = {
    "0_5", "1", "10", "11", "12", "14", "16", "1_2p", "1_3p", "1_4p", "1_5", "2", "20", "24", "28",
    "2_3p", "2_5", "2px", "3", "32", "36", "3_4p", "3_5", "4", "40", "44", "48", "4px", "5", "52",
    "56", "6", "60", "64", "7", "72", "8", "80", "8px", "9", "96", "full", "px"
  };

  private static final String[] BORDER_TOKENS = {
    "0", "0_5", "1", "10", "11", "12", "14", "16", "1_5", "2", "20", "24", "28", "2_5", "2px", "3",
    "32", "36", "3_5", "4", "40", "44", "48", "4px", "5", "52", "56", "6", "60", "64", "7", "72",
    "8", "80", "8px", "9", "96", "9999px"
  };

  private static final String[] OUTLINE_OFFSET_TOKENS = {"0", "1", "2", "4", "8"};

  private static final String[] OPACITY_TOKENS = {
    "0", "5", "10", "20", "25", "30", "40", "50", "60", "70", "75", "80", "90", "95", "100"
  };

  private static final String[] GRID_COLUMNS_TOKENS = {
    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "none"
  };

  private static final String[] GRID_ROWS_TOKENS = {"1", "2", "3", "4", "5", "6", "none"};

  private static final String[] GRID_SPAN_TOKENS = {
    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "full"
  };

  private static final String[] GRID_COLUMN_POSITION_TOKENS = {
    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "auto"
  };

  private static final String[] GRID_ROW_POSITION_TOKENS = {
    "1", "2", "3", "4", "5", "6", "7", "auto"
  };

  private static final String[] GRID_FLOW_TOKENS = {"row", "col", "row-dense", "col-dense"};

  private static final String[] GRID_AUTO_TOKENS = {"auto", "min", "max", "fr"};

  private static final String[] RADIUS_TOKENS = {
    "none", "inherit", "sm", "1", "md", "lg", "xl", "2xl", "3xl", "full", "circle"
  };

  private static final String[] DIVIDE_TOKENS = {"0", "2", "4", "8"};

  private static final String[] OVERFLOW_TOKENS = {"auto", "hidden", "clip", "visible", "scroll"};

  private static final String[] OVERSCROLL_TOKENS = {"auto", "contain", "none"};

  private static final String[] UNDERLINE_OFFSET_TOKENS = {"auto", "0", "1", "2", "4", "8"};

  private static final DynamicCssDefinition OPACITY =
      DynamicCssDefinition.of("dui-opacity", "dui-opacity", "opacity");

  private static final DynamicCssDefinition UNDERLINE_OFFSET =
      DynamicCssDefinition.of("dui-underline-offset", "dui-spc", "text-underline-offset");

  private static final DynamicCssDefinition COLUMN_SPAN =
      directDefinition("dui-col-span", "grid-column");

  private static final DynamicCssDefinition COLUMN_START =
      directDefinition("dui-col-start", "grid-column-start");

  private static final DynamicCssDefinition COLUMN_END =
      directDefinition("dui-col-end", "grid-column-end");

  private static final DynamicCssDefinition ROW_SPAN = directDefinition("dui-row-span", "grid-row");

  private static final DynamicCssDefinition ROW_START =
      directDefinition("dui-row-start", "grid-row-start");

  private static final DynamicCssDefinition ROW_END =
      directDefinition("dui-row-end", "grid-row-end");

  private static final DynamicCssDefinition GRID_FLOW =
      directDefinition("dui-grid-flow", "grid-auto-flow");

  private static final String[] FLEX_SCALE_TOKENS = {
    "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"
  };

  private static final String[] ORDER_TOKENS = {
    "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "20", "30", "40", "50", "60", "70", "80",
    "90", "100"
  };

  private static final String[] LEADING_TOKENS = {
    "3", "4", "5", "6", "7", "8", "9", "10", "none", "tight", "snug", "normal", "relaxed", "loose"
  };

  private static final String[] COLOR_NAMES = {
    "accent",
    "amber",
    "black",
    "blue",
    "blue-grey",
    "brown",
    "cobalt",
    "coral",
    "cyan",
    "deep-orange",
    "deep-purple",
    "dominant",
    "emerald",
    "error",
    "green",
    "grey",
    "indigo",
    "info",
    "light-blue",
    "light-green",
    "lime",
    "orange",
    "pink",
    "plum",
    "primary",
    "purple",
    "red",
    "secondary",
    "success",
    "teal",
    "warning",
    "white",
    "yellow"
  };

  private static final String[] COLOR_SHADES = {
    "l-5", "l-4", "l-3", "l-2", "l-1", "", "d-1", "d-2", "d-3", "d-4"
  };

  private static final String[] COLOR_SPECIAL_VALUES = {"current", "inherit", "transparent"};

  private static final DynamicCssDefinition TEXT_INDENT =
      DynamicCssDefinition.of("dui-txt-indnt", "dui-spc", "text-indent");

  private static final Utility[] UTILITIES = {
    opacity("dui-opacity", OPACITY),
    radius("dui-rounded-tl", DynamicRadius.TOP_LEFT),
    radius("dui-rounded-tr", DynamicRadius.TOP_RIGHT),
    radius("dui-rounded-br", DynamicRadius.BOTTOM_RIGHT),
    radius("dui-rounded-bl", DynamicRadius.BOTTOM_LEFT),
    radius("dui-rounded-t", DynamicRadius.TOP),
    radius("dui-rounded-r", DynamicRadius.RIGHT),
    radius("dui-rounded-b", DynamicRadius.BOTTOM),
    radius("dui-rounded-l", DynamicRadius.LEFT),
    radius("dui-rounded", DynamicRadius.RADIUS),
    grid("dui-grid-cols", DynamicGrid.COLUMNS, ValueType.GRID_TEMPLATE, GRID_COLUMNS_TOKENS),
    grid("dui-grid-rows", DynamicGrid.ROWS, ValueType.GRID_TEMPLATE, GRID_ROWS_TOKENS),
    grid("dui-auto-cols", DynamicGrid.AUTO_COLUMNS, ValueType.GRID_AUTO, GRID_AUTO_TOKENS),
    grid("dui-auto-rows", DynamicGrid.AUTO_ROWS, ValueType.GRID_AUTO, GRID_AUTO_TOKENS),
    utility("dui-col-span", COLUMN_SPAN, ValueType.GRID_SPAN),
    utility("dui-col-start", COLUMN_START, ValueType.GRID_POSITION),
    utility("dui-col-end", COLUMN_END, ValueType.GRID_POSITION),
    utility("dui-row-span", ROW_SPAN, ValueType.GRID_SPAN),
    utility("dui-row-start", ROW_START, ValueType.GRID_POSITION),
    utility("dui-row-end", ROW_END, ValueType.GRID_POSITION),
    grid("dui-grid-flow", GRID_FLOW, ValueType.GRID_FLOW, GRID_FLOW_TOKENS),
    pixelSpacing("dui-underline-offset", UNDERLINE_OFFSET),
    outlineWidth("dui-outline", DynamicOutline.WIDTH),
    spacing("dui-p-x", DynamicPadding.X),
    spacing("dui-p-y", DynamicPadding.Y),
    spacing("dui-p-t", DynamicPadding.TOP),
    spacing("dui-p-r", DynamicPadding.RIGHT),
    spacing("dui-p-b", DynamicPadding.BOTTOM),
    spacing("dui-p-l", DynamicPadding.LEFT),
    spacing("dui-p", DynamicPadding.PADDING),
    spacing("dui-m-x", DynamicMargin.X),
    spacing("dui-m-y", DynamicMargin.Y),
    spacing("dui-m-t", DynamicMargin.TOP),
    spacing("dui-m-r", DynamicMargin.RIGHT),
    spacing("dui-m-b", DynamicMargin.BOTTOM),
    spacing("dui-m-l", DynamicMargin.LEFT),
    spacing("dui-m", DynamicMargin.MARGIN),
    spacing("dui-gap-x", DynamicGap.X),
    spacing("dui-gap-y", DynamicGap.Y),
    spacing("dui-gap", DynamicGap.GAP),
    spacing("dui-txt-indnt", TEXT_INDENT),
    spacing("dui-font-size", DynamicTypography.FONT_SIZE),
    leading("dui-leading", DynamicTypography.LINE_HEIGHT),
    outlineOffset("dui-outline-offset", DynamicOutline.OFFSET),
    sizing("dui-min-w", DynamicSizing.MIN_WIDTH),
    sizing("dui-max-w", DynamicSizing.MAX_WIDTH),
    sizing("dui-min-h", DynamicSizing.MIN_HEIGHT),
    sizing("dui-max-h", DynamicSizing.MAX_HEIGHT),
    sizing("dui-w", DynamicSizing.WIDTH),
    sizing("dui-h", DynamicSizing.HEIGHT),
    spacing("dui-basis", DynamicFlex.BASIS),
    border("dui-border-x", DynamicBorder.X),
    border("dui-border-y", DynamicBorder.Y),
    border("dui-border-t", DynamicBorder.TOP),
    border("dui-border-r", DynamicBorder.RIGHT),
    border("dui-border-b", DynamicBorder.BOTTOM),
    border("dui-border-l", DynamicBorder.LEFT),
    border("dui-border", DynamicBorder.BORDER),
    cssVariable("dui-grow", DynamicFlex.GROW),
    cssVariable("dui-shrink", DynamicFlex.SHRINK),
    cssVariable("dui-order", DynamicFlex.ORDER),
    spacing("dui-inset-x", DynamicPosition.X),
    spacing("dui-inset-y", DynamicPosition.Y),
    spacing("dui-inset", DynamicPosition.INSET),
    spacing("dui-top", DynamicPosition.TOP),
    spacing("dui-right", DynamicPosition.RIGHT),
    spacing("dui-bottom", DynamicPosition.BOTTOM),
    spacing("dui-left", DynamicPosition.LEFT),
    direct("dui-z", DynamicPosition.Z_INDEX)
  };

  private StaticDynamicCssUtility() {}

  static CssClass resolve(DynamicCssRegistry registry, String staticClassName) {
    CssClass directUtility = resolveDirectUtility(registry, staticClassName);
    if (directUtility != null) {
      return directUtility;
    }
    CssClass radiusUtility = resolveRadiusUtility(registry, staticClassName);
    if (radiusUtility != null) {
      return radiusUtility;
    }
    CssClass spaceUtility = resolveSpaceUtility(registry, staticClassName);
    if (spaceUtility != null) {
      return spaceUtility;
    }
    CssClass divideUtility = resolveDivideUtility(registry, staticClassName);
    if (divideUtility != null) {
      return divideUtility;
    }
    ColorUtility colorUtility = ColorUtility.fromClassName(staticClassName);
    if (colorUtility != null) {
      return new LazyDynamicCssClass(
          () -> {
            colorUtility.inject(registry);
            return () -> staticClassName;
          });
    }
    for (Utility utility : UTILITIES) {
      String token = utility.token(staticClassName);
      if (token != null) {
        return registry.lazyCssClass(utility.definition, token, utility.cssValue(token));
      }
    }
    return () -> staticClassName;
  }

  private static CssClass resolveDirectUtility(
      DynamicCssRegistry registry, String staticClassName) {
    String[] prefixes = {
      "dui-overflow-x", "dui-overflow-y", "dui-overflow",
      "dui-overscroll-x", "dui-overscroll-y", "dui-overscroll",
      "dui-col-auto", "dui-row-auto"
    };
    String[] properties = {
      "overflow-x", "overflow-y", "overflow",
      "overscroll-behavior-x", "overscroll-behavior-y", "overscroll-behavior",
      "grid-column", "grid-row"
    };
    for (int index = 0; index < prefixes.length; index++) {
      String prefix = prefixes[index];
      boolean bare = index >= 6;
      String token;
      if (bare && staticClassName.equals(prefix)) {
        token = "auto";
      } else if (!bare && staticClassName.startsWith(prefix + "-")) {
        token = staticClassName.substring(prefix.length() + 1);
      } else {
        continue;
      }
      String[] valid = index < 3 ? OVERFLOW_TOKENS : OVERSCROLL_TOKENS;
      if (!contains(valid, token)) {
        return null;
      }
      String selector = ".dui." + staticClassName;
      String property = properties[index];
      return new LazyDynamicCssClass(
          () -> {
            registry.setProperty(selector, property, token);
            return () -> staticClassName;
          });
    }
    return null;
  }

  private static CssClass resolveRadiusUtility(
      DynamicCssRegistry registry, String staticClassName) {
    String[] prefixes = {
      "dui-rounded-tl",
      "dui-rounded-tr",
      "dui-rounded-br",
      "dui-rounded-bl",
      "dui-rounded-t",
      "dui-rounded-r",
      "dui-rounded-b",
      "dui-rounded-l",
      "dui-rounded"
    };
    DynamicCssDefinition[] definitions = {
      DynamicRadius.TOP_LEFT,
      DynamicRadius.TOP_RIGHT,
      DynamicRadius.BOTTOM_RIGHT,
      DynamicRadius.BOTTOM_LEFT,
      DynamicRadius.TOP,
      DynamicRadius.RIGHT,
      DynamicRadius.BOTTOM,
      DynamicRadius.LEFT,
      DynamicRadius.RADIUS
    };
    for (int index = 0; index < prefixes.length; index++) {
      String prefix = prefixes[index];
      if (!staticClassName.equals(prefix) && !staticClassName.startsWith(prefix + "-")) {
        continue;
      }
      String token =
          staticClassName.equals(prefix) ? "1" : staticClassName.substring(prefix.length() + 1);
      if (!contains(RADIUS_TOKENS, token) && !contains(SPACING_TOKENS, token)) {
        return null;
      }
      String value = radiusValue(token);
      Map<String, String> properties = new LinkedHashMap<>();
      for (String property : definitions[index].getCssProperties()) {
        properties.put(property, value);
      }
      String selector = ".dui." + staticClassName;
      return new LazyDynamicCssClass(
          () -> {
            registry.setProperties(selector, properties);
            return () -> staticClassName;
          });
    }
    return null;
  }

  private static String radiusValue(String token) {
    switch (token) {
      case "none":
        return "var(--dui-spc-0)";
      case "sm":
        return "var(--dui-spc-0_5)";
      case "md":
        return "var(--dui-spc-1_5)";
      case "lg":
        return "var(--dui-spc-2)";
      case "xl":
        return "var(--dui-spc-3)";
      case "2xl":
        return "var(--dui-spc-4)";
      case "3xl":
        return "var(--dui-spc-6)";
      case "full":
        return "9999px";
      case "circle":
        return "50%";
      case "inherit":
        return "inherit";
      default:
        return "var(--dui-spc-" + token + ")";
    }
  }

  private static CssClass resolveSpaceUtility(DynamicCssRegistry registry, String staticClassName) {
    String prefix;
    String property;
    if (staticClassName.startsWith("dui-space-x-")) {
      prefix = "dui-space-x-";
      property = "margin-left";
    } else if (staticClassName.startsWith("dui-space-y-")) {
      prefix = "dui-space-y-";
      property = "margin-top";
    } else {
      return null;
    }

    String token = staticClassName.substring(prefix.length());
    if (!contains(SPACING_TOKENS, token)) {
      return null;
    }

    String selector = ".dui." + staticClassName + " > * + *";
    String value = "var(--dui-spc-" + token + ")";
    return new LazyDynamicCssClass(
        () -> {
          registry.setProperty(selector, property, value);
          return () -> staticClassName;
        });
  }

  private static CssClass resolveDivideUtility(
      DynamicCssRegistry registry, String staticClassName) {
    String prefix;
    String firstProperty;
    String secondProperty;
    if (staticClassName.equals("dui-divide-x") || staticClassName.startsWith("dui-divide-x-")) {
      prefix = "dui-divide-x";
      firstProperty = "border-right-width";
      secondProperty = "border-left-width";
    } else if (staticClassName.equals("dui-divide-y")
        || staticClassName.startsWith("dui-divide-y-")) {
      prefix = "dui-divide-y";
      firstProperty = "border-top-width";
      secondProperty = "border-bottom-width";
    } else {
      return null;
    }

    String classToken =
        staticClassName.equals(prefix) ? "px" : staticClassName.substring(prefix.length() + 1);
    String spacingToken;
    if (classToken.equals("px")) {
      spacingToken = "px";
    } else if (contains(DIVIDE_TOKENS, classToken)) {
      spacingToken = "0".equals(classToken) ? "0" : classToken + "px";
    } else {
      return null;
    }

    String selector = ".dui." + staticClassName + " > * + *";
    Map<String, String> properties = new LinkedHashMap<>();
    if ("dui-divide-x".equals(prefix)) {
      properties.put(firstProperty, "var(--dui-spc-" + spacingToken + ")");
      properties.put(secondProperty, "var(--dui-spc-0)");
    } else {
      properties.put(firstProperty, "var(--dui-spc-0)");
      properties.put(secondProperty, "var(--dui-spc-" + spacingToken + ")");
    }
    return new LazyDynamicCssClass(
        () -> {
          registry.setProperties(selector, properties);
          return () -> staticClassName;
        });
  }

  private static final class ColorUtility {

    private final String utility;
    private final String color;
    private final String shade;
    private final boolean specialValue;

    private ColorUtility(String utility, String color, String shade, boolean specialValue) {
      this.utility = utility;
      this.color = color;
      this.shade = shade;
      this.specialValue = specialValue;
    }

    private static ColorUtility fromClassName(String className) {
      String[] utilityPrefixes = {
        "text-decoration",
        "border-x",
        "border-y",
        "border-t",
        "border-r",
        "border-b",
        "border-l",
        "border",
        "divide",
        "outline",
        "shadow",
        "context",
        "accent",
        "fg",
        "bg"
      };
      for (String utility : utilityPrefixes) {
        String prefix = "dui-" + utility + "-";
        if (!className.startsWith(prefix)) {
          continue;
        }
        ColorUtility parsed = parse(utility, className.substring(prefix.length()));
        if (parsed != null) {
          return parsed;
        }
      }
      return null;
    }

    private static ColorUtility parse(String utility, String token) {
      for (String color : COLOR_NAMES) {
        if (token.equals(color)) {
          return new ColorUtility(utility, color, "", false);
        }
        String colorPrefix = color + "-";
        if (token.startsWith(colorPrefix)) {
          String shade = token.substring(colorPrefix.length());
          if (contains(COLOR_SHADES, shade)) {
            return new ColorUtility(utility, color, shade, false);
          }
        }
      }
      if (contains(COLOR_SPECIAL_VALUES, token)) {
        return new ColorUtility(utility, token, "", true);
      }
      return null;
    }

    private void inject(DynamicCssRegistry registry) {
      if (!specialValue && isFamilyUtility()) {
        injectFamilyMapping(registry);
      }
      injectUtilityRule(registry);
    }

    private boolean isFamilyUtility() {
      return "fg".equals(utility) || "bg".equals(utility) || "accent".equals(utility);
    }

    private void injectFamilyMapping(DynamicCssRegistry registry) {
      String selector = ".dui[class*=\"dui-" + utility + "-" + color + "\"]";
      String propertyPrefix =
          "fg".equals(utility)
              ? "--dui-fg"
              : "bg".equals(utility) ? "--dui-bg" : "--dui-accent-source";
      Map<String, String> properties = new LinkedHashMap<>();
      for (String familyShade : COLOR_SHADES) {
        String property = propertyPrefix + suffix(familyShade);
        properties.put(property, colorValueForFamily(familyShade));
      }
      if ("bg".equals(utility) && "dominant".equals(color)) {
        properties.put("--dui-btn-hover-color", "var(--dui-dominant-fg-clr)");
      }
      registry.setProperties(selector, properties);
    }

    private String colorValueForFamily(String familyShade) {
      String variable;
      if ("accent".equals(color)) {
        if ("accent".equals(utility)) {
          variable = "--dui-palette-accent" + suffix(familyShade);
        } else {
          variable = "--dui-accent" + suffix(familyShade);
        }
      } else {
        variable = "--dui-clr-" + color + suffix(familyShade);
      }
      return "var(" + variable + ")";
    }

    private void injectUtilityRule(DynamicCssRegistry registry) {
      String selector = utilitySelector();
      String value = colorValue();
      switch (utility) {
        case "fg":
          set(registry, selector, "--dui-fg-clr", value);
          if (!"accent".equals(color)) {
            set(registry, selector, "--dui-text-color", "var(--dui-fg-clr)");
          }
          set(registry, selector, "color", value);
          break;
        case "bg":
          set(registry, selector, "--dui-bg-clr", value);
          set(registry, selector, "--dui-text-color", backgroundForeground());
          set(registry, selector, "background-color", value);
          break;
        case "accent":
          set(registry, selector, "--dui-accent-clr", value);
          if ("inherit".equals(color)) {
            set(registry, selector, "--dui-accent-text-color", value);
          } else if ("accent".equals(color)) {
            set(registry, selector, "--dui-accent-text-color", "var(--dui-clr-white)");
          } else if ("dominant".equals(color)) {
            set(registry, selector, "--dui-accent-text-color", "var(--dui-color)");
          } else if (!specialValue) {
            set(registry, selector, "--dui-accent-text-color", foregroundVariable());
          }
          set(registry, selector, "accent-color", value);
          break;
        case "shadow":
          set(registry, selector, "--dui-shadow-clr", value);
          break;
        case "text-decoration":
          set(registry, selector, "--dui-text-decoration-clr", value);
          set(registry, selector, "text-decoration-color", value);
          break;
        case "border":
          set(registry, selector, "--dui-border-clr", value);
          set(registry, selector, "border-color", value);
          break;
        case "border-x":
          set(registry, selector, "--dui-border-x-clr", value);
          set(registry, selector, "border-left-color", value);
          set(registry, selector, "border-right-color", value);
          break;
        case "border-y":
          set(registry, selector, "--dui-border-y-clr", value);
          set(registry, selector, "border-top-color", value);
          set(registry, selector, "border-bottom-color", value);
          break;
        case "border-t":
        case "border-r":
        case "border-b":
        case "border-l":
          String side = utility.substring("border-".length());
          set(registry, selector, "--dui-border-" + side + "-clr", value);
          set(registry, selector, borderProperty(side), value);
          break;
        case "divide":
          set(registry, selector, "--dui-border-clr", value);
          set(registry, selector, "border-color", value);
          break;
        case "outline":
          set(registry, selector, "--dui-outline-clr", value);
          set(registry, selector, "outline-color", value);
          break;
        case "context":
          if (shade.isEmpty()) {
            for (String familyShade : COLOR_SHADES) {
              set(
                  registry,
                  selector,
                  "--dui-context-color" + suffix(familyShade),
                  paletteColorValue(familyShade));
            }
          } else {
            set(registry, selector, "--dui-context-color", value);
          }
          set(registry, selector, "--dui-context-fg-color", foregroundVariable());
          break;
        default:
          break;
      }
    }

    private String utilitySelector() {
      if ("context".equals(utility)) {
        return ".dui-context-" + color + suffix(shade);
      }
      String selector = ".dui.dui-" + utility + "-" + color + suffix(shade);
      if ("divide".equals(utility)) {
        return selector + " > * + *";
      }
      return selector;
    }

    private String colorValue() {
      if (specialValue) {
        return "var(--dui-clr-" + color + ")";
      }
      return paletteColorValue(shade);
    }

    private String paletteColorValue(String colorShade) {
      String variable =
          "accent".equals(color)
              ? "--dui-accent" + suffix(colorShade)
              : "--dui-clr-" + color + suffix(colorShade);
      return "var(" + variable + ")";
    }

    private String backgroundForeground() {
      if (specialValue || "dominant".equals(color)) {
        return "var(--dui-color)";
      }
      if ("accent".equals(color)) {
        return "var(--dui-clr-white)";
      }
      return foregroundVariable();
    }

    private String foregroundVariable() {
      return "var(--dui-" + color + "-fg-clr)";
    }

    private static String borderProperty(String side) {
      switch (side) {
        case "t":
          return "border-top-color";
        case "r":
          return "border-right-color";
        case "b":
          return "border-bottom-color";
        default:
          return "border-left-color";
      }
    }

    private static void set(
        DynamicCssRegistry registry, String selector, String property, String value) {
      registry.setProperty(selector, property, value);
    }

    private static String suffix(String shade) {
      return shade.isEmpty() ? "" : "-" + shade;
    }
  }

  private static boolean contains(String[] values, String value) {
    for (String candidate : values) {
      if (candidate.equals(value)) {
        return true;
      }
    }
    return false;
  }

  static CssClass resolveStaticValue(
      DynamicCssRegistry registry, DynamicCssDefinition definition, String rawValue) {
    for (Utility utility : UTILITIES) {
      if (utility.matches(definition) && utility.isStaticValue(rawValue)) {
        return registry.lazyCssClass(definition, rawValue, utility.cssValue(rawValue));
      }
    }
    return null;
  }

  static void preloadAll(DynamicCssRegistry registry) {
    preload(registry, OPACITY_TOKENS, "dui-opacity");
    String[] radiusPrefixes = {
      "dui-rounded-tl",
      "dui-rounded-tr",
      "dui-rounded-br",
      "dui-rounded-bl",
      "dui-rounded-t",
      "dui-rounded-r",
      "dui-rounded-b",
      "dui-rounded-l",
      "dui-rounded"
    };
    String[] radiusAliases = {"none", "inherit", "sm", "md", "lg", "xl", "2xl", "3xl", "full"};
    preload(registry, radiusAliases, radiusPrefixes);
    preloadBare(registry, radiusPrefixes);
    preload(registry, "circle", "dui-rounded");
    preload(registry, GRID_COLUMNS_TOKENS, "dui-grid-cols");
    preload(registry, GRID_ROWS_TOKENS, "dui-grid-rows");
    preload(registry, GRID_AUTO_TOKENS, "dui-auto-cols", "dui-auto-rows");
    preload(registry, GRID_SPAN_TOKENS, "dui-col-span", "dui-row-span");
    preload(registry, GRID_COLUMN_POSITION_TOKENS, "dui-col-start", "dui-col-end");
    preload(registry, GRID_ROW_POSITION_TOKENS, "dui-row-start", "dui-row-end");
    preload(registry, GRID_FLOW_TOKENS, "dui-grid-flow");
    preloadBare(registry, "dui-col-auto", "dui-row-auto");
    preload(registry, OVERFLOW_TOKENS, "dui-overflow");
    preload(registry, OVERFLOW_TOKENS, "dui-overflow-x", "dui-overflow-y");
    preload(registry, OVERSCROLL_TOKENS, "dui-overscroll");
    preload(registry, OVERSCROLL_TOKENS, "dui-overscroll-x", "dui-overscroll-y");
    preload(registry, UNDERLINE_OFFSET_TOKENS, "dui-underline-offset");
    preload(registry, OUTLINE_OFFSET_TOKENS, "dui-outline");
    preload(
        registry,
        SPACING_TOKENS,
        "dui-p",
        "dui-p-x",
        "dui-p-y",
        "dui-p-t",
        "dui-p-r",
        "dui-p-b",
        "dui-p-l");
    preload(
        registry,
        SPACING_TOKENS,
        "dui-m",
        "dui-m-x",
        "dui-m-y",
        "dui-m-t",
        "dui-m-r",
        "dui-m-b",
        "dui-m-l");
    preload(
        registry, "auto", "dui-m", "dui-m-x", "dui-m-y", "dui-m-t", "dui-m-r", "dui-m-b",
        "dui-m-l");
    preload(registry, SPACING_TOKENS, "dui-gap", "dui-gap-x", "dui-gap-y", "dui-basis");
    preload(registry, SPACING_TOKENS, "dui-space-x", "dui-space-y");
    preload(registry, SPACING_TOKENS, "dui-txt-indnt", "dui-font-size");
    preload(registry, LEADING_TOKENS, "dui-leading");
    preload(registry, OUTLINE_OFFSET_TOKENS, "dui-outline-offset");
    preload(registry, DIVIDE_TOKENS, "dui-divide-x", "dui-divide-y");
    preloadBare(registry, "dui-divide-x", "dui-divide-y");
    preload(
        registry,
        BORDER_TOKENS,
        "dui-border",
        "dui-border-x",
        "dui-border-y",
        "dui-border-t",
        "dui-border-r",
        "dui-border-b",
        "dui-border-l");
    preloadBare(
        registry,
        "dui-border",
        "dui-border-x",
        "dui-border-y",
        "dui-border-t",
        "dui-border-r",
        "dui-border-b",
        "dui-border-l");
    preload(registry, FLEX_SCALE_TOKENS, "dui-grow", "dui-shrink");
    preload(registry, ORDER_TOKENS, "dui-order");

    preload(
        registry,
        SPACING_TOKENS,
        "dui-w",
        "dui-min-w",
        "dui-max-w",
        "dui-h",
        "dui-min-h",
        "dui-max-h");
    preload(registry, "auto", "dui-w");
    preload(registry, "inherit", "dui-w", "dui-h");
    preload(registry, "screen", "dui-w", "dui-h", "dui-min-h", "dui-max-h");
    preload(registry, "min", "dui-w", "dui-min-w", "dui-max-w", "dui-h", "dui-min-h", "dui-max-h");
    preload(registry, "max", "dui-w", "dui-min-w", "dui-max-w", "dui-h", "dui-min-h", "dui-max-h");
    preload(registry, "fit", "dui-w", "dui-min-w", "dui-max-w", "dui-h", "dui-min-h", "dui-max-h");

    preload(registry, POSITION_TOKENS, "dui-inset", "dui-inset-x", "dui-inset-y", "dui-bottom");
    preload(registry, "auto", "dui-inset", "dui-inset-x", "dui-inset-y", "dui-bottom");
    preload(registry, SPACING_TOKENS, "dui-top", "dui-right", "dui-left");
    preload(registry, "auto", "dui-top", "dui-right", "dui-left");
    preload(registry, new String[] {"0", "10", "20", "30", "40", "50", "auto"}, "dui-z");
  }

  private static void preload(DynamicCssRegistry registry, String token, String... prefixes) {
    for (String prefix : prefixes) {
      resolve(registry, prefix + "-" + token).getCssClass();
    }
  }

  private static void preload(DynamicCssRegistry registry, String[] tokens, String... prefixes) {
    for (String token : tokens) {
      preload(registry, token, prefixes);
    }
  }

  private static void preloadBare(DynamicCssRegistry registry, String... classNames) {
    for (String className : classNames) {
      resolve(registry, className).getCssClass();
    }
  }

  private static Utility spacing(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.SPACING);
  }

  private static Utility radius(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.RADIUS, "1");
  }

  private static Utility grid(
      String prefix, DynamicCssDefinition definition, ValueType valueType, String[] staticTokens) {
    return new Utility(prefix, definition, valueType, null, staticTokens);
  }

  private static Utility utility(
      String prefix, DynamicCssDefinition definition, ValueType valueType, String bareClassToken) {
    return new Utility(prefix, definition, valueType, bareClassToken);
  }

  private static Utility utility(
      String prefix, DynamicCssDefinition definition, ValueType valueType) {
    return new Utility(prefix, definition, valueType);
  }

  private static Utility opacity(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.OPACITY);
  }

  private static Utility pixelSpacing(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.PIXEL_SPACING);
  }

  private static Utility outlineWidth(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.OUTLINE_WIDTH);
  }

  private static Utility outlineOffset(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.OUTLINE_OFFSET);
  }

  private static Utility border(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.SPACING, "px");
  }

  private static Utility sizing(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.SIZING);
  }

  private static Utility direct(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.DIRECT);
  }

  private static Utility direct(String prefix, String property) {
    return direct(prefix, directDefinition(prefix, property));
  }

  private static DynamicCssDefinition directDefinition(String prefix, String property) {
    return DynamicCssDefinition.of(prefix, prefix.replace("dui-", "dui-value"), property);
  }

  private static Utility cssVariable(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.CSS_VARIABLE);
  }

  private static Utility leading(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.LEADING);
  }

  private enum ValueType {
    SPACING,
    SIZING,
    DIRECT,
    CSS_VARIABLE,
    LEADING,
    OUTLINE_OFFSET,
    OUTLINE_WIDTH,
    OPACITY,
    PIXEL_SPACING,
    RADIUS,
    GRID_TEMPLATE,
    GRID_AUTO,
    GRID_SPAN,
    GRID_POSITION,
    GRID_FLOW
  }

  private static final class Utility {

    private final String prefix;
    private final DynamicCssDefinition definition;
    private final ValueType valueType;
    private final String bareClassToken;
    private final String[] staticTokens;

    private Utility(String prefix, DynamicCssDefinition definition, ValueType valueType) {
      this(prefix, definition, valueType, null, null);
    }

    private Utility(
        String prefix,
        DynamicCssDefinition definition,
        ValueType valueType,
        String bareClassToken) {
      this(prefix, definition, valueType, bareClassToken, null);
    }

    private Utility(
        String prefix,
        DynamicCssDefinition definition,
        ValueType valueType,
        String bareClassToken,
        String[] staticTokens) {
      this.prefix = prefix;
      this.definition = definition;
      this.valueType = valueType;
      this.bareClassToken = bareClassToken;
      this.staticTokens = staticTokens;
    }

    private String token(String className) {
      if (className.equals(prefix)) {
        return bareClassToken;
      }
      String prefixWithSeparator = prefix + "-";
      return className.startsWith(prefixWithSeparator)
          ? className.substring(prefixWithSeparator.length())
          : null;
    }

    private String cssValue(String token) {
      if (valueType == ValueType.CSS_VARIABLE) {
        return "var(--" + definition.getVariablePrefix() + "-" + token + ")";
      }
      if (valueType == ValueType.LEADING) {
        return leadingValue(token);
      }
      if (valueType == ValueType.OUTLINE_OFFSET) {
        return outlineSpacingValue(token);
      }
      if (valueType == ValueType.OUTLINE_WIDTH) {
        return outlineSpacingValue(token);
      }
      if (valueType == ValueType.OPACITY) {
        return "var(--dui-opacity-" + token + ")";
      }
      if (valueType == ValueType.PIXEL_SPACING) {
        return "auto".equals(token) ? "auto" : token + "px";
      }
      if (valueType == ValueType.RADIUS) {
        switch (token) {
          case "none":
            return "var(--dui-spc-0)";
          case "sm":
            return "var(--dui-spc-0_5)";
          case "md":
            return "var(--dui-spc-1_5)";
          case "lg":
            return "var(--dui-spc-2)";
          case "xl":
            return "var(--dui-spc-3)";
          case "2xl":
            return "var(--dui-spc-4)";
          case "3xl":
            return "var(--dui-spc-6)";
          case "full":
            return "9999px";
          case "circle":
            return "50%";
          case "inherit":
            return "inherit";
          default:
            return "var(--dui-spc-" + token + ")";
        }
      }
      if (valueType == ValueType.GRID_TEMPLATE) {
        return "none".equals(token) ? "none" : "repeat(" + token + ", minmax(0, 1fr))";
      }
      if (valueType == ValueType.GRID_AUTO) {
        switch (token) {
          case "min":
            return "min-content";
          case "max":
            return "max-content";
          case "fr":
            return "minmax(0, 1fr)";
          default:
            return token;
        }
      }
      if (valueType == ValueType.GRID_SPAN) {
        return "full".equals(token) ? "1 / -1" : "span " + token + " / span " + token;
      }
      if (valueType == ValueType.GRID_POSITION) {
        return token;
      }
      if (valueType == ValueType.GRID_FLOW) {
        return token.replace("col", "column").replace('-', ' ');
      }
      if (valueType == ValueType.DIRECT || "auto".equals(token) || "inherit".equals(token)) {
        return token;
      }
      if (valueType == ValueType.SIZING) {
        switch (token) {
          case "screen":
            return prefix.endsWith("w") ? "100vw" : "100vh";
          case "min":
            return "min-content";
          case "max":
            return "max-content";
          case "fit":
            return "fit-content";
          default:
            break;
        }
      }
      return "var(--dui-spc-" + spacingVariableToken(token) + ")";
    }

    private String spacingVariableToken(String token) {
      if (!isPositionUtility()) {
        return token;
      }
      String normalized = token.replace('.', '_');
      switch (normalized) {
        case "1_2":
        case "2_4":
          return "1_2p";
        case "1_3":
          return "1_3p";
        case "2_3":
          return "2_3p";
        case "1_4":
          return "1_4p";
        case "3_4":
          return "3_4p";
        default:
          return normalized;
      }
    }

    private boolean isPositionUtility() {
      return prefix.equals("dui-inset")
          || prefix.equals("dui-inset-x")
          || prefix.equals("dui-inset-y")
          || prefix.equals("dui-top")
          || prefix.equals("dui-right")
          || prefix.equals("dui-bottom")
          || prefix.equals("dui-left");
    }

    private boolean matches(DynamicCssDefinition other) {
      return prefix.equals(other.getClassPrefix())
          && definition.getVariablePrefix().equals(other.getVariablePrefix())
          && definition.getCssProperties().equals(other.getCssProperties());
    }

    private boolean isStaticValue(String value) {
      if (value == null) {
        return false;
      }
      if (valueType == ValueType.CSS_VARIABLE) {
        return prefix.equals("dui-order")
            ? contains(ORDER_TOKENS, value)
            : contains(FLEX_SCALE_TOKENS, value);
      }
      if (valueType == ValueType.OUTLINE_OFFSET) {
        return contains(OUTLINE_OFFSET_TOKENS, value);
      }
      if (valueType == ValueType.OUTLINE_WIDTH) {
        return contains(OUTLINE_OFFSET_TOKENS, value);
      }
      if (valueType == ValueType.OPACITY) {
        return contains(OPACITY_TOKENS, value);
      }
      if (valueType == ValueType.PIXEL_SPACING) {
        return contains(UNDERLINE_OFFSET_TOKENS, value);
      }
      if (valueType == ValueType.RADIUS) {
        return contains(RADIUS_TOKENS, value) || contains(SPACING_TOKENS, value);
      }
      if (valueType == ValueType.GRID_TEMPLATE
          || valueType == ValueType.GRID_AUTO
          || valueType == ValueType.GRID_SPAN
          || valueType == ValueType.GRID_POSITION
          || valueType == ValueType.GRID_FLOW) {
        return contains(staticTokens, value);
      }
      return valueType == ValueType.SPACING && contains(SPACING_TOKENS, value);
    }

    private String outlineSpacingValue(String token) {
      switch (token) {
        case "0":
          return "var(--dui-spc-0)";
        case "1":
          return "var(--dui-spc-px)";
        case "2":
          return "var(--dui-spc-2px)";
        case "4":
          return "var(--dui-spc-4px)";
        case "8":
          return "var(--dui-spc-8px)";
        default:
          return token;
      }
    }

    private boolean contains(String[] values, String value) {
      for (String candidate : values) {
        if (candidate.equals(value)) {
          return true;
        }
      }
      return false;
    }

    private String leadingValue(String token) {
      switch (token) {
        case "3":
          return ".75rem";
        case "4":
          return "1rem";
        case "5":
          return "1.25rem";
        case "6":
          return "1.5rem";
        case "7":
          return "1.75rem";
        case "8":
          return "2rem";
        case "9":
          return "2.25rem";
        case "10":
          return "2.5rem";
        case "none":
          return "1";
        case "tight":
          return "1.25";
        case "snug":
          return "1.375";
        case "normal":
          return "1.5";
        case "relaxed":
          return "1.625";
        case "loose":
          return "2";
        default:
          return token;
      }
    }
  }
}
