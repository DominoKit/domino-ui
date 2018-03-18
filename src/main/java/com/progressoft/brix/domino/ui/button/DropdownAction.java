package com.progressoft.brix.domino.ui.button;

import com.progressoft.brix.domino.ui.utils.HasClickableElement;
import com.progressoft.brix.domino.ui.utils.Justifiable;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.jboss.gwt.elemento.core.Elements;

public class DropdownAction implements Justifiable, HasClickableElement {

    private HTMLLIElement iElement = Elements.li().asElement();
    private HTMLAnchorElement aElement;

    private DropdownAction(String content) {
        aElement = Elements.a()
                .textContent(content)
                .asElement();
        iElement.appendChild(aElement);
    }

    public static DropdownAction create(String content) {
        return new DropdownAction(content);
    }

    @Override
    public HTMLElement asElement() {
        return iElement;
    }

    @Override
    public HTMLElement justify() {
        return (HTMLLIElement) asElement().cloneNode(true);
    }

    @Override
    public HTMLElement getClickableElement() {
        return aElement;
    }
}
