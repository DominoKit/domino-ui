package org.dominokit.domino.ui.grid.flex;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.IsCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class FlexLayout extends BaseDominoElement<HTMLDivElement, FlexLayout> {

    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(FlexStyles.FLEX_LAYOUT));
    private List<FlexItem> flexItems = new ArrayList<>();
    private FlexDirection flexDirection;
    private FlexWrap flexWrap;
    private FlexJustifyContent flexJustifyContent;
    private FlexAlign flexAlign;

    public FlexLayout() {
        init(this);
    }

    public static FlexLayout create() {
        return new FlexLayout();
    }

    public FlexLayout setDirection(FlexDirection direction) {
        replaceCssClass(flexDirection, direction);
        this.flexDirection = direction;
        return this;
    }

    public FlexLayout setWrap(FlexWrap wrap) {
        replaceCssClass(flexWrap, wrap);
        flexWrap = wrap;
        return this;
    }

    public FlexLayout setFlow(FlexDirection direction, FlexWrap wrap) {
        setDirection(direction);
        setWrap(wrap);
        return this;
    }

    public FlexLayout setJustifyContent(FlexJustifyContent justifyContent) {
        replaceCssClass(flexJustifyContent, justifyContent);
        flexJustifyContent = justifyContent;
        return this;
    }

    public FlexLayout setAlignItems(FlexAlign alignItems) {
        replaceCssClass(flexAlign, alignItems);
        flexAlign = alignItems;
        return this;
    }

    public FlexLayout appendChild(FlexItem flexItem) {
        flexItems.add(flexItem);
        appendChild(flexItem.asElement());
        return this;
    }

    public FlexLayout appendChildBefore(FlexItem flexItem, FlexItem existingItem) {
        if (flexItems.contains(existingItem)) {
            flexItems.add(flexItem);
            insertBefore(flexItem, existingItem);
        }
        return this;
    }

    private void replaceCssClass(IsCssClass original, IsCssClass replacement) {
        if (nonNull(original)) {
            element.style().remove(original.getStyle());
        }
        element.style().add(replacement.getStyle());
    }

    public List<FlexItem> getFlexItems() {
        return flexItems;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

}
