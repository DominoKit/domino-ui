package org.dominokit.domino.ui.cards;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.dominokit.domino.ui.cards.CardStyles.ACTION_ICON;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class HeaderAction extends BaseDominoElement<HTMLLIElement, HeaderAction> {

    private HTMLLIElement element = li().element();
    private HTMLAnchorElement anchorElement = a().element();
    private BaseIcon<?> icon;

    public static HeaderAction create(BaseIcon<?> icon, EventListener eventListener) {
        return new HeaderAction(icon, eventListener);
    }

    public static HeaderAction create(BaseIcon<?> icon) {
        return new HeaderAction(icon);
    }

    public HeaderAction(BaseIcon<?> icon) {
        this.icon = icon;
        this.icon.clickable()
                .styler(style -> style.add(Styles.pull_right, ACTION_ICON));
        anchorElement.appendChild(this.icon.element());
        element.appendChild(anchorElement);
        init(this);
    }

    public HeaderAction(BaseIcon<?> icon, EventListener eventListener) {
        this(icon);
        anchorElement.addEventListener("click", eventListener);
    }

    @Override
    public HTMLLIElement element() {
        return element;
    }

    @Override
    public HTMLElement getClickableElement() {
        return anchorElement;
    }

    public BaseIcon<?> getIcon() {
        return icon;
    }
}
