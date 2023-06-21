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

import elemental2.dom.*;
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
 * A component that can switch between two boolean values with different labels
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class SwitchButton extends InputFormField<SwitchButton, HTMLInputElement, Boolean>
    implements Checkable<SwitchButton> {

  private LazyChild<LabelElement> offLabelElement;
  private LazyChild<LabelElement> onLabelElement;

  private String offTitle;
  private String onTitle;
  private SpanElement trackElement;

  /**
   * create.
   *
   * @param label String label describing the switch
   * @param offTitle String label for the OFF state
   * @param onTitle String label for the ON state
   * @return new SwitchButton instance
   */
  public static SwitchButton create(String label, String offTitle, String onTitle) {
    return new SwitchButton(label, offTitle, onTitle);
  }

  /**
   * create.
   *
   * @param label String label describing the switch
   * @param onOffTitle String label for the OFF state
   * @return new SwitchButton instance
   */
  public static SwitchButton create(String label, String onOffTitle) {
    return new SwitchButton(label, onOffTitle);
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.SwitchButton} object
   */
  public static SwitchButton create() {
    return new SwitchButton();
  }

  /**
   * Constructor for SwitchButton.
   *
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
   * Constructor for SwitchButton.
   *
   * @param label String label describing the switch
   * @param onOffTitle String label for the ON/OFF state
   */
  public SwitchButton(String label, String onOffTitle) {
    this(label);
    setOffTitle(onOffTitle);
  }

  /** @param label String label describing the switch */
  /**
   * Constructor for SwitchButton.
   *
   * @param label a {@link java.lang.String} object
   */
  public SwitchButton(String label) {
    this();
    setLabel(label);
  }

  /** Creates a switch without a label */
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

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "checkbox";
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_hidden_input).toDominoElement();
  }

  /** {@inheritDoc} */
  @Override
  public Optional<Consumer<Event>> onChange() {
    return Optional.of(
        event -> {
          if (isEnabled() && !isReadOnly()) {
            withValue(isChecked(), isChangeListenersPaused());
          }
        });
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton toggleChecked(boolean silent) {
    withValue(!isChecked(), silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton toggleChecked() {
    withValue(!isChecked());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SwitchButton toggleChecked(boolean checkedState, boolean silent) {
    withValue(checkedState, silent);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Boolean getDefaultValue() {
    return isNull(defaultValue) ? false : defaultValue;
  }

  /** {@inheritDoc} */
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
   * Setter for the field <code>onTitle</code>.
   *
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
   * Setter for the field <code>offTitle</code>.
   *
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
  /**
   * Getter for the field <code>offLabelElement</code>.
   *
   * @return a {@link org.dominokit.domino.ui.utils.LazyChild} object
   */
  public LazyChild<LabelElement> getOffLabelElement() {
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

  /** {@inheritDoc} */
  @Override
  public Boolean getValue() {
    return isChecked();
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return getInputElement().element().checked;
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
  public String getStringValue() {
    return Boolean.toString(getValue());
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(Boolean value) {
    withPauseChangeListenersToggle(true, field -> getInputElement().element().checked = value);
  }

  /**
   * The SwitchButton will stretch the left label pushing the switch and the right label to the
   * right keeping the left label on the left
   *
   * @return same SwitchButton instance
   */
  public SwitchButton grow() {
    addCss(BooleanCssClass.of(dui_switch_grow, true));
    return this;
  }

  /**
   * reverse the effect if {@link #grow()}
   *
   * @return same SwitchButton instance
   */
  public SwitchButton ungrow() {
    addCss(BooleanCssClass.of(dui_switch_grow, false));
    return this;
  }

  /**
   * switch between {@link #grow()} if true and {@link #ungrow()} if false
   *
   * @return same SwitchButton instance
   * @param grow a boolean
   */
  public SwitchButton grow(boolean grow) {
    addCss(BooleanCssClass.of(dui_switch_grow, grow));
    return this;
  }

  /**
   * Will force SwitchButton labels closer to the switch track , in case of {@link #grow()} the
   * right label will be pushed to the right closer to the track
   *
   * @return same SwitchButton instance
   */
  public SwitchButton condenseLabels() {
    addCss(BooleanCssClass.of(dui_switch_condense, true));
    return this;
  }

  /**
   * reverse the effect if {@link #condenseLabels()}
   *
   * @return same SwitchButton instance
   */
  public SwitchButton uncondenseLabels() {
    addCss(BooleanCssClass.of(dui_switch_condense, false));
    return this;
  }

  /**
   * switch between {@link #condenseLabels()} if true and {@link #uncondenseLabels()} if false
   *
   * @return same SwitchButton instance
   * @param grow a boolean
   */
  public SwitchButton condenseLabels(boolean grow) {
    addCss(BooleanCssClass.of(dui_switch_condense, grow));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return getInputElement().element().name;
  }

  /** {@inheritDoc} */
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
