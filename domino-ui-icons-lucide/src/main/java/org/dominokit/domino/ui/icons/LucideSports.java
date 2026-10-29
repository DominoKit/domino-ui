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

/** Lucide sports catalog category. */
public interface LucideSports {
  enum Icon implements LucideIconDefinition {
    AWARD(
        "award",
        "<path d=\"m15.477 12.89 1.515 8.526a.5.5 0 0 1-.81.47l-3.58-2.687a1 1 0 0 0-1.197 0l-3.586 2.686a.5.5 0 0 1-.81-.469l1.514-8.526\" />\n  <circle cx=\"12\" cy=\"8\" r=\"6\" />"),
    CIRCLE_GAUGE(
        "circle-gauge",
        "<path d=\"M15.6 2.7a10 10 0 1 0 5.7 5.7\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M13.4 10.6 19 5\" />"),
    CIRCLE_STAR(
        "circle-star",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M11.051 7.616a1 1 0 0 1 1.909.024l.737 1.452a1 1 0 0 0 .737.535l1.634.256a1 1 0 0 1 .588 1.806l-1.172 1.168a1 1 0 0 0-.282.866l.259 1.613a1 1 0 0 1-1.541 1.134l-1.465-.75a1 1 0 0 0-.912 0l-1.465.75a1 1 0 0 1-1.539-1.133l.258-1.613a1 1 0 0 0-.282-.867l-1.156-1.152a1 1 0 0 1 .572-1.822l1.633-.256a1 1 0 0 0 .737-.535z\" />"),
    DUMBBELL(
        "dumbbell",
        "<path d=\"M17.596 12.768a2 2 0 1 0 2.829-2.829l-1.768-1.767a2 2 0 0 0 2.828-2.829l-2.828-2.828a2 2 0 0 0-2.829 2.828l-1.767-1.768a2 2 0 1 0-2.829 2.829z\" />\n  <path d=\"m2.5 21.5 1.4-1.4\" />\n  <path d=\"m20.1 3.9 1.4-1.4\" />\n  <path d=\"M5.343 21.485a2 2 0 1 0 2.829-2.828l1.767 1.768a2 2 0 1 0 2.829-2.829l-6.364-6.364a2 2 0 1 0-2.829 2.829l1.768 1.767a2 2 0 0 0-2.828 2.829z\" />\n  <path d=\"m9.6 14.4 4.8-4.8\" />"),
    FISHING_HOOK(
        "fishing-hook",
        "<path d=\"m17.586 11.414-5.93 5.93a1 1 0 0 1-8-8l3.137-3.137a.707.707 0 0 1 1.207.5V10\" />\n  <path d=\"M20.414 8.586 22 7\" />\n  <circle cx=\"19\" cy=\"10\" r=\"2\" />"),
    FISHING_ROD(
        "fishing-rod",
        "<path d=\"M4 11h1\" />\n  <path d=\"M8 15a2 2 0 0 1-4 0V3a1 1 0 0 1 1-1h.5C14 2 20 9 20 18v4\" />\n  <circle cx=\"18\" cy=\"18\" r=\"2\" />"),
    GAUGE("gauge", "<path d=\"m12 14 4-4\" />\n  <path d=\"M3.34 19a10 10 0 1 1 17.32 0\" />"),
    HAND_FIST(
        "hand-fist",
        "<path d=\"M12.035 17.012a3 3 0 0 0-3-3l-.311-.002a.72.72 0 0 1-.505-1.229l1.195-1.195A2 2 0 0 1 10.828 11H12a2 2 0 0 0 0-4H9.243a3 3 0 0 0-2.122.879l-2.707 2.707A4.83 4.83 0 0 0 3 14a8 8 0 0 0 8 8h2a8 8 0 0 0 8-8V7a2 2 0 1 0-4 0v2a2 2 0 1 0 4 0\" />\n  <path d=\"M13.888 9.662A2 2 0 0 0 17 8V5A2 2 0 1 0 13 5\" />\n  <path d=\"M9 5A2 2 0 1 0 5 5V10\" />\n  <path d=\"M9 7V4A2 2 0 1 1 13 4V7.268\" />"),
    HIKING_STICK(
        "hiking-stick",
        "<path d=\"M13.5 10.5 2 22\" />\n  <path d=\"M16.352 11.648a1.205 1.205 0 01-1.704 0l-2.296-2.296a1.205 1.205 0 010-1.704l.72-.72a2 2 0 011.022-.546l.599-.12a2 2 0 001.569-1.57l.12-.598a2 2 0 01.546-1.022l.72-.72a1.205 1.205 0 011.704 0l2.296 2.296a1.205 1.205 0 010 1.704l-6.02 6.02a1 1 0 103 3l.201-.201A7.4 7.4 0 0021 9.93V7\" />\n  <path d=\"m6 21-3-3\" />"),
    LAND_PLOT(
        "land-plot",
        "<path d=\"m12 8 6-3-6-3v10\" />\n  <path d=\"m8 11.99-5.5 3.14a1 1 0 0 0 0 1.74l8.5 4.86a2 2 0 0 0 2 0l8.5-4.86a1 1 0 0 0 0-1.74L16 12\" />\n  <path d=\"m6.49 12.85 11.02 6.3\" />\n  <path d=\"M17.51 12.85 6.5 19.15\" />"),
    MEDAL(
        "medal",
        "<path d=\"M7.21 15 2.66 7.14a2 2 0 0 1 .13-2.2L4.4 2.8A2 2 0 0 1 6 2h12a2 2 0 0 1 1.6.8l1.6 2.14a2 2 0 0 1 .14 2.2L16.79 15\" />\n  <path d=\"M11 12 5.12 2.2\" />\n  <path d=\"m13 12 5.88-9.8\" />\n  <path d=\"M8 7h8\" />\n  <circle cx=\"12\" cy=\"17\" r=\"5\" />\n  <path d=\"M12 18v-2h-.5\" />"),
    PODIUM(
        "podium",
        "<path d=\"M12 6V2h-1\" />\n  <path d=\"M9 15a1 1 0 0 0-1-1H4a1 1 0 0 0-1 1v5a1 1 0 0 0 1 1h16a1 1 0 0 0 1-1v-3a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1\" />\n  <path d=\"M9 21V11a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v10\" />"),
    RUGBY_BALL(
        "rugby-ball",
        "<path d=\"m10 10 4 4\" />\n  <path d=\"m13 7 4 4\" />\n  <path d=\"M15.34 2.138A15 15 0 002.138 15.34c-.357 2.94.004 4.919.805 5.717.798.8 2.778 1.162 5.718.805A15 15 0 0021.862 8.661c.357-2.94-.004-4.92-.805-5.718-.798-.8-2.778-1.162-5.717-.805\" />\n  <path d=\"M17 7 7 17\" />\n  <path d=\"m7 13 4 4\" />"),
    SPORT_SHOE(
        "sport-shoe",
        "<path d=\"m15 10.42 4.8-5.07\" />\n  <path d=\"M19 18h3\" />\n  <path d=\"M9.5 22 21.414 9.415A2 2 0 0 0 21.2 6.4l-5.61-4.208A1 1 0 0 0 14 3v2a2 2 0 0 1-1.394 1.906L8.677 8.053A1 1 0 0 0 8 9c-.155 6.393-2.082 9-4 9a2 2 0 0 0 0 4h14\" />"),
    SQUARE_STAR(
        "square-star",
        "<path d=\"M11.035 7.69a1 1 0 0 1 1.909.024l.737 1.452a1 1 0 0 0 .737.535l1.634.256a1 1 0 0 1 .588 1.806l-1.172 1.168a1 1 0 0 0-.282.866l.259 1.613a1 1 0 0 1-1.541 1.134l-1.465-.75a1 1 0 0 0-.912 0l-1.465.75a1 1 0 0 1-1.539-1.133l.258-1.613a1 1 0 0 0-.282-.866l-1.156-1.153a1 1 0 0 1 .572-1.822l1.633-.256a1 1 0 0 0 .737-.535z\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    TROPHY(
        "trophy",
        "<path d=\"M10 14.66V17a1 1 0 0 1-1 1 2 2 0 0 0-2 2v2\" />\n  <path d=\"M14 14.66V17a1 1 0 0 0 1 1 2 2 0 0 1 2 2v2\" />\n  <path d=\"M17.916 10H19.5A2.5 2.5 0 0 0 22 7.5V5a1 1 0 0 0-1-1h-3\" />\n  <path d=\"M4 22h16\" />\n  <path d=\"M6 9a6 6 0 0 0 12 0V3a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1z\" />\n  <path d=\"M6.084 10H4.5A2.5 2.5 0 0 1 2 7.5V5a1 1 0 0 1 1-1h3\" />"),
    VOLLEYBALL(
        "volleyball",
        "<path d=\"M11 7a16 16 20 0 1 10.98 4.362\" />\n  <path d=\"M12 12a13 13 0 0 1-8.66 5\" />\n  <path d=\"M16.83 13.634a16 16 0 0 1-9.267 7.328\" />\n  <path d=\"M20.66 17A13 13 0 0 0 12 12a13 13 0 0 1 0-10\" />\n  <path d=\"M8.17 15.366a16 16 0 0 1-1.713-11.69\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    WAVES_LADDER(
        "waves-ladder",
        "<path d=\"M19 5a2 2 0 0 0-2 2v11\" />\n  <path d=\"M2 18c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M7 13h10\" />\n  <path d=\"M7 9h10\" />\n  <path d=\"M9 5a2 2 0 0 0-2 2v11\" />"),
    WHISTLE(
        "whistle",
        "<path d=\"M10 6v4\" />\n  <path d=\"M21 6a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-5.675A7 7 0 1 1 9 6z\" />");

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
  default LucideIcon award_sports() {
    return LucideIcon.create(Icon.AWARD);
  }

  default LucideIcon circle_gauge_sports() {
    return LucideIcon.create(Icon.CIRCLE_GAUGE);
  }

  default LucideIcon circle_star_sports() {
    return LucideIcon.create(Icon.CIRCLE_STAR);
  }

  default LucideIcon dumbbell_sports() {
    return LucideIcon.create(Icon.DUMBBELL);
  }

  default LucideIcon fishing_hook_sports() {
    return LucideIcon.create(Icon.FISHING_HOOK);
  }

  default LucideIcon fishing_rod_sports() {
    return LucideIcon.create(Icon.FISHING_ROD);
  }

  default LucideIcon gauge_sports() {
    return LucideIcon.create(Icon.GAUGE);
  }

  default LucideIcon hand_fist_sports() {
    return LucideIcon.create(Icon.HAND_FIST);
  }

  default LucideIcon hiking_stick_sports() {
    return LucideIcon.create(Icon.HIKING_STICK);
  }

  default LucideIcon land_plot_sports() {
    return LucideIcon.create(Icon.LAND_PLOT);
  }

  default LucideIcon medal_sports() {
    return LucideIcon.create(Icon.MEDAL);
  }

  default LucideIcon podium_sports() {
    return LucideIcon.create(Icon.PODIUM);
  }

  default LucideIcon rugby_ball() {
    return LucideIcon.create(Icon.RUGBY_BALL);
  }

  default LucideIcon sport_shoe() {
    return LucideIcon.create(Icon.SPORT_SHOE);
  }

  default LucideIcon square_star_sports() {
    return LucideIcon.create(Icon.SQUARE_STAR);
  }

  default LucideIcon trophy_sports() {
    return LucideIcon.create(Icon.TROPHY);
  }

  default LucideIcon volleyball_sports() {
    return LucideIcon.create(Icon.VOLLEYBALL);
  }

  default LucideIcon waves_ladder_sports() {
    return LucideIcon.create(Icon.WAVES_LADDER);
  }

  default LucideIcon whistle_sports() {
    return LucideIcon.create(Icon.WHISTLE);
  }
}
