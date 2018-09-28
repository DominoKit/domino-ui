package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.gwt.elemento.core.Elements.footer;

public class Footer extends BaseDominoElement<HTMLElement, Footer> {

    private DominoElement<HTMLElement> element = DominoElement.of(footer().css("footer"));

    public static Footer create() {
        return new Footer();
    }

    public Footer() {
        hide();
        init(this);
    }

    @Override
    public HTMLElement asElement() {
        return element.asElement();
    }

    public Footer fixed() {
        element.style().add("fixed");
        return this;
    }

    public Footer unfixed() {
        element.style().remove("fixed");
        return this;
    }

    public void hide() {
        element.style().setDisplay("none");
    }

    public void show() {
        element.style().setDisplay("block");
    }
}