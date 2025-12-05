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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLInputElement;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * A customizable SwitchButton component.
 *
 * <p>This component provides a switchable button that can be toggled between ON and OFF states.
 *
 * <pre>
 * Usage:
 * SwitchButton button = SwitchButton.create("Label", "Off", "On");
 * </pre>
 *
 * @see InputFormField
 */
public class SwitchButton extends InputFormField<SwitchButton, HTMLInputElement, Boolean>
    implements Checkable<SwitchButton> {

  private LazyChild<LabelElement> offLabelElement;
  private LazyChild<LabelElement> onLabelElement;

  private String offTitle;
  private String onTitle;
  private SpanElement trackElement;

  /**
   * Factory method to create a {@link SwitchButton} with specified label, off and on titles.
   *
   * @param label the label of the switch button
   * @param offTitle the title when switch is OFF
   * @param onTitle the title when switch is ON
   * @return a new {@link SwitchButton} instance
   */
  public static SwitchButton create(String label, String offTitle, String onTitle) {
    return new SwitchButton(label, offTitle, onTitle);
  }

  /**
   * Factory method to create a {@link SwitchButton} with specified label and on/off title.
   *
   * @param label the label of the switch button
   * @param onOffTitle the title for both ON and OFF states
   * @return a new {@link SwitchButton} instance
   */
  public static SwitchButton create(String label, String onOffTitle) {
    return new SwitchButton(label, onOffTitle);
  }

  /**
   * Factory method to create a {@link SwitchButton} with no initial settings.
   *
   * @return a new {@link SwitchButton} instance
   */
  public static SwitchButton create() {
    return new SwitchButton();
  }

  /**
   * Constructor to initialize the {@link SwitchButton} with a label, off title, and on title.
   *
   * @param label the label of the switch button
   * @param offTitle the title when switch is OFF
   * @param onTitle the title when switch is ON
   */
  public SwitchButton(String label, String offTitle, String onTitle) {
    this(label);
    setOffTitle(offTitle);
    setOnTitle(onTitle);
  }

  /**
   * Constructor to initialize the {@link SwitchButton} with a label and on/off title.
   *
   * @param label the label of the switch button
   * @param onOffTitle the title for both ON and OFF states
   */
  public SwitchButton(String label, String onOffTitle) {
    this(label);
    setOffTitle(onOffTitle);
  }

  /**
   * Constructor to initialize the {@link SwitchButton} with a label.
   *
   * @param label the label of the switch button
   */
  public SwitchButton(String label) {
    this();
    setLabel(label);
  }

  /** Default constructor to initialize the {@link SwitchButton} with default settings. */
  public SwitchButton() {
    addCss(dui_switch);
    DivElement fieldInput = div().addCss(dui_field_input);
    wrapperElement.appendChild(fieldInput);
    offLabelElement = LazyChild.of(label().addCss(di_switch_off_label), fieldInput);
    onLabelElement = LazyChild.of(label().addCss(dui_switch_on_label), fieldInput);
    fieldInput.appendChild(trackElement = span().addCss(dui_switch_track));

    EventListener listener =
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          if (isEnabled() && !isReadOnly()) {
            toggleChecked();
          }
        };
    trackElement.addClickListener(listener);
    getInputElement().onKeyDown(keyEvents -> keyEvents.onEnter(listener));
    setDefaultValue(false);
    labelElement.get();
  }

  /**
   * Returns the type of the SwitchButton as a "checkbox".
   *
   * @return String representing the type "checkbox".
   */
  @Override
  public String getType() {
    return "checkbox";
  }

  /**
   * Creates an input element of the given type and adds a CSS class to it.
   *
   * @param type the type of the input element to be created.
   * @return DominoElement wrapping the created input element.
   */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_hidden_input).toDominoElement();
  }

  /**
   * Provides an event consumer for handling change events.
   *
   * @return Optional containing a Consumer for the change event.
   */
  @Override
  public Optional<Consumer<Event>> onChange() {
    return Optional.of(
        event -> {
          if (isEnabled() && !isReadOnly()) {
            withValue(isChecked(), isChangeListenersPaused());
          }
        });
  }

  /**
   * Toggles the checked state of the SwitchButton.
   *
   * @param silent if true, does not notify the change listeners.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton toggleChecked(boolean silent) {
    withValue(!isChecked(), silent);
    return this;
  }

  /**
   * Toggles the checked state of the SwitchButton.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton toggleChecked() {
    withValue(!isChecked());
    return this;
  }

  /**
   * Sets the checked state of the SwitchButton to the provided state.
   *
   * @param checkedState desired checked state.
   * @param silent if true, does not notify the change listeners.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton toggleChecked(boolean checkedState, boolean silent) {
    withValue(checkedState, silent);
    return this;
  }

  /**
   * Returns the default value for the SwitchButton.
   *
   * @return the default value which is false if null.
   */
  @Override
  public Boolean getDefaultValue() {
    return isNull(defaultValue) ? false : defaultValue;
  }

  /**
   * Sets the value of the SwitchButton.
   *
   * @param value the desired value.
   * @param silent if true, does not notify the change listeners.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton withValue(Boolean value, boolean silent) {
    if (isNull(value)) {
      return withValue(getDefaultValue(), silent);
    }
    super.withValue(value, silent);
    return this;
  }

  /**
   * Sets the SwitchButton to a checked state.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton check() {
    return check(isChangeListenersPaused());
  }

  /**
   * Sets the SwitchButton to an unchecked state.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /**
   * Sets the SwitchButton to a checked state.
   *
   * @param silent if true, does not notify the change listeners.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton check(boolean silent) {
    toggleChecked(true, silent);
    return this;
  }

  /**
   * Sets the SwitchButton to an unchecked state.
   *
   * @param silent if true, does not notify the change listeners.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton uncheck(boolean silent) {
    toggleChecked(false, silent);
    return this;
  }

  /**
   * Sets the title for the "on" state of the SwitchButton.
   *
   * @param onTitle the title to be set for the "on" state.
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton setOnTitle(String onTitle) {
    if (nonNull(onTitle) && !onTitle.isEmpty()) {
      onLabelElement.get().setTextContent(onTitle);
    } else {
      onLabelElement.remove();
    }
    this.onTitle = onTitle;
    return this;
  }

  /**
   * Sets the title for the "off" state of the SwitchButton.
   *
   * @param offTitle the title to be set for the "off" state.
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton setOffTitle(String offTitle) {
    if (nonNull(offTitle) && !offTitle.isEmpty()) {
      offLabelElement.get().setTextContent(offTitle);
    } else {
      offLabelElement.remove();
    }
    this.offTitle = offTitle;
    return this;
  }

  /**
   * Gets a lazy child representing the "off" label element of the SwitchButton.
   *
   * @return the LazyChild for the "off" label element.
   */
  public LazyChild<LabelElement> getOffLabelElement() {
    return offLabelElement;
  }

  /**
   * Gets a lazy child representing the "on" label element of the SwitchButton.
   *
   * @return the LazyChild for the "on" label element.
   */
  public LazyChild<LabelElement> getOnLabelElement() {
    return onLabelElement;
  }

  /**
   * Checks if the "on" title is empty.
   *
   * @return true if the "on" title is null or empty, false otherwise.
   */
  private boolean isOnTitleEmpty() {
    return isNull(onTitle) || onTitle.isEmpty();
  }

  /**
   * Creates an auto validator for the SwitchButton.
   *
   * @param autoValidate the ApplyFunction to be applied for auto-validation.
   * @return an instance of {@link AutoValidator} for the SwitchButton.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SwitchButtonAutoValidator(this, autoValidate);
  }

  /**
   * Gets the value of the SwitchButton as a Boolean.
   *
   * @return the Boolean value representing the checked state of the SwitchButton.
   */
  @Override
  public Boolean getValue() {
    return isChecked();
  }

  /**
   * Checks if the SwitchButton is in a checked state.
   *
   * @return true if the SwitchButton is checked, false otherwise.
   */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
  }

  /**
   * Checks if the SwitchButton is empty (unchecked).
   *
   * @return true if the SwitchButton is empty, false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return !isChecked();
  }

  /**
   * Checks if the SwitchButton is empty, ignoring spaces.
   *
   * @return true if the SwitchButton is empty, false otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * Gets the value of the SwitchButton as a string.
   *
   * @return a string representation of the Boolean value.
   */
  @Override
  public String getStringValue() {
    return Boolean.toString(getValue());
  }

  /**
   * Sets the value of the SwitchButton.
   *
   * @param value the desired value.
   */
  @Override
  protected void doSetValue(Boolean value) {
    withPauseChangeListenersToggle(true, field -> getInputElement().element().checked = value);
  }

  /**
   * Adds a CSS class to make the SwitchButton grow in size.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton grow() {
    addCss(BooleanCssClass.of(dui_switch_grow, true));
    return this;
  }

  /**
   * Removes the CSS class that makes the SwitchButton grow in size.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton ungrow() {
    addCss(BooleanCssClass.of(dui_switch_grow, false));
    return this;
  }

  /**
   * Adds or removes the CSS class to make the SwitchButton grow in size based on the provided
   * boolean.
   *
   * @param grow true to add the CSS class and make the SwitchButton grow, false to remove it.
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton grow(boolean grow) {
    addCss(BooleanCssClass.of(dui_switch_grow, grow));
    return this;
  }

  /**
   * Adds a CSS class to condense the labels of the SwitchButton.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton condenseLabels() {
    addCss(BooleanCssClass.of(dui_switch_condense, true));
    return this;
  }

  /**
   * Removes the CSS class that condenses the labels of the SwitchButton.
   *
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton uncondenseLabels() {
    addCss(BooleanCssClass.of(dui_switch_condense, false));
    return this;
  }

  /**
   * Adds or removes the CSS class to condense the labels of the SwitchButton based on the provided
   * boolean.
   *
   * @param grow true to add the CSS class and condense the labels, false to remove it.
   * @return the current instance of {@link SwitchButton}.
   */
  public SwitchButton condenseLabels(boolean grow) {
    addCss(BooleanCssClass.of(dui_switch_condense, grow));
    return this;
  }

  /**
   * Gets the name attribute of the SwitchButton's input element.
   *
   * @return the name attribute value.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * Sets the name attribute of the SwitchButton's input element.
   *
   * @param name the name attribute to be set.
   * @return the current instance of {@link SwitchButton}.
   */
  @Override
  public SwitchButton setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

  /** A private inner class for implementing auto-validation for the SwitchButton. */
  private static class SwitchButtonAutoValidator extends AutoValidator {

    private SwitchButton switchButton;
    private ChangeListener<Boolean> changeListener;

    public SwitchButtonAutoValidator(SwitchButton switchButton, ApplyFunction autoValidate) {
      super(autoValidate);
      this.switchButton = switchButton;
    }

    @Override
    public void attach() {
      changeListener = (oldValue, newValue) -> autoValidate.apply();
      switchButton.addChangeListener(changeListener);
    }

    @Override
    public void remove() {
      switchButton.removeChangeListener(changeListener);
    }
  }
}
