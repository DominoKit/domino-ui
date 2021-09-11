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
import static org.dominokit.domino.ui.tabs.TabStyles.*;
import static org.dominokit.domino.ui.tabs.TabStyles.TAB_CONTENT;
import static org.dominokit.domino.ui.tabs.TabStyles.VTABS_PANEL;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.animations.Animation;
import org.dominokit.domino.ui.animations.Transition;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/**
 * A component to create tabs where only one {@link VerticalTab} can be active at a time
 *
 * <p>The tabs in this component will be always aligned vertically
 *
 * <pre>
 *     VerticalTabsPanel.create()
 *         .apply((element) -&gt; element.getTabsContent().css(Styles.p_l_10))
 *         .appendChild(
 *                 VerticalTab.create("HOME")
 *                         .appendChild(b().textContent("Home Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT")))
 *         .appendChild(
 *                 VerticalTab.create("PROFILE")
 *                         .appendChild(b().textContent("Profile Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT")))
 *         .appendChild(
 *                 VerticalTab.create("MESSAGES")
 *                         .appendChild(b().textContent("Messages Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT"))
 *                         .activate())
 *         .appendChild(
 *                 VerticalTab.create("SETTINGS")
 *                         .appendChild(b().textContent("Settings Content"))
 *                         .appendChild(Paragraph.create("SAMPLE_TEXT")));
 * </pre>
 */
public class VerticalTabsPanel extends BaseDominoElement<HTMLDivElement, VerticalTabsPanel> {

  private final VTabsContainer tabsList = VTabsContainer.create();
  private final FlexItem<HTMLDivElement> tabsHeadersContainer;
  private DominoElement<HTMLDivElement> element = DominoElement.of(div().css(VTABS_PANEL));
  private HTMLElement tabsContent = div().css(TAB_CONTENT).element();
  private VerticalTab activeTab;
  private Color tabsColor;
  private Transition transition;
  private List<VerticalTab> tabs = new ArrayList<>();
  private Color background;

  private boolean activeTabColored = false;

  private Color textColor;
  private Color iconColor;
  private final List<VerticalTab.ActivationHandler> activationHandlers = new ArrayList<>();

  public static VerticalTabsPanel create() {
    return new VerticalTabsPanel();
  }

  public VerticalTabsPanel() {
    tabsHeadersContainer = FlexItem.create();
    element.appendChild(
        FlexLayout.create()
            .styler(style -> style.add(TABS_CONTAINER))
            .appendChild(
                tabsHeadersContainer.styler(style -> style.add(TABS)).appendChild(tabsList))
            .appendChild(
                FlexItem.create()
                    .styler(style -> style.add(TABS_CONTENT))
                    .setFlexGrow(1)
                    .appendChild(tabsContent)));

    init(this);
    setColor(Color.BLUE);
  }

  /**
   * @param fillItem {@link FillItem} to be added between tabs to make more space between them
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel appendChild(FillItem fillItem) {
    if (nonNull(fillItem)) {
      tabsList.appendChild(fillItem);
    }
    return this;
  }

  /**
   * @param tab {@link VerticalTab} to be added to the TabsPanel, the tab will be added as the last
   *     Tab
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel appendChild(VerticalTab tab) {
    if (nonNull(tab)) {
      tabs.add(tab);
      if (isNull(activeTab)) {
        this.activeTab = tab;
        this.activeTab.activate();
        if (activeTabColored) {
          this.activeTab.setColor(tabsColor);
        }
      } else {
        if (tab.isActive()) {
          activateTab(tab);
        }
      }
      tabsList.appendChild(tab);
      tabsContent.appendChild(tab.getContentContainer().element());
      tab.getClickableElement().addEventListener("click", evt -> activateTab(tab));
      if (nonNull(textColor)) {
        tab.setTextColor(textColor);
      }

      if (nonNull(iconColor)) {
        tab.setIconColor(iconColor);
      }
    }
    return this;
  }

  /** @return the {@link Color} of the tab header text */
  public Color getTextColor() {
    return textColor;
  }

  /**
   * @param textColor {@link Color} of the Tab header title
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setTextColor(Color textColor) {
    this.textColor = textColor;
    getTabs().forEach(verticalTab -> verticalTab.setTextColor(textColor));
    return this;
  }

  /** @return the {@link Color} of the tab header icon */
  public Color getIconColor() {
    return iconColor;
  }

  /**
   * @param iconColor {@link Color} of the tab header icon
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setIconColor(Color iconColor) {
    this.iconColor = iconColor;
    getTabs().forEach(verticalTab -> verticalTab.setIconColor(iconColor));
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

  /** @param tab {@link VerticalTab} to be activated, this will show the tab content */
  public void activateTab(VerticalTab tab) {
    if (nonNull(tab) && tabs.contains(tab)) {
      if (activeTabColored) {
        this.activeTab.resetColor();
      }
      activeTab.deactivate();
      activeTab = tab;
      activeTab.activate();
      activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, true));
      if (nonNull(transition)) {
        Animation.create(activeTab.getContentContainer()).transition(transition).animate();
      }

      if (activeTabColored) {
        this.activeTab.setColor(this.tabsColor);
      }
    }
  }

  /** @param tab {@link VerticalTab} to be deactivated, this will hide the tab content */
  public void deactivateTab(VerticalTab tab) {
    if (nonNull(tab) && tabs.contains(tab)) {
      if (tab.isActive()) {
        tab.deactivate();
        activationHandlers.forEach(handler -> handler.onActiveStateChanged(tab, false));
        if (nonNull(transition)) {
          Animation.create(activeTab.getContentContainer()).transition(transition).animate();
        }
      }
    }
  }

  /**
   * @param color {@link Color} of the Tabs headers
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setColor(Color color) {
    if (nonNull(this.tabsColor)) {
      tabsList.style().remove(tabsColor.getStyle());
    }
    tabsList.style().add(color.getStyle());
    this.tabsColor = color;

    if (activeTabColored && nonNull(this.activeTab)) {
      this.activeTab.setColor(this.tabsColor);
    }
    return this;
  }

  /** @return boolean, true if the active tab will have the color from {@link #setColor(Color)} */
  public boolean isActiveTabColored() {
    return activeTabColored;
  }

  /**
   * @param activeTabColored boolean, if true the active tab will have the color from {@link
   *     #setColor(Color)}
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setActiveTabColored(boolean activeTabColored) {
    this.activeTabColored = activeTabColored;
    if (activeTabColored) {
      if (nonNull(activeTab) && nonNull(this.tabsColor)) {
        this.activeTab.setColor(tabsColor);
      }
    } else {
      this.activeTab.resetColor();
    }

    return this;
  }

  /**
   * @param background {@link Color} of tabs panel header
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setBackgroundColor(Color background) {
    if (nonNull(this.background)) {
      tabsList.style().remove(this.background.getBackground());
    }
    tabsList.style().add(background.getBackground());
    this.background = background;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /**
   * @param transition {@link Transition} for activating/deactivating tabs animations
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setTransition(Transition transition) {
    this.transition = transition;
    return this;
  }

  /**
   * @param contentContainer {@link HTMLElement} to used as a container element to render active tab
   *     content
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setContentContainer(HTMLElement contentContainer) {
    if (element.contains(tabsContent)) {
      tabsContent.remove();
    }
    Style.of(contentContainer).add("tab-content");
    this.tabsContent = contentContainer;
    return this;
  }

  /**
   * @param contentContainer {@link IsElement} to used as a container element to render active tab
   *     content
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel setContentContainer(IsElement<?> contentContainer) {
    return setContentContainer(contentContainer.element());
  }

  /**
   * @return the {@link HTMLElement} that is used to as a container element to render active tab
   *     content wrapped as {@link DominoElement}
   */
  public DominoElement<HTMLElement> getTabsContent() {
    return DominoElement.of(tabsContent);
  }

  /** @return the current active {@link VerticalTab} */
  public VerticalTab getActiveTab() {
    return activeTab;
  }

  /** @return List of all {@link VerticalTab}s */
  public List<VerticalTab> getTabs() {
    return tabs;
  }

  /**
   * render the tab header title under the tab head icon
   *
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel textBelowIcon() {
    tabsList.style().add("text-below");
    return this;
  }

  /**
   * render the tab header title horizontally with the tab header icon
   *
   * @return same VerticalTabsPanel instance
   */
  public VerticalTabsPanel textBesideIcon() {
    tabsList.style().remove("text-below");
    return this;
  }

  /** @return the {@link VTabsContainer} */
  public VTabsContainer getTabsContainer() {
    return tabsList;
  }

  /** @return the {@link FlexItem} that contains the Tabs headers */
  public FlexItem getTabsHeadersContainer() {
    return tabsHeadersContainer;
  }

  /**
   * @param activationHandler {@link org.dominokit.domino.ui.tabs.VerticalTab.ActivationHandler}
   * @return same instance
   */
  public VerticalTabsPanel addActivationHandler(VerticalTab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.add(activationHandler);
    }
    return this;
  }

  /**
   * @param activationHandler {@link org.dominokit.domino.ui.tabs.VerticalTab.ActivationHandler}
   * @return same instance
   */
  public VerticalTabsPanel removeActivationHandler(
      VerticalTab.ActivationHandler activationHandler) {
    if (nonNull(activationHandler)) {
      this.activationHandlers.remove(activationHandler);
    }
    return this;
  }
}
