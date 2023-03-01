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

import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;

public class SortPluginConfig implements PluginConfig {
  private boolean triStateSort = false;
  private Supplier<BaseIcon<?>> ascendingIcon = Icons.ALL::sort_ascending_mdi;
  private Supplier<BaseIcon<?>> descendingIcon = Icons.ALL::sort_descending_mdi;
  private Supplier<BaseIcon<?>> unsortedIcon = Icons.ALL::sort_mdi;
  private boolean showIconOnSortedColumnOnly = false;

  public boolean isTriStateSort() {
    return triStateSort;
  }

  public SortPluginConfig setTriStateSort(boolean triStateSort) {
    this.triStateSort = triStateSort;
    return this;
  }

  public Supplier<BaseIcon<?>> getAscendingIcon() {
    return ascendingIcon;
  }

  public SortPluginConfig setAscendingIcon(Supplier<BaseIcon<?>> ascendingIcon) {
    if (nonNull(ascendingIcon)) {
      this.ascendingIcon = ascendingIcon;
    }
    return this;
  }

  public Supplier<BaseIcon<?>> getDescendingIcon() {
    return descendingIcon;
  }

  public SortPluginConfig setDescendingIcon(Supplier<BaseIcon<?>> descendingIcon) {
    if (nonNull(descendingIcon)) {
      this.descendingIcon = descendingIcon;
    }
    return this;
  }

  public Supplier<BaseIcon<?>> getUnsortedIcon() {
    return unsortedIcon;
  }

  public SortPluginConfig setUnsortedIcon(Supplier<BaseIcon<?>> unsortedIcon) {
    if (nonNull(unsortedIcon)) {
      this.unsortedIcon = unsortedIcon;
    }
    return this;
  }

  public boolean isShowIconOnSortedColumnOnly() {
    return showIconOnSortedColumnOnly;
  }

  public SortPluginConfig setShowIconOnSortedColumnOnly(boolean showIconOnSortedColumnOnly) {
    this.showIconOnSortedColumnOnly = showIconOnSortedColumnOnly;
    return this;
  }
}
