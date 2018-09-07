package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.ul;

public class SimpleListGroup extends BaseDominoElement<HTMLUListElement, SimpleListGroup> {

    private final HTMLUListElement element;

    private SimpleListGroup(HTMLUListElement element){
        this.element=element;
        init(this);
    }

    public static SimpleListGroup create(){
        return new SimpleListGroup(ul().css("list-group").asElement());
    }

    public SimpleListItem addItem(String content){
        SimpleListItem item = SimpleListItem.create(content);
        element.appendChild(item.asElement());
        return item;
    }

    /**
     * @deprecated use {@link #appendChild(String)}
     * @param content
     * @return
     */
    @Deprecated
    public SimpleListGroup appendItem(String content){
        element.appendChild(SimpleListItem.create(content).asElement());
        return this;
    }

    public SimpleListGroup appendChild(String content){
        element.appendChild(SimpleListItem.create(content).asElement());
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(SimpleListItem)}
     * @param item
     * @return
     */
    @Deprecated
    public SimpleListGroup appendItem(SimpleListItem item){
        element.appendChild(item.asElement());
        return this;
    }

    public SimpleListGroup appendChild(SimpleListItem item){
        element.appendChild(item.asElement());
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }

}
