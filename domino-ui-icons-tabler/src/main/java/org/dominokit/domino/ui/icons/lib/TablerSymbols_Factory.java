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
import org.dominokit.domino.ui.icons.TablerSymbols;

/** Static icon factory for the Tabler Symbols category. */
public final class TablerSymbols_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerSymbols tagIcons = new TablerSymbols() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "ankh (outline)", "TablerIcon.create(TablerSymbols.OutlineIcon.ANKH)", tagIcons::ankh));
    icons.add(
        new IconCatalogEntry<>(
            "biohazard (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.BIOHAZARD)",
            tagIcons::biohazard));
    icons.add(
        new IconCatalogEntry<>(
            "biohazard-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.BIOHAZARD_OFF)",
            tagIcons::biohazard_off));
    icons.add(
        new IconCatalogEntry<>(
            "ce (outline)", "TablerIcon.create(TablerSymbols.OutlineIcon.CE)", tagIcons::ce));
    icons.add(
        new IconCatalogEntry<>(
            "ce-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.CE_OFF)",
            tagIcons::ce_off));
    icons.add(
        new IconCatalogEntry<>(
            "command (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COMMAND)",
            tagIcons::command));
    icons.add(
        new IconCatalogEntry<>(
            "command-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COMMAND_OFF)",
            tagIcons::command_off));
    icons.add(
        new IconCatalogEntry<>(
            "confucius (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.CONFUCIUS)",
            tagIcons::confucius));
    icons.add(
        new IconCatalogEntry<>(
            "copyleft (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COPYLEFT)",
            tagIcons::copyleft));
    icons.add(
        new IconCatalogEntry<>(
            "copyleft-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COPYLEFT_OFF)",
            tagIcons::copyleft_off));
    icons.add(
        new IconCatalogEntry<>(
            "copyright (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COPYRIGHT)",
            tagIcons::copyright));
    icons.add(
        new IconCatalogEntry<>(
            "copyright-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.COPYRIGHT_OFF)",
            tagIcons::copyright_off));
    icons.add(
        new IconCatalogEntry<>(
            "cross (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.CROSS)",
            tagIcons::cross));
    icons.add(
        new IconCatalogEntry<>(
            "cross-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.CROSS_OFF)",
            tagIcons::cross_off));
    icons.add(
        new IconCatalogEntry<>(
            "fish-christianity (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.FISH_CHRISTIANITY)",
            tagIcons::fish_christianity));
    icons.add(
        new IconCatalogEntry<>(
            "mars (outline)", "TablerIcon.create(TablerSymbols.OutlineIcon.MARS)", tagIcons::mars));
    icons.add(
        new IconCatalogEntry<>(
            "menorah (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.MENORAH)",
            tagIcons::menorah));
    icons.add(
        new IconCatalogEntry<>(
            "om (outline)", "TablerIcon.create(TablerSymbols.OutlineIcon.OM)", tagIcons::om));
    icons.add(
        new IconCatalogEntry<>(
            "option (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.OPTION)",
            tagIcons::option));
    icons.add(
        new IconCatalogEntry<>(
            "parking-circle (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.PARKING_CIRCLE)",
            tagIcons::parking_circle));
    icons.add(
        new IconCatalogEntry<>(
            "peace (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.PEACE)",
            tagIcons::peace));
    icons.add(
        new IconCatalogEntry<>(
            "radioactive (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RADIOACTIVE)",
            tagIcons::radioactive));
    icons.add(
        new IconCatalogEntry<>(
            "radioactive-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RADIOACTIVE_OFF)",
            tagIcons::radioactive_off));
    icons.add(
        new IconCatalogEntry<>(
            "rating-12-plus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RATING_12_PLUS)",
            tagIcons::rating_12_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rating-14-plus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RATING_14_PLUS)",
            tagIcons::rating_14_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rating-16-plus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RATING_16_PLUS)",
            tagIcons::rating_16_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rating-18-plus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RATING_18_PLUS)",
            tagIcons::rating_18_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rating-21-plus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RATING_21_PLUS)",
            tagIcons::rating_21_plus));
    icons.add(
        new IconCatalogEntry<>(
            "recycle (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RECYCLE)",
            tagIcons::recycle));
    icons.add(
        new IconCatalogEntry<>(
            "recycle-off (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RECYCLE_OFF)",
            tagIcons::recycle_off));
    icons.add(
        new IconCatalogEntry<>(
            "registered (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.REGISTERED)",
            tagIcons::registered));
    icons.add(
        new IconCatalogEntry<>(
            "ribbon-health (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.RIBBON_HEALTH)",
            tagIcons::ribbon_health));
    icons.add(
        new IconCatalogEntry<>(
            "servicemark (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.SERVICEMARK)",
            tagIcons::servicemark));
    icons.add(
        new IconCatalogEntry<>(
            "torii (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.TORII)",
            tagIcons::torii));
    icons.add(
        new IconCatalogEntry<>(
            "trademark (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.TRADEMARK)",
            tagIcons::trademark));
    icons.add(
        new IconCatalogEntry<>(
            "venus (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.VENUS)",
            tagIcons::venus));
    icons.add(
        new IconCatalogEntry<>(
            "yin-yang (outline)",
            "TablerIcon.create(TablerSymbols.OutlineIcon.YIN_YANG)",
            tagIcons::yin_yang));
    icons.add(
        new IconCatalogEntry<>(
            "biohazard (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.BIOHAZARD)",
            tagIcons::biohazard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copyleft (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.COPYLEFT)",
            tagIcons::copyleft_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copyright (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.COPYRIGHT)",
            tagIcons::copyright_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cross (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.CROSS)",
            tagIcons::cross_filled));
    icons.add(
        new IconCatalogEntry<>(
            "parking-circle (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.PARKING_CIRCLE)",
            tagIcons::parking_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "radioactive (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.RADIOACTIVE)",
            tagIcons::radioactive_filled));
    icons.add(
        new IconCatalogEntry<>(
            "registered (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.REGISTERED)",
            tagIcons::registered_filled));
    icons.add(
        new IconCatalogEntry<>(
            "yin-yang (filled)",
            "TablerIcon.create(TablerSymbols.FilledIcon.YIN_YANG)",
            tagIcons::yin_yang_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
