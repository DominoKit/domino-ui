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

/** TextBox class. */
public class TextBox extends BaseTextBox<TextBox> {

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.forms.TextBox} object
   */
  public static TextBox create() {
    return new TextBox();
  }

  /**
   * create.
   *
   * @param label a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.forms.TextBox} object
   */
  public static TextBox create(String label) {
    return new TextBox(label);
  }

  /** Constructor for TextBox. */
  public TextBox() {}

  /**
   * Constructor for TextBox.
   *
   * @param label a {@link java.lang.String} object
   */
  public TextBox(String label) {
    super(label);
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return "text";
  }
}
