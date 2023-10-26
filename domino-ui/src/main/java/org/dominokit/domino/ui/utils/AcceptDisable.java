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
 * The {@code AcceptDisable} interface defines methods for enabling, disabling, and checking the
 * enabled state of an object. This interface is typically used with UI components to control their
 * interaction state, such as enabling or disabling user input.
 *
 * @param <T> The type of object that can be enabled or disabled.
 */
public interface AcceptDisable<T> {

  /**
   * Enables the object, allowing it to interact with user input and other actions.
   *
   * @return The object after enabling.
   */
  @Editor.Ignore
  T enable();

  /**
   * Disables the object, preventing it from interacting with user input and other actions.
   *
   * @return The object after disabling.
   */
  @Editor.Ignore
  T disable();

  /**
   * Checks if the object is currently enabled.
   *
   * @return {@code true} if the object is enabled, {@code false} if it is disabled.
   */
  @Editor.Ignore
  boolean isEnabled();
}
