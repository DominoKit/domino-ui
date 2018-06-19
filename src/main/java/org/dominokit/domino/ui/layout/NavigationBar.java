package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.jboss.gwt.elemento.core.IsElement;

import static org.jboss.gwt.elemento.core.Elements.*;

public class NavigationBar implements IsElement<HTMLElement> {

    private HTMLAnchorElement navBarExpand = a()
            .css("navbar-toggle", "collapsed")
            .attr("data-toggle", "collapse")
            .attr("data-target", "#navbar-collapse")
            .attr("aria-expanded", "false")
            .asElement();

    private HTMLAnchorElement menu = a().css("bars").asElement();
    private HTMLAnchorElement title = a().css("navbar-brand").asElement();

    private HTMLUListElement topBar = ul().css("nav", "navbar-nav", "navbar-right").asElement();

    private HTMLDivElement navigationBar = div()
            .css("collapse", "navbar-collapse")
            .attr("id", "navbar-collapse")
            .add(topBar)
            .asElement();

    private HTMLElement element = nav()
            .css("navbar", "bars")
            .add(div()
                    .css("container-fluid")
                    .add(div()
                            .css("navbar-header")
                            .add(navBarExpand)
                            .add(menu)
                            .add(title)
                    )
                    .add(navigationBar)
            )
            .asElement();


    private boolean collapsed = true;

    public static NavigationBar create() {
        return new NavigationBar();
    }

    public boolean isCollapsed() {
        return collapsed;
    }

    public NavigationBar setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
        return this;
    }

    @Override
    public HTMLElement asElement() {
        return element;
    }

    public HTMLAnchorElement getNavBarExpand() {
        return navBarExpand;
    }

    public HTMLAnchorElement getMenu() {
        return menu;
    }

    public HTMLAnchorElement getTitle() {
        return title;
    }

    public HTMLUListElement getTopBar() {
        return topBar;
    }

    public HTMLDivElement getNavigationBar() {
        return navigationBar;
    }
}
