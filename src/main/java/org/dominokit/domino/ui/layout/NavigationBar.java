package org.dominokit.domino.ui.layout;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.gwt.elemento.template.DataElement;
import org.jboss.gwt.elemento.template.Templated;

import javax.annotation.PostConstruct;

@Templated
public abstract class NavigationBar extends BaseDominoElement<HTMLElement, NavigationBar> {

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

    @DataElement
    HTMLDivElement navBarHeader;

    private boolean collapsed = true;

    @PostConstruct
    void init() {
        init(this);
    }

    public static NavigationBar create() {
        return new Templated_NavigationBar();
    }

    @Override
    public boolean isHidden() {
        return collapsed;
    }

    public NavigationBar setCollapsed(boolean collapsed) {
        this.collapsed = collapsed;
        return this;
    }

    public DominoElement<HTMLAnchorElement> getMenu() {
        return DominoElement.of(menu);
    }

    public DominoElement<HTMLAnchorElement> getNavBarExpand() {
        return DominoElement.of(navBarExpand);
    }

    public DominoElement<HTMLDivElement> getNavigationBar() {
        return DominoElement.of(navigationBar);
    }

    public DominoElement<HTMLDivElement> getNavBarHeader() {
        return DominoElement.of(navBarHeader);
    }

    public DominoElement<HTMLUListElement> getTopBar() {
        return DominoElement.of(topBar);
    }

    public DominoElement<HTMLAnchorElement> getTitle() {
        return DominoElement.of(title);
    }
}
