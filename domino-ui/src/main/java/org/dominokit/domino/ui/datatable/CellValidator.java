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

package org.dominokit.domino.ui.datatable;

import org.dominokit.domino.ui.forms.validations.ValidationResult;

/**
 * A functional interface representing a validator for a data table cell. This interface defines the
 * validation behavior for individual cells in a data table. Implementing this interface allows for
 * custom validation logic to be applied to cell values.
 */
@FunctionalInterface
public interface CellValidator {

  /**
   * Executes the validation logic for a cell.
   *
   * @return a {@link ValidationResult} object indicating the result of the validation.
   */
  ValidationResult onValidate();
}
