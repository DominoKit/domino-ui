package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.menu.AbstractMenuItem;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class MultiSuggestBox<V> extends AbstractSuggestionBox<V, List<V>, MultiSuggestBox<V>> {

    private List<SelectOption<V>> selectedOptions = new ArrayList<>();

    public MultiSuggestBox(SuggestBoxStore<V> store) {
        super(store);
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
    protected void onOptionSelected(SelectOption<V> suggestion) {
        selectedOptions.add(suggestion);
    }

    @Override
    protected void onBackspace() {
        if (!selectedOptions.isEmpty()) {
            SelectOption<V> option = selectedOptions.get(selectedOptions.size() - 1);
            option.deselect();
            selectedOptions.remove(option);
        }
    }

    @Override
    public void onApplyMissingOption(SelectOption<V> option) {
        selectedOptions.add(option);
    }

    @Override
    protected MultiSuggestBox<V> clearValue(boolean silent) {
        if (!selectedOptions.isEmpty()) {
            List<V> oldValue = getValue();
            optionsMenu.withPauseSelectionListenersToggle(true, (field, handler) -> {
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
