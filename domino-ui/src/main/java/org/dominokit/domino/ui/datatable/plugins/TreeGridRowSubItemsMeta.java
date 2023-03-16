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
package org.dominokit.domino.ui.datatable.plugins;

import static java.util.Objects.nonNull;

import java.util.Collection;
import java.util.Collections;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.datatable.RowMeta;
import org.dominokit.domino.ui.datatable.TableRow;

public class TreeGridRowSubItemsMeta<T> implements RowMeta {

  public static final String TREE_GRID_ROW_SUB_ITEMS_META = "tree-grid-row-sub-items-meta";
  private final TreePluginConfig<T> config;
  private Collection<T> records;

  public static <T> TreeGridRowSubItemsMeta<T> of(
      TreePluginConfig<T> config, Collection<T> records) {
    return new TreeGridRowSubItemsMeta<>(config, records);
  }

  public static <T> TreeGridRowSubItemsMeta<T> of(TreePluginConfig<T> config) {
    return new TreeGridRowSubItemsMeta<>(config);
  }

  public TreeGridRowSubItemsMeta(TreePluginConfig<T> config) {
    this.config = config;
  }

  public TreeGridRowSubItemsMeta(TreePluginConfig<T> config, Collection<T> records) {
    this.config = config;
    this.records = records;
  }

  public static <T> Optional<TreeGridRowSubItemsMeta<T>> get(TableRow<T> row) {
    return row.getMeta(TREE_GRID_ROW_SUB_ITEMS_META);
  }

  public TreeGridRowSubItemsMeta<T> getRecords(
      TableRow<T> row, Consumer<Optional<Collection<T>>> recordsConsumer) {
    if (nonNull(records)) {
      recordsConsumer.accept(Optional.of(records));
    } else {
      config
          .getSubItemsProvider()
          .get(
              row.getRecord(),
              items -> {
                this.records = items.orElse(Collections.emptyList());
                recordsConsumer.accept(items);
              });
    }
    return this;
  }

  public boolean loaded() {
    return nonNull(records);
  }

  @Override
  public String getKey() {
    return TREE_GRID_ROW_SUB_ITEMS_META;
  }
}
