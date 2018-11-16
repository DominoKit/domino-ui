package org.dominokit.domino.ui.alerts;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.BaseDominoElement;

public class AlertLink extends BaseDominoElement<HTMLAnchorElement, AlertLink> {

    private final HTMLAnchorElement element;

    public AlertLink(HTMLAnchorElement element) {
        this.element = element;
        init(this);
        style().add(Styles.alert_link);
    }

    public static AlertLink create(HTMLAnchorElement element){
        return new AlertLink(element);
    }

    @Override
    public HTMLAnchorElement asElement() {
        return element;
    }
}
