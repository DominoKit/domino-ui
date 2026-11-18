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
import org.dominokit.domino.ui.icons.TablerDevices;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Devices category. */
public final class TablerDevices_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerDevices tagIcons = new TablerDevices() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
    addIcons3();
    addIcons4();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "access-point", "TablerIcons.access_point()", tagIcons::access_point));
    icons.add(
        new IconCatalogEntry<>(
            "access-point-off",
            "TablerIcons.access_point_off()",
            tagIcons::access_point_off));
    icons.add(
        new IconCatalogEntry<>(
            "air-conditioning",
            "TablerIcons.air_conditioning()",
            tagIcons::air_conditioning));
    icons.add(
        new IconCatalogEntry<>(
            "air-conditioning-disabled",
            "TablerIcons.air_conditioning_disabled()",
            tagIcons::air_conditioning_disabled));
    icons.add(
        new IconCatalogEntry<>(
            "airpods-l", "TablerIcons.airpods_l()", tagIcons::airpods_l));
    icons.add(
        new IconCatalogEntry<>(
            "airpods-r", "TablerIcons.airpods_r()", tagIcons::airpods_r));
    icons.add(
        new IconCatalogEntry<>(
            "alarm-smoke", "TablerIcons.alarm_smoke()", tagIcons::alarm_smoke));
    icons.add(
        new IconCatalogEntry<>("antenna", "TablerIcons.antenna()", tagIcons::antenna));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-1", "TablerIcons.antenna_bars_1()", tagIcons::antenna_bars_1));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-2", "TablerIcons.antenna_bars_2()", tagIcons::antenna_bars_2));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-3", "TablerIcons.antenna_bars_3()", tagIcons::antenna_bars_3));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-4", "TablerIcons.antenna_bars_4()", tagIcons::antenna_bars_4));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-5", "TablerIcons.antenna_bars_5()", tagIcons::antenna_bars_5));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-bars-off",
            "TablerIcons.antenna_bars_off()",
            tagIcons::antenna_bars_off));
    icons.add(
        new IconCatalogEntry<>(
            "antenna-off", "TablerIcons.antenna_off()", tagIcons::antenna_off));
    icons.add(
        new IconCatalogEntry<>("battery", "TablerIcons.battery()", tagIcons::battery));
    icons.add(
        new IconCatalogEntry<>(
            "battery-1", "TablerIcons.battery_1()", tagIcons::battery_1));
    icons.add(
        new IconCatalogEntry<>(
            "battery-2", "TablerIcons.battery_2()", tagIcons::battery_2));
    icons.add(
        new IconCatalogEntry<>(
            "battery-3", "TablerIcons.battery_3()", tagIcons::battery_3));
    icons.add(
        new IconCatalogEntry<>(
            "battery-4", "TablerIcons.battery_4()", tagIcons::battery_4));
    icons.add(
        new IconCatalogEntry<>(
            "battery-charging",
            "TablerIcons.battery_charging()",
            tagIcons::battery_charging));
    icons.add(
        new IconCatalogEntry<>(
            "battery-charging-2",
            "TablerIcons.battery_charging_2()",
            tagIcons::battery_charging_2));
    icons.add(
        new IconCatalogEntry<>(
            "battery-eco", "TablerIcons.battery_eco()", tagIcons::battery_eco));
    icons.add(
        new IconCatalogEntry<>(
            "battery-exclamation",
            "TablerIcons.battery_exclamation()",
            tagIcons::battery_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "battery-off", "TablerIcons.battery_off()", tagIcons::battery_off));
    icons.add(
        new IconCatalogEntry<>(
            "battery-spark", "TablerIcons.battery_spark()", tagIcons::battery_spark));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical",
            "TablerIcons.battery_vertical()",
            tagIcons::battery_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-1",
            "TablerIcons.battery_vertical_1()",
            tagIcons::battery_vertical_1));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-2",
            "TablerIcons.battery_vertical_2()",
            tagIcons::battery_vertical_2));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-3",
            "TablerIcons.battery_vertical_3()",
            tagIcons::battery_vertical_3));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-4",
            "TablerIcons.battery_vertical_4()",
            tagIcons::battery_vertical_4));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-charging",
            "TablerIcons.battery_vertical_charging()",
            tagIcons::battery_vertical_charging));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-charging-2",
            "TablerIcons.battery_vertical_charging_2()",
            tagIcons::battery_vertical_charging_2));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-eco",
            "TablerIcons.battery_vertical_eco()",
            tagIcons::battery_vertical_eco));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-exclamation",
            "TablerIcons.battery_vertical_exclamation()",
            tagIcons::battery_vertical_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-off",
            "TablerIcons.battery_vertical_off()",
            tagIcons::battery_vertical_off));
    icons.add(
        new IconCatalogEntry<>("blender", "TablerIcons.blender()", tagIcons::blender));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth", "TablerIcons.bluetooth()", tagIcons::bluetooth));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth-connected",
            "TablerIcons.bluetooth_connected()",
            tagIcons::bluetooth_connected));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth-off", "TablerIcons.bluetooth_off()", tagIcons::bluetooth_off));
    icons.add(
        new IconCatalogEntry<>(
            "bluetooth-x", "TablerIcons.bluetooth_x()", tagIcons::bluetooth_x));
    icons.add(
        new IconCatalogEntry<>(
            "broadcast", "TablerIcons.broadcast()", tagIcons::broadcast));
    icons.add(
        new IconCatalogEntry<>(
            "broadcast-off", "TablerIcons.broadcast_off()", tagIcons::broadcast_off));
    icons.add(
        new IconCatalogEntry<>("browser", "TablerIcons.browser()", tagIcons::browser));
    icons.add(
        new IconCatalogEntry<>(
            "browser-check", "TablerIcons.browser_check()", tagIcons::browser_check));
    icons.add(
        new IconCatalogEntry<>(
            "browser-maximize",
            "TablerIcons.browser_maximize()",
            tagIcons::browser_maximize));
    icons.add(
        new IconCatalogEntry<>(
            "browser-minus", "TablerIcons.browser_minus()", tagIcons::browser_minus));
    icons.add(
        new IconCatalogEntry<>(
            "browser-off", "TablerIcons.browser_off()", tagIcons::browser_off));
    icons.add(
        new IconCatalogEntry<>(
            "browser-plus", "TablerIcons.browser_plus()", tagIcons::browser_plus));
    icons.add(
        new IconCatalogEntry<>(
            "browser-share", "TablerIcons.browser_share()", tagIcons::browser_share));
    icons.add(
        new IconCatalogEntry<>(
            "browser-x", "TablerIcons.browser_x()", tagIcons::browser_x));
    icons.add(
        new IconCatalogEntry<>(
            "calculator", "TablerIcons.calculator()", tagIcons::calculator));
    icons.add(
        new IconCatalogEntry<>(
            "calculator-off", "TablerIcons.calculator_off()", tagIcons::calculator_off));
    icons.add(
        new IconCatalogEntry<>(
            "cardboards", "TablerIcons.cardboards()", tagIcons::cardboards));
    icons.add(
        new IconCatalogEntry<>(
            "cardboards-off", "TablerIcons.cardboards_off()", tagIcons::cardboards_off));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-1", "TablerIcons.cell_signal_1()", tagIcons::cell_signal_1));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-2", "TablerIcons.cell_signal_2()", tagIcons::cell_signal_2));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-3", "TablerIcons.cell_signal_3()", tagIcons::cell_signal_3));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-4", "TablerIcons.cell_signal_4()", tagIcons::cell_signal_4));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-5", "TablerIcons.cell_signal_5()", tagIcons::cell_signal_5));
    icons.add(
        new IconCatalogEntry<>(
            "cell-signal-off",
            "TablerIcons.cell_signal_off()",
            tagIcons::cell_signal_off));
    icons.add(new IconCatalogEntry<>("cpu", "TablerIcons.cpu()", tagIcons::cpu));
    icons.add(new IconCatalogEntry<>("cpu-2", "TablerIcons.cpu_2()", tagIcons::cpu_2));
    icons.add(
        new IconCatalogEntry<>("cpu-off", "TablerIcons.cpu_off()", tagIcons::cpu_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-3d-camera",
            "TablerIcons.device_3d_camera()",
            tagIcons::device_3d_camera));
    icons.add(
        new IconCatalogEntry<>(
            "device-3d-lens", "TablerIcons.device_3d_lens()", tagIcons::device_3d_lens));
    icons.add(
        new IconCatalogEntry<>(
            "device-airpods", "TablerIcons.device_airpods()", tagIcons::device_airpods));
    icons.add(
        new IconCatalogEntry<>(
            "device-airpods-case",
            "TablerIcons.device_airpods_case()",
            tagIcons::device_airpods_case));
    icons.add(
        new IconCatalogEntry<>(
            "device-airtag", "TablerIcons.device_airtag()", tagIcons::device_airtag));
    icons.add(
        new IconCatalogEntry<>(
            "device-analytics",
            "TablerIcons.device_analytics()",
            tagIcons::device_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "device-audio-tape",
            "TablerIcons.device_audio_tape()",
            tagIcons::device_audio_tape));
    icons.add(
        new IconCatalogEntry<>(
            "device-camera-phone",
            "TablerIcons.device_camera_phone()",
            tagIcons::device_camera_phone));
    icons.add(
        new IconCatalogEntry<>(
            "device-cctv", "TablerIcons.device_cctv()", tagIcons::device_cctv));
    icons.add(
        new IconCatalogEntry<>(
            "device-cctv-off",
            "TablerIcons.device_cctv_off()",
            tagIcons::device_cctv_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-computer-camera",
            "TablerIcons.device_computer_camera()",
            tagIcons::device_computer_camera));
    icons.add(
        new IconCatalogEntry<>(
            "device-computer-camera-2",
            "TablerIcons.device_computer_camera_2()",
            tagIcons::device_computer_camera_2));
    icons.add(
        new IconCatalogEntry<>(
            "device-computer-camera-off",
            "TablerIcons.device_computer_camera_off()",
            tagIcons::device_computer_camera_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop", "TablerIcons.device_desktop()", tagIcons::device_desktop));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-analytics",
            "TablerIcons.device_desktop_analytics()",
            tagIcons::device_desktop_analytics));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-bolt",
            "TablerIcons.device_desktop_bolt()",
            tagIcons::device_desktop_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-cancel",
            "TablerIcons.device_desktop_cancel()",
            tagIcons::device_desktop_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-check",
            "TablerIcons.device_desktop_check()",
            tagIcons::device_desktop_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-code",
            "TablerIcons.device_desktop_code()",
            tagIcons::device_desktop_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-cog",
            "TablerIcons.device_desktop_cog()",
            tagIcons::device_desktop_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-dollar",
            "TablerIcons.device_desktop_dollar()",
            tagIcons::device_desktop_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-down",
            "TablerIcons.device_desktop_down()",
            tagIcons::device_desktop_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-exclamation",
            "TablerIcons.device_desktop_exclamation()",
            tagIcons::device_desktop_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-heart",
            "TablerIcons.device_desktop_heart()",
            tagIcons::device_desktop_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-minus",
            "TablerIcons.device_desktop_minus()",
            tagIcons::device_desktop_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-off",
            "TablerIcons.device_desktop_off()",
            tagIcons::device_desktop_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-pause",
            "TablerIcons.device_desktop_pause()",
            tagIcons::device_desktop_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-pin",
            "TablerIcons.device_desktop_pin()",
            tagIcons::device_desktop_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-plus",
            "TablerIcons.device_desktop_plus()",
            tagIcons::device_desktop_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-question",
            "TablerIcons.device_desktop_question()",
            tagIcons::device_desktop_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-search",
            "TablerIcons.device_desktop_search()",
            tagIcons::device_desktop_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-share",
            "TablerIcons.device_desktop_share()",
            tagIcons::device_desktop_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-star",
            "TablerIcons.device_desktop_star()",
            tagIcons::device_desktop_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-up",
            "TablerIcons.device_desktop_up()",
            tagIcons::device_desktop_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop-x",
            "TablerIcons.device_desktop_x()",
            tagIcons::device_desktop_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-floppy", "TablerIcons.device_floppy()", tagIcons::device_floppy));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad", "TablerIcons.device_gamepad()", tagIcons::device_gamepad));
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad-2",
            "TablerIcons.device_gamepad_2()",
            tagIcons::device_gamepad_2));
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad-3",
            "TablerIcons.device_gamepad_3()",
            tagIcons::device_gamepad_3));
    icons.add(
        new IconCatalogEntry<>(
            "device-heart-monitor",
            "TablerIcons.device_heart_monitor()",
            tagIcons::device_heart_monitor));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac", "TablerIcons.device_imac()", tagIcons::device_imac));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-bolt",
            "TablerIcons.device_imac_bolt()",
            tagIcons::device_imac_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-cancel",
            "TablerIcons.device_imac_cancel()",
            tagIcons::device_imac_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-check",
            "TablerIcons.device_imac_check()",
            tagIcons::device_imac_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-code",
            "TablerIcons.device_imac_code()",
            tagIcons::device_imac_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-cog",
            "TablerIcons.device_imac_cog()",
            tagIcons::device_imac_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-dollar",
            "TablerIcons.device_imac_dollar()",
            tagIcons::device_imac_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-down",
            "TablerIcons.device_imac_down()",
            tagIcons::device_imac_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-exclamation",
            "TablerIcons.device_imac_exclamation()",
            tagIcons::device_imac_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-heart",
            "TablerIcons.device_imac_heart()",
            tagIcons::device_imac_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-minus",
            "TablerIcons.device_imac_minus()",
            tagIcons::device_imac_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-off",
            "TablerIcons.device_imac_off()",
            tagIcons::device_imac_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-pause",
            "TablerIcons.device_imac_pause()",
            tagIcons::device_imac_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-pin",
            "TablerIcons.device_imac_pin()",
            tagIcons::device_imac_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-plus",
            "TablerIcons.device_imac_plus()",
            tagIcons::device_imac_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-question",
            "TablerIcons.device_imac_question()",
            tagIcons::device_imac_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-search",
            "TablerIcons.device_imac_search()",
            tagIcons::device_imac_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-share",
            "TablerIcons.device_imac_share()",
            tagIcons::device_imac_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-star",
            "TablerIcons.device_imac_star()",
            tagIcons::device_imac_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-up", "TablerIcons.device_imac_up()", tagIcons::device_imac_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac-x", "TablerIcons.device_imac_x()", tagIcons::device_imac_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad", "TablerIcons.device_ipad()", tagIcons::device_ipad));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-bolt",
            "TablerIcons.device_ipad_bolt()",
            tagIcons::device_ipad_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-cancel",
            "TablerIcons.device_ipad_cancel()",
            tagIcons::device_ipad_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-check",
            "TablerIcons.device_ipad_check()",
            tagIcons::device_ipad_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-code",
            "TablerIcons.device_ipad_code()",
            tagIcons::device_ipad_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-cog",
            "TablerIcons.device_ipad_cog()",
            tagIcons::device_ipad_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-dollar",
            "TablerIcons.device_ipad_dollar()",
            tagIcons::device_ipad_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-down",
            "TablerIcons.device_ipad_down()",
            tagIcons::device_ipad_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-exclamation",
            "TablerIcons.device_ipad_exclamation()",
            tagIcons::device_ipad_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-heart",
            "TablerIcons.device_ipad_heart()",
            tagIcons::device_ipad_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal",
            "TablerIcons.device_ipad_horizontal()",
            tagIcons::device_ipad_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-bolt",
            "TablerIcons.device_ipad_horizontal_bolt()",
            tagIcons::device_ipad_horizontal_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-cancel",
            "TablerIcons.device_ipad_horizontal_cancel()",
            tagIcons::device_ipad_horizontal_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-check",
            "TablerIcons.device_ipad_horizontal_check()",
            tagIcons::device_ipad_horizontal_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-code",
            "TablerIcons.device_ipad_horizontal_code()",
            tagIcons::device_ipad_horizontal_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-cog",
            "TablerIcons.device_ipad_horizontal_cog()",
            tagIcons::device_ipad_horizontal_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-dollar",
            "TablerIcons.device_ipad_horizontal_dollar()",
            tagIcons::device_ipad_horizontal_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-down",
            "TablerIcons.device_ipad_horizontal_down()",
            tagIcons::device_ipad_horizontal_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-exclamation",
            "TablerIcons.device_ipad_horizontal_exclamation()",
            tagIcons::device_ipad_horizontal_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-heart",
            "TablerIcons.device_ipad_horizontal_heart()",
            tagIcons::device_ipad_horizontal_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-minus",
            "TablerIcons.device_ipad_horizontal_minus()",
            tagIcons::device_ipad_horizontal_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-off",
            "TablerIcons.device_ipad_horizontal_off()",
            tagIcons::device_ipad_horizontal_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-pause",
            "TablerIcons.device_ipad_horizontal_pause()",
            tagIcons::device_ipad_horizontal_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-pin",
            "TablerIcons.device_ipad_horizontal_pin()",
            tagIcons::device_ipad_horizontal_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-plus",
            "TablerIcons.device_ipad_horizontal_plus()",
            tagIcons::device_ipad_horizontal_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-question",
            "TablerIcons.device_ipad_horizontal_question()",
            tagIcons::device_ipad_horizontal_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-search",
            "TablerIcons.device_ipad_horizontal_search()",
            tagIcons::device_ipad_horizontal_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-share",
            "TablerIcons.device_ipad_horizontal_share()",
            tagIcons::device_ipad_horizontal_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-star",
            "TablerIcons.device_ipad_horizontal_star()",
            tagIcons::device_ipad_horizontal_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-up",
            "TablerIcons.device_ipad_horizontal_up()",
            tagIcons::device_ipad_horizontal_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-horizontal-x",
            "TablerIcons.device_ipad_horizontal_x()",
            tagIcons::device_ipad_horizontal_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-minus",
            "TablerIcons.device_ipad_minus()",
            tagIcons::device_ipad_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-off",
            "TablerIcons.device_ipad_off()",
            tagIcons::device_ipad_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-pause",
            "TablerIcons.device_ipad_pause()",
            tagIcons::device_ipad_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-pin",
            "TablerIcons.device_ipad_pin()",
            tagIcons::device_ipad_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-plus",
            "TablerIcons.device_ipad_plus()",
            tagIcons::device_ipad_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-question",
            "TablerIcons.device_ipad_question()",
            tagIcons::device_ipad_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-search",
            "TablerIcons.device_ipad_search()",
            tagIcons::device_ipad_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-share",
            "TablerIcons.device_ipad_share()",
            tagIcons::device_ipad_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-star",
            "TablerIcons.device_ipad_star()",
            tagIcons::device_ipad_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-up", "TablerIcons.device_ipad_up()", tagIcons::device_ipad_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad-x", "TablerIcons.device_ipad_x()", tagIcons::device_ipad_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-landline-phone",
            "TablerIcons.device_landline_phone()",
            tagIcons::device_landline_phone));
    icons.add(
        new IconCatalogEntry<>(
            "device-laptop", "TablerIcons.device_laptop()", tagIcons::device_laptop));
    icons.add(
        new IconCatalogEntry<>(
            "device-laptop-off",
            "TablerIcons.device_laptop_off()",
            tagIcons::device_laptop_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile", "TablerIcons.device_mobile()", tagIcons::device_mobile));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-bolt",
            "TablerIcons.device_mobile_bolt()",
            tagIcons::device_mobile_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-cancel",
            "TablerIcons.device_mobile_cancel()",
            tagIcons::device_mobile_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-charging",
            "TablerIcons.device_mobile_charging()",
            tagIcons::device_mobile_charging));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-check",
            "TablerIcons.device_mobile_check()",
            tagIcons::device_mobile_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-code",
            "TablerIcons.device_mobile_code()",
            tagIcons::device_mobile_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-cog",
            "TablerIcons.device_mobile_cog()",
            tagIcons::device_mobile_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-dollar",
            "TablerIcons.device_mobile_dollar()",
            tagIcons::device_mobile_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-down",
            "TablerIcons.device_mobile_down()",
            tagIcons::device_mobile_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-exclamation",
            "TablerIcons.device_mobile_exclamation()",
            tagIcons::device_mobile_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-heart",
            "TablerIcons.device_mobile_heart()",
            tagIcons::device_mobile_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-message",
            "TablerIcons.device_mobile_message()",
            tagIcons::device_mobile_message));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-minus",
            "TablerIcons.device_mobile_minus()",
            tagIcons::device_mobile_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-off",
            "TablerIcons.device_mobile_off()",
            tagIcons::device_mobile_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-pause",
            "TablerIcons.device_mobile_pause()",
            tagIcons::device_mobile_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-pin",
            "TablerIcons.device_mobile_pin()",
            tagIcons::device_mobile_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-plus",
            "TablerIcons.device_mobile_plus()",
            tagIcons::device_mobile_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-question",
            "TablerIcons.device_mobile_question()",
            tagIcons::device_mobile_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-rotated",
            "TablerIcons.device_mobile_rotated()",
            tagIcons::device_mobile_rotated));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-search",
            "TablerIcons.device_mobile_search()",
            tagIcons::device_mobile_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-share",
            "TablerIcons.device_mobile_share()",
            tagIcons::device_mobile_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-star",
            "TablerIcons.device_mobile_star()",
            tagIcons::device_mobile_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-up",
            "TablerIcons.device_mobile_up()",
            tagIcons::device_mobile_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-vibration",
            "TablerIcons.device_mobile_vibration()",
            tagIcons::device_mobile_vibration));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile-x",
            "TablerIcons.device_mobile_x()",
            tagIcons::device_mobile_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-nintendo",
            "TablerIcons.device_nintendo()",
            tagIcons::device_nintendo));
    icons.add(
        new IconCatalogEntry<>(
            "device-nintendo-off",
            "TablerIcons.device_nintendo_off()",
            tagIcons::device_nintendo_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-remote", "TablerIcons.device_remote()", tagIcons::device_remote));
    icons.add(
        new IconCatalogEntry<>(
            "device-screen", "TablerIcons.device_screen()", tagIcons::device_screen));
    icons.add(
        new IconCatalogEntry<>(
            "device-sd-card", "TablerIcons.device_sd_card()", tagIcons::device_sd_card));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "device-sim", "TablerIcons.device_sim()", tagIcons::device_sim));
    icons.add(
        new IconCatalogEntry<>(
            "device-sim-1", "TablerIcons.device_sim_1()", tagIcons::device_sim_1));
    icons.add(
        new IconCatalogEntry<>(
            "device-sim-2", "TablerIcons.device_sim_2()", tagIcons::device_sim_2));
    icons.add(
        new IconCatalogEntry<>(
            "device-sim-3", "TablerIcons.device_sim_3()", tagIcons::device_sim_3));
    icons.add(
        new IconCatalogEntry<>(
            "device-speaker", "TablerIcons.device_speaker()", tagIcons::device_speaker));
    icons.add(
        new IconCatalogEntry<>(
            "device-speaker-off",
            "TablerIcons.device_speaker_off()",
            tagIcons::device_speaker_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet", "TablerIcons.device_tablet()", tagIcons::device_tablet));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-bolt",
            "TablerIcons.device_tablet_bolt()",
            tagIcons::device_tablet_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-cancel",
            "TablerIcons.device_tablet_cancel()",
            tagIcons::device_tablet_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-check",
            "TablerIcons.device_tablet_check()",
            tagIcons::device_tablet_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-code",
            "TablerIcons.device_tablet_code()",
            tagIcons::device_tablet_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-cog",
            "TablerIcons.device_tablet_cog()",
            tagIcons::device_tablet_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-dollar",
            "TablerIcons.device_tablet_dollar()",
            tagIcons::device_tablet_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-down",
            "TablerIcons.device_tablet_down()",
            tagIcons::device_tablet_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-exclamation",
            "TablerIcons.device_tablet_exclamation()",
            tagIcons::device_tablet_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-heart",
            "TablerIcons.device_tablet_heart()",
            tagIcons::device_tablet_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-minus",
            "TablerIcons.device_tablet_minus()",
            tagIcons::device_tablet_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-off",
            "TablerIcons.device_tablet_off()",
            tagIcons::device_tablet_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-pause",
            "TablerIcons.device_tablet_pause()",
            tagIcons::device_tablet_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-pin",
            "TablerIcons.device_tablet_pin()",
            tagIcons::device_tablet_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-plus",
            "TablerIcons.device_tablet_plus()",
            tagIcons::device_tablet_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-question",
            "TablerIcons.device_tablet_question()",
            tagIcons::device_tablet_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-search",
            "TablerIcons.device_tablet_search()",
            tagIcons::device_tablet_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-share",
            "TablerIcons.device_tablet_share()",
            tagIcons::device_tablet_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-star",
            "TablerIcons.device_tablet_star()",
            tagIcons::device_tablet_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-up",
            "TablerIcons.device_tablet_up()",
            tagIcons::device_tablet_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet-x",
            "TablerIcons.device_tablet_x()",
            tagIcons::device_tablet_x));
    icons.add(
        new IconCatalogEntry<>(
            "device-tv", "TablerIcons.device_tv()", tagIcons::device_tv));
    icons.add(
        new IconCatalogEntry<>(
            "device-tv-off", "TablerIcons.device_tv_off()", tagIcons::device_tv_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-tv-old", "TablerIcons.device_tv_old()", tagIcons::device_tv_old));
    icons.add(
        new IconCatalogEntry<>(
            "device-usb", "TablerIcons.device_usb()", tagIcons::device_usb));
    icons.add(
        new IconCatalogEntry<>(
            "device-vision-pro",
            "TablerIcons.device_vision_pro()",
            tagIcons::device_vision_pro));
    icons.add(
        new IconCatalogEntry<>(
            "device-vision-pro-wifi",
            "TablerIcons.device_vision_pro_wifi()",
            tagIcons::device_vision_pro_wifi));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch", "TablerIcons.device_watch()", tagIcons::device_watch));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-bolt",
            "TablerIcons.device_watch_bolt()",
            tagIcons::device_watch_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-cancel",
            "TablerIcons.device_watch_cancel()",
            tagIcons::device_watch_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-check",
            "TablerIcons.device_watch_check()",
            tagIcons::device_watch_check));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-code",
            "TablerIcons.device_watch_code()",
            tagIcons::device_watch_code));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-cog",
            "TablerIcons.device_watch_cog()",
            tagIcons::device_watch_cog));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-dollar",
            "TablerIcons.device_watch_dollar()",
            tagIcons::device_watch_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-down",
            "TablerIcons.device_watch_down()",
            tagIcons::device_watch_down));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-exclamation",
            "TablerIcons.device_watch_exclamation()",
            tagIcons::device_watch_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-heart",
            "TablerIcons.device_watch_heart()",
            tagIcons::device_watch_heart));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-minus",
            "TablerIcons.device_watch_minus()",
            tagIcons::device_watch_minus));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-off",
            "TablerIcons.device_watch_off()",
            tagIcons::device_watch_off));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-pause",
            "TablerIcons.device_watch_pause()",
            tagIcons::device_watch_pause));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-pin",
            "TablerIcons.device_watch_pin()",
            tagIcons::device_watch_pin));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-plus",
            "TablerIcons.device_watch_plus()",
            tagIcons::device_watch_plus));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-question",
            "TablerIcons.device_watch_question()",
            tagIcons::device_watch_question));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-search",
            "TablerIcons.device_watch_search()",
            tagIcons::device_watch_search));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-share",
            "TablerIcons.device_watch_share()",
            tagIcons::device_watch_share));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-star",
            "TablerIcons.device_watch_star()",
            tagIcons::device_watch_star));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-stats",
            "TablerIcons.device_watch_stats()",
            tagIcons::device_watch_stats));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-stats-2",
            "TablerIcons.device_watch_stats_2()",
            tagIcons::device_watch_stats_2));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-up",
            "TablerIcons.device_watch_up()",
            tagIcons::device_watch_up));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch-x", "TablerIcons.device_watch_x()", tagIcons::device_watch_x));
    icons.add(
        new IconCatalogEntry<>("devices", "TablerIcons.devices()", tagIcons::devices));
    icons.add(
        new IconCatalogEntry<>(
            "devices-2", "TablerIcons.devices_2()", tagIcons::devices_2));
    icons.add(
        new IconCatalogEntry<>(
            "devices-bolt", "TablerIcons.devices_bolt()", tagIcons::devices_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "devices-cancel", "TablerIcons.devices_cancel()", tagIcons::devices_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "devices-check", "TablerIcons.devices_check()", tagIcons::devices_check));
    icons.add(
        new IconCatalogEntry<>(
            "devices-code", "TablerIcons.devices_code()", tagIcons::devices_code));
    icons.add(
        new IconCatalogEntry<>(
            "devices-cog", "TablerIcons.devices_cog()", tagIcons::devices_cog));
    icons.add(
        new IconCatalogEntry<>(
            "devices-dollar", "TablerIcons.devices_dollar()", tagIcons::devices_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "devices-down", "TablerIcons.devices_down()", tagIcons::devices_down));
    icons.add(
        new IconCatalogEntry<>(
            "devices-exclamation",
            "TablerIcons.devices_exclamation()",
            tagIcons::devices_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "devices-heart", "TablerIcons.devices_heart()", tagIcons::devices_heart));
    icons.add(
        new IconCatalogEntry<>(
            "devices-minus", "TablerIcons.devices_minus()", tagIcons::devices_minus));
    icons.add(
        new IconCatalogEntry<>(
            "devices-off", "TablerIcons.devices_off()", tagIcons::devices_off));
    icons.add(
        new IconCatalogEntry<>(
            "devices-pause", "TablerIcons.devices_pause()", tagIcons::devices_pause));
    icons.add(
        new IconCatalogEntry<>(
            "devices-pc", "TablerIcons.devices_pc()", tagIcons::devices_pc));
    icons.add(
        new IconCatalogEntry<>(
            "devices-pc-off", "TablerIcons.devices_pc_off()", tagIcons::devices_pc_off));
    icons.add(
        new IconCatalogEntry<>(
            "devices-pin", "TablerIcons.devices_pin()", tagIcons::devices_pin));
    icons.add(
        new IconCatalogEntry<>(
            "devices-plus", "TablerIcons.devices_plus()", tagIcons::devices_plus));
    icons.add(
        new IconCatalogEntry<>(
            "devices-question",
            "TablerIcons.devices_question()",
            tagIcons::devices_question));
    icons.add(
        new IconCatalogEntry<>(
            "devices-search", "TablerIcons.devices_search()", tagIcons::devices_search));
    icons.add(
        new IconCatalogEntry<>(
            "devices-share", "TablerIcons.devices_share()", tagIcons::devices_share));
    icons.add(
        new IconCatalogEntry<>(
            "devices-star", "TablerIcons.devices_star()", tagIcons::devices_star));
    icons.add(
        new IconCatalogEntry<>(
            "devices-up", "TablerIcons.devices_up()", tagIcons::devices_up));
    icons.add(
        new IconCatalogEntry<>(
            "devices-x", "TablerIcons.devices_x()", tagIcons::devices_x));
    icons.add(
        new IconCatalogEntry<>("dialpad", "TablerIcons.dialpad()", tagIcons::dialpad));
    icons.add(
        new IconCatalogEntry<>(
            "dialpad-off", "TablerIcons.dialpad_off()", tagIcons::dialpad_off));
    icons.add(new IconCatalogEntry<>("disc", "TablerIcons.disc()", tagIcons::disc));
    icons.add(
        new IconCatalogEntry<>("disc-off", "TablerIcons.disc_off()", tagIcons::disc_off));
    icons.add(
        new IconCatalogEntry<>(
            "dual-screen", "TablerIcons.dual_screen()", tagIcons::dual_screen));
    icons.add(
        new IconCatalogEntry<>(
            "earphone-bluetooth",
            "TablerIcons.earphone_bluetooth()",
            tagIcons::earphone_bluetooth));
    icons.add(new IconCatalogEntry<>("fridge", "TablerIcons.fridge()", tagIcons::fridge));
    icons.add(
        new IconCatalogEntry<>(
            "fridge-off", "TablerIcons.fridge_off()", tagIcons::fridge_off));
    icons.add(new IconCatalogEntry<>("gpu", "TablerIcons.gpu()", tagIcons::gpu));
    icons.add(new IconCatalogEntry<>("gpu-2", "TablerIcons.gpu_2()", tagIcons::gpu_2));
    icons.add(
        new IconCatalogEntry<>(
            "hammer-drill", "TablerIcons.hammer_drill()", tagIcons::hammer_drill));
    icons.add(
        new IconCatalogEntry<>("keyboard", "TablerIcons.keyboard()", tagIcons::keyboard));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard-hide", "TablerIcons.keyboard_hide()", tagIcons::keyboard_hide));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard-off", "TablerIcons.keyboard_off()", tagIcons::keyboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard-show", "TablerIcons.keyboard_show()", tagIcons::keyboard_show));
    icons.add(
        new IconCatalogEntry<>(
            "lawn-mower", "TablerIcons.lawn_mower()", tagIcons::lawn_mower));
    icons.add(new IconCatalogEntry<>("memory", "TablerIcons.memory()", tagIcons::memory));
    icons.add(new IconCatalogEntry<>("mouse", "TablerIcons.mouse()", tagIcons::mouse));
    icons.add(
        new IconCatalogEntry<>("mouse-2", "TablerIcons.mouse_2()", tagIcons::mouse_2));
    icons.add(
        new IconCatalogEntry<>(
            "mouse-off", "TablerIcons.mouse_off()", tagIcons::mouse_off));
  }

  private static void addIcons3() {
    icons.add(new IconCatalogEntry<>("nfc", "TablerIcons.nfc()", tagIcons::nfc));
    icons.add(
        new IconCatalogEntry<>("nfc-off", "TablerIcons.nfc_off()", tagIcons::nfc_off));
    icons.add(new IconCatalogEntry<>("phone", "TablerIcons.phone()", tagIcons::phone));
    icons.add(
        new IconCatalogEntry<>(
            "phone-call", "TablerIcons.phone_call()", tagIcons::phone_call));
    icons.add(
        new IconCatalogEntry<>(
            "phone-calling", "TablerIcons.phone_calling()", tagIcons::phone_calling));
    icons.add(
        new IconCatalogEntry<>(
            "phone-check", "TablerIcons.phone_check()", tagIcons::phone_check));
    icons.add(
        new IconCatalogEntry<>(
            "phone-incoming", "TablerIcons.phone_incoming()", tagIcons::phone_incoming));
    icons.add(
        new IconCatalogEntry<>(
            "phone-off", "TablerIcons.phone_off()", tagIcons::phone_off));
    icons.add(
        new IconCatalogEntry<>(
            "phone-outgoing", "TablerIcons.phone_outgoing()", tagIcons::phone_outgoing));
    icons.add(
        new IconCatalogEntry<>(
            "phone-pause", "TablerIcons.phone_pause()", tagIcons::phone_pause));
    icons.add(
        new IconCatalogEntry<>(
            "phone-plus", "TablerIcons.phone_plus()", tagIcons::phone_plus));
    icons.add(
        new IconCatalogEntry<>(
            "phone-spark", "TablerIcons.phone_spark()", tagIcons::phone_spark));
    icons.add(
        new IconCatalogEntry<>("phone-x", "TablerIcons.phone_x()", tagIcons::phone_x));
    icons.add(
        new IconCatalogEntry<>(
            "playstation-circle",
            "TablerIcons.playstation_circle()",
            tagIcons::playstation_circle));
    icons.add(
        new IconCatalogEntry<>(
            "playstation-square",
            "TablerIcons.playstation_square()",
            tagIcons::playstation_square));
    icons.add(
        new IconCatalogEntry<>(
            "playstation-triangle",
            "TablerIcons.playstation_triangle()",
            tagIcons::playstation_triangle));
    icons.add(
        new IconCatalogEntry<>(
            "playstation-x", "TablerIcons.playstation_x()", tagIcons::playstation_x));
    icons.add(new IconCatalogEntry<>("plug", "TablerIcons.plug()", tagIcons::plug));
    icons.add(
        new IconCatalogEntry<>(
            "plug-connected", "TablerIcons.plug_connected()", tagIcons::plug_connected));
    icons.add(
        new IconCatalogEntry<>(
            "plug-connected-x",
            "TablerIcons.plug_connected_x()",
            tagIcons::plug_connected_x));
    icons.add(
        new IconCatalogEntry<>("plug-off", "TablerIcons.plug_off()", tagIcons::plug_off));
    icons.add(new IconCatalogEntry<>("plug-x", "TablerIcons.plug_x()", tagIcons::plug_x));
    icons.add(new IconCatalogEntry<>("power", "TablerIcons.power()", tagIcons::power));
    icons.add(
        new IconCatalogEntry<>("printer", "TablerIcons.printer()", tagIcons::printer));
    icons.add(
        new IconCatalogEntry<>(
            "printer-off", "TablerIcons.printer_off()", tagIcons::printer_off));
    icons.add(new IconCatalogEntry<>("qrcode", "TablerIcons.qrcode()", tagIcons::qrcode));
    icons.add(
        new IconCatalogEntry<>(
            "qrcode-off", "TablerIcons.qrcode_off()", tagIcons::qrcode_off));
    icons.add(
        new IconCatalogEntry<>(
            "remote-control", "TablerIcons.remote_control()", tagIcons::remote_control));
    icons.add(new IconCatalogEntry<>("router", "TablerIcons.router()", tagIcons::router));
    icons.add(
        new IconCatalogEntry<>(
            "router-off", "TablerIcons.router_off()", tagIcons::router_off));
    icons.add(
        new IconCatalogEntry<>(
            "screen-share", "TablerIcons.screen_share()", tagIcons::screen_share));
    icons.add(
        new IconCatalogEntry<>(
            "screen-share-off",
            "TablerIcons.screen_share_off()",
            tagIcons::screen_share_off));
    icons.add(new IconCatalogEntry<>("server", "TablerIcons.server()", tagIcons::server));
    icons.add(
        new IconCatalogEntry<>("server-2", "TablerIcons.server_2()", tagIcons::server_2));
    icons.add(
        new IconCatalogEntry<>(
            "server-bolt", "TablerIcons.server_bolt()", tagIcons::server_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "server-cog", "TablerIcons.server_cog()", tagIcons::server_cog));
    icons.add(
        new IconCatalogEntry<>(
            "server-off", "TablerIcons.server_off()", tagIcons::server_off));
    icons.add(
        new IconCatalogEntry<>(
            "server-spark", "TablerIcons.server_spark()", tagIcons::server_spark));
    icons.add(
        new IconCatalogEntry<>("shredder", "TablerIcons.shredder()", tagIcons::shredder));
    icons.add(
        new IconCatalogEntry<>(
            "signal-2g", "TablerIcons.signal_2g()", tagIcons::signal_2g));
    icons.add(
        new IconCatalogEntry<>(
            "signal-3g", "TablerIcons.signal_3g()", tagIcons::signal_3g));
    icons.add(
        new IconCatalogEntry<>(
            "signal-4g", "TablerIcons.signal_4g()", tagIcons::signal_4g));
    icons.add(
        new IconCatalogEntry<>(
            "signal-4g-plus", "TablerIcons.signal_4g_plus()", tagIcons::signal_4g_plus));
    icons.add(
        new IconCatalogEntry<>(
            "signal-5g", "TablerIcons.signal_5g()", tagIcons::signal_5g));
    icons.add(
        new IconCatalogEntry<>(
            "signal-6g", "TablerIcons.signal_6g()", tagIcons::signal_6g));
    icons.add(
        new IconCatalogEntry<>("signal-e", "TablerIcons.signal_e()", tagIcons::signal_e));
    icons.add(
        new IconCatalogEntry<>("signal-g", "TablerIcons.signal_g()", tagIcons::signal_g));
    icons.add(
        new IconCatalogEntry<>("signal-h", "TablerIcons.signal_h()", tagIcons::signal_h));
    icons.add(
        new IconCatalogEntry<>(
            "signal-h-plus", "TablerIcons.signal_h_plus()", tagIcons::signal_h_plus));
    icons.add(
        new IconCatalogEntry<>(
            "signal-lte", "TablerIcons.signal_lte()", tagIcons::signal_lte));
    icons.add(
        new IconCatalogEntry<>(
            "viewport-narrow",
            "TablerIcons.viewport_narrow()",
            tagIcons::viewport_narrow));
    icons.add(
        new IconCatalogEntry<>(
            "viewport-wide", "TablerIcons.viewport_wide()", tagIcons::viewport_wide));
    icons.add(new IconCatalogEntry<>("vinyl", "TablerIcons.vinyl()", tagIcons::vinyl));
    icons.add(
        new IconCatalogEntry<>(
            "wash-machine", "TablerIcons.wash_machine()", tagIcons::wash_machine));
    icons.add(new IconCatalogEntry<>("wifi", "TablerIcons.wifi()", tagIcons::wifi));
    icons.add(new IconCatalogEntry<>("wifi-0", "TablerIcons.wifi_0()", tagIcons::wifi_0));
    icons.add(new IconCatalogEntry<>("wifi-1", "TablerIcons.wifi_1()", tagIcons::wifi_1));
    icons.add(new IconCatalogEntry<>("wifi-2", "TablerIcons.wifi_2()", tagIcons::wifi_2));
    icons.add(
        new IconCatalogEntry<>("wifi-off", "TablerIcons.wifi_off()", tagIcons::wifi_off));
    icons.add(new IconCatalogEntry<>("xbox-a", "TablerIcons.xbox_a()", tagIcons::xbox_a));
    icons.add(new IconCatalogEntry<>("xbox-b", "TablerIcons.xbox_b()", tagIcons::xbox_b));
    icons.add(new IconCatalogEntry<>("xbox-x", "TablerIcons.xbox_x()", tagIcons::xbox_x));
    icons.add(new IconCatalogEntry<>("xbox-y", "TablerIcons.xbox_y()", tagIcons::xbox_y));
    icons.add(
        new IconCatalogEntry<>(
            "battery", "TablerIcons.battery_filled()", tagIcons::battery_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-1", "TablerIcons.battery_1_filled()", tagIcons::battery_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-2", "TablerIcons.battery_2_filled()", tagIcons::battery_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-3", "TablerIcons.battery_3_filled()", tagIcons::battery_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-4", "TablerIcons.battery_4_filled()", tagIcons::battery_4_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical",
            "TablerIcons.battery_vertical_filled()",
            tagIcons::battery_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-1",
            "TablerIcons.battery_vertical_1_filled()",
            tagIcons::battery_vertical_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-2",
            "TablerIcons.battery_vertical_2_filled()",
            tagIcons::battery_vertical_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-3",
            "TablerIcons.battery_vertical_3_filled()",
            tagIcons::battery_vertical_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-vertical-4",
            "TablerIcons.battery_vertical_4_filled()",
            tagIcons::battery_vertical_4_filled));
    icons.add(
        new IconCatalogEntry<>(
            "blender", "TablerIcons.blender_filled()", tagIcons::blender_filled));
    icons.add(
        new IconCatalogEntry<>(
            "calculator", "TablerIcons.calculator_filled()", tagIcons::calculator_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cardboards", "TablerIcons.cardboards_filled()", tagIcons::cardboards_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-cctv",
            "TablerIcons.device_cctv_filled()",
            tagIcons::device_cctv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-desktop",
            "TablerIcons.device_desktop_filled()",
            tagIcons::device_desktop_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-floppy",
            "TablerIcons.device_floppy_filled()",
            tagIcons::device_floppy_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad",
            "TablerIcons.device_gamepad_filled()",
            tagIcons::device_gamepad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad-2",
            "TablerIcons.device_gamepad_2_filled()",
            tagIcons::device_gamepad_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-gamepad-3",
            "TablerIcons.device_gamepad_3_filled()",
            tagIcons::device_gamepad_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-heart-monitor",
            "TablerIcons.device_heart_monitor_filled()",
            tagIcons::device_heart_monitor_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-imac",
            "TablerIcons.device_imac_filled()",
            tagIcons::device_imac_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-ipad",
            "TablerIcons.device_ipad_filled()",
            tagIcons::device_ipad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-mobile",
            "TablerIcons.device_mobile_filled()",
            tagIcons::device_mobile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-remote",
            "TablerIcons.device_remote_filled()",
            tagIcons::device_remote_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-speaker",
            "TablerIcons.device_speaker_filled()",
            tagIcons::device_speaker_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-tablet",
            "TablerIcons.device_tablet_filled()",
            tagIcons::device_tablet_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-tv", "TablerIcons.device_tv_filled()", tagIcons::device_tv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-tv-old",
            "TablerIcons.device_tv_old_filled()",
            tagIcons::device_tv_old_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-usb", "TablerIcons.device_usb_filled()", tagIcons::device_usb_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-vision-pro",
            "TablerIcons.device_vision_pro_filled()",
            tagIcons::device_vision_pro_filled));
    icons.add(
        new IconCatalogEntry<>(
            "device-watch",
            "TablerIcons.device_watch_filled()",
            tagIcons::device_watch_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dialpad", "TablerIcons.dialpad_filled()", tagIcons::dialpad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "disc", "TablerIcons.disc_filled()", tagIcons::disc_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dual-screen",
            "TablerIcons.dual_screen_filled()",
            tagIcons::dual_screen_filled));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard", "TablerIcons.keyboard_filled()", tagIcons::keyboard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "mouse", "TablerIcons.mouse_filled()", tagIcons::mouse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "phone", "TablerIcons.phone_filled()", tagIcons::phone_filled));
  }

  private static void addIcons4() {
    icons.add(
        new IconCatalogEntry<>(
            "phone-call", "TablerIcons.phone_call_filled()", tagIcons::phone_call_filled));
    icons.add(
        new IconCatalogEntry<>(
            "phone-calling",
            "TablerIcons.phone_calling_filled()",
            tagIcons::phone_calling_filled));
    icons.add(
        new IconCatalogEntry<>(
            "phone-check",
            "TablerIcons.phone_check_filled()",
            tagIcons::phone_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "phone-x", "TablerIcons.phone_x_filled()", tagIcons::phone_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "xbox-a", "TablerIcons.xbox_a_filled()", tagIcons::xbox_a_filled));
    icons.add(
        new IconCatalogEntry<>(
            "xbox-b", "TablerIcons.xbox_b_filled()", tagIcons::xbox_b_filled));
    icons.add(
        new IconCatalogEntry<>(
            "xbox-x", "TablerIcons.xbox_x_filled()", tagIcons::xbox_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "xbox-y", "TablerIcons.xbox_y_filled()", tagIcons::xbox_y_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
