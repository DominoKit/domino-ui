package com.progressoft.brix.domino.ui.lists;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import com.progressoft.brix.domino.ui.utils.HasMultiSelectSupport;
import com.progressoft.brix.domino.ui.utils.HasValue;
import com.progressoft.brix.domino.ui.utils.Selectable;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLHeadingElement;
import elemental2.dom.HTMLParagraphElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.a;

public class ListItem<T> extends BaseListItem implements IsElement<HTMLAnchorElement>, HasValue<T>
        , Selectable<ListItem<T>>, HasBackground<ListItem<T>> {

    private final HTMLAnchorElement element;
    private T value;
    private HasMultiSelectSupport<ListItem<T>> parent;
    private boolean selected = false;
    private boolean disabled = false;
    private String style;
    private HTMLHeadingElement header;
    private HTMLParagraphElement body;

    private ListItem(HTMLAnchorElement element, T value, HasMultiSelectSupport<ListItem<T>> parent) {
        super(element);
        this.element = element;
        this.value = value;
        this.parent = parent;
    }

    static <T> ListItem<T> create(HasMultiSelectSupport<ListItem<T>> parent, T value) {
        HTMLAnchorElement element = a().css("list-group-item").asElement();
        ListItem<T> listItem = new ListItem<>(element, value, parent);
        element.addEventListener("click", e -> {
            if (!listItem.disabled) {
                if (listItem.isSelected()) {
                    listItem.deselect();
                } else {
                    listItem.select();
                }
            }
        });
        return listItem;
    }


    @Override
    public HTMLAnchorElement asElement() {
        return element;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public ListItem<T> select() {
        if (!parent.isMultiSelect())
            parent.getItems().forEach(ListItem::deselect);
        if (!selected) {
            asElement().classList.add("active");
            this.selected = true;
        }

        return this;
    }

    @Override
    public ListItem<T> deselect() {
        if (selected) {
            asElement().classList.remove("active");
            this.selected = false;
        }

        return this;
    }

    public ListItem<T> disable() {
        if (!disabled) {
            deselect();
            element.classList.add("disabled");
            this.disabled = true;
        }

        return this;
    }

    public ListItem<T> enable() {
        if (disabled) {
            element.classList.remove("disabled");
            this.disabled = false;
        }

        return this;
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
            element.classList.remove(this.style);
        element.classList.add(itemStyle);
        this.style = itemStyle;
        return this;
    }

    public ListItem<T> success(){
        setStyle(ListGroupStyle.SUCCESS);
        return this;
    }

    public ListItem<T> warning(){
        setStyle(ListGroupStyle.WARNING);
        return this;
    }

    public ListItem<T> info(){
        setStyle(ListGroupStyle.INFO);
        return this;
    }

    public ListItem<T> error(){
        setStyle(ListGroupStyle.ERROR);
        return this;
    }

    @Override
    public ListItem<T> setBackground(Background background) {
        setStyle("list-group-" + background.getStyle());
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
}
