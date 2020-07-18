package org.dominokit.domino.ui.tabs;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.*;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.jboss.elemento.IsElement;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.tabs.TabStyles.*;
import static org.jboss.elemento.Elements.*;

public class VerticalTab extends WavesElement<HTMLDivElement, VerticalTab> implements HasClickableElement {

    private String title;
    private FlexItem element;
    private HTMLAnchorElement anchorElement;

    private BaseIcon<?> icon;
    private DominoElement<HTMLElement> titleElement;
    private DominoElement<HTMLDivElement> contentContainer = DominoElement.of(div()
            .attr("role", "tabpanel")
            .css(TAB_PANE, FADE));
    private boolean active;
    private DominoElement<HTMLDivElement> iconContainer = DominoElement.div();
    private DominoElement<HTMLDivElement> textContainer = DominoElement.div()
            .styler(style -> style.setMarginTop(Unit.px.of(2)));

    private Color textColor;
    private Color iconColor;

    private final List<VerticalTab.ActivationHandler> activationHandlers = new ArrayList<>();

    private boolean textColorOverridden = false;
    private boolean iconColorOverridden = false;

    private Color color = Color.GREY_DARKEN_3;

    public VerticalTab(String title, BaseIcon<?> icon) {
        this.title = title;
        setIcon(icon);
        this.titleElement = DominoElement.of(span().css(TITLE).textContent(title));
        this.anchorElement = a()
                .add(iconContainer.appendChild(this.icon))
                .add(textContainer.appendChild(titleElement)).element();
        init();
    }

    public VerticalTab(String title) {
        this.title = title;
        this.titleElement = DominoElement.of(span().css(TITLE).textContent(title));
        this.anchorElement = a()
                .add(iconContainer)
                .add(textContainer.appendChild(titleElement)).element();
        init();
    }

    public VerticalTab(BaseIcon<?> icon) {
        setIcon(icon);
        this.anchorElement = a()
                .add(iconContainer.appendChild(this.icon))
                .add(textContainer)
                .element();
        init();
    }

    public static VerticalTab create(String title) {
        return new VerticalTab(title);
    }

    public static VerticalTab create(String title, BaseIcon<?> icon) {
        return new VerticalTab(title, icon);
    }

    public static VerticalTab create(BaseIcon<?> icon) {
        return new VerticalTab(icon);
    }

    private void init() {
        this.element = FlexItem.create()
                .css(Color.GREY_DARKEN_3.getStyle());
        this.element.appendChild(anchorElement);
        init(this);
        setWaveColor(WaveColor.THEME);
        applyWaveStyle(WaveStyle.BLOCK);
    }

    public DominoElement<HTMLDivElement> getContentContainer() {
        return DominoElement.of(contentContainer);
    }

    public VerticalTab activate() {
        Style.of(element()).add(ACTIVE);
        contentContainer.style().add(IN, ACTIVE);
        this.active = true;
        activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, true));
        return this;
    }

    public VerticalTab deactivate() {
        Style.of(element()).remove(ACTIVE);
        contentContainer.style().remove(IN, ACTIVE);
        this.active = false;
        activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, false));
        return this;
    }

    public VerticalTab appendChild(Node content) {
        contentContainer.appendChild(content);
        return this;
    }

    public VerticalTab setTitle(String title) {
        titleElement.setTextContent(title);
        return this;
    }

    public VerticalTab appendChild(IsElement<?> content) {
        return appendChild(content.element());
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return anchorElement;
    }

    public VerticalTab setIcon(BaseIcon<?> icon) {
        this.icon = icon;
        iconContainer.clearElement();
        iconContainer.appendChild(icon);
        return this;
    }

    public String getTitle() {
        return title;
    }

    public boolean isActive() {
        return active;
    }

    public DominoElement<HTMLElement> getTitleElement() {
        return DominoElement.of(titleElement);
    }

    @Override
    public HTMLElement getWavesElement() {
        return anchorElement;
    }

    @Override
    public HTMLDivElement element() {
        return element.element();
    }

    public VerticalTab setTextColor(Color textColor) {
        if (!textColorOverridden && nonNull(title)) {
            if (nonNull(this.textColor)) {
                this.titleElement.removeCss(this.textColor.getStyle());
            }
            this.titleElement.addCss(textColor.getStyle());
            this.textColor = textColor;
        }
        return this;
    }

    public VerticalTab setIconColor(Color iconColor) {
        if (!iconColorOverridden && nonNull(icon)) {
            if (nonNull(this.iconColor)) {
                this.icon.removeCss(this.iconColor.getStyle());
            }
            this.icon.addCss(iconColor.getStyle());
            this.iconColor = iconColor;
        }
        return this;
    }

    public VerticalTab setTextColorOverride(Color textColor) {
        setTextColor(textColor);
        this.textColorOverridden = true;
        return this;
    }

    public VerticalTab setIconColorOverride(Color iconColor) {
        setIconColor(iconColor);
        this.iconColorOverridden = true;
        return this;
    }

    public VerticalTab addActivationHandler(VerticalTab.ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.add(activationHandler);
        }
        return this;
    }

    public VerticalTab removeActivationHandler(VerticalTab.ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.remove(activationHandler);
        }
        return this;
    }

    public VerticalTab setColor(Color color) {
        element.removeCss(this.color.getStyle());
        element.css(color.getStyle());
        this.color = color;
        return this;
    }

    public VerticalTab resetColor() {
        element.removeCss(this.color.getStyle());
        element.css(Color.GREY_DARKEN_3.getStyle());
        this.color = Color.GREY_DARKEN_3;
        return this;
    }

    @FunctionalInterface
    public interface ActivationHandler {
        void onActiveStateChanged(VerticalTab tab, boolean active);
    }
}
