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

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * A custom menu item that extends the {@link AbstractMenuItem} with the capability to apply custom
 * search filters to menu items.
 *
 * <p><strong>Usage example:</strong>
 *
 * <pre>
 * CustomMenuItem<String> menuItem = CustomMenuItem.create();
 * menuItem.setSearchFilter((token, caseSensitive) -> token.equals("example"));
 * </pre>
 *
 * @param <V> the type parameter for the value associated with the menu item.
 */
public class CustomMenuItem<V> extends AbstractMenuItem<V> {

  private MenuSearchFilter searchFilter = (token, caseSensitive) -> false;

  /**
   * Creates a new instance of {@link CustomMenuItem}.
   *
   * @return a new instance of {@link CustomMenuItem}
   */
  public static <V> CustomMenuItem<V> create() {
    return new CustomMenuItem<>();
  }

  /**
   * Invoked during a search operation. Displays the menu item if the token is found using the
   * provided {@link MenuSearchFilter}.
   *
   * @param token the search token
   * @param caseSensitive indicates if the search should be case sensitive or not
   * @return true if the token matches; false otherwise
   */
  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    if (isNull(token) || token.isEmpty()) {
      this.show();
      return true;
    }
    if (searchable && searchFilter.onSearch(token, caseSensitive)) {
      if (this.isHidden()) {
        this.show();
      }
      return true;
    }
    if (!this.isHidden()) {
      this.hide();
    }
    return false;
  }

  /**
   * Retrieves the current {@link MenuSearchFilter} used for search operations.
   *
   * @return the current {@link MenuSearchFilter}
   */
  public MenuSearchFilter getSearchFilter() {
    return searchFilter;
  }

  /**
   * Sets the {@link MenuSearchFilter} to be used during search operations.
   *
   * @param searchFilter the search filter to set
   * @return this {@link CustomMenuItem} instance for chaining
   */
  public CustomMenuItem<V> setSearchFilter(MenuSearchFilter searchFilter) {
    if (nonNull(searchFilter)) {
      this.searchFilter = searchFilter;
    }
    return this;
  }
}
