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

/** Lucide arrows catalog category. */
public interface LucideArrows {
  enum Icon implements LucideIconDefinition {
    ARROW_BIG_DOWN(
        "arrow-big-down",
        "<path d=\"M9 5a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v6a1 1 0 0 0 1 1h3.293a.707.707 0 0 1 .5 1.207l-7.086 7.086a1 1 0 0 1-1.414 0l-7.086-7.086a.707.707 0 0 1 .5-1.207H8a1 1 0 0 0 1-1z\" />"),
    ARROW_BIG_DOWN_DASH(
        "arrow-big-down-dash",
        "<path d=\"M14 8a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1h3.293a.707.707 0 0 1 .5 1.207l-6.939 6.939a1.207 1.207 0 0 1-1.708 0l-6.94-6.94a.707.707 0 0 1 .5-1.206H8a1 1 0 0 0 1-1V9a1 1 0 0 1 1-1z\" />\n  <path d=\"M9 4h6\" />"),
    ARROW_BIG_LEFT(
        "arrow-big-left",
        "<path d=\"M10.793 19.793a.707.707 0 0 0 1.207-.5V16a1 1 0 0 1 1-1h6a1 1 0 0 0 1-1v-4a1 1 0 0 0-1-1h-6a1 1 0 0 1-1-1V4.707a.707.707 0 0 0-1.207-.5l-6.94 6.94a1.207 1.207 0 0 0 0 1.707z\" />"),
    ARROW_BIG_LEFT_DASH(
        "arrow-big-left-dash",
        "<path d=\"M13 9a1 1 0 0 1-1-1V4.707a.707.707 0 0 0-1.207-.5l-6.94 6.94a1.207 1.207 0 0 0 0 1.707l6.94 6.94a.707.707 0 0 0 1.207-.5V16a1 1 0 0 1 1-1h2a1 1 0 0 0 1-1v-4a1 1 0 0 0-1-1z\" />\n  <path d=\"M20 9v6\" />"),
    ARROW_BIG_RIGHT(
        "arrow-big-right",
        "<path d=\"M13.207 19.793a.707.707 0 0 1-1.207-.5V16a1 1 0 0 0-1-1H5a1 1 0 0 1-1-1v-4a1 1 0 0 1 1-1h6a1 1 0 0 0 1-1V4.707a.707.707 0 0 1 1.207-.5l6.94 6.94a1.207 1.207 0 0 1 0 1.707z\" />"),
    ARROW_BIG_RIGHT_DASH(
        "arrow-big-right-dash",
        "<path d=\"M11 9a1 1 0 0 0 1-1V4.707a.707.707 0 0 1 1.207-.5l6.94 6.94a1.207 1.207 0 0 1 0 1.707l-6.94 6.94a.707.707 0 0 1-1.207-.5V16a1 1 0 0 0-1-1H9a1 1 0 0 1-1-1v-4a1 1 0 0 1 1-1z\" />\n  <path d=\"M4 9v6\" />"),
    ARROW_BIG_UP(
        "arrow-big-up",
        "<path d=\"M9 19a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1v-6a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-7.086-7.086a1 1 0 0 0-1.414 0l-7.086 7.086a.707.707 0 0 0 .5 1.207H8a1 1 0 0 1 1 1z\" />"),
    ARROW_BIG_UP_DASH(
        "arrow-big-up-dash",
        "<path d=\"M14 16a1 1 0 0 0 1-1v-2a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-6.939-6.939a1.207 1.207 0 0 0-1.708 0l-6.94 6.94a.707.707 0 0 0 .5 1.206H8a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1z\" />\n  <path d=\"M9 20h6\" />"),
    ARROW_DOWN("arrow-down", "<path d=\"M12 5v14\" />\n  <path d=\"m19 12-7 7-7-7\" />"),
    ARROW_DOWN_0_1(
        "arrow-down-0-1",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <rect x=\"15\" y=\"4\" width=\"4\" height=\"6\" ry=\"2\" />\n  <path d=\"M17 20v-6h-2\" />\n  <path d=\"M15 20h4\" />"),
    ARROW_DOWN_1_0(
        "arrow-down-1-0",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M17 10V4h-2\" />\n  <path d=\"M15 10h4\" />\n  <rect x=\"15\" y=\"14\" width=\"4\" height=\"6\" ry=\"2\" />"),
    ARROW_DOWN_A_Z(
        "arrow-down-a-z",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M20 8h-5\" />\n  <path d=\"M15 10V6.5a2.5 2.5 0 0 1 5 0V10\" />\n  <path d=\"M15 14h5l-5 6h5\" />"),
    ARROW_DOWN_FROM_LINE(
        "arrow-down-from-line",
        "<path d=\"M19 3H5\" />\n  <path d=\"M12 21V7\" />\n  <path d=\"m6 15 6 6 6-6\" />"),
    ARROW_DOWN_LEFT("arrow-down-left", "<path d=\"M17 7 7 17\" />\n  <path d=\"M17 17H7V7\" />"),
    ARROW_DOWN_NARROW_WIDE(
        "arrow-down-narrow-wide",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M11 4h4\" />\n  <path d=\"M11 8h7\" />\n  <path d=\"M11 12h10\" />"),
    ARROW_DOWN_RIGHT("arrow-down-right", "<path d=\"m7 7 10 10\" />\n  <path d=\"M17 7v10H7\" />"),
    ARROW_DOWN_TO_DOT(
        "arrow-down-to-dot",
        "<path d=\"M12 2v14\" />\n  <path d=\"m19 9-7 7-7-7\" />\n  <circle cx=\"12\" cy=\"21\" r=\"1\" />"),
    ARROW_DOWN_TO_LINE(
        "arrow-down-to-line",
        "<path d=\"M12 17V3\" />\n  <path d=\"m6 11 6 6 6-6\" />\n  <path d=\"M19 21H5\" />"),
    ARROW_DOWN_UP(
        "arrow-down-up",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"m21 8-4-4-4 4\" />\n  <path d=\"M17 4v16\" />"),
    ARROW_DOWN_WIDE_NARROW(
        "arrow-down-wide-narrow",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 20V4\" />\n  <path d=\"M11 4h10\" />\n  <path d=\"M11 8h7\" />\n  <path d=\"M11 12h4\" />"),
    ARROW_DOWN_Z_A(
        "arrow-down-z-a",
        "<path d=\"m3 16 4 4 4-4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M15 4h5l-5 6h5\" />\n  <path d=\"M15 20v-3.5a2.5 2.5 0 0 1 5 0V20\" />\n  <path d=\"M20 18h-5\" />"),
    ARROW_LEFT("arrow-left", "<path d=\"m12 19-7-7 7-7\" />\n  <path d=\"M19 12H5\" />"),
    ARROW_LEFT_FROM_LINE(
        "arrow-left-from-line",
        "<path d=\"m9 6-6 6 6 6\" />\n  <path d=\"M3 12h14\" />\n  <path d=\"M21 19V5\" />"),
    ARROW_LEFT_RIGHT(
        "arrow-left-right",
        "<path d=\"M8 3 4 7l4 4\" />\n  <path d=\"M4 7h16\" />\n  <path d=\"m16 21 4-4-4-4\" />\n  <path d=\"M20 17H4\" />"),
    ARROW_LEFT_TO_LINE(
        "arrow-left-to-line",
        "<path d=\"M3 19V5\" />\n  <path d=\"m13 6-6 6 6 6\" />\n  <path d=\"M7 12h14\" />"),
    ARROW_RIGHT("arrow-right", "<path d=\"M5 12h14\" />\n  <path d=\"m12 5 7 7-7 7\" />"),
    ARROW_RIGHT_FROM_LINE(
        "arrow-right-from-line",
        "<path d=\"M3 5v14\" />\n  <path d=\"M21 12H7\" />\n  <path d=\"m15 18 6-6-6-6\" />"),
    ARROW_RIGHT_LEFT(
        "arrow-right-left",
        "<path d=\"m16 3 4 4-4 4\" />\n  <path d=\"M20 7H4\" />\n  <path d=\"m8 21-4-4 4-4\" />\n  <path d=\"M4 17h16\" />"),
    ARROW_RIGHT_TO_LINE(
        "arrow-right-to-line",
        "<path d=\"M17 12H3\" />\n  <path d=\"m11 18 6-6-6-6\" />\n  <path d=\"M21 5v14\" />"),
    ARROW_UP("arrow-up", "<path d=\"m5 12 7-7 7 7\" />\n  <path d=\"M12 19V5\" />"),
    ARROW_UP_0_1(
        "arrow-up-0-1",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <rect x=\"15\" y=\"4\" width=\"4\" height=\"6\" ry=\"2\" />\n  <path d=\"M17 20v-6h-2\" />\n  <path d=\"M15 20h4\" />"),
    ARROW_UP_1_0(
        "arrow-up-1-0",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M17 10V4h-2\" />\n  <path d=\"M15 10h4\" />\n  <rect x=\"15\" y=\"14\" width=\"4\" height=\"6\" ry=\"2\" />"),
    ARROW_UP_A_Z(
        "arrow-up-a-z",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M20 8h-5\" />\n  <path d=\"M15 10V6.5a2.5 2.5 0 0 1 5 0V10\" />\n  <path d=\"M15 14h5l-5 6h5\" />"),
    ARROW_UP_DOWN(
        "arrow-up-down",
        "<path d=\"m21 16-4 4-4-4\" />\n  <path d=\"M17 20V4\" />\n  <path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />"),
    ARROW_UP_FROM_DOT(
        "arrow-up-from-dot",
        "<path d=\"m5 9 7-7 7 7\" />\n  <path d=\"M12 16V2\" />\n  <circle cx=\"12\" cy=\"21\" r=\"1\" />"),
    ARROW_UP_FROM_LINE(
        "arrow-up-from-line",
        "<path d=\"m18 9-6-6-6 6\" />\n  <path d=\"M12 3v14\" />\n  <path d=\"M5 21h14\" />"),
    ARROW_UP_LEFT("arrow-up-left", "<path d=\"M7 17V7h10\" />\n  <path d=\"M17 17 7 7\" />"),
    ARROW_UP_NARROW_WIDE(
        "arrow-up-narrow-wide",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M11 12h4\" />\n  <path d=\"M11 16h7\" />\n  <path d=\"M11 20h10\" />"),
    ARROW_UP_RIGHT("arrow-up-right", "<path d=\"M7 7h10v10\" />\n  <path d=\"M7 17 17 7\" />"),
    ARROW_UP_TO_LINE(
        "arrow-up-to-line",
        "<path d=\"M5 3h14\" />\n  <path d=\"m18 13-6-6-6 6\" />\n  <path d=\"M12 7v14\" />"),
    ARROW_UP_WIDE_NARROW(
        "arrow-up-wide-narrow",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M11 12h10\" />\n  <path d=\"M11 16h7\" />\n  <path d=\"M11 20h4\" />"),
    ARROW_UP_Z_A(
        "arrow-up-z-a",
        "<path d=\"m3 8 4-4 4 4\" />\n  <path d=\"M7 4v16\" />\n  <path d=\"M15 4h5l-5 6h5\" />\n  <path d=\"M15 20v-3.5a2.5 2.5 0 0 1 5 0V20\" />\n  <path d=\"M20 18h-5\" />"),
    ARROWS_UP_FROM_LINE(
        "arrows-up-from-line",
        "<path d=\"m4 6 3-3 3 3\" />\n  <path d=\"M7 17V3\" />\n  <path d=\"m14 6 3-3 3 3\" />\n  <path d=\"M17 17V3\" />\n  <path d=\"M4 21h16\" />"),
    CALENDAR_CHEVRONS_LEFT(
        "calendar-chevrons-left",
        "<path d=\"m11 21-3-3 3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M3 11.5V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2h-4\" />\n  <path d=\"m5 21-3-3 3-3\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CHEVRONS_RIGHT(
        "calendar-chevrons-right",
        "<path d=\"m13 21 3-3-3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m19 21 3-3-3-3\" />\n  <path d=\"M21 11.5V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h4\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_SYNC(
        "calendar-sync",
        "<path d=\"M11 10v4h4\" />\n  <path d=\"m11 14 1.535-1.605a5 5 0 018 1.5\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m21 18-1.535 1.605a5 5 0 01-8-1.5\" />\n  <path d=\"M21 22v-4h-4\" />\n  <path d=\"M21 8.517V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h3.517\" />\n  <path d=\"M3 9h4\" />\n  <path d=\"M8 2v3\" />"),
    CHEVRON_DOWN("chevron-down", "<path d=\"m6 9 6 6 6-6\" />"),
    CHEVRON_FIRST("chevron-first", "<path d=\"m17 18-6-6 6-6\" />\n  <path d=\"M7 6v12\" />"),
    CHEVRON_LAST("chevron-last", "<path d=\"m7 18 6-6-6-6\" />\n  <path d=\"M17 6v12\" />"),
    CHEVRON_LEFT("chevron-left", "<path d=\"m15 18-6-6 6-6\" />"),
    CHEVRON_RIGHT("chevron-right", "<path d=\"m9 18 6-6-6-6\" />"),
    CHEVRON_UP("chevron-up", "<path d=\"m18 15-6-6-6 6\" />"),
    CHEVRONS_DOWN("chevrons-down", "<path d=\"m7 6 5 5 5-5\" />\n  <path d=\"m7 13 5 5 5-5\" />"),
    CHEVRONS_DOWN_UP(
        "chevrons-down-up", "<path d=\"m7 20 5-5 5 5\" />\n  <path d=\"m7 4 5 5 5-5\" />"),
    CHEVRONS_LEFT(
        "chevrons-left", "<path d=\"m11 17-5-5 5-5\" />\n  <path d=\"m18 17-5-5 5-5\" />"),
    CHEVRONS_LEFT_RIGHT(
        "chevrons-left-right", "<path d=\"m9 7-5 5 5 5\" />\n  <path d=\"m15 7 5 5-5 5\" />"),
    CHEVRONS_RIGHT(
        "chevrons-right", "<path d=\"m6 17 5-5-5-5\" />\n  <path d=\"m13 17 5-5-5-5\" />"),
    CHEVRONS_RIGHT_LEFT(
        "chevrons-right-left", "<path d=\"m20 17-5-5 5-5\" />\n  <path d=\"m4 17 5-5-5-5\" />"),
    CHEVRONS_UP("chevrons-up", "<path d=\"m17 11-5-5-5 5\" />\n  <path d=\"m17 18-5-5-5 5\" />"),
    CHEVRONS_UP_DOWN(
        "chevrons-up-down", "<path d=\"m7 15 5 5 5-5\" />\n  <path d=\"m7 9 5-5 5 5\" />"),
    CIRCLE_ARROW_DOWN(
        "circle-arrow-down",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8 12 4 4 4-4\" />"),
    CIRCLE_ARROW_LEFT(
        "circle-arrow-left",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m12 8-4 4 4 4\" />\n  <path d=\"M16 12H8\" />"),
    CIRCLE_ARROW_OUT_DOWN_LEFT(
        "circle-arrow-out-down-left",
        "<path d=\"M2 12a10 10 0 1 1 10 10\" />\n  <path d=\"m2 22 10-10\" />\n  <path d=\"M8 22H2v-6\" />"),
    CIRCLE_ARROW_OUT_DOWN_RIGHT(
        "circle-arrow-out-down-right",
        "<path d=\"M12 22a10 10 0 1 1 10-10\" />\n  <path d=\"M22 22 12 12\" />\n  <path d=\"M22 16v6h-6\" />"),
    CIRCLE_ARROW_OUT_UP_LEFT(
        "circle-arrow-out-up-left",
        "<path d=\"M2 8V2h6\" />\n  <path d=\"m2 2 10 10\" />\n  <path d=\"M12 2A10 10 0 1 1 2 12\" />"),
    CIRCLE_ARROW_OUT_UP_RIGHT(
        "circle-arrow-out-up-right",
        "<path d=\"M22 12A10 10 0 1 1 12 2\" />\n  <path d=\"M22 2 12 12\" />\n  <path d=\"M16 2h6v6\" />"),
    CIRCLE_ARROW_RIGHT(
        "circle-arrow-right",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m12 16 4-4-4-4\" />\n  <path d=\"M8 12h8\" />"),
    CIRCLE_ARROW_UP(
        "circle-arrow-up",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m16 12-4-4-4 4\" />\n  <path d=\"M12 16V8\" />"),
    CIRCLE_CHEVRON_DOWN(
        "circle-chevron-down",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m16 10-4 4-4-4\" />"),
    CIRCLE_CHEVRON_LEFT(
        "circle-chevron-left",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m14 16-4-4 4-4\" />"),
    CIRCLE_CHEVRON_RIGHT(
        "circle-chevron-right",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m10 8 4 4-4 4\" />"),
    CIRCLE_CHEVRON_UP(
        "circle-chevron-up",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m8 14 4-4 4 4\" />"),
    CIRCLE_CHEVRONS_DOWN(
        "circle-chevrons-down",
        "<path d=\"M9 14L12 17L15 14\" />\n  <path d=\"M9 8L12 11L15 8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_LEFT(
        "circle-chevrons-left",
        "<path d=\"M10 9L7 12L10 15\" />\n  <path d=\"M16 9L13 12L16 15\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_RIGHT(
        "circle-chevrons-right",
        "<path d=\"M14 15L17 12L14 9\" />\n  <path d=\"M8 15L11 12L8 9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_UP(
        "circle-chevrons-up",
        "<path d=\"M15 10L12 7L9 10\" />\n  <path d=\"M15 16L12 13L9 16\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_FADING_ARROW_UP(
        "circle-fading-arrow-up",
        "<path d=\"M12 2a10 10 0 0 1 7.38 16.75\" />\n  <path d=\"m16 12-4-4-4 4\" />\n  <path d=\"M12 16V8\" />\n  <path d=\"M2.5 8.875a10 10 0 0 0-.5 3\" />\n  <path d=\"M2.83 16a10 10 0 0 0 2.43 3.4\" />\n  <path d=\"M4.636 5.235a10 10 0 0 1 .891-.857\" />\n  <path d=\"M8.644 21.42a10 10 0 0 0 7.631-.38\" />"),
    CLIPBOARD_COPY(
        "clipboard-copy",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v4\" />\n  <path d=\"M21 14H11\" />\n  <path d=\"m15 10-4 4 4 4\" />"),
    CLIPBOARD_PASTE(
        "clipboard-paste",
        "<path d=\"M11 14h10\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v1.344\" />\n  <path d=\"m17 18 4-4-4-4\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h12a2 2 0 0 0 1.793-1.113\" />\n  <rect x=\"8\" y=\"2\" width=\"8\" height=\"4\" rx=\"1\" />"),
    CLOCK_ARROW_RIGHT(
        "clock-arrow-right",
        "<path d=\"M12 6v6l2 1\" />\n  <path d=\"M13.5 21.885A10 10 0 1 1 22 12\" />\n  <path d=\"M14 18h8\" />\n  <path d=\"m18 22 4-4-4-4\" />"),
    CLOUD_BACKUP(
        "cloud-backup",
        "<path d=\"M21 15.251A4.5 4.5 0 0 0 17.5 8h-1.79A7 7 0 1 0 3 13.607\" />\n  <path d=\"M7 11v4h4\" />\n  <path d=\"M8 19a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5 4.82 4.82 0 0 0-3.41 1.41L7 15\" />"),
    CLOUD_DOWNLOAD(
        "cloud-download",
        "<path d=\"M12 13v8l-4-4\" />\n  <path d=\"m12 21 4-4\" />\n  <path d=\"M4.393 15.269A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.436 8.284\" />"),
    CLOUD_SYNC(
        "cloud-sync",
        "<path d=\"m17 18-1.535 1.605a5 5 0 0 1-8-1.5\" />\n  <path d=\"M17 22v-4h-4\" />\n  <path d=\"M20.996 15.251A4.5 4.5 0 0 0 17.495 8h-1.79a7 7 0 1 0-12.709 5.607\" />\n  <path d=\"M7 10v4h4\" />\n  <path d=\"m7 14 1.535-1.605a5 5 0 0 1 8 1.5\" />"),
    CLOUD_UPLOAD(
        "cloud-upload",
        "<path d=\"M12 13v8\" />\n  <path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"m8 17 4-4 4 4\" />"),
    CORNER_DOWN_LEFT(
        "corner-down-left",
        "<path d=\"M20 4v7a4 4 0 0 1-4 4H4\" />\n  <path d=\"m9 10-5 5 5 5\" />"),
    CORNER_DOWN_RIGHT(
        "corner-down-right",
        "<path d=\"m15 10 5 5-5 5\" />\n  <path d=\"M4 4v7a4 4 0 0 0 4 4h12\" />"),
    CORNER_LEFT_DOWN(
        "corner-left-down",
        "<path d=\"m14 15-5 5-5-5\" />\n  <path d=\"M20 4h-7a4 4 0 0 0-4 4v12\" />"),
    CORNER_LEFT_UP(
        "corner-left-up",
        "<path d=\"M14 9 9 4 4 9\" />\n  <path d=\"M20 20h-7a4 4 0 0 1-4-4V4\" />"),
    CORNER_RIGHT_DOWN(
        "corner-right-down",
        "<path d=\"m10 15 5 5 5-5\" />\n  <path d=\"M4 4h7a4 4 0 0 1 4 4v12\" />"),
    CORNER_RIGHT_UP(
        "corner-right-up",
        "<path d=\"m10 9 5-5 5 5\" />\n  <path d=\"M4 20h7a4 4 0 0 0 4-4V4\" />"),
    CORNER_UP_LEFT(
        "corner-up-left",
        "<path d=\"M20 20v-7a4 4 0 0 0-4-4H4\" />\n  <path d=\"M9 14 4 9l5-5\" />"),
    CORNER_UP_RIGHT(
        "corner-up-right",
        "<path d=\"m15 14 5-5-5-5\" />\n  <path d=\"M4 20v-7a4 4 0 0 1 4-4h12\" />"),
    DATABASE_BACKUP(
        "database-backup",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 12a9 3 0 0 0 5 2.69\" />\n  <path d=\"M21 9.3V5\" />\n  <path d=\"M3 5v14a9 3 0 0 0 6.47 2.88\" />\n  <path d=\"M12 12v4h4\" />\n  <path d=\"M13 20a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L12 16\" />"),
    DECIMALS_ARROW_LEFT(
        "decimals-arrow-left",
        "<path d=\"m13 21-3-3 3-3\" />\n  <path d=\"M20 18H10\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DECIMALS_ARROW_RIGHT(
        "decimals-arrow-right",
        "<path d=\"M10 18h10\" />\n  <path d=\"m17 21 3-3-3-3\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"15\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DELETE(
        "delete",
        "<path d=\"M10 5a2 2 0 0 0-1.344.519l-6.328 5.74a1 1 0 0 0 0 1.481l6.328 5.741A2 2 0 0 0 10 19h10a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2z\" />\n  <path d=\"m12 9 6 6\" />\n  <path d=\"m18 9-6 6\" />"),
    DOWNLOAD(
        "download",
        "<path d=\"M12 15V3\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4\" />\n  <path d=\"m7 10 5 5 5-5\" />"),
    EXPAND(
        "expand",
        "<path d=\"m15 15 6 6\" />\n  <path d=\"m15 9 6-6\" />\n  <path d=\"M21 16v5h-5\" />\n  <path d=\"M21 8V3h-5\" />\n  <path d=\"M3 16v5h5\" />\n  <path d=\"m3 21 6-6\" />\n  <path d=\"M3 8V3h5\" />\n  <path d=\"M9 9 3 3\" />"),
    EXTERNAL_LINK(
        "external-link",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"M10 14 21 3\" />\n  <path d=\"M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6\" />"),
    FAST_FORWARD(
        "fast-forward",
        "<path d=\"M12 6a2 2 0 0 1 3.414-1.414l6 6a2 2 0 0 1 0 2.828l-6 6A2 2 0 0 1 12 18z\" />\n  <path d=\"M2 6a2 2 0 0 1 3.414-1.414l6 6a2 2 0 0 1 0 2.828l-6 6A2 2 0 0 1 2 18z\" />"),
    FILE_DOWN(
        "file-down",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 18v-6\" />\n  <path d=\"m9 15 3 3 3-3\" />"),
    FILE_INPUT(
        "file-input",
        "<path d=\"M4 11V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-1\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M2 15h10\" />\n  <path d=\"m9 18 3-3-3-3\" />"),
    FILE_OUTPUT(
        "file-output",
        "<path d=\"M4.226 20.925A2 2 0 0 0 6 22h12a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v3.127\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m5 11-3 3\" />\n  <path d=\"m5 17-3-3h10\" />"),
    FILE_UP(
        "file-up",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 12v6\" />\n  <path d=\"m15 15-3-3-3 3\" />"),
    FOLD_HORIZONTAL(
        "fold-horizontal",
        "<path d=\"M2 12h6\" />\n  <path d=\"M22 12h-6\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m19 9-3 3 3 3\" />\n  <path d=\"m5 15 3-3-3-3\" />"),
    FOLD_VERTICAL(
        "fold-vertical",
        "<path d=\"M12 22v-6\" />\n  <path d=\"M12 8V2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"m15 19-3-3-3 3\" />\n  <path d=\"m15 5-3 3-3-3\" />"),
    FOLDER_DOWN(
        "folder-down",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"m15 13-3 3-3-3\" />"),
    FOLDER_INPUT(
        "folder-input",
        "<path d=\"M2 9V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-1\" />\n  <path d=\"M2 13h10\" />\n  <path d=\"m9 16 3-3-3-3\" />"),
    FOLDER_OUTPUT(
        "folder-output",
        "<path d=\"M2 7.5V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-1.5\" />\n  <path d=\"M2 13h10\" />\n  <path d=\"m5 10-3 3 3 3\" />"),
    FOLDER_SYNC(
        "folder-sync",
        "<path d=\"M9 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M12 10v4h4\" />\n  <path d=\"m12 14 1.535-1.605a5 5 0 0 1 8 1.5\" />\n  <path d=\"M22 22v-4h-4\" />\n  <path d=\"m22 18-1.535 1.605a5 5 0 0 1-8-1.5\" />"),
    FOLDER_UP(
        "folder-up",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"m9 13 3-3 3 3\" />"),
    GIT_COMPARE_ARROWS(
        "git-compare-arrows",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v7\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <circle cx=\"19\" cy=\"18\" r=\"3\" />\n  <path d=\"M12 18H7a2 2 0 0 1-2-2V9\" />\n  <path d=\"m9 15 3 3-3 3\" />"),
    GIT_PULL_REQUEST_ARROW(
        "git-pull-request-arrow",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M5 9v12\" />\n  <circle cx=\"19\" cy=\"18\" r=\"3\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v7\" />"),
    GIT_PULL_REQUEST_CREATE_ARROW(
        "git-pull-request-create-arrow",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M5 9v12\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v3\" />\n  <path d=\"M19 15v6\" />\n  <path d=\"M22 18h-6\" />"),
    HARD_DRIVE_DOWNLOAD(
        "hard-drive-download",
        "<path d=\"M12 2v8\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HARD_DRIVE_UPLOAD(
        "hard-drive-upload",
        "<path d=\"m16 6-4-4-4 4\" />\n  <path d=\"M12 2v8\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    IMPORT(
        "import",
        "<path d=\"M12 3v12\" />\n  <path d=\"m8 11 4 4 4-4\" />\n  <path d=\"M8 5H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-4\" />"),
    ITERATION_CCW(
        "iteration-ccw", "<path d=\"m16 14 4 4-4 4\" />\n  <path d=\"M20 10a8 8 0 1 0-8 8h8\" />"),
    ITERATION_CW(
        "iteration-cw", "<path d=\"M4 10a8 8 0 1 1 8 8H4\" />\n  <path d=\"m8 22-4-4 4-4\" />"),
    LASSO_SELECT(
        "lasso-select",
        "<path d=\"M7 22a5 5 0 0 1-2-4\" />\n  <path d=\"M7 16.93c.96.43 1.96.74 2.99.91\" />\n  <path d=\"M3.34 14A6.8 6.8 0 0 1 2 10c0-4.42 4.48-8 10-8s10 3.58 10 8a7.19 7.19 0 0 1-.33 2\" />\n  <path d=\"M5 18a2 2 0 1 0 0-4 2 2 0 0 0 0 4z\" />\n  <path d=\"M14.33 22h-.09a.35.35 0 0 1-.24-.32v-10a.34.34 0 0 1 .33-.34c.08 0 .15.03.21.08l7.34 6a.33.33 0 0 1-.21.59h-4.49l-2.57 3.85a.35.35 0 0 1-.28.14z\" />"),
    LAYERS_ARROW_UP(
        "layers-arrow-up",
        "<path d=\"M12 12V2\" />\n  <path d=\"M2 17.002a1 1 0 00.58.91l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92\" />\n  <path d=\"M7.674 8.774 2.58 11.09a1 1 0 000 1.822l8.6 3.91a2 2 0 001.65 0l8.58-3.9a1 1 0 00.59-.92 1 1 0 00-.59-.922l-5.078-2.308\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    LIST_CHEVRONS_DOWN_UP(
        "list-chevrons-down-up",
        "<path d=\"M3 5h8\" />\n  <path d=\"M3 12h8\" />\n  <path d=\"M3 19h8\" />\n  <path d=\"m15 5 3 3 3-3\" />\n  <path d=\"m15 19 3-3 3 3\" />"),
    LIST_CHEVRONS_UP_DOWN(
        "list-chevrons-up-down",
        "<path d=\"M3 5h8\" />\n  <path d=\"M3 12h8\" />\n  <path d=\"M3 19h8\" />\n  <path d=\"m15 8 3-3 3 3\" />\n  <path d=\"m15 16 3 3 3-3\" />"),
    LOG_IN(
        "log-in",
        "<path d=\"m10 17 5-5-5-5\" />\n  <path d=\"M15 12H3\" />\n  <path d=\"M15 3h4a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2h-4\" />"),
    LOG_OUT(
        "log-out",
        "<path d=\"m16 17 5-5-5-5\" />\n  <path d=\"M21 12H9\" />\n  <path d=\"M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4\" />"),
    MAXIMIZE_2(
        "maximize-2",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"m21 3-7 7\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M9 21H3v-6\" />"),
    MERGE(
        "merge",
        "<path d=\"m8 6 4-4 4 4\" />\n  <path d=\"M12 2v10.3a4 4 0 0 1-1.172 2.872L4 22\" />\n  <path d=\"m20 22-5-5\" />"),
    MILESTONE(
        "milestone",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M18.172 6a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H4a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1z\" />"),
    MINIMIZE_2(
        "minimize-2",
        "<path d=\"m14 10 7-7\" />\n  <path d=\"M20 10h-6V4\" />\n  <path d=\"m3 21 7-7\" />\n  <path d=\"M4 14h6v6\" />"),
    MOUSE_POINTER(
        "mouse-pointer",
        "<path d=\"M12.586 12.586 19 19\" />\n  <path d=\"M3.688 3.037a.497.497 0 0 0-.651.651l6.5 15.999a.501.501 0 0 0 .947-.062l1.569-6.083a2 2 0 0 1 1.448-1.479l6.124-1.579a.5.5 0 0 0 .063-.947z\" />"),
    MOUSE_POINTER_2(
        "mouse-pointer-2",
        "<path d=\"M4.037 4.688a.495.495 0 0 1 .651-.651l16 6.5a.5.5 0 0 1-.063.947l-6.124 1.58a2 2 0 0 0-1.438 1.435l-1.579 6.126a.5.5 0 0 1-.947.063z\" />"),
    MOUSE_POINTER_2_OFF(
        "mouse-pointer-2-off",
        "<path d=\"m15.55 8.45 5.138 2.087a.5.5 0 0 1-.063.947l-6.124 1.58a2 2 0 0 0-1.438 1.435l-1.579 6.126a.5.5 0 0 1-.947.063L8.45 15.551\" />\n  <path d=\"M22 2 2 22\" />\n  <path d=\"m6.816 11.528-2.779-6.84a.495.495 0 0 1 .651-.651l6.84 2.779\" />"),
    MOUSE_POINTER_BAN(
        "mouse-pointer-ban",
        "<path d=\"M2.034 2.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.944L8.204 7.545a1 1 0 0 0-.66.66l-1.066 3.443a.5.5 0 0 1-.944.033z\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />\n  <path d=\"m11.8 11.8 8.4 8.4\" />"),
    MOUSE_POINTER_CLICK(
        "mouse-pointer-click",
        "<path d=\"M14 4.1 12 6\" />\n  <path d=\"m5.1 8-2.9-.8\" />\n  <path d=\"m6 12-1.9 2\" />\n  <path d=\"M7.2 2.2 8 5.1\" />\n  <path d=\"M9.037 9.69a.498.498 0 0 1 .653-.653l11 4.5a.5.5 0 0 1-.074.949l-4.349 1.041a1 1 0 0 0-.74.739l-1.04 4.35a.5.5 0 0 1-.95.074z\" />"),
    MOVE(
        "move",
        "<path d=\"M12 2v20\" />\n  <path d=\"m15 19-3 3-3-3\" />\n  <path d=\"m19 9 3 3-3 3\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"m5 9-3 3 3 3\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    MOVE_DIAGONAL(
        "move-diagonal",
        "<path d=\"M11 19H5v-6\" />\n  <path d=\"M13 5h6v6\" />\n  <path d=\"M19 5 5 19\" />"),
    MOVE_DIAGONAL_2(
        "move-diagonal-2",
        "<path d=\"M19 13v6h-6\" />\n  <path d=\"M5 11V5h6\" />\n  <path d=\"m5 5 14 14\" />"),
    MOVE_DOWN("move-down", "<path d=\"M8 18L12 22L16 18\" />\n  <path d=\"M12 2V22\" />"),
    MOVE_DOWN_LEFT("move-down-left", "<path d=\"M11 19H5V13\" />\n  <path d=\"M19 5L5 19\" />"),
    MOVE_DOWN_RIGHT("move-down-right", "<path d=\"M19 13V19H13\" />\n  <path d=\"M5 5L19 19\" />"),
    MOVE_HORIZONTAL(
        "move-horizontal",
        "<path d=\"m18 8 4 4-4 4\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"m6 8-4 4 4 4\" />"),
    MOVE_LEFT("move-left", "<path d=\"M6 8L2 12L6 16\" />\n  <path d=\"M2 12H22\" />"),
    MOVE_RIGHT("move-right", "<path d=\"M18 8L22 12L18 16\" />\n  <path d=\"M2 12H22\" />"),
    MOVE_UP("move-up", "<path d=\"M8 6L12 2L16 6\" />\n  <path d=\"M12 2V22\" />"),
    MOVE_UP_LEFT("move-up-left", "<path d=\"M5 11V5H11\" />\n  <path d=\"M5 5L19 19\" />"),
    MOVE_UP_RIGHT("move-up-right", "<path d=\"M13 5H19V11\" />\n  <path d=\"M19 5L5 19\" />"),
    MOVE_VERTICAL(
        "move-vertical",
        "<path d=\"M12 2v20\" />\n  <path d=\"m8 18 4 4 4-4\" />\n  <path d=\"m8 6 4-4 4 4\" />"),
    PANEL_BOTTOM_CLOSE(
        "panel-bottom-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"m15 8-3 3-3-3\" />"),
    PANEL_BOTTOM_OPEN(
        "panel-bottom-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"m9 10 3-3 3 3\" />"),
    PANEL_LEFT_CLOSE(
        "panel-left-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"m16 15-3-3 3-3\" />"),
    PANEL_LEFT_OPEN(
        "panel-left-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"m14 9 3 3-3 3\" />"),
    PANEL_RIGHT_CLOSE(
        "panel-right-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 3v18\" />\n  <path d=\"m8 9 3 3-3 3\" />"),
    PANEL_RIGHT_OPEN(
        "panel-right-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M15 3v18\" />\n  <path d=\"m10 15-3-3 3-3\" />"),
    PANEL_TOP_CLOSE(
        "panel-top-close",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m9 16 3-3 3 3\" />"),
    PANEL_TOP_OPEN(
        "panel-top-open",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m15 14-3 3-3-3\" />"),
    PHONE_FORWARDED(
        "phone-forwarded",
        "<path d=\"M14 6h8\" />\n  <path d=\"m18 2 4 4-4 4\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_INCOMING(
        "phone-incoming",
        "<path d=\"M16 2v6h6\" />\n  <path d=\"m22 2-6 6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_OUTGOING(
        "phone-outgoing",
        "<path d=\"m16 8 6-6\" />\n  <path d=\"M22 8V2h-6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PLAY(
        "play",
        "<path d=\"M5 5a2 2 0 0 1 3.008-1.728l11.997 6.998a2 2 0 0 1 .003 3.458l-12 7A2 2 0 0 1 5 19z\" />"),
    REDO(
        "redo",
        "<path d=\"M21 7v6h-6\" />\n  <path d=\"M3 17a9 9 0 0 1 9-9 9 9 0 0 1 6 2.3l3 2.7\" />"),
    REDO_2(
        "redo-2",
        "<path d=\"m15 14 5-5-5-5\" />\n  <path d=\"M20 9H9.5A5.5 5.5 0 0 0 4 14.5A5.5 5.5 0 0 0 9.5 20H13\" />"),
    REDO_DOT(
        "redo-dot",
        "<circle cx=\"12\" cy=\"17\" r=\"1\" />\n  <path d=\"M21 7v6h-6\" />\n  <path d=\"M3 17a9 9 0 0 1 9-9 9 9 0 0 1 6 2.3l3 2.7\" />"),
    REFRESH_CCW(
        "refresh-ccw",
        "<path d=\"M21 12a9 9 0 0 0-9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <path d=\"M3 12a9 9 0 0 0 9 9 9.75 9.75 0 0 0 6.74-2.74L21 16\" />\n  <path d=\"M16 16h5v5\" />"),
    REFRESH_CCW_DOT(
        "refresh-ccw-dot",
        "<path d=\"M21 12a9 9 0 0 0-9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <path d=\"M3 12a9 9 0 0 0 9 9 9.75 9.75 0 0 0 6.74-2.74L21 16\" />\n  <path d=\"M16 16h5v5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    REFRESH_CW(
        "refresh-cw",
        "<path d=\"M3 12a9 9 0 0 1 9-9 9.75 9.75 0 0 1 6.74 2.74L21 8\" />\n  <path d=\"M21 3v5h-5\" />\n  <path d=\"M21 12a9 9 0 0 1-9 9 9.75 9.75 0 0 1-6.74-2.74L3 16\" />\n  <path d=\"M8 16H3v5\" />"),
    REFRESH_CW_OFF(
        "refresh-cw-off",
        "<path d=\"M21 8L18.74 5.74A9.75 9.75 0 0 0 12 3C11 3 10.03 3.16 9.13 3.47\" />\n  <path d=\"M8 16H3v5\" />\n  <path d=\"M3 12C3 9.51 4 7.26 5.64 5.64\" />\n  <path d=\"m3 16 2.26 2.26A9.75 9.75 0 0 0 12 21c2.49 0 4.74-1 6.36-2.64\" />\n  <path d=\"M21 12c0 1-.16 1.97-.47 2.87\" />\n  <path d=\"M21 3v5h-5\" />\n  <path d=\"M22 22 2 2\" />"),
    REPEAT(
        "repeat",
        "<path d=\"m17 2 4 4-4 4\" />\n  <path d=\"M3 11v-1a4 4 0 0 1 4-4h14\" />\n  <path d=\"m7 22-4-4 4-4\" />\n  <path d=\"M21 13v1a4 4 0 0 1-4 4H3\" />"),
    REPEAT_2(
        "repeat-2",
        "<path d=\"m2 9 3-3 3 3\" />\n  <path d=\"M13 18H7a2 2 0 0 1-2-2V6\" />\n  <path d=\"m22 15-3 3-3-3\" />\n  <path d=\"M11 6h6a2 2 0 0 1 2 2v10\" />"),
    REPEAT_OFF(
        "repeat-off",
        "<path d=\"M11.656 6H21l-4-4\" />\n  <path d=\"M17.898 17.898A4 4 0 0 1 17 18H3l4-4\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 13v1a4 4 0 0 1-.171 1.159\" />\n  <path d=\"m21 6-4 4\" />\n  <path d=\"M3 11v-1a4 4 0 0 1 3.102-3.898\" />\n  <path d=\"m7 22-4-4\" />"),
    REWIND(
        "rewind",
        "<path d=\"M12 6a2 2 0 0 0-3.414-1.414l-6 6a2 2 0 0 0 0 2.828l6 6A2 2 0 0 0 12 18z\" />\n  <path d=\"M22 6a2 2 0 0 0-3.414-1.414l-6 6a2 2 0 0 0 0 2.828l6 6A2 2 0 0 0 22 18z\" />"),
    ROTATE_CCW(
        "rotate-ccw",
        "<path d=\"M3 12a9 9 0 1 0 9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />"),
    ROTATE_CCW_CLOCK(
        "rotate-ccw-clock",
        "<path d=\"M3 12a9 9 0 1 0 9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <path d=\"M12 7v5l4 2\" />"),
    ROTATE_CCW_SQUARE(
        "rotate-ccw-square",
        "<path d=\"M20 9V7a2 2 0 0 0-2-2h-6\" />\n  <path d=\"m15 2-3 3 3 3\" />\n  <path d=\"M20 13v5a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h2\" />"),
    ROTATE_CW(
        "rotate-cw",
        "<path d=\"M21 12a9 9 0 1 1-9-9c2.52 0 4.93 1 6.74 2.74L21 8\" />\n  <path d=\"M21 3v5h-5\" />"),
    ROTATE_CW_CLOCK(
        "rotate-cw-clock",
        "<path d=\"M12 7v5l4 2\" />\n  <path d=\"M16 8h5V3\" />\n  <path d=\"m21 8-2.3-2.3A9.7 9.7 0 0012 3a9 9 0 109 9\" />"),
    ROTATE_CW_SQUARE(
        "rotate-cw-square",
        "<path d=\"M12 5H6a2 2 0 0 0-2 2v3\" />\n  <path d=\"m9 8 3-3-3-3\" />\n  <path d=\"M4 14v4a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />"),
    SEPARATOR_HORIZONTAL(
        "separator-horizontal",
        "<path d=\"m16 16-4 4-4-4\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"m8 8 4-4 4 4\" />"),
    SEPARATOR_VERTICAL(
        "separator-vertical",
        "<path d=\"M12 3v18\" />\n  <path d=\"m16 16 4-4-4-4\" />\n  <path d=\"m8 8-4 4 4 4\" />"),
    SHRINK(
        "shrink",
        "<path d=\"m15 15 6 6m-6-6v4.8m0-4.8h4.8\" />\n  <path d=\"M9 19.8V15m0 0H4.2M9 15l-6 6\" />\n  <path d=\"M15 4.2V9m0 0h4.8M15 9l6-6\" />\n  <path d=\"M9 4.2V9m0 0H4.2M9 9 3 3\" />"),
    SHUFFLE(
        "shuffle",
        "<path d=\"m18 14 4 4-4 4\" />\n  <path d=\"m18 2 4 4-4 4\" />\n  <path d=\"M2 18h1.973a4 4 0 0 0 3.3-1.7l5.454-8.6a4 4 0 0 1 3.3-1.7H22\" />\n  <path d=\"M2 6h1.972a4 4 0 0 1 3.6 2.2\" />\n  <path d=\"M22 18h-6.041a4 4 0 0 1-3.3-1.8l-.359-.45\" />"),
    SIGNPOST(
        "signpost",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M2.354 10.354a1.207 1.207 0 0 1 0-1.708l2.06-2.06A2 2 0 0 1 5.828 6h12.344a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H5.828a2 2 0 0 1-1.414-.586z\" />"),
    SIGNPOST_BIG(
        "signpost-big",
        "<path d=\"M10 9H4L2 7l2-2h6\" />\n  <path d=\"M14 5h6l2 2-2 2h-6\" />\n  <path d=\"M10 22V4a2 2 0 1 1 4 0v18\" />\n  <path d=\"M8 22h8\" />"),
    SKIP_BACK(
        "skip-back",
        "<path d=\"M17.971 4.285A2 2 0 0 1 21 6v12a2 2 0 0 1-3.029 1.715l-9.997-5.998a2 2 0 0 1-.003-3.432z\" />\n  <path d=\"M3 20V4\" />"),
    SKIP_FORWARD(
        "skip-forward",
        "<path d=\"M21 4v16\" />\n  <path d=\"M6.029 4.285A2 2 0 0 0 3 6v12a2 2 0 0 0 3.029 1.715l9.997-5.998a2 2 0 0 0 .003-3.432z\" />"),
    SPLINE_POINTER(
        "spline-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 17A12 12 0 0 1 17 5\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    SPLIT(
        "split",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"M8 3H3v5\" />\n  <path d=\"M12 22v-8.3a4 4 0 0 0-1.172-2.872L3 3\" />\n  <path d=\"m15 9 6-6\" />"),
    SQUARE_ARROW_DOWN(
        "square-arrow-down",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8 12 4 4 4-4\" />"),
    SQUARE_ARROW_DOWN_LEFT(
        "square-arrow-down-left",
        "<path d=\"M15 15H9l6-6\" />\n  <path d=\"M9 15V9\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_ARROW_DOWN_RIGHT(
        "square-arrow-down-right",
        "<path d=\"M15 15 9 9\" />\n  <path d=\"M9 15h6V9\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_ARROW_LEFT(
        "square-arrow-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m12 8-4 4 4 4\" />\n  <path d=\"M16 12H8\" />"),
    SQUARE_ARROW_OUT_DOWN_LEFT(
        "square-arrow-out-down-left",
        "<path d=\"M13 21h6a2 2 0 0 0 2-2V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v6\" />\n  <path d=\"m3 21 9-9\" />\n  <path d=\"M9 21H3v-6\" />"),
    SQUARE_ARROW_OUT_DOWN_RIGHT(
        "square-arrow-out-down-right",
        "<path d=\"M21 11V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />\n  <path d=\"m21 21-9-9\" />\n  <path d=\"M21 15v6h-6\" />"),
    SQUARE_ARROW_OUT_UP_LEFT(
        "square-arrow-out-up-left",
        "<path d=\"M13 3h6a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-6\" />\n  <path d=\"m3 3 9 9\" />\n  <path d=\"M3 9V3h6\" />"),
    SQUARE_ARROW_OUT_UP_RIGHT(
        "square-arrow-out-up-right",
        "<path d=\"M21 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h6\" />\n  <path d=\"m21 3-9 9\" />\n  <path d=\"M15 3h6v6\" />"),
    SQUARE_ARROW_RIGHT(
        "square-arrow-right",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"m12 16 4-4-4-4\" />"),
    SQUARE_ARROW_RIGHT_ENTER(
        "square-arrow-right-enter",
        "<path d=\"m10 16 4-4-4-4\" />\n  <path d=\"M3 12h11\" />\n  <path d=\"M3 8V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />"),
    SQUARE_ARROW_RIGHT_EXIT(
        "square-arrow-right-exit",
        "<path d=\"M10 12h11\" />\n  <path d=\"m17 16 4-4-4-4\" />\n  <path d=\"M21 6.344V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-1.344\" />"),
    SQUARE_ARROW_UP(
        "square-arrow-up",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m16 12-4-4-4 4\" />\n  <path d=\"M12 16V8\" />"),
    SQUARE_ARROW_UP_LEFT(
        "square-arrow-up-left",
        "<path d=\"M15 15 9 9\" />\n  <path d=\"M9 15V9h6\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_ARROW_UP_RIGHT(
        "square-arrow-up-right",
        "<path d=\"M15 15V9H9\" />\n  <path d=\"m9 15 6-6\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_CHEVRON_DOWN(
        "square-chevron-down",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m16 10-4 4-4-4\" />"),
    SQUARE_CHEVRON_LEFT(
        "square-chevron-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m14 16-4-4 4-4\" />"),
    SQUARE_CHEVRON_RIGHT(
        "square-chevron-right",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m10 8 4 4-4 4\" />"),
    SQUARE_CHEVRON_UP(
        "square-chevron-up",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m8 14 4-4 4 4\" />"),
    SQUARE_DASHED_MOUSE_POINTER(
        "square-dashed-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h2\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v2\" />\n  <path d=\"M3 14v1\" />"),
    SQUARE_MOUSE_POINTER(
        "square-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M21 11V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />"),
    SQUARE_PLAY(
        "square-play",
        "<rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M9 9.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997A1 1 0 0 1 9 14.996z\" />"),
    STEP_BACK(
        "step-back",
        "<path d=\"M13.971 4.285A2 2 0 0 1 17 6v12a2 2 0 0 1-3.029 1.715l-9.997-5.998a2 2 0 0 1-.003-3.432z\" />\n  <path d=\"M21 20V4\" />"),
    STEP_FORWARD(
        "step-forward",
        "<path d=\"M10.029 4.285A2 2 0 0 0 7 6v12a2 2 0 0 0 3.029 1.715l9.997-5.998a2 2 0 0 0 .003-3.432z\" />\n  <path d=\"M3 4v16\" />"),
    SUNRISE(
        "sunrise",
        "<path d=\"M12 2v8\" />\n  <path d=\"m4.93 10.93 1.41 1.41\" />\n  <path d=\"M2 18h2\" />\n  <path d=\"M20 18h2\" />\n  <path d=\"m19.07 10.93-1.41 1.41\" />\n  <path d=\"M22 22H2\" />\n  <path d=\"m8 6 4-4 4 4\" />\n  <path d=\"M16 18a4 4 0 0 0-8 0\" />"),
    SUNSET(
        "sunset",
        "<path d=\"M12 10V2\" />\n  <path d=\"m4.93 10.93 1.41 1.41\" />\n  <path d=\"M2 18h2\" />\n  <path d=\"M20 18h2\" />\n  <path d=\"m19.07 10.93-1.41 1.41\" />\n  <path d=\"M22 22H2\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <path d=\"M16 18a4 4 0 0 0-8 0\" />"),
    TEXT_WRAP(
        "text-wrap",
        "<path d=\"m16 16-3 3 3 3\" />\n  <path d=\"M3 12h14.5a1 1 0 0 1 0 7H13\" />\n  <path d=\"M3 19h6\" />\n  <path d=\"M3 5h18\" />"),
    TRENDING_DOWN(
        "trending-down", "<path d=\"M16 17h6v-6\" />\n  <path d=\"m22 17-8.5-8.5-5 5L2 7\" />"),
    TRENDING_UP("trending-up", "<path d=\"M16 7h6v6\" />\n  <path d=\"m22 7-8.5 8.5-5-5L2 17\" />"),
    TRENDING_UP_DOWN(
        "trending-up-down",
        "<path d=\"M14.828 14.828 21 21\" />\n  <path d=\"M21 16v5h-5\" />\n  <path d=\"m21 3-9 9-4-4-6 6\" />\n  <path d=\"M21 8V3h-5\" />"),
    UNDO(
        "undo",
        "<path d=\"M3 7v6h6\" />\n  <path d=\"M21 17a9 9 0 0 0-9-9 9 9 0 0 0-6 2.3L3 13\" />"),
    UNDO_2(
        "undo-2",
        "<path d=\"M9 14 4 9l5-5\" />\n  <path d=\"M4 9h10.5a5.5 5.5 0 0 1 5.5 5.5a5.5 5.5 0 0 1-5.5 5.5H11\" />"),
    UNDO_DOT(
        "undo-dot",
        "<path d=\"M21 17a9 9 0 0 0-15-6.7L3 13\" />\n  <path d=\"M3 7v6h6\" />\n  <circle cx=\"12\" cy=\"17\" r=\"1\" />"),
    UNFOLD_HORIZONTAL(
        "unfold-horizontal",
        "<path d=\"M16 12h6\" />\n  <path d=\"M8 12H2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 8v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m19 15 3-3-3-3\" />\n  <path d=\"m5 9-3 3 3 3\" />"),
    UNFOLD_VERTICAL(
        "unfold-vertical",
        "<path d=\"M12 22v-6\" />\n  <path d=\"M12 8V2\" />\n  <path d=\"M4 12H2\" />\n  <path d=\"M10 12H8\" />\n  <path d=\"M16 12h-2\" />\n  <path d=\"M22 12h-2\" />\n  <path d=\"m15 19-3 3-3-3\" />\n  <path d=\"m15 5-3-3-3 3\" />"),
    UPLOAD(
        "upload",
        "<path d=\"M12 3v12\" />\n  <path d=\"m17 8-5-5-5 5\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4\" />"),
    USER_ROUND_ARROW_LEFT(
        "user-round-arrow-left",
        "<path d=\"m19 16-3 3\" />\n  <path d=\"M2 21a8 8 0 0 1 12.664-6.5\" />\n  <path d=\"M22 19h-6l3 3\" />\n  <circle cx=\"10\" cy=\"8\" r=\"5\" />"),
    WIND_ARROW_UP(
        "wind-arrow-up",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 -4 4 4\" />");

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
  default LucideIcon arrow_big_down_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_DOWN);
  }

  default LucideIcon arrow_big_down_dash_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_DOWN_DASH);
  }

  default LucideIcon arrow_big_left_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_LEFT);
  }

  default LucideIcon arrow_big_left_dash_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_LEFT_DASH);
  }

  default LucideIcon arrow_big_right_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_RIGHT);
  }

  default LucideIcon arrow_big_right_dash_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_RIGHT_DASH);
  }

  default LucideIcon arrow_big_up_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_UP);
  }

  default LucideIcon arrow_big_up_dash_arrows() {
    return LucideIcon.create(Icon.ARROW_BIG_UP_DASH);
  }

  default LucideIcon arrow_down() {
    return LucideIcon.create(Icon.ARROW_DOWN);
  }

  default LucideIcon arrow_down_0_1_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_0_1);
  }

  default LucideIcon arrow_down_1_0_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_1_0);
  }

  default LucideIcon arrow_down_a_z_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_A_Z);
  }

  default LucideIcon arrow_down_from_line_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_FROM_LINE);
  }

  default LucideIcon arrow_down_left() {
    return LucideIcon.create(Icon.ARROW_DOWN_LEFT);
  }

  default LucideIcon arrow_down_narrow_wide_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_NARROW_WIDE);
  }

  default LucideIcon arrow_down_right() {
    return LucideIcon.create(Icon.ARROW_DOWN_RIGHT);
  }

  default LucideIcon arrow_down_to_dot() {
    return LucideIcon.create(Icon.ARROW_DOWN_TO_DOT);
  }

  default LucideIcon arrow_down_to_line_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_TO_LINE);
  }

  default LucideIcon arrow_down_up() {
    return LucideIcon.create(Icon.ARROW_DOWN_UP);
  }

  default LucideIcon arrow_down_wide_narrow_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_WIDE_NARROW);
  }

  default LucideIcon arrow_down_z_a_arrows() {
    return LucideIcon.create(Icon.ARROW_DOWN_Z_A);
  }

  default LucideIcon arrow_left() {
    return LucideIcon.create(Icon.ARROW_LEFT);
  }

  default LucideIcon arrow_left_from_line() {
    return LucideIcon.create(Icon.ARROW_LEFT_FROM_LINE);
  }

  default LucideIcon arrow_left_right() {
    return LucideIcon.create(Icon.ARROW_LEFT_RIGHT);
  }

  default LucideIcon arrow_left_to_line() {
    return LucideIcon.create(Icon.ARROW_LEFT_TO_LINE);
  }

  default LucideIcon arrow_right() {
    return LucideIcon.create(Icon.ARROW_RIGHT);
  }

  default LucideIcon arrow_right_from_line() {
    return LucideIcon.create(Icon.ARROW_RIGHT_FROM_LINE);
  }

  default LucideIcon arrow_right_left() {
    return LucideIcon.create(Icon.ARROW_RIGHT_LEFT);
  }

  default LucideIcon arrow_right_to_line_arrows() {
    return LucideIcon.create(Icon.ARROW_RIGHT_TO_LINE);
  }

  default LucideIcon arrow_up() {
    return LucideIcon.create(Icon.ARROW_UP);
  }

  default LucideIcon arrow_up_0_1_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_0_1);
  }

  default LucideIcon arrow_up_1_0_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_1_0);
  }

  default LucideIcon arrow_up_a_z_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_A_Z);
  }

  default LucideIcon arrow_up_down() {
    return LucideIcon.create(Icon.ARROW_UP_DOWN);
  }

  default LucideIcon arrow_up_from_dot() {
    return LucideIcon.create(Icon.ARROW_UP_FROM_DOT);
  }

  default LucideIcon arrow_up_from_line_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_FROM_LINE);
  }

  default LucideIcon arrow_up_left() {
    return LucideIcon.create(Icon.ARROW_UP_LEFT);
  }

  default LucideIcon arrow_up_narrow_wide_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_NARROW_WIDE);
  }

  default LucideIcon arrow_up_right() {
    return LucideIcon.create(Icon.ARROW_UP_RIGHT);
  }

  default LucideIcon arrow_up_to_line_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_TO_LINE);
  }

  default LucideIcon arrow_up_wide_narrow_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_WIDE_NARROW);
  }

  default LucideIcon arrow_up_z_a_arrows() {
    return LucideIcon.create(Icon.ARROW_UP_Z_A);
  }

  default LucideIcon arrows_up_from_line_arrows() {
    return LucideIcon.create(Icon.ARROWS_UP_FROM_LINE);
  }

  default LucideIcon calendar_chevrons_left_arrows() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_LEFT);
  }

  default LucideIcon calendar_chevrons_right_arrows() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_RIGHT);
  }

  default LucideIcon calendar_sync_arrows() {
    return LucideIcon.create(Icon.CALENDAR_SYNC);
  }

  default LucideIcon chevron_down_arrows() {
    return LucideIcon.create(Icon.CHEVRON_DOWN);
  }

  default LucideIcon chevron_first_arrows() {
    return LucideIcon.create(Icon.CHEVRON_FIRST);
  }

  default LucideIcon chevron_last_arrows() {
    return LucideIcon.create(Icon.CHEVRON_LAST);
  }

  default LucideIcon chevron_left() {
    return LucideIcon.create(Icon.CHEVRON_LEFT);
  }

  default LucideIcon chevron_right_arrows() {
    return LucideIcon.create(Icon.CHEVRON_RIGHT);
  }

  default LucideIcon chevron_up_arrows() {
    return LucideIcon.create(Icon.CHEVRON_UP);
  }

  default LucideIcon chevrons_down_arrows() {
    return LucideIcon.create(Icon.CHEVRONS_DOWN);
  }

  default LucideIcon chevrons_down_up() {
    return LucideIcon.create(Icon.CHEVRONS_DOWN_UP);
  }

  default LucideIcon chevrons_left_arrows() {
    return LucideIcon.create(Icon.CHEVRONS_LEFT);
  }

  default LucideIcon chevrons_left_right() {
    return LucideIcon.create(Icon.CHEVRONS_LEFT_RIGHT);
  }

  default LucideIcon chevrons_right_arrows() {
    return LucideIcon.create(Icon.CHEVRONS_RIGHT);
  }

  default LucideIcon chevrons_right_left() {
    return LucideIcon.create(Icon.CHEVRONS_RIGHT_LEFT);
  }

  default LucideIcon chevrons_up_arrows() {
    return LucideIcon.create(Icon.CHEVRONS_UP);
  }

  default LucideIcon chevrons_up_down() {
    return LucideIcon.create(Icon.CHEVRONS_UP_DOWN);
  }

  default LucideIcon circle_arrow_down_arrows() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_DOWN);
  }

  default LucideIcon circle_arrow_left_arrows() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_LEFT);
  }

  default LucideIcon circle_arrow_out_down_left() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_OUT_DOWN_LEFT);
  }

  default LucideIcon circle_arrow_out_down_right() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_OUT_DOWN_RIGHT);
  }

  default LucideIcon circle_arrow_out_up_left_arrows() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_OUT_UP_LEFT);
  }

  default LucideIcon circle_arrow_out_up_right() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_OUT_UP_RIGHT);
  }

  default LucideIcon circle_arrow_right_arrows() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_RIGHT);
  }

  default LucideIcon circle_arrow_up_arrows() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_UP);
  }

  default LucideIcon circle_chevron_down() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRON_DOWN);
  }

  default LucideIcon circle_chevron_left() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRON_LEFT);
  }

  default LucideIcon circle_chevron_right() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRON_RIGHT);
  }

  default LucideIcon circle_chevron_up() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRON_UP);
  }

  default LucideIcon circle_chevrons_down_arrows() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_DOWN);
  }

  default LucideIcon circle_chevrons_left_arrows() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_LEFT);
  }

  default LucideIcon circle_chevrons_right_arrows() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_RIGHT);
  }

  default LucideIcon circle_chevrons_up_arrows() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_UP);
  }

  default LucideIcon circle_fading_arrow_up_arrows() {
    return LucideIcon.create(Icon.CIRCLE_FADING_ARROW_UP);
  }

  default LucideIcon clipboard_copy_arrows() {
    return LucideIcon.create(Icon.CLIPBOARD_COPY);
  }

  default LucideIcon clipboard_paste_arrows() {
    return LucideIcon.create(Icon.CLIPBOARD_PASTE);
  }

  default LucideIcon clock_arrow_right_arrows() {
    return LucideIcon.create(Icon.CLOCK_ARROW_RIGHT);
  }

  default LucideIcon cloud_backup_arrows() {
    return LucideIcon.create(Icon.CLOUD_BACKUP);
  }

  default LucideIcon cloud_download_arrows() {
    return LucideIcon.create(Icon.CLOUD_DOWNLOAD);
  }

  default LucideIcon cloud_sync_arrows() {
    return LucideIcon.create(Icon.CLOUD_SYNC);
  }

  default LucideIcon cloud_upload_arrows() {
    return LucideIcon.create(Icon.CLOUD_UPLOAD);
  }

  default LucideIcon corner_down_left() {
    return LucideIcon.create(Icon.CORNER_DOWN_LEFT);
  }

  default LucideIcon corner_down_right_arrows() {
    return LucideIcon.create(Icon.CORNER_DOWN_RIGHT);
  }

  default LucideIcon corner_left_down() {
    return LucideIcon.create(Icon.CORNER_LEFT_DOWN);
  }

  default LucideIcon corner_left_up() {
    return LucideIcon.create(Icon.CORNER_LEFT_UP);
  }

  default LucideIcon corner_right_down() {
    return LucideIcon.create(Icon.CORNER_RIGHT_DOWN);
  }

  default LucideIcon corner_right_up() {
    return LucideIcon.create(Icon.CORNER_RIGHT_UP);
  }

  default LucideIcon corner_up_left() {
    return LucideIcon.create(Icon.CORNER_UP_LEFT);
  }

  default LucideIcon corner_up_right() {
    return LucideIcon.create(Icon.CORNER_UP_RIGHT);
  }

  default LucideIcon database_backup_arrows() {
    return LucideIcon.create(Icon.DATABASE_BACKUP);
  }

  default LucideIcon decimals_arrow_left_arrows() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_LEFT);
  }

  default LucideIcon decimals_arrow_right_arrows() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_RIGHT);
  }

  default LucideIcon delete_arrows() {
    return LucideIcon.create(Icon.DELETE);
  }

  default LucideIcon download_arrows() {
    return LucideIcon.create(Icon.DOWNLOAD);
  }

  default LucideIcon expand_arrows() {
    return LucideIcon.create(Icon.EXPAND);
  }

  default LucideIcon external_link_arrows() {
    return LucideIcon.create(Icon.EXTERNAL_LINK);
  }

  default LucideIcon fast_forward_arrows() {
    return LucideIcon.create(Icon.FAST_FORWARD);
  }

  default LucideIcon file_down_arrows() {
    return LucideIcon.create(Icon.FILE_DOWN);
  }

  default LucideIcon file_input_arrows() {
    return LucideIcon.create(Icon.FILE_INPUT);
  }

  default LucideIcon file_output_arrows() {
    return LucideIcon.create(Icon.FILE_OUTPUT);
  }

  default LucideIcon file_up_arrows() {
    return LucideIcon.create(Icon.FILE_UP);
  }

  default LucideIcon fold_horizontal_arrows() {
    return LucideIcon.create(Icon.FOLD_HORIZONTAL);
  }

  default LucideIcon fold_vertical_arrows() {
    return LucideIcon.create(Icon.FOLD_VERTICAL);
  }

  default LucideIcon folder_down_arrows() {
    return LucideIcon.create(Icon.FOLDER_DOWN);
  }

  default LucideIcon folder_input_arrows() {
    return LucideIcon.create(Icon.FOLDER_INPUT);
  }

  default LucideIcon folder_output_arrows() {
    return LucideIcon.create(Icon.FOLDER_OUTPUT);
  }

  default LucideIcon folder_sync_arrows() {
    return LucideIcon.create(Icon.FOLDER_SYNC);
  }

  default LucideIcon folder_up_arrows() {
    return LucideIcon.create(Icon.FOLDER_UP);
  }

  default LucideIcon git_compare_arrows_arrows() {
    return LucideIcon.create(Icon.GIT_COMPARE_ARROWS);
  }

  default LucideIcon git_pull_request_arrow_arrows() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_ARROW);
  }

  default LucideIcon git_pull_request_create_arrow_arrows() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_CREATE_ARROW);
  }

  default LucideIcon hard_drive_download_arrows() {
    return LucideIcon.create(Icon.HARD_DRIVE_DOWNLOAD);
  }

  default LucideIcon hard_drive_upload_arrows() {
    return LucideIcon.create(Icon.HARD_DRIVE_UPLOAD);
  }

  default LucideIcon import_arrows() {
    return LucideIcon.create(Icon.IMPORT);
  }

  default LucideIcon iteration_ccw_arrows() {
    return LucideIcon.create(Icon.ITERATION_CCW);
  }

  default LucideIcon iteration_cw_arrows() {
    return LucideIcon.create(Icon.ITERATION_CW);
  }

  default LucideIcon lasso_select_arrows() {
    return LucideIcon.create(Icon.LASSO_SELECT);
  }

  default LucideIcon layers_arrow_up_arrows() {
    return LucideIcon.create(Icon.LAYERS_ARROW_UP);
  }

  default LucideIcon list_chevrons_down_up_arrows() {
    return LucideIcon.create(Icon.LIST_CHEVRONS_DOWN_UP);
  }

  default LucideIcon list_chevrons_up_down_arrows() {
    return LucideIcon.create(Icon.LIST_CHEVRONS_UP_DOWN);
  }

  default LucideIcon log_in_arrows() {
    return LucideIcon.create(Icon.LOG_IN);
  }

  default LucideIcon log_out_arrows() {
    return LucideIcon.create(Icon.LOG_OUT);
  }

  default LucideIcon maximize_2_arrows() {
    return LucideIcon.create(Icon.MAXIMIZE_2);
  }

  default LucideIcon merge_arrows() {
    return LucideIcon.create(Icon.MERGE);
  }

  default LucideIcon milestone_arrows() {
    return LucideIcon.create(Icon.MILESTONE);
  }

  default LucideIcon minimize_2_arrows() {
    return LucideIcon.create(Icon.MINIMIZE_2);
  }

  default LucideIcon mouse_pointer_arrows() {
    return LucideIcon.create(Icon.MOUSE_POINTER);
  }

  default LucideIcon mouse_pointer_2_arrows() {
    return LucideIcon.create(Icon.MOUSE_POINTER_2);
  }

  default LucideIcon mouse_pointer_2_off_arrows() {
    return LucideIcon.create(Icon.MOUSE_POINTER_2_OFF);
  }

  default LucideIcon mouse_pointer_ban_arrows() {
    return LucideIcon.create(Icon.MOUSE_POINTER_BAN);
  }

  default LucideIcon mouse_pointer_click_arrows() {
    return LucideIcon.create(Icon.MOUSE_POINTER_CLICK);
  }

  default LucideIcon move_arrows() {
    return LucideIcon.create(Icon.MOVE);
  }

  default LucideIcon move_diagonal_arrows() {
    return LucideIcon.create(Icon.MOVE_DIAGONAL);
  }

  default LucideIcon move_diagonal_2_arrows() {
    return LucideIcon.create(Icon.MOVE_DIAGONAL_2);
  }

  default LucideIcon move_down() {
    return LucideIcon.create(Icon.MOVE_DOWN);
  }

  default LucideIcon move_down_left() {
    return LucideIcon.create(Icon.MOVE_DOWN_LEFT);
  }

  default LucideIcon move_down_right() {
    return LucideIcon.create(Icon.MOVE_DOWN_RIGHT);
  }

  default LucideIcon move_horizontal_arrows() {
    return LucideIcon.create(Icon.MOVE_HORIZONTAL);
  }

  default LucideIcon move_left() {
    return LucideIcon.create(Icon.MOVE_LEFT);
  }

  default LucideIcon move_right() {
    return LucideIcon.create(Icon.MOVE_RIGHT);
  }

  default LucideIcon move_up() {
    return LucideIcon.create(Icon.MOVE_UP);
  }

  default LucideIcon move_up_left() {
    return LucideIcon.create(Icon.MOVE_UP_LEFT);
  }

  default LucideIcon move_up_right() {
    return LucideIcon.create(Icon.MOVE_UP_RIGHT);
  }

  default LucideIcon move_vertical_arrows() {
    return LucideIcon.create(Icon.MOVE_VERTICAL);
  }

  default LucideIcon panel_bottom_close_arrows() {
    return LucideIcon.create(Icon.PANEL_BOTTOM_CLOSE);
  }

  default LucideIcon panel_bottom_open_arrows() {
    return LucideIcon.create(Icon.PANEL_BOTTOM_OPEN);
  }

  default LucideIcon panel_left_close_arrows() {
    return LucideIcon.create(Icon.PANEL_LEFT_CLOSE);
  }

  default LucideIcon panel_left_open_arrows() {
    return LucideIcon.create(Icon.PANEL_LEFT_OPEN);
  }

  default LucideIcon panel_right_close_arrows() {
    return LucideIcon.create(Icon.PANEL_RIGHT_CLOSE);
  }

  default LucideIcon panel_right_open_arrows() {
    return LucideIcon.create(Icon.PANEL_RIGHT_OPEN);
  }

  default LucideIcon panel_top_close_arrows() {
    return LucideIcon.create(Icon.PANEL_TOP_CLOSE);
  }

  default LucideIcon panel_top_open_arrows() {
    return LucideIcon.create(Icon.PANEL_TOP_OPEN);
  }

  default LucideIcon phone_forwarded_arrows() {
    return LucideIcon.create(Icon.PHONE_FORWARDED);
  }

  default LucideIcon phone_incoming_arrows() {
    return LucideIcon.create(Icon.PHONE_INCOMING);
  }

  default LucideIcon phone_outgoing_arrows() {
    return LucideIcon.create(Icon.PHONE_OUTGOING);
  }

  default LucideIcon play_arrows() {
    return LucideIcon.create(Icon.PLAY);
  }

  default LucideIcon redo_arrows() {
    return LucideIcon.create(Icon.REDO);
  }

  default LucideIcon redo_2_arrows() {
    return LucideIcon.create(Icon.REDO_2);
  }

  default LucideIcon redo_dot_arrows() {
    return LucideIcon.create(Icon.REDO_DOT);
  }

  default LucideIcon refresh_ccw() {
    return LucideIcon.create(Icon.REFRESH_CCW);
  }

  default LucideIcon refresh_ccw_dot_arrows() {
    return LucideIcon.create(Icon.REFRESH_CCW_DOT);
  }

  default LucideIcon refresh_cw() {
    return LucideIcon.create(Icon.REFRESH_CW);
  }

  default LucideIcon refresh_cw_off() {
    return LucideIcon.create(Icon.REFRESH_CW_OFF);
  }

  default LucideIcon repeat_arrows() {
    return LucideIcon.create(Icon.REPEAT);
  }

  default LucideIcon repeat_2_arrows() {
    return LucideIcon.create(Icon.REPEAT_2);
  }

  default LucideIcon repeat_off_arrows() {
    return LucideIcon.create(Icon.REPEAT_OFF);
  }

  default LucideIcon rewind_arrows() {
    return LucideIcon.create(Icon.REWIND);
  }

  default LucideIcon rotate_ccw_arrows() {
    return LucideIcon.create(Icon.ROTATE_CCW);
  }

  default LucideIcon rotate_ccw_clock_arrows() {
    return LucideIcon.create(Icon.ROTATE_CCW_CLOCK);
  }

  default LucideIcon rotate_ccw_square_arrows() {
    return LucideIcon.create(Icon.ROTATE_CCW_SQUARE);
  }

  default LucideIcon rotate_cw_arrows() {
    return LucideIcon.create(Icon.ROTATE_CW);
  }

  default LucideIcon rotate_cw_clock_arrows() {
    return LucideIcon.create(Icon.ROTATE_CW_CLOCK);
  }

  default LucideIcon rotate_cw_square_arrows() {
    return LucideIcon.create(Icon.ROTATE_CW_SQUARE);
  }

  default LucideIcon separator_horizontal_arrows() {
    return LucideIcon.create(Icon.SEPARATOR_HORIZONTAL);
  }

  default LucideIcon separator_vertical_arrows() {
    return LucideIcon.create(Icon.SEPARATOR_VERTICAL);
  }

  default LucideIcon shrink_arrows() {
    return LucideIcon.create(Icon.SHRINK);
  }

  default LucideIcon shuffle_arrows() {
    return LucideIcon.create(Icon.SHUFFLE);
  }

  default LucideIcon signpost_arrows() {
    return LucideIcon.create(Icon.SIGNPOST);
  }

  default LucideIcon signpost_big_arrows() {
    return LucideIcon.create(Icon.SIGNPOST_BIG);
  }

  default LucideIcon skip_back_arrows() {
    return LucideIcon.create(Icon.SKIP_BACK);
  }

  default LucideIcon skip_forward_arrows() {
    return LucideIcon.create(Icon.SKIP_FORWARD);
  }

  default LucideIcon spline_pointer_arrows() {
    return LucideIcon.create(Icon.SPLINE_POINTER);
  }

  default LucideIcon split_arrows() {
    return LucideIcon.create(Icon.SPLIT);
  }

  default LucideIcon square_arrow_down_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_DOWN);
  }

  default LucideIcon square_arrow_down_left_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_DOWN_LEFT);
  }

  default LucideIcon square_arrow_down_right_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_DOWN_RIGHT);
  }

  default LucideIcon square_arrow_left() {
    return LucideIcon.create(Icon.SQUARE_ARROW_LEFT);
  }

  default LucideIcon square_arrow_out_down_left() {
    return LucideIcon.create(Icon.SQUARE_ARROW_OUT_DOWN_LEFT);
  }

  default LucideIcon square_arrow_out_down_right() {
    return LucideIcon.create(Icon.SQUARE_ARROW_OUT_DOWN_RIGHT);
  }

  default LucideIcon square_arrow_out_up_left() {
    return LucideIcon.create(Icon.SQUARE_ARROW_OUT_UP_LEFT);
  }

  default LucideIcon square_arrow_out_up_right_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_OUT_UP_RIGHT);
  }

  default LucideIcon square_arrow_right() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT);
  }

  default LucideIcon square_arrow_right_enter_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_ENTER);
  }

  default LucideIcon square_arrow_right_exit_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_EXIT);
  }

  default LucideIcon square_arrow_up() {
    return LucideIcon.create(Icon.SQUARE_ARROW_UP);
  }

  default LucideIcon square_arrow_up_left() {
    return LucideIcon.create(Icon.SQUARE_ARROW_UP_LEFT);
  }

  default LucideIcon square_arrow_up_right_arrows() {
    return LucideIcon.create(Icon.SQUARE_ARROW_UP_RIGHT);
  }

  default LucideIcon square_chevron_down_arrows() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_DOWN);
  }

  default LucideIcon square_chevron_left_arrows() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_LEFT);
  }

  default LucideIcon square_chevron_right_arrows() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_RIGHT);
  }

  default LucideIcon square_chevron_up_arrows() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_UP);
  }

  default LucideIcon square_dashed_mouse_pointer_arrows() {
    return LucideIcon.create(Icon.SQUARE_DASHED_MOUSE_POINTER);
  }

  default LucideIcon square_mouse_pointer_arrows() {
    return LucideIcon.create(Icon.SQUARE_MOUSE_POINTER);
  }

  default LucideIcon square_play_arrows() {
    return LucideIcon.create(Icon.SQUARE_PLAY);
  }

  default LucideIcon step_back_arrows() {
    return LucideIcon.create(Icon.STEP_BACK);
  }

  default LucideIcon step_forward_arrows() {
    return LucideIcon.create(Icon.STEP_FORWARD);
  }

  default LucideIcon sunrise_arrows() {
    return LucideIcon.create(Icon.SUNRISE);
  }

  default LucideIcon sunset_arrows() {
    return LucideIcon.create(Icon.SUNSET);
  }

  default LucideIcon text_wrap_arrows() {
    return LucideIcon.create(Icon.TEXT_WRAP);
  }

  default LucideIcon trending_down_arrows() {
    return LucideIcon.create(Icon.TRENDING_DOWN);
  }

  default LucideIcon trending_up_arrows() {
    return LucideIcon.create(Icon.TRENDING_UP);
  }

  default LucideIcon trending_up_down_arrows() {
    return LucideIcon.create(Icon.TRENDING_UP_DOWN);
  }

  default LucideIcon undo_arrows() {
    return LucideIcon.create(Icon.UNDO);
  }

  default LucideIcon undo_2_arrows() {
    return LucideIcon.create(Icon.UNDO_2);
  }

  default LucideIcon undo_dot_arrows() {
    return LucideIcon.create(Icon.UNDO_DOT);
  }

  default LucideIcon unfold_horizontal_arrows() {
    return LucideIcon.create(Icon.UNFOLD_HORIZONTAL);
  }

  default LucideIcon unfold_vertical_arrows() {
    return LucideIcon.create(Icon.UNFOLD_VERTICAL);
  }

  default LucideIcon upload_arrows() {
    return LucideIcon.create(Icon.UPLOAD);
  }

  default LucideIcon user_round_arrow_left_arrows() {
    return LucideIcon.create(Icon.USER_ROUND_ARROW_LEFT);
  }

  default LucideIcon wind_arrow_up_arrows() {
    return LucideIcon.create(Icon.WIND_ARROW_UP);
  }
}
