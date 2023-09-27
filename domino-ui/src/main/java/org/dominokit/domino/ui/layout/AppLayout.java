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

import static org.dominokit.domino.ui.layout.NavBarStyles.dui_nav_utility;

import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.HashSet;
import java.util.Set;
import org.dominokit.domino.ui.animations.TransitionListeners;
import org.dominokit.domino.ui.elements.AsideElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeaderElement;
import org.dominokit.domino.ui.elements.SectionElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.style.ToggleCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * A component that provides feature rich main application layout that includes, Navigation bar,
 * left drawer, right drawer, footer and main content panel.
 */
public class AppLayout extends BaseDominoElement<HTMLDivElement, AppLayout>
    implements AppLayoutStyles {

  private final DivElement layout;
  private final SectionElement body;
  private final SectionElement content;
  private final LazyChild<NavBar> navBar;
  private final LazyChild<HeaderElement> header;
  private final LazyChild<SectionElement> footer;
  private final LazyChild<SectionElement> leftDrawer;
  private final LazyChild<AsideElement> leftDrawerContent;
  private final LazyChild<SectionElement> rightDrawer;
  private final LazyChild<SectionElement> rightDrawerContent;
  private final LazyChild<DivElement> overlay;
  private LazyChild<PrefixAddOn<HTMLElement>> leftDrawerToggle;
  private Icon<?> leftToggleIcon = Icons.menu();
  private LazyChild<PostfixAddOn<HTMLElement>> rightDrawerToggle;
  private Icon<?> rightToggleIcon = Icons.menu_open();

  private boolean autoCloseLeftDrawer = true;
  private boolean autoCloseRightDrawer = true;

  public SwapCssClass LEFT_DRAWER_SIZE = new SwapCssClass(dui_left_medium);
  public SwapCssClass RIGHT_DRAWER_SIZE = new SwapCssClass(dui_right_medium);

  public Set<ChildHandler<AppLayout, SectionElement>> leftDrawerOpenHandlers = new HashSet<>();
  public Set<ChildHandler<AppLayout, SectionElement>> leftDrawerCloseHandlers = new HashSet<>();
  public Set<ChildHandler<AppLayout, SectionElement>> rightDrawerOpenHandlers = new HashSet<>();
  public Set<ChildHandler<AppLayout, SectionElement>> rightDrawerCloseHandlers = new HashSet<>();

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public static AppLayout create() {
    return new AppLayout();
  }

  /**
   * create.
   *
   * @param title a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public static AppLayout create(String title) {
    return new AppLayout(title);
  }

  /** Constructor for AppLayout. */
  public AppLayout() {
    layout =
        div()
            .addCss(dui_layout)
            .appendChild(
                body =
                    section()
                        .addCss(dui_body)
                        .appendChild(content = section().addCss(dui_content)));
    header =
        LazyChild.of(header().addCss(dui_header), body)
            .whenInitialized(() -> layout.addCss(dui_has_header));
    navBar = LazyChild.of(NavBar.create(), header);
    footer =
        LazyChild.of(section().addCss(dui_footer), body)
            .whenInitialized(() -> layout.addCss(dui_has_footer));
    leftDrawerToggle = initLeftDrawerToggle(leftToggleIcon);
    leftDrawer =
        LazyChild.of(
                section().addCss(dui_left_drawer).addClickListener(Event::stopPropagation), layout)
            .whenInitialized(leftDrawerToggle::get);
    leftDrawer.whenInitialized(
        () -> {
          TransitionListeners.of(leftDrawer.element())
              .onTransitionStart(
                  target -> {
                    if (dui_left_open.isAppliedTo(layout)) {
                      leftDrawerOpenHandlers.forEach(
                          handler -> handler.apply(this, leftDrawer.get()));
                    }
                  })
              .onTransitionEnd(
                  target -> {
                    if (!dui_left_open.isAppliedTo(layout)) {
                      leftDrawerCloseHandlers.forEach(
                          handler -> handler.apply(this, leftDrawer.get()));
                    }
                  });
        });

    leftDrawerContent = LazyChild.of(aside().addCss(dui_layout_menu), leftDrawer);

    rightDrawerToggle = initRightDrawerToggle(rightToggleIcon);
    rightDrawer =
        LazyChild.of(
                section().addCss(dui_right_drawer).addClickListener(Event::stopPropagation), layout)
            .whenInitialized(rightDrawerToggle::get);

    rightDrawer.whenInitialized(
        () -> {
          TransitionListeners.of(rightDrawer.element())
              .onTransitionStart(
                  target -> {
                    if (dui_right_open.isAppliedTo(layout)) {
                      rightDrawerOpenHandlers.forEach(
                          handler -> handler.apply(this, rightDrawer.get()));
                    }
                  })
              .onTransitionEnd(
                  target -> {
                    if (!dui_right_open.isAppliedTo(layout)) {
                      rightDrawerCloseHandlers.forEach(
                          handler -> handler.apply(this, rightDrawer.get()));
                    }
                  });
        });
    rightDrawerContent = LazyChild.of(section().addCss(dui_layout_menu), rightDrawer);
    overlay = LazyChild.of(div().addCss(GenericCss.dui_overlay), layout);

    init(this);

    layout.onAttached(
        mutationRecord ->
            layout
                .parent()
                .addClickListener(
                    evt -> {
                      if (autoCloseLeftDrawer) {
                        dui_left_open.remove(layout);
                      }

                      if (autoCloseRightDrawer) {
                        dui_right_open.remove(layout);
                      }
                    }));

    DomGlobal.document.addEventListener(
        "dui-event-scroll-top",
        evt -> {
          body.element().scrollTop = 0;
        });
  }

  private LazyChild<PrefixAddOn<HTMLElement>> initLeftDrawerToggle(Icon<?> icon) {
    return LazyChild.of(PrefixAddOn.of(icon), navBar)
        .whenInitialized(
            () ->
                icon.clickable()
                    .addClickListener(
                        evt -> {
                          evt.stopPropagation();
                          toggleLeftDrawer();
                        })
                    .addCss(dui_order_first));
  }

  private LazyChild<PostfixAddOn<HTMLElement>> initRightDrawerToggle(Icon<?> icon) {
    return LazyChild.of(
            PostfixAddOn.of(icon).addCss(dui_order_last_4).addCss(dui_nav_utility), navBar)
        .whenInitialized(
            () ->
                icon.clickable()
                    .addClickListener(
                        evt -> {
                          evt.stopPropagation();
                          toggleRightDrawer();
                        }));
  }

  /**
   * Constructor for AppLayout.
   *
   * @param title a {@link java.lang.String} object
   */
  public AppLayout(String title) {
    this();
    navBar.get().setTitle(title);
  }

  /**
   * Getter for the field <code>layout</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.DivElement} object
   */
  public DivElement getLayout() {
    return layout;
  }

  /**
   * Getter for the field <code>body</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getBody() {
    return body;
  }

  /**
   * Getter for the field <code>content</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getContent() {
    return content;
  }

  /**
   * Getter for the field <code>navBar</code>.
   *
   * @return a {@link org.dominokit.domino.ui.layout.NavBar} object
   */
  public NavBar getNavBar() {
    return navBar.get();
  }

  /**
   * Getter for the field <code>header</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.HeaderElement} object
   */
  public HeaderElement getHeader() {
    return header.get();
  }

  /**
   * Getter for the field <code>footer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getFooter() {
    return footer.get();
  }

  /**
   * Getter for the field <code>leftDrawer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getLeftDrawer() {
    return leftDrawer.get();
  }

  /**
   * Getter for the field <code>leftDrawerContent</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.AsideElement} object
   */
  public AsideElement getLeftDrawerContent() {
    return leftDrawerContent.get();
  }

  /**
   * Getter for the field <code>rightDrawer</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getRightDrawer() {
    return rightDrawer.get();
  }

  /**
   * Getter for the field <code>rightDrawerContent</code>.
   *
   * @return a {@link org.dominokit.domino.ui.elements.SectionElement} object
   */
  public SectionElement getRightDrawerContent() {
    return rightDrawerContent.get();
  }

  /**
   * withLayout.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withLayout(ChildHandler<AppLayout, DivElement> handler) {
    handler.apply(this, layout);
    return this;
  }

  /**
   * withBody.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withBody(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * withContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withContent(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /**
   * withNavBar.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withNavBar(ChildHandler<AppLayout, NavBar> handler) {
    handler.apply(this, navBar.get());
    return this;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withHeader(ChildHandler<AppLayout, HeaderElement> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * withFooter.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withFooter(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * withLeftDrawer.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withLeftDrawer(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, leftDrawer.get());
    return this;
  }

  /**
   * withRightDrawer.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withRightDrawer(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, rightDrawer.get());
    return this;
  }

  /**
   * withLeftDrawerContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withLeftDrawerContent(ChildHandler<AppLayout, AsideElement> handler) {
    handler.apply(this, leftDrawerContent.get());
    return this;
  }

  /**
   * withRightDrawerContent.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withRightDrawerContent(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, rightDrawerContent.get());
    return this;
  }

  /**
   * withNavBar.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withNavBar() {
    navBar.get();
    return this;
  }

  /**
   * withHeader.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withHeader() {
    header.get();
    return this;
  }

  /**
   * withFooter.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withFooter() {
    footer.get();
    return this;
  }

  /**
   * withLeftDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withLeftDrawer() {
    leftDrawer.get();
    return this;
  }

  /**
   * withRightDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withRightDrawer() {
    rightDrawer.get();
    return this;
  }

  /**
   * withLeftDrawerContent.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withLeftDrawerContent() {
    leftDrawerContent.get();
    return this;
  }

  /**
   * withRightDrawerContent.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout withRightDrawerContent() {
    rightDrawerContent.get();
    return this;
  }

  /**
   * setLeftDrawerSize.
   *
   * @param size a {@link org.dominokit.domino.ui.layout.LeftDrawerSize} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setLeftDrawerSize(LeftDrawerSize size) {
    layout.addCss(LEFT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  /**
   * setRightDrawerSize.
   *
   * @param size a {@link org.dominokit.domino.ui.layout.RightDrawerSize} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setRightDrawerSize(RightDrawerSize size) {
    layout.addCss(RIGHT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  /**
   * toggleLeftDrawerSpanUp.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleLeftDrawerSpanUp() {
    layout.addCss(ToggleCssClass.of(dui_left_span_up));
    return this;
  }

  /**
   * setLeftDrawerSpanUp.
   *
   * @param spanUp a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setLeftDrawerSpanUp(boolean spanUp) {
    layout.addCss(BooleanCssClass.of(dui_left_span_up, spanUp));
    return this;
  }

  /**
   * toggleLeftDrawerSpanDown.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleLeftDrawerSpanDown() {
    layout.addCss(ToggleCssClass.of(dui_left_span_down));
    return this;
  }

  /**
   * setLeftDrawerSpanDown.
   *
   * @param spanDown a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setLeftDrawerSpanDown(boolean spanDown) {
    layout.addCss(BooleanCssClass.of(dui_left_span_down, spanDown));
    return this;
  }

  /**
   * toggleShrinkContent.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleShrinkContent() {
    layout.addCss(ToggleCssClass.of(dui_shrink_content));
    return this;
  }

  /**
   * setShrinkContent.
   *
   * @param shrink a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setShrinkContent(boolean shrink) {
    layout.addCss(BooleanCssClass.of(dui_shrink_content, shrink));
    return this;
  }

  /**
   * toggleLeftOverlay.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleLeftOverlay() {
    overlay.get();
    layout.addCss(ToggleCssClass.of(dui_left_overlay));
    return this;
  }

  /**
   * toggleRightOverlay.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleRightOverlay() {
    overlay.get();
    layout.addCss(ToggleCssClass.of(dui_right_overlay));
    return this;
  }

  /**
   * toggleLeftDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleLeftDrawer() {
    layout.addCss(ToggleCssClass.of(dui_left_open));
    return this;
  }

  /**
   * toggleRightDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleRightDrawer() {
    layout.addCss(ToggleCssClass.of(dui_right_open));
    return this;
  }

  /**
   * toggleFixedFooter.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout toggleFixedFooter() {
    layout.addCss(ToggleCssClass.of(dui_footer_fixed));
    return this;
  }

  /**
   * setFixedFooter.
   *
   * @param fixed a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setFixedFooter(boolean fixed) {
    layout.addCss(BooleanCssClass.of(dui_footer_fixed, fixed));
    return this;
  }

  /**
   * showLeftDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout showLeftDrawer() {
    layout.addCss(dui_left_open);
    return this;
  }

  /**
   * hideLeftDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout hideLeftDrawer() {
    dui_left_open.remove(layout);
    return this;
  }

  /**
   * showRightDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout showRightDrawer() {
    layout.addCss(dui_right_open);
    return this;
  }

  /**
   * hideRightDrawer.
   *
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout hideRightDrawer() {
    dui_right_open.remove(layout);
    return this;
  }

  /**
   * setLeftDrawerToggleIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setLeftDrawerToggleIcon(Icon<?> icon) {
    if (leftDrawerToggle.isInitialized()) {
      leftDrawerToggle.get().remove();
    }
    this.leftToggleIcon = icon;
    this.leftDrawerToggle = initLeftDrawerToggle(icon);
    leftDrawerToggle.get();
    return this;
  }

  /**
   * setRightDrawerToggleIcon.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setRightDrawerToggleIcon(Icon<?> icon) {
    if (rightDrawerToggle.isInitialized()) {
      rightDrawerToggle.get().remove();
    }
    this.rightToggleIcon = icon;
    this.rightDrawerToggle = initRightDrawerToggle(icon);
    rightDrawerToggle.get();
    return this;
  }

  /**
   * Setter for the field <code>autoCloseLeftDrawer</code>.
   *
   * @param autoCloseLeftDrawer a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setAutoCloseLeftDrawer(boolean autoCloseLeftDrawer) {
    this.autoCloseLeftDrawer = autoCloseLeftDrawer;
    return this;
  }

  /**
   * setFixLeftDrawer.
   *
   * @param fixed a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setFixLeftDrawer(boolean fixed) {
    if (fixed) {
      showLeftDrawer();
      setShrinkContent(true);
      setAutoCloseLeftDrawer(false);
    } else {
      setShrinkContent(false);
      setAutoCloseLeftDrawer(true);
    }
    return this;
  }

  /**
   * Setter for the field <code>autoCloseRightDrawer</code>.
   *
   * @param autoCloseRightDrawer a boolean
   * @return a {@link org.dominokit.domino.ui.layout.AppLayout} object
   */
  public AppLayout setAutoCloseRightDrawer(boolean autoCloseRightDrawer) {
    this.autoCloseRightDrawer = autoCloseRightDrawer;
    return this;
  }

  public AppLayout withLeftDrawerToggle(ChildHandler<AppLayout, PrefixAddOn<HTMLElement>> handler) {
    handler.apply(this, leftDrawerToggle.get());
    return this;
  }

  public AppLayout setLeftDrawerToggleVisible(boolean visible) {
    leftDrawerToggle.get().toggleDisplay(visible);
    return this;
  }

  /**
   * isLeftDrawerOpen.
   *
   * @return a boolean
   */
  public boolean isLeftDrawerOpen() {
    return dui_left_open.isAppliedTo(layout);
  }

  /**
   * isRightDrawerOpen.
   *
   * @return a boolean
   */
  public boolean isRightDrawerOpen() {
    return dui_right_open.isAppliedTo(layout);
  }

  public AppLayout onLeftDrawerOpen(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerOpenHandlers.add(handler);
    return this;
  }

  public AppLayout removeLeftDrawerOpenListener(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerOpenHandlers.remove(handler);
    return this;
  }

  public AppLayout onLeftDrawerClosed(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerCloseHandlers.add(handler);
    return this;
  }

  public AppLayout removeLeftDrawerCloseListener(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerCloseHandlers.remove(handler);
    return this;
  }

  public AppLayout onRightDrawerOpen(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerOpenHandlers.add(handler);
    return this;
  }

  public AppLayout removeRightDrawerOpenListener(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerOpenHandlers.remove(handler);
    return this;
  }

  public AppLayout onRightDrawerClosed(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerCloseHandlers.add(handler);
    return this;
  }

  public AppLayout removeRightDrawerCloseListener(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerCloseHandlers.remove(handler);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return layout.element();
  }
}
