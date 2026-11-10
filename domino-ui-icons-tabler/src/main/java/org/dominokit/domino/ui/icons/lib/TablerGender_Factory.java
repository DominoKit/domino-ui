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
            "gender-agender (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_AGENDER)",
            tagIcons::gender_agender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-androgyne (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_ANDROGYNE)",
            tagIcons::gender_androgyne));
    icons.add(
        new IconCatalogEntry<>(
            "gender-bigender (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_BIGENDER)",
            tagIcons::gender_bigender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-demiboy (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_DEMIBOY)",
            tagIcons::gender_demiboy));
    icons.add(
        new IconCatalogEntry<>(
            "gender-demigirl (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_DEMIGIRL)",
            tagIcons::gender_demigirl));
    icons.add(
        new IconCatalogEntry<>(
            "gender-epicene (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_EPICENE)",
            tagIcons::gender_epicene));
    icons.add(
        new IconCatalogEntry<>(
            "gender-female (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_FEMALE)",
            tagIcons::gender_female));
    icons.add(
        new IconCatalogEntry<>(
            "gender-femme (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_FEMME)",
            tagIcons::gender_femme));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderfluid (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERFLUID)",
            tagIcons::gender_genderfluid));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderless (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERLESS)",
            tagIcons::gender_genderless));
    icons.add(
        new IconCatalogEntry<>(
            "gender-genderqueer (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_GENDERQUEER)",
            tagIcons::gender_genderqueer));
    icons.add(
        new IconCatalogEntry<>(
            "gender-hermaphrodite (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_HERMAPHRODITE)",
            tagIcons::gender_hermaphrodite));
    icons.add(
        new IconCatalogEntry<>(
            "gender-intergender (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_INTERGENDER)",
            tagIcons::gender_intergender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-male (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_MALE)",
            tagIcons::gender_male));
    icons.add(
        new IconCatalogEntry<>(
            "gender-neutrois (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_NEUTROIS)",
            tagIcons::gender_neutrois));
    icons.add(
        new IconCatalogEntry<>(
            "gender-third (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_THIRD)",
            tagIcons::gender_third));
    icons.add(
        new IconCatalogEntry<>(
            "gender-transgender (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_TRANSGENDER)",
            tagIcons::gender_transgender));
    icons.add(
        new IconCatalogEntry<>(
            "gender-travesti (outline)",
            "TablerIcon.create(TablerGender.OutlineIcon.GENDER_TRAVESTI)",
            tagIcons::gender_travesti));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
