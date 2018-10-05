package org.dominokit.domino.ui.cards;

import elemental2.dom.EventListener;
import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLIElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class HeaderAction extends BaseDominoElement<HTMLLIElement, HeaderAction> {

    private HTMLLIElement element = li().asElement();
    private HTMLAnchorElement anchorElement = a().asElement();
    private Icon icon;

    public static HeaderAction create(Icon icon, EventListener eventListener) {
        return new HeaderAction(icon, eventListener);
    }

    public static HeaderAction create(Icon icon) {
        return new HeaderAction(icon);
    }

    public HeaderAction(Icon icon) {
        this.icon = icon;
        this.icon.withWaves()
                .styler(style -> style.add(Styles.pull_right, "action-icon"));
        anchorElement.appendChild(this.icon.asElement());
        element.appendChild(anchorElement);
        init(this);
    }

    public HeaderAction(Icon icon, EventListener eventListener) {
        this(icon);
        anchorElement.addEventListener("click", eventListener);
    }

    @Override
    public HTMLLIElement asElement() {
        return element;
    }

    @Override
    public HTMLElement getClickableElement() {
        return anchorElement;
    }

    public Icon getIcon() {
        return icon;
    }
}
