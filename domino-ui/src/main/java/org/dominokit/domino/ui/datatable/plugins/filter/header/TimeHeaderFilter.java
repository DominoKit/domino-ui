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
 * Date column header filter component that is rendered as a {@link
 * org.dominokit.domino.ui.forms.TimeBox} component
 *
 * @param <T> type of data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public class TimeHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private TimeBox timeBox;

  /**
   * Static factory to create a new instance
   *
   * @param <T> the type of the data table records
   * @return new instance
   */
  public static <T> TimeHeaderFilter<T> create() {
    return new TimeHeaderFilter<>();
  }

  /** @see TimeHeaderFilter#create() */
  /** Constructor for TimeHeaderFilter. */
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

  /** @return the {@link TimeBox} wrapped in this filter component */
  /**
   * Getter for the field <code>timeBox</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.TimeBox} object
   */
  public TimeBox getTimeBox() {
    return timeBox;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void clear() {
    timeBox.withPausedChangeListeners(
        field -> {
          timeBox.clear();
        });
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return timeBox.element();
  }
}
