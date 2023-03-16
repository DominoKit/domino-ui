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

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

class PagerNavItem extends BaseDominoElement<HTMLLIElement, PagerNavItem>
        implements PaginationStyles {

    private DominoElement<HTMLLIElement> root;
    private DominoElement<HTMLAnchorElement> link;
    private final int page;

    public static PagerNavItem create(Node node) {
        return new PagerNavItem(-1)
                .withLink((parent, link) -> link.addCss(dui_page_link))
                .appendChild(node);
    }

    public static PagerNavItem create(IsElement<?> element) {
        return new PagerNavItem(-1)
                .withLink((parent, link) -> link.addCss(dui_page_link))
                .appendChild(element);
    }

    public static PagerNavItem nav(BaseIcon<?> icon) {
        return new PagerNavItem(-1)
                .withLink((parent, link) -> link.addCss(dui_page_link))
                .appendChild(icon.addCss(dui_page_icon, dui_clickable));
    }

    public static PagerNavItem page(int page) {
        return new PagerNavItem(page)
                .withLink(
                        (parent, self) -> self
                                .addCss(dui_page_link, dui_clickable).setTextContent(String.valueOf(page)));
    }

    public static PagerNavItem create() {
        return new PagerNavItem(-1);
    }

    public PagerNavItem(int page) {
        this.page = page;
        root =
                li()
                        .addCss(dui_pager_item)
                        .appendChild(link = a());
        init(this);
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return link.element();
    }

    @Override
    public HTMLElement getClickableElement() {
        return link.element();
    }

    public DominoElement<HTMLAnchorElement> getLink() {
        return link;
    }

    public PagerNavItem withLink(
            ChildHandler<PagerNavItem, DominoElement<HTMLAnchorElement>> handler) {
        handler.apply(this, link);
        return this;
    }

    public int getPage() {
        return page;
    }

    @Override
    public HTMLLIElement element() {
        return root.element();
    }
}
