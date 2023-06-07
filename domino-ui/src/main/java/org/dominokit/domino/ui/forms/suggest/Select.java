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

import org.dominokit.domino.ui.elements.DivElement;

import java.util.Objects;

import static java.util.Objects.nonNull;

public class Select<V> extends AbstractSelect<V, V, DivElement, SelectOption<V>, Select<V>> {

    private SelectOption<V> selectedOption;

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
        findOptionByValue(value).ifPresent(this::onOptionSelected);
    }
    protected void doSetOption(SelectOption<V> option) {
        if(nonNull(this.selectedOption)) {
            this.selectedOption.remove();
        }
        this.selectedOption = option;
    }

    @Override
    protected void onOptionSelected(SelectOption<V> option) {
        withOption(option);
        updateTextValue();
        if(nonNull(this.selectedOption)){
            onOptionDeselected(this.selectedOption);
        }
        this.selectedOption = option;
        fieldInput.appendChild(option);
    }

    @Override
    public Select<V> withOption(SelectOption<V> option, boolean silent) {
                V oldValue = getValue();
        if (!Objects.equals(option.getValue(), oldValue)) {
            doSetOption(option);
            if (!silent) {
                triggerChangeListeners(oldValue, getValue());
            }
        }
        autoValidate();
        return this;
    }

    @Override
    protected void onOptionDeselected(SelectOption<V> option) {
        option.remove();
        if(Objects.equals(this.selectedOption, option)){
            this.selectedOption = null;
        }
        this.optionsMenu.withPauseSelectionListenersToggle(true, field -> {
            option.getMenuItem().deselect(true);
        });
    }

    @Override
    public V getValue() {
        if(nonNull(this.selectedOption)){
            return this.selectedOption.getValue();
        }
        return null;
    }
}
