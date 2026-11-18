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
import org.dominokit.domino.ui.icons.TablerBadges;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Badges category. */
public final class TablerBadges_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerBadges tagIcons = new TablerBadges() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("award", "TablerIcons.award()", tagIcons::award));
    icons.add(
        new IconCatalogEntry<>(
            "award-off", "TablerIcons.award_off()", tagIcons::award_off));
    icons.add(new IconCatalogEntry<>("badge", "TablerIcons.badge()", tagIcons::badge));
    icons.add(
        new IconCatalogEntry<>("badge-2k", "TablerIcons.badge_2k()", tagIcons::badge_2k));
    icons.add(
        new IconCatalogEntry<>("badge-3d", "TablerIcons.badge_3d()", tagIcons::badge_3d));
    icons.add(
        new IconCatalogEntry<>("badge-3k", "TablerIcons.badge_3k()", tagIcons::badge_3k));
    icons.add(
        new IconCatalogEntry<>("badge-4k", "TablerIcons.badge_4k()", tagIcons::badge_4k));
    icons.add(
        new IconCatalogEntry<>("badge-5k", "TablerIcons.badge_5k()", tagIcons::badge_5k));
    icons.add(
        new IconCatalogEntry<>("badge-8k", "TablerIcons.badge_8k()", tagIcons::badge_8k));
    icons.add(
        new IconCatalogEntry<>("badge-ad", "TablerIcons.badge_ad()", tagIcons::badge_ad));
    icons.add(
        new IconCatalogEntry<>(
            "badge-ad-off", "TablerIcons.badge_ad_off()", tagIcons::badge_ad_off));
    icons.add(
        new IconCatalogEntry<>("badge-ar", "TablerIcons.badge_ar()", tagIcons::badge_ar));
    icons.add(
        new IconCatalogEntry<>("badge-cc", "TablerIcons.badge_cc()", tagIcons::badge_cc));
    icons.add(
        new IconCatalogEntry<>("badge-hd", "TablerIcons.badge_hd()", tagIcons::badge_hd));
    icons.add(
        new IconCatalogEntry<>(
            "badge-off", "TablerIcons.badge_off()", tagIcons::badge_off));
    icons.add(
        new IconCatalogEntry<>("badge-sd", "TablerIcons.badge_sd()", tagIcons::badge_sd));
    icons.add(
        new IconCatalogEntry<>("badge-tm", "TablerIcons.badge_tm()", tagIcons::badge_tm));
    icons.add(
        new IconCatalogEntry<>("badge-vo", "TablerIcons.badge_vo()", tagIcons::badge_vo));
    icons.add(
        new IconCatalogEntry<>("badge-vr", "TablerIcons.badge_vr()", tagIcons::badge_vr));
    icons.add(
        new IconCatalogEntry<>("badge-wc", "TablerIcons.badge_wc()", tagIcons::badge_wc));
    icons.add(new IconCatalogEntry<>("badges", "TablerIcons.badges()", tagIcons::badges));
    icons.add(
        new IconCatalogEntry<>(
            "badges-off", "TablerIcons.badges_off()", tagIcons::badges_off));
    icons.add(
        new IconCatalogEntry<>(
            "award", "TablerIcons.award_filled()", tagIcons::award_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge", "TablerIcons.badge_filled()", tagIcons::badge_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-3d", "TablerIcons.badge_3d_filled()", tagIcons::badge_3d_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-4k", "TablerIcons.badge_4k_filled()", tagIcons::badge_4k_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-8k", "TablerIcons.badge_8k_filled()", tagIcons::badge_8k_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-ad", "TablerIcons.badge_ad_filled()", tagIcons::badge_ad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-ar", "TablerIcons.badge_ar_filled()", tagIcons::badge_ar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-cc", "TablerIcons.badge_cc_filled()", tagIcons::badge_cc_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-hd", "TablerIcons.badge_hd_filled()", tagIcons::badge_hd_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-sd", "TablerIcons.badge_sd_filled()", tagIcons::badge_sd_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-tm", "TablerIcons.badge_tm_filled()", tagIcons::badge_tm_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-vo", "TablerIcons.badge_vo_filled()", tagIcons::badge_vo_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-vr", "TablerIcons.badge_vr_filled()", tagIcons::badge_vr_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badge-wc", "TablerIcons.badge_wc_filled()", tagIcons::badge_wc_filled));
    icons.add(
        new IconCatalogEntry<>(
            "badges", "TablerIcons.badges_filled()", tagIcons::badges_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
