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
package org.dominokit.domino.ui.menu;

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.menu.MenuStyles.*;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * MenuItemsGroup class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class MenuItemsGroup<V> extends AbstractMenuItem<V> {

  private final Menu<V> menu;
  private List<AbstractMenuItem<V>> menuItems = new ArrayList<>();

  private DivElement groupElement;
  private LazyChild<NavBar> groupHeader;
  private LazyChild<UListElement> itemsListElement;

  /**
   * Constructor for MenuItemsGroup.
   *
   * @param menu a {@link org.dominokit.domino.ui.menu.Menu} object
   */
  public MenuItemsGroup(Menu<V> menu) {
    this.menu = menu;
    removeCss(dui_menu_item);
    addCss(dui_menu_group);
    linkElement.removeCss(dui_menu_item_anchor);
    linkElement.addCss(dui_menu_group_header);
    root.appendChild(groupElement = div().addCss(dui_flex, dui_flex_col));
    groupHeader = LazyChild.of(NavBar.create().addCss(dui_order_first), bodyElement);
    itemsListElement = LazyChild.of(ul().addCss(dui_menu_items_list, dui_order_last), groupElement);
  }

  /**
   * appendChild.
   *
   * @param menuItem a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   * @return a {@link org.dominokit.domino.ui.menu.MenuItemsGroup} object
   */
  public MenuItemsGroup<V> appendChild(AbstractMenuItem<V> menuItem) {
    if (nonNull(menuItem)) {
      menuItem.bindToGroup(this);
      itemsListElement.get().appendChild(menuItem);
      menuItems.add(menuItem);
      menuItem.setParent(menu);
      menu.onItemAdded(menuItem);
    }
    return this;
  }

  /**
   * removeItem.
   *
   * @param menuItem a {@link org.dominokit.domino.ui.menu.AbstractMenuItem} object
   * @return a {@link org.dominokit.domino.ui.menu.MenuItemsGroup} object
   */
  public MenuItemsGroup<V> removeItem(AbstractMenuItem<V> menuItem) {
    if (this.menuItems.contains(menuItem)) {
      menuItem.unbindGroup();
      menuItem.remove();
      this.menuItems.remove(menuItem);
    }
    return this;
  }

  /**
   * Getter for the field <code>menuItems</code>.
   *
   * @return a {@link java.util.List} object
   */
  public List<AbstractMenuItem<V>> getMenuItems() {
    return menuItems;
  }

  /**
   * withHeader.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.menu.MenuItemsGroup} object
   */
  public MenuItemsGroup<V> withHeader(ChildHandler<MenuItemsGroup<V>, NavBar> handler) {
    handler.apply(this, groupHeader.get());
    return this;
  }

  /**
   * withItemsMenu.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.menu.MenuItemsGroup} object
   */
  public MenuItemsGroup<V> withItemsMenu(ChildHandler<MenuItemsGroup<V>, UListElement> handler) {
    handler.apply(this, itemsListElement.get());
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    return menuItems.stream().anyMatch(menuItem -> menuItem.onSearch(token, caseSensitive));
  }
}
