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
import org.dominokit.domino.ui.icons.TablerHealth;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Health category. */
public final class TablerHealth_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerHealth tagIcons = new TablerHealth() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "accessible (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.ACCESSIBLE)",
            tagIcons::accessible));
    icons.add(
        new IconCatalogEntry<>(
            "accessible-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.ACCESSIBLE_OFF)",
            tagIcons::accessible_off));
    icons.add(
        new IconCatalogEntry<>(
            "activity (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.ACTIVITY)",
            tagIcons::activity));
    icons.add(
        new IconCatalogEntry<>(
            "activity-heartbeat (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.ACTIVITY_HEARTBEAT)",
            tagIcons::activity_heartbeat));
    icons.add(
        new IconCatalogEntry<>(
            "baby-bottle (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BABY_BOTTLE)",
            tagIcons::baby_bottle));
    icons.add(
        new IconCatalogEntry<>(
            "baby-carriage (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BABY_CARRIAGE)",
            tagIcons::baby_carriage));
    icons.add(
        new IconCatalogEntry<>(
            "bandage (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BANDAGE)",
            tagIcons::bandage));
    icons.add(
        new IconCatalogEntry<>(
            "bandage-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BANDAGE_OFF)",
            tagIcons::bandage_off));
    icons.add(
        new IconCatalogEntry<>(
            "blind (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BLIND)",
            tagIcons::blind));
    icons.add(
        new IconCatalogEntry<>(
            "braille (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BRAILLE)",
            tagIcons::braille));
    icons.add(
        new IconCatalogEntry<>(
            "brain (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.BRAIN)",
            tagIcons::brain));
    icons.add(
        new IconCatalogEntry<>(
            "cane (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.CANE)", tagIcons::cane));
    icons.add(
        new IconCatalogEntry<>(
            "checkup-list (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.CHECKUP_LIST)",
            tagIcons::checkup_list));
    icons.add(
        new IconCatalogEntry<>(
            "crutches (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.CRUTCHES)",
            tagIcons::crutches));
    icons.add(
        new IconCatalogEntry<>(
            "crutches-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.CRUTCHES_OFF)",
            tagIcons::crutches_off));
    icons.add(
        new IconCatalogEntry<>(
            "deaf (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.DEAF)", tagIcons::deaf));
    icons.add(
        new IconCatalogEntry<>(
            "dental (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DENTAL)",
            tagIcons::dental));
    icons.add(
        new IconCatalogEntry<>(
            "dental-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DENTAL_OFF)",
            tagIcons::dental_off));
    icons.add(
        new IconCatalogEntry<>(
            "disabled (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DISABLED)",
            tagIcons::disabled));
    icons.add(
        new IconCatalogEntry<>(
            "disabled-2 (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DISABLED_2)",
            tagIcons::disabled_2));
    icons.add(
        new IconCatalogEntry<>(
            "disabled-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DISABLED_OFF)",
            tagIcons::disabled_off));
    icons.add(
        new IconCatalogEntry<>(
            "dna (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.DNA)", tagIcons::dna));
    icons.add(
        new IconCatalogEntry<>(
            "dna-2 (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DNA_2)",
            tagIcons::dna_2));
    icons.add(
        new IconCatalogEntry<>(
            "dna-2-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DNA_2_OFF)",
            tagIcons::dna_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "dna-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.DNA_OFF)",
            tagIcons::dna_off));
    icons.add(
        new IconCatalogEntry<>(
            "ear (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.EAR)", tagIcons::ear));
    icons.add(
        new IconCatalogEntry<>(
            "ear-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EAR_OFF)",
            tagIcons::ear_off));
    icons.add(
        new IconCatalogEntry<>(
            "emergency-bed (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EMERGENCY_BED)",
            tagIcons::emergency_bed));
    icons.add(
        new IconCatalogEntry<>(
            "empathize (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EMPATHIZE)",
            tagIcons::empathize));
    icons.add(
        new IconCatalogEntry<>(
            "empathize-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EMPATHIZE_OFF)",
            tagIcons::empathize_off));
    icons.add(
        new IconCatalogEntry<>(
            "eye-bitcoin (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYE_BITCOIN)",
            tagIcons::eye_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "eye-discount (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYE_DISCOUNT)",
            tagIcons::eye_discount));
    icons.add(
        new IconCatalogEntry<>(
            "eye-dotted (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYE_DOTTED)",
            tagIcons::eye_dotted));
    icons.add(
        new IconCatalogEntry<>(
            "eye-table (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYE_TABLE)",
            tagIcons::eye_table));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS)",
            tagIcons::eyeglass));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-2 (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS_2)",
            tagIcons::eyeglass_2));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.EYEGLASS_OFF)",
            tagIcons::eyeglass_off));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FACE_MASK)",
            tagIcons::face_mask));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FACE_MASK_OFF)",
            tagIcons::face_mask_off));
    icons.add(
        new IconCatalogEntry<>(
            "fall (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.FALL)", tagIcons::fall));
    icons.add(
        new IconCatalogEntry<>(
            "fingerprint-scan (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FINGERPRINT_SCAN)",
            tagIcons::fingerprint_scan));
    icons.add(
        new IconCatalogEntry<>(
            "first-aid-kit (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FIRST_AID_KIT)",
            tagIcons::first_aid_kit));
    icons.add(
        new IconCatalogEntry<>(
            "first-aid-kit-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FIRST_AID_KIT_OFF)",
            tagIcons::first_aid_kit_off));
    icons.add(
        new IconCatalogEntry<>(
            "flask (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FLASK)",
            tagIcons::flask));
    icons.add(
        new IconCatalogEntry<>(
            "flask-2 (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FLASK_2)",
            tagIcons::flask_2));
    icons.add(
        new IconCatalogEntry<>(
            "flask-2-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FLASK_2_OFF)",
            tagIcons::flask_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "flask-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FLASK_OFF)",
            tagIcons::flask_off));
    icons.add(
        new IconCatalogEntry<>(
            "footsteps (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.FOOTSTEPS)",
            tagIcons::footsteps));
    icons.add(
        new IconCatalogEntry<>(
            "hand-sanitizer (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HAND_SANITIZER)",
            tagIcons::hand_sanitizer));
    icons.add(
        new IconCatalogEntry<>(
            "heart-bitcoin (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEART_BITCOIN)",
            tagIcons::heart_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "heart-broken (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEART_BROKEN)",
            tagIcons::heart_broken));
    icons.add(
        new IconCatalogEntry<>(
            "heart-discount (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEART_DISCOUNT)",
            tagIcons::heart_discount));
    icons.add(
        new IconCatalogEntry<>(
            "heart-handshake (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEART_HANDSHAKE)",
            tagIcons::heart_handshake));
    icons.add(
        new IconCatalogEntry<>(
            "heart-rate-monitor (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEART_RATE_MONITOR)",
            tagIcons::heart_rate_monitor));
    icons.add(
        new IconCatalogEntry<>(
            "heartbeat (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HEARTBEAT)",
            tagIcons::heartbeat));
    icons.add(
        new IconCatalogEntry<>(
            "hospital (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HOSPITAL)",
            tagIcons::hospital));
    icons.add(
        new IconCatalogEntry<>(
            "hospital-circle (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.HOSPITAL_CIRCLE)",
            tagIcons::hospital_circle));
    icons.add(
        new IconCatalogEntry<>(
            "lungs (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.LUNGS)",
            tagIcons::lungs));
    icons.add(
        new IconCatalogEntry<>(
            "lungs-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.LUNGS_OFF)",
            tagIcons::lungs_off));
    icons.add(
        new IconCatalogEntry<>(
            "massage (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.MASSAGE)",
            tagIcons::massage));
    icons.add(
        new IconCatalogEntry<>(
            "medicine-syrup (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.MEDICINE_SYRUP)",
            tagIcons::medicine_syrup));
    icons.add(
        new IconCatalogEntry<>(
            "microscope (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.MICROSCOPE)",
            tagIcons::microscope));
    icons.add(
        new IconCatalogEntry<>(
            "microscope-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.MICROSCOPE_OFF)",
            tagIcons::microscope_off));
    icons.add(
        new IconCatalogEntry<>(
            "nurse (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.NURSE)",
            tagIcons::nurse));
    icons.add(
        new IconCatalogEntry<>(
            "old (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.OLD)", tagIcons::old));
    icons.add(
        new IconCatalogEntry<>(
            "physiotherapist (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.PHYSIOTHERAPIST)",
            tagIcons::physiotherapist));
    icons.add(
        new IconCatalogEntry<>(
            "pill (outline)", "TablerIcon.create(TablerHealth.OutlineIcon.PILL)", tagIcons::pill));
    icons.add(
        new IconCatalogEntry<>(
            "pill-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.PILL_OFF)",
            tagIcons::pill_off));
    icons.add(
        new IconCatalogEntry<>(
            "pills (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.PILLS)",
            tagIcons::pills));
    icons.add(
        new IconCatalogEntry<>(
            "plunger (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.PLUNGER)",
            tagIcons::plunger));
    icons.add(
        new IconCatalogEntry<>(
            "prescription (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.PRESCRIPTION)",
            tagIcons::prescription));
    icons.add(
        new IconCatalogEntry<>(
            "razor (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.RAZOR)",
            tagIcons::razor));
    icons.add(
        new IconCatalogEntry<>(
            "razor-electric (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.RAZOR_ELECTRIC)",
            tagIcons::razor_electric));
    icons.add(
        new IconCatalogEntry<>(
            "skull (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.SKULL)",
            tagIcons::skull));
    icons.add(
        new IconCatalogEntry<>(
            "smoking (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.SMOKING)",
            tagIcons::smoking));
    icons.add(
        new IconCatalogEntry<>(
            "smoking-no (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.SMOKING_NO)",
            tagIcons::smoking_no));
    icons.add(
        new IconCatalogEntry<>(
            "stethoscope (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.STETHOSCOPE)",
            tagIcons::stethoscope));
    icons.add(
        new IconCatalogEntry<>(
            "stethoscope-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.STETHOSCOPE_OFF)",
            tagIcons::stethoscope_off));
    icons.add(
        new IconCatalogEntry<>(
            "sunglasses (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.SUNGLASSES)",
            tagIcons::sunglasses));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.THERMOMETER)",
            tagIcons::thermometer));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VACCINE)",
            tagIcons::vaccine));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-bottle (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_BOTTLE)",
            tagIcons::vaccine_bottle));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-bottle-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_BOTTLE_OFF)",
            tagIcons::vaccine_bottle_off));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VACCINE_OFF)",
            tagIcons::vaccine_off));
    icons.add(
        new IconCatalogEntry<>(
            "virus (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VIRUS)",
            tagIcons::virus));
    icons.add(
        new IconCatalogEntry<>(
            "virus-off (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VIRUS_OFF)",
            tagIcons::virus_off));
    icons.add(
        new IconCatalogEntry<>(
            "virus-search (outline)",
            "TablerIcon.create(TablerHealth.OutlineIcon.VIRUS_SEARCH)",
            tagIcons::virus_search));
    icons.add(
        new IconCatalogEntry<>(
            "accessible (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.ACCESSIBLE)",
            tagIcons::accessible_filled));
    icons.add(
        new IconCatalogEntry<>(
            "baby-carriage (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.BABY_CARRIAGE)",
            tagIcons::baby_carriage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bandage (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.BANDAGE)",
            tagIcons::bandage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eye-table (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.EYE_TABLE)",
            tagIcons::eye_table_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.EYEGLASS)",
            tagIcons::eyeglass_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-2 (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.EYEGLASS_2)",
            tagIcons::eyeglass_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.FACE_MASK)",
            tagIcons::face_mask_filled));
    icons.add(
        new IconCatalogEntry<>(
            "flask (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.FLASK)",
            tagIcons::flask_filled));
    icons.add(
        new IconCatalogEntry<>(
            "flask-2 (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.FLASK_2)",
            tagIcons::flask_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "heart-broken (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.HEART_BROKEN)",
            tagIcons::heart_broken_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hospital-circle (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.HOSPITAL_CIRCLE)",
            tagIcons::hospital_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "lungs (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.LUNGS)",
            tagIcons::lungs_filled));
    icons.add(
        new IconCatalogEntry<>(
            "microscope (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.MICROSCOPE)",
            tagIcons::microscope_filled));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "nurse (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.NURSE)",
            tagIcons::nurse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pill (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.PILL)",
            tagIcons::pill_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sunglasses (filled)",
            "TablerIcon.create(TablerHealth.FilledIcon.SUNGLASSES)",
            tagIcons::sunglasses_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
