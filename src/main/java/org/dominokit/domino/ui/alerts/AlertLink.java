package org.dominokit.domino.ui.alerts;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

public class AlertLink extends DominoElement<HTMLAnchorElement, AlertLink> implements IsElement<HTMLAnchorElement> {

    private final HTMLAnchorElement element;

    public AlertLink(HTMLAnchorElement element) {
        this.element = element;
        style().add(Styles.alert_link);
        init(this);
    }

    public static AlertLink create(HTMLAnchorElement element){
        return new AlertLink(element);
    }

    @Override
    public HTMLAnchorElement asElement() {
        return element;
    }
}
