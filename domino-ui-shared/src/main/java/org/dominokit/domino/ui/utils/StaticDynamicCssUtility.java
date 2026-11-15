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
      for (String familyShade : COLOR_SHADES) {
        String property = propertyPrefix + suffix(familyShade);
        registry.setProperty(selector, property, colorValueForFamily(familyShade));
      }
      if ("bg".equals(utility) && "dominant".equals(color)) {
        registry.setProperty(selector, "--dui-btn-hover-color", "var(--dui-dominant-fg-clr)");
      }
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
    preload(registry, SPACING_TOKENS, "dui-txt-indnt", "dui-font-size");
    preload(registry, LEADING_TOKENS, "dui-leading");
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

  private static Utility border(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.SPACING, "px");
  }

  private static Utility sizing(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.SIZING);
  }

  private static Utility direct(String prefix, DynamicCssDefinition definition) {
    return new Utility(prefix, definition, ValueType.DIRECT);
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
    LEADING
  }

  private static final class Utility {

    private final String prefix;
    private final DynamicCssDefinition definition;
    private final ValueType valueType;
    private final String bareClassToken;

    private Utility(String prefix, DynamicCssDefinition definition, ValueType valueType) {
      this(prefix, definition, valueType, null);
    }

    private Utility(
        String prefix,
        DynamicCssDefinition definition,
        ValueType valueType,
        String bareClassToken) {
      this.prefix = prefix;
      this.definition = definition;
      this.valueType = valueType;
      this.bareClassToken = bareClassToken;
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
      return "var(--dui-spc-" + token + ")";
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
      return valueType == ValueType.SPACING && contains(SPACING_TOKENS, value);
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
