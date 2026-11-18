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
    icons.add(new IconCatalogEntry<>("abacus", "TablerIcons.abacus()", tagIcons::abacus));
    icons.add(
        new IconCatalogEntry<>(
            "abacus-off", "TablerIcons.abacus_off()", tagIcons::abacus_off));
    icons.add(
        new IconCatalogEntry<>(
            "ampersand", "TablerIcons.ampersand()", tagIcons::ampersand));
    icons.add(
        new IconCatalogEntry<>(
            "backslash", "TablerIcons.backslash()", tagIcons::backslash));
    icons.add(new IconCatalogEntry<>("braces", "TablerIcons.braces()", tagIcons::braces));
    icons.add(
        new IconCatalogEntry<>(
            "braces-off", "TablerIcons.braces_off()", tagIcons::braces_off));
    icons.add(
        new IconCatalogEntry<>("brackets", "TablerIcons.brackets()", tagIcons::brackets));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain",
            "TablerIcons.brackets_contain()",
            tagIcons::brackets_contain));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain-end",
            "TablerIcons.brackets_contain_end()",
            tagIcons::brackets_contain_end));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-contain-start",
            "TablerIcons.brackets_contain_start()",
            tagIcons::brackets_contain_start));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-off", "TablerIcons.brackets_off()", tagIcons::brackets_off));
    icons.add(
        new IconCatalogEntry<>("decimal", "TablerIcons.decimal()", tagIcons::decimal));
    icons.add(new IconCatalogEntry<>("divide", "TablerIcons.divide()", tagIcons::divide));
    icons.add(new IconCatalogEntry<>("equal", "TablerIcons.equal()", tagIcons::equal));
    icons.add(
        new IconCatalogEntry<>(
            "equal-double", "TablerIcons.equal_double()", tagIcons::equal_double));
    icons.add(
        new IconCatalogEntry<>(
            "equal-not", "TablerIcons.equal_not()", tagIcons::equal_not));
    icons.add(
        new IconCatalogEntry<>("function", "TablerIcons.function()", tagIcons::function));
    icons.add(
        new IconCatalogEntry<>(
            "function-off", "TablerIcons.function_off()", tagIcons::function_off));
    icons.add(
        new IconCatalogEntry<>("infinity", "TablerIcons.infinity()", tagIcons::infinity));
    icons.add(
        new IconCatalogEntry<>(
            "infinity-2", "TablerIcons.infinity_2()", tagIcons::infinity_2));
    icons.add(
        new IconCatalogEntry<>(
            "infinity-off", "TablerIcons.infinity_off()", tagIcons::infinity_off));
    icons.add(new IconCatalogEntry<>("math", "TablerIcons.math()", tagIcons::math));
    icons.add(
        new IconCatalogEntry<>(
            "math-1-divide-2",
            "TablerIcons.math_1_divide_2()",
            tagIcons::math_1_divide_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-1-divide-3",
            "TablerIcons.math_1_divide_3()",
            tagIcons::math_1_divide_3));
    icons.add(
        new IconCatalogEntry<>("math-avg", "TablerIcons.math_avg()", tagIcons::math_avg));
    icons.add(
        new IconCatalogEntry<>("math-cos", "TablerIcons.math_cos()", tagIcons::math_cos));
    icons.add(
        new IconCatalogEntry<>("math-ctg", "TablerIcons.math_ctg()", tagIcons::math_ctg));
    icons.add(
        new IconCatalogEntry<>(
            "math-equal-greater",
            "TablerIcons.math_equal_greater()",
            tagIcons::math_equal_greater));
    icons.add(
        new IconCatalogEntry<>(
            "math-equal-lower",
            "TablerIcons.math_equal_lower()",
            tagIcons::math_equal_lower));
    icons.add(
        new IconCatalogEntry<>(
            "math-function", "TablerIcons.math_function()", tagIcons::math_function));
    icons.add(
        new IconCatalogEntry<>(
            "math-function-off",
            "TablerIcons.math_function_off()",
            tagIcons::math_function_off));
    icons.add(
        new IconCatalogEntry<>(
            "math-function-y",
            "TablerIcons.math_function_y()",
            tagIcons::math_function_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-greater", "TablerIcons.math_greater()", tagIcons::math_greater));
    icons.add(
        new IconCatalogEntry<>(
            "math-integral", "TablerIcons.math_integral()", tagIcons::math_integral));
    icons.add(
        new IconCatalogEntry<>(
            "math-integral-x",
            "TablerIcons.math_integral_x()",
            tagIcons::math_integral_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-integrals", "TablerIcons.math_integrals()", tagIcons::math_integrals));
    icons.add(
        new IconCatalogEntry<>(
            "math-lower", "TablerIcons.math_lower()", tagIcons::math_lower));
    icons.add(
        new IconCatalogEntry<>("math-max", "TablerIcons.math_max()", tagIcons::math_max));
    icons.add(
        new IconCatalogEntry<>(
            "math-max-min", "TablerIcons.math_max_min()", tagIcons::math_max_min));
    icons.add(
        new IconCatalogEntry<>("math-min", "TablerIcons.math_min()", tagIcons::math_min));
    icons.add(
        new IconCatalogEntry<>("math-not", "TablerIcons.math_not()", tagIcons::math_not));
    icons.add(
        new IconCatalogEntry<>("math-off", "TablerIcons.math_off()", tagIcons::math_off));
    icons.add(
        new IconCatalogEntry<>("math-pi", "TablerIcons.math_pi()", tagIcons::math_pi));
    icons.add(
        new IconCatalogEntry<>(
            "math-pi-divide-2",
            "TablerIcons.math_pi_divide_2()",
            tagIcons::math_pi_divide_2));
    icons.add(
        new IconCatalogEntry<>("math-sec", "TablerIcons.math_sec()", tagIcons::math_sec));
    icons.add(
        new IconCatalogEntry<>("math-sin", "TablerIcons.math_sin()", tagIcons::math_sin));
    icons.add(
        new IconCatalogEntry<>(
            "math-symbols", "TablerIcons.math_symbols()", tagIcons::math_symbols));
    icons.add(
        new IconCatalogEntry<>("math-tg", "TablerIcons.math_tg()", tagIcons::math_tg));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-2",
            "TablerIcons.math_x_divide_2()",
            tagIcons::math_x_divide_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-y",
            "TablerIcons.math_x_divide_y()",
            tagIcons::math_x_divide_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-divide-y-2",
            "TablerIcons.math_x_divide_y_2()",
            tagIcons::math_x_divide_y_2));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-floor-divide-y",
            "TablerIcons.math_x_floor_divide_y()",
            tagIcons::math_x_floor_divide_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-minus-x", "TablerIcons.math_x_minus_x()", tagIcons::math_x_minus_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-minus-y", "TablerIcons.math_x_minus_y()", tagIcons::math_x_minus_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-plus-x", "TablerIcons.math_x_plus_x()", tagIcons::math_x_plus_x));
    icons.add(
        new IconCatalogEntry<>(
            "math-x-plus-y", "TablerIcons.math_x_plus_y()", tagIcons::math_x_plus_y));
    icons.add(
        new IconCatalogEntry<>("math-xy", "TablerIcons.math_xy()", tagIcons::math_xy));
    icons.add(
        new IconCatalogEntry<>(
            "math-y-minus-y", "TablerIcons.math_y_minus_y()", tagIcons::math_y_minus_y));
    icons.add(
        new IconCatalogEntry<>(
            "math-y-plus-y", "TablerIcons.math_y_plus_y()", tagIcons::math_y_plus_y));
    icons.add(new IconCatalogEntry<>("matrix", "TablerIcons.matrix()", tagIcons::matrix));
    icons.add(new IconCatalogEntry<>("minus", "TablerIcons.minus()", tagIcons::minus));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-0-5x",
            "TablerIcons.multiplier_0_5x()",
            tagIcons::multiplier_0_5x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-1-5x",
            "TablerIcons.multiplier_1_5x()",
            tagIcons::multiplier_1_5x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-1x", "TablerIcons.multiplier_1x()", tagIcons::multiplier_1x));
    icons.add(
        new IconCatalogEntry<>(
            "multiplier-2x", "TablerIcons.multiplier_2x()", tagIcons::multiplier_2x));
    icons.add(new IconCatalogEntry<>("omega", "TablerIcons.omega()", tagIcons::omega));
    icons.add(
        new IconCatalogEntry<>(
            "parentheses", "TablerIcons.parentheses()", tagIcons::parentheses));
    icons.add(
        new IconCatalogEntry<>(
            "parentheses-off",
            "TablerIcons.parentheses_off()",
            tagIcons::parentheses_off));
    icons.add(
        new IconCatalogEntry<>("pendulum", "TablerIcons.pendulum()", tagIcons::pendulum));
    icons.add(
        new IconCatalogEntry<>(
            "percentage", "TablerIcons.percentage()", tagIcons::percentage));
    icons.add(new IconCatalogEntry<>("plus", "TablerIcons.plus()", tagIcons::plus));
    icons.add(
        new IconCatalogEntry<>(
            "plus-equal", "TablerIcons.plus_equal()", tagIcons::plus_equal));
    icons.add(
        new IconCatalogEntry<>(
            "plus-minus", "TablerIcons.plus_minus()", tagIcons::plus_minus));
    icons.add(new IconCatalogEntry<>("slash", "TablerIcons.slash()", tagIcons::slash));
    icons.add(
        new IconCatalogEntry<>(
            "square-root", "TablerIcons.square_root()", tagIcons::square_root));
    icons.add(
        new IconCatalogEntry<>(
            "square-root-2", "TablerIcons.square_root_2()", tagIcons::square_root_2));
    icons.add(new IconCatalogEntry<>("sum", "TablerIcons.sum()", tagIcons::sum));
    icons.add(
        new IconCatalogEntry<>("sum-off", "TablerIcons.sum_off()", tagIcons::sum_off));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-1", "TablerIcons.tallymark_1()", tagIcons::tallymark_1));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-2", "TablerIcons.tallymark_2()", tagIcons::tallymark_2));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-3", "TablerIcons.tallymark_3()", tagIcons::tallymark_3));
    icons.add(
        new IconCatalogEntry<>(
            "tallymark-4", "TablerIcons.tallymark_4()", tagIcons::tallymark_4));
    icons.add(
        new IconCatalogEntry<>(
            "tallymarks", "TablerIcons.tallymarks()", tagIcons::tallymarks));
    icons.add(
        new IconCatalogEntry<>("variable", "TablerIcons.variable()", tagIcons::variable));
    icons.add(
        new IconCatalogEntry<>(
            "variable-minus", "TablerIcons.variable_minus()", tagIcons::variable_minus));
    icons.add(
        new IconCatalogEntry<>(
            "variable-off", "TablerIcons.variable_off()", tagIcons::variable_off));
    icons.add(
        new IconCatalogEntry<>(
            "variable-plus", "TablerIcons.variable_plus()", tagIcons::variable_plus));
    icons.add(
        new IconCatalogEntry<>(
            "x-power-y", "TablerIcons.x_power_y()", tagIcons::x_power_y));
    icons.add(
        new IconCatalogEntry<>(
            "function", "TablerIcons.function_filled()", tagIcons::function_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plus", "TablerIcons.plus_filled()", tagIcons::plus_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
