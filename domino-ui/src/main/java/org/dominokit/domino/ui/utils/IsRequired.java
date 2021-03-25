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
 * Components that need to have required value validation should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
public interface IsRequired<T> {

  /**
   * @param required boolean, true to make the component value as required
   * @return same implementing component instance
   */
  @Editor.Ignore
  T setRequired(boolean required);

  /**
   * @param required boolean, true to make the component value required
   * @param message String to show as error message when the value is missing
   * @return same implementing component instance
   */
  @Editor.Ignore
  T setRequired(boolean required, String message);

  /** @return boolean, true if the component value is required */
  @Editor.Ignore
  boolean isRequired();

  /**
   * @param requiredErrorMessage String error message to show when the value is missing
   * @return same implementing component instance
   */
  @Editor.Ignore
  T setRequiredErrorMessage(String requiredErrorMessage);

  /** @return String required error message */
  @Editor.Ignore
  String getRequiredErrorMessage();
}
