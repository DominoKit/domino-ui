package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLOListElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.ol;

public class Breadcrumb extends BaseDominoElement<HTMLOListElement, Breadcrumb> implements HasBackground<Breadcrumb> {

    private DominoElement<HTMLOListElement> element = DominoElement.of(ol()
            .css(BreadcrumbStyles.BREADCRUMB));
    private List<BreadcrumbItem> items = new LinkedList<>();
    private BreadcrumbItem activeItem;
    private boolean removeTail = false;
    private Color activeColor;
    private Color activeBackground;

    public Breadcrumb() {
        init(this);
    }

    public static Breadcrumb create() {
        return new Breadcrumb();
    }


    public Breadcrumb appendChild(String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(text);
        addNewItem(item);
        item.addClickListener(onClick);
        return this;
    }


    public Breadcrumb appendChild(BaseIcon<?> icon, String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(icon, text);
        addNewItem(item);
        item.addClickListener(onClick);
        return this;
    }


    public Breadcrumb appendChild(BreadcrumbItem item) {
        addNewItem(item);
        return this;
    }

    private void addNewItem(BreadcrumbItem item) {
        items.add(item);
        setActiveItem(item);
        element.appendChild(item);
        DominoElement.of(item.getClickableElement()).addClickListener(e -> setActiveItem(item));
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
                items.get(items.size() - 1).asElement().remove();
                items.remove(items.size() - 1);
            }
        }

        return this;
    }

    public Breadcrumb setRemoveActiveTailItem(boolean removeTail) {
        this.removeTail = removeTail;

        return this;
    }

    public Breadcrumb setColor(Color color) {
        if (nonNull(this.activeColor))
            element.style().remove(color.getStyle());
        this.activeColor = color;
        element.style().add(color.getStyle());

        return this;
    }

    public Breadcrumb alignCenter() {
        style().alignCenter();
        return this;
    }

    public Breadcrumb alignRight() {
        style().alignRight();
        return this;
    }

    @Override
    public HTMLOListElement asElement() {
        return element.asElement();
    }

    @Override
    public Breadcrumb setBackground(Color background) {
        if (nonNull(this.activeBackground))
            element.style().remove(background.getBackground());
        this.activeBackground = background;
        element.style().add(background.getBackground());

        return this;
    }

    public BreadcrumbItem getActiveItem() {
        return activeItem;
    }

    public List<BreadcrumbItem> getItems() {
        return items;
    }
}
