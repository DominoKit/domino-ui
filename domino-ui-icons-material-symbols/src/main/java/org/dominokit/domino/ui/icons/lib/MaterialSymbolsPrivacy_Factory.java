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
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;
import org.dominokit.domino.ui.icons.MaterialSymbolsPrivacy;

/** Static icon factory for the Material Symbols Privacy category. */
public final class MaterialSymbolsPrivacy_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsPrivacy tagIcons = new MaterialSymbolsPrivacy() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "add_moderator",
            "MaterialSymbolsIcon.create(\"add_moderator\")",
            tagIcons::add_moderator_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "admin_panel_settings",
            "MaterialSymbolsIcon.create(\"admin_panel_settings\")",
            tagIcons::admin_panel_settings_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "assured_workload",
            "MaterialSymbolsIcon.create(\"assured_workload\")",
            tagIcons::assured_workload_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "badge", "MaterialSymbolsIcon.create(\"badge\")", tagIcons::badge_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "disabled_visible",
            "MaterialSymbolsIcon.create(\"disabled_visible\")",
            tagIcons::disabled_visible_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "e911_emergency",
            "MaterialSymbolsIcon.create(\"e911_emergency\")",
            tagIcons::e911_emergency_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "encrypted", "MaterialSymbolsIcon.create(\"encrypted\")", tagIcons::encrypted_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "encrypted_add",
            "MaterialSymbolsIcon.create(\"encrypted_add\")",
            tagIcons::encrypted_add_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "encrypted_add_circle",
            "MaterialSymbolsIcon.create(\"encrypted_add_circle\")",
            tagIcons::encrypted_add_circle_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "encrypted_minus_circle",
            "MaterialSymbolsIcon.create(\"encrypted_minus_circle\")",
            tagIcons::encrypted_minus_circle_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "encrypted_off",
            "MaterialSymbolsIcon.create(\"encrypted_off\")",
            tagIcons::encrypted_off_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "enhanced_encryption",
            "MaterialSymbolsIcon.create(\"enhanced_encryption\")",
            tagIcons::enhanced_encryption_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "exclamation",
            "MaterialSymbolsIcon.create(\"exclamation\")",
            tagIcons::exclamation_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "id_card", "MaterialSymbolsIcon.create(\"id_card\")", tagIcons::id_card_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "id_card_2", "MaterialSymbolsIcon.create(\"id_card_2\")", tagIcons::id_card_2_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "identity_aware_proxy",
            "MaterialSymbolsIcon.create(\"identity_aware_proxy\")",
            tagIcons::identity_aware_proxy_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "key_visualizer",
            "MaterialSymbolsIcon.create(\"key_visualizer\")",
            tagIcons::key_visualizer_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "mobile_theft",
            "MaterialSymbolsIcon.create(\"mobile_theft\")",
            tagIcons::mobile_theft_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "no_encryption",
            "MaterialSymbolsIcon.create(\"no_encryption\")",
            tagIcons::no_encryption_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "passkey", "MaterialSymbolsIcon.create(\"passkey\")", tagIcons::passkey_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "person_shield",
            "MaterialSymbolsIcon.create(\"person_shield\")",
            tagIcons::person_shield_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "policy", "MaterialSymbolsIcon.create(\"policy\")", tagIcons::policy_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "policy_alert",
            "MaterialSymbolsIcon.create(\"policy_alert\")",
            tagIcons::policy_alert_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "privacy_tip",
            "MaterialSymbolsIcon.create(\"privacy_tip\")",
            tagIcons::privacy_tip_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "private_connectivity",
            "MaterialSymbolsIcon.create(\"private_connectivity\")",
            tagIcons::private_connectivity_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "remove_moderator",
            "MaterialSymbolsIcon.create(\"remove_moderator\")",
            tagIcons::remove_moderator_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "report", "MaterialSymbolsIcon.create(\"report\")", tagIcons::report_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "report_off",
            "MaterialSymbolsIcon.create(\"report_off\")",
            tagIcons::report_off_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "security", "MaterialSymbolsIcon.create(\"security\")", tagIcons::security_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield", "MaterialSymbolsIcon.create(\"shield\")", tagIcons::shield_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_card",
            "MaterialSymbolsIcon.create(\"shield_card\")",
            tagIcons::shield_card_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_lock",
            "MaterialSymbolsIcon.create(\"shield_lock\")",
            tagIcons::shield_lock_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_locked",
            "MaterialSymbolsIcon.create(\"shield_locked\")",
            tagIcons::shield_locked_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_person",
            "MaterialSymbolsIcon.create(\"shield_person\")",
            tagIcons::shield_person_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_question",
            "MaterialSymbolsIcon.create(\"shield_question\")",
            tagIcons::shield_question_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_radar",
            "MaterialSymbolsIcon.create(\"shield_radar\")",
            tagIcons::shield_radar_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "shield_toggle",
            "MaterialSymbolsIcon.create(\"shield_toggle\")",
            tagIcons::shield_toggle_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "sync_lock", "MaterialSymbolsIcon.create(\"sync_lock\")", tagIcons::sync_lock_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "verified_user",
            "MaterialSymbolsIcon.create(\"verified_user\")",
            tagIcons::verified_user_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "vpn_key", "MaterialSymbolsIcon.create(\"vpn_key\")", tagIcons::vpn_key_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "vpn_key_alert",
            "MaterialSymbolsIcon.create(\"vpn_key_alert\")",
            tagIcons::vpn_key_alert_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "vpn_key_off",
            "MaterialSymbolsIcon.create(\"vpn_key_off\")",
            tagIcons::vpn_key_off_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "vpn_lock", "MaterialSymbolsIcon.create(\"vpn_lock\")", tagIcons::vpn_lock_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "vpn_lock_2",
            "MaterialSymbolsIcon.create(\"vpn_lock_2\")",
            tagIcons::vpn_lock_2_privacy));
    icons.add(
        new IconCatalogEntry<>(
            "wifi_password",
            "MaterialSymbolsIcon.create(\"wifi_password\")",
            tagIcons::wifi_password_privacy));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
