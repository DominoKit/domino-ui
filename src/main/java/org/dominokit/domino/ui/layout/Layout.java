package org.dominokit.domino.ui.layout;

import elemental2.dom.*;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ElementUtil;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.gwt.elemento.core.IsElement;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.li;

public class Layout {

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
    private final Footer footer = Footer.create();

    private Text appTitle = TextNode.empty();

    private boolean leftPanelVisible = false;
    private boolean rightPanelVisible = false;
    private boolean navigationBarExpanded = false;
    private boolean overlayVisible = false;
    private boolean leftPanelDisabled = false;
    private boolean fixedLeftPanel;

    public Layout() {
    }

    public Layout(String title) {
        setTitle(title);
    }

    public static Layout create() {
        return new Layout();
    }

    public static Layout create(String title) {
        return new Layout(title);
    }

    public Layout show() {
        return show(ColorScheme.INDIGO);
    }

    public Layout show(ColorScheme theme) {
        appendElements();
        initElementsPosition();
        addExpandListeners();
        if (!bodyStyle().contains("ls-hidden"))
            bodyStyle().add("ls-closed");
        new Theme(theme).apply();
        MediaQuery.addOnSmallAndDownListener(() -> {
            unfixFooter();
        });
        return this;
    }

    private void appendElements() {
        document.body.appendChild(overlay.asElement());
        document.body.appendChild(navigationBar.asElement());
        document.body.appendChild(section.asElement());
        document.body.appendChild(content.asElement());
        document.body.appendChild(footer.asElement());
        navigationBar.title.appendChild(appTitle);
    }

    private void initElementsPosition() {
        getLeftPanel()
                .style()
                .setMarginLeft("0px")
                .setLeft(SLIDE_OUT);

        getRightPanel()
                .style()
                .setMarginRight("0px")
                .setRight(SLIDE_OUT);
    }

    private void addExpandListeners() {
        navigationBar.getMenu().addEventListener(CLICK, e -> toggleLeftPanel());
        navigationBar.getNavBarExpand().addEventListener(CLICK, e -> toggleNavigationBar());
        overlay.addEventListener(CLICK, e -> hidePanels());
    }

    public Layout removeLeftPanel() {
        return updateLeftPanel("none", "ls-closed", "ls-hidden");
    }

    public Layout addLeftPanel() {
        return updateLeftPanel("block", "ls-hidden", "ls-closed");
    }

    public Layout updateLeftPanel(String style, String hiddenStyle, String visibleStyle) {
        navigationBar.getMenu().style().setDisplay(style);
        getLeftPanel().style().setDisplay(style);
        bodyStyle().remove(hiddenStyle);
        bodyStyle().add(visibleStyle);

        return this;
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
        navigationBar.getNavigationBar().style().remove(COLLAPSE);
        navigationBarExpanded = true;
    }

    private void collapseNavBar() {
        navigationBar.getNavigationBar().style().add(COLLAPSE);
        navigationBarExpanded = false;
    }

    public void toggleRightPanel() {
        if (rightPanelVisible)
            hideRightPanel();
        else
            showRightPanel();
    }

    public Layout showRightPanel() {
        if (leftPanelVisible)
            hideLeftPanel();
        if (navigationBarExpanded)
            collapseNavBar();
        getRightPanel().style().setRight(SLIDE_IN);
        rightPanelVisible = true;
        showOverlay();

        return this;
    }

    public Layout hideRightPanel() {
        getRightPanel().style().setRight(SLIDE_OUT);
        rightPanelVisible = false;
        hideOverlay();

        return this;
    }

    private void hideOverlay() {
        if (overlayVisible) {
            overlay.style().setDisplay(NONE);
            overlayVisible = false;
        }
    }

    private void showOverlay() {
        if (!overlayVisible) {
            overlay.style().setDisplay(BLOCK);
            overlayVisible = true;
        }
    }

    public void toggleLeftPanel() {
        if (leftPanelVisible)
            hideLeftPanel();
        else
            showLeftPanel();
    }

    public Layout showLeftPanel() {
        if (!leftPanelDisabled) {
            if (rightPanelVisible)
                hideRightPanel();
            if (navigationBarExpanded)
                collapseNavBar();
            getLeftPanel().style().setLeft(SLIDE_IN);
            leftPanelVisible = true;
            showOverlay();
        }

        return this;
    }

    public Layout hideLeftPanel() {
        if (!fixedLeftPanel && !leftPanelDisabled) {
            getLeftPanel().style().setLeft(SLIDE_OUT);
            leftPanelVisible = false;
            hideOverlay();
        }

        return this;
    }

    public DominoElement<HTMLElement> getRightPanel() {
        return DominoElement.of(section.rightSide);
    }

    public DominoElement<HTMLElement> getLeftPanel() {
        return DominoElement.of(section.leftSide);
    }

    public DominoElement<HTMLDivElement> getContentPanel() {
        return DominoElement.of(content.contentContainer);
    }

    public DominoElement<HTMLUListElement> getTopBar() {
        return DominoElement.of(navigationBar.topBar);
    }

    public NavigationBar getNavigationBar() {
        return this.navigationBar;
    }

    public Content getContentSection() {
        return this.content;
    }

    public Footer getFooter() {
        return footer;
    }

    public Layout hideFooter() {
        footer.hide();
        return this;
    }

    public Layout showFooter() {
        footer.show();
        return this;
    }

    public Layout setTitle(String title) {
        if (navigationBar.getTitle().hasChildNodes())
            navigationBar.getTitle().removeChild(appTitle);
        this.appTitle = TextNode.of(title);
        navigationBar.getTitle().appendChild(appTitle);

        return this;
    }

    public HTMLElement addActionItem(Icon icon) {
        HTMLLIElement li = li().css("pull-right").add(
                a().css("js-right-sidebar")
                        .add(icon.asElement())).asElement();
        getTopBar().appendChild(li);
        return li;
    }

    public Layout fixLeftPanelPosition() {
        if (!leftPanelDisabled) {
            showLeftPanel();
            hideOverlay();
            if (bodyStyle().contains("ls-closed"))
                bodyStyle().remove("ls-closed");
            this.fixedLeftPanel = true;
        }
        return this;
    }

    public Layout unfixLeftPanelPosition() {
        if (!leftPanelDisabled) {
            if (!bodyStyle().contains("ls-closed"))
                bodyStyle().add("ls-closed");
            this.fixedLeftPanel = false;
        }
        return this;
    }

    private Style<HTMLBodyElement, IsElement<HTMLBodyElement>> bodyStyle() {
        return Style.of(document.body);
    }

    public Layout disableLeftPanel() {
        unfixLeftPanelPosition();
        hideLeftPanel();
        getLeftPanel().style().setDisplay("none");
        navigationBar.getMenu().style()
                .remove("bars")
                .setDisplay("none");
        this.leftPanelDisabled = true;
        return this;
    }

    public Layout enableLeftPanel() {
        getLeftPanel().style().removeProperty("display");
        navigationBar.getMenu().style()
                .add("bars")
                .removeProperty("display");
        this.leftPanelDisabled = false;
        return this;
    }

    public Layout fixFooter() {
        footer.style().add("fixed");
        if (footer.isAttached()) {
            updateContentBottomMargin();
        } else {
            ElementUtil.onAttach(footer.asElement(), mutationRecord -> updateContentBottomMargin());
        }
        return this;
    }

    private void updateContentBottomMargin() {
        Style.of(content.asElement()).setMarginBottom(footer.asElement().clientHeight + "px");
    }

    public Layout unfixFooter() {
        footer.style().remove("fixed");
        ElementUtil.onAttach(footer, mutationRecord -> {
            content.style().removeProperty("margin-bottom");
        });
        return this;
    }

    public Layout setHeaderHeight(String height) {
        navigationBar.style().setHeight(height);
        if (navigationBar.isAttached()) {
            updateContentMargin();
        } else {
            navigationBar.onAttached(mutationRecord -> {
                updateContentMargin();
            });
        }

        return this;
    }

    public Text getAppTitle() {
        return appTitle;
    }

    private void updateContentMargin() {
        double margin = navigationBar.getBoundingClientRect().height + 30;
        content.style().setMarginTop(margin + "px");
    }
}
