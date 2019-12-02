package org.dominokit.domino.ui.labels;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Label extends BaseDominoElement<HTMLElement, Label> implements HasContent<Label>, HasBackground<Label> {

    private DominoElement<HTMLElement> span = DominoElement.of(span().css("label"));
    private Color background;

    private Label(String content) {
        setContent(content);
        init(this);
    }

    private Label(String content, StyleType type) {
        this(content);
        setType(type);
    }

    private void setType(StyleType type) {
        span.style().add("label-" + type.getStyle());
    }

    public static Label create(String content) {
        return new Label(content);
    }

    public static Label create(String content, StyleType type) {
        return new Label(content, type);
    }

    public static Label createDefault(String content) {
        return create(content, StyleType.DEFAULT);
    }

    public static Label createPrimary(String content) {
        return create(content, StyleType.PRIMARY);
    }

    public static Label createSuccess(String content) {
        return create(content, StyleType.SUCCESS);
    }

    public static Label createInfo(String content) {
        return create(content, StyleType.INFO);
    }

    public static Label createWarning(String content) {
        return create(content, StyleType.WARNING);
    }

    public static Label createDanger(String content) {
        return create(content, StyleType.DANGER);
    }

    @Override
    public HTMLElement element() {
        return span.element();
    }

    @Override
    public Label setContent(String content) {
        span.setTextContent(content);
        return this;
    }

    @Override
    public Label setBackground(Color background) {
        if (nonNull(this.background))
            span.style().remove(this.background.getBackground());
        span.style().add(background.getBackground());
        this.background = background;
        return this;
    }
}
