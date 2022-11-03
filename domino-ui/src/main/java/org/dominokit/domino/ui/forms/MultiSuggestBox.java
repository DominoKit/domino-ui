package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MultiSuggestBox<V> extends AbstractSuggestBox<V, List<V>, Option<V>, MultiSuggestBox<V>> {

    private List<Option<V>> selectedOptions = new ArrayList<>();

    public static <V> MultiSuggestBox<V> create(SuggestBoxStore<V, Option<V>> store){
        return new MultiSuggestBox<>(store);
    }

    public static <V> MultiSuggestBox<V> create(String label, SuggestBoxStore<V, Option<V>> store){
        return new MultiSuggestBox<>(label, store);
    }

    public MultiSuggestBox(SuggestBoxStore<V, Option<V>> store) {
        super(store);
    }

    public MultiSuggestBox(String label, SuggestBoxStore<V, Option<V>> store) {
        super(store);
        setLabel(label);
    }

    @Override
    protected void doSetValue(List<V> values) {
        clearValue(false);
        values.forEach(v -> {
            store.find(v, this::applyOptionValue);
        });
    }

    @Override
    public List<V> getValue() {
        return selectedOptions
                .stream()
                .map(AbstractMenuItem::getValue)
                .collect(Collectors.toList());
    }

    @Override
    protected void onOptionSelected(Option<V> suggestion) {
        selectedOptions.add(suggestion);
    }

    @Override
    protected void onBackspace() {
        if (!selectedOptions.isEmpty()) {
            Option<V> option = selectedOptions.get(selectedOptions.size() - 1);
            option.deselect();
            selectedOptions.remove(option);
        }
    }

    @Override
    public void onApplyMissingOption(Option<V> option) {
        selectedOptions.add(option);
    }

    @Override
    protected MultiSuggestBox<V> clearValue(boolean silent) {
        if (!selectedOptions.isEmpty()) {
            List<V> oldValue = getValue();
            optionsMenu.withPauseSelectionListenersToggle(true, field -> {
                new ArrayList<>(selectedOptions)
                        .forEach(AbstractMenuItem::deselect);
            });

            if (!silent) {
                triggerClearListeners(oldValue);
            }

            if (isAutoValidation()) {
                autoValidate();
            }
        }

        return this;
    }
}
