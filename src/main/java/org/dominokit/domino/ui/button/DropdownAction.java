package org.dominokit.domino.ui.button;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Justifiable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction implements Justifiable, HasClickableElement, HasSelectionHandler<DropdownAction> {

    private HTMLLIElement iElement = Elements.li().asElement();
    private HTMLAnchorElement aElement;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();

    private DropdownAction(String content) {
        aElement = Elements.a()
                .textContent(content)
                .asElement();
        iElement.appendChild(aElement);
        getClickableElement().addEventListener("click", evt -> selectionHandlers.forEach(SelectionHandler::onSelection));
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

    @Override
    public DropdownAction addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }
}
