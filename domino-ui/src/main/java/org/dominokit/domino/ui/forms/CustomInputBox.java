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
 * A Base implementation for special type components with text input
 *
 * @param <T> The type of the component extending from this class
 * @see TelephoneBox
 * @see EmailBox
 * @author vegegoku
 * @version $Id: $Id
 */
public abstract class CustomInputBox<T extends CustomInputBox<T>>
    extends TextInputFormField<T, HTMLInputElement, String> implements HasInputDataList<T> {
  private DataListElement dataListElement;
  private Map<String, OptionElement> dataListOptions;
  private boolean emptyAsNull;

  /** Creates an instance of the specified type with a label */
  public CustomInputBox() {
    this.dataListElement = datalist();
    this.dataListOptions = new HashMap<>();
    init();
  }

  /**
   * Creates an instance of the specified type with a label
   *
   * @param label String
   */
  public CustomInputBox(String label) {
    this();
    setLabel(label);
  }

  private void init() {
    bindDataList((T) this);
    setAutoValidation(true);
  }

  /** {@inheritDoc} */
  @Override
  protected DominoElement<HTMLInputElement> createInputElement(String type) {
    return input(type).addCss(dui_field_input).toDominoElement();
  }

  /** {@inheritDoc} */
  @Override
  protected void doSetValue(String value) {
    if (nonNull(value)) {
      getInputElement().element().value = value;
    } else {
      getInputElement().element().value = "";
    }
  }

  /** {@inheritDoc} */
  @Override
  public String getValue() {
    String value = getInputElement().element().value;
    if (value.isEmpty() && isEmptyAsNull()) {
      return null;
    }
    return value;
  }

  /**
   * Sets the type for the HTMLInputElement of this component
   *
   * @param type String
   * @return same implementing component instance
   */
  public T setType(String type) {
    getInputElement().element().type = type;
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public String getStringValue() {
    return getValue();
  }

  /** {@inheritDoc} */
  public T setEmptyAsNull(boolean emptyAsNull) {
    this.emptyAsNull = emptyAsNull;
    return (T) this;
  }

  /** @return boolean, if true empty value will be treated as null otherwise it is empty string */
  /**
   * isEmptyAsNull.
   *
   * @return a boolean
   */
  public boolean isEmptyAsNull() {
    return emptyAsNull;
  }

  /** {@inheritDoc} */
  @Override
  public AutoValidator createAutoValidator(ApplyFunction autoValidate) {
    return new InputAutoValidator(autoValidate, getInputElement());
  }

  /** {@inheritDoc} */
  @Override
  public DataListElement getDataListElement() {
    return dataListElement;
  }

  /** {@inheritDoc} */
  @Override
  public Map<String, OptionElement> getDataListOptions() {
    return dataListOptions;
  }
}
