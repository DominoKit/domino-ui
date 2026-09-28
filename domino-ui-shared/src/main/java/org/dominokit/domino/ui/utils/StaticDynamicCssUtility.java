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
    for (Utility utility : UTILITIES) {
      String token = utility.token(staticClassName);
      if (token != null) {
        return registry.lazyCssClass(utility.definition, token, utility.cssValue(token));
      }
    }
    return () -> staticClassName;
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
