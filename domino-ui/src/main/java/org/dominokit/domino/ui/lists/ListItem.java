package org.dominokit.domino.ui.lists;

import elemental2.dom.Event;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;

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

        KeyboardEvents.listenOn(element)
                .onEnter(this::trySelect);
    }

    private void trySelect(Event evt) {
        evt.stopPropagation();
        if (selectable && enabled && selectOnClick) {
            if (isSelected()) {
                deselect();
            } else {
                select();
            }
        }
    }

    @Override
    public HTMLLIElement element() {
        return element;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HTMLLIElement getElement() {
        return element;
    }

    public void setElement(HTMLLIElement element) {
        this.element = element;
    }

    public boolean valueEquals(T value) {
        return Objects.equals(this.value, value);
    }

    public ListItem<T> select() {
        return select(false);
    }

    public ListItem<T> deselect() {
        return deselect(false);
    }

    public ListItem<T> select(boolean silent) {
        this.listGroup.select(this, silent);
        return this;
    }

    public ListItem<T> deselect(boolean silent) {
        this.listGroup.deselect(this, silent);
        return this;
    }

    public boolean isSelected() {
        return selected;
    }

    public ListItem<T> onSelectionChange(SelectionChangedListener<T> listener) {
        this.selectionChangedListeners.add(listener);
        return this;
    }

    public ListItem<T> setSelectable(boolean selectable) {
        this.selectable = selectable;
        if (selectable) {
            css(ListStyles.SELECTABLE);
        } else {
            removeCss(ListStyles.SELECTABLE);
        }
        return this;
    }

    public boolean isSelectOnClick() {
        return selectOnClick;
    }

    public ListItem<T>  setSelectOnClick(boolean selectOnClick) {
        this.selectOnClick = selectOnClick;
        return this;
    }

    public boolean isEnabled() {
        return enabled;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        ListItem<?> listItem = (ListItem<?>) other;
        return value.equals(listItem.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    void setSelected(boolean selected, boolean silent) {
        this.selected = selected;
        if(nonNull(listGroup.getSelectionColor())){
            removeCss(listGroup.getSelectionColor().getBackground());
        }
        removeCss(ListStyles.SELECTED);
        if(selected){
            css(ListStyles.SELECTED);
            if(nonNull(listGroup.getSelectionColor())){
                css(listGroup.getSelectionColor().getBackground());
            }
        }
        if(!silent) {
            this.selectionChangedListeners.forEach(listener -> listener.onSelectionChanged(ListItem.this, selected));
        }
    }

    @FunctionalInterface
    public interface SelectionChangedListener<T> {
        void onSelectionChanged(ListItem<? extends T> item, boolean selected);
    }
}
