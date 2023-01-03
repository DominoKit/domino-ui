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

import elemental2.dom.HTMLDivElement;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.dominokit.domino.ui.utils.DynamicStyleSheet;

public class ColumnCssRuleMeta<T> implements ColumnMeta {

  public static final String COLUMN_CSS_RULE_META = "column-css-rule-meta";
  public static final String DEFAULT_RULE = "COLUMN-DEFAULT-CSS-RULE";

  private final Map<String, ColumnCssRule> cssRules = new HashMap<>();
  private final DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet;

  static <T> ColumnCssRuleMeta<T> of(
      DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    return new ColumnCssRuleMeta<>(dynamicStyleSheet);
  }

  private ColumnCssRuleMeta(DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    this.dynamicStyleSheet = dynamicStyleSheet;
  }

  public static <T> Optional<ColumnCssRuleMeta<T>> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_CSS_RULE_META);
  }

  public ColumnCssRuleMeta addRule(String key, String cssClass) {
    DynamicStyleSheet.DynamicCssRule dynamicCssRule = dynamicStyleSheet.insertRule(cssClass);
    cssRules.put(
        key,
        new ColumnCssRule(
            key,
            dynamicCssRule.getSelector(),
            dynamicCssRule.getClassName(),
            dynamicCssRule.getCssRule()));
    return this;
  }

  public Optional<ColumnCssRule> getColumnCssRule(String key) {
    return Optional.ofNullable(cssRules.get(key));
  }

  public Map<String, ColumnCssRule> getCssRules() {
    return cssRules;
  }

  public Collection<ColumnCssRule> cssRules() {
    return cssRules.values();
  }

  @Override
  public String getKey() {
    return COLUMN_CSS_RULE_META;
  }
}
