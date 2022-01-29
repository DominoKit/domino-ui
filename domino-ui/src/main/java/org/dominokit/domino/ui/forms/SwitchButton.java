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
import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import elemental2.dom.HTMLLabelElement;
import org.dominokit.domino.ui.keyboard.KeyboardEvents;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LambdaFunction;

/** A component that can switch between two boolean values with different labels */
public class SwitchButton extends AbstractValueBox<SwitchButton, HTMLElement, Boolean>
    implements Checkable<SwitchButton> {

  private HTMLLabelElement onOffLabelElement;
  private DominoElement<HTMLInputElement> inputElement;
  private DominoElement<HTMLElement> lever = DominoElement.of(span()).css("lever");
  private Color color;
  private DominoElement<HTMLElement> onTitleTextRoot = DominoElement.of(span());
  private DominoElement<HTMLElement> offTitleTextRoot = DominoElement.of(span());
  private String checkedReadonlyLabel = "Yes";
  private String unCheckedReadonlyLabel = "No";
  private String offTitle;
  private String onTitle;
  private LambdaFunction offLabelInitializer;
  private LambdaFunction onLabelInitializer;

  /**
   * @param label String label describing the switch
   * @param offTitle String label for the OFF state
   * @param onTitle String label for the ON state
   */
  public SwitchButton(String label, String offTitle, String onTitle) {
    this(label);
    setOffTitle(offTitle);
    setOnTitle(onTitle);
  }

  /**
   * @param label String label describing the switch
   * @param onOffTitle String label for the ON/OFF state
   */
  public SwitchButton(String label, String onOffTitle) {
    this(label);
    setOffTitle(onOffTitle);
  }

  /** @param label String label describing the switch */
  public SwitchButton(String label) {
    this();
    setLabel(label);
  }

  /** Creates a switch without a label */
  public SwitchButton() {
    super("switch", "");
    init(this);
    onOffLabelElement = label().element();
    DominoElement.of(onOffLabelElement).css("switch-label");
    getInputContainer().appendChild(onOffLabelElement);
    onOffLabelElement.appendChild(getInputElement().element());
    onOffLabelElement.appendChild(lever.element());

    linkLabelToField();

    inputElement.addEventListener("focus", evt -> inputElement.css("tabbed"));
    inputElement.addEventListener("blur", evt -> inputElement.removeCss("tabbed"));

    inputElement.addEventListener(
        "change",
        evt -> {
          evt.stopPropagation();
          if (!isReadOnly()) {
            if (isAutoValidation()) {
              validate();
            }
          }
        });

    KeyboardEvents.listenOnKeyDown(inputElement)
        .onEnter(
            evt -> {
              evt.stopPropagation();
              setValue(!this.getValue());
            });
    css("switch");
    onLabelInitializer =
        () -> {
          onOffLabelElement.appendChild(onTitleTextRoot.element());
          onLabelInitializer = () -> {};
        };
    offLabelInitializer =
        () -> {
          onOffLabelElement.insertBefore(offTitleTextRoot.element(), inputElement.element());
          offLabelInitializer = () -> {};
        };
  }

  /**
   * @param label String label describing the switch
   * @param offTitle String label for the OFF state
   * @param onTitle String label for the ON state
   * @return new SwitchButton instance
   */
  public static SwitchButton create(String label, String offTitle, String onTitle) {
    return new SwitchButton(label, offTitle, onTitle);
  }

  /**
   * @param label String label describing the switch
   * @param onOffTitle String label for the OFF state
   * @return new SwitchButton instance
   */
  public static SwitchButton create(String label, String onOffTitle) {
    return new SwitchButton(label, onOffTitle);
  }

  public static SwitchButton create() {
    return new SwitchButton();
  }

  /** @return the lever {@link HTMLElement} */
  public DominoElement<HTMLElement> getLever() {
    return lever;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton value(Boolean value) {
    if (value != null && value) {
      check(true);
    } else {
      uncheck(true);
    }
    super.value(value);
    return this;
  }

  @Override
  protected void updateCharacterCount() {
    // Do nothing, Switch does not have character count
  }

  /**
   * {@inheritDoc}
   *
   * @return boolean, true if ON false if OFF
   */
  @Override
  public Boolean getValue() {
    return inputElement.element().checked;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmpty() {
    return !isChecked();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEmptyIgnoreSpaces() {
    return isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton clear() {
    value(false);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton check() {
    return check(false);
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton uncheck() {
    return uncheck(false);
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton check(boolean silent) {
    inputElement.element().checked = true;
    if (!silent) {
      callChangeHandlers();
      validate();
    }
    updateLabel();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton uncheck(boolean silent) {
    inputElement.element().checked = false;
    if (!silent) {
      callChangeHandlers();
      validate();
    }
    updateLabel();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return inputElement.element().checked;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    changeHandlers.add(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    if (changeHandler != null) changeHandlers.remove(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  /**
   * Sets the color of the Switch when it is ON
   *
   * @param color {@link Color}
   * @return same Switch instance
   */
  public SwitchButton setColor(Color color) {
    if (this.color != null) lever.removeCss(this.color.getStyle());
    lever.addCss(color.getStyle());
    this.color = color;
    return this;
  }

  /**
   * @param onTitle String title for the ON switch state
   * @return same SwitchButton instance
   */
  public SwitchButton setOnTitle(String onTitle) {
    if (nonNull(onTitle) && !onTitle.isEmpty()) {
      onLabelInitializer.apply();
      onTitleTextRoot.clearElement().appendChild(span().textContent(onTitle));
      this.onTitle = onTitle;
    }
    return this;
  }

  /**
   * @param offTitle String title for the OFF switch state
   * @return same SwitchButton instance
   */
  public SwitchButton setOffTitle(String offTitle) {
    if (nonNull(offTitle) && !offTitle.isEmpty()) {
      offLabelInitializer.apply();
      offTitleTextRoot.clearElement().appendChild(span().textContent(offTitle));
      this.offTitle = offTitle;
    }
    return this;
  }

  /** @return HTMLLabelElement */
  public DominoElement<HTMLLabelElement> getOnOffLabelElement() {
    return DominoElement.of(onOffLabelElement);
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton setReadOnly(boolean readOnly) {
    super.setReadOnly(readOnly);
    if (readOnly) {
      updateLabel();
    } else {
      setOffTitle(offTitle);
      setOnTitle(onTitle);
    }

    return this;
  }

  private void updateLabel() {
    setOffTitle(offTitle);
    setOnTitle(onTitle);
    if (isReadOnly()) {
      if (isChecked()) {
        if (isOnTitleEmpty()) {
          offTitleTextRoot
              .clearElement()
              .appendChild(span().textContent(offTitle))
              .appendChild(span().textContent(getCheckedReadonlyLabel()));
        } else {
          offTitleTextRoot.clearElement();
        }
      } else {
        if (isOnTitleEmpty()) {
          offTitleTextRoot
              .clearElement()
              .appendChild(span().textContent(offTitle))
              .appendChild(span().textContent(getUnCheckedReadonlyLabel()));
        } else {
          onTitleTextRoot.clearElement();
        }
      }
    }
  }

  private boolean isOnTitleEmpty() {
    return isNull(onTitle) || onTitle.isEmpty();
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
   * Set the label when the state is ON but the switch is readonly
   *
   * @param checkedReadonlyLabel String
   * @return same SwitchButton instance
   */
  public SwitchButton setCheckedReadonlyLabel(String checkedReadonlyLabel) {
    this.checkedReadonlyLabel = checkedReadonlyLabel;
    return this;
  }

  /**
   * Set the label when the state is OFF but the switch is readonly
   *
   * @param unCheckedReadonlyLabel String
   * @return same SwitchButton instance
   */
  public SwitchButton setUnCheckedReadonlyLabel(String unCheckedReadonlyLabel) {
    this.unCheckedReadonlyLabel = unCheckedReadonlyLabel;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  protected HTMLElement createInputElement(String type) {
    inputElement = DominoElement.of(input("checkbox"));
    return inputElement.element();
  }

  /** {@inheritDoc} */
  @Override
  protected AutoValidator createAutoValidator(AutoValidate autoValidate) {
    return null;
  }

  /** {@inheritDoc} */
  @Override
  protected void clearValue() {
    value(false);
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(Boolean value) {}

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return Boolean.toString(getValue());
  }

  /** {@inheritDoc} */
  @Override
  protected boolean isAddFocusColor() {
    return false;
  }

  private static class SwitchButtonAutoValidator<T> extends AutoValidator {

    private SwitchButton switchButton;
    private ChangeHandler<Boolean> changeHandler;

    public SwitchButtonAutoValidator(SwitchButton switchButton, AutoValidate autoValidate) {
      super(autoValidate);
      this.switchButton = switchButton;
    }

    @Override
    public void attach() {
      changeHandler = value -> autoValidate.apply();
      switchButton.addChangeHandler(changeHandler);
    }

    @Override
    public void remove() {
      switchButton.removeChangeHandler(changeHandler);
    }
  }
}
