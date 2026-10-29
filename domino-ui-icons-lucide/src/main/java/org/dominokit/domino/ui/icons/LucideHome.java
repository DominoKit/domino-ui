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

/** Lucide home catalog category. */
public interface LucideHome {
  enum Icon implements LucideIconDefinition {
    AIR_VENT(
        "air-vent",
        "<path d=\"M18 17.5a2.5 2.5 0 1 1-4 2.03V12\" />\n  <path d=\"M6 12H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M6 8h12\" />\n  <path d=\"M6.6 15.572A2 2 0 1 0 10 17v-5\" />"),
    ALARM_SMOKE(
        "alarm-smoke",
        "<path d=\"M11 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"M16 21c0-2.5 2-2.5 2-5\" />\n  <path d=\"m19 8-.8 3a1.25 1.25 0 0 1-1.2 1H7a1.25 1.25 0 0 1-1.2-1L5 8\" />\n  <path d=\"M21 3a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V4a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 21c0-2.5 2-2.5 2-5\" />"),
    ARMCHAIR(
        "armchair",
        "<path d=\"M19 9V6a2 2 0 0 0-2-2H7a2 2 0 0 0-2 2v3\" />\n  <path d=\"M3 16a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2v-5a2 2 0 0 0-4 0v1.5a.5.5 0 0 1-.5.5h-9a.5.5 0 0 1-.5-.5V11a2 2 0 0 0-4 0z\" />\n  <path d=\"M5 18v2\" />\n  <path d=\"M19 18v2\" />"),
    BED(
        "bed",
        "<path d=\"M2 4v16\" />\n  <path d=\"M2 8h18a2 2 0 0 1 2 2v10\" />\n  <path d=\"M2 17h20\" />\n  <path d=\"M6 8v9\" />"),
    BED_DOUBLE(
        "bed-double",
        "<path d=\"M2 20v-8a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v8\" />\n  <path d=\"M4 10V6a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v4\" />\n  <path d=\"M12 4v6\" />\n  <path d=\"M2 18h20\" />"),
    BED_SINGLE(
        "bed-single",
        "<path d=\"M3 20v-8a2 2 0 0 1 2-2h14a2 2 0 0 1 2 2v8\" />\n  <path d=\"M5 10V6a2 2 0 0 1 2-2h10a2 2 0 0 1 2 2v4\" />\n  <path d=\"M3 18h18\" />"),
    BELL_ELECTRIC(
        "bell-electric",
        "<path d=\"M18.518 17.347A7 7 0 0 1 14 19\" />\n  <path d=\"M18.8 4A11 11 0 0 1 20 9\" />\n  <path d=\"M9 9h.01\" />\n  <circle cx=\"20\" cy=\"16\" r=\"2\" />\n  <circle cx=\"9\" cy=\"9\" r=\"7\" />\n  <rect x=\"4\" y=\"16\" width=\"10\" height=\"6\" rx=\"2\" />"),
    BIRDHOUSE(
        "birdhouse",
        "<path d=\"M12 18v4\" />\n  <path d=\"m17 18 1.956-11.468\" />\n  <path d=\"m3 8 7.82-5.615a2 2 0 0 1 2.36 0L21 8\" />\n  <path d=\"M4 18h16\" />\n  <path d=\"M7 18 5.044 6.532\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    BLENDER(
        "blender",
        "<path d=\"M8 14a2 2 0 0 0-1.963 1.615l-1.018 5.193A1 1 0 0 0 6 22h12a1 1 0 0 0 .981-1.192l-1.018-5.193A2 2 0 0 0 16 14z\" />\n  <path d=\"m17 2-1 12\" />\n  <path d=\"M8.006 14 7 2\" />\n  <path d=\"M7.565 8.787A5 5 0 0 0 12 8a5 5 0 0 1 4.56-.75\" />\n  <path d=\"M19 2H5a2 2 0 0 0-2 2v5a2 2 0 0 0 .688 1.5\" />\n  <path d=\"M12 18h.01\" />"),
    BLINDS(
        "blinds",
        "<path d=\"M3 3h18\" />\n  <path d=\"M20 7H8\" />\n  <path d=\"M20 11H8\" />\n  <path d=\"M10 19h10\" />\n  <path d=\"M8 15h12\" />\n  <path d=\"M4 3v14\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />"),
    BOLT(
        "bolt",
        "<path d=\"M21 16V8a2 2 0 0 0-1-1.73l-7-4a2 2 0 0 0-2 0l-7 4A2 2 0 0 0 3 8v8a2 2 0 0 0 1 1.73l7 4a2 2 0 0 0 2 0l7-4A2 2 0 0 0 21 16z\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    BRICK_WALL(
        "brick-wall",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M16 15v6\" />\n  <path d=\"M16 3v6\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BRICK_WALL_FIRE(
        "brick-wall-fire",
        "<path d=\"M16 3v2.107\" />\n  <path d=\"M17 9c1 3 2.5 3.5 3.5 4.5A5 5 0 0 1 22 17a5 5 0 0 1-10 0c0-.3 0-.6.1-.9a2 2 0 1 0 3.3-2C13 11.5 16 9 17 9\" />\n  <path d=\"M21 8.274V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h3.938\" />\n  <path d=\"M3 15h5.253\" />\n  <path d=\"M3 9h8.228\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BRICK_WALL_SHIELD(
        "brick-wall-shield",
        "<path d=\"M12 9v1.258\" />\n  <path d=\"M16 3v5.46\" />\n  <path d=\"M21 9.118V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v14a2 2 0 0 0 2 2h5.75\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <path d=\"M3 15h7\" />\n  <path d=\"M3 9h12.142\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BROOM(
        "broom",
        "<path d=\"M13.5 10.5 22 2\" />\n  <path d=\"M14.734 13.841a2 2 0 00-.314-2.42L12.58 9.58a2 2 0 00-2.421-.314l-7.657 4.461A1 1 0 002.3 15.3l6.403 6.403a1 1 0 001.571-.204z\" />\n  <path d=\"m5 18 2-2\" />\n  <path d=\"m7.699 10.7 5.602 5.601\" />"),
    BROOM_SPARKLES(
        "broom-sparkles",
        "<path d=\"M11 2v2\" />\n  <path d=\"M12 3h-2\" />\n  <path d=\"M13.5 10.5 22 2\" />\n  <path d=\"M14.734 13.841a2 2 0 00-.314-2.42L12.58 9.58a2 2 0 00-2.421-.314l-7.657 4.461A1 1 0 002.3 15.3l6.403 6.403a1 1 0 001.571-.204z\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 4v4\" />\n  <path d=\"m5 18 2-2\" />\n  <path d=\"M6 6H2\" />\n  <path d=\"m7.699 10.7 5.602 5.601\" />"),
    BRUSH_CLEANING(
        "brush-cleaning",
        "<path d=\"m16 22-1-4\" />\n  <path d=\"M19 14a1 1 0 0 0 1-1v-1a2 2 0 0 0-2-2h-3a1 1 0 0 1-1-1V4a2 2 0 0 0-4 0v5a1 1 0 0 1-1 1H6a2 2 0 0 0-2 2v1a1 1 0 0 0 1 1\" />\n  <path d=\"M19 14H5l-1.973 6.767A1 1 0 0 0 4 22h16a1 1 0 0 0 .973-1.233z\" />\n  <path d=\"m8 22 1-4\" />"),
    COOKING_POT(
        "cooking-pot",
        "<path d=\"M2 12h20\" />\n  <path d=\"M20 12v8a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-8\" />\n  <path d=\"m4 8 16-4\" />\n  <path d=\"m8.86 6.78-.45-1.81a2 2 0 0 1 1.45-2.43l1.94-.48a2 2 0 0 1 2.43 1.46l.45 1.8\" />"),
    DOOR_CLOSED(
        "door-closed",
        "<path d=\"M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 12h.01\" />"),
    DOOR_CLOSED_COG(
        "door-closed-cog",
        "<path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.773-.383.924\" />\n  <path d=\"M19 10.35V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.697-.382-.924\" />\n  <path d=\"M2 21h8.58\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <path d=\"M9 12h.01\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    DOOR_CLOSED_LOCKED(
        "door-closed-locked",
        "<path d=\"M19 8V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M20 16v-2a2 2 0 00-4 0v2\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"16\" width=\"8\" height=\"5\" rx=\"1\" />"),
    DOOR_CLOSED_PACKAGE(
        "door-closed-package",
        "<path d=\"M18 13v3\" />\n  <path d=\"M19 9V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"13\" width=\"8\" height=\"8\" rx=\"1\" />"),
    DOOR_OPEN(
        "door-open",
        "<path d=\"M10 21H2\" />\n  <path d=\"M10 3H7a2 2 0 00-2 2v16\" />\n  <path d=\"M14 12h.01\" />\n  <path d=\"M19 21V5a2 2 0 00-1.675-1.974l-6.163-1.013A1 1 0 0010 3v18a1 1 0 001.124.992z\" />\n  <path d=\"M22 21h-3\" />"),
    DOOR_STAIRWELL(
        "door-stairwell",
        "<path d=\"M12 17v-3a1 1 0 011-1h6\" />\n  <path d=\"M19 17h-9a1 1 0 00-1 1v3\" />\n  <path d=\"M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M19 9h-3a1 1 0 00-1 1v3\" />\n  <path d=\"M22 21H2\" />"),
    DRILL(
        "drill",
        "<path d=\"M10 18a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H5a3 3 0 0 1-3-3 1 1 0 0 1 1-1z\" />\n  <path d=\"M13 10H4a2 2 0 0 1-2-2V4a2 2 0 0 1 2-2h9a1 1 0 0 1 1 1v6a1 1 0 0 1-1 1l-.81 3.242a1 1 0 0 1-.97.758H8\" />\n  <path d=\"M14 4h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M18 6h4\" />\n  <path d=\"m5 10-2 8\" />\n  <path d=\"m7 18 2-8\" />"),
    FAN(
        "fan",
        "<path d=\"M10.827 16.379a6.082 6.082 0 0 1-8.618-7.002l5.412 1.45a6.082 6.082 0 0 1 7.002-8.618l-1.45 5.412a6.082 6.082 0 0 1 8.618 7.002l-5.412-1.45a6.082 6.082 0 0 1-7.002 8.618l1.45-5.412Z\" />\n  <path d=\"M12 12v.01\" />"),
    FAUCET(
        "faucet",
        "<path d=\"M10.083 5.428 5.57 4.083a2 2 0 10.001 3.834l4.512-1.345\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"m13.917 5.428 4.511-1.345a2 2 0 110 3.834l-4.51-1.345\" />\n  <path d=\"M18 17v-4.006\" />\n  <path d=\"M22 11v8\" />\n  <path d=\"M22 12h-3a1 1 0 00-1 .994h-2.539a4 4 0 00-6.915-.012L7 13a5 5 0 00-5 5v1a1 1 0 001 1h2a1 1 0 001-1v-1a1 1 0 01.995-1l1.552.018a4 4 0 006.907 0L18 17a1 1 0 001 1h3\" />\n  <circle cx=\"12\" cy=\"6\" r=\"2\" />"),
    FENCE(
        "fence",
        "<path d=\"M4 3 2 5v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />\n  <path d=\"M6 8h4\" />\n  <path d=\"M6 18h4\" />\n  <path d=\"m12 3-2 2v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />\n  <path d=\"M14 8h4\" />\n  <path d=\"M14 18h4\" />\n  <path d=\"m20 3-2 2v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />"),
    FIRE_EXTINGUISHER(
        "fire-extinguisher",
        "<path d=\"M15 6.5V3a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3.5\" />\n  <path d=\"M9 18h8\" />\n  <path d=\"M18 3h-3\" />\n  <path d=\"M11 3a6 6 0 0 0-6 6v11\" />\n  <path d=\"M5 13h4\" />\n  <path d=\"M17 10a4 4 0 0 0-8 0v10a2 2 0 0 0 2 2h4a2 2 0 0 0 2-2Z\" />"),
    HAMMER(
        "hammer",
        "<path d=\"m15 12-9.373 9.373a1 1 0 0 1-3.001-3L12 9\" />\n  <path d=\"m18 15 4-4\" />\n  <path d=\"m21.5 11.5-1.914-1.914A2 2 0 0 1 19 8.172v-.344a2 2 0 0 0-.586-1.414l-1.657-1.657A6 6 0 0 0 12.516 3H9l1.243 1.243A6 6 0 0 1 12 8.485V10l2 2h1.172a2 2 0 0 1 1.414.586L18.5 14.5\" />"),
    HEATER(
        "heater",
        "<path d=\"M11 8c2-3-2-3 0-6\" />\n  <path d=\"M15.5 8c2-3-2-3 0-6\" />\n  <path d=\"M6 10h.01\" />\n  <path d=\"M6 14h.01\" />\n  <path d=\"M10 16v-4\" />\n  <path d=\"M14 16v-4\" />\n  <path d=\"M18 16v-4\" />\n  <path d=\"M20 6a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h3\" />\n  <path d=\"M5 20v2\" />\n  <path d=\"M19 20v2\" />"),
    HOUSE(
        "house",
        "<path d=\"M15 21v-8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v8\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    HOUSE_COG(
        "house-cog",
        "<path d=\"M10.584 21H5a2 2 0 01-2-2v-9a2 2 0 01.709-1.527l7-6a2 2 0 012.582 0l7 6A2 2 0 0121 10.001v.583\" />\n  <path d=\"M14 12H10a1 1 0 00-1 1v8\" />\n  <path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.773-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.697-.382-.924\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    HOUSE_HEART(
        "house-heart",
        "<path d=\"M8.62 13.8A2.25 2.25 0 1 1 12 10.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a.998.998 0 0 1-1.507 0z\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    HOUSE_PLUG(
        "house-plug",
        "<path d=\"M10 12V8.964\" />\n  <path d=\"M14 12V8.964\" />\n  <path d=\"M15 12a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2h-4a2 2 0 0 1-2-2v-2a1 1 0 0 1 1-1z\" />\n  <path d=\"M8.5 21H5a2 2 0 0 1-2-2v-9a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2h-5a2 2 0 0 1-2-2v-2\" />"),
    HOUSE_WIFI(
        "house-wifi",
        "<path d=\"M9.5 13.866a4 4 0 0 1 5 .01\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />\n  <path d=\"M7 10.754a8 8 0 0 1 10 0\" />"),
    HOUSES(
        "houses",
        "<path d=\"m12.681 4.24.834-.715a1.45 1.45 0 011.88 0l5.09 4.364A1.45 1.45 0 0121 9v6.546a1.45 1.45 0 01-1 1.381\" />\n  <path d=\"M15.485 11.889A1.45 1.45 0 0116 13v6.546A1.454 1.454 0 0114.546 21H4.364a1.454 1.454 0 01-1.454-1.454V13a1.45 1.45 0 01.515-1.111l5.09-4.364a1.45 1.45 0 011.88 0z\" />\n  <path d=\"M7.41 20.546v-4a1 1 0 011-1h2a1 1 0 011 1v4\" />"),
    LAMP(
        "lamp",
        "<path d=\"M12 12v6\" />\n  <path d=\"M4.077 10.615A1 1 0 0 0 5 12h14a1 1 0 0 0 .923-1.385l-3.077-7.384A2 2 0 0 0 15 2H9a2 2 0 0 0-1.846 1.23Z\" />\n  <path d=\"M8 20a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H9a1 1 0 0 1-1-1z\" />"),
    LAMP_CEILING(
        "lamp-ceiling",
        "<path d=\"M12 2v5\" />\n  <path d=\"M14.829 15.998a3 3 0 1 1-5.658 0\" />\n  <path d=\"M20.92 14.606A1 1 0 0 1 20 16H4a1 1 0 0 1-.92-1.394l3-7A1 1 0 0 1 7 7h10a1 1 0 0 1 .92.606z\" />"),
    LAMP_DESK(
        "lamp-desk",
        "<path d=\"M10.293 2.293a1 1 0 0 1 1.414 0l2.5 2.5 5.994 1.227a1 1 0 0 1 .506 1.687l-7 7a1 1 0 0 1-1.687-.506l-1.227-5.994-2.5-2.5a1 1 0 0 1 0-1.414z\" />\n  <path d=\"m14.207 4.793-3.414 3.414\" />\n  <path d=\"M3 20a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v1a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1z\" />\n  <path d=\"m9.086 6.5-4.793 4.793a1 1 0 0 0-.18 1.17L7 18\" />"),
    LAMP_FLOOR(
        "lamp-floor",
        "<path d=\"M12 10v12\" />\n  <path d=\"M17.929 7.629A1 1 0 0 1 17 9H7a1 1 0 0 1-.928-1.371l2-5A1 1 0 0 1 9 2h6a1 1 0 0 1 .928.629z\" />\n  <path d=\"M9 22h6\" />"),
    LAMP_WALL_DOWN(
        "lamp-wall-down",
        "<path d=\"M19.929 18.629A1 1 0 0 1 19 20H9a1 1 0 0 1-.928-1.371l2-5A1 1 0 0 1 11 13h6a1 1 0 0 1 .928.629z\" />\n  <path d=\"M6 3a2 2 0 0 1 2 2v2a2 2 0 0 1-2 2H5a1 1 0 0 1-1-1V4a1 1 0 0 1 1-1z\" />\n  <path d=\"M8 6h4a2 2 0 0 1 2 2v5\" />"),
    LAMP_WALL_UP(
        "lamp-wall-up",
        "<path d=\"M19.929 9.629A1 1 0 0 1 19 11H9a1 1 0 0 1-.928-1.371l2-5A1 1 0 0 1 11 4h6a1 1 0 0 1 .928.629z\" />\n  <path d=\"M6 15a2 2 0 0 1 2 2v2a2 2 0 0 1-2 2H5a1 1 0 0 1-1-1v-4a1 1 0 0 1 1-1z\" />\n  <path d=\"M8 18h4a2 2 0 0 0 2-2v-5\" />"),
    MICROWAVE(
        "microwave",
        "<rect width=\"20\" height=\"15\" x=\"2\" y=\"4\" rx=\"2\" />\n  <rect width=\"8\" height=\"7\" x=\"6\" y=\"8\" rx=\"1\" />\n  <path d=\"M18 8v7\" />\n  <path d=\"M6 19v2\" />\n  <path d=\"M18 19v2\" />"),
    MIRROR_RECTANGULAR(
        "mirror-rectangular",
        "<path d=\"M11 6 8 9\" />\n  <path d=\"m16 7-8 8\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    MIRROR_ROUND(
        "mirror-round",
        "<path d=\"M10 6.6 8.6 8\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"M15 7.5 9.5 13\" />\n  <path d=\"M7 22h10\" />\n  <circle cx=\"12\" cy=\"10\" r=\"8\" />"),
    MOP(
        "mop",
        "<path d=\"M10 22c2.761 0 5-1.79 5-4-4.42 0-4.08-5-8.5-5a1 1 0 100 9za3 3 0 01-3-3\" />\n  <path d=\"M12.5 11.5 22 2\" />\n  <path d=\"m6.98 13.02 2.665-2.664a1.21 1.21 0 011.71 0l2.29 2.288a1.21 1.21 0 010 1.712l-2.088 2.087\" />"),
    MOP_SPARKLES(
        "mop-sparkles",
        "<path d=\"M10 22a3 3 0 01-3-3\" />\n  <path d=\"M10 22c2.761 0 5-1.79 5-4-4.42 0-4.08-5-8.5-5a4.501 4.501 0 000 9z\" />\n  <path d=\"M10 3H8\" />\n  <path d=\"M12.5 11.5 22 2\" />\n  <path d=\"M20 13v4\" />\n  <path d=\"M22 15h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"m6.98 13.02 2.665-2.664a1.21 1.21 0 011.71 0l2.29 2.288a1.21 1.21 0 010 1.712l-2.088 2.087\" />\n  <path d=\"M9 2v2\" />"),
    PAINT_ROLLER(
        "paint-roller",
        "<rect width=\"16\" height=\"6\" x=\"2\" y=\"2\" rx=\"2\" />\n  <path d=\"M10 16v-2a2 2 0 0 1 2-2h8a2 2 0 0 0 2-2V7a2 2 0 0 0-2-2h-2\" />\n  <rect width=\"4\" height=\"6\" x=\"8\" y=\"16\" rx=\"1\" />"),
    PAINTBRUSH(
        "paintbrush",
        "<path d=\"m14.622 17.897-10.68-2.913\" />\n  <path d=\"M18.376 2.622a1 1 0 1 1 3.002 3.002L17.36 9.643a.5.5 0 0 0 0 .707l.944.944a2.41 2.41 0 0 1 0 3.408l-.944.944a.5.5 0 0 1-.707 0L8.354 7.348a.5.5 0 0 1 0-.707l.944-.944a2.41 2.41 0 0 1 3.408 0l.944.944a.5.5 0 0 0 .707 0z\" />\n  <path d=\"M9 8c-1.804 2.71-3.97 3.46-6.583 3.948a.507.507 0 0 0-.302.819l7.32 8.883a1 1 0 0 0 1.185.204C12.735 20.405 16 16.792 16 15\" />"),
    PAINTBRUSH_VERTICAL(
        "paintbrush-vertical",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v4\" />\n  <path d=\"M17 2a1 1 0 0 1 1 1v9H6V3a1 1 0 0 1 1-1z\" />\n  <path d=\"M6 12a1 1 0 0 0-1 1v1a2 2 0 0 0 2 2h2a1 1 0 0 1 1 1v2.9a2 2 0 1 0 4 0V17a1 1 0 0 1 1-1h2a2 2 0 0 0 2-2v-1a1 1 0 0 0-1-1\" />"),
    PLANT_POT(
        "plant-pot",
        "<path d=\"M14 8.536V6a4 4 0 014-4h1.5a.5.5 0 01.5.5V4a4 4 0 01-4 4 4 4 0 00-4 4 5 5 0 01-8-4 5 5 0 018 4c0 2 1 3 1 5\" />\n  <path d=\"m18 17-1.085 3.58A2 2 0 0115 22H9.002a2 2 0 01-1.913-1.418L6 17\" />\n  <path d=\"M5 17h14\" />"),
    REFRIGERATOR(
        "refrigerator",
        "<path d=\"M5 6a4 4 0 0 1 4-4h6a4 4 0 0 1 4 4v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6Z\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M15 7v6\" />"),
    ROBOT_VACUUM(
        "robot-vacuum",
        "<path d=\"M11 17h2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M17 12a5 5 0 00-10 0\" />\n  <path d=\"M19 2v2.8\" />\n  <path d=\"M2 5h2.8\" />\n  <path d=\"M22 5h-2.8\" />\n  <path d=\"M5 2v2.8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    ROCKING_CHAIR(
        "rocking-chair",
        "<path d=\"m15 13 3.708 7.416\" />\n  <path d=\"M3 19a15 15 0 0 0 18 0\" />\n  <path d=\"m3 2 3.21 9.633A2 2 0 0 0 8.109 13H18\" />\n  <path d=\"m9 13-3.708 7.416\" />"),
    ROSE(
        "rose",
        "<path d=\"M17 10h-1a4 4 0 1 1 4-4v.534\" />\n  <path d=\"M17 6h1a4 4 0 0 1 1.42 7.74l-2.29.87a6 6 0 0 1-5.339-10.68l2.069-1.31\" />\n  <path d=\"M4.5 17c2.8-.5 4.4 0 5.5.8s1.8 2.2 2.3 3.7c-2 .4-3.5.4-4.8-.3-1.2-.6-2.3-1.9-3-4.2\" />\n  <path d=\"M9.77 12C4 15 2 22 2 22\" />\n  <circle cx=\"17\" cy=\"8\" r=\"2\" />"),
    ROUTER(
        "router",
        "<rect width=\"20\" height=\"8\" x=\"2\" y=\"14\" rx=\"2\" />\n  <path d=\"M6.01 18H6\" />\n  <path d=\"M10.01 18H10\" />\n  <path d=\"M15 10v4\" />\n  <path d=\"M17.84 7.17a4 4 0 0 0-5.66 0\" />\n  <path d=\"M20.66 4.34a8 8 0 0 0-11.31 0\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHELVING_UNIT(
        "shelving-unit",
        "<path d=\"M12 12V9a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3\" />\n  <path d=\"M16 20v-3a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 22V2\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M4 20h16\" />\n  <path d=\"M4 2v20\" />\n  <path d=\"M4 4h16\" />"),
    SHIELD_HOUSE(
        "shield-house",
        "<path d=\"M15 22a1 1 0 01-1-1v-4a1 1 0 01.445-.832l3-2a1 1 0 011.11 0l3 2A1 1 0 0122 17v4a1 1 0 01-1 1z\" />\n  <path d=\"M18 22v-3\" />\n  <path d=\"M20 10.418V6a1 1 0 00-1-1c-2 0-4.49-1.19-6.24-2.72a1.17 1.17 0 00-1.52 0C9.5 3.8 7 5 5 5a1 1 0 00-1 1v7c0 4.602 2.67 7.1 6.037 8.603\" />"),
    SHOWER_HEAD(
        "shower-head",
        "<path d=\"m4 4 2.5 2.5\" />\n  <path d=\"M13.5 6.5a4.95 4.95 0 0 0-7 7\" />\n  <path d=\"M15 5 5 15\" />\n  <path d=\"M14 17v.01\" />\n  <path d=\"M10 16v.01\" />\n  <path d=\"M13 13v.01\" />\n  <path d=\"M16 10v.01\" />\n  <path d=\"M11 20v.01\" />\n  <path d=\"M17 14v.01\" />\n  <path d=\"M20 11v.01\" />"),
    SOAP_DISPENSER_DROPLET(
        "soap-dispenser-droplet",
        "<path d=\"M10.5 2v4\" />\n  <path d=\"M14 2H7a2 2 0 0 0-2 2\" />\n  <path d=\"M19.29 14.76A6.67 6.67 0 0 1 17 11a6.6 6.6 0 0 1-2.29 3.76c-1.15.92-1.71 2.04-1.71 3.19 0 2.22 1.8 4.05 4 4.05s4-1.83 4-4.05c0-1.16-.57-2.26-1.71-3.19\" />\n  <path d=\"M9.607 21H6a2 2 0 0 1-2-2v-7a2 2 0 0 1 2-2h7V7a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3\" />"),
    SOFA(
        "sofa",
        "<path d=\"M20 9V6a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v3\" />\n  <path d=\"M2 16a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-5a2 2 0 0 0-4 0v1.5a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5V11a2 2 0 0 0-4 0z\" />\n  <path d=\"M4 18v2\" />\n  <path d=\"M20 18v2\" />\n  <path d=\"M12 4v9\" />"),
    SOLAR_PANEL(
        "solar-panel",
        "<path d=\"M11 2h2\" />\n  <path d=\"m14.28 14-4.56 8\" />\n  <path d=\"m21 22-1.558-4H4.558\" />\n  <path d=\"M3 10v2\" />\n  <path d=\"M6.245 15.04A2 2 0 0 1 8 14h12a1 1 0 0 1 .864 1.505l-3.11 5.457A2 2 0 0 1 16 22H4a1 1 0 0 1-.863-1.506z\" />\n  <path d=\"M7 2a4 4 0 0 1-4 4\" />\n  <path d=\"m8.66 7.66 1.41 1.41\" />"),
    SWATCH_BOOK(
        "swatch-book",
        "<path d=\"M11 17a4 4 0 0 1-8 0V5a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2Z\" />\n  <path d=\"M16.7 13H19a2 2 0 0 1 2 2v4a2 2 0 0 1-2 2H7\" />\n  <path d=\"M 7 17h.01\" />\n  <path d=\"m11 8 2.3-2.3a2.4 2.4 0 0 1 3.404.004L18.6 7.6a2.4 2.4 0 0 1 .026 3.434L9.9 19.8\" />"),
    TOILET(
        "toilet",
        "<path d=\"M7 12h13a1 1 0 0 1 1 1 5 5 0 0 1-5 5h-.598a.5.5 0 0 0-.424.765l1.544 2.47a.5.5 0 0 1-.424.765H5.402a.5.5 0 0 1-.424-.765L7 18\" />\n  <path d=\"M8 18a5 5 0 0 1-5-5V4a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v8\" />"),
    TOOL_CASE(
        "tool-case",
        "<path d=\"M10 15h4\" />\n  <path d=\"m14.5 4.058.571-1.429a1 1 0 011.3-.558l5 2a1 1 0 01.549.534.88.88 0 01.01.765l-2.332 5.83\" />\n  <path d=\"M15.634 11a2 2 0 00-.186-.34l-1.17-1.757 1.31-1.656a2 2 0 00-2.109-3.165l-2.032.57-1.17-1.758a2 2 0 00-3.664 1.028l-.086 2.11-2.032.568a2 2 0 00-.155 3.8l1.617.6\" />\n  <path d=\"M4 12.006A1 1 0 014.994 11H19a1 1 0 011 1v7a2 2 0 01-2 2H6a2 2 0 01-2-2z\" />"),
    TOOLBOX(
        "toolbox",
        "<path d=\"M16 12v4\" />\n  <path d=\"M16 6V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v2\" />\n  <path d=\"M17 6a2 2 0 011.414.586l3 3A2 2 0 0122 11v8a2 2 0 01-2 2H4a2 2 0 01-2-2v-8a2 2 0 01.586-1.414l3-3A2 2 0 017 6z\" />\n  <path d=\"M2 14h20\" />\n  <path d=\"M8 12v4\" />"),
    TOOTHBRUSH(
        "toothbrush",
        "<path d=\"M15 11c-2 2-4 2-6 4l-7 7\" />\n  <path d=\"m22 4-7.414 7.414-2-2A2 2 0 0114 6c0-.512.196-1.024.586-1.414A2 2 0 0116 4a2 2 0 013.262-1.552l2.152 2.138\" />"),
    TOOTHBRUSH_SPARKLES(
        "toothbrush-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"M14.586 11.414 22 4\" />\n  <path d=\"M15 11a8 8 0 01-.429.4\" />\n  <path d=\"m2 22 7-7c1.857-1.857 3.714-1.99 5.571-3.6l-1.985-1.986A2 2 0 0114 6a2 2 0 012-2 2 2 0 013.262-1.552l2.152 2.138\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    TOWEL_RACK(
        "towel-rack",
        "<path d=\"M22 7h-2\" />\n  <path d=\"M6.5 3h11A2.5 2.5 0 0 1 20 5.5V20a1 1 0 0 1-1 1h-9a1 1 0 0 1-1-1V5.5a1 1 0 0 0-5 0V17a1 1 0 0 0 1 1h4\" />\n  <path d=\"M9 7H2\" />"),
    TUBE_LOTION(
        "tube-lotion",
        "<path d=\"M15 18v3a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-3\" />\n  <path d=\"M17 2a2 2 0 0 1 1.6 3.2A8 8 0 0 0 17 10v6a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2v-6a8 8 0 0 0-1.6-4.8A2 2 0 0 1 7 2z\" />\n  <path d=\"M7 10a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />"),
    TURNTABLE(
        "turntable",
        "<path d=\"M10 12.01h.01\" />\n  <path d=\"M18 8v4a8 8 0 0 1-1.07 4\" />\n  <circle cx=\"10\" cy=\"12\" r=\"4\" />\n  <rect x=\"2\" y=\"4\" width=\"20\" height=\"16\" rx=\"2\" />"),
    USB(
        "usb",
        "<circle cx=\"10\" cy=\"7\" r=\"1\" />\n  <circle cx=\"4\" cy=\"20\" r=\"1\" />\n  <path d=\"M4.7 19.3 19 5\" />\n  <path d=\"m21 3-3 1 2 2Z\" />\n  <path d=\"M9.26 7.68 5 12l2 5\" />\n  <path d=\"m10 14 5 2 3.5-3.5\" />\n  <path d=\"m18 12 1-1 1 1-1 1Z\" />"),
    USB_C_PORT(
        "usb-c-port",
        "<path d=\"M6 12h12\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"8\" rx=\"4\" />"),
    UTILITY_POLE(
        "utility-pole",
        "<path d=\"M12 2v20\" />\n  <path d=\"M2 5h20\" />\n  <path d=\"M3 3v2\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M17 3v2\" />\n  <path d=\"M21 3v2\" />\n  <path d=\"m19 5-7 7-7-7\" />"),
    VAULT(
        "vault",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <circle cx=\"7.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 7.9 2.7 2.7\" />\n  <circle cx=\"16.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 10.6 2.7-2.7\" />\n  <circle cx=\"7.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m7.9 16.1 2.7-2.7\" />\n  <circle cx=\"16.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"m13.4 13.4 2.7 2.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    WASHING_MACHINE(
        "washing-machine",
        "<path d=\"M3 6h3\" />\n  <path d=\"M17 6h.01\" />\n  <rect width=\"18\" height=\"20\" x=\"3\" y=\"2\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"13\" r=\"5\" />\n  <path d=\"M12 18a2.5 2.5 0 0 0 0-5 2.5 2.5 0 0 1 0-5\" />"),
    WAVES_LADDER(
        "waves-ladder",
        "<path d=\"M19 5a2 2 0 0 0-2 2v11\" />\n  <path d=\"M2 18c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M7 13h10\" />\n  <path d=\"M7 9h10\" />\n  <path d=\"M9 5a2 2 0 0 0-2 2v11\" />");

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
  default LucideIcon air_vent() {
    return LucideIcon.create(Icon.AIR_VENT);
  }

  default LucideIcon alarm_smoke_home() {
    return LucideIcon.create(Icon.ALARM_SMOKE);
  }

  default LucideIcon armchair() {
    return LucideIcon.create(Icon.ARMCHAIR);
  }

  default LucideIcon bed() {
    return LucideIcon.create(Icon.BED);
  }

  default LucideIcon bed_double() {
    return LucideIcon.create(Icon.BED_DOUBLE);
  }

  default LucideIcon bed_single() {
    return LucideIcon.create(Icon.BED_SINGLE);
  }

  default LucideIcon bell_electric_home() {
    return LucideIcon.create(Icon.BELL_ELECTRIC);
  }

  default LucideIcon birdhouse_home() {
    return LucideIcon.create(Icon.BIRDHOUSE);
  }

  default LucideIcon blender() {
    return LucideIcon.create(Icon.BLENDER);
  }

  default LucideIcon blinds() {
    return LucideIcon.create(Icon.BLINDS);
  }

  default LucideIcon bolt_home() {
    return LucideIcon.create(Icon.BOLT);
  }

  default LucideIcon brick_wall_home() {
    return LucideIcon.create(Icon.BRICK_WALL);
  }

  default LucideIcon brick_wall_fire_home() {
    return LucideIcon.create(Icon.BRICK_WALL_FIRE);
  }

  default LucideIcon brick_wall_shield_home() {
    return LucideIcon.create(Icon.BRICK_WALL_SHIELD);
  }

  default LucideIcon broom_home() {
    return LucideIcon.create(Icon.BROOM);
  }

  default LucideIcon broom_sparkles_home() {
    return LucideIcon.create(Icon.BROOM_SPARKLES);
  }

  default LucideIcon brush_cleaning_home() {
    return LucideIcon.create(Icon.BRUSH_CLEANING);
  }

  default LucideIcon cooking_pot() {
    return LucideIcon.create(Icon.COOKING_POT);
  }

  default LucideIcon door_closed_home() {
    return LucideIcon.create(Icon.DOOR_CLOSED);
  }

  default LucideIcon door_closed_cog_home() {
    return LucideIcon.create(Icon.DOOR_CLOSED_COG);
  }

  default LucideIcon door_closed_locked_home() {
    return LucideIcon.create(Icon.DOOR_CLOSED_LOCKED);
  }

  default LucideIcon door_closed_package_home() {
    return LucideIcon.create(Icon.DOOR_CLOSED_PACKAGE);
  }

  default LucideIcon door_open_home() {
    return LucideIcon.create(Icon.DOOR_OPEN);
  }

  default LucideIcon door_stairwell_home() {
    return LucideIcon.create(Icon.DOOR_STAIRWELL);
  }

  default LucideIcon drill_home() {
    return LucideIcon.create(Icon.DRILL);
  }

  default LucideIcon fan() {
    return LucideIcon.create(Icon.FAN);
  }

  default LucideIcon faucet_home() {
    return LucideIcon.create(Icon.FAUCET);
  }

  default LucideIcon fence_home() {
    return LucideIcon.create(Icon.FENCE);
  }

  default LucideIcon fire_extinguisher_home() {
    return LucideIcon.create(Icon.FIRE_EXTINGUISHER);
  }

  default LucideIcon hammer_home() {
    return LucideIcon.create(Icon.HAMMER);
  }

  default LucideIcon heater_home() {
    return LucideIcon.create(Icon.HEATER);
  }

  default LucideIcon house_home() {
    return LucideIcon.create(Icon.HOUSE);
  }

  default LucideIcon house_cog_home() {
    return LucideIcon.create(Icon.HOUSE_COG);
  }

  default LucideIcon house_heart_home() {
    return LucideIcon.create(Icon.HOUSE_HEART);
  }

  default LucideIcon house_plug_home() {
    return LucideIcon.create(Icon.HOUSE_PLUG);
  }

  default LucideIcon house_wifi_home() {
    return LucideIcon.create(Icon.HOUSE_WIFI);
  }

  default LucideIcon houses_home() {
    return LucideIcon.create(Icon.HOUSES);
  }

  default LucideIcon lamp() {
    return LucideIcon.create(Icon.LAMP);
  }

  default LucideIcon lamp_ceiling() {
    return LucideIcon.create(Icon.LAMP_CEILING);
  }

  default LucideIcon lamp_desk() {
    return LucideIcon.create(Icon.LAMP_DESK);
  }

  default LucideIcon lamp_floor() {
    return LucideIcon.create(Icon.LAMP_FLOOR);
  }

  default LucideIcon lamp_wall_down() {
    return LucideIcon.create(Icon.LAMP_WALL_DOWN);
  }

  default LucideIcon lamp_wall_up() {
    return LucideIcon.create(Icon.LAMP_WALL_UP);
  }

  default LucideIcon microwave() {
    return LucideIcon.create(Icon.MICROWAVE);
  }

  default LucideIcon mirror_rectangular_home() {
    return LucideIcon.create(Icon.MIRROR_RECTANGULAR);
  }

  default LucideIcon mirror_round_home() {
    return LucideIcon.create(Icon.MIRROR_ROUND);
  }

  default LucideIcon mop_home() {
    return LucideIcon.create(Icon.MOP);
  }

  default LucideIcon mop_sparkles_home() {
    return LucideIcon.create(Icon.MOP_SPARKLES);
  }

  default LucideIcon paint_roller_home() {
    return LucideIcon.create(Icon.PAINT_ROLLER);
  }

  default LucideIcon paintbrush_home() {
    return LucideIcon.create(Icon.PAINTBRUSH);
  }

  default LucideIcon paintbrush_vertical_home() {
    return LucideIcon.create(Icon.PAINTBRUSH_VERTICAL);
  }

  default LucideIcon plant_pot_home() {
    return LucideIcon.create(Icon.PLANT_POT);
  }

  default LucideIcon refrigerator() {
    return LucideIcon.create(Icon.REFRIGERATOR);
  }

  default LucideIcon robot_vacuum_home() {
    return LucideIcon.create(Icon.ROBOT_VACUUM);
  }

  default LucideIcon rocking_chair() {
    return LucideIcon.create(Icon.ROCKING_CHAIR);
  }

  default LucideIcon rose_home() {
    return LucideIcon.create(Icon.ROSE);
  }

  default LucideIcon router_home() {
    return LucideIcon.create(Icon.ROUTER);
  }

  default LucideIcon shell_home() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon shelving_unit() {
    return LucideIcon.create(Icon.SHELVING_UNIT);
  }

  default LucideIcon shield_house_home() {
    return LucideIcon.create(Icon.SHIELD_HOUSE);
  }

  default LucideIcon shower_head_home() {
    return LucideIcon.create(Icon.SHOWER_HEAD);
  }

  default LucideIcon soap_dispenser_droplet_home() {
    return LucideIcon.create(Icon.SOAP_DISPENSER_DROPLET);
  }

  default LucideIcon sofa() {
    return LucideIcon.create(Icon.SOFA);
  }

  default LucideIcon solar_panel_home() {
    return LucideIcon.create(Icon.SOLAR_PANEL);
  }

  default LucideIcon swatch_book_home() {
    return LucideIcon.create(Icon.SWATCH_BOOK);
  }

  default LucideIcon toilet_home() {
    return LucideIcon.create(Icon.TOILET);
  }

  default LucideIcon tool_case_home() {
    return LucideIcon.create(Icon.TOOL_CASE);
  }

  default LucideIcon toolbox_home() {
    return LucideIcon.create(Icon.TOOLBOX);
  }

  default LucideIcon toothbrush_home() {
    return LucideIcon.create(Icon.TOOTHBRUSH);
  }

  default LucideIcon toothbrush_sparkles_home() {
    return LucideIcon.create(Icon.TOOTHBRUSH_SPARKLES);
  }

  default LucideIcon towel_rack_home() {
    return LucideIcon.create(Icon.TOWEL_RACK);
  }

  default LucideIcon tube_lotion_home() {
    return LucideIcon.create(Icon.TUBE_LOTION);
  }

  default LucideIcon turntable_home() {
    return LucideIcon.create(Icon.TURNTABLE);
  }

  default LucideIcon usb_home() {
    return LucideIcon.create(Icon.USB);
  }

  default LucideIcon usb_c_port_home() {
    return LucideIcon.create(Icon.USB_C_PORT);
  }

  default LucideIcon utility_pole_home() {
    return LucideIcon.create(Icon.UTILITY_POLE);
  }

  default LucideIcon vault_home() {
    return LucideIcon.create(Icon.VAULT);
  }

  default LucideIcon washing_machine_home() {
    return LucideIcon.create(Icon.WASHING_MACHINE);
  }

  default LucideIcon waves_ladder_home() {
    return LucideIcon.create(Icon.WAVES_LADDER);
  }
}
