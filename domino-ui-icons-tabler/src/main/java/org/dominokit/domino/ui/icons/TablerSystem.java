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

/** Tabler System catalog category. */
public interface TablerSystem {
  enum OutlineIcon implements TablerIconDefinition {
    AD_CIRCLE(
        "ad-circle",
        "<path d=\"M2 12a10 10 0 1 0 20 0a10 10 0 1 0 -20 0\" />\n  <path d=\"M7 15v-4.5a1.5 1.5 0 0 1 3 0v4.5\" />\n  <path d=\"M7 13h3\" />\n  <path d=\"M14 9v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />"),
    AD_CIRCLE_OFF(
        "ad-circle-off",
        "<path d=\"M4.91 4.949a9.968 9.968 0 0 0 -2.91 7.051c0 5.523 4.477 10 10 10a9.968 9.968 0 0 0 7.05 -2.909\" />\n  <path d=\"M20.778 16.793a9.955 9.955 0 0 0 1.222 -4.793c0 -5.523 -4.477 -10 -10 -10c-1.74 0 -3.376 .444 -4.8 1.225\" />\n  <path d=\"M7 15v-4.5a1.5 1.5 0 0 1 2.138 -1.358\" />\n  <path d=\"M9.854 9.853c.094 .196 .146 .415 .146 .647v4.5\" />\n  <path d=\"M7 13h3\" />\n  <path d=\"M14 14v1h1\" />\n  <path d=\"M17 13v-2a2 2 0 0 0 -2 -2h-1v1\" />\n  <path d=\"M3 3l18 18\" />"),
    ADJUSTMENTS(
        "adjustments",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M10 16a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v11\" />"),
    ADJUSTMENTS_ALT(
        "adjustments-alt",
        "<path d=\"M4 8h4v4h-4l0 -4\" />\n  <path d=\"M6 4l0 4\" />\n  <path d=\"M6 12l0 8\" />\n  <path d=\"M10 14h4v4h-4l0 -4\" />\n  <path d=\"M12 4l0 10\" />\n  <path d=\"M12 18l0 2\" />\n  <path d=\"M16 5h4v4h-4l0 -4\" />\n  <path d=\"M18 4l0 1\" />\n  <path d=\"M18 9l0 11\" />"),
    ADJUSTMENTS_BOLT(
        "adjustments-bolt",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M10 16a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />"),
    ADJUSTMENTS_CANCEL(
        "adjustments-cancel",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.499 14.675a2 2 0 1 0 -1.499 3.325\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    ADJUSTMENTS_CHECK(
        "adjustments-check",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.823 15.176a2 2 0 1 0 -2.638 2.651\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v5\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    ADJUSTMENTS_CODE(
        "adjustments-code",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.557 14.745a2 2 0 1 0 -1.557 3.255\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    ADJUSTMENTS_COG(
        "adjustments-cog",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.199 14.399a2 2 0 1 0 -1.199 3.601\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2.5\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    ADJUSTMENTS_DOLLAR(
        "adjustments-dollar",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.366 14.54a2 2 0 1 0 -.216 3.097\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v1\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    ADJUSTMENTS_DOWN(
        "adjustments-down",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.945 15.53a2 2 0 1 0 -1.945 2.47\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    ADJUSTMENTS_EXCLAMATION(
        "adjustments-exclamation",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M10 16a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    ADJUSTMENTS_HEART(
        "adjustments-heart",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M12 4v8.5\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2.5\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    ADJUSTMENTS_HORIZONTAL(
        "adjustments-horizontal",
        "<path d=\"M12 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 6l8 0\" />\n  <path d=\"M16 6l4 0\" />\n  <path d=\"M6 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 12l2 0\" />\n  <path d=\"M10 12l10 0\" />\n  <path d=\"M15 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 18l11 0\" />\n  <path d=\"M19 18l1 0\" />"),
    ADJUSTMENTS_MINUS(
        "adjustments-minus",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.954 15.574a2 2 0 1 0 -1.954 2.426\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v6\" />\n  <path d=\"M16 19h6\" />"),
    ADJUSTMENTS_OFF(
        "adjustments-off",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 6v2\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M10 16a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 4v4m0 4v2\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v5m0 4v2\" />\n  <path d=\"M3 3l18 18\" />"),
    ADJUSTMENTS_PAUSE(
        "adjustments-pause",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.627 14.836a2 2 0 1 0 -.62 2.892\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />\n  <path d=\"M18 9v4.5\" />"),
    ADJUSTMENTS_PIN(
        "adjustments-pin",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.071 14.31a2 2 0 1 0 -1.071 3.69\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    ADJUSTMENTS_PLUS(
        "adjustments-plus",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.958 15.592a2 2 0 1 0 -1.958 2.408\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    ADJUSTMENTS_QUESTION(
        "adjustments-question",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.577 14.77a2 2 0 1 0 .117 2.295\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2\" />"),
    ADJUSTMENTS_SEARCH(
        "adjustments-search",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M12 14a2 2 0 0 0 -1.042 3.707\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    ADJUSTMENTS_SHARE(
        "adjustments-share",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.387 14.56a2 2 0 1 0 -.798 3.352\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />\n  <path d=\"M18 9v4\" />"),
    ADJUSTMENTS_SPARK(
        "adjustments-spark",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.879 15.312a2 2 0 1 0 -2.26 2.652\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v2.5\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    ADJUSTMENTS_STAR(
        "adjustments-star",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M12 4v9.5\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M18 9v1\" />"),
    ADJUSTMENTS_UP(
        "adjustments-up",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.927 15.462a2 2 0 1 0 -1.927 2.538\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v3\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    ADJUSTMENTS_X(
        "adjustments-x",
        "<path d=\"M4 10a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M6 4v4\" />\n  <path d=\"M6 12v8\" />\n  <path d=\"M13.653 14.874a2 2 0 1 0 -.586 2.818\" />\n  <path d=\"M12 4v10\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M18 4v1\" />\n  <path d=\"M18 9v4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    AFFILIATE(
        "affiliate",
        "<path d=\"M5.931 6.936l1.275 4.249m5.607 5.609l4.251 1.275\" />\n  <path d=\"M11.683 12.317l5.759 -5.759\" />\n  <path d=\"M4 5.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M17 5.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M17 18.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M4 15.5a4.5 4.5 0 1 0 9 0a4.5 4.5 0 1 0 -9 0\" />"),
    ALARM(
        "alarm",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M12 10l0 3l2 0\" />\n  <path d=\"M7 4l-2.75 2\" />\n  <path d=\"M17 4l2.75 2\" />"),
    ALARM_AVERAGE(
        "alarm-average",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 0 0 -14 0\" />\n  <path d=\"M7 4l-2.75 2\" />\n  <path d=\"M17 4l2.75 2\" />\n  <path d=\"M8 13h1l2 3l2 -6l2 3h1\" />"),
    ALARM_MINUS(
        "alarm-minus",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M7 4l-2.75 2\" />\n  <path d=\"M17 4l2.75 2\" />\n  <path d=\"M10 13h4\" />"),
    ALARM_OFF(
        "alarm-off",
        "<path d=\"M7.587 7.566a7 7 0 1 0 9.833 9.864m1.35 -2.645a7 7 0 0 0 -8.536 -8.56\" />\n  <path d=\"M12 12v1h1\" />\n  <path d=\"M5.261 5.265l-1.011 .735\" />\n  <path d=\"M17 4l2.75 2\" />\n  <path d=\"M3 3l18 18\" />"),
    ALARM_PLUS(
        "alarm-plus",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M7 4l-2.75 2\" />\n  <path d=\"M17 4l2.75 2\" />\n  <path d=\"M10 13h4\" />\n  <path d=\"M12 11v4\" />"),
    ALARM_SNOOZE(
        "alarm-snooze",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M10 11h4l-4 4h4\" />\n  <path d=\"M7 4l-2.75 2\" />\n  <path d=\"M17 4l2.75 2\" />"),
    ALERT_CIRCLE(
        "alert-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_CIRCLE_OFF(
        "alert-circle-off",
        "<path d=\"M5.644 5.629a9 9 0 1 0 12.715 12.741m1.693 -2.349a9 9 0 0 0 -12.087 -12.068\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M12 16h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    ALERT_HEXAGON(
        "alert-hexagon",
        "<path d=\"M19.875 6.27c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_HEXAGON_OFF(
        "alert-hexagon-off",
        "<path d=\"M18.36 18.387l-5.268 3.333a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l1.317 -.777m2.535 -1.493l2.898 -1.709a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .414 -.116 .812 -.326 1.155\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M12 8v.01\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_OCTAGON(
        "alert-octagon",
        "<path d=\"M12.802 2.165l5.575 2.389c.48 .206 .863 .589 1.07 1.07l2.388 5.574c.22 .512 .22 1.092 0 1.604l-2.389 5.575c-.206 .48 -.589 .863 -1.07 1.07l-5.574 2.388c-.512 .22 -1.092 .22 -1.604 0l-5.575 -2.389a2.036 2.036 0 0 1 -1.07 -1.07l-2.388 -5.574a2.036 2.036 0 0 1 0 -1.604l2.389 -5.575c.206 -.48 .589 -.863 1.07 -1.07l5.574 -2.388a2.036 2.036 0 0 1 1.604 0\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_SMALL("alert-small", "<path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_SMALL_OFF(
        "alert-small-off",
        "<path d=\"M12 16h.01\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M3 3l18 18\" />"),
    ALERT_SQUARE(
        "alert-square",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_SQUARE_ROUNDED(
        "alert-square-rounded",
        "<path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_SQUARE_ROUNDED_OFF(
        "alert-square-rounded-off",
        "<path d=\"M19.201 19.199c-1.35 1.35 -3.6 1.801 -7.201 1.801c-7.2 0 -9 -1.8 -9 -9c0 -3.598 .45 -5.847 1.797 -7.197m2.626 -1.376c1.204 -.307 2.709 -.427 4.577 -.427c7.2 0 9 1.8 9 9c0 1.865 -.12 3.367 -.425 4.57\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M12 16h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    ALERT_TRIANGLE(
        "alert-triangle",
        "<path d=\"M12 9v4\" />\n  <path d=\"M10.363 3.591l-8.106 13.534a1.914 1.914 0 0 0 1.636 2.871h16.214a1.914 1.914 0 0 0 1.636 -2.87l-8.106 -13.536a1.914 1.914 0 0 0 -3.274 0\" />\n  <path d=\"M12 16h.01\" />"),
    ALERT_TRIANGLE_OFF(
        "alert-triangle-off",
        "<path d=\"M21.998 17.997a1.913 1.913 0 0 0 -.255 -.872l-8.106 -13.534a1.914 1.914 0 0 0 -3.274 0l-1.04 1.736m-1.493 2.493l-5.573 9.304a1.914 1.914 0 0 0 1.636 2.871h16.107\" />\n  <path d=\"M12 16h.01\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M12 7v1\" />"),
    ANALYZE(
        "analyze",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -6.986 -6.918a8.095 8.095 0 0 0 -8.019 3.918\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 15 3\" />\n  <path d=\"M18 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    ANALYZE_OFF(
        "analyze-off",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -6.986 -6.918a8.086 8.086 0 0 0 -4.31 .62m-2.383 1.608a8.089 8.089 0 0 0 -1.326 1.69\" />\n  <path d=\"M4 13a8.1 8.1 0 0 0 13.687 4.676\" />\n  <path d=\"M20 16a1 1 0 0 0 -1 -1\" />\n  <path d=\"M4 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9.888 9.87a3 3 0 1 0 4.233 4.252m.595 -3.397a3.012 3.012 0 0 0 -1.426 -1.435\" />\n  <path d=\"M3 3l18 18\" />"),
    APP_WINDOW(
        "app-window",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M9 8h.01\" />"),
    APP_WINDOW_BOTTOM(
        "app-window-bottom",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6 14h12v2h-12v-2\" fill=\"currentColor\" />"),
    APP_WINDOW_BOTTOM_LEFT(
        "app-window-bottom-left",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6 14h2v2h-2v-2\" fill=\"currentColor\" />"),
    APP_WINDOW_BOTTOM_RIGHT(
        "app-window-bottom-right",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M16 14h2v2h-2v-2\" fill=\"currentColor\" />"),
    APP_WINDOW_CENTER(
        "app-window-center",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M11 11h2v2h-2v-2\" fill=\"currentColor\" />"),
    AUGMENTED_REALITY(
        "augmented-reality",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M12 12.5l4 -2.5\" />\n  <path d=\"M8 10l4 2.5v4.5l4 -2.5v-4.5l-4 -2.5l-4 2.5\" />\n  <path d=\"M8 10v4.5l4 2.5\" />"),
    AUGMENTED_REALITY_2(
        "augmented-reality-2",
        "<path d=\"M10 21h-2a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M17 17l-4 -2.5l4 -2.5l4 2.5v4.5l-4 2.5l0 -4.5\" />\n  <path d=\"M13 14.5v4.5l4 2.5\" />\n  <path d=\"M17 17l4 -2.5\" />\n  <path d=\"M11 4h2\" />"),
    AUGMENTED_REALITY_OFF(
        "augmented-reality-off",
        "<path d=\"M4 8v-2c0 -.557 .228 -1.061 .595 -1.424\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2c.558 0 1.062 -.228 1.425 -.596\" />\n  <path d=\"M12 12.5l.312 -.195m2.457 -1.536l1.231 -.769\" />\n  <path d=\"M9.225 9.235l-1.225 .765l4 2.5v4.5l3.076 -1.923m.924 -3.077v-2l-4 -2.5l-.302 .189\" />\n  <path d=\"M8 10v4.5l4 2.5\" />\n  <path d=\"M3 3l18 18\" />"),
    AUTOMATION(
        "automation",
        "<path d=\"M13 20.693c-.905 .628 -2.36 .292 -2.675 -1.01a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.492 .362 1.716 2.219 .674 3.03\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M17 22l5 -3l-5 -3l0 6\" />"),
    BAN(
        "ban",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M5.7 5.7l12.6 12.6\" />"),
    BARCODE(
        "barcode",
        "<path d=\"M4 7v-1a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 17v1a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M5 11h1v2h-1l0 -2\" />\n  <path d=\"M10 11l0 2\" />\n  <path d=\"M14 11h1v2h-1l0 -2\" />\n  <path d=\"M19 11l0 2\" />"),
    BARCODE_OFF(
        "barcode-off",
        "<path d=\"M4 7v-1c0 -.552 .224 -1.052 .586 -1.414\" />\n  <path d=\"M4 17v1a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M16 20h2c.551 0 1.05 -.223 1.412 -.584\" />\n  <path d=\"M5 11h1v2h-1l0 -2\" />\n  <path d=\"M10 11v2\" />\n  <path d=\"M15 11v.01\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M3 3l18 18\" />"),
    BELL(
        "bell",
        "<path d=\"M10 5a2 2 0 1 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 6 0v-1\" />"),
    BELL_BOLT(
        "bell-bolt",
        "<path d=\"M13.5 17h-9.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1\" />\n  <path d=\"M9 17v1a3 3 0 0 0 4.368 2.67\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    BELL_CANCEL(
        "bell-cancel",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3 3\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    BELL_CHECK(
        "bell-check",
        "<path d=\"M11.5 17h-7.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v3c.016 .129 .037 .256 .065 .382\" />\n  <path d=\"M9 17v1a3 3 0 0 0 2.502 2.959\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    BELL_CODE(
        "bell-code",
        "<path d=\"M11.5 17h-7.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v2\" />\n  <path d=\"M9 17v1a3 3 0 0 0 2.498 2.958\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    BELL_COG(
        "bell-cog",
        "<path d=\"M12 17h-8a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v.5\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3 3\" />"),
    BELL_DOLLAR(
        "bell-dollar",
        "<path d=\"M13 17h-9a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 3.911 5.17\" />\n  <path d=\"M9 17v1a3 3 0 0 0 4.02 2.822\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    BELL_DOWN(
        "bell-down",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3.518 2.955\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    BELL_EXCLAMATION(
        "bell-exclamation",
        "<path d=\"M15 17h-11a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1.5\" />\n  <path d=\"M9 17v1a3 3 0 0 0 6 0v-1\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    BELL_HEART(
        "bell-heart",
        "<path d=\"M10 17h-6a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6\" />\n  <path d=\"M9 17v1c0 1.408 .97 2.59 2.28 2.913\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    BELL_MINUS(
        "bell-minus",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v3c.047 .386 .149 .758 .3 1.107\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3.504 2.958\" />\n  <path d=\"M16 19h6\" />"),
    BELL_OFF(
        "bell-off",
        "<path d=\"M9.346 5.353c.21 -.129 .428 -.246 .654 -.353a2 2 0 1 1 4 0a7 7 0 0 1 4 6v3m-1 3h-13a4 4 0 0 0 2 -3v-3a6.996 6.996 0 0 1 1.273 -3.707\" />\n  <path d=\"M9 17v1a3 3 0 0 0 6 0v-1\" />\n  <path d=\"M3 3l18 18\" />"),
    BELL_PAUSE(
        "bell-pause",
        "<path d=\"M13 17h-9a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v2\" />\n  <path d=\"M9 17v1a3 3 0 0 0 4.022 2.821\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    BELL_PIN(
        "bell-pin",
        "<path d=\"M12 17h-8a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3.64 2.931\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    BELL_PLUS(
        "bell-plus",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3.51 2.957\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    BELL_QUESTION(
        "bell-question",
        "<path d=\"M13.5 17h-9.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 5.914 .716\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    BELL_RINGING(
        "bell-ringing",
        "<path d=\"M10 5a2 2 0 0 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 6 0v-1\" />\n  <path d=\"M21 6.727a11.05 11.05 0 0 0 -2.794 -3.727\" />\n  <path d=\"M3 6.727a11.05 11.05 0 0 1 2.792 -3.727\" />"),
    BELL_RINGING_2(
        "bell-ringing-2",
        "<path d=\"M19.364 4.636a2 2 0 0 1 0 2.828a7 7 0 0 1 -1.414 7.072l-2.122 2.12a4 4 0 0 0 -.707 3.536l-11.313 -11.312a4 4 0 0 0 3.535 -.707l2.121 -2.123a7 7 0 0 1 7.072 -1.414a2 2 0 0 1 2.828 0\" />\n  <path d=\"M7.343 12.414l-.707 .707a3 3 0 0 0 4.243 4.243l.707 -.707\" />"),
    BELL_SEARCH(
        "bell-search",
        "<path d=\"M11 17h-7a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 2.685 2.984\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    BELL_SHARE(
        "bell-share",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v2\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3 3\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    BELL_STAR(
        "bell-star",
        "<path d=\"M9.5 17h-5.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 3.88 5\" />\n  <path d=\"M9 17v1a3 3 0 0 0 2.15 2.878\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    BELL_UP(
        "bell-up",
        "<path d=\"M12.5 17h-8.5a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v1\" />\n  <path d=\"M9 17v1a3 3 0 0 0 3.49 2.96\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    BELL_X(
        "bell-x",
        "<path d=\"M13 17h-9a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6a2 2 0 1 1 4 0a7 7 0 0 1 4 6v2\" />\n  <path d=\"M9 17v1a3 3 0 0 0 4.194 2.753\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    BELL_Z(
        "bell-z",
        "<path d=\"M10 5a2 2 0 1 1 4 0a7 7 0 0 1 4 6v3a4 4 0 0 0 2 3h-16a4 4 0 0 0 2 -3v-3a7 7 0 0 1 4 -6\" />\n  <path d=\"M9 17v1a3 3 0 0 0 6 0v-1\" />\n  <path d=\"M10 9h4l-4 4h4\" />"),
    BLOB(
        "blob",
        "<path d=\"M5.897 20.188c1.67 .752 3.896 .812 6.103 .812s4.434 -.059 6.104 -.812c.868 -.392 1.614 -.982 2.133 -1.856c.514 -.865 .763 -1.94 .763 -3.234c0 -2.577 -.983 -5.315 -2.557 -7.416c-1.57 -2.094 -3.833 -3.682 -6.443 -3.682s-4.873 1.588 -6.443 3.682c-1.574 2.101 -2.557 4.84 -2.557 7.416c0 1.295 .249 2.369 .763 3.234c.519 .874 1.265 1.464 2.134 1.856\" />"),
    BLOB_DASHED(
        "blob-dashed",
        "<path d=\"M10.899 20.992q .498 .008 1 .008\" />\n  <path d=\"M15.989 20.781q .506 -.079 .979 -.201\" />\n  <path d=\"M20.249 18.312q .247 -.421 .412 -.909\" />\n  <path d=\"M20.856 13.346q -.08 -.492 -.201 -.98\" />\n  <path d=\"M19.07 8.603a13 13 0 0 0 -.559 -.829\" />\n  <path d=\"M15.526 5.004a8 8 0 0 0 -.892 -.451\" />\n  <path d=\"M10.621 4.149a7 7 0 0 0 -.958 .284\" />\n  <path d=\"M6.329 6.756q -.34 .367 -.647 .762\" />\n  <path d=\"M3.727 11.103q -.17 .472 -.301 .953\" />\n  <path d=\"M3.057 16.115q .06 .519 .188 .982\" />\n  <path d=\"M5.79 20.138l.107 .05q .446 .2 .94 .339\" />"),
    BLOCKS(
        "blocks",
        "<path d=\"M14 4a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v5a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1l0 -5\" />\n  <path d=\"M3 14h12a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h3a2 2 0 0 1 2 2v12\" />"),
    BODY_SCAN(
        "body-scan",
        "<path d=\"M11 8a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M10 17v-1a2 2 0 1 1 4 0v1\" />\n  <path d=\"M8 10q 1 1 2 1h4q 1 0 2 -1\" />\n  <path d=\"M12 11v3\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    CALENDAR(
        "calendar",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M11 15h1\" />\n  <path d=\"M12 15v3\" />"),
    CALENDAR_BOLT(
        "calendar-bolt",
        "<path d=\"M13.5 21h-7.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    CALENDAR_CANCEL(
        "calendar-cancel",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    CALENDAR_CHECK(
        "calendar-check",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    CALENDAR_CLOCK(
        "calendar-clock",
        "<path d=\"M10.5 21h-4.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h10\" />\n  <path d=\"M14 18a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M18 16.5v1.5l.5 .5\" />"),
    CALENDAR_CODE(
        "calendar-code",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    CALENDAR_COG(
        "calendar-cog",
        "<path d=\"M12 21h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    CALENDAR_DOLLAR(
        "calendar-dollar",
        "<path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h12.5\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    CALENDAR_DOT(
        "calendar-dot",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    CALENDAR_DOWN(
        "calendar-down",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />"),
    CALENDAR_DUE(
        "calendar-due",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    CALENDAR_EVENT(
        "calendar-event",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M16 3l0 4\" />\n  <path d=\"M8 3l0 4\" />\n  <path d=\"M4 11l16 0\" />\n  <path d=\"M8 15h2v2h-2l0 -2\" />"),
    CALENDAR_EXCLAMATION(
        "calendar-exclamation",
        "<path d=\"M15 21h-9a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M11 15h1\" />\n  <path d=\"M12 15v3\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    CALENDAR_HEART(
        "calendar-heart",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    CALENDAR_MINUS(
        "calendar-minus",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M16 19h6\" />"),
    CALENDAR_MONTH(
        "calendar-month",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M8 14v4\" />\n  <path d=\"M12 14v4\" />\n  <path d=\"M16 14v4\" />"),
    CALENDAR_OFF(
        "calendar-off",
        "<path d=\"M9 5h9a2 2 0 0 1 2 2v9m-.184 3.839a2 2 0 0 1 -1.816 1.161h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 1.158 -1.815\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v1\" />\n  <path d=\"M4 11h7m4 0h5\" />\n  <path d=\"M3 3l18 18\" />"),
    CALENDAR_PAUSE(
        "calendar-pause",
        "<path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    CALENDAR_PIN(
        "calendar-pin",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />"),
    CALENDAR_PLUS(
        "calendar-plus",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    CALENDAR_QUESTION(
        "calendar-question",
        "<path d=\"M15 21h-9a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    CALENDAR_REPEAT(
        "calendar-repeat",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h12\" />\n  <path d=\"M20 14l2 2h-3\" />\n  <path d=\"M20 18l2 -2\" />\n  <path d=\"M19 16a3 3 0 1 0 2 5.236\" />"),
    CALENDAR_SAD(
        "calendar-sad",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12m12 -4v4m-8 -4v4m-4 4h16m-9.995 3h.01m3.99 0h.01\" />\n  <path d=\"M10 18a3.5 3.5 0 0 1 4 0\" />"),
    CALENDAR_SEARCH(
        "calendar-search",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4.5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    CALENDAR_SHARE(
        "calendar-share",
        "<path d=\"M12 21h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    CALENDAR_SMILE(
        "calendar-smile",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12m12 -4v4m-8 -4v4m-4 4h16m-9.995 3h.01m3.99 0h.01\" />\n  <path d=\"M10.005 17a3.5 3.5 0 0 0 4 0\" />"),
    CALENDAR_STAR(
        "calendar-star",
        "<path d=\"M11 21h-5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h11\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    CALENDAR_STATS(
        "calendar-stats",
        "<path d=\"M11.795 21h-6.795a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M18 14v4h4\" />\n  <path d=\"M14 18a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M15 3v4\" />\n  <path d=\"M7 3v4\" />\n  <path d=\"M3 11h16\" />"),
    CALENDAR_TIME(
        "calendar-time",
        "<path d=\"M11.795 21h-6.795a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14 18a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M15 3v4\" />\n  <path d=\"M7 3v4\" />\n  <path d=\"M3 11h16\" />\n  <path d=\"M18 16.496v1.504l1 1\" />"),
    CALENDAR_UP(
        "calendar-up",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    CALENDAR_USER(
        "calendar-user",
        "<path d=\"M12 21h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4.5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M17 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M22 22a2 2 0 0 0 -2 -2h-2a2 2 0 0 0 -2 2\" />"),
    CALENDAR_WEEK(
        "calendar-week",
        "<path d=\"M4 7a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M7 14h.013\" />\n  <path d=\"M10.01 14h.005\" />\n  <path d=\"M13.01 14h.005\" />\n  <path d=\"M16.015 14h.005\" />\n  <path d=\"M13.015 17h.005\" />\n  <path d=\"M7.01 17h.005\" />\n  <path d=\"M10.01 17h.005\" />"),
    CALENDAR_X(
        "calendar-x",
        "<path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M16 3v4\" />\n  <path d=\"M8 3v4\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    CHECK("check", "<path d=\"M5 12l5 5l10 -10\" />"),
    CHECKBOX(
        "checkbox",
        "<path d=\"M9 11l3 3l8 -8\" />\n  <path d=\"M20 12v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h9\" />"),
    CHECKLIST(
        "checklist",
        "<path d=\"M9.615 20h-2.615a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8\" />\n  <path d=\"M14 19l2 2l4 -4\" />\n  <path d=\"M9 8h4\" />\n  <path d=\"M9 12h2\" />"),
    CHECKS("checks", "<path d=\"M7 12l5 5l10 -10\" />\n  <path d=\"M2 12l5 5m5 -5l5 -5\" />"),
    CLEAR_ALL(
        "clear-all",
        "<path d=\"M8 6h12\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M4 18h12\" />"),
    CLICK(
        "click",
        "<path d=\"M3 12l3 0\" />\n  <path d=\"M12 3l0 3\" />\n  <path d=\"M7.8 7.8l-2.2 -2.2\" />\n  <path d=\"M16.2 7.8l2.2 -2.2\" />\n  <path d=\"M7.8 16.2l-2.2 2.2\" />\n  <path d=\"M12 12l9 3l-4 2l-2 4l-3 -9\" />"),
    CLOCK(
        "clock",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M12 7v5l3 3\" />"),
    CLOCK_12(
        "clock-12",
        "<path d=\"M3 12a9 9 0 0 0 9 9m9 -9a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 7v5l.5 .5\" />\n  <path d=\"M18 15h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M15 21v-6\" />"),
    CLOCK_2(
        "clock-2",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M4 12h1\" />\n  <path d=\"M19 12h1\" />\n  <path d=\"M12 19v1\" />"),
    CLOCK_24(
        "clock-24",
        "<path d=\"M3 12a9 9 0 0 0 5.998 8.485m12.002 -8.485a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 7v5\" />\n  <path d=\"M12 15h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M18 15v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M21 15v6\" />"),
    CLOCK_BITCOIN(
        "clock-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M20.866 10.45a9 9 0 1 0 -7.815 10.488\" />\n  <path d=\"M12 7v5l1.5 1.5\" />"),
    CLOCK_BOLT(
        "clock-bolt",
        "<path d=\"M20.984 12.53a9 9 0 1 0 -7.552 8.355\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    CLOCK_CANCEL(
        "clock-cancel",
        "<path d=\"M20.997 12.25a9 9 0 1 0 -8.718 8.745\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M12 7v5l2 2\" />"),
    CLOCK_CHECK(
        "clock-check",
        "<path d=\"M20.942 13.021a9 9 0 1 0 -9.407 7.967\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    CLOCK_CODE(
        "clock-code",
        "<path d=\"M20.931 13.111a9 9 0 1 0 -9.453 7.874\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />\n  <path d=\"M12 7v5l2 2\" />"),
    CLOCK_COG(
        "clock-cog",
        "<path d=\"M21 12a9 9 0 1 0 -9.002 9\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />\n  <path d=\"M12 7v5l2 2\" />"),
    CLOCK_DOLLAR(
        "clock-dollar",
        "<path d=\"M20.866 10.45a9 9 0 1 0 -7.815 10.488\" />\n  <path d=\"M12 7v5l1.5 1.5\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    CLOCK_DOWN(
        "clock-down",
        "<path d=\"M20.984 12.535a9 9 0 1 0 -8.431 8.448\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    CLOCK_EDIT(
        "clock-edit",
        "<path d=\"M21 12a9 9 0 1 0 -9.972 8.948c.32 .034 .644 .052 .972 .052\" />\n  <path d=\"M12 7v5l2 2\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    CLOCK_EXCLAMATION(
        "clock-exclamation",
        "<path d=\"M20.986 12.502a9 9 0 1 0 -5.973 7.98\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    CLOCK_HEART(
        "clock-heart",
        "<path d=\"M20.956 11.107a9 9 0 1 0 -9.579 9.871\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />\n  <path d=\"M12 7v5l.5 .5\" />"),
    CLOCK_HOUR_1(
        "clock-hour-1",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 7v5\" />\n  <path d=\"M12 12l2 -3\" />"),
    CLOCK_HOUR_10(
        "clock-hour-10",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l-3 -2\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_11(
        "clock-hour-11",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l-2 -3\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_12(
        "clock-hour-12",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_2(
        "clock-hour-2",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l3 -2\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_3(
        "clock-hour-3",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12h3.5\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_4(
        "clock-hour-4",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l3 2\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_5(
        "clock-hour-5",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l2 3\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_6(
        "clock-hour-6",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12v3.5\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_7(
        "clock-hour-7",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l-2 3\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_8(
        "clock-hour-8",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l-3 2\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_HOUR_9(
        "clock-hour-9",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12h-3.5\" />\n  <path d=\"M12 7v5\" />"),
    CLOCK_MINUS(
        "clock-minus",
        "<path d=\"M20.477 15.022a9 9 0 1 0 -7.998 5.965\" />\n  <path d=\"M12 7v5l3 3\" />\n  <path d=\"M16 19h6\" />"),
    CLOCK_OFF(
        "clock-off",
        "<path d=\"M5.633 5.64a9 9 0 1 0 12.735 12.72m1.674 -2.32a9 9 0 0 0 -12.082 -12.082\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M3 3l18 18\" />"),
    CLOCK_PAUSE(
        "clock-pause",
        "<path d=\"M20.942 13.018a9 9 0 1 0 -7.909 7.922\" />\n  <path d=\"M12 7v5l2 2\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    CLOCK_PIN(
        "clock-pin",
        "<path d=\"M20.971 11.278a9 9 0 1 0 -8.313 9.698\" />\n  <path d=\"M12 7v5l1.5 1.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    CLOCK_PLAY(
        "clock-play",
        "<path d=\"M12 7v5l2 2\" />\n  <path d=\"M17 22l5 -3l-5 -3l0 6\" />\n  <path d=\"M13.017 20.943a9 9 0 1 1 7.831 -7.292\" />"),
    CLOCK_PLUS(
        "clock-plus",
        "<path d=\"M20.984 12.535a9 9 0 1 0 -8.468 8.45\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M12 7v5l3 3\" />"),
    CLOCK_QUESTION(
        "clock-question",
        "<path d=\"M20.975 11.33a9 9 0 1 0 -5.717 9.06\" />\n  <path d=\"M12 7v5l2 2\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    CLOCK_RECORD(
        "clock-record",
        "<path d=\"M21 12.3a9 9 0 1 0 -8.683 8.694\" />\n  <path d=\"M12 7v5l2 2\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    CLOCK_SEARCH(
        "clock-search",
        "<path d=\"M20.993 11.646a9 9 0 1 0 -9.318 9.348\" />\n  <path d=\"M12 7v5l1 1\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    CLOCK_SHARE(
        "clock-share",
        "<path d=\"M20.943 13.016a9 9 0 1 0 -8.915 7.984\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />\n  <path d=\"M12 7v5l2 2\" />"),
    CLOCK_SHIELD(
        "clock-shield",
        "<path d=\"M21 12a9 9 0 1 0 -8.98 9\" />\n  <path d=\"M12 7v5l1 1\" />\n  <path d=\"M22 16c0 4 -2.5 6 -3.5 6s-3.5 -2 -3.5 -6c1 0 2.5 -.5 3.5 -1.5c1 1 2.5 1.5 3.5 1.5\" />"),
    CLOCK_STAR(
        "clock-star",
        "<path d=\"M20.982 11.436a9 9 0 1 0 -9.966 9.51\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M12 7v5l1 1\" />"),
    CLOCK_STOP(
        "clock-stop",
        "<path d=\"M21 12a9 9 0 1 0 -9 9\" />\n  <path d=\"M12 7v5l1 1\" />\n  <path d=\"M16 16h6v6h-6l0 -6\" />"),
    CLOCK_UP(
        "clock-up",
        "<path d=\"M20.983 12.548a9 9 0 1 0 -8.45 8.436\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M12 7v5l2.5 2.5\" />"),
    CLOCK_X(
        "clock-x",
        "<path d=\"M20.926 13.15a9 9 0 1 0 -7.835 7.784\" />\n  <path d=\"M12 7v5l2 2\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    CLOUD_BITCOIN(
        "cloud-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M13.5 18.004h-6.843c-2.572 -.004 -4.657 -2.011 -4.657 -4.487s2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.28 1.023 1.957 2.51 1.873 4.027\" />"),
    CLOUD_DOWNLOAD(
        "cloud-download",
        "<path d=\"M19 18a3.5 3.5 0 0 0 0 -7h-1a5 4.5 0 0 0 -11 -2a4.6 4.4 0 0 0 -2.1 8.4\" />\n  <path d=\"M12 13l0 9\" />\n  <path d=\"M9 19l3 3l3 -3\" />"),
    CLOUD_LOCK(
        "cloud-lock",
        "<path d=\"M19 18a3.5 3.5 0 0 0 0 -7h-1c.397 -1.768 -.285 -3.593 -1.788 -4.787c-1.503 -1.193 -3.6 -1.575 -5.5 -1s-3.315 2.019 -3.712 3.787c-2.199 -.088 -4.155 1.326 -4.666 3.373c-.512 2.047 .564 4.154 2.566 5.027\" />\n  <path d=\"M8 16a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M10 15v-2a2 2 0 1 1 4 0v2\" />"),
    CLOUD_LOCK_OPEN(
        "cloud-lock-open",
        "<path d=\"M19 18a3.5 3.5 0 0 0 0 -7h-1c.397 -1.768 -.285 -3.593 -1.788 -4.787c-1.503 -1.193 -3.6 -1.575 -5.5 -1s-3.315 2.019 -3.712 3.787c-2.199 -.088 -4.155 1.326 -4.666 3.373c-.512 2.047 .564 4.154 2.566 5.027\" />\n  <path d=\"M8 16a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M10 15v-2a2 2 0 0 1 3.736 -1\" />"),
    CLOUD_NETWORK(
        "cloud-network",
        "<path d=\"M3 20h7\" />\n  <path d=\"M14 20h7\" />\n  <path d=\"M10 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 16v2\" />\n  <path d=\"M8 16.004h-1.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.913 0 3.464 1.56 3.464 3.486c0 1.927 -1.551 3.487 -3.465 3.487h-2.535\" />"),
    CLOUD_UPLOAD(
        "cloud-upload",
        "<path d=\"M7 18a4.6 4.4 0 0 1 0 -9a5 4.5 0 0 1 11 2h1a3.5 3.5 0 0 1 0 7h-1\" />\n  <path d=\"M9 15l3 -3l3 3\" />\n  <path d=\"M12 12l0 9\" />"),
    CODE_VARIABLE(
        "code-variable",
        "<path d=\"M4 10a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -4\" />"),
    CODE_VARIABLE_MINUS(
        "code-variable-minus",
        "<path d=\"M12.5 16h-6.5a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M16 18h6\" />"),
    CODE_VARIABLE_PLUS(
        "code-variable-plus",
        "<path d=\"M13 16h-7a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v1\" />\n  <path d=\"M16 18h6\" />\n  <path d=\"M19 15v6\" />"),
    CONGRUENT_TO(
        "congruent-to",
        "<path d=\"M5 13h14\" />\n  <path d=\"M5 17h14\" />\n  <path d=\"M5 7.686c2.333 -2.624 4.667 -1.856 7 .064s4.667 2.688 7 .064\" />"),
    CREATIVE_COMMONS(
        "creative-commons",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10.5 10.5c-.847 -.71 -2.132 -.658 -2.914 .116a1.928 1.928 0 0 0 0 2.768c.782 .774 2.067 .825 2.914 .116\" />\n  <path d=\"M16.5 10.5c-.847 -.71 -2.132 -.658 -2.914 .116a1.928 1.928 0 0 0 0 2.768c.782 .774 2.067 .825 2.914 .116\" />"),
    CREATIVE_COMMONS_BY(
        "creative-commons-by",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M11 7a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9 13v-1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-.5l-.5 4h-2l-.5 -4h-.5a1 1 0 0 1 -1 -1\" />"),
    CREATIVE_COMMONS_NC(
        "creative-commons-nc",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M15 9h-4.5a1.5 1.5 0 0 0 0 3h3a1.5 1.5 0 0 1 0 3h-4.5\" />\n  <path d=\"M12 7v2\" />\n  <path d=\"M12 15v2\" />\n  <path d=\"M6 6l3 3\" />\n  <path d=\"M15 15l3 3\" />"),
    CREATIVE_COMMONS_ND(
        "creative-commons-nd",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M9 14h6\" />"),
    CREATIVE_COMMONS_OFF(
        "creative-commons-off",
        "<path d=\"M5.638 5.634a9 9 0 1 0 12.723 12.733m1.686 -2.332a9 9 0 0 0 -12.093 -12.077\" />\n  <path d=\"M10.5 10.5a2.187 2.187 0 0 0 -2.914 .116a1.928 1.928 0 0 0 0 2.768a2.188 2.188 0 0 0 2.914 .116\" />\n  <path d=\"M16.5 10.5a2.194 2.194 0 0 0 -2.309 -.302\" />\n  <path d=\"M3 3l18 18\" />"),
    CREATIVE_COMMONS_SA(
        "creative-commons-sa",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 16a4 4 0 1 0 -4 -4v1\" />\n  <path d=\"M6 12l2 2l2 -2\" />"),
    CREATIVE_COMMONS_ZERO(
        "creative-commons-zero",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 12a3 4 0 1 0 6 0a3 4 0 1 0 -6 0\" />\n  <path d=\"M14 9l-4 6\" />"),
    CREDITS(
        "credits",
        "<path d=\"M3 14a6 2 0 1 0 12 0a6 2 0 1 0 -12 0\" />\n  <path d=\"M3 14v5c0 1.105 2.686 2 6 2s6 -.895 6 -2v-5\" />\n  <path d=\"M9 5a6 2 0 1 0 12 0a6 2 0 1 0 -12 0\" />\n  <path d=\"M9 5v3\" />\n  <path d=\"M18.365 11.656c1.59 -.36 2.635 -.966 2.635 -1.656v-5\" />"),
    CROSSHAIR(
        "crosshair",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M9 12l6 0\" />\n  <path d=\"M12 9l0 6\" />"),
    CUBE_3D_SPHERE(
        "cube-3d-sphere",
        "<path d=\"M6 17.6l-2 -1.1v-2.5\" />\n  <path d=\"M4 10v-2.5l2 -1.1\" />\n  <path d=\"M10 4.1l2 -1.1l2 1.1\" />\n  <path d=\"M18 6.4l2 1.1v2.5\" />\n  <path d=\"M20 14v2.5l-2 1.12\" />\n  <path d=\"M14 19.9l-2 1.1l-2 -1.1\" />\n  <path d=\"M12 12l2 -1.1\" />\n  <path d=\"M18 8.6l2 -1.1\" />\n  <path d=\"M12 12l0 2.5\" />\n  <path d=\"M12 18.5l0 2.5\" />\n  <path d=\"M12 12l-2 -1.12\" />\n  <path d=\"M6 8.6l-2 -1.1\" />"),
    CUBE_3D_SPHERE_OFF(
        "cube-3d-sphere-off",
        "<path d=\"M6 17.6l-2 -1.1v-2.5\" />\n  <path d=\"M4 10v-2.5l2 -1.1\" />\n  <path d=\"M10 4.1l2 -1.1l2 1.1\" />\n  <path d=\"M18 6.4l2 1.1v2.5\" />\n  <path d=\"M20 14v2\" />\n  <path d=\"M14 19.9l-2 1.1l-2 -1.1\" />\n  <path d=\"M18 8.6l2 -1.1\" />\n  <path d=\"M12 12v2.5\" />\n  <path d=\"M12 18.5v2.5\" />\n  <path d=\"M12 12l-2 -1.12\" />\n  <path d=\"M6 8.6l-2 -1.1\" />\n  <path d=\"M3 3l18 18\" />"),
    CUBE_SEND(
        "cube-send",
        "<path d=\"M16 12.5l-5 -3l5 -3l5 3v5.5l-5 3l0 -5.5\" />\n  <path d=\"M11 9.5v5.5l5 3\" />\n  <path d=\"M16 12.545l5 -3.03\" />\n  <path d=\"M7 9h-5\" />\n  <path d=\"M7 12h-3\" />\n  <path d=\"M7 15h-1\" />"),
    CUBE_UNFOLDED(
        "cube-unfolded",
        "<path d=\"M2 15h10v5h5v-5h5v-5h-10v-5h-5v5h-5l0 5\" />\n  <path d=\"M7 15v-5h5v5h5v-5\" />"),
    CURLY_LOOP(
        "curly-loop",
        "<path d=\"M21 8c-4 0 -7 2 -7 5a3 3 0 0 0 6 0c0 -3 -2.5 -5 -8 -5s-8 2 -8 5a3 3 0 0 0 6 0c0 -3 -3 -5 -7 -5\" />"),
    CURSOR_OFF(
        "cursor-off",
        "<path d=\"M9 4a3 3 0 0 1 3 3v1m0 9a3 3 0 0 1 -3 3\" />\n  <path d=\"M15 4a3 3 0 0 0 -3 3v1m0 4v5a3 3 0 0 0 3 3\" />\n  <path d=\"M3 3l18 18\" />"),
    DASHBOARD(
        "dashboard",
        "<path d=\"M10 13a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M13.45 11.55l2.05 -2.05\" />\n  <path d=\"M6.4 20a9 9 0 1 1 11.2 0l-11.2 0\" />"),
    DASHBOARD_OFF(
        "dashboard-off",
        "<path d=\"M11.175 11.178a2 2 0 1 0 2.653 2.634\" />\n  <path d=\"M14.5 10.5l1 -1\" />\n  <path d=\"M8.621 4.612a9 9 0 0 1 11.721 11.72m-1.516 2.488a9.008 9.008 0 0 1 -1.226 1.18h-11.2a9 9 0 0 1 -.268 -13.87\" />\n  <path d=\"M3 3l18 18\" />"),
    DATABASE_SMILE(
        "database-smile",
        "<path d=\"M10 14h.01\" />\n  <path d=\"M14 14h.01\" />\n  <path d=\"M10 17a3.5 3.5 0 0 0 4 0\" />\n  <path d=\"M4 6c0 1.657 3.582 3 8 3s8 -1.343 8 -3s-3.582 -3 -8 -3s-8 1.343 -8 3\" />\n  <path d=\"M4 6v12c0 1.657 3.582 3 8 3s8 -1.343 8 -3v-12\" />"),
    DENTAL_BROKEN(
        "dental-broken",
        "<path d=\"M12 5.5c-1.074 -.586 -2.583 -1.5 -4 -1.5c-2.1 0 -4 1.247 -4 5c0 4.899 1.056 8.41 2.671 10.537c.573 .756 1.97 .521 2.567 -.236c.398 -.505 .819 -1.439 1.262 -2.801c.292 -.771 .892 -1.504 1.5 -1.5c.602 0 1.21 .737 1.5 1.5c.443 1.362 .864 2.295 1.262 2.8c.597 .759 2 .993 2.567 .237c1.615 -2.127 2.671 -5.637 2.671 -10.537c0 -3.74 -1.908 -5 -4 -5c-1.423 0 -2.92 .911 -4 1.5\" />\n  <path d=\"M12 5.5l1 2.5l-2 2l2 2\" />"),
    DESELECT(
        "deselect",
        "<path d=\"M12 8h3a1 1 0 0 1 1 1v3\" />\n  <path d=\"M16 16h-7a1 1 0 0 1 -1 -1v-7\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 8v.01\" />\n  <path d=\"M8 4v.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M16 4v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    DESK(
        "desk",
        "<path d=\"M3 6h18\" />\n  <path d=\"M4 6v13\" />\n  <path d=\"M20 19v-13\" />\n  <path d=\"M4 10h16\" />\n  <path d=\"M15 6v8a2 2 0 0 0 2 2h3\" />"),
    DETAILS(
        "details",
        "<path d=\"M11.999 3l.001 17\" />\n  <path d=\"M10.363 3.591l-8.106 13.534a1.914 1.914 0 0 0 1.636 2.871h16.214a1.914 1.914 0 0 0 1.636 -2.87l-8.106 -13.536a1.914 1.914 0 0 0 -3.274 0\" />"),
    DETAILS_OFF(
        "details-off",
        "<path d=\"M5 19h14\" />\n  <path d=\"M20.986 16.984a2 2 0 0 0 -.146 -.734l-7.1 -12.25a2 2 0 0 0 -3.5 0l-.821 1.417m-1.469 2.534l-4.81 8.299a2 2 0 0 0 1.75 2.75\" />\n  <path d=\"M12 3v5m0 4v7\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_PROJECTOR(
        "device-projector",
        "<path d=\"M8 9a5 5 0 1 0 10 0a5 5 0 0 0 -10 0\" />\n  <path d=\"M9 6h-4a2 2 0 0 0 -2 2v8a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-8a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M6 15h1\" />\n  <path d=\"M7 18l-1 2\" />\n  <path d=\"M18 18l1 2\" />"),
    DEVICE_UNKNOWN(
        "device-unknown",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_WORKSTATION(
        "device-workstation",
        "<path d=\"M7.07 20l-4.84 -4.617a.79 .79 0 0 1 -.065 -1.041l2.835 -3.342\" />\n  <path d=\"M9 20h-5\" />\n  <path d=\"M6.398 8.063l-1.302 -.896a.95 .95 0 0 0 -1.318 .245l-.611 .889a.95 .95 0 0 0 .245 1.318l1.302 .896c1.041 .716 .635 3.505 2.735 4.949l4.551 -6.62c-2.067 -1.42 -4.559 -.065 -5.602 -.781\" />\n  <path d=\"M9 4h10a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-7\" />\n  <path d=\"M13 20h4\" />\n  <path d=\"M15 16v4\" />"),
    DIRECTION("direction", "<path d=\"M9 10l3 -3l3 3\" />\n  <path d=\"M9 14l3 3l3 -3\" />"),
    DIRECTION_ARROWS(
        "direction-arrows",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M8 11l-1 1l1 1\" />\n  <path d=\"M11 8l1 -1l1 1\" />\n  <path d=\"M16 11l1 1l-1 1\" />\n  <path d=\"M11 16l1 1l1 -1\" />"),
    DIRECTION_HORIZONTAL(
        "direction-horizontal", "<path d=\"M10 9l-3 3l3 3\" />\n  <path d=\"M14 9l3 3l-3 3\" />"),
    DIRECTION_SIGN(
        "direction-sign",
        "<path d=\"M3.32 12.774l7.906 7.905c.427 .428 1.12 .428 1.548 0l7.905 -7.905a1.095 1.095 0 0 0 0 -1.548l-7.905 -7.905a1.095 1.095 0 0 0 -1.548 0l-7.905 7.905a1.095 1.095 0 0 0 0 1.548\" />\n  <path d=\"M8 12h7.5\" />\n  <path d=\"M12 8.5l3.5 3.5l-3.5 3.5\" />"),
    DIRECTION_SIGN_OFF(
        "direction-sign-off",
        "<path d=\"M18.73 14.724l1.949 -1.95a1.095 1.095 0 0 0 0 -1.548l-7.905 -7.905a1.095 1.095 0 0 0 -1.548 0l-1.95 1.95m-2.01 2.01l-3.945 3.945a1.095 1.095 0 0 0 0 1.548l7.905 7.905c.427 .428 1.12 .428 1.548 0l3.95 -3.95\" />\n  <path d=\"M8 12h4\" />\n  <path d=\"M13.748 13.752l-1.748 1.748\" />\n  <path d=\"M3 3l18 18\" />"),
    DOOR(
        "door",
        "<path d=\"M14 12v.01\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M6 21v-16a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v16\" />"),
    DOOR_ENTER(
        "door-enter",
        "<path d=\"M13 12v.01\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M5 21v-16a2 2 0 0 1 2 -2h6m4 10.5v7.5\" />\n  <path d=\"M21 7h-7m3 -3l-3 3l3 3\" />"),
    DOOR_EXIT(
        "door-exit",
        "<path d=\"M13 12v.01\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M5 21v-16a2 2 0 0 1 2 -2h7.5m2.5 10.5v7.5\" />\n  <path d=\"M14 7h7m-3 -3l3 3l-3 3\" />"),
    DOOR_OFF(
        "door-off",
        "<path d=\"M3 21h18\" />\n  <path d=\"M6 21v-15\" />\n  <path d=\"M7.18 3.175c.25 -.112 .528 -.175 .82 -.175h8a2 2 0 0 1 2 2v9\" />\n  <path d=\"M18 18v3\" />\n  <path d=\"M3 3l18 18\" />"),
    DOTS(
        "dots",
        "<path d=\"M4 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    DOTS_CIRCLE_HORIZONTAL(
        "dots-circle-horizontal",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M8 12l0 .01\" />\n  <path d=\"M12 12l0 .01\" />\n  <path d=\"M16 12l0 .01\" />"),
    DOTS_DIAGONAL(
        "dots-diagonal",
        "<path d=\"M6 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16 7a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    DOTS_DIAGONAL_2(
        "dots-diagonal-2",
        "<path d=\"M6 7a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    DOTS_VERTICAL(
        "dots-vertical",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    EAR_SCAN(
        "ear-scan",
        "<path d=\"M15 15a2 2 0 0 1 -2 2c-.732 0 -1.555 -.247 -1.72 -.98c-.634 -2.8 -3.17 -2.628 -3.28 -5.02v-.5a3.5 3.5 0 0 1 6.671 -1.483\" />\n  <path d=\"M13 12v.01\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    ELEVATOR(
        "elevator",
        "<path d=\"M5 5a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M10 10l2 -2l2 2\" />\n  <path d=\"M10 14l2 2l2 -2\" />"),
    ELEVATOR_OFF(
        "elevator-off",
        "<path d=\"M8 4h10a1 1 0 0 1 1 1v10m0 4a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-14\" />\n  <path d=\"M12 8l2 2\" />\n  <path d=\"M10 14l2 2l2 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    EXCHANGE(
        "exchange",
        "<path d=\"M3 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19 8v5a5 5 0 0 1 -5 5h-3l3 -3m0 6l-3 -3\" />\n  <path d=\"M5 16v-5a5 5 0 0 1 5 -5h3l-3 -3m0 6l3 -3\" />"),
    EXCHANGE_OFF(
        "exchange-off",
        "<path d=\"M3 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19 8v5c0 .594 -.104 1.164 -.294 1.692m-1.692 2.298a4.978 4.978 0 0 1 -3.014 1.01h-3l3 -3\" />\n  <path d=\"M14 21l-3 -3\" />\n  <path d=\"M5 16v-5c0 -1.632 .782 -3.082 1.992 -4m3.008 -1h3l-3 -3\" />\n  <path d=\"M11.501 7.499l1.499 -1.499\" />\n  <path d=\"M3 3l18 18\" />"),
    EXCLAMATION_CIRCLE(
        "exclamation-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 16v.01\" />"),
    EXCLAMATION_MARK("exclamation-mark", "<path d=\"M12 19v.01\" />\n  <path d=\"M12 15v-10\" />"),
    EXCLAMATION_MARK_OFF(
        "exclamation-mark-off",
        "<path d=\"M12 19v.01\" />\n  <path d=\"M12 15v-3m0 -4v-3\" />\n  <path d=\"M3 3l18 18\" />"),
    EXPLICIT(
        "explicit",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M14 8h-4v8h4\" />\n  <path d=\"M14 12h-4\" />"),
    EXPLICIT_OFF(
        "explicit-off",
        "<path d=\"M14 8h-2m-2 2v6h4\" />\n  <path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M12 12h-2\" />\n  <path d=\"M3 3l18 18\" />"),
    EXTERNAL_LINK(
        "external-link",
        "<path d=\"M12 6h-6a2 2 0 0 0 -2 2v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-6\" />\n  <path d=\"M11 13l9 -9\" />\n  <path d=\"M15 4h5v5\" />"),
    EXTERNAL_LINK_OFF(
        "external-link-off",
        "<path d=\"M7 7h-1a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M10 14l2 -2m2.007 -2.007l6 -6\" />\n  <path d=\"M15 4h5v5\" />\n  <path d=\"M3 3l18 18\" />"),
    EYE(
        "eye",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M21 12c-2.4 4 -5.4 6 -9 6c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />"),
    EYE_BOLT(
        "eye-bolt",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M13.1 17.936a9.28 9.28 0 0 1 -1.1 .064c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    EYE_CANCEL(
        "eye-cancel",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    EYE_CHECK(
        "eye-check",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M11.102 17.957c-3.204 -.307 -5.904 -2.294 -8.102 -5.957c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6a19.5 19.5 0 0 1 -.663 1.032\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    EYE_CLOSED(
        "eye-closed",
        "<path d=\"M21 9c-2.4 2.667 -5.4 4 -9 4c-3.6 0 -6.6 -1.333 -9 -4\" />\n  <path d=\"M3 15l2.5 -3.8\" />\n  <path d=\"M21 14.976l-2.492 -3.776\" />\n  <path d=\"M9 17l.5 -4\" />\n  <path d=\"M15 17l-.5 -4\" />"),
    EYE_CODE(
        "eye-code",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M11.11 17.958c-3.209 -.307 -5.91 -2.293 -8.11 -5.958c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6c-.21 .352 -.427 .688 -.647 1.008\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    EYE_COG(
        "eye-cog",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    EYE_DOLLAR(
        "eye-dollar",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M13.193 17.924c-.39 .05 -.788 .076 -1.193 .076c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.005 0 5.592 1.394 7.761 4.181\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    EYE_DOWN(
        "eye-down",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    EYE_EDIT(
        "eye-edit",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M11.192 17.966c-3.242 -.28 -5.972 -2.269 -8.192 -5.966c2.4 -4 5.4 -6 9 -6c3.326 0 6.14 1.707 8.442 5.122\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    EYE_EXCLAMATION(
        "eye-exclamation",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M15.03 17.478a8.797 8.797 0 0 1 -3.03 .522c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6a20.48 20.48 0 0 1 -.258 .419\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    EYE_HEART(
        "eye-heart",
        "<path d=\"M13.905 11.39a2 2 0 1 0 -2.855 2.37\" />\n  <path d=\"M9.992 17.779c-2.722 -.621 -5.053 -2.547 -6.992 -5.779c2.4 -4 5.4 -6 9 -6c3.332 0 6.15 1.714 8.454 5.14\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    EYE_MINUS(
        "eye-minus",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6c-.713 1.188 -1.478 2.199 -2.296 3.034\" />\n  <path d=\"M16 19h6\" />"),
    EYE_OFF(
        "eye-off",
        "<path d=\"M10.585 10.587a2 2 0 0 0 2.829 2.828\" />\n  <path d=\"M16.681 16.673a8.717 8.717 0 0 1 -4.681 1.327c-3.6 0 -6.6 -2 -9 -6c1.272 -2.12 2.712 -3.678 4.32 -4.674m2.86 -1.146a9.055 9.055 0 0 1 1.82 -.18c3.6 0 6.6 2 9 6c-.666 1.11 -1.379 2.067 -2.138 2.87\" />\n  <path d=\"M3 3l18 18\" />"),
    EYE_PAUSE(
        "eye-pause",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M13.022 17.945a9.308 9.308 0 0 1 -1.022 .055c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6c-.195 .325 -.394 .636 -.596 .935\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    EYE_PIN(
        "eye-pin",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.362 0 6.202 1.745 8.517 5.234\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    EYE_PLUS(
        "eye-plus",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    EYE_QUESTION(
        "eye-question",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M14.071 17.764a8.989 8.989 0 0 1 -2.071 .236c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.346 0 6.173 1.727 8.482 5.182\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    EYE_SEARCH(
        "eye-search",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-.328 0 -.652 -.017 -.97 -.05c-3.172 -.332 -5.85 -2.315 -8.03 -5.95c2.4 -4 5.4 -6 9 -6c3.465 0 6.374 1.853 8.727 5.558\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    EYE_SHARE(
        "eye-share",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12.597 17.981a9.467 9.467 0 0 1 -.597 .019c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6c-.205 .342 -.415 .67 -.63 .983\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    EYE_SPARK(
        "eye-spark",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M11.669 17.994q -5.18 -.18 -8.669 -5.994q 3.6 -6 9 -6t 9 6\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    EYE_STAR(
        "eye-star",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M9.608 17.682c-2.558 -.71 -4.76 -2.603 -6.608 -5.682c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    EYE_UP(
        "eye-up",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M12 18c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6c-.09 .15 -.18 .295 -.27 .439\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    EYE_X(
        "eye-x",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M13.048 17.942a9.298 9.298 0 0 1 -1.048 .058c-3.6 0 -6.6 -2 -9 -6c2.4 -4 5.4 -6 9 -6c3.6 0 6.6 2 9 6a17.986 17.986 0 0 1 -1.362 1.975\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    FACE_ID(
        "face-id",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />"),
    FACE_ID_ERROR(
        "face-id-error",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15.05a3.5 3.5 0 0 1 5 0\" />"),
    FIDGET_SPINNER(
        "fidget-spinner",
        "<path d=\"M18 16v.01\" />\n  <path d=\"M6 16v.01\" />\n  <path d=\"M12 5v.01\" />\n  <path d=\"M12 12v.01\" />\n  <path d=\"M12 1a4 4 0 0 1 2.001 7.464l.001 .072a3.998 3.998 0 0 1 1.987 3.758l.22 .128a3.978 3.978 0 0 1 1.591 -.417l.2 -.005a4 4 0 1 1 -3.994 3.77l-.28 -.16c-.522 .25 -1.108 .39 -1.726 .39c-.619 0 -1.205 -.14 -1.728 -.391l-.279 .16l.007 .231a4 4 0 1 1 -2.212 -3.579l.222 -.129a3.998 3.998 0 0 1 1.988 -3.756l.002 -.071a4 4 0 0 1 -1.995 -3.265l-.005 -.2a4 4 0 0 1 4 -4\" />"),
    FILTER(
        "filter",
        "<path d=\"M4 4h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v7l-6 2v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227\" />"),
    FILTER_2(
        "filter-2", "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h6\" />"),
    FILTER_2_BOLT(
        "filter-2-bolt",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    FILTER_2_CANCEL(
        "filter-2-cancel",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M17 21l4 -4m-5 2c0 .796 .316 1.559 .879 2.121c.563 .563 1.326 .879 2.121 .879c.796 0 1.559 -.316 2.121 -.879c.563 -.563 .879 -1.326 .879 -2.121c0 -.796 -.316 -1.559 -.879 -2.121c-.563 -.563 -1.326 -.879 -2.121 -.879c-.796 0 -1.559 .316 -2.121 .879c-.563 .563 -.879 1.326 -.879 2.121l1 2\" />"),
    FILTER_2_CHECK(
        "filter-2-check",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M15 18l2 2l4 -4\" />"),
    FILTER_2_CODE(
        "filter-2-code",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M17 17l-2 2l2 2\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />"),
    FILTER_2_COG(
        "filter-2-cog",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19.001 21c-.53 0 -1.039 -.211 -1.414 -.586c-.375 -.375 -.586 -.884 -.586 -1.414c0 -.53 .211 -1.039 .586 -1.414c.375 -.375 .884 -.586 1.414 -.586m0 4c.53 0 1.039 -.211 1.414 -.586c.375 -.375 .586 -.884 .586 -1.414c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586m0 4v1.5m0 -5.5v-1.5m3.031 1.75l-1.299 .75m-3.463 2l-1.3 .75m0 -3.5l1.3 .75m3.463 2l1.3 .75\" />"),
    FILTER_2_DISCOUNT(
        "filter-2-discount",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M16 16v.01\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />"),
    FILTER_2_DOLLAR(
        "filter-2-dollar",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h10\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M21 15h-2m-2 6h2m0 0v1m0 -1h.5c.398 0 .779 -.158 1.061 -.439c.281 -.281 .439 -.663 .439 -1.061c0 -.398 -.158 -.779 -.439 -1.061c-.281 -.281 -.663 -.439 -1.061 -.439h-1c-.398 0 -.779 -.158 -1.061 -.439c-.281 -.281 -.439 -.663 -.439 -1.061c0 -.398 .158 -.779 .439 -1.061c.281 -.281 .663 -.439 1.061 -.439h.5m0 -1v1\" />"),
    FILTER_2_DOWN(
        "filter-2-down",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M19 22l3 -3\" />\n  <path d=\"M19 22l-3 -3\" />"),
    FILTER_2_EDIT(
        "filter-2-edit",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h11\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M18.42 15.61c.195 -.195 .426 -.35 .681 -.455c.255 -.106 .528 -.16 .804 -.16c.276 0 .549 .054 .804 .16c.255 .106 .486 .26 .681 .455c.195 .195 .35 .427 .455 .681c.106 .255 .16 .528 .16 .804c0 .276 -.054 .549 -.16 .804c-.105 .255 -.26 .486 -.455 .681l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    FILTER_2_EXCLAMATION(
        "filter-2-exclamation",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M19 16v3m0 3v.01\" />"),
    FILTER_2_MINUS(
        "filter-2-minus",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M16 19h6\" />"),
    FILTER_2_PAUSE(
        "filter-2-pause",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    FILTER_2_PIN(
        "filter-2-pin",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h10\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19 18v.01m2.121 2.111c.42 -.419 .706 -.954 .821 -1.536c.116 -.582 .056 -1.185 -.17 -1.733c-.227 -.548 -.611 -1.017 -1.105 -1.347c-.493 -.33 -1.073 -.506 -1.667 -.506c-.593 0 -1.173 .176 -1.667 .506c-.493 .33 -.878 .798 -1.105 1.347c-.227 .548 -.286 1.151 -.17 1.733c.116 .582 .402 1.116 .821 1.536c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879l-2.121 -2.121\" />"),
    FILTER_2_PLUS(
        "filter-2-plus",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h10\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19 15v6\" />\n  <path d=\"M16 18h6\" />"),
    FILTER_2_QUESTION(
        "filter-2-question",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h10.5\" />\n  <path d=\"M9 18h5\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19c.448 -.001 .883 -.153 1.235 -.431c.352 -.278 .6 -.666 .706 -1.101c.105 -.436 .061 -.894 -.125 -1.302c-.186 -.408 -.504 -.742 -.902 -.948c-.398 -.204 -.853 -.267 -1.291 -.179c-.438 .088 -.834 .321 -1.123 .662\" />"),
    FILTER_2_SEARCH(
        "filter-2-search",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h8.5\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M15 18c0 .796 .316 1.559 .879 2.121c.563 .563 1.326 .879 2.121 .879c.796 0 1.559 -.316 2.121 -.879c.563 -.563 .879 -1.326 .879 -2.121c0 -.796 -.316 -1.559 -.879 -2.121c-.563 -.563 -1.326 -.879 -2.121 -.879c-.796 0 -1.559 .316 -2.121 .879c-.563 .563 -.879 1.326 -.879 2.121\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    FILTER_2_SHARE(
        "filter-2-share",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3.5\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 17v4.5\" />\n  <path d=\"M21 17h-4.5\" />"),
    FILTER_2_SPARK(
        "filter-2-spark",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h9.5\" />\n  <path d=\"M9 18h2.5\" />\n  <path d=\"M19 21.5c.205 -.849 .641 -1.625 1.258 -2.242c.617 -.617 1.393 -1.053 2.242 -1.258c-.849 -.205 -1.625 -.641 -2.242 -1.258c-.617 -.617 -1.053 -1.393 -1.258 -2.242c-.205 .849 -.641 1.625 -1.258 2.242c-.617 .617 -1.393 1.053 -2.242 1.258c.849 .205 1.625 .641 2.242 1.258c.617 .617 1.053 1.393 1.258 2.242\" />"),
    FILTER_2_UP(
        "filter-2-up",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19 22v-6m0 0l3 3m-3 -3l-3 3\" />"),
    FILTER_2_X(
        "filter-2-x",
        "<path d=\"M4 6h16\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M22 22l-5 -5m0 5l5 -5\" />"),
    FILTER_BOLT(
        "filter-bolt",
        "<path d=\"M12.991 19.67l-3.991 1.33v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v3\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    FILTER_CANCEL(
        "filter-cancel",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    FILTER_CHECK(
        "filter-check",
        "<path d=\"M11.18 20.274l-2.18 .726v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v3\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    FILTER_CODE(
        "filter-code",
        "<path d=\"M11.19 20.27l-2.19 .73v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    FILTER_COG(
        "filter-cog",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    FILTER_DISCOUNT(
        "filter-discount",
        "<path d=\"M12.705 19.765l-3.705 1.235v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v.5\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    FILTER_DOLLAR(
        "filter-dollar",
        "<path d=\"M13.25 19.583l-4.25 1.417v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    FILTER_DOWN(
        "filter-down",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    FILTER_EDIT(
        "filter-edit",
        "<path d=\"M10.97 20.344l-1.97 .656v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    FILTER_EXCLAMATION(
        "filter-exclamation",
        "<path d=\"M4 4h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v7l-6 2v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    FILTER_HEART(
        "filter-heart",
        "<path d=\"M10.888 20.37l-1.888 .63v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-3.503 3.503\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    FILTER_MINUS(
        "filter-minus",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v3\" />\n  <path d=\"M16 19h6\" />"),
    FILTER_OFF(
        "filter-off",
        "<path d=\"M8 4h12v2.172a2 2 0 0 1 -.586 1.414l-3.914 3.914m-.5 3.5v4l-6 2v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227\" />\n  <path d=\"M3 3l18 18\" />"),
    FILTER_PAUSE(
        "filter-pause",
        "<path d=\"M12.97 19.677l-3.97 1.323v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    FILTER_PIN(
        "filter-pin",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    FILTER_PLUS(
        "filter-plus",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v3\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    FILTER_QUESTION(
        "filter-question",
        "<path d=\"M15 19l-6 2v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    FILTER_SEARCH(
        "filter-search",
        "<path d=\"M11.36 20.213l-2.36 .787v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    FILTER_SHARE(
        "filter-share",
        "<path d=\"M12.713 19.762l-3.713 1.238v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    FILTER_SPARK(
        "filter-spark",
        "<path d=\"M15 12.5v-.5l4.414 -4.414a2 2 0 0 0 .586 -1.414v-2.172h-16v2.227c0 .497 .185 .977 .52 1.345l4.48 4.928v8.5l2 -.667\" />\n  <path d=\"M18.5 22a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    FILTER_STAR(
        "filter-star",
        "<path d=\"M11.042 20.32l-2.042 .68v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    FILTER_UP(
        "filter-up",
        "<path d=\"M12 20l-3 1v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v2\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    FILTER_X(
        "filter-x",
        "<path d=\"M13.758 19.414l-4.758 1.586v-8.5l-4.48 -4.928a2 2 0 0 1 -.52 -1.345v-2.227h16v2.172a2 2 0 0 1 -.586 1.414l-4.414 4.414v1.5\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    FILTERS(
        "filters",
        "<path d=\"M7 8a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M8 11a5 5 0 1 0 3.998 1.997\" />\n  <path d=\"M12.002 19.003a5 5 0 1 0 3.998 -8.003\" />"),
    FINGERPRINT(
        "fingerprint",
        "<path d=\"M18.9 7a8 8 0 0 1 1.1 5v1a6 6 0 0 0 .8 3\" />\n  <path d=\"M8 11a4 4 0 0 1 8 0v1a10 10 0 0 0 2 6\" />\n  <path d=\"M12 11v2a14 14 0 0 0 2.5 8\" />\n  <path d=\"M8 15a18 18 0 0 0 1.8 6\" />\n  <path d=\"M4.9 19a22 22 0 0 1 -.9 -7v-1a8 8 0 0 1 12 -6.95\" />"),
    FINGERPRINT_OFF(
        "fingerprint-off",
        "<path d=\"M18.9 7a8 8 0 0 1 1.1 5v1a6 6 0 0 0 .8 3\" />\n  <path d=\"M8 11c0 -.848 .264 -1.634 .713 -2.28m2.4 -1.621a4 4 0 0 1 4.887 3.901l0 1\" />\n  <path d=\"M12 12v1a14 14 0 0 0 2.5 8\" />\n  <path d=\"M8 15a18 18 0 0 0 1.8 6\" />\n  <path d=\"M4.9 19a22 22 0 0 1 -.9 -7v-1a8 8 0 0 1 1.854 -5.143m2.176 -1.825a8 8 0 0 1 7.97 .018\" />\n  <path d=\"M3 3l18 18\" />"),
    FIRE_EXTINGUISHER(
        "fire-extinguisher",
        "<path d=\"M12 7a4 4 0 0 1 4 4v9a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-9a4 4 0 0 1 4 -4\" />\n  <path d=\"M9 16h6\" />\n  <path d=\"M12 7v-3\" />\n  <path d=\"M16 5l-4 -1l4 -1\" />\n  <path d=\"M12 4h-3a3 3 0 0 0 -3 3\" />"),
    FLAG_BITCOIN(
        "flag-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M13.222 14.882a5 5 0 0 1 -1.222 -.882a5 5 0 0 0 -7 0v-9a5 5 0 0 1 7 0a5 5 0 0 0 7 0v5\" />\n  <path d=\"M5 21v-7\" />"),
    FLAG_DISCOUNT(
        "flag-discount",
        "<path d=\"M12.804 14.641a5.02 5.02 0 0 1 -.804 -.641a5 5 0 0 0 -7 0v-9a5 5 0 0 1 7 0a5 5 0 0 0 7 0v8\" />\n  <path d=\"M5 21v-7\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    FOCUS_CENTERED(
        "focus-centered",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />"),
    FORBID(
        "forbid", "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 9l6 6\" />"),
    FORBID_2(
        "forbid-2",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 15l6 -6\" />"),
    FREE_RIGHTS(
        "free-rights",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M13.867 9.75c-.246 -.48 -.708 -.769 -1.2 -.75h-1.334c-.736 0 -1.333 .67 -1.333 1.5c0 .827 .597 1.499 1.333 1.499h1.334c.736 0 1.333 .671 1.333 1.5c0 .828 -.597 1.499 -1.333 1.499h-1.334c-.492 .019 -.954 -.27 -1.2 -.75\" />\n  <path d=\"M12 7v2\" />\n  <path d=\"M12 15v2\" />\n  <path d=\"M6 6l1.5 1.5\" />\n  <path d=\"M16.5 16.5l1.5 1.5\" />"),
    FRIENDS(
        "friends",
        "<path d=\"M5 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 22v-5l-1 -1v-4a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4l-1 1v5\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 22v-4h-2l2 -6a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1l2 6h-2v4\" />"),
    FRIENDS_OFF(
        "friends-off",
        "<path d=\"M5 5a2 2 0 0 0 2 2m2 -2a2 2 0 0 0 -2 -2\" />\n  <path d=\"M5 22v-5l-1 -1v-4a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4l-1 1v5\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 22v-4h-2l1.254 -3.763m1.036 -2.942a1 1 0 0 1 .71 -.295h2a1 1 0 0 1 1 1l1.503 4.508m-1.503 2.492v3\" />\n  <path d=\"M3 3l18 18\" />"),
    GALAXY(
        "galaxy",
        "<path d=\"M12 3c-1.333 1 -2 2.5 -2 4.5c0 3 2 4.5 2 4.5s2 1.5 2 4.5c0 2 -.667 3.5 -2 4.5\" />\n  <path d=\"M19.794 16.5c-.2 -1.655 -1.165 -2.982 -2.897 -3.982c-2.597 -1.5 -4.897 -.518 -4.897 -.518s-2.299 .982 -4.897 -.518c-1.732 -1 -2.698 -2.327 -2.897 -3.982\" />\n  <path d=\"M19.794 7.5c-1.532 -.655 -3.165 -.482 -4.897 .518c-2.597 1.5 -2.897 3.982 -2.897 3.982s-.299 2.482 -2.897 3.982c-1.732 1 -3.365 1.173 -4.897 .518\" />"),
    GAUGE(
        "gauge",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M13.41 10.59l2.59 -2.59\" />\n  <path d=\"M7 12a5 5 0 0 1 5 -5\" />"),
    GAUGE_OFF(
        "gauge-off",
        "<path d=\"M20.038 16.052a9 9 0 0 0 -12.067 -12.102m-2.333 1.686a9 9 0 1 0 12.73 12.726\" />\n  <path d=\"M11.283 11.303a1 1 0 0 0 1.419 1.41\" />\n  <path d=\"M14 10l2 -2\" />\n  <path d=\"M7 12c0 -1.386 .564 -2.64 1.475 -3.546m2.619 -1.372c.294 -.054 .597 -.082 .906 -.082\" />\n  <path d=\"M3 3l18 18\" />"),
    GAVEL(
        "gavel",
        "<path d=\"M13 10l7.383 7.418c.823 .82 .823 2.148 0 2.967a2.11 2.11 0 0 1 -2.976 0l-7.407 -7.385\" />\n  <path d=\"M6 9l4 4\" />\n  <path d=\"M13 10l-4 -4\" />\n  <path d=\"M3 21h7\" />\n  <path d=\"M6.793 15.793l-3.586 -3.586a1 1 0 0 1 0 -1.414l2.293 -2.293l.5 .5l3 -3l-.5 -.5l2.293 -2.293a1 1 0 0 1 1.414 0l3.586 3.586a1 1 0 0 1 0 1.414l-2.293 2.293l-.5 -.5l-3 3l.5 .5l-2.293 2.293a1 1 0 0 1 -1.414 0\" />"),
    GRAPH(
        "graph",
        "<path d=\"M4 18v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2\" />\n  <path d=\"M7 14l3 -3l2 2l3 -3l2 2\" />"),
    GRAPH_OFF(
        "graph-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M7 14l3 -3l2 2l.5 -.5m2 -2l.5 -.5l2 2\" />\n  <path d=\"M3 3l18 18\" />"),
    GRID_DOTS(
        "grid-dots",
        "<path d=\"M4 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GRID_PATTERN(
        "grid-pattern",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M10 8v8\" />\n  <path d=\"M14 8v8\" />\n  <path d=\"M8 10h8\" />\n  <path d=\"M8 14h8\" />"),
    GRID_SCAN(
        "grid-scan",
        "<path d=\"M10 8v8\" />\n  <path d=\"M14 8v8\" />\n  <path d=\"M8 10h8\" />\n  <path d=\"M8 14h8\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    GRIP_HORIZONTAL(
        "grip-horizontal",
        "<path d=\"M4 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M4 15a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 15a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M18 15a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GRIP_VERTICAL(
        "grip-vertical",
        "<path d=\"M8 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M14 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M14 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M14 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    GYMNASTICS(
        "gymnastics",
        "<path d=\"M7 7a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M13 21l1 -9l7 -6\" />\n  <path d=\"M3 11h6l5 1\" />\n  <path d=\"M11.5 8.5l4.5 -3.5\" />"),
    HANGER_2(
        "hanger-2",
        "<path d=\"M12 9l-7.971 4.428a2 2 0 0 0 -1.029 1.749v.823a2 2 0 0 0 2 2h1\" />\n  <path d=\"M18 18h1a2 2 0 0 0 2 -2v-.823a2 2 0 0 0 -1.029 -1.749l-7.971 -4.428c-1.457 -.81 -1.993 -2.333 -2 -4a2 2 0 1 1 4 0\" />\n  <path d=\"M6 18a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -1\" />"),
    HAZE_MOON(
        "haze-moon",
        "<path d=\"M3 16h18\" />\n  <path d=\"M3 20h18\" />\n  <path d=\"M8.296 16c-2.268 -1.4 -3.598 -4.087 -3.237 -6.916c.443 -3.48 3.308 -6.083 6.698 -6.084v.006h.296c-1.991 1.916 -2.377 5.03 -.918 7.405c1.459 2.374 4.346 3.33 6.865 2.275a6.888 6.888 0 0 1 -2.777 3.314\" />"),
    HEALTH_RECOGNITION(
        "health-recognition",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M8.603 9.61a2.04 2.04 0 0 1 2.912 0l.485 .39l.5 -.396a2.035 2.035 0 0 1 2.897 .007a2.104 2.104 0 0 1 0 2.949l-3.397 3.44l-3.397 -3.44a2.104 2.104 0 0 1 0 -2.95\" />"),
    HELP(
        "help",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 17l0 .01\" />\n  <path d=\"M12 13.5a1.5 1.5 0 0 1 1 -1.5a2.6 2.6 0 1 0 -3 -4\" />"),
    HELP_CIRCLE(
        "help-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_HEXAGON(
        "help-hexagon",
        "<path d=\"M19.875 6.27c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_OCTAGON(
        "help-octagon",
        "<path d=\"M12.802 2.165l5.575 2.389c.48 .206 .863 .589 1.07 1.07l2.388 5.574c.22 .512 .22 1.092 0 1.604l-2.389 5.575c-.206 .48 -.589 .863 -1.07 1.07l-5.574 2.388c-.512 .22 -1.092 .22 -1.604 0l-5.575 -2.389a2.036 2.036 0 0 1 -1.07 -1.07l-2.388 -5.574a2.036 2.036 0 0 1 0 -1.604l2.389 -5.575c.206 -.48 .589 -.863 1.07 -1.07l5.574 -2.388a2.036 2.036 0 0 1 1.604 0\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_OFF(
        "help-off",
        "<path d=\"M5.641 5.631a9 9 0 1 0 12.719 12.738m1.68 -2.318a9 9 0 0 0 -12.074 -12.098\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M12 13.5a1.5 1.5 0 0 1 .394 -1.1m2.106 -1.9a2.6 2.6 0 0 0 -3.347 -3.361\" />\n  <path d=\"M3 3l18 18\" />"),
    HELP_SMALL(
        "help-small",
        "<path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_SQUARE(
        "help-square",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_SQUARE_ROUNDED(
        "help-square-rounded",
        "<path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HELP_TRIANGLE(
        "help-triangle",
        "<path d=\"M12 16v.01\" />\n  <path d=\"M10.363 3.591l-8.106 13.534a1.914 1.914 0 0 0 1.636 2.871h16.214a1.914 1.914 0 0 0 1.636 -2.87l-8.106 -13.536a1.914 1.914 0 0 0 -3.274 0\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HISTORY(
        "history",
        "<path d=\"M12 8l0 4l2 2\" />\n  <path d=\"M3.05 11a9 9 0 1 1 .5 4m-.5 5v-5h5\" />"),
    HISTORY_OFF(
        "history-off",
        "<path d=\"M3.05 11a8.975 8.975 0 0 1 2.54 -5.403m2.314 -1.697a9 9 0 0 1 12.113 12.112m-1.695 2.312a9 9 0 0 1 -14.772 -3.324m-.5 5v-5h5\" />\n  <path d=\"M3 3l18 18\" />"),
    HISTORY_TOGGLE(
        "history-toggle",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M12 8v4l3 3\" />"),
    HOURGLASS(
        "hourglass",
        "<path d=\"M6.5 7h11\" />\n  <path d=\"M6.5 17h11\" />\n  <path d=\"M6 20v-2a6 6 0 1 1 12 0v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1\" />\n  <path d=\"M6 4v2a6 6 0 1 0 12 0v-2a1 1 0 0 0 -1 -1h-10a1 1 0 0 0 -1 1\" />"),
    HOURGLASS_EMPTY(
        "hourglass-empty",
        "<path d=\"M6 20v-2a6 6 0 1 1 12 0v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1\" />\n  <path d=\"M6 4v2a6 6 0 1 0 12 0v-2a1 1 0 0 0 -1 -1h-10a1 1 0 0 0 -1 1\" />"),
    HOURGLASS_HIGH(
        "hourglass-high",
        "<path d=\"M6.5 7h11\" />\n  <path d=\"M6 20v-2a6 6 0 1 1 12 0v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1\" />\n  <path d=\"M6 4v2a6 6 0 1 0 12 0v-2a1 1 0 0 0 -1 -1h-10a1 1 0 0 0 -1 1\" />"),
    HOURGLASS_LOW(
        "hourglass-low",
        "<path d=\"M6.5 17h11\" />\n  <path d=\"M6 20v-2a6 6 0 1 1 12 0v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1\" />\n  <path d=\"M6 4v2a6 6 0 1 0 12 0v-2a1 1 0 0 0 -1 -1h-10a1 1 0 0 0 -1 1\" />"),
    HOURGLASS_OFF(
        "hourglass-off",
        "<path d=\"M18 18v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1v-2a6 6 0 0 1 6 -6\" />\n  <path d=\"M6 6a6 6 0 0 0 6 6m3.13 -.88a6 6 0 0 0 2.87 -5.12v-2a1 1 0 0 0 -1 -1h-10\" />\n  <path d=\"M3 3l18 18\" />"),
    HOURS_12(
        "hours-12",
        "<path d=\"M20 11a8.1 8.1 0 0 0 -15.5 -2m-.5 -4v4h4\" />\n  <path d=\"M4 13c.468 3.6 3.384 6.546 7 7\" />\n  <path d=\"M18 15h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M15 21v-6\" />"),
    HOURS_24(
        "hours-24",
        "<path d=\"M4 13c.325 2.532 1.881 4.781 4 6\" />\n  <path d=\"M20 11a8.1 8.1 0 0 0 -15.5 -2\" />\n  <path d=\"M4 5v4h4\" />\n  <path d=\"M12 15h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M18 15v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M21 15v6\" />"),
    ID(
        "id",
        "<path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3l0 -10\" />\n  <path d=\"M7 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 8l2 0\" />\n  <path d=\"M15 12l2 0\" />\n  <path d=\"M7 16l10 0\" />"),
    ID_BADGE(
        "id-badge",
        "<path d=\"M5 6a3 3 0 0 1 3 -3h8a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3l0 -12\" />\n  <path d=\"M10 13a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 6h4\" />\n  <path d=\"M9 18h6\" />"),
    ID_BADGE_2(
        "id-badge-2",
        "<path d=\"M7 12h3v4h-3l0 -4\" />\n  <path d=\"M10 6h-6a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h16a1 1 0 0 0 1 -1v-12a1 1 0 0 0 -1 -1h-6\" />\n  <path d=\"M10 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M14 16h2\" />\n  <path d=\"M14 12h4\" />"),
    ID_BADGE_OFF(
        "id-badge-off",
        "<path d=\"M7.141 3.125a3 3 0 0 1 .859 -.125h8a3 3 0 0 1 3 3v9m-.13 3.874a3 3 0 0 1 -2.87 2.126h-8a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 .128 -.869\" />\n  <path d=\"M11.179 11.176a2 2 0 1 0 2.635 2.667\" />\n  <path d=\"M10 6h4\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M3 3l18 18\" />"),
    ID_OFF(
        "id-off",
        "<path d=\"M8 4h10a3 3 0 0 1 3 3v10m-1.437 2.561c-.455 .279 -.99 .439 -1.563 .439h-12a3 3 0 0 1 -3 -3v-10c0 -1.083 .573 -2.031 1.433 -2.559\" />\n  <path d=\"M8.175 8.178a2 2 0 1 0 2.646 2.65\" />\n  <path d=\"M15 8h2\" />\n  <path d=\"M16 12h1\" />\n  <path d=\"M7 16h9\" />\n  <path d=\"M3 3l18 18\" />"),
    INBOX(
        "inbox",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 13h3l3 3h4l3 -3h3\" />"),
    INBOX_OFF(
        "inbox-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.593 3.422a2 2 0 0 1 -1.407 .578h-12a2 2 0 0 1 -2 -2v-12c0 -.554 .225 -1.056 .59 -1.418\" />\n  <path d=\"M4 13h3l3 3h4l.987 -.987m2.013 -2.013h3\" />\n  <path d=\"M3 3l18 18\" />"),
    INFO_CIRCLE(
        "info-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INFO_HEXAGON(
        "info-hexagon",
        "<path d=\"M19.875 6.27c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />\n  <path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INFO_OCTAGON(
        "info-octagon",
        "<path d=\"M12.802 2.165l5.575 2.389c.48 .206 .863 .589 1.07 1.07l2.388 5.574c.22 .512 .22 1.092 0 1.604l-2.389 5.575c-.206 .48 -.589 .863 -1.07 1.07l-5.574 2.388c-.512 .22 -1.092 .22 -1.604 0l-5.575 -2.389a2.036 2.036 0 0 1 -1.07 -1.07l-2.388 -5.574a2.036 2.036 0 0 1 0 -1.604l2.389 -5.575c.206 -.48 .589 -.863 1.07 -1.07l5.574 -2.388a2.036 2.036 0 0 1 1.604 0\" />\n  <path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INFO_SMALL("info-small", "<path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INFO_SQUARE(
        "info-square",
        "<path d=\"M12 9h.01\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INFO_SQUARE_ROUNDED(
        "info-square-rounded",
        "<path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />"),
    INFO_TRIANGLE(
        "info-triangle",
        "<path d=\"M10.363 3.591l-8.106 13.534a1.914 1.914 0 0 0 1.636 2.871h16.214a1.914 1.914 0 0 0 1.636 -2.87l-8.106 -13.536a1.914 1.914 0 0 0 -3.274 0\" />\n  <path d=\"M12 9h.01\" />\n  <path d=\"M11 12h1v4h1\" />"),
    INPUT_AI(
        "input-ai",
        "<path d=\"M20 11v-2a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h4\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    INPUT_CHECK(
        "input-check",
        "<path d=\"M20 13v-4a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h6\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    INPUT_SPARK(
        "input-spark",
        "<path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />\n  <path d=\"M20 11.5v-2.5a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h7\" />"),
    INPUT_X(
        "input-x",
        "<path d=\"M20 13v-4a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h7\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    JETPACK(
        "jetpack",
        "<path d=\"M10 6a3 3 0 1 0 -6 0v7h6v-7\" />\n  <path d=\"M14 13h6v-7a3 3 0 0 0 -6 0v7\" />\n  <path d=\"M5 16c0 2.333 .667 4 2 5c1.333 -1 2 -2.667 2 -5\" />\n  <path d=\"M15 16c0 2.333 .667 4 2 5c1.333 -1 2 -2.667 2 -5\" />\n  <path d=\"M10 8h4\" />\n  <path d=\"M10 11h4\" />"),
    JOIN_BEVEL(
        "join-bevel",
        "<path d=\"M6 4h3a2 2 0 0 1 2 2v6a1 1 0 0 0 1 1h6a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-6.586a1 1 0 0 1 -.707 -.293l-6.414 -6.414a1 1 0 0 1 -.293 -.707v-6.586a2 2 0 0 1 2 -2\" />"),
    JOIN_ROUND(
        "join-round",
        "<path d=\"M6 4h3a2 2 0 0 1 2 2v6a1 1 0 0 0 1 1h6a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-6a8 8 0 0 1 -8 -8v-6a2 2 0 0 1 2 -2\" />"),
    JOIN_STRAIGHT(
        "join-straight",
        "<path d=\"M6 4h3a2 2 0 0 1 2 2v6a1 1 0 0 0 1 1h6a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2\" />"),
    LABEL(
        "label",
        "<path d=\"M16.52 7h-10.52a2 2 0 0 0 -2 2v6a2 2 0 0 0 2 2h10.52a1 1 0 0 0 .78 -.375l3.7 -4.625l-3.7 -4.625a1 1 0 0 0 -.78 -.375\" />"),
    LABEL_IMPORTANT(
        "label-important",
        "<path d=\"M16.52 7h-12.52l4 5l-4 5h12.52a1 1 0 0 0 .78 -.375l3.7 -4.625l-3.7 -4.625a1 1 0 0 0 -.78 -.375\" />"),
    LABEL_OFF(
        "label-off",
        "<path d=\"M7 7h-1a2 2 0 0 0 -2 2v6a2 2 0 0 0 2 2h10.52a1 1 0 0 0 .394 -.081m1.86 -2.137l2.226 -2.782l-3.7 -4.625a1 1 0 0 0 -.78 -.375h-5.52\" />\n  <path d=\"M3 3l18 18\" />"),
    LADDER(
        "ladder",
        "<path d=\"M8 3v18\" />\n  <path d=\"M16 3v18\" />\n  <path d=\"M8 14h8\" />\n  <path d=\"M8 10h8\" />\n  <path d=\"M8 6h8\" />\n  <path d=\"M8 18h8\" />"),
    LADDER_OFF(
        "ladder-off",
        "<path d=\"M8 3v1m0 4v13\" />\n  <path d=\"M16 3v9m0 4v5\" />\n  <path d=\"M8 14h6\" />\n  <path d=\"M8 10h2m4 0h2\" />\n  <path d=\"M10 6h6\" />\n  <path d=\"M8 18h8\" />\n  <path d=\"M3 3l18 18\" />"),
    LANE("lane", "<path d=\"M4 6v13\" />\n  <path d=\"M20 6v13\" />"),
    LAYOUT_BOTTOMBAR_INACTIVE(
        "layout-bottombar-inactive",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M4 15h1\" />\n  <path d=\"M19 15h1\" />\n  <path d=\"M9 15h1\" />\n  <path d=\"M14 15h1\" />"),
    LAYOUT_NAVBAR_INACTIVE(
        "layout-navbar-inactive",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M4 9h1\" />\n  <path d=\"M19 9h1\" />\n  <path d=\"M9 9h1\" />\n  <path d=\"M14 9h1\" />"),
    LAYOUT_SIDEBAR_INACTIVE(
        "layout-sidebar-inactive",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M9 4v1\" />\n  <path d=\"M9 9v1\" />\n  <path d=\"M9 14v1\" />\n  <path d=\"M9 19v1\" />"),
    LAYOUT_SIDEBAR_RIGHT_INACTIVE(
        "layout-sidebar-right-inactive",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M15 4v1\" />\n  <path d=\"M15 9v1\" />\n  <path d=\"M15 14v1\" />\n  <path d=\"M15 19v1\" />"),
    LEGO(
        "lego",
        "<path d=\"M9.5 11l.01 0\" />\n  <path d=\"M14.5 11l.01 0\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M7 5h1v-2h8v2h1a3 3 0 0 1 3 3v9a3 3 0 0 1 -3 3v1h-10v-1a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3\" />"),
    LEGO_OFF(
        "lego-off",
        "<path d=\"M9.5 11h.01\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M8 4v-1h8v2h1a3 3 0 0 1 3 3v8m-.884 3.127a2.99 2.99 0 0 1 -2.116 .873v1h-10v-1a3 3 0 0 1 -3 -3v-9c0 -1.083 .574 -2.032 1.435 -2.56\" />\n  <path d=\"M3 3l18 18\" />"),
    LIBRARY(
        "library",
        "<path d=\"M7 5.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 7.26a2.005 2.005 0 0 0 -1.012 1.737v10c0 1.1 .9 2 2 2h10c.75 0 1.158 -.385 1.5 -1\" />\n  <path d=\"M11 7h5\" />\n  <path d=\"M11 10h6\" />\n  <path d=\"M11 13h3\" />"),
    LIBRARY_MINUS(
        "library-minus",
        "<path d=\"M7 5.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 7.26a2.005 2.005 0 0 0 -1.012 1.737v10c0 1.1 .9 2 2 2h10c.75 0 1.158 -.385 1.5 -1\" />\n  <path d=\"M11 10h6\" />"),
    LIBRARY_PHOTO(
        "library-photo",
        "<path d=\"M7 5.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 7.26a2.005 2.005 0 0 0 -1.012 1.737v10c0 1.1 .9 2 2 2h10c.75 0 1.158 -.385 1.5 -1\" />\n  <path d=\"M17 7h.01\" />\n  <path d=\"M7 13l3.644 -3.644a1.21 1.21 0 0 1 1.712 0l3.644 3.644\" />\n  <path d=\"M15 12l1.644 -1.644a1.21 1.21 0 0 1 1.712 0l2.644 2.644\" />"),
    LIBRARY_PLUS(
        "library-plus",
        "<path d=\"M7 5.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 7.26a2.005 2.005 0 0 0 -1.012 1.737v10c0 1.1 .9 2 2 2h10c.75 0 1.158 -.385 1.5 -1\" />\n  <path d=\"M11 10h6\" />\n  <path d=\"M14 7v6\" />"),
    LIFEBUOY(
        "lifebuoy",
        "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M15 15l3.35 3.35\" />\n  <path d=\"M9 15l-3.35 3.35\" />\n  <path d=\"M5.65 5.65l3.35 3.35\" />\n  <path d=\"M18.35 5.65l-3.35 3.35\" />"),
    LIFEBUOY_OFF(
        "lifebuoy-off",
        "<path d=\"M9.171 9.172a4 4 0 0 0 5.65 5.663m1.179 -2.835a4 4 0 0 0 -4 -4\" />\n  <path d=\"M5.64 5.632a9 9 0 1 0 12.73 12.725m1.667 -2.301a9 9 0 0 0 -12.077 -12.1\" />\n  <path d=\"M15 15l3.35 3.35\" />\n  <path d=\"M9 15l-3.35 3.35\" />\n  <path d=\"M5.65 5.65l3.35 3.35\" />\n  <path d=\"M18.35 5.65l-3.35 3.35\" />\n  <path d=\"M3 3l18 18\" />"),
    LIGHTER(
        "lighter",
        "<path d=\"M10 3v16a2 2 0 0 0 2 2h5a2 2 0 0 0 2 -2v-7h-12a2 2 0 0 1 -2 -2v-5a2 2 0 0 1 2 -2h3\" />\n  <path d=\"M16 4l1.465 1.638a2 2 0 1 1 -3.015 .099l1.55 -1.737\" />"),
    LINE_SCAN(
        "line-scan",
        "<path d=\"M7 12h10\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    LIST_LETTERS(
        "list-letters",
        "<path d=\"M11 6h9\" />\n  <path d=\"M11 12h9\" />\n  <path d=\"M11 18h9\" />\n  <path d=\"M4 10v-4.5a1.5 1.5 0 0 1 3 0v4.5\" />\n  <path d=\"M4 8h3\" />\n  <path d=\"M4 20h1.5a1.5 1.5 0 0 0 0 -3h-1.5h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />"),
    LIST_TREE(
        "list-tree",
        "<path d=\"M9 6h11\" />\n  <path d=\"M12 12h8\" />\n  <path d=\"M15 18h5\" />\n  <path d=\"M5 6v.01\" />\n  <path d=\"M8 12v.01\" />\n  <path d=\"M11 18v.01\" />"),
    LOADER(
        "loader",
        "<path d=\"M12 6l0 -3\" />\n  <path d=\"M16.25 7.75l2.15 -2.15\" />\n  <path d=\"M18 12l3 0\" />\n  <path d=\"M16.25 16.25l2.15 2.15\" />\n  <path d=\"M12 18l0 3\" />\n  <path d=\"M7.75 16.25l-2.15 2.15\" />\n  <path d=\"M6 12l-3 0\" />\n  <path d=\"M7.75 7.75l-2.15 -2.15\" />"),
    LOADER_2("loader-2", "<path d=\"M12 3a9 9 0 1 0 9 9\" />"),
    LOADER_3(
        "loader-3",
        "<path d=\"M3 12a9 9 0 0 0 9 9a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9\" />\n  <path d=\"M17 12a5 5 0 1 0 -5 5\" />"),
    LOADER_4(
        "loader-4",
        "<path d=\"M12 21v-3m6.36 .36l-2.12 -2.12m4.76 -4.24h-3m.36 -6.36l-2.12 2.12m-4.24 -4.76v3m-6.36 -.36l2.12 2.12m-3.76 4.24h2m1 4.95l.71 -.71\" />"),
    LOADER_QUARTER(
        "loader-quarter",
        "<path d=\"M12 6l0 -3\" />\n  <path d=\"M6 12l-3 0\" />\n  <path d=\"M7.75 7.75l-2.15 -2.15\" />"),
    LOCATION_DISCOUNT(
        "location-discount",
        "<path d=\"M12.797 19.595l-2.797 -5.595l-7 -3.5a.55 .55 0 0 1 0 -1l18 -6.5l-3.548 9.826\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    LOCK(
        "lock",
        "<path d=\"M5 13a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-6\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />"),
    LOCK_ACCESS(
        "lock-access",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M8 12a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M10 11v-2a2 2 0 1 1 4 0v2\" />"),
    LOCK_ACCESS_OFF(
        "lock-access-off",
        "<path d=\"M4 8v-2c0 -.554 .225 -1.055 .588 -1.417\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2c.55 0 1.05 -.222 1.41 -.582\" />\n  <path d=\"M15 11a1 1 0 0 1 1 1m-.29 3.704a1 1 0 0 1 -.71 .296h-6a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1h2\" />\n  <path d=\"M10 11v-1m1.182 -2.826a2 2 0 0 1 2.818 1.826v1\" />\n  <path d=\"M3 3l18 18\" />"),
    LOCK_BITCOIN(
        "lock-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />"),
    LOCK_BOLT(
        "lock-bolt",
        "<path d=\"M13.5 21h-6.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.74 1.012\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    LOCK_CANCEL(
        "lock-cancel",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.749 1.028\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    LOCK_CHECK(
        "lock-check",
        "<path d=\"M11.5 21h-4.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    LOCK_CODE(
        "lock-code",
        "<path d=\"M11.5 21h-4.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    LOCK_COG(
        "lock-cog",
        "<path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10c.564 0 1.074 .234 1.437 .61\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    LOCK_DOLLAR(
        "lock-dollar",
        "<path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    LOCK_DOWN(
        "lock-down",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.74 1.015\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    LOCK_EXCLAMATION(
        "lock-exclamation",
        "<path d=\"M15 21h-8a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.734 1.002\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    LOCK_HEART(
        "lock-heart",
        "<path d=\"M11.5 21h-4.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10c.38 0 .734 .106 1.037 .29\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    LOCK_MINUS(
        "lock-minus",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v2\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M16 19h6\" />"),
    LOCK_OFF(
        "lock-off",
        "<path d=\"M15 11h2a2 2 0 0 1 2 2v2m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h4\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-3m.719 -3.289a4 4 0 0 1 7.281 2.289v4\" />\n  <path d=\"M3 3l18 18\" />"),
    LOCK_OPEN(
        "lock-open",
        "<path d=\"M5 13a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -6\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 11v-5a4 4 0 0 1 8 0\" />"),
    LOCK_OPEN_2(
        "lock-open-2",
        "<path d=\"M3 13a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -6\" />\n  <path d=\"M9 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M13 11v-4a4 4 0 1 1 8 0v4\" />"),
    LOCK_OPEN_OFF(
        "lock-open-off",
        "<path d=\"M15 11h2a2 2 0 0 1 2 2v2m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h4\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 11v-3m.347 -3.631a4 4 0 0 1 7.653 1.631\" />\n  <path d=\"M3 3l18 18\" />"),
    LOCK_PASSWORD(
        "lock-password",
        "<path d=\"M5 13a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -6\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M15 16h.01\" />\n  <path d=\"M12.01 16h.01\" />\n  <path d=\"M9.02 16h.01\" />"),
    LOCK_PAUSE(
        "lock-pause",
        "<path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    LOCK_PIN(
        "lock-pin",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10c.24 0 .47 .042 .683 .12\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    LOCK_PLUS(
        "lock-plus",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.74 1.012\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    LOCK_QUESTION(
        "lock-question",
        "<path d=\"M15 21h-8a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10c.265 0 .518 .052 .75 .145\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    LOCK_SEARCH(
        "lock-search",
        "<path d=\"M11.5 21h-4.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    LOCK_SHARE(
        "lock-share",
        "<path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    LOCK_SQUARE(
        "lock-square",
        "<path d=\"M8 12a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M10 11v-2a2 2 0 1 1 4 0v2\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />"),
    LOCK_SQUARE_ROUNDED(
        "lock-square-rounded",
        "<path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />\n  <path d=\"M8 12a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M10 11v-2a2 2 0 1 1 4 0v2\" />"),
    LOCK_STAR(
        "lock-star",
        "<path d=\"M11 21h-4a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h9\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    LOCK_UP(
        "lock-up",
        "<path d=\"M12.5 21h-5.5a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 1.739 1.01\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    LOCK_X(
        "lock-x",
        "<path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    LOGOUT(
        "logout",
        "<path d=\"M14 8v-2a2 2 0 0 0 -2 -2h-7a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M9 12h12l-3 -3\" />\n  <path d=\"M18 15l3 -3\" />"),
    LOGOUT_2(
        "logout-2",
        "<path d=\"M10 8v-2a2 2 0 0 1 2 -2h7a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M15 12h-12l3 -3\" />\n  <path d=\"M6 15l-3 -3\" />"),
    LUGGAGE(
        "luggage",
        "<path d=\"M6 8a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M9 6v-1a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M6 10h12\" />\n  <path d=\"M6 16h12\" />\n  <path d=\"M9 20v1\" />\n  <path d=\"M15 20v1\" />"),
    LUGGAGE_OFF(
        "luggage-off",
        "<path d=\"M10 6h6a2 2 0 0 1 2 2v6m0 4a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-10c0 -.546 .218 -1.04 .573 -1.4\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M6 10h4m4 0h4\" />\n  <path d=\"M6 16h10\" />\n  <path d=\"M9 20v1\" />\n  <path d=\"M15 20v1\" />\n  <path d=\"M3 3l18 18\" />"),
    MAN(
        "man",
        "<path d=\"M10 16v5\" />\n  <path d=\"M14 16v5\" />\n  <path d=\"M9 9h6l-1 7h-4l-1 -7\" />\n  <path d=\"M5 11c1.333 -1.333 2.667 -2 4 -2\" />\n  <path d=\"M19 11c-1.333 -1.333 -2.667 -2 -4 -2\" />\n  <path d=\"M10 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    MARQUEE(
        "marquee",
        "<path d=\"M4 6a2 2 0 0 1 2 -2m3 0h1.5m3 0h1.5m3 0a2 2 0 0 1 2 2m0 3v1.5m0 3v1.5m0 3a2 2 0 0 1 -2 2m-3 0h-1.5m-3 0h-1.5m-3 0a2 2 0 0 1 -2 -2m0 -3v-1.5m0 -3v-1.5m0 -3\" />"),
    MARQUEE_2(
        "marquee-2",
        "<path d=\"M4 6v-1a1 1 0 0 1 1 -1h1m5 0h2m5 0h1a1 1 0 0 1 1 1v1m0 5v2m0 5v1a1 1 0 0 1 -1 1h-1m-5 0h-2m-5 0h-1a1 1 0 0 1 -1 -1v-1m0 -5v-2\" />"),
    MARQUEE_OFF(
        "marquee-off",
        "<path d=\"M4 6c0 -.556 .227 -1.059 .593 -1.421\" />\n  <path d=\"M9 4h1.5\" />\n  <path d=\"M13.5 4h1.5\" />\n  <path d=\"M18 4a2 2 0 0 1 2 2\" />\n  <path d=\"M20 9v1.5\" />\n  <path d=\"M20 13.5v1.5\" />\n  <path d=\"M19.402 19.426a1.993 1.993 0 0 1 -1.402 .574\" />\n  <path d=\"M15 20h-1.5\" />\n  <path d=\"M10.5 20h-1.5\" />\n  <path d=\"M6 20a2 2 0 0 1 -2 -2\" />\n  <path d=\"M4 15v-1.5\" />\n  <path d=\"M4 10.5v-1.5\" />\n  <path d=\"M3 3l18 18\" />"),
    MATCHSTICK(
        "matchstick",
        "<path d=\"M3 21l14 -9\" />\n  <path d=\"M16 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M17 3l3.62 7.29a4.007 4.007 0 0 1 -.764 4.51a4 4 0 0 1 -6.493 -4.464l3.637 -7.336\" />"),
    MENU("menu", "<path d=\"M4 8l16 0\" />\n  <path d=\"M4 16l16 0\" />"),
    MENU_2(
        "menu-2",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M4 12l16 0\" />\n  <path d=\"M4 18l16 0\" />"),
    MENU_3(
        "menu-3",
        "<path d=\"M10 6h10\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M7 12h13\" />\n  <path d=\"M4 18h10\" />"),
    MENU_4(
        "menu-4",
        "<path d=\"M7 6h10\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M7 12h13\" />\n  <path d=\"M7 18h10\" />"),
    MENU_DEEP(
        "menu-deep",
        "<path d=\"M4 6h16\" />\n  <path d=\"M7 12h13\" />\n  <path d=\"M10 18h10\" />"),
    MENU_ORDER(
        "menu-order",
        "<path d=\"M4 10h16\" />\n  <path d=\"M4 14h16\" />\n  <path d=\"M9 18l3 3l3 -3\" />\n  <path d=\"M9 6l3 -3l3 3\" />"),
    METER_CUBE(
        "meter-cube",
        "<path d=\"M17 5h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />\n  <path d=\"M4 12v6\" />\n  <path d=\"M4 14a2 2 0 0 1 2 -2h.5a2.5 2.5 0 0 1 2.5 2.5v3.5\" />\n  <path d=\"M9 15.5v-1a2.5 2.5 0 1 1 5 0v3.5\" />"),
    METER_SQUARE(
        "meter-square",
        "<path d=\"M17 5h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M4 12v6\" />\n  <path d=\"M4 14a2 2 0 0 1 2 -2h.5a2.5 2.5 0 0 1 2.5 2.5v3.5\" />\n  <path d=\"M9 15.5v-1a2.5 2.5 0 1 1 5 0v3.5\" />"),
    METRONOME(
        "metronome",
        "<path d=\"M14.153 8.188l-.72 -3.236a2.493 2.493 0 0 0 -4.867 0l-3.025 13.614a2 2 0 0 0 1.952 2.434h7.014a2 2 0 0 0 1.952 -2.434l-.524 -2.357m-4.935 1.791l9 -13\" />\n  <path d=\"M19 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    MILITARY_AWARD(
        "military-award",
        "<path d=\"M8 13a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M8.5 10.5l-1 -2.5h-5.5l2.48 5.788a2 2 0 0 0 1.84 1.212h2.18\" />\n  <path d=\"M15.5 10.5l1 -2.5h5.5l-2.48 5.788a2 2 0 0 1 -1.84 1.212h-2.18\" />"),
    MILITARY_RANK(
        "military-rank",
        "<path d=\"M18 7v12a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-12l6 -4l6 4\" />\n  <path d=\"M10 13l2 -1l2 1\" />\n  <path d=\"M10 17l2 -1l2 1\" />\n  <path d=\"M10 9l2 -1l2 1\" />"),
    MINUS_VERTICAL("minus-vertical", "<path d=\"M12 5v14\" />"),
    MOBILEDATA(
        "mobiledata",
        "<path d=\"M16 12v-8\" />\n  <path d=\"M8 20v-8\" />\n  <path d=\"M13 7l3 -3l3 3\" />\n  <path d=\"M5 17l3 3l3 -3\" />"),
    MOBILEDATA_OFF(
        "mobiledata-off",
        "<path d=\"M16 12v-8\" />\n  <path d=\"M8 20v-8\" />\n  <path d=\"M13 7l3 -3l3 3\" />\n  <path d=\"M5 17l3 3l3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    MUSIC_DISCOUNT(
        "music-discount",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M16 21l5 -5\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M16 16v.01\" />"),
    NEW_SECTION(
        "new-section",
        "<path d=\"M9 12l6 0\" />\n  <path d=\"M12 9l0 6\" />\n  <path d=\"M4 6v-1a1 1 0 0 1 1 -1h1m5 0h2m5 0h1a1 1 0 0 1 1 1v1m0 5v2m0 5v1a1 1 0 0 1 -1 1h-1m-5 0h-2m-5 0h-1a1 1 0 0 1 -1 -1v-1m0 -5v-2m0 -5\" />"),
    NO_COPYRIGHT(
        "no-copyright",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14 9.75a3.016 3.016 0 0 0 -4.163 .173a2.993 2.993 0 0 0 0 4.154a3.016 3.016 0 0 0 4.163 .173\" />\n  <path d=\"M6 6l1.5 1.5\" />\n  <path d=\"M16.5 16.5l1.5 1.5\" />"),
    NO_CREATIVE_COMMONS(
        "no-creative-commons",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10.5 10.5c-.847 -.71 -2.132 -.658 -2.914 .116a1.928 1.928 0 0 0 0 2.768c.782 .774 2.067 .825 2.914 .116\" />\n  <path d=\"M16.5 10.5c-.847 -.71 -2.132 -.658 -2.914 .116a1.928 1.928 0 0 0 0 2.768c.782 .774 2.067 .825 2.914 .116\" />\n  <path d=\"M6 6l1.5 1.5\" />\n  <path d=\"M16.5 16.5l1.5 1.5\" />"),
    NO_DERIVATIVES(
        "no-derivatives",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M9 14h6\" />"),
    NOTIFICATION(
        "notification",
        "<path d=\"M10 6h-3a2 2 0 0 0 -2 2v9a2 2 0 0 0 2 2h9a2 2 0 0 0 2 -2v-3\" />\n  <path d=\"M14 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    NOTIFICATION_OFF(
        "notification-off",
        "<path d=\"M6.154 6.187a2 2 0 0 0 -1.154 1.813v9a2 2 0 0 0 2 2h9a2 2 0 0 0 1.811 -1.151\" />\n  <path d=\"M14 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 3l18 18\" />"),
    OBJECT_SCAN(
        "object-scan",
        "<path d=\"M8 10a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    OUTBOUND(
        "outbound",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 15l6 -6\" />\n  <path d=\"M11 9h4v4\" />"),
    OUTLET(
        "outlet",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M8.5 12a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M14.5 12a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />"),
    PASSWORD(
        "password",
        "<path d=\"M12 10v4\" />\n  <path d=\"M10 13l4 -2\" />\n  <path d=\"M10 11l4 2\" />\n  <path d=\"M5 10v4\" />\n  <path d=\"M3 13l4 -2\" />\n  <path d=\"M3 11l4 2\" />\n  <path d=\"M19 10v4\" />\n  <path d=\"M17 13l4 -2\" />\n  <path d=\"M17 11l4 2\" />"),
    PASSWORD_FINGERPRINT(
        "password-fingerprint",
        "<path d=\"M17 8c.788 1 1 2 1 3v1\" />\n  <path d=\"M9 11c0 -1.578 1.343 -3 3 -3s3 1.422 3 3v2\" />\n  <path d=\"M12 11v2\" />\n  <path d=\"M6 12v-1.397c-.006 -1.999 1.136 -3.849 2.993 -4.85a6.385 6.385 0 0 1 6.007 -.005\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M10 20l4 -2\" />\n  <path d=\"M10 18l4 2\" />\n  <path d=\"M5 17v4\" />\n  <path d=\"M3 20l4 -2\" />\n  <path d=\"M3 18l4 2\" />\n  <path d=\"M19 17v4\" />\n  <path d=\"M17 20l4 -2\" />\n  <path d=\"M17 18l4 2\" />"),
    PASSWORD_MOBILE_PHONE(
        "password-mobile-phone",
        "<path d=\"M12 17v4\" />\n  <path d=\"M10 20l4 -2\" />\n  <path d=\"M10 18l4 2\" />\n  <path d=\"M5 17v4\" />\n  <path d=\"M3 20l4 -2\" />\n  <path d=\"M3 18l4 2\" />\n  <path d=\"M19 17v4\" />\n  <path d=\"M17 20l4 -2\" />\n  <path d=\"M17 18l4 2\" />\n  <path d=\"M7 14v-8a2 2 0 0 1 2 -2h6a2 2 0 0 1 2 2v8\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M12 17v.01\" />"),
    PASSWORD_USER(
        "password-user",
        "<path d=\"M12 17v4\" />\n  <path d=\"M10 20l4 -2\" />\n  <path d=\"M10 18l4 2\" />\n  <path d=\"M5 17v4\" />\n  <path d=\"M3 20l4 -2\" />\n  <path d=\"M3 18l4 2\" />\n  <path d=\"M19 17v4\" />\n  <path d=\"M17 20l4 -2\" />\n  <path d=\"M17 18l4 2\" />\n  <path d=\"M9 6a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M7 14a2 2 0 0 1 2 -2h6a2 2 0 0 1 2 2\" />"),
    PAYWALL(
        "paywall",
        "<path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h10\" />\n  <path d=\"M11 16a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M8 11v-4a4 4 0 1 1 8 0v4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1\" />\n  <path d=\"M19 14v1\" />"),
    PERCENTAGE_0("percentage-0", "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_10(
        "percentage-10",
        "<path d=\"M12 3c1.92 0 3.7 .601 5.16 1.626l-5.16 7.374v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_100(
        "percentage-100",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" fill=\"currentColor\" />"),
    PERCENTAGE_20(
        "percentage-20",
        "<path d=\"M12 3a9 9 0 0 1 8.497 6.025l-8.497 2.975v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_25(
        "percentage-25",
        "<path d=\"M21 12a9 9 0 0 0 -9 -9m0 0v9h9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_30(
        "percentage-30",
        "<path d=\"M12 3a9 9 0 0 1 8.495 11.973l-8.495 -2.973v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_33(
        "percentage-33",
        "<path d=\"M12 3a9 9 0 0 1 7.794 13.5l-7.79 -4.497v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_40(
        "percentage-40",
        "<path d=\"M12 3a9 9 0 0 1 5.162 16.372l-5.162 -7.372v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_50(
        "percentage-50",
        "<path d=\"M12 21a9 9 0 0 0 0 -18m0 0v18\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_60(
        "percentage-60",
        "<path d=\"M12 3a9 9 0 1 1 -5.162 16.373l5.162 -7.373v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_66(
        "percentage-66",
        "<path d=\"M12 3a9 9 0 1 1 -7.795 13.498l7.795 -4.498v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_70(
        "percentage-70",
        "<path d=\"M12 3a9 9 0 1 1 -8.495 11.973l8.495 -2.973v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_75(
        "percentage-75",
        "<path d=\"M3 12a9 9 0 1 0 9 -9m0 0v9h-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_80(
        "percentage-80",
        "<path d=\"M12 3a9 9 0 1 1 -8.497 6.025l8.497 2.975v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PERCENTAGE_90(
        "percentage-90",
        "<path d=\"M12 3a9 9 0 1 1 -5.16 1.626l5.16 7.374v-9\" fill=\"currentColor\" stroke=\"none\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PHOTO_SCAN(
        "photo-scan",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M6 13l2.644 -2.644a1.21 1.21 0 0 1 1.712 0l3.644 3.644\" />\n  <path d=\"M13 13l1.644 -1.644a1.21 1.21 0 0 1 1.712 0l1.644 1.644\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    PILLOW(
        "pillow",
        "<path d=\"M6 9a9.34 9.34 0 0 1 0 6\" />\n  <path d=\"M21.699 16.607c.481 .934 .28 2.088 -.486 2.79c-.767 .703 -1.9 .77 -2.74 .165a48 48 0 0 1 -12.946 0a2.16 2.16 0 0 1 -2.74 -.165a2.345 2.345 0 0 1 -.486 -2.79a41.7 41.7 0 0 1 0 -9.163a2.346 2.346 0 0 1 .433 -2.856a2.16 2.16 0 0 1 2.793 -.145a48 48 0 0 1 12.946 0a2.16 2.16 0 0 1 2.793 .145c.78 .726 .961 1.918 .433 2.856a41.7 41.7 0 0 1 0 9.163\" />"),
    PIN_END(
        "pin-end",
        "<path d=\"M21 11v-5a1 1 0 0 0 -1 -1h-16a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M17 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 13v-4h4\" />\n  <path d=\"M14 13l-4 -4\" />"),
    PIN_INVOKE(
        "pin-invoke",
        "<path d=\"M21 13v5a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h9\" />\n  <path d=\"M17 7a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 11h4v4\" />\n  <path d=\"M10 15l4 -4\" />"),
    PLAYLIST_ADD(
        "playlist-add",
        "<path d=\"M19 8h-14\" />\n  <path d=\"M5 12h9\" />\n  <path d=\"M11 16h-6\" />\n  <path d=\"M15 16h6\" />\n  <path d=\"M18 13v6\" />"),
    POINT("point", "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />"),
    POINT_OFF(
        "point-off",
        "<path d=\"M9.15 9.194a4 4 0 0 0 5.697 5.617m1.153 -2.811a4 4 0 0 0 -4 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    POINTER(
        "pointer",
        "<path d=\"M7.904 17.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l4.907 4.907a1.067 1.067 0 0 0 1.509 0l1.047 -1.047a1.067 1.067 0 0 0 0 -1.509l-4.907 -4.907l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563\" />"),
    POINTER_2(
        "pointer-2",
        "<path d=\"M14.185 13.14l5.644 -2.202c1.625 -.634 1.538 -2.962 -.13 -3.473l-14.319 -4.382c-1.41 -.431 -2.73 .888 -2.298 2.298l4.382 14.318c.51 1.668 2.84 1.755 3.473 .13l2.202 -5.644a1.84 1.84 0 0 1 1.045 -1.045\" />"),
    POINTER_BOLT(
        "pointer-bolt",
        "<path d=\"M16.044 13.488l-1.266 -1.266l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.678 1.678\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    POINTER_CANCEL(
        "pointer-cancel",
        "<path d=\"M15.526 12.97l-.748 -.748l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.714 .714\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    POINTER_CHECK(
        "pointer-check",
        "<path d=\"M17.487 14.93l-2.709 -2.708l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.785 .785\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    POINTER_CODE(
        "pointer-code",
        "<path d=\"M15.76 13.203l-.982 -.981l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.67 .67\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    POINTER_COG(
        "pointer-cog",
        "<path d=\"M15.774 13.218l-.996 -.996l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.343 .343\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    POINTER_COLLABORATION(
        "pointer-collaboration",
        "<path d=\"M13.943 13.013l5.016 -1.957c1.445 -.563 1.367 -2.633 -.116 -3.087l-12.727 -3.895c-1.253 -.384 -2.426 .79 -2.042 2.042l3.895 12.727c.454 1.483 2.524 1.56 3.087 .116l1.957 -5.017c.166 -.426 .503 -.763 .93 -.929\" />\n  <path d=\"M20 15l-3.151 1.064a1.25 1.25 0 0 0 -.785 .785l-1.064 3.151\" />"),
    POINTER_COLLABORATION_2(
        "pointer-collaboration-2",
        "<path d=\"M10.987 13.943l1.957 5.016c.563 1.445 2.633 1.367 3.087 -.116l3.895 -12.727c.384 -1.253 -.79 -2.426 -2.042 -2.042l-12.727 3.895c-1.483 .454 -1.56 2.524 -.116 3.087l5.017 1.957c.426 .166 .763 .503 .929 .93\" />\n  <path d=\"M9 20l-1.064 -3.151a1.25 1.25 0 0 0 -.785 -.785l-3.151 -1.064\" />"),
    POINTER_DOLLAR(
        "pointer-dollar",
        "<path d=\"M14.778 12.222l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.787 .787\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    POINTER_DOWN(
        "pointer-down",
        "<path d=\"M15.992 13.436l-1.214 -1.214l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.171 1.171\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    POINTER_EXCLAMATION(
        "pointer-exclamation",
        "<path d=\"M15.97 13.414l-1.192 -1.192l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l2.778 2.778\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    POINTER_HEART(
        "pointer-heart",
        "<path d=\"M16.571 11.018l1.32 -.886a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    POINTER_MINUS(
        "pointer-minus",
        "<path d=\"M17.6 15.043l-2.822 -2.821l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.188 1.188\" />\n  <path d=\"M16 19h6\" />"),
    POINTER_OFF(
        "pointer-off",
        "<path d=\"M15.662 11.628l2.229 -1.496a1.2 1.2 0 0 0 -.309 -2.228l-8.013 -2.303m-5.569 -1.601l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l4.907 4.907a1.067 1.067 0 0 0 1.509 0l.524 -.524\" />\n  <path d=\"M3 3l18 18\" />"),
    POINTER_PAUSE(
        "pointer-pause",
        "<path d=\"M15.72 13.163l-.942 -.941l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.969 .969\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    POINTER_PIN(
        "pointer-pin",
        "<path d=\"M14.778 12.222l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.381 .381\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    POINTER_PLUS(
        "pointer-plus",
        "<path d=\"M15.941 13.385l-1.163 -1.163l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.23 1.23\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    POINTER_QUESTION(
        "pointer-question",
        "<path d=\"M15.062 12.506l-.284 -.284l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.278 1.278\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    POINTER_SEARCH(
        "pointer-search",
        "<path d=\"M14.778 12.222l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    POINTER_SHARE(
        "pointer-share",
        "<path d=\"M15.646 13.09l-.868 -.868l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.607 .607\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    POINTER_STAR(
        "pointer-star",
        "<path d=\"M17.891 10.132a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    POINTER_UP(
        "pointer-up",
        "<path d=\"M15.984 13.428l-1.206 -1.206l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l1.217 1.217\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    POINTER_X(
        "pointer-x",
        "<path d=\"M15.768 13.212l-.99 -.99l3.113 -2.09a1.2 1.2 0 0 0 -.309 -2.228l-13.582 -3.904l3.904 13.563a1.2 1.2 0 0 0 2.228 .308l2.09 -3.093l.908 .908\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    POO(
        "poo",
        "<path d=\"M10 12h.01\" />\n  <path d=\"M14 12h.01\" />\n  <path d=\"M10 16a3.5 3.5 0 0 0 4 0\" />\n  <path d=\"M11 4c2 0 3.5 1.5 3.5 4l.164 0a2.5 2.5 0 0 1 2.196 3.32a3 3 0 0 1 1.615 3.063a3 3 0 0 1 -1.299 5.607l-.176 0h-10a3 3 0 0 1 -1.474 -5.613a3 3 0 0 1 1.615 -3.062a2.5 2.5 0 0 1 2.195 -3.32l.164 0c1.5 0 2.5 -2 1.5 -4l0 .005\" />"),
    PRAY(
        "pray",
        "<path d=\"M11 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 20h8l-4 -4v-7l4 3l2 -2\" />"),
    PREMIUM_RIGHTS(
        "premium-rights",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M13.867 9.75c-.246 -.48 -.708 -.769 -1.2 -.75h-1.334c-.736 0 -1.333 .67 -1.333 1.5c0 .827 .597 1.499 1.333 1.499h1.334c.736 0 1.333 .671 1.333 1.5c0 .828 -.597 1.499 -1.333 1.499h-1.334c-.492 .019 -.954 -.27 -1.2 -.75\" />\n  <path d=\"M12 7v2\" />\n  <path d=\"M12 15v2\" />"),
    PRISM_LIGHT(
        "prism-light",
        "<path d=\"M4.731 19h11.539a1 1 0 0 0 .866 -1.5l-5.769 -10a1 1 0 0 0 -1.732 0l-5.769 10a1 1 0 0 0 .865 1.5\" />\n  <path d=\"M2 13h4.45\" />\n  <path d=\"M18 5l-4.5 6\" />\n  <path d=\"M22 9l-7.75 3.25\" />\n  <path d=\"M22 15l-7 -1.5\" />"),
    PROGRESS(
        "progress",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />"),
    PROGRESS_ALERT(
        "progress-alert",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16v.01\" />"),
    PROGRESS_BOLT(
        "progress-bolt",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M12 9l-2 3h4l-2 3\" />"),
    PROGRESS_CHECK(
        "progress-check",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M9 12l2 2l4 -4\" />"),
    PROGRESS_DOWN(
        "progress-down",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M15 12l-3 3l-3 -3\" />"),
    PROGRESS_HELP(
        "progress-help",
        "<path d=\"M12 16v.01\" />\n  <path d=\"M12 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />\n  <path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />"),
    PROGRESS_X(
        "progress-x",
        "<path d=\"M10 20.777a8.942 8.942 0 0 1 -2.48 -.969\" />\n  <path d=\"M14 3.223a9.003 9.003 0 0 1 0 17.554\" />\n  <path d=\"M4.579 17.093a8.961 8.961 0 0 1 -1.227 -2.592\" />\n  <path d=\"M3.124 10.5c.16 -.95 .468 -1.85 .9 -2.675l.169 -.305\" />\n  <path d=\"M6.907 4.579a8.954 8.954 0 0 1 3.093 -1.356\" />\n  <path d=\"M14 14l-4 -4\" />\n  <path d=\"M10 14l4 -4\" />"),
    PROPELLER(
        "propeller",
        "<path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14.167 10.5c.722 -1.538 1.156 -3.043 1.303 -4.514c.22 -1.63 -.762 -2.986 -3.47 -2.986s-3.69 1.357 -3.47 2.986c.147 1.471 .581 2.976 1.303 4.514\" />\n  <path d=\"M13.169 16.751c.97 1.395 2.057 2.523 3.257 3.386c1.3 1 2.967 .833 4.321 -1.512c1.354 -2.345 .67 -3.874 -.85 -4.498c-1.348 -.608 -2.868 -.985 -4.562 -1.128\" />\n  <path d=\"M8.664 13c-1.693 .143 -3.213 .52 -4.56 1.128c-1.522 .623 -2.206 2.153 -.852 4.498s3.02 2.517 4.321 1.512c1.2 -.863 2.287 -1.991 3.258 -3.386\" />"),
    PROPELLER_OFF(
        "propeller-off",
        "<path d=\"M10.448 10.432a3 3 0 1 0 4.106 4.143\" />\n  <path d=\"M14.272 10.272c.66 -1.459 1.058 -2.888 1.198 -4.286c.22 -1.63 -.762 -2.986 -3.47 -2.986c-1.94 0 -3 .696 -3.355 1.69m.697 4.653c.145 .384 .309 .77 .491 1.157\" />\n  <path d=\"M13.169 16.751c.97 1.395 2.057 2.523 3.257 3.386c1.02 .789 2.265 .853 3.408 -.288m1.479 -2.493c.492 -1.634 -.19 -2.726 -1.416 -3.229c-.82 -.37 -1.703 -.654 -2.65 -.852\" />\n  <path d=\"M8.664 13c-1.693 .143 -3.213 .52 -4.56 1.128c-1.522 .623 -2.206 2.153 -.852 4.498s3.02 2.517 4.321 1.512c1.2 -.863 2.287 -1.991 3.258 -3.386\" />\n  <path d=\"M3 3l18 18\" />"),
    PROTOCOL(
        "protocol",
        "<path d=\"M15 6l-7 12\" />\n  <path d=\"M20 6l-7 12\" />\n  <path d=\"M5 14v.015\" />\n  <path d=\"M5 10.015v.015\" />"),
    QUESTION_MARK(
        "question-mark",
        "<path d=\"M8 8a3.5 3 0 0 1 3.5 -3h1a3.5 3 0 0 1 3.5 3a3 3 0 0 1 -2 3a3 4 0 0 0 -2 4\" />\n  <path d=\"M12 19l0 .01\" />"),
    RECHARGING(
        "recharging",
        "<path d=\"M7.038 4.5a9 9 0 0 0 -2.495 2.47\" />\n  <path d=\"M3.186 10.209a9 9 0 0 0 0 3.508\" />\n  <path d=\"M4.5 16.962a9 9 0 0 0 2.47 2.495\" />\n  <path d=\"M10.209 20.814a9 9 0 0 0 3.5 0\" />\n  <path d=\"M16.962 19.5a9 9 0 0 0 2.495 -2.47\" />\n  <path d=\"M20.814 13.791a9 9 0 0 0 0 -3.508\" />\n  <path d=\"M19.5 7.038a9 9 0 0 0 -2.47 -2.495\" />\n  <path d=\"M13.791 3.186a9 9 0 0 0 -3.508 -.02\" />\n  <path d=\"M12 8l-2 4h4l-2 4\" />\n  <path d=\"M12 21a9 9 0 0 0 0 -18\" />"),
    RECORD_MAIL(
        "record-mail",
        "<path d=\"M4 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M7 15l10 0\" />"),
    RECORD_MAIL_OFF(
        "record-mail-off",
        "<path d=\"M4 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M18.569 14.557a3 3 0 1 0 -4.113 -4.149\" />\n  <path d=\"M7 15h8\" />\n  <path d=\"M3 3l18 18\" />"),
    REDUCE_MOTION(
        "reduce-motion",
        "<path d=\"M8 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M5.5 5.941v.007\" />\n  <path d=\"M2.941 8.498v.008\" />\n  <path d=\"M2 11.996v.008\" />\n  <path d=\"M2.941 15.494v.008\" />\n  <path d=\"M5.5 18.052v.007\" />\n  <path d=\"M9 18.992v.008\" />\n  <path d=\"M12.5 18.052v.007\" />\n  <path d=\"M15.059 15.494v.008\" />\n  <path d=\"M16 11.996v.008\" />\n  <path d=\"M15.059 8.498v.008\" />\n  <path d=\"M12.5 5.941v.007\" />\n  <path d=\"M9 5v.008\" />"),
    REORDER(
        "reorder",
        "<path d=\"M3 16a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M10 16a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 16a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M5 11v-3a3 3 0 0 1 3 -3h8a3 3 0 0 1 3 3v3\" />\n  <path d=\"M16.5 8.5l2.5 2.5l2.5 -2.5\" />"),
    REPLACE(
        "replace",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M15 16a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M21 11v-3a2 2 0 0 0 -2 -2h-6l3 3m0 -6l-3 3\" />\n  <path d=\"M3 13v3a2 2 0 0 0 2 2h6l-3 -3m0 6l3 -3\" />"),
    REPLACE_OFF(
        "replace-off",
        "<path d=\"M7 3h1a1 1 0 0 1 1 1v1m-.303 3.717a1 1 0 0 1 -.697 .283h-4a1 1 0 0 1 -1 -1v-4c0 -.28 .115 -.532 .3 -.714\" />\n  <path d=\"M19 15h1a1 1 0 0 1 1 1v1m-.303 3.717a1 1 0 0 1 -.697 .283h-4a1 1 0 0 1 -1 -1v-4c0 -.28 .115 -.532 .3 -.714\" />\n  <path d=\"M21 11v-3a2 2 0 0 0 -2 -2h-6l3 3m0 -6l-3 3\" />\n  <path d=\"M3 13v3a2 2 0 0 0 2 2h6l-3 -3m0 6l3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    REPLACE_USER(
        "replace-user",
        "<path d=\"M21 11v-3c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586h-6m0 0l3 3m-3 -3l3 -3\" />\n  <path d=\"M3 13.013v3c0 .53 .211 1.039 .586 1.414c.375 .375 .884 .586 1.414 .586h6m0 0l-3 -3m3 3l-3 3\" />\n  <path d=\"M16 16.502c0 .53 .211 1.039 .586 1.414c.375 .375 .884 .586 1.414 .586c.53 0 1.039 -.211 1.414 -.586c.375 -.375 .586 -.884 .586 -1.414c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586c-.53 0 -1.039 .211 -1.414 .586c-.375 .375 -.586 .884 -.586 1.414\" />\n  <path d=\"M4 4.502c0 .53 .211 1.039 .586 1.414c.375 .375 .884 .586 1.414 .586c.53 0 1.039 -.211 1.414 -.586c.375 -.375 .586 -.884 .586 -1.414c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586c-.53 0 -1.039 .211 -1.414 .586c-.375 .375 -.586 .884 -.586 1.414\" />\n  <path d=\"M21 21.499c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586h-2c-.53 0 -1.039 .211 -1.414 .586c-.375 .375 -.586 .884 -.586 1.414\" />\n  <path d=\"M9 9.499c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586h-2c-.53 0 -1.039 .211 -1.414 .586c-.375 .375 -.586 .884 -.586 1.414\" />"),
    RESERVED_LINE(
        "reserved-line",
        "<path d=\"M9 20h6\" />\n  <path d=\"M12 14v6\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -6\" />\n  <path d=\"M9 9h6\" />"),
    RESTORE(
        "restore",
        "<path d=\"M3.06 13a9 9 0 1 0 .49 -4.087\" />\n  <path d=\"M3 4.001v5h5\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    ROBOT_FACE(
        "robot-face",
        "<path d=\"M6 5h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2\" />\n  <path d=\"M9 16c1 .667 2 1 3 1s2 -.333 3 -1\" />\n  <path d=\"M9 7l-1 -4\" />\n  <path d=\"M15 7l1 -4\" />\n  <path d=\"M9 12v-1\" />\n  <path d=\"M15 12v-1\" />"),
    ROBOT_OFF(
        "robot-off",
        "<path d=\"M8 4h8a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2m-4 0h-4a2 2 0 0 1 -2 -2v-4\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M9 12v9\" />\n  <path d=\"M15 15v6\" />\n  <path d=\"M5 16l4 -2\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M14 8v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    ROTATE_3D(
        "rotate-3d",
        "<path d=\"M12 3a7 7 0 0 1 7 7v4l-3 -3\" />\n  <path d=\"M22 11l-3 3\" />\n  <path d=\"M8 15.5l-5 -3l5 -3l5 3v5.5l-5 3l0 -5.5\" />\n  <path d=\"M3 12.5v5.5l5 3\" />\n  <path d=\"M8 15.545l5 -3.03\" />"),
    ROUTE_SCAN(
        "route-scan",
        "<path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M7 12v-3h3\" />\n  <path d=\"M14 9h3v3\" />\n  <path d=\"M7 9l4.414 4.414a2 2 0 0 1 .586 1.414v2.172\" />\n  <path d=\"M17 9l-4.414 4.414a2 2 0 0 0 -.586 1.414v2.172\" />"),
    RV_TRUCK(
        "rv-truck",
        "<path d=\"M5 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M9 17h6\" />\n  <path d=\"M19 17h1a1 1 0 0 0 1 -1v-4.528a2 2 0 0 0 -.211 -.894l-.96 -1.92a3 3 0 0 0 -2.683 -1.658h-11.146a3 3 0 0 0 -3 3v6a1 1 0 0 0 1 1h1\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M15 12v-5\" />\n  <path d=\"M6 5.5a1.5 1.5 0 0 1 1.5 -1.5h7a1.5 1.5 0 0 1 1.5 1.5a1.5 1.5 0 0 1 -1.5 1.5h-7a1.5 1.5 0 0 1 -1.5 -1.5\" />"),
    SANDBOX(
        "sandbox",
        "<path d=\"M19.953 8.017l1.047 6.983v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2l1.245 -8.297a2 2 0 0 1 1.977 -1.703h3.778\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M13 3l5.5 1.5\" />\n  <path d=\"M15.75 3.75l-2 7\" />\n  <path d=\"M7 10.5c1.667 -.667 3.333 -.667 5 0c1.667 .667 3.333 .667 5 0\" />"),
    SCALE(
        "scale",
        "<path d=\"M7 20l10 0\" />\n  <path d=\"M6 6l6 -1l6 1\" />\n  <path d=\"M12 3l0 17\" />\n  <path d=\"M9 12l-3 -6l-3 6a3 3 0 0 0 6 0\" />\n  <path d=\"M21 12l-3 -6l-3 6a3 3 0 0 0 6 0\" />"),
    SCALE_OFF(
        "scale-off",
        "<path d=\"M7 20h10\" />\n  <path d=\"M9.452 5.425l2.548 -.425l6 1\" />\n  <path d=\"M12 3v5m0 4v8\" />\n  <path d=\"M9 12l-3 -6l-3 6a3 3 0 0 0 6 0\" />\n  <path d=\"M18.873 14.871a3 3 0 0 0 2.127 -2.871l-3 -6l-2.677 5.355\" />\n  <path d=\"M3 3l18 18\" />"),
    SCALE_OUTLINE(
        "scale-outline",
        "<path d=\"M3 7a4 4 0 0 1 4 -4h10a4 4 0 0 1 4 4v10a4 4 0 0 1 -4 4h-10a4 4 0 0 1 -4 -4v-10\" />\n  <path d=\"M12 7c1.956 0 3.724 .802 5 2.095l-2.956 2.904a3 3 0 0 0 -2.038 -.799a3 3 0 0 0 -2.038 .798l-2.956 -2.903a6.979 6.979 0 0 1 5 -2.095\" />"),
    SCALE_OUTLINE_OFF(
        "scale-outline-off",
        "<path d=\"M7 3h10a4 4 0 0 1 4 4v10m-1.173 2.83a3.987 3.987 0 0 1 -2.827 1.17h-10a4 4 0 0 1 -4 -4v-10c0 -1.104 .447 -2.103 1.17 -2.827\" />\n  <path d=\"M11.062 7.062c.31 -.041 .622 -.062 .938 -.062c1.956 0 3.724 .802 5 2.095a142.85 142.85 0 0 0 -2 1.905m-3.723 .288a3 3 0 0 0 -1.315 .71l-2.956 -2.903a6.977 6.977 0 0 1 1.142 -.942\" />\n  <path d=\"M3 3l18 18\" />"),
    SCAN(
        "scan",
        "<path d=\"M5 12h14\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    SCAN_CUBE(
        "scan-cube",
        "<path d=\"M8.504 9.426l3 -1.714a1 1 0 0 1 .992 0l3 1.714a1 1 0 0 1 .504 .868v3.411a1 1 0 0 1 -.504 .868l-3 1.715a1 1 0 0 1 -.992 0l-3 -1.715a1 1 0 0 1 -.504 -.868v-3.41a1 1 0 0 1 .504 -.869\" />\n  <path d=\"M15.75 9.964l-3.75 2.036\" />\n  <path d=\"M12 12l-3.75 -2.036\" />\n  <path d=\"M12 12v4.071\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M7 12q 5 -7 10 0\" />\n  <path d=\"M7 12q 5 7 10 0\" />\n  <path d=\"M12 12h-.01\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    SCAN_POSITION(
        "scan-position",
        "<path d=\"M12 17l3 -8l-8 3l3.5 1.5l1.5 3.5\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    SEARCH(
        "search",
        "<path d=\"M3 10a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M21 21l-6 -6\" />"),
    SEARCH_OFF(
        "search-off",
        "<path d=\"M5.039 5.062a7 7 0 0 0 9.91 9.89m1.584 -2.434a7 7 0 0 0 -9.038 -9.057\" />\n  <path d=\"M3 3l18 18\" />"),
    SECRET_PHRASES(
        "secret-phrases",
        "<path d=\"M19 5h-14a2 2 0 0 0 -2 2v10a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-10a2 2 0 0 0 -2 -2\" />\n  <path d=\"M7 9h3\" />\n  <path d=\"M14 9h3\" />\n  <path d=\"M7 12h3\" />\n  <path d=\"M14 12h3\" />\n  <path d=\"M7 15h3\" />\n  <path d=\"M14 15h3\" />"),
    SELECT_ALL(
        "select-all",
        "<path d=\"M8 9a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M16 20v.01\" />\n  <path d=\"M8 20v.01\" />\n  <path d=\"M4 20v.01\" />\n  <path d=\"M4 16v.01\" />\n  <path d=\"M4 12v.01\" />\n  <path d=\"M4 8v.01\" />\n  <path d=\"M4 4v.01\" />\n  <path d=\"M8 4v.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M16 4v.01\" />\n  <path d=\"M20 4v.01\" />\n  <path d=\"M20 8v.01\" />\n  <path d=\"M20 12v.01\" />\n  <path d=\"M20 16v.01\" />\n  <path d=\"M20 20v.01\" />"),
    SETTINGS(
        "settings",
        "<path d=\"M10.325 4.317c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.724 1.724 0 0 0 -1.066 2.573c.94 1.543 -.826 3.31 -2.37 2.37a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_2(
        "settings-2",
        "<path d=\"M19.875 6.27a2.225 2.225 0 0 1 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    SETTINGS_AI(
        "settings-ai",
        "<path d=\"M10.325 4.317c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.724 1.724 0 0 0 -1.066 2.573c.94 1.543 -.826 3.31 -2.37 2.37a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065\" />\n  <path d=\"M9 14v-2.5a1.5 1.5 0 0 1 3 0v2.5\" />\n  <path d=\"M9 13h3\" />\n  <path d=\"M15 10v4\" />"),
    SETTINGS_AUTOMATION(
        "settings-automation",
        "<path d=\"M10.325 4.317c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.724 1.724 0 0 0 -1.066 2.573c.94 1.543 -.826 3.31 -2.37 2.37a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065\" />\n  <path d=\"M10 9v6l5 -3l-5 -3\" />"),
    SETTINGS_BOLT(
        "settings-bolt",
        "<path d=\"M13.256 20.473c-.855 .907 -2.583 .643 -2.931 -.79a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.07 .26 1.488 1.29 1.254 2.15\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_CANCEL(
        "settings-cancel",
        "<path d=\"M12.29 20.977c-.818 .132 -1.724 -.3 -1.965 -1.294a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.983 .238 1.416 1.126 1.298 1.937\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_CHECK(
        "settings-check",
        "<path d=\"M11.445 20.913a1.665 1.665 0 0 1 -1.12 -1.23a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.31 .318 1.643 1.79 .997 2.694\" />\n  <path d=\"M15 19l2 2l4 -4\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_CODE(
        "settings-code",
        "<path d=\"M11.482 20.924a1.666 1.666 0 0 1 -1.157 -1.241a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.312 .318 1.644 1.794 .995 2.697\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    SETTINGS_COG(
        "settings-cog",
        "<path d=\"M12.003 21c-.732 .001 -1.465 -.438 -1.678 -1.317a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.886 .215 1.325 .957 1.318 1.694\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    SETTINGS_DOLLAR(
        "settings-dollar",
        "<path d=\"M13.038 20.666c-.902 .665 -2.393 .337 -2.713 -.983a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 .402 2.248\" />\n  <path d=\"M15 12a3 3 0 1 0 -1.724 2.716\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    SETTINGS_DOWN(
        "settings-down",
        "<path d=\"M12.52 20.924c-.87 .262 -1.93 -.152 -2.195 -1.241a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.088 .264 1.502 1.323 1.242 2.192\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_EXCLAMATION(
        "settings-exclamation",
        "<path d=\"M15.004 18.401a1.724 1.724 0 0 0 -1.329 1.282c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.079 .262 1.495 1.305 1.248 2.17\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    SETTINGS_HEART(
        "settings-heart",
        "<path d=\"M11.231 20.828a1.668 1.668 0 0 1 -.906 -1.145a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.509 .123 .87 .421 1.084 .792\" />\n  <path d=\"M14.882 11.165a3.001 3.001 0 1 0 -4.31 3.474\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    SETTINGS_MINUS(
        "settings-minus",
        "<path d=\"M12.488 20.933c-.863 .243 -1.902 -.174 -2.163 -1.25a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35c-.535 .13 -.976 .507 -1.187 1.016c-.049 .118 -.084 .185 -.106 .309\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_OFF(
        "settings-off",
        "<path d=\"M9.451 5.437c.418 -.218 .75 -.609 .874 -1.12c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35c-.486 .118 -.894 .44 -1.123 .878m-.188 3.803c-.517 .523 -1.349 .734 -2.125 .262a1.724 1.724 0 0 0 -2.572 1.065c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.472 -.774 -.262 -1.604 .259 -2.121\" />\n  <path d=\"M9.889 9.869a3 3 0 1 0 4.226 4.26m.592 -3.424a3.012 3.012 0 0 0 -1.419 -1.415\" />\n  <path d=\"M3 3l18 18\" />"),
    SETTINGS_PAUSE(
        "settings-pause",
        "<path d=\"M13.004 20.69c-.905 .632 -2.363 .296 -2.679 -1.007a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.314 .319 1.645 1.798 .992 2.701\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    SETTINGS_PIN(
        "settings-pin",
        "<path d=\"M12.578 20.905c-.88 .299 -1.983 -.109 -2.253 -1.222a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.574 .14 .96 .5 1.16 .937\" />\n  <path d=\"M14.99 12.256a3 3 0 1 0 -2.33 2.671\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    SETTINGS_PLUS(
        "settings-plus",
        "<path d=\"M12.483 20.935c-.862 .239 -1.898 -.178 -2.158 -1.252a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.08 .262 1.496 1.308 1.247 2.173\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_QUESTION(
        "settings-question",
        "<path d=\"M14.69 18.498c-.508 .21 -.885 .65 -1.015 1.185c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572a1.67 1.67 0 0 1 1.179 .982\" />\n  <path d=\"M14.95 12.553a3 3 0 1 0 -1.211 1.892\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    SETTINGS_SEARCH(
        "settings-search",
        "<path d=\"M11.646 20.965a1.67 1.67 0 0 1 -1.321 -1.282a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.728 .177 1.154 .71 1.279 1.303\" />\n  <path d=\"M14.985 11.694a3 3 0 1 0 -3.29 3.29\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    SETTINGS_SHARE(
        "settings-share",
        "<path d=\"M12.004 21c-.732 .002 -1.466 -.437 -1.679 -1.317a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.306 .317 1.64 1.78 1.004 2.684\" />\n  <path d=\"M12 15a3 3 0 1 0 0 -6a3 3 0 0 0 0 6\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    SETTINGS_SPARK(
        "settings-spark",
        "<path d=\"M11.992 21c-.728 -.003 -1.455 -.442 -1.667 -1.317a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c.882 .214 1.32 .95 1.317 1.684\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    SETTINGS_STAR(
        "settings-star",
        "<path d=\"M10.325 19.683a1.723 1.723 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572a1.67 1.67 0 0 1 1.106 .831\" />\n  <path d=\"M14.89 11.195a3.001 3.001 0 1 0 -4.457 3.364\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    SETTINGS_UP(
        "settings-up",
        "<path d=\"M12.501 20.93c-.866 .25 -1.914 -.166 -2.176 -1.247a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.074 .26 1.49 1.296 1.252 2.158\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    SETTINGS_X(
        "settings-x",
        "<path d=\"M13.675 19.683c-.426 1.756 -2.924 1.756 -3.35 0a1.724 1.724 0 0 0 -2.573 -1.066c-1.543 .94 -3.31 -.826 -2.37 -2.37a1.724 1.724 0 0 0 -1.065 -2.572c-1.756 -.426 -1.756 -2.924 0 -3.35a1.724 1.724 0 0 0 1.066 -2.573c-.94 -1.543 .826 -3.31 2.37 -2.37c1 .608 2.296 .07 2.572 -1.065c.426 -1.756 2.924 -1.756 3.35 0a1.724 1.724 0 0 0 2.573 1.066c1.543 -.94 3.31 .826 2.37 2.37a1.724 1.724 0 0 0 1.065 2.572c1.756 .426 1.756 2.924 0 3.35a1.66 1.66 0 0 0 -.324 .114\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    SHARE(
        "share",
        "<path d=\"M3 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15 6a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8.7 10.7l6.6 -3.4\" />\n  <path d=\"M8.7 13.3l6.6 3.4\" />"),
    SHARE_OFF(
        "share-off",
        "<path d=\"M3 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15 6a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15.861 15.896a3 3 0 0 0 4.265 4.22m.578 -3.417a3.012 3.012 0 0 0 -1.507 -1.45\" />\n  <path d=\"M8.7 10.7l1.336 -.688m2.624 -1.352l2.64 -1.36\" />\n  <path d=\"M8.7 13.3l6.6 3.4\" />\n  <path d=\"M3 3l18 18\" />"),
    SHIELD(
        "shield",
        "<path d=\"M12 3a12 12 0 0 0 8.5 3a12 12 0 0 1 -8.5 15a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3\" />"),
    SHIELD_BOLT(
        "shield-bolt",
        "<path d=\"M13.342 20.566c-.436 .17 -.884 .315 -1.342 .434a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .117 6.34\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    SHIELD_CANCEL(
        "shield-cancel",
        "<path d=\"M12.277 20.925c-.092 .026 -.184 .051 -.277 .075a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .145 6.232\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    SHIELD_CHECK(
        "shield-check",
        "<path d=\"M11.46 20.846a12 12 0 0 1 -7.96 -14.846a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 -.09 7.06\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    SHIELD_CHECKERED(
        "shield-checkered",
        "<path d=\"M12 3a12 12 0 0 0 8.5 3a12 12 0 0 1 -8.5 15a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M3.5 12h17\" />"),
    SHIELD_CHEVRON(
        "shield-chevron",
        "<path d=\"M12 3a12 12 0 0 0 8.5 3a12 12 0 0 1 -8.5 15a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3\" />\n  <path d=\"M4 14l8 -3l8 3\" />"),
    SHIELD_CODE(
        "shield-code",
        "<path d=\"M12 21a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 -.078 7.024\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    SHIELD_COG(
        "shield-cog",
        "<path d=\"M12 21a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.568 1.933 .635 3.957 .223 5.89\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    SHIELD_DOLLAR(
        "shield-dollar",
        "<path d=\"M13.018 20.687c-.333 .119 -.673 .223 -1.018 .313a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.433 1.472 .575 2.998 .436 4.495\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    SHIELD_DOWN(
        "shield-down",
        "<path d=\"M12.444 20.876c-.147 .044 -.295 .085 -.444 .124a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .117 6.343\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    SHIELD_EXCLAMATION(
        "shield-exclamation",
        "<path d=\"M15.04 19.745c-.942 .551 -1.964 .976 -3.04 1.255a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .195 6.015\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    SHIELD_HALF(
        "shield-half",
        "<path d=\"M12 3a12 12 0 0 0 8.5 3a12 12 0 0 1 -8.5 15a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3\" />\n  <path d=\"M12 3v18\" />"),
    SHIELD_HEART(
        "shield-heart",
        "<path d=\"M12 21a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12.01 12.01 0 0 1 .378 5\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    SHIELD_LOCK(
        "shield-lock",
        "<path d=\"M12 3a12 12 0 0 0 8.5 3a12 12 0 0 1 -8.5 15a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3\" />\n  <path d=\"M11 11a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M12 12l0 2.5\" />"),
    SHIELD_MINUS(
        "shield-minus",
        "<path d=\"M12.46 20.871c-.153 .046 -.306 .089 -.46 .129a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 -.916 9.015\" />\n  <path d=\"M16 19h6\" />"),
    SHIELD_OFF(
        "shield-off",
        "<path d=\"M17.67 17.667a12 12 0 0 1 -5.67 3.333a12 12 0 0 1 -8.5 -15c.794 .036 1.583 -.006 2.357 -.124m3.128 -.926a11.997 11.997 0 0 0 3.015 -1.95a12 12 0 0 0 8.5 3a12 12 0 0 1 -1.116 9.376\" />\n  <path d=\"M3 3l18 18\" />"),
    SHIELD_PAUSE(
        "shield-pause",
        "<path d=\"M13.004 20.692c-.329 .117 -.664 .22 -1.004 .308a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 -.081 7.034\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    SHIELD_PIN(
        "shield-pin",
        "<path d=\"M12.597 20.829a12 12 0 0 1 -.597 .171a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.506 1.72 .614 3.512 .342 5.248\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    SHIELD_PLUS(
        "shield-plus",
        "<path d=\"M12.462 20.87c-.153 .047 -.307 .09 -.462 .13a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .11 6.37\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    SHIELD_QUESTION(
        "shield-question",
        "<path d=\"M15.065 19.732c-.95 .557 -1.98 .986 -3.065 1.268a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.51 1.738 .617 3.55 .333 5.303\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    SHIELD_SEARCH(
        "shield-search",
        "<path d=\"M12 21a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.539 1.832 .627 3.747 .283 5.588\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    SHIELD_SHARE(
        "shield-share",
        "<path d=\"M12 21a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .193 6.025\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    SHIELD_STAR(
        "shield-star",
        "<path d=\"M11.143 20.743a12 12 0 0 1 -7.643 -14.743a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3c.504 1.716 .614 3.505 .343 5.237\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    SHIELD_UP(
        "shield-up",
        "<path d=\"M12.442 20.876a13.12 13.12 0 0 1 -.442 .124a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 .119 6.336\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    SHIELD_X(
        "shield-x",
        "<path d=\"M13.252 20.601c-.408 .155 -.826 .288 -1.252 .399a12 12 0 0 1 -8.5 -15a12 12 0 0 0 8.5 -3a12 12 0 0 0 8.5 3a12 12 0 0 1 -.19 7.357\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    SKEW_X(
        "skew-x",
        "<path d=\"M4 5.205v13.59a1 1 0 0 0 1.184 .983l14 -2.625a1 1 0 0 0 .816 -.983v-8.34a1 1 0 0 0 -.816 -.983l-14 -2.625a1 1 0 0 0 -1.184 .983\" />"),
    SKEW_Y(
        "skew-y",
        "<path d=\"M4.326 19h15.348a1 1 0 0 0 .962 -1.275l-3.429 -12a1 1 0 0 0 -.961 -.725h-8.492a1 1 0 0 0 -.961 .725l-3.429 12a1 1 0 0 0 .962 1.275\" />"),
    SLASHES("slashes", "<path d=\"M14 5l-10 14\" />\n  <path d=\"M20 5l-10 14\" />"),
    SNOWBOARDING(
        "snowboarding",
        "<path d=\"M15 3a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M7 19l4 -2.5l-.5 -1.5\" />\n  <path d=\"M16 21l-1 -6l-4.5 -3l3.5 -6\" />\n  <path d=\"M7 9l1.5 -3h5.5l2 4l3 1\" />\n  <path d=\"M3 17c.399 1.154 .899 1.805 1.5 1.951c6 1.464 10.772 2.262 13.5 2.927c1.333 .325 2.333 0 3 -.976\" />"),
    SOCIAL(
        "social",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M9 14a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 7l0 4\" />\n  <path d=\"M6.7 17.8l2.8 -2\" />\n  <path d=\"M17.3 17.8l-2.8 -2\" />"),
    SOCIAL_OFF(
        "social-off",
        "<path d=\"M10 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17.57 17.602a2 2 0 0 0 2.83 2.827\" />\n  <path d=\"M11.113 11.133a3 3 0 1 0 3.765 3.715\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M6.7 17.8l2.8 -2\" />\n  <path d=\"M17.3 17.8l-2.8 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    SOFA(
        "sofa",
        "<path d=\"M4 11a2 2 0 0 1 2 2v1h12v-1a2 2 0 1 1 4 0v5a1 1 0 0 1 -1 1h-18a1 1 0 0 1 -1 -1v-5a2 2 0 0 1 2 -2\" />\n  <path d=\"M4 11v-3a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v3\" />\n  <path d=\"M12 5v9\" />"),
    SOFA_OFF(
        "sofa-off",
        "<path d=\"M18 14v-1a2 2 0 1 1 4 0v5m-3 1h-16a1 1 0 0 1 -1 -1v-5a2 2 0 1 1 4 0v1h8\" />\n  <path d=\"M4 11v-3c0 -1.082 .573 -2.03 1.432 -2.558m3.568 -.442h8a3 3 0 0 1 3 3v3\" />\n  <path d=\"M12 5v3m0 4v2\" />\n  <path d=\"M3 3l18 18\" />"),
    SOLAR_ELECTRICITY(
        "solar-electricity",
        "<path d=\"M4 6.28v11.44a1 1 0 0 0 1.243 .97l6 -1.5a1 1 0 0 0 .757 -.97v-8.44a1 1 0 0 0 -.757 -.97l-6 -1.5a1 1 0 0 0 -1.243 .97\" />\n  <path d=\"M8 6v12\" />\n  <path d=\"M12 12h-8\" />\n  <path d=\"M20 7l-3 5h4l-3 5\" />"),
    SOLAR_PANEL(
        "solar-panel",
        "<path d=\"M4.28 14h15.44a1 1 0 0 0 .97 -1.243l-1.5 -6a1 1 0 0 0 -.97 -.757h-12.44a1 1 0 0 0 -.97 .757l-1.5 6a1 1 0 0 0 .97 1.243\" />\n  <path d=\"M4 10h16\" />\n  <path d=\"M10 6l-1 8\" />\n  <path d=\"M14 6l1 8\" />\n  <path d=\"M12 14v4\" />\n  <path d=\"M7 18h10\" />"),
    SOLAR_PANEL_2(
        "solar-panel-2",
        "<path d=\"M8 2a4 4 0 1 0 8 0\" />\n  <path d=\"M4 3h1\" />\n  <path d=\"M19 3h1\" />\n  <path d=\"M12 9v1\" />\n  <path d=\"M17.2 7.2l.707 .707\" />\n  <path d=\"M6.8 7.2l-.7 .7\" />\n  <path d=\"M4.28 21h15.44a1 1 0 0 0 .97 -1.243l-1.5 -6a1 1 0 0 0 -.97 -.757h-12.44a1 1 0 0 0 -.97 .757l-1.5 6a1 1 0 0 0 .97 1.243\" />\n  <path d=\"M4 17h16\" />\n  <path d=\"M10 13l-1 8\" />\n  <path d=\"M14 13l1 8\" />"),
    SORT_ASCENDING_SHAPES(
        "sort-ascending-shapes",
        "<path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M17 14l-3.5 6h7l-3.5 -6\" />"),
    SORT_ASCENDING_SMALL_BIG(
        "sort-ascending-small-big",
        "<path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M14 5.667c0 -.369 .298 -.667 .667 -.667h2.666c.369 0 .667 .298 .667 .667v2.666a.667 .667 0 0 1 -.667 .667h-2.666a.667 .667 0 0 1 -.667 -.667v-2.666\" />\n  <path d=\"M14 13.167c0 -.645 .522 -1.167 1.167 -1.167h4.666c.645 0 1.167 .522 1.167 1.167v4.666c0 .645 -.522 1.167 -1.167 1.167h-4.666a1.167 1.167 0 0 1 -1.167 -1.167v-4.666\" />"),
    SORT_DESCENDING_SHAPES(
        "sort-descending-shapes",
        "<path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M14 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M17 4l-3.5 6h7l-3.5 -6\" />"),
    SORT_DESCENDING_SMALL_BIG(
        "sort-descending-small-big",
        "<path d=\"M10 15l-3 3l-3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M14 18.333c0 .369 .298 .667 .667 .667h2.666a.667 .667 0 0 0 .667 -.667v-2.666a.667 .667 0 0 0 -.667 -.667h-2.666a.667 .667 0 0 0 -.667 .667v2.666\" />\n  <path d=\"M14 10.833c0 .645 .522 1.167 1.167 1.167h4.666c.645 0 1.167 -.522 1.167 -1.167v-4.666c0 -.645 -.522 -1.167 -1.167 -1.167h-4.666c-.645 0 -1.167 .522 -1.167 1.167v4.666\" />"),
    SOS(
        "sos",
        "<path d=\"M12 8a2 2 0 0 1 2 2v4a2 2 0 1 1 -4 0v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 15c.345 .6 1.258 1 2 1a2 2 0 1 0 0 -4a2 2 0 1 1 0 -4c.746 0 1.656 .394 2 1\" />\n  <path d=\"M3 15c.345 .6 1.258 1 2 1a2 2 0 1 0 0 -4a2 2 0 1 1 0 -4c.746 0 1.656 .394 2 1\" />"),
    SPACES(
        "spaces",
        "<path d=\"M6.045 9.777a6 6 0 1 0 5.951 .023\" />\n  <path d=\"M11.997 20.196a6 6 0 1 0 -2.948 -5.97\" />\n  <path d=\"M17.95 9.785q .05 -.386 .05 -.785a6 6 0 1 0 -3.056 5.23\" />"),
    SPARKLES(
        "sparkles",
        "<path d=\"M16 18a2 2 0 0 1 2 2a2 2 0 0 1 2 -2a2 2 0 0 1 -2 -2a2 2 0 0 1 -2 2m0 -12a2 2 0 0 1 2 2a2 2 0 0 1 2 -2a2 2 0 0 1 -2 -2a2 2 0 0 1 -2 2m-7 12a6 6 0 0 1 6 -6a6 6 0 0 1 -6 -6a6 6 0 0 1 -6 6a6 6 0 0 1 6 6\" />"),
    SPIRAL(
        "spiral",
        "<path d=\"M10 12.057a1.9 1.9 0 0 0 .614 .743c1.06 .713 2.472 .112 3.043 -.919c.839 -1.513 -.022 -3.368 -1.525 -4.08c-2 -.95 -4.371 .154 -5.24 2.086c-1.095 2.432 .29 5.248 2.71 6.246c2.931 1.208 6.283 -.418 7.438 -3.255c1.36 -3.343 -.557 -7.134 -3.896 -8.41c-3.855 -1.474 -8.2 .68 -9.636 4.422c-1.63 4.253 .823 9.024 5.082 10.576c4.778 1.74 10.118 -.941 11.833 -5.59a9.354 9.354 0 0 0 .577 -2.813\" />"),
    SPIRAL_OFF(
        "spiral-off",
        "<path d=\"M10 12.057a1.9 1.9 0 0 0 .614 .743c.682 .459 1.509 .374 2.164 -.02m1.103 -2.92a3.298 3.298 0 0 0 -1.749 -2.059a3.6 3.6 0 0 0 -.507 -.195m-3.385 .634a4.154 4.154 0 0 0 -1.347 1.646c-1.095 2.432 .29 5.248 2.71 6.246c1.955 .806 4.097 .35 5.65 -.884m1.745 -2.268l.043 -.103c1.36 -3.343 -.557 -7.134 -3.896 -8.41c-1.593 -.61 -3.27 -.599 -4.79 -.113m-2.579 1.408a7.574 7.574 0 0 0 -2.268 3.128c-1.63 4.253 .823 9.024 5.082 10.576c3.211 1.17 6.676 .342 9.124 -1.738m1.869 -2.149a9.354 9.354 0 0 0 1.417 -4.516\" />\n  <path d=\"M3 3l18 18\" />"),
    SPRAY(
        "spray",
        "<path d=\"M4 12a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v7a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2l0 -7\" />\n  <path d=\"M6 10v-4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v4\" />\n  <path d=\"M15 7h.01\" />\n  <path d=\"M18 9h.01\" />\n  <path d=\"M18 5h.01\" />\n  <path d=\"M21 3h.01\" />\n  <path d=\"M21 7h.01\" />\n  <path d=\"M21 11h.01\" />\n  <path d=\"M10 7h1\" />"),
    SPY(
        "spy",
        "<path d=\"M3 11h18\" />\n  <path d=\"M5 11v-4a3 3 0 0 1 3 -3h8a3 3 0 0 1 3 3v4\" />\n  <path d=\"M4 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M10 17h4\" />"),
    SPY_OFF(
        "spy-off",
        "<path d=\"M3 11h8m4 0h6\" />\n  <path d=\"M5 11v-4c0 -.571 .16 -1.105 .437 -1.56m2.563 -1.44h8a3 3 0 0 1 3 3v4\" />\n  <path d=\"M4 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14.88 14.877a3 3 0 1 0 4.239 4.247m.59 -3.414a3.012 3.012 0 0 0 -1.425 -1.422\" />\n  <path d=\"M10 17h4\" />\n  <path d=\"M3 3l18 18\" />"),
    SQUARE_F0(
        "square-f0",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 10.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F1(
        "square-f1",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 11l2 -2v6\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F2(
        "square-f2",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 9h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F3(
        "square-f3",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 9.5a.5 .5 0 0 1 .5 -.5h1a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1a.5 .5 0 0 1 -.5 -.5\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F4(
        "square-f4",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 9v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M16 9v6\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F5(
        "square-f5",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 14.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F6(
        "square-f6",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M16 9.75a.75 .75 0 0 0 -.75 -.75h-1.25a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F7(
        "square-f7",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 9h3l-1.5 6\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F8(
        "square-f8",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M14.5 12h-.5a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    SQUARE_F9(
        "square-f9",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M13 14.25c0 .414 .336 .75 .75 .75h1.5a.75 .75 0 0 0 .75 -.75v-4.5a.75 .75 0 0 0 -.75 -.75h-1.5a.75 .75 0 0 0 -.75 .75v1.5c0 .414 .336 .75 .75 .75h2.25\" />\n  <path d=\"M8 12h2\" />\n  <path d=\"M10 9h-2v6\" />"),
    STACK_BACK(
        "stack-back",
        "<path d=\"M4 8l8 4l8 -4l-8 -4l-8 4\" />\n  <path d=\"M12 16l-4 -2l-4 2l8 4l8 -4l-4 -2l-4 2\" fill=\"currentColor\" />\n  <path d=\"M8 10l-4 2l4 2m8 0l4 -2l-4 -2\" />"),
    STACK_BACKWARD(
        "stack-backward",
        "<path d=\"M14 12l6 -3l-8 -4l-8 4l6 3\" />\n  <path d=\"M10 12l-6 3l8 4l8 -4l-6 -3l-2 1l-2 -1\" fill=\"currentColor\" />"),
    STACK_FORWARD(
        "stack-forward",
        "<path d=\"M12 5l-8 4l8 4l8 -4l-8 -4\" fill=\"currentColor\" />\n  <path d=\"M10 12l-6 3l8 4l8 -4l-6 -3\" />"),
    STACK_FRONT(
        "stack-front",
        "<path d=\"M12 4l-8 4l8 4l8 -4l-8 -4\" fill=\"currentColor\" />\n  <path d=\"M8 14l-4 2l8 4l8 -4l-4 -2\" />\n  <path d=\"M8 10l-4 2l8 4l8 -4l-4 -2\" />"),
    STACK_MIDDLE(
        "stack-middle",
        "<path d=\"M16 10l4 -2l-8 -4l-8 4l4 2\" />\n  <path d=\"M12 12l-4 -2l-4 2l8 4l8 -4l-4 -2l-4 2\" fill=\"currentColor\" />\n  <path d=\"M8 14l-4 2l8 4l8 -4l-4 -2\" />"),
    STAR(
        "star",
        "<path d=\"M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l3.086 6.253l6.9 1l-5 4.867l1.179 6.873l-6.158 -3.245\" />"),
    STAR_HALF(
        "star-half",
        "<path d=\"M12 17.75l-6.172 3.245l1.179 -6.873l-5 -4.867l6.9 -1l3.086 -6.253l.007 15.748\" />"),
    STAR_OFF(
        "star-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M10.012 6.016l1.981 -4.014l3.086 6.253l6.9 1l-4.421 4.304m.012 4.01l.588 3.426l-6.158 -3.245l-6.172 3.245l1.179 -6.873l-5 -4.867l6.327 -.917\" />"),
    STARS(
        "stars",
        "<path d=\"M17.8 19.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M6.2 19.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M12 9.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    STARS_OFF(
        "stars-off",
        "<path d=\"M17.373 13.371l.076 -.154a.392 .392 0 0 1 .702 0l.907 1.831m.367 .39c.498 .071 1.245 .18 2.24 .324a.39 .39 0 0 1 .217 .665c-.326 .316 -.57 .553 -.732 .712m-.611 3.405a.39 .39 0 0 1 -.567 .411l-2.172 -1.138l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l1.601 -.232\" />\n  <path d=\"M6.2 19.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M9.557 5.556l1 -.146l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.014 .187m-4.153 -.166l-.744 .39a.392 .392 0 0 1 -.568 -.41l.188 -1.093\" />\n  <path d=\"M3 3l18 18\" />"),
    STATUS_CHANGE(
        "status-change",
        "<path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 12v-2a6 6 0 1 1 12 0v2\" />\n  <path d=\"M15 9l3 3l3 -3\" />"),
    STEAM(
        "steam",
        "<path d=\"M11 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M19 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 20a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M5.5 5.5l3 3\" />\n  <path d=\"M15.5 15.5l3 3\" />\n  <path d=\"M18.5 5.5l-3 3\" />\n  <path d=\"M8.5 15.5l-3 3\" />"),
    STEREO_GLASSES(
        "stereo-glasses",
        "<path d=\"M8 3h-2l-3 9\" />\n  <path d=\"M16 3h2l3 9\" />\n  <path d=\"M3 12v7a1 1 0 0 0 1 1h4.586a1 1 0 0 0 .707 -.293l2 -2a1 1 0 0 1 1.414 0l2 2a1 1 0 0 0 .707 .293h4.586a1 1 0 0 0 1 -1v-7h-18\" />\n  <path d=\"M7 16h1\" />\n  <path d=\"M16 16h1\" />"),
    STOPWATCH(
        "stopwatch",
        "<path d=\"M5 13a7 7 0 1 0 14 0a7 7 0 0 0 -14 0\" />\n  <path d=\"M14.5 10.5l-2.5 2.5\" />\n  <path d=\"M17 8l1 -1\" />\n  <path d=\"M14 3h-4\" />"),
    SUBTASK(
        "subtask",
        "<path d=\"M6 9l6 0\" />\n  <path d=\"M4 5l4 0\" />\n  <path d=\"M6 5v11a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 8a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M12 16a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -2\" />"),
    SWIPE(
        "swipe",
        "<path d=\"M15 16.572v2.42a2.01 2.01 0 0 1 -2.009 2.008h-7.981a2.01 2.01 0 0 1 -2.01 -2.009v-7.981a2.01 2.01 0 0 1 2.009 -2.01h2.954\" />\n  <path d=\"M9.167 4.511a2.04 2.04 0 0 1 2.496 -1.441l7.826 2.097a2.04 2.04 0 0 1 1.441 2.496l-2.097 7.826a2.04 2.04 0 0 1 -2.496 1.441l-7.827 -2.097a2.04 2.04 0 0 1 -1.441 -2.496l2.098 -7.827l0 .001\" />"),
    TAB_CLOSE(
        "tab-close",
        "<path d=\"M3 21v-1a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v1\" />\n  <path d=\"M6 15a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2\" />\n  <path d=\"M15 6l-3 3l-3 -3\" />\n  <path d=\"M12 9v-6\" />"),
    TABLE_DASHED(
        "table-dashed",
        "<path d=\"M5 3a2 2 0 0 0 -2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1 -2 2\" />\n  <path d=\"M5 21a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M7 10h1\" />\n  <path d=\"M12 10h1\" />\n  <path d=\"M17 10h1\" />\n  <path d=\"M10 12v1\" />\n  <path d=\"M10 17v1\" />\n  <path d=\"M10 7v1\" />"),
    TABS(
        "tabs",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6.36 5a2 2 0 0 1 1.962 1.608l.356 1.784a2 2 0 0 0 1.962 1.608h8.36a2 2 0 0 1 2 2\" />\n  <path d=\"M12.36 5a2 2 0 0 1 1.962 1.608l.356 1.784a2 2 0 0 0 1.962 1.608\" />"),
    TELESCOPE(
        "telescope",
        "<path d=\"M6 21l6 -5l6 5\" />\n  <path d=\"M12 13v8\" />\n  <path d=\"M3.294 13.678l.166 .281c.52 .88 1.624 1.265 2.605 .91l14.242 -5.165a1.023 1.023 0 0 0 .565 -1.456l-2.62 -4.705a1.087 1.087 0 0 0 -1.447 -.42l-.056 .032l-12.694 7.618c-1.02 .613 -1.357 1.897 -.76 2.905l-.001 0\" />\n  <path d=\"M14 5l3 5.5\" />"),
    TELESCOPE_OFF(
        "telescope-off",
        "<path d=\"M6 21l6 -5l6 5\" />\n  <path d=\"M12 13v8\" />\n  <path d=\"M8.238 8.264l-4.183 2.51c-1.02 .614 -1.357 1.898 -.76 2.906l.165 .28c.52 .88 1.624 1.266 2.605 .91l6.457 -2.34m2.907 -1.055l4.878 -1.77a1.023 1.023 0 0 0 .565 -1.455l-2.62 -4.705a1.087 1.087 0 0 0 -1.447 -.42l-.056 .032l-6.016 3.61\" />\n  <path d=\"M14 5l3 5.5\" />\n  <path d=\"M3 3l18 18\" />"),
    TEMPERATURE_SNOW(
        "temperature-snow",
        "<path d=\"M4 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 1 0 -4 0v8.5\" />\n  <path d=\"M4 9h4\" />\n  <path d=\"M14.75 4l1 2h2.25\" />\n  <path d=\"M17 4l-3 5l2 3\" />\n  <path d=\"M20.25 10l-1.25 2l1.25 2\" />\n  <path d=\"M22 12h-6l-2 3\" />\n  <path d=\"M18 18h-2.25l-1 2\" />\n  <path d=\"M17 20l-3 -5h-1\" />\n  <path d=\"M12 9l2.088 .008\" />"),
    TEMPERATURE_SUN(
        "temperature-sun",
        "<path d=\"M4 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 1 0 -4 0v8.5\" />\n  <path d=\"M4 9h4\" />\n  <path d=\"M13 16a4 4 0 1 0 0 -8a4.07 4.07 0 0 0 -1 .124\" />\n  <path d=\"M13 3v1\" />\n  <path d=\"M21 12h1\" />\n  <path d=\"M13 20v1\" />\n  <path d=\"M19.4 5.6l-.7 .7\" />\n  <path d=\"M18.7 17.7l.7 .7\" />"),
    TERMINAL("terminal", "<path d=\"M5 7l5 5l-5 5\" />\n  <path d=\"M12 19l7 0\" />"),
    TEST_PIPE(
        "test-pipe",
        "<path d=\"M20 8.04l-12.122 12.124a2.857 2.857 0 1 1 -4.041 -4.04l12.122 -12.124\" />\n  <path d=\"M7 13h8\" />\n  <path d=\"M19 15l1.5 1.6a2 2 0 1 1 -3 0l1.5 -1.6\" />\n  <path d=\"M15 3l6 6\" />"),
    TEST_PIPE_2(
        "test-pipe-2",
        "<path d=\"M15 3v15a3 3 0 0 1 -6 0v-15\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M8 3h8\" />"),
    TEST_PIPE_OFF(
        "test-pipe-off",
        "<path d=\"M20 8.04a803.533 803.533 0 0 0 -4 3.96m-2 2c-1.085 1.085 -3.125 3.14 -6.122 6.164a2.857 2.857 0 0 1 -4.041 -4.04c3.018 -3 5.073 -5.037 6.163 -6.124m2 -2c.872 -.872 2.191 -2.205 3.959 -4\" />\n  <path d=\"M7 13h6\" />\n  <path d=\"M19 15l1.5 1.6m-.74 3.173a2 2 0 0 1 -2.612 -2.608\" />\n  <path d=\"M15 3l6 6\" />\n  <path d=\"M3 3l18 18\" />"),
    TEXT_SCAN_2(
        "text-scan-2",
        "<path d=\"M8 12h8\" />\n  <path d=\"M8 9h6\" />\n  <path d=\"M8 15h4\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    TEXT_SCAN_AI(
        "text-scan-ai",
        "<path d=\"M8 12h4.5\" />\n  <path d=\"M8 8h6\" />\n  <path d=\"M8 16h2\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    TEXTURE(
        "texture",
        "<path d=\"M6 3l-3 3\" />\n  <path d=\"M21 18l-3 3\" />\n  <path d=\"M11 3l-8 8\" />\n  <path d=\"M16 3l-13 13\" />\n  <path d=\"M21 3l-18 18\" />\n  <path d=\"M21 8l-13 13\" />\n  <path d=\"M21 13l-8 8\" />"),
    THUMB_DOWN(
        "thumb-down",
        "<path d=\"M7 13v-8a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v7a1 1 0 0 0 1 1h3a4 4 0 0 1 4 4v1a2 2 0 0 0 4 0v-5h3a2 2 0 0 0 2 -2l-1 -5a2 3 0 0 0 -2 -2h-7a3 3 0 0 0 -3 3\" />"),
    THUMB_DOWN_OFF(
        "thumb-down-off",
        "<path d=\"M7 13v-6m-3 -3a1 1 0 0 0 -1 1v7a1 1 0 0 0 1 1h3a4 4 0 0 1 4 4v1a2 2 0 1 0 4 0v-3m2 -2h1a2 2 0 0 0 2 -2l-1 -5c-.295 -1.26 -1.11 -2.076 -2 -2h-7c-.57 0 -1.102 .159 -1.556 .434\" />\n  <path d=\"M3 3l18 18\" />"),
    THUMB_UP(
        "thumb-up",
        "<path d=\"M7 11v8a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-7a1 1 0 0 1 1 -1h3a4 4 0 0 0 4 -4v-1a2 2 0 0 1 4 0v5h3a2 2 0 0 1 2 2l-1 5a2 3 0 0 1 -2 2h-7a3 3 0 0 1 -3 -3\" />"),
    THUMB_UP_OFF(
        "thumb-up-off",
        "<path d=\"M7 11v8a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-7a1 1 0 0 1 1 -1h3a3.987 3.987 0 0 0 2.828 -1.172m1.172 -2.828v-1a2 2 0 1 1 4 0v5h3a2 2 0 0 1 2 2c-.222 1.112 -.39 1.947 -.5 2.503m-.758 3.244c-.392 .823 -1.044 1.312 -1.742 1.253h-7a3 3 0 0 1 -3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    TILDE(
        "tilde",
        "<path d=\"M4 12c0 -1.657 1.592 -3 3.556 -3c1.963 0 3.11 1.5 4.444 3c1.333 1.5 2.48 3 4.444 3s3.556 -1.343 3.556 -3\" />"),
    TIME_DURATION_0(
        "time-duration-0",
        "<path d=\"M3 12v.01\" />\n  <path d=\"M21 12v.01\" />\n  <path d=\"M12 21v.01\" />\n  <path d=\"M12 3v.01\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M16.5 4.2v.01\" />\n  <path d=\"M16.5 19.8v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M19.8 16.5v.01\" />\n  <path d=\"M19.8 7.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M10 11v2a2 2 0 1 0 4 0v-2a2 2 0 1 0 -4 0\" />"),
    TIME_DURATION_10(
        "time-duration-10",
        "<path d=\"M9 9v6\" />\n  <path d=\"M12 11v2a2 2 0 1 0 4 0v-2a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 12v.01\" />\n  <path d=\"M21 12v.01\" />\n  <path d=\"M12 21v.01\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M16.5 19.8v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M19.8 16.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M19.81 7.527a8.994 8.994 0 0 0 -7.81 -4.527\" />"),
    TIME_DURATION_15(
        "time-duration-15",
        "<path d=\"M12 15h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M9 9v6\" />\n  <path d=\"M3 12v.01\" />\n  <path d=\"M12 21v.01\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M16.5 19.8v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M19.8 16.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M21 12a9 9 0 0 0 -9 -9\" />"),
    TIME_DURATION_30(
        "time-duration-30",
        "<path d=\"M14 10.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M8 9h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />\n  <path d=\"M3 12v.01\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M12 21a9 9 0 0 0 0 -18\" />"),
    TIME_DURATION_45(
        "time-duration-45",
        "<path d=\"M13 15h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M7 9v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M10 9v6\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M3 12a9 9 0 1 0 9 -9\" />"),
    TIME_DURATION_5(
        "time-duration-5",
        "<path d=\"M10 15h2a1.5 1.5 0 0 0 0 -3h-2v-3h3.5\" />\n  <path d=\"M3 12v.01\" />\n  <path d=\"M21 12v.01\" />\n  <path d=\"M12 21v.01\" />\n  <path d=\"M7.5 4.2v.01\" />\n  <path d=\"M16.5 19.8v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M19.8 16.5v.01\" />\n  <path d=\"M19.8 7.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M16.5 4.206a9.042 9.042 0 0 0 -4.5 -1.206\" />"),
    TIME_DURATION_60(
        "time-duration-60",
        "<path d=\"M14 10.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M11 9h-2a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    TIME_DURATION_90(
        "time-duration-90",
        "<path d=\"M8 14.25c0 .414 .336 .75 .75 .75h1.5a.75 .75 0 0 0 .75 -.75v-4.5a.75 .75 0 0 0 -.75 -.75h-1.5a.75 .75 0 0 0 -.75 .75v1.5c0 .414 .336 .75 .75 .75h2.25\" />\n  <path d=\"M14 10.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    TIME_DURATION_OFF(
        "time-duration-off",
        "<path d=\"M3 12v.01\" />\n  <path d=\"M7.5 19.8v.01\" />\n  <path d=\"M4.2 16.5v.01\" />\n  <path d=\"M4.2 7.5v.01\" />\n  <path d=\"M12 21a8.994 8.994 0 0 0 6.362 -2.634m1.685 -2.336a9 9 0 0 0 -8.047 -13.03\" />\n  <path d=\"M3 3l18 18\" />"),
    TIMELINE(
        "timeline",
        "<path d=\"M4 16l6 -7l5 5l5 -6\" />\n  <path d=\"M14 14a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M19 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    TIMEZONE(
        "timezone",
        "<path d=\"M20.884 10.554a9 9 0 1 0 -10.337 10.328\" />\n  <path d=\"M3.6 9h16.8\" />\n  <path d=\"M3.6 15h6.9\" />\n  <path d=\"M11.5 3a17 17 0 0 0 -1.502 14.954\" />\n  <path d=\"M12.5 3a17 17 0 0 1 2.52 7.603\" />\n  <path d=\"M14 18a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M18 16.5v1.5l.5 .5\" />"),
    TIP_JAR(
        "tip-jar",
        "<path d=\"M14 10h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M12 9v1\" />\n  <path d=\"M12 16v1\" />\n  <path d=\"M17 4v1.882c0 .685 .387 1.312 1 1.618s1 .933 1 1.618v8.882a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-8.882c0 -.685 .387 -1.312 1 -1.618s1 -.933 1 -1.618v-1.882\" />\n  <path d=\"M6 4h12l-12 0\" />"),
    TIP_JAR_EURO(
        "tip-jar-euro",
        "<path d=\"M17 4v1.882c0 .685 .387 1.312 1 1.618s1 .933 1 1.618v8.882a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-8.882c0 -.685 .387 -1.312 1 -1.618s1 -.933 1 -1.618v-1.882\" />\n  <path d=\"M6 4h12l-12 0\" />\n  <path d=\"M12 13h-3\" />\n  <path d=\"M14 10.172a3 3 0 1 0 0 5.656\" />"),
    TIP_JAR_POUND(
        "tip-jar-pound",
        "<path d=\"M17 4v1.882c0 .685 .387 1.312 1 1.618s1 .933 1 1.618v8.882a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-8.882c0 -.685 .387 -1.312 1 -1.618s1 -.933 1 -1.618v-1.882\" />\n  <path d=\"M6 4h12l-12 0\" />\n  <path d=\"M14 10h-1a2 2 0 0 0 -2 2v2c0 1.105 -.395 2 -1.5 2h4.5\" />\n  <path d=\"M10 13h3\" />"),
    TOGGLE_LEFT(
        "toggle-left",
        "<path d=\"M6 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 12a6 6 0 0 1 6 -6h8a6 6 0 0 1 6 6a6 6 0 0 1 -6 6h-8a6 6 0 0 1 -6 -6\" />"),
    TOGGLE_RIGHT(
        "toggle-right",
        "<path d=\"M14 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M2 12a6 6 0 0 1 6 -6h8a6 6 0 0 1 6 6a6 6 0 0 1 -6 6h-8a6 6 0 0 1 -6 -6\" />"),
    TOILET_PAPER(
        "toilet-paper",
        "<path d=\"M3 10a3 7 0 1 0 6 0a3 7 0 1 0 -6 0\" />\n  <path d=\"M21 10c0 -3.866 -1.343 -7 -3 -7\" />\n  <path d=\"M6 3h12\" />\n  <path d=\"M21 10v10l-3 -1l-3 2l-3 -3l-3 2v-10\" />\n  <path d=\"M6 10h.01\" />"),
    TOILET_PAPER_OFF(
        "toilet-paper-off",
        "<path d=\"M4.27 4.28c-.768 1.27 -1.27 3.359 -1.27 5.72c0 3.866 1.343 7 3 7s3 -3.134 3 -7c0 -.34 -.01 -.672 -.03 -1\" />\n  <path d=\"M21 10c0 -3.866 -1.343 -7 -3 -7\" />\n  <path d=\"M7 3h11\" />\n  <path d=\"M21 10v7m-1.513 2.496l-1.487 -.496l-3 2l-3 -3l-3 2v-10\" />\n  <path d=\"M6 10h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    TOOL(
        "tool",
        "<path d=\"M7 10h3v-3l-3.5 -3.5a6 6 0 0 1 8 8l6 6a2 2 0 0 1 -3 3l-6 -6a6 6 0 0 1 -8 -8l3.5 3.5\" />"),
    TOOLTIP(
        "tooltip",
        "<path d=\"M10 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M12 13l-1.707 -1.707a1 1 0 0 0 -.707 -.293h-2.586a2 2 0 0 1 -2 -2v-3a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-2.586a1 1 0 0 0 -.707 .293l-1.707 1.707\" />"),
    TRANSFER("transfer", "<path d=\"M20 10h-16l5.5 -6\" />\n  <path d=\"M4 14h16l-5.5 6\" />"),
    TRANSFER_VERTICAL(
        "transfer-vertical", "<path d=\"M10 4v16l-6 -5.5\" />\n  <path d=\"M14 20v-16l6 5.5\" />"),
    TRANSFORM(
        "transform",
        "<path d=\"M3 6a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M21 11v-3a2 2 0 0 0 -2 -2h-6l3 3m0 -6l-3 3\" />\n  <path d=\"M3 13v3a2 2 0 0 0 2 2h6l-3 -3m0 6l3 -3\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    TRANSFORM_POINT(
        "transform-point",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M5 11v2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M11 19h2\" />"),
    TRANSFORM_POINT_BOTTOM_LEFT(
        "transform-point-bottom-left",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" fill=\"currentColor\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M5 11v2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M11 19h2\" />"),
    TRANSFORM_POINT_BOTTOM_RIGHT(
        "transform-point-bottom-right",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" fill=\"currentColor\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M5 11v2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M11 19h2\" />"),
    TRANSFORM_POINT_TOP_LEFT(
        "transform-point-top-left",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" fill=\"currentColor\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M5 11v2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M11 19h2\" />"),
    TRANSFORM_POINT_TOP_RIGHT(
        "transform-point-top-right",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M3 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M17 4a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" fill=\"currentColor\" />\n  <path d=\"M17 18a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M5 11v2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M11 19h2\" />"),
    TRASH(
        "trash",
        "<path d=\"M4 7l16 0\" />\n  <path d=\"M10 11l0 6\" />\n  <path d=\"M14 11l0 6\" />\n  <path d=\"M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12\" />\n  <path d=\"M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3\" />"),
    TRASH_OFF(
        "trash-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M4 7h3m4 0h9\" />\n  <path d=\"M10 11l0 6\" />\n  <path d=\"M14 14l0 3\" />\n  <path d=\"M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l.077 -.923\" />\n  <path d=\"M18.384 14.373l.616 -7.373\" />\n  <path d=\"M9 5v-1a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3\" />"),
    TRASH_X(
        "trash-x",
        "<path d=\"M4 7h16\" />\n  <path d=\"M5 7l1 12a2 2 0 0 0 2 2h8a2 2 0 0 0 2 -2l1 -12\" />\n  <path d=\"M9 7v-3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v3\" />\n  <path d=\"M10 12l4 4m0 -4l-4 4\" />"),
    TROWEL(
        "trowel",
        "<path d=\"M14.42 9.058l-5.362 5.363a1.978 1.978 0 0 1 -3.275 -.773l-2.682 -8.044a1.978 1.978 0 0 1 2.502 -2.502l8.045 2.682a1.978 1.978 0 0 1 .773 3.274\" />\n  <path d=\"M10 10l6.5 6.5\" />\n  <path d=\"M19.347 16.575l1.08 1.079a1.96 1.96 0 0 1 -2.773 2.772l-1.08 -1.079a1.96 1.96 0 0 1 2.773 -2.772\" />"),
    UFO_OFF(
        "ufo-off",
        "<path d=\"M16.95 9.01c3.02 .739 5.05 2.123 5.05 3.714c0 1.08 -.931 2.063 -2.468 2.814m-3 1c-1.36 .295 -2.9 .462 -4.531 .462c-5.52 0 -10 -1.909 -10 -4.276c0 -1.59 2.04 -2.985 5.07 -3.724\" />\n  <path d=\"M14.69 10.686c1.388 -.355 2.31 -.976 2.31 -1.686v-.035c0 -2.742 -2.239 -4.965 -5 -4.965c-1.125 0 -2.164 .37 -3 .992m-1.707 2.297a4.925 4.925 0 0 0 -.293 1.676v.035c0 .961 1.696 1.764 3.956 1.956\" />\n  <path d=\"M15 17l2 3\" />\n  <path d=\"M8.5 17l-1.5 3\" />\n  <path d=\"M12 14h.01\" />\n  <path d=\"M7 13h.01\" />\n  <path d=\"M17 13h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    UHD(
        "uhd",
        "<path d=\"M10 16v-8\" />\n  <path d=\"M10 12h4\" />\n  <path d=\"M14 8v8\" />\n  <path d=\"M17 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2l-2 0\" />\n  <path d=\"M3 8v6a2 2 0 1 0 4 0v-6\" />"),
    UMBRELLA(
        "umbrella",
        "<path d=\"M4 12a8 8 0 0 1 16 0l-16 0\" />\n  <path d=\"M12 12v6a2 2 0 0 0 4 0\" />"),
    UMBRELLA_2(
        "umbrella-2",
        "<path d=\"M5.343 7.343a8 8 0 1 1 11.314 11.314l-11.314 -11.314\" />\n  <path d=\"M10.828 13.34l-4.242 4.243a2 2 0 1 0 2.828 2.828\" />"),
    UMBRELLA_CLOSED(
        "umbrella-closed",
        "<path d=\"M9 16l3 -13l3 13l-6 0\" />\n  <path d=\"M12 16v3c0 2.667 4 2.667 4 0\" />"),
    UMBRELLA_CLOSED_2(
        "umbrella-closed-2",
        "<path d=\"M6.697 12.071l11.313 -7.071l-7.07 11.314l-4.243 -4.243\" />\n  <path d=\"M8.743 14.475l-2.121 2.121c-1.886 1.886 .943 4.715 2.828 2.829\" />"),
    UMBRELLA_OFF(
        "umbrella-off",
        "<path d=\"M12 12h-8c0 -2.209 .895 -4.208 2.342 -5.656m2.382 -1.645a8 8 0 0 1 11.276 7.301l-4 0\" />\n  <path d=\"M12 12v6a2 2 0 1 0 4 0\" />\n  <path d=\"M3 3l18 18\" />"),
    UNIVERSE(
        "universe",
        "<path d=\"M7.027 11.477a5 5 0 1 0 5.496 -4.45a4.951 4.951 0 0 0 -3.088 .681\" />\n  <path d=\"M5.636 5.636a9 9 0 1 0 3.555 -2.188\" />\n  <path d=\"M17 5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    URGENT(
        "urgent",
        "<path d=\"M8 16v-4a4 4 0 0 1 8 0v4\" />\n  <path d=\"M3 12h1m8 -9v1m8 8h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7\" />\n  <path d=\"M6 17a1 1 0 0 1 1 -1h10a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1l0 -2\" />"),
    USB(
        "usb",
        "<path d=\"M10 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M12 17v-11.5\" />\n  <path d=\"M7 10v3l5 3\" />\n  <path d=\"M12 14.5l5 -2v-2.5\" />\n  <path d=\"M16 10h2v-2h-2l0 2\" />\n  <path d=\"M6 9a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M10 5.5h4l-2 -2.5l-2 2.5\" />"),
    USER(
        "user",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2\" />"),
    USER_BITCOIN(
        "user-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3\" />"),
    USER_BOLT(
        "user-bolt",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4c.267 0 .529 .026 .781 .076\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    USER_CANCEL(
        "user-cancel",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    USER_CHECK(
        "user-check",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    USER_CIRCLE(
        "user-circle",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M6.168 18.849a4 4 0 0 1 3.832 -2.849h4a4 4 0 0 1 3.834 2.855\" />"),
    USER_CODE(
        "user-code",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    USER_COG(
        "user-cog",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h2.5\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    USER_DOLLAR(
        "user-dollar",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    USER_DOWN(
        "user-down",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4c.342 0 .674 .043 .99 .124\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    USER_EDIT(
        "user-edit",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    USER_EXCLAMATION(
        "user-exclamation",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4c.348 0 .686 .045 1.008 .128\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    USER_HEART(
        "user-heart",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h.5\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    USER_HEXAGON(
        "user-hexagon",
        "<path d=\"M12 13a3 3 0 1 0 0 -6a3 3 0 0 0 0 6\" />\n  <path d=\"M6.201 18.744a4 4 0 0 1 3.799 -2.744h4a4 4 0 0 1 3.798 2.741\" />\n  <path d=\"M19.875 6.27c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />"),
    USER_MINUS(
        "user-minus",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4c.348 0 .686 .045 1.009 .128\" />\n  <path d=\"M16 19h6\" />"),
    USER_OFF(
        "user-off",
        "<path d=\"M8.18 8.189a4.01 4.01 0 0 0 2.616 2.627m3.507 -.545a4 4 0 1 0 -5.59 -5.552\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4c.412 0 .81 .062 1.183 .178m2.633 2.618c.12 .38 .184 .785 .184 1.204v2\" />\n  <path d=\"M3 3l18 18\" />"),
    USER_PAUSE(
        "user-pause",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    USER_PENTAGON(
        "user-pentagon",
        "<path d=\"M13.163 2.168l8.021 5.828c.694 .504 .984 1.397 .719 2.212l-3.064 9.43a1.978 1.978 0 0 1 -1.881 1.367h-9.916a1.978 1.978 0 0 1 -1.881 -1.367l-3.064 -9.43a1.978 1.978 0 0 1 .719 -2.212l8.021 -5.828a1.978 1.978 0 0 1 2.326 0\" />\n  <path d=\"M12 13a3 3 0 1 0 0 -6a3 3 0 0 0 0 6\" />\n  <path d=\"M6 20.703v-.703a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v.707\" />"),
    USER_PIN(
        "user-pin",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h2.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    USER_PLUS(
        "user-plus",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4\" />"),
    USER_QUESTION(
        "user-question",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    USER_SCAN(
        "user-scan",
        "<path d=\"M10 9a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M8 16a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    USER_SEARCH(
        "user-search",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h1.5\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    USER_SHARE(
        "user-share",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    USER_SHIELD(
        "user-shield",
        "<path d=\"M6 21v-2a4 4 0 0 1 4 -4h2\" />\n  <path d=\"M22 16c0 4 -2.5 6 -3.5 6s-3.5 -2 -3.5 -6c1 0 2.5 -.5 3.5 -1.5c1 1 2.5 1.5 3.5 1.5\" />\n  <path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />"),
    USER_SQUARE(
        "user-square",
        "<path d=\"M9 10a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M6 21v-1a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v1\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />"),
    USER_SQUARE_ROUNDED(
        "user-square-rounded",
        "<path d=\"M12 13a3 3 0 1 0 0 -6a3 3 0 0 0 0 6\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />\n  <path d=\"M6 20.05v-.05a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v.05\" />"),
    USER_STAR(
        "user-star",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h.5\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    USER_UP(
        "user-up",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h4\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    USER_X(
        "user-x",
        "<path d=\"M8 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M6 21v-2a4 4 0 0 1 4 -4h3.5\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    USERS(
        "users",
        "<path d=\"M5 7a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M3 21v-2a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v2\" />\n  <path d=\"M16 3.13a4 4 0 0 1 0 7.75\" />\n  <path d=\"M21 21v-2a4 4 0 0 0 -3 -3.85\" />"),
    USERS_GROUP(
        "users-group",
        "<path d=\"M10 13a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M8 21v-1a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2v1\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M17 10h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M5 5a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M3 13v-1a2 2 0 0 1 2 -2h2\" />"),
    USERS_MINUS(
        "users-minus",
        "<path d=\"M5 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M3 21v-2a4 4 0 0 1 4 -4h4c.948 0 1.818 .33 2.504 .88\" />\n  <path d=\"M16 3.13a4 4 0 0 1 0 7.75\" />\n  <path d=\"M16 19h6\" />"),
    USERS_PLUS(
        "users-plus",
        "<path d=\"M5 7a4 4 0 1 0 8 0a4 4 0 0 0 -8 0\" />\n  <path d=\"M3 21v-2a4 4 0 0 1 4 -4h4c.96 0 1.84 .338 2.53 .901\" />\n  <path d=\"M16 3.13a4 4 0 0 1 0 7.75\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    VACUUM_CLEANER(
        "vacuum-cleaner",
        "<path d=\"M21 12a9 9 0 1 1 -18 0a9 9 0 0 1 18 0\" />\n  <path d=\"M14 9a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M12 16h.01\" />"),
    VAULT(
        "vault",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9.75 9.75l-1.75 -1.75\" />\n  <path d=\"M14.25 9.75l1.75 -1.75\" />\n  <path d=\"M14.25 14.25l1.75 1.75\" />\n  <path d=\"M9.75 14.25l-1.75 1.75\" />"),
    VIEW_360(
        "view-360",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M8 12a4 9 0 1 0 8 0a4 9 0 1 0 -8 0\" />\n  <path d=\"M3 12c0 2.21 4.03 4 9 4s9 -1.79 9 -4s-4.03 -4 -9 -4s-9 1.79 -9 4\" />"),
    VIEW_360_ARROW(
        "view-360-arrow",
        "<path d=\"M17 15.328c2.414 -.718 4 -1.94 4 -3.328c0 -2.21 -4.03 -4 -9 -4s-9 1.79 -9 4s4.03 4 9 4\" />\n  <path d=\"M9 13l3 3l-3 3\" />"),
    VIEW_360_NUMBER(
        "view-360-number",
        "<path d=\"M14 6a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-3\" />\n  <path d=\"M3 5h2.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-1.5h1.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-2.5\" />\n  <path d=\"M17 7v4a2 2 0 1 0 4 0v-4a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 16c0 1.657 4.03 3 9 3s9 -1.343 9 -3\" />"),
    VIEW_360_OFF(
        "view-360-off",
        "<path d=\"M8.335 8.388a19 19 0 0 0 -.335 3.612c0 4.97 1.79 9 4 9c1.622 0 3.018 -2.172 3.646 -5.294m.354 -3.706c0 -4.97 -1.79 -9 -4 -9c-1.035 0 -1.979 .885 -2.689 2.337\" />\n  <path d=\"M5.65 5.623a9 9 0 1 0 12.71 12.745m1.684 -2.328a9 9 0 0 0 -12.094 -12.08\" />\n  <path d=\"M8.32 8.349c-3.136 .625 -5.32 2.025 -5.32 3.651c0 2.21 4.03 4 9 4c1.286 0 2.51 -.12 3.616 -.336m3.059 -.98c1.445 -.711 2.325 -1.653 2.325 -2.684c0 -2.21 -4.03 -4 -9 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    VIEWPORT_SHORT(
        "viewport-short",
        "<path d=\"M12 3v7l3 -3\" />\n  <path d=\"M9 7l3 3\" />\n  <path d=\"M12 21v-7l3 3\" />\n  <path d=\"M9 17l3 -3\" />\n  <path d=\"M18 9h1a2 2 0 0 1 2 2v2a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M6 9h-1a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h1\" />"),
    VIEWPORT_TALL(
        "viewport-tall",
        "<path d=\"M12 10v-7l3 3\" />\n  <path d=\"M9 6l3 -3\" />\n  <path d=\"M12 14v7l3 -3\" />\n  <path d=\"M9 18l3 3\" />\n  <path d=\"M18 3h1a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M6 3h-1a2 2 0 0 0 -2 2v14a2 2 0 0 0 2 2h1\" />"),
    VIP(
        "vip",
        "<path d=\"M3 5h18\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M4 9l2 6h1l2 -6\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M16 15v-6h2a2 2 0 1 1 0 4h-2\" />"),
    VIP_2(
        "vip-2",
        "<path d=\"M3 5h4\" />\n  <path d=\"M17 5h4\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M4 9l2 6h1l2 -6\" />\n  <path d=\"M12 10v5\" />\n  <path d=\"M16 15v-6h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M10 5a2 2 0 0 1 2 2a2 2 0 0 1 2 -2a2 2 0 0 1 -2 -2a2 2 0 0 1 -2 2\" />"),
    VIP_OFF(
        "vip-off",
        "<path d=\"M3 5h2m4 0h12\" />\n  <path d=\"M3 19h16\" />\n  <path d=\"M4 9l2 6h1l2 -6\" />\n  <path d=\"M12 12v3\" />\n  <path d=\"M16 12v-3h2a2 2 0 1 1 0 4h-1\" />\n  <path d=\"M3 3l18 18\" />"),
    VIRTUAL_SPACE(
        "virtual-space",
        "<path d=\"M16 14.808a25 25 0 0 0 -4 -.312c-1.439 0 -2.796 .113 -4 .312\" />\n  <path d=\"M21 17.439c0 1.148 -2.034 2.142 -4.997 2.625l-.003 -10.439c2.965 -.482 5 -1.477 5 -2.625v-.064c0 -1.622 -4.03 -2.936 -9 -2.936s-9 1.314 -9 2.936c0 1.148 2.035 2.142 5 2.624l-.003 10.44c-2.963 -.483 -4.997 -1.477 -4.997 -2.625\" />\n  <path d=\"M3 6.936v10.439\" />\n  <path d=\"M21 6.936v10.439\" />"),
    VS(
        "vs",
        "<path d=\"M2 12c0 5.523 4.477 10 10 10s10 -4.477 10 -10s-4.477 -10 -10 -10s-10 4.477 -10 10\" />\n  <path d=\"M14 14.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M7 9l2 6l2 -6\" />"),
    WALLPAPER(
        "wallpaper",
        "<path d=\"M8 6h10a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-12\" />\n  <path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M8 18v-12a2 2 0 1 0 -4 0v12\" />"),
    WALLPAPER_OFF(
        "wallpaper-off",
        "<path d=\"M10 6h8a2 2 0 0 1 2 2v8m-.58 3.409a2 2 0 0 1 -1.42 .591h-12\" />\n  <path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M8 18v-10m-3.427 -3.402c-.353 .362 -.573 .856 -.573 1.402v12\" />\n  <path d=\"M3 3l18 18\" />"),
    WAND(
        "wand",
        "<path d=\"M6 21l15 -15l-3 -3l-15 15l3 3\" />\n  <path d=\"M15 6l3 3\" />\n  <path d=\"M9 3a2 2 0 0 0 2 2a2 2 0 0 0 -2 2a2 2 0 0 0 -2 -2a2 2 0 0 0 2 -2\" />\n  <path d=\"M19 13a2 2 0 0 0 2 2a2 2 0 0 0 -2 2a2 2 0 0 0 -2 -2a2 2 0 0 0 2 -2\" />"),
    WAND_OFF(
        "wand-off",
        "<path d=\"M10.5 10.5l-7.5 7.5l3 3l7.5 -7.5m2 -2l5.5 -5.5l-3 -3l-5.5 5.5\" />\n  <path d=\"M15 6l3 3\" />\n  <path d=\"M8.433 4.395c.35 -.36 .567 -.852 .567 -1.395a2 2 0 0 0 2 2c-.554 0 -1.055 .225 -1.417 .589\" />\n  <path d=\"M18.418 14.41c.36 -.36 .582 -.86 .582 -1.41a2 2 0 0 0 2 2c-.555 0 -1.056 .226 -1.419 .59\" />\n  <path d=\"M3 3l18 18\" />"),
    WAVE_SAW_TOOL("wave-saw-tool", "<path d=\"M3 12h5l4 8v-16l4 8h5\" />"),
    WAVE_SINE(
        "wave-sine",
        "<path d=\"M21 12h-2c-.894 0 -1.662 -.857 -1.761 -2c-.296 -3.45 -.749 -6 -2.749 -6s-2.5 3.582 -2.5 8s-.5 8 -2.5 8s-2.452 -2.547 -2.749 -6c-.1 -1.147 -.867 -2 -1.763 -2h-2\" />"),
    WAVE_SQUARE("wave-square", "<path d=\"M3 12h5v8h4v-16h4v8h5\" />"),
    WAVES_ELECTRICITY(
        "waves-electricity",
        "<path d=\"M3 12c.576 -.643 1.512 -1.017 2.5 -1c.988 -.017 1.924 .357 2.5 1c.576 .643 1.512 1.017 2.5 1c.988 .017 1.924 -.357 2.5 -1\" />\n  <path d=\"M3 16c.576 -.643 1.512 -1.017 2.5 -1c.988 -.017 1.924 .357 2.5 1c.576 .643 1.512 1.017 2.5 1c.988 .017 1.924 -.357 2.5 -1\" />\n  <path d=\"M3 8c.576 -.643 1.512 -1.017 2.5 -1c.988 -.017 1.924 .357 2.5 1c.576 .643 1.512 1.017 2.5 1c.988 .017 1.924 -.357 2.5 -1\" />\n  <path d=\"M20 7l-3 5h4l-3 5\" />"),
    WEIGHT(
        "weight",
        "<path d=\"M9 6a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M6.835 9h10.33a1 1 0 0 1 .984 .821l1.637 9a1 1 0 0 1 -.984 1.179h-13.604a1 1 0 0 1 -.984 -1.179l1.637 -9a1 1 0 0 1 .984 -.821\" />"),
    WINDOW_MAXIMIZE(
        "window-maximize",
        "<path d=\"M3 17a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M4 12v-6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-6\" />\n  <path d=\"M12 8h4v4\" />\n  <path d=\"M16 8l-5 5\" />"),
    WINDOW_MINIMIZE(
        "window-minimize",
        "<path d=\"M3 17a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M4 12v-6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-6\" />\n  <path d=\"M15 13h-4v-4\" />\n  <path d=\"M11 13l5 -5\" />"),
    WOMAN(
        "woman",
        "<path d=\"M10 16v5\" />\n  <path d=\"M14 16v5\" />\n  <path d=\"M8 16h8l-2 -7h-4l-2 7\" />\n  <path d=\"M5 11c1.667 -1.333 3.333 -2 5 -2\" />\n  <path d=\"M19 11c-1.667 -1.333 -3.333 -2 -5 -2\" />\n  <path d=\"M10 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    WOOD(
        "wood",
        "<path d=\"M6 5.5a6 2.5 0 1 0 12 0a6 2.5 0 1 0 -12 0\" />\n  <path d=\"M18 5.5v4.626a1.415 1.415 0 0 1 1.683 2.18l-.097 .108l-1.586 1.586v4c0 1.61 -2.54 2.925 -5.725 3l-.275 0c-3.314 0 -6 -1.343 -6 -3v-2l-1.586 -1.586a1.414 1.414 0 0 1 1.586 -2.287v-6.627\" />\n  <path d=\"M10 12.5v1.5\" />\n  <path d=\"M14 16v1\" />"),
    X("x", "<path d=\"M18 6l-12 12\" />\n  <path d=\"M6 6l12 12\" />"),
    X_MARK(
        "x-mark",
        "<path d=\"M12 16l3.644 3.644a1.21 1.21 0 0 0 1.712 0l2.288 -2.288a1.21 1.21 0 0 0 0 -1.712l-3.644 -3.644l3.644 -3.644a1.21 1.21 0 0 0 0 -1.712l-2.288 -2.288a1.21 1.21 0 0 0 -1.712 0l-3.644 3.644l-3.644 -3.644a1.21 1.21 0 0 0 -1.712 0l-2.288 2.288a1.21 1.21 0 0 0 0 1.712l3.644 3.644l-3.644 3.644a1.21 1.21 0 0 0 0 1.712l2.288 2.288a1.21 1.21 0 0 0 1.712 0l3.644 -3.644\" />"),
    XD(
        "xd",
        "<path d=\"M6 8l4 8\" />\n  <path d=\"M6 16l4 -8\" />\n  <path d=\"M14 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2h-2\" />"),
    XXX(
        "xxx",
        "<path d=\"M10 8l4 8\" />\n  <path d=\"M10 16l4 -8\" />\n  <path d=\"M17 8l4 8\" />\n  <path d=\"M17 16l4 -8\" />\n  <path d=\"M3 8l4 8\" />\n  <path d=\"M3 16l4 -8\" />"),
    ZOOM_SCAN(
        "zoom-scan",
        "<path d=\"M8 11a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M16 16l-2.5 -2.5\" />\n  <path d=\"M3 7v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 17v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2 -2v-2\" />"),
    ZZZ("zzz", "<path d=\"M4 12h6l-6 8h6\" />\n  <path d=\"M14 4h6l-6 8h6\" />"),
    ZZZ_OFF(
        "zzz-off",
        "<path d=\"M4 12h6l-6 8h6\" />\n  <path d=\"M14 4h6l-5.146 6.862m1.146 1.138h4\" />\n  <path d=\"M3 3l18 18\" />");

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
    AD_CIRCLE(
        "ad-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10c-5.43 0 -9.848 -4.327 -9.996 -9.72l-.004 -.28l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72zm-3.5 6a2.5 2.5 0 0 0 -2.495 2.336l-.005 .164v4.5l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-1h1v1l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4.5l-.005 -.164a2.5 2.5 0 0 0 -2.495 -2.336zm6.5 0h-1a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h1a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3zm0 2a1 1 0 0 1 1 1v2a1 1 0 0 1 -.883 .993l-.117 .007v-4zm-6.5 0a.5 .5 0 0 1 .492 .41l.008 .09v1.5h-1v-1.5l.008 -.09a.5 .5 0 0 1 .492 -.41z\" />"),
    ADJUSTMENTS(
        "adjustments",
        "<path d=\"M6 3a1 1 0 0 1 .993 .883l.007 .117v3.171a3.001 3.001 0 0 1 0 5.658v7.171a1 1 0 0 1 -1.993 .117l-.007 -.117v-7.17a3.002 3.002 0 0 1 -1.995 -2.654l-.005 -.176l.005 -.176a3.002 3.002 0 0 1 1.995 -2.654v-3.17a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 3a1 1 0 0 1 .993 .883l.007 .117v9.171a3.001 3.001 0 0 1 0 5.658v1.171a1 1 0 0 1 -1.993 .117l-.007 -.117v-1.17a3.002 3.002 0 0 1 -1.995 -2.654l-.005 -.176l.005 -.176a3.002 3.002 0 0 1 1.995 -2.654v-9.17a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 3a1 1 0 0 1 .993 .883l.007 .117v.171a3.001 3.001 0 0 1 0 5.658v10.171a1 1 0 0 1 -1.993 .117l-.007 -.117v-10.17a3.002 3.002 0 0 1 -1.995 -2.654l-.005 -.176l.005 -.176a3.002 3.002 0 0 1 1.995 -2.654v-.17a1 1 0 0 1 1 -1z\" />"),
    ADJUSTMENTS_HORIZONTAL(
        "adjustments-horizontal",
        "<path d=\"M17 15c1.306 0 2.418 .835 2.83 2h.17a1 1 0 0 1 0 2h-.171a3.001 3.001 0 0 1 -5.658 0h-10.171a1 1 0 0 1 0 -2h10.173c.41 -1.165 1.52 -2 2.827 -2m-9 -6c1.306 0 2.418 .835 2.83 2h9.17a1 1 0 0 1 0 2h-9.171a3.001 3.001 0 0 1 -5.658 0h-1.171a1 1 0 0 1 0 -2h1.173c.41 -1.165 1.52 -2 2.827 -2m6 -6c1.306 0 2.418 .835 2.83 2h3.17a1 1 0 0 1 0 2h-3.171a3.001 3.001 0 0 1 -5.658 0h-7.171a1 1 0 1 1 0 -2h7.173c.41 -1.165 1.52 -2 2.827 -2\" />"),
    AFFILIATE(
        "affiliate",
        "<path d=\"M18.5 3a2.5 2.5 0 1 1 -.912 4.828l-4.556 4.555a5.475 5.475 0 0 1 .936 3.714l2.624 .787a2.5 2.5 0 1 1 -.575 1.916l-2.623 -.788a5.5 5.5 0 0 1 -10.39 -2.29l-.004 -.222l.004 -.221a5.5 5.5 0 0 1 2.984 -4.673l-.788 -2.624a2.498 2.498 0 0 1 -2.194 -2.304l-.006 -.178l.005 -.164a2.5 2.5 0 1 1 4.111 2.071l.787 2.625a5.475 5.475 0 0 1 3.714 .936l4.555 -4.556a2.487 2.487 0 0 1 -.167 -.748l-.005 -.164l.005 -.164a2.5 2.5 0 0 1 2.495 -2.336z\" />"),
    ALARM(
        "alarm",
        "<path d=\"M16 6.072a8 8 0 1 1 -11.995 7.213l-.005 -.285l.005 -.285a8 8 0 0 1 11.995 -6.643zm-4 2.928a1 1 0 0 0 -1 1v3l.007 .117a1 1 0 0 0 .993 .883h2l.117 -.007a1 1 0 0 0 .883 -.993l-.007 -.117a1 1 0 0 0 -.993 -.883h-1v-2l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />\n  <path d=\"M6.412 3.191a1 1 0 0 1 1.273 1.539l-.097 .08l-2.75 2a1 1 0 0 1 -1.273 -1.54l.097 -.08l2.75 -2z\" />\n  <path d=\"M16.191 3.412a1 1 0 0 1 1.291 -.288l.106 .067l2.75 2a1 1 0 0 1 -1.07 1.685l-.106 -.067l-2.75 -2a1 1 0 0 1 -.22 -1.397z\" />"),
    ALARM_MINUS(
        "alarm-minus",
        "<path d=\"M16 6.072a8 8 0 1 1 -11.995 7.213l-.005 -.285l.005 -.285a8 8 0 0 1 11.995 -6.643zm-2 5.928h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />\n  <path d=\"M6.412 3.191a1 1 0 0 1 1.273 1.539l-.097 .08l-2.75 2a1 1 0 0 1 -1.273 -1.54l.097 -.08l2.75 -2z\" />\n  <path d=\"M16.191 3.412a1 1 0 0 1 1.291 -.288l.106 .067l2.75 2a1 1 0 0 1 -1.07 1.685l-.106 -.067l-2.75 -2a1 1 0 0 1 -.22 -1.397z\" />"),
    ALARM_PLUS(
        "alarm-plus",
        "<path d=\"M16 6.072a8 8 0 1 1 -11.995 7.213l-.005 -.285l.005 -.285a8 8 0 0 1 11.995 -6.643zm-4 3.928a1 1 0 0 0 -1 1v1h-1l-.117 .007a1 1 0 0 0 .117 1.993h1v1l.007 .117a1 1 0 0 0 1.993 -.117v-1h1l.117 -.007a1 1 0 0 0 -.117 -1.993h-1v-1l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />\n  <path d=\"M6.412 3.191a1 1 0 0 1 1.273 1.539l-.097 .08l-2.75 2a1 1 0 0 1 -1.273 -1.54l.097 -.08l2.75 -2z\" />\n  <path d=\"M16.191 3.412a1 1 0 0 1 1.291 -.288l.106 .067l2.75 2a1 1 0 0 1 -1.07 1.685l-.106 -.067l-2.75 -2a1 1 0 0 1 -.22 -1.397z\" />"),
    ALARM_SNOOZE(
        "alarm-snooze",
        "<path d=\"M16 6.072a8 8 0 1 1 -11.995 7.213l-.005 -.285l.005 -.285a8 8 0 0 1 11.995 -6.643zm-2 3.928h-4l-.117 .007a1 1 0 0 0 -.883 .993l.007 .117a1 1 0 0 0 .993 .883h1.584l-2.291 2.293l-.076 .084c-.514 .637 -.07 1.623 .783 1.623h4l.117 -.007a1 1 0 0 0 .883 -.993l-.007 -.117a1 1 0 0 0 -.993 -.883h-1.586l2.293 -2.293l.076 -.084c.514 -.637 .07 -1.623 -.783 -1.623z\" />\n  <path d=\"M6.412 3.191a1 1 0 0 1 1.273 1.539l-.097 .08l-2.75 2a1 1 0 0 1 -1.273 -1.54l.097 -.08l2.75 -2z\" />\n  <path d=\"M16.191 3.412a1 1 0 0 1 1.291 -.288l.106 .067l2.75 2a1 1 0 0 1 -1.07 1.685l-.106 -.067l-2.75 -2a1 1 0 0 1 -.22 -1.397z\" />"),
    ALERT_CIRCLE(
        "alert-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -19.995 .324l-.005 -.324l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72zm.01 13l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -8a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALERT_HEXAGON(
        "alert-hexagon",
        "<path d=\"M10.425 1.414a3.33 3.33 0 0 1 3.026 -.097l.19 .097l6.775 3.995l.096 .063l.092 .077l.107 .075a3.224 3.224 0 0 1 1.266 2.188l.018 .202l.005 .204v7.284c0 1.106 -.57 2.129 -1.454 2.693l-.17 .1l-6.803 4.302c-.918 .504 -2.019 .535 -3.004 .068l-.196 -.1l-6.695 -4.237a3.225 3.225 0 0 1 -1.671 -2.619l-.007 -.207v-7.285c0 -1.106 .57 -2.128 1.476 -2.705l6.95 -4.098zm1.585 13.586l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -8a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALERT_OCTAGON(
        "alert-octagon",
        "<path d=\"M14.897 1a4 4 0 0 1 2.664 1.016l.165 .156l4.1 4.1a4 4 0 0 1 1.168 2.605l.006 .227v5.794a4 4 0 0 1 -1.016 2.664l-.156 .165l-4.1 4.1a4 4 0 0 1 -2.603 1.168l-.227 .006h-5.795a3.999 3.999 0 0 1 -2.664 -1.017l-.165 -.156l-4.1 -4.1a4 4 0 0 1 -1.168 -2.604l-.006 -.227v-5.794a4 4 0 0 1 1.016 -2.664l.156 -.165l4.1 -4.1a4 4 0 0 1 2.605 -1.168l.227 -.006h5.793zm-2.887 14l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -8a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALERT_SQUARE(
        "alert-square",
        "<path d=\"M19 2a3 3 0 0 1 2.995 2.824l.005 .176v14a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h14zm-6.99 13l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -8a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALERT_SQUARE_ROUNDED(
        "alert-square-rounded",
        "<path d=\"M12 2l.642 .005l.616 .017l.299 .013l.579 .034l.553 .046c4.687 .455 6.65 2.333 7.166 6.906l.03 .29l.046 .553l.041 .727l.006 .15l.017 .617l.005 .642l-.005 .642l-.017 .616l-.013 .299l-.034 .579l-.046 .553c-.455 4.687 -2.333 6.65 -6.906 7.166l-.29 .03l-.553 .046l-.727 .041l-.15 .006l-.617 .017l-.642 .005l-.642 -.005l-.616 -.017l-.299 -.013l-.579 -.034l-.553 -.046c-4.687 -.455 -6.65 -2.333 -7.166 -6.906l-.03 -.29l-.046 -.553l-.041 -.727l-.006 -.15l-.017 -.617l-.004 -.318v-.648l.004 -.318l.017 -.616l.013 -.299l.034 -.579l.046 -.553c.455 -4.687 2.333 -6.65 6.906 -7.166l.29 -.03l.553 -.046l.727 -.041l.15 -.006l.617 -.017c.21 -.003 .424 -.005 .642 -.005zm.01 13l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -8a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALERT_TRIANGLE(
        "alert-triangle",
        "<path d=\"M12 1.67c.955 0 1.845 .467 2.39 1.247l.105 .16l8.114 13.548a2.914 2.914 0 0 1 -2.307 4.363l-.195 .008h-16.225a2.914 2.914 0 0 1 -2.582 -4.2l.099 -.185l8.11 -13.538a2.914 2.914 0 0 1 2.491 -1.403zm.01 13.33l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-.01 -7a1 1 0 0 0 -.993 .883l-.007 .117v4l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ANALYZE(
        "analyze",
        "<path d=\"M4.99 12.862a7.1 7.1 0 0 0 12.171 3.924a1.956 1.956 0 0 1 -.156 -.637l-.005 -.149l.005 -.15a2 2 0 1 1 1.769 2.137a9.099 9.099 0 0 1 -15.764 -4.85a1 1 0 0 1 1.98 -.275z\" />\n  <path d=\"M12 8a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M13.142 3.09a9.1 9.1 0 0 1 7.848 7.772a1 1 0 0 1 -1.98 .276a7.1 7.1 0 0 0 -6.125 -6.064a7.096 7.096 0 0 0 -6.048 2.136a2 2 0 1 1 -3.831 .939l-.006 -.149l.005 -.15a2 2 0 0 1 2.216 -1.838a9.094 9.094 0 0 1 7.921 -2.922z\" />"),
    APP_WINDOW(
        "app-window",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-12.99 3l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993zm3 0l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    BELL(
        "bell",
        "<path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004z\" />"),
    BELL_MINUS(
        "bell-minus",
        "<path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004zm2 8h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    BELL_PLUS(
        "bell-plus",
        "<path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004zm0 6a1 1 0 0 0 -1 1v1h-1l-.117 .007a1 1 0 0 0 .117 1.993h1v1l.007 .117a1 1 0 0 0 1.993 -.117v-1h1l.117 -.007a1 1 0 0 0 -.117 -1.993h-1v-1l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BELL_RINGING(
        "bell-ringing",
        "<path d=\"M17.451 2.344a1 1 0 0 1 1.41 -.099a12.05 12.05 0 0 1 3.048 4.064a1 1 0 1 1 -1.818 .836a10.05 10.05 0 0 0 -2.54 -3.39a1 1 0 0 1 -.1 -1.41z\" />\n  <path d=\"M5.136 2.245a1 1 0 0 1 1.312 1.51a10.05 10.05 0 0 0 -2.54 3.39a1 1 0 1 1 -1.817 -.835a12.05 12.05 0 0 1 3.045 -4.065z\" />\n  <path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004z\" />"),
    BELL_RINGING_2(
        "bell-ringing-2",
        "<path d=\"M9.63 17.531c.612 .611 .211 1.658 -.652 1.706a3.992 3.992 0 0 1 -3.05 -1.166a3.992 3.992 0 0 1 -1.165 -3.049c.046 -.826 1.005 -1.228 1.624 -.726l.082 .074l3.161 3.16z\" />\n  <path d=\"M20.071 3.929c.96 .96 1.134 2.41 .52 3.547l-.09 .153l-.024 .036a8.013 8.013 0 0 1 -1.446 7.137l-.183 .223l-.191 .218l-2.073 2.072l-.08 .112a3 3 0 0 0 -.499 2.113l.035 .201l.045 .185c.264 .952 -.853 1.645 -1.585 1.051l-.086 -.078l-11.313 -11.313c-.727 -.727 -.017 -1.945 .973 -1.671a3 3 0 0 0 2.5 -.418l.116 -.086l2.101 -2.1a8 8 0 0 1 7.265 -1.86l.278 .071l.037 -.023a3.003 3.003 0 0 1 3.432 .192l.14 .117l.128 .12z\" />"),
    BELL_X(
        "bell-x",
        "<path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004zm-1.489 6.14a1 1 0 0 0 -1.218 1.567l1.292 1.293l-1.292 1.293l-.083 .094a1 1 0 0 0 1.497 1.32l1.293 -1.292l1.293 1.292l.094 .083a1 1 0 0 0 1.32 -1.497l-1.292 -1.293l1.292 -1.293l.083 -.094a1 1 0 0 0 -1.497 -1.32l-1.293 1.292l-1.293 -1.292l-.094 -.083z\" />"),
    BELL_Z(
        "bell-z",
        "<path d=\"M14.235 19c.865 0 1.322 1.024 .745 1.668a3.992 3.992 0 0 1 -2.98 1.332a3.992 3.992 0 0 1 -2.98 -1.332c-.552 -.616 -.158 -1.579 .634 -1.661l.11 -.006h4.471z\" />\n  <path d=\"M12 2c1.358 0 2.506 .903 2.875 2.141l.046 .171l.008 .043a8.013 8.013 0 0 1 4.024 6.069l.028 .287l.019 .289v2.931l.021 .136a3 3 0 0 0 1.143 1.847l.167 .117l.162 .099c.86 .487 .56 1.766 -.377 1.864l-.116 .006h-16c-1.028 0 -1.387 -1.364 -.493 -1.87a3 3 0 0 0 1.472 -2.063l.021 -.143l.001 -2.97a8 8 0 0 1 3.821 -6.454l.248 -.146l.01 -.043a3.003 3.003 0 0 1 2.562 -2.29l.182 -.017l.176 -.004zm2 6h-4l-.117 .007a1 1 0 0 0 -.883 .993l.007 .117a1 1 0 0 0 .993 .883h1.584l-2.291 2.293l-.076 .084c-.514 .637 -.07 1.623 .783 1.623h4l.117 -.007a1 1 0 0 0 .883 -.993l-.007 -.117a1 1 0 0 0 -.993 -.883h-1.586l2.293 -2.293l.076 -.084c.514 -.637 .07 -1.623 -.783 -1.623z\" />"),
    BLOB(
        "blob",
        "<path d=\"M12 3c2.779 0 5.349 1.556 7.243 4.082c1.728 2.306 2.757 5.259 2.757 8.016c0 1.47 -.293 2.718 -.903 3.745c-.603 1.014 -1.479 1.758 -2.582 2.257c-1.593 .718 -3.335 .9 -6.515 .9c-3.175 0 -4.92 -.183 -6.514 -.9c-1.012 -.457 -1.833 -1.12 -2.426 -2.01l-.157 -.247c-.61 -1.028 -.903 -2.274 -.903 -3.745c0 -2.757 1.03 -5.71 2.757 -8.016c1.893 -2.526 4.463 -4.082 7.243 -4.082\" />"),
    CALENDAR(
        "calendar",
        "<path d=\"M16 2a1 1 0 0 1 .993 .883l.007 .117v1h1a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h1v-1a1 1 0 0 1 1.993 -.117l.007 .117v1h6v-1a1 1 0 0 1 1 -1zm3 7h-14v9.625c0 .705 .386 1.286 .883 1.366l.117 .009h12c.513 0 .936 -.53 .993 -1.215l.007 -.16v-9.625z\" />\n  <path d=\"M12 12a1 1 0 0 1 .993 .883l.007 .117v3a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />"),
    CALENDAR_EVENT(
        "calendar-event",
        "<path d=\"M16 2a1 1 0 0 1 .993 .883l.007 .117v1h1a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h1v-1a1 1 0 0 1 1.993 -.117l.007 .117v1h6v-1a1 1 0 0 1 1 -1m3 8h-14v8.625c0 .705 .386 1.286 .883 1.366l.117 .009h12c.513 0 .936 -.53 .993 -1.215l.007 -.16zm-9 4a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1z\" />"),
    CALENDAR_MONTH(
        "calendar-month",
        "<path d=\"M8 12a1 1 0 0 1 1 1v4a1 1 0 0 1 -2 0v-4a1 1 0 0 1 1 -1\" />\n  <path d=\"M12 12a1 1 0 0 1 1 1v4a1 1 0 0 1 -2 0v-4a1 1 0 0 1 1 -1\" />\n  <path d=\"M16 12a1 1 0 0 1 1 1v4a1 1 0 0 1 -2 0v-4a1 1 0 0 1 1 -1\" />\n  <path d=\"M16 2a1 1 0 0 1 .993 .883l.007 .117v1h1a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h1v-1a1 1 0 0 1 1.993 -.117l.007 .117v1h6v-1a1 1 0 0 1 1 -1m3 7h-14v9.625c0 .705 .386 1.286 .883 1.366l.117 .009h12c.513 0 .936 -.53 .993 -1.215l.007 -.16z\" />"),
    CALENDAR_WEEK(
        "calendar-week",
        "<path d=\"M16 2c.183 0 .355 .05 .502 .135l.033 .02c.28 .177 .465 .49 .465 .845v1h1a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h1v-1a1 1 0 0 1 .514 -.874l.093 -.046l.066 -.025l.1 -.029l.107 -.019l.12 -.007q .083 0 .161 .013l.122 .029l.04 .012l.06 .023c.328 .135 .568 .44 .61 .806l.007 .117v1h6v-1a1 1 0 0 1 1 -1m3 7h-14v9.625c0 .705 .386 1.286 .883 1.366l.117 .009h12c.513 0 .936 -.53 .993 -1.215l.007 -.16z\" />\n  <path d=\"M9.015 13a1 1 0 0 1 -1 1a1.001 1.001 0 1 1 -.005 -2c.557 0 1.005 .448 1.005 1\" />\n  <path d=\"M13.015 13a1 1 0 0 1 -1 1a1.001 1.001 0 1 1 -.005 -2c.557 0 1.005 .448 1.005 1\" />\n  <path d=\"M17.02 13a1 1 0 0 1 -1 1a1.001 1.001 0 1 1 -.005 -2c.557 0 1.005 .448 1.005 1\" />\n  <path d=\"M12.02 15a1 1 0 0 1 0 2a1.001 1.001 0 1 1 -.005 -2z\" />\n  <path d=\"M9.015 16a1 1 0 0 1 -1 1a1.001 1.001 0 1 1 -.005 -2c.557 0 1.005 .448 1.005 1\" />"),
    CHECK(
        "check",
        "<path d=\"M20.707 6.293a1 1 0 0 1 0 1.414l-10 10a1 1 0 0 1 -1.414 0l-5 -5a1 1 0 0 1 1.414 -1.414l4.293 4.293l9.293 -9.293a1 1 0 0 1 1.414 0\" />"),
    CLICK(
        "click",
        "<path d=\"M7 12a1 1 0 0 1 -1 1h-3a1 1 0 0 1 0 -2h3a1 1 0 0 1 1 1m6 -9v3a1 1 0 0 1 -2 0v-3a1 1 0 0 1 2 0m-6.693 1.893l2.2 2.2a1 1 0 0 1 -1.414 1.414l-2.2 -2.2a1 1 0 0 1 1.414 -1.414m12.8 0a1 1 0 0 1 0 1.414l-2.2 2.2a1 1 0 0 1 -1.414 -1.414l2.2 -2.2a1 1 0 0 1 1.414 0m-10.6 10.6a1 1 0 0 1 0 1.414l-2.2 2.2a1 1 0 1 1 -1.414 -1.414l2.2 -2.2a1 1 0 0 1 1.414 0m3.42 -4.49l.049 -.003l.098 .003l.097 .012l.097 .022l9.048 3.014c.845 .282 .928 1.445 .131 1.843l-3.702 1.851l-1.85 3.702c-.399 .797 -1.562 .714 -1.844 -.13l-3.003 -9.011l-.033 -.135l-.012 -.097v-.148l.012 -.097l.022 -.097l.03 -.094l.04 -.09l.05 -.084l.086 -.117l.067 -.07l.037 -.034l.076 -.06l.081 -.052l.087 -.043l.103 -.04l.135 -.033z\" />"),
    CLOCK(
        "clock",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-5 2.66a1 1 0 0 0 -.993 .883l-.007 .117v5l.009 .131a1 1 0 0 0 .197 .477l.087 .1l3 3l.094 .082a1 1 0 0 0 1.226 0l.094 -.083l.083 -.094a1 1 0 0 0 0 -1.226l-.083 -.094l-2.707 -2.708v-4.585l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    CLOCK_HOUR_1(
        "clock-hour-1",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5.401 9.576l.052 .021l.08 .026l.08 .019l.072 .011l.117 .007l.076 -.003l.135 -.02l.082 -.02l.103 -.039l.073 -.035l.078 -.046l.06 -.042l.08 -.069l.083 -.088l.062 -.083l2 -3a1 1 0 1 0 -1.664 -1.11l-.168 .251v-1.696a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v5.026l.009 .105l.02 .107l.04 .129l.048 .102l.046 .078l.042 .06l.069 .08l.088 .083l.083 .062l.09 .053z\" />"),
    CLOCK_HOUR_10(
        "clock-hour-10",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5.401 9.576l.052 .021l.08 .026l.08 .019l.072 .011l.117 .007l.076 -.003l.135 -.02l.082 -.02l.103 -.039l.073 -.035l.078 -.046l.06 -.042l.08 -.069l.083 -.088l.062 -.083l.053 -.09l.031 -.064l.032 -.081l.03 -.109l.015 -.094l.007 -.117v-5a1 1 0 0 0 -2 0v3.131l-1.445 -.963a1 1 0 0 0 -1.317 .184l-.07 .093a1 1 0 0 0 .277 1.387l3.038 2.024z\" />"),
    CLOCK_HOUR_11(
        "clock-hour-11",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.952 9.659l.069 -.006l.096 -.016l.089 -.023l.099 -.038l.082 -.04l.113 -.073l.073 -.06l.074 -.074l.075 -.094l.052 -.08l.035 -.07l.051 -.132l.031 -.135l.01 -.082l.003 -.076v-5a1 1 0 0 0 -2 0v1.697l-.168 -.252a1 1 0 0 0 -1.286 -.336l-.1 .059a1 1 0 0 0 -.278 1.387l2.018 3.027l.07 .087l.075 .074l.094 .075l.08 .052l.07 .035l.132 .051l.135 .031l.082 .01z\" />"),
    CLOCK_HOUR_12(
        "clock-hour-12",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 2.66a1 1 0 0 0 -1 1v5a1 1 0 0 0 2 0v-5a1 1 0 0 0 -1 -1\" />"),
    CLOCK_HOUR_2(
        "clock-hour-2",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-6 3.66v5.022l.003 .054l.02 .135l.005 .025a1 1 0 0 0 .056 .165l.04 .082l.062 .099l.07 .087l.075 .074l.094 .075l.08 .052l.07 .035l.132 .051l.135 .031l.082 .01l.124 .002l.113 -.012l.108 -.024l.106 -.036l.108 -.051l.065 -.04l3.007 -2.004a1 1 0 1 0 -1.11 -1.664l-1.445 .962v-3.13a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1\" />"),
    CLOCK_HOUR_3(
        "clock-hour-3",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 2.66a1 1 0 0 0 -1 1v5a1 1 0 0 0 1 1h3.5a1 1 0 0 0 0 -2h-2.5v-4a1 1 0 0 0 -.883 -.993z\" />"),
    CLOCK_HOUR_4(
        "clock-hour-4",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 2.66a1 1 0 0 0 -1 1v5.026l.009 .105l.02 .107l.04 .129l.048 .102l.046 .078l.042 .06l.069 .08l.088 .083l.083 .062l3 2a1 1 0 1 0 1.11 -1.664l-2.555 -1.704v-4.464a1 1 0 0 0 -.883 -.993z\" />"),
    CLOCK_HOUR_5(
        "clock-hour-5",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-6 3.66v5.022l.003 .054l.02 .135l.005 .025a1 1 0 0 0 .056 .165l.04 .082l.04 .065l2.004 3.007a1 1 0 1 0 1.664 -1.11l-1.832 -2.748v-4.697a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1\" />"),
    CLOCK_HOUR_6(
        "clock-hour-6",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-6 12.16a1 1 0 0 0 2 0v-8.5a1 1 0 0 0 -2 0z\" />"),
    CLOCK_HOUR_7(
        "clock-hour-7",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.007 8.777l.007 -.117v-5a1 1 0 0 0 -2 0v4.696l-1.832 2.75a1 1 0 0 0 .184 1.316l.093 .07a1 1 0 0 0 1.387 -.277l2.024 -3.038l.06 -.116l.032 -.081l.03 -.109z\" />"),
    CLOCK_HOUR_8(
        "clock-hour-8",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 2.66a1 1 0 0 0 -1 1v4.464l-2.555 1.704a1 1 0 0 0 -.336 1.286l.059 .1a1 1 0 0 0 1.387 .278l3.027 -2.018l.087 -.07l.074 -.075l.075 -.094l.052 -.08l.035 -.07l.051 -.132l.031 -.135l.01 -.082l.003 -.076v-5a1 1 0 0 0 -1 -1\" />"),
    CLOCK_HOUR_9(
        "clock-hour-9",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.883 9.653a1 1 0 0 0 .883 -.993v-5a1 1 0 0 0 -2 0v4h-2.5a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 0 1 1h3.5z\" />"),
    DASHBOARD(
        "dashboard",
        "<path d=\"M12 2.954a10 10 0 0 1 6.222 17.829a1 1 0 0 1 -.622 .217h-11.2a1 1 0 0 1 -.622 -.217a10 10 0 0 1 6.222 -17.829m4.207 5.839a1 1 0 0 0 -1.414 0l-2.276 2.274a2.003 2.003 0 0 0 -2.514 1.815l-.003 .118a2 2 0 1 0 3.933 -.517l2.274 -2.276a1 1 0 0 0 0 -1.414\" />"),
    DEVICE_UNKNOWN(
        "device-unknown",
        "<path d=\"M17 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-5 13a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.526 1.292a.98 .98 0 0 1 1.195 -.239a1 1 0 0 1 -.455 1.892a1 1 0 0 0 -.006 2a3 3 0 0 0 1.371 -5.673\" />"),
    DIRECTION_ARROWS(
        "direction-arrows",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -20 0l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72m-.293 13.293a1 1 0 0 0 -1.414 1.414l1 1a1 1 0 0 0 1.414 0l1 -1a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-.293 .292zm-3 -5a1 1 0 0 0 -1.414 0l-1 1a1 1 0 0 0 0 1.414l1 1a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-.292 -.293l.292 -.293a1 1 0 0 0 0 -1.414m8 0a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l.292 .292l-.292 .294a1 1 0 0 0 1.414 1.414l1 -1a1 1 0 0 0 0 -1.414zm-4 -4a1 1 0 0 0 -1.414 0l-1 1a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l.293 -.292l.293 .292a1 1 0 0 0 1.414 -1.414z\" />"),
    DIRECTION_SIGN(
        "direction-sign",
        "<path d=\"M10.52 2.614a2.095 2.095 0 0 1 2.835 -.117l.126 .117l7.905 7.905c.777 .777 .816 2.013 .117 2.836l-.117 .126l-7.905 7.905a2.094 2.094 0 0 1 -2.836 .117l-.126 -.117l-7.907 -7.906a2.096 2.096 0 0 1 -.115 -2.835l.117 -.126l7.905 -7.905zm5.969 9.535l.01 -.116l-.003 -.12l-.016 -.114l-.03 -.11l-.044 -.112l-.052 -.098l-.076 -.105l-.07 -.081l-3.5 -3.5l-.095 -.083a1 1 0 0 0 -1.226 0l-.094 .083l-.083 .094a1 1 0 0 0 0 1.226l.083 .094l1.792 1.793h-5.085l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h5.085l-1.792 1.793l-.083 .094a1 1 0 0 0 1.403 1.403l.094 -.083l3.5 -3.5l.097 -.112l.05 -.074l.037 -.067l.05 -.112l.023 -.076l.025 -.117z\" />"),
    DOTS(
        "dots",
        "<path d=\"M7 12a2 2 0 1 1 -4 0q 0 -.053 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />\n  <path d=\"M14 12a2 2 0 1 1 -4 0q 0 -.053 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />\n  <path d=\"M21 12a2 2 0 1 1 -4 0q 0 -.053 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />"),
    DOTS_VERTICAL(
        "dots-vertical",
        "<path d=\"M14 12a2 2 0 1 1 -4 0q 0 -.053 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />\n  <path d=\"M14 19a2 2 0 1 1 -4 0q 0 -.052 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />\n  <path d=\"M14 5a2 2 0 1 1 -4 0q 0 -.053 .005 -.102a1.996 1.996 0 0 1 1.995 -1.898a2 2 0 0 1 2 2\" />"),
    ELEVATOR(
        "elevator",
        "<path d=\"M18 3a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2zm-7.293 10.293a1 1 0 1 0 -1.414 1.414l2 2a1 1 0 0 0 1.414 0l2 -2a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-1.294 1.292zm2 -6a1 1 0 0 0 -1.414 0l-2 2a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l1.293 -1.292l1.293 1.292a1 1 0 0 0 1.414 -1.414z\" />"),
    EXCHANGE(
        "exchange",
        "<path d=\"M19 3a3 3 0 0 1 1 5.83v4.17a6 6 0 0 1 -6 6h-.585l1.292 1.293a1 1 0 0 1 .083 1.32l-.083 .094a1 1 0 0 1 -1.414 0l-2.959 -2.959a1 1 0 0 1 -.238 -.32l-.038 -.091l-.028 -.094a.98 .98 0 0 1 .187 -.866l.076 -.084l3 -3a1 1 0 0 1 1.414 1.414l-1.293 1.293h.586a4 4 0 0 0 3.995 -3.8l.005 -.2v-4.171a3 3 0 0 1 -2 -2.829l.005 -.176a3 3 0 0 1 2.995 -2.824m-8.293 -.707l3 3a.98 .98 0 0 1 .263 .95l-.01 .031l-.003 .018l-.008 .018l-.007 .027l-.016 .035l-.01 .032l-.007 .01l-.005 .014a1 1 0 0 1 -.232 .316l-2.965 2.963a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l1.291 -1.293h-.584a4 4 0 0 0 -3.995 3.8l-.005 .2v4.171a3.001 3.001 0 1 1 -4 2.829l.005 -.176a3 3 0 0 1 1.995 -2.654v-4.17a6 6 0 0 1 6 -6h.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.414 0\" />"),
    EXCLAMATION_CIRCLE(
        "exclamation-circle",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 11.66a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m0 -7a1 1 0 0 0 -1 1v4a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1\" />"),
    EXPLICIT(
        "explicit",
        "<path d=\"M19 3a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2zm-5 4h-4a1 1 0 0 0 -1 1v8a1 1 0 0 0 1 1h4a1 1 0 0 0 1 -1l-.007 -.117a1 1 0 0 0 -.993 -.883h-3v-2h3a1 1 0 0 0 0 -2h-3v-2h3a1 1 0 0 0 0 -2\" />"),
    EXTERNAL_LINK(
        "external-link",
        "<path d=\"M12 5a1 1 0 0 1 0 2h-6a1 1 0 0 0 -1 1v10a1 1 0 0 0 1 1h10a1 1 0 0 0 1 -1v-6a1 1 0 0 1 2 0v6a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm3 -2h5l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.096 .067l.09 .08q .054 .053 .097 .112l.071 .11l.054 .114l.035 .105l.03 .148l.006 .118v5a1 1 0 0 1 -2 0v-2.586l-7.293 7.293a1 1 0 0 1 -1.414 -1.414l7.291 -7.293h-2.584a1 1 0 0 1 0 -2\" />"),
    EYE(
        "eye",
        "<path d=\"M12 4c4.29 0 7.863 2.429 10.665 7.154l.22 .379l.045 .1l.03 .083l.014 .055l.014 .082l.011 .1v.11l-.014 .111a.992 .992 0 0 1 -.026 .11l-.039 .108l-.036 .075l-.016 .03c-2.764 4.836 -6.3 7.38 -10.555 7.499l-.313 .004c-4.396 0 -8.037 -2.549 -10.868 -7.504a1 1 0 0 1 0 -.992c2.831 -4.955 6.472 -7.504 10.868 -7.504zm0 5a3 3 0 1 0 0 6a3 3 0 0 0 0 -6\" />"),
    FIDGET_SPINNER(
        "fidget-spinner",
        "<path d=\"M12 0a5 5 0 0 1 3.584 8.488l-.012 .012a5 5 0 0 1 1.33 2.517l.018 .101l.251 -.048q .15 -.025 .3 -.041l.304 -.024l.225 -.005a5 5 0 1 1 -4.89 6.046l-.032 -.164l-.24 .048a5 5 0 0 1 -.556 .062l-.282 .008q -.427 0 -.84 -.07l-.239 -.048l-.004 .025a5 5 0 0 1 -3.331 3.834l-.22 .068a5 5 0 1 1 -.461 -9.728l.173 .036l.019 -.102c.19 -.95 .653 -1.824 1.331 -2.516l-.05 -.052a5.02 5.02 0 0 1 -1.355 -2.978l-.018 -.244l-.005 -.225a5 5 0 0 1 5 -5m6 15a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m-12 0a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m6 -4.995c-1.1 0 -1.99 .891 -1.99 1.99v.02a1.99 1.99 0 0 0 3.98 0v-.02a1.99 1.99 0 0 0 -1.99 -1.99m0 -6.005a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    FILTER(
        "filter",
        "<path d=\"M20 3h-16a1 1 0 0 0 -1 1v2.227l.008 .223a3 3 0 0 0 .772 1.795l4.22 4.641v8.114a1 1 0 0 0 1.316 .949l6 -2l.108 -.043a1 1 0 0 0 .576 -.906v-6.586l4.121 -4.12a3 3 0 0 0 .879 -2.123v-2.171a1 1 0 0 0 -1 -1z\" />"),
    FILTERS(
        "filters",
        "<path d=\"M19.396 11.056a6 6 0 0 1 -5.647 10.506q .206 -.21 .396 -.44a8 8 0 0 0 1.789 -6.155a8.02 8.02 0 0 0 3.462 -3.911\" />\n  <path d=\"M4.609 11.051a7.99 7.99 0 0 0 9.386 4.698a6 6 0 1 1 -9.534 -4.594z\" />\n  <path d=\"M12 2a6 6 0 1 1 -6 6l.004 -.225a6 6 0 0 1 5.996 -5.775\" />"),
    FORBID(
        "forbid",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-7.387 4.87a1 1 0 0 0 -1.32 1.497l6 6l.094 .083a1 1 0 0 0 1.32 -1.497l-6 -6z\" />"),
    FORBID_2(
        "forbid-2",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.293 4.953a1 1 0 0 0 -1.414 0l-6 6l-.083 .094a1 1 0 0 0 1.497 1.32l6 -6l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    GAUGE(
        "gauge",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-.293 3.953a1 1 0 0 0 -1.414 0l-2.59 2.59l-.083 .094l-.068 .1a2.001 2.001 0 0 0 -2.547 1.774l-.005 .149l.005 .15a2 2 0 1 0 3.917 -.701a.968 .968 0 0 0 .195 -.152l2.59 -2.59l.083 -.094a1 1 0 0 0 -.083 -1.32zm-4.707 -1.293a6 6 0 0 0 -6 6a1 1 0 0 0 2 0a4 4 0 0 1 4 -4a1 1 0 0 0 0 -2z\" />"),
    GRAPH(
        "graph",
        "<path d=\"M18 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12zm-2.293 6.293a1 1 0 0 0 -1.414 0l-2.293 2.292l-1.293 -1.292a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l1.293 1.292l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l1.293 1.292a1 1 0 0 0 1.414 -1.414l-2 -2z\" />"),
    GRID_PATTERN(
        "grid-pattern",
        "<path d=\"M18 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3zm-4 4a1 1 0 0 0 -1 1v1h-2v-1a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v1h-1a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 0 1 1h1v2h-1a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 0 1 1h1v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-1h2v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-1h1a1 1 0 0 0 .993 -.883l.007 -.117a1 1 0 0 0 -1 -1h-1v-2h1a1 1 0 0 0 .993 -.883l.007 -.117a1 1 0 0 0 -1 -1h-1v-1a1 1 0 0 0 -.883 -.993zm-1 4v2h-2v-2z\" />"),
    HANGER_2(
        "hanger-2",
        "<path d=\"M12 2a3 3 0 0 1 3 3a1 1 0 0 1 -1.993 .117l-.007 -.117a1 1 0 0 0 -2 -.004c.006 1.516 .495 2.579 1.486 3.13l7.97 4.428a3 3 0 0 1 1.544 2.623v.823a3 3 0 0 1 -2.824 2.995l-.176 .005a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3a3 3 0 0 1 -3 -3v-.823a3 3 0 0 1 1.543 -2.623l6.695 -3.72c-.832 -.976 -1.232 -2.296 -1.238 -3.834a3 3 0 0 1 3 -3m0 8.144l-7.486 4.158a1 1 0 0 0 -.514 .875v.823a1 1 0 0 0 1 1h.17a3 3 0 0 1 2.83 -2h8c1.306 0 2.418 .835 2.83 2h.17a1 1 0 0 0 1 -1v-.823a1 1 0 0 0 -.515 -.875z\" />"),
    HELP(
        "help",
        "<path d=\"M17 3.34a10 10 0 1 1 -10 17.32a10 10 0 0 1 10 -17.32m-5 12.66a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1m1.173 -9.856a3.6 3.6 0 0 0 -3.97 1.252a1 1 0 0 0 1.512 1.304l.082 -.096a1.6 1.6 0 1 1 1.846 2.462a2.49 2.49 0 0 0 -1.641 2.49a1 1 0 0 0 1.996 .004v-.117a.5 .5 0 0 1 .259 -.466l.075 -.034a3.61 3.61 0 0 0 2.338 -3.47a3.6 3.6 0 0 0 -2.497 -3.329\" />"),
    HELP_CIRCLE(
        "help-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -19.995 .324l-.005 -.324l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72zm0 13a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HELP_HEXAGON(
        "help-hexagon",
        "<path d=\"M10.425 1.414a3.33 3.33 0 0 1 3.026 -.097l.19 .097l6.775 3.995l.096 .063l.092 .077l.107 .075a3.224 3.224 0 0 1 1.266 2.188l.018 .202l.005 .204v7.284c0 1.106 -.57 2.129 -1.454 2.693l-.17 .1l-6.803 4.302c-.918 .504 -2.019 .535 -3.004 .068l-.196 -.1l-6.695 -4.237a3.225 3.225 0 0 1 -1.671 -2.619l-.007 -.207v-7.285c0 -1.106 .57 -2.128 1.476 -2.705l6.95 -4.098zm1.575 13.586a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HELP_OCTAGON(
        "help-octagon",
        "<path d=\"M14.897 1a4 4 0 0 1 2.664 1.016l.165 .156l4.1 4.1a4 4 0 0 1 1.168 2.605l.006 .227v5.794a4 4 0 0 1 -1.016 2.664l-.156 .165l-4.1 4.1a4 4 0 0 1 -2.603 1.168l-.227 .006h-5.795a3.999 3.999 0 0 1 -2.664 -1.017l-.165 -.156l-4.1 -4.1a4 4 0 0 1 -1.168 -2.604l-.006 -.227v-5.794a4 4 0 0 1 1.016 -2.664l.156 -.165l4.1 -4.1a4 4 0 0 1 2.605 -1.168l.227 -.006h5.793zm-2.897 14a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HELP_SQUARE(
        "help-square",
        "<path d=\"M19 2a3 3 0 0 1 2.995 2.824l.005 .176v14a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h14zm-7 13a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HELP_SQUARE_ROUNDED(
        "help-square-rounded",
        "<path d=\"M12 2l.642 .005l.616 .017l.299 .013l.579 .034l.553 .046c4.687 .455 6.65 2.333 7.166 6.906l.03 .29l.046 .553l.041 .727l.006 .15l.017 .617l.005 .642l-.005 .642l-.017 .616l-.013 .299l-.034 .579l-.046 .553c-.455 4.687 -2.333 6.65 -6.906 7.166l-.29 .03l-.553 .046l-.727 .041l-.15 .006l-.617 .017l-.642 .005l-.642 -.005l-.616 -.017l-.299 -.013l-.579 -.034l-.553 -.046c-4.687 -.455 -6.65 -2.333 -7.166 -6.906l-.03 -.29l-.046 -.553l-.041 -.727l-.006 -.15l-.017 -.617l-.004 -.318v-.648l.004 -.318l.017 -.616l.013 -.299l.034 -.579l.046 -.553c.455 -4.687 2.333 -6.65 6.906 -7.166l.29 -.03l.553 -.046l.727 -.041l.15 -.006l.617 -.017c.21 -.003 .424 -.005 .642 -.005zm0 13a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HELP_TRIANGLE(
        "help-triangle",
        "<path d=\"M12 1.67c.955 0 1.845 .467 2.39 1.247l.105 .16l8.114 13.548a2.914 2.914 0 0 1 -2.307 4.363l-.195 .008h-16.225a2.914 2.914 0 0 1 -2.582 -4.2l.099 -.185l8.11 -13.538a2.914 2.914 0 0 1 2.491 -1.403zm0 13.33a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1.368 -6.673a2.98 2.98 0 0 0 -3.631 .728a1 1 0 0 0 1.44 1.383l.171 -.18a.98 .98 0 0 1 1.11 -.15a1 1 0 0 1 -.34 1.886l-.232 .012a1 1 0 0 0 .111 1.994a3 3 0 0 0 1.371 -5.673z\" />"),
    HOURGLASS(
        "hourglass",
        "<path d=\"M17 2a2 2 0 0 1 1.995 1.85l.005 .15v2a6.996 6.996 0 0 1 -3.393 6a6.994 6.994 0 0 1 3.388 5.728l.005 .272v2a2 2 0 0 1 -1.85 1.995l-.15 .005h-10a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-2a6.996 6.996 0 0 1 3.393 -6a6.994 6.994 0 0 1 -3.388 -5.728l-.005 -.272v-2a2 2 0 0 1 1.85 -1.995l.15 -.005h10z\" />"),
    ID(
        "id",
        "<path d=\"M18 3a4 4 0 0 1 4 4v10a4 4 0 0 1 -4 4h-12a4 4 0 0 1 -4 -4v-10q 0 -.053 .005 -.102a3.994 3.994 0 0 1 3.995 -3.898zm-1 12h-10a1 1 0 0 0 0 2h10a1 1 0 0 0 0 -2m-8 -8a2.995 2.995 0 0 0 -2.995 2.898a1 1 0 0 0 -.005 .102a3 3 0 1 0 3 -3m8 4h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2m0 -4h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2\" />"),
    INFO_CIRCLE(
        "info-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -19.995 .324l-.005 -.324l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72zm0 9h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    INFO_HEXAGON(
        "info-hexagon",
        "<path d=\"M10.425 1.414a3.33 3.33 0 0 1 3.026 -.097l.19 .097l6.775 3.995l.096 .063l.092 .077l.107 .075a3.224 3.224 0 0 1 1.266 2.188l.018 .202l.005 .204v7.284c0 1.106 -.57 2.129 -1.454 2.693l-.17 .1l-6.803 4.302c-.918 .504 -2.019 .535 -3.004 .068l-.196 -.1l-6.695 -4.237a3.225 3.225 0 0 1 -1.671 -2.619l-.007 -.207v-7.285c0 -1.106 .57 -2.128 1.476 -2.705l6.95 -4.098zm1.575 9.586h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    INFO_OCTAGON(
        "info-octagon",
        "<path d=\"M14.897 1a4 4 0 0 1 2.664 1.016l.165 .156l4.1 4.1a4 4 0 0 1 1.168 2.605l.006 .227v5.794a4 4 0 0 1 -1.016 2.664l-.156 .165l-4.1 4.1a4 4 0 0 1 -2.603 1.168l-.227 .006h-5.795a3.999 3.999 0 0 1 -2.664 -1.017l-.165 -.156l-4.1 -4.1a4 4 0 0 1 -1.168 -2.604l-.006 -.227v-5.794a4 4 0 0 1 1.016 -2.664l.156 -.165l4.1 -4.1a4 4 0 0 1 2.605 -1.168l.227 -.006h5.793zm-2.897 10h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    INFO_SQUARE(
        "info-square",
        "<path d=\"M19 2a3 3 0 0 1 2.995 2.824l.005 .176v14a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h14zm-7 9h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    INFO_SQUARE_ROUNDED(
        "info-square-rounded",
        "<path d=\"M12 2l.642 .005l.616 .017l.299 .013l.579 .034l.553 .046c4.687 .455 6.65 2.333 7.166 6.906l.03 .29l.046 .553l.041 .727l.006 .15l.017 .617l.005 .642l-.005 .642l-.017 .616l-.013 .299l-.034 .579l-.046 .553c-.455 4.687 -2.333 6.65 -6.906 7.166l-.29 .03l-.553 .046l-.727 .041l-.15 .006l-.617 .017l-.642 .005l-.642 -.005l-.616 -.017l-.299 -.013l-.579 -.034l-.553 -.046c-4.687 -.455 -6.65 -2.333 -7.166 -6.906l-.03 -.29l-.046 -.553l-.041 -.727l-.006 -.15l-.017 -.617l-.004 -.318v-.648l.004 -.318l.017 -.616l.013 -.299l.034 -.579l.046 -.553c.455 -4.687 2.333 -6.65 6.906 -7.166l.29 -.03l.553 -.046l.727 -.041l.15 -.006l.617 -.017c.21 -.003 .424 -.005 .642 -.005zm0 9h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    INFO_TRIANGLE(
        "info-triangle",
        "<path d=\"M12 1.67c.955 0 1.845 .467 2.39 1.247l.105 .16l8.114 13.548a2.914 2.914 0 0 1 -2.307 4.363l-.195 .008h-16.225a2.914 2.914 0 0 1 -2.582 -4.2l.099 -.185l8.11 -13.538a2.914 2.914 0 0 1 2.491 -1.403zm0 9.33h-1l-.117 .007a1 1 0 0 0 0 1.986l.117 .007v3l.007 .117a1 1 0 0 0 .876 .876l.117 .007h1l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006v-3l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007zm.01 -3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    JETPACK(
        "jetpack",
        "<path d=\"M17 2a4 4 0 0 1 4 4v7a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-1h-2v1a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-7a4 4 0 0 1 8 0v1h2v-1a4 4 0 0 1 4 -4m-4 8v-1h-2v1zm-4 5a1 1 0 0 1 1 1c0 2.623 -.787 4.59 -2.4 5.8a1 1 0 0 1 -1.2 0c-1.613 -1.21 -2.4 -3.177 -2.4 -5.8a1 1 0 0 1 2 0c0 1.532 .308 2.684 .906 3.498l.094 .119l.094 -.12c.558 -.759 .864 -1.813 .902 -3.196l.004 -.301a1 1 0 0 1 1 -1m10 0a1 1 0 0 1 1 1c0 2.623 -.787 4.59 -2.4 5.8a1 1 0 0 1 -1.2 0c-1.613 -1.21 -2.4 -3.177 -2.4 -5.8a1 1 0 0 1 2 0c0 1.532 .308 2.684 .906 3.498l.094 .119l.094 -.12c.558 -.759 .864 -1.813 .902 -3.196l.004 -.301a1 1 0 0 1 1 -1\" />"),
    LABEL(
        "label",
        "<path d=\"M16.52 6a2 2 0 0 1 1.561 .75l3.7 4.625a1 1 0 0 1 0 1.25l-3.7 4.624a2 2 0 0 1 -1.561 .751h-10.52a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3z\" />"),
    LABEL_IMPORTANT(
        "label-important",
        "<path d=\"M16.52 6a2 2 0 0 1 1.561 .75l3.7 4.625a1 1 0 0 1 0 1.25l-3.7 4.624a2 2 0 0 1 -1.561 .751h-12.52a1 1 0 0 1 -.78 -1.625l3.5 -4.375l-3.5 -4.375a1 1 0 0 1 .668 -1.62l.112 -.005z\" />"),
    LEGO(
        "lego",
        "<path d=\"M16 2a1 1 0 0 1 1 1v1l.2 .005a4 4 0 0 1 3.795 3.795l.005 .2v9a4 4 0 0 1 -2.845 3.83l-.155 .043v.127a1 1 0 0 1 -.883 .993l-.117 .007h-10a1 1 0 0 1 -1 -1v-.127l-.155 -.042a4 4 0 0 1 -2.84 -3.631l-.005 -.2v-9a4 4 0 0 1 4 -4v-1a1 1 0 0 1 1 -1zm-.8 12.286a1 1 0 0 0 -1.414 .014a2.5 2.5 0 0 1 -3.572 0a1 1 0 0 0 -1.428 1.4a4.5 4.5 0 0 0 6.428 0a1 1 0 0 0 -.014 -1.414m-5.69 -4.286h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m5 0h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />"),
    LIBRARY(
        "library",
        "<path d=\"M18.333 2a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-4.333 10h-3a1 1 0 0 0 0 2h3a1 1 0 0 0 0 -2m3 -3h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m-1 -3h-5a1 1 0 0 0 0 2h5a1 1 0 0 0 0 -2\" />\n  <path d=\"M3.517 6.391a1 1 0 0 1 .99 1.738c-.313 .178 -.506 .51 -.507 .868v10c0 .548 .452 1 1 1h10c.284 0 .405 -.088 .626 -.486a1 1 0 0 1 1.748 .972c-.546 .98 -1.28 1.514 -2.374 1.514h-10c-1.652 0 -3 -1.348 -3 -3v-10.002a3 3 0 0 1 1.517 -2.605\" />"),
    LIBRARY_PLUS(
        "library-plus",
        "<path d=\"M18.333 2a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-4.333 4a1 1 0 0 0 -1 1v2h-2a1 1 0 0 0 0 2h2v2a1 1 0 0 0 2 0v-2h2a1 1 0 0 0 0 -2h-2v-2a1 1 0 0 0 -1 -1\" />\n  <path d=\"M3.517 6.391a1 1 0 0 1 .99 1.738c-.313 .178 -.506 .51 -.507 .868v10c0 .548 .452 1 1 1h10c.284 0 .405 -.088 .626 -.486a1 1 0 0 1 1.748 .972c-.546 .98 -1.28 1.514 -2.374 1.514h-10c-1.652 0 -3 -1.348 -3 -3v-10.002a3 3 0 0 1 1.517 -2.605\" />"),
    LIFEBUOY(
        "lifebuoy",
        "<path d=\"M14.757 16.172l3.571 3.571a10.004 10.004 0 0 1 -12.656 0l3.57 -3.571a5 5 0 0 0 2.758 .828c1.02 0 1.967 -.305 2.757 -.828m-10.5 -10.5l3.571 3.57a5 5 0 0 0 -.828 2.758c0 1.02 .305 1.967 .828 2.757l-3.57 3.572a10 10 0 0 1 -2.258 -6.329l.005 -.324a10 10 0 0 1 2.252 -6.005m17.743 6.329c0 2.343 -.82 4.57 -2.257 6.328l-3.571 -3.57a5 5 0 0 0 .828 -2.758c0 -1.02 -.305 -1.967 -.828 -2.757l3.571 -3.57a10 10 0 0 1 2.257 6.327m-5 -8.66q .707 .41 1.33 .918l-3.573 3.57a5 5 0 0 0 -2.757 -.828c-1.02 0 -1.967 .305 -2.757 .828l-3.573 -3.57a10 10 0 0 1 11.33 -.918\" />"),
    LOCK(
        "lock",
        "<path d=\"M12 2a5 5 0 0 1 5 5v3a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3v-3a5 5 0 0 1 5 -5m0 12a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m0 -10a3 3 0 0 0 -3 3v3h6v-3a3 3 0 0 0 -3 -3\" />"),
    LOCK_SQUARE_ROUNDED(
        "lock-square-rounded",
        "<path d=\"M12 2c-.218 0 -.432 .002 -.642 .005l-.616 .017l-.299 .013l-.579 .034l-.553 .046c-4.785 .464 -6.732 2.411 -7.196 7.196l-.046 .553l-.034 .579c-.005 .098 -.01 .198 -.013 .299l-.017 .616l-.004 .318l-.001 .324c0 .218 .002 .432 .005 .642l.017 .616l.013 .299l.034 .579l.046 .553c.464 4.785 2.411 6.732 7.196 7.196l.553 .046l.579 .034c.098 .005 .198 .01 .299 .013l.616 .017l.642 .005l.642 -.005l.616 -.017l.299 -.013l.579 -.034l.553 -.046c4.785 -.464 6.732 -2.411 7.196 -7.196l.046 -.553l.034 -.579c.005 -.098 .01 -.198 .013 -.299l.017 -.616l.005 -.642l-.005 -.642l-.017 -.616l-.013 -.299l-.034 -.579l-.046 -.553c-.464 -4.785 -2.411 -6.732 -7.196 -7.196l-.553 -.046l-.579 -.034a28.058 28.058 0 0 0 -.299 -.013l-.616 -.017l-.318 -.004l-.324 -.001zm0 4a3 3 0 0 1 2.995 2.824l.005 .176v1a2 2 0 0 1 1.995 1.85l.005 .15v3a2 2 0 0 1 -1.85 1.995l-.15 .005h-6a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-3a2 2 0 0 1 1.85 -1.995l.15 -.005v-1a3 3 0 0 1 3 -3zm3 6h-6v3h6v-3zm-3 -4a1 1 0 0 0 -.993 .883l-.007 .117v1h2v-1a1 1 0 0 0 -1 -1z\" fill=\"currentColor\" />"),
    MAN(
        "man",
        "<path d=\"M15 8c1.628 0 3.2 .787 4.707 2.293a1 1 0 0 1 -1.414 1.414c-.848 -.848 -1.662 -1.369 -2.444 -1.587l-.849 5.944v4.936a1 1 0 0 1 -2 0v-4h-2v4a1 1 0 0 1 -2 0v-4.929l-.85 -5.951c-.781 .218 -1.595 .739 -2.443 1.587a1 1 0 1 1 -1.414 -1.414c1.506 -1.506 3.08 -2.293 4.707 -2.293z\" />\n  <path d=\"M12 1a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />"),
    MENU_2(
        "menu-2",
        "<path d=\"M21 6a1 1 0 0 1 -1 1h-16a1 1 0 1 1 0 -2h16a1 1 0 0 1 1 1\" />\n  <path d=\"M21 12a1 1 0 0 1 -1 1h-16a1 1 0 0 1 0 -2h16a1 1 0 0 1 1 1\" />\n  <path d=\"M21 18a1 1 0 0 1 -1 1h-16a1 1 0 0 1 0 -2h16a1 1 0 0 1 1 1\" />"),
    MILITARY_RANK(
        "military-rank",
        "<path d=\"M12.555 2.168l6 4a1 1 0 0 1 .445 .832v12a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-12a1 1 0 0 1 .445 -.832l6 -4a1 1 0 0 1 1.11 0m-.108 12.938a1 1 0 0 0 -.894 0l-2 1a1 1 0 0 0 -.447 1.341l.058 .102a1 1 0 0 0 1.283 .345l1.553 -.776l1.553 .776a1 1 0 0 0 .894 -1.788zm0 -4a1 1 0 0 0 -.894 0l-2 1a1 1 0 0 0 -.447 1.341l.058 .102a1 1 0 0 0 1.283 .345l1.553 -.776l1.553 .776a1 1 0 0 0 .894 -1.788zm0 -4a1 1 0 0 0 -.894 0l-2 1a1 1 0 0 0 -.447 1.341l.058 .102a1 1 0 0 0 1.283 .345l1.553 -.776l1.553 .776a1 1 0 0 0 .894 -1.788z\" />"),
    POINT(
        "point",
        "<path d=\"M12 7a5 5 0 1 1 -4.995 5.217l-.005 -.217l.005 -.217a5 5 0 0 1 4.995 -4.783z\" />"),
    POINTER(
        "pointer",
        "<path d=\"M3.039 4.277l3.904 13.563c.185 .837 .92 1.516 1.831 1.642l.17 .016a2.2 2.2 0 0 0 1.982 -1.006l.045 -.078l1.4 -2.072l4.05 4.05a2.067 2.067 0 0 0 2.924 0l1.047 -1.047c.388 -.388 .606 -.913 .606 -1.461l-.008 -.182a2.067 2.067 0 0 0 -.598 -1.28l-4.047 -4.048l2.103 -1.412c.726 -.385 1.18 -1.278 1.053 -2.189a2.2 2.2 0 0 0 -1.701 -1.845l-13.524 -3.89a1 1 0 0 0 -1.236 1.24z\" />"),
    POO(
        "poo",
        "<path d=\"M11.063 2.995l.086 .009h.07c2.237 .098 3.87 1.686 4.214 4.046l.01 .075l.133 .04a3.5 3.5 0 0 1 1.718 1.22l.125 .179a3.5 3.5 0 0 1 .567 2.243l-.006 .049l.032 .025a4 4 0 0 1 1.476 2.8l.01 .191l.15 .125a4 4 0 0 1 1.29 3.693l-.042 .208c-.4 1.728 -1.89 2.986 -3.72 3.092h-10.176a4 4 0 0 1 -2.638 -7.008l.14 -.118l.011 -.19a4 4 0 0 1 1.476 -2.798l.032 -.025l-.006 -.048a3.5 3.5 0 0 1 .452 -2.058l.114 -.186c.603 -.912 1.598 -1.49 2.755 -1.564h.164c.743 0 1.26 -1.242 .606 -2.553l.006 .015l-.01 -.017a1 1 0 0 1 -.095 -.323l-.007 -.117c0 -.654 .539 -1.031 1.063 -1.005m3.758 12.434a1 1 0 0 0 -1.392 -.25a2.5 2.5 0 0 1 -2.858 0a1 1 0 0 0 -1.142 1.642a4.5 4.5 0 0 0 5.142 0a1 1 0 0 0 .25 -1.392m-4.811 -4.429h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />"),
    REPLACE(
        "replace",
        "<path d=\"M8 2h-4a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h4a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M20 14h-4a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h4a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M16.707 2.293a1 1 0 0 1 .083 1.32l-.083 .094l-1.293 1.293h3.586a3 3 0 0 1 2.995 2.824l.005 .176v3a1 1 0 0 1 -1.993 .117l-.007 -.117v-3a1 1 0 0 0 -.883 -.993l-.117 -.007h-3.585l1.292 1.293a1 1 0 0 1 -1.32 1.497l-.094 -.083l-3 -3a.98 .98 0 0 1 -.28 -.872l.036 -.146l.04 -.104c.058 -.126 .14 -.24 .245 -.334l2.959 -2.958a1 1 0 0 1 1.414 0z\" />\n  <path d=\"M3 12a1 1 0 0 1 .993 .883l.007 .117v3a1 1 0 0 0 .883 .993l.117 .007h3.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083l.094 .083l3 3a.98 .98 0 0 1 .28 .872l-.036 .146l-.04 .104a1.02 1.02 0 0 1 -.245 .334l-2.959 2.958a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.291 -1.293h-3.584a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-3a1 1 0 0 1 1 -1z\" />"),
    SCALE(
        "scale",
        "<path d=\"M12 2a1 1 0 0 1 1 1v1.152l5.159 .86a.98 .98 0 0 1 .636 .38l.041 .059l.058 .102l3.024 6.05l.035 .094l.025 .096l.016 .1l.005 .12l-.003 .061a3.996 3.996 0 0 1 -3.996 3.926a4 4 0 0 1 -4 -4a1 1 0 0 1 .106 -.447l2.393 -4.79l-3.499 -.583v12.82h4a1 1 0 0 1 0 2h-10a1 1 0 0 1 0 -2h4v-12.82l-3.5 .583l2.418 4.84l.035 .094l.025 .096l.016 .1l.005 .12l-.003 .061a3.996 3.996 0 0 1 -3.996 3.926a4 4 0 0 1 -4 -4a1 1 0 0 1 .106 -.447l3.034 -6.065l.039 -.061l.025 -.034a.98 .98 0 0 1 .636 -.38l5.16 -.862v-1.151a1 1 0 0 1 1 -1\" />"),
    SEARCH(
        "search",
        "<path d=\"M14 3.072a8 8 0 0 1 2.32 11.834l5.387 5.387a1 1 0 0 1 -1.414 1.414l-5.388 -5.387a8 8 0 1 1 -.905 -13.249\" />"),
    SETTINGS(
        "settings",
        "<path d=\"M14.647 4.081a.724 .724 0 0 0 1.08 .448c2.439 -1.485 5.23 1.305 3.745 3.744a.724 .724 0 0 0 .447 1.08c2.775 .673 2.775 4.62 0 5.294a.724 .724 0 0 0 -.448 1.08c1.485 2.439 -1.305 5.23 -3.744 3.745a.724 .724 0 0 0 -1.08 .447c-.673 2.775 -4.62 2.775 -5.294 0a.724 .724 0 0 0 -1.08 -.448c-2.439 1.485 -5.23 -1.305 -3.745 -3.744a.724 .724 0 0 0 -.447 -1.08c-2.775 -.673 -2.775 -4.62 0 -5.294a.724 .724 0 0 0 .448 -1.08c-1.485 -2.439 1.305 -5.23 3.744 -3.745a.722 .722 0 0 0 1.08 -.447c.673 -2.775 4.62 -2.775 5.294 0zm-2.647 4.919a3 3 0 1 0 0 6a3 3 0 0 0 0 -6\" />"),
    SHIELD(
        "shield",
        "<path d=\"M11.884 2.007l.114 -.007l.118 .007l.059 .008l.061 .013l.111 .034a.993 .993 0 0 1 .217 .112l.104 .082l.255 .218a11 11 0 0 0 7.189 2.537l.342 -.01a1 1 0 0 1 1.005 .717a13 13 0 0 1 -9.208 16.25a1 1 0 0 1 -.502 0a13 13 0 0 1 -9.209 -16.25a1 1 0 0 1 1.005 -.717a11 11 0 0 0 7.531 -2.527l.263 -.225l.096 -.075a.993 .993 0 0 1 .217 -.112l.112 -.034a.97 .97 0 0 1 .119 -.021z\" />"),
    SHIELD_CHECK(
        "shield-check",
        "<path d=\"M11.998 2l.118 .007l.059 .008l.061 .013l.111 .034a.993 .993 0 0 1 .217 .112l.104 .082l.255 .218a11 11 0 0 0 7.189 2.537l.342 -.01a1 1 0 0 1 1.005 .717a13 13 0 0 1 -9.208 16.25a1 1 0 0 1 -.502 0a13 13 0 0 1 -9.209 -16.25a1 1 0 0 1 1.005 -.717a11 11 0 0 0 7.531 -2.527l.263 -.225l.096 -.075a.993 .993 0 0 1 .217 -.112l.112 -.034a.97 .97 0 0 1 .119 -.021l.115 -.007zm3.71 7.293a1 1 0 0 0 -1.415 0l-3.293 3.292l-1.293 -1.292l-.094 -.083a1 1 0 0 0 -1.32 1.497l2 2l.094 .083a1 1 0 0 0 1.32 -.083l4 -4l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    SHIELD_CHECKERED(
        "shield-checkered",
        "<path d=\"M11.013 12v9.754a13 13 0 0 1 -8.733 -9.754h8.734zm9.284 3.794a13 13 0 0 1 -7.283 5.951l-.001 -9.745h8.708a12.96 12.96 0 0 1 -1.424 3.794zm-9.283 -13.268l-.001 7.474h-8.986c-.068 -1.432 .101 -2.88 .514 -4.282a1 1 0 0 1 1.005 -.717a11 11 0 0 0 7.192 -2.256l.276 -.219zm1.999 7.474v-7.453l-.09 -.073a11 11 0 0 0 7.189 2.537l.342 -.01a1 1 0 0 1 1.005 .717c.413 1.403 .582 2.85 .514 4.282h-8.96z\" />"),
    SHIELD_HALF(
        "shield-half",
        "<path d=\"M11.998 2l.032 .002l.086 .005a1 1 0 0 1 .342 .104l.105 .062l.097 .076l.016 .015l.247 .21a11 11 0 0 0 7.189 2.537l.342 -.01a1 1 0 0 1 1.005 .717a13 13 0 0 1 -9.208 16.25a1 1 0 0 1 -.502 0a13 13 0 0 1 -9.209 -16.25a1 1 0 0 1 1.005 -.717a11 11 0 0 0 7.791 -2.75l.046 -.036l.053 -.041a1 1 0 0 1 .217 -.112l.075 -.023l.036 -.01a1 1 0 0 1 .12 -.022l.086 -.005zm.002 2.296l-.176 .135a13 13 0 0 1 -7.288 2.572l-.264 .006l-.064 .31a11 11 0 0 0 1.064 7.175l.17 .314a11 11 0 0 0 6.49 5.136l.068 .019z\" />"),
    SHIELD_LOCK(
        "shield-lock",
        "<path d=\"M11.998 2l.118 .007l.059 .008l.061 .013l.111 .034a.993 .993 0 0 1 .217 .112l.104 .082l.255 .218a11 11 0 0 0 7.189 2.537l.342 -.01a1 1 0 0 1 1.005 .717a13 13 0 0 1 -9.208 16.25a1 1 0 0 1 -.502 0a13 13 0 0 1 -9.209 -16.25a1 1 0 0 1 1.005 -.717a11 11 0 0 0 7.531 -2.527l.263 -.225l.096 -.075a.993 .993 0 0 1 .217 -.112l.112 -.034a.97 .97 0 0 1 .119 -.021l.115 -.007zm.002 7a2 2 0 0 0 -1.995 1.85l-.005 .15l.005 .15a2 2 0 0 0 .995 1.581v1.769l.007 .117a1 1 0 0 0 1.993 -.117l.001 -1.768a2 2 0 0 0 -1.001 -3.732z\" />"),
    SORT_ASCENDING_SHAPES(
        "sort-ascending-shapes",
        "<path d=\"M7 5a1 1 0 0 1 1 1v9.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-9.586a1 1 0 0 1 1 -1m12 -2a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2zm-1.136 10.496l3.5 6a1 1 0 0 1 -.864 1.504h-7a1 1 0 0 1 -.864 -1.504l3.5 -6a1 1 0 0 1 1.728 0\" />"),
    SORT_DESCENDING_SHAPES(
        "sort-descending-shapes",
        "<path d=\"M7 5a1 1 0 0 1 1 1v9.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-9.586a1 1 0 0 1 1 -1m12 8a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2zm-1.136 -9.504l3.5 6a1 1 0 0 1 -.864 1.504h-7a1 1 0 0 1 -.864 -1.504l3.5 -6a1 1 0 0 1 1.728 0\" />"),
    SPARKLES(
        "sparkles",
        "<path d=\"M16 19a1 1 0 0 1 0 -2a1 1 0 0 0 1 -1c0 -1.333 2 -1.333 2 0a1 1 0 0 0 1 1c1.333 0 1.333 2 0 2a1 1 0 0 0 -1 1c0 1.333 -2 1.333 -2 0a1 1 0 0 0 -1 -1\" />\n  <path d=\"M3 11a5 5 0 0 0 5 -5c0 -1.333 2 -1.333 2 0a5 5 0 0 0 5 5c1.333 0 1.333 2 0 2a5 5 0 0 0 -5 5a1 1 0 0 1 -2 0a5 5 0 0 0 -5 -5c-1.333 0 -1.333 -2 0 -2\" />\n  <path d=\"M16 7a1 1 0 0 1 0 -2a1 1 0 0 0 1 -1c0 -1.333 2 -1.333 2 0a1 1 0 0 0 1 1c1.333 0 1.333 2 0 2a1 1 0 0 0 -1 1c0 1.333 -2 1.333 -2 0a1 1 0 0 0 -1 -1\" />"),
    SQUARE_F0(
        "square-f0",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.833 6a2.5 2.5 0 0 0 -2.495 2.336l-.005 .164v3l.005 .164a2.5 2.5 0 0 0 4.99 0l.005 -.164v-3l-.005 -.164a2.5 2.5 0 0 0 -2.495 -2.336zm-4.5 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm4.5 2a.5 .5 0 0 1 .492 .41l.008 .09v3l-.008 .09a.5 .5 0 0 1 -.984 0l-.008 -.09v-3l.008 -.09a.5 .5 0 0 1 .492 -.41z\" />"),
    SQUARE_F1(
        "square-f1",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-8.333 6h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm5.994 .886c-.083 -.777 -1.008 -1.16 -1.617 -.67l-.084 .077l-2 2l-.083 .094a1 1 0 0 0 0 1.226l.083 .094l.094 .083a1 1 0 0 0 1.226 0l.094 -.083l.293 -.293v3.586l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-6l-.006 -.114z\" />"),
    SQUARE_F2(
        "square-f2",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.333 6h-2l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h2v1h-1l-.15 .005a2 2 0 0 0 -1.844 1.838l-.006 .157v1l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h2l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-2v-1h1l.15 -.005a2 2 0 0 0 1.844 -1.838l.006 -.157v-1l-.005 -.15a2 2 0 0 0 -1.995 -1.85zm-5 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    SQUARE_F3(
        "square-f3",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.833 6h-1l-.144 .007a1.5 1.5 0 0 0 -1.356 1.493a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .727 -.457l.02 -.036h.636l.09 .008a.5 .5 0 0 1 0 .984l-.09 .008h-.5l-.133 .007c-1.156 .124 -1.156 1.862 0 1.986l.133 .007h.5l.09 .008a.5 .5 0 0 1 .41 .492l-.008 .09a.5 .5 0 0 1 -.492 .41h-.635l-.02 -.036a1 1 0 0 0 -1.845 .536a1.5 1.5 0 0 0 1.5 1.5h1l.164 -.005a2.5 2.5 0 0 0 2.336 -2.495l-.005 -.164a2.487 2.487 0 0 0 -.477 -1.312l-.019 -.024l.126 -.183a2.5 2.5 0 0 0 -2.125 -3.817zm-4.5 0h-2l-.117 .007a1 1 0 0 0 -.883 .993v6l.007 .117a1 1 0 0 0 .993 .883l.117 -.007a1 1 0 0 0 .883 -.993v-2h1l.117 -.007a1 1 0 0 0 -.117 -1.993h-1v-1h1l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    SQUARE_F4(
        "square-f4",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-2.333 6a1 1 0 0 0 -.993 .883l-.007 .117v2h-1v-2l-.007 -.117a1 1 0 0 0 -1.986 0l-.007 .117v2l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h1v2l.007 .117a1 1 0 0 0 1.986 0l.007 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm-6 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    SQUARE_F5(
        "square-f5",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-2.333 6h-3l-.117 .007a1 1 0 0 0 -.857 .764l-.02 .112l-.006 .117v3l.007 .117a1 1 0 0 0 .764 .857l.112 .02l.117 .006h2v1h-1.033l-.025 -.087l-.049 -.113a1 1 0 0 0 -1.893 .45c0 .867 .63 1.587 1.458 1.726l.148 .018l.144 .006h1.25l.157 -.006a2 2 0 0 0 1.819 -1.683l.019 -.162l.005 -.149v-1l-.006 -.157a2 2 0 0 0 -1.683 -1.819l-.162 -.019l-.149 -.005h-1v-1h2l.117 -.007a1 1 0 0 0 .857 -.764l.02 -.112l.006 -.117l-.007 -.117a1 1 0 0 0 -.764 -.857l-.112 -.02l-.117 -.006zm-6 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    SQUARE_F6(
        "square-f6",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.083 6h-1.25l-.15 .005a2 2 0 0 0 -1.844 1.838l-.006 .157v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h1l.15 -.005a2 2 0 0 0 1.844 -1.838l.006 -.157v-1l-.005 -.15a2 2 0 0 0 -1.838 -1.844l-.157 -.006h-1v-1h1.032l.026 .087a1 1 0 0 0 1.942 -.337a1.75 1.75 0 0 0 -1.606 -1.744l-.144 -.006zm-5.25 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm5 5v1h-1v-1h1z\" />"),
    SQUARE_F7(
        "square-f7",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-2.333 6h-3l-.117 .007a1 1 0 0 0 -.883 .993l.007 .117a1 1 0 0 0 .993 .883h1.718l-1.188 4.757l-.022 .115a1 1 0 0 0 1.962 .37l1.5 -6l.021 -.11a1 1 0 0 0 -.991 -1.132zm-6 0h-2l-.117 .007a1 1 0 0 0 -.883 .993v6l.007 .117a1 1 0 0 0 .993 .883l.117 -.007a1 1 0 0 0 .883 -.993v-2h1l.117 -.007a1 1 0 0 0 -.117 -1.993h-1v-1h1l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    SQUARE_F8(
        "square-f8",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.333 6h-1l-.15 .005a2 2 0 0 0 -1.844 1.838l-.006 .157v1l.005 .15c.018 .236 .077 .46 .17 .667l.075 .152l.018 .03l-.018 .032c-.133 .24 -.218 .509 -.243 .795l-.007 .174v1l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h1l.15 -.005a2 2 0 0 0 1.844 -1.838l.006 -.157v-1l-.005 -.15a1.988 1.988 0 0 0 -.17 -.667l-.075 -.152l-.019 -.032l.02 -.03a2.01 2.01 0 0 0 .242 -.795l.007 -.174v-1l-.005 -.15a2 2 0 0 0 -1.838 -1.844l-.157 -.006zm-5 0h-2l-.117 .007a1 1 0 0 0 -.876 .876l-.007 .117v6l.007 .117a1 1 0 0 0 .876 .876l.117 .007l.117 -.007a1 1 0 0 0 .876 -.876l.007 -.117v-2h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007h-1v-1h1l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm5 5v1h-1v-1h1zm0 -3v1h-1v-1h1z\" />"),
    SQUARE_F9(
        "square-f9",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.083 6h-1.5l-.144 .006a1.75 1.75 0 0 0 -1.606 1.744v1.5l.006 .144a1.75 1.75 0 0 0 1.744 1.606h1.25v1h-1.033l-.025 -.087a1 1 0 0 0 -1.942 .337c0 .966 .784 1.75 1.75 1.75h1.5l.144 -.006a1.75 1.75 0 0 0 1.606 -1.744v-4.5l-.006 -.144a1.75 1.75 0 0 0 -1.744 -1.606zm-5.25 0h-2l-.117 .007a1 1 0 0 0 -.883 .993v6l.007 .117a1 1 0 0 0 .993 .883l.117 -.007a1 1 0 0 0 .883 -.993v-2h1l.117 -.007a1 1 0 0 0 -.117 -1.993h-1v-1h1l.117 -.007a1 1 0 0 0 -.117 -1.993zm5 2v1h-1v-1h1z\" />"),
    STAR(
        "star",
        "<path d=\"M8.243 7.34l-6.38 .925l-.113 .023a1 1 0 0 0 -.44 1.684l4.622 4.499l-1.09 6.355l-.013 .11a1 1 0 0 0 1.464 .944l5.706 -3l5.693 3l.1 .046a1 1 0 0 0 1.352 -1.1l-1.091 -6.355l4.624 -4.5l.078 -.085a1 1 0 0 0 -.633 -1.62l-6.38 -.926l-2.852 -5.78a1 1 0 0 0 -1.794 0l-2.853 5.78z\" />"),
    STAR_HALF(
        "star-half",
        "<path d=\"M12 1a.993 .993 0 0 1 .823 .443l.067 .116l2.852 5.781l6.38 .925c.741 .108 1.08 .94 .703 1.526l-.07 .095l-.078 .086l-4.624 4.499l1.09 6.355a1.001 1.001 0 0 1 -1.249 1.135l-.101 -.035l-.101 -.046l-5.693 -3l-5.706 3c-.105 .055 -.212 .09 -.32 .106l-.106 .01a1.003 1.003 0 0 1 -1.038 -1.06l.013 -.11l1.09 -6.355l-4.623 -4.5a1.001 1.001 0 0 1 .328 -1.647l.113 -.036l.114 -.023l6.379 -.925l2.853 -5.78a.968 .968 0 0 1 .904 -.56zm0 3.274v12.476a1 1 0 0 1 .239 .029l.115 .036l.112 .05l4.363 2.299l-.836 -4.873a1 1 0 0 1 .136 -.696l.07 -.099l.082 -.09l3.546 -3.453l-4.891 -.708a1 1 0 0 1 -.62 -.344l-.073 -.097l-.06 -.106l-2.183 -4.424z\" />"),
    STARS(
        "stars",
        "<path d=\"M17.657 12.007a1.39 1.39 0 0 0 -1.103 .765l-.855 1.723l-1.907 .277c-.52 .072 -.96 .44 -1.124 .944l-.038 .14c-.1 .465 .046 .954 .393 1.29l1.377 1.337l-.326 1.892a1.393 1.393 0 0 0 2.018 1.465l1.708 -.895l1.708 .896a1.388 1.388 0 0 0 1.462 -.105l.112 -.09a1.39 1.39 0 0 0 .442 -1.272l-.325 -1.891l1.38 -1.339c.38 -.371 .516 -.924 .352 -1.427l-.051 -.134a1.39 1.39 0 0 0 -1.073 -.81l-1.907 -.278l-.853 -1.722a1.393 1.393 0 0 0 -1.247 -.773l-.143 .007z\" />\n  <path d=\"M6.057 12.007a1.39 1.39 0 0 0 -1.103 .765l-.855 1.723l-1.907 .277c-.52 .072 -.96 .44 -1.124 .944l-.038 .14c-.1 .465 .046 .954 .393 1.29l1.377 1.337l-.326 1.892a1.393 1.393 0 0 0 2.018 1.465l1.708 -.895l1.708 .896a1.388 1.388 0 0 0 1.462 -.105l.112 -.09a1.39 1.39 0 0 0 .442 -1.272l-.324 -1.891l1.38 -1.339c.38 -.371 .516 -.924 .352 -1.427l-.051 -.134a1.39 1.39 0 0 0 -1.073 -.81l-1.908 -.279l-.853 -1.722a1.393 1.393 0 0 0 -1.247 -.772l-.143 .007z\" />\n  <path d=\"M11.857 2.007a1.39 1.39 0 0 0 -1.103 .765l-.855 1.723l-1.907 .277c-.52 .072 -.96 .44 -1.124 .944l-.038 .14c-.1 .465 .046 .954 .393 1.29l1.377 1.337l-.326 1.892a1.393 1.393 0 0 0 2.018 1.465l1.708 -.894l1.709 .896a1.388 1.388 0 0 0 1.462 -.105l.112 -.09a1.39 1.39 0 0 0 .442 -1.272l-.325 -1.892l1.38 -1.339c.38 -.371 .516 -.924 .352 -1.427l-.051 -.134a1.39 1.39 0 0 0 -1.073 -.81l-1.908 -.279l-.853 -1.722a1.393 1.393 0 0 0 -1.247 -.772l-.143 .007z\" />"),
    TEST_PIPE_2(
        "test-pipe-2",
        "<path d=\"M16 2a1 1 0 0 1 0 2v14a4 4 0 1 1 -8 0v-14a1 1 0 1 1 0 -2zm-2 2h-4v7h4z\" />"),
    THUMB_DOWN(
        "thumb-down",
        "<path d=\"M13 21.008a3 3 0 0 0 2.995 -2.823l.005 -.177v-4h2a3 3 0 0 0 2.98 -2.65l.015 -.173l.005 -.177l-.02 -.196l-1.006 -5.032c-.381 -1.625 -1.502 -2.796 -2.81 -2.78l-.164 .008h-8a1 1 0 0 0 -.993 .884l-.007 .116l.001 9.536a1 1 0 0 0 .5 .866a2.998 2.998 0 0 1 1.492 2.396l.007 .202v1a3 3 0 0 0 3 3z\" />\n  <path d=\"M5 14.008a1 1 0 0 0 .993 -.883l.007 -.117v-9a1 1 0 0 0 -.883 -.993l-.117 -.007h-1a2 2 0 0 0 -1.995 1.852l-.005 .15v7a2 2 0 0 0 1.85 1.994l.15 .005h1z\" />"),
    THUMB_UP(
        "thumb-up",
        "<path d=\"M13 3a3 3 0 0 1 2.995 2.824l.005 .176v4h2a3 3 0 0 1 2.98 2.65l.015 .174l.005 .176l-.02 .196l-1.006 5.032c-.381 1.626 -1.502 2.796 -2.81 2.78l-.164 -.008h-8a1 1 0 0 1 -.993 -.883l-.007 -.117l.001 -9.536a1 1 0 0 1 .5 -.865a2.998 2.998 0 0 0 1.492 -2.397l.007 -.202v-1a3 3 0 0 1 3 -3z\" />\n  <path d=\"M5 10a1 1 0 0 1 .993 .883l.007 .117v9a1 1 0 0 1 -.883 .993l-.117 .007h-1a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-7a2 2 0 0 1 1.85 -1.995l.15 -.005h1z\" />"),
    TOGGLE_LEFT(
        "toggle-left",
        "<path d=\"M8 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />\n  <path d=\"M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10\" />"),
    TOGGLE_RIGHT(
        "toggle-right",
        "<path d=\"M16 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />\n  <path d=\"M16 5a7 7 0 0 1 0 14h-8a7 7 0 0 1 0 -14zm0 2h-8a5 5 0 1 0 0 10h8a5 5 0 0 0 0 -10\" />"),
    TRANSFORM(
        "transform",
        "<path d=\"M18 14a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M16.707 2.293a1 1 0 0 1 .083 1.32l-.083 .094l-1.293 1.293h3.586a3 3 0 0 1 2.995 2.824l.005 .176v3a1 1 0 0 1 -1.993 .117l-.007 -.117v-3a1 1 0 0 0 -.883 -.993l-.117 -.007h-3.585l1.292 1.293a1 1 0 0 1 -1.32 1.497l-.094 -.083l-3 -3a.98 .98 0 0 1 -.28 -.872l.036 -.146l.04 -.104c.058 -.126 .14 -.24 .245 -.334l2.959 -2.958a1 1 0 0 1 1.414 0z\" />\n  <path d=\"M3 12a1 1 0 0 1 .993 .883l.007 .117v3a1 1 0 0 0 .883 .993l.117 .007h3.585l-1.292 -1.293a1 1 0 0 1 -.083 -1.32l.083 -.094a1 1 0 0 1 1.32 -.083l.094 .083l3 3a.98 .98 0 0 1 .28 .872l-.036 .146l-.04 .104a1.02 1.02 0 0 1 -.245 .334l-2.959 2.958a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.291 -1.293h-3.584a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-3a1 1 0 0 1 1 -1z\" />\n  <path d=\"M6 2a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />"),
    TRASH(
        "trash",
        "<path d=\"M20 6a1 1 0 0 1 .117 1.993l-.117 .007h-.081l-.919 11a3 3 0 0 1 -2.824 2.995l-.176 .005h-8c-1.598 0 -2.904 -1.249 -2.992 -2.75l-.005 -.167l-.923 -11.083h-.08a1 1 0 0 1 -.117 -1.993l.117 -.007zm-10 4a1 1 0 0 0 -1 1v6a1 1 0 0 0 2 0v-6a1 1 0 0 0 -1 -1m4 0a1 1 0 0 0 -1 1v6a1 1 0 0 0 2 0v-6a1 1 0 0 0 -1 -1\" />\n  <path d=\"M14 2a2 2 0 0 1 2 2a1 1 0 0 1 -1.993 .117l-.007 -.117h-4l-.007 .117a1 1 0 0 1 -1.993 -.117a2 2 0 0 1 1.85 -1.995l.15 -.005z\" />"),
    TRASH_X(
        "trash-x",
        "<path d=\"M20 6a1 1 0 0 1 .117 1.993l-.117 .007h-.081l-.919 11a3 3 0 0 1 -2.824 2.995l-.176 .005h-8c-1.598 0 -2.904 -1.249 -2.992 -2.75l-.005 -.167l-.923 -11.083h-.08a1 1 0 0 1 -.117 -1.993l.117 -.007h16zm-9.489 5.14a1 1 0 0 0 -1.218 1.567l1.292 1.293l-1.292 1.293l-.083 .094a1 1 0 0 0 1.497 1.32l1.293 -1.292l1.293 1.292l.094 .083a1 1 0 0 0 1.32 -1.497l-1.292 -1.293l1.292 -1.293l.083 -.094a1 1 0 0 0 -1.497 -1.32l-1.293 1.292l-1.293 -1.292l-.094 -.083z\" />\n  <path d=\"M14 2a2 2 0 0 1 2 2a1 1 0 0 1 -1.993 .117l-.007 -.117h-4l-.007 .117a1 1 0 0 1 -1.993 -.117a2 2 0 0 1 1.85 -1.995l.15 -.005h4z\" />"),
    UMBRELLA(
        "umbrella",
        "<path d=\"M12 3a9 9 0 0 1 9 9a1 1 0 0 1 -.883 .993l-.117 .007h-7v5a1 1 0 0 0 1.993 .117l.007 -.117a1 1 0 0 1 2 0a3 3 0 0 1 -5.995 .176l-.005 -.176v-5h-7a1 1 0 0 1 -.993 -.883l-.007 -.117a9 9 0 0 1 9 -9z\" />"),
    USER(
        "user",
        "<path d=\"M12 2a5 5 0 1 1 -5 5l.005 -.217a5 5 0 0 1 4.995 -4.783z\" />\n  <path d=\"M14 14a5 5 0 0 1 5 5v1a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-1a5 5 0 0 1 5 -5h4z\" />"),
    WOMAN(
        "woman",
        "<path d=\"M14 8c1.91 0 3.79 .752 5.625 2.219a1 1 0 1 1 -1.25 1.562c-1.019 -.815 -2.016 -1.345 -2.997 -1.6l1.584 5.544a1 1 0 0 1 -.962 1.275h-1v4a1 1 0 0 1 -2 0v-4h-2v4a1 1 0 0 1 -2 0v-4h-1a1 1 0 0 1 -.962 -1.275l1.584 -5.545c-.98 .256 -1.978 .786 -2.997 1.601a1 1 0 1 1 -1.25 -1.562c1.733 -1.386 3.506 -2.133 5.307 -2.212l.335 -.007z\" />\n  <path d=\"M12 1a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />"),
    X(
        "x",
        "<path d=\"M6.707 5.293l5.293 5.292l5.293 -5.292a1 1 0 0 1 1.414 1.414l-5.292 5.293l5.292 5.293a1 1 0 0 1 -1.414 1.414l-5.293 -5.292l-5.293 5.292a1 1 0 1 1 -1.414 -1.414l5.292 -5.293l-5.292 -5.293a1 1 0 0 1 1.414 -1.414\" />"),
    ZOOM_SCAN(
        "zoom-scan",
        "<path d=\"M4 15a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1h2a1 1 0 0 1 0 2h-2a3 3 0 0 1 -3 -3v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M20 15a1 1 0 0 1 1 1v2a3 3 0 0 1 -3 3h-2a1 1 0 0 1 0 -2h2a1 1 0 0 0 1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M11 7a4 4 0 0 1 3.446 6.031l2.261 2.262a1 1 0 0 1 -1.414 1.414l-2.262 -2.26l-.031 .017a4 4 0 0 1 -6 -3.464l.005 -.2a4 4 0 0 1 3.995 -3.8\" />\n  <path d=\"M8 3a1 1 0 1 1 0 2h-2a1 1 0 0 0 -1 1v2a1 1 0 1 1 -2 0v-2a3 3 0 0 1 3 -3z\" />\n  <path d=\"M18 3a3 3 0 0 1 3 3v2a1 1 0 0 1 -2 0v-2a1 1 0 0 0 -1 -1h-2a1 1 0 0 1 0 -2z\" />");

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

  default TablerIcon ad_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AD_CIRCLE);
  }

  default TablerIcon ad_circle_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AD_CIRCLE_OFF);
  }

  default TablerIcon adjustments() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS);
  }

  default TablerIcon adjustments_alt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_ALT);
  }

  default TablerIcon adjustments_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_BOLT);
  }

  default TablerIcon adjustments_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_CANCEL);
  }

  default TablerIcon adjustments_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_CHECK);
  }

  default TablerIcon adjustments_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_CODE);
  }

  default TablerIcon adjustments_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_COG);
  }

  default TablerIcon adjustments_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_DOLLAR);
  }

  default TablerIcon adjustments_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_DOWN);
  }

  default TablerIcon adjustments_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_EXCLAMATION);
  }

  default TablerIcon adjustments_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_HEART);
  }

  default TablerIcon adjustments_horizontal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_HORIZONTAL);
  }

  default TablerIcon adjustments_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_MINUS);
  }

  default TablerIcon adjustments_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_OFF);
  }

  default TablerIcon adjustments_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_PAUSE);
  }

  default TablerIcon adjustments_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_PIN);
  }

  default TablerIcon adjustments_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_PLUS);
  }

  default TablerIcon adjustments_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_QUESTION);
  }

  default TablerIcon adjustments_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_SEARCH);
  }

  default TablerIcon adjustments_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_SHARE);
  }

  default TablerIcon adjustments_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_SPARK);
  }

  default TablerIcon adjustments_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_STAR);
  }

  default TablerIcon adjustments_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_UP);
  }

  default TablerIcon adjustments_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ADJUSTMENTS_X);
  }

  default TablerIcon affiliate() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AFFILIATE);
  }

  default TablerIcon alarm() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM);
  }

  default TablerIcon alarm_average() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM_AVERAGE);
  }

  default TablerIcon alarm_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM_MINUS);
  }

  default TablerIcon alarm_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM_OFF);
  }

  default TablerIcon alarm_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM_PLUS);
  }

  default TablerIcon alarm_snooze() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALARM_SNOOZE);
  }

  default TablerIcon alert_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_CIRCLE);
  }

  default TablerIcon alert_circle_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_CIRCLE_OFF);
  }

  default TablerIcon alert_hexagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_HEXAGON);
  }

  default TablerIcon alert_hexagon_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_HEXAGON_OFF);
  }

  default TablerIcon alert_octagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_OCTAGON);
  }

  default TablerIcon alert_small() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_SMALL);
  }

  default TablerIcon alert_small_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_SMALL_OFF);
  }

  default TablerIcon alert_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_SQUARE);
  }

  default TablerIcon alert_square_rounded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_SQUARE_ROUNDED);
  }

  default TablerIcon alert_square_rounded_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_SQUARE_ROUNDED_OFF);
  }

  default TablerIcon alert_triangle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_TRIANGLE);
  }

  default TablerIcon alert_triangle_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_TRIANGLE_OFF);
  }

  default TablerIcon analyze() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ANALYZE);
  }

  default TablerIcon analyze_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ANALYZE_OFF);
  }

  default TablerIcon app_window() {
    return TablerIcon.create(TablerSystem.OutlineIcon.APP_WINDOW);
  }

  default TablerIcon app_window_bottom() {
    return TablerIcon.create(TablerSystem.OutlineIcon.APP_WINDOW_BOTTOM);
  }

  default TablerIcon app_window_bottom_left() {
    return TablerIcon.create(TablerSystem.OutlineIcon.APP_WINDOW_BOTTOM_LEFT);
  }

  default TablerIcon app_window_bottom_right() {
    return TablerIcon.create(TablerSystem.OutlineIcon.APP_WINDOW_BOTTOM_RIGHT);
  }

  default TablerIcon app_window_center() {
    return TablerIcon.create(TablerSystem.OutlineIcon.APP_WINDOW_CENTER);
  }

  default TablerIcon augmented_reality() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AUGMENTED_REALITY);
  }

  default TablerIcon augmented_reality_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AUGMENTED_REALITY_2);
  }

  default TablerIcon augmented_reality_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AUGMENTED_REALITY_OFF);
  }

  default TablerIcon automation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.AUTOMATION);
  }

  default TablerIcon ban() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BAN);
  }

  default TablerIcon barcode() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BARCODE);
  }

  default TablerIcon barcode_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BARCODE_OFF);
  }

  default TablerIcon bell() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL);
  }

  default TablerIcon bell_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_BOLT);
  }

  default TablerIcon bell_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_CANCEL);
  }

  default TablerIcon bell_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_CHECK);
  }

  default TablerIcon bell_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_CODE);
  }

  default TablerIcon bell_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_COG);
  }

  default TablerIcon bell_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_DOLLAR);
  }

  default TablerIcon bell_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_DOWN);
  }

  default TablerIcon bell_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_EXCLAMATION);
  }

  default TablerIcon bell_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_HEART);
  }

  default TablerIcon bell_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_MINUS);
  }

  default TablerIcon bell_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_OFF);
  }

  default TablerIcon bell_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_PAUSE);
  }

  default TablerIcon bell_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_PIN);
  }

  default TablerIcon bell_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_PLUS);
  }

  default TablerIcon bell_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_QUESTION);
  }

  default TablerIcon bell_ringing() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_RINGING);
  }

  default TablerIcon bell_ringing_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_RINGING_2);
  }

  default TablerIcon bell_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_SEARCH);
  }

  default TablerIcon bell_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_SHARE);
  }

  default TablerIcon bell_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_STAR);
  }

  default TablerIcon bell_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_UP);
  }

  default TablerIcon bell_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_X);
  }

  default TablerIcon bell_z() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BELL_Z);
  }

  default TablerIcon blob() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BLOB);
  }

  default TablerIcon blob_dashed() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BLOB_DASHED);
  }

  default TablerIcon blocks() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BLOCKS);
  }

  default TablerIcon body_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BODY_SCAN);
  }

  default TablerIcon calendar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
  }

  default TablerIcon calendar_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_BOLT);
  }

  default TablerIcon calendar_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_CANCEL);
  }

  default TablerIcon calendar_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_CHECK);
  }

  default TablerIcon calendar_clock() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_CLOCK);
  }

  default TablerIcon calendar_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_CODE);
  }

  default TablerIcon calendar_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_COG);
  }

  default TablerIcon calendar_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_DOLLAR);
  }

  default TablerIcon calendar_dot() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_DOT);
  }

  default TablerIcon calendar_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_DOWN);
  }

  default TablerIcon calendar_due() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_DUE);
  }

  default TablerIcon calendar_event() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_EVENT);
  }

  default TablerIcon calendar_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_EXCLAMATION);
  }

  default TablerIcon calendar_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_HEART);
  }

  default TablerIcon calendar_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_MINUS);
  }

  default TablerIcon calendar_month() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_MONTH);
  }

  default TablerIcon calendar_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_OFF);
  }

  default TablerIcon calendar_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_PAUSE);
  }

  default TablerIcon calendar_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_PIN);
  }

  default TablerIcon calendar_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_PLUS);
  }

  default TablerIcon calendar_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_QUESTION);
  }

  default TablerIcon calendar_repeat() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_REPEAT);
  }

  default TablerIcon calendar_sad() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_SAD);
  }

  default TablerIcon calendar_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_SEARCH);
  }

  default TablerIcon calendar_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_SHARE);
  }

  default TablerIcon calendar_smile() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_SMILE);
  }

  default TablerIcon calendar_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_STAR);
  }

  default TablerIcon calendar_stats() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_STATS);
  }

  default TablerIcon calendar_time() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_TIME);
  }

  default TablerIcon calendar_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_UP);
  }

  default TablerIcon calendar_user() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_USER);
  }

  default TablerIcon calendar_week() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_WEEK);
  }

  default TablerIcon calendar_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR_X);
  }

  default TablerIcon check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CHECK);
  }

  default TablerIcon checkbox() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CHECKBOX);
  }

  default TablerIcon checklist() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CHECKLIST);
  }

  default TablerIcon checks() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CHECKS);
  }

  default TablerIcon clear_all() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLEAR_ALL);
  }

  default TablerIcon click() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLICK);
  }

  default TablerIcon clock() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK);
  }

  default TablerIcon clock_12() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_12);
  }

  default TablerIcon clock_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_2);
  }

  default TablerIcon clock_24() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_24);
  }

  default TablerIcon clock_bitcoin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_BITCOIN);
  }

  default TablerIcon clock_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_BOLT);
  }

  default TablerIcon clock_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_CANCEL);
  }

  default TablerIcon clock_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_CHECK);
  }

  default TablerIcon clock_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_CODE);
  }

  default TablerIcon clock_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_COG);
  }

  default TablerIcon clock_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_DOLLAR);
  }

  default TablerIcon clock_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_DOWN);
  }

  default TablerIcon clock_edit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_EDIT);
  }

  default TablerIcon clock_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_EXCLAMATION);
  }

  default TablerIcon clock_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HEART);
  }

  default TablerIcon clock_hour_1() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_1);
  }

  default TablerIcon clock_hour_10() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_10);
  }

  default TablerIcon clock_hour_11() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_11);
  }

  default TablerIcon clock_hour_12() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_12);
  }

  default TablerIcon clock_hour_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_2);
  }

  default TablerIcon clock_hour_3() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_3);
  }

  default TablerIcon clock_hour_4() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_4);
  }

  default TablerIcon clock_hour_5() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_5);
  }

  default TablerIcon clock_hour_6() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_6);
  }

  default TablerIcon clock_hour_7() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_7);
  }

  default TablerIcon clock_hour_8() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_8);
  }

  default TablerIcon clock_hour_9() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_HOUR_9);
  }

  default TablerIcon clock_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_MINUS);
  }

  default TablerIcon clock_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_OFF);
  }

  default TablerIcon clock_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_PAUSE);
  }

  default TablerIcon clock_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_PIN);
  }

  default TablerIcon clock_play() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_PLAY);
  }

  default TablerIcon clock_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_PLUS);
  }

  default TablerIcon clock_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_QUESTION);
  }

  default TablerIcon clock_record() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_RECORD);
  }

  default TablerIcon clock_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_SEARCH);
  }

  default TablerIcon clock_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_SHARE);
  }

  default TablerIcon clock_shield() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_SHIELD);
  }

  default TablerIcon clock_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_STAR);
  }

  default TablerIcon clock_stop() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_STOP);
  }

  default TablerIcon clock_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_UP);
  }

  default TablerIcon clock_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK_X);
  }

  default TablerIcon cloud_bitcoin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_BITCOIN);
  }

  default TablerIcon cloud_download() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_DOWNLOAD);
  }

  default TablerIcon cloud_lock() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_LOCK);
  }

  default TablerIcon cloud_lock_open() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_LOCK_OPEN);
  }

  default TablerIcon cloud_network() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_NETWORK);
  }

  default TablerIcon cloud_upload() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOUD_UPLOAD);
  }

  default TablerIcon code_variable() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CODE_VARIABLE);
  }

  default TablerIcon code_variable_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CODE_VARIABLE_MINUS);
  }

  default TablerIcon code_variable_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CODE_VARIABLE_PLUS);
  }

  default TablerIcon congruent_to() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CONGRUENT_TO);
  }

  default TablerIcon creative_commons() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS);
  }

  default TablerIcon creative_commons_by() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_BY);
  }

  default TablerIcon creative_commons_nc() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_NC);
  }

  default TablerIcon creative_commons_nd() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_ND);
  }

  default TablerIcon creative_commons_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_OFF);
  }

  default TablerIcon creative_commons_sa() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_SA);
  }

  default TablerIcon creative_commons_zero() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREATIVE_COMMONS_ZERO);
  }

  default TablerIcon credits() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CREDITS);
  }

  default TablerIcon crosshair() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CROSSHAIR);
  }

  default TablerIcon cube_3d_sphere() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CUBE_3D_SPHERE);
  }

  default TablerIcon cube_3d_sphere_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CUBE_3D_SPHERE_OFF);
  }

  default TablerIcon cube_send() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CUBE_SEND);
  }

  default TablerIcon cube_unfolded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CUBE_UNFOLDED);
  }

  default TablerIcon curly_loop() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CURLY_LOOP);
  }

  default TablerIcon cursor_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CURSOR_OFF);
  }

  default TablerIcon dashboard() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DASHBOARD);
  }

  default TablerIcon dashboard_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DASHBOARD_OFF);
  }

  default TablerIcon database_smile() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DATABASE_SMILE);
  }

  default TablerIcon dental_broken() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DENTAL_BROKEN);
  }

  default TablerIcon deselect() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DESELECT);
  }

  default TablerIcon desk() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DESK);
  }

  default TablerIcon details() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DETAILS);
  }

  default TablerIcon details_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DETAILS_OFF);
  }

  default TablerIcon device_projector() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DEVICE_PROJECTOR);
  }

  default TablerIcon device_unknown() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DEVICE_UNKNOWN);
  }

  default TablerIcon device_workstation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DEVICE_WORKSTATION);
  }

  default TablerIcon direction() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DIRECTION);
  }

  default TablerIcon direction_arrows() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DIRECTION_ARROWS);
  }

  default TablerIcon direction_horizontal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DIRECTION_HORIZONTAL);
  }

  default TablerIcon direction_sign() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DIRECTION_SIGN);
  }

  default TablerIcon direction_sign_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DIRECTION_SIGN_OFF);
  }

  default TablerIcon door() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOOR);
  }

  default TablerIcon door_enter() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOOR_ENTER);
  }

  default TablerIcon door_exit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOOR_EXIT);
  }

  default TablerIcon door_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOOR_OFF);
  }

  default TablerIcon dots() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS);
  }

  default TablerIcon dots_circle_horizontal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS_CIRCLE_HORIZONTAL);
  }

  default TablerIcon dots_diagonal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS_DIAGONAL);
  }

  default TablerIcon dots_diagonal_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS_DIAGONAL_2);
  }

  default TablerIcon dots_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS_VERTICAL);
  }

  default TablerIcon ear_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EAR_SCAN);
  }

  default TablerIcon elevator() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ELEVATOR);
  }

  default TablerIcon elevator_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ELEVATOR_OFF);
  }

  default TablerIcon exchange() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCHANGE);
  }

  default TablerIcon exchange_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCHANGE_OFF);
  }

  default TablerIcon exclamation_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCLAMATION_CIRCLE);
  }

  default TablerIcon exclamation_mark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCLAMATION_MARK);
  }

  default TablerIcon exclamation_mark_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCLAMATION_MARK_OFF);
  }

  default TablerIcon explicit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXPLICIT);
  }

  default TablerIcon explicit_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXPLICIT_OFF);
  }

  default TablerIcon external_link() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXTERNAL_LINK);
  }

  default TablerIcon external_link_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXTERNAL_LINK_OFF);
  }

  default TablerIcon eye() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE);
  }

  default TablerIcon eye_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_BOLT);
  }

  default TablerIcon eye_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_CANCEL);
  }

  default TablerIcon eye_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_CHECK);
  }

  default TablerIcon eye_closed() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_CLOSED);
  }

  default TablerIcon eye_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_CODE);
  }

  default TablerIcon eye_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_COG);
  }

  default TablerIcon eye_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_DOLLAR);
  }

  default TablerIcon eye_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_DOWN);
  }

  default TablerIcon eye_edit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_EDIT);
  }

  default TablerIcon eye_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_EXCLAMATION);
  }

  default TablerIcon eye_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_HEART);
  }

  default TablerIcon eye_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_MINUS);
  }

  default TablerIcon eye_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_OFF);
  }

  default TablerIcon eye_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_PAUSE);
  }

  default TablerIcon eye_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_PIN);
  }

  default TablerIcon eye_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_PLUS);
  }

  default TablerIcon eye_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_QUESTION);
  }

  default TablerIcon eye_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_SEARCH);
  }

  default TablerIcon eye_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_SHARE);
  }

  default TablerIcon eye_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_SPARK);
  }

  default TablerIcon eye_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_STAR);
  }

  default TablerIcon eye_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_UP);
  }

  default TablerIcon eye_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EYE_X);
  }

  default TablerIcon face_id() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FACE_ID);
  }

  default TablerIcon face_id_error() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FACE_ID_ERROR);
  }

  default TablerIcon fidget_spinner() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FIDGET_SPINNER);
  }

  default TablerIcon filter() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER);
  }

  default TablerIcon filter_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2);
  }

  default TablerIcon filter_2_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_BOLT);
  }

  default TablerIcon filter_2_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_CANCEL);
  }

  default TablerIcon filter_2_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_CHECK);
  }

  default TablerIcon filter_2_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_CODE);
  }

  default TablerIcon filter_2_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_COG);
  }

  default TablerIcon filter_2_discount() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_DISCOUNT);
  }

  default TablerIcon filter_2_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_DOLLAR);
  }

  default TablerIcon filter_2_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_DOWN);
  }

  default TablerIcon filter_2_edit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_EDIT);
  }

  default TablerIcon filter_2_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_EXCLAMATION);
  }

  default TablerIcon filter_2_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_MINUS);
  }

  default TablerIcon filter_2_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_PAUSE);
  }

  default TablerIcon filter_2_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_PIN);
  }

  default TablerIcon filter_2_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_PLUS);
  }

  default TablerIcon filter_2_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_QUESTION);
  }

  default TablerIcon filter_2_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_SEARCH);
  }

  default TablerIcon filter_2_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_SHARE);
  }

  default TablerIcon filter_2_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_SPARK);
  }

  default TablerIcon filter_2_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_UP);
  }

  default TablerIcon filter_2_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_2_X);
  }

  default TablerIcon filter_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_BOLT);
  }

  default TablerIcon filter_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_CANCEL);
  }

  default TablerIcon filter_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_CHECK);
  }

  default TablerIcon filter_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_CODE);
  }

  default TablerIcon filter_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_COG);
  }

  default TablerIcon filter_discount() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_DISCOUNT);
  }

  default TablerIcon filter_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_DOLLAR);
  }

  default TablerIcon filter_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_DOWN);
  }

  default TablerIcon filter_edit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_EDIT);
  }

  default TablerIcon filter_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_EXCLAMATION);
  }

  default TablerIcon filter_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_HEART);
  }

  default TablerIcon filter_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_MINUS);
  }

  default TablerIcon filter_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_OFF);
  }

  default TablerIcon filter_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_PAUSE);
  }

  default TablerIcon filter_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_PIN);
  }

  default TablerIcon filter_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_PLUS);
  }

  default TablerIcon filter_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_QUESTION);
  }

  default TablerIcon filter_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_SEARCH);
  }

  default TablerIcon filter_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_SHARE);
  }

  default TablerIcon filter_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_SPARK);
  }

  default TablerIcon filter_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_STAR);
  }

  default TablerIcon filter_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_UP);
  }

  default TablerIcon filter_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_X);
  }

  default TablerIcon filters() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FILTERS);
  }

  default TablerIcon fingerprint() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FINGERPRINT);
  }

  default TablerIcon fingerprint_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FINGERPRINT_OFF);
  }

  default TablerIcon fire_extinguisher() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FIRE_EXTINGUISHER);
  }

  default TablerIcon flag_bitcoin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FLAG_BITCOIN);
  }

  default TablerIcon flag_discount() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FLAG_DISCOUNT);
  }

  default TablerIcon focus_centered() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FOCUS_CENTERED);
  }

  default TablerIcon forbid() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FORBID);
  }

  default TablerIcon forbid_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FORBID_2);
  }

  default TablerIcon free_rights() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FREE_RIGHTS);
  }

  default TablerIcon friends() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FRIENDS);
  }

  default TablerIcon friends_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.FRIENDS_OFF);
  }

  default TablerIcon galaxy() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GALAXY);
  }

  default TablerIcon gauge() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GAUGE);
  }

  default TablerIcon gauge_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GAUGE_OFF);
  }

  default TablerIcon gavel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GAVEL);
  }

  default TablerIcon graph() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRAPH);
  }

  default TablerIcon graph_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRAPH_OFF);
  }

  default TablerIcon grid_dots() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRID_DOTS);
  }

  default TablerIcon grid_pattern() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRID_PATTERN);
  }

  default TablerIcon grid_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRID_SCAN);
  }

  default TablerIcon grip_horizontal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRIP_HORIZONTAL);
  }

  default TablerIcon grip_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRIP_VERTICAL);
  }

  default TablerIcon gymnastics() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GYMNASTICS);
  }

  default TablerIcon hanger_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HANGER_2);
  }

  default TablerIcon haze_moon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HAZE_MOON);
  }

  default TablerIcon health_recognition() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HEALTH_RECOGNITION);
  }

  default TablerIcon help() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP);
  }

  default TablerIcon help_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon help_hexagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_HEXAGON);
  }

  default TablerIcon help_octagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_OCTAGON);
  }

  default TablerIcon help_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_OFF);
  }

  default TablerIcon help_small() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_SMALL);
  }

  default TablerIcon help_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_SQUARE);
  }

  default TablerIcon help_square_rounded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_SQUARE_ROUNDED);
  }

  default TablerIcon help_triangle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_TRIANGLE);
  }

  default TablerIcon history() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HISTORY);
  }

  default TablerIcon history_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HISTORY_OFF);
  }

  default TablerIcon history_toggle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HISTORY_TOGGLE);
  }

  default TablerIcon hourglass() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURGLASS);
  }

  default TablerIcon hourglass_empty() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURGLASS_EMPTY);
  }

  default TablerIcon hourglass_high() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURGLASS_HIGH);
  }

  default TablerIcon hourglass_low() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURGLASS_LOW);
  }

  default TablerIcon hourglass_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURGLASS_OFF);
  }

  default TablerIcon hours_12() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURS_12);
  }

  default TablerIcon hours_24() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HOURS_24);
  }

  default TablerIcon id() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ID);
  }

  default TablerIcon id_badge() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ID_BADGE);
  }

  default TablerIcon id_badge_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ID_BADGE_2);
  }

  default TablerIcon id_badge_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ID_BADGE_OFF);
  }

  default TablerIcon id_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ID_OFF);
  }

  default TablerIcon inbox() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INBOX);
  }

  default TablerIcon inbox_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INBOX_OFF);
  }

  default TablerIcon info_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_CIRCLE);
  }

  default TablerIcon info_hexagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_HEXAGON);
  }

  default TablerIcon info_octagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_OCTAGON);
  }

  default TablerIcon info_small() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_SMALL);
  }

  default TablerIcon info_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_SQUARE);
  }

  default TablerIcon info_square_rounded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_SQUARE_ROUNDED);
  }

  default TablerIcon info_triangle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INFO_TRIANGLE);
  }

  default TablerIcon input_ai() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INPUT_AI);
  }

  default TablerIcon input_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INPUT_CHECK);
  }

  default TablerIcon input_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INPUT_SPARK);
  }

  default TablerIcon input_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.INPUT_X);
  }

  default TablerIcon jetpack() {
    return TablerIcon.create(TablerSystem.OutlineIcon.JETPACK);
  }

  default TablerIcon join_bevel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.JOIN_BEVEL);
  }

  default TablerIcon join_round() {
    return TablerIcon.create(TablerSystem.OutlineIcon.JOIN_ROUND);
  }

  default TablerIcon join_straight() {
    return TablerIcon.create(TablerSystem.OutlineIcon.JOIN_STRAIGHT);
  }

  default TablerIcon label() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LABEL);
  }

  default TablerIcon label_important() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LABEL_IMPORTANT);
  }

  default TablerIcon label_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LABEL_OFF);
  }

  default TablerIcon ladder() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LADDER);
  }

  default TablerIcon ladder_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LADDER_OFF);
  }

  default TablerIcon lane() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LANE);
  }

  default TablerIcon layout_bottombar_inactive() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LAYOUT_BOTTOMBAR_INACTIVE);
  }

  default TablerIcon layout_navbar_inactive() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LAYOUT_NAVBAR_INACTIVE);
  }

  default TablerIcon layout_sidebar_inactive() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LAYOUT_SIDEBAR_INACTIVE);
  }

  default TablerIcon layout_sidebar_right_inactive() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LAYOUT_SIDEBAR_RIGHT_INACTIVE);
  }

  default TablerIcon lego() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LEGO);
  }

  default TablerIcon lego_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LEGO_OFF);
  }

  default TablerIcon library() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIBRARY);
  }

  default TablerIcon library_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIBRARY_MINUS);
  }

  default TablerIcon library_photo() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIBRARY_PHOTO);
  }

  default TablerIcon library_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIBRARY_PLUS);
  }

  default TablerIcon lifebuoy() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIFEBUOY);
  }

  default TablerIcon lifebuoy_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIFEBUOY_OFF);
  }

  default TablerIcon lighter() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIGHTER);
  }

  default TablerIcon line_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LINE_SCAN);
  }

  default TablerIcon list_letters() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIST_LETTERS);
  }

  default TablerIcon list_tree() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LIST_TREE);
  }

  default TablerIcon loader() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOADER);
  }

  default TablerIcon loader_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOADER_2);
  }

  default TablerIcon loader_3() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOADER_3);
  }

  default TablerIcon loader_4() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOADER_4);
  }

  default TablerIcon loader_quarter() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOADER_QUARTER);
  }

  default TablerIcon location_discount() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCATION_DISCOUNT);
  }

  default TablerIcon lock() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK);
  }

  default TablerIcon lock_access() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_ACCESS);
  }

  default TablerIcon lock_access_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_ACCESS_OFF);
  }

  default TablerIcon lock_bitcoin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_BITCOIN);
  }

  default TablerIcon lock_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_BOLT);
  }

  default TablerIcon lock_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_CANCEL);
  }

  default TablerIcon lock_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_CHECK);
  }

  default TablerIcon lock_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_CODE);
  }

  default TablerIcon lock_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_COG);
  }

  default TablerIcon lock_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_DOLLAR);
  }

  default TablerIcon lock_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_DOWN);
  }

  default TablerIcon lock_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_EXCLAMATION);
  }

  default TablerIcon lock_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_HEART);
  }

  default TablerIcon lock_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_MINUS);
  }

  default TablerIcon lock_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_OFF);
  }

  default TablerIcon lock_open() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_OPEN);
  }

  default TablerIcon lock_open_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_OPEN_2);
  }

  default TablerIcon lock_open_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_OPEN_OFF);
  }

  default TablerIcon lock_password() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_PASSWORD);
  }

  default TablerIcon lock_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_PAUSE);
  }

  default TablerIcon lock_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_PIN);
  }

  default TablerIcon lock_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_PLUS);
  }

  default TablerIcon lock_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_QUESTION);
  }

  default TablerIcon lock_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_SEARCH);
  }

  default TablerIcon lock_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_SHARE);
  }

  default TablerIcon lock_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_SQUARE);
  }

  default TablerIcon lock_square_rounded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_SQUARE_ROUNDED);
  }

  default TablerIcon lock_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_STAR);
  }

  default TablerIcon lock_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_UP);
  }

  default TablerIcon lock_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOCK_X);
  }

  default TablerIcon logout() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOGOUT);
  }

  default TablerIcon logout_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LOGOUT_2);
  }

  default TablerIcon luggage() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LUGGAGE);
  }

  default TablerIcon luggage_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.LUGGAGE_OFF);
  }

  default TablerIcon man() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MAN);
  }

  default TablerIcon marquee() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MARQUEE);
  }

  default TablerIcon marquee_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MARQUEE_2);
  }

  default TablerIcon marquee_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MARQUEE_OFF);
  }

  default TablerIcon matchstick() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MATCHSTICK);
  }

  default TablerIcon menu() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU);
  }

  default TablerIcon menu_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU_2);
  }

  default TablerIcon menu_3() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU_3);
  }

  default TablerIcon menu_4() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU_4);
  }

  default TablerIcon menu_deep() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU_DEEP);
  }

  default TablerIcon menu_order() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MENU_ORDER);
  }

  default TablerIcon meter_cube() {
    return TablerIcon.create(TablerSystem.OutlineIcon.METER_CUBE);
  }

  default TablerIcon meter_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.METER_SQUARE);
  }

  default TablerIcon metronome() {
    return TablerIcon.create(TablerSystem.OutlineIcon.METRONOME);
  }

  default TablerIcon military_award() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MILITARY_AWARD);
  }

  default TablerIcon military_rank() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MILITARY_RANK);
  }

  default TablerIcon minus_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MINUS_VERTICAL);
  }

  default TablerIcon mobiledata() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MOBILEDATA);
  }

  default TablerIcon mobiledata_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MOBILEDATA_OFF);
  }

  default TablerIcon music_discount() {
    return TablerIcon.create(TablerSystem.OutlineIcon.MUSIC_DISCOUNT);
  }

  default TablerIcon new_section() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NEW_SECTION);
  }

  default TablerIcon no_copyright() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NO_COPYRIGHT);
  }

  default TablerIcon no_creative_commons() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NO_CREATIVE_COMMONS);
  }

  default TablerIcon no_derivatives() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NO_DERIVATIVES);
  }

  default TablerIcon notification() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NOTIFICATION);
  }

  default TablerIcon notification_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.NOTIFICATION_OFF);
  }

  default TablerIcon object_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.OBJECT_SCAN);
  }

  default TablerIcon outbound() {
    return TablerIcon.create(TablerSystem.OutlineIcon.OUTBOUND);
  }

  default TablerIcon outlet() {
    return TablerIcon.create(TablerSystem.OutlineIcon.OUTLET);
  }

  default TablerIcon password() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PASSWORD);
  }

  default TablerIcon password_fingerprint() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PASSWORD_FINGERPRINT);
  }

  default TablerIcon password_mobile_phone() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PASSWORD_MOBILE_PHONE);
  }

  default TablerIcon password_user() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PASSWORD_USER);
  }

  default TablerIcon paywall() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PAYWALL);
  }

  default TablerIcon percentage_0() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_0);
  }

  default TablerIcon percentage_10() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_10);
  }

  default TablerIcon percentage_100() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_100);
  }

  default TablerIcon percentage_20() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_20);
  }

  default TablerIcon percentage_25() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_25);
  }

  default TablerIcon percentage_30() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_30);
  }

  default TablerIcon percentage_33() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_33);
  }

  default TablerIcon percentage_40() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_40);
  }

  default TablerIcon percentage_50() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_50);
  }

  default TablerIcon percentage_60() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_60);
  }

  default TablerIcon percentage_66() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_66);
  }

  default TablerIcon percentage_70() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_70);
  }

  default TablerIcon percentage_75() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_75);
  }

  default TablerIcon percentage_80() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_80);
  }

  default TablerIcon percentage_90() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PERCENTAGE_90);
  }

  default TablerIcon photo_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PHOTO_SCAN);
  }

  default TablerIcon pillow() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PILLOW);
  }

  default TablerIcon pin_end() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PIN_END);
  }

  default TablerIcon pin_invoke() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PIN_INVOKE);
  }

  default TablerIcon playlist_add() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PLAYLIST_ADD);
  }

  default TablerIcon point() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINT);
  }

  default TablerIcon point_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINT_OFF);
  }

  default TablerIcon pointer() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER);
  }

  default TablerIcon pointer_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_2);
  }

  default TablerIcon pointer_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_BOLT);
  }

  default TablerIcon pointer_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_CANCEL);
  }

  default TablerIcon pointer_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_CHECK);
  }

  default TablerIcon pointer_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_CODE);
  }

  default TablerIcon pointer_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_COG);
  }

  default TablerIcon pointer_collaboration() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_COLLABORATION);
  }

  default TablerIcon pointer_collaboration_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_COLLABORATION_2);
  }

  default TablerIcon pointer_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_DOLLAR);
  }

  default TablerIcon pointer_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_DOWN);
  }

  default TablerIcon pointer_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_EXCLAMATION);
  }

  default TablerIcon pointer_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_HEART);
  }

  default TablerIcon pointer_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_MINUS);
  }

  default TablerIcon pointer_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_OFF);
  }

  default TablerIcon pointer_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_PAUSE);
  }

  default TablerIcon pointer_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_PIN);
  }

  default TablerIcon pointer_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_PLUS);
  }

  default TablerIcon pointer_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_QUESTION);
  }

  default TablerIcon pointer_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_SEARCH);
  }

  default TablerIcon pointer_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_SHARE);
  }

  default TablerIcon pointer_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_STAR);
  }

  default TablerIcon pointer_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_UP);
  }

  default TablerIcon pointer_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POINTER_X);
  }

  default TablerIcon poo() {
    return TablerIcon.create(TablerSystem.OutlineIcon.POO);
  }

  default TablerIcon pray() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PRAY);
  }

  default TablerIcon premium_rights() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PREMIUM_RIGHTS);
  }

  default TablerIcon prism_light() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PRISM_LIGHT);
  }

  default TablerIcon progress() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS);
  }

  default TablerIcon progress_alert() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_ALERT);
  }

  default TablerIcon progress_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_BOLT);
  }

  default TablerIcon progress_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_CHECK);
  }

  default TablerIcon progress_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_DOWN);
  }

  default TablerIcon progress_help() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_HELP);
  }

  default TablerIcon progress_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROGRESS_X);
  }

  default TablerIcon propeller() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROPELLER);
  }

  default TablerIcon propeller_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROPELLER_OFF);
  }

  default TablerIcon protocol() {
    return TablerIcon.create(TablerSystem.OutlineIcon.PROTOCOL);
  }

  default TablerIcon question_mark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.QUESTION_MARK);
  }

  default TablerIcon recharging() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RECHARGING);
  }

  default TablerIcon record_mail() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RECORD_MAIL);
  }

  default TablerIcon record_mail_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RECORD_MAIL_OFF);
  }

  default TablerIcon reduce_motion() {
    return TablerIcon.create(TablerSystem.OutlineIcon.REDUCE_MOTION);
  }

  default TablerIcon reorder() {
    return TablerIcon.create(TablerSystem.OutlineIcon.REORDER);
  }

  default TablerIcon replace() {
    return TablerIcon.create(TablerSystem.OutlineIcon.REPLACE);
  }

  default TablerIcon replace_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.REPLACE_OFF);
  }

  default TablerIcon replace_user() {
    return TablerIcon.create(TablerSystem.OutlineIcon.REPLACE_USER);
  }

  default TablerIcon reserved_line() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RESERVED_LINE);
  }

  default TablerIcon restore() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RESTORE);
  }

  default TablerIcon robot_face() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ROBOT_FACE);
  }

  default TablerIcon robot_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ROBOT_OFF);
  }

  default TablerIcon rotate_3d() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ROTATE_3D);
  }

  default TablerIcon route_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ROUTE_SCAN);
  }

  default TablerIcon rv_truck() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RV_TRUCK);
  }

  default TablerIcon sandbox() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SANDBOX);
  }

  default TablerIcon scale() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCALE);
  }

  default TablerIcon scale_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCALE_OFF);
  }

  default TablerIcon scale_outline() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCALE_OUTLINE);
  }

  default TablerIcon scale_outline_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCALE_OUTLINE_OFF);
  }

  default TablerIcon scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCAN);
  }

  default TablerIcon scan_cube() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCAN_CUBE);
  }

  default TablerIcon scan_eye() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCAN_EYE);
  }

  default TablerIcon scan_position() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SCAN_POSITION);
  }

  default TablerIcon search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SEARCH);
  }

  default TablerIcon search_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SEARCH_OFF);
  }

  default TablerIcon secret_phrases() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SECRET_PHRASES);
  }

  default TablerIcon select_all() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SELECT_ALL);
  }

  default TablerIcon settings() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS);
  }

  default TablerIcon settings_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_2);
  }

  default TablerIcon settings_ai() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_AI);
  }

  default TablerIcon settings_automation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_AUTOMATION);
  }

  default TablerIcon settings_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_BOLT);
  }

  default TablerIcon settings_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_CANCEL);
  }

  default TablerIcon settings_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_CHECK);
  }

  default TablerIcon settings_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_CODE);
  }

  default TablerIcon settings_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_COG);
  }

  default TablerIcon settings_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_DOLLAR);
  }

  default TablerIcon settings_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_DOWN);
  }

  default TablerIcon settings_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_EXCLAMATION);
  }

  default TablerIcon settings_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_HEART);
  }

  default TablerIcon settings_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_MINUS);
  }

  default TablerIcon settings_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_OFF);
  }

  default TablerIcon settings_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_PAUSE);
  }

  default TablerIcon settings_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_PIN);
  }

  default TablerIcon settings_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_PLUS);
  }

  default TablerIcon settings_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_QUESTION);
  }

  default TablerIcon settings_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_SEARCH);
  }

  default TablerIcon settings_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_SHARE);
  }

  default TablerIcon settings_spark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_SPARK);
  }

  default TablerIcon settings_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_STAR);
  }

  default TablerIcon settings_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_UP);
  }

  default TablerIcon settings_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SETTINGS_X);
  }

  default TablerIcon share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHARE);
  }

  default TablerIcon share_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHARE_OFF);
  }

  default TablerIcon shield() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD);
  }

  default TablerIcon shield_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_BOLT);
  }

  default TablerIcon shield_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_CANCEL);
  }

  default TablerIcon shield_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_CHECK);
  }

  default TablerIcon shield_checkered() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_CHECKERED);
  }

  default TablerIcon shield_chevron() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_CHEVRON);
  }

  default TablerIcon shield_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_CODE);
  }

  default TablerIcon shield_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_COG);
  }

  default TablerIcon shield_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_DOLLAR);
  }

  default TablerIcon shield_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_DOWN);
  }

  default TablerIcon shield_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_EXCLAMATION);
  }

  default TablerIcon shield_half() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_HALF);
  }

  default TablerIcon shield_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_HEART);
  }

  default TablerIcon shield_lock() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_LOCK);
  }

  default TablerIcon shield_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_MINUS);
  }

  default TablerIcon shield_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_OFF);
  }

  default TablerIcon shield_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_PAUSE);
  }

  default TablerIcon shield_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_PIN);
  }

  default TablerIcon shield_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_PLUS);
  }

  default TablerIcon shield_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_QUESTION);
  }

  default TablerIcon shield_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_SEARCH);
  }

  default TablerIcon shield_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_SHARE);
  }

  default TablerIcon shield_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_STAR);
  }

  default TablerIcon shield_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_UP);
  }

  default TablerIcon shield_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SHIELD_X);
  }

  default TablerIcon skew_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SKEW_X);
  }

  default TablerIcon skew_y() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SKEW_Y);
  }

  default TablerIcon slashes() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SLASHES);
  }

  default TablerIcon snowboarding() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SNOWBOARDING);
  }

  default TablerIcon social() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOCIAL);
  }

  default TablerIcon social_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOCIAL_OFF);
  }

  default TablerIcon sofa() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOFA);
  }

  default TablerIcon sofa_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOFA_OFF);
  }

  default TablerIcon solar_electricity() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOLAR_ELECTRICITY);
  }

  default TablerIcon solar_panel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOLAR_PANEL);
  }

  default TablerIcon solar_panel_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOLAR_PANEL_2);
  }

  default TablerIcon sort_ascending_shapes() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SORT_ASCENDING_SHAPES);
  }

  default TablerIcon sort_ascending_small_big() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SORT_ASCENDING_SMALL_BIG);
  }

  default TablerIcon sort_descending_shapes() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SORT_DESCENDING_SHAPES);
  }

  default TablerIcon sort_descending_small_big() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SORT_DESCENDING_SMALL_BIG);
  }

  default TablerIcon sos() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SOS);
  }

  default TablerIcon spaces() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPACES);
  }

  default TablerIcon sparkles() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPARKLES);
  }

  default TablerIcon spiral() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPIRAL);
  }

  default TablerIcon spiral_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPIRAL_OFF);
  }

  default TablerIcon spray() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPRAY);
  }

  default TablerIcon spy() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPY);
  }

  default TablerIcon spy_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SPY_OFF);
  }

  default TablerIcon square_f0() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F0);
  }

  default TablerIcon square_f1() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F1);
  }

  default TablerIcon square_f2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F2);
  }

  default TablerIcon square_f3() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F3);
  }

  default TablerIcon square_f4() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F4);
  }

  default TablerIcon square_f5() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F5);
  }

  default TablerIcon square_f6() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F6);
  }

  default TablerIcon square_f7() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F7);
  }

  default TablerIcon square_f8() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F8);
  }

  default TablerIcon square_f9() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SQUARE_F9);
  }

  default TablerIcon stack_back() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STACK_BACK);
  }

  default TablerIcon stack_backward() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STACK_BACKWARD);
  }

  default TablerIcon stack_forward() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STACK_FORWARD);
  }

  default TablerIcon stack_front() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STACK_FRONT);
  }

  default TablerIcon stack_middle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STACK_MIDDLE);
  }

  default TablerIcon star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STAR);
  }

  default TablerIcon star_half() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STAR_HALF);
  }

  default TablerIcon star_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STAR_OFF);
  }

  default TablerIcon stars() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STARS);
  }

  default TablerIcon stars_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STARS_OFF);
  }

  default TablerIcon status_change() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STATUS_CHANGE);
  }

  default TablerIcon steam() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STEAM);
  }

  default TablerIcon stereo_glasses() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STEREO_GLASSES);
  }

  default TablerIcon stopwatch() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STOPWATCH);
  }

  default TablerIcon subtask() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SUBTASK);
  }

  default TablerIcon swipe() {
    return TablerIcon.create(TablerSystem.OutlineIcon.SWIPE);
  }

  default TablerIcon tab_close() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TAB_CLOSE);
  }

  default TablerIcon table_dashed() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TABLE_DASHED);
  }

  default TablerIcon tabs() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TABS);
  }

  default TablerIcon telescope() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TELESCOPE);
  }

  default TablerIcon telescope_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TELESCOPE_OFF);
  }

  default TablerIcon temperature_snow() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEMPERATURE_SNOW);
  }

  default TablerIcon temperature_sun() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEMPERATURE_SUN);
  }

  default TablerIcon terminal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TERMINAL);
  }

  default TablerIcon test_pipe() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEST_PIPE);
  }

  default TablerIcon test_pipe_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEST_PIPE_2);
  }

  default TablerIcon test_pipe_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEST_PIPE_OFF);
  }

  default TablerIcon text_scan_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEXT_SCAN_2);
  }

  default TablerIcon text_scan_ai() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEXT_SCAN_AI);
  }

  default TablerIcon texture() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TEXTURE);
  }

  default TablerIcon thumb_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.THUMB_DOWN);
  }

  default TablerIcon thumb_down_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.THUMB_DOWN_OFF);
  }

  default TablerIcon thumb_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.THUMB_UP);
  }

  default TablerIcon thumb_up_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.THUMB_UP_OFF);
  }

  default TablerIcon tilde() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TILDE);
  }

  default TablerIcon time_duration_0() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_0);
  }

  default TablerIcon time_duration_10() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_10);
  }

  default TablerIcon time_duration_15() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_15);
  }

  default TablerIcon time_duration_30() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_30);
  }

  default TablerIcon time_duration_45() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_45);
  }

  default TablerIcon time_duration_5() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_5);
  }

  default TablerIcon time_duration_60() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_60);
  }

  default TablerIcon time_duration_90() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_90);
  }

  default TablerIcon time_duration_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIME_DURATION_OFF);
  }

  default TablerIcon timeline() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIMELINE);
  }

  default TablerIcon timezone() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIMEZONE);
  }

  default TablerIcon tip_jar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIP_JAR);
  }

  default TablerIcon tip_jar_euro() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIP_JAR_EURO);
  }

  default TablerIcon tip_jar_pound() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TIP_JAR_POUND);
  }

  default TablerIcon toggle_left() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOGGLE_LEFT);
  }

  default TablerIcon toggle_right() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOGGLE_RIGHT);
  }

  default TablerIcon toilet_paper() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOILET_PAPER);
  }

  default TablerIcon toilet_paper_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOILET_PAPER_OFF);
  }

  default TablerIcon tool() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOOL);
  }

  default TablerIcon tooltip() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TOOLTIP);
  }

  default TablerIcon transfer() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFER);
  }

  default TablerIcon transfer_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFER_VERTICAL);
  }

  default TablerIcon transform() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM);
  }

  default TablerIcon transform_point() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM_POINT);
  }

  default TablerIcon transform_point_bottom_left() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM_POINT_BOTTOM_LEFT);
  }

  default TablerIcon transform_point_bottom_right() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM_POINT_BOTTOM_RIGHT);
  }

  default TablerIcon transform_point_top_left() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM_POINT_TOP_LEFT);
  }

  default TablerIcon transform_point_top_right() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRANSFORM_POINT_TOP_RIGHT);
  }

  default TablerIcon trash() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRASH);
  }

  default TablerIcon trash_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRASH_OFF);
  }

  default TablerIcon trash_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRASH_X);
  }

  default TablerIcon trowel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TROWEL);
  }

  default TablerIcon ufo_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UFO_OFF);
  }

  default TablerIcon uhd() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UHD);
  }

  default TablerIcon umbrella() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UMBRELLA);
  }

  default TablerIcon umbrella_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UMBRELLA_2);
  }

  default TablerIcon umbrella_closed() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UMBRELLA_CLOSED);
  }

  default TablerIcon umbrella_closed_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UMBRELLA_CLOSED_2);
  }

  default TablerIcon umbrella_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UMBRELLA_OFF);
  }

  default TablerIcon universe() {
    return TablerIcon.create(TablerSystem.OutlineIcon.UNIVERSE);
  }

  default TablerIcon urgent() {
    return TablerIcon.create(TablerSystem.OutlineIcon.URGENT);
  }

  default TablerIcon usb() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USB);
  }

  default TablerIcon user() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER);
  }

  default TablerIcon user_bitcoin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_BITCOIN);
  }

  default TablerIcon user_bolt() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_BOLT);
  }

  default TablerIcon user_cancel() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_CANCEL);
  }

  default TablerIcon user_check() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_CHECK);
  }

  default TablerIcon user_circle() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_CIRCLE);
  }

  default TablerIcon user_code() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_CODE);
  }

  default TablerIcon user_cog() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_COG);
  }

  default TablerIcon user_dollar() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_DOLLAR);
  }

  default TablerIcon user_down() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_DOWN);
  }

  default TablerIcon user_edit() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_EDIT);
  }

  default TablerIcon user_exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_EXCLAMATION);
  }

  default TablerIcon user_heart() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_HEART);
  }

  default TablerIcon user_hexagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_HEXAGON);
  }

  default TablerIcon user_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_MINUS);
  }

  default TablerIcon user_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_OFF);
  }

  default TablerIcon user_pause() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_PAUSE);
  }

  default TablerIcon user_pentagon() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_PENTAGON);
  }

  default TablerIcon user_pin() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_PIN);
  }

  default TablerIcon user_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_PLUS);
  }

  default TablerIcon user_question() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_QUESTION);
  }

  default TablerIcon user_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SCAN);
  }

  default TablerIcon user_search() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SEARCH);
  }

  default TablerIcon user_share() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SHARE);
  }

  default TablerIcon user_shield() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SHIELD);
  }

  default TablerIcon user_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SQUARE);
  }

  default TablerIcon user_square_rounded() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_SQUARE_ROUNDED);
  }

  default TablerIcon user_star() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_STAR);
  }

  default TablerIcon user_up() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_UP);
  }

  default TablerIcon user_x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USER_X);
  }

  default TablerIcon users() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USERS);
  }

  default TablerIcon users_group() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USERS_GROUP);
  }

  default TablerIcon users_minus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USERS_MINUS);
  }

  default TablerIcon users_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.USERS_PLUS);
  }

  default TablerIcon vacuum_cleaner() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VACUUM_CLEANER);
  }

  default TablerIcon vault() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VAULT);
  }

  default TablerIcon view_360() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEW_360);
  }

  default TablerIcon view_360_arrow() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEW_360_ARROW);
  }

  default TablerIcon view_360_number() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEW_360_NUMBER);
  }

  default TablerIcon view_360_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEW_360_OFF);
  }

  default TablerIcon viewport_short() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEWPORT_SHORT);
  }

  default TablerIcon viewport_tall() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIEWPORT_TALL);
  }

  default TablerIcon vip() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIP);
  }

  default TablerIcon vip_2() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIP_2);
  }

  default TablerIcon vip_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIP_OFF);
  }

  default TablerIcon virtual_space() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VIRTUAL_SPACE);
  }

  default TablerIcon vs() {
    return TablerIcon.create(TablerSystem.OutlineIcon.VS);
  }

  default TablerIcon wallpaper() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WALLPAPER);
  }

  default TablerIcon wallpaper_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WALLPAPER_OFF);
  }

  default TablerIcon wand() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAND);
  }

  default TablerIcon wand_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAND_OFF);
  }

  default TablerIcon wave_saw_tool() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAVE_SAW_TOOL);
  }

  default TablerIcon wave_sine() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAVE_SINE);
  }

  default TablerIcon wave_square() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAVE_SQUARE);
  }

  default TablerIcon waves_electricity() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WAVES_ELECTRICITY);
  }

  default TablerIcon weight() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WEIGHT);
  }

  default TablerIcon window_maximize() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WINDOW_MAXIMIZE);
  }

  default TablerIcon window_minimize() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WINDOW_MINIMIZE);
  }

  default TablerIcon woman() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WOMAN);
  }

  default TablerIcon wood() {
    return TablerIcon.create(TablerSystem.OutlineIcon.WOOD);
  }

  default TablerIcon x() {
    return TablerIcon.create(TablerSystem.OutlineIcon.X);
  }

  default TablerIcon x_mark() {
    return TablerIcon.create(TablerSystem.OutlineIcon.X_MARK);
  }

  default TablerIcon xd() {
    return TablerIcon.create(TablerSystem.OutlineIcon.XD);
  }

  default TablerIcon xxx() {
    return TablerIcon.create(TablerSystem.OutlineIcon.XXX);
  }

  default TablerIcon zoom_scan() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ZOOM_SCAN);
  }

  default TablerIcon zzz() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ZZZ);
  }

  default TablerIcon zzz_off() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ZZZ_OFF);
  }

  default TablerIcon arrow_collapse_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon arrow_expand_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon block() {
    return TablerIcon.create(TablerSystem.OutlineIcon.BAN);
  }

  default TablerIcon circle_medium() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon close() {
    return TablerIcon.create(TablerSystem.OutlineIcon.X);
  }

  default TablerIcon clock_outline() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK);
  }

  default TablerIcon delete() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRASH);
  }

  default TablerIcon drag_vertical() {
    return TablerIcon.create(TablerSystem.OutlineIcon.GRIP_VERTICAL);
  }

  default TablerIcon dots_horizontal() {
    return TablerIcon.create(TablerSystem.OutlineIcon.DOTS);
  }

  default TablerIcon exclamation() {
    return TablerIcon.create(TablerSystem.OutlineIcon.EXCLAMATION_MARK);
  }

  default TablerIcon format_align_center() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon format_align_left() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon format_align_right() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon redo() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon star_border() {
    return TablerIcon.create(TablerSystem.OutlineIcon.STAR);
  }

  default TablerIcon trash_can() {
    return TablerIcon.create(TablerSystem.OutlineIcon.TRASH);
  }

  default TablerIcon sort() {
    return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
  }

  default TablerIcon vector_point_plus() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CROSSHAIR);
  }

  default TablerIcon view_day() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
  }

  default TablerIcon view_day_outline() {
    return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
  }

  default TablerIcon warning() {
    return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_TRIANGLE);
  }

  default TablerIcon window_close() {
    return TablerIcon.create(TablerSystem.OutlineIcon.X);
  }

  default TablerIcon window_restore() {
    return TablerIcon.create(TablerSystem.OutlineIcon.RESTORE);
  }

  default TablerIcon ad_circle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.AD_CIRCLE);
  }

  default TablerIcon adjustments_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ADJUSTMENTS);
  }

  default TablerIcon adjustments_horizontal_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ADJUSTMENTS_HORIZONTAL);
  }

  default TablerIcon affiliate_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.AFFILIATE);
  }

  default TablerIcon alarm_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALARM);
  }

  default TablerIcon alarm_minus_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALARM_MINUS);
  }

  default TablerIcon alarm_plus_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALARM_PLUS);
  }

  default TablerIcon alarm_snooze_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALARM_SNOOZE);
  }

  default TablerIcon alert_circle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_CIRCLE);
  }

  default TablerIcon alert_hexagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_HEXAGON);
  }

  default TablerIcon alert_octagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_OCTAGON);
  }

  default TablerIcon alert_square_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_SQUARE);
  }

  default TablerIcon alert_square_rounded_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_SQUARE_ROUNDED);
  }

  default TablerIcon alert_triangle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ALERT_TRIANGLE);
  }

  default TablerIcon analyze_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ANALYZE);
  }

  default TablerIcon app_window_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.APP_WINDOW);
  }

  default TablerIcon bell_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL);
  }

  default TablerIcon bell_minus_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_MINUS);
  }

  default TablerIcon bell_plus_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_PLUS);
  }

  default TablerIcon bell_ringing_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_RINGING);
  }

  default TablerIcon bell_ringing_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_RINGING_2);
  }

  default TablerIcon bell_x_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_X);
  }

  default TablerIcon bell_z_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BELL_Z);
  }

  default TablerIcon blob_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.BLOB);
  }

  default TablerIcon calendar_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CALENDAR);
  }

  default TablerIcon calendar_event_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CALENDAR_EVENT);
  }

  default TablerIcon calendar_month_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CALENDAR_MONTH);
  }

  default TablerIcon calendar_week_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CALENDAR_WEEK);
  }

  default TablerIcon check_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CHECK);
  }

  default TablerIcon click_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLICK);
  }

  default TablerIcon clock_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK);
  }

  default TablerIcon clock_hour_1_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_1);
  }

  default TablerIcon clock_hour_10_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_10);
  }

  default TablerIcon clock_hour_11_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_11);
  }

  default TablerIcon clock_hour_12_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_12);
  }

  default TablerIcon clock_hour_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_2);
  }

  default TablerIcon clock_hour_3_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_3);
  }

  default TablerIcon clock_hour_4_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_4);
  }

  default TablerIcon clock_hour_5_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_5);
  }

  default TablerIcon clock_hour_6_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_6);
  }

  default TablerIcon clock_hour_7_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_7);
  }

  default TablerIcon clock_hour_8_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_8);
  }

  default TablerIcon clock_hour_9_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.CLOCK_HOUR_9);
  }

  default TablerIcon dashboard_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DASHBOARD);
  }

  default TablerIcon device_unknown_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DEVICE_UNKNOWN);
  }

  default TablerIcon direction_arrows_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DIRECTION_ARROWS);
  }

  default TablerIcon direction_sign_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DIRECTION_SIGN);
  }

  default TablerIcon dots_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DOTS);
  }

  default TablerIcon dots_vertical_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.DOTS_VERTICAL);
  }

  default TablerIcon elevator_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ELEVATOR);
  }

  default TablerIcon exchange_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.EXCHANGE);
  }

  default TablerIcon exclamation_circle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.EXCLAMATION_CIRCLE);
  }

  default TablerIcon explicit_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.EXPLICIT);
  }

  default TablerIcon external_link_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.EXTERNAL_LINK);
  }

  default TablerIcon eye_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.EYE);
  }

  default TablerIcon fidget_spinner_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.FIDGET_SPINNER);
  }

  default TablerIcon filter_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.FILTER);
  }

  default TablerIcon filters_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.FILTERS);
  }

  default TablerIcon forbid_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.FORBID);
  }

  default TablerIcon forbid_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.FORBID_2);
  }

  default TablerIcon gauge_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.GAUGE);
  }

  default TablerIcon graph_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.GRAPH);
  }

  default TablerIcon grid_pattern_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.GRID_PATTERN);
  }

  default TablerIcon hanger_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HANGER_2);
  }

  default TablerIcon help_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP);
  }

  default TablerIcon help_circle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_CIRCLE);
  }

  default TablerIcon help_hexagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_HEXAGON);
  }

  default TablerIcon help_octagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_OCTAGON);
  }

  default TablerIcon help_square_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_SQUARE);
  }

  default TablerIcon help_square_rounded_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_SQUARE_ROUNDED);
  }

  default TablerIcon help_triangle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HELP_TRIANGLE);
  }

  default TablerIcon hourglass_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.HOURGLASS);
  }

  default TablerIcon id_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ID);
  }

  default TablerIcon info_circle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_CIRCLE);
  }

  default TablerIcon info_hexagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_HEXAGON);
  }

  default TablerIcon info_octagon_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_OCTAGON);
  }

  default TablerIcon info_square_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_SQUARE);
  }

  default TablerIcon info_square_rounded_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_SQUARE_ROUNDED);
  }

  default TablerIcon info_triangle_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.INFO_TRIANGLE);
  }

  default TablerIcon jetpack_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.JETPACK);
  }

  default TablerIcon label_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LABEL);
  }

  default TablerIcon label_important_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LABEL_IMPORTANT);
  }

  default TablerIcon lego_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LEGO);
  }

  default TablerIcon library_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LIBRARY);
  }

  default TablerIcon library_plus_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LIBRARY_PLUS);
  }

  default TablerIcon lifebuoy_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LIFEBUOY);
  }

  default TablerIcon lock_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LOCK);
  }

  default TablerIcon lock_square_rounded_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.LOCK_SQUARE_ROUNDED);
  }

  default TablerIcon man_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.MAN);
  }

  default TablerIcon menu_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.MENU_2);
  }

  default TablerIcon military_rank_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.MILITARY_RANK);
  }

  default TablerIcon point_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.POINT);
  }

  default TablerIcon pointer_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.POINTER);
  }

  default TablerIcon poo_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.POO);
  }

  default TablerIcon replace_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.REPLACE);
  }

  default TablerIcon scale_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SCALE);
  }

  default TablerIcon search_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SEARCH);
  }

  default TablerIcon settings_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SETTINGS);
  }

  default TablerIcon shield_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SHIELD);
  }

  default TablerIcon shield_check_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SHIELD_CHECK);
  }

  default TablerIcon shield_checkered_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SHIELD_CHECKERED);
  }

  default TablerIcon shield_half_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SHIELD_HALF);
  }

  default TablerIcon shield_lock_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SHIELD_LOCK);
  }

  default TablerIcon sort_ascending_shapes_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SORT_ASCENDING_SHAPES);
  }

  default TablerIcon sort_descending_shapes_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SORT_DESCENDING_SHAPES);
  }

  default TablerIcon sparkles_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SPARKLES);
  }

  default TablerIcon square_f0_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F0);
  }

  default TablerIcon square_f1_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F1);
  }

  default TablerIcon square_f2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F2);
  }

  default TablerIcon square_f3_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F3);
  }

  default TablerIcon square_f4_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F4);
  }

  default TablerIcon square_f5_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F5);
  }

  default TablerIcon square_f6_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F6);
  }

  default TablerIcon square_f7_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F7);
  }

  default TablerIcon square_f8_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F8);
  }

  default TablerIcon square_f9_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.SQUARE_F9);
  }

  default TablerIcon star_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.STAR);
  }

  default TablerIcon star_half_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.STAR_HALF);
  }

  default TablerIcon stars_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.STARS);
  }

  default TablerIcon test_pipe_2_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TEST_PIPE_2);
  }

  default TablerIcon thumb_down_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.THUMB_DOWN);
  }

  default TablerIcon thumb_up_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.THUMB_UP);
  }

  default TablerIcon toggle_left_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TOGGLE_LEFT);
  }

  default TablerIcon toggle_right_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TOGGLE_RIGHT);
  }

  default TablerIcon transform_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TRANSFORM);
  }

  default TablerIcon trash_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TRASH);
  }

  default TablerIcon trash_x_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.TRASH_X);
  }

  default TablerIcon umbrella_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.UMBRELLA);
  }

  default TablerIcon user_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.USER);
  }

  default TablerIcon woman_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.WOMAN);
  }

  default TablerIcon x_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.X);
  }

  default TablerIcon zoom_scan_filled() {
    return TablerIcon.create(TablerSystem.FilledIcon.ZOOM_SCAN);
  }
}
