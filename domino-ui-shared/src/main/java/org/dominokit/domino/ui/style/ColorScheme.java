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
package org.dominokit.domino.ui.style;

import org.dominokit.domino.ui.themes.Theme;

/** ColorScheme interface. */
public interface ColorScheme {

  /**
   * lighten_5.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color lighten_5();

  /**
   * lighten_4.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color lighten_4();

  /**
   * lighten_3.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color lighten_3();

  /**
   * lighten_2.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color lighten_2();

  /**
   * lighten_1.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color lighten_1();

  /**
   * color.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color color();

  /**
   * darker_1.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color darker_1();

  /**
   * darker_2.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color darker_2();

  /**
   * darker_3.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color darker_3();

  /**
   * darker_4.
   *
   * @return a {@link org.dominokit.domino.ui.style.Color} object.
   */
  Color darker_4();

  /**
   * theme.
   *
   * @return a {@link org.dominokit.domino.ui.themes.Theme} object
   */
  default Theme theme() {
    return new Theme(this);
  }

  /**
   * valueOf.
   *
   * @param name a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.style.ColorScheme} object
   */
  static ColorScheme valueOf(String name) {
    switch (name) {
      case "RED":
        return ColorScheme.RED;
      case "AMBER":
        return ColorScheme.AMBER;
      case "BLACK":
        return ColorScheme.BLACK;
      case "BLUE":
        return ColorScheme.BLUE;
      case "BROWN":
        return ColorScheme.BROWN;
      case "BLUE GREY":
        return ColorScheme.BLUE_GREY;
      case "CYAN":
        return ColorScheme.CYAN;
      case "DEEP ORANGE":
        return ColorScheme.DEEP_ORANGE;
      case "DEEP PURPLE":
        return ColorScheme.DEEP_PURPLE;
      case "GREEN":
        return ColorScheme.GREEN;
      case "GREY":
        return ColorScheme.GREY;
      case "INDIGO":
        return ColorScheme.INDIGO;
      case "LIGHT BLUE":
        return ColorScheme.LIGHT_BLUE;
      case "LIGHT GREEN":
        return ColorScheme.LIGHT_GREEN;
      case "LIME":
        return ColorScheme.LIME;
      case "ORANGE":
        return ColorScheme.ORANGE;
      case "PINK":
        return ColorScheme.PINK;
      case "PURPLE":
        return ColorScheme.PURPLE;
      case "TEAL":
        return ColorScheme.TEAL;
      case "TRANSPARENT":
        return ColorScheme.TRANSPARENT;
      case "WHITE":
        return ColorScheme.WHITE;
      case "YELLOW":
        return ColorScheme.YELLOW;
      default:
        return Theme.currentTheme.getScheme();
    }
  }

  ColorScheme DOMINANT =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.DOMINANT_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.DOMINANT_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.DOMINANT_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.DOMINANT_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.DOMINANT_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.DOMINANT;
        }

        @Override
        public Color darker_1() {
          return Color.DOMINANT_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.DOMINANT_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.DOMINANT_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.DOMINANT_DARKEN_4;
        }

        public String getName() {
          return "DOMINANT";
        }
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
        /** Constant <code>DOMINANT</code> */
      };
  /** Constant <code>PRIMARY</code> */
  ColorScheme PRIMARY =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.PRIMARY_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.PRIMARY_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.PRIMARY_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.PRIMARY_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.PRIMARY_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.PRIMARY;
        }

        @Override
        public Color darker_1() {
          return Color.PRIMARY_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.PRIMARY_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.PRIMARY_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.PRIMARY_DARKEN_4;
        }

        public String getName() {
          return "PRIMARY";
        }
      };

  /** Constant <code>SECONDARY</code> */
  ColorScheme SECONDARY =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.SECONDARY_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.SECONDARY_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.SECONDARY_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.SECONDARY_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.SECONDARY_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.SECONDARY;
        }

        @Override
        public Color darker_1() {
          return Color.SECONDARY_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.SECONDARY_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.SECONDARY_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.SECONDARY_DARKEN_4;
        }

        public String getName() {
          return "SECONDARY";
        }
      };

  /** Constant <code>ACCENT</code> */
  ColorScheme ACCENT =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.ACCENT_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.ACCENT_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.ACCENT_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.ACCENT_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.ACCENT_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.ACCENT;
        }

        @Override
        public Color darker_1() {
          return Color.ACCENT_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.ACCENT_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.ACCENT_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.ACCENT_DARKEN_4;
        }

        public String getName() {
          return "ACCENT";
        }
      };

  /** Constant <code>SUCCESS</code> */
  ColorScheme SUCCESS =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.SUCCESS_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.SUCCESS_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.SUCCESS_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.SUCCESS_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.SUCCESS_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.SUCCESS;
        }

        @Override
        public Color darker_1() {
          return Color.SUCCESS_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.SUCCESS_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.SUCCESS_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.SUCCESS_DARKEN_4;
        }

        public String getName() {
          return "SUCCESS";
        }
      };

  /** Constant <code>WARNING</code> */
  ColorScheme WARNING =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.WARNING_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.WARNING_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.WARNING_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.WARNING_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.WARNING_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.WARNING;
        }

        @Override
        public Color darker_1() {
          return Color.WARNING_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.WARNING_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.WARNING_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.WARNING_DARKEN_4;
        }

        public String getName() {
          return "WARNING";
        }
      };
  /** Constant <code>INFO</code> */
  ColorScheme INFO =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.INFO_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.INFO_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.INFO_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.INFO_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.INFO_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.INFO;
        }

        @Override
        public Color darker_1() {
          return Color.INFO_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.INFO_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.INFO_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.INFO_DARKEN_4;
        }

        public String getName() {
          return "INFO";
        }
      };

  /** Constant <code>ERROR</code> */
  ColorScheme ERROR =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.ERROR_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.ERROR_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.ERROR_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.ERROR_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.ERROR_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.ERROR;
        }

        @Override
        public Color darker_1() {
          return Color.ERROR_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.ERROR_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.ERROR_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.ERROR_DARKEN_4;
        }

        public String getName() {
          return "ERROR";
        }
      };

  /** Constant <code>RED</code> */
  ColorScheme RED =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.RED_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.RED_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.RED_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.RED_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.RED_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.RED;
        }

        @Override
        public Color darker_1() {
          return Color.RED_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.RED_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.RED_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.RED_DARKEN_4;
        }

        public String getName() {
          return "RED";
        }
      };

  /** Constant <code>PINK</code> */
  ColorScheme PINK =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.PINK_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.PINK_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.PINK_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.PINK_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.PINK_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.PINK;
        }

        @Override
        public Color darker_1() {
          return Color.PINK_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.PINK_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.PINK_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.PINK_DARKEN_4;
        }
      };

  /** Constant <code>PURPLE</code> */
  ColorScheme PURPLE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.PURPLE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.PURPLE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.PURPLE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.PURPLE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.PURPLE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.PURPLE;
        }

        @Override
        public Color darker_1() {
          return Color.PURPLE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.PURPLE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.PURPLE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.PURPLE_DARKEN_4;
        }
      };

  /** Constant <code>DEEP_PURPLE</code> */
  ColorScheme DEEP_PURPLE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.DEEP_PURPLE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.DEEP_PURPLE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.DEEP_PURPLE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.DEEP_PURPLE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.DEEP_PURPLE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.DEEP_PURPLE;
        }

        @Override
        public Color darker_1() {
          return Color.DEEP_PURPLE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.DEEP_PURPLE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.DEEP_PURPLE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.DEEP_PURPLE_DARKEN_4;
        }
      };

  /** Constant <code>INDIGO</code> */
  ColorScheme INDIGO =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.INDIGO_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.INDIGO_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.INDIGO_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.INDIGO_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.INDIGO_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.INDIGO;
        }

        @Override
        public Color darker_1() {
          return Color.INDIGO_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.INDIGO_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.INDIGO_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.INDIGO_DARKEN_4;
        }
      };

  /** Constant <code>BLUE</code> */
  ColorScheme BLUE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.BLUE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.BLUE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.BLUE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.BLUE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.BLUE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.BLUE;
        }

        @Override
        public Color darker_1() {
          return Color.BLUE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.BLUE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.BLUE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.BLUE_DARKEN_4;
        }
      };

  /** Constant <code>LIGHT_BLUE</code> */
  ColorScheme LIGHT_BLUE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.LIGHT_BLUE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.LIGHT_BLUE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.LIGHT_BLUE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.LIGHT_BLUE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.LIGHT_BLUE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.LIGHT_BLUE;
        }

        @Override
        public Color darker_1() {
          return Color.LIGHT_BLUE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.LIGHT_BLUE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.LIGHT_BLUE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.LIGHT_BLUE_DARKEN_4;
        }
      };

  /** Constant <code>CYAN</code> */
  ColorScheme CYAN =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.CYAN_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.CYAN_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.CYAN_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.CYAN_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.CYAN_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.CYAN;
        }

        @Override
        public Color darker_1() {
          return Color.CYAN_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.CYAN_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.CYAN_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.CYAN_DARKEN_4;
        }
      };

  /** Constant <code>TEAL</code> */
  ColorScheme TEAL =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.TEAL_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.TEAL_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.TEAL_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.TEAL_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.TEAL_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.TEAL;
        }

        @Override
        public Color darker_1() {
          return Color.TEAL_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.TEAL_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.TEAL_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.TEAL_DARKEN_4;
        }
      };

  /** Constant <code>GREEN</code> */
  ColorScheme GREEN =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.GREEN_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.GREEN_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.GREEN_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.GREEN_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.GREEN_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.GREEN;
        }

        @Override
        public Color darker_1() {
          return Color.GREEN_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.GREEN_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.GREEN_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.GREEN_DARKEN_4;
        }
      };

  /** Constant <code>LIGHT_GREEN</code> */
  ColorScheme LIGHT_GREEN =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.LIGHT_GREEN_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.LIGHT_GREEN_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.LIGHT_GREEN_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.LIGHT_GREEN_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.LIGHT_GREEN_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.LIGHT_GREEN;
        }

        @Override
        public Color darker_1() {
          return Color.LIGHT_GREEN_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.LIGHT_GREEN_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.LIGHT_GREEN_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.LIGHT_GREEN_DARKEN_4;
        }
      };

  /** Constant <code>LIME</code> */
  ColorScheme LIME =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.LIME_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.LIME_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.LIME_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.LIME_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.LIME_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.LIME;
        }

        @Override
        public Color darker_1() {
          return Color.LIME_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.LIME_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.LIME_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.LIME_DARKEN_4;
        }
      };

  /** Constant <code>YELLOW</code> */
  ColorScheme YELLOW =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.YELLOW_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.YELLOW_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.YELLOW_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.YELLOW_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.YELLOW_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.YELLOW;
        }

        @Override
        public Color darker_1() {
          return Color.YELLOW_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.YELLOW_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.YELLOW_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.YELLOW_DARKEN_4;
        }
      };

  /** Constant <code>AMBER</code> */
  ColorScheme AMBER =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.AMBER_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.AMBER_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.AMBER_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.AMBER_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.AMBER_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.AMBER;
        }

        @Override
        public Color darker_1() {
          return Color.AMBER_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.AMBER_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.AMBER_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.AMBER_DARKEN_4;
        }
      };

  /** Constant <code>ORANGE</code> */
  ColorScheme ORANGE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.ORANGE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.ORANGE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.ORANGE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.ORANGE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.ORANGE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.ORANGE;
        }

        @Override
        public Color darker_1() {
          return Color.ORANGE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.ORANGE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.ORANGE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.ORANGE_DARKEN_4;
        }
      };

  /** Constant <code>DEEP_ORANGE</code> */
  ColorScheme DEEP_ORANGE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.DEEP_ORANGE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.DEEP_ORANGE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.DEEP_ORANGE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.DEEP_ORANGE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.DEEP_ORANGE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.DEEP_ORANGE;
        }

        @Override
        public Color darker_1() {
          return Color.DEEP_ORANGE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.DEEP_ORANGE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.DEEP_ORANGE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.DEEP_ORANGE_DARKEN_4;
        }
      };

  /** Constant <code>BROWN</code> */
  ColorScheme BROWN =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.BROWN_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.BROWN_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.BROWN_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.BROWN_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.BROWN_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.BROWN;
        }

        @Override
        public Color darker_1() {
          return Color.BROWN_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.BROWN_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.BROWN_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.BROWN_DARKEN_4;
        }
      };

  /** Constant <code>GREY</code> */
  ColorScheme GREY =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.GREY_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.GREY_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.GREY_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.GREY_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.GREY_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.GREY;
        }

        @Override
        public Color darker_1() {
          return Color.GREY_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.GREY_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.GREY_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.GREY_DARKEN_4;
        }
      };

  /** Constant <code>BLUE_GREY</code> */
  ColorScheme BLUE_GREY =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.BLUE_GREY_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.BLUE_GREY_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.BLUE_GREY_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.BLUE_GREY_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.BLUE_GREY_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.BLUE_GREY;
        }

        @Override
        public Color darker_1() {
          return Color.BLUE_GREY_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.BLUE_GREY_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.BLUE_GREY_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.BLUE_GREY_DARKEN_4;
        }
      };

  /** Constant <code>BLACK</code> */
  ColorScheme BLACK =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.BLACK_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.BLACK_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.BLACK_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.BLACK_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.BLACK_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.BLACK;
        }

        @Override
        public Color darker_1() {
          return Color.BLACK_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.BLACK_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.BLACK_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.BLACK_DARKEN_4;
        }
      };

  /** Constant <code>WHITE</code> */
  ColorScheme WHITE =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.WHITE_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.WHITE_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.WHITE_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.WHITE_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.WHITE_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.WHITE;
        }

        @Override
        public Color darker_1() {
          return Color.WHITE_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.WHITE_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.WHITE_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.WHITE_DARKEN_4;
        }
      };

  /** Constant <code>TRANSPARENT</code> */
  ColorScheme TRANSPARENT =
      new ColorScheme() {
        @Override
        public Color lighten_5() {
          return Color.TRANSPARENT_LIGHTEN_5;
        }

        @Override
        public Color lighten_4() {
          return Color.TRANSPARENT_LIGHTEN_4;
        }

        @Override
        public Color lighten_3() {
          return Color.TRANSPARENT_LIGHTEN_3;
        }

        @Override
        public Color lighten_2() {
          return Color.TRANSPARENT_LIGHTEN_2;
        }

        @Override
        public Color lighten_1() {
          return Color.TRANSPARENT_LIGHTEN_1;
        }

        @Override
        public Color color() {
          return Color.TRANSPARENT;
        }

        @Override
        public Color darker_1() {
          return Color.TRANSPARENT_DARKEN_1;
        }

        @Override
        public Color darker_2() {
          return Color.TRANSPARENT_DARKEN_2;
        }

        @Override
        public Color darker_3() {
          return Color.TRANSPARENT_DARKEN_3;
        }

        @Override
        public Color darker_4() {
          return Color.TRANSPARENT_DARKEN_4;
        }
      };

  /**
   * of.
   *
   * @param name a {@link java.lang.String} object.
   * @return a {@link org.dominokit.domino.ui.style.ColorScheme} object.
   */
  static ColorScheme of(String name) {
    switch (name) {
      case "RED":
        return ColorScheme.RED;

      case "PINK":
        return ColorScheme.PINK;

      case "PURPLE":
        return ColorScheme.PURPLE;

      case "DEEP PURPLE":
        return ColorScheme.DEEP_PURPLE;

      case "INDIGO":
        return ColorScheme.INDIGO;

      case "BLUE":
        return ColorScheme.BLUE;

      case "LIGHT BLUE":
        return ColorScheme.LIGHT_BLUE;

      case "CYAN":
        return ColorScheme.CYAN;

      case "TEAL":
        return ColorScheme.TEAL;

      case "GREEN":
        return ColorScheme.GREEN;

      case "LIGHT GREEN":
        return ColorScheme.LIGHT_GREEN;

      case "LIME":
        return ColorScheme.LIME;

      case "YELLOW":
        return ColorScheme.YELLOW;

      case "AMBER":
        return ColorScheme.AMBER;

      case "ORANGE":
        return ColorScheme.ORANGE;

      case "DEEP ORANGE":
        return ColorScheme.DEEP_ORANGE;

      case "BROWN":
        return ColorScheme.BROWN;

      case "GREY":
        return ColorScheme.GREY;

      case "BLUE GREY":
        return ColorScheme.BLUE_GREY;

      case "BLACK":
        return ColorScheme.BLACK;

      case "WHITE":
        return ColorScheme.WHITE;

      case "TRANSPARENT":
        return ColorScheme.TRANSPARENT;
      default:
        throw new IllegalArgumentException("ColorScheme [" + name + "] not found!.");
    }
  }
}
