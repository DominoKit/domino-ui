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

/** Lucide text catalog category. */
public interface LucideText {
  enum Icon implements LucideIconDefinition {
    A_ARROW_DOWN(
        "a-arrow-down",
        "<path d=\"m14 12 4 4 4-4\" />\n  <path d=\"M18 16V7\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    A_ARROW_UP(
        "a-arrow-up",
        "<path d=\"m14 11 4-4 4 4\" />\n  <path d=\"M18 16V7\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    A_LARGE_SMALL(
        "a-large-small",
        "<path d=\"m15 16 2.536-7.328a1.02 1.02 1 0 1 1.928 0L22 16\" />\n  <path d=\"M15.697 14h5.606\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    AMPERSAND(
        "ampersand",
        "<path d=\"M16 12h3\" />\n  <path d=\"M17.5 12a8 8 0 0 1-8 8A4.5 4.5 0 0 1 5 15.5c0-6 8-4 8-8.5a3 3 0 1 0-6 0c0 3 2.5 8.5 12 13\" />"),
    AMPERSANDS(
        "ampersands",
        "<path d=\"M10 17c-5-3-7-7-7-9a2 2 0 0 1 4 0c0 2.5-5 2.5-5 6 0 1.7 1.3 3 3 3 2.8 0 5-2.2 5-5\" />\n  <path d=\"M22 17c-5-3-7-7-7-9a2 2 0 0 1 4 0c0 2.5-5 2.5-5 6 0 1.7 1.3 3 3 3 2.8 0 5-2.2 5-5\" />"),
    ANCHOR(
        "anchor",
        "<path d=\"M12 6v16\" />\n  <path d=\"m19 13 2-1a9 9 0 0 1-18 0l2 1\" />\n  <path d=\"M9 11h6\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />"),
    ARROW_BIG_UP(
        "arrow-big-up",
        "<path d=\"M9 19a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1v-6a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-7.086-7.086a1 1 0 0 0-1.414 0l-7.086 7.086a.707.707 0 0 0 .5 1.207H8a1 1 0 0 1 1 1z\" />"),
    ARROW_BIG_UP_DASH(
        "arrow-big-up-dash",
        "<path d=\"M14 16a1 1 0 0 0 1-1v-2a1 1 0 0 1 1-1h3.293a.707.707 0 0 0 .5-1.207l-6.939-6.939a1.207 1.207 0 0 0-1.708 0l-6.94 6.94a.707.707 0 0 0 .5 1.206H8a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1z\" />\n  <path d=\"M9 20h6\" />"),
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
    ASTERISK(
        "asterisk",
        "<path d=\"M12 5v14\" />\n  <path d=\"m18.065 8.496-12.125 7\" />\n  <path d=\"m5.94 8.504 12.125 7\" />"),
    AT_SIGN(
        "at-sign",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M16 8v5a3 3 0 0 0 6 0v-1a10 10 0 1 0-4 8\" />"),
    BASELINE(
        "baseline",
        "<path d=\"M4 20h16\" />\n  <path d=\"m6 16 6-12 6 12\" />\n  <path d=\"M8 12h8\" />"),
    BINARY(
        "binary",
        "<rect x=\"14\" y=\"14\" width=\"4\" height=\"6\" rx=\"2\" />\n  <rect x=\"6\" y=\"4\" width=\"4\" height=\"6\" rx=\"2\" />\n  <path d=\"M6 20h4\" />\n  <path d=\"M14 10h4\" />\n  <path d=\"M6 14h2v6\" />\n  <path d=\"M14 4h2v6\" />"),
    BOLD(
        "bold",
        "<path d=\"M6 12h9a4 4 0 0 1 0 8H7a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1h7a4 4 0 0 1 0 8\" />"),
    BOOK(
        "book",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BOOK_A(
        "book-a",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m8 13 4-7 4 7\" />\n  <path d=\"M9.1 11h5.7\" />"),
    BOOK_ALERT(
        "book-alert",
        "<path d=\"M12 13h.01\" />\n  <path d=\"M12 6v3\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BOOK_AUDIO(
        "book-audio",
        "<path d=\"M12 6v7\" />\n  <path d=\"M16 8v3\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8 8v3\" />"),
    BOOK_BOOKMARK(
        "book-bookmark",
        "<path d=\"M10 2v7.751a.25.25 0 00.407.195l2.28-1.834a.5.5 0 01.627 0l2.28 1.834A.25.25 0 0016 9.751V2\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 016.5 2H19a1 1 0 011 1v18a1 1 0 01-1 1H6.5a1 1 0 010-5H20\" />"),
    BOOK_CHECK(
        "book-check",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m9 9.5 2 2 4-4\" />"),
    BOOK_COPY(
        "book-copy",
        "<path d=\"M5 7a2 2 0 0 0-2 2v11\" />\n  <path d=\"M5.803 18H5a2 2 0 0 0 0 4h9.5a.5.5 0 0 0 .5-.5V21\" />\n  <path d=\"M9 15V4a2 2 0 0 1 2-2h9.5a.5.5 0 0 1 .5.5v14a.5.5 0 0 1-.5.5H11a2 2 0 0 1 0-4h10\" />"),
    BOOK_HEADPHONES(
        "book-headphones",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8 12v-2a4 4 0 0 1 8 0v2\" />\n  <circle cx=\"15\" cy=\"12\" r=\"1\" />\n  <circle cx=\"9\" cy=\"12\" r=\"1\" />"),
    BOOK_HEART(
        "book-heart",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8.62 9.8A2.25 2.25 0 1 1 12 6.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a.998.998 0 0 1-1.507 0z\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
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
    BOOK_TEXT(
        "book-text",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h6\" />"),
    BOOK_TYPE(
        "book-type",
        "<path d=\"M10 13h4\" />\n  <path d=\"M12 6v7\" />\n  <path d=\"M16 8V6H8v2\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />"),
    BOOK_X(
        "book-x",
        "<path d=\"m14.5 7.5-5 5\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"m9.5 7.5 5 5\" />"),
    BRUSH(
        "brush",
        "<path d=\"m11 10 3 3\" />\n  <path d=\"M6.5 21A3.5 3.5 0 1 0 3 17.5a2.62 2.62 0 0 1-.708 1.792A1 1 0 0 0 3 21z\" />\n  <path d=\"M9.969 17.031 21.378 5.624a1 1 0 0 0-3.002-3.002L6.967 14.031\" />"),
    CASE_LOWER(
        "case-lower",
        "<path d=\"M10 9v7\" />\n  <path d=\"M14 6v10\" />\n  <circle cx=\"17.5\" cy=\"12.5\" r=\"3.5\" />\n  <circle cx=\"6.5\" cy=\"12.5\" r=\"3.5\" />"),
    CASE_SENSITIVE(
        "case-sensitive",
        "<path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M22 9v7\" />\n  <path d=\"M3.304 13h6.392\" />\n  <circle cx=\"18.5\" cy=\"12.5\" r=\"3.5\" />"),
    CASE_UPPER(
        "case-upper",
        "<path d=\"M15 11h4.5a1 1 0 0 1 0 5h-4a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h3a1 1 0 0 1 0 5\" />\n  <path d=\"m2 16 4.039-9.69a.5.5 0 0 1 .923 0L11 16\" />\n  <path d=\"M3.304 13h6.392\" />"),
    CIRCLE_QUESTION_MARK(
        "circle-question-mark",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3\" />\n  <path d=\"M12 17h.01\" />"),
    CLIPBOARD(
        "clipboard",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />"),
    CLIPBOARD_CHECK(
        "clipboard-check",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"m9 14 2 2 4-4\" />"),
    CLIPBOARD_CLOCK(
        "clipboard-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v.832\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h2\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />\n  <rect x=\"8\" y=\"2\" width=\"8\" height=\"4\" rx=\"1\" />"),
    CLIPBOARD_COPY(
        "clipboard-copy",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v4\" />\n  <path d=\"M21 14H11\" />\n  <path d=\"m15 10-4 4 4 4\" />"),
    CLIPBOARD_LIST(
        "clipboard-list",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M12 11h4\" />\n  <path d=\"M12 16h4\" />\n  <path d=\"M8 11h.01\" />\n  <path d=\"M8 16h.01\" />"),
    CLIPBOARD_MINUS(
        "clipboard-minus",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M9 14h6\" />"),
    CLIPBOARD_PASTE(
        "clipboard-paste",
        "<path d=\"M11 14h10\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v1.344\" />\n  <path d=\"m17 18 4-4-4-4\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h12a2 2 0 0 0 1.793-1.113\" />\n  <rect x=\"8\" y=\"2\" width=\"8\" height=\"4\" rx=\"1\" />"),
    CLIPBOARD_PEN(
        "clipboard-pen",
        "<path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21.34 15.664a1 1 0 1 0-3.004-3.004l-5.01 5.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />\n  <path d=\"M8 22H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <rect x=\"8\" y=\"2\" width=\"8\" height=\"4\" rx=\"1\" />"),
    CLIPBOARD_PEN_LINE(
        "clipboard-pen-line",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" />\n  <path d=\"M8 4H6a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-.5\" />\n  <path d=\"M16 4h2a2 2 0 0 1 1.73 1\" />\n  <path d=\"M8 18h1\" />\n  <path d=\"M21.378 12.626a1 1 0 0 0-3.004-3.004l-4.01 4.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />"),
    CLIPBOARD_PLUS(
        "clipboard-plus",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M9 14h6\" />\n  <path d=\"M12 17v-6\" />"),
    CLIPBOARD_TYPE(
        "clipboard-type",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M9 12v-1h6v1\" />\n  <path d=\"M11 17h2\" />\n  <path d=\"M12 11v6\" />"),
    CLIPBOARD_X(
        "clipboard-x",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"m14.5 11.5-5 5\" />\n  <path d=\"m9.5 11.5 5 5\" />"),
    CODE("code", "<path d=\"m16 18 6-6-6-6\" />\n  <path d=\"m8 6-6 6 6 6\" />"),
    CODE_XML(
        "code-xml",
        "<path d=\"m18 16 4-4-4-4\" />\n  <path d=\"m6 8-4 4 4 4\" />\n  <path d=\"m14.5 4-5 16\" />"),
    COLUMNS_2(
        "columns-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 3v18\" />"),
    COLUMNS_3(
        "columns-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    COLUMNS_4(
        "columns-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7.5 3v18\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M16.5 3v18\" />"),
    COPY(
        "copy",
        "<rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_CHECK(
        "copy-check",
        "<path d=\"m12 15 2 2 4-4\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_MINUS(
        "copy-minus",
        "<line x1=\"12\" x2=\"18\" y1=\"15\" y2=\"15\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_PLUS(
        "copy-plus",
        "<line x1=\"15\" x2=\"15\" y1=\"12\" y2=\"18\" />\n  <line x1=\"12\" x2=\"18\" y1=\"15\" y2=\"15\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPY_SLASH(
        "copy-slash",
        "<line x1=\"12\" x2=\"18\" y1=\"18\" y2=\"12\" />\n  <rect width=\"14\" height=\"14\" x=\"8\" y=\"8\" rx=\"2\" ry=\"2\" />\n  <path d=\"M4 16c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h10c1.1 0 2 .9 2 2\" />"),
    COPYLEFT(
        "copyleft",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9.17 14.83a4 4 0 1 0 0-5.66\" />"),
    COPYRIGHT(
        "copyright",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M14.83 14.83a4 4 0 1 1 0-5.66\" />"),
    CORNER_DOWN_RIGHT(
        "corner-down-right",
        "<path d=\"m15 10 5 5-5 5\" />\n  <path d=\"M4 4v7a4 4 0 0 0 4 4h12\" />"),
    CREATIVE_COMMONS(
        "creative-commons",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M10 9.3a2.8 2.8 0 0 0-3.5 1 3.1 3.1 0 0 0 0 3.4 2.7 2.7 0 0 0 3.5 1\" />\n  <path d=\"M17 9.3a2.8 2.8 0 0 0-3.5 1 3.1 3.1 0 0 0 0 3.4 2.7 2.7 0 0 0 3.5 1\" />"),
    DECIMALS_ARROW_LEFT(
        "decimals-arrow-left",
        "<path d=\"m13 21-3-3 3-3\" />\n  <path d=\"M20 18H10\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DECIMALS_ARROW_RIGHT(
        "decimals-arrow-right",
        "<path d=\"M10 18h10\" />\n  <path d=\"m17 21 3-3-3-3\" />\n  <path d=\"M3 11h.01\" />\n  <rect x=\"15\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />\n  <rect x=\"6\" y=\"3\" width=\"5\" height=\"8\" rx=\"2.5\" />"),
    DELETE(
        "delete",
        "<path d=\"M10 5a2 2 0 0 0-1.344.519l-6.328 5.74a1 1 0 0 0 0 1.481l6.328 5.741A2 2 0 0 0 10 19h10a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2z\" />\n  <path d=\"m12 9 6 6\" />\n  <path d=\"m18 9-6 6\" />"),
    DOT("dot", "<circle cx=\"12\" cy=\"12\" r=\"1\" />"),
    ERASER(
        "eraser",
        "<path d=\"M21 21H8a2 2 0 0 1-1.42-.587l-3.994-3.999a2 2 0 0 1 0-2.828l10-10a2 2 0 0 1 2.829 0l5.999 6a2 2 0 0 1 0 2.828L12.834 21\" />\n  <path d=\"m5.082 11.09 8.828 8.828\" />"),
    EXPAND(
        "expand",
        "<path d=\"m15 15 6 6\" />\n  <path d=\"m15 9 6-6\" />\n  <path d=\"M21 16v5h-5\" />\n  <path d=\"M21 8V3h-5\" />\n  <path d=\"M3 16v5h5\" />\n  <path d=\"m3 21 6-6\" />\n  <path d=\"M3 8V3h5\" />\n  <path d=\"M9 9 3 3\" />"),
    EXTERNAL_LINK(
        "external-link",
        "<path d=\"M15 3h6v6\" />\n  <path d=\"M10 14 21 3\" />\n  <path d=\"M18 13v6a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h6\" />"),
    FEATHER(
        "feather",
        "<path d=\"M14.086 18.412A2 2 0 0112.67 19H5v-7.672a2 2 0 01.586-1.414L11.75 3.75a6 6 0 118.49 8.49z\" />\n  <path d=\"M16 8 2 22\" />\n  <path d=\"M17.488 15H9\" />"),
    FILE_TEXT(
        "file-text",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 9H8\" />\n  <path d=\"M16 13H8\" />\n  <path d=\"M16 17H8\" />"),
    FILE_TYPE(
        "file-type",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M12 12v6\" />\n  <path d=\"M9 13v-.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 .5.5v.5\" />"),
    FILE_TYPE_CORNER(
        "file-type-corner",
        "<path d=\"M12 22h6a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v6\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M3 16v-1.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5V16\" />\n  <path d=\"M6 22h2\" />\n  <path d=\"M7 14v8\" />"),
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
    HASH(
        "hash",
        "<line x1=\"4\" x2=\"20\" y1=\"9\" y2=\"9\" />\n  <line x1=\"4\" x2=\"20\" y1=\"15\" y2=\"15\" />\n  <line x1=\"10\" x2=\"8\" y1=\"3\" y2=\"21\" />\n  <line x1=\"16\" x2=\"14\" y1=\"3\" y2=\"21\" />"),
    HEADING(
        "heading", "<path d=\"M6 12h12\" />\n  <path d=\"M6 20V4\" />\n  <path d=\"M18 20V4\" />"),
    HEADING_1(
        "heading-1",
        "<path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />\n  <path d=\"M12 18V6\" />\n  <path d=\"m17 12 3-2v8\" />"),
    HEADING_2(
        "heading-2",
        "<path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />\n  <path d=\"M12 18V6\" />\n  <path d=\"M21 18h-4c0-4 4-3 4-6 0-1.5-2-2.5-4-1\" />"),
    HEADING_3(
        "heading-3",
        "<path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />\n  <path d=\"M12 18V6\" />\n  <path d=\"M17.5 10.5c1.7-1 3.5 0 3.5 1.5a2 2 0 0 1-2 2\" />\n  <path d=\"M17 17.5c2 1.5 4 .3 4-1.5a2 2 0 0 0-2-2\" />"),
    HEADING_4(
        "heading-4",
        "<path d=\"M12 18V6\" />\n  <path d=\"M17 10v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M21 10v8\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />"),
    HEADING_5(
        "heading-5",
        "<path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />\n  <path d=\"M12 18V6\" />\n  <path d=\"M17 13v-3h4\" />\n  <path d=\"M17 17.7c.4.2.8.3 1.3.3 1.5 0 2.7-1.1 2.7-2.5S19.8 13 18.3 13H17\" />"),
    HEADING_6(
        "heading-6",
        "<path d=\"M4 12h8\" />\n  <path d=\"M4 18V6\" />\n  <path d=\"M12 18V6\" />\n  <circle cx=\"19\" cy=\"16\" r=\"2\" />\n  <path d=\"M20 10c-2 2-3 3.5-3 6\" />"),
    HIGHLIGHTER(
        "highlighter",
        "<path d=\"m9 11-6 6v3h9l3-3\" />\n  <path d=\"m22 12-4.6 4.6a2 2 0 0 1-2.8 0l-5.2-5.2a2 2 0 0 1 0-2.8L14 4\" />"),
    IMAGE(
        "image",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_DOWN(
        "image-down",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19 3 3v-5.5\" />\n  <path d=\"m17 22 3-3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_PLAY(
        "image-play",
        "<path d=\"M15 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M21 12.17V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />\n  <path d=\"m6 21 5-5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UP(
        "image-up",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19.5 3-3 3 3\" />\n  <path d=\"M17 22v-5.5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGES(
        "images",
        "<path d=\"m22 11-1.296-1.296a2.4 2.4 0 0 0-3.408 0L11 16\" />\n  <path d=\"M4 8a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2\" />\n  <circle cx=\"13\" cy=\"7\" r=\"1\" fill=\"currentColor\" />\n  <rect x=\"8\" y=\"2\" width=\"14\" height=\"14\" rx=\"2\" />"),
    ITALIC(
        "italic",
        "<line x1=\"19\" x2=\"10\" y1=\"4\" y2=\"4\" />\n  <line x1=\"14\" x2=\"5\" y1=\"20\" y2=\"20\" />\n  <line x1=\"15\" x2=\"9\" y1=\"4\" y2=\"20\" />"),
    KEYBOARD(
        "keyboard",
        "<path d=\"M10 8h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M7 16h10\" />\n  <path d=\"M8 12h.01\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />"),
    KEYBOARD_OFF(
        "keyboard-off",
        "<path d=\"M 20 4 A2 2 0 0 1 22 6\" />\n  <path d=\"M 22 6 L 22 16.41\" />\n  <path d=\"M 7 16 L 16 16\" />\n  <path d=\"M 9.69 4 L 20 4\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M8 12h.01\" />"),
    LAMBDA(
        "lambda",
        "<path d=\"M11.38 10 5 20\" />\n  <path d=\"M19 18a2 2 0 01-2 2c-4.87-.003-5.052-16-10-16a2 2 0 00-2 2\" />"),
    LANGUAGES(
        "languages",
        "<path d=\"m5 8 6 6\" />\n  <path d=\"m4 14 6-6 2-3\" />\n  <path d=\"M2 5h12\" />\n  <path d=\"M7 2h1\" />\n  <path d=\"m22 22-5-10-5 10\" />\n  <path d=\"M14 18h6\" />"),
    LAYOUT_LIST(
        "layout-list",
        "<rect width=\"7\" height=\"7\" x=\"3\" y=\"3\" rx=\"1\" />\n  <rect width=\"7\" height=\"7\" x=\"3\" y=\"14\" rx=\"1\" />\n  <path d=\"M14 4h7\" />\n  <path d=\"M14 9h7\" />\n  <path d=\"M14 15h7\" />\n  <path d=\"M14 20h7\" />"),
    LETTER_SPACING(
        "letter-spacing",
        "<path d=\"M15 14H9\" />\n  <path d=\"M21 3v18\" />\n  <path d=\"M3 3v18\" />\n  <path d=\"m8 16 3.453-7.648a.6.6 0 011.094.001L16 16\" />"),
    LETTERS(
        "letters",
        "<path d=\"M15 8H9\" />\n  <path d=\"M21 15.354a4 4 0 100 5.292\" />\n  <path d=\"M3 18h4a2 2 0 010 4H3.5a.5.5 0 01-.5-.5v-7a.5.5 0 01.5-.5H6a2 2 0 010 4\" />\n  <path d=\"m8 10 3.453-7.648a.6.6 0 011.094 0L16 10\" />"),
    LIBRARY(
        "library",
        "<path d=\"m16 6 4 14\" />\n  <path d=\"M12 6v14\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M4 4v16\" />"),
    LIBRARY_BIG(
        "library-big",
        "<rect width=\"8\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M20.4 18.9c.2.5-.1 1.1-.6 1.3l-1.9.7c-.5.2-1.1-.1-1.3-.6L11.1 5.1c-.2-.5.1-1.1.6-1.3l1.9-.7c.5-.2 1.1.1 1.3.6Z\" />"),
    LIGATURE(
        "ligature",
        "<path d=\"M14 12h2v8\" />\n  <path d=\"M14 20h4\" />\n  <path d=\"M6 12h4\" />\n  <path d=\"M6 20h4\" />\n  <path d=\"M8 20V8a4 4 0 0 1 7.464-2\" />"),
    LINE_HEIGHT(
        "line-height",
        "<path d=\"M15 14H9\" />\n  <path d=\"M21 21H3\" />\n  <path d=\"M21 3H3\" />\n  <path d=\"m8 16 3.453-7.648a.6.6 0 011.094.001L16 16\" />"),
    LINK(
        "link",
        "<path d=\"M10 13a5 5 0 0 0 7.54.54l3-3a5 5 0 0 0-7.07-7.07l-1.72 1.71\" />\n  <path d=\"M14 11a5 5 0 0 0-7.54-.54l-3 3a5 5 0 0 0 7.07 7.07l1.71-1.71\" />"),
    LINK_2(
        "link-2",
        "<path d=\"M9 17H7A5 5 0 0 1 7 7h2\" />\n  <path d=\"M15 7h2a5 5 0 1 1 0 10h-2\" />\n  <line x1=\"8\" x2=\"16\" y1=\"12\" y2=\"12\" />"),
    LINK_2_OFF(
        "link-2-off",
        "<path d=\"M9 17H7A5 5 0 0 1 7 7\" />\n  <path d=\"M15 7h2a5 5 0 0 1 4 8\" />\n  <line x1=\"8\" x2=\"12\" y1=\"12\" y2=\"12\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    LIST(
        "list",
        "<path d=\"M3 5h.01\" />\n  <path d=\"M3 12h.01\" />\n  <path d=\"M3 19h.01\" />\n  <path d=\"M8 5h13\" />\n  <path d=\"M8 12h13\" />\n  <path d=\"M8 19h13\" />"),
    LIST_CHECK(
        "list-check",
        "<path d=\"M16 5H3\" />\n  <path d=\"M16 12H3\" />\n  <path d=\"M11 19H3\" />\n  <path d=\"m15 18 2 2 4-4\" />"),
    LIST_CHECKS(
        "list-checks",
        "<path d=\"M13 5h8\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />\n  <path d=\"m3 17 2 2 4-4\" />\n  <path d=\"m3 7 2 2 4-4\" />"),
    LIST_CHEVRONS_DOWN_UP(
        "list-chevrons-down-up",
        "<path d=\"M3 5h8\" />\n  <path d=\"M3 12h8\" />\n  <path d=\"M3 19h8\" />\n  <path d=\"m15 5 3 3 3-3\" />\n  <path d=\"m15 19 3-3 3 3\" />"),
    LIST_CHEVRONS_UP_DOWN(
        "list-chevrons-up-down",
        "<path d=\"M3 5h8\" />\n  <path d=\"M3 12h8\" />\n  <path d=\"M3 19h8\" />\n  <path d=\"m15 8 3-3 3 3\" />\n  <path d=\"m15 16 3 3 3-3\" />"),
    LIST_CLOCK(
        "list-clock",
        "<path d=\"M16 13v2.2l1.6 1\" />\n  <path d=\"M3 12h3.458\" />\n  <path d=\"M3 19h3.832\" />\n  <path d=\"M3 5h18\" />\n  <circle cx=\"16\" cy=\"15\" r=\"6\" />"),
    LIST_COLLAPSE(
        "list-collapse",
        "<path d=\"M10 5h11\" />\n  <path d=\"M10 12h11\" />\n  <path d=\"M10 19h11\" />\n  <path d=\"m3 10 3-3-3-3\" />\n  <path d=\"m3 20 3-3-3-3\" />"),
    LIST_END(
        "list-end",
        "<path d=\"M16 5H3\" />\n  <path d=\"M16 12H3\" />\n  <path d=\"M9 19H3\" />\n  <path d=\"m16 16-3 3 3 3\" />\n  <path d=\"M21 5v12a2 2 0 0 1-2 2h-6\" />"),
    LIST_FILTER(
        "list-filter",
        "<path d=\"M2 5h20\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 19h6\" />"),
    LIST_FILTER_PLUS(
        "list-filter-plus",
        "<path d=\"M12 5H2\" />\n  <path d=\"M6 12h12\" />\n  <path d=\"M9 19h6\" />\n  <path d=\"M16 5h6\" />\n  <path d=\"M19 8V2\" />"),
    LIST_INDENT_DECREASE(
        "list-indent-decrease",
        "<path d=\"M21 5H11\" />\n  <path d=\"M21 12H11\" />\n  <path d=\"M21 19H11\" />\n  <path d=\"m7 8-4 4 4 4\" />"),
    LIST_INDENT_INCREASE(
        "list-indent-increase",
        "<path d=\"M21 5H11\" />\n  <path d=\"M21 12H11\" />\n  <path d=\"M21 19H11\" />\n  <path d=\"m3 8 4 4-4 4\" />"),
    LIST_MINUS(
        "list-minus",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"M21 12h-6\" />"),
    LIST_ORDERED(
        "list-ordered",
        "<path d=\"M11 5h10\" />\n  <path d=\"M11 12h10\" />\n  <path d=\"M11 19h10\" />\n  <path d=\"M4 4h1v5\" />\n  <path d=\"M4 9h2\" />\n  <path d=\"M6.5 20H3.4c0-1 2.6-1.925 2.6-3.5a1.5 1.5 0 0 0-2.6-1.02\" />"),
    LIST_PLUS(
        "list-plus",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"M18 9v6\" />\n  <path d=\"M21 12h-6\" />"),
    LIST_RESTART(
        "list-restart",
        "<path d=\"M21 5H3\" />\n  <path d=\"M7 12H3\" />\n  <path d=\"M7 19H3\" />\n  <path d=\"M12 18a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L11 14\" />\n  <path d=\"M11 10v4h4\" />"),
    LIST_SORT_ASCENDING(
        "list-sort-ascending",
        "<path d=\"M3 19h18\" />\n  <path d=\"M15 12H3\" />\n  <path d=\"M9 5H3\" />"),
    LIST_SORT_DESCENDING(
        "list-sort-descending",
        "<path d=\"M15 12H3\" />\n  <path d=\"M3 5h18\" />\n  <path d=\"M9 19H3\" />"),
    LIST_START(
        "list-start",
        "<path d=\"M3 5h6\" />\n  <path d=\"M3 12h13\" />\n  <path d=\"M3 19h13\" />\n  <path d=\"m16 8-3-3 3-3\" />\n  <path d=\"M21 19V7a2 2 0 0 0-2-2h-6\" />"),
    LIST_TODO(
        "list-todo",
        "<path d=\"M13 5h8\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />\n  <path d=\"m3 17 2 2 4-4\" />\n  <rect x=\"3\" y=\"4\" width=\"6\" height=\"6\" rx=\"1\" />"),
    LIST_TREE(
        "list-tree",
        "<path d=\"M8 5h13\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />\n  <path d=\"M3 10a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 5v12a2 2 0 0 0 2 2h3\" />"),
    LIST_X(
        "list-x",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"m15.5 9.5 5 5\" />\n  <path d=\"m20.5 9.5-5 5\" />"),
    LOGS(
        "logs",
        "<path d=\"M3 5h1\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M3 19h1\" />\n  <path d=\"M8 5h1\" />\n  <path d=\"M8 12h1\" />\n  <path d=\"M8 19h1\" />\n  <path d=\"M13 5h8\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />"),
    MAIL(
        "mail",
        "<path d=\"m22 7-8.991 5.727a2 2 0 0 1-2.009 0L2 7\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    MAIL_CLOCK(
        "mail-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"m22 7-.759.484\" />\n  <path d=\"M6.835 20H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v2\" />\n  <path d=\"M7.605 10.567 2 7\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    MAIL_DOT(
        "mail-dot",
        "<path d=\"M12.674 4H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4.675\" />\n  <path d=\"m2 7 9 5.701a2 2 0 0 0 2 0l1.084-.686\" />\n  <circle cx=\"19\" cy=\"7\" r=\"3\" />"),
    MAP(
        "map",
        "<path d=\"M14.106 5.553a2 2 0 0 0 1.788 0l3.659-1.83A1 1 0 0 1 21 4.619v12.764a1 1 0 0 1-.553.894l-4.553 2.277a2 2 0 0 1-1.788 0l-4.212-2.106a2 2 0 0 0-1.788 0l-3.659 1.83A1 1 0 0 1 3 19.381V6.618a1 1 0 0 1 .553-.894l4.553-2.277a2 2 0 0 1 1.788 0z\" />\n  <path d=\"M15 5.764v15\" />\n  <path d=\"M9 3.236v15\" />"),
    MAP_PIN_SEARCH(
        "map-pin-search",
        "<path d=\"M 12.248 21.969 a 1 1 0 0 1 -0.849 -0.17 C 9.539 20.193 4 14.993 4 10 a 8 8 0 0 1 16 0 C 20 10.42 19.961 10.841 19.888 11.262\" />\n  <path d=\"m22 22-1.88-1.88\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    MESSAGE_SQUARE_QUOTE(
        "message-square-quote",
        "<path d=\"M14 14a2 2 0 0 0 2-2V8h-2\" />\n  <path d=\"M22 17a2 2 0 0 1-2 2H6.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 2 21.286V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2z\" />\n  <path d=\"M8 14a2 2 0 0 0 2-2V8H8\" />"),
    MINUS("minus", "<path d=\"M5 12h14\" />"),
    NOTEBOOK(
        "notebook",
        "<path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M16 2v20\" />"),
    NOTEBOOK_PEN(
        "notebook-pen",
        "<path d=\"M13.4 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-7.4\" />\n  <path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <path d=\"M21.378 5.626a1 1 0 1 0-3.004-3.004l-5.01 5.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />"),
    NOTEBOOK_TEXT(
        "notebook-text",
        "<path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M9.5 8h5\" />\n  <path d=\"M9.5 12H16\" />\n  <path d=\"M9.5 16H14\" />"),
    NOTEPAD_TEXT(
        "notepad-text",
        "<path d=\"M8 2v4\" />\n  <path d=\"M12 2v4\" />\n  <path d=\"M16 2v4\" />\n  <rect width=\"16\" height=\"18\" x=\"4\" y=\"4\" rx=\"2\" />\n  <path d=\"M8 10h6\" />\n  <path d=\"M8 14h8\" />\n  <path d=\"M8 18h5\" />"),
    NOTEPAD_TEXT_DASHED(
        "notepad-text-dashed",
        "<path d=\"M8 2v4\" />\n  <path d=\"M12 2v4\" />\n  <path d=\"M16 2v4\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M20 12v2\" />\n  <path d=\"M20 18v2a2 2 0 0 1-2 2h-1\" />\n  <path d=\"M13 22h-2\" />\n  <path d=\"M7 22H6a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M4 14v-2\" />\n  <path d=\"M4 8V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M8 10h6\" />\n  <path d=\"M8 14h8\" />\n  <path d=\"M8 18h5\" />"),
    OMEGA(
        "omega",
        "<path d=\"M3 20h4.5a.5.5 0 0 0 .5-.5v-.282a.52.52 0 0 0-.247-.437 8 8 0 1 1 8.494-.001.52.52 0 0 0-.247.438v.282a.5.5 0 0 0 .5.5H21\" />"),
    PAINT_ROLLER(
        "paint-roller",
        "<rect width=\"16\" height=\"6\" x=\"2\" y=\"2\" rx=\"2\" />\n  <path d=\"M10 16v-2a2 2 0 0 1 2-2h8a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />\n  <rect width=\"4\" height=\"6\" x=\"8\" y=\"16\" rx=\"1\" />"),
    PAINTBRUSH(
        "paintbrush",
        "<path d=\"m14.622 17.897-10.68-2.913\" />\n  <path d=\"M18.376 2.622a1 1 0 1 1 3.002 3.002L17.36 9.643a.5.5 0 0 0 0 .707l.944.944a2.41 2.41 0 0 1 0 3.408l-.944.944a.5.5 0 0 1-.707 0L8.354 7.348a.5.5 0 0 1 0-.707l.944-.944a2.41 2.41 0 0 1 3.408 0l.944.944a.5.5 0 0 0 .707 0z\" />\n  <path d=\"M9 8c-1.804 2.71-3.97 3.46-6.583 3.948a.507.507 0 0 0-.302.819l7.32 8.883a1 1 0 0 0 1.185.204C12.735 20.405 16 16.792 16 15\" />"),
    PAINTBRUSH_VERTICAL(
        "paintbrush-vertical",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v4\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v9H6V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 12a1 1 0 0 0-1 1v1a2 2 0 0 0 2 2h2a1 1 0 0 1 1 1v2.9a2 2 0 1 0 4 0V17a1 1 0 0 1 1-1h2a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1\" />"),
    PALETTE(
        "palette",
        "<path d=\"M12 22a1 1 0 0 1 0-20 10 9 0 0 1 10 9 5 5 0 0 1-5 5h-2.25a1.75 1.75 0 0 0-1.4 2.8l.3.4a1.75 1.75 0 0 1-1.4 2.8z\" />\n  <circle cx=\"13.5\" cy=\"6.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"17.5\" cy=\"10.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"6.5\" cy=\"12.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"8.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />"),
    PAPERCLIP(
        "paperclip",
        "<path d=\"m16 6-8.414 8.586a2 2 0 0 0 2.829 2.829l8.414-8.586a4 4 0 1 0-5.657-5.657l-8.379 8.551a6 6 0 1 0 8.485 8.485l8.379-8.551\" />"),
    PEN(
        "pen",
        "<path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_LINE(
        "pen-line",
        "<path d=\"M13 21h8\" />\n  <path d=\"M21.174 6.812a1 1 0 0 0-3.986-3.987L3.842 16.174a2 2 0 0 0-.5.83l-1.321 4.352a.5.5 0 0 0 .623.622l4.353-1.32a2 2 0 0 0 .83-.497z\" />"),
    PEN_OFF(
        "pen-off",
        "<path d=\"m10 10-6.157 6.162a2 2 0 0 0-.5.833l-1.322 4.36a.5.5 0 0 0 .622.624l4.358-1.323a2 2 0 0 0 .83-.5L14 13.982\" />\n  <path d=\"m12.829 7.172 4.359-4.346a1 1 0 1 1 3.986 3.986l-4.353 4.353\" />\n  <path d=\"m2 2 20 20\" />"),
    PEN_TOOL(
        "pen-tool",
        "<path d=\"m18 13-.654-4.736a4 4 0 00-2.756-3.266l-9.163-2.9a2 2 0 00-2.017.493l-.82.819a2 2 0 00-.492 2.017l2.9 9.163a4 4 0 003.266 2.756L13 18\" />\n  <path d=\"M18.648 12.352a1.205 1.205 0 011.704 0l1.296 1.296a1.205 1.205 0 010 1.704l-6.296 6.296a1.205 1.205 0 01-1.704 0l-1.296-1.296a1.205 1.205 0 010-1.704z\" />\n  <path d=\"m3 3 6.586 6.586\" />\n  <circle cx=\"11\" cy=\"11\" r=\"2\" />"),
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
    PHONE(
        "phone",
        "<path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PILCROW(
        "pilcrow",
        "<path d=\"M13 4v16\" />\n  <path d=\"M17 4v16\" />\n  <path d=\"M19 4H9.5a4.5 4.5 0 0 0 0 9H13\" />"),
    PILCROW_LEFT(
        "pilcrow-left",
        "<path d=\"M14 3v11\" />\n  <path d=\"M14 9h-3a3 3 0 0 1 0-6h9\" />\n  <path d=\"M18 3v11\" />\n  <path d=\"M22 18H2l4-4\" />\n  <path d=\"m6 22-4-4\" />"),
    PILCROW_RIGHT(
        "pilcrow-right",
        "<path d=\"M10 3v11\" />\n  <path d=\"M10 9H7a1 1 0 0 1 0-6h8\" />\n  <path d=\"M14 3v11\" />\n  <path d=\"m18 14 4 4H2\" />\n  <path d=\"m22 18-4 4\" />"),
    PIPETTE(
        "pipette",
        "<path d=\"m12 9-8.414 8.414A2 2 0 0 0 3 18.828v1.344a2 2 0 0 1-.586 1.414A2 2 0 0 1 3.828 21h1.344a2 2 0 0 0 1.414-.586L15 12\" />\n  <path d=\"m18 9 .4.4a1 1 0 1 1-3 3l-3.8-3.8a1 1 0 1 1 3-3l.4.4 3.4-3.4a1 1 0 1 1 3 3z\" />\n  <path d=\"m2 22 .414-.414\" />"),
    PLUS("plus", "<path d=\"M5 12h14\" />\n  <path d=\"M12 5v14\" />"),
    QUOTE(
        "quote",
        "<path d=\"M16 3a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2 1 1 0 0 1 1 1v1a2 2 0 0 1-2 2 1 1 0 0 0-1 1v2a1 1 0 0 0 1 1 6 6 0 0 0 6-6V5a2 2 0 0 0-2-2z\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2 1 1 0 0 1 1 1v1a2 2 0 0 1-2 2 1 1 0 0 0-1 1v2a1 1 0 0 0 1 1 6 6 0 0 0 6-6V5a2 2 0 0 0-2-2z\" />"),
    RECTANGLE_CIRCLE(
        "rectangle-circle",
        "<path d=\"M14 4v16H3a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1z\" />\n  <circle cx=\"14\" cy=\"12\" r=\"8\" />"),
    RECTANGLE_ELLIPSIS(
        "rectangle-ellipsis",
        "<rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M17 12h.01\" />\n  <path d=\"M7 12h.01\" />"),
    REDO(
        "redo",
        "<path d=\"M21 7v6h-6\" />\n  <path d=\"M3 17a9 9 0 0 1 9-9 9 9 0 0 1 6 2.3l3 2.7\" />"),
    REDO_2(
        "redo-2",
        "<path d=\"m15 14 5-5-5-5\" />\n  <path d=\"M20 9H9.5A5.5 5.5 0 0 0 4 14.5A5.5 5.5 0 0 0 9.5 20H13\" />"),
    REDO_DOT(
        "redo-dot",
        "<circle cx=\"12\" cy=\"17\" r=\"1\" />\n  <path d=\"M21 7v6h-6\" />\n  <path d=\"M3 17a9 9 0 0 1 9-9 9 9 0 0 1 6 2.3l3 2.7\" />"),
    REGEX(
        "regex",
        "<path d=\"M17 3v10\" />\n  <path d=\"m12.67 5.5 8.66 5\" />\n  <path d=\"m12.67 10.5 8.66-5\" />\n  <path d=\"M9 17a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2-2v-2z\" />"),
    REMOVE_FORMATTING(
        "remove-formatting",
        "<path d=\"M4 7V4h16v3\" />\n  <path d=\"M5 20h6\" />\n  <path d=\"M13 4 8 20\" />\n  <path d=\"m15 15 5 5\" />\n  <path d=\"m20 15-5 5\" />"),
    REPLACE(
        "replace",
        "<path d=\"M14 4a1 1 0 0 1 1-1\" />\n  <path d=\"M15 10a1 1 0 0 1-1-1\" />\n  <path d=\"M21 4a1 1 0 0 0-1-1\" />\n  <path d=\"M21 9a1 1 0 0 1-1 1\" />\n  <path d=\"m3 7 3 3 3-3\" />\n  <path d=\"M6 10V5a2 2 0 0 1 2-2h2\" />\n  <rect x=\"3\" y=\"14\" width=\"7\" height=\"7\" rx=\"1\" />"),
    REPLACE_ALL(
        "replace-all",
        "<path d=\"M14 14a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"M14 4a1 1 0 0 1 1-1\" />\n  <path d=\"M15 10a1 1 0 0 1-1-1\" />\n  <path d=\"M19 14a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"M21 4a1 1 0 0 0-1-1\" />\n  <path d=\"M21 9a1 1 0 0 1-1 1\" />\n  <path d=\"m3 7 3 3 3-3\" />\n  <path d=\"M6 10V5a2 2 0 0 1 2-2h2\" />\n  <rect x=\"3\" y=\"14\" width=\"7\" height=\"7\" rx=\"1\" />"),
    ROWS_2(
        "rows-2",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 12h18\" />"),
    ROWS_3(
        "rows-3",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    ROWS_4(
        "rows-4",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 7.5H3\" />\n  <path d=\"M21 12H3\" />\n  <path d=\"M21 16.5H3\" />"),
    SAVE(
        "save",
        "<path d=\"M15.2 3a2 2 0 0 1 1.4.6l3.8 3.8a2 2 0 0 1 .6 1.4V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2z\" />\n  <path d=\"M17 21v-7a1 1 0 0 0-1-1H8a1 1 0 0 0-1 1v7\" />\n  <path d=\"M7 3v4a1 1 0 0 0 1 1h7\" />"),
    SAVE_ALL(
        "save-all",
        "<path d=\"M10 2v3a1 1 0 0 0 1 1h5\" />\n  <path d=\"M18 18v-6a1 1 0 0 0-1-1h-6a1 1 0 0 0-1 1v6\" />\n  <path d=\"M18 22H4a2 2 0 0 1-2-2V6\" />\n  <path d=\"M8 18a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9.172a2 2 0 0 1 1.414.586l2.828 2.828A2 2 0 0 1 22 6.828V16a2 2 0 0 1-2.01 2z\" />"),
    SAVE_CHECK(
        "save-check",
        "<path d=\"M12.5 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h10.2a2 2 0 0 1 1.4.6l3.8 3.8a2 2 0 0 1 .6 1.4v4.35\" />\n  <path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M17 15.13V14a1 1 0 0 0-1-1H8a1 1 0 0 0-1 1v7\" />\n  <path d=\"M7 3v4a1 1 0 0 0 1 1h7\" />"),
    SAVE_OFF(
        "save-off",
        "<path d=\"M13 13H8a1 1 0 0 0-1 1v7\" />\n  <path d=\"M14 8h1\" />\n  <path d=\"M17 21v-4\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20.41 20.41A2 2 0 0 1 19 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 .59-1.41\" />\n  <path d=\"M9 3h6.2a2 2 0 0 1 1.4.6l3.8 3.8a2 2 0 0 1 .6 1.4V15\" />"),
    SAVE_PEN(
        "save-pen",
        "<path d=\"M13.33 13H8a1 1 0 00-1 1v7\" />\n  <path d=\"M14.363 17.634a2 2 0 00-.506.854l-.837 2.87a.5.5 0 00.62.62l2.87-.837a2 2 0 00.854-.506l4.013-4.009a1 1 0 10-3.004-3.004z\" />\n  <path d=\"M7 3v4a1 1 0 001 1h7\" />\n  <path d=\"M9 21H5a2 2 0 01-2-2V5a2 2 0 012-2h10.2a2 2 0 011.4.6l3.8 3.8a2 2 0 01.6 1.4v.3\" />"),
    SAVE_PLUS(
        "save-plus",
        "<path d=\"M12.5 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h10.2a2 2 0 0 1 1.4.6l3.8 3.8a2 2 0 0 1 .6 1.4V12\" />\n  <path d=\"M16 13H8a1 1 0 0 0-1 1v7\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19h-6\" />\n  <path d=\"M7 3v4a1 1 0 0 0 1 1h7\" />"),
    SCAN_TEXT(
        "scan-text",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />"),
    SCISSORS(
        "scissors",
        "<circle cx=\"6\" cy=\"6\" r=\"3\" />\n  <path d=\"M8.12 8.12 12 12\" />\n  <path d=\"M20 4 8.12 15.88\" />\n  <circle cx=\"6\" cy=\"18\" r=\"3\" />\n  <path d=\"M14.8 14.8 20 20\" />"),
    SCROLL(
        "scroll",
        "<path d=\"M19 17V5a2 2 0 0 0-2-2H4\" />\n  <path d=\"M8 21h12a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1H11a1 1 0 0 0-1 1v1a2 2 0 1 1-4 0V5a2 2 0 1 0-4 0v2a1 1 0 0 0 1 1h3\" />"),
    SCROLL_TEXT(
        "scroll-text",
        "<path d=\"M15 12h-5\" />\n  <path d=\"M15 8h-5\" />\n  <path d=\"M19 17V5a2 2 0 0 0-2-2H4\" />\n  <path d=\"M8 21h12a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1H11a1 1 0 0 0-1 1v1a2 2 0 1 1-4 0V5a2 2 0 1 0-4 0v2a1 1 0 0 0 1 1h3\" />"),
    SEARCH("search", "<path d=\"m21 21-4.34-4.34\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />"),
    SEARCH_ALERT(
        "search-alert",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <path d=\"m21 21-4.3-4.3\" />\n  <path d=\"M11 7v4\" />\n  <path d=\"M11 15h.01\" />"),
    SEARCH_CHECK(
        "search-check",
        "<path d=\"m8 11 2 2 4-4\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <path d=\"m21 21-4.3-4.3\" />"),
    SEARCH_CODE(
        "search-code",
        "<path d=\"m13 13.5 2-2.5-2-2.5\" />\n  <path d=\"m21 21-4.3-4.3\" />\n  <path d=\"M9 8.5 7 11l2 2.5\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />"),
    SEARCH_SLASH(
        "search-slash",
        "<path d=\"m13.5 8.5-5 5\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <path d=\"m21 21-4.3-4.3\" />"),
    SEARCH_X(
        "search-x",
        "<path d=\"m13.5 8.5-5 5\" />\n  <path d=\"m8.5 8.5 5 5\" />\n  <circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <path d=\"m21 21-4.3-4.3\" />"),
    SECTION(
        "section",
        "<path d=\"M16 5a4 3 0 0 0-8 0c0 4 8 3 8 7a4 3 0 0 1-8 0\" />\n  <path d=\"M8 19a4 3 0 0 0 8 0c0-4-8-3-8-7a4 3 0 0 1 8 0\" />"),
    SEPARATOR_HORIZONTAL(
        "separator-horizontal",
        "<path d=\"m16 16-4 4-4-4\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"m8 8 4-4 4 4\" />"),
    SEPARATOR_VERTICAL(
        "separator-vertical",
        "<path d=\"M12 3v18\" />\n  <path d=\"m16 16 4-4-4-4\" />\n  <path d=\"m8 8-4 4 4 4\" />"),
    SHEET(
        "sheet",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <line x1=\"3\" x2=\"21\" y1=\"9\" y2=\"9\" />\n  <line x1=\"3\" x2=\"21\" y1=\"15\" y2=\"15\" />\n  <line x1=\"9\" x2=\"9\" y1=\"9\" y2=\"21\" />\n  <line x1=\"15\" x2=\"15\" y1=\"9\" y2=\"21\" />"),
    SIGMA(
        "sigma",
        "<path d=\"M18 7V5a1 1 0 0 0-1-1H6.5a.5.5 0 0 0-.4.8l4.5 6a2 2 0 0 1 0 2.4l-4.5 6a.5.5 0 0 0 .4.8H17a1 1 0 0 0 1-1v-2\" />"),
    SIGNATURE(
        "signature",
        "<path d=\"m21 17-2.156-1.868A.5.5 0 0 0 18 15.5v.5a1 1 0 0 1-1 1h-2a1 1 0 0 1-1-1c0-2.545-3.991-3.97-8.5-4a1 1 0 0 0 0 5c4.153 0 4.745-11.295 5.708-13.5a2.5 2.5 0 1 1 3.31 3.284\" />\n  <path d=\"M3 21h18\" />"),
    SPACE("space", "<path d=\"M22 17v1c0 .5-.5 1-1 1H3c-.5 0-1-.5-1-1v-1\" />"),
    SPELL_CHECK(
        "spell-check",
        "<path d=\"m20 15-5.5 5.5L12 18\" />\n  <path d=\"m4 16 6-12 5.115 10.23\" />\n  <path d=\"M6 12h8\" />"),
    SPELL_CHECK_2(
        "spell-check-2",
        "<path d=\"m6 16 6-12 6 12\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M4 21c1.1 0 1.1-1 2.3-1s1.1 1 2.3 1c1.1 0 1.1-1 2.3-1 1.1 0 1.1 1 2.3 1 1.1 0 1.1-1 2.3-1 1.1 0 1.1 1 2.3 1 1.1 0 1.1-1 2.3-1\" />"),
    SQUARE_ASTERISK(
        "square-asterisk",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"m8.5 14 7-4\" />\n  <path d=\"m8.5 10 7 4\" />"),
    SQUARE_BOTTOM_DASHED_SCISSORS(
        "square-bottom-dashed-scissors",
        "<path d=\"M14 21h1\" />\n  <path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M5 21a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />"),
    SQUARE_CODE(
        "square-code",
        "<path d=\"m10 9-3 3 3 3\" />\n  <path d=\"m14 15 3-3-3-3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_DASHED(
        "square-dashed",
        "<path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M21 14v1\" />"),
    SQUARE_DASHED_TEXT(
        "square-dashed-text",
        "<path d=\"M14 21h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9 3h1\" />"),
    SQUARE_LIBRARY(
        "square-library",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7v10\" />\n  <path d=\"M11 7v10\" />\n  <path d=\"m15 7 2 10\" />"),
    SQUARE_MINUS(
        "square-minus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />"),
    SQUARE_PEN(
        "square-pen",
        "<path d=\"M12 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-7\" />\n  <path d=\"M18.375 2.625a1 1 0 0 1 3 3l-9.013 9.014a2 2 0 0 1-.853.505l-2.873.84a.5.5 0 0 1-.62-.62l.84-2.873a2 2 0 0 1 .506-.852z\" />"),
    SQUARE_PILCROW(
        "square-pilcrow",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 12H9.5a2.5 2.5 0 0 1 0-5H17\" />\n  <path d=\"M12 7v10\" />\n  <path d=\"M16 7v10\" />"),
    SQUARE_PLUS(
        "square-plus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M12 8v8\" />"),
    SQUARE_SCISSORS(
        "square-scissors",
        "<path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_SIGMA(
        "square-sigma",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M16 8.9V7H8l4 5-4 5h8v-1.9\" />"),
    SQUARE_SPARKLES(
        "square-sparkles",
        "<path d=\"M11 15H7\" />\n  <path d=\"M15.41 2.49a.6.6 0 011.18 0l.63 3.334a1.2 1.2 0 00.956.955l3.334.631a.6.6 0 010 1.18l-3.334.63a1.2 1.2 0 00-.955.956l-.631 3.334a.6.6 0 01-1.18 0l-.63-3.334a1.2 1.2 0 00-.956-.955L10.49 8.59a.6.6 0 010-1.18l3.334-.63a1.2 1.2 0 00.955-.956z\" />\n  <path d=\"M21 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V5a2 2 0 012-2h6\" />\n  <path d=\"M9 13v4\" />"),
    SQUARE_STACK(
        "square-stack",
        "<path d=\"M4 10c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <path d=\"M10 16c-1.1 0-2-.9-2-2v-4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <rect width=\"8\" height=\"8\" x=\"14\" y=\"14\" rx=\"2\" />"),
    SQUARE_TEXT(
        "square-text",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />"),
    STICKY_NOTE(
        "sticky-note",
        "<path d=\"M21 9a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 15 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2z\" />\n  <path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />"),
    STICKY_NOTE_CHECK(
        "sticky-note-check",
        "<path d=\"m15 19 2 2 4-4\" />\n  <path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M21 13V9a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 15 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6.5\" />"),
    STICKY_NOTE_MINUS(
        "sticky-note-minus",
        "<path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M21 14V9a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 15 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h7.35\" />\n  <path d=\"M21 18h-6\" />"),
    STICKY_NOTE_OFF(
        "sticky-note-off",
        "<path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M3.586 3.586A2 2 0 0 0 3 5v14a2 2 0 0 0 2 2h14a2 2 0 0 0 1.414-.586\" />\n  <path d=\"M8.656 3H15a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 21 9v6.344\" />"),
    STICKY_NOTE_PLUS(
        "sticky-note-plus",
        "<path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M21 12.356V9a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 15 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h7.355\" />\n  <path d=\"M21 18h-6\" />"),
    STICKY_NOTE_X(
        "sticky-note-x",
        "<path d=\"M15 3v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m16 16 5 5\" />\n  <path d=\"M21 12V9a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 15 3H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h7\" />\n  <path d=\"m21 16-5 5\" />"),
    STICKY_NOTES(
        "sticky-notes",
        "<path d=\"M10 8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 16 14v6a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V10a2 2 0 0 1 2-2z\" />\n  <path d=\"M10 8v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 4a2 2 0 0 1 2-2h6a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 22 8v6a2 2 0 0 1-2 2\" />\n  <path d=\"M16 2v5a1 1 0 0 0 1 1h5\" />"),
    STRIKETHROUGH(
        "strikethrough",
        "<path d=\"M16 4H9a3 3 0 0 0-2.83 4\" />\n  <path d=\"M14 12a4 4 0 0 1 0 8H6\" />\n  <line x1=\"4\" x2=\"20\" y1=\"12\" y2=\"12\" />"),
    SUBSCRIPT(
        "subscript",
        "<path d=\"m4 5 8 8\" />\n  <path d=\"m12 5-8 8\" />\n  <path d=\"M20 19h-4c0-1.5.44-2 1.5-2.5S20 15.33 20 14c0-.47-.17-.93-.48-1.29a2.11 2.11 0 0 0-2.62-.44c-.42.24-.74.62-.9 1.07\" />"),
    SUMMARY(
        "summary",
        "<path d=\"M15 4H7\" />\n  <path d=\"m18 16 3 3-3 3\" />\n  <path d=\"M3 4v13a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 14h7\" />\n  <path d=\"M7 9h12\" />"),
    SUPERSCRIPT(
        "superscript",
        "<path d=\"m4 19 8-8\" />\n  <path d=\"m12 19-8-8\" />\n  <path d=\"M20 12h-4c0-1.5.442-2 1.5-2.5S20 8.334 20 7.002c0-.472-.17-.93-.484-1.29a2.105 2.105 0 0 0-2.617-.436c-.42.239-.738.614-.899 1.06\" />"),
    TABLE(
        "table",
        "<path d=\"M12 3v18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M3 15h18\" />"),
    TABLE_2(
        "table-2",
        "<path d=\"M3 9h18\" />\n  <path d=\"M9 3v18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    TABLE_CELLS_MERGE(
        "table-cells-merge",
        "<path d=\"M12 21v-6\" />\n  <path d=\"M12 9V3\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M3 9h18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />"),
    TABLE_CELLS_SPLIT(
        "table-cells-split",
        "<path d=\"M12 15V9\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M3 9h18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />"),
    TABLE_COLUMNS_SPLIT(
        "table-columns-split",
        "<path d=\"M14 14v2\" />\n  <path d=\"M14 20v2\" />\n  <path d=\"M14 2v2\" />\n  <path d=\"M14 8v2\" />\n  <path d=\"M2 15h8\" />\n  <path d=\"M2 3h6a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H2\" />\n  <path d=\"M2 9h8\" />\n  <path d=\"M22 15h-4\" />\n  <path d=\"M22 3h-2a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h2\" />\n  <path d=\"M22 9h-4\" />\n  <path d=\"M5 3v18\" />"),
    TABLE_OF_CONTENTS(
        "table-of-contents",
        "<path d=\"M16 5H3\" />\n  <path d=\"M16 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"M21 5h.01\" />\n  <path d=\"M21 12h.01\" />\n  <path d=\"M21 19h.01\" />"),
    TABLE_PROPERTIES(
        "table-properties",
        "<path d=\"M15 3v18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    TABLE_ROWS_SPLIT(
        "table-rows-split",
        "<path d=\"M14 10h2\" />\n  <path d=\"M15 22v-8\" />\n  <path d=\"M15 2v4\" />\n  <path d=\"M2 10h2\" />\n  <path d=\"M20 10h2\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M3 22v-6a2 2 135 0 1 2-2h14a2 2 45 0 1 2 2v6\" />\n  <path d=\"M3 2v2a2 2 45 0 0 2 2h14a2 2 135 0 0 2-2V2\" />\n  <path d=\"M8 10h2\" />\n  <path d=\"M9 22v-8\" />\n  <path d=\"M9 2v4\" />"),
    TEXT_ALIGN_CENTER(
        "text-align-center",
        "<path d=\"M21 5H3\" />\n  <path d=\"M17 12H7\" />\n  <path d=\"M19 19H5\" />"),
    TEXT_ALIGN_END(
        "text-align-end",
        "<path d=\"M21 5H3\" />\n  <path d=\"M21 12H9\" />\n  <path d=\"M21 19H7\" />"),
    TEXT_ALIGN_JUSTIFY(
        "text-align-justify",
        "<path d=\"M3 5h18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 19h18\" />"),
    TEXT_ALIGN_JUSTIFY_CENTER(
        "text-align-justify-center",
        "<path d=\"M3 5h18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M7 19h10\" />"),
    TEXT_ALIGN_JUSTIFY_END(
        "text-align-justify-end",
        "<path d=\"M3 5h18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M11 19h10\" />"),
    TEXT_ALIGN_JUSTIFY_START(
        "text-align-justify-start",
        "<path d=\"M3 5h18\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 19h10\" />"),
    TEXT_ALIGN_START(
        "text-align-start",
        "<path d=\"M21 5H3\" />\n  <path d=\"M15 12H3\" />\n  <path d=\"M17 19H3\" />"),
    TEXT_CURSOR(
        "text-cursor",
        "<path d=\"M17 22h-1a4 4 0 0 1-4-4V6a4 4 0 0 1 4-4h1\" />\n  <path d=\"M7 22h1a4 4 0 0 0 4-4\" />\n  <path d=\"M7 2h1a4 4 0 0 1 4 4\" />"),
    TEXT_CURSOR_INPUT(
        "text-cursor-input",
        "<path d=\"M12 20h-1a2 2 0 0 1-2-2 2 2 0 0 1-2 2H6\" />\n  <path d=\"M13 8h7a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-7\" />\n  <path d=\"M5 16H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h1\" />\n  <path d=\"M6 4h1a2 2 0 0 1 2 2 2 2 0 0 1 2-2h1\" />\n  <path d=\"M9 6v12\" />"),
    TEXT_INITIAL(
        "text-initial",
        "<path d=\"M15 5h6\" />\n  <path d=\"M15 12h6\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"m3 12 3.553-7.724a.5.5 0 0 1 .894 0L11 12\" />\n  <path d=\"M3.92 10h6.16\" />"),
    TEXT_QUOTE(
        "text-quote",
        "<path d=\"M17 5H3\" />\n  <path d=\"M21 12H8\" />\n  <path d=\"M21 19H8\" />\n  <path d=\"M3 12v7\" />"),
    TEXT_SEARCH(
        "text-search",
        "<path d=\"M21 5H3\" />\n  <path d=\"M10 12H3\" />\n  <path d=\"M10 19H3\" />\n  <circle cx=\"17\" cy=\"15\" r=\"3\" />\n  <path d=\"m21 19-1.9-1.9\" />"),
    TEXT_WRAP(
        "text-wrap",
        "<path d=\"m16 16-3 3 3 3\" />\n  <path d=\"M3 12h14.5a1 1 0 0 1 0 7H13\" />\n  <path d=\"M3 19h6\" />\n  <path d=\"M3 5h18\" />"),
    TYPE(
        "type",
        "<path d=\"M12 4v16\" />\n  <path d=\"M4 7V5a1 1 0 0 1 1-1h14a1 1 0 0 1 1 1v2\" />\n  <path d=\"M9 20h6\" />"),
    TYPE_OUTLINE(
        "type-outline",
        "<path d=\"M14 16.5a.5.5 0 0 0 .5.5h.5a2 2 0 0 1 0 4H9a2 2 0 0 1 0-4h.5a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5V8a2 2 0 0 1-4 0V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v3a2 2 0 0 1-4 0v-.5a.5.5 0 0 0-.5-.5h-3a.5.5 0 0 0-.5.5Z\" />"),
    UNDERLINE(
        "underline",
        "<path d=\"M6 4v6a6 6 0 0 0 12 0V4\" />\n  <line x1=\"4\" x2=\"20\" y1=\"20\" y2=\"20\" />"),
    UNDO(
        "undo",
        "<path d=\"M3 7v6h6\" />\n  <path d=\"M21 17a9 9 0 0 0-9-9 9 9 0 0 0-6 2.3L3 13\" />"),
    UNDO_2(
        "undo-2",
        "<path d=\"M9 14 4 9l5-5\" />\n  <path d=\"M4 9h10.5a5.5 5.5 0 0 1 5.5 5.5a5.5 5.5 0 0 1-5.5 5.5H11\" />"),
    UNDO_DOT(
        "undo-dot",
        "<path d=\"M21 17a9 9 0 0 0-15-6.7L3 13\" />\n  <path d=\"M3 7v6h6\" />\n  <circle cx=\"12\" cy=\"17\" r=\"1\" />"),
    UNLINK(
        "unlink",
        "<path d=\"m18.84 12.25 1.72-1.71h-.02a5.004 5.004 0 0 0-.12-7.07 5.006 5.006 0 0 0-6.95 0l-1.72 1.71\" />\n  <path d=\"m5.17 11.75-1.71 1.71a5.004 5.004 0 0 0 .12 7.07 5.006 5.006 0 0 0 6.95 0l1.71-1.71\" />\n  <line x1=\"8\" x2=\"8\" y1=\"2\" y2=\"5\" />\n  <line x1=\"2\" x2=\"5\" y1=\"8\" y2=\"8\" />\n  <line x1=\"16\" x2=\"16\" y1=\"19\" y2=\"22\" />\n  <line x1=\"19\" x2=\"22\" y1=\"16\" y2=\"16\" />"),
    UNLINK_2("unlink-2", "<path d=\"M15 7h2a5 5 0 0 1 0 10h-2m-6 0H7A5 5 0 0 1 7 7h2\" />"),
    WHOLE_WORD(
        "whole-word",
        "<circle cx=\"7\" cy=\"12\" r=\"3\" />\n  <path d=\"M10 9v6\" />\n  <circle cx=\"17\" cy=\"12\" r=\"3\" />\n  <path d=\"M14 7v8\" />\n  <path d=\"M22 17v1c0 .5-.5 1-1 1H3c-.5 0-1-.5-1-1v-1\" />"),
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
  default LucideIcon a_arrow_down_text() {
    return LucideIcon.create(Icon.A_ARROW_DOWN);
  }

  default LucideIcon a_arrow_up_text() {
    return LucideIcon.create(Icon.A_ARROW_UP);
  }

  default LucideIcon a_large_small_text() {
    return LucideIcon.create(Icon.A_LARGE_SMALL);
  }

  default LucideIcon ampersand_text() {
    return LucideIcon.create(Icon.AMPERSAND);
  }

  default LucideIcon ampersands_text() {
    return LucideIcon.create(Icon.AMPERSANDS);
  }

  default LucideIcon anchor_text() {
    return LucideIcon.create(Icon.ANCHOR);
  }

  default LucideIcon arrow_big_up_text() {
    return LucideIcon.create(Icon.ARROW_BIG_UP);
  }

  default LucideIcon arrow_big_up_dash_text() {
    return LucideIcon.create(Icon.ARROW_BIG_UP_DASH);
  }

  default LucideIcon arrow_down_0_1_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_0_1);
  }

  default LucideIcon arrow_down_1_0_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_1_0);
  }

  default LucideIcon arrow_down_a_z_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_A_Z);
  }

  default LucideIcon arrow_down_narrow_wide_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_NARROW_WIDE);
  }

  default LucideIcon arrow_down_wide_narrow_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_WIDE_NARROW);
  }

  default LucideIcon arrow_down_z_a_text() {
    return LucideIcon.create(Icon.ARROW_DOWN_Z_A);
  }

  default LucideIcon arrow_up_0_1_text() {
    return LucideIcon.create(Icon.ARROW_UP_0_1);
  }

  default LucideIcon arrow_up_1_0_text() {
    return LucideIcon.create(Icon.ARROW_UP_1_0);
  }

  default LucideIcon arrow_up_a_z_text() {
    return LucideIcon.create(Icon.ARROW_UP_A_Z);
  }

  default LucideIcon arrow_up_narrow_wide_text() {
    return LucideIcon.create(Icon.ARROW_UP_NARROW_WIDE);
  }

  default LucideIcon arrow_up_wide_narrow_text() {
    return LucideIcon.create(Icon.ARROW_UP_WIDE_NARROW);
  }

  default LucideIcon arrow_up_z_a_text() {
    return LucideIcon.create(Icon.ARROW_UP_Z_A);
  }

  default LucideIcon asterisk_text() {
    return LucideIcon.create(Icon.ASTERISK);
  }

  default LucideIcon at_sign_text() {
    return LucideIcon.create(Icon.AT_SIGN);
  }

  default LucideIcon baseline() {
    return LucideIcon.create(Icon.BASELINE);
  }

  default LucideIcon binary_text() {
    return LucideIcon.create(Icon.BINARY);
  }

  default LucideIcon bold() {
    return LucideIcon.create(Icon.BOLD);
  }

  default LucideIcon book_text() {
    return LucideIcon.create(Icon.BOOK);
  }

  default LucideIcon book_a_text() {
    return LucideIcon.create(Icon.BOOK_A);
  }

  default LucideIcon book_alert_text() {
    return LucideIcon.create(Icon.BOOK_ALERT);
  }

  default LucideIcon book_audio_text() {
    return LucideIcon.create(Icon.BOOK_AUDIO);
  }

  default LucideIcon book_bookmark_text() {
    return LucideIcon.create(Icon.BOOK_BOOKMARK);
  }

  default LucideIcon book_check_text() {
    return LucideIcon.create(Icon.BOOK_CHECK);
  }

  default LucideIcon book_copy_text() {
    return LucideIcon.create(Icon.BOOK_COPY);
  }

  default LucideIcon book_headphones_text() {
    return LucideIcon.create(Icon.BOOK_HEADPHONES);
  }

  default LucideIcon book_heart_text() {
    return LucideIcon.create(Icon.BOOK_HEART);
  }

  default LucideIcon book_image_text() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon book_minus_text() {
    return LucideIcon.create(Icon.BOOK_MINUS);
  }

  default LucideIcon book_open_text() {
    return LucideIcon.create(Icon.BOOK_OPEN);
  }

  default LucideIcon book_open_check_text() {
    return LucideIcon.create(Icon.BOOK_OPEN_CHECK);
  }

  default LucideIcon book_open_text_text() {
    return LucideIcon.create(Icon.BOOK_OPEN_TEXT);
  }

  default LucideIcon book_plus_text() {
    return LucideIcon.create(Icon.BOOK_PLUS);
  }

  default LucideIcon book_search_text() {
    return LucideIcon.create(Icon.BOOK_SEARCH);
  }

  default LucideIcon book_text_text() {
    return LucideIcon.create(Icon.BOOK_TEXT);
  }

  default LucideIcon book_type_text() {
    return LucideIcon.create(Icon.BOOK_TYPE);
  }

  default LucideIcon book_x_text() {
    return LucideIcon.create(Icon.BOOK_X);
  }

  default LucideIcon brush_text() {
    return LucideIcon.create(Icon.BRUSH);
  }

  default LucideIcon case_lower_text() {
    return LucideIcon.create(Icon.CASE_LOWER);
  }

  default LucideIcon case_sensitive() {
    return LucideIcon.create(Icon.CASE_SENSITIVE);
  }

  default LucideIcon case_upper_text() {
    return LucideIcon.create(Icon.CASE_UPPER);
  }

  default LucideIcon circle_question_mark_text() {
    return LucideIcon.create(Icon.CIRCLE_QUESTION_MARK);
  }

  default LucideIcon clipboard() {
    return LucideIcon.create(Icon.CLIPBOARD);
  }

  default LucideIcon clipboard_check() {
    return LucideIcon.create(Icon.CLIPBOARD_CHECK);
  }

  default LucideIcon clipboard_clock_text() {
    return LucideIcon.create(Icon.CLIPBOARD_CLOCK);
  }

  default LucideIcon clipboard_copy_text() {
    return LucideIcon.create(Icon.CLIPBOARD_COPY);
  }

  default LucideIcon clipboard_list() {
    return LucideIcon.create(Icon.CLIPBOARD_LIST);
  }

  default LucideIcon clipboard_minus_text() {
    return LucideIcon.create(Icon.CLIPBOARD_MINUS);
  }

  default LucideIcon clipboard_paste_text() {
    return LucideIcon.create(Icon.CLIPBOARD_PASTE);
  }

  default LucideIcon clipboard_pen() {
    return LucideIcon.create(Icon.CLIPBOARD_PEN);
  }

  default LucideIcon clipboard_pen_line() {
    return LucideIcon.create(Icon.CLIPBOARD_PEN_LINE);
  }

  default LucideIcon clipboard_plus_text() {
    return LucideIcon.create(Icon.CLIPBOARD_PLUS);
  }

  default LucideIcon clipboard_type() {
    return LucideIcon.create(Icon.CLIPBOARD_TYPE);
  }

  default LucideIcon clipboard_x() {
    return LucideIcon.create(Icon.CLIPBOARD_X);
  }

  default LucideIcon code_text() {
    return LucideIcon.create(Icon.CODE);
  }

  default LucideIcon code_xml_text() {
    return LucideIcon.create(Icon.CODE_XML);
  }

  default LucideIcon columns_2_text() {
    return LucideIcon.create(Icon.COLUMNS_2);
  }

  default LucideIcon columns_3_text() {
    return LucideIcon.create(Icon.COLUMNS_3);
  }

  default LucideIcon columns_4_text() {
    return LucideIcon.create(Icon.COLUMNS_4);
  }

  default LucideIcon copy() {
    return LucideIcon.create(Icon.COPY);
  }

  default LucideIcon copy_check_text() {
    return LucideIcon.create(Icon.COPY_CHECK);
  }

  default LucideIcon copy_minus_text() {
    return LucideIcon.create(Icon.COPY_MINUS);
  }

  default LucideIcon copy_plus_text() {
    return LucideIcon.create(Icon.COPY_PLUS);
  }

  default LucideIcon copy_slash_text() {
    return LucideIcon.create(Icon.COPY_SLASH);
  }

  default LucideIcon copyleft() {
    return LucideIcon.create(Icon.COPYLEFT);
  }

  default LucideIcon copyright() {
    return LucideIcon.create(Icon.COPYRIGHT);
  }

  default LucideIcon corner_down_right_text() {
    return LucideIcon.create(Icon.CORNER_DOWN_RIGHT);
  }

  default LucideIcon creative_commons() {
    return LucideIcon.create(Icon.CREATIVE_COMMONS);
  }

  default LucideIcon decimals_arrow_left_text() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_LEFT);
  }

  default LucideIcon decimals_arrow_right_text() {
    return LucideIcon.create(Icon.DECIMALS_ARROW_RIGHT);
  }

  default LucideIcon delete_text() {
    return LucideIcon.create(Icon.DELETE);
  }

  default LucideIcon dot_text() {
    return LucideIcon.create(Icon.DOT);
  }

  default LucideIcon eraser() {
    return LucideIcon.create(Icon.ERASER);
  }

  default LucideIcon expand_text() {
    return LucideIcon.create(Icon.EXPAND);
  }

  default LucideIcon external_link_text() {
    return LucideIcon.create(Icon.EXTERNAL_LINK);
  }

  default LucideIcon feather_text() {
    return LucideIcon.create(Icon.FEATHER);
  }

  default LucideIcon file_text_text() {
    return LucideIcon.create(Icon.FILE_TEXT);
  }

  default LucideIcon file_type_text() {
    return LucideIcon.create(Icon.FILE_TYPE);
  }

  default LucideIcon file_type_corner_text() {
    return LucideIcon.create(Icon.FILE_TYPE_CORNER);
  }

  default LucideIcon grid_2x2_text() {
    return LucideIcon.create(Icon.GRID_2X2);
  }

  default LucideIcon grid_2x2_check_text() {
    return LucideIcon.create(Icon.GRID_2X2_CHECK);
  }

  default LucideIcon grid_2x2_plus_text() {
    return LucideIcon.create(Icon.GRID_2X2_PLUS);
  }

  default LucideIcon grid_2x2_x_text() {
    return LucideIcon.create(Icon.GRID_2X2_X);
  }

  default LucideIcon grid_3x2_text() {
    return LucideIcon.create(Icon.GRID_3X2);
  }

  default LucideIcon grid_3x3_text() {
    return LucideIcon.create(Icon.GRID_3X3);
  }

  default LucideIcon hash_text() {
    return LucideIcon.create(Icon.HASH);
  }

  default LucideIcon heading() {
    return LucideIcon.create(Icon.HEADING);
  }

  default LucideIcon heading_1() {
    return LucideIcon.create(Icon.HEADING_1);
  }

  default LucideIcon heading_2() {
    return LucideIcon.create(Icon.HEADING_2);
  }

  default LucideIcon heading_3() {
    return LucideIcon.create(Icon.HEADING_3);
  }

  default LucideIcon heading_4() {
    return LucideIcon.create(Icon.HEADING_4);
  }

  default LucideIcon heading_5() {
    return LucideIcon.create(Icon.HEADING_5);
  }

  default LucideIcon heading_6() {
    return LucideIcon.create(Icon.HEADING_6);
  }

  default LucideIcon highlighter_text() {
    return LucideIcon.create(Icon.HIGHLIGHTER);
  }

  default LucideIcon image_text() {
    return LucideIcon.create(Icon.IMAGE);
  }

  default LucideIcon image_down_text() {
    return LucideIcon.create(Icon.IMAGE_DOWN);
  }

  default LucideIcon image_play_text() {
    return LucideIcon.create(Icon.IMAGE_PLAY);
  }

  default LucideIcon image_up_text() {
    return LucideIcon.create(Icon.IMAGE_UP);
  }

  default LucideIcon images_text() {
    return LucideIcon.create(Icon.IMAGES);
  }

  default LucideIcon italic() {
    return LucideIcon.create(Icon.ITALIC);
  }

  default LucideIcon keyboard_text() {
    return LucideIcon.create(Icon.KEYBOARD);
  }

  default LucideIcon keyboard_off_text() {
    return LucideIcon.create(Icon.KEYBOARD_OFF);
  }

  default LucideIcon lambda_text() {
    return LucideIcon.create(Icon.LAMBDA);
  }

  default LucideIcon languages() {
    return LucideIcon.create(Icon.LANGUAGES);
  }

  default LucideIcon layout_list_text() {
    return LucideIcon.create(Icon.LAYOUT_LIST);
  }

  default LucideIcon letter_spacing() {
    return LucideIcon.create(Icon.LETTER_SPACING);
  }

  default LucideIcon letters() {
    return LucideIcon.create(Icon.LETTERS);
  }

  default LucideIcon library_text() {
    return LucideIcon.create(Icon.LIBRARY);
  }

  default LucideIcon library_big_text() {
    return LucideIcon.create(Icon.LIBRARY_BIG);
  }

  default LucideIcon ligature() {
    return LucideIcon.create(Icon.LIGATURE);
  }

  default LucideIcon line_height() {
    return LucideIcon.create(Icon.LINE_HEIGHT);
  }

  default LucideIcon link_text() {
    return LucideIcon.create(Icon.LINK);
  }

  default LucideIcon link_2_text() {
    return LucideIcon.create(Icon.LINK_2);
  }

  default LucideIcon link_2_off() {
    return LucideIcon.create(Icon.LINK_2_OFF);
  }

  default LucideIcon list() {
    return LucideIcon.create(Icon.LIST);
  }

  default LucideIcon list_check() {
    return LucideIcon.create(Icon.LIST_CHECK);
  }

  default LucideIcon list_checks() {
    return LucideIcon.create(Icon.LIST_CHECKS);
  }

  default LucideIcon list_chevrons_down_up_text() {
    return LucideIcon.create(Icon.LIST_CHEVRONS_DOWN_UP);
  }

  default LucideIcon list_chevrons_up_down_text() {
    return LucideIcon.create(Icon.LIST_CHEVRONS_UP_DOWN);
  }

  default LucideIcon list_clock_text() {
    return LucideIcon.create(Icon.LIST_CLOCK);
  }

  default LucideIcon list_collapse() {
    return LucideIcon.create(Icon.LIST_COLLAPSE);
  }

  default LucideIcon list_end_text() {
    return LucideIcon.create(Icon.LIST_END);
  }

  default LucideIcon list_filter() {
    return LucideIcon.create(Icon.LIST_FILTER);
  }

  default LucideIcon list_filter_plus_text() {
    return LucideIcon.create(Icon.LIST_FILTER_PLUS);
  }

  default LucideIcon list_indent_decrease_text() {
    return LucideIcon.create(Icon.LIST_INDENT_DECREASE);
  }

  default LucideIcon list_indent_increase_text() {
    return LucideIcon.create(Icon.LIST_INDENT_INCREASE);
  }

  default LucideIcon list_minus_text() {
    return LucideIcon.create(Icon.LIST_MINUS);
  }

  default LucideIcon list_ordered() {
    return LucideIcon.create(Icon.LIST_ORDERED);
  }

  default LucideIcon list_plus_text() {
    return LucideIcon.create(Icon.LIST_PLUS);
  }

  default LucideIcon list_restart_text() {
    return LucideIcon.create(Icon.LIST_RESTART);
  }

  default LucideIcon list_sort_ascending_text() {
    return LucideIcon.create(Icon.LIST_SORT_ASCENDING);
  }

  default LucideIcon list_sort_descending_text() {
    return LucideIcon.create(Icon.LIST_SORT_DESCENDING);
  }

  default LucideIcon list_start_text() {
    return LucideIcon.create(Icon.LIST_START);
  }

  default LucideIcon list_todo() {
    return LucideIcon.create(Icon.LIST_TODO);
  }

  default LucideIcon list_tree_text() {
    return LucideIcon.create(Icon.LIST_TREE);
  }

  default LucideIcon list_x_text() {
    return LucideIcon.create(Icon.LIST_X);
  }

  default LucideIcon logs() {
    return LucideIcon.create(Icon.LOGS);
  }

  default LucideIcon mail_text() {
    return LucideIcon.create(Icon.MAIL);
  }

  default LucideIcon mail_clock_text() {
    return LucideIcon.create(Icon.MAIL_CLOCK);
  }

  default LucideIcon mail_dot_text() {
    return LucideIcon.create(Icon.MAIL_DOT);
  }

  default LucideIcon map_text() {
    return LucideIcon.create(Icon.MAP);
  }

  default LucideIcon map_pin_search_text() {
    return LucideIcon.create(Icon.MAP_PIN_SEARCH);
  }

  default LucideIcon message_square_quote_text() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_QUOTE);
  }

  default LucideIcon minus_text() {
    return LucideIcon.create(Icon.MINUS);
  }

  default LucideIcon notebook_text() {
    return LucideIcon.create(Icon.NOTEBOOK);
  }

  default LucideIcon notebook_pen_text() {
    return LucideIcon.create(Icon.NOTEBOOK_PEN);
  }

  default LucideIcon notebook_text_text() {
    return LucideIcon.create(Icon.NOTEBOOK_TEXT);
  }

  default LucideIcon notepad_text_text() {
    return LucideIcon.create(Icon.NOTEPAD_TEXT);
  }

  default LucideIcon notepad_text_dashed_text() {
    return LucideIcon.create(Icon.NOTEPAD_TEXT_DASHED);
  }

  default LucideIcon omega_text() {
    return LucideIcon.create(Icon.OMEGA);
  }

  default LucideIcon paint_roller_text() {
    return LucideIcon.create(Icon.PAINT_ROLLER);
  }

  default LucideIcon paintbrush_text() {
    return LucideIcon.create(Icon.PAINTBRUSH);
  }

  default LucideIcon paintbrush_vertical_text() {
    return LucideIcon.create(Icon.PAINTBRUSH_VERTICAL);
  }

  default LucideIcon palette_text() {
    return LucideIcon.create(Icon.PALETTE);
  }

  default LucideIcon paperclip_text() {
    return LucideIcon.create(Icon.PAPERCLIP);
  }

  default LucideIcon pen_text() {
    return LucideIcon.create(Icon.PEN);
  }

  default LucideIcon pen_line_text() {
    return LucideIcon.create(Icon.PEN_LINE);
  }

  default LucideIcon pen_off_text() {
    return LucideIcon.create(Icon.PEN_OFF);
  }

  default LucideIcon pen_tool_text() {
    return LucideIcon.create(Icon.PEN_TOOL);
  }

  default LucideIcon pencil_text() {
    return LucideIcon.create(Icon.PENCIL);
  }

  default LucideIcon pencil_line_text() {
    return LucideIcon.create(Icon.PENCIL_LINE);
  }

  default LucideIcon pencil_off_text() {
    return LucideIcon.create(Icon.PENCIL_OFF);
  }

  default LucideIcon pencil_ruler_text() {
    return LucideIcon.create(Icon.PENCIL_RULER);
  }

  default LucideIcon pencil_sparkles_text() {
    return LucideIcon.create(Icon.PENCIL_SPARKLES);
  }

  default LucideIcon phone_text() {
    return LucideIcon.create(Icon.PHONE);
  }

  default LucideIcon pilcrow() {
    return LucideIcon.create(Icon.PILCROW);
  }

  default LucideIcon pilcrow_left() {
    return LucideIcon.create(Icon.PILCROW_LEFT);
  }

  default LucideIcon pilcrow_right() {
    return LucideIcon.create(Icon.PILCROW_RIGHT);
  }

  default LucideIcon pipette_text() {
    return LucideIcon.create(Icon.PIPETTE);
  }

  default LucideIcon plus_text() {
    return LucideIcon.create(Icon.PLUS);
  }

  default LucideIcon quote() {
    return LucideIcon.create(Icon.QUOTE);
  }

  default LucideIcon rectangle_circle_text() {
    return LucideIcon.create(Icon.RECTANGLE_CIRCLE);
  }

  default LucideIcon rectangle_ellipsis_text() {
    return LucideIcon.create(Icon.RECTANGLE_ELLIPSIS);
  }

  default LucideIcon redo_text() {
    return LucideIcon.create(Icon.REDO);
  }

  default LucideIcon redo_2_text() {
    return LucideIcon.create(Icon.REDO_2);
  }

  default LucideIcon redo_dot_text() {
    return LucideIcon.create(Icon.REDO_DOT);
  }

  default LucideIcon regex_text() {
    return LucideIcon.create(Icon.REGEX);
  }

  default LucideIcon remove_formatting() {
    return LucideIcon.create(Icon.REMOVE_FORMATTING);
  }

  default LucideIcon replace() {
    return LucideIcon.create(Icon.REPLACE);
  }

  default LucideIcon replace_all() {
    return LucideIcon.create(Icon.REPLACE_ALL);
  }

  default LucideIcon rows_2_text() {
    return LucideIcon.create(Icon.ROWS_2);
  }

  default LucideIcon rows_3_text() {
    return LucideIcon.create(Icon.ROWS_3);
  }

  default LucideIcon rows_4_text() {
    return LucideIcon.create(Icon.ROWS_4);
  }

  default LucideIcon save_text() {
    return LucideIcon.create(Icon.SAVE);
  }

  default LucideIcon save_all_text() {
    return LucideIcon.create(Icon.SAVE_ALL);
  }

  default LucideIcon save_check_text() {
    return LucideIcon.create(Icon.SAVE_CHECK);
  }

  default LucideIcon save_off_text() {
    return LucideIcon.create(Icon.SAVE_OFF);
  }

  default LucideIcon save_pen_text() {
    return LucideIcon.create(Icon.SAVE_PEN);
  }

  default LucideIcon save_plus_text() {
    return LucideIcon.create(Icon.SAVE_PLUS);
  }

  default LucideIcon scan_text_text() {
    return LucideIcon.create(Icon.SCAN_TEXT);
  }

  default LucideIcon scissors_text() {
    return LucideIcon.create(Icon.SCISSORS);
  }

  default LucideIcon scroll_text() {
    return LucideIcon.create(Icon.SCROLL);
  }

  default LucideIcon scroll_text_text() {
    return LucideIcon.create(Icon.SCROLL_TEXT);
  }

  default LucideIcon search_text() {
    return LucideIcon.create(Icon.SEARCH);
  }

  default LucideIcon search_alert_text() {
    return LucideIcon.create(Icon.SEARCH_ALERT);
  }

  default LucideIcon search_check_text() {
    return LucideIcon.create(Icon.SEARCH_CHECK);
  }

  default LucideIcon search_code_text() {
    return LucideIcon.create(Icon.SEARCH_CODE);
  }

  default LucideIcon search_slash_text() {
    return LucideIcon.create(Icon.SEARCH_SLASH);
  }

  default LucideIcon search_x_text() {
    return LucideIcon.create(Icon.SEARCH_X);
  }

  default LucideIcon section() {
    return LucideIcon.create(Icon.SECTION);
  }

  default LucideIcon separator_horizontal_text() {
    return LucideIcon.create(Icon.SEPARATOR_HORIZONTAL);
  }

  default LucideIcon separator_vertical_text() {
    return LucideIcon.create(Icon.SEPARATOR_VERTICAL);
  }

  default LucideIcon sheet_text() {
    return LucideIcon.create(Icon.SHEET);
  }

  default LucideIcon sigma_text() {
    return LucideIcon.create(Icon.SIGMA);
  }

  default LucideIcon signature() {
    return LucideIcon.create(Icon.SIGNATURE);
  }

  default LucideIcon space() {
    return LucideIcon.create(Icon.SPACE);
  }

  default LucideIcon spell_check_text() {
    return LucideIcon.create(Icon.SPELL_CHECK);
  }

  default LucideIcon spell_check_2_text() {
    return LucideIcon.create(Icon.SPELL_CHECK_2);
  }

  default LucideIcon square_asterisk_text() {
    return LucideIcon.create(Icon.SQUARE_ASTERISK);
  }

  default LucideIcon square_bottom_dashed_scissors_text() {
    return LucideIcon.create(Icon.SQUARE_BOTTOM_DASHED_SCISSORS);
  }

  default LucideIcon square_code_text() {
    return LucideIcon.create(Icon.SQUARE_CODE);
  }

  default LucideIcon square_dashed_text() {
    return LucideIcon.create(Icon.SQUARE_DASHED);
  }

  default LucideIcon square_dashed_text_text() {
    return LucideIcon.create(Icon.SQUARE_DASHED_TEXT);
  }

  default LucideIcon square_library_text() {
    return LucideIcon.create(Icon.SQUARE_LIBRARY);
  }

  default LucideIcon square_minus_text() {
    return LucideIcon.create(Icon.SQUARE_MINUS);
  }

  default LucideIcon square_pen() {
    return LucideIcon.create(Icon.SQUARE_PEN);
  }

  default LucideIcon square_pilcrow() {
    return LucideIcon.create(Icon.SQUARE_PILCROW);
  }

  default LucideIcon square_plus_text() {
    return LucideIcon.create(Icon.SQUARE_PLUS);
  }

  default LucideIcon square_scissors_text() {
    return LucideIcon.create(Icon.SQUARE_SCISSORS);
  }

  default LucideIcon square_sigma_text() {
    return LucideIcon.create(Icon.SQUARE_SIGMA);
  }

  default LucideIcon square_sparkles_text() {
    return LucideIcon.create(Icon.SQUARE_SPARKLES);
  }

  default LucideIcon square_stack_text() {
    return LucideIcon.create(Icon.SQUARE_STACK);
  }

  default LucideIcon square_text_text() {
    return LucideIcon.create(Icon.SQUARE_TEXT);
  }

  default LucideIcon sticky_note_text() {
    return LucideIcon.create(Icon.STICKY_NOTE);
  }

  default LucideIcon sticky_note_check_text() {
    return LucideIcon.create(Icon.STICKY_NOTE_CHECK);
  }

  default LucideIcon sticky_note_minus_text() {
    return LucideIcon.create(Icon.STICKY_NOTE_MINUS);
  }

  default LucideIcon sticky_note_off_text() {
    return LucideIcon.create(Icon.STICKY_NOTE_OFF);
  }

  default LucideIcon sticky_note_plus_text() {
    return LucideIcon.create(Icon.STICKY_NOTE_PLUS);
  }

  default LucideIcon sticky_note_x_text() {
    return LucideIcon.create(Icon.STICKY_NOTE_X);
  }

  default LucideIcon sticky_notes_text() {
    return LucideIcon.create(Icon.STICKY_NOTES);
  }

  default LucideIcon strikethrough() {
    return LucideIcon.create(Icon.STRIKETHROUGH);
  }

  default LucideIcon subscript() {
    return LucideIcon.create(Icon.SUBSCRIPT);
  }

  default LucideIcon summary() {
    return LucideIcon.create(Icon.SUMMARY);
  }

  default LucideIcon superscript() {
    return LucideIcon.create(Icon.SUPERSCRIPT);
  }

  default LucideIcon table_text() {
    return LucideIcon.create(Icon.TABLE);
  }

  default LucideIcon table_2_text() {
    return LucideIcon.create(Icon.TABLE_2);
  }

  default LucideIcon table_cells_merge_text() {
    return LucideIcon.create(Icon.TABLE_CELLS_MERGE);
  }

  default LucideIcon table_cells_split_text() {
    return LucideIcon.create(Icon.TABLE_CELLS_SPLIT);
  }

  default LucideIcon table_columns_split_text() {
    return LucideIcon.create(Icon.TABLE_COLUMNS_SPLIT);
  }

  default LucideIcon table_of_contents() {
    return LucideIcon.create(Icon.TABLE_OF_CONTENTS);
  }

  default LucideIcon table_properties_text() {
    return LucideIcon.create(Icon.TABLE_PROPERTIES);
  }

  default LucideIcon table_rows_split_text() {
    return LucideIcon.create(Icon.TABLE_ROWS_SPLIT);
  }

  default LucideIcon text_align_center() {
    return LucideIcon.create(Icon.TEXT_ALIGN_CENTER);
  }

  default LucideIcon text_align_end() {
    return LucideIcon.create(Icon.TEXT_ALIGN_END);
  }

  default LucideIcon text_align_justify() {
    return LucideIcon.create(Icon.TEXT_ALIGN_JUSTIFY);
  }

  default LucideIcon text_align_justify_center() {
    return LucideIcon.create(Icon.TEXT_ALIGN_JUSTIFY_CENTER);
  }

  default LucideIcon text_align_justify_end() {
    return LucideIcon.create(Icon.TEXT_ALIGN_JUSTIFY_END);
  }

  default LucideIcon text_align_justify_start() {
    return LucideIcon.create(Icon.TEXT_ALIGN_JUSTIFY_START);
  }

  default LucideIcon text_align_start() {
    return LucideIcon.create(Icon.TEXT_ALIGN_START);
  }

  default LucideIcon text_cursor_text() {
    return LucideIcon.create(Icon.TEXT_CURSOR);
  }

  default LucideIcon text_cursor_input_text() {
    return LucideIcon.create(Icon.TEXT_CURSOR_INPUT);
  }

  default LucideIcon text_initial() {
    return LucideIcon.create(Icon.TEXT_INITIAL);
  }

  default LucideIcon text_quote() {
    return LucideIcon.create(Icon.TEXT_QUOTE);
  }

  default LucideIcon text_search() {
    return LucideIcon.create(Icon.TEXT_SEARCH);
  }

  default LucideIcon text_wrap_text() {
    return LucideIcon.create(Icon.TEXT_WRAP);
  }

  default LucideIcon type() {
    return LucideIcon.create(Icon.TYPE);
  }

  default LucideIcon type_outline() {
    return LucideIcon.create(Icon.TYPE_OUTLINE);
  }

  default LucideIcon underline() {
    return LucideIcon.create(Icon.UNDERLINE);
  }

  default LucideIcon undo_text() {
    return LucideIcon.create(Icon.UNDO);
  }

  default LucideIcon undo_2_text() {
    return LucideIcon.create(Icon.UNDO_2);
  }

  default LucideIcon undo_dot_text() {
    return LucideIcon.create(Icon.UNDO_DOT);
  }

  default LucideIcon unlink() {
    return LucideIcon.create(Icon.UNLINK);
  }

  default LucideIcon unlink_2() {
    return LucideIcon.create(Icon.UNLINK_2);
  }

  default LucideIcon whole_word() {
    return LucideIcon.create(Icon.WHOLE_WORD);
  }

  default LucideIcon zoom_in_text() {
    return LucideIcon.create(Icon.ZOOM_IN);
  }

  default LucideIcon zoom_out_text() {
    return LucideIcon.create(Icon.ZOOM_OUT);
  }
}
