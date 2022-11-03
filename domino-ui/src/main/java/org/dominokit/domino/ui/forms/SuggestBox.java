package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;

public class SuggestBox<V> extends AbstractSuggestBox<V, V, Option<V>, SuggestBox<V>> {

    private Option<V> selectedOption;

    public static <V> SuggestBox<V> create(SuggestBoxStore<V, Option<V>> store){
        return new SuggestBox<>(store);
    }

    public static <V> SuggestBox<V> create(String label, SuggestBoxStore<V, Option<V>> store){
        return new SuggestBox<>(label, store);
    }
     public SuggestBox(SuggestBoxStore<V, Option<V>> store) {
        super(store);
    }
     public SuggestBox(String label, SuggestBoxStore<V, Option<V>> store) {
        super(store);
        setLabel(label);
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
    protected void onOptionSelected(Option<V> option) {
         if(nonNull(this.selectedOption)){
             this.selectedOption.deselect(false);
         }
        this.selectedOption = option;
    }

    @Override
    public void onApplyMissingOption(Option<V> option) {
        if(nonNull(this.selectedOption)){
            this.selectedOption.deselect(false);
        }
        this.selectedOption = option;
    }

    @Override
    protected SuggestBox<V> clearValue(boolean silent) {
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
