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
 * An implementation of {@link org.dominokit.domino.ui.menu.AbstractMenuItem} that can take custom
 * content
 */
public class CustomMenuItem<V> extends AbstractMenuItem<V> {

  private MenuSearchFilter searchFilter = (token, caseSensitive) -> false;

  /**
   * create.
   *
   * @param <V> a V class
   * @return a {@link org.dominokit.domino.ui.menu.CustomMenuItem} object
   */
  public static <V> CustomMenuItem<V> create() {
    return new CustomMenuItem<>();
  }

  /**
   * {@inheritDoc}
   *
   * <p>match the search token with both the text and description of the menu item
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
   * Getter for the field <code>searchFilter</code>.
   *
   * @return a {@link org.dominokit.domino.ui.menu.MenuSearchFilter} object
   */
  public MenuSearchFilter getSearchFilter() {
    return searchFilter;
  }

  /**
   * Setter for the field <code>searchFilter</code>.
   *
   * @param searchFilter a {@link org.dominokit.domino.ui.menu.MenuSearchFilter} object
   * @return a {@link org.dominokit.domino.ui.menu.CustomMenuItem} object
   */
  public CustomMenuItem<V> setSearchFilter(MenuSearchFilter searchFilter) {
    if (nonNull(searchFilter)) {
      this.searchFilter = searchFilter;
    }
    return this;
  }
}
