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
import static org.jboss.elemento.Elements.*;

import elemental2.dom.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasClickableElement;
import org.dominokit.domino.ui.utils.TextNode;
import org.jboss.elemento.EventType;
import org.jboss.elemento.IsElement;

/** A component for a single Tab in the {@link TabsPanel} */
@Deprecated
public class Tab extends BaseDominoElement<HTMLLIElement, Tab> implements HasClickableElement {

  private HTMLAnchorElement clickableElement = a().element();
  private DominoElement<HTMLLIElement> tab =
      DominoElement.of(li().attr("role", "presentation").add(clickableElement));

  private DominoElement<HTMLDivElement> contentContainer =
      DominoElement.of(div()).attr("role", "tabpanel").css(TabStyles.TAB_PANE, TabStyles.FADE);

  private FlexItem closeContainer = FlexItem.create();
  private FlexLayout tabElementsContainer;
  private boolean active;
  private MdiIcon closeIcon;
  private TabsPanel parent;
  private String key = "";
  private CloseHandler closeHandler = tab -> true;
  private final List<Consumer<Tab>> closeHandlers = new ArrayList<>();
  private final List<ActivationHandler> activationHandlers = new ArrayList<>();
  private FlexItem iconContainer;
  private FlexItem textContainer;

  /** @param title String title for the tab */
  public Tab(String title) {
    this(null, title);
  }

  /** @param icon {@link BaseIcon} for the tab header */
  public Tab(BaseIcon<?> icon) {
    this(icon, null);
  }

  /**
   * @param icon icon {@link BaseIcon} for the tab header
   * @param title String tab header title
   * @param key String unique identifier for the tab
   */
  public Tab(BaseIcon<?> icon, String title, String key) {
    this(icon, title);
    setKey(key);
  }

  /**
   * @param icon icon {@link BaseIcon} for the tab header
   * @param title String tab header title
   */
  public Tab(BaseIcon<?> icon, String title) {
    iconContainer = FlexItem.create();
    textContainer = FlexItem.create();
    tabElementsContainer = FlexLayout.create();

    if (nonNull(icon)) {
      tabElementsContainer.appendChild(iconContainer.appendChild(icon));
    }
    if (nonNull(title)) {
      tabElementsContainer.appendChild(textContainer.appendChild(span().add(TextNode.of(title))));
    }

    closeIcon =
        Icons.ALL
            .close_mdi()
            .size18()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  close();
                })
            .addEventListener(EventType.mousedown.getName(), Event::stopPropagation)
            .clickable();

    clickableElement.appendChild(tabElementsContainer.element());
    init(this);
    withWaves();
  }

  /**
   * @param title String tab header title
   * @return new Tab instance
   */
  public static Tab create(String title) {
    return new Tab(title);
  }

  /**
   * @param key String unique identifier for the tab
   * @param title String tab header title
   * @return new Tab instance
   */
  public static Tab create(String key, String title) {
    Tab tab = new Tab(title);
    tab.setKey(key);
    return tab;
  }

  /**
   * @param icon icon {@link BaseIcon} for the tab header
   * @return new Tab instance
   */
  public static Tab create(BaseIcon<?> icon) {
    return new Tab(icon);
  }

  /**
   * @param key String unique identifier for the tab
   * @param icon icon {@link BaseIcon} for the tab header
   * @return new Tab instance
   */
  public static Tab create(String key, BaseIcon<?> icon) {
    Tab tab = new Tab(icon);
    tab.setKey(key);
    return tab;
  }

  /**
   * @param icon icon {@link BaseIcon} for the tab header
   * @param title String title for the tab header
   * @return new Tab instance
   */
  public static Tab create(BaseIcon<?> icon, String title) {
    return new Tab(icon, title);
  }

  /**
   * @param key String unique identifier for the tab
   * @param icon icon {@link BaseIcon} for the tab header
   * @param title String title for the tab header
   * @return new Tab instance
   */
  public static Tab create(String key, BaseIcon<?> icon, String title) {
    Tab tab = new Tab(icon, title);
    tab.setKey(key);
    return tab;
  }

  /** @return the Tab {@link HTMLLIElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLLIElement> getTab() {
    return DominoElement.of(tab);
  }

  /** @return the {@link HTMLDivElement} that contains the Tab content */
  public DominoElement<HTMLDivElement> getContentContainer() {
    return DominoElement.of(contentContainer);
  }

  /**
   * @param content {@link Node} to be appended to the tab contentContainer
   * @return same Tab instance
   */
  public Tab appendChild(Node content) {
    contentContainer.appendChild(content);
    return this;
  }

  /**
   * @param content {@link IsElement} to be appended to the tab contentContainer
   * @return same Tab instance
   */
  public Tab appendChild(IsElement<?> content) {
    return appendChild(content.element());
  }

  /** this will replace the content of the tab contentContainer {@inheritDoc} */
  @Override
  public Tab setContent(IsElement<?> element) {
    return setContent(element.element());
  }

  /** this will replace the content of the tab contentContainer {@inheritDoc} */
  @Override
  public Tab setContent(Node content) {
    contentContainer.clearElement();
    return appendChild(content);
  }

  /**
   * @param title String new tab header title
   * @return same Tab instance
   */
  public Tab setTitle(String title) {
    textContainer.clearElement();
    textContainer.appendChild(span().add(TextNode.of(title)));
    return this;
  }

  /**
   * @param icon the new {@link BaseIcon} for the tab header
   * @return same Tab instance
   */
  public Tab setIcon(BaseIcon<?> icon) {
    iconContainer.clearElement();
    iconContainer.appendChild(icon);
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
   *     ActivationHandler}s
   * @return same Tab instance
   */
  public Tab activate(boolean silent) {
    if (nonNull(parent)) {
      parent.deActivateTab(parent.getActiveTab(), silent);
    }
    tab.addCss(TabStyles.ACTIVE);
    contentContainer.addCss(TabStyles.IN, TabStyles.ACTIVE);
    this.active = true;
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
   *     ActivationHandler}s
   * @return same Tab instance
   */
  public Tab deActivate(boolean silent) {
    tab.removeCss(TabStyles.ACTIVE);
    contentContainer.removeCss(TabStyles.IN, TabStyles.ACTIVE);
    this.active = false;
    if (!silent) {
      activationHandlers.forEach(handler -> handler.onActiveStateChanged(this, false));
    }
    return this;
  }

  /**
   * @param closable boolean, if true it adds a close element to the tab header that when clicked it
   *     removes the tab from the TabsPanel
   * @return same Tab instance
   */
  public Tab setClosable(boolean closable) {
    if (closable) {
      closeContainer.clearElement();
      closeContainer.appendChild(closeIcon);
      tabElementsContainer.appendChild(closeContainer);
    } else {
      closeContainer.remove();
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
      if (closeHandler.onBeforeClose(this)) {
        closeHandlers.forEach(handler -> handler.accept(this));
        parent.closeTab(this);
      }
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
      this.closeHandler = closeHandler;
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

  /** @return boolean, true if the tab is currently active */
  public boolean isActive() {
    return active;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLAnchorElement getClickableElement() {
    return clickableElement;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLLIElement element() {
    return tab.element();
  }

  /** @param tabsPanel the {@link TabsPanel} this tab belongs to */
  void setParent(TabsPanel tabsPanel) {
    this.parent = tabsPanel;
  }

  /** @return String unique identifier of this Tab */
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
    contentContainer.remove();
  }

  /**
   * A function to handle closing of tab before the tab is closed, this could be used to confirm
   * closing the Tab
   */
  @FunctionalInterface
  public interface CloseHandler {
    /**
     * @param tab {@link Tab} that is about to be closed
     * @return boolean, true if the tab should be actually closed, false if the tab should not be
     *     cloased
     */
    boolean onBeforeClose(Tab tab);
  }

  /** A function to handle Tab activation state change */
  @FunctionalInterface
  public interface ActivationHandler {
    /**
     * @param tab {@link Tab} that has its state changed
     * @param active boolean, true if the atb is activated, false if it is deactivated
     */
    void onActiveStateChanged(Tab tab, boolean active);
  }
}
