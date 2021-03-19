package org.dominokit.domino.ui.spin;

import elemental2.dom.DOMRect;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.SwipeUtil;

/**
 * A component provides vertical spin
 *
 * @param <T> the type of the object inside the spin
 */
public class VSpinSelect<T> extends SpinSelect<T, VSpinSelect<T>> {

    /**
     * Creates new instance
     *
     * @param <T> the type of the object inside the spin
     * @return new instance
     */
    public static <T> VSpinSelect<T> create() {
        return new VSpinSelect<>();
    }

    /**
     * Creates new instance with back/forward icons
     *
     * @param backIcon    the back {@link BaseIcon}
     * @param forwardIcon the forward {@link BaseIcon}
     * @param <T>         the type of the object inside the spin
     * @return new instance
     */
    public static <T> VSpinSelect<T> create(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
        return new VSpinSelect<>(backIcon, forwardIcon);
    }

    public VSpinSelect() {
        this(Icons.ALL.keyboard_arrow_up(), Icons.ALL.keyboard_arrow_down());
    }

    public VSpinSelect(BaseIcon<?> backIcon, BaseIcon<?> forwardIcon) {
        super(backIcon, forwardIcon);
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.DOWN, main.element(), evt -> moveBack());
        SwipeUtil.addSwipeListener(SwipeUtil.SwipeDirection.UP, main.element(), evt -> moveForward());
        setHeight("50px");
    }

    @Override
    protected void setTransformProperty(double offset) {
        contentPanel.style().setProperty("transform", "translate3d(0px, -" + offset + "%, 0px)");
    }

    @Override
    protected String getStyle() {
        return SpinStyles.V_SPIN;
    }

    @Override
    protected void fixElementsWidth() {
        DOMRect boundingClientRect = main.getBoundingClientRect();
        double totalHeight = boundingClientRect.height * items.size();
        contentPanel.setHeight(100 * items.size() + "%");

        items.forEach(spinItem -> spinItem.setHeight(((boundingClientRect.height / totalHeight) * 100) + "%"));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLDivElement element() {
        return element.element();
    }
}
