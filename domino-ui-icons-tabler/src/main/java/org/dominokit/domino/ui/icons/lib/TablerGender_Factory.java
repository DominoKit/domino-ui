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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerGender;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Gender category. */
public final class TablerGender_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerGender tagIcons = new TablerGender() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "gender-agender", "TablerIcons.gender_agender()", tagIcons::gender_agender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-androgyne",
            "TablerIcons.gender_androgyne()",
            tagIcons::gender_androgyne));
    icons.add(
        new IconCatalogEntry<>(
            "gender-bigender",
            "TablerIcons.gender_bigender()",
            tagIcons::gender_bigender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-demiboy", "TablerIcons.gender_demiboy()", tagIcons::gender_demiboy));
    icons.add(
        new IconCatalogEntry<>(
            "gender-demigirl",
            "TablerIcons.gender_demigirl()",
            tagIcons::gender_demigirl));
    icons.add(
        new IconCatalogEntry<>(
            "gender-epicene", "TablerIcons.gender_epicene()", tagIcons::gender_epicene));
    icons.add(
        new IconCatalogEntry<>(
            "gender-female", "TablerIcons.gender_female()", tagIcons::gender_female));
    icons.add(
        new IconCatalogEntry<>(
            "gender-femme", "TablerIcons.gender_femme()", tagIcons::gender_femme));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderfluid",
            "TablerIcons.gender_genderfluid()",
            tagIcons::gender_genderfluid));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderless",
            "TablerIcons.gender_genderless()",
            tagIcons::gender_genderless));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderqueer",
            "TablerIcons.gender_genderqueer()",
            tagIcons::gender_genderqueer));
    icons.add(
        new IconCatalogEntry<>(
            "gender-hermaphrodite",
            "TablerIcons.gender_hermaphrodite()",
            tagIcons::gender_hermaphrodite));
    icons.add(
        new IconCatalogEntry<>(
            "gender-intergender",
            "TablerIcons.gender_intergender()",
            tagIcons::gender_intergender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-male", "TablerIcons.gender_male()", tagIcons::gender_male));
    icons.add(
        new IconCatalogEntry<>(
            "gender-neutrois",
            "TablerIcons.gender_neutrois()",
            tagIcons::gender_neutrois));
    icons.add(
        new IconCatalogEntry<>(
            "gender-third", "TablerIcons.gender_third()", tagIcons::gender_third));
    icons.add(
        new IconCatalogEntry<>(
            "gender-transgender",
            "TablerIcons.gender_transgender()",
            tagIcons::gender_transgender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-travesti",
            "TablerIcons.gender_travesti()",
            tagIcons::gender_travesti));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
