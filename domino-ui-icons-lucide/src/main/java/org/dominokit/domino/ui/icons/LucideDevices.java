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

/** Lucide devices catalog category. */
public interface LucideDevices {
  enum Icon implements LucideIconDefinition {
    ALARM_CLOCK(
        "alarm-clock",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M12 9v4l2 2\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />"),
    ALARM_CLOCK_CHECK(
        "alarm-clock-check",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"m9 13 2 2 4-4\" />"),
    ALARM_CLOCK_MINUS(
        "alarm-clock-minus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M9 13h6\" />"),
    ALARM_CLOCK_OFF(
        "alarm-clock-off",
        "<path d=\"M6.87 6.87a8 8 0 1 0 11.26 11.26\" />\n  <path d=\"M19.9 14.25a8 8 0 0 0-9.15-9.15\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.26 18.67 4 21\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M4 4 2 6\" />"),
    ALARM_CLOCK_PLUS(
        "alarm-clock-plus",
        "<circle cx=\"12\" cy=\"13\" r=\"8\" />\n  <path d=\"M5 3 2 6\" />\n  <path d=\"m22 6-3-3\" />\n  <path d=\"M6.38 18.7 4 21\" />\n  <path d=\"M17.64 18.67 20 21\" />\n  <path d=\"M12 10v6\" />\n  <path d=\"M9 13h6\" />"),
    ALARM_SMOKE(
        "alarm-smoke",
        "<path d=\"M11 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"M16 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"m19 8-.8 3a1.25 1.25 0 0 1-1.2 1H7a1.25 1.25 0 0 1-1.2-1L5 8\" />\n  <path d=\"M21 3a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 21c0-2.5 2-2.5 2-5\" />"),
    ANTENNA(
        "antenna",
        "<path d=\"M2 12 7 2\" />\n  <path d=\"m7 12 5-10\" />\n  <path d=\"m12 12 5-10\" />\n  <path d=\"m17 12 5-10\" />\n  <path d=\"M4.5 7h15\" />\n  <path d=\"M12 16v6\" />"),
    BATTERY(
        "battery",
        "<path d=\"M 22 14 L 22 10\" />\n  <rect x=\"2\" y=\"6\" width=\"16\" height=\"12\" rx=\"2\" />"),
    BATTERY_CHARGING(
        "battery-charging",
        "<path d=\"m11 7-3 5h4l-3 5\" />\n  <path d=\"M14.856 6H16a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-2.935\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M5.14 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2.936\" />"),
    BATTERY_FULL(
        "battery-full",
        "<path d=\"M10 10v4\" />\n  <path d=\"M14 10v4\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M6 10v4\" />\n  <rect x=\"2\" y=\"6\" width=\"16\" height=\"12\" rx=\"2\" />"),
    BATTERY_LOW(
        "battery-low",
        "<path d=\"M22 14v-4\" />\n  <path d=\"M6 14v-4\" />\n  <rect x=\"2\" y=\"6\" width=\"16\" height=\"12\" rx=\"2\" />"),
    BATTERY_MEDIUM(
        "battery-medium",
        "<path d=\"M10 14v-4\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M6 14v-4\" />\n  <rect x=\"2\" y=\"6\" width=\"16\" height=\"12\" rx=\"2\" />"),
    BATTERY_PLUS(
        "battery-plus",
        "<path d=\"M10 9v6\" />\n  <path d=\"M12.543 6H16a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-3.605\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M7 12h6\" />\n  <path d=\"M7.606 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h3.606\" />"),
    BATTERY_WARNING(
        "battery-warning",
        "<path d=\"M10 17h.01\" />\n  <path d=\"M10 7v6\" />\n  <path d=\"M14 6h2a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M6 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2\" />"),
    BELL_ELECTRIC(
        "bell-electric",
        "<path d=\"M18.518 17.347A7 7 0 0 1 14 19\" />\n  <path d=\"M18.8 4A11 11 0 0 1 20 9\" />\n  <path d=\"M9 9h.01\" />\n  <circle cx=\"20\" cy=\"16\" r=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"7\" />\n  <rect x=\"4\" y=\"16\" width=\"10\" height=\"6\" rx=\"2\" />"),
    BLUETOOTH("bluetooth", "<path d=\"m7 7 10 10-5 5V2l5 5L7 17\" />"),
    BLUETOOTH_CONNECTED(
        "bluetooth-connected",
        "<path d=\"m7 7 10 10-5 5V2l5 5L7 17\" />\n  <line x1=\"18\" x2=\"21\" y1=\"12\" y2=\"12\" />\n  <line x1=\"3\" x2=\"6\" y1=\"12\" y2=\"12\" />"),
    BLUETOOTH_OFF(
        "bluetooth-off",
        "<path d=\"m17 17-5 5V12l-5 5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M14.5 9.5 17 7l-5-5v4.5\" />"),
    BLUETOOTH_SEARCHING(
        "bluetooth-searching",
        "<path d=\"m7 7 10 10-5 5V2l5 5L7 17\" />\n  <path d=\"M20.83 14.83a4 4 0 0 0 0-5.66\" />\n  <path d=\"M18 12h.01\" />"),
    BOOM_BOX(
        "boom-box",
        "<path d=\"M4 9V5a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M8 8v1\" />\n  <path d=\"M12 8v1\" />\n  <path d=\"M16 8v1\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"9\" rx=\"2\" />\n  <circle cx=\"8\" cy=\"15\" r=\"2\" />\n  <circle cx=\"16\" cy=\"15\" r=\"2\" />"),
    CABLE(
        "cable",
        "<path d=\"M17 19a1 1 0 0 1-1-1v-2a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2a1 1 0 0 1-1 1z\" />\n  <path d=\"M17 21v-2\" />\n  <path d=\"M19 14V6.5a1 1 0 0 0-7 0v11a1 1 0 0 1-7 0V10\" />\n  <path d=\"M21 21v-2\" />\n  <path d=\"M3 5V3\" />\n  <path d=\"M4 10a2 2 0 0 1-2-2V6a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2z\" />\n  <path d=\"M7 5V3\" />"),
    CALCULATOR(
        "calculator",
        "<rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <line x1=\"8\" x2=\"16\" y1=\"6\" y2=\"6\" />\n  <line x1=\"16\" x2=\"16\" y1=\"14\" y2=\"18\" />\n  <path d=\"M16 10h.01\" />\n  <path d=\"M12 10h.01\" />\n  <path d=\"M8 10h.01\" />\n  <path d=\"M12 14h.01\" />\n  <path d=\"M8 14h.01\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M8 18h.01\" />"),
    CAMERA(
        "camera",
        "<path d=\"M13.997 4a2 2 0 0 1 1.76 1.05l.486.9A2 2 0 0 0 18.003 7H20a2 2 0 0 1 2 2v9a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h1.997a2 2 0 0 0 1.759-1.048l.489-.904A2 2 0 0 1 10.004 4z\" />\n  <circle cx=\"12\" cy=\"13\" r=\"3\" />"),
    CAMERA_OFF(
        "camera-off",
        "<path d=\"M14.564 14.558a3 3 0 1 1-4.122-4.121\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V9a2 2 0 0 1 2-2h1.997a2 2 0 0 0 .819-.175\" />\n  <path d=\"M9.695 4.024A2 2 0 0 1 10.004 4h3.993a2 2 0 0 1 1.76 1.05l.486.9A2 2 0 0 0 18.003 7H20a2 2 0 0 1 2 2v7.344\" />"),
    CARD_SIM(
        "card-sim",
        "<path d=\"M12 14v4\" />\n  <path d=\"M14.172 2a2 2 0 0 1 1.414.586l3.828 3.828A2 2 0 0 1 20 7.828V20a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2z\" />\n  <path d=\"M8 14h8\" />\n  <rect x=\"8\" y=\"10\" width=\"8\" height=\"8\" rx=\"2\" />"),
    CASSETTE_TAPE(
        "cassette-tape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <circle cx=\"8\" cy=\"10\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"10\" r=\"2\" />\n  <path d=\"m6 20 .7-2.9A1.4 1.4 0 0 1 8.1 16h7.8a1.4 1.4 0 0 1 1.4 1l.7 3\" />"),
    CAST(
        "cast",
        "<path d=\"M2 8V6a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v12a2 2 0 0 1-2 2h-6\" />\n  <path d=\"M2 12a9 9 0 0 1 8 8\" />\n  <path d=\"M2 16a5 5 0 0 1 4 4\" />\n  <line x1=\"2\" x2=\"2.01\" y1=\"20\" y2=\"20\" />"),
    CCTV(
        "cctv",
        "<path d=\"M16.75 12h3.632a1 1 0 0 1 .894 1.447l-2.034 4.069a1 1 0 0 1-1.708.134l-2.124-2.97\" />\n  <path d=\"M17.106 9.053a1 1 0 0 1 .447 1.341l-3.106 6.211a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.92 2.92 0 0 1 3.92-1.3z\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1L9 15\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CCTV_OFF(
        "cctv-off",
        "<path d=\"m12.309 6.652 4.797 2.401a1 1 0 0 1 .447 1.341l-.501 1.001.605.605h2.725a1 1 0 0 1 .894 1.447l-.724 1.448\" />\n  <path d=\"m15.166 15.166-.719 1.439a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.9 2.9 0 0 1 .873-1.037\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1l1.441-2.902\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CHEVRONS_LEFT_RIGHT_ELLIPSIS(
        "chevrons-left-right-ellipsis",
        "<path d=\"M12 12h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"m17 7 5 5-5 5\" />\n  <path d=\"m7 7-5 5 5 5\" />\n  <path d=\"M8 12h.01\" />"),
    COMPUTER(
        "computer",
        "<path d=\"M12 18h6\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M8 6h1\" />\n  <rect x=\"2\" y=\"14\" width=\"20\" height=\"8\" rx=\"2\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"12\" rx=\"2\" />"),
    CPU(
        "cpu",
        "<path d=\"M12 20v2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M17 20v2\" />\n  <path d=\"M17 2v2\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M2 17h2\" />\n  <path d=\"M2 7h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M20 7h2\" />\n  <path d=\"M7 20v2\" />\n  <path d=\"M7 2v2\" />\n  <rect x=\"4\" y=\"4\" width=\"16\" height=\"16\" rx=\"2\" />\n  <rect x=\"8\" y=\"8\" width=\"8\" height=\"8\" rx=\"1\" />"),
    CPU_AI(
        "cpu-ai",
        "<path d=\"M12 20v2\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M16 9v6\" />\n  <path d=\"M17 20v2\" />\n  <path d=\"M17 2v2\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M2 17h2\" />\n  <path d=\"M2 7h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M20 7h2\" />\n  <path d=\"M7 20v2\" />\n  <path d=\"M7 2v2\" />\n  <path d=\"M8 13h4\" />\n  <path d=\"M8 15v-4a2 2 0 014 0v4\" />\n  <rect x=\"4\" y=\"4\" width=\"16\" height=\"16\" rx=\"2\" />"),
    DATABASE(
        "database",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5V19A9 3 0 0 0 21 19V5\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />"),
    DATABASE_ARROW_DOWN(
        "database-arrow-down",
        "<path d=\"m16 19 3 3 3-3\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"M3 12A9 3 0 0 0 15.182 14.806\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_ARROW_UP(
        "database-arrow-up",
        "<path d=\"M19 22v-6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"m22 19-3-3-3 3\" />\n  <path d=\"M3 12A9 3 0 0 0 14.457 14.886\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_BACKUP(
        "database-backup",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 12a9 3 0 0 0 5 2.69\" />\n  <path d=\"M21 9.3V5\" />\n  <path d=\"M3 5v14a9 3 0 0 0 6.47 2.88\" />\n  <path d=\"M12 12v4h4\" />\n  <path d=\"M13 20a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L12 16\" />"),
    DATABASE_CHECK(
        "database-check",
        "<path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M21 13.127V5\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_MINUS(
        "database-minus",
        "<path d=\"M21 15V5\" />\n  <path d=\"M22 19h-6\" />\n  <path d=\"M3 12A9 3 0 0 0 21 12\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_PLUS(
        "database-plus",
        "<path d=\"M19 16v6\" />\n  <path d=\"M21 12.536V5\" />\n  <path d=\"M22 19h-6\" />\n  <path d=\"M3 12A9 3 0 0 0 15.1824 14.8061\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13.318 21.968\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_SEARCH(
        "database-search",
        "<path d=\"M21 11.693V5\" />\n  <path d=\"m22 22-1.875-1.875\" />\n  <path d=\"M3 12a9 3 0 0 0 8.697 2.998\" />\n  <path d=\"M3 5v14a9 3 0 0 0 9.28 2.999\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_X(
        "database-x",
        "<path d=\"m17 17 5 5\" />\n  <path d=\"M19.323 13.744A9 3 0 0 0 21 12\" />\n  <path d=\"M21 13.127V5\" />\n  <path d=\"m22 17-5 5\" />\n  <path d=\"M3 12A9 3 0 0 0 13.563 14.954\" />\n  <path d=\"M3 5V19A9 3 0 0 0 13 21.981\" />\n  <ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />"),
    DATABASE_ZAP(
        "database-zap",
        "<ellipse cx=\"12\" cy=\"5\" rx=\"9\" ry=\"3\" />\n  <path d=\"M3 5V19A9 3 0 0 0 15 21.84\" />\n  <path d=\"M21 5V8\" />\n  <path d=\"M21 12L18 17H22L19 22\" />\n  <path d=\"M3 12A9 3 0 0 0 14.59 14.87\" />"),
    DIAMOND_MINUS(
        "diamond-minus",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
    DIAMOND_PLUS(
        "diamond-plus",
        "<path d=\"M12 8v8\" />\n  <path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0z\" />\n  <path d=\"M8 12h8\" />"),
    DISC(
        "disc",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    DISC_2(
        "disc-2",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 12h.01\" />"),
    DISC_3(
        "disc-3",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M6 12c0-1.7.7-3.2 1.8-4.2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M18 12c0 1.7-.7 3.2-1.8 4.2\" />"),
    DISC_ALBUM(
        "disc-album",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"5\" />\n  <path d=\"M12 12h.01\" />"),
    DRILL(
        "drill",
        "<path d=\"M10 18a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H5a3 3 0 0 1-3-3 1 1 0 0 1 1-1z\" />\n  <path d=\"M13 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a1 1 0 0 1 1 1v6a1 1 0 0 1-1 1l-.81 3.242a1 1 0 0 1-.97.758H8\" />\n  <path d=\"M14 4h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M18 6h4\" />\n  <path d=\"m5 10-2 8\" />\n  <path d=\"m7 18 2-8\" />"),
    DRONE(
        "drone",
        "<path d=\"M10 10 7 7\" />\n  <path d=\"m10 14-3 3\" />\n  <path d=\"m14 10 3-3\" />\n  <path d=\"m14 14 3 3\" />\n  <path d=\"M14.205 4.139a4 4 0 1 1 5.439 5.863\" />\n  <path d=\"M19.637 14a4 4 0 1 1-5.432 5.868\" />\n  <path d=\"M4.367 10a4 4 0 1 1 5.438-5.862\" />\n  <path d=\"M9.795 19.862a4 4 0 1 1-5.429-5.873\" />\n  <rect x=\"10\" y=\"8\" width=\"4\" height=\"8\" rx=\"1\" />"),
    DRUM(
        "drum",
        "<path d=\"m2 2 8 8\" />\n  <path d=\"m22 2-8 8\" />\n  <ellipse cx=\"12\" cy=\"9\" rx=\"10\" ry=\"5\" />\n  <path d=\"M7 13.4v7.9\" />\n  <path d=\"M12 14v8\" />\n  <path d=\"M17 13.4v7.9\" />\n  <path d=\"M2 9v8a10 5 0 0 0 20 0V9\" />"),
    EARTH_LOCK(
        "earth-lock",
        "<path d=\"M7 3.34V5a3 3 0 0 0 3 3\" />\n  <path d=\"M11 21.95V18a2 2 0 0 0-2-2 2 2 0 0 1-2-2v-1a2 2 0 0 0-2-2H2.05\" />\n  <path d=\"M21.54 15H17a2 2 0 0 0-2 2v4.54\" />\n  <path d=\"M12 2a10 10 0 1 0 9.54 13\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    EJECT(
        "eject",
        "<path d=\"M4 13a1 1 0 0 1-.72-1.695l7.257-7.668a2 2 0 0 1 2.926 0l7.256 7.668A1 1 0 0 1 20 13z\" />\n  <rect x=\"3\" y=\"17\" width=\"18\" height=\"4\" rx=\"1\" />"),
    ETHERNET_PORT(
        "ethernet-port",
        "<path d=\"M10 8v1\" />\n  <path d=\"M14 8v1\" />\n  <path d=\"M18 8v1\" />\n  <path d=\"M19 17a2 2 0 00-1.765 1.059l-.47.882A2 2 0 0115 20H9a2 2 0 01-1.765-1.059l-.47-.882A2 2 0 005 17H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v9a2 2 0 01-2 2z\" />\n  <path d=\"M6 8v1\" />"),
    FINGERPRINT_PATTERN(
        "fingerprint-pattern",
        "<path d=\"M12 10a2 2 0 0 0-2 2c0 1.02-.1 2.51-.26 4\" />\n  <path d=\"M14 13.12c0 2.38 0 6.38-1 8.88\" />\n  <path d=\"M17.29 21.02c.12-.6.43-2.3.5-3.02\" />\n  <path d=\"M2 12a10 10 0 0 1 18-6\" />\n  <path d=\"M2 16h.01\" />\n  <path d=\"M21.8 16c.2-2 .131-5.354 0-6\" />\n  <path d=\"M5 19.5C5.5 18 6 15 6 12a6 6 0 0 1 .34-2\" />\n  <path d=\"M8.65 22c.21-.66.45-1.32.57-2\" />\n  <path d=\"M9 6.8a6 6 0 0 1 9 5.2v2\" />"),
    FLASHLIGHT(
        "flashlight",
        "<path d=\"M12 13v1\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v4a3 3 0 0 1-.6 1.8l-.6.8A4 4 0 0 0 16 12v8a2 2 0 0 1-2 2H10a2 2 0 0 1-2-2v-8a4 4 0 0 0-.8-2.4l-.6-.8A3 3 0 0 1 6 7V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 6h12\" />"),
    FLASHLIGHT_OFF(
        "flashlight-off",
        "<path d=\"M11.652 6H18\" />\n  <path d=\"M12 13v1\" />\n  <path d=\"M16 16v4a2 2 0 0 1-2 2h-4a2 2 0 0 1-2-2v-8a4 4 0 0 0-.8-2.4l-.6-.8A3 3 0 0 1 6 7V6\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7.649 2H17a1 1 0 0 1 1 1v4a3 3 0 0 1-.6 1.8l-.6.8a4 4 0 0 0-.55 1.007\" />"),
    GAMEPAD(
        "gamepad",
        "<line x1=\"6\" x2=\"10\" y1=\"12\" y2=\"12\" />\n  <line x1=\"8\" x2=\"8\" y1=\"10\" y2=\"14\" />\n  <line x1=\"15\" x2=\"15.01\" y1=\"13\" y2=\"13\" />\n  <line x1=\"18\" x2=\"18.01\" y1=\"11\" y2=\"11\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />"),
    GAMEPAD_2(
        "gamepad-2",
        "<line x1=\"6\" x2=\"10\" y1=\"11\" y2=\"11\" />\n  <line x1=\"8\" x2=\"8\" y1=\"9\" y2=\"13\" />\n  <line x1=\"15\" x2=\"15.01\" y1=\"12\" y2=\"12\" />\n  <line x1=\"18\" x2=\"18.01\" y1=\"10\" y2=\"10\" />\n  <path d=\"M17.32 5H6.68a4 4 0 0 0-3.978 3.59c-.006.052-.01.101-.017.152C2.604 9.416 2 14.456 2 16a3 3 0 0 0 3 3c1 0 1.5-.5 2-1l1.414-1.414A2 2 0 0 1 9.828 16h4.344a2 2 0 0 1 1.414.586L17 18c.5.5 1 1 2 1a3 3 0 0 0 3-3c0-1.545-.604-6.584-.685-7.258-.007-.05-.011-.1-.017-.151A4 4 0 0 0 17.32 5z\" />"),
    GAMEPAD_DIRECTIONAL(
        "gamepad-directional",
        "<path d=\"M11.146 15.854a1.207 1.207 0 0 1 1.708 0l1.56 1.56A2 2 0 0 1 15 18.828V21a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-2.172a2 2 0 0 1 .586-1.414z\" />\n  <path d=\"M18.828 15a2 2 0 0 1-1.414-.586l-1.56-1.56a1.207 1.207 0 0 1 0-1.708l1.56-1.56A2 2 0 0 1 18.828 9H21a1 1 0 0 1 1 1v4a1 1 0 0 1-1 1z\" />\n  <path d=\"M6.586 14.414A2 2 0 0 1 5.172 15H3a1 1 0 0 1-1-1v-4a1 1 0 0 1 1-1h2.172a2 2 0 0 1 1.414.586l1.56 1.56a1.207 1.207 0 0 1 0 1.708z\" />\n  <path d=\"M9 3a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v2.172a2 2 0 0 1-.586 1.414l-1.56 1.56a1.207 1.207 0 0 1-1.708 0l-1.56-1.56A2 2 0 0 1 9 5.172z\" />"),
    GLOBE_LOCK(
        "globe-lock",
        "<path d=\"M15.686 15A14.5 14.5 0 0 1 12 22a14.5 14.5 0 0 1 0-20 10 10 0 1 0 9.542 13\" />\n  <path d=\"M2 12h8.5\" />\n  <path d=\"M20 6V4a2 2 0 1 0-4 0v2\" />\n  <rect width=\"8\" height=\"5\" x=\"14\" y=\"6\" rx=\"1\" />"),
    GLOBE_OFF(
        "globe-off",
        "<path d=\"M10.114 4.462A14.5 14.5 0 0 1 12 2a10 10 0 0 1 9.313 13.643\" />\n  <path d=\"M15.557 15.556A14.5 14.5 0 0 1 12 22 10 10 0 0 1 4.929 4.929\" />\n  <path d=\"M15.892 10.234A14.5 14.5 0 0 0 12 2a10 10 0 0 0-3.643.687\" />\n  <path d=\"M17.656 12H22\" />\n  <path d=\"M19.071 19.071A10 10 0 0 1 12 22 14.5 14.5 0 0 1 8.44 8.45\" />\n  <path d=\"M2 12h10\" />\n  <path d=\"m2 2 20 20\" />"),
    GLOBE_X(
        "globe-x",
        "<path d=\"m16 3 5 5\" />\n  <path d=\"M2 12h20A10 10 0 1 1 12 2a14.5 14.5 0 0 0 0 20 14.5 14.5 0 0 0 4-10\" />\n  <path d=\"m21 3-5 5\" />"),
    GPU(
        "gpu",
        "<path d=\"M2 17h18a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2H2\" />\n  <path d=\"M2 21V3\" />\n  <path d=\"M7 17v3a1 1 0 0 0 1 1h5a1 1 0 0 0 1-1v-3\" />\n  <circle cx=\"16\" cy=\"11\" r=\"2\" />\n  <circle cx=\"8\" cy=\"11\" r=\"2\" />"),
    HARD_DRIVE(
        "hard-drive",
        "<path d=\"M10 16h.01\" />\n  <path d=\"M2.212 11.577a2 2 0 0 0-.212.896V18a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-5.527a2 2 0 0 0-.212-.896L18.55 5.11A2 2 0 0 0 16.76 4H7.24a2 2 0 0 0-1.79 1.11z\" />\n  <path d=\"M21.946 12.013H2.054\" />\n  <path d=\"M6 16h.01\" />"),
    HARD_DRIVE_DOWNLOAD(
        "hard-drive-download",
        "<path d=\"M12 2v8\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HARD_DRIVE_UPLOAD(
        "hard-drive-upload",
        "<path d=\"m16 6-4-4-4 4\" />\n  <path d=\"M12 2v8\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M10 18h.01\" />"),
    HD(
        "hd",
        "<path d=\"M10 12H6\" />\n  <path d=\"M10 15V9\" />\n  <path d=\"M14 14.5a.5.5 0 0 0 .5.5h1a2.5 2.5 0 0 0 2.5-2.5v-1A2.5 2.5 0 0 0 15.5 9h-1a.5.5 0 0 0-.5.5z\" />\n  <path d=\"M6 15V9\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    HDMI_PORT(
        "hdmi-port",
        "<path d=\"M22 9a1 1 0 00-1-1H3a1 1 0 00-1 1v4a1 1 0 001 1h.5a2 2 0 011.6.8l.3.4A2 2 0 007 16h10a2 2 0 001.6-.8l.3-.4a2 2 0 011.6-.8h.5a1 1 0 001-1z\" />\n  <path d=\"M8 12h8\" />"),
    HEADPHONE_OFF(
        "headphone-off",
        "<path d=\"M21 14h-1.343\" />\n  <path d=\"M9.128 3.47A9 9 0 0 1 21 12v3.343\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20.414 20.414A2 2 0 0 1 19 21h-1a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 2.636-6.364\" />"),
    HEADPHONES(
        "headphones",
        "<path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3\" />"),
    HEADSET(
        "headset",
        "<path d=\"M3 11h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-5Zm0 0a9 9 0 1 1 18 0m0 0v5a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3Z\" />\n  <path d=\"M21 16v2a4 4 0 0 1-4 4h-5\" />"),
    HEATER(
        "heater",
        "<path d=\"M11 8c2-3-2-3 0-6\" />\n  <path d=\"M15.5 8c2-3-2-3 0-6\" />\n  <path d=\"M6 10h.01\" />\n  <path d=\"M6 14h.01\" />\n  <path d=\"M10 16v-4\" />\n  <path d=\"M14 16v-4\" />\n  <path d=\"M18 16v-4\" />\n  <path d=\"M20 6a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h3\" />\n  <path d=\"M5 20v2\" />\n  <path d=\"M19 20v2\" />"),
    JOYSTICK(
        "joystick",
        "<path d=\"M21 17a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v2a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-2Z\" />\n  <path d=\"M6 15v-2\" />\n  <path d=\"M12 15V9\" />\n  <circle cx=\"12\" cy=\"6\" r=\"3\" />"),
    KEYBOARD(
        "keyboard",
        "<path d=\"M10 8h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M7 16h10\" />\n  <path d=\"M8 12h.01\" />\n  <rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />"),
    KEYBOARD_MUSIC(
        "keyboard-music",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h4\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"M6 12v4\" />\n  <path d=\"M10 12v4\" />\n  <path d=\"M14 12v4\" />\n  <path d=\"M18 12v4\" />"),
    KEYBOARD_OFF(
        "keyboard-off",
        "<path d=\"M 20 4 A2 2 0 0 1 22 6\" />\n  <path d=\"M 22 6 L 22 16.41\" />\n  <path d=\"M 7 16 L 16 16\" />\n  <path d=\"M 9.69 4 L 20 4\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2\" />\n  <path d=\"M6 8h.01\" />\n  <path d=\"M8 12h.01\" />"),
    LAPTOP(
        "laptop",
        "<path d=\"M18 5a2 2 0 0 1 2 2v8.526a2 2 0 0 0 .212.897l1.068 2.127a1 1 0 0 1-.9 1.45H3.62a1 1 0 0 1-.9-1.45l1.068-2.127A2 2 0 0 0 4 15.526V7a2 2 0 0 1 2-2z\" />\n  <path d=\"M20.054 15.987H3.946\" />"),
    LAPTOP_MINIMAL(
        "laptop-minimal",
        "<rect width=\"18\" height=\"12\" x=\"3\" y=\"4\" rx=\"2\" ry=\"2\" />\n  <line x1=\"2\" x2=\"22\" y1=\"20\" y2=\"20\" />"),
    LAPTOP_MINIMAL_CHECK(
        "laptop-minimal-check",
        "<path d=\"M2 20h20\" />\n  <path d=\"m9 10 2 2 4-4\" />\n  <rect x=\"3\" y=\"4\" width=\"18\" height=\"12\" rx=\"2\" />"),
    MEMORY_STICK(
        "memory-stick",
        "<path d=\"M12 12v-2\" />\n  <path d=\"M12 18v-2\" />\n  <path d=\"M16 12v-2\" />\n  <path d=\"M16 18v-2\" />\n  <path d=\"M2 11h1.5\" />\n  <path d=\"M20 18v-2\" />\n  <path d=\"M20.5 11H22\" />\n  <path d=\"M4 18v-2\" />\n  <path d=\"M8 12v-2\" />\n  <path d=\"M8 18v-2\" />\n  <rect x=\"2\" y=\"6\" width=\"20\" height=\"10\" rx=\"2\" />"),
    MIC(
        "mic",
        "<path d=\"M12 19v3\" />\n  <path d=\"M19 10v2a7 7 0 0 1-14 0v-2\" />\n  <rect x=\"9\" y=\"2\" width=\"6\" height=\"13\" rx=\"3\" />"),
    MIC_AUDIO_LINES(
        "mic-audio-lines",
        "<path d=\"M10 3v2.341\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M14 5v.341\" />\n  <path d=\"M18 5v13\" />\n  <path d=\"M2 10v3\" />\n  <path d=\"M22 10v3\" />\n  <path d=\"M6 6v11\" />\n  <path d=\"M9 21h6\" />\n  <rect width=\"4\" height=\"8\" x=\"10\" y=\"9\" rx=\"2\" />"),
    MIC_OFF(
        "mic-off",
        "<path d=\"M12 19v3\" />\n  <path d=\"M15 9.34V5a3 3 0 0 0-5.68-1.33\" />\n  <path d=\"M16.95 16.95A7 7 0 0 1 5 12v-2\" />\n  <path d=\"M18.89 13.23A7 7 0 0 0 19 12v-2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M9 9v3a3 3 0 0 0 5.12 2.12\" />"),
    MIC_SIGNAL(
        "mic-signal",
        "<path d=\"M12 17v4\" />\n  <path d=\"M18 11a6 6 0 00-3-5.197\" />\n  <path d=\"M2 11a10 10 0 015-8.662\" />\n  <path d=\"M22 11a10 10 0 00-5-8.662\" />\n  <path d=\"M6 11a6 6 0 013-5.197\" />\n  <path d=\"M9 21h6\" />\n  <rect x=\"10\" y=\"9\" width=\"4\" height=\"8\" rx=\"2\" />"),
    MIC_VOCAL(
        "mic-vocal",
        "<path d=\"m11 7.601-5.994 8.19a1 1 0 0 0 .1 1.298l.817.818a1 1 0 0 0 1.314.087L15.09 12\" />\n  <path d=\"M16.5 21.174C15.5 20.5 14.372 20 13 20c-2.058 0-3.928 2.356-6 2-2.072-.356-2.775-3.369-1.5-4.5\" />\n  <circle cx=\"16\" cy=\"7\" r=\"5\" />"),
    MICROCHIP(
        "microchip",
        "<path d=\"M10 12h4\" />\n  <path d=\"M10 17h4\" />\n  <path d=\"M10 7h4\" />\n  <path d=\"M18 12h2\" />\n  <path d=\"M18 18h2\" />\n  <path d=\"M18 6h2\" />\n  <path d=\"M4 12h2\" />\n  <path d=\"M4 18h2\" />\n  <path d=\"M4 6h2\" />\n  <rect x=\"6\" y=\"2\" width=\"12\" height=\"20\" rx=\"2\" />"),
    MIDI_PORT(
        "midi-port",
        "<path d=\"M12 18h.01\" />\n  <path d=\"M15 2.458V5a1 1 0 01-1 1h-4a1 1 0 01-1-1V2.458\" />\n  <path d=\"M16 16h.01\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M8 16h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    MONITOR(
        "monitor",
        "<rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <line x1=\"8\" x2=\"16\" y1=\"21\" y2=\"21\" />\n  <line x1=\"12\" x2=\"12\" y1=\"17\" y2=\"21\" />"),
    MONITOR_CHECK(
        "monitor-check",
        "<path d=\"m9 10 2 2 4-4\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MONITOR_CLOUD(
        "monitor-cloud",
        "<path d=\"M11 13a3 3 0 1 1 2.83-4H14a2 2 0 0 1 0 4z\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />"),
    MONITOR_COG(
        "monitor-cog",
        "<path d=\"M12 17v4\" />\n  <path d=\"m14.305 7.53.923-.382\" />\n  <path d=\"m15.228 4.852-.923-.383\" />\n  <path d=\"m16.852 3.228-.383-.924\" />\n  <path d=\"m16.852 8.772-.383.923\" />\n  <path d=\"m19.148 3.228.383-.924\" />\n  <path d=\"m19.53 9.696-.382-.924\" />\n  <path d=\"m20.772 4.852.924-.383\" />\n  <path d=\"m20.772 7.148.924.383\" />\n  <path d=\"M22 13v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7\" />\n  <path d=\"M8 21h8\" />\n  <circle cx=\"18\" cy=\"6\" r=\"3\" />"),
    MONITOR_DOT(
        "monitor-dot",
        "<path d=\"M12 17v4\" />\n  <path d=\"M22 12.307V15a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h8.693\" />\n  <path d=\"M8 21h8\" />\n  <circle cx=\"19\" cy=\"6\" r=\"3\" />"),
    MONITOR_DOWN(
        "monitor-down",
        "<path d=\"M12 13V7\" />\n  <path d=\"m15 10-3 3-3-3\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MONITOR_OFF(
        "monitor-off",
        "<path d=\"M12 17v4\" />\n  <path d=\"M17 17H4a2 2 0 0 1-2-2V5a2 2 0 0 1 1.184-1.826\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M8.656 3H20a2 2 0 0 1 2 2v10a2 2 0 0 1-.293 1.042\" />"),
    MONITOR_PAUSE(
        "monitor-pause",
        "<path d=\"M10 13V7\" />\n  <path d=\"M14 13V7\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MONITOR_PC(
        "monitor-pc",
        "<path d=\"M10 15H4a2 2 0 01-2-2V7a2 2 0 012-2h6\" />\n  <path d=\"M10 19H5\" />\n  <path d=\"M14 11h8\" />\n  <path d=\"M14 7h8\" />\n  <path d=\"M18 17h.01\" />\n  <path d=\"M9 19v-4\" />\n  <rect x=\"14\" y=\"3\" width=\"8\" height=\"18\" rx=\"1\" />"),
    MONITOR_PLAY(
        "monitor-play",
        "<path d=\"M15.033 9.44a.647.647 0 0 1 0 1.12l-4.065 2.352a.645.645 0 0 1-.968-.56V7.648a.645.645 0 0 1 .967-.56z\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />"),
    MONITOR_SMARTPHONE(
        "monitor-smartphone",
        "<path d=\"M18 8V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v7a2 2 0 0 0 2 2h8\" />\n  <path d=\"M10 19v-3.96 3.15\" />\n  <path d=\"M7 19h5\" />\n  <rect width=\"6\" height=\"10\" x=\"16\" y=\"12\" rx=\"2\" />"),
    MONITOR_SPEAKER(
        "monitor-speaker",
        "<path d=\"M5.5 20H8\" />\n  <path d=\"M17 9h.01\" />\n  <rect width=\"10\" height=\"16\" x=\"12\" y=\"4\" rx=\"2\" />\n  <path d=\"M8 6H4a2 2 0 0 0-2 2v6a2 2 0 0 0 2 2h4\" />\n  <circle cx=\"17\" cy=\"15\" r=\"1\" />"),
    MONITOR_STOP(
        "monitor-stop",
        "<path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />\n  <rect x=\"9\" y=\"7\" width=\"6\" height=\"6\" rx=\"1\" />"),
    MONITOR_UP(
        "monitor-up",
        "<path d=\"m9 10 3-3 3 3\" />\n  <path d=\"M12 13V7\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MONITOR_X(
        "monitor-x",
        "<path d=\"m14.5 12.5-5-5\" />\n  <path d=\"m9.5 12.5 5-5\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MOUSE(
        "mouse",
        "<rect x=\"5\" y=\"2\" width=\"14\" height=\"20\" rx=\"7\" />\n  <path d=\"M12 6v4\" />"),
    MOUSE_LEFT(
        "mouse-left",
        "<path d=\"M12 7.318V10\" />\n  <path d=\"M5 10v5a7 7 0 0 0 14 0V9c0-3.527-2.608-6.515-6-7\" />\n  <circle cx=\"7\" cy=\"4\" r=\"2\" />"),
    MOUSE_OFF(
        "mouse-off",
        "<path d=\"M12 6v.343\" />\n  <path d=\"M18.218 18.218A7 7 0 0 1 5 15V9a7 7 0 0 1 .782-3.218\" />\n  <path d=\"M19 13.343V9A7 7 0 0 0 8.56 2.902\" />\n  <path d=\"M22 22 2 2\" />"),
    MOUSE_RIGHT(
        "mouse-right",
        "<path d=\"M12 7.318V10\" />\n  <path d=\"M19 10v5a7 7 0 0 1-14 0V9c0-3.527 2.608-6.515 6-7\" />\n  <circle cx=\"17\" cy=\"4\" r=\"2\" />"),
    NFC(
        "nfc",
        "<path d=\"M6 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M9.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M12.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />\n  <path d=\"M16.37 2a20.16 20.16 0 0 1 0 20\" />"),
    PC_CASE(
        "pc-case",
        "<rect width=\"14\" height=\"20\" x=\"5\" y=\"2\" rx=\"2\" />\n  <path d=\"M15 14h.01\" />\n  <path d=\"M9 6h6\" />\n  <path d=\"M9 10h6\" />"),
    PHONE(
        "phone",
        "<path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_CALL(
        "phone-call",
        "<path d=\"M13 2a9 9 0 0 1 9 9\" />\n  <path d=\"M13 6a5 5 0 0 1 5 5\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_FORWARDED(
        "phone-forwarded",
        "<path d=\"M14 6h8\" />\n  <path d=\"m18 2 4 4-4 4\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_INCOMING(
        "phone-incoming",
        "<path d=\"M16 2v6h6\" />\n  <path d=\"m22 2-6 6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_MISSED(
        "phone-missed",
        "<path d=\"m16 2 6 6\" />\n  <path d=\"m22 2-6 6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_OFF(
        "phone-off",
        "<path d=\"M10.1 13.9a14 14 0 0 0 3.732 2.668 1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2 18 18 0 0 1-12.728-5.272\" />\n  <path d=\"M22 2 2 22\" />\n  <path d=\"M4.76 13.582A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 .244.473\" />"),
    PHONE_OUTGOING(
        "phone-outgoing",
        "<path d=\"m16 8 6-6\" />\n  <path d=\"M22 8V2h-6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PIANO(
        "piano",
        "<path d=\"M10 13v4\" />\n  <path d=\"M14 13v4\" />\n  <path d=\"M18 13v4\" />\n  <path d=\"M2 13h20\" />\n  <path d=\"M22 11.5A3.5 3.5 0 0018.5 8a3.52 3.52 0 01-3.173-2A7 7 0 002 9v10a2 2 0 002 2h16a2 2 0 002-2z\" />\n  <path d=\"M6 13v4\" />"),
    PLUG(
        "plug",
        "<path d=\"M12 22v-5\" />\n  <path d=\"M15 8V2\" />\n  <path d=\"M17 8a1 1 0 0 1 1 1v4a4 4 0 0 1-4 4h-4a4 4 0 0 1-4-4V9a1 1 0 0 1 1-1z\" />\n  <path d=\"M9 8V2\" />"),
    PLUG_2(
        "plug-2",
        "<path d=\"M9 2v6\" />\n  <path d=\"M15 2v6\" />\n  <path d=\"M12 17v5\" />\n  <path d=\"M5 8h14\" />\n  <path d=\"M6 11V8h12v3a6 6 0 1 1-12 0Z\" />"),
    PLUG_ZAP(
        "plug-zap",
        "<path d=\"M6.3 20.3a2.4 2.4 0 0 0 3.4 0L12 18l-6-6-2.3 2.3a2.4 2.4 0 0 0 0 3.4Z\" />\n  <path d=\"m2 22 3-3\" />\n  <path d=\"M7.5 13.5 10 11\" />\n  <path d=\"M10.5 16.5 13 14\" />\n  <path d=\"m18 3-4 4h6l-4 4\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M2 3h20\" />\n  <path d=\"M21 3v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V3\" />\n  <path d=\"m7 21 5-5 5 5\" />"),
    PRINTER(
        "printer",
        "<path d=\"M6 18H4a2 2 0 0 1-2-2v-5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M6 9V3a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6\" />\n  <rect x=\"6\" y=\"14\" width=\"12\" height=\"8\" rx=\"1\" />"),
    PRINTER_3D(
        "printer-3d",
        "<path d=\"M10 11v1\" />\n  <path d=\"M12 8h8\" />\n  <path d=\"M15 20v-3a1 1 0 00-1-1H9a1 1 0 00-1 1v3\" />\n  <path d=\"M4 20h16\" />\n  <path d=\"M4 22V4a2 2 0 012-2h12a2 2 0 012 2v18\" />\n  <path d=\"M4 8h4\" />\n  <path d=\"M8.635 10.093A2 2 0 018 8.631V7a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 01-.293.707l-1 1a1 1 0 01-1.414 0z\" />"),
    PRINTER_CHECK(
        "printer-check",
        "<path d=\"M13.5 22H7a1 1 0 0 1-1-1v-6a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v.5\" />\n  <path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M6 18H4a2 2 0 0 1-2-2v-5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v2\" />\n  <path d=\"M6 9V3a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6\" />"),
    PRINTER_X(
        "printer-x",
        "<path d=\"M12.531 22H7a1 1 0 0 1-1-1v-6a1 1 0 0 1 1-1h6.377\" />\n  <path d=\"m16.5 16.5 5 5\" />\n  <path d=\"m16.5 21.5 5-5\" />\n  <path d=\"M6 18H4a2 2 0 0 1-2-2v-5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v1.5\" />\n  <path d=\"M6 9V3a1 1 0 0 1 1-1h10a1 1 0 0 1 1 1v6\" />"),
    PROJECTOR(
        "projector",
        "<path d=\"M5 7 3 5\" />\n  <path d=\"M9 6V3\" />\n  <path d=\"m13 7 2-2\" />\n  <circle cx=\"9\" cy=\"13\" r=\"3\" />\n  <path d=\"M11.83 12H20a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h2.17\" />\n  <path d=\"M16 16h2\" />"),
    PROPORTIONS(
        "proportions",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M12 9v11\" />\n  <path d=\"M2 9h13a2 2 0 0 1 2 2v9\" />"),
    RADIO(
        "radio",
        "<path d=\"M16.247 7.761a6 6 0 0 1 0 8.478\" />\n  <path d=\"M19.075 4.933a10 10 0 0 1 0 14.134\" />\n  <path d=\"M4.925 19.067a10 10 0 0 1 0-14.134\" />\n  <path d=\"M7.753 16.239a6 6 0 0 1 0-8.478\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    RADIO_OFF(
        "radio-off",
        "<path d=\"M13.414 13.414a2 2 0 1 1-2.828-2.828\" />\n  <path d=\"M16.247 7.761a6 6 0 0 1 1.744 4.572\" />\n  <path d=\"M19.075 4.933a10 10 0 0 1 2.234 10.72\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M4.925 19.067a10 10 0 0 1 0-14.134\" />\n  <path d=\"M7.753 16.239a6 6 0 0 1 0-8.478\" />"),
    RADIO_RECEIVER(
        "radio-receiver",
        "<path d=\"M5 16v2\" />\n  <path d=\"M19 16v2\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"8\" rx=\"2\" />\n  <path d=\"M18 12h.01\" />"),
    RADIO_TOWER(
        "radio-tower",
        "<path d=\"M4.9 16.1C1 12.2 1 5.8 4.9 1.9\" />\n  <path d=\"M7.8 4.7a6.14 6.14 0 0 0-.8 7.5\" />\n  <circle cx=\"12\" cy=\"9\" r=\"2\" />\n  <path d=\"M16.2 4.8c2 2 2.26 5.11.8 7.47\" />\n  <path d=\"M19.1 1.9a9.96 9.96 0 0 1 0 14.1\" />\n  <path d=\"M9.5 18h5\" />\n  <path d=\"m8 22 4-11 4 11\" />"),
    RECTANGLE_GOGGLES(
        "rectangle-goggles",
        "<path d=\"M20 6a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-4a2 2 0 0 1-1.6-.8l-1.6-2.13a1 1 0 0 0-1.6 0L9.6 17.2A2 2 0 0 1 8 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2z\" />"),
    ROBOT_VACUUM(
        "robot-vacuum",
        "<path d=\"M11 17h2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M17 12a5 5 0 00-10 0\" />\n  <path d=\"M19 2v2.8\" />\n  <path d=\"M2 5h2.8\" />\n  <path d=\"M22 5h-2.8\" />\n  <path d=\"M5 2v2.8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    ROUTER(
        "router",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6.01 18H6\" />\n  <path d=\"M10.01 18H10\" />\n  <path d=\"M15 10v4\" />\n  <path d=\"M17.84 7.17a4 4 0 0 0-5.66 0\" />\n  <path d=\"M20.66 4.34a8 8 0 0 0-11.31 0\" />"),
    SATELLITE_DISH(
        "satellite-dish",
        "<path d=\"M18 12a6 6 0 00-6-6\" />\n  <path d=\"M2.824 10.459a8 8 0 0010.717 10.717c.558-.276.623-1.012.183-1.452l-9.448-9.448c-.44-.44-1.176-.375-1.452.183\" />\n  <path d=\"M22 12A10 10 0 0012 2\" />\n  <path d=\"m9 15 4-4\" />"),
    SCAN(
        "scan",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />"),
    SCAN_BARCODE(
        "scan-barcode",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M8 7v10\" />\n  <path d=\"M12 7v10\" />\n  <path d=\"M17 7v10\" />"),
    SCAN_BOX(
        "scan-box",
        "<path d=\"M12 12v5.5\" />\n  <path d=\"M17 3h2a2 2 0 012 2v2\" />\n  <path d=\"M21 17v2a2 2 0 01-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 012-2h2\" />\n  <path d=\"M7 21H5a2 2 0 01-2-2v-2\" />\n  <path d=\"M7.264 9.252 12 12l4.737-2.748\" />\n  <path d=\"M7.995 8.514A2 2 0 007 10.244v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0017 13.76v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />"),
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    SCAN_FACE(
        "scan-face",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M8 14s1.5 2 4 2 4-2 4-2\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 9h.01\" />"),
    SCAN_LINE(
        "scan-line",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M7 12h10\" />"),
    SCAN_QR_CODE(
        "scan-qr-code",
        "<path d=\"M17 12v4a1 1 0 0 1-1 1h-4\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 8V7\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M7 17h.01\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect x=\"7\" y=\"7\" width=\"5\" height=\"5\" rx=\"1\" />"),
    SCAN_TEXT(
        "scan-text",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M7 8h8\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h6\" />"),
    SCREEN_SHARE(
        "screen-share",
        "<path d=\"M13 3H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"m17 8 5-5\" />\n  <path d=\"M17 3h5v5\" />"),
    SCREEN_SHARE_OFF(
        "screen-share-off",
        "<path d=\"M13 3H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"m22 3-5 5\" />\n  <path d=\"m17 3 5 5\" />"),
    SERVER(
        "server",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" ry=\"2\" />\n  <line x1=\"6\" x2=\"6.01\" y1=\"6\" y2=\"6\" />\n  <line x1=\"6\" x2=\"6.01\" y1=\"18\" y2=\"18\" />"),
    SERVER_COG(
        "server-cog",
        "<path d=\"m10.852 14.772-.383.923\" />\n  <path d=\"M13.148 14.772a3 3 0 1 0-2.296-5.544l-.383-.923\" />\n  <path d=\"m13.148 9.228.383-.923\" />\n  <path d=\"m13.53 15.696-.382-.924a3 3 0 1 1-2.296-5.544\" />\n  <path d=\"m14.772 10.852.923-.383\" />\n  <path d=\"m14.772 13.148.923.383\" />\n  <path d=\"M4.5 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-.5\" />\n  <path d=\"M4.5 14H4a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-.5\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M6 6h.01\" />\n  <path d=\"m9.228 10.852-.923-.383\" />\n  <path d=\"m9.228 13.148-.923.383\" />"),
    SERVER_CRASH(
        "server-crash",
        "<path d=\"M6 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M6 14H4a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-4a2 2 0 0 0-2-2h-2\" />\n  <path d=\"M6 6h.01\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"m13 6-4 6h6l-4 6\" />"),
    SERVER_NAS(
        "server-nas",
        "<path d=\"M10 16V8\" />\n  <path d=\"M14 16V8\" />\n  <path d=\"M18 16V8\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M6 16h.01\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    SERVER_OFF(
        "server-off",
        "<path d=\"M7 2h13a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2h-5\" />\n  <path d=\"M10 10 2.5 2.5C2 2 2 2.5 2 5v3a2 2 0 0 0 2 2h6z\" />\n  <path d=\"M22 17v-1a2 2 0 0 0-2-2h-1\" />\n  <path d=\"M4 14a2 2 0 0 0-2 2v4a2 2 0 0 0 2 2h16.5l1-.5.5.5-8-8H4z\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"m2 2 20 20\" />"),
    SERVER_PLUS(
        "server-plus",
        "<path d=\"M12.5 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 12h6\" />\n  <path d=\"M19 9v6\" />\n  <path d=\"M22 18v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h8.5\" />\n  <path d=\"M6 18h.01\" />\n  <path d=\"M6 6h.01\" />"),
    SMARTPHONE(
        "smartphone",
        "<rect width=\"14\" height=\"20\" x=\"5\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <path d=\"M12 18h.01\" />"),
    SMARTPHONE_CHARGING(
        "smartphone-charging",
        "<rect width=\"14\" height=\"20\" x=\"5\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <path d=\"M12.667 8 10 12h4l-2.667 4\" />"),
    SMARTPHONE_NFC(
        "smartphone-nfc",
        "<rect width=\"7\" height=\"12\" x=\"2\" y=\"6\" rx=\"1\" />\n  <path d=\"M13 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M16.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M19.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />"),
    SMARTPHONE_USER_ROUND(
        "smartphone-user-round",
        "<path d=\"M10 22H6a2 2 0 01-2-2V4a2 2 0 012-2h10a2 2 0 012 2v4\" />\n  <path d=\"M11 18h.01\" />\n  <path d=\"M22 22a4 4 0 00-8 0\" />\n  <circle cx=\"18\" cy=\"15\" r=\"3\" />"),
    SPEAKER(
        "speaker",
        "<rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M12 6h.01\" />\n  <circle cx=\"12\" cy=\"14\" r=\"4\" />\n  <path d=\"M12 14h.01\" />"),
    SPOTLIGHT(
        "spotlight",
        "<path d=\"M15.295 19.562 16 22\" />\n  <path d=\"m17 16 3.758 2.098\" />\n  <path d=\"m19 12.5 3.026-.598\" />\n  <path d=\"M7.61 6.3a3 3 0 0 0-3.92 1.3l-1.38 2.79a3 3 0 0 0 1.3 3.91l6.89 3.597a1 1 0 0 0 1.342-.447l3.106-6.211a1 1 0 0 0-.447-1.341z\" />\n  <path d=\"M8 9V2\" />"),
    SQUARE_MINUS(
        "square-minus",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 12h8\" />"),
    SWITCH_CAMERA(
        "switch-camera",
        "<path d=\"M11 19H4a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h5\" />\n  <path d=\"M13 5h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"m18 22-3-3 3-3\" />\n  <path d=\"m6 2 3 3-3 3\" />"),
    TABLET(
        "tablet",
        "<rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"18\" y2=\"18\" />"),
    TABLET_SMARTPHONE(
        "tablet-smartphone",
        "<rect width=\"10\" height=\"14\" x=\"3\" y=\"8\" rx=\"2\" />\n  <path d=\"M5 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v16a2 2 0 0 1-2 2h-2.4\" />\n  <path d=\"M8 18h.01\" />"),
    TOILET(
        "toilet",
        "<path d=\"M7 12h13a1 1 0 0 1 1 1 5 5 0 0 1-5 5h-.598a.5.5 0 0 0-.424.765l1.544 2.47a.5.5 0 0 1-.424.765H5.402a.5.5 0 0 1-.424-.765L7 18\" />\n  <path d=\"M8 18a5 5 0 0 1-5-5V4a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v8\" />"),
    TOUCHPAD(
        "touchpad",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 14h20\" />\n  <path d=\"M12 20v-6\" />"),
    TOUCHPAD_OFF(
        "touchpad-off",
        "<path d=\"M12 20v-6\" />\n  <path d=\"M19.656 14H22\" />\n  <path d=\"M2 14h12\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20H4a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2\" />\n  <path d=\"M9.656 4H20a2 2 0 0 1 2 2v10.344\" />"),
    TV(
        "tv",
        "<path d=\"m17 2-5 5-5-5\" />\n  <rect width=\"20\" height=\"15\" x=\"2\" y=\"7\" rx=\"2\" />"),
    TV_MINIMAL(
        "tv-minimal",
        "<path d=\"M7 21h10\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />"),
    TV_MINIMAL_PLAY(
        "tv-minimal-play",
        "<path d=\"M15.033 9.44a.647.647 0 0 1 0 1.12l-4.065 2.352a.645.645 0 0 1-.968-.56V7.648a.645.645 0 0 1 .967-.56z\" />\n  <path d=\"M7 21h10\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />"),
    UNPLUG(
        "unplug",
        "<path d=\"m19 5 3-3\" />\n  <path d=\"m2 22 3-3\" />\n  <path d=\"M6.3 20.3a2.4 2.4 0 0 0 3.4 0L12 18l-6-6-2.3 2.3a2.4 2.4 0 0 0 0 3.4Z\" />\n  <path d=\"M7.5 13.5 10 11\" />\n  <path d=\"M10.5 16.5 13 14\" />\n  <path d=\"m12 6 6 6 2.3-2.3a2.4 2.4 0 0 0 0-3.4l-2.6-2.6a2.4 2.4 0 0 0-3.4 0Z\" />"),
    USB(
        "usb",
        "<circle cx=\"10\" cy=\"7\" r=\"1\" />\n  <circle cx=\"4\" cy=\"20\" r=\"1\" />\n  <path d=\"M4.7 19.3 19 5\" />\n  <path d=\"m21 3-3 1 2 2Z\" />\n  <path d=\"M9.26 7.68 5 12l2 5\" />\n  <path d=\"m10 14 5 2 3.5-3.5\" />\n  <path d=\"m18 12 1-1 1 1-1 1Z\" />"),
    USB_C_PORT(
        "usb-c-port",
        "<path d=\"M6 12h12\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"8\" rx=\"4\" />"),
    VIBRATE(
        "vibrate",
        "<path d=\"m2 8 2 2-2 2 2 2-2 2\" />\n  <path d=\"m22 8-2 2 2 2-2 2 2 2\" />\n  <rect width=\"8\" height=\"14\" x=\"8\" y=\"5\" rx=\"1\" />"),
    VIBRATE_OFF(
        "vibrate-off",
        "<path d=\"m2 8 2 2-2 2 2 2-2 2\" />\n  <path d=\"m22 8-2 2 2 2-2 2 2 2\" />\n  <path d=\"M8 8v10c0 .55.45 1 1 1h6c.55 0 1-.45 1-1v-2\" />\n  <path d=\"M16 10.34V6c0-.55-.45-1-1-1h-4.34\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    VIDEO(
        "video",
        "<path d=\"m16 13 5.223 3.482a.5.5 0 0 0 .777-.416V7.87a.5.5 0 0 0-.752-.432L16 10.5\" />\n  <rect x=\"2\" y=\"6\" width=\"14\" height=\"12\" rx=\"2\" />"),
    VIDEO_OFF(
        "video-off",
        "<path d=\"M10.66 6H14a2 2 0 0 1 2 2v2.5l5.248-3.062A.5.5 0 0 1 22 7.87v8.196\" />\n  <path d=\"M16 16a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2\" />\n  <path d=\"m2 2 20 20\" />"),
    VIDEOTAPE(
        "videotape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 8h20\" />\n  <circle cx=\"8\" cy=\"14\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"14\" r=\"2\" />"),
    VOICEMAIL(
        "voicemail",
        "<circle cx=\"6\" cy=\"12\" r=\"4\" />\n  <circle cx=\"18\" cy=\"12\" r=\"4\" />\n  <line x1=\"6\" x2=\"18\" y1=\"16\" y2=\"16\" />"),
    WALLPAPER(
        "wallpaper",
        "<path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"m9 17 6.1-6.1a2 2 0 0 1 2.81.01L22 15\" />\n  <circle cx=\"8\" cy=\"9\" r=\"2\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />"),
    WASHING_MACHINE(
        "washing-machine",
        "<path d=\"M3 6h3\" />\n  <path d=\"M17 6h.01\" />\n  <rect width=\"18\" height=\"20\" x=\"3\" y=\"2\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"13\" r=\"5\" />\n  <path d=\"M12 18a2.5 2.5 0 0 0 0-5 2.5 2.5 0 0 1 0-5\" />"),
    WEBCAM(
        "webcam",
        "<circle cx=\"12\" cy=\"10\" r=\"8\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <path d=\"M7 22h10\" />\n  <path d=\"M12 22v-4\" />"),
    WEBCAM_OFF(
        "webcam-off",
        "<path d=\"M12 22v-4\" />\n  <path d=\"M12.754 7.096a3 3 0 0 1 2.15 2.15\" />\n  <path d=\"M12.863 12.873a3 3 0 0 1-3.736-3.735\" />\n  <path d=\"M16.566 16.57A8 8 0 0 1 5.43 5.433\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7 22h10\" />\n  <path d=\"M8.478 2.817a8 8 0 0 1 10.705 10.705\" />"),
    WIFI(
        "wifi",
        "<path d=\"M12 20h.01\" />\n  <path d=\"M2 8.82a15 15 0 0 1 20 0\" />\n  <path d=\"M5 12.859a10 10 0 0 1 14 0\" />\n  <path d=\"M8.5 16.429a5 5 0 0 1 7 0\" />"),
    WIFI_COG(
        "wifi-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.228 16.852-.923-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.772-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.696-.382-.924\" />\n  <path d=\"M2 8.82a15 15 0 0120 0\" />\n  <path d=\"m20.772 16.852.924-.383\" />\n  <path d=\"m20.772 19.148.924.383\" />\n  <path d=\"M5 12.859a10 10 0 0110.18-2.342\" />\n  <path d=\"M8.5 16.429a5 5 0 011.998-1.2\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    WIFI_HIGH(
        "wifi-high",
        "<path d=\"M12 20h.01\" />\n  <path d=\"M5 12.859a10 10 0 0 1 14 0\" />\n  <path d=\"M8.5 16.429a5 5 0 0 1 7 0\" />"),
    WIFI_LOCK(
        "wifi-lock",
        "<path d=\"M2 8.82a15 15 0 0120 0\" />\n  <path d=\"M20 16v-2a2 2 0 00-4 0v2\" />\n  <path d=\"M5 12.859a10 10 0 018.436-2.756\" />\n  <path d=\"M8.5 16.429a5 5 0 011.794-1.13\" />\n  <rect x=\"14\" y=\"16\" width=\"8\" height=\"5\" rx=\"1\" />"),
    WIFI_LOW("wifi-low", "<path d=\"M12 20h.01\" />\n  <path d=\"M8.5 16.429a5 5 0 0 1 7 0\" />"),
    WIFI_OFF(
        "wifi-off",
        "<path d=\"M12 20h.01\" />\n  <path d=\"M8.5 16.429a5 5 0 0 1 7 0\" />\n  <path d=\"M5 12.859a10 10 0 0 1 5.17-2.69\" />\n  <path d=\"M19 12.859a10 10 0 0 0-2.007-1.523\" />\n  <path d=\"M2 8.82a15 15 0 0 1 4.177-2.643\" />\n  <path d=\"M22 8.82a15 15 0 0 0-11.288-3.764\" />\n  <path d=\"m2 2 20 20\" />"),
    WIFI_PEN(
        "wifi-pen",
        "<path d=\"M2 8.82a15 15 0 0 1 20 0\" />\n  <path d=\"M21.378 16.626a1 1 0 0 0-3.004-3.004l-4.01 4.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />\n  <path d=\"M5 12.859a10 10 0 0 1 10.5-2.222\" />\n  <path d=\"M8.5 16.429a5 5 0 0 1 3-1.406\" />"),
    WIFI_SYNC(
        "wifi-sync",
        "<path d=\"M11.965 10.105v4L13.5 12.5a5 5 0 0 1 8 1.5\" />\n  <path d=\"M11.965 14.105h4\" />\n  <path d=\"M17.965 18.105h4L20.43 19.71a5 5 0 0 1-8-1.5\" />\n  <path d=\"M2 8.82a15 15 0 0 1 20 0\" />\n  <path d=\"M21.965 22.105v-4\" />\n  <path d=\"M5 12.86a10 10 0 0 1 3-2.032\" />\n  <path d=\"M8.5 16.429h.01\" />"),
    WIFI_ZERO("wifi-zero", "<path d=\"M12 20h.01\" />"),
    ZAP(
        "zap",
        "<path d=\"M15.914 4a1.5 1.5 0 00-2.474-1.561l-9 9A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l9-9A1.5 1.5 0 0018.5 10h-3.997a.5.5 0 01-.472-.667z\" />"),
    ZAP_OFF(
        "zap-off",
        "<path d=\"M10.768 5.111 13.44 2.44a1.5 1.5 0 012.474 1.561l-1.633 4.625\" />\n  <path d=\"m18.889 13.232.672-.672A1.5 1.5 0 0018.5 10h-2.844\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m7.94 7.94-3.5 3.499A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l5.5-5.5\" />");

    private final String catalogName;
    private final String svg;

    Icon(String catalogName, String svg) {
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

  // Icon factories for this category.
  default LucideIcon alarm_clock_devices() {
    return LucideIcon.create(Icon.ALARM_CLOCK);
  }

  default LucideIcon alarm_clock_check_devices() {
    return LucideIcon.create(Icon.ALARM_CLOCK_CHECK);
  }

  default LucideIcon alarm_clock_minus_devices() {
    return LucideIcon.create(Icon.ALARM_CLOCK_MINUS);
  }

  default LucideIcon alarm_clock_off_devices() {
    return LucideIcon.create(Icon.ALARM_CLOCK_OFF);
  }

  default LucideIcon alarm_clock_plus_devices() {
    return LucideIcon.create(Icon.ALARM_CLOCK_PLUS);
  }

  default LucideIcon alarm_smoke_devices() {
    return LucideIcon.create(Icon.ALARM_SMOKE);
  }

  default LucideIcon antenna_devices() {
    return LucideIcon.create(Icon.ANTENNA);
  }

  default LucideIcon battery_devices() {
    return LucideIcon.create(Icon.BATTERY);
  }

  default LucideIcon battery_charging_devices() {
    return LucideIcon.create(Icon.BATTERY_CHARGING);
  }

  default LucideIcon battery_full_devices() {
    return LucideIcon.create(Icon.BATTERY_FULL);
  }

  default LucideIcon battery_low_devices() {
    return LucideIcon.create(Icon.BATTERY_LOW);
  }

  default LucideIcon battery_medium_devices() {
    return LucideIcon.create(Icon.BATTERY_MEDIUM);
  }

  default LucideIcon battery_plus() {
    return LucideIcon.create(Icon.BATTERY_PLUS);
  }

  default LucideIcon battery_warning_devices() {
    return LucideIcon.create(Icon.BATTERY_WARNING);
  }

  default LucideIcon bell_electric_devices() {
    return LucideIcon.create(Icon.BELL_ELECTRIC);
  }

  default LucideIcon bluetooth_devices() {
    return LucideIcon.create(Icon.BLUETOOTH);
  }

  default LucideIcon bluetooth_connected_devices() {
    return LucideIcon.create(Icon.BLUETOOTH_CONNECTED);
  }

  default LucideIcon bluetooth_off_devices() {
    return LucideIcon.create(Icon.BLUETOOTH_OFF);
  }

  default LucideIcon bluetooth_searching_devices() {
    return LucideIcon.create(Icon.BLUETOOTH_SEARCHING);
  }

  default LucideIcon boom_box_devices() {
    return LucideIcon.create(Icon.BOOM_BOX);
  }

  default LucideIcon cable_devices() {
    return LucideIcon.create(Icon.CABLE);
  }

  default LucideIcon calculator_devices() {
    return LucideIcon.create(Icon.CALCULATOR);
  }

  default LucideIcon camera_devices() {
    return LucideIcon.create(Icon.CAMERA);
  }

  default LucideIcon camera_off_devices() {
    return LucideIcon.create(Icon.CAMERA_OFF);
  }

  default LucideIcon card_sim_devices() {
    return LucideIcon.create(Icon.CARD_SIM);
  }

  default LucideIcon cassette_tape_devices() {
    return LucideIcon.create(Icon.CASSETTE_TAPE);
  }

  default LucideIcon cast_devices() {
    return LucideIcon.create(Icon.CAST);
  }

  default LucideIcon cctv_devices() {
    return LucideIcon.create(Icon.CCTV);
  }

  default LucideIcon cctv_off_devices() {
    return LucideIcon.create(Icon.CCTV_OFF);
  }

  default LucideIcon chevrons_left_right_ellipsis_devices() {
    return LucideIcon.create(Icon.CHEVRONS_LEFT_RIGHT_ELLIPSIS);
  }

  default LucideIcon computer_devices() {
    return LucideIcon.create(Icon.COMPUTER);
  }

  default LucideIcon cpu() {
    return LucideIcon.create(Icon.CPU);
  }

  default LucideIcon cpu_ai_devices() {
    return LucideIcon.create(Icon.CPU_AI);
  }

  default LucideIcon database_devices() {
    return LucideIcon.create(Icon.DATABASE);
  }

  default LucideIcon database_arrow_down_devices() {
    return LucideIcon.create(Icon.DATABASE_ARROW_DOWN);
  }

  default LucideIcon database_arrow_up_devices() {
    return LucideIcon.create(Icon.DATABASE_ARROW_UP);
  }

  default LucideIcon database_backup_devices() {
    return LucideIcon.create(Icon.DATABASE_BACKUP);
  }

  default LucideIcon database_check_devices() {
    return LucideIcon.create(Icon.DATABASE_CHECK);
  }

  default LucideIcon database_minus_devices() {
    return LucideIcon.create(Icon.DATABASE_MINUS);
  }

  default LucideIcon database_plus_devices() {
    return LucideIcon.create(Icon.DATABASE_PLUS);
  }

  default LucideIcon database_search_devices() {
    return LucideIcon.create(Icon.DATABASE_SEARCH);
  }

  default LucideIcon database_x_devices() {
    return LucideIcon.create(Icon.DATABASE_X);
  }

  default LucideIcon database_zap_devices() {
    return LucideIcon.create(Icon.DATABASE_ZAP);
  }

  default LucideIcon diamond_minus_devices() {
    return LucideIcon.create(Icon.DIAMOND_MINUS);
  }

  default LucideIcon diamond_plus_devices() {
    return LucideIcon.create(Icon.DIAMOND_PLUS);
  }

  default LucideIcon disc_devices() {
    return LucideIcon.create(Icon.DISC);
  }

  default LucideIcon disc_2_devices() {
    return LucideIcon.create(Icon.DISC_2);
  }

  default LucideIcon disc_3_devices() {
    return LucideIcon.create(Icon.DISC_3);
  }

  default LucideIcon disc_album_devices() {
    return LucideIcon.create(Icon.DISC_ALBUM);
  }

  default LucideIcon drill_devices() {
    return LucideIcon.create(Icon.DRILL);
  }

  default LucideIcon drone_devices() {
    return LucideIcon.create(Icon.DRONE);
  }

  default LucideIcon drum_devices() {
    return LucideIcon.create(Icon.DRUM);
  }

  default LucideIcon earth_lock_devices() {
    return LucideIcon.create(Icon.EARTH_LOCK);
  }

  default LucideIcon eject_devices() {
    return LucideIcon.create(Icon.EJECT);
  }

  default LucideIcon ethernet_port_devices() {
    return LucideIcon.create(Icon.ETHERNET_PORT);
  }

  default LucideIcon fingerprint_pattern_devices() {
    return LucideIcon.create(Icon.FINGERPRINT_PATTERN);
  }

  default LucideIcon flashlight_devices() {
    return LucideIcon.create(Icon.FLASHLIGHT);
  }

  default LucideIcon flashlight_off_devices() {
    return LucideIcon.create(Icon.FLASHLIGHT_OFF);
  }

  default LucideIcon gamepad_devices() {
    return LucideIcon.create(Icon.GAMEPAD);
  }

  default LucideIcon gamepad_2_devices() {
    return LucideIcon.create(Icon.GAMEPAD_2);
  }

  default LucideIcon gamepad_directional_devices() {
    return LucideIcon.create(Icon.GAMEPAD_DIRECTIONAL);
  }

  default LucideIcon globe_lock_devices() {
    return LucideIcon.create(Icon.GLOBE_LOCK);
  }

  default LucideIcon globe_off_devices() {
    return LucideIcon.create(Icon.GLOBE_OFF);
  }

  default LucideIcon globe_x_devices() {
    return LucideIcon.create(Icon.GLOBE_X);
  }

  default LucideIcon gpu_devices() {
    return LucideIcon.create(Icon.GPU);
  }

  default LucideIcon hard_drive_devices() {
    return LucideIcon.create(Icon.HARD_DRIVE);
  }

  default LucideIcon hard_drive_download_devices() {
    return LucideIcon.create(Icon.HARD_DRIVE_DOWNLOAD);
  }

  default LucideIcon hard_drive_upload_devices() {
    return LucideIcon.create(Icon.HARD_DRIVE_UPLOAD);
  }

  default LucideIcon hd_devices() {
    return LucideIcon.create(Icon.HD);
  }

  default LucideIcon hdmi_port_devices() {
    return LucideIcon.create(Icon.HDMI_PORT);
  }

  default LucideIcon headphone_off_devices() {
    return LucideIcon.create(Icon.HEADPHONE_OFF);
  }

  default LucideIcon headphones_devices() {
    return LucideIcon.create(Icon.HEADPHONES);
  }

  default LucideIcon headset_devices() {
    return LucideIcon.create(Icon.HEADSET);
  }

  default LucideIcon heater_devices() {
    return LucideIcon.create(Icon.HEATER);
  }

  default LucideIcon joystick_devices() {
    return LucideIcon.create(Icon.JOYSTICK);
  }

  default LucideIcon keyboard_devices() {
    return LucideIcon.create(Icon.KEYBOARD);
  }

  default LucideIcon keyboard_music_devices() {
    return LucideIcon.create(Icon.KEYBOARD_MUSIC);
  }

  default LucideIcon keyboard_off_devices() {
    return LucideIcon.create(Icon.KEYBOARD_OFF);
  }

  default LucideIcon laptop() {
    return LucideIcon.create(Icon.LAPTOP);
  }

  default LucideIcon laptop_minimal() {
    return LucideIcon.create(Icon.LAPTOP_MINIMAL);
  }

  default LucideIcon laptop_minimal_check_devices() {
    return LucideIcon.create(Icon.LAPTOP_MINIMAL_CHECK);
  }

  default LucideIcon memory_stick_devices() {
    return LucideIcon.create(Icon.MEMORY_STICK);
  }

  default LucideIcon mic_devices() {
    return LucideIcon.create(Icon.MIC);
  }

  default LucideIcon mic_audio_lines_devices() {
    return LucideIcon.create(Icon.MIC_AUDIO_LINES);
  }

  default LucideIcon mic_off_devices() {
    return LucideIcon.create(Icon.MIC_OFF);
  }

  default LucideIcon mic_signal_devices() {
    return LucideIcon.create(Icon.MIC_SIGNAL);
  }

  default LucideIcon mic_vocal_devices() {
    return LucideIcon.create(Icon.MIC_VOCAL);
  }

  default LucideIcon microchip() {
    return LucideIcon.create(Icon.MICROCHIP);
  }

  default LucideIcon midi_port_devices() {
    return LucideIcon.create(Icon.MIDI_PORT);
  }

  default LucideIcon monitor_devices() {
    return LucideIcon.create(Icon.MONITOR);
  }

  default LucideIcon monitor_check_devices() {
    return LucideIcon.create(Icon.MONITOR_CHECK);
  }

  default LucideIcon monitor_cloud_devices() {
    return LucideIcon.create(Icon.MONITOR_CLOUD);
  }

  default LucideIcon monitor_cog_devices() {
    return LucideIcon.create(Icon.MONITOR_COG);
  }

  default LucideIcon monitor_dot_devices() {
    return LucideIcon.create(Icon.MONITOR_DOT);
  }

  default LucideIcon monitor_down_devices() {
    return LucideIcon.create(Icon.MONITOR_DOWN);
  }

  default LucideIcon monitor_off_devices() {
    return LucideIcon.create(Icon.MONITOR_OFF);
  }

  default LucideIcon monitor_pause_devices() {
    return LucideIcon.create(Icon.MONITOR_PAUSE);
  }

  default LucideIcon monitor_pc_devices() {
    return LucideIcon.create(Icon.MONITOR_PC);
  }

  default LucideIcon monitor_play_devices() {
    return LucideIcon.create(Icon.MONITOR_PLAY);
  }

  default LucideIcon monitor_smartphone_devices() {
    return LucideIcon.create(Icon.MONITOR_SMARTPHONE);
  }

  default LucideIcon monitor_speaker_devices() {
    return LucideIcon.create(Icon.MONITOR_SPEAKER);
  }

  default LucideIcon monitor_stop_devices() {
    return LucideIcon.create(Icon.MONITOR_STOP);
  }

  default LucideIcon monitor_up_devices() {
    return LucideIcon.create(Icon.MONITOR_UP);
  }

  default LucideIcon monitor_x_devices() {
    return LucideIcon.create(Icon.MONITOR_X);
  }

  default LucideIcon mouse() {
    return LucideIcon.create(Icon.MOUSE);
  }

  default LucideIcon mouse_left() {
    return LucideIcon.create(Icon.MOUSE_LEFT);
  }

  default LucideIcon mouse_off() {
    return LucideIcon.create(Icon.MOUSE_OFF);
  }

  default LucideIcon mouse_right() {
    return LucideIcon.create(Icon.MOUSE_RIGHT);
  }

  default LucideIcon nfc_devices() {
    return LucideIcon.create(Icon.NFC);
  }

  default LucideIcon pc_case_devices() {
    return LucideIcon.create(Icon.PC_CASE);
  }

  default LucideIcon phone_devices() {
    return LucideIcon.create(Icon.PHONE);
  }

  default LucideIcon phone_call_devices() {
    return LucideIcon.create(Icon.PHONE_CALL);
  }

  default LucideIcon phone_forwarded_devices() {
    return LucideIcon.create(Icon.PHONE_FORWARDED);
  }

  default LucideIcon phone_incoming_devices() {
    return LucideIcon.create(Icon.PHONE_INCOMING);
  }

  default LucideIcon phone_missed_devices() {
    return LucideIcon.create(Icon.PHONE_MISSED);
  }

  default LucideIcon phone_off_devices() {
    return LucideIcon.create(Icon.PHONE_OFF);
  }

  default LucideIcon phone_outgoing_devices() {
    return LucideIcon.create(Icon.PHONE_OUTGOING);
  }

  default LucideIcon piano_devices() {
    return LucideIcon.create(Icon.PIANO);
  }

  default LucideIcon plug_devices() {
    return LucideIcon.create(Icon.PLUG);
  }

  default LucideIcon plug_2_devices() {
    return LucideIcon.create(Icon.PLUG_2);
  }

  default LucideIcon plug_zap() {
    return LucideIcon.create(Icon.PLUG_ZAP);
  }

  default LucideIcon presentation_devices() {
    return LucideIcon.create(Icon.PRESENTATION);
  }

  default LucideIcon printer() {
    return LucideIcon.create(Icon.PRINTER);
  }

  default LucideIcon printer_3d_devices() {
    return LucideIcon.create(Icon.PRINTER_3D);
  }

  default LucideIcon printer_check() {
    return LucideIcon.create(Icon.PRINTER_CHECK);
  }

  default LucideIcon printer_x() {
    return LucideIcon.create(Icon.PRINTER_X);
  }

  default LucideIcon projector_devices() {
    return LucideIcon.create(Icon.PROJECTOR);
  }

  default LucideIcon proportions_devices() {
    return LucideIcon.create(Icon.PROPORTIONS);
  }

  default LucideIcon radio_devices() {
    return LucideIcon.create(Icon.RADIO);
  }

  default LucideIcon radio_off_devices() {
    return LucideIcon.create(Icon.RADIO_OFF);
  }

  default LucideIcon radio_receiver() {
    return LucideIcon.create(Icon.RADIO_RECEIVER);
  }

  default LucideIcon radio_tower_devices() {
    return LucideIcon.create(Icon.RADIO_TOWER);
  }

  default LucideIcon rectangle_goggles_devices() {
    return LucideIcon.create(Icon.RECTANGLE_GOGGLES);
  }

  default LucideIcon robot_vacuum_devices() {
    return LucideIcon.create(Icon.ROBOT_VACUUM);
  }

  default LucideIcon router_devices() {
    return LucideIcon.create(Icon.ROUTER);
  }

  default LucideIcon satellite_dish_devices() {
    return LucideIcon.create(Icon.SATELLITE_DISH);
  }

  default LucideIcon scan_devices() {
    return LucideIcon.create(Icon.SCAN);
  }

  default LucideIcon scan_barcode_devices() {
    return LucideIcon.create(Icon.SCAN_BARCODE);
  }

  default LucideIcon scan_box_devices() {
    return LucideIcon.create(Icon.SCAN_BOX);
  }

  default LucideIcon scan_eye_devices() {
    return LucideIcon.create(Icon.SCAN_EYE);
  }

  default LucideIcon scan_face_devices() {
    return LucideIcon.create(Icon.SCAN_FACE);
  }

  default LucideIcon scan_line_devices() {
    return LucideIcon.create(Icon.SCAN_LINE);
  }

  default LucideIcon scan_qr_code_devices() {
    return LucideIcon.create(Icon.SCAN_QR_CODE);
  }

  default LucideIcon scan_text_devices() {
    return LucideIcon.create(Icon.SCAN_TEXT);
  }

  default LucideIcon screen_share_devices() {
    return LucideIcon.create(Icon.SCREEN_SHARE);
  }

  default LucideIcon screen_share_off_devices() {
    return LucideIcon.create(Icon.SCREEN_SHARE_OFF);
  }

  default LucideIcon server_devices() {
    return LucideIcon.create(Icon.SERVER);
  }

  default LucideIcon server_cog_devices() {
    return LucideIcon.create(Icon.SERVER_COG);
  }

  default LucideIcon server_crash_devices() {
    return LucideIcon.create(Icon.SERVER_CRASH);
  }

  default LucideIcon server_nas_devices() {
    return LucideIcon.create(Icon.SERVER_NAS);
  }

  default LucideIcon server_off_devices() {
    return LucideIcon.create(Icon.SERVER_OFF);
  }

  default LucideIcon server_plus_devices() {
    return LucideIcon.create(Icon.SERVER_PLUS);
  }

  default LucideIcon smartphone_devices() {
    return LucideIcon.create(Icon.SMARTPHONE);
  }

  default LucideIcon smartphone_charging_devices() {
    return LucideIcon.create(Icon.SMARTPHONE_CHARGING);
  }

  default LucideIcon smartphone_nfc_devices() {
    return LucideIcon.create(Icon.SMARTPHONE_NFC);
  }

  default LucideIcon smartphone_user_round_devices() {
    return LucideIcon.create(Icon.SMARTPHONE_USER_ROUND);
  }

  default LucideIcon speaker_devices() {
    return LucideIcon.create(Icon.SPEAKER);
  }

  default LucideIcon spotlight_devices() {
    return LucideIcon.create(Icon.SPOTLIGHT);
  }

  default LucideIcon square_minus_devices() {
    return LucideIcon.create(Icon.SQUARE_MINUS);
  }

  default LucideIcon switch_camera_devices() {
    return LucideIcon.create(Icon.SWITCH_CAMERA);
  }

  default LucideIcon tablet() {
    return LucideIcon.create(Icon.TABLET);
  }

  default LucideIcon tablet_smartphone_devices() {
    return LucideIcon.create(Icon.TABLET_SMARTPHONE);
  }

  default LucideIcon toilet_devices() {
    return LucideIcon.create(Icon.TOILET);
  }

  default LucideIcon touchpad() {
    return LucideIcon.create(Icon.TOUCHPAD);
  }

  default LucideIcon touchpad_off() {
    return LucideIcon.create(Icon.TOUCHPAD_OFF);
  }

  default LucideIcon tv_devices() {
    return LucideIcon.create(Icon.TV);
  }

  default LucideIcon tv_minimal_devices() {
    return LucideIcon.create(Icon.TV_MINIMAL);
  }

  default LucideIcon tv_minimal_play_devices() {
    return LucideIcon.create(Icon.TV_MINIMAL_PLAY);
  }

  default LucideIcon unplug_devices() {
    return LucideIcon.create(Icon.UNPLUG);
  }

  default LucideIcon usb_devices() {
    return LucideIcon.create(Icon.USB);
  }

  default LucideIcon usb_c_port_devices() {
    return LucideIcon.create(Icon.USB_C_PORT);
  }

  default LucideIcon vibrate_devices() {
    return LucideIcon.create(Icon.VIBRATE);
  }

  default LucideIcon vibrate_off_devices() {
    return LucideIcon.create(Icon.VIBRATE_OFF);
  }

  default LucideIcon video_devices() {
    return LucideIcon.create(Icon.VIDEO);
  }

  default LucideIcon video_off_devices() {
    return LucideIcon.create(Icon.VIDEO_OFF);
  }

  default LucideIcon videotape_devices() {
    return LucideIcon.create(Icon.VIDEOTAPE);
  }

  default LucideIcon voicemail_devices() {
    return LucideIcon.create(Icon.VOICEMAIL);
  }

  default LucideIcon wallpaper_devices() {
    return LucideIcon.create(Icon.WALLPAPER);
  }

  default LucideIcon washing_machine_devices() {
    return LucideIcon.create(Icon.WASHING_MACHINE);
  }

  default LucideIcon webcam_devices() {
    return LucideIcon.create(Icon.WEBCAM);
  }

  default LucideIcon webcam_off_devices() {
    return LucideIcon.create(Icon.WEBCAM_OFF);
  }

  default LucideIcon wifi_devices() {
    return LucideIcon.create(Icon.WIFI);
  }

  default LucideIcon wifi_cog_devices() {
    return LucideIcon.create(Icon.WIFI_COG);
  }

  default LucideIcon wifi_high_devices() {
    return LucideIcon.create(Icon.WIFI_HIGH);
  }

  default LucideIcon wifi_lock_devices() {
    return LucideIcon.create(Icon.WIFI_LOCK);
  }

  default LucideIcon wifi_low_devices() {
    return LucideIcon.create(Icon.WIFI_LOW);
  }

  default LucideIcon wifi_off_devices() {
    return LucideIcon.create(Icon.WIFI_OFF);
  }

  default LucideIcon wifi_pen_devices() {
    return LucideIcon.create(Icon.WIFI_PEN);
  }

  default LucideIcon wifi_sync_devices() {
    return LucideIcon.create(Icon.WIFI_SYNC);
  }

  default LucideIcon wifi_zero_devices() {
    return LucideIcon.create(Icon.WIFI_ZERO);
  }

  default LucideIcon zap_devices() {
    return LucideIcon.create(Icon.ZAP);
  }

  default LucideIcon zap_off_devices() {
    return LucideIcon.create(Icon.ZAP_OFF);
  }
}
