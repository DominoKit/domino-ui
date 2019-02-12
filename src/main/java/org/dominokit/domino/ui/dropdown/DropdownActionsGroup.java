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

import static org.jboss.gwt.elemento.core.Elements.li;

public class DropdownActionsGroup extends BaseDominoElement<HTMLLIElement, DropdownActionsGroup> {
    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css(DropDownStyles.DROPDOWN_HEADER));
    private List<DropdownAction> actions = new ArrayList<>();

    public DropdownActionsGroup(Node titleElement) {
        element.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        element.appendChild(titleElement);
        init(this);
    }

    public static DropdownActionsGroup create(String title) {
        return create(DomGlobal.document.createTextNode(title));
    }

    public static DropdownActionsGroup create(Node titleElement) {
        return new DropdownActionsGroup(titleElement);
    }

    public static DropdownActionsGroup create(HTMLElement titleElement) {
        return create((Node) titleElement);
    }

    public static DropdownActionsGroup create(IsElement titleElement) {
        return create(titleElement.asElement());
    }


    public DropdownActionsGroup appendChild(DropdownAction action) {
        actions.add(action);
        return this;
    }

    public List<DropdownAction> getActions() {
        return actions;
    }

    @Override
    public HTMLLIElement asElement() {
        return element.asElement();
    }

    boolean isAllHidden() {
        return actions.stream().allMatch(DropdownAction::isHidden);
    }

    void addActionsTo(DropDownMenu menu) {
        for (DropdownAction action : actions) {
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
