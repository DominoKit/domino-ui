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

/** Tabler Gender catalog category. */
public interface TablerGender {
  enum OutlineIcon implements TablerIconDefinition {
    GENDER_AGENDER(
        "gender-agender",
        "<path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M7 12h11\" />"),
    GENDER_ANDROGYNE(
        "gender-androgyne",
        "<path d=\"M13 11l6 -6\" />\n  <path d=\"M4 15a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M19 9v-4h-4\" />\n  <path d=\"M16.5 10.5l-3 -3\" />"),
    GENDER_BIGENDER(
        "gender-bigender",
        "<path d=\"M7 11a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M19 3l-5 5\" />\n  <path d=\"M15 3h4v4\" />\n  <path d=\"M11 16v6\" />\n  <path d=\"M8 19h6\" />"),
    GENDER_DEMIBOY(
        "gender-demiboy",
        "<path d=\"M5 14a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M19 5l-5.4 5.4\" />\n  <path d=\"M19 5h-5\" />"),
    GENDER_DEMIGIRL(
        "gender-demigirl",
        "<path d=\"M7 9a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M12 14v7\" />\n  <path d=\"M9 18h3\" />"),
    GENDER_EPICENE(
        "gender-epicene",
        "<path d=\"M15.536 15.536a5 5 0 1 0 -7.072 -7.072a5 5 0 0 0 7.072 7.072\" />\n  <path d=\"M15.536 15.535l5.464 -5.535\" />\n  <path d=\"M3 14l5.464 -5.535\" />\n  <path d=\"M12 12h.01\" />"),
    GENDER_FEMALE(
        "gender-female",
        "<path d=\"M7 9a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M12 14v7\" />\n  <path d=\"M9 18h6\" />"),
    GENDER_FEMME(
        "gender-femme",
        "<path d=\"M7 9a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M12 14v7\" />\n  <path d=\"M7 18h10\" />"),
    GENDER_GENDERFLUID(
        "gender-genderfluid",
        "<path d=\"M10 15.464a4 4 0 1 0 4 -6.928a4 4 0 0 0 -4 6.928\" />\n  <path d=\"M15.464 14l3 -5.196\" />\n  <path d=\"M5.536 15.195l3 -5.196\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M9 9l-6 -6\" />\n  <path d=\"M5.5 8.5l3 -3\" />\n  <path d=\"M21 21l-6 -6\" />\n  <path d=\"M17 20l3 -3\" />\n  <path d=\"M3 7v-4h4\" />"),
    GENDER_GENDERLESS(
        "gender-genderless",
        "<path d=\"M12 10a5 5 0 1 1 0 10a5 5 0 0 1 0 -10\" />\n  <path d=\"M12 10v-7\" />\n  <path d=\"M7 15h10\" />"),
    GENDER_GENDERQUEER(
        "gender-genderqueer",
        "<path d=\"M12 11a5 5 0 1 1 0 10a5 5 0 0 1 0 -10\" />\n  <path d=\"M12 11v-8\" />\n  <path d=\"M14.5 4.5l-5 3\" />\n  <path d=\"M9.5 4.5l5 3\" />"),
    GENDER_HERMAPHRODITE(
        "gender-hermaphrodite",
        "<path d=\"M12 14v7\" />\n  <path d=\"M9 18h6\" />\n  <path d=\"M12 6a4 4 0 1 1 0 8a4 4 0 0 1 0 -8\" />\n  <path d=\"M15 3a3 3 0 1 1 -6 0\" />"),
    GENDER_INTERGENDER(
        "gender-intergender",
        "<path d=\"M13.5 11.5l6.5 6.5v-4\" />\n  <path d=\"M11.5 13.5l6.5 6.5\" />\n  <path d=\"M9 4a5 5 0 1 1 0 10a5 5 0 0 1 0 -10\" />\n  <path d=\"M14 20l2 -2\" />"),
    GENDER_MALE(
        "gender-male",
        "<path d=\"M5 14a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M19 5l-5.4 5.4\" />\n  <path d=\"M19 5h-5\" />\n  <path d=\"M19 5v5\" />"),
    GENDER_NEUTROIS(
        "gender-neutrois",
        "<path d=\"M12 10a5 5 0 1 1 0 10a5 5 0 0 1 0 -10\" />\n  <path d=\"M12 10v-7\" />"),
    GENDER_THIRD(
        "gender-third",
        "<path d=\"M11 12a5 5 0 1 0 10 0a5 5 0 0 0 -10 0\" />\n  <path d=\"M11 12h-3\" />\n  <path d=\"M8 12l-5 -4v8l5 -4\" />"),
    GENDER_TRANSGENDER(
        "gender-transgender",
        "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M15 9l6 -6\" />\n  <path d=\"M21 7v-4h-4\" />\n  <path d=\"M9 9l-6 -6\" />\n  <path d=\"M3 7v-4h4\" />\n  <path d=\"M5.5 8.5l3 -3\" />\n  <path d=\"M12 16v5\" />\n  <path d=\"M9.5 19h5\" />"),
    GENDER_TRAVESTI(
        "gender-travesti",
        "<path d=\"M15 20a5 5 0 1 1 0 -10a5 5 0 0 1 0 10\" />\n  <path d=\"M6 6l5.4 5.4\" />\n  <path d=\"M4 8l4 -4\" />");

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

  default TablerIcon gender_agender() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_AGENDER);
  }

  default TablerIcon gender_androgyne() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_ANDROGYNE);
  }

  default TablerIcon gender_bigender() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_BIGENDER);
  }

  default TablerIcon gender_demiboy() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_DEMIBOY);
  }

  default TablerIcon gender_demigirl() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_DEMIGIRL);
  }

  default TablerIcon gender_epicene() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_EPICENE);
  }

  default TablerIcon gender_female() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_FEMALE);
  }

  default TablerIcon gender_femme() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_FEMME);
  }

  default TablerIcon gender_genderfluid() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERFLUID);
  }

  default TablerIcon gender_genderless() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERLESS);
  }

  default TablerIcon gender_genderqueer() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERQUEER);
  }

  default TablerIcon gender_hermaphrodite() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_HERMAPHRODITE);
  }

  default TablerIcon gender_intergender() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_INTERGENDER);
  }

  default TablerIcon gender_male() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_MALE);
  }

  default TablerIcon gender_neutrois() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_NEUTROIS);
  }

  default TablerIcon gender_third() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_THIRD);
  }

  default TablerIcon gender_transgender() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_TRANSGENDER);
  }

  default TablerIcon gender_travesti() {
    return TablerIcon.create(TablerGender.OutlineIcon.GENDER_TRAVESTI);
  }
}
