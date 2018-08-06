package org.dominokit.domino.ui.labels;

import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.HasContent;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Label extends DominoElement<Label> implements IsElement<HTMLElement>, HasContent<Label>, HasBackground<Label> {

    private HTMLElement span = Elements.span().css("label").asElement();
    private Color background;

    private Label(String content) {
        setContent(content);
        initCollapsible(this);
    }

    private Label(String content, StyleType type) {
        this(content);
        setType(type);
    }

    private void setType(StyleType type) {
        span.classList.add("label-" + type.getStyle());
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
    public HTMLElement asElement() {
        return span;
    }

    @Override
    public Label setContent(String content) {
        span.textContent = content;
        return this;
    }

    @Override
    public Label setBackground(Color background) {
        if (nonNull(this.background))
            span.classList.remove(this.background.getBackground());
        span.classList.add(background.getBackground());
        this.background = background;
        return this;
    }
}
