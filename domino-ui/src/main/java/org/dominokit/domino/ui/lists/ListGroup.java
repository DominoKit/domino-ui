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

import elemental2.dom.HTMLUListElement;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionListeners;

/**
 * A collection of elements that can be selected and customized grouped in a single list container.
 *
 * <p>This component provides a container that accepts a collection of elements for viewing with
 * customized content for each one.
 *
 * <p>For example:
 *
 * <pre>
 *     ListGroup.create()
 *              .setItemRenderer((listGroup, item) -&gt; {
 *                  item.appendChild(Label.createPrimary(item.getValue())
 *              })
 *              .setItems(Arrays.asList("first item", "second item"));
 * </pre>
 *
 * @param <T> the type of the value object inside the element
 * @see BaseDominoElement
 */
public class ListGroup<T> extends BaseDominoElement<HTMLUListElement, ListGroup<T>>
    implements HasSelectionListeners<ListGroup<T>, T, List<T>>, ListStyles {

  private final UListElement element;
  private final List<ListItem<T>> items = new ArrayList<>();
  private ItemRenderer<T> itemRenderer = (listGroup, item) -> {};

  private final List<RemoveListener<T>> removeListeners = new ArrayList<>();
  private final List<AddListener<T>> addListeners = new ArrayList<>();

  private boolean selectionListenersPaused = false;

  private boolean multiSelect = false;
  private ListItem<? extends T> lastSelected = null;

  private boolean selectable = true;
  private Set<SelectionListener<? super T, ? super List<T>>> selectionListeners = new HashSet<>();
  private Set<SelectionListener<? super T, ? super List<T>>> deselectionListeners = new HashSet<>();

  /**
   * Creates a new {@code ListGroup} instance.
   *
   * <p>The list group is initially created with bordered style.
   *
   * @return a new {@code ListGroup} instance.
   */
  public static <T> ListGroup<T> create() {
    return new ListGroup<>();
  }

  /** Constructs a {@code ListGroup} with bordered style. */
  public ListGroup() {
    element = ul().addCss(dui_list_group, dui_list_group_bordered);
    init(this);

    this.addClickListener(
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
        });
  }

  /**
   * Sets the item renderer for this list group.
   *
   * @param itemRenderer The item renderer function.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> setItemRenderer(ItemRenderer<T> itemRenderer) {
    this.itemRenderer = itemRenderer;
    return this;
  }

  /**
   * Sets the items in this list group.
   *
   * @param items The list of items to set.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> setItems(List<? extends T> items) {
    removeAll();
    items.forEach(this::addItem);
    addListeners.forEach(listener -> listener.onAdd(new ArrayList<>(this.items)));
    return this;
  }

  /**
   * Removes all items from this list group.
   *
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeAll() {
    clearElement();
    List<ListItem<? extends T>> removed = new ArrayList<>(this.items);
    items.clear();
    removeListeners.forEach(listener -> listener.onRemove(removed));
    return this;
  }

  /**
   * Adds items to this list group.
   *
   * @param items The list of items to add.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> addItems(List<? extends T> items) {
    List<ListItem<? extends T>> addedItems = new ArrayList<>();
    items.forEach(value -> insertAt(this.items.size(), value, true, addedItems::add));
    if (!addedItems.isEmpty()) {
      this.addListeners.forEach(listener -> listener.onAdd(addedItems));
    }
    return this;
  }

  /**
   * Adds a single item to this list group.
   *
   * @param value The item value to add.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> addItem(T value) {
    return insertAt(items.isEmpty() ? 0 : items.size(), value);
  }

  /**
   * Inserts an item at the beginning of this list group.
   *
   * @param value The item value to insert.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> insertFirst(T value) {
    return insertAt(0, value);
  }

  /**
   * Inserts an item at the specified index in this list group.
   *
   * @param index The index at which to insert the item.
   * @param value The item value to insert.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> insertAt(int index, T value) {
    return insertAt(index, value, false, listItem -> {});
  }

  private ListGroup<T> insertAt(
      int index, T value, boolean silent, Consumer<ListItem<T>> onItemAdded) {
    if (index == 0 || (index >= 0 && index <= items.size())) {
      ListItem<T> li = ListItem.create(value);
      li.bindTo(this);
      if (index == items.size()) {
        items.add(li);
      } else {
        items.add(index, li);
      }
      this.insertAfter(li.element(), items.get(index));

      itemRenderer.onRender(this, li);
      onItemAdded.accept(li);
      if (!silent) {
        List<ListItem<? extends T>> added = new ArrayList<>();
        added.add(li);
        this.addListeners.forEach(listener -> listener.onAdd(added));
      }
    } else {
      throw new IndexOutOfBoundsException("index : [" + index + "], size : [" + items.size() + "]");
    }

    return this;
  }

  /**
   * Removes items from this list group based on their values.
   *
   * @param toBeRemoved The list of items to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeItemsByValue(List<? extends T> toBeRemoved) {
    return removeItems(
        items.stream()
            .filter(listItem -> toBeRemoved.contains(listItem.getValue()))
            .collect(Collectors.toList()));
  }

  /**
   * Removes a single item from this list group based on its value.
   *
   * @param value The item value to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeItem(T value) {
    Optional<ListItem<T>> first =
        items.stream().filter(listItem -> Objects.equals(listItem.getValue(), value)).findFirst();

    first.ifPresent(this::removeItem);
    return this;
  }

  /**
   * Removes a single item from this list group.
   *
   * @param item The item to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeItem(ListItem<? extends T> item) {
    return removeItem(item, false);
  }

  /**
   * Removes multiple items from this list group.
   *
   * @param items The list of items to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeItems(List<ListItem<? extends T>> items) {
    items.forEach(listItem -> removeItem(listItem, true));
    removeListeners.forEach(listener -> listener.onRemove(new ArrayList<>(items)));
    return this;
  }

  /**
   * Removes a single item from this list group.
   *
   * @param item The item to remove.
   * @param silent Whether to trigger removal listeners.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeItem(ListItem<? extends T> item, boolean silent) {
    items.remove(item);
    item.remove();

    if (!silent) {
      List<ListItem<? extends T>> items = new ArrayList<>();
      items.add(item);
      removeListeners.forEach(listener -> listener.onRemove(items));
    }

    return this;
  }

  /**
   * Sets whether this list group should have a bordered style.
   *
   * @param bordered Whether to set the bordered style.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> setBordered(boolean bordered) {
    addCss(BooleanCssClass.of(dui_list_group_bordered, bordered));
    return this;
  }

  /**
   * Gets a list of all items in this list group.
   *
   * @return A list of items.
   */
  public List<ListItem<T>> getItems() {
    return items;
  }

  /**
   * Gets a list of selected items in this list group.
   *
   * @return A list of selected items.
   */
  public List<ListItem<T>> getSelectedItems() {
    return items.stream().filter(ListItem::isSelected).collect(Collectors.toList());
  }

  /**
   * Pauses the selection listeners, preventing selection and deselection events from being
   * triggered.
   *
   * @return This {@code ListGroup} instance.
   */
  @Override
  public ListGroup<T> pauseSelectionListeners() {
    this.selectionListenersPaused = true;
    return this;
  }

  /**
   * Resumes the selection listeners, allowing selection and deselection events to be triggered.
   *
   * @return This {@code ListGroup} instance.
   */
  @Override
  public ListGroup<T> resumeSelectionListeners() {
    this.selectionListenersPaused = false;
    return this;
  }

  /**
   * Toggles the pause state of selection listeners based on the given toggle value.
   *
   * @param toggle {@code true} to pause selection listeners, {@code false} to resume them.
   * @return This {@code ListGroup} instance.
   */
  @Override
  public ListGroup<T> togglePauseSelectionListeners(boolean toggle) {
    this.selectionListenersPaused = toggle;
    return this;
  }

  /**
   * Retrieves the set of selection listeners registered with this list group.
   *
   * @return A set of selection listeners.
   */
  @Override
  public Set<SelectionListener<? super T, ? super List<T>>> getSelectionListeners() {
    return this.selectionListeners;
  }

  /**
   * Retrieves the set of deselection listeners registered with this list group.
   *
   * @return A set of deselection listeners.
   */
  @Override
  public Set<SelectionListener<? super T, ? super List<T>>> getDeselectionListeners() {
    return this.deselectionListeners;
  }

  /**
   * Checks if the selection listeners are currently paused.
   *
   * @return {@code true} if selection listeners are paused, {@code false} otherwise.
   */
  @Override
  public boolean isSelectionListenersPaused() {
    return selectionListenersPaused;
  }

  /**
   * Triggers selection listeners with the given source and selection list.
   *
   * @param source The source of the selection event.
   * @param selection The list of selected items.
   * @return This {@code ListGroup} instance.
   */
  @Override
  public ListGroup<T> triggerSelectionListeners(T source, List<T> selection) {
    selectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Triggers deselection listeners with the given source and deselected item list.
   *
   * @param source The source of the deselection event.
   * @param selection The list of deselected items.
   * @return This {@code ListGroup} instance.
   */
  @Override
  public ListGroup<T> triggerDeselectionListeners(T source, List<T> selection) {
    deselectionListeners.forEach(
        listener -> listener.onSelectionChanged(Optional.ofNullable(source), selection));
    return this;
  }

  /**
   * Retrieves the currently selected items in the list group.
   *
   * @return A list of selected items.
   */
  @Override
  public List<T> getSelection() {
    return items.stream()
        .filter(ListItem::isSelected)
        .map(ListItem::getValue)
        .collect(Collectors.toList());
  }

  /**
   * Gets a list of values from the items in this list group.
   *
   * @return A list of values.
   */
  public List<T> getValues() {
    return items.stream().map(ListItem::getValue).collect(Collectors.toList());
  }

  /**
   * Selects a list of items in this list group.
   *
   * @param items The list of items to select.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> select(List<ListItem<T>> items) {
    List<ListItem<? extends T>> selected = new ArrayList<>();
    items.forEach(listItem -> select(listItem, isSelectionListenersPaused(), selected::add));
    if (!selected.isEmpty() && !isSelectionListenersPaused()) {
      triggerSelectionListeners(null, getSelection());
    }
    return this;
  }

  /**
   * Selects a single item in this list group.
   *
   * @param listItem The item to select.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> select(ListItem<T> listItem) {
    return select(listItem, false);
  }

  /**
   * Selects a single item in this list group.
   *
   * @param listItem The item to select.
   * @param silent Whether to suppress selection events.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> select(ListItem<T> listItem, boolean silent) {
    return select(listItem, silent, item -> {});
  }

  void selectRange(ListItem<T> item) {
    if (isNull(lastSelected) || Objects.equals(lastSelected, item)) {
      select(item);
    } else {
      int itemIndex = getItems().indexOf(item);
      int lastSelectedIndex = getItems().indexOf(lastSelected);

      int startIndex = Math.min(itemIndex, lastSelectedIndex);
      int lastIndex = Math.max(itemIndex, lastSelectedIndex);

      deselect(getSelectedItems());
      List<ListItem<T>> toSelect =
          getItems().subList(startIndex, lastIndex + 1).stream()
              .filter(ListItem::isEnabled)
              .collect(Collectors.toList());
      select(toSelect);
    }
  }

  void deselectRange(ListItem<T> item) {
    if (isNull(lastSelected) || Objects.equals(lastSelected, item)) {
      select(item);
    } else {
      int itemIndex = getItems().indexOf(item);
      int lastSelectedIndex = getItems().indexOf(lastSelected);

      int startIndex = Math.min(itemIndex, lastSelectedIndex);
      int lastIndex = Math.max(itemIndex, lastSelectedIndex);

      deselect(getSelectedItems());
      select(getItems().subList(startIndex, lastIndex));
    }
  }

  private ListGroup<T> select(
      ListItem<T> listItem, boolean silent, Consumer<ListItem<? extends T>> onSelected) {
    if (!listItem.isSelected() && this.items.contains(listItem)) {
      if (!multiSelect) {
        if (nonNull(lastSelected)) {
          lastSelected.deselect();
        }
      }
      this.lastSelected = listItem;
      onSelected.accept(listItem);
      listItem.setSelected(true);
      if (!silent) {
        triggerSelectionListeners(listItem.getValue(), getSelection());
      }
    }
    return this;
  }

  /**
   * Deselects a list of items in this list group.
   *
   * @param items The list of items to deselect.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> deselect(List<ListItem<T>> items) {
    List<ListItem<? extends T>> deselected = new ArrayList<>();
    items.forEach(listItem -> deselect(listItem, false, deselected::add));
    if (!deselected.isEmpty()) {
      triggerDeselectionListeners(null, getSelection());
    }
    return this;
  }

  /**
   * Deselects a single item in this list group.
   *
   * @param listItem The item to deselect.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> deselect(ListItem<T> listItem) {
    return deselect(listItem, false);
  }

  /**
   * Deselects a single item in this list group.
   *
   * @param listItem The item to deselect.
   * @param silent Whether to suppress deselection events.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> deselect(ListItem<T> listItem, boolean silent) {
    return deselect(listItem, silent, item -> {});
  }

  private ListGroup<T> deselect(
      ListItem<T> listItem, boolean silent, Consumer<ListItem<? extends T>> onDeselected) {
    if (listItem.isSelected() && this.items.contains(listItem)) {
      onDeselected.accept(listItem);
      listItem.setSelected(false);
      if (!silent) {
        triggerDeselectionListeners(listItem.getValue(), getSelection());
      }
    }
    return this;
  }

  /**
   * Checks if multiple items can be selected simultaneously in this list group.
   *
   * @return {@code true} if multi-select is enabled, {@code false} otherwise.
   */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Sets whether multiple items can be selected simultaneously in this list group.
   *
   * @param multiSelect Whether to enable multi-select.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    return this;
  }

  /**
   * Adds an add listener to this list group.
   *
   * @param addListener The add listener to add.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> addAddListener(AddListener<T> addListener) {
    this.addListeners.add(addListener);
    return this;
  }

  /**
   * Removes an add listener from this list group.
   *
   * @param addListener The add listener to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeAddListener(AddListener<T> addListener) {
    this.addListeners.remove(addListener);
    return this;
  }

  /**
   * Adds a remove listener to this list group.
   *
   * @param removeListener The remove listener to add.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> addRemoveListener(RemoveListener<T> removeListener) {
    this.removeListeners.add(removeListener);
    return this;
  }

  /**
   * Removes a remove listener from this list group.
   *
   * @param removeListener The remove listener to remove.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> removeRemoveListener(RemoveListener<T> removeListener) {
    this.removeListeners.remove(removeListener);
    return this;
  }

  /**
   * Sets whether items in this list group are selectable.
   *
   * @param selectable Whether to set items as selectable.
   * @return this {@code ListGroup} instance.
   */
  public ListGroup<T> setSelectable(boolean selectable) {
    this.selectable = selectable;
    getItems().forEach(item -> item.setSelectable(selectable));
    return this;
  }

  /**
   * Checks if items in this list group are selectable.
   *
   * @return {@code true} if items are selectable, {@code false} otherwise.
   */
  public boolean isSelectable() {
    return selectable;
  }

  /**
   * Retrieves the underlying {@code HTMLUListElement} associated with this {@code ListGroup}.
   *
   * @return The {@code HTMLUListElement} representing the list group.
   */
  @Override
  public HTMLUListElement element() {
    return element.element();
  }

  /**
   * A functional interface for rendering items within the {@code ListGroup}.
   *
   * @param <T> The type of the value object inside the element.
   */
  @FunctionalInterface
  public interface ItemRenderer<T> {

    /**
     * Called to render an item within the {@code ListGroup}.
     *
     * @param listGroup The {@code ListGroup} containing the item.
     * @param listItem The {@code ListItem} to be rendered.
     */
    void onRender(ListGroup<T> listGroup, ListItem<T> listItem);
  }

  /**
   * A functional interface for handling item removal events from the {@code ListGroup}.
   *
   * @param <T> The type of the value object inside the element.
   */
  @FunctionalInterface
  public interface RemoveListener<T> {

    /**
     * Called when items are removed from the {@code ListGroup}.
     *
     * @param removedItems A list of {@code ListItem} objects that have been removed.
     */
    void onRemove(List<ListItem<? extends T>> removedItems);
  }

  /**
   * A functional interface for handling item addition events to the {@code ListGroup}.
   *
   * @param <T> The type of the value object inside the element.
   */
  @FunctionalInterface
  public interface AddListener<T> {

    /**
     * Called when items are added to the {@code ListGroup}.
     *
     * @param addedItems A list of {@code ListItem} objects that have been added.
     */
    void onAdd(List<ListItem<? extends T>> addedItems);
  }
}
