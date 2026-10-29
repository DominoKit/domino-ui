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

/** Lucide travel catalog category. */
public interface LucideTravel {
  enum Icon implements LucideIconDefinition {
    ALARM_SMOKE(
        "alarm-smoke",
        "<path d=\"M11 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"M16 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"m19 8-.8 3a1.25 1.25 0 0 1-1.2 1H7a1.25 1.25 0 0 1-1.2-1L5 8\" />\n  <path d=\"M21 3a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 21c0-2.5 2-2.5 2-5\" />"),
    BACKPACK(
        "backpack",
        "<path d=\"M4 10a4 4 0 0 1 4-4h8a4 4 0 0 1 4 4v10a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2z\" />\n  <path d=\"M8 10h8\" />\n  <path d=\"M8 18h8\" />\n  <path d=\"M8 22v-6a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v6\" />\n  <path d=\"M9 6V4a2 2 0 0 1 2-2h2a2 2 0 0 1 2 2v2\" />"),
    BAGGAGE_CLAIM(
        "baggage-claim",
        "<path d=\"M22 18H6a2 2 0 0 1-2-2V7a2 2 0 0 0-2-2\" />\n  <path d=\"M17 14V4a2 2 0 0 0-2-2h-1a2 2 0 0 0-2 2v10\" />\n  <rect width=\"13\" height=\"8\" x=\"8\" y=\"6\" rx=\"1\" />\n  <circle cx=\"18\" cy=\"20\" r=\"2\" />\n  <circle cx=\"9\" cy=\"20\" r=\"2\" />"),
    BANGLADESHI_TAKA(
        "bangladeshi-taka",
        "<path d=\"M6 5a2 2 0 0 1 4 0v12a4 4 0 0 0 8 0 2 2 0 0 0-4 0\" />\n  <path d=\"M6 9h12\" />"),
    BATH(
        "bath",
        "<path d=\"M10 4 8 6\" />\n  <path d=\"M17 19v2\" />\n  <path d=\"M2 12h20\" />\n  <path d=\"M7 19v2\" />\n  <path d=\"M9 5 7.621 3.621A2.121 2.121 0 0 0 4 5v12a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-5\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
    BRIDGE(
        "bridge",
        "<path d=\"M10 9.728V16\" />\n  <path d=\"M14 9.728V16\" />\n  <path d=\"M18 20V4\" />\n  <path d=\"m22 11-4-4A7.5 7.5 0 0 1 6 7l-4 4\" />\n  <path d=\"M22 16H2\" />\n  <path d=\"M6 20V4\" />"),
    BRIEFCASE_CONVEYOR_BELT(
        "briefcase-conveyor-belt",
        "<path d=\"M10 20v2\" />\n  <path d=\"M14 20v2\" />\n  <path d=\"M18 20v2\" />\n  <path d=\"M21 20H3\" />\n  <path d=\"M6 20v2\" />\n  <path d=\"M8 16V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v12\" />\n  <rect x=\"4\" y=\"6\" width=\"16\" height=\"10\" rx=\"2\" />"),
    CABLE_CAR(
        "cable-car",
        "<path d=\"M10 3h.01\" />\n  <path d=\"M14 2h.01\" />\n  <path d=\"m2 9 20-5\" />\n  <path d=\"M12 12V6.5\" />\n  <rect width=\"16\" height=\"10\" x=\"4\" y=\"12\" rx=\"3\" />\n  <path d=\"M9 12v5\" />\n  <path d=\"M15 12v5\" />\n  <path d=\"M4 17h16\" />"),
    CARAVAN(
        "caravan",
        "<path d=\"M18 19V9a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M2 9h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2\" />\n  <path d=\"M22 17v1a1 1 0 0 1-1 1H10v-9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v9\" />\n  <circle cx=\"8\" cy=\"19\" r=\"2\" />"),
    CIGARETTE(
        "cigarette",
        "<path d=\"M17 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h14\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M21 16a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    CIGARETTE_OFF(
        "cigarette-off",
        "<path d=\"M12 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h13\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 12a1 1 0 0 1 1 1v2a1 1 0 0 1-.5.866\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    COMPASS(
        "compass",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m16.24 7.76-1.804 5.411a2 2 0 0 1-1.265 1.265L7.76 16.24l1.804-5.411a2 2 0 0 1 1.265-1.265z\" />"),
    CONCIERGE_BELL(
        "concierge-bell",
        "<path d=\"M3 20a1 1 0 0 1-1-1v-1a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1Z\" />\n  <path d=\"M20 16a8 8 0 1 0-16 0\" />\n  <path d=\"M12 4v4\" />\n  <path d=\"M10 4h4\" />"),
    DOME(
        "dome",
        "<path d=\"M10 21v-3a2 2 0 014 0v3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M18 12v9\" />\n  <path d=\"M22 19a2 2 0 01-2 2H4a2 2 0 01-2-2v-6a1 1 0 011-1h18a1 1 0 011 1z\" />\n  <path d=\"M4 12a8 8 0 0116 0\" />\n  <path d=\"M6 12v9\" />"),
    DOOR_CLOSED(
        "door-closed",
        "<path d=\"M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 12h.01\" />"),
    DOOR_CLOSED_LOCKED(
        "door-closed-locked",
        "<path d=\"M19 8V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M20 16v-2a2 2 0 00-4 0v2\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"16\" width=\"8\" height=\"5\" rx=\"1\" />"),
    DOOR_OPEN(
        "door-open",
        "<path d=\"M10 21H2\" />\n  <path d=\"M10 3H7a2 2 0 00-2 2v16\" />\n  <path d=\"M14 12h.01\" />\n  <path d=\"M19 21V5a2 2 0 00-1.675-1.974l-6.163-1.013A1 1 0 0010 3v18a1 1 0 001.124.992z\" />\n  <path d=\"M22 21h-3\" />"),
    DOOR_STAIRWELL(
        "door-stairwell",
        "<path d=\"M12 17v-3a1 1 0 011-1h6\" />\n  <path d=\"M19 17h-9a1 1 0 00-1 1v3\" />\n  <path d=\"M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M19 9h-3a1 1 0 00-1 1v3\" />\n  <path d=\"M22 21H2\" />"),
    FAUCET(
        "faucet",
        "<path d=\"M10.083 5.428 5.57 4.083a2 2 0 10.001 3.834l4.512-1.345\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"m13.917 5.428 4.511-1.345a2 2 0 110 3.834l-4.51-1.345\" />\n  <path d=\"M18 17v-4.006\" />\n  <path d=\"M22 11v8\" />\n  <path d=\"M22 12h-3a1 1 0 00-1 .994h-2.539a4 4 0 00-6.915-.012L7 13a5 5 0 00-5 5v1a1 1 0 001 1h2a1 1 0 001-1v-1a1 1 0 01.995-1l1.552.018a4 4 0 006.907 0L18 17a1 1 0 001 1h3\" />\n  <circle cx=\"12\" cy=\"6\" r=\"2\" />"),
    FIRE_EXTINGUISHER(
        "fire-extinguisher",
        "<path d=\"M15 6.5V3a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3.5\" />\n  <path d=\"M9 18h8\" />\n  <path d=\"M18 3h-3\" />\n  <path d=\"M11 3a6 6 0 0 0-6 6v11\" />\n  <path d=\"M5 13h4\" />\n  <path d=\"M17 10a4 4 0 0 0-8 0v10a2 2 0 0 0 2 2h4a2 2 0 0 0 2-2Z\" />"),
    FISHING_HOOK(
        "fishing-hook",
        "<path d=\"m17.586 11.414-5.93 5.93a1 1 0 0 1-8-8l3.137-3.137a.707.707 0 0 1 1.207.5V10\" />\n  <path d=\"M20.414 8.586 22 7\" />\n  <circle cx=\"19\" cy=\"10\" r=\"2\" />"),
    FISHING_ROD(
        "fishing-rod",
        "<path d=\"M4 11h1\" />\n  <path d=\"M8 15a2 2 0 0 1-4 0V3a1 1 0 0 1 1-1h.5C14 2 20 9 20 18v4\" />\n  <circle cx=\"18\" cy=\"18\" r=\"2\" />"),
    HEATER(
        "heater",
        "<path d=\"M11 8c2-3-2-3 0-6\" />\n  <path d=\"M15.5 8c2-3-2-3 0-6\" />\n  <path d=\"M6 10h.01\" />\n  <path d=\"M6 14h.01\" />\n  <path d=\"M10 16v-4\" />\n  <path d=\"M14 16v-4\" />\n  <path d=\"M18 16v-4\" />\n  <path d=\"M20 6a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h3\" />\n  <path d=\"M5 20v2\" />\n  <path d=\"M19 20v2\" />"),
    HELICOPTER(
        "helicopter",
        "<path d=\"M11 17v4\" />\n  <path d=\"M14 3v8a2 2 0 0 0 2 2h5.865\" />\n  <path d=\"M17 17v4\" />\n  <path d=\"M18 17a4 4 0 0 0 4-4 8 6 0 0 0-8-6 6 5 0 0 0-6 5v3a2 2 0 0 0 2 2z\" />\n  <path d=\"M2 10v5\" />\n  <path d=\"M6 3h16\" />\n  <path d=\"M7 21h14\" />\n  <path d=\"M8 13H2\" />"),
    HIKING_STICK(
        "hiking-stick",
        "<path d=\"M13.5 10.5 2 22\" />\n  <path d=\"M16.352 11.648a1.205 1.205 0 01-1.704 0l-2.296-2.296a1.205 1.205 0 010-1.704l.72-.72a2 2 0 011.022-.546l.599-.12a2 2 0 001.569-1.57l.12-.598a2 2 0 01.546-1.022l.72-.72a1.205 1.205 0 011.704 0l2.296 2.296a1.205 1.205 0 010 1.704l-6.02 6.02a1 1 0 103 3l.201-.201A7.4 7.4 0 0021 9.93V7\" />\n  <path d=\"m6 21-3-3\" />"),
    HOSPITAL(
        "hospital",
        "<path d=\"M12 7v4\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M14 9h-4\" />\n  <path d=\"M18 11h2a2 2 0 0 1 2 2v6a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-9a2 2 0 0 1 2-2h2\" />\n  <path d=\"M18 21V5a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16\" />"),
    HOTEL(
        "hotel",
        "<path d=\"M10 22v-6.57\" />\n  <path d=\"M12 11h.01\" />\n  <path d=\"M12 7h.01\" />\n  <path d=\"M14 15.43V22\" />\n  <path d=\"M15 16a5 5 0 0 0-6 0\" />\n  <path d=\"M16 11h.01\" />\n  <path d=\"M16 7h.01\" />\n  <path d=\"M8 11h.01\" />\n  <path d=\"M8 7h.01\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    LIGHTHOUSE(
        "lighthouse",
        "<path d=\"M12 3V2\" />\n  <path d=\"M16.066 16.865 7 22l2-11V6a3 3 0 016 0v5l2 11\" />\n  <path d=\"m19.792 4.5.866-.5\" />\n  <path d=\"m19.797 13.5.866.5\" />\n  <path d=\"M21 9h1\" />\n  <path d=\"M3 9H2\" />\n  <path d=\"m4.203 13.5-.866.5\" />\n  <path d=\"M4.208 4.5 3.342 4\" />\n  <path d=\"M5.5 22h13\" />\n  <path d=\"m7.932 16.875 7.377-4.178\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h8\" />"),
    LUGGAGE(
        "luggage",
        "<path d=\"M6 20a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2\" />\n  <path d=\"M8 18V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v14\" />\n  <path d=\"M10 20h4\" />\n  <circle cx=\"16\" cy=\"20\" r=\"2\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    MAP_MINUS(
        "map-minus",
        "<path d=\"m11 19-1.106-.552a2 2 0 0 0-1.788 0l-3.659 1.83A1 1 0 0 1 3 19.381V6.618a1 1 0 0 1 .553-.894l4.553-2.277a2 2 0 0 1 1.788 0l4.212 2.106a2 2 0 0 0 1.788 0l3.659-1.83A1 1 0 0 1 21 4.619V14\" />\n  <path d=\"M15 5.764V14\" />\n  <path d=\"M21 18h-6\" />\n  <path d=\"M9 3.236v15\" />"),
    MAP_PIN(
        "map-pin",
        "<path d=\"M20 10c0 4.993-5.539 10.193-7.399 11.799a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />"),
    MAP_PIN_CHECK(
        "map-pin-check",
        "<path d=\"M19.43 12.935c.357-.967.57-1.955.57-2.935a8 8 0 0 0-16 0c0 4.993 5.539 10.193 7.399 11.799a1 1 0 0 0 1.202 0 32.197 32.197 0 0 0 .813-.728\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <path d=\"m16 18 2 2 4-4\" />"),
    MAP_PIN_CHECK_INSIDE(
        "map-pin-check-inside",
        "<path d=\"M20 10c0 4.993-5.539 10.193-7.399 11.799a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0\" />\n  <path d=\"m9 10 2 2 4-4\" />"),
    MAP_PIN_HOUSE(
        "map-pin-house",
        "<path d=\"M15 22a1 1 0 0 1-1-1v-4a1 1 0 0 1 .445-.832l3-2a1 1 0 0 1 1.11 0l3 2A1 1 0 0 1 22 17v4a1 1 0 0 1-1 1z\" />\n  <path d=\"M18 10a8 8 0 0 0-16 0c0 4.993 5.539 10.193 7.399 11.799a1 1 0 0 0 .601.2\" />\n  <path d=\"M18 22v-3\" />\n  <circle cx=\"10\" cy=\"10\" r=\"3\" />"),
    MAP_PIN_MINUS(
        "map-pin-minus",
        "<path d=\"M18.977 14C19.6 12.701 20 11.343 20 10a8 8 0 0 0-16 0c0 4.993 5.539 10.193 7.399 11.799a1 1 0 0 0 1.202 0 32 32 0 0 0 .824-.738\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <path d=\"M16 18h6\" />"),
    MAP_PIN_MINUS_INSIDE(
        "map-pin-minus-inside",
        "<path d=\"M20 10c0 4.993-5.539 10.193-7.399 11.799a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0\" />\n  <path d=\"M9 10h6\" />"),
    MAP_PIN_OFF(
        "map-pin-off",
        "<path d=\"M12.75 7.09a3 3 0 0 1 2.16 2.16\" />\n  <path d=\"M17.072 17.072c-1.634 2.17-3.527 3.912-4.471 4.727a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 1.432-4.568\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8.475 2.818A8 8 0 0 1 20 10c0 1.183-.31 2.377-.81 3.533\" />\n  <path d=\"M9.13 9.13a3 3 0 0 0 3.74 3.74\" />"),
    MAP_PIN_PEN(
        "map-pin-pen",
        "<path d=\"M17.97 9.304A8 8 0 0 0 2 10c0 4.69 4.887 9.562 7.022 11.468\" />\n  <path d=\"M21.378 16.626a1 1 0 0 0-3.004-3.004l-4.01 4.012a2 2 0 0 0-.506.854l-.837 2.87a.5.5 0 0 0 .62.62l2.87-.837a2 2 0 0 0 .854-.506z\" />\n  <circle cx=\"10\" cy=\"10\" r=\"3\" />"),
    MAP_PIN_PLUS(
        "map-pin-plus",
        "<path d=\"M19.914 11.105A7.298 7.298 0 0 0 20 10a8 8 0 0 0-16 0c0 4.993 5.539 10.193 7.399 11.799a1 1 0 0 0 1.202 0 32 32 0 0 0 .824-.738\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <path d=\"M16 18h6\" />\n  <path d=\"M19 15v6\" />"),
    MAP_PIN_PLUS_INSIDE(
        "map-pin-plus-inside",
        "<path d=\"M20 10c0 4.993-5.539 10.193-7.399 11.799a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0\" />\n  <path d=\"M12 7v6\" />\n  <path d=\"M9 10h6\" />"),
    MAP_PIN_SEARCH(
        "map-pin-search",
        "<path d=\"M 12.248 21.969 a 1 1 0 0 1 -0.849 -0.17 C 9.539 20.193 4 14.993 4 10 a 8 8 0 0 1 16 0 C 20 10.42 19.961 10.841 19.888 11.262\" />\n  <path d=\"m22 22-1.88-1.88\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    MAP_PIN_X(
        "map-pin-x",
        "<path d=\"M19.752 11.901A7.78 7.78 0 0 0 20 10a8 8 0 0 0-16 0c0 4.993 5.539 10.193 7.399 11.799a1 1 0 0 0 1.202 0 19 19 0 0 0 .09-.077\" />\n  <circle cx=\"12\" cy=\"10\" r=\"3\" />\n  <path d=\"m21.5 15.5-5 5\" />\n  <path d=\"m21.5 20.5-5-5\" />"),
    MAP_PIN_X_INSIDE(
        "map-pin-x-inside",
        "<path d=\"M20 10c0 4.993-5.539 10.193-7.399 11.799a1 1 0 0 1-1.202 0C9.539 20.193 4 14.993 4 10a8 8 0 0 1 16 0\" />\n  <path d=\"m14.5 7.5-5 5\" />\n  <path d=\"m9.5 7.5 5 5\" />"),
    MAP_PINNED(
        "map-pinned",
        "<path d=\"M18 8c0 3.613-3.869 7.429-5.393 8.795a1 1 0 01-1.214 0C9.87 15.429 6 11.613 6 8a6 6 0 0112 0\" />\n  <path d=\"M4.474 15h-.197a1 1 0 00-.969.753l-1.097 4.35a1.5 1.5 0 001.444 1.898L20.344 22a1.5 1.5 0 001.446-1.897l-1.098-4.35a1 1 0 00-.969-.753h-.197\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />"),
    MOSQUE(
        "mosque",
        "<path d=\"M12.268 2a2 2 0 003.465 2\" />\n  <path d=\"M14 5 L14 8\" />\n  <path d=\"M16 22v-3a2 2 0 00-4 0v3\" />\n  <path d=\"M21 13c-.662-1.497-1.666-2.753-2.9-3.63C16.825 8.47 15.422 8 14 8s-2.826.47-4.1 1.37C8.668 10.248 7.663 11.504 7 13z\" />\n  <path d=\"M3 9h4\" />\n  <path d=\"M7 22V6a5 5 0 00-2-4 5 5 0 00-2 4v14a2 2 0 002 2h14a2 2 0 002-2v-7\" />"),
    NEPALI_RUPEE(
        "nepali-rupee",
        "<path d=\"M18 16.173 A4.74 4.74 0 0 0 13.496 8.005\" />\n  <path d=\"M4 3 L20 3\" />\n  <path d=\"M5 13 L13.5 21\" />\n  <path d=\"M5 13 L9 13\" />\n  <path d=\"M8 13 C15.5 13 14.667 3 8 3\" />"),
    PARASOL(
        "parasol",
        "<path d=\"M12.5 11.134 18.196 21\" />\n  <path d=\"M20.425 5.299a10 10 0 0 0-16.941 9.78c.183.563.843.774 1.355.478L20.16 6.711c.512-.296.66-.973.264-1.413\" />\n  <path d=\"M21 21H3\" />"),
    PARK(
        "park",
        "<path d=\"M12 18h10\" />\n  <path d=\"M13.248 9.998A4.5 4.5 0 0 0 11.75 8.6V8a1 1 0 0 0-7.5 0 4.9 4.9 0 0 0 2.25 9H8\" />\n  <path d=\"m15 14-2 6\" />\n  <path d=\"m19 14 2 6\" />\n  <path d=\"M21 14h-8\" />\n  <path d=\"M8 20v-5.922a2 2 0 0 0-.586-1.414L6.5 11.75\" />\n  <path d=\"M9.205 12.795 8 14\" />\n  <circle cx=\"19\" cy=\"6\" r=\"2\" />"),
    PERFUME_BOTTLE(
        "perfume-bottle",
        "<path d=\"M 5 22 H 11.072\" />\n  <path d=\"M15 5 C 23 4 23.328 12.676 20 14.536\" />\n  <path d=\"M15.802 10.308 C 14.776 9.465 14 8.496 14 7\" />\n  <path d=\"M2 2h.01\" />\n  <path d=\"M2 7h.01\" />\n  <path d=\"M5 4.5h.01\" />\n  <path d=\"M8.127 22 A 8 8 0 0 1 4 15 3 3 0 0 1 4.879 12.879C 6.879 10.879 10 10 10 7\" />\n  <circle cx=\"18\" cy=\"18\" r=\"4\" />\n  <rect x=\"9\" y=\"2\" width=\"6\" height=\"5\" rx=\"1\" />"),
    PLANE(
        "plane",
        "<path d=\"M17.8 19.2 16 11l3.5-3.5C21 6 21.5 4 21 3c-1-.5-3 0-4.5 1.5L13 8 4.8 6.2c-.5-.1-.9.1-1.1.5l-.3.5c-.2.5-.1 1 .3 1.3L9 12l-2 3H4l-1 1 3 2 2 3 1-1v-3l3-2 3.5 5.3c.3.4.8.5 1.3.3l.5-.2c.4-.3.6-.7.5-1.2z\" />"),
    PLANE_LANDING(
        "plane-landing",
        "<path d=\"M2 22h20\" />\n  <path d=\"M3.77 10.77 2 9l2-4.5 1.1.55c.55.28.9.84.9 1.45s.35 1.17.9 1.45L8 8.5l3-6 1.05.53a2 2 0 0 1 1.09 1.52l.72 5.4a2 2 0 0 0 1.09 1.52l4.4 2.2c.42.22.78.55 1.01.96l.6 1.03c.49.88-.06 1.98-1.06 2.1l-1.18.15c-.47.06-.95-.02-1.37-.24L4.29 11.15a2 2 0 0 1-.52-.38Z\" />"),
    PLANE_TAKEOFF(
        "plane-takeoff",
        "<path d=\"M2 22h20\" />\n  <path d=\"M6.36 17.4 4 17l-2-4 1.1-.55a2 2 0 0 1 1.8 0l.17.1a2 2 0 0 0 1.8 0L8 12 5 6l.9-.45a2 2 0 0 1 2.09.2l4.02 3a2 2 0 0 0 2.1.2l4.19-2.06a2.41 2.41 0 0 1 1.73-.17L21 7a1.4 1.4 0 0 1 .87 1.99l-.38.76c-.23.46-.6.84-1.07 1.08L7.58 17.2a2 2 0 0 1-1.22.18Z\" />"),
    PYRAMID(
        "pyramid",
        "<path d=\"M2.5 16.88a1 1 0 0 1-.32-1.43l9-13.02a1 1 0 0 1 1.64 0l9 13.01a1 1 0 0 1-.32 1.44l-8.51 4.86a2 2 0 0 1-1.98 0Z\" />\n  <path d=\"M12 2v20\" />"),
    RECEIPT(
        "receipt",
        "<path d=\"M12 17V7\" />\n  <path d=\"M16 8h-6a2 2 0 0 0 0 4h4a2 2 0 0 1 0 4H8\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_CENT(
        "receipt-cent",
        "<path d=\"M12 7v10\" />\n  <path d=\"M14.828 14.829a4 4 0 0 1-5.656 0 4 4 0 0 1 0-5.657 4 4 0 0 1 5.656 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_EURO(
        "receipt-euro",
        "<path d=\"M15.828 14.829a4 4 0 0 1-5.656 0 4 4 0 0 1 0-5.657 4 4 0 0 1 5.656 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 12h5\" />"),
    RECEIPT_INDIAN_RUPEE(
        "receipt-indian-rupee",
        "<path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h8\" />\n  <path d=\"M9 7a4 4 0 0 1 0 8H8l3 2\" />"),
    RECEIPT_JAPANESE_YEN(
        "receipt-japanese-yen",
        "<path d=\"m12 10 3-3\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M9 11h6\" />\n  <path d=\"M9 15h6\" />\n  <path d=\"m9 7 3 3v7\" />"),
    RECEIPT_POUND_STERLING(
        "receipt-pound-sterling",
        "<path d=\"M10 17V9.5a1 1 0 0 1 5 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 13h5\" />\n  <path d=\"M8 17h7\" />"),
    RECEIPT_RUSSIAN_RUBLE(
        "receipt-russian-ruble",
        "<path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 11h5a2 2 0 0 0 0-4h-3v10\" />\n  <path d=\"M8 15h5\" />"),
    RECEIPT_SWISS_FRANC(
        "receipt-swiss-franc",
        "<path d=\"M10 11h4\" />\n  <path d=\"M10 17V7h5\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 15h5\" />"),
    RECEIPT_TEXT(
        "receipt-text",
        "<path d=\"M13 16H8\" />\n  <path d=\"M14 8H8\" />\n  <path d=\"M16 12H8\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_TURKISH_LIRA(
        "receipt-turkish-lira",
        "<path d=\"M10 7v10a5 5 0 0 0 5-5\" />\n  <path d=\"m14 8-6 3\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    SAILBOAT(
        "sailboat",
        "<path d=\"M10 2v15\" />\n  <path d=\"M7 22a4 4 0 0 1-4-4 1 1 0 0 1 1-1h16a1 1 0 0 1 1 1 4 4 0 0 1-4 4z\" />\n  <path d=\"M9.159 2.46a1 1 0 0 1 1.521-.193l9.977 8.98A1 1 0 0 1 20 13H4a1 1 0 0 1-.824-1.567z\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHIP(
        "ship",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 9.189V13\" />\n  <path d=\"M19 12V6a2 2 0 00-2-2H7a2 2 0 00-2 2v6\" />\n  <path d=\"M19.38 19A11.6 11.6 0 0021 13l-8.188-3.639a2 2 0 00-1.624 0L3 13.001a11.6 11.6 0 002.81 7.76\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_CARGO(
        "ship-cargo",
        "<path d=\"M12 15v-3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M16.5 12V9a1 1 0 011-1h1a1 1 0 001-1V5a1 1 0 00-1-1h-13a1 1 0 00-1 1v2a1 1 0 001 1h1a1 1 0 011 1v3\" />\n  <path d=\"M19.38 19c1.076-1.815 1.636-4.89 1.628-6.008a1 1 0 00-1-.992H3.984a1 1 0 00-1 .984c-.03 1.86.97 5.621 2.826 7.776\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_WHEEL(
        "ship-wheel",
        "<circle cx=\"12\" cy=\"12\" r=\"8\" />\n  <path d=\"M12 2v7.5\" />\n  <path d=\"m19 5-5.23 5.23\" />\n  <path d=\"M22 12h-7.5\" />\n  <path d=\"m19 19-5.23-5.23\" />\n  <path d=\"M12 14.5V22\" />\n  <path d=\"M10.23 13.77 5 19\" />\n  <path d=\"M9.5 12H2\" />\n  <path d=\"M10.23 10.23 5 5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2.5\" />"),
    SHOWER_HEAD(
        "shower-head",
        "<path d=\"m4 4 2.5 2.5\" />\n  <path d=\"M13.5 6.5a4.95 4.95 0 0 0-7 7\" />\n  <path d=\"M15 5 5 15\" />\n  <path d=\"M14 17v.01\" />\n  <path d=\"M10 16v.01\" />\n  <path d=\"M13 13v.01\" />\n  <path d=\"M16 10v.01\" />\n  <path d=\"M11 20v.01\" />\n  <path d=\"M17 14v.01\" />\n  <path d=\"M20 11v.01\" />"),
    SOAP_DISPENSER_DROPLET(
        "soap-dispenser-droplet",
        "<path d=\"M10.5 2v4\" />\n  <path d=\"M14 2H7a2 2 0 0 0-2 2\" />\n  <path d=\"M19.29 14.76A6.67 6.67 0 0 1 17 11a6.6 6.6 0 0 1-2.29 3.76c-1.15.92-1.71 2.04-1.71 3.19 0 2.22 1.8 4.05 4 4.05s4-1.83 4-4.05c0-1.16-.57-2.26-1.71-3.19\" />\n  <path d=\"M9.607 21H6a2 2 0 0 1-2-2v-7a2 2 0 0 1 2-2h7V7a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3\" />"),
    TENT(
        "tent",
        "<path d=\"M3.5 21 14 3\" />\n  <path d=\"M20.5 21 10 3\" />\n  <path d=\"M15.5 21 12 15l-3.5 6\" />\n  <path d=\"M2 21h20\" />"),
    TENT_TREE(
        "tent-tree",
        "<circle cx=\"4\" cy=\"4\" r=\"2\" />\n  <path d=\"m14 5 3-3 3 3\" />\n  <path d=\"m14 10 3-3 3 3\" />\n  <path d=\"M17 14V2\" />\n  <path d=\"M17 14H7l-5 8h20Z\" />\n  <path d=\"M8 14v8\" />\n  <path d=\"m9 14 5 8\" />"),
    TICKETS(
        "tickets",
        "<path d=\"m3.173 8.18 11-5a2 2 0 0 1 2.647.993L18.56 8\" />\n  <path d=\"M6 10V8\" />\n  <path d=\"M6 14v1\" />\n  <path d=\"M6 19v2\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"13\" rx=\"2\" />"),
    TICKETS_PLANE(
        "tickets-plane",
        "<path d=\"M10.5 17h1.227a2 2 0 0 0 1.345-.52L18 12\" />\n  <path d=\"m12 13.5 3.794.506\" />\n  <path d=\"m3.173 8.18 11-5a2 2 0 0 1 2.647.993L18.56 8\" />\n  <path d=\"M6 10V8\" />\n  <path d=\"M6 14v1\" />\n  <path d=\"M6 19v2\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"13\" rx=\"2\" />"),
    TOOTHBRUSH(
        "toothbrush",
        "<path d=\"M15 11c-2 2-4 2-6 4l-7 7\" />\n  <path d=\"m22 4-7.414 7.414-2-2A2 2 0 0114 6c0-.512.196-1.024.586-1.414A2 2 0 0116 4a2 2 0 013.262-1.552l2.152 2.138\" />"),
    TOOTHBRUSH_SPARKLES(
        "toothbrush-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"M14.586 11.414 22 4\" />\n  <path d=\"M15 11a8 8 0 01-.429.4\" />\n  <path d=\"m2 22 7-7c1.857-1.857 3.714-1.99 5.571-3.6l-1.985-1.986A2 2 0 0114 6a2 2 0 012-2 2 2 0 013.262-1.552l2.152 2.138\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    TOWEL_RACK(
        "towel-rack",
        "<path d=\"M22 7h-2\" />\n  <path d=\"M6.5 3h11A2.5 2.5 0 0 1 20 5.5V20a1 1 0 0 1-1 1h-9a1 1 0 0 1-1-1V5.5a1 1 0 0 0-5 0V17a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9 7H2\" />"),
    TOWER_CONTROL(
        "tower-control",
        "<path d=\"M18.2 12.27 20 6H4l1.8 6.27a1 1 0 0 0 .95.73h10.5a1 1 0 0 0 .96-.73Z\" />\n  <path d=\"M8 13v9\" />\n  <path d=\"M16 22v-9\" />\n  <path d=\"m9 6 1 7\" />\n  <path d=\"m15 6-1 7\" />\n  <path d=\"M12 6V2\" />\n  <path d=\"M13 2h-2\" />"),
    TUBE_LOTION(
        "tube-lotion",
        "<path d=\"M15 18v3a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-3\" />\n  <path d=\"M17 2a2 2 0 0 1 1.6 3.2A8 8 0 0 0 17 10v6a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2v-6a8 8 0 0 0-1.6-4.8A2 2 0 0 1 7 2z\" />\n  <path d=\"M7 10a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />"),
    UTENSILS(
        "utensils",
        "<path d=\"M3 2v7c0 1.1.9 2 2 2h4a2 2 0 0 0 2-2V2\" />\n  <path d=\"M7 2v20\" />\n  <path d=\"M21 15V2a5 5 0 0 0-5 5v6c0 1.1.9 2 2 2h3Zm0 0v7\" />"),
    UTENSILS_CROSSED(
        "utensils-crossed",
        "<path d=\"m16 2-2.3 2.3a3 3 0 0 0 0 4.2l1.8 1.8a3 3 0 0 0 4.2 0L22 8\" />\n  <path d=\"M15 15 3.3 3.3a4.2 4.2 0 0 0 0 6l7.3 7.3c.7.7 2 .7 2.8 0L15 15Zm0 0 7 7\" />\n  <path d=\"m2.1 21.8 6.4-6.3\" />\n  <path d=\"m19 5-7 7\" />"),
    VAULT(
        "vault",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <circle cx=\"7.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 7.9 2.7 2.7\" />\n  <circle cx=\"16.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 10.6 2.7-2.7\" />\n  <circle cx=\"7.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 16.1 2.7-2.7\" />\n  <circle cx=\"16.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 13.4 2.7 2.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    VOLLEYBALL(
        "volleyball",
        "<path d=\"M11 7a16 16 20 0 1 10.98 4.362\" />\n  <path d=\"M12 12a13 13 0 0 1-8.66 5\" />\n  <path d=\"M16.83 13.634a16 16 0 0 1-9.267 7.328\" />\n  <path d=\"M20.66 17A13 13 0 0 0 12 12a13 13 0 0 1 0-10\" />\n  <path d=\"M8.17 15.366a16 16 0 0 1-1.713-11.69\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    WASHING_MACHINE(
        "washing-machine",
        "<path d=\"M3 6h3\" />\n  <path d=\"M17 6h.01\" />\n  <rect width=\"18\" height=\"20\" x=\"3\" y=\"2\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"13\" r=\"5\" />\n  <path d=\"M12 18a2.5 2.5 0 0 0 0-5 2.5 2.5 0 0 1 0-5\" />");

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
  default LucideIcon alarm_smoke_travel() {
    return LucideIcon.create(Icon.ALARM_SMOKE);
  }

  default LucideIcon backpack_travel() {
    return LucideIcon.create(Icon.BACKPACK);
  }

  default LucideIcon baggage_claim_travel() {
    return LucideIcon.create(Icon.BAGGAGE_CLAIM);
  }

  default LucideIcon bangladeshi_taka_travel() {
    return LucideIcon.create(Icon.BANGLADESHI_TAKA);
  }

  default LucideIcon bath() {
    return LucideIcon.create(Icon.BATH);
  }

  default LucideIcon binoculars_travel() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon book_image_travel() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon bridge_travel() {
    return LucideIcon.create(Icon.BRIDGE);
  }

  default LucideIcon briefcase_conveyor_belt_travel() {
    return LucideIcon.create(Icon.BRIEFCASE_CONVEYOR_BELT);
  }

  default LucideIcon cable_car_travel() {
    return LucideIcon.create(Icon.CABLE_CAR);
  }

  default LucideIcon caravan_travel() {
    return LucideIcon.create(Icon.CARAVAN);
  }

  default LucideIcon cigarette_travel() {
    return LucideIcon.create(Icon.CIGARETTE);
  }

  default LucideIcon cigarette_off_travel() {
    return LucideIcon.create(Icon.CIGARETTE_OFF);
  }

  default LucideIcon compass_travel() {
    return LucideIcon.create(Icon.COMPASS);
  }

  default LucideIcon concierge_bell() {
    return LucideIcon.create(Icon.CONCIERGE_BELL);
  }

  default LucideIcon dome_travel() {
    return LucideIcon.create(Icon.DOME);
  }

  default LucideIcon door_closed_travel() {
    return LucideIcon.create(Icon.DOOR_CLOSED);
  }

  default LucideIcon door_closed_locked_travel() {
    return LucideIcon.create(Icon.DOOR_CLOSED_LOCKED);
  }

  default LucideIcon door_open_travel() {
    return LucideIcon.create(Icon.DOOR_OPEN);
  }

  default LucideIcon door_stairwell_travel() {
    return LucideIcon.create(Icon.DOOR_STAIRWELL);
  }

  default LucideIcon faucet_travel() {
    return LucideIcon.create(Icon.FAUCET);
  }

  default LucideIcon fire_extinguisher_travel() {
    return LucideIcon.create(Icon.FIRE_EXTINGUISHER);
  }

  default LucideIcon fishing_hook_travel() {
    return LucideIcon.create(Icon.FISHING_HOOK);
  }

  default LucideIcon fishing_rod_travel() {
    return LucideIcon.create(Icon.FISHING_ROD);
  }

  default LucideIcon heater_travel() {
    return LucideIcon.create(Icon.HEATER);
  }

  default LucideIcon helicopter_travel() {
    return LucideIcon.create(Icon.HELICOPTER);
  }

  default LucideIcon hiking_stick_travel() {
    return LucideIcon.create(Icon.HIKING_STICK);
  }

  default LucideIcon hospital_travel() {
    return LucideIcon.create(Icon.HOSPITAL);
  }

  default LucideIcon hotel_travel() {
    return LucideIcon.create(Icon.HOTEL);
  }

  default LucideIcon lighthouse_travel() {
    return LucideIcon.create(Icon.LIGHTHOUSE);
  }

  default LucideIcon luggage_travel() {
    return LucideIcon.create(Icon.LUGGAGE);
  }

  default LucideIcon map_minus_travel() {
    return LucideIcon.create(Icon.MAP_MINUS);
  }

  default LucideIcon map_pin_travel() {
    return LucideIcon.create(Icon.MAP_PIN);
  }

  default LucideIcon map_pin_check_travel() {
    return LucideIcon.create(Icon.MAP_PIN_CHECK);
  }

  default LucideIcon map_pin_check_inside_travel() {
    return LucideIcon.create(Icon.MAP_PIN_CHECK_INSIDE);
  }

  default LucideIcon map_pin_house_travel() {
    return LucideIcon.create(Icon.MAP_PIN_HOUSE);
  }

  default LucideIcon map_pin_minus_travel() {
    return LucideIcon.create(Icon.MAP_PIN_MINUS);
  }

  default LucideIcon map_pin_minus_inside_travel() {
    return LucideIcon.create(Icon.MAP_PIN_MINUS_INSIDE);
  }

  default LucideIcon map_pin_off_travel() {
    return LucideIcon.create(Icon.MAP_PIN_OFF);
  }

  default LucideIcon map_pin_pen_travel() {
    return LucideIcon.create(Icon.MAP_PIN_PEN);
  }

  default LucideIcon map_pin_plus_travel() {
    return LucideIcon.create(Icon.MAP_PIN_PLUS);
  }

  default LucideIcon map_pin_plus_inside_travel() {
    return LucideIcon.create(Icon.MAP_PIN_PLUS_INSIDE);
  }

  default LucideIcon map_pin_search_travel() {
    return LucideIcon.create(Icon.MAP_PIN_SEARCH);
  }

  default LucideIcon map_pin_x_travel() {
    return LucideIcon.create(Icon.MAP_PIN_X);
  }

  default LucideIcon map_pin_x_inside_travel() {
    return LucideIcon.create(Icon.MAP_PIN_X_INSIDE);
  }

  default LucideIcon map_pinned_travel() {
    return LucideIcon.create(Icon.MAP_PINNED);
  }

  default LucideIcon mosque_travel() {
    return LucideIcon.create(Icon.MOSQUE);
  }

  default LucideIcon nepali_rupee_travel() {
    return LucideIcon.create(Icon.NEPALI_RUPEE);
  }

  default LucideIcon parasol_travel() {
    return LucideIcon.create(Icon.PARASOL);
  }

  default LucideIcon park_travel() {
    return LucideIcon.create(Icon.PARK);
  }

  default LucideIcon perfume_bottle_travel() {
    return LucideIcon.create(Icon.PERFUME_BOTTLE);
  }

  default LucideIcon plane_travel() {
    return LucideIcon.create(Icon.PLANE);
  }

  default LucideIcon plane_landing_travel() {
    return LucideIcon.create(Icon.PLANE_LANDING);
  }

  default LucideIcon plane_takeoff_travel() {
    return LucideIcon.create(Icon.PLANE_TAKEOFF);
  }

  default LucideIcon pyramid_travel() {
    return LucideIcon.create(Icon.PYRAMID);
  }

  default LucideIcon receipt_travel() {
    return LucideIcon.create(Icon.RECEIPT);
  }

  default LucideIcon receipt_cent_travel() {
    return LucideIcon.create(Icon.RECEIPT_CENT);
  }

  default LucideIcon receipt_euro_travel() {
    return LucideIcon.create(Icon.RECEIPT_EURO);
  }

  default LucideIcon receipt_indian_rupee_travel() {
    return LucideIcon.create(Icon.RECEIPT_INDIAN_RUPEE);
  }

  default LucideIcon receipt_japanese_yen_travel() {
    return LucideIcon.create(Icon.RECEIPT_JAPANESE_YEN);
  }

  default LucideIcon receipt_pound_sterling_travel() {
    return LucideIcon.create(Icon.RECEIPT_POUND_STERLING);
  }

  default LucideIcon receipt_russian_ruble_travel() {
    return LucideIcon.create(Icon.RECEIPT_RUSSIAN_RUBLE);
  }

  default LucideIcon receipt_swiss_franc_travel() {
    return LucideIcon.create(Icon.RECEIPT_SWISS_FRANC);
  }

  default LucideIcon receipt_text_travel() {
    return LucideIcon.create(Icon.RECEIPT_TEXT);
  }

  default LucideIcon receipt_turkish_lira_travel() {
    return LucideIcon.create(Icon.RECEIPT_TURKISH_LIRA);
  }

  default LucideIcon sailboat_travel() {
    return LucideIcon.create(Icon.SAILBOAT);
  }

  default LucideIcon shell_travel() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon ship_travel() {
    return LucideIcon.create(Icon.SHIP);
  }

  default LucideIcon ship_cargo_travel() {
    return LucideIcon.create(Icon.SHIP_CARGO);
  }

  default LucideIcon ship_wheel_travel() {
    return LucideIcon.create(Icon.SHIP_WHEEL);
  }

  default LucideIcon shower_head_travel() {
    return LucideIcon.create(Icon.SHOWER_HEAD);
  }

  default LucideIcon soap_dispenser_droplet_travel() {
    return LucideIcon.create(Icon.SOAP_DISPENSER_DROPLET);
  }

  default LucideIcon tent_travel() {
    return LucideIcon.create(Icon.TENT);
  }

  default LucideIcon tent_tree_travel() {
    return LucideIcon.create(Icon.TENT_TREE);
  }

  default LucideIcon tickets_travel() {
    return LucideIcon.create(Icon.TICKETS);
  }

  default LucideIcon tickets_plane_travel() {
    return LucideIcon.create(Icon.TICKETS_PLANE);
  }

  default LucideIcon toothbrush_travel() {
    return LucideIcon.create(Icon.TOOTHBRUSH);
  }

  default LucideIcon toothbrush_sparkles_travel() {
    return LucideIcon.create(Icon.TOOTHBRUSH_SPARKLES);
  }

  default LucideIcon towel_rack_travel() {
    return LucideIcon.create(Icon.TOWEL_RACK);
  }

  default LucideIcon tower_control_travel() {
    return LucideIcon.create(Icon.TOWER_CONTROL);
  }

  default LucideIcon tube_lotion_travel() {
    return LucideIcon.create(Icon.TUBE_LOTION);
  }

  default LucideIcon utensils_travel() {
    return LucideIcon.create(Icon.UTENSILS);
  }

  default LucideIcon utensils_crossed_travel() {
    return LucideIcon.create(Icon.UTENSILS_CROSSED);
  }

  default LucideIcon vault_travel() {
    return LucideIcon.create(Icon.VAULT);
  }

  default LucideIcon volleyball_travel() {
    return LucideIcon.create(Icon.VOLLEYBALL);
  }

  default LucideIcon washing_machine_travel() {
    return LucideIcon.create(Icon.WASHING_MACHINE);
  }
}
