package org.dominokit.domino.ui.forms;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;

public class Select<V, S> extends AbstractSelect<V, S, V, Select<V, S>> {

     public Select(Function<S, Optional<SelectOption<V>>> optionMapper) {
        super(optionMapper);
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
        if (!optionsMenu.getSelected().isEmpty()) {
            return optionsMenu.getSelected().get(0).getValue();
        }
        return null;
    }
}
