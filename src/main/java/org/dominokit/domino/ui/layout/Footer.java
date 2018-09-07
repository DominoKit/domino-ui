package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.footer;

public class Footer extends BaseDominoElement<HTMLElement, Footer> {

    private HTMLElement element = footer().css("footer").asElement();

    public static Footer create() {
        return new Footer();
    }

    public Footer() {
        hide();
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }

    public Footer fixed() {
        element.classList.add("fixed");
        return this;
    }

    public Footer unfixed() {
        element.classList.remove("fixed");
        return this;
    }

    public void hide() {
        asElement().style.display = "none";
    }

    public void show() {
        asElement().style.display = "block";
    }

    public Footer appendChild(Node content) {
        asElement().appendChild(content);
        return this;
    }

    public Footer appendChild(IsElement content) {
        return appendChild(content.asElement());
    }
}