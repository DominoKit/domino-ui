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

/** Tabler Laundry catalog category. */
public interface TablerLaundry {
  enum OutlineIcon implements TablerIconDefinition {
    BLEACH(
        "bleach",
        "<path d=\"M5 19h14a2 2 0 0 0 1.84 -2.75l-7.1 -12.25a2 2 0 0 0 -3.5 0l-7.1 12.25a2 2 0 0 0 1.75 2.75\" />"),
    BLEACH_CHLORINE(
        "bleach-chlorine",
        "<path d=\"M5 19h14a2 2 0 0 0 1.84 -2.75l-7.1 -12.25a2 2 0 0 0 -3.5 0l-7.1 12.25a2 2 0 0 0 1.75 2.75\" />\n  <path d=\"M11 12h-1a2 2 0 1 0 0 4h1\" />\n  <path d=\"M14 12v4h2\" />"),
    BLEACH_NO_CHLORINE(
        "bleach-no-chlorine",
        "<path d=\"M5 19h14a2 2 0 0 0 1.84 -2.75l-7.1 -12.25a2 2 0 0 0 -3.5 0l-7.1 12.25a2 2 0 0 0 1.75 2.75\" />\n  <path d=\"M6.576 19l7.907 -13.733\" />\n  <path d=\"M11.719 19.014l5.346 -9.284\" />"),
    BLEACH_OFF(
        "bleach-off",
        "<path d=\"M5 19h14m1.986 -1.977a2 2 0 0 0 -.146 -.773l-7.1 -12.25a2 2 0 0 0 -3.5 0l-.815 1.405m-1.488 2.568l-4.797 8.277a2 2 0 0 0 1.75 2.75\" />\n  <path d=\"M3 3l18 18\" />"),
    IRONING(
        "ironing",
        "<path d=\"M9 6h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.985 1.164h-16.82a7 7 0 0 1 7 -7h9.8\" />"),
    IRONING_1(
        "ironing-1",
        "<path d=\"M9 6h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.985 1.164h-16.82a7 7 0 0 1 7 -7h9.8\" />\n  <path d=\"M12 15h.01\" />"),
    IRONING_2(
        "ironing-2",
        "<path d=\"M10 15h.01\" />\n  <path d=\"M9 6h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.985 1.164h-16.82a7 7 0 0 1 7 -7h9.8\" />\n  <path d=\"M14 15h.01\" />"),
    IRONING_3(
        "ironing-3",
        "<path d=\"M12 15h.01\" />\n  <path d=\"M9 6h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.985 1.164h-16.82a7 7 0 0 1 7 -7h9.8\" />\n  <path d=\"M9 15h.01\" />\n  <path d=\"M15 15h.01\" />"),
    IRONING_OFF(
        "ironing-off",
        "<path d=\"M10 6h6.459a3 3 0 0 1 2.959 2.507l.577 3.464l.804 4.821l.007 .044m-2.806 1.164h-15a7 7 0 0 1 7 -7h1m4 0h4.8\" />\n  <path d=\"M3 3l18 18\" />"),
    IRONING_STEAM(
        "ironing-steam",
        "<path d=\"M12 19v2\" />\n  <path d=\"M9 4h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.985 1.164h-16.82a7 7 0 0 1 7 -7h9.8\" />\n  <path d=\"M8 19l-1 2\" />\n  <path d=\"M16 19l1 2\" />"),
    IRONING_STEAM_OFF(
        "ironing-steam-off",
        "<path d=\"M9 4h7.459a3 3 0 0 1 2.959 2.507l.577 3.464l.81 4.865a1 1 0 0 1 -.821 1.15\" />\n  <path d=\"M16 16h-13a7 7 0 0 1 6.056 -6.937\" />\n  <path d=\"M13 9h6.8\" />\n  <path d=\"M12 19v2\" />\n  <path d=\"M8 19l-1 2\" />\n  <path d=\"M16 19l1 2\" />\n  <path d=\"M3 3l18 18\" />"),
    WASH(
        "wash",
        "<path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />"),
    WASH_DRY(
        "wash-dry",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />"),
    WASH_DRY_1(
        "wash-dry-1",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M12 12h.01\" />"),
    WASH_DRY_2(
        "wash-dry-2",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M10 12h.01\" />\n  <path d=\"M14 12h.01\" />"),
    WASH_DRY_3(
        "wash-dry-3",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M9 12h.01\" />\n  <path d=\"M15 12h.01\" />"),
    WASH_DRY_A(
        "wash-dry-a",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 16v-4.8c0 -1.657 1.343 -3.2 3 -3.2s3 1.543 3 3.2v4.8\" />\n  <path d=\"M15 13h-6\" />"),
    WASH_DRY_DIP(
        "wash-dry-dip",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M12 7v10\" />\n  <path d=\"M16 7v10\" />\n  <path d=\"M8 7v10\" />"),
    WASH_DRY_F(
        "wash-dry-f",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 16v-8h4\" />\n  <path d=\"M13 12h-3\" />"),
    WASH_DRY_FLAT(
        "wash-dry-flat",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M7 12h10\" />"),
    WASH_DRY_HANG(
        "wash-dry-hang",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M4 4.01c5.333 5.323 10.667 5.32 16 -.01\" />"),
    WASH_DRY_OFF(
        "wash-dry-off",
        "<path d=\"M20.116 20.127a2.99 2.99 0 0 1 -2.116 .873h-12a3 3 0 0 1 -3 -3v-12c0 -.827 .335 -1.576 .877 -2.12m3.123 -.88h11a3 3 0 0 1 3 3v11\" />\n  <path d=\"M3 3l18 18\" />"),
    WASH_DRY_P(
        "wash-dry-p",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 16v-8h2.5a2.5 2.5 0 1 1 0 5h-2.5\" />"),
    WASH_DRY_SHADE(
        "wash-dry-shade",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M3 11l8 -8\" />\n  <path d=\"M3 17l14 -14\" />"),
    WASH_DRY_W(
        "wash-dry-w",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M8 8l1.5 8h1l1.5 -6l1.5 6h1l1.5 -8\" />"),
    WASH_DRYCLEAN("wash-dryclean", "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    WASH_DRYCLEAN_OFF(
        "wash-dryclean-off",
        "<path d=\"M20.048 16.033a9 9 0 0 0 -12.094 -12.075m-2.321 1.682a9 9 0 0 0 12.733 12.723\" />\n  <path d=\"M3 3l18 18\" />"),
    WASH_ECO(
        "wash-eco",
        "<path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h5.306m8.162 -6.972l.838 -5.028\" />\n  <path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M16 22s0 -2 3 -4\" />\n  <path d=\"M19 21a3 3 0 0 1 0 -6h3v3a3 3 0 0 1 -3 3\" />"),
    WASH_GENTLE(
        "wash-gentle",
        "<path d=\"M3.486 5.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 3l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M5 18h14\" />\n  <path d=\"M5 21h14\" />"),
    WASH_HAND(
        "wash-hand",
        "<path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.426 -.296 .777 -.5 1.5 -.5h1\" />\n  <path d=\"M16 8l.615 .034c.552 .067 1.046 .23 1.385 .466c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M14 10.5l.586 .578a1.516 1.516 0 0 0 2 0c.476 -.433 .55 -1.112 .176 -1.622l-1.762 -2.456c-.37 -.506 -1.331 -1 -2 -1h-3.117a1 1 0 0 0 -.992 .876l-.499 3.986a3.857 3.857 0 0 0 2.608 4.138a2.28 2.28 0 0 0 3 -2.162v-2.338\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />"),
    WASH_OFF(
        "wash-off",
        "<path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612c.208 0 .41 -.032 .6 -.092m1.521 -2.472l1.573 -9.436\" />\n  <path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5m4.92 .919c.428 -.083 .805 -.227 1.08 -.418c.461 -.322 1.21 -.508 2 -.5c.79 -.008 1.539 .178 2 .5c.461 .32 1.21 .508 2 .5c.17 0 .339 -.015 .503 -.035\" />\n  <path d=\"M3 3l18 18\" />"),
    WASH_PRESS(
        "wash-press",
        "<path d=\"M3.486 7.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 5l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M5 20h14\" />"),
    WASH_TEMPERATURE_1(
        "wash-temperature-1",
        "<path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M12 13h.01\" />"),
    WASH_TEMPERATURE_2(
        "wash-temperature-2",
        "<path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M14 13h.01\" />\n  <path d=\"M10 13h.01\" />"),
    WASH_TEMPERATURE_3(
        "wash-temperature-3",
        "<path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M12 13h.01\" />\n  <path d=\"M15 13h.01\" />\n  <path d=\"M9 13h.01\" />"),
    WASH_TEMPERATURE_4(
        "wash-temperature-4",
        "<path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M10 15h.01\" />\n  <path d=\"M14 15h.01\" />\n  <path d=\"M14 12h.01\" />\n  <path d=\"M10 12h.01\" />"),
    WASH_TEMPERATURE_5(
        "wash-temperature-5",
        "<path d=\"M10 15h.01\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M14 15h.01\" />\n  <path d=\"M15 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M9 12h.01\" />\n  <path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />"),
    WASH_TEMPERATURE_6(
        "wash-temperature-6",
        "<path d=\"M9 15h.01\" />\n  <path d=\"M3 6l1.721 10.329a2 2 0 0 0 1.973 1.671h10.612a2 2 0 0 0 1.973 -1.671l1.721 -10.329\" />\n  <path d=\"M12 15h.01\" />\n  <path d=\"M15 15h.01\" />\n  <path d=\"M15 12h.01\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M9 12h.01\" />\n  <path d=\"M3.486 8.965c.168 .02 .34 .033 .514 .035c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.79 .009 1.539 -.178 2 -.5c.461 -.32 1.21 -.507 2 -.5c.79 -.007 1.539 .18 2 .5c.461 .322 1.21 .509 2 .5c.17 0 .339 -.014 .503 -.034\" />"),
    WASH_TUMBLE_DRY(
        "wash-tumble-dry",
        "<path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />"),
    WASH_TUMBLE_OFF(
        "wash-tumble-off",
        "<path d=\"M20.116 20.127a2.99 2.99 0 0 1 -2.116 .873h-12a3 3 0 0 1 -3 -3v-12c0 -.827 .335 -1.576 .877 -2.12m3.123 -.88h11a3 3 0 0 1 3 3v11\" />\n  <path d=\"M17.744 13.74a6 6 0 0 0 -7.486 -7.482m-2.499 1.497a6 6 0 1 0 8.48 8.49\" />\n  <path d=\"M3 3l18 18\" />");

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
    IRONING(
        "ironing",
        "<path d=\"M16.459 5a4 4 0 0 1 3.945 3.343l.577 3.464l.81 4.865a2 2 0 0 1 -1.971 2.328h-16.82a1 1 0 0 1 -1 -1a8 8 0 0 1 8 -8h8.652l-.22 -1.329a2 2 0 0 0 -1.811 -1.665l-.162 -.006h-7.459a1 1 0 1 1 0 -2z\" />"),
    IRONING_1(
        "ironing-1",
        "<path d=\"M16.459 5a4 4 0 0 1 3.945 3.343l1.387 8.329a2 2 0 0 1 -1.971 2.328h-16.82a1 1 0 0 1 -1 -1a8 8 0 0 1 8 -8h8.652l-.22 -1.329a2 2 0 0 0 -1.811 -1.665l-.162 -.006h-7.459a1 1 0 1 1 0 -2zm-4.449 9h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2\" />"),
    IRONING_2(
        "ironing-2",
        "<path d=\"M16.459 5a4 4 0 0 1 3.945 3.343l1.387 8.329a2 2 0 0 1 -1.971 2.328h-16.82a1 1 0 0 1 -1 -1a8 8 0 0 1 8 -8h8.652l-.22 -1.329a2 2 0 0 0 -1.811 -1.665l-.162 -.006h-7.459a1 1 0 1 1 0 -2zm-6.449 9h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m4 0h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2\" />"),
    IRONING_3(
        "ironing-3",
        "<path d=\"M16.459 5a4 4 0 0 1 3.945 3.343l1.387 8.329a2 2 0 0 1 -1.971 2.328h-16.82a1 1 0 0 1 -1 -1a8 8 0 0 1 8 -8h8.652l-.22 -1.329a2 2 0 0 0 -1.811 -1.665l-.162 -.006h-7.459a1 1 0 1 1 0 -2zm-4.449 9h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m-3 0h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2m6 0h-.01a1 1 0 0 0 -.117 1.993l.127 .007a1 1 0 0 0 0 -2\" />"),
    IRONING_STEAM(
        "ironing-steam",
        "<path d=\"M12 18a1 1 0 0 1 1 1v2a1 1 0 0 1 -2 0v-2a1 1 0 0 1 1 -1\" />\n  <path d=\"M16.459 3a4 4 0 0 1 3.945 3.343l.577 3.464l.81 4.865a2 2 0 0 1 -1.971 2.328h-16.82a1 1 0 0 1 -1 -1a8 8 0 0 1 8 -8h8.652l-.22 -1.329a2 2 0 0 0 -1.811 -1.665l-.162 -.006h-7.459a1 1 0 1 1 0 -2z\" />\n  <path d=\"M7.106 18.553a1 1 0 0 1 1.788 .894l-1 2a1 1 0 0 1 -1.788 -.894z\" />\n  <path d=\"M15.553 18.106a1 1 0 0 1 1.341 .447l1 2a1 1 0 0 1 -1.788 .894l-1 -2a1 1 0 0 1 .447 -1.341\" />");

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

  default TablerIcon bleach() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.BLEACH);
  }

  default TablerIcon bleach_chlorine() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.BLEACH_CHLORINE);
  }

  default TablerIcon bleach_no_chlorine() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.BLEACH_NO_CHLORINE);
  }

  default TablerIcon bleach_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.BLEACH_OFF);
  }

  default TablerIcon ironing() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING);
  }

  default TablerIcon ironing_1() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_1);
  }

  default TablerIcon ironing_2() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_2);
  }

  default TablerIcon ironing_3() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_3);
  }

  default TablerIcon ironing_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_OFF);
  }

  default TablerIcon ironing_steam() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_STEAM);
  }

  default TablerIcon ironing_steam_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.IRONING_STEAM_OFF);
  }

  default TablerIcon wash() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH);
  }

  default TablerIcon wash_dry() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY);
  }

  default TablerIcon wash_dry_1() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_1);
  }

  default TablerIcon wash_dry_2() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_2);
  }

  default TablerIcon wash_dry_3() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_3);
  }

  default TablerIcon wash_dry_a() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_A);
  }

  default TablerIcon wash_dry_dip() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_DIP);
  }

  default TablerIcon wash_dry_f() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_F);
  }

  default TablerIcon wash_dry_flat() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_FLAT);
  }

  default TablerIcon wash_dry_hang() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_HANG);
  }

  default TablerIcon wash_dry_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_OFF);
  }

  default TablerIcon wash_dry_p() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_P);
  }

  default TablerIcon wash_dry_shade() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_SHADE);
  }

  default TablerIcon wash_dry_w() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRY_W);
  }

  default TablerIcon wash_dryclean() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRYCLEAN);
  }

  default TablerIcon wash_dryclean_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_DRYCLEAN_OFF);
  }

  default TablerIcon wash_eco() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_ECO);
  }

  default TablerIcon wash_gentle() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_GENTLE);
  }

  default TablerIcon wash_hand() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_HAND);
  }

  default TablerIcon wash_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_OFF);
  }

  default TablerIcon wash_press() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_PRESS);
  }

  default TablerIcon wash_temperature_1() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_1);
  }

  default TablerIcon wash_temperature_2() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_2);
  }

  default TablerIcon wash_temperature_3() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_3);
  }

  default TablerIcon wash_temperature_4() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_4);
  }

  default TablerIcon wash_temperature_5() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_5);
  }

  default TablerIcon wash_temperature_6() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TEMPERATURE_6);
  }

  default TablerIcon wash_tumble_dry() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TUMBLE_DRY);
  }

  default TablerIcon wash_tumble_off() {
    return TablerIcon.create(TablerLaundry.OutlineIcon.WASH_TUMBLE_OFF);
  }

  default TablerIcon ironing_filled() {
    return TablerIcon.create(TablerLaundry.FilledIcon.IRONING);
  }

  default TablerIcon ironing_1_filled() {
    return TablerIcon.create(TablerLaundry.FilledIcon.IRONING_1);
  }

  default TablerIcon ironing_2_filled() {
    return TablerIcon.create(TablerLaundry.FilledIcon.IRONING_2);
  }

  default TablerIcon ironing_3_filled() {
    return TablerIcon.create(TablerLaundry.FilledIcon.IRONING_3);
  }

  default TablerIcon ironing_steam_filled() {
    return TablerIcon.create(TablerLaundry.FilledIcon.IRONING_STEAM);
  }
}
