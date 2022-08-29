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
package org.dominokit.domino.ui.forms;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.menu.AbstractMenuItem;
import org.dominokit.domino.ui.menu.MenuStyles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.HasValue;
import org.gwtproject.editor.client.TakesValue;

/**
 * A component for a single select option in the select component DropDownMenu
 *
 * @param <T> The type of the SelectOption value
 */
public class SelectOption<T> extends AbstractMenuItem<T, SelectOption<T>>
    implements HasValue<SelectOption<T>, T>, TakesValue<T>, IsSelectOption<T> {
  private String displayValue;
  private boolean excludeFromSearchResults = false;
  private SelectSearchFilter<T> selectSearchFilter =
      (token, caseSensitive, selectOption) -> {
        if (selectOption.isExcludeFromSearchResults()) {
          return false;
        }
        if (isNull(token) || token.isEmpty()) {
          return true;
        }
        if (caseSensitive) {
          return selectOption.getDisplayValue().contains(token);
        } else {
          return selectOption.getDisplayValue().toLowerCase().contains(token.toLowerCase());
        }
      };

  private DominoElement<HTMLDivElement> body =
      DominoElement.div().addCss(MenuStyles.MENU_ITEM_BODY);

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption
   * @param displayValue String
   */
  public SelectOption(T value, String key, String displayValue) {
    setKey(key);
    setValue(value);
    setDisplayValue(displayValue);
    appendChild(body);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption and also the display value
   */
  public SelectOption(T value, String key) {
    this(value, key, key);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption
   * @param displayValue String
   * @param <T> type of the SelectOption value
   * @return new SelectOption instance
   */
  public static <T> SelectOption<T> create(T value, String key, String displayValue) {
    return new SelectOption<>(value, key, displayValue);
  }

  /**
   * @param value T the SelectOption value
   * @param key String key unique identifier for the SelectOption and also the display string
   * @param <T> type of the SelectOption value
   * @return new SelectOption instance
   */
  public static <T> SelectOption<T> create(T value, String key) {
    return new SelectOption<>(value, key);
  }

  /** @return String */
  public String getDisplayValue() {
    return displayValue;
  }

  /**
   * @param displayValue String
   * @return same SelectionOption instance
   */
  public SelectOption<T> setDisplayValue(String displayValue) {
    this.displayValue = displayValue;
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> select() {
    return select(false);
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> deselect() {
    return deselect(false);
  }

  /** {@inheritDoc} */
  @Override
  public SelectOption<T> value(T value) {
    return value(value, false);
  }

  @Override
  public SelectOption value(T value, boolean silent) {
    setValue(value);
    return this;
  }

  /** @return boolean, true if this option is excluded from showing in the search results */
  public boolean isExcludeFromSearchResults() {
    return excludeFromSearchResults;
  }

  /**
   * Enable/Disable exclusion from search result
   *
   * @param excludeFromSearchResults boolean, if true then even if this SelectOption matches the
   *     search criteria it wont be included in the search results
   * @return same {@link SelectOption}
   */
  public SelectOption<T> setExcludeFromSearchResults(boolean excludeFromSearchResults) {
    this.excludeFromSearchResults = excludeFromSearchResults;
    return this;
  }

  @Override
  public boolean onSearch(String token, boolean caseSensitive) {
    return selectSearchFilter.onSearch(token, caseSensitive, this);
  }

  @Override
  public SelectOption<T> render(SelectOptionRenderer<T> renderer) {
    body.clearElement().appendChild(renderer.render(getValue(), getKey(), getDisplayValue()));
    return this;
  }

  @Override
  public SelectOption<T> setSearchFilter(SelectSearchFilter selectSearchFilter) {
    if (nonNull(selectSearchFilter)) {
      this.selectSearchFilter = selectSearchFilter;
    }
    return this;
  }
}
