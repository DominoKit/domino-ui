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

/** Tabler Buildings catalog category. */
public interface TablerBuildings {
  enum OutlineIcon implements TablerIconDefinition {
    ARMCHAIR(
        "armchair",
        "<path d=\"M5 11a2 2 0 0 1 2 2v2h10v-2a2 2 0 1 1 4 0v4a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-4a2 2 0 0 1 2 -2\" />\n  <path d=\"M5 11v-5a3 3 0 0 1 3 -3h8a3 3 0 0 1 3 3v5\" />\n  <path d=\"M6 19v2\" />\n  <path d=\"M18 19v2\" />"),
    ARMCHAIR_2(
        "armchair-2",
        "<path d=\"M5 10v-4a3 3 0 0 1 3 -3h8a3 3 0 0 1 3 3v4\" />\n  <path d=\"M16 15v-2a3 3 0 1 1 3 3v3h-14v-3a3 3 0 1 1 3 -3v2\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"M7 19v2\" />\n  <path d=\"M17 19v2\" />"),
    ARMCHAIR_2_OFF(
        "armchair-2-off",
        "<path d=\"M5 10v-4a3 3 0 0 1 .128 -.869m2.038 -2.013c.264 -.078 .544 -.118 .834 -.118h8a3 3 0 0 1 3 3v4\" />\n  <path d=\"M16.124 12.145a3 3 0 1 1 3.756 3.724m-.88 3.131h-14v-3a3 3 0 1 1 3 -3v2\" />\n  <path d=\"M8 12h4\" />\n  <path d=\"M7 19v2\" />\n  <path d=\"M17 19v2\" />\n  <path d=\"M3 3l18 18\" />"),
    ARMCHAIR_OFF(
        "armchair-off",
        "<path d=\"M17 13a2 2 0 1 1 4 0v4m-2 2h-14a2 2 0 0 1 -2 -2v-4a2 2 0 1 1 4 0v2h8.036\" />\n  <path d=\"M5 11v-5a3 3 0 0 1 .134 -.89m1.987 -1.98a3 3 0 0 1 .879 -.13h8a3 3 0 0 1 3 3v5\" />\n  <path d=\"M6 19v2\" />\n  <path d=\"M18 19v2\" />\n  <path d=\"M3 3l18 18\" />"),
    BATH(
        "bath",
        "<path d=\"M4 12h16a1 1 0 0 1 1 1v3a4 4 0 0 1 -4 4h-10a4 4 0 0 1 -4 -4v-3a1 1 0 0 1 1 -1\" />\n  <path d=\"M6 12v-7a2 2 0 0 1 2 -2h3v2.25\" />\n  <path d=\"M4 21l1 -1.5\" />\n  <path d=\"M20 21l-1 -1.5\" />"),
    BATH_OFF(
        "bath-off",
        "<path d=\"M16 12h4a1 1 0 0 1 1 1v3c0 .311 -.036 .614 -.103 .904m-1.61 2.378a3.982 3.982 0 0 1 -2.287 .718h-10a4 4 0 0 1 -4 -4v-3a1 1 0 0 1 1 -1h8\" />\n  <path d=\"M6 12v-6m1.178 -2.824c.252 -.113 .53 -.176 .822 -.176h3v2.25\" />\n  <path d=\"M4 21l1 -1.5\" />\n  <path d=\"M20 21l-1 -1.5\" />\n  <path d=\"M3 3l18 18\" />"),
    BED_FLAT(
        "bed-flat",
        "<path d=\"M3 11a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 13h11v-2a3 3 0 0 0 -3 -3h-8v5\" />\n  <path d=\"M3 16h18\" />"),
    BELL_SCHOOL(
        "bell-school",
        "<path d=\"M4 10a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M13.5 15h.5a2 2 0 0 1 2 2v1a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-1a2 2 0 0 1 2 -2h.5\" />\n  <path d=\"M16 17a5.698 5.698 0 0 0 4.467 -7.932l-.467 -1.068\" />\n  <path d=\"M10 10v.01\" />\n  <path d=\"M19 8a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />"),
    BUILDING(
        "building",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M9 8l1 0\" />\n  <path d=\"M9 12l1 0\" />\n  <path d=\"M9 16l1 0\" />\n  <path d=\"M14 8l1 0\" />\n  <path d=\"M14 12l1 0\" />\n  <path d=\"M14 16l1 0\" />\n  <path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16\" />"),
    BUILDING_AIRPORT(
        "building-airport",
        "<path d=\"M3.59 7h8.82a1 1 0 0 1 .902 1.433l-1.44 3a1 1 0 0 1 -.901 .567h-5.942a1 1 0 0 1 -.901 -.567l-1.44 -3a1 1 0 0 1 .901 -1.433\" />\n  <path d=\"M6 7l-.78 -2.342a.5 .5 0 0 1 .473 -.658h4.612a.5 .5 0 0 1 .475 .658l-.78 2.342\" />\n  <path d=\"M8 2v2\" />\n  <path d=\"M6 12v9h4v-9\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M22 5h-6l-1 -1\" />\n  <path d=\"M18 3l2 2l-2 2\" />\n  <path d=\"M10 17h7a2 2 0 0 1 2 2v2\" />"),
    BUILDING_ARCH(
        "building-arch",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M4 21v-15a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v15\" />\n  <path d=\"M9 21v-8a3 3 0 0 1 6 0v8\" />"),
    BUILDING_BANK(
        "building-bank",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M3 10l18 0\" />\n  <path d=\"M5 6l7 -3l7 3\" />\n  <path d=\"M4 10l0 11\" />\n  <path d=\"M20 10l0 11\" />\n  <path d=\"M8 14l0 3\" />\n  <path d=\"M12 14l0 3\" />\n  <path d=\"M16 14l0 3\" />"),
    BUILDING_BRIDGE(
        "building-bridge",
        "<path d=\"M6 5l0 14\" />\n  <path d=\"M18 5l0 14\" />\n  <path d=\"M2 15l20 0\" />\n  <path d=\"M3 8a7.5 7.5 0 0 0 3 -2a6.5 6.5 0 0 0 12 0a7.5 7.5 0 0 0 3 2\" />\n  <path d=\"M12 10l0 5\" />"),
    BUILDING_BRIDGE_2(
        "building-bridge-2",
        "<path d=\"M6 7h12a2 2 0 0 1 2 2v9a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-2a4 4 0 0 0 -8 0v2a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-9a2 2 0 0 1 2 -2\" />"),
    BUILDING_BROADCAST_TOWER(
        "building-broadcast-tower",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16.616 13.924a5 5 0 1 0 -9.23 0\" />\n  <path d=\"M20.307 15.469a9 9 0 1 0 -16.615 0\" />\n  <path d=\"M9 21l3 -9l3 9\" />\n  <path d=\"M10 19h4\" />"),
    BUILDING_BURJ_AL_ARAB(
        "building-burj-al-arab",
        "<path d=\"M3 21h18\" />\n  <path d=\"M7 21v-18\" />\n  <path d=\"M7 4c5.675 .908 10 5.613 10 11.28a11 11 0 0 1 -1.605 5.72\" />\n  <path d=\"M5 9h12\" />\n  <path d=\"M7 13h4\" />\n  <path d=\"M7 17h4\" />"),
    BUILDING_CAROUSEL(
        "building-carousel",
        "<path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M3 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 4a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 16a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 16a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M8 22l4 -10l4 10\" />"),
    BUILDING_CASTLE(
        "building-castle",
        "<path d=\"M15 19v-2a3 3 0 0 0 -6 0v2a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-14h4v3h3v-3h4v3h3v-3h4v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1\" />\n  <path d=\"M3 11l18 0\" />"),
    BUILDING_CHURCH(
        "building-church",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M10 21v-4a2 2 0 0 1 4 0v4\" />\n  <path d=\"M10 5l4 0\" />\n  <path d=\"M12 3l0 5\" />\n  <path d=\"M6 21v-7m-2 2l8 -8l8 8m-2 -2v7\" />"),
    BUILDING_CIRCUS(
        "building-circus",
        "<path d=\"M4 11h16\" />\n  <path d=\"M12 6.5c0 1 -5 4.5 -8 4.5\" />\n  <path d=\"M12 6.5c0 1 5 4.5 8 4.5\" />\n  <path d=\"M6 11c-.333 5.333 -1 8.667 -2 10h4c1 0 4 -4 4 -9v-1\" />\n  <path d=\"M18 11c.333 5.333 1 8.667 2 10h-4c-1 0 -4 -4 -4 -9v-1\" />\n  <path d=\"M12 7v-4l2 1h-2\" />"),
    BUILDING_COG(
        "building-cog",
        "<path d=\"M3 21h9\" />\n  <path d=\"M9 8h1\" />\n  <path d=\"M9 12h1\" />\n  <path d=\"M9 16h1\" />\n  <path d=\"M14 8h1\" />\n  <path d=\"M14 12h1\" />\n  <path d=\"M5 21v-16c0 -.53 .211 -1.039 .586 -1.414c.375 -.375 .884 -.586 1.414 -.586h10c.53 0 1.039 .211 1.414 .586c.375 .375 .586 .884 .586 1.414v7\" />\n  <path d=\"M16 18c0 .53 .211 1.039 .586 1.414c.375 .375 .884 .586 1.414 .586c.53 0 1.039 -.211 1.414 -.586c.375 -.375 .586 -.884 .586 -1.414c0 -.53 -.211 -1.039 -.586 -1.414c-.375 -.375 -.884 -.586 -1.414 -.586c-.53 0 -1.039 .211 -1.414 .586c-.375 .375 -.586 .884 -.586 1.414\" />\n  <path d=\"M18 14.5v1.5\" />\n  <path d=\"M18 20v1.5\" />\n  <path d=\"M21.032 16.25l-1.299 .75\" />\n  <path d=\"M16.27 19l-1.3 .75\" />\n  <path d=\"M14.97 16.25l1.3 .75\" />\n  <path d=\"M19.733 19l1.3 .75\" />"),
    BUILDING_COMMUNITY(
        "building-community",
        "<path d=\"M8 9l5 5v7h-5v-4m0 4h-5v-7l5 -5m1 1v-6a1 1 0 0 1 1 -1h10a1 1 0 0 1 1 1v17h-8\" />\n  <path d=\"M13 7l0 .01\" />\n  <path d=\"M17 7l0 .01\" />\n  <path d=\"M17 11l0 .01\" />\n  <path d=\"M17 15l0 .01\" />"),
    BUILDING_COTTAGE(
        "building-cottage",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M4 21v-11l2.5 -4.5l5.5 -2.5l5.5 2.5l2.5 4.5v11\" />\n  <path d=\"M10 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M9 21v-5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v5\" />"),
    BUILDING_EIFFEL_TOWER(
        "building-eiffel-tower",
        "<path d=\"M11 4c0 4.889 -2.292 12.111 -5 17\" />\n  <path d=\"M13 4c0 4.889 2.292 12.111 5 17\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M8 14h8\" />\n  <path d=\"M9 10h6\" />\n  <path d=\"M10 4h4\" />\n  <path d=\"M12 2v1.778\" />\n  <path d=\"M10 21s.27 -1.406 .667 -2c.333 -.5 .666 -1 1.333 -1s1 .5 1.333 1c.448 .672 .667 2 .667 2\" />"),
    BUILDING_ESTATE(
        "building-estate",
        "<path d=\"M3 21h18\" />\n  <path d=\"M19 21v-4\" />\n  <path d=\"M19 17a2 2 0 0 0 2 -2v-2a2 2 0 1 0 -4 0v2a2 2 0 0 0 2 2\" />\n  <path d=\"M14 21v-14a3 3 0 0 0 -3 -3h-4a3 3 0 0 0 -3 3v14\" />\n  <path d=\"M9 17v4\" />\n  <path d=\"M8 13h2\" />\n  <path d=\"M8 9h2\" />"),
    BUILDING_FACTORY(
        "building-factory",
        "<path d=\"M4 21c1.147 -4.02 1.983 -8.027 2 -12h6c.017 3.973 .853 7.98 2 12\" />\n  <path d=\"M12.5 13h4.5c.025 2.612 .894 5.296 2 8\" />\n  <path d=\"M9 5a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1\" />\n  <path d=\"M3 21l19 0\" />"),
    BUILDING_FACTORY_2(
        "building-factory-2",
        "<path d=\"M3 21h18\" />\n  <path d=\"M5 21v-12l5 4v-4l5 4h4\" />\n  <path d=\"M19 21v-8l-1.436 -9.574a.5 .5 0 0 0 -.495 -.426h-1.145a.5 .5 0 0 0 -.494 .418l-1.43 8.582\" />\n  <path d=\"M9 17h1\" />\n  <path d=\"M14 17h1\" />"),
    BUILDING_FORTRESS(
        "building-fortress",
        "<path d=\"M7 21h1a1 1 0 0 0 1 -1v-1a3 3 0 0 1 6 0m3 2h1a1 1 0 0 0 1 -1v-15l-3 -2l-3 2v6h-4v-6l-3 -2l-3 2v15a1 1 0 0 0 1 1h2m8 -2v1a1 1 0 0 0 1 1h2\" />\n  <path d=\"M7 7v.01\" />\n  <path d=\"M7 10v.01\" />\n  <path d=\"M7 13v.01\" />\n  <path d=\"M17 7v.01\" />\n  <path d=\"M17 10v.01\" />\n  <path d=\"M17 13v.01\" />"),
    BUILDING_HOSPITAL(
        "building-hospital",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M5 21v-16a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v16\" />\n  <path d=\"M9 21v-4a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v4\" />\n  <path d=\"M10 9l4 0\" />\n  <path d=\"M12 7l0 4\" />"),
    BUILDING_LIGHTHOUSE(
        "building-lighthouse",
        "<path d=\"M12 3l2 3l2 15h-8l2 -15l2 -3\" />\n  <path d=\"M8 9l8 0\" />\n  <path d=\"M3 11l2 -2l-2 -2\" />\n  <path d=\"M21 11l-2 -2l2 -2\" />"),
    BUILDING_MINUS(
        "building-minus",
        "<path d=\"M3 21h9\" />\n  <path d=\"M9 8h1\" />\n  <path d=\"M9 12h1\" />\n  <path d=\"M9 16h1\" />\n  <path d=\"M14 8h1\" />\n  <path d=\"M14 12h1\" />\n  <path d=\"M5 21v-16c0 -.53 .211 -1.039 .586 -1.414c.375 -.375 .884 -.586 1.414 -.586h10c.53 0 1.039 .211 1.414 .586c.375 .375 .586 .884 .586 1.414v7\" />\n  <path d=\"M16 19h6\" />"),
    BUILDING_MONUMENT(
        "building-monument",
        "<path d=\"M8 18l2 -13l2 -2l2 2l2 13\" />\n  <path d=\"M5 21v-3h14v3\" />\n  <path d=\"M3 21l18 0\" />"),
    BUILDING_MOSQUE(
        "building-mosque",
        "<path d=\"M3 21h7v-2a2 2 0 1 1 4 0v2h7\" />\n  <path d=\"M4 21v-10\" />\n  <path d=\"M20 21v-10\" />\n  <path d=\"M4 16h3v-3h10v3h3\" />\n  <path d=\"M17 13a5 5 0 0 0 -10 0\" />\n  <path d=\"M21 10.5c0 -.329 -.077 -.653 -.224 -.947l-.776 -1.553l-.776 1.553a2.118 2.118 0 0 0 -.224 .947a.5 .5 0 0 0 .5 .5h1a.5 .5 0 0 0 .5 -.5\" />\n  <path d=\"M5 10.5c0 -.329 -.077 -.653 -.224 -.947l-.776 -1.553l-.776 1.553a2.118 2.118 0 0 0 -.224 .947a.5 .5 0 0 0 .5 .5h1a.5 .5 0 0 0 .5 -.5\" />\n  <path d=\"M12 2a2 2 0 1 0 2 2\" />\n  <path d=\"M12 6v2\" />"),
    BUILDING_OFF(
        "building-off",
        "<path d=\"M3 21h18\" />\n  <path d=\"M9 12h1\" />\n  <path d=\"M9 16h1\" />\n  <path d=\"M14 8h1\" />\n  <path d=\"M14 16h1\" />\n  <path d=\"M5 21v-16\" />\n  <path d=\"M7 3h10c1 0 2 1 2 2v10\" />\n  <path d=\"M19 19v2\" />\n  <path d=\"M3 3l18 18\" />"),
    BUILDING_PAVILION(
        "building-pavilion",
        "<path d=\"M3 21h7v-3a2 2 0 0 1 4 0v3h7\" />\n  <path d=\"M6 21l0 -9\" />\n  <path d=\"M18 21l0 -9\" />\n  <path d=\"M6 12h12a3 3 0 0 0 3 -3a9 8 0 0 1 -9 -6a9 8 0 0 1 -9 6a3 3 0 0 0 3 3\" />"),
    BUILDING_PLUS(
        "building-plus",
        "<path d=\"M3 21h9\" />\n  <path d=\"M9 8h1\" />\n  <path d=\"M9 12h1\" />\n  <path d=\"M9 16h1\" />\n  <path d=\"M14 8h1\" />\n  <path d=\"M14 12h1\" />\n  <path d=\"M5 21v-16c0 -.53 .211 -1.039 .586 -1.414c.375 -.375 .884 -.586 1.414 -.586h10c.53 0 1.039 .211 1.414 .586c.375 .375 .586 .884 .586 1.414v7\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    BUILDING_SKYSCRAPER(
        "building-skyscraper",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M5 21v-14l8 -4v18\" />\n  <path d=\"M19 21v-10l-6 -4\" />\n  <path d=\"M9 9l0 .01\" />\n  <path d=\"M9 12l0 .01\" />\n  <path d=\"M9 15l0 .01\" />\n  <path d=\"M9 18l0 .01\" />"),
    BUILDING_STADIUM(
        "building-stadium",
        "<path d=\"M4 12a8 2 0 1 0 16 0a8 2 0 1 0 -16 0\" />\n  <path d=\"M4 12v7c0 .94 2.51 1.785 6 2v-3h4v3c3.435 -.225 6 -1.07 6 -2v-7\" />\n  <path d=\"M15 6h4v-3h-4v7\" />\n  <path d=\"M7 6h4v-3h-4v7\" />"),
    BUILDING_STORE(
        "building-store",
        "<path d=\"M3 21l18 0\" />\n  <path d=\"M3 7v1a3 3 0 0 0 6 0v-1m0 1a3 3 0 0 0 6 0v-1m0 1a3 3 0 0 0 6 0v-1h-18l2 -4h14l2 4\" />\n  <path d=\"M5 21l0 -10.15\" />\n  <path d=\"M19 21l0 -10.15\" />\n  <path d=\"M9 21v-4a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v4\" />"),
    BUILDING_TUNNEL(
        "building-tunnel",
        "<path d=\"M5 21h14a2 2 0 0 0 2 -2v-7a9 9 0 0 0 -18 0v7a2 2 0 0 0 2 2\" />\n  <path d=\"M8 21v-9a4 4 0 1 1 8 0v9\" />\n  <path d=\"M3 17h4\" />\n  <path d=\"M17 17h4\" />\n  <path d=\"M21 12h-4\" />\n  <path d=\"M7 12h-4\" />\n  <path d=\"M12 3v5\" />\n  <path d=\"M6 6l3 3\" />\n  <path d=\"M15 9l3 -3l-3 3\" />"),
    BUILDING_WAREHOUSE(
        "building-warehouse",
        "<path d=\"M3 21v-13l9 -4l9 4v13\" />\n  <path d=\"M13 13h4v8h-10v-6h6\" />\n  <path d=\"M13 21v-9a1 1 0 0 0 -1 -1h-2a1 1 0 0 0 -1 1v3\" />"),
    BUILDING_WIND_TURBINE(
        "building-wind-turbine",
        "<path d=\"M10 11a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 11v-2.573c0 -.18 .013 -.358 .04 -.536l.716 -4.828c.064 -.597 .597 -1.063 1.244 -1.063s1.18 .466 1.244 1.063l.716 4.828c.027 .178 .04 .357 .04 .536v2.573\" />\n  <path d=\"M13.01 9.28l2.235 1.276c.156 .09 .305 .19 .446 .3l3.836 2.911c.487 .352 .624 1.04 .3 1.596c-.325 .556 -1 .782 -1.548 .541l-4.555 -1.68a3.624 3.624 0 0 1 -.486 -.231l-2.235 -1.277\" />\n  <path d=\"M13 12.716l-2.236 1.277a3.624 3.624 0 0 1 -.485 .23l-4.555 1.681c-.551 .241 -1.223 .015 -1.548 -.54c-.324 -.557 -.187 -1.245 .3 -1.597l3.836 -2.91a3.41 3.41 0 0 1 .446 -.3l2.235 -1.277\" />\n  <path d=\"M7 21h10\" />\n  <path d=\"M10 21l1 -7\" />\n  <path d=\"M13 14l1 7\" />"),
    BUILDINGS(
        "buildings",
        "<path d=\"M4 21v-15c0 -1 1 -2 2 -2h5c1 0 2 1 2 2v15\" />\n  <path d=\"M16 8h2c1 0 2 1 2 2v11\" />\n  <path d=\"M3 21h18\" />\n  <path d=\"M10 12v.01\" />\n  <path d=\"M10 16v.01\" />\n  <path d=\"M10 8v.01\" />\n  <path d=\"M7 12v.01\" />\n  <path d=\"M7 16v.01\" />\n  <path d=\"M7 8v.01\" />\n  <path d=\"M17 12v.01\" />\n  <path d=\"M17 16v.01\" />"),
    CAR_GARAGE(
        "car-garage",
        "<path d=\"M5 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M15 20a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M5 20h-2v-6l2 -5h9l4 5h1a2 2 0 0 1 2 2v4h-2m-4 0h-6m-6 -6h15m-6 0v-5\" />\n  <path d=\"M3 6l9 -4l9 4\" />"),
    CHALKBOARD_TEACHER(
        "chalkboard-teacher",
        "<path d=\"M8 19h-3a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v11a1 1 0 0 1 -1 1\" />\n  <path d=\"M12 14a2 2 0 1 0 4.001 -.001a2 2 0 0 0 -4.001 .001\" />\n  <path d=\"M17 19a2 2 0 0 0 -2 -2h-2a2 2 0 0 0 -2 2\" />"),
    DOOR_HANGER(
        "door-hanger",
        "<path d=\"M12 3a7 7 0 0 0 -5.48 2.64a1 1 0 0 0 .31 1.49l1.76 1a1 1 0 0 0 1.22 -.13a3 3 0 0 1 2.82 -.88a3.09 3.09 0 0 1 2.37 3.01v.87l-9.2 1.84a1 1 0 0 0 -.8 1v6.16a1 1 0 0 0 1 1h12a1 1 0 0 0 1 -1v-9.72a7.18 7.18 0 0 0 -7 -7.28\" />\n  <path d=\"M12 17v.01\" />"),
    FENCE(
        "fence",
        "<path d=\"M4 12v4h16v-4l-16 0\" />\n  <path d=\"M6 16v4h4v-4m0 -4v-6l-2 -2l-2 2v6\" />\n  <path d=\"M14 16v4h4v-4m0 -4v-6l-2 -2l-2 2v6\" />"),
    FENCE_OFF(
        "fence-off",
        "<path d=\"M12 12h-8v4h12m4 0v-4h-4\" />\n  <path d=\"M6 16v4h4v-4\" />\n  <path d=\"M10 12v-2m0 -4l-2 -2m-2 2v6\" />\n  <path d=\"M14 16v4h4v-2\" />\n  <path d=\"M18 12v-6l-2 -2l-2 2v4\" />\n  <path d=\"M3 3l18 18\" />"),
    HOME(
        "home",
        "<path d=\"M5 12l-2 0l9 -9l9 9l-2 0\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v6\" />"),
    HOME_2(
        "home-2",
        "<path d=\"M5 12l-2 0l9 -9l9 9l-2 0\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2v-7\" />\n  <path d=\"M10 12h4v4h-4l0 -4\" />"),
    HOME_BITCOIN(
        "home-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M19.5 10.5l-7.5 -7.5l-9 9h2v7a2 2 0 0 0 2 2h6\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.387 0 .748 .11 1.054 .3\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />"),
    HOME_BOLT(
        "home-bolt",
        "<path d=\"M19 10l-7 -7l-9 9h2v7a2 2 0 0 0 2 2h7.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.661 0 1.248 .32 1.612 .815\" />\n  <path d=\"M19 14l-2 4h4l-2 4\" />"),
    HOME_CANCEL(
        "home-cancel",
        "<path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />\n  <path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.58 0 1.103 .247 1.468 .642\" />"),
    HOME_CHECK(
        "home-check",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M19 13.488v-1.488h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h4.525\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    HOME_COG(
        "home-cog",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h1.6\" />\n  <path d=\"M20 11l-8 -8l-9 9h2v7a2 2 0 0 0 2 2h4.159\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M18 14.5v1.5\" />\n  <path d=\"M18 20v1.5\" />\n  <path d=\"M21.032 16.25l-1.299 .75\" />\n  <path d=\"M16.27 19l-1.3 .75\" />\n  <path d=\"M14.97 16.25l1.3 .75\" />\n  <path d=\"M19.733 19l1.3 .75\" />"),
    HOME_DOLLAR(
        "home-dollar",
        "<path d=\"M19 10l-7 -7l-9 9h2v7a2 2 0 0 0 2 2h6\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.387 0 .748 .11 1.054 .3\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    HOME_DOT(
        "home-dot",
        "<path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.641 0 1.212 .302 1.578 .771\" />"),
    HOME_DOWN(
        "home-down",
        "<path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    HOME_ECO(
        "home-eco",
        "<path d=\"M20 11l-8 -8l-9 9h2v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.325 0 .631 .077 .902 .215\" />\n  <path d=\"M16 22s0 -2 3 -4\" />\n  <path d=\"M19 21a3 3 0 0 1 0 -6h3v3a3 3 0 0 1 -3 3\" />"),
    HOME_EDIT(
        "home-edit",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.645 0 1.218 .305 1.584 .78\" />\n  <path d=\"M20 11l-8 -8l-9 9h2v7a2 2 0 0 0 2 2h4\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    HOME_EXCLAMATION(
        "home-exclamation",
        "<path d=\"M21 12l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h8\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 1.857 1.257\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    HOME_HAND(
        "home-hand",
        "<path d=\"M18 9l-6 -6l-9 9h2v7a2 2 0 0 0 2 2h3.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M16 17.5l-.585 -.578a1.516 1.516 0 0 0 -2 0c-.477 .433 -.551 1.112 -.177 1.622l1.762 2.456c.37 .506 1.331 1 2 1h3c1.009 0 1.497 -.683 1.622 -1.593c.252 -.938 .378 -1.74 .378 -2.407c0 -1 -.939 -1.843 -2 -2h-1v-2.636c0 -.754 -.672 -1.364 -1.5 -1.364s-1.5 .61 -1.5 1.364v4.136\" />"),
    HOME_HEART(
        "home-heart",
        "<path d=\"M21 12l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h6\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.39 0 .754 .112 1.061 .304\" />\n  <path d=\"M19 21.5l2.518 -2.58a1.74 1.74 0 0 0 0 -2.413a1.627 1.627 0 0 0 -2.346 0l-.168 .172l-.168 -.172a1.627 1.627 0 0 0 -2.346 0a1.74 1.74 0 0 0 0 2.412l2.51 2.59l0 -.009\" />"),
    HOME_INFINITY(
        "home-infinity",
        "<path d=\"M19 14v-2h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h2.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 1.75 1.032\" />\n  <path d=\"M15.536 17.586a2.123 2.123 0 0 0 -2.929 0a1.951 1.951 0 0 0 0 2.828c.809 .781 2.12 .781 2.929 0c.809 -.781 -.805 .778 0 0l1.46 -1.41l1.46 -1.419\" />\n  <path d=\"M15.54 17.582l1.46 1.42l1.46 1.41c.809 .78 -.805 -.779 0 0s2.12 .781 2.929 0a1.951 1.951 0 0 0 0 -2.828a2.123 2.123 0 0 0 -2.929 0\" />"),
    HOME_LINK(
        "home-link",
        "<path d=\"M20.085 11.085l-8.085 -8.085l-9 9h2v7a2 2 0 0 0 2 2h4.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 1.807 1.143\" />\n  <path d=\"M20 21a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M20 16a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M15 19a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M21 16l-5 3l5 2\" />"),
    HOME_LOCK(
        "home-lock",
        "<path d=\"M5 12h-2l9 -9l8 8\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h6\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.688 0 1.294 .347 1.654 .875\" />\n  <path d=\"M17 19a1 1 0 0 1 1 -1h3a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-3a1 1 0 0 1 -1 -1v-2\" />\n  <path d=\"M18 18v-1.5a1.5 1.5 0 1 1 3 0v1.5\" />"),
    HOME_MINUS(
        "home-minus",
        "<path d=\"M19 15v-3h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />"),
    HOME_MOVE(
        "home-move",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16l3 3l-3 3\" />"),
    HOME_OFF(
        "home-off",
        "<path d=\"M5 12h-2l4.497 -4.497m2 -2l2.504 -2.504l9 9h-2\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h10a2 2 0 0 0 2 -2m0 -4v-3\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2m2 2v6\" />\n  <path d=\"M3 3l18 18\" />"),
    HOME_PLUS(
        "home-plus",
        "<path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    HOME_QUESTION(
        "home-question",
        "<path d=\"M20.136 11.136l-8.136 -8.136l-9 9h2v7a2 2 0 0 0 2 2h7\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.467 0 .896 .16 1.236 .428\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2 2 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    HOME_RIBBON(
        "home-ribbon",
        "<path d=\"M16 15h5v7l-2.5 -1.5l-2.5 1.5l0 -7\" />\n  <path d=\"M20 11l-8 -8l-9 9h2v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h1.5\" />"),
    HOME_SEARCH(
        "home-search",
        "<path d=\"M21 12l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h4.7\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    HOME_SHARE(
        "home-share",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.247 0 .484 .045 .702 .127\" />\n  <path d=\"M19 12h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    HOME_SHIELD(
        "home-shield",
        "<path d=\"M5 12h-2l9 -9l7.636 7.636\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h1.5\" />\n  <path d=\"M22 16c0 4 -2.5 6 -3.5 6s-3.5 -2 -3.5 -6c1 0 2.5 -.5 3.5 -1.5c1 1 2.5 1.5 3.5 1.5\" />"),
    HOME_SIGNAL(
        "home-signal",
        "<path d=\"M15 22v-2\" />\n  <path d=\"M18 22v-4\" />\n  <path d=\"M21 22v-6\" />\n  <path d=\"M19 12.494v-.494h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h4\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2v.5\" />"),
    HOME_SPARK(
        "home-spark",
        "<path d=\"M5 12h-2l9 -9l9 9h-2\" />\n  <path d=\"M5 12v7a2 2 0 0 0 2 2h5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    HOME_STAR(
        "home-star",
        "<path d=\"M19.258 10.258l-7.258 -7.258l-9 9h2v7a2 2 0 0 0 2 2h4\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h1.5\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    HOME_STATS(
        "home-stats",
        "<path d=\"M19 13v-1h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h2.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2a2 2 0 0 1 2 2\" />\n  <path d=\"M13 22l3 -3l2 2l4 -4\" />\n  <path d=\"M19 17h3v3\" />"),
    HOME_UP(
        "home-up",
        "<path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.641 0 1.212 .302 1.578 .771\" />\n  <path d=\"M20.136 11.136l-8.136 -8.136l-9 9h2v7a2 2 0 0 0 2 2h6.344\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    HOME_X(
        "home-x",
        "<path d=\"M19 13.4v-1.4h2l-9 -9l-9 9h2v7a2 2 0 0 0 2 2h5.5\" />\n  <path d=\"M9 21v-6a2 2 0 0 1 2 -2h2c.402 0 .777 .119 1.091 .323\" />\n  <path d=\"M21.5 21.5l-5 -5\" />\n  <path d=\"M16.5 21.5l5 -5\" />"),
    HOTEL_SERVICE(
        "hotel-service",
        "<path d=\"M8.5 10a1.5 1.5 0 0 1 -1.5 -1.5a5.5 5.5 0 0 1 11 0v10.5a2 2 0 0 1 -2 2h-7a2 2 0 0 1 -2 -2v-2c0 -1.38 .71 -2.444 1.88 -3.175l4.424 -2.765c1.055 -.66 1.696 -1.316 1.696 -2.56a2.5 2.5 0 1 0 -5 0a1.5 1.5 0 0 1 -1.5 1.5\" />"),
    MOSQUE(
        "mosque",
        "<path d=\"M13.5 5.49a1.764 1.764 0 0 1 -2.5 -2.49\" />\n  <path d=\"M12 6v3\" />\n  <path d=\"M19 21a8.9 8.9 0 0 0 1 -3.67c0 -2 -.92 -3.25 -3.24 -4.51a17.4 17.4 0 0 1 -4.76 -3.82a17.4 17.4 0 0 1 -4.76 3.82c-2.32 1.26 -3.24 2.55 -3.24 4.51a8.9 8.9 0 0 0 1 3.67h14\" />"),
    PODIUM(
        "podium",
        "<path d=\"M5 8h14l-.621 2.485a2 2 0 0 1 -1.94 1.515h-8.878a2 2 0 0 1 -1.94 -1.515l-.621 -2.485\" />\n  <path d=\"M7 8v-2a3 3 0 0 1 3 -3\" />\n  <path d=\"M8 12l1 9\" />\n  <path d=\"M16 12l-1 9\" />\n  <path d=\"M7 21h10\" />"),
    PODIUM_OFF(
        "podium-off",
        "<path d=\"M12 8h7l-.621 2.485a2 2 0 0 1 -1.94 1.515h-.439m-4 0h-4.439a2 2 0 0 1 -1.94 -1.515l-.621 -2.485h3\" />\n  <path d=\"M7 8v-1m.864 -3.106a2.99 2.99 0 0 1 2.136 -.894\" />\n  <path d=\"M8 12l1 9\" />\n  <path d=\"M15.599 15.613l-.599 5.387\" />\n  <path d=\"M7 21h10\" />\n  <path d=\"M3 3l18 18\" />"),
    ROCKING_CHAIR(
        "rocking-chair",
        "<path d=\"M4 3l1.478 6.65a3 3 0 0 0 2.929 2.35h9.593\" />\n  <path d=\"M10 12l-3.5 7.5\" />\n  <path d=\"M14 12l3.5 7.5\" />\n  <path d=\"M3 16c1.966 2.992 4.75 5 9 5s7.035 -2.002 9 -5\" />"),
    SCHOOL_BELL(
        "school-bell",
        "<path d=\"M4 17a3 3 0 0 0 3 3\" />\n  <path d=\"M14.805 6.37l2.783 -2.784a2 2 0 1 1 2.829 2.828l-2.784 2.786\" />\n  <path d=\"M16.505 7.495a5.105 5.105 0 0 1 .176 7.035l-.176 .184l-1.867 1.867a3.48 3.48 0 0 0 -1.013 2.234l-.008 .23v.934c0 .327 -.13 .64 -.36 .871a.51 .51 0 0 1 -.652 .06l-.07 -.06l-9.385 -9.384a.51 .51 0 0 1 0 -.722c.198 -.198 .456 -.322 .732 -.353l.139 -.008h.933c.848 0 1.663 -.309 2.297 -.864l.168 -.157l1.867 -1.867l.16 -.153a5.105 5.105 0 0 1 7.059 .153\" />"),
    SMART_HOME(
        "smart-home",
        "<path d=\"M19 8.71l-5.333 -4.148a2.666 2.666 0 0 0 -3.274 0l-5.334 4.148a2.665 2.665 0 0 0 -1.029 2.105v7.2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-7.2c0 -.823 -.38 -1.6 -1.03 -2.105\" />\n  <path d=\"M16 15c-2.21 1.333 -5.792 1.333 -8 0\" />"),
    SMART_HOME_OFF(
        "smart-home-off",
        "<path d=\"M7.097 7.125l-2.037 1.585a2.665 2.665 0 0 0 -1.029 2.105v7.2a2 2 0 0 0 2 2h12c.559 0 1.064 -.229 1.427 -.598m.572 -3.417v-5.185c0 -.823 -.38 -1.6 -1.03 -2.105l-5.333 -4.148a2.666 2.666 0 0 0 -3.274 0l-1.029 .8\" />\n  <path d=\"M15.332 15.345c-2.213 .976 -5.335 .86 -7.332 -.345\" />\n  <path d=\"M3 3l18 18\" />"),
    TOWER(
        "tower",
        "<path d=\"M5 3h1a1 1 0 0 1 1 1v2h3v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2h3v-2a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v4.394a2 2 0 0 1 -.336 1.11l-1.328 1.992a2 2 0 0 0 -.336 1.11v7.394a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1v-7.394a2 2 0 0 0 -.336 -1.11l-1.328 -1.992a2 2 0 0 1 -.336 -1.11v-4.394a1 1 0 0 1 1 -1\" />\n  <path d=\"M10 21v-5a2 2 0 1 1 4 0v5\" />"),
    TOWER_OFF(
        "tower-off",
        "<path d=\"M10 6v-2a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v2h3v-2a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v4.394a2 2 0 0 1 -.336 1.11l-1.328 1.992a2 2 0 0 0 -.336 1.11v1.394m0 4v2a1 1 0 0 1 -1 1h-10a1 1 0 0 1 -1 -1v-7.394a2 2 0 0 0 -.336 -1.11l-1.328 -1.992a2 2 0 0 1 -.336 -1.11v-4.394\" />\n  <path d=\"M10 21v-5a2 2 0 1 1 4 0v5\" />\n  <path d=\"M3 3l18 18\" />"),
    WALL(
        "wall",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 8h16\" />\n  <path d=\"M20 12h-16\" />\n  <path d=\"M4 16h16\" />\n  <path d=\"M9 4v4\" />\n  <path d=\"M14 8v4\" />\n  <path d=\"M8 12v4\" />\n  <path d=\"M16 12v4\" />\n  <path d=\"M11 16v4\" />"),
    WALL_OFF(
        "wall-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.589 3.417c-.361 .36 -.86 .583 -1.411 .583h-12a2 2 0 0 1 -2 -2v-12c0 -.55 .222 -1.047 .58 -1.409\" />\n  <path d=\"M4 8h4m4 0h8\" />\n  <path d=\"M20 12h-4m-4 0h-8\" />\n  <path d=\"M4 16h12\" />\n  <path d=\"M9 4v1\" />\n  <path d=\"M14 8v2\" />\n  <path d=\"M8 12v4\" />\n  <path d=\"M11 16v4\" />\n  <path d=\"M3 3l18 18\" />"),
    WINDOW(
        "window",
        "<path d=\"M12 3c-3.866 0 -7 3.272 -7 7v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1 -1v-10c0 -3.728 -3.134 -7 -7 -7\" />\n  <path d=\"M5 13l14 0\" />\n  <path d=\"M12 3l0 18\" />"),
    WINDOW_OFF(
        "window-off",
        "<path d=\"M6.166 6.19a6.903 6.903 0 0 0 -1.166 3.81v10a1 1 0 0 0 1 1h12a1 1 0 0 0 1 -1v-1m0 -4v-5c0 -3.728 -3.134 -7 -7 -7a6.86 6.86 0 0 0 -3.804 1.158\" />\n  <path d=\"M5 13h8m4 0h2\" />\n  <path d=\"M12 3v5m0 4v9\" />\n  <path d=\"M3 3l18 18\" />");

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
    BATH(
        "bath",
        "<path d=\"M11 2a1 1 0 0 1 .993 .883l.007 .117v2.25a1 1 0 0 1 -1.993 .117l-.007 -.117v-1.25h-2a1 1 0 0 0 -.993 .883l-.007 .117v6h13a2 2 0 0 1 1.995 1.85l.005 .15v3c0 1.475 -.638 2.8 -1.654 3.715l.486 .73a1 1 0 0 1 -1.594 1.203l-.07 -.093l-.55 -.823a4.98 4.98 0 0 1 -1.337 .26l-.281 .008h-10a4.994 4.994 0 0 1 -1.619 -.268l-.549 .823a1 1 0 0 1 -1.723 -1.009l.059 -.1l.486 -.73a4.987 4.987 0 0 1 -1.647 -3.457l-.007 -.259v-3a2 2 0 0 1 1.85 -1.995l.15 -.005h1v-6a3 3 0 0 1 2.824 -2.995l.176 -.005h3z\" />"),
    BED_FLAT(
        "bed-flat",
        "<path d=\"M5 8a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />\n  <path d=\"M18 7a4 4 0 0 1 4 4v2a1 1 0 0 1 -1 1h-11a1 1 0 0 1 -1 -1v-5a1 1 0 0 1 1 -1z\" />\n  <path d=\"M21 15a1 1 0 0 1 0 2h-18a1 1 0 0 1 0 -2z\" />"),
    BUILDING_BRIDGE_2(
        "building-bridge-2",
        "<path d=\"M18 6a3 3 0 0 1 3 3v9a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2v-2a3 3 0 0 0 -6 0v2a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2v-9a3 3 0 0 1 3 -3z\" />"),
    BUILDING_BROADCAST_TOWER(
        "building-broadcast-tower",
        "<path d=\"M12 10a2 2 0 0 1 1.497 3.327l2.452 7.357a1 1 0 1 1 -1.898 .632l-.44 -1.316h-3.224l-.438 1.317a1 1 0 0 1 -1.152 .663l-.113 -.03a1 1 0 0 1 -.633 -1.265l2.452 -7.357a2 2 0 0 1 -.503 -1.328l.005 -.15a2 2 0 0 1 1.995 -1.85\" />\n  <path d=\"M18.093 4.078a10 10 0 0 1 3.137 11.776a1 1 0 0 1 -1.846 -.77a8 8 0 1 0 -14.769 0a1 1 0 0 1 -1.846 .77a10 10 0 0 1 15.324 -11.776\" />\n  <path d=\"M15.657 7.243a6 6 0 0 1 1.882 7.066a1 1 0 1 1 -1.846 -.77a4 4 0 1 0 -7.384 0a1 1 0 1 1 -1.846 .77a6 6 0 0 1 9.194 -7.066\" />"),
    FENCE(
        "fence",
        "<path d=\"M19 17v3a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-3z\" />\n  <path d=\"M11 17v3a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-3z\" />\n  <path d=\"M20 12a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-16a1 1 0 0 1 -1 -1v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M8.707 3.293l2 2a1 1 0 0 1 .293 .707v5h-6v-5a1 1 0 0 1 .293 -.707l2 -2a1 1 0 0 1 1.414 0\" />\n  <path d=\"M16.707 3.293l2 2a1 1 0 0 1 .293 .707v5h-6v-5a1 1 0 0 1 .293 -.707l2 -2a1 1 0 0 1 1.414 0\" />"),
    HOME(
        "home",
        "<path d=\"M12.707 2.293l9 9c.63 .63 .184 1.707 -.707 1.707h-1v6a3 3 0 0 1 -3 3h-1v-7a3 3 0 0 0 -2.824 -2.995l-.176 -.005h-2a3 3 0 0 0 -3 3v7h-1a3 3 0 0 1 -3 -3v-6h-1c-.89 0 -1.337 -1.077 -.707 -1.707l9 -9a1 1 0 0 1 1.414 0m.293 11.707a1 1 0 0 1 1 1v7h-4v-7a1 1 0 0 1 .883 -.993l.117 -.007z\" />"),
    HOME_2(
        "home-2",
        "<path d=\"M12.707 2.293l9 9c.63 .63 .184 1.707 -.707 1.707h-1v6a3 3 0 0 1 -3 3h-10a3 3 0 0 1 -3 -3v-6h-1c-.89 0 -1.337 -1.077 -.707 -1.707l9 -9a1 1 0 0 1 1.414 0m.793 8.707h-3a1.5 1.5 0 0 0 -1.5 1.5v3a1.5 1.5 0 0 0 1.5 1.5h3a1.5 1.5 0 0 0 1.5 -1.5v-3a1.5 1.5 0 0 0 -1.5 -1.5\" />");

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

  default TablerIcon armchair() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR);
  }

  default TablerIcon armchair_2() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_2);
  }

  default TablerIcon armchair_2_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_2_OFF);
  }

  default TablerIcon armchair_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_OFF);
  }

  default TablerIcon bath() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BATH);
  }

  default TablerIcon bath_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BATH_OFF);
  }

  default TablerIcon bed_flat() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BED_FLAT);
  }

  default TablerIcon bell_school() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BELL_SCHOOL);
  }

  default TablerIcon building() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING);
  }

  default TablerIcon building_airport() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_AIRPORT);
  }

  default TablerIcon building_arch() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_ARCH);
  }

  default TablerIcon building_bank() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BANK);
  }

  default TablerIcon building_bridge() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BRIDGE);
  }

  default TablerIcon building_bridge_2() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BRIDGE_2);
  }

  default TablerIcon building_broadcast_tower() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BROADCAST_TOWER);
  }

  default TablerIcon building_burj_al_arab() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BURJ_AL_ARAB);
  }

  default TablerIcon building_carousel() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CAROUSEL);
  }

  default TablerIcon building_castle() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CASTLE);
  }

  default TablerIcon building_church() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CHURCH);
  }

  default TablerIcon building_circus() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CIRCUS);
  }

  default TablerIcon building_cog() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COG);
  }

  default TablerIcon building_community() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COMMUNITY);
  }

  default TablerIcon building_cottage() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COTTAGE);
  }

  default TablerIcon building_eiffel_tower() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_EIFFEL_TOWER);
  }

  default TablerIcon building_estate() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_ESTATE);
  }

  default TablerIcon building_factory() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FACTORY);
  }

  default TablerIcon building_factory_2() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FACTORY_2);
  }

  default TablerIcon building_fortress() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FORTRESS);
  }

  default TablerIcon building_hospital() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_HOSPITAL);
  }

  default TablerIcon building_lighthouse() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_LIGHTHOUSE);
  }

  default TablerIcon building_minus() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MINUS);
  }

  default TablerIcon building_monument() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MONUMENT);
  }

  default TablerIcon building_mosque() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MOSQUE);
  }

  default TablerIcon building_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_OFF);
  }

  default TablerIcon building_pavilion() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_PAVILION);
  }

  default TablerIcon building_plus() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_PLUS);
  }

  default TablerIcon building_skyscraper() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_SKYSCRAPER);
  }

  default TablerIcon building_stadium() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_STADIUM);
  }

  default TablerIcon building_store() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_STORE);
  }

  default TablerIcon building_tunnel() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_TUNNEL);
  }

  default TablerIcon building_warehouse() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_WAREHOUSE);
  }

  default TablerIcon building_wind_turbine() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_WIND_TURBINE);
  }

  default TablerIcon buildings() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.BUILDINGS);
  }

  default TablerIcon car_garage() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.CAR_GARAGE);
  }

  default TablerIcon chalkboard_teacher() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.CHALKBOARD_TEACHER);
  }

  default TablerIcon door_hanger() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.DOOR_HANGER);
  }

  default TablerIcon fence() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.FENCE);
  }

  default TablerIcon fence_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.FENCE_OFF);
  }

  default TablerIcon home() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME);
  }

  default TablerIcon home_2() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_2);
  }

  default TablerIcon home_bitcoin() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_BITCOIN);
  }

  default TablerIcon home_bolt() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_BOLT);
  }

  default TablerIcon home_cancel() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_CANCEL);
  }

  default TablerIcon home_check() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_CHECK);
  }

  default TablerIcon home_cog() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_COG);
  }

  default TablerIcon home_dollar() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOLLAR);
  }

  default TablerIcon home_dot() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOT);
  }

  default TablerIcon home_down() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOWN);
  }

  default TablerIcon home_eco() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_ECO);
  }

  default TablerIcon home_edit() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_EDIT);
  }

  default TablerIcon home_exclamation() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_EXCLAMATION);
  }

  default TablerIcon home_hand() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_HAND);
  }

  default TablerIcon home_heart() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_HEART);
  }

  default TablerIcon home_infinity() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_INFINITY);
  }

  default TablerIcon home_link() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_LINK);
  }

  default TablerIcon home_lock() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_LOCK);
  }

  default TablerIcon home_minus() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_MINUS);
  }

  default TablerIcon home_move() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_MOVE);
  }

  default TablerIcon home_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_OFF);
  }

  default TablerIcon home_plus() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_PLUS);
  }

  default TablerIcon home_question() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_QUESTION);
  }

  default TablerIcon home_ribbon() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_RIBBON);
  }

  default TablerIcon home_search() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SEARCH);
  }

  default TablerIcon home_share() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SHARE);
  }

  default TablerIcon home_shield() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SHIELD);
  }

  default TablerIcon home_signal() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SIGNAL);
  }

  default TablerIcon home_spark() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SPARK);
  }

  default TablerIcon home_star() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_STAR);
  }

  default TablerIcon home_stats() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_STATS);
  }

  default TablerIcon home_up() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_UP);
  }

  default TablerIcon home_x() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOME_X);
  }

  default TablerIcon hotel_service() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.HOTEL_SERVICE);
  }

  default TablerIcon mosque() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.MOSQUE);
  }

  default TablerIcon podium() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.PODIUM);
  }

  default TablerIcon podium_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.PODIUM_OFF);
  }

  default TablerIcon rocking_chair() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.ROCKING_CHAIR);
  }

  default TablerIcon school_bell() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.SCHOOL_BELL);
  }

  default TablerIcon smart_home() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.SMART_HOME);
  }

  default TablerIcon smart_home_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.SMART_HOME_OFF);
  }

  default TablerIcon tower() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.TOWER);
  }

  default TablerIcon tower_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.TOWER_OFF);
  }

  default TablerIcon wall() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.WALL);
  }

  default TablerIcon wall_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.WALL_OFF);
  }

  default TablerIcon window() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.WINDOW);
  }

  default TablerIcon window_off() {
    return TablerIcon.create(TablerBuildings.OutlineIcon.WINDOW_OFF);
  }

  default TablerIcon bath_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.BATH);
  }

  default TablerIcon bed_flat_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.BED_FLAT);
  }

  default TablerIcon building_bridge_2_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.BUILDING_BRIDGE_2);
  }

  default TablerIcon building_broadcast_tower_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.BUILDING_BROADCAST_TOWER);
  }

  default TablerIcon fence_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.FENCE);
  }

  default TablerIcon home_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.HOME);
  }

  default TablerIcon home_2_filled() {
    return TablerIcon.create(TablerBuildings.FilledIcon.HOME_2);
  }
}
