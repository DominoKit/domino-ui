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

import java.util.ArrayList;
import java.util.List;

public abstract class MenuItemsGroup<
        V, I extends AbstractMenuItem<V, I>, T extends MenuItemsGroup<V, I, T>>
    extends AbstractMenuItem<V, MenuItemsGroup<V, I, T>> {

  private List<I> menuItems = new ArrayList<>();

  public T appendChild(I menuItem) {
    menuItem.bindToGroup(this);
    getParent().appendChild(menuItem);
    return (T) this;
  }

  public T removeItem(I menuItem) {
    menuItem.unbindGroup();
    parent.removeItem(menuItem);
    return (T) this;
  }

  public List<I> getMenuItems() {
    return menuItems;
  }

  @Override
  public boolean isItemsGroup() {
    return true;
  }

  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    return menuItems.stream().filter(menuItem -> menuItem.onSearch(token, caseSensitive)).count()
        > 0;
  }
}
