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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.LabelElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * Represents a checkbox input field that allows users to select or deselect an option.
 *
 * <p>Example usage:
 *
 * <pre>
 * CheckBox checkBox = CheckBox.create("Enable feature")
 *      .setChecked(true)
 *      .onChange(value -> DomGlobal.console.log("Checkbox state changed: " + value));
 * </pre>
 *
 * <p>
 *
 * @see InputFormField
 */
public class CheckBox extends InputFormField<CheckBox, HTMLInputElement, Boolean>
    implements Checkable<CheckBox>, HasIndeterminateState<CheckBox> {

  private LabelElement checkLabelElement;
  private LazyChild<SpanElement> checkLabelTextElement;

  /**
   * Creates a CheckBox instance.
   *
   * @param checkLabel The label text displayed next to the checkbox.
   */
  public static CheckBox create(String checkLabel) {
    return new CheckBox(checkLabel);
  }

  /**
   * Creates a CheckBox instance with an additional label.
   *
   * @param label The label text for the checkbox field.
   * @param checkLabel The label text displayed next to the checkbox.
   */
  public static CheckBox create(String label, String checkLabel) {
    return new CheckBox(label, checkLabel);
  }

  /** Creates a CheckBox instance without any labels. */
  public static CheckBox create() {
    return new CheckBox();
  }

  /** Initializes a new CheckBox instance. */
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
    labelElement.get();
  }

  protected LazyChild<DominoElement<HTMLElement>> initRequiredIndicator() {
    return LazyChild.of(
        elementOf(getConfig().getRequiredIndicator().get()).addCss(dui_field_required_indicator),
        checkLabelElement);
  }

  /**
   * Creates a CheckBox instance with a check label.
   *
   * @param checkLabel The label text displayed next to the checkbox.
   */
  public CheckBox(String checkLabel) {
    this();
    setCheckLabel(checkLabel);
  }

  /**
   * Creates a CheckBox instance with labels for both the checkbox field and the check label.
   *
   * @param label The label text for the checkbox field.
   * @param checkLabel The label text displayed next to the checkbox.
   */
  public CheckBox(String label, String checkLabel) {
    this();
    setLabel(label);
    setCheckLabel(checkLabel);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns an optional {@link Consumer} of {@link Event} that listens for change events on this
   * CheckBox. When a change event occurs, this method checks if the CheckBox is enabled and not
   * read-only. If both conditions are met, it updates the CheckBox's value based on its checked
   * state.
   *
   * @return An optional {@link Consumer} of {@link Event} to handle change events on this CheckBox.
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
   * Sets the label text displayed next to the checkbox.
   *
   * @param checkLabel The label text for the checkbox.
   * @return This CheckBox instance.
   */
  public CheckBox setCheckLabel(String checkLabel) {
    checkLabelTextElement.get().setTextContent(checkLabel);
    return this;
  }

  /**
   * Sets the label content displayed next to the checkbox using a DOM Node.
   *
   * @param checkLabel The DOM Node to be used as the label content.
   * @return This CheckBox instance.
   */
  public CheckBox setCheckLabel(Node checkLabel) {
    checkLabelTextElement.get().setContent(checkLabel);
    return this;
  }

  /**
   * Sets the label content displayed next to the checkbox using an {@link IsElement}.
   *
   * @param checkLabel The {@link IsElement} to be used as the label content.
   * @return This CheckBox instance.
   */
  public CheckBox setCheckLabel(IsElement<?> checkLabel) {
    checkLabelTextElement.get().setContent(checkLabel);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Creates and returns a hidden input element of the specified type, which is "checkbox" in
   * this case, to be used as the underlying input element for this CheckBox.
   *
   * @param type The type of the input element to create. In this case, it's "checkbox."
   * @return A hidden input element of the specified type.
   */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_hidden_input).toDominoElement();
  }

  /**
   * {@inheritDoc}
   *
   * <p>Gets the type of this input field, which is always "checkbox" for CheckBox instances.
   *
   * @return The type of this input field, which is "checkbox."
   */
  @Override
  public String getType() {
    return "checkbox";
  }

  /**
   * Toggles the checkbox's checked state, optionally without triggering change listeners.
   *
   * @param silent If {@code true}, change listeners will not be triggered; otherwise, they will.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox toggleChecked(boolean silent) {
    withValue(!isChecked(), silent);
    return this;
  }

  /**
   * Toggles the checkbox's checked state and triggers change listeners.
   *
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox toggleChecked() {
    withValue(!isChecked(), isChangeListenersPaused());
    return this;
  }

  /**
   * Toggles the checkbox's checked state, optionally without triggering change listeners.
   *
   * @param checkedState The desired checked state.
   * @param silent If {@code true}, change listeners will not be triggered; otherwise, they will.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox toggleChecked(boolean checkedState, boolean silent) {
    withValue(checkedState, silent);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the default value for the CheckBox, which is {@code false} if no default
   * value has been set.
   *
   * @return The default value of the CheckBox (false if not set).
   */
  @Override
  public Boolean getDefaultValue() {
    return isNull(defaultValue) ? false : defaultValue;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method sets the value of the CheckBox and allows the option to perform the operation
   * silently (without triggering change listeners).
   *
   * <p>If the provided value is {@code null}, it will use the default value instead (if set).
   *
   * @param value The value to set.
   * @param silent True to perform the operation silently, false otherwise.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox withValue(Boolean value, boolean silent) {
    if (isNull(value)) {
      return withValue(getDefaultValue(), silent);
    }
    super.withValue(value, silent);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method sets the CheckBox to an indeterminate state.
   *
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox indeterminate() {
    getInputElement().element().indeterminate = true;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, true));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method sets the CheckBox to a determinate state.
   *
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox determinate() {
    getInputElement().element().indeterminate = false;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, false));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method toggles the indeterminate state of the CheckBox.
   *
   * @param indeterminate True to set to an indeterminate state, false otherwise.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox toggleIndeterminate(boolean indeterminate) {
    getInputElement().element().indeterminate = indeterminate;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, indeterminate));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method toggles the indeterminate state of the CheckBox.
   *
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox toggleIndeterminate() {
    boolean current = getInputElement().element().indeterminate;
    getInputElement().element().indeterminate = !current;
    addCss(BooleanCssClass.of(dui_check_box_indeterminate, !current));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>Checks the CheckBox, setting its value to {@code true}. If the CheckBox is currently paused
   * for change listeners, the check operation can be silent. If not paused, it will trigger change
   * listeners if any are registered.
   *
   * @return This CheckBox instance after the check operation.
   */
  @Override
  public CheckBox check() {
    return check(isChangeListenersPaused());
  }

  /**
   * {@inheritDoc}
   *
   * <p>Unchecks the CheckBox, setting its value to {@code false}. If the CheckBox is currently
   * paused for change listeners, the uncheck operation can be silent. If not paused, it will
   * trigger change listeners if any are registered.
   *
   * @return This CheckBox instance after the uncheck operation.
   */
  @Override
  public CheckBox uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method checks the CheckBox, optionally allowing the operation to be performed silently
   * (without triggering change listeners). It also sets the CheckBox to a determinate state.
   *
   * @param silent True to perform the operation silently, false otherwise.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox check(boolean silent) {
    determinate();
    toggleChecked(true, silent);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method unchecks the CheckBox, optionally allowing the operation to be performed
   * silently (without triggering change listeners). It also sets the CheckBox to a determinate
   * state.
   *
   * @param silent True to perform the operation silently, false otherwise.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox uncheck(boolean silent) {
    determinate();
    toggleChecked(false, silent);
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method checks whether the CheckBox is in a checked state.
   *
   * @return True if the CheckBox is checked, false otherwise.
   */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
  }

  /**
   * Adds CSS class to style the CheckBox as filled in.
   *
   * @return This CheckBox instance.
   */
  public CheckBox filledIn() {
    addCss(BooleanCssClass.of(dui_check_box_filled, true));
    return this;
  }

  /**
   * Adds CSS class to style the CheckBox as filled out.
   *
   * @return This CheckBox instance.
   */
  public CheckBox filledOut() {
    addCss(BooleanCssClass.of(dui_check_box_filled, false));
    return this;
  }

  /**
   * Sets the filled state of the CheckBox, adding or removing the CSS class accordingly.
   *
   * @param filled True to style the CheckBox as filled in, false to style it as filled out.
   * @return This CheckBox instance.
   */
  public CheckBox setFilled(boolean filled) {
    addCss(BooleanCssClass.of(dui_check_box_filled, filled));
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the value of the CheckBox, which is the same as whether it's checked or
   * not.
   *
   * @return True if the CheckBox is checked, false otherwise.
   */
  @Override
  public Boolean getValue() {
    return isChecked();
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method checks whether the CheckBox is empty, meaning it is not checked.
   *
   * @return True if the CheckBox is empty (unchecked), false otherwise.
   */
  @Override
  public boolean isEmpty() {
    return !isChecked();
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method checks whether the CheckBox is empty, ignoring spaces.
   *
   * @return True if the CheckBox is empty (unchecked), false otherwise.
   */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the string representation of the CheckBox's value, which is either
   * "true" if checked or "false" if not checked.
   *
   * @return The string representation of the CheckBox's value.
   */
  @Override
  public String getStringValue() {
    return Boolean.toString(getValue());
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method sets the value of the CheckBox, allowing the option to perform the operation
   * with or without triggering change listeners.
   *
   * @param value The value to set.
   */
  @Override
  protected void doSetValue(Boolean value) {
    withPauseChangeListenersToggle(true, field -> getInputElement().element().checked = value);
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method creates an {@link AutoValidator} instance for the CheckBox, which is used to
   * automatically validate the CheckBox's value.
   *
   * @param autoValidate The function to apply for auto-validation.
   * @return An {@link AutoValidator} instance for the CheckBox.
   */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new CheckBoxAutoValidator(this, autoValidate);
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method returns the name of the CheckBox.
   *
   * @return The name of the CheckBox.
   */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /**
   * {@inheritDoc}
   *
   * <p>This method sets the name attribute of the CheckBox's input element.
   *
   * @param name The name to set.
   * @return This CheckBox instance.
   */
  @Override
  public CheckBox setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

  /**
   * Applies the given handler to the label element associated with this CheckBox. This allows you
   * to customize the label element.
   *
   * @param handler The handler to apply to the label element.
   * @return This CheckBox instance.
   */
  public CheckBox withLabel(ChildHandler<CheckBox, LabelElement> handler) {
    handler.apply(this, checkLabelElement);
    return this;
  }

  /**
   * Applies the given handler to the label text element associated with this CheckBox. This allows
   * you to customize the label text element.
   *
   * @param handler The handler to apply to the label text element.
   * @return This CheckBox instance.
   */
  public CheckBox withLabelTextElement(ChildHandler<CheckBox, SpanElement> handler) {
    handler.apply(this, checkLabelTextElement.get());
    return this;
  }

  /**
   * Retrieves the label element associated with this CheckBox.
   *
   * @return The label element of this CheckBox.
   */
  public LabelElement getCheckLabelElement() {
    return checkLabelElement;
  }

  /**
   * Retrieves the lazy child element representing the label text associated with this CheckBox.
   *
   * @return The lazy child element of the label text associated with this CheckBox.
   */
  public LazyChild<SpanElement> getCheckLabelTextElement() {
    return checkLabelTextElement;
  }

  /**
   * An inner class that extends {@link AutoValidator} to provide auto-validation capabilities for
   * the CheckBox.
   */
  private static class CheckBoxAutoValidator extends AutoValidator {

    private CheckBox checkBox;
    private ChangeListener<Boolean> changeListener;

    /**
     * Constructs a new CheckBoxAutoValidator instance.
     *
     * @param checkBox The CheckBox to be auto-validated.
     * @param autoValidate The function to apply for auto-validation.
     */
    public CheckBoxAutoValidator(CheckBox checkBox, ApplyFunction autoValidate) {
      super(autoValidate);
      this.checkBox = checkBox;
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method attaches a change listener to the CheckBox to trigger auto-validation when the
     * CheckBox's value changes.
     */
    @Override
    public void attach() {
      changeListener = (oldValue, newValue) -> autoValidate.apply();
      checkBox.addChangeListener(changeListener);
    }

    /**
     * {@inheritDoc}
     *
     * <p>This method removes the change listener from the CheckBox.
     */
    @Override
    public void remove() {
      checkBox.removeChangeListener(changeListener);
    }
  }
}
