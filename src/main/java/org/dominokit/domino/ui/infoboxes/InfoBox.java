package org.dominokit.domino.ui.infoboxes;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.div;

public class InfoBox implements IsElement<HTMLDivElement>, HasBackground<InfoBox> {

    public enum HoverEffect {
        ZOOM("hover-zoom-effect"),
        EXPAND("hover-expand-effect");

        private final String effectStyle;

        HoverEffect(String effectStyle) {
            this.effectStyle = effectStyle;
        }

    }

    public enum Flip {
        RIGHT("info-box-3"),
        LEFT("info-box");

        private final String flipStyle;

        Flip(String flipStyle) {
            this.flipStyle = flipStyle;
        }
    }

    private HTMLDivElement iconElement = div().css("icon").asElement();

    private HTMLDivElement titleElement = div().css("text").asElement();
    private HTMLDivElement valueElement = div().css("number", "count-to").asElement();


    private HTMLDivElement element = div()
            .css("info-box")
            .add(iconElement)
            .add(div().css("content")
                    .add(titleElement)
                    .add(valueElement))
            .asElement();

    private Icon icon;

    private Color counterBackground;
    private Color iconBackground;
    private HoverEffect hoverEffect;
    private Flip flip = Flip.LEFT;
    private Color iconColor;

    public static InfoBox create(Icon icon, String title, String value) {

        InfoBox infoBox = new InfoBox();
        infoBox.iconElement.appendChild(icon.asElement());
        infoBox.titleElement.textContent = title;
        infoBox.valueElement.textContent = value;
        infoBox.icon = icon;

        return infoBox;
    }

    @Override
    public InfoBox setBackground(Color background) {
        if (nonNull(counterBackground))
            this.asElement().classList.remove(counterBackground.getBackground());
        this.asElement().classList.add(background.getBackground());
        this.counterBackground = background;

        return this;
    }

    public InfoBox setIconBackground(Color background) {
        if (nonNull(iconBackground))
            iconElement.classList.remove(iconBackground.getBackground());
        iconElement.classList.add(background.getBackground());
        this.iconBackground = background;

        return this;
    }

    public InfoBox setHoverEffect(HoverEffect effect) {
        if (nonNull(hoverEffect))
            this.asElement().classList.remove(hoverEffect.effectStyle);
        this.hoverEffect = effect;
        this.asElement().classList.add(hoverEffect.effectStyle);

        return this;
    }

    public InfoBox removeHoverEffect() {
        if (nonNull(hoverEffect)) {
            this.asElement().classList.remove(hoverEffect.effectStyle);
            this.hoverEffect = null;
        }

        return this;
    }

    public InfoBox flipLeft() {
        this.asElement().classList.remove(flip.flipStyle);
        this.flip = Flip.LEFT;
        this.asElement().classList.add(this.flip.flipStyle);

        return this;
    }

    public InfoBox flipRight() {
        this.asElement().classList.remove(flip.flipStyle);
        this.flip = Flip.RIGHT;
        this.asElement().classList.add(this.flip.flipStyle);
        return this;
    }

    public InfoBox flip() {
        this.asElement().classList.remove(flip.flipStyle);
        if (Flip.LEFT.equals(this.flip)) {
            this.flip = Flip.RIGHT;
        } else {
            this.flip = Flip.LEFT;
        }
        this.asElement().classList.add(this.flip.flipStyle);

        return this;
    }

    public InfoBox setIconColor(Color color) {
        if (nonNull(iconColor) && nonNull(icon))
            icon.asElement().classList.remove(iconColor.getStyle());
        if (nonNull(icon)) {
            this.iconColor = color;
            icon.asElement().classList.add(this.iconColor.getStyle());
        }

        return this;
    }

    public HTMLDivElement getIconElement() {
        return iconElement;
    }

    public HTMLDivElement getTitleElement() {
        return titleElement;
    }

    public HTMLDivElement getValueElement() {
        return valueElement;
    }

    @Override
    public HTMLDivElement asElement() {
        return element;
    }

}
