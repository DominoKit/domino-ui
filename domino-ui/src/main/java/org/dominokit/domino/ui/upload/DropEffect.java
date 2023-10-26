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
package org.dominokit.domino.ui.upload;

/**
 * An enumeration of drop effects that can be used in drag-and-drop operations. Each effect
 * represents a specific behavior when data is dragged and dropped onto a target element.
 */
public enum DropEffect {
  COPY("copy"),
  MOVE("move"),
  LINK("link"),
  NONE("none");

  /** The string representation of the drop effect. */
  private final String effect;

  /**
   * Constructs a DropEffect enum with the specified effect string.
   *
   * @param effect The string representation of the drop effect.
   */
  DropEffect(String effect) {
    this.effect = effect;
  }

  /**
   * Gets the string representation of the drop effect.
   *
   * @return The string representation of the drop effect.
   */
  public String getEffect() {
    return effect;
  }
}
