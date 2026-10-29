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

/** Lucide communication catalog category. */
public interface LucideCommunication {
  enum Icon implements LucideIconDefinition {
    ANTENNA(
        "antenna",
        "<path d=\"M2 12 7 2\" />\n  <path d=\"m7 12 5-10\" />\n  <path d=\"m12 12 5-10\" />\n  <path d=\"m17 12 5-10\" />\n  <path d=\"M4.5 7h15\" />\n  <path d=\"M12 16v6\" />"),
    AUDIO_LINES(
        "audio-lines",
        "<path d=\"M2 10v3\" />\n  <path d=\"M6 6v11\" />\n  <path d=\"M10 3v18\" />\n  <path d=\"M14 8v7\" />\n  <path d=\"M18 5v13\" />\n  <path d=\"M22 10v3\" />"),
    AUDIO_LINES_OFF(
        "audio-lines-off",
        "<path d=\"M10 10v11\" />\n  <path d=\"M10 3v1.35\" />\n  <path d=\"M14 14v1\" />\n  <path d=\"M14 8v.35\" />\n  <path d=\"M18 5v7.35\" />\n  <path d=\"M2 10v3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M22 10v3\" />\n  <path d=\"M6 6v11\" />"),
    AUDIO_LINES_X(
        "audio-lines-x",
        "<path d=\"M10 3v18\" />\n  <path d=\"M14 8v6.35\" />\n  <path d=\"m17 17 5 5\" />\n  <path d=\"M18 5v8.1\" />\n  <path d=\"M2 10v3\" />\n  <path d=\"M22 10v3\" />\n  <path d=\"m22 17-5 5\" />\n  <path d=\"M6 6v11\" />"),
    AUDIO_WAVEFORM(
        "audio-waveform",
        "<path d=\"M2 13a2 2 0 0 0 2-2V7a2 2 0 0 1 4 0v13a2 2 0 0 0 4 0V4a2 2 0 0 1 4 0v13a2 2 0 0 0 4 0v-4a2 2 0 0 1 2-2\" />"),
    BOOK_USER(
        "book-user",
        "<path d=\"M15 13a3 3 0 1 0-6 0\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />"),
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
    CCTV(
        "cctv",
        "<path d=\"M16.75 12h3.632a1 1 0 0 1 .894 1.447l-2.034 4.069a1 1 0 0 1-1.708.134l-2.124-2.97\" />\n  <path d=\"M17.106 9.053a1 1 0 0 1 .447 1.341l-3.106 6.211a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.92 2.92 0 0 1 3.92-1.3z\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1L9 15\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CCTV_OFF(
        "cctv-off",
        "<path d=\"m12.309 6.652 4.797 2.401a1 1 0 0 1 .447 1.341l-.501 1.001.605.605h2.725a1 1 0 0 1 .894 1.447l-.724 1.448\" />\n  <path d=\"m15.166 15.166-.719 1.439a1 1 0 0 1-1.342.447L3.61 12.3a2.92 2.92 0 0 1-1.3-3.91L3.69 5.6a2.9 2.9 0 0 1 .873-1.037\" />\n  <path d=\"M2 19h3.76a2 2 0 0 0 1.8-1.1l1.441-2.902\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M2 21v-4\" />\n  <path d=\"M7 9h.01\" />"),
    CHEVRONS_LEFT_RIGHT_ELLIPSIS(
        "chevrons-left-right-ellipsis",
        "<path d=\"M12 12h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"m17 7 5 5-5 5\" />\n  <path d=\"m7 7-5 5 5 5\" />\n  <path d=\"M8 12h.01\" />"),
    CIRCLE_FADING_PLUS(
        "circle-fading-plus",
        "<path d=\"M12 2a10 10 0 0 1 7.38 16.75\" />\n  <path d=\"M12 8v8\" />\n  <path d=\"M16 12H8\" />\n  <path d=\"M2.5 8.875a10 10 0 0 0-.5 3\" />\n  <path d=\"M2.83 16a10 10 0 0 0 2.43 3.4\" />\n  <path d=\"M4.636 5.235a10 10 0 0 1 .891-.857\" />\n  <path d=\"M8.644 21.42a10 10 0 0 0 7.631-.38\" />"),
    CONTACT(
        "contact",
        "<path d=\"M16 2v2\" />\n  <path d=\"M7 21v-2a2 2 0 012-2h6a2 2 0 012 2v2\" />\n  <path d=\"M8 2v2\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    CONTACT_ROUND(
        "contact-round",
        "<path d=\"M16 2v2\" />\n  <path d=\"M17.915 21a6 6 0 10-12 0\" />\n  <path d=\"M8 2v2\" />\n  <circle cx=\"12\" cy=\"11\" r=\"4\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    ETHERNET_PORT(
        "ethernet-port",
        "<path d=\"M10 8v1\" />\n  <path d=\"M14 8v1\" />\n  <path d=\"M18 8v1\" />\n  <path d=\"M19 17a2 2 0 00-1.765 1.059l-.47.882A2 2 0 0115 20H9a2 2 0 01-1.765-1.059l-.47-.882A2 2 0 005 17H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v9a2 2 0 01-2 2z\" />\n  <path d=\"M6 8v1\" />"),
    FACE_SLIGHTLY_SMILING_PLUS(
        "face-slightly-smiling-plus",
        "<path d=\"M13.267 2.08a10 10 0 108.653 8.653\" />\n  <path d=\"M15 10V9\" />\n  <path d=\"M16 5h6\" />\n  <path d=\"M16.472 15a6 6 0 01-8.943 0\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M9 10V9\" />"),
    HAND_FIST(
        "hand-fist",
        "<path d=\"M12.035 17.012a3 3 0 0 0-3-3l-.311-.002a.72.72 0 0 1-.505-1.229l1.195-1.195A2 2 0 0 1 10.828 11H12a2 2 0 0 0 0-4H9.243a3 3 0 0 0-2.122.879l-2.707 2.707A4.83 4.83 0 0 0 3 14a8 8 0 0 0 8 8h2a8 8 0 0 0 8-8V7a2 2 0 1 0-4 0v2a2 2 0 1 0 4 0\" />\n  <path d=\"M13.888 9.662A2 2 0 0 0 17 8V5A2 2 0 1 0 13 5\" />\n  <path d=\"M9 5A2 2 0 1 0 5 5V10\" />\n  <path d=\"M9 7V4A2 2 0 1 1 13 4V7.268\" />"),
    HANDSHAKE(
        "handshake",
        "<path d=\"m11 17 2 2a1 1 0 1 0 3-3\" />\n  <path d=\"m14 14 2.5 2.5a1 1 0 1 0 3-3l-3.88-3.88a3 3 0 0 0-4.24 0l-.88.88a1 1 0 1 1-3-3l2.81-2.81a5.79 5.79 0 0 1 7.06-.87l.47.28a2 2 0 0 0 1.42.25L21 4\" />\n  <path d=\"m21 3 1 11h-2\" />\n  <path d=\"M3 3 2 14l6.5 6.5a1 1 0 1 0 3-3\" />\n  <path d=\"M3 4h8\" />"),
    HEADPHONE_OFF(
        "headphone-off",
        "<path d=\"M21 14h-1.343\" />\n  <path d=\"M9.128 3.47A9 9 0 0 1 21 12v3.343\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20.414 20.414A2 2 0 0 1 19 21h-1a2 2 0 0 1-2-2v-3\" />\n  <path d=\"M3 14h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-7a9 9 0 0 1 2.636-6.364\" />"),
    LECTERN(
        "lectern",
        "<path d=\"M15 13h4a2 2 0 001.901-1.38l1.057-4.333A1 1 0 0021 6H3a1 1 0 00-.958 1.287L3.1 11.621A2 2 0 005.001 13h4\" />\n  <path d=\"M15 22V11a1 1 0 00-1-1h-4a1 1 0 00-1 1v11\" />\n  <path d=\"M18 22H6\" />\n  <path d=\"M18 6V3a1 1 0 00-1-1h-3\" />"),
    MAIL_BADGE(
        "mail-badge",
        "<path d=\"M22 7.7V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8.25\" />\n  <path d=\"M12 12.996a1.94 1.94 0 0 1-1.03-.296L2 7\" />\n  <path d=\"m20.69 16.479 1.29 4.88a.5.5 0 0 1-.698.591l-1.843-.849a1 1 0 0 0-.879.001l-1.846.85a.5.5 0 0 1-.692-.593l1.29-4.88\" />\n  <circle cx=\"19\" cy=\"14\" r=\"3\" />"),
    MAIL_CLOCK(
        "mail-clock",
        "<path d=\"M16 14v2.2l1.6 1\" />\n  <path d=\"m22 7-.759.484\" />\n  <path d=\"M6.835 20H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v2\" />\n  <path d=\"M7.605 10.567 2 7\" />\n  <circle cx=\"16\" cy=\"16\" r=\"6\" />"),
    MESSAGES_CIRCLE(
        "messages-circle",
        "<path d=\"M19.95 10.05a7 7 0 011.412 7.872 1 1 0 00-.058.787l.675 2.089a1 1 0 01-1.236 1.168l-2.155-.631a1 1 0 00-.745.06 7 7 0 01-7.793-1.445\" />\n  <path d=\"M2.696 12.708a1 1 0 00-.058-.785 7 7 0 113.518 3.473 1 1 0 00-.744-.061l-2.155.63a1 1 0 01-1.236-1.167z\" />"),
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
    MOUTH(
        "mouth",
        "<path d=\"M2 12a50.5 50.5 0 0020 0 1 1 0 00-1-1\" />\n  <path d=\"M2.457 11.159a1 1 0 00-.307 1.369 11.59 11.59 0 0019.7 0 1 1 0 00-.308-1.368c-2.426-1.568-3.65-2.284-5.479-3.644a2.6 2.6 0 00-3.373.208 1 1 0 01-1.38 0 2.62 2.62 0 00-3.373-.208c-1.83 1.36-3.053 2.076-5.48 3.643\" />"),
    MOUTH_OFF(
        "mouth-off",
        "<path d=\"M13.074 7.417a2.6 2.6 0 012.989.099c1.829 1.36 3.053 2.076 5.479 3.644a1 1 0 01.308 1.368 11.6 11.6 0 01-1.617 2.05\" />\n  <path d=\"M2 12a50.5 50.5 0 0010.99.99\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 11a1 1 0 011 1 51 51 0 01-3.734.61\" />\n  <path d=\"M7.695 7.695c-1.7 1.247-2.92 1.967-5.238 3.464a1 1 0 00-.307 1.369 11.6 11.6 0 0014.766 4.388\" />"),
    NEWSPAPER(
        "newspaper",
        "<path d=\"M15 18h-5\" />\n  <path d=\"M18 14h-8\" />\n  <path d=\"M4 22h16a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16a2 2 0 0 1-4 0v-9a2 2 0 0 1 2-2h2\" />\n  <rect width=\"8\" height=\"4\" x=\"10\" y=\"6\" rx=\"1\" />"),
    NFC(
        "nfc",
        "<path d=\"M6 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M9.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M12.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />\n  <path d=\"M16.37 2a20.16 20.16 0 0 1 0 20\" />"),
    NOTEBOOK(
        "notebook",
        "<path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M16 2v20\" />"),
    NOTEBOOK_DOT(
        "notebook-dot",
        "<path d=\"M16 11.75V22\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <path d=\"M2 6h4\" />\n  <path d=\"M20 11.75V20a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h5.65\" />\n  <circle cx=\"18\" cy=\"5\" r=\"3\" />"),
    NOTEBOOK_TABS(
        "notebook-tabs",
        "<path d=\"M2 6h4\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M15 2v20\" />\n  <path d=\"M15 7h5\" />\n  <path d=\"M15 12h5\" />\n  <path d=\"M15 17h5\" />"),
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
    PHONE_LOG(
        "phone-log",
        "<path d=\"M13.832 16.568a1 1 0 001.213-.303l.355-.465A2 2 0 0117 15h3a2 2 0 012 2v3a2 2 0 01-2 2A18 18 0 012 4a2 2 0 012-2h3a2 2 0 012 2v3a2 2 0 01-.8 1.6l-.468.351a1 1 0 00-.292 1.233 14 14 0 006.392 6.384\" />\n  <path d=\"M14.396 4.171h7.171\" />\n  <path d=\"M17.343 8.17h4.224\" />"),
    PHONE_MISSED(
        "phone-missed",
        "<path d=\"m16 2 6 6\" />\n  <path d=\"m22 2-6 6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PHONE_OFF(
        "phone-off",
        "<path d=\"M10.1 13.9a14 14 0 0 0 3.732 2.668 1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2 18 18 0 0 1-12.728-5.272\" />\n  <path d=\"M22 2 2 22\" />\n  <path d=\"M4.76 13.582A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 .244.473\" />"),
    PHONE_OUTGOING(
        "phone-outgoing",
        "<path d=\"m16 8 6-6\" />\n  <path d=\"M22 8V2h-6\" />\n  <path d=\"M13.832 16.568a1 1 0 0 0 1.213-.303l.355-.465A2 2 0 0 1 17 15h3a2 2 0 0 1 2 2v3a2 2 0 0 1-2 2A18 18 0 0 1 2 4a2 2 0 0 1 2-2h3a2 2 0 0 1 2 2v3a2 2 0 0 1-.8 1.6l-.468.351a1 1 0 0 0-.292 1.233 14 14 0 0 0 6.392 6.384\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M2 3h20\" />\n  <path d=\"M21 3v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V3\" />\n  <path d=\"m7 21 5-5 5 5\" />"),
    PROJECTOR(
        "projector",
        "<path d=\"M5 7 3 5\" />\n  <path d=\"M9 6V3\" />\n  <path d=\"m13 7 2-2\" />\n  <circle cx=\"9\" cy=\"13\" r=\"3\" />\n  <path d=\"M11.83 12H20a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h2.17\" />\n  <path d=\"M16 16h2\" />"),
    RADAR(
        "radar",
        "<path d=\"M19.07 4.93A10 10 0 0 0 6.99 3.34\" />\n  <path d=\"M4 6h.01\" />\n  <path d=\"M2.29 9.62A10 10 0 1 0 21.31 8.35\" />\n  <path d=\"M16.24 7.76A6 6 0 1 0 8.23 16.67\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M17.99 11.66A6 6 0 0 1 15.77 16.67\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"m13.41 10.59 5.66-5.66\" />"),
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
    SMARTPHONE_NFC(
        "smartphone-nfc",
        "<rect width=\"7\" height=\"12\" x=\"2\" y=\"6\" rx=\"1\" />\n  <path d=\"M13 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M16.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M19.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />"),
    SPEECH(
        "speech",
        "<path d=\"M8.8 20v-4.1l1.9.2a2.3 2.3 0 0 0 2.164-2.1V8.3A5.37 5.37 0 0 0 2 8.25c0 2.8.656 3.054 1 4.55a5.77 5.77 0 0 1 .029 2.758L2 20\" />\n  <path d=\"M19.8 17.8a7.5 7.5 0 0 0 .003-10.603\" />\n  <path d=\"M17 15a3.5 3.5 0 0 0-.025-4.975\" />"),
    SPOOL(
        "spool",
        "<path d=\"M17 13.44 4.442 17.082A2 2 0 0 0 4.982 21H19a2 2 0 0 0 .558-3.921l-1.115-.32A2 2 0 0 1 17 14.837V7.66\" />\n  <path d=\"m7 10.56 12.558-3.642A2 2 0 0 0 19.018 3H5a2 2 0 0 0-.558 3.921l1.115.32A2 2 0 0 1 7 9.163v7.178\" />"),
    SPOTLIGHT(
        "spotlight",
        "<path d=\"M15.295 19.562 16 22\" />\n  <path d=\"m17 16 3.758 2.098\" />\n  <path d=\"m19 12.5 3.026-.598\" />\n  <path d=\"M7.61 6.3a3 3 0 0 0-3.92 1.3l-1.38 2.79a3 3 0 0 0 1.3 3.91l6.89 3.597a1 1 0 0 0 1.342-.447l3.106-6.211a1 1 0 0 0-.447-1.341z\" />\n  <path d=\"M8 9V2\" />"),
    SWITCH_CAMERA(
        "switch-camera",
        "<path d=\"M11 19H4a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2h5\" />\n  <path d=\"M13 5h7a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"m18 22-3-3 3-3\" />\n  <path d=\"m6 2 3 3-3 3\" />"),
    TV(
        "tv",
        "<path d=\"m17 2-5 5-5-5\" />\n  <rect width=\"20\" height=\"15\" x=\"2\" y=\"7\" rx=\"2\" />"),
    USERS_COLLABORATION(
        "users-collaboration",
        "<path d=\"M12.925 3.047a9 9 0 017.616 6.11\" />\n  <path d=\"M13 22a2 2 0 012-2h4a2 2 0 012 2\" />\n  <path d=\"M3 12a2 2 0 012-2h4a2 2 0 012 2\" />\n  <path d=\"M3.889 15.9a9 9 0 005.247 4.632\" />\n  <circle cx=\"17\" cy=\"14\" r=\"2\" />\n  <circle cx=\"7\" cy=\"4\" r=\"2\" />"),
    USERS_ROUND_COLLABORATION(
        "users-round-collaboration",
        "<path d=\"M20.453 8.911a9 9 0 00-6.696-5.738\" />\n  <path d=\"M21 22a4 4 0 00-8 0\" />\n  <path d=\"M3 12a4 4 0 017.963-.543\" />\n  <path d=\"M3.889 15.9a9 9 0 005.247 4.632\" />\n  <circle cx=\"17\" cy=\"15\" r=\"3\" />\n  <circle cx=\"7\" cy=\"5\" r=\"3\" />"),
    VIDEO(
        "video",
        "<path d=\"m16 13 5.223 3.482a.5.5 0 0 0 .777-.416V7.87a.5.5 0 0 0-.752-.432L16 10.5\" />\n  <rect x=\"2\" y=\"6\" width=\"14\" height=\"12\" rx=\"2\" />"),
    VIDEO_OFF(
        "video-off",
        "<path d=\"M10.66 6H14a2 2 0 0 1 2 2v2.5l5.248-3.062A.5.5 0 0 1 22 7.87v8.196\" />\n  <path d=\"M16 16a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h2\" />\n  <path d=\"m2 2 20 20\" />"),
    VIDEOTAPE(
        "videotape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M2 8h20\" />\n  <circle cx=\"8\" cy=\"14\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"14\" r=\"2\" />"),
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
        "<path d=\"M12 22v-4\" />\n  <path d=\"M12.754 7.096a3 3 0 0 1 2.15 2.15\" />\n  <path d=\"M12.863 12.873a3 3 0 0 1-3.736-3.735\" />\n  <path d=\"M16.566 16.57A8 8 0 0 1 5.43 5.433\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7 22h10\" />\n  <path d=\"M8.478 2.817a8 8 0 0 1 10.705 10.705\" />");

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
  default LucideIcon antenna_communication() {
    return LucideIcon.create(Icon.ANTENNA);
  }

  default LucideIcon audio_lines_communication() {
    return LucideIcon.create(Icon.AUDIO_LINES);
  }

  default LucideIcon audio_lines_off_communication() {
    return LucideIcon.create(Icon.AUDIO_LINES_OFF);
  }

  default LucideIcon audio_lines_x_communication() {
    return LucideIcon.create(Icon.AUDIO_LINES_X);
  }

  default LucideIcon audio_waveform_communication() {
    return LucideIcon.create(Icon.AUDIO_WAVEFORM);
  }

  default LucideIcon book_user_communication() {
    return LucideIcon.create(Icon.BOOK_USER);
  }

  default LucideIcon camera_communication() {
    return LucideIcon.create(Icon.CAMERA);
  }

  default LucideIcon camera_off_communication() {
    return LucideIcon.create(Icon.CAMERA_OFF);
  }

  default LucideIcon card_sim_communication() {
    return LucideIcon.create(Icon.CARD_SIM);
  }

  default LucideIcon cassette_tape_communication() {
    return LucideIcon.create(Icon.CASSETTE_TAPE);
  }

  default LucideIcon cctv_communication() {
    return LucideIcon.create(Icon.CCTV);
  }

  default LucideIcon cctv_off_communication() {
    return LucideIcon.create(Icon.CCTV_OFF);
  }

  default LucideIcon chevrons_left_right_ellipsis_communication() {
    return LucideIcon.create(Icon.CHEVRONS_LEFT_RIGHT_ELLIPSIS);
  }

  default LucideIcon circle_fading_plus_communication() {
    return LucideIcon.create(Icon.CIRCLE_FADING_PLUS);
  }

  default LucideIcon contact_communication() {
    return LucideIcon.create(Icon.CONTACT);
  }

  default LucideIcon contact_round_communication() {
    return LucideIcon.create(Icon.CONTACT_ROUND);
  }

  default LucideIcon ethernet_port_communication() {
    return LucideIcon.create(Icon.ETHERNET_PORT);
  }

  default LucideIcon face_slightly_smiling_plus_communication() {
    return LucideIcon.create(Icon.FACE_SLIGHTLY_SMILING_PLUS);
  }

  default LucideIcon hand_fist_communication() {
    return LucideIcon.create(Icon.HAND_FIST);
  }

  default LucideIcon handshake_communication() {
    return LucideIcon.create(Icon.HANDSHAKE);
  }

  default LucideIcon headphone_off_communication() {
    return LucideIcon.create(Icon.HEADPHONE_OFF);
  }

  default LucideIcon lectern_communication() {
    return LucideIcon.create(Icon.LECTERN);
  }

  default LucideIcon mail_badge_communication() {
    return LucideIcon.create(Icon.MAIL_BADGE);
  }

  default LucideIcon mail_clock_communication() {
    return LucideIcon.create(Icon.MAIL_CLOCK);
  }

  default LucideIcon messages_circle_communication() {
    return LucideIcon.create(Icon.MESSAGES_CIRCLE);
  }

  default LucideIcon mic_communication() {
    return LucideIcon.create(Icon.MIC);
  }

  default LucideIcon mic_audio_lines_communication() {
    return LucideIcon.create(Icon.MIC_AUDIO_LINES);
  }

  default LucideIcon mic_off_communication() {
    return LucideIcon.create(Icon.MIC_OFF);
  }

  default LucideIcon mic_signal_communication() {
    return LucideIcon.create(Icon.MIC_SIGNAL);
  }

  default LucideIcon mouth_communication() {
    return LucideIcon.create(Icon.MOUTH);
  }

  default LucideIcon mouth_off_communication() {
    return LucideIcon.create(Icon.MOUTH_OFF);
  }

  default LucideIcon newspaper_communication() {
    return LucideIcon.create(Icon.NEWSPAPER);
  }

  default LucideIcon nfc_communication() {
    return LucideIcon.create(Icon.NFC);
  }

  default LucideIcon notebook_communication() {
    return LucideIcon.create(Icon.NOTEBOOK);
  }

  default LucideIcon notebook_dot() {
    return LucideIcon.create(Icon.NOTEBOOK_DOT);
  }

  default LucideIcon notebook_tabs_communication() {
    return LucideIcon.create(Icon.NOTEBOOK_TABS);
  }

  default LucideIcon phone_communication() {
    return LucideIcon.create(Icon.PHONE);
  }

  default LucideIcon phone_call_communication() {
    return LucideIcon.create(Icon.PHONE_CALL);
  }

  default LucideIcon phone_forwarded_communication() {
    return LucideIcon.create(Icon.PHONE_FORWARDED);
  }

  default LucideIcon phone_incoming_communication() {
    return LucideIcon.create(Icon.PHONE_INCOMING);
  }

  default LucideIcon phone_log() {
    return LucideIcon.create(Icon.PHONE_LOG);
  }

  default LucideIcon phone_missed_communication() {
    return LucideIcon.create(Icon.PHONE_MISSED);
  }

  default LucideIcon phone_off_communication() {
    return LucideIcon.create(Icon.PHONE_OFF);
  }

  default LucideIcon phone_outgoing_communication() {
    return LucideIcon.create(Icon.PHONE_OUTGOING);
  }

  default LucideIcon presentation_communication() {
    return LucideIcon.create(Icon.PRESENTATION);
  }

  default LucideIcon projector_communication() {
    return LucideIcon.create(Icon.PROJECTOR);
  }

  default LucideIcon radar_communication() {
    return LucideIcon.create(Icon.RADAR);
  }

  default LucideIcon screen_share_communication() {
    return LucideIcon.create(Icon.SCREEN_SHARE);
  }

  default LucideIcon screen_share_off_communication() {
    return LucideIcon.create(Icon.SCREEN_SHARE_OFF);
  }

  default LucideIcon send_communication() {
    return LucideIcon.create(Icon.SEND);
  }

  default LucideIcon send_horizontal_communication() {
    return LucideIcon.create(Icon.SEND_HORIZONTAL);
  }

  default LucideIcon smartphone_nfc_communication() {
    return LucideIcon.create(Icon.SMARTPHONE_NFC);
  }

  default LucideIcon speech_communication() {
    return LucideIcon.create(Icon.SPEECH);
  }

  default LucideIcon spool_communication() {
    return LucideIcon.create(Icon.SPOOL);
  }

  default LucideIcon spotlight_communication() {
    return LucideIcon.create(Icon.SPOTLIGHT);
  }

  default LucideIcon switch_camera_communication() {
    return LucideIcon.create(Icon.SWITCH_CAMERA);
  }

  default LucideIcon tv_communication() {
    return LucideIcon.create(Icon.TV);
  }

  default LucideIcon users_collaboration_communication() {
    return LucideIcon.create(Icon.USERS_COLLABORATION);
  }

  default LucideIcon users_round_collaboration_communication() {
    return LucideIcon.create(Icon.USERS_ROUND_COLLABORATION);
  }

  default LucideIcon video_communication() {
    return LucideIcon.create(Icon.VIDEO);
  }

  default LucideIcon video_off_communication() {
    return LucideIcon.create(Icon.VIDEO_OFF);
  }

  default LucideIcon videotape_communication() {
    return LucideIcon.create(Icon.VIDEOTAPE);
  }

  default LucideIcon volume_communication() {
    return LucideIcon.create(Icon.VOLUME);
  }

  default LucideIcon volume_1_communication() {
    return LucideIcon.create(Icon.VOLUME_1);
  }

  default LucideIcon volume_2_communication() {
    return LucideIcon.create(Icon.VOLUME_2);
  }

  default LucideIcon volume_off_communication() {
    return LucideIcon.create(Icon.VOLUME_OFF);
  }

  default LucideIcon volume_x_communication() {
    return LucideIcon.create(Icon.VOLUME_X);
  }

  default LucideIcon webcam_communication() {
    return LucideIcon.create(Icon.WEBCAM);
  }

  default LucideIcon webcam_off_communication() {
    return LucideIcon.create(Icon.WEBCAM_OFF);
  }
}
