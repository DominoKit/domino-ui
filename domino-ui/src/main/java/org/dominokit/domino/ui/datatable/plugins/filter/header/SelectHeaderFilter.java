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

import static org.dominokit.domino.ui.style.SpacingCss.dui_m_b_0;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.suggest.Select;
import org.dominokit.domino.ui.forms.suggest.SelectOption;

/**
 * The SelectHeaderFilter class provides a header filter for selecting options from a list.
 *
 * @param <T> The type of data in the DataTable.
 */
public class SelectHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private final Select<String> select;

  /** Creates a new instance of SelectHeaderFilter with default "ALL" label. */
  public static <T> SelectHeaderFilter<T> create() {
    return new SelectHeaderFilter<>("ALL");
  }

  /**
   * Creates a new instance of SelectHeaderFilter with a custom label for "ALL".
   *
   * @param allLabel The custom label for "ALL".
   */
  public static <T> SelectHeaderFilter<T> create(String allLabel) {
    return new SelectHeaderFilter<>(allLabel);
  }

  /**
   * Creates a new instance of SelectHeaderFilter.
   *
   * @param allLabel The label for the "ALL" option.
   */
  public SelectHeaderFilter(String allLabel) {
    select =
        Select.<String>create()
            .addCss(dui_m_b_0)
            .appendChild(SelectOption.create("", "", allLabel))
            .selectAt(0);
  }

  /**
   * Appends a SelectOption to the header filter.
   *
   * @param selectOption The SelectOption to append.
   * @return The SelectHeaderFilter instance.
   */
  public SelectHeaderFilter<T> appendChild(SelectOption<String> selectOption) {
    select.appendChild(selectOption);
    return this;
  }

  /**
   * Initializes the header filter and adds event listeners.
   *
   * @param searchContext The SearchContext for filtering.
   * @param columnConfig The ColumnConfig associated with the header filter.
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
                    FilterTypes.STRING));
          } else {
            searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
          }
        });
    select.addChangeListener((oldOption, option) -> searchContext.fireSearchEvent());
  }

  /** Clears the header filter by selecting the "ALL" option. */
  @Override
  public void clear() {
    select.withPausedChangeListeners(
        field -> {
          select.selectAt(0);
        });
  }

  /**
   * @dominokit-site-ignore {@inheritDoc} Gets the HTML element representing the header filter.
   * @return The HTML element.
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
