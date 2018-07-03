package org.dominokit.domino.ui.infoboxes;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import static java.util.Objects.nonNull;

@Templated
public abstract class InfoBox implements IsElement<HTMLDivElement>, HasBackground<InfoBox> {

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

    @DataElement
    HTMLDivElement iconElement;

    @DataElement
    HTMLDivElement titleElement;

    @DataElement
    HTMLDivElement valueElement;

    HTMLElement icon;

    private Color counterBackground;
    private Color iconBackground;
    private HoverEffect hoverEffect;
    private Flip flip = Flip.LEFT;
    private Color iconColor;

    public static InfoBox create(Icon icon, String title, String value) {

        Templated_InfoBox templated_InfoBox = new Templated_InfoBox();
        templated_InfoBox.iconElement.appendChild(icon.asElement());
        templated_InfoBox.titleElement.textContent = title;
        templated_InfoBox.valueElement.textContent = value;
        templated_InfoBox.icon = icon.asElement();

        return templated_InfoBox;
    }

    public static InfoBox create(HTMLElement icon, String title, String value) {

        Templated_InfoBox templated_InfoBox = new Templated_InfoBox();
        templated_InfoBox.iconElement.appendChild(icon);
        templated_InfoBox.titleElement.textContent = title;
        templated_InfoBox.valueElement.textContent = value;
        templated_InfoBox.icon = icon;

        return templated_InfoBox;
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
            icon.classList.remove(iconColor.getStyle());
        if (nonNull(icon)) {
            this.iconColor = color;
            icon.classList.add(this.iconColor.getStyle());
        }

        return this;
    }

    public InfoBox setIcon(HTMLElement element){
        ElementUtil.clear(iconElement);
        iconElement.appendChild(element);
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
}
