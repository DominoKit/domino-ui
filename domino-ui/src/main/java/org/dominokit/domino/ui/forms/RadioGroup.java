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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.forms.FormsStyles.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * A component to group a set of {@link org.dominokit.domino.ui.forms.Radio} component as one field,
 * only one Radio can be checked from this radio group.
 *
 * @param <T> The type of the RadioGroup value
 * @author vegegoku
 * @version $Id: $Id
 */
public class RadioGroup<T> extends AbstractFormElement<RadioGroup<T>, T> {

  private List<Radio<? extends T>> radios = new ArrayList<>();

  private String name;

  /**
   * Creates a new group with a name and empty label
   *
   * @param name String
   */
  public RadioGroup(String name) {
    init(this);
    addCss(dui_form_radio_group);
    setName(name);
  }

  /**
   * Creates a new group with a name and a label
   *
   * @param name String
   * @param label String
   */
  public RadioGroup(String name, String label) {
    this(name);
    setLabel(label);
  }

  /**
   * Creates a new group with a name and empty label
   *
   * @param name String
   * @param <T> type of the RadioGroup value
   * @return new RadioGroup instance
   */
  public static <T> RadioGroup<T> create(String name) {
    return new RadioGroup<>(name);
  }

  /**
   * Creates a new group with a name and a label
   *
   * @param name String
   * @param label String
   * @param <T> type of the RadioGroup value
   * @return new RadioGroup instance
   */
  public static <T> RadioGroup<T> create(String name, String label) {
    return new RadioGroup<>(name, label);
  }

  /**
   * withGap.
   *
   * @param withGap a boolean
   * @return a {@link org.dominokit.domino.ui.forms.RadioGroup} object
   */
  public RadioGroup<T> withGap(boolean withGap) {
    addCss(BooleanCssClass.of(dui_form_radio_group_gap, withGap));
    return this;
  }
  /**
   * appendChild.
   *
   * @param radio {@link org.dominokit.domino.ui.forms.Radio}
   * @return same RadioGroup instance
   */
  public RadioGroup<T> appendChild(Radio<? extends T> radio) {
    wrapperElement.appendChild(radio);
    radio.setName(getName());
    radio.setGroup(this);
    if (radio.isChecked()) {
      radios.forEach(r -> r.uncheck(true));
    }
    radios.add(radio);
    return this;
  }

  /**
   * removeRadio.
   *
   * @param radio a {@link org.dominokit.domino.ui.forms.Radio} object
   * @param silent a boolean
   * @return a {@link org.dominokit.domino.ui.forms.RadioGroup} object
   */
  public RadioGroup<T> removeRadio(Radio<? extends T> radio, boolean silent) {
    if (radios.remove(radio)) {
      radio.uncheck(silent);
      radio.remove();
    }
    return this;
  }

  /**
   * removeAllRadios.
   *
   * @param silent a boolean
   * @return a {@link org.dominokit.domino.ui.forms.RadioGroup} object
   */
  public RadioGroup<T> removeAllRadios(boolean silent) {
    new ArrayList<>(radios).forEach(radio -> removeRadio(radio, silent));
    radios.clear();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> clear(boolean silent) {
    if (radios.isEmpty()) {
      return this;
    }

    if (nonNull(defaultValue)) {
      Optional<Radio<? extends T>> first =
          radios.stream()
              .filter(radio -> Objects.equals(defaultValue, radio.getValue()))
              .findFirst();
      if (first.isPresent()) {
        T oldValue = getValue();
        first.get().check(silent);
        if (!silent) {
          triggerClearListeners(oldValue);
        }
      } else {
        selectFirst(silent);
      }

    } else {
      radios.get(0).check(silent);
    }
    return this;
  }

  private void selectFirst(boolean silent) {
    T oldValue = getValue();
    radios.get(0).check(silent);
    if (!silent) {
      triggerClearListeners(oldValue);
    }
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> triggerChangeListeners(T oldValue, T newValue) {
    changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> triggerClearListeners(T oldValue) {
    clearListeners.forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "RadioGroup";
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> withValue(T value) {
    return withValue(value, isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> withValue(T value, boolean silent) {
    radios.stream()
        .filter(radio -> Objects.equals(value, radio.getValue()))
        .findFirst()
        .ifPresent(radio -> radio.check(silent));
    return this;
  }

  /**
   * Aligns the radios in this group vertically
   *
   * @return same RadioGroup instance
   */
  public RadioGroup<T> vertical() {
    return vertical(true);
  }

  /**
   * Aligns the radios in this group horizontal
   *
   * @return same RadioGroup instance
   */
  public RadioGroup<T> horizontal() {
    return vertical(false);
  }

  /**
   * Aligns the radios in this group vertically
   *
   * @return same RadioGroup instance
   * @param vertical a boolean
   */
  public RadioGroup<T> vertical(boolean vertical) {
    addCss(BooleanCssClass.of(dui_form_radio_group_vertical, vertical));
    return this;
  }

  /** @return List of {@link Radio} that belongs to this RadioGroup */
  /**
   * Getter for the field <code>radios</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<Radio<? extends T>> getRadios() {
    return radios;
  }

  /**
   * Apply a function on the current Radio group radio buttons
   *
   * @return same radio group instance
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   */
  public RadioGroup<T> withRadios(ChildHandler<RadioGroup<T>, List<Radio<? extends T>>> handler) {
    handler.apply(this, getRadios());
    return this;
  }

  /** @return boolean, true only if there is a checked radio in this RadioGroup */
  /**
   * isSelected.
   *
   * @return a boolean
   */
  public boolean isSelected() {
    return getValue() != null;
  }

  /** @return T value of the first checked Radio in this RadioGroup */
  /**
   * getValue.
   *
   * @return a T object
   */
  public T getValue() {
    return radios.stream().filter(Radio::isChecked).map(Radio::getValue).findFirst().orElse(null);
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    return !isSelected();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> clear() {
    return clear(isClearListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return name;
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> setName(String name) {
    this.name = name;
    radios.forEach(radio -> radio.setName(name));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> enable() {
    radios.forEach(Radio::enable);
    return super.enable();
  }

  /** {@inheritDoc} */
  @Override
  public RadioGroup<T> disable() {
    radios.forEach(Radio::disable);
    return super.disable();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !formElement.isDisabled() && radios.stream().allMatch(Radio::isEnabled);
  }

  /**
   * Sets the value from the specific Radio. When the radio self is null, clearValue will be
   * executed.
   *
   * @param value {@link org.dominokit.domino.ui.forms.Radio}
   */
  public void setValue(Radio<T> value) {
    if (value == null) {
      clear(isClearListenersPaused());
    } else {
      setValue(value.getValue());
    }
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(T value) {
    setValue(value, isChangeListenersPaused());
  }

  /**
   * {@inheritDoc}
   *
   * @param value a T object
   * @param silent a boolean
   */
  public void setValue(T value, boolean silent) {
    radios.stream()
        .filter(radio -> radio.getValue().equals(value))
        .findFirst()
        .ifPresent(
            radio -> {
              T oldValue = getValue();
              radio.check();
              if (!silent) {
                triggerChangeListeners(oldValue, getValue());
              }
            });
  }

  /**
   * getSelectedRadioImpl.
   *
   * @return a {@link java.util.Optional} object
   */
  protected Optional<Radio<? extends T>> getSelectedRadioImpl() {
    return radios.stream().filter(Radio::isChecked).findFirst();
  }

  /** @return the checked {@link Radio} */
  /**
   * getSelectedRadio.
   *
   * @return a {@link org.dominokit.domino.ui.forms.Radio} object
   */
  public Radio<? extends T> getSelectedRadio() {
    return getSelectedRadioImpl().orElse(null);
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new RadioAutoValidator(this, autoValidate);
  }

  void onSelectionChanged(T oldValue, Radio<? extends T> selectedRadio, boolean silent) {
    if (!silent) {
      changeListeners.forEach(
          listener -> listener.onValueChanged(oldValue, selectedRadio.getValue()));
    }
  }

  private static class RadioAutoValidator<T> extends AutoValidator {

    private RadioGroup<T> radioGroup;
    private ChangeListener<Boolean> changeListener;

    public RadioAutoValidator(RadioGroup<T> radioGroup, ApplyFunction autoValidate) {
      super(autoValidate);
      this.radioGroup = radioGroup;
    }

    @Override
    public void attach() {
      changeListener = (oldValue, newValue) -> autoValidate.apply();
      radioGroup.getRadios().forEach(radio -> radio.addChangeListener(changeListener));
    }

    @Override
    public void remove() {
      radioGroup.getRadios().forEach(radio -> radio.removeChangeListener(changeListener));
    }
  }
}
