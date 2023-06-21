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
 * A Single option select column header filter component that is rendered as a {@link
 * org.dominokit.domino.ui.forms.suggest.Select} component * @param <T&gt; type of data table
 * records
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class SelectHeaderFilter<T> implements ColumnHeaderFilterPlugin.HeaderFilter<T> {

  private final Select<String> select;

  /**
   * create a new instance with a default label for ALL option
   *
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter}
   *     object
   */
  public static <T> SelectHeaderFilter<T> create() {
    return new SelectHeaderFilter<>("ALL");
  }

  /**
   * create a new instance with a custom label for ALL option
   *
   * @param allLabel a {@link java.lang.String} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.filter.header.SelectHeaderFilter}
   *     object
   */
  public static <T> SelectHeaderFilter<T> create(String allLabel) {
    return new SelectHeaderFilter<>(allLabel);
  }

  /** @param allLabel String, ALL option label */
  /**
   * Constructor for SelectHeaderFilter.
   *
   * @param allLabel a {@link java.lang.String} object
   */
  public SelectHeaderFilter(String allLabel) {
    select =
        Select.<String>create()
            .addCss(dui_m_b_0)
            .appendChild(SelectOption.create("", "", allLabel))
            .selectAt(0);
  }

  /**
   * adds a new option to the select
   *
   * @see Select#appendChild(SelectOption)
   * @param selectOption the {@link org.dominokit.domino.ui.forms.suggest.SelectOption}
   * @return same instance
   */
  public SelectHeaderFilter<T> appendChild(SelectOption<String> selectOption) {
    select.appendChild(selectOption);
    return this;
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  public void clear() {
    select.withPausedChangeListeners(
        field -> {
          select.selectAt(0);
        });
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return select.element();
  }

  /** @return the {@link Select} wrapped in this component */
  /**
   * Getter for the field <code>select</code>.
   *
   * @return a {@link org.dominokit.domino.ui.forms.suggest.Select} object
   */
  public Select<String> getSelect() {
    return select;
  }
}
