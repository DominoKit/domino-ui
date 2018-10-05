package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class TopBarAction extends BaseDominoElement<HTMLLIElement, TopBarAction> {

    private HTMLLIElement element = li().css(Styles.pull_right).asElement();
    private HTMLAnchorElement clickableElement= a().css("js-right-sidebar").asElement();

    public TopBarAction(Icon icon) {
        element.appendChild(clickableElement);
        clickableElement.appendChild(icon.asElement());
        init(this);
    }

    public static TopBarAction create(Icon icon){
        return new TopBarAction(icon);
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return clickableElement;
    }
}
