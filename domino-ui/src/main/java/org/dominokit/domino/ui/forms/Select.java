package org.dominokit.domino.ui.forms;

import java.util.Objects;

public class Select<V> extends AbstractSelect<V, V, Option<V>, Select<V>> {

    public static <V> Select<V> create() {
        return new Select<>();
    }

    public static <V> Select<V> create(String label) {
        return new Select<>(label);
    }

    public Select() {
    }

    public Select(String label) {
        setLabel(label);
    }

    protected void doSetValue(V value) {
        optionsMenu.getMenuItems()
                .stream()
                .filter(menuItem -> Objects.equals(value, menuItem.getValue()))
                .findFirst()
                .ifPresent(menuItem -> optionsMenu.select(menuItem));
    }

    @Override
    public V getValue() {
        if (!optionsMenu.getSelection().isEmpty()) {
            return optionsMenu.getSelection().get(0).getValue();
        }
        return null;
    }
}
