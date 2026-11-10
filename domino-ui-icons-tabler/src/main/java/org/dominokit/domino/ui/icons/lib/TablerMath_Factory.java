/*
 * Copyright © 2026 Dominokit
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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerMath;

/** Static icon factory for the Tabler Math category. */
public final class TablerMath_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerMath tagIcons = new TablerMath() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "abacus (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.ABACUS)",
            tagIcons::abacus));
    icons.add(
        new IconCatalogEntry<>(
            "abacus-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.ABACUS_OFF)",
            tagIcons::abacus_off));
    icons.add(
        new IconCatalogEntry<>(
            "ampersand (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.AMPERSAND)",
            tagIcons::ampersand));
    icons.add(
        new IconCatalogEntry<>(
            "backslash (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BACKSLASH)",
            tagIcons::backslash));
    icons.add(
        new IconCatalogEntry<>(
            "braces (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACES)",
            tagIcons::braces));
    icons.add(
        new IconCatalogEntry<>(
            "braces-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACES_OFF)",
            tagIcons::braces_off));
    icons.add(
        new IconCatalogEntry<>(
            "brackets (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACKETS)",
            tagIcons::brackets));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN)",
            tagIcons::brackets_contain));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain-end (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN_END)",
            tagIcons::brackets_contain_end));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain-start (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN_START)",
            tagIcons::brackets_contain_start));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_OFF)",
            tagIcons::brackets_off));
    icons.add(
        new IconCatalogEntry<>(
            "decimal (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.DECIMAL)",
            tagIcons::decimal));
    icons.add(
        new IconCatalogEntry<>(
            "divide (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.DIVIDE)",
            tagIcons::divide));
    icons.add(
        new IconCatalogEntry<>(
            "equal (outline)", "TablerIcon.create(TablerMath.OutlineIcon.EQUAL)", tagIcons::equal));
    icons.add(
        new IconCatalogEntry<>(
            "equal-double (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.EQUAL_DOUBLE)",
            tagIcons::equal_double));
    icons.add(
        new IconCatalogEntry<>(
            "equal-not (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.EQUAL_NOT)",
            tagIcons::equal_not));
    icons.add(
        new IconCatalogEntry<>(
            "function (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.FUNCTION)",
            tagIcons::function));
    icons.add(
        new IconCatalogEntry<>(
            "function-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.FUNCTION_OFF)",
            tagIcons::function_off));
    icons.add(
        new IconCatalogEntry<>(
            "infinity (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.INFINITY)",
            tagIcons::infinity));
    icons.add(
        new IconCatalogEntry<>(
            "infinity-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.INFINITY_2)",
            tagIcons::infinity_2));
    icons.add(
        new IconCatalogEntry<>(
            "infinity-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.INFINITY_OFF)",
            tagIcons::infinity_off));
    icons.add(
        new IconCatalogEntry<>(
            "math (outline)", "TablerIcon.create(TablerMath.OutlineIcon.MATH)", tagIcons::math));
    icons.add(
        new IconCatalogEntry<>(
            "math-1-divide-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_1_DIVIDE_2)",
            tagIcons::math_1_divide_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-1-divide-3 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_1_DIVIDE_3)",
            tagIcons::math_1_divide_3));
    icons.add(
        new IconCatalogEntry<>(
            "math-avg (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_AVG)",
            tagIcons::math_avg));
    icons.add(
        new IconCatalogEntry<>(
            "math-cos (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_COS)",
            tagIcons::math_cos));
    icons.add(
        new IconCatalogEntry<>(
            "math-ctg (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_CTG)",
            tagIcons::math_ctg));
    icons.add(
        new IconCatalogEntry<>(
            "math-equal-greater (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_EQUAL_GREATER)",
            tagIcons::math_equal_greater));
    icons.add(
        new IconCatalogEntry<>(
            "math-equal-lower (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_EQUAL_LOWER)",
            tagIcons::math_equal_lower));
    icons.add(
        new IconCatalogEntry<>(
            "math-function (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION)",
            tagIcons::math_function));
    icons.add(
        new IconCatalogEntry<>(
            "math-function-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION_OFF)",
            tagIcons::math_function_off));
    icons.add(
        new IconCatalogEntry<>(
            "math-function-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION_Y)",
            tagIcons::math_function_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-greater (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_GREATER)",
            tagIcons::math_greater));
    icons.add(
        new IconCatalogEntry<>(
            "math-integral (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRAL)",
            tagIcons::math_integral));
    icons.add(
        new IconCatalogEntry<>(
            "math-integral-x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRAL_X)",
            tagIcons::math_integral_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-integrals (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRALS)",
            tagIcons::math_integrals));
    icons.add(
        new IconCatalogEntry<>(
            "math-lower (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_LOWER)",
            tagIcons::math_lower));
    icons.add(
        new IconCatalogEntry<>(
            "math-max (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_MAX)",
            tagIcons::math_max));
    icons.add(
        new IconCatalogEntry<>(
            "math-max-min (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_MAX_MIN)",
            tagIcons::math_max_min));
    icons.add(
        new IconCatalogEntry<>(
            "math-min (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_MIN)",
            tagIcons::math_min));
    icons.add(
        new IconCatalogEntry<>(
            "math-not (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_NOT)",
            tagIcons::math_not));
    icons.add(
        new IconCatalogEntry<>(
            "math-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_OFF)",
            tagIcons::math_off));
    icons.add(
        new IconCatalogEntry<>(
            "math-pi (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_PI)",
            tagIcons::math_pi));
    icons.add(
        new IconCatalogEntry<>(
            "math-pi-divide-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_PI_DIVIDE_2)",
            tagIcons::math_pi_divide_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-sec (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_SEC)",
            tagIcons::math_sec));
    icons.add(
        new IconCatalogEntry<>(
            "math-sin (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_SIN)",
            tagIcons::math_sin));
    icons.add(
        new IconCatalogEntry<>(
            "math-symbols (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_SYMBOLS)",
            tagIcons::math_symbols));
    icons.add(
        new IconCatalogEntry<>(
            "math-tg (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_TG)",
            tagIcons::math_tg));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_2)",
            tagIcons::math_x_divide_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_Y)",
            tagIcons::math_x_divide_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-y-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_Y_2)",
            tagIcons::math_x_divide_y_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-floor-divide-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_FLOOR_DIVIDE_Y)",
            tagIcons::math_x_floor_divide_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-minus-x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_MINUS_X)",
            tagIcons::math_x_minus_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-minus-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_MINUS_Y)",
            tagIcons::math_x_minus_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-plus-x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_PLUS_X)",
            tagIcons::math_x_plus_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-plus-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_X_PLUS_Y)",
            tagIcons::math_x_plus_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-xy (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_XY)",
            tagIcons::math_xy));
    icons.add(
        new IconCatalogEntry<>(
            "math-y-minus-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_Y_MINUS_Y)",
            tagIcons::math_y_minus_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-y-plus-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATH_Y_PLUS_Y)",
            tagIcons::math_y_plus_y));
    icons.add(
        new IconCatalogEntry<>(
            "matrix (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MATRIX)",
            tagIcons::matrix));
    icons.add(
        new IconCatalogEntry<>(
            "minus (outline)", "TablerIcon.create(TablerMath.OutlineIcon.MINUS)", tagIcons::minus));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-0-5x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_0_5X)",
            tagIcons::multiplier_0_5x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-1-5x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_1_5X)",
            tagIcons::multiplier_1_5x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-1x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_1X)",
            tagIcons::multiplier_1x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-2x (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_2X)",
            tagIcons::multiplier_2x));
    icons.add(
        new IconCatalogEntry<>(
            "omega (outline)", "TablerIcon.create(TablerMath.OutlineIcon.OMEGA)", tagIcons::omega));
    icons.add(
        new IconCatalogEntry<>(
            "parentheses (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PARENTHESES)",
            tagIcons::parentheses));
    icons.add(
        new IconCatalogEntry<>(
            "parentheses-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PARENTHESES_OFF)",
            tagIcons::parentheses_off));
    icons.add(
        new IconCatalogEntry<>(
            "pendulum (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PENDULUM)",
            tagIcons::pendulum));
    icons.add(
        new IconCatalogEntry<>(
            "percentage (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PERCENTAGE)",
            tagIcons::percentage));
    icons.add(
        new IconCatalogEntry<>(
            "plus (outline)", "TablerIcon.create(TablerMath.OutlineIcon.PLUS)", tagIcons::plus));
    icons.add(
        new IconCatalogEntry<>(
            "plus-equal (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PLUS_EQUAL)",
            tagIcons::plus_equal));
    icons.add(
        new IconCatalogEntry<>(
            "plus-minus (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.PLUS_MINUS)",
            tagIcons::plus_minus));
    icons.add(
        new IconCatalogEntry<>(
            "slash (outline)", "TablerIcon.create(TablerMath.OutlineIcon.SLASH)", tagIcons::slash));
    icons.add(
        new IconCatalogEntry<>(
            "square-root (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.SQUARE_ROOT)",
            tagIcons::square_root));
    icons.add(
        new IconCatalogEntry<>(
            "square-root-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.SQUARE_ROOT_2)",
            tagIcons::square_root_2));
    icons.add(
        new IconCatalogEntry<>(
            "sum (outline)", "TablerIcon.create(TablerMath.OutlineIcon.SUM)", tagIcons::sum));
    icons.add(
        new IconCatalogEntry<>(
            "sum-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.SUM_OFF)",
            tagIcons::sum_off));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-1 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_1)",
            tagIcons::tallymark_1));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-2 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_2)",
            tagIcons::tallymark_2));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-3 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_3)",
            tagIcons::tallymark_3));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-4 (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_4)",
            tagIcons::tallymark_4));
    icons.add(
        new IconCatalogEntry<>(
            "tallymarks (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.TALLYMARKS)",
            tagIcons::tallymarks));
    icons.add(
        new IconCatalogEntry<>(
            "variable (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.VARIABLE)",
            tagIcons::variable));
    icons.add(
        new IconCatalogEntry<>(
            "variable-minus (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_MINUS)",
            tagIcons::variable_minus));
    icons.add(
        new IconCatalogEntry<>(
            "variable-off (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_OFF)",
            tagIcons::variable_off));
    icons.add(
        new IconCatalogEntry<>(
            "variable-plus (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_PLUS)",
            tagIcons::variable_plus));
    icons.add(
        new IconCatalogEntry<>(
            "x-power-y (outline)",
            "TablerIcon.create(TablerMath.OutlineIcon.X_POWER_Y)",
            tagIcons::x_power_y));
    icons.add(
        new IconCatalogEntry<>(
            "function (filled)",
            "TablerIcon.create(TablerMath.FilledIcon.FUNCTION)",
            tagIcons::function_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plus (filled)",
            "TablerIcon.create(TablerMath.FilledIcon.PLUS)",
            tagIcons::plus_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
