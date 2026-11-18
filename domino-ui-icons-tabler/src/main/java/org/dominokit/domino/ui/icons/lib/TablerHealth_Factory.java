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
            "accessible", "TablerIcons.accessible()", tagIcons::accessible));
    icons.add(
        new IconCatalogEntry<>(
            "accessible-off", "TablerIcons.accessible_off()", tagIcons::accessible_off));
    icons.add(
        new IconCatalogEntry<>("activity", "TablerIcons.activity()", tagIcons::activity));
    icons.add(
        new IconCatalogEntry<>(
            "activity-heartbeat",
            "TablerIcons.activity_heartbeat()",
            tagIcons::activity_heartbeat));
    icons.add(
        new IconCatalogEntry<>(
            "baby-bottle", "TablerIcons.baby_bottle()", tagIcons::baby_bottle));
    icons.add(
        new IconCatalogEntry<>(
            "baby-carriage", "TablerIcons.baby_carriage()", tagIcons::baby_carriage));
    icons.add(
        new IconCatalogEntry<>("bandage", "TablerIcons.bandage()", tagIcons::bandage));
    icons.add(
        new IconCatalogEntry<>(
            "bandage-off", "TablerIcons.bandage_off()", tagIcons::bandage_off));
    icons.add(new IconCatalogEntry<>("blind", "TablerIcons.blind()", tagIcons::blind));
    icons.add(
        new IconCatalogEntry<>("braille", "TablerIcons.braille()", tagIcons::braille));
    icons.add(new IconCatalogEntry<>("brain", "TablerIcons.brain()", tagIcons::brain));
    icons.add(new IconCatalogEntry<>("cane", "TablerIcons.cane()", tagIcons::cane));
    icons.add(
        new IconCatalogEntry<>(
            "checkup-list", "TablerIcons.checkup_list()", tagIcons::checkup_list));
    icons.add(
        new IconCatalogEntry<>("crutches", "TablerIcons.crutches()", tagIcons::crutches));
    icons.add(
        new IconCatalogEntry<>(
            "crutches-off", "TablerIcons.crutches_off()", tagIcons::crutches_off));
    icons.add(new IconCatalogEntry<>("deaf", "TablerIcons.deaf()", tagIcons::deaf));
    icons.add(new IconCatalogEntry<>("dental", "TablerIcons.dental()", tagIcons::dental));
    icons.add(
        new IconCatalogEntry<>(
            "dental-off", "TablerIcons.dental_off()", tagIcons::dental_off));
    icons.add(
        new IconCatalogEntry<>("disabled", "TablerIcons.disabled()", tagIcons::disabled));
    icons.add(
        new IconCatalogEntry<>(
            "disabled-2", "TablerIcons.disabled_2()", tagIcons::disabled_2));
    icons.add(
        new IconCatalogEntry<>(
            "disabled-off", "TablerIcons.disabled_off()", tagIcons::disabled_off));
    icons.add(new IconCatalogEntry<>("dna", "TablerIcons.dna()", tagIcons::dna));
    icons.add(new IconCatalogEntry<>("dna-2", "TablerIcons.dna_2()", tagIcons::dna_2));
    icons.add(
        new IconCatalogEntry<>(
            "dna-2-off", "TablerIcons.dna_2_off()", tagIcons::dna_2_off));
    icons.add(
        new IconCatalogEntry<>("dna-off", "TablerIcons.dna_off()", tagIcons::dna_off));
    icons.add(new IconCatalogEntry<>("ear", "TablerIcons.ear()", tagIcons::ear));
    icons.add(
        new IconCatalogEntry<>("ear-off", "TablerIcons.ear_off()", tagIcons::ear_off));
    icons.add(
        new IconCatalogEntry<>(
            "emergency-bed", "TablerIcons.emergency_bed()", tagIcons::emergency_bed));
    icons.add(
        new IconCatalogEntry<>(
            "empathize", "TablerIcons.empathize()", tagIcons::empathize));
    icons.add(
        new IconCatalogEntry<>(
            "empathize-off", "TablerIcons.empathize_off()", tagIcons::empathize_off));
    icons.add(
        new IconCatalogEntry<>(
            "eye-bitcoin", "TablerIcons.eye_bitcoin()", tagIcons::eye_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "eye-discount", "TablerIcons.eye_discount()", tagIcons::eye_discount));
    icons.add(
        new IconCatalogEntry<>(
            "eye-dotted", "TablerIcons.eye_dotted()", tagIcons::eye_dotted));
    icons.add(
        new IconCatalogEntry<>(
            "eye-table", "TablerIcons.eye_table()", tagIcons::eye_table));
    icons.add(
        new IconCatalogEntry<>("eyeglass", "TablerIcons.eyeglass()", tagIcons::eyeglass));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-2", "TablerIcons.eyeglass_2()", tagIcons::eyeglass_2));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-off", "TablerIcons.eyeglass_off()", tagIcons::eyeglass_off));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask", "TablerIcons.face_mask()", tagIcons::face_mask));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask-off", "TablerIcons.face_mask_off()", tagIcons::face_mask_off));
    icons.add(new IconCatalogEntry<>("fall", "TablerIcons.fall()", tagIcons::fall));
    icons.add(
        new IconCatalogEntry<>(
            "fingerprint-scan",
            "TablerIcons.fingerprint_scan()",
            tagIcons::fingerprint_scan));
    icons.add(
        new IconCatalogEntry<>(
            "first-aid-kit", "TablerIcons.first_aid_kit()", tagIcons::first_aid_kit));
    icons.add(
        new IconCatalogEntry<>(
            "first-aid-kit-off",
            "TablerIcons.first_aid_kit_off()",
            tagIcons::first_aid_kit_off));
    icons.add(new IconCatalogEntry<>("flask", "TablerIcons.flask()", tagIcons::flask));
    icons.add(
        new IconCatalogEntry<>("flask-2", "TablerIcons.flask_2()", tagIcons::flask_2));
    icons.add(
        new IconCatalogEntry<>(
            "flask-2-off", "TablerIcons.flask_2_off()", tagIcons::flask_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "flask-off", "TablerIcons.flask_off()", tagIcons::flask_off));
    icons.add(
        new IconCatalogEntry<>(
            "footsteps", "TablerIcons.footsteps()", tagIcons::footsteps));
    icons.add(
        new IconCatalogEntry<>(
            "hand-sanitizer", "TablerIcons.hand_sanitizer()", tagIcons::hand_sanitizer));
    icons.add(
        new IconCatalogEntry<>(
            "heart-bitcoin", "TablerIcons.heart_bitcoin()", tagIcons::heart_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "heart-broken", "TablerIcons.heart_broken()", tagIcons::heart_broken));
    icons.add(
        new IconCatalogEntry<>(
            "heart-discount", "TablerIcons.heart_discount()", tagIcons::heart_discount));
    icons.add(
        new IconCatalogEntry<>(
            "heart-handshake",
            "TablerIcons.heart_handshake()",
            tagIcons::heart_handshake));
    icons.add(
        new IconCatalogEntry<>(
            "heart-rate-monitor",
            "TablerIcons.heart_rate_monitor()",
            tagIcons::heart_rate_monitor));
    icons.add(
        new IconCatalogEntry<>(
            "heartbeat", "TablerIcons.heartbeat()", tagIcons::heartbeat));
    icons.add(
        new IconCatalogEntry<>("hospital", "TablerIcons.hospital()", tagIcons::hospital));
    icons.add(
        new IconCatalogEntry<>(
            "hospital-circle",
            "TablerIcons.hospital_circle()",
            tagIcons::hospital_circle));
    icons.add(new IconCatalogEntry<>("lungs", "TablerIcons.lungs()", tagIcons::lungs));
    icons.add(
        new IconCatalogEntry<>(
            "lungs-off", "TablerIcons.lungs_off()", tagIcons::lungs_off));
    icons.add(
        new IconCatalogEntry<>("massage", "TablerIcons.massage()", tagIcons::massage));
    icons.add(
        new IconCatalogEntry<>(
            "medicine-syrup", "TablerIcons.medicine_syrup()", tagIcons::medicine_syrup));
    icons.add(
        new IconCatalogEntry<>(
            "microscope", "TablerIcons.microscope()", tagIcons::microscope));
    icons.add(
        new IconCatalogEntry<>(
            "microscope-off", "TablerIcons.microscope_off()", tagIcons::microscope_off));
    icons.add(new IconCatalogEntry<>("nurse", "TablerIcons.nurse()", tagIcons::nurse));
    icons.add(new IconCatalogEntry<>("old", "TablerIcons.old()", tagIcons::old));
    icons.add(
        new IconCatalogEntry<>(
            "physiotherapist",
            "TablerIcons.physiotherapist()",
            tagIcons::physiotherapist));
    icons.add(new IconCatalogEntry<>("pill", "TablerIcons.pill()", tagIcons::pill));
    icons.add(
        new IconCatalogEntry<>("pill-off", "TablerIcons.pill_off()", tagIcons::pill_off));
    icons.add(new IconCatalogEntry<>("pills", "TablerIcons.pills()", tagIcons::pills));
    icons.add(
        new IconCatalogEntry<>("plunger", "TablerIcons.plunger()", tagIcons::plunger));
    icons.add(
        new IconCatalogEntry<>(
            "prescription", "TablerIcons.prescription()", tagIcons::prescription));
    icons.add(new IconCatalogEntry<>("razor", "TablerIcons.razor()", tagIcons::razor));
    icons.add(
        new IconCatalogEntry<>(
            "razor-electric", "TablerIcons.razor_electric()", tagIcons::razor_electric));
    icons.add(new IconCatalogEntry<>("skull", "TablerIcons.skull()", tagIcons::skull));
    icons.add(
        new IconCatalogEntry<>("smoking", "TablerIcons.smoking()", tagIcons::smoking));
    icons.add(
        new IconCatalogEntry<>(
            "smoking-no", "TablerIcons.smoking_no()", tagIcons::smoking_no));
    icons.add(
        new IconCatalogEntry<>(
            "stethoscope", "TablerIcons.stethoscope()", tagIcons::stethoscope));
    icons.add(
        new IconCatalogEntry<>(
            "stethoscope-off",
            "TablerIcons.stethoscope_off()",
            tagIcons::stethoscope_off));
    icons.add(
        new IconCatalogEntry<>(
            "sunglasses", "TablerIcons.sunglasses()", tagIcons::sunglasses));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer", "TablerIcons.thermometer()", tagIcons::thermometer));
    icons.add(
        new IconCatalogEntry<>("vaccine", "TablerIcons.vaccine()", tagIcons::vaccine));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-bottle", "TablerIcons.vaccine_bottle()", tagIcons::vaccine_bottle));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-bottle-off",
            "TablerIcons.vaccine_bottle_off()",
            tagIcons::vaccine_bottle_off));
    icons.add(
        new IconCatalogEntry<>(
            "vaccine-off", "TablerIcons.vaccine_off()", tagIcons::vaccine_off));
    icons.add(new IconCatalogEntry<>("virus", "TablerIcons.virus()", tagIcons::virus));
    icons.add(
        new IconCatalogEntry<>(
            "virus-off", "TablerIcons.virus_off()", tagIcons::virus_off));
    icons.add(
        new IconCatalogEntry<>(
            "virus-search", "TablerIcons.virus_search()", tagIcons::virus_search));
    icons.add(
        new IconCatalogEntry<>(
            "accessible", "TablerIcons.accessible_filled()", tagIcons::accessible_filled));
    icons.add(
        new IconCatalogEntry<>(
            "baby-carriage",
            "TablerIcons.baby_carriage_filled()",
            tagIcons::baby_carriage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bandage", "TablerIcons.bandage_filled()", tagIcons::bandage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eye-table", "TablerIcons.eye_table_filled()", tagIcons::eye_table_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass", "TablerIcons.eyeglass_filled()", tagIcons::eyeglass_filled));
    icons.add(
        new IconCatalogEntry<>(
            "eyeglass-2", "TablerIcons.eyeglass_2_filled()", tagIcons::eyeglass_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "face-mask", "TablerIcons.face_mask_filled()", tagIcons::face_mask_filled));
    icons.add(
        new IconCatalogEntry<>(
            "flask", "TablerIcons.flask_filled()", tagIcons::flask_filled));
    icons.add(
        new IconCatalogEntry<>(
            "flask-2", "TablerIcons.flask_2_filled()", tagIcons::flask_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "heart-broken",
            "TablerIcons.heart_broken_filled()",
            tagIcons::heart_broken_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hospital-circle",
            "TablerIcons.hospital_circle_filled()",
            tagIcons::hospital_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "lungs", "TablerIcons.lungs_filled()", tagIcons::lungs_filled));
    icons.add(
        new IconCatalogEntry<>(
            "microscope", "TablerIcons.microscope_filled()", tagIcons::microscope_filled));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "nurse", "TablerIcons.nurse_filled()", tagIcons::nurse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pill", "TablerIcons.pill_filled()", tagIcons::pill_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sunglasses", "TablerIcons.sunglasses_filled()", tagIcons::sunglasses_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
