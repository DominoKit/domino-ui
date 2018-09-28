package org.dominokit.domino.ui.infoboxes;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

import static java.util.Objects.nonNull;

@Templated
public abstract class InfoBox extends BaseDominoElement<HTMLDivElement, InfoBox> implements HasBackground<InfoBox>, IsElement<HTMLDivElement> {

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

    @PostConstruct
    void init() {
        init(this);
    }

    public static InfoBox create(Icon icon, String title, String value) {
        Templated_InfoBox templated_InfoBox = new Templated_InfoBox();
        templated_InfoBox.getIconElement().appendChild(icon);
        templated_InfoBox.getTitleElement().setTextContent(title);
        templated_InfoBox.getValueElement().setTextContent(value);
        templated_InfoBox.icon = icon.asElement();
        return templated_InfoBox;
    }

    public static InfoBox create(HTMLElement icon, String title, String value) {
        Templated_InfoBox templated_InfoBox = new Templated_InfoBox();
        templated_InfoBox.getIconElement().appendChild(icon);
        templated_InfoBox.getTitleElement().setTextContent(title);
        templated_InfoBox.getValueElement().setTextContent(value);
        templated_InfoBox.icon = icon;
        return templated_InfoBox;
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
        style()
                .setBoxShadow("none")
                .setProperty("-webkit-box-shadow", "none");
        return this;
    }

    public DominoElement<HTMLDivElement> getIconElement() {
        return DominoElement.of(iconElement);
    }

    public DominoElement<HTMLDivElement> getTitleElement() {
        return DominoElement.of(titleElement);
    }

    public DominoElement<HTMLDivElement> getValueElement() {
        return DominoElement.of(valueElement);
    }
}
