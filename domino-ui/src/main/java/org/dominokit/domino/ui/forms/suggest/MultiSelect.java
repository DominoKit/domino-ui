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

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.DivElement;

/**
 * MultiSelect class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class MultiSelect<V>
    extends AbstractSelect<V, List<V>, DivElement, SelectOption<V>, MultiSelect<V>> {

  private Set<SelectOption<V>> selectedOptions = new HashSet<>();

  /**
   * create.
   *
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.MultiSelect} object
   */
  public static <V> MultiSelect<V> create() {
    return new MultiSelect<>();
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.forms.suggest.MultiSelect} object
   */
  public static <V> MultiSelect<V> create(String label) {
    return new MultiSelect<>(label);
  }

  /** Constructor for MultiSelect. */
  public MultiSelect() {
    optionsMenu.setMultiSelect(true);
  }

  /**
   * Constructor for MultiSelect.
   *
   * @param label a {@link java.lang.String} object
   */
  public MultiSelect(String label) {
    this();
    setLabel(label);
  }

  /** {@inheritDoc} */
  @Override
  protected List<V> asValue(V singleValue) {
    return Arrays.asList(singleValue);
  }

  /**
   * withValue.
   *
   * @param value a V object
   * @return a {@link org.dominokit.domino.ui.forms.suggest.MultiSelect} object
   */
  public MultiSelect<V> withValue(V... value) {
    return withValue(isChangeListenersPaused(), value);
  }

  /**
   * withValue.
   *
   * @param silent a boolean
   * @param value a V object
   * @return a {@link org.dominokit.domino.ui.forms.suggest.MultiSelect} object
   */
  public MultiSelect<V> withValue(boolean silent, V... value) {
    return withValue(Arrays.asList(value), silent);
  }

  /**
   * doSetValue.
   *
   * @param value a {@link java.util.List} object
   */
  protected void doSetValue(List<V> value) {
    withPauseChangeListenersToggle(
        true,
        field ->
            value.forEach(
                v -> {
                  Optional<SelectOption<V>> optionByValue = findOptionByValue(v);
                  optionByValue.ifPresent(this::onOptionSelected);
                }));
  }

  /** {@inheritDoc} */
  @Override
  protected void onOptionSelected(SelectOption<V> option) {
    if (nonNull(this.selectedOptions) && this.selectedOptions.contains(option)) {
      return;
    }
    withOption(option);
    updateTextValue();
    fieldInput.appendChild(option);
    selectedOptions.add(option);
  }

  /** {@inheritDoc} */
  @Override
  public MultiSelect<V> withOption(SelectOption<V> option, boolean silent) {
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

  /** {@inheritDoc} */
  @Override
  protected void onOptionDeselected(SelectOption<V> option) {
    List<V> oldValue = getValue();
    if (nonNull(oldValue) && oldValue.contains(option.getValue())) {
      selectedOptions.remove(option);
      option.remove();
      if (!isChangeListenersPaused()) {
        triggerChangeListeners(oldValue, getValue());
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetOption(SelectOption<V> option) {
    if (isNull(this.selectedOptions)) {
      this.selectedOptions = new HashSet<>();
    }
    this.selectedOptions.add(option);
  }

  /** {@inheritDoc} */
  @Override
  public List<V> getValue() {
    return this.selectedOptions.stream().map(Option::getValue).collect(Collectors.toList());
  }
}
