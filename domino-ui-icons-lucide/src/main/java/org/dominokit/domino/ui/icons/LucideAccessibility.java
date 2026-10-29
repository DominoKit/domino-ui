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

/** Lucide accessibility catalog category. */
public interface LucideAccessibility {
  enum Icon implements LucideIconDefinition {
    ACCESSIBILITY(
        "accessibility",
        "<circle cx=\"16\" cy=\"4\" r=\"1\" />\n  <path d=\"m18 19 1-7-6 1\" />\n  <path d=\"m5 8 3-3 5.5 3-2.36 3.5\" />\n  <path d=\"M4.24 14.5a5 5 0 0 0 6.88 6\" />\n  <path d=\"M13.76 17.5a5 5 0 0 0-6.88-6\" />"),
    AD(
        "ad",
        "<path d=\"M10 13H6\" />\n  <path d=\"M10 15v-4a2 2 0 0 0-4 0v4\" />\n  <path d=\"M14 14.5a.5.5 0 0 0 .5.5h1a2.5 2.5 0 0 0 2.5-2.5v-1A2.5 2.5 0 0 0 15.5 9h-1a.5.5 0 0 0-.5.5z\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    BABY(
        "baby",
        "<path d=\"M10 16c.5.3 1.2.5 2 .5s1.5-.2 2-.5\" />\n  <path d=\"M15 12h.01\" />\n  <path d=\"M19.38 6.813A9 9 0 0 1 20.8 10.2a2 2 0 0 1 0 3.6 9 9 0 0 1-17.6 0 2 2 0 0 1 0-3.6A9 9 0 0 1 12 3c2 0 3.5 1.1 3.5 2.5s-.9 2.5-2 2.5c-.8 0-1.5-.4-1.5-1\" />\n  <path d=\"M9 12h.01\" />"),
    BADGE_INFO(
        "badge-info",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <line x1=\"12\" x2=\"12\" y1=\"16\" y2=\"12\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"8\" y2=\"8\" />"),
    BADGE_QUESTION_MARK(
        "badge-question-mark",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3\" />\n  <line x1=\"12\" x2=\"12.01\" y1=\"17\" y2=\"17\" />"),
    CIRCLE_QUESTION_MARK(
        "circle-question-mark",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M9.09 9a3 3 0 0 1 5.83 1c0 2-3 3-3 3\" />\n  <path d=\"M12 17h.01\" />"),
    CLOSED_CAPTION(
        "closed-caption",
        "<path d=\"M10 9.17a3 3 0 1 0 0 5.66\" />\n  <path d=\"M17 9.17a3 3 0 1 0 0 5.66\" />\n  <rect x=\"2\" y=\"5\" width=\"20\" height=\"14\" rx=\"2\" />"),
    CONTRAST(
        "contrast",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 18a6 6 0 0 0 0-12v12z\" />"),
    EAR(
        "ear",
        "<path d=\"M6 8.5a6.5 6.5 0 1 1 13 0c0 6-6 6-6 10a3.5 3.5 0 1 1-7 0\" />\n  <path d=\"M15 8.5a2.5 2.5 0 0 0-5 0v1a2 2 0 1 1 0 4\" />"),
    EAR_OFF(
        "ear-off",
        "<path d=\"M6 18.5a3.5 3.5 0 1 0 7 0c0-1.57.92-2.52 2.04-3.46\" />\n  <path d=\"M6 8.5c0-.75.13-1.47.36-2.14\" />\n  <path d=\"M8.8 3.15A6.5 6.5 0 0 1 19 8.5c0 1.63-.44 2.81-1.09 3.76\" />\n  <path d=\"M12.5 6A2.5 2.5 0 0 1 15 8.5M10 13a2 2 0 0 0 1.82-1.18\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    ECLIPSE(
        "eclipse",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 2a7 7 0 1 0 10 10\" />"),
    EYE(
        "eye",
        "<path d=\"M2.062 12.348a1 1 0 0 1 0-.696 10.75 10.75 0 0 1 19.876 0 1 1 0 0 1 0 .696 10.75 10.75 0 0 1-19.876 0\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    EYE_CLOSED(
        "eye-closed",
        "<path d=\"m15 18-.722-3.25\" />\n  <path d=\"M2 8a10.645 10.645 0 0 0 20 0\" />\n  <path d=\"m20 15-1.726-2.05\" />\n  <path d=\"m4 15 1.726-2.05\" />\n  <path d=\"m9 18 .722-3.25\" />"),
    EYE_DASHED(
        "eye-dashed",
        "<path d=\"M13.054 18.946a11 11 0 0 1-2.11 0\" />\n  <path d=\"M13.054 5.054a11 11 0 0 0-2.11-.001\" />\n  <path d=\"M17.072 6.274a11 11 0 0 1 1.753 1.173\" />\n  <path d=\"M18.825 16.552a11 11 0 0 1-1.753 1.174\" />\n  <path d=\"M2.514 13.303a11 11 0 0 1-.452-.954 1 1 0 0 1 0-.697 11 11 0 0 1 .45-.955\" />\n  <path d=\"M21.485 10.697a11 11 0 0 1 .453.955 1 1 0 0 1 0 .697 11 11 0 0 1-.453.954\" />\n  <path d=\"M5.173 7.448a11 11 0 0 1 1.753-1.174\" />\n  <path d=\"M6.926 17.726a11 11 0 0 1-1.753-1.174\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    EYE_OFF(
        "eye-off",
        "<path d=\"M10.733 5.076a10.744 10.744 0 0 1 11.205 6.575 1 1 0 0 1 0 .696 10.747 10.747 0 0 1-1.444 2.49\" />\n  <path d=\"M14.084 14.158a3 3 0 0 1-4.242-4.242\" />\n  <path d=\"M17.479 17.499a10.75 10.75 0 0 1-15.417-5.151 1 1 0 0 1 0-.696 10.75 10.75 0 0 1 4.446-5.143\" />\n  <path d=\"m2 2 20 20\" />"),
    GLASSES(
        "glasses",
        "<circle cx=\"6\" cy=\"15\" r=\"4\" />\n  <circle cx=\"18\" cy=\"15\" r=\"4\" />\n  <path d=\"M14 15a2 2 0 0 0-2-2 2 2 0 0 0-2 2\" />\n  <path d=\"M2.5 13 5 7c.7-1.3 1.4-2 3-2\" />\n  <path d=\"M21.5 13 19 7c-.7-1.3-1.5-2-3-2\" />"),
    HAND(
        "hand",
        "<path d=\"M18 11V6a2 2 0 0 0-2-2a2 2 0 0 0-2 2\" />\n  <path d=\"M14 10V4a2 2 0 0 0-2-2a2 2 0 0 0-2 2v2\" />\n  <path d=\"M10 10.5V6a2 2 0 0 0-2-2a2 2 0 0 0-2 2v8\" />\n  <path d=\"M18 8a2 2 0 1 1 4 0v6a8 8 0 0 1-8 8h-2c-2.8 0-4.5-.86-5.99-2.34l-3.6-3.6a2 2 0 0 1 2.83-2.82L7 15\" />"),
    INFO(
        "info",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M12 16v-4\" />\n  <path d=\"M12 8h.01\" />"),
    LIFE_BUOY(
        "life-buoy",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m4.93 4.93 4.24 4.24\" />\n  <path d=\"m14.83 9.17 4.24-4.24\" />\n  <path d=\"m14.83 14.83 4.24 4.24\" />\n  <path d=\"m9.17 14.83-4.24 4.24\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    MOON(
        "moon",
        "<path d=\"M20.985 12.486a9 9 0 1 1-9.473-9.472c.405-.022.617.46.402.803a6 6 0 0 0 8.268 8.268c.344-.215.825-.004.803.401\" />"),
    MOON_STAR(
        "moon-star",
        "<path d=\"M18 5h4\" />\n  <path d=\"M20 3v4\" />\n  <path d=\"M20.985 12.486a9 9 0 1 1-9.473-9.472c.405-.022.617.46.402.803a6 6 0 0 0 8.268 8.268c.344-.215.825-.004.803.401\" />"),
    MOUTH(
        "mouth",
        "<path d=\"M2 12a50.5 50.5 0 0020 0 1 1 0 00-1-1\" />\n  <path d=\"M2.457 11.159a1 1 0 00-.307 1.369 11.59 11.59 0 0019.7 0 1 1 0 00-.308-1.368c-2.426-1.568-3.65-2.284-5.479-3.644a2.6 2.6 0 00-3.373.208 1 1 0 01-1.38 0 2.62 2.62 0 00-3.373-.208c-1.83 1.36-3.053 2.076-5.48 3.643\" />"),
    MOUTH_OFF(
        "mouth-off",
        "<path d=\"M13.074 7.417a2.6 2.6 0 012.989.099c1.829 1.36 3.053 2.076 5.479 3.644a1 1 0 01.308 1.368 11.6 11.6 0 01-1.617 2.05\" />\n  <path d=\"M2 12a50.5 50.5 0 0010.99.99\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 11a1 1 0 011 1 51 51 0 01-3.734.61\" />\n  <path d=\"M7.695 7.695c-1.7 1.247-2.92 1.967-5.238 3.464a1 1 0 00-.307 1.369 11.6 11.6 0 0014.766 4.388\" />"),
    PERSON_STANDING(
        "person-standing",
        "<circle cx=\"12\" cy=\"5\" r=\"1\" />\n  <path d=\"m9 20 3-6 3 6\" />\n  <path d=\"m6 8 6 2 6-2\" />\n  <path d=\"M12 10v4\" />"),
    SCAN_EYE(
        "scan-eye",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"1\" />\n  <path d=\"M18.944 12.33a1 1 0 0 0 0-.66 7.5 7.5 0 0 0-13.888 0 1 1 0 0 0 0 .66 7.5 7.5 0 0 0 13.888 0\" />"),
    SCAN_SEARCH(
        "scan-search",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"m16 16-1.9-1.9\" />"),
    SPEECH(
        "speech",
        "<path d=\"M8.8 20v-4.1l1.9.2a2.3 2.3 0 0 0 2.164-2.1V8.3A5.37 5.37 0 0 0 2 8.25c0 2.8.656 3.054 1 4.55a5.77 5.77 0 0 1 .029 2.758L2 20\" />\n  <path d=\"M19.8 17.8a7.5 7.5 0 0 0 .003-10.603\" />\n  <path d=\"M17 15a3.5 3.5 0 0 0-.025-4.975\" />"),
    SUN(
        "sun",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"m17.66 17.66 1.41 1.41\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m6.34 17.66-1.41 1.41\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />"),
    SUN_DIM(
        "sun-dim",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 4h.01\" />\n  <path d=\"M20 12h.01\" />\n  <path d=\"M12 20h.01\" />\n  <path d=\"M4 12h.01\" />\n  <path d=\"M17.657 6.343h.01\" />\n  <path d=\"M17.657 17.657h.01\" />\n  <path d=\"M6.343 17.657h.01\" />\n  <path d=\"M6.343 6.343h.01\" />"),
    SUN_MEDIUM(
        "sun-medium",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 3v1\" />\n  <path d=\"M12 20v1\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M20 12h1\" />\n  <path d=\"m18.364 5.636-.707.707\" />\n  <path d=\"m6.343 17.657-.707.707\" />\n  <path d=\"m5.636 5.636.707.707\" />\n  <path d=\"m17.657 17.657.707.707\" />"),
    SUN_MOON(
        "sun-moon",
        "<path d=\"M12 2v2\" />\n  <path d=\"M14.837 16.385a6 6 0 1 1-7.223-7.222c.624-.147.97.66.715 1.248a4 4 0 0 0 5.26 5.259c.589-.255 1.396.09 1.248.715\" />\n  <path d=\"M16 12a4 4 0 0 0-4-4\" />\n  <path d=\"m19 5-1.256 1.256\" />\n  <path d=\"M20 12h2\" />"),
    TRANSGENDER(
        "transgender",
        "<path d=\"M12 16v6\" />\n  <path d=\"M14 20h-4\" />\n  <path d=\"M18 2h4v4\" />\n  <path d=\"m2 2 7.17 7.17\" />\n  <path d=\"M2 5.355V2h3.357\" />\n  <path d=\"m22 2-7.17 7.17\" />\n  <path d=\"M8 5 5 8\" />\n  <circle cx=\"12\" cy=\"12\" r=\"4\" />"),
    ZOOM_IN(
        "zoom-in",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"11\" x2=\"11\" y1=\"8\" y2=\"14\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />"),
    ZOOM_OUT(
        "zoom-out",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <line x1=\"21\" x2=\"16.65\" y1=\"21\" y2=\"16.65\" />\n  <line x1=\"8\" x2=\"14\" y1=\"11\" y2=\"11\" />");

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
  default LucideIcon accessibility_accessibility() {
    return LucideIcon.create(Icon.ACCESSIBILITY);
  }

  default LucideIcon ad_accessibility() {
    return LucideIcon.create(Icon.AD);
  }

  default LucideIcon baby_accessibility() {
    return LucideIcon.create(Icon.BABY);
  }

  default LucideIcon badge_info_accessibility() {
    return LucideIcon.create(Icon.BADGE_INFO);
  }

  default LucideIcon badge_question_mark_accessibility() {
    return LucideIcon.create(Icon.BADGE_QUESTION_MARK);
  }

  default LucideIcon circle_question_mark_accessibility() {
    return LucideIcon.create(Icon.CIRCLE_QUESTION_MARK);
  }

  default LucideIcon closed_caption_accessibility() {
    return LucideIcon.create(Icon.CLOSED_CAPTION);
  }

  default LucideIcon contrast_accessibility() {
    return LucideIcon.create(Icon.CONTRAST);
  }

  default LucideIcon ear_accessibility() {
    return LucideIcon.create(Icon.EAR);
  }

  default LucideIcon ear_off_accessibility() {
    return LucideIcon.create(Icon.EAR_OFF);
  }

  default LucideIcon eclipse_accessibility() {
    return LucideIcon.create(Icon.ECLIPSE);
  }

  default LucideIcon eye_accessibility() {
    return LucideIcon.create(Icon.EYE);
  }

  default LucideIcon eye_closed_accessibility() {
    return LucideIcon.create(Icon.EYE_CLOSED);
  }

  default LucideIcon eye_dashed_accessibility() {
    return LucideIcon.create(Icon.EYE_DASHED);
  }

  default LucideIcon eye_off_accessibility() {
    return LucideIcon.create(Icon.EYE_OFF);
  }

  default LucideIcon glasses() {
    return LucideIcon.create(Icon.GLASSES);
  }

  default LucideIcon hand_accessibility() {
    return LucideIcon.create(Icon.HAND);
  }

  default LucideIcon info_accessibility() {
    return LucideIcon.create(Icon.INFO);
  }

  default LucideIcon life_buoy_accessibility() {
    return LucideIcon.create(Icon.LIFE_BUOY);
  }

  default LucideIcon moon() {
    return LucideIcon.create(Icon.MOON);
  }

  default LucideIcon moon_star_accessibility() {
    return LucideIcon.create(Icon.MOON_STAR);
  }

  default LucideIcon mouth_accessibility() {
    return LucideIcon.create(Icon.MOUTH);
  }

  default LucideIcon mouth_off_accessibility() {
    return LucideIcon.create(Icon.MOUTH_OFF);
  }

  default LucideIcon person_standing_accessibility() {
    return LucideIcon.create(Icon.PERSON_STANDING);
  }

  default LucideIcon scan_eye_accessibility() {
    return LucideIcon.create(Icon.SCAN_EYE);
  }

  default LucideIcon scan_search_accessibility() {
    return LucideIcon.create(Icon.SCAN_SEARCH);
  }

  default LucideIcon speech_accessibility() {
    return LucideIcon.create(Icon.SPEECH);
  }

  default LucideIcon sun_accessibility() {
    return LucideIcon.create(Icon.SUN);
  }

  default LucideIcon sun_dim_accessibility() {
    return LucideIcon.create(Icon.SUN_DIM);
  }

  default LucideIcon sun_medium_accessibility() {
    return LucideIcon.create(Icon.SUN_MEDIUM);
  }

  default LucideIcon sun_moon() {
    return LucideIcon.create(Icon.SUN_MOON);
  }

  default LucideIcon transgender_accessibility() {
    return LucideIcon.create(Icon.TRANSGENDER);
  }

  default LucideIcon zoom_in_accessibility() {
    return LucideIcon.create(Icon.ZOOM_IN);
  }

  default LucideIcon zoom_out_accessibility() {
    return LucideIcon.create(Icon.ZOOM_OUT);
  }
}
