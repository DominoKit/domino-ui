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

import org.dominokit.domino.ui.style.IsCssClass;

/** An enum representing the wrapping of the layout */
public enum FlexWrap implements IsCssClass {
  /** No wrap of the items */
  NO_WRAP(FlexStyles.FLEX_WRAP_NOWRAP),
  /** Wrap the items from top to bottom */
  WRAP_TOP_TO_BOTTOM(FlexStyles.FLEX_WRAP_WRAP),
  /** Wrap the items from bottom to top */
  WRAP_BOTTOM_TO_TOP(FlexStyles.FLEX_WRAP_WRAP_REVERSE);

  private final String style;

  FlexWrap(String style) {
    this.style = style;
  }

  /** {@inheritDoc} */
  @Override
  public String getStyle() {
    return style;
  }
}
