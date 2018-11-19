package org.dominokit.domino.ui.tabs;

import elemental2.dom.CSSProperties;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.ul;

class VTabsContainer extends BaseDominoElement<HTMLDivElement, VTabsContainer> implements HasActiveItem<VerticalTab>, IsElement<HTMLDivElement> {

    private HTMLUListElement listContainer = DominoElement.of(ul().css("list"))
            .asElement();

    private HTMLDivElement element = DominoElement.of(div()
            .add(listContainer)
            .css("vtabs"))
            .asElement();

    private VerticalTab activeItem;

    private List<VerticalTab> tabItems = new ArrayList<>();

    public VTabsContainer() {
        init(this);
    }

    public static VTabsContainer create() {
        return new VTabsContainer();
    }

    public VTabsContainer appendChild(VerticalTab tabItem) {
        listContainer.appendChild(tabItem.asElement());
        this.tabItems.add(tabItem);
        return this;
    }

    @Override
    public VerticalTab getActiveItem() {
        return activeItem;
    }

    @Override
    public void setActiveItem(VerticalTab activeItem) {
        if (nonNull(this.activeItem) && !this.activeItem.equals(activeItem)) {
            this.activeItem.deactivate();
        }

        this.activeItem = activeItem;
        this.activeItem.activate();
    }

    public DominoElement<HTMLUListElement> getListContainer() {
        return DominoElement.of(listContainer);
    }

    public VTabsContainer autoHieght() {
        listContainer.style.height = CSSProperties.HeightUnionType.of("calc(100vh - 83px)");
        asElement().style.height = CSSProperties.HeightUnionType.of("calc(100vh - 70px)");
        return this;
    }

    public VTabsContainer autoHieght(int offset) {
        listContainer.style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + 13 + "px)");
        asElement().style.height = CSSProperties.HeightUnionType.of("calc(100vh - " + offset + "px)");
        return this;
    }

    public List<VerticalTab> getTabItems() {
        return tabItems;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
