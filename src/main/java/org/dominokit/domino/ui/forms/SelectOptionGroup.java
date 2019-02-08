package org.dominokit.domino.ui.forms;

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

public class SelectOptionGroup<T> extends BaseDominoElement<HTMLLIElement, SelectOptionGroup<T>> {

    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css("dropdown-header"));
    private List<SelectOption<T>> options = new ArrayList<>();
    private Node titleElement;

    public SelectOptionGroup(Node titleElement) {
        this.titleElement = titleElement;
        element.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        element.appendChild(titleElement);
        init(this);
    }

    public static <T> SelectOptionGroup<T> create(String title) {
        return create(DomGlobal.document.createTextNode(title));
    }

    public static <T> SelectOptionGroup<T> create(Node titleElement) {
        return new SelectOptionGroup<>(titleElement);
    }

    public static <T> SelectOptionGroup<T> create(HTMLElement titleElement) {
        return create((Node) titleElement);
    }

    public static <T> SelectOptionGroup<T> create(IsElement titleElement) {
        return create(titleElement.asElement());
    }

    /**
     * @deprecated use {@link #appendChild(SelectOption)}
     */
    @Deprecated
    public SelectOptionGroup<T> addOption(SelectOption<T> option) {
        return appendChild(option);
    }

    public SelectOptionGroup<T> appendChild(SelectOption<T> option) {
        option.style().add("opt");
        options.add(option);
        return this;
    }

    public List<SelectOption<T>> getOptions() {
        return options;
    }

    @Override
    public HTMLLIElement asElement() {
        return element.asElement();
    }

    boolean isAllHidden() {
        return options.stream().allMatch(SelectOption::isCollapsed);
    }

    void addOptionsTo(Select<T> select) {
        for (SelectOption<T> option : options) {
            option.addCollapseHandler(this::changeVisibility);
            option.addExpandHandler(this::changeVisibility);
            select.appendChild(option);
        }
    }

    void changeVisibility() {
        DomGlobal.console.info("changeVisibility");
        if (isAllHidden()) {
            hide();
        } else {
            show();
        }
    }

    public Node getTitleElement() {
        return titleElement;
    }
}
