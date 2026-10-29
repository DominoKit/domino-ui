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

/** Lucide navigation catalog category. */
public interface LucideNavigation {
  enum Icon implements LucideIconDefinition {
    BARREL(
        "barrel",
        "<path d=\"M10.5 2a34.5 34.5 0 000 20\" />\n  <path d=\"M13.5 2a34.5 34.5 0 010 20\" />\n  <path d=\"M4.67 17h14.67\" />\n  <path d=\"M4.67 7h14.67\" />\n  <path d=\"M6.23 3.06a19 19 0 000 17.88A2 2 0 008 22h8a2 2 0 001.77-1.06 19 19 0 000-17.88A2 2 0 0016 2H8a2 2 0 00-1.77 1.06\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BIRDHOUSE(
        "birdhouse",
        "<path d=\"M12 18v4\" />\n  <path d=\"m17 18 1.956-11.468\" />\n  <path d=\"m3 8 7.82-5.615a2 2 0 0 1 2.36 0L21 8\" />\n  <path d=\"M4 18h16\" />\n  <path d=\"M7 18 5.044 6.532\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    CALENDAR_CHEVRONS_LEFT(
        "calendar-chevrons-left",
        "<path d=\"m11 21-3-3 3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"M21 9H3\" />\n  <path d=\"M3 11.5V5a2 2 0 012-2h14a2 2 0 012 2v14a2 2 0 01-2 2h-4\" />\n  <path d=\"m5 21-3-3 3-3\" />\n  <path d=\"M8 2v3\" />"),
    CALENDAR_CHEVRONS_RIGHT(
        "calendar-chevrons-right",
        "<path d=\"m13 21 3-3-3-3\" />\n  <path d=\"M16 2v3\" />\n  <path d=\"m19 21 3-3-3-3\" />\n  <path d=\"M21 11.5V5a2 2 0 00-2-2H5a2 2 0 00-2 2v14a2 2 0 002 2h4\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 2v3\" />"),
    CASTLE(
        "castle",
        "<path d=\"M10 5V3\" />\n  <path d=\"M14 5V3\" />\n  <path d=\"M15 21v-3a3 3 0 0 0-6 0v3\" />\n  <path d=\"M18 3v8\" />\n  <path d=\"M18 5H6\" />\n  <path d=\"M22 11H2\" />\n  <path d=\"M22 9v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V9\" />\n  <path d=\"M6 3v8\" />"),
    CHURCH(
        "church",
        "<path d=\"M10 9h4\" />\n  <path d=\"M12 7v5\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"m18 9 3.52 2.147a1 1 0 0 1 .48.854V19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-6.999a1 1 0 0 1 .48-.854L6 9\" />\n  <path d=\"M6 21V7a1 1 0 0 1 .376-.782l5-3.999a1 1 0 0 1 1.249.001l5 4A1 1 0 0 1 18 7v14\" />"),
    CIRCLE_CHEVRONS_DOWN(
        "circle-chevrons-down",
        "<path d=\"M9 14L12 17L15 14\" />\n  <path d=\"M9 8L12 11L15 8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_LEFT(
        "circle-chevrons-left",
        "<path d=\"M10 9L7 12L10 15\" />\n  <path d=\"M16 9L13 12L16 15\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_RIGHT(
        "circle-chevrons-right",
        "<path d=\"M14 15L17 12L14 9\" />\n  <path d=\"M8 15L11 12L8 9\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_CHEVRONS_UP(
        "circle-chevrons-up",
        "<path d=\"M15 10L12 7L9 10\" />\n  <path d=\"M15 16L12 13L9 16\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_PARKING(
        "circle-parking",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9 17V7h4a3 3 0 0 1 0 6H9\" />"),
    CIRCLE_PARKING_OFF(
        "circle-parking-off",
        "<path d=\"M12.656 7H13a3 3 0 0 1 2.984 3.307\" />\n  <path d=\"M13 13H9\" />\n  <path d=\"M19.071 19.071A1 1 0 0 1 4.93 4.93\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8.357 2.687a10 10 0 0 1 12.956 12.956\" />\n  <path d=\"M9 17V9\" />"),
    COMPASS(
        "compass",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m16.24 7.76-1.804 5.411a2 2 0 0 1-1.265 1.265L7.76 16.24l1.804-5.411a2 2 0 0 1 1.265-1.265z\" />"),
    CREDIT_CARD_READER(
        "credit-card-reader",
        "<path d=\"M15 16v1\" />\n  <path d=\"M16.963 7.734A1 1 0 0015.999 7H8.003a1 1 0 00-.964.734L4.073 18.467A2 2 0 006 21h12a2 2 0 001.927-2.532z\" />\n  <path d=\"M2.678 8.5A2 2 0 012 7V5a2 2 0 012-2h16a2 2 0 012 2v2a2 2 0 01-.676 1.499\" />\n  <path d=\"m9 21 2-14\" />"),
    DAM(
        "dam",
        "<path d=\"M11 11.31c1.17.56 1.54 1.69 3.5 1.69 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M11.75 18c.35.5 1.45 1 2.75 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <path d=\"M2 6h4\" />\n  <path d=\"M7 3a1 1 0 0 0-1 1v16a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1L10 4a1 1 0 0 0-1-1z\" />"),
    DOME(
        "dome",
        "<path d=\"M10 21v-3a2 2 0 014 0v3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M18 12v9\" />\n  <path d=\"M22 19a2 2 0 01-2 2H4a2 2 0 01-2-2v-6a1 1 0 011-1h18a1 1 0 011 1z\" />\n  <path d=\"M4 12a8 8 0 0116 0\" />\n  <path d=\"M6 12v9\" />"),
    DUMBBELL(
        "dumbbell",
        "<path d=\"M17.596 12.768a2 2 0 1 0 2.829-2.829l-1.768-1.767a2 2 0 0 0 2.828-2.829l-2.828-2.828a2 2 0 0 0-2.829 2.828l-1.767-1.768a2 2 0 1 0-2.829 2.829z\" />\n  <path d=\"m2.5 21.5 1.4-1.4\" />\n  <path d=\"m20.1 3.9 1.4-1.4\" />\n  <path d=\"M5.343 21.485a2 2 0 1 0 2.829-2.828l1.767 1.768a2 2 0 1 0 2.829-2.829l-6.364-6.364a2 2 0 1 0-2.829 2.829l1.768 1.767a2 2 0 0 0-2.828 2.829z\" />\n  <path d=\"m9.6 14.4 4.8-4.8\" />"),
    EARTH(
        "earth",
        "<path d=\"M21.54 15H17a2 2 0 0 0-2 2v4.54\" />\n  <path d=\"M7 3.34V5a3 3 0 0 0 3 3a2 2 0 0 1 2 2c0 1.1.9 2 2 2a2 2 0 0 0 2-2c0-1.1.9-2 2-2h3.17\" />\n  <path d=\"M11 21.95V18a2 2 0 0 0-2-2a2 2 0 0 1-2-2v-1a2 2 0 0 0-2-2H2.05\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    EV_CHARGER(
        "ev-charger",
        "<path d=\"M14 13h2a2 2 0 0 1 2 2v2a2 2 0 0 0 4 0v-6.998a2 2 0 0 0-.59-1.42L18 5\" />\n  <path d=\"M14 21V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v16\" />\n  <path d=\"M2 21h13\" />\n  <path d=\"M3 7h11\" />\n  <path d=\"m9 11-2 3h3l-2 3\" />"),
    FACTORY(
        "factory",
        "<path d=\"M12 16h.01\" />\n  <path d=\"M16 16h.01\" />\n  <path d=\"M3 19a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V8.5a.5.5 0 0 0-.769-.422l-4.462 2.844A.5.5 0 0 1 15 10.5v-2a.5.5 0 0 0-.769-.422L9.77 10.922A.5.5 0 0 1 9 10.5V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2z\" />\n  <path d=\"M8 16h.01\" />"),
    FAUCET(
        "faucet",
        "<path d=\"M10.083 5.428 5.57 4.083a2 2 0 10.001 3.834l4.512-1.345\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"m13.917 5.428 4.511-1.345a2 2 0 110 3.834l-4.51-1.345\" />\n  <path d=\"M18 17v-4.006\" />\n  <path d=\"M22 11v8\" />\n  <path d=\"M22 12h-3a1 1 0 00-1 .994h-2.539a4 4 0 00-6.915-.012L7 13a5 5 0 00-5 5v1a1 1 0 001 1h2a1 1 0 001-1v-1a1 1 0 01.995-1l1.552.018a4 4 0 006.907 0L18 17a1 1 0 001 1h3\" />\n  <circle cx=\"12\" cy=\"6\" r=\"2\" />"),
    FERRIS_WHEEL(
        "ferris-wheel",
        "<circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M12 2v4\" />\n  <path d=\"m6.8 15-3.5 2\" />\n  <path d=\"m20.7 7-3.5 2\" />\n  <path d=\"M6.8 9 3.3 7\" />\n  <path d=\"m20.7 17-3.5-2\" />\n  <path d=\"m9 22 3-8 3 8\" />\n  <path d=\"M8 22h8\" />\n  <path d=\"M18 18.7a9 9 0 1 0-12 0\" />"),
    FLAG_TRIANGLE_LEFT(
        "flag-triangle-left",
        "<path d=\"M18 22V2.8a.8.8 0 0 0-1.17-.71L5.45 7.78a.8.8 0 0 0 0 1.44L18 15.5\" />"),
    FLAG_TRIANGLE_RIGHT(
        "flag-triangle-right",
        "<path d=\"M6 22V2.8a.8.8 0 0 1 1.17-.71l11.38 5.69a.8.8 0 0 1 0 1.44L6 15.5\" />"),
    FOOTPRINTS(
        "footprints",
        "<path d=\"M4 16v-2.38C4 11.5 2.97 10.5 3 8c.03-2.72 1.49-6 4.5-6C9.37 2 10 3.8 10 5.5c0 3.11-2 5.66-2 8.68V16a2 2 0 1 1-4 0Z\" />\n  <path d=\"M20 20v-2.38c0-2.12 1.03-3.12 1-5.62-.03-2.72-1.49-6-4.5-6C14.63 6 14 7.8 14 9.5c0 3.11 2 5.66 2 8.68V20a2 2 0 1 0 4 0Z\" />\n  <path d=\"M16 17h4\" />\n  <path d=\"M4 13h4\" />"),
    FUEL(
        "fuel",
        "<path d=\"M14 13h2a2 2 0 0 1 2 2v2a2 2 0 0 0 4 0v-6.998a2 2 0 0 0-.59-1.42L18 5\" />\n  <path d=\"M14 21V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v16\" />\n  <path d=\"M2 21h13\" />\n  <path d=\"M3 9h11\" />"),
    GAVEL(
        "gavel",
        "<path d=\"m14 13-8.381 8.38a1 1 0 0 1-3.001-3l8.384-8.381\" />\n  <path d=\"m16 16 6-6\" />\n  <path d=\"m21.5 10.5-8-8\" />\n  <path d=\"m8 8 6-6\" />\n  <path d=\"m8.5 7.5 8 8\" />"),
    GIT_COMMIT_HORIZONTAL(
        "git-commit-horizontal",
        "<circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <line x1=\"3\" x2=\"9\" y1=\"12\" y2=\"12\" />\n  <line x1=\"15\" x2=\"21\" y1=\"12\" y2=\"12\" />"),
    GIT_COMMIT_VERTICAL(
        "git-commit-vertical",
        "<path d=\"M12 3v6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"M12 15v6\" />"),
    GLOBE(
        "globe",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 2a14.5 14.5 0 0 0 0 20 14.5 14.5 0 0 0 0-20\" />\n  <path d=\"M2 12h20\" />"),
    GLOBE_CHECK(
        "globe-check",
        "<path d=\"m15 6 2 2 4-4\" />\n  <path d=\"M2 12h20A10 10 0 1 1 12 2a14.5 14.5 0 0 0 0 20 14.5 14.5 0 0 0 4-10\" />"),
    GLOBE_CODE(
        "globe-code",
        "<path d=\"M15.5 10 13 7.5 15.5 5\" />\n  <path d=\"M15.861 14A14.5 14.5 0 0112 22a14.48 14.48 0 010-20 10 10 0 109.888 11.5\" />\n  <path d=\"M19.5 5 22 7.5 19.5 10\" />\n  <path d=\"M2 12h8.5\" />"),
    GLOBE_OFF(
        "globe-off",
        "<path d=\"M10.114 4.462A14.5 14.5 0 0 1 12 2a10 10 0 0 1 9.313 13.643\" />\n  <path d=\"M15.557 15.556A14.5 14.5 0 0 1 12 22 10 10 0 0 1 4.929 4.929\" />\n  <path d=\"M15.892 10.234A14.5 14.5 0 0 0 12 2a10 10 0 0 0-3.643.687\" />\n  <path d=\"M17.656 12H22\" />\n  <path d=\"M19.071 19.071A10 10 0 0 1 12 22 14.5 14.5 0 0 1 8.44 8.45\" />\n  <path d=\"M2 12h10\" />\n  <path d=\"m2 2 20 20\" />"),
    GLOBE_X(
        "globe-x",
        "<path d=\"m16 3 5 5\" />\n  <path d=\"M2 12h20A10 10 0 1 1 12 2a14.5 14.5 0 0 0 0 20 14.5 14.5 0 0 0 4-10\" />\n  <path d=\"m21 3-5 5\" />"),
    HIKING_STICK(
        "hiking-stick",
        "<path d=\"M13.5 10.5 2 22\" />\n  <path d=\"M16.352 11.648a1.205 1.205 0 01-1.704 0l-2.296-2.296a1.205 1.205 0 010-1.704l.72-.72a2 2 0 011.022-.546l.599-.12a2 2 0 001.569-1.57l.12-.598a2 2 0 01.546-1.022l.72-.72a1.205 1.205 0 011.704 0l2.296 2.296a1.205 1.205 0 010 1.704l-6.02 6.02a1 1 0 103 3l.201-.201A7.4 7.4 0 0021 9.93V7\" />\n  <path d=\"m6 21-3-3\" />"),
    HOSPITAL(
        "hospital",
        "<path d=\"M12 7v4\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M14 9h-4\" />\n  <path d=\"M18 11h2a2 2 0 0 1 2 2v6a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-9a2 2 0 0 1 2-2h2\" />\n  <path d=\"M18 21V5a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16\" />"),
    HOTEL(
        "hotel",
        "<path d=\"M10 22v-6.57\" />\n  <path d=\"M12 11h.01\" />\n  <path d=\"M12 7h.01\" />\n  <path d=\"M14 15.43V22\" />\n  <path d=\"M15 16a5 5 0 0 0-6 0\" />\n  <path d=\"M16 11h.01\" />\n  <path d=\"M16 7h.01\" />\n  <path d=\"M8 11h.01\" />\n  <path d=\"M8 7h.01\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    HOUSE(
        "house",
        "<path d=\"M15 21v-8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v8\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    LANDMARK(
        "landmark",
        "<path d=\"M10 18v-7\" />\n  <path d=\"M11.119 2.205a2 2 0 0 1 1.762 0l7.84 3.846A.5.5 0 0 1 20.5 7h-17a.5.5 0 0 1-.22-.949z\" />\n  <path d=\"M14 18v-7\" />\n  <path d=\"M18 18v-7\" />\n  <path d=\"M3 22h18\" />\n  <path d=\"M6 18v-7\" />"),
    LIBRARY(
        "library",
        "<path d=\"m16 6 4 14\" />\n  <path d=\"M12 6v14\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M4 4v16\" />"),
    LIBRARY_BIG(
        "library-big",
        "<rect width=\"8\" height=\"18\" x=\"3\" y=\"3\" rx=\"1\" />\n  <path d=\"M7 3v18\" />\n  <path d=\"M20.4 18.9c.2.5-.1 1.1-.6 1.3l-1.9.7c-.5.2-1.1-.1-1.3-.6L11.1 5.1c-.2-.5.1-1.1.6-1.3l1.9-.7c.5-.2 1.1.1 1.3.6Z\" />"),
    LIGHTHOUSE(
        "lighthouse",
        "<path d=\"M12 3V2\" />\n  <path d=\"M16.066 16.865 7 22l2-11V6a3 3 0 016 0v5l2 11\" />\n  <path d=\"m19.792 4.5.866-.5\" />\n  <path d=\"m19.797 13.5.866.5\" />\n  <path d=\"M21 9h1\" />\n  <path d=\"M3 9H2\" />\n  <path d=\"m4.203 13.5-.866.5\" />\n  <path d=\"M4.208 4.5 3.342 4\" />\n  <path d=\"M5.5 22h13\" />\n  <path d=\"m7.932 16.875 7.377-4.178\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h8\" />"),
    LINE_DOT_BOTTOM_VERTICAL(
        "line-dot-bottom-vertical",
        "<path d=\"M12 3v12\" />\n  <circle cx=\"12\" cy=\"18\" r=\"3\" />"),
    LINE_DOT_LEFT_HORIZONTAL(
        "line-dot-left-horizontal",
        "<path d=\"M9 12h12\" />\n  <circle cx=\"6\" cy=\"12\" r=\"3\" />"),
    LINE_DOT_RIGHT_HORIZONTAL(
        "line-dot-right-horizontal",
        "<path d=\"M 3 12 L 15 12\" />\n  <circle cx=\"18\" cy=\"12\" r=\"3\" />"),
    LINE_DOT_TOP_VERTICAL(
        "line-dot-top-vertical",
        "<path d=\"M12 9v12\" />\n  <circle cx=\"12\" cy=\"6\" r=\"3\" />"),
    LOCATE(
        "locate",
        "<line x1=\"2\" x2=\"5\" y1=\"12\" y2=\"12\" />\n  <line x1=\"19\" x2=\"22\" y1=\"12\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12\" y1=\"2\" y2=\"5\" />\n  <line x1=\"12\" x2=\"12\" y1=\"19\" y2=\"22\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />"),
    LOCATE_FIXED(
        "locate-fixed",
        "<line x1=\"2\" x2=\"5\" y1=\"12\" y2=\"12\" />\n  <line x1=\"19\" x2=\"22\" y1=\"12\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12\" y1=\"2\" y2=\"5\" />\n  <line x1=\"12\" x2=\"12\" y1=\"19\" y2=\"22\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    LOCATE_OFF(
        "locate-off",
        "<path d=\"M12 19v3\" />\n  <path d=\"M12 2v3\" />\n  <path d=\"M18.89 13.24a7 7 0 0 0-8.13-8.13\" />\n  <path d=\"M19 12h3\" />\n  <path d=\"M2 12h3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7.05 7.05a7 7 0 0 0 9.9 9.9\" />"),
    MAP(
        "map",
        "<path d=\"M14.106 5.553a2 2 0 0 0 1.788 0l3.659-1.83A1 1 0 0 1 21 4.619v12.764a1 1 0 0 1-.553.894l-4.553 2.277a2 2 0 0 1-1.788 0l-4.212-2.106a2 2 0 0 0-1.788 0l-3.659 1.83A1 1 0 0 1 3 19.381V6.618a1 1 0 0 1 .553-.894l4.553-2.277a2 2 0 0 1 1.788 0z\" />\n  <path d=\"M15 5.764v15\" />\n  <path d=\"M9 3.236v15\" />"),
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
    MAP_PLUS(
        "map-plus",
        "<path d=\"m11 19-1.106-.552a2 2 0 0 0-1.788 0l-3.659 1.83A1 1 0 0 1 3 19.381V6.618a1 1 0 0 1 .553-.894l4.553-2.277a2 2 0 0 1 1.788 0l4.212 2.106a2 2 0 0 0 1.788 0l3.659-1.83A1 1 0 0 1 21 4.619V12\" />\n  <path d=\"M15 5.764V12\" />\n  <path d=\"M18 15v6\" />\n  <path d=\"M21 18h-6\" />\n  <path d=\"M9 3.236v15\" />"),
    MILESTONE(
        "milestone",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M18.172 6a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H4a1 1 0 0 1-1-1V7a1 1 0 0 1 1-1z\" />"),
    MOSQUE(
        "mosque",
        "<path d=\"M12.268 2a2 2 0 003.465 2\" />\n  <path d=\"M14 5 L14 8\" />\n  <path d=\"M16 22v-3a2 2 0 00-4 0v3\" />\n  <path d=\"M21 13c-.662-1.497-1.666-2.753-2.9-3.63C16.825 8.47 15.422 8 14 8s-2.826.47-4.1 1.37C8.668 10.248 7.663 11.504 7 13z\" />\n  <path d=\"M3 9h4\" />\n  <path d=\"M7 22V6a5 5 0 00-2-4 5 5 0 00-2 4v14a2 2 0 002 2h14a2 2 0 002-2v-7\" />"),
    NAVIGATION("navigation", "<polygon points=\"3 11 22 2 13 21 11 13 3 11\" />"),
    NAVIGATION_2("navigation-2", "<polygon points=\"12 2 19 21 12 17 5 21 12 2\" />"),
    NAVIGATION_2_OFF(
        "navigation-2-off",
        "<path d=\"M9.31 9.31 5 21l7-4 7 4-1.17-3.17\" />\n  <path d=\"M14.53 8.88 12 2l-1.17 3.17\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    NAVIGATION_OFF(
        "navigation-off",
        "<path d=\"M8.43 8.43 3 11l8 2 2 8 2.57-5.43\" />\n  <path d=\"M17.39 11.73 22 2l-9.73 4.61\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    PARK(
        "park",
        "<path d=\"M12 18h10\" />\n  <path d=\"M13.248 9.998A4.5 4.5 0 0 0 11.75 8.6V8a1 1 0 0 0-7.5 0 4.9 4.9 0 0 0 2.25 9H8\" />\n  <path d=\"m15 14-2 6\" />\n  <path d=\"m19 14 2 6\" />\n  <path d=\"M21 14h-8\" />\n  <path d=\"M8 20v-5.922a2 2 0 0 0-.586-1.414L6.5 11.75\" />\n  <path d=\"M9.205 12.795 8 14\" />\n  <circle cx=\"19\" cy=\"6\" r=\"2\" />"),
    PARKING_METER(
        "parking-meter",
        "<path d=\"M11 15h2\" />\n  <path d=\"M12 12v3\" />\n  <path d=\"M12 19v3\" />\n  <path d=\"M15.282 19a1 1 0 0 0 .948-.68l2.37-6.988a7 7 0 1 0-13.2 0l2.37 6.988a1 1 0 0 0 .948.68z\" />\n  <path d=\"M9 9a3 3 0 1 1 6 0\" />"),
    PIN(
        "pin",
        "<path d=\"M12 17v5\" />\n  <path d=\"M9 10.76a2 2 0 0 1-1.11 1.79l-1.78.9A2 2 0 0 0 5 15.24V16a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-.76a2 2 0 0 0-1.11-1.79l-1.78-.9A2 2 0 0 1 15 10.76V7a1 1 0 0 1 1-1 2 2 0 0 0 0-4H8a2 2 0 0 0 0 4 1 1 0 0 1 1 1z\" />"),
    PIN_OFF(
        "pin-off",
        "<path d=\"M12 17v5\" />\n  <path d=\"M15 9.34V7a1 1 0 0 1 1-1 2 2 0 0 0 0-4H7.89\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M9 9v1.76a2 2 0 0 1-1.11 1.79l-1.78.9A2 2 0 0 0 5 15.24V16a1 1 0 0 0 1 1h11\" />"),
    PLANE(
        "plane",
        "<path d=\"M17.8 19.2 16 11l3.5-3.5C21 6 21.5 4 21 3c-1-.5-3 0-4.5 1.5L13 8 4.8 6.2c-.5-.1-.9.1-1.1.5l-.3.5c-.2.5-.1 1 .3 1.3L9 12l-2 3H4l-1 1 3 2 2 3 1-1v-3l3-2 3.5 5.3c.3.4.8.5 1.3.3l.5-.2c.4-.3.6-.7.5-1.2z\" />"),
    RADAR(
        "radar",
        "<path d=\"M19.07 4.93A10 10 0 0 0 6.99 3.34\" />\n  <path d=\"M4 6h.01\" />\n  <path d=\"M2.29 9.62A10 10 0 1 0 21.31 8.35\" />\n  <path d=\"M16.24 7.76A6 6 0 1 0 8.23 16.67\" />\n  <path d=\"M12 18h.01\" />\n  <path d=\"M17.99 11.66A6 6 0 0 1 15.77 16.67\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"m13.41 10.59 5.66-5.66\" />"),
    ROLLER_COASTER(
        "roller-coaster",
        "<path d=\"M6 19V5\" />\n  <path d=\"M10 19V6.8\" />\n  <path d=\"M14 19v-7.8\" />\n  <path d=\"M18 5v4\" />\n  <path d=\"M18 19v-6\" />\n  <path d=\"M22 19V9\" />\n  <path d=\"M2 19V9a4 4 0 0 1 4-4c2 0 4 1.33 6 4s4 4 6 4a4 4 0 1 0-3-6.65\" />"),
    ROUTE(
        "route",
        "<circle cx=\"6\" cy=\"19\" r=\"3\" />\n  <path d=\"M9 19h8.5a3.5 3.5 0 0 0 0-7h-11a3.5 3.5 0 0 1 0-7H15\" />\n  <circle cx=\"18\" cy=\"5\" r=\"3\" />"),
    ROUTE_OFF(
        "route-off",
        "<circle cx=\"6\" cy=\"19\" r=\"3\" />\n  <path d=\"M9 19h8.5c.4 0 .9-.1 1.3-.2\" />\n  <path d=\"M5.2 5.2A3.5 3.53 0 0 0 6.5 12H12\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 15.3a3.5 3.5 0 0 0-3.3-3.3\" />\n  <path d=\"M15 5h-4.3\" />\n  <circle cx=\"18\" cy=\"5\" r=\"3\" />"),
    SCALE(
        "scale",
        "<path d=\"M12 3v18\" />\n  <path d=\"m19 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M3 7h1a17 17 0 0 0 8-2 17 17 0 0 0 8 2h1\" />\n  <path d=\"m5 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M7 21h10\" />"),
    SCHOOL(
        "school",
        "<path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M18 4.933V21\" />\n  <path d=\"m4 6 7.106-3.79a2 2 0 0 1 1.788 0L20 6\" />\n  <path d=\"m6 11-3.52 2.147a1 1 0 0 0-.48.854V19a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-5a1 1 0 0 0-.48-.853L18 11\" />\n  <path d=\"M6 4.933V21\" />\n  <circle cx=\"12\" cy=\"9\" r=\"2\" />"),
    SHIP(
        "ship",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 9.189V13\" />\n  <path d=\"M19 12V6a2 2 0 00-2-2H7a2 2 0 00-2 2v6\" />\n  <path d=\"M19.38 19A11.6 11.6 0 0021 13l-8.188-3.639a2 2 0 00-1.624 0L3 13.001a11.6 11.6 0 002.81 7.76\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_CARGO(
        "ship-cargo",
        "<path d=\"M12 15v-3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M16.5 12V9a1 1 0 011-1h1a1 1 0 001-1V5a1 1 0 00-1-1h-13a1 1 0 00-1 1v2a1 1 0 001 1h1a1 1 0 011 1v3\" />\n  <path d=\"M19.38 19c1.076-1.815 1.636-4.89 1.628-6.008a1 1 0 00-1-.992H3.984a1 1 0 00-1 .984c-.03 1.86.97 5.621 2.826 7.776\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_WHEEL(
        "ship-wheel",
        "<circle cx=\"12\" cy=\"12\" r=\"8\" />\n  <path d=\"M12 2v7.5\" />\n  <path d=\"m19 5-5.23 5.23\" />\n  <path d=\"M22 12h-7.5\" />\n  <path d=\"m19 19-5.23-5.23\" />\n  <path d=\"M12 14.5V22\" />\n  <path d=\"M10.23 13.77 5 19\" />\n  <path d=\"M9.5 12H2\" />\n  <path d=\"M10.23 10.23 5 5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2.5\" />"),
    SIGNPOST(
        "signpost",
        "<path d=\"M12 13v8\" />\n  <path d=\"M12 3v3\" />\n  <path d=\"M2.354 10.354a1.207 1.207 0 0 1 0-1.708l2.06-2.06A2 2 0 0 1 5.828 6h12.344a2 2 0 0 1 1.414.586l2.06 2.06a1.207 1.207 0 0 1 0 1.708l-2.06 2.06a2 2 0 0 1-1.414.586H5.828a2 2 0 0 1-1.414-.586z\" />"),
    SIGNPOST_BIG(
        "signpost-big",
        "<path d=\"M10 9H4L2 7l2-2h6\" />\n  <path d=\"M14 5h6l2 2-2 2h-6\" />\n  <path d=\"M10 22V4a2 2 0 1 1 4 0v18\" />\n  <path d=\"M8 22h8\" />"),
    SQUARE_CHEVRON_DOWN(
        "square-chevron-down",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m16 10-4 4-4-4\" />"),
    SQUARE_CHEVRON_LEFT(
        "square-chevron-left",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m14 16-4-4 4-4\" />"),
    SQUARE_CHEVRON_RIGHT(
        "square-chevron-right",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m10 8 4 4-4 4\" />"),
    SQUARE_CHEVRON_UP(
        "square-chevron-up",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m8 14 4-4 4 4\" />"),
    SQUARE_LIBRARY(
        "square-library",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M7 7v10\" />\n  <path d=\"M11 7v10\" />\n  <path d=\"m15 7 2 10\" />"),
    SQUARE_M(
        "square-m",
        "<path d=\"M8 16V8.5a.5.5 0 0 1 .9-.3l2.7 3.599a.5.5 0 0 0 .8 0l2.7-3.6a.5.5 0 0 1 .9.3V16\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_PARKING(
        "square-parking",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 17V7h4a3 3 0 0 1 0 6H9\" />"),
    SQUARE_PARKING_OFF(
        "square-parking-off",
        "<path d=\"M3.6 3.6A2 2 0 0 1 5 3h14a2 2 0 0 1 2 2v14a2 2 0 0 1-.59 1.41\" />\n  <path d=\"M3 8.7V19a2 2 0 0 0 2 2h10.3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M13 13a3 3 0 1 0 0-6H9v2\" />\n  <path d=\"M9 17v-2.3\" />"),
    STORE(
        "store",
        "<path d=\"M15 21v-5a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v5\" />\n  <path d=\"M17.774 10.31a1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.451 0 1.12 1.12 0 0 0-1.548 0 2.5 2.5 0 0 1-3.452 0 1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.77-3.248l2.889-4.184A2 2 0 0 1 7 2h10a2 2 0 0 1 1.653.873l2.895 4.192a2.5 2.5 0 0 1-3.774 3.244\" />\n  <path d=\"M4 10.95V19a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8.05\" />"),
    TOMBSTONE(
        "tombstone",
        "<path d=\"M11 10h2\" />\n  <path d=\"M19 21V10a7 7 0 00-14 0v11\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 14h6\" />"),
    TRAIN_FRONT_TUNNEL(
        "train-front-tunnel",
        "<path d=\"M2 22V12a10 10 0 1 1 20 0v10\" />\n  <path d=\"M15 6.8v1.4a3 2.8 0 1 1-6 0V6.8\" />\n  <path d=\"M10 15h.01\" />\n  <path d=\"M14 15h.01\" />\n  <path d=\"M10 19a4 4 0 0 1-4-4v-3a6 6 0 1 1 12 0v3a4 4 0 0 1-4 4Z\" />\n  <path d=\"m9 19-2 3\" />\n  <path d=\"m15 19 2 3\" />"),
    TRAIN_TRACK(
        "train-track",
        "<path d=\"M2 17 17 2\" />\n  <path d=\"m2 14 8 8\" />\n  <path d=\"m5 11 8 8\" />\n  <path d=\"m8 8 8 8\" />\n  <path d=\"m11 5 8 8\" />\n  <path d=\"m14 2 8 8\" />\n  <path d=\"M7 22 22 7\" />"),
    UNIVERSITY(
        "university",
        "<path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M18 16h.01\" />\n  <path d=\"M22 7a1 1 0 0 0-1-1h-2a2 2 0 0 1-1.143-.359L13.143 2.36a2 2 0 0 0-2.286-.001L6.143 5.64A2 2 0 0 1 5 6H3a1 1 0 0 0-1 1v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2z\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M6 16h.01\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    UTENSILS(
        "utensils",
        "<path d=\"M3 2v7c0 1.1.9 2 2 2h4a2 2 0 0 0 2-2V2\" />\n  <path d=\"M7 2v20\" />\n  <path d=\"M21 15V2a5 5 0 0 0-5 5v6c0 1.1.9 2 2 2h3Zm0 0v7\" />"),
    UTENSILS_CROSSED(
        "utensils-crossed",
        "<path d=\"m16 2-2.3 2.3a3 3 0 0 0 0 4.2l1.8 1.8a3 3 0 0 0 4.2 0L22 8\" />\n  <path d=\"M15 15 3.3 3.3a4.2 4.2 0 0 0 0 6l7.3 7.3c.7.7 2 .7 2.8 0L15 15Zm0 0 7 7\" />\n  <path d=\"m2.1 21.8 6.4-6.3\" />\n  <path d=\"m19 5-7 7\" />"),
    WAREHOUSE(
        "warehouse",
        "<path d=\"M18 21V10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1v11\" />\n  <path d=\"M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 1.132-1.803l7.95-3.974a2 2 0 0 1 1.837 0l7.948 3.974A2 2 0 0 1 22 8z\" />\n  <path d=\"M6 13h12\" />\n  <path d=\"M6 17h12\" />"),
    WAVES_HORIZONTAL(
        "waves-horizontal",
        "<path d=\"M2 12q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 19q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 5q2.5 2 5 0t5 0 5 0 5 0\" />"),
    WAYPOINTS(
        "waypoints",
        "<path d=\"m10.586 5.414-5.172 5.172\" />\n  <path d=\"m18.586 13.414-5.172 5.172\" />\n  <path d=\"M6 12h12\" />\n  <circle cx=\"12\" cy=\"20\" r=\"2\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />\n  <circle cx=\"20\" cy=\"12\" r=\"2\" />\n  <circle cx=\"4\" cy=\"12\" r=\"2\" />"),
    WIND_ARROW_UP(
        "wind-arrow-up",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 -4 4 4\" />");

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
  default LucideIcon barrel() {
    return LucideIcon.create(Icon.BARREL);
  }

  default LucideIcon binoculars_navigation() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon birdhouse_navigation() {
    return LucideIcon.create(Icon.BIRDHOUSE);
  }

  default LucideIcon calendar_chevrons_left_navigation() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_LEFT);
  }

  default LucideIcon calendar_chevrons_right_navigation() {
    return LucideIcon.create(Icon.CALENDAR_CHEVRONS_RIGHT);
  }

  default LucideIcon castle_navigation() {
    return LucideIcon.create(Icon.CASTLE);
  }

  default LucideIcon church_navigation() {
    return LucideIcon.create(Icon.CHURCH);
  }

  default LucideIcon circle_chevrons_down_navigation() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_DOWN);
  }

  default LucideIcon circle_chevrons_left_navigation() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_LEFT);
  }

  default LucideIcon circle_chevrons_right_navigation() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_RIGHT);
  }

  default LucideIcon circle_chevrons_up_navigation() {
    return LucideIcon.create(Icon.CIRCLE_CHEVRONS_UP);
  }

  default LucideIcon circle_parking_navigation() {
    return LucideIcon.create(Icon.CIRCLE_PARKING);
  }

  default LucideIcon circle_parking_off_navigation() {
    return LucideIcon.create(Icon.CIRCLE_PARKING_OFF);
  }

  default LucideIcon compass_navigation() {
    return LucideIcon.create(Icon.COMPASS);
  }

  default LucideIcon credit_card_reader_navigation() {
    return LucideIcon.create(Icon.CREDIT_CARD_READER);
  }

  default LucideIcon dam_navigation() {
    return LucideIcon.create(Icon.DAM);
  }

  default LucideIcon dome_navigation() {
    return LucideIcon.create(Icon.DOME);
  }

  default LucideIcon dumbbell_navigation() {
    return LucideIcon.create(Icon.DUMBBELL);
  }

  default LucideIcon earth() {
    return LucideIcon.create(Icon.EARTH);
  }

  default LucideIcon ev_charger_navigation() {
    return LucideIcon.create(Icon.EV_CHARGER);
  }

  default LucideIcon factory_navigation() {
    return LucideIcon.create(Icon.FACTORY);
  }

  default LucideIcon faucet_navigation() {
    return LucideIcon.create(Icon.FAUCET);
  }

  default LucideIcon ferris_wheel() {
    return LucideIcon.create(Icon.FERRIS_WHEEL);
  }

  default LucideIcon flag_triangle_left_navigation() {
    return LucideIcon.create(Icon.FLAG_TRIANGLE_LEFT);
  }

  default LucideIcon flag_triangle_right_navigation() {
    return LucideIcon.create(Icon.FLAG_TRIANGLE_RIGHT);
  }

  default LucideIcon footprints() {
    return LucideIcon.create(Icon.FOOTPRINTS);
  }

  default LucideIcon fuel_navigation() {
    return LucideIcon.create(Icon.FUEL);
  }

  default LucideIcon gavel_navigation() {
    return LucideIcon.create(Icon.GAVEL);
  }

  default LucideIcon git_commit_horizontal_navigation() {
    return LucideIcon.create(Icon.GIT_COMMIT_HORIZONTAL);
  }

  default LucideIcon git_commit_vertical_navigation() {
    return LucideIcon.create(Icon.GIT_COMMIT_VERTICAL);
  }

  default LucideIcon globe() {
    return LucideIcon.create(Icon.GLOBE);
  }

  default LucideIcon globe_check() {
    return LucideIcon.create(Icon.GLOBE_CHECK);
  }

  default LucideIcon globe_code_navigation() {
    return LucideIcon.create(Icon.GLOBE_CODE);
  }

  default LucideIcon globe_off_navigation() {
    return LucideIcon.create(Icon.GLOBE_OFF);
  }

  default LucideIcon globe_x_navigation() {
    return LucideIcon.create(Icon.GLOBE_X);
  }

  default LucideIcon hiking_stick_navigation() {
    return LucideIcon.create(Icon.HIKING_STICK);
  }

  default LucideIcon hospital_navigation() {
    return LucideIcon.create(Icon.HOSPITAL);
  }

  default LucideIcon hotel_navigation() {
    return LucideIcon.create(Icon.HOTEL);
  }

  default LucideIcon house_navigation() {
    return LucideIcon.create(Icon.HOUSE);
  }

  default LucideIcon landmark_navigation() {
    return LucideIcon.create(Icon.LANDMARK);
  }

  default LucideIcon library_navigation() {
    return LucideIcon.create(Icon.LIBRARY);
  }

  default LucideIcon library_big_navigation() {
    return LucideIcon.create(Icon.LIBRARY_BIG);
  }

  default LucideIcon lighthouse_navigation() {
    return LucideIcon.create(Icon.LIGHTHOUSE);
  }

  default LucideIcon line_dot_bottom_vertical_navigation() {
    return LucideIcon.create(Icon.LINE_DOT_BOTTOM_VERTICAL);
  }

  default LucideIcon line_dot_left_horizontal_navigation() {
    return LucideIcon.create(Icon.LINE_DOT_LEFT_HORIZONTAL);
  }

  default LucideIcon line_dot_right_horizontal_navigation() {
    return LucideIcon.create(Icon.LINE_DOT_RIGHT_HORIZONTAL);
  }

  default LucideIcon line_dot_top_vertical_navigation() {
    return LucideIcon.create(Icon.LINE_DOT_TOP_VERTICAL);
  }

  default LucideIcon locate() {
    return LucideIcon.create(Icon.LOCATE);
  }

  default LucideIcon locate_fixed() {
    return LucideIcon.create(Icon.LOCATE_FIXED);
  }

  default LucideIcon locate_off() {
    return LucideIcon.create(Icon.LOCATE_OFF);
  }

  default LucideIcon map_navigation() {
    return LucideIcon.create(Icon.MAP);
  }

  default LucideIcon map_minus_navigation() {
    return LucideIcon.create(Icon.MAP_MINUS);
  }

  default LucideIcon map_pin_navigation() {
    return LucideIcon.create(Icon.MAP_PIN);
  }

  default LucideIcon map_pin_check_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_CHECK);
  }

  default LucideIcon map_pin_check_inside_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_CHECK_INSIDE);
  }

  default LucideIcon map_pin_house_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_HOUSE);
  }

  default LucideIcon map_pin_minus_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_MINUS);
  }

  default LucideIcon map_pin_minus_inside_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_MINUS_INSIDE);
  }

  default LucideIcon map_pin_off_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_OFF);
  }

  default LucideIcon map_pin_pen_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_PEN);
  }

  default LucideIcon map_pin_plus_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_PLUS);
  }

  default LucideIcon map_pin_plus_inside_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_PLUS_INSIDE);
  }

  default LucideIcon map_pin_search_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_SEARCH);
  }

  default LucideIcon map_pin_x_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_X);
  }

  default LucideIcon map_pin_x_inside_navigation() {
    return LucideIcon.create(Icon.MAP_PIN_X_INSIDE);
  }

  default LucideIcon map_pinned_navigation() {
    return LucideIcon.create(Icon.MAP_PINNED);
  }

  default LucideIcon map_plus() {
    return LucideIcon.create(Icon.MAP_PLUS);
  }

  default LucideIcon milestone_navigation() {
    return LucideIcon.create(Icon.MILESTONE);
  }

  default LucideIcon mosque_navigation() {
    return LucideIcon.create(Icon.MOSQUE);
  }

  default LucideIcon navigation() {
    return LucideIcon.create(Icon.NAVIGATION);
  }

  default LucideIcon navigation_2() {
    return LucideIcon.create(Icon.NAVIGATION_2);
  }

  default LucideIcon navigation_2_off() {
    return LucideIcon.create(Icon.NAVIGATION_2_OFF);
  }

  default LucideIcon navigation_off() {
    return LucideIcon.create(Icon.NAVIGATION_OFF);
  }

  default LucideIcon park_navigation() {
    return LucideIcon.create(Icon.PARK);
  }

  default LucideIcon parking_meter_navigation() {
    return LucideIcon.create(Icon.PARKING_METER);
  }

  default LucideIcon pin_navigation() {
    return LucideIcon.create(Icon.PIN);
  }

  default LucideIcon pin_off() {
    return LucideIcon.create(Icon.PIN_OFF);
  }

  default LucideIcon plane_navigation() {
    return LucideIcon.create(Icon.PLANE);
  }

  default LucideIcon radar_navigation() {
    return LucideIcon.create(Icon.RADAR);
  }

  default LucideIcon roller_coaster() {
    return LucideIcon.create(Icon.ROLLER_COASTER);
  }

  default LucideIcon route() {
    return LucideIcon.create(Icon.ROUTE);
  }

  default LucideIcon route_off() {
    return LucideIcon.create(Icon.ROUTE_OFF);
  }

  default LucideIcon scale_navigation() {
    return LucideIcon.create(Icon.SCALE);
  }

  default LucideIcon school_navigation() {
    return LucideIcon.create(Icon.SCHOOL);
  }

  default LucideIcon ship_navigation() {
    return LucideIcon.create(Icon.SHIP);
  }

  default LucideIcon ship_cargo_navigation() {
    return LucideIcon.create(Icon.SHIP_CARGO);
  }

  default LucideIcon ship_wheel_navigation() {
    return LucideIcon.create(Icon.SHIP_WHEEL);
  }

  default LucideIcon signpost_navigation() {
    return LucideIcon.create(Icon.SIGNPOST);
  }

  default LucideIcon signpost_big_navigation() {
    return LucideIcon.create(Icon.SIGNPOST_BIG);
  }

  default LucideIcon square_chevron_down_navigation() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_DOWN);
  }

  default LucideIcon square_chevron_left_navigation() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_LEFT);
  }

  default LucideIcon square_chevron_right_navigation() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_RIGHT);
  }

  default LucideIcon square_chevron_up_navigation() {
    return LucideIcon.create(Icon.SQUARE_CHEVRON_UP);
  }

  default LucideIcon square_library_navigation() {
    return LucideIcon.create(Icon.SQUARE_LIBRARY);
  }

  default LucideIcon square_m_navigation() {
    return LucideIcon.create(Icon.SQUARE_M);
  }

  default LucideIcon square_parking_navigation() {
    return LucideIcon.create(Icon.SQUARE_PARKING);
  }

  default LucideIcon square_parking_off_navigation() {
    return LucideIcon.create(Icon.SQUARE_PARKING_OFF);
  }

  default LucideIcon store_navigation() {
    return LucideIcon.create(Icon.STORE);
  }

  default LucideIcon tombstone_navigation() {
    return LucideIcon.create(Icon.TOMBSTONE);
  }

  default LucideIcon train_front_tunnel_navigation() {
    return LucideIcon.create(Icon.TRAIN_FRONT_TUNNEL);
  }

  default LucideIcon train_track_navigation() {
    return LucideIcon.create(Icon.TRAIN_TRACK);
  }

  default LucideIcon university_navigation() {
    return LucideIcon.create(Icon.UNIVERSITY);
  }

  default LucideIcon utensils_navigation() {
    return LucideIcon.create(Icon.UTENSILS);
  }

  default LucideIcon utensils_crossed_navigation() {
    return LucideIcon.create(Icon.UTENSILS_CROSSED);
  }

  default LucideIcon warehouse_navigation() {
    return LucideIcon.create(Icon.WAREHOUSE);
  }

  default LucideIcon waves_horizontal_navigation() {
    return LucideIcon.create(Icon.WAVES_HORIZONTAL);
  }

  default LucideIcon waypoints_navigation() {
    return LucideIcon.create(Icon.WAYPOINTS);
  }

  default LucideIcon wind_arrow_up_navigation() {
    return LucideIcon.create(Icon.WIND_ARROW_UP);
  }
}
