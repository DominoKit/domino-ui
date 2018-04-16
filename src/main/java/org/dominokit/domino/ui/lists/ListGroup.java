package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.ContentIcons;
import org.dominokit.domino.ui.utils.HasMultiSelectSupport;
import org.dominokit.domino.ui.utils.Selectable;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ListGroup<T> implements IsElement<HTMLDivElement>, HasMultiSelectSupport<ListItem<T>> {

    private final HTMLDivElement element;
    private List<ListItem<T>> allItems = new LinkedList<>();
    private boolean multiSelect = false;
    private List<SelectionChangeHandler<T>> selectionHandlers=new ArrayList<>();

    private ListGroup(HTMLDivElement element) {
        this.element = element;
    }

    public static <T> ListGroup<T> create() {
        return new ListGroup<>(div().css("list-group").asElement());
    }

    public ListItem<T> addItem(T value) {
        ListItem<T> listItem = ListItem.create(this, value);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListItem<T> addItem(T value, String text) {
        ListItem<T> listItem = ListItem.create(this, value);
        listItem.setText(text);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListGroup<T> appendItem(ListItem<T> listItem) {
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        listItem.setParent(this);
        return this;
    }

    public ListItem<T> createItem(T value, String text) {
        ListItem<T> listItem = ListItem.create(this, value);
        listItem.setText(text);
        return listItem;
    }

    public ListGroup<T> multiSelect() {
        setMultiSelect(true);
        return this;
    }

    @Override
    public List<ListItem<T>> getSelectedItems() {
        return allItems.stream().filter(ListItem::isSelected).collect(Collectors.toList());
    }

    public List<T> getSelectedValues(){
        List<ListItem<T>> selectedItems = getSelectedItems();
        if(selectedItems.isEmpty())
            return new ArrayList<>();
        else
            return selectedItems.stream().map(i-> i.getValue()).collect(Collectors.toList());
    }

    public ListGroup<T> removeSelected() {
        getSelectedItems().forEach(item -> {
            allItems.remove(item);
            item.asElement().remove();
        });
        return this;
    }

    public ListGroup<T> removeItem(ListItem<T> listItem) {
        if(allItems.contains(listItem)) {
            allItems.remove(listItem);
            listItem.asElement().remove();
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

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

    @Override
    public void onSelectionChange(ListItem<T> source) {
        for(int i=0;i<selectionHandlers.size();i++){
            selectionHandlers.get(i).onSelectionChanged(source);
        }
    }

    public ListGroup<T> addSelectionChangeHandler(SelectionChangeHandler<T> selectionChangeHandler){
        this.selectionHandlers.add(selectionChangeHandler);
        return this;
    }

    public ListGroup<T> removeSelectionChangeHandler(SelectionChangeHandler<T> selectionChangeHandler){
        this.selectionHandlers.remove(selectionChangeHandler);
        return this;
    }

    public interface SelectionChangeHandler<T> {
        void onSelectionChanged(ListItem<T> item);
    }
}
