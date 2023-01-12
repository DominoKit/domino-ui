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

import static java.util.Objects.isNull;

import elemental2.dom.Node;
import java.util.function.Function;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.TextNode;

public class TreePluginConfig<T> implements PluginConfig {

  public static final int DEFAULT_INDENT = 20;

  private boolean lazy = false;
  private final TreeGridPlugin.SubItemsProvider<T> subItemsProvider;
  private TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier;
  private Supplier<BaseIcon<?>> expandIconSupplier = Icons.ALL::menu_right_mdi;
  private Supplier<BaseIcon<?>> collapseIconSupplier = Icons.ALL::menu_down_mdi;
  private Supplier<BaseIcon<?>> leafIconSupplier = Icons.ALL::circle_medium_mdi;
  private Function<TableRow<T>, Node> indentColumnElementSupplier = tableRow -> TextNode.empty();
  private int indent = DEFAULT_INDENT;

  public TreePluginConfig(TreeGridPlugin.SubItemsProvider<T> subItemsProvider) {
    this.subItemsProvider = subItemsProvider;
  }

  public boolean isLazy() {
    return lazy;
  }

  public TreePluginConfig setLazy(boolean lazy) {
    this.lazy = lazy;
    return this;
  }

  public TreeGridPlugin.SubItemsProvider<T> getSubItemsProvider() {
    return subItemsProvider;
  }

  public TreeGridPlugin.ParentRowCellsSupplier<T> getParentRowCellsSupplier() {
    return parentRowCellsSupplier;
  }

  /**
   * Set a supplier that provides cells to be rendered in a parent row cells, this can be used to
   * provide a custom UI for parent rows
   *
   * @param parentRowCellsSupplier {@link TreeGridPlugin.ParentRowCellsSupplier}
   * @return Same config instance
   */
  public TreePluginConfig<T> setParentRowCellsSupplier(
      TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier) {
    this.parentRowCellsSupplier = parentRowCellsSupplier;
    return this;
  }

  public Supplier<BaseIcon<?>> getExpandIconSupplier() {
    return expandIconSupplier;
  }

  /**
   * Sets a supplier for a custom expand icon instead of the default one
   *
   * @param expandIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same config instance
   */
  public TreePluginConfig<T> setExpandIconSupplier(Supplier<BaseIcon<?>> expandIconSupplier) {
    if (isNull(expandIconSupplier)) {
      this.expandIconSupplier = () -> Icons.ALL.plus_mdi().size18();
    } else {
      this.expandIconSupplier = expandIconSupplier;
    }
    return this;
  }

  public Supplier<BaseIcon<?>> getCollapseIconSupplier() {
    return collapseIconSupplier;
  }

  /**
   * Sets a supplier for a custom collapse icon instead of the default one
   *
   * @param collapseIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same config instance
   */
  public TreePluginConfig<T> setCollapseIconSupplier(Supplier<BaseIcon<?>> collapseIconSupplier) {
    if (isNull(collapseIconSupplier)) {
      this.collapseIconSupplier = () -> Icons.ALL.minus_mdi().size18();
    } else {
      this.collapseIconSupplier = collapseIconSupplier;
    }
    return this;
  }

  public Supplier<BaseIcon<?>> getLeafIconSupplier() {
    return leafIconSupplier;
  }

  /**
   * Sets a supplier for a custom leaf row icon instead of the default one
   *
   * @param leafIconSupplier {@link Supplier} of {@link BaseIcon}
   * @return Same config instance
   */
  public TreePluginConfig<T> setLeafIconSupplier(Supplier<BaseIcon<?>> leafIconSupplier) {
    if (isNull(leafIconSupplier)) {
      this.leafIconSupplier = () -> Icons.ALL.circle_medium_mdi().size18();
    } else {
      this.leafIconSupplier = leafIconSupplier;
    }
    return this;
  }

  public Function<TableRow<T>, Node> getIndentColumnElementSupplier() {
    return indentColumnElementSupplier;
  }

  /**
   * Sets a supplier of elements to be appended to the tree grid indent column as part of the
   * utility columns cells
   *
   * @param indentColumnElementSupplier {@link Function} that takes a {@link TableRow} and return a
   *     {@link Node}
   * @return same config instance
   */
  public TreePluginConfig<T> setIndentColumnElementSupplier(
      Function<TableRow<T>, Node> indentColumnElementSupplier) {
    this.indentColumnElementSupplier = indentColumnElementSupplier;
    return this;
  }

  public int getIndent() {
    return indent;
  }

  /**
   * Sets indent value to be added for each tree gird level
   *
   * @param indent int
   * @return Same config instance
   */
  public TreePluginConfig<T> setIndent(int indent) {
    if (indent < 0) {
      this.indent = DEFAULT_INDENT;
    } else {
      this.indent = indent;
    }
    return this;
  }
}
