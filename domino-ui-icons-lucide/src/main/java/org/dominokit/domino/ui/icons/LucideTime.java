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

/** Lucide time catalog category. */
public interface LucideTime {
  enum Icon implements LucideIconDefinition {
    ALARM_CLOCK(
        "alarm-clock",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M12 9v4l2 2\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />"),
    ALARM_CLOCK_CHECK(
        "alarm-clock-check",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"m9 13 2 2 4-4\" />"),
    ALARM_CLOCK_MINUS(
        "alarm-clock-minus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M9 13h6\" />"),
    ALARM_CLOCK_OFF(
        "alarm-clock-off",
        "<path d=\"M6.87 6.87a8 8 0 1 0 11.26 11.26\" />\n  <path d=\"M19.9 14.25a8 8 0 0 0-9.15-9.15\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.26 18.67 4 21\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M4 4 2 6\" />"),
    ALARM_CLOCK_PLUS(
        "alarm-clock-plus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"M9 13h6\" />"),
    CALENDAR(
        "calendar",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />"),
    CALENDAR_1(
        "calendar-1",
        "<path d=\"M11 13h1v4\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    CALENDAR_ARROW_DOWN(
        "calendar-arrow-down",
        "<path d=\"m14 17 4 4 4-4\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M18 13v8\" />\n  <path d=\"M21 10.354V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h7.343\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_ARROW_UP(
        "calendar-arrow-up",
        "<path d=\"m14 17 4-4 4 4\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M18 21v-8\" />\n  <path d=\"M21 10.343V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h9\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CHECK(
        "calendar-check",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m9 15 2 2 4-4\" />"),
    CALENDAR_CHECK_2(
        "calendar-check-2",
        "<path d=\"M 19 3 L 5 3\" />\n  <path d=\"M 21 13 L 21 5\" />\n  <path d=\"M 21 5 A2 2 0 0 0 19 3\" />\n  <path d=\"M 3 19 A2 2 0 0 0 5 21\" />\n  <path d=\"M 3 5 L 3 19\" />\n  <path d=\"M 5 3 A2 2 0 0 0 3 5\" />\n  <path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M5 21 L12.5 21\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CHEVRONS_LEFT(
        "calendar-chevrons-left",
        "<path d=\"m11 21-3-3 3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M3 11.5V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2h-4\" />\n  <path d=\"m5 21-3-3 3-3\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CHEVRONS_RIGHT(
        "calendar-chevrons-right",
        "<path d=\"m13 21 3-3-3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m19 21 3-3-3-3\" />\n  <path d=\"M21 11.5V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h4\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CLOCK(
        "calendar-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M21 7.338V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h2.338\" />\n  <path d=\"M3 9h5.859\" />\n  <path d=\"M8 2v3\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    CALENDAR_COG(
        "calendar-cog",
        "<path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m15.228 19.148-.923.383\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m16.47 14.305.382.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.773 16.852.924-.383\" />\n  <path d=\"m20.773 19.148.924.383\" />\n  <path d=\"M21 10.5V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h5.5\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    CALENDAR_DAYS(
        "calendar-days",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 13h.01\" />\n  <path d=\"M12 13h.01\" />\n  <path d=\"M16 13h.01\" />\n  <path d=\"M8 17h.01\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M16 17h.01\" />"),
    CALENDAR_FOLD(
        "calendar-fold",
        "<path d=\"M16 2v3\" />\n  <path d=\"M21 15V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h10v-5a1 1 0 011-1za2.4 2.4 0 01-.706 1.706l-3.588 3.588A2.4 2.4 0 0115 21\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_HEART(
        "calendar-heart",
        "<path d=\"M12.127 21H5a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v5.125\" />\n  <path d=\"M14.62 17.8A2.25 2.25 0 1118 14.836a2.25 2.25 0 113.38 2.966l-2.626 2.856a.998.998 0 01-1.507 0z\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_MINUS(
        "calendar-minus",
        "<path d=\"M16 18h6\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M21 14V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h8.3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_MINUS_2(
        "calendar-minus-2",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M10 15h4\" />"),
    CALENDAR_OFF(
        "calendar-off",
        "<path d=\"M16 2v3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 9h-5.5\" />\n  <path d=\"M3 9h6\" />\n  <path d=\"M3.586 3.586A2 2 0 003 5v14a2 2 0 002 2h14a2 2 0 001.414-.586\" />\n  <path d=\"M8.656 3H19a2 2 0 012 2v10.344\" />"),
    CALENDAR_PLUS(
        "calendar-plus",
        "<path d=\"M16 18h6\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M19 15v6\" />\n  <path d=\"M21 11.5V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h8.3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_PLUS_2(
        "calendar-plus-2",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M10 15h4\" />\n  <path d=\"M12 13v4\" />"),
    CALENDAR_RANGE(
        "calendar-range",
        "<rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />\n  <path d=\"M17 13h-6\" />\n  <path d=\"M13 17H7\" />\n  <path d=\"M7 13h.01\" />\n  <path d=\"M17 17h.01\" />"),
    CALENDAR_SEARCH(
        "calendar-search",
        "<path d=\"M16 2v3\" />\n  <path d=\"M21 10.69V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h7.25\" />\n  <path d=\"m22 21-1.875-1.875\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />\n  <circle cx=\"18\" cy=\"17\" r=\"3\" />"),
    CALENDAR_SYNC(
        "calendar-sync",
        "<path d=\"M11 10v4h4\" />\n  <path d=\"m11 14 1.535-1.605a5 5 0 018 1.5\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m21 18-1.535 1.605a5 5 0 01-8-1.5\" />\n  <path d=\"M21 22v-4h-4\" />\n  <path d=\"M21 8.517V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h3.517\" />\n  <path d=\"M3 9h4\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_X(
        "calendar-x",
        "<path d=\"M8 2v3\" />\n  <path d=\"M16 2v3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"m14 13-4 4\" />\n  <path d=\"m10 13 4 4\" />"),
    CALENDAR_X_2(
        "calendar-x-2",
        "<path d=\"M16 2v3\" />\n  <path d=\"m17 16 5 5\" />\n  <path d=\"m17 21 5-5\" />\n  <path d=\"M21 12V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h8\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CALENDARS(
        "calendars",
        "<path d=\"M12 2v2\" />\n  <path d=\"M15.726 21.01A2 2 0 0 1 14 22H4a2 2 0 0 1-2-2V10a2 2 0 0 1 2-2\" />\n  <path d=\"M18 2v2\" />\n  <path d=\"M2 13h2\" />\n  <path d=\"M8 8h14\" />\n  <rect x=\"8\" y=\"3\" width=\"14\" height=\"14\" rx=\"2\" />"),
    CHART_NO_AXES_GANTT(
        "chart-no-axes-gantt",
        "<path d=\"M6 5h12\" />\n  <path d=\"M4 12h10\" />\n  <path d=\"M12 19h8\" />"),
    CLIPBOARD_CLOCK(
        "clipboard-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v.832\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h2\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />\n  <rect x=\"8\" y=\"2\" width=\"8\" height=\"4\" rx=\"1\" />"),
    CLOCK("clock", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l4 2\" />"),
    CLOCK_1("clock-1", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l2-4\" />"),
    CLOCK_10("clock-10", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l-4-2\" />"),
    CLOCK_11("clock-11", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l-2-4\" />"),
    CLOCK_12("clock-12", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6\" />"),
    CLOCK_2("clock-2", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l4-2\" />"),
    CLOCK_3("clock-3", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6h4\" />"),
    CLOCK_4("clock-4", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l4 2\" />"),
    CLOCK_5("clock-5", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l2 4\" />"),
    CLOCK_6("clock-6", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v10\" />"),
    CLOCK_7("clock-7", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l-2 4\" />"),
    CLOCK_8("clock-8", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6l-4 2\" />"),
    CLOCK_9("clock-9", "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 6v6H8\" />"),
    CLOCK_ALERT(
        "clock-alert",
        "<path d=\"M12 6v6l4 2\" />\n  <path d=\"M20 12v5\" />\n  <path d=\"M20 21h.01\" />\n  <path d=\"M21.25 8.2A10 10 0 1 0 16 21.16\" />"),
    CLOCK_ARROW_DOWN(
        "clock-arrow-down",
        "<path d=\"M12 6v6l2 1\" />\n  <path d=\"M12.337 21.994a10 10 0 1 1 9.588-8.767\" />\n  <path d=\"m14 18 4 4 4-4\" />\n  <path d=\"M18 14v8\" />"),
    CLOCK_ARROW_LEFT(
        "clock-arrow-left",
        "<path d=\"M12 6v6l1.5.8\" />\n  <path d=\"M12.338 21.994a10 10 0 1 1 9.587-8.767\" />\n  <path d=\"M14 18h8\" />\n  <path d=\"m18 22-4-4 4-4\" />"),
    CLOCK_ARROW_RIGHT(
        "clock-arrow-right",
        "<path d=\"M12 6v6l2 1\" />\n  <path d=\"M13.5 21.885A10 10 0 1 1 22 12\" />\n  <path d=\"M14 18h8\" />\n  <path d=\"m18 22 4-4-4-4\" />"),
    CLOCK_ARROW_UP(
        "clock-arrow-up",
        "<path d=\"M12 6v6l1.56.78\" />\n  <path d=\"M13.227 21.925a10 10 0 1 1 8.767-9.588\" />\n  <path d=\"m14 18 4-4 4 4\" />\n  <path d=\"M18 22v-8\" />"),
    CLOCK_CHECK(
        "clock-check",
        "<path d=\"M21.95 13a10 10 0 1 0-8.685 8.92\" />\n  <path d=\"M12 6v6l4 2\" />\n  <path d=\"m16 19 2 2 4-4\" />"),
    CLOCK_FADING(
        "clock-fading",
        "<path d=\"M12 2a10 10 0 0 1 7.38 16.75\" />\n  <path d=\"M12 6v6l4 2\" />\n  <path d=\"M2.5 8.875a10 10 0 0 0-.5 3\" />\n  <path d=\"M2.83 16a10 10 0 0 0 2.43 3.4\" />\n  <path d=\"M4.636 5.235a10 10 0 0 1 .891-.857\" />\n  <path d=\"M8.644 21.42a10 10 0 0 0 7.631-.38\" />"),
    CLOCK_PLUS(
        "clock-plus",
        "<path d=\"M12 6v6l3.644 1.822\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M21.92 13.267a10 10 0 1 0-8.653 8.653\" />"),
    FILE_CLOCK(
        "file-clock",
        "<path d=\"M16 22h2a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v2.85\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 14v2.2l1.6 1\" />\n  <circle cx=\"8\" cy=\"16\" r=\"6\" />"),
    FOLDER_CLOCK(
        "folder-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"M7 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    HOURGLASS(
        "hourglass",
        "<path d=\"M5 22h14\" />\n  <path d=\"M5 2h14\" />\n  <path d=\"M17 22v-4.172a2 2 0 0 0-.586-1.414L12 12l-4.414 4.414A2 2 0 0 0 7 17.828V22\" />\n  <path d=\"M7 2v4.172a2 2 0 0 0 .586 1.414L12 12l4.414-4.414A2 2 0 0 0 17 6.172V2\" />"),
    HOURGLASS_COG(
        "hourglass-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"M17 2v4.172a2 2 0 0 1-.586 1.414l-8.828 8.828A2 2 0 0 0 7 17.828V22\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.772 16.852.924-.383\" />\n  <path d=\"m20.772 19.148.924.383\" />\n  <path d=\"M5 22h6.159\" />\n  <path d=\"M5 2h14\" />\n  <path d=\"M7 2v4.172a2 2 0 0 0 .586 1.414l5.188 5.188\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    LIST_CLOCK(
        "list-clock",
        "<path d=\"M16 13v2.2l1.6 1\" />\n  <path d=\"M3 12h3.458\" />\n  <path d=\"M3 19h3.832\" />\n  <path d=\"M3 5h18\" />\n  <circle cx=\"16\" cy=\"15\" r=\"6\" />"),
    MAIL_CLOCK(
        "mail-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"m22 7-.759.484\" />\n  <path d=\"M6.835 20H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v2\" />\n  <path d=\"M7.605 10.567 2 7\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    METRONOME(
        "metronome",
        "<path d=\"M12 11.4V9.1\" />\n  <path d=\"m12 17 6.59-6.59\" />\n  <path d=\"m15.05 5.7-.218-.691a3 3 0 0 0-5.663 0L4.418 19.695A1 1 0 0 0 5.37 21h13.253a1 1 0 0 0 .951-1.31L18.45 16.2\" />\n  <circle cx=\"20\" cy=\"9\" r=\"2\" />"),
    ROTATE_CCW_CLOCK(
        "rotate-ccw-clock",
        "<path d=\"M3 12a9 9 0 1 0 9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <path d=\"M12 7v5l4 2\" />"),
    ROTATE_CW_CLOCK(
        "rotate-cw-clock",
        "<path d=\"M12 7v5l4 2\" />\n  <path d=\"M16 8h5V3\" />\n  <path d=\"m21 8-2.3-2.3A9.7 9.7 0 0012 3a9 9 0 109 9\" />"),
    ROTATE_CW_FADING_CLOCK(
        "rotate-cw-fading-clock",
        "<path d=\"M12 3a9.75 9.75 0 0 1 6.74 2.74\" />\n  <path d=\"M18.74 5.74 21 8\" />\n  <path d=\"M21 8V3\" />\n  <path d=\"M7.5 19.794c-6-3.464-6-12.124 0-15.588\" />\n  <path d=\"M7.5 4.206A9 9 0 0 1 12 3\" />\n  <path d=\"M12 7v5l4 2\" />\n  <path d=\"M14 20.775A9 9 0 0 1 12 21\" />\n  <path d=\"M19 17.656a9 9 0 0 1-1.5 1.456\" />\n  <path d=\"M21 12a9 9 0 0 1-.228 2\" />\n  <path d=\"M21 8h-5\" />"),
    SQUARE_CHART_GANTT(
        "square-chart-gantt",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 8h7\" />\n  <path d=\"M8 12h6\" />\n  <path d=\"M11 16h5\" />"),
    SUNRISE(
        "sunrise",
        "<path d=\"M12 2v8\" />\n  <path d=\"m4.93 10.93 1.41 1.41\" />\n  <path d=\"M2 18h2\" />\n  <path d=\"M20 18h2\" />\n  <path d=\"m19.07 10.93-1.41 1.41\" />\n  <path d=\"M22 22H2\" />\n  <path d=\"m8 6 4-4 4 4\" />\n  <path d=\"M16 18a4 4 0 0 0-8 0\" />"),
    TIMELINE(
        "timeline",
        "<path d=\"M4 12h.01\" />\n  <path d=\"M4 16h.01\" />\n  <path d=\"M4 20h.01\" />\n  <path d=\"M4 4h.01\" />\n  <path d=\"M4 8h.01\" />\n  <path d=\"M9.414 13.414a2 2 0 0 0 1.414.586H19a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-8.172a2 2 0 0 0-1.414.586L8 12z\" />\n  <path d=\"M9.414 21.414a2 2 0 0 0 1.414.586H19a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-8.172a2 2 0 0 0-1.414.586L8 20z\" />\n  <path d=\"M9.414 5.414A2 2 0 0 0 10.828 6H19a1 1 0 0 0 1-1V3a1 1 0 0 0-1-1h-8.172a2 2 0 0 0-1.414.586L8 4z\" />"),
    TIMER(
        "timer",
        "<line x1=\"10\" x2=\"14\" y1=\"2\" y2=\"2\" />\n  <line x1=\"12\" x2=\"15\" y1=\"14\" y2=\"11\" />\n  <circle cx=\"12\" cy=\"14\" r=\"8\" />"),
    TIMER_OFF(
        "timer-off",
        "<path d=\"M10 2h4\" />\n  <path d=\"M4.6 11a8 8 0 0 0 1.7 8.7 8 8 0 0 0 8.7 1.7\" />\n  <path d=\"M7.4 7.4a8 8 0 0 1 10.3 1 8 8 0 0 1 .9 10.2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M12 12v-2\" />"),
    TIMER_RESET(
        "timer-reset",
        "<path d=\"M10 2h4\" />\n  <path d=\"M12 14v-4\" />\n  <path d=\"M4 13a8 8 0 0 1 8-7 8 8 0 1 1-5.3 14L4 17.6\" />\n  <path d=\"M9 17H4v5\" />"),
    WATCH(
        "watch",
        "<path d=\"M12 10v2.2l1.6 1\" />\n  <path d=\"m16.13 7.66-.81-4.05a2 2 0 0 0-2-1.61h-2.68a2 2 0 0 0-2 1.61l-.78 4.05\" />\n  <path d=\"m7.88 16.36.8 4a2 2 0 0 0 2 1.61h2.72a2 2 0 0 0 2-1.61l.81-4.05\" />\n  <circle cx=\"12\" cy=\"12\" r=\"6\" />");

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
  default LucideIcon alarm_clock_time() {
    return LucideIcon.create(Icon.ALARM_CLOCK);
  }

  default LucideIcon alarm_clock_check_time() {
    return LucideIcon.create(Icon.ALARM_CLOCK_CHECK);
  }

  default LucideIcon alarm_clock_minus_time() {
    return LucideIcon.create(Icon.ALARM_CLOCK_MINUS);
  }

  default LucideIcon alarm_clock_off_time() {
    return LucideIcon.create(Icon.ALARM_CLOCK_OFF);
  }

  default LucideIcon alarm_clock_plus_time() {
    return LucideIcon.create(Icon.ALARM_CLOCK_PLUS);
  }

  default LucideIcon calendar() {
    return LucideIcon.create(Icon.CALENDAR);
  }

  default LucideIcon calendar_1() {
    return LucideIcon.create(Icon.CALENDAR_1);
  }

  default LucideIcon calendar_arrow_down() {
    return LucideIcon.create(Icon.CALENDAR_ARROW_DOWN);
  }

  default LucideIcon calendar_arrow_up() {
    return LucideIcon.create(Icon.CALENDAR_ARROW_UP);
  }

  default LucideIcon calendar_check() {
    return LucideIcon.create(Icon.CALENDAR_CHECK);
  }

  default LucideIcon calendar_check_2() {
    return LucideIcon.create(Icon.CALENDAR_CHECK_2);
  }

  default LucideIcon calendar_chevrons_left_time() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_LEFT);
  }

  default LucideIcon calendar_chevrons_right_time() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_RIGHT);
  }

  default LucideIcon calendar_clock() {
    return LucideIcon.create(Icon.CALENDAR_CLOCK);
  }

  default LucideIcon calendar_cog() {
    return LucideIcon.create(Icon.CALENDAR_COG);
  }

  default LucideIcon calendar_days() {
    return LucideIcon.create(Icon.CALENDAR_DAYS);
  }

  default LucideIcon calendar_fold_time() {
    return LucideIcon.create(Icon.CALENDAR_FOLD);
  }

  default LucideIcon calendar_heart() {
    return LucideIcon.create(Icon.CALENDAR_HEART);
  }

  default LucideIcon calendar_minus() {
    return LucideIcon.create(Icon.CALENDAR_MINUS);
  }

  default LucideIcon calendar_minus_2() {
    return LucideIcon.create(Icon.CALENDAR_MINUS_2);
  }

  default LucideIcon calendar_off() {
    return LucideIcon.create(Icon.CALENDAR_OFF);
  }

  default LucideIcon calendar_plus() {
    return LucideIcon.create(Icon.CALENDAR_PLUS);
  }

  default LucideIcon calendar_plus_2() {
    return LucideIcon.create(Icon.CALENDAR_PLUS_2);
  }

  default LucideIcon calendar_range() {
    return LucideIcon.create(Icon.CALENDAR_RANGE);
  }

  default LucideIcon calendar_search() {
    return LucideIcon.create(Icon.CALENDAR_SEARCH);
  }

  default LucideIcon calendar_sync_time() {
    return LucideIcon.create(Icon.CALENDAR_SYNC);
  }

  default LucideIcon calendar_x() {
    return LucideIcon.create(Icon.CALENDAR_X);
  }

  default LucideIcon calendar_x_2() {
    return LucideIcon.create(Icon.CALENDAR_X_2);
  }

  default LucideIcon calendars() {
    return LucideIcon.create(Icon.CALENDARS);
  }

  default LucideIcon chart_no_axes_gantt_time() {
    return LucideIcon.create(Icon.CHART_NO_AXES_GANTT);
  }

  default LucideIcon clipboard_clock_time() {
    return LucideIcon.create(Icon.CLIPBOARD_CLOCK);
  }

  default LucideIcon clock() {
    return LucideIcon.create(Icon.CLOCK);
  }

  default LucideIcon clock_1() {
    return LucideIcon.create(Icon.CLOCK_1);
  }

  default LucideIcon clock_10() {
    return LucideIcon.create(Icon.CLOCK_10);
  }

  default LucideIcon clock_11() {
    return LucideIcon.create(Icon.CLOCK_11);
  }

  default LucideIcon clock_12() {
    return LucideIcon.create(Icon.CLOCK_12);
  }

  default LucideIcon clock_2() {
    return LucideIcon.create(Icon.CLOCK_2);
  }

  default LucideIcon clock_3() {
    return LucideIcon.create(Icon.CLOCK_3);
  }

  default LucideIcon clock_4() {
    return LucideIcon.create(Icon.CLOCK_4);
  }

  default LucideIcon clock_5() {
    return LucideIcon.create(Icon.CLOCK_5);
  }

  default LucideIcon clock_6() {
    return LucideIcon.create(Icon.CLOCK_6);
  }

  default LucideIcon clock_7() {
    return LucideIcon.create(Icon.CLOCK_7);
  }

  default LucideIcon clock_8() {
    return LucideIcon.create(Icon.CLOCK_8);
  }

  default LucideIcon clock_9() {
    return LucideIcon.create(Icon.CLOCK_9);
  }

  default LucideIcon clock_alert() {
    return LucideIcon.create(Icon.CLOCK_ALERT);
  }

  default LucideIcon clock_arrow_down() {
    return LucideIcon.create(Icon.CLOCK_ARROW_DOWN);
  }

  default LucideIcon clock_arrow_left() {
    return LucideIcon.create(Icon.CLOCK_ARROW_LEFT);
  }

  default LucideIcon clock_arrow_right_time() {
    return LucideIcon.create(Icon.CLOCK_ARROW_RIGHT);
  }

  default LucideIcon clock_arrow_up() {
    return LucideIcon.create(Icon.CLOCK_ARROW_UP);
  }

  default LucideIcon clock_check() {
    return LucideIcon.create(Icon.CLOCK_CHECK);
  }

  default LucideIcon clock_fading() {
    return LucideIcon.create(Icon.CLOCK_FADING);
  }

  default LucideIcon clock_plus() {
    return LucideIcon.create(Icon.CLOCK_PLUS);
  }

  default LucideIcon file_clock_time() {
    return LucideIcon.create(Icon.FILE_CLOCK);
  }

  default LucideIcon folder_clock_time() {
    return LucideIcon.create(Icon.FOLDER_CLOCK);
  }

  default LucideIcon hourglass_time() {
    return LucideIcon.create(Icon.HOURGLASS);
  }

  default LucideIcon hourglass_cog_time() {
    return LucideIcon.create(Icon.HOURGLASS_COG);
  }

  default LucideIcon list_clock_time() {
    return LucideIcon.create(Icon.LIST_CLOCK);
  }

  default LucideIcon mail_clock_time() {
    return LucideIcon.create(Icon.MAIL_CLOCK);
  }

  default LucideIcon metronome_time() {
    return LucideIcon.create(Icon.METRONOME);
  }

  default LucideIcon rotate_ccw_clock_time() {
    return LucideIcon.create(Icon.ROTATE_CCW_CLOCK);
  }

  default LucideIcon rotate_cw_clock_time() {
    return LucideIcon.create(Icon.ROTATE_CW_CLOCK);
  }

  default LucideIcon rotate_cw_fading_clock() {
    return LucideIcon.create(Icon.ROTATE_CW_FADING_CLOCK);
  }

  default LucideIcon square_chart_gantt_time() {
    return LucideIcon.create(Icon.SQUARE_CHART_GANTT);
  }

  default LucideIcon sunrise_time() {
    return LucideIcon.create(Icon.SUNRISE);
  }

  default LucideIcon timeline() {
    return LucideIcon.create(Icon.TIMELINE);
  }

  default LucideIcon timer() {
    return LucideIcon.create(Icon.TIMER);
  }

  default LucideIcon timer_off() {
    return LucideIcon.create(Icon.TIMER_OFF);
  }

  default LucideIcon timer_reset() {
    return LucideIcon.create(Icon.TIMER_RESET);
  }

  default LucideIcon watch() {
    return LucideIcon.create(Icon.WATCH);
  }
}
