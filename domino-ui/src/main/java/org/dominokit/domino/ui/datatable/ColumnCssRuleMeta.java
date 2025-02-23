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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.*;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.DynamicStyleSheet;

/**
 * Represents the metadata of CSS rules associated with columns in a data table. This class provides
 * a mechanism to manage and retrieve custom styles associated with individual columns in the data
 * table. Each column can be identified using a key and can have its own CSS styling.
 */
public class ColumnCssRuleMeta<T> implements ComponentMeta {

  /** The meta key for the column CSS rule. */
  public static final String COLUMN_CSS_RULE_META = "column-css-rule-meta";

  /** The key for the default CSS rule. */
  public static final String DEFAULT_RULE = "COLUMN-DEFAULT-CSS-RULE";

  private final Map<String, DominoCSSRule> cssRules = new HashMap<>();
  private final DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet;

  /**
   * Creates an instance of {@link ColumnCssRuleMeta} for the specified dynamic style sheet.
   *
   * @param dynamicStyleSheet The dynamic style sheet associated with the data table.
   * @return The created {@link ColumnCssRuleMeta} instance.
   */
  static <T> ColumnCssRuleMeta<T> of(
      DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    return new ColumnCssRuleMeta<>(dynamicStyleSheet);
  }

  private ColumnCssRuleMeta(DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    this.dynamicStyleSheet = dynamicStyleSheet;
  }

  /**
   * Retrieves the CSS rule meta associated with the given column.
   *
   * @param column The column to get its CSS rule meta.
   * @return The CSS rule meta associated with the column if present; otherwise Optional.empty().
   */
  public static <T> Optional<ColumnCssRuleMeta<T>> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_CSS_RULE_META);
  }

  /**
   * Adds a CSS rule to the column meta.
   *
   * @param key The key associated with the CSS rule.
   * @param cssClass The CSS class rule to be added.
   * @return The current {@link ColumnCssRuleMeta} instance.
   */
  public ColumnCssRuleMeta<T> addRule(String key, String cssClass) {
    DominoCSSRule dominoCSSRule = dynamicStyleSheet.insertRule(cssClass);
    cssRules.put(key, dominoCSSRule);
    return this;
  }

  /**
   * Retrieves the {@link ColumnCssRule} associated with the specified key.
   *
   * @param key The key to retrieve its associated CSS rule.
   * @return The {@link ColumnCssRule} associated with the key if present; otherwise
   *     Optional.empty().
   */
  public Optional<ColumnCssRule> getColumnCssRule(String key) {
    if (cssRules.containsKey(key)) {
      Optional<DominoCSSRule> cssStyleRule =
          dynamicStyleSheet.getCssStyleRule(cssRules.get(key).getSelector());
      if (cssStyleRule.isPresent()) {
        DominoCSSRule dynamicCssRule = cssStyleRule.get();
        return Optional.of(new ColumnCssRule(key, dynamicCssRule));
      }
    }
    return Optional.empty();
  }

  /**
   * Retrieves all the CSS rules associated with the columns in the data table.
   *
   * @return A collection of {@link ColumnCssRule} representing all the CSS rules.
   */
  public Collection<ColumnCssRule> cssRules() {
    List<ColumnCssRule> list = new ArrayList<>();
    for (String s : cssRules.keySet()) {
      Optional<ColumnCssRule> columnCssRule = getColumnCssRule(s);
      if (columnCssRule.isPresent()) {
        ColumnCssRule cssRule = columnCssRule.get();
        list.add(cssRule);
      }
    }
    return list;
  }

  /**
   * Returns the key associated with the column CSS rule meta.
   *
   * @return The key associated with the column CSS rule meta.
   */
  @Override
  public String getKey() {
    return COLUMN_CSS_RULE_META;
  }
}
