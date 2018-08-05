package org.dominokit.domino.ui.button;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.collapsible.Collapsible;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.WaveStyle;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.*;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Button extends WavesElement<Button, HTMLElement> implements
        Justifiable, HasClickableElement, Sizable<Button>, HasBackground<Button>,
        HasContent<Button>, IsElement<HTMLElement>, IsHtmlComponent<HTMLElement, Button>, HasStyleProperty<Button>,
        Switchable<Button> , IsCollapsible<Button>{

    private static final String DISABLED = "disabled";

    final HTMLElement buttonElement = Elements.button().css("btn").asElement();
    private StyleType type;
    private Color background;
    private Color color;
    private ButtonSize size;
    protected String content;
    private HtmlComponentBuilder<HTMLElement, Button> buttonComponentBuilder = new HtmlComponentBuilder<>(this);
    private Collapsible collapsible;

    private static Button create(String content, StyleType type) {
        return new Button(content, type);
    }

    public static Button create() {
        return new Button();
    }

    public static Button create(String content) {
        return new Button(content);
    }

    public static Button createDefault(String content) {
        return create(content, StyleType.DEFAULT);
    }


    public static Button createPrimary(String content) {
        return create(content, StyleType.PRIMARY);
    }

    public static Button createSuccess(String content) {
        return create(content, StyleType.SUCCESS);
    }

    public static Button createInfo(String content) {
        return create(content, StyleType.INFO);
    }

    public static Button createWarning(String content) {
        return create(content, StyleType.WARNING);
    }

    public static Button createDanger(String content) {
        return create(content, StyleType.DANGER);
    }

    protected Button() {
        super.init(this, buttonElement);
        collapsible= Collapsible.create(this);
    }

    protected Button(String content) {
        this();
        setContent(content);
    }

    protected Button(String content, StyleType type) {
        this(content);
        setButtonType(type);
    }

    @Override
    public Button setContent(String content) {
        this.content = content;
        buttonElement.textContent = this.content;
        return this;
    }

    public Button setSize(ButtonSize size) {
        if (nonNull(this.size))
            buttonElement.classList.remove("btn-" + this.size.getStyle());
        buttonElement.classList.add("btn-" + size.getStyle());
        this.size = size;
        return this;
    }

    public Button setBlock(boolean block) {
        if (block)
            buttonElement.classList.add("btn-block");
        else
            buttonElement.classList.remove("btn-block");
        return this;
    }

    @Override
    public Button setBackground(Color background) {
        if (nonNull(this.type))
            buttonElement.classList.remove("btn-" + this.type.getStyle());
        if (nonNull(this.background))
            buttonElement.classList.remove(this.background.getBackground());
        buttonElement.classList.add(background.getBackground());
        this.background = background;
        return this;
    }

    public Button setColor(Color color) {
        if (nonNull(this.color))
            asElement().classList.remove(this.color.getStyle());
        this.color = color;
        asElement().classList.add(this.color.getStyle());
        return this;
    }

    public Button setButtonType(StyleType type) {
        if (nonNull(this.type))
            buttonElement.classList.remove("btn-" + this.type.getStyle());
        buttonElement.classList.add("btn-" + type.getStyle());
        this.type = type;
        return this;
    }

    @Override
    public Button disable() {
        buttonElement.setAttribute(DISABLED, DISABLED);
        return this;
    }

    @Override
    public Button enable() {
        buttonElement.removeAttribute(DISABLED);
        return this;
    }

    @Override
    public boolean isEnabled() {
        return !buttonElement.hasAttribute(DISABLED);
    }

    @Override
    public HTMLElement asElement() {
        return buttonElement;
    }

    @Override
    public HTMLElement justify() {
        return Elements.a()
                .css(asElement().className)
                .attr("role", "button")
                .textContent(asElement().textContent).asElement();
    }

    @Override
    public HTMLElement getClickableElement() {
        return asElement();
    }

    public Button appendContent(Node node) {
        this.asElement().appendChild(node);
        return this;
    }

    @Override
    public Button large() {
        setSize(ButtonSize.LARGE);
        return this;
    }

    @Override
    public Button small() {
        setSize(ButtonSize.SMALL);
        return this;
    }

    @Override
    public Button xSmall() {
        setSize(ButtonSize.XSMALL);
        return this;
    }

    public Button block() {
        setBlock(true);
        return this;
    }

    public Button linkify() {
        buttonElement.classList.add("btn-link");
        return this;
    }

    public Button addClickListener(EventListener listener) {
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return this;
    }

    public Button circle(CircleSize size) {
        buttonElement.classList.add(size.getStyle());
        applyCircleWaves();
        return this;
    }

    private void applyCircleWaves() {
        applyWaveStyle(WaveStyle.CIRCLE);
        applyWaveStyle(WaveStyle.FLOAT);
    }

    @Override
    public HtmlComponentBuilder<HTMLElement, Button> htmlBuilder() {
        return buttonComponentBuilder;
    }

    @Override
    public Button setStyleProperty(String name, String value) {
        asElement().style.setProperty(name, value);
        return this;
    }

    @Override
    public Button collapse() {
        collapsible.collapse();
        return this;
    }

    @Override
    public Button expand() {
        collapsible.expand();
        return this;
    }

    @Override
    public Button collapse(int duration) {
        collapsible.collapse(duration);
        return this;
    }

    @Override
    public Button expand(int duration) {
        collapsible.expand(duration);
        return this;
    }

    @Override
    public Button toggle() {
        collapsible.toggle();
        return this;
    }

    @Override
    public boolean isCollapsed() {
        return collapsible.isCollapsed();
    }
}
