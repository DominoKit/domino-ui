package org.dominokit.domino.ui.dropdown;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;

public class DropDownMenu implements IsElement<HTMLUListElement> {

    private HTMLUListElement element = Elements.ul().css("dropdown-menu").asElement();
    private HTMLElement targetElement;
    private DropDownPosition position = DropDownPosition.BOTTOM;
    private List<DropdownAction> actions = new ArrayList<>();
    private boolean touchMoved;

    public DropDownMenu(HTMLElement targetElement) {
        this.targetElement = targetElement;
        EventListener listener = this::closeAllGroups;
        document.addEventListener("click", listener);
        document.addEventListener("touchend", evt -> {
            if (!touchMoved) {
                closeAllGroups(evt);
            }
            touchMoved = false;
        });
        document.addEventListener("touchmove", evt -> this.touchMoved = true);
    }

    private void closeAllGroups(Event evt) {
        HTMLElement element = Js.uncheckedCast(evt.target);
        if (!this.element.contains(element)) {
            closeAllMenus();
        }
    }

    private void close(HTMLElement item) {
        item.style.display = "none";
    }

    private boolean isOpened(HTMLElement item) {
        return item.style.display.equals("block");
    }

    public static DropDownMenu create(HTMLElement targetElement) {
        return new DropDownMenu(targetElement);
    }

    public static DropDownMenu create(IsElement targetElement) {
        return new DropDownMenu(targetElement.asElement());
    }

    public DropDownMenu addAction(DropdownAction action) {
        action.addSelectionHandler(this::close);
        actions.add(action);
        element.appendChild(action.asElement());
        return this;
    }

    public DropDownMenu separator() {
        element.appendChild(Elements.li().attr("role", "separator").css("divider").asElement());
        return this;
    }

    public DropDownMenu appendChild(Node child) {
        element.appendChild(child);
        return this;
    }

    public void close() {
        Style.of(element).setDisplay("none");
    }

    public void open() {
        if (!document.body.contains(element)) {
            document.body.appendChild(element);
        }
        Style.of(element).setDisplay("block");
        position.position(element, targetElement);
    }

    public DropDownMenu setPosition(DropDownPosition position) {
        this.position = position;
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }

    public DropDownMenu clearActions() {
        ElementUtil.clear(element);
        actions.clear();
        return this;
    }

    public boolean hasActions() {
        return !actions.isEmpty();
    }

    public void closeAllMenus() {
        NodeList<Element> elementsByName = document.body.querySelectorAll(".dropdown-menu");
        for (int i = 0; i < elementsByName.length; i++) {
            HTMLElement item = Js.uncheckedCast(elementsByName.item(i));
            if (isOpened(item)) {
                close(item);
            }
        }
    }
}
