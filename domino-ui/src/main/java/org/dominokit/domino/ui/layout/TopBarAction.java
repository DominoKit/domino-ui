package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class TopBarAction extends BaseDominoElement<HTMLLIElement, TopBarAction> {

    private HTMLLIElement element = li().css(Styles.pull_right).element();
    private HTMLAnchorElement clickableElement= a().css("js-right-sidebar").element();

    public TopBarAction(BaseIcon<?> icon) {
        element.appendChild(clickableElement);
        clickableElement.appendChild(icon.element());
        init(this);
    }

    public static TopBarAction create(BaseIcon<?> icon){
        return new TopBarAction(icon);
    }

    @Override
    public HTMLLIElement element() {
        return element;
    }

    @Override
    public HTMLAnchorElement getClickableElement() {
        return clickableElement;
    }
}
