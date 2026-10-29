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

/** Lucide shapes catalog category. */
public interface LucideShapes {
  enum Icon implements LucideIconDefinition {
    ASTROID(
        "astroid",
        "<path d=\"M12.983 21.186a1 1 0 0 1-1.966 0 10 10 0 0 0-8.203-8.203 1 1 0 0 1 0-1.966 10 10 0 0 0 8.203-8.203 1 1 0 0 1 1.966 0 10 10 0 0 0 8.203 8.203 1 1 0 0 1 0 1.966 10 10 0 0 0-8.203 8.203\" />"),
    BADGE(
        "badge",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />"),
    BADGE_QUESTION_MARK(
        "badge-question-mark",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"17\" y2=\"17\" />"),
    BLOCKS(
        "blocks",
        "<path d=\"M10 22V7a1 1 0 0 0-1-1H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-5a1 1 0 0 0-1-1H2\" />\n  <rect x=\"14\" y=\"2\" width=\"8\" height=\"8\" rx=\"1\" />"),
    BOX(
        "box",
        "<path d=\"M21 8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16Z\" />\n  <path d=\"m3.3 7 8.7 5 8.7-5\" />\n  <path d=\"M12 22V12\" />"),
    BOXES(
        "boxes",
        "<path d=\"M2.97 12.92A2 2 0 0 0 2 14.63v3.24a2 2 0 0 0 .97 1.71l3 1.8a2 2 0 0 0 2.06 0L12 19v-5.5l-5-3-4.03 2.42Z\" />\n  <path d=\"m7 16.5-4.74-2.85\" />\n  <path d=\"m7 16.5 5-3\" />\n  <path d=\"M7 16.5v5.17\" />\n  <path d=\"M12 13.5V19l3.97 2.38a2 2 0 0 0 2.06 0l3-1.8a2 2 0 0 0 .97-1.71v-3.24a2 2 0 0 0-.97-1.71L17 10.5l-5 3Z\" />\n  <path d=\"m17 16.5-5-3\" />\n  <path d=\"m17 16.5 4.74-2.85\" />\n  <path d=\"M17 16.5v5.17\" />\n  <path d=\"M7.97 4.42A2 2 0 0 0 7 6.13v4.37l5 3 5-3V6.13a2 2 0 0 0-.97-1.71l-3-1.8a2 2 0 0 0-2.06 0l-3 1.8Z\" />\n  <path d=\"M12 8 7.26 5.15\" />\n  <path d=\"m12 8 4.74-2.85\" />\n  <path d=\"M12 13.5V8\" />"),
    CIRCLE("circle", "<circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_DASHED(
        "circle-dashed",
        "<path d=\"M10.1 2.182a10 10 0 0 1 3.8 0\" />\n  <path d=\"M13.9 21.818a10 10 0 0 1-3.8 0\" />\n  <path d=\"M17.609 3.721a10 10 0 0 1 2.69 2.7\" />\n  <path d=\"M2.182 13.9a10 10 0 0 1 0-3.8\" />\n  <path d=\"M20.279 17.609a10 10 0 0 1-2.7 2.69\" />\n  <path d=\"M21.818 10.1a10 10 0 0 1 0 3.8\" />\n  <path d=\"M3.721 6.391a10 10 0 0 1 2.7-2.69\" />\n  <path d=\"M6.391 20.279a10 10 0 0 1-2.69-2.7\" />"),
    CIRCLE_DASHED_CHECK(
        "circle-dashed-check",
        "<path d=\"M10.1 2.182a10 10 0 013.8 0\" />\n  <path d=\"M13.9 21.818a10 10 0 01-3.8 0\" />\n  <path d=\"m16 9-5.5 5.5L8 12\" />\n  <path d=\"M17.609 3.721a10 10 0 012.69 2.7\" />\n  <path d=\"M2.182 13.9a10 10 0 010-3.8\" />\n  <path d=\"M20.279 17.609a10 10 0 01-2.7 2.69\" />\n  <path d=\"M21.818 10.1a10 10 0 010 3.8\" />\n  <path d=\"M3.721 6.391a10 10 0 012.7-2.69\" />\n  <path d=\"M6.391 20.279a10 10 0 01-2.69-2.7\" />"),
    CIRCLE_DOT(
        "circle-dot",
        "<circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_DOT_DASHED(
        "circle-dot-dashed",
        "<path d=\"M10.1 2.18a9.93 9.93 0 0 1 3.8 0\" />\n  <path d=\"M17.6 3.71a9.95 9.95 0 0 1 2.69 2.7\" />\n  <path d=\"M21.82 10.1a9.93 9.93 0 0 1 0 3.8\" />\n  <path d=\"M20.29 17.6a9.95 9.95 0 0 1-2.7 2.69\" />\n  <path d=\"M13.9 21.82a9.94 9.94 0 0 1-3.8 0\" />\n  <path d=\"M6.4 20.29a9.95 9.95 0 0 1-2.69-2.7\" />\n  <path d=\"M2.18 13.9a9.93 9.93 0 0 1 0-3.8\" />\n  <path d=\"M3.71 6.4a9.95 9.95 0 0 1 2.7-2.69\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    CIRCLE_OFF(
        "circle-off",
        "<path d=\"m2 2 20 20\" />\n  <path d=\"M8.35 2.69A10 10 0 0 1 21.3 15.65\" />\n  <path d=\"M19.08 19.08A10 10 0 1 1 4.92 4.92\" />"),
    CIRCLE_PILE(
        "circle-pile",
        "<circle cx=\"12\" cy=\"19\" r=\"2\" />\n  <circle cx=\"12\" cy=\"5\" r=\"2\" />\n  <circle cx=\"16\" cy=\"12\" r=\"2\" />\n  <circle cx=\"20\" cy=\"19\" r=\"2\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />\n  <circle cx=\"8\" cy=\"12\" r=\"2\" />"),
    CIRCLE_SLASH_2(
        "circle-slash-2", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M22 2 2 22\" />"),
    CIRCLE_SMALL("circle-small", "<circle cx=\"12\" cy=\"12\" r=\"6\" />"),
    CLUB(
        "club",
        "<path d=\"M17.28 9.05a5.5 5.5 0 1 0-10.56 0A5.5 5.5 0 1 0 12 17.66a5.5 5.5 0 1 0 5.28-8.6Z\" />\n  <path d=\"M12 17.66L12 22\" />"),
    CONE(
        "cone",
        "<path d=\"m20.9 18.55-8-15.98a1 1 0 0 0-1.8 0l-8 15.98\" />\n  <ellipse cx=\"12\" cy=\"19\" rx=\"9\" ry=\"3\" />"),
    CROSS(
        "cross",
        "<path d=\"M4 9a2 2 0 0 0-2 2v2a2 2 0 0 0 2 2h4a1 1 0 0 1 1 1v4a2 2 0 0 0 2 2h2a2 2 0 0 0 2-2v-4a1 1 0 0 1 1-1h4a2 2 0 0 0 2-2v-2a2 2 0 0 0-2-2h-4a1 1 0 0 1-1-1V4a2 2 0 0 0-2-2h-2a2 2 0 0 0-2 2v4a1 1 0 0 1-1 1z\" />"),
    CUBOID(
        "cuboid",
        "<path d=\"M10 22v-8\" />\n  <path d=\"M2.336 8.89 10 14l11.715-7.029\" />\n  <path d=\"M22 14a2 2 0 0 1-.971 1.715l-10 6a2 2 0 0 1-2.138-.05l-6-4A2 2 0 0 1 2 16v-6a2 2 0 0 1 .971-1.715l10-6a2 2 0 0 1 2.138.05l6 4A2 2 0 0 1 22 8z\" />"),
    CYLINDER(
        "cylinder",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5v14a9 3 0 0 0 18 0V5\" />"),
    DIAMETER(
        "diameter",
        "<circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />\n  <path d=\"M6.48 3.66a10 10 0 0 1 13.86 13.86\" />\n  <path d=\"m6.41 6.41 11.18 11.18\" />\n  <path d=\"M3.66 6.48a10 10 0 0 0 13.86 13.86\" />"),
    DIAMOND(
        "diamond",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41l-7.59-7.59a2.41 2.41 0 0 0-3.41 0Z\" />"),
    DOT("dot", "<circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    ELLIPSE("ellipse", "<ellipse cx=\"12\" cy=\"12\" rx=\"10\" ry=\"6\" />"),
    HEART(
        "heart",
        "<path d=\"M2 9.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5l-5.492 5.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5\" />"),
    HEART_X(
        "heart-x",
        "<path d=\"m15.5 12.5 5 5\" />\n  <path d=\"m20.5 12.5-5 5\" />\n  <path d=\"M21.955 8.774a5.5 5.5 0 0 0-9.546-2.95.6.6 0 0 1-.818 0A5.5 5.5 0 0 0 2 9.5c0 2.3 1.5 4 3 5.5l5.508 5.332a2 2 0 0 0 2.57.352\" />"),
    HEXAGON(
        "hexagon",
        "<path d=\"M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z\" />"),
    LENS_CONCAVE(
        "lens-concave",
        "<path d=\"M7 2a1 1 0 0 0-.8 1.6 14 14 0 0 1 0 16.8A1 1 0 0 0 7 22h10a1 1 0 0 0 .8-1.6 14 14 0 0 1 0-16.8A1 1 0 0 0 17 2z\" />"),
    LENS_CONVEX(
        "lens-convex",
        "<path d=\"M13.433 2a1 1 0 0 1 .824.448 18 18 0 0 1 0 19.104 1 1 0 0 1-.824.448h-2.866a1 1 0 0 1-.824-.448 18 18 0 0 1 0-19.104A1 1 0 0 1 10.567 2z\" />"),
    LINE_SQUIGGLE(
        "line-squiggle",
        "<path d=\"M7 3.5c5-2 7 2.5 3 4C1.5 10 2 15 5 16c5 2 9-10 14-7s.5 13.5-4 12c-5-2.5.5-11 6-2\" />"),
    OCTAGON(
        "octagon",
        "<path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />"),
    OCTAGON_ALERT(
        "octagon-alert",
        "<path d=\"M12 16h.01\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M15.312 2a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586l-4.688-4.688A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2z\" />"),
    OCTAGON_PAUSE(
        "octagon-pause",
        "<path d=\"M10 15V9\" />\n  <path d=\"M14 15V9\" />\n  <path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />"),
    PENTAGON(
        "pentagon",
        "<path d=\"M10.83 2.38a2 2 0 0 1 2.34 0l8 5.74a2 2 0 0 1 .73 2.25l-3.04 9.26a2 2 0 0 1-1.9 1.37H7.04a2 2 0 0 1-1.9-1.37L2.1 10.37a2 2 0 0 1 .73-2.25z\" />"),
    PYRAMID(
        "pyramid",
        "<path d=\"M2.5 16.88a1 1 0 0 1-.32-1.43l9-13.02a1 1 0 0 1 1.64 0l9 13.01a1 1 0 0 1-.32 1.44l-8.51 4.86a2 2 0 0 1-1.98 0Z\" />\n  <path d=\"M12 2v20\" />"),
    RADIUS(
        "radius",
        "<path d=\"M20.34 17.52a10 10 0 1 0-2.82 2.82\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <path d=\"m13.41 13.41 4.18 4.18\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    RECTANGLE_HORIZONTAL(
        "rectangle-horizontal", "<rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
    RECTANGLE_VERTICAL(
        "rectangle-vertical", "<rect width=\"12\" height=\"20\" x=\"6\" y=\"2\" rx=\"2\" />"),
    SHAPES(
        "shapes",
        "<path d=\"M8.3 10a.7.7 0 0 1-.626-1.079L11.4 3a.7.7 0 0 1 1.198-.043L16.3 8.9a.7.7 0 0 1-.572 1.1Z\" />\n  <rect x=\"3\" y=\"14\" width=\"7\" height=\"7\" rx=\"1\" />\n  <circle cx=\"17.5\" cy=\"17.5\" r=\"3.5\" />"),
    SHIELD(
        "shield",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />"),
    SHIELD_COG(
        "shield-cog",
        "<path d=\"m10.929 14.467-.383.924\" />\n  <path d=\"M10.929 8.923 10.546 8\" />\n  <path d=\"M13.225 8.923 13.608 8\" />\n  <path d=\"m13.607 15.391-.382-.924\" />\n  <path d=\"m14.849 10.547.923-.383\" />\n  <path d=\"m14.849 12.843.923.383\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m9.305 10.547-.923-.383\" />\n  <path d=\"m9.305 12.843-.923.383\" />\n  <circle cx=\"12.077\" cy=\"11.695\" r=\"3\" />"),
    SHIELD_COG_CORNER(
        "shield-cog-corner",
        "<path d=\"M11 22c-3.806-1.45-7-3.966-7-9V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1v4\" />\n  <path d=\"M14.923 16.547 14 16.164\" />\n  <path d=\"m14.923 18.843-.923.383\" />\n  <path d=\"M16.547 14.923 16.164 14\" />\n  <path d=\"m16.547 20.467-.383.924\" />\n  <path d=\"m18.843 14.923.383-.923\" />\n  <path d=\"m19.225 21.391-.382-.924\" />\n  <path d=\"m20.467 16.547.923-.383\" />\n  <path d=\"m20.467 18.843.923.383\" />\n  <circle cx=\"17.695\" cy=\"17.695\" r=\"3\" />"),
    SPADE(
        "spade",
        "<path d=\"M12 18v4\" />\n  <path d=\"M2 14.499a5.5 5.5 0 0 0 9.591 3.675.6.6 0 0 1 .818.001A5.5 5.5 0 0 0 22 14.5c0-2.29-1.5-4-3-5.5l-5.492-5.312a2 2 0 0 0-3-.02L5 8.999c-1.5 1.5-3 3.2-3 5.5\" />"),
    SPARKLE(
        "sparkle",
        "<path d=\"M11.017 2.814a1 1 0 0 1 1.966 0l1.051 5.558a2 2 0 0 0 1.594 1.594l5.558 1.051a1 1 0 0 1 0 1.966l-5.558 1.051a2 2 0 0 0-1.594 1.594l-1.051 5.558a1 1 0 0 1-1.966 0l-1.051-5.558a2 2 0 0 0-1.594-1.594l-5.558-1.051a1 1 0 0 1 0-1.966l5.558-1.051a2 2 0 0 0 1.594-1.594z\" />"),
    SQUARE("square", "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />"),
    SQUARE_ARROW_RIGHT_ENTER(
        "square-arrow-right-enter",
        "<path d=\"m10 16 4-4-4-4\" />\n  <path d=\"M3 12h11\" />\n  <path d=\"M3 8V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />"),
    SQUARE_ARROW_RIGHT_EXIT(
        "square-arrow-right-exit",
        "<path d=\"M10 12h11\" />\n  <path d=\"m17 16 4-4-4-4\" />\n  <path d=\"M21 6.344V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-1.344\" />"),
    SQUARE_DASHED_PLUS(
        "square-dashed-plus",
        "<path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_EXCLAMATION_POINT(
        "square-exclamation-point",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <line x1=\"12\" x2=\"12\" y1=\"8\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"16\" y2=\"16\" />"),
    SQUARE_OFF(
        "square-off",
        "<path d=\"M20.4 20.4a2 2 0 01-1.4.6H5a2 2 0 01-2-2V5a2 2 0 01.59-1.41\" />\n  <path d=\"M21 15.3V5a2 2 0 00-2-2H8.7\" />\n  <path d=\"M22 22 2 2\" />"),
    SQUARE_TEXT(
        "square-text",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />"),
    SQUIRCLE("squircle", "<path d=\"M12 3c7.2 0 9 1.8 9 9s-1.8 9-9 9-9-1.8-9-9 1.8-9 9-9\" />"),
    SQUIRCLE_DASHED(
        "squircle-dashed",
        "<path d=\"M13.77 3.043a34 34 0 0 0-3.54 0\" />\n  <path d=\"M13.771 20.956a33 33 0 0 1-3.541.001\" />\n  <path d=\"M20.18 17.74c-.51 1.15-1.29 1.93-2.439 2.44\" />\n  <path d=\"M20.18 6.259c-.51-1.148-1.291-1.929-2.44-2.438\" />\n  <path d=\"M20.957 10.23a33 33 0 0 1 0 3.54\" />\n  <path d=\"M3.043 10.23a34 34 0 0 0 .001 3.541\" />\n  <path d=\"M6.26 20.179c-1.15-.508-1.93-1.29-2.44-2.438\" />\n  <path d=\"M6.26 3.82c-1.149.51-1.93 1.291-2.44 2.44\" />"),
    STAR(
        "star",
        "<path d=\"M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z\" />"),
    STAR_CHECK(
        "star-check",
        "<path d=\"m19.06 12.501 2.78-2.707a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />\n  <path d=\"m15 18 2 2 4-4\" />"),
    STAR_MINUS(
        "star-minus",
        "<path d=\"M15 18h6\" />\n  <path d=\"M17.688 14a2.1 2.1 0 0 1 .416-.568l3.736-3.638a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />"),
    STAR_PLUS(
        "star-plus",
        "<path d=\"M11.013 18.582 6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.12 2.12 0 0 0 1.597-1.16l2.309-4.679a.53.53 0 0 1 .95 0l2.31 4.679a2.12 2.12 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904L20 11.5\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    STAR_X(
        "star-x",
        "<path d=\"m15.5 15.5 5 5\" />\n  <path d=\"m20.063 11.525 1.777-1.731a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428a2.1 2.1 0 0 1 .987-.243 2 2 0 0 1 .132.004\" />\n  <path d=\"m20.5 15.5-5 5\" />"),
    TANGENT(
        "tangent",
        "<circle cx=\"17\" cy=\"4\" r=\"2\" />\n  <path d=\"M15.59 5.41 5.41 15.59\" />\n  <circle cx=\"4\" cy=\"17\" r=\"2\" />\n  <path d=\"M12 22s-4-9-1.5-11.5S22 12 22 12\" />"),
    TORUS(
        "torus",
        "<ellipse cx=\"12\" cy=\"11\" rx=\"3\" ry=\"2\" />\n  <ellipse cx=\"12\" cy=\"12.5\" rx=\"10\" ry=\"8.5\" />"),
    TRIANGLE(
        "triangle",
        "<path d=\"M13.73 4a2 2 0 0 0-3.46 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3Z\" />"),
    TRIANGLE_ALERT(
        "triangle-alert",
        "<path d=\"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 17h.01\" />"),
    TRIANGLE_DASHED(
        "triangle-dashed",
        "<path d=\"M10.17 4.193a2 2 0 0 1 3.666.013\" />\n  <path d=\"M14 21h2\" />\n  <path d=\"m15.874 7.743 1 1.732\" />\n  <path d=\"m18.849 12.952 1 1.732\" />\n  <path d=\"M21.824 18.18a2 2 0 0 1-1.835 2.824\" />\n  <path d=\"M4.024 21a2 2 0 0 1-1.839-2.839\" />\n  <path d=\"m5.136 12.952-1 1.732\" />\n  <path d=\"M8 21h2\" />\n  <path d=\"m8.102 7.743-1 1.732\" />"),
    TRIANGLE_RIGHT(
        "triangle-right",
        "<path d=\"M22 18a2 2 0 0 1-2 2H3c-1.1 0-1.3-.6-.4-1.3L20.4 4.3c.9-.7 1.6-.4 1.6.7Z\" />"),
    UNGROUP(
        "ungroup",
        "<rect x=\"11\" y=\"14\" width=\"10\" height=\"7\" rx=\"2\" />\n  <rect x=\"3\" y=\"3\" width=\"10\" height=\"7\" rx=\"2\" />"),
    VECTOR_POLYGON(
        "vector-polygon",
        "<path d=\"m12.828 4.813 5.344 2.375\" />\n  <path d=\"m15.769 18.153 3.461-8.306\" />\n  <path d=\"m5.687 14.074 7.625 4.852\" />\n  <path d=\"M9.772 5.579 5.228 11.42\" />\n  <circle cx=\"11\" cy=\"4\" r=\"2\" />\n  <circle cx=\"15\" cy=\"20\" r=\"2\" />\n  <circle cx=\"20\" cy=\"8\" r=\"2\" />\n  <circle cx=\"4\" cy=\"13\" r=\"2\" />"),
    VECTOR_SQUARE(
        "vector-square",
        "<path d=\"M17.055 4.533a24 24 0 00-10.11 0\" />\n  <path d=\"M19.467 17.055a24 24 0 000-10.11\" />\n  <path d=\"M4.533 6.945a24 24 0 000 10.11\" />\n  <path d=\"M6.945 19.467a24 24 0 0010.11 0\" />\n  <circle cx=\"19\" cy=\"19\" r=\"2\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"5\" r=\"2\" />");

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
  default LucideIcon astroid_shapes() {
    return LucideIcon.create(Icon.ASTROID);
  }

  default LucideIcon badge_shapes() {
    return LucideIcon.create(Icon.BADGE);
  }

  default LucideIcon badge_question_mark_shapes() {
    return LucideIcon.create(Icon.BADGE_QUESTION_MARK);
  }

  default LucideIcon blocks_shapes() {
    return LucideIcon.create(Icon.BLOCKS);
  }

  default LucideIcon box_shapes() {
    return LucideIcon.create(Icon.BOX);
  }

  default LucideIcon boxes_shapes() {
    return LucideIcon.create(Icon.BOXES);
  }

  default LucideIcon circle() {
    return LucideIcon.create(Icon.CIRCLE);
  }

  default LucideIcon circle_dashed_shapes() {
    return LucideIcon.create(Icon.CIRCLE_DASHED);
  }

  default LucideIcon circle_dashed_check_shapes() {
    return LucideIcon.create(Icon.CIRCLE_DASHED_CHECK);
  }

  default LucideIcon circle_dot_shapes() {
    return LucideIcon.create(Icon.CIRCLE_DOT);
  }

  default LucideIcon circle_dot_dashed_shapes() {
    return LucideIcon.create(Icon.CIRCLE_DOT_DASHED);
  }

  default LucideIcon circle_off() {
    return LucideIcon.create(Icon.CIRCLE_OFF);
  }

  default LucideIcon circle_pile() {
    return LucideIcon.create(Icon.CIRCLE_PILE);
  }

  default LucideIcon circle_slash_2_shapes() {
    return LucideIcon.create(Icon.CIRCLE_SLASH_2);
  }

  default LucideIcon circle_small_shapes() {
    return LucideIcon.create(Icon.CIRCLE_SMALL);
  }

  default LucideIcon club_shapes() {
    return LucideIcon.create(Icon.CLUB);
  }

  default LucideIcon cone_shapes() {
    return LucideIcon.create(Icon.CONE);
  }

  default LucideIcon cross() {
    return LucideIcon.create(Icon.CROSS);
  }

  default LucideIcon cuboid_shapes() {
    return LucideIcon.create(Icon.CUBOID);
  }

  default LucideIcon cylinder_shapes() {
    return LucideIcon.create(Icon.CYLINDER);
  }

  default LucideIcon diameter_shapes() {
    return LucideIcon.create(Icon.DIAMETER);
  }

  default LucideIcon diamond_shapes() {
    return LucideIcon.create(Icon.DIAMOND);
  }

  default LucideIcon dot_shapes() {
    return LucideIcon.create(Icon.DOT);
  }

  default LucideIcon ellipse() {
    return LucideIcon.create(Icon.ELLIPSE);
  }

  default LucideIcon heart_shapes() {
    return LucideIcon.create(Icon.HEART);
  }

  default LucideIcon heart_x_shapes() {
    return LucideIcon.create(Icon.HEART_X);
  }

  default LucideIcon hexagon_shapes() {
    return LucideIcon.create(Icon.HEXAGON);
  }

  default LucideIcon lens_concave_shapes() {
    return LucideIcon.create(Icon.LENS_CONCAVE);
  }

  default LucideIcon lens_convex_shapes() {
    return LucideIcon.create(Icon.LENS_CONVEX);
  }

  default LucideIcon line_squiggle_shapes() {
    return LucideIcon.create(Icon.LINE_SQUIGGLE);
  }

  default LucideIcon octagon() {
    return LucideIcon.create(Icon.OCTAGON);
  }

  default LucideIcon octagon_alert_shapes() {
    return LucideIcon.create(Icon.OCTAGON_ALERT);
  }

  default LucideIcon octagon_pause_shapes() {
    return LucideIcon.create(Icon.OCTAGON_PAUSE);
  }

  default LucideIcon pentagon() {
    return LucideIcon.create(Icon.PENTAGON);
  }

  default LucideIcon pyramid_shapes() {
    return LucideIcon.create(Icon.PYRAMID);
  }

  default LucideIcon radius_shapes() {
    return LucideIcon.create(Icon.RADIUS);
  }

  default LucideIcon rectangle_horizontal_shapes() {
    return LucideIcon.create(Icon.RECTANGLE_HORIZONTAL);
  }

  default LucideIcon rectangle_vertical_shapes() {
    return LucideIcon.create(Icon.RECTANGLE_VERTICAL);
  }

  default LucideIcon shapes_shapes() {
    return LucideIcon.create(Icon.SHAPES);
  }

  default LucideIcon shield_shapes() {
    return LucideIcon.create(Icon.SHIELD);
  }

  default LucideIcon shield_cog_shapes() {
    return LucideIcon.create(Icon.SHIELD_COG);
  }

  default LucideIcon shield_cog_corner_shapes() {
    return LucideIcon.create(Icon.SHIELD_COG_CORNER);
  }

  default LucideIcon spade_shapes() {
    return LucideIcon.create(Icon.SPADE);
  }

  default LucideIcon sparkle() {
    return LucideIcon.create(Icon.SPARKLE);
  }

  default LucideIcon square_shapes() {
    return LucideIcon.create(Icon.SQUARE);
  }

  default LucideIcon square_arrow_right_enter_shapes() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_ENTER);
  }

  default LucideIcon square_arrow_right_exit_shapes() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_EXIT);
  }

  default LucideIcon square_dashed_plus_shapes() {
    return LucideIcon.create(Icon.SQUARE_DASHED_PLUS);
  }

  default LucideIcon square_exclamation_point_shapes() {
    return LucideIcon.create(Icon.SQUARE_EXCLAMATION_POINT);
  }

  default LucideIcon square_off_shapes() {
    return LucideIcon.create(Icon.SQUARE_OFF);
  }

  default LucideIcon square_text_shapes() {
    return LucideIcon.create(Icon.SQUARE_TEXT);
  }

  default LucideIcon squircle() {
    return LucideIcon.create(Icon.SQUIRCLE);
  }

  default LucideIcon squircle_dashed_shapes() {
    return LucideIcon.create(Icon.SQUIRCLE_DASHED);
  }

  default LucideIcon star_shapes() {
    return LucideIcon.create(Icon.STAR);
  }

  default LucideIcon star_check_shapes() {
    return LucideIcon.create(Icon.STAR_CHECK);
  }

  default LucideIcon star_minus_shapes() {
    return LucideIcon.create(Icon.STAR_MINUS);
  }

  default LucideIcon star_plus_shapes() {
    return LucideIcon.create(Icon.STAR_PLUS);
  }

  default LucideIcon star_x_shapes() {
    return LucideIcon.create(Icon.STAR_X);
  }

  default LucideIcon tangent_shapes() {
    return LucideIcon.create(Icon.TANGENT);
  }

  default LucideIcon torus_shapes() {
    return LucideIcon.create(Icon.TORUS);
  }

  default LucideIcon triangle() {
    return LucideIcon.create(Icon.TRIANGLE);
  }

  default LucideIcon triangle_alert_shapes() {
    return LucideIcon.create(Icon.TRIANGLE_ALERT);
  }

  default LucideIcon triangle_dashed() {
    return LucideIcon.create(Icon.TRIANGLE_DASHED);
  }

  default LucideIcon triangle_right_shapes() {
    return LucideIcon.create(Icon.TRIANGLE_RIGHT);
  }

  default LucideIcon ungroup_shapes() {
    return LucideIcon.create(Icon.UNGROUP);
  }

  default LucideIcon vector_polygon_shapes() {
    return LucideIcon.create(Icon.VECTOR_POLYGON);
  }

  default LucideIcon vector_square_shapes() {
    return LucideIcon.create(Icon.VECTOR_SQUARE);
  }
}
