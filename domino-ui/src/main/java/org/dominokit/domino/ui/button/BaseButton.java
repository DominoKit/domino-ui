package org.dominokit.domino.ui.button;

import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.*;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.span;

public abstract class BaseButton<B extends BaseButton<?>> extends WavesElement<HTMLElement, B> implements
        HasClickableElement, Sizable<B>, HasBackground<B>,
        HasContent<B>, Switchable<B> {

    private static final String DISABLED = "disabled";

    protected final DominoElement<HTMLButtonElement> buttonElement = DominoElement.of(button().css(ButtonStyles.BUTTON));
    private StyleType type;
    private Color background;
    private Color color;
    private ButtonSize size;
    protected String content;
    private BaseIcon<?> icon;
    private HTMLElement textSpan = span().asElement();
    private Text textElement = TextNode.empty();
    private Elevation beforeLinkifyElevation = Elevation.LEVEL_1;

    protected BaseButton() {
    }

    protected BaseButton(String content) {
        this();
        setContent(content);
    }

    protected BaseButton(BaseIcon icon) {
        this();
        setIcon(icon);
    }

    protected BaseButton(String content, StyleType type) {
        this(content);
        setButtonType(type);
    }

    protected BaseButton(BaseIcon icon, StyleType type) {
        this(icon);
        setButtonType(type);
    }

    public BaseButton(String content, Color background) {
        this(content);
        setBackground(background);
    }

    @Override
    public B setContent(String content) {
        this.content = content;
        textElement.textContent = content;
        if (isNull(icon)) {
            buttonElement.appendChild(textElement);
        } else {
            textSpan.appendChild(textElement);
            buttonElement.appendChild(textSpan);
        }
        return (B) this;
    }

    @Override
    public B setTextContent(String text) {
        setContent(text);
        return (B) this;
    }

    public B setSize(ButtonSize size) {
        if (nonNull(this.size))
            buttonElement.style().remove(this.size.getStyle());
        buttonElement.style().add(size.getStyle());
        this.size = size;
        return (B) this;
    }

    public B setBlock(boolean block) {
        if (block)
            buttonElement.style().add(ButtonStyles.BUTTON_BLOCK);
        else
            buttonElement.style().remove(ButtonStyles.BUTTON_BLOCK);
        return (B) this;
    }

    @Override
    public B setBackground(Color background) {
        if (nonNull(this.type))
            buttonElement.style().remove(this.type.getStyle());
        if (nonNull(this.background))
            buttonElement.style().remove(this.background.getBackground());
        buttonElement.style().add(background.getBackground());
        this.background = background;
        return (B) this;
    }

    public B setColor(Color color) {
        if (nonNull(this.color))
            style().remove(this.color.getStyle());
        this.color = color;
        style().add(this.color.getStyle());
        return (B) this;
    }

    public B setButtonType(StyleType type) {
        if (nonNull(this.type))
            buttonElement.style().remove(this.type.getStyle());
        buttonElement.style().add(type.getStyle());
        this.type = type;
        return (B) this;
    }

    @Override
    public B disable() {
        buttonElement.setAttribute(DISABLED, DISABLED);
        return (B) this;
    }

    @Override
    public B enable() {
        buttonElement.removeAttribute(DISABLED);
        return (B) this;
    }

    @Override
    public boolean isEnabled() {
        return !buttonElement.hasAttribute(DISABLED);
    }

    @Override
    public HTMLElement getClickableElement() {
        return asElement();
    }

    @Override
    public B large() {
        setSize(ButtonSize.LARGE);
        return (B) this;
    }

    @Override
    public B small() {
        setSize(ButtonSize.SMALL);
        return (B) this;
    }

    @Override
    public B xSmall() {
        setSize(ButtonSize.XSMALL);
        return (B) this;
    }

    public B block() {
        setBlock(true);
        return (B) this;
    }

    public B linkify() {
        buttonElement.style().add(ButtonStyles.BUTTON_LINK);
        beforeLinkifyElevation = nonNull(buttonElement.getElevation()) ? buttonElement.getElevation() : Elevation.LEVEL_1;
        buttonElement.elevate(Elevation.NONE);
        return (B) this;
    }

    public B deLinkify() {
        buttonElement.style().remove(ButtonStyles.BUTTON_LINK);
        buttonElement.elevate(beforeLinkifyElevation);
        return (B) this;
    }

    public B circle() {
        buttonElement.style().add(ButtonStyles.BUTTON_CIRCLE);
        applyCircleWaves();
        return (B) this;
    }

    public B setIcon(BaseIcon<?> icon) {
        if (nonNull(this.icon)) {
            this.icon.setTextContent(icon.getName());
        } else {
            if (nonNull(content) && !content.isEmpty()) {
                textSpan.appendChild(textElement);
                buttonElement.appendChild(textSpan.appendChild(textElement));
            }
            this.icon = icon;
            buttonElement.appendChild(this.icon);
        }
        icon.addCss("btn-icon");
        return (B) this;
    }

    private void applyCircleWaves() {
        applyWaveStyle(WaveStyle.CIRCLE);
        applyWaveStyle(WaveStyle.FLOAT);
    }
}
