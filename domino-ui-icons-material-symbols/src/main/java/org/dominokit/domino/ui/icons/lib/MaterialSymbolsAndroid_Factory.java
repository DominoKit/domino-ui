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
import org.dominokit.domino.ui.icons.MaterialSymbolsAndroid;
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Static icon factory for the Material Symbols Android category. */
public final class MaterialSymbolsAndroid_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsAndroid tagIcons = new MaterialSymbolsAndroid() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "1x_mobiledata", "MaterialSymbols._1x_mobiledata()", tagIcons::_1x_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "1x_mobiledata_badge",
            "MaterialSymbols._1x_mobiledata_badge()",
            tagIcons::_1x_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "3g_mobiledata", "MaterialSymbols._3g_mobiledata()", tagIcons::_3g_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "3g_mobiledata_badge",
            "MaterialSymbols._3g_mobiledata_badge()",
            tagIcons::_3g_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "4g_mobiledata", "MaterialSymbols._4g_mobiledata()", tagIcons::_4g_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "4g_mobiledata_badge",
            "MaterialSymbols._4g_mobiledata_badge()",
            tagIcons::_4g_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "4g_plus_mobiledata",
            "MaterialSymbols._4g_plus_mobiledata()",
            tagIcons::_4g_plus_mobiledata_android));
    icons.add(new IconCatalogEntry<>("5g", "MaterialSymbols._5g()", tagIcons::_5g_android));
    icons.add(
        new IconCatalogEntry<>(
            "5g_mobiledata_badge",
            "MaterialSymbols._5g_mobiledata_badge()",
            tagIcons::_5g_mobiledata_badge_android));
    icons.add(new IconCatalogEntry<>("adb", "MaterialSymbols.adb()", tagIcons::adb_android));
    icons.add(
        new IconCatalogEntry<>(
            "airplanemode_inactive",
            "MaterialSymbols.airplanemode_inactive()",
            tagIcons::airplanemode_inactive_android));
    icons.add(
        new IconCatalogEntry<>("android", "MaterialSymbols.android()", tagIcons::android_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_4_bar",
            "MaterialSymbols.android_cell_4_bar()",
            tagIcons::android_cell_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_4_bar_alert",
            "MaterialSymbols.android_cell_4_bar_alert()",
            tagIcons::android_cell_4_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_4_bar_off",
            "MaterialSymbols.android_cell_4_bar_off()",
            tagIcons::android_cell_4_bar_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_4_bar_plus",
            "MaterialSymbols.android_cell_4_bar_plus()",
            tagIcons::android_cell_4_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_5_bar",
            "MaterialSymbols.android_cell_5_bar()",
            tagIcons::android_cell_5_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_5_bar_alert",
            "MaterialSymbols.android_cell_5_bar_alert()",
            tagIcons::android_cell_5_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_5_bar_off",
            "MaterialSymbols.android_cell_5_bar_off()",
            tagIcons::android_cell_5_bar_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_5_bar_plus",
            "MaterialSymbols.android_cell_5_bar_plus()",
            tagIcons::android_cell_5_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_4_bar",
            "MaterialSymbols.android_cell_dual_4_bar()",
            tagIcons::android_cell_dual_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_4_bar_alert",
            "MaterialSymbols.android_cell_dual_4_bar_alert()",
            tagIcons::android_cell_dual_4_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_4_bar_plus",
            "MaterialSymbols.android_cell_dual_4_bar_plus()",
            tagIcons::android_cell_dual_4_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_5_bar",
            "MaterialSymbols.android_cell_dual_5_bar()",
            tagIcons::android_cell_dual_5_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_5_bar_alert",
            "MaterialSymbols.android_cell_dual_5_bar_alert()",
            tagIcons::android_cell_dual_5_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_cell_dual_5_bar_plus",
            "MaterialSymbols.android_cell_dual_5_bar_plus()",
            tagIcons::android_cell_dual_5_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar",
            "MaterialSymbols.android_wifi_3_bar()",
            tagIcons::android_wifi_3_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar_alert",
            "MaterialSymbols.android_wifi_3_bar_alert()",
            tagIcons::android_wifi_3_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar_lock",
            "MaterialSymbols.android_wifi_3_bar_lock()",
            tagIcons::android_wifi_3_bar_lock_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar_off",
            "MaterialSymbols.android_wifi_3_bar_off()",
            tagIcons::android_wifi_3_bar_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar_plus",
            "MaterialSymbols.android_wifi_3_bar_plus()",
            tagIcons::android_wifi_3_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_3_bar_question",
            "MaterialSymbols.android_wifi_3_bar_question()",
            tagIcons::android_wifi_3_bar_question_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar",
            "MaterialSymbols.android_wifi_4_bar()",
            tagIcons::android_wifi_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar_alert",
            "MaterialSymbols.android_wifi_4_bar_alert()",
            tagIcons::android_wifi_4_bar_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar_lock",
            "MaterialSymbols.android_wifi_4_bar_lock()",
            tagIcons::android_wifi_4_bar_lock_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar_off",
            "MaterialSymbols.android_wifi_4_bar_off()",
            tagIcons::android_wifi_4_bar_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar_plus",
            "MaterialSymbols.android_wifi_4_bar_plus()",
            tagIcons::android_wifi_4_bar_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "android_wifi_4_bar_question",
            "MaterialSymbols.android_wifi_4_bar_question()",
            tagIcons::android_wifi_4_bar_question_android));
    icons.add(
        new IconCatalogEntry<>(
            "apk_document", "MaterialSymbols.apk_document()", tagIcons::apk_document_android));
    icons.add(
        new IconCatalogEntry<>(
            "apk_install", "MaterialSymbols.apk_install()", tagIcons::apk_install_android));
    icons.add(
        new IconCatalogEntry<>(
            "backlight_high",
            "MaterialSymbols.backlight_high()",
            tagIcons::backlight_high_android));
    icons.add(
        new IconCatalogEntry<>(
            "backlight_high_off",
            "MaterialSymbols.backlight_high_off()",
            tagIcons::backlight_high_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "backlight_low", "MaterialSymbols.backlight_low()", tagIcons::backlight_low_android));
    icons.add(
        new IconCatalogEntry<>(
            "badge_critical_battery",
            "MaterialSymbols.badge_critical_battery()",
            tagIcons::badge_critical_battery_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_0_bar", "MaterialSymbols.battery_0_bar()", tagIcons::battery_0_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_1_bar", "MaterialSymbols.battery_1_bar()", tagIcons::battery_1_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_2_bar", "MaterialSymbols.battery_2_bar()", tagIcons::battery_2_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_3_bar", "MaterialSymbols.battery_3_bar()", tagIcons::battery_3_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_4_bar", "MaterialSymbols.battery_4_bar()", tagIcons::battery_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_5_bar", "MaterialSymbols.battery_5_bar()", tagIcons::battery_5_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_6_bar", "MaterialSymbols.battery_6_bar()", tagIcons::battery_6_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_alert", "MaterialSymbols.battery_alert()", tagIcons::battery_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_0",
            "MaterialSymbols.battery_android_0()",
            tagIcons::battery_android_0_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_1",
            "MaterialSymbols.battery_android_1()",
            tagIcons::battery_android_1_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_2",
            "MaterialSymbols.battery_android_2()",
            tagIcons::battery_android_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_3",
            "MaterialSymbols.battery_android_3()",
            tagIcons::battery_android_3_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_4",
            "MaterialSymbols.battery_android_4()",
            tagIcons::battery_android_4_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_5",
            "MaterialSymbols.battery_android_5()",
            tagIcons::battery_android_5_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_6",
            "MaterialSymbols.battery_android_6()",
            tagIcons::battery_android_6_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_alert",
            "MaterialSymbols.battery_android_alert()",
            tagIcons::battery_android_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_bolt",
            "MaterialSymbols.battery_android_bolt()",
            tagIcons::battery_android_bolt_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_1",
            "MaterialSymbols.battery_android_frame_1()",
            tagIcons::battery_android_frame_1_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_2",
            "MaterialSymbols.battery_android_frame_2()",
            tagIcons::battery_android_frame_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_3",
            "MaterialSymbols.battery_android_frame_3()",
            tagIcons::battery_android_frame_3_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_4",
            "MaterialSymbols.battery_android_frame_4()",
            tagIcons::battery_android_frame_4_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_5",
            "MaterialSymbols.battery_android_frame_5()",
            tagIcons::battery_android_frame_5_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_6",
            "MaterialSymbols.battery_android_frame_6()",
            tagIcons::battery_android_frame_6_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_alert",
            "MaterialSymbols.battery_android_frame_alert()",
            tagIcons::battery_android_frame_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_bolt",
            "MaterialSymbols.battery_android_frame_bolt()",
            tagIcons::battery_android_frame_bolt_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_full",
            "MaterialSymbols.battery_android_frame_full()",
            tagIcons::battery_android_frame_full_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_plus",
            "MaterialSymbols.battery_android_frame_plus()",
            tagIcons::battery_android_frame_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_question",
            "MaterialSymbols.battery_android_frame_question()",
            tagIcons::battery_android_frame_question_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_share",
            "MaterialSymbols.battery_android_frame_share()",
            tagIcons::battery_android_frame_share_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_frame_shield",
            "MaterialSymbols.battery_android_frame_shield()",
            tagIcons::battery_android_frame_shield_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_full",
            "MaterialSymbols.battery_android_full()",
            tagIcons::battery_android_full_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_plus",
            "MaterialSymbols.battery_android_plus()",
            tagIcons::battery_android_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_question",
            "MaterialSymbols.battery_android_question()",
            tagIcons::battery_android_question_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_share",
            "MaterialSymbols.battery_android_share()",
            tagIcons::battery_android_share_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_android_shield",
            "MaterialSymbols.battery_android_shield()",
            tagIcons::battery_android_shield_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_change",
            "MaterialSymbols.battery_change()",
            tagIcons::battery_change_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_20",
            "MaterialSymbols.battery_charging_20()",
            tagIcons::battery_charging_20_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_20_2",
            "MaterialSymbols.battery_charging_20_2()",
            tagIcons::battery_charging_20_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_30",
            "MaterialSymbols.battery_charging_30()",
            tagIcons::battery_charging_30_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_30_2",
            "MaterialSymbols.battery_charging_30_2()",
            tagIcons::battery_charging_30_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_50",
            "MaterialSymbols.battery_charging_50()",
            tagIcons::battery_charging_50_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_50_2",
            "MaterialSymbols.battery_charging_50_2()",
            tagIcons::battery_charging_50_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_60",
            "MaterialSymbols.battery_charging_60()",
            tagIcons::battery_charging_60_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_60_2",
            "MaterialSymbols.battery_charging_60_2()",
            tagIcons::battery_charging_60_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_80",
            "MaterialSymbols.battery_charging_80()",
            tagIcons::battery_charging_80_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_80_2",
            "MaterialSymbols.battery_charging_80_2()",
            tagIcons::battery_charging_80_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_90",
            "MaterialSymbols.battery_charging_90()",
            tagIcons::battery_charging_90_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_full",
            "MaterialSymbols.battery_charging_full()",
            tagIcons::battery_charging_full_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_charging_full_2",
            "MaterialSymbols.battery_charging_full_2()",
            tagIcons::battery_charging_full_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_error", "MaterialSymbols.battery_error()", tagIcons::battery_error_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_full", "MaterialSymbols.battery_full()", tagIcons::battery_full_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_full_alt",
            "MaterialSymbols.battery_full_alt()",
            tagIcons::battery_full_alt_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_low", "MaterialSymbols.battery_low()", tagIcons::battery_low_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_plus", "MaterialSymbols.battery_plus()", tagIcons::battery_plus_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_share", "MaterialSymbols.battery_share()", tagIcons::battery_share_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_status_good",
            "MaterialSymbols.battery_status_good()",
            tagIcons::battery_status_good_android));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "battery_unknown",
            "MaterialSymbols.battery_unknown()",
            tagIcons::battery_unknown_android));
    icons.add(
        new IconCatalogEntry<>(
            "battery_very_low",
            "MaterialSymbols.battery_very_low()",
            tagIcons::battery_very_low_android));
    icons.add(
        new IconCatalogEntry<>(
            "bigtop_updates",
            "MaterialSymbols.bigtop_updates()",
            tagIcons::bigtop_updates_android));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth", "MaterialSymbols.bluetooth()", tagIcons::bluetooth_android));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth_connected",
            "MaterialSymbols.bluetooth_connected()",
            tagIcons::bluetooth_connected_android));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth_disabled",
            "MaterialSymbols.bluetooth_disabled()",
            tagIcons::bluetooth_disabled_android));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth_drive",
            "MaterialSymbols.bluetooth_drive()",
            tagIcons::bluetooth_drive_android));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth_searching",
            "MaterialSymbols.bluetooth_searching()",
            tagIcons::bluetooth_searching_android));
    icons.add(
        new IconCatalogEntry<>(
            "bolt_boost", "MaterialSymbols.bolt_boost()", tagIcons::bolt_boost_android));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_alert",
            "MaterialSymbols.brightness_alert()",
            tagIcons::brightness_alert_android));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_auto",
            "MaterialSymbols.brightness_auto()",
            tagIcons::brightness_auto_android));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_empty",
            "MaterialSymbols.brightness_empty()",
            tagIcons::brightness_empty_android));
    icons.add(
        new IconCatalogEntry<>(
            "brightness_medium",
            "MaterialSymbols.brightness_medium()",
            tagIcons::brightness_medium_android));
    icons.add(new IconCatalogEntry<>("cable", "MaterialSymbols.cable()", tagIcons::cable_android));
    icons.add(
        new IconCatalogEntry<>(
            "cameraswitch", "MaterialSymbols.cameraswitch()", tagIcons::cameraswitch_android));
    icons.add(
        new IconCatalogEntry<>("charger", "MaterialSymbols.charger()", tagIcons::charger_android));
    icons.add(
        new IconCatalogEntry<>(
            "contextual_token",
            "MaterialSymbols.contextual_token()",
            tagIcons::contextual_token_android));
    icons.add(
        new IconCatalogEntry<>(
            "contextual_token_add",
            "MaterialSymbols.contextual_token_add()",
            tagIcons::contextual_token_add_android));
    icons.add(
        new IconCatalogEntry<>(
            "dark_mode", "MaterialSymbols.dark_mode()", tagIcons::dark_mode_android));
    icons.add(
        new IconCatalogEntry<>(
            "data_saver_on", "MaterialSymbols.data_saver_on()", tagIcons::data_saver_on_android));
    icons.add(
        new IconCatalogEntry<>(
            "data_usage", "MaterialSymbols.data_usage()", tagIcons::data_usage_android));
    icons.add(
        new IconCatalogEntry<>(
            "devices_fold", "MaterialSymbols.devices_fold()", tagIcons::devices_fold_android));
    icons.add(
        new IconCatalogEntry<>(
            "devices_fold_2",
            "MaterialSymbols.devices_fold_2()",
            tagIcons::devices_fold_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "display_external_input",
            "MaterialSymbols.display_external_input()",
            tagIcons::display_external_input_android));
    icons.add(
        new IconCatalogEntry<>(
            "do_not_disturb_on_total_silence",
            "MaterialSymbols.do_not_disturb_on_total_silence()",
            tagIcons::do_not_disturb_on_total_silence_android));
    icons.add(
        new IconCatalogEntry<>(
            "dock_to_bottom",
            "MaterialSymbols.dock_to_bottom()",
            tagIcons::dock_to_bottom_android));
    icons.add(
        new IconCatalogEntry<>(
            "dock_to_left", "MaterialSymbols.dock_to_left()", tagIcons::dock_to_left_android));
    icons.add(
        new IconCatalogEntry<>(
            "dock_to_right", "MaterialSymbols.dock_to_right()", tagIcons::dock_to_right_android));
    icons.add(
        new IconCatalogEntry<>(
            "dual_screen", "MaterialSymbols.dual_screen()", tagIcons::dual_screen_android));
    icons.add(new IconCatalogEntry<>("dvr", "MaterialSymbols.dvr()", tagIcons::dvr_android));
    icons.add(
        new IconCatalogEntry<>(
            "e_mobiledata", "MaterialSymbols.e_mobiledata()", tagIcons::e_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "e_mobiledata_badge",
            "MaterialSymbols.e_mobiledata_badge()",
            tagIcons::e_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "ev_mobiledata_badge",
            "MaterialSymbols.ev_mobiledata_badge()",
            tagIcons::ev_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "flashlight_off",
            "MaterialSymbols.flashlight_off()",
            tagIcons::flashlight_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "flashlight_on", "MaterialSymbols.flashlight_on()", tagIcons::flashlight_on_android));
    icons.add(
        new IconCatalogEntry<>(
            "g_mobiledata", "MaterialSymbols.g_mobiledata()", tagIcons::g_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "g_mobiledata_badge",
            "MaterialSymbols.g_mobiledata_badge()",
            tagIcons::g_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "globe_2_cancel",
            "MaterialSymbols.globe_2_cancel()",
            tagIcons::globe_2_cancel_android));
    icons.add(
        new IconCatalogEntry<>(
            "globe_2_question",
            "MaterialSymbols.globe_2_question()",
            tagIcons::globe_2_question_android));
    icons.add(
        new IconCatalogEntry<>("gpp_bad", "MaterialSymbols.gpp_bad()", tagIcons::gpp_bad_android));
    icons.add(
        new IconCatalogEntry<>(
            "gpp_maybe", "MaterialSymbols.gpp_maybe()", tagIcons::gpp_maybe_android));
    icons.add(
        new IconCatalogEntry<>(
            "graphic_eq", "MaterialSymbols.graphic_eq()", tagIcons::graphic_eq_android));
    icons.add(
        new IconCatalogEntry<>(
            "graphic_eq_off",
            "MaterialSymbols.graphic_eq_off()",
            tagIcons::graphic_eq_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "grid_3x3", "MaterialSymbols.grid_3x3()", tagIcons::grid_3x3_android));
    icons.add(
        new IconCatalogEntry<>(
            "grid_3x3_off", "MaterialSymbols.grid_3x3_off()", tagIcons::grid_3x3_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "grid_4x4", "MaterialSymbols.grid_4x4()", tagIcons::grid_4x4_android));
    icons.add(
        new IconCatalogEntry<>(
            "grid_goldenratio",
            "MaterialSymbols.grid_goldenratio()",
            tagIcons::grid_goldenratio_android));
    icons.add(
        new IconCatalogEntry<>(
            "h_mobiledata", "MaterialSymbols.h_mobiledata()", tagIcons::h_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "h_mobiledata_badge",
            "MaterialSymbols.h_mobiledata_badge()",
            tagIcons::h_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "h_plus_mobiledata",
            "MaterialSymbols.h_plus_mobiledata()",
            tagIcons::h_plus_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "h_plus_mobiledata_badge",
            "MaterialSymbols.h_plus_mobiledata_badge()",
            tagIcons::h_plus_mobiledata_badge_android));
    icons.add(new IconCatalogEntry<>("ios", "MaterialSymbols.ios()", tagIcons::ios_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_capslock_badge",
            "MaterialSymbols.keyboard_capslock_badge()",
            tagIcons::keyboard_capslock_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_external_input",
            "MaterialSymbols.keyboard_external_input()",
            tagIcons::keyboard_external_input_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_full", "MaterialSymbols.keyboard_full()", tagIcons::keyboard_full_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_keys", "MaterialSymbols.keyboard_keys()", tagIcons::keyboard_keys_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_off", "MaterialSymbols.keyboard_off()", tagIcons::keyboard_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_onscreen",
            "MaterialSymbols.keyboard_onscreen()",
            tagIcons::keyboard_onscreen_android));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_previous_language",
            "MaterialSymbols.keyboard_previous_language()",
            tagIcons::keyboard_previous_language_android));
    icons.add(
        new IconCatalogEntry<>(
            "light_mode", "MaterialSymbols.light_mode()", tagIcons::light_mode_android));
    icons.add(
        new IconCatalogEntry<>(
            "light_mode_auto",
            "MaterialSymbols.light_mode_auto()",
            tagIcons::light_mode_auto_android));
    icons.add(
        new IconCatalogEntry<>(
            "lte_mobiledata",
            "MaterialSymbols.lte_mobiledata()",
            tagIcons::lte_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "lte_mobiledata_badge",
            "MaterialSymbols.lte_mobiledata_badge()",
            tagIcons::lte_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "lte_plus_mobiledata",
            "MaterialSymbols.lte_plus_mobiledata()",
            tagIcons::lte_plus_mobiledata_android));
    icons.add(
        new IconCatalogEntry<>(
            "lte_plus_mobiledata_badge",
            "MaterialSymbols.lte_plus_mobiledata_badge()",
            tagIcons::lte_plus_mobiledata_badge_android));
    icons.add(
        new IconCatalogEntry<>(
            "magnify_docked",
            "MaterialSymbols.magnify_docked()",
            tagIcons::magnify_docked_android));
    icons.add(
        new IconCatalogEntry<>(
            "magnify_fullscreen",
            "MaterialSymbols.magnify_fullscreen()",
            tagIcons::magnify_fullscreen_android));
    icons.add(
        new IconCatalogEntry<>(
            "media_bluetooth_off",
            "MaterialSymbols.media_bluetooth_off()",
            tagIcons::media_bluetooth_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "media_bluetooth_on",
            "MaterialSymbols.media_bluetooth_on()",
            tagIcons::media_bluetooth_on_android));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_sensor_hi",
            "MaterialSymbols.mobile_sensor_hi()",
            tagIcons::mobile_sensor_hi_android));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_sensor_lo",
            "MaterialSymbols.mobile_sensor_lo()",
            tagIcons::mobile_sensor_lo_android));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_wrench", "MaterialSymbols.mobile_wrench()", tagIcons::mobile_wrench_android));
    icons.add(
        new IconCatalogEntry<>(
            "mobiledata_arrows",
            "MaterialSymbols.mobiledata_arrows()",
            tagIcons::mobiledata_arrows_android));
    icons.add(
        new IconCatalogEntry<>(
            "mobiledata_off",
            "MaterialSymbols.mobiledata_off()",
            tagIcons::mobiledata_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "mode_standby", "MaterialSymbols.mode_standby()", tagIcons::mode_standby_android));
    icons.add(
        new IconCatalogEntry<>("nearby", "MaterialSymbols.nearby()", tagIcons::nearby_android));
    icons.add(
        new IconCatalogEntry<>(
            "nearby_error", "MaterialSymbols.nearby_error()", tagIcons::nearby_error_android));
    icons.add(
        new IconCatalogEntry<>(
            "nearby_off", "MaterialSymbols.nearby_off()", tagIcons::nearby_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_cell", "MaterialSymbols.network_cell()", tagIcons::network_cell_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_check", "MaterialSymbols.network_check()", tagIcons::network_check_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_locked",
            "MaterialSymbols.network_locked()",
            tagIcons::network_locked_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_ping", "MaterialSymbols.network_ping()", tagIcons::network_ping_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi", "MaterialSymbols.network_wifi()", tagIcons::network_wifi_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_1_bar",
            "MaterialSymbols.network_wifi_1_bar()",
            tagIcons::network_wifi_1_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_1_bar_locked",
            "MaterialSymbols.network_wifi_1_bar_locked()",
            tagIcons::network_wifi_1_bar_locked_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_2_bar",
            "MaterialSymbols.network_wifi_2_bar()",
            tagIcons::network_wifi_2_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_2_bar_locked",
            "MaterialSymbols.network_wifi_2_bar_locked()",
            tagIcons::network_wifi_2_bar_locked_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_3_bar",
            "MaterialSymbols.network_wifi_3_bar()",
            tagIcons::network_wifi_3_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_3_bar_locked",
            "MaterialSymbols.network_wifi_3_bar_locked()",
            tagIcons::network_wifi_3_bar_locked_android));
    icons.add(
        new IconCatalogEntry<>(
            "network_wifi_locked",
            "MaterialSymbols.network_wifi_locked()",
            tagIcons::network_wifi_locked_android));
    icons.add(new IconCatalogEntry<>("nfc", "MaterialSymbols.nfc()", tagIcons::nfc_android));
    icons.add(
        new IconCatalogEntry<>("nfc_off", "MaterialSymbols.nfc_off()", tagIcons::nfc_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "nightlight", "MaterialSymbols.nightlight()", tagIcons::nightlight_android));
    icons.add(
        new IconCatalogEntry<>(
            "noise_aware", "MaterialSymbols.noise_aware()", tagIcons::noise_aware_android));
    icons.add(
        new IconCatalogEntry<>(
            "noise_control_off",
            "MaterialSymbols.noise_control_off()",
            tagIcons::noise_control_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "noise_control_on",
            "MaterialSymbols.noise_control_on()",
            tagIcons::noise_control_on_android));
    icons.add(
        new IconCatalogEntry<>(
            "overview_key", "MaterialSymbols.overview_key()", tagIcons::overview_key_android));
    icons.add(
        new IconCatalogEntry<>(
            "password", "MaterialSymbols.password()", tagIcons::password_android));
    icons.add(
        new IconCatalogEntry<>(
            "password_2", "MaterialSymbols.password_2()", tagIcons::password_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "password_2_off",
            "MaterialSymbols.password_2_off()",
            tagIcons::password_2_off_android));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>("pattern", "MaterialSymbols.pattern()", tagIcons::pattern_android));
    icons.add(
        new IconCatalogEntry<>(
            "perm_data_setting",
            "MaterialSymbols.perm_data_setting()",
            tagIcons::perm_data_setting_android));
    icons.add(
        new IconCatalogEntry<>(
            "perm_scan_wifi",
            "MaterialSymbols.perm_scan_wifi()",
            tagIcons::perm_scan_wifi_android));
    icons.add(new IconCatalogEntry<>("pin", "MaterialSymbols.pin()", tagIcons::pin_android));
    icons.add(
        new IconCatalogEntry<>(
            "portable_wifi_off",
            "MaterialSymbols.portable_wifi_off()",
            tagIcons::portable_wifi_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "quick_phrases", "MaterialSymbols.quick_phrases()", tagIcons::quick_phrases_android));
    icons.add(
        new IconCatalogEntry<>(
            "r_mobiledata", "MaterialSymbols.r_mobiledata()", tagIcons::r_mobiledata_android));
    icons.add(new IconCatalogEntry<>("radar", "MaterialSymbols.radar()", tagIcons::radar_android));
    icons.add(
        new IconCatalogEntry<>(
            "rss_feed", "MaterialSymbols.rss_feed()", tagIcons::rss_feed_android));
    icons.add(
        new IconCatalogEntry<>(
            "screen_record", "MaterialSymbols.screen_record()", tagIcons::screen_record_android));
    icons.add(
        new IconCatalogEntry<>(
            "screen_rotation_alt",
            "MaterialSymbols.screen_rotation_alt()",
            tagIcons::screen_rotation_alt_android));
    icons.add(
        new IconCatalogEntry<>(
            "screen_rotation_up",
            "MaterialSymbols.screen_rotation_up()",
            tagIcons::screen_rotation_up_android));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_frame",
            "MaterialSymbols.screenshot_frame()",
            tagIcons::screenshot_frame_android));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_frame_2",
            "MaterialSymbols.screenshot_frame_2()",
            tagIcons::screenshot_frame_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_keyboard",
            "MaterialSymbols.screenshot_keyboard()",
            tagIcons::screenshot_keyboard_android));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_region",
            "MaterialSymbols.screenshot_region()",
            tagIcons::screenshot_region_android));
    icons.add(
        new IconCatalogEntry<>(
            "settings_system_daydream",
            "MaterialSymbols.settings_system_daydream()",
            tagIcons::settings_system_daydream_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_0_bar",
            "MaterialSymbols.signal_cellular_0_bar()",
            tagIcons::signal_cellular_0_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_1_bar",
            "MaterialSymbols.signal_cellular_1_bar()",
            tagIcons::signal_cellular_1_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_2_bar",
            "MaterialSymbols.signal_cellular_2_bar()",
            tagIcons::signal_cellular_2_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_3_bar",
            "MaterialSymbols.signal_cellular_3_bar()",
            tagIcons::signal_cellular_3_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_4_bar",
            "MaterialSymbols.signal_cellular_4_bar()",
            tagIcons::signal_cellular_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_alt",
            "MaterialSymbols.signal_cellular_alt()",
            tagIcons::signal_cellular_alt_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_alt_1_bar",
            "MaterialSymbols.signal_cellular_alt_1_bar()",
            tagIcons::signal_cellular_alt_1_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_alt_2_bar",
            "MaterialSymbols.signal_cellular_alt_2_bar()",
            tagIcons::signal_cellular_alt_2_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_alt_off",
            "MaterialSymbols.signal_cellular_alt_off()",
            tagIcons::signal_cellular_alt_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_connected_no_internet_0_bar",
            "MaterialSymbols.signal_cellular_connected_no_internet_0_bar()",
            tagIcons::signal_cellular_connected_no_internet_0_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_connected_no_internet_4_bar",
            "MaterialSymbols.signal_cellular_connected_no_internet_4_bar()",
            tagIcons::signal_cellular_connected_no_internet_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_nodata",
            "MaterialSymbols.signal_cellular_nodata()",
            tagIcons::signal_cellular_nodata_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_null",
            "MaterialSymbols.signal_cellular_null()",
            tagIcons::signal_cellular_null_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_off",
            "MaterialSymbols.signal_cellular_off()",
            tagIcons::signal_cellular_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_cellular_pause",
            "MaterialSymbols.signal_cellular_pause()",
            tagIcons::signal_cellular_pause_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_disconnected",
            "MaterialSymbols.signal_disconnected()",
            tagIcons::signal_disconnected_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_0_bar",
            "MaterialSymbols.signal_wifi_0_bar()",
            tagIcons::signal_wifi_0_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_4_bar",
            "MaterialSymbols.signal_wifi_4_bar()",
            tagIcons::signal_wifi_4_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_bad",
            "MaterialSymbols.signal_wifi_bad()",
            tagIcons::signal_wifi_bad_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_off",
            "MaterialSymbols.signal_wifi_off()",
            tagIcons::signal_wifi_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_statusbar_not_connected",
            "MaterialSymbols.signal_wifi_statusbar_not_connected()",
            tagIcons::signal_wifi_statusbar_not_connected_android));
    icons.add(
        new IconCatalogEntry<>(
            "signal_wifi_statusbar_null",
            "MaterialSymbols.signal_wifi_statusbar_null()",
            tagIcons::signal_wifi_statusbar_null_android));
    icons.add(
        new IconCatalogEntry<>(
            "sim_card_download",
            "MaterialSymbols.sim_card_download()",
            tagIcons::sim_card_download_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen", "MaterialSymbols.splitscreen()", tagIcons::splitscreen_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_add",
            "MaterialSymbols.splitscreen_add()",
            tagIcons::splitscreen_add_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_bottom",
            "MaterialSymbols.splitscreen_bottom()",
            tagIcons::splitscreen_bottom_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_left",
            "MaterialSymbols.splitscreen_left()",
            tagIcons::splitscreen_left_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_right",
            "MaterialSymbols.splitscreen_right()",
            tagIcons::splitscreen_right_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_top",
            "MaterialSymbols.splitscreen_top()",
            tagIcons::splitscreen_top_android));
    icons.add(
        new IconCatalogEntry<>(
            "splitscreen_vertical_add",
            "MaterialSymbols.splitscreen_vertical_add()",
            tagIcons::splitscreen_vertical_add_android));
    icons.add(
        new IconCatalogEntry<>("storage", "MaterialSymbols.storage()", tagIcons::storage_android));
    icons.add(
        new IconCatalogEntry<>("stylus", "MaterialSymbols.stylus()", tagIcons::stylus_android));
    icons.add(
        new IconCatalogEntry<>(
            "stylus_note", "MaterialSymbols.stylus_note()", tagIcons::stylus_note_android));
    icons.add(
        new IconCatalogEntry<>(
            "thermostat", "MaterialSymbols.thermostat()", tagIcons::thermostat_android));
    icons.add(
        new IconCatalogEntry<>(
            "timer_10_select",
            "MaterialSymbols.timer_10_select()",
            tagIcons::timer_10_select_android));
    icons.add(
        new IconCatalogEntry<>(
            "timer_3_select",
            "MaterialSymbols.timer_3_select()",
            tagIcons::timer_3_select_android));
    icons.add(
        new IconCatalogEntry<>("timer_5", "MaterialSymbols.timer_5()", tagIcons::timer_5_android));
    icons.add(
        new IconCatalogEntry<>(
            "timer_5_shutter",
            "MaterialSymbols.timer_5_shutter()",
            tagIcons::timer_5_shutter_android));
    icons.add(new IconCatalogEntry<>("usb", "MaterialSymbols.usb()", tagIcons::usb_android));
    icons.add(
        new IconCatalogEntry<>("usb_off", "MaterialSymbols.usb_off()", tagIcons::usb_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "wallpaper", "MaterialSymbols.wallpaper()", tagIcons::wallpaper_android));
    icons.add(
        new IconCatalogEntry<>(
            "wallpaper_slideshow",
            "MaterialSymbols.wallpaper_slideshow()",
            tagIcons::wallpaper_slideshow_android));
    icons.add(
        new IconCatalogEntry<>("widgets", "MaterialSymbols.widgets()", tagIcons::widgets_android));
    icons.add(new IconCatalogEntry<>("wifi", "MaterialSymbols.wifi()", tagIcons::wifi_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_1_bar", "MaterialSymbols.wifi_1_bar()", tagIcons::wifi_1_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_2_bar", "MaterialSymbols.wifi_2_bar()", tagIcons::wifi_2_bar_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_bar_1",
            "MaterialSymbols.wifi_calling_bar_1()",
            tagIcons::wifi_calling_bar_1_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_bar_2",
            "MaterialSymbols.wifi_calling_bar_2()",
            tagIcons::wifi_calling_bar_2_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_calling_bar_3",
            "MaterialSymbols.wifi_calling_bar_3()",
            tagIcons::wifi_calling_bar_3_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_find", "MaterialSymbols.wifi_find()", tagIcons::wifi_find_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_home", "MaterialSymbols.wifi_home()", tagIcons::wifi_home_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_lock", "MaterialSymbols.wifi_lock()", tagIcons::wifi_lock_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_notification",
            "MaterialSymbols.wifi_notification()",
            tagIcons::wifi_notification_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_off", "MaterialSymbols.wifi_off()", tagIcons::wifi_off_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_tethering",
            "MaterialSymbols.wifi_tethering()",
            tagIcons::wifi_tethering_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_tethering_error",
            "MaterialSymbols.wifi_tethering_error()",
            tagIcons::wifi_tethering_error_android));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_tethering_off",
            "MaterialSymbols.wifi_tethering_off()",
            tagIcons::wifi_tethering_off_android));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
