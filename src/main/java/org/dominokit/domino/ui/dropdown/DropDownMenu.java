package org.dominokit.domino.ui.dropdown;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.li;
import static org.jboss.gwt.elemento.core.Elements.ul;

public class DropDownMenu extends BaseDominoElement<HTMLUListElement, DropDownMenu> {

    private DominoElement<HTMLUListElement> element = DominoElement.of(ul().css("dropdown-menu"));
    private DominoElement<HTMLElement> targetElement;
    private DropDownPosition position = DropDownPosition.BOTTOM;
    private List<DropdownAction> actions = new ArrayList<>();
    private boolean touchMoved;

    public DropDownMenu(HTMLElement targetElement) {
        this.targetElement = DominoElement.of(targetElement);
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
        item.remove();
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
        element.appendChild(li().attr("role", "separator").css("divider"));
        return this;
    }

    public DropDownMenu appendChild(Node child) {
        element.appendChild(child);
        return this;
    }

    public void close() {
        element.remove();
    }

    public void open() {
        if (!document.body.contains(element.asElement())) {
            document.body.appendChild(element.asElement());
        }
        element.style().setDisplay("block");
        position.position(element.asElement(), targetElement.asElement());
    }

    public DropDownMenu setPosition(DropDownPosition position) {
        this.position = position;
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element.asElement();
    }

    public DropDownMenu clearActions() {
        element.clearElement();
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
