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
import org.dominokit.domino.ui.elements.AsideElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.HeaderElement;
import org.dominokit.domino.ui.elements.SectionElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.BooleanCssClass;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.style.ToggleCssClass;
import org.dominokit.domino.ui.utils.*;

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

    public static AppLayout create() {
        return new AppLayout();
    }

    public static AppLayout create(String title) {
        return new AppLayout(title);
    }

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
                LazyChild.of(section()
                                .addCss(dui_left_drawer)
                                .addClickListener(Event::stopPropagation), layout)
                        .whenInitialized(leftDrawerToggle::get);
        leftDrawerContent = LazyChild.of(aside().addCss(dui_layout_menu), leftDrawer);

        rightDrawerToggle = initRightDrawerToggle(rightToggleIcon);
        rightDrawer =
                LazyChild.of(section().addCss(dui_right_drawer)
                                .addClickListener(Event::stopPropagation), layout)
                        .whenInitialized(rightDrawerToggle::get);
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

        DomGlobal.document.addEventListener("dui-event-scroll-top", evt -> {
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
        return LazyChild.of(PostfixAddOn.of(icon)
                        .addCss(dui_order_last_4)
                        .addCss(dui_nav_utility), navBar)
                .whenInitialized(
                        () ->
                                icon.clickable()
                                        .addClickListener(
                                                evt -> {
                                                    evt.stopPropagation();
                                                    toggleRightDrawer();
                                                })
                );
    }

    public AppLayout(String title) {
        this();
        navBar.get().setTitle(title);
    }

    public DivElement getLayout() {
        return layout;
    }

    public SectionElement getBody() {
        return body;
    }

    public SectionElement getContent() {
        return content;
    }

    public NavBar getNavBar() {
        return navBar.get();
    }

    public HeaderElement getHeader() {
        return header.get();
    }

    public SectionElement getFooter() {
        return footer.get();
    }

    public SectionElement getLeftDrawer() {
        return leftDrawer.get();
    }

    public AsideElement getLeftDrawerContent() {
        return leftDrawerContent.get();
    }

    public SectionElement getRightDrawer() {
        return rightDrawer.get();
    }

    public SectionElement getRightDrawerContent() {
        return rightDrawerContent.get();
    }

    public AppLayout withLayout(ChildHandler<AppLayout, DivElement> handler) {
        handler.apply(this, layout);
        return this;
    }

    public AppLayout withBody(ChildHandler<AppLayout, SectionElement> handler) {
        handler.apply(this, body);
        return this;
    }

    public AppLayout withContent(ChildHandler<AppLayout, SectionElement> handler) {
        handler.apply(this, content);
        return this;
    }

    public AppLayout withNavBar(ChildHandler<AppLayout, NavBar> handler) {
        handler.apply(this, navBar.get());
        return this;
    }

    public AppLayout withHeader(ChildHandler<AppLayout, HeaderElement> handler) {
        handler.apply(this, header.get());
        return this;
    }

    public AppLayout withFooter(ChildHandler<AppLayout, SectionElement> handler) {
        handler.apply(this, footer.get());
        return this;
    }

    public AppLayout withLeftDrawer(ChildHandler<AppLayout, SectionElement> handler) {
        handler.apply(this, leftDrawer.get());
        return this;
    }

    public AppLayout withRightDrawer(ChildHandler<AppLayout, SectionElement> handler) {
        handler.apply(this, rightDrawer.get());
        return this;
    }

    public AppLayout withLeftDrawerContent(
            ChildHandler<AppLayout, AsideElement> handler) {
        handler.apply(this, leftDrawerContent.get());
        return this;
    }

    public AppLayout withRightDrawerContent(
            ChildHandler<AppLayout, SectionElement> handler) {
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
        layout.addCss(ToggleCssClass.of(dui_left_span_up));
        return this;
    }

    public AppLayout setLeftDrawerSpanUp(boolean spanUp) {
        layout.addCss(BooleanCssClass.of(dui_left_span_up, spanUp));
        return this;
    }

    public AppLayout toggleLeftDrawerSpanDown() {
        layout.addCss(ToggleCssClass.of(dui_left_span_down));
        return this;
    }

    public AppLayout setLeftDrawerSpanDown(boolean spanDown) {
        layout.addCss(BooleanCssClass.of(dui_left_span_down, spanDown));
        return this;
    }

    public AppLayout toggleShrinkContent() {
        layout.addCss(ToggleCssClass.of(dui_shrink_content));
        return this;
    }

    public AppLayout setShrinkContent(boolean shrink) {
        layout.addCss(BooleanCssClass.of(dui_shrink_content, shrink));
        return this;
    }

    public AppLayout toggleLeftOverlay() {
        overlay.get();
        layout.addCss(ToggleCssClass.of(dui_left_overlay));
        return this;
    }

    public AppLayout toggleRightOverlay() {
        overlay.get();
        layout.addCss(ToggleCssClass.of(dui_right_overlay));
        return this;
    }

    public AppLayout toggleLeftDrawer() {
        layout.addCss(ToggleCssClass.of(dui_left_open));
        return this;
    }

    public AppLayout toggleRightDrawer() {
        layout.addCss(ToggleCssClass.of(dui_right_open));
        return this;
    }

    public AppLayout toggleFixedFooter() {
        layout.addCss(ToggleCssClass.of(dui_footer_fixed));
        return this;
    }

    public AppLayout setFixedFooter(boolean fixed) {
        layout.addCss(BooleanCssClass.of(dui_footer_fixed, fixed));
        return this;
    }

    public AppLayout showLeftDrawer() {
        layout.addCss(dui_left_open);
        return this;
    }

    public AppLayout hideLeftDrawer() {
        dui_left_open.remove(layout);
        return this;
    }

    public AppLayout showRightDrawer() {
        layout.addCss(dui_right_open);
        return this;
    }

    public AppLayout hideRightDrawer() {
        dui_right_open.remove(layout);
        return this;
    }

    public AppLayout setLeftDrawerToggleIcon(Icon<?> icon) {
        if (leftDrawerToggle.isInitialized()) {
            leftDrawerToggle.get().remove();
        }
        this.leftToggleIcon = icon;
        this.leftDrawerToggle = initLeftDrawerToggle(icon);
        leftDrawerToggle.get();
        return this;
    }

    public AppLayout setRightDrawerToggleIcon(Icon<?> icon) {
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

    public AppLayout setAutoCloseRightDrawer(boolean autoCloseRightDrawer) {
        this.autoCloseRightDrawer = autoCloseRightDrawer;
        return this;
    }

    public boolean isLeftDrawerOpen() {
        return dui_left_open.isAppliedTo(layout);
    }

    public boolean isRightDrawerOpen() {
        return dui_right_open.isAppliedTo(layout);
    }

    @Override
    public HTMLDivElement element() {
        return layout.element();
    }
}
