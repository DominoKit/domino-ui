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

import static org.jboss.elemento.Elements.*;

import elemental2.dom.HTMLAnchorElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLUListElement;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/** A component that is part of the {@link Layout} header */
public class NavigationBar extends BaseDominoElement<HTMLElement, NavigationBar> {
  private final FlexItem<HTMLDivElement> menuToggleItem;
  private final FlexItem<HTMLDivElement> titleItem;
  private final FlexItem<HTMLDivElement> logoItem;
  private final FlexItem<HTMLDivElement> actionBarItem;

  private DominoElement<HTMLElement> navBar =
      DominoElement.of(nav()).css("navbar").css("ls-closed");
  private FlexLayout container = FlexLayout.create().css("container-fluid");

  DominoElement<HTMLAnchorElement> title = DominoElement.of(a()).css("navbar-brand");
  DominoElement<HTMLAnchorElement> menu = DominoElement.of(a()).css("bars");
  DominoElement<HTMLUListElement> topBar =
      DominoElement.of(ul()).css("nav").css("navbar-nav").css("navbar-right");
  DominoElement<HTMLDivElement> topBarContainer = DominoElement.div().appendChild(topBar);
  DominoElement<HTMLDivElement> navBarHeader = DominoElement.div().css("navbar-header");

  /** */
  public NavigationBar() {
    menuToggleItem = FlexItem.create().css("menu-toggle");
    logoItem = FlexItem.create();
    titleItem = FlexItem.create();
    actionBarItem = FlexItem.create();
    container
        .appendChild(menuToggleItem.appendChild(menu))
        .appendChild(logoItem)
        .appendChild(titleItem.setFlexGrow(1).appendChild(title))
        .appendChild(actionBarItem.appendChild(topBarContainer));

    navBar.appendChild(navBarHeader.appendChild(container));
    init();
  }

  void init() {
    init(this);
  }

  /** @return new NavigationBar instance */
  public static NavigationBar create() {
    return new NavigationBar();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLElement element() {
    return navBar.element();
  }

  /** @return the {@link HTMLElement} of this component wrapped as {@link DominoElement} */
  public DominoElement<HTMLElement> getNavBar() {
    return navBar;
  }

  /** @return the title {@link HTMLAnchorElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLAnchorElement> getTitle() {
    return title;
  }

  /** @return the Menu icon {@link HTMLAnchorElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLAnchorElement> getMenu() {
    return menu;
  }

  public DominoElement<HTMLUListElement> getTopBar() {
    return topBar;
  }

  /**
   * @return the action container {@link HTMLDivElement} at the right side wrapped as {@link
   *     DominoElement}
   */
  public DominoElement<HTMLDivElement> getTopBarContainer() {
    return topBarContainer;
  }

  /** @return the main container {@link HTMLDivElement} wrapped as {@link DominoElement} */
  public DominoElement<HTMLDivElement> getNavBarHeader() {
    return navBarHeader;
  }

  /** @return the {@link FlexItem} that contains the menu toggle icon */
  public FlexItem<HTMLDivElement> getMenuToggleItem() {
    return menuToggleItem;
  }

  /** @return the {@link FlexItem} that contains the logoItem */
  public FlexItem<HTMLDivElement> getLogoItem() {
    return logoItem;
  }

  /** @return The {@link FlexItem} contains the actions bar */
  public FlexItem<HTMLDivElement> getActionBarItem() {
    return actionBarItem;
  }

  /** @return the {@link FlexItem} contains the title */
  public FlexItem<HTMLDivElement> getTitleItem() {
    return titleItem;
  }
}
