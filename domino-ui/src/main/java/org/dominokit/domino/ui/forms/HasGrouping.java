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
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.forms.validations.ValidationResult;
import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.Editor;

/**
 * The {@code HasGrouping} interface provides methods to group and ungroup form fields, perform
 * validations, and handle errors.
 *
 * @param <T> The concrete type implementing this interface.
 */
public interface HasGrouping<T>
    extends AcceptDisable<T>, AcceptReadOnly<T>, IsRequired<T>, HasValidation<T>, Clearable<T> {

  /**
   * Groups this form element by adding it to the specified {@link FieldsGrouping}.
   *
   * @param fieldsGrouping The {@link FieldsGrouping} to group by.
   * @return The updated instance of the concrete type implementing this interface.
   */
  @Editor.Ignore
  T groupBy(FieldsGrouping fieldsGrouping);

  /**
   * Ungroups this form element by removing it from the specified {@link FieldsGrouping}.
   *
   * @param fieldsGrouping The {@link FieldsGrouping} to ungroup from.
   * @return The updated instance of the concrete type implementing this interface.
   */
  @Editor.Ignore
  T ungroup(FieldsGrouping fieldsGrouping);

  /**
   * Checks if this form element is empty.
   *
   * @return {@code true} if the form element is empty, {@code false} otherwise.
   */
  @Editor.Ignore
  boolean isEmpty();

  /**
   * Checks if this form element is empty, ignoring spaces.
   *
   * @return {@code true} if the form element is empty (ignoring spaces), {@code false} otherwise.
   */
  @Editor.Ignore
  boolean isEmptyIgnoreSpaces();

  /**
   * Sets whether to fix errors position for this form element.
   *
   * @param fixErrorsPosition {@code true} to fix errors position, {@code false} otherwise.
   * @return The updated instance of the concrete type implementing this interface.
   */
  @Editor.Ignore
  T fixErrorsPosition(boolean fixErrorsPosition);

  /**
   * Validates this form element and returns the validation result.
   *
   * @return The {@link ValidationResult} of the validation.
   */
  default ValidationResult validate() {
    return validate((T) this);
  }
}
