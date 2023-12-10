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

import static org.dominokit.domino.ui.utils.Domino.*;

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
 * The BooleanHeaderFilter class provides a header filter for boolean (true/false) columns in a
 * DataTable. It allows users to filter data based on boolean values.
 *
 * @param <T> The type of data in the DataTable.
 */
public class BooleanHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private final Select<String> select;

  /**
   * Creates a new instance of the BooleanHeaderFilter with default labels for true, false, and both
   * options.
   *
   * @param <T> The type of data in the DataTable.
   * @return A new BooleanHeaderFilter instance.
   */
  public static <T> BooleanHeaderFilter<T> create() {
    return new BooleanHeaderFilter<>();
  }

  /**
   * Creates a new instance of the BooleanHeaderFilter with custom labels for true, false, and both
   * options.
   *
   * @param <T> The type of data in the DataTable.
   * @param trueLabel The label for the "true" option.
   * @param falseLabel The label for the "false" option.
   * @param bothLabel The label for the "both" option.
   * @return A new BooleanHeaderFilter instance with custom labels.
   */
  public static <T> BooleanHeaderFilter<T> create(
      String trueLabel, String falseLabel, String bothLabel) {
    return new BooleanHeaderFilter<>(trueLabel, falseLabel, bothLabel);
  }

  /** Initializes a new BooleanHeaderFilter with default labels ("Yes", "No", "ALL"). */
  public BooleanHeaderFilter() {
    this("Yes", "No", "ALL");
  }

  /**
   * Initializes a new BooleanHeaderFilter with custom labels for true, false, and both options.
   *
   * @param trueLabel The label for the "true" option.
   * @param falseLabel The label for the "false" option.
   * @param bothLabel The label for the "both" option.
   */
  public BooleanHeaderFilter(String trueLabel, String falseLabel, String bothLabel) {
    select =
        Select.<String>create()
            .appendChild(SelectOption.create("", bothLabel))
            .appendChild(SelectOption.create(Boolean.TRUE.toString(), trueLabel))
            .appendChild(SelectOption.create(Boolean.FALSE.toString(), falseLabel))
            .setSearchable(false)
            .selectAt(0);

    select.styler(style -> style.setMarginBottom("0px"));
  }

  /**
   * Initializes the BooleanHeaderFilter and sets up filtering behavior.
   *
   * @param searchContext The search context for the DataTable.
   * @param columnConfig The configuration for the column being filtered.
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
                    FilterTypes.BOOLEAN));
          } else {
            searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
          }
        });
    select.addChangeListener((oldOption, option) -> searchContext.fireSearchEvent());
  }

  /** Clears the BooleanHeaderFilter by resetting the Select value to the default option. */
  @Override
  public void clear() {
    select.withPausedChangeListeners(
        field -> {
          select.selectAt(0);
        });
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the HTML element representing the BooleanHeaderFilter.
   * @return The HTML element.
   */
  @Override
  public HTMLElement element() {
    return select.element();
  }

  /**
   * Gets the Select instance used for filtering boolean values.
   *
   * @return The Select instance.
   */
  public Select<String> getSelect() {
    return select;
  }
}
