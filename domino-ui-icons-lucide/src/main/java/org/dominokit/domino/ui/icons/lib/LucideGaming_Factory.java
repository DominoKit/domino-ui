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
import org.dominokit.domino.ui.icons.LucideGaming;
import org.dominokit.domino.ui.icons.LucideIcon;

/** Static icon factory for the Lucide Gaming category. */
public final class LucideGaming_Factory {
  private static final List<IconCatalogEntry<LucideIcon>> icons = new ArrayList<>();

  static {
    for (LucideGaming.Icon definition : LucideGaming.Icon.values()) {
      String code = "LucideIcon.create(LucideGaming.Icon." + definition.name() + ")";
      icons.add(
          new IconCatalogEntry<>(
              definition.catalogName(), code, () -> LucideIcon.create(definition)));
    }
  }

  public List<IconCatalogEntry<LucideIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
