package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;

public class SuggestionBox<V> extends AbstractSuggestionBox<V, V, SuggestionBox<V>> {

    private SelectOption<V> selectedOption;

     public SuggestionBox(SuggestBoxStore<V> store) {
        super(store);
    }

    protected void doSetValue(V value) {
         store.find(value, this::applyOptionValue);
    }

    @Override
    public V getValue() {
        if (nonNull(selectedOption)) {
            return selectedOption.getValue();
        }
        return null;
    }

    @Override
    protected void onBackspace() {
        if (nonNull(selectedOption)) {
            selectedOption.deselect();
            selectedOption = null;
        }
    }

    @Override
    protected void onOptionSelected(SelectOption<V> option) {
         if(nonNull(this.selectedOption)){
             this.selectedOption.deselect(false);
         }
        this.selectedOption = option;
    }

    @Override
    public void onApplyMissingOption(SelectOption<V> option) {
        if(nonNull(this.selectedOption)){
            this.selectedOption.deselect(false);
        }
        this.selectedOption = option;
    }

    @Override
    protected SuggestionBox<V> clearValue(boolean silent) {
        if (nonNull(selectedOption)) {
            V oldValue = getValue();
            withPauseChangeListenersToggle(true, (field, handler) -> {
                selectedOption.deselect();
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
