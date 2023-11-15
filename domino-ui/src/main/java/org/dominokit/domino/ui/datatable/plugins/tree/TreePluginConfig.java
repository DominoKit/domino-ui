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
import static org.dominokit.domino.ui.utils.Domino.*;
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
 * Configuration class for the TreeGridPlugin, which adds tree-like functionality to a DataTable.
 *
 * @param <T> The data type of the DataTable.
 */
public class TreePluginConfig<T> implements PluginConfig {

  /** The default indentation value for tree grid rows. */
  public static final int DEFAULT_INDENT = 20;

  private boolean lazy = false;
  private TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier;
  private Supplier<ToggleIcon<?, ?>> expandToggleIconSupplier =
      () -> ToggleMdiIcon.create(Icons.menu_right(), Icons.menu_down());
  private Supplier<Icon<?>> leafIconSupplier = Icons::circle_medium;
  private Function<TableRow<T>, Node> indentColumnElementSupplier = tableRow -> elements.text();
  private int indent = DEFAULT_INDENT;

  /** Constructs a new TreePluginConfig with default settings. */
  public TreePluginConfig() {}

  /**
   * Checks if lazy loading of child rows is enabled.
   *
   * @return {@code true} if lazy loading is enabled; otherwise, {@code false}.
   */
  public boolean isLazy() {
    return lazy;
  }

  /**
   * Sets whether lazy loading of child rows should be enabled.
   *
   * @param lazy {@code true} to enable lazy loading; {@code false} to disable it.
   * @return The TreePluginConfig instance.
   */
  public TreePluginConfig<T> setLazy(boolean lazy) {
    this.lazy = lazy;
    return this;
  }

  /**
   * Retrieves the supplier for parent row cells.
   *
   * @return The supplier for parent row cells.
   */
  public TreeGridPlugin.ParentRowCellsSupplier<T> getParentRowCellsSupplier() {
    return parentRowCellsSupplier;
  }

  /**
   * Sets the supplier for parent row cells.
   *
   * @param parentRowCellsSupplier The supplier for parent row cells.
   * @return The TreePluginConfig instance.
   */
  public TreePluginConfig<T> setParentRowCellsSupplier(
      TreeGridPlugin.ParentRowCellsSupplier<T> parentRowCellsSupplier) {
    this.parentRowCellsSupplier = parentRowCellsSupplier;
    return this;
  }

  /**
   * Retrieves the supplier for the expand/collapse toggle icon.
   *
   * @return The supplier for the expand/collapse toggle icon.
   */
  public Supplier<ToggleIcon<?, ?>> getExpandToggleIconSupplier() {
    return expandToggleIconSupplier;
  }

  /**
   * Sets the supplier for the expand/collapse toggle icon.
   *
   * @param expandIconSupplier The supplier for the expand/collapse toggle icon.
   * @return The TreePluginConfig instance.
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
   * Retrieves the supplier for the leaf icon.
   *
   * @return The supplier for the leaf icon.
   */
  public Supplier<Icon<?>> getLeafIconSupplier() {
    return leafIconSupplier;
  }

  /**
   * Sets the supplier for the leaf icon.
   *
   * @param leafIconSupplier The supplier for the leaf icon.
   * @return The TreePluginConfig instance.
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
   * Retrieves the supplier for the indent column element.
   *
   * @return The supplier for the indent column element.
   */
  public Function<TableRow<T>, Node> getIndentColumnElementSupplier() {
    return indentColumnElementSupplier;
  }

  /**
   * Sets the supplier for the indent column element.
   *
   * @param indentColumnElementSupplier The supplier for the indent column element.
   * @return The TreePluginConfig instance.
   */
  public TreePluginConfig<T> setIndentColumnElementSupplier(
      Function<TableRow<T>, Node> indentColumnElementSupplier) {
    this.indentColumnElementSupplier = indentColumnElementSupplier;
    return this;
  }

  /**
   * Retrieves the indentation value for tree grid rows.
   *
   * @return The indentation value.
   */
  public int getIndent() {
    return indent;
  }

  /**
   * Sets the indentation value for tree grid rows.
   *
   * @param indent The indentation value.
   * @return The TreePluginConfig instance.
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
