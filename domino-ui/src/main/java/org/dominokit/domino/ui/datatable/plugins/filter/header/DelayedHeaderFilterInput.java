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

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
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
 * An abstract implementation of the {@link
 * org.dominokit.domino.ui.datatable.plugins.column.ColumnHeaderFilterPlugin.HeaderFilter} for text
 * input based filters that add a delay for triggering the search while the user is typing
 *
 * @param <B> the type of the component that extends from {@link
 *     org.dominokit.domino.ui.forms.InputFormField} and is wrapped in the implementation
 * @param <T> the type of the data table records
 */
public abstract class DelayedHeaderFilterInput<
        B extends InputFormField<B, HTMLInputElement, V>, T, V>
    implements ColumnHeaderFilterPlugin.HeaderFilter<T> {
  private B input;
  private DelayedTextInput delayedTextInput;

  /**
   * A constructor that initialized with a default placeholder
   *
   * <pre>Search</pre>
   */
  public DelayedHeaderFilterInput() {
    this("Search");
  }

  /**
   * A constructor to specify a custom placeholder
   *
   * @param placeHolder String
   */
  public DelayedHeaderFilterInput(String placeHolder) {
    input = createValueBox();

    input.addCss(dui_m_b_0);
    if (input instanceof HasPlaceHolder<?>) {
      ((HasPlaceHolder<B>) input).setPlaceholder(placeHolder);
    }

    delayedTextInput = DelayedTextInput.create(getInputElement(), 200);
  }

  /** {@inheritDoc} */
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

  /** @return the {@link HTMLInputElement} wrapped inside the ValueBox component */
  /**
   * getInputElement.
   *
   * @return a {@link elemental2.dom.HTMLInputElement} object
   */
  protected abstract HTMLInputElement getInputElement();

  /** @return a new instance of the wrapped component type */
  /**
   * createValueBox.
   *
   * @return a B object
   */
  protected abstract B createValueBox();

  /** @return boolean, true if the wrapped component is empty */
  /**
   * isEmpty.
   *
   * @return a boolean
   */
  protected abstract boolean isEmpty();

  /** @return String value of the wrapped component */
  /**
   * getValue.
   *
   * @return a {@link java.lang.String} object
   */
  protected abstract String getValue();

  /** @return The type of the filter */
  /**
   * getType.
   *
   * @return a {@link org.dominokit.domino.ui.datatable.model.FilterTypes} object
   */
  protected abstract FilterTypes getType();

  /** @return the wrapped component instance */
  /**
   * getField.
   *
   * @return a B object
   */
  public B getField() {
    return input;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return input.element();
  }
}
