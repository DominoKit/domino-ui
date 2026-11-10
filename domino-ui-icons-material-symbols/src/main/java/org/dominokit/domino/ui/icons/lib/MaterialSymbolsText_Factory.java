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
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;
import org.dominokit.domino.ui.icons.MaterialSymbolsText;

/** Static icon factory for the Material Symbols Text category. */
public final class MaterialSymbolsText_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsText tagIcons = new MaterialSymbolsText() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
    addIcons3();
    addIcons4();
    addIcons5();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "add_column_left",
            "MaterialSymbolsIcon.create(\"add_column_left\")",
            tagIcons::add_column_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_column_right",
            "MaterialSymbolsIcon.create(\"add_column_right\")",
            tagIcons::add_column_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_link", "MaterialSymbolsIcon.create(\"add_link\")", tagIcons::add_link_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_notes", "MaterialSymbolsIcon.create(\"add_notes\")", tagIcons::add_notes_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_row_above",
            "MaterialSymbolsIcon.create(\"add_row_above\")",
            tagIcons::add_row_above_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_row_below",
            "MaterialSymbolsIcon.create(\"add_row_below\")",
            tagIcons::add_row_below_text));
    icons.add(
        new IconCatalogEntry<>(
            "add_to_drive",
            "MaterialSymbolsIcon.create(\"add_to_drive\")",
            tagIcons::add_to_drive_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_center",
            "MaterialSymbolsIcon.create(\"align_center\")",
            tagIcons::align_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_end", "MaterialSymbolsIcon.create(\"align_end\")", tagIcons::align_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_flex_center",
            "MaterialSymbolsIcon.create(\"align_flex_center\")",
            tagIcons::align_flex_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_flex_end",
            "MaterialSymbolsIcon.create(\"align_flex_end\")",
            tagIcons::align_flex_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_flex_start",
            "MaterialSymbolsIcon.create(\"align_flex_start\")",
            tagIcons::align_flex_start_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_horizontal_center",
            "MaterialSymbolsIcon.create(\"align_horizontal_center\")",
            tagIcons::align_horizontal_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_horizontal_left",
            "MaterialSymbolsIcon.create(\"align_horizontal_left\")",
            tagIcons::align_horizontal_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_horizontal_right",
            "MaterialSymbolsIcon.create(\"align_horizontal_right\")",
            tagIcons::align_horizontal_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_items_stretch",
            "MaterialSymbolsIcon.create(\"align_items_stretch\")",
            tagIcons::align_items_stretch_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_center",
            "MaterialSymbolsIcon.create(\"align_justify_center\")",
            tagIcons::align_justify_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_flex_end",
            "MaterialSymbolsIcon.create(\"align_justify_flex_end\")",
            tagIcons::align_justify_flex_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_flex_start",
            "MaterialSymbolsIcon.create(\"align_justify_flex_start\")",
            tagIcons::align_justify_flex_start_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_space_around",
            "MaterialSymbolsIcon.create(\"align_justify_space_around\")",
            tagIcons::align_justify_space_around_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_space_between",
            "MaterialSymbolsIcon.create(\"align_justify_space_between\")",
            tagIcons::align_justify_space_between_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_space_even",
            "MaterialSymbolsIcon.create(\"align_justify_space_even\")",
            tagIcons::align_justify_space_even_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_justify_stretch",
            "MaterialSymbolsIcon.create(\"align_justify_stretch\")",
            tagIcons::align_justify_stretch_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_self_stretch",
            "MaterialSymbolsIcon.create(\"align_self_stretch\")",
            tagIcons::align_self_stretch_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_space_around",
            "MaterialSymbolsIcon.create(\"align_space_around\")",
            tagIcons::align_space_around_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_space_between",
            "MaterialSymbolsIcon.create(\"align_space_between\")",
            tagIcons::align_space_between_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_space_even",
            "MaterialSymbolsIcon.create(\"align_space_even\")",
            tagIcons::align_space_even_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_start",
            "MaterialSymbolsIcon.create(\"align_start\")",
            tagIcons::align_start_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_stretch",
            "MaterialSymbolsIcon.create(\"align_stretch\")",
            tagIcons::align_stretch_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_vertical_bottom",
            "MaterialSymbolsIcon.create(\"align_vertical_bottom\")",
            tagIcons::align_vertical_bottom_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_vertical_center",
            "MaterialSymbolsIcon.create(\"align_vertical_center\")",
            tagIcons::align_vertical_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "align_vertical_top",
            "MaterialSymbolsIcon.create(\"align_vertical_top\")",
            tagIcons::align_vertical_top_text));
    icons.add(
        new IconCatalogEntry<>(
            "amp_stories",
            "MaterialSymbolsIcon.create(\"amp_stories\")",
            tagIcons::amp_stories_text));
    icons.add(
        new IconCatalogEntry<>(
            "apps_plus", "MaterialSymbolsIcon.create(\"apps_plus\")", tagIcons::apps_plus_text));
    icons.add(
        new IconCatalogEntry<>(
            "archive", "MaterialSymbolsIcon.create(\"archive\")", tagIcons::archive_text));
    icons.add(
        new IconCatalogEntry<>(
            "article", "MaterialSymbolsIcon.create(\"article\")", tagIcons::article_text));
    icons.add(
        new IconCatalogEntry<>(
            "article_person",
            "MaterialSymbolsIcon.create(\"article_person\")",
            tagIcons::article_person_text));
    icons.add(
        new IconCatalogEntry<>(
            "article_shortcut",
            "MaterialSymbolsIcon.create(\"article_shortcut\")",
            tagIcons::article_shortcut_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment", "MaterialSymbolsIcon.create(\"assignment\")", tagIcons::assignment_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_add",
            "MaterialSymbolsIcon.create(\"assignment_add\")",
            tagIcons::assignment_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_globe",
            "MaterialSymbolsIcon.create(\"assignment_globe\")",
            tagIcons::assignment_globe_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_ind",
            "MaterialSymbolsIcon.create(\"assignment_ind\")",
            tagIcons::assignment_ind_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_late",
            "MaterialSymbolsIcon.create(\"assignment_late\")",
            tagIcons::assignment_late_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_return",
            "MaterialSymbolsIcon.create(\"assignment_return\")",
            tagIcons::assignment_return_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_returned",
            "MaterialSymbolsIcon.create(\"assignment_returned\")",
            tagIcons::assignment_returned_text));
    icons.add(
        new IconCatalogEntry<>(
            "assignment_turned_in",
            "MaterialSymbolsIcon.create(\"assignment_turned_in\")",
            tagIcons::assignment_turned_in_text));
    icons.add(
        new IconCatalogEntry<>(
            "asterisk", "MaterialSymbolsIcon.create(\"asterisk\")", tagIcons::asterisk_text));
    icons.add(
        new IconCatalogEntry<>(
            "attach_file",
            "MaterialSymbolsIcon.create(\"attach_file\")",
            tagIcons::attach_file_text));
    icons.add(
        new IconCatalogEntry<>(
            "attach_file_add",
            "MaterialSymbolsIcon.create(\"attach_file_add\")",
            tagIcons::attach_file_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "attach_file_off",
            "MaterialSymbolsIcon.create(\"attach_file_off\")",
            tagIcons::attach_file_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "attachment", "MaterialSymbolsIcon.create(\"attachment\")", tagIcons::attachment_text));
    icons.add(
        new IconCatalogEntry<>(
            "automation", "MaterialSymbolsIcon.create(\"automation\")", tagIcons::automation_text));
    icons.add(
        new IconCatalogEntry<>(
            "ballot", "MaterialSymbolsIcon.create(\"ballot\")", tagIcons::ballot_text));
    icons.add(
        new IconCatalogEntry<>(
            "book", "MaterialSymbolsIcon.create(\"book\")", tagIcons::book_text));
    icons.add(
        new IconCatalogEntry<>(
            "book_2", "MaterialSymbolsIcon.create(\"book_2\")", tagIcons::book_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "book_3", "MaterialSymbolsIcon.create(\"book_3\")", tagIcons::book_3_text));
    icons.add(
        new IconCatalogEntry<>(
            "book_4", "MaterialSymbolsIcon.create(\"book_4\")", tagIcons::book_4_text));
    icons.add(
        new IconCatalogEntry<>(
            "book_5", "MaterialSymbolsIcon.create(\"book_5\")", tagIcons::book_5_text));
    icons.add(
        new IconCatalogEntry<>(
            "book_6", "MaterialSymbolsIcon.create(\"book_6\")", tagIcons::book_6_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_all", "MaterialSymbolsIcon.create(\"border_all\")", tagIcons::border_all_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_bottom",
            "MaterialSymbolsIcon.create(\"border_bottom\")",
            tagIcons::border_bottom_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_clear",
            "MaterialSymbolsIcon.create(\"border_clear\")",
            tagIcons::border_clear_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_color",
            "MaterialSymbolsIcon.create(\"border_color\")",
            tagIcons::border_color_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_horizontal",
            "MaterialSymbolsIcon.create(\"border_horizontal\")",
            tagIcons::border_horizontal_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_inner",
            "MaterialSymbolsIcon.create(\"border_inner\")",
            tagIcons::border_inner_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_left",
            "MaterialSymbolsIcon.create(\"border_left\")",
            tagIcons::border_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_outer",
            "MaterialSymbolsIcon.create(\"border_outer\")",
            tagIcons::border_outer_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_right",
            "MaterialSymbolsIcon.create(\"border_right\")",
            tagIcons::border_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_style",
            "MaterialSymbolsIcon.create(\"border_style\")",
            tagIcons::border_style_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_top", "MaterialSymbolsIcon.create(\"border_top\")", tagIcons::border_top_text));
    icons.add(
        new IconCatalogEntry<>(
            "border_vertical",
            "MaterialSymbolsIcon.create(\"border_vertical\")",
            tagIcons::border_vertical_text));
    icons.add(
        new IconCatalogEntry<>(
            "brand_family",
            "MaterialSymbolsIcon.create(\"brand_family\")",
            tagIcons::brand_family_text));
    icons.add(
        new IconCatalogEntry<>(
            "breaking_news",
            "MaterialSymbolsIcon.create(\"breaking_news\")",
            tagIcons::breaking_news_text));
    icons.add(
        new IconCatalogEntry<>(
            "breaking_news_alt_1",
            "MaterialSymbolsIcon.create(\"breaking_news_alt_1\")",
            tagIcons::breaking_news_alt_1_text));
    icons.add(
        new IconCatalogEntry<>(
            "business_chip",
            "MaterialSymbolsIcon.create(\"business_chip\")",
            tagIcons::business_chip_text));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_view_day",
            "MaterialSymbolsIcon.create(\"calendar_view_day\")",
            tagIcons::calendar_view_day_text));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_view_month",
            "MaterialSymbolsIcon.create(\"calendar_view_month\")",
            tagIcons::calendar_view_month_text));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_view_week",
            "MaterialSymbolsIcon.create(\"calendar_view_week\")",
            tagIcons::calendar_view_week_text));
    icons.add(
        new IconCatalogEntry<>(
            "cards_stack",
            "MaterialSymbolsIcon.create(\"cards_stack\")",
            tagIcons::cards_stack_text));
    icons.add(
        new IconCatalogEntry<>(
            "cell_merge", "MaterialSymbolsIcon.create(\"cell_merge\")", tagIcons::cell_merge_text));
    icons.add(
        new IconCatalogEntry<>(
            "checklist", "MaterialSymbolsIcon.create(\"checklist\")", tagIcons::checklist_text));
    icons.add(
        new IconCatalogEntry<>(
            "checklist_rtl",
            "MaterialSymbolsIcon.create(\"checklist_rtl\")",
            tagIcons::checklist_rtl_text));
    icons.add(
        new IconCatalogEntry<>(
            "clarify", "MaterialSymbolsIcon.create(\"clarify\")", tagIcons::clarify_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud", "MaterialSymbolsIcon.create(\"cloud\")", tagIcons::cloud_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_alert",
            "MaterialSymbolsIcon.create(\"cloud_alert\")",
            tagIcons::cloud_alert_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_circle",
            "MaterialSymbolsIcon.create(\"cloud_circle\")",
            tagIcons::cloud_circle_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_done", "MaterialSymbolsIcon.create(\"cloud_done\")", tagIcons::cloud_done_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_download",
            "MaterialSymbolsIcon.create(\"cloud_download\")",
            tagIcons::cloud_download_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_lock", "MaterialSymbolsIcon.create(\"cloud_lock\")", tagIcons::cloud_lock_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_off", "MaterialSymbolsIcon.create(\"cloud_off\")", tagIcons::cloud_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_sync", "MaterialSymbolsIcon.create(\"cloud_sync\")", tagIcons::cloud_sync_text));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_upload",
            "MaterialSymbolsIcon.create(\"cloud_upload\")",
            tagIcons::cloud_upload_text));
    icons.add(
        new IconCatalogEntry<>(
            "colors", "MaterialSymbolsIcon.create(\"colors\")", tagIcons::colors_text));
    icons.add(
        new IconCatalogEntry<>(
            "combine_columns",
            "MaterialSymbolsIcon.create(\"combine_columns\")",
            tagIcons::combine_columns_text));
    icons.add(
        new IconCatalogEntry<>(
            "contact_page",
            "MaterialSymbolsIcon.create(\"contact_page\")",
            tagIcons::contact_page_text));
    icons.add(
        new IconCatalogEntry<>(
            "content_copy",
            "MaterialSymbolsIcon.create(\"content_copy\")",
            tagIcons::content_copy_text));
    icons.add(
        new IconCatalogEntry<>(
            "content_cut",
            "MaterialSymbolsIcon.create(\"content_cut\")",
            tagIcons::content_cut_text));
    icons.add(
        new IconCatalogEntry<>(
            "content_paste",
            "MaterialSymbolsIcon.create(\"content_paste\")",
            tagIcons::content_paste_text));
    icons.add(
        new IconCatalogEntry<>(
            "content_paste_go",
            "MaterialSymbolsIcon.create(\"content_paste_go\")",
            tagIcons::content_paste_go_text));
    icons.add(
        new IconCatalogEntry<>(
            "content_paste_off",
            "MaterialSymbolsIcon.create(\"content_paste_off\")",
            tagIcons::content_paste_off_text));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "content_paste_search",
            "MaterialSymbolsIcon.create(\"content_paste_search\")",
            tagIcons::content_paste_search_text));
    icons.add(
        new IconCatalogEntry<>(
            "contract", "MaterialSymbolsIcon.create(\"contract\")", tagIcons::contract_text));
    icons.add(
        new IconCatalogEntry<>(
            "contract_delete",
            "MaterialSymbolsIcon.create(\"contract_delete\")",
            tagIcons::contract_delete_text));
    icons.add(
        new IconCatalogEntry<>(
            "contract_edit",
            "MaterialSymbolsIcon.create(\"contract_edit\")",
            tagIcons::contract_edit_text));
    icons.add(
        new IconCatalogEntry<>(
            "convert_to_text",
            "MaterialSymbolsIcon.create(\"convert_to_text\")",
            tagIcons::convert_to_text_text));
    icons.add(
        new IconCatalogEntry<>(
            "copy_all", "MaterialSymbolsIcon.create(\"copy_all\")", tagIcons::copy_all_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_0", "MaterialSymbolsIcon.create(\"counter_0\")", tagIcons::counter_0_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_1", "MaterialSymbolsIcon.create(\"counter_1\")", tagIcons::counter_1_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_2", "MaterialSymbolsIcon.create(\"counter_2\")", tagIcons::counter_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_3", "MaterialSymbolsIcon.create(\"counter_3\")", tagIcons::counter_3_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_4", "MaterialSymbolsIcon.create(\"counter_4\")", tagIcons::counter_4_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_5", "MaterialSymbolsIcon.create(\"counter_5\")", tagIcons::counter_5_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_6", "MaterialSymbolsIcon.create(\"counter_6\")", tagIcons::counter_6_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_7", "MaterialSymbolsIcon.create(\"counter_7\")", tagIcons::counter_7_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_8", "MaterialSymbolsIcon.create(\"counter_8\")", tagIcons::counter_8_text));
    icons.add(
        new IconCatalogEntry<>(
            "counter_9", "MaterialSymbolsIcon.create(\"counter_9\")", tagIcons::counter_9_text));
    icons.add(
        new IconCatalogEntry<>("csv", "MaterialSymbolsIcon.create(\"csv\")", tagIcons::csv_text));
    icons.add(
        new IconCatalogEntry<>(
            "custom_typography",
            "MaterialSymbolsIcon.create(\"custom_typography\")",
            tagIcons::custom_typography_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard", "MaterialSymbolsIcon.create(\"dashboard\")", tagIcons::dashboard_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard_2",
            "MaterialSymbolsIcon.create(\"dashboard_2\")",
            tagIcons::dashboard_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard_2_add",
            "MaterialSymbolsIcon.create(\"dashboard_2_add\")",
            tagIcons::dashboard_2_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard_2_edit",
            "MaterialSymbolsIcon.create(\"dashboard_2_edit\")",
            tagIcons::dashboard_2_edit_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard_2_gear",
            "MaterialSymbolsIcon.create(\"dashboard_2_gear\")",
            tagIcons::dashboard_2_gear_text));
    icons.add(
        new IconCatalogEntry<>(
            "dashboard_customize",
            "MaterialSymbolsIcon.create(\"dashboard_customize\")",
            tagIcons::dashboard_customize_text));
    icons.add(
        new IconCatalogEntry<>(
            "data_array", "MaterialSymbolsIcon.create(\"data_array\")", tagIcons::data_array_text));
    icons.add(
        new IconCatalogEntry<>(
            "data_object",
            "MaterialSymbolsIcon.create(\"data_object\")",
            tagIcons::data_object_text));
    icons.add(
        new IconCatalogEntry<>(
            "decimal_decrease",
            "MaterialSymbolsIcon.create(\"decimal_decrease\")",
            tagIcons::decimal_decrease_text));
    icons.add(
        new IconCatalogEntry<>(
            "decimal_increase",
            "MaterialSymbolsIcon.create(\"decimal_increase\")",
            tagIcons::decimal_increase_text));
    icons.add(
        new IconCatalogEntry<>(
            "description",
            "MaterialSymbolsIcon.create(\"description\")",
            tagIcons::description_text));
    icons.add(
        new IconCatalogEntry<>(
            "deselect", "MaterialSymbolsIcon.create(\"deselect\")", tagIcons::deselect_text));
    icons.add(
        new IconCatalogEntry<>(
            "design_services",
            "MaterialSymbolsIcon.create(\"design_services\")",
            tagIcons::design_services_text));
    icons.add(
        new IconCatalogEntry<>(
            "diagnosis", "MaterialSymbolsIcon.create(\"diagnosis\")", tagIcons::diagnosis_text));
    icons.add(
        new IconCatalogEntry<>(
            "diagonal_line",
            "MaterialSymbolsIcon.create(\"diagonal_line\")",
            tagIcons::diagonal_line_text));
    icons.add(
        new IconCatalogEntry<>(
            "dictionary", "MaterialSymbolsIcon.create(\"dictionary\")", tagIcons::dictionary_text));
    icons.add(
        new IconCatalogEntry<>(
            "difference", "MaterialSymbolsIcon.create(\"difference\")", tagIcons::difference_text));
    icons.add(
        new IconCatalogEntry<>(
            "docs", "MaterialSymbolsIcon.create(\"docs\")", tagIcons::docs_text));
    icons.add(
        new IconCatalogEntry<>(
            "docs_add_on",
            "MaterialSymbolsIcon.create(\"docs_add_on\")",
            tagIcons::docs_add_on_text));
    icons.add(
        new IconCatalogEntry<>(
            "docs_apps_script",
            "MaterialSymbolsIcon.create(\"docs_apps_script\")",
            tagIcons::docs_apps_script_text));
    icons.add(
        new IconCatalogEntry<>(
            "document_scanner",
            "MaterialSymbolsIcon.create(\"document_scanner\")",
            tagIcons::document_scanner_text));
    icons.add(
        new IconCatalogEntry<>(
            "document_search",
            "MaterialSymbolsIcon.create(\"document_search\")",
            tagIcons::document_search_text));
    icons.add(
        new IconCatalogEntry<>(
            "document_share",
            "MaterialSymbolsIcon.create(\"document_share\")",
            tagIcons::document_share_text));
    icons.add(
        new IconCatalogEntry<>(
            "document_share_stack",
            "MaterialSymbolsIcon.create(\"document_share_stack\")",
            tagIcons::document_share_stack_text));
    icons.add(
        new IconCatalogEntry<>(
            "draft", "MaterialSymbolsIcon.create(\"draft\")", tagIcons::draft_text));
    icons.add(
        new IconCatalogEntry<>(
            "drag_handle",
            "MaterialSymbolsIcon.create(\"drag_handle\")",
            tagIcons::drag_handle_text));
    icons.add(
        new IconCatalogEntry<>(
            "draw", "MaterialSymbolsIcon.create(\"draw\")", tagIcons::draw_text));
    icons.add(
        new IconCatalogEntry<>(
            "draw_abstract",
            "MaterialSymbolsIcon.create(\"draw_abstract\")",
            tagIcons::draw_abstract_text));
    icons.add(
        new IconCatalogEntry<>(
            "draw_collage",
            "MaterialSymbolsIcon.create(\"draw_collage\")",
            tagIcons::draw_collage_text));
    icons.add(
        new IconCatalogEntry<>(
            "drive_export",
            "MaterialSymbolsIcon.create(\"drive_export\")",
            tagIcons::drive_export_text));
    icons.add(
        new IconCatalogEntry<>(
            "drive_file_move",
            "MaterialSymbolsIcon.create(\"drive_file_move\")",
            tagIcons::drive_file_move_text));
    icons.add(
        new IconCatalogEntry<>(
            "drive_file_rename",
            "MaterialSymbolsIcon.create(\"drive_file_rename\")",
            tagIcons::drive_file_rename_text));
    icons.add(
        new IconCatalogEntry<>(
            "drive_folder_upload",
            "MaterialSymbolsIcon.create(\"drive_folder_upload\")",
            tagIcons::drive_folder_upload_text));
    icons.add(
        new IconCatalogEntry<>(
            "edit_document",
            "MaterialSymbolsIcon.create(\"edit_document\")",
            tagIcons::edit_document_text));
    icons.add(
        new IconCatalogEntry<>(
            "edit_line", "MaterialSymbolsIcon.create(\"edit_line\")", tagIcons::edit_line_text));
    icons.add(
        new IconCatalogEntry<>(
            "edit_note", "MaterialSymbolsIcon.create(\"edit_note\")", tagIcons::edit_note_text));
    icons.add(
        new IconCatalogEntry<>(
            "edit_off", "MaterialSymbolsIcon.create(\"edit_off\")", tagIcons::edit_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "equal", "MaterialSymbolsIcon.create(\"equal\")", tagIcons::equal_text));
    icons.add(
        new IconCatalogEntry<>(
            "eraser_size_1",
            "MaterialSymbolsIcon.create(\"eraser_size_1\")",
            tagIcons::eraser_size_1_text));
    icons.add(
        new IconCatalogEntry<>(
            "eraser_size_2",
            "MaterialSymbolsIcon.create(\"eraser_size_2\")",
            tagIcons::eraser_size_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "eraser_size_3",
            "MaterialSymbolsIcon.create(\"eraser_size_3\")",
            tagIcons::eraser_size_3_text));
    icons.add(
        new IconCatalogEntry<>(
            "eraser_size_4",
            "MaterialSymbolsIcon.create(\"eraser_size_4\")",
            tagIcons::eraser_size_4_text));
    icons.add(
        new IconCatalogEntry<>(
            "eraser_size_5",
            "MaterialSymbolsIcon.create(\"eraser_size_5\")",
            tagIcons::eraser_size_5_text));
    icons.add(
        new IconCatalogEntry<>(
            "export_notes",
            "MaterialSymbolsIcon.create(\"export_notes\")",
            tagIcons::export_notes_text));
    icons.add(
        new IconCatalogEntry<>(
            "fact_check", "MaterialSymbolsIcon.create(\"fact_check\")", tagIcons::fact_check_text));
    icons.add(
        new IconCatalogEntry<>(
            "file_copy", "MaterialSymbolsIcon.create(\"file_copy\")", tagIcons::file_copy_text));
    icons.add(
        new IconCatalogEntry<>(
            "file_copy_off",
            "MaterialSymbolsIcon.create(\"file_copy_off\")",
            tagIcons::file_copy_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "file_present",
            "MaterialSymbolsIcon.create(\"file_present\")",
            tagIcons::file_present_text));
    icons.add(
        new IconCatalogEntry<>(
            "file_save", "MaterialSymbolsIcon.create(\"file_save\")", tagIcons::file_save_text));
    icons.add(
        new IconCatalogEntry<>(
            "file_save_off",
            "MaterialSymbolsIcon.create(\"file_save_off\")",
            tagIcons::file_save_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "files", "MaterialSymbolsIcon.create(\"files\")", tagIcons::files_text));
    icons.add(
        new IconCatalogEntry<>(
            "filter_cancel",
            "MaterialSymbolsIcon.create(\"filter_cancel\")",
            tagIcons::filter_cancel_text));
    icons.add(
        new IconCatalogEntry<>(
            "filter_plus",
            "MaterialSymbolsIcon.create(\"filter_plus\")",
            tagIcons::filter_plus_text));
    icons.add(
        new IconCatalogEntry<>(
            "finance_chip",
            "MaterialSymbolsIcon.create(\"finance_chip\")",
            tagIcons::finance_chip_text));
    icons.add(
        new IconCatalogEntry<>(
            "find_in_page",
            "MaterialSymbolsIcon.create(\"find_in_page\")",
            tagIcons::find_in_page_text));
    icons.add(
        new IconCatalogEntry<>(
            "fit_page", "MaterialSymbolsIcon.create(\"fit_page\")", tagIcons::fit_page_text));
    icons.add(
        new IconCatalogEntry<>(
            "fit_page_height",
            "MaterialSymbolsIcon.create(\"fit_page_height\")",
            tagIcons::fit_page_height_text));
    icons.add(
        new IconCatalogEntry<>(
            "fit_page_width",
            "MaterialSymbolsIcon.create(\"fit_page_width\")",
            tagIcons::fit_page_width_text));
    icons.add(
        new IconCatalogEntry<>(
            "fit_width", "MaterialSymbolsIcon.create(\"fit_width\")", tagIcons::fit_width_text));
    icons.add(
        new IconCatalogEntry<>(
            "flex_direction",
            "MaterialSymbolsIcon.create(\"flex_direction\")",
            tagIcons::flex_direction_text));
    icons.add(
        new IconCatalogEntry<>(
            "flex_no_wrap",
            "MaterialSymbolsIcon.create(\"flex_no_wrap\")",
            tagIcons::flex_no_wrap_text));
    icons.add(
        new IconCatalogEntry<>(
            "flex_wrap", "MaterialSymbolsIcon.create(\"flex_wrap\")", tagIcons::flex_wrap_text));
    icons.add(
        new IconCatalogEntry<>(
            "flip_to_back",
            "MaterialSymbolsIcon.create(\"flip_to_back\")",
            tagIcons::flip_to_back_text));
    icons.add(
        new IconCatalogEntry<>(
            "flip_to_front",
            "MaterialSymbolsIcon.create(\"flip_to_front\")",
            tagIcons::flip_to_front_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder", "MaterialSymbolsIcon.create(\"folder\")", tagIcons::folder_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_check",
            "MaterialSymbolsIcon.create(\"folder_check\")",
            tagIcons::folder_check_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_check_2",
            "MaterialSymbolsIcon.create(\"folder_check_2\")",
            tagIcons::folder_check_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_code",
            "MaterialSymbolsIcon.create(\"folder_code\")",
            tagIcons::folder_code_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_copy",
            "MaterialSymbolsIcon.create(\"folder_copy\")",
            tagIcons::folder_copy_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_data",
            "MaterialSymbolsIcon.create(\"folder_data\")",
            tagIcons::folder_data_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_delete",
            "MaterialSymbolsIcon.create(\"folder_delete\")",
            tagIcons::folder_delete_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_eye", "MaterialSymbolsIcon.create(\"folder_eye\")", tagIcons::folder_eye_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_info",
            "MaterialSymbolsIcon.create(\"folder_info\")",
            tagIcons::folder_info_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_limited",
            "MaterialSymbolsIcon.create(\"folder_limited\")",
            tagIcons::folder_limited_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_managed",
            "MaterialSymbolsIcon.create(\"folder_managed\")",
            tagIcons::folder_managed_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_match",
            "MaterialSymbolsIcon.create(\"folder_match\")",
            tagIcons::folder_match_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_off", "MaterialSymbolsIcon.create(\"folder_off\")", tagIcons::folder_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_open",
            "MaterialSymbolsIcon.create(\"folder_open\")",
            tagIcons::folder_open_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_shared",
            "MaterialSymbolsIcon.create(\"folder_shared\")",
            tagIcons::folder_shared_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_special",
            "MaterialSymbolsIcon.create(\"folder_special\")",
            tagIcons::folder_special_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_supervised",
            "MaterialSymbolsIcon.create(\"folder_supervised\")",
            tagIcons::folder_supervised_text));
    icons.add(
        new IconCatalogEntry<>(
            "folder_zip", "MaterialSymbolsIcon.create(\"folder_zip\")", tagIcons::folder_zip_text));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "font_download",
            "MaterialSymbolsIcon.create(\"font_download\")",
            tagIcons::font_download_text));
    icons.add(
        new IconCatalogEntry<>(
            "font_download_off",
            "MaterialSymbolsIcon.create(\"font_download_off\")",
            tagIcons::font_download_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_align_center",
            "MaterialSymbolsIcon.create(\"format_align_center\")",
            tagIcons::format_align_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_align_justify",
            "MaterialSymbolsIcon.create(\"format_align_justify\")",
            tagIcons::format_align_justify_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_align_left",
            "MaterialSymbolsIcon.create(\"format_align_left\")",
            tagIcons::format_align_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_align_right",
            "MaterialSymbolsIcon.create(\"format_align_right\")",
            tagIcons::format_align_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_bold",
            "MaterialSymbolsIcon.create(\"format_bold\")",
            tagIcons::format_bold_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_clear",
            "MaterialSymbolsIcon.create(\"format_clear\")",
            tagIcons::format_clear_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_color_fill",
            "MaterialSymbolsIcon.create(\"format_color_fill\")",
            tagIcons::format_color_fill_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_color_reset",
            "MaterialSymbolsIcon.create(\"format_color_reset\")",
            tagIcons::format_color_reset_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_color_text",
            "MaterialSymbolsIcon.create(\"format_color_text\")",
            tagIcons::format_color_text_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h1", "MaterialSymbolsIcon.create(\"format_h1\")", tagIcons::format_h1_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h2", "MaterialSymbolsIcon.create(\"format_h2\")", tagIcons::format_h2_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h3", "MaterialSymbolsIcon.create(\"format_h3\")", tagIcons::format_h3_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h4", "MaterialSymbolsIcon.create(\"format_h4\")", tagIcons::format_h4_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h5", "MaterialSymbolsIcon.create(\"format_h5\")", tagIcons::format_h5_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_h6", "MaterialSymbolsIcon.create(\"format_h6\")", tagIcons::format_h6_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_back",
            "MaterialSymbolsIcon.create(\"format_image_back\")",
            tagIcons::format_image_back_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_break_left",
            "MaterialSymbolsIcon.create(\"format_image_break_left\")",
            tagIcons::format_image_break_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_break_right",
            "MaterialSymbolsIcon.create(\"format_image_break_right\")",
            tagIcons::format_image_break_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_front",
            "MaterialSymbolsIcon.create(\"format_image_front\")",
            tagIcons::format_image_front_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_inline_left",
            "MaterialSymbolsIcon.create(\"format_image_inline_left\")",
            tagIcons::format_image_inline_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_inline_right",
            "MaterialSymbolsIcon.create(\"format_image_inline_right\")",
            tagIcons::format_image_inline_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_left",
            "MaterialSymbolsIcon.create(\"format_image_left\")",
            tagIcons::format_image_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_image_right",
            "MaterialSymbolsIcon.create(\"format_image_right\")",
            tagIcons::format_image_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_indent_decrease",
            "MaterialSymbolsIcon.create(\"format_indent_decrease\")",
            tagIcons::format_indent_decrease_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_indent_increase",
            "MaterialSymbolsIcon.create(\"format_indent_increase\")",
            tagIcons::format_indent_increase_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_ink_highlighter",
            "MaterialSymbolsIcon.create(\"format_ink_highlighter\")",
            tagIcons::format_ink_highlighter_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_italic",
            "MaterialSymbolsIcon.create(\"format_italic\")",
            tagIcons::format_italic_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_letter_spacing",
            "MaterialSymbolsIcon.create(\"format_letter_spacing\")",
            tagIcons::format_letter_spacing_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_letter_spacing_2",
            "MaterialSymbolsIcon.create(\"format_letter_spacing_2\")",
            tagIcons::format_letter_spacing_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_letter_spacing_standard",
            "MaterialSymbolsIcon.create(\"format_letter_spacing_standard\")",
            tagIcons::format_letter_spacing_standard_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_letter_spacing_wide",
            "MaterialSymbolsIcon.create(\"format_letter_spacing_wide\")",
            tagIcons::format_letter_spacing_wide_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_letter_spacing_wider",
            "MaterialSymbolsIcon.create(\"format_letter_spacing_wider\")",
            tagIcons::format_letter_spacing_wider_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_line_spacing",
            "MaterialSymbolsIcon.create(\"format_line_spacing\")",
            tagIcons::format_line_spacing_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_list_bulleted",
            "MaterialSymbolsIcon.create(\"format_list_bulleted\")",
            tagIcons::format_list_bulleted_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_list_bulleted_add",
            "MaterialSymbolsIcon.create(\"format_list_bulleted_add\")",
            tagIcons::format_list_bulleted_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_list_numbered",
            "MaterialSymbolsIcon.create(\"format_list_numbered\")",
            tagIcons::format_list_numbered_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_list_numbered_rtl",
            "MaterialSymbolsIcon.create(\"format_list_numbered_rtl\")",
            tagIcons::format_list_numbered_rtl_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_overline",
            "MaterialSymbolsIcon.create(\"format_overline\")",
            tagIcons::format_overline_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_paint",
            "MaterialSymbolsIcon.create(\"format_paint\")",
            tagIcons::format_paint_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_paint_off",
            "MaterialSymbolsIcon.create(\"format_paint_off\")",
            tagIcons::format_paint_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_paragraph",
            "MaterialSymbolsIcon.create(\"format_paragraph\")",
            tagIcons::format_paragraph_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_quote",
            "MaterialSymbolsIcon.create(\"format_quote\")",
            tagIcons::format_quote_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_quote_off",
            "MaterialSymbolsIcon.create(\"format_quote_off\")",
            tagIcons::format_quote_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_shapes",
            "MaterialSymbolsIcon.create(\"format_shapes\")",
            tagIcons::format_shapes_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_size",
            "MaterialSymbolsIcon.create(\"format_size\")",
            tagIcons::format_size_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_strikethrough",
            "MaterialSymbolsIcon.create(\"format_strikethrough\")",
            tagIcons::format_strikethrough_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_text_clip",
            "MaterialSymbolsIcon.create(\"format_text_clip\")",
            tagIcons::format_text_clip_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_text_overflow",
            "MaterialSymbolsIcon.create(\"format_text_overflow\")",
            tagIcons::format_text_overflow_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_text_wrap",
            "MaterialSymbolsIcon.create(\"format_text_wrap\")",
            tagIcons::format_text_wrap_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_textdirection_l_to_r",
            "MaterialSymbolsIcon.create(\"format_textdirection_l_to_r\")",
            tagIcons::format_textdirection_l_to_r_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_textdirection_r_to_l",
            "MaterialSymbolsIcon.create(\"format_textdirection_r_to_l\")",
            tagIcons::format_textdirection_r_to_l_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_textdirection_vertical",
            "MaterialSymbolsIcon.create(\"format_textdirection_vertical\")",
            tagIcons::format_textdirection_vertical_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_underlined",
            "MaterialSymbolsIcon.create(\"format_underlined\")",
            tagIcons::format_underlined_text));
    icons.add(
        new IconCatalogEntry<>(
            "format_underlined_squiggle",
            "MaterialSymbolsIcon.create(\"format_underlined_squiggle\")",
            tagIcons::format_underlined_squiggle_text));
    icons.add(
        new IconCatalogEntry<>(
            "forms_add_on",
            "MaterialSymbolsIcon.create(\"forms_add_on\")",
            tagIcons::forms_add_on_text));
    icons.add(
        new IconCatalogEntry<>(
            "forms_apps_script",
            "MaterialSymbolsIcon.create(\"forms_apps_script\")",
            tagIcons::forms_apps_script_text));
    icons.add(
        new IconCatalogEntry<>(
            "frame_inspect",
            "MaterialSymbolsIcon.create(\"frame_inspect\")",
            tagIcons::frame_inspect_text));
    icons.add(
        new IconCatalogEntry<>(
            "frame_reload",
            "MaterialSymbolsIcon.create(\"frame_reload\")",
            tagIcons::frame_reload_text));
    icons.add(
        new IconCatalogEntry<>(
            "frame_source",
            "MaterialSymbolsIcon.create(\"frame_source\")",
            tagIcons::frame_source_text));
    icons.add(
        new IconCatalogEntry<>(
            "full_coverage",
            "MaterialSymbolsIcon.create(\"full_coverage\")",
            tagIcons::full_coverage_text));
    icons.add(
        new IconCatalogEntry<>(
            "function", "MaterialSymbolsIcon.create(\"function\")", tagIcons::function_text));
    icons.add(
        new IconCatalogEntry<>(
            "function_search",
            "MaterialSymbolsIcon.create(\"function_search\")",
            tagIcons::function_search_text));
    icons.add(
        new IconCatalogEntry<>(
            "functions", "MaterialSymbolsIcon.create(\"functions\")", tagIcons::functions_text));
    icons.add(
        new IconCatalogEntry<>(
            "glyphs", "MaterialSymbolsIcon.create(\"glyphs\")", tagIcons::glyphs_text));
    icons.add(
        new IconCatalogEntry<>(
            "grading", "MaterialSymbolsIcon.create(\"grading\")", tagIcons::grading_text));
    icons.add(
        new IconCatalogEntry<>(
            "grid_guides",
            "MaterialSymbolsIcon.create(\"grid_guides\")",
            tagIcons::grid_guides_text));
    icons.add(
        new IconCatalogEntry<>(
            "grid_layout_side",
            "MaterialSymbolsIcon.create(\"grid_layout_side\")",
            tagIcons::grid_layout_side_text));
    icons.add(
        new IconCatalogEntry<>(
            "grid_view", "MaterialSymbolsIcon.create(\"grid_view\")", tagIcons::grid_view_text));
    icons.add(
        new IconCatalogEntry<>(
            "group_eye", "MaterialSymbolsIcon.create(\"group_eye\")", tagIcons::group_eye_text));
    icons.add(
        new IconCatalogEntry<>(
            "heap_snapshot_large",
            "MaterialSymbolsIcon.create(\"heap_snapshot_large\")",
            tagIcons::heap_snapshot_large_text));
    icons.add(
        new IconCatalogEntry<>(
            "heap_snapshot_multiple",
            "MaterialSymbolsIcon.create(\"heap_snapshot_multiple\")",
            tagIcons::heap_snapshot_multiple_text));
    icons.add(
        new IconCatalogEntry<>(
            "heap_snapshot_thumbnail",
            "MaterialSymbolsIcon.create(\"heap_snapshot_thumbnail\")",
            tagIcons::heap_snapshot_thumbnail_text));
    icons.add(
        new IconCatalogEntry<>(
            "height", "MaterialSymbolsIcon.create(\"height\")", tagIcons::height_text));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon", "MaterialSymbolsIcon.create(\"hexagon\")", tagIcons::hexagon_text));
    icons.add(
        new IconCatalogEntry<>(
            "highlighter_size_1",
            "MaterialSymbolsIcon.create(\"highlighter_size_1\")",
            tagIcons::highlighter_size_1_text));
    icons.add(
        new IconCatalogEntry<>(
            "highlighter_size_2",
            "MaterialSymbolsIcon.create(\"highlighter_size_2\")",
            tagIcons::highlighter_size_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "highlighter_size_3",
            "MaterialSymbolsIcon.create(\"highlighter_size_3\")",
            tagIcons::highlighter_size_3_text));
    icons.add(
        new IconCatalogEntry<>(
            "highlighter_size_4",
            "MaterialSymbolsIcon.create(\"highlighter_size_4\")",
            tagIcons::highlighter_size_4_text));
    icons.add(
        new IconCatalogEntry<>(
            "highlighter_size_5",
            "MaterialSymbolsIcon.create(\"highlighter_size_5\")",
            tagIcons::highlighter_size_5_text));
    icons.add(
        new IconCatalogEntry<>(
            "history_edu",
            "MaterialSymbolsIcon.create(\"history_edu\")",
            tagIcons::history_edu_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_align_center",
            "MaterialSymbolsIcon.create(\"horizontal_align_center\")",
            tagIcons::horizontal_align_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_align_left",
            "MaterialSymbolsIcon.create(\"horizontal_align_left\")",
            tagIcons::horizontal_align_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_align_right",
            "MaterialSymbolsIcon.create(\"horizontal_align_right\")",
            tagIcons::horizontal_align_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_distribute",
            "MaterialSymbolsIcon.create(\"horizontal_distribute\")",
            tagIcons::horizontal_distribute_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_rule",
            "MaterialSymbolsIcon.create(\"horizontal_rule\")",
            tagIcons::horizontal_rule_text));
    icons.add(
        new IconCatalogEntry<>(
            "horizontal_split",
            "MaterialSymbolsIcon.create(\"horizontal_split\")",
            tagIcons::horizontal_split_text));
    icons.add(
        new IconCatalogEntry<>(
            "imagesearch_roller",
            "MaterialSymbolsIcon.create(\"imagesearch_roller\")",
            tagIcons::imagesearch_roller_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_eraser", "MaterialSymbolsIcon.create(\"ink_eraser\")", tagIcons::ink_eraser_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_eraser_off",
            "MaterialSymbolsIcon.create(\"ink_eraser_off\")",
            tagIcons::ink_eraser_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_highlighter",
            "MaterialSymbolsIcon.create(\"ink_highlighter\")",
            tagIcons::ink_highlighter_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_highlighter_move",
            "MaterialSymbolsIcon.create(\"ink_highlighter_move\")",
            tagIcons::ink_highlighter_move_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_highlighter_off",
            "MaterialSymbolsIcon.create(\"ink_highlighter_off\")",
            tagIcons::ink_highlighter_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_marker", "MaterialSymbolsIcon.create(\"ink_marker\")", tagIcons::ink_marker_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_pen", "MaterialSymbolsIcon.create(\"ink_pen\")", tagIcons::ink_pen_text));
    icons.add(
        new IconCatalogEntry<>(
            "ink_selection",
            "MaterialSymbolsIcon.create(\"ink_selection\")",
            tagIcons::ink_selection_text));
    icons.add(
        new IconCatalogEntry<>(
            "insert_page_break",
            "MaterialSymbolsIcon.create(\"insert_page_break\")",
            tagIcons::insert_page_break_text));
    icons.add(
        new IconCatalogEntry<>(
            "insert_text",
            "MaterialSymbolsIcon.create(\"insert_text\")",
            tagIcons::insert_text_text));
    icons.add(
        new IconCatalogEntry<>(
            "integration_instructions",
            "MaterialSymbolsIcon.create(\"integration_instructions\")",
            tagIcons::integration_instructions_text));
  }

  private static void addIcons3() {
    icons.add(
        new IconCatalogEntry<>(
            "inventory", "MaterialSymbolsIcon.create(\"inventory\")", tagIcons::inventory_text));
    icons.add(
        new IconCatalogEntry<>(
            "join", "MaterialSymbolsIcon.create(\"join\")", tagIcons::join_text));
    icons.add(
        new IconCatalogEntry<>(
            "join_inner", "MaterialSymbolsIcon.create(\"join_inner\")", tagIcons::join_inner_text));
    icons.add(
        new IconCatalogEntry<>(
            "join_left", "MaterialSymbolsIcon.create(\"join_left\")", tagIcons::join_left_text));
    icons.add(
        new IconCatalogEntry<>(
            "join_right", "MaterialSymbolsIcon.create(\"join_right\")", tagIcons::join_right_text));
    icons.add(
        new IconCatalogEntry<>(
            "lab_profile",
            "MaterialSymbolsIcon.create(\"lab_profile\")",
            tagIcons::lab_profile_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_array",
            "MaterialSymbolsIcon.create(\"language_chinese_array\")",
            tagIcons::language_chinese_array_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_cangjie",
            "MaterialSymbolsIcon.create(\"language_chinese_cangjie\")",
            tagIcons::language_chinese_cangjie_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_dayi",
            "MaterialSymbolsIcon.create(\"language_chinese_dayi\")",
            tagIcons::language_chinese_dayi_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_pinyin",
            "MaterialSymbolsIcon.create(\"language_chinese_pinyin\")",
            tagIcons::language_chinese_pinyin_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_quick",
            "MaterialSymbolsIcon.create(\"language_chinese_quick\")",
            tagIcons::language_chinese_quick_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_chinese_wubi",
            "MaterialSymbolsIcon.create(\"language_chinese_wubi\")",
            tagIcons::language_chinese_wubi_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_french",
            "MaterialSymbolsIcon.create(\"language_french\")",
            tagIcons::language_french_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_gb_english",
            "MaterialSymbolsIcon.create(\"language_gb_english\")",
            tagIcons::language_gb_english_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_international",
            "MaterialSymbolsIcon.create(\"language_international\")",
            tagIcons::language_international_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_japanese_kana",
            "MaterialSymbolsIcon.create(\"language_japanese_kana\")",
            tagIcons::language_japanese_kana_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_korean_latin",
            "MaterialSymbolsIcon.create(\"language_korean_latin\")",
            tagIcons::language_korean_latin_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_pinyin",
            "MaterialSymbolsIcon.create(\"language_pinyin\")",
            tagIcons::language_pinyin_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_spanish",
            "MaterialSymbolsIcon.create(\"language_spanish\")",
            tagIcons::language_spanish_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_us",
            "MaterialSymbolsIcon.create(\"language_us\")",
            tagIcons::language_us_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_us_colemak",
            "MaterialSymbolsIcon.create(\"language_us_colemak\")",
            tagIcons::language_us_colemak_text));
    icons.add(
        new IconCatalogEntry<>(
            "language_us_dvorak",
            "MaterialSymbolsIcon.create(\"language_us_dvorak\")",
            tagIcons::language_us_dvorak_text));
    icons.add(
        new IconCatalogEntry<>(
            "lasso_select",
            "MaterialSymbolsIcon.create(\"lasso_select\")",
            tagIcons::lasso_select_text));
    icons.add(
        new IconCatalogEntry<>(
            "letter_switch",
            "MaterialSymbolsIcon.create(\"letter_switch\")",
            tagIcons::letter_switch_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_axis", "MaterialSymbolsIcon.create(\"line_axis\")", tagIcons::line_axis_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_curve", "MaterialSymbolsIcon.create(\"line_curve\")", tagIcons::line_curve_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end", "MaterialSymbolsIcon.create(\"line_end\")", tagIcons::line_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end_arrow",
            "MaterialSymbolsIcon.create(\"line_end_arrow\")",
            tagIcons::line_end_arrow_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end_arrow_notch",
            "MaterialSymbolsIcon.create(\"line_end_arrow_notch\")",
            tagIcons::line_end_arrow_notch_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end_circle",
            "MaterialSymbolsIcon.create(\"line_end_circle\")",
            tagIcons::line_end_circle_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end_diamond",
            "MaterialSymbolsIcon.create(\"line_end_diamond\")",
            tagIcons::line_end_diamond_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_end_square",
            "MaterialSymbolsIcon.create(\"line_end_square\")",
            tagIcons::line_end_square_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start", "MaterialSymbolsIcon.create(\"line_start\")", tagIcons::line_start_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start_arrow",
            "MaterialSymbolsIcon.create(\"line_start_arrow\")",
            tagIcons::line_start_arrow_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start_arrow_notch",
            "MaterialSymbolsIcon.create(\"line_start_arrow_notch\")",
            tagIcons::line_start_arrow_notch_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start_circle",
            "MaterialSymbolsIcon.create(\"line_start_circle\")",
            tagIcons::line_start_circle_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start_diamond",
            "MaterialSymbolsIcon.create(\"line_start_diamond\")",
            tagIcons::line_start_diamond_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_start_square",
            "MaterialSymbolsIcon.create(\"line_start_square\")",
            tagIcons::line_start_square_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_style", "MaterialSymbolsIcon.create(\"line_style\")", tagIcons::line_style_text));
    icons.add(
        new IconCatalogEntry<>(
            "line_weight",
            "MaterialSymbolsIcon.create(\"line_weight\")",
            tagIcons::line_weight_text));
    icons.add(
        new IconCatalogEntry<>(
            "linear_scale",
            "MaterialSymbolsIcon.create(\"linear_scale\")",
            tagIcons::linear_scale_text));
    icons.add(
        new IconCatalogEntry<>(
            "list", "MaterialSymbolsIcon.create(\"list\")", tagIcons::list_text));
    icons.add(
        new IconCatalogEntry<>(
            "list_2", "MaterialSymbolsIcon.create(\"list_2\")", tagIcons::list_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "list_alt", "MaterialSymbolsIcon.create(\"list_alt\")", tagIcons::list_alt_text));
    icons.add(
        new IconCatalogEntry<>(
            "list_alt_add",
            "MaterialSymbolsIcon.create(\"list_alt_add\")",
            tagIcons::list_alt_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "list_alt_check",
            "MaterialSymbolsIcon.create(\"list_alt_check\")",
            tagIcons::list_alt_check_text));
    icons.add(
        new IconCatalogEntry<>(
            "list_arrow", "MaterialSymbolsIcon.create(\"list_arrow\")", tagIcons::list_arrow_text));
    icons.add(
        new IconCatalogEntry<>(
            "location_chip",
            "MaterialSymbolsIcon.create(\"location_chip\")",
            tagIcons::location_chip_text));
    icons.add(
        new IconCatalogEntry<>(
            "low_priority",
            "MaterialSymbolsIcon.create(\"low_priority\")",
            tagIcons::low_priority_text));
    icons.add(
        new IconCatalogEntry<>(
            "lowercase", "MaterialSymbolsIcon.create(\"lowercase\")", tagIcons::lowercase_text));
    icons.add(
        new IconCatalogEntry<>(
            "margin", "MaterialSymbolsIcon.create(\"margin\")", tagIcons::margin_text));
    icons.add(
        new IconCatalogEntry<>(
            "markdown", "MaterialSymbolsIcon.create(\"markdown\")", tagIcons::markdown_text));
    icons.add(
        new IconCatalogEntry<>(
            "markdown_convert",
            "MaterialSymbolsIcon.create(\"markdown_convert\")",
            tagIcons::markdown_convert_text));
    icons.add(
        new IconCatalogEntry<>(
            "markdown_copy",
            "MaterialSymbolsIcon.create(\"markdown_copy\")",
            tagIcons::markdown_copy_text));
    icons.add(
        new IconCatalogEntry<>(
            "markdown_document",
            "MaterialSymbolsIcon.create(\"markdown_document\")",
            tagIcons::markdown_document_text));
    icons.add(
        new IconCatalogEntry<>(
            "markdown_paste",
            "MaterialSymbolsIcon.create(\"markdown_paste\")",
            tagIcons::markdown_paste_text));
    icons.add(
        new IconCatalogEntry<>(
            "match_case", "MaterialSymbolsIcon.create(\"match_case\")", tagIcons::match_case_text));
    icons.add(
        new IconCatalogEntry<>(
            "match_case_off",
            "MaterialSymbolsIcon.create(\"match_case_off\")",
            tagIcons::match_case_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "match_word", "MaterialSymbolsIcon.create(\"match_word\")", tagIcons::match_word_text));
    icons.add(
        new IconCatalogEntry<>(
            "menu_book", "MaterialSymbolsIcon.create(\"menu_book\")", tagIcons::menu_book_text));
    icons.add(
        new IconCatalogEntry<>(
            "merge_type", "MaterialSymbolsIcon.create(\"merge_type\")", tagIcons::merge_type_text));
    icons.add(
        new IconCatalogEntry<>(
            "news", "MaterialSymbolsIcon.create(\"news\")", tagIcons::news_text));
    icons.add(
        new IconCatalogEntry<>(
            "newsmode", "MaterialSymbolsIcon.create(\"newsmode\")", tagIcons::newsmode_text));
    icons.add(
        new IconCatalogEntry<>(
            "newspaper", "MaterialSymbolsIcon.create(\"newspaper\")", tagIcons::newspaper_text));
    icons.add(
        new IconCatalogEntry<>(
            "note_add", "MaterialSymbolsIcon.create(\"note_add\")", tagIcons::note_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "note_alt", "MaterialSymbolsIcon.create(\"note_alt\")", tagIcons::note_alt_text));
    icons.add(
        new IconCatalogEntry<>(
            "note_stack", "MaterialSymbolsIcon.create(\"note_stack\")", tagIcons::note_stack_text));
    icons.add(
        new IconCatalogEntry<>(
            "note_stack_add",
            "MaterialSymbolsIcon.create(\"note_stack_add\")",
            tagIcons::note_stack_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "notes", "MaterialSymbolsIcon.create(\"notes\")", tagIcons::notes_text));
    icons.add(
        new IconCatalogEntry<>(
            "numbers", "MaterialSymbolsIcon.create(\"numbers\")", tagIcons::numbers_text));
    icons.add(
        new IconCatalogEntry<>(
            "other_admission",
            "MaterialSymbolsIcon.create(\"other_admission\")",
            tagIcons::other_admission_text));
    icons.add(
        new IconCatalogEntry<>(
            "overview", "MaterialSymbolsIcon.create(\"overview\")", tagIcons::overview_text));
    icons.add(
        new IconCatalogEntry<>(
            "padding", "MaterialSymbolsIcon.create(\"padding\")", tagIcons::padding_text));
    icons.add(
        new IconCatalogEntry<>(
            "page_footer",
            "MaterialSymbolsIcon.create(\"page_footer\")",
            tagIcons::page_footer_text));
    icons.add(
        new IconCatalogEntry<>(
            "page_header",
            "MaterialSymbolsIcon.create(\"page_header\")",
            tagIcons::page_header_text));
    icons.add(
        new IconCatalogEntry<>(
            "pageless", "MaterialSymbolsIcon.create(\"pageless\")", tagIcons::pageless_text));
    icons.add(
        new IconCatalogEntry<>(
            "pages", "MaterialSymbolsIcon.create(\"pages\")", tagIcons::pages_text));
    icons.add(
        new IconCatalogEntry<>(
            "pen_size_1", "MaterialSymbolsIcon.create(\"pen_size_1\")", tagIcons::pen_size_1_text));
    icons.add(
        new IconCatalogEntry<>(
            "pen_size_2", "MaterialSymbolsIcon.create(\"pen_size_2\")", tagIcons::pen_size_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "pen_size_3", "MaterialSymbolsIcon.create(\"pen_size_3\")", tagIcons::pen_size_3_text));
    icons.add(
        new IconCatalogEntry<>(
            "pen_size_4", "MaterialSymbolsIcon.create(\"pen_size_4\")", tagIcons::pen_size_4_text));
    icons.add(
        new IconCatalogEntry<>(
            "pen_size_5", "MaterialSymbolsIcon.create(\"pen_size_5\")", tagIcons::pen_size_5_text));
    icons.add(
        new IconCatalogEntry<>(
            "pending_actions",
            "MaterialSymbolsIcon.create(\"pending_actions\")",
            tagIcons::pending_actions_text));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon", "MaterialSymbolsIcon.create(\"pentagon\")", tagIcons::pentagon_text));
    icons.add(
        new IconCatalogEntry<>(
            "percent", "MaterialSymbolsIcon.create(\"percent\")", tagIcons::percent_text));
    icons.add(
        new IconCatalogEntry<>(
            "perm_media", "MaterialSymbolsIcon.create(\"perm_media\")", tagIcons::perm_media_text));
    icons.add(
        new IconCatalogEntry<>(
            "person_book",
            "MaterialSymbolsIcon.create(\"person_book\")",
            tagIcons::person_book_text));
    icons.add(
        new IconCatalogEntry<>(
            "person_eye", "MaterialSymbolsIcon.create(\"person_eye\")", tagIcons::person_eye_text));
    icons.add(
        new IconCatalogEntry<>(
            "pivot_table_chart",
            "MaterialSymbolsIcon.create(\"pivot_table_chart\")",
            tagIcons::pivot_table_chart_text));
    icons.add(
        new IconCatalogEntry<>(
            "plagiarism", "MaterialSymbolsIcon.create(\"plagiarism\")", tagIcons::plagiarism_text));
    icons.add(
        new IconCatalogEntry<>(
            "polyline", "MaterialSymbolsIcon.create(\"polyline\")", tagIcons::polyline_text));
    icons.add(
        new IconCatalogEntry<>(
            "post", "MaterialSymbolsIcon.create(\"post\")", tagIcons::post_text));
    icons.add(
        new IconCatalogEntry<>(
            "post_add", "MaterialSymbolsIcon.create(\"post_add\")", tagIcons::post_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "process_chart",
            "MaterialSymbolsIcon.create(\"process_chart\")",
            tagIcons::process_chart_text));
    icons.add(
        new IconCatalogEntry<>(
            "read_more", "MaterialSymbolsIcon.create(\"read_more\")", tagIcons::read_more_text));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle", "MaterialSymbolsIcon.create(\"rectangle\")", tagIcons::rectangle_text));
    icons.add(
        new IconCatalogEntry<>(
            "regular_expression",
            "MaterialSymbolsIcon.create(\"regular_expression\")",
            tagIcons::regular_expression_text));
    icons.add(
        new IconCatalogEntry<>(
            "remove_selection",
            "MaterialSymbolsIcon.create(\"remove_selection\")",
            tagIcons::remove_selection_text));
    icons.add(
        new IconCatalogEntry<>(
            "reorder", "MaterialSymbolsIcon.create(\"reorder\")", tagIcons::reorder_text));
    icons.add(
        new IconCatalogEntry<>(
            "request_page",
            "MaterialSymbolsIcon.create(\"request_page\")",
            tagIcons::request_page_text));
  }

  private static void addIcons4() {
    icons.add(
        new IconCatalogEntry<>(
            "request_quote",
            "MaterialSymbolsIcon.create(\"request_quote\")",
            tagIcons::request_quote_text));
    icons.add(
        new IconCatalogEntry<>(
            "reset_image",
            "MaterialSymbolsIcon.create(\"reset_image\")",
            tagIcons::reset_image_text));
    icons.add(
        new IconCatalogEntry<>(
            "restore_page",
            "MaterialSymbolsIcon.create(\"restore_page\")",
            tagIcons::restore_page_text));
    icons.add(
        new IconCatalogEntry<>(
            "rubric", "MaterialSymbolsIcon.create(\"rubric\")", tagIcons::rubric_text));
    icons.add(
        new IconCatalogEntry<>(
            "rule_folder",
            "MaterialSymbolsIcon.create(\"rule_folder\")",
            tagIcons::rule_folder_text));
    icons.add(
        new IconCatalogEntry<>(
            "scan", "MaterialSymbolsIcon.create(\"scan\")", tagIcons::scan_text));
    icons.add(
        new IconCatalogEntry<>(
            "scan_delete",
            "MaterialSymbolsIcon.create(\"scan_delete\")",
            tagIcons::scan_delete_text));
    icons.add(
        new IconCatalogEntry<>(
            "script", "MaterialSymbolsIcon.create(\"script\")", tagIcons::script_text));
    icons.add(
        new IconCatalogEntry<>(
            "segment", "MaterialSymbolsIcon.create(\"segment\")", tagIcons::segment_text));
    icons.add(
        new IconCatalogEntry<>(
            "select", "MaterialSymbolsIcon.create(\"select\")", tagIcons::select_text));
    icons.add(
        new IconCatalogEntry<>(
            "serif", "MaterialSymbolsIcon.create(\"serif\")", tagIcons::serif_text));
    icons.add(
        new IconCatalogEntry<>(
            "shape_line", "MaterialSymbolsIcon.create(\"shape_line\")", tagIcons::shape_line_text));
    icons.add(
        new IconCatalogEntry<>(
            "shapes", "MaterialSymbolsIcon.create(\"shapes\")", tagIcons::shapes_text));
    icons.add(
        new IconCatalogEntry<>(
            "sheets_column_swap",
            "MaterialSymbolsIcon.create(\"sheets_column_swap\")",
            tagIcons::sheets_column_swap_text));
    icons.add(
        new IconCatalogEntry<>(
            "sheets_rtl", "MaterialSymbolsIcon.create(\"sheets_rtl\")", tagIcons::sheets_rtl_text));
    icons.add(
        new IconCatalogEntry<>(
            "short_text", "MaterialSymbolsIcon.create(\"short_text\")", tagIcons::short_text_text));
    icons.add(
        new IconCatalogEntry<>(
            "signature", "MaterialSymbolsIcon.create(\"signature\")", tagIcons::signature_text));
    icons.add(
        new IconCatalogEntry<>(
            "slab_serif", "MaterialSymbolsIcon.create(\"slab_serif\")", tagIcons::slab_serif_text));
    icons.add(
        new IconCatalogEntry<>(
            "slide_library",
            "MaterialSymbolsIcon.create(\"slide_library\")",
            tagIcons::slide_library_text));
    icons.add(
        new IconCatalogEntry<>(
            "smb_share", "MaterialSymbolsIcon.create(\"smb_share\")", tagIcons::smb_share_text));
    icons.add(
        new IconCatalogEntry<>(
            "snippet_folder",
            "MaterialSymbolsIcon.create(\"snippet_folder\")",
            tagIcons::snippet_folder_text));
    icons.add(
        new IconCatalogEntry<>(
            "source_notes",
            "MaterialSymbolsIcon.create(\"source_notes\")",
            tagIcons::source_notes_text));
    icons.add(
        new IconCatalogEntry<>(
            "space_bar", "MaterialSymbolsIcon.create(\"space_bar\")", tagIcons::space_bar_text));
    icons.add(
        new IconCatalogEntry<>(
            "space_dashboard",
            "MaterialSymbolsIcon.create(\"space_dashboard\")",
            tagIcons::space_dashboard_text));
    icons.add(
        new IconCatalogEntry<>(
            "space_dashboard_2",
            "MaterialSymbolsIcon.create(\"space_dashboard_2\")",
            tagIcons::space_dashboard_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "special_character",
            "MaterialSymbolsIcon.create(\"special_character\")",
            tagIcons::special_character_text));
    icons.add(
        new IconCatalogEntry<>(
            "spellcheck", "MaterialSymbolsIcon.create(\"spellcheck\")", tagIcons::spellcheck_text));
    icons.add(
        new IconCatalogEntry<>(
            "square", "MaterialSymbolsIcon.create(\"square\")", tagIcons::square_text));
    icons.add(
        new IconCatalogEntry<>(
            "stack_hexagon",
            "MaterialSymbolsIcon.create(\"stack_hexagon\")",
            tagIcons::stack_hexagon_text));
    icons.add(
        new IconCatalogEntry<>(
            "sticky_note",
            "MaterialSymbolsIcon.create(\"sticky_note\")",
            tagIcons::sticky_note_text));
    icons.add(
        new IconCatalogEntry<>(
            "sticky_note_2",
            "MaterialSymbolsIcon.create(\"sticky_note_2\")",
            tagIcons::sticky_note_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "stock_media",
            "MaterialSymbolsIcon.create(\"stock_media\")",
            tagIcons::stock_media_text));
    icons.add(
        new IconCatalogEntry<>(
            "stroke_full",
            "MaterialSymbolsIcon.create(\"stroke_full\")",
            tagIcons::stroke_full_text));
    icons.add(
        new IconCatalogEntry<>(
            "stroke_partial",
            "MaterialSymbolsIcon.create(\"stroke_partial\")",
            tagIcons::stroke_partial_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_brush",
            "MaterialSymbolsIcon.create(\"stylus_brush\")",
            tagIcons::stylus_brush_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_fountain_pen",
            "MaterialSymbolsIcon.create(\"stylus_fountain_pen\")",
            tagIcons::stylus_fountain_pen_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_highlighter",
            "MaterialSymbolsIcon.create(\"stylus_highlighter\")",
            tagIcons::stylus_highlighter_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_laser_pointer",
            "MaterialSymbolsIcon.create(\"stylus_laser_pointer\")",
            tagIcons::stylus_laser_pointer_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_pen", "MaterialSymbolsIcon.create(\"stylus_pen\")", tagIcons::stylus_pen_text));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_pencil",
            "MaterialSymbolsIcon.create(\"stylus_pencil\")",
            tagIcons::stylus_pencil_text));
    icons.add(
        new IconCatalogEntry<>(
            "subject", "MaterialSymbolsIcon.create(\"subject\")", tagIcons::subject_text));
    icons.add(
        new IconCatalogEntry<>(
            "subscript", "MaterialSymbolsIcon.create(\"subscript\")", tagIcons::subscript_text));
    icons.add(
        new IconCatalogEntry<>(
            "subtitles_off",
            "MaterialSymbolsIcon.create(\"subtitles_off\")",
            tagIcons::subtitles_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "summarize", "MaterialSymbolsIcon.create(\"summarize\")", tagIcons::summarize_text));
    icons.add(
        new IconCatalogEntry<>(
            "superscript",
            "MaterialSymbolsIcon.create(\"superscript\")",
            tagIcons::superscript_text));
    icons.add(
        new IconCatalogEntry<>(
            "table", "MaterialSymbolsIcon.create(\"table\")", tagIcons::table_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_chart",
            "MaterialSymbolsIcon.create(\"table_chart\")",
            tagIcons::table_chart_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_chart_view",
            "MaterialSymbolsIcon.create(\"table_chart_view\")",
            tagIcons::table_chart_view_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_convert",
            "MaterialSymbolsIcon.create(\"table_convert\")",
            tagIcons::table_convert_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_edit", "MaterialSymbolsIcon.create(\"table_edit\")", tagIcons::table_edit_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_eye", "MaterialSymbolsIcon.create(\"table_eye\")", tagIcons::table_eye_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_rows", "MaterialSymbolsIcon.create(\"table_rows\")", tagIcons::table_rows_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_rows_narrow",
            "MaterialSymbolsIcon.create(\"table_rows_narrow\")",
            tagIcons::table_rows_narrow_text));
    icons.add(
        new IconCatalogEntry<>(
            "table_view", "MaterialSymbolsIcon.create(\"table_view\")", tagIcons::table_view_text));
    icons.add(
        new IconCatalogEntry<>("tag", "MaterialSymbolsIcon.create(\"tag\")", tagIcons::tag_text));
    icons.add(
        new IconCatalogEntry<>(
            "task", "MaterialSymbolsIcon.create(\"task\")", tagIcons::task_text));
    icons.add(
        new IconCatalogEntry<>(
            "team_dashboard",
            "MaterialSymbolsIcon.create(\"team_dashboard\")",
            tagIcons::team_dashboard_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_ad", "MaterialSymbolsIcon.create(\"text_ad\")", tagIcons::text_ad_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_ad_off",
            "MaterialSymbolsIcon.create(\"text_ad_off\")",
            tagIcons::text_ad_off_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_compare",
            "MaterialSymbolsIcon.create(\"text_compare\")",
            tagIcons::text_compare_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_decrease",
            "MaterialSymbolsIcon.create(\"text_decrease\")",
            tagIcons::text_decrease_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_fields",
            "MaterialSymbolsIcon.create(\"text_fields\")",
            tagIcons::text_fields_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_fields_alt",
            "MaterialSymbolsIcon.create(\"text_fields_alt\")",
            tagIcons::text_fields_alt_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_format",
            "MaterialSymbolsIcon.create(\"text_format\")",
            tagIcons::text_format_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_increase",
            "MaterialSymbolsIcon.create(\"text_increase\")",
            tagIcons::text_increase_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotate_up",
            "MaterialSymbolsIcon.create(\"text_rotate_up\")",
            tagIcons::text_rotate_up_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotate_vertical",
            "MaterialSymbolsIcon.create(\"text_rotate_vertical\")",
            tagIcons::text_rotate_vertical_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotation_angledown",
            "MaterialSymbolsIcon.create(\"text_rotation_angledown\")",
            tagIcons::text_rotation_angledown_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotation_angleup",
            "MaterialSymbolsIcon.create(\"text_rotation_angleup\")",
            tagIcons::text_rotation_angleup_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotation_down",
            "MaterialSymbolsIcon.create(\"text_rotation_down\")",
            tagIcons::text_rotation_down_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_rotation_none",
            "MaterialSymbolsIcon.create(\"text_rotation_none\")",
            tagIcons::text_rotation_none_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_end",
            "MaterialSymbolsIcon.create(\"text_select_end\")",
            tagIcons::text_select_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_jump_to_beginning",
            "MaterialSymbolsIcon.create(\"text_select_jump_to_beginning\")",
            tagIcons::text_select_jump_to_beginning_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_jump_to_end",
            "MaterialSymbolsIcon.create(\"text_select_jump_to_end\")",
            tagIcons::text_select_jump_to_end_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_back_character",
            "MaterialSymbolsIcon.create(\"text_select_move_back_character\")",
            tagIcons::text_select_move_back_character_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_back_word",
            "MaterialSymbolsIcon.create(\"text_select_move_back_word\")",
            tagIcons::text_select_move_back_word_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_down",
            "MaterialSymbolsIcon.create(\"text_select_move_down\")",
            tagIcons::text_select_move_down_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_forward_character",
            "MaterialSymbolsIcon.create(\"text_select_move_forward_character\")",
            tagIcons::text_select_move_forward_character_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_forward_word",
            "MaterialSymbolsIcon.create(\"text_select_move_forward_word\")",
            tagIcons::text_select_move_forward_word_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_move_up",
            "MaterialSymbolsIcon.create(\"text_select_move_up\")",
            tagIcons::text_select_move_up_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_select_start",
            "MaterialSymbolsIcon.create(\"text_select_start\")",
            tagIcons::text_select_start_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_snippet",
            "MaterialSymbolsIcon.create(\"text_snippet\")",
            tagIcons::text_snippet_text));
    icons.add(
        new IconCatalogEntry<>(
            "text_up", "MaterialSymbolsIcon.create(\"text_up\")", tagIcons::text_up_text));
    icons.add(
        new IconCatalogEntry<>(
            "thumbnail_bar",
            "MaterialSymbolsIcon.create(\"thumbnail_bar\")",
            tagIcons::thumbnail_bar_text));
    icons.add(
        new IconCatalogEntry<>(
            "title", "MaterialSymbolsIcon.create(\"title\")", tagIcons::title_text));
    icons.add(
        new IconCatalogEntry<>(
            "titlecase", "MaterialSymbolsIcon.create(\"titlecase\")", tagIcons::titlecase_text));
    icons.add(
        new IconCatalogEntry<>("toc", "MaterialSymbolsIcon.create(\"toc\")", tagIcons::toc_text));
    icons.add(
        new IconCatalogEntry<>(
            "top_panel_close",
            "MaterialSymbolsIcon.create(\"top_panel_close\")",
            tagIcons::top_panel_close_text));
    icons.add(
        new IconCatalogEntry<>(
            "top_panel_open",
            "MaterialSymbolsIcon.create(\"top_panel_open\")",
            tagIcons::top_panel_open_text));
    icons.add(
        new IconCatalogEntry<>("tsv", "MaterialSymbolsIcon.create(\"tsv\")", tagIcons::tsv_text));
    icons.add(
        new IconCatalogEntry<>(
            "two_pager", "MaterialSymbolsIcon.create(\"two_pager\")", tagIcons::two_pager_text));
    icons.add(
        new IconCatalogEntry<>(
            "two_pager_store",
            "MaterialSymbolsIcon.create(\"two_pager_store\")",
            tagIcons::two_pager_store_text));
    icons.add(
        new IconCatalogEntry<>(
            "type_specimen",
            "MaterialSymbolsIcon.create(\"type_specimen\")",
            tagIcons::type_specimen_text));
    icons.add(
        new IconCatalogEntry<>(
            "ungroup", "MaterialSymbolsIcon.create(\"ungroup\")", tagIcons::ungroup_text));
    icons.add(
        new IconCatalogEntry<>(
            "unknown_document",
            "MaterialSymbolsIcon.create(\"unknown_document\")",
            tagIcons::unknown_document_text));
    icons.add(
        new IconCatalogEntry<>(
            "uppercase", "MaterialSymbolsIcon.create(\"uppercase\")", tagIcons::uppercase_text));
    icons.add(
        new IconCatalogEntry<>(
            "variable_add",
            "MaterialSymbolsIcon.create(\"variable_add\")",
            tagIcons::variable_add_text));
    icons.add(
        new IconCatalogEntry<>(
            "variable_insert",
            "MaterialSymbolsIcon.create(\"variable_insert\")",
            tagIcons::variable_insert_text));
    icons.add(
        new IconCatalogEntry<>(
            "variable_remove",
            "MaterialSymbolsIcon.create(\"variable_remove\")",
            tagIcons::variable_remove_text));
    icons.add(
        new IconCatalogEntry<>(
            "variables", "MaterialSymbolsIcon.create(\"variables\")", tagIcons::variables_text));
  }

  private static void addIcons5() {
    icons.add(
        new IconCatalogEntry<>(
            "vertical_align_bottom",
            "MaterialSymbolsIcon.create(\"vertical_align_bottom\")",
            tagIcons::vertical_align_bottom_text));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_align_center",
            "MaterialSymbolsIcon.create(\"vertical_align_center\")",
            tagIcons::vertical_align_center_text));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_align_top",
            "MaterialSymbolsIcon.create(\"vertical_align_top\")",
            tagIcons::vertical_align_top_text));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_distribute",
            "MaterialSymbolsIcon.create(\"vertical_distribute\")",
            tagIcons::vertical_distribute_text));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_split",
            "MaterialSymbolsIcon.create(\"vertical_split\")",
            tagIcons::vertical_split_text));
    icons.add(
        new IconCatalogEntry<>(
            "video_file", "MaterialSymbolsIcon.create(\"video_file\")", tagIcons::video_file_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_agenda",
            "MaterialSymbolsIcon.create(\"view_agenda\")",
            tagIcons::view_agenda_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_array", "MaterialSymbolsIcon.create(\"view_array\")", tagIcons::view_array_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_carousel",
            "MaterialSymbolsIcon.create(\"view_carousel\")",
            tagIcons::view_carousel_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_column",
            "MaterialSymbolsIcon.create(\"view_column\")",
            tagIcons::view_column_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_column_2",
            "MaterialSymbolsIcon.create(\"view_column_2\")",
            tagIcons::view_column_2_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_day", "MaterialSymbolsIcon.create(\"view_day\")", tagIcons::view_day_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_headline",
            "MaterialSymbolsIcon.create(\"view_headline\")",
            tagIcons::view_headline_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_list", "MaterialSymbolsIcon.create(\"view_list\")", tagIcons::view_list_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_module",
            "MaterialSymbolsIcon.create(\"view_module\")",
            tagIcons::view_module_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_object_track",
            "MaterialSymbolsIcon.create(\"view_object_track\")",
            tagIcons::view_object_track_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_quilt", "MaterialSymbolsIcon.create(\"view_quilt\")", tagIcons::view_quilt_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_sidebar",
            "MaterialSymbolsIcon.create(\"view_sidebar\")",
            tagIcons::view_sidebar_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_stream",
            "MaterialSymbolsIcon.create(\"view_stream\")",
            tagIcons::view_stream_text));
    icons.add(
        new IconCatalogEntry<>(
            "view_week", "MaterialSymbolsIcon.create(\"view_week\")", tagIcons::view_week_text));
    icons.add(
        new IconCatalogEntry<>(
            "voting_chip",
            "MaterialSymbolsIcon.create(\"voting_chip\")",
            tagIcons::voting_chip_text));
    icons.add(
        new IconCatalogEntry<>(
            "wrap_text", "MaterialSymbolsIcon.create(\"wrap_text\")", tagIcons::wrap_text_text));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
