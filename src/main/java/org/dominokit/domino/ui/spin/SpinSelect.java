package org.dominokit.domino.ui.spin;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasSelectionHandler;
import org.dominokit.domino.ui.utils.SwipeUtil;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.div;

abstract class SpinSelect<T, S extends SpinSelect<T, ?>> extends BaseDominoElement<HTMLDivElement, S> implements HasSelectionHandler<S, SpinItem<T>> {

    protected DominoElement<HTMLDivElement> element = DominoElement.of(div().css(getStyle()));

    private DominoElement<HTMLAnchorElement> prevAnchor = DominoElement.of(a().css("prev").css("disabled"));

    private DominoElement<HTMLAnchorElement> nextAnchor = DominoElement.of(a().css("next"));
    DominoElement<HTMLDivElement> contentPanel = DominoElement.of(div().css("spin-content"));
    protected DominoElement<HTMLDivElement> main = DominoElement.of(div().add(contentPanel).css("spin-container"));
    protected List<SpinItem<T>> items = new ArrayList<>();
    private SpinItem<T> activeItem;
    private List<HasSelectionHandler.SelectionHandler<SpinItem<T>>> selectionHandlers = new ArrayList<>();

    SpinSelect(Icon backIcon, Icon forwardIcon) {
        element.appendChild(
                prevAnchor.appendChild(backIcon
                        .clickable()
                        .addClickListener(evt -> moveBack())))
                .appendChild(main)
                .appendChild(
                        nextAnchor.appendChild(forwardIcon
                                .clickable()
                                .addClickListener(evt -> moveForward())));
        init((S) this);
        onAttached(mutationRecord -> fixElementsWidth());
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, main.asElement(), evt -> moveBack());
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, main.asElement(), evt -> moveForward());
        style().setHeight("50px");
    }

    public S moveForward() {
        moveToIndex(items.indexOf(this.activeItem) + 1);
        return (S) this;
    }

    public S moveBack() {
        moveToIndex(items.indexOf(this.activeItem) - 1);
        return (S) this;
    }
    public S moveToIndex(int targetIndex) {
        if (targetIndex < items.size() && targetIndex >= 0) {
            int activeIndex = items.indexOf(activeItem);
            if (targetIndex != activeIndex) {
                this.activeItem = items.get(targetIndex);
                double offset = (100d / items.size()) * (targetIndex);
                setTransformProperty(offset);
                informSelectionHandlers();
            }
        }

        updateArrowsVisibility();
        return (S) this;
    }

    public S moveToItem(SpinItem<T> item) {
        if(items.contains(item)){
            return moveToIndex(items.indexOf(item));
        }
        return (S) this;
    }

    private void updateArrowsVisibility() {
        if (items.indexOf(this.activeItem) == items.size() - 1) {
            nextAnchor.style().add("disabled");
        } else {
            nextAnchor.style().remove("disabled");
        }

        if (items.indexOf(this.activeItem) < 1) {
            prevAnchor.style().add("disabled");
        } else {
            prevAnchor.style().remove("disabled");
        }
    }

    public S appendChild(SpinItem<T> spinItem) {
        if (items.isEmpty()) {
            this.activeItem = spinItem;
        }
        items.add(spinItem);
        contentPanel.appendChild(spinItem);
        return (S) this;
    }

    public SpinItem<T> getActiveItem() {
        return activeItem;
    }

    private void informSelectionHandlers() {
        selectionHandlers.forEach(spinItemSelectionHandler -> spinItemSelectionHandler.onSelection(this.activeItem));
    }

    @Override
    public S addSelectionHandler(SelectionHandler<SpinItem<T>> selectionHandler) {
        selectionHandlers.add(selectionHandler);
        return (S) this;
    }

    @Override
    public S removeSelectionHandler(SelectionHandler<SpinItem<T>> selectionHandler) {
        selectionHandlers.remove(selectionHandler);
        return (S) this;
    }

    protected abstract void fixElementsWidth();
    protected abstract void setTransformProperty(double offset);
    protected abstract String getStyle();
}
