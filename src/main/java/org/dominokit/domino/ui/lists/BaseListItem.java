package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;

import static java.util.Objects.isNull;
import static org.jboss.gwt.elemento.core.Elements.h;
import static org.jboss.gwt.elemento.core.Elements.p;

public class BaseListItem {

    private HTMLElement element;
    private HTMLHeadingElement header;
    private HTMLParagraphElement body;

    BaseListItem(HTMLElement element) {
        this.element = element;
    }

    void setHeaderText(String heading) {
        if (isNull(header)) {
            body = p().css("list-group-item-text").asElement();
            body.textContent = element.textContent;
            element.textContent = "";
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
}
