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
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * A component which represents an item inside a {@link ListGroup}
 *
 * @param <T> the type of the value object inside the item
 * @see ListGroup
 * @see BaseDominoElement
 */
public class ListItem<T> extends BaseDominoElement<HTMLLIElement, ListItem<T>>
    implements Selectable<ListItem<T>>,
        HasSelectionListeners<ListItem<T>, ListItem<T>, ListItem<T>>,
        Bindable<ListGroup<T>>,
        ListStyles {

  private ListGroup<T> listGroup;
  private T value;
  private LIElement element;
  private boolean selectable = true;
  private boolean selectOnClick = true;

  private boolean selectionListenersPaused = false;
  private Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>> selectionListeners =
      new HashSet<>();
  private Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>> deselectionListeners =
      new HashSet<>();

  public static <T> ListItem<T> create(T value) {
    return new ListItem<>(value);
  }

  public ListItem(T value) {
    this.value = value;
    this.element = li().addCss(dui_list_group_item).setAttribute("tabindex", "0");
    init(this);

    this.addClickListener(this::trySelect, true);
    element.onKeyDown(keyEvents -> keyEvents.onEnter(this::trySelect));
  }

  @Override
  public void bindTo(ListGroup<T> owner) {
    this.listGroup = owner;
  }

  private void trySelect(Event evt) {
    evt.stopPropagation();
    evt.preventDefault();
    MouseEvent mouseEvent = Js.uncheckedCast(evt);
    if (selectable && isEnabled() && selectOnClick) {
      if (isSelected()) {
        if (mouseEvent.shiftKey && isMultiSelect()) {
          deselectRange();
        } else {
          deselect();
        }
      } else {
        if (mouseEvent.shiftKey && isMultiSelect()) {
          selectRange();
        } else {
          select();
        }
      }
    }
  }

  private boolean isMultiSelect() {
    return nonNull(listGroup) && listGroup.isMultiSelect();
  }

  private void selectRange() {
    if (nonNull(listGroup)) {
      listGroup.selectRange(this);
    }
  }

  private void deselectRange() {
    if (nonNull(listGroup)) {
      listGroup.deselectRange(this);
    }
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /** @return The value */
  public T getValue() {
    return value;
  }

  /** @param value The new value of this item */
  public void setValue(T value) {
    this.value = value;
  }

  @Override
  public ListItem<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  @Override
  public ListItem<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  @Override
  public ListItem<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  @Override
  public Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  @Override
  public Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  @Override
  public boolean isSelectionListenersPaused() {
    return selectionListenersPaused;
  }

  @Override
  public ListItem<T> triggerSelectionListeners(ListItem<T> source, ListItem<T> selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  @Override
  public ListItem<T> triggerDeselectionListeners(ListItem<T> source, ListItem<T> selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  @Override
  public ListItem<T> getSelection() {
    return this;
  }

  @Override
  public ListItem<T> select() {
    return select(isSelectable());
  }

  @Override
  public ListItem<T> deselect() {
    return deselect(isSelectionListenersPaused());
  }

  @Override
  public ListItem<T> select(boolean silent) {
    if (selectable && isEnabled()) {
      if (nonNull(listGroup)) {
        listGroup.select(this, silent);
      }
      setSelected(true);
      if (!silent) {
        triggerSelectionListeners(this, this);
      }
    }
    return this;
  }

  @Override
  public ListItem<T> deselect(boolean silent) {
    if (selectable && isEnabled()) {
      if (nonNull(listGroup)) {
        listGroup.deselect(this, silent);
      }
      setSelected(false);
      if (!silent) {
        triggerDeselectionListeners(this, null);
      }
    }
    return this;
  }

  @Override
  public boolean isSelected() {
    return dui_selected.isAppliedTo(this);
  }

  @Override
  public boolean isSelectable() {
    return selectable;
  }

  @Override
  public ListItem<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  @Override
  public ListItem<T> setSelected(boolean selected) {
    addCss(BooleanCssClass.of(dui_selected, selected));
    return this;
  }

  @Override
  public ListItem<T> setSelected(boolean selected, boolean silent) {
    if (selected) {
      select(silent);
    } else {
      deselect(silent);
    }
    return this;
  }
}
