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
 * The {@code LeftDrawerSize} enum represents different size options for the left drawer in an
 * application layout.
 */
public enum LeftDrawerSize {

  /** Represents the extra-small size for the left drawer. */
  XSMALL(AppLayoutStyles.dui_left_xsmall),

  /** Represents the small size for the left drawer. */
  SMALL(AppLayoutStyles.dui_left_small),

  /** Represents the medium size for the left drawer. */
  MEDIUM(AppLayoutStyles.dui_left_medium),

  /** Represents the large size for the left drawer. */
  LARGE(AppLayoutStyles.dui_left_large),

  /** Represents the extra-large size for the left drawer. */
  XLARGE(AppLayoutStyles.dui_left_xlarge);

  private CssClass cssClass;

  /**
   * Constructs a {@code LeftDrawerSize} enum with the associated CSS class.
   *
   * @param cssClass The CSS class associated with the size.
   */
  LeftDrawerSize(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Gets the CSS class associated with the left drawer size.
   *
   * @return The CSS class associated with the size.
   */
  public CssClass getCssClass() {
    return cssClass;
  }
}
