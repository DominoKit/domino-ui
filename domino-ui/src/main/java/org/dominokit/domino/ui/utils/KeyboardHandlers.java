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

package org.dominokit.domino.ui.utils;

/** An interface for defining keyboard event handlers. */
public interface KeyboardHandlers {

  /** Functional interface for handling the 'Escape' key press event. */
  @FunctionalInterface
  interface EscapeHandler {
    /** Called when the 'Escape' key is pressed. */
    void onEscape();
  }

  /** Functional interface for handling the 'Arrow Down' key press event. */
  @FunctionalInterface
  interface ArrowDownHandler {
    /** Called when the 'Arrow Down' key is pressed. */
    void onArrowDown();
  }

  /** Functional interface for handling the 'Arrow Up' key press event. */
  @FunctionalInterface
  interface ArrowUpHandler {
    /** Called when the 'Arrow Up' key is pressed. */
    void onArrowUp();
  }

  /** Functional interface for handling the 'Tab' key press event. */
  @FunctionalInterface
  interface TabHandler {
    /** Called when the 'Tab' key is pressed. */
    void onTab();
  }
}
