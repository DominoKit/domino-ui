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

/** Tabler Design catalog category. */
public interface TablerDesign {
  enum OutlineIcon implements TablerIconDefinition {
    AD(
        "ad",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 15v-4a2 2 0 0 1 4 0v4\" />\n  <path d=\"M7 13l4 0\" />\n  <path d=\"M17 9v6h-1.5a1.5 1.5 0 1 1 1.5 -1.5\" />"),
    AD_2(
        "ad-2",
        "<path d=\"M11.933 5h-6.933v16h13v-8\" />\n  <path d=\"M14 17h-5\" />\n  <path d=\"M9 13h5v-4h-5v4\" />\n  <path d=\"M15 5v-2\" />\n  <path d=\"M18 6l2 -2\" />\n  <path d=\"M19 9h2\" />"),
    AD_OFF(
        "ad-off",
        "<path d=\"M9 5h10a2 2 0 0 1 2 2v10m-2 2h-14a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 15v-4a2 2 0 0 1 2 -2m2 2v4\" />\n  <path d=\"M7 13h4\" />\n  <path d=\"M17 9v4\" />\n  <path d=\"M16.115 12.131c.33 .149 .595 .412 .747 .74\" />\n  <path d=\"M3 3l18 18\" />"),
    ANGLE(
        "angle",
        "<path d=\"M21 19h-18l9 -15\" />\n  <path d=\"M20.615 15.171h.015\" />\n  <path d=\"M19.515 11.771h.015\" />\n  <path d=\"M17.715 8.671h.015\" />\n  <path d=\"M15.415 5.971h.015\" />"),
    ARTBOARD(
        "artboard",
        "<path d=\"M8 9a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M3 8l1 0\" />\n  <path d=\"M3 16l1 0\" />\n  <path d=\"M8 3l0 1\" />\n  <path d=\"M16 3l0 1\" />\n  <path d=\"M20 8l1 0\" />\n  <path d=\"M20 16l1 0\" />\n  <path d=\"M8 20l0 1\" />\n  <path d=\"M16 20l0 1\" />"),
    ARTBOARD_OFF(
        "artboard-off",
        "<path d=\"M12 8h3a1 1 0 0 1 1 1v3\" />\n  <path d=\"M15.716 15.698a1 1 0 0 1 -.716 .302h-6a1 1 0 0 1 -1 -1v-6c0 -.273 .11 -.52 .287 -.7\" />\n  <path d=\"M3 8h1\" />\n  <path d=\"M3 16h1\" />\n  <path d=\"M8 3v1\" />\n  <path d=\"M16 3v1\" />\n  <path d=\"M20 8h1\" />\n  <path d=\"M20 16h1\" />\n  <path d=\"M8 20v1\" />\n  <path d=\"M16 20v1\" />\n  <path d=\"M3 3l18 18\" />"),
    BACKGROUND(
        "background",
        "<path d=\"M4 8l4 -4\" />\n  <path d=\"M14 4l-10 10\" />\n  <path d=\"M4 20l16 -16\" />\n  <path d=\"M20 10l-10 10\" />\n  <path d=\"M20 16l-4 4\" />"),
    BARREL(
        "barrel",
        "<path d=\"M7.278 4h9.444a2 2 0 0 1 1.841 1.22c.958 2.26 1.437 4.52 1.437 6.78c0 2.26 -.479 4.52 -1.437 6.78a2 2 0 0 1 -1.841 1.22h-9.444a2 2 0 0 1 -1.841 -1.22c-.958 -2.26 -1.437 -4.52 -1.437 -6.78c0 -2.26 .479 -4.52 1.437 -6.78a2 2 0 0 1 1.841 -1.22\" />\n  <path d=\"M14 4c.667 2.667 1 5.333 1 8s-.333 5.333 -1 8\" />\n  <path d=\"M10 4c-.667 2.667 -1 5.333 -1 8s.333 5.333 1 8\" />\n  <path d=\"M4.5 16h15\" />\n  <path d=\"M19.5 8h-15\" />"),
    BARREL_OFF(
        "barrel-off",
        "<path d=\"M8 4h8.722a2 2 0 0 1 1.841 1.22c.958 2.26 1.437 4.52 1.437 6.78a16.35 16.35 0 0 1 -.407 3.609m-.964 3.013l-.066 .158a2 2 0 0 1 -1.841 1.22h-9.444a2 2 0 0 1 -1.841 -1.22c-.958 -2.26 -1.437 -4.52 -1.437 -6.78c0 -2.21 .458 -4.42 1.374 -6.63\" />\n  <path d=\"M14 4c.585 2.337 .913 4.674 .985 7.01m-.114 3.86a33.415 33.415 0 0 1 -.871 5.13\" />\n  <path d=\"M10 4a34.42 34.42 0 0 0 -.366 1.632m-.506 3.501a32.126 32.126 0 0 0 -.128 2.867c0 2.667 .333 5.333 1 8\" />\n  <path d=\"M4.5 16h11.5\" />\n  <path d=\"M19.5 8h-7.5m-4 0h-3.5\" />\n  <path d=\"M3 3l18 18\" />"),
    BARRIER_BLOCK(
        "barrier-block",
        "<path d=\"M4 8a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v7a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -7\" />\n  <path d=\"M7 16v4\" />\n  <path d=\"M7.5 16l9 -9\" />\n  <path d=\"M13.5 16l6.5 -6.5\" />\n  <path d=\"M4 13.5l6.5 -6.5\" />\n  <path d=\"M17 16v4\" />\n  <path d=\"M5 20h4\" />\n  <path d=\"M15 20h4\" />\n  <path d=\"M17 7v-2\" />\n  <path d=\"M7 7v-2\" />"),
    BARRIER_BLOCK_OFF(
        "barrier-block-off",
        "<path d=\"M11 7h8a1 1 0 0 1 1 1v7c0 .27 -.107 .516 -.282 .696\" />\n  <path d=\"M16 16h-11a1 1 0 0 1 -1 -1v-7a1 1 0 0 1 1 -1h2\" />\n  <path d=\"M7 16v4\" />\n  <path d=\"M7.5 16l4.244 -4.244\" />\n  <path d=\"M13.745 9.755l2.755 -2.755\" />\n  <path d=\"M13.5 16l1.249 -1.249\" />\n  <path d=\"M16.741 12.759l3.259 -3.259\" />\n  <path d=\"M4 13.5l4.752 -4.752\" />\n  <path d=\"M17 17v3\" />\n  <path d=\"M5 20h4\" />\n  <path d=\"M15 20h4\" />\n  <path d=\"M17 7v-2\" />\n  <path d=\"M3 3l18 18\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M4 16a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 16a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M16.346 9.17l-.729 -1.261c-.16 -.248 -1.056 -.203 -1.117 .091l-.177 1.38\" />\n  <path d=\"M19.761 14.813l-2.84 -5.133c-.189 -.31 -.592 -.68 -1.421 -.68c-.828 0 -1.5 .448 -1.5 1v6\" />\n  <path d=\"M7.654 9.17l.729 -1.261c.16 -.249 1.056 -.203 1.117 .091l.177 1.38\" />\n  <path d=\"M4.239 14.813l2.84 -5.133c.189 -.31 .592 -.68 1.421 -.68c.828 0 1.5 .448 1.5 1v6\" />\n  <path d=\"M10 12h4v2h-4l0 -2\" />"),
    BLADE(
        "blade",
        "<path d=\"M17.707 3.707l2.586 2.586a1 1 0 0 1 0 1.414l-.586 .586a1 1 0 0 0 0 1.414l.586 .586a1 1 0 0 1 0 1.414l-8.586 8.586a1 1 0 0 1 -1.414 0l-.586 -.586a1 1 0 0 0 -1.414 0l-.586 .586a1 1 0 0 1 -1.414 0l-2.586 -2.586a1 1 0 0 1 0 -1.414l.586 -.586a1 1 0 0 0 0 -1.414l-.586 -.586a1 1 0 0 1 0 -1.414l8.586 -8.586a1 1 0 0 1 1.414 0l.586 .586a1 1 0 0 0 1.414 0l.586 -.586a1 1 0 0 1 1.414 0\" />\n  <path d=\"M8 16l3.2 -3.2\" />\n  <path d=\"M12.8 11.2l3.2 -3.2\" />\n  <path d=\"M14 8l2 2\" />\n  <path d=\"M8 14l2 2\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    BLEND_MODE(
        "blend-mode",
        "<path d=\"M8 9.5a6.5 6.5 0 1 0 13 0a6.5 6.5 0 1 0 -13 0\" />\n  <path d=\"M3 14.5a6.5 6.5 0 1 0 13 0a6.5 6.5 0 1 0 -13 0\" />"),
    BLUR(
        "blur",
        "<path d=\"M12 21a9.01 9.01 0 0 0 2.32 -.302a9 9 0 0 0 1.74 -16.733a9 9 0 1 0 -4.06 17.035\" />\n  <path d=\"M12 3v17\" />\n  <path d=\"M12 12h9\" />\n  <path d=\"M12 9h8\" />\n  <path d=\"M12 6h6\" />\n  <path d=\"M12 18h6\" />\n  <path d=\"M12 15h8\" />"),
    BLUR_OFF(
        "blur-off",
        "<path d=\"M12 3v5m0 4v8\" />\n  <path d=\"M5.641 5.631a9 9 0 1 0 12.719 12.738m1.68 -2.318a9 9 0 0 0 -12.074 -12.098\" />\n  <path d=\"M16 12h5\" />\n  <path d=\"M13 9h7\" />\n  <path d=\"M12 6h6\" />\n  <path d=\"M12 18h6\" />\n  <path d=\"M12 15h3m4 0h1\" />\n  <path d=\"M3 3l18 18\" />"),
    BOLT("bolt", "<path d=\"M13 3l0 7l6 0l-8 11l0 -7l-6 0l8 -11\" />"),
    BOLT_OFF(
        "bolt-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M15.212 15.21l-4.212 5.79v-7h-6l3.79 -5.21m1.685 -2.32l2.525 -3.47v6m1 1h5l-2.104 2.893\" />"),
    BOMB(
        "bomb",
        "<path d=\"M15.349 5.349l3.301 3.301a1.2 1.2 0 0 1 0 1.698l-.972 .972a7.5 7.5 0 1 1 -5 -5l.972 -.972a1.2 1.2 0 0 1 1.698 0l.001 .001\" />\n  <path d=\"M17 7l1.293 -1.293a2.414 2.414 0 0 0 .707 -1.707a1 1 0 0 1 1 -1h1\" />\n  <path d=\"M7 13a3 3 0 0 1 3 -3\" />"),
    BONG(
        "bong",
        "<path d=\"M13 3v8.416c.134 .059 .265 .123 .393 .193l3.607 -3.609l2 2l-3.608 3.608a5 5 0 1 1 -6.392 -2.192v-8.416h4\" />\n  <path d=\"M8 3h6\" />\n  <path d=\"M6.1 17h9.8\" />"),
    BONG_OFF(
        "bong-off",
        "<path d=\"M9 5v-2h4v6m1.5 1.5l2.5 -2.5l2 2l-2.5 2.5m-.5 3.505a5 5 0 1 1 -7 -4.589v-2.416\" />\n  <path d=\"M8 3h6\" />\n  <path d=\"M6.1 17h9.8\" />\n  <path d=\"M3 3l18 18\" />"),
    BOOM(
        "boom",
        "<path d=\"M3 9.662c2 2.338 2 4.338 0 6.338c3 .5 4.5 1 5 4c2 -3 6 -4 9 0c0 -3 1 -4 4 -4.004q -3 -2.995 0 -5.996c-3 0 -5 -2 -5 -5c-2 4 -5 3 -7.5 -1c-.5 3 -2.5 5 -5.5 5.662\" />"),
    BORDER_ALL(
        "border-all",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 12l16 0\" />\n  <path d=\"M12 4l0 16\" />"),
    BORDER_BOTTOM(
        "border-bottom",
        "<path d=\"M20 20l-16 0\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />"),
    BORDER_BOTTOM_PLUS(
        "border-bottom-plus",
        "<path d=\"M4 20h16\" />\n  <path d=\"M4 16v-.01\" />\n  <path d=\"M20 16v-.01\" />\n  <path d=\"M4 12v-.01\" />\n  <path d=\"M20 12v-.01\" />\n  <path d=\"M4 8v-.01\" />\n  <path d=\"M20 8v-.01\" />\n  <path d=\"M4 4v-.01\" />\n  <path d=\"M8 4v-.01\" />\n  <path d=\"M12 4v-.01\" />\n  <path d=\"M16 4v-.01\" />\n  <path d=\"M20 4v-.01\" />\n  <path d=\"M15 12h-6\" />\n  <path d=\"M12 9v6\" />"),
    BORDER_CORNER_PILL("border-corner-pill", "<path d=\"M4 20v-5c0 -6.075 4.925 -11 11 -11h5\" />"),
    BORDER_CORNER_ROUNDED("border-corner-rounded", "<path d=\"M4 20v-10a6 6 0 0 1 6 -6h10\" />"),
    BORDER_CORNER_SQUARE("border-corner-square", "<path d=\"M4 20v-15a1 1 0 0 1 1 -1h15\" />"),
    BORDER_CORNERS(
        "border-corners",
        "<path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M20 16v2a2 2 0 0 1 -2 2h-2\" />\n  <path d=\"M8 20h-2a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />"),
    BORDER_HORIZONTAL(
        "border-horizontal",
        "<path d=\"M4 12l16 0\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_INNER(
        "border-inner",
        "<path d=\"M4 12l16 0\" />\n  <path d=\"M12 4l0 16\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_LEFT(
        "border-left",
        "<path d=\"M4 20l0 -16\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_LEFT_PLUS(
        "border-left-plus",
        "<path d=\"M4 20v-16\" />\n  <path d=\"M8 4v.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M16 4v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M20 20v.01\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />"),
    BORDER_NONE(
        "border-none",
        "<path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_OUTER(
        "border-outer",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M12 16l0 .01\" />"),
    BORDER_RADIUS(
        "border-radius",
        "<path d=\"M4 12v-4a4 4 0 0 1 4 -4h4\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_RIGHT(
        "border-right",
        "<path d=\"M20 4l0 16\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />"),
    BORDER_RIGHT_PLUS(
        "border-right-plus",
        "<path d=\"M20 20v-16\" />\n  <path d=\"M16 4v.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M8 4v.01\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M4 8v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M15 12h-6\" />\n  <path d=\"M12 9v6\" />"),
    BORDER_SIDES(
        "border-sides",
        "<path d=\"M4 8v8\" />\n  <path d=\"M20 16v-8\" />\n  <path d=\"M8 4h8\" />\n  <path d=\"M8 20h8\" />"),
    BORDER_STYLE(
        "border-style",
        "<path d=\"M4 20v-14a2 2 0 0 1 2 -2h14\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M20 20v.01\" />"),
    BORDER_STYLE_2(
        "border-style-2",
        "<path d=\"M4 18v.01\" />\n  <path d=\"M8 18v.01\" />\n  <path d=\"M12 18v.01\" />\n  <path d=\"M16 18v.01\" />\n  <path d=\"M20 18v.01\" />\n  <path d=\"M18 12h2\" />\n  <path d=\"M11 12h2\" />\n  <path d=\"M4 12h2\" />\n  <path d=\"M4 6h16\" />"),
    BORDER_TOP(
        "border-top",
        "<path d=\"M4 4l16 0\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M12 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M12 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M12 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BORDER_TOP_PLUS(
        "border-top-plus",
        "<path d=\"M4 4h16\" />\n  <path d=\"M4 8v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M15 12h-6\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M20 20v.01\" />"),
    BORDER_VERTICAL(
        "border-vertical",
        "<path d=\"M12 4l0 16\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M20 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M20 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />\n  <path d=\"M20 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />\n  <path d=\"M20 16l0 .01\" />\n  <path d=\"M4 20l0 .01\" />\n  <path d=\"M8 20l0 .01\" />\n  <path d=\"M16 20l0 .01\" />\n  <path d=\"M20 20l0 .01\" />"),
    BOUNCE_LEFT(
        "bounce-left",
        "<path d=\"M20 15.5c-3 -1 -5.5 -.5 -8 4.5c-.5 -3 -1.5 -5.5 -3 -8\" />\n  <path d=\"M6 9a2 2 0 1 1 0 -4a2 2 0 0 1 0 4\" />"),
    BOUNCE_RIGHT(
        "bounce-right",
        "<path d=\"M4 15.5c3 -1 5.5 -.5 8 4.5c.5 -3 1.5 -5.5 3 -8\" />\n  <path d=\"M18 9a2 2 0 1 1 0 -4a2 2 0 0 1 0 4\" />"),
    BOX(
        "box",
        "<path d=\"M12 3l8 4.5l0 9l-8 4.5l-8 -4.5l0 -9l8 -4.5\" />\n  <path d=\"M12 12l8 -4.5\" />\n  <path d=\"M12 12l0 9\" />\n  <path d=\"M12 12l-8 -4.5\" />"),
    BOX_ALIGN_BOTTOM(
        "box-align-bottom",
        "<path d=\"M4 14h16v5a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1v-5\" />\n  <path d=\"M4 9v.01\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M9 4v.01\" />\n  <path d=\"M15 4v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M20 9v.01\" />"),
    BOX_ALIGN_BOTTOM_LEFT(
        "box-align-bottom-left",
        "<path d=\"M5 13h5a1 1 0 0 1 1 1v5a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1v-5a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 9v.01\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M9 4v.01\" />\n  <path d=\"M15 4v.01\" />\n  <path d=\"M15 20v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M20 9v.01\" />\n  <path d=\"M20 15v.01\" />\n  <path d=\"M20 20v.01\" />"),
    BOX_ALIGN_BOTTOM_RIGHT(
        "box-align-bottom-right",
        "<path d=\"M19 13h-5a1 1 0 0 0 -1 1v5a1 1 0 0 0 1 1h5a1 1 0 0 0 1 -1v-5a1 1 0 0 0 -1 -1\" />\n  <path d=\"M20 9v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M15 4v.01\" />\n  <path d=\"M9 4v.01\" />\n  <path d=\"M9 20v.01\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M4 9v.01\" />\n  <path d=\"M4 15v.01\" />\n  <path d=\"M4 20v.01\" />"),
    BOX_ALIGN_LEFT(
        "box-align-left",
        "<path d=\"M10.002 20.003v-16h-5a1 1 0 0 0 -1 1v14a1 1 0 0 0 1 1h5\" />\n  <path d=\"M15.002 20.003h-.01\" />\n  <path d=\"M20.003 20.003h-.011\" />\n  <path d=\"M20.003 15.002h-.011\" />\n  <path d=\"M20.003 9.002h-.011\" />\n  <path d=\"M20.003 4.002h-.011\" />\n  <path d=\"M15.002 4.002h-.01\" />"),
    BOX_ALIGN_RIGHT(
        "box-align-right",
        "<path d=\"M13.998 20.003v-16h5a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-5\" />\n  <path d=\"M8.998 20.003h.01\" />\n  <path d=\"M3.997 20.003h.011\" />\n  <path d=\"M3.997 15.002h.011\" />\n  <path d=\"M3.997 9.002h.011\" />\n  <path d=\"M3.997 4.002h.011\" />\n  <path d=\"M8.998 4.002h.01\" />"),
    BOX_ALIGN_TOP(
        "box-align-top",
        "<path d=\"M4 10.005h16v-5a1 1 0 0 0 -1 -1h-14a1 1 0 0 0 -1 1v5\" />\n  <path d=\"M4 15.005v-.01\" />\n  <path d=\"M4 20.005v-.01\" />\n  <path d=\"M9 20.005v-.01\" />\n  <path d=\"M15 20.005v-.01\" />\n  <path d=\"M20 20.005v-.01\" />\n  <path d=\"M20 15.005v-.01\" />"),
    BOX_ALIGN_TOP_LEFT(
        "box-align-top-left",
        "<path d=\"M11 5v5a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1v-5a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1\" />\n  <path d=\"M15 4h-.01\" />\n  <path d=\"M20 4h-.01\" />\n  <path d=\"M20 9h-.01\" />\n  <path d=\"M20 15h-.01\" />\n  <path d=\"M4 15h-.01\" />\n  <path d=\"M20 20h-.01\" />\n  <path d=\"M15 20h-.01\" />\n  <path d=\"M9 20h-.01\" />\n  <path d=\"M4 20h-.01\" />"),
    BOX_ALIGN_TOP_RIGHT(
        "box-align-top-right",
        "<path d=\"M19 11.01h-5a1 1 0 0 1 -1 -1v-5a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v5a1 1 0 0 1 -1 1\" />\n  <path d=\"M20 15.01v-.01\" />\n  <path d=\"M20 20.01v-.01\" />\n  <path d=\"M15 20.01v-.01\" />\n  <path d=\"M9 20.01v-.01\" />\n  <path d=\"M9 4.01v-.01\" />\n  <path d=\"M4 20.01v-.01\" />\n  <path d=\"M4 15.01v-.01\" />\n  <path d=\"M4 9.01v-.01\" />\n  <path d=\"M4 4.01v-.01\" />"),
    BOX_MARGIN(
        "box-margin",
        "<path d=\"M8 8h8v8h-8l0 -8\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M8 4v.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M16 4v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M20 20v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 8v.01\" />"),
    BOX_MODEL(
        "box-model",
        "<path d=\"M8 8h8v8h-8l0 -8\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M16 16l3.3 3.3\" />\n  <path d=\"M16 8l3.3 -3.3\" />\n  <path d=\"M8 8l-3.3 -3.3\" />\n  <path d=\"M8 16l-3.3 3.3\" />"),
    BOX_MODEL_2(
        "box-model-2",
        "<path d=\"M8 8h8v8h-8l0 -8\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />"),
    BOX_MODEL_2_OFF(
        "box-model-2-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M12 8h4v4m0 4h-8v-8\" />\n  <path d=\"M3 3l18 18\" />"),
    BOX_MODEL_OFF(
        "box-model-off",
        "<path d=\"M12 8h4v4m0 4h-8v-8\" />\n  <path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M16 16l3.3 3.3\" />\n  <path d=\"M16 8l3.3 -3.3\" />\n  <path d=\"M8 8l-3.3 -3.3\" />\n  <path d=\"M8 16l-3.3 3.3\" />\n  <path d=\"M3 3l18 18\" />"),
    BOX_MULTIPLE(
        "box-multiple",
        "<path d=\"M7 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M17 17v2a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h2\" />"),
    BOX_OFF(
        "box-off",
        "<path d=\"M17.765 17.757l-5.765 3.243l-8 -4.5v-9l2.236 -1.258m2.57 -1.445l3.194 -1.797l8 4.5v8.5\" />\n  <path d=\"M14.561 10.559l5.439 -3.059\" />\n  <path d=\"M12 12v9\" />\n  <path d=\"M12 12l-8 -4.5\" />\n  <path d=\"M3 3l18 18\" />"),
    BOX_PADDING(
        "box-padding",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M8 16v.01\" />\n  <path d=\"M8 12v.01\" />\n  <path d=\"M8 8v.01\" />\n  <path d=\"M16 16v.01\" />\n  <path d=\"M16 12v.01\" />\n  <path d=\"M16 8v.01\" />\n  <path d=\"M12 8v.01\" />\n  <path d=\"M12 16v.01\" />"),
    BRACKETS_ANGLE(
        "brackets-angle", "<path d=\"M8 4l-5 8l5 8\" />\n  <path d=\"M16 4l5 8l-5 8\" />"),
    BRACKETS_ANGLE_OFF(
        "brackets-angle-off",
        "<path d=\"M8 4h.01\" />\n  <path d=\"M6.453 6.474l-3.453 5.526l5 8\" />\n  <path d=\"M16 4l5 8l-1.917 3.067\" />\n  <path d=\"M17.535 17.544l-1.535 2.456\" />\n  <path d=\"M3 3l18 18\" />"),
    BRIEFCASE(
        "briefcase",
        "<path d=\"M3 9a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -9\" />\n  <path d=\"M8 7v-2a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v2\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M3 13a20 20 0 0 0 18 0\" />"),
    BRIEFCASE_2(
        "briefcase-2",
        "<path d=\"M3 9a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-9\" />\n  <path d=\"M8 7v-2a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v2\" />"),
    BRIEFCASE_OFF(
        "briefcase-off",
        "<path d=\"M11 7h8a2 2 0 0 1 2 2v8m-1.166 2.818a1.993 1.993 0 0 1 -.834 .182h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M8.185 4.158a2 2 0 0 1 1.815 -1.158h4a2 2 0 0 1 2 2v2\" />\n  <path d=\"M12 12v.01\" />\n  <path d=\"M3 13a20 20 0 0 0 11.905 1.928m3.263 -.763a20 20 0 0 0 2.832 -1.165\" />\n  <path d=\"M3 3l18 18\" />"),
    BRUSH(
        "brush",
        "<path d=\"M3 21v-4a4 4 0 1 1 4 4h-4\" />\n  <path d=\"M21 3a16 16 0 0 0 -12.8 10.2\" />\n  <path d=\"M21 3a16 16 0 0 1 -10.2 12.8\" />\n  <path d=\"M10.6 9a9 9 0 0 1 4.4 4.4\" />"),
    BRUSH_OFF(
        "brush-off",
        "<path d=\"M3 17a4 4 0 1 1 4 4h-4v-4\" />\n  <path d=\"M21 3a16 16 0 0 0 -9.309 4.704m-1.795 2.212a15.993 15.993 0 0 0 -1.696 3.284\" />\n  <path d=\"M21 3a16 16 0 0 1 -4.697 9.302m-2.195 1.786a15.993 15.993 0 0 1 -3.308 1.712\" />\n  <path d=\"M3 3l18 18\" />"),
    BUCKET(
        "bucket",
        "<path d=\"M4 7a8 4 0 1 0 16 0a8 4 0 1 0 -16 0\" />\n  <path d=\"M4 7c0 .664 .088 1.324 .263 1.965l2.737 10.035c.5 1.5 2.239 2 5 2s4.5 -.5 5 -2c.333 -1 1.246 -4.345 2.737 -10.035a7.45 7.45 0 0 0 .263 -1.965\" />"),
    BUCKET_DROPLET(
        "bucket-droplet",
        "<path d=\"M5 16l1.465 1.638a2 2 0 1 1 -3.015 .099l1.55 -1.737\" />\n  <path d=\"M13.737 9.737c2.299 -2.3 3.23 -5.095 2.081 -6.245c-1.15 -1.15 -3.945 -.217 -6.244 2.082c-2.3 2.299 -3.231 5.095 -2.082 6.244c1.15 1.15 3.946 .218 6.245 -2.081\" />\n  <path d=\"M7.492 11.818c.362 .362 .768 .676 1.208 .934l6.895 4.047c1.078 .557 2.255 -.075 3.692 -1.512c1.437 -1.437 2.07 -2.614 1.512 -3.692c-.372 -.718 -1.72 -3.017 -4.047 -6.895a6.015 6.015 0 0 0 -.934 -1.208\" />"),
    BUCKET_OFF(
        "bucket-off",
        "<path d=\"M5.029 5.036c-.655 .58 -1.029 1.25 -1.029 1.964c0 2.033 3.033 3.712 6.96 3.967m3.788 -.21c3.064 -.559 5.252 -2.029 5.252 -3.757c0 -2.21 -3.582 -4 -8 -4c-1.605 0 -3.1 .236 -4.352 .643\" />\n  <path d=\"M4 7c0 .664 .088 1.324 .263 1.965l2.737 10.035c.5 1.5 2.239 2 5 2s4.5 -.5 5 -2c.1 -.3 .252 -.812 .457 -1.535m.862 -3.146c.262 -.975 .735 -2.76 1.418 -5.354a7.45 7.45 0 0 0 .263 -1.965\" />\n  <path d=\"M3 3l18 18\" />"),
    BULB(
        "bulb",
        "<path d=\"M3 12h1m8 -9v1m8 8h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7\" />\n  <path d=\"M9 16a5 5 0 1 1 6 0a3.5 3.5 0 0 0 -1 3a2 2 0 0 1 -4 0a3.5 3.5 0 0 0 -1 -3\" />\n  <path d=\"M9.7 17l4.6 0\" />"),
    BULB_OFF(
        "bulb-off",
        "<path d=\"M3 12h1m8 -9v1m8 8h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7\" />\n  <path d=\"M11.089 7.083a5 5 0 0 1 5.826 5.84m-1.378 2.611a5.012 5.012 0 0 1 -.537 .466a3.5 3.5 0 0 0 -1 3a2 2 0 1 1 -4 0a3.5 3.5 0 0 0 -1 -3a5 5 0 0 1 -.528 -7.544\" />\n  <path d=\"M9.7 17h4.6\" />\n  <path d=\"M3 3l18 18\" />"),
    CANDLE(
        "candle",
        "<path d=\"M9 21h6v-10a1 1 0 0 0 -1 -1h-4a1 1 0 0 0 -1 1l0 10\" />\n  <path d=\"M12 2l1.465 1.638a2 2 0 1 1 -3.015 .099l1.55 -1.737\" />"),
    CAP_PROJECTING(
        "cap-projecting",
        "<path d=\"M20 6h-13a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h13\" />\n  <path d=\"M13 12a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M13 12h7\" />"),
    CAP_ROUNDED(
        "cap-rounded",
        "<path d=\"M20 6h-9a6 6 0 1 0 0 12h9\" />\n  <path d=\"M13 12a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M13 12h7\" />"),
    CAP_STRAIGHT(
        "cap-straight",
        "<path d=\"M8 12a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M8 12h12\" />\n  <path d=\"M20 6h-12a2 2 0 0 0 -2 2v2\" />\n  <path d=\"M6 14v2a2 2 0 0 0 2 2h12\" />"),
    CARDS(
        "cards",
        "<path d=\"M3.604 7.197l7.138 -3.109a.96 .96 0 0 1 1.27 .527l4.924 11.902a1 1 0 0 1 -.514 1.304l-7.137 3.109a.96 .96 0 0 1 -1.271 -.527l-4.924 -11.903a1 1 0 0 1 .514 -1.304l0 .001\" />\n  <path d=\"M15 4h1a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M20 6c.264 .112 .52 .217 .768 .315a1 1 0 0 1 .53 1.311l-2.298 5.374\" />"),
    CAROUSEL_HORIZONTAL(
        "carousel-horizontal",
        "<path d=\"M7 6a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1l0 -12\" />\n  <path d=\"M22 17h-1a1 1 0 0 1 -1 -1v-8a1 1 0 0 1 1 -1h1\" />\n  <path d=\"M2 17h1a1 1 0 0 0 1 -1v-8a1 1 0 0 0 -1 -1h-1\" />"),
    CAROUSEL_VERTICAL(
        "carousel-vertical",
        "<path d=\"M19 8v8a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-8a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1\" />\n  <path d=\"M7 22v-1a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1v1\" />\n  <path d=\"M17 2v1a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1v-1\" />"),
    CELL(
        "cell",
        "<path d=\"M8 4l-4 2v5l4 2l4 -2v-5l-4 -2\" />\n  <path d=\"M12 11l4 2l4 -2v-5l-4 -2l-4 2\" />\n  <path d=\"M8 13v5l4 2l4 -2v-5\" />"),
    CHAIR_DIRECTOR(
        "chair-director",
        "<path d=\"M6 21l12 -9\" />\n  <path d=\"M6 12l12 9\" />\n  <path d=\"M5 12h14\" />\n  <path d=\"M6 3v9\" />\n  <path d=\"M18 3v9\" />\n  <path d=\"M6 8h12\" />\n  <path d=\"M6 5h12\" />"),
    CHISEL(
        "chisel",
        "<path d=\"M14 14l1.5 1.5\" />\n  <path d=\"M18.347 15.575l2.08 2.079a1.96 1.96 0 0 1 -2.773 2.772l-2.08 -2.079a1.96 1.96 0 0 1 2.773 -2.772\" />\n  <path d=\"M3 6l3 -3l7.414 7.414a2 2 0 0 1 .586 1.414v2.172h-2.172a2 2 0 0 1 -1.414 -.586l-7.414 -7.414\" />"),
    CHRISTMAS_BALL(
        "christmas-ball",
        "<path d=\"M4 13a8 8 0 1 0 16 0a8 8 0 1 0 -16 0\" />\n  <path d=\"M11 5l1 -2l1 2\" />\n  <path d=\"M4.512 10.161c2.496 -1.105 4.992 -.825 7.488 .839c2.627 1.752 5.255 1.97 7.882 .653\" />\n  <path d=\"M4.315 15.252c2.561 -1.21 5.123 -.96 7.685 .748c2.293 1.528 4.585 1.889 6.878 1.081\" />"),
    COFFIN(
        "coffin",
        "<path d=\"M7 3l-2 6l2 12h6l2 -12l-2 -6l-6 0\" />\n  <path d=\"M10 7v5\" />\n  <path d=\"M8 9h4\" />\n  <path d=\"M13 21h4l2 -12l-2 -6h-4\" />"),
    COLOR_FILTER(
        "color-filter",
        "<path d=\"M13.58 13.79c.27 .68 .42 1.43 .42 2.21c0 1.77 -.77 3.37 -2 4.46a5.93 5.93 0 0 1 -4 1.54c-3.31 0 -6 -2.69 -6 -6c0 -2.76 1.88 -5.1 4.42 -5.79\" />\n  <path d=\"M17.58 10.21c2.54 .69 4.42 3.03 4.42 5.79c0 3.31 -2.69 6 -6 6a5.93 5.93 0 0 1 -4 -1.54\" />\n  <path d=\"M6 8a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />"),
    COLOR_PICKER(
        "color-picker",
        "<path d=\"M11 7l6 6\" />\n  <path d=\"M4 16l11.7 -11.7a1 1 0 0 1 1.4 0l2.6 2.6a1 1 0 0 1 0 1.4l-11.7 11.7h-4v-4\" />"),
    COLOR_PICKER_OFF(
        "color-picker-off",
        "<path d=\"M11 7l6 6\" />\n  <path d=\"M12 8l3.699 -3.699a1 1 0 0 1 1.4 0l2.6 2.6a1 1 0 0 1 0 1.4l-3.702 3.702m-2 2l-6 6h-4v-4l6 -6\" />\n  <path d=\"M3 3l18 18\" />"),
    COLOR_SWATCH(
        "color-swatch",
        "<path d=\"M19 3h-4a2 2 0 0 0 -2 2v12a4 4 0 0 0 8 0v-12a2 2 0 0 0 -2 -2\" />\n  <path d=\"M13 7.35l-2 -2a2 2 0 0 0 -2.828 0l-2.828 2.828a2 2 0 0 0 0 2.828l9 9\" />\n  <path d=\"M7.3 13h-2.3a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h12\" />\n  <path d=\"M17 17l0 .01\" />"),
    COLOR_SWATCH_OFF(
        "color-swatch-off",
        "<path d=\"M13 13v4a4 4 0 0 0 6.832 2.825m1.168 -2.825v-12a2 2 0 0 0 -2 -2h-4a2 2 0 0 0 -2 2v4\" />\n  <path d=\"M13 7.35l-2 -2a2 2 0 0 0 -2.11 -.461m-2.13 1.874l-1.416 1.415a2 2 0 0 0 0 2.828l9 9\" />\n  <path d=\"M7.3 13h-2.3a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h12\" />\n  <path d=\"M17 17v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    COMPONENTS(
        "components",
        "<path d=\"M3 12l3 3l3 -3l-3 -3l-3 3\" />\n  <path d=\"M15 12l3 3l3 -3l-3 -3l-3 3\" />\n  <path d=\"M9 6l3 3l3 -3l-3 -3l-3 3\" />\n  <path d=\"M9 18l3 3l3 -3l-3 -3l-3 3\" />"),
    COMPONENTS_OFF(
        "components-off",
        "<path d=\"M3 12l3 3l3 -3l-3 -3l-3 3\" />\n  <path d=\"M18.5 14.5l2.5 -2.5l-3 -3l-2.5 2.5\" />\n  <path d=\"M12.499 8.501l2.501 -2.501l-3 -3l-2.5 2.5\" />\n  <path d=\"M9 18l3 3l3 -3l-3 -3l-3 3\" />\n  <path d=\"M3 3l18 18\" />"),
    CONFETTI(
        "confetti",
        "<path d=\"M4 5h2\" />\n  <path d=\"M5 4v2\" />\n  <path d=\"M11.5 4l-.5 2\" />\n  <path d=\"M18 5h2\" />\n  <path d=\"M19 4v2\" />\n  <path d=\"M15 9l-1 1\" />\n  <path d=\"M18 13l2 -.5\" />\n  <path d=\"M18 19h2\" />\n  <path d=\"M19 18v2\" />\n  <path d=\"M14 16.518l-6.518 -6.518l-4.39 9.58a1 1 0 0 0 1.329 1.329l9.579 -4.39\" />"),
    CONFETTI_OFF(
        "confetti-off",
        "<path d=\"M4 5h1\" />\n  <path d=\"M5 5v1\" />\n  <path d=\"M11.5 4l-.5 2\" />\n  <path d=\"M18 5h2\" />\n  <path d=\"M19 4v2\" />\n  <path d=\"M15 9l-1 1\" />\n  <path d=\"M18 13l2 -.5\" />\n  <path d=\"M18 19h1\" />\n  <path d=\"M19 19v1\" />\n  <path d=\"M14 16.518l-6.518 -6.518l-4.39 9.58a1 1 0 0 0 1.329 1.329l9.579 -4.39\" />\n  <path d=\"M3 3l18 18\" />"),
    CONTAINER(
        "container",
        "<path d=\"M20 4v.01\" />\n  <path d=\"M20 20v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M8 5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 8v.01\" />"),
    CONTAINER_OFF(
        "container-off",
        "<path d=\"M20 4v.01\" />\n  <path d=\"M20 20v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M8.297 4.289a1 1 0 0 1 .703 -.289h6a1 1 0 0 1 1 1v7m0 4v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-11\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 8v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    COOKIE_MAN(
        "cookie-man",
        "<path d=\"M12 2a5 5 0 0 1 2.845 9.112l.147 .369l1.755 -.803c.969 -.443 2.12 -.032 2.571 .918a1.88 1.88 0 0 1 -.787 2.447l-.148 .076l-2.383 1.089v2.02l1.426 1.425l.114 .125a1.96 1.96 0 0 1 -2.762 2.762l-.125 -.114l-2.079 -2.08l-.114 -.124a2 2 0 0 1 -.161 -.22h-.599q -.071 .114 -.16 .22l-.115 .125l-2.08 2.079a1.96 1.96 0 0 1 -2.886 -2.648l.114 -.125l1.427 -1.426v-2.019l-2.383 -1.09l-.148 -.075a1.88 1.88 0 0 1 -.787 -2.447c.429 -.902 1.489 -1.318 2.424 -.978l.147 .06l1.755 .803l.147 -.369a5 5 0 0 1 -2.15 -3.895v-.217a5 5 0 0 1 5 -5l-.005 0\" />\n  <path d=\"M12 16h.01\" />\n  <path d=\"M12 13h.01\" />\n  <path d=\"M10 7h.01\" />\n  <path d=\"M14 7h.01\" />\n  <path d=\"M12 9h.01\" />"),
    CROP(
        "crop",
        "<path d=\"M8 5v10a1 1 0 0 0 1 1h10\" />\n  <path d=\"M5 8h10a1 1 0 0 1 1 1v10\" />"),
    CROP_1_1(
        "crop-1-1",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />"),
    CROP_16_9(
        "crop-16-9",
        "<path d=\"M4 10a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -4\" />"),
    CROP_3_2(
        "crop-3-2",
        "<path d=\"M4 9a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -6\" />"),
    CROP_5_4(
        "crop-5-4",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -10\" />"),
    CROP_7_5(
        "crop-7-5",
        "<path d=\"M4 8a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -8\" />"),
    CROP_LANDSCAPE(
        "crop-landscape",
        "<path d=\"M4 8a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -8\" />"),
    CROP_PORTRAIT(
        "crop-portrait",
        "<path d=\"M6 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -12\" />"),
    CROWN("crown", "<path d=\"M12 6l4 6l5 -4l-2 10h-14l-2 -10l5 4l4 -6\" />"),
    CROWN_OFF(
        "crown-off",
        "<path d=\"M18 18h-13l-1.865 -9.327a.25 .25 0 0 1 .4 -.244l4.465 3.571l1.6 -2.4m1.596 -2.394l.804 -1.206l4 6l4.464 -3.571a.25 .25 0 0 1 .401 .244l-1.363 6.818\" />\n  <path d=\"M3 3l18 18\" />"),
    CUT(
        "cut",
        "<path d=\"M4 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9.15 14.85l8.85 -10.85\" />\n  <path d=\"M6 4l8.85 10.85\" />"),
    DIMENSIONS(
        "dimensions",
        "<path d=\"M3 5h11\" />\n  <path d=\"M12 7l2 -2l-2 -2\" />\n  <path d=\"M5 3l-2 2l2 2\" />\n  <path d=\"M19 10v11\" />\n  <path d=\"M17 19l2 2l2 -2\" />\n  <path d=\"M21 12l-2 -2l-2 2\" />\n  <path d=\"M3 12a2 2 0 0 1 2 -2h7a2 2 0 0 1 2 2v7a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2l0 -7\" />"),
    DRAG_DROP(
        "drag-drop",
        "<path d=\"M19 11v-2a2 2 0 0 0 -2 -2h-8a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M13 13l9 3l-4 2l-2 4l-3 -9\" />\n  <path d=\"M3 3l0 .01\" />\n  <path d=\"M7 3l0 .01\" />\n  <path d=\"M11 3l0 .01\" />\n  <path d=\"M15 3l0 .01\" />\n  <path d=\"M3 7l0 .01\" />\n  <path d=\"M3 11l0 .01\" />\n  <path d=\"M3 15l0 .01\" />"),
    DRAG_DROP_2(
        "drag-drop-2",
        "<path d=\"M8 10a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M4 4l0 .01\" />\n  <path d=\"M8 4l0 .01\" />\n  <path d=\"M12 4l0 .01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M4 8l0 .01\" />\n  <path d=\"M4 12l0 .01\" />\n  <path d=\"M4 16l0 .01\" />"),
    DROPLET(
        "droplet",
        "<path d=\"M7.502 19.423c2.602 2.105 6.395 2.105 8.996 0c2.602 -2.105 3.262 -5.708 1.566 -8.546l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546\" />"),
    DROPLET_BOLT(
        "droplet-bolt",
        "<path d=\"M18.628 12.076a6.653 6.653 0 0 0 -.564 -1.199l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546c1.7 1.375 3.906 1.852 5.958 1.431\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DROPLET_CANCEL(
        "droplet-cancel",
        "<path d=\"M18.606 12.014a6.659 6.659 0 0 0 -.542 -1.137l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.154 7.154 0 0 0 4.826 1.572\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DROPLET_CHECK(
        "droplet-check",
        "<path d=\"M18.967 13.594a6.568 6.568 0 0 0 -.903 -2.717l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.125 7.125 0 0 0 4.04 1.565\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DROPLET_CODE(
        "droplet-code",
        "<path d=\"M18.907 13.147a6.586 6.586 0 0 0 -.843 -2.27l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.123 7.123 0 0 0 3.99 1.561\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DROPLET_COG(
        "droplet-cog",
        "<path d=\"M18.421 11.56a6.702 6.702 0 0 0 -.357 -.683l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.144 7.144 0 0 0 4.518 1.58\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DROPLET_DOLLAR(
        "droplet-dollar",
        "<path d=\"M17.668 10.29l-4.493 -6.673c-.421 -.625 -1.288 -.803 -1.937 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.175 7.175 0 0 0 5.493 1.51\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DROPLET_DOWN(
        "droplet-down",
        "<path d=\"M18.602 12.003a6.66 6.66 0 0 0 -.538 -1.126l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.159 7.159 0 0 0 4.972 1.564\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DROPLET_EXCLAMATION(
        "droplet-exclamation",
        "<path d=\"M18.602 12.004a6.66 6.66 0 0 0 -.538 -1.127l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546c2.142 1.734 5.092 2.04 7.519 .919\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DROPLET_HALF(
        "droplet-half",
        "<path d=\"M7.502 19.423c2.602 2.105 6.395 2.105 8.996 0c2.602 -2.105 3.262 -5.708 1.566 -8.546l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546\" />\n  <path d=\"M12 3v18\" />"),
    DROPLET_HALF_2(
        "droplet-half-2",
        "<path d=\"M7.502 19.423c2.602 2.105 6.395 2.105 8.996 0c2.602 -2.105 3.262 -5.708 1.566 -8.546l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546\" />\n  <path d=\"M5 14h14\" />"),
    DROPLET_HEART(
        "droplet-heart",
        "<path d=\"M18.288 11.282a6.734 6.734 0 0 0 -.224 -.405l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.117 7.117 0 0 0 3.824 1.548\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DROPLET_MINUS(
        "droplet-minus",
        "<path d=\"M18.946 15.083a6.538 6.538 0 0 0 -.882 -4.206l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.163 7.163 0 0 0 5.089 1.555\" />\n  <path d=\"M16 19h6\" />"),
    DROPLET_OFF(
        "droplet-off",
        "<path d=\"M18.963 14.938a6.54 6.54 0 0 0 -.899 -4.06l-4.89 -7.26c-.42 -.626 -1.287 -.804 -1.936 -.398a1.376 1.376 0 0 0 -.41 .397l-1.282 1.9m-1.625 2.415l-1.986 2.946c-1.695 2.837 -1.035 6.44 1.567 8.545c2.602 2.105 6.395 2.105 8.996 0a6.83 6.83 0 0 0 1.376 -1.499\" />\n  <path d=\"M3 3l18 18\" />"),
    DROPLET_PAUSE(
        "droplet-pause",
        "<path d=\"M18.952 13.456a6.573 6.573 0 0 0 -.888 -2.579l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.176 7.176 0 0 0 5.517 1.507\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    DROPLET_PIN(
        "droplet-pin",
        "<path d=\"M18.064 10.877l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.163 7.163 0 0 0 5.102 1.554\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    DROPLET_PLUS(
        "droplet-plus",
        "<path d=\"M18.602 12.004a6.66 6.66 0 0 0 -.538 -1.127l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.16 7.16 0 0 0 5.033 1.56\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DROPLET_QUESTION(
        "droplet-question",
        "<path d=\"M18.064 10.877l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546c2.203 1.782 5.259 2.056 7.723 .82\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DROPLET_SEARCH(
        "droplet-search",
        "<path d=\"M18.064 10.877l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.13 7.13 0 0 0 4.168 1.572\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DROPLET_SHARE(
        "droplet-share",
        "<path d=\"M18.884 13.025a6.591 6.591 0 0 0 -.82 -2.148l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.125 7.125 0 0 0 4.498 1.58\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DROPLET_STAR(
        "droplet-star",
        "<path d=\"M17.496 10.034l-4.321 -6.417c-.421 -.625 -1.288 -.803 -1.937 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.106 7.106 0 0 0 3.547 1.517\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DROPLET_UP(
        "droplet-up",
        "<path d=\"M18.6 11.998a6.66 6.66 0 0 0 -.536 -1.12l-4.89 -7.26c-.42 -.626 -1.287 -.804 -1.936 -.398a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.16 7.16 0 0 0 5.002 1.562\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DROPLET_X(
        "droplet-x",
        "<path d=\"M18.953 13.467a6.572 6.572 0 0 0 -.889 -2.59l-4.89 -7.26c-.42 -.625 -1.287 -.803 -1.936 -.397a1.376 1.376 0 0 0 -.41 .397l-4.893 7.26c-1.695 2.838 -1.035 6.441 1.567 8.546a7.179 7.179 0 0 0 5.633 1.49\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    EASE_IN("ease-in", "<path d=\"M3 20c8 0 18 -16 18 -16\" />"),
    EASE_IN_CONTROL_POINT(
        "ease-in-control-point",
        "<path d=\"M3 19c8 0 18 -16 18 -16\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M17 19h-2\" />\n  <path d=\"M12 19h-2\" />"),
    EASE_IN_OUT("ease-in-out", "<path d=\"M3 20c8 0 10 -16 18 -16\" />"),
    EASE_IN_OUT_CONTROL_POINTS(
        "ease-in-out-control-points",
        "<path d=\"M17 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M17 20h-2\" />\n  <path d=\"M7 4a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M7 4h2\" />\n  <path d=\"M14 4h-2\" />\n  <path d=\"M12 20h-2\" />\n  <path d=\"M3 20c8 0 10 -16 18 -16\" />"),
    EASE_OUT("ease-out", "<path d=\"M3 20s10 -16 18 -16\" />"),
    EASE_OUT_CONTROL_POINT(
        "ease-out-control-point",
        "<path d=\"M3 21s10 -16 18 -16\" />\n  <path d=\"M7 5a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M7 5h2\" />\n  <path d=\"M14 5h-2\" />"),
    EDIT(
        "edit",
        "<path d=\"M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M20.385 6.585a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3l8.385 -8.415\" />\n  <path d=\"M16 5l3 3\" />"),
    EDIT_BULK(
        "edit-bulk",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2\" />\n  <path d=\"M3 11a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2\" />\n  <path d=\"M20.385 9.585a2.1 2.1 0 0 0 -2.97 -2.97l-6.415 6.385v3h3l6.385 -6.415\" />\n  <path d=\"M16 8l3 3\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2\" />"),
    EDIT_CIRCLE(
        "edit-circle",
        "<path d=\"M12 15l8.385 -8.415a2.1 2.1 0 0 0 -2.97 -2.97l-8.415 8.385v3h3\" />\n  <path d=\"M16 5l3 3\" />\n  <path d=\"M9 7.07a7 7 0 0 0 1 13.93a7 7 0 0 0 6.929 -6\" />"),
    EDIT_CIRCLE_OFF(
        "edit-circle-off",
        "<path d=\"M10.507 10.498l-1.507 1.502v3h3l1.493 -1.498m2 -2.01l4.89 -4.907a2.1 2.1 0 0 0 -2.97 -2.97l-4.913 4.896\" />\n  <path d=\"M16 5l3 3\" />\n  <path d=\"M7.476 7.471a7 7 0 0 0 2.524 13.529a7 7 0 0 0 6.53 -4.474\" />\n  <path d=\"M3 3l18 18\" />"),
    EDIT_OFF(
        "edit-off",
        "<path d=\"M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M10.507 10.498l-1.507 1.502v3h3l1.493 -1.498m2 -2.01l4.89 -4.907a2.1 2.1 0 0 0 -2.97 -2.97l-4.913 4.896\" />\n  <path d=\"M16 5l3 3\" />\n  <path d=\"M3 3l18 18\" />"),
    FAVICON(
        "favicon",
        "<path d=\"M2 8a3 3 0 0 1 3 -3h14a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3l0 -8\" />\n  <path d=\"M6 10v4\" />\n  <path d=\"M11 10a2 2 0 1 0 0 4\" />\n  <path d=\"M14 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    FLIP_HORIZONTAL(
        "flip-horizontal",
        "<path d=\"M12 3l0 18\" />\n  <path d=\"M16 7l0 10l5 0l-5 -10\" />\n  <path d=\"M8 7l0 10l-5 0l5 -10\" />"),
    FLIP_VERTICAL(
        "flip-vertical",
        "<path d=\"M3 12l18 0\" />\n  <path d=\"M7 16l10 0l-10 5l0 -5\" />\n  <path d=\"M7 8l10 0l-10 -5l0 5\" />"),
    FRAME(
        "frame",
        "<path d=\"M4 7l16 0\" />\n  <path d=\"M4 17l16 0\" />\n  <path d=\"M7 4l0 16\" />\n  <path d=\"M17 4l0 16\" />"),
    FRAME_OFF(
        "frame-off",
        "<path d=\"M4 7h3m4 0h9\" />\n  <path d=\"M4 17h13\" />\n  <path d=\"M7 7v13\" />\n  <path d=\"M17 4v9m0 4v3\" />\n  <path d=\"M3 3l18 18\" />"),
    FREEZE_COLUMN(
        "freeze-column",
        "<path d=\"M9 9.5l-6 6\" />\n  <path d=\"M9 4l-6 6\" />\n  <path d=\"M9 15l-5 5\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    FREEZE_ROW(
        "freeze-row",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M21 9h-18\" />\n  <path d=\"M15 3l-6 6\" />\n  <path d=\"M9.5 3l-6 6\" />\n  <path d=\"M20 3.5l-5.5 5.5\" />"),
    FREEZE_ROW_COLUMN(
        "freeze-row-column",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M15 3l-12 12\" />\n  <path d=\"M9.5 3l-6 6\" />\n  <path d=\"M20 3.5l-5.5 5.5\" />\n  <path d=\"M9 15l-5 5\" />\n  <path d=\"M21 9h-12v12\" />"),
    GIZMO(
        "gizmo",
        "<path d=\"M20 19l-8 -5.5l-8 5.5\" />\n  <path d=\"M12 4v9.5\" />\n  <path d=\"M11 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M19 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GRADIENTER(
        "gradienter",
        "<path d=\"M3.227 14c.917 4 4.497 7 8.773 7c4.277 0 7.858 -3 8.773 -7\" />\n  <path d=\"M20.78 10a9 9 0 0 0 -8.78 -7a8.985 8.985 0 0 0 -8.782 7\" />\n  <path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    GRAIN(
        "grain",
        "<path d=\"M3.5 9.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8.5 4.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8.5 14.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3.5 19.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M13.5 9.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18.5 4.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M13.5 19.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18.5 14.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GRID_3X3(
        "grid-3x3",
        "<path d=\"M3 8h18\" />\n  <path d=\"M3 16h18\" />\n  <path d=\"M8 3v18\" />\n  <path d=\"M16 3v18\" />"),
    GRID_4X4(
        "grid-4x4",
        "<path d=\"M3 6h18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 18h18\" />\n  <path d=\"M6 3v18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M18 3v18\" />"),
    GRID_GOLDENRATIO(
        "grid-goldenratio",
        "<path d=\"M3 10h18\" />\n  <path d=\"M3 14h18\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M14 3v18\" />"),
    GUITAR_PICK(
        "guitar-pick",
        "<path d=\"M16 18.5c2 -2.5 4 -6.5 4 -10.5c0 -2.946 -2.084 -4.157 -4.204 -4.654c-.864 -.23 -2.13 -.346 -3.796 -.346c-1.667 0 -2.932 .115 -3.796 .346c-2.12 .497 -4.204 1.708 -4.204 4.654c0 3.312 2 8 4 10.5c.297 .37 .618 .731 .963 1.081l.354 .347a3.9 3.9 0 0 0 5.364 0a14.05 14.05 0 0 0 1.319 -1.428\" />"),
    HAMMER(
        "hammer",
        "<path d=\"M11.414 10l-7.383 7.418a2.091 2.091 0 0 0 0 2.967a2.11 2.11 0 0 0 2.976 0l7.407 -7.385\" />\n  <path d=\"M18.121 15.293l2.586 -2.586a1 1 0 0 0 0 -1.414l-7.586 -7.586a1 1 0 0 0 -1.414 0l-2.586 2.586a1 1 0 0 0 0 1.414l7.586 7.586a1 1 0 0 0 1.414 0\" />"),
    HAMMER_OFF(
        "hammer-off",
        "<path d=\"M10.698 10.72l-6.668 6.698a2.091 2.091 0 0 0 0 2.967a2.11 2.11 0 0 0 2.976 0l6.696 -6.676\" />\n  <path d=\"M18.713 14.702l2 -2a1 1 0 0 0 0 -1.414l-7.586 -7.586a1 1 0 0 0 -1.414 0l-2 2\" />\n  <path d=\"M3 3l18 18\" />"),
    HASH(
        "hash",
        "<path d=\"M5 9l14 0\" />\n  <path d=\"M5 15l14 0\" />\n  <path d=\"M11 4l-4 16\" />\n  <path d=\"M17 4l-4 16\" />"),
    HIERARCHY(
        "hierarchy",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6.5 17.5l5.5 -4.5l5.5 4.5\" />\n  <path d=\"M12 7l0 6\" />"),
    HIERARCHY_2(
        "hierarchy-2",
        "<path d=\"M10 3h4v4h-4l0 -4\" />\n  <path d=\"M3 17h4v4h-4l0 -4\" />\n  <path d=\"M17 17h4v4h-4l0 -4\" />\n  <path d=\"M7 17l5 -4l5 4\" />\n  <path d=\"M12 7l0 6\" />"),
    HIERARCHY_3(
        "hierarchy-3",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M18 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 17l2 -3\" />\n  <path d=\"M9 10l2 -3\" />\n  <path d=\"M13 7l2 3\" />\n  <path d=\"M17 14l2 3\" />\n  <path d=\"M15 14l-2 3\" />\n  <path d=\"M9 14l2 3\" />"),
    HIERARCHY_OFF(
        "hierarchy-off",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17.585 17.587a2 2 0 0 0 2.813 2.843\" />\n  <path d=\"M6.5 17.5l5.5 -4.5l5.5 4.5\" />\n  <path d=\"M12 7v1m0 4v1\" />\n  <path d=\"M3 3l18 18\" />"),
    ICOSAHEDRON(
        "icosahedron",
        "<path d=\"M21 8.007v7.986a2 2 0 0 1 -1.006 1.735l-7 4.007a2 2 0 0 1 -1.988 0l-7 -4.007a2 2 0 0 1 -1.006 -1.735v-7.986a2 2 0 0 1 1.006 -1.735l7 -4.007a2 2 0 0 1 1.988 0l7 4.007a2 2 0 0 1 1.006 1.735\" />\n  <path d=\"M3.29 6.97l4.21 2.03\" />\n  <path d=\"M20.71 6.97l-4.21 2.03\" />\n  <path d=\"M20.7 17h-17.4\" />\n  <path d=\"M11.76 2.03l-4.26 6.97l-4.3 7.84\" />\n  <path d=\"M12.24 2.03q 2.797 4.44 4.26 6.97t 4.3 7.84\" />\n  <path d=\"M12 17l-4.5 -8h9l-4.5 8\" />\n  <path d=\"M12 17v5\" />"),
    INNER_SHADOW_BOTTOM(
        "inner-shadow-bottom",
        "<path d=\"M18.364 18.364a9 9 0 1 0 -12.728 -12.728a9 9 0 0 0 12.728 12.728\" />\n  <path d=\"M7.757 16.243a6 6 0 0 0 8.486 0\" />"),
    INNER_SHADOW_BOTTOM_LEFT(
        "inner-shadow-bottom-left",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M6 12a6 6 0 0 0 6 6\" />"),
    INNER_SHADOW_BOTTOM_RIGHT(
        "inner-shadow-bottom-right",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M18 12a6 6 0 0 1 -6 6\" />"),
    INNER_SHADOW_LEFT(
        "inner-shadow-left",
        "<path d=\"M5.636 5.636a9 9 0 1 1 12.728 12.728a9 9 0 0 1 -12.728 -12.728\" />\n  <path d=\"M7.757 16.243a6 6 0 0 1 0 -8.486\" />"),
    INNER_SHADOW_RIGHT(
        "inner-shadow-right",
        "<path d=\"M18.364 18.364a9 9 0 1 1 -12.728 -12.728a9 9 0 0 1 12.728 12.728\" />\n  <path d=\"M16.243 7.757a6 6 0 0 1 0 8.486\" />"),
    INNER_SHADOW_TOP(
        "inner-shadow-top",
        "<path d=\"M5.636 5.636a9 9 0 1 0 12.728 12.728a9 9 0 0 0 -12.728 -12.728\" />\n  <path d=\"M16.243 7.757a6 6 0 0 0 -8.486 0\" />"),
    INNER_SHADOW_TOP_LEFT(
        "inner-shadow-top-left",
        "<path d=\"M12 3a9 9 0 1 1 0 18a9 9 0 0 1 0 -18\" />\n  <path d=\"M6 12a6 6 0 0 1 6 -6\" />"),
    INNER_SHADOW_TOP_RIGHT(
        "inner-shadow-top-right",
        "<path d=\"M12 3a9 9 0 1 0 0 18a9 9 0 0 0 0 -18\" />\n  <path d=\"M18 12a6 6 0 0 0 -6 -6\" />"),
    KEY(
        "key",
        "<path d=\"M16.555 3.843l3.602 3.602a2.877 2.877 0 0 1 0 4.069l-2.643 2.643a2.877 2.877 0 0 1 -4.069 0l-.301 -.301l-6.558 6.558a2 2 0 0 1 -1.239 .578l-.175 .008h-1.172a1 1 0 0 1 -.993 -.883l-.007 -.117v-1.172a2 2 0 0 1 .467 -1.284l.119 -.13l.414 -.414h2v-2h2v-2l2.144 -2.144l-.301 -.301a2.877 2.877 0 0 1 0 -4.069l2.643 -2.643a2.877 2.877 0 0 1 4.069 0\" />\n  <path d=\"M15 9h.01\" />"),
    KEY_OFF(
        "key-off",
        "<path d=\"M10.17 6.159l2.316 -2.316a2.877 2.877 0 0 1 4.069 0l3.602 3.602a2.877 2.877 0 0 1 0 4.069l-2.33 2.33\" />\n  <path d=\"M14.931 14.948a2.863 2.863 0 0 1 -1.486 -.79l-.301 -.302l-6.558 6.558a2 2 0 0 1 -1.239 .578l-.175 .008h-1.172a1 1 0 0 1 -.993 -.883l-.007 -.117v-1.172a2 2 0 0 1 .467 -1.284l.119 -.13l.414 -.414h2v-2h2v-2l2.144 -2.144l-.301 -.301a2.863 2.863 0 0 1 -.794 -1.504\" />\n  <path d=\"M15 9h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    LADLE(
        "ladle",
        "<path d=\"M3 14v1a6 6 0 1 0 12 0v-9a3 3 0 0 1 6 0\" />\n  <path d=\"M9 16c-.663 0 -1.3 -.036 -1.896 -.102l-.5 -.064c-2.123 -.308 -3.604 -1.013 -3.604 -1.834c0 -.82 1.482 -1.526 3.603 -1.834l.5 -.064a17.27 17.27 0 0 1 1.897 -.102c.663 0 1.3 .036 1.896 .102l.5 .064c2.123 .308 3.604 1.013 3.604 1.834c0 .82 -1.482 1.526 -3.603 1.834l-.5 .064a17.27 17.27 0 0 1 -1.897 .102\" />"),
    LAMP(
        "lamp",
        "<path d=\"M9 20h6\" />\n  <path d=\"M12 20v-8\" />\n  <path d=\"M5 12h14l-4 -8h-6l-4 8\" />"),
    LAMP_2(
        "lamp-2",
        "<path d=\"M5 21h9\" />\n  <path d=\"M10 21l-7 -8l8.5 -5.5\" />\n  <path d=\"M13 14c-2.148 -2.148 -2.148 -5.852 0 -8c2.088 -2.088 5.842 -1.972 8 0l-8 8\" />\n  <path d=\"M11.742 7.574l-1.156 -1.156a2 2 0 0 1 2.828 -2.829l1.144 1.144\" />\n  <path d=\"M15.5 12l.208 .274a2.527 2.527 0 0 0 3.556 0c.939 -.933 .98 -2.42 .122 -3.4l-.366 -.369\" />"),
    LAMP_OFF(
        "lamp-off",
        "<path d=\"M9 20h6\" />\n  <path d=\"M12 20v-8\" />\n  <path d=\"M7.325 7.35l-2.325 4.65h7m4 0h3l-4 -8h-6l-.338 .676\" />\n  <path d=\"M3 3l18 18\" />"),
    LASSO(
        "lasso",
        "<path d=\"M4.028 13.252c-.657 -.972 -1.028 -2.078 -1.028 -3.252c0 -3.866 4.03 -7 9 -7s9 3.134 9 7s-4.03 7 -9 7c-1.913 0 -3.686 -.464 -5.144 -1.255\" />\n  <path d=\"M3 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 17c0 1.42 .316 2.805 1 4\" />"),
    LASSO_OFF(
        "lasso-off",
        "<path d=\"M4.028 13.252c-.657 -.972 -1.028 -2.078 -1.028 -3.252c0 -1.804 .878 -3.449 2.319 -4.69m2.49 -1.506a11.066 11.066 0 0 1 4.191 -.804c4.97 0 9 3.134 9 7c0 1.799 -.873 3.44 -2.307 4.68m-2.503 1.517a11.066 11.066 0 0 1 -4.19 .803c-1.913 0 -3.686 -.464 -5.144 -1.255\" />\n  <path d=\"M3 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 17c0 1.42 .316 2.805 1 4\" />\n  <path d=\"M3 3l18 18\" />"),
    LASSO_POLYGON(
        "lasso-polygon",
        "<path d=\"M4.028 13.252l-1.028 -3.252l2 -7l7 5l8 -3l1 9l-9 3l-5.144 -1.255\" />\n  <path d=\"M3 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 17c0 1.42 .316 2.805 1 4\" />"),
    LAUREL_WREATH(
        "laurel-wreath",
        "<path d=\"M6.436 8a8.6 8.6 0 0 0 -.436 2.727c0 4.017 2.686 7.273 6 7.273s6 -3.256 6 -7.273a8.6 8.6 0 0 0 -.436 -2.727\" />\n  <path d=\"M14.5 21s-.682 -3 -2.5 -3s-2.5 3 -2.5 3\" />\n  <path d=\"M18.52 5.23c.292 1.666 -1.02 2.77 -1.02 2.77s-1.603 -.563 -1.895 -2.23c-.292 -1.666 1.02 -2.77 1.02 -2.77s1.603 .563 1.895 2.23\" />\n  <path d=\"M21.094 12.14c-1.281 1.266 -3.016 .76 -3.016 .76s-.454 -1.772 .828 -3.04c1.28 -1.266 3.016 -.76 3.016 -.76s.454 1.772 -.828 3.04\" />\n  <path d=\"M17.734 18.826c-1.5 -.575 -1.734 -2.19 -1.734 -2.19s1.267 -1.038 2.767 -.462c1.5 .575 1.733 2.19 1.733 2.19s-1.267 1.038 -2.767 .462\" />\n  <path d=\"M6.267 18.826c1.5 -.575 1.733 -2.19 1.733 -2.19s-1.267 -1.038 -2.767 -.462c-1.5 .575 -1.733 2.19 -1.733 2.19s1.267 1.038 2.767 .462\" />\n  <path d=\"M2.906 12.14c1.281 1.266 3.016 .76 3.016 .76s.454 -1.772 -.828 -3.04c-1.281 -1.265 -3.016 -.76 -3.016 -.76s-.454 1.772 .828 3.04\" />\n  <path d=\"M5.48 5.23c-.292 1.666 1.02 2.77 1.02 2.77s1.603 -.563 1.895 -2.23c.292 -1.666 -1.02 -2.77 -1.02 -2.77s-1.603 .563 -1.895 2.23\" />"),
    LAUREL_WREATH_1(
        "laurel-wreath-1",
        "<path d=\"M6.436 8a8.6 8.6 0 0 0 -.436 2.727c0 4.017 2.686 7.273 6 7.273s6 -3.256 6 -7.273a8.6 8.6 0 0 0 -.436 -2.727\" />\n  <path d=\"M14.5 21s-.682 -3 -2.5 -3s-2.5 3 -2.5 3\" />\n  <path d=\"M18.52 5.23c.292 1.666 -1.02 2.77 -1.02 2.77s-1.603 -.563 -1.895 -2.23c-.292 -1.666 1.02 -2.77 1.02 -2.77s1.603 .563 1.895 2.23\" />\n  <path d=\"M21.094 12.14c-1.281 1.266 -3.016 .76 -3.016 .76s-.454 -1.772 .828 -3.04c1.28 -1.266 3.016 -.76 3.016 -.76s.454 1.772 -.828 3.04\" />\n  <path d=\"M17.734 18.826c-1.5 -.575 -1.734 -2.19 -1.734 -2.19s1.267 -1.038 2.767 -.462c1.5 .575 1.733 2.19 1.733 2.19s-1.267 1.038 -2.767 .462\" />\n  <path d=\"M6.267 18.826c1.5 -.575 1.733 -2.19 1.733 -2.19s-1.267 -1.038 -2.767 -.462c-1.5 .575 -1.733 2.19 -1.733 2.19s1.267 1.038 2.767 .462\" />\n  <path d=\"M2.906 12.14c1.281 1.266 3.016 .76 3.016 .76s.454 -1.772 -.828 -3.04c-1.281 -1.265 -3.016 -.76 -3.016 -.76s-.454 1.772 .828 3.04\" />\n  <path d=\"M5.48 5.23c-.292 1.666 1.02 2.77 1.02 2.77s1.603 -.563 1.895 -2.23c.292 -1.666 -1.02 -2.77 -1.02 -2.77s-1.603 .563 -1.895 2.23\" />\n  <path d=\"M11 9l1 -1v6\" />"),
    LAUREL_WREATH_2(
        "laurel-wreath-2",
        "<path d=\"M6.436 8a8.6 8.6 0 0 0 -.436 2.727c0 4.017 2.686 7.273 6 7.273s6 -3.256 6 -7.273a8.6 8.6 0 0 0 -.436 -2.727\" />\n  <path d=\"M14.5 21s-.682 -3 -2.5 -3s-2.5 3 -2.5 3\" />\n  <path d=\"M18.52 5.23c.292 1.666 -1.02 2.77 -1.02 2.77s-1.603 -.563 -1.895 -2.23c-.292 -1.666 1.02 -2.77 1.02 -2.77s1.603 .563 1.895 2.23\" />\n  <path d=\"M21.094 12.14c-1.281 1.266 -3.016 .76 -3.016 .76s-.454 -1.772 .828 -3.04c1.28 -1.266 3.016 -.76 3.016 -.76s.454 1.772 -.828 3.04\" />\n  <path d=\"M17.734 18.826c-1.5 -.575 -1.734 -2.19 -1.734 -2.19s1.267 -1.038 2.767 -.462c1.5 .575 1.733 2.19 1.733 2.19s-1.267 1.038 -2.767 .462\" />\n  <path d=\"M6.267 18.826c1.5 -.575 1.733 -2.19 1.733 -2.19s-1.267 -1.038 -2.767 -.462c-1.5 .575 -1.733 2.19 -1.733 2.19s1.267 1.038 2.767 .462\" />\n  <path d=\"M2.906 12.14c1.281 1.266 3.016 .76 3.016 .76s.454 -1.772 -.828 -3.04c-1.281 -1.265 -3.016 -.76 -3.016 -.76s-.454 1.772 .828 3.04\" />\n  <path d=\"M5.48 5.23c-.292 1.666 1.02 2.77 1.02 2.77s1.603 -.563 1.895 -2.23c.292 -1.666 -1.02 -2.77 -1.02 -2.77s-1.603 .563 -1.895 2.23\" />\n  <path d=\"M10.6 8h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />"),
    LAUREL_WREATH_3(
        "laurel-wreath-3",
        "<path d=\"M6.436 8a8.6 8.6 0 0 0 -.436 2.727c0 4.017 2.686 7.273 6 7.273s6 -3.256 6 -7.273a8.6 8.6 0 0 0 -.436 -2.727\" />\n  <path d=\"M14.5 21s-.682 -3 -2.5 -3s-2.5 3 -2.5 3\" />\n  <path d=\"M18.52 5.23c.292 1.666 -1.02 2.77 -1.02 2.77s-1.603 -.563 -1.895 -2.23c-.292 -1.666 1.02 -2.77 1.02 -2.77s1.603 .563 1.895 2.23\" />\n  <path d=\"M21.094 12.14c-1.281 1.266 -3.016 .76 -3.016 .76s-.454 -1.772 .828 -3.04c1.28 -1.266 3.016 -.76 3.016 -.76s.454 1.772 -.828 3.04\" />\n  <path d=\"M17.734 18.826c-1.5 -.575 -1.734 -2.19 -1.734 -2.19s1.267 -1.038 2.767 -.462c1.5 .575 1.733 2.19 1.733 2.19s-1.267 1.038 -2.767 .462\" />\n  <path d=\"M6.267 18.826c1.5 -.575 1.733 -2.19 1.733 -2.19s-1.267 -1.038 -2.767 -.462c-1.5 .575 -1.733 2.19 -1.733 2.19s1.267 1.038 2.767 .462\" />\n  <path d=\"M2.906 12.14c1.281 1.266 3.016 .76 3.016 .76s.454 -1.772 -.828 -3.04c-1.281 -1.265 -3.016 -.76 -3.016 -.76s-.454 1.772 .828 3.04\" />\n  <path d=\"M5.48 5.23c-.292 1.666 1.02 2.77 1.02 2.77s1.603 -.563 1.895 -2.23c.292 -1.666 -1.02 -2.77 -1.02 -2.77s-1.603 .563 -1.895 2.23\" />\n  <path d=\"M10.5 8h1.5a1.5 1.5 0 0 1 0 3h-1h1a1.5 1.5 0 0 1 0 3h-1.5\" />"),
    LAYERS_DIFFERENCE(
        "layers-difference",
        "<path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2v-2a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2\" />\n  <path d=\"M10 8l-2 0l0 2\" />\n  <path d=\"M8 14l0 2l2 0\" />\n  <path d=\"M14 8l2 0l0 2\" />\n  <path d=\"M16 14l0 2l-2 0\" />"),
    LAYERS_INTERSECT(
        "layers-intersect",
        "<path d=\"M8 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M4 10a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />"),
    LAYERS_INTERSECT_2(
        "layers-intersect-2",
        "<path d=\"M8 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M4 10a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M9 15l6 -6\" />"),
    LAYERS_LINKED(
        "layers-linked",
        "<path d=\"M19 8.268a2 2 0 0 1 1 1.732v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h3\" />\n  <path d=\"M5 15.734a2 2 0 0 1 -1 -1.734v-8a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-3\" />"),
    LAYERS_OFF(
        "layers-off",
        "<path d=\"M8.59 4.581c.362 -.359 .86 -.581 1.41 -.581h8a2 2 0 0 1 2 2v8c0 .556 -.227 1.06 -.594 1.422m-3.406 .578h-6a2 2 0 0 1 -2 -2v-6\" />\n  <path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 3l18 18\" />"),
    LAYERS_SELECTED(
        "layers-selected",
        "<path d=\"M8 10.5l6.492 -6.492\" />\n  <path d=\"M13.496 16l6.504 -6.504l-6.504 6.504\" />\n  <path d=\"M8.586 15.414l10.827 -10.827\" />\n  <path d=\"M8 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2\" />"),
    LAYERS_SELECTED_BOTTOM(
        "layers-selected-bottom",
        "<path d=\"M4 14.5l4 -4\" />\n  <path d=\"M9.496 20l4.004 -4l-4.004 4\" />\n  <path d=\"M4.586 19.414l3.914 -3.914\" />\n  <path d=\"M8 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2\" />"),
    LAYERS_SUBTRACT(
        "layers-subtract",
        "<path d=\"M8 6a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2\" />"),
    LAYERS_UNION(
        "layers-union",
        "<path d=\"M16 16v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2v-2a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2\" />"),
    LAYOUT(
        "layout",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -1\" />\n  <path d=\"M4 15a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M14 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -12\" />"),
    LAYOUT_2(
        "layout-2",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -1\" />\n  <path d=\"M4 15a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M14 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M14 17a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -1\" />"),
    LAYOUT_ALIGN_BOTTOM(
        "layout-align-bottom",
        "<path d=\"M4 20l16 0\" />\n  <path d=\"M9 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -8\" />"),
    LAYOUT_ALIGN_CENTER(
        "layout-align-center",
        "<path d=\"M12 4l0 5\" />\n  <path d=\"M12 15l0 5\" />\n  <path d=\"M6 11a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_ALIGN_LEFT(
        "layout-align-left",
        "<path d=\"M4 4l0 16\" />\n  <path d=\"M8 11a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_ALIGN_MIDDLE(
        "layout-align-middle",
        "<path d=\"M4 12l5 0\" />\n  <path d=\"M15 12l5 0\" />\n  <path d=\"M9 8a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -8\" />"),
    LAYOUT_ALIGN_RIGHT(
        "layout-align-right",
        "<path d=\"M20 4l0 16\" />\n  <path d=\"M4 11a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_ALIGN_TOP(
        "layout-align-top",
        "<path d=\"M4 4l16 0\" />\n  <path d=\"M9 10a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -8\" />"),
    LAYOUT_BOARD(
        "layout-board",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 9h8\" />\n  <path d=\"M12 15h8\" />\n  <path d=\"M12 4v16\" />"),
    LAYOUT_BOARD_SPLIT(
        "layout-board-split",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M12 15h8\" />\n  <path d=\"M12 9h8\" />\n  <path d=\"M12 4v16\" />"),
    LAYOUT_BOTTOMBAR(
        "layout-bottombar",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 15l16 0\" />"),
    LAYOUT_BOTTOMBAR_COLLAPSE(
        "layout-bottombar-collapse",
        "<path d=\"M20 6v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2\" />\n  <path d=\"M20 15h-16\" />\n  <path d=\"M14 8l-2 2l-2 -2\" />"),
    LAYOUT_BOTTOMBAR_EXPAND(
        "layout-bottombar-expand",
        "<path d=\"M20 6v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2\" />\n  <path d=\"M20 15h-16\" />\n  <path d=\"M14 10l-2 -2l-2 2\" />"),
    LAYOUT_CARDS(
        "layout-cards",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M14 6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -6\" />"),
    LAYOUT_COLLAGE(
        "layout-collage",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M10 4l4 16\" />\n  <path d=\"M12 12l-8 2\" />"),
    LAYOUT_COLUMNS(
        "layout-columns",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M12 4l0 16\" />"),
    LAYOUT_DASHBOARD(
        "layout-dashboard",
        "<path d=\"M5 4h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-6a1 1 0 0 1 1 -1\" />\n  <path d=\"M5 16h4a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M15 12h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-6a1 1 0 0 1 1 -1\" />\n  <path d=\"M15 4h4a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />"),
    LAYOUT_DISTRIBUTE_HORIZONTAL(
        "layout-distribute-horizontal",
        "<path d=\"M4 4l16 0\" />\n  <path d=\"M4 20l16 0\" />\n  <path d=\"M6 11a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_DISTRIBUTE_VERTICAL(
        "layout-distribute-vertical",
        "<path d=\"M4 4l0 16\" />\n  <path d=\"M20 4l0 16\" />\n  <path d=\"M9 8a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -8\" />"),
    LAYOUT_GRID(
        "layout-grid",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M14 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />"),
    LAYOUT_GRID_ADD(
        "layout-grid-add",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M14 17h6m-3 -3v6\" />"),
    LAYOUT_GRID_REMOVE(
        "layout-grid-remove",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M4 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M14 17h6\" />"),
    LAYOUT_KANBAN(
        "layout-kanban",
        "<path d=\"M4 4l6 0\" />\n  <path d=\"M14 4l6 0\" />\n  <path d=\"M4 10a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M14 10a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -2\" />\n  <path d=\"M4 16a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -2\" />"),
    LAYOUT_NAVBAR(
        "layout-navbar",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 9l16 0\" />"),
    LAYOUT_NAVBAR_COLLAPSE(
        "layout-navbar-collapse",
        "<path d=\"M4 18v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2\" />\n  <path d=\"M4 9h16\" />\n  <path d=\"M10 16l2 -2l2 2\" />"),
    LAYOUT_NAVBAR_EXPAND(
        "layout-navbar-expand",
        "<path d=\"M4 18v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2\" />\n  <path d=\"M4 9h16\" />\n  <path d=\"M10 14l2 2l2 -2\" />"),
    LAYOUT_OFF(
        "layout-off",
        "<path d=\"M8 4a2 2 0 0 1 2 2m-1.162 2.816a1.993 1.993 0 0 1 -.838 .184h-2a2 2 0 0 1 -2 -2v-1c0 -.549 .221 -1.046 .58 -1.407\" />\n  <path d=\"M4 15a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M14 10v-4a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v10m-.595 3.423a2 2 0 0 1 -1.405 .577h-2a2 2 0 0 1 -2 -2v-4\" />\n  <path d=\"M3 3l18 18\" />"),
    LAYOUT_ROWS(
        "layout-rows",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 12l16 0\" />"),
    LAYOUT_SIDEBAR(
        "layout-sidebar",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M9 4l0 16\" />"),
    LAYOUT_SIDEBAR_LEFT_COLLAPSE(
        "layout-sidebar-left-collapse",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M9 4v16\" />\n  <path d=\"M15 10l-2 2l2 2\" />"),
    LAYOUT_SIDEBAR_LEFT_EXPAND(
        "layout-sidebar-left-expand",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M9 4v16\" />\n  <path d=\"M14 10l2 2l-2 2\" />"),
    LAYOUT_SIDEBAR_RIGHT(
        "layout-sidebar-right",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M15 4l0 16\" />"),
    LAYOUT_SIDEBAR_RIGHT_COLLAPSE(
        "layout-sidebar-right-collapse",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M15 4v16\" />\n  <path d=\"M9 10l2 2l-2 2\" />"),
    LAYOUT_SIDEBAR_RIGHT_EXPAND(
        "layout-sidebar-right-expand",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M15 4v16\" />\n  <path d=\"M10 10l-2 2l2 2\" />"),
    LINE(
        "line",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7.5 16.5l9 -9\" />"),
    LINE_DASHED(
        "line-dashed",
        "<path d=\"M5 12h2\" />\n  <path d=\"M17 12h2\" />\n  <path d=\"M11 12h2\" />"),
    LINE_DOTTED(
        "line-dotted",
        "<path d=\"M4 12v.01\" />\n  <path d=\"M8 12v.01\" />\n  <path d=\"M12 12v.01\" />\n  <path d=\"M16 12v.01\" />\n  <path d=\"M20 12v.01\" />"),
    MAGNET(
        "magnet",
        "<path d=\"M4 13v-8a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v8a2 2 0 0 0 6 0v-8a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v8a8 8 0 0 1 -16 0\" />\n  <path d=\"M4 8l5 0\" />\n  <path d=\"M15 8l4 0\" />"),
    MAGNET_OFF(
        "magnet-off",
        "<path d=\"M7 3a2 2 0 0 1 2 2m0 4v4a3 3 0 0 0 5.552 1.578m.448 -3.578v-6a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v8a7.99 7.99 0 0 1 -.424 2.577m-1.463 2.584a8 8 0 0 1 -14.113 -5.161v-8c0 -.297 .065 -.58 .181 -.833\" />\n  <path d=\"M4 8h4\" />\n  <path d=\"M15 8h4\" />\n  <path d=\"M3 3l18 18\" />"),
    MAGNETIC(
        "magnetic",
        "<path d=\"M12 3v18\" />\n  <path d=\"M18 7c-.633 -1.255 -1.538 -2 -2.5 -2c-1.933 0 -3.5 3.134 -3.5 7s1.567 7 3.5 7s3.5 -3.134 3.5 -7v-1\" />\n  <path d=\"M6 7c.633 -1.255 1.538 -2 2.5 -2c1.933 0 3.5 3.134 3.5 7s-1.567 7 -3.5 7s-3.5 -3.134 -3.5 -7v-1\" />\n  <path d=\"M3 13l2 -2l2 2\" />\n  <path d=\"M17 13l2 -2l2 2\" />"),
    MASK(
        "mask",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />"),
    MASK_OFF(
        "mask-off",
        "<path d=\"M19.42 19.41a2 2 0 0 1 -1.42 .59h-12a2 2 0 0 1 -2 -2v-12c0 -.554 .225 -1.055 .588 -1.417m3.412 -.583h10a2 2 0 0 1 2 2v10\" />\n  <path d=\"M9.885 9.872a3 3 0 1 0 4.245 4.24m.582 -3.396a3.012 3.012 0 0 0 -1.438 -1.433\" />\n  <path d=\"M3 3l18 18\" />"),
    MESH(
        "mesh",
        "<path d=\"M3 9h18\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M8 4c.485 .445 3.5 3.312 3.5 8c0 .663 -.07 4.848 -3.5 8\" />\n  <path d=\"M15 4a17 17 0 0 1 2.004 8c0 1.51 -.201 4.628 -2.004 8\" />\n  <path d=\"M18.778 20h-13.556a2.22 2.22 0 0 1 -2.222 -2.222v-11.556c0 -1.227 .995 -2.222 2.222 -2.222h13.556c1.227 0 2.222 .995 2.222 2.222v11.556a2.22 2.22 0 0 1 -2.222 2.222\" />"),
    MICKEY(
        "mickey",
        "<path d=\"M5.5 3a3.5 3.5 0 0 1 3.25 4.8a7.017 7.017 0 0 0 -2.424 2.1a3.5 3.5 0 1 1 -.826 -6.9\" />\n  <path d=\"M18.5 3a3.5 3.5 0 1 1 -.826 6.902a7.013 7.013 0 0 0 -2.424 -2.103a3.5 3.5 0 0 1 3.25 -4.799\" />\n  <path d=\"M5 14a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />"),
    MOUSTACHE(
        "moustache",
        "<path d=\"M15 9a3 3 0 0 1 2.599 1.5c.933 1.333 2.133 1.556 3.126 1.556l.291 0l.77 -.044l.213 0c-.963 1.926 -3.163 2.925 -6.6 3l-.4 0l-.165 0a3 3 0 0 1 .165 -6l.001 -.012\" />\n  <path d=\"M9 9a3 3 0 0 0 -2.599 1.5c-.933 1.333 -2.133 1.556 -3.126 1.556l-.291 0l-.77 -.044l-.213 0c.963 1.926 3.163 2.925 6.6 3l.4 0l.165 0a3 3 0 0 0 -.165 -6l-.001 -.012\" />"),
    NEEDLE(
        "needle",
        "<path d=\"M3 21c-.667 -.667 3.262 -6.236 11.785 -16.709a3.5 3.5 0 1 1 5.078 4.791c-10.575 8.612 -16.196 12.585 -16.863 11.918\" />\n  <path d=\"M17.5 6.5l-1 1\" />"),
    NEEDLE_THREAD(
        "needle-thread",
        "<path d=\"M3 21c-.667 -.667 3.262 -6.236 11.785 -16.709a3.5 3.5 0 1 1 5.078 4.791c-10.575 8.612 -16.196 12.585 -16.863 11.918\" />\n  <path d=\"M17.5 6.5l-1 1\" />\n  <path d=\"M17 7c-2.333 -2.667 -3.5 -4 -5 -4s-2 1 -2 2c0 4 8.161 8.406 6 11c-1.056 1.268 -3.363 1.285 -5.75 .808\" />\n  <path d=\"M5.739 15.425c-1.393 -.565 -3.739 -1.925 -3.739 -3.425\" />\n  <path d=\"M19.5 9.5l1.5 1.5\" />"),
    NOISE_REDUCTION(
        "noise-reduction",
        "<path d=\"M21 12a9 9 0 1 1 -18 0a9 9 0 0 1 18 0\" />\n  <path d=\"M10.01 18h-.01\" />\n  <path d=\"M14.01 14h-.01\" />\n  <path d=\"M16.01 12h-.01\" />\n  <path d=\"M18.01 10h-.01\" />\n  <path d=\"M16.01 16h-.01\" />\n  <path d=\"M14.01 18h-.01\" />\n  <path d=\"M18.01 14h-.01\" />\n  <path d=\"M12.01 16h-.01\" />"),
    PAINT(
        "paint",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -2\" />\n  <path d=\"M19 6h1a2 2 0 0 1 2 2a5 5 0 0 1 -5 5l-5 0v2\" />\n  <path d=\"M10 16a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -4\" />"),
    PAINT_OFF(
        "paint-off",
        "<path d=\"M7 3h10a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-4m-4 0h-2a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M19 6h1a2 2 0 0 1 2 2a5 5 0 0 1 -5 5m-4 0h-1v2\" />\n  <path d=\"M10 16a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    PALETTE(
        "palette",
        "<path d=\"M12 21a9 9 0 0 1 0 -18c4.97 0 9 3.582 9 8c0 1.06 -.474 2.078 -1.318 2.828c-.844 .75 -1.989 1.172 -3.182 1.172h-2.5a2 2 0 0 0 -1 3.75a1.3 1.3 0 0 1 -1 2.25\" />\n  <path d=\"M7.5 10.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11.5 7.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M15.5 10.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    PALETTE_OFF(
        "palette-off",
        "<path d=\"M15 15h-1a2 2 0 0 0 -1 3.75a1.3 1.3 0 0 1 -1 2.25a9 9 0 0 1 -6.372 -15.356\" />\n  <path d=\"M8 4c1.236 -.623 2.569 -1 4 -1c4.97 0 9 3.582 9 8c0 1.06 -.474 2.078 -1.318 2.828a4.516 4.516 0 0 1 -1.127 .73\" />\n  <path d=\"M7.5 10.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11.5 7.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M15.5 10.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3 3l18 18\" />"),
    PENCIL(
        "pencil",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />"),
    PENCIL_AI(
        "pencil-ai",
        "<path d=\"M17.013 10.987l1.487 -1.487a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4h4l2 -2\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    PENCIL_BOLT(
        "pencil-bolt",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    PENCIL_CANCEL(
        "pencil-cancel",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    PENCIL_CHECK(
        "pencil-check",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    PENCIL_CODE(
        "pencil-code",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    PENCIL_COG(
        "pencil-cog",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    PENCIL_DISCOUNT(
        "pencil-discount",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    PENCIL_DOLLAR(
        "pencil-dollar",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    PENCIL_DOWN(
        "pencil-down",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    PENCIL_EXCLAMATION(
        "pencil-exclamation",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    PENCIL_HEART(
        "pencil-heart",
        "<path d=\"M17 11l1.5 -1.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4h4l2 -2\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    PENCIL_MINUS(
        "pencil-minus",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M16 19h6\" />"),
    PENCIL_OFF(
        "pencil-off",
        "<path d=\"M10 10l-6 6v4h4l6 -6m1.99 -1.99l2.504 -2.504a2.828 2.828 0 1 0 -4 -4l-2.5 2.5\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M3 3l18 18\" />"),
    PENCIL_PAUSE(
        "pencil-pause",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    PENCIL_PIN(
        "pencil-pin",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    PENCIL_PLUS(
        "pencil-plus",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    PENCIL_QUESTION(
        "pencil-question",
        "<path d=\"M8 20l6 -6l3 -3l1.5 -1.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4h4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    PENCIL_SEARCH(
        "pencil-search",
        "<path d=\"M17 11l1.5 -1.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4h4l3 -3\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    PENCIL_SHARE(
        "pencil-share",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    PENCIL_STAR(
        "pencil-star",
        "<path d=\"M17.5 10.5l1 -1a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4h4l2 -2\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    PENCIL_UP(
        "pencil-up",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    PENCIL_X(
        "pencil-x",
        "<path d=\"M4 20h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M13.5 6.5l4 4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    PENTAGRAM(
        "pentagram",
        "<path d=\"M5.636 5.636a9 9 0 1 1 12.728 12.728a9 9 0 0 1 -12.728 -12.728\" />\n  <path d=\"M15.236 11l5.264 4h-6.5l-2 6l-2 -6h-6.5l5.276 -4l-2.056 -6.28l5.28 3.78l5.28 -3.78l-2.044 6.28\" />"),
    PLACEHOLDER(
        "placeholder",
        "<path d=\"M10 20.415a8 8 0 1 0 3 -15.415h-3\" />\n  <path d=\"M13 8l-3 -3l3 -3\" />\n  <path d=\"M7 17l4 -4l-4 -4l-4 4l4 4\" />"),
    POLYGON(
        "polygon",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 11a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M13 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6.5 9.5l3.5 -3\" />\n  <path d=\"M14 5.5l3 1.5\" />\n  <path d=\"M18.5 10l-2.5 7\" />\n  <path d=\"M13.5 17.5l-7 -5\" />"),
    POLYGON_OFF(
        "polygon-off",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 11a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M13 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6.5 9.5l1.546 -1.311\" />\n  <path d=\"M14 5.5l3 1.5\" />\n  <path d=\"M18.5 10l-1.185 3.318m-1.062 2.972l-.253 .71\" />\n  <path d=\"M13.5 17.5l-7 -5\" />\n  <path d=\"M3 3l18 18\" />"),
    PRONG(
        "prong",
        "<path d=\"M10.2 10.2l6.3 6.3\" />\n  <path d=\"M19.347 16.575l1.08 1.079a1.96 1.96 0 0 1 -2.773 2.772l-1.08 -1.079a1.96 1.96 0 0 1 2.773 -2.772\" />\n  <path d=\"M3 7l3.05 3.15a2.9 2.9 0 0 0 4.1 -4.1l-3.15 -3.05\" />"),
    RADIUS_BOTTOM_LEFT("radius-bottom-left", "<path d=\"M19 19h-6a8 8 0 0 1 -8 -8v-6\" />"),
    RADIUS_BOTTOM_RIGHT("radius-bottom-right", "<path d=\"M19 5v6a8 8 0 0 1 -8 8h-6\" />"),
    RADIUS_TOP_LEFT("radius-top-left", "<path d=\"M5 19v-6a8 8 0 0 1 8 -8h6\" />"),
    RADIUS_TOP_RIGHT("radius-top-right", "<path d=\"M5 5h6a8 8 0 0 1 8 8v6\" />"),
    REFERENCE_IMAGE(
        "reference-image",
        "<path d=\"M14.121 9.879l4.95 4.95\" />\n  <path d=\"M5 7.2a2.2 2.2 0 0 1 2.2 -2.2h1a2.2 2.2 0 0 0 1.55 -.64l.7 -.7a2.2 2.2 0 0 1 3.12 0l.7 .7c.412 .41 .97 .64 1.55 .64h1a2.2 2.2 0 0 1 2.2 2.2v1c0 .58 .23 1.138 .64 1.55l.7 .7a2.2 2.2 0 0 1 0 3.12l-.7 .7a2.2 2.2 0 0 0 -.64 1.55v1a2.2 2.2 0 0 1 -2.2 2.2h-1a2.2 2.2 0 0 0 -1.55 .64l-.7 .7a2.2 2.2 0 0 1 -3.12 0l-.7 -.7a2.2 2.2 0 0 0 -1.55 -.64h-1a2.2 2.2 0 0 1 -2.2 -2.2v-1a2.2 2.2 0 0 0 -.64 -1.55l-.7 -.7a2.2 2.2 0 0 1 0 -3.12l.7 -.7a2.2 2.2 0 0 0 .64 -1.55v-1\" />\n  <path d=\"M5 15h7\" />\n  <path d=\"M12 9h7\" />\n  <path d=\"M9.172 19.071l4.95 -4.949\" />\n  <path d=\"M9.879 9.879l4.95 -4.95\" />\n  <path d=\"M9 5v7\" />\n  <path d=\"M15 12v7\" />\n  <path d=\"M4.93 9.172l4.949 4.95\" />\n  <path d=\"M15 12a3 3 0 1 1 -6 0a3 3 0 0 1 6 0\" />"),
    RESIZE(
        "resize",
        "<path d=\"M4 11v8a1 1 0 0 0 1 1h8m-9 -14v-1a1 1 0 0 1 1 -1h1m5 0h2m5 0h1a1 1 0 0 1 1 1v1m0 5v2m0 5v1a1 1 0 0 1 -1 1h-1\" />\n  <path d=\"M4 12h7a1 1 0 0 1 1 1v7\" />"),
    RULER(
        "ruler",
        "<path d=\"M5 4h14a1 1 0 0 1 1 1v5a1 1 0 0 1 -1 1h-7a1 1 0 0 0 -1 1v7a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 8l2 0\" />\n  <path d=\"M4 12l3 0\" />\n  <path d=\"M4 16l2 0\" />\n  <path d=\"M8 4l0 2\" />\n  <path d=\"M12 4l0 3\" />\n  <path d=\"M16 4l0 2\" />"),
    RULER_2(
        "ruler-2",
        "<path d=\"M17 3l4 4l-14 14l-4 -4l14 -14\" />\n  <path d=\"M16 7l-1.5 -1.5\" />\n  <path d=\"M13 10l-1.5 -1.5\" />\n  <path d=\"M10 13l-1.5 -1.5\" />\n  <path d=\"M7 16l-1.5 -1.5\" />"),
    RULER_2_OFF(
        "ruler-2-off",
        "<path d=\"M12.03 7.97l4.97 -4.97l4 4l-5 5m-2 2l-7 7l-4 -4l7 -7\" />\n  <path d=\"M16 7l-1.5 -1.5\" />\n  <path d=\"M10 13l-1.5 -1.5\" />\n  <path d=\"M7 16l-1.5 -1.5\" />\n  <path d=\"M3 3l18 18\" />"),
    RULER_3(
        "ruler-3",
        "<path d=\"M19.875 8c.621 0 1.125 .512 1.125 1.143v5.714c0 .631 -.504 1.143 -1.125 1.143h-15.875a1 1 0 0 1 -1 -1v-5.857c0 -.631 .504 -1.143 1.125 -1.143h15.75\" />\n  <path d=\"M9 8v2\" />\n  <path d=\"M6 8v3\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"M18 8v3\" />\n  <path d=\"M15 8v2\" />"),
    RULER_MEASURE(
        "ruler-measure",
        "<path d=\"M19.875 12c.621 0 1.125 .512 1.125 1.143v5.714c0 .631 -.504 1.143 -1.125 1.143h-15.875a1 1 0 0 1 -1 -1v-5.857c0 -.631 .504 -1.143 1.125 -1.143h15.75\" />\n  <path d=\"M9 12v2\" />\n  <path d=\"M6 12v3\" />\n  <path d=\"M12 12v3\" />\n  <path d=\"M18 12v3\" />\n  <path d=\"M15 12v2\" />\n  <path d=\"M3 3v4\" />\n  <path d=\"M3 5h18\" />\n  <path d=\"M21 3v4\" />"),
    RULER_MEASURE_2(
        "ruler-measure-2",
        "<path d=\"M12 19.875c0 .621 -.512 1.125 -1.143 1.125h-5.714a1.134 1.134 0 0 1 -1.143 -1.125v-15.875a1 1 0 0 1 1 -1h5.857c.631 0 1.143 .504 1.143 1.125l0 15.75\" />\n  <path d=\"M12 9h-2\" />\n  <path d=\"M12 6h-3\" />\n  <path d=\"M12 12h-3\" />\n  <path d=\"M12 18h-3\" />\n  <path d=\"M12 15h-2\" />\n  <path d=\"M21 3h-4\" />\n  <path d=\"M19 3v18\" />\n  <path d=\"M21 21h-4\" />"),
    RULER_OFF(
        "ruler-off",
        "<path d=\"M8 4h11a1 1 0 0 1 1 1v5a1 1 0 0 1 -1 1h-4m-3.713 .299a1 1 0 0 0 -.287 .701v7a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1v-14c0 -.284 .118 -.54 .308 -.722\" />\n  <path d=\"M4 8h2\" />\n  <path d=\"M4 12h3\" />\n  <path d=\"M4 16h2\" />\n  <path d=\"M12 4v3\" />\n  <path d=\"M16 4v2\" />\n  <path d=\"M3 3l18 18\" />"),
    SCISSORS(
        "scissors",
        "<path d=\"M3 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8.6 8.6l10.4 10.4\" />\n  <path d=\"M8.6 15.4l10.4 -10.4\" />"),
    SCISSORS_OFF(
        "scissors-off",
        "<path d=\"M4.432 4.442a3 3 0 1 0 4.114 4.146\" />\n  <path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8.6 15.4l3.4 -3.4m2 -2l5 -5\" />\n  <path d=\"M3 3l18 18\" />"),
    SECTION(
        "section",
        "<path d=\"M20 20h.01\" />\n  <path d=\"M4 20h.01\" />\n  <path d=\"M8 20h.01\" />\n  <path d=\"M12 20h.01\" />\n  <path d=\"M16 20h.01\" />\n  <path d=\"M20 4h.01\" />\n  <path d=\"M4 4h.01\" />\n  <path d=\"M8 4h.01\" />\n  <path d=\"M12 4h.01\" />\n  <path d=\"M16 4l0 .01\" />\n  <path d=\"M4 9a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -6\" />"),
    SHAPE(
        "shape",
        "<path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 7l0 10\" />\n  <path d=\"M7 5l10 0\" />\n  <path d=\"M7 19l10 0\" />\n  <path d=\"M19 7l0 10\" />"),
    SHAPE_2(
        "shape-2",
        "<path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6.5 17.5l11 -11m-12.5 .5v10m14 -10v10\" />"),
    SHAPE_3(
        "shape-3",
        "<path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 5h10m-12 2v10m14 -10v10\" />"),
    SHAPE_OFF(
        "shape-off",
        "<path d=\"M3.575 3.597a2 2 0 0 0 2.849 2.808\" />\n  <path d=\"M17 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17.574 17.598a2 2 0 0 0 2.826 2.83\" />\n  <path d=\"M5 7v10\" />\n  <path d=\"M9 5h8\" />\n  <path d=\"M7 19h10\" />\n  <path d=\"M19 7v8\" />\n  <path d=\"M3 3l18 18\" />"),
    SHOVEL(
        "shovel",
        "<path d=\"M17 4l3 3\" />\n  <path d=\"M18.5 5.5l-8 8\" />\n  <path d=\"M8.276 11.284l4.44 4.44a.968 .968 0 0 1 0 1.369l-2.704 2.704a4.108 4.108 0 0 1 -5.809 -5.81l2.704 -2.703a.968 .968 0 0 1 1.37 0l-.001 0\" />"),
    SHOVEL_PITCHFORKS(
        "shovel-pitchforks",
        "<path d=\"M5 3h4\" />\n  <path d=\"M7 3v12\" />\n  <path d=\"M4 15h6v3a3 3 0 0 1 -6 0v-3\" />\n  <path d=\"M14 21v-3a3 3 0 0 1 6 0v3\" />\n  <path d=\"M17 21v-18\" />"),
    SKETCHING(
        "sketching",
        "<path d=\"M4 15c2 -4.97 7.356 -11 9 -11c4.25 0 -5.5 11.958 -3 13s5.65 -6.678 7.4 -5.902c1.75 .777 -1.05 7.589 -.3 8.63s3.15 -.897 3.9 -2.728\" />"),
    SLICE("slice", "<path d=\"M3 19l15 -15l3 3l-6 6l2 2a14 14 0 0 1 -14 4\" />"),
    SPARKLE(
        "sparkle",
        "<path d=\"M21 12c-6.597 0 -9 2.403 -9 9c0 -6.597 -2.403 -9 -9 -9c6.597 0 9 -2.403 9 -9c0 6.597 2.403 9 9 9\" />"),
    SPARKLE_2(
        "sparkle-2",
        "<path d=\"M12 3c.375 0 .711 .231 .846 .581l1.65 4.29a2.85 2.85 0 0 0 1.632 1.633l4.291 1.65a.906 .906 0 0 1 0 1.692l-4.29 1.65a2.84 2.84 0 0 0 -1.633 1.632l-1.65 4.291a.906 .906 0 0 1 -1.692 0l-1.65 -4.29a2.84 2.84 0 0 0 -1.632 -1.633l-4.291 -1.65a.906 .906 0 0 1 0 -1.692l4.29 -1.65a2.84 2.84 0 0 0 1.633 -1.632l1.65 -4.291a.91 .91 0 0 1 .846 -.581\" />"),
    SPARKLE_HIGHLIGHT(
        "sparkle-highlight",
        "<path d=\"M14.504 8.522l-1.758 -4.032a.814 .814 0 0 0 -1.492 0l-1.759 4.032c-.19 .436 -.537 .784 -.973 .973l-4.032 1.759a.814 .814 0 0 0 0 1.492l4.033 1.758c.436 .19 .784 .538 .973 .974l1.759 4.033a.814 .814 0 0 0 1.492 0l1.758 -4.033c.19 -.436 .538 -.784 .974 -.974l4.033 -1.758a.814 .814 0 0 0 0 -1.492l-4.033 -1.759a1.88 1.88 0 0 1 -.974 -.973\" />\n  <path d=\"M3 3l2 2\" />\n  <path d=\"M21 3l-2 2\" />\n  <path d=\"M3 21l2 -2\" />\n  <path d=\"M21 21l-2 -2\" />"),
    SPARKLES_2(
        "sparkles-2",
        "<path d=\"M14 6a9.3 9.3 0 0 0 1.516 -.546c.911 -.438 1.494 -1.015 1.937 -1.932c.207 -.428 .382 -.928 .547 -1.522c.165 .595 .34 1.095 .547 1.521c.443 .918 1.026 1.495 1.937 1.933c.426 .205 .925 .38 1.516 .546a9.3 9.3 0 0 0 -1.516 .547c-.911 .438 -1.494 1.015 -1.937 1.932a9 9 0 0 0 -.547 1.521c-.165 -.594 -.34 -1.095 -.547 -1.521c-.443 -.918 -1.026 -1.494 -1.937 -1.932a9 9 0 0 0 -1.516 -.547\" />\n  <path d=\"M3 14a21 21 0 0 0 1.652 -.532c2.542 -.953 3.853 -2.238 4.816 -4.806a20 20 0 0 0 .532 -1.662a20 20 0 0 0 .532 1.662c.963 2.567 2.275 3.853 4.816 4.806q .75 .28 1.652 .532a21 21 0 0 0 -1.652 .532c-2.542 .953 -3.854 2.238 -4.816 4.806a20 20 0 0 0 -.532 1.662a20 20 0 0 0 -.532 -1.662c-.963 -2.568 -2.275 -3.853 -4.816 -4.806a21 21 0 0 0 -1.652 -.532\" />"),
    SPARKLES_2_OFF(
        "sparkles-2-off",
        "<path d=\"M14 6a9.3 9.3 0 0 0 1.516 -.546c.911 -.438 1.494 -1.015 1.937 -1.932c.207 -.428 .382 -.928 .547 -1.522c.165 .595 .34 1.095 .547 1.521c.443 .918 1.026 1.495 1.937 1.933c.426 .205 .925 .38 1.516 .546a9.3 9.3 0 0 0 -1.516 .547c-.911 .438 -1.494 1.015 -1.937 1.932a9 9 0 0 0 -.547 1.521c-.165 -.594 -.34 -1.095 -.547 -1.521c-.443 -.918 -1.026 -1.494 -1.937 -1.932a9 9 0 0 0 -1.516 -.547\" />\n  <path d=\"M14.756 14.77c-2.16 .93 -3.34 2.207 -4.224 4.568a20 20 0 0 0 -.532 1.662a20 20 0 0 0 -.532 -1.662c-.963 -2.568 -2.275 -3.853 -4.816 -4.806a21 21 0 0 0 -1.652 -.532a21 21 0 0 0 1.652 -.532c2.345 -.879 3.642 -2.04 4.585 -4.23\" />\n  <path d=\"M3 3l18 18\" />"),
    SQUARE_HALF(
        "square-half",
        "<path d=\"M12 4v16\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M12 13l7.5 -7.5\" />\n  <path d=\"M12 18l8 -8\" />\n  <path d=\"M15 20l5 -5\" />\n  <path d=\"M12 8l4 -4\" />"),
    SQUARE_TOGGLE(
        "square-toggle",
        "<path d=\"M12 2l0 20\" />\n  <path d=\"M14 20h-8a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h8\" />\n  <path d=\"M20 6a2 2 0 0 0 -2 -2\" />\n  <path d=\"M18 20a2 2 0 0 0 2 -2\" />\n  <path d=\"M20 10l0 4\" />"),
    SQUARE_TOGGLE_HORIZONTAL(
        "square-toggle-horizontal",
        "<path d=\"M22 12h-20\" />\n  <path d=\"M4 14v-8a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M18 20a2 2 0 0 0 2 -2\" />\n  <path d=\"M4 18a2 2 0 0 0 2 2\" />\n  <path d=\"M14 20l-4 0\" />"),
    SQUARES(
        "squares",
        "<path d=\"M8 10a2 2 0 0 1 2 -2h9a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-9a2 2 0 0 1 -2 -2l0 -9\" />\n  <path d=\"M16 8v-3a2 2 0 0 0 -2 -2h-9a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h3\" />"),
    SQUARES_DIAGONAL(
        "squares-diagonal",
        "<path d=\"M8 10a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M16 8v-2a2 2 0 0 0 -2 -2h-8a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M8.586 19.414l10.827 -10.827\" />"),
    STACK("stack", "<path d=\"M12 6l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 14l8 4l8 -4\" />"),
    STACK_2(
        "stack-2",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 12l8 4l8 -4\" />\n  <path d=\"M4 16l8 4l8 -4\" />"),
    STACK_3(
        "stack-3",
        "<path d=\"M12 2l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 10l8 4l8 -4\" />\n  <path d=\"M4 18l8 4l8 -4\" />\n  <path d=\"M4 14l8 4l8 -4\" />"),
    STACK_CHECK(
        "stack-check",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 12l8 4\" />\n  <path d=\"M4 16l7.004 3.502\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    STACK_MINUS(
        "stack-minus",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 12l8 4\" />\n  <path d=\"M4 16l8 4\" />\n  <path d=\"M16 19h6\" />"),
    STACK_PLUS(
        "stack-plus",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 12l8 4\" />\n  <path d=\"M4 16l8 4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    STACK_POP(
        "stack-pop",
        "<path d=\"M7 9.5l-3 1.5l8 4l8 -4l-3 -1.5\" />\n  <path d=\"M4 15l8 4l8 -4\" />\n  <path d=\"M12 11v-7\" />\n  <path d=\"M9 7l3 -3l3 3\" />"),
    STACK_PUSH(
        "stack-push",
        "<path d=\"M6 10l-2 1l8 4l8 -4l-2 -1\" />\n  <path d=\"M4 15l8 4l8 -4\" />\n  <path d=\"M12 4v7\" />\n  <path d=\"M15 8l-3 3l-3 -3\" />"),
    STACK_X(
        "stack-x",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" />\n  <path d=\"M4 12l8 4\" />\n  <path d=\"M4 16l8 4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    STICKER(
        "sticker",
        "<path d=\"M20 12l-2 .5a6 6 0 0 1 -6.5 -6.5l.5 -2l8 8\" />\n  <path d=\"M20 12a8 8 0 1 1 -8 -8\" />"),
    STICKER_2(
        "sticker-2",
        "<path d=\"M6 4h12a2 2 0 0 1 2 2v7h-5a2 2 0 0 0 -2 2v5h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2\" />\n  <path d=\"M20 13v.172a2 2 0 0 1 -.586 1.414l-4.828 4.828a2 2 0 0 1 -1.414 .586h-.172\" />"),
    STICKER_SMILE(
        "sticker-smile",
        "<path d=\"M21 12c-.819 -.388 -2.223 -.5 -3.19 -.5a6.31 6.31 0 0 0 -6.31 6.31c0 .966 .113 2.371 .5 3.19\" />\n  <path d=\"M12 21c4 0 9 -5 9 -9a9 9 0 1 0 -9 9\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M8.75 15c.878 .672 1.746 1 3 1\" />"),
    STROKE_CURVED(
        "stroke-curved",
        "<path d=\"M4 19h1.341a7 7 0 0 0 6.845 -5.533l.628 -2.934a7 7 0 0 1 6.846 -5.533h1.34\" />"),
    STROKE_DYNAMIC("stroke-dynamic", "<path d=\"M4 19h6a2 2 0 0 0 2 -2v-10a2 2 0 0 1 2 -2h7\" />"),
    STROKE_STRAIGHT("stroke-straight", "<path d=\"M4 19l16 -14\" />"),
    TEMPLATE(
        "template",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M4 13a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M14 12l6 0\" />\n  <path d=\"M14 16l6 0\" />\n  <path d=\"M14 20l6 0\" />"),
    TEMPLATE_OFF(
        "template-off",
        "<path d=\"M8 4h11a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-7m-4 0h-3a1 1 0 0 1 -1 -1v-2c0 -.271 .108 -.517 .283 -.697\" />\n  <path d=\"M4 13a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M16 12h4\" />\n  <path d=\"M14 16h2\" />\n  <path d=\"M14 20h6\" />\n  <path d=\"M3 3l18 18\" />"),
    TEXT_RESIZE(
        "text-resize",
        "<path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 7v10\" />\n  <path d=\"M7 5h10\" />\n  <path d=\"M7 19h10\" />\n  <path d=\"M19 7v10\" />\n  <path d=\"M10 10h4\" />\n  <path d=\"M12 14v-4\" />"),
    TOOLS(
        "tools",
        "<path d=\"M3 21h4l13 -13a1.5 1.5 0 0 0 -4 -4l-13 13v4\" />\n  <path d=\"M14.5 5.5l4 4\" />\n  <path d=\"M12 8l-5 -5l-4 4l5 5\" />\n  <path d=\"M7 8l-1.5 1.5\" />\n  <path d=\"M16 12l5 5l-4 4l-5 -5\" />\n  <path d=\"M16 17l-1.5 1.5\" />"),
    TOOLS_OFF(
        "tools-off",
        "<path d=\"M16 12l4 -4a2.828 2.828 0 1 0 -4 -4l-4 4m-2 2l-7 7v4h4l7 -7\" />\n  <path d=\"M14.5 5.5l4 4\" />\n  <path d=\"M12 8l-5 -5m-2 2l-2 2l5 5\" />\n  <path d=\"M7 8l-1.5 1.5\" />\n  <path d=\"M16 12l5 5m-2 2l-2 2l-5 -5\" />\n  <path d=\"M16 17l-1.5 1.5\" />\n  <path d=\"M3 3l18 18\" />"),
    TRIDENT(
        "trident",
        "<path d=\"M3 6l2 -2v3a7 7 0 0 0 14 0v-3l2 2\" />\n  <path d=\"M12 21v-18l-2 2m4 0l-2 -2\" />"),
    TYPEFACE(
        "typeface",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M17 17a2 2 0 0 1 -2 -2v-8h-5a2 2 0 0 0 -2 2\" />\n  <path d=\"M7 17a2.775 2.775 0 0 0 2.632 -1.897l.368 -1.103a13.4 13.4 0 0 1 3.236 -5.236l1.764 -1.764\" />\n  <path d=\"M10 14h5\" />"),
    UX_CIRCLE(
        "ux-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M7 10v2a2 2 0 1 0 4 0v-2\" />\n  <path d=\"M14 10l3 4\" />\n  <path d=\"M14 14l3 -4\" />"),
    VECTOR(
        "vector",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M5 7l0 10\" />\n  <path d=\"M19 7l0 10\" />\n  <path d=\"M7 5l10 0\" />\n  <path d=\"M7 19l10 0\" />"),
    VECTOR_BEZIER(
        "vector-bezier",
        "<path d=\"M3 15a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 15a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 7a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 8.5a6 6 0 0 0 -5 5.5\" />\n  <path d=\"M14 8.5a6 6 0 0 1 5 5.5\" />\n  <path d=\"M10 8l-6 0\" />\n  <path d=\"M20 8l-6 0\" />\n  <path d=\"M2 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M20 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    VECTOR_BEZIER_2(
        "vector-bezier-2",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M7 5l7 0\" />\n  <path d=\"M10 19l7 0\" />\n  <path d=\"M8 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M14 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 5.5a5 6.5 0 0 1 5 6.5a5 6.5 0 0 0 5 6.5\" />"),
    VECTOR_BEZIER_ARC(
        "vector-bezier-arc",
        "<path d=\"M3 11a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 11a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M19 10a5 5 0 0 0 -5 -5\" />\n  <path d=\"M5 14a5 5 0 0 0 5 5\" />\n  <path d=\"M5 10a5 5 0 0 1 5 -5\" />"),
    VECTOR_BEZIER_CIRCLE(
        "vector-bezier-circle",
        "<path d=\"M3 11a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 11a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M19 10a5 5 0 0 0 -5 -5\" />\n  <path d=\"M19 14a5 5 0 0 1 -5 5\" />\n  <path d=\"M5 14a5 5 0 0 0 5 5\" />\n  <path d=\"M5 10a5 5 0 0 1 5 -5\" />"),
    VECTOR_OFF(
        "vector-off",
        "<path d=\"M6.68 6.733a1 1 0 0 1 -.68 .267h-2a1 1 0 0 1 -1 -1v-2c0 -.276 .112 -.527 .293 -.708\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M20.72 20.693a1 1 0 0 1 -.72 .307h-2a1 1 0 0 1 -1 -1v-2c0 -.282 .116 -.536 .304 -.718\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M5 7v10\" />\n  <path d=\"M19 7v8\" />\n  <path d=\"M9 5h8\" />\n  <path d=\"M7 19h10\" />\n  <path d=\"M3 3l18 18\" />"),
    VECTOR_SPLINE(
        "vector-spline",
        "<path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 5c-6.627 0 -12 5.373 -12 12\" />"),
    VECTOR_TRIANGLE(
        "vector-triangle",
        "<path d=\"M10 5a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M6.5 17.1l5 -9.1\" />\n  <path d=\"M17.5 17.1l-5 -9.1\" />\n  <path d=\"M7 19l10 0\" />"),
    VECTOR_TRIANGLE_OFF(
        "vector-triangle-off",
        "<path d=\"M10 6v-1a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-1\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M20.705 20.709a1 1 0 0 1 -.705 .291h-2a1 1 0 0 1 -1 -1v-2c0 -.28 .115 -.532 .3 -.714\" />\n  <path d=\"M6.5 17.1l3.749 -6.823\" />\n  <path d=\"M13.158 9.197l-.658 -1.197\" />\n  <path d=\"M7 19h10\" />\n  <path d=\"M3 3l18 18\" />"),
    VIGNETTE(
        "vignette",
        "<path d=\"M21 12a9 9 0 1 1 -18 0a9 9 0 0 1 18 0\" />\n  <path d=\"M7.02 12h-.01\" />\n  <path d=\"M12.02 7h-.01\" />\n  <path d=\"M17.02 12h-.01\" />\n  <path d=\"M12.02 17h-.01\" />\n  <path d=\"M8.483 8.468l-.007 -.007\" />\n  <path d=\"M15.554 8.468l-.007 -.007\" />\n  <path d=\"M15.554 15.539l-.007 -.007\" />\n  <path d=\"M8.483 15.539l-.007 -.007\" />"),
    WHEEL(
        "wheel",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 12h6\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M13.6 9.4l3.4 -4.8\" />\n  <path d=\"M10.4 14.6l-3.4 4.8\" />\n  <path d=\"M7 4.6l3.4 4.8\" />\n  <path d=\"M13.6 14.6l3.4 4.8\" />"),
    YARN(
        "yarn",
        "<path d=\"M7.5 19.794a9 9 0 1 0 9 -15.588a9 9 0 0 0 -9 15.588\" />\n  <path d=\"M20.997 12a9 9 0 0 0 -8.997 9\" />\n  <path d=\"M9.662 12.778a9 9 0 0 0 -6.643 -.27\" />\n  <path d=\"M19.527 7.078a14 14 0 0 0 -12.45 12.458\" />\n  <path d=\"M13.503 9.18a14 14 0 0 0 -9.033 -2.097\" />");

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
    AD(
        "ad",
        "<path d=\"M19 4h-14a3 3 0 0 0 -3 3v10a3 3 0 0 0 3 3h14a3 3 0 0 0 3 -3v-10a3 3 0 0 0 -3 -3zm-10 4a3 3 0 0 1 2.995 2.824l.005 .176v4a1 1 0 0 1 -1.993 .117l-.007 -.117v-1h-2v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-4a3 3 0 0 1 3 -3zm0 2a1 1 0 0 0 -.993 .883l-.007 .117v1h2v-1a1 1 0 0 0 -1 -1zm8 -2a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -.883 .993l-.117 .007h-1.5a2.5 2.5 0 1 1 .326 -4.979l.174 .029v-2.05a1 1 0 0 1 .883 -.993l.117 -.007zm-1.41 5.008l-.09 -.008a.5 .5 0 0 0 -.09 .992l.09 .008h.5v-.5l-.008 -.09a.5 .5 0 0 0 -.318 -.379l-.084 -.023z\" />"),
    ARTBOARD(
        "artboard",
        "<path d=\"M15 7h-6a2 2 0 0 0 -2 2v6a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-6a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M4 7a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M4 15a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M8 2a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M16 2a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M21 7a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M21 15a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M8 19a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M16 19a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />"),
    BARRIER_BLOCK(
        "barrier-block",
        "<path d=\"M15 21a1 1 0 0 1 0 -2h1v-2h-8v2h1a1 1 0 0 1 0 2h-4a1 1 0 0 1 0 -2h1v-2h-1a2 2 0 0 1 -2 -2v-7a2 2 0 0 1 2 -2h1v-1a1 1 0 1 1 2 0v1h8v-1a1 1 0 0 1 2 0v1h1a2 2 0 0 1 2 2v7a2 2 0 0 1 -2 2h-1v2h1a1 1 0 0 1 0 2zm-2.086 -13l-7 7h4.17l6.916 -7zm6.086 2.914l-4.086 4.086h4.086zm-10.916 -2.914h-3.084v3.084z\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M8.887 6.748c-.163 0 -.337 .016 -.506 .057c-.172 .041 -.582 .165 -.838 .562l-.014 .02l-.607 1.05c-.307 .205 -.534 .46 -.693 .717l-.014 .02l-2.572 4.65a4.009 4.009 0 0 0 -.274 .494l-.006 .01a3.99 3.99 0 0 0 -.363 1.672a4 4 0 0 0 8 0v-1h2v1a4 4 0 1 0 7.635 -1.67l-.004 -.012a4.008 4.008 0 0 0 -.274 -.494l-2.572 -4.65l-.014 -.02a2.337 2.337 0 0 0 -.693 -.716l-.607 -1.051l-.014 -.02c-.256 -.397 -.667 -.52 -.838 -.562a2.225 2.225 0 0 0 -.664 -.051a2.06 2.06 0 0 0 -.68 .156c-.184 .081 -.638 .327 -.754 .889l-.007 .037l-.14 1.1c-.22 .283 -.374 .64 -.374 1.064v1h-2v-1c0 -.424 -.154 -.781 -.373 -1.064l-.14 -1.1l-.008 -.037c-.116 -.562 -.57 -.808 -.754 -.889a2.06 2.06 0 0 0 -.68 -.156a2.374 2.374 0 0 0 -.158 -.006zm-1.887 7.252a2 2 0 1 1 -1.838 1.209l.19 -.342c.36 -.523 .964 -.867 1.648 -.867zm10 0c.684 0 1.288 .344 1.648 .867l.19 .342a2 2 0 1 1 -1.838 -1.209z\" />"),
    BLADE(
        "blade",
        "<path d=\"M11.586 3a2 2 0 0 1 2.828 0l.586 .585l.586 -.585a2 2 0 0 1 2.7 -.117l.128 .117l2.586 2.586a2 2 0 0 1 0 2.828l-.586 .586l.586 .586a2 2 0 0 1 0 2.828l-8.586 8.586a2 2 0 0 1 -2.828 0l-.586 -.586l-.586 .586a2 2 0 0 1 -2.828 0l-2.586 -2.586a2 2 0 0 1 0 -2.828l.585 -.587l-.585 -.585a2 2 0 0 1 -.117 -2.7l.117 -.129zm3.027 4.21a1 1 0 0 0 -1.32 1.497l.292 .293l-1.068 1.067a2.003 2.003 0 0 0 -2.512 1.784l-.005 .149l.005 .15c.01 .125 .03 .248 .062 .367l-1.067 1.068l-.293 -.292l-.094 -.083a1 1 0 0 0 -1.32 1.497l.292 .293l-.292 .293l-.083 .094a1 1 0 0 0 1.497 1.32l.293 -.292l.293 .292l.094 .083a1 1 0 0 0 1.32 -1.497l-.292 -.293l1.069 -1.067a2.003 2.003 0 0 0 2.449 -2.45l1.067 -1.068l.293 .292l.094 .083a1 1 0 0 0 1.32 -1.497l-.292 -.293l.292 -.293l.083 -.094a1 1 0 0 0 -1.497 -1.32l-.293 .292l-.293 -.292z\" />"),
    BOLT(
        "bolt",
        "<path d=\"M13 2l.018 .001l.016 .001l.083 .005l.011 .002h.011l.038 .009l.052 .008l.016 .006l.011 .001l.029 .011l.052 .014l.019 .009l.015 .004l.028 .014l.04 .017l.021 .012l.022 .01l.023 .015l.031 .017l.034 .024l.018 .011l.013 .012l.024 .017l.038 .034l.022 .017l.008 .01l.014 .012l.036 .041l.026 .027l.006 .009c.12 .147 .196 .322 .218 .513l.001 .012l.002 .041l.004 .064v6h5a1 1 0 0 1 .868 1.497l-.06 .091l-8 11c-.568 .783 -1.808 .38 -1.808 -.588v-6h-5a1 1 0 0 1 -.868 -1.497l.06 -.091l8 -11l.01 -.013l.018 -.024l.033 -.038l.018 -.022l.009 -.008l.013 -.014l.04 -.036l.028 -.026l.008 -.006a1 1 0 0 1 .402 -.199l.011 -.001l.027 -.005l.074 -.013l.011 -.001l.041 -.002z\" />"),
    BOMB(
        "bomb",
        "<path d=\"M14.499 3.996a2.2 2.2 0 0 1 1.556 .645l3.302 3.301a2.2 2.2 0 0 1 0 3.113l-.567 .567l.043 .192a8.5 8.5 0 0 1 -3.732 8.83l-.23 .144a8.5 8.5 0 1 1 -2.687 -15.623l.192 .042l.567 -.566a2.2 2.2 0 0 1 1.362 -.636zm-4.499 5.004a4 4 0 0 0 -4 4a1 1 0 0 0 2 0a2 2 0 0 1 2 -2a1 1 0 0 0 0 -2z\" />\n  <path d=\"M21 2a1 1 0 0 1 .117 1.993l-.117 .007h-1c0 .83 -.302 1.629 -.846 2.25l-.154 .163l-1.293 1.293a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.293 -1.292c.232 -.232 .375 -.537 .407 -.86l.007 -.14a2 2 0 0 1 1.85 -1.995l.15 -.005h1z\" />"),
    BONG(
        "bong",
        "<path d=\"M14 2a1 1 0 0 1 0 2v5.587l2.293 -2.294a1 1 0 0 1 1.32 -.083l.094 .083l2 2a1 1 0 0 1 0 1.414l-3.116 3.115l.086 .233c.311 .907 .396 1.865 .263 2.794l-.062 .36l-.012 .052a6 6 0 0 1 -1.121 2.41l-.16 .199a6 6 0 0 1 -10.396 -2.378l-.068 -.288l-.009 -.046a6 6 0 0 1 2.833 -6.324l.055 -.031v-6.803a1 1 0 1 1 0 -2zm-2 2h-2v7.416a1 1 0 0 1 -.483 .856l-.117 .06a4 4 0 0 0 -2.4 3.668h8a4 4 0 0 0 -.486 -1.914a1 1 0 0 1 .17 -1.185l2.902 -2.901l-.586 -.586l-2.9 2.902a1 1 0 0 1 -1.067 .226l-.12 -.056a4 4 0 0 0 -.316 -.155a1 1 0 0 1 -.597 -.915z\" />"),
    BOOM(
        "boom",
        "<path d=\"M7.514 3.836c.151 -.909 1.346 -1.147 1.834 -.366c2.294 3.67 4.275 4.048 5.758 1.083c.471 -.944 1.894 -.608 1.894 .447c0 2.448 1.552 4 4 4c.89 0 1.337 1.077 .707 1.707c-1.61 1.61 -1.61 2.975 0 4.581c.63 .63 .185 1.707 -.706 1.708c-2.448 .003 -3.001 .556 -3.001 3.004c0 .961 -1.223 1.369 -1.8 .6c-2.325 -3.1 -5.494 -2.856 -7.368 -.045c-.503 .754 -1.67 .504 -1.818 -.39c-.365 -2.188 -1.04 -2.656 -4.178 -3.179a1 1 0 0 1 -.543 -1.693c1.618 -1.618 1.618 -3.027 -.053 -4.981l-.009 -.013l-.013 -.014l-.044 -.062l-.01 -.011l-.006 -.013l-.038 -.066l-.017 -.028l-.001 -.004l-.027 -.066l-.019 -.041a1 1 0 0 1 -.051 -.233l-.002 -.045l-.003 -.068a1 1 0 0 1 .06 -.328l.009 -.023l.023 -.049l.011 -.029l.009 -.015l.007 -.016l.019 -.029l.02 -.035l.012 -.017l.013 -.022l.027 -.034l.011 -.016l.018 -.02l.02 -.025l.021 -.02l.015 -.017l.035 -.032l.02 -.019l.009 -.007l.018 -.015l.055 -.039l.018 -.015l.008 -.004l.01 -.007l.061 -.034l.028 -.016l.004 -.002l.063 -.026l.044 -.019a1 1 0 0 1 .115 -.032l.004 -.002l.267 -.063c2.39 -.613 3.934 -2.19 4.411 -4.523z\" />"),
    BOUNCE_LEFT(
        "bounce-left",
        "<path d=\"M8.486 11.143a1 1 0 0 1 1.371 .343c1.045 1.74 1.83 3.443 2.392 5.237l.172 .581l.092 -.13c2.093 -2.921 4.48 -3.653 7.565 -2.7l.238 .077a1 1 0 1 1 -.632 1.898c-2.932 -.978 -4.73 -.122 -6.79 3.998c-.433 .866 -1.721 .673 -1.88 -.283c-.46 -2.76 -1.369 -5.145 -2.871 -7.65a1 1 0 0 1 .343 -1.371z\" />\n  <path d=\"M6 4a3 3 0 1 0 0 6a3 3 0 0 0 0 -6\" />"),
    BOUNCE_RIGHT(
        "bounce-right",
        "<path d=\"M14.143 11.486a1 1 0 0 1 1.714 1.028c-1.502 2.505 -2.41 4.89 -2.87 7.65c-.16 .956 -1.448 1.15 -1.881 .283c-2.06 -4.12 -3.858 -4.976 -6.79 -3.998a1 1 0 1 1 -.632 -1.898c3.2 -1.067 5.656 -.373 7.803 2.623l.091 .13l.011 -.04c.522 -1.828 1.267 -3.55 2.273 -5.3l.28 -.478z\" />\n  <path d=\"M18 4a3 3 0 1 0 0 6a3 3 0 0 0 0 -6\" />"),
    BOX_ALIGN_BOTTOM(
        "box-align-bottom",
        "<path d=\"M20 13h-16a1 1 0 0 0 -1 1v5a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-5a1 1 0 0 0 -1 -1z\" />\n  <path d=\"M4 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BOX_ALIGN_BOTTOM_LEFT(
        "box-align-bottom-left",
        "<path d=\"M10 12h-5a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h5a2 2 0 0 0 2 -2v-5a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M4 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 14a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BOX_ALIGN_BOTTOM_RIGHT(
        "box-align-bottom-right",
        "<path d=\"M19 12h-5a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h5a2 2 0 0 0 2 -2v-5a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M20 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 14a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BOX_ALIGN_LEFT(
        "box-align-left",
        "<path d=\"M10.002 3.003h-5a2 2 0 0 0 -2 2v14a2 2 0 0 0 2 2h5a1 1 0 0 0 1 -1v-16a1 1 0 0 0 -1 -1z\" />\n  <path d=\"M15.002 19.003a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M20.003 19.003a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M20.003 14.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M20.003 8.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M20.003 3.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M15.002 3.002a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />"),
    BOX_ALIGN_RIGHT(
        "box-align-right",
        "<path d=\"M18.998 3.003h-5a1 1 0 0 0 -1 1v16a1 1 0 0 0 1 1h5a2 2 0 0 0 2 -2v-14a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M9.008 19.003a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M4.008 19.003a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M4.008 14.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M4.008 8.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M4.008 3.002a1 1 0 0 1 .117 1.993l-.128 .007a1 1 0 0 1 -.117 -1.993l.128 -.007z\" />\n  <path d=\"M9.008 3.002a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />"),
    BOX_ALIGN_TOP(
        "box-align-top",
        "<path d=\"M19 3.005h-14a2 2 0 0 0 -2 2v5a1 1 0 0 0 1 1h16a1 1 0 0 0 1 -1v-5a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M4 13.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 18.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 18.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 18.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 18.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 13.995a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BOX_ALIGN_TOP_LEFT(
        "box-align-top-left",
        "<path d=\"M10 3h-5a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h5a2 2 0 0 0 2 -2v-5a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M15 3a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M20 3a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M20 8a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M20 14a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M4 14a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M20 19a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M15 19a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M9 19a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M4 19a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />"),
    BOX_ALIGN_TOP_RIGHT(
        "box-align-top-right",
        "<path d=\"M19 3.01h-5a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h5a2 2 0 0 0 2 -2v-5a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M20 14a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M20 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M15 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M9 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 19a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 14a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M4 3a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BOX_MULTIPLE(
        "box-multiple",
        "<path d=\"M6 5.667a3.667 3.667 0 0 1 3.667 -3.667h8.666a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667z\" />\n  <path d=\"M2 9c0 -1.094 .533 -1.828 1.514 -2.374a1 1 0 1 1 .972 1.748c-.398 .221 -.486 .342 -.486 .626v10c0 .548 .452 1 1 1h9.998c.32 0 .618 -.154 .805 -.407l.065 -.1a1 1 0 1 1 1.738 .99a3 3 0 0 1 -2.606 1.517h-10c-1.652 0 -3 -1.348 -3 -3z\" />"),
    BRIEFCASE(
        "briefcase",
        "<path d=\"M22 13.478v4.522a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-4.522l.553 .277a20.999 20.999 0 0 0 18.897 -.002l.55 -.275zm-8 -11.478a3 3 0 0 1 3 3v1h2a3 3 0 0 1 3 3v2.242l-1.447 .724a19.002 19.002 0 0 1 -16.726 .186l-.647 -.32l-1.18 -.59v-2.242a3 3 0 0 1 3 -3h2v-1a3 3 0 0 1 3 -3h4zm-2 8a1 1 0 0 0 -1 1a1 1 0 1 0 2 .01c0 -.562 -.448 -1.01 -1 -1.01zm2 -6h-4a1 1 0 0 0 -1 1v1h6v-1a1 1 0 0 0 -1 -1z\" />"),
    BRIEFCASE_2(
        "briefcase-2",
        "<path d=\"M14 2a3 3 0 0 1 3 3v1h2a3 3 0 0 1 3 3v9a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3h2v-1a3 3 0 0 1 3 -3zm0 2h-4a1 1 0 0 0 -1 1v1h6v-1a1 1 0 0 0 -1 -1\" />"),
    BULB(
        "bulb",
        "<path d=\"M4 11a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M12 2a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M21 11a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M4.893 4.893a1 1 0 0 1 1.32 -.083l.094 .083l.7 .7a1 1 0 0 1 -1.32 1.497l-.094 -.083l-.7 -.7a1 1 0 0 1 0 -1.414z\" />\n  <path d=\"M17.693 4.893a1 1 0 0 1 1.497 1.32l-.083 .094l-.7 .7a1 1 0 0 1 -1.497 -1.32l.083 -.094l.7 -.7z\" />\n  <path d=\"M14 18a1 1 0 0 1 1 1a3 3 0 0 1 -6 0a1 1 0 0 1 .883 -.993l.117 -.007h4z\" />\n  <path d=\"M12 6a6 6 0 0 1 3.6 10.8a1 1 0 0 1 -.471 .192l-.129 .008h-6a1 1 0 0 1 -.6 -.2a6 6 0 0 1 3.6 -10.8z\" />"),
    CANDLE(
        "candle",
        "<path d=\"M14 9a2 2 0 0 1 2 2v10a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-10a2 2 0 0 1 2 -2z\" />\n  <path d=\"M11.254 1.334a1 1 0 0 1 1.491 0l1.452 1.623a3 3 0 0 1 -4.196 4.28c-1.195 -1.07 -1.339 -2.889 -.297 -4.166z\" />"),
    CARDS(
        "cards",
        "<path d=\"M10.348 3.169l-7.15 3.113a2 2 0 0 0 -1.03 2.608l4.92 11.895a1.96 1.96 0 0 0 2.59 1.063l7.142 -3.11a2.002 2.002 0 0 0 1.036 -2.611l-4.92 -11.894a1.96 1.96 0 0 0 -2.588 -1.064z\" />\n  <path d=\"M16 3a2 2 0 0 1 1.995 1.85l.005 .15v3.5a1 1 0 0 1 -1.993 .117l-.007 -.117v-3.5h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M19.08 5.61a1 1 0 0 1 1.31 -.53c.257 .108 .505 .21 .769 .314a2 2 0 0 1 1.114 2.479l-.056 .146l-2.298 5.374a1 1 0 0 1 -1.878 -.676l.04 -.11l2.296 -5.371l-.366 -.148l-.402 -.167a1 1 0 0 1 -.53 -1.312z\" />"),
    CAROUSEL_HORIZONTAL(
        "carousel-horizontal",
        "<path d=\"M16 4h-8a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M22 6a1 1 0 0 1 .117 1.993l-.117 .007h-1v8h1a1 1 0 0 1 .117 1.993l-.117 .007h-1a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-8a2 2 0 0 1 1.85 -1.995l.15 -.005h1z\" />\n  <path d=\"M3 6a2 2 0 0 1 1.995 1.85l.005 .15v8a2 2 0 0 1 -1.85 1.995l-.15 .005h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1v-8h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />"),
    CAROUSEL_VERTICAL(
        "carousel-vertical",
        "<path d=\"M18 6h-12a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-8a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M16 19a2 2 0 0 1 1.995 1.85l.005 .15v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1h-8v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a2 2 0 0 1 1.85 -1.995l.15 -.005h8z\" />\n  <path d=\"M17 1a1 1 0 0 1 .993 .883l.007 .117v1a2 2 0 0 1 -1.85 1.995l-.15 .005h-8a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-1a1 1 0 0 1 1.993 -.117l.007 .117v1h8v-1a1 1 0 0 1 1 -1z\" />"),
    CONFETTI(
        "confetti",
        "<path d=\"M3 5a1 1 0 0 1 1 -1a1 1 0 0 1 1.993 -.117l.007 .117a1 1 0 0 1 .117 1.993l-.117 .007a1 1 0 1 1 -2 0a1 1 0 0 1 -1 -1m7.53 -1.243a1 1 0 1 1 1.94 .486l-.5 2a1 1 0 1 1 -1.94 -.486zm6.47 1.243a1 1 0 0 1 1 -1a1 1 0 0 1 1.993 -.117l.007 .117a1 1 0 0 1 .117 1.993l-.117 .007a1 1 0 0 1 -2 0a1 1 0 0 1 -1 -1m-8.81 4.293l6.517 6.518a1 1 0 0 1 -.29 1.617l-9.573 4.387a2 2 0 0 1 -2.661 -2.652l4.39 -9.58a1 1 0 0 1 1.616 -.29m7.517 -1a1 1 0 0 1 0 1.414l-1 1a1 1 0 0 1 -1.414 -1.414l1 -1a1 1 0 0 1 1.414 0m4.05 3.237a1 1 0 0 1 .486 1.94l-2 .5a1 1 0 0 1 -.486 -1.94zm-2.756 7.47a1 1 0 0 1 1 -1a1 1 0 0 1 1.993 -.117l.007 .117a1 1 0 0 1 .117 1.993l-.117 .007a1 1 0 0 1 -2 0a1 1 0 0 1 -1 -1\" />"),
    CONTAINER(
        "container",
        "<path d=\"M20 3a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 19a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 15a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 11a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 7a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M15 3a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2z\" />\n  <path d=\"M4 3a1 1 0 0 1 1 1v.01a1 1 0 1 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 19a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 15a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 11a1 1 0 0 1 1 1v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 7a1 1 0 0 1 1 1v.01a1 1 0 1 1 -2 0v-.01a1 1 0 0 1 1 -1\" />"),
    COOKIE_MAN(
        "cookie-man",
        "<path d=\"M12.007 1l.238 .005a6 6 0 0 1 5.405 3.974l.078 .233a6 6 0 0 1 -.182 4.08l-.093 .21l.05 -.002a2.94 2.94 0 0 1 2.638 1.511l.081 .158a2.887 2.887 0 0 1 -1.234 3.764l-.19 .096l-1.798 .821v.963l1.166 1.166l.14 .154a2.96 2.96 0 0 1 -.17 4.002c-1.087 1.088 -2.827 1.161 -4.03 .144l-.16 -.146l-1.946 -1.948l-1.946 1.947a2.96 2.96 0 0 1 -3.95 .22l-.15 -.128c-1.17 -1.073 -1.284 -2.879 -.234 -4.12l.146 -.158l1.134 -1.134v-.962l-1.834 -.84l-.181 -.093a2.88 2.88 0 0 1 -1.205 -3.75a2.93 2.93 0 0 1 2.646 -1.661l.13 .003l-.03 -.064a6.1 6.1 0 0 1 -.503 -1.968l-.017 -.26v-.217a6 6 0 0 1 5.775 -5.996l.224 -.004zm.003 15h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m0 -3h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m0 -5h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m-2 -3h-.01a1 1 0 1 0 0 2h.01a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />"),
    CROP_1_1(
        "crop-1-1",
        "<path d=\"M18 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3z\" />"),
    CROP_16_9(
        "crop-16-9",
        "<path d=\"M18 7a3 3 0 0 1 3 3v4a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-4a3 3 0 0 1 3 -3z\" />"),
    CROP_3_2(
        "crop-3-2",
        "<path d=\"M18 6a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3z\" />"),
    CROP_5_4(
        "crop-5-4",
        "<path d=\"M18 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3z\" />"),
    CROP_7_5(
        "crop-7-5",
        "<path d=\"M18 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />"),
    CROP_LANDSCAPE(
        "crop-landscape",
        "<path d=\"M18 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />"),
    CROP_PORTRAIT(
        "crop-portrait",
        "<path d=\"M16 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3z\" />"),
    CROWN(
        "crown",
        "<path d=\"M19 19h-14c-.5 0 -.9 -.3 -1 -.8l-2 -10c0 -.4 .1 -.8 .5 -1.1c.4 -.2 .8 -.2 1.1 0l4.1 3.3l3.4 -5.1c.4 -.6 1.3 -.6 1.7 0l3.4 5.1l4.1 -3.3c.3 -.3 .8 -.3 1.1 0c.4 .2 .5 .6 .5 1.1l-2 10c0 .5 -.5 .8 -1 .8z\" />"),
    DROPLET(
        "droplet",
        "<path d=\"M10.708 2.372a2.382 2.382 0 0 0 -.71 .686l-4.892 7.26c-1.981 3.314 -1.22 7.466 1.767 9.882c2.969 2.402 7.286 2.402 10.254 0c2.987 -2.416 3.748 -6.569 1.795 -9.836l-4.919 -7.306c-.722 -1.075 -2.192 -1.376 -3.295 -.686z\" />"),
    DROPLET_HALF(
        "droplet-half",
        "<path d=\"M12 2l.07 .003a2.41 2.41 0 0 1 1.825 .907l.108 .148l4.92 7.306c1.952 3.267 1.191 7.42 -1.796 9.836c-2.968 2.402 -7.285 2.402 -10.254 0c-2.917 -2.36 -3.711 -6.376 -1.901 -9.65l.134 -.232l4.893 -7.26c.185 -.275 .426 -.509 .709 -.686a2.426 2.426 0 0 1 1.066 -.36l.226 -.012zm-1 3.149l-4.206 6.24c-1.44 2.41 -.88 5.463 1.337 7.257a6.101 6.101 0 0 0 2.869 1.276v-14.773z\" />"),
    DROPLET_HALF_2(
        "droplet-half-2",
        "<path d=\"M13.905 2.923l.098 .135l4.92 7.306a7.566 7.566 0 0 1 1.043 3.167l.024 .326c.007 .047 .01 .094 .01 .143l-.002 .06c.056 2.3 -.944 4.582 -2.87 6.14c-2.969 2.402 -7.286 2.402 -10.255 0c-1.904 -1.54 -2.904 -3.787 -2.865 -6.071a1.052 1.052 0 0 1 .013 -.333a7.66 7.66 0 0 1 .913 -3.176l.172 -.302l4.893 -7.26c.185 -.275 .426 -.509 .709 -.686c1.055 -.66 2.446 -.413 3.197 .55zm-2.06 1.107l-.077 .038l-.041 .03l-.037 .036l-.033 .042l-4.863 7.214a5.607 5.607 0 0 0 -.651 1.61h11.723a5.444 5.444 0 0 0 -.49 -1.313l-.141 -.251l-4.891 -7.261a.428 .428 0 0 0 -.5 -.145z\" />"),
    EASE_IN_CONTROL_POINT(
        "ease-in-control-point",
        "<path d=\"M19 16a3 3 0 1 1 -2.829 4h-1.171a1 1 0 0 1 0 -2h1.17a3 3 0 0 1 2.83 -2m2.53 -13.848a1 1 0 0 1 .318 1.378l-.286 .445l-.173 .264a73 73 0 0 1 -1.26 1.839a70 70 0 0 1 -4.376 5.58c-2.795 3.195 -5.544 5.638 -8.171 7.04c-1.593 .848 -3.123 1.302 -4.582 1.302a1 1 0 0 1 0 -2c1.097 0 2.317 -.361 3.64 -1.068c2.373 -1.265 4.958 -3.562 7.607 -6.59a68 68 0 0 0 4.25 -5.42a69 69 0 0 0 1.003 -1.456l.455 -.69q .133 -.204 .196 -.306a1 1 0 0 1 1.378 -.318m-9.529 15.848a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2z\" />"),
    EASE_IN_OUT_CONTROL_POINTS(
        "ease-in-out-control-points",
        "<path d=\"M19 17a3 3 0 1 1 -2.829 4h-1.171a1 1 0 0 1 0 -2h1.17a3 3 0 0 1 2.83 -2m-14 -16c1.306 0 2.418 .835 2.83 2h1.17a1 1 0 1 1 0 2h-1.171a3.001 3.001 0 1 1 -2.829 -4m9 2a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2zm-2 16a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2z\" />\n  <path d=\"M21 3a1 1 0 0 1 0 2c-2.83 0 -4.6 1.845 -8.152 7.53c-3.947 6.315 -6.012 8.47 -9.848 8.47a1 1 0 0 1 0 -2c2.83 0 4.6 -1.845 8.152 -7.53c3.947 -6.315 6.012 -8.47 9.848 -8.47\" />"),
    EASE_OUT_CONTROL_POINT(
        "ease-out-control-point",
        "<path d=\"M21 4a1 1 0 0 1 0 2c-1.097 0 -2.317 .361 -3.64 1.068c-2.373 1.265 -4.958 3.562 -7.607 6.59a68 68 0 0 0 -4.25 5.42a69 69 0 0 0 -1.003 1.456l-.455 .69q -.132 .204 -.196 .306a1 1 0 1 1 -1.696 -1.06l.286 -.445l.173 -.264a73 73 0 0 1 1.26 -1.839a70 70 0 0 1 4.376 -5.58c2.795 -3.195 5.544 -5.638 8.171 -7.04c1.592 -.848 3.122 -1.302 4.581 -1.302m-16 -2c1.306 0 2.418 .835 2.83 2h1.17a1 1 0 1 1 0 2h-1.171a3.001 3.001 0 1 1 -2.829 -4\" />\n  <path d=\"M14 4a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2z\" />"),
    EDIT(
        "edit",
        "<path d=\"M8 7a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v9a1 1 0 0 0 1 1h9a1 1 0 0 0 1 -1v-1a1 1 0 0 1 2 0v1a3 3 0 0 1 -3 3h-9a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3h1a1 1 0 0 1 1 1\" />\n  <path d=\"M14.596 5.011l4.392 4.392l-6.28 6.303a1 1 0 0 1 -.708 .294h-3a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 .294 -.708zm6.496 -2.103a3.097 3.097 0 0 1 .165 4.203l-.164 .18l-.693 .694l-4.387 -4.387l.695 -.69a3.1 3.1 0 0 1 4.384 0\" />"),
    FAVICON(
        "favicon",
        "<path d=\"M19 4a4 4 0 0 1 4 4v8a4 4 0 0 1 -4 4h-14a4 4 0 0 1 -4 -4v-8a4 4 0 0 1 4 -4zm-13 5a1 1 0 0 0 -1 1v4a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m5 0a3 3 0 0 0 0 6a1 1 0 0 0 .117 -1.993l-.117 -.007a1 1 0 0 1 -.117 -1.993l.117 -.007a1 1 0 0 0 0 -2m5 0a3 3 0 0 0 -2.995 2.824l-.005 .176a3 3 0 1 0 3 -3\" />\n  <path d=\"M16 11a1 1 0 1 0 0 2a1 1 0 0 0 0 -2\" />"),
    GUITAR_PICK(
        "guitar-pick",
        "<path d=\"M12 2c-1.613 0 -2.882 .104 -3.825 .323l-.23 .057c-3.019 .708 -4.945 2.503 -4.945 5.62c0 3.367 1.939 8.274 4.22 11.125c.32 .4 .664 .786 1.03 1.158l.367 .36a4.904 4.904 0 0 0 6.752 .011a15.04 15.04 0 0 0 1.41 -1.528c2.491 -3.113 4.221 -7.294 4.221 -11.126c0 -3.025 -1.813 -4.806 -4.71 -5.562l-.266 -.066c-.936 -.25 -2.281 -.372 -4.024 -.372z\" />"),
    INNER_SHADOW_BOTTOM(
        "inner-shadow-bottom",
        "<path d=\"M5.144 4.72c3.92 -3.695 10.093 -3.625 13.927 .209c3.905 3.905 3.905 10.237 0 14.142c-3.905 3.905 -10.237 3.905 -14.142 0c-3.905 -3.905 -3.905 -10.237 0 -14.142zm3.32 10.816a1 1 0 1 0 -1.414 1.414a7 7 0 0 0 9.9 0a1 1 0 0 0 -1.414 -1.414a5 5 0 0 1 -7.072 0z\" />"),
    INNER_SHADOW_BOTTOM_LEFT(
        "inner-shadow-bottom-left",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10zm-6 9a1 1 0 0 0 -1 1a7 7 0 0 0 7 7a1 1 0 0 0 0 -2a5 5 0 0 1 -5 -5a1 1 0 0 0 -1 -1z\" />"),
    INNER_SHADOW_BOTTOM_RIGHT(
        "inner-shadow-bottom-right",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10zm6 9a1 1 0 0 0 -1 1a5 5 0 0 1 -5 5a1 1 0 0 0 0 2a7 7 0 0 0 7 -7a1 1 0 0 0 -1 -1z\" />"),
    INNER_SHADOW_LEFT(
        "inner-shadow-left",
        "<path d=\"M4.929 4.929c3.905 -3.905 10.237 -3.905 14.142 0c3.905 3.905 3.905 10.237 0 14.142c-3.905 3.905 -10.237 3.905 -14.142 0c-3.905 -3.905 -3.905 -10.237 0 -14.142zm3.535 2.121a1 1 0 0 0 -1.414 0a7 7 0 0 0 0 9.9a1 1 0 1 0 1.414 -1.414a5 5 0 0 1 0 -7.072a1 1 0 0 0 0 -1.414z\" />"),
    INNER_SHADOW_RIGHT(
        "inner-shadow-right",
        "<path d=\"M4.929 4.929c3.905 -3.905 10.237 -3.905 14.142 0c3.905 3.905 3.905 10.237 0 14.142c-3.905 3.905 -10.237 3.905 -14.142 0c-3.905 -3.905 -3.905 -10.237 0 -14.142zm12.02 2.121a1 1 0 0 0 -1.413 1.414a5 5 0 0 1 0 7.072a1 1 0 0 0 1.414 1.414a7 7 0 0 0 0 -9.9z\" />"),
    INNER_SHADOW_TOP(
        "inner-shadow-top",
        "<path d=\"M4.929 4.929c3.905 -3.905 10.237 -3.905 14.142 0c3.905 3.905 3.905 10.237 0 14.142c-3.905 3.905 -10.237 3.905 -14.142 0c-3.905 -3.905 -3.905 -10.237 0 -14.142zm12.02 2.121a7 7 0 0 0 -9.899 0a1 1 0 0 0 1.414 1.414a5 5 0 0 1 7.072 0a1 1 0 0 0 1.414 -1.414z\" />"),
    INNER_SHADOW_TOP_LEFT(
        "inner-shadow-top-left",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10zm0 3a7 7 0 0 0 -7 7a1 1 0 0 0 2 0a5 5 0 0 1 5 -5a1 1 0 0 0 0 -2z\" />"),
    INNER_SHADOW_TOP_RIGHT(
        "inner-shadow-top-right",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10zm0 3a1 1 0 0 0 0 2a5 5 0 0 1 5 5a1 1 0 0 0 2 0a7 7 0 0 0 -7 -7z\" />"),
    KEY(
        "key",
        "<path d=\"M14.52 2c1.029 0 2.015 .409 2.742 1.136l3.602 3.602a3.877 3.877 0 0 1 0 5.483l-2.643 2.643a3.88 3.88 0 0 1 -4.941 .452l-.105 -.078l-5.882 5.883a3 3 0 0 1 -1.68 .843l-.22 .027l-.221 .009h-1.172c-1.014 0 -1.867 -.759 -1.991 -1.823l-.009 -.177v-1.172c0 -.704 .248 -1.386 .73 -1.96l.149 -.161l.414 -.414a1 1 0 0 1 .707 -.293h1v-1a1 1 0 0 1 .883 -.993l.117 -.007h1v-1a1 1 0 0 1 .206 -.608l.087 -.1l1.468 -1.469l-.076 -.103a3.9 3.9 0 0 1 -.678 -1.963l-.007 -.236c0 -1.029 .409 -2.015 1.136 -2.742l2.643 -2.643a3.88 3.88 0 0 1 2.741 -1.136m.495 5h-.02a2 2 0 1 0 0 4h.02a2 2 0 1 0 0 -4\" />"),
    LASSO_POLYGON(
        "lasso-polygon",
        "<path d=\"M5.581 2.186l6.566 4.69l7.502 -2.812a1 1 0 0 1 1.326 .714l.019 .112l1 9a1 1 0 0 1 -.678 1.059l-9 3a1 1 0 0 1 -.553 .023l-4.434 -1.082a3 3 0 0 1 -1.287 .923c.095 .986 .374 1.9 .826 2.69a1 1 0 0 1 -1.736 .993c-.624 -1.09 -.99 -2.335 -1.098 -3.656a3 3 0 0 1 -2.034 -2.84l.005 -.176a3 3 0 0 1 .86 -1.932l-.818 -2.59a1 1 0 0 1 -.009 -.577l2 -7a1 1 0 0 1 1.543 -.539m-.009 2.451l-1.528 5.348l.642 2.031q .155 -.016 .314 -.016a3 3 0 0 1 3 2.995l3.957 .965l7.96 -2.654l-.769 -6.919l-6.797 2.55a1 1 0 0 1 -.827 -.058l-.105 -.065z\" />"),
    LAUREL_WREATH(
        "laurel-wreath",
        "<path d=\"M16.956 2.057c.355 .124 .829 .375 1.303 .796a3.77 3.77 0 0 1 1.246 2.204c.173 .989 -.047 1.894 -.519 2.683l-.123 .194q -.097 .147 -.196 .272q .066 .234 .117 .471q .26 -.178 .545 -.307c.851 -.389 1.727 -.442 2.527 -.306q .226 .04 .346 .076a1 1 0 0 1 .689 .712l.029 .13q .015 .08 .03 .18a4.45 4.45 0 0 1 -.324 2.496a3.94 3.94 0 0 1 -1.71 1.85l-.242 .12a4.23 4.23 0 0 1 -2.234 .349a9 9 0 0 1 -.443 1.023c.37 .016 .748 .093 1.128 .24c.732 .28 1.299 .758 1.711 1.367a3.95 3.95 0 0 1 .654 1.613a1 1 0 0 1 -.356 .917a3.8 3.8 0 0 1 -.716 .443c-.933 .455 -1.978 .588 -3.043 .179l-.032 -.015l-.205 -.086a3.6 3.6 0 0 1 -1.33 -1.069l-.143 -.197a4 4 0 0 1 -.26 -.433a6 6 0 0 1 -.927 .511q .18 .262 .337 .56a7.4 7.4 0 0 1 .66 1.747a1 1 0 0 1 -1.95 .444l-.028 -.11a6 6 0 0 0 -.449 -1.143c-.342 -.645 -.71 -.968 -1.048 -.968s-.706 .323 -1.048 .969a5.6 5.6 0 0 0 -.367 .874l-.082 .269l-.028 .11a1 1 0 0 1 -1.95 -.444a7.3 7.3 0 0 1 .66 -1.747q .158 -.298 .337 -.561a6.4 6.4 0 0 1 -.93 -.508a4 4 0 0 1 -.256 .43c-.366 .541 -.855 .98 -1.473 1.267l-.238 .1c-.994 .382 -1.97 .292 -2.855 -.091l-.188 -.087a3.8 3.8 0 0 1 -.716 -.443a1 1 0 0 1 -.356 -.917a3.95 3.95 0 0 1 .654 -1.613a3.6 3.6 0 0 1 1.71 -1.368c.38 -.146 .758 -.223 1.13 -.24a9 9 0 0 1 -.445 -1.023a4.23 4.23 0 0 1 -2.233 -.348a4 4 0 0 1 -.916 -.587l-.207 -.191a4 4 0 0 1 -.724 -.977l-.105 -.216a4.45 4.45 0 0 1 -.265 -2.806a1 1 0 0 1 .69 -.712q .119 -.036 .345 -.076c.801 -.135 1.678 -.082 2.53 .308q .283 .129 .545 .304q .048 -.235 .112 -.47a5 5 0 0 1 -.194 -.272c-.556 -.832 -.83 -1.806 -.642 -2.877l.05 -.242a3.75 3.75 0 0 1 1.027 -1.803l.169 -.159a4 4 0 0 1 1.303 -.796a1 1 0 0 1 .975 .178c.2 .168 .462 .446 .719 .83c.556 .833 .83 1.807 .642 2.878a3.77 3.77 0 0 1 -1.246 2.204c-.303 .27 -.607 .47 -.879 .61a7.5 7.5 0 0 0 -.255 1.971c0 3.502 2.285 6.272 5 6.272s5 -2.77 5 -6.276a7.6 7.6 0 0 0 -.253 -1.967a4.3 4.3 0 0 1 -.881 -.61a3.77 3.77 0 0 1 -1.246 -2.204c-.188 -1.07 .086 -2.045 .642 -2.877c.257 -.385 .52 -.663 .72 -.831a1 1 0 0 1 .974 -.178\" />"),
    LAUREL_WREATH_1(
        "laurel-wreath-1",
        "<path d=\"M16.956 2.057c.355 .124 .829 .375 1.303 .796a3.77 3.77 0 0 1 1.246 2.204c.173 .989 -.047 1.894 -.519 2.683l-.123 .194q -.097 .147 -.196 .272q .066 .234 .117 .471q .26 -.178 .545 -.307c.851 -.389 1.727 -.442 2.527 -.306q .226 .04 .346 .076a1 1 0 0 1 .689 .712l.029 .13q .015 .08 .03 .18a4.45 4.45 0 0 1 -.324 2.496a3.94 3.94 0 0 1 -1.71 1.85l-.242 .12a4.23 4.23 0 0 1 -2.234 .349a9 9 0 0 1 -.443 1.023c.37 .016 .748 .093 1.128 .24c.732 .28 1.299 .758 1.711 1.367a3.95 3.95 0 0 1 .654 1.613a1 1 0 0 1 -.356 .917a3.8 3.8 0 0 1 -.716 .443c-.933 .455 -1.978 .588 -3.043 .179l-.032 -.015l-.205 -.086a3.6 3.6 0 0 1 -1.33 -1.069l-.143 -.197a4 4 0 0 1 -.26 -.433a6 6 0 0 1 -.927 .511q .18 .262 .337 .56a7.4 7.4 0 0 1 .66 1.747a1 1 0 0 1 -1.95 .444l-.028 -.11a6 6 0 0 0 -.449 -1.143c-.342 -.645 -.71 -.968 -1.048 -.968s-.706 .323 -1.048 .969a5.6 5.6 0 0 0 -.367 .874l-.082 .269l-.028 .11a1 1 0 0 1 -1.95 -.444a7.3 7.3 0 0 1 .66 -1.747q .158 -.298 .337 -.561a6.4 6.4 0 0 1 -.93 -.508a4 4 0 0 1 -.256 .43c-.366 .541 -.855 .98 -1.473 1.267l-.238 .1c-.994 .382 -1.97 .292 -2.855 -.091l-.188 -.087a3.8 3.8 0 0 1 -.716 -.443a1 1 0 0 1 -.356 -.917a3.95 3.95 0 0 1 .654 -1.613a3.6 3.6 0 0 1 1.71 -1.368c.38 -.146 .758 -.223 1.13 -.24a9 9 0 0 1 -.445 -1.023a4.23 4.23 0 0 1 -2.233 -.348a4 4 0 0 1 -.916 -.587l-.207 -.191a4 4 0 0 1 -.724 -.977l-.105 -.216a4.45 4.45 0 0 1 -.265 -2.806a1 1 0 0 1 .69 -.712q .119 -.036 .345 -.076c.801 -.135 1.678 -.082 2.53 .308q .283 .129 .545 .304q .048 -.235 .112 -.47a5 5 0 0 1 -.194 -.272c-.556 -.832 -.83 -1.806 -.642 -2.877l.05 -.242a3.75 3.75 0 0 1 1.027 -1.803l.169 -.159a4 4 0 0 1 1.303 -.796a1 1 0 0 1 .975 .178c.2 .168 .462 .446 .719 .83c.556 .833 .83 1.807 .642 2.878a3.77 3.77 0 0 1 -1.246 2.204c-.303 .27 -.607 .47 -.879 .61a7.5 7.5 0 0 0 -.255 1.971c0 3.502 2.285 6.272 5 6.272s5 -2.77 5 -6.276a7.6 7.6 0 0 0 -.253 -1.967a4.3 4.3 0 0 1 -.881 -.61a3.77 3.77 0 0 1 -1.246 -2.204c-.188 -1.07 .086 -2.045 .642 -2.877c.257 -.385 .52 -.663 .72 -.831a1 1 0 0 1 .974 -.178m-3.956 5.943v6a1 1 0 0 1 -2 0v-4.002h-.059a1 1 0 0 1 -.554 -.208l-.094 -.083a1 1 0 0 1 0 -1.414l1 -1c.63 -.63 1.707 -.184 1.707 .707\" />"),
    LAUREL_WREATH_2(
        "laurel-wreath-2",
        "<path d=\"M16.956 2.057c.355 .124 .829 .375 1.303 .796a3.77 3.77 0 0 1 1.246 2.204c.173 .989 -.047 1.894 -.519 2.683l-.123 .194q -.097 .147 -.196 .272q .066 .234 .117 .471q .26 -.178 .545 -.307c.851 -.389 1.727 -.442 2.527 -.306q .226 .04 .346 .076a1 1 0 0 1 .689 .712l.029 .13q .015 .08 .03 .18a4.45 4.45 0 0 1 -.324 2.496a3.94 3.94 0 0 1 -1.71 1.85l-.242 .12a4.23 4.23 0 0 1 -2.234 .349a9 9 0 0 1 -.443 1.023c.37 .016 .748 .093 1.128 .24c.732 .28 1.299 .758 1.711 1.367a3.95 3.95 0 0 1 .654 1.613a1 1 0 0 1 -.356 .917a3.8 3.8 0 0 1 -.716 .443c-.933 .455 -1.978 .588 -3.043 .179l-.032 -.015l-.205 -.086a3.6 3.6 0 0 1 -1.33 -1.069l-.143 -.197a4 4 0 0 1 -.26 -.433a6 6 0 0 1 -.927 .511q .18 .262 .337 .56a7.4 7.4 0 0 1 .66 1.747a1 1 0 0 1 -1.95 .444l-.028 -.11a6 6 0 0 0 -.449 -1.143c-.342 -.645 -.71 -.968 -1.048 -.968s-.706 .323 -1.048 .969a5.6 5.6 0 0 0 -.367 .874l-.082 .269l-.028 .11a1 1 0 0 1 -1.95 -.444a7.3 7.3 0 0 1 .66 -1.747q .158 -.298 .337 -.561a6.4 6.4 0 0 1 -.93 -.508a4 4 0 0 1 -.256 .43c-.366 .541 -.855 .98 -1.473 1.267l-.238 .1c-.994 .382 -1.97 .292 -2.855 -.091l-.188 -.087a3.8 3.8 0 0 1 -.716 -.443a1 1 0 0 1 -.356 -.917a3.95 3.95 0 0 1 .654 -1.613a3.6 3.6 0 0 1 1.71 -1.368c.38 -.146 .758 -.223 1.13 -.24a9 9 0 0 1 -.445 -1.023a4.23 4.23 0 0 1 -2.233 -.348a4 4 0 0 1 -.916 -.587l-.207 -.191a4 4 0 0 1 -.724 -.977l-.105 -.216a4.45 4.45 0 0 1 -.265 -2.806a1 1 0 0 1 .69 -.712q .119 -.036 .345 -.076c.801 -.135 1.678 -.082 2.53 .308q .283 .129 .545 .304q .048 -.235 .112 -.47a5 5 0 0 1 -.194 -.272c-.556 -.832 -.83 -1.806 -.642 -2.877l.05 -.242a3.75 3.75 0 0 1 1.027 -1.803l.169 -.159a4 4 0 0 1 1.303 -.796a1 1 0 0 1 .975 .178c.2 .168 .462 .446 .719 .83c.556 .833 .83 1.807 .642 2.878a3.77 3.77 0 0 1 -1.246 2.204c-.303 .27 -.607 .47 -.879 .61a7.5 7.5 0 0 0 -.255 1.971c0 3.502 2.285 6.272 5 6.272s5 -2.77 5 -6.276a7.6 7.6 0 0 0 -.253 -1.967a4.3 4.3 0 0 1 -.881 -.61a3.77 3.77 0 0 1 -1.246 -2.204c-.188 -1.07 .086 -2.045 .642 -2.877c.257 -.385 .52 -.663 .72 -.831a1 1 0 0 1 .974 -.178m-4.356 4.943a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-1v1h2a1 1 0 0 1 0 2h-2a2 2 0 0 1 -2 -2v-1a2 2 0 0 1 2 -2h1v-1h-2a1 1 0 0 1 0 -2z\" />"),
    LAUREL_WREATH_3(
        "laurel-wreath-3",
        "<path d=\"M16.956 2.057c.355 .124 .829 .375 1.303 .796a3.77 3.77 0 0 1 1.246 2.204c.173 .989 -.047 1.894 -.519 2.683l-.123 .194q -.097 .147 -.196 .272q .066 .234 .117 .471q .26 -.178 .545 -.307c.851 -.389 1.727 -.442 2.527 -.306q .226 .04 .346 .076a1 1 0 0 1 .689 .712l.029 .13q .015 .08 .03 .18a4.45 4.45 0 0 1 -.324 2.496a3.94 3.94 0 0 1 -1.71 1.85l-.242 .12a4.23 4.23 0 0 1 -2.234 .349a9 9 0 0 1 -.443 1.023c.37 .016 .748 .093 1.128 .24c.732 .28 1.299 .758 1.711 1.367a3.95 3.95 0 0 1 .654 1.613a1 1 0 0 1 -.356 .917a3.8 3.8 0 0 1 -.716 .443c-.933 .455 -1.978 .588 -3.043 .179l-.032 -.015l-.205 -.086a3.6 3.6 0 0 1 -1.33 -1.069l-.143 -.197a4 4 0 0 1 -.26 -.433a6 6 0 0 1 -.927 .511q .18 .262 .337 .56a7.4 7.4 0 0 1 .66 1.747a1 1 0 0 1 -1.95 .444l-.028 -.11a6 6 0 0 0 -.449 -1.143c-.342 -.645 -.71 -.968 -1.048 -.968s-.706 .323 -1.048 .969a5.6 5.6 0 0 0 -.367 .874l-.082 .269l-.028 .11a1 1 0 0 1 -1.95 -.444a7.3 7.3 0 0 1 .66 -1.747q .158 -.298 .337 -.561a6.4 6.4 0 0 1 -.93 -.508a4 4 0 0 1 -.256 .43c-.366 .541 -.855 .98 -1.473 1.267l-.238 .1c-.994 .382 -1.97 .292 -2.855 -.091l-.188 -.087a3.8 3.8 0 0 1 -.716 -.443a1 1 0 0 1 -.356 -.917a3.95 3.95 0 0 1 .654 -1.613a3.6 3.6 0 0 1 1.71 -1.368c.38 -.146 .758 -.223 1.13 -.24a9 9 0 0 1 -.445 -1.023a4.23 4.23 0 0 1 -2.233 -.348a4 4 0 0 1 -.916 -.587l-.207 -.191a4 4 0 0 1 -.724 -.977l-.105 -.216a4.45 4.45 0 0 1 -.265 -2.806a1 1 0 0 1 .69 -.712q .119 -.036 .345 -.076c.801 -.135 1.678 -.082 2.53 .308q .283 .129 .545 .304q .048 -.235 .112 -.47a5 5 0 0 1 -.194 -.272c-.556 -.832 -.83 -1.806 -.642 -2.877l.05 -.242a3.75 3.75 0 0 1 1.027 -1.803l.169 -.159a4 4 0 0 1 1.303 -.796a1 1 0 0 1 .975 .178c.2 .168 .462 .446 .719 .83c.556 .833 .83 1.807 .642 2.878a3.77 3.77 0 0 1 -1.246 2.204c-.303 .27 -.607 .47 -.879 .61a7.5 7.5 0 0 0 -.255 1.971c0 3.502 2.285 6.272 5 6.272s5 -2.77 5 -6.276a7.6 7.6 0 0 0 -.253 -1.967a4.3 4.3 0 0 1 -.881 -.61a3.77 3.77 0 0 1 -1.246 -2.204c-.188 -1.07 .086 -2.045 .642 -2.877c.257 -.385 .52 -.663 .72 -.831a1 1 0 0 1 .974 -.178m-4.956 4.943a2.5 2.5 0 0 1 2.125 3.817l-.125 .183l.019 .024c.273 .372 .445 .823 .477 1.312l.005 .164a2.5 2.5 0 0 1 -2.501 2.5h-1.5a1 1 0 0 1 0 -2h1.5a.5 .5 0 1 0 0 -1h-1l-.133 -.007c-1.199 -.129 -1.154 -1.993 .133 -1.993h1l.09 -.008a.5 .5 0 0 0 -.09 -.992h-1.5a1 1 0 1 1 0 -2z\" />"),
    LAYOUT(
        "layout",
        "<path d=\"M8 3a3 3 0 0 1 3 3v1a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-1a3 3 0 0 1 3 -3z\" />\n  <path d=\"M8 12a3 3 0 0 1 3 3v3a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-3a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_2(
        "layout-2",
        "<path d=\"M8 3a3 3 0 0 1 3 3v1a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-1a3 3 0 0 1 3 -3z\" />\n  <path d=\"M8 12a3 3 0 0 1 3 3v3a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-3a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 3a3 3 0 0 1 3 3v3a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-3a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 14a3 3 0 0 1 3 3v1a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-1a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_ALIGN_BOTTOM(
        "layout-align-bottom",
        "<path d=\"M20 19a1 1 0 0 1 0 2h-16a1 1 0 0 1 0 -2z\" />\n  <path d=\"M13 3a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_ALIGN_CENTER(
        "layout-align-center",
        "<path d=\"M12 3a1 1 0 0 1 1 1v4h3a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-3v4a1 1 0 0 1 -2 0v-4h-3a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3h3v-4a1 1 0 0 1 1 -1\" />"),
    LAYOUT_ALIGN_LEFT(
        "layout-align-left",
        "<path d=\"M4 3a1 1 0 0 1 1 1v16a1 1 0 0 1 -2 0v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M18 8a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_ALIGN_MIDDLE(
        "layout-align-middle",
        "<path d=\"M13 5a3 3 0 0 1 3 3v3h4a1 1 0 0 1 0 2h-4v3a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-3h-4a1 1 0 0 1 0 -2h4v-3a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_ALIGN_RIGHT(
        "layout-align-right",
        "<path d=\"M20 3a1 1 0 0 1 1 1v16a1 1 0 0 1 -2 0v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M14 8a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_ALIGN_TOP(
        "layout-align-top",
        "<path d=\"M20 3a1 1 0 0 1 0 2h-16a1 1 0 1 1 0 -2z\" />\n  <path d=\"M13 7a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_BOARD(
        "layout-board",
        "<path d=\"M5 3h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-2a2 2 0 0 1 2 -2\" />\n  <path d=\"M14 3h5a2 2 0 0 1 2 2v8a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-9a1 1 0 0 1 1 -1\" />\n  <path d=\"M14 16h6a1 1 0 0 1 1 1v2a2 2 0 0 1 -2 2h-5a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 10h6a1 1 0 0 1 1 1v9a1 1 0 0 1 -1 1h-5a2 2 0 0 1 -2 -2v-8a1 1 0 0 1 1 -1\" />"),
    LAYOUT_BOARD_SPLIT(
        "layout-board-split",
        "<path d=\"M5 3h5a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-5a2 2 0 0 1 2 -2\" />\n  <path d=\"M14 3h5a2 2 0 0 1 2 2v2a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1\" />\n  <path d=\"M13 11a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1z\" />\n  <path d=\"M14 16h6a1 1 0 0 1 1 1v2a2 2 0 0 1 -2 2h-5a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 13h6a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-5a2 2 0 0 1 -2 -2v-5a1 1 0 0 1 1 -1\" />"),
    LAYOUT_BOTTOMBAR(
        "layout-bottombar",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm0 2h-12a1 1 0 0 0 -.993 .883l-.007 .117v9h14v-9a1 1 0 0 0 -.883 -.993l-.117 -.007z\" />"),
    LAYOUT_BOTTOMBAR_COLLAPSE(
        "layout-bottombar-collapse",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm0 2h-12a1 1 0 0 0 -.993 .883l-.007 .117v9h14v-9a1 1 0 0 0 -.883 -.993l-.117 -.007zm-7.387 3.21l.094 .083l1.293 1.292l1.293 -1.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-2 2a1 1 0 0 1 -1.32 .083l-.094 -.083l-2 -2a1 1 0 0 1 1.32 -1.497z\" />"),
    LAYOUT_BOTTOMBAR_EXPAND(
        "layout-bottombar-expand",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm0 2h-12a1 1 0 0 0 -.993 .883l-.007 .117v9h14v-9a1 1 0 0 0 -.883 -.993l-.117 -.007zm-5.387 3.21l.094 .083l2 2a1 1 0 0 1 -1.32 1.497l-.094 -.083l-1.293 -1.292l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l2 -2a1 1 0 0 1 1.32 -.083z\" />"),
    LAYOUT_CARDS(
        "layout-cards",
        "<path d=\"M8 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 3a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_DASHBOARD(
        "layout-dashboard",
        "<path d=\"M9 3a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2zm0 12a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-2a2 2 0 0 1 2 -2zm10 -4a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2zm0 -8a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-2a2 2 0 0 1 2 -2z\" />"),
    LAYOUT_DISTRIBUTE_HORIZONTAL(
        "layout-distribute-horizontal",
        "<path d=\"M20 3a1 1 0 0 1 0 2h-16a1 1 0 1 1 0 -2z\" />\n  <path d=\"M20 19a1 1 0 0 1 0 2h-16a1 1 0 0 1 0 -2z\" />\n  <path d=\"M16 8a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_DISTRIBUTE_VERTICAL(
        "layout-distribute-vertical",
        "<path d=\"M4 3a1 1 0 0 1 1 1v16a1 1 0 0 1 -2 0v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 3a1 1 0 0 1 1 1v16a1 1 0 0 1 -2 0v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M13 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_GRID(
        "layout-grid",
        "<path d=\"M9 3a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2z\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2z\" />\n  <path d=\"M9 13a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2z\" />\n  <path d=\"M19 13a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2z\" />"),
    LAYOUT_KANBAN(
        "layout-kanban",
        "<path d=\"M10 3a1 1 0 0 1 0 2h-6a1 1 0 1 1 0 -2z\" />\n  <path d=\"M20 3a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2z\" />\n  <path d=\"M8 7a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 7a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-2a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<path d=\"M18 3a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 13a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3z\" />"),
    LAYOUT_NAVBAR(
        "layout-navbar",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm1 6h-14v9a1 1 0 0 0 .883 .993l.117 .007h12a1 1 0 0 0 .993 -.883l.007 -.117v-9z\" />"),
    LAYOUT_NAVBAR_COLLAPSE(
        "layout-navbar-collapse",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm1 6h-14v9a1 1 0 0 0 .883 .993l.117 .007h12a1 1 0 0 0 .993 -.883l.007 -.117v-9zm-6.387 3.21l.094 .083l2 2a1 1 0 0 1 -1.32 1.497l-.094 -.083l-1.293 -1.292l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l2 -2a1 1 0 0 1 1.32 -.083z\" />"),
    LAYOUT_NAVBAR_EXPAND(
        "layout-navbar-expand",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm1 6h-14v9a1 1 0 0 0 .883 .993l.117 .007h12a1 1 0 0 0 .993 -.883l.007 -.117v-9zm-8.387 3.21l.094 .083l1.293 1.292l1.293 -1.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-2 2a1 1 0 0 1 -1.32 .083l-.094 -.083l-2 -2a1 1 0 0 1 1.32 -1.497z\" />"),
    LAYOUT_SIDEBAR(
        "layout-sidebar",
        "<path d=\"M6 21a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3zm12 -16h-8v14h8a1 1 0 0 0 1 -1v-12a1 1 0 0 0 -1 -1\" />"),
    LAYOUT_SIDEBAR_LEFT_COLLAPSE(
        "layout-sidebar-left-collapse",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm0 2h-9v14h9a1 1 0 0 0 .993 -.883l.007 -.117v-12a1 1 0 0 0 -.883 -.993l-.117 -.007zm-2.293 4.293a1 1 0 0 1 .083 1.32l-.083 .094l-1.292 1.293l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.32 .083l-.094 -.083l-2 -2a1 1 0 0 1 -.083 -1.32l.083 -.094l2 -2a1 1 0 0 1 1.414 0z\" />"),
    LAYOUT_SIDEBAR_LEFT_EXPAND(
        "layout-sidebar-left-expand",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm0 2h-9v14h9a1 1 0 0 0 .993 -.883l.007 -.117v-12a1 1 0 0 0 -.883 -.993l-.117 -.007zm-4.387 4.21l.094 .083l2 2a1 1 0 0 1 .083 1.32l-.083 .094l-2 2a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.292 -1.293l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083z\" />"),
    LAYOUT_SIDEBAR_RIGHT(
        "layout-sidebar-right",
        "<path d=\"M6 21a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3zm8 -16h-8a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8z\" />"),
    LAYOUT_SIDEBAR_RIGHT_COLLAPSE(
        "layout-sidebar-right-collapse",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm-3 2h-9a1 1 0 0 0 -.993 .883l-.007 .117v12a1 1 0 0 0 .883 .993l.117 .007h9v-14zm-5.387 4.21l.094 .083l2 2a1 1 0 0 1 .083 1.32l-.083 .094l-2 2a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.292 -1.293l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083z\" />"),
    LAYOUT_SIDEBAR_RIGHT_EXPAND(
        "layout-sidebar-right-expand",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm-3 2h-9a1 1 0 0 0 -.993 .883l-.007 .117v12a1 1 0 0 0 .883 .993l.117 .007h9v-14zm-3.293 4.293a1 1 0 0 1 .083 1.32l-.083 .094l-1.292 1.293l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.32 .083l-.094 -.083l-2 -2a1 1 0 0 1 -.083 -1.32l.083 -.094l2 -2a1 1 0 0 1 1.414 0z\" />"),
    MAGNET(
        "magnet",
        "<path d=\"M21 9v4a9 9 0 0 1 -18 0v-4h7v4a2 2 0 1 0 4 0v-4zm-3 -7a3 3 0 0 1 3 3v2h-7v-2a3 3 0 0 1 3 -3zm-11 0a3 3 0 0 1 3 3v2h-7v-2a3 3 0 0 1 3 -3z\" />"),
    MICKEY(
        "mickey",
        "<path d=\"M18.501 2a4.5 4.5 0 0 1 .878 8.913a8 8 0 1 1 -15.374 3.372l-.005 -.285l.005 -.285a7.991 7.991 0 0 1 .615 -2.803a4.5 4.5 0 0 1 -3.187 -6.348a4.505 4.505 0 0 1 3.596 -2.539l.225 -.018l.281 -.007l.244 .009a4.5 4.5 0 0 1 4.215 4.247a8.001 8.001 0 0 1 4.013 0a4.5 4.5 0 0 1 4.493 -4.256z\" />"),
    PAINT(
        "paint",
        "<path d=\"M17 2a3 3 0 0 1 2.995 2.824l.005 .176a3 3 0 0 1 3 3a6 6 0 0 1 -5.775 5.996l-.225 .004h-4l.15 .005a2 2 0 0 1 1.844 1.838l.006 .157v4a2 2 0 0 1 -1.85 1.995l-.15 .005h-2a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-4a2 2 0 0 1 1.85 -1.995l.15 -.005v-1a1 1 0 0 1 .883 -.993l.117 -.007h5a4 4 0 0 0 4 -4a1 1 0 0 0 -.883 -.993l-.117 -.007l-.005 .176a3 3 0 0 1 -2.819 2.819l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-2a3 3 0 0 1 2.824 -2.995l.176 -.005h10z\" />"),
    PALETTE(
        "palette",
        "<path d=\"M12 2c5.498 0 10 4.002 10 9c0 1.351 -.6 2.64 -1.654 3.576c-1.03 .914 -2.412 1.424 -3.846 1.424h-2.516a1 1 0 0 0 -.5 1.875a1 1 0 0 1 .194 .14a2.3 2.3 0 0 1 -1.597 3.99l-.156 -.009l.068 .004l-.273 -.004c-5.3 -.146 -9.57 -4.416 -9.716 -9.716l-.004 -.28c0 -5.523 4.477 -10 10 -10m-3.5 6.5a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m8 0a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m-4 -3a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2\" />"),
    PENCIL(
        "pencil",
        "<path d=\"M12.085 6.5l5.415 5.415l-8.793 8.792a1 1 0 0 1 -.707 .293h-4a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 .293 -.707zm5.406 -2.698a3.828 3.828 0 0 1 1.716 6.405l-.292 .293l-5.415 -5.415l.293 -.292a3.83 3.83 0 0 1 3.698 -.991\" />"),
    SECTION(
        "section",
        "<path d=\"M20.01 19a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm-16 0a1 1 0 0 1 0 2a1 1 0 0 1 -.127 -1.993m4 0a1 1 0 0 1 0 2a1 1 0 0 1 -.127 -1.993m4 0a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm4 0a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm4 -16a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm-16 0a1 1 0 1 1 0 2a1 1 0 0 1 -.127 -1.993m4 0a1 1 0 1 1 0 2a1 1 0 0 1 -.127 -1.993m4 0a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm3.99 0a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m3 4a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2z\" />"),
    SPARKLES_2(
        "sparkles-2",
        "<path d=\"M17.964 2.733c.156 .563 .312 1 .484 1.353c.342 .71 .758 1.125 1.47 1.467c.353 .17 .79 .326 1.352 .484c.98 .276 .97 1.668 -.013 1.93a8.3 8.3 0 0 0 -1.34 .481c-.71 .342 -1.127 .757 -1.463 1.453a8 8 0 0 0 -.486 1.352c-.258 .988 -1.658 1 -1.932 .015c-.156 -.565 -.312 -1.002 -.484 -1.354c-.342 -.71 -.758 -1.124 -1.458 -1.46a8 8 0 0 0 -1.374 -.495a.4 .4 0 0 1 -.06 -.02l-.044 -.017l-.045 -.02l-.049 -.025l-.035 -.02a.4 .4 0 0 1 -.049 -.03l-.032 -.023l-.043 -.034l-.033 -.028l-.036 -.035l-.034 -.035l-.028 -.033l-.035 -.043l-.022 -.032a.4 .4 0 0 1 -.032 -.049l-.02 -.035l-.025 -.05l-.02 -.044l-.017 -.043a.4 .4 0 0 1 -.02 -.06l-.01 -.034a.5 .5 0 0 1 -.02 -.098l-.006 -.065l-.005 -.035v-.05a.4 .4 0 0 1 .003 -.085a.5 .5 0 0 1 .013 -.093a.5 .5 0 0 1 .024 -.103a.4 .4 0 0 1 .02 -.06l.017 -.044l.02 -.045l.025 -.049l.02 -.035a.4 .4 0 0 1 .03 -.049l.023 -.032l.034 -.043l.028 -.033l.035 -.036l.035 -.034q .015 -.015 .033 -.028l.043 -.035l.032 -.022a.4 .4 0 0 1 .049 -.032l.035 -.02l.05 -.025l.044 -.02l.043 -.017a.4 .4 0 0 1 .06 -.02l.027 -.008a8.3 8.3 0 0 0 1.339 -.48c.71 -.342 1.127 -.757 1.47 -1.466c.17 -.354 .327 -.792 .483 -1.355c.272 -.976 1.657 -.976 1.928 0\" />\n  <path d=\"M10.965 6.737q .219 .801 .503 1.574c.856 2.28 1.945 3.363 4.23 4.22q .708 .265 1.571 .506c.976 .272 .974 1.656 -.002 1.927q -.798 .221 -1.568 .504c-2.288 .858 -3.376 1.94 -4.229 4.216a19 19 0 0 0 -.505 1.579c-.268 .983 -1.662 .983 -1.93 0a19 19 0 0 0 -.503 -1.574c-.856 -2.281 -1.944 -3.363 -4.226 -4.219a20 20 0 0 0 -1.594 -.513a.4 .4 0 0 1 -.054 -.018l-.044 -.017l-.043 -.02a.3 .3 0 0 1 -.048 -.024l-.036 -.02a.4 .4 0 0 1 -.048 -.03l-.032 -.024l-.044 -.034l-.033 -.029l-.037 -.034l-.034 -.037l-.03 -.033l-.033 -.044l-.023 -.032a.4 .4 0 0 1 -.03 -.048l-.021 -.036a.3 .3 0 0 1 -.024 -.048l-.02 -.043l-.017 -.044a.4 .4 0 0 1 -.018 -.054a.2 .2 0 0 1 -.01 -.039a.4 .4 0 0 1 -.014 -.059l-.007 -.04l-.007 -.056l-.003 -.044l-.002 -.05v-.05q 0 -.023 .004 -.044q .001 -.03 .007 -.057l.007 -.04a.4 .4 0 0 1 .017 -.076l.007 -.021a.4 .4 0 0 1 .018 -.054l.017 -.044l.02 -.043a.3 .3 0 0 1 .024 -.048l.02 -.036a.4 .4 0 0 1 .03 -.048l.024 -.032l.034 -.044l.029 -.033l.034 -.037l.037 -.034l.033 -.03l.044 -.033l.032 -.023a.4 .4 0 0 1 .048 -.03l.036 -.021a.3 .3 0 0 1 .048 -.024l.043 -.02l.044 -.017a.4 .4 0 0 1 .054 -.018l.021 -.007a20 20 0 0 0 1.568 -.504c2.287 -.858 3.375 -1.94 4.229 -4.216a19 19 0 0 0 .505 -1.579c.268 -.983 1.662 -.983 1.93 0\" />"),
    SQUARES(
        "squares",
        "<path d=\"M19 7a3 3 0 0 1 3 3v9a3 3 0 0 1 -3 3h-9a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3z\" />\n  <path d=\"M14 2a3 3 0 0 1 3 2.999l-7 .001a5 5 0 0 0 -5 5l-.001 7l-.175 -.005a3 3 0 0 1 -2.824 -2.995v-9a3 3 0 0 1 3 -3z\" />"),
    STACK(
        "stack",
        "<path d=\"M20.894 13.553a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.553 3.774l7.554 -3.775a1 1 0 0 1 1.341 .447m-8.887 -8.552q .056 0 .111 .007l.111 .02l.086 .024l.012 .006l.012 .002l.029 .014l.05 .019l.016 .009l.012 .005l8 4a1 1 0 0 1 0 1.788l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 0 -1.788l8 -4l.011 -.005l.018 -.01l.078 -.032l.011 -.002l.013 -.006l.086 -.024l.11 -.02l.056 -.005z\" />"),
    STACK_2(
        "stack-2",
        "<path d=\"M20.894 15.553a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.553 3.774l7.554 -3.775a1 1 0 0 1 1.341 .447m0 -4a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.552 3.775l7.554 -3.775a1 1 0 0 1 1.341 .447m-8.887 -8.552q .056 0 .111 .007l.111 .02l.086 .024l.012 .006l.012 .002l.029 .014l.05 .019l.016 .009l.012 .005l8 4a1 1 0 0 1 0 1.788l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 0 -1.788l8 -4l.011 -.005l.018 -.01l.078 -.032l.011 -.002l.013 -.006l.086 -.024l.11 -.02l.056 -.005z\" />"),
    STACK_3(
        "stack-3",
        "<path d=\"M20.894 17.553a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.553 3.774l7.554 -3.775a1 1 0 0 1 1.341 .447m0 -4a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.552 3.775l7.554 -3.775a1 1 0 0 1 1.341 .447m0 -4a1 1 0 0 1 -.447 1.341l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 .894 -1.788l7.552 3.775l7.554 -3.775a1 1 0 0 1 1.341 .447m-8.887 -8.552q .056 0 .111 .007l.111 .02l.086 .024l.012 .006l.012 .002l.029 .014l.05 .019l.016 .009l.012 .005l8 4a1 1 0 0 1 0 1.788l-8 4a1 1 0 0 1 -.894 0l-8 -4a1 1 0 0 1 0 -1.788l8 -4l.011 -.005l.018 -.01l.078 -.032l.011 -.002l.013 -.006l.086 -.024l.11 -.02l.056 -.005z\" />"),
    TEMPLATE(
        "template",
        "<path d=\"M19 3a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-2a2 2 0 0 1 2 -2z\" />\n  <path d=\"M9 11a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2z\" />\n  <path d=\"M20 11a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2z\" />\n  <path d=\"M20 15a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2z\" />\n  <path d=\"M20 19a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2z\" />");

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

  default TablerIcon ad() {
    return TablerIcon.create(TablerDesign.OutlineIcon.AD);
  }

  default TablerIcon ad_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.AD_2);
  }

  default TablerIcon ad_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.AD_OFF);
  }

  default TablerIcon angle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.ANGLE);
  }

  default TablerIcon artboard() {
    return TablerIcon.create(TablerDesign.OutlineIcon.ARTBOARD);
  }

  default TablerIcon artboard_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.ARTBOARD_OFF);
  }

  default TablerIcon background() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BACKGROUND);
  }

  default TablerIcon barrel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BARREL);
  }

  default TablerIcon barrel_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BARREL_OFF);
  }

  default TablerIcon barrier_block() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BARRIER_BLOCK);
  }

  default TablerIcon barrier_block_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BARRIER_BLOCK_OFF);
  }

  default TablerIcon binoculars() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BINOCULARS);
  }

  default TablerIcon blade() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BLADE);
  }

  default TablerIcon blend_mode() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BLEND_MODE);
  }

  default TablerIcon blur() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BLUR);
  }

  default TablerIcon blur_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BLUR_OFF);
  }

  default TablerIcon bolt() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOLT);
  }

  default TablerIcon bolt_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOLT_OFF);
  }

  default TablerIcon bomb() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOMB);
  }

  default TablerIcon bong() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BONG);
  }

  default TablerIcon bong_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BONG_OFF);
  }

  default TablerIcon boom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOOM);
  }

  default TablerIcon border_all() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_ALL);
  }

  default TablerIcon border_bottom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_BOTTOM);
  }

  default TablerIcon border_bottom_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_BOTTOM_PLUS);
  }

  default TablerIcon border_corner_pill() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_CORNER_PILL);
  }

  default TablerIcon border_corner_rounded() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_CORNER_ROUNDED);
  }

  default TablerIcon border_corner_square() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_CORNER_SQUARE);
  }

  default TablerIcon border_corners() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_CORNERS);
  }

  default TablerIcon border_horizontal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_HORIZONTAL);
  }

  default TablerIcon border_inner() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_INNER);
  }

  default TablerIcon border_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_LEFT);
  }

  default TablerIcon border_left_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_LEFT_PLUS);
  }

  default TablerIcon border_none() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_NONE);
  }

  default TablerIcon border_outer() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_OUTER);
  }

  default TablerIcon border_radius() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_RADIUS);
  }

  default TablerIcon border_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_RIGHT);
  }

  default TablerIcon border_right_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_RIGHT_PLUS);
  }

  default TablerIcon border_sides() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_SIDES);
  }

  default TablerIcon border_style() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_STYLE);
  }

  default TablerIcon border_style_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_STYLE_2);
  }

  default TablerIcon border_top() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_TOP);
  }

  default TablerIcon border_top_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_TOP_PLUS);
  }

  default TablerIcon border_vertical() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_VERTICAL);
  }

  default TablerIcon bounce_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOUNCE_LEFT);
  }

  default TablerIcon bounce_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOUNCE_RIGHT);
  }

  default TablerIcon box() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX);
  }

  default TablerIcon box_align_bottom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_BOTTOM);
  }

  default TablerIcon box_align_bottom_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_BOTTOM_LEFT);
  }

  default TablerIcon box_align_bottom_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_BOTTOM_RIGHT);
  }

  default TablerIcon box_align_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_LEFT);
  }

  default TablerIcon box_align_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_RIGHT);
  }

  default TablerIcon box_align_top() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_TOP);
  }

  default TablerIcon box_align_top_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_TOP_LEFT);
  }

  default TablerIcon box_align_top_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_ALIGN_TOP_RIGHT);
  }

  default TablerIcon box_margin() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MARGIN);
  }

  default TablerIcon box_model() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MODEL);
  }

  default TablerIcon box_model_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MODEL_2);
  }

  default TablerIcon box_model_2_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MODEL_2_OFF);
  }

  default TablerIcon box_model_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MODEL_OFF);
  }

  default TablerIcon box_multiple() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_MULTIPLE);
  }

  default TablerIcon box_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_OFF);
  }

  default TablerIcon box_padding() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BOX_PADDING);
  }

  default TablerIcon brackets_angle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRACKETS_ANGLE);
  }

  default TablerIcon brackets_angle_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRACKETS_ANGLE_OFF);
  }

  default TablerIcon briefcase() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRIEFCASE);
  }

  default TablerIcon briefcase_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRIEFCASE_2);
  }

  default TablerIcon briefcase_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRIEFCASE_OFF);
  }

  default TablerIcon brush() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRUSH);
  }

  default TablerIcon brush_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BRUSH_OFF);
  }

  default TablerIcon bucket() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BUCKET);
  }

  default TablerIcon bucket_droplet() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BUCKET_DROPLET);
  }

  default TablerIcon bucket_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BUCKET_OFF);
  }

  default TablerIcon bulb() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BULB);
  }

  default TablerIcon bulb_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.BULB_OFF);
  }

  default TablerIcon candle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CANDLE);
  }

  default TablerIcon cap_projecting() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CAP_PROJECTING);
  }

  default TablerIcon cap_rounded() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CAP_ROUNDED);
  }

  default TablerIcon cap_straight() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CAP_STRAIGHT);
  }

  default TablerIcon cards() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CARDS);
  }

  default TablerIcon carousel_horizontal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CAROUSEL_HORIZONTAL);
  }

  default TablerIcon carousel_vertical() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CAROUSEL_VERTICAL);
  }

  default TablerIcon cell() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CELL);
  }

  default TablerIcon chair_director() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CHAIR_DIRECTOR);
  }

  default TablerIcon chisel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CHISEL);
  }

  default TablerIcon christmas_ball() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CHRISTMAS_BALL);
  }

  default TablerIcon coffin() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COFFIN);
  }

  default TablerIcon color_filter() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_FILTER);
  }

  default TablerIcon color_picker() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_PICKER);
  }

  default TablerIcon color_picker_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_PICKER_OFF);
  }

  default TablerIcon color_swatch() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_SWATCH);
  }

  default TablerIcon color_swatch_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_SWATCH_OFF);
  }

  default TablerIcon components() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COMPONENTS);
  }

  default TablerIcon components_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COMPONENTS_OFF);
  }

  default TablerIcon confetti() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CONFETTI);
  }

  default TablerIcon confetti_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CONFETTI_OFF);
  }

  default TablerIcon container() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CONTAINER);
  }

  default TablerIcon container_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CONTAINER_OFF);
  }

  default TablerIcon cookie_man() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COOKIE_MAN);
  }

  default TablerIcon crop() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP);
  }

  default TablerIcon crop_1_1() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_1_1);
  }

  default TablerIcon crop_16_9() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_16_9);
  }

  default TablerIcon crop_3_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_3_2);
  }

  default TablerIcon crop_5_4() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_5_4);
  }

  default TablerIcon crop_7_5() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_7_5);
  }

  default TablerIcon crop_landscape() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_LANDSCAPE);
  }

  default TablerIcon crop_portrait() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROP_PORTRAIT);
  }

  default TablerIcon crown() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROWN);
  }

  default TablerIcon crown_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CROWN_OFF);
  }

  default TablerIcon cut() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CUT);
  }

  default TablerIcon dimensions() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DIMENSIONS);
  }

  default TablerIcon drag_drop() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DRAG_DROP);
  }

  default TablerIcon drag_drop_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DRAG_DROP_2);
  }

  default TablerIcon droplet() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET);
  }

  default TablerIcon droplet_bolt() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_BOLT);
  }

  default TablerIcon droplet_cancel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_CANCEL);
  }

  default TablerIcon droplet_check() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_CHECK);
  }

  default TablerIcon droplet_code() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_CODE);
  }

  default TablerIcon droplet_cog() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_COG);
  }

  default TablerIcon droplet_dollar() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_DOLLAR);
  }

  default TablerIcon droplet_down() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_DOWN);
  }

  default TablerIcon droplet_exclamation() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_EXCLAMATION);
  }

  default TablerIcon droplet_half() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_HALF);
  }

  default TablerIcon droplet_half_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_HALF_2);
  }

  default TablerIcon droplet_heart() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_HEART);
  }

  default TablerIcon droplet_minus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_MINUS);
  }

  default TablerIcon droplet_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_OFF);
  }

  default TablerIcon droplet_pause() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_PAUSE);
  }

  default TablerIcon droplet_pin() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_PIN);
  }

  default TablerIcon droplet_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_PLUS);
  }

  default TablerIcon droplet_question() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_QUESTION);
  }

  default TablerIcon droplet_search() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_SEARCH);
  }

  default TablerIcon droplet_share() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_SHARE);
  }

  default TablerIcon droplet_star() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_STAR);
  }

  default TablerIcon droplet_up() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_UP);
  }

  default TablerIcon droplet_x() {
    return TablerIcon.create(TablerDesign.OutlineIcon.DROPLET_X);
  }

  default TablerIcon ease_in() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_IN);
  }

  default TablerIcon ease_in_control_point() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_IN_CONTROL_POINT);
  }

  default TablerIcon ease_in_out() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_IN_OUT);
  }

  default TablerIcon ease_in_out_control_points() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_IN_OUT_CONTROL_POINTS);
  }

  default TablerIcon ease_out() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_OUT);
  }

  default TablerIcon ease_out_control_point() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EASE_OUT_CONTROL_POINT);
  }

  default TablerIcon edit() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EDIT);
  }

  default TablerIcon edit_bulk() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EDIT_BULK);
  }

  default TablerIcon edit_circle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EDIT_CIRCLE);
  }

  default TablerIcon edit_circle_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EDIT_CIRCLE_OFF);
  }

  default TablerIcon edit_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.EDIT_OFF);
  }

  default TablerIcon favicon() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FAVICON);
  }

  default TablerIcon flip_horizontal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FLIP_HORIZONTAL);
  }

  default TablerIcon flip_vertical() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FLIP_VERTICAL);
  }

  default TablerIcon frame() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FRAME);
  }

  default TablerIcon frame_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FRAME_OFF);
  }

  default TablerIcon freeze_column() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FREEZE_COLUMN);
  }

  default TablerIcon freeze_row() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FREEZE_ROW);
  }

  default TablerIcon freeze_row_column() {
    return TablerIcon.create(TablerDesign.OutlineIcon.FREEZE_ROW_COLUMN);
  }

  default TablerIcon gizmo() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GIZMO);
  }

  default TablerIcon gradienter() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GRADIENTER);
  }

  default TablerIcon grain() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GRAIN);
  }

  default TablerIcon grid_3x3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GRID_3X3);
  }

  default TablerIcon grid_4x4() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GRID_4X4);
  }

  default TablerIcon grid_goldenratio() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GRID_GOLDENRATIO);
  }

  default TablerIcon guitar_pick() {
    return TablerIcon.create(TablerDesign.OutlineIcon.GUITAR_PICK);
  }

  default TablerIcon hammer() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HAMMER);
  }

  default TablerIcon hammer_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HAMMER_OFF);
  }

  default TablerIcon hash() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HASH);
  }

  default TablerIcon hierarchy() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HIERARCHY);
  }

  default TablerIcon hierarchy_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HIERARCHY_2);
  }

  default TablerIcon hierarchy_3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HIERARCHY_3);
  }

  default TablerIcon hierarchy_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.HIERARCHY_OFF);
  }

  default TablerIcon icosahedron() {
    return TablerIcon.create(TablerDesign.OutlineIcon.ICOSAHEDRON);
  }

  default TablerIcon inner_shadow_bottom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_BOTTOM);
  }

  default TablerIcon inner_shadow_bottom_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_BOTTOM_LEFT);
  }

  default TablerIcon inner_shadow_bottom_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_BOTTOM_RIGHT);
  }

  default TablerIcon inner_shadow_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_LEFT);
  }

  default TablerIcon inner_shadow_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_RIGHT);
  }

  default TablerIcon inner_shadow_top() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_TOP);
  }

  default TablerIcon inner_shadow_top_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_TOP_LEFT);
  }

  default TablerIcon inner_shadow_top_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.INNER_SHADOW_TOP_RIGHT);
  }

  default TablerIcon key() {
    return TablerIcon.create(TablerDesign.OutlineIcon.KEY);
  }

  default TablerIcon key_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.KEY_OFF);
  }

  default TablerIcon ladle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LADLE);
  }

  default TablerIcon lamp() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAMP);
  }

  default TablerIcon lamp_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAMP_2);
  }

  default TablerIcon lamp_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAMP_OFF);
  }

  default TablerIcon lasso() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LASSO);
  }

  default TablerIcon lasso_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LASSO_OFF);
  }

  default TablerIcon lasso_polygon() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LASSO_POLYGON);
  }

  default TablerIcon laurel_wreath() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAUREL_WREATH);
  }

  default TablerIcon laurel_wreath_1() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAUREL_WREATH_1);
  }

  default TablerIcon laurel_wreath_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAUREL_WREATH_2);
  }

  default TablerIcon laurel_wreath_3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAUREL_WREATH_3);
  }

  default TablerIcon layers_difference() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_DIFFERENCE);
  }

  default TablerIcon layers_intersect() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_INTERSECT);
  }

  default TablerIcon layers_intersect_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_INTERSECT_2);
  }

  default TablerIcon layers_linked() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_LINKED);
  }

  default TablerIcon layers_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_OFF);
  }

  default TablerIcon layers_selected() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_SELECTED);
  }

  default TablerIcon layers_selected_bottom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_SELECTED_BOTTOM);
  }

  default TablerIcon layers_subtract() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_SUBTRACT);
  }

  default TablerIcon layers_union() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYERS_UNION);
  }

  default TablerIcon layout() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT);
  }

  default TablerIcon layout_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_2);
  }

  default TablerIcon layout_align_bottom() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_BOTTOM);
  }

  default TablerIcon layout_align_center() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_CENTER);
  }

  default TablerIcon layout_align_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_LEFT);
  }

  default TablerIcon layout_align_middle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_MIDDLE);
  }

  default TablerIcon layout_align_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_RIGHT);
  }

  default TablerIcon layout_align_top() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ALIGN_TOP);
  }

  default TablerIcon layout_board() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_BOARD);
  }

  default TablerIcon layout_board_split() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_BOARD_SPLIT);
  }

  default TablerIcon layout_bottombar() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_BOTTOMBAR);
  }

  default TablerIcon layout_bottombar_collapse() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_BOTTOMBAR_COLLAPSE);
  }

  default TablerIcon layout_bottombar_expand() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_BOTTOMBAR_EXPAND);
  }

  default TablerIcon layout_cards() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_CARDS);
  }

  default TablerIcon layout_collage() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_COLLAGE);
  }

  default TablerIcon layout_columns() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_COLUMNS);
  }

  default TablerIcon layout_dashboard() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_DASHBOARD);
  }

  default TablerIcon layout_distribute_horizontal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_DISTRIBUTE_HORIZONTAL);
  }

  default TablerIcon layout_distribute_vertical() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_DISTRIBUTE_VERTICAL);
  }

  default TablerIcon layout_grid() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_GRID);
  }

  default TablerIcon layout_grid_add() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_GRID_ADD);
  }

  default TablerIcon layout_grid_remove() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_GRID_REMOVE);
  }

  default TablerIcon layout_kanban() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_KANBAN);
  }

  default TablerIcon layout_list() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_LIST);
  }

  default TablerIcon layout_navbar() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_NAVBAR);
  }

  default TablerIcon layout_navbar_collapse() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_NAVBAR_COLLAPSE);
  }

  default TablerIcon layout_navbar_expand() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_NAVBAR_EXPAND);
  }

  default TablerIcon layout_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_OFF);
  }

  default TablerIcon layout_rows() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_ROWS);
  }

  default TablerIcon layout_sidebar() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR);
  }

  default TablerIcon layout_sidebar_left_collapse() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_COLLAPSE);
  }

  default TablerIcon layout_sidebar_left_expand() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_EXPAND);
  }

  default TablerIcon layout_sidebar_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_RIGHT);
  }

  default TablerIcon layout_sidebar_right_collapse() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_RIGHT_COLLAPSE);
  }

  default TablerIcon layout_sidebar_right_expand() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_RIGHT_EXPAND);
  }

  default TablerIcon line() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LINE);
  }

  default TablerIcon line_dashed() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LINE_DASHED);
  }

  default TablerIcon line_dotted() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LINE_DOTTED);
  }

  default TablerIcon magnet() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MAGNET);
  }

  default TablerIcon magnet_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MAGNET_OFF);
  }

  default TablerIcon magnetic() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MAGNETIC);
  }

  default TablerIcon mask() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MASK);
  }

  default TablerIcon mask_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MASK_OFF);
  }

  default TablerIcon mesh() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MESH);
  }

  default TablerIcon mickey() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MICKEY);
  }

  default TablerIcon moustache() {
    return TablerIcon.create(TablerDesign.OutlineIcon.MOUSTACHE);
  }

  default TablerIcon needle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.NEEDLE);
  }

  default TablerIcon needle_thread() {
    return TablerIcon.create(TablerDesign.OutlineIcon.NEEDLE_THREAD);
  }

  default TablerIcon noise_reduction() {
    return TablerIcon.create(TablerDesign.OutlineIcon.NOISE_REDUCTION);
  }

  default TablerIcon paint() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PAINT);
  }

  default TablerIcon paint_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PAINT_OFF);
  }

  default TablerIcon palette() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PALETTE);
  }

  default TablerIcon palette_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PALETTE_OFF);
  }

  default TablerIcon pencil() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL);
  }

  default TablerIcon pencil_ai() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_AI);
  }

  default TablerIcon pencil_bolt() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_BOLT);
  }

  default TablerIcon pencil_cancel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_CANCEL);
  }

  default TablerIcon pencil_check() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_CHECK);
  }

  default TablerIcon pencil_code() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_CODE);
  }

  default TablerIcon pencil_cog() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_COG);
  }

  default TablerIcon pencil_discount() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_DISCOUNT);
  }

  default TablerIcon pencil_dollar() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_DOLLAR);
  }

  default TablerIcon pencil_down() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_DOWN);
  }

  default TablerIcon pencil_exclamation() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_EXCLAMATION);
  }

  default TablerIcon pencil_heart() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_HEART);
  }

  default TablerIcon pencil_minus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_MINUS);
  }

  default TablerIcon pencil_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_OFF);
  }

  default TablerIcon pencil_pause() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_PAUSE);
  }

  default TablerIcon pencil_pin() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_PIN);
  }

  default TablerIcon pencil_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_PLUS);
  }

  default TablerIcon pencil_question() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_QUESTION);
  }

  default TablerIcon pencil_search() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_SEARCH);
  }

  default TablerIcon pencil_share() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_SHARE);
  }

  default TablerIcon pencil_star() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_STAR);
  }

  default TablerIcon pencil_up() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_UP);
  }

  default TablerIcon pencil_x() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENCIL_X);
  }

  default TablerIcon pentagram() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PENTAGRAM);
  }

  default TablerIcon placeholder() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PLACEHOLDER);
  }

  default TablerIcon polygon() {
    return TablerIcon.create(TablerDesign.OutlineIcon.POLYGON);
  }

  default TablerIcon polygon_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.POLYGON_OFF);
  }

  default TablerIcon prong() {
    return TablerIcon.create(TablerDesign.OutlineIcon.PRONG);
  }

  default TablerIcon radius_bottom_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RADIUS_BOTTOM_LEFT);
  }

  default TablerIcon radius_bottom_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RADIUS_BOTTOM_RIGHT);
  }

  default TablerIcon radius_top_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RADIUS_TOP_LEFT);
  }

  default TablerIcon radius_top_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RADIUS_TOP_RIGHT);
  }

  default TablerIcon reference_image() {
    return TablerIcon.create(TablerDesign.OutlineIcon.REFERENCE_IMAGE);
  }

  default TablerIcon resize() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RESIZE);
  }

  default TablerIcon ruler() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER);
  }

  default TablerIcon ruler_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_2);
  }

  default TablerIcon ruler_2_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_2_OFF);
  }

  default TablerIcon ruler_3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_3);
  }

  default TablerIcon ruler_measure() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_MEASURE);
  }

  default TablerIcon ruler_measure_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_MEASURE_2);
  }

  default TablerIcon ruler_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.RULER_OFF);
  }

  default TablerIcon scissors() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SCISSORS);
  }

  default TablerIcon scissors_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SCISSORS_OFF);
  }

  default TablerIcon section() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SECTION);
  }

  default TablerIcon shape() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHAPE);
  }

  default TablerIcon shape_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHAPE_2);
  }

  default TablerIcon shape_3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHAPE_3);
  }

  default TablerIcon shape_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHAPE_OFF);
  }

  default TablerIcon shovel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHOVEL);
  }

  default TablerIcon shovel_pitchforks() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SHOVEL_PITCHFORKS);
  }

  default TablerIcon sketching() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SKETCHING);
  }

  default TablerIcon slice() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SLICE);
  }

  default TablerIcon sparkle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SPARKLE);
  }

  default TablerIcon sparkle_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SPARKLE_2);
  }

  default TablerIcon sparkle_highlight() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SPARKLE_HIGHLIGHT);
  }

  default TablerIcon sparkles_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SPARKLES_2);
  }

  default TablerIcon sparkles_2_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SPARKLES_2_OFF);
  }

  default TablerIcon square_half() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SQUARE_HALF);
  }

  default TablerIcon square_toggle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SQUARE_TOGGLE);
  }

  default TablerIcon square_toggle_horizontal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SQUARE_TOGGLE_HORIZONTAL);
  }

  default TablerIcon squares() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SQUARES);
  }

  default TablerIcon squares_diagonal() {
    return TablerIcon.create(TablerDesign.OutlineIcon.SQUARES_DIAGONAL);
  }

  default TablerIcon stack() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK);
  }

  default TablerIcon stack_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_2);
  }

  default TablerIcon stack_3() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_3);
  }

  default TablerIcon stack_check() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_CHECK);
  }

  default TablerIcon stack_minus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_MINUS);
  }

  default TablerIcon stack_plus() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_PLUS);
  }

  default TablerIcon stack_pop() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_POP);
  }

  default TablerIcon stack_push() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_PUSH);
  }

  default TablerIcon stack_x() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STACK_X);
  }

  default TablerIcon sticker() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STICKER);
  }

  default TablerIcon sticker_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STICKER_2);
  }

  default TablerIcon sticker_smile() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STICKER_SMILE);
  }

  default TablerIcon stroke_curved() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STROKE_CURVED);
  }

  default TablerIcon stroke_dynamic() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STROKE_DYNAMIC);
  }

  default TablerIcon stroke_straight() {
    return TablerIcon.create(TablerDesign.OutlineIcon.STROKE_STRAIGHT);
  }

  default TablerIcon template() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TEMPLATE);
  }

  default TablerIcon template_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TEMPLATE_OFF);
  }

  default TablerIcon text_resize() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TEXT_RESIZE);
  }

  default TablerIcon tools() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TOOLS);
  }

  default TablerIcon tools_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TOOLS_OFF);
  }

  default TablerIcon trident() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TRIDENT);
  }

  default TablerIcon typeface() {
    return TablerIcon.create(TablerDesign.OutlineIcon.TYPEFACE);
  }

  default TablerIcon ux_circle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.UX_CIRCLE);
  }

  default TablerIcon vector() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR);
  }

  default TablerIcon vector_bezier() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_BEZIER);
  }

  default TablerIcon vector_bezier_2() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_BEZIER_2);
  }

  default TablerIcon vector_bezier_arc() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_BEZIER_ARC);
  }

  default TablerIcon vector_bezier_circle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_BEZIER_CIRCLE);
  }

  default TablerIcon vector_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_OFF);
  }

  default TablerIcon vector_spline() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_SPLINE);
  }

  default TablerIcon vector_triangle() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_TRIANGLE);
  }

  default TablerIcon vector_triangle_off() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VECTOR_TRIANGLE_OFF);
  }

  default TablerIcon vignette() {
    return TablerIcon.create(TablerDesign.OutlineIcon.VIGNETTE);
  }

  default TablerIcon wheel() {
    return TablerIcon.create(TablerDesign.OutlineIcon.WHEEL);
  }

  default TablerIcon yarn() {
    return TablerIcon.create(TablerDesign.OutlineIcon.YARN);
  }

  default TablerIcon content_cut() {
    return TablerIcon.create(TablerDesign.OutlineIcon.CUT);
  }

  default TablerIcon dock_left() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_COLLAPSE);
  }

  default TablerIcon dock_right() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_RIGHT_COLLAPSE);
  }

  default TablerIcon format_color_text() {
    return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_SWATCH);
  }

  default TablerIcon menu_open() {
    return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_EXPAND);
  }

  default TablerIcon ad_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.AD);
  }

  default TablerIcon artboard_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.ARTBOARD);
  }

  default TablerIcon barrier_block_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BARRIER_BLOCK);
  }

  default TablerIcon binoculars_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BINOCULARS);
  }

  default TablerIcon blade_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BLADE);
  }

  default TablerIcon bolt_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOLT);
  }

  default TablerIcon bomb_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOMB);
  }

  default TablerIcon bong_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BONG);
  }

  default TablerIcon boom_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOOM);
  }

  default TablerIcon bounce_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOUNCE_LEFT);
  }

  default TablerIcon bounce_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOUNCE_RIGHT);
  }

  default TablerIcon box_align_bottom_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_BOTTOM);
  }

  default TablerIcon box_align_bottom_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_BOTTOM_LEFT);
  }

  default TablerIcon box_align_bottom_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_BOTTOM_RIGHT);
  }

  default TablerIcon box_align_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_LEFT);
  }

  default TablerIcon box_align_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_RIGHT);
  }

  default TablerIcon box_align_top_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_TOP);
  }

  default TablerIcon box_align_top_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_TOP_LEFT);
  }

  default TablerIcon box_align_top_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_ALIGN_TOP_RIGHT);
  }

  default TablerIcon box_multiple_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BOX_MULTIPLE);
  }

  default TablerIcon briefcase_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BRIEFCASE);
  }

  default TablerIcon briefcase_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BRIEFCASE_2);
  }

  default TablerIcon bulb_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.BULB);
  }

  default TablerIcon candle_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CANDLE);
  }

  default TablerIcon cards_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CARDS);
  }

  default TablerIcon carousel_horizontal_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CAROUSEL_HORIZONTAL);
  }

  default TablerIcon carousel_vertical_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CAROUSEL_VERTICAL);
  }

  default TablerIcon confetti_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CONFETTI);
  }

  default TablerIcon container_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CONTAINER);
  }

  default TablerIcon cookie_man_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.COOKIE_MAN);
  }

  default TablerIcon crop_1_1_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_1_1);
  }

  default TablerIcon crop_16_9_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_16_9);
  }

  default TablerIcon crop_3_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_3_2);
  }

  default TablerIcon crop_5_4_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_5_4);
  }

  default TablerIcon crop_7_5_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_7_5);
  }

  default TablerIcon crop_landscape_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_LANDSCAPE);
  }

  default TablerIcon crop_portrait_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROP_PORTRAIT);
  }

  default TablerIcon crown_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.CROWN);
  }

  default TablerIcon droplet_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.DROPLET);
  }

  default TablerIcon droplet_half_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.DROPLET_HALF);
  }

  default TablerIcon droplet_half_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.DROPLET_HALF_2);
  }

  default TablerIcon ease_in_control_point_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.EASE_IN_CONTROL_POINT);
  }

  default TablerIcon ease_in_out_control_points_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.EASE_IN_OUT_CONTROL_POINTS);
  }

  default TablerIcon ease_out_control_point_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.EASE_OUT_CONTROL_POINT);
  }

  default TablerIcon edit_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.EDIT);
  }

  default TablerIcon favicon_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.FAVICON);
  }

  default TablerIcon guitar_pick_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.GUITAR_PICK);
  }

  default TablerIcon inner_shadow_bottom_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_BOTTOM);
  }

  default TablerIcon inner_shadow_bottom_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_BOTTOM_LEFT);
  }

  default TablerIcon inner_shadow_bottom_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_BOTTOM_RIGHT);
  }

  default TablerIcon inner_shadow_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_LEFT);
  }

  default TablerIcon inner_shadow_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_RIGHT);
  }

  default TablerIcon inner_shadow_top_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_TOP);
  }

  default TablerIcon inner_shadow_top_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_TOP_LEFT);
  }

  default TablerIcon inner_shadow_top_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.INNER_SHADOW_TOP_RIGHT);
  }

  default TablerIcon key_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.KEY);
  }

  default TablerIcon lasso_polygon_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LASSO_POLYGON);
  }

  default TablerIcon laurel_wreath_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAUREL_WREATH);
  }

  default TablerIcon laurel_wreath_1_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAUREL_WREATH_1);
  }

  default TablerIcon laurel_wreath_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAUREL_WREATH_2);
  }

  default TablerIcon laurel_wreath_3_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAUREL_WREATH_3);
  }

  default TablerIcon layout_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT);
  }

  default TablerIcon layout_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_2);
  }

  default TablerIcon layout_align_bottom_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_BOTTOM);
  }

  default TablerIcon layout_align_center_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_CENTER);
  }

  default TablerIcon layout_align_left_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_LEFT);
  }

  default TablerIcon layout_align_middle_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_MIDDLE);
  }

  default TablerIcon layout_align_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_RIGHT);
  }

  default TablerIcon layout_align_top_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_ALIGN_TOP);
  }

  default TablerIcon layout_board_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_BOARD);
  }

  default TablerIcon layout_board_split_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_BOARD_SPLIT);
  }

  default TablerIcon layout_bottombar_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_BOTTOMBAR);
  }

  default TablerIcon layout_bottombar_collapse_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_BOTTOMBAR_COLLAPSE);
  }

  default TablerIcon layout_bottombar_expand_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_BOTTOMBAR_EXPAND);
  }

  default TablerIcon layout_cards_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_CARDS);
  }

  default TablerIcon layout_dashboard_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_DASHBOARD);
  }

  default TablerIcon layout_distribute_horizontal_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_DISTRIBUTE_HORIZONTAL);
  }

  default TablerIcon layout_distribute_vertical_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_DISTRIBUTE_VERTICAL);
  }

  default TablerIcon layout_grid_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_GRID);
  }

  default TablerIcon layout_kanban_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_KANBAN);
  }

  default TablerIcon layout_list_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_LIST);
  }

  default TablerIcon layout_navbar_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_NAVBAR);
  }

  default TablerIcon layout_navbar_collapse_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_NAVBAR_COLLAPSE);
  }

  default TablerIcon layout_navbar_expand_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_NAVBAR_EXPAND);
  }

  default TablerIcon layout_sidebar_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR);
  }

  default TablerIcon layout_sidebar_left_collapse_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR_LEFT_COLLAPSE);
  }

  default TablerIcon layout_sidebar_left_expand_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR_LEFT_EXPAND);
  }

  default TablerIcon layout_sidebar_right_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR_RIGHT);
  }

  default TablerIcon layout_sidebar_right_collapse_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR_RIGHT_COLLAPSE);
  }

  default TablerIcon layout_sidebar_right_expand_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.LAYOUT_SIDEBAR_RIGHT_EXPAND);
  }

  default TablerIcon magnet_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.MAGNET);
  }

  default TablerIcon mickey_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.MICKEY);
  }

  default TablerIcon paint_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.PAINT);
  }

  default TablerIcon palette_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.PALETTE);
  }

  default TablerIcon pencil_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.PENCIL);
  }

  default TablerIcon section_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.SECTION);
  }

  default TablerIcon sparkles_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.SPARKLES_2);
  }

  default TablerIcon squares_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.SQUARES);
  }

  default TablerIcon stack_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.STACK);
  }

  default TablerIcon stack_2_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.STACK_2);
  }

  default TablerIcon stack_3_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.STACK_3);
  }

  default TablerIcon template_filled() {
    return TablerIcon.create(TablerDesign.FilledIcon.TEMPLATE);
  }
}
