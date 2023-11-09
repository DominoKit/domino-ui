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
 * The {@code FlexJustifyContent} enum represents different options for justifying content within a
 * flex container.
 *
 * <p>It provides options for controlling how space is distributed between and around flex items
 * along the main axis within a flex container.
 */
public enum FlexJustifyContent implements HasCssClass {
  /** Aligns content at the start of the main axis. */
  START(dui_justify_start),

  /** Aligns content at the end of the main axis. */
  END(dui_justify_end),

  /** Centers content along the main axis. */
  CENTER(dui_justify_center),

  /**
   * Distributes space evenly between flex items along the main axis, with no space at the start and
   * end.
   */
  SPACE_BETWEEN(dui_justify_between),

  /**
   * Distributes space evenly around flex items along the main axis, including space at the start
   * and end.
   */
  SPACE_AROUND(dui_justify_around),

  /** Distributes space evenly between and around flex items along the main axis. */
  SPACE_EVENLY(dui_justify_evenly);

  private final CssClass style;

  /**
   * Constructs a new {@code FlexJustifyContent} enum value with the associated CSS class.
   *
   * @param style The CSS class representing the justification option for flex content.
   */
  FlexJustifyContent(CssClass style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
