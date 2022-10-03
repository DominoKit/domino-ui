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

/**
 * A component that has an input to take/provide Email(s) value
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/input/email">Email input
 *     on MDN</a>
 */
public class EmailBox extends TextBox {

  /**
   * Creates a new instance with a label
   *
   */
  public EmailBox() {
  }

  /**
   * Creates a new instance with a label
   *
   * @param label String
   */
  public EmailBox(String label) {
    super(label);
  }

  /** @return a new instance without a label */
  public static EmailBox create() {
    return new EmailBox();
  }

  /** @return a new instance with a label */
  public static EmailBox create(String label) {
    return new EmailBox(label);
  }


  @Override
  public String getType() {
    return "email";
  }

  /**
   * @param multiple boolean, Whether to allow multiple comma-separated e-mail addresses to
   * be entered
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
}
