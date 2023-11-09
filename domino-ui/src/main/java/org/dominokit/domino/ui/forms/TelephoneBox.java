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
 * Represents a telephone input box that accepts telephone numbers.
 *
 * <p>Usage example:
 *
 * <pre>
 * TelephoneBox boxWithoutLabel = TelephoneBox.create();
 * TelephoneBox boxWithLabel = TelephoneBox.create("Phone Number:");
 * </pre>
 *
 * @see CustomInputBox
 */
public class TelephoneBox extends CustomInputBox<TelephoneBox> {

  /** Default constructor to create a telephone input box without any label. */
  public TelephoneBox() {}

  /**
   * Constructor that initializes the telephone input box with the given label.
   *
   * @param label the label for the telephone input box
   */
  public TelephoneBox(String label) {
    super(label);
  }

  /**
   * Static factory method to create a telephone input box without any label.
   *
   * @return a new instance of {@link TelephoneBox}
   */
  public static TelephoneBox create() {
    return new TelephoneBox();
  }

  /**
   * Static factory method to create a telephone input box with the given label.
   *
   * @param label the label for the telephone input box
   * @return a new instance of {@link TelephoneBox} with the specified label
   */
  public static TelephoneBox create(String label) {
    return new TelephoneBox(label);
  }

  /**
   * Retrieves the type of the input box, which is set to "tel" to accept telephone numbers.
   * {@inheritDoc}
   */
  @Override
  public String getType() {
    return "tel";
  }
}
