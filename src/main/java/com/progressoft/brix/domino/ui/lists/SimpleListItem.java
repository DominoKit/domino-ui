package com.progressoft.brix.domino.ui.lists;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.li;

public class SimpleListItem extends BaseListItem implements IsElement<HTMLLIElement>, HasBackground<SimpleListItem> {

    private final HTMLLIElement element;
    private String style;


    private SimpleListItem(HTMLLIElement element) {
        super(element);
        this.element = element;
    }

    public static SimpleListItem create(String text) {
        return new SimpleListItem(li().css("list-group-item").textContent(text).asElement());
    }

    public SimpleListItem setStyle(ListGroupStyle itemStyle) {
        return setStyle(itemStyle.getStyle());
    }

    private SimpleListItem setStyle(String itemStyle) {
        if (nonNull(this.style))
            element.classList.remove(this.style);
        element.classList.add(itemStyle);
        this.style = itemStyle;
        return this;
    }

    @Override
    public SimpleListItem setBackground(Background background) {
        setStyle("list-group-" + background.getStyle());
        return this;
    }

    public SimpleListItem setHeading(String heading) {
        setHeaderText(heading);
        return this;
    }

    public SimpleListItem setText(String content) {
        setBodyText(content);
        return this;
    }

    public SimpleListItem appendContent(Node content) {
        asElement().appendChild(content);
        return this;
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }
}