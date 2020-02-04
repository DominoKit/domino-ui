package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.elemento.Elements.ul;

public class SimpleListGroup extends BaseDominoElement<HTMLUListElement, SimpleListGroup> {

    private final HTMLUListElement element;

    private SimpleListGroup() {
        this.element = ul()
                .css(ListStyles.LIST_GROUP)
                .element();
        init(this);
        elevate(Elevation.LEVEL_1);
    }

    public static SimpleListGroup create() {
        return new SimpleListGroup();
    }

    public SimpleListGroup appendChild(String content) {
        element.appendChild(SimpleListItem.create(content).element());
        return this;
    }

    public SimpleListGroup appendChild(SimpleListItem item) {
        element.appendChild(item.element());
        return this;
    }

    @Override
    public HTMLUListElement element() {
        return element;
    }

}
