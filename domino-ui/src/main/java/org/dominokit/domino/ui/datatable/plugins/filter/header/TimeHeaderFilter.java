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
import org.dominokit.domino.ui.forms.TimeBox;

/**
 * The {@code TimeHeaderFilter} class provides a header filter for filtering time values in a
 * DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class TimeHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private TimeBox timeBox;

  /**
   * Creates a new instance of {@code TimeHeaderFilter} with the default placeholder text "Search".
   *
   * @return A new {@code TimeHeaderFilter} instance.
   */
  public static <T> TimeHeaderFilter<T> create() {
    return new TimeHeaderFilter<>();
  }

  /**
   * Creates a new instance of {@code TimeHeaderFilter} with the default placeholder text "Search".
   * The created instance allows users to filter time values in a DataTable.
   */
  public TimeHeaderFilter() {
    this.timeBox =
        TimeBox.create()
            .setPlaceholder("Search")
            .apply(
                element -> {
                  element.withTimePicker(
                      (parent, timePicker) -> {
                        timePicker.addTimeSelectionListener(
                            (oldDate, newDate) -> {
                              element.close();
                            });
                      });
                });
  }

  /**
   * Gets the TimeBox element used in the header filter.
   *
   * @return The TimeBox element configured for filtering time values.
   */
  public TimeBox getTimeBox() {
    return timeBox;
  }

  /**
   * Initializes the header filter by adding a BeforeSearchHandler and a change listener. When the
   * search is performed, it adds a filter based on the selected time value or removes the filter if
   * the TimeBox is empty.
   *
   * @param searchContext The search context of the DataTable.
   * @param columnConfig The column configuration of the DataTable.
   */
  @Override
  public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
    searchContext.addBeforeSearchHandler(
        context -> {
          if (timeBox.isEmptyIgnoreSpaces()) {
            searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
          } else {
            searchContext.add(
                Filter.create(
                    columnConfig.getFilterKey(),
                    timeBox.getValue().getTime() + "",
                    Category.HEADER_FILTER,
                    FilterTypes.TIME));
          }
        });
    timeBox.addChangeListener((oldValue, value) -> searchContext.fireSearchEvent());
  }

  /** Clears the header filter by invoking the clear method on the TimeBox element. */
  @Override
  public void clear() {
    timeBox.withPausedChangeListeners(
        field -> {
          timeBox.clear();
        });
  }

  /**
   * @dominokit-site-ignore {@inheritDoc} Gets the HTMLElement representing the header filter
   *     element, which is the TimeBox element.
   * @return The TimeBox element used for filtering time values in the header.
   */
  @Override
  public HTMLElement element() {
    return timeBox.element();
  }
}
