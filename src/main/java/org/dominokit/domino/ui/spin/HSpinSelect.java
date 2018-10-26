package org.dominokit.domino.ui.spin;

import elemental2.dom.ClientRect;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.SwipeUtil;

public class HSpinSelect<T> extends SpinSelect<T, HSpinSelect<T>>{

    public static <T> HSpinSelect<T> create() {
        return new HSpinSelect<>();
    }

    public static <T> HSpinSelect<T> create(BaseIcon<?> backIcon, Icon forwardIcon) {
        return new HSpinSelect<>(backIcon, forwardIcon);
    }

    public HSpinSelect() {
        this(Icons.ALL.keyboard_arrow_left(), Icons.ALL.keyboard_arrow_right());
    }

    public HSpinSelect(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
        super(backIcon, forwardIcon);
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.RIGHT, main.asElement(), evt -> moveBack());
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.LEFT, main.asElement(), evt -> moveForward());
    }

    @Override
    protected void fixElementsWidth() {
        ClientRect boundingClientRect = main.getBoundingClientRect();
        double totalWidth = boundingClientRect.width * items.size();
        contentPanel.setWidth(100 * items.size() + "%");

        items.forEach(spinItem -> spinItem.setWidth(((boundingClientRect.width / totalWidth) * 100) + "%"));
    }

    @Override
    protected void setTransformProperty(double offset) {
        contentPanel.style().setProperty("transform", "translate3d(-" + offset + "%, 0px, 0px)");
    }

    @Override
    protected String getStyle() {
        return "h-spin";
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }


}
