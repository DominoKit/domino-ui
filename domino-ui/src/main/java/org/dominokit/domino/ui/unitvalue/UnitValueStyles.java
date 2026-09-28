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
package org.dominokit.domino.ui.unitvalue;

import org.dominokit.domino.ui.style.CssClass;

/** CSS hooks for the {@link UnitValue} component and its content. */
public interface UnitValueStyles {

  /** The root UnitValue element. */
  CssClass dui_unit_value = () -> "dui-unit-value";

  /** The optional title element. */
  CssClass dui_unit_value_title = () -> "dui-unit-value-title";

  /** The value and unit row. */
  CssClass dui_unit_value_row = () -> "dui-unit-value-value-row";

  /** The pre-formatted value element. */
  CssClass dui_unit_value_value = () -> "dui-unit-value-value";

  /** The optional unit or symbol element. */
  CssClass dui_unit_value_unit = () -> "dui-unit-value-unit";

  /** The optional description element. */
  CssClass dui_unit_value_description = () -> "dui-unit-value-description";
}
