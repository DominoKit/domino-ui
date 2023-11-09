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

package org.dominokit.domino.ui.datatable.plugins.filter.header;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.DateBox;

/**
 * The DateHeaderFilter class provides a header filter for date columns in a DataTable. It allows
 * users to filter data based on date values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class DateHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private DateBox dateBox;

  /**
   * Creates a new instance of the DateHeaderFilter.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new DateHeaderFilter instance.
   */
  public static <T> DateHeaderFilter<T> create() {
    return new DateHeaderFilter<>();
  }

  /** Initializes a new DateHeaderFilter. */
  public DateHeaderFilter() {
    this.dateBox =
        DateBox.create()
            .setPlaceholder("Search")
            .apply(
                element -> {
                  element.withCalendar(
                      (parent, calendar) -> {
                        calendar.addDateSelectionListener(
                            (oldDay, newDay) -> {
                              element.close();
                            });
                      });
                });
  }

  /**
   * Gets the DateBox instance used for filtering dates.
   *
   * @return The DateBox instance.
   */
  public DateBox getDateBox() {
    return dateBox;
  }

  /**
   * Initializes the DateHeaderFilter and sets up filtering behavior.
   *
   * @param searchContext The search context for the DataTable.
   * @param columnConfig The configuration for the column being filtered.
   */
  @Override
  public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
    searchContext.addBeforeSearchHandler(
        context -> {
          if (dateBox.isEmptyIgnoreSpaces()) {
            searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
          } else {
            searchContext.add(
                Filter.create(
                    columnConfig.getFilterKey(),
                    dateBox.getValue().getTime() + "",
                    Category.HEADER_FILTER,
                    FilterTypes.DATE));
          }
        });
    dateBox.addChangeListener((oldValue, value) -> searchContext.fireSearchEvent());
  }

  /** Clears the DateHeaderFilter by resetting the DateBox value. */
  @Override
  public void clear() {
    dateBox.withPausedChangeListeners(
        field -> {
          dateBox.clear();
        });
  }

  /**
   * @dominokit-site-ignore {@inheritDoc} Gets the HTML element representing the DateHeaderFilter.
   * @return The HTML element.
   */
  @Override
  public HTMLElement element() {
    return dateBox.element();
  }
}
