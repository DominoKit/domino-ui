package org.dominokit.domino.ui.forms;

import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import elemental2.dom.Text;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.li;

public class SelectOptionGroup<T> extends BaseDominoElement<HTMLLIElement, SelectOptionGroup<T>> {

    private HTMLLIElement element = li().css("dropdown-header").asElement();
    private List<SelectOption<T>> options = new ArrayList<>();

    public SelectOptionGroup(Node titleElement) {
        element.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        element.appendChild(titleElement);
        init(this);
    }

    public static <T> SelectOptionGroup<T> create(String title) {
        return create(new Text(title));
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
     * @param option
     * @return
     */
    @Deprecated
    public SelectOptionGroup<T> addOption(SelectOption<T> option) {
        return appendChild(option);
    }

    public SelectOptionGroup<T> appendChild(SelectOption<T> option) {
        option.getLinkElement().style().add("opt");
        options.add(option);
        return this;
    }

    public List<SelectOption<T>> getOptions() {
        return options;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    boolean isAllHidden() {
        return options.stream().allMatch(option -> option.style().contains("hidden"));
    }

    void hide() {
        style().add("hidden");
    }

    void show() {
        style().remove("hidden");
    }

    void addOptionsTo(Select<T> select) {
        for (SelectOption<T> option : options) {
            select.appendChild(option);
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
