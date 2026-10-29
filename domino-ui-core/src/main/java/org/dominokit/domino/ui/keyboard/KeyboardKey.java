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
 * Defines a keyboard key representation used by Domino UI keyboard helpers.
 *
 * <p>Implementations typically map a key to one or more string values returned by the browser (for
 * example, {@code "ArrowUp"} and {@code "arrowup"}). Helper methods are provided to match an
 * incoming key string and to read a primary key value.
 */
public interface KeyboardKey {

  /**
   * Returns all string representations associated with this key.
   *
   * @return a set of key strings, never {@code null}
   */
  Set<String> getKeys();

  /**
   * Checks whether the provided key string matches any of this key's representations.
   *
   * @param key the key value from a {@link elemental2.dom.KeyboardEvent}
   * @return {@code true} if the key matches, otherwise {@code false}
   */
  default boolean matchesKey(String key) {
    return key != null && getKeys().contains(key);
  }

  /**
   * Returns the first key representation for this key, or {@code null} if none exist.
   *
   * @return the primary key string or {@code null}
   */
  default String getPrimaryKey() {
    return getKeys().stream().findFirst().orElse(null);
  }

  /**
   * Indicates if the key is a modifier key such as Shift, Control, Alt, or Meta.
   *
   * @return {@code true} when the key is a modifier
   */
  public boolean isModifier();

  /**
   * Indicates if the key is one of the lock keys (CapsLock, NumLock, ScrollLock).
   *
   * @return {@code true} when the key is a lock key
   */
  public boolean isLockKey();

  /**
   * Indicates if the key is used for navigation (arrow keys, Home/End, PageUp/PageDown, Insert,
   * Delete).
   *
   * @return {@code true} when the key is a navigation key
   */
  public boolean isNavigationKey();

  /**
   * Indicates if the key is a function key (F1–F24).
   *
   * @return {@code true} when the key is a function key
   */
  public boolean isFunctionKey();

  /**
   * Indicates if the key belongs to the numpad group.
   *
   * @return {@code true} when the key is a numpad key
   */
  public boolean isNumpadKey();
}
