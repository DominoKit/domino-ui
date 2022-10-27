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
package org.dominokit.domino.ui.button;

import org.dominokit.domino.ui.style.CssClass;

import static org.dominokit.domino.ui.style.GenericCss.*;

/**
 * An enum that lists all predefined button sizes. each enum value represent one css class that
 * changes the button height.
 */
public enum ButtonSize {
  /** Large height */
  LARGE(dui_large),
  /** Medium height */
  MEDIUM(dui_medium),
  /** Small height */
  SMALL(dui_small),
  /** smaller height */
  XSMALL(dui_xsmall);

  private CssClass style;

  /** @param style String css class name */
  ButtonSize(CssClass style) {
    this.style = style;
  }

  /** @return String css class name for a button size */
  public CssClass getStyle() {
    return style;
  }
}
