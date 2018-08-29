package org.dominokit.domino.ui.dropdown;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.Justifiable;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction<V> implements Justifiable, HasSelectionHandler<DropdownAction> {

    private HTMLLIElement liElement = Elements.li().asElement();
    private V value;
    private HTMLAnchorElement aElement;
    private List<SelectionHandler> selectionHandlers = new ArrayList<>();

    private DropdownAction(V value, String displayValue) {
        this.value = value;
        aElement = Elements.a()
                .textContent(displayValue)
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

    public static DropdownAction<String> create(String content) {
        return create(content, content);
    }

    public static <V> DropdownAction<V> create(V value, String displayValue) {
        return new DropdownAction<>(value, displayValue);
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

    public V getValue() {
        return value;
    }

    public HTMLAnchorElement getAElement() {
        return aElement;
    }
}
