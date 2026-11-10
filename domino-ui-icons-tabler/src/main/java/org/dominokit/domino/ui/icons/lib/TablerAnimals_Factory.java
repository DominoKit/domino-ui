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
    icons.add(
        new IconCatalogEntry<>(
            "bat (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.BAT)", tagIcons::bat));
    icons.add(
        new IconCatalogEntry<>(
            "cat (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.CAT)", tagIcons::cat));
    icons.add(
        new IconCatalogEntry<>(
            "deer (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.DEER)", tagIcons::deer));
    icons.add(
        new IconCatalogEntry<>(
            "dog (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.DOG)", tagIcons::dog));
    icons.add(
        new IconCatalogEntry<>(
            "dragon (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.DRAGON)",
            tagIcons::dragon));
    icons.add(
        new IconCatalogEntry<>(
            "fish (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.FISH)", tagIcons::fish));
    icons.add(
        new IconCatalogEntry<>(
            "fish-bone (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.FISH_BONE)",
            tagIcons::fish_bone));
    icons.add(
        new IconCatalogEntry<>(
            "fish-hook (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.FISH_HOOK)",
            tagIcons::fish_hook));
    icons.add(
        new IconCatalogEntry<>(
            "fish-hook-off (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.FISH_HOOK_OFF)",
            tagIcons::fish_hook_off));
    icons.add(
        new IconCatalogEntry<>(
            "fish-off (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.FISH_OFF)",
            tagIcons::fish_off));
    icons.add(
        new IconCatalogEntry<>(
            "horse (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.HORSE)",
            tagIcons::horse));
    icons.add(
        new IconCatalogEntry<>(
            "horseshoe (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.HORSESHOE)",
            tagIcons::horseshoe));
    icons.add(
        new IconCatalogEntry<>(
            "paw (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.PAW)", tagIcons::paw));
    icons.add(
        new IconCatalogEntry<>(
            "paw-off (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.PAW_OFF)",
            tagIcons::paw_off));
    icons.add(
        new IconCatalogEntry<>(
            "pig (outline)", "TablerIcon.create(TablerAnimals.OutlineIcon.PIG)", tagIcons::pig));
    icons.add(
        new IconCatalogEntry<>(
            "pig-money (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.PIG_MONEY)",
            tagIcons::pig_money));
    icons.add(
        new IconCatalogEntry<>(
            "pig-off (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.PIG_OFF)",
            tagIcons::pig_off));
    icons.add(
        new IconCatalogEntry<>(
            "spider (outline)",
            "TablerIcon.create(TablerAnimals.OutlineIcon.SPIDER)",
            tagIcons::spider));
    icons.add(
        new IconCatalogEntry<>(
            "fish-bone (filled)",
            "TablerIcon.create(TablerAnimals.FilledIcon.FISH_BONE)",
            tagIcons::fish_bone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "paw (filled)",
            "TablerIcon.create(TablerAnimals.FilledIcon.PAW)",
            tagIcons::paw_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pig (filled)",
            "TablerIcon.create(TablerAnimals.FilledIcon.PIG)",
            tagIcons::pig_filled));
    icons.add(
        new IconCatalogEntry<>(
            "spider (filled)",
            "TablerIcon.create(TablerAnimals.FilledIcon.SPIDER)",
            tagIcons::spider_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
