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
package org.dominokit.domino.ui.keyboard;

/**
 * HasKeyboardEvents interface.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface HasKeyboardEvents<T> {

  /**
   * onKeyDown.
   *
   * @param onKeyDown a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a T object
   */
  T onKeyDown(KeyEventsConsumer onKeyDown);

  /**
   * stopOnKeyDown.
   *
   * @return a T object
   */
  T stopOnKeyDown();

  /**
   * onKeyUp.
   *
   * @param onKeyUp a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a T object
   */
  T onKeyUp(KeyEventsConsumer onKeyUp);

  /**
   * stopOnKeyUp.
   *
   * @return a T object
   */
  T stopOnKeyUp();

  /**
   * onKeyPress.
   *
   * @param onKeyPress a {@link org.dominokit.domino.ui.keyboard.KeyEventsConsumer} object
   * @return a T object
   */
  T onKeyPress(KeyEventsConsumer onKeyPress);

  /**
   * stopOnKeyPress.
   *
   * @return a T object
   */
  T stopOnKeyPress();

  /**
   * getKeyboardEventsOptions.
   *
   * @return a {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions} object
   */
  KeyboardEventOptions getKeyboardEventsOptions();

  /**
   * Sets the default {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}
   *
   * @param defaultOptions the default {@link org.dominokit.domino.ui.keyboard.KeyboardEventOptions}
   * @return same instance
   */
  T setDefaultOptions(KeyboardEventOptions defaultOptions);
}
