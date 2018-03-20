package org.dominokit.domino.ui.lists;

import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.ul;

public class SimpleListGroup implements IsElement<HTMLUListElement>{

    private final HTMLUListElement element;

    private SimpleListGroup(HTMLUListElement element){
        this.element=element;
    }

    public static SimpleListGroup create(){
        return new SimpleListGroup(ul().css("list-group").asElement());
    }

    public SimpleListItem addItem(String content){
        SimpleListItem item = SimpleListItem.create(content);
        element.appendChild(item.asElement());
        return item;
    }

    public SimpleListGroup appendItem(String content){
        element.appendChild(SimpleListItem.create(content).asElement());
        return this;
    }

    public SimpleListGroup appendItem(SimpleListItem item){
        element.appendChild(item.asElement());
        return this;
    }

    @Override
    public HTMLUListElement asElement() {
        return element;
    }
}
