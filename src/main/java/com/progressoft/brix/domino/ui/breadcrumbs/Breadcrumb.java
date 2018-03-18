package com.progressoft.brix.domino.ui.breadcrumbs;

import com.progressoft.brix.domino.ui.icons.Icon;
import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.Color;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLOListElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.ol;

public class Breadcrumb implements IsElement<HTMLOListElement>, HasBackground<Breadcrumb> {

    private HTMLOListElement element = ol().css("breadcrumb").asElement();
    private List<BreadcrumbItem> items = new LinkedList<>();
    private BreadcrumbItem activeItem;
    private boolean removeTail=false;
    private Color activeColor;
    private Background activeBackground;
    private String alignmentStyle;

    public static Breadcrumb create() {
        return new Breadcrumb();
    }

    public Breadcrumb addItem(String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(text);
        addNewItem(item);
        item.onClick(onClick);
        return this;
    }

    public Breadcrumb addItem(Icon icon, String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(icon, text);
        addNewItem(item);
        item.onClick(onClick);
        return this;
    }

    public Breadcrumb addItem(BreadcrumbItem item) {
        addNewItem(item);
        return this;
    }

    private void addNewItem(BreadcrumbItem item) {
        items.add(item);
        setActiveItem(item);
        element.appendChild(item.asElement());
        item.getClickableElement().addEventListener("click", e -> setActiveItem(item));
    }

    private Breadcrumb setActiveItem(BreadcrumbItem item) {
        if (nonNull(activeItem))
            activeItem.deActivate();
        item.activate();
        this.activeItem = item;
        item.activate();
        if (removeTail) {
            int index = items.indexOf(item) + 1;
            while (items.size() > index) {
                items.get(items.size()-1).asElement().remove();
                items.remove(items.size() - 1);
            }
        }

        return this;
    }

    public Breadcrumb setRemoveActiveTailItem(boolean removeTail) {
        this.removeTail = removeTail;

        return this;
    }

    public Breadcrumb setColor(Color color){
        if(nonNull(this.activeColor))
            element.classList.remove("breadcrumb-"+color.getStyle());
        this.activeColor=color;
        element.classList.add("breadcrumb-"+color.getStyle());

        return this;
    }

    public Breadcrumb alignCenter(){
        if(nonNull(this.alignmentStyle))
            element.classList.remove(this.alignmentStyle);
        this.alignmentStyle="align-center";
        element.classList.add(this.alignmentStyle);
        return this;
    }

    public Breadcrumb alignRight(){
        if(nonNull(this.alignmentStyle))
            element.classList.remove(this.alignmentStyle);
        this.alignmentStyle="align-right";
        element.classList.add(this.alignmentStyle);
        return this;
    }

    @Override
    public HTMLOListElement asElement() {
        return element;
    }

    @Override
    public Breadcrumb setBackground(Background background) {
        if(nonNull(this.activeBackground))
            element.classList.remove("breadcrumb-"+background.getStyle());
        this.activeBackground=background;
        element.classList.add("breadcrumb-"+background.getStyle());

        return this;
    }
}
