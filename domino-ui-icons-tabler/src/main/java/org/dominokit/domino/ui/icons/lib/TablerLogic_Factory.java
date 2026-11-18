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
import org.dominokit.domino.ui.icons.TablerLogic;

/** Static icon factory for the Tabler Logic category. */
public final class TablerLogic_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerLogic tagIcons = new TablerLogic() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "logic-and", "TablerIcons.logic_and()", tagIcons::logic_and));
    icons.add(
        new IconCatalogEntry<>(
            "logic-buffer", "TablerIcons.logic_buffer()", tagIcons::logic_buffer));
    icons.add(
        new IconCatalogEntry<>(
            "logic-nand", "TablerIcons.logic_nand()", tagIcons::logic_nand));
    icons.add(
        new IconCatalogEntry<>(
            "logic-nor", "TablerIcons.logic_nor()", tagIcons::logic_nor));
    icons.add(
        new IconCatalogEntry<>(
            "logic-not", "TablerIcons.logic_not()", tagIcons::logic_not));
    icons.add(
        new IconCatalogEntry<>("logic-or", "TablerIcons.logic_or()", tagIcons::logic_or));
    icons.add(
        new IconCatalogEntry<>(
            "logic-xnor", "TablerIcons.logic_xnor()", tagIcons::logic_xnor));
    icons.add(
        new IconCatalogEntry<>(
            "logic-xor", "TablerIcons.logic_xor()", tagIcons::logic_xor));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
