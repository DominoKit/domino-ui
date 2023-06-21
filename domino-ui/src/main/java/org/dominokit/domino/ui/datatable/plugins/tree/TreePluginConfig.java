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

import static java.util.Objects.isNull;
import static org.dominokit.domino.ui.style.SpacingCss.dui_font_size_4;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.Node;
import java.util.function.Function;
import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.PluginConfig;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.ToggleIcon;
import org.dominokit.domino.ui.icons.ToggleMdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * TreePluginConfig class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class TreePluginConfig<T> implements PluginConfig {

  /** Constant <code>DEFAULT_INDENT=20</code> */
  public static final int DEFAULT_INDENT = 20;

  private boolean lazy = false;
  private TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier;
  private Supplier<ToggleIcon<?, ?>> expandToggleIconSupplier =
      () -> ToggleMdiIcon.create(Icons.menu_right(), Icons.menu_down());
  private Supplier<Icon<?>> leafIconSupplier = Icons::circle_medium;
  private Function<TableRow<T>, Node> indentColumnElementSupplier = tableRow -> elements.text();
  private int indent = DEFAULT_INDENT;

  /** Constructor for TreePluginConfig. */
  public TreePluginConfig() {}

  /**
   * isLazy.
   *
   * @return a boolean
   */
  public boolean isLazy() {
    return lazy;
  }

  /**
   * Setter for the field <code>lazy</code>.
   *
   * @param lazy a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.tree.TreePluginConfig} object
   */
  public TreePluginConfig<T> setLazy(boolean lazy) {
    this.lazy = lazy;
    return this;
  }

  /**
   * Getter for the field <code>parentRowCellsSupplier</code>.
   *
   * @return a {@link
   *     org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin.ParentRowCellsSupplier}
   *     object
   */
  public TreeGridPlugin.ParentRowCellsSupplier<T> getParentRowCellsSupplier() {
    return parentRowCellsSupplier;
  }

  /**
   * Set a supplier that provides cells to be rendered in a parent row cells, this can be used to
   * provide a custom UI for parent rows
   *
   * @param parentRowCellsSupplier {@link
   *     org.dominokit.domino.ui.datatable.plugins.tree.TreeGridPlugin.ParentRowCellsSupplier}
   * @return Same config instance
   */
  public TreePluginConfig<T> setParentRowCellsSupplier(
      TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier) {
    this.parentRowCellsSupplier = parentRowCellsSupplier;
    return this;
  }

  /**
   * Getter for the field <code>expandToggleIconSupplier</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<ToggleIcon<?, ?>> getExpandToggleIconSupplier() {
    return expandToggleIconSupplier;
  }

  /**
   * Sets a supplier for a custom expand icon instead of the default one
   *
   * @param expandIconSupplier {@link java.util.function.Supplier} of {@link
   *     org.dominokit.domino.ui.icons.Icon}
   * @return Same config instance
   */
  public TreePluginConfig<T> setExpandToggleIconSupplier(
      Supplier<ToggleIcon<?, ?>> expandIconSupplier) {
    if (isNull(expandIconSupplier)) {
      this.expandToggleIconSupplier =
          () -> ToggleMdiIcon.create(Icons.menu_right(), Icons.menu_down());
    } else {
      this.expandToggleIconSupplier = expandIconSupplier;
    }
    return this;
  }

  /**
   * Getter for the field <code>leafIconSupplier</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<Icon<?>> getLeafIconSupplier() {
    return leafIconSupplier;
  }

  /**
   * Sets a supplier for a custom leaf row icon instead of the default one
   *
   * @param leafIconSupplier {@link java.util.function.Supplier} of {@link
   *     org.dominokit.domino.ui.icons.Icon}
   * @return Same config instance
   */
  public TreePluginConfig<T> setLeafIconSupplier(Supplier<Icon<?>> leafIconSupplier) {
    if (isNull(leafIconSupplier)) {
      this.leafIconSupplier = () -> Icons.circle_medium().addCss(dui_font_size_4);
    } else {
      this.leafIconSupplier = leafIconSupplier;
    }
    return this;
  }

  /**
   * Getter for the field <code>indentColumnElementSupplier</code>.
   *
   * @return a {@link java.util.function.Function} object
   */
  public Function<TableRow<T>, Node> getIndentColumnElementSupplier() {
    return indentColumnElementSupplier;
  }

  /**
   * Sets a supplier of elements to be appended to the tree grid indent column as part of the
   * utility columns cells
   *
   * @param indentColumnElementSupplier {@link java.util.function.Function} that takes a {@link
   *     org.dominokit.domino.ui.datatable.TableRow} and return a {@link elemental2.dom.Node}
   * @return same config instance
   */
  public TreePluginConfig<T> setIndentColumnElementSupplier(
      Function<TableRow<T>, Node> indentColumnElementSupplier) {
    this.indentColumnElementSupplier = indentColumnElementSupplier;
    return this;
  }

  /**
   * Getter for the field <code>indent</code>.
   *
   * @return a int
   */
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
