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

import static org.dominokit.domino.ui.style.ColorsCss.*;
import static org.dominokit.domino.ui.style.GenericCss.*;

public interface Color {

  CssClass getCss();

  String getName();

  CssClass getBackground();

  CssClass getForeground();

  CssClass getBorderColor();

  CssClass getAccentColor();

  CssClass getUtilityColor();

  Color DOMINANT =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant;
        }
      };

  Color DOMINANT_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_l_1;
        }
      };

  Color DOMINANT_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_l_2;
        }
      };

  Color DOMINANT_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_l_3;
        }
      };

  Color DOMINANT_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_l_4;
        }
      };

  Color DOMINANT_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_l_5;
        }
      };

  Color DOMINANT_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_d_1;
        }
      };

  Color DOMINANT_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_d_2;
        }
      };

  Color DOMINANT_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_dominant_d_3;
        }
      };

  Color DOMINANT_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_dominant;
        }

        @Override
        public String getName() {
          return "DOMINANT_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_dominant_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_dominant_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_dominant;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_dominant;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_d_4;
        }
      };

  Color ACCENT =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent;
        }
      };

  Color ACCENT_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_l_1;
        }
      };

  Color ACCENT_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_l_2;
        }
      };

  Color ACCENT_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_l_3;
        }
      };

  Color ACCENT_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_l_4;
        }
      };

  Color ACCENT_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_l_5;
        }
      };

  Color ACCENT_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_d_1;
        }
      };

  Color ACCENT_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_d_2;
        }
      };

  Color ACCENT_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_d_3;
        }
      };

  Color ACCENT_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_accent;
        }

        @Override
        public String getName() {
          return "ACCENT_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_accent_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_accent_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_accent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_accent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_accent_d_4;
        }
      };

  Color PRIMARY =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary;
        }
      };

  Color PRIMARY_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_l_1;
        }
      };

  Color PRIMARY_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_l_2;
        }
      };

  Color PRIMARY_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_l_3;
        }
      };

  Color PRIMARY_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_l_4;
        }
      };

  Color PRIMARY_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_l_5;
        }
      };

  Color PRIMARY_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_d_1;
        }
      };

  Color PRIMARY_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_d_2;
        }
      };

  Color PRIMARY_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_d_3;
        }
      };

  Color PRIMARY_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_primary;
        }

        @Override
        public String getName() {
          return "PRIMARY_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_primary_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_primary_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_primary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_primary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_primary_d_4;
        }
      };

  Color SECONDARY =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary;
        }
      };

  Color SECONDARY_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_l_1;
        }
      };

  Color SECONDARY_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_l_2;
        }
      };

  Color SECONDARY_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_l_3;
        }
      };

  Color SECONDARY_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_l_4;
        }
      };

  Color SECONDARY_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_l_5;
        }
      };

  Color SECONDARY_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_d_1;
        }
      };

  Color SECONDARY_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_d_2;
        }
      };

  Color SECONDARY_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_d_3;
        }
      };

  Color SECONDARY_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_secondary;
        }

        @Override
        public String getName() {
          return "SECONDARY_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_secondary_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_secondary_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_secondary;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_secondary;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_secondary_d_4;
        }
      };

  Color SUCCESS =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success;
        }
      };

  Color SUCCESS_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_l_1;
        }
      };

  Color SUCCESS_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_l_2;
        }
      };

  Color SUCCESS_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_l_3;
        }
      };

  Color SUCCESS_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_l_4;
        }
      };

  Color SUCCESS_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_l_5;
        }
      };

  Color SUCCESS_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_d_1;
        }
      };

  Color SUCCESS_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_d_2;
        }
      };

  Color SUCCESS_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_d_3;
        }
      };

  Color SUCCESS_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_success;
        }

        @Override
        public String getName() {
          return "SUCCESS_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_success_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_success_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_success;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_success;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_success_d_4;
        }
      };

  Color WARNING =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning;
        }
      };

  Color WARNING_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_l_1;
        }
      };

  Color WARNING_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_l_2;
        }
      };

  Color WARNING_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_l_3;
        }
      };

  Color WARNING_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_l_4;
        }
      };

  Color WARNING_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_l_5;
        }
      };

  Color WARNING_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_d_1;
        }
      };

  Color WARNING_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_d_2;
        }
      };

  Color WARNING_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_d_3;
        }
      };

  Color WARNING_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_warning;
        }

        @Override
        public String getName() {
          return "WARNING_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_warning_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_warning_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_warning;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_warning;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_warning_d_4;
        }
      };

  Color INFO =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info;
        }
      };

  Color INFO_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_l_1;
        }
      };

  Color INFO_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_l_2;
        }
      };

  Color INFO_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_l_3;
        }
      };

  Color INFO_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_l_4;
        }
      };

  Color INFO_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_l_5;
        }
      };

  Color INFO_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_d_1;
        }
      };

  Color INFO_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_d_2;
        }
      };

  Color INFO_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_d_3;
        }
      };

  Color INFO_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_info;
        }

        @Override
        public String getName() {
          return "INFO_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_info_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_info_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_info;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_info;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_info_d_4;
        }
      };

  Color ERROR =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error;
        }
      };

  Color ERROR_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_l_1;
        }
      };

  Color ERROR_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_l_2;
        }
      };

  Color ERROR_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_l_3;
        }
      };

  Color ERROR_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_l_4;
        }
      };

  Color ERROR_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_l_5;
        }
      };

  Color ERROR_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_d_1;
        }
      };

  Color ERROR_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_d_2;
        }
      };

  Color ERROR_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_d_3;
        }
      };

  Color ERROR_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_error;
        }

        @Override
        public String getName() {
          return "ERROR_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_error_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_error_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_error;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_error;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_error_d_4;
        }
      };

  Color RED =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red;
        }
      };

  Color RED_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_l_1;
        }
      };

  Color RED_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_l_2;
        }
      };

  Color RED_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_l_3;
        }
      };

  Color RED_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_l_4;
        }
      };

  Color RED_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_l_5;
        }
      };

  Color RED_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_d_1;
        }
      };

  Color RED_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_d_2;
        }
      };

  Color RED_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_d_3;
        }
      };

  Color RED_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_red;
        }

        @Override
        public String getName() {
          return "RED_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_red_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_red_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_red;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_red;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_red_d_4;
        }
      };

  Color PINK =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink;
        }
      };

  Color PINK_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_l_1;
        }
      };

  Color PINK_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_l_2;
        }
      };

  Color PINK_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_l_3;
        }
      };

  Color PINK_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_l_4;
        }
      };

  Color PINK_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_l_5;
        }
      };

  Color PINK_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_d_1;
        }
      };

  Color PINK_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_d_2;
        }
      };

  Color PINK_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_d_3;
        }
      };

  Color PINK_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_pink;
        }

        @Override
        public String getName() {
          return "PINK_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_pink_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_pink_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_pink;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_pink;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_pink_d_4;
        }
      };

  Color PURPLE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple;
        }
      };

  Color PURPLE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_l_1;
        }
      };

  Color PURPLE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_l_2;
        }
      };

  Color PURPLE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_l_3;
        }
      };

  Color PURPLE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_l_4;
        }
      };

  Color PURPLE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_l_5;
        }
      };

  Color PURPLE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_d_1;
        }
      };

  Color PURPLE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_d_2;
        }
      };

  Color PURPLE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_d_3;
        }
      };

  Color PURPLE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_purple;
        }

        @Override
        public String getName() {
          return "PURPLE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_purple_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_purple_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_purple_d_4;
        }
      };

  Color DEEP_PURPLE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple;
        }
      };

  Color DEEP_PURPLE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_l_1;
        }
      };

  Color DEEP_PURPLE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_l_2;
        }
      };

  Color DEEP_PURPLE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_l_3;
        }
      };

  Color DEEP_PURPLE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_l_4;
        }
      };

  Color DEEP_PURPLE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_l_5;
        }
      };

  Color DEEP_PURPLE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_d_1;
        }
      };

  Color DEEP_PURPLE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_d_2;
        }
      };

  Color DEEP_PURPLE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_d_3;
        }
      };

  Color DEEP_PURPLE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_purple;
        }

        @Override
        public String getName() {
          return "DEEP_PURPLE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_purple_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_purple_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_purple;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_purple;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_purple_d_4;
        }
      };

  Color INDIGO =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo;
        }
      };

  Color INDIGO_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_l_1;
        }
      };

  Color INDIGO_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_l_2;
        }
      };

  Color INDIGO_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_l_3;
        }
      };

  Color INDIGO_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_l_4;
        }
      };

  Color INDIGO_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_l_5;
        }
      };

  Color INDIGO_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_d_1;
        }
      };

  Color INDIGO_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_d_2;
        }
      };

  Color INDIGO_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_d_3;
        }
      };

  Color INDIGO_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_indigo;
        }

        @Override
        public String getName() {
          return "INDIGO_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_indigo_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_indigo_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_indigo;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_indigo;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_indigo_d_4;
        }
      };

  Color BLUE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue;
        }
      };

  Color BLUE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_l_1;
        }
      };

  Color BLUE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_l_2;
        }
      };

  Color BLUE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_l_3;
        }
      };

  Color BLUE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_l_4;
        }
      };

  Color BLUE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_l_5;
        }
      };

  Color BLUE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_d_1;
        }
      };

  Color BLUE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_d_2;
        }
      };

  Color BLUE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_d_3;
        }
      };

  Color BLUE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue;
        }

        @Override
        public String getName() {
          return "BLUE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_d_4;
        }
      };

  Color LIGHT_BLUE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue;
        }
      };

  Color LIGHT_BLUE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_l_1;
        }
      };

  Color LIGHT_BLUE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_l_2;
        }
      };

  Color LIGHT_BLUE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_l_3;
        }
      };

  Color LIGHT_BLUE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_l_4;
        }
      };

  Color LIGHT_BLUE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_l_5;
        }
      };

  Color LIGHT_BLUE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_d_1;
        }
      };

  Color LIGHT_BLUE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_d_2;
        }
      };

  Color LIGHT_BLUE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_d_3;
        }
      };

  Color LIGHT_BLUE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_blue;
        }

        @Override
        public String getName() {
          return "LIGHT_BLUE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_blue_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_blue_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_blue;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_blue;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_blue_d_4;
        }
      };

  Color CYAN =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan;
        }
      };

  Color CYAN_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_l_1;
        }
      };

  Color CYAN_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_l_2;
        }
      };

  Color CYAN_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_l_3;
        }
      };

  Color CYAN_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_l_4;
        }
      };

  Color CYAN_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_l_5;
        }
      };

  Color CYAN_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_d_1;
        }
      };

  Color CYAN_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_d_2;
        }
      };

  Color CYAN_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_d_3;
        }
      };

  Color CYAN_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_cyan;
        }

        @Override
        public String getName() {
          return "CYAN_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_cyan_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_cyan_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_cyan;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_cyan;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_cyan_d_4;
        }
      };

  Color TEAL =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal;
        }
      };

  Color TEAL_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_l_1;
        }
      };

  Color TEAL_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_l_2;
        }
      };

  Color TEAL_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_l_3;
        }
      };

  Color TEAL_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_l_4;
        }
      };

  Color TEAL_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_l_5;
        }
      };

  Color TEAL_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_d_1;
        }
      };

  Color TEAL_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_d_2;
        }
      };

  Color TEAL_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_d_3;
        }
      };

  Color TEAL_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_teal;
        }

        @Override
        public String getName() {
          return "TEAL_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_teal_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_teal_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_teal;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_teal;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_teal_d_4;
        }
      };

  Color GREEN =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green;
        }
      };

  Color GREEN_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_l_1;
        }
      };

  Color GREEN_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_l_2;
        }
      };

  Color GREEN_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_l_3;
        }
      };

  Color GREEN_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_l_4;
        }
      };

  Color GREEN_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_l_5;
        }
      };

  Color GREEN_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_d_1;
        }
      };

  Color GREEN_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_d_2;
        }
      };

  Color GREEN_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_d_3;
        }
      };

  Color GREEN_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_green;
        }

        @Override
        public String getName() {
          return "GREEN_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_green_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_green_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_green_d_4;
        }
      };

  Color LIGHT_GREEN =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green;
        }
      };

  Color LIGHT_GREEN_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_l_1;
        }
      };

  Color LIGHT_GREEN_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_l_2;
        }
      };

  Color LIGHT_GREEN_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_l_3;
        }
      };

  Color LIGHT_GREEN_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_l_4;
        }
      };

  Color LIGHT_GREEN_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_l_5;
        }
      };

  Color LIGHT_GREEN_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_d_1;
        }
      };

  Color LIGHT_GREEN_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_d_2;
        }
      };

  Color LIGHT_GREEN_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_d_3;
        }
      };

  Color LIGHT_GREEN_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_light_green;
        }

        @Override
        public String getName() {
          return "LIGHT_GREEN_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_light_green_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_light_green_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_light_green;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_light_green;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_light_green_d_4;
        }
      };

  Color LIME =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime;
        }
      };

  Color LIME_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_l_1;
        }
      };

  Color LIME_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_l_2;
        }
      };

  Color LIME_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_l_3;
        }
      };

  Color LIME_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_l_4;
        }
      };

  Color LIME_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_l_5;
        }
      };

  Color LIME_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_d_1;
        }
      };

  Color LIME_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_d_2;
        }
      };

  Color LIME_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_d_3;
        }
      };

  Color LIME_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_lime;
        }

        @Override
        public String getName() {
          return "LIME_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_lime_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_lime_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_lime;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_lime;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_lime_d_4;
        }
      };

  Color YELLOW =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow;
        }
      };

  Color YELLOW_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_l_1;
        }
      };

  Color YELLOW_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_l_2;
        }
      };

  Color YELLOW_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_l_3;
        }
      };

  Color YELLOW_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_l_4;
        }
      };

  Color YELLOW_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_l_5;
        }
      };

  Color YELLOW_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_d_1;
        }
      };

  Color YELLOW_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_d_2;
        }
      };

  Color YELLOW_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_d_3;
        }
      };

  Color YELLOW_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_yellow;
        }

        @Override
        public String getName() {
          return "YELLOW_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_yellow_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_yellow_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_yellow;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_yellow;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_yellow_d_4;
        }
      };

  Color AMBER =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber;
        }
      };

  Color AMBER_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_l_1;
        }
      };

  Color AMBER_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_l_2;
        }
      };

  Color AMBER_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_l_3;
        }
      };

  Color AMBER_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_l_4;
        }
      };

  Color AMBER_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_l_5;
        }
      };

  Color AMBER_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_d_1;
        }
      };

  Color AMBER_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_d_2;
        }
      };

  Color AMBER_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_d_3;
        }
      };

  Color AMBER_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_amber;
        }

        @Override
        public String getName() {
          return "AMBER_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_amber_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_amber_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_amber;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_amber;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_amber_d_4;
        }
      };

  Color ORANGE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange;
        }
      };

  Color ORANGE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_l_1;
        }
      };

  Color ORANGE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_l_2;
        }
      };

  Color ORANGE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_l_3;
        }
      };

  Color ORANGE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_l_4;
        }
      };

  Color ORANGE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_l_5;
        }
      };

  Color ORANGE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_d_1;
        }
      };

  Color ORANGE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_d_2;
        }
      };

  Color ORANGE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_d_3;
        }
      };

  Color ORANGE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_orange;
        }

        @Override
        public String getName() {
          return "ORANGE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_orange_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_orange_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_orange_d_4;
        }
      };

  Color DEEP_ORANGE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange;
        }
      };

  Color DEEP_ORANGE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_l_1;
        }
      };

  Color DEEP_ORANGE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_l_2;
        }
      };

  Color DEEP_ORANGE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_l_3;
        }
      };

  Color DEEP_ORANGE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_l_4;
        }
      };

  Color DEEP_ORANGE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_l_5;
        }
      };

  Color DEEP_ORANGE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_d_1;
        }
      };

  Color DEEP_ORANGE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_d_2;
        }
      };

  Color DEEP_ORANGE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_d_3;
        }
      };

  Color DEEP_ORANGE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_deep_orange;
        }

        @Override
        public String getName() {
          return "DEEP_ORANGE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_deep_orange_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_deep_orange_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_deep_orange;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_deep_orange;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_deep_orange_d_4;
        }
      };

  Color BROWN =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown;
        }
      };

  Color BROWN_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_l_1;
        }
      };

  Color BROWN_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_l_2;
        }
      };

  Color BROWN_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_l_3;
        }
      };

  Color BROWN_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_l_4;
        }
      };

  Color BROWN_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_l_5;
        }
      };

  Color BROWN_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_d_1;
        }
      };

  Color BROWN_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_d_2;
        }
      };

  Color BROWN_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_d_3;
        }
      };

  Color BROWN_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_brown;
        }

        @Override
        public String getName() {
          return "BROWN_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_brown_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_brown_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_brown;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_brown;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_brown_d_4;
        }
      };

  Color GREY =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey;
        }
      };

  Color GREY_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_l_1;
        }
      };

  Color GREY_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_l_2;
        }
      };

  Color GREY_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_l_3;
        }
      };

  Color GREY_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_l_4;
        }
      };

  Color GREY_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_l_5;
        }
      };

  Color GREY_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_d_1;
        }
      };

  Color GREY_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_d_2;
        }
      };

  Color GREY_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_d_3;
        }
      };

  Color GREY_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_grey;
        }

        @Override
        public String getName() {
          return "GREY_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_grey_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_grey_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_grey_d_4;
        }
      };

  Color BLUE_GREY =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey;
        }
      };

  Color BLUE_GREY_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_l_1;
        }
      };

  Color BLUE_GREY_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_l_2;
        }
      };

  Color BLUE_GREY_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_l_3;
        }
      };

  Color BLUE_GREY_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_l_4;
        }
      };

  Color BLUE_GREY_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_l_5;
        }
      };

  Color BLUE_GREY_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_d_1;
        }
      };

  Color BLUE_GREY_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_d_2;
        }
      };

  Color BLUE_GREY_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_d_3;
        }
      };

  Color BLUE_GREY_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_blue_grey;
        }

        @Override
        public String getName() {
          return "BLUE_GREY_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_blue_grey_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_blue_grey_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_blue_grey;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_blue_grey;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_blue_grey_d_4;
        }
      };

  Color WHITE =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white;
        }
      };

  Color WHITE_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_l_1;
        }
      };

  Color WHITE_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_l_2;
        }
      };

  Color WHITE_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_l_3;
        }
      };

  Color WHITE_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_l_4;
        }
      };

  Color WHITE_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_l_5;
        }
      };

  Color WHITE_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_d_1;
        }
      };

  Color WHITE_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_d_2;
        }
      };

  Color WHITE_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_d_3;
        }
      };

  Color WHITE_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_white;
        }

        @Override
        public String getName() {
          return "WHITE_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_white_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_white_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_white;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_white;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_white_d_4;
        }
      };

  Color BLACK =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black;
        }
      };

  Color BLACK_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_l_1;
        }
      };

  Color BLACK_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_l_2;
        }
      };

  Color BLACK_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_l_3;
        }
      };

  Color BLACK_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_l_4;
        }
      };

  Color BLACK_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_l_5;
        }
      };

  Color BLACK_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_d_1;
        }
      };

  Color BLACK_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_d_2;
        }
      };

  Color BLACK_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_d_3;
        }
      };

  Color BLACK_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_black;
        }

        @Override
        public String getName() {
          return "BLACK_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_black_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_black_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_black;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_black;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_black_d_4;
        }
      };

  Color TRANSPARENT =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_LIGHTEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_LIGHTEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_l_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_l_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_LIGHTEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_LIGHTEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_l_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_l_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_LIGHTEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_LIGHTEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_l_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_l_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_LIGHTEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_LIGHTEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_l_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_l_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_LIGHTEN_5 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_LIGHTEN_5";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_l_5;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_l_5;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_DARKEN_1 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_DARKEN_1";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_d_1;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_d_1;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_DARKEN_2 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_DARKEN_2";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_d_2;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_d_2;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_DARKEN_3 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_DARKEN_3";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_d_3;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_d_3;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  Color TRANSPARENT_DARKEN_4 =
      new Color() {
        @Override
        public CssClass getCss() {
          return dui_transparent;
        }

        @Override
        public String getName() {
          return "TRANSPARENT_DARKEN_4";
        }

        @Override
        public CssClass getBackground() {
          return dui_bg_transparent_d_4;
        }

        @Override
        public CssClass getForeground() {
          return dui_fg_transparent_d_4;
        }

        @Override
        public CssClass getBorderColor() {
          return dui_border_transparent;
        }

        @Override
        public CssClass getAccentColor() {
          return dui_accent_transparent;
        }

        @Override
        public CssClass getUtilityColor() {
          return dui_color_transparent;
        }
      };

  static Color of(String name) {
    switch (name) {
      case "RED":
        return Color.RED;

      case "RED DARKEN 1":
        return Color.RED_DARKEN_1;

      case "RED DARKEN 2":
        return Color.RED_DARKEN_2;

      case "RED DARKEN 3":
        return Color.RED_DARKEN_3;

      case "RED DARKEN 4":
        return Color.RED_DARKEN_4;

      case "RED LIGHTEN 1":
        return Color.RED_LIGHTEN_1;

      case "RED LIGHTEN 2":
        return Color.RED_LIGHTEN_2;

      case "RED LIGHTEN 3":
        return Color.RED_LIGHTEN_3;

      case "RED LIGHTEN 4":
        return Color.RED_LIGHTEN_4;

      case "RED LIGHTEN 5":
        return Color.RED_LIGHTEN_5;

      case "PINK":
        return Color.PINK;

      case "PINK DARKEN 1":
        return Color.PINK_DARKEN_1;

      case "PINK DARKEN 2":
        return Color.PINK_DARKEN_2;

      case "PINK DARKEN 3":
        return Color.PINK_DARKEN_3;

      case "PINK DARKEN 4":
        return Color.PINK_DARKEN_4;

      case "PINK LIGHTEN 1":
        return Color.PINK_LIGHTEN_1;

      case "PINK LIGHTEN 2":
        return Color.PINK_LIGHTEN_2;

      case "PINK LIGHTEN 3":
        return Color.PINK_LIGHTEN_3;

      case "PINK LIGHTEN 4":
        return Color.PINK_LIGHTEN_4;

      case "PINK LIGHTEN 5":
        return Color.PINK_LIGHTEN_5;

      case "PURPLE":
        return Color.PURPLE;

      case "PURPLE DARKEN 1":
        return Color.PURPLE_DARKEN_1;

      case "PURPLE DARKEN 2":
        return Color.PURPLE_DARKEN_2;

      case "PURPLE DARKEN 3":
        return Color.PURPLE_DARKEN_3;

      case "PURPLE DARKEN 4":
        return Color.PURPLE_DARKEN_4;

      case "PURPLE LIGHTEN 1":
        return Color.PURPLE_LIGHTEN_1;

      case "PURPLE LIGHTEN 2":
        return Color.PURPLE_LIGHTEN_2;

      case "PURPLE LIGHTEN 3":
        return Color.PURPLE_LIGHTEN_3;

      case "PURPLE LIGHTEN 4":
        return Color.PURPLE_LIGHTEN_4;

      case "PURPLE LIGHTEN 5":
        return Color.PURPLE_LIGHTEN_5;

      case "DEEP PURPLE":
        return Color.DEEP_PURPLE;

      case "DEEP PURPLE DARKEN 1":
        return Color.DEEP_PURPLE_DARKEN_1;

      case "DEEP PURPLE DARKEN 2":
        return Color.DEEP_PURPLE_DARKEN_2;

      case "DEEP PURPLE DARKEN 3":
        return Color.DEEP_PURPLE_DARKEN_3;

      case "DEEP PURPLE DARKEN 4":
        return Color.DEEP_PURPLE_DARKEN_4;

      case "DEEP PURPLE LIGHTEN 1":
        return Color.DEEP_PURPLE_LIGHTEN_1;

      case "DEEP PURPLE LIGHTEN 2":
        return Color.DEEP_PURPLE_LIGHTEN_2;

      case "DEEP PURPLE LIGHTEN 3":
        return Color.DEEP_PURPLE_LIGHTEN_3;

      case "DEEP PURPLE LIGHTEN 4":
        return Color.DEEP_PURPLE_LIGHTEN_4;

      case "DEEP PURPLE LIGHTEN 5":
        return Color.DEEP_PURPLE_LIGHTEN_5;

      case "INDIGO":
        return Color.INDIGO;

      case "INDIGO DARKEN 1":
        return Color.INDIGO_DARKEN_1;

      case "INDIGO DARKEN 2":
        return Color.INDIGO_DARKEN_2;

      case "INDIGO DARKEN 3":
        return Color.INDIGO_DARKEN_3;

      case "INDIGO DARKEN 4":
        return Color.INDIGO_DARKEN_4;

      case "INDIGO LIGHTEN 1":
        return Color.INDIGO_LIGHTEN_1;

      case "INDIGO LIGHTEN 2":
        return Color.INDIGO_LIGHTEN_2;

      case "INDIGO LIGHTEN 3":
        return Color.INDIGO_LIGHTEN_3;

      case "INDIGO LIGHTEN 4":
        return Color.INDIGO_LIGHTEN_4;

      case "INDIGO LIGHTEN 5":
        return Color.INDIGO_LIGHTEN_5;

      case "BLUE":
        return Color.BLUE;

      case "BLUE DARKEN 1":
        return Color.BLUE_DARKEN_1;

      case "BLUE DARKEN 2":
        return Color.BLUE_DARKEN_2;

      case "BLUE DARKEN 3":
        return Color.BLUE_DARKEN_3;

      case "BLUE DARKEN 4":
        return Color.BLUE_DARKEN_4;

      case "BLUE LIGHTEN 1":
        return Color.BLUE_LIGHTEN_1;

      case "BLUE LIGHTEN 2":
        return Color.BLUE_LIGHTEN_2;

      case "BLUE LIGHTEN 3":
        return Color.BLUE_LIGHTEN_3;

      case "BLUE LIGHTEN 4":
        return Color.BLUE_LIGHTEN_4;

      case "BLUE LIGHTEN 5":
        return Color.BLUE_LIGHTEN_5;

      case "LIGHT BLUE":
        return Color.LIGHT_BLUE;

      case "LIGHT BLUE DARKEN 1":
        return Color.LIGHT_BLUE_DARKEN_1;

      case "LIGHT BLUE DARKEN 2":
        return Color.LIGHT_BLUE_DARKEN_2;

      case "LIGHT BLUE DARKEN 3":
        return Color.LIGHT_BLUE_DARKEN_3;

      case "LIGHT BLUE DARKEN 4":
        return Color.LIGHT_BLUE_DARKEN_4;

      case "LIGHT BLUE LIGHTEN 1":
        return Color.LIGHT_BLUE_LIGHTEN_1;

      case "LIGHT BLUE LIGHTEN 2":
        return Color.LIGHT_BLUE_LIGHTEN_2;

      case "LIGHT BLUE LIGHTEN 3":
        return Color.LIGHT_BLUE_LIGHTEN_3;

      case "LIGHT BLUE LIGHTEN 4":
        return Color.LIGHT_BLUE_LIGHTEN_4;

      case "LIGHT BLUE LIGHTEN 5":
        return Color.LIGHT_BLUE_LIGHTEN_5;

      case "CYAN":
        return Color.CYAN;

      case "CYAN DARKEN 1":
        return Color.CYAN_DARKEN_1;

      case "CYAN DARKEN 2":
        return Color.CYAN_DARKEN_2;

      case "CYAN DARKEN 3":
        return Color.CYAN_DARKEN_3;

      case "CYAN DARKEN 4":
        return Color.CYAN_DARKEN_4;

      case "CYAN LIGHTEN 1":
        return Color.CYAN_LIGHTEN_1;

      case "CYAN LIGHTEN 2":
        return Color.CYAN_LIGHTEN_2;

      case "CYAN LIGHTEN 3":
        return Color.CYAN_LIGHTEN_3;

      case "CYAN LIGHTEN 4":
        return Color.CYAN_LIGHTEN_4;

      case "CYAN LIGHTEN 5":
        return Color.CYAN_LIGHTEN_5;

      case "TEAL":
        return Color.TEAL;

      case "TEAL DARKEN 1":
        return Color.TEAL_DARKEN_1;

      case "TEAL DARKEN 2":
        return Color.TEAL_DARKEN_2;

      case "TEAL DARKEN 3":
        return Color.TEAL_DARKEN_3;

      case "TEAL DARKEN 4":
        return Color.TEAL_DARKEN_4;

      case "TEAL LIGHTEN 1":
        return Color.TEAL_LIGHTEN_1;

      case "TEAL LIGHTEN 2":
        return Color.TEAL_LIGHTEN_2;

      case "TEAL LIGHTEN 3":
        return Color.TEAL_LIGHTEN_3;

      case "TEAL LIGHTEN 4":
        return Color.TEAL_LIGHTEN_4;

      case "TEAL LIGHTEN 5":
        return Color.TEAL_LIGHTEN_5;

      case "GREEN":
        return Color.GREEN;

      case "GREEN DARKEN 1":
        return Color.GREEN_DARKEN_1;

      case "GREEN DARKEN 2":
        return Color.GREEN_DARKEN_2;

      case "GREEN DARKEN 3":
        return Color.GREEN_DARKEN_3;

      case "GREEN DARKEN 4":
        return Color.GREEN_DARKEN_4;

      case "GREEN LIGHTEN 1":
        return Color.GREEN_LIGHTEN_1;

      case "GREEN LIGHTEN 2":
        return Color.GREEN_LIGHTEN_2;

      case "GREEN LIGHTEN 3":
        return Color.GREEN_LIGHTEN_3;

      case "GREEN LIGHTEN 4":
        return Color.GREEN_LIGHTEN_4;

      case "GREEN LIGHTEN 5":
        return Color.GREEN_LIGHTEN_5;

      case "LIGHT GREEN":
        return Color.LIGHT_GREEN;

      case "LIGHT GREEN DARKEN 1":
        return Color.LIGHT_GREEN_DARKEN_1;

      case "LIGHT GREEN DARKEN 2":
        return Color.LIGHT_GREEN_DARKEN_2;

      case "LIGHT GREEN DARKEN 3":
        return Color.LIGHT_GREEN_DARKEN_3;

      case "LIGHT GREEN DARKEN 4":
        return Color.LIGHT_GREEN_DARKEN_4;

      case "LIGHT GREEN LIGHTEN 1":
        return Color.LIGHT_GREEN_LIGHTEN_1;

      case "LIGHT GREEN LIGHTEN 2":
        return Color.LIGHT_GREEN_LIGHTEN_2;

      case "LIGHT GREEN LIGHTEN 3":
        return Color.LIGHT_GREEN_LIGHTEN_3;

      case "LIGHT GREEN LIGHTEN 4":
        return Color.LIGHT_GREEN_LIGHTEN_4;

      case "LIGHT GREEN LIGHTEN 5":
        return Color.LIGHT_GREEN_LIGHTEN_5;

      case "LIME":
        return Color.LIME;

      case "LIME DARKEN 1":
        return Color.LIME_DARKEN_1;

      case "LIME DARKEN 2":
        return Color.LIME_DARKEN_2;

      case "LIME DARKEN 3":
        return Color.LIME_DARKEN_3;

      case "LIME DARKEN 4":
        return Color.LIME_DARKEN_4;

      case "LIME LIGHTEN 1":
        return Color.LIME_LIGHTEN_1;

      case "LIME LIGHTEN 2":
        return Color.LIME_LIGHTEN_2;

      case "LIME LIGHTEN 3":
        return Color.LIME_LIGHTEN_3;

      case "LIME LIGHTEN 4":
        return Color.LIME_LIGHTEN_4;

      case "LIME LIGHTEN 5":
        return Color.LIME_LIGHTEN_5;

      case "YELLOW":
        return Color.YELLOW;

      case "YELLOW DARKEN 1":
        return Color.YELLOW_DARKEN_1;

      case "YELLOW DARKEN 2":
        return Color.YELLOW_DARKEN_2;

      case "YELLOW DARKEN 3":
        return Color.YELLOW_DARKEN_3;

      case "YELLOW DARKEN 4":
        return Color.YELLOW_DARKEN_4;

      case "YELLOW LIGHTEN 1":
        return Color.YELLOW_LIGHTEN_1;

      case "YELLOW LIGHTEN 2":
        return Color.YELLOW_LIGHTEN_2;

      case "YELLOW LIGHTEN 3":
        return Color.YELLOW_LIGHTEN_3;

      case "YELLOW LIGHTEN 4":
        return Color.YELLOW_LIGHTEN_4;

      case "YELLOW LIGHTEN 5":
        return Color.YELLOW_LIGHTEN_5;

      case "AMBER":
        return Color.AMBER;

      case "AMBER DARKEN 1":
        return Color.AMBER_DARKEN_1;

      case "AMBER DARKEN 2":
        return Color.AMBER_DARKEN_2;

      case "AMBER DARKEN 3":
        return Color.AMBER_DARKEN_3;

      case "AMBER DARKEN 4":
        return Color.AMBER_DARKEN_4;

      case "AMBER LIGHTEN 1":
        return Color.AMBER_LIGHTEN_1;

      case "AMBER LIGHTEN 2":
        return Color.AMBER_LIGHTEN_2;

      case "AMBER LIGHTEN 3":
        return Color.AMBER_LIGHTEN_3;

      case "AMBER LIGHTEN 4":
        return Color.AMBER_LIGHTEN_4;

      case "AMBER LIGHTEN 5":
        return Color.AMBER_LIGHTEN_5;

      case "ORANGE":
        return Color.ORANGE;

      case "ORANGE DARKEN 1":
        return Color.ORANGE_DARKEN_1;

      case "ORANGE DARKEN 2":
        return Color.ORANGE_DARKEN_2;

      case "ORANGE DARKEN 3":
        return Color.ORANGE_DARKEN_3;

      case "ORANGE DARKEN 4":
        return Color.ORANGE_DARKEN_4;

      case "ORANGE LIGHTEN 1":
        return Color.ORANGE_LIGHTEN_1;

      case "ORANGE LIGHTEN 2":
        return Color.ORANGE_LIGHTEN_2;

      case "ORANGE LIGHTEN 3":
        return Color.ORANGE_LIGHTEN_3;

      case "ORANGE LIGHTEN 4":
        return Color.ORANGE_LIGHTEN_4;

      case "ORANGE LIGHTEN 5":
        return Color.ORANGE_LIGHTEN_5;

      case "DEEP ORANGE":
        return Color.DEEP_ORANGE;

      case "DEEP ORANGE DARKEN 1":
        return Color.DEEP_ORANGE_DARKEN_1;

      case "DEEP ORANGE DARKEN 2":
        return Color.DEEP_ORANGE_DARKEN_2;

      case "DEEP ORANGE DARKEN 3":
        return Color.DEEP_ORANGE_DARKEN_3;

      case "DEEP ORANGE DARKEN 4":
        return Color.DEEP_ORANGE_DARKEN_4;

      case "DEEP ORANGE LIGHTEN 1":
        return Color.DEEP_ORANGE_LIGHTEN_1;

      case "DEEP ORANGE LIGHTEN 2":
        return Color.DEEP_ORANGE_LIGHTEN_2;

      case "DEEP ORANGE LIGHTEN 3":
        return Color.DEEP_ORANGE_LIGHTEN_3;

      case "DEEP ORANGE LIGHTEN 4":
        return Color.DEEP_ORANGE_LIGHTEN_4;

      case "DEEP ORANGE LIGHTEN 5":
        return Color.DEEP_ORANGE_LIGHTEN_5;

      case "BROWN":
        return Color.BROWN;

      case "BROWN DARKEN 1":
        return Color.BROWN_DARKEN_1;

      case "BROWN DARKEN 2":
        return Color.BROWN_DARKEN_2;

      case "BROWN DARKEN 3":
        return Color.BROWN_DARKEN_3;

      case "BROWN DARKEN 4":
        return Color.BROWN_DARKEN_4;

      case "BROWN LIGHTEN 1":
        return Color.BROWN_LIGHTEN_1;

      case "BROWN LIGHTEN 2":
        return Color.BROWN_LIGHTEN_2;

      case "BROWN LIGHTEN 3":
        return Color.BROWN_LIGHTEN_3;

      case "BROWN LIGHTEN 4":
        return Color.BROWN_LIGHTEN_4;

      case "BROWN LIGHTEN 5":
        return Color.BROWN_LIGHTEN_5;

      case "GREY":
        return Color.GREY;

      case "GREY DARKEN 1":
        return Color.GREY_DARKEN_1;

      case "GREY DARKEN 2":
        return Color.GREY_DARKEN_2;

      case "GREY DARKEN 3":
        return Color.GREY_DARKEN_3;

      case "GREY DARKEN 4":
        return Color.GREY_DARKEN_4;

      case "GREY LIGHTEN 1":
        return Color.GREY_LIGHTEN_1;

      case "GREY LIGHTEN 2":
        return Color.GREY_LIGHTEN_2;

      case "GREY LIGHTEN 3":
        return Color.GREY_LIGHTEN_3;

      case "GREY LIGHTEN 4":
        return Color.GREY_LIGHTEN_4;

      case "GREY LIGHTEN 5":
        return Color.GREY_LIGHTEN_5;

      case "BLUE GREY":
        return Color.BLUE_GREY;

      case "BLUE GREY DARKEN 1":
        return Color.BLUE_GREY_DARKEN_1;

      case "BLUE GREY DARKEN 2":
        return Color.BLUE_GREY_DARKEN_2;

      case "BLUE GREY DARKEN 3":
        return Color.BLUE_GREY_DARKEN_3;

      case "BLUE GREY DARKEN 4":
        return Color.BLUE_GREY_DARKEN_4;

      case "BLUE GREY LIGHTEN 1":
        return Color.BLUE_GREY_LIGHTEN_1;

      case "BLUE GREY LIGHTEN 2":
        return Color.BLUE_GREY_LIGHTEN_2;

      case "BLUE GREY LIGHTEN 3":
        return Color.BLUE_GREY_LIGHTEN_3;

      case "BLUE GREY LIGHTEN 4":
        return Color.BLUE_GREY_LIGHTEN_4;

      case "BLUE GREY LIGHTEN 5":
        return Color.BLUE_GREY_LIGHTEN_5;

      case "BLACK":
        return Color.BLACK;

      case "BLACK DARKEN 1":
        return Color.BLACK_DARKEN_1;

      case "BLACK DARKEN 2":
        return Color.BLACK_DARKEN_2;

      case "BLACK DARKEN 3":
        return Color.BLACK_DARKEN_3;

      case "BLACK DARKEN 4":
        return Color.BLACK_DARKEN_4;

      case "BLACK LIGHTEN 1":
        return Color.BLACK_LIGHTEN_1;

      case "BLACK LIGHTEN 2":
        return Color.BLACK_LIGHTEN_2;

      case "BLACK LIGHTEN 3":
        return Color.BLACK_LIGHTEN_3;

      case "BLACK LIGHTEN 4":
        return Color.BLACK_LIGHTEN_4;

      case "BLACK LIGHTEN 5":
        return Color.BLACK_LIGHTEN_5;

      case "WHITE":
        return Color.WHITE;

      case "WHITE DARKEN 1":
        return Color.WHITE_DARKEN_1;

      case "WHITE DARKEN 2":
        return Color.WHITE_DARKEN_2;

      case "WHITE DARKEN 3":
        return Color.WHITE_DARKEN_3;

      case "WHITE DARKEN 4":
        return Color.WHITE_DARKEN_4;

      case "WHITE LIGHTEN 1":
        return Color.WHITE_LIGHTEN_1;

      case "WHITE LIGHTEN 2":
        return Color.WHITE_LIGHTEN_2;

      case "WHITE LIGHTEN 3":
        return Color.WHITE_LIGHTEN_3;

      case "WHITE LIGHTEN 4":
        return Color.WHITE_LIGHTEN_4;

      case "WHITE LIGHTEN 5":
        return Color.WHITE_LIGHTEN_5;

      case "TRANSPARENT":
        return Color.TRANSPARENT;

      case "TRANSPARENT DARKEN 1":
        return Color.TRANSPARENT_DARKEN_1;

      case "TRANSPARENT DARKEN 2":
        return Color.TRANSPARENT_DARKEN_2;

      case "TRANSPARENT DARKEN 3":
        return Color.TRANSPARENT_DARKEN_3;

      case "TRANSPARENT DARKEN 4":
        return Color.TRANSPARENT_DARKEN_4;

      case "TRANSPARENT LIGHTEN 1":
        return Color.TRANSPARENT_LIGHTEN_1;

      case "TRANSPARENT LIGHTEN 2":
        return Color.TRANSPARENT_LIGHTEN_2;

      case "TRANSPARENT LIGHTEN 3":
        return Color.TRANSPARENT_LIGHTEN_3;

      case "TRANSPARENT LIGHTEN 4":
        return Color.TRANSPARENT_LIGHTEN_4;

      case "TRANSPARENT LIGHTEN 5":
        return Color.TRANSPARENT_LIGHTEN_5;
      default:
        throw new IllegalArgumentException("Color [" + name + "] not found!");
    }
  }
}
