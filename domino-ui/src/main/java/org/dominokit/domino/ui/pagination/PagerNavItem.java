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

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

class PagerNavItem extends BaseDominoElement<HTMLLIElement, PagerNavItem>
    implements PaginationStyles {

  private LIElement root;
  private AnchorElement link;
  private final int page;

  /**
   * create.
   *
   * @param node a {@link elemental2.dom.Node} object
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public static PagerNavItem create(Node node) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(node);
  }

  /**
   * create.
   *
   * @param element a {@link org.dominokit.domino.ui.IsElement} object
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public static PagerNavItem create(IsElement<?> element) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(element);
  }

  /**
   * nav.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public static PagerNavItem nav(Icon<?> icon) {
    return new PagerNavItem(-1)
        .withLink((parent, link) -> link.addCss(dui_page_link))
        .appendChild(icon.addCss(dui_page_icon, dui_clickable));
  }

  /**
   * page.
   *
   * @param page a int
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public static PagerNavItem page(int page) {
    return new PagerNavItem(page)
        .withLink(
            (parent, self) ->
                self.addCss(dui_page_link, dui_clickable).setTextContent(String.valueOf(page)));
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public static PagerNavItem create() {
    return new PagerNavItem(-1);
  }

  /**
   * Constructor for PagerNavItem.
   *
   * @param page a int
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
   * Getter for the field <code>link</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
   */
  public AnchorElement getLink() {
    return link;
  }

  /**
   * withLink.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.pagination.PagerNavItem} object
   */
  public PagerNavItem withLink(ChildHandler<PagerNavItem, AnchorElement> handler) {
    handler.apply(this, link);
    return this;
  }

  /**
   * Getter for the field <code>page</code>.
   *
   * @return a int
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
