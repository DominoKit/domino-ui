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

import static java.util.Objects.nonNull;

import java.util.Objects;
import org.dominokit.domino.ui.IsElement;

/**
 * A single-select suggestion box that allows users to select an option from a list of suggestions.
 *
 * @param <V> The type of data associated with the selected option.
 * @param <E> The type of the suggest box's element.
 * @param <O> The type of the option within the suggest box.
 */
public class SuggestBox<V, E extends IsElement<?>, O extends Option<V, E, O>>
    extends AbstractSuggestBox<V, V, E, O, SuggestBox<V, E, O>> {

  private O selectedOption;

  /**
   * Creates a new instance of SuggestBox with the provided SuggestionsStore.
   *
   * @param store The SuggestionsStore that provides suggestions for this single-select suggest box.
   * @return A new instance of SuggestBox.
   */
  public static <V, E extends IsElement<?>, O extends Option<V, E, O>> SuggestBox<V, E, O> create(
      SuggestionsStore<V, E, O> store) {
    return new SuggestBox<>(store);
  }

  /**
   * Creates a new instance of SuggestBox with a label and the provided SuggestionsStore.
   *
   * @param label The label to display for the single-select suggest box.
   * @param store The SuggestionsStore that provides suggestions for this single-select suggest box.
   * @return A new instance of SuggestBox.
   */
  public static <V, E extends IsElement<?>, O extends Option<V, E, O>> SuggestBox<V, E, O> create(
      String label, SuggestionsStore<V, E, O> store) {
    return new SuggestBox<>(label, store);
  }

  /**
   * Creates a new instance of SuggestBox with the provided SuggestionsStore.
   *
   * @param store The SuggestionsStore that provides suggestions for this single-select suggest box.
   */
  public SuggestBox(SuggestionsStore<V, E, O> store) {
    super(store);
  }

  /**
   * Creates a new instance of SuggestBox with a label and the provided SuggestionsStore.
   *
   * @param label The label to display for the single-select suggest box.
   * @param store The SuggestionsStore that provides suggestions for this single-select suggest box.
   */
  public SuggestBox(String label, SuggestionsStore<V, E, O> store) {
    super(store);
    setLabel(label);
  }

  /**
   * Sets the selected value for the single-select suggest box.
   *
   * @param value The value to set as the selected option.
   */
  @Override
  protected void doSetValue(V value) {
    store.find(value, this::applyOptionValue);
  }

  /**
   * Retrieves the currently selected value.
   *
   * @return The selected value.
   */
  @Override
  public V getValue() {
    if (nonNull(selectedOption)) {
      return selectedOption.getValue();
    }
    return null;
  }

  /** Handles the "Backspace" key event. */
  @Override
  protected void onBackspace() {
    clearValue(isChangeListenersPaused());
  }

  /**
   * Handles the selection of a suggestion option.
   *
   * @param option The suggestion option that was selected.
   */
  @Override
  public void onOptionSelected(O option) {
    withOption(option);
    updateTextValue();
    if (nonNull(this.selectedOption)) {
      onOptionDeselected(this.selectedOption);
    }
    this.selectedOption = option;
  }

  /**
   * Adds a suggestion option to the single-select suggest box.
   *
   * @param option The suggestion option to add.
   * @return The updated SuggestBox instance.
   */
  public SuggestBox<V, E, O> withOption(O option) {
    return withOption(option, isChangeListenersPaused());
  }

  /**
   * Adds a suggestion option to the single-select suggest box.
   *
   * @param option The suggestion option to add.
   * @param silent Whether to trigger change listeners silently.
   * @return The updated SuggestBox instance.
   */
  public SuggestBox<V, E, O> withOption(O option, boolean silent) {
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

  /** Updates the text value of the input element. */
  private void updateTextValue() {
    getInputElement().element().value = getStringValue();
  }

  /**
   * Handles the deselection of a suggestion option.
   *
   * @param option The suggestion option that was deselected.
   */
  @Override
  public void onOptionDeselected(O option) {
    option.remove();
    V oldValue = this.selectedOption.getValue();
    if (Objects.equals(this.selectedOption, option)) {
      this.selectedOption = null;
    }
    this.optionsMenu.withPauseSelectionListenersToggle(
        true,
        field -> {
          option.getMenuItem().deselect(true);
        });
  }

  /**
   * Clears the value of the single-select suggest box.
   *
   * @param silent Whether to clear the value silently.
   * @return The updated SuggestBox instance.
   */
  @Override
  protected SuggestBox<V, E, O> clearValue(boolean silent) {
    if (nonNull(selectedOption)) {
      V oldValue = getValue();
      withPauseChangeListenersToggle(
          true,
          field -> {
            onOptionDeselected(selectedOption);
            getInputElement().element().value = null;
          });
      if (!silent) {
        triggerClearListeners(oldValue);
        triggerChangeListeners(oldValue, getValue());
      }

      if (isAutoValidation()) {
        autoValidate();
      }
    } else {
      withPauseChangeListenersToggle(true, field -> getInputElement().element().value = null);
    }

    return this;
  }

  /**
   * Retrieves the string representation of the selected value.
   *
   * @return The string representation of the selected value.
   */
  @Override
  public String getStringValue() {
    if (nonNull(this.selectedOption)) {
      return String.valueOf(this.selectedOption.getValue());
    }
    return getInputElement().element().value;
  }

  /** Handles actions to be performed after an option is selected. */
  @Override
  protected void onAfterOptionSelected() {}
}
