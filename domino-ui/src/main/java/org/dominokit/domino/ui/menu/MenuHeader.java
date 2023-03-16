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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.jboss.elemento.IsElement;

/**
 * Menu header component for {@link Menu}, the header is hidden by default unless it is explicitly
 * set to visible or the user attached any header element.
 */
public class MenuHeader extends BaseDominoElement<HTMLDivElement, MenuHeader> {

  private final DominoElement<HTMLDivElement> root;
  private final LazyChild<DominoElement<HTMLElement>> titleElement;

  public MenuHeader() {
    root = div().addCss(menu_header_bar);
    titleElement = LazyChild.of(span().addCss(menu_title), root);
    init(this);
  }

  /**
   * Set the menu header icon
   *
   * @param icon {@link BaseIcon}
   * @return same header instance
   */
  public MenuHeader setIcon(BaseIcon<?> icon) {
    root.appendChild(icon.addCss(menu_icon));
    return this;
  }

  /**
   * Set the menu header title
   *
   * @param title String
   * @return same header instance
   */
  public MenuHeader setTitle(String title) {
    if (nonNull(title) && !title.isEmpty()) {
      titleElement.get().setTextContent(title);
    } else if (titleElement.isInitialized()) {
      titleElement.remove();
    }
    return this;
  }

  /**
   * Appends an element as an action to the header actions bar
   *
   * @param element {@link HTMLElement}
   * @return same header instance
   */
  public MenuHeader appendAction(HTMLElement element) {
    appendAction(() -> element);
    return this;
  }

  /**
   * Appends an element as an action to the header actions bar
   *
   * @param element {@link IsElement}
   * @return same header instance
   */
  public MenuHeader appendAction(IsElement<?> element) {
    root.appendChild(elementOf(element).addCss(menu_utility, dui_clickable));
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }
}
