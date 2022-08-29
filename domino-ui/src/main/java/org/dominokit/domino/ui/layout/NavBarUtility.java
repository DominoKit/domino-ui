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

import static org.dominokit.domino.ui.layout.NavBarStyles.UTILITY;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

public class NavBarUtility extends BaseDominoElement<HTMLElement, NavBarUtility> {

  private DominoElement<HTMLElement> root;

  public static NavBarUtility of(HTMLElement element) {
    return new NavBarUtility(element);
  }

  public static NavBarUtility of(IsElement<? extends HTMLElement> element) {
    return new NavBarUtility(element);
  }

  public NavBarUtility(HTMLElement element) {
    root = DominoElement.of(element).addCss(UTILITY);
    init(this);
  }

  public NavBarUtility(IsElement<? extends HTMLElement> element) {
    this(element.element());
  }

  @Override
  public HTMLElement element() {
    return root.element();
  }
}
