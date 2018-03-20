package org.dominokit.domino.ui.badges;

import org.dominokit.domino.ui.style.Background;
import org.dominokit.domino.ui.utils.HasBackground;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

import static java.util.Objects.nonNull;
import static org.jboss.gwt.elemento.core.Elements.span;

public class Badge implements IsElement<HTMLElement>, HasBackground<Badge> {

    private HTMLElement badgeElement = span().css("badge").asElement();
    private boolean pulledRight = false;
    private Background badgeBackground;

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
        if (!pulledRight)
            badgeElement.classList.add("pull-right");

        return this;
    }

    @Override
    public Badge setBackground(Background badgeBackground) {
        if (nonNull(this.badgeBackground))
            badgeElement.classList.remove(this.badgeBackground.getStyle());

        this.badgeBackground = badgeBackground;
        badgeElement.classList.add(this.badgeBackground.getStyle());
        return this;
    }
}
