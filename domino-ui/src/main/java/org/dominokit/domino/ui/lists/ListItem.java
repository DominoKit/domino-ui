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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

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
 * Represents a list item within a {@link ListGroup}. This class provides methods for selecting,
 * deselecting, and configuring list items.
 *
 * <p>Usage example:
 *
 * <pre>
 * ListItem<String> listItem = ListItem.create("Item 1");
 * listItem.addSelectionListener((source, selection) -> {
 *     // Handle selection event
 *     if (selection.isSelected()) {
 *         // Item is selected
 *     } else {
 *         // Item is deselected
 *     }
 * });
 * </pre>
 *
 * @param <T> The type of value associated with the list item.
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

  /**
   * Creates a new `ListItem` instance with the specified value.
   *
   * @param value The value associated with this `ListItem`.
   * @param <T> The type of the value.
   * @return A new `ListItem` instance.
   */
  public static <T> ListItem<T> create(T value) {
    return new ListItem<>(value);
  }

  /**
   * Constructs a new `ListItem` with the given value.
   *
   * @param value The value associated with this `ListItem`.
   */
  public ListItem(T value) {
    this.value = value;
    this.element = li().addCss(dui_list_group_item).setAttribute("tabindex", "0");
    init(this);

    this.addClickListener(this::trySelect, true);
    element.onKeyDown(keyEvents -> keyEvents.onEnter(this::trySelect));
  }

  /**
   * Binds this `ListItem` to a parent `ListGroup`.
   *
   * @param owner The `ListGroup` to which this `ListItem` will be bound.
   */
  @Override
  public void bindTo(ListGroup<T> owner) {
    this.listGroup = owner;
  }

  /**
   * Handles the selection of this list item when a click or key event occurs.
   *
   * @param evt The event that triggered the selection attempt.
   */
  private void trySelect(Event evt) {
    MouseEvent mouseEvent = Js.uncheckedCast(evt);
    if (selectable
        && (isNull(listGroup) || listGroup.isSelectable())
        && isEnabled()
        && selectOnClick) {
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

  /**
   * Checks if the parent {@link ListGroup} allows multi-select.
   *
   * @return {@code true} if multi-select is allowed, {@code false} otherwise.
   */
  private boolean isMultiSelect() {
    return nonNull(listGroup) && listGroup.isMultiSelect();
  }

  /** Selects a range of list items in the parent {@link ListGroup} when multi-select is enabled. */
  private void selectRange() {
    if (nonNull(listGroup)) {
      listGroup.selectRange(this);
    }
  }

  /**
   * Deselects a range of list items in the parent {@link ListGroup} when multi-select is enabled.
   */
  private void deselectRange() {
    if (nonNull(listGroup)) {
      listGroup.deselectRange(this);
    }
  }

  /**
   * Returns the underlying HTML list item element.
   *
   * @return The HTML list item element.
   */
  @Override
  public HTMLLIElement element() {
    return element.element();
  }

  /**
   * Gets the value associated with this list item.
   *
   * @return The value associated with the list item.
   */
  public T getValue() {
    return value;
  }

  /**
   * Sets the value associated with this list item.
   *
   * @param value The value to set.
   */
  public void setValue(T value) {
    this.value = value;
  }

  /**
   * Pauses the execution of selection listeners for this list item.
   *
   * @return This list item instance with selection listeners paused.
   */
  @Override
  public ListItem<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes the execution of selection listeners for this list item.
   *
   * @return This list item instance with selection listeners resumed.
   */
  @Override
  public ListItem<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of selection listeners for this list item.
   *
   * @param toggle {@code true} to pause, {@code false} to resume.
   * @return This list item instance with selection listeners paused or resumed based on the toggle
   *     value.
   */
  @Override
  public ListItem<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Gets the selection listeners attached to this list item.
   *
   * @return A set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Gets the deselection listeners attached to this list item.
   *
   * @return A set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super ListItem<T>, ? super ListItem<T>>>
      getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * Checks if selection listeners are currently paused for this list item.
   *
   * @return {@code true} if selection listeners are paused, {@code false} otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return selectionListenersPaused;
  }

  /**
   * Triggers selection listeners for this list item with the provided source and selection.
   *
   * @param source The source of the selection event.
   * @param selection The selected list item.
   * @return This list item instance.
   */
  @Override
  public ListItem<T> triggerSelectionListeners(ListItem<T> source, ListItem<T> selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Triggers deselection listeners for this list item with the provided source and selection.
   *
   * @param source The source of the deselection event.
   * @param selection The deselected list item.
   * @return This list item instance.
   */
  @Override
  public ListItem<T> triggerDeselectionListeners(ListItem<T> source, ListItem<T> selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Gets the currently selected list item.
   *
   * @return This list item if it is selected, or {@code null} if it is not selected.
   */
  @Override
  public ListItem<T> getSelection() {
    return this;
  }

  /**
   * Selects this list item if it is selectable.
   *
   * @return This list item instance with the selection state updated.
   */
  @Override
  public ListItem<T> select() {
    return select(isSelectionListenersPaused());
  }

  /**
   * Deselects this list item if it is selectable.
   *
   * @return This list item instance with the deselection state updated.
   */
  @Override
  public ListItem<T> deselect() {
    return deselect(isSelectionListenersPaused());
  }

  /**
   * Selects or deselects this list item based on the provided flag.
   *
   * @param silent {@code true} to suppress selection/deselection events, {@code false} to trigger
   *     them.
   * @return This list item instance with the selection state updated.
   */
  @Override
  public ListItem<T> select(boolean silent) {
    if (isSelectable() && isEnabled()) {
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

  /**
   * Deselects this list item if it is selectable, optionally suppressing deselection events.
   *
   * @param silent {@code true} to suppress deselection events, {@code false} to trigger them.
   * @return This list item instance with the deselection state updated.
   */
  @Override
  public ListItem<T> deselect(boolean silent) {
    if (isSelectable() && isEnabled()) {
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

  /**
   * Checks if this list item is currently selected.
   *
   * @return {@code true} if this list item is selected, {@code false} otherwise.
   */
  @Override
  public boolean isSelected() {
    return dui_selected.isAppliedTo(this);
  }

  /**
   * Checks if this list item is selectable.
   *
   * @return {@code true} if this list item is selectable, {@code false} otherwise.
   */
  @Override
  public boolean isSelectable() {
    return selectable;
  }

  /**
   * Sets whether this list item is selectable.
   *
   * @param selectable {@code true} to make this list item selectable, {@code false} to make it
   *     non-selectable.
   * @return This list item instance with the selectability state updated.
   */
  @Override
  public ListItem<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    return this;
  }

  /**
   * Sets the selected state of this list item.
   *
   * @param selected The new selected state.
   * @return This list item instance with the selected state updated.
   */
  @Override
  public ListItem<T> setSelected(boolean selected) {
    addCss(BooleanCssClass.of(dui_selected, selected));
    return this;
  }

  /**
   * Sets the selected state of this list item, optionally suppressing selection/deselection events.
   *
   * @param selected The new selected state.
   * @param silent {@code true} to suppress selection/deselection events, {@code false} to trigger
   *     them.
   * @return This list item instance with the selected state updated.
   */
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
