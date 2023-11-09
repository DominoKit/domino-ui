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

import org.dominokit.domino.ui.forms.AutoValidator;
import org.gwtproject.editor.client.Editor;

/**
 * The {@code HasAutoValidation} interface defines methods for enabling and configuring
 * auto-validation behavior for an object of type {@code T}.
 *
 * @param <T> The type on which auto-validation can be configured and performed.
 */
public interface HasAutoValidation<T> {

  /**
   * Sets whether auto-validation should be enabled for the object of type {@code T}.
   *
   * @param autoValidation {@code true} to enable auto-validation, {@code false} to disable it.
   * @return The modified object of type {@code T} with auto-validation configured.
   */
  @Editor.Ignore
  T setAutoValidation(boolean autoValidation);

  /**
   * Checks if auto-validation is currently enabled for the object of type {@code T}.
   *
   * @return {@code true} if auto-validation is enabled, {@code false} otherwise.
   */
  @Editor.Ignore
  boolean isAutoValidation();

  /**
   * Manually triggers the auto-validation process for the object of type {@code T}.
   *
   * @return The modified object of type {@code T} after auto-validation.
   */
  T autoValidate();

  /**
   * Creates an instance of {@link AutoValidator} with the provided {@code autoValidate} function,
   * which can be used to perform custom auto-validation logic.
   *
   * @param autoValidate The {@link ApplyFunction} representing the custom auto-validation logic.
   * @return An {@link AutoValidator} instance for custom auto-validation.
   */
  AutoValidator createAutoValidator(ApplyFunction autoValidate);
}
