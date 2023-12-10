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
package org.dominokit.domino.ui.pagination;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Represents a navigation item within a pager, typically used for pagination controls.
 *
 * @see BaseDominoElement
 */
class PagerNavItem extends BaseDominoElement<HTMLLIElement, PagerNavItem>
    implements PaginationStyles {

  private LIElement root;
  private AnchorElement link;
  private final int page;

  /**
   * Creates a PagerNavItem from a given HTML Node.
   *
   * @param node The HTML Node to create the PagerNavItem from.
   * @return A new PagerNavItem instance.
   */
  public static PagerNavItem create(Node node) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(node);
  }

  /**
   * Creates a PagerNavItem from a given IsElement instance.
   *
   * @param element The IsElement instance to create the PagerNavItem from.
   * @return A new PagerNavItem instance.
   */
  public static PagerNavItem create(IsElement<?> element) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(element);
  }

  /**
   * Creates a PagerNavItem with a navigation icon.
   *
   * @param icon The Icon instance to be used as the navigation icon.
   * @return A new PagerNavItem instance with the provided navigation icon.
   */
  public static PagerNavItem nav(Icon<?> icon) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(icon.addCss(dui_page_icon, dui_clickable));
  }

  /**
   * Creates a PagerNavItem with a numeric page.
   *
   * @param page The numeric page value.
   * @return A new PagerNavItem instance representing the specified page.
   */
  public static PagerNavItem page(int page) {
    return new PagerNavItem(page)
        .withLink(
            (parent, self) ->
                self.addCss(dui_page_link, dui_clickable).setTextContent(String.valueOf(page)));
  }

  /**
   * Creates an empty PagerNavItem.
   *
   * @return A new PagerNavItem instance.
   */
  public static PagerNavItem create() {
    return new PagerNavItem(-1);
  }

  /**
   * Constructs a PagerNavItem with a given page number.
   *
   * @param page The numeric page value associated with this navigation item.
   */
  public PagerNavItem(int page) {
    this.page = page;
    root = li().addCss(dui_pager_item).appendChild(link = a());
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getAppendTarget() {
    return link.element();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement getClickableElement() {
    return link.element();
  }

  /**
   * Gets the anchor element associated with this PagerNavItem.
   *
   * @return The AnchorElement of this PagerNavItem.
   */
  public AnchorElement getLink() {
    return link;
  }

  /**
   * Applies a handler to the anchor element of this PagerNavItem.
   *
   * @param handler The ChildHandler to apply to the anchor element.
   * @return This PagerNavItem instance.
   */
  public PagerNavItem withLink(ChildHandler<PagerNavItem, AnchorElement> handler) {
    handler.apply(this, link);
    return this;
  }

  /**
   * Gets the page number associated with this PagerNavItem.
   *
   * @return The numeric page value.
   */
  public int getPage() {
    return page;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return root.element();
  }
}
