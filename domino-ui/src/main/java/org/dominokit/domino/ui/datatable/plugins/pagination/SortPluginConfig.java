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

package org.dominokit.domino.ui.datatable.plugins.pagination;

import static java.util.Objects.nonNull;

import java.util.function.Supplier;
import org.dominokit.domino.ui.datatable.plugins.PluginConfig;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;

/**
 * Configuration class for the SortPlugin that allows customization of sorting behavior and icons.
 */
public class SortPluginConfig implements PluginConfig {
  private boolean triStateSort = false;
  private Supplier<Icon<?>> ascendingIcon = Icons::sort_ascending;
  private Supplier<Icon<?>> descendingIcon = Icons::sort_descending;
  private Supplier<Icon<?>> unsortedIcon = Icons::sort;
  private boolean showIconOnSortedColumnOnly = false;
  private boolean showSortOptionsInColumnMenu = false;
  private String sortAscendingLabel = "Sort ascending";
  private String sortDescendingLabel = "Sort descending";
  private String noSortLabel = "Unsorted";

  /**
   * Checks if tri-state sorting is enabled.
   *
   * @return {@code true} if tri-state sorting is enabled, {@code false} otherwise.
   */
  public boolean isTriStateSort() {
    return triStateSort;
  }

  /**
   * Sets whether tri-state sorting is enabled.
   *
   * @param triStateSort {@code true} to enable tri-state sorting, {@code false} to disable.
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setTriStateSort(boolean triStateSort) {
    this.triStateSort = triStateSort;
    return this;
  }

  /**
   * Gets the supplier for the ascending sorting icon.
   *
   * @return The supplier for the ascending sorting icon.
   */
  public Supplier<Icon<?>> getAscendingIcon() {
    return ascendingIcon;
  }

  /**
   * Sets the supplier for the ascending sorting icon.
   *
   * @param ascendingIcon The supplier for the ascending sorting icon.
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setAscendingIcon(Supplier<Icon<?>> ascendingIcon) {
    if (nonNull(ascendingIcon)) {
      this.ascendingIcon = ascendingIcon;
    }
    return this;
  }

  /**
   * Gets the supplier for the descending sorting icon.
   *
   * @return The supplier for the descending sorting icon.
   */
  public Supplier<Icon<?>> getDescendingIcon() {
    return descendingIcon;
  }

  /**
   * Sets the supplier for the descending sorting icon.
   *
   * @param descendingIcon The supplier for the descending sorting icon.
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setDescendingIcon(Supplier<Icon<?>> descendingIcon) {
    if (nonNull(descendingIcon)) {
      this.descendingIcon = descendingIcon;
    }
    return this;
  }

  /**
   * Gets the supplier for the unsorted icon.
   *
   * @return The supplier for the unsorted icon.
   */
  public Supplier<Icon<?>> getUnsortedIcon() {
    return unsortedIcon;
  }

  /**
   * Sets the supplier for the unsorted icon.
   *
   * @param unsortedIcon The supplier for the unsorted icon.
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setUnsortedIcon(Supplier<Icon<?>> unsortedIcon) {
    if (nonNull(unsortedIcon)) {
      this.unsortedIcon = unsortedIcon;
    }
    return this;
  }

  /**
   * Checks if icons are displayed only on the sorted column.
   *
   * @return {@code true} if icons are displayed only on the sorted column, {@code false} otherwise.
   */
  public boolean isShowIconOnSortedColumnOnly() {
    return showIconOnSortedColumnOnly;
  }

  /**
   * Sets whether icons should be displayed only on the sorted column.
   *
   * @param showIconOnSortedColumnOnly {@code true} to display icons only on the sorted column,
   *     {@code false} otherwise.
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setShowIconOnSortedColumnOnly(boolean showIconOnSortedColumnOnly) {
    this.showIconOnSortedColumnOnly = showIconOnSortedColumnOnly;
    return this;
  }

  /**
   * Checks whether sort options are shown in the column menu.
   *
   * @return {@code true} if sort options are displayed in the column menu, {@code false} otherwise
   */
  public boolean isShowSortOptionsInColumnMenu() {
    return showSortOptionsInColumnMenu;
  }

  /**
   * Sets whether sort options should be shown in the column menu.
   *
   * @param showSortOptionsInColumnMenu {@code true} to display sort options in the column menu,
   *     {@code false} to hide them
   * @return This SortPluginConfig instance for method chaining.
   */
  public SortPluginConfig setShowSortOptionsInColumnMenu(boolean showSortOptionsInColumnMenu) {
    this.showSortOptionsInColumnMenu = showSortOptionsInColumnMenu;
    return this;
  }

  /**
   * Returns the label text used for the "Sort Ascending" option.
   *
   * @return the "Sort Ascending" label, or {@code null} if not set
   */
  public String getSortAscendingLabel() {
    return sortAscendingLabel;
  }

  /**
   * Sets the label text for the "Sort Ascending" option.
   *
   * @param sortAscendingLabel the label to use for the "Sort Ascending" option
   */
  public void setSortAscendingLabel(String sortAscendingLabel) {
    this.sortAscendingLabel = sortAscendingLabel;
  }

  /**
   * Returns the label text used for the "Sort Descending" option.
   *
   * @return the "Sort Descending" label, or {@code null} if not set
   */
  public String getSortDescendingLabel() {
    return sortDescendingLabel;
  }

  /**
   * Sets the label text for the "Sort Descending" option.
   *
   * @param sortDescendingLabel the label to use for the "Sort Descending" option
   */
  public void setSortDescendingLabel(String sortDescendingLabel) {
    this.sortDescendingLabel = sortDescendingLabel;
  }

  /**
   * Returns the label text used for the "No Sort" option.
   *
   * @return the "No Sort" label, or {@code null} if not set
   */
  public String getNoSortLabel() {
    return noSortLabel;
  }

  /**
   * Sets the label text for the "No Sort" option.
   *
   * @param noSortLabel the label to use for the "No Sort" option
   */
  public void setNoSortLabel(String noSortLabel) {
    this.noSortLabel = noSortLabel;
  }
}
