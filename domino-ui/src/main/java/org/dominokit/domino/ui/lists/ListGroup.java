package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLLIElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.Elements;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.li;

public class ListGroup<T> extends BaseDominoElement<HTMLUListElement, ListGroup<T>> {

    private HTMLUListElement element;
    private final List<ListItem<T>> items = new ArrayList<>();
    private ItemRenderer<T> itemRenderer = (listGroup, item) -> {
    };

    private final List<RemoveListener<T>> removeListeners = new ArrayList<>();
    private final List<AddListener<T>> addListeners = new ArrayList<>();
    private final List<SelectionListener<T>> selectionListeners = new ArrayList<>();
    private final List<DeSelectionListener<T>> deSelectionListeners = new ArrayList<>();
    private boolean multiSelect = false;
    private ListItem<? extends T> lastSelected = null;

    public static <T> ListGroup<T> create() {
        return new ListGroup<>();
    }

    public ListGroup() {
        element = Elements.ul().css(ListStyles.LIST_GROUP, ListStyles.BORDERED).element();
        init(this);
    }

    public ListGroup<T> setItemRenderer(ItemRenderer<T> itemRenderer) {
        this.itemRenderer = itemRenderer;
        return this;
    }

    public ListGroup<T> setItems(List<? extends T> items) {
        removeAll();
        items.forEach(this::addItem);
        addListeners.forEach(listener -> listener.onAdd(new ArrayList<>(this.items)));
        return this;
    }

    public ListGroup<T> removeAll() {
        clearElement();
        List<ListItem<? extends T>> removed = new ArrayList<>(this.items);
        items.clear();
        removeListeners.forEach(listener -> listener.onRemove(removed));
        return this;
    }

    public ListGroup<T> addItems(List<? extends T> items) {
        List<ListItem<? extends T>> addedItems = new ArrayList<>();
        items.forEach(value -> insertAt(this.items.size(), value, true, addedItems::add));
        if (!addedItems.isEmpty()) {
            this.addListeners.forEach(listener -> listener.onAdd(addedItems));
        }
        return this;
    }

    public ListGroup<T> addItem(T value) {
        return insertAt(items.isEmpty() ? 0 : items.size() , value);
    }

    public ListGroup<T> insertFirst(T value) {
        return insertAt(0, value);
    }

    public ListGroup<T> insertAt(int index, T value) {
        return insertAt(index, value, false, listItem -> {
        });
    }

    private ListGroup<T> insertAt(int index, T value, boolean silent, Consumer<ListItem<T>> onItemAdded) {
        if (index == 0 || (index >= 0 && index <= items.size())) {
            HTMLLIElement li = li().css(ListStyles.LIST_GROUP_ITEM).element();
            ListItem<T> listItem = new ListItem<>(this, value, li);

            if(index==items.size()) {
                items.add(listItem);
            }else {
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

    public ListGroup<T> removeItemsByValue(List<? extends T> toBeRemoved) {
        return removeItems(items.stream()
                .filter(listItem -> toBeRemoved.contains(listItem.getValue()))
                .collect(Collectors.toList()));
    }

    public ListGroup<T> removeItem(T value) {
        Optional<ListItem<T>> first = items.stream()
                .filter(listItem -> listItem.valueEquals(value))
                .findFirst();

        first.ifPresent(this::removeItem);
        return this;
    }

    public ListGroup<T> removeItem(ListItem<? extends T> item) {
        return removeItem(item, false);
    }

    public ListGroup<T> removeItems(List<ListItem<? extends T>> items) {
        items.forEach(listItem -> removeItem(listItem, true));
        removeListeners.forEach(listener -> listener.onRemove(new ArrayList<>(items)));
        return this;
    }

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

    public ListGroup<T> setBordered(boolean bordered) {
        if (bordered) {
            removeCss(ListStyles.BORDERED);
            css(ListStyles.BORDERED);
        } else {
            removeCss(ListStyles.BORDERED);
        }

        return this;
    }

    public List<ListItem<T>> getItems() {
        return items;
    }

    public List<ListItem<T>> getSelectedItems() {
        return items.stream()
                .filter(ListItem::isSelected)
                .collect(Collectors.toList());
    }

    public List<T> getSelectedValues() {
        return items.stream()
                .filter(ListItem::isSelected)
                .map(ListItem::getValue)
                .collect(Collectors.toList());
    }

    public List<T> getValues() {
        return items.stream()
                .map(ListItem::getValue)
                .collect(Collectors.toList());
    }

    public ListGroup<T> select(List<ListItem<? extends T>> items) {
        List<ListItem<? extends T>> selected = new ArrayList<>();
        items.forEach(listItem -> select(listItem, multiSelect, selected::add));
        if (!selected.isEmpty() && multiSelect) {
            this.selectionListeners.forEach(listener -> listener.onSelect(selected));
        }
        return this;
    }

    public ListGroup<T> select(ListItem<T> listItem) {
        return select(listItem, false);
    }

    public ListGroup<T> select(ListItem<T> listItem, boolean silent) {
        return select(listItem, silent, item -> {
        });
    }

    private ListGroup<T> select(ListItem<? extends T> listItem, boolean silent, Consumer<ListItem<? extends T>> onSelected) {
        if (!listItem.isSelected() && this.items.contains(listItem)) {
            if (!multiSelect) {
                if (nonNull(lastSelected)) {
                    lastSelected.deselect();
                }
                this.lastSelected = listItem;
            }
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

    public ListGroup<T> deselect(List<ListItem<? extends T>> items) {
        List<ListItem<? extends T>> deselected = new ArrayList<>();
        items.forEach(listItem -> deselect(listItem, false, deselected::add));
        if (!deselected.isEmpty()) {
            this.deSelectionListeners.forEach(listener -> listener.onDeSelect(deselected));
        }
        return this;
    }

    public ListGroup<T> deselect(ListItem<T> listItem) {
        return deselect(listItem, false);
    }

    public ListGroup<T> deselect(ListItem<T> listItem, boolean silent) {
        return deselect(listItem, silent, item -> {
        });
    }

    private ListGroup<T> deselect(ListItem<? extends T> listItem, boolean silent, Consumer<ListItem<? extends T>> onDeselected) {
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

    public boolean isMultiSelect() {
        return multiSelect;
    }

    public ListGroup<T> setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
        return this;
    }

    public ListGroup<T> addSelectionListener(SelectionListener<T> selectionListener){
        this.selectionListeners.add(selectionListener);
        return this;
    }

    public ListGroup<T> removeSelectionListener(SelectionListener<T> selectionListener){
        this.selectionListeners.remove(selectionListener);
        return this;
    }

    public ListGroup<T> addDeselectionListener(DeSelectionListener<T> deSelectionListener){
        this.deSelectionListeners.add(deSelectionListener);
        return this;
    }

    public ListGroup<T> removeDeselectionListener(DeSelectionListener<T> deSelectionListener){
        this.selectionListeners.remove(deSelectionListener);
        return this;
    }

    public ListGroup<T> addAddListener(AddListener<T> addListener){
        this.addListeners.add(addListener);
        return this;
    }

    public ListGroup<T> removeAddListener(AddListener<T> addListener){
        this.addListeners.remove(addListener);
        return this;
    }

    public ListGroup<T> addRemoveListener(RemoveListener<T> removeListener){
        this.removeListeners.add(removeListener);
        return this;
    }

    public ListGroup<T> removeRemoveListener(RemoveListener<T> removeListener){
        this.removeListeners.remove(removeListener);
        return this;
    }

    @Override
    public HTMLUListElement element() {
        return element;
    }

    @FunctionalInterface
    public interface ItemRenderer<T> {

        void onRender(ListGroup<T> listGroup, ListItem<T> listItem);
    }

    @FunctionalInterface
    public interface RemoveListener<T> {
        void onRemove(List<ListItem<? extends T>> removedItems);
    }

    @FunctionalInterface
    public interface AddListener<T> {
        void onAdd(List<ListItem<? extends T>> addedItems);
    }

    @FunctionalInterface
    public interface SelectionListener<T> {
        void onSelect(List<ListItem<? extends T>> selectedItems);
    }

    @FunctionalInterface
    public interface DeSelectionListener<T> {
        void onDeSelect(List<ListItem<? extends T>> deSelectedItems);
    }
}
