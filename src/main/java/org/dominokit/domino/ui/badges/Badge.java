package org.dominokit.domino.ui.badges;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Badge extends BaseDominoElement<HTMLElement, Badge> implements HasBackground<Badge> {

    private DominoElement<HTMLElement> badgeElement = DominoElement.of(span().css("badge"));
    private Color badgeBackground;

    public Badge() {
        init(this);
    }

    public static Badge create(String content) {
        Badge badge = new Badge();
        badge.badgeElement.setTextContent(content);
        return badge;
    }

    @Override
    public HTMLElement asElement() {
        return badgeElement.asElement();
    }

    public Badge setText(String text) {
        badgeElement.setTextContent(text);
        return this;
    }

    public Badge pullRight() {
        style().pullRight();
        return this;
    }

    @Override
    public Badge setBackground(Color badgeBackground) {
        if (nonNull(this.badgeBackground))
            badgeElement.style().remove(this.badgeBackground.getBackground());

        this.badgeBackground = badgeBackground;
        badgeElement.style().add(this.badgeBackground.getBackground());
        return this;
    }
}
