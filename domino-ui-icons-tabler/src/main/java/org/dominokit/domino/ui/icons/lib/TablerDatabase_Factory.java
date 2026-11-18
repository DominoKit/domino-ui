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
import org.dominokit.domino.ui.icons.TablerDatabase;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Database category. */
public final class TablerDatabase_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerDatabase tagIcons = new TablerDatabase() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "column-insert-left",
            "TablerIcons.column_insert_left()",
            tagIcons::column_insert_left));
    icons.add(
        new IconCatalogEntry<>(
            "column-insert-right",
            "TablerIcons.column_insert_right()",
            tagIcons::column_insert_right));
    icons.add(
        new IconCatalogEntry<>(
            "column-remove", "TablerIcons.column_remove()", tagIcons::column_remove));
    icons.add(
        new IconCatalogEntry<>("database", "TablerIcons.database()", tagIcons::database));
    icons.add(
        new IconCatalogEntry<>(
            "database-cog", "TablerIcons.database_cog()", tagIcons::database_cog));
    icons.add(
        new IconCatalogEntry<>(
            "database-dollar",
            "TablerIcons.database_dollar()",
            tagIcons::database_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "database-edit", "TablerIcons.database_edit()", tagIcons::database_edit));
    icons.add(
        new IconCatalogEntry<>(
            "database-exclamation",
            "TablerIcons.database_exclamation()",
            tagIcons::database_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "database-export",
            "TablerIcons.database_export()",
            tagIcons::database_export));
    icons.add(
        new IconCatalogEntry<>(
            "database-heart", "TablerIcons.database_heart()", tagIcons::database_heart));
    icons.add(
        new IconCatalogEntry<>(
            "database-import",
            "TablerIcons.database_import()",
            tagIcons::database_import));
    icons.add(
        new IconCatalogEntry<>(
            "database-leak", "TablerIcons.database_leak()", tagIcons::database_leak));
    icons.add(
        new IconCatalogEntry<>(
            "database-minus", "TablerIcons.database_minus()", tagIcons::database_minus));
    icons.add(
        new IconCatalogEntry<>(
            "database-off", "TablerIcons.database_off()", tagIcons::database_off));
    icons.add(
        new IconCatalogEntry<>(
            "database-plus", "TablerIcons.database_plus()", tagIcons::database_plus));
    icons.add(
        new IconCatalogEntry<>(
            "database-search",
            "TablerIcons.database_search()",
            tagIcons::database_search));
    icons.add(
        new IconCatalogEntry<>(
            "database-share", "TablerIcons.database_share()", tagIcons::database_share));
    icons.add(
        new IconCatalogEntry<>(
            "database-star", "TablerIcons.database_star()", tagIcons::database_star));
    icons.add(
        new IconCatalogEntry<>(
            "database-x", "TablerIcons.database_x()", tagIcons::database_x));
    icons.add(
        new IconCatalogEntry<>(
            "relation-many-to-many",
            "TablerIcons.relation_many_to_many()",
            tagIcons::relation_many_to_many));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-many",
            "TablerIcons.relation_one_to_many()",
            tagIcons::relation_one_to_many));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-one",
            "TablerIcons.relation_one_to_one()",
            tagIcons::relation_one_to_one));
    icons.add(
        new IconCatalogEntry<>(
            "row-insert-bottom",
            "TablerIcons.row_insert_bottom()",
            tagIcons::row_insert_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "row-insert-top", "TablerIcons.row_insert_top()", tagIcons::row_insert_top));
    icons.add(
        new IconCatalogEntry<>(
            "row-remove", "TablerIcons.row_remove()", tagIcons::row_remove));
    icons.add(new IconCatalogEntry<>("schema", "TablerIcons.schema()", tagIcons::schema));
    icons.add(
        new IconCatalogEntry<>(
            "schema-off", "TablerIcons.schema_off()", tagIcons::schema_off));
    icons.add(new IconCatalogEntry<>("table", "TablerIcons.table()", tagIcons::table));
    icons.add(
        new IconCatalogEntry<>(
            "table-alias", "TablerIcons.table_alias()", tagIcons::table_alias));
    icons.add(
        new IconCatalogEntry<>(
            "table-column", "TablerIcons.table_column()", tagIcons::table_column));
    icons.add(
        new IconCatalogEntry<>(
            "table-down", "TablerIcons.table_down()", tagIcons::table_down));
    icons.add(
        new IconCatalogEntry<>(
            "table-export", "TablerIcons.table_export()", tagIcons::table_export));
    icons.add(
        new IconCatalogEntry<>(
            "table-heart", "TablerIcons.table_heart()", tagIcons::table_heart));
    icons.add(
        new IconCatalogEntry<>(
            "table-import", "TablerIcons.table_import()", tagIcons::table_import));
    icons.add(
        new IconCatalogEntry<>(
            "table-minus", "TablerIcons.table_minus()", tagIcons::table_minus));
    icons.add(
        new IconCatalogEntry<>(
            "table-off", "TablerIcons.table_off()", tagIcons::table_off));
    icons.add(
        new IconCatalogEntry<>(
            "table-options", "TablerIcons.table_options()", tagIcons::table_options));
    icons.add(
        new IconCatalogEntry<>(
            "table-plus", "TablerIcons.table_plus()", tagIcons::table_plus));
    icons.add(
        new IconCatalogEntry<>(
            "table-row", "TablerIcons.table_row()", tagIcons::table_row));
    icons.add(
        new IconCatalogEntry<>(
            "table-share", "TablerIcons.table_share()", tagIcons::table_share));
    icons.add(
        new IconCatalogEntry<>(
            "table-shortcut", "TablerIcons.table_shortcut()", tagIcons::table_shortcut));
    icons.add(
        new IconCatalogEntry<>(
            "table-spark", "TablerIcons.table_spark()", tagIcons::table_spark));
    icons.add(
        new IconCatalogEntry<>(
            "database", "TablerIcons.database_filled()", tagIcons::database_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-many-to-many",
            "TablerIcons.relation_many_to_many_filled()",
            tagIcons::relation_many_to_many_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-many",
            "TablerIcons.relation_one_to_many_filled()",
            tagIcons::relation_one_to_many_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-one",
            "TablerIcons.relation_one_to_one_filled()",
            tagIcons::relation_one_to_one_filled));
    icons.add(
        new IconCatalogEntry<>(
            "table", "TablerIcons.table_filled()", tagIcons::table_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
