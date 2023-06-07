/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.forms.suggest;

import org.dominokit.domino.ui.IsElement;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class SuggestBox<V, E extends IsElement<?>, O extends Option<V, E, O>> extends AbstractSuggestBox<V, V, E, O, SuggestBox<V, E, O>> {

    private O selectedOption;

    public static <V, E extends IsElement<?>, O extends Option<V, E, O>> SuggestBox<V, E, O> create(SuggestionsStore<V, E, O> store) {
        return new SuggestBox<>(store);
    }

    public static <V, E extends IsElement<?>, O extends Option<V, E, O>> SuggestBox<V, E, O> create(String label, SuggestionsStore<V, E, O> store) {
        return new SuggestBox<>(label, store);
    }

    public SuggestBox(SuggestionsStore<V, E, O> store) {
        super(store);
    }

    public SuggestBox(String label, SuggestionsStore<V, E, O> store) {
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
            selectedOption.remove();
            selectedOption = null;
        }
    }

    @Override
    public void onOptionSelected(O option) {
        withOption(option);
        updateTextValue();
        if(nonNull(this.selectedOption)){
            onOptionDeselected(this.selectedOption);
        }
        this.selectedOption = option;
    }

    public SuggestBox<V, E,O> withOption(O option) {
        return withOption(option, isChangeListenersPaused());
    }

    public SuggestBox<V, E,O> withOption(O option, boolean silent) {
        V oldValue = getValue();
        if (!Objects.equals(option.getValue(), oldValue)) {
            this.selectedOption = option;
            if (!silent) {
                triggerChangeListeners(oldValue, getValue());
            }
        }
        autoValidate();
        return this;
    }

    private void updateTextValue() {
        getInputElement().element().value = getStringValue();
    }

    @Override
    public void onOptionDeselected(O option) {
        option.remove();
        if(Objects.equals(this.selectedOption, option)){
            this.selectedOption = null;
        }
        this.optionsMenu.withPauseSelectionListenersToggle(true, field -> {
            option.getMenuItem().deselect(true);
        });
    }

    @Override
    protected SuggestBox<V, E, O> clearValue(boolean silent) {
        if (nonNull(selectedOption)) {
            V oldValue = getValue();
            withPauseChangeListenersToggle(
                    true,
                    field -> onOptionDeselected(selectedOption));

            if (!silent) {
                triggerClearListeners(oldValue);
                triggerChangeListeners(oldValue, getValue());
            }

            if (isAutoValidation()) {
                autoValidate();
            }
        }

        return this;
    }

    @Override
    public String getStringValue() {
        if(nonNull(this.selectedOption)) {
            return String.valueOf(this.selectedOption.getValue());
        }
        return null;
    }

    @Override
    protected void onAfterOptionSelected() {

    }
}
