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
package org.dominokit.domino.ui.shaded.layout;

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.shaded.icons.BaseIcon;
import org.dominokit.domino.ui.shaded.style.Styles;
import org.dominokit.domino.ui.shaded.utils.BaseDominoElement;
import org.dominokit.domino.ui.shaded.utils.DominoElement;

/** @deprecated use {@link LayoutActionItem} */
@Deprecated
public class TopBarAction extends BaseDominoElement<HTMLLIElement, TopBarAction> {

  private HTMLLIElement element = DominoElement.of(li()).css(Styles.pull_right).element();
  private HTMLAnchorElement clickableElement =
      DominoElement.of(a()).css("js-right-sidebar").element();

  public TopBarAction(BaseIcon<?> icon) {
    element.appendChild(clickableElement);
    clickableElement.appendChild(icon.element());
    init(this);
  }

  public static TopBarAction create(BaseIcon<?> icon) {
    return new TopBarAction(icon);
  }

  @Override
  public HTMLLIElement element() {
    return element;
  }

  @Override
  public HTMLAnchorElement getClickableElement() {
    return clickableElement;
  }
}
