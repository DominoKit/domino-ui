package org.dominokit.domino.ui.badges;

import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.dominokit.domino.ui.utils.TextNode;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Badge extends BaseDominoElement<HTMLElement, Badge> implements HasBackground<Badge> {

    private DominoElement<HTMLElement> badgeElement = DominoElement.of(span()
            .css(BadgeStyles.BADGE)
            .css(Styles.default_shadow));
    private Color badgeBackground;
    private Text textNode = TextNode.empty();

    public Badge() {
        init(this);
        appendChild(textNode);
    }

    public static Badge create(String content) {
        Badge badge = new Badge();
        badge.setText(content);
        return badge;
    }

    @Override
    public HTMLElement asElement() {
        return badgeElement.asElement();
    }

    public Badge setText(String text) {
        textNode.textContent = text;
        return this;
    }

    public Badge pullRight() {
        style().pullRight();
        return this;
    }

    @Override
    public Badge setBackground(Color badgeBackground) {
        if (nonNull(this.badgeBackground)) {
            badgeElement.style().remove(this.badgeBackground.getBackground());
        }

        this.badgeBackground = badgeBackground;
        badgeElement.style().add(this.badgeBackground.getBackground());
        return this;
    }
}
