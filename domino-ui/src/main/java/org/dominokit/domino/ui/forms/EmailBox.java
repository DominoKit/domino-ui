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
 * A component that has an input to take/provide Email(s) value
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email">Email input
 *     on MDN</a>
 * @author vegegoku
 * @version $Id: $Id
 */
public class EmailBox extends BaseTextBox<EmailBox> implements HasInputDataList<EmailBox> {

  private DataListElement dataListElement;
  private Map<String, OptionElement> dataListOptions;

  /** Creates a new instance with a label */
  public EmailBox() {
    initDataList();
  }

  private void initDataList() {
    this.dataListElement = datalist();
    this.dataListOptions = new HashMap<>();
    bindDataList(this);
  }

  /**
   * Creates a new instance with a label
   *
   * @param label String
   */
  public EmailBox(String label) {
    super(label);
    initDataList();
  }

  /** @return a new instance without a label */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.EmailBox} object
   */
  public static EmailBox create() {
    return new EmailBox();
  }

  /** @return a new instance with a label */
  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.forms.EmailBox} object
   */
  public static EmailBox create(String label) {
    return new EmailBox(label);
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "email";
  }

  /**
   * setMultiple.
   *
   * @param multiple boolean, Whether to allow multiple comma-separated e-mail addresses to be
   *     entered
   * @return Same EmailBox instance
   */
  public EmailBox setMultiple(boolean multiple) {
    if (multiple) {
      getInputElement().setAttribute("multiple", multiple);
    } else {
      getInputElement().removeAttribute("multiple");
    }
    return this;
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
