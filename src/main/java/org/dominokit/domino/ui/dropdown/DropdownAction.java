package org.dominokit.domino.ui.dropdown;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction<V> extends BaseDominoElement<HTMLLIElement, DropdownAction<V>> implements HasSelectionHandler<DropdownAction, V> {

    private HTMLLIElement liElement = Elements.li().asElement();
    private V value;
    private HTMLAnchorElement aElement;
    private List<SelectionHandler<V>> selectionHandlers = new ArrayList<>();

    private DropdownAction(V value, String displayValue) {
        this.value = value;
        aElement = Elements.a()
                .attr("tabindex", "0")
                .textContent(displayValue)
                .asElement();
        liElement.appendChild(aElement);
        liElement.addEventListener("click", evt -> {
            select();
            evt.preventDefault();
        });
        liElement.addEventListener("touchstart", evt -> {
            select();
            evt.preventDefault();
        });
    }

    public static DropdownAction<String> create(String content) {
        return create(content, content);
    }

    public static <V> DropdownAction<V> create(V value, String displayValue) {
        return new DropdownAction<>(value, displayValue);
    }

    public DropdownAction<V> focus() {
        aElement.focus();
        return this;
    }

    public DropdownAction<V> select() {
        selectionHandlers.forEach(handler -> handler.onSelection(getValue()));
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return liElement;
    }

    @Override
    public DropdownAction<V> addSelectionHandler(SelectionHandler<V> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    public V getValue() {
        return value;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }
}
