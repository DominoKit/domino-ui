package org.dominokit.domino.ui.breadcrumbs;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLOListElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;

import java.util.LinkedList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.ol;

public class Breadcrumb extends BaseDominoElement<HTMLOListElement, Breadcrumb> implements HasBackground<Breadcrumb> {

    private HTMLOListElement element = ol().css("breadcrumb").asElement();
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

    /**
     * @deprecated use {@link #appendChild(String, EventListener)}
     */
    @Deprecated
    public Breadcrumb addItem(String text, EventListener onClick) {
        return appendChild(text, onClick);
    }

    public Breadcrumb appendChild(String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(text);
        addNewItem(item);
        item.addClickListener(onClick);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(Icon, String, EventListener)}
     */
    @Deprecated
    public Breadcrumb addItem(Icon icon, String text, EventListener onClick) {
        return appendChild(icon, text, onClick);
    }

    public Breadcrumb appendChild(Icon icon, String text, EventListener onClick) {
        BreadcrumbItem item = BreadcrumbItem.create(icon, text);
        addNewItem(item);
        item.addClickListener(onClick);
        return this;
    }

    /**
     * @deprecated use {@link #appendChild(BreadcrumbItem)}
     */
    @Deprecated
    public Breadcrumb addItem(BreadcrumbItem item) {
        addNewItem(item);
        return this;
    }

    public Breadcrumb appendChild(BreadcrumbItem item) {
        addNewItem(item);
        return this;
    }

    private void addNewItem(BreadcrumbItem item) {
        items.add(item);
        setActiveItem(item);
        element.appendChild(item.asElement());
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
            element.classList.remove(color.getStyle());
        this.activeColor = color;
        element.classList.add(color.getStyle());

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
        return element;
    }

    @Override
    public Breadcrumb setBackground(Color background) {
        if (nonNull(this.activeBackground))
            element.classList.remove(background.getBackground());
        this.activeBackground = background;
        element.classList.add(background.getBackground());

        return this;
    }

    public BreadcrumbItem getActiveItem() {
        return activeItem;
    }

    public List<BreadcrumbItem> getItems() {
        return items;
    }
}
