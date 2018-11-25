package org.dominokit.domino.ui.dropdown;


import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.Elements;

import java.util.ArrayList;
import java.util.List;

public class DropdownAction extends BaseDominoElement<HTMLLIElement, DropdownAction> implements HasSelectionHandler<DropdownAction, String> {

    private HTMLLIElement liElement = Elements.li().asElement();
    private String value;
    private HTMLElement content;
    private HTMLAnchorElement aElement;
    private List<SelectionHandler<String>> selectionHandlers = new ArrayList<>();
    private List<FocusHandler> focusHandlers = new ArrayList<>();

    public DropdownAction(String value, String displayValue) {
        this.value = value;
        init();
        aElement.appendChild(TextNode.of(displayValue));
        init(this);
    }

    public DropdownAction(String value, HTMLElement content) {
        this.value = value;
        this.content = content;
        init();
        aElement.appendChild(content);
        init(this);
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

    public static DropdownAction create(String content) {
        return create(content, content);
    }

    public static DropdownAction create(String value, String displayValue) {
        return new DropdownAction(value, displayValue);
    }

    public static DropdownAction create(String value, HTMLElement content) {
        return new DropdownAction(value, content);
    }

    public DropdownAction focus() {
        aElement.focus();
        return this;
    }

    public DropdownAction select() {
        selectionHandlers.forEach(handler -> handler.onSelection(getValue()));
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return liElement;
    }

    @Override
    public DropdownAction addSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return this;
    }

    @Override
    public DropdownAction removeSelectionHandler(SelectionHandler<String> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return this;
    }

    public String getValue() {
        return value;
    }

    public Node getContent() {
        return content;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return aElement;
    }

    public DropdownAction setDisplayValue(String displayValue) {
        DominoElement.of(aElement).clearElement()
                .appendChild(TextNode.of(displayValue));
        return this;
    }

    public DropdownAction setDisplayValue(HTMLElement content) {
        this.content = content;
        DominoElement.of(aElement).clearElement()
                .appendChild(content);
        return this;
    }

    public DropdownAction addFocusHandler(FocusHandler focusHandler) {
        focusHandlers.add(focusHandler);
        return this;
    }

    @FunctionalInterface
    public interface FocusHandler {
        void onFocus(DropdownAction dropdownAction);
    }
}
