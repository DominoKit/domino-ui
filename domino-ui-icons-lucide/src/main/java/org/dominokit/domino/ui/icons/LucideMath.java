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

/** Lucide math catalog category. */
public interface LucideMath {
  enum Icon implements LucideIconDefinition {
    ANGLE(
        "angle",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M3 11a10 10 0 0 1 10 10\" />"),
    ASTERISK(
        "asterisk",
        "<path d=\"M12 5v14\" />\n  <path d=\"m18.065 8.496-12.125 7\" />\n  <path d=\"m5.94 8.504 12.125 7\" />"),
    ASTROID(
        "astroid",
        "<path d=\"M12.983 21.186a1 1 0 0 1-1.966 0 10 10 0 0 0-8.203-8.203 1 1 0 0 1 0-1.966 10 10 0 0 0 8.203-8.203 1 1 0 0 1 1.966 0 10 10 0 0 0 8.203 8.203 1 1 0 0 1 0 1.966 10 10 0 0 0-8.203 8.203\" />"),
    BADGE_PERCENT(
        "badge-percent",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    BOX(
        "box",
        "<path d=\"M21 8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16Z\" />\n  <path d=\"m3.3 7 8.7 5 8.7-5\" />\n  <path d=\"M12 22V12\" />"),
    CALCULATOR(
        "calculator",
        "<rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <line x1=\"8\" x2=\"16\" y1=\"6\" y2=\"6\" />\n  <line x1=\"16\" x2=\"16\" y1=\"14\" y2=\"18\" />\n  <path d=\"M16 10h.01\" />\n  <path d=\"M12 10h.01\" />\n  <path d=\"M8 10h.01\" />\n  <path d=\"M12 14h.01\" />\n  <path d=\"M8 14h.01\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M8 18h.01\" />"),
    CHEVRON_RIGHT("chevron-right", "<path d=\"m9 18 6-6-6-6\" />"),
    CHEVRON_UP("chevron-up", "<path d=\"m18 15-6-6-6 6\" />"),
    CIRCLE_DIVIDE(
        "circle-divide",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <line x1=\"8\" x2=\"16\" y1=\"12\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12\" y1=\"16\" y2=\"16\" />\n  <line x1=\"12\" x2=\"12\" y1=\"8\" y2=\"8\" />"),
    CIRCLE_EQUAL(
        "circle-equal",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M7 10h10\" />\n  <path d=\"M7 14h10\" />"),
    CIRCLE_MINUS(
        "circle-minus", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M8 12h8\" />"),
    CIRCLE_PERCENT(
        "circle-percent",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    CIRCLE_PLUS(
        "circle-plus",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    CIRCLE_SLASH(
        "circle-slash",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <line x1=\"9\" x2=\"15\" y1=\"15\" y2=\"9\" />"),
    CIRCLE_SLASH_2(
        "circle-slash-2", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M22 2 2 22\" />"),
    CIRCLE_X(
        "circle-x",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"m9 9 6 6\" />"),
    CONE(
        "cone",
        "<path d=\"m20.9 18.55-8-15.98a1 1 0 0 0-1.8 0l-8 15.98\" />\n  <ellipse cx=\"12\" cy=\"19\" rx=\"9\" ry=\"3\" />"),
    COPY_MINUS(
        "copy-minus",
        "<line x1=\"12\" x2=\"18\" y1=\"15\" y2=\"15\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_PLUS(
        "copy-plus",
        "<line x1=\"15\" x2=\"15\" y1=\"12\" y2=\"18\" />\n  <line x1=\"12\" x2=\"18\" y1=\"15\" y2=\"15\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_SLASH(
        "copy-slash",
        "<line x1=\"12\" x2=\"18\" y1=\"18\" y2=\"12\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_X(
        "copy-x",
        "<path d=\"M4 16a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2\" />\n  <rect x=\"8\" y=\"8\" width=\"14\" height=\"14\" rx=\"2\" />\n  <path d=\"m12.5 12.5 5 5\" />\n  <path d=\"m12.5 17.5 5-5\" />"),
    CUBOID(
        "cuboid",
        "<path d=\"M10 22v-8\" />\n  <path d=\"M2.336 8.89 10 14l11.715-7.029\" />\n  <path d=\"M22 14a2 2 0 0 1-.971 1.715l-10 6a2 2 0 0 1-2.138-.05l-6-4A2 2 0 0 1 2 16v-6a2 2 0 0 1 .971-1.715l10-6a2 2 0 0 1 2.138.05l6 4A2 2 0 0 1 22 8z\" />"),
    CYLINDER(
        "cylinder",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5v14a9 3 0 0 0 18 0V5\" />"),
    DECIMALS_ARROW_LEFT(
        "decimals-arrow-left",
        "<path d=\"m13 21-3-3 3-3\" />\n  <path d=\"M20 18H10\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DECIMALS_ARROW_RIGHT(
        "decimals-arrow-right",
        "<path d=\"M10 18h10\" />\n  <path d=\"m17 21 3-3-3-3\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"15\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DIAMETER(
        "diameter",
        "<circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />\n  <path d=\"M6.48 3.66a10 10 0 0 1 13.86 13.86\" />\n  <path d=\"m6.41 6.41 11.18 11.18\" />\n  <path d=\"M3.66 6.48a10 10 0 0 0 13.86 13.86\" />"),
    DIAMOND_PERCENT(
        "diamond-percent",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0Z\" />\n  <path d=\"M9.2 9.2h.01\" />\n  <path d=\"m14.5 9.5-5 5\" />\n  <path d=\"M14.7 14.8h.01\" />"),
    DIVIDE(
        "divide",
        "<circle cx=\"12\" cy=\"6\" r=\"1\" />\n  <line x1=\"5\" x2=\"19\" y1=\"12\" y2=\"12\" />\n  <circle cx=\"12\" cy=\"18\" r=\"1\" />"),
    DRAFTING_COMPASS(
        "drafting-compass",
        "<path d=\"m12.99 6.74 1.93 3.44\" />\n  <path d=\"M19.136 12a10 10 0 0 1-14.271 0\" />\n  <path d=\"m21 21-2.16-3.84\" />\n  <path d=\"m3 21 8.02-14.26\" />\n  <circle cx=\"12\" cy=\"5\" r=\"2\" />"),
    EQUAL(
        "equal",
        "<line x1=\"5\" x2=\"19\" y1=\"9\" y2=\"9\" />\n  <line x1=\"5\" x2=\"19\" y1=\"15\" y2=\"15\" />"),
    EQUAL_APPROXIMATELY(
        "equal-approximately",
        "<path d=\"M5 15a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <path d=\"M5 9a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />"),
    EQUAL_APPROXIMATELY_NOT(
        "equal-approximately-not",
        "<path d=\"M5 15a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <path d=\"M5 9a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    EQUAL_NOT(
        "equal-not",
        "<line x1=\"5\" x2=\"19\" y1=\"9\" y2=\"9\" />\n  <line x1=\"5\" x2=\"19\" y1=\"15\" y2=\"15\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    GRID_2X2(
        "grid-2x2",
        "<path d=\"M12 3v18\" />\n  <path d=\"M3 12h18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    GRID_2X2_CHECK(
        "grid-2x2-check",
        "<path d=\"M12 3v17a1 1 0 0 1-1 1H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v6a1 1 0 0 1-1 1H3\" />\n  <path d=\"m16 19 2 2 4-4\" />"),
    GRID_2X2_PLUS(
        "grid-2x2-plus",
        "<path d=\"M12 3v17a1 1 0 0 1-1 1H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v6a1 1 0 0 1-1 1H3\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 22v-6\" />"),
    GRID_2X2_X(
        "grid-2x2-x",
        "<path d=\"M12 3v17a1 1 0 0 1-1 1H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v6a1 1 0 0 1-1 1H3\" />\n  <path d=\"m16.5 16.5 5 5\" />\n  <path d=\"m16.5 21.5 5-5\" />"),
    GRID_3X2(
        "grid-3x2",
        "<path d=\"M15 3v18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M9 3v18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    LAMBDA(
        "lambda",
        "<path d=\"M11.38 10 5 20\" />\n  <path d=\"M19 18a2 2 0 01-2 2c-4.87-.003-5.052-16-10-16a2 2 0 00-2 2\" />"),
    LAND_PLOT(
        "land-plot",
        "<path d=\"m12 8 6-3-6-3v10\" />\n  <path d=\"m8 11.99-5.5 3.14a1 1 0 0 0 0 1.74l8.5 4.86a2 2 0 0 0 2 0l8.5-4.86a1 1 0 0 0 0-1.74L16 12\" />\n  <path d=\"m6.49 12.85 11.02 6.3\" />\n  <path d=\"M17.51 12.85 6.5 19.15\" />"),
    LINE_SQUIGGLE(
        "line-squiggle",
        "<path d=\"M7 3.5c5-2 7 2.5 3 4C1.5 10 2 15 5 16c5 2 9-10 14-7s.5 13.5-4 12c-5-2.5.5-11 6-2\" />"),
    MINUS("minus", "<path d=\"M5 12h14\" />"),
    OCTAGON_X(
        "octagon-x",
        "<path d=\"m15 9-6 6\" />\n  <path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />\n  <path d=\"m9 9 6 6\" />"),
    OMEGA(
        "omega",
        "<path d=\"M3 20h4.5a.5.5 0 0 0 .5-.5v-.282a.52.52 0 0 0-.247-.437 8 8 0 1 1 8.494-.001.52.52 0 0 0-.247.438v.282a.5.5 0 0 0 .5.5H21\" />"),
    PARENTHESES(
        "parentheses",
        "<path d=\"M8 21s-4-3-4-9 4-9 4-9\" />\n  <path d=\"M16 3s4 3 4 9-4 9-4 9\" />"),
    PERCENT(
        "percent",
        "<line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"2.5\" />\n  <circle cx=\"17.5\" cy=\"17.5\" r=\"2.5\" />"),
    PHI("phi", "<path d=\"M12 2v20\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />"),
    PI(
        "pi",
        "<line x1=\"9\" x2=\"9\" y1=\"4\" y2=\"20\" />\n  <path d=\"M4 7c0-1.7 1.3-3 3-3h13\" />\n  <path d=\"M18 20c-1.7 0-3-1.3-3-3V4\" />"),
    PLUS("plus", "<path d=\"M5 12h14\" />\n  <path d=\"M12 5v14\" />"),
    PYRAMID(
        "pyramid",
        "<path d=\"M2.5 16.88a1 1 0 0 1-.32-1.43l9-13.02a1 1 0 0 1 1.64 0l9 13.01a1 1 0 0 1-.32 1.44l-8.51 4.86a2 2 0 0 1-1.98 0Z\" />\n  <path d=\"M12 2v20\" />"),
    RADICAL(
        "radical",
        "<path d=\"M3 12h3.28a1 1 0 0 1 .948.684l2.298 7.934a.5.5 0 0 0 .96-.044L13.82 4.771A1 1 0 0 1 14.792 4H21\" />"),
    RADIUS(
        "radius",
        "<path d=\"M20.34 17.52a10 10 0 1 0-2.82 2.82\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <path d=\"m13.41 13.41 4.18 4.18\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    SIGMA(
        "sigma",
        "<path d=\"M18 7V5a1 1 0 0 0-1-1H6.5a.5.5 0 0 0-.4.8l4.5 6a2 2 0 0 1 0 2.4l-4.5 6a.5.5 0 0 0 .4.8H17a1 1 0 0 0 1-1v-2\" />"),
    SLASH("slash", "<path d=\"M22 2 2 22\" />"),
    SQUARE_ASTERISK(
        "square-asterisk",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8.5 14 7-4\" />\n  <path d=\"m8.5 10 7 4\" />"),
    SQUARE_CHEVRON_UP(
        "square-chevron-up",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m8 14 4-4 4 4\" />"),
    SQUARE_DIVIDE(
        "square-divide",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <line x1=\"8\" x2=\"16\" y1=\"12\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12\" y1=\"16\" y2=\"16\" />\n  <line x1=\"12\" x2=\"12\" y1=\"8\" y2=\"8\" />"),
    SQUARE_EQUAL(
        "square-equal",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 10h10\" />\n  <path d=\"M7 14h10\" />"),
    SQUARE_FUNCTION(
        "square-function",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <path d=\"M9 17c2 0 2.8-1 2.8-2.8V10c0-2 1-3.3 3.2-3\" />\n  <path d=\"M9 11.2h5.7\" />"),
    SQUARE_MINUS(
        "square-minus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />"),
    SQUARE_PERCENT(
        "square-percent",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    SQUARE_PI(
        "square-pi",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7h10\" />\n  <path d=\"M10 7v10\" />\n  <path d=\"M16 17a2 2 0 0 1-2-2V7\" />"),
    SQUARE_PLUS(
        "square-plus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_RADICAL(
        "square-radical",
        "<path d=\"M7 12h2l2 5 2-10h4\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_SIGMA(
        "square-sigma",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M16 8.9V7H8l4 5-4 5h8v-1.9\" />"),
    SQUARE_SLASH(
        "square-slash",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <line x1=\"9\" x2=\"15\" y1=\"15\" y2=\"9\" />"),
    SQUARE_X(
        "square-x",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"m9 9 6 6\" />"),
    TALLY_1("tally-1", "<path d=\"M4 4v16\" />"),
    TALLY_2("tally-2", "<path d=\"M4 4v16\" />\n  <path d=\"M9 4v16\" />"),
    TALLY_3(
        "tally-3", "<path d=\"M4 4v16\" />\n  <path d=\"M9 4v16\" />\n  <path d=\"M14 4v16\" />"),
    TALLY_4(
        "tally-4",
        "<path d=\"M4 4v16\" />\n  <path d=\"M9 4v16\" />\n  <path d=\"M14 4v16\" />\n  <path d=\"M19 4v16\" />"),
    TALLY_5(
        "tally-5",
        "<path d=\"M4 4v16\" />\n  <path d=\"M9 4v16\" />\n  <path d=\"M14 4v16\" />\n  <path d=\"M19 4v16\" />\n  <path d=\"M22 6 2 18\" />"),
    TANGENT(
        "tangent",
        "<circle cx=\"17\" cy=\"4\" r=\"2\" />\n  <path d=\"M15.59 5.41 5.41 15.59\" />\n  <circle cx=\"4\" cy=\"17\" r=\"2\" />\n  <path d=\"M12 22s-4-9-1.5-11.5S22 12 22 12\" />"),
    TRIANGLE_RIGHT(
        "triangle-right",
        "<path d=\"M22 18a2 2 0 0 1-2 2H3c-1.1 0-1.3-.6-.4-1.3L20.4 4.3c.9-.7 1.6-.4 1.6.7Z\" />"),
    VARIABLE(
        "variable",
        "<path d=\"M8 21s-4-3-4-9 4-9 4-9\" />\n  <path d=\"M16 3s4 3 4 9-4 9-4 9\" />\n  <line x1=\"15\" x2=\"9\" y1=\"9\" y2=\"15\" />\n  <line x1=\"9\" x2=\"15\" y1=\"9\" y2=\"15\" />"),
    VECTOR_POLYGON(
        "vector-polygon",
        "<path d=\"m12.828 4.813 5.344 2.375\" />\n  <path d=\"m15.769 18.153 3.461-8.306\" />\n  <path d=\"m5.687 14.074 7.625 4.852\" />\n  <path d=\"M9.772 5.579 5.228 11.42\" />\n  <circle cx=\"11\" cy=\"4\" r=\"2\" />\n  <circle cx=\"15\" cy=\"20\" r=\"2\" />\n  <circle cx=\"20\" cy=\"8\" r=\"2\" />\n  <circle cx=\"4\" cy=\"13\" r=\"2\" />"),
    VECTOR_SQUARE(
        "vector-square",
        "<path d=\"M17.055 4.533a24 24 0 00-10.11 0\" />\n  <path d=\"M19.467 17.055a24 24 0 000-10.11\" />\n  <path d=\"M4.533 6.945a24 24 0 000 10.11\" />\n  <path d=\"M6.945 19.467a24 24 0 0010.11 0\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />"),
    WEIGHT(
        "weight",
        "<circle cx=\"12\" cy=\"5\" r=\"3\" />\n  <path d=\"M6.5 8a2 2 0 0 0-1.905 1.46L2.1 18.5A2 2 0 0 0 4 21h16a2 2 0 0 0 1.925-2.54L19.4 9.5A2 2 0 0 0 17.48 8Z\" />"),
    WEIGHT_TILDE(
        "weight-tilde",
        "<path d=\"M6.5 8a2 2 0 0 0-1.906 1.46L2.1 18.5A2 2 0 0 0 4 21h16a2 2 0 0 0 1.925-2.54L19.4 9.5A2 2 0 0 0 17.48 8z\" />\n  <path d=\"M7.999 15a2.5 2.5 0 0 1 4 0 2.5 2.5 0 0 0 4 0\" />\n  <circle cx=\"12\" cy=\"5\" r=\"3\" />"),
    X("x", "<path d=\"M18 6 6 18\" />\n  <path d=\"m6 6 12 12\" />"),
    X_LINE_TOP(
        "x-line-top",
        "<path d=\"M18 4H6\" />\n  <path d=\"M18 8 6 20\" />\n  <path d=\"m6 8 12 12\" />");

    private final String catalogName;
    private final String svg;

    Icon(String catalogName, String svg) {
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

  // Icon factories for this category.
  default LucideIcon angle_math() {
    return LucideIcon.create(Icon.ANGLE);
  }

  default LucideIcon asterisk_math() {
    return LucideIcon.create(Icon.ASTERISK);
  }

  default LucideIcon astroid_math() {
    return LucideIcon.create(Icon.ASTROID);
  }

  default LucideIcon badge_percent_math() {
    return LucideIcon.create(Icon.BADGE_PERCENT);
  }

  default LucideIcon box_math() {
    return LucideIcon.create(Icon.BOX);
  }

  default LucideIcon calculator_math() {
    return LucideIcon.create(Icon.CALCULATOR);
  }

  default LucideIcon chevron_right_math() {
    return LucideIcon.create(Icon.CHEVRON_RIGHT);
  }

  default LucideIcon chevron_up_math() {
    return LucideIcon.create(Icon.CHEVRON_UP);
  }

  default LucideIcon circle_divide() {
    return LucideIcon.create(Icon.CIRCLE_DIVIDE);
  }

  default LucideIcon circle_equal() {
    return LucideIcon.create(Icon.CIRCLE_EQUAL);
  }

  default LucideIcon circle_minus() {
    return LucideIcon.create(Icon.CIRCLE_MINUS);
  }

  default LucideIcon circle_percent_math() {
    return LucideIcon.create(Icon.CIRCLE_PERCENT);
  }

  default LucideIcon circle_plus_math() {
    return LucideIcon.create(Icon.CIRCLE_PLUS);
  }

  default LucideIcon circle_slash_math() {
    return LucideIcon.create(Icon.CIRCLE_SLASH);
  }

  default LucideIcon circle_slash_2_math() {
    return LucideIcon.create(Icon.CIRCLE_SLASH_2);
  }

  default LucideIcon circle_x_math() {
    return LucideIcon.create(Icon.CIRCLE_X);
  }

  default LucideIcon cone_math() {
    return LucideIcon.create(Icon.CONE);
  }

  default LucideIcon copy_minus_math() {
    return LucideIcon.create(Icon.COPY_MINUS);
  }

  default LucideIcon copy_plus_math() {
    return LucideIcon.create(Icon.COPY_PLUS);
  }

  default LucideIcon copy_slash_math() {
    return LucideIcon.create(Icon.COPY_SLASH);
  }

  default LucideIcon copy_x_math() {
    return LucideIcon.create(Icon.COPY_X);
  }

  default LucideIcon cuboid_math() {
    return LucideIcon.create(Icon.CUBOID);
  }

  default LucideIcon cylinder_math() {
    return LucideIcon.create(Icon.CYLINDER);
  }

  default LucideIcon decimals_arrow_left_math() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_LEFT);
  }

  default LucideIcon decimals_arrow_right_math() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_RIGHT);
  }

  default LucideIcon diameter_math() {
    return LucideIcon.create(Icon.DIAMETER);
  }

  default LucideIcon diamond_percent_math() {
    return LucideIcon.create(Icon.DIAMOND_PERCENT);
  }

  default LucideIcon divide_math() {
    return LucideIcon.create(Icon.DIVIDE);
  }

  default LucideIcon drafting_compass_math() {
    return LucideIcon.create(Icon.DRAFTING_COMPASS);
  }

  default LucideIcon equal_math() {
    return LucideIcon.create(Icon.EQUAL);
  }

  default LucideIcon equal_approximately() {
    return LucideIcon.create(Icon.EQUAL_APPROXIMATELY);
  }

  default LucideIcon equal_approximately_not_math() {
    return LucideIcon.create(Icon.EQUAL_APPROXIMATELY_NOT);
  }

  default LucideIcon equal_not_math() {
    return LucideIcon.create(Icon.EQUAL_NOT);
  }

  default LucideIcon grid_2x2_math() {
    return LucideIcon.create(Icon.GRID_2X2);
  }

  default LucideIcon grid_2x2_check_math() {
    return LucideIcon.create(Icon.GRID_2X2_CHECK);
  }

  default LucideIcon grid_2x2_plus_math() {
    return LucideIcon.create(Icon.GRID_2X2_PLUS);
  }

  default LucideIcon grid_2x2_x_math() {
    return LucideIcon.create(Icon.GRID_2X2_X);
  }

  default LucideIcon grid_3x2_math() {
    return LucideIcon.create(Icon.GRID_3X2);
  }

  default LucideIcon lambda_math() {
    return LucideIcon.create(Icon.LAMBDA);
  }

  default LucideIcon land_plot_math() {
    return LucideIcon.create(Icon.LAND_PLOT);
  }

  default LucideIcon line_squiggle_math() {
    return LucideIcon.create(Icon.LINE_SQUIGGLE);
  }

  default LucideIcon minus_math() {
    return LucideIcon.create(Icon.MINUS);
  }

  default LucideIcon octagon_x_math() {
    return LucideIcon.create(Icon.OCTAGON_X);
  }

  default LucideIcon omega_math() {
    return LucideIcon.create(Icon.OMEGA);
  }

  default LucideIcon parentheses_math() {
    return LucideIcon.create(Icon.PARENTHESES);
  }

  default LucideIcon percent_math() {
    return LucideIcon.create(Icon.PERCENT);
  }

  default LucideIcon phi_math() {
    return LucideIcon.create(Icon.PHI);
  }

  default LucideIcon pi_math() {
    return LucideIcon.create(Icon.PI);
  }

  default LucideIcon plus_math() {
    return LucideIcon.create(Icon.PLUS);
  }

  default LucideIcon pyramid_math() {
    return LucideIcon.create(Icon.PYRAMID);
  }

  default LucideIcon radical_math() {
    return LucideIcon.create(Icon.RADICAL);
  }

  default LucideIcon radius_math() {
    return LucideIcon.create(Icon.RADIUS);
  }

  default LucideIcon sigma_math() {
    return LucideIcon.create(Icon.SIGMA);
  }

  default LucideIcon slash_math() {
    return LucideIcon.create(Icon.SLASH);
  }

  default LucideIcon square_asterisk_math() {
    return LucideIcon.create(Icon.SQUARE_ASTERISK);
  }

  default LucideIcon square_chevron_up_math() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_UP);
  }

  default LucideIcon square_divide() {
    return LucideIcon.create(Icon.SQUARE_DIVIDE);
  }

  default LucideIcon square_equal() {
    return LucideIcon.create(Icon.SQUARE_EQUAL);
  }

  default LucideIcon square_function_math() {
    return LucideIcon.create(Icon.SQUARE_FUNCTION);
  }

  default LucideIcon square_minus_math() {
    return LucideIcon.create(Icon.SQUARE_MINUS);
  }

  default LucideIcon square_percent_math() {
    return LucideIcon.create(Icon.SQUARE_PERCENT);
  }

  default LucideIcon square_pi_math() {
    return LucideIcon.create(Icon.SQUARE_PI);
  }

  default LucideIcon square_plus_math() {
    return LucideIcon.create(Icon.SQUARE_PLUS);
  }

  default LucideIcon square_radical_math() {
    return LucideIcon.create(Icon.SQUARE_RADICAL);
  }

  default LucideIcon square_sigma_math() {
    return LucideIcon.create(Icon.SQUARE_SIGMA);
  }

  default LucideIcon square_slash_math() {
    return LucideIcon.create(Icon.SQUARE_SLASH);
  }

  default LucideIcon square_x_math() {
    return LucideIcon.create(Icon.SQUARE_X);
  }

  default LucideIcon tally_1_math() {
    return LucideIcon.create(Icon.TALLY_1);
  }

  default LucideIcon tally_2_math() {
    return LucideIcon.create(Icon.TALLY_2);
  }

  default LucideIcon tally_3_math() {
    return LucideIcon.create(Icon.TALLY_3);
  }

  default LucideIcon tally_4_math() {
    return LucideIcon.create(Icon.TALLY_4);
  }

  default LucideIcon tally_5_math() {
    return LucideIcon.create(Icon.TALLY_5);
  }

  default LucideIcon tangent_math() {
    return LucideIcon.create(Icon.TANGENT);
  }

  default LucideIcon triangle_right_math() {
    return LucideIcon.create(Icon.TRIANGLE_RIGHT);
  }

  default LucideIcon variable_math() {
    return LucideIcon.create(Icon.VARIABLE);
  }

  default LucideIcon vector_polygon_math() {
    return LucideIcon.create(Icon.VECTOR_POLYGON);
  }

  default LucideIcon vector_square_math() {
    return LucideIcon.create(Icon.VECTOR_SQUARE);
  }

  default LucideIcon weight() {
    return LucideIcon.create(Icon.WEIGHT);
  }

  default LucideIcon weight_tilde() {
    return LucideIcon.create(Icon.WEIGHT_TILDE);
  }

  default LucideIcon x_math() {
    return LucideIcon.create(Icon.X);
  }

  default LucideIcon x_line_top_math() {
    return LucideIcon.create(Icon.X_LINE_TOP);
  }
}
