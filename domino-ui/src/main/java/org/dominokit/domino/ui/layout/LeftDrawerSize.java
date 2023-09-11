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

/** LeftDrawerSize class. */
public enum LeftDrawerSize {
  XSMALL(AppLayoutStyles.dui_left_xsmall),
  SMALL(AppLayoutStyles.dui_left_small),
  MEDIUM(AppLayoutStyles.dui_left_medium),
  LARGE(AppLayoutStyles.dui_left_large),
  XLARGE(AppLayoutStyles.dui_left_xlarge),
  ;

  private CssClass cssClass;

  LeftDrawerSize(CssClass cssClass) {
    this.cssClass = cssClass;
  }

  /**
   * Getter for the field <code>cssClass</code>.
   *
   * @return a {@link org.dominokit.domino.ui.style.CssClass} object
   */
  public CssClass getCssClass() {
    return cssClass;
  }
}
