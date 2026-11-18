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
import org.dominokit.domino.ui.icons.MaterialSymbolsHardware;
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Static icon factory for the Material Symbols Hardware category. */
public final class MaterialSymbolsHardware_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsHardware tagIcons = new MaterialSymbolsHardware() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "add_diamond", "MaterialSymbols.add_diamond()", tagIcons::add_diamond_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "adf_scanner", "MaterialSymbols.adf_scanner()", tagIcons::adf_scanner_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "aod_tablet", "MaterialSymbols.aod_tablet()", tagIcons::aod_tablet_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "aod_watch", "MaterialSymbols.aod_watch()", tagIcons::aod_watch_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "arrows_left_right_circle",
            "MaterialSymbols.arrows_left_right_circle()",
            tagIcons::arrows_left_right_circle_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "arrows_up_down_circle",
            "MaterialSymbols.arrows_up_down_circle()",
            tagIcons::arrows_up_down_circle_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "assistant_device",
            "MaterialSymbols.assistant_device()",
            tagIcons::assistant_device_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "audio_video_receiver",
            "MaterialSymbols.audio_video_receiver()",
            tagIcons::audio_video_receiver_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "b_circle", "MaterialSymbols.b_circle()", tagIcons::b_circle_hardware));
    icons.add(
        new IconCatalogEntry<>("balance", "MaterialSymbols.balance()", tagIcons::balance_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "browser_updated",
            "MaterialSymbols.browser_updated()",
            tagIcons::browser_updated_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "camera_video", "MaterialSymbols.camera_video()", tagIcons::camera_video_hardware));
    icons.add(new IconCatalogEntry<>("cast", "MaterialSymbols.cast()", tagIcons::cast_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "cast_connected",
            "MaterialSymbols.cast_connected()",
            tagIcons::cast_connected_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "cast_for_education",
            "MaterialSymbols.cast_for_education()",
            tagIcons::cast_for_education_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "cast_pause", "MaterialSymbols.cast_pause()", tagIcons::cast_pause_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "cast_warning", "MaterialSymbols.cast_warning()", tagIcons::cast_warning_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "chromecast_device",
            "MaterialSymbols.chromecast_device()",
            tagIcons::chromecast_device_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "circle_circle", "MaterialSymbols.circle_circle()", tagIcons::circle_circle_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "computer", "MaterialSymbols.computer()", tagIcons::computer_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "computer_arrow_up",
            "MaterialSymbols.computer_arrow_up()",
            tagIcons::computer_arrow_up_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "computer_cancel",
            "MaterialSymbols.computer_cancel()",
            tagIcons::computer_cancel_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "computer_sound",
            "MaterialSymbols.computer_sound()",
            tagIcons::computer_sound_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "connected_tv", "MaterialSymbols.connected_tv()", tagIcons::connected_tv_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "deskphone", "MaterialSymbols.deskphone()", tagIcons::deskphone_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "desktop_access_disabled",
            "MaterialSymbols.desktop_access_disabled()",
            tagIcons::desktop_access_disabled_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "desktop_cloud", "MaterialSymbols.desktop_cloud()", tagIcons::desktop_cloud_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "desktop_cloud_stack",
            "MaterialSymbols.desktop_cloud_stack()",
            tagIcons::desktop_cloud_stack_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "desktop_mac", "MaterialSymbols.desktop_mac()", tagIcons::desktop_mac_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "desktop_windows",
            "MaterialSymbols.desktop_windows()",
            tagIcons::desktop_windows_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "developer_board",
            "MaterialSymbols.developer_board()",
            tagIcons::developer_board_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "developer_board_off",
            "MaterialSymbols.developer_board_off()",
            tagIcons::developer_board_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "developer_mode_tv",
            "MaterialSymbols.developer_mode_tv()",
            tagIcons::developer_mode_tv_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "device_band", "MaterialSymbols.device_band()", tagIcons::device_band_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "device_hub", "MaterialSymbols.device_hub()", tagIcons::device_hub_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "device_swoosh_star",
            "MaterialSymbols.device_swoosh_star()",
            tagIcons::device_swoosh_star_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "device_thermostat",
            "MaterialSymbols.device_thermostat()",
            tagIcons::device_thermostat_hardware));
    icons.add(
        new IconCatalogEntry<>("devices", "MaterialSymbols.devices()", tagIcons::devices_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "devices_off", "MaterialSymbols.devices_off()", tagIcons::devices_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "devices_other", "MaterialSymbols.devices_other()", tagIcons::devices_other_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "devices_wearables",
            "MaterialSymbols.devices_wearables()",
            tagIcons::devices_wearables_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "disc_full", "MaterialSymbols.disc_full()", tagIcons::disc_full_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "display_add", "MaterialSymbols.display_add()", tagIcons::display_add_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "display_settings",
            "MaterialSymbols.display_settings()",
            tagIcons::display_settings_hardware));
    icons.add(new IconCatalogEntry<>("dns", "MaterialSymbols.dns()", tagIcons::dns_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "earbud_case", "MaterialSymbols.earbud_case()", tagIcons::earbud_case_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "earbud_left", "MaterialSymbols.earbud_left()", tagIcons::earbud_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "earbud_right", "MaterialSymbols.earbud_right()", tagIcons::earbud_right_hardware));
    icons.add(
        new IconCatalogEntry<>("earbuds", "MaterialSymbols.earbuds()", tagIcons::earbuds_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "earbuds_2", "MaterialSymbols.earbuds_2()", tagIcons::earbuds_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "earbuds_battery",
            "MaterialSymbols.earbuds_battery()",
            tagIcons::earbuds_battery_hardware));
    icons.add(new IconCatalogEntry<>("ecg", "MaterialSymbols.ecg()", tagIcons::ecg_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "emoji_language",
            "MaterialSymbols.emoji_language()",
            tagIcons::emoji_language_hardware));
    icons.add(new IconCatalogEntry<>("fax", "MaterialSymbols.fax()", tagIcons::fax_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "fitness_tracker",
            "MaterialSymbols.fitness_tracker()",
            tagIcons::fitness_tracker_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "fitness_trackers",
            "MaterialSymbols.fitness_trackers()",
            tagIcons::fitness_trackers_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_bumper_left",
            "MaterialSymbols.game_bumper_left()",
            tagIcons::game_bumper_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_bumper_right",
            "MaterialSymbols.game_bumper_right()",
            tagIcons::game_bumper_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_l", "MaterialSymbols.game_button_l()", tagIcons::game_button_l_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_l1",
            "MaterialSymbols.game_button_l1()",
            tagIcons::game_button_l1_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_l2",
            "MaterialSymbols.game_button_l2()",
            tagIcons::game_button_l2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_r", "MaterialSymbols.game_button_r()", tagIcons::game_button_r_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_r1",
            "MaterialSymbols.game_button_r1()",
            tagIcons::game_button_r1_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_r2",
            "MaterialSymbols.game_button_r2()",
            tagIcons::game_button_r2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_zl",
            "MaterialSymbols.game_button_zl()",
            tagIcons::game_button_zl_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_button_zr",
            "MaterialSymbols.game_button_zr()",
            tagIcons::game_button_zr_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_stick_l3", "MaterialSymbols.game_stick_l3()", tagIcons::game_stick_l3_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_stick_left",
            "MaterialSymbols.game_stick_left()",
            tagIcons::game_stick_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_stick_r3", "MaterialSymbols.game_stick_r3()", tagIcons::game_stick_r3_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_stick_right",
            "MaterialSymbols.game_stick_right()",
            tagIcons::game_stick_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_trigger_left",
            "MaterialSymbols.game_trigger_left()",
            tagIcons::game_trigger_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "game_trigger_right",
            "MaterialSymbols.game_trigger_right()",
            tagIcons::game_trigger_right_hardware));
    icons.add(
        new IconCatalogEntry<>("gamepad", "MaterialSymbols.gamepad()", tagIcons::gamepad_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_circle_down",
            "MaterialSymbols.gamepad_circle_down()",
            tagIcons::gamepad_circle_down_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_circle_left",
            "MaterialSymbols.gamepad_circle_left()",
            tagIcons::gamepad_circle_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_circle_right",
            "MaterialSymbols.gamepad_circle_right()",
            tagIcons::gamepad_circle_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_circle_up",
            "MaterialSymbols.gamepad_circle_up()",
            tagIcons::gamepad_circle_up_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_down", "MaterialSymbols.gamepad_down()", tagIcons::gamepad_down_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_left", "MaterialSymbols.gamepad_left()", tagIcons::gamepad_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_right", "MaterialSymbols.gamepad_right()", tagIcons::gamepad_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "gamepad_up", "MaterialSymbols.gamepad_up()", tagIcons::gamepad_up_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "general_device",
            "MaterialSymbols.general_device()",
            tagIcons::general_device_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "google_home_devices",
            "MaterialSymbols.google_home_devices()",
            tagIcons::google_home_devices_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "handheld_controller",
            "MaterialSymbols.handheld_controller()",
            tagIcons::handheld_controller_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "hard_disk", "MaterialSymbols.hard_disk()", tagIcons::hard_disk_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "hard_drive", "MaterialSymbols.hard_drive()", tagIcons::hard_drive_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "hard_drive_2", "MaterialSymbols.hard_drive_2()", tagIcons::hard_drive_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "head_mounted_device",
            "MaterialSymbols.head_mounted_device()",
            tagIcons::head_mounted_device_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "headphones", "MaterialSymbols.headphones()", tagIcons::headphones_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "headphones_battery",
            "MaterialSymbols.headphones_battery()",
            tagIcons::headphones_battery_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "headset_mic", "MaterialSymbols.headset_mic()", tagIcons::headset_mic_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "headset_off", "MaterialSymbols.headset_off()", tagIcons::headset_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "home_max", "MaterialSymbols.home_max()", tagIcons::home_max_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "home_mini", "MaterialSymbols.home_mini()", tagIcons::home_mini_hardware));
    icons.add(new IconCatalogEntry<>("host", "MaterialSymbols.host()", tagIcons::host_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "important_devices",
            "MaterialSymbols.important_devices()",
            tagIcons::important_devices_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "jamboard_kiosk",
            "MaterialSymbols.jamboard_kiosk()",
            tagIcons::jamboard_kiosk_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "joystick", "MaterialSymbols.joystick()", tagIcons::joystick_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard", "MaterialSymbols.keyboard()", tagIcons::keyboard_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_alt", "MaterialSymbols.keyboard_alt()", tagIcons::keyboard_alt_hardware));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_arrow_down",
            "MaterialSymbols.keyboard_arrow_down()",
            tagIcons::keyboard_arrow_down_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_arrow_left",
            "MaterialSymbols.keyboard_arrow_left()",
            tagIcons::keyboard_arrow_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_arrow_right",
            "MaterialSymbols.keyboard_arrow_right()",
            tagIcons::keyboard_arrow_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_arrow_up",
            "MaterialSymbols.keyboard_arrow_up()",
            tagIcons::keyboard_arrow_up_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_backspace",
            "MaterialSymbols.keyboard_backspace()",
            tagIcons::keyboard_backspace_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_capslock",
            "MaterialSymbols.keyboard_capslock()",
            tagIcons::keyboard_capslock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_hide", "MaterialSymbols.keyboard_hide()", tagIcons::keyboard_hide_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_lock", "MaterialSymbols.keyboard_lock()", tagIcons::keyboard_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_lock_off",
            "MaterialSymbols.keyboard_lock_off()",
            tagIcons::keyboard_lock_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_return",
            "MaterialSymbols.keyboard_return()",
            tagIcons::keyboard_return_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_tab", "MaterialSymbols.keyboard_tab()", tagIcons::keyboard_tab_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard_tab_rtl",
            "MaterialSymbols.keyboard_tab_rtl()",
            tagIcons::keyboard_tab_rtl_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "laptop_car", "MaterialSymbols.laptop_car()", tagIcons::laptop_car_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "laptop_chromebook",
            "MaterialSymbols.laptop_chromebook()",
            tagIcons::laptop_chromebook_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "laptop_mac", "MaterialSymbols.laptop_mac()", tagIcons::laptop_mac_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "laptop_windows",
            "MaterialSymbols.laptop_windows()",
            tagIcons::laptop_windows_hardware));
    icons.add(new IconCatalogEntry<>("lda", "MaterialSymbols.lda()", tagIcons::lda_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "lift_to_talk", "MaterialSymbols.lift_to_talk()", tagIcons::lift_to_talk_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "lightning_stand",
            "MaterialSymbols.lightning_stand()",
            tagIcons::lightning_stand_hardware));
    icons.add(
        new IconCatalogEntry<>("live_tv", "MaterialSymbols.live_tv()", tagIcons::live_tv_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "media_output", "MaterialSymbols.media_output()", tagIcons::media_output_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "media_output_off",
            "MaterialSymbols.media_output_off()",
            tagIcons::media_output_off_hardware));
    icons.add(
        new IconCatalogEntry<>("memory", "MaterialSymbols.memory()", tagIcons::memory_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "memory_alt", "MaterialSymbols.memory_alt()", tagIcons::memory_alt_hardware));
    icons.add(new IconCatalogEntry<>("merge", "MaterialSymbols.merge()", tagIcons::merge_hardware));
    icons.add(new IconCatalogEntry<>("mimo", "MaterialSymbols.mimo()", tagIcons::mimo_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mimo_disconnect",
            "MaterialSymbols.mimo_disconnect()",
            tagIcons::mimo_disconnect_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "missing_controller",
            "MaterialSymbols.missing_controller()",
            tagIcons::missing_controller_hardware));
    icons.add(
        new IconCatalogEntry<>("mobile", "MaterialSymbols.mobile()", tagIcons::mobile_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_2", "MaterialSymbols.mobile_2()", tagIcons::mobile_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_3", "MaterialSymbols.mobile_3()", tagIcons::mobile_3_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_alert", "MaterialSymbols.mobile_alert()", tagIcons::mobile_alert_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_arrow_down",
            "MaterialSymbols.mobile_arrow_down()",
            tagIcons::mobile_arrow_down_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_arrow_right",
            "MaterialSymbols.mobile_arrow_right()",
            tagIcons::mobile_arrow_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_arrow_up_right",
            "MaterialSymbols.mobile_arrow_up_right()",
            tagIcons::mobile_arrow_up_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_block", "MaterialSymbols.mobile_block()", tagIcons::mobile_block_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_camera", "MaterialSymbols.mobile_camera()", tagIcons::mobile_camera_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_cast", "MaterialSymbols.mobile_cast()", tagIcons::mobile_cast_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_charge", "MaterialSymbols.mobile_charge()", tagIcons::mobile_charge_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_chat", "MaterialSymbols.mobile_chat()", tagIcons::mobile_chat_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_check", "MaterialSymbols.mobile_check()", tagIcons::mobile_check_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_code", "MaterialSymbols.mobile_code()", tagIcons::mobile_code_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_dock", "MaterialSymbols.mobile_dock()", tagIcons::mobile_dock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_dots", "MaterialSymbols.mobile_dots()", tagIcons::mobile_dots_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_gear", "MaterialSymbols.mobile_gear()", tagIcons::mobile_gear_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_hand", "MaterialSymbols.mobile_hand()", tagIcons::mobile_hand_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_hand_left",
            "MaterialSymbols.mobile_hand_left()",
            tagIcons::mobile_hand_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_hand_left_off",
            "MaterialSymbols.mobile_hand_left_off()",
            tagIcons::mobile_hand_left_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_hand_off",
            "MaterialSymbols.mobile_hand_off()",
            tagIcons::mobile_hand_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_info", "MaterialSymbols.mobile_info()", tagIcons::mobile_info_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_landscape",
            "MaterialSymbols.mobile_landscape()",
            tagIcons::mobile_landscape_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_layout", "MaterialSymbols.mobile_layout()", tagIcons::mobile_layout_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_lock_landscape",
            "MaterialSymbols.mobile_lock_landscape()",
            tagIcons::mobile_lock_landscape_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_lock_portrait",
            "MaterialSymbols.mobile_lock_portrait()",
            tagIcons::mobile_lock_portrait_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_loupe", "MaterialSymbols.mobile_loupe()", tagIcons::mobile_loupe_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_menu", "MaterialSymbols.mobile_menu()", tagIcons::mobile_menu_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_off", "MaterialSymbols.mobile_off()", tagIcons::mobile_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_question",
            "MaterialSymbols.mobile_question()",
            tagIcons::mobile_question_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_rotate", "MaterialSymbols.mobile_rotate()", tagIcons::mobile_rotate_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_rotate_lock",
            "MaterialSymbols.mobile_rotate_lock()",
            tagIcons::mobile_rotate_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_screensaver",
            "MaterialSymbols.mobile_screensaver()",
            tagIcons::mobile_screensaver_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_share", "MaterialSymbols.mobile_share()", tagIcons::mobile_share_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_share_stack",
            "MaterialSymbols.mobile_share_stack()",
            tagIcons::mobile_share_stack_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_sound_2",
            "MaterialSymbols.mobile_sound_2()",
            tagIcons::mobile_sound_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_speaker",
            "MaterialSymbols.mobile_speaker()",
            tagIcons::mobile_speaker_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_text", "MaterialSymbols.mobile_text()", tagIcons::mobile_text_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_text_2", "MaterialSymbols.mobile_text_2()", tagIcons::mobile_text_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_ticket", "MaterialSymbols.mobile_ticket()", tagIcons::mobile_ticket_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_unlock", "MaterialSymbols.mobile_unlock()", tagIcons::mobile_unlock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_vibrate",
            "MaterialSymbols.mobile_vibrate()",
            tagIcons::mobile_vibrate_hardware));
    icons.add(
        new IconCatalogEntry<>("monitor", "MaterialSymbols.monitor()", tagIcons::monitor_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "monitor_weight",
            "MaterialSymbols.monitor_weight()",
            tagIcons::monitor_weight_hardware));
    icons.add(new IconCatalogEntry<>("mouse", "MaterialSymbols.mouse()", tagIcons::mouse_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mouse_lock", "MaterialSymbols.mouse_lock()", tagIcons::mouse_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "mouse_lock_off",
            "MaterialSymbols.mouse_lock_off()",
            tagIcons::mouse_lock_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "night_sight_max",
            "MaterialSymbols.night_sight_max()",
            tagIcons::night_sight_max_hardware));
    icons.add(
        new IconCatalogEntry<>("no_sim", "MaterialSymbols.no_sim()", tagIcons::no_sim_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "open_jam", "MaterialSymbols.open_jam()", tagIcons::open_jam_hardware));
    icons.add(new IconCatalogEntry<>("p2p", "MaterialSymbols.p2p()", tagIcons::p2p_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "pacemaker", "MaterialSymbols.pacemaker()", tagIcons::pacemaker_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "plug_connect", "MaterialSymbols.plug_connect()", tagIcons::plug_connect_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "point_of_sale", "MaterialSymbols.point_of_sale()", tagIcons::point_of_sale_hardware));
    icons.add(new IconCatalogEntry<>("power", "MaterialSymbols.power()", tagIcons::power_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "power_input", "MaterialSymbols.power_input()", tagIcons::power_input_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "power_off", "MaterialSymbols.power_off()", tagIcons::power_off_hardware));
    icons.add(new IconCatalogEntry<>("print", "MaterialSymbols.print()", tagIcons::print_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "print_add", "MaterialSymbols.print_add()", tagIcons::print_add_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "print_connect", "MaterialSymbols.print_connect()", tagIcons::print_connect_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "print_disabled",
            "MaterialSymbols.print_disabled()",
            tagIcons::print_disabled_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "print_error", "MaterialSymbols.print_error()", tagIcons::print_error_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "print_lock", "MaterialSymbols.print_lock()", tagIcons::print_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "punch_clock", "MaterialSymbols.punch_clock()", tagIcons::punch_clock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "ramp_left", "MaterialSymbols.ramp_left()", tagIcons::ramp_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "ramp_right", "MaterialSymbols.ramp_right()", tagIcons::ramp_right_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "rear_camera", "MaterialSymbols.rear_camera()", tagIcons::rear_camera_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle_add", "MaterialSymbols.rectangle_add()", tagIcons::rectangle_add_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "remember_me", "MaterialSymbols.remember_me()", tagIcons::remember_me_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "reset_tv", "MaterialSymbols.reset_tv()", tagIcons::reset_tv_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "reset_wrench", "MaterialSymbols.reset_wrench()", tagIcons::reset_wrench_hardware));
    icons.add(new IconCatalogEntry<>("robot", "MaterialSymbols.robot()", tagIcons::robot_hardware));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>("robot_2", "MaterialSymbols.robot_2()", tagIcons::robot_2_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "roundabout_left",
            "MaterialSymbols.roundabout_left()",
            tagIcons::roundabout_left_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "roundabout_right",
            "MaterialSymbols.roundabout_right()",
            tagIcons::roundabout_right_hardware));
    icons.add(new IconCatalogEntry<>("route", "MaterialSymbols.route()", tagIcons::route_hardware));
    icons.add(
        new IconCatalogEntry<>("router", "MaterialSymbols.router()", tagIcons::router_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "router_off", "MaterialSymbols.router_off()", tagIcons::router_off_hardware));
    icons.add(new IconCatalogEntry<>("save", "MaterialSymbols.save()", tagIcons::save_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "save_clock", "MaterialSymbols.save_clock()", tagIcons::save_clock_hardware));
    icons.add(new IconCatalogEntry<>("scale", "MaterialSymbols.scale()", tagIcons::scale_hardware));
    icons.add(
        new IconCatalogEntry<>("scanner", "MaterialSymbols.scanner()", tagIcons::scanner_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "screen_search_desktop",
            "MaterialSymbols.screen_search_desktop()",
            tagIcons::screen_search_desktop_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "screen_share", "MaterialSymbols.screen_share()", tagIcons::screen_share_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_monitor",
            "MaterialSymbols.screenshot_monitor()",
            tagIcons::screenshot_monitor_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot_tablet",
            "MaterialSymbols.screenshot_tablet()",
            tagIcons::screenshot_tablet_hardware));
    icons.add(
        new IconCatalogEntry<>("sd_card", "MaterialSymbols.sd_card()", tagIcons::sd_card_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "sd_card_alert", "MaterialSymbols.sd_card_alert()", tagIcons::sd_card_alert_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "security_key", "MaterialSymbols.security_key()", tagIcons::security_key_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "server_person", "MaterialSymbols.server_person()", tagIcons::server_person_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_ethernet",
            "MaterialSymbols.settings_ethernet()",
            tagIcons::settings_ethernet_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_input_antenna",
            "MaterialSymbols.settings_input_antenna()",
            tagIcons::settings_input_antenna_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_input_component",
            "MaterialSymbols.settings_input_component()",
            tagIcons::settings_input_component_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_input_hdmi",
            "MaterialSymbols.settings_input_hdmi()",
            tagIcons::settings_input_hdmi_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_input_svideo",
            "MaterialSymbols.settings_input_svideo()",
            tagIcons::settings_input_svideo_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settings_remote",
            "MaterialSymbols.settings_remote()",
            tagIcons::settings_remote_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "settop_component",
            "MaterialSymbols.settop_component()",
            tagIcons::settop_component_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "sim_card", "MaterialSymbols.sim_card()", tagIcons::sim_card_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "sim_card_lock", "MaterialSymbols.sim_card_lock()", tagIcons::sim_card_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "smart_card_reader",
            "MaterialSymbols.smart_card_reader()",
            tagIcons::smart_card_reader_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "smart_card_reader_off",
            "MaterialSymbols.smart_card_reader_off()",
            tagIcons::smart_card_reader_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "smart_display", "MaterialSymbols.smart_display()", tagIcons::smart_display_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "smart_toy", "MaterialSymbols.smart_toy()", tagIcons::smart_toy_hardware));
    icons.add(
        new IconCatalogEntry<>("speaker", "MaterialSymbols.speaker()", tagIcons::speaker_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_3", "MaterialSymbols.speaker_3()", tagIcons::speaker_3_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_group", "MaterialSymbols.speaker_group()", tagIcons::speaker_group_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "square_circle", "MaterialSymbols.square_circle()", tagIcons::square_circle_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "stop_screen_share",
            "MaterialSymbols.stop_screen_share()",
            tagIcons::stop_screen_share_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "straight", "MaterialSymbols.straight()", tagIcons::straight_hardware));
    icons.add(
        new IconCatalogEntry<>("tablet", "MaterialSymbols.tablet()", tagIcons::tablet_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tablet_android",
            "MaterialSymbols.tablet_android()",
            tagIcons::tablet_android_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tablet_camera", "MaterialSymbols.tablet_camera()", tagIcons::tablet_camera_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tablet_mac", "MaterialSymbols.tablet_mac()", tagIcons::tablet_mac_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "touchpad_mouse",
            "MaterialSymbols.touchpad_mouse()",
            tagIcons::touchpad_mouse_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "touchpad_mouse_off",
            "MaterialSymbols.touchpad_mouse_off()",
            tagIcons::touchpad_mouse_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "triangle_circle",
            "MaterialSymbols.triangle_circle()",
            tagIcons::triangle_circle_hardware));
    icons.add(new IconCatalogEntry<>("tty", "MaterialSymbols.tty()", tagIcons::tty_hardware));
    icons.add(new IconCatalogEntry<>("tv", "MaterialSymbols.tv()", tagIcons::tv_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_displays", "MaterialSymbols.tv_displays()", tagIcons::tv_displays_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_guide", "MaterialSymbols.tv_guide()", tagIcons::tv_guide_hardware));
    icons.add(
        new IconCatalogEntry<>("tv_next", "MaterialSymbols.tv_next()", tagIcons::tv_next_hardware));
    icons.add(
        new IconCatalogEntry<>("tv_off", "MaterialSymbols.tv_off()", tagIcons::tv_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_options_edit_channels",
            "MaterialSymbols.tv_options_edit_channels()",
            tagIcons::tv_options_edit_channels_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_options_input_settings",
            "MaterialSymbols.tv_options_input_settings()",
            tagIcons::tv_options_input_settings_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_remote", "MaterialSymbols.tv_remote()", tagIcons::tv_remote_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "tv_signin", "MaterialSymbols.tv_signin()", tagIcons::tv_signin_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "ventilator", "MaterialSymbols.ventilator()", tagIcons::ventilator_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "videogame_asset",
            "MaterialSymbols.videogame_asset()",
            tagIcons::videogame_asset_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "videogame_asset_off",
            "MaterialSymbols.videogame_asset_off()",
            tagIcons::videogame_asset_off_hardware));
    icons.add(new IconCatalogEntry<>("watch", "MaterialSymbols.watch()", tagIcons::watch_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_alert", "MaterialSymbols.watch_alert()", tagIcons::watch_alert_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_arrow", "MaterialSymbols.watch_arrow()", tagIcons::watch_arrow_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_arrow_down",
            "MaterialSymbols.watch_arrow_down()",
            tagIcons::watch_arrow_down_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_button", "MaterialSymbols.watch_button()", tagIcons::watch_button_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_button_press",
            "MaterialSymbols.watch_button_press()",
            tagIcons::watch_button_press_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_check", "MaterialSymbols.watch_check()", tagIcons::watch_check_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_lock", "MaterialSymbols.watch_lock()", tagIcons::watch_lock_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_off", "MaterialSymbols.watch_off()", tagIcons::watch_off_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_vibration",
            "MaterialSymbols.watch_vibration()",
            tagIcons::watch_vibration_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "watch_wake", "MaterialSymbols.watch_wake()", tagIcons::watch_wake_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_device", "MaterialSymbols.wifi_device()", tagIcons::wifi_device_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "x_circle", "MaterialSymbols.x_circle()", tagIcons::x_circle_hardware));
    icons.add(
        new IconCatalogEntry<>(
            "y_circle", "MaterialSymbols.y_circle()", tagIcons::y_circle_hardware));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
