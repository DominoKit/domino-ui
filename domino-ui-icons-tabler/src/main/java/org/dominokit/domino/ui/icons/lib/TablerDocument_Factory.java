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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerDocument;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Document category. */
public final class TablerDocument_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerDocument tagIcons = new TablerDocument() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "archive (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.ARCHIVE)",
            tagIcons::archive));
    icons.add(
        new IconCatalogEntry<>(
            "archive-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.ARCHIVE_OFF)",
            tagIcons::archive_off));
    icons.add(
        new IconCatalogEntry<>(
            "article (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.ARTICLE)",
            tagIcons::article));
    icons.add(
        new IconCatalogEntry<>(
            "article-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.ARTICLE_OFF)",
            tagIcons::article_off));
    icons.add(
        new IconCatalogEntry<>(
            "book (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOK)",
            tagIcons::book));
    icons.add(
        new IconCatalogEntry<>(
            "book-2 (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOK_2)",
            tagIcons::book_2));
    icons.add(
        new IconCatalogEntry<>(
            "book-download (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOK_DOWNLOAD)",
            tagIcons::book_download));
    icons.add(
        new IconCatalogEntry<>(
            "book-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOK_OFF)",
            tagIcons::book_off));
    icons.add(
        new IconCatalogEntry<>(
            "book-upload (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOK_UPLOAD)",
            tagIcons::book_upload));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK)",
            tagIcons::bookmark));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-ai (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_AI)",
            tagIcons::bookmark_ai));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-edit (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_EDIT)",
            tagIcons::bookmark_edit));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-minus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_MINUS)",
            tagIcons::bookmark_minus));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_OFF)",
            tagIcons::bookmark_off));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-plus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_PLUS)",
            tagIcons::bookmark_plus));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-question (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARK_QUESTION)",
            tagIcons::bookmark_question));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARKS)",
            tagIcons::bookmarks));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKMARKS_OFF)",
            tagIcons::bookmarks_off));
    icons.add(
        new IconCatalogEntry<>(
            "books (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKS)",
            tagIcons::books));
    icons.add(
        new IconCatalogEntry<>(
            "books-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.BOOKS_OFF)",
            tagIcons::books_off));
    icons.add(
        new IconCatalogEntry<>(
            "certificate (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE)",
            tagIcons::certificate));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-2 (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_2)",
            tagIcons::certificate_2));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-2-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_2_OFF)",
            tagIcons::certificate_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CERTIFICATE_OFF)",
            tagIcons::certificate_off));
    icons.add(
        new IconCatalogEntry<>(
            "chalkboard (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CHALKBOARD)",
            tagIcons::chalkboard));
    icons.add(
        new IconCatalogEntry<>(
            "chalkboard-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CHALKBOARD_OFF)",
            tagIcons::chalkboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD)",
            tagIcons::clipboard));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-check (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_CHECK)",
            tagIcons::clipboard_check));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-copy (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_COPY)",
            tagIcons::clipboard_copy));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-data (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_DATA)",
            tagIcons::clipboard_data));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-heart (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_HEART)",
            tagIcons::clipboard_heart));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-list (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_LIST)",
            tagIcons::clipboard_list));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_OFF)",
            tagIcons::clipboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-plus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_PLUS)",
            tagIcons::clipboard_plus));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-search (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_SEARCH)",
            tagIcons::clipboard_search));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-smile (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_SMILE)",
            tagIcons::clipboard_smile));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-text (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_TEXT)",
            tagIcons::clipboard_text));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-typography (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_TYPOGRAPHY)",
            tagIcons::clipboard_typography));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-x (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD_X)",
            tagIcons::clipboard_x));
    icons.add(
        new IconCatalogEntry<>(
            "contract (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CONTRACT)",
            tagIcons::contract));
    icons.add(
        new IconCatalogEntry<>(
            "file (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE)",
            tagIcons::file));
    icons.add(
        new IconCatalogEntry<>(
            "file-3d (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_3D)",
            tagIcons::file_3d));
    icons.add(
        new IconCatalogEntry<>(
            "file-ai (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_AI)",
            tagIcons::file_ai));
    icons.add(
        new IconCatalogEntry<>(
            "file-alert (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ALERT)",
            tagIcons::file_alert));
    icons.add(
        new IconCatalogEntry<>(
            "file-analytics (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ANALYTICS)",
            tagIcons::file_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "file-arrow-left (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ARROW_LEFT)",
            tagIcons::file_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "file-arrow-right (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ARROW_RIGHT)",
            tagIcons::file_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "file-barcode (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_BARCODE)",
            tagIcons::file_barcode));
    icons.add(
        new IconCatalogEntry<>(
            "file-bitcoin (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_BITCOIN)",
            tagIcons::file_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "file-broken (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_BROKEN)",
            tagIcons::file_broken));
    icons.add(
        new IconCatalogEntry<>(
            "file-certificate (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CERTIFICATE)",
            tagIcons::file_certificate));
    icons.add(
        new IconCatalogEntry<>(
            "file-chart (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CHART)",
            tagIcons::file_chart));
    icons.add(
        new IconCatalogEntry<>(
            "file-check (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CHECK)",
            tagIcons::file_check));
    icons.add(
        new IconCatalogEntry<>(
            "file-code (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CODE)",
            tagIcons::file_code));
    icons.add(
        new IconCatalogEntry<>(
            "file-code-2 (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CODE_2)",
            tagIcons::file_code_2));
    icons.add(
        new IconCatalogEntry<>(
            "file-cv (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_CV)",
            tagIcons::file_cv));
    icons.add(
        new IconCatalogEntry<>(
            "file-database (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DATABASE)",
            tagIcons::file_database));
    icons.add(
        new IconCatalogEntry<>(
            "file-delta (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DELTA)",
            tagIcons::file_delta));
    icons.add(
        new IconCatalogEntry<>(
            "file-description (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DESCRIPTION)",
            tagIcons::file_description));
    icons.add(
        new IconCatalogEntry<>(
            "file-diff (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DIFF)",
            tagIcons::file_diff));
    icons.add(
        new IconCatalogEntry<>(
            "file-digit (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DIGIT)",
            tagIcons::file_digit));
    icons.add(
        new IconCatalogEntry<>(
            "file-dislike (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DISLIKE)",
            tagIcons::file_dislike));
    icons.add(
        new IconCatalogEntry<>(
            "file-dollar (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOLLAR)",
            tagIcons::file_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "file-dots (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOTS)",
            tagIcons::file_dots));
    icons.add(
        new IconCatalogEntry<>(
            "file-download (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_DOWNLOAD)",
            tagIcons::file_download));
    icons.add(
        new IconCatalogEntry<>(
            "file-euro (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_EURO)",
            tagIcons::file_euro));
    icons.add(
        new IconCatalogEntry<>(
            "file-excel (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_EXCEL)",
            tagIcons::file_excel));
    icons.add(
        new IconCatalogEntry<>(
            "file-export (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_EXPORT)",
            tagIcons::file_export));
    icons.add(
        new IconCatalogEntry<>(
            "file-function (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_FUNCTION)",
            tagIcons::file_function));
    icons.add(
        new IconCatalogEntry<>(
            "file-horizontal (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_HORIZONTAL)",
            tagIcons::file_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "file-import (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_IMPORT)",
            tagIcons::file_import));
    icons.add(
        new IconCatalogEntry<>(
            "file-infinity (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_INFINITY)",
            tagIcons::file_infinity));
    icons.add(
        new IconCatalogEntry<>(
            "file-info (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_INFO)",
            tagIcons::file_info));
    icons.add(
        new IconCatalogEntry<>(
            "file-invoice (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_INVOICE)",
            tagIcons::file_invoice));
    icons.add(
        new IconCatalogEntry<>(
            "file-isr (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ISR)",
            tagIcons::file_isr));
    icons.add(
        new IconCatalogEntry<>(
            "file-lambda (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_LAMBDA)",
            tagIcons::file_lambda));
    icons.add(
        new IconCatalogEntry<>(
            "file-like (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_LIKE)",
            tagIcons::file_like));
    icons.add(
        new IconCatalogEntry<>(
            "file-lock (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_LOCK)",
            tagIcons::file_lock));
    icons.add(
        new IconCatalogEntry<>(
            "file-minus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_MINUS)",
            tagIcons::file_minus));
    icons.add(
        new IconCatalogEntry<>(
            "file-music (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_MUSIC)",
            tagIcons::file_music));
    icons.add(
        new IconCatalogEntry<>(
            "file-neutral (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_NEUTRAL)",
            tagIcons::file_neutral));
    icons.add(
        new IconCatalogEntry<>(
            "file-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_OFF)",
            tagIcons::file_off));
    icons.add(
        new IconCatalogEntry<>(
            "file-orientation (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ORIENTATION)",
            tagIcons::file_orientation));
    icons.add(
        new IconCatalogEntry<>(
            "file-pencil (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_PENCIL)",
            tagIcons::file_pencil));
    icons.add(
        new IconCatalogEntry<>(
            "file-percent (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_PERCENT)",
            tagIcons::file_percent));
    icons.add(
        new IconCatalogEntry<>(
            "file-phone (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_PHONE)",
            tagIcons::file_phone));
    icons.add(
        new IconCatalogEntry<>(
            "file-plus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_PLUS)",
            tagIcons::file_plus));
    icons.add(
        new IconCatalogEntry<>(
            "file-power (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_POWER)",
            tagIcons::file_power));
    icons.add(
        new IconCatalogEntry<>(
            "file-report (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_REPORT)",
            tagIcons::file_report));
    icons.add(
        new IconCatalogEntry<>(
            "file-rss (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_RSS)",
            tagIcons::file_rss));
    icons.add(
        new IconCatalogEntry<>(
            "file-sad (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SAD)",
            tagIcons::file_sad));
    icons.add(
        new IconCatalogEntry<>(
            "file-scissors (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SCISSORS)",
            tagIcons::file_scissors));
    icons.add(
        new IconCatalogEntry<>(
            "file-search (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SEARCH)",
            tagIcons::file_search));
    icons.add(
        new IconCatalogEntry<>(
            "file-settings (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SETTINGS)",
            tagIcons::file_settings));
    icons.add(
        new IconCatalogEntry<>(
            "file-shredder (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SHREDDER)",
            tagIcons::file_shredder));
    icons.add(
        new IconCatalogEntry<>(
            "file-signal (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SIGNAL)",
            tagIcons::file_signal));
    icons.add(
        new IconCatalogEntry<>(
            "file-smile (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SMILE)",
            tagIcons::file_smile));
    icons.add(
        new IconCatalogEntry<>(
            "file-spark (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SPARK)",
            tagIcons::file_spark));
    icons.add(
        new IconCatalogEntry<>(
            "file-spreadsheet (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SPREADSHEET)",
            tagIcons::file_spreadsheet));
    icons.add(
        new IconCatalogEntry<>(
            "file-stack (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_STACK)",
            tagIcons::file_stack));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "file-star (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_STAR)",
            tagIcons::file_star));
    icons.add(
        new IconCatalogEntry<>(
            "file-symlink (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_SYMLINK)",
            tagIcons::file_symlink));
    icons.add(
        new IconCatalogEntry<>(
            "file-text (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT)",
            tagIcons::file_text));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-ai (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_AI)",
            tagIcons::file_text_ai));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-shield (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_SHIELD)",
            tagIcons::file_text_shield));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-spark (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TEXT_SPARK)",
            tagIcons::file_text_spark));
    icons.add(
        new IconCatalogEntry<>(
            "file-time (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TIME)",
            tagIcons::file_time));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-bmp (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_BMP)",
            tagIcons::file_type_bmp));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-css (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_CSS)",
            tagIcons::file_type_css));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-csv (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_CSV)",
            tagIcons::file_type_csv));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-doc (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_DOC)",
            tagIcons::file_type_doc));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-docx (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_DOCX)",
            tagIcons::file_type_docx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-html (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_HTML)",
            tagIcons::file_type_html));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-jpg (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JPG)",
            tagIcons::file_type_jpg));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-js (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JS)",
            tagIcons::file_type_js));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-jsx (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_JSX)",
            tagIcons::file_type_jsx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-pdf (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PDF)",
            tagIcons::file_type_pdf));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-php (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PHP)",
            tagIcons::file_type_php));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-png (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PNG)",
            tagIcons::file_type_png));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-ppt (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_PPT)",
            tagIcons::file_type_ppt));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-rs (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_RS)",
            tagIcons::file_type_rs));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-sql (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_SQL)",
            tagIcons::file_type_sql));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-svg (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_SVG)",
            tagIcons::file_type_svg));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-ts (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TS)",
            tagIcons::file_type_ts));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-tsx (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TSX)",
            tagIcons::file_type_tsx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-txt (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_TXT)",
            tagIcons::file_type_txt));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-vue (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_VUE)",
            tagIcons::file_type_vue));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-xls (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_XLS)",
            tagIcons::file_type_xls));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-xml (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_XML)",
            tagIcons::file_type_xml));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-zip (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPE_ZIP)",
            tagIcons::file_type_zip));
    icons.add(
        new IconCatalogEntry<>(
            "file-typography (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_TYPOGRAPHY)",
            tagIcons::file_typography));
    icons.add(
        new IconCatalogEntry<>(
            "file-unknown (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_UNKNOWN)",
            tagIcons::file_unknown));
    icons.add(
        new IconCatalogEntry<>(
            "file-upload (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_UPLOAD)",
            tagIcons::file_upload));
    icons.add(
        new IconCatalogEntry<>(
            "file-vector (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_VECTOR)",
            tagIcons::file_vector));
    icons.add(
        new IconCatalogEntry<>(
            "file-word (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_WORD)",
            tagIcons::file_word));
    icons.add(
        new IconCatalogEntry<>(
            "file-x (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_X)",
            tagIcons::file_x));
    icons.add(
        new IconCatalogEntry<>(
            "file-zip (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILE_ZIP)",
            tagIcons::file_zip));
    icons.add(
        new IconCatalogEntry<>(
            "files (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILES)",
            tagIcons::files));
    icons.add(
        new IconCatalogEntry<>(
            "files-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FILES_OFF)",
            tagIcons::files_off));
    icons.add(
        new IconCatalogEntry<>(
            "folder (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER)",
            tagIcons::folder));
    icons.add(
        new IconCatalogEntry<>(
            "folder-ai (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_AI)",
            tagIcons::folder_ai));
    icons.add(
        new IconCatalogEntry<>(
            "folder-bolt (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_BOLT)",
            tagIcons::folder_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "folder-cancel (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CANCEL)",
            tagIcons::folder_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "folder-check (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CHECK)",
            tagIcons::folder_check));
    icons.add(
        new IconCatalogEntry<>(
            "folder-code (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_CODE)",
            tagIcons::folder_code));
    icons.add(
        new IconCatalogEntry<>(
            "folder-cog (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_COG)",
            tagIcons::folder_cog));
    icons.add(
        new IconCatalogEntry<>(
            "folder-dollar (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_DOLLAR)",
            tagIcons::folder_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "folder-down (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_DOWN)",
            tagIcons::folder_down));
    icons.add(
        new IconCatalogEntry<>(
            "folder-exclamation (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_EXCLAMATION)",
            tagIcons::folder_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "folder-heart (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_HEART)",
            tagIcons::folder_heart));
    icons.add(
        new IconCatalogEntry<>(
            "folder-lock (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_LOCK)",
            tagIcons::folder_lock));
    icons.add(
        new IconCatalogEntry<>(
            "folder-minus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_MINUS)",
            tagIcons::folder_minus));
    icons.add(
        new IconCatalogEntry<>(
            "folder-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_OFF)",
            tagIcons::folder_off));
    icons.add(
        new IconCatalogEntry<>(
            "folder-open (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_OPEN)",
            tagIcons::folder_open));
    icons.add(
        new IconCatalogEntry<>(
            "folder-pause (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PAUSE)",
            tagIcons::folder_pause));
    icons.add(
        new IconCatalogEntry<>(
            "folder-pin (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PIN)",
            tagIcons::folder_pin));
    icons.add(
        new IconCatalogEntry<>(
            "folder-plus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_PLUS)",
            tagIcons::folder_plus));
    icons.add(
        new IconCatalogEntry<>(
            "folder-question (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_QUESTION)",
            tagIcons::folder_question));
    icons.add(
        new IconCatalogEntry<>(
            "folder-root (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_ROOT)",
            tagIcons::folder_root));
    icons.add(
        new IconCatalogEntry<>(
            "folder-search (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SEARCH)",
            tagIcons::folder_search));
    icons.add(
        new IconCatalogEntry<>(
            "folder-share (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SHARE)",
            tagIcons::folder_share));
    icons.add(
        new IconCatalogEntry<>(
            "folder-sparkle (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SPARKLE)",
            tagIcons::folder_sparkle));
    icons.add(
        new IconCatalogEntry<>(
            "folder-star (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_STAR)",
            tagIcons::folder_star));
    icons.add(
        new IconCatalogEntry<>(
            "folder-stats (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_STATS)",
            tagIcons::folder_stats));
    icons.add(
        new IconCatalogEntry<>(
            "folder-symlink (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_SYMLINK)",
            tagIcons::folder_symlink));
    icons.add(
        new IconCatalogEntry<>(
            "folder-up (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_UP)",
            tagIcons::folder_up));
    icons.add(
        new IconCatalogEntry<>(
            "folder-user (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_USER)",
            tagIcons::folder_user));
    icons.add(
        new IconCatalogEntry<>(
            "folder-x (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDER_X)",
            tagIcons::folder_x));
    icons.add(
        new IconCatalogEntry<>(
            "folders (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDERS)",
            tagIcons::folders));
    icons.add(
        new IconCatalogEntry<>(
            "folders-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.FOLDERS_OFF)",
            tagIcons::folders_off));
    icons.add(
        new IconCatalogEntry<>(
            "invoice (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.INVOICE)",
            tagIcons::invoice));
    icons.add(
        new IconCatalogEntry<>(
            "license (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.LICENSE)",
            tagIcons::license));
    icons.add(
        new IconCatalogEntry<>(
            "license-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.LICENSE_OFF)",
            tagIcons::license_off));
    icons.add(
        new IconCatalogEntry<>(
            "manual-gearbox (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.MANUAL_GEARBOX)",
            tagIcons::manual_gearbox));
    icons.add(
        new IconCatalogEntry<>(
            "news (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NEWS)",
            tagIcons::news));
    icons.add(
        new IconCatalogEntry<>(
            "news-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NEWS_OFF)",
            tagIcons::news_off));
    icons.add(
        new IconCatalogEntry<>(
            "note (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTE)",
            tagIcons::note));
    icons.add(
        new IconCatalogEntry<>(
            "note-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTE_OFF)",
            tagIcons::note_off));
    icons.add(
        new IconCatalogEntry<>(
            "notebook (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTEBOOK)",
            tagIcons::notebook));
    icons.add(
        new IconCatalogEntry<>(
            "notebook-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTEBOOK_OFF)",
            tagIcons::notebook_off));
    icons.add(
        new IconCatalogEntry<>(
            "notes (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTES)",
            tagIcons::notes));
    icons.add(
        new IconCatalogEntry<>(
            "notes-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.NOTES_OFF)",
            tagIcons::notes_off));
    icons.add(
        new IconCatalogEntry<>(
            "page-break (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.PAGE_BREAK)",
            tagIcons::page_break));
    icons.add(
        new IconCatalogEntry<>(
            "paperclip (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.PAPERCLIP)",
            tagIcons::paperclip));
    icons.add(
        new IconCatalogEntry<>(
            "presentation (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION)",
            tagIcons::presentation));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-analytics (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION_ANALYTICS)",
            tagIcons::presentation_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.PRESENTATION_OFF)",
            tagIcons::presentation_off));
    icons.add(
        new IconCatalogEntry<>(
            "receipt (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT)",
            tagIcons::receipt));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-2 (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_2)",
            tagIcons::receipt_2));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-dollar (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_DOLLAR)",
            tagIcons::receipt_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_OFF)",
            tagIcons::receipt_off));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-refund (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_REFUND)",
            tagIcons::receipt_refund));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-tax (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RECEIPT_TAX)",
            tagIcons::receipt_tax));
    icons.add(
        new IconCatalogEntry<>(
            "report (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT)",
            tagIcons::report));
    icons.add(
        new IconCatalogEntry<>(
            "report-analytics (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT_ANALYTICS)",
            tagIcons::report_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "report-medical (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT_MEDICAL)",
            tagIcons::report_medical));
    icons.add(
        new IconCatalogEntry<>(
            "report-money (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT_MONEY)",
            tagIcons::report_money));
    icons.add(
        new IconCatalogEntry<>(
            "report-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT_OFF)",
            tagIcons::report_off));
    icons.add(
        new IconCatalogEntry<>(
            "report-search (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.REPORT_SEARCH)",
            tagIcons::report_search));
    icons.add(
        new IconCatalogEntry<>(
            "rubber-stamp (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RUBBER_STAMP)",
            tagIcons::rubber_stamp));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "rubber-stamp-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.RUBBER_STAMP_OFF)",
            tagIcons::rubber_stamp_off));
    icons.add(
        new IconCatalogEntry<>(
            "script (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT)",
            tagIcons::script));
    icons.add(
        new IconCatalogEntry<>(
            "script-minus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_MINUS)",
            tagIcons::script_minus));
    icons.add(
        new IconCatalogEntry<>(
            "script-plus (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_PLUS)",
            tagIcons::script_plus));
    icons.add(
        new IconCatalogEntry<>(
            "script-x (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SCRIPT_X)",
            tagIcons::script_x));
    icons.add(
        new IconCatalogEntry<>(
            "spacing-horizontal (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SPACING_HORIZONTAL)",
            tagIcons::spacing_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "spacing-vertical (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.SPACING_VERTICAL)",
            tagIcons::spacing_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "ticket (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.TICKET)",
            tagIcons::ticket));
    icons.add(
        new IconCatalogEntry<>(
            "ticket-off (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.TICKET_OFF)",
            tagIcons::ticket_off));
    icons.add(
        new IconCatalogEntry<>(
            "content-paste (outline)",
            "TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD)",
            tagIcons::content_paste));
    icons.add(
        new IconCatalogEntry<>(
            "archive (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.ARCHIVE)",
            tagIcons::archive_filled));
    icons.add(
        new IconCatalogEntry<>(
            "article (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.ARTICLE)",
            tagIcons::article_filled));
    icons.add(
        new IconCatalogEntry<>(
            "book (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.BOOK)",
            tagIcons::book_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.BOOKMARK)",
            tagIcons::bookmark_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.BOOKMARKS)",
            tagIcons::bookmarks_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD)",
            tagIcons::clipboard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-check (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_CHECK)",
            tagIcons::clipboard_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-data (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_DATA)",
            tagIcons::clipboard_data_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-list (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_LIST)",
            tagIcons::clipboard_list_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-plus (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_PLUS)",
            tagIcons::clipboard_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-smile (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_SMILE)",
            tagIcons::clipboard_smile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-text (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_TEXT)",
            tagIcons::clipboard_text_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-typography (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_TYPOGRAPHY)",
            tagIcons::clipboard_typography_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-x (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.CLIPBOARD_X)",
            tagIcons::clipboard_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE)",
            tagIcons::file_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-analytics (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_ANALYTICS)",
            tagIcons::file_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-check (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_CHECK)",
            tagIcons::file_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-code (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_CODE)",
            tagIcons::file_code_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-code-2 (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_CODE_2)",
            tagIcons::file_code_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-cv (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_CV)",
            tagIcons::file_cv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-delta (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DELTA)",
            tagIcons::file_delta_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-description (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DESCRIPTION)",
            tagIcons::file_description_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-diff (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DIFF)",
            tagIcons::file_diff_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-digit (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DIGIT)",
            tagIcons::file_digit_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-dollar (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DOLLAR)",
            tagIcons::file_dollar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-dots (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DOTS)",
            tagIcons::file_dots_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-download (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_DOWNLOAD)",
            tagIcons::file_download_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-euro (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_EURO)",
            tagIcons::file_euro_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-function (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_FUNCTION)",
            tagIcons::file_function_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-horizontal (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_HORIZONTAL)",
            tagIcons::file_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-info (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_INFO)",
            tagIcons::file_info_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-invoice (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_INVOICE)",
            tagIcons::file_invoice_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-lambda (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_LAMBDA)",
            tagIcons::file_lambda_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-minus (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_MINUS)",
            tagIcons::file_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-music (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_MUSIC)",
            tagIcons::file_music_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-neutral (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_NEUTRAL)",
            tagIcons::file_neutral_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-pencil (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_PENCIL)",
            tagIcons::file_pencil_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-percent (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_PERCENT)",
            tagIcons::file_percent_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-phone (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_PHONE)",
            tagIcons::file_phone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-power (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_POWER)",
            tagIcons::file_power_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-rss (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_RSS)",
            tagIcons::file_rss_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-sad (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_SAD)",
            tagIcons::file_sad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-scissors (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_SCISSORS)",
            tagIcons::file_scissors_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-settings (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_SETTINGS)",
            tagIcons::file_settings_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-signal (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_SIGNAL)",
            tagIcons::file_signal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-smile (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_SMILE)",
            tagIcons::file_smile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-star (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_STAR)",
            tagIcons::file_star_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-text (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_TEXT)",
            tagIcons::file_text_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-time (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_TIME)",
            tagIcons::file_time_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-typography (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_TYPOGRAPHY)",
            tagIcons::file_typography_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-unknown (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_UNKNOWN)",
            tagIcons::file_unknown_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-upload (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_UPLOAD)",
            tagIcons::file_upload_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-vector (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_VECTOR)",
            tagIcons::file_vector_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-x (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILE_X)",
            tagIcons::file_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "files (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FILES)",
            tagIcons::files_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folder (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FOLDER)",
            tagIcons::folder_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folder-open (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FOLDER_OPEN)",
            tagIcons::folder_open_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folders (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.FOLDERS)",
            tagIcons::folders_filled));
    icons.add(
        new IconCatalogEntry<>(
            "manual-gearbox (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.MANUAL_GEARBOX)",
            tagIcons::manual_gearbox_filled));
    icons.add(
        new IconCatalogEntry<>(
            "presentation (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.PRESENTATION)",
            tagIcons::presentation_filled));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-analytics (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.PRESENTATION_ANALYTICS)",
            tagIcons::presentation_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "receipt (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.RECEIPT)",
            tagIcons::receipt_filled));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-dollar (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.RECEIPT_DOLLAR)",
            tagIcons::receipt_dollar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "report-analytics (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.REPORT_ANALYTICS)",
            tagIcons::report_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "report-money (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.REPORT_MONEY)",
            tagIcons::report_money_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ticket (filled)",
            "TablerIcon.create(TablerDocument.FilledIcon.TICKET)",
            tagIcons::ticket_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
