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
import org.dominokit.domino.ui.icons.TablerExtensions;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Extensions category. */
public final class TablerExtensions_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerExtensions tagIcons = new TablerExtensions() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "bmp (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.BMP)", tagIcons::bmp));
    icons.add(
        new IconCatalogEntry<>(
            "csv (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.CSV)", tagIcons::csv));
    icons.add(
        new IconCatalogEntry<>(
            "gif (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.GIF)", tagIcons::gif));
    icons.add(
        new IconCatalogEntry<>(
            "html (outline)",
            "TablerIcon.create(TablerExtensions.OutlineIcon.HTML)",
            tagIcons::html));
    icons.add(
        new IconCatalogEntry<>(
            "jpg (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.JPG)", tagIcons::jpg));
    icons.add(
        new IconCatalogEntry<>(
            "json (outline)",
            "TablerIcon.create(TablerExtensions.OutlineIcon.JSON)",
            tagIcons::json));
    icons.add(
        new IconCatalogEntry<>(
            "pdf (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.PDF)", tagIcons::pdf));
    icons.add(
        new IconCatalogEntry<>(
            "png (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.PNG)", tagIcons::png));
    icons.add(
        new IconCatalogEntry<>(
            "sql (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.SQL)", tagIcons::sql));
    icons.add(
        new IconCatalogEntry<>(
            "svg (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.SVG)", tagIcons::svg));
    icons.add(
        new IconCatalogEntry<>(
            "toml (outline)",
            "TablerIcon.create(TablerExtensions.OutlineIcon.TOML)",
            tagIcons::toml));
    icons.add(
        new IconCatalogEntry<>(
            "txt (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.TXT)", tagIcons::txt));
    icons.add(
        new IconCatalogEntry<>(
            "zip (outline)", "TablerIcon.create(TablerExtensions.OutlineIcon.ZIP)", tagIcons::zip));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
