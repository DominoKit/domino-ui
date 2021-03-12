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

/**
 * A component that can group a set of {@link SelectOption}
 *
 * @param <T> The type of the SelectOption value
 */
public class SelectOptionGroup<T> extends BaseDominoElement<HTMLLIElement, SelectOptionGroup<T>> {

    private DominoElement<HTMLLIElement> element = DominoElement.of(li().css("dropdown-header"));
    private List<SelectOption<T>> options = new ArrayList<>();
    private Node titleElement;
    private Consumer<SelectOption<T>> addOptionConsumer = (option) -> {
    };

    /**
     * Creates a group with title
     *
     * @param titleElement {@link Node} to be used as the title
     */
    public SelectOptionGroup(Node titleElement) {
        this.titleElement = titleElement;
        element.addEventListener("click", evt -> {
            evt.preventDefault();
            evt.stopPropagation();
        });
        element.appendChild(titleElement);
        init(this);
    }

    /**
     * Creates a group with title
     *
     * @param title String to be used as the title
     * @return new SelectOptionGroup instance
     */
    public static <T> SelectOptionGroup<T> create(String title) {
        return create(DomGlobal.document.createTextNode(title));
    }

    /**
     * Creates a group with title
     *
     * @param titleElement {@link Node} to be used as the title
     * @return new SelectOptionGroup instance
     */
    public static <T> SelectOptionGroup<T> create(Node titleElement) {
        return new SelectOptionGroup<>(titleElement);
    }

    /**
     * Creates a group with title
     *
     * @param titleElement {@link HTMLElement} to be used as the title
     * @return new SelectOptionGroup instance
     */
    public static <T> SelectOptionGroup<T> create(HTMLElement titleElement) {
        return create((Node) titleElement);
    }

    /**
     * Creates a group with title
     *
     * @param titleElement {@link IsElement} to be used as the title
     * @return new SelectOptionGroup instance
     */
    public static <T> SelectOptionGroup<T> create(IsElement<?> titleElement) {
        return create(titleElement.element());
    }

    /**
     * Adds a SelectOption to this group
     *
     * @param option {@link SelectOption}
     * @return same SelectOptionGroup instance
     */
    public SelectOptionGroup<T> appendChild(SelectOption<T> option) {
        option.style().add("opt");
        options.add(option);
        if (nonNull(addOptionConsumer)) {
            addOptionConsumer.accept(option);
        }
        return this;
    }

    /**
     * Sets a consumer to be called when ever a SelectOption is added to this group
     *
     * @param addOptionConsumer Consumer of {@link SelectOption}
     */
    public void setAddOptionConsumer(Consumer<SelectOption<T>> addOptionConsumer) {
        this.addOptionConsumer = addOptionConsumer;
    }

    /**
     * @return List of all {@link SelectOption} in this group
     */
    public List<SelectOption<T>> getOptions() {
        return options;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLLIElement element() {
        return element.element();
    }

    /**
     * @return boolean, true if all the options in the group are hidden
     */
    boolean isAllHidden() {
        return options.stream().allMatch(SelectOption::isHidden);
    }

    /**
     * Adds the options in this group to the specified Select
     *
     * @param select {@link Select}
     */
    void addOptionsTo(AbstractSelect<T, ?, ?> select) {
        for (SelectOption<T> option : options) {
            option.addHideListener(this::changeVisibility);
            option.addShowListener(this::changeVisibility);
            select.appendChild(option);
        }
    }

    /**
     * Change the visibility of this group based on its options visibility
     */
    void changeVisibility() {
        if (isAllHidden()) {
            hide();
        } else {
            show();
        }
    }

    /**
     *
     * @return the {@link Node} used as title for this group
     */
    public Node getTitleElement() {
        return titleElement;
    }
}
