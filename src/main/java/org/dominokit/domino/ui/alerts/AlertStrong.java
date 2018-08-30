package org.dominokit.domino.ui.alerts;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.strong;

public class AlertStrong extends DominoElement<HTMLElement, AlertStrong> implements IsElement<HTMLElement> {

    private HTMLElement element = strong().asElement();

    public AlertStrong(String text){
        element.textContent = text;
    }

    public static AlertStrong create(String text){
        return new AlertStrong(text);
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
