package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.elemento.Elements.footer;

public class Footer extends BaseDominoElement<HTMLElement, Footer> {

    private DominoElement<HTMLElement> element = DominoElement.of(footer().css("footer"));
    private boolean autoUnFixForSmallScreens = true;
    private boolean fixed = false;

    public static Footer create() {
        return new Footer();
    }

    public Footer() {
        init(this);
        hide();
    }

    @Override
    public HTMLElement element() {
        return element.element();
    }

    public Footer fixed() {
        element.style().add("fixed");
        this.fixed = true;
        return this;
    }

    public Footer unfixed() {
        element.style().remove("fixed");
        this.fixed = false;
        return this;
    }

    public boolean isAutoUnFixForSmallScreens() {
        return autoUnFixForSmallScreens;
    }

    public Footer setAutoUnFixForSmallScreens(boolean autoUnFixForSmallScreens) {
        this.autoUnFixForSmallScreens = autoUnFixForSmallScreens;
        return this;
    }

    public boolean isFixed() {
        return fixed;
    }
}