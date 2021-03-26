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
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import elemental2.dom.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.Elements;

/**
 * A collection of elements that can be selected and customized grouped in a single list container.
 *
 * <p>This component provides a container which accepts a collection of elements to view which
 * customized content for each one.
 *
 * <p>Customize the component can be done by overwriting classes provided by {@link ListStyles}
 *
 * <p>For example:
 *
 * <pre>
 *     ListGroup.create()
 *              .setItemRenderer((listGroup, item) -> {
 *                  item.appendChild(Label.createPrimary(item.getValue())
 *              })
 *              .setItems(Arrays.asList("first item", "second item"));
 * </pre>
 *
 * @param <T> the type of the value object inside the element
 * @see BaseDominoElement
 */
public class ListGroup<T> extends BaseDominoElement<HTMLUListElement, ListGroup<T>> {

  private final HTMLUListElement element;
  private final List<ListItem<T>> items = new ArrayList<>();
  private ItemRenderer<T> itemRenderer = (listGroup, item) -> {};

  private final List<RemoveListener<T>> removeListeners = new ArrayList<>();
  private final List<AddListener<T>> addListeners = new ArrayList<>();
  private final List<SelectionListener<T>> selectionListeners = new ArrayList<>();
  private final List<DeSelectionListener<T>> deSelectionListeners = new ArrayList<>();
  private boolean multiSelect = false;
  private ListItem<? extends T> lastSelected = null;
  private Color selectionColor = null;

  /**
   * Creates an empty list group
   *
   * @param <T> the type of the value object
   * @return new instance
   */
  public static <T> ListGroup<T> create() {
    return new ListGroup<>();
  }

  public ListGroup() {
    element = Elements.ul().css(ListStyles.LIST_GROUP, ListStyles.BORDERED).element();
    init(this);

    this.addClickListener(
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);
          evt.stopPropagation();
          evt.preventDefault();
        });
  }

  /**
   * Sets the renderer for which adds the content of a single element inside the group
   *
   * @param itemRenderer the {@link ItemRenderer}
   * @return same instance
   */
  public ListGroup<T> setItemRenderer(ItemRenderer<T> itemRenderer) {
    this.itemRenderer = itemRenderer;
    return this;
  }

  /**
   * Sets the collection of values to show in the list group
   *
   * @param items the collection of values
   * @return same instance
   */
  public ListGroup<T> setItems(List<? extends T> items) {
    removeAll();
    items.forEach(this::addItem);
    addListeners.forEach(listener -> listener.onAdd(new ArrayList<>(this.items)));
    return this;
  }

  /**
   * Clears the list group
   *
   * @return same instance
   */
  public ListGroup<T> removeAll() {
    clearElement();
    List<ListItem<? extends T>> removed = new ArrayList<>(this.items);
    items.clear();
    removeListeners.forEach(listener -> listener.onRemove(removed));
    return this;
  }

  /**
   * Adds a new collection of values to the existed ones
   *
   * @param items the new collection of values to add
   * @return same instance
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
   * Adds a single value to the collection of values in the list group
   *
   * @param value the new value
   * @return same instance
   */
  public ListGroup<T> addItem(T value) {
    return insertAt(items.isEmpty() ? 0 : items.size(), value);
  }

  /**
   * Adds a single value at the beginning of the list
   *
   * @param value the new value
   * @return same instance
   */
  public ListGroup<T> insertFirst(T value) {
    return insertAt(0, value);
  }

  /**
   * Adds a single value at a specific index in the list
   *
   * @param index the index
   * @param value the new value
   * @return same instance
   */
  public ListGroup<T> insertAt(int index, T value) {
    return insertAt(index, value, false, listItem -> {});
  }

  private ListGroup<T> insertAt(
      int index, T value, boolean silent, Consumer<ListItem<T>> onItemAdded) {
    if (index == 0 || (index >= 0 && index <= items.size())) {
      HTMLLIElement li = li().css(ListStyles.LIST_GROUP_ITEM).element();
      ListItem<T> listItem = new ListItem<>(this, value, li);

      if (index == items.size()) {
        items.add(listItem);
      } else {
        items.add(index, listItem);
      }
      if (!items.isEmpty()) {
        this.insertAfter(listItem.element(), items.get(index).getElement());
      } else {
        this.appendChild(listItem);
      }
      itemRenderer.onRender(this, listItem);
      onItemAdded.accept(listItem);
      if (!silent) {
        List<ListItem<? extends T>> added = new ArrayList<>();
        added.add(listItem);
        this.addListeners.forEach(listener -> listener.onAdd(added));
      }
    } else {
      throw new IndexOutOfBoundsException("index : [" + index + "], size : [" + items.size() + "]");
    }

    return this;
  }

  /**
   * Removes all values existed in the provided {@code toBeRemoved} list
   *
   * @param toBeRemoved the values that will be removed from the list
   * @return same instance
   */
  public ListGroup<T> removeItemsByValue(List<? extends T> toBeRemoved) {
    return removeItems(
        items.stream()
            .filter(listItem -> toBeRemoved.contains(listItem.getValue()))
            .collect(Collectors.toList()));
  }

  /**
   * Removes a single value from the list
   *
   * @param value the value to remove
   * @return same instance
   */
  public ListGroup<T> removeItem(T value) {
    Optional<ListItem<T>> first =
        items.stream().filter(listItem -> listItem.valueEquals(value)).findFirst();

    first.ifPresent(this::removeItem);
    return this;
  }

  /**
   * Removes a single {@link ListItem} from the list group
   *
   * @param item the {@link ListItem} to remove
   * @return same instance
   */
  public ListGroup<T> removeItem(ListItem<? extends T> item) {
    return removeItem(item, false);
  }

  /**
   * Removes a collection of {@link ListItem} from the list group
   *
   * @param items the collection of the {@link ListItem} to remove
   * @return same instance
   */
  public ListGroup<T> removeItems(List<ListItem<? extends T>> items) {
    items.forEach(listItem -> removeItem(listItem, true));
    removeListeners.forEach(listener -> listener.onRemove(new ArrayList<>(items)));
    return this;
  }

  /**
   * Removes a single {@link ListItem} from the list group with a boolean to indicate if this should
   * inform handlers or not
   *
   * @param item the {@link ListItem} to remove
   * @param silent true for not informing the handlers associated with the list group, false
   *     otherwise
   * @return same instance
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
   * Sets to true for adding border for all elements inside the list group
   *
   * @param bordered true to add border, false otherwise
   * @return same instance
   */
  public ListGroup<T> setBordered(boolean bordered) {
    if (bordered) {
      removeCss(ListStyles.BORDERED);
      css(ListStyles.BORDERED);
    } else {
      removeCss(ListStyles.BORDERED);
    }

    return this;
  }

  /** @return All the {@link ListItem} */
  public List<ListItem<T>> getItems() {
    return items;
  }

  /** @return All the selected {@link ListItem} */
  public List<ListItem<T>> getSelectedItems() {
    return items.stream().filter(ListItem::isSelected).collect(Collectors.toList());
  }

  /** @return All the selected values */
  public List<T> getSelectedValues() {
    return items.stream()
        .filter(ListItem::isSelected)
        .map(ListItem::getValue)
        .collect(Collectors.toList());
  }

  /** @return All the values */
  public List<T> getValues() {
    return items.stream().map(ListItem::getValue).collect(Collectors.toList());
  }

  /**
   * Selects a collection of {@link ListItem}
   *
   * @param items the collection of {@link ListItem} to select
   * @return same instance
   */
  public ListGroup<T> select(List<ListItem<T>> items) {
    List<ListItem<? extends T>> selected = new ArrayList<>();
    items.forEach(listItem -> select(listItem, multiSelect, selected::add));
    if (!selected.isEmpty() && multiSelect) {
      this.selectionListeners.forEach(listener -> listener.onSelect(selected));
      selected.forEach(listItem -> listItem.fireSelectionHandlers(true));
    }
    return this;
  }

  /**
   * Selects a single {@link ListItem}
   *
   * @param listItem the {@link ListItem} to select
   * @return same instance
   */
  public ListGroup<T> select(ListItem<T> listItem) {
    return select(listItem, false);
  }

  /**
   * Selects a single {@link ListItem} with a boolean to indicate if this should inform handlers or
   * not
   *
   * @param listItem the {@link ListItem} to select
   * @param silent true for not informing the handlers associated with the list group, false
   *     otherwise
   * @return same instance
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
      listItem.setSelected(true, silent);
      onSelected.accept(listItem);
      if (!silent) {
        List<ListItem<? extends T>> selected = new ArrayList<>();
        selected.add(listItem);
        this.selectionListeners.forEach(listener -> listener.onSelect(selected));
      }
    }
    return this;
  }

  /**
   * Deselects a collection of {@link ListItem}
   *
   * @param items the collection of {@link ListItem} to deselect
   * @return same instance
   */
  public ListGroup<T> deselect(List<ListItem<T>> items) {
    List<ListItem<? extends T>> deselected = new ArrayList<>();
    items.forEach(listItem -> deselect(listItem, false, deselected::add));
    if (!deselected.isEmpty()) {
      this.deSelectionListeners.forEach(listener -> listener.onDeSelect(deselected));
      deselected.forEach(listItem -> listItem.fireSelectionHandlers(false));
    }
    return this;
  }

  /**
   * Deselects a single {@link ListItem}
   *
   * @param listItem the {@link ListItem} to deselect
   * @return same instance
   */
  public ListGroup<T> deselect(ListItem<T> listItem) {
    return deselect(listItem, false);
  }

  /**
   * Deselects a single {@link ListItem} with a boolean to indicate if this should inform handlers
   * or not
   *
   * @param listItem the {@link ListItem} to deselect
   * @param silent true for not informing the handlers associated with the list group, false
   *     otherwise
   * @return same instance
   */
  public ListGroup<T> deselect(ListItem<T> listItem, boolean silent) {
    return deselect(listItem, silent, item -> {});
  }

  private ListGroup<T> deselect(
      ListItem<T> listItem, boolean silent, Consumer<ListItem<? extends T>> onDeselected) {
    if (listItem.isSelected() && this.items.contains(listItem)) {
      listItem.setSelected(false, silent);
      onDeselected.accept(listItem);
      if (!silent) {
        List<ListItem<? extends T>> deselected = new ArrayList<>();
        deselected.add(listItem);
        this.deSelectionListeners.forEach(listener -> listener.onDeSelect(deselected));
      }
    }
    return this;
  }

  /** @return True if the list group supports multiselect */
  public boolean isMultiSelect() {
    return multiSelect;
  }

  /**
   * Sets if this list group is a multiselect
   *
   * @param multiSelect true to add multiselect support, false otherwise
   * @return same instance
   */
  public ListGroup<T> setMultiSelect(boolean multiSelect) {
    this.multiSelect = multiSelect;
    removeCss(Styles.disable_selection);
    if (multiSelect) {
      css(Styles.disable_selection);
    }
    return this;
  }

  /**
   * Adds selection listener to be called when item is selected
   *
   * @param selectionListener the {@link SelectionListener} to add
   * @return same instance
   */
  public ListGroup<T> addSelectionListener(SelectionListener<T> selectionListener) {
    this.selectionListeners.add(selectionListener);
    return this;
  }

  /**
   * Removes a selection listener
   *
   * @param selectionListener the {@link SelectionListener} to remove
   * @return same instance
   */
  public ListGroup<T> removeSelectionListener(SelectionListener<T> selectionListener) {
    this.selectionListeners.remove(selectionListener);
    return this;
  }

  /**
   * Adds deselection listener to be called when item is deselected
   *
   * @param deSelectionListener the {@link DeSelectionListener} to add
   * @return same instance
   */
  public ListGroup<T> addDeselectionListener(DeSelectionListener<T> deSelectionListener) {
    this.deSelectionListeners.add(deSelectionListener);
    return this;
  }

  /**
   * Removes a deselection listener
   *
   * @param deSelectionListener the {@link DeSelectionListener} to remove
   * @return same instance
   */
  public ListGroup<T> removeDeselectionListener(DeSelectionListener<T> deSelectionListener) {
    this.deSelectionListeners.remove(deSelectionListener);
    return this;
  }

  /**
   * Adds adding listener to be called when a new item is added
   *
   * @param addListener the {@link AddListener} to add
   * @return same instance
   */
  public ListGroup<T> addAddListener(AddListener<T> addListener) {
    this.addListeners.add(addListener);
    return this;
  }

  /**
   * Removes adding listener
   *
   * @param addListener the {@link AddListener} to remove
   * @return same instance
   */
  public ListGroup<T> removeAddListener(AddListener<T> addListener) {
    this.addListeners.remove(addListener);
    return this;
  }

  /**
   * Adds removing listener to be called when item is removed
   *
   * @param removeListener the {@link RemoveListener} to add
   * @return same instance
   */
  public ListGroup<T> addRemoveListener(RemoveListener<T> removeListener) {
    this.removeListeners.add(removeListener);
    return this;
  }

  /**
   * Removes removing listener
   *
   * @param removeListener the {@link RemoveListener} to remove
   * @return same instance
   */
  public ListGroup<T> removeRemoveListener(RemoveListener<T> removeListener) {
    this.removeListeners.remove(removeListener);
    return this;
  }

  /** @return The color for selected items */
  public Color getSelectionColor() {
    return selectionColor;
  }

  /**
   * Sets the color for all selected items
   *
   * @param selectionColor the {@link Color}
   * @return same instance
   */
  public ListGroup<T> setSelectionColor(Color selectionColor) {
    this.selectionColor = selectionColor;
    return this;
  }

  /**
   * Sets if this list group supports single selection
   *
   * @param selectable true to add support for single selection, false otherwise
   * @return same instance
   */
  public ListGroup<T> setSelectable(boolean selectable) {
    getItems().forEach(item -> item.setSelectable(selectable));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLUListElement element() {
    return element;
  }

  /**
   * A handler which will be called for adding elements inside the {@link ListItem}
   *
   * @param <T> the type of the value
   */
  @FunctionalInterface
  public interface ItemRenderer<T> {
    /**
     * @param listGroup The {@link ListGroup} which holds the list item
     * @param listItem the {@link ListItem} to render
     */
    void onRender(ListGroup<T> listGroup, ListItem<T> listItem);
  }

  /**
   * A handler which will be called when removing items
   *
   * @param <T> the type of the value
   */
  @FunctionalInterface
  public interface RemoveListener<T> {
    /** @param removedItems The removed list of {@link ListItem} */
    void onRemove(List<ListItem<? extends T>> removedItems);
  }

  /**
   * A handler which will be called when adding items
   *
   * @param <T> the type of the value
   */
  @FunctionalInterface
  public interface AddListener<T> {
    /** @param addedItems The added list of {@link ListItem} */
    void onAdd(List<ListItem<? extends T>> addedItems);
  }

  /**
   * A handler which will be called when selecting items
   *
   * @param <T> the type of the value
   */
  @FunctionalInterface
  public interface SelectionListener<T> {
    /** @param selectedItems The selected list of {@link ListItem} */
    void onSelect(List<ListItem<? extends T>> selectedItems);
  }

  /**
   * A handler which will be called when deselecting items
   *
   * @param <T> the type of the value
   */
  @FunctionalInterface
  public interface DeSelectionListener<T> {
    /** @param deSelectedItems The deselected list of {@link ListItem} */
    void onDeSelect(List<ListItem<? extends T>> deSelectedItems);
  }
}
