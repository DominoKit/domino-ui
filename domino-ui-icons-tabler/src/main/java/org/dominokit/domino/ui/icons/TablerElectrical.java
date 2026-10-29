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
package org.dominokit.domino.ui.icons;

/** Tabler Electrical catalog category. */
public interface TablerElectrical {
  enum OutlineIcon implements TablerIconDefinition {
    CIRCUIT_AMMETER(
        "circuit-ammeter",
        "<path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M5 12h-3\" />\n  <path d=\"M19 12h3\" />\n  <path d=\"M10 14v-3c0 -1.036 .895 -2 2 -2s2 .964 2 2v3\" />\n  <path d=\"M14 12h-4\" />"),
    CIRCUIT_BATTERY(
        "circuit-battery",
        "<path d=\"M2 12h4\" />\n  <path d=\"M18 12h4\" />\n  <path d=\"M18 5v14\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M10 5v14\" />\n  <path d=\"M6 9v6\" />"),
    CIRCUIT_BULB(
        "circuit-bulb",
        "<path d=\"M2 12h5\" />\n  <path d=\"M17 12h5\" />\n  <path d=\"M7 12a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M8.5 8.5l7 7\" />\n  <path d=\"M15.5 8.5l-7 7\" />"),
    CIRCUIT_CAPACITOR(
        "circuit-capacitor",
        "<path d=\"M22 12h-8\" />\n  <path d=\"M2 12h8\" />\n  <path d=\"M10 7v10\" />\n  <path d=\"M14 7v10\" />"),
    CIRCUIT_CAPACITOR_POLARIZED(
        "circuit-capacitor-polarized",
        "<path d=\"M22 12h-8\" />\n  <path d=\"M2 12h8\" />\n  <path d=\"M10 7v10\" />\n  <path d=\"M14 7v10\" />\n  <path d=\"M17 5h4\" />\n  <path d=\"M19 3v4\" />"),
    CIRCUIT_CELL(
        "circuit-cell",
        "<path d=\"M2 12h8\" />\n  <path d=\"M14 12h8\" />\n  <path d=\"M10 5v14\" />\n  <path d=\"M14 9v6\" />"),
    CIRCUIT_CELL_PLUS(
        "circuit-cell-plus",
        "<path d=\"M2 12h9\" />\n  <path d=\"M15 12h7\" />\n  <path d=\"M11 5v14\" />\n  <path d=\"M15 9v6\" />\n  <path d=\"M3 5h4\" />\n  <path d=\"M5 3v4\" />"),
    CIRCUIT_CHANGEOVER(
        "circuit-changeover",
        "<path d=\"M2 12h2\" />\n  <path d=\"M20 7h2\" />\n  <path d=\"M4 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 7a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M16 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7.5 10.5l8.5 -3.5\" />"),
    CIRCUIT_DIODE(
        "circuit-diode",
        "<path d=\"M22 12h-6\" />\n  <path d=\"M2 12h6\" />\n  <path d=\"M8 7l8 5l-8 5l0 -10\" />\n  <path d=\"M16 7v10\" />"),
    CIRCUIT_DIODE_ZENER(
        "circuit-diode-zener",
        "<path d=\"M22 12h-6\" />\n  <path d=\"M2 12h6\" />\n  <path d=\"M8 7l8 5l-8 5l0 -10\" />\n  <path d=\"M14 7h2v10h2\" />"),
    CIRCUIT_GROUND(
        "circuit-ground",
        "<path d=\"M12 13v-8\" />\n  <path d=\"M4 13h16\" />\n  <path d=\"M7 16h10\" />\n  <path d=\"M10 19h4\" />"),
    CIRCUIT_GROUND_DIGITAL(
        "circuit-ground-digital",
        "<path d=\"M12 13v-10\" />\n  <path d=\"M12 21l-6 -8h12l-6 8\" />"),
    CIRCUIT_INDUCTOR(
        "circuit-inductor",
        "<path d=\"M2 14h3v-2a2 2 0 1 1 4 0v2v-1.5a2.5 2.5 0 1 1 5 0v1.5v-1.5a2.5 2.5 0 1 1 5 0v1.5h3\" />"),
    CIRCUIT_MOTOR(
        "circuit-motor",
        "<path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M5 12h-3\" />\n  <path d=\"M19 12h3\" />\n  <path d=\"M10 14v-4l2 2l2 -2v4\" />"),
    CIRCUIT_PUSHBUTTON(
        "circuit-pushbutton",
        "<path d=\"M2 17h2\" />\n  <path d=\"M20 17h2\" />\n  <path d=\"M4 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 17a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M6 11h12\" />\n  <path d=\"M12 11v-6\" />"),
    CIRCUIT_RESISTOR(
        "circuit-resistor", "<path d=\"M2 12h2l2 -5l3 10l3 -10l3 10l3 -10l1.5 5h2.5\" />"),
    CIRCUIT_SWITCH_CLOSED(
        "circuit-switch-closed",
        "<path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M4 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M8 12h8\" />"),
    CIRCUIT_SWITCH_OPEN(
        "circuit-switch-open",
        "<path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M4 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7.5 10.5l7.5 -5.5\" />"),
    CIRCUIT_VOLTMETER(
        "circuit-voltmeter",
        "<path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M5 12h-3\" />\n  <path d=\"M19 12h3\" />\n  <path d=\"M10 10l2 4l2 -4\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  enum FilledIcon implements TablerIconDefinition {
    ;

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "filled";
    }
  }

  default TablerIcon circuit_ammeter() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_AMMETER);
  }

  default TablerIcon circuit_battery() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_BATTERY);
  }

  default TablerIcon circuit_bulb() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_BULB);
  }

  default TablerIcon circuit_capacitor() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CAPACITOR);
  }

  default TablerIcon circuit_capacitor_polarized() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CAPACITOR_POLARIZED);
  }

  default TablerIcon circuit_cell() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CELL);
  }

  default TablerIcon circuit_cell_plus() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CELL_PLUS);
  }

  default TablerIcon circuit_changeover() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_CHANGEOVER);
  }

  default TablerIcon circuit_diode() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_DIODE);
  }

  default TablerIcon circuit_diode_zener() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_DIODE_ZENER);
  }

  default TablerIcon circuit_ground() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_GROUND);
  }

  default TablerIcon circuit_ground_digital() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_GROUND_DIGITAL);
  }

  default TablerIcon circuit_inductor() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_INDUCTOR);
  }

  default TablerIcon circuit_motor() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_MOTOR);
  }

  default TablerIcon circuit_pushbutton() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_PUSHBUTTON);
  }

  default TablerIcon circuit_resistor() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_RESISTOR);
  }

  default TablerIcon circuit_switch_closed() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_SWITCH_CLOSED);
  }

  default TablerIcon circuit_switch_open() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_SWITCH_OPEN);
  }

  default TablerIcon circuit_voltmeter() {
    return TablerIcon.create(TablerElectrical.OutlineIcon.CIRCUIT_VOLTMETER);
  }
}
