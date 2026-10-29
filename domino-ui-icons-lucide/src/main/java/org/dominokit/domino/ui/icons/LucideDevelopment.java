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

/** Lucide development catalog category. */
public interface LucideDevelopment {
  enum Icon implements LucideIconDefinition {
    AMPERSAND(
        "ampersand",
        "<path d=\"M16 12h3\" />\n  <path d=\"M17.5 12a8 8 0 0 1-8 8A4.5 4.5 0 0 1 5 15.5c0-6 8-4 8-8.5a3 3 0 1 0-6 0c0 3 2.5 8.5 12 13\" />"),
    AMPERSANDS(
        "ampersands",
        "<path d=\"M10 17c-5-3-7-7-7-9a2 2 0 0 1 4 0c0 2.5-5 2.5-5 6 0 1.7 1.3 3 3 3 2.8 0 5-2.2 5-5\" />\n  <path d=\"M22 17c-5-3-7-7-7-9a2 2 0 0 1 4 0c0 2.5-5 2.5-5 6 0 1.7 1.3 3 3 3 2.8 0 5-2.2 5-5\" />"),
    APP_WINDOW(
        "app-window",
        "<rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />\n  <path d=\"M10 4v4\" />\n  <path d=\"M2 8h20\" />\n  <path d=\"M6 4v4\" />"),
    APP_WINDOW_MAC(
        "app-window-mac",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M10 8h.01\" />\n  <path d=\"M14 8h.01\" />"),
    ARROW_BIG_UP(
        "arrow-big-up",
        "<path d=\"M9 19a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1v-6a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-7.086-7.086a1 1 0 0 0-1.414 0l-7.086 7.086a.707.707 0 0 0 .5 1.207H8a1 1 0 0 1 1 1z\" />"),
    ARROW_BIG_UP_DASH(
        "arrow-big-up-dash",
        "<path d=\"M14 16a1 1 0 0 0 1-1v-2a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-6.939-6.939a1.207 1.207 0 0 0-1.708 0l-6.94 6.94a.707.707 0 0 0 .5 1.206H8a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1z\" />\n  <path d=\"M9 20h6\" />"),
    ARROW_DOWN_TO_LINE(
        "arrow-down-to-line",
        "<path d=\"M12 17V3\" />\n  <path d=\"m6 11 6 6 6-6\" />\n  <path d=\"M19 21H5\" />"),
    ARROW_RIGHT_TO_LINE(
        "arrow-right-to-line",
        "<path d=\"M17 12H3\" />\n  <path d=\"m11 18 6-6-6-6\" />\n  <path d=\"M21 5v14\" />"),
    ARROW_UP_FROM_LINE(
        "arrow-up-from-line",
        "<path d=\"m18 9-6-6-6 6\" />\n  <path d=\"M12 3v14\" />\n  <path d=\"M5 21h14\" />"),
    ASTERISK(
        "asterisk",
        "<path d=\"M12 5v14\" />\n  <path d=\"m18.065 8.496-12.125 7\" />\n  <path d=\"m5.94 8.504 12.125 7\" />"),
    BINARY(
        "binary",
        "<rect x=\"14\" y=\"14\" width=\"4\" height=\"6\" rx=\"2\" />\n  <rect x=\"6\" y=\"4\" width=\"4\" height=\"6\" rx=\"2\" />\n  <path d=\"M6 20h4\" />\n  <path d=\"M14 10h4\" />\n  <path d=\"M6 14h2v6\" />\n  <path d=\"M14 4h2v6\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BITCOIN(
        "bitcoin",
        "<path d=\"M11.767 19.089c4.924.868 6.14-6.025 1.216-6.894m-1.216 6.894L5.86 18.047m5.908 1.042-.347 1.97m1.563-8.864c4.924.869 6.14-6.025 1.215-6.893m-1.215 6.893-3.94-.694m5.155-6.2L8.29 4.26m5.908 1.042.348-1.97M7.48 20.364l3.126-17.727\" />"),
    BLEND(
        "blend", "<circle cx=\"15\" cy=\"9\" r=\"7\" />\n  <circle cx=\"9\" cy=\"15\" r=\"7\" />"),
    BLOCKS(
        "blocks",
        "<path d=\"M10 22V7a1 1 0 0 0-1-1H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-5a1 1 0 0 0-1-1H2\" />\n  <rect x=\"14\" y=\"2\" width=\"8\" height=\"8\" rx=\"1\" />"),
    BOOK(
        "book",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BOOK_ALERT(
        "book-alert",
        "<path d=\"M12 13h.01\" />\n  <path d=\"M12 6v3\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BOOK_BOOKMARK(
        "book-bookmark",
        "<path d=\"M10 2v7.751a.25.25 0 00.407.195l2.28-1.834a.5.5 0 01.627 0l2.28 1.834A.25.25 0 0016 9.751V2\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 016.5 2H19a1 1 0 011 1v18a1 1 0 01-1 1H6.5a1 1 0 010-5H20\" />"),
    BOOK_CHECK(
        "book-check",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m9 9.5 2 2 4-4\" />"),
    BOOK_COPY(
        "book-copy",
        "<path d=\"M5 7a2 2 0 0 0-2 2v11\" />\n  <path d=\"M5.803 18H5a2 2 0 0 0 0 4h9.5a.5.5 0 0 0 .5-.5V21\" />\n  <path d=\"M9 15V4a2 2 0 0 1 2-2h9.5a.5.5 0 0 1 .5.5v14a.5.5 0 0 1-.5.5H11a2 2 0 0 1 0-4h10\" />"),
    BOOK_DASHED(
        "book-dashed",
        "<path d=\"M12 17h1.5\" />\n  <path d=\"M12 22h1.5\" />\n  <path d=\"M12 2h1.5\" />\n  <path d=\"M17.5 22H19a1 1 0 0 0 1-1\" />\n  <path d=\"M17.5 2H19a1 1 0 0 1 1 1v1.5\" />\n  <path d=\"M20 14v3h-2.5\" />\n  <path d=\"M20 8.5V10\" />\n  <path d=\"M4 10V8.5\" />\n  <path d=\"M4 19.5V14\" />\n  <path d=\"M4 4.5A2.5 2.5 0 0 1 6.5 2H8\" />\n  <path d=\"M8 22H6.5a1 1 0 0 1 0-5H8\" />"),
    BOOK_DOWN(
        "book-down",
        "<path d=\"M12 13V7\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m9 10 3 3 3-3\" />"),
    BOOK_KEY(
        "book-key",
        "<path d=\"M13 2H6.5A2.5 2.5 0 0 0 4 4.5v15\" />\n  <path d=\"M17 2v6\" />\n  <path d=\"M17 4h2\" />\n  <path d=\"M20 15.2V21a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"17\" cy=\"10\" r=\"2\" />"),
    BOOK_LOCK(
        "book-lock",
        "<path d=\"M18 6V4a2 2 0 1 0-4 0v2\" />\n  <path d=\"M20 15v6a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H10\" />\n  <rect x=\"12\" y=\"6\" width=\"8\" height=\"5\" rx=\"1\" />"),
    BOOK_MINUS(
        "book-minus",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M9 10h6\" />"),
    BOOK_OPEN(
        "book-open",
        "<path d=\"M12 5v16\" />\n  <path d=\"M20.001 19A2 2 0 0022 17V5a2 2 0 00-1.999-2L16 3.002A5 5 0 0012 5a5 5 0 00-4-2H4a2 2 0 00-2 2v12a2 2 0 001.999 2H8a5 5 0 014 2 5 5 0 014-2z\" />"),
    BOOK_OPEN_CHECK(
        "book-open-check",
        "<path d=\"M12 5v16\" />\n  <path d=\"m16 12 2 2 4-4\" />\n  <path d=\"M22 6V5a2 2 0 00-1.999-2L16 3.002A5 5 0 0012 5a5 5 0 00-4-2H4a2 2 0 00-2 2v12a2 2 0 001.999 2H8a5 5 0 014 2 5 5 0 014-2h4.001A2 2 0 0022 17v-1.344\" />"),
    BOOK_OPEN_TEXT(
        "book-open-text",
        "<path d=\"M12 5v16\" />\n  <path d=\"M16 13h2\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M20.001 19A2 2 0 0022 17V5a2 2 0 00-1.999-2L16 3.002A5 5 0 0012 5a5 5 0 00-4-2H4a2 2 0 00-2 2v12a2 2 0 001.999 2H8a5 5 0 014 2 5 5 0 014-2z\" />\n  <path d=\"M6 13h2\" />\n  <path d=\"M6 9h2\" />"),
    BOOK_PLUS(
        "book-plus",
        "<path d=\"M12 7v6\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M9 10h6\" />"),
    BOOK_SEARCH(
        "book-search",
        "<path d=\"M11 22H5.5a1 1 0 0 1 0-5h4.501\" />\n  <path d=\"m21 22-1.879-1.878\" />\n  <path d=\"M3 19.5v-15A2.5 2.5 0 0 1 5.5 2H18a1 1 0 0 1 1 1v8\" />\n  <circle cx=\"17\" cy=\"18\" r=\"3\" />"),
    BOOK_UP(
        "book-up",
        "<path d=\"M12 13V7\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m9 10 3-3 3 3\" />"),
    BOOK_UP_2(
        "book-up-2",
        "<path d=\"M12 13V7\" />\n  <path d=\"M18 2h1a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2\" />\n  <path d=\"m9 10 3-3 3 3\" />\n  <path d=\"m9 5 3-3 3 3\" />"),
    BOT(
        "bot",
        "<path d=\"M12 8V4H8\" />\n  <rect width=\"16\" height=\"12\" x=\"4\" y=\"8\" rx=\"2\" />\n  <path d=\"M2 14h2\" />\n  <path d=\"M20 14h2\" />\n  <path d=\"M15 13v2\" />\n  <path d=\"M9 13v2\" />"),
    BOT_MESSAGE_SQUARE(
        "bot-message-square",
        "<path d=\"M12 6V2H8\" />\n  <path d=\"M15 11v2\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M20 16a2 2 0 0 1-2 2H8.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 4 20.286V8a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2z\" />\n  <path d=\"M9 11v2\" />"),
    BOT_OFF(
        "bot-off",
        "<path d=\"M13.67 8H18a2 2 0 0 1 2 2v4.33\" />\n  <path d=\"M2 14h2\" />\n  <path d=\"M20 14h2\" />\n  <path d=\"M22 22 2 2\" />\n  <path d=\"M8 8H6a2 2 0 0 0-2 2v8a2 2 0 0 0 2 2h12a2 2 0 0 0 1.414-.586\" />\n  <path d=\"M9 13v2\" />\n  <path d=\"M9.67 4H12v2.33\" />"),
    BOX(
        "box",
        "<path d=\"M21 8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16Z\" />\n  <path d=\"m3.3 7 8.7 5 8.7-5\" />\n  <path d=\"M12 22V12\" />"),
    BOXES(
        "boxes",
        "<path d=\"M2.97 12.92A2 2 0 0 0 2 14.63v3.24a2 2 0 0 0 .97 1.71l3 1.8a2 2 0 0 0 2.06 0L12 19v-5.5l-5-3-4.03 2.42Z\" />\n  <path d=\"m7 16.5-4.74-2.85\" />\n  <path d=\"m7 16.5 5-3\" />\n  <path d=\"M7 16.5v5.17\" />\n  <path d=\"M12 13.5V19l3.97 2.38a2 2 0 0 0 2.06 0l3-1.8a2 2 0 0 0 .97-1.71v-3.24a2 2 0 0 0-.97-1.71L17 10.5l-5 3Z\" />\n  <path d=\"m17 16.5-5-3\" />\n  <path d=\"m17 16.5 4.74-2.85\" />\n  <path d=\"M17 16.5v5.17\" />\n  <path d=\"M7.97 4.42A2 2 0 0 0 7 6.13v4.37l5 3 5-3V6.13a2 2 0 0 0-.97-1.71l-3-1.8a2 2 0 0 0-2.06 0l-3 1.8Z\" />\n  <path d=\"M12 8 7.26 5.15\" />\n  <path d=\"m12 8 4.74-2.85\" />\n  <path d=\"M12 13.5V8\" />"),
    BRACES(
        "braces",
        "<path d=\"M8 3H7a2 2 0 0 0-2 2v5a2 2 0 0 1-2 2 2 2 0 0 1 2 2v5c0 1.1.9 2 2 2h1\" />\n  <path d=\"M16 21h1a2 2 0 0 0 2-2v-5c0-1.1.9-2 2-2a2 2 0 0 1-2-2V5a2 2 0 0 0-2-2h-1\" />"),
    BRACKETS(
        "brackets",
        "<path d=\"M16 3h3a1 1 0 0 1 1 1v16a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M8 21H5a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h3\" />"),
    BRAIN_CIRCUIT(
        "brain-circuit",
        "<path d=\"M12 13h4\" />\n  <path d=\"M12 18h6a2 2 0 012 2v1\" />\n  <path d=\"M12 8h8\" />\n  <path d=\"M12 9a4.17 4.17 0 01-3 4\" />\n  <path d=\"M16 8V5a2 2 0 012-2\" />\n  <path d=\"M6 18a4 4 0 01-2-7.465\" />\n  <path d=\"M6.004 5.125a4 4 0 00-2.526 5.77\" />\n  <path d=\"M6.294 6.294A3 3 0 1112 5v13a4 4 0 11-7.967-.518\" />\n  <circle cx=\"16\" cy=\"13\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"18\" cy=\"3\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"20\" cy=\"21\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"20\" cy=\"8\" r=\"0.5\" fill=\"currentColor\" />"),
    BRAIN_COG(
        "brain-cog",
        "<path d=\"m10.852 14.772-.383.923\" />\n  <path d=\"m10.852 9.228-.383-.923\" />\n  <path d=\"m13.148 14.772.382.924\" />\n  <path d=\"m13.53 8.305-.382.923\" />\n  <path d=\"m14.772 10.852.923-.383\" />\n  <path d=\"m14.772 13.148.923.383\" />\n  <path d=\"M17.997 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M18 18a4 4 0 002-7.464\" />\n  <path d=\"M4.033 17.483A4 4 0 0011.46 20c.184-.31.896-.31 1.076 0a4 4 0 007.43-2.517\" />\n  <path d=\"M6 18a4 4 0 01-2-7.464\" />\n  <path d=\"M6.002 5.125a4 4 0 00-2.525 5.77\" />\n  <path d=\"M6.293 6.294a3 3 0 01-.287-1.098l-.004-.07a3 3 0 015.968-.543c.05.02.057.01.059 0a3 3 0 015.968.542l-.004.071a3 3 0 01-.287 1.098\" />\n  <path d=\"m9.228 10.852-.923-.383\" />\n  <path d=\"m9.228 13.148-.923.383\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    BRAIN_OFF(
        "brain-off",
        "<path d=\"M12 18v-6\" />\n  <path d=\"M12 5v1.344\" />\n  <path d=\"M17.707 6.293A3 3 0 1012 5a3 3 0 00-4.124-2.781\" />\n  <path d=\"M17.997 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M19.644 19.644A4 4 0 0112 18a4 4 0 11-7.967-.517\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 10.536a4 4 0 011.533 5.34\" />\n  <path d=\"M3.477 10.895a4 4 0 011.876-5.542\" />\n  <path d=\"M6 18a4 4 0 01-2-7.464\" />\n  <path d=\"M9 13a4.17 4.17 0 002.166-1.5 4 4 0 00.138-.196\" />"),
    BUG(
        "bug",
        "<path d=\"M12 20v-9\" />\n  <path d=\"M14 7a4 4 0 0 1 4 4v3a6 6 0 0 1-12 0v-3a4 4 0 0 1 4-4z\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M21 21a4 4 0 0 0-3.81-4\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M22 13h-4\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9 7.13V6a3 3 0 1 1 6 0v1.13\" />"),
    BUG_OFF(
        "bug-off",
        "<path d=\"M12 20v-8\" />\n  <path d=\"M12.656 7H14a4 4 0 0 1 4 4v1.344\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M17.123 17.123A6 6 0 0 1 6 14v-3a4 4 0 0 1 1.72-3.287\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M22 13h-3.344\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9.712 4.06A3 3 0 0 1 15 6v1.13\" />"),
    BUG_PLAY(
        "bug-play",
        "<path d=\"M10 19.655A6 6 0 0 1 6 14v-3a4 4 0 0 1 4-4h4a4 4 0 0 1 4 3.97\" />\n  <path d=\"M14 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9 7.13V6a3 3 0 1 1 6 0v1.13\" />"),
    CASE_LOWER(
        "case-lower",
        "<path d=\"M10 9v7\" />\n  <path d=\"M14 6v10\" />\n  <circle cx=\"17.5\" cy=\"12.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"12.5\" r=\"3.5\" />"),
    CASE_UPPER(
        "case-upper",
        "<path d=\"M15 11h4.5a1 1 0 0 1 0 5h-4a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h3a1 1 0 0 1 0 5\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    CHART_NO_AXES_GANTT(
        "chart-no-axes-gantt",
        "<path d=\"M6 5h12\" />\n  <path d=\"M4 12h10\" />\n  <path d=\"M12 19h8\" />"),
    CHEVRON_RIGHT("chevron-right", "<path d=\"m9 18 6-6-6-6\" />"),
    CIRCLE_ARROW_OUT_UP_LEFT(
        "circle-arrow-out-up-left",
        "<path d=\"M2 8V2h6\" />\n  <path d=\"m2 2 10 10\" />\n  <path d=\"M12 2A10 10 0 1 1 2 12\" />"),
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
    CIRCLE_ELLIPSIS(
        "circle-ellipsis",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M17 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M7 12h.01\" />"),
    CIRCLE_FADING_ARROW_UP(
        "circle-fading-arrow-up",
        "<path d=\"M12 2a10 10 0 0 1 7.38 16.75\" />\n  <path d=\"m16 12-4-4-4 4\" />\n  <path d=\"M12 16V8\" />\n  <path d=\"M2.5 8.875a10 10 0 0 0-.5 3\" />\n  <path d=\"M2.83 16a10 10 0 0 0 2.43 3.4\" />\n  <path d=\"M4.636 5.235a10 10 0 0 1 .891-.857\" />\n  <path d=\"M8.644 21.42a10 10 0 0 0 7.631-.38\" />"),
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
    CIRCUIT_BOARD(
        "circuit-board",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M11 9h4a2 2 0 0 0 2-2V3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"M7 21v-4a2 2 0 0 1 2-2h4\" />\n  <circle cx=\"15\" cy=\"15\" r=\"2\" />"),
    CLOUD_ALERT(
        "cloud-alert",
        "<path d=\"M12 12v4\" />\n  <path d=\"M12 20h.01\" />\n  <path d=\"M8.128 16.949A7 7 0 1 1 15.71 8h1.79a1 1 0 0 1 0 9h-1.642\" />"),
    CLOUD_CHECK(
        "cloud-check",
        "<path d=\"m17 15-5.5 5.5L9 18\" />\n  <path d=\"M5.516 16.07A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 3.501 7.327\" />"),
    CLOUD_COG(
        "cloud-cog",
        "<path d=\"m10.852 19.772-.383.924\" />\n  <path d=\"m13.148 14.228.383-.923\" />\n  <path d=\"M13.148 19.772a3 3 0 1 0-2.296-5.544l-.383-.923\" />\n  <path d=\"m13.53 20.696-.382-.924a3 3 0 1 1-2.296-5.544\" />\n  <path d=\"m14.772 15.852.923-.383\" />\n  <path d=\"m14.772 18.148.923.383\" />\n  <path d=\"M4.2 15.1a7 7 0 1 1 9.93-9.858A7 7 0 0 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.2\" />\n  <path d=\"m9.228 15.852-.923-.383\" />\n  <path d=\"m9.228 18.148-.923.383\" />"),
    CODE("code", "<path d=\"m16 18 6-6-6-6\" />\n  <path d=\"m8 6-6 6 6 6\" />"),
    CODE_XML(
        "code-xml",
        "<path d=\"m18 16 4-4-4-4\" />\n  <path d=\"m6 8-4 4 4 4\" />\n  <path d=\"m14.5 4-5 16\" />"),
    COMBINE(
        "combine",
        "<path d=\"M14 3a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"M19 3a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"m7 15 3 3\" />\n  <path d=\"m7 21 3-3H5a2 2 0 0 1-2-2v-2\" />\n  <rect x=\"14\" y=\"14\" width=\"7\" height=\"7\" rx=\"1\" />\n  <rect x=\"3\" y=\"3\" width=\"7\" height=\"7\" rx=\"1\" />"),
    COMMAND(
        "command",
        "<path d=\"M15 6v12a3 3 0 1 0 3-3H6a3 3 0 1 0 3 3V6a3 3 0 1 0-3 3h12a3 3 0 1 0-3-3\" />"),
    COMPONENT(
        "component",
        "<path d=\"M15.536 11.293a1 1 0 0 0 0 1.414l2.376 2.377a1 1 0 0 0 1.414 0l2.377-2.377a1 1 0 0 0 0-1.414l-2.377-2.377a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M2.297 11.293a1 1 0 0 0 0 1.414l2.377 2.377a1 1 0 0 0 1.414 0l2.377-2.377a1 1 0 0 0 0-1.414L6.088 8.916a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M8.916 17.912a1 1 0 0 0 0 1.415l2.377 2.376a1 1 0 0 0 1.414 0l2.377-2.376a1 1 0 0 0 0-1.415l-2.377-2.376a1 1 0 0 0-1.414 0z\" />\n  <path d=\"M8.916 4.674a1 1 0 0 0 0 1.414l2.377 2.376a1 1 0 0 0 1.414 0l2.377-2.376a1 1 0 0 0 0-1.414l-2.377-2.377a1 1 0 0 0-1.414 0z\" />"),
    COMPUTER(
        "computer",
        "<path d=\"M12 18h6\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M8 6h1\" />\n  <rect x=\"2\" y=\"14\" width=\"20\" height=\"8\" rx=\"2\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"12\" rx=\"2\" />"),
    CONSTRUCTION(
        "construction",
        "<rect x=\"2\" y=\"6\" width=\"20\" height=\"8\" rx=\"1\" />\n  <path d=\"M17 14v7\" />\n  <path d=\"M7 14v7\" />\n  <path d=\"M17 3v3\" />\n  <path d=\"M7 3v3\" />\n  <path d=\"M10 14 2.3 6.3\" />\n  <path d=\"m14 6 7.7 7.7\" />\n  <path d=\"m8 6 8 8\" />"),
    CONTAINER(
        "container",
        "<path d=\"M22 7.7c0-.6-.4-1.2-.8-1.5l-6.3-3.9a1.72 1.72 0 0 0-1.7 0l-10.3 6c-.5.2-.9.8-.9 1.4v6.6c0 .5.4 1.2.8 1.5l6.3 3.9a1.72 1.72 0 0 0 1.7 0l10.3-6c.5-.3.9-1 .9-1.5Z\" />\n  <path d=\"M10 21.9V14L2.1 9.1\" />\n  <path d=\"m10 14 11.9-6.9\" />\n  <path d=\"M14 19.8v-8.1\" />\n  <path d=\"M18 17.5V9.4\" />"),
    COPY_SLASH(
        "copy-slash",
        "<line x1=\"12\" x2=\"18\" y1=\"18\" y2=\"12\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    CORNER_DOWN_RIGHT(
        "corner-down-right",
        "<path d=\"m15 10 5 5-5 5\" />\n  <path d=\"M4 4v7a4 4 0 0 0 4 4h12\" />"),
    CPU_AI(
        "cpu-ai",
        "<path d=\"M12 20v2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M16 9v6\" />\n  <path d=\"M17 20v2\" />\n  <path d=\"M17 2v2\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M2 17h2\" />\n  <path d=\"M2 7h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M20 7h2\" />\n  <path d=\"M7 20v2\" />\n  <path d=\"M7 2v2\" />\n  <path d=\"M8 13h4\" />\n  <path d=\"M8 15v-4a2 2 0 014 0v4\" />\n  <rect x=\"4\" y=\"4\" width=\"16\" height=\"16\" rx=\"2\" />"),
    DATABASE(
        "database",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5V19A9 3 0 0 0 21 19V5\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />"),
    DATABASE_ARROW_DOWN(
        "database-arrow-down",
        "<path d=\"m16 19 3 3 3-3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"M3 12A9 3 0 0 0 15.182 14.806\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_ARROW_UP(
        "database-arrow-up",
        "<path d=\"M19 22v-6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"m22 19-3-3-3 3\" />\n  <path d=\"M3 12A9 3 0 0 0 14.457 14.886\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_BACKUP(
        "database-backup",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 12a9 3 0 0 0 5 2.69\" />\n  <path d=\"M21 9.3V5\" />\n  <path d=\"M3 5v14a9 3 0 0 0 6.47 2.88\" />\n  <path d=\"M12 12v4h4\" />\n  <path d=\"M13 20a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L12 16\" />"),
    DATABASE_CHECK(
        "database-check",
        "<path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M21 13.127V5\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_MINUS(
        "database-minus",
        "<path d=\"M21 15V5\" />\n  <path d=\"M22 19h-6\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_PLUS(
        "database-plus",
        "<path d=\"M19 16v6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"M22 19h-6\" />\n  <path d=\"M3 12A9 3 0 0 0 15.1824 14.8061\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_SEARCH(
        "database-search",
        "<path d=\"M21 11.693V5\" />\n  <path d=\"m22 22-1.875-1.875\" />\n  <path d=\"M3 12a9 3 0 0 0 8.697 2.998\" />\n  <path d=\"M3 5v14a9 3 0 0 0 9.28 2.999\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_X(
        "database-x",
        "<path d=\"m17 17 5 5\" />\n  <path d=\"M19.323 13.744A9 3 0 0 0 21 12\" />\n  <path d=\"M21 13.127V5\" />\n  <path d=\"m22 17-5 5\" />\n  <path d=\"M3 12A9 3 0 0 0 13.563 14.954\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13 21.981\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_ZAP(
        "database-zap",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5V19A9 3 0 0 0 15 21.84\" />\n  <path d=\"M21 5V8\" />\n  <path d=\"M21 12L18 17H22L19 22\" />\n  <path d=\"M3 12A9 3 0 0 0 14.59 14.87\" />"),
    DIFF("diff", "<path d=\"M12 3v14\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M5 21h14\" />"),
    DIVIDE(
        "divide",
        "<circle cx=\"12\" cy=\"6\" r=\"1\" />\n  <line x1=\"5\" x2=\"19\" y1=\"12\" y2=\"12\" />\n  <circle cx=\"12\" cy=\"18\" r=\"1\" />"),
    DOCK(
        "dock",
        "<path d=\"M2 8h20\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 16h12\" />"),
    EARTH_LOCK(
        "earth-lock",
        "<path d=\"M7 3.34V5a3 3 0 0 0 3 3\" />\n  <path d=\"M11 21.95V18a2 2 0 0 0-2-2 2 2 0 0 1-2-2v-1a2 2 0 0 0-2-2H2.05\" />\n  <path d=\"M21.54 15H17a2 2 0 0 0-2 2v4.54\" />\n  <path d=\"M12 2a10 10 0 1 0 9.54 13\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    ECLIPSE(
        "eclipse",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 2a7 7 0 1 0 10 10\" />"),
    ELLIPSIS(
        "ellipsis",
        "<circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <circle cx=\"19\" cy=\"12\" r=\"1\" />\n  <circle cx=\"5\" cy=\"12\" r=\"1\" />"),
    EQUAL(
        "equal",
        "<line x1=\"5\" x2=\"19\" y1=\"9\" y2=\"9\" />\n  <line x1=\"5\" x2=\"19\" y1=\"15\" y2=\"15\" />"),
    EQUAL_APPROXIMATELY_NOT(
        "equal-approximately-not",
        "<path d=\"M5 15a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <path d=\"M5 9a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    EQUAL_NOT(
        "equal-not",
        "<line x1=\"5\" x2=\"19\" y1=\"9\" y2=\"9\" />\n  <line x1=\"5\" x2=\"19\" y1=\"15\" y2=\"15\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    FILE_BOX(
        "file-box",
        "<path d=\"M14 2v5a1 1 0 001 1h5\" />\n  <path d=\"M14.692 22H18a2 2 0 002-2V8a2.4 2.4 0 00-.706-1.706l-3.588-3.588A2.4 2.4 0 0014 2H6a2 2 0 00-2 2v3.804\" />\n  <path d=\"M2.264 13.752 7 16.5l4.737-2.748\" />\n  <path d=\"M2.995 13.014A2 2 0 002 14.744v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0012 18.26v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />\n  <path d=\"M7 16.5V22\" />"),
    FILE_BRACES(
        "file-braces",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 12a1 1 0 0 0-1 1v1a1 1 0 0 1-1 1 1 1 0 0 1 1 1v1a1 1 0 0 0 1 1\" />\n  <path d=\"M14 18a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1 1 1 0 0 1-1-1v-1a1 1 0 0 0-1-1\" />"),
    FILE_BRACES_CORNER(
        "file-braces-corner",
        "<path d=\"M14 22h4a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v6\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M5 14a1 1 0 0 0-1 1v2a1 1 0 0 1-1 1 1 1 0 0 1 1 1v2a1 1 0 0 0 1 1\" />\n  <path d=\"M9 22a1 1 0 0 0 1-1v-2a1 1 0 0 1 1-1 1 1 0 0 1-1-1v-2a1 1 0 0 0-1-1\" />"),
    FILE_CODE(
        "file-code",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 12.5 8 15l2 2.5\" />\n  <path d=\"m14 12.5 2 2.5-2 2.5\" />"),
    FILE_CODE_CORNER(
        "file-code-corner",
        "<path d=\"M4 12.15V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-3.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m5 16-3 3 3 3\" />\n  <path d=\"m9 22 3-3-3-3\" />"),
    FILE_DIFF(
        "file-diff",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M12 13V7\" />\n  <path d=\"M9 17h6\" />"),
    FILE_DIGIT(
        "file-digit",
        "<path d=\"M4 12V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 16h2v6\" />\n  <path d=\"M10 22h4\" />\n  <rect x=\"2\" y=\"16\" width=\"4\" height=\"6\" rx=\"2\" />"),
    FILE_SLIDERS(
        "file-sliders",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M10 11v2\" />\n  <path d=\"M8 17h8\" />\n  <path d=\"M14 16v2\" />"),
    FILE_STACK(
        "file-stack",
        "<path d=\"M11 21a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-8a1 1 0 0 1 1-1\" />\n  <path d=\"M16 16a1 1 0 0 1-1 1H9a1 1 0 0 1-1-1V8a1 1 0 0 1 1-1\" />\n  <path d=\"M21 6a2 2 0 0 0-.586-1.414l-2-2A2 2 0 0 0 17 2h-3a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1z\" />"),
    FILE_TERMINAL(
        "file-terminal",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m8 16 2-2-2-2\" />\n  <path d=\"M12 18h4\" />"),
    FLAG_TRIANGLE_LEFT(
        "flag-triangle-left",
        "<path d=\"M18 22V2.8a.8.8 0 0 0-1.17-.71L5.45 7.78a.8.8 0 0 0 0 1.44L18 15.5\" />"),
    FLAG_TRIANGLE_RIGHT(
        "flag-triangle-right",
        "<path d=\"M6 22V2.8a.8.8 0 0 1 1.17-.71l11.38 5.69a.8.8 0 0 1 0 1.44L6 15.5\" />"),
    FOLDER_CODE(
        "folder-code",
        "<path d=\"M10 10.5 8 13l2 2.5\" />\n  <path d=\"m14 10.5 2 2.5-2 2.5\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2z\" />"),
    FOLDER_DOT(
        "folder-dot",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"1\" />"),
    FOLDER_KANBAN(
        "folder-kanban",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <path d=\"M8 10v4\" />\n  <path d=\"M12 10v2\" />\n  <path d=\"M16 10v6\" />"),
    FOLDER_OPEN_DOT(
        "folder-open-dot",
        "<path d=\"m6 14 1.45-2.9A2 2 0 0 1 9.24 10H20a2 2 0 0 1 1.94 2.5l-1.55 6a2 2 0 0 1-1.94 1.5H4a2 2 0 0 1-2-2V5c0-1.1.9-2 2-2h3.93a2 2 0 0 1 1.66.9l.82 1.2a2 2 0 0 0 1.66.9H18a2 2 0 0 1 2 2v2\" />\n  <circle cx=\"14\" cy=\"15\" r=\"1\" />"),
    FOLDER_ROOT(
        "folder-root",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"2\" />\n  <path d=\"M12 15v5\" />"),
    FORM(
        "form",
        "<path d=\"M4 14h6\" />\n  <path d=\"M4 2h10\" />\n  <rect x=\"4\" y=\"18\" width=\"16\" height=\"4\" rx=\"1\" />\n  <rect x=\"4\" y=\"6\" width=\"16\" height=\"4\" rx=\"1\" />"),
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
    GEM(
        "gem",
        "<path d=\"M10.5 3 8 9l4 13 4-13-2.5-6\" />\n  <path d=\"M17 3a2 2 0 0 1 1.6.8l3 4a2 2 0 0 1 .013 2.382l-7.99 10.986a2 2 0 0 1-3.247 0l-7.99-10.986A2 2 0 0 1 2.4 7.8l2.998-3.997A2 2 0 0 1 7 3z\" />\n  <path d=\"M2 9h20\" />"),
    GIT_BRANCH(
        "git-branch",
        "<path d=\"M15 6a9 9 0 0 0-9 9V3\" />\n  <circle cx=\"18\" cy=\"6\" r=\"3\" />\n  <circle cx=\"6\" cy=\"18\" r=\"3\" />"),
    GIT_BRANCH_MINUS(
        "git-branch-minus",
        "<path d=\"M15 6a9 9 0 0 0-9 9V3\" />\n  <path d=\"M21 18h-6\" />\n  <circle cx=\"18\" cy=\"6\" r=\"3\" />\n  <circle cx=\"6\" cy=\"18\" r=\"3\" />"),
    GIT_BRANCH_PLUS(
        "git-branch-plus",
        "<path d=\"M6 3v12\" />\n  <path d=\"M18 9a3 3 0 1 0 0-6 3 3 0 0 0 0 6z\" />\n  <path d=\"M6 21a3 3 0 1 0 0-6 3 3 0 0 0 0 6z\" />\n  <path d=\"M15 6a9 9 0 0 0-9 9\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M21 18h-6\" />"),
    GIT_COMMIT_HORIZONTAL(
        "git-commit-horizontal",
        "<circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <line x1=\"3\" x2=\"9\" y1=\"12\" y2=\"12\" />\n  <line x1=\"15\" x2=\"21\" y1=\"12\" y2=\"12\" />"),
    GIT_COMMIT_VERTICAL(
        "git-commit-vertical",
        "<path d=\"M12 3v6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"M12 15v6\" />"),
    GIT_COMPARE(
        "git-compare",
        "<circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M13 6h3a2 2 0 0 1 2 2v7\" />\n  <path d=\"M11 18H8a2 2 0 0 1-2-2V9\" />"),
    GIT_COMPARE_ARROWS(
        "git-compare-arrows",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v7\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <circle cx=\"19\" cy=\"18\" r=\"3\" />\n  <path d=\"M12 18H7a2 2 0 0 1-2-2V9\" />\n  <path d=\"m9 15 3 3-3 3\" />"),
    GIT_FORK(
        "git-fork",
        "<circle cx=\"12\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <circle cx=\"18\" cy=\"6\" r=\"3\" />\n  <path d=\"M18 9v2c0 .6-.4 1-1 1H7c-.6 0-1-.4-1-1V9\" />\n  <path d=\"M12 12v3\" />"),
    GIT_GRAPH(
        "git-graph",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M5 9v6\" />\n  <circle cx=\"5\" cy=\"18\" r=\"3\" />\n  <path d=\"M12 3v18\" />\n  <circle cx=\"19\" cy=\"6\" r=\"3\" />\n  <path d=\"M16 15.7A9 9 0 0 0 19 9\" />"),
    GIT_MERGE(
        "git-merge",
        "<circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M6 21V9a9 9 0 0 0 9 9\" />"),
    GIT_MERGE_CONFLICT(
        "git-merge-conflict",
        "<path d=\"M12 6h4a2 2 0 0 1 2 2v7\" />\n  <path d=\"M6 12v9\" />\n  <path d=\"m8.5 3.5-5 5\" />\n  <path d=\"m8.5 8.5-5-5\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    GIT_PULL_REQUEST(
        "git-pull-request",
        "<circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M13 6h3a2 2 0 0 1 2 2v7\" />\n  <line x1=\"6\" x2=\"6\" y1=\"9\" y2=\"21\" />"),
    GIT_PULL_REQUEST_ARROW(
        "git-pull-request-arrow",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M5 9v12\" />\n  <circle cx=\"19\" cy=\"18\" r=\"3\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v7\" />"),
    GIT_PULL_REQUEST_CLOSED(
        "git-pull-request-closed",
        "<path d=\"m15.5 3.5 5 5\" />\n  <path d=\"m15.5 8.5 5-5\" />\n  <path d=\"M18 11.62V15\" />\n  <path d=\"M6 9v12\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />"),
    GIT_PULL_REQUEST_CREATE(
        "git-pull-request-create",
        "<circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M6 9v12\" />\n  <path d=\"M13 6h3a2 2 0 0 1 2 2v3\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M21 18h-6\" />"),
    GIT_PULL_REQUEST_CREATE_ARROW(
        "git-pull-request-create-arrow",
        "<circle cx=\"5\" cy=\"6\" r=\"3\" />\n  <path d=\"M5 9v12\" />\n  <path d=\"m15 9-3-3 3-3\" />\n  <path d=\"M12 6h5a2 2 0 0 1 2 2v3\" />\n  <path d=\"M19 15v6\" />\n  <path d=\"M22 18h-6\" />"),
    GIT_PULL_REQUEST_DRAFT(
        "git-pull-request-draft",
        "<circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M18 6V5\" />\n  <path d=\"M18 11v-1\" />\n  <line x1=\"6\" x2=\"6\" y1=\"9\" y2=\"21\" />"),
    GLOBE_CODE(
        "globe-code",
        "<path d=\"M15.5 10 13 7.5 15.5 5\" />\n  <path d=\"M15.861 14A14.5 14.5 0 0112 22a14.48 14.48 0 010-20 10 10 0 109.888 11.5\" />\n  <path d=\"M19.5 5 22 7.5 19.5 10\" />\n  <path d=\"M2 12h8.5\" />"),
    GLOBE_LOCK(
        "globe-lock",
        "<path d=\"M15.686 15A14.5 14.5 0 0 1 12 22a14.5 14.5 0 0 1 0-20 10 10 0 1 0 9.542 13\" />\n  <path d=\"M2 12h8.5\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    GRAPH_HUB(
        "graph-hub",
        "<circle cx=\"12\" cy=\"7\" r=\"4\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />\n  <circle cx=\"12\" cy=\"19\" r=\"2\" />\n  <circle cx=\"20\" cy=\"19\" r=\"2\" />\n  <path d=\"M8 7a4 4 0 0 0-4 4v6\" />\n  <path d=\"M12 11v6\" />\n  <path d=\"M16 7a4 4 0 0 1 4 4v6\" />"),
    GRAPH_STAR(
        "graph-star",
        "<path d=\"m12.342 9.316 1.764-3.527\" />\n  <path d=\"m12.59 14.545 2.35 3.759\" />\n  <path d=\"m13.982 12.332 4.03.447\" />\n  <path d=\"M5.414 17.586 8.88 14.12\" />\n  <path d=\"M9.025 9.742 5.317 5.505\" />\n  <circle cx=\"11\" cy=\"12\" r=\"3\" />\n  <circle cx=\"15\" cy=\"4\" r=\"2\" />\n  <circle cx=\"16\" cy=\"20\" r=\"2\" />\n  <circle cx=\"20\" cy=\"13\" r=\"2\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />\n  <circle cx=\"4\" cy=\"4\" r=\"2\" />"),
    HARD_DRIVE(
        "hard-drive",
        "<path d=\"M10 16h.01\" />\n  <path d=\"M2.212 11.577a2 2 0 0 0-.212.896V18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-5.527a2 2 0 0 0-.212-.896L18.55 5.11A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z\" />\n  <path d=\"M21.946 12.013H2.054\" />\n  <path d=\"M6 16h.01\" />"),
    HARD_DRIVE_DOWNLOAD(
        "hard-drive-download",
        "<path d=\"M12 2v8\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HARD_DRIVE_UPLOAD(
        "hard-drive-upload",
        "<path d=\"m16 6-4-4-4 4\" />\n  <path d=\"M12 2v8\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HEXAGON(
        "hexagon",
        "<path d=\"M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z\" />"),
    KANBAN("kanban", "<path d=\"M5 3v14\" />\n  <path d=\"M12 3v8\" />\n  <path d=\"M19 3v18\" />"),
    KEYBOARD(
        "keyboard",
        "<path d=\"M10 8h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M7 16h10\" />\n  <path d=\"M8 12h.01\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />"),
    KEYBOARD_OFF(
        "keyboard-off",
        "<path d=\"M 20 4 A2 2 0 0 1 22 6\" />\n  <path d=\"M 22 6 L 22 16.41\" />\n  <path d=\"M 7 16 L 16 16\" />\n  <path d=\"M 9.69 4 L 20 4\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M8 12h.01\" />"),
    LAMBDA(
        "lambda",
        "<path d=\"M11.38 10 5 20\" />\n  <path d=\"M19 18a2 2 0 01-2 2c-4.87-.003-5.052-16-10-16a2 2 0 00-2 2\" />"),
    LIBRARY(
        "library",
        "<path d=\"m16 6 4 14\" />\n  <path d=\"M12 6v14\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M4 4v16\" />"),
    LIBRARY_BIG(
        "library-big",
        "<rect width=\"8\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M20.4 18.9c.2.5-.1 1.1-.6 1.3l-1.9.7c-.5.2-1.1-.1-1.3-.6L11.1 5.1c-.2-.5.1-1.1.6-1.3l1.9-.7c.5-.2 1.1.1 1.3.6Z\" />"),
    LINE_DOT_BOTTOM_VERTICAL(
        "line-dot-bottom-vertical",
        "<path d=\"M12 3v12\" />\n  <circle cx=\"12\" cy=\"18\" r=\"3\" />"),
    LINE_DOT_LEFT_HORIZONTAL(
        "line-dot-left-horizontal",
        "<path d=\"M9 12h12\" />\n  <circle cx=\"6\" cy=\"12\" r=\"3\" />"),
    LINE_DOT_RIGHT_HORIZONTAL(
        "line-dot-right-horizontal",
        "<path d=\"M 3 12 L 15 12\" />\n  <circle cx=\"18\" cy=\"12\" r=\"3\" />"),
    LINE_DOT_TOP_VERTICAL(
        "line-dot-top-vertical",
        "<path d=\"M12 9v12\" />\n  <circle cx=\"12\" cy=\"6\" r=\"3\" />"),
    LIST_INDENT_DECREASE(
        "list-indent-decrease",
        "<path d=\"M21 5H11\" />\n  <path d=\"M21 12H11\" />\n  <path d=\"M21 19H11\" />\n  <path d=\"m7 8-4 4 4 4\" />"),
    LIST_INDENT_INCREASE(
        "list-indent-increase",
        "<path d=\"M21 5H11\" />\n  <path d=\"M21 12H11\" />\n  <path d=\"M21 19H11\" />\n  <path d=\"m3 8 4 4-4 4\" />"),
    MERGE(
        "merge",
        "<path d=\"m8 6 4-4 4 4\" />\n  <path d=\"M12 2v10.3a4 4 0 0 1-1.172 2.872L4 22\" />\n  <path d=\"m20 22-5-5\" />"),
    MESSAGE_CIRCLE_CODE(
        "message-circle-code",
        "<path d=\"m10 9-3 3 3 3\" />\n  <path d=\"m14 15 3-3-3-3\" />\n  <path d=\"M2.992 16.342a2 2 0 0 1 .094 1.167l-1.065 3.29a1 1 0 0 0 1.236 1.168l3.413-.998a2 2 0 0 1 1.099.092 10 10 0 1 0-4.777-4.719\" />"),
    MESSAGE_SQUARE_CODE(
        "message-square-code",
        "<path d=\"M22 17a2 2 0 0 1-2 2H6.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 2 21.286V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2z\" />\n  <path d=\"m10 8-3 3 3 3\" />\n  <path d=\"m14 14 3-3-3-3\" />"),
    MESSAGE_SQUARE_DIFF(
        "message-square-diff",
        "<path d=\"M22 17a2 2 0 0 1-2 2H6.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 2 21.286V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2z\" />\n  <path d=\"M10 15h4\" />\n  <path d=\"M10 9h4\" />\n  <path d=\"M12 7v4\" />"),
    MILESTONE(
        "milestone",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M18.172 6a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H4a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1z\" />"),
    MINUS("minus", "<path d=\"M5 12h14\" />"),
    MONITOR_CLOUD(
        "monitor-cloud",
        "<path d=\"M11 13a3 3 0 1 1 2.83-4H14a2 2 0 0 1 0 4z\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />"),
    MONITOR_PC(
        "monitor-pc",
        "<path d=\"M10 15H4a2 2 0 01-2-2V7a2 2 0 012-2h6\" />\n  <path d=\"M10 19H5\" />\n  <path d=\"M14 11h8\" />\n  <path d=\"M14 7h8\" />\n  <path d=\"M18 17h.01\" />\n  <path d=\"M9 19v-4\" />\n  <rect x=\"14\" y=\"3\" width=\"8\" height=\"18\" rx=\"1\" />"),
    NETWORK(
        "network",
        "<rect x=\"16\" y=\"16\" width=\"6\" height=\"6\" rx=\"1\" />\n  <rect x=\"2\" y=\"16\" width=\"6\" height=\"6\" rx=\"1\" />\n  <rect x=\"9\" y=\"2\" width=\"6\" height=\"6\" rx=\"1\" />\n  <path d=\"M5 16v-3a1 1 0 0 1 1-1h12a1 1 0 0 1 1 1v3\" />\n  <path d=\"M12 12V8\" />"),
    OMEGA(
        "omega",
        "<path d=\"M3 20h4.5a.5.5 0 0 0 .5-.5v-.282a.52.52 0 0 0-.247-.437 8 8 0 1 1 8.494-.001.52.52 0 0 0-.247.438v.282a.5.5 0 0 0 .5.5H21\" />"),
    OPTION(
        "option",
        "<path d=\"M14 3h7\" />\n  <path d=\"M3 3h5.28a1 1 0 0 1 .948.684l5.544 16.632a1 1 0 0 0 .949.684H21\" />"),
    PACKAGE(
        "package",
        "<path d=\"M11 21.73a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73z\" />\n  <path d=\"M12 22V12\" />\n  <polyline points=\"3.29 7 12 12 20.71 7\" />\n  <path d=\"m7.5 4.27 9 5.15\" />"),
    PACKAGE_2(
        "package-2",
        "<path d=\"M12 3v6\" />\n  <path d=\"M16.76 3a2 2 0 0 1 1.8 1.1l2.23 4.479a2 2 0 0 1 .21.891V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9.472a2 2 0 0 1 .211-.894L5.45 4.1A2 2 0 0 1 7.24 3z\" />\n  <path d=\"M3.054 9.013h17.893\" />"),
    PACKAGE_CHECK(
        "package-check",
        "<path d=\"M12 22V12\" />\n  <path d=\"m16 17 2 2 4-4\" />\n  <path d=\"M21 11.127V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l1.32-.753\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />"),
    PACKAGE_MINUS(
        "package-minus",
        "<path d=\"M12 22V12\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M21 13V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l1.675-.955\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />"),
    PACKAGE_OPEN(
        "package-open",
        "<path d=\"M12 22v-9\" />\n  <path d=\"M15.17 2.21a1.67 1.67 0 0 1 1.63 0L21 4.57a1.93 1.93 0 0 1 0 3.36L8.82 14.79a1.655 1.655 0 0 1-1.64 0L3 12.43a1.93 1.93 0 0 1 0-3.36z\" />\n  <path d=\"M20 13v3.87a2.06 2.06 0 0 1-1.11 1.83l-6 3.08a1.93 1.93 0 0 1-1.78 0l-6-3.08A2.06 2.06 0 0 1 4 16.87V13\" />\n  <path d=\"M21 12.43a1.93 1.93 0 0 0 0-3.36L8.83 2.2a1.64 1.64 0 0 0-1.63 0L3 4.57a1.93 1.93 0 0 0 0 3.36l12.18 6.86a1.636 1.636 0 0 0 1.63 0z\" />"),
    PACKAGE_PLUS(
        "package-plus",
        "<path d=\"M12 22V12\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />\n  <path d=\"M21 10.535V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l1.675-.955\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />"),
    PACKAGE_SEARCH(
        "package-search",
        "<path d=\"M12 22V12\" />\n  <path d=\"M20.27 18.27 22 20\" />\n  <path d=\"M21 10.498V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l.98-.559\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />\n  <circle cx=\"18.5\" cy=\"16.5\" r=\"2.5\" />"),
    PACKAGE_X(
        "package-x",
        "<path d=\"M12 22V12\" />\n  <path d=\"m16.5 14.5 5 5\" />\n  <path d=\"m16.5 19.5 5-5\" />\n  <path d=\"M21 10.5V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l.13-.074\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />"),
    PANEL_TOP(
        "panel-top",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />"),
    PANELS_TOP_LEFT(
        "panels-top-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M9 21V9\" />"),
    PARENTHESES(
        "parentheses",
        "<path d=\"M8 21s-4-3-4-9 4-9 4-9\" />\n  <path d=\"M16 3s4 3 4 9-4 9-4 9\" />"),
    PERCENT(
        "percent",
        "<line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"2.5\" />\n  <circle cx=\"17.5\" cy=\"17.5\" r=\"2.5\" />"),
    PI(
        "pi",
        "<line x1=\"9\" x2=\"9\" y1=\"4\" y2=\"20\" />\n  <path d=\"M4 7c0-1.7 1.3-3 3-3h13\" />\n  <path d=\"M18 20c-1.7 0-3-1.3-3-3V4\" />"),
    PLAYING_CARD(
        "playing-card",
        "<path d=\"M12.832 8.445a1 1 0 00-1.589-.098l-2.075 3.098a1 1 0 000 1.11l2 3a1 1 0 001.664 0l2-3a1 1 0 000-1.11z\" />\n  <rect x=\"5\" y=\"2\" width=\"14\" height=\"20\" rx=\"2\" />"),
    PLAYING_CARDS(
        "playing-cards",
        "<path d=\"M14.832 8.445a1 1 0 00-1.589-.098l-2.075 3.098a1 1 0 000 1.11l2 3a1 1 0 001.664 0l2-3a1 1 0 000-1.11z\" />\n  <path d=\"m7.18 20.827-5-11a2 2 0 01.993-2.647L7 5.44\" />\n  <rect x=\"7\" y=\"2\" width=\"14\" height=\"20\" rx=\"2\" />"),
    PLAYING_CARDS_FAN(
        "playing-cards-fan",
        "<path d=\"M12.65 7.65a2 2 0 012.629-1.046l5.51 2.374a2 2 0 011.046 2.628l-3.957 9.184a2 2 0 01-2.628 1.046l-5.51-2.374a2 2 0 01-1.046-2.628z\" />\n  <path d=\"M18 7.777V4a2 2 0 00-2-2h-6a2 2 0 00-2 2v10a2 2 0 001.137 1.805\" />\n  <path d=\"m8 4.389-4.364.809a2 2 0 00-1.602 2.33l1.822 9.833a2 2 0 002.331 1.602l2.542-.47\" />"),
    PLUG(
        "plug",
        "<path d=\"M12 22v-5\" />\n  <path d=\"M15 8V2\" />\n  <path d=\"M17 8a1 1 0 0 1 1 1v4a4 4 0 0 1-4 4h-4a4 4 0 0 1-4-4V9a1 1 0 0 1 1-1z\" />\n  <path d=\"M9 8V2\" />"),
    PLUG_2(
        "plug-2",
        "<path d=\"M9 2v6\" />\n  <path d=\"M15 2v6\" />\n  <path d=\"M12 17v5\" />\n  <path d=\"M5 8h14\" />\n  <path d=\"M6 11V8h12v3a6 6 0 1 1-12 0Z\" />"),
    PLUS("plus", "<path d=\"M5 12h14\" />\n  <path d=\"M12 5v14\" />"),
    PUZZLE(
        "puzzle",
        "<path d=\"M15.39 4.39a1 1 0 0 0 1.68-.474 2.5 2.5 0 1 1 3.014 3.015 1 1 0 0 0-.474 1.68l1.683 1.682a2.414 2.414 0 0 1 0 3.414L19.61 15.39a1 1 0 0 1-1.68-.474 2.5 2.5 0 1 0-3.014 3.015 1 1 0 0 1 .474 1.68l-1.683 1.682a2.414 2.414 0 0 1-3.414 0L8.61 19.61a1 1 0 0 0-1.68.474 2.5 2.5 0 1 1-3.014-3.015 1 1 0 0 0 .474-1.68l-1.683-1.682a2.414 2.414 0 0 1 0-3.414L4.39 8.61a1 1 0 0 1 1.68.474 2.5 2.5 0 1 0 3.014-3.015 1 1 0 0 1-.474-1.68l1.683-1.682a2.414 2.414 0 0 1 3.414 0z\" />"),
    QR_CODE(
        "qr-code",
        "<rect width=\"5\" height=\"5\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"5\" height=\"5\" x=\"16\" y=\"3\" rx=\"1\" />\n  <rect width=\"5\" height=\"5\" x=\"3\" y=\"16\" rx=\"1\" />\n  <path d=\"M21 16h-3a2 2 0 0 0-2 2v3\" />\n  <path d=\"M21 21v.01\" />\n  <path d=\"M12 7v3a2 2 0 0 1-2 2H7\" />\n  <path d=\"M3 12h.01\" />\n  <path d=\"M12 3h.01\" />\n  <path d=\"M12 16v.01\" />\n  <path d=\"M16 12h1\" />\n  <path d=\"M21 12v.01\" />\n  <path d=\"M12 21v-1\" />"),
    RADICAL(
        "radical",
        "<path d=\"M3 12h3.28a1 1 0 0 1 .948.684l2.298 7.934a.5.5 0 0 0 .96-.044L13.82 4.771A1 1 0 0 1 14.792 4H21\" />"),
    RECTANGLE_CIRCLE(
        "rectangle-circle",
        "<path d=\"M14 4v16H3a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1z\" />\n  <circle cx=\"14\" cy=\"12\" r=\"8\" />"),
    RECTANGLE_ELLIPSIS(
        "rectangle-ellipsis",
        "<rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M17 12h.01\" />\n  <path d=\"M7 12h.01\" />"),
    REFRESH_CCW_DOT(
        "refresh-ccw-dot",
        "<path d=\"M21 12a9 9 0 0 0-9-9 9.75 9.75 0 0 0-6.74 2.74L3 8\" />\n  <path d=\"M3 3v5h5\" />\n  <path d=\"M3 12a9 9 0 0 0 9 9 9.75 9.75 0 0 0 6.74-2.74L21 16\" />\n  <path d=\"M16 16h5v5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    REGEX(
        "regex",
        "<path d=\"M17 3v10\" />\n  <path d=\"m12.67 5.5 8.66 5\" />\n  <path d=\"m12.67 10.5 8.66-5\" />\n  <path d=\"M9 17a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2-2v-2z\" />"),
    ROCKET(
        "rocket",
        "<path d=\"M12 15v5s3.03-.55 4-2c1.08-1.62 0-5 0-5\" />\n  <path d=\"M4.5 16.5c-1.5 1.26-2 5-2 5s3.74-.5 5-2c.71-.84.7-2.13-.09-2.91a2.18 2.18 0 0 0-2.91-.09\" />\n  <path d=\"M9 12a22 22 0 0 1 2-3.95A12.88 12.88 0 0 1 22 2c0 2.72-.78 7.5-6 11a22.4 22.4 0 0 1-4 2z\" />\n  <path d=\"M9 12H4s.55-3.03 2-4c1.62-1.08 5 .05 5 .05\" />"),
    ROUTER(
        "router",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6.01 18H6\" />\n  <path d=\"M10.01 18H10\" />\n  <path d=\"M15 10v4\" />\n  <path d=\"M17.84 7.17a4 4 0 0 0-5.66 0\" />\n  <path d=\"M20.66 4.34a8 8 0 0 0-11.31 0\" />"),
    RSS(
        "rss",
        "<path d=\"M4 11a9 9 0 0 1 9 9\" />\n  <path d=\"M4 4a16 16 0 0 1 16 16\" />\n  <circle cx=\"5\" cy=\"19\" r=\"1\" />"),
    SAVE_CHECK(
        "save-check",
        "<path d=\"M12.5 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h10.2a2 2 0 0 1 1.4.6l3.8 3.8a2 2 0 0 1 .6 1.4v4.35\" />\n  <path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M17 15.13V14a1 1 0 0 0-1-1H8a1 1 0 0 0-1 1v7\" />\n  <path d=\"M7 3v4a1 1 0 0 0 1 1h7\" />"),
    SCAN_SQUARE(
        "scan-square",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"8\" height=\"8\" x=\"8\" y=\"8\" rx=\"1\" />"),
    SCRATCH_BLOCKS(
        "scratch-blocks",
        "<path d=\"M19 5a2 2 0 012 2v11a2 2 0 01-2 2h-5.586a1 1 0 00-.707.293l-1.414 1.414a1 1 0 01-.707.293H8.414a1 1 0 01-.707-.293l-1.414-1.414A1 1 0 005.586 20H5a2 2 0 01-2-2V5.286c0-.394.11-.785.36-1.09a6 6 0 019.168-.133C12.996 4.6 13.637 5 14.35 5z\" />\n  <path d=\"M21 12h-7.586a1 1 0 00-.707.293l-1.414 1.414a1 1 0 01-.707.293H8.414a1 1 0 01-.707-.293l-1.414-1.414A1 1 0 005.586 12H3\" />"),
    SCROLL(
        "scroll",
        "<path d=\"M19 17V5a2 2 0 0 0-2-2H4\" />\n  <path d=\"M8 21h12a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1H11a1 1 0 0 0-1 1v1a2 2 0 1 1-4 0V5a2 2 0 1 0-4 0v2a1 1 0 0 0 1 1h3\" />"),
    SCROLL_TEXT(
        "scroll-text",
        "<path d=\"M15 12h-5\" />\n  <path d=\"M15 8h-5\" />\n  <path d=\"M19 17V5a2 2 0 0 0-2-2H4\" />\n  <path d=\"M8 21h12a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1H11a1 1 0 0 0-1 1v1a2 2 0 1 1-4 0V5a2 2 0 1 0-4 0v2a1 1 0 0 0 1 1h3\" />"),
    SEARCH_CODE(
        "search-code",
        "<path d=\"m13 13.5 2-2.5-2-2.5\" />\n  <path d=\"m21 21-4.3-4.3\" />\n  <path d=\"M9 8.5 7 11l2 2.5\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />"),
    SERVER(
        "server",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" ry=\"2\" />\n  <line x1=\"6\" x2=\"6.01\" y1=\"6\" y2=\"6\" />\n  <line x1=\"6\" x2=\"6.01\" y1=\"18\" y2=\"18\" />"),
    SERVER_COG(
        "server-cog",
        "<path d=\"m10.852 14.772-.383.923\" />\n  <path d=\"M13.148 14.772a3 3 0 1 0-2.296-5.544l-.383-.923\" />\n  <path d=\"m13.148 9.228.383-.923\" />\n  <path d=\"m13.53 15.696-.382-.924a3 3 0 1 1-2.296-5.544\" />\n  <path d=\"m14.772 10.852.923-.383\" />\n  <path d=\"m14.772 13.148.923.383\" />\n  <path d=\"M4.5 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-.5\" />\n  <path d=\"M4.5 14H4a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-.5\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M6 6h.01\" />\n  <path d=\"m9.228 10.852-.923-.383\" />\n  <path d=\"m9.228 13.148-.923.383\" />"),
    SERVER_CRASH(
        "server-crash",
        "<path d=\"M6 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M6 14H4a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-2\" />\n  <path d=\"M6 6h.01\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"m13 6-4 6h6l-4 6\" />"),
    SERVER_NAS(
        "server-nas",
        "<path d=\"M10 16V8\" />\n  <path d=\"M14 16V8\" />\n  <path d=\"M18 16V8\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M6 16h.01\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    SERVER_OFF(
        "server-off",
        "<path d=\"M7 2h13a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-5\" />\n  <path d=\"M10 10 2.5 2.5C2 2 2 2.5 2 5v3a2 2 0 0 0 2 2h6z\" />\n  <path d=\"M22 17v-1a2 2 0 0 0-2-2h-1\" />\n  <path d=\"M4 14a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16.5l1-.5.5.5-8-8H4z\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"m2 2 20 20\" />"),
    SERVER_PLUS(
        "server-plus",
        "<path d=\"M12.5 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 12h6\" />\n  <path d=\"M19 9v6\" />\n  <path d=\"M22 18v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h8.5\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M6 6h.01\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHIELD(
        "shield",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />"),
    SHIELD_ALERT(
        "shield-alert",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M12 8v4\" />\n  <path d=\"M12 16h.01\" />"),
    SHIELD_BAN(
        "shield-ban",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m4.243 5.21 14.39 12.472\" />"),
    SHIELD_CHECK(
        "shield-check",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m9 12 2 2 4-4\" />"),
    SHIELD_COG(
        "shield-cog",
        "<path d=\"m10.929 14.467-.383.924\" />\n  <path d=\"M10.929 8.923 10.546 8\" />\n  <path d=\"M13.225 8.923 13.608 8\" />\n  <path d=\"m13.607 15.391-.382-.924\" />\n  <path d=\"m14.849 10.547.923-.383\" />\n  <path d=\"m14.849 12.843.923.383\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m9.305 10.547-.923-.383\" />\n  <path d=\"m9.305 12.843-.923.383\" />\n  <circle cx=\"12.077\" cy=\"11.695\" r=\"3\" />"),
    SHIELD_COG_CORNER(
        "shield-cog-corner",
        "<path d=\"M11 22c-3.806-1.45-7-3.966-7-9V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1v4\" />\n  <path d=\"M14.923 16.547 14 16.164\" />\n  <path d=\"m14.923 18.843-.923.383\" />\n  <path d=\"M16.547 14.923 16.164 14\" />\n  <path d=\"m16.547 20.467-.383.924\" />\n  <path d=\"m18.843 14.923.383-.923\" />\n  <path d=\"m19.225 21.391-.382-.924\" />\n  <path d=\"m20.467 16.547.923-.383\" />\n  <path d=\"m20.467 18.843.923.383\" />\n  <circle cx=\"17.695\" cy=\"17.695\" r=\"3\" />"),
    SHIELD_ELLIPSIS(
        "shield-ellipsis",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M8 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M16 12h.01\" />"),
    SHIELD_HALF(
        "shield-half",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M12 22V2\" />"),
    SHIELD_HOUSE(
        "shield-house",
        "<path d=\"M15 22a1 1 0 01-1-1v-4a1 1 0 01.445-.832l3-2a1 1 0 011.11 0l3 2A1 1 0 0122 17v4a1 1 0 01-1 1z\" />\n  <path d=\"M18 22v-3\" />\n  <path d=\"M20 10.418V6a1 1 0 00-1-1c-2 0-4.49-1.19-6.24-2.72a1.17 1.17 0 00-1.52 0C9.5 3.8 7 5 5 5a1 1 0 00-1 1v7c0 4.602 2.67 7.1 6.037 8.603\" />"),
    SHIELD_KEYHOLE(
        "shield-keyhole",
        "<path d=\"M12 13v3\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 01-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 011-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 011.52 0C14.51 3.81 17 5 19 5a1 1 0 011 1z\" />\n  <circle cx=\"12\" cy=\"11\" r=\"2\" />"),
    SHIELD_MINUS(
        "shield-minus",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9 12h6\" />"),
    SHIELD_OFF(
        "shield-off",
        "<path d=\"m2 2 20 20\" />\n  <path d=\"M5 5a1 1 0 0 0-1 1v7c0 5 3.5 7.5 7.67 8.94a1 1 0 0 0 .67.01c2.35-.82 4.48-1.97 5.9-3.71\" />\n  <path d=\"M9.309 3.652A12.252 12.252 0 0 0 11.24 2.28a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1v7a9.784 9.784 0 0 1-.08 1.264\" />"),
    SHIELD_PLUS(
        "shield-plus",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />"),
    SHIELD_QUESTION_MARK(
        "shield-question-mark",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9.1 9a3 3 0 0 1 5.82 1c0 2-3 3-3 3\" />\n  <path d=\"M12 17h.01\" />"),
    SHIELD_USER(
        "shield-user",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M6.376 18.91a6 6 0 0 1 11.249.003\" />\n  <circle cx=\"12\" cy=\"11\" r=\"4\" />"),
    SHIELD_X(
        "shield-x",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"m14.5 9.5-5 5\" />\n  <path d=\"m9.5 9.5 5 5\" />"),
    SIGNPOST(
        "signpost",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M2.354 10.354a1.207 1.207 0 0 1 0-1.708l2.06-2.06A2 2 0 0 1 5.828 6h12.344a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H5.828a2 2 0 0 1-1.414-.586z\" />"),
    SIGNPOST_BIG(
        "signpost-big",
        "<path d=\"M10 9H4L2 7l2-2h6\" />\n  <path d=\"M14 5h6l2 2-2 2h-6\" />\n  <path d=\"M10 22V4a2 2 0 1 1 4 0v18\" />\n  <path d=\"M8 22h8\" />"),
    SLASH("slash", "<path d=\"M22 2 2 22\" />"),
    SPELL_CHECK(
        "spell-check",
        "<path d=\"m20 15-5.5 5.5L12 18\" />\n  <path d=\"m4 16 6-12 5.115 10.23\" />\n  <path d=\"M6 12h8\" />"),
    SPELL_CHECK_2(
        "spell-check-2",
        "<path d=\"m6 16 6-12 6 12\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M4 21c1.1 0 1.1-1 2.3-1s1.1 1 2.3 1c1.1 0 1.1-1 2.3-1 1.1 0 1.1 1 2.3 1 1.1 0 1.1-1 2.3-1 1.1 0 1.1 1 2.3 1 1.1 0 1.1-1 2.3-1\" />"),
    SPLIT(
        "split",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"M8 3H3v5\" />\n  <path d=\"M12 22v-8.3a4 4 0 0 0-1.172-2.872L3 3\" />\n  <path d=\"m15 9 6-6\" />"),
    SQUARE_ASTERISK(
        "square-asterisk",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8.5 14 7-4\" />\n  <path d=\"m8.5 10 7 4\" />"),
    SQUARE_BOTTOM_DASHED_SCISSORS(
        "square-bottom-dashed-scissors",
        "<path d=\"M14 21h1\" />\n  <path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M5 21a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />"),
    SQUARE_CHART_GANTT(
        "square-chart-gantt",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 8h7\" />\n  <path d=\"M8 12h6\" />\n  <path d=\"M11 16h5\" />"),
    SQUARE_CHEVRON_RIGHT(
        "square-chevron-right",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m10 8 4 4-4 4\" />"),
    SQUARE_CODE(
        "square-code",
        "<path d=\"m10 9-3 3 3 3\" />\n  <path d=\"m14 15 3-3-3-3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_DASHED_BOTTOM(
        "square-dashed-bottom",
        "<path d=\"M5 21a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 21h1\" />"),
    SQUARE_DASHED_BOTTOM_CODE(
        "square-dashed-bottom-code",
        "<path d=\"M10 9.5 8 12l2 2.5\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"m14 9.5 2 2.5-2 2.5\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2\" />\n  <path d=\"M9 21h1\" />"),
    SQUARE_DASHED_KANBAN(
        "square-dashed-kanban",
        "<path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />"),
    SQUARE_DASHED_MOUSE_POINTER(
        "square-dashed-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h2\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v2\" />\n  <path d=\"M3 14v1\" />"),
    SQUARE_DASHED_TOP_SOLID(
        "square-dashed-top-solid",
        "<path d=\"M14 21h1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 21h1\" />"),
    SQUARE_DASHED_X(
        "square-dashed-x",
        "<path d=\"M14 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 01-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"m9 15 6-6\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"m9 9 6 6\" />"),
    SQUARE_DASHED_X_CORNER(
        "square-dashed-x-corner",
        "<path d=\"M14 3h1\" />\n  <path d=\"m16 16 5 5\" />\n  <path d=\"M19 3a2 2 0 012 2\" />\n  <path d=\"m21 16-5 5\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 01-2-2\" />\n  <path d=\"M5 3a2 2 0 00-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />"),
    SQUARE_DOT(
        "square-dot",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    SQUARE_FUNCTION(
        "square-function",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <path d=\"M9 17c2 0 2.8-1 2.8-2.8V10c0-2 1-3.3 3.2-3\" />\n  <path d=\"M9 11.2h5.7\" />"),
    SQUARE_KANBAN(
        "square-kanban",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />"),
    SQUARE_LIBRARY(
        "square-library",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7v10\" />\n  <path d=\"M11 7v10\" />\n  <path d=\"m15 7 2 10\" />"),
    SQUARE_MINUS(
        "square-minus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />"),
    SQUARE_MOUSE_POINTER(
        "square-mouse-pointer",
        "<path d=\"M12.034 12.681a.498.498 0 0 1 .647-.647l9 3.5a.5.5 0 0 1-.033.943l-3.444 1.068a1 1 0 0 0-.66.66l-1.067 3.443a.5.5 0 0 1-.943.033z\" />\n  <path d=\"M21 11V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />"),
    SQUARE_PI(
        "square-pi",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7h10\" />\n  <path d=\"M10 7v10\" />\n  <path d=\"M16 17a2 2 0 0 1-2-2V7\" />"),
    SQUARE_PLUS(
        "square-plus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_RADICAL(
        "square-radical",
        "<path d=\"M7 12h2l2 5 2-10h4\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_ROUND_CORNER(
        "square-round-corner",
        "<path d=\"M21 11a8 8 0 0 0-8-8\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4\" />"),
    SQUARE_SCISSORS(
        "square-scissors",
        "<path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_SLASH(
        "square-slash",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <line x1=\"9\" x2=\"15\" y1=\"15\" y2=\"9\" />"),
    SQUARE_STACK(
        "square-stack",
        "<path d=\"M4 10c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <path d=\"M10 16c-1.1 0-2-.9-2-2v-4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <rect width=\"8\" height=\"8\" x=\"14\" y=\"14\" rx=\"2\" />"),
    SQUARE_TERMINAL(
        "square-terminal",
        "<path d=\"m7 11 2-2-2-2\" />\n  <path d=\"M11 13h4\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />"),
    SQUARE_TEXT(
        "square-text",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />"),
    SQUIRCLE_DASHED(
        "squircle-dashed",
        "<path d=\"M13.77 3.043a34 34 0 0 0-3.54 0\" />\n  <path d=\"M13.771 20.956a33 33 0 0 1-3.541.001\" />\n  <path d=\"M20.18 17.74c-.51 1.15-1.29 1.93-2.439 2.44\" />\n  <path d=\"M20.18 6.259c-.51-1.148-1.291-1.929-2.44-2.438\" />\n  <path d=\"M20.957 10.23a33 33 0 0 1 0 3.54\" />\n  <path d=\"M3.043 10.23a34 34 0 0 0 .001 3.541\" />\n  <path d=\"M6.26 20.179c-1.15-.508-1.93-1.29-2.44-2.438\" />\n  <path d=\"M6.26 3.82c-1.149.51-1.93 1.291-2.44 2.44\" />"),
    TABLE_PROPERTIES(
        "table-properties",
        "<path d=\"M15 3v18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    TABLET_SMARTPHONE(
        "tablet-smartphone",
        "<rect width=\"10\" height=\"14\" x=\"3\" y=\"8\" rx=\"2\" />\n  <path d=\"M5 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v16a2 2 0 0 1-2 2h-2.4\" />\n  <path d=\"M8 18h.01\" />"),
    TELESCOPE(
        "telescope",
        "<path d=\"m10.065 12.493-6.18 1.318a.934.934 0 0 1-1.108-.702l-.537-2.15a1.07 1.07 0 0 1 .691-1.265l13.504-4.44\" />\n  <path d=\"m13.56 11.747 4.332-.924\" />\n  <path d=\"m16 21-3.105-6.21\" />\n  <path d=\"M16.485 5.94a2 2 0 0 1 1.455-2.425l1.09-.272a1 1 0 0 1 1.212.727l1.515 6.06a1 1 0 0 1-.727 1.213l-1.09.272a2 2 0 0 1-2.425-1.455z\" />\n  <path d=\"m6.158 8.633 1.114 4.456\" />\n  <path d=\"m8 21 3.105-6.21\" />\n  <circle cx=\"12\" cy=\"13\" r=\"2\" />"),
    TERMINAL("terminal", "<path d=\"M12 19h8\" />\n  <path d=\"m4 17 6-6-6-6\" />"),
    TOGGLE_LEFT(
        "toggle-left",
        "<circle cx=\"9\" cy=\"12\" r=\"3\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"5\" rx=\"7\" />"),
    TOGGLE_RIGHT(
        "toggle-right",
        "<circle cx=\"15\" cy=\"12\" r=\"3\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"5\" rx=\"7\" />"),
    TOMBSTONE(
        "tombstone",
        "<path d=\"M11 10h2\" />\n  <path d=\"M19 21V10a7 7 0 00-14 0v11\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 14h6\" />"),
    TOOL_CASE(
        "tool-case",
        "<path d=\"M10 15h4\" />\n  <path d=\"m14.5 4.058.571-1.429a1 1 0 011.3-.558l5 2a1 1 0 01.549.534.88.88 0 01.01.765l-2.332 5.83\" />\n  <path d=\"M15.634 11a2 2 0 00-.186-.34l-1.17-1.757 1.31-1.656a2 2 0 00-2.109-3.165l-2.032.57-1.17-1.758a2 2 0 00-3.664 1.028l-.086 2.11-2.032.568a2 2 0 00-.155 3.8l1.617.6\" />\n  <path d=\"M4 12.006A1 1 0 014.994 11H19a1 1 0 011 1v7a2 2 0 01-2 2H6a2 2 0 01-2-2z\" />"),
    TOY_BRICK(
        "toy-brick",
        "<rect width=\"18\" height=\"12\" x=\"3\" y=\"8\" rx=\"1\" />\n  <path d=\"M10 8V5c0-.6-.4-1-1-1H6a1 1 0 0 0-1 1v3\" />\n  <path d=\"M19 8V5c0-.6-.4-1-1-1h-3a1 1 0 0 0-1 1v3\" />"),
    TRIANGLE_ALERT(
        "triangle-alert",
        "<path d=\"m21.73 18-8-14a2 2 0 0 0-3.48 0l-8 14A2 2 0 0 0 4 21h16a2 2 0 0 0 1.73-3\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 17h.01\" />"),
    UNPLUG(
        "unplug",
        "<path d=\"m19 5 3-3\" />\n  <path d=\"m2 22 3-3\" />\n  <path d=\"M6.3 20.3a2.4 2.4 0 0 0 3.4 0L12 18l-6-6-2.3 2.3a2.4 2.4 0 0 0 0 3.4Z\" />\n  <path d=\"M7.5 13.5 10 11\" />\n  <path d=\"M10.5 16.5 13 14\" />\n  <path d=\"m12 6 6 6 2.3-2.3a2.4 2.4 0 0 0 0-3.4l-2.6-2.6a2.4 2.4 0 0 0-3.4 0Z\" />"),
    USER_SHIELD(
        "user-shield",
        "<path d=\"M10 15H6a4 4 0 0 0-4 4v2\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <circle cx=\"9\" cy=\"7\" r=\"4\" />"),
    VARIABLE(
        "variable",
        "<path d=\"M8 21s-4-3-4-9 4-9 4-9\" />\n  <path d=\"M16 3s4 3 4 9-4 9-4 9\" />\n  <line x1=\"15\" x2=\"9\" y1=\"9\" y2=\"15\" />\n  <line x1=\"9\" x2=\"15\" y1=\"9\" y2=\"15\" />"),
    WAYPOINTS(
        "waypoints",
        "<path d=\"m10.586 5.414-5.172 5.172\" />\n  <path d=\"m18.586 13.414-5.172 5.172\" />\n  <path d=\"M6 12h12\" />\n  <circle cx=\"12\" cy=\"20\" r=\"2\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />\n  <circle cx=\"20\" cy=\"12\" r=\"2\" />\n  <circle cx=\"4\" cy=\"12\" r=\"2\" />"),
    WEBHOOK(
        "webhook",
        "<path d=\"M18 16.98h-5.99c-1.1 0-1.95.94-2.48 1.9A4 4 0 0 1 2 17c.01-.7.2-1.4.57-2\" />\n  <path d=\"m6 17 3.13-5.78c.53-.97.1-2.18-.5-3.1a4 4 0 1 1 6.89-4.06\" />\n  <path d=\"m12 6 3.13 5.73C15.66 12.7 16.9 13 18 13a4 4 0 0 1 0 8\" />"),
    WEBHOOK_OFF(
        "webhook-off",
        "<path d=\"M17 17h-5c-1.09-.02-1.94.92-2.5 1.9A3 3 0 1 1 2.57 15\" />\n  <path d=\"M9 3.4a4 4 0 0 1 6.52.66\" />\n  <path d=\"m6 17 3.1-5.8a2.5 2.5 0 0 0 .057-2.05\" />\n  <path d=\"M20.3 20.3a4 4 0 0 1-2.3.7\" />\n  <path d=\"M18.6 13a4 4 0 0 1 3.357 3.414\" />\n  <path d=\"m12 6 .6 1\" />\n  <path d=\"m2 2 20 20\" />"),
    WORKFLOW(
        "workflow",
        "<rect width=\"8\" height=\"8\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 11v4a2 2 0 0 0 2 2h4\" />\n  <rect width=\"8\" height=\"8\" x=\"13\" y=\"13\" rx=\"2\" />"),
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
  default LucideIcon ampersand_development() {
    return LucideIcon.create(Icon.AMPERSAND);
  }

  default LucideIcon ampersands_development() {
    return LucideIcon.create(Icon.AMPERSANDS);
  }

  default LucideIcon app_window_development() {
    return LucideIcon.create(Icon.APP_WINDOW);
  }

  default LucideIcon app_window_mac_development() {
    return LucideIcon.create(Icon.APP_WINDOW_MAC);
  }

  default LucideIcon arrow_big_up_development() {
    return LucideIcon.create(Icon.ARROW_BIG_UP);
  }

  default LucideIcon arrow_big_up_dash_development() {
    return LucideIcon.create(Icon.ARROW_BIG_UP_DASH);
  }

  default LucideIcon arrow_down_to_line_development() {
    return LucideIcon.create(Icon.ARROW_DOWN_TO_LINE);
  }

  default LucideIcon arrow_right_to_line_development() {
    return LucideIcon.create(Icon.ARROW_RIGHT_TO_LINE);
  }

  default LucideIcon arrow_up_from_line_development() {
    return LucideIcon.create(Icon.ARROW_UP_FROM_LINE);
  }

  default LucideIcon asterisk_development() {
    return LucideIcon.create(Icon.ASTERISK);
  }

  default LucideIcon binary_development() {
    return LucideIcon.create(Icon.BINARY);
  }

  default LucideIcon binoculars_development() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon bitcoin_development() {
    return LucideIcon.create(Icon.BITCOIN);
  }

  default LucideIcon blend_development() {
    return LucideIcon.create(Icon.BLEND);
  }

  default LucideIcon blocks_development() {
    return LucideIcon.create(Icon.BLOCKS);
  }

  default LucideIcon book_development() {
    return LucideIcon.create(Icon.BOOK);
  }

  default LucideIcon book_alert_development() {
    return LucideIcon.create(Icon.BOOK_ALERT);
  }

  default LucideIcon book_bookmark_development() {
    return LucideIcon.create(Icon.BOOK_BOOKMARK);
  }

  default LucideIcon book_check_development() {
    return LucideIcon.create(Icon.BOOK_CHECK);
  }

  default LucideIcon book_copy_development() {
    return LucideIcon.create(Icon.BOOK_COPY);
  }

  default LucideIcon book_dashed() {
    return LucideIcon.create(Icon.BOOK_DASHED);
  }

  default LucideIcon book_down() {
    return LucideIcon.create(Icon.BOOK_DOWN);
  }

  default LucideIcon book_key_development() {
    return LucideIcon.create(Icon.BOOK_KEY);
  }

  default LucideIcon book_lock_development() {
    return LucideIcon.create(Icon.BOOK_LOCK);
  }

  default LucideIcon book_minus_development() {
    return LucideIcon.create(Icon.BOOK_MINUS);
  }

  default LucideIcon book_open_development() {
    return LucideIcon.create(Icon.BOOK_OPEN);
  }

  default LucideIcon book_open_check_development() {
    return LucideIcon.create(Icon.BOOK_OPEN_CHECK);
  }

  default LucideIcon book_open_text_development() {
    return LucideIcon.create(Icon.BOOK_OPEN_TEXT);
  }

  default LucideIcon book_plus_development() {
    return LucideIcon.create(Icon.BOOK_PLUS);
  }

  default LucideIcon book_search_development() {
    return LucideIcon.create(Icon.BOOK_SEARCH);
  }

  default LucideIcon book_up() {
    return LucideIcon.create(Icon.BOOK_UP);
  }

  default LucideIcon book_up_2() {
    return LucideIcon.create(Icon.BOOK_UP_2);
  }

  default LucideIcon bot_development() {
    return LucideIcon.create(Icon.BOT);
  }

  default LucideIcon bot_message_square_development() {
    return LucideIcon.create(Icon.BOT_MESSAGE_SQUARE);
  }

  default LucideIcon bot_off_development() {
    return LucideIcon.create(Icon.BOT_OFF);
  }

  default LucideIcon box_development() {
    return LucideIcon.create(Icon.BOX);
  }

  default LucideIcon boxes_development() {
    return LucideIcon.create(Icon.BOXES);
  }

  default LucideIcon braces_development() {
    return LucideIcon.create(Icon.BRACES);
  }

  default LucideIcon brackets_development() {
    return LucideIcon.create(Icon.BRACKETS);
  }

  default LucideIcon brain_circuit_development() {
    return LucideIcon.create(Icon.BRAIN_CIRCUIT);
  }

  default LucideIcon brain_cog_development() {
    return LucideIcon.create(Icon.BRAIN_COG);
  }

  default LucideIcon brain_off_development() {
    return LucideIcon.create(Icon.BRAIN_OFF);
  }

  default LucideIcon bug_development() {
    return LucideIcon.create(Icon.BUG);
  }

  default LucideIcon bug_off_development() {
    return LucideIcon.create(Icon.BUG_OFF);
  }

  default LucideIcon bug_play_development() {
    return LucideIcon.create(Icon.BUG_PLAY);
  }

  default LucideIcon case_lower_development() {
    return LucideIcon.create(Icon.CASE_LOWER);
  }

  default LucideIcon case_upper_development() {
    return LucideIcon.create(Icon.CASE_UPPER);
  }

  default LucideIcon chart_no_axes_gantt_development() {
    return LucideIcon.create(Icon.CHART_NO_AXES_GANTT);
  }

  default LucideIcon chevron_right_development() {
    return LucideIcon.create(Icon.CHEVRON_RIGHT);
  }

  default LucideIcon circle_arrow_out_up_left_development() {
    return LucideIcon.create(Icon.CIRCLE_ARROW_OUT_UP_LEFT);
  }

  default LucideIcon circle_dashed_development() {
    return LucideIcon.create(Icon.CIRCLE_DASHED);
  }

  default LucideIcon circle_dashed_check_development() {
    return LucideIcon.create(Icon.CIRCLE_DASHED_CHECK);
  }

  default LucideIcon circle_dot_development() {
    return LucideIcon.create(Icon.CIRCLE_DOT);
  }

  default LucideIcon circle_dot_dashed_development() {
    return LucideIcon.create(Icon.CIRCLE_DOT_DASHED);
  }

  default LucideIcon circle_ellipsis_development() {
    return LucideIcon.create(Icon.CIRCLE_ELLIPSIS);
  }

  default LucideIcon circle_fading_arrow_up_development() {
    return LucideIcon.create(Icon.CIRCLE_FADING_ARROW_UP);
  }

  default LucideIcon circle_plus_development() {
    return LucideIcon.create(Icon.CIRCLE_PLUS);
  }

  default LucideIcon circle_slash_development() {
    return LucideIcon.create(Icon.CIRCLE_SLASH);
  }

  default LucideIcon circle_slash_2_development() {
    return LucideIcon.create(Icon.CIRCLE_SLASH_2);
  }

  default LucideIcon circle_x_development() {
    return LucideIcon.create(Icon.CIRCLE_X);
  }

  default LucideIcon circuit_board_development() {
    return LucideIcon.create(Icon.CIRCUIT_BOARD);
  }

  default LucideIcon cloud_alert() {
    return LucideIcon.create(Icon.CLOUD_ALERT);
  }

  default LucideIcon cloud_check() {
    return LucideIcon.create(Icon.CLOUD_CHECK);
  }

  default LucideIcon cloud_cog() {
    return LucideIcon.create(Icon.CLOUD_COG);
  }

  default LucideIcon code_development() {
    return LucideIcon.create(Icon.CODE);
  }

  default LucideIcon code_xml_development() {
    return LucideIcon.create(Icon.CODE_XML);
  }

  default LucideIcon combine_development() {
    return LucideIcon.create(Icon.COMBINE);
  }

  default LucideIcon command() {
    return LucideIcon.create(Icon.COMMAND);
  }

  default LucideIcon component_development() {
    return LucideIcon.create(Icon.COMPONENT);
  }

  default LucideIcon computer_development() {
    return LucideIcon.create(Icon.COMPUTER);
  }

  default LucideIcon construction() {
    return LucideIcon.create(Icon.CONSTRUCTION);
  }

  default LucideIcon container_development() {
    return LucideIcon.create(Icon.CONTAINER);
  }

  default LucideIcon copy_slash_development() {
    return LucideIcon.create(Icon.COPY_SLASH);
  }

  default LucideIcon corner_down_right_development() {
    return LucideIcon.create(Icon.CORNER_DOWN_RIGHT);
  }

  default LucideIcon cpu_ai_development() {
    return LucideIcon.create(Icon.CPU_AI);
  }

  default LucideIcon database_development() {
    return LucideIcon.create(Icon.DATABASE);
  }

  default LucideIcon database_arrow_down_development() {
    return LucideIcon.create(Icon.DATABASE_ARROW_DOWN);
  }

  default LucideIcon database_arrow_up_development() {
    return LucideIcon.create(Icon.DATABASE_ARROW_UP);
  }

  default LucideIcon database_backup_development() {
    return LucideIcon.create(Icon.DATABASE_BACKUP);
  }

  default LucideIcon database_check_development() {
    return LucideIcon.create(Icon.DATABASE_CHECK);
  }

  default LucideIcon database_minus_development() {
    return LucideIcon.create(Icon.DATABASE_MINUS);
  }

  default LucideIcon database_plus_development() {
    return LucideIcon.create(Icon.DATABASE_PLUS);
  }

  default LucideIcon database_search_development() {
    return LucideIcon.create(Icon.DATABASE_SEARCH);
  }

  default LucideIcon database_x_development() {
    return LucideIcon.create(Icon.DATABASE_X);
  }

  default LucideIcon database_zap_development() {
    return LucideIcon.create(Icon.DATABASE_ZAP);
  }

  default LucideIcon diff_development() {
    return LucideIcon.create(Icon.DIFF);
  }

  default LucideIcon divide_development() {
    return LucideIcon.create(Icon.DIVIDE);
  }

  default LucideIcon dock_development() {
    return LucideIcon.create(Icon.DOCK);
  }

  default LucideIcon earth_lock_development() {
    return LucideIcon.create(Icon.EARTH_LOCK);
  }

  default LucideIcon eclipse_development() {
    return LucideIcon.create(Icon.ECLIPSE);
  }

  default LucideIcon ellipsis_development() {
    return LucideIcon.create(Icon.ELLIPSIS);
  }

  default LucideIcon equal_development() {
    return LucideIcon.create(Icon.EQUAL);
  }

  default LucideIcon equal_approximately_not_development() {
    return LucideIcon.create(Icon.EQUAL_APPROXIMATELY_NOT);
  }

  default LucideIcon equal_not_development() {
    return LucideIcon.create(Icon.EQUAL_NOT);
  }

  default LucideIcon file_box_development() {
    return LucideIcon.create(Icon.FILE_BOX);
  }

  default LucideIcon file_braces_development() {
    return LucideIcon.create(Icon.FILE_BRACES);
  }

  default LucideIcon file_braces_corner_development() {
    return LucideIcon.create(Icon.FILE_BRACES_CORNER);
  }

  default LucideIcon file_code_development() {
    return LucideIcon.create(Icon.FILE_CODE);
  }

  default LucideIcon file_code_corner_development() {
    return LucideIcon.create(Icon.FILE_CODE_CORNER);
  }

  default LucideIcon file_diff_development() {
    return LucideIcon.create(Icon.FILE_DIFF);
  }

  default LucideIcon file_digit_development() {
    return LucideIcon.create(Icon.FILE_DIGIT);
  }

  default LucideIcon file_sliders_development() {
    return LucideIcon.create(Icon.FILE_SLIDERS);
  }

  default LucideIcon file_stack_development() {
    return LucideIcon.create(Icon.FILE_STACK);
  }

  default LucideIcon file_terminal_development() {
    return LucideIcon.create(Icon.FILE_TERMINAL);
  }

  default LucideIcon flag_triangle_left_development() {
    return LucideIcon.create(Icon.FLAG_TRIANGLE_LEFT);
  }

  default LucideIcon flag_triangle_right_development() {
    return LucideIcon.create(Icon.FLAG_TRIANGLE_RIGHT);
  }

  default LucideIcon folder_code_development() {
    return LucideIcon.create(Icon.FOLDER_CODE);
  }

  default LucideIcon folder_dot_development() {
    return LucideIcon.create(Icon.FOLDER_DOT);
  }

  default LucideIcon folder_kanban_development() {
    return LucideIcon.create(Icon.FOLDER_KANBAN);
  }

  default LucideIcon folder_open_dot_development() {
    return LucideIcon.create(Icon.FOLDER_OPEN_DOT);
  }

  default LucideIcon folder_root_development() {
    return LucideIcon.create(Icon.FOLDER_ROOT);
  }

  default LucideIcon form() {
    return LucideIcon.create(Icon.FORM);
  }

  default LucideIcon gallery_horizontal_development() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL);
  }

  default LucideIcon gallery_horizontal_end_development() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_thumbnails_development() {
    return LucideIcon.create(Icon.GALLERY_THUMBNAILS);
  }

  default LucideIcon gallery_vertical_development() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL);
  }

  default LucideIcon gallery_vertical_end_development() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon gem_development() {
    return LucideIcon.create(Icon.GEM);
  }

  default LucideIcon git_branch() {
    return LucideIcon.create(Icon.GIT_BRANCH);
  }

  default LucideIcon git_branch_minus() {
    return LucideIcon.create(Icon.GIT_BRANCH_MINUS);
  }

  default LucideIcon git_branch_plus() {
    return LucideIcon.create(Icon.GIT_BRANCH_PLUS);
  }

  default LucideIcon git_commit_horizontal_development() {
    return LucideIcon.create(Icon.GIT_COMMIT_HORIZONTAL);
  }

  default LucideIcon git_commit_vertical_development() {
    return LucideIcon.create(Icon.GIT_COMMIT_VERTICAL);
  }

  default LucideIcon git_compare() {
    return LucideIcon.create(Icon.GIT_COMPARE);
  }

  default LucideIcon git_compare_arrows_development() {
    return LucideIcon.create(Icon.GIT_COMPARE_ARROWS);
  }

  default LucideIcon git_fork() {
    return LucideIcon.create(Icon.GIT_FORK);
  }

  default LucideIcon git_graph() {
    return LucideIcon.create(Icon.GIT_GRAPH);
  }

  default LucideIcon git_merge() {
    return LucideIcon.create(Icon.GIT_MERGE);
  }

  default LucideIcon git_merge_conflict() {
    return LucideIcon.create(Icon.GIT_MERGE_CONFLICT);
  }

  default LucideIcon git_pull_request() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST);
  }

  default LucideIcon git_pull_request_arrow_development() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_ARROW);
  }

  default LucideIcon git_pull_request_closed() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_CLOSED);
  }

  default LucideIcon git_pull_request_create() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_CREATE);
  }

  default LucideIcon git_pull_request_create_arrow_development() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_CREATE_ARROW);
  }

  default LucideIcon git_pull_request_draft() {
    return LucideIcon.create(Icon.GIT_PULL_REQUEST_DRAFT);
  }

  default LucideIcon globe_code_development() {
    return LucideIcon.create(Icon.GLOBE_CODE);
  }

  default LucideIcon globe_lock_development() {
    return LucideIcon.create(Icon.GLOBE_LOCK);
  }

  default LucideIcon graph_hub_development() {
    return LucideIcon.create(Icon.GRAPH_HUB);
  }

  default LucideIcon graph_star_development() {
    return LucideIcon.create(Icon.GRAPH_STAR);
  }

  default LucideIcon hard_drive_development() {
    return LucideIcon.create(Icon.HARD_DRIVE);
  }

  default LucideIcon hard_drive_download_development() {
    return LucideIcon.create(Icon.HARD_DRIVE_DOWNLOAD);
  }

  default LucideIcon hard_drive_upload_development() {
    return LucideIcon.create(Icon.HARD_DRIVE_UPLOAD);
  }

  default LucideIcon hexagon_development() {
    return LucideIcon.create(Icon.HEXAGON);
  }

  default LucideIcon kanban_development() {
    return LucideIcon.create(Icon.KANBAN);
  }

  default LucideIcon keyboard_development() {
    return LucideIcon.create(Icon.KEYBOARD);
  }

  default LucideIcon keyboard_off_development() {
    return LucideIcon.create(Icon.KEYBOARD_OFF);
  }

  default LucideIcon lambda_development() {
    return LucideIcon.create(Icon.LAMBDA);
  }

  default LucideIcon library_development() {
    return LucideIcon.create(Icon.LIBRARY);
  }

  default LucideIcon library_big_development() {
    return LucideIcon.create(Icon.LIBRARY_BIG);
  }

  default LucideIcon line_dot_bottom_vertical_development() {
    return LucideIcon.create(Icon.LINE_DOT_BOTTOM_VERTICAL);
  }

  default LucideIcon line_dot_left_horizontal_development() {
    return LucideIcon.create(Icon.LINE_DOT_LEFT_HORIZONTAL);
  }

  default LucideIcon line_dot_right_horizontal_development() {
    return LucideIcon.create(Icon.LINE_DOT_RIGHT_HORIZONTAL);
  }

  default LucideIcon line_dot_top_vertical_development() {
    return LucideIcon.create(Icon.LINE_DOT_TOP_VERTICAL);
  }

  default LucideIcon list_indent_decrease_development() {
    return LucideIcon.create(Icon.LIST_INDENT_DECREASE);
  }

  default LucideIcon list_indent_increase_development() {
    return LucideIcon.create(Icon.LIST_INDENT_INCREASE);
  }

  default LucideIcon merge_development() {
    return LucideIcon.create(Icon.MERGE);
  }

  default LucideIcon message_circle_code_development() {
    return LucideIcon.create(Icon.MESSAGE_CIRCLE_CODE);
  }

  default LucideIcon message_square_code_development() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_CODE);
  }

  default LucideIcon message_square_diff_development() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_DIFF);
  }

  default LucideIcon milestone_development() {
    return LucideIcon.create(Icon.MILESTONE);
  }

  default LucideIcon minus_development() {
    return LucideIcon.create(Icon.MINUS);
  }

  default LucideIcon monitor_cloud_development() {
    return LucideIcon.create(Icon.MONITOR_CLOUD);
  }

  default LucideIcon monitor_pc_development() {
    return LucideIcon.create(Icon.MONITOR_PC);
  }

  default LucideIcon network() {
    return LucideIcon.create(Icon.NETWORK);
  }

  default LucideIcon omega_development() {
    return LucideIcon.create(Icon.OMEGA);
  }

  default LucideIcon option() {
    return LucideIcon.create(Icon.OPTION);
  }

  default LucideIcon package_development() {
    return LucideIcon.create(Icon.PACKAGE);
  }

  default LucideIcon package_2_development() {
    return LucideIcon.create(Icon.PACKAGE_2);
  }

  default LucideIcon package_check() {
    return LucideIcon.create(Icon.PACKAGE_CHECK);
  }

  default LucideIcon package_minus() {
    return LucideIcon.create(Icon.PACKAGE_MINUS);
  }

  default LucideIcon package_open_development() {
    return LucideIcon.create(Icon.PACKAGE_OPEN);
  }

  default LucideIcon package_plus() {
    return LucideIcon.create(Icon.PACKAGE_PLUS);
  }

  default LucideIcon package_search_development() {
    return LucideIcon.create(Icon.PACKAGE_SEARCH);
  }

  default LucideIcon package_x() {
    return LucideIcon.create(Icon.PACKAGE_X);
  }

  default LucideIcon panel_top_development() {
    return LucideIcon.create(Icon.PANEL_TOP);
  }

  default LucideIcon panels_top_left_development() {
    return LucideIcon.create(Icon.PANELS_TOP_LEFT);
  }

  default LucideIcon parentheses_development() {
    return LucideIcon.create(Icon.PARENTHESES);
  }

  default LucideIcon percent_development() {
    return LucideIcon.create(Icon.PERCENT);
  }

  default LucideIcon pi_development() {
    return LucideIcon.create(Icon.PI);
  }

  default LucideIcon playing_card_development() {
    return LucideIcon.create(Icon.PLAYING_CARD);
  }

  default LucideIcon playing_cards_development() {
    return LucideIcon.create(Icon.PLAYING_CARDS);
  }

  default LucideIcon playing_cards_fan_development() {
    return LucideIcon.create(Icon.PLAYING_CARDS_FAN);
  }

  default LucideIcon plug_development() {
    return LucideIcon.create(Icon.PLUG);
  }

  default LucideIcon plug_2_development() {
    return LucideIcon.create(Icon.PLUG_2);
  }

  default LucideIcon plus_development() {
    return LucideIcon.create(Icon.PLUS);
  }

  default LucideIcon puzzle_development() {
    return LucideIcon.create(Icon.PUZZLE);
  }

  default LucideIcon qr_code_development() {
    return LucideIcon.create(Icon.QR_CODE);
  }

  default LucideIcon radical_development() {
    return LucideIcon.create(Icon.RADICAL);
  }

  default LucideIcon rectangle_circle_development() {
    return LucideIcon.create(Icon.RECTANGLE_CIRCLE);
  }

  default LucideIcon rectangle_ellipsis_development() {
    return LucideIcon.create(Icon.RECTANGLE_ELLIPSIS);
  }

  default LucideIcon refresh_ccw_dot_development() {
    return LucideIcon.create(Icon.REFRESH_CCW_DOT);
  }

  default LucideIcon regex_development() {
    return LucideIcon.create(Icon.REGEX);
  }

  default LucideIcon rocket_development() {
    return LucideIcon.create(Icon.ROCKET);
  }

  default LucideIcon router_development() {
    return LucideIcon.create(Icon.ROUTER);
  }

  default LucideIcon rss_development() {
    return LucideIcon.create(Icon.RSS);
  }

  default LucideIcon save_check_development() {
    return LucideIcon.create(Icon.SAVE_CHECK);
  }

  default LucideIcon scan_square_development() {
    return LucideIcon.create(Icon.SCAN_SQUARE);
  }

  default LucideIcon scratch_blocks() {
    return LucideIcon.create(Icon.SCRATCH_BLOCKS);
  }

  default LucideIcon scroll_development() {
    return LucideIcon.create(Icon.SCROLL);
  }

  default LucideIcon scroll_text_development() {
    return LucideIcon.create(Icon.SCROLL_TEXT);
  }

  default LucideIcon search_code_development() {
    return LucideIcon.create(Icon.SEARCH_CODE);
  }

  default LucideIcon server_development() {
    return LucideIcon.create(Icon.SERVER);
  }

  default LucideIcon server_cog_development() {
    return LucideIcon.create(Icon.SERVER_COG);
  }

  default LucideIcon server_crash_development() {
    return LucideIcon.create(Icon.SERVER_CRASH);
  }

  default LucideIcon server_nas_development() {
    return LucideIcon.create(Icon.SERVER_NAS);
  }

  default LucideIcon server_off_development() {
    return LucideIcon.create(Icon.SERVER_OFF);
  }

  default LucideIcon server_plus_development() {
    return LucideIcon.create(Icon.SERVER_PLUS);
  }

  default LucideIcon shell_development() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon shield_development() {
    return LucideIcon.create(Icon.SHIELD);
  }

  default LucideIcon shield_alert_development() {
    return LucideIcon.create(Icon.SHIELD_ALERT);
  }

  default LucideIcon shield_ban_development() {
    return LucideIcon.create(Icon.SHIELD_BAN);
  }

  default LucideIcon shield_check_development() {
    return LucideIcon.create(Icon.SHIELD_CHECK);
  }

  default LucideIcon shield_cog_development() {
    return LucideIcon.create(Icon.SHIELD_COG);
  }

  default LucideIcon shield_cog_corner_development() {
    return LucideIcon.create(Icon.SHIELD_COG_CORNER);
  }

  default LucideIcon shield_ellipsis_development() {
    return LucideIcon.create(Icon.SHIELD_ELLIPSIS);
  }

  default LucideIcon shield_half_development() {
    return LucideIcon.create(Icon.SHIELD_HALF);
  }

  default LucideIcon shield_house_development() {
    return LucideIcon.create(Icon.SHIELD_HOUSE);
  }

  default LucideIcon shield_keyhole_development() {
    return LucideIcon.create(Icon.SHIELD_KEYHOLE);
  }

  default LucideIcon shield_minus_development() {
    return LucideIcon.create(Icon.SHIELD_MINUS);
  }

  default LucideIcon shield_off_development() {
    return LucideIcon.create(Icon.SHIELD_OFF);
  }

  default LucideIcon shield_plus_development() {
    return LucideIcon.create(Icon.SHIELD_PLUS);
  }

  default LucideIcon shield_question_mark_development() {
    return LucideIcon.create(Icon.SHIELD_QUESTION_MARK);
  }

  default LucideIcon shield_user_development() {
    return LucideIcon.create(Icon.SHIELD_USER);
  }

  default LucideIcon shield_x_development() {
    return LucideIcon.create(Icon.SHIELD_X);
  }

  default LucideIcon signpost_development() {
    return LucideIcon.create(Icon.SIGNPOST);
  }

  default LucideIcon signpost_big_development() {
    return LucideIcon.create(Icon.SIGNPOST_BIG);
  }

  default LucideIcon slash_development() {
    return LucideIcon.create(Icon.SLASH);
  }

  default LucideIcon spell_check_development() {
    return LucideIcon.create(Icon.SPELL_CHECK);
  }

  default LucideIcon spell_check_2_development() {
    return LucideIcon.create(Icon.SPELL_CHECK_2);
  }

  default LucideIcon split_development() {
    return LucideIcon.create(Icon.SPLIT);
  }

  default LucideIcon square_asterisk_development() {
    return LucideIcon.create(Icon.SQUARE_ASTERISK);
  }

  default LucideIcon square_bottom_dashed_scissors_development() {
    return LucideIcon.create(Icon.SQUARE_BOTTOM_DASHED_SCISSORS);
  }

  default LucideIcon square_chart_gantt_development() {
    return LucideIcon.create(Icon.SQUARE_CHART_GANTT);
  }

  default LucideIcon square_chevron_right_development() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_RIGHT);
  }

  default LucideIcon square_code_development() {
    return LucideIcon.create(Icon.SQUARE_CODE);
  }

  default LucideIcon square_dashed_bottom_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_BOTTOM);
  }

  default LucideIcon square_dashed_bottom_code_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_BOTTOM_CODE);
  }

  default LucideIcon square_dashed_kanban_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_KANBAN);
  }

  default LucideIcon square_dashed_mouse_pointer_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_MOUSE_POINTER);
  }

  default LucideIcon square_dashed_top_solid_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_TOP_SOLID);
  }

  default LucideIcon square_dashed_x_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X);
  }

  default LucideIcon square_dashed_x_corner_development() {
    return LucideIcon.create(Icon.SQUARE_DASHED_X_CORNER);
  }

  default LucideIcon square_dot() {
    return LucideIcon.create(Icon.SQUARE_DOT);
  }

  default LucideIcon square_function_development() {
    return LucideIcon.create(Icon.SQUARE_FUNCTION);
  }

  default LucideIcon square_kanban_development() {
    return LucideIcon.create(Icon.SQUARE_KANBAN);
  }

  default LucideIcon square_library_development() {
    return LucideIcon.create(Icon.SQUARE_LIBRARY);
  }

  default LucideIcon square_minus_development() {
    return LucideIcon.create(Icon.SQUARE_MINUS);
  }

  default LucideIcon square_mouse_pointer_development() {
    return LucideIcon.create(Icon.SQUARE_MOUSE_POINTER);
  }

  default LucideIcon square_pi_development() {
    return LucideIcon.create(Icon.SQUARE_PI);
  }

  default LucideIcon square_plus_development() {
    return LucideIcon.create(Icon.SQUARE_PLUS);
  }

  default LucideIcon square_radical_development() {
    return LucideIcon.create(Icon.SQUARE_RADICAL);
  }

  default LucideIcon square_round_corner_development() {
    return LucideIcon.create(Icon.SQUARE_ROUND_CORNER);
  }

  default LucideIcon square_scissors_development() {
    return LucideIcon.create(Icon.SQUARE_SCISSORS);
  }

  default LucideIcon square_slash_development() {
    return LucideIcon.create(Icon.SQUARE_SLASH);
  }

  default LucideIcon square_stack_development() {
    return LucideIcon.create(Icon.SQUARE_STACK);
  }

  default LucideIcon square_terminal() {
    return LucideIcon.create(Icon.SQUARE_TERMINAL);
  }

  default LucideIcon square_text_development() {
    return LucideIcon.create(Icon.SQUARE_TEXT);
  }

  default LucideIcon squircle_dashed_development() {
    return LucideIcon.create(Icon.SQUIRCLE_DASHED);
  }

  default LucideIcon table_properties_development() {
    return LucideIcon.create(Icon.TABLE_PROPERTIES);
  }

  default LucideIcon tablet_smartphone_development() {
    return LucideIcon.create(Icon.TABLET_SMARTPHONE);
  }

  default LucideIcon telescope_development() {
    return LucideIcon.create(Icon.TELESCOPE);
  }

  default LucideIcon terminal() {
    return LucideIcon.create(Icon.TERMINAL);
  }

  default LucideIcon toggle_left_development() {
    return LucideIcon.create(Icon.TOGGLE_LEFT);
  }

  default LucideIcon toggle_right_development() {
    return LucideIcon.create(Icon.TOGGLE_RIGHT);
  }

  default LucideIcon tombstone_development() {
    return LucideIcon.create(Icon.TOMBSTONE);
  }

  default LucideIcon tool_case_development() {
    return LucideIcon.create(Icon.TOOL_CASE);
  }

  default LucideIcon toy_brick_development() {
    return LucideIcon.create(Icon.TOY_BRICK);
  }

  default LucideIcon triangle_alert_development() {
    return LucideIcon.create(Icon.TRIANGLE_ALERT);
  }

  default LucideIcon unplug_development() {
    return LucideIcon.create(Icon.UNPLUG);
  }

  default LucideIcon user_shield_development() {
    return LucideIcon.create(Icon.USER_SHIELD);
  }

  default LucideIcon variable_development() {
    return LucideIcon.create(Icon.VARIABLE);
  }

  default LucideIcon waypoints_development() {
    return LucideIcon.create(Icon.WAYPOINTS);
  }

  default LucideIcon webhook_development() {
    return LucideIcon.create(Icon.WEBHOOK);
  }

  default LucideIcon webhook_off_development() {
    return LucideIcon.create(Icon.WEBHOOK_OFF);
  }

  default LucideIcon workflow() {
    return LucideIcon.create(Icon.WORKFLOW);
  }

  default LucideIcon wrench_development() {
    return LucideIcon.create(Icon.WRENCH);
  }

  default LucideIcon wrench_off_development() {
    return LucideIcon.create(Icon.WRENCH_OFF);
  }
}
