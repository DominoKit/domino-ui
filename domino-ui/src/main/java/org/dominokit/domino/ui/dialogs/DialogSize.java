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
package org.dominokit.domino.ui.dialogs;

import static org.dominokit.domino.ui.style.GenericCss.*;

import org.dominokit.domino.ui.style.CssClass;

/** An enum to list modal possible zises */
public enum DialogSize {
  /** Very small modal with smaller width */
  VERY_SMALL(dui_w_xsmall, dui_h_xsmall),
  /** Small modal with small width */
  SMALL(dui_w_small, dui_h_small),
  /** Medium modal with moderate width */
  MEDIUM(dui_w_medium, dui_h_medium),
  /** Large modal with wide width */
  LARGE(dui_w_large, dui_h_large),
  /** Very large modal with wider width */
  VERY_LARGE(dui_w_xlarge, dui_h_xlarge);

  CssClass widthStyle;
  CssClass heightStyle;

  /** @param widthStyle String css style name */
  DialogSize(CssClass widthStyle, CssClass heightStyle) {
    this.widthStyle = widthStyle;
    this.heightStyle = heightStyle;
  }
}
