package org.dominokit.domino.ui.grid.flex;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.div;

public class FlexLayout extends BaseDominoElement<HTMLDivElement, FlexLayout> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css("flex-layout"));
    private List<FlexItem> flexItems = new ArrayList<>();

    public FlexLayout() {
        init(this);
    }

    public static FlexLayout create() {
        return new FlexLayout();
    }

    public FlexLayout setDirection(FlexDirection direction) {
        element.style().setProperty("flex-direction", direction.getStyle());
        return this;
    }

    public FlexLayout setWrap(FlexWrap wrap) {
        element.style().setProperty("flex-wrap", wrap.getStyle());
        return this;
    }

    public FlexLayout setFlow(FlexDirection direction, FlexWrap wrap) {
        setDirection(direction);
        setWrap(wrap);
        return this;
    }

    public FlexLayout setJustifyContent(FlexJustifyContent justifyContent) {
        element.style().setProperty("justify-content", justifyContent.getStyle());
        return this;
    }

    public FlexLayout setAlignItems(FlexAlign alignItems) {
        element.style().setProperty("align-items", alignItems.getStyle());
        return this;
    }

    public FlexLayout appendChild(FlexItem flexItem) {
        flexItems.add(flexItem);
        appendChild(flexItem.asElement());
        return this;
    }

    public List<FlexItem> getFlexItems() {
        return flexItems;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

}
