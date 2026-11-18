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
import org.dominokit.domino.ui.icons.MaterialSymbolsOther;

/** Static icon factory for the Material Symbols Other category. */
public final class MaterialSymbolsOther_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsOther tagIcons = new MaterialSymbolsOther() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
    addIcons3();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "access_alarm", "MaterialSymbols.access_alarm()", tagIcons::access_alarm_other));
    icons.add(
        new IconCatalogEntry<>(
            "access_alarms", "MaterialSymbols.access_alarms()", tagIcons::access_alarms_other));
    icons.add(
        new IconCatalogEntry<>(
            "access_time", "MaterialSymbols.access_time()", tagIcons::access_time_other));
    icons.add(
        new IconCatalogEntry<>(
            "access_time_filled",
            "MaterialSymbols.access_time_filled()",
            tagIcons::access_time_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "account_circle_filled",
            "MaterialSymbols.account_circle_filled()",
            tagIcons::account_circle_filled_other));
    icons.add(
        new IconCatalogEntry<>("ad_units", "MaterialSymbols.ad_units()", tagIcons::ad_units_other));
    icons.add(
        new IconCatalogEntry<>(
            "add_alarm", "MaterialSymbols.add_alarm()", tagIcons::add_alarm_other));
    icons.add(
        new IconCatalogEntry<>(
            "add_circle_outline",
            "MaterialSymbols.add_circle_outline()",
            tagIcons::add_circle_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "add_ic_call", "MaterialSymbols.add_ic_call()", tagIcons::add_ic_call_other));
    icons.add(
        new IconCatalogEntry<>(
            "add_to_home_screen",
            "MaterialSymbols.add_to_home_screen()",
            tagIcons::add_to_home_screen_other));
    icons.add(
        new IconCatalogEntry<>(
            "add_to_photos", "MaterialSymbols.add_to_photos()", tagIcons::add_to_photos_other));
    icons.add(
        new IconCatalogEntry<>("addchart", "MaterialSymbols.addchart()", tagIcons::addchart_other));
    icons.add(
        new IconCatalogEntry<>(
            "airplanemode_active",
            "MaterialSymbols.airplanemode_active()",
            tagIcons::airplanemode_active_other));
    icons.add(
        new IconCatalogEntry<>("airware", "MaterialSymbols.airware()", tagIcons::airware_other));
    icons.add(
        new IconCatalogEntry<>(
            "ambient_screen", "MaterialSymbols.ambient_screen()", tagIcons::ambient_screen_other));
    icons.add(
        new IconCatalogEntry<>(
            "announcement", "MaterialSymbols.announcement()", tagIcons::announcement_other));
    icons.add(new IconCatalogEntry<>("aod", "MaterialSymbols.aod()", tagIcons::aod_other));
    icons.add(
        new IconCatalogEntry<>(
            "app_blocking", "MaterialSymbols.app_blocking()", tagIcons::app_blocking_other));
    icons.add(
        new IconCatalogEntry<>(
            "app_promo", "MaterialSymbols.app_promo()", tagIcons::app_promo_other));
    icons.add(
        new IconCatalogEntry<>(
            "app_settings_alt",
            "MaterialSymbols.app_settings_alt()",
            tagIcons::app_settings_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "app_shortcut", "MaterialSymbols.app_shortcut()", tagIcons::app_shortcut_other));
    icons.add(
        new IconCatalogEntry<>(
            "assessment", "MaterialSymbols.assessment()", tagIcons::assessment_other));
    icons.add(
        new IconCatalogEntry<>(
            "assistant", "MaterialSymbols.assistant()", tagIcons::assistant_other));
    icons.add(
        new IconCatalogEntry<>(
            "assistant_photo",
            "MaterialSymbols.assistant_photo()",
            tagIcons::assistant_photo_other));
    icons.add(
        new IconCatalogEntry<>(
            "astrophotography_auto",
            "MaterialSymbols.astrophotography_auto()",
            tagIcons::astrophotography_auto_other));
    icons.add(
        new IconCatalogEntry<>(
            "astrophotography_off",
            "MaterialSymbols.astrophotography_off()",
            tagIcons::astrophotography_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "audiotrack", "MaterialSymbols.audiotrack()", tagIcons::audiotrack_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_activity_zone",
            "MaterialSymbols.auto_activity_zone()",
            tagIcons::auto_activity_zone_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_awesome", "MaterialSymbols.auto_awesome()", tagIcons::auto_awesome_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_detect_voice",
            "MaterialSymbols.auto_detect_voice()",
            tagIcons::auto_detect_voice_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_draw_solid",
            "MaterialSymbols.auto_draw_solid()",
            tagIcons::auto_draw_solid_other));
    icons.add(
        new IconCatalogEntry<>("auto_fix", "MaterialSymbols.auto_fix()", tagIcons::auto_fix_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_fix_high", "MaterialSymbols.auto_fix_high()", tagIcons::auto_fix_high_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_fix_normal",
            "MaterialSymbols.auto_fix_normal()",
            tagIcons::auto_fix_normal_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_fix_off", "MaterialSymbols.auto_fix_off()", tagIcons::auto_fix_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_graph", "MaterialSymbols.auto_graph()", tagIcons::auto_graph_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_label", "MaterialSymbols.auto_label()", tagIcons::auto_label_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_meeting_room",
            "MaterialSymbols.auto_meeting_room()",
            tagIcons::auto_meeting_room_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_mode", "MaterialSymbols.auto_mode()", tagIcons::auto_mode_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_schedule", "MaterialSymbols.auto_schedule()", tagIcons::auto_schedule_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_timer", "MaterialSymbols.auto_timer()", tagIcons::auto_timer_other));
    icons.add(
        new IconCatalogEntry<>(
            "auto_videocam", "MaterialSymbols.auto_videocam()", tagIcons::auto_videocam_other));
    icons.add(
        new IconCatalogEntry<>("autopay", "MaterialSymbols.autopay()", tagIcons::autopay_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_20", "MaterialSymbols.battery_20()", tagIcons::battery_20_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_30", "MaterialSymbols.battery_30()", tagIcons::battery_30_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_50", "MaterialSymbols.battery_50()", tagIcons::battery_50_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_60", "MaterialSymbols.battery_60()", tagIcons::battery_60_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_80", "MaterialSymbols.battery_80()", tagIcons::battery_80_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_90", "MaterialSymbols.battery_90()", tagIcons::battery_90_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_saver", "MaterialSymbols.battery_saver()", tagIcons::battery_saver_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_std", "MaterialSymbols.battery_std()", tagIcons::battery_std_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_vert_005",
            "MaterialSymbols.battery_vert_005()",
            tagIcons::battery_vert_005_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_vert_020",
            "MaterialSymbols.battery_vert_020()",
            tagIcons::battery_vert_020_other));
    icons.add(
        new IconCatalogEntry<>(
            "battery_vert_050",
            "MaterialSymbols.battery_vert_050()",
            tagIcons::battery_vert_050_other));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth_audio",
            "MaterialSymbols.bluetooth_audio()",
            tagIcons::bluetooth_audio_other));
    icons.add(
        new IconCatalogEntry<>(
            "book_online", "MaterialSymbols.book_online()", tagIcons::book_online_other));
    icons.add(
        new IconCatalogEntry<>(
            "bookmark_border",
            "MaterialSymbols.bookmark_border()",
            tagIcons::bookmark_border_other));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_high",
            "MaterialSymbols.brightness_high()",
            tagIcons::brightness_high_other));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_low", "MaterialSymbols.brightness_low()", tagIcons::brightness_low_other));
    icons.add(
        new IconCatalogEntry<>(
            "browser_not_supported",
            "MaterialSymbols.browser_not_supported()",
            tagIcons::browser_not_supported_other));
    icons.add(
        new IconCatalogEntry<>("business", "MaterialSymbols.business()", tagIcons::business_other));
    icons.add(
        new IconCatalogEntry<>(
            "call_end_alt", "MaterialSymbols.call_end_alt()", tagIcons::call_end_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "camera_alt", "MaterialSymbols.camera_alt()", tagIcons::camera_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "camera_enhance", "MaterialSymbols.camera_enhance()", tagIcons::camera_enhance_other));
    icons.add(
        new IconCatalogEntry<>(
            "camera_front", "MaterialSymbols.camera_front()", tagIcons::camera_front_other));
    icons.add(
        new IconCatalogEntry<>(
            "camera_rear", "MaterialSymbols.camera_rear()", tagIcons::camera_rear_other));
    icons.add(
        new IconCatalogEntry<>(
            "card_giftcard", "MaterialSymbols.card_giftcard()", tagIcons::card_giftcard_other));
    icons.add(
        new IconCatalogEntry<>(
            "charging_station",
            "MaterialSymbols.charging_station()",
            tagIcons::charging_station_other));
    icons.add(
        new IconCatalogEntry<>(
            "chat_bubble_outline",
            "MaterialSymbols.chat_bubble_outline()",
            tagIcons::chat_bubble_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "check_circle_filled",
            "MaterialSymbols.check_circle_filled()",
            tagIcons::check_circle_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "check_circle_outline",
            "MaterialSymbols.check_circle_outline()",
            tagIcons::check_circle_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "class", "MaterialSymbols.class_icon()", tagIcons::class_icon_other));
    icons.add(new IconCatalogEntry<>("clear", "MaterialSymbols.clear()", tagIcons::clear_other));
    icons.add(
        new IconCatalogEntry<>(
            "clear_night", "MaterialSymbols.clear_night()", tagIcons::clear_night_other));
    icons.add(
        new IconCatalogEntry<>(
            "closed_caption_off",
            "MaterialSymbols.closed_caption_off()",
            tagIcons::closed_caption_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "cloud_queue", "MaterialSymbols.cloud_queue()", tagIcons::cloud_queue_other));
    icons.add(new IconCatalogEntry<>("cloudy", "MaterialSymbols.cloudy()", tagIcons::cloudy_other));
    icons.add(
        new IconCatalogEntry<>(
            "cloudy_filled", "MaterialSymbols.cloudy_filled()", tagIcons::cloudy_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "cloudy_snowing", "MaterialSymbols.cloudy_snowing()", tagIcons::cloudy_snowing_other));
    icons.add(
        new IconCatalogEntry<>(
            "collections", "MaterialSymbols.collections()", tagIcons::collections_other));
    icons.add(
        new IconCatalogEntry<>(
            "color_lens", "MaterialSymbols.color_lens()", tagIcons::color_lens_other));
    icons.add(
        new IconCatalogEntry<>(
            "communities_filled",
            "MaterialSymbols.communities_filled()",
            tagIcons::communities_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "contact_phone_filled",
            "MaterialSymbols.contact_phone_filled()",
            tagIcons::contact_phone_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "control_point", "MaterialSymbols.control_point()", tagIcons::control_point_other));
    icons.add(new IconCatalogEntry<>("create", "MaterialSymbols.create()", tagIcons::create_other));
    icons.add(
        new IconCatalogEntry<>("crop_din", "MaterialSymbols.crop_din()", tagIcons::crop_din_other));
    icons.add(
        new IconCatalogEntry<>(
            "crop_original", "MaterialSymbols.crop_original()", tagIcons::crop_original_other));
    icons.add(new IconCatalogEntry<>("cut", "MaterialSymbols.cut()", tagIcons::cut_other));
    icons.add(
        new IconCatalogEntry<>(
            "data_saver_off", "MaterialSymbols.data_saver_off()", tagIcons::data_saver_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "delete_outline", "MaterialSymbols.delete_outline()", tagIcons::delete_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "delivery_dining",
            "MaterialSymbols.delivery_dining()",
            tagIcons::delivery_dining_other));
    icons.add(
        new IconCatalogEntry<>(
            "developer_mode", "MaterialSymbols.developer_mode()", tagIcons::developer_mode_other));
    icons.add(
        new IconCatalogEntry<>(
            "device_reset", "MaterialSymbols.device_reset()", tagIcons::device_reset_other));
    icons.add(
        new IconCatalogEntry<>(
            "device_unknown", "MaterialSymbols.device_unknown()", tagIcons::device_unknown_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_boat_filled",
            "MaterialSymbols.directions_boat_filled()",
            tagIcons::directions_boat_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_bus_filled",
            "MaterialSymbols.directions_bus_filled()",
            tagIcons::directions_bus_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_car_filled",
            "MaterialSymbols.directions_car_filled()",
            tagIcons::directions_car_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_railway_filled",
            "MaterialSymbols.directions_railway_filled()",
            tagIcons::directions_railway_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_subway_filled",
            "MaterialSymbols.directions_subway_filled()",
            tagIcons::directions_subway_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "directions_transit",
            "MaterialSymbols.directions_transit()",
            tagIcons::directions_transit_other));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "directions_transit_filled",
            "MaterialSymbols.directions_transit_filled()",
            tagIcons::directions_transit_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_disturb", "MaterialSymbols.do_disturb()", tagIcons::do_disturb_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_disturb_alt", "MaterialSymbols.do_disturb_alt()", tagIcons::do_disturb_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_disturb_off", "MaterialSymbols.do_disturb_off()", tagIcons::do_disturb_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_disturb_on", "MaterialSymbols.do_disturb_on()", tagIcons::do_disturb_on_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_not_disturb", "MaterialSymbols.do_not_disturb()", tagIcons::do_not_disturb_other));
    icons.add(
        new IconCatalogEntry<>(
            "do_not_disturb_alt",
            "MaterialSymbols.do_not_disturb_alt()",
            tagIcons::do_not_disturb_alt_other));
    icons.add(new IconCatalogEntry<>("dock", "MaterialSymbols.dock()", tagIcons::dock_other));
    icons.add(new IconCatalogEntry<>("done", "MaterialSymbols.done()", tagIcons::done_other));
    icons.add(
        new IconCatalogEntry<>(
            "drawing_recognition",
            "MaterialSymbols.drawing_recognition()",
            tagIcons::drawing_recognition_other));
    icons.add(
        new IconCatalogEntry<>(
            "drive_eta", "MaterialSymbols.drive_eta()", tagIcons::drive_eta_other));
    icons.add(
        new IconCatalogEntry<>(
            "drive_file_move_outline",
            "MaterialSymbols.drive_file_move_outline()",
            tagIcons::drive_file_move_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "drive_file_move_rtl",
            "MaterialSymbols.drive_file_move_rtl()",
            tagIcons::drive_file_move_rtl_other));
    icons.add(
        new IconCatalogEntry<>(
            "drive_file_rename_outline",
            "MaterialSymbols.drive_file_rename_outline()",
            tagIcons::drive_file_rename_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "edgesensor_high",
            "MaterialSymbols.edgesensor_high()",
            tagIcons::edgesensor_high_other));
    icons.add(
        new IconCatalogEntry<>(
            "edgesensor_low", "MaterialSymbols.edgesensor_low()", tagIcons::edgesensor_low_other));
    icons.add(new IconCatalogEntry<>("email", "MaterialSymbols.email()", tagIcons::email_other));
    icons.add(
        new IconCatalogEntry<>(
            "emoji_emotions", "MaterialSymbols.emoji_emotions()", tagIcons::emoji_emotions_other));
    icons.add(
        new IconCatalogEntry<>(
            "emoji_events", "MaterialSymbols.emoji_events()", tagIcons::emoji_events_other));
    icons.add(
        new IconCatalogEntry<>(
            "emoji_flags", "MaterialSymbols.emoji_flags()", tagIcons::emoji_flags_other));
    icons.add(
        new IconCatalogEntry<>(
            "error_circle_rounded",
            "MaterialSymbols.error_circle_rounded()",
            tagIcons::error_circle_rounded_other));
    icons.add(
        new IconCatalogEntry<>(
            "error_outline", "MaterialSymbols.error_outline()", tagIcons::error_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "ev_charger", "MaterialSymbols.ev_charger()", tagIcons::ev_charger_other));
    icons.add(
        new IconCatalogEntry<>(
            "expand_less", "MaterialSymbols.expand_less()", tagIcons::expand_less_other));
    icons.add(
        new IconCatalogEntry<>(
            "expand_more", "MaterialSymbols.expand_more()", tagIcons::expand_more_other));
    icons.add(
        new IconCatalogEntry<>(
            "expension_panels",
            "MaterialSymbols.expension_panels()",
            tagIcons::expension_panels_other));
    icons.add(
        new IconCatalogEntry<>(
            "face_retouching_natural",
            "MaterialSymbols.face_retouching_natural()",
            tagIcons::face_retouching_natural_other));
    icons.add(
        new IconCatalogEntry<>(
            "face_unlock", "MaterialSymbols.face_unlock()", tagIcons::face_unlock_other));
    icons.add(
        new IconCatalogEntry<>(
            "favorite_border",
            "MaterialSymbols.favorite_border()",
            tagIcons::favorite_border_other));
    icons.add(new IconCatalogEntry<>("feed", "MaterialSymbols.feed()", tagIcons::feed_other));
    icons.add(
        new IconCatalogEntry<>(
            "file_download", "MaterialSymbols.file_download()", tagIcons::file_download_other));
    icons.add(
        new IconCatalogEntry<>(
            "file_download_done",
            "MaterialSymbols.file_download_done()",
            tagIcons::file_download_done_other));
    icons.add(
        new IconCatalogEntry<>("file_map", "MaterialSymbols.file_map()", tagIcons::file_map_other));
    icons.add(
        new IconCatalogEntry<>(
            "file_upload", "MaterialSymbols.file_upload()", tagIcons::file_upload_other));
    icons.add(
        new IconCatalogEntry<>(
            "filter_hdr", "MaterialSymbols.filter_hdr()", tagIcons::filter_hdr_other));
    icons.add(
        new IconCatalogEntry<>(
            "filter_list_alt",
            "MaterialSymbols.filter_list_alt()",
            tagIcons::filter_list_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "flag_filled", "MaterialSymbols.flag_filled()", tagIcons::flag_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "flightsmode", "MaterialSymbols.flightsmode()", tagIcons::flightsmode_other));
    icons.add(
        new IconCatalogEntry<>(
            "flourescent", "MaterialSymbols.flourescent()", tagIcons::flourescent_other));
    icons.add(
        new IconCatalogEntry<>("fmd_good", "MaterialSymbols.fmd_good()", tagIcons::fmd_good_other));
    icons.add(
        new IconCatalogEntry<>(
            "free_breakfast", "MaterialSymbols.free_breakfast()", tagIcons::free_breakfast_other));
    icons.add(new IconCatalogEntry<>("games", "MaterialSymbols.games()", tagIcons::games_other));
    icons.add(
        new IconCatalogEntry<>(
            "generating_tokens",
            "MaterialSymbols.generating_tokens()",
            tagIcons::generating_tokens_other));
    icons.add(
        new IconCatalogEntry<>("get_app", "MaterialSymbols.get_app()", tagIcons::get_app_other));
    icons.add(
        new IconCatalogEntry<>(
            "google_plus_reshare",
            "MaterialSymbols.google_plus_reshare()",
            tagIcons::google_plus_reshare_other));
    icons.add(
        new IconCatalogEntry<>("gpp_good", "MaterialSymbols.gpp_good()", tagIcons::gpp_good_other));
    icons.add(
        new IconCatalogEntry<>(
            "gps_fixed", "MaterialSymbols.gps_fixed()", tagIcons::gps_fixed_other));
    icons.add(
        new IconCatalogEntry<>(
            "gps_not_fixed", "MaterialSymbols.gps_not_fixed()", tagIcons::gps_not_fixed_other));
    icons.add(
        new IconCatalogEntry<>("gps_off", "MaterialSymbols.gps_off()", tagIcons::gps_off_other));
    icons.add(new IconCatalogEntry<>("grade", "MaterialSymbols.grade()", tagIcons::grade_other));
    icons.add(
        new IconCatalogEntry<>(
            "handwriting_recognition",
            "MaterialSymbols.handwriting_recognition()",
            tagIcons::handwriting_recognition_other));
    icons.add(
        new IconCatalogEntry<>("headset", "MaterialSymbols.headset()", tagIcons::headset_other));
    icons.add(
        new IconCatalogEntry<>(
            "help_outline", "MaterialSymbols.help_outline()", tagIcons::help_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "highlight_alt", "MaterialSymbols.highlight_alt()", tagIcons::highlight_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "highlight_off", "MaterialSymbols.highlight_off()", tagIcons::highlight_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "home_filled", "MaterialSymbols.home_filled()", tagIcons::home_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "hourglass_full", "MaterialSymbols.hourglass_full()", tagIcons::hourglass_full_other));
    icons.add(new IconCatalogEntry<>("https", "MaterialSymbols.https()", tagIcons::https_other));
    icons.add(
        new IconCatalogEntry<>(
            "image_not_supported",
            "MaterialSymbols.image_not_supported()",
            tagIcons::image_not_supported_other));
    icons.add(
        new IconCatalogEntry<>(
            "import_export", "MaterialSymbols.import_export()", tagIcons::import_export_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_chart_filled",
            "MaterialSymbols.insert_chart_filled()",
            tagIcons::insert_chart_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_chart_outlined",
            "MaterialSymbols.insert_chart_outlined()",
            tagIcons::insert_chart_outlined_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_comment", "MaterialSymbols.insert_comment()", tagIcons::insert_comment_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_drive_file",
            "MaterialSymbols.insert_drive_file()",
            tagIcons::insert_drive_file_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_emoticon",
            "MaterialSymbols.insert_emoticon()",
            tagIcons::insert_emoticon_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_invitation",
            "MaterialSymbols.insert_invitation()",
            tagIcons::insert_invitation_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_link", "MaterialSymbols.insert_link()", tagIcons::insert_link_other));
    icons.add(
        new IconCatalogEntry<>(
            "insert_photo", "MaterialSymbols.insert_photo()", tagIcons::insert_photo_other));
    icons.add(
        new IconCatalogEntry<>("insights", "MaterialSymbols.insights()", tagIcons::insights_other));
    icons.add(
        new IconCatalogEntry<>(
            "install_mobile", "MaterialSymbols.install_mobile()", tagIcons::install_mobile_other));
    icons.add(new IconCatalogEntry<>("iso", "MaterialSymbols.iso()", tagIcons::iso_other));
    icons.add(
        new IconCatalogEntry<>(
            "join_full", "MaterialSymbols.join_full()", tagIcons::join_full_other));
    icons.add(
        new IconCatalogEntry<>("keep_pin", "MaterialSymbols.keep_pin()", tagIcons::keep_pin_other));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_voice", "MaterialSymbols.keyboard_voice()", tagIcons::keyboard_voice_other));
    icons.add(
        new IconCatalogEntry<>(
            "label_important_outline",
            "MaterialSymbols.label_important_outline()",
            tagIcons::label_important_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "label_outline", "MaterialSymbols.label_outline()", tagIcons::label_outline_other));
    icons.add(new IconCatalogEntry<>("laptop", "MaterialSymbols.laptop()", tagIcons::laptop_other));
    icons.add(new IconCatalogEntry<>("launch", "MaterialSymbols.launch()", tagIcons::launch_other));
    icons.add(new IconCatalogEntry<>("lens", "MaterialSymbols.lens()", tagIcons::lens_other));
    icons.add(
        new IconCatalogEntry<>(
            "lightbulb_outline",
            "MaterialSymbols.lightbulb_outline()",
            tagIcons::lightbulb_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_airport", "MaterialSymbols.local_airport()", tagIcons::local_airport_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_grocery_store",
            "MaterialSymbols.local_grocery_store()",
            tagIcons::local_grocery_store_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_hotel", "MaterialSymbols.local_hotel()", tagIcons::local_hotel_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_movies", "MaterialSymbols.local_movies()", tagIcons::local_movies_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_offer", "MaterialSymbols.local_offer()", tagIcons::local_offer_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_phone", "MaterialSymbols.local_phone()", tagIcons::local_phone_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_play", "MaterialSymbols.local_play()", tagIcons::local_play_other));
    icons.add(
        new IconCatalogEntry<>(
            "local_printshop",
            "MaterialSymbols.local_printshop()",
            tagIcons::local_printshop_other));
    icons.add(
        new IconCatalogEntry<>(
            "location_automation",
            "MaterialSymbols.location_automation()",
            tagIcons::location_automation_other));
    icons.add(
        new IconCatalogEntry<>(
            "location_pin", "MaterialSymbols.location_pin()", tagIcons::location_pin_other));
    icons.add(
        new IconCatalogEntry<>(
            "locator_tag", "MaterialSymbols.locator_tag()", tagIcons::locator_tag_other));
    icons.add(
        new IconCatalogEntry<>(
            "lock_outline", "MaterialSymbols.lock_outline()", tagIcons::lock_outline_other));
    icons.add(new IconCatalogEntry<>("loop", "MaterialSymbols.loop()", tagIcons::loop_other));
    icons.add(
        new IconCatalogEntry<>(
            "magic_button", "MaterialSymbols.magic_button()", tagIcons::magic_button_other));
    icons.add(
        new IconCatalogEntry<>(
            "magic_exchange", "MaterialSymbols.magic_exchange()", tagIcons::magic_exchange_other));
    icons.add(
        new IconCatalogEntry<>(
            "magic_tether", "MaterialSymbols.magic_tether()", tagIcons::magic_tether_other));
    icons.add(
        new IconCatalogEntry<>(
            "mail_outline", "MaterialSymbols.mail_outline()", tagIcons::mail_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "maps_home_work", "MaterialSymbols.maps_home_work()", tagIcons::maps_home_work_other));
    icons.add(
        new IconCatalogEntry<>(
            "markunread", "MaterialSymbols.markunread()", tagIcons::markunread_other));
    icons.add(
        new IconCatalogEntry<>("message", "MaterialSymbols.message()", tagIcons::message_other));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>("mic_none", "MaterialSymbols.mic_none()", tagIcons::mic_none_other));
    icons.add(
        new IconCatalogEntry<>(
            "missed_video_call_filled",
            "MaterialSymbols.missed_video_call_filled()",
            tagIcons::missed_video_call_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_friendly",
            "MaterialSymbols.mobile_friendly()",
            tagIcons::mobile_friendly_other));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_screen_share",
            "MaterialSymbols.mobile_screen_share()",
            tagIcons::mobile_screen_share_other));
    icons.add(new IconCatalogEntry<>("mode", "MaterialSymbols.mode()", tagIcons::mode_other));
    icons.add(
        new IconCatalogEntry<>(
            "mode_edit", "MaterialSymbols.mode_edit()", tagIcons::mode_edit_other));
    icons.add(
        new IconCatalogEntry<>(
            "mode_edit_outline",
            "MaterialSymbols.mode_edit_outline()",
            tagIcons::mode_edit_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "monetization_on",
            "MaterialSymbols.monetization_on()",
            tagIcons::monetization_on_other));
    icons.add(
        new IconCatalogEntry<>(
            "money_off_csred",
            "MaterialSymbols.money_off_csred()",
            tagIcons::money_off_csred_other));
    icons.add(
        new IconCatalogEntry<>(
            "motion_photos_off",
            "MaterialSymbols.motion_photos_off()",
            tagIcons::motion_photos_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "motion_photos_pause",
            "MaterialSymbols.motion_photos_pause()",
            tagIcons::motion_photos_pause_other));
    icons.add(
        new IconCatalogEntry<>(
            "movie_creation", "MaterialSymbols.movie_creation()", tagIcons::movie_creation_other));
    icons.add(
        new IconCatalogEntry<>(
            "movie_filter", "MaterialSymbols.movie_filter()", tagIcons::movie_filter_other));
    icons.add(
        new IconCatalogEntry<>(
            "navigate_before",
            "MaterialSymbols.navigate_before()",
            tagIcons::navigate_before_other));
    icons.add(
        new IconCatalogEntry<>(
            "navigate_next", "MaterialSymbols.navigate_next()", tagIcons::navigate_next_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_gale_wifi", "MaterialSymbols.nest_gale_wifi()", tagIcons::nest_gale_wifi_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_locator_tag",
            "MaterialSymbols.nest_locator_tag()",
            tagIcons::nest_locator_tag_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_remote", "MaterialSymbols.nest_remote()", tagIcons::nest_remote_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_wifi_gale", "MaterialSymbols.nest_wifi_gale()", tagIcons::nest_wifi_gale_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_wifi_mistral",
            "MaterialSymbols.nest_wifi_mistral()",
            tagIcons::nest_wifi_mistral_other));
    icons.add(
        new IconCatalogEntry<>(
            "nest_wifi_point_vento",
            "MaterialSymbols.nest_wifi_point_vento()",
            tagIcons::nest_wifi_point_vento_other));
    icons.add(
        new IconCatalogEntry<>(
            "new_releases", "MaterialSymbols.new_releases()", tagIcons::new_releases_other));
    icons.add(
        new IconCatalogEntry<>(
            "nightlight_round",
            "MaterialSymbols.nightlight_round()",
            tagIcons::nightlight_round_other));
    icons.add(
        new IconCatalogEntry<>(
            "nights_stay", "MaterialSymbols.nights_stay()", tagIcons::nights_stay_other));
    icons.add(
        new IconCatalogEntry<>(
            "no_encryption_gmailerrorred",
            "MaterialSymbols.no_encryption_gmailerrorred()",
            tagIcons::no_encryption_gmailerrorred_other));
    icons.add(
        new IconCatalogEntry<>(
            "not_interested", "MaterialSymbols.not_interested()", tagIcons::not_interested_other));
    icons.add(new IconCatalogEntry<>("note", "MaterialSymbols.note()", tagIcons::note_other));
    icons.add(
        new IconCatalogEntry<>(
            "notifications_none",
            "MaterialSymbols.notifications_none()",
            tagIcons::notifications_none_other));
    icons.add(
        new IconCatalogEntry<>(
            "offline_bolt", "MaterialSymbols.offline_bolt()", tagIcons::offline_bolt_other));
    icons.add(
        new IconCatalogEntry<>(
            "offline_share", "MaterialSymbols.offline_share()", tagIcons::offline_share_other));
    icons.add(
        new IconCatalogEntry<>(
            "ondemand_video", "MaterialSymbols.ondemand_video()", tagIcons::ondemand_video_other));
    icons.add(
        new IconCatalogEntry<>(
            "open_in_phone", "MaterialSymbols.open_in_phone()", tagIcons::open_in_phone_other));
    icons.add(
        new IconCatalogEntry<>(
            "outlined_flag", "MaterialSymbols.outlined_flag()", tagIcons::outlined_flag_other));
    icons.add(
        new IconCatalogEntry<>(
            "panorama_fish_eye",
            "MaterialSymbols.panorama_fish_eye()",
            tagIcons::panorama_fish_eye_other));
    icons.add(
        new IconCatalogEntry<>(
            "pause_circle_filled",
            "MaterialSymbols.pause_circle_filled()",
            tagIcons::pause_circle_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "pause_circle_outline",
            "MaterialSymbols.pause_circle_outline()",
            tagIcons::pause_circle_outline_other));
    icons.add(
        new IconCatalogEntry<>("payment", "MaterialSymbols.payment()", tagIcons::payment_other));
    icons.add(new IconCatalogEntry<>("people", "MaterialSymbols.people()", tagIcons::people_other));
    icons.add(
        new IconCatalogEntry<>(
            "people_alt", "MaterialSymbols.people_alt()", tagIcons::people_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "people_outline", "MaterialSymbols.people_outline()", tagIcons::people_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "performance_max",
            "MaterialSymbols.performance_max()",
            tagIcons::performance_max_other));
    icons.add(
        new IconCatalogEntry<>(
            "perm_device_information",
            "MaterialSymbols.perm_device_information()",
            tagIcons::perm_device_information_other));
    icons.add(
        new IconCatalogEntry<>(
            "perm_identity", "MaterialSymbols.perm_identity()", tagIcons::perm_identity_other));
    icons.add(
        new IconCatalogEntry<>(
            "person_add_alt", "MaterialSymbols.person_add_alt()", tagIcons::person_add_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "person_filled", "MaterialSymbols.person_filled()", tagIcons::person_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "person_outline", "MaterialSymbols.person_outline()", tagIcons::person_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "personal_video", "MaterialSymbols.personal_video()", tagIcons::personal_video_other));
    icons.add(new IconCatalogEntry<>("phone", "MaterialSymbols.phone()", tagIcons::phone_other));
    icons.add(
        new IconCatalogEntry<>(
            "phone_alt", "MaterialSymbols.phone_alt()", tagIcons::phone_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "phone_android", "MaterialSymbols.phone_android()", tagIcons::phone_android_other));
    icons.add(
        new IconCatalogEntry<>(
            "phone_iphone", "MaterialSymbols.phone_iphone()", tagIcons::phone_iphone_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink", "MaterialSymbols.phonelink()", tagIcons::phonelink_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_erase",
            "MaterialSymbols.phonelink_erase()",
            tagIcons::phonelink_erase_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_lock", "MaterialSymbols.phonelink_lock()", tagIcons::phonelink_lock_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_off", "MaterialSymbols.phonelink_off()", tagIcons::phonelink_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_ring", "MaterialSymbols.phonelink_ring()", tagIcons::phonelink_ring_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_ring_off",
            "MaterialSymbols.phonelink_ring_off()",
            tagIcons::phonelink_ring_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "phonelink_setup",
            "MaterialSymbols.phonelink_setup()",
            tagIcons::phonelink_setup_other));
    icons.add(
        new IconCatalogEntry<>(
            "photo_filter", "MaterialSymbols.photo_filter()", tagIcons::photo_filter_other));
    icons.add(
        new IconCatalogEntry<>(
            "photo_size_select_actual",
            "MaterialSymbols.photo_size_select_actual()",
            tagIcons::photo_size_select_actual_other));
    icons.add(
        new IconCatalogEntry<>(
            "pie_chart_filled",
            "MaterialSymbols.pie_chart_filled()",
            tagIcons::pie_chart_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "pie_chart_outline",
            "MaterialSymbols.pie_chart_outline()",
            tagIcons::pie_chart_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "pie_chart_outlined",
            "MaterialSymbols.pie_chart_outlined()",
            tagIcons::pie_chart_outlined_other));
    icons.add(new IconCatalogEntry<>("place", "MaterialSymbols.place()", tagIcons::place_other));
    icons.add(
        new IconCatalogEntry<>(
            "play_music", "MaterialSymbols.play_music()", tagIcons::play_music_other));
    icons.add(
        new IconCatalogEntry<>(
            "play_shapes", "MaterialSymbols.play_shapes()", tagIcons::play_shapes_other));
    icons.add(
        new IconCatalogEntry<>("plus_one", "MaterialSymbols.plus_one()", tagIcons::plus_one_other));
    icons.add(new IconCatalogEntry<>("poll", "MaterialSymbols.poll()", tagIcons::poll_other));
    icons.add(
        new IconCatalogEntry<>("portrait", "MaterialSymbols.portrait()", tagIcons::portrait_other));
    icons.add(
        new IconCatalogEntry<>(
            "power_rounded", "MaterialSymbols.power_rounded()", tagIcons::power_rounded_other));
    icons.add(
        new IconCatalogEntry<>("push_pin", "MaterialSymbols.push_pin()", tagIcons::push_pin_other));
    icons.add(
        new IconCatalogEntry<>(
            "query_builder", "MaterialSymbols.query_builder()", tagIcons::query_builder_other));
    icons.add(
        new IconCatalogEntry<>(
            "question_answer",
            "MaterialSymbols.question_answer()",
            tagIcons::question_answer_other));
    icons.add(new IconCatalogEntry<>("queue", "MaterialSymbols.queue()", tagIcons::queue_other));
    icons.add(
        new IconCatalogEntry<>(
            "quiet_time", "MaterialSymbols.quiet_time()", tagIcons::quiet_time_other));
    icons.add(
        new IconCatalogEntry<>(
            "quiet_time_active",
            "MaterialSymbols.quiet_time_active()",
            tagIcons::quiet_time_active_other));
    icons.add(
        new IconCatalogEntry<>(
            "rate_review_rtl",
            "MaterialSymbols.rate_review_rtl()",
            tagIcons::rate_review_rtl_other));
    icons.add(
        new IconCatalogEntry<>(
            "reminders_alt", "MaterialSymbols.reminders_alt()", tagIcons::reminders_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "remove_circle", "MaterialSymbols.remove_circle()", tagIcons::remove_circle_other));
    icons.add(
        new IconCatalogEntry<>(
            "remove_circle_outline",
            "MaterialSymbols.remove_circle_outline()",
            tagIcons::remove_circle_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "remove_red_eye", "MaterialSymbols.remove_red_eye()", tagIcons::remove_red_eye_other));
    icons.add(
        new IconCatalogEntry<>(
            "replay_circle_filled",
            "MaterialSymbols.replay_circle_filled()",
            tagIcons::replay_circle_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "report_gmailerrorred",
            "MaterialSymbols.report_gmailerrorred()",
            tagIcons::report_gmailerrorred_other));
    icons.add(
        new IconCatalogEntry<>(
            "report_problem", "MaterialSymbols.report_problem()", tagIcons::report_problem_other));
    icons.add(
        new IconCatalogEntry<>(
            "restaurant_menu",
            "MaterialSymbols.restaurant_menu()",
            tagIcons::restaurant_menu_other));
    icons.add(
        new IconCatalogEntry<>("restore", "MaterialSymbols.restore()", tagIcons::restore_other));
    icons.add(
        new IconCatalogEntry<>(
            "ring_volume_filled",
            "MaterialSymbols.ring_volume_filled()",
            tagIcons::ring_volume_filled_other));
    icons.add(new IconCatalogEntry<>("room", "MaterialSymbols.room()", tagIcons::room_other));
    icons.add(
        new IconCatalogEntry<>("save_alt", "MaterialSymbols.save_alt()", tagIcons::save_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "screen_lock_landscape",
            "MaterialSymbols.screen_lock_landscape()",
            tagIcons::screen_lock_landscape_other));
    icons.add(
        new IconCatalogEntry<>(
            "screen_lock_portrait",
            "MaterialSymbols.screen_lock_portrait()",
            tagIcons::screen_lock_portrait_other));
    icons.add(
        new IconCatalogEntry<>(
            "screen_lock_rotation",
            "MaterialSymbols.screen_lock_rotation()",
            tagIcons::screen_lock_rotation_other));
    icons.add(
        new IconCatalogEntry<>(
            "screen_rotation",
            "MaterialSymbols.screen_rotation()",
            tagIcons::screen_rotation_other));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot", "MaterialSymbols.screenshot()", tagIcons::screenshot_other));
    icons.add(
        new IconCatalogEntry<>(
            "sd_storage", "MaterialSymbols.sd_storage()", tagIcons::sd_storage_other));
    icons.add(
        new IconCatalogEntry<>(
            "security_update",
            "MaterialSymbols.security_update()",
            tagIcons::security_update_other));
    icons.add(
        new IconCatalogEntry<>(
            "security_update_good",
            "MaterialSymbols.security_update_good()",
            tagIcons::security_update_good_other));
    icons.add(
        new IconCatalogEntry<>(
            "security_update_warning",
            "MaterialSymbols.security_update_warning()",
            tagIcons::security_update_warning_other));
    icons.add(
        new IconCatalogEntry<>(
            "send_to_mobile", "MaterialSymbols.send_to_mobile()", tagIcons::send_to_mobile_other));
    icons.add(
        new IconCatalogEntry<>(
            "sentiment_satisfied_alt",
            "MaterialSymbols.sentiment_satisfied_alt()",
            tagIcons::sentiment_satisfied_alt_other));
  }

  private static void addIcons3() {
    icons.add(
        new IconCatalogEntry<>(
            "settings_cell", "MaterialSymbols.settings_cell()", tagIcons::settings_cell_other));
    icons.add(
        new IconCatalogEntry<>(
            "settings_input_composite",
            "MaterialSymbols.settings_input_composite()",
            tagIcons::settings_input_composite_other));
    icons.add(
        new IconCatalogEntry<>(
            "settings_suggest",
            "MaterialSymbols.settings_suggest()",
            tagIcons::settings_suggest_other));
    icons.add(
        new IconCatalogEntry<>(
            "shape_recognition",
            "MaterialSymbols.shape_recognition()",
            tagIcons::shape_recognition_other));
    icons.add(new IconCatalogEntry<>("shop_2", "MaterialSymbols.shop_2()", tagIcons::shop_2_other));
    icons.add(
        new IconCatalogEntry<>("shortcut", "MaterialSymbols.shortcut()", tagIcons::shortcut_other));
    icons.add(
        new IconCatalogEntry<>(
            "sign_language_2",
            "MaterialSymbols.sign_language_2()",
            tagIcons::sign_language_2_other));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_no_sim",
            "MaterialSymbols.signal_cellular_no_sim()",
            tagIcons::signal_cellular_no_sim_other));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_4_bar_lock",
            "MaterialSymbols.signal_wifi_4_bar_lock()",
            tagIcons::signal_wifi_4_bar_lock_other));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_connected_no_internet_4",
            "MaterialSymbols.signal_wifi_connected_no_internet_4()",
            tagIcons::signal_wifi_connected_no_internet_4_other));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_statusbar_4_bar",
            "MaterialSymbols.signal_wifi_statusbar_4_bar()",
            tagIcons::signal_wifi_statusbar_4_bar_other));
    icons.add(
        new IconCatalogEntry<>(
            "sim_card_alert", "MaterialSymbols.sim_card_alert()", tagIcons::sim_card_alert_other));
    icons.add(new IconCatalogEntry<>("sleep", "MaterialSymbols.sleep()", tagIcons::sleep_other));
    icons.add(
        new IconCatalogEntry<>(
            "smart_button", "MaterialSymbols.smart_button()", tagIcons::smart_button_other));
    icons.add(
        new IconCatalogEntry<>(
            "smart_screen", "MaterialSymbols.smart_screen()", tagIcons::smart_screen_other));
    icons.add(
        new IconCatalogEntry<>(
            "smartphone", "MaterialSymbols.smartphone()", tagIcons::smartphone_other));
    icons.add(
        new IconCatalogEntry<>(
            "smartphone_camera",
            "MaterialSymbols.smartphone_camera()",
            tagIcons::smartphone_camera_other));
    icons.add(
        new IconCatalogEntry<>(
            "sms_failed", "MaterialSymbols.sms_failed()", tagIcons::sms_failed_other));
    icons.add(new IconCatalogEntry<>("source", "MaterialSymbols.source()", tagIcons::source_other));
    icons.add(
        new IconCatalogEntry<>(
            "star_border", "MaterialSymbols.star_border()", tagIcons::star_border_other));
    icons.add(
        new IconCatalogEntry<>(
            "star_border_purple500",
            "MaterialSymbols.star_border_purple500()",
            tagIcons::star_border_purple500_other));
    icons.add(
        new IconCatalogEntry<>(
            "star_outline", "MaterialSymbols.star_outline()", tagIcons::star_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "star_purple500", "MaterialSymbols.star_purple500()", tagIcons::star_purple500_other));
    icons.add(
        new IconCatalogEntry<>(
            "stay_current_landscape",
            "MaterialSymbols.stay_current_landscape()",
            tagIcons::stay_current_landscape_other));
    icons.add(
        new IconCatalogEntry<>(
            "stay_current_portrait",
            "MaterialSymbols.stay_current_portrait()",
            tagIcons::stay_current_portrait_other));
    icons.add(
        new IconCatalogEntry<>(
            "stay_primary_landscape",
            "MaterialSymbols.stay_primary_landscape()",
            tagIcons::stay_primary_landscape_other));
    icons.add(
        new IconCatalogEntry<>(
            "stay_primary_portrait",
            "MaterialSymbols.stay_primary_portrait()",
            tagIcons::stay_primary_portrait_other));
    icons.add(
        new IconCatalogEntry<>(
            "store_mall_directory",
            "MaterialSymbols.store_mall_directory()",
            tagIcons::store_mall_directory_other));
    icons.add(
        new IconCatalogEntry<>(
            "stream_apps", "MaterialSymbols.stream_apps()", tagIcons::stream_apps_other));
    icons.add(
        new IconCatalogEntry<>(
            "system_security_update",
            "MaterialSymbols.system_security_update()",
            tagIcons::system_security_update_other));
    icons.add(
        new IconCatalogEntry<>(
            "system_security_update_good",
            "MaterialSymbols.system_security_update_good()",
            tagIcons::system_security_update_good_other));
    icons.add(
        new IconCatalogEntry<>(
            "system_security_update_warning",
            "MaterialSymbols.system_security_update_warning()",
            tagIcons::system_security_update_warning_other));
    icons.add(
        new IconCatalogEntry<>(
            "system_update", "MaterialSymbols.system_update()", tagIcons::system_update_other));
    icons.add(
        new IconCatalogEntry<>(
            "tag_faces", "MaterialSymbols.tag_faces()", tagIcons::tag_faces_other));
    icons.add(
        new IconCatalogEntry<>(
            "tap_and_play", "MaterialSymbols.tap_and_play()", tagIcons::tap_and_play_other));
    icons.add(
        new IconCatalogEntry<>(
            "temp_preferences_custom",
            "MaterialSymbols.temp_preferences_custom()",
            tagIcons::temp_preferences_custom_other));
    icons.add(
        new IconCatalogEntry<>("terrain", "MaterialSymbols.terrain()", tagIcons::terrain_other));
    icons.add(
        new IconCatalogEntry<>("textsms", "MaterialSymbols.textsms()", tagIcons::textsms_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_down_alt", "MaterialSymbols.thumb_down_alt()", tagIcons::thumb_down_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_down_filled",
            "MaterialSymbols.thumb_down_filled()",
            tagIcons::thumb_down_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_down_off", "MaterialSymbols.thumb_down_off()", tagIcons::thumb_down_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_down_off_alt",
            "MaterialSymbols.thumb_down_off_alt()",
            tagIcons::thumb_down_off_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_up_alt", "MaterialSymbols.thumb_up_alt()", tagIcons::thumb_up_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_up_filled",
            "MaterialSymbols.thumb_up_filled()",
            tagIcons::thumb_up_filled_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_up_off", "MaterialSymbols.thumb_up_off()", tagIcons::thumb_up_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "thumb_up_off_alt",
            "MaterialSymbols.thumb_up_off_alt()",
            tagIcons::thumb_up_off_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "time_to_leave", "MaterialSymbols.time_to_leave()", tagIcons::time_to_leave_other));
    icons.add(
        new IconCatalogEntry<>(
            "tips_and_updates",
            "MaterialSymbols.tips_and_updates()",
            tagIcons::tips_and_updates_other));
    icons.add(
        new IconCatalogEntry<>(
            "tools_wrench", "MaterialSymbols.tools_wrench()", tagIcons::tools_wrench_other));
    icons.add(
        new IconCatalogEntry<>(
            "transcribe", "MaterialSymbols.transcribe()", tagIcons::transcribe_other));
    icons.add(
        new IconCatalogEntry<>("try", "MaterialSymbols.try_icon()", tagIcons::try_icon_other));
    icons.add(
        new IconCatalogEntry<>("tungsten", "MaterialSymbols.tungsten()", tagIcons::tungsten_other));
    icons.add(
        new IconCatalogEntry<>(
            "turned_in", "MaterialSymbols.turned_in()", tagIcons::turned_in_other));
    icons.add(
        new IconCatalogEntry<>(
            "turned_in_not", "MaterialSymbols.turned_in_not()", tagIcons::turned_in_not_other));
    icons.add(
        new IconCatalogEntry<>(
            "unknown_7", "MaterialSymbols.unknown_7()", tagIcons::unknown_7_other));
    icons.add(new IconCatalogEntry<>("unpin", "MaterialSymbols.unpin()", tagIcons::unpin_other));
    icons.add(
        new IconCatalogEntry<>(
            "vibration", "MaterialSymbols.vibration()", tagIcons::vibration_other));
    icons.add(
        new IconCatalogEntry<>(
            "view_in_ar_new", "MaterialSymbols.view_in_ar_new()", tagIcons::view_in_ar_new_other));
    icons.add(new IconCatalogEntry<>("vitals", "MaterialSymbols.vitals()", tagIcons::vitals_other));
    icons.add(
        new IconCatalogEntry<>(
            "volume_down_alt",
            "MaterialSymbols.volume_down_alt()",
            tagIcons::volume_down_alt_other));
    icons.add(
        new IconCatalogEntry<>(
            "warning_amber", "MaterialSymbols.warning_amber()", tagIcons::warning_amber_other));
    icons.add(
        new IconCatalogEntry<>(
            "watch_later", "MaterialSymbols.watch_later()", tagIcons::watch_later_other));
    icons.add(
        new IconCatalogEntry<>(
            "wb_cloudy", "MaterialSymbols.wb_cloudy()", tagIcons::wb_cloudy_other));
    icons.add(new IconCatalogEntry<>("width", "MaterialSymbols.width()", tagIcons::width_other));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_1", "MaterialSymbols.wifi_calling_1()", tagIcons::wifi_calling_1_other));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_2", "MaterialSymbols.wifi_calling_2()", tagIcons::wifi_calling_2_other));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_3", "MaterialSymbols.wifi_calling_3()", tagIcons::wifi_calling_3_other));
    icons.add(
        new IconCatalogEntry<>("work_off", "MaterialSymbols.work_off()", tagIcons::work_off_other));
    icons.add(
        new IconCatalogEntry<>(
            "work_outline", "MaterialSymbols.work_outline()", tagIcons::work_outline_other));
    icons.add(
        new IconCatalogEntry<>("workflow", "MaterialSymbols.workflow()", tagIcons::workflow_other));
    icons.add(
        new IconCatalogEntry<>(
            "workspaces_outline",
            "MaterialSymbols.workspaces_outline()",
            tagIcons::workspaces_outline_other));
    icons.add(
        new IconCatalogEntry<>(
            "youtube_activity",
            "MaterialSymbols.youtube_activity()",
            tagIcons::youtube_activity_other));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
