/*
 * Copyright © 2019 Dominokit
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

package org.dominokit.domino.ui.datatable.plugins.tree;

import static java.util.Objects.nonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.tree.store.TreeNodeStore;
import org.dominokit.domino.ui.datatable.plugins.tree.store.TreeNodeStoreContext;
import org.dominokit.domino.ui.datatable.store.DataStore;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * The {@code TreeGridRowSubItemsMeta} class provides metadata and utilities for managing sub-items
 * in a tree grid. It is used in conjunction with the TreeGridPlugin to enable hierarchical data
 * rendering in a DataTable.
 *
 * @param <T> The type of data records in the DataTable.
 */
public class TreeGridRowSubItemsMeta<T> implements ComponentMeta {

  /** A constant representing the key for accessing this metadata in a TableRow. */
  public static final String TREE_GRID_ROW_SUB_ITEMS_META = "tree-grid-row-sub-items-meta";

  private final TreePluginConfig<T> config;
  private Collection<T> records;

  /**
   * Static factory method to create an instance of {@code TreeGridRowSubItemsMeta} with the
   * specified configuration and records.
   *
   * @param <T> The type of data records in the DataTable.
   * @param config The configuration for the TreeGridPlugin.
   * @param records The collection of sub-items records.
   * @return A new instance of {@code TreeGridRowSubItemsMeta}.
   */
  public static <T> TreeGridRowSubItemsMeta<T> of(
      TreePluginConfig<T> config, Collection<T> records) {
    return new TreeGridRowSubItemsMeta<>(config, records);
  }

  /**
   * Static factory method to create an instance of {@code TreeGridRowSubItemsMeta} with the
   * specified configuration.
   *
   * @param <T> The type of data records in the DataTable.
   * @param config The configuration for the TreeGridPlugin.
   * @return A new instance of {@code TreeGridRowSubItemsMeta}.
   */
  public static <T> TreeGridRowSubItemsMeta<T> of(TreePluginConfig<T> config) {
    return new TreeGridRowSubItemsMeta<>(config);
  }

  /**
   * Creates a new instance of {@code TreeGridRowSubItemsMeta} with the specified configuration and
   * records.
   *
   * @param config The configuration for the TreeGridPlugin.
   * @param records The collection of sub-items records.
   */
  public TreeGridRowSubItemsMeta(TreePluginConfig<T> config) {
    this.config = config;
  }

  /**
   * Creates a new instance of {@code TreeGridRowSubItemsMeta} with the specified configuration.
   *
   * @param config The configuration for the TreeGridPlugin.
   */
  public TreeGridRowSubItemsMeta(TreePluginConfig<T> config, Collection<T> records) {
    this.config = config;
    this.records = records;
  }

  /**
   * Gets the {@code TreeGridRowSubItemsMeta} instance associated with the provided TableRow.
   *
   * @param <T> The type of data records in the DataTable.
   * @param row The TableRow for which to retrieve the metadata.
   * @return An optional containing the {@code TreeGridRowSubItemsMeta} instance, if available.
   */
  public static <T> Optional<TreeGridRowSubItemsMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TREE_GRID_ROW_SUB_ITEMS_META);
  }

  /**
   * Retrieves the sub-items records associated with the provided TableRow and invokes a consumer to
   * process them.
   *
   * @param row The TableRow for which to retrieve the sub-items records.
   * @param recordsConsumer The consumer function to process the retrieved records.
   * @return The current {@code TreeGridRowSubItemsMeta} instance.
   */
  public TreeGridRowSubItemsMeta<T> getRecords(
      TableRow<T> row, Consumer<Optional<Collection<T>>> recordsConsumer) {

    DataStore<T> dataStore = row.getDataTable().getDataStore();
    if (!(dataStore instanceof TreeNodeStore)) {
      throw new IllegalArgumentException(
          "Tree plugin requires the use of a Store that implements the TreeGridPlugin.SubItemsProvider");
    }
    TreeNodeStore<T> treeNodeStore = (TreeNodeStore<T>) dataStore;
    treeNodeStore.getNodeChildren(
        new TreeNodeStoreContext<>(
            row.getRecord(), treeNodeStore.getLastSearch(), treeNodeStore.getLastSort()),
        items -> {
          this.records = items.orElse(Collections.emptyList());
          recordsConsumer.accept(items);
        });
    return this;
  }

  /**
   * Checks if the provided TableRow has children records.
   *
   * @param row The TableRow to check for children records.
   * @return {@code true} if the TableRow has children records, {@code false} otherwise.
   */
  @SuppressWarnings("unchecked")
  public boolean hasChildren(TableRow<T> row) {
    if (row.getRecord() instanceof IsTreeNode) {
      return ((IsTreeNode) row.getRecord()).hasChildren();
    } else if (row.getDataTable().getDataStore() instanceof TreeNodeChildrenAware) {
      TreeNodeChildrenAware<T> dataStore =
          (TreeNodeChildrenAware<T>) row.getDataTable().getDataStore();
      return dataStore.hasChildren(row.getRecord());
    }
    return ((TreeNodeStore<T>) row.getDataTable().getDataStore()).hasChildren(row.getRecord());
  }

  /**
   * Checks if the sub-items records have been loaded.
   *
   * @return {@code true} if the sub-items records have been loaded, {@code false} otherwise.
   */
  public boolean loaded() {
    return nonNull(records);
  }

  /**
   * Gets the key associated with this metadata.
   *
   * @return The key for accessing this metadata.
   */
  @Override
  public String getKey() {
    return TREE_GRID_ROW_SUB_ITEMS_META;
  }
}
