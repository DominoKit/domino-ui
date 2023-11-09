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
package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.style.CssClass;

/**
 * The {@code RightDrawerSize} enum represents different sizes for the right drawer in an
 * application layout.
 */
public enum RightDrawerSize {
  /** Extra-small right drawer size. */
  XSMALL(AppLayoutStyles.dui_right_xsmall),

  /** Small right drawer size. */
  SMALL(AppLayoutStyles.dui_right_small),

  /** Medium right drawer size. */
  MEDIUM(AppLayoutStyles.dui_right_medium),

  /** Large right drawer size. */
  LARGE(AppLayoutStyles.dui_right_large),

  /** Extra-large right drawer size. */
  XLARGE(AppLayoutStyles.dui_right_xlarge);

  private CssClass cssClass;

  /**
   * Creates a {@code RightDrawerSize} enum value with the associated CSS class.
   *
   * @param cssClass The CSS class associated with the right drawer size.
   */
  RightDrawerSize(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Gets the CSS class associated with the right drawer size.
   *
   * @return The CSS class associated with the right drawer size.
   */
  public CssClass getCssClass() {
    return cssClass;
  }
}
