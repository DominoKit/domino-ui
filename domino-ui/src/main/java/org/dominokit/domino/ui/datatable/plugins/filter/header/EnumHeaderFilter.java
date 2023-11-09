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
import java.util.Arrays;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;

/**
 * The EnumHeaderFilter class provides a header filter for filtering values from an Enum.
 *
 * @param <T> The type of data in the DataTable.
 * @param <E> The type of Enum to filter.
 */
public class EnumHeaderFilter<T, E extends Enum>
    implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private final Select<String> select;

  /**
   * Creates a new instance of EnumHeaderFilter with default labels.
   *
   * @param values The Enum values to display in the filter.
   * @param <T> The type of data in the DataTable.
   * @param <E> The type of Enum to filter.
   * @return A new instance of EnumHeaderFilter.
   */
  public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values) {
    return new EnumHeaderFilter<>(values, "ALL");
  }

  /**
   * Creates a new instance of EnumHeaderFilter with custom labels.
   *
   * @param values The Enum values to display in the filter.
   * @param allLabel The label to use for the "All" option in the filter.
   * @param <T> The type of data in the DataTable.
   * @param <E> The type of Enum to filter.
   * @return A new instance of EnumHeaderFilter with custom labels.
   */
  public static <T, E extends Enum> EnumHeaderFilter<T, E> create(E[] values, String allLabel) {
    return new EnumHeaderFilter<>(values, allLabel);
  }

  /**
   * Creates a new instance of EnumHeaderFilter with custom labels.
   *
   * @param values The Enum values to display in the filter.
   * @param allLabel The label to use for the "All" option in the filter.
   */
  public EnumHeaderFilter(E[] values, String allLabel) {
    select =
        Select.<String>create()
            .appendChild(SelectOption.create("", allLabel))
            .apply(
                element ->
                    Arrays.stream(values)
                        .forEach(
                            value ->
                                element.appendChild(
                                    SelectOption.create(value.toString(), value.toString()))))
            .selectAt(0);
    select.styler(style -> style.setMarginBottom("0px"));
  }

  /**
   * Initializes the header filter and adds search functionality.
   *
   * @param searchContext The search context for filtering.
   * @param columnConfig The column configuration to filter.
   */
  @Override
  public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
    searchContext.addBeforeSearchHandler(
        context -> {
          if (select.getSelectedIndex() > 0) {
            searchContext.add(
                Filter.create(
                    columnConfig.getFilterKey(),
                    select.getValue(),
                    Category.HEADER_FILTER,
                    FilterTypes.ENUM));
          } else {
            searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
          }
        });
    select.addChangeListener((oldOption, option) -> searchContext.fireSearchEvent());
  }

  /** Clears the header filter. */
  @Override
  public void clear() {
    select.withPausedChangeListeners(
        field -> {
          select.selectAt(0);
        });
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the HTML element representing the header filter.
   * @return The HTML element of the header filter.
   */
  @Override
  public HTMLElement element() {
    return select.element();
  }

  /**
   * Gets the Select component used in the header filter.
   *
   * @return The Select component.
   */
  public Select<String> getSelect() {
    return select;
  }
}
