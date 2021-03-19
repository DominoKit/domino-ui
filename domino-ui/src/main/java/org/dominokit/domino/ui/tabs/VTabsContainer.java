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

/**
 * The component that contains the tabs headers from the {@link VerticalTabsPanel}
 */
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

    /**
     *
     * @return new instance
     */
    public static VTabsContainer create() {
        return new VTabsContainer();
    }

    /**
     *
     * @param tabItem {@link VerticalTab}
     * @return same VTabsContainer instance
     */
    public VTabsContainer appendChild(VerticalTab tabItem) {
        listContainer.appendChild(tabItem.element());
        this.tabItems.add(tabItem);
        return this;
    }

    /**
     * adds space between tabs
     * @param fillItem {@link FillItem}
     * @return same VTabsContainer instance
     */
    public VTabsContainer appendChild(FillItem fillItem) {
        listContainer.appendChild(fillItem.element());
        return this;
    }

    /**
     *
     * @return the current active {@link VerticalTab}
     */
    @Override
    public VerticalTab getActiveItem() {
        return activeItem;
    }

    /**
     *
     * @param activeItem {@link VerticalTab} to be activated
     */
    @Override
    public void setActiveItem(VerticalTab activeItem) {
        if (nonNull(this.activeItem) && !this.activeItem.equals(activeItem)) {
            this.activeItem.deactivate();
        }

        this.activeItem = activeItem;
        this.activeItem.activate();
    }

    /**
     *
     * @return the {@link FlexLayout} that contains the FlexItems from each tab
     */
    public FlexLayout getListContainer() {
        return listContainer;
    }

    /**
     * Make the container height match the visible window height
     * @return same VTabsContainer instance
     */
    public VTabsContainer autoHeight() {
        listContainer.styler(style-> style.setHeight(Calc.sub(vh.of(100), px.of(83))));
        DominoElement.of(element).styler(style -> style.setHeight(Calc.sub(vh.of(100), px.of(70))));
        return this;
    }

    /**
     * Make the container height match the visible window height, with an offset
     * @return same VTabsContainer instance
     */
    public VTabsContainer autoHeight(int offset) {
        listContainer.styler(style-> style.setHeight(Calc.sum(vh.of(100), px.of(offset+13))));
        DominoElement.of(element).styler(style -> style.setHeight(Calc.sum(vh.of(100), px.of(offset))));
        return this;
    }

    /**
     *
     * @return List of all {@link VerticalTab}s
     */
    public List<VerticalTab> getTabItems() {
        return tabItems;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element;
    }
}
