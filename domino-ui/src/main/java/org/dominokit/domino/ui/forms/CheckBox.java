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
import static org.jboss.elemento.Elements.input;
import static org.jboss.elemento.Elements.span;

import elemental2.dom.*;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/** A checkbox component that takes/provide a boolean value */
public class CheckBox extends AbstractValueBox<CheckBox, HTMLInputElement, Boolean>
    implements Checkable<CheckBox> {

  private static final String READONLY = "readonly";
  private Color color;
  private String checkedReadonlyLabel = "Yes";
  private String unCheckedReadonlyLabel = "No";
  private DominoElement<HTMLElement> readOnlyLabelElement = DominoElement.of(span());

  /** Creates a checkbox without a label */
  public CheckBox() {
    this("");
  }

  /**
   * Creates a checkbox with a label
   *
   * @param label String
   */
  public CheckBox(String label) {
    super("checkbox", label);
    css("d-checkbox");

    EventListener listener =
        evt -> {
          evt.stopPropagation();
          evt.preventDefault();
          if (isEnabled() && !isReadOnly()) toggle();
        };

    getInputElement()
        .removeEventListener("change", changeListener)
        .addEventListener(
            "change",
            evt -> {
              if (isEnabled() && !isReadOnly()) {
                setValue(isChecked());
              }
            });
    getLabelElement().addEventListener("click", listener);
    KeyboardEvents.listenOnKeyDown(getInputElement()).onEnter(listener);
  }

  private void onCheck() {
    changeHandlers.forEach(handler -> handler.onValueChanged(isChecked()));
  }

  /**
   * Creates a checkbox with a label
   *
   * @param label String
   * @return new CheckBox instance
   */
  public static CheckBox create(String label) {
    return new CheckBox(label);
  }

  /**
   * Creates a CheckBox without a label
   *
   * @return new CheckBox instance
   */
  public static CheckBox create() {
    return new CheckBox();
  }

  /**
   * Creates a CheckBox with a clickable link as a label
   *
   * @param link {@link HTMLAnchorElement} wrapped as {@link IsElement}
   * @return new CheckBox instance
   */
  public static CheckBox create(IsElement<HTMLAnchorElement> link) {
    return create(DominoElement.of(link));
  }

  /**
   * Creates a CheckBox with a clickable link as a label
   *
   * @param link {@link HTMLAnchorElement}
   * @return new CheckBox instance
   */
  public static CheckBox create(HTMLAnchorElement link) {
    return create(DominoElement.of(link));
  }

  /**
   * Creates a CheckBox with a clickable link as a label
   *
   * @param link {@link HTMLAnchorElement} wrapped as {@link DominoElement}
   * @return new CheckBox instance
   */
  public static CheckBox create(DominoElement<HTMLAnchorElement> link) {
    CheckBox checkBox = new CheckBox();
    checkBox.setLabel(link.element());
    link.addClickListener(Event::stopPropagation);
    return checkBox;
  }

  /**
   * Toggle the current state of the CheckBox, if it is checked it will be unchecked, and if it is
   * unchecked it will be checked
   *
   * @return same CheckBox instance
   */
  public CheckBox toggle() {
    if (isChecked()) {
      uncheck();
      element.removeCss("checked");
    } else {
      check();
      element.css("checked");
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox check() {
    return check(false);
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox uncheck() {
    return uncheck(false);
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox check(boolean silent) {
    getInputElement().element().checked = true;
    element.css("checked");
    if (!silent) onCheck();
    if (isReadOnly()) changeReadOnlyText();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox uncheck(boolean silent) {
    getInputElement().element().checked = false;
    element.removeCss("checked");
    if (!silent) onCheck();
    if (isReadOnly()) changeReadOnlyText();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox setLabel(String label) {
    super.setLabel(label);
    if (isReadOnly()) changeReadOnlyText();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    changeHandlers.add(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public CheckBox removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    if (changeHandler != null) changeHandlers.remove(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  /**
   * The CheckBox will be filled with its color instead of a white background
   *
   * @return same CheckBox instance
   */
  public CheckBox filledIn() {
    element.addCss("filled-in");
    return this;
  }

  /**
   * The CheckBox will be filled with a white background, this is the default
   *
   * @return same CheckBox instance
   */
  public CheckBox filledOut() {
    element.removeCss("filled-in");
    return this;
  }

  /**
   * This color will be used for the check mark in the CheckBox or the background for a {@link
   * #filledIn()} CheckBox
   *
   * @param color {@link Color}
   * @return same CheckBox instance
   */
  public CheckBox setColor(Color color) {
    if (this.color != null) {
      element.removeCss(this.color.getStyle());
    }
    element.addCss(color.getStyle());
    this.color = color;
    return this;
  }

  /** {@inheritDoc} This will check/uncheck the CheckBox based on the boolean value */
  @Override
  public CheckBox value(Boolean value) {
    if (value != null && value) {
      check();
    } else {
      uncheck();
    }
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
   * This should render the checkbox as a label based on {@link #setCheckedReadonlyLabel(String)}
   * and {@link #setUnCheckedReadonlyLabel(String)}
   *
   * @param readOnly boolean
   * @return same CheckBox instance
   */
  @Override
  public CheckBox setReadOnly(boolean readOnly) {
    super.setReadOnly(readOnly);
    if (readOnly) {
      getInputElement().setReadOnly(true);
      css(READONLY);
      changeReadOnlyText();
    } else {
      getInputElement().setReadOnly(false);
      removeCss(READONLY);
      readOnlyLabelElement.remove();
    }
    return this;
  }

  private void changeReadOnlyText() {
    readOnlyLabelElement.remove();
    if (isChecked()) {
      readOnlyLabelElement.setTextContent(getCheckedReadonlyLabel());
    } else {
      readOnlyLabelElement.setTextContent(getUnCheckedReadonlyLabel());
    }
    getLabelElement().appendChild(readOnlyLabelElement);
  }

  private String getCheckedReadonlyLabel() {
    return isNull(checkedReadonlyLabel) || checkedReadonlyLabel.isEmpty()
        ? ""
        : ": " + checkedReadonlyLabel;
  }

  private String getUnCheckedReadonlyLabel() {
    return isNull(unCheckedReadonlyLabel) || unCheckedReadonlyLabel.isEmpty()
        ? ""
        : ": " + unCheckedReadonlyLabel;
  }

  /**
   * @param checkedReadonlyLabel String label to be used in checked readonly mode
   * @return same CheckBox instance
   */
  public CheckBox setCheckedReadonlyLabel(String checkedReadonlyLabel) {
    this.checkedReadonlyLabel = checkedReadonlyLabel;
    return this;
  }

  /**
   * @param unCheckedReadonlyLabel String label to be used in unchecked readonly mode
   * @return same CheckBox instance
   */
  public CheckBox setUnCheckedReadonlyLabel(String unCheckedReadonlyLabel) {
    this.unCheckedReadonlyLabel = unCheckedReadonlyLabel;
    return this;
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

  /** {@inheritDoc} creates a <b>checkbox</b> input element */
  @Override
  protected HTMLInputElement createInputElement(String type) {
    return DominoElement.of(input("checkbox")).element();
  }

  /** {@inheritDoc} this will uncheck the CheckBox if it is checked */
  @Override
  protected void clearValue() {
    value(false);
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(Boolean value) {}

  /** {@inheritDoc} */
  @Override
  protected boolean isAddFocusColor() {
    return false;
  }

  /** {@inheritDoc} */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return new CheckBoxAutoValidator<>(this, autoValidate);
  }

  private static class CheckBoxAutoValidator<T> extends AutoValidator {

    private CheckBox checkBox;
    private ChangeHandler<Boolean> changeHandler;

    public CheckBoxAutoValidator(CheckBox checkBox, AutoValidate autoValidate) {
      super(autoValidate);
      this.checkBox = checkBox;
    }

    @Override
    public void attach() {
      changeHandler = value -> autoValidate.apply();
      checkBox.addChangeHandler(changeHandler);
    }

    @Override
    public void remove() {
      checkBox.removeChangeHandler(changeHandler);
    }
  }
}
