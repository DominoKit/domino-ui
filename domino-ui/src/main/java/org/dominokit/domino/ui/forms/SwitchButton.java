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
import static org.dominokit.domino.ui.forms.FormsStyles.*;

import elemental2.dom.*;
import java.util.Optional;
import java.util.function.Consumer;

import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.Checkable;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

/** A component that can switch between two boolean values with different labels */
public class SwitchButton extends InputFormField<SwitchButton, HTMLInputElement, Boolean>
    implements Checkable<SwitchButton> {

  private LazyChild<DominoElement<HTMLLabelElement>> offLabelElement;
  private LazyChild<DominoElement<HTMLLabelElement>> onLabelElement;

  private String offTitle;
  private String onTitle;
  private DominoElement<HTMLElement> trackElement;

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
    addCss(SWITCH);
    DominoElement<HTMLDivElement> fieldInput = div().addCss(FIELD_INPUT);
    wrapperElement.appendChild(fieldInput);
    offLabelElement = LazyChild.of(label().addCss(SWITCH_OFF_LABEL), fieldInput);
    onLabelElement = LazyChild.of(label().addCss(SWITCH_ON_LABEL), fieldInput);
    fieldInput.appendChild(trackElement = span().addCss(SWITCH_TRACK));

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
  }

  @Override
  public String getType() {
    return "checkbox";
  }

  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(HIDDEN_INPUT);
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

  @Override
  public SwitchButton toggleChecked(boolean silent) {
    withValue(!isChecked(), silent);
    return this;
  }

  @Override
  public SwitchButton toggleChecked() {
    withValue(!isChecked());
    return this;
  }

  @Override
  public SwitchButton toggleChecked(boolean checkedState, boolean silent) {
    withValue(checkedState, silent);
    return this;
  }

  @Override
  public Boolean getDefaultValue() {
    return isNull(defaultValue) ? false : defaultValue;
  }

  @Override
  public SwitchButton withValue(Boolean value, boolean silent) {
    if (isNull(value)) {
      return withValue(getDefaultValue(), silent);
    }
    super.withValue(value, silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton check() {
    return check(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton uncheck() {
    return uncheck(isChangeListenersPaused());
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton check(boolean silent) {
    toggleChecked(true, silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton uncheck(boolean silent) {
    toggleChecked(false, silent);
    return this;
  }

  /**
   * @param onTitle String title for the ON switch state
   * @return same SwitchButton instance
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
   * @param offTitle String title for the OFF switch state
   * @return same SwitchButton instance
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

  /** @return HTMLLabelElement */
  public LazyChild<DominoElement<HTMLLabelElement>> getOffLabelElement() {
    return offLabelElement;
  }

  private boolean isOnTitleEmpty() {
    return isNull(onTitle) || onTitle.isEmpty();
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new SwitchButtonAutoValidator(this, autoValidate);
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

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
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

  /**
   * The SwitchButton will stretch the left label pushing the switch and the right label to the
   * right keeping the left label on the left
   *
   * @return same SwitchButton instance
   */
  public SwitchButton grow() {
    addCss(BooleanCssClass.of(SWITCH_GROW, true));
    return this;
  }

  /**
   * reverse the effect if {@link #grow()}
   *
   * @return same SwitchButton instance
   */
  public SwitchButton ungrow() {
    addCss(BooleanCssClass.of(SWITCH_GROW, false));
    return this;
  }

  /**
   * switch between {@link #grow()} if true and {@link #ungrow()} if false
   *
   * @return same SwitchButton instance
   */
  public SwitchButton grow(boolean grow) {
    addCss(BooleanCssClass.of(SWITCH_GROW, grow));
    return this;
  }

  /**
   * Will force SwitchButton labels closer to the switch track , in case of {@link #grow()} the
   * right label will be pushed to the right closer to the track
   *
   * @return same SwitchButton instance
   */
  public SwitchButton condenseLabels() {
    addCss(BooleanCssClass.of(SWITCH_CONDENSE, true));
    return this;
  }

  /**
   * reverse the effect if {@link #condenseLabels()}
   *
   * @return same SwitchButton instance
   */
  public SwitchButton uncondenseLabels() {
    addCss(BooleanCssClass.of(SWITCH_CONDENSE, false));
    return this;
  }

  /**
   * switch between {@link #condenseLabels()} if true and {@link #uncondenseLabels()} if false
   *
   * @return same SwitchButton instance
   */
  public SwitchButton condenseLabels(boolean grow) {
    addCss(BooleanCssClass.of(SWITCH_CONDENSE, grow));
    return this;
  }

  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  @Override
  public SwitchButton setName(String name) {
    getInputElement().element().name = name;
    return this;
  }

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
