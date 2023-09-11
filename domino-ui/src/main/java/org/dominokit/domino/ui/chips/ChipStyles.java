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
package org.dominokit.domino.ui.chips;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link org.dominokit.domino.ui.chips.Chip} */
public class ChipStyles {
  /** CSS class for chip */
  public static final CssClass dui_chip = () -> "dui-chip";
  /** CSS class for chip value container */
  public static final CssClass dui_chip_value = () -> "dui-chip-value";
  /** CSS class for left element */
  public static final CssClass dui_chip_addon = () -> "dui-chip-addon";
  /** CSS class for remove element */
  public static final CssClass dui_chip_selected = () -> "dui-chip-selected";

  /** Constant <code>dui_chip_remove</code> */
  public static final CssClass dui_chip_remove = () -> "dui-chip-remove";
  /** Constant <code>dui_chip_has_addon</code> */
  public static final CssClass dui_chip_has_addon = () -> "dui-has-addon";
}
