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

/** Lucide multimedia catalog category. */
public interface LucideMultimedia {
  enum Icon implements LucideIconDefinition {
    ACTIVITY(
        "activity",
        "<path d=\"M22 12h-2.48a2 2 0 0 0-1.93 1.46l-2.35 8.36a.25.25 0 0 1-.48 0L9.24 2.18a.25.25 0 0 0-.48 0l-2.35 8.36A2 2 0 0 1 4.49 12H2\" />"),
    AD(
        "ad",
        "<path d=\"M10 13H6\" />\n  <path d=\"M10 15v-4a2 2 0 0 0-4 0v4\" />\n  <path d=\"M14 14.5a.5.5 0 0 0 .5.5h1a2.5 2.5 0 0 0 2.5-2.5v-1A2.5 2.5 0 0 0 15.5 9h-1a.5.5 0 0 0-.5.5z\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    AIRPLAY(
        "airplay",
        "<path d=\"M5 17H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2h-1\" />\n  <path d=\"m12 15 5 6H7Z\" />"),
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
    BOOK_AUDIO(
        "book-audio",
        "<path d=\"M12 6v7\" />\n  <path d=\"M16 8v3\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8 8v3\" />"),
    BOOK_HEADPHONES(
        "book-headphones",
        "<path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <path d=\"M8 12v-2a4 4 0 0 1 8 0v2\" />\n  <circle cx=\"15\" cy=\"12\" r=\"1\" />\n  <circle cx=\"9\" cy=\"12\" r=\"1\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
    BOOM_BOX(
        "boom-box",
        "<path d=\"M4 9V5a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M8 8v1\" />\n  <path d=\"M12 8v1\" />\n  <path d=\"M16 8v1\" />\n  <rect width=\"20\" height=\"12\" x=\"2\" y=\"9\" rx=\"2\" />\n  <circle cx=\"8\" cy=\"15\" r=\"2\" />\n  <circle cx=\"16\" cy=\"15\" r=\"2\" />"),
    CABLE(
        "cable",
        "<path d=\"M17 19a1 1 0 0 1-1-1v-2a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2a1 1 0 0 1-1 1z\" />\n  <path d=\"M17 21v-2\" />\n  <path d=\"M19 14V6.5a1 1 0 0 0-7 0v11a1 1 0 0 1-7 0V10\" />\n  <path d=\"M21 21v-2\" />\n  <path d=\"M3 5V3\" />\n  <path d=\"M4 10a2 2 0 0 1-2-2V6a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2z\" />\n  <path d=\"M7 5V3\" />"),
    CAPTIONS(
        "captions",
        "<rect width=\"18\" height=\"14\" x=\"3\" y=\"5\" rx=\"2\" ry=\"2\" />\n  <path d=\"M7 15h4M15 15h2M7 11h2M13 11h4\" />"),
    CAPTIONS_OFF(
        "captions-off",
        "<path d=\"M10.5 5H19a2 2 0 0 1 2 2v8.5\" />\n  <path d=\"M17 11h-.5\" />\n  <path d=\"M19 19H5a2 2 0 0 1-2-2V7a2 2 0 0 1 2-2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7 11h4\" />\n  <path d=\"M7 15h2.5\" />"),
    CARD_SIM(
        "card-sim",
        "<path d=\"M12 14v4\" />\n  <path d=\"M14.172 2a2 2 0 0 1 1.414.586l3.828 3.828A2 2 0 0 1 20 7.828V20a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2z\" />\n  <path d=\"M8 14h8\" />\n  <rect x=\"8\" y=\"10\" width=\"8\" height=\"8\" rx=\"2\" />"),
    CASSETTE_TAPE(
        "cassette-tape",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <circle cx=\"8\" cy=\"10\" r=\"2\" />\n  <path d=\"M8 12h8\" />\n  <circle cx=\"16\" cy=\"10\" r=\"2\" />\n  <path d=\"m6 20 .7-2.9A1.4 1.4 0 0 1 8.1 16h7.8a1.4 1.4 0 0 1 1.4 1l.7 3\" />"),
    CHEVRON_FIRST("chevron-first", "<path d=\"m17 18-6-6 6-6\" />\n  <path d=\"M7 6v12\" />"),
    CHEVRON_LAST("chevron-last", "<path d=\"m7 18 6-6-6-6\" />\n  <path d=\"M17 6v12\" />"),
    CHEVRONS_LEFT_RIGHT_ELLIPSIS(
        "chevrons-left-right-ellipsis",
        "<path d=\"M12 12h.01\" />\n  <path d=\"M16 12h.01\" />\n  <path d=\"m17 7 5 5-5 5\" />\n  <path d=\"m7 7-5 5 5 5\" />\n  <path d=\"M8 12h.01\" />"),
    CIRCLE_CHEVRONS_LEFT(
        "circle-chevrons-left",
        "<path d=\"M10 9L7 12L10 15\" />\n  <path d=\"M16 9L13 12L16 15\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_RIGHT(
        "circle-chevrons-right",
        "<path d=\"M14 15L17 12L14 9\" />\n  <path d=\"M8 15L11 12L8 9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_FADING_PLAY(
        "circle-fading-play",
        "<path d=\"M12 2a10 10 0 0 1 7.38 16.75\" />\n  <path d=\"M9 9.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997A1 1 0 0 1 9 14.996z\" />\n  <path d=\"M2.5 8.875a10 10 0 0 0-.5 3\" />\n  <path d=\"M2.83 16a10 10 0 0 0 2.43 3.4\" />\n  <path d=\"M4.636 5.235a10 10 0 0 1 .891-.857\" />\n  <path d=\"M8.644 21.42a10 10 0 0 0 7.631-.38\" />"),
    CIRCLE_PAUSE(
        "circle-pause",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <line x1=\"10\" x2=\"10\" y1=\"15\" y2=\"9\" />\n  <line x1=\"14\" x2=\"14\" y1=\"15\" y2=\"9\" />"),
    CIRCLE_PLAY(
        "circle-play",
        "<path d=\"M9 9.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997A1 1 0 0 1 9 14.996z\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_STOP(
        "circle-stop",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <rect x=\"9\" y=\"9\" width=\"6\" height=\"6\" rx=\"1\" />"),
    CLAPPERBOARD(
        "clapperboard",
        "<path d=\"m12.296 3.464 3.02 3.956\" />\n  <path d=\"M20.2 6 3 11l-.9-2.4c-.3-1.1.3-2.2 1.3-2.5l13.5-4c1.1-.3 2.2.3 2.5 1.3z\" />\n  <path d=\"M3 11h18v8a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />\n  <path d=\"m6.18 5.276 3.1 3.899\" />"),
    CLEF_ALTO(
        "clef-alto",
        "<path d=\"M10 4v16\" />\n  <path d=\"M14 4.764a3 3 0 1 1-.152 4.327A4 4 0 0 1 10 12a4 4 0 0 1 3.848 2.909A3 3 0 1 1 14 19.236\" />\n  <path d=\"M6 4v16\" />"),
    CLEF_BASS(
        "clef-bass",
        "<path d=\"M19 11h.01\" />\n  <path d=\"M19 6h.01\" />\n  <path d=\"M5 8c0-4 4-4 4-4 6 0 6 6 6 6 0 7-10 11-10 11\" />\n  <circle cx=\"7\" cy=\"8\" r=\"2\" />"),
    CLEF_TREBLE(
        "clef-treble",
        "<path d=\"M10.586 21.414a2 2 0 0 0 3.378-1.791L11.036 4.377a2 2 0 1 1 3.378 1.037C12.414 7.414 7 8 7 13a5 5 0 0 0 5 5 5 4 0 0 0 5-4 3 3 0 0 0-3-3 3 2 0 0 0-3 2\" />"),
    CLOSED_CAPTION(
        "closed-caption",
        "<path d=\"M10 9.17a3 3 0 1 0 0 5.66\" />\n  <path d=\"M17 9.17a3 3 0 1 0 0 5.66\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
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
    DRAMA(
        "drama",
        "<path d=\"M10 11h.01\" />\n  <path d=\"M14 6h.01\" />\n  <path d=\"M18 6h.01\" />\n  <path d=\"M6.5 13.1h.01\" />\n  <path d=\"M22 5c0 9-4 12-6 12s-6-3-6-12c0-2 2-3 6-3s6 1 6 3\" />\n  <path d=\"M17.4 9.9c-.8.8-2 .8-2.8 0\" />\n  <path d=\"M10.1 7.1C9 7.2 7.7 7.7 6 8.6c-3.5 2-4.7 3.9-3.7 5.6 4.5 7.8 9.5 8.4 11.2 7.4.9-.5 1.9-2.1 1.9-4.7\" />\n  <path d=\"M9.1 16.5c.3-1.1 1.4-1.7 2.4-1.4\" />"),
    DRUM(
        "drum",
        "<path d=\"m2 2 8 8\" />\n  <path d=\"m22 2-8 8\" />\n  <ellipse cx=\"12\" cy=\"9\" rx=\"10\" ry=\"5\" />\n  <path d=\"M7 13.4v7.9\" />\n  <path d=\"M12 14v8\" />\n  <path d=\"M17 13.4v7.9\" />\n  <path d=\"M2 9v8a10 5 0 0 0 20 0V9\" />"),
    EIGHTH_NOTE(
        "eighth-note",
        "<path d=\"m19 6-5.2-3.9a.5.5 0 0 0-.8.4V18\" />\n  <circle cx=\"9\" cy=\"18\" r=\"4\" />"),
    EIGHTH_NOTES(
        "eighth-notes",
        "<path d=\"M21 16V3a1 1 0 0 0-1.28-.96l-10 2.917a1 1 0 0 0-.72.96V19\" />\n  <circle cx=\"18\" cy=\"16\" r=\"3\" />\n  <circle cx=\"6\" cy=\"19\" r=\"3\" />"),
    EJECT(
        "eject",
        "<path d=\"M4 13a1 1 0 0 1-.72-1.695l7.257-7.668a2 2 0 0 1 2.926 0l7.256 7.668A1 1 0 0 1 20 13z\" />\n  <rect x=\"3\" y=\"17\" width=\"18\" height=\"4\" rx=\"1\" />"),
    ETHERNET_PORT(
        "ethernet-port",
        "<path d=\"M10 8v1\" />\n  <path d=\"M14 8v1\" />\n  <path d=\"M18 8v1\" />\n  <path d=\"M19 17a2 2 0 00-1.765 1.059l-.47.882A2 2 0 0115 20H9a2 2 0 01-1.765-1.059l-.47-.882A2 2 0 005 17H4a2 2 0 01-2-2V6a2 2 0 012-2h16a2 2 0 012 2v9a2 2 0 01-2 2z\" />\n  <path d=\"M6 8v1\" />"),
    FAST_FORWARD(
        "fast-forward",
        "<path d=\"M12 6a2 2 0 0 1 3.414-1.414l6 6a2 2 0 0 1 0 2.828l-6 6A2 2 0 0 1 12 18z\" />\n  <path d=\"M2 6a2 2 0 0 1 3.414-1.414l6 6a2 2 0 0 1 0 2.828l-6 6A2 2 0 0 1 2 18z\" />"),
    FILE_MUSIC(
        "file-music",
        "<path d=\"M11.65 22H18a2 2 0 0 0 2-2V8a2.4 2.4 0 0 0-.706-1.706l-3.588-3.588A2.4 2.4 0 0 0 14 2H6a2 2 0 0 0-2 2v10.35\" />\n  <path d=\"M14 2v5a1 1 0 0 0 1 1h5\" />\n  <path d=\"M8 20v-7l3 1.474\" />\n  <circle cx=\"6\" cy=\"20\" r=\"2\" />"),
    FILM(
        "film",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M3 7.5h4\" />\n  <path d=\"M3 12h18\" />\n  <path d=\"M3 16.5h4\" />\n  <path d=\"M17 3v18\" />\n  <path d=\"M17 7.5h4\" />\n  <path d=\"M17 16.5h4\" />"),
    FULLSCREEN(
        "fullscreen",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect width=\"10\" height=\"8\" x=\"7\" y=\"8\" rx=\"1\" />"),
    GALLERY_HORIZONTAL(
        "gallery-horizontal",
        "<path d=\"M2 3v18\" />\n  <rect width=\"12\" height=\"18\" x=\"6\" y=\"3\" rx=\"2\" />\n  <path d=\"M22 3v18\" />"),
    GALLERY_HORIZONTAL_END(
        "gallery-horizontal-end",
        "<path d=\"M2 7v10\" />\n  <path d=\"M6 5v14\" />\n  <rect width=\"12\" height=\"18\" x=\"10\" y=\"3\" rx=\"2\" />"),
    GALLERY_THUMBNAILS(
        "gallery-thumbnails",
        "<rect width=\"18\" height=\"14\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M4 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M19 21h1\" />"),
    GALLERY_VERTICAL(
        "gallery-vertical",
        "<path d=\"M3 2h18\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"6\" rx=\"2\" />\n  <path d=\"M3 22h18\" />"),
    GALLERY_VERTICAL_END(
        "gallery-vertical-end",
        "<path d=\"M7 2h10\" />\n  <path d=\"M5 6h14\" />\n  <rect width=\"18\" height=\"12\" x=\"3\" y=\"10\" rx=\"2\" />"),
    GUITAR(
        "guitar",
        "<path d=\"m11.9 12.1 4.514-4.514\" />\n  <path d=\"M20.1 2.3a1 1 0 0 0-1.4 0l-1.114 1.114A2 2 0 0 0 17 4.828v1.344a2 2 0 0 1-.586 1.414A2 2 0 0 1 17.828 7h1.344a2 2 0 0 0 1.414-.586L21.7 5.3a1 1 0 0 0 0-1.4z\" />\n  <path d=\"m6 16 2 2\" />\n  <path d=\"M8.23 9.85A3 3 0 0 1 11 8a5 5 0 0 1 5 5 3 3 0 0 1-1.85 2.77l-.92.38A2 2 0 0 0 12 18a4 4 0 0 1-4 4 6 6 0 0 1-6-6 4 4 0 0 1 4-4 2 2 0 0 0 1.85-1.23z\" />"),
    GUITAR_ELECTRIC(
        "guitar-electric",
        "<path d=\"m12.172 11.828 4.242-4.242\" />\n  <path d=\"M16.414 7.586A2 2 0 0017 6.172V5a2 2 0 011.177-1.823L20.59 2.09a1 1 0 011.32 1.32l-1.088 2.412A2 2 0 0119 7h-1a2 2 0 00-1.586.586\" />\n  <path d=\"m6 16 2 2\" />\n  <path d=\"M8.23 9.85a3 3 0 011.28-1.454 1 1 0 011.496.815 4 4 0 003.783 3.783 1 1 0 01.815 1.496 3 3 0 01-1.454 1.28l-.92.38A2 2 0 0012 18a4 4 0 01-4 4 6 6 0 01-6-6 4 4 0 014-4 2 2 0 001.85-1.23z\" />"),
    HALF_NOTE("half-note", "<circle cx=\"12\" cy=\"18\" r=\"4\" />\n  <path d=\"M16 18V2\" />"),
    HAND_METAL(
        "hand-metal",
        "<path d=\"M18 12.5V10a2 2 0 0 0-2-2a2 2 0 0 0-2 2v1.4\" />\n  <path d=\"M14 11V9a2 2 0 1 0-4 0v2\" />\n  <path d=\"M10 10.5V5a2 2 0 1 0-4 0v9\" />\n  <path d=\"m7 15-1.76-1.76a2 2 0 0 0-2.83 2.82l3.6 3.6C7.5 21.14 9.2 22 12 22h2a8 8 0 0 0 8-8V7a2 2 0 1 0-4 0v5\" />"),
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
    HEART(
        "heart",
        "<path d=\"M2 9.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5l-5.492 5.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5\" />"),
    HEART_MINUS(
        "heart-minus",
        "<path d=\"m14.876 18.99-1.368 1.323a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5a5.2 5.2 0 0 1-.244 1.572\" />\n  <path d=\"M15 15h6\" />"),
    HEART_OFF(
        "heart-off",
        "<path d=\"M10.5 4.893a5.5 5.5 0 0 1 1.091.931.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 1.872-1.002 3.356-2.187 4.655\" />\n  <path d=\"m16.967 16.967-3.459 3.346a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 2.747-4.761\" />\n  <path d=\"m2 2 20 20\" />"),
    HEART_PLUS(
        "heart-plus",
        "<path d=\"m14.479 19.374-.971.939a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5a5.2 5.2 0 0 1-.219 1.49\" />\n  <path d=\"M15 15h6\" />\n  <path d=\"M18 12v6\" />"),
    HEART_X(
        "heart-x",
        "<path d=\"m15.5 12.5 5 5\" />\n  <path d=\"m20.5 12.5-5 5\" />\n  <path d=\"M21.955 8.774a5.5 5.5 0 0 0-9.546-2.95.6.6 0 0 1-.818 0A5.5 5.5 0 0 0 2 9.5c0 2.3 1.5 4 3 5.5l5.508 5.332a2 2 0 0 0 2.57.352\" />"),
    IMAGE(
        "image",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" ry=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_DOWN(
        "image-down",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19 3 3v-5.5\" />\n  <path d=\"m17 22 3-3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_MINUS(
        "image-minus",
        "<path d=\"M21 9v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7\" />\n  <line x1=\"16\" x2=\"22\" y1=\"5\" y2=\"5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />"),
    IMAGE_OFF(
        "image-off",
        "<line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />\n  <path d=\"M10.41 10.41a2 2 0 1 1-2.83-2.83\" />\n  <line x1=\"13.5\" x2=\"6\" y1=\"13.5\" y2=\"21\" />\n  <line x1=\"18\" x2=\"21\" y1=\"12\" y2=\"15\" />\n  <path d=\"M3.59 3.59A1.99 1.99 0 0 0 3 5v14a2 2 0 0 0 2 2h14c.55 0 1.052-.22 1.41-.59\" />\n  <path d=\"M21 15V5a2 2 0 0 0-2-2H9\" />"),
    IMAGE_PLAY(
        "image-play",
        "<path d=\"M15 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M21 12.17V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h6\" />\n  <path d=\"m6 21 5-5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_PLUS(
        "image-plus",
        "<path d=\"M16 5h6\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"M21 11.5V19a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h7.5\" />\n  <path d=\"m21 15-3.086-3.086a2 2 0 0 0-2.828 0L6 21\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UP(
        "image-up",
        "<path d=\"M10.3 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v10l-3.1-3.1a2 2 0 0 0-2.814.014L6 21\" />\n  <path d=\"m14 19.5 3-3 3 3\" />\n  <path d=\"M17 22v-5.5\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />"),
    IMAGE_UPSCALE(
        "image-upscale",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"M17 21h2a2 2 0 0 0 2-2\" />\n  <path d=\"M21 12v3\" />\n  <path d=\"m21 3-5 5\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2\" />\n  <path d=\"m5 21 4.144-4.144a1.21 1.21 0 0 1 1.712 0L13 19\" />\n  <path d=\"M9 3h3\" />\n  <rect x=\"3\" y=\"11\" width=\"10\" height=\"10\" rx=\"1\" />"),
    IMAGES(
        "images",
        "<path d=\"m22 11-1.296-1.296a2.4 2.4 0 0 0-3.408 0L11 16\" />\n  <path d=\"M4 8a2 2 0 0 0-2 2v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2\" />\n  <circle cx=\"13\" cy=\"7\" r=\"1\" fill=\"currentColor\" />\n  <rect x=\"8\" y=\"2\" width=\"14\" height=\"14\" rx=\"2\" />"),
    INFINITY(
        "infinity", "<path d=\"M6 16c5 0 7-8 12-8a4 4 0 0 1 0 8c-5 0-7-8-12-8a4 4 0 1 0 0 8\" />"),
    KEYBOARD_MUSIC(
        "keyboard-music",
        "<rect width=\"20\" height=\"16\" x=\"2\" y=\"4\" rx=\"2\" />\n  <path d=\"M6 8h4\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M18 8h.01\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"M6 12v4\" />\n  <path d=\"M10 12v4\" />\n  <path d=\"M14 12v4\" />\n  <path d=\"M18 12v4\" />"),
    LECTERN(
        "lectern",
        "<path d=\"M15 13h4a2 2 0 001.901-1.38l1.057-4.333A1 1 0 0021 6H3a1 1 0 00-.958 1.287L3.1 11.621A2 2 0 005.001 13h4\" />\n  <path d=\"M15 22V11a1 1 0 00-1-1h-4a1 1 0 00-1 1v11\" />\n  <path d=\"M18 22H6\" />\n  <path d=\"M18 6V3a1 1 0 00-1-1h-3\" />"),
    LIBRARY(
        "library",
        "<path d=\"m16 6 4 14\" />\n  <path d=\"M12 6v14\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M4 4v16\" />"),
    LIBRARY_BIG(
        "library-big",
        "<rect width=\"8\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M20.4 18.9c.2.5-.1 1.1-.6 1.3l-1.9.7c-.5.2-1.1-.1-1.3-.6L11.1 5.1c-.2-.5.1-1.1.6-1.3l1.9-.7c.5-.2 1.1.1 1.3.6Z\" />"),
    LIST_END(
        "list-end",
        "<path d=\"M16 5H3\" />\n  <path d=\"M16 12H3\" />\n  <path d=\"M9 19H3\" />\n  <path d=\"m16 16-3 3 3 3\" />\n  <path d=\"M21 5v12a2 2 0 0 1-2 2h-6\" />"),
    LIST_MINUS(
        "list-minus",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"M21 12h-6\" />"),
    LIST_MUSIC(
        "list-music",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M11 19H3\" />\n  <path d=\"M21 16V5\" />\n  <circle cx=\"18\" cy=\"16\" r=\"3\" />"),
    LIST_PLUS(
        "list-plus",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"M18 9v6\" />\n  <path d=\"M21 12h-6\" />"),
    LIST_RESTART(
        "list-restart",
        "<path d=\"M21 5H3\" />\n  <path d=\"M7 12H3\" />\n  <path d=\"M7 19H3\" />\n  <path d=\"M12 18a5 5 0 0 0 9-3 4.5 4.5 0 0 0-4.5-4.5c-1.33 0-2.54.54-3.41 1.41L11 14\" />\n  <path d=\"M11 10v4h4\" />"),
    LIST_START(
        "list-start",
        "<path d=\"M3 5h6\" />\n  <path d=\"M3 12h13\" />\n  <path d=\"M3 19h13\" />\n  <path d=\"m16 8-3-3 3-3\" />\n  <path d=\"M21 19V7a2 2 0 0 0-2-2h-6\" />"),
    LIST_VIDEO(
        "list-video",
        "<path d=\"M21 5H3\" />\n  <path d=\"M10 12H3\" />\n  <path d=\"M10 19H3\" />\n  <path d=\"M15 12.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />"),
    LIST_X(
        "list-x",
        "<path d=\"M16 5H3\" />\n  <path d=\"M11 12H3\" />\n  <path d=\"M16 19H3\" />\n  <path d=\"m15.5 9.5 5 5\" />\n  <path d=\"m20.5 9.5-5 5\" />"),
    LOADER(
        "loader",
        "<path d=\"M12 2v4\" />\n  <path d=\"m16.2 7.8 2.9-2.9\" />\n  <path d=\"M18 12h4\" />\n  <path d=\"m16.2 16.2 2.9 2.9\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"m4.9 19.1 2.9-2.9\" />\n  <path d=\"M2 12h4\" />\n  <path d=\"m4.9 4.9 2.9 2.9\" />"),
    LOADER_CIRCLE("loader-circle", "<path d=\"M21 12a9 9 0 1 1-6.219-8.56\" />"),
    MEGAPHONE(
        "megaphone",
        "<path d=\"M11 6a13 13 0 0 0 8.4-2.8A1 1 0 0 1 21 4v12a1 1 0 0 1-1.6.8A13 13 0 0 0 11 14H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2z\" />\n  <path d=\"M6 14a12 12 0 0 0 2.4 7.2 2 2 0 0 0 3.2-2.4A8 8 0 0 1 10 14\" />\n  <path d=\"M8 6v8\" />"),
    MEGAPHONE_OFF(
        "megaphone-off",
        "<path d=\"M11.636 6A13 13 0 0 0 19.4 3.2 1 1 0 0 1 21 4v11.344\" />\n  <path d=\"M14.378 14.357A13 13 0 0 0 11 14H5a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h1\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M6 14a12 12 0 0 0 2.4 7.2 2 2 0 0 0 3.2-2.4A8 8 0 0 1 10 14\" />\n  <path d=\"M8 8v6\" />"),
    METRONOME(
        "metronome",
        "<path d=\"M12 11.4V9.1\" />\n  <path d=\"m12 17 6.59-6.59\" />\n  <path d=\"m15.05 5.7-.218-.691a3 3 0 0 0-5.663 0L4.418 19.695A1 1 0 0 0 5.37 21h13.253a1 1 0 0 0 .951-1.31L18.45 16.2\" />\n  <circle cx=\"20\" cy=\"9\" r=\"2\" />"),
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
    MIDI_PORT(
        "midi-port",
        "<path d=\"M12 18h.01\" />\n  <path d=\"M15 2.458V5a1 1 0 01-1 1h-4a1 1 0 01-1-1V2.458\" />\n  <path d=\"M16 16h.01\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M8 16h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    MONITOR_PAUSE(
        "monitor-pause",
        "<path d=\"M10 13V7\" />\n  <path d=\"M14 13V7\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />"),
    MONITOR_PLAY(
        "monitor-play",
        "<path d=\"M15.033 9.44a.647.647 0 0 1 0 1.12l-4.065 2.352a.645.645 0 0 1-.968-.56V7.648a.645.645 0 0 1 .967-.56z\" />\n  <path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />"),
    MONITOR_STOP(
        "monitor-stop",
        "<path d=\"M12 17v4\" />\n  <path d=\"M8 21h8\" />\n  <rect x=\"2\" y=\"3\" width=\"20\" height=\"14\" rx=\"2\" />\n  <rect x=\"9\" y=\"7\" width=\"6\" height=\"6\" rx=\"1\" />"),
    NEWSPAPER(
        "newspaper",
        "<path d=\"M15 18h-5\" />\n  <path d=\"M18 14h-8\" />\n  <path d=\"M4 22h16a2 2 0 0 0 2-2V4a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16a2 2 0 0 1-4 0v-9a2 2 0 0 1 2-2h2\" />\n  <rect width=\"8\" height=\"4\" x=\"10\" y=\"6\" rx=\"1\" />"),
    OCTAGON_PAUSE(
        "octagon-pause",
        "<path d=\"M10 15V9\" />\n  <path d=\"M14 15V9\" />\n  <path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />"),
    PAUSE(
        "pause",
        "<rect x=\"14\" y=\"3\" width=\"5\" height=\"18\" rx=\"1\" />\n  <rect x=\"5\" y=\"3\" width=\"5\" height=\"18\" rx=\"1\" />"),
    PIANO(
        "piano",
        "<path d=\"M10 13v4\" />\n  <path d=\"M14 13v4\" />\n  <path d=\"M18 13v4\" />\n  <path d=\"M2 13h20\" />\n  <path d=\"M22 11.5A3.5 3.5 0 0018.5 8a3.52 3.52 0 01-3.173-2A7 7 0 002 9v10a2 2 0 002 2h16a2 2 0 002-2z\" />\n  <path d=\"M6 13v4\" />"),
    PICTURE_IN_PICTURE(
        "picture-in-picture",
        "<path d=\"M2 10h6V4\" />\n  <path d=\"m2 4 6 6\" />\n  <path d=\"M21 10V7a2 2 0 0 0-2-2h-7\" />\n  <path d=\"M3 14v2a2 2 0 0 0 2 2h3\" />\n  <rect x=\"12\" y=\"14\" width=\"10\" height=\"7\" rx=\"1\" />"),
    PICTURE_IN_PICTURE_2(
        "picture-in-picture-2",
        "<path d=\"M21 9V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v10c0 1.1.9 2 2 2h4\" />\n  <rect width=\"10\" height=\"7\" x=\"12\" y=\"13\" rx=\"2\" />"),
    PLAY(
        "play",
        "<path d=\"M5 5a2 2 0 0 1 3.008-1.728l11.997 6.998a2 2 0 0 1 .003 3.458l-12 7A2 2 0 0 1 5 19z\" />"),
    PLAY_OFF(
        "play-off",
        "<path d=\"m10.215 4.56 9.79 5.71a2 2 0 0 1 .003 3.458l-.393.23\" />\n  <path d=\"m16.042 16.042-8.034 4.686A2 2 0 0 1 5 19V5\" />\n  <path d=\"m2 2 20 20\" />"),
    POPCORN(
        "popcorn",
        "<path d=\"M18 8a2 2 0 0 0 0-4 2 2 0 0 0-4 0 2 2 0 0 0-4 0 2 2 0 0 0-4 0 2 2 0 0 0 0 4\" />\n  <path d=\"M10 22 9 8\" />\n  <path d=\"m14 22 1-14\" />\n  <path d=\"M20 8c.5 0 .9.4.8 1l-2.6 12c-.1.5-.7 1-1.2 1H7c-.6 0-1.1-.4-1.2-1L3.2 9c-.1-.6.3-1 .8-1Z\" />"),
    PRESENTATION(
        "presentation",
        "<path d=\"M2 3h20\" />\n  <path d=\"M21 3v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V3\" />\n  <path d=\"m7 21 5-5 5 5\" />"),
    PROJECTOR(
        "projector",
        "<path d=\"M5 7 3 5\" />\n  <path d=\"M9 6V3\" />\n  <path d=\"m13 7 2-2\" />\n  <circle cx=\"9\" cy=\"13\" r=\"3\" />\n  <path d=\"M11.83 12H20a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-4a2 2 0 0 1 2-2h2.17\" />\n  <path d=\"M16 16h2\" />"),
    RADIO(
        "radio",
        "<path d=\"M16.247 7.761a6 6 0 0 1 0 8.478\" />\n  <path d=\"M19.075 4.933a10 10 0 0 1 0 14.134\" />\n  <path d=\"M4.925 19.067a10 10 0 0 1 0-14.134\" />\n  <path d=\"M7.753 16.239a6 6 0 0 1 0-8.478\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    RADIO_OFF(
        "radio-off",
        "<path d=\"M13.414 13.414a2 2 0 1 1-2.828-2.828\" />\n  <path d=\"M16.247 7.761a6 6 0 0 1 1.744 4.572\" />\n  <path d=\"M19.075 4.933a10 10 0 0 1 2.234 10.72\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M4.925 19.067a10 10 0 0 1 0-14.134\" />\n  <path d=\"M7.753 16.239a6 6 0 0 1 0-8.478\" />"),
    RADIO_TOWER(
        "radio-tower",
        "<path d=\"M4.9 16.1C1 12.2 1 5.8 4.9 1.9\" />\n  <path d=\"M7.8 4.7a6.14 6.14 0 0 0-.8 7.5\" />\n  <circle cx=\"12\" cy=\"9\" r=\"2\" />\n  <path d=\"M16.2 4.8c2 2 2.26 5.11.8 7.47\" />\n  <path d=\"M19.1 1.9a9.96 9.96 0 0 1 0 14.1\" />\n  <path d=\"M9.5 18h5\" />\n  <path d=\"m8 22 4-11 4 11\" />"),
    RECTANGLE_GOGGLES(
        "rectangle-goggles",
        "<path d=\"M20 6a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2h-4a2 2 0 0 1-1.6-.8l-1.6-2.13a1 1 0 0 0-1.6 0L9.6 17.2A2 2 0 0 1 8 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2z\" />"),
    REPEAT(
        "repeat",
        "<path d=\"m17 2 4 4-4 4\" />\n  <path d=\"M3 11v-1a4 4 0 0 1 4-4h14\" />\n  <path d=\"m7 22-4-4 4-4\" />\n  <path d=\"M21 13v1a4 4 0 0 1-4 4H3\" />"),
    REPEAT_1(
        "repeat-1",
        "<path d=\"m17 2 4 4-4 4\" />\n  <path d=\"M3 11v-1a4 4 0 0 1 4-4h14\" />\n  <path d=\"m7 22-4-4 4-4\" />\n  <path d=\"M21 13v1a4 4 0 0 1-4 4H3\" />\n  <path d=\"M11 10h1v4\" />"),
    REPEAT_2(
        "repeat-2",
        "<path d=\"m2 9 3-3 3 3\" />\n  <path d=\"M13 18H7a2 2 0 0 1-2-2V6\" />\n  <path d=\"m22 15-3 3-3-3\" />\n  <path d=\"M11 6h6a2 2 0 0 1 2 2v10\" />"),
    REPEAT_OFF(
        "repeat-off",
        "<path d=\"M11.656 6H21l-4-4\" />\n  <path d=\"M17.898 17.898A4 4 0 0 1 17 18H3l4-4\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 13v1a4 4 0 0 1-.171 1.159\" />\n  <path d=\"m21 6-4 4\" />\n  <path d=\"M3 11v-1a4 4 0 0 1 3.102-3.898\" />\n  <path d=\"m7 22-4-4\" />"),
    REWIND(
        "rewind",
        "<path d=\"M12 6a2 2 0 0 0-3.414-1.414l-6 6a2 2 0 0 0 0 2.828l6 6A2 2 0 0 0 12 18z\" />\n  <path d=\"M22 6a2 2 0 0 0-3.414-1.414l-6 6a2 2 0 0 0 0 2.828l6 6A2 2 0 0 0 22 18z\" />"),
    SATELLITE_DISH(
        "satellite-dish",
        "<path d=\"M18 12a6 6 0 00-6-6\" />\n  <path d=\"M2.824 10.459a8 8 0 0010.717 10.717c.558-.276.623-1.012.183-1.452l-9.448-9.448c-.44-.44-1.176-.375-1.452.183\" />\n  <path d=\"M22 12A10 10 0 0012 2\" />\n  <path d=\"m9 15 4-4\" />"),
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    SCAN_SEARCH(
        "scan-search",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"m16 16-1.9-1.9\" />"),
    SHUFFLE(
        "shuffle",
        "<path d=\"m18 14 4 4-4 4\" />\n  <path d=\"m18 2 4 4-4 4\" />\n  <path d=\"M2 18h1.973a4 4 0 0 0 3.3-1.7l5.454-8.6a4 4 0 0 1 3.3-1.7H22\" />\n  <path d=\"M2 6h1.972a4 4 0 0 1 3.6 2.2\" />\n  <path d=\"M22 18h-6.041a4 4 0 0 1-3.3-1.8l-.359-.45\" />"),
    SIXTEENTH_NOTES(
        "sixteenth-notes",
        "<path d=\"M21 16V3a1 1 0 0 0-1.28-.96l-10 2.917a1 1 0 0 0-.72.96V19\" />\n  <path d=\"M21 6 9 9.5\" />\n  <circle cx=\"18\" cy=\"16\" r=\"3\" />\n  <circle cx=\"6\" cy=\"19\" r=\"3\" />"),
    SKIP_BACK(
        "skip-back",
        "<path d=\"M17.971 4.285A2 2 0 0 1 21 6v12a2 2 0 0 1-3.029 1.715l-9.997-5.998a2 2 0 0 1-.003-3.432z\" />\n  <path d=\"M3 20V4\" />"),
    SKIP_FORWARD(
        "skip-forward",
        "<path d=\"M21 4v16\" />\n  <path d=\"M6.029 4.285A2 2 0 0 0 3 6v12a2 2 0 0 0 3.029 1.715l9.997-5.998a2 2 0 0 0 .003-3.432z\" />"),
    SPARKLES(
        "sparkles",
        "<path d=\"M11.017 2.814a1 1 0 0 1 1.966 0l1.051 5.558a2 2 0 0 0 1.594 1.594l5.558 1.051a1 1 0 0 1 0 1.966l-5.558 1.051a2 2 0 0 0-1.594 1.594l-1.051 5.558a1 1 0 0 1-1.966 0l-1.051-5.558a2 2 0 0 0-1.594-1.594l-5.558-1.051a1 1 0 0 1 0-1.966l5.558-1.051a2 2 0 0 0 1.594-1.594z\" />\n  <path d=\"M20 2v4\" />\n  <path d=\"M22 4h-4\" />\n  <circle cx=\"4\" cy=\"20\" r=\"2\" />"),
    SPEAKER(
        "speaker",
        "<rect width=\"16\" height=\"20\" x=\"4\" y=\"2\" rx=\"2\" />\n  <path d=\"M12 6h.01\" />\n  <circle cx=\"12\" cy=\"14\" r=\"4\" />\n  <path d=\"M12 14h.01\" />"),
    SPOTLIGHT(
        "spotlight",
        "<path d=\"M15.295 19.562 16 22\" />\n  <path d=\"m17 16 3.758 2.098\" />\n  <path d=\"m19 12.5 3.026-.598\" />\n  <path d=\"M7.61 6.3a3 3 0 0 0-3.92 1.3l-1.38 2.79a3 3 0 0 0 1.3 3.91l6.89 3.597a1 1 0 0 0 1.342-.447l3.106-6.211a1 1 0 0 0-.447-1.341z\" />\n  <path d=\"M8 9V2\" />"),
    SQUARE("square", "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />"),
    SQUARE_ACTIVITY(
        "square-activity",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M17 12h-2l-2 5-2-10-2 5H7\" />"),
    SQUARE_ARROW_RIGHT_ENTER(
        "square-arrow-right-enter",
        "<path d=\"m10 16 4-4-4-4\" />\n  <path d=\"M3 12h11\" />\n  <path d=\"M3 8V5a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2v-3\" />"),
    SQUARE_ARROW_RIGHT_EXIT(
        "square-arrow-right-exit",
        "<path d=\"M10 12h11\" />\n  <path d=\"m17 16 4-4-4-4\" />\n  <path d=\"M21 6.344V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-1.344\" />"),
    SQUARE_BOOKMARK(
        "square-bookmark",
        "<path d=\"M11 3v7.751a.25.25 0 00.407.195l2.28-1.834a.5.5 0 01.627 0l2.28 1.834a.25.25 0 00.406-.195V3\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_LIBRARY(
        "square-library",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7v10\" />\n  <path d=\"M11 7v10\" />\n  <path d=\"m15 7 2 10\" />"),
    SQUARE_PAUSE(
        "square-pause",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <line x1=\"10\" x2=\"10\" y1=\"15\" y2=\"9\" />\n  <line x1=\"14\" x2=\"14\" y1=\"15\" y2=\"9\" />"),
    SQUARE_PLAY(
        "square-play",
        "<rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />\n  <path d=\"M9 9.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997A1 1 0 0 1 9 14.996z\" />"),
    SQUARE_SPARKLES(
        "square-sparkles",
        "<path d=\"M11 15H7\" />\n  <path d=\"M15.41 2.49a.6.6 0 011.18 0l.63 3.334a1.2 1.2 0 00.956.955l3.334.631a.6.6 0 010 1.18l-3.334.63a1.2 1.2 0 00-.955.956l-.631 3.334a.6.6 0 01-1.18 0l-.63-3.334a1.2 1.2 0 00-.956-.955L10.49 8.59a.6.6 0 010-1.18l3.334-.63a1.2 1.2 0 00.955-.956z\" />\n  <path d=\"M21 13v6a2 2 0 01-2 2H5a2 2 0 01-2-2V5a2 2 0 012-2h6\" />\n  <path d=\"M9 13v4\" />"),
    SQUARE_STOP(
        "square-stop",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <rect x=\"9\" y=\"9\" width=\"6\" height=\"6\" rx=\"1\" />"),
    STAR(
        "star",
        "<path d=\"M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z\" />"),
    STAR_CHECK(
        "star-check",
        "<path d=\"m19.06 12.501 2.78-2.707a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />\n  <path d=\"m15 18 2 2 4-4\" />"),
    STAR_HALF(
        "star-half",
        "<path d=\"M12 18.338a2.1 2.1 0 0 0-.987.244L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.12 2.12 0 0 0 1.597-1.16l2.309-4.679A.53.53 0 0 1 12 2\" />"),
    STAR_MINUS(
        "star-minus",
        "<path d=\"M15 18h6\" />\n  <path d=\"M17.688 14a2.1 2.1 0 0 1 .416-.568l3.736-3.638a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />"),
    STAR_OFF(
        "star-off",
        "<path d=\"m10.344 4.688 1.181-2.393a.53.53 0 0 1 .95 0l2.31 4.679a2.12 2.12 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.237 3.152\" />\n  <path d=\"m17.945 17.945.43 2.505a.53.53 0 0 1-.771.56l-4.618-2.428a2.12 2.12 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a8 8 0 0 0 .4-.099\" />\n  <path d=\"m2 2 20 20\" />"),
    STAR_PLUS(
        "star-plus",
        "<path d=\"M11.013 18.582 6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.12 2.12 0 0 0 1.597-1.16l2.309-4.679a.53.53 0 0 1 .95 0l2.31 4.679a2.12 2.12 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904L20 11.5\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    STAR_X(
        "star-x",
        "<path d=\"m15.5 15.5 5 5\" />\n  <path d=\"m20.063 11.525 1.777-1.731a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428a2.1 2.1 0 0 1 .987-.243 2 2 0 0 1 .132.004\" />\n  <path d=\"m20.5 15.5-5 5\" />"),
    STEP_BACK(
        "step-back",
        "<path d=\"M13.971 4.285A2 2 0 0 1 17 6v12a2 2 0 0 1-3.029 1.715l-9.997-5.998a2 2 0 0 1-.003-3.432z\" />\n  <path d=\"M21 20V4\" />"),
    STEP_FORWARD(
        "step-forward",
        "<path d=\"M10.029 4.285A2 2 0 0 0 7 6v12a2 2 0 0 0 3.029 1.715l9.997-5.998a2 2 0 0 0 .003-3.432z\" />\n  <path d=\"M3 4v16\" />"),
    TURNTABLE(
        "turntable",
        "<path d=\"M10 12.01h.01\" />\n  <path d=\"M18 8v4a8 8 0 0 1-1.07 4\" />\n  <circle cx=\"10\" cy=\"12\" r=\"4\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    TV(
        "tv",
        "<path d=\"m17 2-5 5-5-5\" />\n  <rect width=\"20\" height=\"15\" x=\"2\" y=\"7\" rx=\"2\" />"),
    TV_MINIMAL(
        "tv-minimal",
        "<path d=\"M7 21h10\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />"),
    TV_MINIMAL_PLAY(
        "tv-minimal-play",
        "<path d=\"M15.033 9.44a.647.647 0 0 1 0 1.12l-4.065 2.352a.645.645 0 0 1-.968-.56V7.648a.645.645 0 0 1 .967-.56z\" />\n  <path d=\"M7 21h10\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"3\" rx=\"2\" />"),
    USB(
        "usb",
        "<circle cx=\"10\" cy=\"7\" r=\"1\" />\n  <circle cx=\"4\" cy=\"20\" r=\"1\" />\n  <path d=\"M4.7 19.3 19 5\" />\n  <path d=\"m21 3-3 1 2 2Z\" />\n  <path d=\"M9.26 7.68 5 12l2 5\" />\n  <path d=\"m10 14 5 2 3.5-3.5\" />\n  <path d=\"m18 12 1-1 1 1-1 1Z\" />"),
    USB_C_PORT(
        "usb-c-port",
        "<path d=\"M6 12h12\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"8\" rx=\"4\" />"),
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
    WAVES_HORIZONTAL(
        "waves-horizontal",
        "<path d=\"M2 12q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 19q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 5q2.5 2 5 0t5 0 5 0 5 0\" />");

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
  default LucideIcon activity_multimedia() {
    return LucideIcon.create(Icon.ACTIVITY);
  }

  default LucideIcon ad_multimedia() {
    return LucideIcon.create(Icon.AD);
  }

  default LucideIcon airplay_multimedia() {
    return LucideIcon.create(Icon.AIRPLAY);
  }

  default LucideIcon antenna_multimedia() {
    return LucideIcon.create(Icon.ANTENNA);
  }

  default LucideIcon audio_lines_multimedia() {
    return LucideIcon.create(Icon.AUDIO_LINES);
  }

  default LucideIcon audio_lines_off_multimedia() {
    return LucideIcon.create(Icon.AUDIO_LINES_OFF);
  }

  default LucideIcon audio_lines_x_multimedia() {
    return LucideIcon.create(Icon.AUDIO_LINES_X);
  }

  default LucideIcon audio_waveform_multimedia() {
    return LucideIcon.create(Icon.AUDIO_WAVEFORM);
  }

  default LucideIcon book_audio_multimedia() {
    return LucideIcon.create(Icon.BOOK_AUDIO);
  }

  default LucideIcon book_headphones_multimedia() {
    return LucideIcon.create(Icon.BOOK_HEADPHONES);
  }

  default LucideIcon book_image_multimedia() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon boom_box_multimedia() {
    return LucideIcon.create(Icon.BOOM_BOX);
  }

  default LucideIcon cable_multimedia() {
    return LucideIcon.create(Icon.CABLE);
  }

  default LucideIcon captions() {
    return LucideIcon.create(Icon.CAPTIONS);
  }

  default LucideIcon captions_off() {
    return LucideIcon.create(Icon.CAPTIONS_OFF);
  }

  default LucideIcon card_sim_multimedia() {
    return LucideIcon.create(Icon.CARD_SIM);
  }

  default LucideIcon cassette_tape_multimedia() {
    return LucideIcon.create(Icon.CASSETTE_TAPE);
  }

  default LucideIcon chevron_first_multimedia() {
    return LucideIcon.create(Icon.CHEVRON_FIRST);
  }

  default LucideIcon chevron_last_multimedia() {
    return LucideIcon.create(Icon.CHEVRON_LAST);
  }

  default LucideIcon chevrons_left_right_ellipsis_multimedia() {
    return LucideIcon.create(Icon.CHEVRONS_LEFT_RIGHT_ELLIPSIS);
  }

  default LucideIcon circle_chevrons_left_multimedia() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_LEFT);
  }

  default LucideIcon circle_chevrons_right_multimedia() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_RIGHT);
  }

  default LucideIcon circle_fading_play_multimedia() {
    return LucideIcon.create(Icon.CIRCLE_FADING_PLAY);
  }

  default LucideIcon circle_pause() {
    return LucideIcon.create(Icon.CIRCLE_PAUSE);
  }

  default LucideIcon circle_play() {
    return LucideIcon.create(Icon.CIRCLE_PLAY);
  }

  default LucideIcon circle_stop() {
    return LucideIcon.create(Icon.CIRCLE_STOP);
  }

  default LucideIcon clapperboard() {
    return LucideIcon.create(Icon.CLAPPERBOARD);
  }

  default LucideIcon clef_alto() {
    return LucideIcon.create(Icon.CLEF_ALTO);
  }

  default LucideIcon clef_bass() {
    return LucideIcon.create(Icon.CLEF_BASS);
  }

  default LucideIcon clef_treble() {
    return LucideIcon.create(Icon.CLEF_TREBLE);
  }

  default LucideIcon closed_caption_multimedia() {
    return LucideIcon.create(Icon.CLOSED_CAPTION);
  }

  default LucideIcon diamond_minus_multimedia() {
    return LucideIcon.create(Icon.DIAMOND_MINUS);
  }

  default LucideIcon diamond_plus_multimedia() {
    return LucideIcon.create(Icon.DIAMOND_PLUS);
  }

  default LucideIcon disc_multimedia() {
    return LucideIcon.create(Icon.DISC);
  }

  default LucideIcon disc_2_multimedia() {
    return LucideIcon.create(Icon.DISC_2);
  }

  default LucideIcon disc_3_multimedia() {
    return LucideIcon.create(Icon.DISC_3);
  }

  default LucideIcon disc_album_multimedia() {
    return LucideIcon.create(Icon.DISC_ALBUM);
  }

  default LucideIcon drama() {
    return LucideIcon.create(Icon.DRAMA);
  }

  default LucideIcon drum_multimedia() {
    return LucideIcon.create(Icon.DRUM);
  }

  default LucideIcon eighth_note_multimedia() {
    return LucideIcon.create(Icon.EIGHTH_NOTE);
  }

  default LucideIcon eighth_notes_multimedia() {
    return LucideIcon.create(Icon.EIGHTH_NOTES);
  }

  default LucideIcon eject_multimedia() {
    return LucideIcon.create(Icon.EJECT);
  }

  default LucideIcon ethernet_port_multimedia() {
    return LucideIcon.create(Icon.ETHERNET_PORT);
  }

  default LucideIcon fast_forward_multimedia() {
    return LucideIcon.create(Icon.FAST_FORWARD);
  }

  default LucideIcon file_music_multimedia() {
    return LucideIcon.create(Icon.FILE_MUSIC);
  }

  default LucideIcon film_multimedia() {
    return LucideIcon.create(Icon.FILM);
  }

  default LucideIcon fullscreen_multimedia() {
    return LucideIcon.create(Icon.FULLSCREEN);
  }

  default LucideIcon gallery_horizontal_multimedia() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL);
  }

  default LucideIcon gallery_horizontal_end_multimedia() {
    return LucideIcon.create(Icon.GALLERY_HORIZONTAL_END);
  }

  default LucideIcon gallery_thumbnails_multimedia() {
    return LucideIcon.create(Icon.GALLERY_THUMBNAILS);
  }

  default LucideIcon gallery_vertical_multimedia() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL);
  }

  default LucideIcon gallery_vertical_end_multimedia() {
    return LucideIcon.create(Icon.GALLERY_VERTICAL_END);
  }

  default LucideIcon guitar() {
    return LucideIcon.create(Icon.GUITAR);
  }

  default LucideIcon guitar_electric() {
    return LucideIcon.create(Icon.GUITAR_ELECTRIC);
  }

  default LucideIcon half_note_multimedia() {
    return LucideIcon.create(Icon.HALF_NOTE);
  }

  default LucideIcon hand_metal_multimedia() {
    return LucideIcon.create(Icon.HAND_METAL);
  }

  default LucideIcon hd_multimedia() {
    return LucideIcon.create(Icon.HD);
  }

  default LucideIcon hdmi_port_multimedia() {
    return LucideIcon.create(Icon.HDMI_PORT);
  }

  default LucideIcon headphone_off_multimedia() {
    return LucideIcon.create(Icon.HEADPHONE_OFF);
  }

  default LucideIcon headphones_multimedia() {
    return LucideIcon.create(Icon.HEADPHONES);
  }

  default LucideIcon headset_multimedia() {
    return LucideIcon.create(Icon.HEADSET);
  }

  default LucideIcon heart_multimedia() {
    return LucideIcon.create(Icon.HEART);
  }

  default LucideIcon heart_minus_multimedia() {
    return LucideIcon.create(Icon.HEART_MINUS);
  }

  default LucideIcon heart_off_multimedia() {
    return LucideIcon.create(Icon.HEART_OFF);
  }

  default LucideIcon heart_plus_multimedia() {
    return LucideIcon.create(Icon.HEART_PLUS);
  }

  default LucideIcon heart_x_multimedia() {
    return LucideIcon.create(Icon.HEART_X);
  }

  default LucideIcon image_multimedia() {
    return LucideIcon.create(Icon.IMAGE);
  }

  default LucideIcon image_down_multimedia() {
    return LucideIcon.create(Icon.IMAGE_DOWN);
  }

  default LucideIcon image_minus_multimedia() {
    return LucideIcon.create(Icon.IMAGE_MINUS);
  }

  default LucideIcon image_off_multimedia() {
    return LucideIcon.create(Icon.IMAGE_OFF);
  }

  default LucideIcon image_play_multimedia() {
    return LucideIcon.create(Icon.IMAGE_PLAY);
  }

  default LucideIcon image_plus_multimedia() {
    return LucideIcon.create(Icon.IMAGE_PLUS);
  }

  default LucideIcon image_up_multimedia() {
    return LucideIcon.create(Icon.IMAGE_UP);
  }

  default LucideIcon image_upscale_multimedia() {
    return LucideIcon.create(Icon.IMAGE_UPSCALE);
  }

  default LucideIcon images_multimedia() {
    return LucideIcon.create(Icon.IMAGES);
  }

  default LucideIcon infinity() {
    return LucideIcon.create(Icon.INFINITY);
  }

  default LucideIcon keyboard_music_multimedia() {
    return LucideIcon.create(Icon.KEYBOARD_MUSIC);
  }

  default LucideIcon lectern_multimedia() {
    return LucideIcon.create(Icon.LECTERN);
  }

  default LucideIcon library_multimedia() {
    return LucideIcon.create(Icon.LIBRARY);
  }

  default LucideIcon library_big_multimedia() {
    return LucideIcon.create(Icon.LIBRARY_BIG);
  }

  default LucideIcon list_end_multimedia() {
    return LucideIcon.create(Icon.LIST_END);
  }

  default LucideIcon list_minus_multimedia() {
    return LucideIcon.create(Icon.LIST_MINUS);
  }

  default LucideIcon list_music() {
    return LucideIcon.create(Icon.LIST_MUSIC);
  }

  default LucideIcon list_plus_multimedia() {
    return LucideIcon.create(Icon.LIST_PLUS);
  }

  default LucideIcon list_restart_multimedia() {
    return LucideIcon.create(Icon.LIST_RESTART);
  }

  default LucideIcon list_start_multimedia() {
    return LucideIcon.create(Icon.LIST_START);
  }

  default LucideIcon list_video() {
    return LucideIcon.create(Icon.LIST_VIDEO);
  }

  default LucideIcon list_x_multimedia() {
    return LucideIcon.create(Icon.LIST_X);
  }

  default LucideIcon loader_multimedia() {
    return LucideIcon.create(Icon.LOADER);
  }

  default LucideIcon loader_circle_multimedia() {
    return LucideIcon.create(Icon.LOADER_CIRCLE);
  }

  default LucideIcon megaphone_multimedia() {
    return LucideIcon.create(Icon.MEGAPHONE);
  }

  default LucideIcon megaphone_off_multimedia() {
    return LucideIcon.create(Icon.MEGAPHONE_OFF);
  }

  default LucideIcon metronome_multimedia() {
    return LucideIcon.create(Icon.METRONOME);
  }

  default LucideIcon mic_multimedia() {
    return LucideIcon.create(Icon.MIC);
  }

  default LucideIcon mic_audio_lines_multimedia() {
    return LucideIcon.create(Icon.MIC_AUDIO_LINES);
  }

  default LucideIcon mic_off_multimedia() {
    return LucideIcon.create(Icon.MIC_OFF);
  }

  default LucideIcon mic_signal_multimedia() {
    return LucideIcon.create(Icon.MIC_SIGNAL);
  }

  default LucideIcon mic_vocal_multimedia() {
    return LucideIcon.create(Icon.MIC_VOCAL);
  }

  default LucideIcon midi_port_multimedia() {
    return LucideIcon.create(Icon.MIDI_PORT);
  }

  default LucideIcon monitor_pause_multimedia() {
    return LucideIcon.create(Icon.MONITOR_PAUSE);
  }

  default LucideIcon monitor_play_multimedia() {
    return LucideIcon.create(Icon.MONITOR_PLAY);
  }

  default LucideIcon monitor_stop_multimedia() {
    return LucideIcon.create(Icon.MONITOR_STOP);
  }

  default LucideIcon newspaper_multimedia() {
    return LucideIcon.create(Icon.NEWSPAPER);
  }

  default LucideIcon octagon_pause_multimedia() {
    return LucideIcon.create(Icon.OCTAGON_PAUSE);
  }

  default LucideIcon pause() {
    return LucideIcon.create(Icon.PAUSE);
  }

  default LucideIcon piano_multimedia() {
    return LucideIcon.create(Icon.PIANO);
  }

  default LucideIcon picture_in_picture() {
    return LucideIcon.create(Icon.PICTURE_IN_PICTURE);
  }

  default LucideIcon picture_in_picture_2() {
    return LucideIcon.create(Icon.PICTURE_IN_PICTURE_2);
  }

  default LucideIcon play_multimedia() {
    return LucideIcon.create(Icon.PLAY);
  }

  default LucideIcon play_off() {
    return LucideIcon.create(Icon.PLAY_OFF);
  }

  default LucideIcon popcorn() {
    return LucideIcon.create(Icon.POPCORN);
  }

  default LucideIcon presentation_multimedia() {
    return LucideIcon.create(Icon.PRESENTATION);
  }

  default LucideIcon projector_multimedia() {
    return LucideIcon.create(Icon.PROJECTOR);
  }

  default LucideIcon radio_multimedia() {
    return LucideIcon.create(Icon.RADIO);
  }

  default LucideIcon radio_off_multimedia() {
    return LucideIcon.create(Icon.RADIO_OFF);
  }

  default LucideIcon radio_tower_multimedia() {
    return LucideIcon.create(Icon.RADIO_TOWER);
  }

  default LucideIcon rectangle_goggles_multimedia() {
    return LucideIcon.create(Icon.RECTANGLE_GOGGLES);
  }

  default LucideIcon repeat_multimedia() {
    return LucideIcon.create(Icon.REPEAT);
  }

  default LucideIcon repeat_1() {
    return LucideIcon.create(Icon.REPEAT_1);
  }

  default LucideIcon repeat_2_multimedia() {
    return LucideIcon.create(Icon.REPEAT_2);
  }

  default LucideIcon repeat_off_multimedia() {
    return LucideIcon.create(Icon.REPEAT_OFF);
  }

  default LucideIcon rewind_multimedia() {
    return LucideIcon.create(Icon.REWIND);
  }

  default LucideIcon satellite_dish_multimedia() {
    return LucideIcon.create(Icon.SATELLITE_DISH);
  }

  default LucideIcon scan_eye_multimedia() {
    return LucideIcon.create(Icon.SCAN_EYE);
  }

  default LucideIcon scan_search_multimedia() {
    return LucideIcon.create(Icon.SCAN_SEARCH);
  }

  default LucideIcon shuffle_multimedia() {
    return LucideIcon.create(Icon.SHUFFLE);
  }

  default LucideIcon sixteenth_notes_multimedia() {
    return LucideIcon.create(Icon.SIXTEENTH_NOTES);
  }

  default LucideIcon skip_back_multimedia() {
    return LucideIcon.create(Icon.SKIP_BACK);
  }

  default LucideIcon skip_forward_multimedia() {
    return LucideIcon.create(Icon.SKIP_FORWARD);
  }

  default LucideIcon sparkles_multimedia() {
    return LucideIcon.create(Icon.SPARKLES);
  }

  default LucideIcon speaker_multimedia() {
    return LucideIcon.create(Icon.SPEAKER);
  }

  default LucideIcon spotlight_multimedia() {
    return LucideIcon.create(Icon.SPOTLIGHT);
  }

  default LucideIcon square_multimedia() {
    return LucideIcon.create(Icon.SQUARE);
  }

  default LucideIcon square_activity_multimedia() {
    return LucideIcon.create(Icon.SQUARE_ACTIVITY);
  }

  default LucideIcon square_arrow_right_enter_multimedia() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_ENTER);
  }

  default LucideIcon square_arrow_right_exit_multimedia() {
    return LucideIcon.create(Icon.SQUARE_ARROW_RIGHT_EXIT);
  }

  default LucideIcon square_bookmark_multimedia() {
    return LucideIcon.create(Icon.SQUARE_BOOKMARK);
  }

  default LucideIcon square_library_multimedia() {
    return LucideIcon.create(Icon.SQUARE_LIBRARY);
  }

  default LucideIcon square_pause() {
    return LucideIcon.create(Icon.SQUARE_PAUSE);
  }

  default LucideIcon square_play_multimedia() {
    return LucideIcon.create(Icon.SQUARE_PLAY);
  }

  default LucideIcon square_sparkles_multimedia() {
    return LucideIcon.create(Icon.SQUARE_SPARKLES);
  }

  default LucideIcon square_stop() {
    return LucideIcon.create(Icon.SQUARE_STOP);
  }

  default LucideIcon star_multimedia() {
    return LucideIcon.create(Icon.STAR);
  }

  default LucideIcon star_check_multimedia() {
    return LucideIcon.create(Icon.STAR_CHECK);
  }

  default LucideIcon star_half_multimedia() {
    return LucideIcon.create(Icon.STAR_HALF);
  }

  default LucideIcon star_minus_multimedia() {
    return LucideIcon.create(Icon.STAR_MINUS);
  }

  default LucideIcon star_off_multimedia() {
    return LucideIcon.create(Icon.STAR_OFF);
  }

  default LucideIcon star_plus_multimedia() {
    return LucideIcon.create(Icon.STAR_PLUS);
  }

  default LucideIcon star_x_multimedia() {
    return LucideIcon.create(Icon.STAR_X);
  }

  default LucideIcon step_back_multimedia() {
    return LucideIcon.create(Icon.STEP_BACK);
  }

  default LucideIcon step_forward_multimedia() {
    return LucideIcon.create(Icon.STEP_FORWARD);
  }

  default LucideIcon turntable_multimedia() {
    return LucideIcon.create(Icon.TURNTABLE);
  }

  default LucideIcon tv_multimedia() {
    return LucideIcon.create(Icon.TV);
  }

  default LucideIcon tv_minimal_multimedia() {
    return LucideIcon.create(Icon.TV_MINIMAL);
  }

  default LucideIcon tv_minimal_play_multimedia() {
    return LucideIcon.create(Icon.TV_MINIMAL_PLAY);
  }

  default LucideIcon usb_multimedia() {
    return LucideIcon.create(Icon.USB);
  }

  default LucideIcon usb_c_port_multimedia() {
    return LucideIcon.create(Icon.USB_C_PORT);
  }

  default LucideIcon volume_multimedia() {
    return LucideIcon.create(Icon.VOLUME);
  }

  default LucideIcon volume_1_multimedia() {
    return LucideIcon.create(Icon.VOLUME_1);
  }

  default LucideIcon volume_2_multimedia() {
    return LucideIcon.create(Icon.VOLUME_2);
  }

  default LucideIcon volume_off_multimedia() {
    return LucideIcon.create(Icon.VOLUME_OFF);
  }

  default LucideIcon volume_x_multimedia() {
    return LucideIcon.create(Icon.VOLUME_X);
  }

  default LucideIcon waves_horizontal_multimedia() {
    return LucideIcon.create(Icon.WAVES_HORIZONTAL);
  }
}
