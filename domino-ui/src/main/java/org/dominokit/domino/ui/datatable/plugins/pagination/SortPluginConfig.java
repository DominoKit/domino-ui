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

/** SortPluginConfig class. */
public class SortPluginConfig implements PluginConfig {
  private boolean triStateSort = false;
  private Supplier<Icon<?>> ascendingIcon = Icons::sort_ascending;
  private Supplier<Icon<?>> descendingIcon = Icons::sort_descending;
  private Supplier<Icon<?>> unsortedIcon = Icons::sort;
  private boolean showIconOnSortedColumnOnly = false;

  /**
   * isTriStateSort.
   *
   * @return a boolean
   */
  public boolean isTriStateSort() {
    return triStateSort;
  }

  /**
   * Setter for the field <code>triStateSort</code>.
   *
   * @param triStateSort a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortPluginConfig} object
   */
  public SortPluginConfig setTriStateSort(boolean triStateSort) {
    this.triStateSort = triStateSort;
    return this;
  }

  /**
   * Getter for the field <code>ascendingIcon</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<Icon<?>> getAscendingIcon() {
    return ascendingIcon;
  }

  /**
   * Setter for the field <code>ascendingIcon</code>.
   *
   * @param ascendingIcon a {@link java.util.function.Supplier} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortPluginConfig} object
   */
  public SortPluginConfig setAscendingIcon(Supplier<Icon<?>> ascendingIcon) {
    if (nonNull(ascendingIcon)) {
      this.ascendingIcon = ascendingIcon;
    }
    return this;
  }

  /**
   * Getter for the field <code>descendingIcon</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<Icon<?>> getDescendingIcon() {
    return descendingIcon;
  }

  /**
   * Setter for the field <code>descendingIcon</code>.
   *
   * @param descendingIcon a {@link java.util.function.Supplier} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortPluginConfig} object
   */
  public SortPluginConfig setDescendingIcon(Supplier<Icon<?>> descendingIcon) {
    if (nonNull(descendingIcon)) {
      this.descendingIcon = descendingIcon;
    }
    return this;
  }

  /**
   * Getter for the field <code>unsortedIcon</code>.
   *
   * @return a {@link java.util.function.Supplier} object
   */
  public Supplier<Icon<?>> getUnsortedIcon() {
    return unsortedIcon;
  }

  /**
   * Setter for the field <code>unsortedIcon</code>.
   *
   * @param unsortedIcon a {@link java.util.function.Supplier} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortPluginConfig} object
   */
  public SortPluginConfig setUnsortedIcon(Supplier<Icon<?>> unsortedIcon) {
    if (nonNull(unsortedIcon)) {
      this.unsortedIcon = unsortedIcon;
    }
    return this;
  }

  /**
   * isShowIconOnSortedColumnOnly.
   *
   * @return a boolean
   */
  public boolean isShowIconOnSortedColumnOnly() {
    return showIconOnSortedColumnOnly;
  }

  /**
   * Setter for the field <code>showIconOnSortedColumnOnly</code>.
   *
   * @param showIconOnSortedColumnOnly a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.pagination.SortPluginConfig} object
   */
  public SortPluginConfig setShowIconOnSortedColumnOnly(boolean showIconOnSortedColumnOnly) {
    this.showIconOnSortedColumnOnly = showIconOnSortedColumnOnly;
    return this;
  }
}
