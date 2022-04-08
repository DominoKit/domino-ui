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
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.style.Color;
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
        Switchable<Radio<T>>,
        Checkable<Radio<T>>,
        TakesValue<T>,
        HasHelperText<Radio<T>>,
        HasInputElement {

  private FlexItem<HTMLDivElement> container = FlexItem.create().addCss("radio-option");
  private HTMLLabelElement labelElement = label().element();
  private HTMLInputElement inputElement = input("radio").element();
  private DominoElement<HTMLParagraphElement> helperTextElement = DominoElement.of(p());
  private List<ChangeHandler<? super Boolean>> changeHandlers;
  private Color color;
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
    changeHandlers = new ArrayList<>();
    linkLabelToField();
    container.appendChild(labelElement);
    container.appendChild(inputElement);
    setLabel(label);
    value(value);
    container.addEventListener(
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
  public Radio<T> addChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    changeHandlers.add(changeHandler);
    return this;
  }

  private void setChecked(boolean value) {
    inputElement.checked = value;
    this.checked = value;
    if (this.checked) {
      element.css("checked");
    } else {
      element.removeCss("checked");
    }
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> removeChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    if (changeHandler != null) changeHandlers.remove(changeHandler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean hasChangeHandler(ChangeHandler<? super Boolean> changeHandler) {
    return changeHandlers.contains(changeHandler);
  }

  private void onCheck() {
    for (ChangeHandler<? super Boolean> checkHandler : changeHandlers)
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

  /**
   * Sets the color of the radio border and filling
   *
   * @param color {@link Color}
   * @return same Radio instance
   */
  public Radio<T> setColor(Color color) {
    if (this.color != null) {
      element.removeCss(this.color.getStyle());
    }
    element.css(color.getStyle());
    this.color = color;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return container.element();
  }

  /** {@inheritDoc} */
  @Override
  public String getName() {
    return inputElement.name;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setName(String name) {
    inputElement.name = name;
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
    labelElement.textContent = label;
    return this;
  }

  /** @param safeHtml {@link SafeHtml} to be used as a label */
  public Radio<T> setLabel(SafeHtml safeHtml) {
    labelElement.innerHTML = safeHtml.asString();
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
    return Optional.of(labelElement.textContent);
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> enable() {
    inputElement.disabled = false;
    element.removeCss("disabled");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> disable() {
    inputElement.disabled = true;
    element.css("disabled");
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public String getHelperText() {
    return helperTextElement.getTextContent();
  }

  /** {@inheritDoc} */
  @Override
  public Radio<T> setHelperText(String text) {
    helperTextElement.setTextContent(text);
    if (!DominoElement.of(labelElement).contains(helperTextElement.element())) {
      labelElement.appendChild(helperTextElement.element());
    }
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean isEnabled() {
    return !inputElement.disabled;
  }

  /** @param radioGroup {@link RadioGroup} this radio belongs to */
  void setGroup(RadioGroup<? super T> radioGroup) {
    this.radioGroup = radioGroup;
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLInputElement> getInputElement() {
    return DominoElement.of(inputElement);
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return String.valueOf(getValue());
  }
}
