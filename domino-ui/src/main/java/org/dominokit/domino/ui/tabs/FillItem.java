package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component that adds a space between {@link VerticalTab}s in the {@link VerticalTabsPanel}
 */
public class FillItem extends BaseDominoElement<HTMLDivElement, FillItem> {

    private FlexItem element;

    public FillItem() {
        this.element = FlexItem.create()
                .setFlexGrow(1);
        init(this);
    }

    /**
     *
     * @return new instance
     */
    public static FillItem create() {
        return new FillItem();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
