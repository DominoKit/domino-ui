package org.dominokit.domino.ui.dropdown;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static elemental2.dom.DomGlobal.*;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.li;

public class DropdownActionsGroup<T> extends BaseDominoElement<HTMLLIElement, DropdownActionsGroup<T>> {
    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css(DropDownStyles.DROPDOWN_HEADER));
    private List<DropdownAction<T>> actions = new ArrayList<>();
    private DropDownMenu menu;

    public DropdownActionsGroup(Node titleElement) {
        element.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        element.appendChild(titleElement);
        init(this);
    }

    public static <T> DropdownActionsGroup<T> create(String title) {
        return create(document.createTextNode(title));
    }

    public static <T> DropdownActionsGroup<T> create(Node titleElement) {
        return new DropdownActionsGroup<>(titleElement);
    }

    public static <T> DropdownActionsGroup<T> create(HTMLElement titleElement) {
        return create((Node) titleElement);
    }

    public static <T> DropdownActionsGroup<T> create(IsElement titleElement) {
        return create(titleElement.element());
    }


    public DropdownActionsGroup<T> appendChild(DropdownAction<T> action) {
        actions.add(action);
        addActionToMenu(action);
        return this;
    }

    public List<DropdownAction<T>> getActions() {
        return actions;
    }

    @Override
    public HTMLLIElement element() {
        return element.element();
    }

    boolean isAllHidden() {
        return actions.stream().allMatch(DropdownAction::isHidden);
    }

    public void bindTo(DropDownMenu menu) {
        this.menu = menu;
        for (DropdownAction action : actions) {
            addActionToMenu(action);
        }
    }

    private void addActionToMenu(DropdownAction<T> action) {
        if (nonNull(menu)) {
            action.addHideHandler(this::changeVisibility);
            action.addShowHandler(this::changeVisibility);
            menu.appendChild(action);
        }
    }

    void changeVisibility() {
        if (isAllHidden()) {
            hide();
        } else {
            show();
        }
    }
}
