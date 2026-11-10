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
import org.dominokit.domino.ui.icons.LucideHome;
import org.dominokit.domino.ui.icons.LucideIcon;

/** Static icon factory for the Lucide Home category. */
public final class LucideHome_Factory {
  private static final List<IconCatalogEntry<LucideIcon>> icons = new ArrayList<>();

  static {
    for (LucideHome.Icon definition : LucideHome.Icon.values()) {
      String code = "LucideIcon.create(LucideHome.Icon." + definition.name() + ")";
      icons.add(
          new IconCatalogEntry<>(
              definition.catalogName(), code, () -> LucideIcon.create(definition)));
    }
  }

  public List<IconCatalogEntry<LucideIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
