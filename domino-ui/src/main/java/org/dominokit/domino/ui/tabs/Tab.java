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
package org.dominokit.domino.ui.tabs;

import static java.util.Objects.nonNull;

import elemental2.dom.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.TabsConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.ApplyFunction;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.LazyChild;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.IsElement;

/**
 * A component for a single Tab in the {@link TabsPanel}
 */
public class Tab extends BaseDominoElement<HTMLLIElement, Tab>
        implements HasClickableElement,
        HasComponentConfig<TabsConfig>,
        TabStyles {

    private final LIElement tab;
    private final AnchorElement tabAnchorElement;
    private final DivElement tabHeader;
    private final DivElement tabPanel;
    private final LazyChild<Icon<?>> closeIcon;
    private LazyChild<Icon<?>> tabIcon;
    private LazyChild<SpanElement> tabTitle;
    private TabsPanel parent;
    private String key = "";
    private CloseHandler closeCondition = (tab1, callToClose) -> callToClose.apply();
    private final List<Consumer<Tab>> closeHandlers = new ArrayList<>();
    private final List<ActivationHandler> activationHandlers = new ArrayList<>();

    private Tab() {
        tab = li()
                .addCss(dui_tab_item)
                .appendChild(tabAnchorElement = a().addCss(dui_tab_anchor)
                        .appendChild(tabHeader = div().addCss(dui_tab_header))
                );
        init(this);
        closeIcon = LazyChild.of(getConfig().getDefaultTabCloseIcon()
                .get()
                .addCss(dui_font_size_4)
                .addCss(dui_tab_header_item, dui_tab_header_close)
                .addClickListener(
                        evt -> {
                            evt.stopPropagation();
                            close();
                        })
                .addEventListener(EventType.mousedown.getName(), Event::stopPropagation)
                .clickable(), tabHeader);

        tabPanel = div().addCss(dui_tab_panel);

    }


    /**
     * @param title String title for the tab
     */
    public Tab(String title) {
        this();
        setTitle(title);
    }

    /**
     * @param icon {@link Icon} for the tab header
     */
    public Tab(Icon<?> icon) {
        this();
        setIcon(icon);
    }

    /**
     * @param icon  icon {@link Icon} for the tab header
     * @param title String tab header title
     * @param key   String unique identifier for the tab
     */
    public Tab(Icon<?> icon, String title, String key) {
        this();
        setIcon(icon);
        setTitle(title);
        setKey(key);
    }

    /**
     * @param icon  icon {@link Icon} for the tab header
     * @param title String tab header title
     */
    public Tab(Icon<?> icon, String title) {
        this();
        setIcon(icon);
        setTitle(title);
    }

    /**
     * @param title String tab header title
     * @return new Tab instance
     */
    public static Tab create(String title) {
        return new Tab(title);
    }

    /**
     * @param key   String unique identifier for the tab
     * @param title String tab header title
     * @return new Tab instance
     */
    public static Tab create(String key, String title) {
        Tab tab = new Tab(title);
        tab.setKey(key);
        return tab;
    }

    /**
     * @param icon icon {@link Icon} for the tab header
     * @return new Tab instance
     */
    public static Tab create(Icon<?> icon) {
        return new Tab(icon);
    }

    /**
     * @param key  String unique identifier for the tab
     * @param icon icon {@link Icon} for the tab header
     * @return new Tab instance
     */
    public static Tab create(String key, Icon<?> icon) {
        Tab tab = new Tab(icon);
        tab.setKey(key);
        return tab;
    }

    /**
     * @param icon  icon {@link Icon} for the tab header
     * @param title String title for the tab header
     * @return new Tab instance
     */
    public static Tab create(Icon<?> icon, String title) {
        return new Tab(icon, title);
    }

    /**
     * @param key   String unique identifier for the tab
     * @param icon  icon {@link Icon} for the tab header
     * @param title String title for the tab header
     * @return new Tab instance
     */
    public static Tab create(String key, Icon<?> icon, String title) {
        Tab tab = new Tab(icon, title);
        tab.setKey(key);
        return tab;
    }

    @Override
    protected HTMLElement getAppendTarget() {
        return tabPanel.element();
    }

    /**
     * @return the Tab {@link HTMLLIElement} wrapped as {@link DominoElement}
     */
    public LIElement getTab() {
        return tab;
    }

    /**
     * @return the {@link HTMLDivElement} that contains the Tab content
     */
    public DivElement getTabPanel() {
        return tabPanel;
    }

    /**
     * @param content {@link Node} to be appended to the tab contentContainer
     * @return same Tab instance
     */
    public Tab appendChild(Node content) {
        tabPanel.appendChild(content);
        return this;
    }

    /**
     * @param content {@link IsElement} to be appended to the tab contentContainer
     * @return same Tab instance
     */
    public Tab appendChild(IsElement<?> content) {
        return appendChild(content.element());
    }

    /**
     * this will replace the content of the tab contentContainer {@inheritDoc}
     */
    @Override
    public Tab setContent(IsElement<?> element) {
        return setContent(element.element());
    }

    /**
     * this will replace the content of the tab contentContainer {@inheritDoc}
     */
    @Override
    public Tab setContent(Node content) {
        tabPanel.clearElement();
        return appendChild(content);
    }

    /**
     * @param title String new tab header title
     * @return same Tab instance
     */
    public Tab setTitle(String title) {
        if(nonNull(tabTitle) && tabTitle.isInitialized()){
            tabTitle.remove();
        }

        if(nonNull(title) && !title.isEmpty()){
            tabTitle = LazyChild.of(span().textContent(title).addCss(dui_tab_header_item, dui_tab_header_text), tabHeader);
            tabTitle.get();
        }
        return this;
    }

    /**
     * @param icon the new {@link Icon} for the tab header
     * @return same Tab instance
     */
    public Tab setIcon(Icon<?> icon) {
        if(nonNull(tabIcon) && tabIcon.isInitialized()){
            tabIcon.remove();
        }

        if(nonNull(icon)){
            tabIcon = LazyChild.of(icon.addCss(dui_tab_header_item, dui_tab_header_icon), tabHeader);
            tabIcon.get();
        }
        return this;
    }

    /**
     * make the tab active and show its content in the TabsPanel
     *
     * @return same Tab instance
     */
    public Tab activate() {
        return activate(false);
    }

    /**
     * make the tab active and show its content in the TabsPanel
     *
     * @param silent boolean, if true then activate the tab without triggering the {@link
     *               ActivationHandler}s
     * @return same Tab instance
     */
    public Tab activate(boolean silent) {
        if (nonNull(parent)) {
            parent.deActivateTab(parent.getActiveTab(), silent);
        }
        dui_active.apply(tab, tabPanel);
        if (!silent) {
            activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, true));
        }
        return this;
    }

    /**
     * make the tab inactive and hide its content in the TabsPanel
     *
     * @return same Tab instance
     */
    public Tab deActivate() {
        return deActivate(false);
    }

    /**
     * make the tab inactive and hides its content in the TabsPanel
     *
     * @param silent boolean, if true then activate the tab without triggering the {@link
     *               ActivationHandler}s
     * @return same Tab instance
     */
    public Tab deActivate(boolean silent) {
        dui_active.remove(tab, tabPanel);
        if (!silent) {
            activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, false));
        }
        return this;
    }

    /**
     * @param closable boolean, if true it adds a close element to the tab header that when clicked it
     *                 removes the tab from the TabsPanel
     * @return same Tab instance
     */
    public Tab setClosable(boolean closable) {
        if (closable) {
            closeIcon.get();
        } else {
           closeIcon.remove();
        }
        return this;
    }

    /**
     * Remove the Tab from the TabsPanel
     *
     * @return same Tab instance
     */
    public Tab close() {
        if (nonNull(parent)) {
            closeCondition.onBeforeClose(this, () -> {
                closeHandlers.forEach(handler -> handler.accept(this));
                parent.closeTab(this);
            });
        }
        return this;
    }

    /**
     * delegate to {@link #setClosable(boolean)} with true
     *
     * @return same Tab instance
     */
    public Tab closable() {
        return setClosable(true);
    }

    /**
     * delegate to {@link #setClosable(boolean)} with false
     *
     * @return same Tab instance
     */
    public Tab notClosable() {
        return setClosable(false);
    }

    /**
     * @param closeHandler {@link CloseHandler}
     * @return same Tab instance
     */
    public Tab setOnBeforeCloseHandler(CloseHandler closeHandler) {
        if (nonNull(closeHandler)) {
            this.closeCondition = closeHandler;
        }
        return this;
    }

    /**
     * @param closeHandler Consumer of {@link Tab} to be called when the tab is closed
     * @return same Tab instance
     */
    public Tab addCloseHandler(Consumer<Tab> closeHandler) {
        if (nonNull(closeHandler)) {
            this.closeHandlers.add(closeHandler);
        }
        return this;
    }

    /**
     * @param closeHandler Consumer of {@link Tab} to be called when the tab is closed
     * @return same Tab instance
     */
    public Tab removeCloseHandler(Consumer<Tab> closeHandler) {
        if (nonNull(closeHandler)) {
            this.closeHandlers.remove(closeHandler);
        }
        return this;
    }

    /**
     * @param activationHandler {@link ActivationHandler}
     * @return same Tab instance
     */
    public Tab addActivationHandler(ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.add(activationHandler);
        }
        return this;
    }

    /**
     * @param activationHandler {@link ActivationHandler}
     * @return same Tab instance
     */
    public Tab removeActivationHandler(ActivationHandler activationHandler) {
        if (nonNull(activationHandler)) {
            this.activationHandlers.remove(activationHandler);
        }
        return this;
    }

    /**
     * @return boolean, true if the tab is currently active
     */
    public boolean isActive() {
        return dui_active.isAppliedTo(tab);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLAnchorElement getClickableElement() {
        return tabAnchorElement.element();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HTMLLIElement element() {
        return tab.element();
    }

    /**
     * @param tabsPanel the {@link TabsPanel} this tab belongs to
     */
    void setParent(TabsPanel tabsPanel) {
        this.parent = tabsPanel;
    }

    /**
     * @return String unique identifier of this Tab
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key String unique identifier of this Tab
     * @return same Tab instance
     */
    public Tab setKey(String key) {
        this.key = key;
        return this;
    }

    /**
     * Removes the tab from the TabsPanel, this is different from closing the tab and wont trigger the
     * close handlers
     */
    public void removeTab() {
        this.remove();
        tabPanel.remove();
    }

    /**
     * A function to handle closing of tab before the tab is closed, this could be used to confirm
     * closing the Tab
     */
    @FunctionalInterface
    public interface CloseHandler {
        /**
         * @param tab {@link Tab} that is about to be closed
         * closed
         */
        void onBeforeClose(Tab tab, ApplyFunction callToClose);
    }

    /**
     * A function to handle Tab activation state change
     */
    @FunctionalInterface
    public interface ActivationHandler {
        /**
         * @param tab    {@link Tab} that has its state changed
         * @param active boolean, true if the atb is activated, false if it is deactivated
         */
        void onActiveStateChanged(Tab tab, boolean active);
    }
}
