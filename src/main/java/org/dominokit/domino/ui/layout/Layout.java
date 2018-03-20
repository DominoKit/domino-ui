package org.dominokit.domino.ui.layout;

import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.themes.Theme;
import elemental2.dom.*;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class Layout implements IsLayout {

    private static final String SLIDE_OUT = "-300px";
    private static final String SLIDE_IN = "0px";
    private static final String NONE = "none";
    private static final String BLOCK = "block";
    private static final String COLLAPSE = "collapse";
    private static final String CLICK = "click";

    private final NavigationBar navigationBar = NavigationBar.create();
    private final Section section = Section.create();
    private final Overlay overlay = Overlay.create();
    private final Content content = Content.create();

    private Text appTitle=new Text("");

    private boolean leftPanelVisible = false;
    private boolean rightPanelVisible = false;
    private boolean navigationBarExpanded = false;
    private boolean overlayVisible = false;
    private boolean fixedLeftPanel;

    @Override
    public Layout show() {
        return show(Theme.currentTheme);
    }

    @Override
    public Layout show(Theme theme){
        appendElements();
        initElementsPosition();
        addExpandListeners();
        document.body.classList.add("ls-closed");
        theme.apply();
        return this;
    }

    private void appendElements() {
        document.body.appendChild(overlay.asElement());
        document.body.appendChild(navigationBar.asElement());
        document.body.appendChild(section.asElement());
        document.body.appendChild(content.asElement());
        navigationBar.title.appendChild(appTitle);
    }

    private void initElementsPosition() {
        section.leftSide.style.marginLeft = CSSProperties.MarginLeftUnionType.of(0);
        section.rightSide.style.marginRight = CSSProperties.MarginRightUnionType.of(0);
        section.leftSide.style.left = SLIDE_OUT;
        section.rightSide.style.right = SLIDE_OUT;
    }

    private void addExpandListeners() {
        navigationBar.menu.addEventListener(CLICK, e -> toggleLeftPanel());
        navigationBar.navBarExpand.addEventListener(CLICK, e -> toggleNavigationBar());
        overlay.asElement().addEventListener(CLICK, e -> hidePanels());
    }

    private void hidePanels() {
        hideRightPanel();
        hideLeftPanel();
        collapseNavBar();
        hideOverlay();
    }

    private void toggleNavigationBar() {
        if (navigationBarExpanded)
            collapseNavBar();
        else
            expandNavBar();
    }

    private void expandNavBar() {
        if (leftPanelVisible)
            hideLeftPanel();
        if (rightPanelVisible)
            hideRightPanel();
        navigationBar.navigationBar.classList.remove(COLLAPSE);
        navigationBarExpanded = true;
    }

    private void collapseNavBar() {
        navigationBar.navigationBar.classList.add(COLLAPSE);
        navigationBarExpanded = false;
    }

    @Override
    public void toggleRightPanel() {
        if (rightPanelVisible)
            hideRightPanel();
        else
            showRightPanel();
    }

    @Override
    public Layout showRightPanel() {
        if (leftPanelVisible)
            hideLeftPanel();
        if (navigationBarExpanded)
            collapseNavBar();
        section.rightSide.style.right = SLIDE_IN;
        rightPanelVisible = true;
        showOverlay();

        return this;
    }

    @Override
    public Layout hideRightPanel() {
        section.rightSide.style.right = SLIDE_OUT;
        rightPanelVisible = false;
        hideOverlay();

        return this;
    }

    private void hideOverlay() {
        if (overlayVisible) {
            overlay.asElement().style.display = NONE;
            overlayVisible = false;
        }
    }

    private void showOverlay() {
        if (!overlayVisible) {
            overlay.asElement().style.display = BLOCK;
            overlayVisible = true;
        }
    }

    @Override
    public void toggleLeftPanel() {
        if (leftPanelVisible)
            hideLeftPanel();
        else
            showLeftPanel();
    }

    @Override
    public Layout showLeftPanel() {
        if (rightPanelVisible)
            hideRightPanel();
        if (navigationBarExpanded)
            collapseNavBar();
        section.leftSide.style.left = SLIDE_IN;
        leftPanelVisible = true;
        showOverlay();

        return this;
    }

    @Override
    public Layout hideLeftPanel() {
        if(!fixedLeftPanel) {
            section.leftSide.style.left = SLIDE_OUT;
            leftPanelVisible = false;
            hideOverlay();
        }

        return this;
    }

    @Override
    public HTMLElement getRightPanel() {
        return section.rightSide;
    }

    @Override
    public HTMLElement getLeftPanel() {
        return section.leftSide;
    }

    @Override
    public HTMLDivElement getContentPanel() {
        return content.contentContainer;
    }

    @Override
    public HTMLUListElement getTopBar() {
        return navigationBar.topBar;
    }

    @Override
    public Layout setTitle(String title) {
        if(navigationBar.title.hasChildNodes())
            navigationBar.title.removeChild(appTitle);
        this.appTitle=new Text(title);
        navigationBar.title.appendChild(appTitle);

        return this;
    }

    @Override
    public HTMLElement addActionItem(Icon icon){
        HTMLLIElement li = li().css("pull-right").add(
                a().css("js-right-sidebar")
                        .add(icon.asElement())).asElement();
        getTopBar().appendChild(li);
        return li;
    }

    public Layout fixLeftPanelPosition(){
        showLeftPanel();
        hideOverlay();
        if(document.body.classList.contains("ls-closed"))
            document.body.classList.remove("ls-closed");
        this.fixedLeftPanel=true;
        return this;
    }

    public Layout unfixLeftPanelPosition(){
        if(!document.body.classList.contains("ls-closed"))
            document.body.classList.add("ls-closed");
        this.fixedLeftPanel=false;
        return this;
    }
}
