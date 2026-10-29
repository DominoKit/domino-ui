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

/** Lucide medical catalog category. */
public interface LucideMedical {
  enum Icon implements LucideIconDefinition {
    ACCESSIBILITY(
        "accessibility",
        "<circle cx=\"16\" cy=\"4\" r=\"1\" />\n  <path d=\"m18 19 1-7-6 1\" />\n  <path d=\"m5 8 3-3 5.5 3-2.36 3.5\" />\n  <path d=\"M4.24 14.5a5 5 0 0 0 6.88 6\" />\n  <path d=\"M13.76 17.5a5 5 0 0 0-6.88-6\" />"),
    ACTIVITY(
        "activity",
        "<path d=\"M22 12h-2.48a2 2 0 0 0-1.93 1.46l-2.35 8.36a.25.25 0 0 1-.48 0L9.24 2.18a.25.25 0 0 0-.48 0l-2.35 8.36A2 2 0 0 1 4.49 12H2\" />"),
    AMBULANCE(
        "ambulance",
        "<path d=\"M10 10H6\" />\n  <path d=\"M14 18V6a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2v11a1 1 0 0 0 1 1h2\" />\n  <path d=\"M19 18h2a1 1 0 0 0 1-1v-3.28a1 1 0 0 0-.684-.948l-1.923-.641a1 1 0 0 1-.578-.502l-1.539-3.076A1 1 0 0 0 16.382 8H14\" />\n  <path d=\"M8 8v4\" />\n  <path d=\"M9 18h6\" />\n  <circle cx=\"17\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"18\" r=\"2\" />"),
    BANDAGE(
        "bandage",
        "<path d=\"M10 10.01h.01\" />\n  <path d=\"M10 14.01h.01\" />\n  <path d=\"M14 10.01h.01\" />\n  <path d=\"M14 14.01h.01\" />\n  <path d=\"M18 6v12\" />\n  <path d=\"M6 6v12\" />\n  <rect x=\"2\" y=\"6\" width=\"20\" height=\"12\" rx=\"2\" />"),
    BONE(
        "bone",
        "<path d=\"M17 10c.7-.7 1.69 0 2.5 0a2.5 2.5 0 1 0 0-5 .5.5 0 0 1-.5-.5 2.5 2.5 0 1 0-5 0c0 .81.7 1.8 0 2.5l-7 7c-.7.7-1.69 0-2.5 0a2.5 2.5 0 0 0 0 5c.28 0 .5.22.5.5a2.5 2.5 0 1 0 5 0c0-.81-.7-1.8 0-2.5Z\" />"),
    BONE_FRACTURE(
        "bone-fracture",
        "<path d=\"M14 4.5a1 1 0 0 1 5 0 .5.5 0 0 0 .5.5 1 1 0 0 1 0 5c-.81 0-1.8-.7-2.5 0l-1.958 1.957a.15.15 0 0 1-.252-.072l-.493-2.07a.15.15 0 0 0-.111-.112l-2.072-.494a.15.15 0 0 1-.072-.252L14 7c.7-.7 0-1.69 0-2.5\" />\n  <path d=\"m16 20-1-2\" />\n  <path d=\"m20 16-2-1\" />\n  <path d=\"m4 8 2 1\" />\n  <path d=\"m8 4 1 2\" />\n  <path d=\"M9.698 14.19a.15.15 0 0 0 .112.112l2.074.489a.15.15 0 0 1 .072.252L10 17c-.7.7 0 1.69 0 2.5a1 1 0 0 1-5 0 .495.495 0 0 0-.5-.5 1 1 0 0 1 0-5c.81 0 1.8.7 2.5 0l1.956-1.957a.15.15 0 0 1 .252.072z\" />"),
    BRAIN(
        "brain",
        "<path d=\"M12 18V5\" />\n  <path d=\"M15 13a4.17 4.17 0 01-3-4 4.17 4.17 0 01-3 4\" />\n  <path d=\"M17.707 6.294A3 3 0 1012 5a3 3 0 10-5.707 1.294\" />\n  <path d=\"M17.996 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M18 18a4 4 0 002-7.465\" />\n  <path d=\"M19.967 17.482a4 4 0 11-7.967.517 4 4 0 11-7.967-.517\" />\n  <path d=\"M6 18a4 4 0 01-2-7.465\" />\n  <path d=\"M6.004 5.125a4 4 0 00-2.526 5.77\" />"),
    BRAIN_OFF(
        "brain-off",
        "<path d=\"M12 18v-6\" />\n  <path d=\"M12 5v1.344\" />\n  <path d=\"M17.707 6.293A3 3 0 1012 5a3 3 0 00-4.124-2.781\" />\n  <path d=\"M17.997 5.125a4 4 0 012.526 5.77\" />\n  <path d=\"M19.644 19.644A4 4 0 0112 18a4 4 0 11-7.967-.517\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20 10.536a4 4 0 011.533 5.34\" />\n  <path d=\"M3.477 10.895a4 4 0 011.876-5.542\" />\n  <path d=\"M6 18a4 4 0 01-2-7.464\" />\n  <path d=\"M9 13a4.17 4.17 0 002.166-1.5 4 4 0 00.138-.196\" />"),
    BRIEFCASE_MEDICAL(
        "briefcase-medical",
        "<path d=\"M12 11v4\" />\n  <path d=\"M14 13h-4\" />\n  <path d=\"M16 6V4a2 2 0 0 0-2-2h-4a2 2 0 0 0-2 2v2\" />\n  <path d=\"M18 6v14\" />\n  <path d=\"M6 6v14\" />\n  <rect width=\"20\" height=\"14\" x=\"2\" y=\"6\" rx=\"2\" />"),
    CIGARETTE(
        "cigarette",
        "<path d=\"M17 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h14\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M21 16a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    CIGARETTE_OFF(
        "cigarette-off",
        "<path d=\"M12 12H3a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h13\" />\n  <path d=\"M18 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 12a1 1 0 0 1 1 1v2a1 1 0 0 1-.5.866\" />\n  <path d=\"M22 8c0-2.5-2-2.5-2-5\" />\n  <path d=\"M7 12v4\" />"),
    CIRCLE_SMALL("circle-small", "<circle cx=\"12\" cy=\"12\" r=\"6\" />"),
    CLIPBOARD_MINUS(
        "clipboard-minus",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M9 14h6\" />"),
    CLIPBOARD_PLUS(
        "clipboard-plus",
        "<rect width=\"8\" height=\"4\" x=\"8\" y=\"2\" rx=\"1\" ry=\"1\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v14a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2V6a2 2 0 0 1 2-2h2\" />\n  <path d=\"M9 14h6\" />\n  <path d=\"M12 17v-6\" />"),
    DNA(
        "dna",
        "<path d=\"m10 16 1.5 1.5\" />\n  <path d=\"m14 8-1.5-1.5\" />\n  <path d=\"M15 2c-1.798 1.998-2.518 3.995-2.807 5.993\" />\n  <path d=\"m16.5 10.5 1 1\" />\n  <path d=\"m17 6-2.891-2.891\" />\n  <path d=\"M2 15c6.667-6 13.333 0 20-6\" />\n  <path d=\"m20 9 .891.891\" />\n  <path d=\"M3.109 14.109 4 15\" />\n  <path d=\"m6.5 12.5 1 1\" />\n  <path d=\"m7 18 2.891 2.891\" />\n  <path d=\"M9 22c1.798-1.998 2.518-3.995 2.807-5.993\" />"),
    DNA_OFF(
        "dna-off",
        "<path d=\"M15 2c-1.35 1.5-2.092 3-2.5 4.5L14 8\" />\n  <path d=\"m17 6-2.891-2.891\" />\n  <path d=\"M2 15c3.333-3 6.667-3 10-3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m20 9 .891.891\" />\n  <path d=\"M22 9c-1.5 1.35-3 2.092-4.5 2.5l-1-1\" />\n  <path d=\"M3.109 14.109 4 15\" />\n  <path d=\"m6.5 12.5 1 1\" />\n  <path d=\"m7 18 2.891 2.891\" />\n  <path d=\"M9 22c1.35-1.5 2.092-3 2.5-4.5L10 16\" />"),
    EAR(
        "ear",
        "<path d=\"M6 8.5a6.5 6.5 0 1 1 13 0c0 6-6 6-6 10a3.5 3.5 0 1 1-7 0\" />\n  <path d=\"M15 8.5a2.5 2.5 0 0 0-5 0v1a2 2 0 1 1 0 4\" />"),
    EAR_OFF(
        "ear-off",
        "<path d=\"M6 18.5a3.5 3.5 0 1 0 7 0c0-1.57.92-2.52 2.04-3.46\" />\n  <path d=\"M6 8.5c0-.75.13-1.47.36-2.14\" />\n  <path d=\"M8.8 3.15A6.5 6.5 0 0 1 19 8.5c0 1.63-.44 2.81-1.09 3.76\" />\n  <path d=\"M12.5 6A2.5 2.5 0 0 1 15 8.5M10 13a2 2 0 0 0 1.82-1.18\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    FINGERPRINT_PATTERN(
        "fingerprint-pattern",
        "<path d=\"M12 10a2 2 0 0 0-2 2c0 1.02-.1 2.51-.26 4\" />\n  <path d=\"M14 13.12c0 2.38 0 6.38-1 8.88\" />\n  <path d=\"M17.29 21.02c.12-.6.43-2.3.5-3.02\" />\n  <path d=\"M2 12a10 10 0 0 1 18-6\" />\n  <path d=\"M2 16h.01\" />\n  <path d=\"M21.8 16c.2-2 .131-5.354 0-6\" />\n  <path d=\"M5 19.5C5.5 18 6 15 6 12a6 6 0 0 1 .34-2\" />\n  <path d=\"M8.65 22c.21-.66.45-1.32.57-2\" />\n  <path d=\"M9 6.8a6 6 0 0 1 9 5.2v2\" />"),
    GERM(
        "germ",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m22 16-2.474-2.13\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />\n  <path d=\"M9.33 7.035c-.51 1.478-1.786 2.93-3.09 3.794A5 5 0 009 20a12.1 12.1 0 0011.902-9.916A6 6 0 009.33 7.035\" />\n  <circle cx=\"15\" cy=\"9\" r=\"2\" />"),
    GERM_OFF(
        "germ-off",
        "<path d=\"m11 2 .925 1.848\" />\n  <path d=\"M13 15h.01\" />\n  <path d=\"M13.424 7.768a2 2 0 112.808 2.808\" />\n  <path d=\"m16 21-1-2.472\" />\n  <path d=\"M16.988 16.988A12 12 0 019 20a5 5 0 01-2.759-9.171 8.8 8.8 0 002.307-2.28\" />\n  <path d=\"m19 2-1 1.804\" />\n  <path d=\"m2 19 2.746-1.373\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m22 16-2.474-2.13a12 12 0 001.376-3.786 6 6 0 00-10.313-5.151\" />\n  <path d=\"m22 5-1.804 1\" />\n  <path d=\"m3 10 2 2\" />\n  <path d=\"M9 16h.01\" />\n  <path d=\"M9 20v2\" />"),
    HEART(
        "heart",
        "<path d=\"M2 9.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5l-5.492 5.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5\" />"),
    HEART_MINUS(
        "heart-minus",
        "<path d=\"m14.876 18.99-1.368 1.323a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5a5.2 5.2 0 0 1-.244 1.572\" />\n  <path d=\"M15 15h6\" />"),
    HEART_PLUS(
        "heart-plus",
        "<path d=\"m14.479 19.374-.971.939a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5a5.2 5.2 0 0 1-.219 1.49\" />\n  <path d=\"M15 15h6\" />\n  <path d=\"M18 12v6\" />"),
    HEART_PULSE(
        "heart-pulse",
        "<path d=\"M2 9.5a5.5 5.5 0 0 1 9.591-3.676.56.56 0 0 0 .818 0A5.49 5.49 0 0 1 22 9.5c0 2.29-1.5 4-3 5.5l-5.492 5.313a2 2 0 0 1-3 .019L5 15c-1.5-1.5-3-3.2-3-5.5\" />\n  <path d=\"M3.22 13H9.5l.5-1 2 4.5 2-7 1.5 3.5h5.27\" />"),
    HOSPITAL(
        "hospital",
        "<path d=\"M12 7v4\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M14 9h-4\" />\n  <path d=\"M18 11h2a2 2 0 0 1 2 2v6a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-9a2 2 0 0 1 2-2h2\" />\n  <path d=\"M18 21V5a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16\" />"),
    HOUSE_HEART(
        "house-heart",
        "<path d=\"M8.62 13.8A2.25 2.25 0 1 1 12 10.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a.998.998 0 0 1-1.507 0z\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    HOUSE_PLUS(
        "house-plus",
        "<path d=\"M12.35 21H5a2 2 0 0 1-2-2v-9a2 2 0 0 1 .71-1.53l7-6a2 2 0 0 1 2.58 0l7 6A2 2 0 0 1 21 10v2.35\" />\n  <path d=\"M14.8 12.4A1 1 0 0 0 14 12h-4a1 1 0 0 0-1 1v8\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    IV_BAG(
        "iv-bag",
        "<path d=\"M12 18v2a2 2 0 002 2h6\" />\n  <path d=\"M6 11c.72.5 1.44 1 3 1 3 0 3-2 6-2 1.56 0 2.28.5 3 1\" />\n  <path d=\"M9.293 3c.453 0 .887-.18 1.207-.5s.754-.5 1.207-.5h.586c.453 0 .887.18 1.207.5s.754.5 1.207.5H16a2 2 0 012 2v11a2 2 0 01-2 2H8a2 2 0 01-2-2V5a2 2 0 012-2z\" />"),
    LIFE_BUOY(
        "life-buoy",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m4.93 4.93 4.24 4.24\" />\n  <path d=\"m14.83 9.17 4.24-4.24\" />\n  <path d=\"m14.83 14.83 4.24 4.24\" />\n  <path d=\"m9.17 14.83-4.24 4.24\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    MARS(
        "mars",
        "<path d=\"M16 3h5v5\" />\n  <path d=\"m21 3-6.75 6.75\" />\n  <circle cx=\"10\" cy=\"14\" r=\"6\" />"),
    MARS_STROKE(
        "mars-stroke",
        "<path d=\"m14 6 4 4\" />\n  <path d=\"M17 3h4v4\" />\n  <path d=\"m21 3-7.75 7.75\" />\n  <circle cx=\"9\" cy=\"15\" r=\"6\" />"),
    MICROSCOPE(
        "microscope",
        "<path d=\"M6 18h8\" />\n  <path d=\"M3 22h18\" />\n  <path d=\"M14 22a7 7 0 1 0 0-14h-1\" />\n  <path d=\"M9 14h2\" />\n  <path d=\"M9 12a2 2 0 0 1-2-2V6h6v4a2 2 0 0 1-2 2Z\" />\n  <path d=\"M12 6V3a1 1 0 0 0-1-1H9a1 1 0 0 0-1 1v3\" />"),
    MOUTH(
        "mouth",
        "<path d=\"M2 12a50.5 50.5 0 0020 0 1 1 0 00-1-1\" />\n  <path d=\"M2.457 11.159a1 1 0 00-.307 1.369 11.59 11.59 0 0019.7 0 1 1 0 00-.308-1.368c-2.426-1.568-3.65-2.284-5.479-3.644a2.6 2.6 0 00-3.373.208 1 1 0 01-1.38 0 2.62 2.62 0 00-3.373-.208c-1.83 1.36-3.053 2.076-5.48 3.643\" />"),
    MOUTH_OFF(
        "mouth-off",
        "<path d=\"M13.074 7.417a2.6 2.6 0 012.989.099c1.829 1.36 3.053 2.076 5.479 3.644a1 1 0 01.308 1.368 11.6 11.6 0 01-1.617 2.05\" />\n  <path d=\"M2 12a50.5 50.5 0 0010.99.99\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 11a1 1 0 011 1 51 51 0 01-3.734.61\" />\n  <path d=\"M7.695 7.695c-1.7 1.247-2.92 1.967-5.238 3.464a1 1 0 00-.307 1.369 11.6 11.6 0 0014.766 4.388\" />"),
    NON_BINARY(
        "non-binary",
        "<path d=\"M12 2v10\" />\n  <path d=\"m8.5 4 7 4\" />\n  <path d=\"m8.5 8 7-4\" />\n  <circle cx=\"12\" cy=\"17\" r=\"5\" />"),
    PILL(
        "pill",
        "<path d=\"m10.5 20.5 10-10a4.95 4.95 0 1 0-7-7l-10 10a4.95 4.95 0 1 0 7 7Z\" />\n  <path d=\"m8.5 8.5 7 7\" />"),
    PILL_BOTTLE(
        "pill-bottle",
        "<path d=\"M18 11h-4a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h4\" />\n  <path d=\"M6 7v13a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V7\" />\n  <rect width=\"16\" height=\"5\" x=\"4\" y=\"2\" rx=\"1\" />"),
    RIBBON(
        "ribbon",
        "<path d=\"M12 11.22C11 9.997 10 9 10 8a2 2 0 0 1 4 0c0 1-.998 2.002-2.01 3.22\" />\n  <path d=\"m12 18 2.57-3.5\" />\n  <path d=\"M6.243 9.016a7 7 0 0 1 11.507-.009\" />\n  <path d=\"M9.35 14.53 12 11.22\" />\n  <path d=\"M9.35 14.53C7.728 12.246 6 10.221 6 7a6 5 0 0 1 12 0c-.005 3.22-1.778 5.235-3.43 7.5l3.557 4.527a1 1 0 0 1-.203 1.43l-1.894 1.36a1 1 0 0 1-1.384-.215L12 18l-2.679 3.593a1 1 0 0 1-1.39.213l-1.865-1.353a1 1 0 0 1-.203-1.422z\" />"),
    SCAN_HEART(
        "scan-heart",
        "<path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M7.828 13.07A3 3 0 0 1 12 8.764a3 3 0 0 1 4.172 4.306l-3.447 3.62a1 1 0 0 1-1.449 0z\" />"),
    SHIELD_PLUS(
        "shield-plus",
        "<path d=\"M20 13c0 5-3.5 7.5-7.66 8.95a1 1 0 0 1-.67-.01C7.5 20.5 4 18 4 13V6a1 1 0 0 1 1-1c2 0 4.5-1.2 6.24-2.72a1.17 1.17 0 0 1 1.52 0C14.51 3.81 17 5 19 5a1 1 0 0 1 1 1z\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M12 9v6\" />"),
    SIREN(
        "siren",
        "<path d=\"M7 18v-6a5 5 0 1 1 10 0v6\" />\n  <path d=\"M5 21a1 1 0 0 0 1 1h12a1 1 0 0 0 1-1v-1a2 2 0 0 0-2-2H7a2 2 0 0 0-2 2z\" />\n  <path d=\"M21 12h1\" />\n  <path d=\"M18.5 4.5 18 5\" />\n  <path d=\"M2 12h1\" />\n  <path d=\"M12 2v1\" />\n  <path d=\"m4.929 4.929.707.707\" />\n  <path d=\"M12 12v6\" />"),
    SQUARE_ACTIVITY(
        "square-activity",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M17 12h-2l-2 5-2-10-2 5H7\" />"),
    STETHOSCOPE(
        "stethoscope",
        "<path d=\"M11 2v2\" />\n  <path d=\"M5 2v2\" />\n  <path d=\"M5 3H4a2 2 0 0 0-2 2v4a6 6 0 0 0 12 0V5a2 2 0 0 0-2-2h-1\" />\n  <path d=\"M8 15a6 6 0 0 0 12 0v-3\" />\n  <circle cx=\"20\" cy=\"10\" r=\"2\" />"),
    SYRINGE(
        "syringe",
        "<path d=\"m18 2 4 4\" />\n  <path d=\"m17 7 3-3\" />\n  <path d=\"M19 9 8.7 19.3c-1 1-2.5 1-3.4 0l-.6-.6c-1-1-1-2.5 0-3.4L15 5\" />\n  <path d=\"m9 11 4 4\" />\n  <path d=\"m5 19-3 3\" />\n  <path d=\"m14 4 6 6\" />"),
    TABLETS(
        "tablets",
        "<circle cx=\"7\" cy=\"7\" r=\"5\" />\n  <circle cx=\"17\" cy=\"17\" r=\"5\" />\n  <path d=\"M12 17h10\" />\n  <path d=\"m3.46 10.54 7.08-7.08\" />"),
    TOOTHBRUSH(
        "toothbrush",
        "<path d=\"M15 11c-2 2-4 2-6 4l-7 7\" />\n  <path d=\"m22 4-7.414 7.414-2-2A2 2 0 0114 6c0-.512.196-1.024.586-1.414A2 2 0 0116 4a2 2 0 013.262-1.552l2.152 2.138\" />"),
    TOOTHBRUSH_SPARKLES(
        "toothbrush-sparkles",
        "<path d=\"M10 3H8\" />\n  <path d=\"M14.586 11.414 22 4\" />\n  <path d=\"M15 11a8 8 0 01-.429.4\" />\n  <path d=\"m2 22 7-7c1.857-1.857 3.714-1.99 5.571-3.6l-1.985-1.986A2 2 0 0114 6a2 2 0 012-2 2 2 0 013.262-1.552l2.152 2.138\" />\n  <path d=\"M20 15v4\" />\n  <path d=\"M22 17h-4\" />\n  <path d=\"M4 5v4\" />\n  <path d=\"M6 7H2\" />\n  <path d=\"M9 2v2\" />"),
    TRANSGENDER(
        "transgender",
        "<path d=\"M12 16v6\" />\n  <path d=\"M14 20h-4\" />\n  <path d=\"M18 2h4v4\" />\n  <path d=\"m2 2 7.17 7.17\" />\n  <path d=\"M2 5.355V2h3.357\" />\n  <path d=\"m22 2-7.17 7.17\" />\n  <path d=\"M8 5 5 8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    TUBE_LOTION(
        "tube-lotion",
        "<path d=\"M15 18v3a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-3\" />\n  <path d=\"M17 2a2 2 0 0 1 1.6 3.2A8 8 0 0 0 17 10v6a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2v-6a8 8 0 0 0-1.6-4.8A2 2 0 0 1 7 2z\" />\n  <path d=\"M7 10a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />"),
    VENUS(
        "venus",
        "<path d=\"M12 15v7\" />\n  <path d=\"M9 19h6\" />\n  <circle cx=\"12\" cy=\"9\" r=\"6\" />"),
    VENUS_AND_MARS(
        "venus-and-mars",
        "<path d=\"M10 20h4\" />\n  <path d=\"M12 16v6\" />\n  <path d=\"M17 2h4v4\" />\n  <path d=\"m21 2-5.46 5.46\" />\n  <circle cx=\"12\" cy=\"11\" r=\"5\" />"),
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
  default LucideIcon accessibility_medical() {
    return LucideIcon.create(Icon.ACCESSIBILITY);
  }

  default LucideIcon activity_medical() {
    return LucideIcon.create(Icon.ACTIVITY);
  }

  default LucideIcon ambulance_medical() {
    return LucideIcon.create(Icon.AMBULANCE);
  }

  default LucideIcon bandage() {
    return LucideIcon.create(Icon.BANDAGE);
  }

  default LucideIcon bone_medical() {
    return LucideIcon.create(Icon.BONE);
  }

  default LucideIcon bone_fracture_medical() {
    return LucideIcon.create(Icon.BONE_FRACTURE);
  }

  default LucideIcon brain_medical() {
    return LucideIcon.create(Icon.BRAIN);
  }

  default LucideIcon brain_off_medical() {
    return LucideIcon.create(Icon.BRAIN_OFF);
  }

  default LucideIcon briefcase_medical_medical() {
    return LucideIcon.create(Icon.BRIEFCASE_MEDICAL);
  }

  default LucideIcon cigarette_medical() {
    return LucideIcon.create(Icon.CIGARETTE);
  }

  default LucideIcon cigarette_off_medical() {
    return LucideIcon.create(Icon.CIGARETTE_OFF);
  }

  default LucideIcon circle_small_medical() {
    return LucideIcon.create(Icon.CIRCLE_SMALL);
  }

  default LucideIcon clipboard_minus_medical() {
    return LucideIcon.create(Icon.CLIPBOARD_MINUS);
  }

  default LucideIcon clipboard_plus_medical() {
    return LucideIcon.create(Icon.CLIPBOARD_PLUS);
  }

  default LucideIcon dna() {
    return LucideIcon.create(Icon.DNA);
  }

  default LucideIcon dna_off() {
    return LucideIcon.create(Icon.DNA_OFF);
  }

  default LucideIcon ear_medical() {
    return LucideIcon.create(Icon.EAR);
  }

  default LucideIcon ear_off_medical() {
    return LucideIcon.create(Icon.EAR_OFF);
  }

  default LucideIcon fingerprint_pattern_medical() {
    return LucideIcon.create(Icon.FINGERPRINT_PATTERN);
  }

  default LucideIcon germ_medical() {
    return LucideIcon.create(Icon.GERM);
  }

  default LucideIcon germ_off_medical() {
    return LucideIcon.create(Icon.GERM_OFF);
  }

  default LucideIcon heart_medical() {
    return LucideIcon.create(Icon.HEART);
  }

  default LucideIcon heart_minus_medical() {
    return LucideIcon.create(Icon.HEART_MINUS);
  }

  default LucideIcon heart_plus_medical() {
    return LucideIcon.create(Icon.HEART_PLUS);
  }

  default LucideIcon heart_pulse() {
    return LucideIcon.create(Icon.HEART_PULSE);
  }

  default LucideIcon hospital_medical() {
    return LucideIcon.create(Icon.HOSPITAL);
  }

  default LucideIcon house_heart_medical() {
    return LucideIcon.create(Icon.HOUSE_HEART);
  }

  default LucideIcon house_plus_medical() {
    return LucideIcon.create(Icon.HOUSE_PLUS);
  }

  default LucideIcon iv_bag() {
    return LucideIcon.create(Icon.IV_BAG);
  }

  default LucideIcon life_buoy_medical() {
    return LucideIcon.create(Icon.LIFE_BUOY);
  }

  default LucideIcon mars() {
    return LucideIcon.create(Icon.MARS);
  }

  default LucideIcon mars_stroke() {
    return LucideIcon.create(Icon.MARS_STROKE);
  }

  default LucideIcon microscope_medical() {
    return LucideIcon.create(Icon.MICROSCOPE);
  }

  default LucideIcon mouth_medical() {
    return LucideIcon.create(Icon.MOUTH);
  }

  default LucideIcon mouth_off_medical() {
    return LucideIcon.create(Icon.MOUTH_OFF);
  }

  default LucideIcon non_binary() {
    return LucideIcon.create(Icon.NON_BINARY);
  }

  default LucideIcon pill() {
    return LucideIcon.create(Icon.PILL);
  }

  default LucideIcon pill_bottle() {
    return LucideIcon.create(Icon.PILL_BOTTLE);
  }

  default LucideIcon ribbon_medical() {
    return LucideIcon.create(Icon.RIBBON);
  }

  default LucideIcon scan_heart() {
    return LucideIcon.create(Icon.SCAN_HEART);
  }

  default LucideIcon shield_plus_medical() {
    return LucideIcon.create(Icon.SHIELD_PLUS);
  }

  default LucideIcon siren() {
    return LucideIcon.create(Icon.SIREN);
  }

  default LucideIcon square_activity_medical() {
    return LucideIcon.create(Icon.SQUARE_ACTIVITY);
  }

  default LucideIcon stethoscope_medical() {
    return LucideIcon.create(Icon.STETHOSCOPE);
  }

  default LucideIcon syringe_medical() {
    return LucideIcon.create(Icon.SYRINGE);
  }

  default LucideIcon tablets() {
    return LucideIcon.create(Icon.TABLETS);
  }

  default LucideIcon toothbrush_medical() {
    return LucideIcon.create(Icon.TOOTHBRUSH);
  }

  default LucideIcon toothbrush_sparkles_medical() {
    return LucideIcon.create(Icon.TOOTHBRUSH_SPARKLES);
  }

  default LucideIcon transgender_medical() {
    return LucideIcon.create(Icon.TRANSGENDER);
  }

  default LucideIcon tube_lotion_medical() {
    return LucideIcon.create(Icon.TUBE_LOTION);
  }

  default LucideIcon venus() {
    return LucideIcon.create(Icon.VENUS);
  }

  default LucideIcon venus_and_mars() {
    return LucideIcon.create(Icon.VENUS_AND_MARS);
  }

  default LucideIcon virus_medical() {
    return LucideIcon.create(Icon.VIRUS);
  }

  default LucideIcon virus_off_medical() {
    return LucideIcon.create(Icon.VIRUS_OFF);
  }
}
