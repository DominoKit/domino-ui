package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HtmlComponentBuilder;
import org.dominokit.domino.ui.utils.IsHtmlComponent;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.li;

public class SimpleListItem extends BaseListItem implements IsElement<HTMLLIElement>, HasBackground<SimpleListItem>, IsHtmlComponent<HTMLLIElement, SimpleListItem> {

    private final HTMLLIElement element;
    private final HtmlComponentBuilder<HTMLLIElement, SimpleListItem> htmlBuilder;
    private String style;


    private SimpleListItem(HTMLLIElement element) {
        super(element);
        this.element = element;
        this.htmlBuilder = new HtmlComponentBuilder<>(this);
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

    @Override
    public HtmlComponentBuilder<HTMLLIElement, SimpleListItem> htmlBuilder() {
        return htmlBuilder;
    }
}