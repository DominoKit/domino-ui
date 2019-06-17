package org.dominokit.domino.ui.spin;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.div;

public class SpinItem<T> extends BaseDominoElement<HTMLDivElement, SpinItem<T>> {

    private T value;
    private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(SpinStyles.spin_item));

    public SpinItem(T value) {
        this.value = value;
        init(this);
    }

    public SpinItem(T value, Node content) {
        this(value);
        setContent(content);
    }

    public SpinItem(T value, IsElement content) {
        this(value);
        setContent(content);
    }

    public static <T> SpinItem<T> create(T value) {
        return new SpinItem<>(value);
    }

    public static <T> SpinItem<T> create(T value, Node content) {
        return new SpinItem<>(value, content);
    }

    public static <T> SpinItem<T> create(T value, IsElement content) {
        return new SpinItem<>(value, content);
    }

    public T getValue() {
        return value;
    }

    @Override
    public HTMLDivElement asElement() {
        return element.asElement();
    }

}
