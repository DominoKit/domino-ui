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

/** Tabler Zodiac catalog category. */
public interface TablerZodiac {
  enum OutlineIcon implements TablerIconDefinition {
    ZODIAC_AQUARIUS(
        "zodiac-aquarius",
        "<path d=\"M3 10l3 -3l3 3l3 -3l3 3l3 -3l3 3\" />\n  <path d=\"M3 17l3 -3l3 3l3 -3l3 3l3 -3l3 3\" />"),
    ZODIAC_ARIES(
        "zodiac-aries",
        "<path d=\"M12 5a5 5 0 1 0 -4 8\" />\n  <path d=\"M16 13a5 5 0 1 0 -4 -8\" />\n  <path d=\"M12 21l0 -16\" />"),
    ZODIAC_CANCER(
        "zodiac-cancer",
        "<path d=\"M3 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M15 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 12a10 6.5 0 0 1 14 -6.5\" />\n  <path d=\"M21 12a10 6.5 0 0 1 -14 6.5\" />"),
    ZODIAC_CAPRICORN(
        "zodiac-capricorn",
        "<path d=\"M4 4a3 3 0 0 1 3 3v9\" />\n  <path d=\"M7 7a3 3 0 0 1 6 0v11a3 3 0 0 1 -3 3\" />\n  <path d=\"M13 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    ZODIAC_GEMINI(
        "zodiac-gemini",
        "<path d=\"M3 3a21 21 0 0 0 18 0\" />\n  <path d=\"M3 21a21 21 0 0 1 18 0\" />\n  <path d=\"M7 4.5l0 15\" />\n  <path d=\"M17 4.5l0 15\" />"),
    ZODIAC_LEO(
        "zodiac-leo",
        "<path d=\"M13 17a4 4 0 1 0 8 0\" />\n  <path d=\"M3 16a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M7 7a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M7 7c0 3 2 5 2 9\" />\n  <path d=\"M15 7c0 4 -2 6 -2 10\" />"),
    ZODIAC_LIBRA(
        "zodiac-libra",
        "<path d=\"M5 20l14 0\" />\n  <path d=\"M5 17h5v-.3a7 7 0 1 1 4 0v.3h5\" />"),
    ZODIAC_PISCES(
        "zodiac-pisces",
        "<path d=\"M5 3a21 21 0 0 1 0 18\" />\n  <path d=\"M19 3a21 21 0 0 0 0 18\" />\n  <path d=\"M5 12l14 0\" />"),
    ZODIAC_SAGITTARIUS(
        "zodiac-sagittarius",
        "<path d=\"M4 20l16 -16\" />\n  <path d=\"M13 4h7v7\" />\n  <path d=\"M6.5 12.5l5 5\" />"),
    ZODIAC_SCORPIO(
        "zodiac-scorpio",
        "<path d=\"M3 4a2 2 0 0 1 2 2v9\" />\n  <path d=\"M5 6a2 2 0 0 1 4 0v9\" />\n  <path d=\"M9 6a2 2 0 0 1 4 0v10a3 3 0 0 0 3 3h5l-3 -3m0 6l3 -3\" />"),
    ZODIAC_TAURUS(
        "zodiac-taurus",
        "<path d=\"M6 3a6 6 0 0 0 12 0\" />\n  <path d=\"M6 15a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />"),
    ZODIAC_VIRGO(
        "zodiac-virgo",
        "<path d=\"M3 4a2 2 0 0 1 2 2v9\" />\n  <path d=\"M5 6a2 2 0 0 1 4 0v9\" />\n  <path d=\"M9 6a2 2 0 0 1 4 0v10a7 5 0 0 0 7 5\" />\n  <path d=\"M12 21a7 5 0 0 0 7 -5v-2a3 3 0 0 0 -6 0\" />");

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
    ;

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

  default TablerIcon zodiac_aquarius() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_AQUARIUS);
  }

  default TablerIcon zodiac_aries() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_ARIES);
  }

  default TablerIcon zodiac_cancer() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_CANCER);
  }

  default TablerIcon zodiac_capricorn() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_CAPRICORN);
  }

  default TablerIcon zodiac_gemini() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_GEMINI);
  }

  default TablerIcon zodiac_leo() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_LEO);
  }

  default TablerIcon zodiac_libra() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_LIBRA);
  }

  default TablerIcon zodiac_pisces() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_PISCES);
  }

  default TablerIcon zodiac_sagittarius() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_SAGITTARIUS);
  }

  default TablerIcon zodiac_scorpio() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_SCORPIO);
  }

  default TablerIcon zodiac_taurus() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_TAURUS);
  }

  default TablerIcon zodiac_virgo() {
    return TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_VIRGO);
  }
}
