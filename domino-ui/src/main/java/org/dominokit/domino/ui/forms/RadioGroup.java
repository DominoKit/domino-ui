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
 * Represents a group of radio buttons, ensuring that only one radio button in the group can be
 * selected at a time.
 *
 * <p>This implementation guarantees that radio buttons belonging to the same group have the same
 * name attribute. It provides an API for managing the radio buttons as a group and ensures that
 * selecting one radio deselects others in the same group.
 *
 * @param <T> The type of the value associated with the radio buttons in the group.
 */
public class RadioGroup<T> extends AbstractFormElement<RadioGroup<T>, T> {

  /** List of radio buttons that are part of this group. */
  private List<Radio<? extends T>> radios = new ArrayList<>();

  /** The name attribute shared by all radio buttons in this group. */
  private String name;

  /**
   * Constructs a radio group with the given name. This name will be set as the name attribute of
   * each radio button in the group.
   *
   * @param name The name attribute for the radio group.
   */
  public RadioGroup(String name) {
    init(this);
    addCss(dui_form_radio_group);
    setName(name);
  }

  /**
   * Constructs a radio group with the given name and label. This name will be set as the name
   * attribute of each radio button in the group.
   *
   * @param name The name attribute for the radio group.
   * @param label The label for the radio group.
   */
  public RadioGroup(String name, String label) {
    this(name);
    setLabel(label);
  }

  /**
   * Factory method to create a new RadioGroup with the specified name.
   *
   * @param <T> The type of the value associated with the radio buttons in the group.
   * @param name The name attribute for the radio group.
   * @return A new instance of RadioGroup.
   */
  public static <T> RadioGroup<T> create(String name) {
    return new RadioGroup<>(name);
  }

  /**
   * Factory method to create a new RadioGroup with the specified name and label.
   *
   * @param <T> The type of the value associated with the radio buttons in the group.
   * @param name The name attribute for the radio group.
   * @param label The label for the radio group.
   * @return A new instance of RadioGroup.
   */
  public static <T> RadioGroup<T> create(String name, String label) {
    return new RadioGroup<>(name, label);
  }

  /**
   * Configures the gap style for the radio group. When set to true, the radio group will have gaps
   * between the radio border and the selected indicator circle at the middle.
   *
   * @param withGap A boolean flag indicating whether to add gaps between radio the radio border and
   *     the selected indicator circle at the middle.
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> withGap(boolean withGap) {
    addCss(BooleanCssClass.of(dui_form_radio_group_gap, withGap));
    return this;
  }

  /**
   * Appends a radio button to the group, setting its name to match the group's name, and making
   * sure only one radio button is checked at a time.
   *
   * @param radio The {@link Radio} to be appended to the group.
   * @return The instance of the {@link RadioGroup}.
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
   * Removes a specified radio button from the group. The radio button will be unchecked and removed
   * from the DOM.
   *
   * @param radio The {@link Radio} to be removed.
   * @param silent A boolean flag indicating if the uncheck action should trigger events.
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> removeRadio(Radio<? extends T> radio, boolean silent) {
    if (radios.remove(radio)) {
      radio.uncheck(silent);
      radio.remove();
    }
    return this;
  }

  /**
   * Removes all radio buttons from the group.
   *
   * @param silent A boolean flag indicating if the uncheck action for each radio should trigger
   *     events.
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> removeAllRadios(boolean silent) {
    new ArrayList<>(radios).forEach(radio -> removeRadio(radio, silent));
    radios.clear();
    return this;
  }

  /**
   * Clears the selection of the radio group. If a default value is set, the radio button with the
   * matching value will be checked, otherwise, the first radio button in the group will be checked.
   *
   * @param silent A boolean flag indicating if the check action should trigger events.
   * @return The instance of the {@link RadioGroup}.
   */
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

  /**
   * Selects the first radio button in the group. Triggers the clear listeners if the silent flag is
   * set to false.
   *
   * @param silent A boolean flag indicating if the check action should trigger events.
   */
  private void selectFirst(boolean silent) {
    T oldValue = getValue();
    radios.get(0).check(silent);
    if (!silent) {
      triggerClearListeners(oldValue);
    }
  }

  /**
   * Notifies all registered change listeners about a value change in the group.
   *
   * @param oldValue The old value of the group before the change.
   * @param newValue The new value of the group after the change.
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> triggerChangeListeners(T oldValue, T newValue) {
    changeListeners.forEach(changeListener -> changeListener.onValueChanged(oldValue, newValue));
    return this;
  }

  /**
   * Notifies all registered clear listeners about a value clear in the group.
   *
   * @param oldValue The old value of the group before the clear action.
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> triggerClearListeners(T oldValue) {
    clearListeners.forEach(clearListener -> clearListener.onValueCleared(oldValue));
    return this;
  }

  /**
   * Retrieves the type of the form element.
   *
   * @return A string representation of the form element type, which is "RadioGroup".
   */
  @Override
  public String getType() {
    return "RadioGroup";
  }

  /**
   * Sets the value of the radio group to the specified value, and checks the corresponding radio
   * button with that value. The change listeners will be triggered if they are not paused.
   *
   * @param value The value to set for the radio group.
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> withValue(T value) {
    return withValue(value, isChangeListenersPaused());
  }

  /**
   * Sets the value of the radio group to the specified value, and checks the corresponding radio
   * button with that value.
   *
   * @param value The value to set for the radio group.
   * @param silent A boolean flag indicating if the check action should trigger events.
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> withValue(T value, boolean silent) {
    radios.stream()
        .filter(radio -> Objects.equals(value, radio.getValue()))
        .findFirst()
        .ifPresent(radio -> radio.check(silent));
    return this;
  }

  /**
   * Sets the layout of the radio buttons in the group to be vertical.
   *
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> vertical() {
    return vertical(true);
  }

  /**
   * Sets the layout of the radio buttons in the group to be horizontal.
   *
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> horizontal() {
    return vertical(false);
  }

  /**
   * Toggles the layout of the radio buttons in the group based on the vertical parameter.
   *
   * @param vertical A boolean indicating if the radio buttons should be arranged vertically.
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> vertical(boolean vertical) {
    addCss(BooleanCssClass.of(dui_form_radio_group_vertical, vertical));
    return this;
  }

  /**
   * Retrieves the list of radio buttons that belong to the group.
   *
   * @return A list of radio buttons.
   */
  public List<Radio<? extends T>> getRadios() {
    return radios;
  }

  /**
   * Allows manipulation of the list of radio buttons that belong to the group.
   *
   * @param handler A handler to apply changes to the list of radio buttons.
   * @return The instance of the {@link RadioGroup}.
   */
  public RadioGroup<T> withRadios(ChildHandler<RadioGroup<T>, List<Radio<? extends T>>> handler) {
    handler.apply(this, getRadios());
    return this;
  }

  /**
   * Checks if any radio button in the group is selected.
   *
   * @return A boolean indicating if a radio button is selected.
   */
  public boolean isSelected() {
    return getValue() != null;
  }

  /**
   * Retrieves the value of the selected radio button from the group.
   *
   * @return The value of the selected radio button, or null if no button is selected.
   */
  public T getValue() {
    return radios.stream().filter(Radio::isChecked).map(Radio::getValue).findFirst().orElse(null);
  }

  /**
   * Checks if the radio group has no selected value.
   *
   * @return {@code true} if the group has no selected radio button, otherwise {@code false}.
   */
  @Override
  public boolean isEmpty() {
    return !isSelected();
  }

  /**
   * Checks if the radio group has no selected value, ignoring any spaces. This is functionally
   * identical to {@link #isEmpty()} for radio groups.
   *
   * @return {@code true} if the group has no selected radio button, otherwise {@code false}.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * Clears any selected value in the radio group.
   *
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> clear() {
    return clear(isClearListenersPaused());
  }

  /**
   * Retrieves the name attribute of the radio group.
   *
   * @return The name attribute of the radio group.
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * Sets the name attribute for the radio group and all its radio buttons.
   *
   * @param name The new name attribute to set.
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> setName(String name) {
    this.name = name;
    radios.forEach(radio -> radio.setName(name));
    return this;
  }

  /**
   * Enables all radio buttons within the radio group.
   *
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> enable() {
    radios.forEach(Radio::enable);
    return super.enable();
  }

  /**
   * Disables all radio buttons within the radio group.
   *
   * @return The instance of the {@link RadioGroup}.
   */
  @Override
  public RadioGroup<T> disable() {
    radios.forEach(Radio::disable);
    return super.disable();
  }

  /**
   * Checks if the radio group and all its radio buttons are enabled.
   *
   * @return {@code true} if all radio buttons are enabled, otherwise {@code false}.
   */
  @Override
  public boolean isEnabled() {
    return !formElement.isDisabled() && radios.stream().allMatch(Radio::isEnabled);
  }

  /**
   * Sets the value for the radio group. This will check the radio button that has the specified
   * value.
   *
   * @param value The value to be set.
   */
  public void setValue(Radio<T> value) {
    if (value == null) {
      clear(isClearListenersPaused());
    } else {
      setValue(value.getValue());
    }
  }

  @Override
  public void setValue(T value) {
    setValue(value, isChangeListenersPaused());
  }

  /**
   * Sets the value for the radio group, with an option to silence any change listeners. This will
   * check the radio button that matches the specified value.
   *
   * @param value The value to be set.
   * @param silent If true, change listeners will not be notified.
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
   * Retrieves the currently selected radio from the group. This is the implementation detail and is
   * meant for internal use.
   *
   * @return An optional containing the selected radio, or empty if none is selected.
   */
  protected Optional<Radio<? extends T>> getSelectedRadioImpl() {
    return radios.stream().filter(Radio::isChecked).findFirst();
  }

  /**
   * Gets the radio button that is currently selected in the group.
   *
   * @return The selected radio button, or {@code null} if none is selected.
   */
  public Radio<? extends T> getSelectedRadio() {
    return getSelectedRadioImpl().orElse(null);
  }

  /**
   * Creates an auto validator for the radio group. The auto validator will automatically validate
   * the radio group based on the provided function.
   *
   * @param autoValidate A function to apply the auto-validation logic.
   * @return An instance of {@link AutoValidator} for the radio group.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new RadioAutoValidator(this, autoValidate);
  }

  /**
   * Notifies change listeners when a radio button selection has changed.
   *
   * @param oldValue The previous selected value.
   * @param selectedRadio The radio button that was just selected.
   * @param silent If true, change listeners will not be notified.
   */
  void onSelectionChanged(T oldValue, Radio<? extends T> selectedRadio, boolean silent) {
    if (!silent) {
      changeListeners.forEach(
          listener -> listener.onValueChanged(oldValue, selectedRadio.getValue()));
    }
  }

  /**
   * An automatic validator for {@link RadioGroup}. This class will handle the attachment of
   * validation to the individual radio buttons within the group. Whenever a radio button's state
   * changes, the specified validation logic is triggered.
   *
   * @param <T> The type of the value represented by the radio buttons in the group.
   */
  private static class RadioAutoValidator<T> extends AutoValidator {

    /** The radio group associated with this auto validator. */
    private RadioGroup<T> radioGroup;

    /** A listener that triggers validation whenever a radio button's state changes. */
    private ChangeListener<Boolean> changeListener;

    /**
     * Constructs a new auto validator for a given radio group.
     *
     * @param radioGroup The radio group to validate.
     * @param autoValidate A function that represents the validation logic to be applied.
     */
    public RadioAutoValidator(RadioGroup<T> radioGroup, ApplyFunction autoValidate) {
      super(autoValidate);
      this.radioGroup = radioGroup;
    }

    /**
     * Attaches the validation logic to each radio button in the group. Once attached, any change to
     * a radio button's state will trigger validation.
     */
    @Override
    public void attach() {
      changeListener = (oldValue, newValue) -> autoValidate.apply();
      radioGroup.getRadios().forEach(radio -> radio.addChangeListener(changeListener));
    }

    /** Removes the validation logic from each radio button in the group. */
    @Override
    public void remove() {
      radioGroup.getRadios().forEach(radio -> radio.removeChangeListener(changeListener));
    }
  }
}
