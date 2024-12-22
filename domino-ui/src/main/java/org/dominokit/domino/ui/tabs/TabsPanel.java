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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.style.SwapCssClass;
import org.dominokit.domino.ui.utils.*;

/**
 * A panel that facilitates the creation and management of tabs for organizing content in a
 * structured and accessible manner.
 *
 * <p><b>Usage:</b>
 *
 * <pre>
 * TabsPanel tabsPanel = TabsPanel.create();
 * tabsPanel.appendChild(Tab.create("Key 1", "Title 1"));
 * tabsPanel.appendChild(Tab.create("Key 2", "Title 2"));
 * </pre>
 *
 * @see BaseDominoElement
 */
public class TabsPanel extends BaseDominoElement<HTMLDivElement, TabsPanel>
    implements IsElement<HTMLDivElement>, TabStyles {

  private final DivElement mainNav;
  private final DivElement leadingNav;
  private final DivElement tailNav;
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
  private TabsOverflowHandler currentOverflowHandler;

  /** Creates a new instance of {@link TabsPanel}. */
  public TabsPanel() {
    root =
        div()
            .addCss(dui_tabs, directionCss)
            .appendChild(
                mainNav =
                    div()
                        .addCss(dui_tabs_main_nav)
                        .appendChild(leadingNav = div().addCss(dui_tabs_leading_nav))
                        .appendChild(tabsListElement = ul().addCss(dui_tabs_nav))
                        .appendChild(tailNav = div().addCss(dui_tabs_tail_nav)))
            .appendChild(tabsContent = elementOf(div().addCss(dui_tabs_content).element()));

    init(this);
    setTabsOverflow(config().getUIConfig().getTabsDefaultOverflowHandler());
  }

  /**
   * Factory method to create a new instance of {@link TabsPanel}.
   *
   * @return a new instance of {@link TabsPanel}.
   */
  public static TabsPanel create() {
    return new TabsPanel();
  }

  /**
   * Inserts a tab at a specific index.
   *
   * @param index the index to insert the tab.
   * @param tab the tab to be inserted.
   * @return the current {@link TabsPanel} instance.
   * @throws IndexOutOfBoundsException if the index is out of range.
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

        tab.getClickableElement()
            .addEventListener(
                "click",
                evt -> {
                  activateTab(tab);
                });
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
   * Appends a tab to the end of the tabs list.
   *
   * @param tab the tab to be appended.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel appendChild(Tab tab) {
    insertAt(tabs.size(), tab);
    if (nonNull(currentOverflowHandler)) {
      currentOverflowHandler.update(this);
    }
    return this;
  }

  public TabsPanel appendChild(Tab... tabs) {
    Arrays.stream(tabs).forEach(this::appendChild);
    return this;
  }

  /**
   * Appends a fill item (usually a spacer or separator) to the tabs navigation list.
   *
   * @param fillItem the fill item to be appended.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel appendChild(FillItem fillItem) {
    tabsListElement.appendChild(fillItem);
    return this;
  }

  /**
   * Activates a tab by its index.
   *
   * @param index the index of the tab to activate.
   * @throws IndexOutOfBoundsException if the index is out of range.
   */
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

  public void activateTab(Tab tab) {
    activateTab(tab, false);
  }

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

  public void deActivateTab(Tab tab) {
    deActivateTab(tab, false);
  }

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

  /**
   * {@inheritDoc} Returns the root {@link HTMLDivElement} that represents the tabs panel.
   *
   * @return the root {@link HTMLDivElement} of this {@link TabsPanel}.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Sets the transition effect for the tabs panel.
   *
   * @param transition the transition to set.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel setTransition(Transition transition) {
    this.transition = transition;
    return this;
  }

  /**
   * Sets the container for the tab contents. Replaces the existing content container with the
   * provided one.
   *
   * @param contentContainer the new content container.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel setContentContainer(Element contentContainer) {
    if (root.contains(tabsContent)) {
      tabsContent.remove();
    }
    this.tabsContent = elementOf(contentContainer).addCss(dui_tabs_content);
    return this;
  }

  /**
   * Sets the container for the tab contents using an {@link IsElement}. This is a convenience
   * method that calls {@link #setContentContainer(Element)}.
   *
   * @param contentContainer the new content container.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel setContentContainer(IsElement<?> contentContainer) {
    return setContentContainer(contentContainer.element());
  }

  /**
   * Returns the element representing the tabs' content container.
   *
   * @return the {@link DominoElement} for the tabs' content.
   */
  public DominoElement<Element> getTabsContent() {
    return tabsContent;
  }

  /**
   * Returns the currently active tab of this tabs panel.
   *
   * @return the currently active {@link Tab}.
   */
  public Tab getActiveTab() {
    return activeTab;
  }

  /**
   * Returns a list of all tabs in this tabs panel.
   *
   * @return a list of {@link Tab} elements.
   */
  public List<Tab> getTabs() {
    return tabs;
  }

  /**
   * Closes a given tab. If the closed tab was active, it will activate the next available tab. If
   * there's no other tab, it will deactivate the given tab and set the active tab to null. After
   * closing, it will notify all registered close handlers.
   *
   * @param tab the {@link Tab} to close.
   */
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

    closeHandlers.forEach(closeHandler -> closeHandler.accept(tab));
    tab.setParent(null);
  }

  /**
   * Adds a close handler to be notified when a tab is closed.
   *
   * @param closeHandler a {@link Consumer} to handle the tab close event.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel addCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.add(closeHandler);
    }
    return this;
  }

  /**
   * Removes a previously registered close handler.
   *
   * @param closeHandler the close handler to remove.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel removeCloseHandler(Consumer<Tab> closeHandler) {
    if (nonNull(closeHandler)) {
      this.closeHandlers.remove(closeHandler);
    }
    return this;
  }

  /**
   * Adds an activation handler to be notified when a tab's activation state changes.
   *
   * @param activationHandler the handler to add.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel addActivationHandler(Tab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.add(activationHandler);
    }
    return this;
  }

  /**
   * Removes a previously registered activation handler.
   *
   * @param activationHandler the handler to remove.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel removeActivationHandler(Tab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.remove(activationHandler);
    }
    return this;
  }

  /**
   * Activates a tab by its key.
   *
   * @param key the unique identifier of the tab.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel activateByKey(String key) {
    return activateByKey(key, false);
  }

  /**
   * Activates a tab by its key, with an option to keep the activation silent.
   *
   * @param key the unique identifier of the tab.
   * @param silent whether the activation should be silent.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel activateByKey(String key, boolean silent) {
    findByKey(key).ifPresent(tab -> activateTab(tab, silent));
    return this;
  }

  /**
   * Finds the first tab by the specified key. this is a case-sensitive search
   *
   * @param key The tab key
   * @return Optional of a tab.
   */
  public Optional<Tab> findByKey(String key) {
    return tabs.stream().filter(tab -> Objects.equals(tab.getKey(), key)).findFirst();
  }

  /**
   * Checks if the auto-activation feature is enabled. When auto-activation is enabled, the first
   * tab added to the tabs panel will automatically be set as active.
   *
   * @return true if auto-activation is enabled, false otherwise.
   */
  public boolean isAutoActivate() {
    return autoActivate;
  }

  /**
   * Sets the auto-activation feature. When auto-activation is enabled, the first tab added to the
   * tabs panel will automatically be set as active.
   *
   * @param autoActivate true to enable auto-activation, false to disable it.
   * @return the current {@link TabsPanel} instance for method chaining.
   */
  public TabsPanel setAutoActivate(boolean autoActivate) {
    this.autoActivate = autoActivate;
    return this;
  }

  /**
   * Configures the tabs' alignment.
   *
   * @param align the desired alignment for the tabs.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel setTabsAlign(TabsAlign align) {
    addCss(alignCss.replaceWith(align.getAlign()));
    return this;
  }

  /**
   * Sets the direction for the tabs. This will determine the orientation in which the tabs are
   * displayed within the panel.
   *
   * @param direction the desired {@link TabsDirection} for the tabs.
   * @return the current {@link TabsPanel} instance for method chaining.
   */
  public TabsPanel setTabsDirection(TabsDirection direction) {
    addCss(directionCss.replaceWith(direction));
    return this;
  }

  /**
   * Sets the direction for the header. This can be used to control the layout orientation of the
   * header section relative to the content.
   *
   * @param direction the desired {@link HeaderDirection} for the header.
   * @return the current {@link TabsPanel} instance for method chaining.
   */
  public TabsPanel setHeaderDirection(HeaderDirection direction) {
    addCss(headerDirectionCss.replaceWith(direction));
    return this;
  }

  /**
   * Sets the alignment for the tab headers. This defines the positioning of the headers within the
   * tabs container.
   *
   * @param align the desired {@link TabsHeaderAlign} for the tab headers.
   * @return the current {@link TabsPanel} instance for method chaining.
   */
  public TabsPanel setTabHeaderAlign(TabsHeaderAlign align) {
    addCss(headerAlignCss.replaceWith(align));
    return this;
  }

  @Override
  public PrefixElement getPrefixElement() {
    return PrefixElement.of(tabsListElement);
  }

  @Override
  public PostfixElement getPostfixElement() {
    return PostfixElement.of(tabsListElement);
  }

  /**
   * Apply customizations to the tabs' navigation.
   *
   * @param handler the handler for customizing the tabs' navigation.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel withTabsNav(ChildHandler<TabsPanel, UListElement> handler) {
    handler.apply(this, tabsListElement);
    return this;
  }

  /** @return the tabs {@link UListElement} */
  public UListElement getTabsNav() {
    return tabsListElement;
  }

  /**
   * Apply customizations to the tabs' content.
   *
   * @param handler the handler for customizing the tabs' content.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel withTabsContent(ChildHandler<TabsPanel, DominoElement<Element>> handler) {
    handler.apply(this, tabsContent);
    return this;
  }

  /**
   * Apply customizations to the tabs main navigation element.
   *
   * @param handler the handler for customizing the tabs' content.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel withMainNav(ChildHandler<TabsPanel, DivElement> handler) {
    handler.apply(this, mainNav);
    return this;
  }

  /**
   * Apply customizations to the tabs leading navigation element.
   *
   * @param handler the handler for customizing the tabs' content.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel withNavLeadElement(ChildHandler<TabsPanel, DivElement> handler) {
    handler.apply(this, leadingNav);
    return this;
  }

  /**
   * Apply customizations to the tabs tail navigation element.
   *
   * @param handler the handler for customizing the tabs' content.
   * @return the current {@link TabsPanel} instance.
   */
  public TabsPanel withNavTailElement(ChildHandler<TabsPanel, DivElement> handler) {
    handler.apply(this, tailNav);
    return this;
  }

  /**
   * @return The container that hosts the tabs nav element in addition to navigation leading element
   *     and navigation tail element used to implement navigation overflow behavior
   */
  public DivElement getMainNav() {
    return mainNav;
  }

  /**
   * used to host tabs overflow elements.
   *
   * @return The navigation leading element to the left of the tabs navigation elements
   */
  public DivElement getLeadingNav() {
    return leadingNav;
  }

  /**
   * used to host tabs overflow elements.
   *
   * @return the navigation tail element to the right of the tabs navigation element.
   */
  public DivElement getTailNav() {
    return tailNav;
  }

  public TabsPanel setTabsOverflow(TabsOverflow overflow) {
    if (nonNull(currentOverflowHandler)) {
      currentOverflowHandler.cleanUp(this);
    }

    if (isNull(overflow)) {
      currentOverflowHandler = config().getUIConfig().getTabsDefaultOverflowHandler().get();
    } else {
      currentOverflowHandler = overflow.get();
    }

    currentOverflowHandler.apply(this);

    return this;
  }
}
