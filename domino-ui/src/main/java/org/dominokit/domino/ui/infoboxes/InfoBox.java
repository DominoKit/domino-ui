package org.dominokit.domino.ui.infoboxes;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static java.util.Objects.nonNull;

public class InfoBox extends BaseDominoElement<HTMLDivElement, InfoBox> implements HasBackground<InfoBox>, IsElement<HTMLDivElement> {

    private DominoElement<HTMLDivElement> iconElement = DominoElement.div().css("icon");
    private DominoElement<HTMLDivElement> titleElement = DominoElement.div().css("text");
    private DominoElement<HTMLDivElement> valueElement = DominoElement.div()
            .css("number")
            .css("count-to");
    private DominoElement<HTMLDivElement> infoContent = DominoElement.div()
            .css("info-content")
            .appendChild(titleElement)
            .appendChild(valueElement);

    private DominoElement<HTMLDivElement> root = DominoElement.div()
            .css("info-box")
            .elevate(Elevation.LEVEL_1)
            .appendChild(iconElement)
            .appendChild(infoContent);

    private HTMLElement icon;

    private Color counterBackground;

    private Color iconBackground;
    private HoverEffect hoverEffect;
    private Flip flip = Flip.LEFT;
    private Color iconColor;

    public InfoBox(HTMLElement icon, String title, String value) {
        iconElement.appendChild(icon);
        titleElement.setTextContent(title);
        if (nonNull(value)) {
            valueElement.setTextContent(value);
        }
        init(this);
        this.icon = icon;

    }

    public InfoBox(BaseIcon<?> icon, String title, String value) {
        this(icon.asElement(), title, value);
    }

    public InfoBox(HTMLElement icon, String title) {
       this(icon, title, null);
    }
    public InfoBox(BaseIcon<?> icon, String title) {
       this(icon, title, null);
    }

    public static InfoBox create(BaseIcon<?> icon, String title, String value) {
        return new InfoBox(icon, title, value);
    }

    public static InfoBox create(HTMLElement icon, String title, String value) {
        return new InfoBox(icon, title, value);
    }

    public static InfoBox create(HTMLElement icon, String title) {
        return new InfoBox(icon, title);
    }

    public static InfoBox create(BaseIcon<?> icon, String title) {
        return new InfoBox(icon, title);
    }

    @Override
    public InfoBox setBackground(Color background) {
        if (nonNull(counterBackground))
            style().remove(counterBackground.getBackground());
        style().add(background.getBackground());
        this.counterBackground = background;

        return this;
    }

    public InfoBox setIconBackground(Color background) {
        if (nonNull(iconBackground))
            Style.of(iconElement).remove(iconBackground.getBackground());
        Style.of(iconElement).add(background.getBackground());
        this.iconBackground = background;

        return this;
    }

    public InfoBox setHoverEffect(HoverEffect effect) {
        if (nonNull(hoverEffect))
            style().remove(hoverEffect.effectStyle);
        this.hoverEffect = effect;
        style().add(hoverEffect.effectStyle);

        return this;
    }

    public InfoBox removeHoverEffect() {
        if (nonNull(hoverEffect)) {
            style().remove(hoverEffect.effectStyle);
            this.hoverEffect = null;
        }

        return this;
    }

    public InfoBox flipLeft() {
        style().remove(flip.flipStyle);
        this.flip = Flip.LEFT;
        style().add(this.flip.flipStyle);

        return this;
    }

    public InfoBox flipRight() {
        style().remove(flip.flipStyle);
        this.flip = Flip.RIGHT;
        style().add(this.flip.flipStyle);
        return this;
    }

    public InfoBox flip() {
        style().remove(flip.flipStyle);
        if (Flip.LEFT.equals(this.flip)) {
            this.flip = Flip.RIGHT;
        } else {
            this.flip = Flip.LEFT;
        }
        style().add(this.flip.flipStyle);

        return this;
    }

    public InfoBox setIconColor(Color color) {
        if (nonNull(iconColor) && nonNull(icon))
            Style.of(icon).remove(iconColor.getStyle());
        if (nonNull(icon)) {
            this.iconColor = color;
            Style.of(icon).add(this.iconColor.getStyle());
        }

        return this;
    }

    public InfoBox setIcon(HTMLElement element) {
        ElementUtil.clear(iconElement);
        iconElement.appendChild(element);
        return this;
    }

    public InfoBox removeShadow() {
        style().removeShadow();
        return this;
    }

    public InfoBox setValue(String value) {
        getValueElement().setTextContent(value);
        return this;
    }

    public InfoBox setTitle(String title) {
        getTitleElement().setTextContent(title);
        return this;
    }

    public InfoBox setIcon(BaseIcon icon) {
        getIconElement().clearElement()
                .appendChild(icon);
        return this;
    }

    public DominoElement<HTMLDivElement> getIconElement() {
        return iconElement;
    }

    public DominoElement<HTMLDivElement> getTitleElement() {
        return titleElement;
    }

    public DominoElement<HTMLDivElement> getValueElement() {
        return valueElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return root.asElement();
    }

    public enum HoverEffect {
        ZOOM(InfoBoxStyles.HOVER_ZOOM_EFFECT),
        EXPAND(InfoBoxStyles.HOVER_EXPAND_EFFECT);

        private final String effectStyle;

        HoverEffect(String effectStyle) {
            this.effectStyle = effectStyle;
        }

    }

    public enum Flip {

        RIGHT(InfoBoxStyles.INFO_BOX_3),
        LEFT(InfoBoxStyles.INFO_BOX);

        private final String flipStyle;

        Flip(String flipStyle) {
            this.flipStyle = flipStyle;
        }

    }

}