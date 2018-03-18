package com.progressoft.brix.domino.ui.labels;

import com.progressoft.brix.domino.ui.style.Background;
import com.progressoft.brix.domino.ui.style.StyleType;
import com.progressoft.brix.domino.ui.utils.HasBackground;
import com.progressoft.brix.domino.ui.utils.HasContent;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Label implements IsElement<HTMLElement>, HasContent<Label>, HasBackground<Label> {

    private HTMLElement span = Elements.span().css("label").asElement();
    private Background background;

    private Label(String content) {
        setContent(content);
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
    public Label setBackground(Background background) {
        if (nonNull(this.background))
            span.classList.remove(this.background.getStyle());
        span.classList.add(background.getStyle());
        this.background = background;
        return this;
    }
}
