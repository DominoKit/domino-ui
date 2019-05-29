package org.dominokit.domino.ui.spin;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.SwipeUtil;

public class VSpinSelect<T> extends SpinSelect<T, VSpinSelect<T>> {


    public static <T> VSpinSelect<T> create() {
        return new VSpinSelect<>();
    }

    public static <T> VSpinSelect<T> create(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
        return new VSpinSelect<>(backIcon, forwardIcon);
    }

    public VSpinSelect() {
        this(Icons.ALL.keyboard_arrow_up(), Icons.ALL.keyboard_arrow_down());
    }

    public VSpinSelect(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
        super(backIcon, forwardIcon);
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.DOWN, main.asElement(), evt -> moveBack());
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.UP, main.asElement(), evt -> moveForward());
        setHeight("50px");
    }

    @Override
    protected void setTransformProperty(double offset) {
        contentPanel.style().setProperty("transform", "translate3d(0px, -" + offset + "%, 0px)");
    }

    @Override
    protected String getStyle() {
        return "v-spin";
    }

    @Override
    protected void fixElementsWidth() {
        ClientRect boundingClientRect = main.getBoundingClientRect();
        double totalHeight = boundingClientRect.height * items.size();
        contentPanel.setHeight(100 * items.size() + "%");

        items.forEach(spinItem -> spinItem.setHeight(((boundingClientRect.height / totalHeight) * 100) + "%"));
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

}
