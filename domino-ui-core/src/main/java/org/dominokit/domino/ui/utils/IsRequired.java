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
 * An interface representing a component that can be marked as required.
 *
 * @param <T> The type of the component that implements this interface.
 */
public interface IsRequired<T> {

  /**
   * Sets whether the component is required.
   *
   * @param required {@code true} if the component is required, {@code false} otherwise.
   * @return The component instance after setting the required state.
   */
  @Editor.Ignore
  T setRequired(boolean required);

  /**
   * Sets whether the component is required along with a custom error message.
   *
   * @param required {@code true} if the component is required, {@code false} otherwise.
   * @param requiredMessage The custom error message to display if the component is empty and
   *     required.
   * @return The component instance after setting the required state and error message.
   */
  @Editor.Ignore
  T setRequired(boolean required, String message);

  /**
   * Checks if the component is required.
   *
   * @return {@code true} if the component is required, {@code false} otherwise.
   */
  @Editor.Ignore
  boolean isRequired();

  /**
   * Sets the error message to display if the component is empty and required.
   *
   * @param requiredErrorMessage The error message to display.
   * @return The component instance after setting the error message.
   */
  @Editor.Ignore
  T setRequiredErrorMessage(String requiredErrorMessage);

  /**
   * Gets the current error message for the required state.
   *
   * @return The current error message.
   */
  @Editor.Ignore
  String getRequiredErrorMessage();
}
