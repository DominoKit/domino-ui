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

import org.gwtproject.editor.client.Editor;

/**
 * An interface for objects that can be cleared, optionally with a silent flag.
 *
 * @param <T> The type of the object that can be cleared.
 */
public interface Clearable<T> {

  /**
   * Clears the object.
   *
   * @return The cleared object of type {@code T}.
   */
  @Editor.Ignore
  T clear();

  /**
   * Clears the object with an optional silent flag.
   *
   * @param silent {@code true} to clear the object silently, {@code false} otherwise.
   * @return The cleared object of type {@code T}.
   */
  @Editor.Ignore
  T clear(boolean silent);
}
