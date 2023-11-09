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
package org.dominokit.domino.ui.grid.flex;

import static org.dominokit.domino.ui.style.SpacingCss.*;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * The {@code FlexDirection} enum represents different flex direction behaviors.
 *
 * <p>It provides options for controlling the main axis direction of flex containers and flex items.
 */
public enum FlexDirection implements HasCssClass {
  /** The main axis direction is left to right. */
  LEFT_TO_RIGHT(dui_flex_row),

  /** The main axis direction is right to left. */
  RIGHT_TO_LEFT(dui_flex_row_reverse),

  /** The main axis direction is top to bottom. */
  TOP_TO_BOTTOM(dui_flex_col),

  /** The main axis direction is bottom to top. */
  BOTTOM_TO_TOP(dui_flex_col_reverse);

  private final CssClass style;

  /**
   * Constructs a new {@code FlexDirection} enum value with the associated CSS class.
   *
   * @param style The CSS class representing the flex direction behavior.
   */
  FlexDirection(CssClass style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
