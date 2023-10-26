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

package org.dominokit.domino.ui.datatable;

import org.dominokit.domino.ui.utils.DominoCSSRule;

/**
 * Represents a CSS rule associated with a specific column in a data table. This class provides a
 * mechanism to associate custom styles with individual columns in the data table. Each column can
 * be uniquely identified using a key and can have its own CSS styling through a {@link
 * DominoCSSRule}.
 */
public class ColumnCssRule {

  private final String key;
  private final DominoCSSRule cssRule;

  /**
   * Constructs a new {@link ColumnCssRule} instance with the specified key and CSS rule.
   *
   * @param key A unique identifier for the column associated with this CSS rule.
   * @param cssRule A {@link DominoCSSRule} object representing the CSS styling for the column.
   */
  public ColumnCssRule(String key, DominoCSSRule cssRule) {
    this.key = key;
    this.cssRule = cssRule;
  }

  /**
   * Retrieves the unique key associated with the column for this CSS rule.
   *
   * @return the column key.
   */
  public String getKey() {
    return key;
  }

  /**
   * Retrieves the {@link DominoCSSRule} object representing the CSS styling for the column.
   *
   * @return the CSS rule for the column.
   */
  public DominoCSSRule getCssRule() {
    return cssRule;
  }
}
