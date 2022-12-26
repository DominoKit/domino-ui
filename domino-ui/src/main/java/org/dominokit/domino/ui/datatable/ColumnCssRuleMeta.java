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

import elemental2.dom.CSSRule;
import java.util.Optional;

public class ColumnCssRuleMeta implements ColumnMeta {

  public static final String COLUMN_CSS_RULE_META = "column-css-rule-meta";

  private final CSSRule cssRule;
  private final String selector;

  public static ColumnCssRuleMeta of(CSSRule cssRule, String selector) {
    return new ColumnCssRuleMeta(cssRule, selector);
  }

  public ColumnCssRuleMeta(CSSRule cssRule, String selector) {
    this.cssRule = cssRule;
    this.selector = selector;
  }

  public static Optional<ColumnCssRuleMeta> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_CSS_RULE_META);
  }

  public CSSRule getCssRule() {
    return cssRule;
  }

  public String getSelector() {
    return selector;
  }

  @Override
  public String getKey() {
    return COLUMN_CSS_RULE_META;
  }
}
