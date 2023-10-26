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
 * Represents a text input form field. This class extends from {@link BaseTextBox} and provides a
 * simple way to handle text input.
 *
 * <p>Usage example:
 *
 * <pre>
 * TextBox defaultTextBox = new TextBox();
 * TextBox labeledTextBox = new TextBox("Enter some text:");
 * </pre>
 *
 * @see BaseTextBox
 * @see TextInputFormField
 * @see CountableInputFormField
 * @see InputFormField
 */
public class TextBox extends BaseTextBox<TextBox> {

  /**
   * Factory method to create a new instance of {@link TextBox}.
   *
   * @return a new instance of TextBox
   */
  public static TextBox create() {
    return new TextBox();
  }

  /**
   * Factory method to create a new instance of {@link TextBox} with a label.
   *
   * @param label the label for the text box
   * @return a new instance of TextBox with the provided label
   */
  public static TextBox create(String label) {
    return new TextBox(label);
  }

  /** Default constructor. Initializes the text box. */
  public TextBox() {}

  /**
   * Constructor that initializes the text box with the given label.
   *
   * @param label the label for the text box
   */
  public TextBox(String label) {
    super(label);
  }

  /**
   * Retrieves the input type for the text box, which is "text". {@inheritDoc}
   *
   * @return the string "text"
   */
  @Override
  public String getType() {
    return "text";
  }
}
