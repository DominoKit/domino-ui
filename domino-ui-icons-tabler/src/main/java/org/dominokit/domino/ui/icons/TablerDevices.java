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

/** Tabler Devices catalog category. */
public interface TablerDevices {
  enum OutlineIcon implements TablerIconDefinition {
    ACCESS_POINT(
        "access-point",
        "<path d=\"M12 12l0 .01\" />\n  <path d=\"M14.828 9.172a4 4 0 0 1 0 5.656\" />\n  <path d=\"M17.657 6.343a8 8 0 0 1 0 11.314\" />\n  <path d=\"M9.168 14.828a4 4 0 0 1 0 -5.656\" />\n  <path d=\"M6.337 17.657a8 8 0 0 1 0 -11.314\" />"),
    ACCESS_POINT_OFF(
        "access-point-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M14.828 9.172a4 4 0 0 1 1.172 2.828\" />\n  <path d=\"M17.657 6.343a8 8 0 0 1 1.635 8.952\" />\n  <path d=\"M9.168 14.828a4 4 0 0 1 0 -5.656\" />\n  <path d=\"M6.337 17.657a8 8 0 0 1 0 -11.314\" />"),
    AIR_CONDITIONING(
        "air-conditioning",
        "<path d=\"M8 16a3 3 0 0 1 -3 3\" />\n  <path d=\"M16 16a3 3 0 0 0 3 3\" />\n  <path d=\"M12 16v4\" />\n  <path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -4\" />\n  <path d=\"M7 13v-3a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1v3\" />"),
    AIR_CONDITIONING_DISABLED(
        "air-conditioning-disabled",
        "<path d=\"M3 10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -4\" />\n  <path d=\"M7 16v-3a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1v3\" />"),
    AIRPODS_L(
        "airpods-l",
        "<path d=\"M6 4a4 4 0 0 1 4 3.8v10.7a1.5 1.5 0 1 1 -3 0v-6.5h-1a4 4 0 0 1 -4 -3.8v-.2a4 4 0 0 1 4 -4\" />\n  <path d=\"M15 8v8h4\" />"),
    AIRPODS_R(
        "airpods-r",
        "<path d=\"M18 4a4 4 0 0 0 -4 3.8v10.7a1.5 1.5 0 1 0 3 0v-6.5h1a4 4 0 0 0 4 -3.8v-.2a4 4 0 0 0 -4 -4\" />\n  <path d=\"M5 12h2a2 2 0 1 0 0 -4h-2v8m4 0l-3 -4\" />"),
    ALARM_SMOKE(
        "alarm-smoke",
        "<path d=\"M18 8l-.8 3a1.25 1.25 0 0 1 -1.2 1h-8a1.25 1.25 0 0 1 -1.2 -1l-.8 -3\" />\n  <path d=\"M3 5a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M12 16c.643 .288 1.017 .756 1 1.25c.017 .494 -.357 .962 -1 1.25s-1.017 .756 -1 1.25c-.017 .494 .357 .962 1 1.25\" />\n  <path d=\"M7 16c.643 .288 1.017 .756 1 1.25c.017 .494 -.357 .962 -1 1.25s-1.017 .756 -1 1.25c-.017 .494 .357 .962 1 1.25\" />\n  <path d=\"M17 16c.643 .288 1.017 .756 1 1.25c.017 .494 -.357 .962 -1 1.25s-1.017 .756 -1 1.25c-.017 .494 .357 .962 1 1.25\" />"),
    ANTENNA(
        "antenna",
        "<path d=\"M20 4v8\" />\n  <path d=\"M16 4.5v7\" />\n  <path d=\"M12 5v16\" />\n  <path d=\"M8 5.5v5\" />\n  <path d=\"M4 6v4\" />\n  <path d=\"M20 8h-16\" />"),
    ANTENNA_BARS_1(
        "antenna-bars-1",
        "<path d=\"M6 18l0 .01\" />\n  <path d=\"M10 18l0 .01\" />\n  <path d=\"M14 18l0 .01\" />\n  <path d=\"M18 18l0 .01\" />"),
    ANTENNA_BARS_2(
        "antenna-bars-2",
        "<path d=\"M6 18l0 -3\" />\n  <path d=\"M10 18l0 .01\" />\n  <path d=\"M14 18l0 .01\" />\n  <path d=\"M18 18l0 .01\" />"),
    ANTENNA_BARS_3(
        "antenna-bars-3",
        "<path d=\"M6 18l0 -3\" />\n  <path d=\"M10 18l0 -6\" />\n  <path d=\"M14 18l0 .01\" />\n  <path d=\"M18 18l0 .01\" />"),
    ANTENNA_BARS_4(
        "antenna-bars-4",
        "<path d=\"M6 18l0 -3\" />\n  <path d=\"M10 18l0 -6\" />\n  <path d=\"M14 18l0 -9\" />\n  <path d=\"M18 18l0 .01\" />"),
    ANTENNA_BARS_5(
        "antenna-bars-5",
        "<path d=\"M6 18l0 -3\" />\n  <path d=\"M10 18l0 -6\" />\n  <path d=\"M14 18l0 -9\" />\n  <path d=\"M18 18l0 -12\" />"),
    ANTENNA_BARS_OFF(
        "antenna-bars-off",
        "<path d=\"M6 18v-3\" />\n  <path d=\"M10 18v-6\" />\n  <path d=\"M14 18v-4\" />\n  <path d=\"M14 10v-1\" />\n  <path d=\"M18 14v-8\" />\n  <path d=\"M3 3l18 18\" />"),
    ANTENNA_OFF(
        "antenna-off",
        "<path d=\"M20 4v8\" />\n  <path d=\"M16 4.5v7\" />\n  <path d=\"M12 5v3m0 4v9\" />\n  <path d=\"M8 8v2.5\" />\n  <path d=\"M4 6v4\" />\n  <path d=\"M20 8h-8m-4 0h-4\" />\n  <path d=\"M3 3l18 18\" />"),
    BATTERY(
        "battery",
        "<path d=\"M6 7h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2\" />"),
    BATTERY_1(
        "battery-1",
        "<path d=\"M6 7h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 10l0 4\" />"),
    BATTERY_2(
        "battery-2",
        "<path d=\"M6 7h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 10l0 4\" />\n  <path d=\"M10 10l0 4\" />"),
    BATTERY_3(
        "battery-3",
        "<path d=\"M6 7h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 10l0 4\" />\n  <path d=\"M10 10l0 4\" />\n  <path d=\"M13 10l0 4\" />"),
    BATTERY_4(
        "battery-4",
        "<path d=\"M6 7h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 10l0 4\" />\n  <path d=\"M10 10l0 4\" />\n  <path d=\"M13 10l0 4\" />\n  <path d=\"M16 10l0 4\" />"),
    BATTERY_CHARGING(
        "battery-charging",
        "<path d=\"M16 7h1a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-2\" />\n  <path d=\"M8 7h-2a2 2 0 0 0 -2 2v6a2 2 0 0 0 2 2h1\" />\n  <path d=\"M12 8l-2 4h3l-2 4\" />"),
    BATTERY_CHARGING_2(
        "battery-charging-2",
        "<path d=\"M4 9a2 2 0 0 1 2 -2h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-4.5\" />\n  <path d=\"M3 15h6v2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M6 22v-3\" />\n  <path d=\"M4 15v-2.5\" />\n  <path d=\"M8 15v-2.5\" />"),
    BATTERY_ECO(
        "battery-eco",
        "<path d=\"M4 9a2 2 0 0 1 2 -2h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5a2 2 0 0 1 -2 2h-5.5\" />\n  <path d=\"M3 16.143c0 -2.84 2.09 -5.143 4.667 -5.143h2.333v.857c0 2.84 -2.09 5.143 -4.667 5.143h-2.333v-.857\" />\n  <path d=\"M3 20v-3\" />"),
    BATTERY_EXCLAMATION(
        "battery-exclamation",
        "<path d=\"M9 17h8c1.105 0 2 -.895 2 -2v-.5c0 -.276 .224 -.5 .5 -.5s.5 -.224 .5 -.5v-3c0 -.276 -.224 -.5 -.5 -.5s-.5 -.224 -.5 -.5v-.5c0 -1.105 -.895 -2 -2 -2h-11c-1.105 0 -2 .895 -2 2v3\" />\n  <path d=\"M5 16v3\" />\n  <path d=\"M5 22v.01\" />"),
    BATTERY_OFF(
        "battery-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M11 7h6a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v3a.5 .5 0 0 1 -.5 .5a.5 .5 0 0 0 -.5 .5v.5m-2 2h-11a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h1\" />"),
    BATTERY_SPARK(
        "battery-spark",
        "<path d=\"M12 17h-6a2 2 0 0 1 -2 -2v-6a2 2 0 0 1 2 -2h11a2 2 0 0 1 2 2v.5a.5 .5 0 0 0 .5 .5a.5 .5 0 0 1 .5 .5v1\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    BATTERY_VERTICAL(
        "battery-vertical",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />"),
    BATTERY_VERTICAL_1(
        "battery-vertical-1",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 17h4\" />"),
    BATTERY_VERTICAL_2(
        "battery-vertical-2",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 17h4\" />\n  <path d=\"M10 14h4\" />"),
    BATTERY_VERTICAL_3(
        "battery-vertical-3",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 17h4\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M10 11h4\" />"),
    BATTERY_VERTICAL_4(
        "battery-vertical-4",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />\n  <path d=\"M10 17h4\" />\n  <path d=\"M10 14h4\" />\n  <path d=\"M10 11h4\" />\n  <path d=\"M10 8h4\" />"),
    BATTERY_VERTICAL_CHARGING(
        "battery-vertical-charging",
        "<path d=\"M7 18v-11a2 2 0 0 1 2 -2h.5a.5 .5 0 0 0 .5 -.5a.5 .5 0 0 1 .5 -.5h3a.5 .5 0 0 1 .5 .5a.5 .5 0 0 0 .5 .5h.5a2 2 0 0 1 2 2v11a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2\" />\n  <path d=\"M12.667 8l-2.667 4h4l-2.667 4\" />"),
    BATTERY_VERTICAL_CHARGING_2(
        "battery-vertical-charging-2",
        "<path d=\"M7 18v-11c0 -1.105 .895 -2 2 -2h.5c.276 0 .5 -.224 .5 -.5s.224 -.5 .5 -.5h3c.276 0 .5 .224 .5 .5s.224 .5 .5 .5h.5c1.105 0 2 .895 2 2v1m-10 10c0 1.105 .895 2 2 2h1\" />\n  <path d=\"M12 14h6v2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2l0 -2\" />\n  <path d=\"M15 21v-3\" />\n  <path d=\"M13 14v-2.5\" />\n  <path d=\"M17 14v-2.5\" />"),
    BATTERY_VERTICAL_ECO(
        "battery-vertical-eco",
        "<path d=\"M7 18v-11c0 -1.105 .895 -2 2 -2h.5c.276 0 .5 -.224 .5 -.5s.224 -.5 .5 -.5h3c.276 0 .5 .224 .5 .5s.224 .5 .5 .5h.5c1.105 0 2 .895 2 2v1m-8 12c-1.105 0 -2 -.895 -2 -2\" />\n  <path d=\"M13 17.143c0 -2.84 2.09 -5.143 4.667 -5.143h2.333v.857c0 2.84 -2.09 5.143 -4.667 5.143h-2.333l0 -.857\" />\n  <path d=\"M13 21v-3\" />"),
    BATTERY_VERTICAL_EXCLAMATION(
        "battery-vertical-exclamation",
        "<path d=\"M17 12v-5c0 -1.105 -.895 -2 -2 -2h-.5c-.276 0 -.5 -.224 -.5 -.5s-.224 -.5 -.5 -.5h-3c-.276 0 -.5 .224 -.5 .5s-.224 .5 -.5 .5h-.5c-1.105 0 -2 .895 -2 2v11c0 1.105 .895 2 2 2h6\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    BATTERY_VERTICAL_OFF(
        "battery-vertical-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M17 13v-6a2 2 0 0 0 -2 -2h-.5a.5 .5 0 0 1 -.5 -.5a.5 .5 0 0 0 -.5 -.5h-3a.5 .5 0 0 0 -.5 .5a.5 .5 0 0 1 -.5 .5h-.5m-2 2v11a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-1\" />"),
    BLENDER(
        "blender",
        "<path d=\"M9 10h-3a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h10.802a1 1 0 0 1 .984 1.179l-1.786 9.821\" />\n  <path d=\"M8 4l2 11\" />\n  <path d=\"M11 15h4a3 3 0 0 1 3 3v2a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1v-2a3 3 0 0 1 3 -3\" />\n  <path d=\"M12 4v-1h2v1\" />\n  <path d=\"M13 18v.01\" />"),
    BLUETOOTH("bluetooth", "<path d=\"M7 8l10 8l-5 4l0 -16l5 4l-10 8\" />"),
    BLUETOOTH_CONNECTED(
        "bluetooth-connected",
        "<path d=\"M7 8l10 8l-5 4l0 -16l5 4l-10 8\" />\n  <path d=\"M4 12l1 0\" />\n  <path d=\"M18 12l1 0\" />"),
    BLUETOOTH_OFF(
        "bluetooth-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M16.438 16.45l-4.438 3.55v-8m0 -4v-4l5 4l-2.776 2.22m-2.222 1.779l-5 4\" />"),
    BLUETOOTH_X(
        "bluetooth-x",
        "<path d=\"M7 8l10 8l-5 4v-16l1 .802m0 6.396l-6 4.802\" />\n  <path d=\"M16 6l4 4\" />\n  <path d=\"M20 6l-4 4\" />"),
    BROADCAST(
        "broadcast",
        "<path d=\"M18.364 19.364a9 9 0 1 0 -12.728 0\" />\n  <path d=\"M15.536 16.536a5 5 0 1 0 -7.072 0\" />\n  <path d=\"M11 13a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    BROADCAST_OFF(
        "broadcast-off",
        "<path d=\"M18.364 19.364a9 9 0 0 0 -9.721 -14.717m-2.488 1.509a9 9 0 0 0 -.519 13.208\" />\n  <path d=\"M15.536 16.536a5 5 0 0 0 -3.536 -8.536m-3 1a5 5 0 0 0 -.535 7.536\" />\n  <path d=\"M12 12a1 1 0 1 0 1 1\" />\n  <path d=\"M3 3l18 18\" />"),
    BROWSER(
        "browser",
        "<path d=\"M4 8h16\" />\n  <path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M8 4v4\" />"),
    BROWSER_CHECK(
        "browser-check",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M4 8h16\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M9.5 14.5l1.5 1.5l3 -3\" />"),
    BROWSER_MAXIMIZE(
        "browser-maximize",
        "<path d=\"M4 8h8\" />\n  <path d=\"M20 11.5v6.5a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h6.5\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M16 8l5 -5\" />\n  <path d=\"M21 7.5v-4.5h-4.5\" />"),
    BROWSER_MINUS(
        "browser-minus",
        "<path d=\"M4 8h16\" />\n  <path d=\"M12 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v9\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M16 19h6\" />"),
    BROWSER_OFF(
        "browser-off",
        "<path d=\"M8 4h11a1 1 0 0 1 1 1v11m-.288 3.702a1 1 0 0 1 -.712 .298h-14a1 1 0 0 1 -1 -1v-14c0 -.276 .112 -.526 .293 -.707\" />\n  <path d=\"M4 8h4m4 0h8\" />\n  <path d=\"M3 3l18 18\" />"),
    BROWSER_PLUS(
        "browser-plus",
        "<path d=\"M4 8h16\" />\n  <path d=\"M12 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    BROWSER_SHARE(
        "browser-share",
        "<path d=\"M4 8h16\" />\n  <path d=\"M12.5 20h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    BROWSER_X(
        "browser-x",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M4 8h16\" />\n  <path d=\"M8 4v4\" />\n  <path d=\"M10 16l4 -4\" />\n  <path d=\"M14 16l-4 -4\" />"),
    CALCULATOR(
        "calculator",
        "<path d=\"M4 5a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M8 8a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -1\" />\n  <path d=\"M8 14l0 .01\" />\n  <path d=\"M12 14l0 .01\" />\n  <path d=\"M16 14l0 .01\" />\n  <path d=\"M8 17l0 .01\" />\n  <path d=\"M12 17l0 .01\" />\n  <path d=\"M16 17l0 .01\" />"),
    CALCULATOR_OFF(
        "calculator-off",
        "<path d=\"M19.823 19.824a2 2 0 0 1 -1.823 1.176h-12a2 2 0 0 1 -2 -2v-14c0 -.295 .064 -.575 .178 -.827m2.822 -1.173h11a2 2 0 0 1 2 2v11\" />\n  <path d=\"M10 10h-1a1 1 0 0 1 -1 -1v-1m3 -1h4a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1\" />\n  <path d=\"M8 14v.01\" />\n  <path d=\"M12 14v.01\" />\n  <path d=\"M8 17v.01\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M16 17v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    CARDBOARDS(
        "cardboards",
        "<path d=\"M3 8v8.5a2.5 2.5 0 0 0 2.5 2.5h1.06a3 3 0 0 0 2.34 -1.13l1.54 -1.92a2 2 0 0 1 3.12 0l1.54 1.92a3 3 0 0 0 2.34 1.13h1.06a2.5 2.5 0 0 0 2.5 -2.5v-8.5a2 2 0 0 0 -2 -2h-14a2 2 0 0 0 -2 2\" />\n  <path d=\"M7 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M15 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    CARDBOARDS_OFF(
        "cardboards-off",
        "<path d=\"M20.96 16.953c.026 -.147 .04 -.298 .04 -.453v-8.5a2 2 0 0 0 -2 -2h-9m-4 0h-1a2 2 0 0 0 -2 2v8.5a2.5 2.5 0 0 0 2.5 2.5h1.06a3 3 0 0 0 2.34 -1.13l1.54 -1.92a2 2 0 0 1 3.12 0l1.54 1.92a3 3 0 0 0 2.34 1.13h1.06c.155 0 .307 -.014 .454 -.041\" />\n  <path d=\"M7 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16.714 12.7a1 1 0 0 0 -1.417 -1.411l1.417 1.41\" />\n  <path d=\"M3 3l18 18\" />"),
    CELL_SIGNAL_1(
        "cell-signal-1",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l14.537 -14.537a.731 .731 0 0 1 1.249 .517v15.269\" />"),
    CELL_SIGNAL_2(
        "cell-signal-2",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l14.537 -14.537a.731 .731 0 0 1 1.249 .517v15.269\" />\n  <path d=\"M8 20v-5\" />"),
    CELL_SIGNAL_3(
        "cell-signal-3",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l14.537 -14.537a.731 .731 0 0 1 1.249 .517v15.269\" />\n  <path d=\"M12 20v-9\" />"),
    CELL_SIGNAL_4(
        "cell-signal-4",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l14.537 -14.537a.731 .731 0 0 1 1.249 .517v15.269\" />\n  <path d=\"M16 7v13\" />"),
    CELL_SIGNAL_5(
        "cell-signal-5",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l14.537 -14.537a.731 .731 0 0 1 1.249 .517v15.269\" />\n  <path d=\"M16 7v13\" />\n  <path d=\"M12 20v-9\" />\n  <path d=\"M8 20v-5\" />"),
    CELL_SIGNAL_OFF(
        "cell-signal-off",
        "<path d=\"M20 20h-15.269a.731 .731 0 0 1 -.517 -1.249l7.265 -7.264m2 -2l5.272 -5.272a.731 .731 0 0 1 1.249 .517v11.269\" />\n  <path d=\"M3 3l18 18\" />"),
    CPU(
        "cpu",
        "<path d=\"M5 6a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -12\" />\n  <path d=\"M9 9h6v6h-6l0 -6\" />\n  <path d=\"M3 10h2\" />\n  <path d=\"M3 14h2\" />\n  <path d=\"M10 3v2\" />\n  <path d=\"M14 3v2\" />\n  <path d=\"M21 10h-2\" />\n  <path d=\"M21 14h-2\" />\n  <path d=\"M14 21v-2\" />\n  <path d=\"M10 21v-2\" />"),
    CPU_2(
        "cpu-2",
        "<path d=\"M5 6a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -12\" />\n  <path d=\"M8 10v-2h2m6 6v2h-2m-4 0h-2v-2m8 -4v-2h-2\" />\n  <path d=\"M3 10h2\" />\n  <path d=\"M3 14h2\" />\n  <path d=\"M10 3v2\" />\n  <path d=\"M14 3v2\" />\n  <path d=\"M21 10h-2\" />\n  <path d=\"M21 14h-2\" />\n  <path d=\"M14 21v-2\" />\n  <path d=\"M10 21v-2\" />"),
    CPU_OFF(
        "cpu-off",
        "<path d=\"M9 5h9a1 1 0 0 1 1 1v9m-.292 3.706a1 1 0 0 1 -.708 .294h-12a1 1 0 0 1 -1 -1v-12c0 -.272 .108 -.518 .284 -.698\" />\n  <path d=\"M13 9h2v2m0 4h-6v-6\" />\n  <path d=\"M3 10h2\" />\n  <path d=\"M3 14h2\" />\n  <path d=\"M10 3v2\" />\n  <path d=\"M14 3v2\" />\n  <path d=\"M21 10h-2\" />\n  <path d=\"M21 14h-2\" />\n  <path d=\"M14 21v-2\" />\n  <path d=\"M10 21v-2\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_3D_CAMERA(
        "device-3d-camera",
        "<path d=\"M11 8a2 2 0 0 1 2 -2a2 2 0 0 1 2 2a2 2 0 0 1 -2 2a2 2 0 0 1 -2 -2\" />\n  <path d=\"M8 6a3 3 0 0 1 3 -3h4a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-4a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M13 14v2\" />"),
    DEVICE_3D_LENS(
        "device-3d-lens",
        "<path d=\"M18.005 14.64a3.98 3.98 0 0 0 .995 -2.64\" />\n  <path d=\"M12 4v16\" />\n  <path d=\"M15 5v14a7 7 0 0 0 0 -14\" />\n  <path d=\"M9 5v14a7 7 0 0 1 0 -14\" />"),
    DEVICE_AIRPODS(
        "device-airpods",
        "<path d=\"M6 4a4 4 0 0 1 4 3.8l0 .2v10.5a1.5 1.5 0 0 1 -3 0v-6.5h-1a4 4 0 0 1 -4 -3.8l0 -.2a4 4 0 0 1 4 -4\" />\n  <path d=\"M18 4a4 4 0 0 0 -4 3.8l0 .2v10.5a1.5 1.5 0 0 0 3 0v-6.5h1a4 4 0 0 0 4 -3.8l0 -.2a4 4 0 0 0 -4 -4\" />"),
    DEVICE_AIRPODS_CASE(
        "device-airpods-case",
        "<path d=\"M21 10h-18\" />\n  <path d=\"M3 8a4 4 0 0 1 4 -4h10a4 4 0 0 1 4 4v8a4 4 0 0 1 -4 4h-10a4 4 0 0 1 -4 -4l0 -8\" />\n  <path d=\"M7 10v1.5a1.5 1.5 0 0 0 1.5 1.5h7a1.5 1.5 0 0 0 1.5 -1.5v-1.5\" />"),
    DEVICE_AIRTAG(
        "device-airtag",
        "<path d=\"M4 12a8 8 0 1 0 16 0a8 8 0 0 0 -16 0\" />\n  <path d=\"M9 15v.01\" />\n  <path d=\"M15 15a6 6 0 0 0 -6 -6\" />\n  <path d=\"M12 15a3 3 0 0 0 -3 -3\" />"),
    DEVICE_ANALYTICS(
        "device-analytics",
        "<path d=\"M3 5a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -10\" />\n  <path d=\"M7 20l10 0\" />\n  <path d=\"M9 16l0 4\" />\n  <path d=\"M15 16l0 4\" />\n  <path d=\"M8 12l3 -3l2 2l3 -3\" />"),
    DEVICE_AUDIO_TAPE(
        "device-audio-tape",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M3 17l4 -3h10l4 3\" />\n  <path d=\"M7 9.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M16 9.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />"),
    DEVICE_CAMERA_PHONE(
        "device-camera-phone",
        "<path d=\"M16 8.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M13 7h-8a2 2 0 0 0 -2 2v7a2 2 0 0 0 2 2h13a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M17 15v-1\" />"),
    DEVICE_CCTV(
        "device-cctv",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -2\" />\n  <path d=\"M8 14a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M19 7v7a7 7 0 0 1 -14 0v-7\" />\n  <path d=\"M12 14l.01 0\" />"),
    DEVICE_CCTV_OFF(
        "device-cctv-off",
        "<path d=\"M7 7h-3a1 1 0 0 1 -1 -1v-2c0 -.275 .11 -.523 .29 -.704m3.71 -.296h13a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-9\" />\n  <path d=\"M10.36 10.35a4 4 0 1 0 5.285 5.3\" />\n  <path d=\"M19 7v7c0 .321 -.022 .637 -.064 .947m-1.095 2.913a7 7 0 0 1 -12.841 -3.86l0 -7\" />\n  <path d=\"M12 14h.01\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_COMPUTER_CAMERA(
        "device-computer-camera",
        "<path d=\"M5 10a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M9 10a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M8 16l-2.091 3.486a1 1 0 0 0 .857 1.514h10.468a1 1 0 0 0 .857 -1.514l-2.091 -3.486\" />"),
    DEVICE_COMPUTER_CAMERA_2(
        "device-computer-camera-2",
        "<path d=\"M17 14h-10a4 4 0 0 1 -4 -4a4 4 0 0 1 4 -4h10a4 4 0 0 1 4 4a4 4 0 0 1 -4 4\" />\n  <path d=\"M15 14h-6v4h6v-4\" />\n  <path d=\"M17 18h-10\" />\n  <path d=\"M12 10.02v.01\" />"),
    DEVICE_COMPUTER_CAMERA_OFF(
        "device-computer-camera-off",
        "<path d=\"M6.15 6.153a7 7 0 0 0 9.696 9.696m2 -2a7 7 0 0 0 -9.699 -9.695\" />\n  <path d=\"M9.13 9.122a3 3 0 0 0 3.743 3.749m2 -2a3 3 0 0 0 -3.737 -3.736\" />\n  <path d=\"M8 16l-2.091 3.486a1 1 0 0 0 .857 1.514h10.468a1 1 0 0 0 .857 -1.514l-2.091 -3.486\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_DESKTOP(
        "device-desktop",
        "<path d=\"M3 5a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-10\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 16v4\" />"),
    DEVICE_DESKTOP_ANALYTICS(
        "device-desktop-analytics",
        "<path d=\"M3 5a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1l0 -10\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 16v4\" />\n  <path d=\"M9 12v-4\" />\n  <path d=\"M12 12v-1\" />\n  <path d=\"M15 12v-2\" />\n  <path d=\"M12 12v-1\" />"),
    DEVICE_DESKTOP_BOLT(
        "device-desktop-bolt",
        "<path d=\"M14.5 16h-10.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M7 20h6\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DEVICE_DESKTOP_CANCEL(
        "device-desktop-cancel",
        "<path d=\"M12.5 16h-8.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DEVICE_DESKTOP_CHECK(
        "device-desktop-check",
        "<path d=\"M12 16h-8a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M15 19l2 2l4 -4\" />\n  <path d=\"M7 20h4\" />\n  <path d=\"M9 16v4\" />"),
    DEVICE_DESKTOP_CODE(
        "device-desktop-code",
        "<path d=\"M12.5 16h-8.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M7 20h4\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DEVICE_DESKTOP_COG(
        "device-desktop-cog",
        "<path d=\"M12 16h-8a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_DESKTOP_DOLLAR(
        "device-desktop-dollar",
        "<path d=\"M13 16h-9a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v5.5\" />\n  <path d=\"M7 20h6.5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_DESKTOP_DOWN(
        "device-desktop-down",
        "<path d=\"M13.5 16h-9.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_DESKTOP_EXCLAMATION(
        "device-desktop-exclamation",
        "<path d=\"M15 16h-11a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7\" />\n  <path d=\"M7 20h8\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 16v4\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_DESKTOP_HEART(
        "device-desktop-heart",
        "<path d=\"M10 16h-6a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6\" />\n  <path d=\"M7 20h3.5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_DESKTOP_MINUS(
        "device-desktop-minus",
        "<path d=\"M13.5 16h-9.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v10\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_DESKTOP_OFF(
        "device-desktop-off",
        "<path d=\"M8 4h12a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1m-4 0h-12a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1\" />\n  <path d=\"M7 20h10\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 16v4\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_DESKTOP_PAUSE(
        "device-desktop-pause",
        "<path d=\"M13 16h-9a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />\n  <path d=\"M7 20h6\" />\n  <path d=\"M9 16v4\" />"),
    DEVICE_DESKTOP_PIN(
        "device-desktop-pin",
        "<path d=\"M12.5 16h-8.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />"),
    DEVICE_DESKTOP_PLUS(
        "device-desktop-plus",
        "<path d=\"M13.5 16h-9.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DEVICE_DESKTOP_QUESTION(
        "device-desktop-question",
        "<path d=\"M13.5 16h-9.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6.5\" />\n  <path d=\"M7 20h8\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_DESKTOP_SEARCH(
        "device-desktop-search",
        "<path d=\"M11.5 16h-7.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6.5\" />\n  <path d=\"M7 20h4\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DEVICE_DESKTOP_SHARE(
        "device-desktop-share",
        "<path d=\"M12.5 16h-8.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M7 20h5.5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_DESKTOP_STAR(
        "device-desktop-star",
        "<path d=\"M10 16h-6a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6.5\" />\n  <path d=\"M7 20h3.5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_DESKTOP_UP(
        "device-desktop-up",
        "<path d=\"M13.5 16h-9.5a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M9 16v4\" />"),
    DEVICE_DESKTOP_X(
        "device-desktop-x",
        "<path d=\"M13 16h-9a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M7 20h6.5\" />\n  <path d=\"M9 16v4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    DEVICE_FLOPPY(
        "device-floppy",
        "<path d=\"M6 4h10l4 4v10a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2\" />\n  <path d=\"M10 14a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 4l0 4l-6 0l0 -4\" />"),
    DEVICE_GAMEPAD(
        "device-gamepad",
        "<path d=\"M2 8a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M6 12h4m-2 -2v4\" />\n  <path d=\"M15 11l0 .01\" />\n  <path d=\"M18 13l0 .01\" />"),
    DEVICE_GAMEPAD_2(
        "device-gamepad-2",
        "<path d=\"M12 5h3.5a5 5 0 0 1 0 10h-5.5l-4.015 4.227a2.3 2.3 0 0 1 -3.923 -2.035l1.634 -8.173a5 5 0 0 1 4.904 -4.019h3.4\" />\n  <path d=\"M14 15l4.07 4.284a2.3 2.3 0 0 0 3.925 -2.023l-1.6 -8.232\" />\n  <path d=\"M8 9v2\" />\n  <path d=\"M7 10h2\" />\n  <path d=\"M14 10h2\" />"),
    DEVICE_GAMEPAD_3(
        "device-gamepad-3",
        "<path d=\"M9 12l-3 -3h-2a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h2l3 -3\" />\n  <path d=\"M15 12l3 -3h2a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-2l-3 -3\" />\n  <path d=\"M12 15l-3 3v2a1 1 0 0 0 1 1h4a1 1 0 0 0 1 -1v-2l-3 -3\" />\n  <path d=\"M12 9l-3 -3v-2a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v2l-3 3\" />"),
    DEVICE_HEART_MONITOR(
        "device-heart-monitor",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 9h6l1 -2l2 4l1 -2h6\" />\n  <path d=\"M4 14h16\" />\n  <path d=\"M14 17v.01\" />\n  <path d=\"M17 17v.01\" />"),
    DEVICE_IMAC(
        "device-imac",
        "<path d=\"M3 4a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-12\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M14 17l.5 4\" />"),
    DEVICE_IMAC_BOLT(
        "device-imac-bolt",
        "<path d=\"M13.5 17h-9.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8.5\" />\n  <path d=\"M3 13h13\" />\n  <path d=\"M8 21h5.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DEVICE_IMAC_CANCEL(
        "device-imac-cancel",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M3 13h12.5\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DEVICE_IMAC_CHECK(
        "device-imac-check",
        "<path d=\"M11.5 17h-7.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v9\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h3.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICE_IMAC_CODE(
        "device-imac-code",
        "<path d=\"M11.5 17h-7.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v9\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h3.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DEVICE_IMAC_COG(
        "device-imac-cog",
        "<path d=\"M12 17h-8a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M3 13h13\" />\n  <path d=\"M8 21h4\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_IMAC_DOLLAR(
        "device-imac-dollar",
        "<path d=\"M13 17h-9a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v6.5\" />\n  <path d=\"M3 13h11\" />\n  <path d=\"M8 21h5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_IMAC_DOWN(
        "device-imac-down",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8.5\" />\n  <path d=\"M3 13h13\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_IMAC_EXCLAMATION(
        "device-imac-exclamation",
        "<path d=\"M15 17h-11a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8.5\" />\n  <path d=\"M3 13h13\" />\n  <path d=\"M8 21h7\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M14 17l.5 4\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_IMAC_HEART(
        "device-imac-heart",
        "<path d=\"M10 17h-6a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7\" />\n  <path d=\"M3 13h9\" />\n  <path d=\"M8 21h3.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_IMAC_MINUS(
        "device-imac-minus",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v11\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_IMAC_OFF(
        "device-imac-off",
        "<path d=\"M7 3h13a1 1 0 0 1 1 1v12c0 .28 -.115 .532 -.3 .713m-3.7 .287h-13a1 1 0 0 1 -1 -1v-12c0 -.276 .112 -.526 .293 -.707\" />\n  <path d=\"M3 13h10m4 0h4\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M14 17l.5 4\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_IMAC_PAUSE(
        "device-imac-pause",
        "<path d=\"M13 17h-9a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v9\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    DEVICE_IMAC_PIN(
        "device-imac-pin",
        "<path d=\"M12 17h-8a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />\n  <path d=\"M3 13h11\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />"),
    DEVICE_IMAC_PLUS(
        "device-imac-plus",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8.5\" />\n  <path d=\"M3 13h13.5\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DEVICE_IMAC_QUESTION(
        "device-imac-question",
        "<path d=\"M14 17h-10a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M3 13h11.5\" />\n  <path d=\"M8 21h7\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M14 17l.5 4\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_IMAC_SEARCH(
        "device-imac-search",
        "<path d=\"M11 17h-7a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8\" />\n  <path d=\"M3 13h10\" />\n  <path d=\"M8 21h4\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DEVICE_IMAC_SHARE(
        "device-imac-share",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v9\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h4\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_IMAC_STAR(
        "device-imac-star",
        "<path d=\"M10 17h-6a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M3 13h10\" />\n  <path d=\"M8 21h3\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_IMAC_UP(
        "device-imac-up",
        "<path d=\"M12.5 17h-8.5a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v8.5\" />\n  <path d=\"M3 13h13\" />\n  <path d=\"M8 21h4.5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DEVICE_IMAC_X(
        "device-imac-x",
        "<path d=\"M13 17h-9a1 1 0 0 1 -1 -1v-12a1 1 0 0 1 1 -1h16a1 1 0 0 1 1 1v9\" />\n  <path d=\"M3 13h18\" />\n  <path d=\"M8 21h5\" />\n  <path d=\"M10 17l-.5 4\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    DEVICE_IPAD(
        "device-ipad",
        "<path d=\"M18 3a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2l12 0\" />\n  <path d=\"M9 18h6\" />"),
    DEVICE_IPAD_BOLT(
        "device-ipad-bolt",
        "<path d=\"M13.5 21h-7.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DEVICE_IPAD_CANCEL(
        "device-ipad-cancel",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DEVICE_IPAD_CHECK(
        "device-ipad-check",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICE_IPAD_CODE(
        "device-ipad-code",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DEVICE_IPAD_COG(
        "device-ipad-cog",
        "<path d=\"M12 21h-6a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_IPAD_DOLLAR(
        "device-ipad-dollar",
        "<path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_IPAD_DOWN(
        "device-ipad-down",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_IPAD_EXCLAMATION(
        "device-ipad-exclamation",
        "<path d=\"M15 21h-9a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_IPAD_HEART(
        "device-ipad-heart",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 18h1\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_IPAD_HORIZONTAL(
        "device-ipad-horizontal",
        "<path d=\"M3 6a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-12\" />\n  <path d=\"M9 17h6\" />"),
    DEVICE_IPAD_HORIZONTAL_BOLT(
        "device-ipad-horizontal-bolt",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 17h4.5\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DEVICE_IPAD_HORIZONTAL_CANCEL(
        "device-ipad-horizontal-cancel",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 17h3.5\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DEVICE_IPAD_HORIZONTAL_CHECK(
        "device-ipad-horizontal-check",
        "<path d=\"M11 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M15 19l2 2l4 -4\" />\n  <path d=\"M9 17h2.5\" />"),
    DEVICE_IPAD_HORIZONTAL_CODE(
        "device-ipad-horizontal-code",
        "<path d=\"M11 20h-6a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 17h2.5\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DEVICE_IPAD_HORIZONTAL_COG(
        "device-ipad-horizontal-cog",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 17h3\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_IPAD_HORIZONTAL_DOLLAR(
        "device-ipad-horizontal-dollar",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4.5\" />\n  <path d=\"M9 17h4\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_IPAD_HORIZONTAL_DOWN(
        "device-ipad-horizontal-down",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 17h3.5\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_IPAD_HORIZONTAL_EXCLAMATION(
        "device-ipad-horizontal-exclamation",
        "<path d=\"M15 20h-10a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 17h6\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_IPAD_HORIZONTAL_HEART(
        "device-ipad-horizontal-heart",
        "<path d=\"M10.5 20h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5\" />\n  <path d=\"M9 17h1\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_IPAD_HORIZONTAL_MINUS(
        "device-ipad-horizontal-minus",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v9\" />\n  <path d=\"M9 17h3.5\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_IPAD_HORIZONTAL_OFF(
        "device-ipad-horizontal-off",
        "<path d=\"M8 4h12a2 2 0 0 1 2 2v12m-2 2h-16a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2\" />\n  <path d=\"M9 17h6\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_IPAD_HORIZONTAL_PAUSE(
        "device-ipad-horizontal-pause",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 17h4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    DEVICE_IPAD_HORIZONTAL_PIN(
        "device-ipad-horizontal-pin",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5\" />\n  <path d=\"M9 17h3\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    DEVICE_IPAD_HORIZONTAL_PLUS(
        "device-ipad-horizontal-plus",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 17h3.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DEVICE_IPAD_HORIZONTAL_QUESTION(
        "device-ipad-horizontal-question",
        "<path d=\"M15 20h-10a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5\" />\n  <path d=\"M9 17h4.5\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_IPAD_HORIZONTAL_SEARCH(
        "device-ipad-horizontal-search",
        "<path d=\"M11.5 20h-6.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5.5\" />\n  <path d=\"M9 17h2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DEVICE_IPAD_HORIZONTAL_SHARE(
        "device-ipad-horizontal-share",
        "<path d=\"M12.5 20h-7.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 17h3\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_IPAD_HORIZONTAL_STAR(
        "device-ipad-horizontal-star",
        "<path d=\"M10.5 20h-5.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v5.5\" />\n  <path d=\"M9 17h1\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_IPAD_HORIZONTAL_UP(
        "device-ipad-horizontal-up",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M9 17h3.5\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DEVICE_IPAD_HORIZONTAL_X(
        "device-ipad-horizontal-x",
        "<path d=\"M13.5 20h-8.5a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v7\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />\n  <path d=\"M9 17h4\" />"),
    DEVICE_IPAD_MINUS(
        "device-ipad-minus",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v10\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_IPAD_OFF(
        "device-ipad-off",
        "<path d=\"M6 2h12a2 2 0 0 1 2 2v12m0 4a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2v-16\" />\n  <path d=\"M9 19h6\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_IPAD_PAUSE(
        "device-ipad-pause",
        "<path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M9 18h4\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    DEVICE_IPAD_PIN(
        "device-ipad-pin",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    DEVICE_IPAD_PLUS(
        "device-ipad-plus",
        "<path d=\"M12.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />\n  <path d=\"M9 18h3\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DEVICE_IPAD_QUESTION(
        "device-ipad-question",
        "<path d=\"M15 21h-9a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 18h5\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_IPAD_SEARCH(
        "device-ipad-search",
        "<path d=\"M11.5 21h-5.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 18h2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DEVICE_IPAD_SHARE(
        "device-ipad-share",
        "<path d=\"M12 21h-6a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v8\" />\n  <path d=\"M9 18h3.5\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_IPAD_STAR(
        "device-ipad-star",
        "<path d=\"M11 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v5.5\" />\n  <path d=\"M9 18h1\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_IPAD_UP(
        "device-ipad-up",
        "<path d=\"M9 18h3\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M13.5 21h-6.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v7\" />"),
    DEVICE_IPAD_X(
        "device-ipad-x",
        "<path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />\n  <path d=\"M13 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v9\" />\n  <path d=\"M9 18h4\" />"),
    DEVICE_LANDLINE_PHONE(
        "device-landline-phone",
        "<path d=\"M20 3h-2a2 2 0 0 0 -2 2v14a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-14a2 2 0 0 0 -2 -2\" />\n  <path d=\"M16 4h-11a3 3 0 0 0 -3 3v10a3 3 0 0 0 3 3h11\" />\n  <path d=\"M12 8h-6v3h6l0 -3\" />\n  <path d=\"M12 14v.01\" />\n  <path d=\"M9 14v.01\" />\n  <path d=\"M6 14v.01\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M9 17v.01\" />\n  <path d=\"M6 17v.01\" />"),
    DEVICE_LAPTOP(
        "device-laptop",
        "<path d=\"M3 19l18 0\" />\n  <path d=\"M5 7a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -8\" />"),
    DEVICE_LAPTOP_OFF(
        "device-laptop-off",
        "<path d=\"M3 19h16\" />\n  <path d=\"M10 6h8a1 1 0 0 1 1 1v8m-3 1h-10a1 1 0 0 1 -1 -1v-8a1 1 0 0 1 1 -1\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_MOBILE(
        "device-mobile",
        "<path d=\"M6 5a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_BOLT(
        "device-mobile-bolt",
        "<path d=\"M13.5 21h-5.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_CANCEL(
        "device-mobile-cancel",
        "<path d=\"M12 21h-4a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_CHARGING(
        "device-mobile-charging",
        "<path d=\"M6 5a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 9.5l-1 2.5h2l-1 2.5\" />"),
    DEVICE_MOBILE_CHECK(
        "device-mobile-check",
        "<path d=\"M11.5 21h-3.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v9.5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICE_MOBILE_CODE(
        "device-mobile-code",
        "<path d=\"M11.5 21h-3.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_COG(
        "device-mobile-cog",
        "<path d=\"M12 21h-4a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v6.5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_MOBILE_DOLLAR(
        "device-mobile-dollar",
        "<path d=\"M13 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_MOBILE_DOWN(
        "device-mobile-down",
        "<path d=\"M12.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_MOBILE_EXCLAMATION(
        "device-mobile-exclamation",
        "<path d=\"M15 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_MOBILE_HEART(
        "device-mobile-heart",
        "<path d=\"M11.5 21h-3.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v6\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_MOBILE_MESSAGE(
        "device-mobile-message",
        "<path d=\"M11 3h10v8h-3l-4 2v-2h-3l0 -8\" />\n  <path d=\"M15 16v4a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1v-14a1 1 0 0 1 1 -1h2\" />\n  <path d=\"M10 18v.01\" />"),
    DEVICE_MOBILE_MINUS(
        "device-mobile-minus",
        "<path d=\"M12.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v10\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_MOBILE_OFF(
        "device-mobile-off",
        "<path d=\"M7.159 3.185c.256 -.119 .54 -.185 .841 -.185h8a2 2 0 0 1 2 2v9m0 4v1a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-13\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_PAUSE(
        "device-mobile-pause",
        "<path d=\"M13 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_PIN(
        "device-mobile-pin",
        "<path d=\"M12.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v6\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_PLUS(
        "device-mobile-plus",
        "<path d=\"M12.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_QUESTION(
        "device-mobile-question",
        "<path d=\"M15 21h-7a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v6\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_ROTATED(
        "device-mobile-rotated",
        "<path d=\"M3 8a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M20 11v2\" />\n  <path d=\"M7 12h-.01\" />"),
    DEVICE_MOBILE_SEARCH(
        "device-mobile-search",
        "<path d=\"M12 21h-4a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v6\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_SHARE(
        "device-mobile-share",
        "<path d=\"M12 21h-4a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_STAR(
        "device-mobile-star",
        "<path d=\"M11 21h-3a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_MOBILE_UP(
        "device-mobile-up",
        "<path d=\"M12.5 21h-4.5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v7\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_MOBILE_VIBRATION(
        "device-mobile-vibration",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M8 4l2 0\" />\n  <path d=\"M9 17l0 .01\" />\n  <path d=\"M21 6l-2 3l2 3l-2 3l2 3\" />"),
    DEVICE_MOBILE_X(
        "device-mobile-x",
        "<path d=\"M13 21h-5a2 2 0 0 1 -2 -2v-14a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M12 17v.01\" />"),
    DEVICE_NINTENDO(
        "device-nintendo",
        "<path d=\"M10 20v-16h-3a4 4 0 0 0 -4 4v8a4 4 0 0 0 4 4h3\" />\n  <path d=\"M14 20v-16h3a4 4 0 0 1 4 4v8a4 4 0 0 1 -4 4h-3\" />\n  <path d=\"M16.5 15.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" fill=\"currentColor\" />\n  <path d=\"M5.5 8.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" fill=\"currentColor\" />"),
    DEVICE_NINTENDO_OFF(
        "device-nintendo-off",
        "<path d=\"M4.713 4.718a4 4 0 0 0 -1.713 3.282v8a4 4 0 0 0 4 4h3v-10m0 -4v-2h-2\" />\n  <path d=\"M14 10v-6h3a4 4 0 0 1 4 4v8c0 .308 -.035 .608 -.1 .896m-1.62 2.39a3.982 3.982 0 0 1 -2.28 .714h-3v-6\" />\n  <path d=\"M5.5 8.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_REMOTE(
        "device-remote",
        "<path d=\"M10 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 5a2 2 0 0 1 2 -2h6a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M12 3v2\" />\n  <path d=\"M10 15v.01\" />\n  <path d=\"M10 18v.01\" />\n  <path d=\"M14 18v.01\" />\n  <path d=\"M14 15v.01\" />"),
    DEVICE_SCREEN(
        "device-screen",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M15 7l-6 10\" />\n  <path d=\"M15 14l-1.75 3\" />\n  <path d=\"M10.75 7l-1.75 3\" />"),
    DEVICE_SD_CARD(
        "device-sd-card",
        "<path d=\"M7 21h10a2 2 0 0 0 2 -2v-14a2 2 0 0 0 -2 -2h-6.172a2 2 0 0 0 -1.414 .586l-3.828 3.828a2 2 0 0 0 -.586 1.414v10.172a2 2 0 0 0 2 2\" />\n  <path d=\"M13 6v2\" />\n  <path d=\"M16 6v2\" />\n  <path d=\"M10 7v1\" />"),
    DEVICE_SIM(
        "device-sim",
        "<path d=\"M6 3h8.5l4.5 4.5v12.5a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M9 11h3v6\" />\n  <path d=\"M15 17v.01\" />\n  <path d=\"M15 14v.01\" />\n  <path d=\"M15 11v.01\" />\n  <path d=\"M9 14v.01\" />\n  <path d=\"M9 17v.01\" />"),
    DEVICE_SIM_1(
        "device-sim-1",
        "<path d=\"M6 3h8.5l4.5 4.5v12.5a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M10 11l2 -2v8\" />"),
    DEVICE_SIM_2(
        "device-sim-2",
        "<path d=\"M6 3h8.5l4.5 4.5v12.5a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M10 9h3a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 0 -1 1v2a1 1 0 0 0 1 1h3\" />"),
    DEVICE_SIM_3(
        "device-sim-3",
        "<path d=\"M6 3h8.5l4.5 4.5v12.5a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1\" />\n  <path d=\"M10 9h2.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-1.5h1.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-2.5\" />"),
    DEVICE_SPEAKER(
        "device-speaker",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M9 14a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 7l0 .01\" />"),
    DEVICE_SPEAKER_OFF(
        "device-speaker-off",
        "<path d=\"M7 3h10a2 2 0 0 1 2 2v10m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M11.114 11.133a3 3 0 1 0 3.754 3.751\" />\n  <path d=\"M12 7v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_TABLET(
        "device-tablet",
        "<path d=\"M5 4a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v16a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-16\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_BOLT(
        "device-tablet-bolt",
        "<path d=\"M13.5 21h-7.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_CANCEL(
        "device-tablet-cancel",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_CHECK(
        "device-tablet-check",
        "<path d=\"M11.5 21h-5.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v9.5\" />\n  <path d=\"M12.314 16.05a1 1 0 0 0 -1.042 1.635\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICE_TABLET_CODE(
        "device-tablet-code",
        "<path d=\"M11.5 21h-5.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v9\" />\n  <path d=\"M12.344 16.06a1 1 0 0 0 -1.07 1.627\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    DEVICE_TABLET_COG(
        "device-tablet-cog",
        "<path d=\"M12 21h-6a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v7.5\" />\n  <path d=\"M12 16a1 1 0 0 0 0 2\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_TABLET_DOLLAR(
        "device-tablet-dollar",
        "<path d=\"M13 21h-7a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v6\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICE_TABLET_DOWN(
        "device-tablet-down",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_EXCLAMATION(
        "device-tablet-exclamation",
        "<path d=\"M15 21h-9a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_TABLET_HEART(
        "device-tablet-heart",
        "<path d=\"M11.5 21h-5.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v7\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_TABLET_MINUS(
        "device-tablet-minus",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v11\" />\n  <path d=\"M12.872 16.51a1 1 0 1 0 -.872 1.49\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_TABLET_OFF(
        "device-tablet-off",
        "<path d=\"M7 3h11a1 1 0 0 1 1 1v11m0 4v1a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1v-15\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_TABLET_PAUSE(
        "device-tablet-pause",
        "<path d=\"M13 21h-7a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v9.5\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_PIN(
        "device-tablet-pin",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v7\" />\n  <path d=\"M12 16a1 1 0 0 0 0 2\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    DEVICE_TABLET_PLUS(
        "device-tablet-plus",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_QUESTION(
        "device-tablet-question",
        "<path d=\"M15 21h-9a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v7\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TABLET_SEARCH(
        "device-tablet-search",
        "<path d=\"M11.5 21h-5.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v7\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    DEVICE_TABLET_SHARE(
        "device-tablet-share",
        "<path d=\"M12 21h-6a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v9\" />\n  <path d=\"M12.57 16.178a1 1 0 1 0 .016 1.633\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_TABLET_STAR(
        "device-tablet-star",
        "<path d=\"M11 21h-5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v6\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_TABLET_UP(
        "device-tablet-up",
        "<path d=\"M12.5 21h-6.5a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v8\" />\n  <path d=\"M12.906 16.576a1 1 0 1 0 -.906 1.424\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DEVICE_TABLET_X(
        "device-tablet-x",
        "<path d=\"M13 21h-7a1 1 0 0 1 -1 -1v-16a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v9.5\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />\n  <path d=\"M11 17a1 1 0 1 0 2 0a1 1 0 0 0 -2 0\" />"),
    DEVICE_TV(
        "device-tv",
        "<path d=\"M3 9a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -9\" />\n  <path d=\"M16 3l-4 4l-4 -4\" />"),
    DEVICE_TV_OFF(
        "device-tv-off",
        "<path d=\"M11 7h8a2 2 0 0 1 2 2v8m-1.178 2.824c-.25 .113 -.529 .176 -.822 .176h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M16 3l-4 4l-4 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_TV_OLD(
        "device-tv-old",
        "<path d=\"M3 9a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -9\" />\n  <path d=\"M16 3l-4 4l-4 -4\" />\n  <path d=\"M15 7v13\" />\n  <path d=\"M18 15v.01\" />\n  <path d=\"M18 12v.01\" />"),
    DEVICE_USB(
        "device-usb",
        "<path d=\"M7 8h10v8a5 5 0 0 1 -10 0l0 -8\" />\n  <path d=\"M9 8v-5h6v5\" />"),
    DEVICE_VISION_PRO(
        "device-vision-pro",
        "<path d=\"M12 7c1.143 0 2.235 .035 3.275 .104c1.017 .068 1.95 .207 2.798 .42c.813 .203 1.52 .505 2.119 .909a3.903 3.903 0 0 1 1.328 1.531c.326 .657 .48 1.48 .48 2.466c0 1.006 -.189 1.91 -.574 2.707c-.375 .779 -.886 1.396 -1.537 1.848a3.696 3.696 0 0 1 -2.16 .66c-.509 0 -.97 -.068 -1.382 -.21a5.84 5.84 0 0 1 -1.17 -.548a18.45 18.45 0 0 1 -1.045 -.695a9.104 9.104 0 0 0 -1.001 -.63a2.376 2.376 0 0 0 -1.13 -.301c-.373 0 -.75 .097 -1.132 .3c-.316 .17 -.65 .38 -1 .63c-.322 .23 -.67 .462 -1.047 .695a5.78 5.78 0 0 1 -1.168 .548c-.413 .142 -.872 .21 -1.378 .21a3.706 3.706 0 0 1 -2.165 -.659c-.651 -.452 -1.162 -1.07 -1.537 -1.848c-.385 -.798 -.574 -1.7 -.574 -2.709c-.004 -.98 .15 -1.802 .477 -2.46a3.897 3.897 0 0 1 1.33 -1.531c.6 -.403 1.307 -.704 2.12 -.907a16.088 16.088 0 0 1 2.8 -.423c1.04 -.071 2.13 -.107 3.273 -.107\" />"),
    DEVICE_VISION_PRO_WIFI(
        "device-vision-pro-wifi",
        "<path d=\"M12 10q 1.715 0 3.275 .104q 1.526 .101 2.798 .42q 1.22 .304 2.119 .909a3.9 3.9 0 0 1 1.328 1.531c.326 .657 .48 1.48 .48 2.466q .002 1.51 -.574 2.707q -.562 1.17 -1.537 1.848a3.7 3.7 0 0 1 -2.16 .66q -.764 .002 -1.382 -.21a6 6 0 0 1 -1.17 -.548a19 19 0 0 1 -1.045 -.695a9 9 0 0 0 -1.001 -.63a2.4 2.4 0 0 0 -1.13 -.301c-.373 0 -.75 .097 -1.132 .3q -.475 .255 -1 .63q -.482 .345 -1.047 .695a5.8 5.8 0 0 1 -1.168 .548q -.62 .211 -1.378 .21a3.7 3.7 0 0 1 -2.165 -.659q -.976 -.68 -1.537 -1.848q -.576 -1.196 -.574 -2.709c-.004 -.98 .15 -1.802 .477 -2.46c.3 -.619 .76 -1.147 1.33 -1.531q .9 -.604 2.12 -.907q 1.382 -.335 2.8 -.423q 1.56 -.107 3.273 -.107\" />\n  <path d=\"M7 4.071a7.07 7.07 0 0 1 10 0\" />\n  <path d=\"M9.5 6.572a3.535 3.535 0 0 1 5.001 0\" />"),
    DEVICE_WATCH(
        "device-watch",
        "<path d=\"M6 9a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-6\" />\n  <path d=\"M9 18v3h6v-3\" />\n  <path d=\"M9 6v-3h6v3\" />"),
    DEVICE_WATCH_BOLT(
        "device-watch-bolt",
        "<path d=\"M13 18h-4a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 18v3h4.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    DEVICE_WATCH_CANCEL(
        "device-watch-cancel",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 18v3h3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    DEVICE_WATCH_CHECK(
        "device-watch-check",
        "<path d=\"M11 18h-2a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v5.5\" />\n  <path d=\"M9 18v3h2.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICE_WATCH_CODE(
        "device-watch-code",
        "<path d=\"M11 18h-2a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v4\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />\n  <path d=\"M9 18v3h3\" />\n  <path d=\"M9 6v-3h6v3\" />"),
    DEVICE_WATCH_COG(
        "device-watch-cog",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v2.5\" />\n  <path d=\"M9 18v3h3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICE_WATCH_DOLLAR(
        "device-watch-dollar",
        "<path d=\"M13 18h-4a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v1\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />\n  <path d=\"M9 18v3h4\" />\n  <path d=\"M9 6v-3h6v3\" />"),
    DEVICE_WATCH_DOWN(
        "device-watch-down",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 18v3h3.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    DEVICE_WATCH_EXCLAMATION(
        "device-watch-exclamation",
        "<path d=\"M15 18h-6a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 18v3h6v-3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICE_WATCH_HEART(
        "device-watch-heart",
        "<path d=\"M10 18h-1a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v2\" />\n  <path d=\"M9 18v3h2.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    DEVICE_WATCH_MINUS(
        "device-watch-minus",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v6\" />\n  <path d=\"M9 18v3h3.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M16 19h6\" />"),
    DEVICE_WATCH_OFF(
        "device-watch-off",
        "<path d=\"M10 6h5a3 3 0 0 1 3 3v5m-.89 3.132a2.99 2.99 0 0 1 -2.11 .868h-6a3 3 0 0 1 -3 -3v-6c0 -.817 .327 -1.559 .857 -2.1\" />\n  <path d=\"M9 18v3h6v-3\" />\n  <path d=\"M9 5v-2h6v3\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICE_WATCH_PAUSE(
        "device-watch-pause",
        "<path d=\"M13 18h-4a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v4\" />\n  <path d=\"M9 18v3h4\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    DEVICE_WATCH_PIN(
        "device-watch-pin",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v2\" />\n  <path d=\"M9 18v3h3.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    DEVICE_WATCH_PLUS(
        "device-watch-plus",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M9 18v3h3.5\" />\n  <path d=\"M9 6v-3h6v3\" />"),
    DEVICE_WATCH_QUESTION(
        "device-watch-question",
        "<path d=\"M14 18h-5a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v2\" />\n  <path d=\"M9 18v3h6v-2\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    DEVICE_WATCH_SEARCH(
        "device-watch-search",
        "<path d=\"M11 18h-2a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />\n  <path d=\"M9 18v3h3\" />\n  <path d=\"M9 6v-3h6v3\" />"),
    DEVICE_WATCH_SHARE(
        "device-watch-share",
        "<path d=\"M12.5 18h-3.5a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v4\" />\n  <path d=\"M9 18v3h3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    DEVICE_WATCH_STAR(
        "device-watch-star",
        "<path d=\"M10 18h-1a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v1\" />\n  <path d=\"M9 18v3h2\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    DEVICE_WATCH_STATS(
        "device-watch-stats",
        "<path d=\"M6 9a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3l0 -6\" />\n  <path d=\"M9 18v3h6v-3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M9 14v-4\" />\n  <path d=\"M12 14v-1\" />\n  <path d=\"M15 14v-3\" />"),
    DEVICE_WATCH_STATS_2(
        "device-watch-stats-2",
        "<path d=\"M6 9a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3l0 -6\" />\n  <path d=\"M9 18v3h6v-3\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M12 10a2 2 0 1 0 2 2\" />"),
    DEVICE_WATCH_UP(
        "device-watch-up",
        "<path d=\"M12 18h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 18v3h3.5\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    DEVICE_WATCH_X(
        "device-watch-x",
        "<path d=\"M13 18h-4a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v4\" />\n  <path d=\"M9 18v3h4\" />\n  <path d=\"M9 6v-3h6v3\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    DEVICES(
        "devices",
        "<path d=\"M13 9a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-10\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_2(
        "devices-2",
        "<path d=\"M10 15h-6a1 1 0 0 1 -1 -1v-8a1 1 0 0 1 1 -1h6\" />\n  <path d=\"M13 5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M7 19l3 0\" />\n  <path d=\"M17 8l0 .01\" />\n  <path d=\"M16 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M9 15l0 4\" />"),
    DEVICES_BOLT(
        "devices-bolt",
        "<path d=\"M13 19v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_CANCEL(
        "devices-cancel",
        "<path d=\"M13 15.5v-6.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_CHECK(
        "devices-check",
        "<path d=\"M13 15.5v-6.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v4\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h7\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    DEVICES_CODE(
        "devices-code",
        "<path d=\"M13 15.5v-6.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v4m0 6a1 1 0 0 1 -1 1\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h7\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_COG(
        "devices-cog",
        "<path d=\"M13 14.5v-5.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    DEVICES_DOLLAR(
        "devices-dollar",
        "<path d=\"M13 19v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v1.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    DEVICES_DOWN(
        "devices-down",
        "<path d=\"M13 16.5v-7.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_EXCLAMATION(
        "devices-exclamation",
        "<path d=\"M15 20h-1a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    DEVICES_HEART(
        "devices-heart",
        "<path d=\"M13 12v-3a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h6\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_MINUS(
        "devices-minus",
        "<path d=\"M13 16.5v-7.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v6\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_OFF(
        "devices-off",
        "<path d=\"M13 9a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v8m-1 3h-6a1 1 0 0 1 -1 -1v-6\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-9m-4 0a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICES_PAUSE(
        "devices-pause",
        "<path d=\"M13 19v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v4\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_PC(
        "devices-pc",
        "<path d=\"M3 5h6v14h-6l0 -14\" />\n  <path d=\"M12 9h10v7h-10l0 -7\" />\n  <path d=\"M14 19h6\" />\n  <path d=\"M17 16v3\" />\n  <path d=\"M6 13v.01\" />\n  <path d=\"M6 16v.01\" />"),
    DEVICES_PC_OFF(
        "devices-pc-off",
        "<path d=\"M9 9v10h-6v-14h2\" />\n  <path d=\"M13 9h9v7h-2m-4 0h-4v-4\" />\n  <path d=\"M14 19h5\" />\n  <path d=\"M17 17v2\" />\n  <path d=\"M6 13v.01\" />\n  <path d=\"M6 16v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    DEVICES_PIN(
        "devices-pin",
        "<path d=\"M13 14v-5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_PLUS(
        "devices-plus",
        "<path d=\"M13 16.5v-7.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    DEVICES_QUESTION(
        "devices-question",
        "<path d=\"M15 20h-1a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_SEARCH(
        "devices-search",
        "<path d=\"M13 13v-4a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h7\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_SHARE(
        "devices-share",
        "<path d=\"M13 15v-6a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v4\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_STAR(
        "devices-star",
        "<path d=\"M13 13v-4a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v2.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h5.5\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_UP(
        "devices-up",
        "<path d=\"M13 16.5v-7.5a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v3.5\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h8\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M16 9h2\" />"),
    DEVICES_X(
        "devices-x",
        "<path d=\"M14 20a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v4\" />\n  <path d=\"M18 8v-3a1 1 0 0 0 -1 -1h-13a1 1 0 0 0 -1 1v12a1 1 0 0 0 1 1h9\" />\n  <path d=\"M16 9h2\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    DIALPAD(
        "dialpad",
        "<path d=\"M4 3h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M18 3h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M11 3h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M4 10h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M18 10h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M11 10h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M11 17h2a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1\" />"),
    DIALPAD_OFF(
        "dialpad-off",
        "<path d=\"M7 7h-4v-4\" />\n  <path d=\"M17 3h4v4h-4l0 -4\" />\n  <path d=\"M10 6v-3h4v4h-3\" />\n  <path d=\"M3 10h4v4h-4l0 -4\" />\n  <path d=\"M17 13v-3h4v4h-3\" />\n  <path d=\"M14 14h-4v-4\" />\n  <path d=\"M10 17h4v4h-4l0 -4\" />\n  <path d=\"M3 3l18 18\" />"),
    DISC(
        "disc",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 12a5 5 0 0 1 5 -5\" />\n  <path d=\"M12 17a5 5 0 0 0 5 -5\" />"),
    DISC_OFF(
        "disc-off",
        "<path d=\"M20.044 16.04a9 9 0 0 0 -12.082 -12.085m-2.333 1.688a9 9 0 0 0 6.371 15.357c2.491 0 4.73 -1 6.36 -2.631\" />\n  <path d=\"M11.298 11.288a1 1 0 1 0 1.402 1.427\" />\n  <path d=\"M7 12c0 -1.38 .559 -2.629 1.462 -3.534m2.607 -1.38c.302 -.056 .613 -.086 .931 -.086\" />\n  <path d=\"M12 17a4.985 4.985 0 0 0 3.551 -1.48m1.362 -2.587c.057 -.302 .087 -.614 .087 -.933\" />\n  <path d=\"M3 3l18 18\" />"),
    DUAL_SCREEN(
        "dual-screen", "<path d=\"M5 4l8 3v15l-8 -3l0 -15\" />\n  <path d=\"M13 19h6v-15h-14\" />"),
    EARPHONE_BLUETOOTH(
        "earphone-bluetooth",
        "<path d=\"M6.57 12.77a6.9 6.9 0 0 1 -.57 -2.77a7 7 0 0 1 14 0\" />\n  <path d=\"M9 16l-1 1\" />\n  <path d=\"M10.83 19.83l6.36 -6.37a1 1 0 0 0 0 -1.41l-4.19 -4.24a1 1 0 0 0 -1.41 0l-6.42 6.36a4 4 0 0 0 0 5.66a4 4 0 0 0 5.66 0\" />"),
    FRIDGE(
        "fridge",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M9 13v3\" />\n  <path d=\"M9 6v1\" />"),
    FRIDGE_OFF(
        "fridge-off",
        "<path d=\"M7 3h10a2 2 0 0 1 2 2v10m0 4a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2v-14\" />\n  <path d=\"M5 10h5m4 0h5\" />\n  <path d=\"M9 13v3\" />\n  <path d=\"M3 3l18 18\" />"),
    GPU(
        "gpu",
        "<path d=\"M3 4v14\" />\n  <path d=\"M3 6h17a1 1 0 0 1 1 1v8a1 1 0 0 1 -1 1h-17\" />\n  <path d=\"M9 13a2 2 0 1 0 0 -4a2 2 0 0 0 0 4\" />\n  <path d=\"M15 9v4\" />\n  <path d=\"M18 9v4\" />\n  <path d=\"M7 16v3h8v-3\" />"),
    GPU_2(
        "gpu-2",
        "<path d=\"M5 6a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -12\" />\n  <path d=\"M14 9h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2v-3h-1\" />\n  <path d=\"M3 10h2\" />\n  <path d=\"M3 14h2\" />\n  <path d=\"M10 3v2\" />\n  <path d=\"M14 3v2\" />\n  <path d=\"M21 10h-2\" />\n  <path d=\"M21 14h-2\" />\n  <path d=\"M14 21v-2\" />\n  <path d=\"M10 21v-2\" />"),
    HAMMER_DRILL(
        "hammer-drill",
        "<path d=\"M12 15v6\" />\n  <path d=\"M16 5h4\" />\n  <path d=\"M8 5h-4\" />\n  <path d=\"M15 11h-6a1 1 0 0 1 -1 -1v-6a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1\" />\n  <path d=\"M14 11h-4v3a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-3\" />"),
    KEYBOARD(
        "keyboard",
        "<path d=\"M2 8a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M6 10l0 .01\" />\n  <path d=\"M10 10l0 .01\" />\n  <path d=\"M14 10l0 .01\" />\n  <path d=\"M18 10l0 .01\" />\n  <path d=\"M6 14l0 .01\" />\n  <path d=\"M18 14l0 .01\" />\n  <path d=\"M10 14l4 .01\" />"),
    KEYBOARD_HIDE(
        "keyboard-hide",
        "<path d=\"M2 5a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M6 7l0 .01\" />\n  <path d=\"M10 7l0 .01\" />\n  <path d=\"M14 7l0 .01\" />\n  <path d=\"M18 7l0 .01\" />\n  <path d=\"M6 11l0 .01\" />\n  <path d=\"M18 11l0 .01\" />\n  <path d=\"M10 11l4 0\" />\n  <path d=\"M10 21l2 -2l2 2\" />"),
    KEYBOARD_OFF(
        "keyboard-off",
        "<path d=\"M18 18h-14a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h2m4 0h10a2 2 0 0 1 2 2v8c0 .554 -.226 1.056 -.59 1.418\" />\n  <path d=\"M6 10l0 .01\" />\n  <path d=\"M10 10l0 .01\" />\n  <path d=\"M14 10l0 .01\" />\n  <path d=\"M18 10l0 .01\" />\n  <path d=\"M6 14l0 .01\" />\n  <path d=\"M18 14l0 .01\" />\n  <path d=\"M10 14l4 0\" />\n  <path d=\"M3 3l18 18\" />"),
    KEYBOARD_SHOW(
        "keyboard-show",
        "<path d=\"M2 5a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M6 7l0 .01\" />\n  <path d=\"M10 7l0 .01\" />\n  <path d=\"M14 7l0 .01\" />\n  <path d=\"M18 7l0 .01\" />\n  <path d=\"M6 11l0 .01\" />\n  <path d=\"M18 11l0 .01\" />\n  <path d=\"M10 11l4 0\" />\n  <path d=\"M10 19l2 2l2 -2\" />"),
    LAWN_MOWER(
        "lawn-mower",
        "<path d=\"M6 11h5.38a1 1 0 0 1 .9 .55l.72 1.45h5a1 1 0 0 1 1 1v2\" />\n  <path d=\"M3 4h1.13a1 1 0 0 1 1 .86l1.59 11.14\" />\n  <path d=\"M17 18h-8\" />\n  <path d=\"M9 18a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />\n  <path d=\"M21 18a2 2 0 1 1 -4 0a2 2 0 0 1 4 0\" />"),
    MEMORY(
        "memory",
        "<path d=\"M12 11v2\" />\n  <path d=\"M16 11v2\" />\n  <path d=\"M3 7h18a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-18a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1\" />\n  <path d=\"M8 11v2\" />\n  <path d=\"M4 17v2\" />\n  <path d=\"M7 17v2\" />\n  <path d=\"M10 17v2\" />\n  <path d=\"M20 17v2\" />\n  <path d=\"M17 17v2\" />\n  <path d=\"M13 17v2\" />"),
    MOUSE(
        "mouse",
        "<path d=\"M6 7a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v10a4 4 0 0 1 -4 4h-4a4 4 0 0 1 -4 -4l0 -10\" />\n  <path d=\"M12 7l0 4\" />"),
    MOUSE_2(
        "mouse-2",
        "<path d=\"M6 7a4 4 0 0 1 4 -4h4a4 4 0 0 1 4 4v10a4 4 0 0 1 -4 4h-4a4 4 0 0 1 -4 -4l0 -10\" />\n  <path d=\"M12 3v7\" />\n  <path d=\"M6 10h12\" />"),
    MOUSE_OFF(
        "mouse-off",
        "<path d=\"M7.733 3.704a3.982 3.982 0 0 1 2.267 -.704h4a4 4 0 0 1 4 4v7m-.1 3.895a4 4 0 0 1 -3.9 3.105h-4a4 4 0 0 1 -4 -4v-10c0 -.3 .033 -.593 .096 -.874\" />\n  <path d=\"M12 7v1\" />\n  <path d=\"M3 3l18 18\" />"),
    NFC(
        "nfc",
        "<path d=\"M11 20a3 3 0 0 1 -3 -3v-11l5 5\" />\n  <path d=\"M13 4a3 3 0 0 1 3 3v11l-5 -5\" />\n  <path d=\"M4 7a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3l0 -10\" />"),
    NFC_OFF(
        "nfc-off",
        "<path d=\"M11 20a3 3 0 0 1 -3 -3v-9\" />\n  <path d=\"M13 4a3 3 0 0 1 3 3v5m0 4v2l-5 -5\" />\n  <path d=\"M8 4h9a3 3 0 0 1 3 3v9m-.873 3.116a2.99 2.99 0 0 1 -2.127 .884h-10a3 3 0 0 1 -3 -3v-10c0 -.83 .337 -1.582 .882 -2.125\" />\n  <path d=\"M3 3l18 18\" />"),
    PHONE(
        "phone",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />"),
    PHONE_CALL(
        "phone-call",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 7a2 2 0 0 1 2 2\" />\n  <path d=\"M15 3a6 6 0 0 1 6 6\" />"),
    PHONE_CALLING(
        "phone-calling",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 7l0 .01\" />\n  <path d=\"M18 7l0 .01\" />\n  <path d=\"M21 7l0 .01\" />"),
    PHONE_CHECK(
        "phone-check",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 6l2 2l4 -4\" />"),
    PHONE_INCOMING(
        "phone-incoming",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 9l5 -5\" />\n  <path d=\"M15 5l0 4l4 0\" />"),
    PHONE_OFF(
        "phone-off",
        "<path d=\"M3 21l18 -18\" />\n  <path d=\"M5.831 14.161a15.946 15.946 0 0 1 -2.831 -8.161a2 2 0 0 1 2 -2h4l2 5l-2.5 1.5c.108 .22 .223 .435 .345 .645m1.751 2.277c.843 .84 1.822 1.544 2.904 2.078l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a15.963 15.963 0 0 1 -10.344 -4.657\" />"),
    PHONE_OUTGOING(
        "phone-outgoing",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2c-8.072 -.49 -14.51 -6.928 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 5h6\" />\n  <path d=\"M18.5 7.5l2.5 -2.5l-2.5 -2.5\" />"),
    PHONE_PAUSE(
        "phone-pause",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2c-8.072 -.49 -14.51 -6.928 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M17 3v5\" />\n  <path d=\"M21 3v5\" />"),
    PHONE_PLUS(
        "phone-plus",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M15 6h6m-3 -3v6\" />"),
    PHONE_SPARK(
        "phone-spark",
        "<path d=\"M11.584 19.225a16 16 0 0 1 -8.584 -13.225a2 2 0 0 1 2 -2h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l.65 .26\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    PHONE_X(
        "phone-x",
        "<path d=\"M5 4h4l2 5l-2.5 1.5a11 11 0 0 0 5 5l1.5 -2.5l5 2v4a2 2 0 0 1 -2 2a16 16 0 0 1 -15 -15a2 2 0 0 1 2 -2\" />\n  <path d=\"M16 4l4 4m0 -4l-4 4\" />"),
    PLAYSTATION_CIRCLE(
        "playstation-circle",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M7.5 12a4.5 4.5 0 1 0 9 0a4.5 4.5 0 1 0 -9 0\" />"),
    PLAYSTATION_SQUARE(
        "playstation-square",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M8 9a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1l0 -6\" />"),
    PLAYSTATION_TRIANGLE(
        "playstation-triangle",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M7.5 15h9l-4.5 -8l-4.5 8\" />"),
    PLAYSTATION_X(
        "playstation-x",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M8.5 8.5l7 7\" />\n  <path d=\"M8.5 15.5l7 -7\" />"),
    PLUG(
        "plug",
        "<path d=\"M9.785 6l8.215 8.215l-2.054 2.054a5.81 5.81 0 1 1 -8.215 -8.215l2.054 -2.054\" />\n  <path d=\"M4 20l3.5 -3.5\" />\n  <path d=\"M15 4l-3.5 3.5\" />\n  <path d=\"M20 9l-3.5 3.5\" />"),
    PLUG_CONNECTED(
        "plug-connected",
        "<path d=\"M7 12l5 5l-1.5 1.5a3.536 3.536 0 1 1 -5 -5l1.5 -1.5\" />\n  <path d=\"M17 12l-5 -5l1.5 -1.5a3.536 3.536 0 1 1 5 5l-1.5 1.5\" />\n  <path d=\"M3 21l2.5 -2.5\" />\n  <path d=\"M18.5 5.5l2.5 -2.5\" />\n  <path d=\"M10 11l-2 2\" />\n  <path d=\"M13 14l-2 2\" />"),
    PLUG_CONNECTED_X(
        "plug-connected-x",
        "<path d=\"M20 16l-4 4\" />\n  <path d=\"M7 12l5 5l-1.5 1.5a3.536 3.536 0 1 1 -5 -5l1.5 -1.5\" />\n  <path d=\"M17 12l-5 -5l1.5 -1.5a3.536 3.536 0 1 1 5 5l-1.5 1.5\" />\n  <path d=\"M3 21l2.5 -2.5\" />\n  <path d=\"M18.5 5.5l2.5 -2.5\" />\n  <path d=\"M10 11l-2 2\" />\n  <path d=\"M13 14l-2 2\" />\n  <path d=\"M16 16l4 4\" />"),
    PLUG_OFF(
        "plug-off",
        "<path d=\"M16.123 16.092l-.177 .177a5.81 5.81 0 1 1 -8.215 -8.215l.159 -.159\" />\n  <path d=\"M4 20l3.5 -3.5\" />\n  <path d=\"M15 4l-3.5 3.5\" />\n  <path d=\"M20 9l-3.5 3.5\" />\n  <path d=\"M3 3l18 18\" />"),
    PLUG_X(
        "plug-x",
        "<path d=\"M13.55 17.733a5.806 5.806 0 0 1 -7.356 -4.052a5.81 5.81 0 0 1 1.537 -5.627l2.054 -2.054l7.165 7.165\" />\n  <path d=\"M4 20l3.5 -3.5\" />\n  <path d=\"M15 4l-3.5 3.5\" />\n  <path d=\"M20 9l-3.5 3.5\" />\n  <path d=\"M16 16l4 4\" />\n  <path d=\"M20 16l-4 4\" />"),
    POWER("power", "<path d=\"M7 6a7.75 7.75 0 1 0 10 0\" />\n  <path d=\"M12 4l0 8\" />"),
    PRINTER(
        "printer",
        "<path d=\"M17 17h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2h-14a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 9v-4a2 2 0 0 0 -2 -2h-6a2 2 0 0 0 -2 2v4\" />\n  <path d=\"M7 15a2 2 0 0 1 2 -2h6a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2l0 -4\" />"),
    PRINTER_OFF(
        "printer-off",
        "<path d=\"M20.412 16.416c.363 -.362 .588 -.863 .588 -1.416v-4a2 2 0 0 0 -2 -2h-6m-4 0h-4a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2\" />\n  <path d=\"M17 9v-4a2 2 0 0 0 -2 -2h-6c-.551 0 -1.05 .223 -1.412 .584m-.588 3.416v2\" />\n  <path d=\"M17 17v2a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2h4\" />\n  <path d=\"M3 3l18 18\" />"),
    QRCODE(
        "qrcode",
        "<path d=\"M4 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M7 17l0 .01\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M7 7l0 .01\" />\n  <path d=\"M4 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M17 7l0 .01\" />\n  <path d=\"M14 14l3 0\" />\n  <path d=\"M20 14l0 .01\" />\n  <path d=\"M14 14l0 3\" />\n  <path d=\"M14 20l3 0\" />\n  <path d=\"M17 17l3 0\" />\n  <path d=\"M20 17l0 3\" />"),
    QRCODE_OFF(
        "qrcode-off",
        "<path d=\"M8 4h1a1 1 0 0 1 1 1v1m-.297 3.711a1 1 0 0 1 -.703 .289h-4a1 1 0 0 1 -1 -1v-4c0 -.275 .11 -.524 .29 -.705\" />\n  <path d=\"M7 17v.01\" />\n  <path d=\"M14 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M7 7v.01\" />\n  <path d=\"M4 15a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M17 7v.01\" />\n  <path d=\"M20 14v.01\" />\n  <path d=\"M14 14v3\" />\n  <path d=\"M14 20h3\" />\n  <path d=\"M3 3l18 18\" />"),
    REMOTE_CONTROL(
        "remote-control",
        "<path d=\"M9 14a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v5a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2v-5\" />\n  <path d=\"M20 9c-.914 -3.455 -4.15 -6 -8 -6c-3.853 0 -7.089 2.542 -8 6\" />\n  <path d=\"M15 9c-.69 -1.2 -1.517 -2 -3 -2s-2.31 .801 -3 2\" />"),
    ROUTER(
        "router",
        "<path d=\"M3 15a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -4\" />\n  <path d=\"M17 17l0 .01\" />\n  <path d=\"M13 17l0 .01\" />\n  <path d=\"M15 13l0 -2\" />\n  <path d=\"M11.75 8.75a4 4 0 0 1 6.5 0\" />\n  <path d=\"M8.5 6.5a8 8 0 0 1 13 0\" />"),
    ROUTER_OFF(
        "router-off",
        "<path d=\"M17 13h2a2 2 0 0 1 2 2v2m-.588 3.417c-.362 .36 -.861 .583 -1.412 .583h-14a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2h8\" />\n  <path d=\"M17 17v.01\" />\n  <path d=\"M13 17v.01\" />\n  <path d=\"M12.226 8.2a4 4 0 0 1 6.024 .55\" />\n  <path d=\"M9.445 5.407a8 8 0 0 1 12.055 1.093\" />\n  <path d=\"M3 3l18 18\" />"),
    SCREEN_SHARE(
        "screen-share",
        "<path d=\"M21 12v3a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h9\" />\n  <path d=\"M7 20l10 0\" />\n  <path d=\"M9 16l0 4\" />\n  <path d=\"M15 16l0 4\" />\n  <path d=\"M17 4h4v4\" />\n  <path d=\"M16 9l5 -5\" />"),
    SCREEN_SHARE_OFF(
        "screen-share-off",
        "<path d=\"M21 12v3a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-10a1 1 0 0 1 1 -1h9\" />\n  <path d=\"M7 20l10 0\" />\n  <path d=\"M9 16l0 4\" />\n  <path d=\"M15 16l0 4\" />\n  <path d=\"M17 8l4 -4m-4 0l4 4\" />"),
    SERVER(
        "server",
        "<path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2\" />\n  <path d=\"M3 15a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3l0 -2\" />\n  <path d=\"M7 8l0 .01\" />\n  <path d=\"M7 16l0 .01\" />"),
    SERVER_2(
        "server-2",
        "<path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2\" />\n  <path d=\"M3 15a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3l0 -2\" />\n  <path d=\"M7 8l0 .01\" />\n  <path d=\"M7 16l0 .01\" />\n  <path d=\"M11 8h6\" />\n  <path d=\"M11 16h6\" />"),
    SERVER_BOLT(
        "server-bolt",
        "<path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2\" />\n  <path d=\"M15 20h-9a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3h12\" />\n  <path d=\"M7 8v.01\" />\n  <path d=\"M7 16v.01\" />\n  <path d=\"M20 15l-2 3h3l-2 3\" />"),
    SERVER_COG(
        "server-cog",
        "<path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-2\" />\n  <path d=\"M12 20h-6a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3h10.5\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M18 14.5v1.5\" />\n  <path d=\"M18 20v1.5\" />\n  <path d=\"M21.032 16.25l-1.299 .75\" />\n  <path d=\"M16.27 19l-1.3 .75\" />\n  <path d=\"M14.97 16.25l1.3 .75\" />\n  <path d=\"M19.733 19l1.3 .75\" />\n  <path d=\"M7 8v.01\" />\n  <path d=\"M7 16v.01\" />"),
    SERVER_OFF(
        "server-off",
        "<path d=\"M12 12h-6a3 3 0 0 1 -3 -3v-2c0 -1.083 .574 -2.033 1.435 -2.56m3.565 -.44h10a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-2\" />\n  <path d=\"M16 12h2a3 3 0 0 1 3 3v2m-1.448 2.568a2.986 2.986 0 0 1 -1.552 .432h-12a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3h6\" />\n  <path d=\"M7 8v.01\" />\n  <path d=\"M7 16v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    SERVER_SPARK(
        "server-spark",
        "<path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />\n  <path d=\"M3 7a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v2a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3l0 -2\" />\n  <path d=\"M12 20h-6a3 3 0 0 1 -3 -3v-2a3 3 0 0 1 3 -3h10.5\" />\n  <path d=\"M7 8v.01\" />\n  <path d=\"M7 16v.01\" />"),
    SHREDDER(
        "shredder",
        "<path d=\"M4 11a1 1 0 0 1 1 -1h14a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-14a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M17 10v-4a2 2 0 0 0 -2 -2h-6a2 2 0 0 0 -2 2v4m5 5v5m4 -5v2m-8 -2v3\" />"),
    SIGNAL_2G(
        "signal-2g",
        "<path d=\"M19 8h-3a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h3v-4h-1\" />\n  <path d=\"M5 8h4a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-3a1 1 0 0 0 -1 1v2a1 1 0 0 0 1 1h4\" />"),
    SIGNAL_3G(
        "signal-3g",
        "<path d=\"M17 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M6 8h2.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-1.5h1.5a1.5 1.5 0 0 1 1.5 1.5v1a1.5 1.5 0 0 1 -1.5 1.5h-2.5\" />"),
    SIGNAL_4G(
        "signal-4g",
        "<path d=\"M6 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M10 8v8\" />\n  <path d=\"M17 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />"),
    SIGNAL_4G_PLUS(
        "signal-4g-plus",
        "<path d=\"M17 12h4\" />\n  <path d=\"M3 8v3a1 1 0 0 0 1 1h3\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M19 10v4\" />\n  <path d=\"M14 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />"),
    SIGNAL_5G(
        "signal-5g",
        "<path d=\"M18 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M6 15a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-3v-4h4\" />"),
    SIGNAL_6G(
        "signal-6g",
        "<path d=\"M18 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />\n  <path d=\"M10 9a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-2a1 1 0 0 0 -1 -1h-3\" />"),
    SIGNAL_E("signal-e", "<path d=\"M14 8h-4v8h4\" />\n  <path d=\"M10 12h2.5\" />"),
    SIGNAL_G("signal-g", "<path d=\"M14 8h-2a2 2 0 0 0 -2 2v4a2 2 0 0 0 2 2h2v-4h-1\" />"),
    SIGNAL_H(
        "signal-h",
        "<path d=\"M10 16v-8\" />\n  <path d=\"M14 8v8\" />\n  <path d=\"M10 12h4\" />"),
    SIGNAL_H_PLUS(
        "signal-h-plus",
        "<path d=\"M7 16v-8\" />\n  <path d=\"M11 8v8\" />\n  <path d=\"M7 12h4\" />\n  <path d=\"M14 12h4\" />\n  <path d=\"M16 10v4\" />"),
    SIGNAL_LTE(
        "signal-lte",
        "<path d=\"M21 8h-4v8h4\" />\n  <path d=\"M17 12h2.5\" />\n  <path d=\"M4 8v8h4\" />\n  <path d=\"M10 8h4\" />\n  <path d=\"M12 8v8\" />"),
    VIEWPORT_NARROW(
        "viewport-narrow",
        "<path d=\"M3 12h7l-3 -3\" />\n  <path d=\"M7 15l3 -3\" />\n  <path d=\"M21 12h-7l3 -3\" />\n  <path d=\"M17 15l-3 -3\" />\n  <path d=\"M9 6v-1a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v1\" />\n  <path d=\"M9 18v1a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-1\" />"),
    VIEWPORT_WIDE(
        "viewport-wide",
        "<path d=\"M10 12h-7l3 -3\" />\n  <path d=\"M6 15l-3 -3\" />\n  <path d=\"M14 12h7l-3 -3\" />\n  <path d=\"M18 15l3 -3\" />\n  <path d=\"M3 6v-1a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v1\" />\n  <path d=\"M3 18v1a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-1\" />"),
    VINYL(
        "vinyl",
        "<path d=\"M16 3.937a9 9 0 1 0 5 8.063\" />\n  <path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M19 4a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M20 4l-3.5 10l-2.5 2\" />"),
    WASH_MACHINE(
        "wash-machine",
        "<path d=\"M5 5a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M8 14a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M8 6h.01\" />\n  <path d=\"M11 6h.01\" />\n  <path d=\"M14 6h2\" />\n  <path d=\"M8 14c1.333 -.667 2.667 -.667 4 0c1.333 .667 2.667 .667 4 0\" />"),
    WIFI(
        "wifi",
        "<path d=\"M12 18l.01 0\" />\n  <path d=\"M9.172 15.172a4 4 0 0 1 5.656 0\" />\n  <path d=\"M6.343 12.343a8 8 0 0 1 11.314 0\" />\n  <path d=\"M3.515 9.515c4.686 -4.687 12.284 -4.687 17 0\" />"),
    WIFI_0("wifi-0", "<path d=\"M12 18l.01 0\" />"),
    WIFI_1(
        "wifi-1", "<path d=\"M12 18l.01 0\" />\n  <path d=\"M9.172 15.172a4 4 0 0 1 5.656 0\" />"),
    WIFI_2(
        "wifi-2",
        "<path d=\"M12 18l.01 0\" />\n  <path d=\"M9.172 15.172a4 4 0 0 1 5.656 0\" />\n  <path d=\"M6.343 12.343a8 8 0 0 1 11.314 0\" />"),
    WIFI_OFF(
        "wifi-off",
        "<path d=\"M12 18l.01 0\" />\n  <path d=\"M9.172 15.172a4 4 0 0 1 5.656 0\" />\n  <path d=\"M6.343 12.343a7.963 7.963 0 0 1 3.864 -2.14m4.163 .155a7.965 7.965 0 0 1 3.287 2\" />\n  <path d=\"M3.515 9.515a12 12 0 0 1 3.544 -2.455m3.101 -.92a12 12 0 0 1 10.325 3.374\" />\n  <path d=\"M3 3l18 18\" />"),
    XBOX_A(
        "xbox-a",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M15 16l-3 -8l-3 8\" />\n  <path d=\"M14 14h-4\" />"),
    XBOX_B(
        "xbox-b",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M13 12a2 2 0 1 1 0 4h-3v-4\" />\n  <path d=\"M13 12h-3\" />\n  <path d=\"M13 12a2 2 0 1 0 0 -4h-3v4\" />"),
    XBOX_X(
        "xbox-x",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M9 8l6 8\" />\n  <path d=\"M15 8l-6 8\" />"),
    XBOX_Y(
        "xbox-y",
        "<path d=\"M12 21a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9a9 9 0 0 0 9 9\" />\n  <path d=\"M9 8l3 4\" />\n  <path d=\"M15 8l-2.988 3.984l-.012 4.016\" />");

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
    BATTERY(
        "battery",
        "<path d=\"M17 6a3 3 0 0 1 2.995 2.824l.005 .176v.086l.052 .019a1.5 1.5 0 0 1 .941 1.25l.007 .145v3a1.5 1.5 0 0 1 -.948 1.395l-.052 .018v.087a3 3 0 0 1 -2.824 2.995l-.176 .005h-11a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h11z\" />"),
    BATTERY_1(
        "battery-1",
        "<path d=\"M17 6a3 3 0 0 1 2.995 2.824l.005 .176v.086l.052 .019a1.5 1.5 0 0 1 .941 1.25l.007 .145v3a1.5 1.5 0 0 1 -.948 1.395l-.052 .018v.087a3 3 0 0 1 -2.824 2.995l-.176 .005h-11a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h11zm-10 3a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BATTERY_2(
        "battery-2",
        "<path d=\"M17 6a3 3 0 0 1 2.995 2.824l.005 .176v.086l.052 .019a1.5 1.5 0 0 1 .941 1.25l.007 .145v3a1.5 1.5 0 0 1 -.948 1.395l-.052 .018v.087a3 3 0 0 1 -2.824 2.995l-.176 .005h-11a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h11zm-10 3a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BATTERY_3(
        "battery-3",
        "<path d=\"M17 6a3 3 0 0 1 2.995 2.824l.005 .176v.086l.052 .019a1.5 1.5 0 0 1 .941 1.25l.007 .145v3a1.5 1.5 0 0 1 -.948 1.395l-.052 .018v.087a3 3 0 0 1 -2.824 2.995l-.176 .005h-11a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h11zm-10 3a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BATTERY_4(
        "battery-4",
        "<path d=\"M17 6a3 3 0 0 1 2.995 2.824l.005 .176v.086l.052 .019a1.5 1.5 0 0 1 .941 1.25l.007 .145v3a1.5 1.5 0 0 1 -.948 1.395l-.052 .018v.087a3 3 0 0 1 -2.824 2.995l-.176 .005h-11a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h11zm-10 3a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    BATTERY_VERTICAL(
        "battery-vertical",
        "<path d=\"M13.5 3a1.5 1.5 0 0 1 1.395 .948l.018 .052h.087a3 3 0 0 1 2.995 2.824l.005 .176v11a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-11a3 3 0 0 1 3 -3h.086l.019 -.052a1.5 1.5 0 0 1 1.25 -.941l.145 -.007z\" />"),
    BATTERY_VERTICAL_1(
        "battery-vertical-1",
        "<path d=\"M13.5 3a1.5 1.5 0 0 1 1.395 .948l.018 .052h.087a3 3 0 0 1 2.995 2.824l.005 .176v11a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-11a3 3 0 0 1 3 -3h.086l.019 -.052a1.5 1.5 0 0 1 1.25 -.941l.145 -.007zm.5 13h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    BATTERY_VERTICAL_2(
        "battery-vertical-2",
        "<path d=\"M13.5 3a1.5 1.5 0 0 1 1.395 .948l.018 .052h.087a3 3 0 0 1 2.995 2.824l.005 .176v11a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-11a3 3 0 0 1 3 -3h.086l.019 -.052a1.5 1.5 0 0 1 1.25 -.941l.145 -.007zm.5 13h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    BATTERY_VERTICAL_3(
        "battery-vertical-3",
        "<path d=\"M13.5 3a1.5 1.5 0 0 1 1.395 .948l.018 .052h.087a3 3 0 0 1 2.995 2.824l.005 .176v11a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-11a3 3 0 0 1 3 -3h.086l.019 -.052a1.5 1.5 0 0 1 1.25 -.941l.145 -.007zm.5 13h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    BATTERY_VERTICAL_4(
        "battery-vertical-4",
        "<path d=\"M13.5 3a1.5 1.5 0 0 1 1.395 .948l.018 .052h.087a3 3 0 0 1 2.995 2.824l.005 .176v11a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-11a3 3 0 0 1 3 -3h.086l.019 -.052a1.5 1.5 0 0 1 1.25 -.941l.145 -.007zm.5 13h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m0 -3h-4a1 1 0 1 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    BLENDER(
        "blender",
        "<path d=\"M15 14c.899 0 1.728 .296 2.396 .797l-.12 -.086q .101 .069 .196 .144l-.076 -.058q .07 .053 .14 .109l-.064 -.05q .072 .055 .14 .115l-.077 -.065a4 4 0 0 1 .565 .566l-.065 -.078q .061 .072 .12 .147l-.055 -.07q .057 .071 .111 .144l-.056 -.074q .066 .084 .127 .172l-.07 -.098q .058 .078 .112 .16l-.042 -.062q .054 .078 .104 .157l-.062 -.096q .06 .09 .117 .185l-.055 -.089l.09 .15l-.035 -.061a4 4 0 0 1 .338 .727l-.055 -.15q .039 .1 .073 .201l-.018 -.051q .033 .093 .06 .188l-.042 -.137q .033 .1 .061 .204l-.019 -.067q .027 .091 .05 .184l-.03 -.117q .03 .114 .055 .23l-.025 -.113q .026 .107 .045 .215l-.02 -.101q .021 .1 .037 .201l-.017 -.1q .018 .095 .03 .19l-.013 -.09a4 4 0 0 1 .026 .196l.017 .205l.006 .226v2a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-2q 0 -.273 .036 -.537l-.013 .105a4 4 0 0 1 .026 -.194l-.013 .09a4 4 0 0 1 .03 -.191l-.017 .1q .015 -.1 .037 -.2l-.02 .1q .02 -.108 .046 -.215l-.026 .114q .024 -.117 .056 -.23l-.03 .116a4 4 0 0 1 .049 -.184l-.02 .067q .03 -.104 .062 -.204l-.042 .137q .027 -.096 .06 -.188l-.018 .051a4 4 0 0 1 .32 -.717l-.064 .117q .048 -.09 .1 -.178l-.035 .06l.09 -.15l-.055 .09q .055 -.094 .117 -.185l-.062 .096q .05 -.08 .104 -.157l-.042 .061q .054 -.08 .113 -.16l-.071 .1q .06 -.09 .127 -.173l-.056 .074q .054 -.073 .111 -.143l-.055 .069a4 4 0 0 1 .542 -.57l-.072 .064q .073 -.066 .15 -.129l-.078 .065a4 4 0 0 1 .14 -.116l-.062 .051q .068 -.056 .139 -.11l-.076 .06q .096 -.076 .195 -.145l-.12 .086q .07 -.053 .142 -.101l-.022 .015q .072 -.05 .145 -.096a4 4 0 0 1 2.132 -.615zm-2 3a1 1 0 0 0 -.993 .883l-.007 .127a1 1 0 0 0 1.993 .117l.007 -.127a1 1 0 0 0 -1 -1m1 -15a1 1 0 0 1 1 .999l1.802 .001a2 2 0 0 1 1.968 2.358l-1.49 8.191a5 5 0 0 0 -2.28 -.549h-4c-.822 0 -1.597 .198 -2.28 .55l-.464 -2.551l-2.256 .001a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2l5 -.001l.007 -.116a1 1 0 0 1 .993 -.883zm-6.835 2.999l-1.165 .001v4l1.893 -.001z\" />"),
    CALCULATOR(
        "calculator",
        "<path d=\"M18 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-10 15a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm-8 -4a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm-1 -7h-6a2 2 0 0 0 -2 2v1a2 2 0 0 0 2 2h6a2 2 0 0 0 2 -2v-1a2 2 0 0 0 -2 -2z\" />"),
    CARDBOARDS(
        "cardboards",
        "<path d=\"M19 5a3 3 0 0 1 3 3v8.5a3.5 3.5 0 0 1 -3.5 3.5h-1.062a4 4 0 0 1 -3.118 -1.504l-1.54 -1.92a1 1 0 0 0 -1.56 0l-1.538 1.917a4 4 0 0 1 -3.122 1.507h-1.06a3.5 3.5 0 0 1 -3.5 -3.5v-8.5a3 3 0 0 1 3 -3zm-11 5a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m8 0a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2\" />"),
    DEVICE_CCTV(
        "device-cctv",
        "<path d=\"M20 8v6a8 8 0 1 1 -16 0v-6zm-8 2a4 4 0 0 0 -3.996 3.826l-.004 .174a4 4 0 1 0 4 -4m.01 3a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm-10.01 -8v-1a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-16a2 2 0 0 1 -2 -2\" />"),
    DEVICE_DESKTOP(
        "device-desktop",
        "<path d=\"M7 21a1 1 0 0 1 0 -2h1v-2h-4a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-4v2h1a1 1 0 0 1 0 2zm7 -4h-4v2h4z\" />"),
    DEVICE_FLOPPY(
        "device-floppy",
        "<path d=\"M16 3a1 1 0 0 1 .707 .293l4 4a1 1 0 0 1 .293 .707v10a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h1v4a1 1 0 0 0 .883 .993l.117 .007h6a1 1 0 0 0 1 -1v-4zm-4 8a2.995 2.995 0 0 0 -2.995 2.898a1 1 0 0 0 -.005 .102a3 3 0 1 0 3 -3m1 -8v3h-4v-3z\" />"),
    DEVICE_GAMEPAD(
        "device-gamepad",
        "<path d=\"M20 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-16a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3zm-12 4l-.117 .007a1 1 0 0 0 -.883 .993v1h-1a1 1 0 0 0 -1 1l.007 .117a1 1 0 0 0 .993 .883h1v1a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1h1a1 1 0 0 0 1 -1l-.007 -.117a1 1 0 0 0 -.993 -.883h-1v-1a1 1 0 0 0 -1 -1m10 3a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m-3 -2a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    DEVICE_GAMEPAD_2(
        "device-gamepad-2",
        "<path d=\"M15.5 4a6 6 0 0 1 5.945 5.187l1.532 7.883a3.3 3.3 0 0 1 -5.632 2.903l-3.776 -3.974l-3.14 .001l-3.719 3.916a3.3 3.3 0 0 1 -5.629 -2.92l1.634 -8.173a6 6 0 0 1 5.885 -4.823zm-7.5 3a1 1 0 0 0 -1 1v1h-1a1 1 0 1 0 0 2h1v1a1 1 0 0 0 2 0v-1h1a1 1 0 0 0 0 -2h-1v-1a1 1 0 0 0 -1 -1m10 2h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    DEVICE_GAMEPAD_3(
        "device-gamepad-3",
        "<path d=\"M12.707 14.293l3 3a1 1 0 0 1 .293 .707v2a2 2 0 0 1 -2 2h-4a2 2 0 0 1 -2 -2v-2a1 1 0 0 1 .293 -.707l3 -3a1 1 0 0 1 1.414 0m-6.707 -6.293a1 1 0 0 1 .707 .293l3 3a1 1 0 0 1 0 1.414l-3 3a1 1 0 0 1 -.707 .293h-2a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2zm14 0a2 2 0 0 1 2 2v4a2 2 0 0 1 -2 2h-2a1 1 0 0 1 -.707 -.293l-3 -3a1 1 0 0 1 0 -1.414l3 -3a1 1 0 0 1 .707 -.293zm-6 -6a2 2 0 0 1 2 2v2a1 1 0 0 1 -.293 .707l-3 3a1 1 0 0 1 -1.414 0l-3 -3a1 1 0 0 1 -.293 -.707v-2a2 2 0 0 1 2 -2z\" />"),
    DEVICE_HEART_MONITOR(
        "device-heart-monitor",
        "<path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v12a3 3 0 0 1 -2.824 2.995l-.176 .005h-12a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-12a3 3 0 0 1 2.824 -2.995l.176 -.005h12zm-4 13a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm3 0a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm-6 -6.764l-.106 .211a1 1 0 0 1 -.77 .545l-.124 .008l-5 -.001v3.001h14v-3.001l-4.382 .001l-.724 1.447a1 1 0 0 1 -1.725 .11l-.063 -.11l-1.106 -2.211zm7 -4.236h-12a1 1 0 0 0 -.993 .883l-.007 .117v1.999l4.381 .001l.725 -1.447a1 1 0 0 1 1.725 -.11l.063 .11l1.106 2.21l.106 -.21a1 1 0 0 1 .77 -.545l.124 -.008l5 -.001v-1.999a1 1 0 0 0 -.883 -.993l-.117 -.007z\" />"),
    DEVICE_IMAC(
        "device-imac",
        "<path d=\"M8 22a1 1 0 0 1 0 -2h.616l.25 -2h-4.866a2 2 0 0 1 -2 -2v-12a2 2 0 0 1 2 -2h16a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-4.867l.25 2h.617a1 1 0 0 1 0 2zm5.116 -4h-2.233l-.25 2h2.733z\" />"),
    DEVICE_IPAD(
        "device-ipad",
        "<path d=\"M18 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-3 16h-6a1 1 0 0 0 0 2h6a1 1 0 0 0 0 -2\" />"),
    DEVICE_MOBILE(
        "device-mobile",
        "<path d=\"M16 2a3 3 0 0 1 2.995 2.824l.005 .176v14a3 3 0 0 1 -2.824 2.995l-.176 .005h-8a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-14a3 3 0 0 1 2.824 -2.995l.176 -.005h8zm-4 14a1 1 0 0 0 -.993 .883l-.007 .117l.007 .127a1 1 0 0 0 1.986 0l.007 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883zm1 -12h-2l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h2l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    DEVICE_REMOTE(
        "device-remote",
        "<path d=\"M15 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3h2v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-1zm-5 15a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883m4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883m-4 -3a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883m4 0a1 1 0 0 0 -1 1l.007 .127a1 1 0 0 0 1.993 -.117l-.007 -.127a1 1 0 0 0 -.993 -.883m-2 -7a3 3 0 0 0 -2.995 2.824l-.005 .176a3 3 0 1 0 3 -3\" />"),
    DEVICE_SPEAKER(
        "device-speaker",
        "<path d=\"M17 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm-5 9a4 4 0 0 0 -3.995 3.8l-.005 .2a4 4 0 1 0 4 -4m0 -5a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    DEVICE_TABLET(
        "device-tablet",
        "<path d=\"M18 2a2 2 0 0 1 1.995 1.85l.005 .15v16a2 2 0 0 1 -1.85 1.995l-.15 .005h-12a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-16a2 2 0 0 1 1.85 -1.995l.15 -.005h12zm-6 13a2 2 0 0 0 -1.977 1.697l-.018 .154l-.005 .149l.005 .15a2 2 0 1 0 1.995 -2.15z\" />"),
    DEVICE_TV(
        "device-tv",
        "<path d=\"M8.707 2.293l3.293 3.292l3.293 -3.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-2.293 2.293h4.586a3 3 0 0 1 3 3v9a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3h4.585l-2.292 -2.293a1 1 0 0 1 1.414 -1.414\" />"),
    DEVICE_TV_OLD(
        "device-tv-old",
        "<path d=\"M8.707 2.293l3.293 3.292l3.293 -3.292a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-2.293 2.293h4.586a3 3 0 0 1 3 3v9a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-9a3 3 0 0 1 3 -3h4.585l-2.292 -2.293a1 1 0 0 1 1.414 -1.414m10.293 5.707h-2a1 1 0 0 0 -1 1v9a1 1 0 0 0 1 1h2a1 1 0 0 0 1 -1v-9a1 1 0 0 0 -1 -1\" />\n  <path d=\"M18 14a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1\" />\n  <path d=\"M18 11a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1\" />"),
    DEVICE_USB(
        "device-usb",
        "<path d=\"M15 2a1 1 0 0 1 1 1v4h1a1 1 0 0 1 1 1v8a6 6 0 1 1 -12 0v-8a1 1 0 0 1 1 -1h1v-4a1 1 0 0 1 1 -1zm-1 2h-4v3h4z\" />"),
    DEVICE_VISION_PRO(
        "device-vision-pro",
        "<path d=\"M12 6q 1.74 0 3.342 .106q 1.619 .107 2.973 .448q 1.388 .345 2.436 1.05a4.9 4.9 0 0 1 1.665 1.916c.397 .801 .584 1.769 .584 2.91c0 1.156 -.222 2.208 -.673 3.14c-.45 .934 -1.073 1.685 -1.868 2.236a4.7 4.7 0 0 1 -2.73 .839q -.932 .001 -1.703 -.263a7 7 0 0 1 -1.374 -.644a20 20 0 0 1 -1.107 -.736a8 8 0 0 0 -.901 -.567a1.4 1.4 0 0 0 -.643 -.174c-.209 0 -.426 .057 -.658 .18q -.42 .226 -.893 .564a20 20 0 0 1 -1.105 .733a6.8 6.8 0 0 1 -1.366 .642a5.2 5.2 0 0 1 -1.688 .264a4.7 4.7 0 0 1 -2.75 -.838c-.794 -.55 -1.418 -1.302 -1.868 -2.234q -.675 -1.407 -.673 -3.14c-.005 -1.135 .182 -2.105 .577 -2.9a4.9 4.9 0 0 1 1.673 -1.926c.699 -.47 1.511 -.816 2.442 -1.049a17 17 0 0 1 2.968 -.447q 1.599 -.11 3.34 -.11\" />"),
    DEVICE_WATCH(
        "device-watch",
        "<path d=\"M15 2a1 1 0 0 1 1 1v2.126c1.726 .445 3 2.01 3 3.874v6a4 4 0 0 1 -3 3.874v2.126a1 1 0 0 1 -1 1h-6a1 1 0 0 1 -1 -1v-2.126a4 4 0 0 1 -3 -3.874v-6a4 4 0 0 1 3 -3.874v-2.126a1 1 0 0 1 1 -1zm-1 17h-4v1h4zm0 -15h-4v1h4z\" />"),
    DIALPAD(
        "dialpad",
        "<path d=\"M6 2h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M20 2h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M13 2h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M6 9h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M20 9h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M13 9h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M13 16h-2a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />"),
    DISC(
        "disc",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m0 7.66a1 1 0 0 0 -1 1a4 4 0 0 1 -4 4a1 1 0 0 0 0 2a6 6 0 0 0 6 -6a1 1 0 0 0 -1 -1m-5 -1a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m0 -4a6 6 0 0 0 -6 6a1 1 0 0 0 2 0a4 4 0 0 1 4 -4a1 1 0 0 0 0 -2\" />"),
    DUAL_SCREEN(
        "dual-screen",
        "<path d=\"M19 3a1 1 0 0 1 1 1v15a1 1 0 0 1 -1 1h-5v2a1 1 0 0 1 -1.351 .936l-8 -3a1 1 0 0 1 -.649 -.936v-15a1 1 0 0 1 .212 -.616l.068 -.079l.078 -.072l.066 -.05l.092 -.058l.065 -.033l.1 -.04l.099 -.028l.046 -.01l.108 -.013l.066 -.001zm-5.649 3.064a1 1 0 0 1 .649 .936v11h4v-13h-7.486z\" />"),
    KEYBOARD(
        "keyboard",
        "<path d=\"M20 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-16a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3zm-14 8a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m12 0a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m-7.998 0a1 1 0 0 0 -.004 2l4 .01a1 1 0 0 0 .005 -2zm-4.002 -4a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m4 0a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m4 0a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1m4 0a1 1 0 0 0 -1 1v.01a1 1 0 0 0 2 0v-.01a1 1 0 0 0 -1 -1\" />"),
    MOUSE(
        "mouse",
        "<path d=\"M14 2a5 5 0 0 1 5 5v10a5 5 0 0 1 -5 5h-4a5 5 0 0 1 -5 -5v-10a5 5 0 0 1 5 -5zm-2 4a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 1.993 -.117v-4l-.007 -.117a1 1 0 0 0 -.993 -.883z\" />"),
    PHONE(
        "phone",
        "<path d=\"M9 3a1 1 0 0 1 .877 .519l.051 .11l2 5a1 1 0 0 1 -.313 1.16l-.1 .068l-1.674 1.004l.063 .103a10 10 0 0 0 3.132 3.132l.102 .062l1.005 -1.672a1 1 0 0 1 1.113 -.453l.115 .039l5 2a1 1 0 0 1 .622 .807l.007 .121v4c0 1.657 -1.343 3 -3.06 2.998c-8.579 -.521 -15.418 -7.36 -15.94 -15.998a3 3 0 0 1 2.824 -2.995l.176 -.005h4z\" />"),
    PHONE_CALL(
        "phone-call",
        "<path d=\"M9.928 3.629l2 5a1 1 0 0 1 -.414 1.228l-1.67 1.003a9.9 9.9 0 0 0 3.296 3.297l1.003 -1.671a1 1 0 0 1 1.228 -.414l5 2a1 1 0 0 1 .629 .928v4c0 1.657 -1.343 3 -3.06 2.998c-8.579 -.521 -15.418 -7.36 -15.94 -15.998a3 3 0 0 1 3 -3h4a1 1 0 0 1 .928 .629\" />\n  <path d=\"M18 9a1 1 0 0 1 -2 0a1 1 0 0 0 -1 -1a1 1 0 0 1 0 -2a3 3 0 0 1 3 3\" />\n  <path d=\"M22 9a1 1 0 0 1 -2 0a5 5 0 0 0 -5 -5a1 1 0 0 1 0 -2a7 7 0 0 1 7 7\" />"),
    PHONE_CALLING(
        "phone-calling",
        "<path d=\"M9.928 3.629l2 5a1 1 0 0 1 -.414 1.228l-1.67 1.003a9.9 9.9 0 0 0 3.296 3.297l1.003 -1.671a1 1 0 0 1 1.228 -.414l5 2a1 1 0 0 1 .629 .928v4c0 1.657 -1.343 3 -3.06 2.998c-8.579 -.521 -15.418 -7.36 -15.94 -15.998a3 3 0 0 1 3 -3h4a1 1 0 0 1 .928 .629\" />\n  <path d=\"M16 7v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 2 0\" />\n  <path d=\"M19 7v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 2 0\" />\n  <path d=\"M22 7v.01a1 1 0 0 1 -2 0v-.01a1 1 0 0 1 2 0\" />"),
    PHONE_CHECK(
        "phone-check",
        "<path d=\"M9.928 3.629l2 5a1 1 0 0 1 -.414 1.228l-1.67 1.003a9.9 9.9 0 0 0 3.296 3.297l1.003 -1.671a1 1 0 0 1 1.228 -.414l5 2a1 1 0 0 1 .629 .928v4c0 1.657 -1.343 3 -3.06 2.998c-8.579 -.521 -15.418 -7.36 -15.94 -15.998a3 3 0 0 1 3 -3h4a1 1 0 0 1 .928 .629\" />\n  <path d=\"M21.707 3.293a1 1 0 0 1 0 1.414l-4 4a1 1 0 0 1 -1.414 0l-2 -2a1 1 0 1 1 1.414 -1.414l1.293 1.293l3.293 -3.293a1 1 0 0 1 1.414 0\" />"),
    PHONE_X(
        "phone-x",
        "<path d=\"M9.928 3.629l2 5a1 1 0 0 1 -.414 1.228l-1.67 1.003a9.9 9.9 0 0 0 3.296 3.297l1.003 -1.671a1 1 0 0 1 1.228 -.414l5 2a1 1 0 0 1 .629 .928v4c0 1.657 -1.343 3 -3.06 2.998c-8.579 -.521 -15.418 -7.36 -15.94 -15.998a3 3 0 0 1 3 -3h4a1 1 0 0 1 .928 .629\" />\n  <path d=\"M20.707 3.293a1 1 0 0 1 0 1.414l-1.293 1.293l1.293 1.293a1 1 0 1 1 -1.414 1.414l-1.293 -1.293l-1.293 1.293a1 1 0 0 1 -1.414 -1.414l1.293 -1.293l-1.293 -1.293a1 1 0 1 1 1.414 -1.414l1.293 1.293l1.293 -1.293a1 1 0 0 1 1.414 0\" />"),
    XBOX_A(
        "xbox-a",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10m.936 5.649c-.324 -.865 -1.548 -.865 -1.872 0l-3 8a1 1 0 0 0 .585 1.287l.111 .035a1 1 0 0 0 1.176 -.62l.507 -1.351h3.114l.507 1.351a1 1 0 1 0 1.872 -.702zm-.936 3.199l.807 2.152h-1.614z\" />"),
    XBOX_B(
        "xbox-b",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10m1 5h-3a1 1 0 0 0 -1 1v8a1 1 0 0 0 1 1h3a3 3 0 0 0 2.235 -5a3 3 0 0 0 -2.235 -5m0 6a1 1 0 0 1 1 1l-.007 .117a1 1 0 0 1 -.993 .883h-2v-2zm0 -4a1 1 0 0 1 0 2h-2v-2z\" />"),
    XBOX_X(
        "xbox-x",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10m3.6 5.2a1 1 0 0 0 -1.4 .2l-2.2 2.933l-2.2 -2.933a1 1 0 1 0 -1.6 1.2l2.55 3.4l-2.55 3.4a1 1 0 1 0 1.6 1.2l2.2 -2.933l2.2 2.933a1 1 0 0 0 1.6 -1.2l-2.55 -3.4l2.55 -3.4a1 1 0 0 0 -.2 -1.4\" />"),
    XBOX_Y(
        "xbox-y",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10s-10 -4.477 -10 -10s4.477 -10 10 -10m3.6 5.2a1 1 0 0 0 -1.4 .2l-2.2 2.933l-2.2 -2.933a1 1 0 1 0 -1.6 1.2l2.81 3.748l-.01 3.649a1 1 0 0 0 .997 1.003l.117 -.006a1 1 0 0 0 .886 -.991l.01 -3.683l2.79 -3.72a1 1 0 0 0 -.2 -1.4\" />");

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

  default TablerIcon access_point() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ACCESS_POINT);
  }

  default TablerIcon access_point_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ACCESS_POINT_OFF);
  }

  default TablerIcon air_conditioning() {
    return TablerIcon.create(TablerDevices.OutlineIcon.AIR_CONDITIONING);
  }

  default TablerIcon air_conditioning_disabled() {
    return TablerIcon.create(TablerDevices.OutlineIcon.AIR_CONDITIONING_DISABLED);
  }

  default TablerIcon airpods_l() {
    return TablerIcon.create(TablerDevices.OutlineIcon.AIRPODS_L);
  }

  default TablerIcon airpods_r() {
    return TablerIcon.create(TablerDevices.OutlineIcon.AIRPODS_R);
  }

  default TablerIcon alarm_smoke() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ALARM_SMOKE);
  }

  default TablerIcon antenna() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA);
  }

  default TablerIcon antenna_bars_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_1);
  }

  default TablerIcon antenna_bars_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_2);
  }

  default TablerIcon antenna_bars_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_3);
  }

  default TablerIcon antenna_bars_4() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_4);
  }

  default TablerIcon antenna_bars_5() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_5);
  }

  default TablerIcon antenna_bars_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_BARS_OFF);
  }

  default TablerIcon antenna_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ANTENNA_OFF);
  }

  default TablerIcon battery() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY);
  }

  default TablerIcon battery_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_1);
  }

  default TablerIcon battery_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_2);
  }

  default TablerIcon battery_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_3);
  }

  default TablerIcon battery_4() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_4);
  }

  default TablerIcon battery_charging() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_CHARGING);
  }

  default TablerIcon battery_charging_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_CHARGING_2);
  }

  default TablerIcon battery_eco() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_ECO);
  }

  default TablerIcon battery_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_EXCLAMATION);
  }

  default TablerIcon battery_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_OFF);
  }

  default TablerIcon battery_spark() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_SPARK);
  }

  default TablerIcon battery_vertical() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL);
  }

  default TablerIcon battery_vertical_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_1);
  }

  default TablerIcon battery_vertical_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_2);
  }

  default TablerIcon battery_vertical_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_3);
  }

  default TablerIcon battery_vertical_4() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_4);
  }

  default TablerIcon battery_vertical_charging() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_CHARGING);
  }

  default TablerIcon battery_vertical_charging_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_CHARGING_2);
  }

  default TablerIcon battery_vertical_eco() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_ECO);
  }

  default TablerIcon battery_vertical_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_EXCLAMATION);
  }

  default TablerIcon battery_vertical_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BATTERY_VERTICAL_OFF);
  }

  default TablerIcon blender() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BLENDER);
  }

  default TablerIcon bluetooth() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BLUETOOTH);
  }

  default TablerIcon bluetooth_connected() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BLUETOOTH_CONNECTED);
  }

  default TablerIcon bluetooth_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BLUETOOTH_OFF);
  }

  default TablerIcon bluetooth_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BLUETOOTH_X);
  }

  default TablerIcon broadcast() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROADCAST);
  }

  default TablerIcon broadcast_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROADCAST_OFF);
  }

  default TablerIcon browser() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER);
  }

  default TablerIcon browser_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_CHECK);
  }

  default TablerIcon browser_maximize() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_MAXIMIZE);
  }

  default TablerIcon browser_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_MINUS);
  }

  default TablerIcon browser_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_OFF);
  }

  default TablerIcon browser_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_PLUS);
  }

  default TablerIcon browser_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_SHARE);
  }

  default TablerIcon browser_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.BROWSER_X);
  }

  default TablerIcon calculator() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CALCULATOR);
  }

  default TablerIcon calculator_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CALCULATOR_OFF);
  }

  default TablerIcon cardboards() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CARDBOARDS);
  }

  default TablerIcon cardboards_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CARDBOARDS_OFF);
  }

  default TablerIcon cell_signal_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_1);
  }

  default TablerIcon cell_signal_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_2);
  }

  default TablerIcon cell_signal_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_3);
  }

  default TablerIcon cell_signal_4() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_4);
  }

  default TablerIcon cell_signal_5() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_5);
  }

  default TablerIcon cell_signal_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CELL_SIGNAL_OFF);
  }

  default TablerIcon cpu() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CPU);
  }

  default TablerIcon cpu_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CPU_2);
  }

  default TablerIcon cpu_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.CPU_OFF);
  }

  default TablerIcon device_3d_camera() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_3D_CAMERA);
  }

  default TablerIcon device_3d_lens() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_3D_LENS);
  }

  default TablerIcon device_airpods() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_AIRPODS);
  }

  default TablerIcon device_airpods_case() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_AIRPODS_CASE);
  }

  default TablerIcon device_airtag() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_AIRTAG);
  }

  default TablerIcon device_analytics() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_ANALYTICS);
  }

  default TablerIcon device_audio_tape() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_AUDIO_TAPE);
  }

  default TablerIcon device_camera_phone() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_CAMERA_PHONE);
  }

  default TablerIcon device_cctv() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_CCTV);
  }

  default TablerIcon device_cctv_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_CCTV_OFF);
  }

  default TablerIcon device_computer_camera() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_COMPUTER_CAMERA);
  }

  default TablerIcon device_computer_camera_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_COMPUTER_CAMERA_2);
  }

  default TablerIcon device_computer_camera_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_COMPUTER_CAMERA_OFF);
  }

  default TablerIcon device_desktop() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP);
  }

  default TablerIcon device_desktop_analytics() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_ANALYTICS);
  }

  default TablerIcon device_desktop_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_BOLT);
  }

  default TablerIcon device_desktop_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_CANCEL);
  }

  default TablerIcon device_desktop_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_CHECK);
  }

  default TablerIcon device_desktop_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_CODE);
  }

  default TablerIcon device_desktop_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_COG);
  }

  default TablerIcon device_desktop_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_DOLLAR);
  }

  default TablerIcon device_desktop_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_DOWN);
  }

  default TablerIcon device_desktop_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_EXCLAMATION);
  }

  default TablerIcon device_desktop_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_HEART);
  }

  default TablerIcon device_desktop_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_MINUS);
  }

  default TablerIcon device_desktop_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_OFF);
  }

  default TablerIcon device_desktop_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_PAUSE);
  }

  default TablerIcon device_desktop_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_PIN);
  }

  default TablerIcon device_desktop_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_PLUS);
  }

  default TablerIcon device_desktop_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_QUESTION);
  }

  default TablerIcon device_desktop_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_SEARCH);
  }

  default TablerIcon device_desktop_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_SHARE);
  }

  default TablerIcon device_desktop_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_STAR);
  }

  default TablerIcon device_desktop_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_UP);
  }

  default TablerIcon device_desktop_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_DESKTOP_X);
  }

  default TablerIcon device_floppy() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_FLOPPY);
  }

  default TablerIcon device_gamepad() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_GAMEPAD);
  }

  default TablerIcon device_gamepad_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_GAMEPAD_2);
  }

  default TablerIcon device_gamepad_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_GAMEPAD_3);
  }

  default TablerIcon device_heart_monitor() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_HEART_MONITOR);
  }

  default TablerIcon device_imac() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC);
  }

  default TablerIcon device_imac_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_BOLT);
  }

  default TablerIcon device_imac_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_CANCEL);
  }

  default TablerIcon device_imac_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_CHECK);
  }

  default TablerIcon device_imac_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_CODE);
  }

  default TablerIcon device_imac_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_COG);
  }

  default TablerIcon device_imac_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_DOLLAR);
  }

  default TablerIcon device_imac_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_DOWN);
  }

  default TablerIcon device_imac_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_EXCLAMATION);
  }

  default TablerIcon device_imac_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_HEART);
  }

  default TablerIcon device_imac_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_MINUS);
  }

  default TablerIcon device_imac_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_OFF);
  }

  default TablerIcon device_imac_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_PAUSE);
  }

  default TablerIcon device_imac_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_PIN);
  }

  default TablerIcon device_imac_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_PLUS);
  }

  default TablerIcon device_imac_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_QUESTION);
  }

  default TablerIcon device_imac_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_SEARCH);
  }

  default TablerIcon device_imac_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_SHARE);
  }

  default TablerIcon device_imac_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_STAR);
  }

  default TablerIcon device_imac_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_UP);
  }

  default TablerIcon device_imac_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IMAC_X);
  }

  default TablerIcon device_ipad() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD);
  }

  default TablerIcon device_ipad_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_BOLT);
  }

  default TablerIcon device_ipad_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_CANCEL);
  }

  default TablerIcon device_ipad_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_CHECK);
  }

  default TablerIcon device_ipad_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_CODE);
  }

  default TablerIcon device_ipad_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_COG);
  }

  default TablerIcon device_ipad_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_DOLLAR);
  }

  default TablerIcon device_ipad_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_DOWN);
  }

  default TablerIcon device_ipad_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_EXCLAMATION);
  }

  default TablerIcon device_ipad_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HEART);
  }

  default TablerIcon device_ipad_horizontal() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL);
  }

  default TablerIcon device_ipad_horizontal_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_BOLT);
  }

  default TablerIcon device_ipad_horizontal_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_CANCEL);
  }

  default TablerIcon device_ipad_horizontal_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_CHECK);
  }

  default TablerIcon device_ipad_horizontal_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_CODE);
  }

  default TablerIcon device_ipad_horizontal_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_COG);
  }

  default TablerIcon device_ipad_horizontal_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_DOLLAR);
  }

  default TablerIcon device_ipad_horizontal_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_DOWN);
  }

  default TablerIcon device_ipad_horizontal_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_EXCLAMATION);
  }

  default TablerIcon device_ipad_horizontal_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_HEART);
  }

  default TablerIcon device_ipad_horizontal_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_MINUS);
  }

  default TablerIcon device_ipad_horizontal_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_OFF);
  }

  default TablerIcon device_ipad_horizontal_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_PAUSE);
  }

  default TablerIcon device_ipad_horizontal_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_PIN);
  }

  default TablerIcon device_ipad_horizontal_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_PLUS);
  }

  default TablerIcon device_ipad_horizontal_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_QUESTION);
  }

  default TablerIcon device_ipad_horizontal_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_SEARCH);
  }

  default TablerIcon device_ipad_horizontal_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_SHARE);
  }

  default TablerIcon device_ipad_horizontal_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_STAR);
  }

  default TablerIcon device_ipad_horizontal_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_UP);
  }

  default TablerIcon device_ipad_horizontal_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_HORIZONTAL_X);
  }

  default TablerIcon device_ipad_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_MINUS);
  }

  default TablerIcon device_ipad_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_OFF);
  }

  default TablerIcon device_ipad_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_PAUSE);
  }

  default TablerIcon device_ipad_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_PIN);
  }

  default TablerIcon device_ipad_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_PLUS);
  }

  default TablerIcon device_ipad_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_QUESTION);
  }

  default TablerIcon device_ipad_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_SEARCH);
  }

  default TablerIcon device_ipad_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_SHARE);
  }

  default TablerIcon device_ipad_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_STAR);
  }

  default TablerIcon device_ipad_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_UP);
  }

  default TablerIcon device_ipad_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_IPAD_X);
  }

  default TablerIcon device_landline_phone() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_LANDLINE_PHONE);
  }

  default TablerIcon device_laptop() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_LAPTOP);
  }

  default TablerIcon device_laptop_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_LAPTOP_OFF);
  }

  default TablerIcon device_mobile() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE);
  }

  default TablerIcon device_mobile_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_BOLT);
  }

  default TablerIcon device_mobile_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_CANCEL);
  }

  default TablerIcon device_mobile_charging() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_CHARGING);
  }

  default TablerIcon device_mobile_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_CHECK);
  }

  default TablerIcon device_mobile_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_CODE);
  }

  default TablerIcon device_mobile_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_COG);
  }

  default TablerIcon device_mobile_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_DOLLAR);
  }

  default TablerIcon device_mobile_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_DOWN);
  }

  default TablerIcon device_mobile_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_EXCLAMATION);
  }

  default TablerIcon device_mobile_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_HEART);
  }

  default TablerIcon device_mobile_message() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_MESSAGE);
  }

  default TablerIcon device_mobile_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_MINUS);
  }

  default TablerIcon device_mobile_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_OFF);
  }

  default TablerIcon device_mobile_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_PAUSE);
  }

  default TablerIcon device_mobile_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_PIN);
  }

  default TablerIcon device_mobile_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_PLUS);
  }

  default TablerIcon device_mobile_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_QUESTION);
  }

  default TablerIcon device_mobile_rotated() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_ROTATED);
  }

  default TablerIcon device_mobile_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_SEARCH);
  }

  default TablerIcon device_mobile_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_SHARE);
  }

  default TablerIcon device_mobile_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_STAR);
  }

  default TablerIcon device_mobile_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_UP);
  }

  default TablerIcon device_mobile_vibration() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_VIBRATION);
  }

  default TablerIcon device_mobile_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_MOBILE_X);
  }

  default TablerIcon device_nintendo() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_NINTENDO);
  }

  default TablerIcon device_nintendo_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_NINTENDO_OFF);
  }

  default TablerIcon device_remote() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_REMOTE);
  }

  default TablerIcon device_screen() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SCREEN);
  }

  default TablerIcon device_sd_card() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SD_CARD);
  }

  default TablerIcon device_sim() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SIM);
  }

  default TablerIcon device_sim_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SIM_1);
  }

  default TablerIcon device_sim_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SIM_2);
  }

  default TablerIcon device_sim_3() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SIM_3);
  }

  default TablerIcon device_speaker() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SPEAKER);
  }

  default TablerIcon device_speaker_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_SPEAKER_OFF);
  }

  default TablerIcon device_tablet() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET);
  }

  default TablerIcon device_tablet_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_BOLT);
  }

  default TablerIcon device_tablet_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_CANCEL);
  }

  default TablerIcon device_tablet_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_CHECK);
  }

  default TablerIcon device_tablet_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_CODE);
  }

  default TablerIcon device_tablet_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_COG);
  }

  default TablerIcon device_tablet_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_DOLLAR);
  }

  default TablerIcon device_tablet_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_DOWN);
  }

  default TablerIcon device_tablet_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_EXCLAMATION);
  }

  default TablerIcon device_tablet_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_HEART);
  }

  default TablerIcon device_tablet_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_MINUS);
  }

  default TablerIcon device_tablet_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_OFF);
  }

  default TablerIcon device_tablet_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_PAUSE);
  }

  default TablerIcon device_tablet_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_PIN);
  }

  default TablerIcon device_tablet_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_PLUS);
  }

  default TablerIcon device_tablet_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_QUESTION);
  }

  default TablerIcon device_tablet_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_SEARCH);
  }

  default TablerIcon device_tablet_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_SHARE);
  }

  default TablerIcon device_tablet_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_STAR);
  }

  default TablerIcon device_tablet_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_UP);
  }

  default TablerIcon device_tablet_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TABLET_X);
  }

  default TablerIcon device_tv() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TV);
  }

  default TablerIcon device_tv_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TV_OFF);
  }

  default TablerIcon device_tv_old() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_TV_OLD);
  }

  default TablerIcon device_usb() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_USB);
  }

  default TablerIcon device_vision_pro() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_VISION_PRO);
  }

  default TablerIcon device_vision_pro_wifi() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_VISION_PRO_WIFI);
  }

  default TablerIcon device_watch() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH);
  }

  default TablerIcon device_watch_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_BOLT);
  }

  default TablerIcon device_watch_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_CANCEL);
  }

  default TablerIcon device_watch_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_CHECK);
  }

  default TablerIcon device_watch_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_CODE);
  }

  default TablerIcon device_watch_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_COG);
  }

  default TablerIcon device_watch_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_DOLLAR);
  }

  default TablerIcon device_watch_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_DOWN);
  }

  default TablerIcon device_watch_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_EXCLAMATION);
  }

  default TablerIcon device_watch_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_HEART);
  }

  default TablerIcon device_watch_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_MINUS);
  }

  default TablerIcon device_watch_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_OFF);
  }

  default TablerIcon device_watch_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_PAUSE);
  }

  default TablerIcon device_watch_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_PIN);
  }

  default TablerIcon device_watch_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_PLUS);
  }

  default TablerIcon device_watch_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_QUESTION);
  }

  default TablerIcon device_watch_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_SEARCH);
  }

  default TablerIcon device_watch_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_SHARE);
  }

  default TablerIcon device_watch_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_STAR);
  }

  default TablerIcon device_watch_stats() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_STATS);
  }

  default TablerIcon device_watch_stats_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_STATS_2);
  }

  default TablerIcon device_watch_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_UP);
  }

  default TablerIcon device_watch_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICE_WATCH_X);
  }

  default TablerIcon devices() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES);
  }

  default TablerIcon devices_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_2);
  }

  default TablerIcon devices_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_BOLT);
  }

  default TablerIcon devices_cancel() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_CANCEL);
  }

  default TablerIcon devices_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_CHECK);
  }

  default TablerIcon devices_code() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_CODE);
  }

  default TablerIcon devices_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_COG);
  }

  default TablerIcon devices_dollar() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_DOLLAR);
  }

  default TablerIcon devices_down() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_DOWN);
  }

  default TablerIcon devices_exclamation() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_EXCLAMATION);
  }

  default TablerIcon devices_heart() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_HEART);
  }

  default TablerIcon devices_minus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_MINUS);
  }

  default TablerIcon devices_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_OFF);
  }

  default TablerIcon devices_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_PAUSE);
  }

  default TablerIcon devices_pc() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_PC);
  }

  default TablerIcon devices_pc_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_PC_OFF);
  }

  default TablerIcon devices_pin() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_PIN);
  }

  default TablerIcon devices_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_PLUS);
  }

  default TablerIcon devices_question() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_QUESTION);
  }

  default TablerIcon devices_search() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_SEARCH);
  }

  default TablerIcon devices_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_SHARE);
  }

  default TablerIcon devices_star() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_STAR);
  }

  default TablerIcon devices_up() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_UP);
  }

  default TablerIcon devices_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DEVICES_X);
  }

  default TablerIcon dialpad() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DIALPAD);
  }

  default TablerIcon dialpad_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DIALPAD_OFF);
  }

  default TablerIcon disc() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DISC);
  }

  default TablerIcon disc_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DISC_OFF);
  }

  default TablerIcon dual_screen() {
    return TablerIcon.create(TablerDevices.OutlineIcon.DUAL_SCREEN);
  }

  default TablerIcon earphone_bluetooth() {
    return TablerIcon.create(TablerDevices.OutlineIcon.EARPHONE_BLUETOOTH);
  }

  default TablerIcon fridge() {
    return TablerIcon.create(TablerDevices.OutlineIcon.FRIDGE);
  }

  default TablerIcon fridge_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.FRIDGE_OFF);
  }

  default TablerIcon gpu() {
    return TablerIcon.create(TablerDevices.OutlineIcon.GPU);
  }

  default TablerIcon gpu_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.GPU_2);
  }

  default TablerIcon hammer_drill() {
    return TablerIcon.create(TablerDevices.OutlineIcon.HAMMER_DRILL);
  }

  default TablerIcon keyboard() {
    return TablerIcon.create(TablerDevices.OutlineIcon.KEYBOARD);
  }

  default TablerIcon keyboard_hide() {
    return TablerIcon.create(TablerDevices.OutlineIcon.KEYBOARD_HIDE);
  }

  default TablerIcon keyboard_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.KEYBOARD_OFF);
  }

  default TablerIcon keyboard_show() {
    return TablerIcon.create(TablerDevices.OutlineIcon.KEYBOARD_SHOW);
  }

  default TablerIcon lawn_mower() {
    return TablerIcon.create(TablerDevices.OutlineIcon.LAWN_MOWER);
  }

  default TablerIcon memory() {
    return TablerIcon.create(TablerDevices.OutlineIcon.MEMORY);
  }

  default TablerIcon mouse() {
    return TablerIcon.create(TablerDevices.OutlineIcon.MOUSE);
  }

  default TablerIcon mouse_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.MOUSE_2);
  }

  default TablerIcon mouse_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.MOUSE_OFF);
  }

  default TablerIcon nfc() {
    return TablerIcon.create(TablerDevices.OutlineIcon.NFC);
  }

  default TablerIcon nfc_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.NFC_OFF);
  }

  default TablerIcon phone() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE);
  }

  default TablerIcon phone_call() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_CALL);
  }

  default TablerIcon phone_calling() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_CALLING);
  }

  default TablerIcon phone_check() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_CHECK);
  }

  default TablerIcon phone_incoming() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_INCOMING);
  }

  default TablerIcon phone_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_OFF);
  }

  default TablerIcon phone_outgoing() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_OUTGOING);
  }

  default TablerIcon phone_pause() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_PAUSE);
  }

  default TablerIcon phone_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_PLUS);
  }

  default TablerIcon phone_spark() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_SPARK);
  }

  default TablerIcon phone_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PHONE_X);
  }

  default TablerIcon playstation_circle() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLAYSTATION_CIRCLE);
  }

  default TablerIcon playstation_square() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLAYSTATION_SQUARE);
  }

  default TablerIcon playstation_triangle() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLAYSTATION_TRIANGLE);
  }

  default TablerIcon playstation_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLAYSTATION_X);
  }

  default TablerIcon plug() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLUG);
  }

  default TablerIcon plug_connected() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLUG_CONNECTED);
  }

  default TablerIcon plug_connected_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLUG_CONNECTED_X);
  }

  default TablerIcon plug_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLUG_OFF);
  }

  default TablerIcon plug_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PLUG_X);
  }

  default TablerIcon power() {
    return TablerIcon.create(TablerDevices.OutlineIcon.POWER);
  }

  default TablerIcon printer() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PRINTER);
  }

  default TablerIcon printer_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.PRINTER_OFF);
  }

  default TablerIcon qrcode() {
    return TablerIcon.create(TablerDevices.OutlineIcon.QRCODE);
  }

  default TablerIcon qrcode_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.QRCODE_OFF);
  }

  default TablerIcon remote_control() {
    return TablerIcon.create(TablerDevices.OutlineIcon.REMOTE_CONTROL);
  }

  default TablerIcon router() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ROUTER);
  }

  default TablerIcon router_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.ROUTER_OFF);
  }

  default TablerIcon screen_share() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SCREEN_SHARE);
  }

  default TablerIcon screen_share_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SCREEN_SHARE_OFF);
  }

  default TablerIcon server() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER);
  }

  default TablerIcon server_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER_2);
  }

  default TablerIcon server_bolt() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER_BOLT);
  }

  default TablerIcon server_cog() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER_COG);
  }

  default TablerIcon server_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER_OFF);
  }

  default TablerIcon server_spark() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SERVER_SPARK);
  }

  default TablerIcon shredder() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SHREDDER);
  }

  default TablerIcon signal_2g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_2G);
  }

  default TablerIcon signal_3g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_3G);
  }

  default TablerIcon signal_4g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_4G);
  }

  default TablerIcon signal_4g_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_4G_PLUS);
  }

  default TablerIcon signal_5g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_5G);
  }

  default TablerIcon signal_6g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_6G);
  }

  default TablerIcon signal_e() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_E);
  }

  default TablerIcon signal_g() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_G);
  }

  default TablerIcon signal_h() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_H);
  }

  default TablerIcon signal_h_plus() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_H_PLUS);
  }

  default TablerIcon signal_lte() {
    return TablerIcon.create(TablerDevices.OutlineIcon.SIGNAL_LTE);
  }

  default TablerIcon viewport_narrow() {
    return TablerIcon.create(TablerDevices.OutlineIcon.VIEWPORT_NARROW);
  }

  default TablerIcon viewport_wide() {
    return TablerIcon.create(TablerDevices.OutlineIcon.VIEWPORT_WIDE);
  }

  default TablerIcon vinyl() {
    return TablerIcon.create(TablerDevices.OutlineIcon.VINYL);
  }

  default TablerIcon wash_machine() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WASH_MACHINE);
  }

  default TablerIcon wifi() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WIFI);
  }

  default TablerIcon wifi_0() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WIFI_0);
  }

  default TablerIcon wifi_1() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WIFI_1);
  }

  default TablerIcon wifi_2() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WIFI_2);
  }

  default TablerIcon wifi_off() {
    return TablerIcon.create(TablerDevices.OutlineIcon.WIFI_OFF);
  }

  default TablerIcon xbox_a() {
    return TablerIcon.create(TablerDevices.OutlineIcon.XBOX_A);
  }

  default TablerIcon xbox_b() {
    return TablerIcon.create(TablerDevices.OutlineIcon.XBOX_B);
  }

  default TablerIcon xbox_x() {
    return TablerIcon.create(TablerDevices.OutlineIcon.XBOX_X);
  }

  default TablerIcon xbox_y() {
    return TablerIcon.create(TablerDevices.OutlineIcon.XBOX_Y);
  }

  default TablerIcon battery_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY);
  }

  default TablerIcon battery_1_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_1);
  }

  default TablerIcon battery_2_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_2);
  }

  default TablerIcon battery_3_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_3);
  }

  default TablerIcon battery_4_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_4);
  }

  default TablerIcon battery_vertical_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_VERTICAL);
  }

  default TablerIcon battery_vertical_1_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_VERTICAL_1);
  }

  default TablerIcon battery_vertical_2_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_VERTICAL_2);
  }

  default TablerIcon battery_vertical_3_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_VERTICAL_3);
  }

  default TablerIcon battery_vertical_4_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BATTERY_VERTICAL_4);
  }

  default TablerIcon blender_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.BLENDER);
  }

  default TablerIcon calculator_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.CALCULATOR);
  }

  default TablerIcon cardboards_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.CARDBOARDS);
  }

  default TablerIcon device_cctv_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_CCTV);
  }

  default TablerIcon device_desktop_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_DESKTOP);
  }

  default TablerIcon device_floppy_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_FLOPPY);
  }

  default TablerIcon device_gamepad_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_GAMEPAD);
  }

  default TablerIcon device_gamepad_2_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_GAMEPAD_2);
  }

  default TablerIcon device_gamepad_3_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_GAMEPAD_3);
  }

  default TablerIcon device_heart_monitor_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_HEART_MONITOR);
  }

  default TablerIcon device_imac_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_IMAC);
  }

  default TablerIcon device_ipad_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_IPAD);
  }

  default TablerIcon device_mobile_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_MOBILE);
  }

  default TablerIcon device_remote_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_REMOTE);
  }

  default TablerIcon device_speaker_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_SPEAKER);
  }

  default TablerIcon device_tablet_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_TABLET);
  }

  default TablerIcon device_tv_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_TV);
  }

  default TablerIcon device_tv_old_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_TV_OLD);
  }

  default TablerIcon device_usb_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_USB);
  }

  default TablerIcon device_vision_pro_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_VISION_PRO);
  }

  default TablerIcon device_watch_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DEVICE_WATCH);
  }

  default TablerIcon dialpad_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DIALPAD);
  }

  default TablerIcon disc_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DISC);
  }

  default TablerIcon dual_screen_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.DUAL_SCREEN);
  }

  default TablerIcon keyboard_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.KEYBOARD);
  }

  default TablerIcon mouse_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.MOUSE);
  }

  default TablerIcon phone_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.PHONE);
  }

  default TablerIcon phone_call_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.PHONE_CALL);
  }

  default TablerIcon phone_calling_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.PHONE_CALLING);
  }

  default TablerIcon phone_check_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.PHONE_CHECK);
  }

  default TablerIcon phone_x_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.PHONE_X);
  }

  default TablerIcon xbox_a_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.XBOX_A);
  }

  default TablerIcon xbox_b_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.XBOX_B);
  }

  default TablerIcon xbox_x_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.XBOX_X);
  }

  default TablerIcon xbox_y_filled() {
    return TablerIcon.create(TablerDevices.FilledIcon.XBOX_Y);
  }
}
