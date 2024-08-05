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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.config.HasComponentConfig;
import org.dominokit.domino.ui.config.TabsConfig;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.LIElement;
import org.dominokit.domino.ui.elements.SpanElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.utils.*;

/**
 * Represents a UI tab component used within a {@link TabsPanel}. Provides functionalities such as
 * activation, deactivation, and closability.
 *
 * <p>Usage example within a {@link TabsPanel}:
 *
 * <pre>
 * TabsPanel panel = new TabsPanel();
 * Tab exampleTab = Tab.create("Example");
 * panel.appendChild(exampleTab);
 * exampleTab.activate();
 * exampleTab.setClosable(true);
 * </pre>
 *
 * @see TabsPanel
 * @see BaseDominoElement
 */
public class Tab extends BaseDominoElement<HTMLLIElement, Tab>
    implements HasClickableElement, HasComponentConfig<TabsConfig>, TabStyles {

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

  /** Constructor to create an empty tab. */
  private Tab() {
    tab =
        li().addCss(dui_tab_item)
            .appendChild(
                tabAnchorElement =
                    a().removeAttribute("href")
                        .addCss(dui_tab_anchor)
                        .appendChild(tabHeader = div().addCss(dui_tab_header)));
    init(this);
    closeIcon =
        LazyChild.of(
            getConfig()
                .getDefaultTabCloseIcon()
                .get()
                .addCss(dui_font_size_4)
                .addCss(dui_tab_header_item, dui_tab_header_close)
                .addClickListener(
                    evt -> {
                      evt.stopPropagation();
                      close();
                    })
                .addEventListener(EventType.mousedown.getName(), Event::stopPropagation)
                .clickable(),
            tabHeader);

    tabPanel = div().addCss(dui_tab_panel);
  }

  /**
   * Constructor to create a tab with a specified title.
   *
   * @param title The title of the tab.
   */
  public Tab(String title) {
    this();
    setTitle(title);
  }

  /**
   * Constructor to create a tab with a specified icon.
   *
   * @param icon The icon of the tab.
   */
  public Tab(Icon<?> icon) {
    this();
    setIcon(icon);
  }

  /**
   * Constructor to create a tab with a specified icon, title, and key.
   *
   * @param icon The icon of the tab.
   * @param title The title of the tab.
   * @param key The key associated with the tab.
   */
  public Tab(Icon<?> icon, String title, String key) {
    this();
    setIcon(icon);
    setTitle(title);
    setKey(key);
  }

  /**
   * Constructor to create a tab with a specified icon and title.
   *
   * @param icon The icon of the tab.
   * @param title The title of the tab.
   */
  public Tab(Icon<?> icon, String title) {
    this();
    setIcon(icon);
    setTitle(title);
  }

  /**
   * Factory method to create a tab with a specified title.
   *
   * @param title The title of the tab.
   * @return The created tab.
   */
  public static Tab create(String title) {
    return new Tab(title);
  }

  /**
   * Creates a new {@link Tab} instance with the specified key and title.
   *
   * @param key The key associated with the tab.
   * @param title The title of the tab.
   * @return The newly created {@link Tab} instance.
   * @see Tab#Tab(String)
   */
  public static Tab create(String key, String title) {
    Tab tab = new Tab(title);
    tab.setKey(key);
    return tab;
  }

  /**
   * Creates a new {@link Tab} instance with the specified icon.
   *
   * @param icon The icon of the tab.
   * @return The newly created {@link Tab} instance.
   * @see Tab#Tab(Icon)
   */
  public static Tab create(Icon<?> icon) {
    return new Tab(icon);
  }

  /**
   * Creates a new {@link Tab} instance with the specified key and icon.
   *
   * @param key The key associated with the tab.
   * @param icon The icon of the tab.
   * @return The newly created {@link Tab} instance.
   * @see Tab#Tab(Icon)
   */
  public static Tab create(String key, Icon<?> icon) {
    Tab tab = new Tab(icon);
    tab.setKey(key);
    return tab;
  }

  /**
   * Creates a new {@link Tab} instance with the specified icon and title.
   *
   * @param icon The icon of the tab.
   * @param title The title of the tab.
   * @return The newly created {@link Tab} instance.
   * @see Tab#Tab(Icon, String)
   */
  public static Tab create(Icon<?> icon, String title) {
    return new Tab(icon, title);
  }

  /**
   * Creates a new {@link Tab} instance with the specified key, icon, and title.
   *
   * @param key The key associated with the tab.
   * @param icon The icon of the tab.
   * @param title The title of the tab.
   * @return The newly created {@link Tab} instance.
   * @see Tab#Tab(Icon, String, String)
   */
  public static Tab create(String key, Icon<?> icon, String title) {
    Tab tab = new Tab(icon, title);
    tab.setKey(key);
    return tab;
  }

  /**
   * Returns the target element where content can be appended.
   *
   * @return The {@link HTMLElement} representing the content area of the tab.
   */
  @Override
  public HTMLElement getAppendTarget() {
    return tabPanel.element();
  }

  /**
   * Returns the underlying LI element of the tab.
   *
   * @return The {@link LIElement} that represents the tab.
   */
  public LIElement getTab() {
    return tab;
  }

  /**
   * Returns the div element that represents the content area of the tab.
   *
   * @return The {@link DivElement} representing the content area of the tab.
   */
  public DivElement getTabPanel() {
    return tabPanel;
  }

  /**
   * Appends a {@link Node} to the content area of the tab.
   *
   * @param content The content to be appended.
   * @return The current {@link Tab} instance.
   */
  public Tab appendChild(Node content) {
    tabPanel.appendChild(content);
    return this;
  }

  public Tab appendChild(Node... contents) {
    Arrays.stream(contents).forEach(this::appendChild);
    return this;
  }

  /**
   * Appends an {@link IsElement} to the content area of the tab.
   *
   * @param content The content to be appended.
   * @return The current {@link Tab} instance.
   */
  public Tab appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  public Tab appendChild(IsElement<?>... contents) {
    Arrays.stream(contents).forEach(this::appendChild);
    return this;
  }

  /**
   * Sets the content of the tab using an {@link IsElement}.
   *
   * @param element The content to be set.
   * @return The current {@link Tab} instance.
   */
  @Override
  public Tab setContent(IsElement<?> element) {
    return setContent(element.element());
  }

  /**
   * Sets the content of the tab using a {@link Node}.
   *
   * @param content The content to be set.
   * @return The current {@link Tab} instance.
   */
  @Override
  public Tab setContent(Node content) {
    tabPanel.clearElement();
    return appendChild(content);
  }

  /**
   * Sets the title of the tab.
   *
   * @param title The title to be set.
   * @return The current {@link Tab} instance.
   */
  public Tab setTitle(String title) {
    if (nonNull(tabTitle) && tabTitle.isInitialized()) {
      tabTitle.remove();
    }

    if (nonNull(title) && !title.isEmpty()) {
      tabTitle =
          LazyChild.of(
              span().textContent(title).addCss(dui_tab_header_item, dui_tab_header_text),
              tabHeader);
      tabTitle.get();
    }
    return this;
  }

  /**
   * Sets the icon of the tab.
   *
   * @param icon The icon to be set.
   * @return The current {@link Tab} instance.
   */
  public Tab setIcon(Icon<?> icon) {
    if (nonNull(tabIcon) && tabIcon.isInitialized()) {
      tabIcon.remove();
    }

    if (nonNull(icon)) {
      tabIcon = LazyChild.of(icon.addCss(dui_tab_header_item, dui_tab_header_icon), tabHeader);
      tabIcon.get();
    }
    return this;
  }

  /**
   * Activates the tab.
   *
   * @return The current {@link Tab} instance.
   */
  public Tab activate() {
    return activate(false);
  }

  /**
   * Activates the tab with an option to silence activation events.
   *
   * @param silent If true, the activation event handlers will not be triggered.
   * @return The current {@link Tab} instance.
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
   * Deactivates the tab.
   *
   * @return The current {@link Tab} instance.
   */
  public Tab deActivate() {
    return deActivate(false);
  }

  /**
   * Deactivates the tab with an option to silence deactivation events.
   *
   * @param silent If true, the deactivation event handlers will not be triggered.
   * @return The current {@link Tab} instance.
   */
  public Tab deActivate(boolean silent) {
    dui_active.remove(tab, tabPanel);
    if (!silent) {
      activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, false));
    }
    return this;
  }

  /**
   * Sets the tab's closability status.
   *
   * @param closable If true, the tab becomes closable; otherwise, it's not closable.
   * @return The current {@link Tab} instance.
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
   * Closes the tab.
   *
   * @return The current {@link Tab} instance.
   */
  public Tab close() {
    if (nonNull(parent)) {
      closeCondition.onBeforeClose(
          this,
          () -> {
            closeHandlers.forEach(handler -> handler.accept(this));
            parent.closeTab(this);
          });
    }
    return this;
  }

  /**
   * Makes the tab closable.
   *
   * @return The current {@link Tab} instance.
   */
  public Tab closable() {
    return setClosable(true);
  }

  /**
   * Makes the tab non-closable.
   *
   * @return The current {@link Tab} instance.
   */
  public Tab notClosable() {
    return setClosable(false);
  }

  /**
   * Sets a handler that is triggered before the tab is closed.
   *
   * @param closeHandler The {@link CloseHandler} instance that provides the close condition.
   * @return The current {@link Tab} instance.
   */
  public Tab setOnBeforeCloseHandler(CloseHandler closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeCondition = closeHandler;
    }
    return this;
  }

  /**
   * Adds a close handler that will be triggered when the tab is closed.
   *
   * @param closeHandler The close handler to be added.
   * @return The current {@link Tab} instance.
   */
  public Tab addCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.add(closeHandler);
    }
    return this;
  }

  /**
   * Removes a previously added close handler.
   *
   * @param closeHandler The close handler to be removed.
   * @return The current {@link Tab} instance.
   */
  public Tab removeCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.remove(closeHandler);
    }
    return this;
  }

  /**
   * Adds an activation handler that will be triggered when the tab is activated or deactivated.
   *
   * @param activationHandler The activation handler to be added.
   * @return The current {@link Tab} instance.
   */
  public Tab addActivationHandler(ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.add(activationHandler);
    }
    return this;
  }

  /**
   * Removes a previously added activation handler.
   *
   * @param activationHandler The activation handler to be removed.
   * @return The current {@link Tab} instance.
   */
  public Tab removeActivationHandler(ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.remove(activationHandler);
    }
    return this;
  }

  /**
   * Checks if the tab is currently active.
   *
   * @return True if the tab is active, otherwise false.
   */
  public boolean isActive() {
    return dui_active.isAppliedTo(tab);
  }

  /**
   * Retrieves the clickable anchor element of the tab.
   *
   * @return The {@link HTMLAnchorElement} which is the clickable element of the tab.
   */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return tabAnchorElement.element();
  }

  /**
   * Retrieves the main LI element that represents the tab.
   *
   * @return The {@link HTMLLIElement} which represents the tab.
   */
  @Override
  public HTMLLIElement element() {
    return tab.element();
  }

  /**
   * Sets the parent {@link TabsPanel} for this tab. This method is typically intended for internal
   * use.
   *
   * @param tabsPanel The parent {@link TabsPanel} for this tab.
   */
  void setParent(TabsPanel tabsPanel) {
    this.parent = tabsPanel;
  }

  /**
   * Retrieves the unique key associated with the tab.
   *
   * @return The key of the tab.
   */
  public String getKey() {
    return key;
  }

  /**
   * Sets the unique key for the tab.
   *
   * @param key The unique key to set.
   * @return The current {@link Tab} instance.
   */
  public Tab setKey(String key) {
    this.key = key;
    return this;
  }

  /** Removes the tab and its associated panel content. */
  public void removeTab() {
    this.remove();
    tabPanel.remove();
  }

  /**
   * Adds child elements to the header of the tab using the provided handler.
   *
   * @param handler The {@link ChildHandler} which defines how child elements should be added to the
   *     tab's header.
   * @return The current {@link Tab} instance.
   */
  public Tab withHeader(ChildHandler<Tab, DivElement> handler) {
    handler.apply(this, tabHeader);
    return this;
  }

  /**
   * Adds child elements to the content of the tab using the provided handler.
   *
   * @param handler The {@link ChildHandler} which defines how child elements should be added to the
   *     tab's content panel.
   * @return The current {@link Tab} instance.
   */
  public Tab withContent(ChildHandler<Tab, DivElement> handler) {
    handler.apply(this, tabPanel);
    return this;
  }

  /** Interface to handle tab close actions. */
  @FunctionalInterface
  public interface CloseHandler {
    /**
     * Triggered before a tab is closed.
     *
     * @param tab The tab being closed.
     * @param callToClose The function to proceed with closing the tab.
     */
    void onBeforeClose(Tab tab, ApplyFunction callToClose);
  }

  /** Interface to handle tab activation state changes. */
  @FunctionalInterface
  public interface ActivationHandler {
    /**
     * Triggered when the active state of a tab changes.
     *
     * @param tab The tab whose active state changed.
     * @param active True if the tab is activated, false otherwise.
     */
    void onActiveStateChanged(Tab tab, boolean active);
  }
}
