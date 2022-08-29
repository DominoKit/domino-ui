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

import static org.dominokit.domino.ui.layout.AppLayoutStyles.*;
import static org.dominokit.domino.ui.style.Styles.ORDER_FIRST;
import static org.dominokit.domino.ui.style.Styles.ORDER_LAST;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.LazyChild;

public class AppLayout extends BaseDominoElement<HTMLDivElement, AppLayout> {

  private final DominoElement<HTMLDivElement> layout;
  private final DominoElement<HTMLElement> body;
  private final DominoElement<HTMLElement> content;
  private final LazyChild<NavBar> navBar;
  private final LazyChild<DominoElement<HTMLElement>> header;
  private final LazyChild<DominoElement<HTMLElement>> footer;
  private final LazyChild<DominoElement<HTMLElement>> leftDrawer;
  private final LazyChild<DominoElement<HTMLElement>> leftDrawerContent;
  private final LazyChild<DominoElement<HTMLElement>> rightDrawer;
  private final LazyChild<DominoElement<HTMLElement>> rightDrawerContent;
  private final LazyChild<DominoElement<HTMLDivElement>> overlay;
  private LazyChild<NavBarAddOn> leftDrawerToggle;
  private BaseIcon<?> leftToggleIcon = Icons.ALL.menu_mdi();
  private LazyChild<NavBarUtility> rightDrawerToggle;
  private BaseIcon<?> rightToggleIcon = Icons.ALL.menu_open_mdi();

  private boolean autoCloseLeftDrawer = true;
  private boolean autoCloseRightDrawer = true;

  public SwapCssClass LEFT_DRAWER_SIZE = new SwapCssClass(LEFT_MEDIUM);
  public SwapCssClass RIGHT_DRAWER_SIZE = new SwapCssClass(RIGHT_MEDIUM);

  public static AppLayout create() {
    return new AppLayout();
  }

  public static AppLayout create(String title) {
    return new AppLayout(title);
  }

  public AppLayout() {
    layout =
        DominoElement.div()
            .addCss(LAYOUT)
            .appendChild(
                body =
                    DominoElement.section()
                        .addCss(BODY)
                        .appendChild(content = DominoElement.section().addCss(CONTENT)));
    header =
        LazyChild.of(DominoElement.header().addCss(HEADER), body)
            .whenInitialized(() -> layout.addCss(HAS_HEADER));
    navBar = LazyChild.of(NavBar.create(), header);
    footer =
        LazyChild.of(DominoElement.section().addCss(FOOTER), body)
            .whenInitialized(() -> layout.addCss(HAS_FOOTER));
    leftDrawerToggle = initLeftDrawerToggle(leftToggleIcon);
    leftDrawer =
        LazyChild.of(DominoElement.section().addCss(LEFT_DRAWER), layout)
            .whenInitialized(leftDrawerToggle::get);
    leftDrawerContent = LazyChild.of(DominoElement.aside().addCss(LAYOUT_MENU), leftDrawer);

    rightDrawerToggle = initRightDrawerToggle(rightToggleIcon);
    rightDrawer =
        LazyChild.of(DominoElement.section().addCss(RIGHT_DRAWER), layout)
            .whenInitialized(rightDrawerToggle::get);
    rightDrawerContent = LazyChild.of(DominoElement.section().addCss(LAYOUT_MENU), rightDrawer);
    overlay = LazyChild.of(DominoElement.div().addCss(Styles.OVERLAY), layout);

    init(this);

    layout.onAttached(
        mutationRecord ->
            layout
                .parent()
                .addClickListener(
                    evt -> {
                      if (autoCloseLeftDrawer) {
                        LEFT_OPEN.remove(layout);
                      }

                      if (autoCloseRightDrawer) {
                        RIGHT_DRAWER.remove(layout);
                      }
                    }));
  }

  private LazyChild<NavBarAddOn> initLeftDrawerToggle(BaseIcon<?> icon) {
    return LazyChild.of(NavBarAddOn.of(icon), navBar)
        .whenInitialized(
            () ->
                icon.clickable()
                    .addClickListener(
                        evt -> {
                          evt.stopPropagation();
                          toggleLeftDrawer();
                        })
                    .addCss(ORDER_FIRST));
  }

  private LazyChild<NavBarUtility> initRightDrawerToggle(BaseIcon<?> icon) {
    return LazyChild.of(NavBarUtility.of(icon), navBar)
        .whenInitialized(
            () ->
                icon.clickable()
                    .addClickListener(
                        evt -> {
                          evt.stopPropagation();
                          toggleRightDrawer();
                        })
                    .addCss(ORDER_LAST));
  }

  public AppLayout(String title) {
    this();
    navBar.get().setTitle(title);
  }

  public DominoElement<HTMLDivElement> getLayout() {
    return layout;
  }

  public DominoElement<HTMLElement> getBody() {
    return body;
  }

  public DominoElement<HTMLElement> getContent() {
    return content;
  }

  public NavBar getNavBar() {
    return navBar.get();
  }

  public DominoElement<HTMLElement> getHeader() {
    return header.get();
  }

  public DominoElement<HTMLElement> getFooter() {
    return footer.get();
  }

  public DominoElement<HTMLElement> getLeftDrawer() {
    return leftDrawer.get();
  }

  public DominoElement<HTMLElement> getLeftDrawerContent() {
    return leftDrawerContent.get();
  }

  public DominoElement<HTMLElement> getRightDrawer() {
    return rightDrawer.get();
  }

  public DominoElement<HTMLElement> getRightDrawerContent() {
    return rightDrawerContent.get();
  }

  public AppLayout withLayout(ChildHandler<AppLayout, DominoElement<HTMLDivElement>> handler) {
    handler.apply(this, layout);
    return this;
  }

  public AppLayout withBody(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, body);
    return this;
  }

  public AppLayout withContent(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, content);
    return this;
  }

  public AppLayout withNavBar(ChildHandler<AppLayout, NavBar> handler) {
    handler.apply(this, navBar.get());
    return this;
  }

  public AppLayout withHeader(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, header.get());
    return this;
  }

  public AppLayout withFooter(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  public AppLayout withLeftDrawer(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, leftDrawer.get());
    return this;
  }

  public AppLayout withRightDrawer(ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, rightDrawer.get());
    return this;
  }

  public AppLayout withLeftDrawerContent(
      ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, leftDrawerContent.get());
    return this;
  }

  public AppLayout withRightDrawerContent(
      ChildHandler<AppLayout, DominoElement<HTMLElement>> handler) {
    handler.apply(this, rightDrawerContent.get());
    return this;
  }

  public AppLayout withNavBar() {
    navBar.get();
    return this;
  }

  public AppLayout withHeader() {
    header.get();
    return this;
  }

  public AppLayout withFooter() {
    footer.get();
    return this;
  }

  public AppLayout withLeftDrawer() {
    leftDrawer.get();
    return this;
  }

  public AppLayout withRightDrawer() {
    rightDrawer.get();
    return this;
  }

  public AppLayout withLeftDrawerContent() {
    leftDrawerContent.get();
    return this;
  }

  public AppLayout withRightDrawerContent() {
    rightDrawerContent.get();
    return this;
  }

  public AppLayout setLeftDrawerSize(LeftDrawerSize size) {
    layout.addCss(LEFT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  public AppLayout setRightDrawerSize(RightDrawerSize size) {
    layout.addCss(RIGHT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  public AppLayout toggleLeftDrawerSpanUp() {
    layout.addCss(LEFT_SPAN_UP);
    return this;
  }

  public AppLayout toggleLeftDrawerSpanDown() {
    layout.addCss(LEFT_SPAN_DOWN);
    return this;
  }

  public AppLayout toggleShrinkContent() {
    layout.addCss(SHRINK_CONENT);
    return this;
  }

  public AppLayout toggleLeftOverlay() {
    overlay.get();
    layout.addCss(LEFT_OVERLAY);
    return this;
  }

  public AppLayout toggleRightOverlay() {
    overlay.get();
    layout.addCss(RIGHT_OVERLAY);
    return this;
  }

  public AppLayout toggleLeftDrawer() {
    layout.addCss(LEFT_OPEN);
    return this;
  }

  public AppLayout toggleRightDrawer() {
    layout.addCss(RIGHT_OPEN);
    return this;
  }

  public AppLayout toggleFixedFooter() {
    layout.addCss(FOOTER_FIXED);
    return this;
  }

  public AppLayout showLeftDrawer() {
    layout.addCss(LEFT_OPEN);
    return this;
  }

  public AppLayout hideLeftDrawer() {
    layout.removeCss(LEFT_OPEN);
    return this;
  }

  public AppLayout showRightDrawer() {
    layout.addCss(RIGHT_OPEN);
    return this;
  }

  public AppLayout hideRightDrawer() {
    layout.removeCss(RIGHT_OPEN);
    return this;
  }

  public AppLayout setLeftDrawerToggleIcon(BaseIcon<?> icon) {
    if (leftDrawerToggle.isInitialized()) {
      leftDrawerToggle.get().remove();
    }
    this.leftToggleIcon = icon;
    this.leftDrawerToggle = initLeftDrawerToggle(icon);
    leftDrawerToggle.get();
    return this;
  }

  public AppLayout setRightDrawerToggleIcon(BaseIcon<?> icon) {
    if (rightDrawerToggle.isInitialized()) {
      rightDrawerToggle.get().remove();
    }
    this.rightToggleIcon = icon;
    this.rightDrawerToggle = initRightDrawerToggle(icon);
    rightDrawerToggle.get();
    return this;
  }

  public AppLayout setAutoCloseLeftDrawer(boolean autoCloseLeftDrawer) {
    this.autoCloseLeftDrawer = autoCloseLeftDrawer;
    return this;
  }

  public AppLayout setAutoCloseRightDrawer(boolean autoCloseRightDrawer) {
    this.autoCloseRightDrawer = autoCloseRightDrawer;
    return this;
  }

  public boolean isLeftDrawerOpen() {
    return LEFT_OPEN.isAppliedTo(layout);
  }

  public boolean isRightDrawerOpen() {
    return RIGHT_OPEN.isAppliedTo(layout);
  }

  @Override
  public HTMLDivElement element() {
    return layout.element();
  }
}
