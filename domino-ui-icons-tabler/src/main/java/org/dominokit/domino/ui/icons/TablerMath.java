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
package org.dominokit.domino.ui.icons;

/** Tabler Math catalog category. */
public interface TablerMath {
  enum OutlineIcon implements TablerIconDefinition {
    ABACUS(
        "abacus",
        "<path d=\"M5 3v18\" />\n  <path d=\"M19 21v-18\" />\n  <path d=\"M5 7h14\" />\n  <path d=\"M5 15h14\" />\n  <path d=\"M8 13v4\" />\n  <path d=\"M11 13v4\" />\n  <path d=\"M16 13v4\" />\n  <path d=\"M14 5v4\" />\n  <path d=\"M11 5v4\" />\n  <path d=\"M8 5v4\" />\n  <path d=\"M3 21h18\" />"),
    ABACUS_OFF(
        "abacus-off",
        "<path d=\"M5 5v16\" />\n  <path d=\"M19 21v-2m0 -4v-12\" />\n  <path d=\"M5 7h2m4 0h8\" />\n  <path d=\"M5 15h10\" />\n  <path d=\"M8 13v4\" />\n  <path d=\"M11 13v4\" />\n  <path d=\"M16 16v1\" />\n  <path d=\"M14 5v4\" />\n  <path d=\"M11 5v2\" />\n  <path d=\"M8 8v1\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M3 3l18 18\" />"),
    AMPERSAND(
        "ampersand",
        "<path d=\"M19 20l-10.403 -10.972a2.948 2.948 0 0 1 0 -4.165a2.94 2.94 0 0 1 4.161 0a2.948 2.948 0 0 1 0 4.165l-4.68 4.687a3.685 3.685 0 0 0 0 5.207a3.675 3.675 0 0 0 5.2 0l5.722 -5.922\" />"),
    BACKSLASH("backslash", "<path d=\"M7 5l10 14\" />"),
    BRACES(
        "braces",
        "<path d=\"M7 4a2 2 0 0 0 -2 2v3a2 3 0 0 1 -2 3a2 3 0 0 1 2 3v3a2 2 0 0 0 2 2\" />\n  <path d=\"M17 4a2 2 0 0 1 2 2v3a2 3 0 0 0 2 3a2 3 0 0 0 -2 3v3a2 2 0 0 1 -2 2\" />"),
    BRACES_OFF(
        "braces-off",
        "<path d=\"M5.176 5.177c-.113 .251 -.176 .53 -.176 .823v3c0 1.657 -.895 3 -2 3c1.105 0 2 1.343 2 3v3a2 2 0 0 0 2 2\" />\n  <path d=\"M17 4a2 2 0 0 1 2 2v3c0 1.657 .895 3 2 3c-1.105 0 -2 1.343 -2 3m-.176 3.821a2 2 0 0 1 -1.824 1.179\" />\n  <path d=\"M3 3l18 18\" />"),
    BRACKETS("brackets", "<path d=\"M8 4h-3v16h3\" />\n  <path d=\"M16 4h3v16h-3\" />"),
    BRACKETS_CONTAIN(
        "brackets-contain",
        "<path d=\"M7 4h-4v16h4\" />\n  <path d=\"M17 4h4v16h-4\" />\n  <path d=\"M8 16h.01\" />\n  <path d=\"M12 16h.01\" />\n  <path d=\"M16 16h.01\" />"),
    BRACKETS_CONTAIN_END(
        "brackets-contain-end",
        "<path d=\"M14 4h4v16h-4\" />\n  <path d=\"M5 16h.01\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M13 16h.01\" />"),
    BRACKETS_CONTAIN_START(
        "brackets-contain-start",
        "<path d=\"M9 4h-4v16h4\" />\n  <path d=\"M18 16h-.01\" />\n  <path d=\"M14 16h-.01\" />\n  <path d=\"M10 16h-.01\" />"),
    BRACKETS_OFF(
        "brackets-off",
        "<path d=\"M5 5v15h3\" />\n  <path d=\"M16 4h3v11m0 4v1h-3\" />\n  <path d=\"M3 3l18 18\" />"),
    DECIMAL(
        "decimal",
        "<path d=\"M17 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M10 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M5 16h.01\" />"),
    DIVIDE(
        "divide",
        "<path d=\"M11 6a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" fill=\"currentColor\" />\n  <path d=\"M11 18a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" fill=\"currentColor\" />\n  <path d=\"M5 12l14 0\" />"),
    EQUAL("equal", "<path d=\"M5 10h14\" />\n  <path d=\"M5 14h14\" />"),
    EQUAL_DOUBLE(
        "equal-double",
        "<path d=\"M3 10h7\" />\n  <path d=\"M3 14h7\" />\n  <path d=\"M14 10h7\" />\n  <path d=\"M14 14h7\" />"),
    EQUAL_NOT(
        "equal-not",
        "<path d=\"M5 10h14\" />\n  <path d=\"M5 14h14\" />\n  <path d=\"M5 19l14 -14\" />"),
    FUNCTION(
        "function",
        "<path d=\"M4 6.667a2.667 2.667 0 0 1 2.667 -2.667h10.666a2.667 2.667 0 0 1 2.667 2.667v10.666a2.667 2.667 0 0 1 -2.667 2.667h-10.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -10.666\" />\n  <path d=\"M9 15.5v.25c0 .69 .56 1.25 1.25 1.25c.71 0 1.304 -.538 1.374 -1.244l.752 -7.512a1.381 1.381 0 0 1 1.374 -1.244c.69 0 1.25 .56 1.25 1.25v.25\" />\n  <path d=\"M9 12h6\" />"),
    FUNCTION_OFF(
        "function-off",
        "<path d=\"M9 15.5v.25c0 .69 .56 1.25 1.25 1.25a1.38 1.38 0 0 0 1.374 -1.244l.376 -3.756m.363 -3.63l.013 -.126a1.38 1.38 0 0 1 1.374 -1.244c.69 0 1.25 .56 1.25 1.25v.25\" />\n  <path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M9 12h3\" />\n  <path d=\"M3 3l18 18\" />"),
    INFINITY(
        "infinity",
        "<path d=\"M9.828 9.172a4 4 0 1 0 0 5.656a10 10 0 0 0 2.172 -2.828a10 10 0 0 1 2.172 -2.828a4 4 0 1 1 0 5.656a10 10 0 0 1 -2.172 -2.828a10 10 0 0 0 -2.172 -2.828\" />"),
    INFINITY_2(
        "infinity-2",
        "<path d=\"M13.94 9.39a10 10 0 0 1 .232 -.218a4 4 0 1 1 0 5.656a10 10 0 0 1 -2.172 -2.828a10 10 0 0 0 -2.172 -2.828a4 4 0 1 0 0 5.656a10 10 0 0 0 .234 -.219\" />"),
    INFINITY_OFF(
        "infinity-off",
        "<path d=\"M8.165 8.174a4 4 0 0 0 -5.166 3.826a4 4 0 0 0 6.829 2.828a10 10 0 0 0 2.172 -2.828m1.677 -2.347a10 10 0 0 1 .495 -.481a4 4 0 1 1 5.129 6.1m-3.521 .537a4 4 0 0 1 -1.608 -.981a10 10 0 0 1 -2.172 -2.828\" />\n  <path d=\"M3 3l18 18\" />"),
    MATH(
        "math",
        "<path d=\"M19 5h-7l-4 14l-3 -6h-2\" />\n  <path d=\"M14 13l6 6\" />\n  <path d=\"M14 19l6 -6\" />"),
    MATH_1_DIVIDE_2(
        "math-1-divide-2",
        "<path d=\"M5 12h14\" />\n  <path d=\"M10 15h3a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-2a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h3\" />\n  <path d=\"M10 5l2 -2v6\" />"),
    MATH_1_DIVIDE_3(
        "math-1-divide-3",
        "<path d=\"M10 15.5a.5 .5 0 0 1 .5 -.5h2a1.5 1.5 0 0 1 0 3h-1.167h1.167a1.5 1.5 0 0 1 0 3h-2a.5 .5 0 0 1 -.5 -.5\" />\n  <path d=\"M5 12h14\" />\n  <path d=\"M10 5l2 -2v6\" />"),
    MATH_AVG(
        "math-avg",
        "<path d=\"M3 21l18 -18\" />\n  <path d=\"M4 12a8 8 0 1 0 16 0a8 8 0 1 0 -16 0\" />"),
    MATH_COS(
        "math-cos",
        "<path d=\"M7 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />\n  <path d=\"M12 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 15c.345 .6 1.258 1 2 1a2 2 0 1 0 0 -4a2 2 0 1 1 0 -4c.746 0 1.656 .394 2 1\" />"),
    MATH_CTG(
        "math-ctg",
        "<path d=\"M10 8h4\" />\n  <path d=\"M21 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M7 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />"),
    MATH_EQUAL_GREATER(
        "math-equal-greater", "<path d=\"M5 18l14 -4\" />\n  <path d=\"M5 14l14 -4l-14 -4\" />"),
    MATH_EQUAL_LOWER(
        "math-equal-lower", "<path d=\"M19 18l-14 -4\" />\n  <path d=\"M19 14l-14 -4l14 -4\" />"),
    MATH_FUNCTION(
        "math-function",
        "<path d=\"M3 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />\n  <path d=\"M5 12h6\" />\n  <path d=\"M15 12l6 6\" />\n  <path d=\"M15 18l6 -6\" />"),
    MATH_FUNCTION_OFF(
        "math-function-off",
        "<path d=\"M14 10h1c.882 0 .986 .777 1.694 2.692\" />\n  <path d=\"M13 17c.864 0 1.727 -.663 2.495 -1.512m1.717 -2.302c.993 -1.45 2.39 -3.186 3.788 -3.186\" />\n  <path d=\"M3 19c0 1.5 .5 2 2 2s2 -4 3 -9c.237 -1.186 .446 -2.317 .647 -3.35m.727 -3.248c.423 -1.492 .91 -2.402 1.626 -2.402c1.5 0 2 .5 2 2\" />\n  <path d=\"M5 12h6\" />\n  <path d=\"M3 3l18 18\" />"),
    MATH_FUNCTION_Y(
        "math-function-y",
        "<path d=\"M3 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />\n  <path d=\"M5 12h6\" />\n  <path d=\"M15 12l3 5.063\" />\n  <path d=\"M21 12l-4.8 9\" />"),
    MATH_GREATER("math-greater", "<path d=\"M5 18l14 -6l-14 -6\" />"),
    MATH_INTEGRAL(
        "math-integral",
        "<path d=\"M7 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />"),
    MATH_INTEGRAL_X(
        "math-integral-x",
        "<path d=\"M3 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />\n  <path d=\"M14 12l6 6\" />\n  <path d=\"M14 18l6 -6\" />"),
    MATH_INTEGRALS(
        "math-integrals",
        "<path d=\"M3 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />\n  <path d=\"M11 19a2 2 0 0 0 2 2c2 0 2 -4 3 -9s1 -9 3 -9a2 2 0 0 1 2 2\" />"),
    MATH_LOWER("math-lower", "<path d=\"M19 18l-14 -6l14 -6\" />"),
    MATH_MAX(
        "math-max",
        "<path d=\"M5 6a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M3 15s.616 -5.544 2.332 -7.93\" />\n  <path d=\"M8.637 7.112c2.717 3.313 5.882 12.888 8.363 12.888c2 0 3.333 -3 4 -9\" />"),
    MATH_MAX_MIN(
        "math-max-min",
        "<path d=\"M15 19a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M5 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M3 14s.605 -5.44 2.284 -7.862m3.395 .026c2.137 2.652 4.547 9.113 6.68 11.719\" />\n  <path d=\"M18.748 18.038c.702 -.88 1.452 -3.56 2.252 -8.038\" />"),
    MATH_MIN(
        "math-min",
        "<path d=\"M15 18a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M3 13s1 -9 4 -9c2.48 0 5.643 9.565 8.36 12.883\" />\n  <path d=\"M18.748 17.038c.702 -.88 1.452 -3.56 2.252 -8.038\" />"),
    MATH_NOT("math-not", "<path d=\"M5 12h14v4\" />"),
    MATH_OFF(
        "math-off",
        "<path d=\"M14 19l2.5 -2.5\" />\n  <path d=\"M18.5 14.5l1.5 -1.5\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M19 5h-7l-.646 2.262\" />\n  <path d=\"M10.448 10.431l-2.448 8.569l-3 -6h-2\" />"),
    MATH_PI(
        "math-pi",
        "<path d=\"M7 20v-16\" />\n  <path d=\"M17 4v16\" />\n  <path d=\"M20 4h-16\" />"),
    MATH_PI_DIVIDE_2(
        "math-pi-divide-2",
        "<path d=\"M10 15h3a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-2a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h3\" />\n  <path d=\"M5 12h14\" />\n  <path d=\"M10 9v-6\" />\n  <path d=\"M14 3v6\" />\n  <path d=\"M15 3h-6\" />"),
    MATH_SEC(
        "math-sec",
        "<path d=\"M3 15c.345 .6 1.258 1 2 1a2 2 0 1 0 0 -4a2 2 0 1 1 0 -4c.746 0 1.656 .394 2 1\" />\n  <path d=\"M21 10a2 2 0 1 0 -4 0v4a2 2 0 1 0 4 0\" />\n  <path d=\"M14 8h-4v8h4\" />\n  <path d=\"M10 12h2.5\" />"),
    MATH_SIN(
        "math-sin",
        "<path d=\"M4 15c.345 .6 1.258 1 2 1a2 2 0 1 0 0 -4a2 2 0 1 1 0 -4c.746 0 1.656 .394 2 1\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M16 16v-8l4 8v-8\" />"),
    MATH_SYMBOLS(
        "math-symbols",
        "<path d=\"M3 12l18 0\" />\n  <path d=\"M12 3l0 18\" />\n  <path d=\"M16.5 4.5l3 3\" />\n  <path d=\"M19.5 4.5l-3 3\" />\n  <path d=\"M6 4l0 4\" />\n  <path d=\"M4 6l4 0\" />\n  <path d=\"M18 16l.01 0\" />\n  <path d=\"M18 20l.01 0\" />\n  <path d=\"M4 18l4 0\" />"),
    MATH_TG(
        "math-tg",
        "<path d=\"M7 8h4\" />\n  <path d=\"M9 8v8\" />\n  <path d=\"M18 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />"),
    MATH_X_DIVIDE_2(
        "math-x-divide-2",
        "<path d=\"M10 15h3a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-2a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h3\" />\n  <path d=\"M5 12h14\" />\n  <path d=\"M9 3l6 6\" />\n  <path d=\"M9 9l6 -6\" />"),
    MATH_X_DIVIDE_Y(
        "math-x-divide-y",
        "<path d=\"M9 3l6 6\" />\n  <path d=\"M9 9l6 -6\" />\n  <path d=\"M9 15l3 4.5\" />\n  <path d=\"M15 15l-4.5 7\" />\n  <path d=\"M5 12h14\" />"),
    MATH_X_DIVIDE_Y_2(
        "math-x-divide-y-2",
        "<path d=\"M3 21l18 -18\" />\n  <path d=\"M15 14l3 4.5\" />\n  <path d=\"M21 14l-4.5 7\" />\n  <path d=\"M3 4l6 6\" />\n  <path d=\"M3 10l6 -6\" />"),
    MATH_X_FLOOR_DIVIDE_Y(
        "math-x-floor-divide-y",
        "<path d=\"M1.5 19l18 -18\" />\n  <path d=\"M4.5 22l18 -18\" />\n  <path d=\"M18 15l3 4\" />\n  <path d=\"M23 15l-4.5 8\" />\n  <path d=\"M1 1l6 6\" />\n  <path d=\"M1 7l6 -6\" />"),
    MATH_X_MINUS_X(
        "math-x-minus-x",
        "<path d=\"M2 9l6 6\" />\n  <path d=\"M2 15l6 -6\" />\n  <path d=\"M16 9l6 6\" />\n  <path d=\"M16 15l6 -6\" />\n  <path d=\"M10 12h4\" />"),
    MATH_X_MINUS_Y(
        "math-x-minus-y",
        "<path d=\"M2 9l6 6\" />\n  <path d=\"M2 15l6 -6\" />\n  <path d=\"M16 9l3 5.063\" />\n  <path d=\"M22 9l-4.8 9\" />\n  <path d=\"M10 12h4\" />"),
    MATH_X_PLUS_X(
        "math-x-plus-x",
        "<path d=\"M2 9l6 6\" />\n  <path d=\"M2 15l6 -6\" />\n  <path d=\"M16 9l6 6\" />\n  <path d=\"M16 15l6 -6\" />\n  <path d=\"M10 12h4\" />\n  <path d=\"M12 10v4\" />"),
    MATH_X_PLUS_Y(
        "math-x-plus-y",
        "<path d=\"M16 9l3 5.063\" />\n  <path d=\"M2 9l6 6\" />\n  <path d=\"M2 15l6 -6\" />\n  <path d=\"M22 9l-4.8 9\" />\n  <path d=\"M10 12h4\" />\n  <path d=\"M12 10v4\" />"),
    MATH_XY(
        "math-xy",
        "<path d=\"M14 9l3 5.063\" />\n  <path d=\"M4 9l6 6\" />\n  <path d=\"M4 15l6 -6\" />\n  <path d=\"M20 9l-4.8 9\" />"),
    MATH_Y_MINUS_Y(
        "math-y-minus-y",
        "<path d=\"M2 9l3 5.063\" />\n  <path d=\"M8 9l-4.8 9\" />\n  <path d=\"M16 9l3 5.063\" />\n  <path d=\"M22 9l-4.8 9\" />\n  <path d=\"M10 12h4\" />"),
    MATH_Y_PLUS_Y(
        "math-y-plus-y",
        "<path d=\"M2 9l3 5.063\" />\n  <path d=\"M8 9l-4.8 9\" />\n  <path d=\"M16 9l3 5.063\" />\n  <path d=\"M22 9l-4.8 9\" />\n  <path d=\"M10 12h4\" />\n  <path d=\"M12 10v4\" />"),
    MATRIX(
        "matrix",
        "<path d=\"M8 16h.013\" />\n  <path d=\"M12.01 16h.005\" />\n  <path d=\"M16.015 16h.005\" />\n  <path d=\"M16.015 12h.005\" />\n  <path d=\"M8.01 12h.005\" />\n  <path d=\"M12.01 12h.005\" />\n  <path d=\"M16.02 8h.005\" />\n  <path d=\"M8.015 8h.005\" />\n  <path d=\"M12.015 8h.005\" />\n  <path d=\"M7 4h-1a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h1\" />\n  <path d=\"M17 4h1a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-1\" />"),
    MINUS("minus", "<path d=\"M5 12l14 0\" />"),
    MULTIPLIER_0_5X(
        "multiplier-0-5x",
        "<path d=\"M8 16h2a2 2 0 1 0 0 -4h-2v-4h4\" />\n  <path d=\"M5 16v.01\" />\n  <path d=\"M15 16l4 -4\" />\n  <path d=\"M19 16l-4 -4\" />"),
    MULTIPLIER_1_5X(
        "multiplier-1-5x",
        "<path d=\"M4 16v-8l-2 2\" />\n  <path d=\"M10 16h2a2 2 0 1 0 0 -4h-2v-4h4\" />\n  <path d=\"M7 16v.01\" />\n  <path d=\"M17 16l4 -4\" />\n  <path d=\"M21 16l-4 -4\" />"),
    MULTIPLIER_1X(
        "multiplier-1x",
        "<path d=\"M9 16v-8l-2 2\" />\n  <path d=\"M13 16l4 -4\" />\n  <path d=\"M17 16l-4 -4\" />"),
    MULTIPLIER_2X(
        "multiplier-2x",
        "<path d=\"M14 16l4 -4\" />\n  <path d=\"M18 16l-4 -4\" />\n  <path d=\"M6 10a2 2 0 1 1 4 0c0 .591 -.417 1.318 -.816 1.858l-3.184 4.143l4 0\" />"),
    OMEGA("omega", "<path d=\"M4 19h5v-1a7.35 7.35 0 1 1 6 0v1h5\" />"),
    PARENTHESES(
        "parentheses",
        "<path d=\"M7 4a12.25 12.25 0 0 0 0 16\" />\n  <path d=\"M17 4a12.25 12.25 0 0 1 0 16\" />"),
    PARENTHESES_OFF(
        "parentheses-off",
        "<path d=\"M5.743 5.745a12.253 12.253 0 0 0 1.257 14.255\" />\n  <path d=\"M17 4a12.25 12.25 0 0 1 2.474 11.467m-1.22 2.794a12.291 12.291 0 0 1 -1.254 1.739\" />\n  <path d=\"M3 3l18 18\" />"),
    PENDULUM(
        "pendulum",
        "<path d=\"M5 19a2 2 0 1 1 4 0a2 2 0 0 1 -4 0\" />\n  <path d=\"M12 3l-4.4 14.09\" />\n  <path d=\"M19 3h-14\" />"),
    PERCENTAGE(
        "percentage",
        "<path d=\"M16 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M6 7a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M6 18l12 -12\" />"),
    PLUS("plus", "<path d=\"M12 5l0 14\" />\n  <path d=\"M5 12l14 0\" />"),
    PLUS_EQUAL(
        "plus-equal",
        "<path d=\"M4 7h6\" />\n  <path d=\"M7 4v6\" />\n  <path d=\"M20 16h-6\" />\n  <path d=\"M20 19h-6\" />\n  <path d=\"M5 19l14 -14\" />"),
    PLUS_MINUS(
        "plus-minus",
        "<path d=\"M4 7h6\" />\n  <path d=\"M7 4v6\" />\n  <path d=\"M20 18h-6\" />\n  <path d=\"M5 19l14 -14\" />"),
    SLASH("slash", "<path d=\"M17 5l-10 14\" />"),
    SQUARE_ROOT("square-root", "<path d=\"M3 12h2l4 8l4 -16h8\" />"),
    SQUARE_ROOT_2(
        "square-root-2",
        "<path d=\"M13 12h1c1 0 1 1 2.016 3.527c.984 2.473 .984 3.473 1.984 3.473h1\" />\n  <path d=\"M12 19c1.5 0 3 -2 4 -3.5s2.5 -3.5 4 -3.5\" />\n  <path d=\"M3 12h1l3 8l3 -16h10\" />"),
    SUM("sum", "<path d=\"M18 16v2a1 1 0 0 1 -1 1h-11l6 -7l-6 -7h11a1 1 0 0 1 1 1v2\" />"),
    SUM_OFF(
        "sum-off",
        "<path d=\"M18 18a1 1 0 0 1 -1 1h-11l6 -7m-3 -7h8a1 1 0 0 1 1 1v2\" />\n  <path d=\"M3 3l18 18\" />"),
    TALLYMARK_1("tallymark-1", "<path d=\"M12 5l0 14\" />"),
    TALLYMARK_2("tallymark-2", "<path d=\"M10 5l0 14\" />\n  <path d=\"M14 5l0 14\" />"),
    TALLYMARK_3(
        "tallymark-3",
        "<path d=\"M8 5l0 14\" />\n  <path d=\"M12 5l0 14\" />\n  <path d=\"M16 5l0 14\" />"),
    TALLYMARK_4(
        "tallymark-4",
        "<path d=\"M6 5l0 14\" />\n  <path d=\"M10 5l0 14\" />\n  <path d=\"M14 5l0 14\" />\n  <path d=\"M18 5l0 14\" />"),
    TALLYMARKS(
        "tallymarks",
        "<path d=\"M6 5l0 14\" />\n  <path d=\"M10 5l0 14\" />\n  <path d=\"M14 5l0 14\" />\n  <path d=\"M18 5l0 14\" />\n  <path d=\"M3 17l18 -10\" />"),
    VARIABLE(
        "variable",
        "<path d=\"M5 4c-2.5 5 -2.5 10 0 16m14 -16c2.5 5 2.5 10 0 16m-10 -11h1c1 0 1 1 2.016 3.527c.984 2.473 .984 3.473 1.984 3.473h1\" />\n  <path d=\"M8 16c1.5 0 3 -2 4 -3.5s2.5 -3.5 4 -3.5\" />"),
    VARIABLE_MINUS(
        "variable-minus",
        "<path d=\"M8 16c1.5 0 3 -2 4 -3.5s2.5 -3.5 4 -3.5\" />\n  <path d=\"M5 4c-2.5 5 -2.5 10 0 16m14 -16c1.775 3.55 2.29 7.102 1.544 11.01m-11.544 -6.01h1c1 0 1 1 2.016 3.527c.782 1.966 .943 3 1.478 3.343\" />\n  <path d=\"M8 16c1.5 0 3 -2 4 -3.5s2.5 -3.5 4 -3.5\" />\n  <path d=\"M16 19h6\" />"),
    VARIABLE_OFF(
        "variable-off",
        "<path d=\"M4.675 4.68c-2.17 4.776 -2.062 9.592 .325 15.32\" />\n  <path d=\"M19 4c1.959 3.917 2.383 7.834 1.272 12.232m-.983 3.051c-.093 .238 -.189 .477 -.289 .717\" />\n  <path d=\"M11.696 11.696c.095 .257 .2 .533 .32 .831c.984 2.473 .984 3.473 1.984 3.473h1\" />\n  <path d=\"M8 16c1.5 0 3 -2 4 -3.5m2.022 -2.514c.629 -.582 1.304 -.986 1.978 -.986\" />\n  <path d=\"M3 3l18 18\" />"),
    VARIABLE_PLUS(
        "variable-plus",
        "<path d=\"M5 4c-2.5 5 -2.5 10 0 16m14 -16c1.38 2.76 2 5.52 1.855 8.448m-11.855 -3.448h1c1 0 1 1 2.016 3.527c.785 1.972 .944 3.008 1.483 3.346\" />\n  <path d=\"M8 16c1.5 0 3 -2 4 -3.5s2.5 -3.5 4 -3.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    X_POWER_Y(
        "x-power-y",
        "<path d=\"M15 3l3 5.063\" />\n  <path d=\"M5 12l6 6\" />\n  <path d=\"M5 18l6 -6\" />\n  <path d=\"M21 3l-4.8 9\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  enum FilledIcon implements TablerIconDefinition {
    FUNCTION(
        "function",
        "<path d=\"M17.333 3a3.667 3.667 0 0 1 3.667 3.667v10.666a3.667 3.667 0 0 1 -3.667 3.667h-10.666a3.667 3.667 0 0 1 -3.667 -3.667v-10.666a3.667 3.667 0 0 1 3.667 -3.667zm-3.583 3a2.38 2.38 0 0 0 -2.37 2.145l-.285 2.855h-2.095l-.117 .007a1 1 0 0 0 .117 1.993h1.894l-.265 2.656l-.014 .071a.38 .38 0 0 1 -.365 .273a.25 .25 0 0 1 -.25 -.25v-.25l-.007 -.117a1 1 0 0 0 -1.993 .117v.25l.005 .154a2.25 2.25 0 0 0 2.245 2.096a2.38 2.38 0 0 0 2.37 -2.145l.284 -2.855h2.096l.117 -.007a1 1 0 0 0 -.117 -1.993h-1.895l.266 -2.656l.014 -.071a.381 .381 0 0 1 .365 -.273a.25 .25 0 0 1 .25 .25v.25l.007 .117a1 1 0 0 0 1.993 -.117v-.25l-.005 -.154a2.25 2.25 0 0 0 -2.245 -2.096z\" />"),
    PLUS(
        "plus",
        "<path d=\"M12 4a1 1 0 0 1 1 1v6h6a1 1 0 0 1 0 2h-6v6a1 1 0 0 1 -2 0v-6h-6a1 1 0 0 1 0 -2h6v-6a1 1 0 0 1 1 -1\" />");

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "filled";
    }
  }

  default TablerIcon abacus() {
    return TablerIcon.create(TablerMath.OutlineIcon.ABACUS);
  }

  default TablerIcon abacus_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.ABACUS_OFF);
  }

  default TablerIcon ampersand() {
    return TablerIcon.create(TablerMath.OutlineIcon.AMPERSAND);
  }

  default TablerIcon backslash() {
    return TablerIcon.create(TablerMath.OutlineIcon.BACKSLASH);
  }

  default TablerIcon braces() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACES);
  }

  default TablerIcon braces_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACES_OFF);
  }

  default TablerIcon brackets() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACKETS);
  }

  default TablerIcon brackets_contain() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN);
  }

  default TablerIcon brackets_contain_end() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN_END);
  }

  default TablerIcon brackets_contain_start() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_CONTAIN_START);
  }

  default TablerIcon brackets_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.BRACKETS_OFF);
  }

  default TablerIcon decimal() {
    return TablerIcon.create(TablerMath.OutlineIcon.DECIMAL);
  }

  default TablerIcon divide() {
    return TablerIcon.create(TablerMath.OutlineIcon.DIVIDE);
  }

  default TablerIcon equal() {
    return TablerIcon.create(TablerMath.OutlineIcon.EQUAL);
  }

  default TablerIcon equal_double() {
    return TablerIcon.create(TablerMath.OutlineIcon.EQUAL_DOUBLE);
  }

  default TablerIcon equal_not() {
    return TablerIcon.create(TablerMath.OutlineIcon.EQUAL_NOT);
  }

  default TablerIcon function() {
    return TablerIcon.create(TablerMath.OutlineIcon.FUNCTION);
  }

  default TablerIcon function_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.FUNCTION_OFF);
  }

  default TablerIcon infinity() {
    return TablerIcon.create(TablerMath.OutlineIcon.INFINITY);
  }

  default TablerIcon infinity_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.INFINITY_2);
  }

  default TablerIcon infinity_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.INFINITY_OFF);
  }

  default TablerIcon math() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH);
  }

  default TablerIcon math_1_divide_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_1_DIVIDE_2);
  }

  default TablerIcon math_1_divide_3() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_1_DIVIDE_3);
  }

  default TablerIcon math_avg() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_AVG);
  }

  default TablerIcon math_cos() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_COS);
  }

  default TablerIcon math_ctg() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_CTG);
  }

  default TablerIcon math_equal_greater() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_EQUAL_GREATER);
  }

  default TablerIcon math_equal_lower() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_EQUAL_LOWER);
  }

  default TablerIcon math_function() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION);
  }

  default TablerIcon math_function_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION_OFF);
  }

  default TablerIcon math_function_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_FUNCTION_Y);
  }

  default TablerIcon math_greater() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_GREATER);
  }

  default TablerIcon math_integral() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRAL);
  }

  default TablerIcon math_integral_x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRAL_X);
  }

  default TablerIcon math_integrals() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_INTEGRALS);
  }

  default TablerIcon math_lower() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_LOWER);
  }

  default TablerIcon math_max() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_MAX);
  }

  default TablerIcon math_max_min() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_MAX_MIN);
  }

  default TablerIcon math_min() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_MIN);
  }

  default TablerIcon math_not() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_NOT);
  }

  default TablerIcon math_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_OFF);
  }

  default TablerIcon math_pi() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_PI);
  }

  default TablerIcon math_pi_divide_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_PI_DIVIDE_2);
  }

  default TablerIcon math_sec() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_SEC);
  }

  default TablerIcon math_sin() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_SIN);
  }

  default TablerIcon math_symbols() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_SYMBOLS);
  }

  default TablerIcon math_tg() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_TG);
  }

  default TablerIcon math_x_divide_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_2);
  }

  default TablerIcon math_x_divide_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_Y);
  }

  default TablerIcon math_x_divide_y_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_DIVIDE_Y_2);
  }

  default TablerIcon math_x_floor_divide_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_FLOOR_DIVIDE_Y);
  }

  default TablerIcon math_x_minus_x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_MINUS_X);
  }

  default TablerIcon math_x_minus_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_MINUS_Y);
  }

  default TablerIcon math_x_plus_x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_PLUS_X);
  }

  default TablerIcon math_x_plus_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_X_PLUS_Y);
  }

  default TablerIcon math_xy() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_XY);
  }

  default TablerIcon math_y_minus_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_Y_MINUS_Y);
  }

  default TablerIcon math_y_plus_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATH_Y_PLUS_Y);
  }

  default TablerIcon matrix() {
    return TablerIcon.create(TablerMath.OutlineIcon.MATRIX);
  }

  default TablerIcon minus() {
    return TablerIcon.create(TablerMath.OutlineIcon.MINUS);
  }

  default TablerIcon multiplier_0_5x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_0_5X);
  }

  default TablerIcon multiplier_1_5x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_1_5X);
  }

  default TablerIcon multiplier_1x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_1X);
  }

  default TablerIcon multiplier_2x() {
    return TablerIcon.create(TablerMath.OutlineIcon.MULTIPLIER_2X);
  }

  default TablerIcon omega() {
    return TablerIcon.create(TablerMath.OutlineIcon.OMEGA);
  }

  default TablerIcon parentheses() {
    return TablerIcon.create(TablerMath.OutlineIcon.PARENTHESES);
  }

  default TablerIcon parentheses_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.PARENTHESES_OFF);
  }

  default TablerIcon pendulum() {
    return TablerIcon.create(TablerMath.OutlineIcon.PENDULUM);
  }

  default TablerIcon percentage() {
    return TablerIcon.create(TablerMath.OutlineIcon.PERCENTAGE);
  }

  default TablerIcon plus() {
    return TablerIcon.create(TablerMath.OutlineIcon.PLUS);
  }

  default TablerIcon plus_equal() {
    return TablerIcon.create(TablerMath.OutlineIcon.PLUS_EQUAL);
  }

  default TablerIcon plus_minus() {
    return TablerIcon.create(TablerMath.OutlineIcon.PLUS_MINUS);
  }

  default TablerIcon slash() {
    return TablerIcon.create(TablerMath.OutlineIcon.SLASH);
  }

  default TablerIcon square_root() {
    return TablerIcon.create(TablerMath.OutlineIcon.SQUARE_ROOT);
  }

  default TablerIcon square_root_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.SQUARE_ROOT_2);
  }

  default TablerIcon sum() {
    return TablerIcon.create(TablerMath.OutlineIcon.SUM);
  }

  default TablerIcon sum_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.SUM_OFF);
  }

  default TablerIcon tallymark_1() {
    return TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_1);
  }

  default TablerIcon tallymark_2() {
    return TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_2);
  }

  default TablerIcon tallymark_3() {
    return TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_3);
  }

  default TablerIcon tallymark_4() {
    return TablerIcon.create(TablerMath.OutlineIcon.TALLYMARK_4);
  }

  default TablerIcon tallymarks() {
    return TablerIcon.create(TablerMath.OutlineIcon.TALLYMARKS);
  }

  default TablerIcon variable() {
    return TablerIcon.create(TablerMath.OutlineIcon.VARIABLE);
  }

  default TablerIcon variable_minus() {
    return TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_MINUS);
  }

  default TablerIcon variable_off() {
    return TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_OFF);
  }

  default TablerIcon variable_plus() {
    return TablerIcon.create(TablerMath.OutlineIcon.VARIABLE_PLUS);
  }

  default TablerIcon x_power_y() {
    return TablerIcon.create(TablerMath.OutlineIcon.X_POWER_Y);
  }

  default TablerIcon function_filled() {
    return TablerIcon.create(TablerMath.FilledIcon.FUNCTION);
  }

  default TablerIcon plus_filled() {
    return TablerIcon.create(TablerMath.FilledIcon.PLUS);
  }
}
