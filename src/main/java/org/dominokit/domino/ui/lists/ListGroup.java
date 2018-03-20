package org.dominokit.domino.ui.lists;

import org.dominokit.domino.ui.utils.HasMultiSelectSupport;
import elemental2.dom.HTMLDivElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static org.jboss.gwt.elemento.core.Elements.div;

public class ListGroup<T> implements IsElement<HTMLDivElement> , HasMultiSelectSupport<ListItem<T>> {

    private final HTMLDivElement element;
    private List<ListItem<T>> allItems=new LinkedList<>();
    private boolean multiSelect=false;

    private ListGroup(HTMLDivElement element) {
        this.element = element;
    }

    public static <T> ListGroup<T> create(){
        return new ListGroup<>(div().css("list-group").asElement());
    }

    public ListItem<T> addItem(T value){
        ListItem<T> listItem = ListItem.create(this, value);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListItem<T> addItem(T value, String text){
        ListItem<T> listItem = ListItem.create(this, value);
        listItem.setText(text);
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return listItem;
    }

    public ListGroup<T> appendItem(ListItem<T> listItem){
        allItems.add(listItem);
        asElement().appendChild(listItem.asElement());
        return this;
    }

    public ListItem<T> createItem(T value, String text){
        ListItem<T> listItem = ListItem.create(this, value);
        listItem.setText(text);
        return listItem;
    }

    public ListGroup<T> multiSelect(){
        setMultiSelect(true);
        return this;
    }

    @Override
    public List<ListItem<T>> getSelectedItems() {
        return allItems.stream().filter(ListItem::isSelected).collect(Collectors.toList());
    }


    @Override
    public boolean isMultiSelect() {
        return multiSelect;
    }

    @Override
    public void setMultiSelect(boolean multiSelect) {
        this.multiSelect=multiSelect;
    }

    @Override
    public List<ListItem<T>> getItems() {
        return allItems;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
