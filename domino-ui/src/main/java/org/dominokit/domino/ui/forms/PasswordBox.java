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
 * Represents a password input form field. This class extends from {@link BaseTextBox} and is
 * specifically tailored for password input.
 *
 * <p>Usage example:
 *
 * <pre>
 * PasswordBox defaultPasswordBox = PasswordBox.create();
 * PasswordBox labeledPasswordBox = PasswordBox.create("Enter your password:");
 * </pre>
 *
 * @see BaseTextBox
 */
public class PasswordBox extends BaseTextBox<PasswordBox> {

  /**
   * Factory method to create a new instance of {@link PasswordBox}.
   *
   * @return a new instance of PasswordBox
   */
  public static PasswordBox create() {
    return new PasswordBox();
  }

  /**
   * Factory method to create a new instance of {@link PasswordBox} with a label.
   *
   * @param label the label for the password box
   * @return a new instance of PasswordBox with the provided label
   */
  public static PasswordBox create(String label) {
    return new PasswordBox(label);
  }

  /** Default constructor. Initializes the password box. */
  public PasswordBox() {}

  /**
   * Constructor that initializes the password box with the given label.
   *
   * @param label the label for the password box
   */
  public PasswordBox(String label) {
    super(label);
  }

  /**
   * Retrieves the input type for the password box, which is "password". {@inheritDoc}
   *
   * @return the string "password"
   */
  @Override
  public String getType() {
    return "password";
  }
}
