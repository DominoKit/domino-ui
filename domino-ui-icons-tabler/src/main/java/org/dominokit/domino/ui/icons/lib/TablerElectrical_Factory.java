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
            "circuit-ammeter",
            "TablerIcons.circuit_ammeter()",
            tagIcons::circuit_ammeter));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-battery",
            "TablerIcons.circuit_battery()",
            tagIcons::circuit_battery));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-bulb", "TablerIcons.circuit_bulb()", tagIcons::circuit_bulb));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-capacitor",
            "TablerIcons.circuit_capacitor()",
            tagIcons::circuit_capacitor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-capacitor-polarized",
            "TablerIcons.circuit_capacitor_polarized()",
            tagIcons::circuit_capacitor_polarized));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-cell", "TablerIcons.circuit_cell()", tagIcons::circuit_cell));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-cell-plus",
            "TablerIcons.circuit_cell_plus()",
            tagIcons::circuit_cell_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-changeover",
            "TablerIcons.circuit_changeover()",
            tagIcons::circuit_changeover));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-diode", "TablerIcons.circuit_diode()", tagIcons::circuit_diode));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-diode-zener",
            "TablerIcons.circuit_diode_zener()",
            tagIcons::circuit_diode_zener));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-ground", "TablerIcons.circuit_ground()", tagIcons::circuit_ground));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-ground-digital",
            "TablerIcons.circuit_ground_digital()",
            tagIcons::circuit_ground_digital));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-inductor",
            "TablerIcons.circuit_inductor()",
            tagIcons::circuit_inductor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-motor", "TablerIcons.circuit_motor()", tagIcons::circuit_motor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-pushbutton",
            "TablerIcons.circuit_pushbutton()",
            tagIcons::circuit_pushbutton));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-resistor",
            "TablerIcons.circuit_resistor()",
            tagIcons::circuit_resistor));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-switch-closed",
            "TablerIcons.circuit_switch_closed()",
            tagIcons::circuit_switch_closed));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-switch-open",
            "TablerIcons.circuit_switch_open()",
            tagIcons::circuit_switch_open));
    icons.add(
        new IconCatalogEntry<>(
            "circuit-voltmeter",
            "TablerIcons.circuit_voltmeter()",
            tagIcons::circuit_voltmeter));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
