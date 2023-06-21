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
import java.util.stream.Collectors;
import org.dominokit.domino.ui.utils.ComponentMeta;
import org.dominokit.domino.ui.utils.DominoCSSRule;
import org.dominokit.domino.ui.utils.DynamicStyleSheet;

/**
 * ColumnCssRuleMeta class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ColumnCssRuleMeta<T> implements ComponentMeta {

  /** Constant <code>COLUMN_CSS_RULE_META="column-css-rule-meta"</code> */
  public static final String COLUMN_CSS_RULE_META = "column-css-rule-meta";
  /** Constant <code>DEFAULT_RULE="COLUMN-DEFAULT-CSS-RULE"</code> */
  public static final String DEFAULT_RULE = "COLUMN-DEFAULT-CSS-RULE";

  private final Map<String, DominoCSSRule> cssRules = new HashMap<>();
  private final DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet;

  static <T> ColumnCssRuleMeta<T> of(
      DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    return new ColumnCssRuleMeta<>(dynamicStyleSheet);
  }

  private ColumnCssRuleMeta(DynamicStyleSheet<HTMLDivElement, DataTable<T>> dynamicStyleSheet) {
    this.dynamicStyleSheet = dynamicStyleSheet;
  }

  /**
   * get.
   *
   * @param column a {@link org.dominokit.domino.ui.datatable.ColumnConfig} object
   * @param <T> a T class
   * @return a {@link java.util.Optional} object
   */
  public static <T> Optional<ColumnCssRuleMeta<T>> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_CSS_RULE_META);
  }

  /**
   * addRule.
   *
   * @param key a {@link java.lang.String} object
   * @param cssClass a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.datatable.ColumnCssRuleMeta} object
   */
  public ColumnCssRuleMeta<T> addRule(String key, String cssClass) {
    DominoCSSRule dominoCSSRule = dynamicStyleSheet.insertRule(cssClass);
    cssRules.put(key, dominoCSSRule);
    return this;
  }

  /**
   * getColumnCssRule.
   *
   * @param key a {@link java.lang.String} object
   * @return a {@link java.util.Optional} object
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
   * cssRules.
   *
   * @return a {@link java.util.Collection} object
   */
  public Collection<ColumnCssRule> cssRules() {
    return cssRules.keySet().stream()
        .map(this::getColumnCssRule)
        .filter(Optional::isPresent)
        .map(Optional::get)
        .collect(Collectors.toList());
  }

  /** {@inheritDoc} */
  @Override
  public String getKey() {
    return COLUMN_CSS_RULE_META;
  }
}
