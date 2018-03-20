package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

@Templated
public abstract class NavigationBar implements IsElement<HTMLElement>{

    @DataElement
    HTMLAnchorElement menu;

    @DataElement
    HTMLAnchorElement navBarExpand;

    @DataElement
    HTMLDivElement navigationBar;

    @DataElement
    HTMLUListElement topBar;

    @DataElement
    HTMLAnchorElement title;

    private boolean collapsed=true;

    public static NavigationBar create(){
        return new Templated_NavigationBar();
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public NavigationBar setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
        return this;
    }

}
