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
package org.dominokit.domino.ui.datatable.plugins.header;

import static org.dominokit.domino.ui.style.SpacingCss.dui_font_size_4;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * An implementation of the {@link HeaderActionElement} that allows clearing filters in a DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class ClearSearch<T> extends BaseDominoElement<HTMLElement, ClearSearch<T>> {

  private final MdiIcon clearFiltersIcon;
  private String clearFiltersToolTip = "Clear filters";

  public static <T> ClearSearch<T> create(DataTable<T> dataTable) {
    return new ClearSearch<>(dataTable);
  }

  /**
   * Creates an element that represents a button to clear filters in a DataTable.
   *
   * @param dataTable The DataTable from which to clear filters.
   */
  public ClearSearch(DataTable<T> dataTable) {
    clearFiltersIcon =
        Icons.filter_off()
            .setTooltip(clearFiltersToolTip)
            .addCss(dui_font_size_4)
            .clickable()
            .addClickListener(evt -> dataTable.getSearchContext().clear().fireSearchEvent());

    init(this);
  }

  @Override
  public HTMLElement element() {
    return clearFiltersIcon.element();
  }

  /**
   * Sets the tooltip text for the "Clear Filters" action button.
   *
   * @param clearFiltersToolTip The tooltip text for the "Clear Filters" action.
   * @return This {@code ClearSearch} instance for method chaining.
   */
  public ClearSearch<T> setClearFiltersToolTip(String clearFiltersToolTip) {
    this.clearFiltersToolTip = clearFiltersToolTip;
    return this;
  }
}
