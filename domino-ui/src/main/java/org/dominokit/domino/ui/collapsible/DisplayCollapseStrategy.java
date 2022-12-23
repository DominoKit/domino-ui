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
package org.dominokit.domino.ui.collapsible;

import static org.dominokit.domino.ui.collapsible.Collapsible.DUI_COLLAPSED;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.DominoCss;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * An implementation of {@link CollapseStrategy} that uses the css display property to hide/show the
 * collapsible element
 */
public class DisplayCollapseStrategy implements CollapseStrategy, CollapsibleStyles, DominoCss {

  /** {@inheritDoc} */
  @Override
  public void show(HTMLElement element) {
    DominoElement.of(element).removeCss(dui_hidden).removeAttribute(DUI_COLLAPSED);
  }

  /** {@inheritDoc} */
  @Override
  public void hide(HTMLElement element) {
    DominoElement.of(element).addCss(dui_hidden).setAttribute(DUI_COLLAPSED, "true");
  }
}
