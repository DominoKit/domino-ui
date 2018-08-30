package org.dominokit.domino.ui.badges;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasBackground;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Badge extends DominoElement<HTMLElement, Badge> implements IsElement<HTMLElement>, HasBackground<Badge> {

    private HTMLElement badgeElement = span().css("badge").asElement();
    private Color badgeBackground;

    public Badge() {
        init(this);
    }

    public static Badge create(String content) {
        Badge badge = new Badge();
        badge.badgeElement.textContent = content;
        return badge;
    }

    @Override
    public HTMLElement asElement() {
        return badgeElement;
    }

    public Badge setText(String text) {
        badgeElement.textContent = text;
        return this;
    }

    public Badge pullRight() {
        style().pullRight();
        return this;
    }

    @Override
    public Badge setBackground(Color badgeBackground) {
        if (nonNull(this.badgeBackground))
            badgeElement.classList.remove(this.badgeBackground.getBackground());

        this.badgeBackground = badgeBackground;
        badgeElement.classList.add(this.badgeBackground.getBackground());
        return this;
    }
}
