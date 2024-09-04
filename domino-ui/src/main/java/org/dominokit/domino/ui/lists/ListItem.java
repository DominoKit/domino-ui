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
package org.dominokit.domino.ui.lists;

import static java.util.Objects.nonNull;

import elemental2.dom.Event;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import jsinterop.base.Js;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component which represents an item inside a {@link ListGroup}
 *
 * @param <T> the type of the value object inside the item
 * @see ListGroup
 * @see BaseDominoElement
 */
public class ListItem<T> extends BaseDominoElement<HTMLLIElement, ListItem<T>> {

  private final ListGroup<T> listGroup;
  private T value;
  private boolean selected = false;
  private HTMLLIElement element;
  private final List<SelectionChangedListener<T>> selectionChangedListeners = new ArrayList<>();
  private boolean selectable = true;
  private boolean enabled = true;
  private boolean selectOnClick = true;

  public ListItem(ListGroup<T> listGroup, T value, HTMLLIElement element) {
    this.value = value;
    this.element = element;
    this.listGroup = listGroup;
    init(this);
    element.setAttribute("tabindex", "0");

    this.addClickListener(this::trySelect);

    KeyboardEvents.listenOnKeyDown(element).onEnter(this::trySelect);
  }

  private void trySelect(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();
    MouseEvent mouseEvent = Js.uncheckedCast(evt);
    if (selectable && enabled && selectOnClick) {
      if (isSelected()) {
        if (mouseEvent.shiftKey && listGroup.isMultiSelect()) {
          deselectRange();
        } else {
          deselect();
        }
      } else {
        if (mouseEvent.shiftKey && listGroup.isMultiSelect()) {
          selectRange();
        } else {
          select();
        }
      }
    }
  }

  private void selectRange() {
    listGroup.selectRange(this);
  }

  private void deselectRange() {
    listGroup.deselectRange(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element;
  }

  /** @return The value */
  public T getValue() {
    return value;
  }

  /** @param value The new value of this item */
  public void setValue(T value) {
    this.value = value;
  }

  /** @return The root element */
  public HTMLLIElement getElement() {
    return element;
  }

  /** @param element The new root element */
  public void setElement(HTMLLIElement element) {
    this.element = element;
  }

  /**
   * Checks if values are equal
   *
   * @param value the value to check
   * @return true if values are equal, false otherwise
   */
  public boolean valueEquals(T value) {
    return Objects.equals(this.value, value);
  }

  /**
   * Selects the item
   *
   * @return same instance
   */
  public ListItem<T> select() {
    return select(false);
  }

  /**
   * Deselects the item
   *
   * @return same instance
   */
  public ListItem<T> deselect() {
    return deselect(false);
  }

  /**
   * Selects the item with a boolean to indicate if this should inform handlers or not
   *
   * @param silent true for not informing the handlers associated, false otherwise
   * @return same instance
   */
  public ListItem<T> select(boolean silent) {
    this.listGroup.select(this, silent);
    return this;
  }

  /**
   * Deselects the item with a boolean to indicate if this should inform handlers or not
   *
   * @param silent true for not informing the handlers associated, false otherwise
   * @return same instance
   */
  public ListItem<T> deselect(boolean silent) {
    this.listGroup.deselect(this, silent);
    return this;
  }

  /** @return True if the item is selected, false otherwise */
  public boolean isSelected() {
    return selected;
  }

  /**
   * Sets a selection handler for which will be called when the selection is changed
   *
   * @param listener the {@link SelectionChangedListener} to set
   * @return same instance
   */
  public ListItem<T> onSelectionChange(SelectionChangedListener<T> listener) {
    this.selectionChangedListeners.add(listener);
    return this;
  }

  /**
   * Sets if this item can be selected
   *
   * @param selectable true to enable selecting the item, false otherwise
   * @return same instance
   */
  public ListItem<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    if (selectable) {
      css(ListStyles.SELECTABLE);
    } else {
      removeCss(ListStyles.SELECTABLE);
    }
    return this;
  }

  /** @return True if this item will be selected when clicking on it */
  public boolean isSelectOnClick() {
    return selectOnClick;
  }

  /**
   * Sets if this item should be selected when clicking on it
   *
   * @param selectOnClick true to select on click, false otherwise
   * @return same instance
   */
  public ListItem<T> setSelectOnClick(boolean selectOnClick) {
    this.selectOnClick = selectOnClick;
    return this;
  }

  /** @return True if the item is enabled, false otherwise */
  public boolean isEnabled() {
    return enabled;
  }

  /**
   * Sets if this item is enabled
   *
   * @param enabled true to enable the item, false otherwise
   * @return same instance
   */
  public ListItem<T> setEnabled(boolean enabled) {
    if (!enabled) {
      deselect();
      addCss("disabled");
      this.enabled = false;
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    if (other == null || getClass() != other.getClass()) return false;
    ListItem<?> listItem = (ListItem<?>) other;
    return value.equals(listItem.value);
  }

  /** {@inheritDoc} */
  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  void setSelected(boolean selected, boolean silent) {
    this.selected = selected;
    if (nonNull(listGroup.getSelectionColor())) {
      removeCss(listGroup.getSelectionColor().getBackground());
    }
    removeCss(ListStyles.SELECTED);
    if (selected) {
      css(ListStyles.SELECTED);
      if (nonNull(listGroup.getSelectionColor())) {
        css(listGroup.getSelectionColor().getBackground());
      }
    }
    if (!silent) {
      fireSelectionHandlers(selected);
    }
  }

  void fireSelectionHandlers(boolean selected) {
    this.selectionChangedListeners.forEach(
        listener -> listener.onSelectionChanged(ListItem.this, selected));
  }

  /**
   * A handler that will be called when the item is selected or deselected
   *
   * @param <T> the type of the value object inside the item
   */
  @FunctionalInterface
  public interface SelectionChangedListener<T> {
    /**
     * @param item The item
     * @param selected true if selected, false otherwise
     */
    void onSelectionChanged(ListItem<? extends T> item, boolean selected);
  }
}
