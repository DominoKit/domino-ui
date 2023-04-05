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

import elemental2.dom.*;
import java.util.Optional;
import java.util.function.Consumer;

import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/** A checkbox component that takes/provide a boolean value */
public class CheckBox extends InputFormField<CheckBox, HTMLInputElement, Boolean>
    implements Checkable<CheckBox>, HasIndeterminateState<CheckBox> {

  private LabelElement checkLabelElement;
  private LazyChild<SpanElement> checkLabelTextElement;

  /**
   * Creates a checkbox with a label
   *
   * @param checkLabel String
   * @return new CheckBox instance
   */
  public static CheckBox create(String checkLabel) {
    return new CheckBox(checkLabel);
  }

  /**
   * Creates a checkbox with a label
   *
   * @param label String, the field label
   * @param checkLabel String, the checkbox label
   * @return new CheckBox instance
   */
  public static CheckBox create(String label, String checkLabel) {
    return new CheckBox(label, checkLabel);
  }

  /**
   * Creates a CheckBox without a label
   *
   * @return new CheckBox instance
   */
  public static CheckBox create() {
    return new CheckBox();
  }

  /** Creates a checkbox without a label */
  public CheckBox() {
    formElement.addCss(dui_form_check_box);
    wrapperElement.appendChild(
        div()
            .addCss(dui_field_input)
            .appendChild(checkLabelElement = label().addCss(dui_check_box_label)));
    checkLabelTextElement = LazyChild.of(span(), checkLabelElement);
    EventListener listener =
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          if (isEnabled() && !isReadOnly()) {
            toggleChecked();
          }
        };
    checkLabelElement.addClickListener(listener);
    getInputElement().onKeyDown(keyEvents -> keyEvents.onEnter(listener));
    setDefaultValue(false);
  }

  /**
   * Creates a checkbox with a label
   *
   * @param checkLabel String
   */
  public CheckBox(String checkLabel) {
    this();
    setCheckLabel(checkLabel);
  }

  /**
   * Creates a checkbox with a label
   *
   * @param checkLabel String
   */
  public CheckBox(String label, String checkLabel) {
    this();
    setLabel(label);
    setCheckLabel(checkLabel);
  }

  @Override
  public Optional<Consumer<Event>> onChange() {
    return Optional.of(
        event -> {
          if (isEnabled() && !isReadOnly()) {
            withValue(isChecked(), isChangeListenersPaused());
          }
        });
  }

  public CheckBox setCheckLabel(String checkLabel) {
    checkLabelTextElement.get().setTextContent(checkLabel);
    return this;
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_hidden_input).toDominoElement();
  }

  @Override
  public String getType() {
    return "checkbox";
  }

  @Override
  public CheckBox toggleChecked(boolean silent) {
    withValue(!isChecked(), silent);
    return this;
  }

  @Override
  public CheckBox toggleChecked() {
    withValue(!isChecked());
    return this;
  }

  @Override
  public CheckBox toggleChecked(boolean checkedState, boolean silent) {
    withValue(checkedState, silent);
    return this;
  }

  @Override
  public Boolean getDefaultValue() {
    return isNull(defaultValue) ? false : defaultValue;
  }

  @Override
  public CheckBox withValue(Boolean value, boolean silent) {
    if (isNull(value)) {
      return withValue(getDefaultValue(), silent);
    }
    super.withValue(value, silent);
    return this;
  }

  @Override
  public CheckBox indeterminate() {
    getInputElement().element().indeterminate = true;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, true));
    return this;
  }

  @Override
  public CheckBox determinate() {
    getInputElement().element().indeterminate = false;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, false));
    return this;
  }

  @Override
  public CheckBox toggleIndeterminate(boolean indeterminate) {
    getInputElement().element().indeterminate = indeterminate;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, indeterminate));
    return this;
  }

  @Override
  public CheckBox toggleIndeterminate() {
    boolean current = getInputElement().element().indeterminate;
    getInputElement().element().indeterminate = !current;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, !current));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox check() {
    return check(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox check(boolean silent) {
    toggleChecked(true, silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox uncheck(boolean silent) {
    toggleChecked(false, silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
  }

  /**
   * The CheckBox will be filled with its color instead of a white background
   *
   * @return same CheckBox instance
   */
  public CheckBox filledIn() {
    addCss(BooleanCssClass.of(dui_check_box_filled, true));
    return this;
  }

  /**
   * The CheckBox will be filled with a white background, this is the default
   *
   * @return same CheckBox instance
   */
  public CheckBox filledOut() {
    addCss(BooleanCssClass.of(dui_check_box_filled, false));
    return this;
  }

  public CheckBox filled(boolean filled) {
    addCss(BooleanCssClass.of(dui_check_box_filled, filled));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * @return boolean, true if checked, false if unchecked
   */
  @Override
  public Boolean getValue() {
    return isChecked();
  }

  /**
   * {@inheritDoc}
   *
   * @return boolean, CheckBox cant be empty so this actually is true if the CheckBox is unchecked.
   */
  @Override
  public boolean isEmpty() {
    return !isChecked();
  }

  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * {@inheritDoc}
   *
   * @return String boolean value
   */
  @Override
  public String getStringValue() {
    return Boolean.toString(getValue());
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(Boolean value) {
    withPauseChangeListenersToggle(
        true, (field, handler) -> getInputElement().element().checked = value);
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new CheckBoxAutoValidator(this, autoValidate);
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public CheckBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

  private static class CheckBoxAutoValidator extends AutoValidator {

    private CheckBox checkBox;
    private ChangeListener<Boolean> changeListener;

    public CheckBoxAutoValidator(CheckBox checkBox, ApplyFunction autoValidate) {
      super(autoValidate);
      this.checkBox = checkBox;
    }

    @Override
    public void attach() {
      changeListener = (oldValue, newValue) -> autoValidate.apply();
      checkBox.addChangeListener(changeListener);
    }

    @Override
    public void remove() {
      checkBox.removeChangeListener(changeListener);
    }
  }
}
