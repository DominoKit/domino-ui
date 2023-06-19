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

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.utils.PrefixAddOn;

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
public class TabsPanel extends BaseDominoElement<HTMLDivElement, TabsPanel>
    implements IsElement<HTMLDivElement>, TabStyles {

  private DivElement root;
  private UListElement tabsListElement;
  private DominoElement<Element> tabsContent;
  private Tab activeTab;
  private Transition transition;
  private List<Tab> tabs = new ArrayList<>();
  private boolean autoActivate = true;

  private final List<Consumer<Tab>> closeHandlers = new ArrayList<>();
  private final List<Tab.ActivationHandler> activationHandlers = new ArrayList<>();

  private final SwapCssClass alignCss = SwapCssClass.of(TabsAlign.START.getAlign());
  private final SwapCssClass directionCss = SwapCssClass.of(TabsDirection.HORIZONTAL);
  private final SwapCssClass headerDirectionCss = SwapCssClass.of();
  private final SwapCssClass headerAlignCss = SwapCssClass.of();

  public TabsPanel() {
    root =
        div()
            .addCss(dui_tabs, directionCss)
            .appendChild(tabsListElement = ul().addCss(dui_tabs_nav))
            .appendChild(tabsContent = elementOf(div().addCss(dui_tabs_content).element()));

    init(this);
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
          tabsListElement.appendChild(tab.element());
          tabsContent.appendChild(tab.getTabPanel().element());
        } else {
          tabsListElement.insertBefore(tab, tabs.get(index + 1));
          tabsContent.insertBefore(
              tab.getTabPanel().element(), tabs.get(index + 1).getTabPanel().element());
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
  /**
   * @param fillItem {@link FillItem}
   * @return same TabsPanel instance
   */
  public TabsPanel appendChild(FillItem fillItem) {
    tabsListElement.appendChild(fillItem);
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
          Animation.create(activeTab.getTabPanel()).transition(transition).animate();
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
          Animation.create(activeTab.getTabPanel()).transition(transition).animate();
        }
      }
    }
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
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
  public TabsPanel setContentContainer(Element contentContainer) {
    if (root.contains(tabsContent)) {
      tabsContent.remove();
    }
    this.tabsContent = elementOf(contentContainer).addCss(dui_tabs_content);
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
  public DominoElement<Element> getTabsContent() {
    return tabsContent;
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
    tabs.stream()
        .filter(tab -> tab.getKey().equalsIgnoreCase(key))
        .findFirst()
        .ifPresent(tab -> activateTab(tab, silent));
    return this;
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
    addCss(alignCss.replaceWith(align.getAlign()));
    return this;
  }

  /**
   * @param direction {@link TabsDirection}
   * @return same TabsPanel instance
   */
  public TabsPanel setTabsDirection(TabsDirection direction) {
    addCss(directionCss.replaceWith(direction));
    return this;
  }

  public TabsPanel setHeaderDirection(HeaderDirection direction) {
    addCss(headerDirectionCss.replaceWith(direction));
    return this;
  }

  public TabsPanel setTabHeaderAlign(TabsHeaderAlign align) {
    addCss(headerAlignCss.replaceWith(align));
    return this;
  }

  public TabsPanel appendChild(PostfixAddOn<?> postfixAddOn) {
    tabsListElement.appendChild(postfixAddOn);
    return this;
  }

  public TabsPanel appendChild(PrefixAddOn<?> prefixAddOn) {
    tabsListElement.appendChild(prefixAddOn);
    return this;
  }
}
