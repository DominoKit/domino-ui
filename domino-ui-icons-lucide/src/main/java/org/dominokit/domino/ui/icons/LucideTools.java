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

/** Lucide tools catalog category. */
public interface LucideTools {
  enum Icon implements LucideIconDefinition {
    ANVIL(
        "anvil",
        "<path d=\"M7 10H6a4 4 0 0 1-4-4 1 1 0 0 1 1-1h4\" />\n  <path d=\"M7 5a1 1 0 0 1 1-1h13a1 1 0 0 1 1 1 7 7 0 0 1-7 7H8a1 1 0 0 1-1-1z\" />\n  <path d=\"M9 12v5\" />\n  <path d=\"M15 12v5\" />\n  <path d=\"M5 20a3 3 0 0 1 3-3h8a3 3 0 0 1 3 3 1 1 0 0 1-1 1H6a1 1 0 0 1-1-1\" />"),
    AXE(
        "axe",
        "<path d=\"m14 12-8.381 8.38a1 1 0 0 1-3.001-3L11 9\" />\n  <path d=\"M15 15.5a.5.5 0 0 0 .5.5A6.5 6.5 0 0 0 22 9.5a.5.5 0 0 0-.5-.5h-1.672a2 2 0 0 1-1.414-.586l-5.062-5.062a1.205 1.205 0 0 0-1.704 0L9.352 5.648a1.205 1.205 0 0 0 0 1.704l5.062 5.062A2 2 0 0 1 15 13.828z\" />"),
    BETWEEN_HORIZONTAL_END(
        "between-horizontal-end",
        "<rect width=\"13\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"m22 15-3-3 3-3\" />\n  <rect width=\"13\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />"),
    BETWEEN_HORIZONTAL_START(
        "between-horizontal-start",
        "<rect width=\"13\" height=\"7\" x=\"8\" y=\"3\" rx=\"1\" />\n  <path d=\"m2 9 3 3-3 3\" />\n  <rect width=\"13\" height=\"7\" x=\"8\" y=\"14\" rx=\"1\" />"),
    BETWEEN_VERTICAL_END(
        "between-vertical-end",
        "<rect width=\"7\" height=\"13\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"m9 22 3-3 3 3\" />\n  <rect width=\"7\" height=\"13\" x=\"14\" y=\"3\" rx=\"1\" />"),
    BETWEEN_VERTICAL_START(
        "between-vertical-start",
        "<rect width=\"7\" height=\"13\" x=\"3\" y=\"8\" rx=\"1\" />\n  <path d=\"m15 2-3 3-3-3\" />\n  <rect width=\"7\" height=\"13\" x=\"14\" y=\"8\" rx=\"1\" />"),
    BLEND(
        "blend", "<circle cx=\"15\" cy=\"9\" r=\"7\" />\n  <circle cx=\"9\" cy=\"15\" r=\"7\" />"),
    BOLT(
        "bolt",
        "<path d=\"M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    BOMB(
        "bomb",
        "<circle cx=\"11\" cy=\"13\" r=\"9\" />\n  <path d=\"M14.35 4.65 16.3 2.7a2.41 2.41 0 0 1 3.4 0l1.6 1.6a2.4 2.4 0 0 1 0 3.4l-1.95 1.95\" />\n  <path d=\"m22 2-1.5 1.5\" />"),
    BOW_ARROW(
        "bow-arrow",
        "<path d=\"M17 3h4v4\" />\n  <path d=\"M18.575 11.082a13 13 0 0 1 1.048 9.027 1.17 1.17 0 0 1-1.914.597L14 17\" />\n  <path d=\"M7 10 3.29 6.29a1.17 1.17 0 0 1 .6-1.91 13 13 0 0 1 9.03 1.05\" />\n  <path d=\"M7 14a1.7 1.7 0 0 0-1.207.5l-2.646 2.646A.5.5 0 0 0 3.5 18H5a1 1 0 0 1 1 1v1.5a.5.5 0 0 0 .854.354L9.5 18.207A1.7 1.7 0 0 0 10 17v-2a1 1 0 0 0-1-1z\" />\n  <path d=\"M9.707 14.293 21 3\" />"),
    BROOM(
        "broom",
        "<path d=\"M13.5 10.5 22 2\" />\n  <path d=\"M14.734 13.841a2 2 0 00-.314-2.42L12.58 9.58a2 2 0 00-2.421-.314l-7.657 4.461A1 1 0 002.3 15.3l6.403 6.403a1 1 0 001.571-.204z\" />\n  <path d=\"m5 18 2-2\" />\n  <path d=\"m7.699 10.7 5.602 5.601\" />"),
    BROOM_SPARKLES(
        "broom-sparkles",
        "<path d=\"M11 2v2\" />\n  <path d=\"M12 3h-2\" />\n  <path d=\"M13.5 10.5 22 2\" />\n  <path d=\"M14.734 13.841a2 2 0 00-.314-2.42L12.58 9.58a2 2 0 00-2.421-.314l-7.657 4.461A1 1 0 002.3 15.3l6.403 6.403a1 1 0 001.571-.204z\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 4v4\" />\n  <path d=\"m5 18 2-2\" />\n  <path d=\"M6 6H2\" />\n  <path d=\"m7.699 10.7 5.602 5.601\" />"),
    BRUSH(
        "brush",
        "<path d=\"m11 10 3 3\" />\n  <path d=\"M6.5 21A3.5 3.5 0 1 0 3 17.5a2.62 2.62 0 0 1-.708 1.792A1 1 0 0 0 3 21z\" />\n  <path d=\"M9.969 17.031 21.378 5.624a1 1 0 0 0-3.002-3.002L6.967 14.031\" />"),
    BRUSH_CLEANING(
        "brush-cleaning",
        "<path d=\"m16 22-1-4\" />\n  <path d=\"M19 14a1 1 0 0 0 1-1v-1a2 2 0 0 0-2-2h-3a1 1 0 0 1-1-1V4a2 2 0 0 0-4 0v5a1 1 0 0 1-1 1H6a2 2 0 0 0-2 2v1a1 1 0 0 0 1 1\" />\n  <path d=\"M19 14H5l-1.973 6.767A1 1 0 0 0 4 22h16a1 1 0 0 0 .973-1.233z\" />\n  <path d=\"m8 22 1-4\" />"),
    DIAMETER(
        "diameter",
        "<circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />\n  <path d=\"M6.48 3.66a10 10 0 0 1 13.86 13.86\" />\n  <path d=\"m6.41 6.41 11.18 11.18\" />\n  <path d=\"M3.66 6.48a10 10 0 0 0 13.86 13.86\" />"),
    DIAMOND_MINUS(
        "diamond-minus",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
    DIAMOND_PLUS(
        "diamond-plus",
        "<path d=\"M12 8v8\" />\n  <path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
    DRAFTING_COMPASS(
        "drafting-compass",
        "<path d=\"m12.99 6.74 1.93 3.44\" />\n  <path d=\"M19.136 12a10 10 0 0 1-14.271 0\" />\n  <path d=\"m21 21-2.16-3.84\" />\n  <path d=\"m3 21 8.02-14.26\" />\n  <circle cx=\"12\" cy=\"5\" r=\"2\" />"),
    DRILL(
        "drill",
        "<path d=\"M10 18a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H5a3 3 0 0 1-3-3 1 1 0 0 1 1-1z\" />\n  <path d=\"M13 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a1 1 0 0 1 1 1v6a1 1 0 0 1-1 1l-.81 3.242a1 1 0 0 1-.97.758H8\" />\n  <path d=\"M14 4h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M18 6h4\" />\n  <path d=\"m5 10-2 8\" />\n  <path d=\"m7 18 2-8\" />"),
    FIRE_EXTINGUISHER(
        "fire-extinguisher",
        "<path d=\"M15 6.5V3a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3.5\" />\n  <path d=\"M9 18h8\" />\n  <path d=\"M18 3h-3\" />\n  <path d=\"M11 3a6 6 0 0 0-6 6v11\" />\n  <path d=\"M5 13h4\" />\n  <path d=\"M17 10a4 4 0 0 0-8 0v10a2 2 0 0 0 2 2h4a2 2 0 0 0 2-2Z\" />"),
    GAVEL(
        "gavel",
        "<path d=\"m14 13-8.381 8.38a1 1 0 0 1-3.001-3l8.384-8.381\" />\n  <path d=\"m16 16 6-6\" />\n  <path d=\"m21.5 10.5-8-8\" />\n  <path d=\"m8 8 6-6\" />\n  <path d=\"m8.5 7.5 8 8\" />"),
    HAMMER(
        "hammer",
        "<path d=\"m15 12-9.373 9.373a1 1 0 0 1-3.001-3L12 9\" />\n  <path d=\"m18 15 4-4\" />\n  <path d=\"m21.5 11.5-1.914-1.914A2 2 0 0 1 19 8.172v-.344a2 2 0 0 0-.586-1.414l-1.657-1.657A6 6 0 0 0 12.516 3H9l1.243 1.243A6 6 0 0 1 12 8.485V10l2 2h1.172a2 2 0 0 1 1.414.586L18.5 14.5\" />"),
    HARD_HAT(
        "hard-hat",
        "<path d=\"M10 10V5a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v5\" />\n  <path d=\"M14 6a6 6 0 0 1 6 6v3\" />\n  <path d=\"M4 15v-3a6 6 0 0 1 6-6\" />\n  <rect x=\"2\" y=\"15\" width=\"20\" height=\"4\" rx=\"1\" />"),
    HOURGLASS_COG(
        "hourglass-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"M17 2v4.172a2 2 0 0 1-.586 1.414l-8.828 8.828A2 2 0 0 0 7 17.828V22\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.772 16.852.924-.383\" />\n  <path d=\"m20.772 19.148.924.383\" />\n  <path d=\"M5 22h6.159\" />\n  <path d=\"M5 2h14\" />\n  <path d=\"M7 2v4.172a2 2 0 0 0 .586 1.414l5.188 5.188\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    INSPECTION_PANEL(
        "inspection-panel",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7h.01\" />\n  <path d=\"M17 7h.01\" />\n  <path d=\"M7 17h.01\" />\n  <path d=\"M17 17h.01\" />"),
    LAND_PLOT(
        "land-plot",
        "<path d=\"m12 8 6-3-6-3v10\" />\n  <path d=\"m8 11.99-5.5 3.14a1 1 0 0 0 0 1.74l8.5 4.86a2 2 0 0 0 2 0l8.5-4.86a1 1 0 0 0 0-1.74L16 12\" />\n  <path d=\"m6.49 12.85 11.02 6.3\" />\n  <path d=\"M17.51 12.85 6.5 19.15\" />"),
    LENS(
        "lens",
        "<path d=\"M15.725 7.296h.01\" />\n  <path d=\"M6 12a6 6 0 016-6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    LENS_CONCAVE(
        "lens-concave",
        "<path d=\"M7 2a1 1 0 0 0-.8 1.6 14 14 0 0 1 0 16.8A1 1 0 0 0 7 22h10a1 1 0 0 0 .8-1.6 14 14 0 0 1 0-16.8A1 1 0 0 0 17 2z\" />"),
    LENS_CONVEX(
        "lens-convex",
        "<path d=\"M13.433 2a1 1 0 0 1 .824.448 18 18 0 0 1 0 19.104 1 1 0 0 1-.824.448h-2.866a1 1 0 0 1-.824-.448 18 18 0 0 1 0-19.104A1 1 0 0 1 10.567 2z\" />"),
    LINE_STYLE(
        "line-style",
        "<path d=\"M11 5h2\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M19 5h2\" />\n  <path d=\"M3 12h6\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M3 5h2\" />"),
    MINUS("minus", "<path d=\"M5 12h14\" />"),
    MIRROR_RECTANGULAR(
        "mirror-rectangular",
        "<path d=\"M11 6 8 9\" />\n  <path d=\"m16 7-8 8\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    MIRROR_ROUND(
        "mirror-round",
        "<path d=\"M10 6.6 8.6 8\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"M15 7.5 9.5 13\" />\n  <path d=\"M7 22h10\" />\n  <circle cx=\"12\" cy=\"10\" r=\"8\" />"),
    MOP(
        "mop",
        "<path d=\"M10 22c2.761 0 5-1.79 5-4-4.42 0-4.08-5-8.5-5a1 1 0 100 9za3 3 0 01-3-3\" />\n  <path d=\"M12.5 11.5 22 2\" />\n  <path d=\"m6.98 13.02 2.665-2.664a1.21 1.21 0 011.71 0l2.29 2.288a1.21 1.21 0 010 1.712l-2.088 2.087\" />"),
    MOP_SPARKLES(
        "mop-sparkles",
        "<path d=\"M10 22a3 3 0 01-3-3\" />\n  <path d=\"M10 22c2.761 0 5-1.79 5-4-4.42 0-4.08-5-8.5-5a4.501 4.501 0 000 9z\" />\n  <path d=\"M10 3H8\" />\n  <path d=\"M12.5 11.5 22 2\" />\n  <path d=\"M20 13v4\" />\n  <path d=\"M22 15h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"m6.98 13.02 2.665-2.664a1.21 1.21 0 011.71 0l2.29 2.288a1.21 1.21 0 010 1.712l-2.088 2.087\" />\n  <path d=\"M9 2v2\" />"),
    PAINT_BUCKET(
        "paint-bucket",
        "<path d=\"M11 7 6 2\" />\n  <path d=\"M18.992 12H2.041\" />\n  <path d=\"M21.145 18.38A3.34 3.34 0 0 1 20 16.5a3.3 3.3 0 0 1-1.145 1.88c-.575.46-.855 1.02-.855 1.595A2 2 0 0 0 20 22a2 2 0 0 0 2-2.025c0-.58-.285-1.13-.855-1.595\" />\n  <path d=\"m8.5 4.5 2.148-2.148a1.205 1.205 0 0 1 1.704 0l7.296 7.296a1.205 1.205 0 0 1 0 1.704l-7.592 7.592a3.615 3.615 0 0 1-5.112 0l-3.888-3.888a3.615 3.615 0 0 1 0-5.112L5.67 7.33\" />"),
    PAINT_ROLLER(
        "paint-roller",
        "<rect width=\"16\" height=\"6\" x=\"2\" y=\"2\" rx=\"2\" />\n  <path d=\"M10 16v-2a2 2 0 0 1 2-2h8a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />\n  <rect width=\"4\" height=\"6\" x=\"8\" y=\"16\" rx=\"1\" />"),
    PAINTBRUSH(
        "paintbrush",
        "<path d=\"m14.622 17.897-10.68-2.913\" />\n  <path d=\"M18.376 2.622a1 1 0 1 1 3.002 3.002L17.36 9.643a.5.5 0 0 0 0 .707l.944.944a2.41 2.41 0 0 1 0 3.408l-.944.944a.5.5 0 0 1-.707 0L8.354 7.348a.5.5 0 0 1 0-.707l.944-.944a2.41 2.41 0 0 1 3.408 0l.944.944a.5.5 0 0 0 .707 0z\" />\n  <path d=\"M9 8c-1.804 2.71-3.97 3.46-6.583 3.948a.507.507 0 0 0-.302.819l7.32 8.883a1 1 0 0 0 1.185.204C12.735 20.405 16 16.792 16 15\" />"),
    PAINTBRUSH_VERTICAL(
        "paintbrush-vertical",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v4\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v9H6V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 12a1 1 0 0 0-1 1v1a2 2 0 0 0 2 2h2a1 1 0 0 1 1 1v2.9a2 2 0 1 0 4 0V17a1 1 0 0 1 1-1h2a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1\" />"),
    PEN(
        "pen",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_LINE(
        "pen-line",
        "<path d=\"M13 21h8\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_OFF(
        "pen-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m2 2 20 20\" />"),
    PENCIL(
        "pencil",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PENCIL_LINE(
        "pencil-line",
        "<path d=\"M13 21h8\" />\n  <path d=\"m15 5 4 4\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PENCIL_OFF(
        "pencil-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m15 5 4 4\" />\n  <path d=\"m2 2 20 20\" />"),
    PENCIL_RULER(
        "pencil-ruler",
        "<path d=\"M13 7 8.7 2.7a2.41 2.41 0 0 0-3.4 0L2.7 5.3a2.41 2.41 0 0 0 0 3.4L7 13\" />\n  <path d=\"m8 6 2-2\" />\n  <path d=\"m18 16 2-2\" />\n  <path d=\"m17 11 4.3 4.3c.94.94.94 2.46 0 3.4l-2.6 2.6c-.94.94-2.46.94-3.4 0L11 17\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PENCIL_SPARKLES(
        "pencil-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"m15.007 5.008 3.987 3.986\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M21.174 6.813a2.82 2.82 0 0 0-3.986-3.987L3.842 16.175a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    PICKAXE(
        "pickaxe",
        "<path d=\"m14 13-8.381 8.38a1 1 0 0 1-3.001-3L11 9.999\" />\n  <path d=\"M15.973 4.027A13 13 0 0 0 5.902 2.373c-1.398.342-1.092 2.158.277 2.601a19.9 19.9 0 0 1 5.822 3.024\" />\n  <path d=\"M16.001 11.999a19.9 19.9 0 0 1 3.024 5.824c.444 1.369 2.26 1.676 2.603.278A13 13 0 0 0 20 8.069\" />\n  <path d=\"M18.352 3.352a1.205 1.205 0 0 0-1.704 0l-5.296 5.296a1.205 1.205 0 0 0 0 1.704l2.296 2.296a1.205 1.205 0 0 0 1.704 0l5.296-5.296a1.205 1.205 0 0 0 0-1.704z\" />"),
    PLUS("plus", "<path d=\"M5 12h14\" />\n  <path d=\"M12 5v14\" />"),
    POCKET_KNIFE(
        "pocket-knife",
        "<path d=\"M3 2v1c0 1 2 1 2 2S3 6 3 7s2 1 2 2-2 1-2 2 2 1 2 2\" />\n  <path d=\"M18 6h.01\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M20.83 8.83a4 4 0 0 0-5.66-5.66l-12 12a4 4 0 1 0 5.66 5.66Z\" />\n  <path d=\"M18 11.66V22a4 4 0 0 0 4-4V6\" />"),
    PRINTER_3D(
        "printer-3d",
        "<path d=\"M10 11v1\" />\n  <path d=\"M12 8h8\" />\n  <path d=\"M15 20v-3a1 1 0 00-1-1H9a1 1 0 00-1 1v3\" />\n  <path d=\"M4 20h16\" />\n  <path d=\"M4 22V4a2 2 0 012-2h12a2 2 0 012 2v18\" />\n  <path d=\"M4 8h4\" />\n  <path d=\"M8.635 10.093A2 2 0 018 8.631V7a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 01-.293.707l-1 1a1 1 0 01-1.414 0z\" />"),
    RADIUS(
        "radius",
        "<path d=\"M20.34 17.52a10 10 0 1 0-2.82 2.82\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <path d=\"m13.41 13.41 4.18 4.18\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    ROBOT_ARM(
        "robot-arm",
        "<path d=\"M12 21 7.5 8.322\" />\n  <path d=\"m14 7 1.75-3.767a.5.5 0 0 1 .662-.172L20 5.005\" />\n  <path d=\"m20 8.998-3.588 1.944a.5.5 0 0 1-.662-.172L14 7H8\" />\n  <path d=\"M3.486 21h10\" />\n  <path d=\"M5 21V8.732\" />\n  <circle cx=\"6\" cy=\"7\" r=\"2\" />"),
    ROBOT_VACUUM(
        "robot-vacuum",
        "<path d=\"M11 17h2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M17 12a5 5 0 00-10 0\" />\n  <path d=\"M19 2v2.8\" />\n  <path d=\"M2 5h2.8\" />\n  <path d=\"M22 5h-2.8\" />\n  <path d=\"M5 2v2.8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    ROTATE_CCW_SQUARE(
        "rotate-ccw-square",
        "<path d=\"M20 9V7a2 2 0 0 0-2-2h-6\" />\n  <path d=\"m15 2-3 3 3 3\" />\n  <path d=\"M20 13v5a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h2\" />"),
    ROTATE_CW_SQUARE(
        "rotate-cw-square",
        "<path d=\"M12 5H6a2 2 0 0 0-2 2v3\" />\n  <path d=\"m9 8 3-3-3-3\" />\n  <path d=\"M4 14v4a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />"),
    RULER(
        "ruler",
        "<path d=\"M21.3 15.3a2.4 2.4 0 0 1 0 3.4l-2.6 2.6a2.4 2.4 0 0 1-3.4 0L2.7 8.7a2.41 2.41 0 0 1 0-3.4l2.6-2.6a2.41 2.41 0 0 1 3.4 0Z\" />\n  <path d=\"m14.5 12.5 2-2\" />\n  <path d=\"m11.5 9.5 2-2\" />\n  <path d=\"m8.5 6.5 2-2\" />\n  <path d=\"m17.5 15.5 2-2\" />"),
    RULER_DIMENSION_LINE(
        "ruler-dimension-line",
        "<path d=\"M10 15v-3\" />\n  <path d=\"M14 15v-3\" />\n  <path d=\"M18 15v-3\" />\n  <path d=\"M2 8V4\" />\n  <path d=\"M22 6H2\" />\n  <path d=\"M22 8V4\" />\n  <path d=\"M6 15v-3\" />\n  <rect x=\"2\" y=\"12\" width=\"20\" height=\"8\" rx=\"2\" />"),
    SCISSORS(
        "scissors",
        "<circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M8.12 8.12 12 12\" />\n  <path d=\"M20 4 8.12 15.88\" />\n  <circle cx=\"6\" cy=\"18\" r=\"3\" />\n  <path d=\"M14.8 14.8 20 20\" />"),
    SCISSORS_LINE_DASHED(
        "scissors-line-dashed",
        "<path d=\"M5.42 9.42 8 12\" />\n  <circle cx=\"4\" cy=\"8\" r=\"2\" />\n  <path d=\"m14 6-8.58 8.58\" />\n  <circle cx=\"4\" cy=\"16\" r=\"2\" />\n  <path d=\"M10.8 14.8 14 18\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />"),
    SCREW(
        "screw",
        "<path d=\"M10 9v10\" />\n  <path d=\"M14 13v2\" />\n  <path d=\"M16.5 10.5 5.706 21.294A2.4 2.4 0 014.002 22H2.5a.5.5 0 01-.5-.5v-1.502a2.4 2.4 0 01.706-1.704L13.5 7.5\" />\n  <path d=\"M20.819 11.575a6 6 0 00.969-5.162.6.6 0 00-.981-.219l-.455.454a1.2 1.2 0 01-1.704 0l-1.296-1.296a1.2 1.2 0 010-1.704l.454-.453a.595.595 0 00-.219-.98 6 6 0 00-5.162.967 2 2 0 00-.222 3.019l5.596 5.597a2 2 0 003.02-.222\" />\n  <path d=\"M6 13v8\" />"),
    SHOVEL(
        "shovel",
        "<path d=\"M21.56 4.56a1.5 1.5 0 0 1 0 2.122l-.47.47a3 3 0 0 1-4.212-.03 3 3 0 0 1 0-4.243l.44-.44a1.5 1.5 0 0 1 2.121 0z\" />\n  <path d=\"M3 22a1 1 0 0 1-1-1v-3.586a1 1 0 0 1 .293-.707l3.355-3.355a1.205 1.205 0 0 1 1.704 0l3.296 3.296a1.205 1.205 0 0 1 0 1.704l-3.355 3.355a1 1 0 0 1-.707.293z\" />\n  <path d=\"m9 15 7.879-7.878\" />"),
    SPLINE_POINTER(
        "spline-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 17A12 12 0 0 1 17 5\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    SPOOL(
        "spool",
        "<path d=\"M17 13.44 4.442 17.082A2 2 0 0 0 4.982 21H19a2 2 0 0 0 .558-3.921l-1.115-.32A2 2 0 0 1 17 14.837V7.66\" />\n  <path d=\"m7 10.56 12.558-3.642A2 2 0 0 0 19.018 3H5a2 2 0 0 0-.558 3.921l1.115.32A2 2 0 0 1 7 9.163v7.178\" />"),
    SPRAY_CAN(
        "spray-can",
        "<path d=\"M3 3h.01\" />\n  <path d=\"M7 5h.01\" />\n  <path d=\"M11 7h.01\" />\n  <path d=\"M3 7h.01\" />\n  <path d=\"M7 9h.01\" />\n  <path d=\"M3 11h.01\" />\n  <rect width=\"4\" height=\"4\" x=\"15\" y=\"5\" />\n  <path d=\"m19 9 2 2v10c0 .6-.4 1-1 1h-6c-.6 0-1-.4-1-1V11l2-2\" />\n  <path d=\"m13 14 8-2\" />\n  <path d=\"m13 19 8-2\" />"),
    SQUARE_BOTTOM_DASHED_SCISSORS(
        "square-bottom-dashed-scissors",
        "<path d=\"M14 21h1\" />\n  <path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M5 21a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />"),
    SQUARE_DASHED_MOUSE_POINTER(
        "square-dashed-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h2\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v2\" />\n  <path d=\"M3 14v1\" />"),
    SQUARE_MINUS(
        "square-minus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />"),
    SQUARE_MOUSE_POINTER(
        "square-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M21 11V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />"),
    SQUARE_PLUS(
        "square-plus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_SCISSORS(
        "square-scissors",
        "<path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    STAMP(
        "stamp",
        "<path d=\"M14 13V8.5C14 7 15 7 15 5a3 3 0 0 0-6 0c0 2 1 2 1 3.5V13\" />\n  <path d=\"M20 15.5a2.5 2.5 0 0 0-2.5-2.5h-11A2.5 2.5 0 0 0 4 15.5V17a1 1 0 0 0 1 1h14a1 1 0 0 0 1-1z\" />\n  <path d=\"M5 22h14\" />"),
    SWORD(
        "sword",
        "<path d=\"m11 19-6-6\" />\n  <path d=\"m5 21-2-2\" />\n  <path d=\"m8 16-4 4\" />\n  <path d=\"M9.5 17.5 20.414 6.586A2 2 0 0021 5.172V3h-2.172a2 2 0 00-1.414.586L6.5 14.5\" />"),
    SWORDS(
        "swords",
        "<path d=\"m13 19 6-6\" />\n  <path d=\"M14.5 17.5 3.586 6.586A2 2 0 013 5.172V3h2.172a2 2 0 011.414.586L17.5 14.5\" />\n  <path d=\"m14.828 6.172 2.586-2.586A2 2 0 0118.828 3H21v2.172a2 2 0 01-.586 1.414l-2.586 2.586\" />\n  <path d=\"m16 16 4 4\" />\n  <path d=\"m19 21 2-2\" />\n  <path d=\"m5 14 4 4\" />\n  <path d=\"m5 21-2-2\" />\n  <path d=\"M7.5 16.5 4 20\" />"),
    TABLET_SMARTPHONE(
        "tablet-smartphone",
        "<rect width=\"10\" height=\"14\" x=\"3\" y=\"8\" rx=\"2\" />\n  <path d=\"M5 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v16a2 2 0 0 1-2 2h-2.4\" />\n  <path d=\"M8 18h.01\" />"),
    TANGENT(
        "tangent",
        "<circle cx=\"17\" cy=\"4\" r=\"2\" />\n  <path d=\"M15.59 5.41 5.41 15.59\" />\n  <circle cx=\"4\" cy=\"17\" r=\"2\" />\n  <path d=\"M12 22s-4-9-1.5-11.5S22 12 22 12\" />"),
    TELESCOPE(
        "telescope",
        "<path d=\"m10.065 12.493-6.18 1.318a.934.934 0 0 1-1.108-.702l-.537-2.15a1.07 1.07 0 0 1 .691-1.265l13.504-4.44\" />\n  <path d=\"m13.56 11.747 4.332-.924\" />\n  <path d=\"m16 21-3.105-6.21\" />\n  <path d=\"M16.485 5.94a2 2 0 0 1 1.455-2.425l1.09-.272a1 1 0 0 1 1.212.727l1.515 6.06a1 1 0 0 1-.727 1.213l-1.09.272a2 2 0 0 1-2.425-1.455z\" />\n  <path d=\"m6.158 8.633 1.114 4.456\" />\n  <path d=\"m8 21 3.105-6.21\" />\n  <circle cx=\"12\" cy=\"13\" r=\"2\" />"),
    TOOL_CASE(
        "tool-case",
        "<path d=\"M10 15h4\" />\n  <path d=\"m14.5 4.058.571-1.429a1 1 0 011.3-.558l5 2a1 1 0 01.549.534.88.88 0 01.01.765l-2.332 5.83\" />\n  <path d=\"M15.634 11a2 2 0 00-.186-.34l-1.17-1.757 1.31-1.656a2 2 0 00-2.109-3.165l-2.032.57-1.17-1.758a2 2 0 00-3.664 1.028l-.086 2.11-2.032.568a2 2 0 00-.155 3.8l1.617.6\" />\n  <path d=\"M4 12.006A1 1 0 014.994 11H19a1 1 0 011 1v7a2 2 0 01-2 2H6a2 2 0 01-2-2z\" />"),
    TOOLBOX(
        "toolbox",
        "<path d=\"M16 12v4\" />\n  <path d=\"M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v2\" />\n  <path d=\"M17 6a2 2 0 011.414.586l3 3A2 2 0 0122 11v8a2 2 0 01-2 2H4a2 2 0 01-2-2v-8a2 2 0 01.586-1.414l3-3A2 2 0 017 6z\" />\n  <path d=\"M2 14h20\" />\n  <path d=\"M8 12v4\" />"),
    TOOTHBRUSH(
        "toothbrush",
        "<path d=\"M15 11c-2 2-4 2-6 4l-7 7\" />\n  <path d=\"m22 4-7.414 7.414-2-2A2 2 0 0114 6c0-.512.196-1.024.586-1.414A2 2 0 0116 4a2 2 0 013.262-1.552l2.152 2.138\" />"),
    TOOTHBRUSH_SPARKLES(
        "toothbrush-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"M14.586 11.414 22 4\" />\n  <path d=\"M15 11a8 8 0 01-.429.4\" />\n  <path d=\"m2 22 7-7c1.857-1.857 3.714-1.99 5.571-3.6l-1.985-1.986A2 2 0 0114 6a2 2 0 012-2 2 2 0 013.262-1.552l2.152 2.138\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    TORUS(
        "torus",
        "<ellipse cx=\"12\" cy=\"11\" rx=\"3\" ry=\"2\" />\n  <ellipse cx=\"12\" cy=\"12.5\" rx=\"10\" ry=\"8.5\" />"),
    VECTOR_SQUARE(
        "vector-square",
        "<path d=\"M17.055 4.533a24 24 0 00-10.11 0\" />\n  <path d=\"M19.467 17.055a24 24 0 000-10.11\" />\n  <path d=\"M4.533 6.945a24 24 0 000 10.11\" />\n  <path d=\"M6.945 19.467a24 24 0 0010.11 0\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />"),
    WRENCH(
        "wrench",
        "<path d=\"M14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.106-3.105c.32-.322.863-.22.983.218a6 6 0 0 1-8.259 7.057l-7.91 7.91a1 1 0 0 1-2.999-3l7.91-7.91a6 6 0 0 1 7.057-8.259c.438.12.54.662.219.984z\" />"),
    WRENCH_OFF(
        "wrench-off",
        "<path d=\"M10.747 5.093a6 6 0 0 1 6.841-2.882c.438.12.54.662.219.984L14.7 6.3a1 1 0 0 0 0 1.4l1.6 1.6a1 1 0 0 0 1.4 0l3.106-3.105c.32-.322.863-.22.983.218a6 6 0 0 1-2.882 6.842\" />\n  <path d=\"m13.5 13.5-7.88 7.88a1 1 0 0 1-2.999-3l7.88-7.88\" />\n  <path d=\"m2 2 20 20\" />");

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
  default LucideIcon anvil_tools() {
    return LucideIcon.create(Icon.ANVIL);
  }

  default LucideIcon axe_tools() {
    return LucideIcon.create(Icon.AXE);
  }

  default LucideIcon between_horizontal_end_tools() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_END);
  }

  default LucideIcon between_horizontal_start_tools() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_START);
  }

  default LucideIcon between_vertical_end_tools() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_END);
  }

  default LucideIcon between_vertical_start_tools() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_START);
  }

  default LucideIcon blend_tools() {
    return LucideIcon.create(Icon.BLEND);
  }

  default LucideIcon bolt_tools() {
    return LucideIcon.create(Icon.BOLT);
  }

  default LucideIcon bomb_tools() {
    return LucideIcon.create(Icon.BOMB);
  }

  default LucideIcon bow_arrow_tools() {
    return LucideIcon.create(Icon.BOW_ARROW);
  }

  default LucideIcon broom_tools() {
    return LucideIcon.create(Icon.BROOM);
  }

  default LucideIcon broom_sparkles_tools() {
    return LucideIcon.create(Icon.BROOM_SPARKLES);
  }

  default LucideIcon brush_tools() {
    return LucideIcon.create(Icon.BRUSH);
  }

  default LucideIcon brush_cleaning_tools() {
    return LucideIcon.create(Icon.BRUSH_CLEANING);
  }

  default LucideIcon diameter_tools() {
    return LucideIcon.create(Icon.DIAMETER);
  }

  default LucideIcon diamond_minus_tools() {
    return LucideIcon.create(Icon.DIAMOND_MINUS);
  }

  default LucideIcon diamond_plus_tools() {
    return LucideIcon.create(Icon.DIAMOND_PLUS);
  }

  default LucideIcon drafting_compass_tools() {
    return LucideIcon.create(Icon.DRAFTING_COMPASS);
  }

  default LucideIcon drill_tools() {
    return LucideIcon.create(Icon.DRILL);
  }

  default LucideIcon fire_extinguisher_tools() {
    return LucideIcon.create(Icon.FIRE_EXTINGUISHER);
  }

  default LucideIcon gavel_tools() {
    return LucideIcon.create(Icon.GAVEL);
  }

  default LucideIcon hammer_tools() {
    return LucideIcon.create(Icon.HAMMER);
  }

  default LucideIcon hard_hat() {
    return LucideIcon.create(Icon.HARD_HAT);
  }

  default LucideIcon hourglass_cog_tools() {
    return LucideIcon.create(Icon.HOURGLASS_COG);
  }

  default LucideIcon inspection_panel() {
    return LucideIcon.create(Icon.INSPECTION_PANEL);
  }

  default LucideIcon land_plot_tools() {
    return LucideIcon.create(Icon.LAND_PLOT);
  }

  default LucideIcon lens_tools() {
    return LucideIcon.create(Icon.LENS);
  }

  default LucideIcon lens_concave_tools() {
    return LucideIcon.create(Icon.LENS_CONCAVE);
  }

  default LucideIcon lens_convex_tools() {
    return LucideIcon.create(Icon.LENS_CONVEX);
  }

  default LucideIcon line_style_tools() {
    return LucideIcon.create(Icon.LINE_STYLE);
  }

  default LucideIcon minus_tools() {
    return LucideIcon.create(Icon.MINUS);
  }

  default LucideIcon mirror_rectangular_tools() {
    return LucideIcon.create(Icon.MIRROR_RECTANGULAR);
  }

  default LucideIcon mirror_round_tools() {
    return LucideIcon.create(Icon.MIRROR_ROUND);
  }

  default LucideIcon mop_tools() {
    return LucideIcon.create(Icon.MOP);
  }

  default LucideIcon mop_sparkles_tools() {
    return LucideIcon.create(Icon.MOP_SPARKLES);
  }

  default LucideIcon paint_bucket_tools() {
    return LucideIcon.create(Icon.PAINT_BUCKET);
  }

  default LucideIcon paint_roller_tools() {
    return LucideIcon.create(Icon.PAINT_ROLLER);
  }

  default LucideIcon paintbrush_tools() {
    return LucideIcon.create(Icon.PAINTBRUSH);
  }

  default LucideIcon paintbrush_vertical_tools() {
    return LucideIcon.create(Icon.PAINTBRUSH_VERTICAL);
  }

  default LucideIcon pen_tools() {
    return LucideIcon.create(Icon.PEN);
  }

  default LucideIcon pen_line_tools() {
    return LucideIcon.create(Icon.PEN_LINE);
  }

  default LucideIcon pen_off_tools() {
    return LucideIcon.create(Icon.PEN_OFF);
  }

  default LucideIcon pencil_tools() {
    return LucideIcon.create(Icon.PENCIL);
  }

  default LucideIcon pencil_line_tools() {
    return LucideIcon.create(Icon.PENCIL_LINE);
  }

  default LucideIcon pencil_off_tools() {
    return LucideIcon.create(Icon.PENCIL_OFF);
  }

  default LucideIcon pencil_ruler_tools() {
    return LucideIcon.create(Icon.PENCIL_RULER);
  }

  default LucideIcon pencil_sparkles_tools() {
    return LucideIcon.create(Icon.PENCIL_SPARKLES);
  }

  default LucideIcon pickaxe_tools() {
    return LucideIcon.create(Icon.PICKAXE);
  }

  default LucideIcon plus_tools() {
    return LucideIcon.create(Icon.PLUS);
  }

  default LucideIcon pocket_knife() {
    return LucideIcon.create(Icon.POCKET_KNIFE);
  }

  default LucideIcon printer_3d_tools() {
    return LucideIcon.create(Icon.PRINTER_3D);
  }

  default LucideIcon radius_tools() {
    return LucideIcon.create(Icon.RADIUS);
  }

  default LucideIcon robot_arm_tools() {
    return LucideIcon.create(Icon.ROBOT_ARM);
  }

  default LucideIcon robot_vacuum_tools() {
    return LucideIcon.create(Icon.ROBOT_VACUUM);
  }

  default LucideIcon rotate_ccw_square_tools() {
    return LucideIcon.create(Icon.ROTATE_CCW_SQUARE);
  }

  default LucideIcon rotate_cw_square_tools() {
    return LucideIcon.create(Icon.ROTATE_CW_SQUARE);
  }

  default LucideIcon ruler_tools() {
    return LucideIcon.create(Icon.RULER);
  }

  default LucideIcon ruler_dimension_line_tools() {
    return LucideIcon.create(Icon.RULER_DIMENSION_LINE);
  }

  default LucideIcon scissors_tools() {
    return LucideIcon.create(Icon.SCISSORS);
  }

  default LucideIcon scissors_line_dashed_tools() {
    return LucideIcon.create(Icon.SCISSORS_LINE_DASHED);
  }

  default LucideIcon screw() {
    return LucideIcon.create(Icon.SCREW);
  }

  default LucideIcon shovel_tools() {
    return LucideIcon.create(Icon.SHOVEL);
  }

  default LucideIcon spline_pointer_tools() {
    return LucideIcon.create(Icon.SPLINE_POINTER);
  }

  default LucideIcon spool_tools() {
    return LucideIcon.create(Icon.SPOOL);
  }

  default LucideIcon spray_can_tools() {
    return LucideIcon.create(Icon.SPRAY_CAN);
  }

  default LucideIcon square_bottom_dashed_scissors_tools() {
    return LucideIcon.create(Icon.SQUARE_BOTTOM_DASHED_SCISSORS);
  }

  default LucideIcon square_dashed_mouse_pointer_tools() {
    return LucideIcon.create(Icon.SQUARE_DASHED_MOUSE_POINTER);
  }

  default LucideIcon square_minus_tools() {
    return LucideIcon.create(Icon.SQUARE_MINUS);
  }

  default LucideIcon square_mouse_pointer_tools() {
    return LucideIcon.create(Icon.SQUARE_MOUSE_POINTER);
  }

  default LucideIcon square_plus_tools() {
    return LucideIcon.create(Icon.SQUARE_PLUS);
  }

  default LucideIcon square_scissors_tools() {
    return LucideIcon.create(Icon.SQUARE_SCISSORS);
  }

  default LucideIcon stamp_tools() {
    return LucideIcon.create(Icon.STAMP);
  }

  default LucideIcon sword_tools() {
    return LucideIcon.create(Icon.SWORD);
  }

  default LucideIcon swords_tools() {
    return LucideIcon.create(Icon.SWORDS);
  }

  default LucideIcon tablet_smartphone_tools() {
    return LucideIcon.create(Icon.TABLET_SMARTPHONE);
  }

  default LucideIcon tangent_tools() {
    return LucideIcon.create(Icon.TANGENT);
  }

  default LucideIcon telescope_tools() {
    return LucideIcon.create(Icon.TELESCOPE);
  }

  default LucideIcon tool_case_tools() {
    return LucideIcon.create(Icon.TOOL_CASE);
  }

  default LucideIcon toolbox_tools() {
    return LucideIcon.create(Icon.TOOLBOX);
  }

  default LucideIcon toothbrush_tools() {
    return LucideIcon.create(Icon.TOOTHBRUSH);
  }

  default LucideIcon toothbrush_sparkles_tools() {
    return LucideIcon.create(Icon.TOOTHBRUSH_SPARKLES);
  }

  default LucideIcon torus_tools() {
    return LucideIcon.create(Icon.TORUS);
  }

  default LucideIcon vector_square_tools() {
    return LucideIcon.create(Icon.VECTOR_SQUARE);
  }

  default LucideIcon wrench_tools() {
    return LucideIcon.create(Icon.WRENCH);
  }

  default LucideIcon wrench_off_tools() {
    return LucideIcon.create(Icon.WRENCH_OFF);
  }
}
