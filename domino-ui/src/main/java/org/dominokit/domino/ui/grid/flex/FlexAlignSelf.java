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
 * The {@code FlexAlignSelf} enum represents different alignment behaviors for individual flex
 * items.
 *
 * <p>It provides options for controlling the alignment of individual flex items along the cross
 * axis within a flex container.
 */
public enum FlexAlignSelf implements HasCssClass {
  /** The default alignment behavior. The item inherits its parent's alignment. */
  AUTO(dui_self_auto),

  /** Aligns the item to the start of the cross axis. */
  START(dui_self_start),

  /** Aligns the item to the end of the cross axis. */
  END(dui_self_end),

  /** Centers the item along the cross axis. */
  CENTER(dui_self_center),

  /** Stretches the item to fill the cross axis. */
  STRETCH(dui_self_stretch),

  /** Aligns the item's baseline with the baseline of the parent item. */
  BASE_LINE(dui_self_baseline);

  private final CssClass style;

  /**
   * Constructs a new {@code FlexAlignSelf} enum value with the associated CSS class.
   *
   * @param style The CSS class representing the alignment behavior for flex items.
   */
  FlexAlignSelf(CssClass style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return style;
  }
}
