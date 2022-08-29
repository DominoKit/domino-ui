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

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.TakesValue;
import org.gwtproject.safehtml.shared.SafeHtml;
import org.jboss.elemento.IsElement;

/**
 * A component that represent a single option in a {@link RadioGroup}
 *
 * @param <T> The type fo the radio value
 */
public class Radio<T> extends BaseDominoElement<HTMLDivElement, Radio<T>>
    implements HasName<Radio<T>>,
        HasValue<Radio<T>, T>,
        HasLabel<Radio<T>>,
        HasHelperText<Radio<T>>,
        AcceptDisable<Radio<T>>,
        Checkable<Radio<T>>,
        TakesValue<T> {

  private DominoElement<HTMLDivElement> root;
  private DominoElement<HTMLInputElement> inputElement;
  private DominoElement<HTMLLabelElement> labelElement;
  private LazyChild<DominoElement<HTMLElement>> noteElement;
  private List<ChangeListener<? super Boolean>> changeListeners = new ArrayList<>();
  private boolean checked = false;
  private RadioGroup<? super T> radioGroup;
  private T value;

  /**
   * Creates an instance for the specified value with a label
   *
   * @param value T
   * @param label String
   */
  public Radio(T value, String label) {

    root =
        DominoElement.div()
            .addCss(FORM_RADIO)
            .appendChild(inputElement = DominoElement.input("radio").addCss(HIDDEN_INPUT))
            .appendChild(labelElement = DominoElement.label().addCss(FORM_RADIO_LABEL));
    noteElement = LazyChild.of(DominoElement.small().addCss(FORM_RADIO_NOTE), root);
    setLabel(label);
    linkLabelToField();
    value(value);
    root.addEventListener(
        "click",
        evt -> {
          if (isEnabled() && !isChecked()) check();
        });
    inputElement.addEventListener("change", evt -> onCheck());
    init(this);
  }

  /**
   * Creates an instance for the specified value without a label, the label will be the
   * String.valueOf(value)
   *
   * @param value T
   */
  public Radio(T value) {
    this(value, String.valueOf(value));
  }

  /**
   * Creates an instance for the specified value with a label
   *
   * @param value T
   * @param label String
   * @param <E> the type of the value
   * @return new Radio instance
   */
  public static <E> Radio<E> create(E value, String label) {
    return new Radio<>(value, label);
  }

  /**
   * Creates an instance for the specified value without a label, the label will be the
   * String.valueOf(value)
   *
   * @param value T
   * @param <E> the type of value
   * @return new Radio instance
   */
  public static <E> Radio<E> create(E value) {
    return new Radio<>(value);
  }

  private void linkLabelToField() {
    DominoElement<HTMLInputElement> asDominoElement = DominoElement.of(inputElement);
    if (!asDominoElement.hasAttribute("id")) {
      inputElement.setAttribute("id", asDominoElement.getDominoId());
    }
    labelElement.setAttribute("for", asDominoElement.getAttribute("id"));
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> check() {
    return check(false);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> uncheck() {
    return uncheck(false);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> check(boolean silent) {
    if (nonNull(radioGroup)) {
      if (!radioGroup.isReadOnly()) {
        radioGroup.getRadios().forEach(radio -> radio.setChecked(false));
        setChecked(true);
        if (!silent) onCheck();
      }
    } else {
      setChecked(true);
      if (!silent) onCheck();
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> uncheck(boolean silent) {
    if (nonNull(radioGroup)) {
      if (!radioGroup.isReadOnly()) {
        setChecked(false);
        if (!silent) onCheck();
      }
    } else {
      setChecked(false);
      if (!silent) onCheck();
    }

    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> addChangeListener(ChangeListener<? super Boolean> changeListener) {
    changeListeners.add(changeListener);
    return this;
  }

  private void setChecked(boolean value) {
    inputElement.element().checked = value;
    this.checked = value;
    if (this.checked) {
      element.css("checked");
    } else {
      element.removeCss("checked");
    }
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> removeChangeListener(ChangeListener<? super Boolean> changeListener) {
    if (changeListener != null) changeListeners.remove(changeListener);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeListener(ChangeListener<? super Boolean> changeListener) {
    return changeListeners.contains(changeListener);
  }

  private void onCheck() {
    for (ChangeListener<? super Boolean> checkHandler : changeListeners)
      checkHandler.onValueChanged(isChecked());
  }

  /** {@inheritDoc} */
  @Override
  public boolean isChecked() {
    return this.checked;
  }

  /**
   * Introduce a small white gap between the radio border and its check mark filling
   *
   * @return same Radio instance
   */
  public Radio<T> withGap() {
    Style.of(inputElement).addCss("with-gap");
    element.css("with-gap");
    return this;
  }

  /**
   * Removesthe small white gap between the radio border and its check mark filling
   *
   * @return same Radio instance
   */
  public Radio<T> withoutGap() {
    Style.of(inputElement).removeCss("with-gap");
    element.removeCss("with-gap");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return inputElement.element().name;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setName(String name) {
    inputElement.element().name = name;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> value(T value) {
    return value(value, false);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> value(T value, boolean silent) {
    setValue(value);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void setValue(T value) {
    this.value = value;
  }

  /** {@inheritDoc} */
  @Override
  public T getValue() {
    return this.value;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setLabel(String label) {
    labelElement.clearElement().appendChild(DominoElement.span().textContent(label));
    return this;
  }

  /** @param safeHtml {@link SafeHtml} to be used as a label */
  public Radio<T> setLabel(SafeHtml safeHtml) {
    labelElement.clearElement().setInnerHtml(safeHtml.asString());
    return this;
  }

  /** @param node {@link Node} to be used as a label */
  public Radio<T> setLabel(Node node) {
    DominoElement.of(labelElement).clearElement().appendChild(node);
    return this;
  }

  /** @param element {@link IsElement} to be used as a label */
  public Radio<T> setLabel(IsElement<?> element) {
    return setLabel(element.element());
  }

  /** {@inheritDoc} */
  @Override
  public Optional<String> getLabel() {
    return Optional.of(labelElement.element().textContent);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> enable() {
    inputElement.enable();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> disable() {
    inputElement.disable();
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getHelperText() {
    return noteElement.get().getTextContent();
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setHelperText(String text) {
    noteElement.get().setTextContent(text);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !inputElement.isDisabled();
  }

  /** @param radioGroup {@link RadioGroup} this radio belongs to */
  void setGroup(RadioGroup<? super T> radioGroup) {
    this.radioGroup = radioGroup;
  }

  /** {@inheritDoc} */
  public DominoElement<HTMLInputElement> getInputElement() {
    return inputElement;
  }

  /** {@inheritDoc} */
  public String getStringValue() {
    return String.valueOf(getValue());
  }
}
