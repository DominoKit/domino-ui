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

/** Lucide connectivity catalog category. */
public interface LucideConnectivity {
  enum Icon implements LucideIconDefinition {
    AIRPLAY(
        "airplay",
        "<path d=\"M5 17H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-1\" />\n  <path d=\"m12 15 5 6H7Z\" />"),
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
    BATTERY_WARNING(
        "battery-warning",
        "<path d=\"M10 17h.01\" />\n  <path d=\"M10 7v6\" />\n  <path d=\"M14 6h2a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M22 14v-4\" />\n  <path d=\"M6 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2\" />"),
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
    BOOK_USER(
        "book-user",
        "<path d=\"M15 13a3 3 0 1 0-6 0\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />"),
    BRICK_WALL_FIRE(
        "brick-wall-fire",
        "<path d=\"M16 3v2.107\" />\n  <path d=\"M17 9c1 3 2.5 3.5 3.5 4.5A5 5 0 0 1 22 17a5 5 0 0 1-10 0c0-.3 0-.6.1-.9a2 2 0 1 0 3.3-2C13 11.5 16 9 17 9\" />\n  <path d=\"M21 8.274V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h3.938\" />\n  <path d=\"M3 15h5.253\" />\n  <path d=\"M3 9h8.228\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BRICK_WALL_SHIELD(
        "brick-wall-shield",
        "<path d=\"M12 9v1.258\" />\n  <path d=\"M16 3v5.46\" />\n  <path d=\"M21 9.118V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h5.75\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <path d=\"M3 15h7\" />\n  <path d=\"M3 9h12.142\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    CABLE(
        "cable",
        "<path d=\"M17 19a1 1 0 0 1-1-1v-2a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2a1 1 0 0 1-1 1z\" />\n  <path d=\"M17 21v-2\" />\n  <path d=\"M19 14V6.5a1 1 0 0 0-7 0v11a1 1 0 0 1-7 0V10\" />\n  <path d=\"M21 21v-2\" />\n  <path d=\"M3 5V3\" />\n  <path d=\"M4 10a2 2 0 0 1-2-2V6a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2z\" />\n  <path d=\"M7 5V3\" />"),
    CAR_BATTERY(
        "car-battery",
        "<path d=\"M14 13h4\" />\n  <path d=\"M16 15v-4\" />\n  <path d=\"M18 5v2\" />\n  <path d=\"M6 13h4\" />\n  <path d=\"M6 5v2\" />\n  <rect x=\"2\" y=\"7\" width=\"20\" height=\"12\" rx=\"2\" />"),
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
    CERTIFICATE(
        "certificate",
        "<path d=\"M12 10H6\" />\n  <path d=\"m20.69 15.479 1.29 4.88a.5.5 0 01-.698.591l-1.843-.849a1 1 0 00-.879.001l-1.846.85a.5.5 0 01-.692-.593l1.29-4.88\" />\n  <path d=\"M22 6.675V6a2 2 0 00-2-2H4a2 2 0 00-2 2v12a2 2 0 002 2h8\" />\n  <path d=\"M6 14h4\" />\n  <circle cx=\"19\" cy=\"13\" r=\"3\" />"),
    CIRCLE_POWER(
        "circle-power",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M7.998 9.003a5 5 0 1 0 8-.005\" />"),
    CLOUD_OFF(
        "cloud-off",
        "<path d=\"M10.94 5.274A7 7 0 0 1 15.71 10h1.79a4.5 4.5 0 0 1 4.222 6.057\" />\n  <path d=\"M18.796 18.81A4.5 4.5 0 0 1 17.5 19H9A7 7 0 0 1 5.79 5.78\" />\n  <path d=\"m2 2 20 20\" />"),
    CONTACT(
        "contact",
        "<path d=\"M16 2v2\" />\n  <path d=\"M7 21v-2a2 2 0 012-2h6a2 2 0 012 2v2\" />\n  <path d=\"M8 2v2\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    CONTACT_ROUND(
        "contact-round",
        "<path d=\"M16 2v2\" />\n  <path d=\"M17.915 21a6 6 0 10-12 0\" />\n  <path d=\"M8 2v2\" />\n  <circle cx=\"12\" cy=\"11\" r=\"4\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    GLOBE_OFF(
        "globe-off",
        "<path d=\"M10.114 4.462A14.5 14.5 0 0 1 12 2a10 10 0 0 1 9.313 13.643\" />\n  <path d=\"M15.557 15.556A14.5 14.5 0 0 1 12 22 10 10 0 0 1 4.929 4.929\" />\n  <path d=\"M15.892 10.234A14.5 14.5 0 0 0 12 2a10 10 0 0 0-3.643.687\" />\n  <path d=\"M17.656 12H22\" />\n  <path d=\"M19.071 19.071A10 10 0 0 1 12 22 14.5 14.5 0 0 1 8.44 8.45\" />\n  <path d=\"M2 12h10\" />\n  <path d=\"m2 2 20 20\" />"),
    GLOBE_X(
        "globe-x",
        "<path d=\"m16 3 5 5\" />\n  <path d=\"M2 12h20A10 10 0 1 1 12 2a14.5 14.5 0 0 0 0 20 14.5 14.5 0 0 0 4-10\" />\n  <path d=\"m21 3-5 5\" />"),
    GRAPH_HUB(
        "graph-hub",
        "<circle cx=\"12\" cy=\"7\" r=\"4\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />\n  <circle cx=\"12\" cy=\"19\" r=\"2\" />\n  <circle cx=\"20\" cy=\"19\" r=\"2\" />\n  <path d=\"M8 7a4 4 0 0 0-4 4v6\" />\n  <path d=\"M12 11v6\" />\n  <path d=\"M16 7a4 4 0 0 1 4 4v6\" />"),
    HEADPHONE_OFF(
        "headphone-off",
        "<path d=\"M21 14h-1.343\" />\n  <path d=\"M9.128 3.47A9 9 0 0 1 21 12v3.343\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20.414 20.414A2 2 0 0 1 19 21h-1a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 2.636-6.364\" />"),
    HEADPHONES(
        "headphones",
        "<path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 18 0v7a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3\" />"),
    HEADSET(
        "headset",
        "<path d=\"M3 11h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-5Zm0 0a9 9 0 1 1 18 0m0 0v5a2 2 0 0 1-2 2h-1a2 2 0 0 1-2-2v-3a2 2 0 0 1 2-2h3Z\" />\n  <path d=\"M21 16v2a4 4 0 0 1-4 4h-5\" />"),
    HOUSE_WIFI(
        "house-wifi",
        "<path d=\"M9.5 13.866a4 4 0 0 1 5 .01\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />\n  <path d=\"M7 10.754a8 8 0 0 1 10 0\" />"),
    MIC(
        "mic",
        "<path d=\"M12 19v3\" />\n  <path d=\"M19 10v2a7 7 0 0 1-14 0v-2\" />\n  <rect x=\"9\" y=\"2\" width=\"6\" height=\"13\" rx=\"3\" />"),
    MIC_OFF(
        "mic-off",
        "<path d=\"M12 19v3\" />\n  <path d=\"M15 9.34V5a3 3 0 0 0-5.68-1.33\" />\n  <path d=\"M16.95 16.95A7 7 0 0 1 5 12v-2\" />\n  <path d=\"M18.89 13.23A7 7 0 0 0 19 12v-2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M9 9v3a3 3 0 0 0 5.12 2.12\" />"),
    MIC_SIGNAL(
        "mic-signal",
        "<path d=\"M12 17v4\" />\n  <path d=\"M18 11a6 6 0 00-3-5.197\" />\n  <path d=\"M2 11a10 10 0 015-8.662\" />\n  <path d=\"M22 11a10 10 0 00-5-8.662\" />\n  <path d=\"M6 11a6 6 0 013-5.197\" />\n  <path d=\"M9 21h6\" />\n  <rect x=\"10\" y=\"9\" width=\"4\" height=\"8\" rx=\"2\" />"),
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
    POWER("power", "<path d=\"M12 2v10\" />\n  <path d=\"M18.4 6.6a9 9 0 1 1-12.77.04\" />"),
    POWER_OFF(
        "power-off",
        "<path d=\"M18.36 6.64A9 9 0 0 1 20.77 15\" />\n  <path d=\"M6.16 6.16a9 9 0 1 0 12.68 12.68\" />\n  <path d=\"M12 2v4\" />\n  <path d=\"m2 2 20 20\" />"),
    RECTANGLE_GOGGLES(
        "rectangle-goggles",
        "<path d=\"M20 6a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-4a2 2 0 0 1-1.6-.8l-1.6-2.13a1 1 0 0 0-1.6 0L9.6 17.2A2 2 0 0 1 8 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2z\" />"),
    ROUTER(
        "router",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6.01 18H6\" />\n  <path d=\"M10.01 18H10\" />\n  <path d=\"M15 10v4\" />\n  <path d=\"M17.84 7.17a4 4 0 0 0-5.66 0\" />\n  <path d=\"M20.66 4.34a8 8 0 0 0-11.31 0\" />"),
    SATELLITE(
        "satellite",
        "<path d=\"m13.5 6.5-3.148-3.148a1.205 1.205 0 0 0-1.704 0L6.352 5.648a1.205 1.205 0 0 0 0 1.704L9.5 10.5\" />\n  <path d=\"M16.5 7.5 19 5\" />\n  <path d=\"m17.5 10.5 3.148 3.148a1.205 1.205 0 0 1 0 1.704l-2.296 2.296a1.205 1.205 0 0 1-1.704 0L13.5 14.5\" />\n  <path d=\"M9 21a6 6 0 0 0-6-6\" />\n  <path d=\"M9.352 10.648a1.205 1.205 0 0 0 0 1.704l2.296 2.296a1.205 1.205 0 0 0 1.704 0l4.296-4.296a1.205 1.205 0 0 0 0-1.704l-2.296-2.296a1.205 1.205 0 0 0-1.704 0z\" />"),
    SATELLITE_DISH(
        "satellite-dish",
        "<path d=\"M18 12a6 6 0 00-6-6\" />\n  <path d=\"M2.824 10.459a8 8 0 0010.717 10.717c.558-.276.623-1.012.183-1.452l-9.448-9.448c-.44-.44-1.176-.375-1.452.183\" />\n  <path d=\"M22 12A10 10 0 0012 2\" />\n  <path d=\"m9 15 4-4\" />"),
    SCREEN_SHARE(
        "screen-share",
        "<path d=\"M13 3H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"m17 8 5-5\" />\n  <path d=\"M17 3h5v5\" />"),
    SCREEN_SHARE_OFF(
        "screen-share-off",
        "<path d=\"M13 3H4a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M8 21h8\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"m22 3-5 5\" />\n  <path d=\"m17 3 5 5\" />"),
    SEND(
        "send",
        "<path d=\"M14.536 21.686a.5.5 0 0 0 .937-.024l6.5-19a.496.496 0 0 0-.635-.635l-19 6.5a.5.5 0 0 0-.024.937l7.93 3.18a2 2 0 0 1 1.112 1.11z\" />\n  <path d=\"m21.854 2.147-10.94 10.939\" />"),
    SEND_HORIZONTAL(
        "send-horizontal",
        "<path d=\"M3.714 3.048a.498.498 0 0 0-.683.627l2.843 7.627a2 2 0 0 1 0 1.396l-2.842 7.627a.498.498 0 0 0 .682.627l18-8.5a.5.5 0 0 0 0-.904z\" />\n  <path d=\"M6 12h16\" />"),
    SHIELD_HOUSE(
        "shield-house",
        "<path d=\"M15 22a1 1 0 01-1-1v-4a1 1 0 01.445-.832l3-2a1 1 0 011.11 0l3 2A1 1 0 0122 17v4a1 1 0 01-1 1z\" />\n  <path d=\"M18 22v-3\" />\n  <path d=\"M20 10.418V6a1 1 0 00-1-1c-2 0-4.49-1.19-6.24-2.72a1.17 1.17 0 00-1.52 0C9.5 3.8 7 5 5 5a1 1 0 00-1 1v7c0 4.602 2.67 7.1 6.037 8.603\" />"),
    SIGNAL(
        "signal",
        "<path d=\"M2 20h.01\" />\n  <path d=\"M7 20v-4\" />\n  <path d=\"M12 20v-8\" />\n  <path d=\"M17 20V8\" />\n  <path d=\"M22 4v16\" />"),
    SIGNAL_HIGH(
        "signal-high",
        "<path d=\"M2 20h.01\" />\n  <path d=\"M7 20v-4\" />\n  <path d=\"M12 20v-8\" />\n  <path d=\"M17 20V8\" />"),
    SIGNAL_LOW("signal-low", "<path d=\"M2 20h.01\" />\n  <path d=\"M7 20v-4\" />"),
    SIGNAL_MEDIUM(
        "signal-medium",
        "<path d=\"M2 20h.01\" />\n  <path d=\"M7 20v-4\" />\n  <path d=\"M12 20v-8\" />"),
    SIGNAL_ZERO("signal-zero", "<path d=\"M2 20h.01\" />"),
    SMARTPHONE(
        "smartphone",
        "<rect width=\"14\" height=\"20\" x=\"5\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <path d=\"M12 18h.01\" />"),
    SMARTPHONE_CHARGING(
        "smartphone-charging",
        "<rect width=\"14\" height=\"20\" x=\"5\" y=\"2\" rx=\"2\" ry=\"2\" />\n  <path d=\"M12.667 8 10 12h4l-2.667 4\" />"),
    SQUARE_POWER(
        "square-power",
        "<path d=\"M12 7v4\" />\n  <path d=\"M7.998 9.003a5 5 0 1 0 8-.005\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
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
    VOLUME(
        "volume",
        "<path d=\"M11 4.702a.705.705 0 0 0-1.203-.498L6.413 7.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 .997.413l3.383 3.384A.705.705 0 0 0 11 19.298z\" />"),
    VOLUME_1(
        "volume-1",
        "<path d=\"M11 4.702a.705.705 0 0 0-1.203-.498L6.413 7.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 .997.413l3.383 3.384A.705.705 0 0 0 11 19.298z\" />\n  <path d=\"M16 9a5 5 0 0 1 0 6\" />"),
    VOLUME_2(
        "volume-2",
        "<path d=\"M11 4.702a.705.705 0 0 0-1.203-.498L6.413 7.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 .997.413l3.383 3.384A.705.705 0 0 0 11 19.298z\" />\n  <path d=\"M16 9a5 5 0 0 1 0 6\" />\n  <path d=\"M19.364 18.364a9 9 0 0 0 0-12.728\" />"),
    VOLUME_OFF(
        "volume-off",
        "<path d=\"M16 9a5 5 0 0 1 .95 2.293\" />\n  <path d=\"M19.364 5.636a9 9 0 0 1 1.889 9.96\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m7 7-.587.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 .997.413l3.383 3.384A.705.705 0 0 0 11 19.298V11\" />\n  <path d=\"M9.828 4.172A.686.686 0 0 1 11 4.657v.686\" />"),
    VOLUME_X(
        "volume-x",
        "<path d=\"M11 4.702a.7.7 0 0 0-1.203-.498L6.413 7.587A1.4 1.4 0 0 1 5.416 8H3a1 1 0 0 0-1 1v6a1 1 0 0 0 1 1h2.416a1.4 1.4 0 0 1 .997.413l3.383 3.384A.7.7 0 0 0 11 19.298z\" />\n  <path d=\"m16.5 14.5 5-5\" />\n  <path d=\"m16.5 9.5 5 5\" />"),
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
  default LucideIcon airplay_connectivity() {
    return LucideIcon.create(Icon.AIRPLAY);
  }

  default LucideIcon battery_connectivity() {
    return LucideIcon.create(Icon.BATTERY);
  }

  default LucideIcon battery_charging_connectivity() {
    return LucideIcon.create(Icon.BATTERY_CHARGING);
  }

  default LucideIcon battery_full_connectivity() {
    return LucideIcon.create(Icon.BATTERY_FULL);
  }

  default LucideIcon battery_low_connectivity() {
    return LucideIcon.create(Icon.BATTERY_LOW);
  }

  default LucideIcon battery_medium_connectivity() {
    return LucideIcon.create(Icon.BATTERY_MEDIUM);
  }

  default LucideIcon battery_warning_connectivity() {
    return LucideIcon.create(Icon.BATTERY_WARNING);
  }

  default LucideIcon bluetooth_connectivity() {
    return LucideIcon.create(Icon.BLUETOOTH);
  }

  default LucideIcon bluetooth_connected_connectivity() {
    return LucideIcon.create(Icon.BLUETOOTH_CONNECTED);
  }

  default LucideIcon bluetooth_off_connectivity() {
    return LucideIcon.create(Icon.BLUETOOTH_OFF);
  }

  default LucideIcon bluetooth_searching_connectivity() {
    return LucideIcon.create(Icon.BLUETOOTH_SEARCHING);
  }

  default LucideIcon book_user_connectivity() {
    return LucideIcon.create(Icon.BOOK_USER);
  }

  default LucideIcon brick_wall_fire_connectivity() {
    return LucideIcon.create(Icon.BRICK_WALL_FIRE);
  }

  default LucideIcon brick_wall_shield_connectivity() {
    return LucideIcon.create(Icon.BRICK_WALL_SHIELD);
  }

  default LucideIcon cable_connectivity() {
    return LucideIcon.create(Icon.CABLE);
  }

  default LucideIcon car_battery_connectivity() {
    return LucideIcon.create(Icon.CAR_BATTERY);
  }

  default LucideIcon card_sim_connectivity() {
    return LucideIcon.create(Icon.CARD_SIM);
  }

  default LucideIcon cassette_tape_connectivity() {
    return LucideIcon.create(Icon.CASSETTE_TAPE);
  }

  default LucideIcon cast_connectivity() {
    return LucideIcon.create(Icon.CAST);
  }

  default LucideIcon cctv_connectivity() {
    return LucideIcon.create(Icon.CCTV);
  }

  default LucideIcon cctv_off_connectivity() {
    return LucideIcon.create(Icon.CCTV_OFF);
  }

  default LucideIcon certificate_connectivity() {
    return LucideIcon.create(Icon.CERTIFICATE);
  }

  default LucideIcon circle_power() {
    return LucideIcon.create(Icon.CIRCLE_POWER);
  }

  default LucideIcon cloud_off_connectivity() {
    return LucideIcon.create(Icon.CLOUD_OFF);
  }

  default LucideIcon contact_connectivity() {
    return LucideIcon.create(Icon.CONTACT);
  }

  default LucideIcon contact_round_connectivity() {
    return LucideIcon.create(Icon.CONTACT_ROUND);
  }

  default LucideIcon globe_off_connectivity() {
    return LucideIcon.create(Icon.GLOBE_OFF);
  }

  default LucideIcon globe_x_connectivity() {
    return LucideIcon.create(Icon.GLOBE_X);
  }

  default LucideIcon graph_hub_connectivity() {
    return LucideIcon.create(Icon.GRAPH_HUB);
  }

  default LucideIcon headphone_off_connectivity() {
    return LucideIcon.create(Icon.HEADPHONE_OFF);
  }

  default LucideIcon headphones_connectivity() {
    return LucideIcon.create(Icon.HEADPHONES);
  }

  default LucideIcon headset_connectivity() {
    return LucideIcon.create(Icon.HEADSET);
  }

  default LucideIcon house_wifi_connectivity() {
    return LucideIcon.create(Icon.HOUSE_WIFI);
  }

  default LucideIcon mic_connectivity() {
    return LucideIcon.create(Icon.MIC);
  }

  default LucideIcon mic_off_connectivity() {
    return LucideIcon.create(Icon.MIC_OFF);
  }

  default LucideIcon mic_signal_connectivity() {
    return LucideIcon.create(Icon.MIC_SIGNAL);
  }

  default LucideIcon midi_port_connectivity() {
    return LucideIcon.create(Icon.MIDI_PORT);
  }

  default LucideIcon monitor_connectivity() {
    return LucideIcon.create(Icon.MONITOR);
  }

  default LucideIcon monitor_check_connectivity() {
    return LucideIcon.create(Icon.MONITOR_CHECK);
  }

  default LucideIcon monitor_cloud_connectivity() {
    return LucideIcon.create(Icon.MONITOR_CLOUD);
  }

  default LucideIcon monitor_cog_connectivity() {
    return LucideIcon.create(Icon.MONITOR_COG);
  }

  default LucideIcon monitor_dot_connectivity() {
    return LucideIcon.create(Icon.MONITOR_DOT);
  }

  default LucideIcon monitor_down_connectivity() {
    return LucideIcon.create(Icon.MONITOR_DOWN);
  }

  default LucideIcon monitor_off_connectivity() {
    return LucideIcon.create(Icon.MONITOR_OFF);
  }

  default LucideIcon monitor_pause_connectivity() {
    return LucideIcon.create(Icon.MONITOR_PAUSE);
  }

  default LucideIcon monitor_play_connectivity() {
    return LucideIcon.create(Icon.MONITOR_PLAY);
  }

  default LucideIcon monitor_smartphone_connectivity() {
    return LucideIcon.create(Icon.MONITOR_SMARTPHONE);
  }

  default LucideIcon monitor_speaker_connectivity() {
    return LucideIcon.create(Icon.MONITOR_SPEAKER);
  }

  default LucideIcon monitor_stop_connectivity() {
    return LucideIcon.create(Icon.MONITOR_STOP);
  }

  default LucideIcon monitor_up_connectivity() {
    return LucideIcon.create(Icon.MONITOR_UP);
  }

  default LucideIcon monitor_x_connectivity() {
    return LucideIcon.create(Icon.MONITOR_X);
  }

  default LucideIcon phone_connectivity() {
    return LucideIcon.create(Icon.PHONE);
  }

  default LucideIcon phone_call_connectivity() {
    return LucideIcon.create(Icon.PHONE_CALL);
  }

  default LucideIcon phone_forwarded_connectivity() {
    return LucideIcon.create(Icon.PHONE_FORWARDED);
  }

  default LucideIcon phone_incoming_connectivity() {
    return LucideIcon.create(Icon.PHONE_INCOMING);
  }

  default LucideIcon phone_missed_connectivity() {
    return LucideIcon.create(Icon.PHONE_MISSED);
  }

  default LucideIcon phone_off_connectivity() {
    return LucideIcon.create(Icon.PHONE_OFF);
  }

  default LucideIcon phone_outgoing_connectivity() {
    return LucideIcon.create(Icon.PHONE_OUTGOING);
  }

  default LucideIcon power() {
    return LucideIcon.create(Icon.POWER);
  }

  default LucideIcon power_off() {
    return LucideIcon.create(Icon.POWER_OFF);
  }

  default LucideIcon rectangle_goggles_connectivity() {
    return LucideIcon.create(Icon.RECTANGLE_GOGGLES);
  }

  default LucideIcon router_connectivity() {
    return LucideIcon.create(Icon.ROUTER);
  }

  default LucideIcon satellite_connectivity() {
    return LucideIcon.create(Icon.SATELLITE);
  }

  default LucideIcon satellite_dish_connectivity() {
    return LucideIcon.create(Icon.SATELLITE_DISH);
  }

  default LucideIcon screen_share_connectivity() {
    return LucideIcon.create(Icon.SCREEN_SHARE);
  }

  default LucideIcon screen_share_off_connectivity() {
    return LucideIcon.create(Icon.SCREEN_SHARE_OFF);
  }

  default LucideIcon send_connectivity() {
    return LucideIcon.create(Icon.SEND);
  }

  default LucideIcon send_horizontal_connectivity() {
    return LucideIcon.create(Icon.SEND_HORIZONTAL);
  }

  default LucideIcon shield_house_connectivity() {
    return LucideIcon.create(Icon.SHIELD_HOUSE);
  }

  default LucideIcon signal() {
    return LucideIcon.create(Icon.SIGNAL);
  }

  default LucideIcon signal_high() {
    return LucideIcon.create(Icon.SIGNAL_HIGH);
  }

  default LucideIcon signal_low() {
    return LucideIcon.create(Icon.SIGNAL_LOW);
  }

  default LucideIcon signal_medium() {
    return LucideIcon.create(Icon.SIGNAL_MEDIUM);
  }

  default LucideIcon signal_zero() {
    return LucideIcon.create(Icon.SIGNAL_ZERO);
  }

  default LucideIcon smartphone_connectivity() {
    return LucideIcon.create(Icon.SMARTPHONE);
  }

  default LucideIcon smartphone_charging_connectivity() {
    return LucideIcon.create(Icon.SMARTPHONE_CHARGING);
  }

  default LucideIcon square_power() {
    return LucideIcon.create(Icon.SQUARE_POWER);
  }

  default LucideIcon vibrate_connectivity() {
    return LucideIcon.create(Icon.VIBRATE);
  }

  default LucideIcon vibrate_off_connectivity() {
    return LucideIcon.create(Icon.VIBRATE_OFF);
  }

  default LucideIcon video_connectivity() {
    return LucideIcon.create(Icon.VIDEO);
  }

  default LucideIcon video_off_connectivity() {
    return LucideIcon.create(Icon.VIDEO_OFF);
  }

  default LucideIcon videotape_connectivity() {
    return LucideIcon.create(Icon.VIDEOTAPE);
  }

  default LucideIcon voicemail_connectivity() {
    return LucideIcon.create(Icon.VOICEMAIL);
  }

  default LucideIcon volume_connectivity() {
    return LucideIcon.create(Icon.VOLUME);
  }

  default LucideIcon volume_1_connectivity() {
    return LucideIcon.create(Icon.VOLUME_1);
  }

  default LucideIcon volume_2_connectivity() {
    return LucideIcon.create(Icon.VOLUME_2);
  }

  default LucideIcon volume_off_connectivity() {
    return LucideIcon.create(Icon.VOLUME_OFF);
  }

  default LucideIcon volume_x_connectivity() {
    return LucideIcon.create(Icon.VOLUME_X);
  }

  default LucideIcon webcam_connectivity() {
    return LucideIcon.create(Icon.WEBCAM);
  }

  default LucideIcon webcam_off_connectivity() {
    return LucideIcon.create(Icon.WEBCAM_OFF);
  }

  default LucideIcon wifi_connectivity() {
    return LucideIcon.create(Icon.WIFI);
  }

  default LucideIcon wifi_cog_connectivity() {
    return LucideIcon.create(Icon.WIFI_COG);
  }

  default LucideIcon wifi_high_connectivity() {
    return LucideIcon.create(Icon.WIFI_HIGH);
  }

  default LucideIcon wifi_lock_connectivity() {
    return LucideIcon.create(Icon.WIFI_LOCK);
  }

  default LucideIcon wifi_low_connectivity() {
    return LucideIcon.create(Icon.WIFI_LOW);
  }

  default LucideIcon wifi_off_connectivity() {
    return LucideIcon.create(Icon.WIFI_OFF);
  }

  default LucideIcon wifi_pen_connectivity() {
    return LucideIcon.create(Icon.WIFI_PEN);
  }

  default LucideIcon wifi_sync_connectivity() {
    return LucideIcon.create(Icon.WIFI_SYNC);
  }

  default LucideIcon wifi_zero_connectivity() {
    return LucideIcon.create(Icon.WIFI_ZERO);
  }

  default LucideIcon zap_connectivity() {
    return LucideIcon.create(Icon.ZAP);
  }

  default LucideIcon zap_off_connectivity() {
    return LucideIcon.create(Icon.ZAP_OFF);
  }
}
