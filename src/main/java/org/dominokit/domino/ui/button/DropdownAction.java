package org.dominokit.domino.ui.button;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Justifiable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction implements Justifiable, HasSelectionHandler<DropdownAction> {

    private HTMLLIElement liElement = Elements.li().asElement();
    private HTMLAnchorElement aElement;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();

    private DropdownAction(String content) {
        aElement = Elements.a()
                .textContent(content)
                .asElement();
        liElement.appendChild(aElement);
        liElement.addEventListener("click", evt -> {
            selectionHandlers.forEach(SelectionHandler::onSelection);
            evt.preventDefault();
        });
        liElement.addEventListener("touchstart", evt -> {
            selectionHandlers.forEach(SelectionHandler::onSelection);
            evt.preventDefault();
        });
    }

    public static DropdownAction create(String content) {
        return new DropdownAction(content);
    }

    @Override
    public HTMLElement asElement() {
        return liElement;
    }

    @Override
    public HTMLElement justify() {
        return (HTMLLIElement) asElement().cloneNode(true);
    }

    @Override
    public DropdownAction addSelectionHandler(SelectionHandler selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    public HTMLAnchorElement getAElement() {
        return aElement;
    }
}
