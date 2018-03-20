package org.dominokit.domino.ui.button;

import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.style.StyleType;
import org.dominokit.domino.ui.style.Waves;
import org.dominokit.domino.ui.style.WavesElement;
import org.dominokit.domino.ui.utils.*;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;

public class Button extends WavesElement<Button, HTMLElement> implements
        Justifiable, HasClickableElement, Sizable<Button>, HasBackground<Button>,
        HasContent<Button>, IsElement<HTMLElement>, IsHtmlComponent<HTMLElement, Button>, HasStyleProperty<Button>{

    final HTMLElement buttonElement = Elements.button().css("btn").asElement();
    private StyleType type;
    private Background background;
    private ButtonSize size;
    protected String content;
    private HtmlComponentBuilder<HTMLElement, Button> buttonComponentBuilder =new HtmlComponentBuilder<>(this);

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
        Waves.init();
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
    public Button setBackground(Background background) {
        if (nonNull(this.type))
            buttonElement.classList.remove("btn-" + this.type.getStyle());
        if (nonNull(this.background))
            buttonElement.classList.remove(this.background.getStyle());
        buttonElement.classList.add(background.getStyle());
        this.background = background;
        return this;
    }

    public Button setButtonType(StyleType type) {
        if (nonNull(this.type))
            buttonElement.classList.remove("btn-" + this.type.getStyle());
        buttonElement.classList.add("btn-" + type.getStyle());
        this.type = type;
        return this;
    }

    public Button disable() {
        buttonElement.setAttribute("disabled", "disabled");
        return this;
    }

    public Button enable() {
        buttonElement.removeAttribute("disabled");
        return this;
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

    public Button linkify(){
        buttonElement.classList.add("btn-link");
        return this;
    }

    public Button addClickListener(EventListener listener){
        getClickableElement().addEventListener(EventType.click.getName(), listener);
        return this;
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
}
