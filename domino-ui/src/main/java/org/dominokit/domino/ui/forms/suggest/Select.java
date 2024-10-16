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

import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.elements.DivElement;

/**
 * Represents a dropdown select control allowing the user to choose a single option from a list.
 *
 * <p><b>Usage example:</b>
 *
 * <pre>
 * Select&lt;String&gt; fruitSelect = Select.create("Choose a fruit");
 * fruitSelect.withOption(new SelectOption&lt;&gt;("Apple"), false);
 * fruitSelect.withOption(new SelectOption&lt;&gt;("Banana"), false);
 * </pre>
 *
 * @param <V> The type of value associated with each select option.
 * @see AbstractSelect
 */
public class Select<V> extends AbstractSelect<V, V, DivElement, SelectOption<V>, Select<V>> {

  private SelectOption<V> selectedOption;

  /**
   * Creates a new instance of {@link Select} without a label.
   *
   * @param <V> the type of value for the select options
   * @return a new instance of {@link Select}
   */
  public static <V> Select<V> create() {
    return new Select<>();
  }

  /**
   * Creates a new instance of {@link Select} with a specified label.
   *
   * @param label The label to be set for the select control.
   * @param <V> the type of value for the select options
   * @return a new instance of {@link Select} with the specified label.
   */
  public static <V> Select<V> create(String label) {
    return new Select<>(label);
  }

  /** Default constructor creating a {@link Select} instance without a label. */
  public Select() {}

  /**
   * Constructor to create a {@link Select} instance with the specified label.
   *
   * @param label The label to be set for the select control.
   */
  public Select(String label) {
    setLabel(label);
  }

  protected void doSetValue(V value, boolean silent) {
    Optional<SelectOption<V>> option = findOptionByValue(value);
    if (option.isPresent()) {
      onOptionSelected(option.get(), silent);
    } else {
      if (isNull(value)) {
        clearValue(silent);
      }
    }
  }

  @Override
  protected Select<V> clearValue(boolean silent) {
    Select<V> thisSelect = super.clearValue(silent);
    this.selectedOption = null;
    return thisSelect;
  }

  protected void doSetOption(SelectOption<V> option) {
    if (nonNull(this.selectedOption)) {
      this.selectedOption.remove();
    }
    this.selectedOption = option;
    if (nonNull(selectedOption)) {
      optionsMenu.select(selectedOption.getMenuItem(), true);
    }
  }

  @Override
  protected void onOptionSelected(SelectOption<V> option, boolean silent) {
    if (nonNull(this.selectedOption)) {
      onOptionDeselected(this.selectedOption, silent);
    }
    withOption(option, silent);
  }

  /**
   * Adds an option to the {@link Select} dropdown. If the option value is different from the
   * current selected value, it updates the selected option.
   *
   * @param option The option to be added.
   * @param silent If true, does not trigger change listeners after setting the option.
   * @return The current {@link Select} instance.
   */
  @Override
  public Select<V> withOption(SelectOption<V> option, boolean silent) {
    V oldValue = getValue();
    if (!Objects.equals(option.getValue(), oldValue) || isNull(oldValue)) {
      doSetOption(option);

      updateTextValue();
      this.selectedOption = option;
      fieldInput.appendChild(option);

      if (!silent) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
    autoValidate();
    getInputElement().element().focus();
    return this;
  }

  @Override
  protected void onOptionDeselected(SelectOption<V> option, boolean silent) {
    option.remove();
    option.getComponent().remove();
    this.optionsMenu.withPauseSelectionListenersToggle(
        true,
        field -> {
          option.getMenuItem().deselect(true);
        });
  }

  /**
   * Retrieves the value of the currently selected option.
   *
   * @return the value of the currently selected option or {@code null} if no option is selected.
   */
  @Override
  public V getValue() {
    if (nonNull(this.selectedOption) && this.selectedOption.getMenuItem().isSelected()) {
      return this.selectedOption.getValue();
    }
    return null;
  }
}
