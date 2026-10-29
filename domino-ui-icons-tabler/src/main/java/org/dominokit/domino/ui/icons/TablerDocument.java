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

/** Tabler Document catalog category. */
public interface TablerDocument {
  enum OutlineIcon implements TablerIconDefinition {
    ARCHIVE(
        "archive",
        "<path d=\"M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2\" />\n  <path d=\"M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-10\" />\n  <path d=\"M10 12l4 0\" />"),
    ARCHIVE_OFF(
        "archive-off",
        "<path d=\"M8 4h11a2 2 0 1 1 0 4h-7m-4 0h-3a2 2 0 0 1 -.826 -3.822\" />\n  <path d=\"M5 8v10a2 2 0 0 0 2 2h10a2 2 0 0 0 1.824 -1.18m.176 -3.82v-7\" />\n  <path d=\"M10 12h2\" />\n  <path d=\"M3 3l18 18\" />"),
    ARTICLE(
        "article",
        "<path d=\"M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M7 8h10\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h10\" />"),
    ARTICLE_OFF(
        "article-off",
        "<path d=\"M8 4h11a2 2 0 0 1 2 2v11m-1.172 2.821a1.993 1.993 0 0 1 -.828 .179h-14a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 1.156 -1.814\" />\n  <path d=\"M7 8h1m4 0h5\" />\n  <path d=\"M7 12h5m4 0h1\" />\n  <path d=\"M7 16h9\" />\n  <path d=\"M3 3l18 18\" />"),
    BOOK(
        "book",
        "<path d=\"M3 19a9 9 0 0 1 9 0a9 9 0 0 1 9 0\" />\n  <path d=\"M3 6a9 9 0 0 1 9 0a9 9 0 0 1 9 0\" />\n  <path d=\"M3 6l0 13\" />\n  <path d=\"M12 6l0 13\" />\n  <path d=\"M21 6l0 13\" />"),
    BOOK_2(
        "book-2",
        "<path d=\"M19 4v16h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12\" />\n  <path d=\"M19 16h-12a2 2 0 0 0 -2 2\" />\n  <path d=\"M9 8h6\" />"),
    BOOK_DOWNLOAD(
        "book-download",
        "<path d=\"M12 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12v5\" />\n  <path d=\"M13 16h-7a2 2 0 0 0 -2 2\" />\n  <path d=\"M15 19l3 3l3 -3\" />\n  <path d=\"M18 22v-9\" />"),
    BOOK_OFF(
        "book-off",
        "<path d=\"M3 19a9 9 0 0 1 9 0a9 9 0 0 1 5.899 -1.096\" />\n  <path d=\"M3 6a9 9 0 0 1 2.114 -.884m3.8 -.21c1.07 .17 2.116 .534 3.086 1.094a9 9 0 0 1 9 0\" />\n  <path d=\"M3 6v13\" />\n  <path d=\"M12 6v2m0 4v7\" />\n  <path d=\"M21 6v11\" />\n  <path d=\"M3 3l18 18\" />"),
    BOOK_UPLOAD(
        "book-upload",
        "<path d=\"M14 20h-8a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12v5\" />\n  <path d=\"M11 16h-5a2 2 0 0 0 -2 2\" />\n  <path d=\"M15 16l3 -3l3 3\" />\n  <path d=\"M18 13v9\" />"),
    BOOKMARK("bookmark", "<path d=\"M18 7v14l-6 -4l-6 4v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4\" />"),
    BOOKMARK_AI(
        "bookmark-ai",
        "<path d=\"M10.02 18.32l-4.02 2.68v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v4.5\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    BOOKMARK_EDIT(
        "bookmark-edit",
        "<path d=\"M12 17l-6 4v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v4\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 1 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    BOOKMARK_MINUS(
        "bookmark-minus",
        "<path d=\"M12 17l-6 4v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v8\" />\n  <path d=\"M16 19h6\" />"),
    BOOKMARK_OFF(
        "bookmark-off",
        "<path d=\"M7.708 3.721a3.982 3.982 0 0 1 2.292 -.721h4a4 4 0 0 1 4 4v7m0 4v3l-6 -4l-6 4v-14c0 -.308 .035 -.609 .1 -.897\" />\n  <path d=\"M3 3l18 18\" />"),
    BOOKMARK_PLUS(
        "bookmark-plus",
        "<path d=\"M12 17l-6 4v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    BOOKMARK_QUESTION(
        "bookmark-question",
        "<path d=\"M15 19l-3 -2l-6 4v-14a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v4\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    BOOKMARKS(
        "bookmarks",
        "<path d=\"M15 10v11l-5 -3l-5 3v-11a3 3 0 0 1 3 -3h4a3 3 0 0 1 3 3\" />\n  <path d=\"M11 3h5a3 3 0 0 1 3 3v11\" />"),
    BOOKMARKS_OFF(
        "bookmarks-off",
        "<path d=\"M11 7h2a2 2 0 0 1 2 2v2m0 4v6l-5 -3l-5 3v-12a2 2 0 0 1 2 -2\" />\n  <path d=\"M9.265 4a2 2 0 0 1 1.735 -1h6a2 2 0 0 1 2 2v10\" />\n  <path d=\"M3 3l18 18\" />"),
    BOOKS(
        "books",
        "<path d=\"M5 5a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M9 5a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M5 8h4\" />\n  <path d=\"M9 16h4\" />\n  <path d=\"M13.803 4.56l2.184 -.53c.562 -.135 1.133 .19 1.282 .732l3.695 13.418a1.02 1.02 0 0 1 -.634 1.219l-.133 .041l-2.184 .53c-.562 .135 -1.133 -.19 -1.282 -.732l-3.695 -13.418a1.02 1.02 0 0 1 .634 -1.219l.133 -.041\" />\n  <path d=\"M14 9l4 -1\" />\n  <path d=\"M16 16l3.923 -.98\" />"),
    BOOKS_OFF(
        "books-off",
        "<path d=\"M9 9v10a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-14\" />\n  <path d=\"M8 4a1 1 0 0 1 1 1\" />\n  <path d=\"M9 5a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v4\" />\n  <path d=\"M13 13v6a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-10\" />\n  <path d=\"M5 8h3\" />\n  <path d=\"M9 16h4\" />\n  <path d=\"M14.254 10.244l-1.218 -4.424a1.02 1.02 0 0 1 .634 -1.219l.133 -.041l2.184 -.53c.562 -.135 1.133 .19 1.282 .732l3.236 11.75\" />\n  <path d=\"M19.585 19.589l-1.572 .38c-.562 .136 -1.133 -.19 -1.282 -.731l-.952 -3.458\" />\n  <path d=\"M14 9l4 -1\" />\n  <path d=\"M19.207 15.199l.716 -.18\" />\n  <path d=\"M3 3l18 18\" />"),
    CERTIFICATE(
        "certificate",
        "<path d=\"M12 15a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M13 17.5v4.5l2 -1.5l2 1.5v-4.5\" />\n  <path d=\"M10 19h-5a2 2 0 0 1 -2 -2v-10c0 -1.1 .9 -2 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -1 1.73\" />\n  <path d=\"M6 9l12 0\" />\n  <path d=\"M6 12l3 0\" />\n  <path d=\"M6 15l2 0\" />"),
    CERTIFICATE_2(
        "certificate-2",
        "<path d=\"M9 15a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M10 7h4\" />\n  <path d=\"M10 18v4l2 -1l2 1v-4\" />\n  <path d=\"M10 19h-2a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-2\" />"),
    CERTIFICATE_2_OFF(
        "certificate-2-off",
        "<path d=\"M12 12a3 3 0 1 0 3 3\" />\n  <path d=\"M11 7h3\" />\n  <path d=\"M10 18v4l2 -1l2 1v-4\" />\n  <path d=\"M10 19h-2a2 2 0 0 1 -2 -2v-11m1.18 -2.825c.25 -.112 .529 -.175 .82 -.175h8a2 2 0 0 1 2 2v9m-.175 3.82a2 2 0 0 1 -1.825 1.18h-2\" />\n  <path d=\"M3 3l18 18\" />"),
    CERTIFICATE_OFF(
        "certificate-off",
        "<path d=\"M12.876 12.881a3 3 0 0 0 4.243 4.243m.588 -3.42a3.012 3.012 0 0 0 -1.437 -1.423\" />\n  <path d=\"M13 17.5v4.5l2 -1.5l2 1.5v-4.5\" />\n  <path d=\"M10 19h-5a2 2 0 0 1 -2 -2v-10c0 -1.1 .9 -2 2 -2m4 0h10a2 2 0 0 1 2 2v10\" />\n  <path d=\"M6 9h3m4 0h5\" />\n  <path d=\"M6 12h3\" />\n  <path d=\"M6 15h2\" />\n  <path d=\"M3 3l18 18\" />"),
    CHALKBOARD(
        "chalkboard",
        "<path d=\"M8 19h-3a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v11a1 1 0 0 1 -1 1\" />\n  <path d=\"M11 17a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -1\" />"),
    CHALKBOARD_OFF(
        "chalkboard-off",
        "<path d=\"M8 19h-3a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2m4 0h10a2 2 0 0 1 2 2v10\" />\n  <path d=\"M17 17v1a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h4\" />\n  <path d=\"M3 3l18 18\" />"),
    CLIPBOARD(
        "clipboard",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />"),
    CLIPBOARD_CHECK(
        "clipboard-check",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 14l2 2l4 -4\" />"),
    CLIPBOARD_COPY(
        "clipboard-copy",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h3m9 -9v-5a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M13 17v-1a1 1 0 0 1 1 -1h1m3 0h1a1 1 0 0 1 1 1v1m0 3v1a1 1 0 0 1 -1 1h-1m-3 0h-1a1 1 0 0 1 -1 -1v-1\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />"),
    CLIPBOARD_DATA(
        "clipboard-data",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 17v-4\" />\n  <path d=\"M12 17v-1\" />\n  <path d=\"M15 17v-2\" />\n  <path d=\"M12 17v-1\" />"),
    CLIPBOARD_HEART(
        "clipboard-heart",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M11.993 16.75l2.747 -2.815a1.9 1.9 0 0 0 0 -2.632a1.775 1.775 0 0 0 -2.56 0l-.183 .188l-.183 -.189a1.775 1.775 0 0 0 -2.56 0a1.899 1.899 0 0 0 0 2.632l2.738 2.825l.001 -.009\" />"),
    CLIPBOARD_LIST(
        "clipboard-list",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 12l.01 0\" />\n  <path d=\"M13 12l2 0\" />\n  <path d=\"M9 16l.01 0\" />\n  <path d=\"M13 16l2 0\" />"),
    CLIPBOARD_OFF(
        "clipboard-off",
        "<path d=\"M5.575 5.597a2 2 0 0 0 -.575 1.403v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2m0 -4v-8a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M3 3l18 18\" />"),
    CLIPBOARD_PLUS(
        "clipboard-plus",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M12 12v4\" />"),
    CLIPBOARD_SEARCH(
        "clipboard-search",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h4.5m7.5 -10v-4a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    CLIPBOARD_SMILE(
        "clipboard-smile",
        "<path d=\"M10 13h.01\" />\n  <path d=\"M14 13h.01\" />\n  <path d=\"M10 16a3.5 3.5 0 0 0 4 0\" />\n  <path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />"),
    CLIPBOARD_TEXT(
        "clipboard-text",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M9 16h6\" />"),
    CLIPBOARD_TYPOGRAPHY(
        "clipboard-typography",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 12v-1h6v1\" />\n  <path d=\"M12 11v6\" />\n  <path d=\"M11 17h2\" />"),
    CLIPBOARD_X(
        "clipboard-x",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 12l4 4m0 -4l-4 4\" />"),
    CONTRACT(
        "contract",
        "<path d=\"M8 21h-2a3 3 0 0 1 -3 -3v-1h5.5\" />\n  <path d=\"M17 8.5v-3.5a2 2 0 1 1 2 2h-2\" />\n  <path d=\"M19 3h-11a3 3 0 0 0 -3 3v11\" />\n  <path d=\"M9 7h4\" />\n  <path d=\"M9 11h4\" />\n  <path d=\"M18.42 12.61a2.1 2.1 0 0 1 2.97 2.97l-6.39 6.42h-3v-3l6.42 -6.39\" />"),
    FILE(
        "file",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />"),
    FILE_3D(
        "file-3d",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 13.5l4 -1.5\" />\n  <path d=\"M8 11.846l4 1.654v4.5l4 -1.846v-4.308l-4 -1.846l-4 1.846\" />\n  <path d=\"M8 12v4.2l4 1.8\" />"),
    FILE_AI(
        "file-ai",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M10 21h-3a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    FILE_ALERT(
        "file-alert",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 17l.01 0\" />\n  <path d=\"M12 11l0 3\" />"),
    FILE_ANALYTICS(
        "file-analytics",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 17l0 -5\" />\n  <path d=\"M12 17l0 -1\" />\n  <path d=\"M15 17l0 -3\" />"),
    FILE_ARROW_LEFT(
        "file-arrow-left",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M15 15h-6\" />\n  <path d=\"M11.5 17.5l-2.5 -2.5l2.5 -2.5\" />"),
    FILE_ARROW_RIGHT(
        "file-arrow-right",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 15h6\" />\n  <path d=\"M12.5 17.5l2.5 -2.5l-2.5 -2.5\" />"),
    FILE_BARCODE(
        "file-barcode",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M8 13h1v3h-1l0 -3\" />\n  <path d=\"M12 13v3\" />\n  <path d=\"M15 13h1v3h-1l0 -3\" />"),
    FILE_BITCOIN(
        "file-bitcoin",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v2\" />\n  <path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />"),
    FILE_BROKEN(
        "file-broken",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 7v-2a2 2 0 0 1 2 -2h7l5 5v2\" />\n  <path d=\"M19 19a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2\" />\n  <path d=\"M5 16h.01\" />\n  <path d=\"M5 13h.01\" />\n  <path d=\"M5 10h.01\" />\n  <path d=\"M19 13h.01\" />\n  <path d=\"M19 16h.01\" />"),
    FILE_CERTIFICATE(
        "file-certificate",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 8v-3a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-5\" />\n  <path d=\"M3 14a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M4.5 17l-1.5 5l3 -1.5l3 1.5l-1.5 -5\" />"),
    FILE_CHART(
        "file-chart",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 10v4h4\" />\n  <path d=\"M8 14a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />"),
    FILE_CHECK(
        "file-check",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 15l2 2l4 -4\" />"),
    FILE_CODE(
        "file-code",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 13l-1 2l1 2\" />\n  <path d=\"M14 13l1 2l-1 2\" />"),
    FILE_CODE_2(
        "file-code-2",
        "<path d=\"M10 12h-1v5h1\" />\n  <path d=\"M14 12h1v5h-1\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />"),
    FILE_CV(
        "file-cv",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M11 12.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M13 11l1.5 6l1.5 -6\" />"),
    FILE_DATABASE(
        "file-database",
        "<path d=\"M8 12.75a4 1.75 0 1 0 8 0a4 1.75 0 1 0 -8 0\" />\n  <path d=\"M8 12.5v3.75c0 .966 1.79 1.75 4 1.75s4 -.784 4 -1.75v-3.75\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />"),
    FILE_DELTA(
        "file-delta",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 17h6l-3 -6l-3 6\" />"),
    FILE_DESCRIPTION(
        "file-description",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 17h6\" />\n  <path d=\"M9 13h6\" />"),
    FILE_DIFF(
        "file-diff",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 10l0 4\" />\n  <path d=\"M10 12l4 0\" />\n  <path d=\"M10 17l4 0\" />"),
    FILE_DIGIT(
        "file-digit",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9 13a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-1a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M15 12v5\" />"),
    FILE_DISLIKE(
        "file-dislike",
        "<path d=\"M3 15a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-1a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M6 15a1 1 0 0 1 1 -1h3.756a1 1 0 0 1 .958 .713l1.2 3c.09 .303 .133 .63 -.056 .884c-.188 .254 -.542 .403 -.858 .403h-2v2.467a1.1 1.1 0 0 1 -2.015 .61l-1.985 -3.077v-4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 11v-6a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-2.5\" />"),
    FILE_DOLLAR(
        "file-dollar",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M14 11h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M12 17v1m0 -8v1\" />"),
    FILE_DOTS(
        "file-dots",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 14v.01\" />\n  <path d=\"M12 14v.01\" />\n  <path d=\"M15 14v.01\" />"),
    FILE_DOWNLOAD(
        "file-download",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 17v-6\" />\n  <path d=\"M9.5 14.5l2.5 2.5l2.5 -2.5\" />"),
    FILE_EURO(
        "file-euro",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 14h-3\" />\n  <path d=\"M14 11.172a3 3 0 1 0 0 5.656\" />"),
    FILE_EXCEL(
        "file-excel",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 12l4 5\" />\n  <path d=\"M10 17l4 -5\" />"),
    FILE_EXPORT(
        "file-export",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M11.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v5m-5 6h7m-3 -3l3 3l-3 3\" />"),
    FILE_FUNCTION(
        "file-function",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10.5 17h.333c.474 0 .87 -.323 .916 -.746l.502 -4.508c.047 -.423 .443 -.746 .916 -.746h.333\" />\n  <path d=\"M10.5 14h3\" />"),
    FILE_HORIZONTAL(
        "file-horizontal",
        "<path d=\"M16 5v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M3 7v10a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-7l-5 -5h-11a2 2 0 0 0 -2 2\" />"),
    FILE_IMPORT(
        "file-import",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 13v-8a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-5.5m-9.5 -2h7m-3 -3l3 3l-3 3\" />"),
    FILE_INFINITY(
        "file-infinity",
        "<path d=\"M15.536 17.586a2.123 2.123 0 0 0 -2.929 0a1.951 1.951 0 0 0 0 2.828c.809 .781 2.12 .781 2.929 0c.809 -.781 -.805 .778 0 0l1.46 -1.41l1.46 -1.419\" />\n  <path d=\"M15.54 17.582l1.46 1.42l1.46 1.41c.809 .78 -.805 -.779 0 0s2.12 .781 2.929 0a1.951 1.951 0 0 0 0 -2.828a2.123 2.123 0 0 0 -2.929 0\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9.5 21h-2.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v6\" />"),
    FILE_INFO(
        "file-info",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M11 14h1v4h1\" />\n  <path d=\"M12 11h.01\" />"),
    FILE_INVOICE(
        "file-invoice",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 7l1 0\" />\n  <path d=\"M9 13l6 0\" />\n  <path d=\"M13 17l2 0\" />"),
    FILE_ISR(
        "file-isr",
        "<path d=\"M15 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M15 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M6 8v-3a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-7\" />\n  <path d=\"M3 15l3 -3l3 3\" />"),
    FILE_LAMBDA(
        "file-lambda",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 17l2 -3\" />\n  <path d=\"M15 17c-2.5 0 -2.5 -6 -5 -6\" />"),
    FILE_LIKE(
        "file-like",
        "<path d=\"M3 17a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-1a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M6 20a1 1 0 0 0 1 1h3.756a1 1 0 0 0 .958 -.713l1.2 -3c.09 -.303 .133 -.63 -.056 -.884c-.188 -.254 -.542 -.403 -.858 -.403h-2v-2.467a1.1 1.1 0 0 0 -2.015 -.61l-1.985 3.077v4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12.1v-7.1a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-2.3\" />"),
    FILE_LOCK(
        "file-lock",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M13 21h-6a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v3\" />\n  <path d=\"M17 19a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1v-2\" />\n  <path d=\"M18 18v-1.5a1.5 1.5 0 1 1 3 0v1.5\" />"),
    FILE_MINUS(
        "file-minus",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 14l6 0\" />"),
    FILE_MUSIC(
        "file-music",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M12 16l0 -5l2 1\" />"),
    FILE_NEUTRAL(
        "file-neutral",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2m-7 -7h.01m3.99 0h.01m-4.01 3h4\" />"),
    FILE_OFF(
        "file-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M7 3h7l5 5v7m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />"),
    FILE_ORIENTATION(
        "file-orientation",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M10 21h-3a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v2\" />\n  <path d=\"M13 20h5a2 2 0 0 0 2 -2v-5\" />\n  <path d=\"M15 22l-2 -2l2 -2\" />\n  <path d=\"M18 15l2 -2l2 2\" />"),
    FILE_PENCIL(
        "file-pencil",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 18l5 -5a1.414 1.414 0 0 0 -2 -2l-5 5v2h2\" />"),
    FILE_PERCENT(
        "file-percent",
        "<path d=\"M10 17l4 -4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 13h.01\" />\n  <path d=\"M14 17h.01\" />"),
    FILE_PHONE(
        "file-phone",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 12a.5 .5 0 0 0 1 0v-1a.5 .5 0 0 0 -1 0v1a5 5 0 0 0 5 5h1a.5 .5 0 0 0 0 -1h-1a.5 .5 0 0 0 0 1\" />"),
    FILE_PLUS(
        "file-plus",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 11l0 6\" />\n  <path d=\"M9 14l6 0\" />"),
    FILE_POWER(
        "file-power",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 11l-2 3h4l-2 3\" />"),
    FILE_REPORT(
        "file-report",
        "<path d=\"M13 17a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M17 13v4h4\" />\n  <path d=\"M12 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M11.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v2m0 3v4\" />"),
    FILE_RSS(
        "file-rss",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 17a3 3 0 0 0 -3 -3\" />\n  <path d=\"M15 17a6 6 0 0 0 -6 -6\" />\n  <path d=\"M9 17h.01\" />"),
    FILE_SAD(
        "file-sad",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2m-7 -7h.01m3.99 0h.01\" />\n  <path d=\"M10 18a3.5 3.5 0 0 1 4 0\" />"),
    FILE_SCISSORS(
        "file-scissors",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M14 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M8 17a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9 17l6 -6\" />\n  <path d=\"M15 17l-6 -6\" />"),
    FILE_SEARCH(
        "file-search",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v4.5\" />\n  <path d=\"M14 17.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M18.5 19.5l2.5 2.5\" />"),
    FILE_SETTINGS(
        "file-settings",
        "<path d=\"M10 14a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M12 10.5v1.5\" />\n  <path d=\"M12 16v1.5\" />\n  <path d=\"M15.031 12.25l-1.299 .75\" />\n  <path d=\"M10.268 15l-1.3 .75\" />\n  <path d=\"M15 15.803l-1.285 -.773\" />\n  <path d=\"M10.285 12.97l-1.285 -.773\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />"),
    FILE_SHREDDER(
        "file-shredder",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M3 12l18 0\" />\n  <path d=\"M6 16l0 2\" />\n  <path d=\"M10 16l0 6\" />\n  <path d=\"M14 16l0 2\" />\n  <path d=\"M18 16l0 4\" />"),
    FILE_SIGNAL(
        "file-signal",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 14v.01\" />\n  <path d=\"M9.525 11.525a3.5 3.5 0 0 0 0 4.95m4.95 0a3.5 3.5 0 0 0 0 -4.95\" />"),
    FILE_SMILE(
        "file-smile",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2m-7 -7h.01m3.99 0h.01\" />\n  <path d=\"M10 17a3.5 3.5 0 0 0 4 0\" />"),
    FILE_SPARK(
        "file-spark",
        "<path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v3.5\" />"),
    FILE_SPREADSHEET(
        "file-spreadsheet",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M8 11h8v7h-8l0 -7\" />\n  <path d=\"M8 15h8\" />\n  <path d=\"M11 11v7\" />"),
    FILE_STACK(
        "file-stack",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M5 21h14\" />\n  <path d=\"M5 18h14\" />\n  <path d=\"M5 15h14\" />"),
    FILE_STAR(
        "file-star",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M11.8 16.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    FILE_SYMLINK(
        "file-symlink",
        "<path d=\"M4 21v-4a3 3 0 0 1 3 -3h5\" />\n  <path d=\"M9 17l3 -3l-3 -3\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 11v-6a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-9.5\" />"),
    FILE_TEXT(
        "file-text",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 9l1 0\" />\n  <path d=\"M9 13l6 0\" />\n  <path d=\"M9 17l6 0\" />"),
    FILE_TEXT_AI(
        "file-text-ai",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M10 21h-3a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v3.5\" />\n  <path d=\"M9 9h1\" />\n  <path d=\"M9 13h2.5\" />\n  <path d=\"M9 17h1\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    FILE_TEXT_SHIELD(
        "file-text-shield",
        "<path d=\"M13 3v4a.997 .997 0 0 0 1 1h4\" />\n  <path d=\"M11 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v3.5\" />\n  <path d=\"M8 9h1\" />\n  <path d=\"M8 12.994l3 0\" />\n  <path d=\"M8 16.997l2 0\" />\n  <path d=\"M21 15.994c0 4 -2.5 6 -3.5 6s-3.5 -2 -3.5 -6c1 0 2.5 -.5 3.5 -1.5c1 1 2.5 1.5 3.5 1.5\" />"),
    FILE_TEXT_SPARK(
        "file-text-spark",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M12 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v3.5\" />\n  <path d=\"M9 9h1\" />\n  <path d=\"M9 13h6\" />\n  <path d=\"M9 17h3\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    FILE_TIME(
        "file-time",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M8 14a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M12 12.496v1.504l1 1\" />"),
    FILE_TYPE_BMP(
        "file-type-bmp",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M18 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M4 21h1.5a1.5 1.5 0 0 0 0 -3h-1.5h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M10 21v-6l2.5 3l2.5 -3v6\" />"),
    FILE_TYPE_CSS(
        "file-type-css",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M8 16.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M11 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M17 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />"),
    FILE_TYPE_CSV(
        "file-type-csv",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M7 16.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M10 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M16 15l2 6l2 -6\" />"),
    FILE_TYPE_DOC(
        "file-type-doc",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M5 15v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M20 16.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M12.5 15a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1 -3 0v-3a1.5 1.5 0 0 1 1.5 -1.5\" />"),
    FILE_TYPE_DOCX(
        "file-type-docx",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M2 15v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M17 16.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M9.5 15a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1 -3 0v-3a1.5 1.5 0 0 1 1.5 -1.5\" />\n  <path d=\"M19.5 15l3 6\" />\n  <path d=\"M19.5 21l3 -6\" />"),
    FILE_TYPE_HTML(
        "file-type-html",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M2 21v-6\" />\n  <path d=\"M5 15v6\" />\n  <path d=\"M2 18h3\" />\n  <path d=\"M20 15v6h2\" />\n  <path d=\"M13 21v-6l2 3l2 -3v6\" />\n  <path d=\"M7.5 15h3\" />\n  <path d=\"M9 15v6\" />"),
    FILE_TYPE_JPG(
        "file-type-jpg",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M11 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M20 15h-1a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h1v-3\" />\n  <path d=\"M5 15h3v4.5a1.5 1.5 0 0 1 -3 0\" />"),
    FILE_TYPE_JS(
        "file-type-js",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M3 15h3v4.5a1.5 1.5 0 0 1 -3 0\" />\n  <path d=\"M9 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-1\" />"),
    FILE_TYPE_JSX(
        "file-type-jsx",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4 15h3v4.5a1.5 1.5 0 0 1 -3 0\" />\n  <path d=\"M10 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M16 15l4 6\" />\n  <path d=\"M16 21l4 -6\" />"),
    FILE_TYPE_PDF(
        "file-type-pdf",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M5 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M17 18h2\" />\n  <path d=\"M20 15h-3v6\" />\n  <path d=\"M11 15v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />"),
    FILE_TYPE_PHP(
        "file-type-php",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M5 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M17 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M11 21v-6\" />\n  <path d=\"M14 15v6\" />\n  <path d=\"M11 18h3\" />"),
    FILE_TYPE_PNG(
        "file-type-png",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M20 15h-1a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h1v-3\" />\n  <path d=\"M5 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M11 21v-6l3 6v-6\" />"),
    FILE_TYPE_PPT(
        "file-type-ppt",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M11 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M16.5 15h3\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />"),
    FILE_TYPE_RS(
        "file-type-rs",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M3 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6m3 0l-2 -3\" />"),
    FILE_TYPE_SQL(
        "file-type-sql",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M18 15v6h2\" />\n  <path d=\"M13 15a2 2 0 0 1 2 2v2a2 2 0 1 1 -4 0v-2a2 2 0 0 1 2 -2\" />\n  <path d=\"M14 20l1.5 1.5\" />"),
    FILE_TYPE_SVG(
        "file-type-svg",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M10 15l2 6l2 -6\" />\n  <path d=\"M20 15h-1a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h1v-3\" />"),
    FILE_TYPE_TS(
        "file-type-ts",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M3.5 15h3\" />\n  <path d=\"M5 15v6\" />"),
    FILE_TYPE_TSX(
        "file-type-tsx",
        "<path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M16 15l4 6\" />\n  <path d=\"M16 21l4 -6\" />\n  <path d=\"M10 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M4.5 15h3\" />\n  <path d=\"M6 15v6\" />"),
    FILE_TYPE_TXT(
        "file-type-txt",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M16.5 15h3\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4.5 15h3\" />\n  <path d=\"M6 15v6\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M10 15l4 6\" />\n  <path d=\"M10 21l4 -6\" />"),
    FILE_TYPE_VUE(
        "file-type-vue",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4 15l2 6l2 -6\" />\n  <path d=\"M11 15v4.5a1.5 1.5 0 0 0 3 0v-4.5\" />\n  <path d=\"M20 15h-3v6h3\" />\n  <path d=\"M17 18h2\" />"),
    FILE_TYPE_XLS(
        "file-type-xls",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4 15l4 6\" />\n  <path d=\"M4 21l4 -6\" />\n  <path d=\"M17 20.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />\n  <path d=\"M11 15v6h3\" />"),
    FILE_TYPE_XML(
        "file-type-xml",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M4 15l4 6\" />\n  <path d=\"M4 21l4 -6\" />\n  <path d=\"M19 15v6h3\" />\n  <path d=\"M11 21v-6l2.5 3l2.5 -3v6\" />"),
    FILE_TYPE_ZIP(
        "file-type-zip",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M5 12v-7a2 2 0 0 1 2 -2h7l5 5v4\" />\n  <path d=\"M16 18h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6\" />\n  <path d=\"M12 15v6\" />\n  <path d=\"M5 15h3l-3 6h3\" />"),
    FILE_TYPOGRAPHY(
        "file-typography",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M11 18h2\" />\n  <path d=\"M12 18v-7\" />\n  <path d=\"M9 12v-1h6v1\" />"),
    FILE_UNKNOWN(
        "file-unknown",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M12 14a1.5 1.5 0 1 0 -1.14 -2.474\" />"),
    FILE_UPLOAD(
        "file-upload",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M12 11v6\" />\n  <path d=\"M9.5 13.5l2.5 -2.5l2.5 2.5\" />"),
    FILE_VECTOR(
        "file-vector",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M8 16.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M13 12.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9.5 15a2.5 2.5 0 0 1 2.5 -2.5h1\" />"),
    FILE_WORD(
        "file-word",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M9 12l1.333 5l1.667 -4l1.667 4l1.333 -5\" />"),
    FILE_X(
        "file-x",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 21h-10a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2\" />\n  <path d=\"M10 12l4 4m0 -4l-4 4\" />"),
    FILE_ZIP(
        "file-zip",
        "<path d=\"M6 20.735a2 2 0 0 1 -1 -1.735v-14a2 2 0 0 1 2 -2h7l5 5v11a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M11 17a2 2 0 0 1 2 2v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a2 2 0 0 1 2 -2\" />\n  <path d=\"M11 5l-1 0\" />\n  <path d=\"M13 7l-1 0\" />\n  <path d=\"M11 9l-1 0\" />\n  <path d=\"M13 11l-1 0\" />\n  <path d=\"M11 13l-1 0\" />\n  <path d=\"M13 15l-1 0\" />"),
    FILES(
        "files",
        "<path d=\"M15 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M18 17h-7a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h4l5 5v7a2 2 0 0 1 -2 2\" />\n  <path d=\"M16 17v2a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h2\" />"),
    FILES_OFF(
        "files-off",
        "<path d=\"M15 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M17 17h-6a2 2 0 0 1 -2 -2v-6m0 -4a2 2 0 0 1 2 -2h4l5 5v7c0 .294 -.063 .572 -.177 .823\" />\n  <path d=\"M16 17v2a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    FOLDER(
        "folder",
        "<path d=\"M5 4h4l3 3h7a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2\" />"),
    FOLDER_AI(
        "folder-ai",
        "<path d=\"M10 19h-5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    FOLDER_BOLT(
        "folder-bolt",
        "<path d=\"M13 19h-8a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    FOLDER_CANCEL(
        "folder-cancel",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    FOLDER_CHECK(
        "folder-check",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v4\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    FOLDER_CODE(
        "folder-code",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    FOLDER_COG(
        "folder-cog",
        "<path d=\"M12.5 19h-7.5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    FOLDER_DOLLAR(
        "folder-dollar",
        "<path d=\"M13.5 19h-8.5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v1.5\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    FOLDER_DOWN(
        "folder-down",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    FOLDER_EXCLAMATION(
        "folder-exclamation",
        "<path d=\"M15 19h-10a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    FOLDER_HEART(
        "folder-heart",
        "<path d=\"M10.5 19h-5.5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    FOLDER_LOCK(
        "folder-lock",
        "<path d=\"M13 19h-8a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 19a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1v-2\" />\n  <path d=\"M18 18v-1.5a1.5 1.5 0 1 1 3 0v1.5\" />"),
    FOLDER_MINUS(
        "folder-minus",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 19h6\" />"),
    FOLDER_OFF(
        "folder-off",
        "<path d=\"M8 4h1l3 3h7a2 2 0 0 1 2 2v8m-2 2h-14a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 1.189 -1.829\" />\n  <path d=\"M3 3l18 18\" />"),
    FOLDER_OPEN(
        "folder-open",
        "<path d=\"M5 19l2.757 -7.351a1 1 0 0 1 .936 -.649h12.307a1 1 0 0 1 .986 1.164l-.996 5.211a2 2 0 0 1 -1.964 1.625h-14.026a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2\" />"),
    FOLDER_PAUSE(
        "folder-pause",
        "<path d=\"M13 19h-8a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    FOLDER_PIN(
        "folder-pin",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    FOLDER_PLUS(
        "folder-plus",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    FOLDER_QUESTION(
        "folder-question",
        "<path d=\"M15 19h-10a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    FOLDER_ROOT(
        "folder-root",
        "<path d=\"M10 13a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M12 15v4\" />\n  <path d=\"M5 4h4l3 3h7a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2\" />"),
    FOLDER_SEARCH(
        "folder-search",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    FOLDER_SHARE(
        "folder-share",
        "<path d=\"M13 19h-8a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    FOLDER_SPARKLE(
        "folder-sparkle",
        "<path d=\"M11.5 19h-6.5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    FOLDER_STAR(
        "folder-star",
        "<path d=\"M10 19h-5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    FOLDER_STATS(
        "folder-stats",
        "<path d=\"M10.25 19h-5.25a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3\" />\n  <path d=\"M13 22l3 -3l2 2l4 -4\" />\n  <path d=\"M19 17h3v3\" />"),
    FOLDER_SYMLINK(
        "folder-symlink",
        "<path d=\"M3 21v-4a3 3 0 0 1 3 -3h5\" />\n  <path d=\"M8 17l3 -3l-3 -3\" />\n  <path d=\"M3 11v-5a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8\" />"),
    FOLDER_UP(
        "folder-up",
        "<path d=\"M12 19h-7a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    FOLDER_USER(
        "folder-user",
        "<path d=\"M12.75 19h-7.75a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M17 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M22 22a2 2 0 0 0 -2 -2h-2a2 2 0 0 0 -2 2\" />"),
    FOLDER_X(
        "folder-x",
        "<path d=\"M13.5 19h-8.5a2 2 0 0 1 -2 -2v-11a2 2 0 0 1 2 -2h4l3 3h7a2 2 0 0 1 2 2v4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    FOLDERS(
        "folders",
        "<path d=\"M9 3h3l2 2h5a2 2 0 0 1 2 2v7a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 16v2a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h2\" />"),
    FOLDERS_OFF(
        "folders-off",
        "<path d=\"M17 17h-8a2 2 0 0 1 -2 -2v-8m1.177 -2.823c.251 -.114 .53 -.177 .823 -.177h3l2 2h5a2 2 0 0 1 2 2v7c0 .55 -.223 1.05 -.583 1.411\" />\n  <path d=\"M17 17v2a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M3 3l18 18\" />"),
    INVOICE(
        "invoice",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M19 12v7a1.78 1.78 0 0 1 -3.1 1.4a1.65 1.65 0 0 0 -2.6 0a1.65 1.65 0 0 1 -2.6 0a1.65 1.65 0 0 0 -2.6 0a1.78 1.78 0 0 1 -3.1 -1.4v-14a2 2 0 0 1 2 -2h7l5 5v4.25\" />"),
    LICENSE(
        "license",
        "<path d=\"M15 21h-9a3 3 0 0 1 -3 -3v-1h10v2a2 2 0 0 0 4 0v-14a2 2 0 1 1 2 2h-2m2 -4h-11a3 3 0 0 0 -3 3v11\" />\n  <path d=\"M9 7l4 0\" />\n  <path d=\"M9 11l4 0\" />"),
    LICENSE_OFF(
        "license-off",
        "<path d=\"M15 21h-9a3 3 0 0 1 -3 -3v-1h10v2a2 2 0 1 0 4 0v-2m0 -4v-8a2 2 0 1 1 2 2h-2m2 -4h-11a3 3 0 0 0 -.864 .126m-2.014 2.025a3 3 0 0 0 -.122 .849v11\" />\n  <path d=\"M11 7h2\" />\n  <path d=\"M9 11h2\" />\n  <path d=\"M3 3l18 18\" />"),
    MANUAL_GEARBOX(
        "manual-gearbox",
        "<path d=\"M3 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M5 8l0 8\" />\n  <path d=\"M12 8l0 8\" />\n  <path d=\"M19 8v2a2 2 0 0 1 -2 2h-12\" />"),
    NEWS(
        "news",
        "<path d=\"M16 6h3a1 1 0 0 1 1 1v11a2 2 0 0 1 -4 0v-13a1 1 0 0 0 -1 -1h-10a1 1 0 0 0 -1 1v12a3 3 0 0 0 3 3h11\" />\n  <path d=\"M8 8l4 0\" />\n  <path d=\"M8 12l4 0\" />\n  <path d=\"M8 16l4 0\" />"),
    NEWS_OFF(
        "news-off",
        "<path d=\"M16 6h3a1 1 0 0 1 1 1v9m-.606 3.435a2 2 0 0 1 -3.394 -1.435v-2m0 -4v-7a1 1 0 0 0 -1 -1h-7m-3.735 .321a1 1 0 0 0 -.265 .679v12a3 3 0 0 0 3 3h11\" />\n  <path d=\"M8 12h4\" />\n  <path d=\"M8 16h4\" />\n  <path d=\"M3 3l18 18\" />"),
    NOTE(
        "note",
        "<path d=\"M13 20l7 -7\" />\n  <path d=\"M13 20v-6a1 1 0 0 1 1 -1h6v-7a2 2 0 0 0 -2 -2h-12a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h7\" />"),
    NOTE_OFF(
        "note-off",
        "<path d=\"M13 20l3.505 -3.505m2 -2l1.501 -1.501\" />\n  <path d=\"M17 13h3v-7a2 2 0 0 0 -2 -2h-10m-3.427 .6c-.355 .36 -.573 .853 -.573 1.4v12a2 2 0 0 0 2 2h7v-6c0 -.272 .109 -.519 .285 -.699\" />\n  <path d=\"M3 3l18 18\" />"),
    NOTEBOOK(
        "notebook",
        "<path d=\"M6 4h11a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-11a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1m3 0v18\" />\n  <path d=\"M13 8l2 0\" />\n  <path d=\"M13 12l2 0\" />"),
    NOTEBOOK_OFF(
        "notebook-off",
        "<path d=\"M8 4h9a2 2 0 0 1 2 2v9m-.179 3.828a2 2 0 0 1 -1.821 1.172h-11a1 1 0 0 1 -1 -1v-14m4 -1v1m0 4v13\" />\n  <path d=\"M13 8h2\" />\n  <path d=\"M3 3l18 18\" />"),
    NOTES(
        "notes",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M9 7l6 0\" />\n  <path d=\"M9 11l6 0\" />\n  <path d=\"M9 15l4 0\" />"),
    NOTES_OFF(
        "notes-off",
        "<path d=\"M7 3h10a2 2 0 0 1 2 2v10m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 7h4\" />\n  <path d=\"M9 11h2\" />\n  <path d=\"M9 15h4\" />\n  <path d=\"M3 3l18 18\" />"),
    PAGE_BREAK(
        "page-break",
        "<path d=\"M14 3v4a1 1 0 0 0 1 1h4\" />\n  <path d=\"M19 18v1a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-1\" />\n  <path d=\"M3 14h3m4.5 0h3m4.5 0h3\" />\n  <path d=\"M5 10v-5a2 2 0 0 1 2 -2h7l5 5v2\" />"),
    PAPERCLIP(
        "paperclip",
        "<path d=\"M15 7l-6.5 6.5a1.5 1.5 0 0 0 3 3l6.5 -6.5a3 3 0 0 0 -6 -6l-6.5 6.5a4.5 4.5 0 0 0 9 9l6.5 -6.5\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M3 4l18 0\" />\n  <path d=\"M4 4v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-10\" />\n  <path d=\"M12 16l0 4\" />\n  <path d=\"M9 20l6 0\" />\n  <path d=\"M8 12l3 -3l2 2l3 -3\" />"),
    PRESENTATION_ANALYTICS(
        "presentation-analytics",
        "<path d=\"M9 12v-4\" />\n  <path d=\"M15 12v-2\" />\n  <path d=\"M12 12v-1\" />\n  <path d=\"M3 4h18\" />\n  <path d=\"M4 4v10a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-10\" />\n  <path d=\"M12 16v4\" />\n  <path d=\"M9 20h6\" />"),
    PRESENTATION_OFF(
        "presentation-off",
        "<path d=\"M3 4h1m4 0h13\" />\n  <path d=\"M4 4v10a2 2 0 0 0 2 2h10m3.42 -.592c.359 -.362 .58 -.859 .58 -1.408v-10\" />\n  <path d=\"M12 16v4\" />\n  <path d=\"M9 20h6\" />\n  <path d=\"M8 12l2 -2m4 0l2 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    RECEIPT(
        "receipt",
        "<path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2m4 -14h6m-6 4h6m-2 4h2\" />"),
    RECEIPT_2(
        "receipt-2",
        "<path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2\" />\n  <path d=\"M14 8h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5m2 0v1.5m0 -9v1.5\" />"),
    RECEIPT_DOLLAR(
        "receipt-dollar",
        "<path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2\" />\n  <path d=\"M14.8 8a2 2 0 0 0 -1.8 -1h-2a2 2 0 1 0 0 4h2a2 2 0 1 1 0 4h-2a2 2 0 0 1 -1.8 -1\" />\n  <path d=\"M12 6v10\" />"),
    RECEIPT_OFF(
        "receipt-off",
        "<path d=\"M5 21v-16m2 -2h10a2 2 0 0 1 2 2v10m0 4.01v1.99l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2\" />\n  <path d=\"M11 7l4 0\" />\n  <path d=\"M9 11l2 0\" />\n  <path d=\"M13 15l2 0\" />\n  <path d=\"M15 11l0 .01\" />\n  <path d=\"M3 3l18 18\" />"),
    RECEIPT_REFUND(
        "receipt-refund",
        "<path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2\" />\n  <path d=\"M15 14v-2a2 2 0 0 0 -2 -2h-4l2 -2m0 4l-2 -2\" />"),
    RECEIPT_TAX(
        "receipt-tax",
        "<path d=\"M9 14l6 -6\" />\n  <path d=\"M9 8.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M14 13.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16l-3 -2l-2 2l-2 -2l-2 2l-2 -2l-3 2\" />"),
    REPORT(
        "report",
        "<path d=\"M8 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h5.697\" />\n  <path d=\"M18 14v4h4\" />\n  <path d=\"M18 11v-4a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M8 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M14 18a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M8 11h4\" />\n  <path d=\"M8 15h3\" />"),
    REPORT_ANALYTICS(
        "report-analytics",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M9 17v-5\" />\n  <path d=\"M12 17v-1\" />\n  <path d=\"M15 17v-3\" />"),
    REPORT_MEDICAL(
        "report-medical",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 14l4 0\" />\n  <path d=\"M12 12l0 4\" />"),
    REPORT_MONEY(
        "report-money",
        "<path d=\"M9 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M14 11h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M12 17v1m0 -8v1\" />"),
    REPORT_OFF(
        "report-off",
        "<path d=\"M5.576 5.595a2 2 0 0 0 -.576 1.405v12a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2m0 -4v-8a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M9 5a2 2 0 0 1 2 -2h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M3 3l18 18\" />"),
    REPORT_SEARCH(
        "report-search",
        "<path d=\"M8 5h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h5.697\" />\n  <path d=\"M18 12v-5a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M8 5a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M8 11h4\" />\n  <path d=\"M8 15h3\" />\n  <path d=\"M14 17.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M18.5 19.5l2.5 2.5\" />"),
    RUBBER_STAMP(
        "rubber-stamp",
        "<path d=\"M21 17.85h-18c0 -4.05 1.421 -4.05 3.79 -4.05c5.21 0 1.21 -4.59 1.21 -6.8a4 4 0 1 1 8 0c0 2.21 -4 6.8 1.21 6.8c2.369 0 3.79 0 3.79 4.05\" />\n  <path d=\"M5 21h14\" />"),
    RUBBER_STAMP_OFF(
        "rubber-stamp-off",
        "<path d=\"M8.273 8.273c.805 2.341 2.857 5.527 -1.484 5.527c-2.368 0 -3.789 0 -3.789 4.05h14.85\" />\n  <path d=\"M5 21h14\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M8.712 4.722a3.99 3.99 0 0 1 3.288 -1.722a4 4 0 0 1 4 4c0 .992 -.806 2.464 -1.223 3.785m6.198 6.196c-.182 -2.883 -1.332 -3.153 -3.172 -3.178\" />"),
    SCRIPT(
        "script",
        "<path d=\"M17 20h-11a3 3 0 0 1 0 -6h11a3 3 0 0 0 0 6h1a3 3 0 0 0 3 -3v-11a2 2 0 0 0 -2 -2h-10a2 2 0 0 0 -2 2v8\" />"),
    SCRIPT_MINUS(
        "script-minus",
        "<path d=\"M17 19h4\" />\n  <path d=\"M14 20h-8a3 3 0 0 1 0 -6h11a3 3 0 0 0 -3 3m7 -2v-9a2 2 0 0 0 -2 -2h-10a2 2 0 0 0 -2 2v8\" />"),
    SCRIPT_PLUS(
        "script-plus",
        "<path d=\"M17 19h4\" />\n  <path d=\"M14 20h-8a3 3 0 0 1 0 -6h11a3 3 0 0 0 -3 3m7 -3v-8a2 2 0 0 0 -2 -2h-10a2 2 0 0 0 -2 2v8\" />\n  <path d=\"M19 17v4\" />"),
    SCRIPT_X(
        "script-x",
        "<path d=\"M14 20h-8a3 3 0 0 1 0 -6h11a3 3 0 0 0 -3 3m7 -3v-8a2 2 0 0 0 -2 -2h-10a2 2 0 0 0 -2 2v8\" />\n  <path d=\"M17 17l4 4m0 -4l-4 4\" />"),
    SPACING_HORIZONTAL(
        "spacing-horizontal",
        "<path d=\"M20 20h-2a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 20h2a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M12 8v8\" />"),
    SPACING_VERTICAL(
        "spacing-vertical",
        "<path d=\"M4 20v-2a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v2\" />\n  <path d=\"M4 4v2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M16 12h-8\" />"),
    TICKET(
        "ticket",
        "<path d=\"M15 5l0 2\" />\n  <path d=\"M15 11l0 2\" />\n  <path d=\"M15 17l0 2\" />\n  <path d=\"M5 5h14a2 2 0 0 1 2 2v3a2 2 0 0 0 0 4v3a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-3a2 2 0 0 0 0 -4v-3a2 2 0 0 1 2 -2\" />"),
    TICKET_OFF(
        "ticket-off",
        "<path d=\"M15 5v2\" />\n  <path d=\"M15 17v2\" />\n  <path d=\"M9 5h10a2 2 0 0 1 2 2v3a2 2 0 1 0 0 4v3m-2 2h-14a2 2 0 0 1 -2 -2v-3a2 2 0 1 0 0 -4v-3a2 2 0 0 1 2 -2\" />\n  <path d=\"M3 3l18 18\" />");

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
    ARCHIVE(
        "archive",
        "<path d=\"M2 5a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2z\" />\n  <path d=\"M19 9c.513 0 .936 .463 .993 1.06l.007 .14v7.2c0 1.917 -1.249 3.484 -2.824 3.594l-.176 .006h-10c-1.598 0 -2.904 -1.499 -2.995 -3.388l-.005 -.212v-7.2c0 -.663 .448 -1.2 1 -1.2h14zm-5 2h-4l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h4l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    ARTICLE(
        "article",
        "<path d=\"M19 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h14zm-2 12h-10l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h10l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm0 -4h-10l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h10l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm0 -4h-10l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h10l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    BOOK(
        "book",
        "<path d=\"M21.5 5.134a1 1 0 0 1 .493 .748l.007 .118v13a1 1 0 0 1 -1.5 .866a8 8 0 0 0 -7.5 -.266v-15.174a10 10 0 0 1 8.5 .708m-10.5 -.707l.001 15.174a8 8 0 0 0 -7.234 .117l-.327 .18l-.103 .044l-.049 .016l-.11 .026l-.061 .01l-.117 .006h-.042l-.11 -.012l-.077 -.014l-.108 -.032l-.126 -.056l-.095 -.056l-.089 -.067l-.06 -.056l-.073 -.082l-.064 -.089l-.022 -.036l-.032 -.06l-.044 -.103l-.016 -.049l-.026 -.11l-.01 -.061l-.004 -.049l-.002 -13.068a1 1 0 0 1 .5 -.866a10 10 0 0 1 8.5 -.707\" />"),
    BOOKMARK(
        "bookmark",
        "<path d=\"M14 2a5 5 0 0 1 5 5v14a1 1 0 0 1 -1.555 .832l-5.445 -3.63l-5.444 3.63a1 1 0 0 1 -1.55 -.72l-.006 -.112v-14a5 5 0 0 1 5 -5h4z\" />"),
    BOOKMARKS(
        "bookmarks",
        "<path d=\"M12 6a4 4 0 0 1 4 4v11a1 1 0 0 1 -1.514 .857l-4.486 -2.691l-4.486 2.691a1 1 0 0 1 -1.508 -.743l-.006 -.114v-11a4 4 0 0 1 4 -4h4z\" />\n  <path d=\"M16 2a4 4 0 0 1 4 4v11a1 1 0 0 1 -2 0v-11a2 2 0 0 0 -2 -2h-5a1 1 0 0 1 0 -2h5z\" />"),
    CLIPBOARD(
        "clipboard",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-3.997 -2.17a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_CHECK(
        "clipboard-check",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-3.704 7.123l-3.293 3.292l-1.293 -1.292a1 1 0 1 0 -1.414 1.414l2 2a1 1 0 0 0 1.414 0l4 -4a1 1 0 0 0 -1.414 -1.414m-.293 -9.293a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_DATA(
        "clipboard-data",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-8.997 7.83a1 1 0 0 0 -1 1v4a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m3 3a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1a1 1 0 0 0 -1 -1m3 -1a1 1 0 0 0 -1 1v2a1 1 0 0 0 2 0v-2a1 1 0 0 0 -1 -1m-1 -12a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_LIST(
        "clipboard-list",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-8.987 10.83h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m5.99 0h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2m-5.99 -4h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m5.99 0h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2m-1 -9a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_PLUS(
        "clipboard-plus",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-5.997 6.83a1 1 0 0 0 -1 1v1h-1a1 1 0 0 0 0 2h1v1a1 1 0 0 0 2 0v-1h1a1 1 0 0 0 0 -2h-1v-1a1 1 0 0 0 -1 -1m2 -9a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_SMILE(
        "clipboard-smile",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-3.176 11.259a1 1 0 0 0 -1.392 -.25a2.5 2.5 0 0 1 -2.858 0a1 1 0 0 0 -1.142 1.642a4.5 4.5 0 0 0 5.142 0a1 1 0 0 0 .25 -1.392m-4.811 -3.429h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m-.01 -10a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_TEXT(
        "clipboard-text",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-2.997 10.83h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m0 -4h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m-1 -9a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_TYPOGRAPHY(
        "clipboard-typography",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-2.997 5.83h-6a1 1 0 0 0 -1 1v1a1 1 0 0 0 2 0h1v4a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2v-4h1a1 1 0 0 0 2 0v-1a1 1 0 0 0 -1 -1m-1 -8a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    CLIPBOARD_X(
        "clipboard-x",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-7.29 7.123a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l1.292 1.293l-1.292 1.293a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l1.293 -1.293l1.293 1.293a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-1.293 -1.293l1.293 -1.293a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-1.293 1.292zm3.293 -9.293a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    FILE(
        "file",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h5z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_ANALYTICS(
        "file-analytics",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-3 10a1 1 0 0 0 -1 1v5a1 1 0 0 0 2 0v-5a1 1 0 0 0 -1 -1m3 4a1 1 0 0 0 -1 1v1a1 1 0 0 0 2 0v-1a1 1 0 0 0 -1 -1m3 -2a1 1 0 0 0 -1 1v3a1 1 0 0 0 2 0v-3a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_CHECK(
        "file-check",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm3.707 10.293a1 1 0 0 0 -1.414 0l-3.293 3.292l-1.293 -1.292a1 1 0 1 0 -1.414 1.414l2 2a1 1 0 0 0 1.414 0l4 -4a1 1 0 0 0 0 -1.414m-.707 -9.294l4 4.001h-4z\" />"),
    FILE_CODE(
        "file-code",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-1.553 11.106a1 1 0 0 0 -1.341 .447l-1 2a1 1 0 0 0 0 .894l1 2a1 1 0 0 0 1.341 .447l.102 -.058a1 1 0 0 0 .345 -1.283l-.776 -1.553l.776 -1.553a1 1 0 0 0 -.447 -1.341m4.447 .447a1 1 0 0 0 -1.341 -.447l-.102 .058a1 1 0 0 0 -.345 1.283l.774 1.553l-.775 1.553a1 1 0 0 0 1.788 .894l1 -2a1 1 0 0 0 0 -.894z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_CODE_2(
        "file-code-2",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-2 9h-1a1 1 0 0 0 -1 1v5a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007v-3a1 1 0 0 0 0 -2m5 0h-1a1 1 0 0 0 0 2v3a1 1 0 0 0 0 2h1a1 1 0 0 0 1 -1v-5a1 1 0 0 0 -1 -1m-.001 -8.001l4.001 4.001h-4z\" />"),
    FILE_CV(
        "file-cv",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-2.5 8a2.5 2.5 0 0 0 -2.5 2.5v3a2.5 2.5 0 1 0 5 0a1 1 0 0 0 -2 0a.5 .5 0 1 1 -1 0v-3a.5 .5 0 1 1 1 0a1 1 0 0 0 2 0a2.5 2.5 0 0 0 -2.5 -2.5m6.743 .03a1 1 0 0 0 -1.213 .727l-.53 2.119l-.53 -2.119a1 1 0 1 0 -1.94 .486l1.5 6c.252 1.01 1.688 1.01 1.94 0l1.5 -6a1 1 0 0 0 -.727 -1.213m-1.244 -7.031l4.001 4.001h-4z\" />"),
    FILE_DELTA(
        "file-delta",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm.894 8.553a1 1 0 0 0 -1.788 0l-3 6a1 1 0 0 0 .894 1.447h6a1 1 0 0 0 .894 -1.447zm-.894 2.683l1.381 2.764h-2.763zm2.999 -10.237l4.001 4.001h-4z\" />"),
    FILE_DESCRIPTION(
        "file-description",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm3 14h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m0 -4h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_DIFF(
        "file-diff",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2 15h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m-2 -7a1 1 0 0 0 -1 1v1h-1a1 1 0 0 0 0 2h1v1a1 1 0 0 0 2 0v-1h1a1 1 0 0 0 0 -2h-1v-1a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_DIGIT(
        "file-digit",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-1 9h-1a2 2 0 0 0 -2 2v3a2 2 0 0 0 2 2h1a2 2 0 0 0 2 -2v-3a2 2 0 0 0 -2 -2m4 0a1 1 0 0 0 -1 1v5a1 1 0 0 0 2 0v-5a1 1 0 0 0 -1 -1m-4 2v3h-1v-3z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_DOLLAR(
        "file-dollar",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 8a1 1 0 0 0 -1 1v.05a2.5 2.5 0 0 0 .5 4.95h1a.5 .5 0 1 1 0 1h-2.5a1 1 0 0 0 0 2h1a1 1 0 0 0 2 0v-.05a2.5 2.5 0 0 0 -.5 -4.95h-1a.5 .5 0 1 1 0 -1h2.5a1 1 0 0 0 0 -2h-1a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_DOTS(
        "file-dots",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-3 12a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1m3 0a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1m3 0a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_DOWNLOAD(
        "file-download",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 8a1 1 0 0 0 -1 1v3.585l-.793 -.792a1 1 0 0 0 -1.32 -.083l-.094 .083a1 1 0 0 0 0 1.414l2.5 2.5l.044 .042l.068 .055l.11 .071l.114 .054l.105 .035l.15 .03l.116 .006l.117 -.007l.117 -.02l.108 -.033l.081 -.034l.098 -.052l.092 -.064l.094 -.083l2.5 -2.5a1 1 0 0 0 0 -1.414l-.094 -.083a1 1 0 0 0 -1.32 .083l-.793 .791v-3.584a1 1 0 0 0 -.883 -.993zm2.999 -7.001l4.001 4.001h-4z\" />"),
    FILE_EURO(
        "file-euro",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2.334 9.23a4 4 0 0 0 -5.208 2.77h-.126a1 1 0 0 0 0 2h.126a4 4 0 0 0 5.208 2.77a1 1 0 0 0 -.668 -1.885l-.156 .049a2 2 0 0 1 -2.243 -.934h.733a1 1 0 0 0 0 -2h-.733q .056 -.097 .124 -.19a2 2 0 0 1 2.275 -.695l.112 .032a1 1 0 0 0 .556 -1.918\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_FUNCTION(
        "file-function",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm1.5 9h-.333l-.16 .006c-.895 .07 -1.65 .732 -1.75 1.63l-.152 1.364h-.605a1 1 0 0 0 0 2h.382l-.111 1h-.271a1 1 0 0 0 0 2h.333l.16 -.006c.896 -.071 1.652 -.733 1.75 -1.632l.151 -1.362h.606a1 1 0 0 0 0 -2h-.383l.111 -1h.272a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_HORIZONTAL(
        "file-horizontal",
        "<path d=\"M22 12l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007h-4l-.15 -.005a2 2 0 0 1 -1.844 -1.838l-.006 -.157v-4l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007h-9a3 3 0 0 0 -2.995 2.824l-.005 .176v10a3 3 0 0 0 2.824 2.995l.176 .005h14a3 3 0 0 0 2.995 -2.824l.005 -.176z\" />\n  <path d=\"M17 5v4l4.001 .001z\" />"),
    FILE_INFO(
        "file-info",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 12h-1a1 1 0 0 0 0 2v3a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1l-.007 -.117a1 1 0 0 0 -.876 -.876l-.117 -.007v-3a1 1 0 0 0 -1 -1m.01 -3h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_INVOICE(
        "file-invoice",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm4 15h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2m0 -4h-8a1 1 0 0 0 0 2h8a1 1 0 0 0 0 -2m-7 -7h-1a1 1 0 1 0 0 2h1a1 1 0 1 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_LAMBDA(
        "file-lambda",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-2 8a1 1 0 0 0 -.117 1.993l.117 .007c.342 0 .662 .362 1.166 1.445l-1.998 3a1 1 0 0 0 1.664 1.11l1.29 -1.934c.825 1.738 1.508 2.379 2.878 2.379a1 1 0 0 0 .117 -1.993l-.117 -.007c-.39 0 -.75 -.47 -1.387 -1.938l-.415 -.976c-.985 -2.274 -1.656 -3.086 -3.198 -3.086m4.999 -7.001l4.001 4.001h-4z\" />"),
    FILE_MINUS(
        "file-minus",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm3 11h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_MUSIC(
        "file-music",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm.447 9.106a1 1 0 0 0 -1.447 .894v3a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 4 0v-3.382l.553 .276a1 1 0 0 0 .894 -1.788z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_NEUTRAL(
        "file-neutral",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2 14h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m-3.995 -4h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_PENCIL(
        "file-pencil",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm1 10l-5 5v2h2l5 -5a1.414 1.414 0 0 0 -2 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_PERCENT(
        "file-percent",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2.01 14h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m.697 -3.707a1 1 0 0 0 -1.414 0l-4 4a1 1 0 0 0 1.414 1.414l4 -4a1 1 0 0 0 0 -1.414m-4.697 -.293h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m4.989 -9.001l4.001 4.001h-4z\" />"),
    FILE_PHONE(
        "file-phone",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-2.5 7.5a1.5 1.5 0 0 0 -1.5 1.5v1a6 6 0 0 0 6 6h1a1.5 1.5 0 0 0 0 -3h-1l-.144 .007a1.5 1.5 0 0 0 -1.128 .697l-.042 .074l-.022 -.007a4.01 4.01 0 0 1 -2.435 -2.435l-.008 -.023l.075 -.041a1.5 1.5 0 0 0 .704 -1.272v-1a1.5 1.5 0 0 0 -1.5 -1.5m5.499 -6.501l4.001 4.001h-4z\" />"),
    FILE_POWER(
        "file-power",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm.555 9.168a1 1 0 0 0 -1.387 .277l-2 3l-.057 .097a1 1 0 0 0 .889 1.458h2.13l-.962 1.445a1 1 0 1 0 1.664 1.11l2 -3l.057 -.097a1 1 0 0 0 -.889 -1.458h-2.132l.964 -1.445a1 1 0 0 0 -.277 -1.387\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_RSS(
        "file-rss",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-3 11a1 1 0 0 0 0 2a2 2 0 0 1 1.995 1.85l.005 .15a1 1 0 0 0 2 0a4 4 0 0 0 -4 -4m0 -3a1 1 0 0 0 0 2a5 5 0 0 1 5 5a1 1 0 0 0 2 0a7 7 0 0 0 -7 -7m.01 6h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m5.989 -13.001l4.001 4.001h-4z\" />"),
    FILE_SAD(
        "file-sad",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2.571 15.18a4.5 4.5 0 0 0 -5.142 0a1 1 0 1 0 1.142 1.64a2.5 2.5 0 0 1 2.858 0a1 1 0 0 0 1.142 -1.64m-4.565 -5.18h-.011a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m4 0h-.011a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_SCISSORS(
        "file-scissors",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-2.293 9.293a1 1 0 1 0 -1.414 1.414l2.292 2.293l-1.068 1.067a2.003 2.003 0 0 0 -2.512 1.784l-.005 .149a2 2 0 1 0 3.933 -.516l1.067 -1.069l1.067 1.068a2 2 0 0 0 -.062 .368l-.005 .149a2 2 0 1 0 1.484 -1.933l-1.069 -1.067l2.292 -2.293a1 1 0 0 0 -1.414 -1.414l-2.293 2.292z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_SETTINGS(
        "file-settings",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 8.5a1 1 0 0 0 -1 1v.67a3 3 0 0 0 -.909 .516l-.576 -.346a1 1 0 0 0 -1.03 1.714l.575 .346q -.043 .207 -.055 .424l-.005 .176q 0 .28 .05 .548l-.582 .336a1 1 0 0 0 1 1.732l.583 -.336c.277 .238 .598 .425 .95 .55l-.001 .67a1 1 0 0 0 2 0v-.671c.335 -.118 .641 -.294 .909 -.514l.576 .345a1 1 0 0 0 1.03 -1.714l-.575 -.346a3 3 0 0 0 .01 -1.148l.581 -.336a1 1 0 0 0 -1 -1.732l-.582 .335a3 3 0 0 0 -.948 -.548l-.001 -.671a1 1 0 0 0 -1 -1m0 3.5a1 1 0 1 1 0 2a1 1 0 0 1 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_SIGNAL(
        "file-signal",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-1.768 9.818a1 1 0 0 0 -1.414 0a4.5 4.5 0 0 0 0 6.364a1 1 0 0 0 1.414 -1.414a2.5 2.5 0 0 1 0 -3.536a1 1 0 0 0 0 -1.414m4.95 0a1 1 0 0 0 -1.414 1.414a2.5 2.5 0 0 1 0 3.536a1 1 0 0 0 1.414 1.414a4.5 4.5 0 0 0 0 -6.364m-3.182 2.182a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_SMILE(
        "file-smile",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2.82 14.429a1 1 0 0 0 -1.391 -.25a2.5 2.5 0 0 1 -2.858 0a1 1 0 0 0 -1.142 1.642a4.5 4.5 0 0 0 5.142 0a1 1 0 0 0 .25 -1.392m-4.815 -4.429h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 0 2h.01a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_STAR(
        "file-star",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm-.2 9a.39 .39 0 0 0 -.351 .217l-1.086 2.193l-2.428 .352a.389 .389 0 0 0 -.217 .665l1.757 1.707l-.415 2.411a.392 .392 0 0 0 .568 .41l2.172 -1.138l2.172 1.138a.39 .39 0 0 0 .567 -.411l-.414 -2.41l1.757 -1.707a.39 .39 0 0 0 -.217 -.665l-2.428 -.352l-1.086 -2.193a.39 .39 0 0 0 -.351 -.217\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_TEXT(
        "file-text",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm3 14h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m0 -4h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m-5 -4h-1a1 1 0 1 0 0 2h1a1 1 0 0 0 0 -2\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_TIME(
        "file-time",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 8a5 5 0 0 0 -4.995 4.783l-.005 .217a5 5 0 1 0 5 -5m0 2a3 3 0 1 1 0 6a3 3 0 0 1 0 -6m0 .496a1 1 0 0 0 -1 1v1.504a1 1 0 0 0 .293 .707l1 1a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-.707 -.708v-1.089a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_TYPOGRAPHY(
        "file-typography",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm3 9h-6a1 1 0 0 0 -1 1v1a1 1 0 0 0 2 0h1v5a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2v-5h1a1 1 0 0 0 2 0v-1a1 1 0 0 0 -1 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_UNKNOWN(
        "file-unknown",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 15a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1m1.136 -5.727a2.5 2.5 0 0 0 -3.037 .604a1 1 0 0 0 1.434 1.389l.088 -.09a.5 .5 0 1 1 .379 .824a1 1 0 0 0 -.002 2a2.5 2.5 0 0 0 1.137 -4.727\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_UPLOAD(
        "file-upload",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm0 9l-.09 .004l-.058 .007l-.118 .025l-.105 .035l-.113 .054l-.111 .071a1 1 0 0 0 -.112 .097l-2.5 2.5a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l.793 -.793v3.586a1 1 0 0 0 2 0v-3.585l.793 .792a1 1 0 0 0 1.414 -1.414l-2.5 -2.5l-.082 -.073l-.104 -.074l-.098 -.052l-.11 -.044l-.112 -.03l-.126 -.017z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_VECTOR(
        "file-vector",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005zm2.5 9a2.5 2.5 0 0 0 -2.292 1.5h-.208a3.5 3.5 0 0 0 -3.399 2.666a2.5 2.5 0 0 0 -1.596 2.17l-.005 .164a2.5 2.5 0 1 0 3.676 -2.206a1.5 1.5 0 0 1 1.324 -.794h.208a2.5 2.5 0 1 0 2.292 -3.5m-5 6a.5 .5 0 1 1 0 1a.5 .5 0 0 1 0 -1m5 -4a.5 .5 0 1 1 0 1a.5 .5 0 0 1 0 -1\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILE_X(
        "file-x",
        "<path d=\"M12 2l.117 .007a1 1 0 0 1 .876 .876l.007 .117v4l.005 .15a2 2 0 0 0 1.838 1.844l.157 .006h4l.117 .007a1 1 0 0 1 .876 .876l.007 .117v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-10a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h5zm-1.489 9.14a1 1 0 0 0 -1.301 1.473l.083 .094l1.292 1.293l-1.292 1.293l-.083 .094a1 1 0 0 0 1.403 1.403l.094 -.083l1.293 -1.292l1.293 1.292l.094 .083a1 1 0 0 0 1.403 -1.403l-.083 -.094l-1.292 -1.293l1.292 -1.293l.083 -.094a1 1 0 0 0 -1.403 -1.403l-.094 .083l-1.293 1.292l-1.293 -1.292l-.094 -.083l-.102 -.07z\" />\n  <path d=\"M19 7h-4l-.001 -4.001z\" />"),
    FILES(
        "files",
        "<path d=\"M11 2l3 .001v5.999a1 1 0 0 0 .883 .993l.117 .007h6v6a3 3 0 0 1 -3 3h-1v1a3 3 0 0 1 -3 3h-7a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3h1v-1a3 3 0 0 1 3 -3m-3 6h-1a1 1 0 0 0 -1 1v10a1 1 0 0 0 1 1h7a1 1 0 0 0 1 -1v-1h-4a3 3 0 0 1 -3 -3zm12.415 -1h-4.415v-4.415z\" />"),
    FOLDER(
        "folder",
        "<path d=\"M9 3a1 1 0 0 1 .608 .206l.1 .087l2.706 2.707h6.586a3 3 0 0 1 2.995 2.824l.005 .176v8a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-11a3 3 0 0 1 2.824 -2.995l.176 -.005h4z\" />"),
    FOLDER_OPEN(
        "folder-open",
        "<path d=\"M2 6c0 -.796 .316 -1.558 .879 -2.121c.563 -.563 1.325 -.879 2.121 -.879h4l.099 .005c.229 .023 .444 .124 .608 .288l2.707 2.707h6.586c.796 0 1.558 .316 2.121 .879c.319 .319 .559 .703 .707 1.121l-14.523 0c-.407 0 -.805 .125 -1.14 .356c-.292 .203 -.525 .48 -.674 .801l-.058 .141l-1.379 3.676c-.194 .517 .068 1.093 .585 1.287c.517 .194 1.094 -.068 1.288 -.585l1.134 -3.027c.146 -.39 .519 -.649 .937 -.649h13.002l.217 .012c.216 .024 .426 .082 .624 .173c.054 .025 .107 .053 .159 .083c.199 .115 .377 .263 .525 .439c.188 .222 .325 .482 .403 .762c.077 .28 .092 .573 .045 .859c-.001 .008 -.003 .016 -.005 .024l-.995 5.21c-.131 .686 -.497 1.304 -1.036 1.749c-.47 .389 -1.046 .624 -1.65 .677l-.261 .012h-14.026c-.796 0 -1.558 -.316 -2.121 -.879c-.563 -.563 -.879 -1.325 -.879 -2.121v-11z\" />"),
    FOLDERS(
        "folders",
        "<path d=\"M12 2a1 1 0 0 1 .707 .293l1.708 1.707h4.585a3 3 0 0 1 2.995 2.824l.005 .176v7a3 3 0 0 1 -3 3h-1v1a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3h1v-1a3 3 0 0 1 3 -3zm-6 6h-1a1 1 0 0 0 -1 1v9a1 1 0 0 0 1 1h10a1 1 0 0 0 1 -1v-1h-7a3 3 0 0 1 -3 -3z\" />"),
    MANUAL_GEARBOX(
        "manual-gearbox",
        "<path d=\"M19 3a3 3 0 0 1 1 5.829v1.171a3 3 0 0 1 -3 3h-4v2.171a3.001 3.001 0 1 1 -4 2.829l.005 -.176a3 3 0 0 1 1.995 -2.654v-2.17h-5v2.171a3.001 3.001 0 1 1 -4 2.829l.005 -.176a3 3 0 0 1 1.995 -2.654v-6.341a3 3 0 0 1 -2 -2.829l.005 -.176a3 3 0 1 1 3.996 3.005l-.001 2.171h5v-2.17a3 3 0 0 1 -2 -2.83l.005 -.176a3 3 0 1 1 3.996 3.005l-.001 2.171h4a1 1 0 0 0 1 -1v-1.17a3 3 0 0 1 -2 -2.83l.005 -.176a3 3 0 0 1 2.995 -2.824\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M21 3a1 1 0 0 1 0 2v9a3 3 0 0 1 -3 3h-5v2h2a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2h2v-2h-5a3 3 0 0 1 -3 -3v-9a1 1 0 1 1 0 -2zm-4.293 4.293a1 1 0 0 0 -1.414 0l-2.293 2.292l-1.293 -1.292a1 1 0 0 0 -1.414 0l-3 3a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l2.293 -2.292l1.293 1.292a1 1 0 0 0 1.414 0l3 -3a1 1 0 0 0 0 -1.414\" />"),
    PRESENTATION_ANALYTICS(
        "presentation-analytics",
        "<path d=\"M21 3a1 1 0 0 1 0 2v9a3 3 0 0 1 -3 3h-5v2h2a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2h2v-2h-5a3 3 0 0 1 -3 -3v-9a1 1 0 1 1 0 -2zm-12 4a1 1 0 0 0 -1 1v4a1 1 0 0 0 2 0v-4a1 1 0 0 0 -1 -1m6 2a1 1 0 0 0 -1 1v2a1 1 0 0 0 2 0v-2a1 1 0 0 0 -1 -1m-3 1a1 1 0 0 0 -1 1v1a1 1 0 0 0 2 0v-1a1 1 0 0 0 -1 -1\" />"),
    RECEIPT(
        "receipt",
        "<path d=\"M17 2a3 3 0 0 1 3 3v16a1 1 0 0 1 -1.555 .832l-2.318 -1.545l-1.42 1.42a1 1 0 0 1 -1.32 .083l-.094 -.083l-1.293 -1.292l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083l-1.421 -1.42l-2.317 1.545l-.019 .012l-.054 .03l-.028 .017l-.054 .023l-.05 .023l-.049 .015l-.06 .019l-.052 .009l-.057 .011l-.084 .006l-.026 .003h-.022l-.049 -.003h-.039l-.013 -.003h-.016l-.041 -.008l-.038 -.005l-.015 -.005l-.018 -.002l-.034 -.011l-.04 -.01l-.019 -.007l-.015 -.004l-.029 -.013l-.04 -.015l-.021 -.011l-.013 -.005l-.028 -.016l-.036 -.018l-.014 -.01l-.018 -.01l-.038 -.027l-.022 -.014l-.01 -.009l-.02 -.014l-.045 -.041l-.012 -.008l-.024 -.024l-.035 -.039l-.02 -.02l-.007 -.011l-.011 -.012l-.032 -.045l-.02 -.025l-.012 -.019l-.03 -.054l-.017 -.028l-.023 -.054l-.023 -.05a1 1 0 0 1 -.034 -.108l-.01 -.057l-.01 -.053l-.009 -.132v-16a3 3 0 0 1 3 -3zm-2 12h-2a1 1 0 0 0 0 2h2a1 1 0 0 0 0 -2m0 -4h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2m0 -4h-6a1 1 0 1 0 0 2h6a1 1 0 0 0 0 -2\" />"),
    RECEIPT_DOLLAR(
        "receipt-dollar",
        "<path d=\"M17 2a3 3 0 0 1 3 3v16a1 1 0 0 1 -1.555 .832l-2.318 -1.545l-1.42 1.42a1 1 0 0 1 -1.32 .083l-.094 -.083l-1.293 -1.292l-1.293 1.292a1 1 0 0 1 -1.32 .083l-.094 -.083l-1.421 -1.42l-2.317 1.545l-.019 .012l-.054 .03l-.028 .017l-.054 .023l-.05 .023l-.049 .015l-.06 .019l-.052 .009l-.057 .011l-.084 .006l-.026 .003h-.022l-.049 -.003h-.039l-.013 -.003h-.016l-.041 -.008l-.038 -.005l-.015 -.005l-.018 -.002l-.034 -.011l-.04 -.01l-.019 -.007l-.015 -.004l-.029 -.013l-.04 -.015l-.021 -.011l-.013 -.005l-.028 -.016l-.036 -.018l-.014 -.01l-.018 -.01l-.038 -.027l-.022 -.014l-.01 -.009l-.02 -.014l-.045 -.041l-.012 -.008l-.024 -.024l-.035 -.039l-.02 -.02l-.007 -.011l-.011 -.012l-.032 -.045l-.02 -.025l-.012 -.019l-.03 -.054l-.017 -.028l-.023 -.054l-.023 -.05a1 1 0 0 1 -.034 -.108l-.01 -.057l-.01 -.053l-.009 -.132v-16a3 3 0 0 1 3 -3zm-5 3a1 1 0 0 0 -1 1a3 3 0 1 0 0 6v2c-.403 .013 -.75 -.18 -.934 -.5a1 1 0 0 0 -1.732 1a3 3 0 0 0 2.505 1.5l.161 -.001a1 1 0 1 0 2 .001l.176 -.005a3 3 0 0 0 -.176 -5.995v-2c.403 -.013 .75 .18 .934 .5a1 1 0 0 0 1.732 -1a3 3 0 0 0 -2.505 -1.5h-.161a1 1 0 0 0 -1 -1m1 7a1 1 0 0 1 0 2zm-2 -4v2a1 1 0 0 1 0 -2\" />"),
    REPORT_ANALYTICS(
        "report-analytics",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-8.997 6.83a1 1 0 0 0 -1 1v5a1 1 0 0 0 2 0v-5a1 1 0 0 0 -1 -1m3 4a1 1 0 0 0 -1 1v1a1 1 0 0 0 2 0v-1a1 1 0 0 0 -1 -1m3 -2a1 1 0 0 0 -1 1v3a1 1 0 0 0 2 0v-3a1 1 0 0 0 -1 -1m-1 -11a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    REPORT_MONEY(
        "report-money",
        "<path d=\"M17.997 4.17a3 3 0 0 1 2.003 2.83v12a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 2.003 -2.83a4 4 0 0 0 3.997 3.83h4a4 4 0 0 0 3.98 -3.597zm-5.997 5.83a1 1 0 0 0 -1 1v.05a2.5 2.5 0 0 0 .5 4.95h1a.5 .5 0 1 1 0 1h-2.5a1 1 0 0 0 0 2h1a1 1 0 0 0 2 0v-.05a2.5 2.5 0 0 0 -.5 -4.95h-1a.5 .5 0 1 1 0 -1h2.5a1 1 0 0 0 0 -2h-1a1 1 0 0 0 -1 -1m2 -8a2 2 0 1 1 0 4h-4a2 2 0 1 1 0 -4z\" />"),
    TICKET(
        "ticket",
        "<path d=\"M14 4v2a1 1 0 0 0 2 0v-2h3a3 3 0 0 1 3 3v3a1 1 0 0 1 -.883 .993l-.117 .007a1 1 0 0 0 -.117 1.993l.117 .007a1 1 0 0 1 1 1v3a3 3 0 0 1 -3 3h-3v-2a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v2h-9a3 3 0 0 1 -3 -3v-3a1 1 0 0 1 .883 -.993l.117 -.007a1 1 0 0 0 .117 -1.993l-.117 -.007a1 1 0 0 1 -1 -1v-3a2.995 2.995 0 0 1 2.727 -2.985l.222 -.014zm1 6a1 1 0 0 0 -1 1v2a1 1 0 0 0 2 0v-2a1 1 0 0 0 -1 -1\" />");

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

  default TablerIcon archive() {
    return TablerIcon.create(TablerDocument.OutlineIcon.ARCHIVE);
  }

  default TablerIcon archive_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.ARCHIVE_OFF);
  }

  default TablerIcon article() {
    return TablerIcon.create(TablerDocument.OutlineIcon.ARTICLE);
  }

  default TablerIcon article_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.ARTICLE_OFF);
  }

  default TablerIcon book() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOK);
  }

  default TablerIcon book_2() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOK_2);
  }

  default TablerIcon book_download() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOK_DOWNLOAD);
  }

  default TablerIcon book_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOK_OFF);
  }

  default TablerIcon book_upload() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOK_UPLOAD);
  }

  default TablerIcon bookmark() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK);
  }

  default TablerIcon bookmark_ai() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_AI);
  }

  default TablerIcon bookmark_edit() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_EDIT);
  }

  default TablerIcon bookmark_minus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_MINUS);
  }

  default TablerIcon bookmark_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_OFF);
  }

  default TablerIcon bookmark_plus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_PLUS);
  }

  default TablerIcon bookmark_question() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_QUESTION);
  }

  default TablerIcon bookmarks() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARKS);
  }

  default TablerIcon bookmarks_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARKS_OFF);
  }

  default TablerIcon books() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKS);
  }

  default TablerIcon books_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.BOOKS_OFF);
  }

  default TablerIcon certificate() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE);
  }

  default TablerIcon certificate_2() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_2);
  }

  default TablerIcon certificate_2_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_2_OFF);
  }

  default TablerIcon certificate_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_OFF);
  }

  default TablerIcon chalkboard() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CHALKBOARD);
  }

  default TablerIcon chalkboard_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CHALKBOARD_OFF);
  }

  default TablerIcon clipboard() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD);
  }

  default TablerIcon clipboard_check() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_CHECK);
  }

  default TablerIcon clipboard_copy() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_COPY);
  }

  default TablerIcon clipboard_data() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_DATA);
  }

  default TablerIcon clipboard_heart() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_HEART);
  }

  default TablerIcon clipboard_list() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_LIST);
  }

  default TablerIcon clipboard_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_OFF);
  }

  default TablerIcon clipboard_plus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_PLUS);
  }

  default TablerIcon clipboard_search() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_SEARCH);
  }

  default TablerIcon clipboard_smile() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_SMILE);
  }

  default TablerIcon clipboard_text() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_TEXT);
  }

  default TablerIcon clipboard_typography() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_TYPOGRAPHY);
  }

  default TablerIcon clipboard_x() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_X);
  }

  default TablerIcon contract() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CONTRACT);
  }

  default TablerIcon file() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE);
  }

  default TablerIcon file_3d() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_3D);
  }

  default TablerIcon file_ai() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_AI);
  }

  default TablerIcon file_alert() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ALERT);
  }

  default TablerIcon file_analytics() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ANALYTICS);
  }

  default TablerIcon file_arrow_left() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ARROW_LEFT);
  }

  default TablerIcon file_arrow_right() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ARROW_RIGHT);
  }

  default TablerIcon file_barcode() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_BARCODE);
  }

  default TablerIcon file_bitcoin() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_BITCOIN);
  }

  default TablerIcon file_broken() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_BROKEN);
  }

  default TablerIcon file_certificate() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CERTIFICATE);
  }

  default TablerIcon file_chart() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CHART);
  }

  default TablerIcon file_check() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CHECK);
  }

  default TablerIcon file_code() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CODE);
  }

  default TablerIcon file_code_2() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CODE_2);
  }

  default TablerIcon file_cv() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_CV);
  }

  default TablerIcon file_database() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DATABASE);
  }

  default TablerIcon file_delta() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DELTA);
  }

  default TablerIcon file_description() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DESCRIPTION);
  }

  default TablerIcon file_diff() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DIFF);
  }

  default TablerIcon file_digit() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DIGIT);
  }

  default TablerIcon file_dislike() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DISLIKE);
  }

  default TablerIcon file_dollar() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOLLAR);
  }

  default TablerIcon file_dots() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOTS);
  }

  default TablerIcon file_download() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOWNLOAD);
  }

  default TablerIcon file_euro() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_EURO);
  }

  default TablerIcon file_excel() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_EXCEL);
  }

  default TablerIcon file_export() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_EXPORT);
  }

  default TablerIcon file_function() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_FUNCTION);
  }

  default TablerIcon file_horizontal() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_HORIZONTAL);
  }

  default TablerIcon file_import() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_IMPORT);
  }

  default TablerIcon file_infinity() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_INFINITY);
  }

  default TablerIcon file_info() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_INFO);
  }

  default TablerIcon file_invoice() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_INVOICE);
  }

  default TablerIcon file_isr() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ISR);
  }

  default TablerIcon file_lambda() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_LAMBDA);
  }

  default TablerIcon file_like() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_LIKE);
  }

  default TablerIcon file_lock() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_LOCK);
  }

  default TablerIcon file_minus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_MINUS);
  }

  default TablerIcon file_music() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_MUSIC);
  }

  default TablerIcon file_neutral() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_NEUTRAL);
  }

  default TablerIcon file_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_OFF);
  }

  default TablerIcon file_orientation() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ORIENTATION);
  }

  default TablerIcon file_pencil() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_PENCIL);
  }

  default TablerIcon file_percent() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_PERCENT);
  }

  default TablerIcon file_phone() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_PHONE);
  }

  default TablerIcon file_plus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_PLUS);
  }

  default TablerIcon file_power() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_POWER);
  }

  default TablerIcon file_report() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_REPORT);
  }

  default TablerIcon file_rss() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_RSS);
  }

  default TablerIcon file_sad() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SAD);
  }

  default TablerIcon file_scissors() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SCISSORS);
  }

  default TablerIcon file_search() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SEARCH);
  }

  default TablerIcon file_settings() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SETTINGS);
  }

  default TablerIcon file_shredder() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SHREDDER);
  }

  default TablerIcon file_signal() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SIGNAL);
  }

  default TablerIcon file_smile() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SMILE);
  }

  default TablerIcon file_spark() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SPARK);
  }

  default TablerIcon file_spreadsheet() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SPREADSHEET);
  }

  default TablerIcon file_stack() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_STACK);
  }

  default TablerIcon file_star() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_STAR);
  }

  default TablerIcon file_symlink() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_SYMLINK);
  }

  default TablerIcon file_text() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT);
  }

  default TablerIcon file_text_ai() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_AI);
  }

  default TablerIcon file_text_shield() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_SHIELD);
  }

  default TablerIcon file_text_spark() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_SPARK);
  }

  default TablerIcon file_time() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TIME);
  }

  default TablerIcon file_type_bmp() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_BMP);
  }

  default TablerIcon file_type_css() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_CSS);
  }

  default TablerIcon file_type_csv() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_CSV);
  }

  default TablerIcon file_type_doc() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_DOC);
  }

  default TablerIcon file_type_docx() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_DOCX);
  }

  default TablerIcon file_type_html() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_HTML);
  }

  default TablerIcon file_type_jpg() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JPG);
  }

  default TablerIcon file_type_js() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JS);
  }

  default TablerIcon file_type_jsx() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JSX);
  }

  default TablerIcon file_type_pdf() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PDF);
  }

  default TablerIcon file_type_php() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PHP);
  }

  default TablerIcon file_type_png() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PNG);
  }

  default TablerIcon file_type_ppt() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PPT);
  }

  default TablerIcon file_type_rs() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_RS);
  }

  default TablerIcon file_type_sql() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_SQL);
  }

  default TablerIcon file_type_svg() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_SVG);
  }

  default TablerIcon file_type_ts() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TS);
  }

  default TablerIcon file_type_tsx() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TSX);
  }

  default TablerIcon file_type_txt() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TXT);
  }

  default TablerIcon file_type_vue() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_VUE);
  }

  default TablerIcon file_type_xls() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_XLS);
  }

  default TablerIcon file_type_xml() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_XML);
  }

  default TablerIcon file_type_zip() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_ZIP);
  }

  default TablerIcon file_typography() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPOGRAPHY);
  }

  default TablerIcon file_unknown() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_UNKNOWN);
  }

  default TablerIcon file_upload() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_UPLOAD);
  }

  default TablerIcon file_vector() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_VECTOR);
  }

  default TablerIcon file_word() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_WORD);
  }

  default TablerIcon file_x() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_X);
  }

  default TablerIcon file_zip() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILE_ZIP);
  }

  default TablerIcon files() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILES);
  }

  default TablerIcon files_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FILES_OFF);
  }

  default TablerIcon folder() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER);
  }

  default TablerIcon folder_ai() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_AI);
  }

  default TablerIcon folder_bolt() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_BOLT);
  }

  default TablerIcon folder_cancel() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CANCEL);
  }

  default TablerIcon folder_check() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CHECK);
  }

  default TablerIcon folder_code() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CODE);
  }

  default TablerIcon folder_cog() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_COG);
  }

  default TablerIcon folder_dollar() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_DOLLAR);
  }

  default TablerIcon folder_down() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_DOWN);
  }

  default TablerIcon folder_exclamation() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_EXCLAMATION);
  }

  default TablerIcon folder_heart() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_HEART);
  }

  default TablerIcon folder_lock() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_LOCK);
  }

  default TablerIcon folder_minus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_MINUS);
  }

  default TablerIcon folder_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_OFF);
  }

  default TablerIcon folder_open() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_OPEN);
  }

  default TablerIcon folder_pause() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PAUSE);
  }

  default TablerIcon folder_pin() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PIN);
  }

  default TablerIcon folder_plus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PLUS);
  }

  default TablerIcon folder_question() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_QUESTION);
  }

  default TablerIcon folder_root() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_ROOT);
  }

  default TablerIcon folder_search() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SEARCH);
  }

  default TablerIcon folder_share() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SHARE);
  }

  default TablerIcon folder_sparkle() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SPARKLE);
  }

  default TablerIcon folder_star() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_STAR);
  }

  default TablerIcon folder_stats() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_STATS);
  }

  default TablerIcon folder_symlink() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SYMLINK);
  }

  default TablerIcon folder_up() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_UP);
  }

  default TablerIcon folder_user() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_USER);
  }

  default TablerIcon folder_x() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_X);
  }

  default TablerIcon folders() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDERS);
  }

  default TablerIcon folders_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.FOLDERS_OFF);
  }

  default TablerIcon invoice() {
    return TablerIcon.create(TablerDocument.OutlineIcon.INVOICE);
  }

  default TablerIcon license() {
    return TablerIcon.create(TablerDocument.OutlineIcon.LICENSE);
  }

  default TablerIcon license_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.LICENSE_OFF);
  }

  default TablerIcon manual_gearbox() {
    return TablerIcon.create(TablerDocument.OutlineIcon.MANUAL_GEARBOX);
  }

  default TablerIcon news() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NEWS);
  }

  default TablerIcon news_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NEWS_OFF);
  }

  default TablerIcon note() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTE);
  }

  default TablerIcon note_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTE_OFF);
  }

  default TablerIcon notebook() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTEBOOK);
  }

  default TablerIcon notebook_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTEBOOK_OFF);
  }

  default TablerIcon notes() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTES);
  }

  default TablerIcon notes_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.NOTES_OFF);
  }

  default TablerIcon page_break() {
    return TablerIcon.create(TablerDocument.OutlineIcon.PAGE_BREAK);
  }

  default TablerIcon paperclip() {
    return TablerIcon.create(TablerDocument.OutlineIcon.PAPERCLIP);
  }

  default TablerIcon presentation() {
    return TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION);
  }

  default TablerIcon presentation_analytics() {
    return TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION_ANALYTICS);
  }

  default TablerIcon presentation_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION_OFF);
  }

  default TablerIcon receipt() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT);
  }

  default TablerIcon receipt_2() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_2);
  }

  default TablerIcon receipt_dollar() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_DOLLAR);
  }

  default TablerIcon receipt_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_OFF);
  }

  default TablerIcon receipt_refund() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_REFUND);
  }

  default TablerIcon receipt_tax() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_TAX);
  }

  default TablerIcon report() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT);
  }

  default TablerIcon report_analytics() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT_ANALYTICS);
  }

  default TablerIcon report_medical() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT_MEDICAL);
  }

  default TablerIcon report_money() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT_MONEY);
  }

  default TablerIcon report_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT_OFF);
  }

  default TablerIcon report_search() {
    return TablerIcon.create(TablerDocument.OutlineIcon.REPORT_SEARCH);
  }

  default TablerIcon rubber_stamp() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RUBBER_STAMP);
  }

  default TablerIcon rubber_stamp_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.RUBBER_STAMP_OFF);
  }

  default TablerIcon script() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT);
  }

  default TablerIcon script_minus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_MINUS);
  }

  default TablerIcon script_plus() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_PLUS);
  }

  default TablerIcon script_x() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_X);
  }

  default TablerIcon spacing_horizontal() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SPACING_HORIZONTAL);
  }

  default TablerIcon spacing_vertical() {
    return TablerIcon.create(TablerDocument.OutlineIcon.SPACING_VERTICAL);
  }

  default TablerIcon ticket() {
    return TablerIcon.create(TablerDocument.OutlineIcon.TICKET);
  }

  default TablerIcon ticket_off() {
    return TablerIcon.create(TablerDocument.OutlineIcon.TICKET_OFF);
  }

  default TablerIcon content_paste() {
    return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD);
  }

  default TablerIcon archive_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.ARCHIVE);
  }

  default TablerIcon article_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.ARTICLE);
  }

  default TablerIcon book_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.BOOK);
  }

  default TablerIcon bookmark_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.BOOKMARK);
  }

  default TablerIcon bookmarks_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.BOOKMARKS);
  }

  default TablerIcon clipboard_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD);
  }

  default TablerIcon clipboard_check_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_CHECK);
  }

  default TablerIcon clipboard_data_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_DATA);
  }

  default TablerIcon clipboard_list_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_LIST);
  }

  default TablerIcon clipboard_plus_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_PLUS);
  }

  default TablerIcon clipboard_smile_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_SMILE);
  }

  default TablerIcon clipboard_text_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_TEXT);
  }

  default TablerIcon clipboard_typography_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_TYPOGRAPHY);
  }

  default TablerIcon clipboard_x_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_X);
  }

  default TablerIcon file_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE);
  }

  default TablerIcon file_analytics_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_ANALYTICS);
  }

  default TablerIcon file_check_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_CHECK);
  }

  default TablerIcon file_code_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_CODE);
  }

  default TablerIcon file_code_2_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_CODE_2);
  }

  default TablerIcon file_cv_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_CV);
  }

  default TablerIcon file_delta_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DELTA);
  }

  default TablerIcon file_description_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DESCRIPTION);
  }

  default TablerIcon file_diff_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DIFF);
  }

  default TablerIcon file_digit_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DIGIT);
  }

  default TablerIcon file_dollar_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DOLLAR);
  }

  default TablerIcon file_dots_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DOTS);
  }

  default TablerIcon file_download_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_DOWNLOAD);
  }

  default TablerIcon file_euro_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_EURO);
  }

  default TablerIcon file_function_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_FUNCTION);
  }

  default TablerIcon file_horizontal_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_HORIZONTAL);
  }

  default TablerIcon file_info_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_INFO);
  }

  default TablerIcon file_invoice_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_INVOICE);
  }

  default TablerIcon file_lambda_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_LAMBDA);
  }

  default TablerIcon file_minus_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_MINUS);
  }

  default TablerIcon file_music_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_MUSIC);
  }

  default TablerIcon file_neutral_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_NEUTRAL);
  }

  default TablerIcon file_pencil_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_PENCIL);
  }

  default TablerIcon file_percent_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_PERCENT);
  }

  default TablerIcon file_phone_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_PHONE);
  }

  default TablerIcon file_power_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_POWER);
  }

  default TablerIcon file_rss_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_RSS);
  }

  default TablerIcon file_sad_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_SAD);
  }

  default TablerIcon file_scissors_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_SCISSORS);
  }

  default TablerIcon file_settings_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_SETTINGS);
  }

  default TablerIcon file_signal_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_SIGNAL);
  }

  default TablerIcon file_smile_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_SMILE);
  }

  default TablerIcon file_star_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_STAR);
  }

  default TablerIcon file_text_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_TEXT);
  }

  default TablerIcon file_time_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_TIME);
  }

  default TablerIcon file_typography_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_TYPOGRAPHY);
  }

  default TablerIcon file_unknown_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_UNKNOWN);
  }

  default TablerIcon file_upload_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_UPLOAD);
  }

  default TablerIcon file_vector_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_VECTOR);
  }

  default TablerIcon file_x_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILE_X);
  }

  default TablerIcon files_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FILES);
  }

  default TablerIcon folder_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FOLDER);
  }

  default TablerIcon folder_open_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FOLDER_OPEN);
  }

  default TablerIcon folders_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.FOLDERS);
  }

  default TablerIcon manual_gearbox_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.MANUAL_GEARBOX);
  }

  default TablerIcon presentation_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.PRESENTATION);
  }

  default TablerIcon presentation_analytics_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.PRESENTATION_ANALYTICS);
  }

  default TablerIcon receipt_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.RECEIPT);
  }

  default TablerIcon receipt_dollar_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.RECEIPT_DOLLAR);
  }

  default TablerIcon report_analytics_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.REPORT_ANALYTICS);
  }

  default TablerIcon report_money_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.REPORT_MONEY);
  }

  default TablerIcon ticket_filled() {
    return TablerIcon.create(TablerDocument.FilledIcon.TICKET);
  }
}
