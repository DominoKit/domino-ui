package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSelect<V> extends AbstractSelect<V,List<V>, Option<V>, MultiSelect<V>> {

    public <V> MultiSelect<V> create(){
        return new MultiSelect<>();
    }

    public <V> MultiSelect<V> create(String label){
        return new MultiSelect<>(label);
    }

     public MultiSelect() {
        optionsMenu.setMultiSelect(true);
    }
     public MultiSelect(String label) {
        this();
        setLabel(label);
    }

    public MultiSelect<V> withValue(V... value) {
        return withValue(isChangeListenersPaused(), value);
    }

    public MultiSelect<V> withValue(boolean silent, V... value) {
        return withValue(Arrays.asList(value), silent);
    }

    protected void doSetValue(List<V> value) {
        withPauseChangeListenersToggle(true, (field, handler) -> {
             value.forEach(v -> findOptionByValue(v).ifPresent(AbstractMenuItem::select));
         });
    }

    @Override
    public List<V> getValue() {
        if (!optionsMenu.getSelection().isEmpty()) {
            return optionsMenu.getSelection()
                    .stream()
                    .map(AbstractMenuItem::getValue)
                    .collect(Collectors.toList());
        }
        return null;
    }
}
