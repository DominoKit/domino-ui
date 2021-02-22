package org.dominokit.domino.ui.alerts;

import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Wrapper element for {@link HTMLAnchorElement} that adds {@link AlertStyles#ALERT_LINK} by default
 *
 * @see Alert
 * @see BaseDominoElement
 */
public class AlertLink extends BaseDominoElement<HTMLAnchorElement, AlertLink> {

    private final HTMLAnchorElement element;

    public AlertLink(HTMLAnchorElement element) {
        this.element = element;
        init(this);
        style().add(AlertStyles.ALERT_LINK);
    }

    /**
     * Creates wrapper for the original anchor element
     *
     * @param element the original anchor element
     * @return new link instance
     */
    public static AlertLink create(HTMLAnchorElement element) {
        return new AlertLink(element);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLAnchorElement element() {
        return element;
    }
}
