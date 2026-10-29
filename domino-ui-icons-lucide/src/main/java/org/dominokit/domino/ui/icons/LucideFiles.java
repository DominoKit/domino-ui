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

/** Lucide files catalog category. */
public interface LucideFiles {
  enum Icon implements LucideIconDefinition {
    APP_WINDOW(
        "app-window",
        "<rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />\n  <path d=\"M10 4v4\" />\n  <path d=\"M2 8h20\" />\n  <path d=\"M6 4v4\" />"),
    APP_WINDOW_MAC(
        "app-window-mac",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M10 8h.01\" />\n  <path d=\"M14 8h.01\" />"),
    ARCHIVE(
        "archive",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8\" />\n  <path d=\"M10 12h4\" />"),
    ARCHIVE_RESTORE(
        "archive-restore",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h2\" />\n  <path d=\"M20 8v11a2 2 0 0 1-2 2h-2\" />\n  <path d=\"m9 15 3-3 3 3\" />\n  <path d=\"M12 12v9\" />"),
    ARCHIVE_X(
        "archive-x",
        "<rect width=\"20\" height=\"5\" x=\"2\" y=\"3\" rx=\"1\" />\n  <path d=\"M4 8v11a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V8\" />\n  <path d=\"m9.5 17 5-5\" />\n  <path d=\"m9.5 12 5 5\" />"),
    ARROW_BIG_DOWN_DASH(
        "arrow-big-down-dash",
        "<path d=\"M14 8a1 1 0 0 1 1 1v2a1 1 0 0 0 1 1h3.293a.707.707 0 0 1 .5 1.207l-6.939 6.939a1.207 1.207 0 0 1-1.708 0l-6.94-6.94a.707.707 0 0 1 .5-1.206H8a1 1 0 0 0 1-1V9a1 1 0 0 1 1-1z\" />\n  <path d=\"M9 4h6\" />"),
    ARROW_DOWN_FROM_LINE(
        "arrow-down-from-line",
        "<path d=\"M19 3H5\" />\n  <path d=\"M12 21V7\" />\n  <path d=\"m6 15 6 6 6-6\" />"),
    ARROW_DOWN_TO_LINE(
        "arrow-down-to-line",
        "<path d=\"M12 17V3\" />\n  <path d=\"m6 11 6 6 6-6\" />\n  <path d=\"M19 21H5\" />"),
    ARROW_UP_FROM_LINE(
        "arrow-up-from-line",
        "<path d=\"m18 9-6-6-6 6\" />\n  <path d=\"M12 3v14\" />\n  <path d=\"M5 21h14\" />"),
    ARROW_UP_TO_LINE(
        "arrow-up-to-line",
        "<path d=\"M5 3h14\" />\n  <path d=\"m18 13-6-6-6 6\" />\n  <path d=\"M12 7v14\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
    BRACES(
        "braces",
        "<path d=\"M8 3H7a2 2 0 0 0-2 2v5a2 2 0 0 1-2 2 2 2 0 0 1 2 2v5c0 1.1.9 2 2 2h1\" />\n  <path d=\"M16 21h1a2 2 0 0 0 2-2v-5c0-1.1.9-2 2-2a2 2 0 0 1-2-2V5a2 2 0 0 0-2-2h-1\" />"),
    BRACKETS(
        "brackets",
        "<path d=\"M16 3h3a1 1 0 0 1 1 1v16a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M8 21H5a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1h3\" />"),
    BRIEFCASE_PLUS(
        "briefcase-plus",
        "<path d=\"M13.354 20H4a2 2 0 01-2-2V8a2 2 0 012-2h16a2 2 0 012 2v3.354\" />\n  <path d=\"M16 11.354V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v16\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />"),
    CALENDAR_FOLD(
        "calendar-fold",
        "<path d=\"M16 2v3\" />\n  <path d=\"M21 15V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h10v-5a1 1 0 011-1za2.4 2.4 0 01-.706 1.706l-3.588 3.588A2.4 2.4 0 0115 21\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CASSETTE_TAPE(
        "cassette-tape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <circle cx=\"8\" cy=\"10\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"10\" r=\"2\" />\n  <path d=\"m6 20 .7-2.9A1.4 1.4 0 0 1 8.1 16h7.8a1.4 1.4 0 0 1 1.4 1l.7 3\" />"),
    CHART_PIE(
        "chart-pie",
        "<path d=\"M21 12c.552 0 1.005-.449.95-.998a10 10 0 0 0-8.953-8.951c-.55-.055-.998.398-.998.95v8a1 1 0 0 0 1 1z\" />\n  <path d=\"M21.21 15.89A10 10 0 1 1 8 2.83\" />"),
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
    COMBINE(
        "combine",
        "<path d=\"M14 3a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"M19 3a1 1 0 0 1 1 1v5a1 1 0 0 1-1 1\" />\n  <path d=\"m7 15 3 3\" />\n  <path d=\"m7 21 3-3H5a2 2 0 0 1-2-2v-2\" />\n  <rect x=\"14\" y=\"14\" width=\"7\" height=\"7\" rx=\"1\" />\n  <rect x=\"3\" y=\"3\" width=\"7\" height=\"7\" rx=\"1\" />"),
    DIFF("diff", "<path d=\"M12 3v14\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M5 21h14\" />"),
    DOCK(
        "dock",
        "<path d=\"M2 8h20\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 16h12\" />"),
    DOWNLOAD(
        "download",
        "<path d=\"M12 15V3\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4\" />\n  <path d=\"m7 10 5 5 5-5\" />"),
    EIGHTH_NOTE(
        "eighth-note",
        "<path d=\"m19 6-5.2-3.9a.5.5 0 0 0-.8.4V18\" />\n  <circle cx=\"9\" cy=\"18\" r=\"4\" />"),
    EIGHTH_NOTES(
        "eighth-notes",
        "<path d=\"M21 16V3a1 1 0 0 0-1.28-.96l-10 2.917a1 1 0 0 0-.72.96V19\" />\n  <circle cx=\"18\" cy=\"16\" r=\"3\" />\n  <circle cx=\"6\" cy=\"19\" r=\"3\" />"),
    EJECT(
        "eject",
        "<path d=\"M4 13a1 1 0 0 1-.72-1.695l7.257-7.668a2 2 0 0 1 2.926 0l7.256 7.668A1 1 0 0 1 20 13z\" />\n  <rect x=\"3\" y=\"17\" width=\"18\" height=\"4\" rx=\"1\" />"),
    FILE(
        "file",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />"),
    FILE_ARCHIVE(
        "file-archive",
        "<path d=\"M13.659 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v11.5\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 12v-1\" />\n  <path d=\"M8 18v-2\" />\n  <path d=\"M8 7V6\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    FILE_AXIS_3D(
        "file-axis-3d",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m8 18 4-4\" />\n  <path d=\"M8 10v8h8\" />"),
    FILE_BADGE(
        "file-badge",
        "<path d=\"M13 22h5a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v3.3\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m7.69 16.479 1.29 4.88a.5.5 0 0 1-.698.591l-1.843-.849a1 1 0 0 0-.879.001l-1.846.85a.5.5 0 0 1-.692-.593l1.29-4.88\" />\n  <circle cx=\"6\" cy=\"14\" r=\"3\" />"),
    FILE_BOX(
        "file-box",
        "<path d=\"M14 2v5a1 1 0 001 1h5\" />\n  <path d=\"M14.692 22H18a2 2 0 002-2V8a2.4 2.4 0 00-.706-1.706l-3.588-3.588A2.4 2.4 0 0014 2H6a2 2 0 00-2 2v3.804\" />\n  <path d=\"M2.264 13.752 7 16.5l4.737-2.748\" />\n  <path d=\"M2.995 13.014A2 2 0 002 14.744v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0012 18.26v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />\n  <path d=\"M7 16.5V22\" />"),
    FILE_BRACES(
        "file-braces",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 12a1 1 0 0 0-1 1v1a1 1 0 0 1-1 1 1 1 0 0 1 1 1v1a1 1 0 0 0 1 1\" />\n  <path d=\"M14 18a1 1 0 0 0 1-1v-1a1 1 0 0 1 1-1 1 1 0 0 1-1-1v-1a1 1 0 0 0-1-1\" />"),
    FILE_BRACES_CORNER(
        "file-braces-corner",
        "<path d=\"M14 22h4a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v6\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M5 14a1 1 0 0 0-1 1v2a1 1 0 0 1-1 1 1 1 0 0 1 1 1v2a1 1 0 0 0 1 1\" />\n  <path d=\"M9 22a1 1 0 0 0 1-1v-2a1 1 0 0 1 1-1 1 1 0 0 1-1-1v-2a1 1 0 0 0-1-1\" />"),
    FILE_CHART_COLUMN(
        "file-chart-column",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 18v-1\" />\n  <path d=\"M12 18v-6\" />\n  <path d=\"M16 18v-3\" />"),
    FILE_CHART_COLUMN_INCREASING(
        "file-chart-column-increasing",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 18v-2\" />\n  <path d=\"M12 18v-4\" />\n  <path d=\"M16 18v-6\" />"),
    FILE_CHART_LINE(
        "file-chart-line",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m16 13-3.5 3.5-2-2L8 17\" />"),
    FILE_CHART_PIE(
        "file-chart-pie",
        "<path d=\"M15.941 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.704l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v3.512\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M4.017 11.512a6 6 0 1 0 8.466 8.475\" />\n  <path d=\"M9 16a1 1 0 0 1-1-1v-4c0-.552.45-1.008.995-.917a6 6 0 0 1 4.922 4.922c.091.544-.365.995-.917.995z\" />"),
    FILE_CHECK(
        "file-check",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m9 15 2 2 4-4\" />"),
    FILE_CHECK_CORNER(
        "file-check-corner",
        "<path d=\"M10.5 22H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v6\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m14 20 2 2 4-4\" />"),
    FILE_CLOCK(
        "file-clock",
        "<path d=\"M16 22h2a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v2.85\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 14v2.2l1.6 1\" />\n  <circle cx=\"8\" cy=\"16\" r=\"6\" />"),
    FILE_CODE(
        "file-code",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 12.5 8 15l2 2.5\" />\n  <path d=\"m14 12.5 2 2.5-2 2.5\" />"),
    FILE_CODE_CORNER(
        "file-code-corner",
        "<path d=\"M4 12.15V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-3.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m5 16-3 3 3 3\" />\n  <path d=\"m9 22 3-3-3-3\" />"),
    FILE_COG(
        "file-cog",
        "<path d=\"M15 8a1 1 0 0 1-1-1V2a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8z\" />\n  <path d=\"M20 8v12a2 2 0 0 1-2 2h-4.182\" />\n  <path d=\"m3.305 19.53.923-.382\" />\n  <path d=\"M4 10.592V4a2 2 0 0 1 2-2h8\" />\n  <path d=\"m4.228 16.852-.924-.383\" />\n  <path d=\"m5.852 15.228-.383-.923\" />\n  <path d=\"m5.852 20.772-.383.924\" />\n  <path d=\"m8.148 15.228.383-.923\" />\n  <path d=\"m8.53 21.696-.382-.924\" />\n  <path d=\"m9.773 16.852.922-.383\" />\n  <path d=\"m9.773 19.148.922.383\" />\n  <circle cx=\"7\" cy=\"18\" r=\"3\" />"),
    FILE_DIFF(
        "file-diff",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M12 13V7\" />\n  <path d=\"M9 17h6\" />"),
    FILE_DIGIT(
        "file-digit",
        "<path d=\"M4 12V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 16h2v6\" />\n  <path d=\"M10 22h4\" />\n  <rect x=\"2\" y=\"16\" width=\"4\" height=\"6\" rx=\"2\" />"),
    FILE_DOWN(
        "file-down",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 18v-6\" />\n  <path d=\"m9 15 3 3 3-3\" />"),
    FILE_EXCLAMATION_POINT(
        "file-exclamation-point",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M12 9v4\" />\n  <path d=\"M12 17h.01\" />"),
    FILE_HEADPHONE(
        "file-headphone",
        "<path d=\"M4 6.835V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-.343\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M2 19a2 2 0 0 1 4 0v1a2 2 0 0 1-4 0v-4a6 6 0 0 1 12 0v4a2 2 0 0 1-4 0v-1a2 2 0 0 1 4 0\" />"),
    FILE_HEART(
        "file-heart",
        "<path d=\"M13 22h5a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v7\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M3.62 18.8A2.25 2.25 0 1 1 7 15.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a1 1 0 0 1-1.507 0z\" />"),
    FILE_IMAGE(
        "file-image",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <circle cx=\"10\" cy=\"12\" r=\"2\" />\n  <path d=\"m20 17-1.296-1.296a2.41 2.41 0 0 0-3.408 0L9 22\" />"),
    FILE_INPUT(
        "file-input",
        "<path d=\"M4 11V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-1\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M2 15h10\" />\n  <path d=\"m9 18 3-3-3-3\" />"),
    FILE_KEY(
        "file-key",
        "<path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M4 12v6\" />\n  <path d=\"M4 14h2\" />\n  <path d=\"M9.65 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v4\" />\n  <circle cx=\"4\" cy=\"20\" r=\"2\" />"),
    FILE_LOCK(
        "file-lock",
        "<path d=\"M4 9.8V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-3\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M9 17v-2a2 2 0 0 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"3\" y=\"17\" rx=\"1\" />"),
    FILE_MINUS(
        "file-minus",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M9 15h6\" />"),
    FILE_MINUS_CORNER(
        "file-minus-corner",
        "<path d=\"M20 14V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M14 18h6\" />"),
    FILE_MUSIC(
        "file-music",
        "<path d=\"M11.65 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v10.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 20v-7l3 1.474\" />\n  <circle cx=\"6\" cy=\"20\" r=\"2\" />"),
    FILE_OUTPUT(
        "file-output",
        "<path d=\"M4.226 20.925A2 2 0 0 0 6 22h12a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v3.127\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m5 11-3 3\" />\n  <path d=\"m5 17-3-3h10\" />"),
    FILE_PEN(
        "file-pen",
        "<path d=\"M12.659 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v9.34\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10.378 12.622a1 1 0 0 1 3 3.003L8.36 20.637a2 2 0 0 1-.854.506l-2.867.837a.5.5 0 0 1-.62-.62l.836-2.869a2 2 0 0 1 .506-.853z\" />"),
    FILE_PEN_LINE(
        "file-pen-line",
        "<path d=\"M14.364 13.634a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506l4.013-4.009a1 1 0 0 0-3.004-3.004z\" />\n  <path d=\"M14.487 7.858A1 1 0 0 1 14 7V2\" />\n  <path d=\"M20 19.645V20a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l2.516 2.516\" />\n  <path d=\"M8 18h1\" />"),
    FILE_PLAY(
        "file-play",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M15.033 13.44a.647.647 0 0 1 0 1.12l-4.065 2.352a.645.645 0 0 1-.968-.56v-4.704a.645.645 0 0 1 .967-.56z\" />"),
    FILE_PLUS(
        "file-plus",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M9 15h6\" />\n  <path d=\"M12 18v-6\" />"),
    FILE_PLUS_CORNER(
        "file-plus-corner",
        "<path d=\"M11.35 22H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v5.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M14 19h6\" />\n  <path d=\"M17 16v6\" />"),
    FILE_QUESTION_MARK(
        "file-question-mark",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M9.1 9a3 3 0 0 1 5.82 1c0 2-3 3-3 3\" />"),
    FILE_SCAN(
        "file-scan",
        "<path d=\"M20 10V8a2.4 2.4 0 0 0-.706-1.704l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h4.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M16 14a2 2 0 0 0-2 2\" />\n  <path d=\"M16 22a2 2 0 0 1-2-2\" />\n  <path d=\"M20 14a2 2 0 0 1 2 2\" />\n  <path d=\"M20 22a2 2 0 0 0 2-2\" />"),
    FILE_SEARCH(
        "file-search",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <circle cx=\"11.5\" cy=\"14.5\" r=\"2.5\" />\n  <path d=\"M13.3 16.3 15 18\" />"),
    FILE_SEARCH_CORNER(
        "file-search-corner",
        "<path d=\"M11.1 22H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.589 3.588A2.4 2.4 0 0 1 20 8v3.25\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m21 22-2.88-2.88\" />\n  <circle cx=\"16\" cy=\"17\" r=\"3\" />"),
    FILE_SIGNAL(
        "file-signal",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 15h.01\" />\n  <path d=\"M11.5 13.5a2.5 2.5 0 0 1 0 3\" />\n  <path d=\"M15 12a5 5 0 0 1 0 6\" />"),
    FILE_SLIDERS(
        "file-sliders",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M10 11v2\" />\n  <path d=\"M8 17h8\" />\n  <path d=\"M14 16v2\" />"),
    FILE_SPREADSHEET(
        "file-spreadsheet",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 13h2\" />\n  <path d=\"M14 13h2\" />\n  <path d=\"M8 17h2\" />\n  <path d=\"M14 17h2\" />"),
    FILE_STACK(
        "file-stack",
        "<path d=\"M11 21a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1v-8a1 1 0 0 1 1-1\" />\n  <path d=\"M16 16a1 1 0 0 1-1 1H9a1 1 0 0 1-1-1V8a1 1 0 0 1 1-1\" />\n  <path d=\"M21 6a2 2 0 0 0-.586-1.414l-2-2A2 2 0 0 0 17 2h-3a1 1 0 0 0-1 1v8a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1z\" />"),
    FILE_SYMLINK(
        "file-symlink",
        "<path d=\"M4 11V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h7\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m10 18 3-3-3-3\" />"),
    FILE_TERMINAL(
        "file-terminal",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m8 16 2-2-2-2\" />\n  <path d=\"M12 18h4\" />"),
    FILE_TEXT(
        "file-text",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 9H8\" />\n  <path d=\"M16 13H8\" />\n  <path d=\"M16 17H8\" />"),
    FILE_TYPE(
        "file-type",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M12 12v6\" />\n  <path d=\"M9 13v-.5a.5.5 0 0 1 .5-.5h5a.5.5 0 0 1 .5.5v.5\" />"),
    FILE_TYPE_CORNER(
        "file-type-corner",
        "<path d=\"M12 22h6a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v6\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M3 16v-1.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5V16\" />\n  <path d=\"M6 22h2\" />\n  <path d=\"M7 14v8\" />"),
    FILE_UP(
        "file-up",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 12v6\" />\n  <path d=\"m15 15-3-3-3 3\" />"),
    FILE_USER(
        "file-user",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M16 22a4 4 0 0 0-8 0\" />\n  <circle cx=\"12\" cy=\"15\" r=\"3\" />"),
    FILE_VIDEO_CAMERA(
        "file-video-camera",
        "<path d=\"M4 12V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m10 17.843 3.033-1.755a.64.64 0 0 1 .967.56v4.704a.65.65 0 0 1-.967.56L10 20.157\" />\n  <rect width=\"7\" height=\"6\" x=\"3\" y=\"16\" rx=\"1\" />"),
    FILE_VOLUME(
        "file-volume",
        "<path d=\"M4 11.55V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2h-1.95\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M12 15a5 5 0 0 1 0 6\" />\n  <path d=\"M8 14.502a.5.5 0 0 0-.826-.381l-1.893 1.631a1 1 0 0 1-.651.243H3.5a.5.5 0 0 0-.5.501v3.006a.5.5 0 0 0 .5.501h1.129a1 1 0 0 1 .652.243l1.893 1.633a.5.5 0 0 0 .826-.38z\" />"),
    FILE_X(
        "file-x",
        "<path d=\"M6 22a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.704.706l3.588 3.588A2.4 2.4 0 0 1 20 8v12a2 2 0 0 1-2 2z\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m14.5 12.5-5 5\" />\n  <path d=\"m9.5 12.5 5 5\" />"),
    FILE_X_CORNER(
        "file-x-corner",
        "<path d=\"M11 22H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v5\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"m15 17 5 5\" />\n  <path d=\"m20 17-5 5\" />"),
    FILES(
        "files",
        "<path d=\"M15 2h-4a2 2 0 0 0-2 2v11a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V8\" />\n  <path d=\"M16.706 2.706A2.4 2.4 0 0 0 15 2v5a1 1 0 0 0 1 1h5a2.4 2.4 0 0 0-.706-1.706z\" />\n  <path d=\"M5 7a2 2 0 0 0-2 2v11a2 2 0 0 0 2 2h8a2 2 0 0 0 1.732-1\" />"),
    FOLDER(
        "folder",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />"),
    FOLDER_ARCHIVE(
        "folder-archive",
        "<circle cx=\"15\" cy=\"19\" r=\"2\" />\n  <path d=\"M20.9 19.8A2 2 0 0 0 22 18V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2h5.1\" />\n  <path d=\"M15 11v-1\" />\n  <path d=\"M15 17v-2\" />"),
    FOLDER_BOOKMARK(
        "folder-bookmark",
        "<path d=\"M12 6v7.751a.25.25 0 00.407.195l2.28-1.834a.5.5 0 01.627 0l2.28 1.834a.25.25 0 00.406-.195V6\" />\n  <path d=\"M20 20a2 2 0 002-2V8a2 2 0 00-2-2h-7.9a2 2 0 01-1.69-.9L9.6 3.9A2 2 0 007.93 3H4a2 2 0 00-2 2v13a2 2 0 002 2z\" />"),
    FOLDER_CHECK(
        "folder-check",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"m9 13 2 2 4-4\" />"),
    FOLDER_CLOCK(
        "folder-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"M7 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    FOLDER_CLOSED(
        "folder-closed",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M2 10h20\" />"),
    FOLDER_CODE(
        "folder-code",
        "<path d=\"M10 10.5 8 13l2 2.5\" />\n  <path d=\"m14 10.5 2 2.5-2 2.5\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2z\" />"),
    FOLDER_COG(
        "folder-cog",
        "<path d=\"M10.3 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.98a2 2 0 0 1 1.69.9l.66 1.2A2 2 0 0 0 12 6h8a2 2 0 0 1 2 2v3.3\" />\n  <path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"m20.772 16.852.924-.383\" />\n  <path d=\"m20.772 19.148.924.383\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    FOLDER_DOT(
        "folder-dot",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"1\" />"),
    FOLDER_DOWN(
        "folder-down",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"m15 13-3 3-3-3\" />"),
    FOLDER_GIT(
        "folder-git",
        "<circle cx=\"12\" cy=\"13\" r=\"2\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M14 13h3\" />\n  <path d=\"M7 13h3\" />"),
    FOLDER_GIT_2(
        "folder-git-2",
        "<path d=\"M18 19a5 5 0 0 1-5-5v8\" />\n  <path d=\"M9 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v5\" />\n  <circle cx=\"13\" cy=\"12\" r=\"2\" />\n  <circle cx=\"20\" cy=\"19\" r=\"2\" />"),
    FOLDER_HEART(
        "folder-heart",
        "<path d=\"M10.638 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v3.417\" />\n  <path d=\"M14.62 18.8A2.25 2.25 0 1 1 18 15.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a.998.998 0 0 1-1.507 0z\" />"),
    FOLDER_INPUT(
        "folder-input",
        "<path d=\"M2 9V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-1\" />\n  <path d=\"M2 13h10\" />\n  <path d=\"m9 16 3-3-3-3\" />"),
    FOLDER_KANBAN(
        "folder-kanban",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <path d=\"M8 10v4\" />\n  <path d=\"M12 10v2\" />\n  <path d=\"M16 10v6\" />"),
    FOLDER_KEY(
        "folder-key",
        "<path d=\"M13 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v1.36\" />\n  <path d=\"M19 12v6\" />\n  <path d=\"M19 14h2\" />\n  <circle cx=\"19\" cy=\"20\" r=\"2\" />"),
    FOLDER_LOCK(
        "folder-lock",
        "<rect width=\"8\" height=\"5\" x=\"14\" y=\"17\" rx=\"1\" />\n  <path d=\"M10 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M20 17v-2a2 2 0 1 0-4 0v2\" />"),
    FOLDER_MINUS(
        "folder-minus",
        "<path d=\"M9 13h6\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />"),
    FOLDER_OPEN(
        "folder-open",
        "<path d=\"m6 14 1.5-2.9A2 2 0 0 1 9.24 10H20a2 2 0 0 1 1.94 2.5l-1.54 6a2 2 0 0 1-1.95 1.5H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H18a2 2 0 0 1 2 2v2\" />"),
    FOLDER_OPEN_DOT(
        "folder-open-dot",
        "<path d=\"m6 14 1.45-2.9A2 2 0 0 1 9.24 10H20a2 2 0 0 1 1.94 2.5l-1.55 6a2 2 0 0 1-1.94 1.5H4a2 2 0 0 1-2-2V5c0-1.1.9-2 2-2h3.93a2 2 0 0 1 1.66.9l.82 1.2a2 2 0 0 0 1.66.9H18a2 2 0 0 1 2 2v2\" />\n  <circle cx=\"14\" cy=\"15\" r=\"1\" />"),
    FOLDER_OUTPUT(
        "folder-output",
        "<path d=\"M2 7.5V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-1.5\" />\n  <path d=\"M2 13h10\" />\n  <path d=\"m5 10-3 3 3 3\" />"),
    FOLDER_PEN(
        "folder-pen",
        "<path d=\"M2 11.5V5a2 2 0 0 1 2-2h3.9c.7 0 1.3.3 1.7.9l.8 1.2c.4.6 1 .9 1.7.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-9.5\" />\n  <path d=\"M11.378 13.626a1 1 0 1 0-3.004-3.004l-5.01 5.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />"),
    FOLDER_PLUS(
        "folder-plus",
        "<path d=\"M12 10v6\" />\n  <path d=\"M9 13h6\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />"),
    FOLDER_ROOT(
        "folder-root",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"2\" />\n  <path d=\"M12 15v5\" />"),
    FOLDER_SEARCH(
        "folder-search",
        "<path d=\"M10.7 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v4.1\" />\n  <path d=\"m21 21-1.9-1.9\" />\n  <circle cx=\"17\" cy=\"17\" r=\"3\" />"),
    FOLDER_SEARCH_2(
        "folder-search-2",
        "<circle cx=\"11.5\" cy=\"12.5\" r=\"2.5\" />\n  <path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M13.3 14.3 15 16\" />"),
    FOLDER_SYMLINK(
        "folder-symlink",
        "<path d=\"M2 9.35V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h7\" />\n  <path d=\"m8 16 3-3-3-3\" />"),
    FOLDER_SYNC(
        "folder-sync",
        "<path d=\"M9 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2v.5\" />\n  <path d=\"M12 10v4h4\" />\n  <path d=\"m12 14 1.535-1.605a5 5 0 0 1 8 1.5\" />\n  <path d=\"M22 22v-4h-4\" />\n  <path d=\"m22 18-1.535 1.605a5 5 0 0 1-8-1.5\" />"),
    FOLDER_TREE(
        "folder-tree",
        "<path d=\"M20 10a1 1 0 0 0 1-1V6a1 1 0 0 0-1-1h-2.5a1 1 0 0 1-.8-.4l-.9-1.2A1 1 0 0 0 15 3h-2a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1Z\" />\n  <path d=\"M20 21a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-2.9a1 1 0 0 1-.88-.55l-.42-.85a1 1 0 0 0-.92-.6H13a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1Z\" />\n  <path d=\"M3 5a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 3v13a2 2 0 0 0 2 2h3\" />"),
    FOLDER_UP(
        "folder-up",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"m9 13 3-3 3 3\" />"),
    FOLDER_USER(
        "folder-user",
        "<path d=\"M10.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <path d=\"M22 22a4 4 0 0 0-8 0\" />\n  <circle cx=\"18\" cy=\"15\" r=\"3\" />"),
    FOLDER_USERS(
        "folder-users",
        "<path d=\"M5.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <circle cx=\"13\" cy=\"15\" r=\"3\" />\n  <path d=\"M17 22a4 4 0 0 0-8 0\" />\n  <path d=\"M22 22A4 4 0 0 0 20.24 18.686 1 1 0 0 1 20.1 17.143 3 3 0 0 0 19.5 12.402\" />"),
    FOLDER_X(
        "folder-x",
        "<path d=\"M20 20a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.9a2 2 0 0 1-1.69-.9L9.6 3.9A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13a2 2 0 0 0 2 2Z\" />\n  <path d=\"m9.5 10.5 5 5\" />\n  <path d=\"m14.5 10.5-5 5\" />"),
    FOLDERS(
        "folders",
        "<path d=\"M20 5a2 2 0 0 1 2 2v7a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h2.5a1.5 1.5 0 0 1 1.2.6l.6.8a1.5 1.5 0 0 0 1.2.6z\" />\n  <path d=\"M3 8.268a2 2 0 0 0-1 1.738V19a2 2 0 0 0 2 2h11a2 2 0 0 0 1.732-1\" />"),
    GALLERY_HORIZONTAL_END(
        "gallery-horizontal-end",
        "<path d=\"M2 7v10\" />\n  <path d=\"M6 5v14\" />\n  <rect width=\"12\" height=\"18\" x=\"10\" y=\"3\" rx=\"2\" />"),
    GALLERY_VERTICAL_END(
        "gallery-vertical-end",
        "<path d=\"M7 2h10\" />\n  <path d=\"M5 6h14\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"10\" rx=\"2\" />"),
    GROUP(
        "group",
        "<path d=\"M3 7V5c0-1.1.9-2 2-2h2\" />\n  <path d=\"M17 3h2c1.1 0 2 .9 2 2v2\" />\n  <path d=\"M21 17v2c0 1.1-.9 2-2 2h-2\" />\n  <path d=\"M7 21H5c-1.1 0-2-.9-2-2v-2\" />\n  <rect width=\"7\" height=\"5\" x=\"7\" y=\"7\" rx=\"1\" />\n  <rect width=\"7\" height=\"5\" x=\"10\" y=\"12\" rx=\"1\" />"),
    HALF_NOTE("half-note", "<circle cx=\"12\" cy=\"18\" r=\"4\" />\n  <path d=\"M16 18V2\" />"),
    HARD_DRIVE_DOWNLOAD(
        "hard-drive-download",
        "<path d=\"M12 2v8\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HARD_DRIVE_UPLOAD(
        "hard-drive-upload",
        "<path d=\"m16 6-4-4-4 4\" />\n  <path d=\"M12 2v8\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HEADPHONES(
        "headphones",
        "<path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3\" />"),
    HEADSET(
        "headset",
        "<path d=\"M3 11h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-5Zm0 0a9 9 0 1 1 18 0m0 0v5a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3Z\" />\n  <path d=\"M21 16v2a4 4 0 0 1-4 4h-5\" />"),
    IMAGE(
        "image",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_DOWN(
        "image-down",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19 3 3v-5.5\" />\n  <path d=\"m17 22 3-3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_MINUS(
        "image-minus",
        "<path d=\"M21 9v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7\" />\n  <line x1=\"16\" x2=\"22\" y1=\"5\" y2=\"5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_OFF(
        "image-off",
        "<line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />\n  <path d=\"M10.41 10.41a2 2 0 1 1-2.83-2.83\" />\n  <line x1=\"13.5\" x2=\"6\" y1=\"13.5\" y2=\"21\" />\n  <line x1=\"18\" x2=\"21\" y1=\"12\" y2=\"15\" />\n  <path d=\"M3.59 3.59A1.99 1.99 0 0 0 3 5v14a2 2 0 0 0 2 2h14c.55 0 1.052-.22 1.41-.59\" />\n  <path d=\"M21 15V5a2 2 0 0 0-2-2H9\" />"),
    IMAGE_PLAY(
        "image-play",
        "<path d=\"M15 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M21 12.17V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />\n  <path d=\"m6 21 5-5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_PLUS(
        "image-plus",
        "<path d=\"M16 5h6\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M21 11.5V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7.5\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UP(
        "image-up",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19.5 3-3 3 3\" />\n  <path d=\"M17 22v-5.5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGES(
        "images",
        "<path d=\"m22 11-1.296-1.296a2.4 2.4 0 0 0-3.408 0L11 16\" />\n  <path d=\"M4 8a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2\" />\n  <circle cx=\"13\" cy=\"7\" r=\"1\" fill=\"currentColor\" />\n  <rect x=\"8\" y=\"2\" width=\"14\" height=\"14\" rx=\"2\" />"),
    IMPORT(
        "import",
        "<path d=\"M12 3v12\" />\n  <path d=\"m8 11 4 4 4-4\" />\n  <path d=\"M8 5H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-4\" />"),
    LIST_TREE(
        "list-tree",
        "<path d=\"M8 5h13\" />\n  <path d=\"M13 12h8\" />\n  <path d=\"M13 19h8\" />\n  <path d=\"M3 10a2 2 0 0 0 2 2h3\" />\n  <path d=\"M3 5v12a2 2 0 0 0 2 2h3\" />"),
    MESSAGE_SQUARE_DIFF(
        "message-square-diff",
        "<path d=\"M22 17a2 2 0 0 1-2 2H6.828a2 2 0 0 0-1.414.586l-2.202 2.202A.71.71 0 0 1 2 21.286V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2z\" />\n  <path d=\"M10 15h4\" />\n  <path d=\"M10 9h4\" />\n  <path d=\"M12 7v4\" />"),
    PACKAGE(
        "package",
        "<path d=\"M11 21.73a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73z\" />\n  <path d=\"M12 22V12\" />\n  <polyline points=\"3.29 7 12 12 20.71 7\" />\n  <path d=\"m7.5 4.27 9 5.15\" />"),
    PACKAGE_2(
        "package-2",
        "<path d=\"M12 3v6\" />\n  <path d=\"M16.76 3a2 2 0 0 1 1.8 1.1l2.23 4.479a2 2 0 0 1 .21.891V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V9.472a2 2 0 0 1 .211-.894L5.45 4.1A2 2 0 0 1 7.24 3z\" />\n  <path d=\"M3.054 9.013h17.893\" />"),
    PACKAGE_OPEN(
        "package-open",
        "<path d=\"M12 22v-9\" />\n  <path d=\"M15.17 2.21a1.67 1.67 0 0 1 1.63 0L21 4.57a1.93 1.93 0 0 1 0 3.36L8.82 14.79a1.655 1.655 0 0 1-1.64 0L3 12.43a1.93 1.93 0 0 1 0-3.36z\" />\n  <path d=\"M20 13v3.87a2.06 2.06 0 0 1-1.11 1.83l-6 3.08a1.93 1.93 0 0 1-1.78 0l-6-3.08A2.06 2.06 0 0 1 4 16.87V13\" />\n  <path d=\"M21 12.43a1.93 1.93 0 0 0 0-3.36L8.83 2.2a1.64 1.64 0 0 0-1.63 0L3 4.57a1.93 1.93 0 0 0 0 3.36l12.18 6.86a1.636 1.636 0 0 0 1.63 0z\" />"),
    PACKAGE_SEARCH(
        "package-search",
        "<path d=\"M12 22V12\" />\n  <path d=\"M20.27 18.27 22 20\" />\n  <path d=\"M21 10.498V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.729l7 4a2 2 0 0 0 2 .001l.98-.559\" />\n  <path d=\"M3.29 7 12 12l8.71-5\" />\n  <path d=\"m7.5 4.27 8.997 5.148\" />\n  <circle cx=\"18.5\" cy=\"16.5\" r=\"2.5\" />"),
    PAPERCLIP(
        "paperclip",
        "<path d=\"m16 6-8.414 8.586a2 2 0 0 0 2.829 2.829l8.414-8.586a4 4 0 1 0-5.657-5.657l-8.379 8.551a6 6 0 1 0 8.485 8.485l8.379-8.551\" />"),
    PARENTHESES(
        "parentheses",
        "<path d=\"M8 21s-4-3-4-9 4-9 4-9\" />\n  <path d=\"M16 3s4 3 4 9-4 9-4 9\" />"),
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
    SHEET(
        "sheet",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <line x1=\"3\" x2=\"21\" y1=\"9\" y2=\"9\" />\n  <line x1=\"3\" x2=\"21\" y1=\"15\" y2=\"15\" />\n  <line x1=\"9\" x2=\"9\" y1=\"9\" y2=\"21\" />\n  <line x1=\"15\" x2=\"15\" y1=\"9\" y2=\"21\" />"),
    SHIELD_KEYHOLE(
        "shield-keyhole",
        "<path d=\"M12 13v3\" />\n  <path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 01-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 011-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 011.52 0C14.51 3.81 17 5 19 5a1 1 0 011 1z\" />\n  <circle cx=\"12\" cy=\"11\" r=\"2\" />"),
    SHREDDER(
        "shredder",
        "<path d=\"M4 13V4a2 2 0 0 1 2-2h8a2.4 2.4 0 0 1 1.706.706l3.588 3.588A2.4 2.4 0 0 1 20 8v5\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M10 22v-5\" />\n  <path d=\"M14 19v-2\" />\n  <path d=\"M18 20v-3\" />\n  <path d=\"M2 13h20\" />\n  <path d=\"M6 20v-3\" />"),
    SIXTEENTH_NOTES(
        "sixteenth-notes",
        "<path d=\"M21 16V3a1 1 0 0 0-1.28-.96l-10 2.917a1 1 0 0 0-.72.96V19\" />\n  <path d=\"M21 6 9 9.5\" />\n  <circle cx=\"18\" cy=\"16\" r=\"3\" />\n  <circle cx=\"6\" cy=\"19\" r=\"3\" />"),
    SQUARE_BOTTOM_DASHED_SCISSORS(
        "square-bottom-dashed-scissors",
        "<path d=\"M14 21h1\" />\n  <path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M5 21a2 2 0 01-2-2V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />"),
    SQUARE_DASHED_BOTTOM(
        "square-dashed-bottom",
        "<path d=\"M5 21a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 21h1\" />"),
    SQUARE_DASHED_BOTTOM_CODE(
        "square-dashed-bottom-code",
        "<path d=\"M10 9.5 8 12l2 2.5\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"m14 9.5 2 2.5-2 2.5\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2\" />\n  <path d=\"M9 21h1\" />"),
    SQUARE_SCISSORS(
        "square-scissors",
        "<path d=\"m17 17-2.18-2.18\" />\n  <path d=\"M9.56 14.44 17 7\" />\n  <path d=\"M9.56 9.56 12 12\" />\n  <circle cx=\"8.5\" cy=\"15.5\" r=\"1.5\" />\n  <circle cx=\"8.5\" cy=\"8.5\" r=\"1.5\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_SPARKLES(
        "square-sparkles",
        "<path d=\"M11 15H7\" />\n  <path d=\"M15.41 2.49a.6.6 0 011.18 0l.63 3.334a1.2 1.2 0 00.956.955l3.334.631a.6.6 0 010 1.18l-3.334.63a1.2 1.2 0 00-.955.956l-.631 3.334a.6.6 0 01-1.18 0l-.63-3.334a1.2 1.2 0 00-.956-.955L10.49 8.59a.6.6 0 010-1.18l3.334-.63a1.2 1.2 0 00.955-.956z\" />\n  <path d=\"M21 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V5a2 2 0 012-2h6\" />\n  <path d=\"M9 13v4\" />"),
    SQUARE_STACK(
        "square-stack",
        "<path d=\"M4 10c-1.1 0-2-.9-2-2V4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <path d=\"M10 16c-1.1 0-2-.9-2-2v-4c0-1.1.9-2 2-2h4c1.1 0 2 .9 2 2\" />\n  <rect width=\"8\" height=\"8\" x=\"14\" y=\"14\" rx=\"2\" />"),
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
    TABLE_PROPERTIES(
        "table-properties",
        "<path d=\"M15 3v18\" />\n  <rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M21 15H3\" />"),
    TABLE_ROWS_SPLIT(
        "table-rows-split",
        "<path d=\"M14 10h2\" />\n  <path d=\"M15 22v-8\" />\n  <path d=\"M15 2v4\" />\n  <path d=\"M2 10h2\" />\n  <path d=\"M20 10h2\" />\n  <path d=\"M3 19h18\" />\n  <path d=\"M3 22v-6a2 2 135 0 1 2-2h14a2 2 45 0 1 2 2v6\" />\n  <path d=\"M3 2v2a2 2 45 0 0 2 2h14a2 2 135 0 0 2-2V2\" />\n  <path d=\"M8 10h2\" />\n  <path d=\"M9 22v-8\" />\n  <path d=\"M9 2v4\" />"),
    TRASH(
        "trash",
        "<path d=\"M10 11v6\" />\n  <path d=\"M14 11v6\" />\n  <path d=\"M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6\" />\n  <path d=\"M3 6h18\" />\n  <path d=\"M8 6V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2\" />"),
    TRASH_OFF(
        "trash-off",
        "<path d=\"M10 11v6\" />\n  <path d=\"M14 17v-3\" />\n  <path d=\"M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-1.576.768\" />\n  <path d=\"M19 6v7.344\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 6h-9.344\" />\n  <path d=\"M3 6h3\" />\n  <path d=\"M5 6v14a2 2 0 002 2h10a2 2 0 002-2v-1\" />"),
    UNGROUP(
        "ungroup",
        "<rect x=\"11\" y=\"14\" width=\"10\" height=\"7\" rx=\"2\" />\n  <rect x=\"3\" y=\"3\" width=\"10\" height=\"7\" rx=\"2\" />"),
    UPLOAD(
        "upload",
        "<path d=\"M12 3v12\" />\n  <path d=\"m17 8-5-5-5 5\" />\n  <path d=\"M21 15v4a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-4\" />"),
    VIDEOTAPE(
        "videotape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 8h20\" />\n  <circle cx=\"8\" cy=\"14\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"14\" r=\"2\" />"),
    WIFI_COG(
        "wifi-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"M2 8.82a15 15 0 0120 0\" />\n  <path d=\"m20.772 16.852.924-.383\" />\n  <path d=\"m20.772 19.148.924.383\" />\n  <path d=\"M5 12.859a10 10 0 0110.18-2.342\" />\n  <path d=\"M8.5 16.429a5 5 0 011.998-1.2\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />");

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
  default LucideIcon app_window_files() {
    return LucideIcon.create(Icon.APP_WINDOW);
  }

  default LucideIcon app_window_mac_files() {
    return LucideIcon.create(Icon.APP_WINDOW_MAC);
  }

  default LucideIcon archive_files() {
    return LucideIcon.create(Icon.ARCHIVE);
  }

  default LucideIcon archive_restore_files() {
    return LucideIcon.create(Icon.ARCHIVE_RESTORE);
  }

  default LucideIcon archive_x_files() {
    return LucideIcon.create(Icon.ARCHIVE_X);
  }

  default LucideIcon arrow_big_down_dash_files() {
    return LucideIcon.create(Icon.ARROW_BIG_DOWN_DASH);
  }

  default LucideIcon arrow_down_from_line_files() {
    return LucideIcon.create(Icon.ARROW_DOWN_FROM_LINE);
  }

  default LucideIcon arrow_down_to_line_files() {
    return LucideIcon.create(Icon.ARROW_DOWN_TO_LINE);
  }

  default LucideIcon arrow_up_from_line_files() {
    return LucideIcon.create(Icon.ARROW_UP_FROM_LINE);
  }

  default LucideIcon arrow_up_to_line_files() {
    return LucideIcon.create(Icon.ARROW_UP_TO_LINE);
  }

  default LucideIcon book_image_files() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon braces_files() {
    return LucideIcon.create(Icon.BRACES);
  }

  default LucideIcon brackets_files() {
    return LucideIcon.create(Icon.BRACKETS);
  }

  default LucideIcon briefcase_plus_files() {
    return LucideIcon.create(Icon.BRIEFCASE_PLUS);
  }

  default LucideIcon calendar_fold_files() {
    return LucideIcon.create(Icon.CALENDAR_FOLD);
  }

  default LucideIcon cassette_tape_files() {
    return LucideIcon.create(Icon.CASSETTE_TAPE);
  }

  default LucideIcon chart_pie_files() {
    return LucideIcon.create(Icon.CHART_PIE);
  }

  default LucideIcon cloud_backup_files() {
    return LucideIcon.create(Icon.CLOUD_BACKUP);
  }

  default LucideIcon cloud_download_files() {
    return LucideIcon.create(Icon.CLOUD_DOWNLOAD);
  }

  default LucideIcon cloud_sync_files() {
    return LucideIcon.create(Icon.CLOUD_SYNC);
  }

  default LucideIcon cloud_upload_files() {
    return LucideIcon.create(Icon.CLOUD_UPLOAD);
  }

  default LucideIcon combine_files() {
    return LucideIcon.create(Icon.COMBINE);
  }

  default LucideIcon diff_files() {
    return LucideIcon.create(Icon.DIFF);
  }

  default LucideIcon dock_files() {
    return LucideIcon.create(Icon.DOCK);
  }

  default LucideIcon download_files() {
    return LucideIcon.create(Icon.DOWNLOAD);
  }

  default LucideIcon eighth_note_files() {
    return LucideIcon.create(Icon.EIGHTH_NOTE);
  }

  default LucideIcon eighth_notes_files() {
    return LucideIcon.create(Icon.EIGHTH_NOTES);
  }

  default LucideIcon eject_files() {
    return LucideIcon.create(Icon.EJECT);
  }

  default LucideIcon file() {
    return LucideIcon.create(Icon.FILE);
  }

  default LucideIcon file_archive() {
    return LucideIcon.create(Icon.FILE_ARCHIVE);
  }

  default LucideIcon file_axis_3d_files() {
    return LucideIcon.create(Icon.FILE_AXIS_3D);
  }

  default LucideIcon file_badge() {
    return LucideIcon.create(Icon.FILE_BADGE);
  }

  default LucideIcon file_box_files() {
    return LucideIcon.create(Icon.FILE_BOX);
  }

  default LucideIcon file_braces_files() {
    return LucideIcon.create(Icon.FILE_BRACES);
  }

  default LucideIcon file_braces_corner_files() {
    return LucideIcon.create(Icon.FILE_BRACES_CORNER);
  }

  default LucideIcon file_chart_column() {
    return LucideIcon.create(Icon.FILE_CHART_COLUMN);
  }

  default LucideIcon file_chart_column_increasing() {
    return LucideIcon.create(Icon.FILE_CHART_COLUMN_INCREASING);
  }

  default LucideIcon file_chart_line() {
    return LucideIcon.create(Icon.FILE_CHART_LINE);
  }

  default LucideIcon file_chart_pie() {
    return LucideIcon.create(Icon.FILE_CHART_PIE);
  }

  default LucideIcon file_check() {
    return LucideIcon.create(Icon.FILE_CHECK);
  }

  default LucideIcon file_check_corner() {
    return LucideIcon.create(Icon.FILE_CHECK_CORNER);
  }

  default LucideIcon file_clock_files() {
    return LucideIcon.create(Icon.FILE_CLOCK);
  }

  default LucideIcon file_code_files() {
    return LucideIcon.create(Icon.FILE_CODE);
  }

  default LucideIcon file_code_corner_files() {
    return LucideIcon.create(Icon.FILE_CODE_CORNER);
  }

  default LucideIcon file_cog() {
    return LucideIcon.create(Icon.FILE_COG);
  }

  default LucideIcon file_diff_files() {
    return LucideIcon.create(Icon.FILE_DIFF);
  }

  default LucideIcon file_digit_files() {
    return LucideIcon.create(Icon.FILE_DIGIT);
  }

  default LucideIcon file_down_files() {
    return LucideIcon.create(Icon.FILE_DOWN);
  }

  default LucideIcon file_exclamation_point_files() {
    return LucideIcon.create(Icon.FILE_EXCLAMATION_POINT);
  }

  default LucideIcon file_headphone() {
    return LucideIcon.create(Icon.FILE_HEADPHONE);
  }

  default LucideIcon file_heart() {
    return LucideIcon.create(Icon.FILE_HEART);
  }

  default LucideIcon file_image() {
    return LucideIcon.create(Icon.FILE_IMAGE);
  }

  default LucideIcon file_input_files() {
    return LucideIcon.create(Icon.FILE_INPUT);
  }

  default LucideIcon file_key_files() {
    return LucideIcon.create(Icon.FILE_KEY);
  }

  default LucideIcon file_lock_files() {
    return LucideIcon.create(Icon.FILE_LOCK);
  }

  default LucideIcon file_minus() {
    return LucideIcon.create(Icon.FILE_MINUS);
  }

  default LucideIcon file_minus_corner() {
    return LucideIcon.create(Icon.FILE_MINUS_CORNER);
  }

  default LucideIcon file_music_files() {
    return LucideIcon.create(Icon.FILE_MUSIC);
  }

  default LucideIcon file_output_files() {
    return LucideIcon.create(Icon.FILE_OUTPUT);
  }

  default LucideIcon file_pen() {
    return LucideIcon.create(Icon.FILE_PEN);
  }

  default LucideIcon file_pen_line() {
    return LucideIcon.create(Icon.FILE_PEN_LINE);
  }

  default LucideIcon file_play() {
    return LucideIcon.create(Icon.FILE_PLAY);
  }

  default LucideIcon file_plus() {
    return LucideIcon.create(Icon.FILE_PLUS);
  }

  default LucideIcon file_plus_corner() {
    return LucideIcon.create(Icon.FILE_PLUS_CORNER);
  }

  default LucideIcon file_question_mark() {
    return LucideIcon.create(Icon.FILE_QUESTION_MARK);
  }

  default LucideIcon file_scan() {
    return LucideIcon.create(Icon.FILE_SCAN);
  }

  default LucideIcon file_search() {
    return LucideIcon.create(Icon.FILE_SEARCH);
  }

  default LucideIcon file_search_corner() {
    return LucideIcon.create(Icon.FILE_SEARCH_CORNER);
  }

  default LucideIcon file_signal() {
    return LucideIcon.create(Icon.FILE_SIGNAL);
  }

  default LucideIcon file_sliders_files() {
    return LucideIcon.create(Icon.FILE_SLIDERS);
  }

  default LucideIcon file_spreadsheet() {
    return LucideIcon.create(Icon.FILE_SPREADSHEET);
  }

  default LucideIcon file_stack_files() {
    return LucideIcon.create(Icon.FILE_STACK);
  }

  default LucideIcon file_symlink() {
    return LucideIcon.create(Icon.FILE_SYMLINK);
  }

  default LucideIcon file_terminal_files() {
    return LucideIcon.create(Icon.FILE_TERMINAL);
  }

  default LucideIcon file_text_files() {
    return LucideIcon.create(Icon.FILE_TEXT);
  }

  default LucideIcon file_type_files() {
    return LucideIcon.create(Icon.FILE_TYPE);
  }

  default LucideIcon file_type_corner_files() {
    return LucideIcon.create(Icon.FILE_TYPE_CORNER);
  }

  default LucideIcon file_up_files() {
    return LucideIcon.create(Icon.FILE_UP);
  }

  default LucideIcon file_user_files() {
    return LucideIcon.create(Icon.FILE_USER);
  }

  default LucideIcon file_video_camera() {
    return LucideIcon.create(Icon.FILE_VIDEO_CAMERA);
  }

  default LucideIcon file_volume() {
    return LucideIcon.create(Icon.FILE_VOLUME);
  }

  default LucideIcon file_x() {
    return LucideIcon.create(Icon.FILE_X);
  }

  default LucideIcon file_x_corner() {
    return LucideIcon.create(Icon.FILE_X_CORNER);
  }

  default LucideIcon files() {
    return LucideIcon.create(Icon.FILES);
  }

  default LucideIcon folder() {
    return LucideIcon.create(Icon.FOLDER);
  }

  default LucideIcon folder_archive() {
    return LucideIcon.create(Icon.FOLDER_ARCHIVE);
  }

  default LucideIcon folder_bookmark() {
    return LucideIcon.create(Icon.FOLDER_BOOKMARK);
  }

  default LucideIcon folder_check() {
    return LucideIcon.create(Icon.FOLDER_CHECK);
  }

  default LucideIcon folder_clock_files() {
    return LucideIcon.create(Icon.FOLDER_CLOCK);
  }

  default LucideIcon folder_closed() {
    return LucideIcon.create(Icon.FOLDER_CLOSED);
  }

  default LucideIcon folder_code_files() {
    return LucideIcon.create(Icon.FOLDER_CODE);
  }

  default LucideIcon folder_cog() {
    return LucideIcon.create(Icon.FOLDER_COG);
  }

  default LucideIcon folder_dot_files() {
    return LucideIcon.create(Icon.FOLDER_DOT);
  }

  default LucideIcon folder_down_files() {
    return LucideIcon.create(Icon.FOLDER_DOWN);
  }

  default LucideIcon folder_git() {
    return LucideIcon.create(Icon.FOLDER_GIT);
  }

  default LucideIcon folder_git_2() {
    return LucideIcon.create(Icon.FOLDER_GIT_2);
  }

  default LucideIcon folder_heart() {
    return LucideIcon.create(Icon.FOLDER_HEART);
  }

  default LucideIcon folder_input_files() {
    return LucideIcon.create(Icon.FOLDER_INPUT);
  }

  default LucideIcon folder_kanban_files() {
    return LucideIcon.create(Icon.FOLDER_KANBAN);
  }

  default LucideIcon folder_key_files() {
    return LucideIcon.create(Icon.FOLDER_KEY);
  }

  default LucideIcon folder_lock_files() {
    return LucideIcon.create(Icon.FOLDER_LOCK);
  }

  default LucideIcon folder_minus() {
    return LucideIcon.create(Icon.FOLDER_MINUS);
  }

  default LucideIcon folder_open() {
    return LucideIcon.create(Icon.FOLDER_OPEN);
  }

  default LucideIcon folder_open_dot_files() {
    return LucideIcon.create(Icon.FOLDER_OPEN_DOT);
  }

  default LucideIcon folder_output_files() {
    return LucideIcon.create(Icon.FOLDER_OUTPUT);
  }

  default LucideIcon folder_pen() {
    return LucideIcon.create(Icon.FOLDER_PEN);
  }

  default LucideIcon folder_plus() {
    return LucideIcon.create(Icon.FOLDER_PLUS);
  }

  default LucideIcon folder_root_files() {
    return LucideIcon.create(Icon.FOLDER_ROOT);
  }

  default LucideIcon folder_search() {
    return LucideIcon.create(Icon.FOLDER_SEARCH);
  }

  default LucideIcon folder_search_2() {
    return LucideIcon.create(Icon.FOLDER_SEARCH_2);
  }

  default LucideIcon folder_symlink() {
    return LucideIcon.create(Icon.FOLDER_SYMLINK);
  }

  default LucideIcon folder_sync_files() {
    return LucideIcon.create(Icon.FOLDER_SYNC);
  }

  default LucideIcon folder_tree() {
    return LucideIcon.create(Icon.FOLDER_TREE);
  }

  default LucideIcon folder_up_files() {
    return LucideIcon.create(Icon.FOLDER_UP);
  }

  default LucideIcon folder_user_files() {
    return LucideIcon.create(Icon.FOLDER_USER);
  }

  default LucideIcon folder_users_files() {
    return LucideIcon.create(Icon.FOLDER_USERS);
  }

  default LucideIcon folder_x() {
    return LucideIcon.create(Icon.FOLDER_X);
  }

  default LucideIcon folders() {
    return LucideIcon.create(Icon.FOLDERS);
  }

  default LucideIcon gallery_horizontal_end_files() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_vertical_end_files() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon group() {
    return LucideIcon.create(Icon.GROUP);
  }

  default LucideIcon half_note_files() {
    return LucideIcon.create(Icon.HALF_NOTE);
  }

  default LucideIcon hard_drive_download_files() {
    return LucideIcon.create(Icon.HARD_DRIVE_DOWNLOAD);
  }

  default LucideIcon hard_drive_upload_files() {
    return LucideIcon.create(Icon.HARD_DRIVE_UPLOAD);
  }

  default LucideIcon headphones_files() {
    return LucideIcon.create(Icon.HEADPHONES);
  }

  default LucideIcon headset_files() {
    return LucideIcon.create(Icon.HEADSET);
  }

  default LucideIcon image_files() {
    return LucideIcon.create(Icon.IMAGE);
  }

  default LucideIcon image_down_files() {
    return LucideIcon.create(Icon.IMAGE_DOWN);
  }

  default LucideIcon image_minus_files() {
    return LucideIcon.create(Icon.IMAGE_MINUS);
  }

  default LucideIcon image_off_files() {
    return LucideIcon.create(Icon.IMAGE_OFF);
  }

  default LucideIcon image_play_files() {
    return LucideIcon.create(Icon.IMAGE_PLAY);
  }

  default LucideIcon image_plus_files() {
    return LucideIcon.create(Icon.IMAGE_PLUS);
  }

  default LucideIcon image_up_files() {
    return LucideIcon.create(Icon.IMAGE_UP);
  }

  default LucideIcon images_files() {
    return LucideIcon.create(Icon.IMAGES);
  }

  default LucideIcon import_files() {
    return LucideIcon.create(Icon.IMPORT);
  }

  default LucideIcon list_tree_files() {
    return LucideIcon.create(Icon.LIST_TREE);
  }

  default LucideIcon message_square_diff_files() {
    return LucideIcon.create(Icon.MESSAGE_SQUARE_DIFF);
  }

  default LucideIcon package_files() {
    return LucideIcon.create(Icon.PACKAGE);
  }

  default LucideIcon package_2_files() {
    return LucideIcon.create(Icon.PACKAGE_2);
  }

  default LucideIcon package_open_files() {
    return LucideIcon.create(Icon.PACKAGE_OPEN);
  }

  default LucideIcon package_search_files() {
    return LucideIcon.create(Icon.PACKAGE_SEARCH);
  }

  default LucideIcon paperclip_files() {
    return LucideIcon.create(Icon.PAPERCLIP);
  }

  default LucideIcon parentheses_files() {
    return LucideIcon.create(Icon.PARENTHESES);
  }

  default LucideIcon save_files() {
    return LucideIcon.create(Icon.SAVE);
  }

  default LucideIcon save_all_files() {
    return LucideIcon.create(Icon.SAVE_ALL);
  }

  default LucideIcon save_check_files() {
    return LucideIcon.create(Icon.SAVE_CHECK);
  }

  default LucideIcon save_off_files() {
    return LucideIcon.create(Icon.SAVE_OFF);
  }

  default LucideIcon save_pen_files() {
    return LucideIcon.create(Icon.SAVE_PEN);
  }

  default LucideIcon save_plus_files() {
    return LucideIcon.create(Icon.SAVE_PLUS);
  }

  default LucideIcon sheet_files() {
    return LucideIcon.create(Icon.SHEET);
  }

  default LucideIcon shield_keyhole_files() {
    return LucideIcon.create(Icon.SHIELD_KEYHOLE);
  }

  default LucideIcon shredder_files() {
    return LucideIcon.create(Icon.SHREDDER);
  }

  default LucideIcon sixteenth_notes_files() {
    return LucideIcon.create(Icon.SIXTEENTH_NOTES);
  }

  default LucideIcon square_bottom_dashed_scissors_files() {
    return LucideIcon.create(Icon.SQUARE_BOTTOM_DASHED_SCISSORS);
  }

  default LucideIcon square_dashed_bottom_files() {
    return LucideIcon.create(Icon.SQUARE_DASHED_BOTTOM);
  }

  default LucideIcon square_dashed_bottom_code_files() {
    return LucideIcon.create(Icon.SQUARE_DASHED_BOTTOM_CODE);
  }

  default LucideIcon square_scissors_files() {
    return LucideIcon.create(Icon.SQUARE_SCISSORS);
  }

  default LucideIcon square_sparkles_files() {
    return LucideIcon.create(Icon.SQUARE_SPARKLES);
  }

  default LucideIcon square_stack_files() {
    return LucideIcon.create(Icon.SQUARE_STACK);
  }

  default LucideIcon table_files() {
    return LucideIcon.create(Icon.TABLE);
  }

  default LucideIcon table_2_files() {
    return LucideIcon.create(Icon.TABLE_2);
  }

  default LucideIcon table_cells_merge_files() {
    return LucideIcon.create(Icon.TABLE_CELLS_MERGE);
  }

  default LucideIcon table_cells_split_files() {
    return LucideIcon.create(Icon.TABLE_CELLS_SPLIT);
  }

  default LucideIcon table_columns_split_files() {
    return LucideIcon.create(Icon.TABLE_COLUMNS_SPLIT);
  }

  default LucideIcon table_properties_files() {
    return LucideIcon.create(Icon.TABLE_PROPERTIES);
  }

  default LucideIcon table_rows_split_files() {
    return LucideIcon.create(Icon.TABLE_ROWS_SPLIT);
  }

  default LucideIcon trash_files() {
    return LucideIcon.create(Icon.TRASH);
  }

  default LucideIcon trash_off_files() {
    return LucideIcon.create(Icon.TRASH_OFF);
  }

  default LucideIcon ungroup_files() {
    return LucideIcon.create(Icon.UNGROUP);
  }

  default LucideIcon upload_files() {
    return LucideIcon.create(Icon.UPLOAD);
  }

  default LucideIcon videotape_files() {
    return LucideIcon.create(Icon.VIDEOTAPE);
  }

  default LucideIcon wifi_cog_files() {
    return LucideIcon.create(Icon.WIFI_COG);
  }
}
