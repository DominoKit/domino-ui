package org.dominokit.domino.ui.collapsible;

import org.dominokit.domino.ui.utils.IsCollapsible;
import elemental2.dom.HTMLElement;
import org.jboss.gwt.elemento.core.IsElement;

public class Collapsible implements IsElement<HTMLElement>, IsCollapsible<Collapsible> {

    private final HTMLElement element;
    private boolean collapsed = true;

    public Collapsible(HTMLElement element) {
        this.element = element;
        if (!element.classList.contains("collapse"))
            this.element.classList.add("collapse");
    }

    public static Collapsible create(HTMLElement element) {
        return new Collapsible(element);
    }

    public Collapsible collapse() {
        this.element.classList.remove("in");
        this.collapsed = true;
        return this;
    }

    public Collapsible expand() {
        this.element.classList.add("in");
        this.collapsed = false;
        return this;
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    @Override
    public Collapsible toggle() {
        if (isCollapsed())
            expand();
        else
            collapse();

        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }
}
