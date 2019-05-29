package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasMultiSelectionSupport;
import org.dominokit.domino.ui.utils.HasSelectionSupport;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.jboss.gwt.elemento.core.Elements.div;

public class ListGroup<T> extends BaseDominoElement<HTMLDivElement, ListGroup<T>> implements HasSelectionSupport<ListItem<T>>, HasMultiSelectionSupport {

    private final HTMLDivElement element;
    private List<ListItem<T>> allItems = new LinkedList<>();
    private boolean multiSelect = false;
    private List<SelectionChangeHandler<T>> selectionHandlers = new ArrayList<>();
    private boolean selectable = true;

    public ListGroup() {
        this.element = div()
                .css(ListStyles.LIST_GROUP)
                .css(Styles.default_shadow)
                .asElement();
        init(this);
    }

    public static <T> ListGroup<T> create() {
        return new ListGroup<>();
    }

    public ListItem<T> addItem(T value) {
        ListItem<T> listItem = ListItem.create(value);
        listItem.setParent(this);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListItem<T> addItem(T value, String text) {
        ListItem<T> listItem = ListItem.create(value);
        listItem.setParent(this);
        listItem.setText(text);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListGroup<T> appendChild(ListItem<T> listItem) {
        listItem.setParent(this);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        listItem.setParent(this);
        return this;
    }

    public ListItem<T> createItem(T value, String text) {
        ListItem<T> listItem = ListItem.create(value);
        listItem.setParent(this);
        listItem.setText(text);
        return listItem;
    }

    public ListGroup<T> multiSelect() {
        setMultiSelect(true);
        return this;
    }

    @Override
    public List<ListItem<T>> getSelectedItems() {
        return allItems.stream().filter(ListItem::isSelected).collect(toList());
    }

    public List<T> getSelectedValues() {
        List<ListItem<T>> selectedItems = getSelectedItems();
        if (selectedItems.isEmpty())
            return new ArrayList<>();
        else
            return selectedItems.stream().map(ListItem::getValue).collect(toList());
    }

    public ListGroup<T> removeSelected() {
        getSelectedItems().forEach(item -> {
            allItems.remove(item);
            item.asElement().remove();
        });
        return this;
    }

    public ListGroup<T> removeItem(ListItem<T> listItem) {
        if (allItems.contains(listItem)) {
            allItems.remove(listItem);
            listItem.asElement().remove();
        }
        return this;
    }

    @Override
    public boolean isSelectable() {
        return selectable;
    }

    public ListGroup<T> setSelectable(boolean selectable) {
        this.selectable = selectable;
        for (ListItem<T> listItem : getSelectedItems()) {
            if (!selectable) {
                listItem.deselect(true);
            }
        }

        return this;
    }

    @Override
    public boolean isMultiSelect() {
        return multiSelect;
    }

    @Override
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect = multiSelect;
    }

    @Override
    public List<ListItem<T>> getItems() {
        return allItems;
    }

    public List<T> getAllValues() {
        return allItems.stream().map(ListItem::getValue).collect(toList());
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public void onSelectionChange(ListItem<T> source) {
        if (selectable) {
            for (int i = 0; i < selectionHandlers.size(); i++) {
                selectionHandlers.get(i).onSelectionChanged(source);
            }
        }
    }

    public ListGroup<T> removeAll() {
        getItems().forEach(this::removeItem);
        return this;
    }

    public ListGroup<T> addSelectionChangeHandler(SelectionChangeHandler<T> selectionChangeHandler) {
        this.selectionHandlers.add(selectionChangeHandler);
        return this;
    }

    public ListGroup<T> removeSelectionChangeHandler(SelectionChangeHandler<T> selectionChangeHandler) {
        this.selectionHandlers.remove(selectionChangeHandler);
        return this;
    }

    public interface SelectionChangeHandler<T> {
        void onSelectionChanged(ListItem<T> item);
    }
}
