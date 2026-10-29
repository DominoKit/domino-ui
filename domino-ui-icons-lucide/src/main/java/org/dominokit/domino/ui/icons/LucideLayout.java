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

/** Lucide layout catalog category. */
public interface LucideLayout {
  enum Icon implements LucideIconDefinition {
    ALIGN_CENTER_HORIZONTAL(
        "align-center-horizontal",
        "<path d=\"M2 12h20\" />\n  <path d=\"M10 16v4a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-4\" />\n  <path d=\"M10 8V4a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v4\" />\n  <path d=\"M20 16v1a2 2 0 0 1-2 2h-2a2 2 0 0 1-2-2v-1\" />\n  <path d=\"M14 8V7c0-1.1.9-2 2-2h2a2 2 0 0 1 2 2v1\" />"),
    ALIGN_CENTER_VERTICAL(
        "align-center-vertical",
        "<path d=\"M12 2v20\" />\n  <path d=\"M8 10H4a2 2 0 0 1-2-2V6c0-1.1.9-2 2-2h4\" />\n  <path d=\"M16 10h4a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2h-4\" />\n  <path d=\"M8 20H7a2 2 0 0 1-2-2v-2c0-1.1.9-2 2-2h1\" />\n  <path d=\"M16 14h1a2 2 0 0 1 2 2v2a2 2 0 0 1-2 2h-1\" />"),
    ALIGN_END_HORIZONTAL(
        "align-end-horizontal",
        "<rect width=\"6\" height=\"16\" x=\"4\" y=\"2\" rx=\"2\" />\n  <rect width=\"6\" height=\"9\" x=\"14\" y=\"9\" rx=\"2\" />\n  <path d=\"M22 22H2\" />"),
    ALIGN_END_VERTICAL(
        "align-end-vertical",
        "<rect width=\"16\" height=\"6\" x=\"2\" y=\"4\" rx=\"2\" />\n  <rect width=\"9\" height=\"6\" x=\"9\" y=\"14\" rx=\"2\" />\n  <path d=\"M22 22V2\" />"),
    ALIGN_HORIZONTAL_DISTRIBUTE_CENTER(
        "align-horizontal-distribute-center",
        "<rect width=\"6\" height=\"14\" x=\"4\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"14\" y=\"7\" rx=\"2\" />\n  <path d=\"M17 22v-5\" />\n  <path d=\"M17 7V2\" />\n  <path d=\"M7 22v-3\" />\n  <path d=\"M7 5V2\" />"),
    ALIGN_HORIZONTAL_DISTRIBUTE_END(
        "align-horizontal-distribute-end",
        "<rect width=\"6\" height=\"14\" x=\"4\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"14\" y=\"7\" rx=\"2\" />\n  <path d=\"M10 2v20\" />\n  <path d=\"M20 2v20\" />"),
    ALIGN_HORIZONTAL_DISTRIBUTE_START(
        "align-horizontal-distribute-start",
        "<rect width=\"6\" height=\"14\" x=\"4\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"14\" y=\"7\" rx=\"2\" />\n  <path d=\"M4 2v20\" />\n  <path d=\"M14 2v20\" />"),
    ALIGN_HORIZONTAL_JUSTIFY_CENTER(
        "align-horizontal-justify-center",
        "<rect width=\"6\" height=\"14\" x=\"2\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"16\" y=\"7\" rx=\"2\" />\n  <path d=\"M12 2v20\" />"),
    ALIGN_HORIZONTAL_JUSTIFY_END(
        "align-horizontal-justify-end",
        "<rect width=\"6\" height=\"14\" x=\"2\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"12\" y=\"7\" rx=\"2\" />\n  <path d=\"M22 2v20\" />"),
    ALIGN_HORIZONTAL_JUSTIFY_START(
        "align-horizontal-justify-start",
        "<rect width=\"6\" height=\"14\" x=\"6\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"16\" y=\"7\" rx=\"2\" />\n  <path d=\"M2 2v20\" />"),
    ALIGN_HORIZONTAL_SPACE_AROUND(
        "align-horizontal-space-around",
        "<rect width=\"6\" height=\"10\" x=\"9\" y=\"7\" rx=\"2\" />\n  <path d=\"M4 22V2\" />\n  <path d=\"M20 22V2\" />"),
    ALIGN_HORIZONTAL_SPACE_BETWEEN(
        "align-horizontal-space-between",
        "<rect width=\"6\" height=\"14\" x=\"3\" y=\"5\" rx=\"2\" />\n  <rect width=\"6\" height=\"10\" x=\"15\" y=\"7\" rx=\"2\" />\n  <path d=\"M3 2v20\" />\n  <path d=\"M21 2v20\" />"),
    ALIGN_START_HORIZONTAL(
        "align-start-horizontal",
        "<rect width=\"6\" height=\"16\" x=\"4\" y=\"6\" rx=\"2\" />\n  <rect width=\"6\" height=\"9\" x=\"14\" y=\"6\" rx=\"2\" />\n  <path d=\"M22 2H2\" />"),
    ALIGN_START_VERTICAL(
        "align-start-vertical",
        "<rect width=\"9\" height=\"6\" x=\"6\" y=\"14\" rx=\"2\" />\n  <rect width=\"16\" height=\"6\" x=\"6\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 2v20\" />"),
    ALIGN_VERTICAL_DISTRIBUTE_CENTER(
        "align-vertical-distribute-center",
        "<path d=\"M22 17h-3\" />\n  <path d=\"M22 7h-5\" />\n  <path d=\"M5 17H2\" />\n  <path d=\"M7 7H2\" />\n  <rect x=\"5\" y=\"14\" width=\"14\" height=\"6\" rx=\"2\" />\n  <rect x=\"7\" y=\"4\" width=\"10\" height=\"6\" rx=\"2\" />"),
    ALIGN_VERTICAL_DISTRIBUTE_END(
        "align-vertical-distribute-end",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"14\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 20h20\" />\n  <path d=\"M2 10h20\" />"),
    ALIGN_VERTICAL_DISTRIBUTE_START(
        "align-vertical-distribute-start",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"14\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 14h20\" />\n  <path d=\"M2 4h20\" />"),
    ALIGN_VERTICAL_JUSTIFY_CENTER(
        "align-vertical-justify-center",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"16\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"2\" rx=\"2\" />\n  <path d=\"M2 12h20\" />"),
    ALIGN_VERTICAL_JUSTIFY_END(
        "align-vertical-justify-end",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"12\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"2\" rx=\"2\" />\n  <path d=\"M2 22h20\" />"),
    ALIGN_VERTICAL_JUSTIFY_START(
        "align-vertical-justify-start",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"16\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"6\" rx=\"2\" />\n  <path d=\"M2 2h20\" />"),
    ALIGN_VERTICAL_SPACE_AROUND(
        "align-vertical-space-around",
        "<rect width=\"10\" height=\"6\" x=\"7\" y=\"9\" rx=\"2\" />\n  <path d=\"M22 20H2\" />\n  <path d=\"M22 4H2\" />"),
    ALIGN_VERTICAL_SPACE_BETWEEN(
        "align-vertical-space-between",
        "<rect width=\"14\" height=\"6\" x=\"5\" y=\"15\" rx=\"2\" />\n  <rect width=\"10\" height=\"6\" x=\"7\" y=\"3\" rx=\"2\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M2 3h20\" />"),
    APP_WINDOW(
        "app-window",
        "<rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />\n  <path d=\"M10 4v4\" />\n  <path d=\"M2 8h20\" />\n  <path d=\"M6 4v4\" />"),
    APP_WINDOW_MAC(
        "app-window-mac",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M10 8h.01\" />\n  <path d=\"M14 8h.01\" />"),
    ARROW_DOWN_0_1(
        "arrow-down-0-1",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <rect x=\"15\" y=\"4\" width=\"4\" height=\"6\" ry=\"2\" />\n  <path d=\"M17 20v-6h-2\" />\n  <path d=\"M15 20h4\" />"),
    ARROW_DOWN_1_0(
        "arrow-down-1-0",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M17 10V4h-2\" />\n  <path d=\"M15 10h4\" />\n  <rect x=\"15\" y=\"14\" width=\"4\" height=\"6\" ry=\"2\" />"),
    ARROW_DOWN_A_Z(
        "arrow-down-a-z",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M20 8h-5\" />\n  <path d=\"M15 10V6.5a2.5 2.5 0 0 1 5 0V10\" />\n  <path d=\"M15 14h5l-5 6h5\" />"),
    ARROW_DOWN_NARROW_WIDE(
        "arrow-down-narrow-wide",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M11 4h4\" />\n  <path d=\"M11 8h7\" />\n  <path d=\"M11 12h10\" />"),
    ARROW_DOWN_WIDE_NARROW(
        "arrow-down-wide-narrow",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M11 4h10\" />\n  <path d=\"M11 8h7\" />\n  <path d=\"M11 12h4\" />"),
    ARROW_DOWN_Z_A(
        "arrow-down-z-a",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M15 4h5l-5 6h5\" />\n  <path d=\"M15 20v-3.5a2.5 2.5 0 0 1 5 0V20\" />\n  <path d=\"M20 18h-5\" />"),
    ARROW_UP_0_1(
        "arrow-up-0-1",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <rect x=\"15\" y=\"4\" width=\"4\" height=\"6\" ry=\"2\" />\n  <path d=\"M17 20v-6h-2\" />\n  <path d=\"M15 20h4\" />"),
    ARROW_UP_1_0(
        "arrow-up-1-0",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M17 10V4h-2\" />\n  <path d=\"M15 10h4\" />\n  <rect x=\"15\" y=\"14\" width=\"4\" height=\"6\" ry=\"2\" />"),
    ARROW_UP_A_Z(
        "arrow-up-a-z",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M20 8h-5\" />\n  <path d=\"M15 10V6.5a2.5 2.5 0 0 1 5 0V10\" />\n  <path d=\"M15 14h5l-5 6h5\" />"),
    ARROW_UP_NARROW_WIDE(
        "arrow-up-narrow-wide",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M11 12h4\" />\n  <path d=\"M11 16h7\" />\n  <path d=\"M11 20h10\" />"),
    ARROW_UP_WIDE_NARROW(
        "arrow-up-wide-narrow",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M11 12h10\" />\n  <path d=\"M11 16h7\" />\n  <path d=\"M11 20h4\" />"),
    ARROW_UP_Z_A(
        "arrow-up-z-a",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M15 4h5l-5 6h5\" />\n  <path d=\"M15 20v-3.5a2.5 2.5 0 0 1 5 0V20\" />\n  <path d=\"M20 18h-5\" />"),
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
    BLOCKS(
        "blocks",
        "<path d=\"M10 22V7a1 1 0 0 0-1-1H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-5a1 1 0 0 0-1-1H2\" />\n  <rect x=\"14\" y=\"2\" width=\"8\" height=\"8\" rx=\"1\" />"),
    BRING_TO_FRONT(
        "bring-to-front",
        "<rect x=\"8\" y=\"8\" width=\"8\" height=\"8\" rx=\"2\" />\n  <path d=\"M4 10a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2\" />\n  <path d=\"M14 20a2 2 0 0 0 2 2h4a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2\" />"),
    CIRCLE_ELLIPSIS(
        "circle-ellipsis",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M17 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M7 12h.01\" />"),
    COLUMNS_2(
        "columns-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 3v18\" />"),
    COLUMNS_3(
        "columns-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    COLUMNS_3_COG(
        "columns-3-cog",
        "<path d=\"M10.6 21H5a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v5.6\" />\n  <path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"M15 3v7.6\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <path d=\"M9 3v18\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    COLUMNS_4(
        "columns-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7.5 3v18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M16.5 3v18\" />"),
    DOCK(
        "dock",
        "<path d=\"M2 8h20\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 16h12\" />"),
    ELLIPSIS(
        "ellipsis",
        "<circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <circle cx=\"19\" cy=\"12\" r=\"1\" />\n  <circle cx=\"5\" cy=\"12\" r=\"1\" />"),
    ELLIPSIS_VERTICAL(
        "ellipsis-vertical",
        "<circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <circle cx=\"12\" cy=\"5\" r=\"1\" />\n  <circle cx=\"12\" cy=\"19\" r=\"1\" />"),
    FOLD_HORIZONTAL(
        "fold-horizontal",
        "<path d=\"M2 12h6\" />\n  <path d=\"M22 12h-6\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m19 9-3 3 3 3\" />\n  <path d=\"m5 15 3-3-3-3\" />"),
    FOLD_VERTICAL(
        "fold-vertical",
        "<path d=\"M12 22v-6\" />\n  <path d=\"M12 8V2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"m15 19-3-3-3 3\" />\n  <path d=\"m15 5-3 3-3-3\" />"),
    FULLSCREEN(
        "fullscreen",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"10\" height=\"8\" x=\"7\" y=\"8\" rx=\"1\" />"),
    FUNNEL(
        "funnel",
        "<path d=\"M10 20a1 1 0 0 0 .553.895l2 1A1 1 0 0 0 14 21v-7a2 2 0 0 1 .517-1.341L21.74 4.67A1 1 0 0 0 21 3H3a1 1 0 0 0-.742 1.67l7.225 7.989A2 2 0 0 1 10 14z\" />"),
    FUNNEL_PLUS(
        "funnel-plus",
        "<path d=\"M13.354 3H3a1 1 0 0 0-.742 1.67l7.225 7.989A2 2 0 0 1 10 14v6a1 1 0 0 0 .553.895l2 1A1 1 0 0 0 14 21v-7a2 2 0 0 1 .517-1.341l1.218-1.348\" />\n  <path d=\"M16 6h6\" />\n  <path d=\"M19 3v6\" />"),
    FUNNEL_X(
        "funnel-x",
        "<path d=\"M12.531 3H3a1 1 0 0 0-.742 1.67l7.225 7.989A2 2 0 0 1 10 14v6a1 1 0 0 0 .553.895l2 1A1 1 0 0 0 14 21v-7a2 2 0 0 1 .517-1.341l.427-.473\" />\n  <path d=\"m16.5 3.5 5 5\" />\n  <path d=\"m21.5 3.5-5 5\" />"),
    GALLERY_HORIZONTAL(
        "gallery-horizontal",
        "<path d=\"M2 3v18\" />\n  <rect width=\"12\" height=\"18\" x=\"6\" y=\"3\" rx=\"2\" />\n  <path d=\"M22 3v18\" />"),
    GALLERY_HORIZONTAL_END(
        "gallery-horizontal-end",
        "<path d=\"M2 7v10\" />\n  <path d=\"M6 5v14\" />\n  <rect width=\"12\" height=\"18\" x=\"10\" y=\"3\" rx=\"2\" />"),
    GALLERY_THUMBNAILS(
        "gallery-thumbnails",
        "<rect width=\"18\" height=\"14\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M4 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M19 21h1\" />"),
    GALLERY_VERTICAL(
        "gallery-vertical",
        "<path d=\"M3 2h18\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"6\" rx=\"2\" />\n  <path d=\"M3 22h18\" />"),
    GALLERY_VERTICAL_END(
        "gallery-vertical-end",
        "<path d=\"M7 2h10\" />\n  <path d=\"M5 6h14\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"10\" rx=\"2\" />"),
    GAP_HORIZONTAL(
        "gap-horizontal",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"M21 3h-3a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 3h3a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H3\" />"),
    GAP_VERTICAL(
        "gap-vertical",
        "<path d=\"M2 12h2\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M14 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M3 21v-3a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v3\" />\n  <path d=\"M3 3v3a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V3\" />"),
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
    GRID_3X3(
        "grid-3x3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    GRIP(
        "grip",
        "<circle cx=\"12\" cy=\"5\" r=\"1\" />\n  <circle cx=\"19\" cy=\"5\" r=\"1\" />\n  <circle cx=\"5\" cy=\"5\" r=\"1\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <circle cx=\"19\" cy=\"12\" r=\"1\" />\n  <circle cx=\"5\" cy=\"12\" r=\"1\" />\n  <circle cx=\"12\" cy=\"19\" r=\"1\" />\n  <circle cx=\"19\" cy=\"19\" r=\"1\" />\n  <circle cx=\"5\" cy=\"19\" r=\"1\" />"),
    GRIP_HORIZONTAL(
        "grip-horizontal",
        "<circle cx=\"12\" cy=\"9\" r=\"1\" />\n  <circle cx=\"19\" cy=\"9\" r=\"1\" />\n  <circle cx=\"5\" cy=\"9\" r=\"1\" />\n  <circle cx=\"12\" cy=\"15\" r=\"1\" />\n  <circle cx=\"19\" cy=\"15\" r=\"1\" />\n  <circle cx=\"5\" cy=\"15\" r=\"1\" />"),
    GRIP_VERTICAL(
        "grip-vertical",
        "<circle cx=\"9\" cy=\"12\" r=\"1\" />\n  <circle cx=\"9\" cy=\"5\" r=\"1\" />\n  <circle cx=\"9\" cy=\"19\" r=\"1\" />\n  <circle cx=\"15\" cy=\"12\" r=\"1\" />\n  <circle cx=\"15\" cy=\"5\" r=\"1\" />\n  <circle cx=\"15\" cy=\"19\" r=\"1\" />"),
    HAND_GRAB(
        "hand-grab",
        "<path d=\"M18 11.5V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1.4\" />\n  <path d=\"M14 10V8a2 2 0 0 0-2-2a2 2 0 0 0-2 2v2\" />\n  <path d=\"M10 9.9V9a2 2 0 0 0-2-2a2 2 0 0 0-2 2v5\" />\n  <path d=\"M6 14a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M18 11a2 2 0 1 1 4 0v3a8 8 0 0 1-8 8h-4a8 8 0 0 1-8-8 2 2 0 1 1 4 0\" />"),
    LAYER_ARROW_DOWN(
        "layer-arrow-down",
        "<path d=\"M12 10v10\" />\n  <path d=\"M22 10a1 1 0 01-.59.92l-5.077 2.308\" />\n  <path d=\"M22.017 10.005a1 1 0 00-.597-.916l-8.59-3.91a2 2 0 00-1.66.001L2.6 9.08a1 1 0 00-.02 1.831l5.093 2.316\" />\n  <path d=\"m9 17 3 3 3-3\" />"),
    LAYER_ARROW_UP(
        "layer-arrow-up",
        "<path d=\"M12 14V4\" />\n  <path d=\"M7.674 10.774 2.58 13.09a1 1 0 000 1.822l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92 1 1 0 00-.59-.922l-5.078-2.308\" />\n  <path d=\"m9 7 3-3 3 3\" />"),
    LAYERS(
        "layers",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 1.66 0l8.58-3.9a1 1 0 0 0 0-1.83z\" />\n  <path d=\"M2 12a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l8.58-3.9A1 1 0 0 0 22 12\" />\n  <path d=\"M2 17a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l8.58-3.9A1 1 0 0 0 22 17\" />"),
    LAYERS_2(
        "layers-2",
        "<path d=\"M13 13.74a2 2 0 0 1-2 0L2.5 8.87a1 1 0 0 1 0-1.74L11 2.26a2 2 0 0 1 2 0l8.5 4.87a1 1 0 0 1 0 1.74z\" />\n  <path d=\"m20 14.285 1.5.845a1 1 0 0 1 0 1.74L13 21.74a2 2 0 0 1-2 0l-8.5-4.87a1 1 0 0 1 0-1.74l1.5-.845\" />"),
    LAYERS_ARROW_DOWN(
        "layers-arrow-down",
        "<path d=\"M12 7v15\" />\n  <path d=\"M2 12a1 1 0 00.58.91l5.093 2.316\" />\n  <path d=\"M22 12a1 1 0 01-.59.92l-5.077 2.308\" />\n  <path d=\"M8 10.37 2.6 7.91a1 1 0 010-1.831l8.57-3.9a2 2 0 011.66.001l8.59 3.91a1 1 0 010 1.831l-5.392 2.45\" />\n  <path d=\"m9 19 3 3 3-3\" />"),
    LAYERS_ARROW_UP(
        "layers-arrow-up",
        "<path d=\"M12 12V2\" />\n  <path d=\"M2 17.002a1 1 0 00.58.91l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92\" />\n  <path d=\"M7.674 8.774 2.58 11.09a1 1 0 000 1.822l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92 1 1 0 00-.59-.922l-5.078-2.308\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    LAYERS_MINUS(
        "layers-minus",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l8.58-3.9a1 1 0 0 0 0-1.832z\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M2.003 11.995a1 1 0 0 0 .597.915l8.58 3.91a2 2 0 0 0 .83.18\" />\n  <path d=\"M2.003 16.995a1 1 0 0 0 .597.915l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l2.11-.96\" />\n  <path d=\"M22.018 12.004a1 1 0 0 1-.598.916l-.177.08\" />"),
    LAYERS_PLUS(
        "layers-plus",
        "<path d=\"M12.83 2.18a2 2 0 0 0-1.66 0L2.6 6.08a1 1 0 0 0 0 1.83l8.58 3.91a2 2 0 0 0 .83.18 2 2 0 0 0 .83-.18l8.58-3.9a1 1 0 0 0 0-1.831z\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />\n  <path d=\"M2 12a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 .825.178\" />\n  <path d=\"M2 17a1 1 0 0 0 .58.91l8.6 3.91a2 2 0 0 0 1.65 0l2.116-.962\" />"),
    LAYOUT_ARROW_DOWN(
        "layout-arrow-down",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M18 3v18\" />\n  <path d=\"m21 18-3 3-3-3\" />"),
    LAYOUT_ARROW_RIGHT(
        "layout-arrow-right",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <path d=\"M3 18h18\" />\n  <path d=\"m18 21 3-3-3-3\" />"),
    LAYOUT_DASHBOARD(
        "layout-dashboard",
        "<rect width=\"7\" height=\"9\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"5\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"9\" x=\"14\" y=\"12\" rx=\"1\" />\n  <rect width=\"7\" height=\"5\" x=\"3\" y=\"16\" rx=\"1\" />"),
    LAYOUT_FREEFORM(
        "layout-freeform",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"4\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"4\" y=\"14\" rx=\"1\" />"),
    LAYOUT_GRID(
        "layout-grid",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"14\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />"),
    LAYOUT_GRID_CIRCLES(
        "layout-grid-circles",
        "<circle cx=\"17.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"17.5\" cy=\"6.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"3.5\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M14 4h7\" />\n  <path d=\"M14 9h7\" />\n  <path d=\"M14 15h7\" />\n  <path d=\"M14 20h7\" />"),
    LAYOUT_PANEL_LEFT(
        "layout-panel-left",
        "<rect width=\"7\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"14\" rx=\"1\" />"),
    LAYOUT_PANEL_TOP(
        "layout-panel-top",
        "<rect width=\"18\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"14\" y=\"14\" rx=\"1\" />"),
    LAYOUT_TEMPLATE(
        "layout-template",
        "<rect width=\"18\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"9\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <rect width=\"5\" height=\"7\" x=\"16\" y=\"14\" rx=\"1\" />"),
    LIST_FILTER_PLUS(
        "list-filter-plus",
        "<path d=\"M12 5H2\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 19h6\" />\n  <path d=\"M16 5h6\" />\n  <path d=\"M19 8V2\" />"),
    LIST_SORT_ASCENDING(
        "list-sort-ascending",
        "<path d=\"M3 19h18\" />\n  <path d=\"M15 12H3\" />\n  <path d=\"M9 5H3\" />"),
    LIST_SORT_DESCENDING(
        "list-sort-descending",
        "<path d=\"M15 12H3\" />\n  <path d=\"M3 5h18\" />\n  <path d=\"M9 19H3\" />"),
    LIST_TREE(
        "list-tree",
        "<path d=\"M8 5h13\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />\n  <path d=\"M3 10a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 5v12a2 2 0 0 0 2 2h3\" />"),
    LOADER(
        "loader",
        "<path d=\"M12 2v4\" />\n  <path d=\"m16.2 7.8 2.9-2.9\" />\n  <path d=\"M18 12h4\" />\n  <path d=\"m16.2 16.2 2.9 2.9\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"m4.9 19.1 2.9-2.9\" />\n  <path d=\"M2 12h4\" />\n  <path d=\"m4.9 4.9 2.9 2.9\" />"),
    LOADER_CIRCLE("loader-circle", "<path d=\"M21 12a9 9 0 1 1-6.219-8.56\" />"),
    MAXIMIZE(
        "maximize",
        "<path d=\"M8 3H5a2 2 0 0 0-2 2v3\" />\n  <path d=\"M21 8V5a2 2 0 0 0-2-2h-3\" />\n  <path d=\"M3 16v3a2 2 0 0 0 2 2h3\" />\n  <path d=\"M16 21h3a2 2 0 0 0 2-2v-3\" />"),
    MAXIMIZE_2(
        "maximize-2",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"m21 3-7 7\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M9 21H3v-6\" />"),
    MENU("menu", "<path d=\"M4 5h16\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M4 19h16\" />"),
    MINIMIZE(
        "minimize",
        "<path d=\"M8 3v3a2 2 0 0 1-2 2H3\" />\n  <path d=\"M21 8h-3a2 2 0 0 1-2-2V3\" />\n  <path d=\"M3 16h3a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 21v-3a2 2 0 0 1 2-2h3\" />"),
    MINIMIZE_2(
        "minimize-2",
        "<path d=\"m14 10 7-7\" />\n  <path d=\"M20 10h-6V4\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M4 14h6v6\" />"),
    PANEL_BOTTOM(
        "panel-bottom",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h18\" />"),
    PANEL_BOTTOM_CLOSE(
        "panel-bottom-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"m15 8-3 3-3-3\" />"),
    PANEL_BOTTOM_DASHED(
        "panel-bottom-dashed",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M14 15h1\" />\n  <path d=\"M19 15h2\" />\n  <path d=\"M3 15h2\" />\n  <path d=\"M9 15h1\" />"),
    PANEL_BOTTOM_OPEN(
        "panel-bottom-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"m9 10 3-3 3 3\" />"),
    PANEL_LEFT(
        "panel-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />"),
    PANEL_LEFT_CLOSE(
        "panel-left-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"m16 15-3-3 3-3\" />"),
    PANEL_LEFT_DASHED(
        "panel-left-dashed",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 14v1\" />\n  <path d=\"M9 19v2\" />\n  <path d=\"M9 3v2\" />\n  <path d=\"M9 9v1\" />"),
    PANEL_LEFT_OPEN(
        "panel-left-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"m14 9 3 3-3 3\" />"),
    PANEL_LEFT_RIGHT_DASHED(
        "panel-left-right-dashed",
        "<path d=\"M15 10V9\" />\n  <path d=\"M15 15v-1\" />\n  <path d=\"M15 21v-2\" />\n  <path d=\"M15 5V3\" />\n  <path d=\"M9 10V9\" />\n  <path d=\"M9 15v-1\" />\n  <path d=\"M9 21v-2\" />\n  <path d=\"M9 5V3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    PANEL_RIGHT(
        "panel-right",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 3v18\" />"),
    PANEL_RIGHT_CLOSE(
        "panel-right-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 3v18\" />\n  <path d=\"m8 9 3 3-3 3\" />"),
    PANEL_RIGHT_DASHED(
        "panel-right-dashed",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 14v1\" />\n  <path d=\"M15 19v2\" />\n  <path d=\"M15 3v2\" />\n  <path d=\"M15 9v1\" />"),
    PANEL_RIGHT_OPEN(
        "panel-right-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 3v18\" />\n  <path d=\"m10 15-3-3 3-3\" />"),
    PANEL_TOP(
        "panel-top",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />"),
    PANEL_TOP_BOTTOM_DASHED(
        "panel-top-bottom-dashed",
        "<path d=\"M14 15h1\" />\n  <path d=\"M14 9h1\" />\n  <path d=\"M19 15h2\" />\n  <path d=\"M19 9h2\" />\n  <path d=\"M3 15h2\" />\n  <path d=\"M3 9h2\" />\n  <path d=\"M9 15h1\" />\n  <path d=\"M9 9h1\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    PANEL_TOP_CLOSE(
        "panel-top-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m9 16 3-3 3 3\" />"),
    PANEL_TOP_DASHED(
        "panel-top-dashed",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M14 9h1\" />\n  <path d=\"M19 9h2\" />\n  <path d=\"M3 9h2\" />\n  <path d=\"M9 9h1\" />"),
    PANEL_TOP_OPEN(
        "panel-top-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m15 14-3 3-3-3\" />"),
    PANELS_LEFT_BOTTOM(
        "panels-left-bottom",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M9 15h12\" />"),
    PANELS_RIGHT_BOTTOM(
        "panels-right-bottom",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h12\" />\n  <path d=\"M15 3v18\" />"),
    PANELS_TOP_LEFT(
        "panels-top-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M9 21V9\" />"),
    PENCIL_RULER(
        "pencil-ruler",
        "<path d=\"M13 7 8.7 2.7a2.41 2.41 0 0 0-3.4 0L2.7 5.3a2.41 2.41 0 0 0 0 3.4L7 13\" />\n  <path d=\"m8 6 2-2\" />\n  <path d=\"m18 16 2-2\" />\n  <path d=\"m17 11 4.3 4.3c.94.94.94 2.46 0 3.4l-2.6 2.6c-.94.94-2.46.94-3.4 0L11 17\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />\n  <path d=\"m15 5 4 4\" />"),
    PROPORTIONS(
        "proportions",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M12 9v11\" />\n  <path d=\"M2 9h13a2 2 0 0 1 2 2v9\" />"),
    RATIO(
        "ratio",
        "<rect width=\"12\" height=\"20\" x=\"6\" y=\"2\" rx=\"2\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
    ROTATE_CCW_SQUARE(
        "rotate-ccw-square",
        "<path d=\"M20 9V7a2 2 0 0 0-2-2h-6\" />\n  <path d=\"m15 2-3 3 3 3\" />\n  <path d=\"M20 13v5a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h2\" />"),
    ROTATE_CW_SQUARE(
        "rotate-cw-square",
        "<path d=\"M12 5H6a2 2 0 0 0-2 2v3\" />\n  <path d=\"m9 8 3-3-3-3\" />\n  <path d=\"M4 14v4a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />"),
    ROWS_2(
        "rows-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 12h18\" />"),
    ROWS_3(
        "rows-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    ROWS_4(
        "rows-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 7.5H3\" />\n  <path d=\"M21 12H3\" />\n  <path d=\"M21 16.5H3\" />"),
    RULER(
        "ruler",
        "<path d=\"M21.3 15.3a2.4 2.4 0 0 1 0 3.4l-2.6 2.6a2.4 2.4 0 0 1-3.4 0L2.7 8.7a2.41 2.41 0 0 1 0-3.4l2.6-2.6a2.41 2.41 0 0 1 3.4 0Z\" />\n  <path d=\"m14.5 12.5 2-2\" />\n  <path d=\"m11.5 9.5 2-2\" />\n  <path d=\"m8.5 6.5 2-2\" />\n  <path d=\"m17.5 15.5 2-2\" />"),
    RULER_DIMENSION_LINE(
        "ruler-dimension-line",
        "<path d=\"M10 15v-3\" />\n  <path d=\"M14 15v-3\" />\n  <path d=\"M18 15v-3\" />\n  <path d=\"M2 8V4\" />\n  <path d=\"M22 6H2\" />\n  <path d=\"M22 8V4\" />\n  <path d=\"M6 15v-3\" />\n  <rect x=\"2\" y=\"12\" width=\"20\" height=\"8\" rx=\"2\" />"),
    SEND_TO_BACK(
        "send-to-back",
        "<rect x=\"14\" y=\"14\" width=\"8\" height=\"8\" rx=\"2\" />\n  <rect x=\"2\" y=\"2\" width=\"8\" height=\"8\" rx=\"2\" />\n  <path d=\"M7 14v1a2 2 0 0 0 2 2h1\" />\n  <path d=\"M14 7h1a2 2 0 0 1 2 2v1\" />"),
    SEPARATOR_HORIZONTAL(
        "separator-horizontal",
        "<path d=\"m16 16-4 4-4-4\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"m8 8 4-4 4 4\" />"),
    SEPARATOR_VERTICAL(
        "separator-vertical",
        "<path d=\"M12 3v18\" />\n  <path d=\"m16 16 4-4-4-4\" />\n  <path d=\"m8 8-4 4 4 4\" />"),
    SHRINK(
        "shrink",
        "<path d=\"m15 15 6 6m-6-6v4.8m0-4.8h4.8\" />\n  <path d=\"M9 19.8V15m0 0H4.2M9 15l-6 6\" />\n  <path d=\"M15 4.2V9m0 0h4.8M15 9l6-6\" />\n  <path d=\"M9 4.2V9m0 0H4.2M9 9 3 3\" />"),
    SQUARE_ARROW_RIGHT_ENTER(
        "square-arrow-right-enter",
        "<path d=\"m10 16 4-4-4-4\" />\n  <path d=\"M3 12h11\" />\n  <path d=\"M3 8V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />"),
    SQUARE_ARROW_RIGHT_EXIT(
        "square-arrow-right-exit",
        "<path d=\"M10 12h11\" />\n  <path d=\"m17 16 4-4-4-4\" />\n  <path d=\"M21 6.344V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-1.344\" />"),
    SQUARE_DASHED_PLUS(
        "square-dashed-plus",
        "<path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_DASHED_TOP_SOLID(
        "square-dashed-top-solid",
        "<path d=\"M14 21h1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 21h1\" />"),
    SQUARE_DASHED_X(
        "square-dashed-x",
        "<path d=\"M14 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 01-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"m9 15 6-6\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"m9 9 6 6\" />"),
    SQUARE_DASHED_X_CORNER(
        "square-dashed-x-corner",
        "<path d=\"M14 3h1\" />\n  <path d=\"m16 16 5 5\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"m21 16-5 5\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />"),
    SQUARE_DIMENSIONS(
        "square-dimensions",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 7H7v5\" />\n  <path d=\"M12 17h5v-5\" />"),
    SQUARE_MENU(
        "square-menu",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 8h10\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h10\" />"),
    SQUARE_ROUND_CORNER(
        "square-round-corner",
        "<path d=\"M21 11a8 8 0 0 0-8-8\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4\" />"),
    SQUARE_SPLIT_HORIZONTAL(
        "square-split-horizontal",
        "<path d=\"M12 2v20\" />\n  <path d=\"M16 3h3a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-3\" />\n  <path d=\"M8 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3\" />"),
    SQUARE_SPLIT_VERTICAL(
        "square-split-vertical",
        "<path d=\"M2 12h20\" />\n  <path d=\"M21 16v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M3 8V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v3\" />"),
    SQUARE_SQUARE(
        "square-square",
        "<rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <rect x=\"8\" y=\"8\" width=\"8\" height=\"8\" rx=\"1\" />"),
    STRETCH_HORIZONTAL(
        "stretch-horizontal",
        "<rect width=\"20\" height=\"6\" x=\"2\" y=\"4\" rx=\"2\" />\n  <rect width=\"20\" height=\"6\" x=\"2\" y=\"14\" rx=\"2\" />"),
    STRETCH_VERTICAL(
        "stretch-vertical",
        "<rect width=\"6\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <rect width=\"6\" height=\"20\" x=\"14\" y=\"2\" rx=\"2\" />"),
    TEXT_CURSOR_INPUT(
        "text-cursor-input",
        "<path d=\"M12 20h-1a2 2 0 0 1-2-2 2 2 0 0 1-2 2H6\" />\n  <path d=\"M13 8h7a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-7\" />\n  <path d=\"M5 16H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h1\" />\n  <path d=\"M6 4h1a2 2 0 0 1 2 2 2 2 0 0 1 2-2h1\" />\n  <path d=\"M9 6v12\" />"),
    TOGGLE_LEFT(
        "toggle-left",
        "<circle cx=\"9\" cy=\"12\" r=\"3\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"5\" rx=\"7\" />"),
    TOGGLE_RIGHT(
        "toggle-right",
        "<circle cx=\"15\" cy=\"12\" r=\"3\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"5\" rx=\"7\" />"),
    UNFOLD_HORIZONTAL(
        "unfold-horizontal",
        "<path d=\"M16 12h6\" />\n  <path d=\"M8 12H2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m19 15 3-3-3-3\" />\n  <path d=\"m5 9-3 3 3 3\" />"),
    UNFOLD_VERTICAL(
        "unfold-vertical",
        "<path d=\"M12 22v-6\" />\n  <path d=\"M12 8V2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"m15 19-3 3-3-3\" />\n  <path d=\"m15 5-3-3-3 3\" />"),
    ZOOM_IN(
        "zoom-in",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"11\" x2=\"11\" y1=\"8\" y2=\"14\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />"),
    ZOOM_OUT(
        "zoom-out",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />");

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
  default LucideIcon align_center_horizontal() {
    return LucideIcon.create(Icon.ALIGN_CENTER_HORIZONTAL);
  }

  default LucideIcon align_center_vertical() {
    return LucideIcon.create(Icon.ALIGN_CENTER_VERTICAL);
  }

  default LucideIcon align_end_horizontal() {
    return LucideIcon.create(Icon.ALIGN_END_HORIZONTAL);
  }

  default LucideIcon align_end_vertical() {
    return LucideIcon.create(Icon.ALIGN_END_VERTICAL);
  }

  default LucideIcon align_horizontal_distribute_center() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_DISTRIBUTE_CENTER);
  }

  default LucideIcon align_horizontal_distribute_end() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_DISTRIBUTE_END);
  }

  default LucideIcon align_horizontal_distribute_start() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_DISTRIBUTE_START);
  }

  default LucideIcon align_horizontal_justify_center() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_JUSTIFY_CENTER);
  }

  default LucideIcon align_horizontal_justify_end() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_JUSTIFY_END);
  }

  default LucideIcon align_horizontal_justify_start() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_JUSTIFY_START);
  }

  default LucideIcon align_horizontal_space_around() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_SPACE_AROUND);
  }

  default LucideIcon align_horizontal_space_between() {
    return LucideIcon.create(Icon.ALIGN_HORIZONTAL_SPACE_BETWEEN);
  }

  default LucideIcon align_start_horizontal() {
    return LucideIcon.create(Icon.ALIGN_START_HORIZONTAL);
  }

  default LucideIcon align_start_vertical() {
    return LucideIcon.create(Icon.ALIGN_START_VERTICAL);
  }

  default LucideIcon align_vertical_distribute_center() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_DISTRIBUTE_CENTER);
  }

  default LucideIcon align_vertical_distribute_end() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_DISTRIBUTE_END);
  }

  default LucideIcon align_vertical_distribute_start() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_DISTRIBUTE_START);
  }

  default LucideIcon align_vertical_justify_center() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_JUSTIFY_CENTER);
  }

  default LucideIcon align_vertical_justify_end() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_JUSTIFY_END);
  }

  default LucideIcon align_vertical_justify_start() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_JUSTIFY_START);
  }

  default LucideIcon align_vertical_space_around() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_SPACE_AROUND);
  }

  default LucideIcon align_vertical_space_between() {
    return LucideIcon.create(Icon.ALIGN_VERTICAL_SPACE_BETWEEN);
  }

  default LucideIcon app_window_layout() {
    return LucideIcon.create(Icon.APP_WINDOW);
  }

  default LucideIcon app_window_mac_layout() {
    return LucideIcon.create(Icon.APP_WINDOW_MAC);
  }

  default LucideIcon arrow_down_0_1_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_0_1);
  }

  default LucideIcon arrow_down_1_0_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_1_0);
  }

  default LucideIcon arrow_down_a_z_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_A_Z);
  }

  default LucideIcon arrow_down_narrow_wide_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_NARROW_WIDE);
  }

  default LucideIcon arrow_down_wide_narrow_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_WIDE_NARROW);
  }

  default LucideIcon arrow_down_z_a_layout() {
    return LucideIcon.create(Icon.ARROW_DOWN_Z_A);
  }

  default LucideIcon arrow_up_0_1_layout() {
    return LucideIcon.create(Icon.ARROW_UP_0_1);
  }

  default LucideIcon arrow_up_1_0_layout() {
    return LucideIcon.create(Icon.ARROW_UP_1_0);
  }

  default LucideIcon arrow_up_a_z_layout() {
    return LucideIcon.create(Icon.ARROW_UP_A_Z);
  }

  default LucideIcon arrow_up_narrow_wide_layout() {
    return LucideIcon.create(Icon.ARROW_UP_NARROW_WIDE);
  }

  default LucideIcon arrow_up_wide_narrow_layout() {
    return LucideIcon.create(Icon.ARROW_UP_WIDE_NARROW);
  }

  default LucideIcon arrow_up_z_a_layout() {
    return LucideIcon.create(Icon.ARROW_UP_Z_A);
  }

  default LucideIcon between_horizontal_end_layout() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_END);
  }

  default LucideIcon between_horizontal_start_layout() {
    return LucideIcon.create(Icon.BETWEEN_HORIZONTAL_START);
  }

  default LucideIcon between_vertical_end_layout() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_END);
  }

  default LucideIcon between_vertical_start_layout() {
    return LucideIcon.create(Icon.BETWEEN_VERTICAL_START);
  }

  default LucideIcon blocks_layout() {
    return LucideIcon.create(Icon.BLOCKS);
  }

  default LucideIcon bring_to_front_layout() {
    return LucideIcon.create(Icon.BRING_TO_FRONT);
  }

  default LucideIcon circle_ellipsis_layout() {
    return LucideIcon.create(Icon.CIRCLE_ELLIPSIS);
  }

  default LucideIcon columns_2_layout() {
    return LucideIcon.create(Icon.COLUMNS_2);
  }

  default LucideIcon columns_3_layout() {
    return LucideIcon.create(Icon.COLUMNS_3);
  }

  default LucideIcon columns_3_cog_layout() {
    return LucideIcon.create(Icon.COLUMNS_3_COG);
  }

  default LucideIcon columns_4_layout() {
    return LucideIcon.create(Icon.COLUMNS_4);
  }

  default LucideIcon dock_layout() {
    return LucideIcon.create(Icon.DOCK);
  }

  default LucideIcon ellipsis_layout() {
    return LucideIcon.create(Icon.ELLIPSIS);
  }

  default LucideIcon ellipsis_vertical() {
    return LucideIcon.create(Icon.ELLIPSIS_VERTICAL);
  }

  default LucideIcon fold_horizontal_layout() {
    return LucideIcon.create(Icon.FOLD_HORIZONTAL);
  }

  default LucideIcon fold_vertical_layout() {
    return LucideIcon.create(Icon.FOLD_VERTICAL);
  }

  default LucideIcon fullscreen_layout() {
    return LucideIcon.create(Icon.FULLSCREEN);
  }

  default LucideIcon funnel() {
    return LucideIcon.create(Icon.FUNNEL);
  }

  default LucideIcon funnel_plus() {
    return LucideIcon.create(Icon.FUNNEL_PLUS);
  }

  default LucideIcon funnel_x() {
    return LucideIcon.create(Icon.FUNNEL_X);
  }

  default LucideIcon gallery_horizontal_layout() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL);
  }

  default LucideIcon gallery_horizontal_end_layout() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_thumbnails_layout() {
    return LucideIcon.create(Icon.GALLERY_THUMBNAILS);
  }

  default LucideIcon gallery_vertical_layout() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL);
  }

  default LucideIcon gallery_vertical_end_layout() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon gap_horizontal_layout() {
    return LucideIcon.create(Icon.GAP_HORIZONTAL);
  }

  default LucideIcon gap_vertical_layout() {
    return LucideIcon.create(Icon.GAP_VERTICAL);
  }

  default LucideIcon grid_2x2_layout() {
    return LucideIcon.create(Icon.GRID_2X2);
  }

  default LucideIcon grid_2x2_check_layout() {
    return LucideIcon.create(Icon.GRID_2X2_CHECK);
  }

  default LucideIcon grid_2x2_plus_layout() {
    return LucideIcon.create(Icon.GRID_2X2_PLUS);
  }

  default LucideIcon grid_2x2_x_layout() {
    return LucideIcon.create(Icon.GRID_2X2_X);
  }

  default LucideIcon grid_3x2_layout() {
    return LucideIcon.create(Icon.GRID_3X2);
  }

  default LucideIcon grid_3x3_layout() {
    return LucideIcon.create(Icon.GRID_3X3);
  }

  default LucideIcon grip() {
    return LucideIcon.create(Icon.GRIP);
  }

  default LucideIcon grip_horizontal() {
    return LucideIcon.create(Icon.GRIP_HORIZONTAL);
  }

  default LucideIcon grip_vertical() {
    return LucideIcon.create(Icon.GRIP_VERTICAL);
  }

  default LucideIcon hand_grab_layout() {
    return LucideIcon.create(Icon.HAND_GRAB);
  }

  default LucideIcon layer_arrow_down_layout() {
    return LucideIcon.create(Icon.LAYER_ARROW_DOWN);
  }

  default LucideIcon layer_arrow_up_layout() {
    return LucideIcon.create(Icon.LAYER_ARROW_UP);
  }

  default LucideIcon layers_layout() {
    return LucideIcon.create(Icon.LAYERS);
  }

  default LucideIcon layers_2_layout() {
    return LucideIcon.create(Icon.LAYERS_2);
  }

  default LucideIcon layers_arrow_down_layout() {
    return LucideIcon.create(Icon.LAYERS_ARROW_DOWN);
  }

  default LucideIcon layers_arrow_up_layout() {
    return LucideIcon.create(Icon.LAYERS_ARROW_UP);
  }

  default LucideIcon layers_minus_layout() {
    return LucideIcon.create(Icon.LAYERS_MINUS);
  }

  default LucideIcon layers_plus_layout() {
    return LucideIcon.create(Icon.LAYERS_PLUS);
  }

  default LucideIcon layout_arrow_down_layout() {
    return LucideIcon.create(Icon.LAYOUT_ARROW_DOWN);
  }

  default LucideIcon layout_arrow_right_layout() {
    return LucideIcon.create(Icon.LAYOUT_ARROW_RIGHT);
  }

  default LucideIcon layout_dashboard_layout() {
    return LucideIcon.create(Icon.LAYOUT_DASHBOARD);
  }

  default LucideIcon layout_freeform_layout() {
    return LucideIcon.create(Icon.LAYOUT_FREEFORM);
  }

  default LucideIcon layout_grid_layout() {
    return LucideIcon.create(Icon.LAYOUT_GRID);
  }

  default LucideIcon layout_grid_circles_layout() {
    return LucideIcon.create(Icon.LAYOUT_GRID_CIRCLES);
  }

  default LucideIcon layout_list_layout() {
    return LucideIcon.create(Icon.LAYOUT_LIST);
  }

  default LucideIcon layout_panel_left_layout() {
    return LucideIcon.create(Icon.LAYOUT_PANEL_LEFT);
  }

  default LucideIcon layout_panel_top() {
    return LucideIcon.create(Icon.LAYOUT_PANEL_TOP);
  }

  default LucideIcon layout_template() {
    return LucideIcon.create(Icon.LAYOUT_TEMPLATE);
  }

  default LucideIcon list_filter_plus_layout() {
    return LucideIcon.create(Icon.LIST_FILTER_PLUS);
  }

  default LucideIcon list_sort_ascending_layout() {
    return LucideIcon.create(Icon.LIST_SORT_ASCENDING);
  }

  default LucideIcon list_sort_descending_layout() {
    return LucideIcon.create(Icon.LIST_SORT_DESCENDING);
  }

  default LucideIcon list_tree_layout() {
    return LucideIcon.create(Icon.LIST_TREE);
  }

  default LucideIcon loader_layout() {
    return LucideIcon.create(Icon.LOADER);
  }

  default LucideIcon loader_circle_layout() {
    return LucideIcon.create(Icon.LOADER_CIRCLE);
  }

  default LucideIcon maximize_layout() {
    return LucideIcon.create(Icon.MAXIMIZE);
  }

  default LucideIcon maximize_2_layout() {
    return LucideIcon.create(Icon.MAXIMIZE_2);
  }

  default LucideIcon menu_layout() {
    return LucideIcon.create(Icon.MENU);
  }

  default LucideIcon minimize_layout() {
    return LucideIcon.create(Icon.MINIMIZE);
  }

  default LucideIcon minimize_2_layout() {
    return LucideIcon.create(Icon.MINIMIZE_2);
  }

  default LucideIcon panel_bottom() {
    return LucideIcon.create(Icon.PANEL_BOTTOM);
  }

  default LucideIcon panel_bottom_close_layout() {
    return LucideIcon.create(Icon.PANEL_BOTTOM_CLOSE);
  }

  default LucideIcon panel_bottom_dashed() {
    return LucideIcon.create(Icon.PANEL_BOTTOM_DASHED);
  }

  default LucideIcon panel_bottom_open_layout() {
    return LucideIcon.create(Icon.PANEL_BOTTOM_OPEN);
  }

  default LucideIcon panel_left() {
    return LucideIcon.create(Icon.PANEL_LEFT);
  }

  default LucideIcon panel_left_close_layout() {
    return LucideIcon.create(Icon.PANEL_LEFT_CLOSE);
  }

  default LucideIcon panel_left_dashed() {
    return LucideIcon.create(Icon.PANEL_LEFT_DASHED);
  }

  default LucideIcon panel_left_open_layout() {
    return LucideIcon.create(Icon.PANEL_LEFT_OPEN);
  }

  default LucideIcon panel_left_right_dashed() {
    return LucideIcon.create(Icon.PANEL_LEFT_RIGHT_DASHED);
  }

  default LucideIcon panel_right() {
    return LucideIcon.create(Icon.PANEL_RIGHT);
  }

  default LucideIcon panel_right_close_layout() {
    return LucideIcon.create(Icon.PANEL_RIGHT_CLOSE);
  }

  default LucideIcon panel_right_dashed() {
    return LucideIcon.create(Icon.PANEL_RIGHT_DASHED);
  }

  default LucideIcon panel_right_open_layout() {
    return LucideIcon.create(Icon.PANEL_RIGHT_OPEN);
  }

  default LucideIcon panel_top_layout() {
    return LucideIcon.create(Icon.PANEL_TOP);
  }

  default LucideIcon panel_top_bottom_dashed() {
    return LucideIcon.create(Icon.PANEL_TOP_BOTTOM_DASHED);
  }

  default LucideIcon panel_top_close_layout() {
    return LucideIcon.create(Icon.PANEL_TOP_CLOSE);
  }

  default LucideIcon panel_top_dashed() {
    return LucideIcon.create(Icon.PANEL_TOP_DASHED);
  }

  default LucideIcon panel_top_open_layout() {
    return LucideIcon.create(Icon.PANEL_TOP_OPEN);
  }

  default LucideIcon panels_left_bottom() {
    return LucideIcon.create(Icon.PANELS_LEFT_BOTTOM);
  }

  default LucideIcon panels_right_bottom() {
    return LucideIcon.create(Icon.PANELS_RIGHT_BOTTOM);
  }

  default LucideIcon panels_top_left_layout() {
    return LucideIcon.create(Icon.PANELS_TOP_LEFT);
  }

  default LucideIcon pencil_ruler_layout() {
    return LucideIcon.create(Icon.PENCIL_RULER);
  }

  default LucideIcon proportions_layout() {
    return LucideIcon.create(Icon.PROPORTIONS);
  }

  default LucideIcon ratio_layout() {
    return LucideIcon.create(Icon.RATIO);
  }

  default LucideIcon rotate_ccw_square_layout() {
    return LucideIcon.create(Icon.ROTATE_CCW_SQUARE);
  }

  default LucideIcon rotate_cw_square_layout() {
    return LucideIcon.create(Icon.ROTATE_CW_SQUARE);
  }

  default LucideIcon rows_2_layout() {
    return LucideIcon.create(Icon.ROWS_2);
  }

  default LucideIcon rows_3_layout() {
    return LucideIcon.create(Icon.ROWS_3);
  }

  default LucideIcon rows_4_layout() {
    return LucideIcon.create(Icon.ROWS_4);
  }

  default LucideIcon ruler_layout() {
    return LucideIcon.create(Icon.RULER);
  }

  default LucideIcon ruler_dimension_line_layout() {
    return LucideIcon.create(Icon.RULER_DIMENSION_LINE);
  }

  default LucideIcon send_to_back_layout() {
    return LucideIcon.create(Icon.SEND_TO_BACK);
  }

  default LucideIcon separator_horizontal_layout() {
    return LucideIcon.create(Icon.SEPARATOR_HORIZONTAL);
  }

  default LucideIcon separator_vertical_layout() {
    return LucideIcon.create(Icon.SEPARATOR_VERTICAL);
  }

  default LucideIcon shrink_layout() {
    return LucideIcon.create(Icon.SHRINK);
  }

  default LucideIcon square_arrow_right_enter_layout() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_ENTER);
  }

  default LucideIcon square_arrow_right_exit_layout() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_EXIT);
  }

  default LucideIcon square_dashed_plus_layout() {
    return LucideIcon.create(Icon.SQUARE_DASHED_PLUS);
  }

  default LucideIcon square_dashed_top_solid_layout() {
    return LucideIcon.create(Icon.SQUARE_DASHED_TOP_SOLID);
  }

  default LucideIcon square_dashed_x_layout() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X);
  }

  default LucideIcon square_dashed_x_corner_layout() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X_CORNER);
  }

  default LucideIcon square_dimensions_layout() {
    return LucideIcon.create(Icon.SQUARE_DIMENSIONS);
  }

  default LucideIcon square_menu() {
    return LucideIcon.create(Icon.SQUARE_MENU);
  }

  default LucideIcon square_round_corner_layout() {
    return LucideIcon.create(Icon.SQUARE_ROUND_CORNER);
  }

  default LucideIcon square_split_horizontal() {
    return LucideIcon.create(Icon.SQUARE_SPLIT_HORIZONTAL);
  }

  default LucideIcon square_split_vertical() {
    return LucideIcon.create(Icon.SQUARE_SPLIT_VERTICAL);
  }

  default LucideIcon square_square() {
    return LucideIcon.create(Icon.SQUARE_SQUARE);
  }

  default LucideIcon stretch_horizontal() {
    return LucideIcon.create(Icon.STRETCH_HORIZONTAL);
  }

  default LucideIcon stretch_vertical() {
    return LucideIcon.create(Icon.STRETCH_VERTICAL);
  }

  default LucideIcon text_cursor_input_layout() {
    return LucideIcon.create(Icon.TEXT_CURSOR_INPUT);
  }

  default LucideIcon toggle_left_layout() {
    return LucideIcon.create(Icon.TOGGLE_LEFT);
  }

  default LucideIcon toggle_right_layout() {
    return LucideIcon.create(Icon.TOGGLE_RIGHT);
  }

  default LucideIcon unfold_horizontal_layout() {
    return LucideIcon.create(Icon.UNFOLD_HORIZONTAL);
  }

  default LucideIcon unfold_vertical_layout() {
    return LucideIcon.create(Icon.UNFOLD_VERTICAL);
  }

  default LucideIcon zoom_in_layout() {
    return LucideIcon.create(Icon.ZOOM_IN);
  }

  default LucideIcon zoom_out_layout() {
    return LucideIcon.create(Icon.ZOOM_OUT);
  }
}
