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
            "column-insert-left (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_INSERT_LEFT)",
            tagIcons::column_insert_left));
    icons.add(
        new IconCatalogEntry<>(
            "column-insert-right (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_INSERT_RIGHT)",
            tagIcons::column_insert_right));
    icons.add(
        new IconCatalogEntry<>(
            "column-remove (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.COLUMN_REMOVE)",
            tagIcons::column_remove));
    icons.add(
        new IconCatalogEntry<>(
            "database (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE)",
            tagIcons::database));
    icons.add(
        new IconCatalogEntry<>(
            "database-cog (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_COG)",
            tagIcons::database_cog));
    icons.add(
        new IconCatalogEntry<>(
            "database-dollar (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_DOLLAR)",
            tagIcons::database_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "database-edit (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EDIT)",
            tagIcons::database_edit));
    icons.add(
        new IconCatalogEntry<>(
            "database-exclamation (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EXCLAMATION)",
            tagIcons::database_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "database-export (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_EXPORT)",
            tagIcons::database_export));
    icons.add(
        new IconCatalogEntry<>(
            "database-heart (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_HEART)",
            tagIcons::database_heart));
    icons.add(
        new IconCatalogEntry<>(
            "database-import (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_IMPORT)",
            tagIcons::database_import));
    icons.add(
        new IconCatalogEntry<>(
            "database-leak (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_LEAK)",
            tagIcons::database_leak));
    icons.add(
        new IconCatalogEntry<>(
            "database-minus (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_MINUS)",
            tagIcons::database_minus));
    icons.add(
        new IconCatalogEntry<>(
            "database-off (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_OFF)",
            tagIcons::database_off));
    icons.add(
        new IconCatalogEntry<>(
            "database-plus (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_PLUS)",
            tagIcons::database_plus));
    icons.add(
        new IconCatalogEntry<>(
            "database-search (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_SEARCH)",
            tagIcons::database_search));
    icons.add(
        new IconCatalogEntry<>(
            "database-share (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_SHARE)",
            tagIcons::database_share));
    icons.add(
        new IconCatalogEntry<>(
            "database-star (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_STAR)",
            tagIcons::database_star));
    icons.add(
        new IconCatalogEntry<>(
            "database-x (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.DATABASE_X)",
            tagIcons::database_x));
    icons.add(
        new IconCatalogEntry<>(
            "relation-many-to-many (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_MANY_TO_MANY)",
            tagIcons::relation_many_to_many));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-many (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_ONE_TO_MANY)",
            tagIcons::relation_one_to_many));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-one (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.RELATION_ONE_TO_ONE)",
            tagIcons::relation_one_to_one));
    icons.add(
        new IconCatalogEntry<>(
            "row-insert-bottom (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.ROW_INSERT_BOTTOM)",
            tagIcons::row_insert_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "row-insert-top (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.ROW_INSERT_TOP)",
            tagIcons::row_insert_top));
    icons.add(
        new IconCatalogEntry<>(
            "row-remove (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.ROW_REMOVE)",
            tagIcons::row_remove));
    icons.add(
        new IconCatalogEntry<>(
            "schema (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.SCHEMA)",
            tagIcons::schema));
    icons.add(
        new IconCatalogEntry<>(
            "schema-off (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.SCHEMA_OFF)",
            tagIcons::schema_off));
    icons.add(
        new IconCatalogEntry<>(
            "table (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE)",
            tagIcons::table));
    icons.add(
        new IconCatalogEntry<>(
            "table-alias (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_ALIAS)",
            tagIcons::table_alias));
    icons.add(
        new IconCatalogEntry<>(
            "table-column (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_COLUMN)",
            tagIcons::table_column));
    icons.add(
        new IconCatalogEntry<>(
            "table-down (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_DOWN)",
            tagIcons::table_down));
    icons.add(
        new IconCatalogEntry<>(
            "table-export (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_EXPORT)",
            tagIcons::table_export));
    icons.add(
        new IconCatalogEntry<>(
            "table-heart (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_HEART)",
            tagIcons::table_heart));
    icons.add(
        new IconCatalogEntry<>(
            "table-import (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_IMPORT)",
            tagIcons::table_import));
    icons.add(
        new IconCatalogEntry<>(
            "table-minus (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_MINUS)",
            tagIcons::table_minus));
    icons.add(
        new IconCatalogEntry<>(
            "table-off (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_OFF)",
            tagIcons::table_off));
    icons.add(
        new IconCatalogEntry<>(
            "table-options (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_OPTIONS)",
            tagIcons::table_options));
    icons.add(
        new IconCatalogEntry<>(
            "table-plus (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_PLUS)",
            tagIcons::table_plus));
    icons.add(
        new IconCatalogEntry<>(
            "table-row (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_ROW)",
            tagIcons::table_row));
    icons.add(
        new IconCatalogEntry<>(
            "table-share (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SHARE)",
            tagIcons::table_share));
    icons.add(
        new IconCatalogEntry<>(
            "table-shortcut (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SHORTCUT)",
            tagIcons::table_shortcut));
    icons.add(
        new IconCatalogEntry<>(
            "table-spark (outline)",
            "TablerIcon.create(TablerDatabase.OutlineIcon.TABLE_SPARK)",
            tagIcons::table_spark));
    icons.add(
        new IconCatalogEntry<>(
            "database (filled)",
            "TablerIcon.create(TablerDatabase.FilledIcon.DATABASE)",
            tagIcons::database_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-many-to-many (filled)",
            "TablerIcon.create(TablerDatabase.FilledIcon.RELATION_MANY_TO_MANY)",
            tagIcons::relation_many_to_many_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-many (filled)",
            "TablerIcon.create(TablerDatabase.FilledIcon.RELATION_ONE_TO_MANY)",
            tagIcons::relation_one_to_many_filled));
    icons.add(
        new IconCatalogEntry<>(
            "relation-one-to-one (filled)",
            "TablerIcon.create(TablerDatabase.FilledIcon.RELATION_ONE_TO_ONE)",
            tagIcons::relation_one_to_one_filled));
    icons.add(
        new IconCatalogEntry<>(
            "table (filled)",
            "TablerIcon.create(TablerDatabase.FilledIcon.TABLE)",
            tagIcons::table_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
