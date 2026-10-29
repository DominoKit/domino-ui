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

/** Lucide transportation catalog category. */
public interface LucideTransportation {
  enum Icon implements LucideIconDefinition {
    AMBULANCE(
        "ambulance",
        "<path d=\"M10 10H6\" />\n  <path d=\"M14 18V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v11a1 1 0 0 0 1 1h2\" />\n  <path d=\"M19 18h2a1 1 0 0 0 1-1v-3.28a1 1 0 0 0-.684-.948l-1.923-.641a1 1 0 0 1-.578-.502l-1.539-3.076A1 1 0 0 0 16.382 8H14\" />\n  <path d=\"M8 8v4\" />\n  <path d=\"M9 18h6\" />\n  <circle cx=\"17\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"18\" r=\"2\" />"),
    ANCHOR(
        "anchor",
        "<path d=\"M12 6v16\" />\n  <path d=\"m19 13 2-1a9 9 0 0 1-18 0l2 1\" />\n  <path d=\"M9 11h6\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />"),
    ARROWS_UP_FROM_LINE(
        "arrows-up-from-line",
        "<path d=\"m4 6 3-3 3 3\" />\n  <path d=\"M7 17V3\" />\n  <path d=\"m14 6 3-3 3 3\" />\n  <path d=\"M17 17V3\" />\n  <path d=\"M4 21h16\" />"),
    BAGGAGE_CLAIM(
        "baggage-claim",
        "<path d=\"M22 18H6a2 2 0 0 1-2-2V7a2 2 0 0 0-2-2\" />\n  <path d=\"M17 14V4a2 2 0 0 0-2-2h-1a2 2 0 0 0-2 2v10\" />\n  <rect width=\"13\" height=\"8\" x=\"8\" y=\"6\" rx=\"1\" />\n  <circle cx=\"18\" cy=\"20\" r=\"2\" />\n  <circle cx=\"9\" cy=\"20\" r=\"2\" />"),
    BIKE(
        "bike",
        "<circle cx=\"18.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"5.5\" cy=\"17.5\" r=\"3.5\" />\n  <circle cx=\"15\" cy=\"5\" r=\"1\" />\n  <path d=\"M12 17.5V14l-3-3 4-3 2 3h2\" />"),
    BRIDGE(
        "bridge",
        "<path d=\"M10 9.728V16\" />\n  <path d=\"M14 9.728V16\" />\n  <path d=\"M18 20V4\" />\n  <path d=\"m22 11-4-4A7.5 7.5 0 0 1 6 7l-4 4\" />\n  <path d=\"M22 16H2\" />\n  <path d=\"M6 20V4\" />"),
    BRIEFCASE(
        "briefcase",
        "<path d=\"M16 20V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v16\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"6\" rx=\"2\" />"),
    BRIEFCASE_BUSINESS(
        "briefcase-business",
        "<path d=\"M12 12h.01\" />\n  <path d=\"M16 6V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v2\" />\n  <path d=\"M22 13a18.15 18.15 0 0 1-20 0\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"6\" rx=\"2\" />"),
    BRIEFCASE_CONVEYOR_BELT(
        "briefcase-conveyor-belt",
        "<path d=\"M10 20v2\" />\n  <path d=\"M14 20v2\" />\n  <path d=\"M18 20v2\" />\n  <path d=\"M21 20H3\" />\n  <path d=\"M6 20v2\" />\n  <path d=\"M8 16V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v12\" />\n  <rect x=\"4\" y=\"6\" width=\"16\" height=\"10\" rx=\"2\" />"),
    BRIEFCASE_MEDICAL(
        "briefcase-medical",
        "<path d=\"M12 11v4\" />\n  <path d=\"M14 13h-4\" />\n  <path d=\"M16 6V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v2\" />\n  <path d=\"M18 6v14\" />\n  <path d=\"M6 6v14\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"6\" rx=\"2\" />"),
    BRIEFCASE_PLUS(
        "briefcase-plus",
        "<path d=\"M13.354 20H4a2 2 0 01-2-2V8a2 2 0 012-2h16a2 2 0 012 2v3.354\" />\n  <path d=\"M16 11.354V4a2 2 0 00-2-2h-4a2 2 0 00-2 2v16\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />"),
    BUS(
        "bus",
        "<path d=\"M8 6v6\" />\n  <path d=\"M15 6v6\" />\n  <path d=\"M2 12h19.6\" />\n  <path d=\"M18 18h3s.5-1.7.8-2.8c.1-.4.2-.8.2-1.2 0-.4-.1-.8-.2-1.2l-1.4-5C20.1 6.8 19.1 6 18 6H4a2 2 0 0 0-2 2v10h3\" />\n  <circle cx=\"7\" cy=\"18\" r=\"2\" />\n  <path d=\"M9 18h5\" />\n  <circle cx=\"16\" cy=\"18\" r=\"2\" />"),
    BUS_FRONT(
        "bus-front",
        "<path d=\"M4 6 2 7\" />\n  <path d=\"M10 6h4\" />\n  <path d=\"m22 7-2-1\" />\n  <rect width=\"16\" height=\"16\" x=\"4\" y=\"3\" rx=\"2\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M8 15h.01\" />\n  <path d=\"M16 15h.01\" />\n  <path d=\"M6 19v2\" />\n  <path d=\"M18 21v-2\" />"),
    CABLE_CAR(
        "cable-car",
        "<path d=\"M10 3h.01\" />\n  <path d=\"M14 2h.01\" />\n  <path d=\"m2 9 20-5\" />\n  <path d=\"M12 12V6.5\" />\n  <rect width=\"16\" height=\"10\" x=\"4\" y=\"12\" rx=\"3\" />\n  <path d=\"M9 12v5\" />\n  <path d=\"M15 12v5\" />\n  <path d=\"M4 17h16\" />"),
    CAR(
        "car",
        "<path d=\"M19 17h2c.6 0 1-.4 1-1v-3c0-.9-.7-1.7-1.5-1.9C18.7 10.6 16 10 16 10s-1.3-1.4-2.2-2.3c-.5-.4-1.1-.7-1.8-.7H5c-.6 0-1.1.4-1.4.9l-1.4 2.9A3.7 3.7 0 0 0 2 12v4c0 .6.4 1 1 1h2\" />\n  <circle cx=\"7\" cy=\"17\" r=\"2\" />\n  <path d=\"M9 17h6\" />\n  <circle cx=\"17\" cy=\"17\" r=\"2\" />"),
    CAR_BATTERY(
        "car-battery",
        "<path d=\"M14 13h4\" />\n  <path d=\"M16 15v-4\" />\n  <path d=\"M18 5v2\" />\n  <path d=\"M6 13h4\" />\n  <path d=\"M6 5v2\" />\n  <rect x=\"2\" y=\"7\" width=\"20\" height=\"12\" rx=\"2\" />"),
    CAR_FRONT(
        "car-front",
        "<path d=\"m21 8-2 2-1.5-3.7A2 2 0 0 0 15.646 5H8.4a2 2 0 0 0-1.903 1.257L5 10 3 8\" />\n  <path d=\"M7 14h.01\" />\n  <path d=\"M17 14h.01\" />\n  <rect width=\"18\" height=\"8\" x=\"3\" y=\"10\" rx=\"2\" />\n  <path d=\"M5 18v2\" />\n  <path d=\"M19 18v2\" />"),
    CAR_TAXI_FRONT(
        "car-taxi-front",
        "<path d=\"M10 2h4\" />\n  <path d=\"m21 8-2 2-1.5-3.7A2 2 0 0 0 15.646 5H8.4a2 2 0 0 0-1.903 1.257L5 10 3 8\" />\n  <path d=\"M7 14h.01\" />\n  <path d=\"M17 14h.01\" />\n  <rect width=\"18\" height=\"8\" x=\"3\" y=\"10\" rx=\"2\" />\n  <path d=\"M5 18v2\" />\n  <path d=\"M19 18v2\" />"),
    CARAVAN(
        "caravan",
        "<path d=\"M18 19V9a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M2 9h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2\" />\n  <path d=\"M22 17v1a1 1 0 0 1-1 1H10v-9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v9\" />\n  <circle cx=\"8\" cy=\"19\" r=\"2\" />"),
    CIGARETTE(
        "cigarette",
        "<path d=\"M17 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h14\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M21 16a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    CIGARETTE_OFF(
        "cigarette-off",
        "<path d=\"M12 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h13\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 12a1 1 0 0 1 1 1v2a1 1 0 0 1-.5.866\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    CIRCLE_GAUGE(
        "circle-gauge",
        "<path d=\"M15.6 2.7a10 10 0 1 0 5.7 5.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M13.4 10.6 19 5\" />"),
    CIRCLE_PARKING(
        "circle-parking",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9 17V7h4a3 3 0 0 1 0 6H9\" />"),
    CIRCLE_PARKING_OFF(
        "circle-parking-off",
        "<path d=\"M12.656 7H13a3 3 0 0 1 2.984 3.307\" />\n  <path d=\"M13 13H9\" />\n  <path d=\"M19.071 19.071A1 1 0 0 1 4.93 4.93\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8.357 2.687a10 10 0 0 1 12.956 12.956\" />\n  <path d=\"M9 17V9\" />"),
    CONTAINER(
        "container",
        "<path d=\"M22 7.7c0-.6-.4-1.2-.8-1.5l-6.3-3.9a1.72 1.72 0 0 0-1.7 0l-10.3 6c-.5.2-.9.8-.9 1.4v6.6c0 .5.4 1.2.8 1.5l6.3 3.9a1.72 1.72 0 0 0 1.7 0l10.3-6c.5-.3.9-1 .9-1.5Z\" />\n  <path d=\"M10 21.9V14L2.1 9.1\" />\n  <path d=\"m10 14 11.9-6.9\" />\n  <path d=\"M14 19.8v-8.1\" />\n  <path d=\"M18 17.5V9.4\" />"),
    DOOR_CLOSED_PACKAGE(
        "door-closed-package",
        "<path d=\"M18 13v3\" />\n  <path d=\"M19 9V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"13\" width=\"8\" height=\"8\" rx=\"1\" />"),
    DRONE(
        "drone",
        "<path d=\"M10 10 7 7\" />\n  <path d=\"m10 14-3 3\" />\n  <path d=\"m14 10 3-3\" />\n  <path d=\"m14 14 3 3\" />\n  <path d=\"M14.205 4.139a4 4 0 1 1 5.439 5.863\" />\n  <path d=\"M19.637 14a4 4 0 1 1-5.432 5.868\" />\n  <path d=\"M4.367 10a4 4 0 1 1 5.438-5.862\" />\n  <path d=\"M9.795 19.862a4 4 0 1 1-5.429-5.873\" />\n  <rect x=\"10\" y=\"8\" width=\"4\" height=\"8\" rx=\"1\" />"),
    ENGINE(
        "engine",
        "<path d=\"M10 3h6\" />\n  <path d=\"M13 3v4\" />\n  <path d=\"M2 10v6\" />\n  <path d=\"M2 13h4\" />\n  <path d=\"M6 16a2 2 0 002 2h1a2 2 0 011.6.8l.3.4a2 2 0 001.6.8h2.264a2 2 0 001.789-1.106l1.67-3.341a1 1 0 01.895-.553H21a1 1 0 001-1v-4a1 1 0 00-1-1h-3.5a1 1 0 01-.8-.4l-.9-1.2A1 1 0 0015 7h-4a1 1 0 00-.8.4l-.9 1.2a1 1 0 01-.8.4H7a1 1 0 00-1 1z\" />"),
    EV_CHARGER(
        "ev-charger",
        "<path d=\"M14 13h2a2 2 0 0 1 2 2v2a2 2 0 0 0 4 0v-6.998a2 2 0 0 0-.59-1.42L18 5\" />\n  <path d=\"M14 21V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v16\" />\n  <path d=\"M2 21h13\" />\n  <path d=\"M3 7h11\" />\n  <path d=\"m9 11-2 3h3l-2 3\" />"),
    FORKLIFT(
        "forklift",
        "<path d=\"M12 12H5a2 2 0 0 0-2 2v5\" />\n  <path d=\"M15 19h7\" />\n  <path d=\"M16 19V2\" />\n  <path d=\"M6 12V7a2 2 0 0 1 2-2h2.172a2 2 0 0 1 1.414.586l3.828 3.828A2 2 0 0 1 16 10.828\" />\n  <path d=\"M7 19h4\" />\n  <circle cx=\"13\" cy=\"19\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    FUEL(
        "fuel",
        "<path d=\"M14 13h2a2 2 0 0 1 2 2v2a2 2 0 0 0 4 0v-6.998a2 2 0 0 0-.59-1.42L18 5\" />\n  <path d=\"M14 21V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2v16\" />\n  <path d=\"M2 21h13\" />\n  <path d=\"M3 9h11\" />"),
    GAUGE("gauge", "<path d=\"m12 14 4-4\" />\n  <path d=\"M3.34 19a10 10 0 1 1 17.32 0\" />"),
    HANDBAG(
        "handbag",
        "<path d=\"M2.048 18.566A2 2 0 0 0 4 21h16a2 2 0 0 0 1.952-2.434l-2-9A2 2 0 0 0 18 8H6a2 2 0 0 0-1.952 1.566z\" />\n  <path d=\"M8 11V6a4 4 0 0 1 8 0v5\" />"),
    HELICOPTER(
        "helicopter",
        "<path d=\"M11 17v4\" />\n  <path d=\"M14 3v8a2 2 0 0 0 2 2h5.865\" />\n  <path d=\"M17 17v4\" />\n  <path d=\"M18 17a4 4 0 0 0 4-4 8 6 0 0 0-8-6 6 5 0 0 0-6 5v3a2 2 0 0 0 2 2z\" />\n  <path d=\"M2 10v5\" />\n  <path d=\"M6 3h16\" />\n  <path d=\"M7 21h14\" />\n  <path d=\"M8 13H2\" />"),
    KAYAK(
        "kayak",
        "<path d=\"M18 17a1 1 0 0 0-1 1v1a2 2 0 1 0 2-2z\" />\n  <path d=\"M20.97 3.61a.45.45 0 0 0-.58-.58C10.2 6.6 6.6 10.2 3.03 20.39a.45.45 0 0 0 .58.58C13.8 17.4 17.4 13.8 20.97 3.61\" />\n  <path d=\"m6.707 6.707 10.586 10.586\" />\n  <path d=\"M7 5a2 2 0 1 0-2 2h1a1 1 0 0 0 1-1z\" />"),
    LUGGAGE(
        "luggage",
        "<path d=\"M6 20a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2\" />\n  <path d=\"M8 18V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v14\" />\n  <path d=\"M10 20h4\" />\n  <circle cx=\"16\" cy=\"20\" r=\"2\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    MOTORBIKE(
        "motorbike",
        "<path d=\"m18 14-1-3\" />\n  <path d=\"m3 9 6 2a2 2 0 0 1 2-2h2a2 2 0 0 1 1.99 1.81\" />\n  <path d=\"M8 17h3a1 1 0 0 0 1-1 6 6 0 0 1 6-6 1 1 0 0 0 1-1v-.75A5 5 0 0 0 17 5\" />\n  <circle cx=\"19\" cy=\"17\" r=\"3\" />\n  <circle cx=\"5\" cy=\"17\" r=\"3\" />"),
    OCTAGON_MINUS(
        "octagon-minus",
        "<path d=\"M2.586 16.726A2 2 0 0 1 2 15.312V8.688a2 2 0 0 1 .586-1.414l4.688-4.688A2 2 0 0 1 8.688 2h6.624a2 2 0 0 1 1.414.586l4.688 4.688A2 2 0 0 1 22 8.688v6.624a2 2 0 0 1-.586 1.414l-4.688 4.688a2 2 0 0 1-1.414.586H8.688a2 2 0 0 1-1.414-.586z\" />\n  <path d=\"M8 12h8\" />"),
    PARKING_METER(
        "parking-meter",
        "<path d=\"M11 15h2\" />\n  <path d=\"M12 12v3\" />\n  <path d=\"M12 19v3\" />\n  <path d=\"M15.282 19a1 1 0 0 0 .948-.68l2.37-6.988a7 7 0 1 0-13.2 0l2.37 6.988a1 1 0 0 0 .948.68z\" />\n  <path d=\"M9 9a3 3 0 1 1 6 0\" />"),
    PLANE(
        "plane",
        "<path d=\"M17.8 19.2 16 11l3.5-3.5C21 6 21.5 4 21 3c-1-.5-3 0-4.5 1.5L13 8 4.8 6.2c-.5-.1-.9.1-1.1.5l-.3.5c-.2.5-.1 1 .3 1.3L9 12l-2 3H4l-1 1 3 2 2 3 1-1v-3l3-2 3.5 5.3c.3.4.8.5 1.3.3l.5-.2c.4-.3.6-.7.5-1.2z\" />"),
    PLANE_LANDING(
        "plane-landing",
        "<path d=\"M2 22h20\" />\n  <path d=\"M3.77 10.77 2 9l2-4.5 1.1.55c.55.28.9.84.9 1.45s.35 1.17.9 1.45L8 8.5l3-6 1.05.53a2 2 0 0 1 1.09 1.52l.72 5.4a2 2 0 0 0 1.09 1.52l4.4 2.2c.42.22.78.55 1.01.96l.6 1.03c.49.88-.06 1.98-1.06 2.1l-1.18.15c-.47.06-.95-.02-1.37-.24L4.29 11.15a2 2 0 0 1-.52-.38Z\" />"),
    PLANE_TAKEOFF(
        "plane-takeoff",
        "<path d=\"M2 22h20\" />\n  <path d=\"M6.36 17.4 4 17l-2-4 1.1-.55a2 2 0 0 1 1.8 0l.17.1a2 2 0 0 0 1.8 0L8 12 5 6l.9-.45a2 2 0 0 1 2.09.2l4.02 3a2 2 0 0 0 2.1.2l4.19-2.06a2.41 2.41 0 0 1 1.73-.17L21 7a1.4 1.4 0 0 1 .87 1.99l-.38.76c-.23.46-.6.84-1.07 1.08L7.58 17.2a2 2 0 0 1-1.22.18Z\" />"),
    ROAD(
        "road",
        "<path d=\"M12 17v4\" />\n  <path d=\"M12 5V3\" />\n  <path d=\"M12 9v3\" />\n  <path d=\"M2.077 18.449A2 2 0 0 0 4 21h16a2 2 0 0 0 1.924-2.55l-4-14A2 2 0 0 0 16 3H8a2 2 0 0 0-1.924 1.45z\" />"),
    SAILBOAT(
        "sailboat",
        "<path d=\"M10 2v15\" />\n  <path d=\"M7 22a4 4 0 0 1-4-4 1 1 0 0 1 1-1h16a1 1 0 0 1 1 1 4 4 0 0 1-4 4z\" />\n  <path d=\"M9.159 2.46a1 1 0 0 1 1.521-.193l9.977 8.98A1 1 0 0 1 20 13H4a1 1 0 0 1-.824-1.567z\" />"),
    SCOOTER(
        "scooter",
        "<path d=\"M21 4h-3.5l2 11.05\" />\n  <path d=\"M6.95 17h5.142c.523 0 .95-.406 1.063-.916a6.5 6.5 0 0 1 5.345-5.009\" />\n  <circle cx=\"19.5\" cy=\"17.5\" r=\"2.5\" />\n  <circle cx=\"4.5\" cy=\"17.5\" r=\"2.5\" />"),
    SHIP(
        "ship",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 9.189V13\" />\n  <path d=\"M19 12V6a2 2 0 00-2-2H7a2 2 0 00-2 2v6\" />\n  <path d=\"M19.38 19A11.6 11.6 0 0021 13l-8.188-3.639a2 2 0 00-1.624 0L3 13.001a11.6 11.6 0 002.81 7.76\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_CARGO(
        "ship-cargo",
        "<path d=\"M12 15v-3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M16.5 12V9a1 1 0 011-1h1a1 1 0 001-1V5a1 1 0 00-1-1h-13a1 1 0 00-1 1v2a1 1 0 001 1h1a1 1 0 011 1v3\" />\n  <path d=\"M19.38 19c1.076-1.815 1.636-4.89 1.628-6.008a1 1 0 00-1-.992H3.984a1 1 0 00-1 .984c-.03 1.86.97 5.621 2.826 7.776\" />\n  <path d=\"M2 20c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1s1.2 1 2.5 1c2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />"),
    SHIP_WHEEL(
        "ship-wheel",
        "<circle cx=\"12\" cy=\"12\" r=\"8\" />\n  <path d=\"M12 2v7.5\" />\n  <path d=\"m19 5-5.23 5.23\" />\n  <path d=\"M22 12h-7.5\" />\n  <path d=\"m19 19-5.23-5.23\" />\n  <path d=\"M12 14.5V22\" />\n  <path d=\"M10.23 13.77 5 19\" />\n  <path d=\"M9.5 12H2\" />\n  <path d=\"M10.23 10.23 5 5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2.5\" />"),
    SQUARE_M(
        "square-m",
        "<path d=\"M8 16V8.5a.5.5 0 0 1 .9-.3l2.7 3.599a.5.5 0 0 0 .8 0l2.7-3.6a.5.5 0 0 1 .9.3V16\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    SQUARE_PARKING(
        "square-parking",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 17V7h4a3 3 0 0 1 0 6H9\" />"),
    SQUARE_PARKING_OFF(
        "square-parking-off",
        "<path d=\"M3.6 3.6A2 2 0 0 1 5 3h14a2 2 0 0 1 2 2v14a2 2 0 0 1-.59 1.41\" />\n  <path d=\"M3 8.7V19a2 2 0 0 0 2 2h10.3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M13 13a3 3 0 1 0 0-6H9v2\" />\n  <path d=\"M9 17v-2.3\" />"),
    TICKET(
        "ticket",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"M13 5v2\" />\n  <path d=\"M13 17v2\" />\n  <path d=\"M13 11v2\" />"),
    TICKET_CHECK(
        "ticket-check",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"m9 12 2 2 4-4\" />"),
    TICKET_MINUS(
        "ticket-minus",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"M9 12h6\" />"),
    TICKET_PERCENT(
        "ticket-percent",
        "<path d=\"M2 9a3 3 0 1 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 1 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M15 15h.01\" />"),
    TICKET_PLUS(
        "ticket-plus",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />"),
    TICKET_SLASH(
        "ticket-slash",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"m9.5 14.5 5-5\" />"),
    TICKET_X(
        "ticket-x",
        "<path d=\"M2 9a3 3 0 0 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 0 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"m9.5 14.5 5-5\" />\n  <path d=\"m9.5 9.5 5 5\" />"),
    TICKETS(
        "tickets",
        "<path d=\"m3.173 8.18 11-5a2 2 0 0 1 2.647.993L18.56 8\" />\n  <path d=\"M6 10V8\" />\n  <path d=\"M6 14v1\" />\n  <path d=\"M6 19v2\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"13\" rx=\"2\" />"),
    TICKETS_PLANE(
        "tickets-plane",
        "<path d=\"M10.5 17h1.227a2 2 0 0 0 1.345-.52L18 12\" />\n  <path d=\"m12 13.5 3.794.506\" />\n  <path d=\"m3.173 8.18 11-5a2 2 0 0 1 2.647.993L18.56 8\" />\n  <path d=\"M6 10V8\" />\n  <path d=\"M6 14v1\" />\n  <path d=\"M6 19v2\" />\n  <rect x=\"2\" y=\"8\" width=\"20\" height=\"13\" rx=\"2\" />"),
    TOWER_CONTROL(
        "tower-control",
        "<path d=\"M18.2 12.27 20 6H4l1.8 6.27a1 1 0 0 0 .95.73h10.5a1 1 0 0 0 .96-.73Z\" />\n  <path d=\"M8 13v9\" />\n  <path d=\"M16 22v-9\" />\n  <path d=\"m9 6 1 7\" />\n  <path d=\"m15 6-1 7\" />\n  <path d=\"M12 6V2\" />\n  <path d=\"M13 2h-2\" />"),
    TRACTOR(
        "tractor",
        "<path d=\"m10 11 11 .9a1 1 0 0 1 .8 1.1l-.665 4.158a1 1 0 0 1-.988.842H20\" />\n  <path d=\"M16 18h-5\" />\n  <path d=\"M18 5a1 1 0 0 0-1 1v5.573\" />\n  <path d=\"M3 4h8.129a1 1 0 0 1 .99.863L13 11.246\" />\n  <path d=\"M4 11V4\" />\n  <path d=\"M7 15h.01\" />\n  <path d=\"M8 10.1V4\" />\n  <circle cx=\"18\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"15\" r=\"5\" />"),
    TRAFFIC_CONE(
        "traffic-cone",
        "<path d=\"M16.05 10.966a5 2.5 0 0 1-8.1 0\" />\n  <path d=\"m16.923 14.049 4.48 2.04a1 1 0 0 1 .001 1.831l-8.574 3.9a2 2 0 0 1-1.66 0l-8.574-3.91a1 1 0 0 1 0-1.83l4.484-2.04\" />\n  <path d=\"M16.949 14.14a5 2.5 0 1 1-9.9 0L10.063 3.5a2 2 0 0 1 3.874 0z\" />\n  <path d=\"M9.194 6.57a5 2.5 0 0 0 5.61 0\" />"),
    TRAILER(
        "trailer",
        "<path d=\"M10 11.341V10\" />\n  <path d=\"M14 13v-3\" />\n  <path d=\"M18 17V8a2 2 0 00-2-2H4a2 2 0 00-2 2v7a2 2 0 002 2h2\" />\n  <path d=\"M22 15v1a1 1 0 01-1 1H10\" />\n  <path d=\"M6 11.341V10\" />\n  <circle cx=\"8\" cy=\"17\" r=\"2\" />"),
    TRAIN_FRONT(
        "train-front",
        "<path d=\"M8 3.1V7a4 4 0 0 0 8 0V3.1\" />\n  <path d=\"m9 15-1-1\" />\n  <path d=\"m15 15 1-1\" />\n  <path d=\"M9 19c-2.8 0-5-2.2-5-5v-4a8 8 0 0 1 16 0v4c0 2.8-2.2 5-5 5Z\" />\n  <path d=\"m8 19-2 3\" />\n  <path d=\"m16 19 2 3\" />"),
    TRAIN_FRONT_TUNNEL(
        "train-front-tunnel",
        "<path d=\"M2 22V12a10 10 0 1 1 20 0v10\" />\n  <path d=\"M15 6.8v1.4a3 2.8 0 1 1-6 0V6.8\" />\n  <path d=\"M10 15h.01\" />\n  <path d=\"M14 15h.01\" />\n  <path d=\"M10 19a4 4 0 0 1-4-4v-3a6 6 0 1 1 12 0v3a4 4 0 0 1-4 4Z\" />\n  <path d=\"m9 19-2 3\" />\n  <path d=\"m15 19 2 3\" />"),
    TRAIN_TRACK(
        "train-track",
        "<path d=\"M2 17 17 2\" />\n  <path d=\"m2 14 8 8\" />\n  <path d=\"m5 11 8 8\" />\n  <path d=\"m8 8 8 8\" />\n  <path d=\"m11 5 8 8\" />\n  <path d=\"m14 2 8 8\" />\n  <path d=\"M7 22 22 7\" />"),
    TRAM_FRONT(
        "tram-front",
        "<rect width=\"16\" height=\"16\" x=\"4\" y=\"3\" rx=\"2\" />\n  <path d=\"M4 11h16\" />\n  <path d=\"M12 3v8\" />\n  <path d=\"m8 19-2 3\" />\n  <path d=\"m18 22-2-3\" />\n  <path d=\"M8 15h.01\" />\n  <path d=\"M16 15h.01\" />"),
    TRUCK(
        "truck",
        "<path d=\"M14 18V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v11a1 1 0 0 0 1 1h2\" />\n  <path d=\"M15 18H9\" />\n  <path d=\"M19 18h2a1 1 0 0 0 1-1v-3.65a1 1 0 0 0-.22-.624l-3.48-4.35A1 1 0 0 0 17.52 8H14\" />\n  <circle cx=\"17\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"18\" r=\"2\" />"),
    TRUCK_ELECTRIC(
        "truck-electric",
        "<path d=\"M14 19V7a2 2 0 0 0-2-2H9\" />\n  <path d=\"M15 19H9\" />\n  <path d=\"M19 19h2a1 1 0 0 0 1-1v-3.65a1 1 0 0 0-.22-.62L18.3 9.38a1 1 0 0 0-.78-.38H14\" />\n  <path d=\"M2 13v5a1 1 0 0 0 1 1h2\" />\n  <path d=\"M4 3 2.15 5.15a.495.495 0 0 0 .35.86h2.15a.47.47 0 0 1 .35.86L3 9.02\" />\n  <circle cx=\"17\" cy=\"19\" r=\"2\" />\n  <circle cx=\"7\" cy=\"19\" r=\"2\" />"),
    VAN(
        "van",
        "<path d=\"M13 6v5a1 1 0 0 0 1 1h6.102a1 1 0 0 1 .712.298l.898.91a1 1 0 0 1 .288.702V17a1 1 0 0 1-1 1h-3\" />\n  <path d=\"M5 18H3a1 1 0 0 1-1-1V8a2 2 0 0 1 2-2h12c1.1 0 2.1.8 2.4 1.8l1.176 4.2\" />\n  <path d=\"M9 18h5\" />\n  <circle cx=\"16\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"18\" r=\"2\" />");

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
  default LucideIcon ambulance_transportation() {
    return LucideIcon.create(Icon.AMBULANCE);
  }

  default LucideIcon anchor_transportation() {
    return LucideIcon.create(Icon.ANCHOR);
  }

  default LucideIcon arrows_up_from_line_transportation() {
    return LucideIcon.create(Icon.ARROWS_UP_FROM_LINE);
  }

  default LucideIcon baggage_claim_transportation() {
    return LucideIcon.create(Icon.BAGGAGE_CLAIM);
  }

  default LucideIcon bike() {
    return LucideIcon.create(Icon.BIKE);
  }

  default LucideIcon bridge_transportation() {
    return LucideIcon.create(Icon.BRIDGE);
  }

  default LucideIcon briefcase() {
    return LucideIcon.create(Icon.BRIEFCASE);
  }

  default LucideIcon briefcase_business() {
    return LucideIcon.create(Icon.BRIEFCASE_BUSINESS);
  }

  default LucideIcon briefcase_conveyor_belt_transportation() {
    return LucideIcon.create(Icon.BRIEFCASE_CONVEYOR_BELT);
  }

  default LucideIcon briefcase_medical_transportation() {
    return LucideIcon.create(Icon.BRIEFCASE_MEDICAL);
  }

  default LucideIcon briefcase_plus_transportation() {
    return LucideIcon.create(Icon.BRIEFCASE_PLUS);
  }

  default LucideIcon bus() {
    return LucideIcon.create(Icon.BUS);
  }

  default LucideIcon bus_front() {
    return LucideIcon.create(Icon.BUS_FRONT);
  }

  default LucideIcon cable_car_transportation() {
    return LucideIcon.create(Icon.CABLE_CAR);
  }

  default LucideIcon car() {
    return LucideIcon.create(Icon.CAR);
  }

  default LucideIcon car_battery_transportation() {
    return LucideIcon.create(Icon.CAR_BATTERY);
  }

  default LucideIcon car_front() {
    return LucideIcon.create(Icon.CAR_FRONT);
  }

  default LucideIcon car_taxi_front() {
    return LucideIcon.create(Icon.CAR_TAXI_FRONT);
  }

  default LucideIcon caravan_transportation() {
    return LucideIcon.create(Icon.CARAVAN);
  }

  default LucideIcon cigarette_transportation() {
    return LucideIcon.create(Icon.CIGARETTE);
  }

  default LucideIcon cigarette_off_transportation() {
    return LucideIcon.create(Icon.CIGARETTE_OFF);
  }

  default LucideIcon circle_gauge_transportation() {
    return LucideIcon.create(Icon.CIRCLE_GAUGE);
  }

  default LucideIcon circle_parking_transportation() {
    return LucideIcon.create(Icon.CIRCLE_PARKING);
  }

  default LucideIcon circle_parking_off_transportation() {
    return LucideIcon.create(Icon.CIRCLE_PARKING_OFF);
  }

  default LucideIcon container_transportation() {
    return LucideIcon.create(Icon.CONTAINER);
  }

  default LucideIcon door_closed_package_transportation() {
    return LucideIcon.create(Icon.DOOR_CLOSED_PACKAGE);
  }

  default LucideIcon drone_transportation() {
    return LucideIcon.create(Icon.DRONE);
  }

  default LucideIcon engine() {
    return LucideIcon.create(Icon.ENGINE);
  }

  default LucideIcon ev_charger_transportation() {
    return LucideIcon.create(Icon.EV_CHARGER);
  }

  default LucideIcon forklift() {
    return LucideIcon.create(Icon.FORKLIFT);
  }

  default LucideIcon fuel_transportation() {
    return LucideIcon.create(Icon.FUEL);
  }

  default LucideIcon gauge_transportation() {
    return LucideIcon.create(Icon.GAUGE);
  }

  default LucideIcon handbag_transportation() {
    return LucideIcon.create(Icon.HANDBAG);
  }

  default LucideIcon helicopter_transportation() {
    return LucideIcon.create(Icon.HELICOPTER);
  }

  default LucideIcon kayak() {
    return LucideIcon.create(Icon.KAYAK);
  }

  default LucideIcon luggage_transportation() {
    return LucideIcon.create(Icon.LUGGAGE);
  }

  default LucideIcon motorbike() {
    return LucideIcon.create(Icon.MOTORBIKE);
  }

  default LucideIcon octagon_minus() {
    return LucideIcon.create(Icon.OCTAGON_MINUS);
  }

  default LucideIcon parking_meter_transportation() {
    return LucideIcon.create(Icon.PARKING_METER);
  }

  default LucideIcon plane_transportation() {
    return LucideIcon.create(Icon.PLANE);
  }

  default LucideIcon plane_landing_transportation() {
    return LucideIcon.create(Icon.PLANE_LANDING);
  }

  default LucideIcon plane_takeoff_transportation() {
    return LucideIcon.create(Icon.PLANE_TAKEOFF);
  }

  default LucideIcon road() {
    return LucideIcon.create(Icon.ROAD);
  }

  default LucideIcon sailboat_transportation() {
    return LucideIcon.create(Icon.SAILBOAT);
  }

  default LucideIcon scooter() {
    return LucideIcon.create(Icon.SCOOTER);
  }

  default LucideIcon ship_transportation() {
    return LucideIcon.create(Icon.SHIP);
  }

  default LucideIcon ship_cargo_transportation() {
    return LucideIcon.create(Icon.SHIP_CARGO);
  }

  default LucideIcon ship_wheel_transportation() {
    return LucideIcon.create(Icon.SHIP_WHEEL);
  }

  default LucideIcon square_m_transportation() {
    return LucideIcon.create(Icon.SQUARE_M);
  }

  default LucideIcon square_parking_transportation() {
    return LucideIcon.create(Icon.SQUARE_PARKING);
  }

  default LucideIcon square_parking_off_transportation() {
    return LucideIcon.create(Icon.SQUARE_PARKING_OFF);
  }

  default LucideIcon ticket_transportation() {
    return LucideIcon.create(Icon.TICKET);
  }

  default LucideIcon ticket_check() {
    return LucideIcon.create(Icon.TICKET_CHECK);
  }

  default LucideIcon ticket_minus() {
    return LucideIcon.create(Icon.TICKET_MINUS);
  }

  default LucideIcon ticket_percent_transportation() {
    return LucideIcon.create(Icon.TICKET_PERCENT);
  }

  default LucideIcon ticket_plus() {
    return LucideIcon.create(Icon.TICKET_PLUS);
  }

  default LucideIcon ticket_slash() {
    return LucideIcon.create(Icon.TICKET_SLASH);
  }

  default LucideIcon ticket_x() {
    return LucideIcon.create(Icon.TICKET_X);
  }

  default LucideIcon tickets_transportation() {
    return LucideIcon.create(Icon.TICKETS);
  }

  default LucideIcon tickets_plane_transportation() {
    return LucideIcon.create(Icon.TICKETS_PLANE);
  }

  default LucideIcon tower_control_transportation() {
    return LucideIcon.create(Icon.TOWER_CONTROL);
  }

  default LucideIcon tractor_transportation() {
    return LucideIcon.create(Icon.TRACTOR);
  }

  default LucideIcon traffic_cone() {
    return LucideIcon.create(Icon.TRAFFIC_CONE);
  }

  default LucideIcon trailer() {
    return LucideIcon.create(Icon.TRAILER);
  }

  default LucideIcon train_front() {
    return LucideIcon.create(Icon.TRAIN_FRONT);
  }

  default LucideIcon train_front_tunnel_transportation() {
    return LucideIcon.create(Icon.TRAIN_FRONT_TUNNEL);
  }

  default LucideIcon train_track_transportation() {
    return LucideIcon.create(Icon.TRAIN_TRACK);
  }

  default LucideIcon tram_front() {
    return LucideIcon.create(Icon.TRAM_FRONT);
  }

  default LucideIcon truck() {
    return LucideIcon.create(Icon.TRUCK);
  }

  default LucideIcon truck_electric() {
    return LucideIcon.create(Icon.TRUCK_ELECTRIC);
  }

  default LucideIcon van() {
    return LucideIcon.create(Icon.VAN);
  }
}
