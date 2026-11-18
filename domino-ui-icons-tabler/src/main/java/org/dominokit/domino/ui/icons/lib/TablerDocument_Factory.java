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
        new IconCatalogEntry<>("archive", "TablerIcons.archive()", tagIcons::archive));
    icons.add(
        new IconCatalogEntry<>(
            "archive-off", "TablerIcons.archive_off()", tagIcons::archive_off));
    icons.add(
        new IconCatalogEntry<>("article", "TablerIcons.article()", tagIcons::article));
    icons.add(
        new IconCatalogEntry<>(
            "article-off", "TablerIcons.article_off()", tagIcons::article_off));
    icons.add(new IconCatalogEntry<>("book", "TablerIcons.book()", tagIcons::book));
    icons.add(new IconCatalogEntry<>("book-2", "TablerIcons.book_2()", tagIcons::book_2));
    icons.add(
        new IconCatalogEntry<>(
            "book-download", "TablerIcons.book_download()", tagIcons::book_download));
    icons.add(
        new IconCatalogEntry<>("book-off", "TablerIcons.book_off()", tagIcons::book_off));
    icons.add(
        new IconCatalogEntry<>(
            "book-upload", "TablerIcons.book_upload()", tagIcons::book_upload));
    icons.add(
        new IconCatalogEntry<>("bookmark", "TablerIcons.bookmark()", tagIcons::bookmark));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-ai", "TablerIcons.bookmark_ai()", tagIcons::bookmark_ai));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-edit", "TablerIcons.bookmark_edit()", tagIcons::bookmark_edit));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-minus", "TablerIcons.bookmark_minus()", tagIcons::bookmark_minus));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-off", "TablerIcons.bookmark_off()", tagIcons::bookmark_off));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-plus", "TablerIcons.bookmark_plus()", tagIcons::bookmark_plus));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark-question",
            "TablerIcons.bookmark_question()",
            tagIcons::bookmark_question));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks", "TablerIcons.bookmarks()", tagIcons::bookmarks));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks-off", "TablerIcons.bookmarks_off()", tagIcons::bookmarks_off));
    icons.add(new IconCatalogEntry<>("books", "TablerIcons.books()", tagIcons::books));
    icons.add(
        new IconCatalogEntry<>(
            "books-off", "TablerIcons.books_off()", tagIcons::books_off));
    icons.add(
        new IconCatalogEntry<>(
            "certificate", "TablerIcons.certificate()", tagIcons::certificate));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-2", "TablerIcons.certificate_2()", tagIcons::certificate_2));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-2-off",
            "TablerIcons.certificate_2_off()",
            tagIcons::certificate_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "certificate-off",
            "TablerIcons.certificate_off()",
            tagIcons::certificate_off));
    icons.add(
        new IconCatalogEntry<>(
            "chalkboard", "TablerIcons.chalkboard()", tagIcons::chalkboard));
    icons.add(
        new IconCatalogEntry<>(
            "chalkboard-off", "TablerIcons.chalkboard_off()", tagIcons::chalkboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard", "TablerIcons.clipboard()", tagIcons::clipboard));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-check",
            "TablerIcons.clipboard_check()",
            tagIcons::clipboard_check));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-copy", "TablerIcons.clipboard_copy()", tagIcons::clipboard_copy));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-data", "TablerIcons.clipboard_data()", tagIcons::clipboard_data));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-heart",
            "TablerIcons.clipboard_heart()",
            tagIcons::clipboard_heart));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-list", "TablerIcons.clipboard_list()", tagIcons::clipboard_list));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-off", "TablerIcons.clipboard_off()", tagIcons::clipboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-plus", "TablerIcons.clipboard_plus()", tagIcons::clipboard_plus));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-search",
            "TablerIcons.clipboard_search()",
            tagIcons::clipboard_search));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-smile",
            "TablerIcons.clipboard_smile()",
            tagIcons::clipboard_smile));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-text", "TablerIcons.clipboard_text()", tagIcons::clipboard_text));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-typography",
            "TablerIcons.clipboard_typography()",
            tagIcons::clipboard_typography));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-x", "TablerIcons.clipboard_x()", tagIcons::clipboard_x));
    icons.add(
        new IconCatalogEntry<>("contract", "TablerIcons.contract()", tagIcons::contract));
    icons.add(new IconCatalogEntry<>("file", "TablerIcons.file()", tagIcons::file));
    icons.add(
        new IconCatalogEntry<>("file-3d", "TablerIcons.file_3d()", tagIcons::file_3d));
    icons.add(
        new IconCatalogEntry<>("file-ai", "TablerIcons.file_ai()", tagIcons::file_ai));
    icons.add(
        new IconCatalogEntry<>(
            "file-alert", "TablerIcons.file_alert()", tagIcons::file_alert));
    icons.add(
        new IconCatalogEntry<>(
            "file-analytics", "TablerIcons.file_analytics()", tagIcons::file_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "file-arrow-left",
            "TablerIcons.file_arrow_left()",
            tagIcons::file_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "file-arrow-right",
            "TablerIcons.file_arrow_right()",
            tagIcons::file_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "file-barcode", "TablerIcons.file_barcode()", tagIcons::file_barcode));
    icons.add(
        new IconCatalogEntry<>(
            "file-bitcoin", "TablerIcons.file_bitcoin()", tagIcons::file_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "file-broken", "TablerIcons.file_broken()", tagIcons::file_broken));
    icons.add(
        new IconCatalogEntry<>(
            "file-certificate",
            "TablerIcons.file_certificate()",
            tagIcons::file_certificate));
    icons.add(
        new IconCatalogEntry<>(
            "file-chart", "TablerIcons.file_chart()", tagIcons::file_chart));
    icons.add(
        new IconCatalogEntry<>(
            "file-check", "TablerIcons.file_check()", tagIcons::file_check));
    icons.add(
        new IconCatalogEntry<>(
            "file-code", "TablerIcons.file_code()", tagIcons::file_code));
    icons.add(
        new IconCatalogEntry<>(
            "file-code-2", "TablerIcons.file_code_2()", tagIcons::file_code_2));
    icons.add(
        new IconCatalogEntry<>("file-cv", "TablerIcons.file_cv()", tagIcons::file_cv));
    icons.add(
        new IconCatalogEntry<>(
            "file-database", "TablerIcons.file_database()", tagIcons::file_database));
    icons.add(
        new IconCatalogEntry<>(
            "file-delta", "TablerIcons.file_delta()", tagIcons::file_delta));
    icons.add(
        new IconCatalogEntry<>(
            "file-description",
            "TablerIcons.file_description()",
            tagIcons::file_description));
    icons.add(
        new IconCatalogEntry<>(
            "file-diff", "TablerIcons.file_diff()", tagIcons::file_diff));
    icons.add(
        new IconCatalogEntry<>(
            "file-digit", "TablerIcons.file_digit()", tagIcons::file_digit));
    icons.add(
        new IconCatalogEntry<>(
            "file-dislike", "TablerIcons.file_dislike()", tagIcons::file_dislike));
    icons.add(
        new IconCatalogEntry<>(
            "file-dollar", "TablerIcons.file_dollar()", tagIcons::file_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "file-dots", "TablerIcons.file_dots()", tagIcons::file_dots));
    icons.add(
        new IconCatalogEntry<>(
            "file-download", "TablerIcons.file_download()", tagIcons::file_download));
    icons.add(
        new IconCatalogEntry<>(
            "file-euro", "TablerIcons.file_euro()", tagIcons::file_euro));
    icons.add(
        new IconCatalogEntry<>(
            "file-excel", "TablerIcons.file_excel()", tagIcons::file_excel));
    icons.add(
        new IconCatalogEntry<>(
            "file-export", "TablerIcons.file_export()", tagIcons::file_export));
    icons.add(
        new IconCatalogEntry<>(
            "file-function", "TablerIcons.file_function()", tagIcons::file_function));
    icons.add(
        new IconCatalogEntry<>(
            "file-horizontal",
            "TablerIcons.file_horizontal()",
            tagIcons::file_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "file-import", "TablerIcons.file_import()", tagIcons::file_import));
    icons.add(
        new IconCatalogEntry<>(
            "file-infinity", "TablerIcons.file_infinity()", tagIcons::file_infinity));
    icons.add(
        new IconCatalogEntry<>(
            "file-info", "TablerIcons.file_info()", tagIcons::file_info));
    icons.add(
        new IconCatalogEntry<>(
            "file-invoice", "TablerIcons.file_invoice()", tagIcons::file_invoice));
    icons.add(
        new IconCatalogEntry<>("file-isr", "TablerIcons.file_isr()", tagIcons::file_isr));
    icons.add(
        new IconCatalogEntry<>(
            "file-lambda", "TablerIcons.file_lambda()", tagIcons::file_lambda));
    icons.add(
        new IconCatalogEntry<>(
            "file-like", "TablerIcons.file_like()", tagIcons::file_like));
    icons.add(
        new IconCatalogEntry<>(
            "file-lock", "TablerIcons.file_lock()", tagIcons::file_lock));
    icons.add(
        new IconCatalogEntry<>(
            "file-minus", "TablerIcons.file_minus()", tagIcons::file_minus));
    icons.add(
        new IconCatalogEntry<>(
            "file-music", "TablerIcons.file_music()", tagIcons::file_music));
    icons.add(
        new IconCatalogEntry<>(
            "file-neutral", "TablerIcons.file_neutral()", tagIcons::file_neutral));
    icons.add(
        new IconCatalogEntry<>("file-off", "TablerIcons.file_off()", tagIcons::file_off));
    icons.add(
        new IconCatalogEntry<>(
            "file-orientation",
            "TablerIcons.file_orientation()",
            tagIcons::file_orientation));
    icons.add(
        new IconCatalogEntry<>(
            "file-pencil", "TablerIcons.file_pencil()", tagIcons::file_pencil));
    icons.add(
        new IconCatalogEntry<>(
            "file-percent", "TablerIcons.file_percent()", tagIcons::file_percent));
    icons.add(
        new IconCatalogEntry<>(
            "file-phone", "TablerIcons.file_phone()", tagIcons::file_phone));
    icons.add(
        new IconCatalogEntry<>(
            "file-plus", "TablerIcons.file_plus()", tagIcons::file_plus));
    icons.add(
        new IconCatalogEntry<>(
            "file-power", "TablerIcons.file_power()", tagIcons::file_power));
    icons.add(
        new IconCatalogEntry<>(
            "file-report", "TablerIcons.file_report()", tagIcons::file_report));
    icons.add(
        new IconCatalogEntry<>("file-rss", "TablerIcons.file_rss()", tagIcons::file_rss));
    icons.add(
        new IconCatalogEntry<>("file-sad", "TablerIcons.file_sad()", tagIcons::file_sad));
    icons.add(
        new IconCatalogEntry<>(
            "file-scissors", "TablerIcons.file_scissors()", tagIcons::file_scissors));
    icons.add(
        new IconCatalogEntry<>(
            "file-search", "TablerIcons.file_search()", tagIcons::file_search));
    icons.add(
        new IconCatalogEntry<>(
            "file-settings", "TablerIcons.file_settings()", tagIcons::file_settings));
    icons.add(
        new IconCatalogEntry<>(
            "file-shredder", "TablerIcons.file_shredder()", tagIcons::file_shredder));
    icons.add(
        new IconCatalogEntry<>(
            "file-signal", "TablerIcons.file_signal()", tagIcons::file_signal));
    icons.add(
        new IconCatalogEntry<>(
            "file-smile", "TablerIcons.file_smile()", tagIcons::file_smile));
    icons.add(
        new IconCatalogEntry<>(
            "file-spark", "TablerIcons.file_spark()", tagIcons::file_spark));
    icons.add(
        new IconCatalogEntry<>(
            "file-spreadsheet",
            "TablerIcons.file_spreadsheet()",
            tagIcons::file_spreadsheet));
    icons.add(
        new IconCatalogEntry<>(
            "file-stack", "TablerIcons.file_stack()", tagIcons::file_stack));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "file-star", "TablerIcons.file_star()", tagIcons::file_star));
    icons.add(
        new IconCatalogEntry<>(
            "file-symlink", "TablerIcons.file_symlink()", tagIcons::file_symlink));
    icons.add(
        new IconCatalogEntry<>(
            "file-text", "TablerIcons.file_text()", tagIcons::file_text));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-ai", "TablerIcons.file_text_ai()", tagIcons::file_text_ai));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-shield",
            "TablerIcons.file_text_shield()",
            tagIcons::file_text_shield));
    icons.add(
        new IconCatalogEntry<>(
            "file-text-spark",
            "TablerIcons.file_text_spark()",
            tagIcons::file_text_spark));
    icons.add(
        new IconCatalogEntry<>(
            "file-time", "TablerIcons.file_time()", tagIcons::file_time));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-bmp", "TablerIcons.file_type_bmp()", tagIcons::file_type_bmp));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-css", "TablerIcons.file_type_css()", tagIcons::file_type_css));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-csv", "TablerIcons.file_type_csv()", tagIcons::file_type_csv));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-doc", "TablerIcons.file_type_doc()", tagIcons::file_type_doc));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-docx", "TablerIcons.file_type_docx()", tagIcons::file_type_docx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-html", "TablerIcons.file_type_html()", tagIcons::file_type_html));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-jpg", "TablerIcons.file_type_jpg()", tagIcons::file_type_jpg));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-js", "TablerIcons.file_type_js()", tagIcons::file_type_js));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-jsx", "TablerIcons.file_type_jsx()", tagIcons::file_type_jsx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-pdf", "TablerIcons.file_type_pdf()", tagIcons::file_type_pdf));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-php", "TablerIcons.file_type_php()", tagIcons::file_type_php));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-png", "TablerIcons.file_type_png()", tagIcons::file_type_png));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-ppt", "TablerIcons.file_type_ppt()", tagIcons::file_type_ppt));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-rs", "TablerIcons.file_type_rs()", tagIcons::file_type_rs));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-sql", "TablerIcons.file_type_sql()", tagIcons::file_type_sql));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-svg", "TablerIcons.file_type_svg()", tagIcons::file_type_svg));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-ts", "TablerIcons.file_type_ts()", tagIcons::file_type_ts));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-tsx", "TablerIcons.file_type_tsx()", tagIcons::file_type_tsx));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-txt", "TablerIcons.file_type_txt()", tagIcons::file_type_txt));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-vue", "TablerIcons.file_type_vue()", tagIcons::file_type_vue));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-xls", "TablerIcons.file_type_xls()", tagIcons::file_type_xls));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-xml", "TablerIcons.file_type_xml()", tagIcons::file_type_xml));
    icons.add(
        new IconCatalogEntry<>(
            "file-type-zip", "TablerIcons.file_type_zip()", tagIcons::file_type_zip));
    icons.add(
        new IconCatalogEntry<>(
            "file-typography",
            "TablerIcons.file_typography()",
            tagIcons::file_typography));
    icons.add(
        new IconCatalogEntry<>(
            "file-unknown", "TablerIcons.file_unknown()", tagIcons::file_unknown));
    icons.add(
        new IconCatalogEntry<>(
            "file-upload", "TablerIcons.file_upload()", tagIcons::file_upload));
    icons.add(
        new IconCatalogEntry<>(
            "file-vector", "TablerIcons.file_vector()", tagIcons::file_vector));
    icons.add(
        new IconCatalogEntry<>(
            "file-word", "TablerIcons.file_word()", tagIcons::file_word));
    icons.add(new IconCatalogEntry<>("file-x", "TablerIcons.file_x()", tagIcons::file_x));
    icons.add(
        new IconCatalogEntry<>("file-zip", "TablerIcons.file_zip()", tagIcons::file_zip));
    icons.add(new IconCatalogEntry<>("files", "TablerIcons.files()", tagIcons::files));
    icons.add(
        new IconCatalogEntry<>(
            "files-off", "TablerIcons.files_off()", tagIcons::files_off));
    icons.add(new IconCatalogEntry<>("folder", "TablerIcons.folder()", tagIcons::folder));
    icons.add(
        new IconCatalogEntry<>(
            "folder-ai", "TablerIcons.folder_ai()", tagIcons::folder_ai));
    icons.add(
        new IconCatalogEntry<>(
            "folder-bolt", "TablerIcons.folder_bolt()", tagIcons::folder_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "folder-cancel", "TablerIcons.folder_cancel()", tagIcons::folder_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "folder-check", "TablerIcons.folder_check()", tagIcons::folder_check));
    icons.add(
        new IconCatalogEntry<>(
            "folder-code", "TablerIcons.folder_code()", tagIcons::folder_code));
    icons.add(
        new IconCatalogEntry<>(
            "folder-cog", "TablerIcons.folder_cog()", tagIcons::folder_cog));
    icons.add(
        new IconCatalogEntry<>(
            "folder-dollar", "TablerIcons.folder_dollar()", tagIcons::folder_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "folder-down", "TablerIcons.folder_down()", tagIcons::folder_down));
    icons.add(
        new IconCatalogEntry<>(
            "folder-exclamation",
            "TablerIcons.folder_exclamation()",
            tagIcons::folder_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "folder-heart", "TablerIcons.folder_heart()", tagIcons::folder_heart));
    icons.add(
        new IconCatalogEntry<>(
            "folder-lock", "TablerIcons.folder_lock()", tagIcons::folder_lock));
    icons.add(
        new IconCatalogEntry<>(
            "folder-minus", "TablerIcons.folder_minus()", tagIcons::folder_minus));
    icons.add(
        new IconCatalogEntry<>(
            "folder-off", "TablerIcons.folder_off()", tagIcons::folder_off));
    icons.add(
        new IconCatalogEntry<>(
            "folder-open", "TablerIcons.folder_open()", tagIcons::folder_open));
    icons.add(
        new IconCatalogEntry<>(
            "folder-pause", "TablerIcons.folder_pause()", tagIcons::folder_pause));
    icons.add(
        new IconCatalogEntry<>(
            "folder-pin", "TablerIcons.folder_pin()", tagIcons::folder_pin));
    icons.add(
        new IconCatalogEntry<>(
            "folder-plus", "TablerIcons.folder_plus()", tagIcons::folder_plus));
    icons.add(
        new IconCatalogEntry<>(
            "folder-question",
            "TablerIcons.folder_question()",
            tagIcons::folder_question));
    icons.add(
        new IconCatalogEntry<>(
            "folder-root", "TablerIcons.folder_root()", tagIcons::folder_root));
    icons.add(
        new IconCatalogEntry<>(
            "folder-search", "TablerIcons.folder_search()", tagIcons::folder_search));
    icons.add(
        new IconCatalogEntry<>(
            "folder-share", "TablerIcons.folder_share()", tagIcons::folder_share));
    icons.add(
        new IconCatalogEntry<>(
            "folder-sparkle", "TablerIcons.folder_sparkle()", tagIcons::folder_sparkle));
    icons.add(
        new IconCatalogEntry<>(
            "folder-star", "TablerIcons.folder_star()", tagIcons::folder_star));
    icons.add(
        new IconCatalogEntry<>(
            "folder-stats", "TablerIcons.folder_stats()", tagIcons::folder_stats));
    icons.add(
        new IconCatalogEntry<>(
            "folder-symlink", "TablerIcons.folder_symlink()", tagIcons::folder_symlink));
    icons.add(
        new IconCatalogEntry<>(
            "folder-up", "TablerIcons.folder_up()", tagIcons::folder_up));
    icons.add(
        new IconCatalogEntry<>(
            "folder-user", "TablerIcons.folder_user()", tagIcons::folder_user));
    icons.add(
        new IconCatalogEntry<>("folder-x", "TablerIcons.folder_x()", tagIcons::folder_x));
    icons.add(
        new IconCatalogEntry<>("folders", "TablerIcons.folders()", tagIcons::folders));
    icons.add(
        new IconCatalogEntry<>(
            "folders-off", "TablerIcons.folders_off()", tagIcons::folders_off));
    icons.add(
        new IconCatalogEntry<>("invoice", "TablerIcons.invoice()", tagIcons::invoice));
    icons.add(
        new IconCatalogEntry<>("license", "TablerIcons.license()", tagIcons::license));
    icons.add(
        new IconCatalogEntry<>(
            "license-off", "TablerIcons.license_off()", tagIcons::license_off));
    icons.add(
        new IconCatalogEntry<>(
            "manual-gearbox", "TablerIcons.manual_gearbox()", tagIcons::manual_gearbox));
    icons.add(new IconCatalogEntry<>("news", "TablerIcons.news()", tagIcons::news));
    icons.add(
        new IconCatalogEntry<>("news-off", "TablerIcons.news_off()", tagIcons::news_off));
    icons.add(new IconCatalogEntry<>("note", "TablerIcons.note()", tagIcons::note));
    icons.add(
        new IconCatalogEntry<>("note-off", "TablerIcons.note_off()", tagIcons::note_off));
    icons.add(
        new IconCatalogEntry<>("notebook", "TablerIcons.notebook()", tagIcons::notebook));
    icons.add(
        new IconCatalogEntry<>(
            "notebook-off", "TablerIcons.notebook_off()", tagIcons::notebook_off));
    icons.add(new IconCatalogEntry<>("notes", "TablerIcons.notes()", tagIcons::notes));
    icons.add(
        new IconCatalogEntry<>(
            "notes-off", "TablerIcons.notes_off()", tagIcons::notes_off));
    icons.add(
        new IconCatalogEntry<>(
            "page-break", "TablerIcons.page_break()", tagIcons::page_break));
    icons.add(
        new IconCatalogEntry<>(
            "paperclip", "TablerIcons.paperclip()", tagIcons::paperclip));
    icons.add(
        new IconCatalogEntry<>(
            "presentation", "TablerIcons.presentation()", tagIcons::presentation));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-analytics",
            "TablerIcons.presentation_analytics()",
            tagIcons::presentation_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-off",
            "TablerIcons.presentation_off()",
            tagIcons::presentation_off));
    icons.add(
        new IconCatalogEntry<>("receipt", "TablerIcons.receipt()", tagIcons::receipt));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-2", "TablerIcons.receipt_2()", tagIcons::receipt_2));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-dollar", "TablerIcons.receipt_dollar()", tagIcons::receipt_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-off", "TablerIcons.receipt_off()", tagIcons::receipt_off));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-refund", "TablerIcons.receipt_refund()", tagIcons::receipt_refund));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-tax", "TablerIcons.receipt_tax()", tagIcons::receipt_tax));
    icons.add(new IconCatalogEntry<>("report", "TablerIcons.report()", tagIcons::report));
    icons.add(
        new IconCatalogEntry<>(
            "report-analytics",
            "TablerIcons.report_analytics()",
            tagIcons::report_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "report-medical", "TablerIcons.report_medical()", tagIcons::report_medical));
    icons.add(
        new IconCatalogEntry<>(
            "report-money", "TablerIcons.report_money()", tagIcons::report_money));
    icons.add(
        new IconCatalogEntry<>(
            "report-off", "TablerIcons.report_off()", tagIcons::report_off));
    icons.add(
        new IconCatalogEntry<>(
            "report-search", "TablerIcons.report_search()", tagIcons::report_search));
    icons.add(
        new IconCatalogEntry<>(
            "rubber-stamp", "TablerIcons.rubber_stamp()", tagIcons::rubber_stamp));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "rubber-stamp-off",
            "TablerIcons.rubber_stamp_off()",
            tagIcons::rubber_stamp_off));
    icons.add(new IconCatalogEntry<>("script", "TablerIcons.script()", tagIcons::script));
    icons.add(
        new IconCatalogEntry<>(
            "script-minus", "TablerIcons.script_minus()", tagIcons::script_minus));
    icons.add(
        new IconCatalogEntry<>(
            "script-plus", "TablerIcons.script_plus()", tagIcons::script_plus));
    icons.add(
        new IconCatalogEntry<>("script-x", "TablerIcons.script_x()", tagIcons::script_x));
    icons.add(
        new IconCatalogEntry<>(
            "spacing-horizontal",
            "TablerIcons.spacing_horizontal()",
            tagIcons::spacing_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "spacing-vertical",
            "TablerIcons.spacing_vertical()",
            tagIcons::spacing_vertical));
    icons.add(new IconCatalogEntry<>("ticket", "TablerIcons.ticket()", tagIcons::ticket));
    icons.add(
        new IconCatalogEntry<>(
            "ticket-off", "TablerIcons.ticket_off()", tagIcons::ticket_off));
    icons.add(
        new IconCatalogEntry<>(
            "content-paste", "TablerIcons.clipboard()", tagIcons::content_paste));
    icons.add(
        new IconCatalogEntry<>(
            "archive", "TablerIcons.archive_filled()", tagIcons::archive_filled));
    icons.add(
        new IconCatalogEntry<>(
            "article", "TablerIcons.article_filled()", tagIcons::article_filled));
    icons.add(
        new IconCatalogEntry<>(
            "book", "TablerIcons.book_filled()", tagIcons::book_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark", "TablerIcons.bookmark_filled()", tagIcons::bookmark_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks", "TablerIcons.bookmarks_filled()", tagIcons::bookmarks_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard", "TablerIcons.clipboard_filled()", tagIcons::clipboard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-check",
            "TablerIcons.clipboard_check_filled()",
            tagIcons::clipboard_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-data",
            "TablerIcons.clipboard_data_filled()",
            tagIcons::clipboard_data_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-list",
            "TablerIcons.clipboard_list_filled()",
            tagIcons::clipboard_list_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-plus",
            "TablerIcons.clipboard_plus_filled()",
            tagIcons::clipboard_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-smile",
            "TablerIcons.clipboard_smile_filled()",
            tagIcons::clipboard_smile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-text",
            "TablerIcons.clipboard_text_filled()",
            tagIcons::clipboard_text_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-typography",
            "TablerIcons.clipboard_typography_filled()",
            tagIcons::clipboard_typography_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clipboard-x",
            "TablerIcons.clipboard_x_filled()",
            tagIcons::clipboard_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file", "TablerIcons.file_filled()", tagIcons::file_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-analytics",
            "TablerIcons.file_analytics_filled()",
            tagIcons::file_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-check", "TablerIcons.file_check_filled()", tagIcons::file_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-code", "TablerIcons.file_code_filled()", tagIcons::file_code_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-code-2",
            "TablerIcons.file_code_2_filled()",
            tagIcons::file_code_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-cv", "TablerIcons.file_cv_filled()", tagIcons::file_cv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-delta", "TablerIcons.file_delta_filled()", tagIcons::file_delta_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-description",
            "TablerIcons.file_description_filled()",
            tagIcons::file_description_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-diff", "TablerIcons.file_diff_filled()", tagIcons::file_diff_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-digit", "TablerIcons.file_digit_filled()", tagIcons::file_digit_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-dollar",
            "TablerIcons.file_dollar_filled()",
            tagIcons::file_dollar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-dots", "TablerIcons.file_dots_filled()", tagIcons::file_dots_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-download",
            "TablerIcons.file_download_filled()",
            tagIcons::file_download_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-euro", "TablerIcons.file_euro_filled()", tagIcons::file_euro_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-function",
            "TablerIcons.file_function_filled()",
            tagIcons::file_function_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-horizontal",
            "TablerIcons.file_horizontal_filled()",
            tagIcons::file_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-info", "TablerIcons.file_info_filled()", tagIcons::file_info_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-invoice",
            "TablerIcons.file_invoice_filled()",
            tagIcons::file_invoice_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-lambda",
            "TablerIcons.file_lambda_filled()",
            tagIcons::file_lambda_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-minus", "TablerIcons.file_minus_filled()", tagIcons::file_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-music", "TablerIcons.file_music_filled()", tagIcons::file_music_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-neutral",
            "TablerIcons.file_neutral_filled()",
            tagIcons::file_neutral_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-pencil",
            "TablerIcons.file_pencil_filled()",
            tagIcons::file_pencil_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-percent",
            "TablerIcons.file_percent_filled()",
            tagIcons::file_percent_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-phone", "TablerIcons.file_phone_filled()", tagIcons::file_phone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-power", "TablerIcons.file_power_filled()", tagIcons::file_power_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-rss", "TablerIcons.file_rss_filled()", tagIcons::file_rss_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-sad", "TablerIcons.file_sad_filled()", tagIcons::file_sad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-scissors",
            "TablerIcons.file_scissors_filled()",
            tagIcons::file_scissors_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-settings",
            "TablerIcons.file_settings_filled()",
            tagIcons::file_settings_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-signal",
            "TablerIcons.file_signal_filled()",
            tagIcons::file_signal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-smile", "TablerIcons.file_smile_filled()", tagIcons::file_smile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-star", "TablerIcons.file_star_filled()", tagIcons::file_star_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-text", "TablerIcons.file_text_filled()", tagIcons::file_text_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-time", "TablerIcons.file_time_filled()", tagIcons::file_time_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-typography",
            "TablerIcons.file_typography_filled()",
            tagIcons::file_typography_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-unknown",
            "TablerIcons.file_unknown_filled()",
            tagIcons::file_unknown_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-upload",
            "TablerIcons.file_upload_filled()",
            tagIcons::file_upload_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-vector",
            "TablerIcons.file_vector_filled()",
            tagIcons::file_vector_filled));
    icons.add(
        new IconCatalogEntry<>(
            "file-x", "TablerIcons.file_x_filled()", tagIcons::file_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "files", "TablerIcons.files_filled()", tagIcons::files_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folder", "TablerIcons.folder_filled()", tagIcons::folder_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folder-open",
            "TablerIcons.folder_open_filled()",
            tagIcons::folder_open_filled));
    icons.add(
        new IconCatalogEntry<>(
            "folders", "TablerIcons.folders_filled()", tagIcons::folders_filled));
    icons.add(
        new IconCatalogEntry<>(
            "manual-gearbox",
            "TablerIcons.manual_gearbox_filled()",
            tagIcons::manual_gearbox_filled));
    icons.add(
        new IconCatalogEntry<>(
            "presentation",
            "TablerIcons.presentation_filled()",
            tagIcons::presentation_filled));
    icons.add(
        new IconCatalogEntry<>(
            "presentation-analytics",
            "TablerIcons.presentation_analytics_filled()",
            tagIcons::presentation_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "receipt", "TablerIcons.receipt_filled()", tagIcons::receipt_filled));
    icons.add(
        new IconCatalogEntry<>(
            "receipt-dollar",
            "TablerIcons.receipt_dollar_filled()",
            tagIcons::receipt_dollar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "report-analytics",
            "TablerIcons.report_analytics_filled()",
            tagIcons::report_analytics_filled));
    icons.add(
        new IconCatalogEntry<>(
            "report-money",
            "TablerIcons.report_money_filled()",
            tagIcons::report_money_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ticket", "TablerIcons.ticket_filled()", tagIcons::ticket_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
