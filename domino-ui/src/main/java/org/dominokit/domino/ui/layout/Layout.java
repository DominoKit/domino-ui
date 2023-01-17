/*
 * Copyright © 2019 Dominokit
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.dominokit.domino.ui.layout;

import static elemental2.dom.DomGlobal.document;
import static java.util.Objects.nonNull;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.utils.*;
import org.jboss.elemento.IsElement;

/**
 * A component for building application layout -Shell- with predefined sections
 *
 * <ul>
 *   <li>Header Bar
 *   <li>Lwft panel
 *   <li>Content panel
 *   <li>Optional right panel
 *   <li>Optional footer
 * </ul>
 *
 * <pre>
 *     Layout.create("Application title").show(ColorScheme.INDIGO);
 * </pre>
 */
public class Layout extends BaseDominoElement<HTMLDivElement, Layout> {

  private static final String SLIDE_OUT_LEFT = "slide-out-left";
  private static final String SLIDE_OUT_RIGHT = "slide-out-right";
  private static final String NONE = "none";
  private static final String BLOCK = "block";
  private static final String COLLAPSE = "collapse";
  private static final String CLICK = "click";
  public static final String FIT_WIDTH = "fit-width";
  public static final String FIT_HEIGHT = "fit-height";

  private DominoElement<HTMLDivElement> root = DominoElement.of(div()).css("layout");

  private final NavigationBar navigationBar = NavigationBar.create();
  private final Section section = Section.create();
  private final Overlay overlay = Overlay.create();
  private final Content content = Content.create();
  private final Footer footer = Footer.create();

  private Text appTitle = TextNode.empty();

  private boolean leftPanelVisible = false;
  private boolean rightPanelVisible = false;
  private boolean overlayVisible = false;
  private boolean leftPanelDisabled = false;
  private boolean footerVisible = false;
  private boolean fixedLeftPanel;
  private boolean fixedFooter = false;
  private LeftPanelSize leftPanelSize = LeftPanelSize.DEFAULT;
  private LeftPanelOpenStyle leftPanelOpenStyle = LeftPanelOpenStyle.OVERLAY;
  private boolean smallScreen = false;

  private LayoutHandler onShowHandler = layout -> {};

  private LayoutHandler removeHandler = layout -> {};

  private List<Consumer<Boolean>> leftPanelHandlers = new ArrayList<>();

  /** Creates a Layout without a title */
  public Layout() {
    this(null);
  }

  /**
   * Creates a Layout with a title
   *
   * @param title String title
   */
  public Layout(String title) {
    init(this);
    if (nonNull(title)) {
      setTitle(title);
    }
    appendElements();
    initElementsPosition();
    addExpandListeners();
    if (!bodyStyle().containsCss("ls-hidden")) bodyStyle().addCss("ls-closed");
    new Theme(Theme.INDIGO).apply();

    DominoElement.of(document.body).addCss(leftPanelSize.getSize());

    MediaQuery.addOnSmallAndDownListener(
        () -> {
          if (footer.isAutoUnFixForSmallScreens() && footer.isFixed()) {
            fixedFooter = true;
            unfixFooter();
          }
          if (footer.isAutoUnFixForSmallScreens() && isFooterVisible()) {
            fixedFooter = true;
            unfixFooter();
          }
          this.smallScreen = true;
        });

    MediaQuery.addOnMediumAndUpListener(
        () -> {
          if (footer.isAutoUnFixForSmallScreens()
              && nonNull(fixedFooter)
              && fixedFooter
              && isFooterVisible()) {
            fixFooter();
          }
          this.smallScreen = false;
        });

    if (nonNull(onShowHandler)) {
      onShowHandler.handleLayout(this);
    }

    config()
        .getZindexManager()
        .addZIndexListener(
            (assignedValues, modalOpen, isDialog) -> {
              Optional<Integer> minZIndex = assignedValues.stream().min(Integer::compare);
              if (isDialog) {
                minZIndex.ifPresent(
                    minIndex -> {
                      Integer sidePanelsIndex =
                          minIndex - (config().getzIndexIncrement() * (modalOpen ? 3 : 2));
                      getRightPanel().setZIndex(sidePanelsIndex);
                      getNavigationBar()
                          .setZIndex(
                              minIndex - (config().getzIndexIncrement() * (modalOpen ? 2 : 1)));
                      if (DominoElement.body().containsCss("l-panel-span-up")) {
                        getLeftPanel().setZIndex(minIndex - config().getzIndexIncrement());
                      } else {
                        getLeftPanel().setZIndex(sidePanelsIndex);
                      }
                    });
              } else {

                Integer sidePanelsIndex = config().getZindexManager().getNextZIndex();
                getRightPanel().setZIndex(sidePanelsIndex);
                getNavigationBar().setZIndex(config().getZindexManager().getNextZIndex());
                if (DominoElement.body().containsCss("l-panel-span-up")) {
                  getLeftPanel().setZIndex(config().getZindexManager().getNextZIndex());
                } else {
                  getLeftPanel().setZIndex(sidePanelsIndex);
                }
              }
            });
  }

  /** @return new Layout instance without a title in the header */
  public static Layout create() {
    return new Layout();
  }

  /** @return new Layout instance with a title in the header */
  public static Layout create(String title) {
    return new Layout(title);
  }

  /**
   * Reveal the layout and append it to the page body
   *
   * @return same Layout instance
   */
  public Layout show() {
    return show(ColorScheme.INDIGO, false);
  }

  /**
   * Reveal the layout and append it to the page body
   *
   * @param autoFixLeftPanel boolean, if true left panel will be fixed and the user wont be able to
   *     hide it using the hamburger menu icon while we open the application on large device screen,
   *     while it will be collapsible when opened on small screens
   * @return same Layout instance
   */
  public Layout show(boolean autoFixLeftPanel) {
    return show(ColorScheme.INDIGO, autoFixLeftPanel);
  }

  /**
   * Reveal the layout and append it to the page body and apply the specified theme color
   *
   * @param theme {@link ColorScheme}
   * @return same Layout instance
   */
  public Layout show(ColorScheme theme) {
    return show(theme, false);
  }

  /**
   * Reveal the layout and append it to the page body and apply the specified theme color
   *
   * @param theme {@link ColorScheme}
   * @param autoFixLeftPanel boolean, if true left panel will be fixed and the user will not be able
   *     to hide it using the hamburger menu icon while we open the application on large device
   *     screen, while it will be collapsible when opened on small screens
   * @return same Layout instance
   */
  public Layout show(ColorScheme theme, boolean autoFixLeftPanel) {
    new Theme(theme).apply();

    if (autoFixLeftPanel) {
      autoFixLeftPanel();
    }
    if (!root.isAttached()) {
      document.body.appendChild(root.element());
    }

    return this;
  }

  private void appendElements() {
    root.appendChild(overlay.element());
    root.appendChild(navigationBar.element());
    root.appendChild(section.element());
    root.appendChild(content.element());
    root.appendChild(footer.element());
    navigationBar.title.appendChild(appTitle);

    navigationBar.css("nav-fixed");
    navigationBar.removeCss("ls-closed");
  }

  /**
   * removes the layout from the page body and call the provided handler
   *
   * @param removeHandler {@link LayoutHandler}
   */
  public void remove(LayoutHandler removeHandler) {
    this.removeHandler = removeHandler;
    remove();
  }

  /**
   * removes the layout from the page body
   *
   * @return the same Layout instance
   */
  public Layout remove() {
    root.remove();
    removeHandler.handleLayout(this);
    return this;
  }

  private void initElementsPosition() {
    getLeftPanel().addCss(SLIDE_OUT_LEFT);

    getRightPanel().addCss(SLIDE_OUT_RIGHT);
  }

  private void addExpandListeners() {
    navigationBar.menu.addEventListener(CLICK, e -> toggleLeftPanel());
    overlay.addEventListener(CLICK, e -> hidePanels());
  }

  /**
   * sets handler to be called when {@link #show()} is called
   *
   * @param layoutHandler {@link LayoutHandler}
   * @return sam Layout instance
   */
  public Layout onShow(LayoutHandler layoutHandler) {
    this.onShowHandler = layoutHandler;
    return this;
  }

  /**
   * Hides the left panel permanently
   *
   * @return same Layout instance
   */
  public Layout removeLeftPanel() {
    return updateLeftPanel("none", "ls-closed", "ls-hidden");
  }

  /**
   * un-hide the left panel
   *
   * @return same Layout instance
   */
  public Layout addLeftPanel() {
    return updateLeftPanel("block", "ls-hidden", "ls-closed");
  }

  private Layout updateLeftPanel(String style, String hiddenStyle, String visibleStyle) {
    navigationBar.menu.style().setDisplay(style);
    getLeftPanel().style().setDisplay(style);
    bodyStyle().removeCss(hiddenStyle);
    bodyStyle().addCss(visibleStyle);

    return this;
  }

  private void hidePanels() {
    hideRightPanel();
    hideLeftPanel();
    hideOverlay();
  }

  /**
   * toggle the state of the right panel, if it is closed it will open and if it is open it will be
   * closed
   */
  public Layout toggleRightPanel() {
    if (rightPanelVisible) {
      hideRightPanel();
    } else {
      showRightPanel();
    }
    return this;
  }

  /**
   * Opens the right panel, this will also hide the left panel if it is open
   *
   * @return same Layout instance
   */
  public Layout showRightPanel() {
    if (leftPanelVisible) {
      hideLeftPanel();
    }
    getRightPanel().removeCss(SLIDE_OUT_RIGHT);
    rightPanelVisible = true;
    showOverlay();

    return this;
  }

  /**
   * Close the left panel if it is open
   *
   * @return same Layout instance
   */
  public Layout hideRightPanel() {
    getRightPanel().addCss(SLIDE_OUT_RIGHT);
    rightPanelVisible = false;
    hideOverlay();

    return this;
  }

  private void hideOverlay() {
    if (overlayVisible) {
      overlay.style().setDisplay("none");
      overlayVisible = false;
    }
  }

  private void showOverlay() {
    if (!overlayVisible) {
      overlay.style().setDisplay("block");
      overlayVisible = true;
    }
  }

  /**
   * Toggle the state of the left panel, if it is open close it, if closed open it
   *
   * @return same Layout instance
   */
  public Layout toggleLeftPanel() {
    if (leftPanelVisible) hideLeftPanel();
    else showLeftPanel();

    return this;
  }

  /**
   * change the left panel size
   *
   * @param leftPanelSize {@link LeftPanelSize}
   * @return same Layout instance
   */
  public Layout setLeftPanelSize(LeftPanelSize leftPanelSize) {
    DominoElement.of(document.body).removeCss(this.leftPanelSize.getSize());
    this.leftPanelSize = leftPanelSize;
    DominoElement.of(document.body).addCss(this.leftPanelSize.getSize());
    return this;
  }

  public LeftPanelOpenStyle getLeftPanelOpenStyle() {
    return leftPanelOpenStyle;
  }

  /**
   * Change the behavior of the left open/close
   *
   * @param leftPanelOpenStyle {@link LeftPanelOpenStyle}
   */
  public Layout setLeftPanelOpenStyle(LeftPanelOpenStyle leftPanelOpenStyle) {
    this.leftPanelOpenStyle = leftPanelOpenStyle;
    return this;
  }

  private LeftPanelOpenStyle getEffectiveLeftPanelOpenStyle() {
    if (smallScreen) {
      return LeftPanelOpenStyle.OVERLAY;
    }
    return leftPanelOpenStyle;
  }

  /**
   * Opens the left panel
   *
   * @return same Layout instance
   */
  public Layout showLeftPanel() {
    if (!leftPanelDisabled) {
      if (rightPanelVisible) hideRightPanel();
      getLeftPanel().removeCss(SLIDE_OUT_LEFT);
      leftPanelVisible = true;
      getEffectiveLeftPanelOpenStyle().onOpen(this);
      DominoElement.of(document.body).addCss("panel-open");
      leftPanelHandlers.forEach(handler -> handler.accept(true));
    }

    return this;
  }

  /**
   * Close the left panel
   *
   * @return same Layout instance
   */
  public Layout hideLeftPanel() {
    if (!fixedLeftPanel && !leftPanelDisabled) {
      getLeftPanel().addCss(SLIDE_OUT_LEFT);
      leftPanelVisible = false;
      getEffectiveLeftPanelOpenStyle().onClose(this);
      DominoElement.of(document.body).removeCss("panel-open");
      leftPanelHandlers.forEach(handler -> handler.accept(false));
    }

    return this;
  }

  /** @return boolean, true if the footer is visible */
  public boolean isFooterVisible() {
    return footerVisible;
  }

  /** @return the right panel {@link HTMLElement} wrapped as a {@link DominoElement} */
  public DominoElement<HTMLElement> getRightPanel() {
    return DominoElement.of(section.rightSide);
  }

  /** @return the left panel {@link HTMLElement} wrapped as a {@link DominoElement} */
  public DominoElement<HTMLElement> getLeftPanel() {
    return DominoElement.of(section.leftSide);
  }

  /** @return the content panel {@link HTMLDivElement} wrapped as a {@link DominoElement} */
  public DominoElement<HTMLDivElement> getContentPanel() {
    return DominoElement.of(content.contentContainer);
  }

  /** @return the top bar panel {@link HTMLUListElement} wrapped as a {@link DominoElement} */
  public DominoElement<HTMLUListElement> getTopBar() {
    return DominoElement.of(navigationBar.topBar);
  }

  /** @return the {@link NavigationBar} */
  public NavigationBar getNavigationBar() {
    return this.navigationBar;
  }

  /** @return the main {@link Content} section */
  public Content getContentSection() {
    return this.content;
  }

  /** @return the {@link Footer} component */
  public Footer getFooter() {
    return footer;
  }

  /** @return same Layout instance */
  public Layout hideFooter() {
    footer.hide();
    return this;
  }

  /** @return same Layout instance */
  public Layout showFooter() {
    footer.show();
    this.footerVisible = true;
    return this;
  }

  /**
   * @param title String application title
   * @return same Layout instance
   */
  public Layout setTitle(String title) {
    if (navigationBar.title.hasChildNodes()) navigationBar.title.removeChild(appTitle);
    this.appTitle = TextNode.of(title);
    navigationBar.title.appendChild(appTitle);

    return this;
  }

  /**
   * Adds an action to the action bar at the right
   *
   * @param icon {@link BaseIcon} for the action
   * @return the {@link HTMLElement} of the created action
   */
  public HTMLElement addActionItem(BaseIcon<?> icon) {
    return addActionItem(icon.element());
  }

  /**
   * Adds an action to the action bar at the right
   *
   * @param element {@link IsElement} action HTMLElement content
   * @return the {@link HTMLElement} of the created action
   */
  public HTMLElement addActionItem(IsElement<?> element) {
    return addActionItem(element.element());
  }

  /**
   * Adds an action to the action bar at the right
   *
   * @param element {@link HTMLElement} action HTMLElement content
   * @return the {@link HTMLElement} of the created action
   */
  public HTMLElement addActionItem(HTMLElement element) {
    LayoutActionItem layoutActionItem = LayoutActionItem.create(element);
    getTopBar().appendChild(layoutActionItem);
    return layoutActionItem.element();
  }

  /**
   * Fix the left panel so it open and push the content panel and reduce its width instead of
   * showing on top of it
   *
   * @return same Layout instance
   */
  public Layout fixLeftPanelPosition() {
    if (!leftPanelDisabled) {
      showLeftPanel();
      hideOverlay();
      if (bodyStyle().containsCss("ls-closed")) bodyStyle().removeCss("ls-closed");
      this.fixedLeftPanel = true;
      DominoElement.body().addCss("l-fixed");
    }
    return this;
  }

  /**
   * The left panel will open on top the content panel with an overlay
   *
   * @return same Layout instance
   */
  public Layout unfixLeftPanelPosition() {
    if (!leftPanelDisabled) {
      if (!bodyStyle().containsCss("ls-closed")) bodyStyle().addCss("ls-closed");
      this.fixedLeftPanel = false;
      DominoElement.body().style().removeCss("l-fixed");
    }
    return this;
  }

  /**
   * the left panel will spread to the top of the browser page and push the header to the right
   * reducing its width
   *
   * @return same Layout instance
   */
  public Layout spanLeftPanelUp() {
    DominoElement.body().addCss("l-panel-span-up");
    return this;
  }

  private Style<HTMLBodyElement, IsElement<HTMLBodyElement>> bodyStyle() {
    return Style.of(document.body);
  }

  /**
   * Hides the left panel and hide the icon that toggle its open/close state
   *
   * @return same Layout instance
   */
  public Layout disableLeftPanel() {
    unfixLeftPanelPosition();
    hideLeftPanel();
    getLeftPanel().style().setDisplay("none");
    navigationBar.menu.removeCss("bars").setDisplay("none");
    this.leftPanelDisabled = true;
    return this;
  }

  /**
   * if disable this will show the left panel and show its toggle icon
   *
   * @return same Layout instance
   */
  public Layout enableLeftPanel() {
    getLeftPanel().removeCssProperty("display");
    navigationBar.menu.addCss("bars").removeCssProperty("display");
    this.leftPanelDisabled = false;
    return this;
  }

  /**
   * @return same Layout instance
   * @see {@link Footer#fixed()}
   */
  public Layout fixFooter() {
    footer.fixed();
    if (footer.isAttached()) {
      updateContentBottomPadding();
    } else {
      footer.onAttached(mutationRecord -> updateContentBottomPadding());
    }

    return this;
  }

  private void updateContentBottomPadding() {
    Style.of(content.element()).setPaddingBottom(footer.element().clientHeight + "px");
  }

  /**
   * @return same Layout instance
   * @see {@link Footer#unfixed()}
   */
  public Layout unfixFooter() {
    footer.unfixed();
    footer.onAttached(
        mutationRecord -> Style.of(content.element()).removeCssProperty("padding-bottom"));
    return this;
  }

  /**
   * @param height String css height for the header
   * @return same Layout instance
   */
  public Layout setHeaderHeight(String height) {
    navigationBar.style().setHeight(height);
    if (navigationBar.isAttached()) {
      updateContentMargin();
    } else {
      navigationBar.onAttached(
          mutationRecord -> {
            updateContentMargin();
          });
    }

    return this;
  }

  /** @return Text node of the application title */
  public Text getAppTitle() {
    return appTitle;
  }

  /**
   * clears the content panel and appends the provided Node to it
   *
   * @param node {@link Node} the new content
   * @return same Layout instance
   */
  public Layout setContent(Node node) {
    getContentPanel().clearElement().appendChild(node);
    ElementUtil.scrollTop();
    return this;
  }

  /**
   * clears the content panel and appends the provided element to it
   *
   * @param element {@link IsElement} the new content
   * @return same Layout instance
   */
  public Layout setContent(IsElement<?> element) {
    setContent(element.element());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout content(Consumer<DominoElement<HTMLDivElement>> contentConsumer) {
    contentConsumer.accept(getContentPanel());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout leftPanel(Consumer<DominoElement<HTMLElement>> leftPanelConsumer) {
    leftPanelConsumer.accept(getLeftPanel());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout rightPanel(Consumer<DominoElement<HTMLElement>> rightPanelConsumer) {
    rightPanelConsumer.accept(getRightPanel());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout footer(Consumer<Footer> footerConsumer) {
    footerConsumer.accept(getFooter());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout navigationBar(Consumer<NavigationBar> navigationBarConsumer) {
    navigationBarConsumer.accept(getNavigationBar());
    return this;
  }

  /** @deprecated not needed, use {@link #apply(ElementHandler)} */
  @Deprecated
  public Layout topBar(Consumer<DominoElement<HTMLUListElement>> topBarConsumer) {
    topBarConsumer.accept(getTopBar());
    return this;
  }

  /**
   * @param imageElement {@link HTMLImageElement} logo to show on the left side
   * @return same Layout instance
   */
  public Layout setLogo(HTMLImageElement imageElement) {
    navigationBar.getLogoItem().clearElement().appendChild(imageElement).css("logo-in");
    return this;
  }

  /**
   * @param imageElement {@link HTMLImageElement} wrapped as {@link IsElement} logo to show on the
   *     left side
   * @return same Layout instance
   */
  public Layout setLogo(IsElement<HTMLImageElement> imageElement) {
    return setLogo(imageElement.element());
  }

  /**
   * fix the left panel so the user wont be able to hide it using the hamburger menu icon while we
   * open the application on large device screen, while it will be collapsible when opened on small
   * screens
   *
   * @return same Layout instance
   */
  public Layout autoFixLeftPanel() {
    MediaQuery.addOnMediumAndUpListener(
        () -> {
          if (Layout.this.getLeftPanel().isAttached()) {
            Layout.this.fixLeftPanelPosition();
          } else {
            Layout.this
                .getLeftPanel()
                .onAttached(mutationRecord -> Layout.this.fixLeftPanelPosition());
          }
        });
    MediaQuery.addOnSmallAndDownListener(
        () -> {
          if (getLeftPanel().isAttached()) {
            this.unfixLeftPanelPosition();
            this.hideLeftPanel();
          } else {
            this.unfixLeftPanelPosition();
            this.hideLeftPanel();
          }
        });

    return this;
  }

  /**
   * Hide the menu toggle icon from the navigation bar
   *
   * @return same Layout instance
   */
  public Layout hideNavBarExpand() {
    navigationBar.getMenuToggleItem().hide();
    return this;
  }

  /**
   * Hide the menu toggle icon from the navigation bar on small screens only
   *
   * @return same Layout instance
   */
  public Layout hideNavBarExpandOnSmallDown() {
    return hideNavBarExpandOn(ScreenMedia.SMALL_AND_DOWN);
  }

  /**
   * Hide the menu toggle icon from the navigation bar on provided screens only
   *
   * @param screenMedia {@link ScreenMedia} for which we should the menu toggle
   * @return same Layout instance
   */
  public Layout hideNavBarExpandOn(ScreenMedia screenMedia) {
    navigationBar.getMenuToggleItem().hideOn(screenMedia);
    return this;
  }

  /**
   * Sets a handler to be called when the left open/closed state is changed
   *
   * @param leftPanelHandler Consumer of Boolean, true for open, false for closed
   * @return same Layout instance
   */
  public Layout onLeftPanelStateChanged(Consumer<Boolean> leftPanelHandler) {
    leftPanelHandlers.add(leftPanelHandler);
    return this;
  }

  /**
   * remove the handler that was set with {@link #onLeftPanelStateChanged(Consumer)}
   *
   * @param leftPanelHandler the handler
   * @return same Layout instance
   */
  public Layout removeLeftPanelHandler(Consumer<Boolean> leftPanelHandler) {
    leftPanelHandlers.remove(leftPanelHandler);
    return this;
  }

  /**
   * expands the content panel width to fit the screen without gaps and margins
   *
   * @return same Layout instance
   */
  public Layout fitWidth() {
    content.addCss(FIT_WIDTH);
    getContentPanel().addCss(FIT_WIDTH);
    return this;
  }

  /**
   * restore the gaps and margins removed by {@link #fitWidth()}
   *
   * @return same Layout instance
   */
  public Layout unfitWidth() {
    content.removeCss(FIT_WIDTH);
    getContentPanel().removeCss(FIT_WIDTH);
    return this;
  }

  /**
   * expands the content panel height to fit the screen without gaps and margins
   *
   * @return same Layout instance
   */
  public Layout fitHeight() {
    content.addCss(FIT_HEIGHT);
    getFooter().addCss(FIT_HEIGHT);
    return this;
  }

  /**
   * restore the gaps and margins removed by {@link #fitHeight()}
   *
   * @return same Layout instance
   */
  public Layout unfitHeight() {
    content.removeCss(FIT_HEIGHT);
    getFooter().removeCss(FIT_HEIGHT);
    return this;
  }

  private void updateContentMargin() {
    double margin = navigationBar.getBoundingClientRect().height + 30;
    content.setMarginTop(margin + "px");
  }

  /** @return boolean, true if the left panel is visible and open */
  public boolean isLeftPanelVisible() {
    return leftPanelVisible;
  }

  /** @return boolean, true if the right panel is visible and open */
  public boolean isRightPanelVisible() {
    return rightPanelVisible;
  }

  /** @deprecated not used */
  @Deprecated
  public boolean isNavigationBarExpanded() {
    return false;
  }

  /** @return boolean, true if the overlay covering the content is visible */
  public boolean isOverlayVisible() {
    return overlayVisible;
  }

  /** @return boolean, true if left panel is disabled */
  public boolean isLeftPanelDisabled() {
    return leftPanelDisabled;
  }

  /** @return boolean, true if left panel is fixed */
  public boolean isFixedLeftPanel() {
    return fixedLeftPanel;
  }

  /** @return the {@link LeftPanelSize} */
  public LeftPanelSize getLeftPanelSize() {
    return leftPanelSize;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** An enum to list left panel sizes that controls the panel width */
  public enum LeftPanelSize {
    /** Small size */
    SMALL("sm"),
    /** Default/Medium size */
    DEFAULT("md"),
    /** Large size */
    LARGE("lg");

    private String size;

    LeftPanelSize(String size) {
      this.size = size;
    }

    /** @return String css class name for the panel size */
    public String getSize() {
      return size;
    }
  }

  /** An enum to list left panel open behaviors */
  public enum LeftPanelOpenStyle {
    /** Opens the left panel on top of content panel and show an overlay */
    OVERLAY(
        layout -> {
          layout.showOverlay();
        },
        layout -> {
          layout.hideOverlay();
        }),
    /** Opens the left panel and shrinks the content panel */
    SHRINK_CONTENT(
        layout -> {
          DominoElement.of(document.body).addCss("l-shrink");
          DominoElement.of(document.body).removeCss("ls-closed");
        },
        layout -> {
          DominoElement.of(document.body).removeCss("l-shrink");
          DominoElement.of(document.body).addCss("ls-closed");
        });

    private final LayoutHandler openHandler;
    private final LayoutHandler closeHandler;

    LeftPanelOpenStyle(LayoutHandler openHandler, LayoutHandler closeHandler) {
      this.openHandler = openHandler;
      this.closeHandler = closeHandler;
    }

    public void onOpen(Layout layout) {
      this.openHandler.handleLayout(layout);
    }

    public void onClose(Layout layout) {
      closeHandler.handleLayout(layout);
    }
  }

  /**
   * a function to implement logic for interacting with the layout during different phases of its
   * attach cycle
   */
  @FunctionalInterface
  public interface LayoutHandler {
    /** @param layout {@link Layout} */
    void handleLayout(Layout layout);
  }
}
