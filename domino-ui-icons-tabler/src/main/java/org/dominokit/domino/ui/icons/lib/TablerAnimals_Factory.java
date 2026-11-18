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
import org.dominokit.domino.ui.icons.TablerAnimals;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Animals category. */
public final class TablerAnimals_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerAnimals tagIcons = new TablerAnimals() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("bat", "TablerIcons.bat()", tagIcons::bat));
    icons.add(new IconCatalogEntry<>("cat", "TablerIcons.cat()", tagIcons::cat));
    icons.add(new IconCatalogEntry<>("deer", "TablerIcons.deer()", tagIcons::deer));
    icons.add(new IconCatalogEntry<>("dog", "TablerIcons.dog()", tagIcons::dog));
    icons.add(new IconCatalogEntry<>("dragon", "TablerIcons.dragon()", tagIcons::dragon));
    icons.add(new IconCatalogEntry<>("fish", "TablerIcons.fish()", tagIcons::fish));
    icons.add(
        new IconCatalogEntry<>(
            "fish-bone", "TablerIcons.fish_bone()", tagIcons::fish_bone));
    icons.add(
        new IconCatalogEntry<>(
            "fish-hook", "TablerIcons.fish_hook()", tagIcons::fish_hook));
    icons.add(
        new IconCatalogEntry<>(
            "fish-hook-off", "TablerIcons.fish_hook_off()", tagIcons::fish_hook_off));
    icons.add(
        new IconCatalogEntry<>("fish-off", "TablerIcons.fish_off()", tagIcons::fish_off));
    icons.add(new IconCatalogEntry<>("horse", "TablerIcons.horse()", tagIcons::horse));
    icons.add(
        new IconCatalogEntry<>(
            "horseshoe", "TablerIcons.horseshoe()", tagIcons::horseshoe));
    icons.add(new IconCatalogEntry<>("paw", "TablerIcons.paw()", tagIcons::paw));
    icons.add(
        new IconCatalogEntry<>("paw-off", "TablerIcons.paw_off()", tagIcons::paw_off));
    icons.add(new IconCatalogEntry<>("pig", "TablerIcons.pig()", tagIcons::pig));
    icons.add(
        new IconCatalogEntry<>(
            "pig-money", "TablerIcons.pig_money()", tagIcons::pig_money));
    icons.add(
        new IconCatalogEntry<>("pig-off", "TablerIcons.pig_off()", tagIcons::pig_off));
    icons.add(new IconCatalogEntry<>("spider", "TablerIcons.spider()", tagIcons::spider));
    icons.add(
        new IconCatalogEntry<>(
            "fish-bone", "TablerIcons.fish_bone_filled()", tagIcons::fish_bone_filled));
    icons.add(
        new IconCatalogEntry<>("paw", "TablerIcons.paw_filled()", tagIcons::paw_filled));
    icons.add(
        new IconCatalogEntry<>("pig", "TablerIcons.pig_filled()", tagIcons::pig_filled));
    icons.add(
        new IconCatalogEntry<>(
            "spider", "TablerIcons.spider_filled()", tagIcons::spider_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
