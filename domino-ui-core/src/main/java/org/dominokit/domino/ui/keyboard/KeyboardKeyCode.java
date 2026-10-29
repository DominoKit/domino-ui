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

import java.util.Set;

/**
 * General contract for keyboard key codes. Allows the enum (and any future implementations) to
 * expose the raw browser KeyboardEvent.code strings.
 */
public interface KeyboardKeyCode {

  /** All associated KeyboardEvent.code strings for this key. */
  Set<String> getCodes();

  /** A convenience method to check if this key matches a given code. */
  default boolean matchesCode(String code) {
    return code != null && getCodes().contains(code);
  }

  /** Optional convenience: primary / canonical code (first one). */
  default String getPrimaryCode() {
    return getCodes().stream().findFirst().orElse(null);
  }

  /**
   * @return {@code true} if this is any modifier key (Ctrl/Shift/Alt/Meta, any side).
   */
  public boolean isModifier();

  /**
   * @return {@code true} if this is a lock key (CapsLock, NumLock, ScrollLock).
   */
  public boolean isLockKey();

  /**
   * @return {@code true} if this is a navigation / cursor key.
   */
  public boolean isNavigationKey();

  /**
   * @return {@code true} if this is one of the function keys F1..F24.
   */
  public boolean isFunctionKey();

  /**
   * @return {@code true} if this is any numpad key.
   */
  public boolean isNumpadKey();
}
