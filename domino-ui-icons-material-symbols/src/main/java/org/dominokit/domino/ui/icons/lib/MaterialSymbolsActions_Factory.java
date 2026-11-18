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
import org.dominokit.domino.ui.icons.MaterialSymbolsActions;
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Static icon factory for the Material Symbols Actions category. */
public final class MaterialSymbolsActions_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsActions tagIcons = new MaterialSymbolsActions() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "3d_rotation", "MaterialSymbols._3d_rotation()", tagIcons::_3d_rotation_actions));
    icons.add(
        new IconCatalogEntry<>(
            "accessibility", "MaterialSymbols.accessibility()", tagIcons::accessibility_actions));
    icons.add(
        new IconCatalogEntry<>(
            "accessibility_new",
            "MaterialSymbols.accessibility_new()",
            tagIcons::accessibility_new_actions));
    icons.add(
        new IconCatalogEntry<>(
            "accessible", "MaterialSymbols.accessible()", tagIcons::accessible_actions));
    icons.add(
        new IconCatalogEntry<>(
            "accessible_forward",
            "MaterialSymbols.accessible_forward()",
            tagIcons::accessible_forward_actions));
    icons.add(
        new IconCatalogEntry<>(
            "account_box", "MaterialSymbols.account_box()", tagIcons::account_box_actions));
    icons.add(
        new IconCatalogEntry<>(
            "account_child", "MaterialSymbols.account_child()", tagIcons::account_child_actions));
    icons.add(
        new IconCatalogEntry<>(
            "account_child_invert",
            "MaterialSymbols.account_child_invert()",
            tagIcons::account_child_invert_actions));
    icons.add(
        new IconCatalogEntry<>(
            "account_circle",
            "MaterialSymbols.account_circle()",
            tagIcons::account_circle_actions));
    icons.add(
        new IconCatalogEntry<>(
            "account_circle_off",
            "MaterialSymbols.account_circle_off()",
            tagIcons::account_circle_off_actions));
    icons.add(new IconCatalogEntry<>("ad", "MaterialSymbols.ad()", tagIcons::ad_actions));
    icons.add(
        new IconCatalogEntry<>(
            "ad_group", "MaterialSymbols.ad_group()", tagIcons::ad_group_actions));
    icons.add(
        new IconCatalogEntry<>(
            "ad_group_off", "MaterialSymbols.ad_group_off()", tagIcons::ad_group_off_actions));
    icons.add(
        new IconCatalogEntry<>("ad_off", "MaterialSymbols.ad_off()", tagIcons::ad_off_actions));
    icons.add(
        new IconCatalogEntry<>("add_ad", "MaterialSymbols.add_ad()", tagIcons::add_ad_actions));
    icons.add(
        new IconCatalogEntry<>(
            "add_alert", "MaterialSymbols.add_alert()", tagIcons::add_alert_actions));
    icons.add(
        new IconCatalogEntry<>(
            "ads_click", "MaterialSymbols.ads_click()", tagIcons::ads_click_actions));
    icons.add(new IconCatalogEntry<>("alarm", "MaterialSymbols.alarm()", tagIcons::alarm_actions));
    icons.add(
        new IconCatalogEntry<>(
            "alarm_add", "MaterialSymbols.alarm_add()", tagIcons::alarm_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "alarm_off", "MaterialSymbols.alarm_off()", tagIcons::alarm_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "alarm_on", "MaterialSymbols.alarm_on()", tagIcons::alarm_on_actions));
    icons.add(
        new IconCatalogEntry<>(
            "alarm_pause", "MaterialSymbols.alarm_pause()", tagIcons::alarm_pause_actions));
    icons.add(
        new IconCatalogEntry<>(
            "alarm_smart_wake",
            "MaterialSymbols.alarm_smart_wake()",
            tagIcons::alarm_smart_wake_actions));
    icons.add(
        new IconCatalogEntry<>(
            "all_inclusive", "MaterialSymbols.all_inclusive()", tagIcons::all_inclusive_actions));
    icons.add(
        new IconCatalogEntry<>("all_out", "MaterialSymbols.all_out()", tagIcons::all_out_actions));
    icons.add(
        new IconCatalogEntry<>("anchor", "MaterialSymbols.anchor()", tagIcons::anchor_actions));
    icons.add(new IconCatalogEntry<>("api", "MaterialSymbols.api()", tagIcons::api_actions));
    icons.add(
        new IconCatalogEntry<>(
            "approval", "MaterialSymbols.approval()", tagIcons::approval_actions));
    icons.add(
        new IconCatalogEntry<>(
            "approval_delegation",
            "MaterialSymbols.approval_delegation()",
            tagIcons::approval_delegation_actions));
    icons.add(
        new IconCatalogEntry<>(
            "approval_delegation_off",
            "MaterialSymbols.approval_delegation_off()",
            tagIcons::approval_delegation_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "arrow_selector_tool",
            "MaterialSymbols.arrow_selector_tool()",
            tagIcons::arrow_selector_tool_actions));
    icons.add(
        new IconCatalogEntry<>(
            "auto_delete", "MaterialSymbols.auto_delete()", tagIcons::auto_delete_actions));
    icons.add(
        new IconCatalogEntry<>(
            "award_star", "MaterialSymbols.award_star()", tagIcons::award_star_actions));
    icons.add(
        new IconCatalogEntry<>(
            "background_replace",
            "MaterialSymbols.background_replace()",
            tagIcons::background_replace_actions));
    icons.add(
        new IconCatalogEntry<>("backup", "MaterialSymbols.backup()", tagIcons::backup_actions));
    icons.add(
        new IconCatalogEntry<>(
            "backup_table", "MaterialSymbols.backup_table()", tagIcons::backup_table_actions));
    icons.add(
        new IconCatalogEntry<>(
            "batch_prediction",
            "MaterialSymbols.batch_prediction()",
            tagIcons::batch_prediction_actions));
    icons.add(
        new IconCatalogEntry<>(
            "book_ribbon", "MaterialSymbols.book_ribbon()", tagIcons::book_ribbon_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark", "MaterialSymbols.bookmark()", tagIcons::bookmark_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_add", "MaterialSymbols.bookmark_add()", tagIcons::bookmark_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_added",
            "MaterialSymbols.bookmark_added()",
            tagIcons::bookmark_added_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_bag", "MaterialSymbols.bookmark_bag()", tagIcons::bookmark_bag_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_check",
            "MaterialSymbols.bookmark_check()",
            tagIcons::bookmark_check_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_flag", "MaterialSymbols.bookmark_flag()", tagIcons::bookmark_flag_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_heart",
            "MaterialSymbols.bookmark_heart()",
            tagIcons::bookmark_heart_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_manager",
            "MaterialSymbols.bookmark_manager()",
            tagIcons::bookmark_manager_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_remove",
            "MaterialSymbols.bookmark_remove()",
            tagIcons::bookmark_remove_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_stacks",
            "MaterialSymbols.bookmark_stacks()",
            tagIcons::bookmark_stacks_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_star", "MaterialSymbols.bookmark_star()", tagIcons::bookmark_star_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bookmarks", "MaterialSymbols.bookmarks()", tagIcons::bookmarks_actions));
    icons.add(
        new IconCatalogEntry<>("browse", "MaterialSymbols.browse()", tagIcons::browse_actions));
    icons.add(
        new IconCatalogEntry<>(
            "bug_report", "MaterialSymbols.bug_report()", tagIcons::bug_report_actions));
    icons.add(new IconCatalogEntry<>("build", "MaterialSymbols.build()", tagIcons::build_actions));
    icons.add(
        new IconCatalogEntry<>(
            "build_circle", "MaterialSymbols.build_circle()", tagIcons::build_circle_actions));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_check",
            "MaterialSymbols.calendar_check()",
            tagIcons::calendar_check_actions));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_clock",
            "MaterialSymbols.calendar_clock()",
            tagIcons::calendar_clock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_lock", "MaterialSymbols.calendar_lock()", tagIcons::calendar_lock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_month",
            "MaterialSymbols.calendar_month()",
            tagIcons::calendar_month_actions));
    icons.add(
        new IconCatalogEntry<>(
            "calendar_today",
            "MaterialSymbols.calendar_today()",
            tagIcons::calendar_today_actions));
    icons.add(
        new IconCatalogEntry<>(
            "category", "MaterialSymbols.category()", tagIcons::category_actions));
    icons.add(
        new IconCatalogEntry<>(
            "celebration", "MaterialSymbols.celebration()", tagIcons::celebration_actions));
    icons.add(
        new IconCatalogEntry<>(
            "change_history",
            "MaterialSymbols.change_history()",
            tagIcons::change_history_actions));
    icons.add(
        new IconCatalogEntry<>(
            "chrome_reader_mode",
            "MaterialSymbols.chrome_reader_mode()",
            tagIcons::chrome_reader_mode_actions));
    icons.add(
        new IconCatalogEntry<>(
            "circle_notifications",
            "MaterialSymbols.circle_notifications()",
            tagIcons::circle_notifications_actions));
    icons.add(
        new IconCatalogEntry<>("circles", "MaterialSymbols.circles()", tagIcons::circles_actions));
    icons.add(
        new IconCatalogEntry<>(
            "circles_ext", "MaterialSymbols.circles_ext()", tagIcons::circles_ext_actions));
    icons.add(new IconCatalogEntry<>("code", "MaterialSymbols.code()", tagIcons::code_actions));
    icons.add(
        new IconCatalogEntry<>(
            "code_blocks", "MaterialSymbols.code_blocks()", tagIcons::code_blocks_actions));
    icons.add(
        new IconCatalogEntry<>(
            "code_off", "MaterialSymbols.code_off()", tagIcons::code_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "code_xml", "MaterialSymbols.code_xml()", tagIcons::code_xml_actions));
    icons.add(
        new IconCatalogEntry<>(
            "collections_bookmark",
            "MaterialSymbols.collections_bookmark()",
            tagIcons::collections_bookmark_actions));
    icons.add(
        new IconCatalogEntry<>("commit", "MaterialSymbols.commit()", tagIcons::commit_actions));
    icons.add(
        new IconCatalogEntry<>(
            "component_exchange",
            "MaterialSymbols.component_exchange()",
            tagIcons::component_exchange_actions));
    icons.add(
        new IconCatalogEntry<>(
            "contacts_product",
            "MaterialSymbols.contacts_product()",
            tagIcons::contacts_product_actions));
    icons.add(
        new IconCatalogEntry<>(
            "dangerous", "MaterialSymbols.dangerous()", tagIcons::dangerous_actions));
    icons.add(
        new IconCatalogEntry<>(
            "data_loss_prevention",
            "MaterialSymbols.data_loss_prevention()",
            tagIcons::data_loss_prevention_actions));
    icons.add(
        new IconCatalogEntry<>(
            "date_range", "MaterialSymbols.date_range()", tagIcons::date_range_actions));
    icons.add(
        new IconCatalogEntry<>(
            "delete_history",
            "MaterialSymbols.delete_history()",
            tagIcons::delete_history_actions));
    icons.add(
        new IconCatalogEntry<>(
            "developer_guide",
            "MaterialSymbols.developer_guide()",
            tagIcons::developer_guide_actions));
    icons.add(
        new IconCatalogEntry<>(
            "domain_verification",
            "MaterialSymbols.domain_verification()",
            tagIcons::domain_verification_actions));
    icons.add(
        new IconCatalogEntry<>(
            "domain_verification_off",
            "MaterialSymbols.domain_verification_off()",
            tagIcons::domain_verification_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "draft_orders", "MaterialSymbols.draft_orders()", tagIcons::draft_orders_actions));
    icons.add(
        new IconCatalogEntry<>(
            "dynamic_feed", "MaterialSymbols.dynamic_feed()", tagIcons::dynamic_feed_actions));
    icons.add(
        new IconCatalogEntry<>(
            "edit_calendar", "MaterialSymbols.edit_calendar()", tagIcons::edit_calendar_actions));
    icons.add(
        new IconCatalogEntry<>(
            "edit_notifications",
            "MaterialSymbols.edit_notifications()",
            tagIcons::edit_notifications_actions));
    icons.add(
        new IconCatalogEntry<>(
            "edit_square", "MaterialSymbols.edit_square()", tagIcons::edit_square_actions));
    icons.add(new IconCatalogEntry<>("error", "MaterialSymbols.error()", tagIcons::error_actions));
    icons.add(new IconCatalogEntry<>("event", "MaterialSymbols.event()", tagIcons::event_actions));
    icons.add(
        new IconCatalogEntry<>(
            "event_available",
            "MaterialSymbols.event_available()",
            tagIcons::event_available_actions));
    icons.add(
        new IconCatalogEntry<>(
            "event_busy", "MaterialSymbols.event_busy()", tagIcons::event_busy_actions));
    icons.add(
        new IconCatalogEntry<>(
            "event_note", "MaterialSymbols.event_note()", tagIcons::event_note_actions));
    icons.add(
        new IconCatalogEntry<>(
            "event_repeat", "MaterialSymbols.event_repeat()", tagIcons::event_repeat_actions));
    icons.add(
        new IconCatalogEntry<>(
            "event_upcoming",
            "MaterialSymbols.event_upcoming()",
            tagIcons::event_upcoming_actions));
    icons.add(
        new IconCatalogEntry<>(
            "extension", "MaterialSymbols.extension()", tagIcons::extension_actions));
    icons.add(
        new IconCatalogEntry<>(
            "feature_search",
            "MaterialSymbols.feature_search()",
            tagIcons::feature_search_actions));
    icons.add(
        new IconCatalogEntry<>(
            "feedback", "MaterialSymbols.feedback()", tagIcons::feedback_actions));
    icons.add(
        new IconCatalogEntry<>(
            "find_replace", "MaterialSymbols.find_replace()", tagIcons::find_replace_actions));
    icons.add(
        new IconCatalogEntry<>(
            "fingerprint", "MaterialSymbols.fingerprint()", tagIcons::fingerprint_actions));
    icons.add(
        new IconCatalogEntry<>(
            "fingerprint_off",
            "MaterialSymbols.fingerprint_off()",
            tagIcons::fingerprint_off_actions));
    icons.add(
        new IconCatalogEntry<>("flutter", "MaterialSymbols.flutter()", tagIcons::flutter_actions));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "flutter_dash", "MaterialSymbols.flutter_dash()", tagIcons::flutter_dash_actions));
    icons.add(
        new IconCatalogEntry<>(
            "free_cancellation",
            "MaterialSymbols.free_cancellation()",
            tagIcons::free_cancellation_actions));
    icons.add(
        new IconCatalogEntry<>("gesture", "MaterialSymbols.gesture()", tagIcons::gesture_actions));
    icons.add(
        new IconCatalogEntry<>(
            "gesture_select",
            "MaterialSymbols.gesture_select()",
            tagIcons::gesture_select_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hand_gesture", "MaterialSymbols.hand_gesture()", tagIcons::hand_gesture_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hand_gesture_off",
            "MaterialSymbols.hand_gesture_off()",
            tagIcons::hand_gesture_off_actions));
    icons.add(new IconCatalogEntry<>("help", "MaterialSymbols.help()", tagIcons::help_actions));
    icons.add(
        new IconCatalogEntry<>(
            "help_center", "MaterialSymbols.help_center()", tagIcons::help_center_actions));
    icons.add(
        new IconCatalogEntry<>(
            "help_clinic", "MaterialSymbols.help_clinic()", tagIcons::help_clinic_actions));
    icons.add(
        new IconCatalogEntry<>("history", "MaterialSymbols.history()", tagIcons::history_actions));
    icons.add(
        new IconCatalogEntry<>(
            "history_2", "MaterialSymbols.history_2()", tagIcons::history_2_actions));
    icons.add(
        new IconCatalogEntry<>(
            "history_off", "MaterialSymbols.history_off()", tagIcons::history_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "history_toggle_off",
            "MaterialSymbols.history_toggle_off()",
            tagIcons::history_toggle_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "home_app_logo", "MaterialSymbols.home_app_logo()", tagIcons::home_app_logo_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hotel_class", "MaterialSymbols.hotel_class()", tagIcons::hotel_class_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass", "MaterialSymbols.hourglass()", tagIcons::hourglass_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_check",
            "MaterialSymbols.hourglass_check()",
            tagIcons::hourglass_check_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_disabled",
            "MaterialSymbols.hourglass_disabled()",
            tagIcons::hourglass_disabled_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_empty",
            "MaterialSymbols.hourglass_empty()",
            tagIcons::hourglass_empty_actions));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_pause",
            "MaterialSymbols.hourglass_pause()",
            tagIcons::hourglass_pause_actions));
    icons.add(
        new IconCatalogEntry<>(
            "how_to_reg", "MaterialSymbols.how_to_reg()", tagIcons::how_to_reg_actions));
    icons.add(new IconCatalogEntry<>("http", "MaterialSymbols.http()", tagIcons::http_actions));
    icons.add(
        new IconCatalogEntry<>(
            "indeterminate_question_box",
            "MaterialSymbols.indeterminate_question_box()",
            tagIcons::indeterminate_question_box_actions));
    icons.add(new IconCatalogEntry<>("info", "MaterialSymbols.info()", tagIcons::info_actions));
    icons.add(
        new IconCatalogEntry<>("info_i", "MaterialSymbols.info_i()", tagIcons::info_i_actions));
    icons.add(new IconCatalogEntry<>("input", "MaterialSymbols.input()", tagIcons::input_actions));
    icons.add(
        new IconCatalogEntry<>(
            "interests", "MaterialSymbols.interests()", tagIcons::interests_actions));
    icons.add(new IconCatalogEntry<>("keep", "MaterialSymbols.keep()", tagIcons::keep_actions));
    icons.add(
        new IconCatalogEntry<>(
            "keep_off", "MaterialSymbols.keep_off()", tagIcons::keep_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "keep_public", "MaterialSymbols.keep_public()", tagIcons::keep_public_actions));
    icons.add(new IconCatalogEntry<>("label", "MaterialSymbols.label()", tagIcons::label_actions));
    icons.add(
        new IconCatalogEntry<>(
            "label_important",
            "MaterialSymbols.label_important()",
            tagIcons::label_important_actions));
    icons.add(
        new IconCatalogEntry<>(
            "label_off", "MaterialSymbols.label_off()", tagIcons::label_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "language", "MaterialSymbols.language()", tagIcons::language_actions));
    icons.add(
        new IconCatalogEntry<>("license", "MaterialSymbols.license()", tagIcons::license_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lightbulb", "MaterialSymbols.lightbulb()", tagIcons::lightbulb_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lightbulb_circle",
            "MaterialSymbols.lightbulb_circle()",
            tagIcons::lightbulb_circle_actions));
    icons.add(new IconCatalogEntry<>("lists", "MaterialSymbols.lists()", tagIcons::lists_actions));
    icons.add(new IconCatalogEntry<>("lock", "MaterialSymbols.lock()", tagIcons::lock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_clock", "MaterialSymbols.lock_clock()", tagIcons::lock_clock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_open", "MaterialSymbols.lock_open()", tagIcons::lock_open_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_open_circle",
            "MaterialSymbols.lock_open_circle()",
            tagIcons::lock_open_circle_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_open_right",
            "MaterialSymbols.lock_open_right()",
            tagIcons::lock_open_right_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_person", "MaterialSymbols.lock_person()", tagIcons::lock_person_actions));
    icons.add(
        new IconCatalogEntry<>(
            "lock_reset", "MaterialSymbols.lock_reset()", tagIcons::lock_reset_actions));
    icons.add(
        new IconCatalogEntry<>(
            "logo_dev", "MaterialSymbols.logo_dev()", tagIcons::logo_dev_actions));
    icons.add(
        new IconCatalogEntry<>(
            "manage_accounts",
            "MaterialSymbols.manage_accounts()",
            tagIcons::manage_accounts_actions));
    icons.add(
        new IconCatalogEntry<>(
            "manage_history",
            "MaterialSymbols.manage_history()",
            tagIcons::manage_history_actions));
    icons.add(
        new IconCatalogEntry<>(
            "manufacturing", "MaterialSymbols.manufacturing()", tagIcons::manufacturing_actions));
    icons.add(
        new IconCatalogEntry<>(
            "measuring_tape",
            "MaterialSymbols.measuring_tape()",
            tagIcons::measuring_tape_actions));
    icons.add(
        new IconCatalogEntry<>(
            "model_training",
            "MaterialSymbols.model_training()",
            tagIcons::model_training_actions));
    icons.add(new IconCatalogEntry<>("more", "MaterialSymbols.more()", tagIcons::more_actions));
    icons.add(
        new IconCatalogEntry<>(
            "more_time", "MaterialSymbols.more_time()", tagIcons::more_time_actions));
    icons.add(
        new IconCatalogEntry<>(
            "new_label", "MaterialSymbols.new_label()", tagIcons::new_label_actions));
    icons.add(
        new IconCatalogEntry<>(
            "no_accounts", "MaterialSymbols.no_accounts()", tagIcons::no_accounts_actions));
    icons.add(
        new IconCatalogEntry<>(
            "notification_add",
            "MaterialSymbols.notification_add()",
            tagIcons::notification_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "notification_important",
            "MaterialSymbols.notification_important()",
            tagIcons::notification_important_actions));
    icons.add(
        new IconCatalogEntry<>(
            "offline_pin", "MaterialSymbols.offline_pin()", tagIcons::offline_pin_actions));
    icons.add(
        new IconCatalogEntry<>(
            "offline_pin_off",
            "MaterialSymbols.offline_pin_off()",
            tagIcons::offline_pin_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "on_device_training",
            "MaterialSymbols.on_device_training()",
            tagIcons::on_device_training_actions));
    icons.add(
        new IconCatalogEntry<>(
            "online_prediction",
            "MaterialSymbols.online_prediction()",
            tagIcons::online_prediction_actions));
    icons.add(
        new IconCatalogEntry<>(
            "open_in_browser",
            "MaterialSymbols.open_in_browser()",
            tagIcons::open_in_browser_actions));
    icons.add(
        new IconCatalogEntry<>(
            "outbound", "MaterialSymbols.outbound()", tagIcons::outbound_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pageview", "MaterialSymbols.pageview()", tagIcons::pageview_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pan_tool", "MaterialSymbols.pan_tool()", tagIcons::pan_tool_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pan_tool_alt", "MaterialSymbols.pan_tool_alt()", tagIcons::pan_tool_alt_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pan_zoom", "MaterialSymbols.pan_zoom()", tagIcons::pan_zoom_actions));
    icons.add(
        new IconCatalogEntry<>("pending", "MaterialSymbols.pending()", tagIcons::pending_actions));
    icons.add(
        new IconCatalogEntry<>(
            "perm_contact_calendar",
            "MaterialSymbols.perm_contact_calendar()",
            tagIcons::perm_contact_calendar_actions));
    icons.add(
        new IconCatalogEntry<>(
            "person_add_disabled",
            "MaterialSymbols.person_add_disabled()",
            tagIcons::person_add_disabled_actions));
    icons.add(
        new IconCatalogEntry<>(
            "person_edit", "MaterialSymbols.person_edit()", tagIcons::person_edit_actions));
    icons.add(
        new IconCatalogEntry<>("pin_end", "MaterialSymbols.pin_end()", tagIcons::pin_end_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pin_invoke", "MaterialSymbols.pin_invoke()", tagIcons::pin_invoke_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pinboard", "MaterialSymbols.pinboard()", tagIcons::pinboard_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pinboard_unread",
            "MaterialSymbols.pinboard_unread()",
            tagIcons::pinboard_unread_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pinch_zoom_in", "MaterialSymbols.pinch_zoom_in()", tagIcons::pinch_zoom_in_actions));
    icons.add(
        new IconCatalogEntry<>(
            "pinch_zoom_out",
            "MaterialSymbols.pinch_zoom_out()",
            tagIcons::pinch_zoom_out_actions));
    icons.add(
        new IconCatalogEntry<>("polymer", "MaterialSymbols.polymer()", tagIcons::polymer_actions));
    icons.add(
        new IconCatalogEntry<>(
            "power_settings_circle",
            "MaterialSymbols.power_settings_circle()",
            tagIcons::power_settings_circle_actions));
    icons.add(
        new IconCatalogEntry<>(
            "power_settings_new",
            "MaterialSymbols.power_settings_new()",
            tagIcons::power_settings_new_actions));
    icons.add(
        new IconCatalogEntry<>("preview", "MaterialSymbols.preview()", tagIcons::preview_actions));
    icons.add(
        new IconCatalogEntry<>(
            "preview_off", "MaterialSymbols.preview_off()", tagIcons::preview_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "priority", "MaterialSymbols.priority()", tagIcons::priority_actions));
    icons.add(
        new IconCatalogEntry<>(
            "priority_high", "MaterialSymbols.priority_high()", tagIcons::priority_high_actions));
    icons.add(
        new IconCatalogEntry<>("problem", "MaterialSymbols.problem()", tagIcons::problem_actions));
    icons.add(
        new IconCatalogEntry<>(
            "published_with_changes",
            "MaterialSymbols.published_with_changes()",
            tagIcons::published_with_changes_actions));
    icons.add(
        new IconCatalogEntry<>(
            "question_mark", "MaterialSymbols.question_mark()", tagIcons::question_mark_actions));
    icons.add(
        new IconCatalogEntry<>(
            "rate_review", "MaterialSymbols.rate_review()", tagIcons::rate_review_actions));
    icons.add(
        new IconCatalogEntry<>(
            "record_voice_over",
            "MaterialSymbols.record_voice_over()",
            tagIcons::record_voice_over_actions));
    icons.add(
        new IconCatalogEntry<>(
            "release_alert", "MaterialSymbols.release_alert()", tagIcons::release_alert_actions));
    icons.add(
        new IconCatalogEntry<>(
            "reminder", "MaterialSymbols.reminder()", tagIcons::reminder_actions));
    icons.add(
        new IconCatalogEntry<>(
            "rounded_corner",
            "MaterialSymbols.rounded_corner()",
            tagIcons::rounded_corner_actions));
    icons.add(new IconCatalogEntry<>("rsvp", "MaterialSymbols.rsvp()", tagIcons::rsvp_actions));
    icons.add(new IconCatalogEntry<>("rule", "MaterialSymbols.rule()", tagIcons::rule_actions));
    icons.add(
        new IconCatalogEntry<>(
            "running_with_errors",
            "MaterialSymbols.running_with_errors()",
            tagIcons::running_with_errors_actions));
    icons.add(
        new IconCatalogEntry<>("save_as", "MaterialSymbols.save_as()", tagIcons::save_as_actions));
    icons.add(
        new IconCatalogEntry<>(
            "schedule", "MaterialSymbols.schedule()", tagIcons::schedule_actions));
    icons.add(
        new IconCatalogEntry<>(
            "scrollable_header",
            "MaterialSymbols.scrollable_header()",
            tagIcons::scrollable_header_actions));
    icons.add(new IconCatalogEntry<>("sdk", "MaterialSymbols.sdk()", tagIcons::sdk_actions));
    icons.add(
        new IconCatalogEntry<>(
            "search_activity",
            "MaterialSymbols.search_activity()",
            tagIcons::search_activity_actions));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "search_hands_free",
            "MaterialSymbols.search_hands_free()",
            tagIcons::search_hands_free_actions));
    icons.add(
        new IconCatalogEntry<>(
            "select_window", "MaterialSymbols.select_window()", tagIcons::select_window_actions));
    icons.add(
        new IconCatalogEntry<>(
            "select_window_2",
            "MaterialSymbols.select_window_2()",
            tagIcons::select_window_2_actions));
    icons.add(
        new IconCatalogEntry<>(
            "select_window_off",
            "MaterialSymbols.select_window_off()",
            tagIcons::select_window_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "settings_account_box",
            "MaterialSymbols.settings_account_box()",
            tagIcons::settings_account_box_actions));
    icons.add(
        new IconCatalogEntry<>(
            "settings_overscan",
            "MaterialSymbols.settings_overscan()",
            tagIcons::settings_overscan_actions));
    icons.add(
        new IconCatalogEntry<>(
            "settings_power",
            "MaterialSymbols.settings_power()",
            tagIcons::settings_power_actions));
    icons.add(
        new IconCatalogEntry<>(
            "settings_screen",
            "MaterialSymbols.settings_screen()",
            tagIcons::settings_screen_actions));
    icons.add(
        new IconCatalogEntry<>("shadow", "MaterialSymbols.shadow()", tagIcons::shadow_actions));
    icons.add(
        new IconCatalogEntry<>(
            "shadow_add", "MaterialSymbols.shadow_add()", tagIcons::shadow_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "shadow_minus", "MaterialSymbols.shadow_minus()", tagIcons::shadow_minus_actions));
    icons.add(new IconCatalogEntry<>("shift", "MaterialSymbols.shift()", tagIcons::shift_actions));
    icons.add(
        new IconCatalogEntry<>(
            "shift_lock", "MaterialSymbols.shift_lock()", tagIcons::shift_lock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "shift_lock_off",
            "MaterialSymbols.shift_lock_off()",
            tagIcons::shift_lock_off_actions));
    icons.add(
        new IconCatalogEntry<>("snooze", "MaterialSymbols.snooze()", tagIcons::snooze_actions));
    icons.add(
        new IconCatalogEntry<>(
            "square_foot", "MaterialSymbols.square_foot()", tagIcons::square_foot_actions));
    icons.add(new IconCatalogEntry<>("stars", "MaterialSymbols.stars()", tagIcons::stars_actions));
    icons.add(
        new IconCatalogEntry<>("sticker", "MaterialSymbols.sticker()", tagIcons::sticker_actions));
    icons.add(
        new IconCatalogEntry<>(
            "sticker_add", "MaterialSymbols.sticker_add()", tagIcons::sticker_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "supervised_user_circle",
            "MaterialSymbols.supervised_user_circle()",
            tagIcons::supervised_user_circle_actions));
    icons.add(
        new IconCatalogEntry<>(
            "supervised_user_circle_off",
            "MaterialSymbols.supervised_user_circle_off()",
            tagIcons::supervised_user_circle_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "supervisor_account",
            "MaterialSymbols.supervisor_account()",
            tagIcons::supervisor_account_actions));
    icons.add(
        new IconCatalogEntry<>("support", "MaterialSymbols.support()", tagIcons::support_actions));
    icons.add(new IconCatalogEntry<>("swipe", "MaterialSymbols.swipe()", tagIcons::swipe_actions));
    icons.add(
        new IconCatalogEntry<>("target", "MaterialSymbols.target()", tagIcons::target_actions));
    icons.add(
        new IconCatalogEntry<>(
            "target_check", "MaterialSymbols.target_check()", tagIcons::target_check_actions));
    icons.add(
        new IconCatalogEntry<>(
            "task_alt", "MaterialSymbols.task_alt()", tagIcons::task_alt_actions));
    icons.add(
        new IconCatalogEntry<>(
            "terminal", "MaterialSymbols.terminal()", tagIcons::terminal_actions));
    icons.add(
        new IconCatalogEntry<>(
            "terminal_2", "MaterialSymbols.terminal_2()", tagIcons::terminal_2_actions));
    icons.add(
        new IconCatalogEntry<>(
            "terminal_add", "MaterialSymbols.terminal_add()", tagIcons::terminal_add_actions));
    icons.add(
        new IconCatalogEntry<>(
            "time_auto", "MaterialSymbols.time_auto()", tagIcons::time_auto_actions));
    icons.add(
        new IconCatalogEntry<>(
            "timer_10_alt_1",
            "MaterialSymbols.timer_10_alt_1()",
            tagIcons::timer_10_alt_1_actions));
    icons.add(
        new IconCatalogEntry<>(
            "timer_3_alt_1", "MaterialSymbols.timer_3_alt_1()", tagIcons::timer_3_alt_1_actions));
    icons.add(
        new IconCatalogEntry<>(
            "timer_pause", "MaterialSymbols.timer_pause()", tagIcons::timer_pause_actions));
    icons.add(
        new IconCatalogEntry<>(
            "timer_play", "MaterialSymbols.timer_play()", tagIcons::timer_play_actions));
    icons.add(new IconCatalogEntry<>("today", "MaterialSymbols.today()", tagIcons::today_actions));
    icons.add(
        new IconCatalogEntry<>(
            "touch_app", "MaterialSymbols.touch_app()", tagIcons::touch_app_actions));
    icons.add(
        new IconCatalogEntry<>(
            "touch_double", "MaterialSymbols.touch_double()", tagIcons::touch_double_actions));
    icons.add(
        new IconCatalogEntry<>(
            "touch_double_2",
            "MaterialSymbols.touch_double_2()",
            tagIcons::touch_double_2_actions));
    icons.add(
        new IconCatalogEntry<>(
            "touch_long", "MaterialSymbols.touch_long()", tagIcons::touch_long_actions));
    icons.add(
        new IconCatalogEntry<>(
            "touch_triple", "MaterialSymbols.touch_triple()", tagIcons::touch_triple_actions));
    icons.add(
        new IconCatalogEntry<>(
            "trackpad_input",
            "MaterialSymbols.trackpad_input()",
            tagIcons::trackpad_input_actions));
    icons.add(
        new IconCatalogEntry<>(
            "trackpad_input_2",
            "MaterialSymbols.trackpad_input_2()",
            tagIcons::trackpad_input_2_actions));
    icons.add(
        new IconCatalogEntry<>(
            "trackpad_input_3",
            "MaterialSymbols.trackpad_input_3()",
            tagIcons::trackpad_input_3_actions));
    icons.add(
        new IconCatalogEntry<>(
            "translate", "MaterialSymbols.translate()", tagIcons::translate_actions));
    icons.add(
        new IconCatalogEntry<>(
            "translate_indic",
            "MaterialSymbols.translate_indic()",
            tagIcons::translate_indic_actions));
    icons.add(
        new IconCatalogEntry<>(
            "unlicense", "MaterialSymbols.unlicense()", tagIcons::unlicense_actions));
    icons.add(
        new IconCatalogEntry<>(
            "unpublished", "MaterialSymbols.unpublished()", tagIcons::unpublished_actions));
    icons.add(
        new IconCatalogEntry<>("update", "MaterialSymbols.update()", tagIcons::update_actions));
    icons.add(
        new IconCatalogEntry<>(
            "update_disabled",
            "MaterialSymbols.update_disabled()",
            tagIcons::update_disabled_actions));
    icons.add(
        new IconCatalogEntry<>("upgrade", "MaterialSymbols.upgrade()", tagIcons::upgrade_actions));
    icons.add(
        new IconCatalogEntry<>(
            "upload_file", "MaterialSymbols.upload_file()", tagIcons::upload_file_actions));
    icons.add(
        new IconCatalogEntry<>(
            "user_attributes",
            "MaterialSymbols.user_attributes()",
            tagIcons::user_attributes_actions));
    icons.add(
        new IconCatalogEntry<>(
            "verified", "MaterialSymbols.verified()", tagIcons::verified_actions));
    icons.add(
        new IconCatalogEntry<>(
            "verified_off", "MaterialSymbols.verified_off()", tagIcons::verified_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "visibility", "MaterialSymbols.visibility()", tagIcons::visibility_actions));
    icons.add(
        new IconCatalogEntry<>(
            "visibility_lock",
            "MaterialSymbols.visibility_lock()",
            tagIcons::visibility_lock_actions));
    icons.add(
        new IconCatalogEntry<>(
            "visibility_off",
            "MaterialSymbols.visibility_off()",
            tagIcons::visibility_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "voice_over_off",
            "MaterialSymbols.voice_over_off()",
            tagIcons::voice_over_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "wand_shine", "MaterialSymbols.wand_shine()", tagIcons::wand_shine_actions));
    icons.add(
        new IconCatalogEntry<>(
            "wand_stars", "MaterialSymbols.wand_stars()", tagIcons::wand_stars_actions));
    icons.add(
        new IconCatalogEntry<>("warning", "MaterialSymbols.warning()", tagIcons::warning_actions));
    icons.add(
        new IconCatalogEntry<>(
            "warning_off", "MaterialSymbols.warning_off()", tagIcons::warning_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "watch_screentime",
            "MaterialSymbols.watch_screentime()",
            tagIcons::watch_screentime_actions));
    icons.add(
        new IconCatalogEntry<>(
            "water_lock", "MaterialSymbols.water_lock()", tagIcons::water_lock_actions));
    icons.add(new IconCatalogEntry<>("web", "MaterialSymbols.web()", tagIcons::web_actions));
    icons.add(
        new IconCatalogEntry<>(
            "web_asset", "MaterialSymbols.web_asset()", tagIcons::web_asset_actions));
    icons.add(
        new IconCatalogEntry<>(
            "web_asset_off", "MaterialSymbols.web_asset_off()", tagIcons::web_asset_off_actions));
    icons.add(
        new IconCatalogEntry<>(
            "web_traffic", "MaterialSymbols.web_traffic()", tagIcons::web_traffic_actions));
    icons.add(
        new IconCatalogEntry<>("webhook", "MaterialSymbols.webhook()", tagIcons::webhook_actions));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_protected_setup",
            "MaterialSymbols.wifi_protected_setup()",
            tagIcons::wifi_protected_setup_actions));
    icons.add(
        new IconCatalogEntry<>("wysiwyg", "MaterialSymbols.wysiwyg()", tagIcons::wysiwyg_actions));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
