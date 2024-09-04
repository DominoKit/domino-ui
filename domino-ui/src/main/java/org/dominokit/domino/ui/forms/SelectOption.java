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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;
import org.jboss.elemento.IsElement;

/**
 * A component for a single select option in the select component DropDownMenu
 *
 * @param <T> The type of the SelectOption value
 */
public class SelectOption<T> extends BaseDominoElement<HTMLDivElement, SelectOption<T>>
    implements HasValue<SelectOption, T>,
        HasBackground<SelectOption>,
        Selectable<SelectOption>,
        TakesValue<T> {

  private static final String SELECTED = "select-option-selected";
  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css("select-option");
  private final DominoElement<HTMLElement> valueContainer =
      DominoElement.of(span()).css("select-option-value", Styles.ellipsis_text);
  private String displayValue;
  private String key;
  private T value;
  private final List<Selectable.SelectionHandler<SelectOption>> selectionHandlers =
      new ArrayList<>();
  private boolean excludeFromSearchResults = false;
  private final FlexLayout optionLayoutElement;

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption
   * @param displayValue String
   */
  public SelectOption(T value, String key, String displayValue) {
    setKey(key);
    setValue(value);
    setDisplayValue(displayValue);
    optionLayoutElement = FlexLayout.create();
    element.appendChild(
        optionLayoutElement.appendChild(
            FlexItem.create()
                .css(Styles.ellipsis_text)
                .setFlexGrow(1)
                .appendChild(valueContainer)));
    init(this);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption and also the display value
   */
  public SelectOption(T value, String key) {
    this(value, key, key);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption
   * @param displayValue String
   * @param <T> type of the SelectOption value
   * @return new SelectOption instance
   */
  public static <T> SelectOption<T> create(T value, String key, String displayValue) {
    return new SelectOption<>(value, key, displayValue);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption and also the display string
   * @param <T> type of the SelectOption value
   * @return new SelectOption instance
   */
  public static <T> SelectOption<T> create(T value, String key) {
    return new SelectOption<>(value, key);
  }

  /**
   * @param node {@link Node} to be appended to this SelectOption
   * @return same SelectOption instance
   */
  public SelectOption<T> appendChild(Node node) {
    element.appendChild(node);
    return this;
  }

  /**
   * @param node {@link IsElement} to be appended to this SelectOption
   * @return same SelectOption instance
   */
  public SelectOption<T> appendChild(IsElement<?> node) {
    element.appendChild(node.element());
    return this;
  }

  /** @return String key identifier of this SelectOption */
  public String getKey() {
    return key;
  }

  /** @param key String key identifier for this SelectOption */
  public void setKey(String key) {
    this.key = key;
  }

  /** {@inheritDoc} */
  @Override
  public T getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(T value) {
    this.value = value;
  }

  /** {@inheritDoc} */
  @Override
  public void addSelectionHandler(Selectable.SelectionHandler<SelectOption> selectionHandler) {
    selectionHandlers.add(selectionHandler);
  }

  /** @return String */
  public String getDisplayValue() {
    return displayValue;
  }

  /**
   * @param displayValue String
   * @return same SelectionOption instance
   */
  public SelectOption<T> setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
    valueContainer.setTextContent(displayValue);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> select() {
    return select(false);
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> deselect() {
    return deselect(false);
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> select(boolean silent) {
    addCss(SELECTED);
    if (!silent) {
      selectionHandlers.forEach(handler -> handler.onSelectionChanged(this));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> deselect(boolean silent) {
    removeCss(SELECTED);
    if (!silent) {
      selectionHandlers.forEach(handler -> handler.onSelectionChanged(this));
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isSelected() {
    return style().containsCss(SELECTED);
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> setBackground(Color background) {
    if (nonNull(background)) {
      addCss(background.getBackground());
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * @return the {@link HTMLElement} that contains the display value text wrapped as {@link
   *     DominoElement}
   */
  public DominoElement<HTMLElement> getValueContainer() {
    return valueContainer;
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> value(T value) {
    return value(value, false);
  }

  @Override
  public SelectOption value(T value, boolean silent) {
    setValue(value);
    return this;
  }

  /** @return boolean, true if this option is excluded from showing in the search results */
  public boolean isExcludeFromSearchResults() {
    return excludeFromSearchResults;
  }

  /**
   * Enable/Disable exclusion from search result
   *
   * @param excludeFromSearchResults boolean, if true then even if this SelectOption matches the
   *     search criteria it wont be included in the search results
   * @return same {@link SelectOption}
   */
  public SelectOption<T> setExcludeFromSearchResults(boolean excludeFromSearchResults) {
    this.excludeFromSearchResults = excludeFromSearchResults;
    return this;
  }

  /** @return the {@link FlexLayout} that contains the different elements in the SelectOption */
  public FlexLayout getOptionLayoutElement() {
    return optionLayoutElement;
  }
}
