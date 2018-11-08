package org.dominokit.domino.ui.lists;

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLLIElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HtmlComponentBuilder;
import org.dominokit.domino.ui.utils.IsHtmlComponent;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.li;

public class SimpleListItem extends BaseListItem<HTMLLIElement, SimpleListItem> implements HasBackground<SimpleListItem> {

    private String style;


    private SimpleListItem(String text) {
        super(li().css("list-group-item").textContent(text).asElement());
        init(this);
    }

    public static SimpleListItem create(String text) {
        return new SimpleListItem(text);
    }

    public SimpleListItem setStyle(ListGroupStyle itemStyle) {
        return setStyle(itemStyle.getStyle());
    }

    private SimpleListItem setStyle(String itemStyle) {
        if (nonNull(this.style)) {
            style().remove(this.style);
        }
        style().add(itemStyle);
        this.style = itemStyle;
        return this;
    }

    @Override
    public SimpleListItem setBackground(Color background) {
        setStyle(background.getBackground());
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

    /**
     * @deprecated use {@link #appendChild(Node)}
     */
    @Deprecated
    public SimpleListItem appendContent(Node content) {
        asElement().appendChild(content);
        return this;
    }

    public SimpleListItem appendChild(Badge badge){
        appendChild(badge, true);
        return this;
    }

    public SimpleListItem appendChild(Badge badge, boolean first){
        if(first) {
            insertFirst(badge);
        }else{
            appendChild(badge.asElement());
        }
        return this;
    }

    public SimpleListItem appendChild(Node content) {
        asElement().appendChild(content);
        return this;
    }

    public SimpleListItem appendChild(IsElement content) {
       return appendChild(content.asElement());
    }

}