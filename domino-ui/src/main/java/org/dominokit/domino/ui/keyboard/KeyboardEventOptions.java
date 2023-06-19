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

import org.dominokit.domino.ui.events.EvenHandlerOptions;

public class KeyboardEventOptions implements EvenHandlerOptions {
  boolean preventDefault = false;
  boolean stopPropagation = false;
  boolean withCtrlKey;
  boolean withAltKey;
  boolean withShiftKey;
  boolean withMetaKey;
  boolean repeating;

  /** @return new instance */
  public static KeyboardEventOptions create() {
    return new KeyboardEventOptions();
  }

  /**
   * Sets if prevent default behaviour is enabled or not
   *
   * @param preventDefault true to prevent default, false otherwise
   * @return same instance
   */
  public KeyboardEventOptions setPreventDefault(boolean preventDefault) {
    this.preventDefault = preventDefault;
    return this;
  }

  /**
   * Sets if stop event propagation is enabled or not
   *
   * @param stopPropagation true to stop propagation, false otherwise
   * @return same instance
   */
  public KeyboardEventOptions setStopPropagation(boolean stopPropagation) {
    this.stopPropagation = stopPropagation;
    return this;
  }

  public KeyboardEventOptions setWithCtrlKey(boolean withCtrlKey) {
    this.withCtrlKey = withCtrlKey;
    return this;
  }

  public KeyboardEventOptions setWithAltKey(boolean withAltKey) {
    this.withAltKey = withAltKey;
    return this;
  }

  public KeyboardEventOptions setWithShiftKey(boolean withShiftKey) {
    this.withShiftKey = withShiftKey;
    return this;
  }

  public KeyboardEventOptions setWithMetaKey(boolean withMetaKey) {
    this.withMetaKey = withMetaKey;
    return this;
  }

  public KeyboardEventOptions setRepeating(boolean repeating) {
    this.repeating = repeating;
    return this;
  }
}
