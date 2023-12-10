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
import static org.dominokit.domino.ui.utils.Domino.*;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.AnchorElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.elements.UListElement;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.LazyChild;

/**
 * Represents a group of menu items in a {@link Menu}.
 *
 * <p><strong>Usage example:</strong>
 *
 * <pre>{@code
 * Menu<String> menu = Menu.create();
 * MenuItemsGroup<String> group = new MenuItemsGroup<>(menu);
 * group.appendChild(MenuItem.create("Item 1"));
 * group.appendChild(MenuItem.create("Item 2"));
 * menu.appendChild(group);
 * }</pre>
 *
 * @param <V> the type parameter for the value associated with the menu items.
 */
public class MenuItemsGroup<V> extends AbstractMenuItem<V> {

  private final Menu<V> menu;
  private List<AbstractMenuItem<V>> menuItems = new ArrayList<>();

  private DivElement groupElement;
  private LazyChild<NavBar> groupHeader;
  private LazyChild<UListElement> itemsListElement;

  /**
   * Creates a new instance of {@link MenuItemsGroup} attached to a specific menu.
   *
   * @param menu the parent {@link Menu} of this group
   */
  public MenuItemsGroup(Menu<V> menu) {
    this.menu = menu;
    removeCss(dui_menu_item);
    addCss(dui_menu_group);
    linkElement.removeCss(dui_menu_item_anchor);
    linkElement.addCss(dui_menu_group_header);
    root.appendChild(groupElement = div().addCss(dui_flex, dui_flex_col));
    groupHeader =
        LazyChild.of(
            NavBar.create().addCss(dui_menu_group_header_nav).addCss(dui_order_first), bodyElement);
    itemsListElement = LazyChild.of(ul().addCss(dui_menu_items_list, dui_order_last), groupElement);
  }

  /**
   * Appends a menu item to this group.
   *
   * @param menuItem the menu item to append
   * @return this {@link MenuItemsGroup} instance for chaining
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
   * Removes a specific menu item from this group.
   *
   * @param menuItem the menu item to remove
   * @return this {@link MenuItemsGroup} instance for chaining
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
   * Retrieves a list of menu items associated with this group.
   *
   * @return the list of {@link AbstractMenuItem}s
   */
  public List<AbstractMenuItem<V>> getMenuItems() {
    return menuItems;
  }

  /**
   * Applies a specific handler to the header of this group.
   *
   * @param handler the child handler to apply
   * @return this {@link MenuItemsGroup} instance for chaining
   */
  public MenuItemsGroup<V> withHeader(ChildHandler<MenuItemsGroup<V>, NavBar> handler) {
    handler.apply(this, groupHeader.get());
    return this;
  }

  /**
   * Applies a specific handler to the items menu of this group.
   *
   * @param handler the child handler to apply
   * @return this {@link MenuItemsGroup} instance for chaining
   */
  public MenuItemsGroup<V> withItemsMenu(ChildHandler<MenuItemsGroup<V>, UListElement> handler) {
    handler.apply(this, itemsListElement.get());
    return this;
  }

  /**
   * Applies a custom child handler to the link element of this menu item
   *
   * @param handler The child handler to apply.
   * @return This menu item instance.
   */
  public MenuItemsGroup<V> withClickableElement(
      ChildHandler<MenuItemsGroup<V>, AnchorElement> handler) {
    handler.apply(this, linkElement);
    return this;
  }

  /**
   * Invoked during a search operation across all the menu items in this group.
   *
   * @param token the search token
   * @param caseSensitive indicates if the search should be case sensitive or not
   * @return true if any of the menu items match the token; false otherwise
   */
  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    return menuItems.stream().anyMatch(menuItem -> menuItem.onSearch(token, caseSensitive));
  }
}
