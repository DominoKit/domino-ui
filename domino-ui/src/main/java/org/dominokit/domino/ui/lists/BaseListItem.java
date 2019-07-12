package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;

import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.p;

public abstract class BaseListItem<E extends HTMLElement, T extends BaseListItem<E, T>> extends BaseDominoElement<E, T> {

    private E element;
    protected HTMLHeadingElement header;
    protected HTMLParagraphElement body;

    BaseListItem() {
    }

    void setElement(E element) {
        this.element = element;
    }

    void setHeaderText(String heading) {
        if (isNull(header)) {
            body = p().css(ListStyles.LIST_GROUP_ITEM_TEXT).asElement();
            body.innerHTML = asElement().innerHTML;
            ElementUtil.clear(asElement());
            header = h(4).css(ListStyles.LIST_GROUP_ITEM_HEADING).asElement();
            header.textContent = heading;
            element.appendChild(header);
            element.appendChild(body);
        } else {
            header.textContent = heading;
        }
    }

    void setBodyText(String content) {
        if (isNull(body))
            element.textContent = content;
        else
            body.textContent = content;
    }

    @Override
    public E asElement() {
        return element;
    }

    public DominoElement<HTMLHeadingElement> getHeader() {
        return DominoElement.of(header);
    }

    public DominoElement<HTMLParagraphElement> getBody() {
        return DominoElement.of(body);
    }

    public T appendChild(Badge badge) {
        return appendChild(badge, true);
    }

    public T appendChild(Badge badge, boolean first) {
        if (first) {
            insertFirst(badge);
        } else {
            appendChild(badge.asElement());
        }
        return (T) this;
    }
}
