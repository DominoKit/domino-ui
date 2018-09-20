package org.dominokit.domino.ui.grid.flex;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class FlexItem extends BaseDominoElement<HTMLDivElement, FlexItem> {

    private HTMLDivElement element = div().css("flex-item").asElement();
    private int order;
    private int flexGrow;
    private int flexShrink;
    private String flexBasis;
    private FlexAlign alignSelf;

    public FlexItem() {
        init(this);
    }

    public static FlexItem create() {
        return new FlexItem();
    }

    public FlexItem setOrder(int order) {
        this.order = order;
        style().setProperty("order", String.valueOf(order));
        return this;
    }

    public int getOrder() {
        return order;
    }

    public FlexItem setFlexGrow(int flexGrow) {
        this.flexGrow = flexGrow;
        style().setProperty("flex-grow", String.valueOf(flexGrow));
        return this;
    }

    public FlexItem setFlexShrink(int flexShrink) {
        this.flexShrink = flexShrink;
        style().setProperty("flex-shrink", String.valueOf(flexShrink));
        return this;
    }

    public FlexItem setFlexBasis(String flexBasis) {
        this.flexBasis = flexBasis;
        style().setProperty("flex-basis", flexBasis);
        return this;
    }

    public FlexItem setAlignSelf(FlexAlign alignSelf) {
        this.alignSelf = alignSelf;
        style().setProperty("align-self", alignSelf.getStyle());
        return this;
    }

    public FlexItem setAutoAlign() {
        style().setProperty("align-self", "auto");
        return this;
    }

    public int getFlexGrow() {
        return flexGrow;
    }

    public int getFlexShrink() {
        return flexShrink;
    }

    public String getFlexBasis() {
        return flexBasis;
    }

    public FlexAlign getAlignSelf() {
        return alignSelf;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }
}
