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

import static org.jboss.elemento.Elements.a;
import static org.jboss.elemento.Elements.li;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/** A component to add an action item to the {@link Layout} right side of the header */
public class LayoutActionItem extends BaseDominoElement<HTMLLIElement, LayoutActionItem> {
  private DominoElement<HTMLAnchorElement> anchorElement =
      DominoElement.of(a()).css("js-right-sidebar");
  private DominoElement<HTMLLIElement> li =
      DominoElement.of(li()).css("pull-right").add(anchorElement);

  /** @param baseIcon {@link BaseIcon} for the action */
  public LayoutActionItem(BaseIcon<?> baseIcon) {
    this(baseIcon.element());
  }

  /** @param isElement {@link IsElement} action content */
  public LayoutActionItem(IsElement<?> isElement) {
    this(isElement.element());
  }

  /**
   * @param baseIcon {@link BaseIcon} for the action
   * @return new LayoutActionItem instance
   */
  public static LayoutActionItem create(BaseIcon<?> baseIcon) {
    return new LayoutActionItem(baseIcon);
  }

  /**
   * @param isElement {@link IsElement} action content
   * @return new LayoutActionItem instance
   */
  public static LayoutActionItem create(IsElement<?> isElement) {
    return new LayoutActionItem(isElement);
  }

  /**
   * @param node {@link Node} action content
   * @return new LayoutActionItem instance
   */
  public static LayoutActionItem create(Node node) {
    return new LayoutActionItem(node);
  }

  /** @param content {@link Node} action content */
  public LayoutActionItem(Node content) {
    init(this);
    DominoElement.of(anchorElement).appendChild(content);
  }

  /** @return the {@link HTMLElement} of this component that will receive the click events */
  @Override
  public HTMLElement getClickableElement() {
    return anchorElement.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return li.element();
  }
}
