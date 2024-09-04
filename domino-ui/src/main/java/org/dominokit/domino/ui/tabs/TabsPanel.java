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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.tabs.TabStyles.HTABS_PANEL;
import static org.jboss.elemento.Elements.div;
import static org.jboss.elemento.Elements.ul;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component to create tabs where only one {@link Tab} can be active at a time
 *
 * <p>The tabs in this component will be always aligned horizontally
 *
 * <pre>
 *     TabsPanel.create()
 *         .appendChild(
 *                 Tab.create("HOME")
 *                         .appendChild(b().textContent("Home Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT")))
 *         .appendChild(
 *                 Tab.create("PROFILE")
 *                         .appendChild(b().textContent("Profile Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT")))
 *         .appendChild(
 *                 Tab.create("MESSAGES")
 *                         .appendChild(b().textContent("Messages Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT"))
 *                         .activate())
 *         .appendChild(
 *                 Tab.create("SETTINGS")
 *                         .appendChild(b().textContent("Settings Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT"))
 *         );
 * </pre>
 */
@Deprecated
public class TabsPanel extends BaseDominoElement<HTMLDivElement, TabsPanel>
    implements IsElement<HTMLDivElement> {

  private final HTMLDivElement element = DominoElement.div().css(HTABS_PANEL).element();
  private final DominoElement<HTMLUListElement> tabsList =
      DominoElement.of(ul())
          .css(TabStyles.NAV, TabStyles.NAV_TABS, TabStyles.NAV_TABS_RIGHT)
          .attr("role", "tablist");
  private HTMLElement tabsContent = DominoElement.of(div()).css(TabStyles.TAB_CONTENT).element();
  private Tab activeTab;
  private Color tabsColor;
  private Transition transition;
  private final List<Tab> tabs = new ArrayList<>();
  private Color background;
  private boolean autoActivate = true;

  private final List<Consumer<Tab>> closeHandlers = new ArrayList<>();
  private final List<Tab.ActivationHandler> activationHandlers = new ArrayList<>();

  public TabsPanel() {
    element.appendChild(tabsList.element());
    element.appendChild(tabsContent);
    init(this);
    setBackgroundColor(Color.WHITE);
    setColor(Color.BLUE);
  }

  public static TabsPanel create() {
    return new TabsPanel();
  }

  /**
   * Inserts a Tab into the specified index
   *
   * @param index int
   * @param tab {@link Tab}
   * @return same TabsPanel
   */
  public TabsPanel insertAt(int index, Tab tab) {
    if (index >= 0 && index <= tabs.size()) {
      if (nonNull(tab)) {
        tabs.add(index, tab);
        if (isNull(activeTab) && autoActivate) {
          this.activeTab = tab;
          activateTab(this.activeTab);
        } else {
          if (tab.isActive()) {
            activateTab(tab);
            this.activeTab = tab;
          }
        }
        if (index == tabs.size() - 1) {
          tabsList.appendChild(tab.element());
          tabsContent.appendChild(tab.getContentContainer().element());
        } else {
          tabsList.insertBefore(tab, tabs.get(index + 1));
          tabsContent.insertBefore(
              tab.getContentContainer().element(),
              tabs.get(index + 1).getContentContainer().element());
        }

        tab.getClickableElement().addEventListener("click", evt -> activateTab(tab));
        tab.setParent(this);
      }
      return this;
    }

    throw new IndexOutOfBoundsException(
        "invalid index for tab insert! Index is ["
            + index
            + "], acceptable range is [0 - "
            + tabs.size()
            + "]");
  }

  /**
   * @param tab {@link Tab} to be added to the TabsPanel, the tab will be added as the last Tab
   * @return same TabsPanel instance
   */
  public TabsPanel appendChild(Tab tab) {
    insertAt(tabs.size(), tab);
    return this;
  }

  /** @param index int index of the Tab to be activated, this will show the tab content */
  public void activateTab(int index) {
    if (!tabs.isEmpty() && index < tabs.size() && index >= 0) {
      activateTab(tabs.get(index));
    } else {
      throw new IndexOutOfBoundsException(
          "provided index of ["
              + index
              + "] is not within current tabs of size ["
              + tabs.size()
              + "].");
    }
  }

  /** @param index int index of the tab to be deactivated, this will hide the tab content */
  public void deActivateTab(int index) {
    if (!tabs.isEmpty() && index < tabs.size() && index >= 0) {
      deActivateTab(tabs.get(index));
    } else {
      throw new IndexOutOfBoundsException(
          "provided index of ["
              + index
              + "] is not within current tabs of size ["
              + tabs.size()
              + "].");
    }
  }

  /** @param tab {@link Tab} to be activated, this will show the tab content */
  public void activateTab(Tab tab) {
    activateTab(tab, false);
  }

  /**
   * @param tab {@link Tab} to be activated, this will show the tab content
   * @param silent boolean, if true the tab will be activated without triggering the {@link
   *     org.dominokit.domino.ui.tabs.Tab.ActivationHandler}s
   */
  public void activateTab(Tab tab, boolean silent) {
    if (nonNull(tab) && tabs.contains(tab)) {
      if (nonNull(activeTab)) {
        deActivateTab(activeTab);
      }
      if (!tab.isActive()) {
        activeTab = tab;
        activeTab.activate();
        if (!silent) {
          activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, true));
        }
        if (nonNull(transition)) {
          Animation.create(activeTab.getContentContainer()).transition(transition).animate();
        }
      }
    }
  }

  /** @param tab {@link Tab} to be deactivated, this will hide the tab content */
  public void deActivateTab(Tab tab) {
    deActivateTab(tab, false);
  }

  /**
   * @param tab {@link Tab} to be deactivated, this will hide the tab content
   * @param silent boolean, if true the tab will be deactivated without triggering the {@link
   *     org.dominokit.domino.ui.tabs.Tab.ActivationHandler}s
   */
  public void deActivateTab(Tab tab, boolean silent) {
    if (nonNull(tab) && tabs.contains(tab)) {
      if (tab.isActive()) {
        tab.deActivate(silent);
        if (!silent) {
          activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, false));
        }
        if (nonNull(transition)) {
          Animation.create(activeTab.getContentContainer()).transition(transition).animate();
        }
      }
    }
  }

  /**
   * @param color {@link Color} of the focus/active color of the tab
   * @return same TabsPanel instance
   */
  public TabsPanel setColor(Color color) {
    if (nonNull(this.tabsColor)) {
      tabsList.removeCss(tabsColor.getStyle());
    }
    tabsList.addCss(color.getStyle());
    this.tabsColor = color;
    return this;
  }

  /**
   * @param background {@link Color} of the TabsPanel header
   * @return same TabsPanel
   */
  public TabsPanel setBackgroundColor(Color background) {
    if (nonNull(this.background)) {
      tabsList.removeCss(this.background.getBackground());
    }
    tabsList.addCss(background.getBackground());
    this.background = background;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element;
  }

  /**
   * @param transition {@link Transition} for activating/deactivating tabs animations
   * @return same TabsPanel instance
   */
  public TabsPanel setTransition(Transition transition) {
    this.transition = transition;
    return this;
  }

  /**
   * @param contentContainer {@link HTMLElement} to used as a container element to render active tab
   *     content
   * @return same TabsPanel instance
   */
  public TabsPanel setContentContainer(HTMLElement contentContainer) {
    if (element.contains(tabsContent)) {
      tabsContent.remove();
    }
    Style.of(contentContainer).addCss(TabStyles.TAB_CONTENT);
    this.tabsContent = contentContainer;
    return this;
  }

  /**
   * @param contentContainer {@link IsElement} to used as a container element to render active tab
   *     content
   * @return same TabsPanel instance
   */
  public TabsPanel setContentContainer(IsElement<?> contentContainer) {
    return setContentContainer(contentContainer.element());
  }

  /**
   * @return the {@link HTMLElement} that is used to as a container element to render active tab
   *     content wrapped as {@link DominoElement}
   */
  public DominoElement<HTMLElement> getTabsContent() {
    return DominoElement.of(tabsContent);
  }

  /** @return the current active {@link Tab} */
  public Tab getActiveTab() {
    return activeTab;
  }

  /** @return List of all {@link Tab}s */
  public List<Tab> getTabs() {
    return tabs;
  }

  /** @param tab {@link Tab} to be closed and removed from the TabsPanel */
  public void closeTab(Tab tab) {
    int tabIndex = tabs.indexOf(tab);
    if (tabs.size() > 1) {
      if (tab.isActive()) {
        if (tabIndex > 0) {
          activateTab(tabIndex - 1);
        } else {
          activateTab(tabIndex + 1);
        }
      }
    } else {
      deActivateTab(tab);
      this.activeTab = null;
    }

    tabs.remove(tab);
    tab.removeTab();

    tab.setParent(null);

    closeHandlers.forEach(closeHandler -> closeHandler.accept(tab));
  }

  /**
   * @param closeHandler {@link Consumer} of {@link Tab} to be called when ever a Tab is closed
   * @return same TabsPanel
   */
  public TabsPanel addCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.add(closeHandler);
    }
    return this;
  }

  /**
   * @param closeHandler {@link Consumer} of {@link Tab} to be called when ever a Tab is closed to
   *     be removed
   * @return same TabsPanel
   */
  public TabsPanel removeCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.remove(closeHandler);
    }
    return this;
  }

  /**
   * @param activationHandler {@link org.dominokit.domino.ui.tabs.Tab.ActivationHandler}
   * @return same TabsPanel instance
   */
  public TabsPanel addActivationHandler(Tab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.add(activationHandler);
    }
    return this;
  }

  /**
   * @param activationHandler {@link org.dominokit.domino.ui.tabs.Tab.ActivationHandler}
   * @return same TabsPanel instance
   */
  public TabsPanel removeActivationHandler(Tab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.remove(activationHandler);
    }
    return this;
  }

  /**
   * @param key String unique key of the currently active tab
   * @return same TabsPanel instance
   */
  public TabsPanel activateByKey(String key) {
    return activateByKey(key, false);
  }

  /**
   * @param key String unique key of the Tab to be activated
   * @param silent boolean, if true the tab will be activated without triggering the {@link
   *     org.dominokit.domino.ui.tabs.Tab.ActivationHandler}s
   * @return
   */
  public TabsPanel activateByKey(String key, boolean silent) {
    findAnyByKey(key).ifPresent(tab -> activateTab(tab, silent));
    return this;
  }

  /**
   * @param key String unique key of the Tab to be activated
   * @return an optional tab matching the given key
   */
  public Optional<Tab> findAnyByKey(String key) {
    return tabs.stream().filter(tab -> tab.getKey().equalsIgnoreCase(key)).findAny();
  }

  /** @return boolean, if auto-activating is enabled */
  public boolean isAutoActivate() {
    return autoActivate;
  }

  /**
   * @param autoActivate boolean, if true then the first tab will be automatically activated when
   *     the TabsPanel is attached to the DOM
   * @return same TabsPanel instance
   */
  public TabsPanel setAutoActivate(boolean autoActivate) {
    this.autoActivate = autoActivate;
    return this;
  }

  /**
   * @param align {@link TabsAlign}
   * @return same TabsPanel instance
   */
  public TabsPanel setTabsAlign(TabsAlign align) {
    this.tabsList.css(align.getAlign());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TabsPanel disable() {
    tabs.forEach(Tab::disable);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public TabsPanel enable() {
    tabs.forEach(Tab::enable);
    return this;
  }
}
