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

/** Lucide science catalog category. */
public interface LucideScience {
  enum Icon implements LucideIconDefinition {
    ACTIVITY(
        "activity",
        "<path d=\"M22 12h-2.48a2 2 0 0 0-1.93 1.46l-2.35 8.36a.25.25 0 0 1-.48 0L9.24 2.18a.25.25 0 0 0-.48 0l-2.35 8.36A2 2 0 0 1 4.49 12H2\" />"),
    ATOM(
        "atom",
        "<circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M20.2 20.2c2.04-2.03.02-7.36-4.5-11.9-4.54-4.52-9.87-6.54-11.9-4.5-2.04 2.03-.02 7.36 4.5 11.9 4.54 4.52 9.87 6.54 11.9 4.5Z\" />\n  <path d=\"M15.7 15.7c4.52-4.54 6.54-9.87 4.5-11.9-2.03-2.04-7.36-.02-11.9 4.5-4.52 4.54-6.54 9.87-4.5 11.9 2.03 2.04 7.36.02 11.9-4.5Z\" />"),
    BEAKER(
        "beaker",
        "<path d=\"M4.5 3h15\" />\n  <path d=\"M6 3v16a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V3\" />\n  <path d=\"M6 14h12\" />"),
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BIOHAZARD(
        "biohazard",
        "<circle cx=\"12\" cy=\"11.9\" r=\"2\" />\n  <path d=\"M6.7 3.4c-.9 2.5 0 5.2 2.2 6.7C6.5 9 3.7 9.6 2 11.6\" />\n  <path d=\"m8.9 10.1 1.4.8\" />\n  <path d=\"M17.3 3.4c.9 2.5 0 5.2-2.2 6.7 2.4-1.2 5.2-.6 6.9 1.5\" />\n  <path d=\"m15.1 10.1-1.4.8\" />\n  <path d=\"M16.7 20.8c-2.6-.4-4.6-2.6-4.7-5.3-.2 2.6-2.1 4.8-4.7 5.2\" />\n  <path d=\"M12 13.9v1.6\" />\n  <path d=\"M13.5 5.4c-1-.2-2-.2-3 0\" />\n  <path d=\"M17 16.4c.7-.7 1.2-1.6 1.5-2.5\" />\n  <path d=\"M5.5 13.9c.3.9.8 1.8 1.5 2.5\" />"),
    BRAIN(
        "brain",
        "<path d=\"M12 18V5\" />\n  <path d=\"M15 13a4.17 4.17 0 01-3-4 4.17 4.17 0 01-3 4\" />\n  <path d=\"M17.707 6.294A3 3 0 1012 5a3 3 0 10-5.707 1.294\" />\n  <path d=\"M17.996 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M18 18a4 4 0 002-7.465\" />\n  <path d=\"M19.967 17.482a4 4 0 11-7.967.517 4 4 0 11-7.967-.517\" />\n  <path d=\"M6 18a4 4 0 01-2-7.465\" />\n  <path d=\"M6.004 5.125a4 4 0 00-2.526 5.77\" />"),
    BRAIN_CIRCUIT(
        "brain-circuit",
        "<path d=\"M12 13h4\" />\n  <path d=\"M12 18h6a2 2 0 012 2v1\" />\n  <path d=\"M12 8h8\" />\n  <path d=\"M12 9a4.17 4.17 0 01-3 4\" />\n  <path d=\"M16 8V5a2 2 0 012-2\" />\n  <path d=\"M6 18a4 4 0 01-2-7.465\" />\n  <path d=\"M6.004 5.125a4 4 0 00-2.526 5.77\" />\n  <path d=\"M6.294 6.294A3 3 0 1112 5v13a4 4 0 11-7.967-.518\" />\n  <circle cx=\"16\" cy=\"13\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"18\" cy=\"3\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"20\" cy=\"21\" r=\"0.5\" fill=\"currentColor\" />\n  <circle cx=\"20\" cy=\"8\" r=\"0.5\" fill=\"currentColor\" />"),
    BRAIN_COG(
        "brain-cog",
        "<path d=\"m10.852 14.772-.383.923\" />\n  <path d=\"m10.852 9.228-.383-.923\" />\n  <path d=\"m13.148 14.772.382.924\" />\n  <path d=\"m13.53 8.305-.382.923\" />\n  <path d=\"m14.772 10.852.923-.383\" />\n  <path d=\"m14.772 13.148.923.383\" />\n  <path d=\"M17.997 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M18 18a4 4 0 002-7.464\" />\n  <path d=\"M4.033 17.483A4 4 0 0011.46 20c.184-.31.896-.31 1.076 0a4 4 0 007.43-2.517\" />\n  <path d=\"M6 18a4 4 0 01-2-7.464\" />\n  <path d=\"M6.002 5.125a4 4 0 00-2.525 5.77\" />\n  <path d=\"M6.293 6.294a3 3 0 01-.287-1.098l-.004-.07a3 3 0 015.968-.543c.05.02.057.01.059 0a3 3 0 015.968.542l-.004.071a3 3 0 01-.287 1.098\" />\n  <path d=\"m9.228 10.852-.923-.383\" />\n  <path d=\"m9.228 13.148-.923.383\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    BRAIN_OFF(
        "brain-off",
        "<path d=\"M12 18v-6\" />\n  <path d=\"M12 5v1.344\" />\n  <path d=\"M17.707 6.293A3 3 0 1012 5a3 3 0 00-4.124-2.781\" />\n  <path d=\"M17.997 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M19.644 19.644A4 4 0 0112 18a4 4 0 11-7.967-.517\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 10.536a4 4 0 011.533 5.34\" />\n  <path d=\"M3.477 10.895a4 4 0 011.876-5.542\" />\n  <path d=\"M6 18a4 4 0 01-2-7.464\" />\n  <path d=\"M9 13a4.17 4.17 0 002.166-1.5 4 4 0 00.138-.196\" />"),
    CIRCLE_GAUGE(
        "circle-gauge",
        "<path d=\"M15.6 2.7a10 10 0 1 0 5.7 5.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M13.4 10.6 19 5\" />"),
    CIRCUIT_BOARD(
        "circuit-board",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M11 9h4a2 2 0 0 0 2-2V3\" />\n  <circle cx=\"9\" cy=\"9\" r=\"2\" />\n  <path d=\"M7 21v-4a2 2 0 0 1 2-2h4\" />\n  <circle cx=\"15\" cy=\"15\" r=\"2\" />"),
    ECLIPSE(
        "eclipse",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 2a7 7 0 1 0 10 10\" />"),
    EQUAL_APPROXIMATELY_NOT(
        "equal-approximately-not",
        "<path d=\"M5 15a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <path d=\"M5 9a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    FLASK_CONICAL(
        "flask-conical",
        "<path d=\"M14 2v6a2 2 0 0 0 .245.96l5.51 10.08A2 2 0 0 1 18 22H6a2 2 0 0 1-1.755-2.96l5.51-10.08A2 2 0 0 0 10 8V2\" />\n  <path d=\"M6.453 15h11.094\" />\n  <path d=\"M8.5 2h7\" />"),
    FLASK_CONICAL_OFF(
        "flask-conical-off",
        "<path d=\"M10 2v2.343\" />\n  <path d=\"M14 2v6.343\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 20a2 2 0 0 1-2 2H6a2 2 0 0 1-1.755-2.96l5.227-9.563\" />\n  <path d=\"M6.453 15H15\" />\n  <path d=\"M8.5 2h7\" />"),
    FLASK_ROUND(
        "flask-round",
        "<path d=\"M10 2v6.292a7 7 0 1 0 4 0V2\" />\n  <path d=\"M5 15h14\" />\n  <path d=\"M8.5 2h7\" />"),
    GALAXY(
        "galaxy",
        "<path d=\"M16.005 15.108a5.041 6.52 28.25 00-8.008-6.217 5.041 6.52 28.25 008.008 6.217A11.884 7.288-60.76 014.029 7.001\" />\n  <path d=\"M17 21h.01\" />\n  <path d=\"M7 3h.01\" />\n  <path d=\"M7.997 8.891a11.885 7.288-60.756 0111.977 8.107\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" fill=\"currentColor\" />"),
    GAUGE("gauge", "<path d=\"m12 14 4-4\" />\n  <path d=\"M3.34 19a10 10 0 1 1 17.32 0\" />"),
    GERM(
        "germ",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m22 16-2.474-2.13\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />\n  <path d=\"M9.33 7.035c-.51 1.478-1.786 2.93-3.09 3.794A5 5 0 009 20a12.1 12.1 0 0011.902-9.916A6 6 0 009.33 7.035\" />\n  <circle cx=\"15\" cy=\"9\" r=\"2\" />"),
    GERM_OFF(
        "germ-off",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"M13.424 7.768a2 2 0 112.808 2.808\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"M16.988 16.988A12 12 0 019 20a5 5 0 01-2.759-9.171 8.8 8.8 0 002.307-2.28\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m22 16-2.474-2.13a12 12 0 001.376-3.786 6 6 0 00-10.313-5.151\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />"),
    LAMBDA(
        "lambda",
        "<path d=\"M11.38 10 5 20\" />\n  <path d=\"M19 18a2 2 0 01-2 2c-4.87-.003-5.052-16-10-16a2 2 0 00-2 2\" />"),
    LENS(
        "lens",
        "<path d=\"M15.725 7.296h.01\" />\n  <path d=\"M6 12a6 6 0 016-6\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    LENS_CONCAVE(
        "lens-concave",
        "<path d=\"M7 2a1 1 0 0 0-.8 1.6 14 14 0 0 1 0 16.8A1 1 0 0 0 7 22h10a1 1 0 0 0 .8-1.6 14 14 0 0 1 0-16.8A1 1 0 0 0 17 2z\" />"),
    LENS_CONVEX(
        "lens-convex",
        "<path d=\"M13.433 2a1 1 0 0 1 .824.448 18 18 0 0 1 0 19.104 1 1 0 0 1-.824.448h-2.866a1 1 0 0 1-.824-.448 18 18 0 0 1 0-19.104A1 1 0 0 1 10.567 2z\" />"),
    MICROSCOPE(
        "microscope",
        "<path d=\"M6 18h8\" />\n  <path d=\"M3 22h18\" />\n  <path d=\"M14 22a7 7 0 1 0 0-14h-1\" />\n  <path d=\"M9 14h2\" />\n  <path d=\"M9 12a2 2 0 0 1-2-2V6h6v4a2 2 0 0 1-2 2Z\" />\n  <path d=\"M12 6V3a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3\" />"),
    MIRROR_RECTANGULAR(
        "mirror-rectangular",
        "<path d=\"M11 6 8 9\" />\n  <path d=\"m16 7-8 8\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    MIRROR_ROUND(
        "mirror-round",
        "<path d=\"M10 6.6 8.6 8\" />\n  <path d=\"M12 18v4\" />\n  <path d=\"M15 7.5 9.5 13\" />\n  <path d=\"M7 22h10\" />\n  <circle cx=\"12\" cy=\"10\" r=\"8\" />"),
    OMEGA(
        "omega",
        "<path d=\"M3 20h4.5a.5.5 0 0 0 .5-.5v-.282a.52.52 0 0 0-.247-.437 8 8 0 1 1 8.494-.001.52.52 0 0 0-.247.438v.282a.5.5 0 0 0 .5.5H21\" />"),
    ORBIT(
        "orbit",
        "<path d=\"M20.341 6.484A10 10 0 0 1 10.266 21.85\" />\n  <path d=\"M3.659 17.516A10 10 0 0 1 13.74 2.152\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <circle cx=\"19\" cy=\"5\" r=\"2\" />\n  <circle cx=\"5\" cy=\"19\" r=\"2\" />"),
    PHI("phi", "<path d=\"M12 2v20\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />"),
    PIPETTE(
        "pipette",
        "<path d=\"m12 9-8.414 8.414A2 2 0 0 0 3 18.828v1.344a2 2 0 0 1-.586 1.414A2 2 0 0 1 3.828 21h1.344a2 2 0 0 0 1.414-.586L15 12\" />\n  <path d=\"m18 9 .4.4a1 1 0 1 1-3 3l-3.8-3.8a1 1 0 1 1 3-3l.4.4 3.4-3.4a1 1 0 1 1 3 3z\" />\n  <path d=\"m2 22 .414-.414\" />"),
    RADIATION(
        "radiation",
        "<path d=\"M12 12h.01\" />\n  <path d=\"M14 15.4641a4 4 0 0 1-4 0L7.52786 19.74597 A 1 1 0 0 0 7.99303 21.16211 10 10 0 0 0 16.00697 21.16211 1 1 0 0 0 16.47214 19.74597z\" />\n  <path d=\"M16 12a4 4 0 0 0-2-3.464l2.472-4.282a1 1 0 0 1 1.46-.305 10 10 0 0 1 4.006 6.94A1 1 0 0 1 21 12z\" />\n  <path d=\"M8 12a4 4 0 0 1 2-3.464L7.528 4.254a1 1 0 0 0-1.46-.305 10 10 0 0 0-4.006 6.94A1 1 0 0 0 3 12z\" />"),
    ROBOT_ARM(
        "robot-arm",
        "<path d=\"M12 21 7.5 8.322\" />\n  <path d=\"m14 7 1.75-3.767a.5.5 0 0 1 .662-.172L20 5.005\" />\n  <path d=\"m20 8.998-3.588 1.944a.5.5 0 0 1-.662-.172L14 7H8\" />\n  <path d=\"M3.486 21h10\" />\n  <path d=\"M5 21V8.732\" />\n  <circle cx=\"6\" cy=\"7\" r=\"2\" />"),
    SATELLITE(
        "satellite",
        "<path d=\"m13.5 6.5-3.148-3.148a1.205 1.205 0 0 0-1.704 0L6.352 5.648a1.205 1.205 0 0 0 0 1.704L9.5 10.5\" />\n  <path d=\"M16.5 7.5 19 5\" />\n  <path d=\"m17.5 10.5 3.148 3.148a1.205 1.205 0 0 1 0 1.704l-2.296 2.296a1.205 1.205 0 0 1-1.704 0L13.5 14.5\" />\n  <path d=\"M9 21a6 6 0 0 0-6-6\" />\n  <path d=\"M9.352 10.648a1.205 1.205 0 0 0 0 1.704l2.296 2.296a1.205 1.205 0 0 0 1.704 0l4.296-4.296a1.205 1.205 0 0 0 0-1.704l-2.296-2.296a1.205 1.205 0 0 0-1.704 0z\" />"),
    SCALE(
        "scale",
        "<path d=\"M12 3v18\" />\n  <path d=\"m19 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M3 7h1a17 17 0 0 0 8-2 17 17 0 0 0 8 2h1\" />\n  <path d=\"m5 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M7 21h10\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SIGMA(
        "sigma",
        "<path d=\"M18 7V5a1 1 0 0 0-1-1H6.5a.5.5 0 0 0-.4.8l4.5 6a2 2 0 0 1 0 2.4l-4.5 6a.5.5 0 0 0 .4.8H17a1 1 0 0 0 1-1v-2\" />"),
    SOLAR_PANEL(
        "solar-panel",
        "<path d=\"M11 2h2\" />\n  <path d=\"m14.28 14-4.56 8\" />\n  <path d=\"m21 22-1.558-4H4.558\" />\n  <path d=\"M3 10v2\" />\n  <path d=\"M6.245 15.04A2 2 0 0 1 8 14h12a1 1 0 0 1 .864 1.505l-3.11 5.457A2 2 0 0 1 16 22H4a1 1 0 0 1-.863-1.506z\" />\n  <path d=\"M7 2a4 4 0 0 1-4 4\" />\n  <path d=\"m8.66 7.66 1.41 1.41\" />"),
    SQUARE_ACTIVITY(
        "square-activity",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M17 12h-2l-2 5-2-10-2 5H7\" />"),
    STETHOSCOPE(
        "stethoscope",
        "<path d=\"M11 2v2\" />\n  <path d=\"M5 2v2\" />\n  <path d=\"M5 3H4a2 2 0 0 0-2 2v4a6 6 0 0 0 12 0V5a2 2 0 0 0-2-2h-1\" />\n  <path d=\"M8 15a6 6 0 0 0 12 0v-3\" />\n  <circle cx=\"20\" cy=\"10\" r=\"2\" />"),
    SYRINGE(
        "syringe",
        "<path d=\"m18 2 4 4\" />\n  <path d=\"m17 7 3-3\" />\n  <path d=\"M19 9 8.7 19.3c-1 1-2.5 1-3.4 0l-.6-.6c-1-1-1-2.5 0-3.4L15 5\" />\n  <path d=\"m9 11 4 4\" />\n  <path d=\"m5 19-3 3\" />\n  <path d=\"m14 4 6 6\" />"),
    TELESCOPE(
        "telescope",
        "<path d=\"m10.065 12.493-6.18 1.318a.934.934 0 0 1-1.108-.702l-.537-2.15a1.07 1.07 0 0 1 .691-1.265l13.504-4.44\" />\n  <path d=\"m13.56 11.747 4.332-.924\" />\n  <path d=\"m16 21-3.105-6.21\" />\n  <path d=\"M16.485 5.94a2 2 0 0 1 1.455-2.425l1.09-.272a1 1 0 0 1 1.212.727l1.515 6.06a1 1 0 0 1-.727 1.213l-1.09.272a2 2 0 0 1-2.425-1.455z\" />\n  <path d=\"m6.158 8.633 1.114 4.456\" />\n  <path d=\"m8 21 3.105-6.21\" />\n  <circle cx=\"12\" cy=\"13\" r=\"2\" />"),
    TEST_TUBE(
        "test-tube",
        "<path d=\"M14.5 2v17.5c0 1.4-1.1 2.5-2.5 2.5c-1.4 0-2.5-1.1-2.5-2.5V2\" />\n  <path d=\"M8.5 2h7\" />\n  <path d=\"M14.5 16h-5\" />"),
    TEST_TUBE_DIAGONAL(
        "test-tube-diagonal",
        "<path d=\"M21 7 6.82 21.18a2.83 2.83 0 0 1-3.99-.01a2.83 2.83 0 0 1 0-4L17 3\" />\n  <path d=\"m16 2 6 6\" />\n  <path d=\"M12 16H4\" />"),
    TEST_TUBES(
        "test-tubes",
        "<path d=\"M9 2v17.5A2.5 2.5 0 0 1 6.5 22A2.5 2.5 0 0 1 4 19.5V2\" />\n  <path d=\"M20 2v17.5a2.5 2.5 0 0 1-2.5 2.5a2.5 2.5 0 0 1-2.5-2.5V2\" />\n  <path d=\"M3 2h7\" />\n  <path d=\"M14 2h7\" />\n  <path d=\"M9 16H4\" />\n  <path d=\"M20 16h-5\" />"),
    VIRUS(
        "virus",
        "<path d=\"M12 14.991h.01\" />\n  <path d=\"M12 22v-3\" />\n  <path d=\"M12 2v3\" />\n  <path d=\"M13 22h-2\" />\n  <path d=\"M13 2h-2\" />\n  <path d=\"M13.99 10H14\" />\n  <path d=\"m16.5 19.794-1-1.733\" />\n  <path d=\"m16.5 4.205-1 1.732\" />\n  <path d=\"m19.794 16.5-1.732-1\" />\n  <path d=\"m19.794 7.5-1.732 1\" />\n  <path d=\"M2 12h3\" />\n  <path d=\"M2 13v-2\" />\n  <path d=\"M22 12h-3\" />\n  <path d=\"M22 13v-2\" />\n  <path d=\"m4.206 16.5 1.732-1\" />\n  <path d=\"m4.206 7.5 1.732 1\" />\n  <path d=\"m7.5 19.794 1-1.733\" />\n  <path d=\"m7.5 4.205 1 1.732\" />\n  <path d=\"M9 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"7\" />"),
    VIRUS_OFF(
        "virus-off",
        "<path d=\"M10.01 10h.01\" />\n  <path d=\"M12 14.991h.01\" />\n  <path d=\"M12 22v-3\" />\n  <path d=\"M12 2v3\" />\n  <path d=\"M13 22h-2\" />\n  <path d=\"M13 2h-2\" />\n  <path d=\"m16.5 19.794-1-1.733\" />\n  <path d=\"m16.5 4.205-1 1.732\" />\n  <path d=\"M18.891 13.235a7 7 0 00-8.126-8.126\" />\n  <path d=\"m19.794 7.5-1.732 1\" />\n  <path d=\"M2 12h3\" />\n  <path d=\"M2 13v-2\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M22 12h-3\" />\n  <path d=\"M22 13v-2\" />\n  <path d=\"m4.206 16.5 1.732-1\" />\n  <path d=\"m4.206 7.5 1.732 1\" />\n  <path d=\"M7.05 7.05a7 7 0 009.9 9.9\" />\n  <path d=\"m7.5 19.794 1-1.733\" />\n  <path d=\"M9 12h.01\" />");

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
  default LucideIcon activity_science() {
    return LucideIcon.create(Icon.ACTIVITY);
  }

  default LucideIcon atom() {
    return LucideIcon.create(Icon.ATOM);
  }

  default LucideIcon beaker_science() {
    return LucideIcon.create(Icon.BEAKER);
  }

  default LucideIcon binoculars_science() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon biohazard() {
    return LucideIcon.create(Icon.BIOHAZARD);
  }

  default LucideIcon brain_science() {
    return LucideIcon.create(Icon.BRAIN);
  }

  default LucideIcon brain_circuit_science() {
    return LucideIcon.create(Icon.BRAIN_CIRCUIT);
  }

  default LucideIcon brain_cog_science() {
    return LucideIcon.create(Icon.BRAIN_COG);
  }

  default LucideIcon brain_off_science() {
    return LucideIcon.create(Icon.BRAIN_OFF);
  }

  default LucideIcon circle_gauge_science() {
    return LucideIcon.create(Icon.CIRCLE_GAUGE);
  }

  default LucideIcon circuit_board_science() {
    return LucideIcon.create(Icon.CIRCUIT_BOARD);
  }

  default LucideIcon eclipse_science() {
    return LucideIcon.create(Icon.ECLIPSE);
  }

  default LucideIcon equal_approximately_not_science() {
    return LucideIcon.create(Icon.EQUAL_APPROXIMATELY_NOT);
  }

  default LucideIcon flask_conical_science() {
    return LucideIcon.create(Icon.FLASK_CONICAL);
  }

  default LucideIcon flask_conical_off_science() {
    return LucideIcon.create(Icon.FLASK_CONICAL_OFF);
  }

  default LucideIcon flask_round_science() {
    return LucideIcon.create(Icon.FLASK_ROUND);
  }

  default LucideIcon galaxy() {
    return LucideIcon.create(Icon.GALAXY);
  }

  default LucideIcon gauge_science() {
    return LucideIcon.create(Icon.GAUGE);
  }

  default LucideIcon germ_science() {
    return LucideIcon.create(Icon.GERM);
  }

  default LucideIcon germ_off_science() {
    return LucideIcon.create(Icon.GERM_OFF);
  }

  default LucideIcon lambda_science() {
    return LucideIcon.create(Icon.LAMBDA);
  }

  default LucideIcon lens_science() {
    return LucideIcon.create(Icon.LENS);
  }

  default LucideIcon lens_concave_science() {
    return LucideIcon.create(Icon.LENS_CONCAVE);
  }

  default LucideIcon lens_convex_science() {
    return LucideIcon.create(Icon.LENS_CONVEX);
  }

  default LucideIcon microscope_science() {
    return LucideIcon.create(Icon.MICROSCOPE);
  }

  default LucideIcon mirror_rectangular_science() {
    return LucideIcon.create(Icon.MIRROR_RECTANGULAR);
  }

  default LucideIcon mirror_round_science() {
    return LucideIcon.create(Icon.MIRROR_ROUND);
  }

  default LucideIcon omega_science() {
    return LucideIcon.create(Icon.OMEGA);
  }

  default LucideIcon orbit() {
    return LucideIcon.create(Icon.ORBIT);
  }

  default LucideIcon phi_science() {
    return LucideIcon.create(Icon.PHI);
  }

  default LucideIcon pipette_science() {
    return LucideIcon.create(Icon.PIPETTE);
  }

  default LucideIcon radiation() {
    return LucideIcon.create(Icon.RADIATION);
  }

  default LucideIcon robot_arm_science() {
    return LucideIcon.create(Icon.ROBOT_ARM);
  }

  default LucideIcon satellite_science() {
    return LucideIcon.create(Icon.SATELLITE);
  }

  default LucideIcon scale_science() {
    return LucideIcon.create(Icon.SCALE);
  }

  default LucideIcon shell_science() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon sigma_science() {
    return LucideIcon.create(Icon.SIGMA);
  }

  default LucideIcon solar_panel_science() {
    return LucideIcon.create(Icon.SOLAR_PANEL);
  }

  default LucideIcon square_activity_science() {
    return LucideIcon.create(Icon.SQUARE_ACTIVITY);
  }

  default LucideIcon stethoscope_science() {
    return LucideIcon.create(Icon.STETHOSCOPE);
  }

  default LucideIcon syringe_science() {
    return LucideIcon.create(Icon.SYRINGE);
  }

  default LucideIcon telescope_science() {
    return LucideIcon.create(Icon.TELESCOPE);
  }

  default LucideIcon test_tube() {
    return LucideIcon.create(Icon.TEST_TUBE);
  }

  default LucideIcon test_tube_diagonal() {
    return LucideIcon.create(Icon.TEST_TUBE_DIAGONAL);
  }

  default LucideIcon test_tubes() {
    return LucideIcon.create(Icon.TEST_TUBES);
  }

  default LucideIcon virus_science() {
    return LucideIcon.create(Icon.VIRUS);
  }

  default LucideIcon virus_off_science() {
    return LucideIcon.create(Icon.VIRUS_OFF);
  }
}
