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

/**
 * A multi-select suggestion box that allows users to select multiple options from a list of
 * suggestions.
 *
 * @param <V> The type of data associated with the selected options.
 * @param <E> The type of the suggest box's element.
 * @param <O> The type of the option within the suggest box.
 */
public class MultiSuggestBox<V, E extends IsElement<?>, O extends Option<V, E, O>>
    extends AbstractSuggestBox<V, List<V>, E, O, MultiSuggestBox<V, E, O>> {

  private List<O> selectedOptions = new ArrayList<>();

  /**
   * Creates a new MultiSuggestBox instance with the provided SuggestionsStore.
   *
   * @param <V> The type of data associated with the selected options.
   * @param <E> The type of the suggest box's element.
   * @param <O> The type of the option within the suggest box.
   * @param store The SuggestionsStore that provides suggestions for this multi-select suggest box.
   * @return A new instance of MultiSuggestBox.
   */
  public static <V, E extends IsElement<?>, O extends Option<V, E, O>>
      MultiSuggestBox<V, E, O> create(SuggestionsStore<V, E, O> store) {
    return new MultiSuggestBox<>(store);
  }

  /**
   * Creates a new MultiSuggestBox instance with a label and the provided SuggestionsStore.
   *
   * @param <V> The type of data associated with the selected options.
   * @param <E> The type of the suggest box's element.
   * @param <O> The type of the option within the suggest box.
   * @param label The label to display for the multi-select suggest box.
   * @param store The SuggestionsStore that provides suggestions for this multi-select suggest box.
   * @return A new instance of MultiSuggestBox.
   */
  public static <V, E extends IsElement<?>, O extends Option<V, E, O>>
      MultiSuggestBox<V, E, O> create(String label, SuggestionsStore<V, E, O> store) {
    return new MultiSuggestBox<>(label, store);
  }

  /**
   * Creates a new instance of MultiSuggestBox with the provided SuggestionsStore.
   *
   * @param store The SuggestionsStore that provides suggestions for this multi-select suggest box.
   */
  public MultiSuggestBox(SuggestionsStore<V, E, O> store) {
    super(store);
  }

  /**
   * Creates a new instance of MultiSuggestBox with a label and the provided SuggestionsStore.
   *
   * @param label The label to display for the multi-select suggest box.
   * @param store The SuggestionsStore that provides suggestions for this multi-select suggest box.
   */
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

  /**
   * Retrieves the currently selected values as a list.
   *
   * @return A list of selected values.
   */
  @Override
  public List<V> getValue() {
    return selectedOptions.stream().map(Option::getValue).collect(Collectors.toList());
  }

  /**
   * Handles the selection of a suggestion option.
   *
   * @param option The suggestion option that was selected.
   */
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

  /**
   * Adds a suggestion option to the multi-select suggest box.
   *
   * @param option The suggestion option to add.
   * @return The updated MultiSuggestBox instance.
   */
  public MultiSuggestBox<V, E, O> withOption(O option) {
    return withOption(option, isChangeListenersPaused());
  }

  /**
   * Adds a suggestion option to the multi-select suggest box.
   *
   * @param option The suggestion option to add.
   * @param silent Whether to trigger change listeners silently.
   * @return The updated MultiSuggestBox instance.
   */
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

  /**
   * Sets the selected options for the multi-select suggest box.
   *
   * @param option The suggestion option to add.
   */
  private void doSetOption(O option) {
    if (isNull(this.selectedOptions)) {
      this.selectedOptions = new ArrayList<>();
    }
    this.selectedOptions.add(option);
  }

  /**
   * Handles the deselection of a suggestion option.
   *
   * @param option The suggestion option that was deselected.
   */
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

  /** Handles the "Backspace" key event. */
  @Override
  protected void onBackspace() {
    if (!selectedOptions.isEmpty()) {
      O option = selectedOptions.get(selectedOptions.size() - 1);
      onOptionDeselected(option);
      selectedOptions.remove(option);
    }
  }

  /**
   * Clears the value of the multi-select suggest box.
   *
   * @param silent Whether to clear the value silently.
   * @return The updated MultiSuggestBox instance.
   */
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

  /**
   * Retrieves the string representation of the selected values.
   *
   * @return A comma-separated string of selected values.
   */
  @Override
  public String getStringValue() {
    if (nonNull(this.selectedOptions) && !this.selectedOptions.isEmpty()) {
      return this.selectedOptions.stream()
          .map(o -> String.valueOf(o.getValue()))
          .collect(Collectors.joining(","));
    }
    return null;
  }

  /** Handles actions to be performed after an option is selected. */
  @Override
  protected void onAfterOptionSelected() {
    getInputElement().element().value = null;
  }
}
