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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
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
 * The <b>AppLayout</b> class represents the main layout structure for a web application. It
 * provides options for creating a responsive layout with a navigation bar, content area, and
 * drawers.
 *
 * @see NavBar
 * @see BaseDominoElement
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
   * Creates a new instance of <b>AppLayout</b> with default settings.
   *
   * @return A new <b>AppLayout</b> instance.
   */
  public static AppLayout create() {
    return new AppLayout();
  }

  /**
   * Creates a new instance of <b>AppLayout</b> with a specified title.
   *
   * @param title The title to be displayed in the navigation bar.
   * @return A new <b>AppLayout</b> instance.
   */
  public static AppLayout create(String title) {
    return new AppLayout(title);
  }

  /** Constructs an <b>AppLayout</b> with default settings. */
  public AppLayout() {
    layout =
        div()
            .addCss(dui_layout)
            .appendChild(
                body =
                    section()
                        .addCss(dui_body)
                        .appendChild(
                            content =
                                section()
                                    .addCss(dui_content)
                                    .setZIndexLayer(ZIndexLayer.Z_LAYER_1)));
    header =
        LazyChild.of(
                header()
                    .addCss(dui_header)
                    .setAttribute("dui-reserve-top-space", "true")
                    .setZIndexLayer(ZIndexLayer.Z_LAYER_2),
                body)
            .whenInitialized(() -> layout.addCss(dui_has_header));
    navBar = LazyChild.of(NavBar.create(), header);
    footer =
        LazyChild.of(
                section()
                    .setAttribute("dui-reserve-bottom-space", "true")
                    .addCss(dui_footer)
                    .setZIndexLayer(ZIndexLayer.Z_LAYER_2),
                body)
            .whenInitialized(() -> layout.addCss(dui_has_footer));
    leftDrawerToggle = initLeftDrawerToggle(leftToggleIcon);
    leftDrawer =
        LazyChild.of(
                section()
                    .setAttribute("dui-reserve-left-space", "true")
                    .addCss(dui_left_drawer)
                    .setZIndexLayer(ZIndexLayer.Z_LAYER_2)
                    .addClickListener(Event::stopPropagation),
                layout)
            .whenInitialized(leftDrawerToggle::get);
    leftDrawer.whenInitialized(
        () -> {
          TransitionListeners.of(leftDrawer.element())
              .onTransitionStart(
                  target -> {
                    if (dui_left_open.isAppliedTo(layout)) {
                      leftDrawerOpenHandlers.forEach(
                          handler -> handler.apply(this, leftDrawer.get()));
                      leftDrawer
                          .get()
                          .setAttribute(
                              "dui-reserve-left-space", dui_left_open.isAppliedTo(layout));
                    }
                  })
              .onTransitionEnd(
                  target -> {
                    if (!dui_left_open.isAppliedTo(layout)) {
                      leftDrawerCloseHandlers.forEach(
                          handler -> handler.apply(this, leftDrawer.get()));
                      leftDrawer
                          .get()
                          .setAttribute(
                              "dui-reserve-left-space", dui_left_open.isAppliedTo(layout));
                    }
                  });
        });

    leftDrawerContent = LazyChild.of(aside().addCss(dui_layout_menu), leftDrawer);

    rightDrawerToggle = initRightDrawerToggle(rightToggleIcon);
    rightDrawer =
        LazyChild.of(
                section()
                    .setAttribute("dui-reserve-left-space", "false")
                    .addCss(dui_right_drawer)
                    .setZIndexLayer(ZIndexLayer.Z_LAYER_2)
                    .addClickListener(Event::stopPropagation),
                layout)
            .whenInitialized(rightDrawerToggle::get);

    rightDrawer.whenInitialized(
        () -> {
          TransitionListeners.of(rightDrawer.element())
              .onTransitionStart(
                  target -> {
                    if (dui_right_open.isAppliedTo(layout)) {
                      rightDrawerOpenHandlers.forEach(
                          handler -> handler.apply(this, rightDrawer.get()));
                      rightDrawer
                          .get()
                          .setAttribute(
                              "dui-reserve-right-space", dui_right_open.isAppliedTo(layout));
                    }
                  })
              .onTransitionEnd(
                  target -> {
                    if (!dui_right_open.isAppliedTo(layout)) {
                      rightDrawerCloseHandlers.forEach(
                          handler -> handler.apply(this, rightDrawer.get()));
                      rightDrawer
                          .get()
                          .setAttribute(
                              "dui-reserve-right-space", dui_right_open.isAppliedTo(layout));
                    }
                  });
        });
    rightDrawerContent = LazyChild.of(section().addCss(dui_layout_menu), rightDrawer);
    overlay = LazyChild.of(div().addCss(GenericCss.dui_overlay), layout);

    init(this);

    DomGlobal.setTimeout(
        p0 -> {
          layout.onAttached(
              (e, mutationRecord) ->
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
        },
        0);

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
   * Creates a new instance of <b>AppLayout</b> with a specified title.
   *
   * @param title The title to be displayed in the navigation bar.
   * @return A new <b>AppLayout</b> instance.
   */
  public AppLayout(String title) {
    this();
    navBar.get().setTitle(title);
  }

  /**
   * Retrieves the layout element of this <b>AppLayout<b>.
   *
   * @return The layout element as a <b>DivElement<b>.
   */
  public DivElement getLayout() {
    return layout;
  }

  /**
   * Retrieves the body section element of this <b>AppLayout<b>.
   *
   * @return The body section element as a <b>SectionElement<b>.
   */
  public SectionElement getBody() {
    return body;
  }

  /**
   * Retrieves the content section element of this <b>AppLayout<b>.
   *
   * @return The content section element as a <b>SectionElement<b>.
   */
  public SectionElement getContent() {
    return content;
  }

  /**
   * Retrieves the navigation bar associated with this <b>AppLayout<b>.
   *
   * @return The navigation bar as a <b>NavBar</b> instance.
   */
  public NavBar getNavBar() {
    return navBar.get();
  }

  /**
   * Retrieves the header element of this <b>AppLayout<b>.
   *
   * @return The header element as a <b>HeaderElement<b>.
   */
  public HeaderElement getHeader() {
    return header.get();
  }

  /**
   * Retrieves the footer section element of this <b>AppLayout<b>.
   *
   * @return The footer section element as a <b>SectionElement<b>.
   */
  public SectionElement getFooter() {
    return footer.get();
  }

  /**
   * Retrieves the left drawer section element of this <b>AppLayout<b>.
   *
   * @return The left drawer section element as a <b>SectionElement<b>.
   */
  public SectionElement getLeftDrawer() {
    return leftDrawer.get();
  }

  /**
   * Retrieves the content of the left drawer as an <b>AsideElement<b>.
   *
   * @return The left drawer content as an <b>AsideElement<b>.
   */
  public AsideElement getLeftDrawerContent() {
    return leftDrawerContent.get();
  }

  /**
   * Retrieves the right drawer section element of this <b>AppLayout<b>.
   *
   * @return The right drawer section element as a <b>SectionElement<b>.
   */
  public SectionElement getRightDrawer() {
    return rightDrawer.get();
  }

  /**
   * Retrieves the content of the right drawer as a <b>SectionElement<b>.
   *
   * @return The right drawer content as a <b>SectionElement<b>.
   */
  public SectionElement getRightDrawerContent() {
    return rightDrawerContent.get();
  }

  /**
   * Configures the layout element using a custom handler.
   *
   * @param handler The handler for configuring the layout.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLayout(ChildHandler<AppLayout, DivElement> handler) {
    handler.apply(this, layout);
    return this;
  }

  /**
   * Configures the body section element using a custom handler.
   *
   * @param handler The handler for configuring the body section.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withBody(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, body);
    return this;
  }

  /**
   * Configures the content section element using a custom handler.
   *
   * @param handler The handler for configuring the content section.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withContent(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, content);
    return this;
  }

  /**
   * Configures the navigation bar using a custom handler.
   *
   * @param handler The handler for configuring the navigation bar.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withNavBar(ChildHandler<AppLayout, NavBar> handler) {
    handler.apply(this, navBar.get());
    return this;
  }

  /**
   * Configures the header element using a custom handler.
   *
   * @param handler The handler for configuring the header element.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withHeader(ChildHandler<AppLayout, HeaderElement> handler) {
    handler.apply(this, header.get());
    return this;
  }

  /**
   * Configures the footer section element using a custom handler.
   *
   * @param handler The handler for configuring the footer section.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withFooter(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, footer.get());
    return this;
  }

  /**
   * Configures the left drawer section element using a custom handler.
   *
   * @param handler The handler for configuring the left drawer section.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLeftDrawer(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, leftDrawer.get());
    return this;
  }

  /**
   * Configures the right drawer section element using a custom handler.
   *
   * @param handler The handler for configuring the right drawer section.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withRightDrawer(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, rightDrawer.get());
    return this;
  }

  /**
   * Configures the content of the left drawer using a custom handler.
   *
   * @param handler The handler for configuring the left drawer content.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLeftDrawerContent(ChildHandler<AppLayout, AsideElement> handler) {
    handler.apply(this, leftDrawerContent.get());
    return this;
  }

  /**
   * Configures the content of the right drawer using a custom handler.
   *
   * @param handler The handler for configuring the right drawer content.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withRightDrawerContent(ChildHandler<AppLayout, SectionElement> handler) {
    handler.apply(this, rightDrawerContent.get());
    return this;
  }

  /**
   * Retrieves and initializes the navigation bar.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withNavBar() {
    navBar.get();
    return this;
  }

  /**
   * Retrieves and initializes the header element.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withHeader() {
    header.get();
    return this;
  }

  /**
   * Retrieves and initializes the footer section element.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withFooter() {
    footer.get();
    return this;
  }

  /**
   * Retrieves and initializes the left drawer section element.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLeftDrawer() {
    leftDrawer.get();
    return this;
  }

  /**
   * Retrieves and initializes the right drawer section element.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withRightDrawer() {
    rightDrawer.get();
    return this;
  }

  /**
   * Retrieves and initializes the content of the left drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLeftDrawerContent() {
    leftDrawerContent.get();
    return this;
  }

  /**
   * Retrieves and initializes the content of the right drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withRightDrawerContent() {
    rightDrawerContent.get();
    return this;
  }

  /**
   * Sets the size of the left drawer.
   *
   * @param size The size of the left drawer.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setLeftDrawerSize(LeftDrawerSize size) {
    layout.addCss(LEFT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  /**
   * Sets the size of the right drawer.
   *
   * @param size The size of the right drawer.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setRightDrawerSize(RightDrawerSize size) {
    layout.addCss(RIGHT_DRAWER_SIZE.replaceWith(size.getCssClass()));
    return this;
  }

  /**
   * Toggles the left drawer to display with a span-up effect.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleLeftDrawerSpanUp() {
    layout.addCss(ToggleCssClass.of(dui_left_span_up));
    return this;
  }

  /**
   * Sets whether the left drawer should display with a span-up effect.
   *
   * @param spanUp <b>true</b> to enable the span-up effect, <b>false</b> to disable it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setLeftDrawerSpanUp(boolean spanUp) {
    layout.addCss(BooleanCssClass.of(dui_left_span_up, spanUp));
    return this;
  }

  /**
   * Toggles the left drawer to display with a span-down effect.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleLeftDrawerSpanDown() {
    layout.addCss(ToggleCssClass.of(dui_left_span_down));
    return this;
  }

  /**
   * Sets whether the left drawer should display with a span-down effect.
   *
   * @param spanDown <b>true</b> to enable the span-down effect, <b>false</b> to disable it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setLeftDrawerSpanDown(boolean spanDown) {
    layout.addCss(BooleanCssClass.of(dui_left_span_down, spanDown));
    return this;
  }

  /**
   * Toggles the content to shrink when drawers are opened.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleShrinkContent() {
    layout.addCss(ToggleCssClass.of(dui_shrink_content));
    return this;
  }

  /**
   * Sets whether the content should shrink when drawers are opened.
   *
   * @param shrink <b>true</b> to enable content shrinking, <b>false</b> to disable it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setShrinkContent(boolean shrink) {
    layout.addCss(BooleanCssClass.of(dui_shrink_content, shrink));
    return this;
  }

  /**
   * Toggles the left overlay effect.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleLeftOverlay() {
    overlay.get();
    layout.addCss(ToggleCssClass.of(dui_left_overlay));
    return this;
  }

  /**
   * Toggles the right overlay effect.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleRightOverlay() {
    overlay.get();
    layout.addCss(ToggleCssClass.of(dui_right_overlay));
    return this;
  }

  /**
   * Toggles the left drawer open or closed.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleLeftDrawer() {
    layout.addCss(ToggleCssClass.of(dui_left_open));
    return this;
  }

  /**
   * Toggles the right drawer open or closed.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleRightDrawer() {
    layout.addCss(ToggleCssClass.of(dui_right_open));
    return this;
  }

  /**
   * Toggles the fixed footer layout.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout toggleFixedFooter() {
    layout.addCss(ToggleCssClass.of(dui_footer_fixed));
    return this;
  }

  /**
   * Sets whether the footer should be fixed or not.
   *
   * @param fixed <b>true</b> to fix the footer, <b>false</b> to unfix it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setFixedFooter(boolean fixed) {
    layout.addCss(BooleanCssClass.of(dui_footer_fixed, fixed));
    return this;
  }

  /**
   * Shows the left drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout showLeftDrawer() {
    layout.addCss(dui_left_open);
    return this;
  }

  /**
   * Hides the left drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout hideLeftDrawer() {
    dui_left_open.remove(layout);
    return this;
  }

  /**
   * Shows the right drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout showRightDrawer() {
    layout.addCss(dui_right_open);
    return this;
  }

  /**
   * Hides the right drawer.
   *
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout hideRightDrawer() {
    dui_right_open.remove(layout);
    return this;
  }

  /**
   * Sets the icon for the left drawer toggle button.
   *
   * @param icon The icon to set.
   * @return This <b>AppLayout</b> instance for method chaining.
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
   * Sets the icon for the right drawer toggle button.
   *
   * @param icon The icon to set.
   * @return This <b>AppLayout</b> instance for method chaining.
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
   * Sets whether the left drawer should automatically close when clicking outside it.
   *
   * @param autoCloseLeftDrawer <b>true</b> to enable auto-closing, <b>false</b> to disable it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setAutoCloseLeftDrawer(boolean autoCloseLeftDrawer) {
    this.autoCloseLeftDrawer = autoCloseLeftDrawer;
    return this;
  }

  /**
   * Sets the left drawer to be fixed or unfixed, depending on the provided boolean.
   *
   * @param fixed <b>true</b> to fix the left drawer, <b>false</b> to unfix it.
   * @return This <b>AppLayout</b> instance for method chaining.
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
   * Sets whether the right drawer should automatically close when clicking outside it.
   *
   * @param autoCloseRightDrawer <b>true</b> to enable auto-closing, <b>false</b> to disable it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setAutoCloseRightDrawer(boolean autoCloseRightDrawer) {
    this.autoCloseRightDrawer = autoCloseRightDrawer;
    return this;
  }

  /**
   * Configures the left drawer toggle button using the provided handler.
   *
   * @param handler The handler for configuring the left drawer toggle button.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout withLeftDrawerToggle(ChildHandler<AppLayout, PrefixAddOn<HTMLElement>> handler) {
    handler.apply(this, leftDrawerToggle.get());
    return this;
  }

  /**
   * Sets the visibility of the left drawer toggle button.
   *
   * @param visible <b>true</b> to make the toggle button visible, <b>false</b> to hide it.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout setLeftDrawerToggleVisible(boolean visible) {
    leftDrawerToggle.get().toggleDisplay(visible);
    return this;
  }

  /**
   * Checks whether the left drawer is currently open.
   *
   * @return <b>true</b> if the left drawer is open, <b>false</b> otherwise.
   */
  public boolean isLeftDrawerOpen() {
    return dui_left_open.isAppliedTo(layout);
  }

  /**
   * Checks whether the right drawer is currently open.
   *
   * @return <b>true</b> if the right drawer is open, <b>false</b> otherwise.
   */
  public boolean isRightDrawerOpen() {
    return dui_right_open.isAppliedTo(layout);
  }

  /**
   * Registers a listener to be called when the left drawer is opened.
   *
   * @param handler The handler to be called when the left drawer is opened.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout onLeftDrawerOpen(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerOpenHandlers.add(handler);
    return this;
  }

  /**
   * Removes a listener that was previously registered to be called when the left drawer is opened.
   *
   * @param handler The handler to be removed from the list of listeners.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout removeLeftDrawerOpenListener(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerOpenHandlers.remove(handler);
    return this;
  }

  /**
   * Registers a listener to be called when the left drawer is closed.
   *
   * @param handler The handler to be called when the left drawer is closed.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout onLeftDrawerClosed(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerCloseHandlers.add(handler);
    return this;
  }

  /**
   * Removes a listener that was previously registered to be called when the left drawer is closed.
   *
   * @param handler The handler to be removed from the list of listeners.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout removeLeftDrawerCloseListener(ChildHandler<AppLayout, SectionElement> handler) {
    leftDrawerCloseHandlers.remove(handler);
    return this;
  }

  /**
   * Registers a listener to be called when the right drawer is opened.
   *
   * @param handler The handler to be called when the right drawer is opened.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout onRightDrawerOpen(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerOpenHandlers.add(handler);
    return this;
  }

  /**
   * Removes a listener that was previously registered to be called when the right drawer is opened.
   *
   * @param handler The handler to be removed from the list of listeners.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout removeRightDrawerOpenListener(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerOpenHandlers.remove(handler);
    return this;
  }

  /**
   * Registers a listener to be called when the right drawer is closed.
   *
   * @param handler The handler to be called when the right drawer is closed.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout onRightDrawerClosed(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerCloseHandlers.add(handler);
    return this;
  }

  /**
   * Removes a listener that was previously registered to be called when the right drawer is closed.
   *
   * @param handler The handler to be removed from the list of listeners.
   * @return This <b>AppLayout</b> instance for method chaining.
   */
  public AppLayout removeRightDrawerCloseListener(ChildHandler<AppLayout, SectionElement> handler) {
    rightDrawerCloseHandlers.remove(handler);
    return this;
  }

  /**
   * @return The HTMLDivElement representing the layout.
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the HTMLDivElement representing the layout.
   */
  @Override
  public HTMLDivElement element() {
    return layout.element();
  }
}
