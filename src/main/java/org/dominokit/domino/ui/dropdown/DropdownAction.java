package org.dominokit.domino.ui.dropdown;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction<V> extends BaseDominoElement<HTMLLIElement, DropdownAction<V>> implements HasSelectionHandler<DropdownAction, V> {

    private HTMLLIElement liElement = Elements.li().asElement();
    private V value;
    private HTMLElement content;
    private HTMLAnchorElement aElement;
    private List<SelectionHandler<V>> selectionHandlers = new ArrayList<>();
    private List<FocusHandler<V>> focusHandlers = new ArrayList<>();

    private DropdownAction(V value, String displayValue) {
        this.value = value;
        init();
        aElement.appendChild(TextNode.of(displayValue));
    }

    public DropdownAction(V value, HTMLElement content) {
        this.value = value;
        this.content = content;
        init();
        aElement.appendChild(content);
    }

    private void init() {
        aElement = Elements.a()
                .attr("tabindex", "0")
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
        aElement.addEventListener("focus", evt -> focusHandlers.forEach(focusHandler -> focusHandler.onFocus(this)));
    }

    public static DropdownAction<String> create(String content) {
        return create(content, content);
    }

    public static <V> DropdownAction<V> create(V value, String displayValue) {
        return new DropdownAction<>(value, displayValue);
    }

    public static <V> DropdownAction<V> create(V value, HTMLElement content) {
        return new DropdownAction<>(value, content);
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

    @Override
    public DropdownAction removeSelectionHandler(SelectionHandler<V> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public V getValue() {
        return value;
    }

    public Node getContent() {
        return content;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }

    public DropdownAction<V> addFocusHandler(FocusHandler<V> focusHandler) {
        focusHandlers.add(focusHandler);
        return this;
    }

    @FunctionalInterface
    public interface FocusHandler<V> {
        void onFocus(DropdownAction<V> dropdownAction);
    }
}
