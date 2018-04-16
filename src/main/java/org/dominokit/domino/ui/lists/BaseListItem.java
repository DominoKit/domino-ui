package org.dominokit.domino.ui.lists;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import org.dominokit.domino.ui.utils.ElementUtil;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.p;

public class BaseListItem<T extends Element> {

    private T element;
    private HTMLHeadingElement header;
    private HTMLParagraphElement body;

    BaseListItem(T element) {
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

    public T getElement() {
        return element;
    }
}
