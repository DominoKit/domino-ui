package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;

public class ListItem<T> extends BaseListItem<HTMLAnchorElement> implements IsElement<HTMLAnchorElement>, HasValue<ListItem<T>, T>
        , Selectable<ListItem<T>>, HasBackground<ListItem<T>>, Switchable<ListItem<T>> {

    private T value;
    private HasMultiSelectSupport<ListItem<T>> parent;
    private boolean selected = false;
    private boolean disabled = false;
    private String style;

    public ListItem(T value, HasMultiSelectSupport<ListItem<T>> parent) {
        super(a().css("list-group-item").asElement());
        this.value = value;
        this.parent = parent;
        getElement().addEventListener("click", e -> {
            if (!disabled) {
                if (isSelected()) {
                    deselect();
                } else {
                    select();
                }
            }
        });
    }

    public static <T> ListItem<T> create(HasMultiSelectSupport<ListItem<T>> parent, T value) {
        return new ListItem<>(value, parent);
    }

    @Override
    public HTMLAnchorElement asElement() {
        return getElement();
    }

    @Override
    public ListItem<T> setValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public ListItem<T> select() {
        return select(false);
    }

    @Override
    public ListItem<T> deselect() {
        return deselect(false);
    }

    @Override
    public ListItem<T> select(boolean silent) {
        if (parent.isSelectable()) {
            if (!parent.isMultiSelect())
                parent.getTableRows().forEach(tListItem -> tListItem.deselect(true));
            if (!selected) {
                asElement().classList.add("active");
                this.selected = true;
                if (!silent)
                    parent.onSelectionChange(this);
            }
        }

        return this;
    }

    @Override
    public ListItem<T> deselect(boolean silent) {
        if (selected) {
            asElement().classList.remove("active");
            this.selected = false;
            if (!silent) {
                parent.onSelectionChange(this);
            }
        }

        return this;
    }

    @Override
    public ListItem<T> disable() {
        if (!disabled) {
            deselect();
            getElement().classList.add("disabled");
            this.disabled = true;
        }

        return this;
    }

    @Override
    public ListItem<T> enable() {
        if (disabled) {
            getElement().classList.remove("disabled");
            this.disabled = false;
        }

        return this;
    }

    @Override
    public boolean isEnabled() {
        return !disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    public ListItem<T> setStyle(ListGroupStyle itemStyle) {
        return setStyle(itemStyle.getStyle());
    }

    private ListItem<T> setStyle(String itemStyle) {
        if (nonNull(this.style))
            getElement().classList.remove(this.style);
        getElement().classList.add(itemStyle);
        this.style = itemStyle;
        return this;
    }

    public ListItem<T> success() {
        setStyle(ListGroupStyle.SUCCESS);
        return this;
    }

    public ListItem<T> warning() {
        setStyle(ListGroupStyle.WARNING);
        return this;
    }

    public ListItem<T> info() {
        setStyle(ListGroupStyle.INFO);
        return this;
    }

    public ListItem<T> error() {
        setStyle(ListGroupStyle.ERROR);
        return this;
    }

    @Override
    public ListItem<T> setBackground(Color background) {
        setStyle("list-group-" + background.getBackground());
        return this;
    }

    public ListItem<T> setHeading(String heading) {
        setHeaderText(heading);
        return this;
    }

    public ListItem<T> setText(String content) {
        setBodyText(content);
        return this;
    }

    public ListItem<T> appendContent(Node node) {
        this.asElement().appendChild(node);
        return this;
    }

    public HTMLHeadingElement getHeaderElement() {
        return header;
    }

    public HTMLParagraphElement getBodyElement() {
        return body;
    }

    void setParent(HasMultiSelectSupport<ListItem<T>> parent) {
        this.parent = parent;
    }
}
