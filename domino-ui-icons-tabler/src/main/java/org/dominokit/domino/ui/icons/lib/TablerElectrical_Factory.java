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
import org.dominokit.domino.ui.icons.TablerElectrical;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Electrical category. */
public final class TablerElectrical_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerElectrical tagIcons = new TablerElectrical() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "circuit-ammeter (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_AMMETER)",
            tagIcons::circuit_ammeter));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-battery (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_BATTERY)",
            tagIcons::circuit_battery));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-bulb (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_BULB)",
            tagIcons::circuit_bulb));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-capacitor (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CAPACITOR)",
            tagIcons::circuit_capacitor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-capacitor-polarized (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CAPACITOR_POLARIZED)",
            tagIcons::circuit_capacitor_polarized));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-cell (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CELL)",
            tagIcons::circuit_cell));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-cell-plus (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CELL_PLUS)",
            tagIcons::circuit_cell_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-changeover (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CHANGEOVER)",
            tagIcons::circuit_changeover));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-diode (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_DIODE)",
            tagIcons::circuit_diode));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-diode-zener (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_DIODE_ZENER)",
            tagIcons::circuit_diode_zener));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-ground (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_GROUND)",
            tagIcons::circuit_ground));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-ground-digital (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_GROUND_DIGITAL)",
            tagIcons::circuit_ground_digital));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-inductor (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_INDUCTOR)",
            tagIcons::circuit_inductor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-motor (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_MOTOR)",
            tagIcons::circuit_motor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-pushbutton (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_PUSHBUTTON)",
            tagIcons::circuit_pushbutton));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-resistor (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_RESISTOR)",
            tagIcons::circuit_resistor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-switch-closed (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_SWITCH_CLOSED)",
            tagIcons::circuit_switch_closed));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-switch-open (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_SWITCH_OPEN)",
            tagIcons::circuit_switch_open));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-voltmeter (outline)",
            "TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_VOLTMETER)",
            tagIcons::circuit_voltmeter));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
