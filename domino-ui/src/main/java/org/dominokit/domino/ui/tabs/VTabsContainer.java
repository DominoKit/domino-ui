package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.style.Unit.px;
import static org.dominokit.domino.ui.style.Unit.vh;
import static org.jboss.elemento.Elements.div;

public class VTabsContainer extends BaseDominoElement<HTMLDivElement, VTabsContainer> implements HasActiveItem<VerticalTab>, IsElement<HTMLDivElement> {

    private FlexLayout listContainer = FlexLayout.create()
            .setDirection(FlexDirection.TOP_TO_BOTTOM)
            .css(TabStyles.LIST);

    private HTMLDivElement element = DominoElement.of(div()
            .add(listContainer)
            .css(TabStyles.VTABS))
            .element();

    private VerticalTab activeItem;

    private List<VerticalTab> tabItems = new ArrayList<>();

    public VTabsContainer() {
        init(this);
    }

    public static VTabsContainer create() {
        return new VTabsContainer();
    }

    public VTabsContainer appendChild(VerticalTab tabItem) {
        listContainer.appendChild(tabItem.element());
        this.tabItems.add(tabItem);
        return this;
    }

    public VTabsContainer appendChild(FillItem fillItem) {
        listContainer.appendChild(fillItem.element());
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

    public FlexLayout getListContainer() {
        return listContainer;
    }

    public VTabsContainer autoHeight() {
        listContainer.styler(style-> style.setHeight(Calc.sub(vh.of(100), px.of(83))));
        DominoElement.of(element).styler(style -> style.setHeight(Calc.sub(vh.of(100), px.of(70))));
        return this;
    }

    public VTabsContainer autoHeight(int offset) {
        listContainer.styler(style-> style.setHeight(Calc.sum(vh.of(100), px.of(offset+13))));
        DominoElement.of(element).styler(style -> style.setHeight(Calc.sum(vh.of(100), px.of(offset))));
        return this;
    }

    public List<VerticalTab> getTabItems() {
        return tabItems;
    }

    @Override
    public HTMLDivElement element() {
        return element;
    }
}
