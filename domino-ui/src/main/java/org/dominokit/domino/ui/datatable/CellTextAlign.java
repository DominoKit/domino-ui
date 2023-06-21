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
package org.dominokit.domino.ui.datatable;

import static org.dominokit.domino.ui.style.SpacingCss.*;

import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

/**
 * CellTextAlign class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public enum CellTextAlign implements HasCssClass {
  LEFT(dui_text_left),
  RIGHT(dui_text_right),
  CENTER(dui_text_center),
  JUSTIFY(dui_text_justify),
  INHERIT(dui_text_inherit),
  CURRENT(dui_text_current);

  private final CssClass cssClass;

  CellTextAlign(CssClass alignCss) {
    this.cssClass = alignCss;
  }

  /** {@inheritDoc} */
  @Override
  public CssClass getCssClass() {
    return cssClass;
  }
}
