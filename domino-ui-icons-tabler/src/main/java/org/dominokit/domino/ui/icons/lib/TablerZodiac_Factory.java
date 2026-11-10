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
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerZodiac;

/** Static icon factory for the Tabler Zodiac category. */
public final class TablerZodiac_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerZodiac tagIcons = new TablerZodiac() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-aquarius (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_AQUARIUS)",
            tagIcons::zodiac_aquarius));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-aries (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_ARIES)",
            tagIcons::zodiac_aries));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-cancer (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_CANCER)",
            tagIcons::zodiac_cancer));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-capricorn (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_CAPRICORN)",
            tagIcons::zodiac_capricorn));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-gemini (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_GEMINI)",
            tagIcons::zodiac_gemini));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-leo (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_LEO)",
            tagIcons::zodiac_leo));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-libra (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_LIBRA)",
            tagIcons::zodiac_libra));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-pisces (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_PISCES)",
            tagIcons::zodiac_pisces));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-sagittarius (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_SAGITTARIUS)",
            tagIcons::zodiac_sagittarius));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-scorpio (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_SCORPIO)",
            tagIcons::zodiac_scorpio));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-taurus (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_TAURUS)",
            tagIcons::zodiac_taurus));
    icons.add(
        new IconCatalogEntry<>(
            "zodiac-virgo (outline)",
            "TablerIcon.create(TablerZodiac.OutlineIcon.ZODIAC_VIRGO)",
            tagIcons::zodiac_virgo));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
