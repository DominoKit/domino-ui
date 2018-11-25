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
    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css("dropdown-header"));
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

    /**
     * @deprecated use {@link #appendChild(DropdownAction)}
     */
    @Deprecated
    public DropdownActionsGroup addOption(DropdownAction action) {
        return appendChild(action);
    }

    public DropdownActionsGroup appendChild(DropdownAction action) {
        action.style().add("opt");
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
        return actions.stream().allMatch(DropdownAction::isCollapsed);
    }

    void hide() {
        element.collapse();
    }

    void show() {
        element.expand();
    }

    void addActionsTo(DropDownMenu menu) {
        for (DropdownAction action : actions) {
            action.addCollapseHandler(this::changeVisibility);
            action.addExpandHandler(this::changeVisibility);
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
