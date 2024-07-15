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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.SpacingCss.dui_m_b_0;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.SearchConfig;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.model.Category;
import org.dominokit.domino.ui.datatable.model.Filter;
import org.dominokit.domino.ui.datatable.model.FilterTypes;
import org.dominokit.domino.ui.datatable.model.SearchContext;
import org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin;
import org.dominokit.domino.ui.forms.InputFormField;
import org.dominokit.domino.ui.utils.DelayedTextInput;
import org.dominokit.domino.ui.utils.HasPlaceHolder;

/**
 * The DelayedHeaderFilterInput class provides a header filter input field with delayed search
 * functionality. It allows users to input filter criteria and performs a delayed search based on
 * the user's input.
 *
 * @param <B> The type of the input field.
 * @param <T> The type of data in the DataTable.
 * @param <V> The type of filter value.
 */
public abstract class DelayedHeaderFilterInput<
        B extends InputFormField<B, HTMLInputElement, V>, T, V>
    implements ColumnHeaderFilterPlugin.HeaderFilter<T>, HasComponentConfig<SearchConfig> {
  private B input;
  private DelayedTextInput delayedTextInput;
  private SearchConfig config;

  /** Creates a new instance of DelayedHeaderFilterInput with a default placeholder. */
  public DelayedHeaderFilterInput() {
    this("Search");
  }

  /**
   * Creates a new instance of DelayedHeaderFilterInput with a specified placeholder.
   *
   * @param placeHolder The placeholder text for the input field.
   */
  public DelayedHeaderFilterInput(String placeHolder) {
    input = createValueBox();

    input.addCss(dui_m_b_0);
    if (input instanceof HasPlaceHolder<?>) {
      ((HasPlaceHolder<B>) input).setPlaceholder(placeHolder);
    }

    delayedTextInput =
        DelayedTextInput.create(
            getInputElement(), getConfig().getTableTextHeaderFilterSearchDelay());
  }

  public void setOwnConfig(SearchConfig config) {
    this.config = config;
  }

  @Override
  public SearchConfig getOwnConfig() {
    return config;
  }

  /**
   * Initializes the header filter input and sets up the delayed search functionality.
   *
   * @param searchContext The search context for filtering data.
   * @param columnConfig The column configuration for filtering.
   */
  @Override
  public void init(SearchContext<T> searchContext, ColumnConfig<T> columnConfig) {
    searchContext.addBeforeSearchHandler(
        tSearchContext -> {
          if (nonNull(columnConfig)) {
            if (isEmpty()) {
              searchContext.remove(columnConfig.getFilterKey(), Category.HEADER_FILTER);
            } else {
              searchContext.add(
                  Filter.create(
                      columnConfig.getFilterKey(), getValue(), Category.HEADER_FILTER, getType()));
            }
          }
        });
    delayedTextInput.setDelayedAction(
        () -> {
          if (nonNull(columnConfig)) {
            searchContext.fireSearchEvent();
          }
        });
  }

  /**
   * Gets the HTML input element used for filtering.
   *
   * @return The HTML input element.
   */
  protected abstract HTMLInputElement getInputElement();

  /**
   * Creates the input field for filtering.
   *
   * @return The created input field instance.
   */
  protected abstract B createValueBox();

  /**
   * Checks if the input field is empty.
   *
   * @return {@code true} if the input field is empty, {@code false} otherwise.
   */
  protected abstract boolean isEmpty();

  /**
   * Gets the value from the input field as a string.
   *
   * @return The value from the input field as a string.
   */
  protected abstract String getValue();

  /**
   * Gets the filter type for the input field.
   *
   * @return The filter type for the input field.
   */
  protected abstract FilterTypes getType();

  /**
   * Gets the input field instance.
   *
   * @return The input field instance.
   */
  public B getField() {
    return input;
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the HTMLElement representing the input field.
   * @return The HTMLElement representing the input field.
   */
  @Override
  public HTMLElement element() {
    return input.element();
  }
}
