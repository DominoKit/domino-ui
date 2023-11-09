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
 * The {@code FlexWrap} enum represents different flex wrapping behaviors.
 *
 * <p>It provides options for controlling how flex items wrap within a flex container.
 */
public enum FlexWrap implements HasCssClass {
  /** No wrapping of flex items. All flex items will be placed in a single line. */
  NO_WRAP(dui_flex_nowrap),

  /** Wrap flex items from top to bottom when they exceed the container's width. */
  WRAP_TOP_TO_BOTTOM(dui_flex_wrap),

  /** Wrap flex items from bottom to top when they exceed the container's width. */
  WRAP_BOTTOM_TO_TOP(dui_flex_wrap_reverse);

  private final CssClass style;

  /**
   * Constructs a new {@code FlexWrap} enum value with the associated CSS class.
   *
   * @param style The CSS class representing the flex wrap behavior.
   */
  FlexWrap(CssClass style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
