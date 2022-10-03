package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MultiSelect<V, S> extends AbstractSelect<V, S, List<V>, MultiSelect<V, S>> {

     public MultiSelect(Function<S, Optional<SelectOption<V>>> optionMapper) {
        super(optionMapper);
        optionsMenu.setMultiSelect(true);
    }

    public MultiSelect<V, S> withValue(V... value) {
        return withValue(isChangeListenersPaused(), value);
    }

    public MultiSelect<V, S> withValue(boolean silent, V... value) {
        return withValue(Arrays.asList(value), silent);
    }

    protected void doSetValue(List<V> value) {
        withPauseChangeListenersToggle(true, (field, handler) -> {
             value.forEach(v -> findOptionByValue(v).ifPresent(AbstractMenuItem::select));
         });
    }

    @Override
    public List<V> getValue() {
        if (!optionsMenu.getSelected().isEmpty()) {
            return optionsMenu.getSelected()
                    .stream()
                    .map(AbstractMenuItem::getValue)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
