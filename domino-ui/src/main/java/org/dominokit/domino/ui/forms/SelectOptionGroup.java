package org.dominokit.domino.ui.forms;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.li;

public class SelectOptionGroup<T> extends BaseDominoElement<HTMLLIElement, SelectOptionGroup<T>> {

    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css("dropdown-header"));
    private List<SelectOption<T>> options = new ArrayList<>();
    private Node titleElement;
    private Consumer<SelectOption<T>> addOptionConsumer = (option)->{};

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
        return create(titleElement.element());
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
        if(nonNull(addOptionConsumer)){
            addOptionConsumer.accept(option);
        }
        return this;
    }

    public void setAddOptionConsumer(Consumer<SelectOption<T>> addOptionConsumer) {
        this.addOptionConsumer = addOptionConsumer;
    }

    public List<SelectOption<T>> getOptions() {
        return options;
    }

    @Override
    public HTMLLIElement element() {
        return element.element();
    }

    boolean isAllHidden() {
        return options.stream().allMatch(SelectOption::isHidden);
    }

    void addOptionsTo(Select<T> select) {
        for (SelectOption<T> option : options) {
            option.addHideListener(this::changeVisibility);
            option.addShowListener(this::changeVisibility);
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

    public Node getTitleElement() {
        return titleElement;
    }
}
