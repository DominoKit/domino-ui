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

/** Tabler Text catalog category. */
public interface TablerText {
  enum OutlineIcon implements TablerIconDefinition {
    A_B_2(
        "a-b-2",
        "<path d=\"M16 21h3c.81 0 1.48 -.67 1.48 -1.48l.02 -.02c0 -.82 -.69 -1.5 -1.5 -1.5h-3v3\" />\n  <path d=\"M16 15h2.5c.84 -.01 1.5 .66 1.5 1.5s-.66 1.5 -1.5 1.5h-2.5v-3\" />\n  <path d=\"M4 9v-4c0 -1.036 .895 -2 2 -2s2 .964 2 2v4\" />\n  <path d=\"M2.99 11.98a9 9 0 0 0 9 9m9 -9a9 9 0 0 0 -9 -9\" />\n  <path d=\"M8 7h-4\" />"),
    A_B_OFF(
        "a-b-off",
        "<path d=\"M3 16v-5.5a2.5 2.5 0 0 1 5 0v5.5m0 -4h-5\" />\n  <path d=\"M12 12v6\" />\n  <path d=\"M12 6v2\" />\n  <path d=\"M16 8h3a2 2 0 1 1 0 4h-3m3 0a2 2 0 0 1 .83 3.82m-3.83 -3.82v-4\" />\n  <path d=\"M3 3l18 18\" />"),
    ABC(
        "abc",
        "<path d=\"M3 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M3 13h4\" />\n  <path d=\"M10 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M20.732 12a2 2 0 0 0 -3.732 1v1a2 2 0 0 0 3.726 1.01\" />"),
    ALIGN_BOX_BOTTOM_CENTER(
        "align-box-bottom-center",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 15v2\" />\n  <path d=\"M12 11v6\" />\n  <path d=\"M15 13v4\" />"),
    ALIGN_BOX_BOTTOM_LEFT(
        "align-box-bottom-left",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M7 15v2\" />\n  <path d=\"M10 11v6\" />\n  <path d=\"M13 13v4\" />"),
    ALIGN_BOX_BOTTOM_RIGHT(
        "align-box-bottom-right",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 15v2\" />\n  <path d=\"M14 11v6\" />\n  <path d=\"M17 13v4\" />"),
    ALIGN_BOX_CENTER_BOTTOM(
        "align-box-center-bottom",
        "<path d=\"M3 19v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11 17h2\" />\n  <path d=\"M9 14h6\" />\n  <path d=\"M10 11h4\" />"),
    ALIGN_BOX_CENTER_MIDDLE(
        "align-box-center-middle",
        "<path d=\"M3 19v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11 15h2\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M10 9h4\" />"),
    ALIGN_BOX_CENTER_STRETCH(
        "align-box-center-stretch",
        "<path d=\"M3 19v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11 17h2\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M10 7h4\" />"),
    ALIGN_BOX_CENTER_TOP(
        "align-box-center-top",
        "<path d=\"M3 19v-14a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11 13h2\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M10 7h4\" />"),
    ALIGN_BOX_LEFT_BOTTOM(
        "align-box-left-bottom",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 17h-2\" />\n  <path d=\"M13 14h-6\" />\n  <path d=\"M11 11h-4\" />"),
    ALIGN_BOX_LEFT_MIDDLE(
        "align-box-left-middle",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 15h-2\" />\n  <path d=\"M13 12h-6\" />\n  <path d=\"M11 9h-4\" />"),
    ALIGN_BOX_LEFT_STRETCH(
        "align-box-left-stretch",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 17h-2\" />\n  <path d=\"M13 12h-6\" />\n  <path d=\"M11 7h-4\" />"),
    ALIGN_BOX_LEFT_TOP(
        "align-box-left-top",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 13h-2\" />\n  <path d=\"M13 10h-6\" />\n  <path d=\"M11 7h-4\" />"),
    ALIGN_BOX_RIGHT_BOTTOM(
        "align-box-right-bottom",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M15 17h2\" />\n  <path d=\"M11 14h6\" />\n  <path d=\"M13 11h4\" />"),
    ALIGN_BOX_RIGHT_MIDDLE(
        "align-box-right-middle",
        "<path d=\"M15 15h2\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 12h6\" />\n  <path d=\"M13 9h4\" />"),
    ALIGN_BOX_RIGHT_STRETCH(
        "align-box-right-stretch",
        "<path d=\"M15 17h2\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 12h6\" />\n  <path d=\"M13 7h4\" />"),
    ALIGN_BOX_RIGHT_TOP(
        "align-box-right-top",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M15 13h2\" />\n  <path d=\"M11 10h6\" />\n  <path d=\"M13 7h4\" />"),
    ALIGN_BOX_TOP_CENTER(
        "align-box-top-center",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M9 9v-2\" />\n  <path d=\"M12 13v-6\" />\n  <path d=\"M15 11v-4\" />"),
    ALIGN_BOX_TOP_LEFT(
        "align-box-top-left",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M7 9v-2\" />\n  <path d=\"M10 13v-6\" />\n  <path d=\"M13 11v-4\" />"),
    ALIGN_BOX_TOP_RIGHT(
        "align-box-top-right",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 9v-2\" />\n  <path d=\"M14 13v-6\" />\n  <path d=\"M17 11v-4\" />"),
    ALIGN_CENTER(
        "align-center",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M8 12l8 0\" />\n  <path d=\"M6 18l12 0\" />"),
    ALIGN_JUSTIFIED(
        "align-justified",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M4 12l16 0\" />\n  <path d=\"M4 18l12 0\" />"),
    ALIGN_LEFT(
        "align-left",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M4 12l10 0\" />\n  <path d=\"M4 18l14 0\" />"),
    ALIGN_LEFT_2(
        "align-left-2",
        "<path d=\"M4 4v16\" />\n  <path d=\"M8 6h12\" />\n  <path d=\"M8 12h6\" />\n  <path d=\"M8 18h10\" />"),
    ALIGN_RIGHT(
        "align-right",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M10 12l10 0\" />\n  <path d=\"M6 18l14 0\" />"),
    ALIGN_RIGHT_2(
        "align-right-2",
        "<path d=\"M20 4v16\" />\n  <path d=\"M4 6h12\" />\n  <path d=\"M10 12h6\" />\n  <path d=\"M6 18h10\" />"),
    ALPHABET_ARABIC(
        "alphabet-arabic",
        "<path d=\"M10 6v4\" />\n  <path d=\"M13 14h8q -2.518 -3 -4 -3\" />\n  <path d=\"M13 6v9.958c0 .963 0 1.444 -.293 1.743s-.764 .299 -1.707 .299h-1\" />\n  <path d=\"M7 6v9.958c0 .963 0 1.444 -.293 1.743s-.764 .299 -1.707 .299h-1\" />"),
    ALPHABET_BANGLA(
        "alphabet-bangla",
        "<path d=\"M14 12c.904 -.027 3 2 3 7\" />\n  <path d=\"M10 11c0 -.955 0 -2 .786 -2.677c1.262 -1.089 3.025 .55 3.2 2.06c.086 .741 -.215 3.109 -1.489 4.527c-.475 .53 -.904 .992 -1.711 1.074c-.75 .076 -1.364 -.122 -2.076 -.588c-1.138 -.743 -2.327 -1.997 -3.336 -3.73c-1.078 -1.849 -1.66 -3.113 -2.374 -5.666\" />\n  <path d=\"M7.37 7.072c.769 -.836 5.246 -4.094 8.4 -.202c.382 .472 .573 .708 .9 1.63c.326 .921 .326 1.562 .326 2.844v7.656\" />\n  <path d=\"M17 10c0 -1.989 1.5 -4 4 -4\" />"),
    ALPHABET_CHINESE(
        "alphabet-chinese",
        "<path d=\"M6 10a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-3\" />\n  <path d=\"M12 5v14\" />"),
    ALPHABET_CYRILLIC(
        "alphabet-cyrillic",
        "<path d=\"M6 10h2a2 2 0 0 1 2 2v5h-3a2 2 0 1 1 0 -4h3\" />\n  <path d=\"M19 7h-3a2 2 0 0 0 -2 2v6a2 2 0 0 0 2 2h1a2 2 0 0 0 2 -2v-3a2 2 0 0 0 -2 -2h-3\" />"),
    ALPHABET_DEVANAGARI(
        "alphabet-devanagari",
        "<path d=\"M4 5h16\" />\n  <path d=\"M16 5v14\" />\n  <path d=\"M5.5 8.5c.5 -1 1.5 -1.5 2.5 -1.5c1.4 0 2.5 1 2.5 2.5s-1.1 2.5 -2.5 2.5c2 0 3.5 1.3 3.5 3.25s-1.5 3.25 -3.5 3.25c-1.2 0 -2.2 -.6 -2.8 -1.5\" />\n  <path d=\"M8 12h8\" />"),
    ALPHABET_ETHIOPIC("alphabet-ethiopic", "<path d=\"M6 19h2v-10a4 4 0 1 1 8 0v10h2\" />"),
    ALPHABET_GEORGIAN(
        "alphabet-georgian",
        "<path d=\"M7 9c0 1 3 3 3 5c0 1.7 -1.3 3 -3 3s-3 -1.3 -3 -3v-1\" />\n  <path d=\"M14 14a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M17 11v-1.2c0 -1.2 -2 -1.6 -2 -2.8\" />"),
    ALPHABET_GREEK(
        "alphabet-greek",
        "<path d=\"M10 10v7\" />\n  <path d=\"M5 12a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M14 20v-11a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2\" />"),
    ALPHABET_HEBREW(
        "alphabet-hebrew",
        "<path d=\"M7 6c2.333 5.143 6.611 6.857 9.333 12\" />\n  <path d=\"M13.667 14c2.505 -1.5 2.666 -4.141 2.666 -5.333c0 -1.778 -.443 -2.667 -.443 -2.667\" />\n  <path d=\"M7.485 18s-.485 -.905 -.485 -2.714c0 -1.172 .164 -3.722 2.641 -5.27\" />"),
    ALPHABET_JAPANESE(
        "alphabet-japanese",
        "<path d=\"M6 6h10\" />\n  <path d=\"M10 4c0 6.784 .8 11.1 1.5 12.5\" />\n  <path d=\"M14.25 10.75c0 3.429 -2.75 6.75 -4.812 6.75s-3.438 -1.25 -3.438 -3c0 -2.5 1.375 -4.5 4.125 -4.5s6.875 .855 6.875 4.286q 0 3.428 -2.75 4.714\" />"),
    ALPHABET_KOREAN(
        "alphabet-korean",
        "<path d=\"M7 7h6c0 2.5 -1.593 8.474 -6 10\" />\n  <path d=\"M16 5v14l0 -14\" />\n  <path d=\"M16 12h2\" />"),
    ALPHABET_LATIN(
        "alphabet-latin",
        "<path d=\"M6 10h2a2 2 0 0 1 2 2v5h-3a2 2 0 1 1 0 -4h3\" />\n  <path d=\"M14 7v10\" />\n  <path d=\"M14 12a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2l0 -3\" />"),
    ALPHABET_POLISH(
        "alphabet-polish",
        "<path d=\"M7 10h2a2 2 0 0 1 2 2v5h-3a2 2 0 1 1 0 -4h3\" />\n  <path d=\"M16 7v10\" />\n  <path d=\"M18 11l-4 2\" />\n  <path d=\"M10.5 17a1.5 1.5 0 0 0 0 3\" />"),
    ALPHABET_RUNES(
        "alphabet-runes",
        "<path d=\"M17 18v-12\" />\n  <path d=\"M13 6l4 4l4 -4\" />\n  <path d=\"M11 18l-7 -8l4 -4l4 4l-7 8\" />"),
    ALPHABET_THAI(
        "alphabet-thai",
        "<path d=\"M8 18v-3.444c0 -.49 .165 -.924 .494 -1.363c.326 -.449 1.009 -.76 1.506 -.934c.032 -.011 .035 -.079 .004 -.095c-.434 -.22 -1.294 -.52 -1.626 -1.032l-.014 -.021l-.083 -.125c-.281 -.42 -.281 -1.246 -.281 -1.246c0 -1.456 .849 -2.62 1.837 -3.199q .9 -.54 2.137 -.541q 1.077 0 1.995 .47c1.328 .647 2.031 2.202 2.031 3.976v7.554\" />"),
    ASTERISK(
        "asterisk",
        "<path d=\"M12 12l8 -4.5\" />\n  <path d=\"M12 12v9\" />\n  <path d=\"M12 12l-8 -4.5\" />\n  <path d=\"M12 12l8 4.5\" />\n  <path d=\"M12 3v9\" />\n  <path d=\"M12 12l-8 4.5\" />"),
    ASTERISK_SIMPLE(
        "asterisk-simple",
        "<path d=\"M12 12v-9\" />\n  <path d=\"M12 12l-9 -2.5\" />\n  <path d=\"M12 12l9 -2.5\" />\n  <path d=\"M12 12l6 8.5\" />\n  <path d=\"M12 12l-6 8.5\" />"),
    AT(
        "at",
        "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M16 12v1.5a2.5 2.5 0 0 0 5 0v-1.5a9 9 0 1 0 -5.5 8.28\" />"),
    AT_OFF(
        "at-off",
        "<path d=\"M9.174 9.17a4 4 0 0 0 5.646 5.668m1.18 -2.838a4 4 0 0 0 -4 -4\" />\n  <path d=\"M19.695 15.697a2.5 2.5 0 0 0 1.305 -2.197v-1.5a9 9 0 0 0 -13.055 -8.047m-2.322 1.683a9 9 0 0 0 9.877 14.644\" />\n  <path d=\"M3 3l18 18\" />"),
    BACKSPACE(
        "backspace",
        "<path d=\"M20 6a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-11l-5 -5a1.5 1.5 0 0 1 0 -2l5 -5l11 0\" />\n  <path d=\"M12 10l4 4m0 -4l-4 4\" />"),
    BALLPEN(
        "ballpen",
        "<path d=\"M14 6l7 7l-4 4\" />\n  <path d=\"M5.828 18.172a2.828 2.828 0 0 0 4 0l10.586 -10.586a2 2 0 0 0 0 -2.829l-1.171 -1.171a2 2 0 0 0 -2.829 0l-10.586 10.586a2.828 2.828 0 0 0 0 4\" />\n  <path d=\"M4 20l1.768 -1.768\" />"),
    BALLPEN_OFF(
        "ballpen-off",
        "<path d=\"M14 6l7 7l-2 2\" />\n  <path d=\"M10 10l-4.172 4.172a2.828 2.828 0 1 0 4 4l4.172 -4.172\" />\n  <path d=\"M16 12l4.414 -4.414a2 2 0 0 0 0 -2.829l-1.171 -1.171a2 2 0 0 0 -2.829 0l-4.414 4.414\" />\n  <path d=\"M4 20l1.768 -1.768\" />\n  <path d=\"M3 3l18 18\" />"),
    BASELINE(
        "baseline",
        "<path d=\"M4 20h16\" />\n  <path d=\"M8 16v-8a4 4 0 1 1 8 0v8\" />\n  <path d=\"M8 10h8\" />"),
    BASELINE_DENSITY_LARGE(
        "baseline-density-large", "<path d=\"M4 4h16\" />\n  <path d=\"M4 20h16\" />"),
    BASELINE_DENSITY_MEDIUM(
        "baseline-density-medium",
        "<path d=\"M4 20h16\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M4 4h16\" />"),
    BASELINE_DENSITY_SMALL(
        "baseline-density-small",
        "<path d=\"M4 3h16\" />\n  <path d=\"M4 9h16\" />\n  <path d=\"M4 15h16\" />\n  <path d=\"M4 21h16\" />"),
    BIBLE(
        "bible",
        "<path d=\"M19 4v16h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12\" />\n  <path d=\"M19 16h-12a2 2 0 0 0 -2 2\" />\n  <path d=\"M12 7v6\" />\n  <path d=\"M10 9h4\" />"),
    BLOCKQUOTE(
        "blockquote",
        "<path d=\"M6 15h15\" />\n  <path d=\"M21 19h-15\" />\n  <path d=\"M15 11h6\" />\n  <path d=\"M21 7h-6\" />\n  <path d=\"M9 9h1a1 1 0 1 1 -1 1v-2.5a2 2 0 0 1 2 -2\" />\n  <path d=\"M3 9h1a1 1 0 1 1 -1 1v-2.5a2 2 0 0 1 2 -2\" />"),
    BOLD(
        "bold",
        "<path d=\"M7 5h6a3.5 3.5 0 0 1 0 7h-6l0 -7\" />\n  <path d=\"M13 12h1a3.5 3.5 0 0 1 0 7h-7v-7\" />"),
    BOLD_OFF(
        "bold-off",
        "<path d=\"M9 5h4a3.5 3.5 0 0 1 2.222 6.204m-3.222 .796h-5v-5\" />\n  <path d=\"M17.107 17.112a3.5 3.5 0 0 1 -3.107 1.888h-7v-7\" />\n  <path d=\"M3 3l18 18\" />"),
    CLEAR_FORMATTING(
        "clear-formatting",
        "<path d=\"M17 15l4 4m0 -4l-4 4\" />\n  <path d=\"M7 6v-1h11v1\" />\n  <path d=\"M7 19l4 0\" />\n  <path d=\"M13 5l-4 14\" />"),
    CODE(
        "code",
        "<path d=\"M7 8l-4 4l4 4\" />\n  <path d=\"M17 8l4 4l-4 4\" />\n  <path d=\"M14 4l-4 16\" />"),
    CODE_ASTERISK(
        "code-asterisk",
        "<path d=\"M6 19a2 2 0 0 1 -2 -2v-4l-1 -1l1 -1v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M12 11.875l3 -1.687\" />\n  <path d=\"M12 11.875v3.375\" />\n  <path d=\"M12 11.875l-3 -1.687\" />\n  <path d=\"M12 11.875l3 1.688\" />\n  <path d=\"M12 8.5v3.375\" />\n  <path d=\"M12 11.875l-3 1.688\" />\n  <path d=\"M18 19a2 2 0 0 0 2 -2v-4l1 -1l-1 -1v-4a2 2 0 0 0 -2 -2\" />"),
    CODE_CIRCLE(
        "code-circle",
        "<path d=\"M10 14l-2 -2l2 -2\" />\n  <path d=\"M14 10l2 2l-2 2\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CODE_CIRCLE_2(
        "code-circle-2",
        "<path d=\"M8.5 13.5l-1.5 -1.5l1.5 -1.5\" />\n  <path d=\"M15.5 10.5l1.5 1.5l-1.5 1.5\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M13 9.5l-2 5.5\" />"),
    CODE_DOTS(
        "code-dots",
        "<path d=\"M15 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M9 12h.01\" />\n  <path d=\"M6 19a2 2 0 0 1 -2 -2v-4l-1 -1l1 -1v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M18 19a2 2 0 0 0 2 -2v-4l1 -1l-1 -1v-4a2 2 0 0 0 -2 -2\" />"),
    CODE_MINUS(
        "code-minus",
        "<path d=\"M9 12h6\" />\n  <path d=\"M6 19a2 2 0 0 1 -2 -2v-4l-1 -1l1 -1v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M18 19a2 2 0 0 0 2 -2v-4l1 -1l-1 -1v-4a2 2 0 0 0 -2 -2\" />"),
    CODE_OFF(
        "code-off",
        "<path d=\"M7 8l-4 4l4 4\" />\n  <path d=\"M17 8l4 4l-2.5 2.5\" />\n  <path d=\"M14 4l-1.201 4.805m-.802 3.207l-2 7.988\" />\n  <path d=\"M3 3l18 18\" />"),
    CODE_PLUS(
        "code-plus",
        "<path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M6 19a2 2 0 0 1 -2 -2v-4l-1 -1l1 -1v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M18 19a2 2 0 0 0 2 -2v-4l1 -1l-1 -1v-4a2 2 0 0 0 -2 -2\" />"),
    COLUMNS(
        "columns",
        "<path d=\"M4 6l5.5 0\" />\n  <path d=\"M4 10l5.5 0\" />\n  <path d=\"M4 14l5.5 0\" />\n  <path d=\"M4 18l5.5 0\" />\n  <path d=\"M14.5 6l5.5 0\" />\n  <path d=\"M14.5 10l5.5 0\" />\n  <path d=\"M14.5 14l5.5 0\" />\n  <path d=\"M14.5 18l5.5 0\" />"),
    COLUMNS_1(
        "columns-1",
        "<path d=\"M5 4a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v16a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -16\" />"),
    COLUMNS_2(
        "columns-2",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v16a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-16\" />\n  <path d=\"M12 3v18\" />"),
    COLUMNS_3(
        "columns-3",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v16a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-16\" />\n  <path d=\"M9 3v18\" />\n  <path d=\"M15 3v18\" />"),
    COLUMNS_OFF(
        "columns-off",
        "<path d=\"M4 6h2\" />\n  <path d=\"M4 10h5.5\" />\n  <path d=\"M4 14h5.5\" />\n  <path d=\"M4 18h5.5\" />\n  <path d=\"M14.5 6h5.5\" />\n  <path d=\"M14.5 10h5.5\" />\n  <path d=\"M18 14h2\" />\n  <path d=\"M14.5 18h3.5\" />\n  <path d=\"M3 3l18 18\" />"),
    COPY(
        "copy",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 16.737a2.005 2.005 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />"),
    COPY_CHECK(
        "copy-check",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 16.737a2 2 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />\n  <path d=\"M11 14l2 2l4 -4\" />"),
    COPY_MINUS(
        "copy-minus",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 16.737a2 2 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />\n  <path d=\"M11 14h6\" />"),
    COPY_OFF(
        "copy-off",
        "<path d=\"M19.414 19.415a2 2 0 0 1 -1.414 .585h-8a2 2 0 0 1 -2 -2v-8c0 -.554 .225 -1.055 .589 -1.417m3.411 -.583h6a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 8v-2a2 2 0 0 0 -2 -2h-6m-3.418 .59c-.36 .36 -.582 .86 -.582 1.41v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M3 3l18 18\" />"),
    COPY_PLUS(
        "copy-plus",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 16.737a2 2 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />\n  <path d=\"M11 14h6\" />\n  <path d=\"M14 11v6\" />"),
    COPY_X(
        "copy-x",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667l0 -8.666\" />\n  <path d=\"M4.012 16.737a2 2 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />\n  <path d=\"M11.5 11.5l4.9 5\" />\n  <path d=\"M16.5 11.5l-5.1 5\" />"),
    CURSOR_TEXT(
        "cursor-text",
        "<path d=\"M10 12h4\" />\n  <path d=\"M9 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3\" />\n  <path d=\"M15 4a3 3 0 0 0 -3 3v10a3 3 0 0 0 3 3\" />"),
    DUPLICATE(
        "duplicate",
        "<path d=\"M7 9.667a2.667 2.667 0 0 1 2.667 -2.667h8.666a2.667 2.667 0 0 1 2.667 2.667v8.666a2.667 2.667 0 0 1 -2.667 2.667h-8.666a2.667 2.667 0 0 1 -2.667 -2.667v-8.666\" />\n  <path d=\"M11 14h6\" />\n  <path d=\"M14 11v6\" />\n  <path d=\"M4.012 16.737a2 2 0 0 1 -1.012 -1.737v-10c0 -1.1 .9 -2 2 -2h10c.75 0 1.158 .385 1.5 1\" />"),
    EMPHASIS(
        "emphasis",
        "<path d=\"M16 5h-8v10h8m-1 -5h-7\" />\n  <path d=\"M6 20l0 .01\" />\n  <path d=\"M10 20l0 .01\" />\n  <path d=\"M14 20l0 .01\" />\n  <path d=\"M18 20l0 .01\" />"),
    ERASER(
        "eraser",
        "<path d=\"M19 20h-10.5l-4.21 -4.3a1 1 0 0 1 0 -1.41l10 -10a1 1 0 0 1 1.41 0l5 5a1 1 0 0 1 0 1.41l-9.2 9.3\" />\n  <path d=\"M18 13.3l-6.3 -6.3\" />"),
    ERASER_OFF(
        "eraser-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M19 20h-10.5l-4.21 -4.3a1 1 0 0 1 0 -1.41l5 -4.993m2.009 -2.01l3 -3a1 1 0 0 1 1.41 0l5 5a1 1 0 0 1 0 1.41c-1.417 1.431 -2.406 2.432 -2.97 3m-2.02 2.043l-4.211 4.256\" />\n  <path d=\"M18 13.3l-6.3 -6.3\" />"),
    FLOAT_CENTER(
        "float-center",
        "<path d=\"M9 6a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 7l1 0\" />\n  <path d=\"M4 11l1 0\" />\n  <path d=\"M19 7l1 0\" />\n  <path d=\"M19 11l1 0\" />\n  <path d=\"M4 15l16 0\" />\n  <path d=\"M4 19l16 0\" />"),
    FLOAT_LEFT(
        "float-left",
        "<path d=\"M4 6a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M14 7l6 0\" />\n  <path d=\"M14 11l6 0\" />\n  <path d=\"M4 15l16 0\" />\n  <path d=\"M4 19l16 0\" />"),
    FLOAT_NONE(
        "float-none",
        "<path d=\"M4 6a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 15l16 0\" />\n  <path d=\"M4 19l16 0\" />"),
    FLOAT_RIGHT(
        "float-right",
        "<path d=\"M14 6a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 7l6 0\" />\n  <path d=\"M4 11l6 0\" />\n  <path d=\"M4 15l16 0\" />\n  <path d=\"M4 19l16 0\" />"),
    FORMS(
        "forms",
        "<path d=\"M12 3a3 3 0 0 0 -3 3v12a3 3 0 0 0 3 3\" />\n  <path d=\"M6 3a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3\" />\n  <path d=\"M13 7h7a1 1 0 0 1 1 1v8a1 1 0 0 1 -1 1h-7\" />\n  <path d=\"M5 7h-1a1 1 0 0 0 -1 1v8a1 1 0 0 0 1 1h1\" />\n  <path d=\"M17 12h.01\" />\n  <path d=\"M13 12h.01\" />"),
    H_1(
        "h-1",
        "<path d=\"M19 18v-8l-2 2\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    H_2(
        "h-2",
        "<path d=\"M17 12a2 2 0 1 1 4 0c0 .591 -.417 1.318 -.816 1.858l-3.184 4.143l4 0\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    H_3(
        "h-3",
        "<path d=\"M19 14a2 2 0 1 0 -2 -2\" />\n  <path d=\"M17 16a2 2 0 1 0 2 -2\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    H_4(
        "h-4",
        "<path d=\"M20 18v-8l-4 6h5\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    H_5(
        "h-5",
        "<path d=\"M17 18h2a2 2 0 1 0 0 -4h-2v-4h4\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    H_6(
        "h-6",
        "<path d=\"M19 14a2 2 0 1 0 0 4a2 2 0 0 0 0 -4\" />\n  <path d=\"M21 12a2 2 0 1 0 -4 0v4\" />\n  <path d=\"M4 6v12\" />\n  <path d=\"M12 6v12\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M3 18h2\" />\n  <path d=\"M4 12h8\" />\n  <path d=\"M3 6h2\" />\n  <path d=\"M11 6h2\" />"),
    HEADING(
        "heading",
        "<path d=\"M7 12h10\" />\n  <path d=\"M7 5v14\" />\n  <path d=\"M17 5v14\" />\n  <path d=\"M15 19h4\" />\n  <path d=\"M15 5h4\" />\n  <path d=\"M5 19h4\" />\n  <path d=\"M5 5h4\" />"),
    HEADING_OFF(
        "heading-off",
        "<path d=\"M7 12h5m4 0h1\" />\n  <path d=\"M7 7v12\" />\n  <path d=\"M17 5v8m0 4v2\" />\n  <path d=\"M15 19h4\" />\n  <path d=\"M15 5h4\" />\n  <path d=\"M5 19h4\" />\n  <path d=\"M3 3l18 18\" />"),
    HIGHLIGHT(
        "highlight",
        "<path d=\"M3 19h4l10.5 -10.5a2.828 2.828 0 1 0 -4 -4l-10.5 10.5v4\" />\n  <path d=\"M12.5 5.5l4 4\" />\n  <path d=\"M4.5 13.5l4 4\" />\n  <path d=\"M21 15v4h-8l4 -4l4 0\" />"),
    HIGHLIGHT_OFF(
        "highlight-off",
        "<path d=\"M9 9l-6 6v4h4l6 -6m2 -2l2.503 -2.503a2.828 2.828 0 1 0 -4 -4l-2.497 2.497\" />\n  <path d=\"M12.5 5.5l4 4\" />\n  <path d=\"M4.5 13.5l4 4\" />\n  <path d=\"M19 15h2v2m-2 2h-6l3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    INDENT_DECREASE(
        "indent-decrease",
        "<path d=\"M20 6l-7 0\" />\n  <path d=\"M20 12l-9 0\" />\n  <path d=\"M20 18l-7 0\" />\n  <path d=\"M8 8l-4 4l4 4\" />"),
    INDENT_INCREASE(
        "indent-increase",
        "<path d=\"M20 6l-11 0\" />\n  <path d=\"M20 12l-7 0\" />\n  <path d=\"M20 18l-11 0\" />\n  <path d=\"M4 8l4 4l-4 4\" />"),
    INPUT_SEARCH(
        "input-search",
        "<path d=\"M20 11v-2a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v5a2 2 0 0 0 2 2h5\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    ITALIC(
        "italic",
        "<path d=\"M11 5l6 0\" />\n  <path d=\"M7 19l6 0\" />\n  <path d=\"M14 5l-4 14\" />"),
    ITALIC_OFF(
        "italic-off",
        "<path d=\"M11 5h6\" />\n  <path d=\"M7 19h6\" />\n  <path d=\"M11.8 12.9l-1.8 6.1\" />\n  <path d=\"M2.8 3l18 18\" />\n  <path d=\"M14 5l-1.2 4.1\" />"),
    KERNING(
        "kerning",
        "<path d=\"M16 15v-3.5a2.5 2.5 0 1 1 5 0v3.5m0 -2h-5\" />\n  <path d=\"M3 9l3 6l3 -6\" />\n  <path d=\"M9 20l6 -16\" />"),
    LANGUAGE(
        "language",
        "<path d=\"M9 6.371c0 4.418 -2.239 6.629 -5 6.629\" />\n  <path d=\"M4 6.371h7\" />\n  <path d=\"M5 9c0 2.144 2.252 3.908 6 4\" />\n  <path d=\"M12 20l4 -9l4 9\" />\n  <path d=\"M19.1 18h-6.2\" />\n  <path d=\"M6.694 3l.793 .582\" />"),
    LANGUAGE_HIRAGANA(
        "language-hiragana",
        "<path d=\"M4 5h7\" />\n  <path d=\"M7 4c0 4.846 0 7 .5 8\" />\n  <path d=\"M10 8.5c0 2.286 -2 4.5 -3.5 4.5s-2.5 -1.135 -2.5 -2c0 -2 1 -3 3 -3s5 .57 5 2.857c0 1.524 -.667 2.571 -2 3.143\" />\n  <path d=\"M12 20l4 -9l4 9\" />\n  <path d=\"M19.1 18h-6.2\" />"),
    LANGUAGE_KATAKANA(
        "language-katakana",
        "<path d=\"M5 5h6.586a1 1 0 0 1 .707 1.707l-1.293 1.293\" />\n  <path d=\"M8 8c0 1.5 .5 3 -2 5\" />\n  <path d=\"M12 20l4 -9l4 9\" />\n  <path d=\"M19.1 18h-6.2\" />"),
    LANGUAGE_OFF(
        "language-off",
        "<path d=\"M12 20l2.463 -5.541m1.228 -2.764l.309 -.695l.8 1.8\" />\n  <path d=\"M18 18h-5.1\" />\n  <path d=\"M8.747 8.748c-.66 2.834 -2.536 4.252 -4.747 4.252\" />\n  <path d=\"M4 6.371l2.371 0\" />\n  <path d=\"M5 9c0 2.144 2.252 3.908 6 4\" />\n  <path d=\"M3 3l18 18\" />"),
    LETTER_CASE(
        "letter-case",
        "<path d=\"M14 15.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M3 19v-10.5a3.5 3.5 0 0 1 7 0v10.5\" />\n  <path d=\"M3 13h7\" />\n  <path d=\"M21 12v7\" />"),
    LETTER_CASE_LOWER(
        "letter-case-lower",
        "<path d=\"M3 15.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M10 12v7\" />\n  <path d=\"M14 15.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M21 12v7\" />"),
    LETTER_CASE_TOGGLE(
        "letter-case-toggle",
        "<path d=\"M3 15.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M14 19v-10.5a3.5 3.5 0 0 1 7 0v10.5\" />\n  <path d=\"M14 13h7\" />\n  <path d=\"M10 12v7\" />"),
    LETTER_CASE_UPPER(
        "letter-case-upper",
        "<path d=\"M3 19v-10.5a3.5 3.5 0 0 1 7 0v10.5\" />\n  <path d=\"M3 13h7\" />\n  <path d=\"M14 19v-10.5a3.5 3.5 0 0 1 7 0v10.5\" />\n  <path d=\"M14 13h7\" />"),
    LETTER_SPACING(
        "letter-spacing",
        "<path d=\"M5 12v-5.5a2.5 2.5 0 0 1 5 0v5.5m0 -4h-5\" />\n  <path d=\"M13 4l3 8l3 -8\" />\n  <path d=\"M5 18h14\" />\n  <path d=\"M17 20l2 -2l-2 -2\" />\n  <path d=\"M7 16l-2 2l2 2\" />"),
    LINE_HEIGHT(
        "line-height",
        "<path d=\"M3 8l3 -3l3 3\" />\n  <path d=\"M3 16l3 3l3 -3\" />\n  <path d=\"M6 5l0 14\" />\n  <path d=\"M13 6l7 0\" />\n  <path d=\"M13 12l7 0\" />\n  <path d=\"M13 18l7 0\" />"),
    LINK(
        "link",
        "<path d=\"M9 15l6 -6\" />\n  <path d=\"M11 6l.463 -.536a5 5 0 0 1 7.071 7.072l-.534 .464\" />\n  <path d=\"M13 18l-.397 .534a5.068 5.068 0 0 1 -7.127 0a4.972 4.972 0 0 1 0 -7.071l.524 -.463\" />"),
    LINK_MINUS(
        "link-minus",
        "<path d=\"M9 15l6 -6\" />\n  <path d=\"M11 6l.463 -.536a5 5 0 1 1 7.071 7.072l-.534 .464\" />\n  <path d=\"M12.603 18.534a5.07 5.07 0 0 1 -7.127 0a4.972 4.972 0 0 1 0 -7.071l.524 -.463\" />\n  <path d=\"M16 19h6\" />"),
    LINK_OFF(
        "link-off",
        "<path d=\"M9 15l3 -3m2 -2l1 -1\" />\n  <path d=\"M11 6l.463 -.536a5 5 0 0 1 7.071 7.072l-.534 .464\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M13 18l-.397 .534a5.068 5.068 0 0 1 -7.127 0a4.972 4.972 0 0 1 0 -7.071l.524 -.463\" />"),
    LINK_PLUS(
        "link-plus",
        "<path d=\"M9 15l6 -6\" />\n  <path d=\"M11 6l.463 -.536a5 5 0 0 1 7.072 0a4.993 4.993 0 0 1 -.001 7.072\" />\n  <path d=\"M12.603 18.534a5.07 5.07 0 0 1 -7.127 0a4.972 4.972 0 0 1 0 -7.071l.524 -.463\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    LIST(
        "list",
        "<path d=\"M9 6l11 0\" />\n  <path d=\"M9 12l11 0\" />\n  <path d=\"M9 18l11 0\" />\n  <path d=\"M5 6l0 .01\" />\n  <path d=\"M5 12l0 .01\" />\n  <path d=\"M5 18l0 .01\" />"),
    LIST_CHECK(
        "list-check",
        "<path d=\"M3.5 5.5l1.5 1.5l2.5 -2.5\" />\n  <path d=\"M3.5 11.5l1.5 1.5l2.5 -2.5\" />\n  <path d=\"M3.5 17.5l1.5 1.5l2.5 -2.5\" />\n  <path d=\"M11 6l9 0\" />\n  <path d=\"M11 12l9 0\" />\n  <path d=\"M11 18l9 0\" />"),
    LIST_DETAILS(
        "list-details",
        "<path d=\"M13 5h8\" />\n  <path d=\"M13 9h5\" />\n  <path d=\"M13 15h8\" />\n  <path d=\"M13 19h5\" />\n  <path d=\"M3 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M3 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />"),
    LIST_NUMBERS(
        "list-numbers",
        "<path d=\"M11 6h9\" />\n  <path d=\"M11 12h9\" />\n  <path d=\"M12 18h8\" />\n  <path d=\"M4 16a2 2 0 1 1 4 0c0 .591 -.5 1 -1 1.5l-3 2.5h4\" />\n  <path d=\"M6 10v-6l-2 2\" />"),
    LIST_SEARCH(
        "list-search",
        "<path d=\"M11 15a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M18.5 18.5l2.5 2.5\" />\n  <path d=\"M4 6h16\" />\n  <path d=\"M4 12h4\" />\n  <path d=\"M4 18h4\" />"),
    MARKDOWN(
        "markdown",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 15v-6l2 2l2 -2v6\" />\n  <path d=\"M14 13l2 2l2 -2m-2 2v-6\" />"),
    MARKDOWN_OFF(
        "markdown-off",
        "<path d=\"M9 5h10a2 2 0 0 1 2 2v10\" />\n  <path d=\"M19 19h-14a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 1.85 -2\" />\n  <path d=\"M7 15v-6l2 2l1 -1m1 1v4\" />\n  <path d=\"M17.5 13.5l.5 -.5m-2 -1v-3\" />\n  <path d=\"M3 3l18 18\" />"),
    NOTDEF(
        "notdef",
        "<path d=\"M18.49 3.666l-12.976 16.673\" />\n  <path d=\"M5.51 3.666l12.976 16.673\" />\n  <path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />"),
    OVERLINE("overline", "<path d=\"M7 9v5a5 5 0 0 0 10 0v-5\" />\n  <path d=\"M5 5h14\" />"),
    PILCROW(
        "pilcrow",
        "<path d=\"M13 4v16\" />\n  <path d=\"M17 4v16\" />\n  <path d=\"M19 4h-9.5a4.5 4.5 0 0 0 0 9h3.5\" />"),
    PILCROW_LEFT(
        "pilcrow-left",
        "<path d=\"M11 9h-2a3 3 0 1 1 0 -6h7\" />\n  <path d=\"M11 3v11\" />\n  <path d=\"M15 3v11\" />\n  <path d=\"M3 18h18\" />\n  <path d=\"M6 15l-3 3l3 3\" />"),
    PILCROW_RIGHT(
        "pilcrow-right",
        "<path d=\"M11 9h-2a3 3 0 1 1 0 -6h7\" />\n  <path d=\"M11 3v11\" />\n  <path d=\"M15 3v11\" />\n  <path d=\"M21 18h-18\" />\n  <path d=\"M18 15l3 3l-3 3\" />"),
    QUOTE(
        "quote",
        "<path d=\"M10 11h-4a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v6c0 2.667 -1.333 4.333 -4 5\" />\n  <path d=\"M19 11h-4a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v6c0 2.667 -1.333 4.333 -4 5\" />"),
    QUOTE_OFF(
        "quote-off",
        "<path d=\"M10 11h-4a1 1 0 0 1 -1 -1v-3a1 1 0 0 1 1 -1m4 4v3c0 2.667 -1.333 4.333 -4 5\" />\n  <path d=\"M19 11h-4m-1 -1v-3a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v6c0 .66 -.082 1.26 -.245 1.798m-1.653 2.29c-.571 .4 -1.272 .704 -2.102 .912\" />\n  <path d=\"M3 3l18 18\" />"),
    QUOTE_OPEN(
        "quote-open",
        "<path d=\"M14 13h4a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1v-6q 0 -4 4 -5\" />\n  <path d=\"M5 13h4a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1v-6q 0 -4 4 -5\" />"),
    QUOTES(
        "quotes",
        "<path d=\"M4 12c-1.333 -1.854 -1.333 -4.146 0 -6\" />\n  <path d=\"M8 12c-1.333 -1.854 -1.333 -4.146 0 -6\" />\n  <path d=\"M16 18c1.333 -1.854 1.333 -4.146 0 -6\" />\n  <path d=\"M20 18c1.333 -1.854 1.333 -4.146 0 -6\" />"),
    REGEX(
        "regex",
        "<path d=\"M6.5 15a2.5 2.5 0 1 1 0 5a2.5 2.5 0 0 1 0 -5\" />\n  <path d=\"M17 7.875l3 -1.687\" />\n  <path d=\"M17 7.875v3.375\" />\n  <path d=\"M17 7.875l-3 -1.687\" />\n  <path d=\"M17 7.875l3 1.688\" />\n  <path d=\"M17 4.5v3.375\" />\n  <path d=\"M17 7.875l-3 1.688\" />"),
    REGEX_OFF(
        "regex-off",
        "<path d=\"M6.5 15a2.5 2.5 0 1 1 0 5a2.5 2.5 0 0 1 0 -5\" />\n  <path d=\"M17 7.875l3 -1.687\" />\n  <path d=\"M17 7.875v3.375\" />\n  <path d=\"M17 7.875l-3 -1.687\" />\n  <path d=\"M17 7.875l3 1.688\" />\n  <path d=\"M17 4.5v3.375\" />\n  <path d=\"M17 7.875l-3 1.688\" />\n  <path d=\"M3 3l18 18\" />"),
    SCRIBBLE(
        "scribble",
        "<path d=\"M3 15c2 3 4 4 7 4s7 -3 7 -7s-3 -7 -6 -7s-5 1.5 -5 4s2 5 6 5s8.408 -2.453 10 -5\" />"),
    SCRIBBLE_OFF(
        "scribble-off",
        "<path d=\"M3 15c2 3 4 4 7 4c1.95 0 4.324 -1.268 5.746 -3.256m1.181 -2.812a5.97 5.97 0 0 0 .073 -.932c0 -4 -3 -7 -6 -7c-.642 0 -1.239 .069 -1.78 .201m-2.492 1.515c-.47 .617 -.728 1.386 -.728 2.284c0 2.5 2 5 6 5c.597 0 1.203 -.055 1.808 -.156m3.102 -.921c2.235 -.953 4.152 -2.423 5.09 -3.923\" />\n  <path d=\"M3 3l18 18\" />"),
    SECTION_SIGN(
        "section-sign",
        "<path d=\"M9.172 19a3 3 0 1 0 2.828 -4\" />\n  <path d=\"M14.83 5a3 3 0 1 0 -2.83 4\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    SEPARATOR(
        "separator",
        "<path d=\"M3 12l0 .01\" />\n  <path d=\"M7 12l10 0\" />\n  <path d=\"M21 12l0 .01\" />"),
    SEPARATOR_HORIZONTAL(
        "separator-horizontal",
        "<path d=\"M4 12l16 0\" />\n  <path d=\"M8 8l4 -4l4 4\" />\n  <path d=\"M16 16l-4 4l-4 -4\" />"),
    SEPARATOR_VERTICAL(
        "separator-vertical",
        "<path d=\"M12 4l0 16\" />\n  <path d=\"M8 8l-4 4l4 4\" />\n  <path d=\"M16 16l4 -4l-4 -4\" />"),
    SIGNATURE(
        "signature",
        "<path d=\"M3 17c3.333 -3.333 5 -6 5 -8c0 -3 -1 -3 -2 -3s-2.032 1.085 -2 3c.034 2.048 1.658 4.877 2.5 6c1.5 2 2.5 2.5 3.5 1l2 -3c.333 2.667 1.333 4 3 4c.53 0 2.639 -2 3 -2c.517 0 1.517 .667 3 2\" />"),
    SIGNATURE_OFF(
        "signature-off",
        "<path d=\"M3 17c3.333 -3.333 5 -6 5 -8c0 -.394 -.017 -.735 -.05 -1.033m-1.95 -1.967c-1 0 -2.032 1.085 -2 3c.034 2.048 1.658 4.877 2.5 6c1.5 2 2.5 2.5 3.5 1l2 -3c.333 2.667 1.333 4 3 4c.219 0 .708 -.341 1.231 -.742m3.769 -.258c.303 .245 .64 .677 1 1\" />\n  <path d=\"M3 3l18 18\" />"),
    SLIDESHOW(
        "slideshow",
        "<path d=\"M15 6l.01 0\" />\n  <path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3l0 -8\" />\n  <path d=\"M3 13l4 -4a3 5 0 0 1 3 0l4 4\" />\n  <path d=\"M13 12l2 -2a3 5 0 0 1 3 0l3 3\" />\n  <path d=\"M8 21l.01 0\" />\n  <path d=\"M12 21l.01 0\" />\n  <path d=\"M16 21l.01 0\" />"),
    SORT_0_9(
        "sort-0-9",
        "<path d=\"M11 12h2\" />\n  <path d=\"M4 10v4a2 2 0 1 0 4 0v-4a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-6a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v2a1 1 0 0 0 1 1h3\" />"),
    SORT_9_0(
        "sort-9-0",
        "<path d=\"M4 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-6a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v2a1 1 0 0 0 1 1h3\" />\n  <path d=\"M16 10v4a2 2 0 1 0 4 0v-4a2 2 0 1 0 -4 0\" />\n  <path d=\"M11 12h2\" />"),
    SORT_A_Z(
        "sort-a-z",
        "<path d=\"M16 8h4l-4 8h4\" />\n  <path d=\"M4 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M4 13h4\" />\n  <path d=\"M11 12h2\" />"),
    SORT_ASCENDING(
        "sort-ascending",
        "<path d=\"M4 6l7 0\" />\n  <path d=\"M4 12l7 0\" />\n  <path d=\"M4 18l9 0\" />\n  <path d=\"M15 9l3 -3l3 3\" />\n  <path d=\"M18 6l0 12\" />"),
    SORT_ASCENDING_2(
        "sort-ascending-2",
        "<path d=\"M14 9l3 -3l3 3\" />\n  <path d=\"M5 5.5a.5 .5 0 0 1 .5 -.5h4a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-4a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M5 14.5a.5 .5 0 0 1 .5 -.5h4a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-4a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M17 6v12\" />"),
    SORT_ASCENDING_LETTERS(
        "sort-ascending-letters",
        "<path d=\"M15 10v-5c0 -1.38 .62 -2 2 -2s2 .62 2 2v5m0 -3h-4\" />\n  <path d=\"M19 21h-4l4 -7h-4\" />\n  <path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />"),
    SORT_ASCENDING_NUMBERS(
        "sort-ascending-numbers",
        "<path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M17 3a2 2 0 0 1 2 2v3a2 2 0 1 1 -4 0v-3a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 16a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19 16v3a2 2 0 0 1 -2 2h-1.5\" />"),
    SORT_DESCENDING(
        "sort-descending",
        "<path d=\"M4 6l9 0\" />\n  <path d=\"M4 12l7 0\" />\n  <path d=\"M4 18l7 0\" />\n  <path d=\"M15 15l3 3l3 -3\" />\n  <path d=\"M18 6l0 12\" />"),
    SORT_DESCENDING_2(
        "sort-descending-2",
        "<path d=\"M5 5.5a.5 .5 0 0 1 .5 -.5h4a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-4a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M5 14.5a.5 .5 0 0 1 .5 -.5h4a.5 .5 0 0 1 .5 .5v4a.5 .5 0 0 1 -.5 .5h-4a.5 .5 0 0 1 -.5 -.5l0 -4\" />\n  <path d=\"M14 15l3 3l3 -3\" />\n  <path d=\"M17 18v-12\" />"),
    SORT_DESCENDING_LETTERS(
        "sort-descending-letters",
        "<path d=\"M15 21v-5c0 -1.38 .62 -2 2 -2s2 .62 2 2v5m0 -3h-4\" />\n  <path d=\"M19 10h-4l4 -7h-4\" />\n  <path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />"),
    SORT_DESCENDING_NUMBERS(
        "sort-descending-numbers",
        "<path d=\"M4 15l3 3l3 -3\" />\n  <path d=\"M7 6v12\" />\n  <path d=\"M17 14a2 2 0 0 1 2 2v3a2 2 0 1 1 -4 0v-3a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19 5v3a2 2 0 0 1 -2 2h-1.5\" />"),
    SORT_Z_A(
        "sort-z-a",
        "<path d=\"M4 8h4l-4 8h4\" />\n  <path d=\"M16 16v-6a2 2 0 1 1 4 0v6\" />\n  <path d=\"M16 13h4\" />\n  <path d=\"M11 12h2\" />"),
    SPACE("space", "<path d=\"M4 10v3a1 1 0 0 0 1 1h14a1 1 0 0 0 1 -1v-3\" />"),
    SPACE_OFF(
        "space-off",
        "<path d=\"M4 10v3a1 1 0 0 0 1 1h9m4 0h1a1 1 0 0 0 1 -1v-3\" />\n  <path d=\"M3 3l18 18\" />"),
    STRIKETHROUGH(
        "strikethrough",
        "<path d=\"M5 12l14 0\" />\n  <path d=\"M16 6.5a4 2 0 0 0 -4 -1.5h-1a3.5 3.5 0 0 0 0 7h2a3.5 3.5 0 0 1 0 7h-1.5a4 2 0 0 1 -4 -1.5\" />"),
    SUBSCRIPT(
        "subscript",
        "<path d=\"M5 7l8 10m-8 0l8 -10\" />\n  <path d=\"M21 20h-4l3.5 -4a1.73 1.73 0 0 0 -3.5 -2\" />"),
    SUPERSCRIPT(
        "superscript",
        "<path d=\"M5 7l8 10m-8 0l8 -10\" />\n  <path d=\"M21 11h-4l3.5 -4a1.73 1.73 0 0 0 -3.5 -2\" />"),
    TEX(
        "tex",
        "<path d=\"M9 8v-1h-6v1\" />\n  <path d=\"M6 15v-8\" />\n  <path d=\"M21 15l-5 -8\" />\n  <path d=\"M16 15l5 -8\" />\n  <path d=\"M14 11h-4v8h4\" />\n  <path d=\"M10 15h3\" />"),
    TEXT_CAPTION(
        "text-caption",
        "<path d=\"M4 15h16\" />\n  <path d=\"M4 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M4 20h12\" />"),
    TEXT_COLOR(
        "text-color",
        "<path d=\"M9 15v-7a3 3 0 0 1 6 0v7\" />\n  <path d=\"M9 11h6\" />\n  <path d=\"M5 19h14\" />"),
    TEXT_DECREASE(
        "text-decrease",
        "<path d=\"M4 19v-10.5a3.5 3.5 0 1 1 7 0v10.5\" />\n  <path d=\"M4 13h7\" />\n  <path d=\"M21 12h-6\" />"),
    TEXT_DIRECTION_LTR(
        "text-direction-ltr",
        "<path d=\"M5 19h14\" />\n  <path d=\"M17 21l2 -2l-2 -2\" />\n  <path d=\"M16 4h-6.5a3.5 3.5 0 0 0 0 7h.5\" />\n  <path d=\"M14 15v-11\" />\n  <path d=\"M10 15v-11\" />"),
    TEXT_DIRECTION_RTL(
        "text-direction-rtl",
        "<path d=\"M16 4h-6.5a3.5 3.5 0 0 0 0 7h.5\" />\n  <path d=\"M14 15v-11\" />\n  <path d=\"M10 15v-11\" />\n  <path d=\"M5 19h14\" />\n  <path d=\"M7 21l-2 -2l2 -2\" />"),
    TEXT_GRAMMAR(
        "text-grammar",
        "<path d=\"M14 9a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M4 12v-5a3 3 0 1 1 6 0v5\" />\n  <path d=\"M4 9h6\" />\n  <path d=\"M20 6v6\" />\n  <path d=\"M4 16h12\" />\n  <path d=\"M4 20h6\" />\n  <path d=\"M14 20l2 2l5 -5\" />"),
    TEXT_INCREASE(
        "text-increase",
        "<path d=\"M4 19v-10.5a3.5 3.5 0 1 1 7 0v10.5\" />\n  <path d=\"M4 13h7\" />\n  <path d=\"M18 9v6\" />\n  <path d=\"M21 12h-6\" />"),
    TEXT_ORIENTATION(
        "text-orientation",
        "<path d=\"M9 15l-5 -5c-1.367 -1.367 -1.367 -3.633 0 -5s3.633 -1.367 5 0l5 5\" />\n  <path d=\"M5.5 11.5l5 -5\" />\n  <path d=\"M21 12l-9 9\" />\n  <path d=\"M21 12v4\" />\n  <path d=\"M21 12h-4\" />"),
    TEXT_OUTLINE(
        "text-outline",
        "<path d=\"M3 8v-1a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v1\" />\n  <path d=\"M3 16v1a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M21.01 12h.01\" />\n  <path d=\"M3.01 12h.01\" />\n  <path d=\"M10 15v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M10 13h4\" />"),
    TEXT_PLUS(
        "text-plus",
        "<path d=\"M19 10h-14\" />\n  <path d=\"M5 6h14\" />\n  <path d=\"M14 14h-9\" />\n  <path d=\"M5 18h6\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M15 18h6\" />"),
    TEXT_RECOGNITION(
        "text-recognition",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M12 16v-7\" />\n  <path d=\"M9 9h6\" />"),
    TEXT_REGEX_ASTERISK(
        "text-regex-asterisk",
        "<path d=\"M10 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M7 16v-3a2 2 0 1 0 -4 0v1a2 2 0 0 0 3.726 1.01\" />\n  <path d=\"M19 9.5v5\" />\n  <path d=\"M17 10.75l4 2.5\" />\n  <path d=\"M17 13.25l4 -2.5\" />"),
    TEXT_REGEX_END(
        "text-regex-end",
        "<path d=\"M10 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M7 16v-3a2 2 0 1 0 -4 0v1a2 2 0 0 0 3.726 1.01\" />\n  <path d=\"M21 10h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 10v-1\" />\n  <path d=\"M19 16v1\" />"),
    TEXT_REGEX_PLUS(
        "text-regex-plus",
        "<path d=\"M10 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M7 16v-3a2 2 0 1 0 -4 0v1a2 2 0 0 0 3.726 1.01\" />\n  <path d=\"M17 13h4\" />\n  <path d=\"M19 11v4\" />"),
    TEXT_REGEX_QUESTION(
        "text-regex-question",
        "<path d=\"M10 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M7 16v-3a2 2 0 1 0 -4 0v1a2 2 0 0 0 3.726 1.01\" />\n  <path d=\"M19 16v.01\" />\n  <path d=\"M19 13a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    TEXT_REGEX_START(
        "text-regex-start",
        "<path d=\"M17 8v6a2 2 0 1 0 4 0v-1a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M14 16v-3a2 2 0 1 0 -4 0v1a2 2 0 0 0 3.726 1.01\" />\n  <path d=\"M3 10l2 -2l2 2\" />"),
    TEXT_SIZE(
        "text-size",
        "<path d=\"M3 7v-2h13v2\" />\n  <path d=\"M10 5v14\" />\n  <path d=\"M12 19h-4\" />\n  <path d=\"M15 13v-1h6v1\" />\n  <path d=\"M18 12v7\" />\n  <path d=\"M17 19h2\" />"),
    TEXT_SPELLCHECK(
        "text-spellcheck",
        "<path d=\"M5 15v-7.5a3.5 3.5 0 0 1 7 0v7.5\" />\n  <path d=\"M5 10h7\" />\n  <path d=\"M10 18l3 3l7 -7\" />"),
    TEXT_WRAP(
        "text-wrap",
        "<path d=\"M4 6l16 0\" />\n  <path d=\"M4 18l5 0\" />\n  <path d=\"M4 12h13a3 3 0 0 1 0 6h-4l2 -2m0 4l-2 -2\" />"),
    TEXT_WRAP_COLUMN(
        "text-wrap-column",
        "<path d=\"M7 9h7a3 3 0 0 1 0 6h-4l2 -2\" />\n  <path d=\"M12 17l-2 -2\" />\n  <path d=\"M3 3v18\" />\n  <path d=\"M21 3v18\" />"),
    TEXT_WRAP_DISABLED(
        "text-wrap-disabled",
        "<path d=\"M4 6l10 0\" />\n  <path d=\"M4 18l10 0\" />\n  <path d=\"M4 12h17l-3 -3m0 6l3 -3\" />"),
    TYPOGRAPHY(
        "typography",
        "<path d=\"M4 20l3 0\" />\n  <path d=\"M14 20l7 0\" />\n  <path d=\"M6.9 15l6.9 0\" />\n  <path d=\"M10.2 6.3l5.8 13.7\" />\n  <path d=\"M5 20l6 -16l2 0l7 16\" />"),
    TYPOGRAPHY_OFF(
        "typography-off",
        "<path d=\"M4 20h3\" />\n  <path d=\"M14 20h6\" />\n  <path d=\"M6.9 15h6.9\" />\n  <path d=\"M13 13l3 7\" />\n  <path d=\"M5 20l4.09 -10.906\" />\n  <path d=\"M10.181 6.183l.819 -2.183h2l3.904 8.924\" />\n  <path d=\"M3 3l18 18\" />"),
    UNDERLINE("underline", "<path d=\"M7 5v5a5 5 0 0 0 10 0v-5\" />\n  <path d=\"M5 19h14\" />"),
    UNDERLINE_OFF(
        "underline-off",
        "<path d=\"M7 7.4v2.6c0 2.8 2.2 5 5 5c.9 0 1.8 -.2 2.4 -.6\" />\n  <path d=\"M5 19h14\" />\n  <path d=\"M3 2.7l18 18\" />\n  <path d=\"M16.4 12.4c.4 -.7 .6 -1.5 .6 -2.4v-5\" />"),
    UNLINK(
        "unlink",
        "<path d=\"M17 22v-2\" />\n  <path d=\"M9 15l6 -6\" />\n  <path d=\"M11 6l.463 -.536a5 5 0 0 1 7.071 7.072l-.534 .464\" />\n  <path d=\"M13 18l-.397 .534a5.068 5.068 0 0 1 -7.127 0a4.972 4.972 0 0 1 0 -7.071l.524 -.463\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M2 7h2\" />\n  <path d=\"M7 2v2\" />"),
    VOCABULARY(
        "vocabulary",
        "<path d=\"M10 19h-6a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1h6a2 2 0 0 1 2 2a2 2 0 0 1 2 -2h6a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-6a2 2 0 0 0 -2 2a2 2 0 0 0 -2 -2\" />\n  <path d=\"M12 5v16\" />\n  <path d=\"M7 7h1\" />\n  <path d=\"M7 11h1\" />\n  <path d=\"M16 7h1\" />\n  <path d=\"M16 11h1\" />\n  <path d=\"M16 15h1\" />"),
    VOCABULARY_OFF(
        "vocabulary-off",
        "<path d=\"M7 3h3a2 2 0 0 1 2 2a2 2 0 0 1 2 -2h6a1 1 0 0 1 1 1v13m-2 2h-5a2 2 0 0 0 -2 2a2 2 0 0 0 -2 -2h-6a1 1 0 0 1 -1 -1v-14c0 -.279 .114 -.53 .298 -.712\" />\n  <path d=\"M12 5v3m0 4v9\" />\n  <path d=\"M7 11h1\" />\n  <path d=\"M16 7h1\" />\n  <path d=\"M16 11h1\" />\n  <path d=\"M3 3l18 18\" />"),
    WRITING(
        "writing",
        "<path d=\"M20 17v-12c0 -1.121 -.879 -2 -2 -2s-2 .879 -2 2v12l2 2l2 -2\" />\n  <path d=\"M16 7h4\" />\n  <path d=\"M18 19h-13a2 2 0 1 1 0 -4h4a2 2 0 1 0 0 -4h-3\" />"),
    WRITING_OFF(
        "writing-off",
        "<path d=\"M16 7h4\" />\n  <path d=\"M16 16v1l2 2l.5 -.5m1.5 -2.5v-11c0 -1.121 -.879 -2 -2 -2s-2 .879 -2 2v7\" />\n  <path d=\"M18 19h-13a2 2 0 1 1 0 -4h4a2 2 0 1 0 0 -4h-3\" />\n  <path d=\"M3 3l18 18\" />"),
    WRITING_SIGN(
        "writing-sign",
        "<path d=\"M3 19c3.333 -2 5 -4 5 -6c0 -3 -1 -3 -2 -3s-2.032 1.085 -2 3c.034 2.048 1.658 2.877 2.5 4c1.5 2 2.5 2.5 3.5 1c.667 -1 1.167 -1.833 1.5 -2.5c1 2.333 2.333 3.5 4 3.5h2.5\" />\n  <path d=\"M20 17v-12c0 -1.121 -.879 -2 -2 -2s-2 .879 -2 2v12l2 2l2 -2\" />\n  <path d=\"M16 7h4\" />"),
    WRITING_SIGN_OFF(
        "writing-sign-off",
        "<path d=\"M3 19c3.333 -2 5 -4 5 -6c0 -3 -1 -3 -2 -3s-2.032 1.085 -2 3c.034 2.048 1.658 2.877 2.5 4c1.5 2 2.5 2.5 3.5 1c.667 -1 1.167 -1.833 1.5 -2.5c1 2.333 2.333 3.5 4 3.5h2.5\" />\n  <path d=\"M16 16v1l2 2l.5 -.5m1.5 -2.5v-11c0 -1.121 -.879 -2 -2 -2s-2 .879 -2 2v7\" />\n  <path d=\"M16 7h4\" />\n  <path d=\"M3 3l18 18\" />");

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
    ALIGN_BOX_BOTTOM_CENTER(
        "align-box-bottom-center",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-9.333 13a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 -4a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 2a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALIGN_BOX_BOTTOM_LEFT(
        "align-box-bottom-left",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-12.333 13a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 -4a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 2a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALIGN_BOX_BOTTOM_RIGHT(
        "align-box-bottom-right",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-6.333 13a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 -4a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 2a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALIGN_BOX_CENTER_MIDDLE(
        "align-box-center-middle",
        "<path d=\"M19 2a3 3 0 0 1 2.995 2.824l.005 .176v14a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.993 -2.802l-.007 -.198v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h14zm-6 12h-2l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h2l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm2 -3h-6l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h6l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-1 -3h-4l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h4l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    ALIGN_BOX_LEFT_BOTTOM(
        "align-box-left-bottom",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-10.333 15h-2l-.117 .007a1 1 0 0 0 .117 1.993h2l.117 -.007a1 1 0 0 0 -.117 -1.993zm4 -3h-6l-.117 .007a1 1 0 0 0 .117 1.993h6l.117 -.007a1 1 0 0 0 -.117 -1.993zm-2 -3h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    ALIGN_BOX_LEFT_MIDDLE(
        "align-box-left-middle",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-10.333 12h-2l-.117 .007a1 1 0 0 0 .117 1.993h2l.117 -.007a1 1 0 0 0 -.117 -1.993zm4 -3h-6l-.117 .007a1 1 0 0 0 .117 1.993h6l.117 -.007a1 1 0 0 0 -.117 -1.993zm-2 -3h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    ALIGN_BOX_LEFT_TOP(
        "align-box-left-top",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-10.333 9h-2l-.117 .007a1 1 0 0 0 .117 1.993h2l.117 -.007a1 1 0 0 0 -.117 -1.993zm4 -3h-6l-.117 .007a1 1 0 0 0 .117 1.993h6l.117 -.007a1 1 0 0 0 -.117 -1.993zm-2 -3h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    ALIGN_BOX_RIGHT_BOTTOM(
        "align-box-right-bottom",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-.333 15h-2l-.117 .007a1 1 0 0 0 .117 1.993h2l.117 -.007a1 1 0 0 0 -.117 -1.993zm0 -3h-6l-.117 .007a1 1 0 0 0 .117 1.993h6l.117 -.007a1 1 0 0 0 -.117 -1.993zm0 -3h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    ALIGN_BOX_RIGHT_MIDDLE(
        "align-box-right-middle",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-.333 12h-2l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h2l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm0 -3h-6l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h6l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm0 -3h-4l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h4l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    ALIGN_BOX_RIGHT_TOP(
        "align-box-right-top",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-.333 9h-2l-.117 .007a1 1 0 0 0 .117 1.993h2l.117 -.007a1 1 0 0 0 -.117 -1.993zm0 -3h-6l-.117 .007a1 1 0 0 0 .117 1.993h6l.117 -.007a1 1 0 0 0 -.117 -1.993zm0 -3h-4l-.117 .007a1 1 0 0 0 .117 1.993h4l.117 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    ALIGN_BOX_TOP_CENTER(
        "align-box-top-center",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-6.333 3a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm-6 0a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALIGN_BOX_TOP_LEFT(
        "align-box-top-left",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-9.333 3a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm-6 0a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    ALIGN_BOX_TOP_RIGHT(
        "align-box-top-right",
        "<path d=\"M18.333 2c1.96 0 3.56 1.537 3.662 3.472l.005 .195v12.666c0 1.96 -1.537 3.56 -3.472 3.662l-.195 .005h-12.666a3.667 3.667 0 0 1 -3.662 -3.472l-.005 -.195v-12.666c0 -1.96 1.537 -3.56 3.472 -3.662l.195 -.005h12.666zm-3.333 3a1 1 0 0 0 -1 1v6l.007 .117a1 1 0 0 0 1.993 -.117v-6l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm-6 0a1 1 0 0 0 -1 1v2l.007 .117a1 1 0 0 0 1.993 -.117v-2l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BACKSPACE(
        "backspace",
        "<path d=\"M20 5a2 2 0 0 1 1.995 1.85l.005 .15v10a2 2 0 0 1 -1.85 1.995l-.15 .005h-11a1 1 0 0 1 -.608 -.206l-.1 -.087l-5.037 -5.04c-.809 -.904 -.847 -2.25 -.083 -3.23l.12 -.144l5 -5a1 1 0 0 1 .577 -.284l.131 -.009h11zm-7.489 4.14a1 1 0 0 0 -1.301 1.473l.083 .094l1.292 1.293l-1.292 1.293l-.083 .094a1 1 0 0 0 1.403 1.403l.094 -.083l1.293 -1.292l1.293 1.292l.094 .083a1 1 0 0 0 1.403 -1.403l-.083 -.094l-1.292 -1.293l1.292 -1.293l.083 -.094a1 1 0 0 0 -1.403 -1.403l-.094 .083l-1.293 1.292l-1.293 -1.292l-.094 -.083l-.102 -.07z\" />"),
    BALLPEN(
        "ballpen",
        "<path d=\"M17.828 2a3 3 0 0 1 1.977 .743l.145 .136l1.171 1.17a3 3 0 0 1 .136 4.1l-.136 .144l-1.706 1.707l2.292 2.293a1 1 0 0 1 .083 1.32l-.083 .094l-4 4a1 1 0 0 1 -1.497 -1.32l.083 -.094l3.292 -3.293l-1.586 -1.585l-7.464 7.464a3.828 3.828 0 0 1 -2.474 1.114l-.233 .008c-.674 0 -1.33 -.178 -1.905 -.508l-1.216 1.214a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.214 -1.216a3.828 3.828 0 0 1 .454 -4.442l.16 -.17l10.586 -10.586a3 3 0 0 1 1.923 -.873l.198 -.006zm0 2a1 1 0 0 0 -.608 .206l-.099 .087l-1.707 1.707l2.586 2.585l1.707 -1.706a1 1 0 0 0 .284 -.576l.01 -.131a1 1 0 0 0 -.207 -.609l-.087 -.099l-1.171 -1.171a1 1 0 0 0 -.708 -.293z\" />"),
    CODE_CIRCLE(
        "code-circle",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-6.293 5.953a1 1 0 0 0 -1.414 0l-2 2a1 1 0 0 0 0 1.414l2 2a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-1.292 -1.293l1.292 -1.293a1 1 0 0 0 0 -1.414m4 0a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l1.292 1.293l-1.292 1.293a1 1 0 0 0 1.414 1.414l2 -2a1 1 0 0 0 0 -1.414z\" />"),
    CODE_CIRCLE_2(
        "code-circle-2",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-3.658 5.22a1 1 0 0 0 -1.282 .598l-2 5.5a1 1 0 0 0 1.88 .684l2 -5.5a1 1 0 0 0 -.598 -1.282m-4.135 1.233a1 1 0 0 0 -1.414 0l-1.5 1.5a1 1 0 0 0 0 1.414l1.5 1.5a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-.792 -.793l.792 -.793a1 1 0 0 0 0 -1.414m7 0a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l.792 .793l-.792 .793a1 1 0 0 0 1.414 1.414l1.5 -1.5a1 1 0 0 0 0 -1.414z\" />"),
    COLUMNS_1(
        "columns-1",
        "<path d=\"M18 2a2 2 0 0 1 2 2v16a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-16a2 2 0 0 1 2 -2z\" />"),
    COLUMNS_2(
        "columns-2",
        "<path d=\"M4 2h6a1 1 0 0 1 1 1v18a1 1 0 0 1 -1 1h-6a2 2 0 0 1 -2 -2v-16a2 2 0 0 1 2 -2\" />\n  <path d=\"M14 2h6a2 2 0 0 1 2 2v16a2 2 0 0 1 -2 2h-6a1 1 0 0 1 -1 -1v-18a1 1 0 0 1 1 -1\" />"),
    COLUMNS_3(
        "columns-3",
        "<path d=\"M4 2h2a1 1 0 0 1 1 1v18a1 1 0 0 1 -1 1h-2a2 2 0 0 1 -2 -2v-16a2 2 0 0 1 2 -2\" />\n  <path d=\"M9 3a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v18a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1z\" />\n  <path d=\"M18 2h2a2 2 0 0 1 2 2v16a2 2 0 0 1 -2 2h-2a1 1 0 0 1 -1 -1v-18a1 1 0 0 1 1 -1\" />"),
    COPY(
        "copy",
        "<path d=\"M20.926 7.074a3.67 3.67 0 0 1 1.074 2.593v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666q 0 -.053 .005 -.102a3.66 3.66 0 0 1 3.662 -3.565h8.666c.973 0 1.905 .386 2.593 1.074\" />\n  <path d=\"M17.374 3.514a1 1 0 1 1 -1.748 .972c-.221 -.398 -.342 -.486 -.626 -.486h-10c-.548 0 -1 .452 -1 1v9.998c0 .36 .194 .692 .507 .87a1 1 0 1 1 -.99 1.738a3 3 0 0 1 -1.517 -2.606v-10c0 -1.652 1.348 -3 3 -3h10c1.094 0 1.828 .533 2.374 1.514\" />"),
    COPY_CHECK(
        "copy-check",
        "<path d=\"M18.333 6a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-3.333 -4c1.094 0 1.828 .533 2.374 1.514a1 1 0 1 1 -1.748 .972c-.221 -.398 -.342 -.486 -.626 -.486h-10c-.548 0 -1 .452 -1 1v9.998c0 .32 .154 .618 .407 .805l.1 .065a1 1 0 1 1 -.99 1.738a3 3 0 0 1 -1.517 -2.606v-10c0 -1.652 1.348 -3 3 -3zm1.293 9.293l-3.293 3.292l-1.293 -1.292a1 1 0 0 0 -1.414 1.414l2 2a1 1 0 0 0 1.414 0l4 -4a1 1 0 0 0 -1.414 -1.414\" />"),
    COPY_MINUS(
        "copy-minus",
        "<path d=\"M18.333 6a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-3.333 -4c1.094 0 1.828 .533 2.374 1.514a1 1 0 1 1 -1.748 .972c-.221 -.398 -.342 -.486 -.626 -.486h-10c-.548 0 -1 .452 -1 1v9.998c0 .32 .154 .618 .407 .805l.1 .065a1 1 0 1 1 -.99 1.738a3 3 0 0 1 -1.517 -2.606v-10c0 -1.652 1.348 -3 3 -3zm2 11h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2\" />"),
    COPY_PLUS(
        "copy-plus",
        "<path d=\"M18.333 6a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-4.333 4a1 1 0 0 0 -1 1v2h-2a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 0 1 1h2v2a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-2h2a1 1 0 0 0 .993 -.883l.007 -.117a1 1 0 0 0 -1 -1h-2v-2a1 1 0 0 0 -.883 -.993zm1 -8c1.094 0 1.828 .533 2.374 1.514a1 1 0 1 1 -1.748 .972c-.221 -.398 -.342 -.486 -.626 -.486h-10c-.548 0 -1 .452 -1 1v9.998c0 .32 .154 .618 .407 .805l.1 .065a1 1 0 1 1 -.99 1.738a3 3 0 0 1 -1.517 -2.606v-10c0 -1.652 1.348 -3 3 -3z\" />"),
    COPY_X(
        "copy-x",
        "<path d=\"M18.333 6a3.667 3.667 0 0 1 3.667 3.667v8.666a3.667 3.667 0 0 1 -3.667 3.667h-8.666a3.667 3.667 0 0 1 -3.667 -3.667v-8.666a3.667 3.667 0 0 1 3.667 -3.667zm-3.333 -4c1.094 0 1.828 .533 2.374 1.514a1 1 0 1 1 -1.748 .972c-.221 -.398 -.342 -.486 -.626 -.486h-10c-.548 0 -1 .452 -1 1v9.998c0 .32 .154 .618 .407 .805l.1 .065a1 1 0 1 1 -.99 1.738a3 3 0 0 1 -1.517 -2.606v-10c0 -1.652 1.348 -3 3 -3zm.8 8.786l-1.837 1.799l-1.749 -1.785a1 1 0 0 0 -1.319 -.096l-.095 .082a1 1 0 0 0 -.014 1.414l1.749 1.785l-1.835 1.8a1 1 0 0 0 -.096 1.32l.082 .095a1 1 0 0 0 1.414 .014l1.836 -1.8l1.75 1.786a1 1 0 0 0 1.319 .096l.095 -.082a1 1 0 0 0 .014 -1.414l-1.75 -1.786l1.836 -1.8a1 1 0 0 0 .096 -1.319l-.082 -.095a1 1 0 0 0 -1.414 -.014\" />"),
    LINK(
        "link",
        "<path d=\"M15.707 8.293a1 1 0 0 1 0 1.414l-6 6a1 1 0 1 1 -1.414 -1.414l6 -6a1 1 0 0 1 1.414 0\" />\n  <path d=\"M19.242 4.757c2.343 2.344 2.342 6.143 -.052 8.534l-.534 .464a1 1 0 1 1 -1.312 -1.51l.483 -.416a4 4 0 0 0 0 -5.657c-1.562 -1.563 -4.095 -1.563 -5.607 -.054l-.463 .536a1 1 0 1 1 -1.514 -1.308l.513 -.59a6 6 0 0 1 8.486 .001\" />\n  <path d=\"M6.75 10.338a1 1 0 0 1 -.088 1.411l-.483 .425a3.97 3.97 0 0 0 0 5.649a4.064 4.064 0 0 0 5.678 .038l.34 -.458a1 1 0 1 1 1.606 1.194l-.397 .534l-.1 .114a6.07 6.07 0 0 1 -8.533 0a5.97 5.97 0 0 1 -1.773 -4.247c0 -1.595 .638 -3.124 1.814 -4.284l.524 -.463a1 1 0 0 1 1.411 .087\" />"),
    LIST(
        "list",
        "<path d=\"M21 6a1 1 0 0 1 -1 1h-10a1 1 0 1 1 0 -2h10a1 1 0 0 1 1 1\" />\n  <path d=\"M21 12a1 1 0 0 1 -1 1h-10a1 1 0 0 1 0 -2h10a1 1 0 0 1 1 1\" />\n  <path d=\"M21 18a1 1 0 0 1 -1 1h-10a1 1 0 0 1 0 -2h10a1 1 0 0 1 1 1\" />\n  <path d=\"M7 5.995v.02c0 1.099 -.895 1.99 -2 1.99s-2 -.891 -2 -1.99v-.02c0 -1.099 .895 -1.99 2 -1.99s2 .891 2 1.99\" />\n  <path d=\"M7 11.995v.02c0 1.099 -.895 1.99 -2 1.99s-2 -.891 -2 -1.99v-.02c0 -1.099 .895 -1.99 2 -1.99s2 .891 2 1.99\" />\n  <path d=\"M7 17.995v.02c0 1.099 -.895 1.99 -2 1.99s-2 -.891 -2 -1.99v-.02c0 -1.099 .895 -1.99 2 -1.99s2 .891 2 1.99\" />"),
    LIST_CHECK(
        "list-check",
        "<path d=\"M8.207 3.793a1 1 0 0 1 0 1.414l-2.5 2.5a1 1 0 0 1 -1.414 0l-1.5 -1.5a1 1 0 0 1 1.414 -1.414l.793 .793l1.793 -1.793a1 1 0 0 1 1.414 0\" />\n  <path d=\"M8.207 9.793a1 1 0 0 1 0 1.414l-2.5 2.5a1 1 0 0 1 -1.414 0l-1.5 -1.5a1 1 0 0 1 1.414 -1.414l.793 .793l1.793 -1.793a1 1 0 0 1 1.414 0\" />\n  <path d=\"M8.207 15.793a1 1 0 0 1 0 1.414l-2.5 2.5a1 1 0 0 1 -1.414 0l-1.5 -1.5a1 1 0 0 1 1.414 -1.414l.793 .793l1.793 -1.793a1 1 0 0 1 1.414 0\" />\n  <path d=\"M21 6a1 1 0 0 1 -1 1h-9a1 1 0 0 1 0 -2h9a1 1 0 0 1 1 1\" />\n  <path d=\"M21 12a1 1 0 0 1 -1 1h-9a1 1 0 0 1 0 -2h9a1 1 0 0 1 1 1\" />\n  <path d=\"M21 18a1 1 0 0 1 -1 1h-9a1 1 0 0 1 0 -2h9a1 1 0 0 1 1 1\" />"),
    LIST_DETAILS(
        "list-details",
        "<path d=\"M22 5a1 1 0 0 1 -1 1h-8a1 1 0 0 1 0 -2h8a1 1 0 0 1 1 1m-3 4a1 1 0 0 1 -1 1h-5a1 1 0 0 1 0 -2h5a1 1 0 0 1 1 1m3 6a1 1 0 0 1 -1 1h-8a1 1 0 0 1 0 -2h8a1 1 0 0 1 1 1m-3 4a1 1 0 0 1 -1 1h-5a1 1 0 0 1 0 -2h5a1 1 0 0 1 1 1m-11 -16a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2l.001 -4.051l.004 -.051a1.996 1.996 0 0 1 1.995 -1.898zm0 10a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2l.001 -4.051l.004 -.051a1.996 1.996 0 0 1 1.995 -1.898z\" />"),
    QUOTE(
        "quote",
        "<path d=\"M9 5a2 2 0 0 1 2 2v6c0 3.13 -1.65 5.193 -4.757 5.97a1 1 0 1 1 -.486 -1.94c2.227 -.557 3.243 -1.827 3.243 -4.03v-1h-3a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-3a2 2 0 0 1 2 -2z\" />\n  <path d=\"M18 5a2 2 0 0 1 2 2v6c0 3.13 -1.65 5.193 -4.757 5.97a1 1 0 1 1 -.486 -1.94c2.227 -.557 3.243 -1.827 3.243 -4.03v-1h-3a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-3a2 2 0 0 1 2 -2z\" />"),
    SORT_ASCENDING_2(
        "sort-ascending-2",
        "<path d=\"M16.852 5.011l.058 -.007l.09 -.004l.075 .003l.126 .017l.111 .03l.111 .044l.098 .052l.104 .074l.082 .073l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v9.585a1 1 0 0 1 -2 0v-9.585l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083a1 1 0 0 1 0 -1.414l3 -3q .053 -.054 .112 -.097l.11 -.071l.114 -.054l.105 -.035z\" />\n  <path d=\"M9.5 4a1.5 1.5 0 0 1 1.5 1.5v4a1.5 1.5 0 0 1 -1.5 1.5h-4a1.5 1.5 0 0 1 -1.5 -1.5v-4a1.5 1.5 0 0 1 1.5 -1.5z\" />\n  <path d=\"M9.5 13a1.5 1.5 0 0 1 1.5 1.5v4a1.5 1.5 0 0 1 -1.5 1.5h-4a1.5 1.5 0 0 1 -1.5 -1.5v-4a1.5 1.5 0 0 1 1.5 -1.5z\" />"),
    SORT_DESCENDING_2(
        "sort-descending-2",
        "<path d=\"M9.5 4a1.5 1.5 0 0 1 1.5 1.5v4a1.5 1.5 0 0 1 -1.5 1.5h-4a1.5 1.5 0 0 1 -1.5 -1.5v-4a1.5 1.5 0 0 1 1.5 -1.5z\" />\n  <path d=\"M9.5 13a1.5 1.5 0 0 1 1.5 1.5v4a1.5 1.5 0 0 1 -1.5 1.5h-4a1.5 1.5 0 0 1 -1.5 -1.5v-4a1.5 1.5 0 0 1 1.5 -1.5z\" />\n  <path d=\"M17 5a1 1 0 0 1 1 1v9.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006l-.075 -.003l-.126 -.017l-.111 -.03l-.111 -.044l-.098 -.052l-.096 -.067l-.09 -.08l-3 -3a1 1 0 0 1 1.414 -1.414l1.293 1.293v-9.586a1 1 0 0 1 1 -1\" />"),
    WRITING(
        "writing",
        "<path d=\"M21 8v9a1 1 0 0 1 -.293 .707l-2 2a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006h-13a3 3 0 0 1 0 -6h4a1 1 0 0 0 0 -2h-3a1 1 0 0 1 0 -2h3a3 3 0 0 1 0 6h-4a1 1 0 0 0 0 2h10.585l-.292 -.293a1 1 0 0 1 -.293 -.707v-9zm-3 -6c1.673 0 3 1.327 3 3v1h-6v-1c0 -1.673 1.327 -3 3 -3\" />"),
    WRITING_SIGN(
        "writing-sign",
        "<path d=\"M6 11c-.483 0 -1.021 .725 -1 1.983c.013 .783 .29 1.3 1.035 2.07l.107 .107l.101 -.134c.466 -.643 .714 -1.266 .752 -1.864l.005 -.162l-.003 -.563c-.017 -1.284 -.13 -1.422 -.807 -1.436zm12 -9c1.673 0 3 1.327 3 3v1h-6v-1c0 -1.673 1.327 -3 3 -3m2.707 15.707l-2 2l-.08 .071l-.043 .034l-.084 .054l-.103 .052l-.084 .032l-.08 .023l-.143 .023l-.071 .004h-2.519c-1.616 0 -2.954 -.83 -4.004 -2.393l-.026 -.04l-.273 .431l-.365 .557c-1.356 2.034 -2.942 1.691 -4.7 -.41l-.064 -.076l-.176 .147q -.897 .727 -2.045 1.438l-.332 .203a1 1 0 1 1 -1.03 -1.714a19 19 0 0 0 2.17 -1.498l.078 -.065l-.147 -.15c-.998 -1.033 -1.498 -1.904 -1.576 -3.157l-.01 -.256c-.038 -2.273 1.257 -4.017 3 -4.017c2.052 0 3 .948 3 4c0 1.218 -.47 2.392 -1.392 3.532l-.11 .13l.28 .36c.784 .985 .994 .992 1.343 .492l.047 -.069q .97 -1.456 1.437 -2.392a1 1 0 0 1 1.814 .053c.858 2.002 1.878 2.894 3.081 2.894l.085 -.001l-.292 -.292a1 1 0 0 1 -.293 -.707v-9h6v9a1 1 0 0 1 -.293 .707\" />");

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

  default TablerIcon a_b_2() {
    return TablerIcon.create(TablerText.OutlineIcon.A_B_2);
  }

  default TablerIcon a_b_off() {
    return TablerIcon.create(TablerText.OutlineIcon.A_B_OFF);
  }

  default TablerIcon abc() {
    return TablerIcon.create(TablerText.OutlineIcon.ABC);
  }

  default TablerIcon align_box_bottom_center() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_CENTER);
  }

  default TablerIcon align_box_bottom_left() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_LEFT);
  }

  default TablerIcon align_box_bottom_right() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_RIGHT);
  }

  default TablerIcon align_box_center_bottom() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_BOTTOM);
  }

  default TablerIcon align_box_center_middle() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_MIDDLE);
  }

  default TablerIcon align_box_center_stretch() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_STRETCH);
  }

  default TablerIcon align_box_center_top() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_TOP);
  }

  default TablerIcon align_box_left_bottom() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_BOTTOM);
  }

  default TablerIcon align_box_left_middle() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_MIDDLE);
  }

  default TablerIcon align_box_left_stretch() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_STRETCH);
  }

  default TablerIcon align_box_left_top() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_TOP);
  }

  default TablerIcon align_box_right_bottom() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_BOTTOM);
  }

  default TablerIcon align_box_right_middle() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_MIDDLE);
  }

  default TablerIcon align_box_right_stretch() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_STRETCH);
  }

  default TablerIcon align_box_right_top() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_TOP);
  }

  default TablerIcon align_box_top_center() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_CENTER);
  }

  default TablerIcon align_box_top_left() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_LEFT);
  }

  default TablerIcon align_box_top_right() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_RIGHT);
  }

  default TablerIcon align_center() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_CENTER);
  }

  default TablerIcon align_justified() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_JUSTIFIED);
  }

  default TablerIcon align_left() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_LEFT);
  }

  default TablerIcon align_left_2() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_LEFT_2);
  }

  default TablerIcon align_right() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_RIGHT);
  }

  default TablerIcon align_right_2() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_RIGHT_2);
  }

  default TablerIcon alphabet_arabic() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_ARABIC);
  }

  default TablerIcon alphabet_bangla() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_BANGLA);
  }

  default TablerIcon alphabet_chinese() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_CHINESE);
  }

  default TablerIcon alphabet_cyrillic() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_CYRILLIC);
  }

  default TablerIcon alphabet_devanagari() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_DEVANAGARI);
  }

  default TablerIcon alphabet_ethiopic() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_ETHIOPIC);
  }

  default TablerIcon alphabet_georgian() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_GEORGIAN);
  }

  default TablerIcon alphabet_greek() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_GREEK);
  }

  default TablerIcon alphabet_hebrew() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_HEBREW);
  }

  default TablerIcon alphabet_japanese() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_JAPANESE);
  }

  default TablerIcon alphabet_korean() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_KOREAN);
  }

  default TablerIcon alphabet_latin() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_LATIN);
  }

  default TablerIcon alphabet_polish() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_POLISH);
  }

  default TablerIcon alphabet_runes() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_RUNES);
  }

  default TablerIcon alphabet_thai() {
    return TablerIcon.create(TablerText.OutlineIcon.ALPHABET_THAI);
  }

  default TablerIcon asterisk() {
    return TablerIcon.create(TablerText.OutlineIcon.ASTERISK);
  }

  default TablerIcon asterisk_simple() {
    return TablerIcon.create(TablerText.OutlineIcon.ASTERISK_SIMPLE);
  }

  default TablerIcon at() {
    return TablerIcon.create(TablerText.OutlineIcon.AT);
  }

  default TablerIcon at_off() {
    return TablerIcon.create(TablerText.OutlineIcon.AT_OFF);
  }

  default TablerIcon backspace() {
    return TablerIcon.create(TablerText.OutlineIcon.BACKSPACE);
  }

  default TablerIcon ballpen() {
    return TablerIcon.create(TablerText.OutlineIcon.BALLPEN);
  }

  default TablerIcon ballpen_off() {
    return TablerIcon.create(TablerText.OutlineIcon.BALLPEN_OFF);
  }

  default TablerIcon baseline() {
    return TablerIcon.create(TablerText.OutlineIcon.BASELINE);
  }

  default TablerIcon baseline_density_large() {
    return TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_LARGE);
  }

  default TablerIcon baseline_density_medium() {
    return TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_MEDIUM);
  }

  default TablerIcon baseline_density_small() {
    return TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_SMALL);
  }

  default TablerIcon bible() {
    return TablerIcon.create(TablerText.OutlineIcon.BIBLE);
  }

  default TablerIcon blockquote() {
    return TablerIcon.create(TablerText.OutlineIcon.BLOCKQUOTE);
  }

  default TablerIcon bold() {
    return TablerIcon.create(TablerText.OutlineIcon.BOLD);
  }

  default TablerIcon bold_off() {
    return TablerIcon.create(TablerText.OutlineIcon.BOLD_OFF);
  }

  default TablerIcon clear_formatting() {
    return TablerIcon.create(TablerText.OutlineIcon.CLEAR_FORMATTING);
  }

  default TablerIcon code() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE);
  }

  default TablerIcon code_asterisk() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_ASTERISK);
  }

  default TablerIcon code_circle() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_CIRCLE);
  }

  default TablerIcon code_circle_2() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_CIRCLE_2);
  }

  default TablerIcon code_dots() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_DOTS);
  }

  default TablerIcon code_minus() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_MINUS);
  }

  default TablerIcon code_off() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_OFF);
  }

  default TablerIcon code_plus() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE_PLUS);
  }

  default TablerIcon columns() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS);
  }

  default TablerIcon columns_1() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_1);
  }

  default TablerIcon columns_2() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_2);
  }

  default TablerIcon columns_3() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_3);
  }

  default TablerIcon columns_off() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_OFF);
  }

  default TablerIcon copy() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY);
  }

  default TablerIcon copy_check() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY_CHECK);
  }

  default TablerIcon copy_minus() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY_MINUS);
  }

  default TablerIcon copy_off() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY_OFF);
  }

  default TablerIcon copy_plus() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY_PLUS);
  }

  default TablerIcon copy_x() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY_X);
  }

  default TablerIcon cursor_text() {
    return TablerIcon.create(TablerText.OutlineIcon.CURSOR_TEXT);
  }

  default TablerIcon duplicate() {
    return TablerIcon.create(TablerText.OutlineIcon.DUPLICATE);
  }

  default TablerIcon emphasis() {
    return TablerIcon.create(TablerText.OutlineIcon.EMPHASIS);
  }

  default TablerIcon eraser() {
    return TablerIcon.create(TablerText.OutlineIcon.ERASER);
  }

  default TablerIcon eraser_off() {
    return TablerIcon.create(TablerText.OutlineIcon.ERASER_OFF);
  }

  default TablerIcon float_center() {
    return TablerIcon.create(TablerText.OutlineIcon.FLOAT_CENTER);
  }

  default TablerIcon float_left() {
    return TablerIcon.create(TablerText.OutlineIcon.FLOAT_LEFT);
  }

  default TablerIcon float_none() {
    return TablerIcon.create(TablerText.OutlineIcon.FLOAT_NONE);
  }

  default TablerIcon float_right() {
    return TablerIcon.create(TablerText.OutlineIcon.FLOAT_RIGHT);
  }

  default TablerIcon forms() {
    return TablerIcon.create(TablerText.OutlineIcon.FORMS);
  }

  default TablerIcon h_1() {
    return TablerIcon.create(TablerText.OutlineIcon.H_1);
  }

  default TablerIcon h_2() {
    return TablerIcon.create(TablerText.OutlineIcon.H_2);
  }

  default TablerIcon h_3() {
    return TablerIcon.create(TablerText.OutlineIcon.H_3);
  }

  default TablerIcon h_4() {
    return TablerIcon.create(TablerText.OutlineIcon.H_4);
  }

  default TablerIcon h_5() {
    return TablerIcon.create(TablerText.OutlineIcon.H_5);
  }

  default TablerIcon h_6() {
    return TablerIcon.create(TablerText.OutlineIcon.H_6);
  }

  default TablerIcon heading() {
    return TablerIcon.create(TablerText.OutlineIcon.HEADING);
  }

  default TablerIcon heading_off() {
    return TablerIcon.create(TablerText.OutlineIcon.HEADING_OFF);
  }

  default TablerIcon highlight() {
    return TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT);
  }

  default TablerIcon highlight_off() {
    return TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT_OFF);
  }

  default TablerIcon indent_decrease() {
    return TablerIcon.create(TablerText.OutlineIcon.INDENT_DECREASE);
  }

  default TablerIcon indent_increase() {
    return TablerIcon.create(TablerText.OutlineIcon.INDENT_INCREASE);
  }

  default TablerIcon input_search() {
    return TablerIcon.create(TablerText.OutlineIcon.INPUT_SEARCH);
  }

  default TablerIcon italic() {
    return TablerIcon.create(TablerText.OutlineIcon.ITALIC);
  }

  default TablerIcon italic_off() {
    return TablerIcon.create(TablerText.OutlineIcon.ITALIC_OFF);
  }

  default TablerIcon kerning() {
    return TablerIcon.create(TablerText.OutlineIcon.KERNING);
  }

  default TablerIcon language() {
    return TablerIcon.create(TablerText.OutlineIcon.LANGUAGE);
  }

  default TablerIcon language_hiragana() {
    return TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_HIRAGANA);
  }

  default TablerIcon language_katakana() {
    return TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_KATAKANA);
  }

  default TablerIcon language_off() {
    return TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_OFF);
  }

  default TablerIcon letter_case() {
    return TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE);
  }

  default TablerIcon letter_case_lower() {
    return TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_LOWER);
  }

  default TablerIcon letter_case_toggle() {
    return TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_TOGGLE);
  }

  default TablerIcon letter_case_upper() {
    return TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_UPPER);
  }

  default TablerIcon letter_spacing() {
    return TablerIcon.create(TablerText.OutlineIcon.LETTER_SPACING);
  }

  default TablerIcon line_height() {
    return TablerIcon.create(TablerText.OutlineIcon.LINE_HEIGHT);
  }

  default TablerIcon link() {
    return TablerIcon.create(TablerText.OutlineIcon.LINK);
  }

  default TablerIcon link_minus() {
    return TablerIcon.create(TablerText.OutlineIcon.LINK_MINUS);
  }

  default TablerIcon link_off() {
    return TablerIcon.create(TablerText.OutlineIcon.LINK_OFF);
  }

  default TablerIcon link_plus() {
    return TablerIcon.create(TablerText.OutlineIcon.LINK_PLUS);
  }

  default TablerIcon list() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST);
  }

  default TablerIcon list_check() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST_CHECK);
  }

  default TablerIcon list_details() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST_DETAILS);
  }

  default TablerIcon list_numbers() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST_NUMBERS);
  }

  default TablerIcon list_search() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST_SEARCH);
  }

  default TablerIcon markdown() {
    return TablerIcon.create(TablerText.OutlineIcon.MARKDOWN);
  }

  default TablerIcon markdown_off() {
    return TablerIcon.create(TablerText.OutlineIcon.MARKDOWN_OFF);
  }

  default TablerIcon notdef() {
    return TablerIcon.create(TablerText.OutlineIcon.NOTDEF);
  }

  default TablerIcon overline() {
    return TablerIcon.create(TablerText.OutlineIcon.OVERLINE);
  }

  default TablerIcon pilcrow() {
    return TablerIcon.create(TablerText.OutlineIcon.PILCROW);
  }

  default TablerIcon pilcrow_left() {
    return TablerIcon.create(TablerText.OutlineIcon.PILCROW_LEFT);
  }

  default TablerIcon pilcrow_right() {
    return TablerIcon.create(TablerText.OutlineIcon.PILCROW_RIGHT);
  }

  default TablerIcon quote() {
    return TablerIcon.create(TablerText.OutlineIcon.QUOTE);
  }

  default TablerIcon quote_off() {
    return TablerIcon.create(TablerText.OutlineIcon.QUOTE_OFF);
  }

  default TablerIcon quote_open() {
    return TablerIcon.create(TablerText.OutlineIcon.QUOTE_OPEN);
  }

  default TablerIcon quotes() {
    return TablerIcon.create(TablerText.OutlineIcon.QUOTES);
  }

  default TablerIcon regex() {
    return TablerIcon.create(TablerText.OutlineIcon.REGEX);
  }

  default TablerIcon regex_off() {
    return TablerIcon.create(TablerText.OutlineIcon.REGEX_OFF);
  }

  default TablerIcon scribble() {
    return TablerIcon.create(TablerText.OutlineIcon.SCRIBBLE);
  }

  default TablerIcon scribble_off() {
    return TablerIcon.create(TablerText.OutlineIcon.SCRIBBLE_OFF);
  }

  default TablerIcon section_sign() {
    return TablerIcon.create(TablerText.OutlineIcon.SECTION_SIGN);
  }

  default TablerIcon separator() {
    return TablerIcon.create(TablerText.OutlineIcon.SEPARATOR);
  }

  default TablerIcon separator_horizontal() {
    return TablerIcon.create(TablerText.OutlineIcon.SEPARATOR_HORIZONTAL);
  }

  default TablerIcon separator_vertical() {
    return TablerIcon.create(TablerText.OutlineIcon.SEPARATOR_VERTICAL);
  }

  default TablerIcon signature() {
    return TablerIcon.create(TablerText.OutlineIcon.SIGNATURE);
  }

  default TablerIcon signature_off() {
    return TablerIcon.create(TablerText.OutlineIcon.SIGNATURE_OFF);
  }

  default TablerIcon slideshow() {
    return TablerIcon.create(TablerText.OutlineIcon.SLIDESHOW);
  }

  default TablerIcon sort_0_9() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_0_9);
  }

  default TablerIcon sort_9_0() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_9_0);
  }

  default TablerIcon sort_a_z() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_A_Z);
  }

  default TablerIcon sort_ascending() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING);
  }

  default TablerIcon sort_ascending_2() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_2);
  }

  default TablerIcon sort_ascending_letters() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_LETTERS);
  }

  default TablerIcon sort_ascending_numbers() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_NUMBERS);
  }

  default TablerIcon sort_descending() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING);
  }

  default TablerIcon sort_descending_2() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_2);
  }

  default TablerIcon sort_descending_letters() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_LETTERS);
  }

  default TablerIcon sort_descending_numbers() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_NUMBERS);
  }

  default TablerIcon sort_z_a() {
    return TablerIcon.create(TablerText.OutlineIcon.SORT_Z_A);
  }

  default TablerIcon space() {
    return TablerIcon.create(TablerText.OutlineIcon.SPACE);
  }

  default TablerIcon space_off() {
    return TablerIcon.create(TablerText.OutlineIcon.SPACE_OFF);
  }

  default TablerIcon strikethrough() {
    return TablerIcon.create(TablerText.OutlineIcon.STRIKETHROUGH);
  }

  default TablerIcon subscript() {
    return TablerIcon.create(TablerText.OutlineIcon.SUBSCRIPT);
  }

  default TablerIcon superscript() {
    return TablerIcon.create(TablerText.OutlineIcon.SUPERSCRIPT);
  }

  default TablerIcon tex() {
    return TablerIcon.create(TablerText.OutlineIcon.TEX);
  }

  default TablerIcon text_caption() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_CAPTION);
  }

  default TablerIcon text_color() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_COLOR);
  }

  default TablerIcon text_decrease() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_DECREASE);
  }

  default TablerIcon text_direction_ltr() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_DIRECTION_LTR);
  }

  default TablerIcon text_direction_rtl() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_DIRECTION_RTL);
  }

  default TablerIcon text_grammar() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_GRAMMAR);
  }

  default TablerIcon text_increase() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_INCREASE);
  }

  default TablerIcon text_orientation() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_ORIENTATION);
  }

  default TablerIcon text_outline() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_OUTLINE);
  }

  default TablerIcon text_plus() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_PLUS);
  }

  default TablerIcon text_recognition() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_RECOGNITION);
  }

  default TablerIcon text_regex_asterisk() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_ASTERISK);
  }

  default TablerIcon text_regex_end() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_END);
  }

  default TablerIcon text_regex_plus() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_PLUS);
  }

  default TablerIcon text_regex_question() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_QUESTION);
  }

  default TablerIcon text_regex_start() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_START);
  }

  default TablerIcon text_size() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_SIZE);
  }

  default TablerIcon text_spellcheck() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_SPELLCHECK);
  }

  default TablerIcon text_wrap() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP);
  }

  default TablerIcon text_wrap_column() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP_COLUMN);
  }

  default TablerIcon text_wrap_disabled() {
    return TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP_DISABLED);
  }

  default TablerIcon typography() {
    return TablerIcon.create(TablerText.OutlineIcon.TYPOGRAPHY);
  }

  default TablerIcon typography_off() {
    return TablerIcon.create(TablerText.OutlineIcon.TYPOGRAPHY_OFF);
  }

  default TablerIcon underline() {
    return TablerIcon.create(TablerText.OutlineIcon.UNDERLINE);
  }

  default TablerIcon underline_off() {
    return TablerIcon.create(TablerText.OutlineIcon.UNDERLINE_OFF);
  }

  default TablerIcon unlink() {
    return TablerIcon.create(TablerText.OutlineIcon.UNLINK);
  }

  default TablerIcon vocabulary() {
    return TablerIcon.create(TablerText.OutlineIcon.VOCABULARY);
  }

  default TablerIcon vocabulary_off() {
    return TablerIcon.create(TablerText.OutlineIcon.VOCABULARY_OFF);
  }

  default TablerIcon writing() {
    return TablerIcon.create(TablerText.OutlineIcon.WRITING);
  }

  default TablerIcon writing_off() {
    return TablerIcon.create(TablerText.OutlineIcon.WRITING_OFF);
  }

  default TablerIcon writing_sign() {
    return TablerIcon.create(TablerText.OutlineIcon.WRITING_SIGN);
  }

  default TablerIcon writing_sign_off() {
    return TablerIcon.create(TablerText.OutlineIcon.WRITING_SIGN_OFF);
  }

  default TablerIcon code_tags() {
    return TablerIcon.create(TablerText.OutlineIcon.CODE);
  }

  default TablerIcon content_copy() {
    return TablerIcon.create(TablerText.OutlineIcon.COPY);
  }

  default TablerIcon format_align_justify() {
    return TablerIcon.create(TablerText.OutlineIcon.ALIGN_JUSTIFIED);
  }

  default TablerIcon format_bold() {
    return TablerIcon.create(TablerText.OutlineIcon.BOLD);
  }

  default TablerIcon format_color_highlight() {
    return TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT);
  }

  default TablerIcon format_color_marker_cancel() {
    return TablerIcon.create(TablerText.OutlineIcon.BACKSPACE);
  }

  default TablerIcon format_header_1() {
    return TablerIcon.create(TablerText.OutlineIcon.H_1);
  }

  default TablerIcon format_header_2() {
    return TablerIcon.create(TablerText.OutlineIcon.H_2);
  }

  default TablerIcon format_header_3() {
    return TablerIcon.create(TablerText.OutlineIcon.H_3);
  }

  default TablerIcon format_header_4() {
    return TablerIcon.create(TablerText.OutlineIcon.H_4);
  }

  default TablerIcon format_header_5() {
    return TablerIcon.create(TablerText.OutlineIcon.H_5);
  }

  default TablerIcon format_header_6() {
    return TablerIcon.create(TablerText.OutlineIcon.H_6);
  }

  default TablerIcon format_indent_decrease() {
    return TablerIcon.create(TablerText.OutlineIcon.INDENT_DECREASE);
  }

  default TablerIcon format_indent_increase() {
    return TablerIcon.create(TablerText.OutlineIcon.INDENT_INCREASE);
  }

  default TablerIcon format_italic() {
    return TablerIcon.create(TablerText.OutlineIcon.ITALIC);
  }

  default TablerIcon format_list_bulleted() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST);
  }

  default TablerIcon format_list_numbered() {
    return TablerIcon.create(TablerText.OutlineIcon.LIST_NUMBERS);
  }

  default TablerIcon format_paragraph() {
    return TablerIcon.create(TablerText.OutlineIcon.PILCROW);
  }

  default TablerIcon format_strikethrough() {
    return TablerIcon.create(TablerText.OutlineIcon.STRIKETHROUGH);
  }

  default TablerIcon format_subscript() {
    return TablerIcon.create(TablerText.OutlineIcon.SUBSCRIPT);
  }

  default TablerIcon format_superscript() {
    return TablerIcon.create(TablerText.OutlineIcon.SUPERSCRIPT);
  }

  default TablerIcon format_underline() {
    return TablerIcon.create(TablerText.OutlineIcon.UNDERLINE);
  }

  default TablerIcon keyboard_backspace() {
    return TablerIcon.create(TablerText.OutlineIcon.BACKSPACE);
  }

  default TablerIcon view_column() {
    return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_3);
  }

  default TablerIcon align_box_bottom_center_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_CENTER);
  }

  default TablerIcon align_box_bottom_left_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_LEFT);
  }

  default TablerIcon align_box_bottom_right_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_RIGHT);
  }

  default TablerIcon align_box_center_middle_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_CENTER_MIDDLE);
  }

  default TablerIcon align_box_left_bottom_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_BOTTOM);
  }

  default TablerIcon align_box_left_middle_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_MIDDLE);
  }

  default TablerIcon align_box_left_top_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_TOP);
  }

  default TablerIcon align_box_right_bottom_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_BOTTOM);
  }

  default TablerIcon align_box_right_middle_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_MIDDLE);
  }

  default TablerIcon align_box_right_top_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_TOP);
  }

  default TablerIcon align_box_top_center_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_CENTER);
  }

  default TablerIcon align_box_top_left_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_LEFT);
  }

  default TablerIcon align_box_top_right_filled() {
    return TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_RIGHT);
  }

  default TablerIcon backspace_filled() {
    return TablerIcon.create(TablerText.FilledIcon.BACKSPACE);
  }

  default TablerIcon ballpen_filled() {
    return TablerIcon.create(TablerText.FilledIcon.BALLPEN);
  }

  default TablerIcon code_circle_filled() {
    return TablerIcon.create(TablerText.FilledIcon.CODE_CIRCLE);
  }

  default TablerIcon code_circle_2_filled() {
    return TablerIcon.create(TablerText.FilledIcon.CODE_CIRCLE_2);
  }

  default TablerIcon columns_1_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COLUMNS_1);
  }

  default TablerIcon columns_2_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COLUMNS_2);
  }

  default TablerIcon columns_3_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COLUMNS_3);
  }

  default TablerIcon copy_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COPY);
  }

  default TablerIcon copy_check_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COPY_CHECK);
  }

  default TablerIcon copy_minus_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COPY_MINUS);
  }

  default TablerIcon copy_plus_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COPY_PLUS);
  }

  default TablerIcon copy_x_filled() {
    return TablerIcon.create(TablerText.FilledIcon.COPY_X);
  }

  default TablerIcon link_filled() {
    return TablerIcon.create(TablerText.FilledIcon.LINK);
  }

  default TablerIcon list_filled() {
    return TablerIcon.create(TablerText.FilledIcon.LIST);
  }

  default TablerIcon list_check_filled() {
    return TablerIcon.create(TablerText.FilledIcon.LIST_CHECK);
  }

  default TablerIcon list_details_filled() {
    return TablerIcon.create(TablerText.FilledIcon.LIST_DETAILS);
  }

  default TablerIcon quote_filled() {
    return TablerIcon.create(TablerText.FilledIcon.QUOTE);
  }

  default TablerIcon sort_ascending_2_filled() {
    return TablerIcon.create(TablerText.FilledIcon.SORT_ASCENDING_2);
  }

  default TablerIcon sort_descending_2_filled() {
    return TablerIcon.create(TablerText.FilledIcon.SORT_DESCENDING_2);
  }

  default TablerIcon writing_filled() {
    return TablerIcon.create(TablerText.FilledIcon.WRITING);
  }

  default TablerIcon writing_sign_filled() {
    return TablerIcon.create(TablerText.FilledIcon.WRITING_SIGN);
  }
}
