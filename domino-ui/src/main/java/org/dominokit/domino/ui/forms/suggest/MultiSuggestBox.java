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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.IsElement;

public class MultiSuggestBox<V, E extends IsElement<?>, O extends Option<V, E, O>>
    extends AbstractSuggestBox<V, List<V>, E, O, MultiSuggestBox<V, E, O>> {

  private List<O> selectedOptions = new ArrayList<>();

  public static <V, E extends IsElement<?>, O extends Option<V, E, O>>
      MultiSuggestBox<V, E, O> create(SuggestionsStore<V, E, O> store) {
    return new MultiSuggestBox<>(store);
  }

  public static <V, E extends IsElement<?>, O extends Option<V, E, O>>
      MultiSuggestBox<V, E, O> create(String label, SuggestionsStore<V, E, O> store) {
    return new MultiSuggestBox<>(label, store);
  }

  public MultiSuggestBox(SuggestionsStore<V, E, O> store) {
    super(store);
  }

  public MultiSuggestBox(String label, SuggestionsStore<V, E, O> store) {
    super(store);
    setLabel(label);
  }

  @Override
  protected void doSetValue(List<V> values) {
    clearValue(false);
    values.forEach(
        v -> {
          store.find(v, this::applyOptionValue);
        });
  }

  @Override
  public List<V> getValue() {
    return selectedOptions.stream().map(Option::getValue).collect(Collectors.toList());
  }

  @Override
  public void onOptionSelected(O option) {
    if (nonNull(this.selectedOptions) && this.selectedOptions.contains(option)) {
      return;
    }
    withOption(option);
    fieldInput.appendChild(option);
    selectedOptions.add(option);
    option.bindTo(this);
  }

  public MultiSuggestBox<V, E, O> withOption(O option) {
    return withOption(option, isChangeListenersPaused());
  }

  public MultiSuggestBox<V, E, O> withOption(O option, boolean silent) {
    List<V> oldValue = getValue();
    if (isNull(oldValue) || !oldValue.contains(option.getValue())) {
      doSetOption(option);
      if (!silent) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    return this;
  }

  private void doSetOption(O option) {
    if (isNull(this.selectedOptions)) {
      this.selectedOptions = new ArrayList<>();
    }
    this.selectedOptions.add(option);
  }

  @Override
  public void onOptionDeselected(O option) {
    List<V> oldValue = getValue();
    if (nonNull(oldValue) && oldValue.contains(option.getValue())) {
      option.remove();
      this.selectedOptions.remove(option);
      this.optionsMenu.withPauseSelectionListenersToggle(
          true,
          field -> {
            option.getMenuItem().deselect(true);
          });
      if (!isChangeListenersPaused()) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    option.unbindTarget();
  }

  @Override
  protected void onBackspace() {
    if (!selectedOptions.isEmpty()) {
      O option = selectedOptions.get(selectedOptions.size() - 1);
      onOptionDeselected(option);
      selectedOptions.remove(option);
    }
  }

  @Override
  protected MultiSuggestBox<V, E, O> clearValue(boolean silent) {
    if (!selectedOptions.isEmpty()) {
      List<V> oldValue = getValue();
      optionsMenu.withPauseSelectionListenersToggle(
          true, field -> new ArrayList<>(selectedOptions).forEach(this::onOptionDeselected));

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
    if (nonNull(this.selectedOptions) && !this.selectedOptions.isEmpty()) {
      return this.selectedOptions.stream()
          .map(o -> String.valueOf(o.getValue()))
          .collect(Collectors.joining(","));
    }
    return null;
  }

  @Override
  protected void onAfterOptionSelected() {
    getInputElement().element().value = null;
  }
}
