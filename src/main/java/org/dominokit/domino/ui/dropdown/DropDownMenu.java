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

    private MenuNavigation<DropdownAction, HTMLElement> menuNavigation;
    private DominoElement<HTMLUListElement> element = DominoElement.of(ul().css("dropdown-menu"));
    private HTMLElement targetElement;
    private DropDownPosition position = DropDownPosition.BOTTOM;
    private List<DropdownAction> actions = new ArrayList<>();
    private boolean touchMoved;
    private List<CloseHandler> closeHandlers = new ArrayList<>();
    private boolean closeOnEscape;

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

        addMenuNavigationListener(targetElement);
        init(this);
    }

    private void addMenuNavigationListener(HTMLElement targetElement) {
        menuNavigation = MenuNavigation.create(actions, targetElement)
                .onSelect(DropdownAction::select)
                .onFocus(item -> {
                    if (isOpened()) {
                        item.focus();
                    }
                })
                .onEscape(this::close);

        element.addEventListener("keydown", menuNavigation);
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

    public DropDownMenu appendChild(DropdownAction action) {
        action.addSelectionHandler(value -> {
            if (!hasActions())
                close();
        });
        actions.add(action);
        element.appendChild(action.asElement());
        return this;
    }

    public DropDownMenu addAction(DropdownAction action) {
        return appendChild(action);
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
        closeHandlers.forEach(CloseHandler::onClose);
    }

    public void open() {
        if (hasActions()) {
            if (!document.body.contains(element.asElement())) {
                document.body.appendChild(element.asElement());
            }
            element.style().setDisplay("block");
            position.position(element.asElement(), targetElement);
        }
    }

    public boolean isOpened() {
        return document.body.contains(element.asElement());
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

    public DropDownMenu selectAt(int index) {
        if (index >= 0 && index < actions.size()) {
            menuNavigation.focusAt(index);
        }
        return this;
    }

    public DropDownMenu addCloseHandler(CloseHandler closeHandler) {
        closeHandlers.add(closeHandler);
        return this;
    }

    public List<DropdownAction> getActions() {
        return actions;
    }

    public DropDownMenu setCloseOnEscape(boolean closeOnEscape) {
        this.closeOnEscape = closeOnEscape;
        return this;
    }

    @FunctionalInterface
    public interface CloseHandler {
        void onClose();
    }
}
