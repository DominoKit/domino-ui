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
import org.dominokit.domino.ui.elements.DivElement;

/** Select class. */
public class Select<V> extends AbstractSelect<V, V, DivElement, SelectOption<V>, Select<V>> {

  private SelectOption<V> selectedOption;

  /**
   * create.
   *
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.Select} object
   */
  public static <V> Select<V> create() {
    return new Select<>();
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.Select} object
   */
  public static <V> Select<V> create(String label) {
    return new Select<>(label);
  }

  /** Constructor for Select. */
  public Select() {}

  /**
   * Constructor for Select.
   *
   * @param label a {@link java.lang.String} object
   */
  public Select(String label) {
    setLabel(label);
  }

  /**
   * doSetValue.
   *
   * @param value a V object
   */
  protected void doSetValue(V value) {
    findOptionByValue(value).ifPresent(this::onOptionSelected);
  }

  /**
   * doSetOption.
   *
   * @param option a {@link org.dominokit.domino.ui.forms.suggest.SelectOption} object
   */
  protected void doSetOption(SelectOption<V> option) {
    if (nonNull(this.selectedOption)) {
      this.selectedOption.remove();
    }
    this.selectedOption = option;
  }

  /** {@inheritDoc} */
  @Override
  protected void onOptionSelected(SelectOption<V> option) {
    if (nonNull(this.selectedOption)) {
      onOptionDeselected(this.selectedOption);
    }
    withOption(option);
    updateTextValue();
    this.selectedOption = option;
    fieldInput.appendChild(option);
  }

  /** {@inheritDoc} */
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

  /** {@inheritDoc} */
  @Override
  protected void onOptionDeselected(SelectOption<V> option) {
    option.remove();
    if (Objects.equals(this.selectedOption, option)) {
      this.selectedOption = null;
    }
    this.optionsMenu.withPauseSelectionListenersToggle(
        true,
        field -> {
          option.getMenuItem().deselect(true);
        });
  }

  /** {@inheritDoc} */
  @Override
  public V getValue() {
    if (nonNull(this.selectedOption)) {
      return this.selectedOption.getValue();
    }
    return null;
  }
}
