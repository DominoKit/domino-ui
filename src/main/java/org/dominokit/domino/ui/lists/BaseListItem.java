package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.p;

public class BaseListItem<E extends HTMLElement, T extends BaseListItem<E,T>> extends DominoElement<E, T> implements IsElement<E>{

    private E element;
    protected HTMLHeadingElement header;
    protected HTMLParagraphElement body;

    BaseListItem(E element) {
        this.element = element;
    }

    void setHeaderText(String heading) {
        if (isNull(header)) {
            body = p().css("list-group-item-text").asElement();
            body.innerHTML = element.innerHTML;
            ElementUtil.clear(element);
            header = h(4).css("list-group-item-heading").asElement();
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

    public DominoElement<HTMLHeadingElement, IsElement<HTMLHeadingElement>> getHeader() {
        return DominoElement.of(header);
    }

    public DominoElement<HTMLParagraphElement, IsElement<HTMLParagraphElement>> getBody() {
        return DominoElement.of(body);
    }
}
