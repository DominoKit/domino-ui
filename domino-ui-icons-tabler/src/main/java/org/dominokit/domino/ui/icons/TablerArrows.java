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

/** Tabler Arrows catalog category. */
public interface TablerArrows {
  enum OutlineIcon implements TablerIconDefinition {
    ARROW_AUTOFIT_CONTENT(
        "arrow-autofit-content",
        "<path d=\"M6 4l-3 3l3 3\" />\n  <path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M4 16a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -2\" />\n  <path d=\"M10 7h-7\" />\n  <path d=\"M21 7h-7\" />"),
    ARROW_AUTOFIT_DOWN(
        "arrow-autofit-down",
        "<path d=\"M12 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h8\" />\n  <path d=\"M18 4v17\" />\n  <path d=\"M15 18l3 3l3 -3\" />"),
    ARROW_AUTOFIT_HEIGHT(
        "arrow-autofit-height",
        "<path d=\"M12 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h6\" />\n  <path d=\"M18 14v7\" />\n  <path d=\"M18 3v7\" />\n  <path d=\"M15 18l3 3l3 -3\" />\n  <path d=\"M15 6l3 -3l3 3\" />"),
    ARROW_AUTOFIT_LEFT(
        "arrow-autofit-left",
        "<path d=\"M4 12v-6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M20 18h-17\" />\n  <path d=\"M6 15l-3 3l3 3\" />"),
    ARROW_AUTOFIT_RIGHT(
        "arrow-autofit-right",
        "<path d=\"M20 12v-6a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v8\" />\n  <path d=\"M4 18h17\" />\n  <path d=\"M18 15l3 3l-3 3\" />"),
    ARROW_AUTOFIT_UP(
        "arrow-autofit-up",
        "<path d=\"M12 4h-6a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h8\" />\n  <path d=\"M18 20v-17\" />\n  <path d=\"M15 6l3 -3l3 3\" />"),
    ARROW_AUTOFIT_WIDTH(
        "arrow-autofit-width",
        "<path d=\"M4 12v-6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M10 18h-7\" />\n  <path d=\"M21 18h-7\" />\n  <path d=\"M6 15l-3 3l3 3\" />\n  <path d=\"M18 15l3 3l-3 3\" />"),
    ARROW_BACK("arrow-back", "<path d=\"M9 11l-4 4l4 4m-4 -4h11a4 4 0 0 0 0 -8h-1\" />"),
    ARROW_BACK_UP(
        "arrow-back-up",
        "<path d=\"M9 14l-4 -4l4 -4\" />\n  <path d=\"M5 10h11a4 4 0 1 1 0 8h-1\" />"),
    ARROW_BACK_UP_DOUBLE(
        "arrow-back-up-double",
        "<path d=\"M13 14l-4 -4l4 -4\" />\n  <path d=\"M8 14l-4 -4l4 -4\" />\n  <path d=\"M9 10h7a4 4 0 1 1 0 8h-1\" />"),
    ARROW_BADGE_DOWN("arrow-badge-down", "<path d=\"M17 13v-6l-5 4l-5 -4v6l5 4l5 -4\" />"),
    ARROW_BADGE_LEFT("arrow-badge-left", "<path d=\"M11 17h6l-4 -5l4 -5h-6l-4 5l4 5\" />"),
    ARROW_BADGE_RIGHT("arrow-badge-right", "<path d=\"M13 7h-6l4 5l-4 5h6l4 -5l-4 -5\" />"),
    ARROW_BADGE_UP("arrow-badge-up", "<path d=\"M17 11v6l-5 -4l-5 4v-6l5 -4l5 4\" />"),
    ARROW_BAR_BOTH(
        "arrow-bar-both",
        "<path d=\"M8 12h-6\" />\n  <path d=\"M5 15l-3 -3l3 -3\" />\n  <path d=\"M22 12h-6\" />\n  <path d=\"M19 15l3 -3l-3 -3\" />\n  <path d=\"M12 4v16\" />"),
    ARROW_BAR_DOWN(
        "arrow-bar-down",
        "<path d=\"M12 20l0 -10\" />\n  <path d=\"M12 20l4 -4\" />\n  <path d=\"M12 20l-4 -4\" />\n  <path d=\"M4 4l16 0\" />"),
    ARROW_BAR_LEFT(
        "arrow-bar-left",
        "<path d=\"M4 12l10 0\" />\n  <path d=\"M4 12l4 4\" />\n  <path d=\"M4 12l4 -4\" />\n  <path d=\"M20 4l0 16\" />"),
    ARROW_BAR_RIGHT(
        "arrow-bar-right",
        "<path d=\"M20 12l-10 0\" />\n  <path d=\"M20 12l-4 4\" />\n  <path d=\"M20 12l-4 -4\" />\n  <path d=\"M4 4l0 16\" />"),
    ARROW_BAR_TO_DOWN(
        "arrow-bar-to-down",
        "<path d=\"M4 20l16 0\" />\n  <path d=\"M12 14l0 -10\" />\n  <path d=\"M12 14l4 -4\" />\n  <path d=\"M12 14l-4 -4\" />"),
    ARROW_BAR_TO_DOWN_DASHED(
        "arrow-bar-to-down-dashed",
        "<path d=\"M12 14v-10\" />\n  <path d=\"M12 14l4 -4\" />\n  <path d=\"M12 14l-4 -4\" />\n  <path d=\"M4 20h3m13 0h-3m-3.5 0h-3\" />"),
    ARROW_BAR_TO_LEFT(
        "arrow-bar-to-left",
        "<path d=\"M10 12l10 0\" />\n  <path d=\"M10 12l4 4\" />\n  <path d=\"M10 12l4 -4\" />\n  <path d=\"M4 4l0 16\" />"),
    ARROW_BAR_TO_LEFT_DASHED(
        "arrow-bar-to-left-dashed",
        "<path d=\"M10 12l10 0\" />\n  <path d=\"M10 12l4 -4\" />\n  <path d=\"M10 12l4 4\" />\n  <path d=\"M4 20l0 -3m0 -13l0 3m0 3.5l0 3\" />"),
    ARROW_BAR_TO_RIGHT(
        "arrow-bar-to-right",
        "<path d=\"M14 12l-10 0\" />\n  <path d=\"M14 12l-4 4\" />\n  <path d=\"M14 12l-4 -4\" />\n  <path d=\"M20 4l0 16\" />"),
    ARROW_BAR_TO_RIGHT_DASHED(
        "arrow-bar-to-right-dashed",
        "<path d=\"M14 12l-10 0\" />\n  <path d=\"M14 12l-4 4\" />\n  <path d=\"M14 12l-4 -4\" />\n  <path d=\"M20 4l0 3m0 13l0 -3m0 -3.5l0 -3\" />"),
    ARROW_BAR_TO_UP(
        "arrow-bar-to-up",
        "<path d=\"M12 10l0 10\" />\n  <path d=\"M12 10l4 4\" />\n  <path d=\"M12 10l-4 4\" />\n  <path d=\"M4 4l16 0\" />"),
    ARROW_BAR_TO_UP_DASHED(
        "arrow-bar-to-up-dashed",
        "<path d=\"M12 10v10\" />\n  <path d=\"M12 10l4 4\" />\n  <path d=\"M12 10l-4 4\" />\n  <path d=\"M4 4h3m13 0h-3m-3.5 0h-3\" />"),
    ARROW_BAR_UP(
        "arrow-bar-up",
        "<path d=\"M12 4l0 10\" />\n  <path d=\"M12 4l4 4\" />\n  <path d=\"M12 4l-4 4\" />\n  <path d=\"M4 20l16 0\" />"),
    ARROW_BEAR_LEFT(
        "arrow-bear-left",
        "<path d=\"M13 3h-5v5\" />\n  <path d=\"M8 3l7.536 7.536a5 5 0 0 1 1.464 3.534v6.93\" />"),
    ARROW_BEAR_LEFT_2(
        "arrow-bear-left-2",
        "<path d=\"M9 3h-5v5\" />\n  <path d=\"M4 3l7.536 7.536a5 5 0 0 1 1.464 3.534v6.93\" />\n  <path d=\"M20 5l-4.5 4.5\" />"),
    ARROW_BEAR_RIGHT(
        "arrow-bear-right",
        "<path d=\"M12 3h5v5\" />\n  <path d=\"M17 3l-7.536 7.536a5 5 0 0 0 -1.464 3.534v6.93\" />"),
    ARROW_BEAR_RIGHT_2(
        "arrow-bear-right-2",
        "<path d=\"M15 3h5v5\" />\n  <path d=\"M20 3l-7.536 7.536a5 5 0 0 0 -1.464 3.534v6.93\" />\n  <path d=\"M4 5l4.5 4.5\" />"),
    ARROW_BIG_DOWN(
        "arrow-big-down",
        "<path d=\"M15 4v8h3.586a1 1 0 0 1 .707 1.707l-6.586 6.586a1 1 0 0 1 -1.414 0l-6.586 -6.586a1 1 0 0 1 .707 -1.707h3.586v-8a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1\" />"),
    ARROW_BIG_DOWN_LINE(
        "arrow-big-down-line",
        "<path d=\"M15 12h3.586a1 1 0 0 1 .707 1.707l-6.586 6.586a1 1 0 0 1 -1.414 0l-6.586 -6.586a1 1 0 0 1 .707 -1.707h3.586v-6h6v6\" />\n  <path d=\"M15 3h-6\" />"),
    ARROW_BIG_DOWN_LINES(
        "arrow-big-down-lines",
        "<path d=\"M15 12h3.586a1 1 0 0 1 .707 1.707l-6.586 6.586a1 1 0 0 1 -1.414 0l-6.586 -6.586a1 1 0 0 1 .707 -1.707h3.586v-3h6v3\" />\n  <path d=\"M15 3h-6\" />\n  <path d=\"M15 6h-6\" />"),
    ARROW_BIG_LEFT(
        "arrow-big-left",
        "<path d=\"M20 15h-8v3.586a1 1 0 0 1 -1.707 .707l-6.586 -6.586a1 1 0 0 1 0 -1.414l6.586 -6.586a1 1 0 0 1 1.707 .707v3.586h8a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1\" />"),
    ARROW_BIG_LEFT_LINE(
        "arrow-big-left-line",
        "<path d=\"M12 15v3.586a1 1 0 0 1 -1.707 .707l-6.586 -6.586a1 1 0 0 1 0 -1.414l6.586 -6.586a1 1 0 0 1 1.707 .707v3.586h6v6h-6\" />\n  <path d=\"M21 15v-6\" />"),
    ARROW_BIG_LEFT_LINES(
        "arrow-big-left-lines",
        "<path d=\"M12 15v3.586a1 1 0 0 1 -1.707 .707l-6.586 -6.586a1 1 0 0 1 0 -1.414l6.586 -6.586a1 1 0 0 1 1.707 .707v3.586h3v6h-3\" />\n  <path d=\"M21 15v-6\" />\n  <path d=\"M18 15v-6\" />"),
    ARROW_BIG_RIGHT(
        "arrow-big-right",
        "<path d=\"M4 9h8v-3.586a1 1 0 0 1 1.707 -.707l6.586 6.586a1 1 0 0 1 0 1.414l-6.586 6.586a1 1 0 0 1 -1.707 -.707v-3.586h-8a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1\" />"),
    ARROW_BIG_RIGHT_LINE(
        "arrow-big-right-line",
        "<path d=\"M12 9v-3.586a1 1 0 0 1 1.707 -.707l6.586 6.586a1 1 0 0 1 0 1.414l-6.586 6.586a1 1 0 0 1 -1.707 -.707v-3.586h-6v-6h6\" />\n  <path d=\"M3 9v6\" />"),
    ARROW_BIG_RIGHT_LINES(
        "arrow-big-right-lines",
        "<path d=\"M12 9v-3.586a1 1 0 0 1 1.707 -.707l6.586 6.586a1 1 0 0 1 0 1.414l-6.586 6.586a1 1 0 0 1 -1.707 -.707v-3.586h-3v-6h3\" />\n  <path d=\"M3 9v6\" />\n  <path d=\"M6 9v6\" />"),
    ARROW_BIG_UP(
        "arrow-big-up",
        "<path d=\"M9 20v-8h-3.586a1 1 0 0 1 -.707 -1.707l6.586 -6.586a1 1 0 0 1 1.414 0l6.586 6.586a1 1 0 0 1 -.707 1.707h-3.586v8a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1\" />"),
    ARROW_BIG_UP_LINE(
        "arrow-big-up-line",
        "<path d=\"M9 12h-3.586a1 1 0 0 1 -.707 -1.707l6.586 -6.586a1 1 0 0 1 1.414 0l6.586 6.586a1 1 0 0 1 -.707 1.707h-3.586v6h-6v-6\" />\n  <path d=\"M9 21h6\" />"),
    ARROW_BIG_UP_LINES(
        "arrow-big-up-lines",
        "<path d=\"M9 12h-3.586a1 1 0 0 1 -.707 -1.707l6.586 -6.586a1 1 0 0 1 1.414 0l6.586 6.586a1 1 0 0 1 -.707 1.707h-3.586v3h-6v-3\" />\n  <path d=\"M9 21h6\" />\n  <path d=\"M9 18h6\" />"),
    ARROW_BOUNCE(
        "arrow-bounce",
        "<path d=\"M10 18h4\" />\n  <path d=\"M3 8a9 9 0 0 1 9 9v1l1.428 -4.285a12 12 0 0 1 6.018 -6.938l.554 -.277\" />\n  <path d=\"M15 6h5v5\" />"),
    ARROW_CAPSULE(
        "arrow-capsule",
        "<path d=\"M18 15a6 6 0 1 1 -12 0v-6a6 6 0 1 1 12 0v2\" />\n  <path d=\"M15 8l3 3l3 -3\" />"),
    ARROW_CURVE_LEFT(
        "arrow-curve-left",
        "<path d=\"M14 7l-4 -4l-4 4\" />\n  <path d=\"M10 3v4.394a6.737 6.737 0 0 0 3 5.606a6.737 6.737 0 0 1 3 5.606v2.394\" />"),
    ARROW_CURVE_RIGHT(
        "arrow-curve-right",
        "<path d=\"M10 7l4 -4l4 4\" />\n  <path d=\"M14 3v4.394a6.737 6.737 0 0 1 -3 5.606a6.737 6.737 0 0 0 -3 5.606v2.394\" />"),
    ARROW_DOWN(
        "arrow-down",
        "<path d=\"M12 5l0 14\" />\n  <path d=\"M18 13l-6 6\" />\n  <path d=\"M6 13l6 6\" />"),
    ARROW_DOWN_BAR(
        "arrow-down-bar",
        "<path d=\"M12 3v18\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M9 3h6\" />"),
    ARROW_DOWN_CIRCLE(
        "arrow-down-circle",
        "<path d=\"M12 7v14\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M12 7a2 2 0 1 0 0 -4a2 2 0 0 0 0 4\" />"),
    ARROW_DOWN_DASHED(
        "arrow-down-dashed",
        "<path d=\"M12 5v.5m0 3v1.5m0 3v6\" />\n  <path d=\"M18 13l-6 6\" />\n  <path d=\"M6 13l6 6\" />"),
    ARROW_DOWN_FROM_ARC(
        "arrow-down-from-arc",
        "<path d=\"M12 15v-12\" />\n  <path d=\"M16 7l-4 -4l-4 4\" />\n  <path d=\"M3 12a9 9 0 0 0 18 0\" />"),
    ARROW_DOWN_LEFT(
        "arrow-down-left", "<path d=\"M17 7l-10 10\" />\n  <path d=\"M16 17l-9 0l0 -9\" />"),
    ARROW_DOWN_LEFT_CIRCLE(
        "arrow-down-left-circle",
        "<path d=\"M15.536 8.464l-9.536 9.536\" />\n  <path d=\"M6 14v4h4\" />\n  <path d=\"M15.586 8.414a2 2 0 1 0 2.828 -2.828a2 2 0 0 0 -2.828 2.828\" />"),
    ARROW_DOWN_RHOMBUS(
        "arrow-down-rhombus",
        "<path d=\"M12 8v13\" />\n  <path d=\"M15 18l-3 3l-3 -3\" />\n  <path d=\"M14.5 5.5l-2.5 -2.5l-2.5 2.5l2.5 2.5l2.5 -2.5\" />"),
    ARROW_DOWN_RIGHT(
        "arrow-down-right", "<path d=\"M7 7l10 10\" />\n  <path d=\"M17 8l0 9l-9 0\" />"),
    ARROW_DOWN_RIGHT_CIRCLE(
        "arrow-down-right-circle",
        "<path d=\"M8.464 8.464l9.536 9.536\" />\n  <path d=\"M14 18h4v-4\" />\n  <path d=\"M8.414 8.414a2 2 0 1 0 -2.828 -2.828a2 2 0 0 0 2.828 2.828\" />"),
    ARROW_DOWN_SQUARE(
        "arrow-down-square",
        "<path d=\"M12 7v14\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M14 3v4h-4v-4l4 0\" />"),
    ARROW_DOWN_TAIL(
        "arrow-down-tail",
        "<path d=\"M12 6v15\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M9 3l3 3l3 -3\" />"),
    ARROW_DOWN_TO_ARC(
        "arrow-down-to-arc",
        "<path d=\"M12 3v12\" />\n  <path d=\"M16 11l-4 4l-4 -4\" />\n  <path d=\"M3 12a9 9 0 0 0 18 0\" />"),
    ARROW_ELBOW_LEFT(
        "arrow-elbow-left", "<path d=\"M3 14v-6h6\" />\n  <path d=\"M3 8l9 9l9 -9\" />"),
    ARROW_ELBOW_RIGHT(
        "arrow-elbow-right", "<path d=\"M21 14v-6h-6\" />\n  <path d=\"M21 8l-9 9l-9 -9\" />"),
    ARROW_FORK(
        "arrow-fork",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"M8 3h-5v5\" />\n  <path d=\"M21 3l-7.536 7.536a5 5 0 0 0 -1.464 3.534v6.93\" />\n  <path d=\"M3 3l7.536 7.536a5 5 0 0 1 1.464 3.534v.93\" />"),
    ARROW_FORK_TRIPLE(
        "arrow-fork-triple",
        "<path d=\"M12 3v18\" />\n  <path d=\"M16 7l-4 -4l-4 4\" />\n  <path d=\"M16 11h5v5\" />\n  <path d=\"M8 11h-5v5\" />\n  <path d=\"M3 11l8.293 8.293c.453 .453 .707 1.067 .707 1.707\" />\n  <path d=\"M21 11l-8.293 8.293a2.4 2.4 0 0 0 -.707 1.707\" />"),
    ARROW_FORWARD("arrow-forward", "<path d=\"M15 11l4 4l-4 4m4 -4h-11a4 4 0 0 1 0 -8h1\" />"),
    ARROW_FORWARD_UP(
        "arrow-forward-up",
        "<path d=\"M15 14l4 -4l-4 -4\" />\n  <path d=\"M19 10h-11a4 4 0 1 0 0 8h1\" />"),
    ARROW_FORWARD_UP_DOUBLE(
        "arrow-forward-up-double",
        "<path d=\"M11 14l4 -4l-4 -4\" />\n  <path d=\"M16 14l4 -4l-4 -4\" />\n  <path d=\"M15 10h-7a4 4 0 1 0 0 8h1\" />"),
    ARROW_GUIDE(
        "arrow-guide",
        "<path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 19h3a2 2 0 0 0 2 -2v-8a2 2 0 0 1 2 -2h7\" />\n  <path d=\"M18 4l3 3l-3 3\" />"),
    ARROW_ITERATION(
        "arrow-iteration",
        "<path d=\"M8.5 16a5.5 5.5 0 1 0 -5.5 -5.5v.5\" />\n  <path d=\"M3 16h18\" />\n  <path d=\"M18 13l3 3l-3 3\" />"),
    ARROW_LEFT(
        "arrow-left",
        "<path d=\"M5 12l14 0\" />\n  <path d=\"M5 12l6 6\" />\n  <path d=\"M5 12l6 -6\" />"),
    ARROW_LEFT_BAR(
        "arrow-left-bar",
        "<path d=\"M21 12h-18\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M21 9v6\" />"),
    ARROW_LEFT_CIRCLE(
        "arrow-left-circle",
        "<path d=\"M17 12h-14\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M17 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    ARROW_LEFT_DASHED(
        "arrow-left-dashed",
        "<path d=\"M5 12h6m3 0h1.5m3 0h.5\" />\n  <path d=\"M5 12l6 6\" />\n  <path d=\"M5 12l6 -6\" />"),
    ARROW_LEFT_FROM_ARC(
        "arrow-left-from-arc",
        "<path d=\"M9 12h12\" />\n  <path d=\"M17 16l4 -4l-4 -4\" />\n  <path d=\"M12 3a9 9 0 1 0 0 18\" />"),
    ARROW_LEFT_RHOMBUS(
        "arrow-left-rhombus",
        "<path d=\"M16 12h-13\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M18.5 9.5l2.5 2.5l-2.5 2.5l-2.5 -2.5l2.5 -2.5\" />"),
    ARROW_LEFT_RIGHT(
        "arrow-left-right",
        "<path d=\"M17 13l4 -4l-4 -4\" />\n  <path d=\"M7 13l-4 -4l4 -4\" />\n  <path d=\"M12 14a5 5 0 0 1 5 -5h4\" />\n  <path d=\"M12 19v-5a5 5 0 0 0 -5 -5h-4\" />"),
    ARROW_LEFT_SQUARE(
        "arrow-left-square",
        "<path d=\"M17 12h-14\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M21 14h-4v-4h4l0 4\" />"),
    ARROW_LEFT_TAIL(
        "arrow-left-tail",
        "<path d=\"M18 12h-15\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M21 9l-3 3l3 3\" />"),
    ARROW_LEFT_TO_ARC(
        "arrow-left-to-arc",
        "<path d=\"M21 12h-12\" />\n  <path d=\"M13 16l-4 -4l4 -4\" />\n  <path d=\"M12 3a9 9 0 1 0 0 18\" />"),
    ARROW_LOOP_LEFT(
        "arrow-loop-left",
        "<path d=\"M13 21v-13a4 4 0 1 1 4 4h-13\" />\n  <path d=\"M8 16l-4 -4l4 -4\" />"),
    ARROW_LOOP_LEFT_2(
        "arrow-loop-left-2",
        "<path d=\"M13 21v-6m0 -6v-1a4 4 0 1 1 4 4h-13\" />\n  <path d=\"M8 16l-4 -4l4 -4\" />"),
    ARROW_LOOP_RIGHT(
        "arrow-loop-right",
        "<path d=\"M12 21v-13a4 4 0 1 0 -4 4h13\" />\n  <path d=\"M17 16l4 -4l-4 -4\" />"),
    ARROW_LOOP_RIGHT_2(
        "arrow-loop-right-2",
        "<path d=\"M12 21v-6m0 -6v-1a4 4 0 1 0 -4 4h13\" />\n  <path d=\"M17 16l4 -4l-4 -4\" />"),
    ARROW_MERGE(
        "arrow-merge",
        "<path d=\"M8 7l4 -4l4 4\" />\n  <path d=\"M12 3v5.394a6.737 6.737 0 0 1 -3 5.606a6.737 6.737 0 0 0 -3 5.606v1.394\" />\n  <path d=\"M12 3v5.394a6.737 6.737 0 0 0 3 5.606a6.737 6.737 0 0 1 3 5.606v1.394\" />"),
    ARROW_MERGE_ALT_LEFT(
        "arrow-merge-alt-left",
        "<path d=\"M8 7l4 -4l4 4\" />\n  <path d=\"M18 21v.01\" />\n  <path d=\"M18 18.01v.01\" />\n  <path d=\"M17 15.02v.01\" />\n  <path d=\"M14 13.03v.01\" />\n  <path d=\"M12 3v5.394a6.737 6.737 0 0 1 -3 5.606a6.737 6.737 0 0 0 -3 5.606v1.394\" />"),
    ARROW_MERGE_ALT_RIGHT(
        "arrow-merge-alt-right",
        "<path d=\"M16 7l-4 -4l-4 4\" />\n  <path d=\"M6 21v.01\" />\n  <path d=\"M6 18.01v.01\" />\n  <path d=\"M7 15.02v.01\" />\n  <path d=\"M10 13.03v.01\" />\n  <path d=\"M12 3v5.394a6.737 6.737 0 0 0 3 5.606a6.737 6.737 0 0 1 3 5.606v1.394\" />"),
    ARROW_MERGE_BOTH(
        "arrow-merge-both",
        "<path d=\"M16 8l-4 -4l-4 4\" />\n  <path d=\"M12 20v-16\" />\n  <path d=\"M18 18c-4 -1.333 -6 -4.667 -6 -10\" />\n  <path d=\"M6 18c4 -1.333 6 -4.667 6 -10\" />"),
    ARROW_MERGE_LEFT(
        "arrow-merge-left",
        "<path d=\"M8 8l4 -4l4 4\" />\n  <path d=\"M12 20v-16\" />\n  <path d=\"M6 18c4 -1.333 6 -4.667 6 -10\" />"),
    ARROW_MERGE_RIGHT(
        "arrow-merge-right",
        "<path d=\"M16 8l-4 -4l-4 4\" />\n  <path d=\"M12 20v-16\" />\n  <path d=\"M18 18c-4 -1.333 -6 -4.667 -6 -10\" />"),
    ARROW_MOVE_DOWN(
        "arrow-move-down",
        "<path d=\"M12 11v10\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    ARROW_MOVE_LEFT(
        "arrow-move-left",
        "<path d=\"M13 12h-10\" />\n  <path d=\"M6 15l-3 -3l3 -3\" />\n  <path d=\"M17 12a2 2 0 1 1 4 0a2 2 0 0 1 -4 0\" />"),
    ARROW_MOVE_RIGHT(
        "arrow-move-right",
        "<path d=\"M11 12h10\" />\n  <path d=\"M18 9l3 3l-3 3\" />\n  <path d=\"M7 12a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />"),
    ARROW_MOVE_UP(
        "arrow-move-up",
        "<path d=\"M12 13v-10\" />\n  <path d=\"M9 6l3 -3l3 3\" />\n  <path d=\"M12 17a2 2 0 1 1 0 4a2 2 0 0 1 0 -4\" />"),
    ARROW_NARROW_DOWN(
        "arrow-narrow-down",
        "<path d=\"M12 5l0 14\" />\n  <path d=\"M16 15l-4 4\" />\n  <path d=\"M8 15l4 4\" />"),
    ARROW_NARROW_DOWN_DASHED(
        "arrow-narrow-down-dashed",
        "<path d=\"M12 5v.5m0 3v1.5m0 3v6\" />\n  <path d=\"M16 15l-4 4\" />\n  <path d=\"M8 15l4 4\" />"),
    ARROW_NARROW_LEFT(
        "arrow-narrow-left",
        "<path d=\"M5 12l14 0\" />\n  <path d=\"M5 12l4 4\" />\n  <path d=\"M5 12l4 -4\" />"),
    ARROW_NARROW_LEFT_DASHED(
        "arrow-narrow-left-dashed",
        "<path d=\"M5 12h6m3 0h1.5m3 0h.5\" />\n  <path d=\"M5 12l4 4\" />\n  <path d=\"M5 12l4 -4\" />"),
    ARROW_NARROW_RIGHT(
        "arrow-narrow-right",
        "<path d=\"M5 12l14 0\" />\n  <path d=\"M15 16l4 -4\" />\n  <path d=\"M15 8l4 4\" />"),
    ARROW_NARROW_RIGHT_DASHED(
        "arrow-narrow-right-dashed",
        "<path d=\"M5 12h.5m3 0h1.5m3 0h6\" />\n  <path d=\"M15 16l4 -4\" />\n  <path d=\"M15 8l4 4\" />"),
    ARROW_NARROW_UP(
        "arrow-narrow-up",
        "<path d=\"M12 5l0 14\" />\n  <path d=\"M16 9l-4 -4\" />\n  <path d=\"M8 9l4 -4\" />"),
    ARROW_NARROW_UP_DASHED(
        "arrow-narrow-up-dashed",
        "<path d=\"M12 5v6m0 3v1.5m0 3v.5\" />\n  <path d=\"M16 9l-4 -4\" />\n  <path d=\"M8 9l4 -4\" />"),
    ARROW_RAMP_LEFT(
        "arrow-ramp-left",
        "<path d=\"M17 3l0 8.707\" />\n  <path d=\"M13 7l4 -4l4 4\" />\n  <path d=\"M7 14l-4 -4l4 -4\" />\n  <path d=\"M17 21a11 11 0 0 0 -11 -11h-3\" />"),
    ARROW_RAMP_LEFT_2(
        "arrow-ramp-left-2",
        "<path d=\"M18 3v8.707\" />\n  <path d=\"M8 14l-4 -4l4 -4\" />\n  <path d=\"M18 21c0 -6.075 -4.925 -11 -11 -11h-3\" />"),
    ARROW_RAMP_LEFT_3(
        "arrow-ramp-left-3",
        "<path d=\"M18 3v6\" />\n  <path d=\"M8 16l-4 -4l4 -4\" />\n  <path d=\"M18 21v-6a3 3 0 0 0 -3 -3h-11\" />"),
    ARROW_RAMP_RIGHT(
        "arrow-ramp-right",
        "<path d=\"M7 3l0 8.707\" />\n  <path d=\"M11 7l-4 -4l-4 4\" />\n  <path d=\"M17 14l4 -4l-4 -4\" />\n  <path d=\"M7 21a11 11 0 0 1 11 -11h3\" />"),
    ARROW_RAMP_RIGHT_2(
        "arrow-ramp-right-2",
        "<path d=\"M6 3v8.707\" />\n  <path d=\"M16 14l4 -4l-4 -4\" />\n  <path d=\"M6 21c0 -6.075 4.925 -11 11 -11h3\" />"),
    ARROW_RAMP_RIGHT_3(
        "arrow-ramp-right-3",
        "<path d=\"M6 3v6\" />\n  <path d=\"M16 16l4 -4l-4 -4\" />\n  <path d=\"M6 21v-6a3 3 0 0 1 3 -3h11\" />"),
    ARROW_RIGHT(
        "arrow-right",
        "<path d=\"M5 12l14 0\" />\n  <path d=\"M13 18l6 -6\" />\n  <path d=\"M13 6l6 6\" />"),
    ARROW_RIGHT_BAR(
        "arrow-right-bar",
        "<path d=\"M18 15l3 -3l-3 -3\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 9v6\" />"),
    ARROW_RIGHT_CIRCLE(
        "arrow-right-circle",
        "<path d=\"M18 15l3 -3l-3 -3\" />\n  <path d=\"M3 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 12h14\" />"),
    ARROW_RIGHT_DASHED(
        "arrow-right-dashed",
        "<path d=\"M5 12h.5m3 0h1.5m3 0h6\" />\n  <path d=\"M13 18l6 -6\" />\n  <path d=\"M13 6l6 6\" />"),
    ARROW_RIGHT_FROM_ARC(
        "arrow-right-from-arc",
        "<path d=\"M15 12h-12\" />\n  <path d=\"M7 8l-4 4l4 4\" />\n  <path d=\"M12 21a9 9 0 0 0 0 -18\" />"),
    ARROW_RIGHT_RHOMBUS(
        "arrow-right-rhombus",
        "<path d=\"M8 12h13\" />\n  <path d=\"M18 9l3 3l-3 3\" />\n  <path d=\"M5.5 9.5l-2.5 2.5l2.5 2.5l2.5 -2.5l-2.5 -2.5\" />"),
    ARROW_RIGHT_SQUARE(
        "arrow-right-square",
        "<path d=\"M7 12l14 0\" />\n  <path d=\"M18 15l3 -3l-3 -3\" />\n  <path d=\"M3 10h4v4h-4l0 -4\" />"),
    ARROW_RIGHT_TAIL(
        "arrow-right-tail",
        "<path d=\"M18 15l3 -3l-3 -3\" />\n  <path d=\"M3 15l3 -3l-3 -3\" />\n  <path d=\"M6 12l15 0\" />"),
    ARROW_RIGHT_TO_ARC(
        "arrow-right-to-arc",
        "<path d=\"M3 12h12\" />\n  <path d=\"M11 8l4 4l-4 4\" />\n  <path d=\"M12 21a9 9 0 0 0 0 -18\" />"),
    ARROW_ROTARY_FIRST_LEFT(
        "arrow-rotary-first-left",
        "<path d=\"M16 10a3 3 0 1 1 0 -6a3 3 0 0 1 0 6\" />\n  <path d=\"M16 10v10\" />\n  <path d=\"M13.5 9.5l-8.5 8.5\" />\n  <path d=\"M10 18h-5v-5\" />"),
    ARROW_ROTARY_FIRST_RIGHT(
        "arrow-rotary-first-right",
        "<path d=\"M5 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8 10v10\" />\n  <path d=\"M10.5 9.5l8.5 8.5\" />\n  <path d=\"M14 18h5v-5\" />"),
    ARROW_ROTARY_LAST_LEFT(
        "arrow-rotary-last-left",
        "<path d=\"M15 15a3 3 0 1 1 0 -6a3 3 0 0 1 0 6\" />\n  <path d=\"M15 15v6\" />\n  <path d=\"M12.5 9.5l-6.5 -6.5\" />\n  <path d=\"M11 3h-5v5\" />"),
    ARROW_ROTARY_LAST_RIGHT(
        "arrow-rotary-last-right",
        "<path d=\"M6 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 15v6\" />\n  <path d=\"M11.5 9.5l6.5 -6.5\" />\n  <path d=\"M13 3h5v5\" />"),
    ARROW_ROTARY_LEFT(
        "arrow-rotary-left",
        "<path d=\"M16 10a3 3 0 1 1 0 -6a3 3 0 0 1 0 6\" />\n  <path d=\"M16 10v10\" />\n  <path d=\"M13 7h-10\" />\n  <path d=\"M7 11l-4 -4l4 -4\" />"),
    ARROW_ROTARY_RIGHT(
        "arrow-rotary-right",
        "<path d=\"M5 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8 10v10\" />\n  <path d=\"M17 11l4 -4l-4 -4\" />\n  <path d=\"M11 7h10\" />"),
    ARROW_ROTARY_STRAIGHT(
        "arrow-rotary-straight",
        "<path d=\"M10 13a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M13 16v5\" />\n  <path d=\"M13 3v7\" />\n  <path d=\"M9 7l4 -4l4 4\" />"),
    ARROW_ROUNDABOUT_LEFT(
        "arrow-roundabout-left",
        "<path d=\"M3 9h8a5 5 0 1 1 5 5v7\" />\n  <path d=\"M7 5l-4 4l4 4\" />"),
    ARROW_ROUNDABOUT_RIGHT(
        "arrow-roundabout-right",
        "<path d=\"M21 9h-8a5 5 0 1 0 -5 5v7\" />\n  <path d=\"M17 5l4 4l-4 4\" />"),
    ARROW_SHARP_TURN_LEFT(
        "arrow-sharp-turn-left",
        "<path d=\"M17 18v-11.31a.7 .7 0 0 0 -1.195 -.495l-9.805 9.805\" />\n  <path d=\"M11 16h-5v-5\" />"),
    ARROW_SHARP_TURN_RIGHT(
        "arrow-sharp-turn-right",
        "<path d=\"M7 18v-11.31a.7 .7 0 0 1 1.195 -.495l9.805 9.805\" />\n  <path d=\"M13 16h5v-5\" />"),
    ARROW_UP(
        "arrow-up",
        "<path d=\"M12 5l0 14\" />\n  <path d=\"M18 11l-6 -6\" />\n  <path d=\"M6 11l6 -6\" />"),
    ARROW_UP_BAR(
        "arrow-up-bar",
        "<path d=\"M12 21l0 -18\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M9 21l6 0\" />"),
    ARROW_UP_CIRCLE(
        "arrow-up-circle",
        "<path d=\"M12 17v-14\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M12 17a2 2 0 1 0 0 4a2 2 0 0 0 0 -4\" />"),
    ARROW_UP_DASHED(
        "arrow-up-dashed",
        "<path d=\"M12 5v6m0 3v1.5m0 3v.5\" />\n  <path d=\"M18 11l-6 -6\" />\n  <path d=\"M6 11l6 -6\" />"),
    ARROW_UP_FROM_ARC(
        "arrow-up-from-arc",
        "<path d=\"M12 9v12\" />\n  <path d=\"M8 17l4 4l4 -4\" />\n  <path d=\"M21 12a9 9 0 0 0 -18 0\" />"),
    ARROW_UP_LEFT("arrow-up-left", "<path d=\"M7 7l10 10\" />\n  <path d=\"M16 7l-9 0l0 9\" />"),
    ARROW_UP_LEFT_CIRCLE(
        "arrow-up-left-circle",
        "<path d=\"M15.536 15.536l-9.536 -9.536\" />\n  <path d=\"M10 6h-4v4\" />\n  <path d=\"M15.586 15.586a2 2 0 1 0 2.828 2.828a2 2 0 0 0 -2.828 -2.828\" />"),
    ARROW_UP_RHOMBUS(
        "arrow-up-rhombus",
        "<path d=\"M12 16v-13\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M14.5 18.5l-2.5 2.5l-2.5 -2.5l2.5 -2.5l2.5 2.5\" />"),
    ARROW_UP_RIGHT("arrow-up-right", "<path d=\"M17 7l-10 10\" />\n  <path d=\"M8 7l9 0l0 9\" />"),
    ARROW_UP_RIGHT_CIRCLE(
        "arrow-up-right-circle",
        "<path d=\"M8.464 15.536l9.536 -9.536\" />\n  <path d=\"M18 10v-4h-4\" />\n  <path d=\"M8.414 15.586a2 2 0 1 0 -2.828 2.828a2 2 0 0 0 2.828 -2.828\" />"),
    ARROW_UP_SQUARE(
        "arrow-up-square",
        "<path d=\"M12 17l0 -14\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M10 21v-4h4v4l-4 0\" />"),
    ARROW_UP_TAIL(
        "arrow-up-tail",
        "<path d=\"M12 18l0 -15\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M15 21l-3 -3l-3 3\" />"),
    ARROW_UP_TO_ARC(
        "arrow-up-to-arc",
        "<path d=\"M12 21v-12\" />\n  <path d=\"M8 13l4 -4l4 4\" />\n  <path d=\"M21 12a9 9 0 0 0 -18 0\" />"),
    ARROW_WAVE_LEFT_DOWN(
        "arrow-wave-left-down",
        "<path d=\"M7 14h-4v-4\" />\n  <path d=\"M21 12c-.887 1.284 -2.48 2.033 -4 2c-1.52 .033 -3.113 -.716 -4 -2s-2.48 -2.033 -4 -2c-1.52 -.033 -3 1 -4 2l-2 2\" />"),
    ARROW_WAVE_LEFT_UP(
        "arrow-wave-left-up",
        "<path d=\"M7 10h-4v4\" />\n  <path d=\"M21 12c-.887 -1.285 -2.48 -2.033 -4 -2c-1.52 -.033 -3.113 .715 -4 2c-.887 1.284 -2.48 2.033 -4 2c-1.52 .033 -3 -1 -4 -2l-2 -2\" />"),
    ARROW_WAVE_RIGHT_DOWN(
        "arrow-wave-right-down",
        "<path d=\"M17 14h4v-4\" />\n  <path d=\"M3 12c.887 1.284 2.48 2.033 4 2c1.52 .033 3.113 -.716 4 -2s2.48 -2.033 4 -2c1.52 -.033 3 1 4 2l2 2\" />"),
    ARROW_WAVE_RIGHT_UP(
        "arrow-wave-right-up",
        "<path d=\"M17 10h4v4\" />\n  <path d=\"M3 12c.887 -1.284 2.48 -2.033 4 -2c1.52 -.033 3.113 .716 4 2s2.48 2.033 4 2c1.52 .033 3 -1 4 -2l2 -2\" />"),
    ARROW_ZIG_ZAG(
        "arrow-zig-zag", "<path d=\"M6 20v-10l10 6v-12\" />\n  <path d=\"M13 7l3 -3l3 3\" />"),
    ARROWS_CROSS(
        "arrows-cross",
        "<path d=\"M16 4h4v4\" />\n  <path d=\"M15 9l5 -5\" />\n  <path d=\"M4 20l5 -5\" />\n  <path d=\"M16 20h4v-4\" />\n  <path d=\"M4 4l16 16\" />"),
    ARROWS_DIAGONAL(
        "arrows-diagonal",
        "<path d=\"M16 4l4 0l0 4\" />\n  <path d=\"M14 10l6 -6\" />\n  <path d=\"M8 20l-4 0l0 -4\" />\n  <path d=\"M4 20l6 -6\" />"),
    ARROWS_DIAGONAL_2(
        "arrows-diagonal-2",
        "<path d=\"M16 20l4 0l0 -4\" />\n  <path d=\"M14 14l6 6\" />\n  <path d=\"M8 4l-4 0l0 4\" />\n  <path d=\"M4 4l6 6\" />"),
    ARROWS_DIAGONAL_MINIMIZE(
        "arrows-diagonal-minimize",
        "<path d=\"M6 10h4v-4\" />\n  <path d=\"M4 4l6 6\" />\n  <path d=\"M18 14h-4v4\" />\n  <path d=\"M14 14l6 6\" />"),
    ARROWS_DIAGONAL_MINIMIZE_2(
        "arrows-diagonal-minimize-2",
        "<path d=\"M18 10h-4v-4\" />\n  <path d=\"M20 4l-6 6\" />\n  <path d=\"M6 14h4v4\" />\n  <path d=\"M10 14l-6 6\" />"),
    ARROWS_DIFF(
        "arrows-diff",
        "<path d=\"M11 16h10\" />\n  <path d=\"M11 16l4 4\" />\n  <path d=\"M11 16l4 -4\" />\n  <path d=\"M13 8h-10\" />\n  <path d=\"M13 8l-4 4\" />\n  <path d=\"M13 8l-4 -4\" />"),
    ARROWS_DOUBLE_NE_SW(
        "arrows-double-ne-sw",
        "<path d=\"M3 14l11 -11\" />\n  <path d=\"M10 3h4v4\" />\n  <path d=\"M10 17v4h4\" />\n  <path d=\"M21 10l-11 11\" />"),
    ARROWS_DOUBLE_NW_SE(
        "arrows-double-nw-se",
        "<path d=\"M14 21l-11 -11\" />\n  <path d=\"M3 14v-4h4\" />\n  <path d=\"M17 14h4v-4\" />\n  <path d=\"M10 3l11 11\" />"),
    ARROWS_DOUBLE_SE_NW(
        "arrows-double-se-nw",
        "<path d=\"M3 10l11 11\" />\n  <path d=\"M14 17v4h-4\" />\n  <path d=\"M14 3h-4v4\" />\n  <path d=\"M21 14l-11 -11\" />"),
    ARROWS_DOUBLE_SW_NE(
        "arrows-double-sw-ne",
        "<path d=\"M14 3l-11 11\" />\n  <path d=\"M3 10v4h4\" />\n  <path d=\"M17 10h4v4\" />\n  <path d=\"M10 21l11 -11\" />"),
    ARROWS_DOWN(
        "arrows-down",
        "<path d=\"M7 21l0 -18\" />\n  <path d=\"M20 18l-3 3l-3 -3\" />\n  <path d=\"M4 18l3 3l3 -3\" />\n  <path d=\"M17 21l0 -18\" />"),
    ARROWS_DOWN_UP(
        "arrows-down-up",
        "<path d=\"M17 3l0 18\" />\n  <path d=\"M10 18l-3 3l-3 -3\" />\n  <path d=\"M7 21l0 -18\" />\n  <path d=\"M20 6l-3 -3l-3 3\" />"),
    ARROWS_EXCHANGE(
        "arrows-exchange", "<path d=\"M7 10h14l-4 -4\" />\n  <path d=\"M17 14h-14l4 4\" />"),
    ARROWS_EXCHANGE_2(
        "arrows-exchange-2", "<path d=\"M17 10h-14l4 -4\" />\n  <path d=\"M7 14h14l-4 4\" />"),
    ARROWS_HORIZONTAL(
        "arrows-horizontal",
        "<path d=\"M7 8l-4 4l4 4\" />\n  <path d=\"M17 8l4 4l-4 4\" />\n  <path d=\"M3 12l18 0\" />"),
    ARROWS_JOIN(
        "arrows-join",
        "<path d=\"M3 7h5l3.5 5h9.5\" />\n  <path d=\"M3 17h5l3.495 -5\" />\n  <path d=\"M18 15l3 -3l-3 -3\" />"),
    ARROWS_JOIN_2(
        "arrows-join-2",
        "<path d=\"M3 7h1.948c1.913 0 3.705 .933 4.802 2.5a5.861 5.861 0 0 0 4.802 2.5h6.448\" />\n  <path d=\"M3 17h1.95a5.854 5.854 0 0 0 4.798 -2.5a5.854 5.854 0 0 1 4.798 -2.5h5.454\" />\n  <path d=\"M18 15l3 -3l-3 -3\" />"),
    ARROWS_LEFT(
        "arrows-left",
        "<path d=\"M3 7l18 0\" />\n  <path d=\"M6 20l-3 -3l3 -3\" />\n  <path d=\"M6 4l-3 3l3 3\" />\n  <path d=\"M3 17l18 0\" />"),
    ARROWS_LEFT_DOWN(
        "arrows-left-down",
        "<path d=\"M7 3l-4 4l4 4\" />\n  <path d=\"M3 7h11a3 3 0 0 1 3 3v11\" />\n  <path d=\"M13 17l4 4l4 -4\" />"),
    ARROWS_LEFT_RIGHT(
        "arrows-left-right",
        "<path d=\"M21 17l-18 0\" />\n  <path d=\"M6 10l-3 -3l3 -3\" />\n  <path d=\"M3 7l18 0\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />"),
    ARROWS_MAXIMIZE(
        "arrows-maximize",
        "<path d=\"M16 4l4 0l0 4\" />\n  <path d=\"M14 10l6 -6\" />\n  <path d=\"M8 20l-4 0l0 -4\" />\n  <path d=\"M4 20l6 -6\" />\n  <path d=\"M16 20l4 0l0 -4\" />\n  <path d=\"M14 14l6 6\" />\n  <path d=\"M8 4l-4 0l0 4\" />\n  <path d=\"M4 4l6 6\" />"),
    ARROWS_MINIMIZE(
        "arrows-minimize",
        "<path d=\"M5 9l4 0l0 -4\" />\n  <path d=\"M3 3l6 6\" />\n  <path d=\"M5 15l4 0l0 4\" />\n  <path d=\"M3 21l6 -6\" />\n  <path d=\"M19 9l-4 0l0 -4\" />\n  <path d=\"M15 9l6 -6\" />\n  <path d=\"M19 15l-4 0l0 4\" />\n  <path d=\"M15 15l6 6\" />"),
    ARROWS_MOVE(
        "arrows-move",
        "<path d=\"M18 9l3 3l-3 3\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M3 12h6\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M12 15v6\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M12 3v6\" />"),
    ARROWS_MOVE_HORIZONTAL(
        "arrows-move-horizontal",
        "<path d=\"M18 9l3 3l-3 3\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M6 9l-3 3l3 3\" />\n  <path d=\"M3 12h6\" />"),
    ARROWS_MOVE_VERTICAL(
        "arrows-move-vertical",
        "<path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M12 15v6\" />\n  <path d=\"M15 6l-3 -3l-3 3\" />\n  <path d=\"M12 3v6\" />"),
    ARROWS_RANDOM(
        "arrows-random",
        "<path d=\"M20 21h-4v-4\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M6.5 9.504l-3.5 -2l2 -3.504\" />\n  <path d=\"M3 7.504l6.83 -1.87\" />\n  <path d=\"M4 16l4 -1l1 4\" />\n  <path d=\"M8 15l-3.5 6\" />\n  <path d=\"M21 5l-.5 4l-4 -.5\" />\n  <path d=\"M20.5 9l-4.5 -5.5\" />"),
    ARROWS_RIGHT(
        "arrows-right",
        "<path d=\"M21 17l-18 0\" />\n  <path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />\n  <path d=\"M21 7l-18 0\" />"),
    ARROWS_RIGHT_DOWN(
        "arrows-right-down",
        "<path d=\"M3 17l4 4l4 -4\" />\n  <path d=\"M7 21v-11a3 3 0 0 1 3 -3h11\" />\n  <path d=\"M17 11l4 -4l-4 -4\" />"),
    ARROWS_RIGHT_LEFT(
        "arrows-right-left",
        "<path d=\"M21 7l-18 0\" />\n  <path d=\"M18 10l3 -3l-3 -3\" />\n  <path d=\"M6 20l-3 -3l3 -3\" />\n  <path d=\"M3 17l18 0\" />"),
    ARROWS_SHUFFLE(
        "arrows-shuffle",
        "<path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />\n  <path d=\"M3 7h3a5 5 0 0 1 5 5a5 5 0 0 0 5 5h5\" />\n  <path d=\"M21 7h-5a4.978 4.978 0 0 0 -3 1m-4 8a4.984 4.984 0 0 1 -3 1h-3\" />"),
    ARROWS_SHUFFLE_2(
        "arrows-shuffle-2",
        "<path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />\n  <path d=\"M3 7h3a5 5 0 0 1 5 5a5 5 0 0 0 5 5h5\" />\n  <path d=\"M3 17h3a5 5 0 0 0 5 -5a5 5 0 0 1 5 -5h5\" />"),
    ARROWS_SORT(
        "arrows-sort",
        "<path d=\"M3 9l4 -4l4 4m-4 -4v14\" />\n  <path d=\"M21 15l-4 4l-4 -4m4 4v-14\" />"),
    ARROWS_SPLIT(
        "arrows-split",
        "<path d=\"M21 17h-8l-3.5 -5h-6.5\" />\n  <path d=\"M21 7h-8l-3.495 5\" />\n  <path d=\"M18 10l3 -3l-3 -3\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />"),
    ARROWS_SPLIT_2(
        "arrows-split-2",
        "<path d=\"M21 17h-5.397a5 5 0 0 1 -4.096 -2.133l-.514 -.734a5 5 0 0 0 -4.096 -2.133h-3.897\" />\n  <path d=\"M21 7h-5.395a5 5 0 0 0 -4.098 2.135l-.51 .73a5 5 0 0 1 -4.097 2.135h-3.9\" />\n  <path d=\"M18 10l3 -3l-3 -3\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />"),
    ARROWS_TRANSFER_DOWN(
        "arrows-transfer-down",
        "<path d=\"M17 3v6\" />\n  <path d=\"M10 18l-3 3l-3 -3\" />\n  <path d=\"M7 21v-18\" />\n  <path d=\"M20 6l-3 -3l-3 3\" />\n  <path d=\"M17 21v-2\" />\n  <path d=\"M17 15v-2\" />"),
    ARROWS_TRANSFER_UP(
        "arrows-transfer-up",
        "<path d=\"M7 21v-6\" />\n  <path d=\"M20 6l-3 -3l-3 3\" />\n  <path d=\"M17 3v18\" />\n  <path d=\"M10 18l-3 3l-3 -3\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M7 9v2\" />"),
    ARROWS_TRANSFER_UP_DOWN(
        "arrows-transfer-up-down",
        "<path d=\"M7 21v-6\" />\n  <path d=\"M20 6l-3 -3l-3 3\" />\n  <path d=\"M10 18l-3 3l-3 -3\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M7 9v2\" />\n  <path d=\"M17 3v6\" />\n  <path d=\"M17 21v-2\" />\n  <path d=\"M17 15v-2\" />"),
    ARROWS_UP(
        "arrows-up",
        "<path d=\"M17 3l0 18\" />\n  <path d=\"M4 6l3 -3l3 3\" />\n  <path d=\"M20 6l-3 -3l-3 3\" />\n  <path d=\"M7 3l0 18\" />"),
    ARROWS_UP_DOWN(
        "arrows-up-down",
        "<path d=\"M7 3l0 18\" />\n  <path d=\"M10 6l-3 -3l-3 3\" />\n  <path d=\"M20 18l-3 3l-3 -3\" />\n  <path d=\"M17 21l0 -18\" />"),
    ARROWS_UP_LEFT(
        "arrows-up-left",
        "<path d=\"M21 7l-4 -4l-4 4\" />\n  <path d=\"M17 3v11a3 3 0 0 1 -3 3h-11\" />\n  <path d=\"M7 13l-4 4l4 4\" />"),
    ARROWS_UP_RIGHT(
        "arrows-up-right",
        "<path d=\"M17 21l4 -4l-4 -4\" />\n  <path d=\"M21 17h-11a3 3 0 0 1 -3 -3v-11\" />\n  <path d=\"M11 7l-4 -4l-4 4\" />"),
    ARROWS_VERTICAL(
        "arrows-vertical",
        "<path d=\"M8 7l4 -4l4 4\" />\n  <path d=\"M8 17l4 4l4 -4\" />\n  <path d=\"M12 3l0 18\" />"),
    AXIS_X(
        "axis-x",
        "<path d=\"M4 13v.01\" />\n  <path d=\"M4 9v.01\" />\n  <path d=\"M4 5v.01\" />\n  <path d=\"M17 20l3 -3l-3 -3\" />\n  <path d=\"M4 17h16\" />"),
    AXIS_Y(
        "axis-y",
        "<path d=\"M11 20h-.01\" />\n  <path d=\"M15 20h-.01\" />\n  <path d=\"M19 20h-.01\" />\n  <path d=\"M4 7l3 -3l3 3\" />\n  <path d=\"M7 20v-16\" />"),
    CARET_DOWN("caret-down", "<path d=\"M6 10l6 6l6 -6h-12\" />"),
    CARET_LEFT("caret-left", "<path d=\"M14 6l-6 6l6 6v-12\" />"),
    CARET_RIGHT("caret-right", "<path d=\"M10 18l6 -6l-6 -6v12\" />"),
    CARET_UP("caret-up", "<path d=\"M18 14l-6 -6l-6 6h12\" />"),
    CARET_UP_DOWN(
        "caret-up-down",
        "<path d=\"M18 10l-6 -6l-6 6h12\" />\n  <path d=\"M18 14l-6 6l-6 -6h12\" />"),
    CHEVRON_COMPACT_DOWN("chevron-compact-down", "<path d=\"M4 11l8 3l8 -3\" />"),
    CHEVRON_COMPACT_LEFT("chevron-compact-left", "<path d=\"M13 20l-3 -8l3 -8\" />"),
    CHEVRON_COMPACT_RIGHT("chevron-compact-right", "<path d=\"M11 4l3 8l-3 8\" />"),
    CHEVRON_COMPACT_UP("chevron-compact-up", "<path d=\"M4 13l8 -3l8 3\" />"),
    CHEVRON_DOWN("chevron-down", "<path d=\"M6 9l6 6l6 -6\" />"),
    CHEVRON_DOWN_LEFT("chevron-down-left", "<path d=\"M8 8v8h8\" />"),
    CHEVRON_DOWN_RIGHT("chevron-down-right", "<path d=\"M16 8v8h-8\" />"),
    CHEVRON_LEFT("chevron-left", "<path d=\"M15 6l-6 6l6 6\" />"),
    CHEVRON_LEFT_PIPE(
        "chevron-left-pipe", "<path d=\"M7 6v12\" />\n  <path d=\"M18 6l-6 6l6 6\" />"),
    CHEVRON_RIGHT("chevron-right", "<path d=\"M9 6l6 6l-6 6\" />"),
    CHEVRON_RIGHT_PIPE(
        "chevron-right-pipe", "<path d=\"M6 6l6 6l-6 6\" />\n  <path d=\"M17 5v13\" />"),
    CHEVRON_UP("chevron-up", "<path d=\"M6 15l6 -6l6 6\" />"),
    CHEVRON_UP_LEFT("chevron-up-left", "<path d=\"M8 16v-8h8\" />"),
    CHEVRON_UP_RIGHT("chevron-up-right", "<path d=\"M8 8h8v8\" />"),
    CHEVRONS_DOWN("chevrons-down", "<path d=\"M7 7l5 5l5 -5\" />\n  <path d=\"M7 13l5 5l5 -5\" />"),
    CHEVRONS_DOWN_LEFT("chevrons-down-left", "<path d=\"M11 5v8h8\" />\n  <path d=\"M7 9v8h8\" />"),
    CHEVRONS_DOWN_RIGHT(
        "chevrons-down-right", "<path d=\"M13 5v8h-8\" />\n  <path d=\"M17 9v8h-8\" />"),
    CHEVRONS_LEFT(
        "chevrons-left", "<path d=\"M11 7l-5 5l5 5\" />\n  <path d=\"M17 7l-5 5l5 5\" />"),
    CHEVRONS_RIGHT(
        "chevrons-right", "<path d=\"M7 7l5 5l-5 5\" />\n  <path d=\"M13 7l5 5l-5 5\" />"),
    CHEVRONS_UP("chevrons-up", "<path d=\"M7 11l5 -5l5 5\" />\n  <path d=\"M7 17l5 -5l5 5\" />"),
    CHEVRONS_UP_LEFT("chevrons-up-left", "<path d=\"M7 15v-8h8\" />\n  <path d=\"M11 19v-8h8\" />"),
    CHEVRONS_UP_RIGHT("chevrons-up-right", "<path d=\"M9 7h8v8\" />\n  <path d=\"M5 11h8v8\" />"),
    CIRCLE_ARROW_DOWN(
        "circle-arrow-down",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M8 12l4 4\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M16 12l-4 4\" />"),
    CIRCLE_ARROW_DOWN_LEFT(
        "circle-arrow-down-left",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M15 9l-6 6\" />\n  <path d=\"M15 15h-6v-6\" />"),
    CIRCLE_ARROW_DOWN_RIGHT(
        "circle-arrow-down-right",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M15 15h-6\" />\n  <path d=\"M15 9v6l-6 -6\" />"),
    CIRCLE_ARROW_LEFT(
        "circle-arrow-left",
        "<path d=\"M12 21a9 9 0 1 0 0 -18a9 9 0 0 0 0 18\" />\n  <path d=\"M8 12l4 4\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8l-4 4\" />"),
    CIRCLE_ARROW_RIGHT(
        "circle-arrow-right",
        "<path d=\"M12 3a9 9 0 1 0 0 18a9 9 0 0 0 0 -18\" />\n  <path d=\"M16 12l-4 -4\" />\n  <path d=\"M16 12h-8\" />\n  <path d=\"M12 16l4 -4\" />"),
    CIRCLE_ARROW_UP(
        "circle-arrow-up",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M12 8l-4 4\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M16 12l-4 -4\" />"),
    CIRCLE_ARROW_UP_LEFT(
        "circle-arrow-up-left",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M9 9l6 6\" />\n  <path d=\"M15 9h-6v6\" />"),
    CIRCLE_ARROW_UP_RIGHT(
        "circle-arrow-up-right",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M15 9l-6 6\" />\n  <path d=\"M15 15v-6h-6\" />"),
    CIRCLE_CARET_DOWN(
        "circle-caret-down",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 15l-4 -4h8l-4 4\" />"),
    CIRCLE_CARET_LEFT(
        "circle-caret-left",
        "<path d=\"M9 12l4 -4v8l-4 -4\" />\n  <path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />"),
    CIRCLE_CARET_RIGHT(
        "circle-caret-right",
        "<path d=\"M15 12l-4 -4v8l4 -4\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CARET_UP(
        "circle-caret-up",
        "<path d=\"M12 9l4 4h-8l4 -4\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CHEVRON_DOWN(
        "circle-chevron-down",
        "<path d=\"M15 11l-3 3l-3 -3\" />\n  <path d=\"M12 3a9 9 0 1 0 0 18a9 9 0 0 0 0 -18\" />"),
    CIRCLE_CHEVRON_LEFT(
        "circle-chevron-left",
        "<path d=\"M13 15l-3 -3l3 -3\" />\n  <path d=\"M21 12a9 9 0 1 0 -18 0a9 9 0 0 0 18 0\" />"),
    CIRCLE_CHEVRON_RIGHT(
        "circle-chevron-right",
        "<path d=\"M11 9l3 3l-3 3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    CIRCLE_CHEVRON_UP(
        "circle-chevron-up",
        "<path d=\"M9 13l3 -3l3 3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CHEVRONS_DOWN(
        "circle-chevrons-down",
        "<path d=\"M15 9l-3 3l-3 -3\" />\n  <path d=\"M15 13l-3 3l-3 -3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CHEVRONS_LEFT(
        "circle-chevrons-left",
        "<path d=\"M15 15l-3 -3l3 -3\" />\n  <path d=\"M11 15l-3 -3l3 -3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CHEVRONS_RIGHT(
        "circle-chevrons-right",
        "<path d=\"M9 9l3 3l-3 3\" />\n  <path d=\"M13 9l3 3l-3 3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_CHEVRONS_UP(
        "circle-chevrons-up",
        "<path d=\"M9 15l3 -3l3 3\" />\n  <path d=\"M9 11l3 -3l3 3\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_OPEN_ARROW_DOWN(
        "circle-open-arrow-down",
        "<path d=\"M15.998 3.934a9 9 0 1 1 -3.998 -.934v13\" />\n  <path d=\"M16 12l-4 4l-4 -4\" />"),
    CIRCLE_OPEN_ARROW_LEFT(
        "circle-open-arrow-left",
        "<path d=\"M20.066 8.002a9 9 0 1 0 .934 3.998h-13\" />\n  <path d=\"M12 8l-4 4l4 4\" />"),
    CIRCLE_OPEN_ARROW_RIGHT(
        "circle-open-arrow-right",
        "<path d=\"M3.934 8.002a9 9 0 1 1 -.934 3.998h13\" />\n  <path d=\"M12 8l4 4l-4 4\" />"),
    CIRCLE_OPEN_ARROW_UP(
        "circle-open-arrow-up",
        "<path d=\"M15.998 20.066a9 9 0 1 0 -3.998 .934v-13\" />\n  <path d=\"M16 12l-4 -4l-4 4\" />"),
    CORNER_DOWN_LEFT(
        "corner-down-left", "<path d=\"M18 6v6a3 3 0 0 1 -3 3h-10l4 -4m0 8l-4 -4\" />"),
    CORNER_DOWN_LEFT_DOUBLE(
        "corner-down-left-double",
        "<path d=\"M19 5v6a3 3 0 0 1 -3 3h-7\" />\n  <path d=\"M13 10l-4 4l4 4m-5 -8l-4 4l4 4\" />"),
    CORNER_DOWN_RIGHT("corner-down-right", "<path d=\"M6 6v6a3 3 0 0 0 3 3h10l-4 -4m0 8l4 -4\" />"),
    CORNER_DOWN_RIGHT_DOUBLE(
        "corner-down-right-double",
        "<path d=\"M4 5v6a3 3 0 0 0 3 3h7\" />\n  <path d=\"M10 10l4 4l-4 4m5 -8l4 4l-4 4\" />"),
    CORNER_LEFT_DOWN(
        "corner-left-down", "<path d=\"M18 6h-6a3 3 0 0 0 -3 3v10l-4 -4m8 0l-4 4\" />"),
    CORNER_LEFT_DOWN_DOUBLE(
        "corner-left-down-double",
        "<path d=\"M18 4h-6a3 3 0 0 0 -3 3v7\" />\n  <path d=\"M13 10l-4 4l-4 -4m8 5l-4 4l-4 -4\" />"),
    CORNER_LEFT_UP("corner-left-up", "<path d=\"M18 18h-6a3 3 0 0 1 -3 -3v-10l-4 4m8 0l-4 -4\" />"),
    CORNER_LEFT_UP_DOUBLE(
        "corner-left-up-double",
        "<path d=\"M18 19h-6a3 3 0 0 1 -3 -3v-7\" />\n  <path d=\"M13 13l-4 -4l-4 4m8 -5l-4 -4l-4 4\" />"),
    CORNER_RIGHT_DOWN("corner-right-down", "<path d=\"M6 6h6a3 3 0 0 1 3 3v10l-4 -4m8 0l-4 4\" />"),
    CORNER_RIGHT_DOWN_DOUBLE(
        "corner-right-down-double",
        "<path d=\"M5 4h6a3 3 0 0 1 3 3v7\" />\n  <path d=\"M10 10l4 4l4 -4m-8 5l4 4l4 -4\" />"),
    CORNER_RIGHT_UP("corner-right-up", "<path d=\"M6 18h6a3 3 0 0 0 3 -3v-10l-4 4m8 0l-4 -4\" />"),
    CORNER_RIGHT_UP_DOUBLE(
        "corner-right-up-double",
        "<path d=\"M5 19h6a3 3 0 0 0 3 -3v-7\" />\n  <path d=\"M10 13l4 -4l4 4m-8 -5l4 -4l4 4\" />"),
    CORNER_UP_LEFT("corner-up-left", "<path d=\"M18 18v-6a3 3 0 0 0 -3 -3h-10l4 -4m0 8l-4 -4\" />"),
    CORNER_UP_LEFT_DOUBLE(
        "corner-up-left-double",
        "<path d=\"M19 18v-6a3 3 0 0 0 -3 -3h-7\" />\n  <path d=\"M13 13l-4 -4l4 -4m-5 8l-4 -4l4 -4\" />"),
    CORNER_UP_RIGHT("corner-up-right", "<path d=\"M6 18v-6a3 3 0 0 1 3 -3h10l-4 -4m0 8l4 -4\" />"),
    CORNER_UP_RIGHT_DOUBLE(
        "corner-up-right-double",
        "<path d=\"M4 18v-6a3 3 0 0 1 3 -3h7\" />\n  <path d=\"M10 13l4 -4l-4 -4m5 8l4 -4l-4 -4\" />"),
    DOWNLOAD(
        "download",
        "<path d=\"M4 17v2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M7 11l5 5l5 -5\" />\n  <path d=\"M12 4l0 12\" />"),
    DOWNLOAD_OFF(
        "download-off",
        "<path d=\"M4 17v2a2 2 0 0 0 2 2h12a2 2 0 0 0 1.83 -1.19\" />\n  <path d=\"M7 11l5 5l2 -2m2 -2l1 -1\" />\n  <path d=\"M12 4v4m0 4v4\" />\n  <path d=\"M3 3l18 18\" />"),
    FOLD(
        "fold",
        "<path d=\"M12 3v6l3 -3m-6 0l3 3\" />\n  <path d=\"M12 21v-6l3 3m-6 0l3 -3\" />\n  <path d=\"M4 12l1 0\" />\n  <path d=\"M9 12l1 0\" />\n  <path d=\"M14 12l1 0\" />\n  <path d=\"M19 12l1 0\" />"),
    FOLD_DOWN(
        "fold-down",
        "<path d=\"M12 11v8l3 -3m-6 0l3 3\" />\n  <path d=\"M9 7l1 0\" />\n  <path d=\"M14 7l1 0\" />\n  <path d=\"M19 7l1 0\" />\n  <path d=\"M4 7l1 0\" />"),
    FOLD_UP(
        "fold-up",
        "<path d=\"M12 13v-8l-3 3m6 0l-3 -3\" />\n  <path d=\"M9 17l1 0\" />\n  <path d=\"M14 17l1 0\" />\n  <path d=\"M19 17l1 0\" />\n  <path d=\"M4 17l1 0\" />"),
    LOGIN(
        "login",
        "<path d=\"M15 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M21 12h-13l3 -3\" />\n  <path d=\"M11 15l-3 -3\" />"),
    LOGIN_2(
        "login-2",
        "<path d=\"M9 8v-2a2 2 0 0 1 2 -2h7a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M3 12h13l-3 -3\" />\n  <path d=\"M13 15l3 -3\" />"),
    REFRESH(
        "refresh",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -15.5 -2m-.5 -4v4h4\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 15.5 2m.5 4v-4h-4\" />"),
    REFRESH_ALERT(
        "refresh-alert",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -15.5 -2m-.5 -4v4h4\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 15.5 2m.5 4v-4h-4\" />\n  <path d=\"M12 9l0 3\" />\n  <path d=\"M12 15l.01 0\" />"),
    REFRESH_DOT(
        "refresh-dot",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -15.5 -2m-.5 -4v4h4\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 15.5 2m.5 4v-4h-4\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    REFRESH_OFF(
        "refresh-off",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -11.271 -6.305m-2.41 1.624a8.083 8.083 0 0 0 -1.819 2.681m-.5 -4v4h4\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 13.671 4.691m2.329 -1.691v-1h-1\" />\n  <path d=\"M3 3l18 18\" />"),
    RELOAD(
        "reload",
        "<path d=\"M19.933 13.041a8 8 0 1 1 -9.925 -8.788c3.899 -1 7.935 1.007 9.425 4.747\" />\n  <path d=\"M20 4v5h-5\" />"),
    RIPPLE_DOWN(
        "ripple-down",
        "<path d=\"M3 7q 4.5 -3 9 0t 9 0\" />\n  <path d=\"M3 17q 4.5 -3 9 0q .213 .142 .427 .27\" />\n  <path d=\"M3 12q 4.5 -3 9 0q 2.006 1.338 4.012 1.482\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    RIPPLE_UP(
        "ripple-up",
        "<path d=\"M3 7q 4.5 -3 9 0t 9 0\" />\n  <path d=\"M3 17q 4.5 -3 9 0q .218 .144 .434 .275\" />\n  <path d=\"M3 12q 4.5 -3 9 0q 1.941 1.294 3.882 1.472\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    ROTATE("rotate", "<path d=\"M19.95 11a8 8 0 1 0 -.5 4m.5 5v-5h-5\" />"),
    ROTATE_2(
        "rotate-2",
        "<path d=\"M15 4.55a8 8 0 0 0 -6 14.9m0 -4.45v5h-5\" />\n  <path d=\"M18.37 7.16l0 .01\" />\n  <path d=\"M13 19.94l0 .01\" />\n  <path d=\"M16.84 18.37l0 .01\" />\n  <path d=\"M19.37 15.1l0 .01\" />\n  <path d=\"M19.94 11l0 .01\" />"),
    ROTATE_360(
        "rotate-360",
        "<path d=\"M12 16h4v4\" />\n  <path d=\"M19.458 11.042c.86 -2.366 .722 -4.58 -.6 -5.9c-2.272 -2.274 -7.185 -1.045 -10.973 2.743c-3.788 3.788 -5.017 8.701 -2.744 10.974c2.227 2.226 6.987 1.093 10.74 -2.515\" />"),
    ROTATE_CLOCKWISE("rotate-clockwise", "<path d=\"M4.05 11a8 8 0 1 1 .5 4m-.5 5v-5h5\" />"),
    ROTATE_CLOCKWISE_2(
        "rotate-clockwise-2",
        "<path d=\"M9 4.55a8 8 0 0 1 6 14.9m0 -4.45v5h5\" />\n  <path d=\"M5.63 7.16l0 .01\" />\n  <path d=\"M4.06 11l0 .01\" />\n  <path d=\"M4.63 15.1l0 .01\" />\n  <path d=\"M7.16 18.37l0 .01\" />\n  <path d=\"M11 19.94l0 .01\" />"),
    ROTATE_DOT(
        "rotate-dot",
        "<path d=\"M19.95 11a8 8 0 1 0 -.5 4m.5 5v-5h-5\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    ROTATE_RECTANGLE(
        "rotate-rectangle",
        "<path d=\"M10.09 4.01l.496 -.495a2 2 0 0 1 2.828 0l7.071 7.07a2 2 0 0 1 0 2.83l-7.07 7.07a2 2 0 0 1 -2.83 0l-7.07 -7.07a2 2 0 0 1 0 -2.83l3.535 -3.535h-3.988\" />\n  <path d=\"M7.05 11.038v-3.988\" />"),
    S_TURN_DOWN(
        "s-turn-down",
        "<path d=\"M7 5a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M5 7v9.5a3.5 3.5 0 0 0 7 0v-9a3.5 3.5 0 0 1 7 0v13.5\" />\n  <path d=\"M16 18l3 3l3 -3\" />"),
    S_TURN_LEFT(
        "s-turn-left",
        "<path d=\"M19 7a2 2 0 1 1 0 -4a2 2 0 0 1 0 4\" />\n  <path d=\"M17 5h-9.5a3.5 3.5 0 0 0 0 7h9a3.5 3.5 0 0 1 0 7h-13.5\" />\n  <path d=\"M6 16l-3 3l3 3\" />"),
    S_TURN_RIGHT(
        "s-turn-right",
        "<path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 5h9.5a3.5 3.5 0 0 1 0 7h-9a3.5 3.5 0 0 0 0 7h13.5\" />\n  <path d=\"M18 16l3 3l-3 3\" />"),
    S_TURN_UP(
        "s-turn-up",
        "<path d=\"M7 19a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M5 17v-9.5a3.5 3.5 0 0 1 7 0v9a3.5 3.5 0 0 0 7 0v-13.5\" />\n  <path d=\"M16 6l3 -3l3 3\" />"),
    SELECT(
        "select",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 11l3 3l3 -3\" />"),
    SELECTOR("selector", "<path d=\"M8 9l4 -4l4 4\" />\n  <path d=\"M16 15l-4 4l-4 -4\" />"),
    SHARE_2(
        "share-2",
        "<path d=\"M8 9h-1a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-8a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M12 14v-11\" />\n  <path d=\"M9 6l3 -3l3 3\" />"),
    SHARE_3(
        "share-3",
        "<path d=\"M13 4v4c-6.575 1.028 -9.02 6.788 -10 12c-.037 .206 5.384 -5.962 10 -6v4l8 -7l-8 -7\" />"),
    SQUARE_ARROW_DOWN(
        "square-arrow-down",
        "<path d=\"M8 12l4 4l4 -4\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_ARROW_LEFT(
        "square-arrow-left",
        "<path d=\"M12 8l-4 4l4 4\" />\n  <path d=\"M16 12h-8\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_ARROW_RIGHT(
        "square-arrow-right",
        "<path d=\"M12 16l4 -4l-4 -4\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_ARROW_UP(
        "square-arrow-up",
        "<path d=\"M16 12l-4 -4l-4 4\" />\n  <path d=\"M12 16v-8\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRON_DOWN(
        "square-chevron-down",
        "<path d=\"M15 11l-3 3l-3 -3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRON_LEFT(
        "square-chevron-left",
        "<path d=\"M13 15l-3 -3l3 -3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRON_RIGHT(
        "square-chevron-right",
        "<path d=\"M11 9l3 3l-3 3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRON_UP(
        "square-chevron-up",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 13l3 -3l3 3\" />"),
    SQUARE_CHEVRONS_DOWN(
        "square-chevrons-down",
        "<path d=\"M15 8l-3 3l-3 -3\" />\n  <path d=\"M15 13l-3 3l-3 -3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRONS_LEFT(
        "square-chevrons-left",
        "<path d=\"M16 15l-3 -3l3 -3\" />\n  <path d=\"M11 15l-3 -3l3 -3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRONS_RIGHT(
        "square-chevrons-right",
        "<path d=\"M8 9l3 3l-3 3\" />\n  <path d=\"M13 9l3 3l-3 3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_CHEVRONS_UP(
        "square-chevrons-up",
        "<path d=\"M9 16l3 -3l3 3\" />\n  <path d=\"M9 11l3 -3l3 3\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    SQUARE_ROUNDED_ARROW_DOWN(
        "square-rounded-arrow-down",
        "<path d=\"M8 12l4 4l4 -4\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_ARROW_LEFT(
        "square-rounded-arrow-left",
        "<path d=\"M12 8l-4 4l4 4\" />\n  <path d=\"M16 12h-8\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_ARROW_RIGHT(
        "square-rounded-arrow-right",
        "<path d=\"M12 16l4 -4l-4 -4\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_ARROW_UP(
        "square-rounded-arrow-up",
        "<path d=\"M16 12l-4 -4l-4 4\" />\n  <path d=\"M12 16v-8\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRON_DOWN(
        "square-rounded-chevron-down",
        "<path d=\"M15 11l-3 3l-3 -3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRON_LEFT(
        "square-rounded-chevron-left",
        "<path d=\"M13 15l-3 -3l3 -3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRON_RIGHT(
        "square-rounded-chevron-right",
        "<path d=\"M11 9l3 3l-3 3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRON_UP(
        "square-rounded-chevron-up",
        "<path d=\"M9 13l3 -3l3 3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRONS_DOWN(
        "square-rounded-chevrons-down",
        "<path d=\"M15 9l-3 3l-3 -3\" />\n  <path d=\"M15 13l-3 3l-3 -3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRONS_LEFT(
        "square-rounded-chevrons-left",
        "<path d=\"M15 15l-3 -3l3 -3\" />\n  <path d=\"M11 15l-3 -3l3 -3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRONS_RIGHT(
        "square-rounded-chevrons-right",
        "<path d=\"M9 9l3 3l-3 3\" />\n  <path d=\"M13 9l3 3l-3 3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    SQUARE_ROUNDED_CHEVRONS_UP(
        "square-rounded-chevrons-up",
        "<path d=\"M9 15l3 -3l3 3\" />\n  <path d=\"M9 11l3 -3l3 3\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    STEP_INTO(
        "step-into",
        "<path d=\"M12 3l0 12\" />\n  <path d=\"M16 11l-4 4\" />\n  <path d=\"M8 11l4 4\" />\n  <path d=\"M11 20a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    STEP_OUT(
        "step-out",
        "<path d=\"M12 3l0 12\" />\n  <path d=\"M16 7l-4 -4\" />\n  <path d=\"M8 7l4 -4\" />\n  <path d=\"M11 20a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    SWIPE_DOWN(
        "swipe-down",
        "<path d=\"M12 4a4 4 0 1 1 0 8a4 4 0 0 1 0 -8\" />\n  <path d=\"M12 12v8\" />\n  <path d=\"M9 17l3 3l3 -3\" />"),
    SWIPE_LEFT(
        "swipe-left",
        "<path d=\"M20 12a4 4 0 1 0 -8 0a4 4 0 0 0 8 0\" />\n  <path d=\"M12 12h-8\" />\n  <path d=\"M7 15l-3 -3l3 -3\" />"),
    SWIPE_RIGHT(
        "swipe-right",
        "<path d=\"M4 12a4 4 0 1 1 8 0a4 4 0 0 1 -8 0\" />\n  <path d=\"M12 12h8\" />\n  <path d=\"M17 15l3 -3l-3 -3\" />"),
    SWIPE_UP(
        "swipe-up",
        "<path d=\"M8 16a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M12 12v-8\" />\n  <path d=\"M9 7l3 -3l3 3\" />"),
    SWITCH(
        "switch",
        "<path d=\"M15 4l4 0l0 4\" />\n  <path d=\"M14.75 9.25l4.25 -5.25\" />\n  <path d=\"M5 19l4 -4\" />\n  <path d=\"M15 19l4 0l0 -4\" />\n  <path d=\"M5 5l14 14\" />"),
    SWITCH_2(
        "switch-2",
        "<path d=\"M3 17h5l1.67 -2.386m3.66 -5.227l1.67 -2.387h6\" />\n  <path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M3 7h5l7 10h6\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />"),
    SWITCH_3(
        "switch-3",
        "<path d=\"M3 17h2.397a5 5 0 0 0 4.096 -2.133l.177 -.253m3.66 -5.227l.177 -.254a5 5 0 0 1 4.096 -2.133h3.397\" />\n  <path d=\"M18 4l3 3l-3 3\" />\n  <path d=\"M3 7h2.397a5 5 0 0 1 4.096 2.133l4.014 5.734a5 5 0 0 0 4.096 2.133h3.397\" />\n  <path d=\"M18 20l3 -3l-3 -3\" />"),
    SWITCH_HORIZONTAL(
        "switch-horizontal",
        "<path d=\"M16 3l4 4l-4 4\" />\n  <path d=\"M10 7l10 0\" />\n  <path d=\"M8 13l-4 4l4 4\" />\n  <path d=\"M4 17l9 0\" />"),
    SWITCH_VERTICAL(
        "switch-vertical",
        "<path d=\"M3 8l4 -4l4 4\" />\n  <path d=\"M7 4l0 9\" />\n  <path d=\"M13 16l4 4l4 -4\" />\n  <path d=\"M17 10l0 10\" />"),
    TRANSITION_BOTTOM(
        "transition-bottom",
        "<path d=\"M21 18a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3\" />\n  <path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3\" />\n  <path d=\"M12 9v8\" />\n  <path d=\"M9 14l3 3l3 -3\" />"),
    TRANSITION_LEFT(
        "transition-left",
        "<path d=\"M6 21a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3\" />\n  <path d=\"M21 6v12a3 3 0 0 1 -6 0v-12a3 3 0 0 1 6 0\" />\n  <path d=\"M15 12h-8\" />\n  <path d=\"M10 9l-3 3l3 3\" />"),
    TRANSITION_RIGHT(
        "transition-right",
        "<path d=\"M18 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3\" />\n  <path d=\"M3 18v-12a3 3 0 1 1 6 0v12a3 3 0 0 1 -6 0\" />\n  <path d=\"M9 12h8\" />\n  <path d=\"M14 15l3 -3l-3 -3\" />"),
    TRANSITION_TOP(
        "transition-top",
        "<path d=\"M21 6a3 3 0 0 0 -3 -3h-12a3 3 0 0 0 -3 3\" />\n  <path d=\"M6 21h12a3 3 0 0 0 0 -6h-12a3 3 0 0 0 0 6\" />\n  <path d=\"M12 15v-8\" />\n  <path d=\"M9 10l3 -3l3 3\" />"),
    TRENDING_DOWN(
        "trending-down", "<path d=\"M3 7l6 6l4 -4l8 8\" />\n  <path d=\"M21 10l0 7l-7 0\" />"),
    TRENDING_DOWN_2(
        "trending-down-2", "<path d=\"M3 6h5l7 10h6\" />\n  <path d=\"M18 19l3 -3l-3 -3\" />"),
    TRENDING_DOWN_3(
        "trending-down-3",
        "<path d=\"M3 6h2.397a5 5 0 0 1 4.096 2.133l4.014 5.734a5 5 0 0 0 4.096 2.133h3.397\" />\n  <path d=\"M18 19l3 -3l-3 -3\" />"),
    TRENDING_UP(
        "trending-up", "<path d=\"M3 17l6 -6l4 4l8 -8\" />\n  <path d=\"M14 7l7 0l0 7\" />"),
    TRENDING_UP_2(
        "trending-up-2", "<path d=\"M18 5l3 3l-3 3\" />\n  <path d=\"M3 18h5l7 -10h6\" />"),
    TRENDING_UP_3(
        "trending-up-3",
        "<path d=\"M18 5l3 3l-3 3\" />\n  <path d=\"M3 18h2.397a5 5 0 0 0 4.096 -2.133l4.014 -5.734a5 5 0 0 1 4.096 -2.133h3.397\" />"),
    U_TURN_LEFT(
        "u-turn-left",
        "<path d=\"M17 20v-11.5a4.5 4.5 0 1 0 -9 0v8.5\" />\n  <path d=\"M11 14l-3 3l-3 -3\" />"),
    U_TURN_RIGHT(
        "u-turn-right",
        "<path d=\"M7 20v-11.5a4.5 4.5 0 0 1 9 0v8.5\" />\n  <path d=\"M13 14l3 3l3 -3\" />"),
    UPLOAD(
        "upload",
        "<path d=\"M4 17v2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M7 9l5 -5l5 5\" />\n  <path d=\"M12 4l0 12\" />");

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
    ARROW_AUTOFIT_CONTENT(
        "arrow-autofit-content",
        "<path d=\"M6.707 3.293a1 1 0 0 1 .083 1.32l-.083 .094l-1.292 1.293h4.585a1 1 0 0 1 .117 1.993l-.117 .007h-4.585l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1.008 1.008 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.064 -.092l.083 -.094l3 -3a1 1 0 0 1 1.414 0z\" />\n  <path d=\"M18.613 3.21l.094 .083l3 3a.927 .927 0 0 1 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.292 -1.293h-4.585a1 1 0 0 1 -.117 -1.993l.117 -.007h4.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083z\" />\n  <path d=\"M18 13h-12a3 3 0 0 0 -3 3v2a3 3 0 0 0 3 3h12a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3z\" />"),
    ARROW_AUTOFIT_DOWN(
        "arrow-autofit-down",
        "<path d=\"M14 3a1 1 0 0 1 1 1v11.001h-.092a3 3 0 0 0 -2.03 5.12a.515 .515 0 0 1 -.363 .879h-6.515a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 3a1 1 0 0 1 1 1v14.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-14.586a1 1 0 0 1 1 -1\" />"),
    ARROW_AUTOFIT_HEIGHT(
        "arrow-autofit-height",
        "<path d=\"M12.879 3.879a3 3 0 0 0 0 4.242l.09 .085l.094 .083l.096 .08l.158 .115a3 3 0 0 0 1.59 .515l.093 -.001v6.003h-.092a3 3 0 0 0 -2.03 5.12a.514 .514 0 0 1 -.363 .878l-6.515 .001a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h6.514a.515 .515 0 0 1 .365 .879\" />\n  <path d=\"M18 13a1 1 0 0 1 1 1v4.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-4.586a1 1 0 0 1 1 -1\" />\n  <path d=\"M17.852 2.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v4.585a1 1 0 0 1 -2 0v-4.585l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />"),
    ARROW_AUTOFIT_LEFT(
        "arrow-autofit-left",
        "<path d=\"M21 14a1 1 0 0 1 -1 1h-11.001v-.092a3 3 0 0 0 -5.12 -2.03a.515 .515 0 0 1 -.879 -.363v-6.515a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3z\" />\n  <path d=\"M21 18a1 1 0 0 1 -1 1h-14.584l1.291 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.03 -.149l-.006 -.117l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 1 1 1.414 1.414l-1.293 1.293h14.586a1 1 0 0 1 1 1\" />"),
    ARROW_AUTOFIT_RIGHT(
        "arrow-autofit-right",
        "<path d=\"M3 14a1 1 0 0 0 1 1h11.001v-.092a3 3 0 0 1 5.12 -2.03a.515 .515 0 0 0 .879 -.363v-6.515a3 3 0 0 0 -3 -3h-12a3 3 0 0 0 -3 3z\" />\n  <path d=\"M3 18a1 1 0 0 0 1 1h14.584l-1.291 1.293a1 1 0 0 0 -.083 1.32l.083 .094a1 1 0 0 0 1.414 0l3 -3q .054 -.053 .097 -.112l.071 -.11l.054 -.114l.035 -.105l.03 -.149l.006 -.117l-.003 -.075l-.017 -.126l-.03 -.111l-.044 -.111l-.052 -.098l-.067 -.096l-.08 -.09l-3 -3a1 1 0 0 0 -1.414 1.414l1.293 1.293h-14.586a1 1 0 0 0 -1 1\" />"),
    ARROW_AUTOFIT_UP(
        "arrow-autofit-up",
        "<path d=\"M14 21a1 1 0 0 0 1 -1v-11.001h-.092a3 3 0 0 1 -2.03 -5.12a.515 .515 0 0 0 -.363 -.879h-6.515a3 3 0 0 0 -3 3v12a3 3 0 0 0 3 3z\" />\n  <path d=\"M18 21a1 1 0 0 0 1 -1v-14.584l1.293 1.291a1 1 0 0 0 1.32 .083l.094 -.083a1 1 0 0 0 0 -1.414l-3 -3a1 1 0 0 0 -.112 -.097l-.11 -.071l-.114 -.054l-.105 -.035l-.149 -.03l-.117 -.006l-.075 .003l-.126 .017l-.111 .03l-.111 .044l-.098 .052l-.096 .067l-.09 .08l-3 3a1 1 0 1 0 1.414 1.414l1.293 -1.293v14.586a1 1 0 0 0 1 1\" />"),
    ARROW_AUTOFIT_WIDTH(
        "arrow-autofit-width",
        "<path d=\"M20.121 12.879a3 3 0 0 0 -4.242 0l-.085 .09l-.083 .094l-.08 .096l-.115 .158a3 3 0 0 0 -.515 1.59l.001 .093h-6.003v-.092a3 3 0 0 0 -5.12 -2.03a.514 .514 0 0 1 -.878 -.363l-.001 -6.515a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.514a.515 .515 0 0 1 -.879 .365\" />\n  <path d=\"M11 18a1 1 0 0 1 -1 1h-4.584l1.291 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.03 -.149l-.006 -.117l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 1.414l-1.293 1.293h4.586a1 1 0 0 1 1 1m10.989 -.148l.007 .058l.004 .09l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 1 1 -1.414 -1.414l1.292 -1.293h-4.585a1 1 0 0 1 0 -2h4.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0l3 3q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105z\" />"),
    ARROW_BADGE_DOWN(
        "arrow-badge-down",
        "<path d=\"M16.375 6.22l-4.375 3.498l-4.375 -3.5a1 1 0 0 0 -1.625 .782v6a1 1 0 0 0 .375 .78l5 4a1 1 0 0 0 1.25 0l5 -4a1 1 0 0 0 .375 -.78v-6a1 1 0 0 0 -1.625 -.78z\" />"),
    ARROW_BADGE_LEFT(
        "arrow-badge-left",
        "<path d=\"M17 6h-6a1 1 0 0 0 -.78 .375l-4 5a1 1 0 0 0 0 1.25l4 5a1 1 0 0 0 .78 .375h6l.112 -.006a1 1 0 0 0 .669 -1.619l-3.501 -4.375l3.5 -4.375a1 1 0 0 0 -.78 -1.625z\" />"),
    ARROW_BADGE_RIGHT(
        "arrow-badge-right",
        "<path d=\"M7 6l-.112 .006a1 1 0 0 0 -.669 1.619l3.501 4.375l-3.5 4.375a1 1 0 0 0 .78 1.625h6a1 1 0 0 0 .78 -.375l4 -5a1 1 0 0 0 0 -1.25l-4 -5a1 1 0 0 0 -.78 -.375h-6z\" />"),
    ARROW_BADGE_UP(
        "arrow-badge-up",
        "<path d=\"M11.375 6.22l-5 4a1 1 0 0 0 -.375 .78v6l.006 .112a1 1 0 0 0 1.619 .669l4.375 -3.501l4.375 3.5a1 1 0 0 0 1.625 -.78v-6a1 1 0 0 0 -.375 -.78l-5 -4a1 1 0 0 0 -1.25 0z\" />"),
    ARROW_BIG_DOWN(
        "arrow-big-down",
        "<path d=\"M10 2l-.15 .005a2 2 0 0 0 -1.85 1.995v6.999l-2.586 .001a2 2 0 0 0 -1.414 3.414l6.586 6.586a2 2 0 0 0 2.828 0l6.586 -6.586a2 2 0 0 0 .434 -2.18l-.068 -.145a2 2 0 0 0 -1.78 -1.089l-2.586 -.001v-6.999a2 2 0 0 0 -2 -2h-4z\" />"),
    ARROW_BIG_DOWN_LINE(
        "arrow-big-down-line",
        "<path d=\"M9 5l-.117 .007a1 1 0 0 0 -.883 .993v4.999l-2.586 .001a2 2 0 0 0 -1.414 3.414l6.586 6.586a2 2 0 0 0 2.828 0l6.586 -6.586a2 2 0 0 0 .434 -2.18l-.068 -.145a2 2 0 0 0 -1.78 -1.089l-2.586 -.001v-4.999a1 1 0 0 0 -1 -1h-6z\" />\n  <path d=\"M15 2a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />"),
    ARROW_BIG_DOWN_LINES(
        "arrow-big-down-lines",
        "<path d=\"M9 8l-.117 .007a1 1 0 0 0 -.883 .993v1.999l-2.586 .001a2 2 0 0 0 -1.414 3.414l6.586 6.586a2 2 0 0 0 2.828 0l6.586 -6.586a2 2 0 0 0 .434 -2.18l-.068 -.145a2 2 0 0 0 -1.78 -1.089l-2.586 -.001v-1.999a1 1 0 0 0 -1 -1h-6z\" />\n  <path d=\"M15 2a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />\n  <path d=\"M15 5a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />"),
    ARROW_BIG_LEFT(
        "arrow-big-left",
        "<path d=\"M9.586 4l-6.586 6.586a2 2 0 0 0 0 2.828l6.586 6.586a2 2 0 0 0 2.18 .434l.145 -.068a2 2 0 0 0 1.089 -1.78v-2.586h7a2 2 0 0 0 2 -2v-4l-.005 -.15a2 2 0 0 0 -1.995 -1.85l-7 -.001v-2.585a2 2 0 0 0 -3.414 -1.414z\" />"),
    ARROW_BIG_LEFT_LINE(
        "arrow-big-left-line",
        "<path d=\"M9.586 4l-6.586 6.586a2 2 0 0 0 0 2.828l6.586 6.586a2 2 0 0 0 2.18 .434l.145 -.068a2 2 0 0 0 1.089 -1.78v-2.586h5a1 1 0 0 0 1 -1v-6l-.007 -.117a1 1 0 0 0 -.993 -.883l-5 -.001v-2.585a2 2 0 0 0 -3.414 -1.414z\" />\n  <path d=\"M4.415 12l6.585 -6.586v3.586l.007 .117a1 1 0 0 0 .993 .883l5 -.001v4l-5 .001a1 1 0 0 0 -1 1v3.586l-6.585 -6.586z\" />\n  <path d=\"M21 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />"),
    ARROW_BIG_LEFT_LINES(
        "arrow-big-left-lines",
        "<path d=\"M9.586 4l-6.586 6.586a2 2 0 0 0 0 2.828l6.586 6.586a2 2 0 0 0 2.18 .434l.145 -.068a2 2 0 0 0 1.089 -1.78v-2.586h2a1 1 0 0 0 1 -1v-6l-.007 -.117a1 1 0 0 0 -.993 -.883l-2 -.001v-2.585a2 2 0 0 0 -3.414 -1.414z\" />\n  <path d=\"M21 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />"),
    ARROW_BIG_RIGHT(
        "arrow-big-right",
        "<path d=\"M12.089 3.634a2 2 0 0 0 -1.089 1.78l-.001 2.586h-6.999a2 2 0 0 0 -2 2v4l.005 .15a2 2 0 0 0 1.995 1.85l6.999 -.001l.001 2.587a2 2 0 0 0 3.414 1.414l6.586 -6.586a2 2 0 0 0 0 -2.828l-6.586 -6.586a2 2 0 0 0 -2.18 -.434l-.145 .068z\" />"),
    ARROW_BIG_RIGHT_LINE(
        "arrow-big-right-line",
        "<path d=\"M12.089 3.634a2 2 0 0 0 -1.089 1.78l-.001 2.586h-4.999a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 .993 .883l4.999 -.001l.001 2.587a2 2 0 0 0 3.414 1.414l6.586 -6.586a2 2 0 0 0 0 -2.828l-6.586 -6.586a2 2 0 0 0 -2.18 -.434l-.145 .068z\" />\n  <path d=\"M3 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />"),
    ARROW_BIG_RIGHT_LINES(
        "arrow-big-right-lines",
        "<path d=\"M12.089 3.634a2 2 0 0 0 -1.089 1.78l-.001 2.585l-1.999 .001a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 .993 .883l1.999 -.001l.001 2.587a2 2 0 0 0 3.414 1.414l6.586 -6.586a2 2 0 0 0 0 -2.828l-6.586 -6.586a2 2 0 0 0 -2.18 -.434l-.145 .068z\" />\n  <path d=\"M3 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />\n  <path d=\"M6 8a1 1 0 0 1 .993 .883l.007 .117v6a1 1 0 0 1 -1.993 .117l-.007 -.117v-6a1 1 0 0 1 1 -1z\" />"),
    ARROW_BIG_UP(
        "arrow-big-up",
        "<path d=\"M10.586 3l-6.586 6.586a2 2 0 0 0 -.434 2.18l.068 .145a2 2 0 0 0 1.78 1.089h2.586v7a2 2 0 0 0 2 2h4l.15 -.005a2 2 0 0 0 1.85 -1.995l-.001 -7h2.587a2 2 0 0 0 1.414 -3.414l-6.586 -6.586a2 2 0 0 0 -2.828 0z\" />"),
    ARROW_BIG_UP_LINE(
        "arrow-big-up-line",
        "<path d=\"M10.586 3l-6.586 6.586a2 2 0 0 0 -.434 2.18l.068 .145a2 2 0 0 0 1.78 1.089h2.586v5a1 1 0 0 0 1 1h6l.117 -.007a1 1 0 0 0 .883 -.993l-.001 -5h2.587a2 2 0 0 0 1.414 -3.414l-6.586 -6.586a2 2 0 0 0 -2.828 0z\" />\n  <path d=\"M15 20a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />"),
    ARROW_BIG_UP_LINES(
        "arrow-big-up-lines",
        "<path d=\"M10.586 3l-6.586 6.586a2 2 0 0 0 -.434 2.18l.068 .145a2 2 0 0 0 1.78 1.089h2.586v2a1 1 0 0 0 1 1h6l.117 -.007a1 1 0 0 0 .883 -.993l-.001 -2h2.587a2 2 0 0 0 1.414 -3.414l-6.586 -6.586a2 2 0 0 0 -2.828 0z\" />\n  <path d=\"M15 20a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />\n  <path d=\"M15 17a1 1 0 0 1 .117 1.993l-.117 .007h-6a1 1 0 0 1 -.117 -1.993l.117 -.007h6z\" />"),
    ARROW_DOWN_CIRCLE(
        "arrow-down-circle",
        "<path d=\"M12 2a3 3 0 0 1 1 5.829v10.755l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-10.757a3.001 3.001 0 0 1 1 -5.829\" />"),
    ARROW_DOWN_RHOMBUS(
        "arrow-down-rhombus",
        "<path d=\"M12.707 2.293l2.5 2.5a1 1 0 0 1 0 1.414l-2.207 2.207v10.17l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-10.171l-2.207 -2.208a1 1 0 0 1 0 -1.414l2.5 -2.5a1 1 0 0 1 1.414 0\" />"),
    ARROW_DOWN_SQUARE(
        "arrow-down-square",
        "<path d=\"M14 2a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-1v10.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-10.586h-1a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1z\" />"),
    ARROW_GUIDE(
        "arrow-guide",
        "<path d=\"M18.707 3.293l3 3q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.067 .096l-.08 .09l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-4.585a1 1 0 0 0 -1 1v8a3 3 0 0 1 -3 3h-2.171a3.001 3.001 0 0 1 -5.829 -1l.005 -.176a3 3 0 0 1 5.825 -.824h2.17a1 1 0 0 0 1 -1v-8a3 3 0 0 1 3 -3h4.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0\" />"),
    ARROW_LEFT_CIRCLE(
        "arrow-left-circle",
        "<path d=\"M6.707 8.293a1 1 0 0 1 0 1.414l-1.292 1.293h10.756a3.001 3.001 0 1 1 0 2h-10.756l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 0\" />"),
    ARROW_LEFT_RHOMBUS(
        "arrow-left-rhombus",
        "<path d=\"M6.707 8.293a1 1 0 0 1 0 1.414l-1.292 1.293h10.169l2.209 -2.207a1 1 0 0 1 1.414 0l2.5 2.5a1 1 0 0 1 0 1.414l-2.5 2.5a1 1 0 0 1 -1.414 0l-2.208 -2.207h-10.17l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 0\" />"),
    ARROW_LEFT_SQUARE(
        "arrow-left-square",
        "<path d=\"M6.707 8.293a1 1 0 0 1 0 1.414l-1.292 1.293h10.585v-1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-1h-10.585l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 0\" />"),
    ARROW_MOVE_DOWN(
        "arrow-move-down",
        "<path d=\"M12 10a1 1 0 0 1 1 1v7.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-7.586a1 1 0 0 1 1 -1m0 -8a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />"),
    ARROW_MOVE_LEFT(
        "arrow-move-left",
        "<path d=\"M6.707 8.293a1 1 0 0 1 0 1.414l-1.292 1.293h7.585a1 1 0 0 1 0 2h-7.585l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 0m12.293 .707a3 3 0 1 1 0 6a3 3 0 0 1 0 -6\" />"),
    ARROW_MOVE_RIGHT(
        "arrow-move-right",
        "<path d=\"M18.707 8.293l3 3q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-7.585a1 1 0 0 1 0 -2h7.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0m-13.707 .707a3 3 0 1 1 0 6a3 3 0 0 1 0 -6\" />"),
    ARROW_MOVE_UP(
        "arrow-move-up",
        "<path d=\"M11.852 2.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v7.585a1 1 0 0 1 -2 0v-7.585l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />\n  <path d=\"M12 16a3 3 0 1 1 0 6a3 3 0 0 1 0 -6\" />"),
    ARROW_RIGHT_CIRCLE(
        "arrow-right-circle",
        "<path d=\"M5 15a3 3 0 0 1 -3 -3l.005 -.176a3 3 0 0 1 5.825 -.824h10.756l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0l3 3l.097 .112l.071 .11l.031 .062l.034 .081l.024 .076l.03 .148l.005 .118l-.004 .085l-.016 .116l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-10.756a3 3 0 0 1 -2.829 2\" />"),
    ARROW_RIGHT_RHOMBUS(
        "arrow-right-rhombus",
        "<path d=\"M18.707 8.293l3 3l.097 .112l.071 .11l.031 .062l.034 .081l.024 .076l.03 .148l.006 .118l-.004 .085l-.016 .116l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-10.171l-2.207 2.207a1 1 0 0 1 -1.414 0l-2.5 -2.5a1 1 0 0 1 0 -1.414l2.5 -2.5a1 1 0 0 1 1.414 0l2.208 2.207h10.17l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0\" />"),
    ARROW_RIGHT_SQUARE(
        "arrow-right-square",
        "<path d=\"M18.707 8.293l3 3q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-10.585v1a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v1h10.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0\" />"),
    ARROW_UP_CIRCLE(
        "arrow-up-circle",
        "<path d=\"M11.852 2.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v10.756a3.001 3.001 0 1 1 -2 0v-10.756l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />"),
    ARROW_UP_RHOMBUS(
        "arrow-up-rhombus",
        "<path d=\"M12 2l.081 .003l.12 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v10.17l2.207 2.208a1 1 0 0 1 0 1.414l-2.5 2.5a1 1 0 0 1 -1.414 0l-2.5 -2.5a1 1 0 0 1 0 -1.414l2.207 -2.209v-10.169l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3l.112 -.097l.11 -.071l.062 -.031l.081 -.034l.076 -.024l.118 -.025l.058 -.007z\" />"),
    ARROW_UP_SQUARE(
        "arrow-up-square",
        "<path d=\"M11.852 2.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v10.585h1a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h1v-10.585l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />"),
    CARET_DOWN(
        "caret-down",
        "<path d=\"M18 9c.852 0 1.297 .986 .783 1.623l-.076 .084l-6 6a1 1 0 0 1 -1.32 .083l-.094 -.083l-6 -6l-.083 -.094l-.054 -.077l-.054 -.096l-.017 -.036l-.027 -.067l-.032 -.108l-.01 -.053l-.01 -.06l-.004 -.057v-.118l.005 -.058l.009 -.06l.01 -.052l.032 -.108l.027 -.067l.07 -.132l.065 -.09l.073 -.081l.094 -.083l.077 -.054l.096 -.054l.036 -.017l.067 -.027l.108 -.032l.053 -.01l.06 -.01l.057 -.004l12.059 -.002z\" />"),
    CARET_LEFT(
        "caret-left",
        "<path d=\"M13.883 5.007l.058 -.005h.118l.058 .005l.06 .009l.052 .01l.108 .032l.067 .027l.132 .07l.09 .065l.081 .073l.083 .094l.054 .077l.054 .096l.017 .036l.027 .067l.032 .108l.01 .053l.01 .06l.004 .057l.002 .059v12c0 .852 -.986 1.297 -1.623 .783l-.084 -.076l-6 -6a1 1 0 0 1 -.083 -1.32l.083 -.094l6 -6l.094 -.083l.077 -.054l.096 -.054l.036 -.017l.067 -.027l.108 -.032l.053 -.01l.06 -.01z\" />"),
    CARET_RIGHT(
        "caret-right",
        "<path d=\"M9 6c0 -.852 .986 -1.297 1.623 -.783l.084 .076l6 6a1 1 0 0 1 .083 1.32l-.083 .094l-6 6l-.094 .083l-.077 .054l-.096 .054l-.036 .017l-.067 .027l-.108 .032l-.053 .01l-.06 .01l-.057 .004l-.059 .002l-.059 -.002l-.058 -.005l-.06 -.009l-.052 -.01l-.108 -.032l-.067 -.027l-.132 -.07l-.09 -.065l-.081 -.073l-.083 -.094l-.054 -.077l-.054 -.096l-.017 -.036l-.027 -.067l-.032 -.108l-.01 -.053l-.01 -.06l-.004 -.057l-.002 -12.059z\" />"),
    CARET_UP(
        "caret-up",
        "<path d=\"M11.293 7.293a1 1 0 0 1 1.32 -.083l.094 .083l6 6l.083 .094l.054 .077l.054 .096l.017 .036l.027 .067l.032 .108l.01 .053l.01 .06l.004 .057l.002 .059l-.002 .059l-.005 .058l-.009 .06l-.01 .052l-.032 .108l-.027 .067l-.07 .132l-.065 .09l-.073 .081l-.094 .083l-.077 .054l-.096 .054l-.036 .017l-.067 .027l-.108 .032l-.053 .01l-.06 .01l-.057 .004l-.059 .002h-12c-.852 0 -1.297 -.986 -.783 -1.623l.076 -.084l6 -6z\" />"),
    CARET_UP_DOWN(
        "caret-up-down",
        "<path d=\"M11.293 3.293a1 1 0 0 1 1.414 0l6 6a.95 .95 0 0 1 .073 .082l.006 .008l.016 .022l.042 .059l.009 .015l.007 .01l.014 .027l.024 .044l.007 .017l.01 .02l.012 .032l.015 .034l.007 .025l.008 .02l.005 .026l.012 .037l.004 .028l.006 .025l.003 .026l.006 .033l.002 .03l.003 .028v.026l.002 .033l-.002 .033v.026l-.003 .026l-.002 .032l-.005 .029l-.004 .03l-.006 .024l-.004 .03l-.012 .035l-.005 .027l-.008 .019l-.007 .026l-.015 .033l-.012 .034l-.01 .018l-.007 .018l-.024 .043l-.014 .028l-.007 .009l-.009 .016l-.042 .058l-.012 .019l-.004 .003l-.006 .01a1.006 1.006 0 0 1 -.155 .154l-.009 .006l-.022 .016l-.058 .042l-.016 .009l-.009 .007l-.028 .014l-.043 .024l-.018 .007l-.018 .01l-.034 .012l-.033 .015l-.024 .006l-.021 .009l-.027 .005l-.036 .012l-.029 .004l-.024 .006l-.028 .003l-.031 .006l-.032 .002l-.026 .003h-.026l-.033 .002h-12c-.89 0 -1.337 -1.077 -.707 -1.707l6 -6z\" />\n  <path d=\"M18 13l.033 .002h.026l.026 .003l.032 .002l.031 .006l.028 .003l.024 .006l.03 .004l.035 .012l.027 .005l.019 .008l.026 .007l.033 .015l.034 .012l.018 .01l.018 .007l.043 .024l.028 .014l.009 .007l.016 .009l.051 .037l.026 .017l.003 .004l.01 .006a.982 .982 0 0 1 .154 .155l.006 .009l.015 .02l.043 .06l.009 .016l.007 .009l.014 .028l.024 .043l.005 .013l.012 .023l.012 .034l.015 .033l.007 .026l.008 .02l.005 .026l.012 .036l.004 .029l.006 .024l.003 .028l.006 .031l.002 .032l.003 .026v.026l.002 .033l-.002 .033v.026l-.003 .026l-.002 .032l-.006 .031l-.003 .028l-.006 .024l-.004 .03l-.012 .035l-.005 .027l-.008 .019l-.007 .026l-.015 .033l-.012 .034l-.01 .018l-.007 .018l-.024 .043l-.014 .028l-.007 .009l-.009 .016l-.042 .058l-.012 .019l-.004 .003l-.006 .01l-.073 .081l-6 6a1 1 0 0 1 -1.414 0l-6 -6c-.63 -.63 -.184 -1.707 .707 -1.707h12z\" />"),
    CHEVRON_DOWN(
        "chevron-down",
        "<path d=\"M18.707 8.293a1 1 0 0 1 0 1.414l-6 6a1 1 0 0 1 -1.414 0l-6 -6a1 1 0 0 1 1.414 -1.414l5.293 5.293l5.293 -5.293a1 1 0 0 1 1.414 0\" />"),
    CHEVRON_RIGHT(
        "chevron-right",
        "<path d=\"M9.707 5.293l6 6a1 1 0 0 1 0 1.414l-6 6a1 1 0 1 1 -1.414 -1.414l5.293 -5.293l-5.293 -5.293a1 1 0 0 1 1.414 -1.414\" />"),
    CIRCLE_ARROW_DOWN(
        "circle-arrow-down",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-5 3.66a1 1 0 0 0 -1 1v5.585l-2.293 -2.292l-.094 -.083a1 1 0 0 0 -1.32 1.497l4 4c.028 .028 .057 .054 .094 .083l.092 .064l.098 .052l.081 .034l.113 .034l.112 .02l.117 .006l.115 -.007l.114 -.02l.142 -.044l.113 -.054l.111 -.071a.939 .939 0 0 0 .112 -.097l4 -4l.083 -.094a1 1 0 0 0 -1.497 -1.32l-2.293 2.291v-5.584l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    CIRCLE_ARROW_DOWN_LEFT(
        "circle-arrow-down-left",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-8 4.66a1 1 0 0 0 -1 1v6l.007 .117l.029 .149l.035 .105l.054 .113l.071 .111c.03 .04 .061 .077 .097 .112l.09 .08l.096 .067l.098 .052l.11 .044l.112 .03l.126 .017l6.075 .003l.117 -.007a1 1 0 0 0 .883 -.993l-.007 -.117a1 1 0 0 0 -.993 -.883h-3.586l4.293 -4.293l.083 -.094a1 1 0 0 0 -1.497 -1.32l-4.293 4.291v-3.584l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    CIRCLE_ARROW_DOWN_RIGHT(
        "circle-arrow-down-right",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2 4.66l-.117 .007a1 1 0 0 0 -.883 .993v3.585l-4.293 -4.292l-.094 -.083a1 1 0 0 0 -1.32 1.497l4.292 4.293h-3.585l-.117 .007a1 1 0 0 0 .117 1.993l6.034 .001a.998 .998 0 0 0 .186 -.025l.053 -.014l.066 -.02l.13 -.059l.093 -.055a.98 .98 0 0 0 .438 -.828v-6l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    CIRCLE_ARROW_LEFT(
        "circle-arrow-left",
        "<path d=\"M12 2a10 10 0 0 1 .324 19.995l-.324 .005l-.324 -.005a10 10 0 0 1 .324 -19.995zm.707 5.293a1 1 0 0 0 -1.414 0l-4 4a1.048 1.048 0 0 0 -.083 .094l-.064 .092l-.052 .098l-.044 .11l-.03 .112l-.017 .126l-.003 .075l.004 .09l.007 .058l.025 .118l.035 .105l.054 .113l.043 .07l.071 .095l.054 .058l4 4l.094 .083a1 1 0 0 0 1.32 -1.497l-2.292 -2.293h5.585l.117 -.007a1 1 0 0 0 -.117 -1.993h-5.586l2.293 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    CIRCLE_ARROW_RIGHT(
        "circle-arrow-right",
        "<path d=\"M12 2l.324 .005a10 10 0 1 1 -.648 0l.324 -.005zm.613 5.21a1 1 0 0 0 -1.32 1.497l2.291 2.293h-5.584l-.117 .007a1 1 0 0 0 .117 1.993h5.584l-2.291 2.293l-.083 .094a1 1 0 0 0 1.497 1.32l4 -4l.073 -.082l.064 -.089l.062 -.113l.044 -.11l.03 -.112l.017 -.126l.003 -.075l-.007 -.118l-.029 -.148l-.035 -.105l-.054 -.113l-.071 -.111a1.008 1.008 0 0 0 -.097 -.112l-4 -4z\" />"),
    CIRCLE_ARROW_UP(
        "circle-arrow-up",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-4.98 3.66l-.163 .01l-.086 .016l-.142 .045l-.113 .054l-.07 .043l-.095 .071l-.058 .054l-4 4l-.083 .094a1 1 0 0 0 1.497 1.32l2.293 -2.293v5.586l.007 .117a1 1 0 0 0 1.993 -.117v-5.585l2.293 2.292l.094 .083a1 1 0 0 0 1.32 -1.497l-4 -4l-.082 -.073l-.089 -.064l-.113 -.062l-.081 -.034l-.113 -.034l-.112 -.02l-.098 -.006z\" />"),
    CIRCLE_ARROW_UP_LEFT(
        "circle-arrow-up-left",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2 4.66h-6l-.117 .007l-.149 .029l-.105 .035l-.113 .054l-.111 .071a1.01 1.01 0 0 0 -.112 .097l-.08 .09l-.067 .096l-.052 .098l-.044 .11l-.03 .112l-.017 .126l-.003 6.075l.007 .117a1 1 0 0 0 .993 .883l.117 -.007a1 1 0 0 0 .883 -.993v-3.585l4.293 4.292l.094 .083a1 1 0 0 0 1.32 -1.497l-4.292 -4.293h3.585l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    CIRCLE_ARROW_UP_RIGHT(
        "circle-arrow-up-right",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2 4.66h-6l-.117 .007a1 1 0 0 0 -.883 .993l.007 .117a1 1 0 0 0 .993 .883h3.584l-4.291 4.293l-.083 .094a1 1 0 0 0 1.497 1.32l4.293 -4.293v3.586l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117l-.029 -.149l-.035 -.105l-.054 -.113l-.071 -.111a1.01 1.01 0 0 0 -.097 -.112l-.09 -.08l-.096 -.067l-.098 -.052l-.11 -.044l-.112 -.03l-.126 -.017l-.075 -.003z\" />"),
    CIRCLE_CARET_DOWN(
        "circle-caret-down",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-2 6.66h-6a1 1 0 0 0 -.708 1.707l3 3a1 1 0 0 0 1.415 0l3 -3a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -.613 -.21\" />"),
    CIRCLE_CARET_LEFT(
        "circle-caret-left",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10a10 10 0 1 1 0 -20m2 13v-6a1 1 0 0 0 -1.707 -.708l-3 3a1 1 0 0 0 0 1.415l3 3a1 1 0 0 0 1.414 0l.083 -.094c.14 -.18 .21 -.396 .21 -.613\" />"),
    CIRCLE_CARET_RIGHT(
        "circle-caret-right",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5.293 4.953a1 1 0 0 0 -1.707 .707v6c0 .217 .07 .433 .21 .613l.083 .094a1 1 0 0 0 1.414 0l3 -3a1 1 0 0 0 0 -1.414z\" />"),
    CIRCLE_CARET_UP(
        "circle-caret-up",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.293 5.953a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 .707 1.707h6c.217 0 .433 -.07 .613 -.21l.094 -.083a1 1 0 0 0 0 -1.414z\" />"),
    CIRCLE_CHEVRON_DOWN(
        "circle-chevron-down",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10a10 10 0 1 1 0 -20m-2.293 8.293a1 1 0 0 0 -1.414 1.414l3 3a1 1 0 0 0 1.414 0l3 -3a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.294 2.292z\" />"),
    CIRCLE_CHEVRON_LEFT(
        "circle-chevron-left",
        "<path d=\"M17 3.34a10 10 0 0 1 5 8.66c0 5.523 -4.477 10 -10 10s-10 -4.477 -10 -10a10 10 0 0 1 15 -8.66m-3.293 4.953a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l3 3a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293a1 1 0 0 0 0 -1.414\" />"),
    CIRCLE_CHEVRON_RIGHT(
        "circle-chevron-right",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -20 0c0 -5.523 4.477 -10 10 -10m-.293 6.293a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293a1 1 0 0 0 1.414 1.414l3 -3a1 1 0 0 0 0 -1.414z\" />"),
    CIRCLE_CHEVRON_UP(
        "circle-chevron-up",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.293 5.953a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l2.293 2.292a1 1 0 0 0 1.414 -1.414z\" />"),
    CIRCLE_CHEVRONS_DOWN(
        "circle-chevrons-down",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10a10 10 0 1 1 0 -20m-2.293 10.293a1 1 0 1 0 -1.414 1.414l3 3a1 1 0 0 0 1.414 0l3 -3a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.294 2.292zm0 -4a1 1 0 0 0 -1.414 1.414l3 3a1 1 0 0 0 1.414 0l3 -3a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.294 2.292z\" />"),
    CIRCLE_CHEVRONS_LEFT(
        "circle-chevrons-left",
        "<path d=\"M11.927 2.133c5.494 -.04 9.992 4.359 10.073 9.852v.295c-.081 5.493 -4.579 9.893 -10.073 9.852c-5.494 -.04 -9.926 -4.505 -9.926 -10c0 -5.494 4.432 -9.959 9.926 -10m3.78 6.16a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l3 3a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.292l2.292 -2.293a1 1 0 0 0 0 -1.414m-4 0a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l3 3a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293a1 1 0 0 0 0 -1.414\" />"),
    CIRCLE_CHEVRONS_RIGHT(
        "circle-chevrons-right",
        "<path d=\"M12.073 1.868c5.494 .04 9.926 4.505 9.926 10c0 5.494 -4.432 9.959 -9.926 10c-5.494 .04 -9.992 -4.36 -10.073 -9.853v-.295c.081 -5.493 4.579 -9.893 10.073 -9.852m-2.366 6.425a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293a1 1 0 0 0 1.414 1.414l3 -3a1 1 0 0 0 0 -1.414zm4 0a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293a1 1 0 0 0 1.414 1.414l3 -3a1 1 0 0 0 0 -1.414z\" />"),
    CIRCLE_CHEVRONS_UP(
        "circle-chevrons-up",
        "<path d=\"M11.867 2.001c5.495 0 9.96 4.432 10 9.926s-4.359 9.993 -9.852 10.073h-.295c-5.493 -.081 -9.893 -4.579 -9.852 -10.073c.04 -5.494 4.505 -9.926 10 -9.926m.84 9.292a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l2.292 -2.292l2.293 2.292a1 1 0 0 0 1.414 -1.414zm0 -4a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l2.292 -2.292l2.293 2.292a1 1 0 0 0 1.414 -1.414z\" />"),
    DOWNLOAD(
        "download",
        "<path d=\"M20 16a1 1 0 0 1 1 1v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2a1 1 0 0 1 2 0v2a1 1 0 0 0 1 1h12a1 1 0 0 0 1 -1v-2a1 1 0 0 1 1 -1m-8 -13a1 1 0 0 1 1 1v9.585l3.293 -3.292a1 1 0 0 1 1.414 1.414l-5 5a1 1 0 0 1 -.09 .08l.09 -.08a1 1 0 0 1 -.674 .292l-.033 .001h-.032l-.054 -.004l.086 .004a1 1 0 0 1 -.617 -.213a1 1 0 0 1 -.09 -.08l-5 -5a1 1 0 0 1 1.414 -1.414l3.293 3.292v-9.585a1 1 0 0 1 1 -1\" />"),
    SQUARE_ARROW_DOWN(
        "square-arrow-down",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-7 5a1 1 0 0 0 -1 1v5.585l-2.293 -2.292l-.094 -.083a1 1 0 0 0 -1.32 1.497l4 4l.094 .083l.092 .064l.098 .052l.11 .044l.112 .03l.126 .017l.075 .003l.117 -.007l.149 -.029l.105 -.035l.113 -.054l.111 -.071a.939 .939 0 0 0 .112 -.097l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.293 2.292v-5.585l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    SQUARE_ARROW_LEFT(
        "square-arrow-left",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-6.293 5.293a1 1 0 0 0 -1.414 0l-4 4l-.083 .094l-.064 .092l-.052 .098l-.044 .11l-.03 .112l-.017 .126l-.003 .075l.004 .09l.007 .058l.025 .118l.035 .105l.054 .113l.071 .111c.03 .04 .061 .077 .097 .112l4 4l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293h5.585l.117 -.007a1 1 0 0 0 -.117 -1.993h-5.585l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    SQUARE_ARROW_RIGHT(
        "square-arrow-right",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-6.387 5.21a1 1 0 0 0 -1.32 .083l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293h-5.585l-.117 .007a1 1 0 0 0 .117 1.993h5.585l-2.292 2.293l-.083 .094a1 1 0 0 0 1.497 1.32l4 -4l.073 -.082l.074 -.104l.052 -.098l.044 -.11l.03 -.112l.017 -.126l.003 -.075l-.007 -.118l-.029 -.148l-.035 -.105l-.054 -.113l-.071 -.111a1.008 1.008 0 0 0 -.097 -.112l-4 -4z\" />"),
    SQUARE_ARROW_UP(
        "square-arrow-up",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-7 5l-.09 .004l-.058 .007l-.118 .025l-.105 .035l-.113 .054l-.111 .071a1.008 1.008 0 0 0 -.112 .097l-4 4l-.083 .094a1 1 0 0 0 .083 1.32l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292v5.585l.007 .117a1 1 0 0 0 1.993 -.117v-5.585l2.293 2.292l.094 .083a1 1 0 0 0 1.32 -1.497l-4 -4l-.082 -.073l-.104 -.074l-.098 -.052l-.11 -.044l-.112 -.03l-.126 -.017l-.075 -.003z\" />"),
    SQUARE_CHEVRON_DOWN(
        "square-chevron-down",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-9.387 8.21a1 1 0 0 0 -1.32 1.497l3 3l.094 .083a1 1 0 0 0 1.32 -.083l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.293 2.292l-2.293 -2.292z\" />"),
    SQUARE_CHEVRON_LEFT(
        "square-chevron-left",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-5.293 6.293a1 1 0 0 0 -1.414 0l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l3 3l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    SQUARE_CHEVRON_RIGHT(
        "square-chevron-right",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-7.387 6.21a1 1 0 0 0 -1.32 .083l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293l-.083 .094a1 1 0 0 0 1.497 1.32l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-3 -3z\" />"),
    SQUARE_CHEVRON_UP(
        "square-chevron-up",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-6.387 7.21a1 1 0 0 0 -1.32 .083l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l2.293 2.292l.094 .083a1 1 0 0 0 1.32 -1.497l-3 -3z\" />"),
    SQUARE_CHEVRONS_DOWN(
        "square-chevrons-down",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-9.387 10.21a1 1 0 0 0 -1.32 1.497l3 3l.094 .083a1 1 0 0 0 1.32 -.083l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.293 2.292l-2.293 -2.292zm0 -5a1 1 0 0 0 -1.32 1.497l3 3l.094 .083a1 1 0 0 0 1.32 -.083l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-.094 -.083a1 1 0 0 0 -1.32 .083l-2.293 2.292l-2.293 -2.292z\" />"),
    SQUARE_CHEVRONS_LEFT(
        "square-chevrons-left",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-2.293 6.293a1 1 0 0 0 -1.414 0l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l3 3l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32zm-5 0a1 1 0 0 0 -1.414 0l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l3 3l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    SQUARE_CHEVRONS_RIGHT(
        "square-chevrons-right",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-10.387 6.21a1 1 0 0 0 -1.32 .083l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293l-.083 .094a1 1 0 0 0 1.497 1.32l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-3 -3zm5 0a1 1 0 0 0 -1.32 .083l-.083 .094a1 1 0 0 0 .083 1.32l2.292 2.293l-2.292 2.293l-.083 .094a1 1 0 0 0 1.497 1.32l3 -3l.083 -.094a1 1 0 0 0 -.083 -1.32l-3 -3z\" />"),
    SQUARE_CHEVRONS_UP(
        "square-chevrons-up",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-6.387 10.21a1 1 0 0 0 -1.32 .083l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l2.293 2.292l.094 .083a1 1 0 0 0 1.32 -1.497l-3 -3zm0 -5a1 1 0 0 0 -1.32 .083l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l2.293 2.292l.094 .083a1 1 0 0 0 1.32 -1.497l-3 -3z\" />"),
    SQUARE_ROUNDED_ARROW_DOWN(
        "square-rounded-arrow-down",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm0 5a1 1 0 0 1 .993 .883l.007 .117v5.585l2.293 -2.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-4 4a1.008 1.008 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.092 -.064l-.094 -.083l-4 -4a1 1 0 0 1 1.32 -1.497l.094 .083l2.293 2.292v-5.585a1 1 0 0 1 1 -1z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_ARROW_LEFT(
        "square-rounded-arrow-left",
        "<path d=\"M12 2l.324 .001l.318 .004l.616 .017l.299 .013l.579 .034l.553 .046c4.785 .464 6.732 2.411 7.196 7.196l.046 .553l.034 .579c.005 .098 .01 .198 .013 .299l.017 .616l.005 .642l-.005 .642l-.017 .616l-.013 .299l-.034 .579l-.046 .553c-.464 4.785 -2.411 6.732 -7.196 7.196l-.553 .046l-.579 .034c-.098 .005 -.198 .01 -.299 .013l-.616 .017l-.642 .005l-.642 -.005l-.616 -.017l-.299 -.013l-.579 -.034l-.553 -.046c-4.785 -.464 -6.732 -2.411 -7.196 -7.196l-.046 -.553l-.034 -.579a28.058 28.058 0 0 1 -.013 -.299l-.017 -.616c-.003 -.21 -.005 -.424 -.005 -.642l.001 -.324l.004 -.318l.017 -.616l.013 -.299l.034 -.579l.046 -.553c.464 -4.785 2.411 -6.732 7.196 -7.196l.553 -.046l.579 -.034c.098 -.005 .198 -.01 .299 -.013l.616 -.017c.21 -.003 .424 -.005 .642 -.005zm.707 5.293a1 1 0 0 0 -1.414 0l-4 4a1.037 1.037 0 0 0 -.2 .284l-.022 .052a.95 .95 0 0 0 -.06 .222l-.008 .067l-.002 .063v-.035v.073a1.034 1.034 0 0 0 .07 .352l.023 .052l.03 .061l.022 .037a1.2 1.2 0 0 0 .05 .074l.024 .03l.073 .082l4 4l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293h5.585l.117 -.007a1 1 0 0 0 -.117 -1.993h-5.585l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_ARROW_RIGHT(
        "square-rounded-arrow-right",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm.613 5.21l.094 .083l4 4a.927 .927 0 0 1 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-4 4a1 1 0 0 1 -1.497 -1.32l.083 -.094l2.292 -2.293h-5.585a1 1 0 0 1 -.117 -1.993l.117 -.007h5.585l-2.292 -2.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_ARROW_UP(
        "square-rounded-arrow-up",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-.148 5.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l4 4a1 1 0 0 1 -1.32 1.497l-.094 -.083l-2.293 -2.292v5.585a1 1 0 0 1 -1.993 .117l-.007 -.117v-5.585l-2.293 2.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l4 -4a.927 .927 0 0 1 .112 -.097l.11 -.071l.114 -.054l.105 -.035l.118 -.025z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRON_DOWN(
        "square-rounded-chevron-down",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-3.707 8.293a1 1 0 0 1 1.32 -.083l.094 .083l2.293 2.292l2.293 -2.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1 1 0 0 1 0 -1.414z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRON_LEFT(
        "square-rounded-chevron-left",
        "<path d=\"M12 2l.324 .001l.318 .004l.616 .017l.299 .013l.579 .034l.553 .046c4.785 .464 6.732 2.411 7.196 7.196l.046 .553l.034 .579c.005 .098 .01 .198 .013 .299l.017 .616l.005 .642l-.005 .642l-.017 .616l-.013 .299l-.034 .579l-.046 .553c-.464 4.785 -2.411 6.732 -7.196 7.196l-.553 .046l-.579 .034c-.098 .005 -.198 .01 -.299 .013l-.616 .017l-.642 .005l-.642 -.005l-.616 -.017l-.299 -.013l-.579 -.034l-.553 -.046c-4.785 -.464 -6.732 -2.411 -7.196 -7.196l-.046 -.553l-.034 -.579a28.058 28.058 0 0 1 -.013 -.299l-.017 -.616c-.003 -.21 -.005 -.424 -.005 -.642l.001 -.324l.004 -.318l.017 -.616l.013 -.299l.034 -.579l.046 -.553c.464 -4.785 2.411 -6.732 7.196 -7.196l.553 -.046l.579 -.034c.098 -.005 .198 -.01 .299 -.013l.616 -.017c.21 -.003 .424 -.005 .642 -.005zm1.707 6.293a1 1 0 0 0 -1.414 0l-3 3l-.083 .094a1 1 0 0 0 .083 1.32l3 3l.094 .083a1 1 0 0 0 1.32 -.083l.083 -.094a1 1 0 0 0 -.083 -1.32l-2.292 -2.293l2.292 -2.293l.083 -.094a1 1 0 0 0 -.083 -1.32z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRON_RIGHT(
        "square-rounded-chevron-right",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-1.707 6.293a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.497 -1.32l.083 -.094l2.292 -2.293l-2.292 -2.293a1 1 0 0 1 -.083 -1.32l.083 -.094z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRON_UP(
        "square-rounded-chevron-up",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-.707 7.293a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 -1.32 1.497l-.094 -.083l-2.293 -2.292l-2.293 2.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l3 -3z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRONS_DOWN(
        "square-rounded-chevrons-down",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-3.707 6.293a1 1 0 0 1 1.32 -.083l.094 .083l2.293 2.292l2.293 -2.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1 1 0 0 1 0 -1.414zm0 4a1 1 0 0 1 1.32 -.083l.094 .083l2.293 2.292l2.293 -2.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1 1 0 0 1 0 -1.414z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRONS_LEFT(
        "square-rounded-chevrons-left",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm2.293 6.293a1 1 0 0 1 1.497 1.32l-.083 .094l-2.292 2.293l2.292 2.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1 1 0 0 1 -.083 -1.32l.083 -.094l3 -3zm-4 0a1 1 0 0 1 1.497 1.32l-.083 .094l-2.292 2.293l2.292 2.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.32 .083l-.094 -.083l-3 -3a1 1 0 0 1 -.083 -1.32l.083 -.094l3 -3z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRONS_RIGHT(
        "square-rounded-chevrons-right",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-3.707 6.293a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.497 -1.32l.083 -.094l2.292 -2.293l-2.292 -2.293a1 1 0 0 1 -.083 -1.32l.083 -.094zm4 0a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 .083 1.32l-.083 .094l-3 3a1 1 0 0 1 -1.497 -1.32l.083 -.094l2.292 -2.293l-2.292 -2.293a1 1 0 0 1 -.083 -1.32l.083 -.094z\" fill=\"currentColor\" />"),
    SQUARE_ROUNDED_CHEVRONS_UP(
        "square-rounded-chevrons-up",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm-.707 9.293a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 -1.32 1.497l-.094 -.083l-2.293 -2.292l-2.293 2.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l3 -3zm0 -4a1 1 0 0 1 1.32 -.083l.094 .083l3 3a1 1 0 0 1 -1.32 1.497l-.094 -.083l-2.293 -2.292l-2.293 2.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 -.083 -1.32l.083 -.094l3 -3z\" fill=\"currentColor\" />"),
    SWIPE_DOWN(
        "swipe-down",
        "<path d=\"M12 3a5 5 0 0 1 1.001 9.9l-.001 4.684l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.292v-4.685a5.002 5.002 0 0 1 1 -9.9\" />"),
    SWIPE_LEFT(
        "swipe-left",
        "<path d=\"M16 7a5 5 0 1 1 -4.9 6.001l-4.685 -.001l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.097 -.112l-.071 -.11l-.054 -.114l-.035 -.105l-.025 -.118l-.007 -.058l-.004 -.09l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 1.414l-1.292 1.293h4.685a5 5 0 0 1 4.9 -4\" />"),
    SWIPE_RIGHT(
        "swipe-right",
        "<path d=\"M8 7a5 5 0 0 1 4.9 4h4.685l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0l3 3q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118l-.003 .075l-.017 .126l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.291 -1.293l-4.684 .001a5.002 5.002 0 0 1 -9.9 -1.001a5 5 0 0 1 5 -5\" />"),
    SWIPE_UP(
        "swipe-up",
        "<path d=\"M11.852 3.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292l.001 4.685a5.002 5.002 0 0 1 -1.001 9.9a5 5 0 0 1 -5 -5l.005 -.217a5 5 0 0 1 3.995 -4.683v-4.685l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />"),
    TRANSITION_BOTTOM(
        "transition-bottom",
        "<path d=\"M21 17a1 1 0 0 1 1 1a4 4 0 0 1 -4 4h-12a4 4 0 0 1 -4 -4a1 1 0 0 1 2 0a2 2 0 0 0 2 2h12a2 2 0 0 0 1.995 -1.85l.005 -.15a1 1 0 0 1 1 -1m-9 1l-.082 -.004l-.119 -.016l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-4.586h-5a4 4 0 1 1 0 -8h12a4 4 0 1 1 0 8h-5v4.583l1.293 -1.29a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3l-.112 .097l-.11 .071l-.062 .031l-.081 .034l-.076 .024l-.149 .03z\" />"),
    TRANSITION_LEFT(
        "transition-left",
        "<path d=\"M6 2a1 1 0 1 1 0 2a2 2 0 0 0 -2 2v12a2 2 0 0 0 1.85 1.995l.15 .005a1 1 0 0 1 0 2a4 4 0 0 1 -4 -4v-12a4 4 0 0 1 4 -4m12 0a4 4 0 0 1 4 4v12a4 4 0 1 1 -8 0v-5h-4.585l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-3 -3l-.097 -.112l-.071 -.11l-.031 -.062l-.034 -.081l-.024 -.076l-.025 -.118l-.007 -.058l-.004 -.108l.003 -.064l.017 -.119l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09l3 -3a1 1 0 0 1 1.414 1.414l-1.292 1.293h4.585v-5a4 4 0 0 1 4 -4\" />"),
    TRANSITION_RIGHT(
        "transition-right",
        "<path d=\"M18 2a4 4 0 0 1 4 4v12a4 4 0 0 1 -4 4a1 1 0 0 1 -.117 -1.993l.117 -.007a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2a1 1 0 0 1 0 -2m-8 16a4 4 0 1 1 -8 0v-12a4 4 0 1 1 8 0v5h4.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0l3 3l.097 .112l.071 .11l.031 .062l.034 .081l.024 .076l.03 .148l.006 .118l-.004 .085l-.016 .116l-.03 .111l-.044 .111l-.052 .098l-.074 .104l-.073 .082l-3 3a1 1 0 0 1 -1.414 -1.414l1.292 -1.293h-4.585z\" />"),
    TRANSITION_TOP(
        "transition-top",
        "<path d=\"M12 6l.081 .003l.12 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v4.585h5a4 4 0 1 1 0 8h-12a4 4 0 1 1 0 -8h5v-4.585l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3l.112 -.097l.11 -.071l.062 -.031l.081 -.034l.076 -.024l.118 -.025l.058 -.007zm6 -4a4 4 0 0 1 4 4a1 1 0 0 1 -1.993 .117l-.007 -.117a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2a1 1 0 1 1 -2 0a4 4 0 0 1 4 -4z\" />");

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

  default TablerIcon arrow_autofit_content() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_CONTENT);
  }

  default TablerIcon arrow_autofit_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_DOWN);
  }

  default TablerIcon arrow_autofit_height() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_HEIGHT);
  }

  default TablerIcon arrow_autofit_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_LEFT);
  }

  default TablerIcon arrow_autofit_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_RIGHT);
  }

  default TablerIcon arrow_autofit_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_UP);
  }

  default TablerIcon arrow_autofit_width() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_WIDTH);
  }

  default TablerIcon arrow_back() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK);
  }

  default TablerIcon arrow_back_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP);
  }

  default TablerIcon arrow_back_up_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP_DOUBLE);
  }

  default TablerIcon arrow_badge_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_DOWN);
  }

  default TablerIcon arrow_badge_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_LEFT);
  }

  default TablerIcon arrow_badge_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_RIGHT);
  }

  default TablerIcon arrow_badge_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_UP);
  }

  default TablerIcon arrow_bar_both() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_BOTH);
  }

  default TablerIcon arrow_bar_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_DOWN);
  }

  default TablerIcon arrow_bar_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_LEFT);
  }

  default TablerIcon arrow_bar_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_RIGHT);
  }

  default TablerIcon arrow_bar_to_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_DOWN);
  }

  default TablerIcon arrow_bar_to_down_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_DOWN_DASHED);
  }

  default TablerIcon arrow_bar_to_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_LEFT);
  }

  default TablerIcon arrow_bar_to_left_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_LEFT_DASHED);
  }

  default TablerIcon arrow_bar_to_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_RIGHT);
  }

  default TablerIcon arrow_bar_to_right_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_RIGHT_DASHED);
  }

  default TablerIcon arrow_bar_to_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_UP);
  }

  default TablerIcon arrow_bar_to_up_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_UP_DASHED);
  }

  default TablerIcon arrow_bar_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_UP);
  }

  default TablerIcon arrow_bear_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_LEFT);
  }

  default TablerIcon arrow_bear_left_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_LEFT_2);
  }

  default TablerIcon arrow_bear_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_RIGHT);
  }

  default TablerIcon arrow_bear_right_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_RIGHT_2);
  }

  default TablerIcon arrow_big_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN);
  }

  default TablerIcon arrow_big_down_line() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN_LINE);
  }

  default TablerIcon arrow_big_down_lines() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN_LINES);
  }

  default TablerIcon arrow_big_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT);
  }

  default TablerIcon arrow_big_left_line() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT_LINE);
  }

  default TablerIcon arrow_big_left_lines() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT_LINES);
  }

  default TablerIcon arrow_big_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT);
  }

  default TablerIcon arrow_big_right_line() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT_LINE);
  }

  default TablerIcon arrow_big_right_lines() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT_LINES);
  }

  default TablerIcon arrow_big_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP);
  }

  default TablerIcon arrow_big_up_line() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP_LINE);
  }

  default TablerIcon arrow_big_up_lines() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP_LINES);
  }

  default TablerIcon arrow_bounce() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BOUNCE);
  }

  default TablerIcon arrow_capsule() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CAPSULE);
  }

  default TablerIcon arrow_curve_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CURVE_LEFT);
  }

  default TablerIcon arrow_curve_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CURVE_RIGHT);
  }

  default TablerIcon arrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN);
  }

  default TablerIcon arrow_down_bar() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_BAR);
  }

  default TablerIcon arrow_down_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_CIRCLE);
  }

  default TablerIcon arrow_down_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_DASHED);
  }

  default TablerIcon arrow_down_from_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_FROM_ARC);
  }

  default TablerIcon arrow_down_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_LEFT);
  }

  default TablerIcon arrow_down_left_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_LEFT_CIRCLE);
  }

  default TablerIcon arrow_down_rhombus() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RHOMBUS);
  }

  default TablerIcon arrow_down_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RIGHT);
  }

  default TablerIcon arrow_down_right_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RIGHT_CIRCLE);
  }

  default TablerIcon arrow_down_square() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_SQUARE);
  }

  default TablerIcon arrow_down_tail() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_TAIL);
  }

  default TablerIcon arrow_down_to_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_TO_ARC);
  }

  default TablerIcon arrow_elbow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ELBOW_LEFT);
  }

  default TablerIcon arrow_elbow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ELBOW_RIGHT);
  }

  default TablerIcon arrow_fork() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORK);
  }

  default TablerIcon arrow_fork_triple() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORK_TRIPLE);
  }

  default TablerIcon arrow_forward() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD);
  }

  default TablerIcon arrow_forward_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD_UP);
  }

  default TablerIcon arrow_forward_up_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD_UP_DOUBLE);
  }

  default TablerIcon arrow_guide() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_GUIDE);
  }

  default TablerIcon arrow_iteration() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ITERATION);
  }

  default TablerIcon arrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT);
  }

  default TablerIcon arrow_left_bar() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_BAR);
  }

  default TablerIcon arrow_left_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_CIRCLE);
  }

  default TablerIcon arrow_left_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_DASHED);
  }

  default TablerIcon arrow_left_from_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_FROM_ARC);
  }

  default TablerIcon arrow_left_rhombus() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_RHOMBUS);
  }

  default TablerIcon arrow_left_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_RIGHT);
  }

  default TablerIcon arrow_left_square() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_SQUARE);
  }

  default TablerIcon arrow_left_tail() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_TAIL);
  }

  default TablerIcon arrow_left_to_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_TO_ARC);
  }

  default TablerIcon arrow_loop_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_LEFT);
  }

  default TablerIcon arrow_loop_left_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_LEFT_2);
  }

  default TablerIcon arrow_loop_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_RIGHT);
  }

  default TablerIcon arrow_loop_right_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_RIGHT_2);
  }

  default TablerIcon arrow_merge() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE);
  }

  default TablerIcon arrow_merge_alt_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_ALT_LEFT);
  }

  default TablerIcon arrow_merge_alt_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_ALT_RIGHT);
  }

  default TablerIcon arrow_merge_both() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_BOTH);
  }

  default TablerIcon arrow_merge_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_LEFT);
  }

  default TablerIcon arrow_merge_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_RIGHT);
  }

  default TablerIcon arrow_move_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_DOWN);
  }

  default TablerIcon arrow_move_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_LEFT);
  }

  default TablerIcon arrow_move_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_RIGHT);
  }

  default TablerIcon arrow_move_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_UP);
  }

  default TablerIcon arrow_narrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_DOWN);
  }

  default TablerIcon arrow_narrow_down_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_DOWN_DASHED);
  }

  default TablerIcon arrow_narrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_LEFT);
  }

  default TablerIcon arrow_narrow_left_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_LEFT_DASHED);
  }

  default TablerIcon arrow_narrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_RIGHT);
  }

  default TablerIcon arrow_narrow_right_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_RIGHT_DASHED);
  }

  default TablerIcon arrow_narrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_UP);
  }

  default TablerIcon arrow_narrow_up_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_UP_DASHED);
  }

  default TablerIcon arrow_ramp_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT);
  }

  default TablerIcon arrow_ramp_left_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT_2);
  }

  default TablerIcon arrow_ramp_left_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT_3);
  }

  default TablerIcon arrow_ramp_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT);
  }

  default TablerIcon arrow_ramp_right_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT_2);
  }

  default TablerIcon arrow_ramp_right_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT_3);
  }

  default TablerIcon arrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT);
  }

  default TablerIcon arrow_right_bar() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_BAR);
  }

  default TablerIcon arrow_right_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_CIRCLE);
  }

  default TablerIcon arrow_right_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_DASHED);
  }

  default TablerIcon arrow_right_from_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_FROM_ARC);
  }

  default TablerIcon arrow_right_rhombus() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_RHOMBUS);
  }

  default TablerIcon arrow_right_square() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_SQUARE);
  }

  default TablerIcon arrow_right_tail() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_TAIL);
  }

  default TablerIcon arrow_right_to_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_TO_ARC);
  }

  default TablerIcon arrow_rotary_first_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_FIRST_LEFT);
  }

  default TablerIcon arrow_rotary_first_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_FIRST_RIGHT);
  }

  default TablerIcon arrow_rotary_last_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LAST_LEFT);
  }

  default TablerIcon arrow_rotary_last_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LAST_RIGHT);
  }

  default TablerIcon arrow_rotary_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LEFT);
  }

  default TablerIcon arrow_rotary_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_RIGHT);
  }

  default TablerIcon arrow_rotary_straight() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_STRAIGHT);
  }

  default TablerIcon arrow_roundabout_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROUNDABOUT_LEFT);
  }

  default TablerIcon arrow_roundabout_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROUNDABOUT_RIGHT);
  }

  default TablerIcon arrow_sharp_turn_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_SHARP_TURN_LEFT);
  }

  default TablerIcon arrow_sharp_turn_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_SHARP_TURN_RIGHT);
  }

  default TablerIcon arrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP);
  }

  default TablerIcon arrow_up_bar() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_BAR);
  }

  default TablerIcon arrow_up_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_CIRCLE);
  }

  default TablerIcon arrow_up_dashed() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_DASHED);
  }

  default TablerIcon arrow_up_from_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_FROM_ARC);
  }

  default TablerIcon arrow_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_LEFT);
  }

  default TablerIcon arrow_up_left_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_LEFT_CIRCLE);
  }

  default TablerIcon arrow_up_rhombus() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RHOMBUS);
  }

  default TablerIcon arrow_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RIGHT);
  }

  default TablerIcon arrow_up_right_circle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RIGHT_CIRCLE);
  }

  default TablerIcon arrow_up_square() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_SQUARE);
  }

  default TablerIcon arrow_up_tail() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_TAIL);
  }

  default TablerIcon arrow_up_to_arc() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_TO_ARC);
  }

  default TablerIcon arrow_wave_left_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_LEFT_DOWN);
  }

  default TablerIcon arrow_wave_left_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_LEFT_UP);
  }

  default TablerIcon arrow_wave_right_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_RIGHT_DOWN);
  }

  default TablerIcon arrow_wave_right_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_RIGHT_UP);
  }

  default TablerIcon arrow_zig_zag() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ZIG_ZAG);
  }

  default TablerIcon arrows_cross() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_CROSS);
  }

  default TablerIcon arrows_diagonal() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL);
  }

  default TablerIcon arrows_diagonal_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_2);
  }

  default TablerIcon arrows_diagonal_minimize() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_MINIMIZE);
  }

  default TablerIcon arrows_diagonal_minimize_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_MINIMIZE_2);
  }

  default TablerIcon arrows_diff() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIFF);
  }

  default TablerIcon arrows_double_ne_sw() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_NE_SW);
  }

  default TablerIcon arrows_double_nw_se() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_NW_SE);
  }

  default TablerIcon arrows_double_se_nw() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_SE_NW);
  }

  default TablerIcon arrows_double_sw_ne() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_SW_NE);
  }

  default TablerIcon arrows_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOWN);
  }

  default TablerIcon arrows_down_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOWN_UP);
  }

  default TablerIcon arrows_exchange() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_EXCHANGE);
  }

  default TablerIcon arrows_exchange_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_EXCHANGE_2);
  }

  default TablerIcon arrows_horizontal() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_HORIZONTAL);
  }

  default TablerIcon arrows_join() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_JOIN);
  }

  default TablerIcon arrows_join_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_JOIN_2);
  }

  default TablerIcon arrows_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT);
  }

  default TablerIcon arrows_left_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT_DOWN);
  }

  default TablerIcon arrows_left_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT_RIGHT);
  }

  default TablerIcon arrows_maximize() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MAXIMIZE);
  }

  default TablerIcon arrows_minimize() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MINIMIZE);
  }

  default TablerIcon arrows_move() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE);
  }

  default TablerIcon arrows_move_horizontal() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE_HORIZONTAL);
  }

  default TablerIcon arrows_move_vertical() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE_VERTICAL);
  }

  default TablerIcon arrows_random() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RANDOM);
  }

  default TablerIcon arrows_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT);
  }

  default TablerIcon arrows_right_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT_DOWN);
  }

  default TablerIcon arrows_right_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT_LEFT);
  }

  default TablerIcon arrows_shuffle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SHUFFLE);
  }

  default TablerIcon arrows_shuffle_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SHUFFLE_2);
  }

  default TablerIcon arrows_sort() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SORT);
  }

  default TablerIcon arrows_split() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SPLIT);
  }

  default TablerIcon arrows_split_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SPLIT_2);
  }

  default TablerIcon arrows_transfer_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_DOWN);
  }

  default TablerIcon arrows_transfer_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_UP);
  }

  default TablerIcon arrows_transfer_up_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_UP_DOWN);
  }

  default TablerIcon arrows_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP);
  }

  default TablerIcon arrows_up_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_DOWN);
  }

  default TablerIcon arrows_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_LEFT);
  }

  default TablerIcon arrows_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_RIGHT);
  }

  default TablerIcon arrows_vertical() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_VERTICAL);
  }

  default TablerIcon axis_x() {
    return TablerIcon.create(TablerArrows.OutlineIcon.AXIS_X);
  }

  default TablerIcon axis_y() {
    return TablerIcon.create(TablerArrows.OutlineIcon.AXIS_Y);
  }

  default TablerIcon caret_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CARET_DOWN);
  }

  default TablerIcon caret_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CARET_LEFT);
  }

  default TablerIcon caret_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CARET_RIGHT);
  }

  default TablerIcon caret_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CARET_UP);
  }

  default TablerIcon caret_up_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CARET_UP_DOWN);
  }

  default TablerIcon chevron_compact_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_DOWN);
  }

  default TablerIcon chevron_compact_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_LEFT);
  }

  default TablerIcon chevron_compact_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_RIGHT);
  }

  default TablerIcon chevron_compact_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_UP);
  }

  default TablerIcon chevron_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN);
  }

  default TablerIcon chevron_down_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN_LEFT);
  }

  default TablerIcon chevron_down_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN_RIGHT);
  }

  default TablerIcon chevron_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT);
  }

  default TablerIcon chevron_left_pipe() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT_PIPE);
  }

  default TablerIcon chevron_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT);
  }

  default TablerIcon chevron_right_pipe() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT_PIPE);
  }

  default TablerIcon chevron_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP);
  }

  default TablerIcon chevron_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP_LEFT);
  }

  default TablerIcon chevron_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP_RIGHT);
  }

  default TablerIcon chevrons_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN);
  }

  default TablerIcon chevrons_down_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN_LEFT);
  }

  default TablerIcon chevrons_down_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN_RIGHT);
  }

  default TablerIcon chevrons_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_LEFT);
  }

  default TablerIcon chevrons_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_RIGHT);
  }

  default TablerIcon chevrons_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP);
  }

  default TablerIcon chevrons_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP_LEFT);
  }

  default TablerIcon chevrons_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP_RIGHT);
  }

  default TablerIcon circle_arrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN);
  }

  default TablerIcon circle_arrow_down_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN_LEFT);
  }

  default TablerIcon circle_arrow_down_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN_RIGHT);
  }

  default TablerIcon circle_arrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_LEFT);
  }

  default TablerIcon circle_arrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_RIGHT);
  }

  default TablerIcon circle_arrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP);
  }

  default TablerIcon circle_arrow_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP_LEFT);
  }

  default TablerIcon circle_arrow_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP_RIGHT);
  }

  default TablerIcon circle_caret_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_DOWN);
  }

  default TablerIcon circle_caret_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_LEFT);
  }

  default TablerIcon circle_caret_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_RIGHT);
  }

  default TablerIcon circle_caret_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_UP);
  }

  default TablerIcon circle_chevron_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_DOWN);
  }

  default TablerIcon circle_chevron_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_LEFT);
  }

  default TablerIcon circle_chevron_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_RIGHT);
  }

  default TablerIcon circle_chevron_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_UP);
  }

  default TablerIcon circle_chevrons_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_DOWN);
  }

  default TablerIcon circle_chevrons_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_LEFT);
  }

  default TablerIcon circle_chevrons_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_RIGHT);
  }

  default TablerIcon circle_chevrons_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_UP);
  }

  default TablerIcon circle_open_arrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_DOWN);
  }

  default TablerIcon circle_open_arrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_LEFT);
  }

  default TablerIcon circle_open_arrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_RIGHT);
  }

  default TablerIcon circle_open_arrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_UP);
  }

  default TablerIcon corner_down_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_LEFT);
  }

  default TablerIcon corner_down_left_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_LEFT_DOUBLE);
  }

  default TablerIcon corner_down_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_RIGHT);
  }

  default TablerIcon corner_down_right_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_RIGHT_DOUBLE);
  }

  default TablerIcon corner_left_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_DOWN);
  }

  default TablerIcon corner_left_down_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_DOWN_DOUBLE);
  }

  default TablerIcon corner_left_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_UP);
  }

  default TablerIcon corner_left_up_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_UP_DOUBLE);
  }

  default TablerIcon corner_right_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_DOWN);
  }

  default TablerIcon corner_right_down_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_DOWN_DOUBLE);
  }

  default TablerIcon corner_right_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_UP);
  }

  default TablerIcon corner_right_up_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_UP_DOUBLE);
  }

  default TablerIcon corner_up_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_LEFT);
  }

  default TablerIcon corner_up_left_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_LEFT_DOUBLE);
  }

  default TablerIcon corner_up_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_RIGHT);
  }

  default TablerIcon corner_up_right_double() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_RIGHT_DOUBLE);
  }

  default TablerIcon download() {
    return TablerIcon.create(TablerArrows.OutlineIcon.DOWNLOAD);
  }

  default TablerIcon download_off() {
    return TablerIcon.create(TablerArrows.OutlineIcon.DOWNLOAD_OFF);
  }

  default TablerIcon fold() {
    return TablerIcon.create(TablerArrows.OutlineIcon.FOLD);
  }

  default TablerIcon fold_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.FOLD_DOWN);
  }

  default TablerIcon fold_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.FOLD_UP);
  }

  default TablerIcon login() {
    return TablerIcon.create(TablerArrows.OutlineIcon.LOGIN);
  }

  default TablerIcon login_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.LOGIN_2);
  }

  default TablerIcon refresh() {
    return TablerIcon.create(TablerArrows.OutlineIcon.REFRESH);
  }

  default TablerIcon refresh_alert() {
    return TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_ALERT);
  }

  default TablerIcon refresh_dot() {
    return TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_DOT);
  }

  default TablerIcon refresh_off() {
    return TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_OFF);
  }

  default TablerIcon reload() {
    return TablerIcon.create(TablerArrows.OutlineIcon.RELOAD);
  }

  default TablerIcon ripple_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.RIPPLE_DOWN);
  }

  default TablerIcon ripple_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.RIPPLE_UP);
  }

  default TablerIcon rotate() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE);
  }

  default TablerIcon rotate_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_2);
  }

  default TablerIcon rotate_360() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_360);
  }

  default TablerIcon rotate_clockwise() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_CLOCKWISE);
  }

  default TablerIcon rotate_clockwise_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_CLOCKWISE_2);
  }

  default TablerIcon rotate_dot() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_DOT);
  }

  default TablerIcon rotate_rectangle() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_RECTANGLE);
  }

  default TablerIcon s_turn_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_DOWN);
  }

  default TablerIcon s_turn_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_LEFT);
  }

  default TablerIcon s_turn_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_RIGHT);
  }

  default TablerIcon s_turn_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_UP);
  }

  default TablerIcon select() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SELECT);
  }

  default TablerIcon selector() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SELECTOR);
  }

  default TablerIcon share_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SHARE_2);
  }

  default TablerIcon share_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SHARE_3);
  }

  default TablerIcon square_arrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_DOWN);
  }

  default TablerIcon square_arrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_LEFT);
  }

  default TablerIcon square_arrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_RIGHT);
  }

  default TablerIcon square_arrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_UP);
  }

  default TablerIcon square_chevron_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_DOWN);
  }

  default TablerIcon square_chevron_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_LEFT);
  }

  default TablerIcon square_chevron_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_RIGHT);
  }

  default TablerIcon square_chevron_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_UP);
  }

  default TablerIcon square_chevrons_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_DOWN);
  }

  default TablerIcon square_chevrons_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_LEFT);
  }

  default TablerIcon square_chevrons_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_RIGHT);
  }

  default TablerIcon square_chevrons_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_UP);
  }

  default TablerIcon square_rounded_arrow_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_DOWN);
  }

  default TablerIcon square_rounded_arrow_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_LEFT);
  }

  default TablerIcon square_rounded_arrow_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_RIGHT);
  }

  default TablerIcon square_rounded_arrow_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_UP);
  }

  default TablerIcon square_rounded_chevron_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_DOWN);
  }

  default TablerIcon square_rounded_chevron_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_LEFT);
  }

  default TablerIcon square_rounded_chevron_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_RIGHT);
  }

  default TablerIcon square_rounded_chevron_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_UP);
  }

  default TablerIcon square_rounded_chevrons_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_DOWN);
  }

  default TablerIcon square_rounded_chevrons_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_LEFT);
  }

  default TablerIcon square_rounded_chevrons_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_RIGHT);
  }

  default TablerIcon square_rounded_chevrons_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_UP);
  }

  default TablerIcon step_into() {
    return TablerIcon.create(TablerArrows.OutlineIcon.STEP_INTO);
  }

  default TablerIcon step_out() {
    return TablerIcon.create(TablerArrows.OutlineIcon.STEP_OUT);
  }

  default TablerIcon swipe_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_DOWN);
  }

  default TablerIcon swipe_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_LEFT);
  }

  default TablerIcon swipe_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_RIGHT);
  }

  default TablerIcon swipe_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_UP);
  }

  default TablerIcon switch_icon() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWITCH);
  }

  default TablerIcon switch_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_2);
  }

  default TablerIcon switch_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_3);
  }

  default TablerIcon switch_horizontal() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_HORIZONTAL);
  }

  default TablerIcon switch_vertical() {
    return TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_VERTICAL);
  }

  default TablerIcon transition_bottom() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_BOTTOM);
  }

  default TablerIcon transition_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_LEFT);
  }

  default TablerIcon transition_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_RIGHT);
  }

  default TablerIcon transition_top() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_TOP);
  }

  default TablerIcon trending_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN);
  }

  default TablerIcon trending_down_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN_2);
  }

  default TablerIcon trending_down_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN_3);
  }

  default TablerIcon trending_up() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP);
  }

  default TablerIcon trending_up_2() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP_2);
  }

  default TablerIcon trending_up_3() {
    return TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP_3);
  }

  default TablerIcon u_turn_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.U_TURN_LEFT);
  }

  default TablerIcon u_turn_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.U_TURN_RIGHT);
  }

  default TablerIcon upload() {
    return TablerIcon.create(TablerArrows.OutlineIcon.UPLOAD);
  }

  default TablerIcon arrow_upward() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP);
  }

  default TablerIcon fullscreen() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MAXIMIZE);
  }

  default TablerIcon fullscreen_exit() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MINIMIZE);
  }

  default TablerIcon menu_down() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN);
  }

  default TablerIcon menu_left() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT);
  }

  default TablerIcon menu_right() {
    return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT);
  }

  default TablerIcon undo() {
    return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP);
  }

  default TablerIcon arrow_autofit_content_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_CONTENT);
  }

  default TablerIcon arrow_autofit_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_DOWN);
  }

  default TablerIcon arrow_autofit_height_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_HEIGHT);
  }

  default TablerIcon arrow_autofit_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_LEFT);
  }

  default TablerIcon arrow_autofit_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_RIGHT);
  }

  default TablerIcon arrow_autofit_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_UP);
  }

  default TablerIcon arrow_autofit_width_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_WIDTH);
  }

  default TablerIcon arrow_badge_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_DOWN);
  }

  default TablerIcon arrow_badge_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_LEFT);
  }

  default TablerIcon arrow_badge_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_RIGHT);
  }

  default TablerIcon arrow_badge_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_UP);
  }

  default TablerIcon arrow_big_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN);
  }

  default TablerIcon arrow_big_down_line_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN_LINE);
  }

  default TablerIcon arrow_big_down_lines_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN_LINES);
  }

  default TablerIcon arrow_big_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT);
  }

  default TablerIcon arrow_big_left_line_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT_LINE);
  }

  default TablerIcon arrow_big_left_lines_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT_LINES);
  }

  default TablerIcon arrow_big_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT);
  }

  default TablerIcon arrow_big_right_line_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT_LINE);
  }

  default TablerIcon arrow_big_right_lines_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT_LINES);
  }

  default TablerIcon arrow_big_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP);
  }

  default TablerIcon arrow_big_up_line_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP_LINE);
  }

  default TablerIcon arrow_big_up_lines_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP_LINES);
  }

  default TablerIcon arrow_down_circle_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_CIRCLE);
  }

  default TablerIcon arrow_down_rhombus_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_RHOMBUS);
  }

  default TablerIcon arrow_down_square_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_SQUARE);
  }

  default TablerIcon arrow_guide_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_GUIDE);
  }

  default TablerIcon arrow_left_circle_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_CIRCLE);
  }

  default TablerIcon arrow_left_rhombus_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_RHOMBUS);
  }

  default TablerIcon arrow_left_square_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_SQUARE);
  }

  default TablerIcon arrow_move_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_DOWN);
  }

  default TablerIcon arrow_move_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_LEFT);
  }

  default TablerIcon arrow_move_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_RIGHT);
  }

  default TablerIcon arrow_move_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_UP);
  }

  default TablerIcon arrow_right_circle_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_CIRCLE);
  }

  default TablerIcon arrow_right_rhombus_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_RHOMBUS);
  }

  default TablerIcon arrow_right_square_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_SQUARE);
  }

  default TablerIcon arrow_up_circle_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_CIRCLE);
  }

  default TablerIcon arrow_up_rhombus_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_RHOMBUS);
  }

  default TablerIcon arrow_up_square_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_SQUARE);
  }

  default TablerIcon caret_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CARET_DOWN);
  }

  default TablerIcon caret_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CARET_LEFT);
  }

  default TablerIcon caret_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CARET_RIGHT);
  }

  default TablerIcon caret_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CARET_UP);
  }

  default TablerIcon caret_up_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CARET_UP_DOWN);
  }

  default TablerIcon chevron_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CHEVRON_DOWN);
  }

  default TablerIcon chevron_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CHEVRON_RIGHT);
  }

  default TablerIcon circle_arrow_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN);
  }

  default TablerIcon circle_arrow_down_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN_LEFT);
  }

  default TablerIcon circle_arrow_down_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN_RIGHT);
  }

  default TablerIcon circle_arrow_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_LEFT);
  }

  default TablerIcon circle_arrow_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_RIGHT);
  }

  default TablerIcon circle_arrow_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP);
  }

  default TablerIcon circle_arrow_up_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP_LEFT);
  }

  default TablerIcon circle_arrow_up_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP_RIGHT);
  }

  default TablerIcon circle_caret_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_DOWN);
  }

  default TablerIcon circle_caret_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_LEFT);
  }

  default TablerIcon circle_caret_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_RIGHT);
  }

  default TablerIcon circle_caret_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_UP);
  }

  default TablerIcon circle_chevron_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_DOWN);
  }

  default TablerIcon circle_chevron_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_LEFT);
  }

  default TablerIcon circle_chevron_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_RIGHT);
  }

  default TablerIcon circle_chevron_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_UP);
  }

  default TablerIcon circle_chevrons_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_DOWN);
  }

  default TablerIcon circle_chevrons_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_LEFT);
  }

  default TablerIcon circle_chevrons_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_RIGHT);
  }

  default TablerIcon circle_chevrons_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_UP);
  }

  default TablerIcon download_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.DOWNLOAD);
  }

  default TablerIcon square_arrow_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_DOWN);
  }

  default TablerIcon square_arrow_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_LEFT);
  }

  default TablerIcon square_arrow_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_RIGHT);
  }

  default TablerIcon square_arrow_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_UP);
  }

  default TablerIcon square_chevron_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_DOWN);
  }

  default TablerIcon square_chevron_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_LEFT);
  }

  default TablerIcon square_chevron_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_RIGHT);
  }

  default TablerIcon square_chevron_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_UP);
  }

  default TablerIcon square_chevrons_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_DOWN);
  }

  default TablerIcon square_chevrons_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_LEFT);
  }

  default TablerIcon square_chevrons_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_RIGHT);
  }

  default TablerIcon square_chevrons_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_UP);
  }

  default TablerIcon square_rounded_arrow_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_DOWN);
  }

  default TablerIcon square_rounded_arrow_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_LEFT);
  }

  default TablerIcon square_rounded_arrow_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_RIGHT);
  }

  default TablerIcon square_rounded_arrow_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_UP);
  }

  default TablerIcon square_rounded_chevron_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_DOWN);
  }

  default TablerIcon square_rounded_chevron_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_LEFT);
  }

  default TablerIcon square_rounded_chevron_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_RIGHT);
  }

  default TablerIcon square_rounded_chevron_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_UP);
  }

  default TablerIcon square_rounded_chevrons_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_DOWN);
  }

  default TablerIcon square_rounded_chevrons_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_LEFT);
  }

  default TablerIcon square_rounded_chevrons_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_RIGHT);
  }

  default TablerIcon square_rounded_chevrons_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_UP);
  }

  default TablerIcon swipe_down_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SWIPE_DOWN);
  }

  default TablerIcon swipe_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SWIPE_LEFT);
  }

  default TablerIcon swipe_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SWIPE_RIGHT);
  }

  default TablerIcon swipe_up_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.SWIPE_UP);
  }

  default TablerIcon transition_bottom_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_BOTTOM);
  }

  default TablerIcon transition_left_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_LEFT);
  }

  default TablerIcon transition_right_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_RIGHT);
  }

  default TablerIcon transition_top_filled() {
    return TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_TOP);
  }
}
