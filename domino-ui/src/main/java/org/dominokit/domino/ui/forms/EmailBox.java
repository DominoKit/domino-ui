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

import java.util.HashMap;
import java.util.Map;
import org.dominokit.domino.ui.elements.DataListElement;
import org.dominokit.domino.ui.elements.OptionElement;

/**
 * Represents an email input form field with optional data list support for autocompletion. This
 * class extends from {@link BaseTextBox} and implements the {@link HasInputDataList} interface.
 *
 * <p>Usage example:
 *
 * <pre>
 * EmailBox defaultEmailBox = new EmailBox();
 * EmailBox labeledEmailBox = new EmailBox("Enter your email:");
 * </pre>
 *
 * @see BaseTextBox
 * @see HasInputDataList
 */
public class EmailBox extends BaseTextBox<EmailBox> implements HasInputDataList<EmailBox> {

  private DataListElement dataListElement;
  private Map<String, OptionElement> dataListOptions;

  /** Default constructor. Initializes the email box with data list support. */
  public EmailBox() {
    initDataList();
  }

  /** Initializes the data list for the email box. */
  private void initDataList() {
    this.dataListElement = datalist();
    this.dataListOptions = new HashMap<>();
    bindDataList(this);
  }

  /**
   * Constructor that initializes the email box with the given label and data list support.
   *
   * @param label the label for the email box
   */
  public EmailBox(String label) {
    super(label);
    initDataList();
  }

  /**
   * Factory method to create a new instance of {@link EmailBox}.
   *
   * @return a new instance of EmailBox
   */
  public static EmailBox create() {
    return new EmailBox();
  }

  /**
   * Factory method to create a new instance of {@link EmailBox} with a label.
   *
   * @param label the label for the email box
   * @return a new instance of EmailBox with the provided label
   */
  public static EmailBox create(String label) {
    return new EmailBox(label);
  }

  /**
   * Retrieves the input type for the email box, which is "email". {@inheritDoc}
   *
   * @return the string "email"
   */
  @Override
  public String getType() {
    return "email";
  }

  /**
   * Sets the "multiple" attribute for the email input element. This allows multiple email
   * addresses.
   *
   * @param multiple true to allow multiple email addresses, false otherwise
   * @return the current EmailBox instance for method chaining
   */
  public EmailBox setMultiple(boolean multiple) {
    if (multiple) {
      getInputElement().setAttribute("multiple", multiple);
    } else {
      getInputElement().removeAttribute("multiple");
    }
    return this;
  }

  /**
   * Retrieves the data list element associated with the email box. {@inheritDoc}
   *
   * @return the {@link DataListElement} instance for the email box
   */
  @Override
  public DataListElement getDataListElement() {
    return dataListElement;
  }

  /**
   * Retrieves the data list options for the email box. {@inheritDoc}
   *
   * @return a map containing the options for the email box's data list
   */
  @Override
  public Map<String, OptionElement> getDataListOptions() {
    return dataListOptions;
  }
}
