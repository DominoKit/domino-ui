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
package org.dominokit.domino.ui.cards;

import static org.dominokit.domino.ui.cards.CardStyles.ACTION_ICON;
import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component for header action of the {@link Card}.
 *
 * <p>This component has icon and event listener to be called when the action gets executed.
 *
 * @see BaseDominoElement
 * @see Card
 * @see Card#addHeaderAction(HeaderAction)
 */
public class HeaderAction extends BaseDominoElement<HTMLLIElement, HeaderAction> {

  private final HTMLLIElement element = li().element();
  private final HTMLAnchorElement anchorElement = a().element();
  private final BaseIcon<?> icon;

  /**
   * Creates header action with icon and event listener
   *
   * @param icon the {@link BaseIcon} of the action
   * @param eventListener The {@link EventListener} to be called when execute the action
   * @return new instance
   */
  public static HeaderAction create(BaseIcon<?> icon, EventListener eventListener) {
    return new HeaderAction(icon, eventListener);
  }

  /**
   * Creates header action with icon
   *
   * @param icon the {@link BaseIcon} of the action
   * @return new instance
   */
  public static HeaderAction create(BaseIcon<?> icon) {
    return new HeaderAction(icon);
  }

  public HeaderAction(BaseIcon<?> icon) {
    this.icon = icon;
    this.icon.clickable().addCss(GenericCss.pull_right, ACTION_ICON);
    anchorElement.appendChild(this.icon.element());
    element.appendChild(anchorElement);
    init(this);
  }

  public HeaderAction(BaseIcon<?> icon, EventListener eventListener) {
    this(icon);
    anchorElement.addEventListener("click", eventListener);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return element;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return anchorElement;
  }

  /** @return The action {@link BaseIcon} */
  public BaseIcon<?> getIcon() {
    return icon;
  }
}
