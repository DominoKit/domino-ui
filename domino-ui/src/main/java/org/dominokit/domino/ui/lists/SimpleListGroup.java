package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.ul;

public class SimpleListGroup extends BaseDominoElement<HTMLUListElement, SimpleListGroup> {

    private final HTMLUListElement element;

    private SimpleListGroup() {
        this.element = ul()
                .css(ListStyles.LIST_GROUP)
                .css(Styles.default_shadow)
                .asElement();
        init(this);
    }

    public static SimpleListGroup create() {
        return new SimpleListGroup();
    }

    public SimpleListGroup appendChild(String content) {
        element.appendChild(SimpleListItem.create(content).asElement());
        return this;
    }

    public SimpleListGroup appendChild(SimpleListItem item) {
        element.appendChild(item.asElement());
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }

}
