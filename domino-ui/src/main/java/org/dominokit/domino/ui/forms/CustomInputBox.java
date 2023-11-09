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

import elemental2.dom.HTMLInputElement;
import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.OptionElement;
import org.dominokit.domino.ui.forms.validations.InputAutoValidator;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Represents a customizable input box that can be associated with a list of pre-defined options.
 *
 * <p>Usage example:
 *
 * <pre>
 * CustomInputBox customInput = new CustomInputBox("Label");
 * customInput.setType("text");
 * </pre>
 *
 * @param <T> the type of the derived class, used for method chaining
 */
public abstract class CustomInputBox<T extends CustomInputBox<T>>
    extends TextInputFormField<T, HTMLInputElement, String> implements HasInputDataList<T> {
  private DataListElement dataListElement;
  private Map<String, OptionElement> dataListOptions;
  private boolean emptyAsNull;

  /** Default constructor that initializes the data list element and its options. */
  public CustomInputBox() {
    this.dataListElement = datalist();
    this.dataListOptions = new HashMap<>();
    init();
  }

  /**
   * Constructor that initializes the input box with the given label.
   *
   * @param label the label for the input box
   */
  public CustomInputBox(String label) {
    this();
    setLabel(label);
  }

  /** Internal method to initialize and bind the data list. */
  private void init() {
    bindDataList((T) this);
    setAutoValidation(true);
  }

  /** Creates the input element for the custom input box. {@inheritDoc} */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  /** Sets the value of the custom input box. {@inheritDoc} */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
  }

  /** Retrieves the value of the custom input box. {@inheritDoc} */
  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }

  /**
   * Sets the type for the input element.
   *
   * @param type the type for the input element
   * @return the current instance, allowing for method chaining
   */
  public T setType(String type) {
    getInputElement().element().type = type;
    return (T) this;
  }

  /** Retrieves the string representation of the value in the custom input box. {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /**
   * Determines whether to consider an empty value as null.
   *
   * @param emptyAsNull true if an empty value should be considered null; false otherwise
   * @return the current instance, allowing for method chaining
   */
  public T setEmptyAsNull(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
    return (T) this;
  }

  /**
   * Checks if the custom input box considers an empty value as null.
   *
   * @return true if an empty value is considered null; false otherwise
   */
  public boolean isEmptyAsNull() {
    return emptyAsNull;
  }

  /** Creates an auto-validator for the custom input box. {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator(autoValidate, getInputElement());
  }

  /** Retrieves the data list element associated with the custom input box. {@inheritDoc} */
  @Override
  public DataListElement getDataListElement() {
    return dataListElement;
  }

  /** Retrieves the data list options for the custom input box. {@inheritDoc} */
  @Override
  public Map<String, OptionElement> getDataListOptions() {
    return dataListOptions;
  }
}
