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

public class ColumnCssRule {

  private final String key;
  private final String selector;
  private final String cssClass;
  private final CSSRule cssRule;

  public ColumnCssRule(String key, String selector, String cssClass, CSSRule cssRule) {
    this.key = key;
    this.selector = selector;
    this.cssClass = cssClass;
    this.cssRule = cssRule;
  }

  public String getKey() {
    return key;
  }

  public String getSelector() {
    return selector;
  }

  public String getCssClass() {
    return cssClass;
  }

  public CSSRule getCssRule() {
    return cssRule;
  }
}
