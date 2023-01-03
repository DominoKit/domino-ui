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
package org.dominokit.domino.ui.utils;

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.CSSRule;
import elemental2.dom.CSSStyleSheet;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLStyleElement;

public class DynamicStyleSheet<E extends HTMLElement, D extends BaseDominoElement<E, D>> {

  private final String cssPrefix;
  private final D target;
  private final HTMLStyleElement styleElement;
  private final CSSStyleSheet styleSheet;

  public DynamicStyleSheet(String cssPrefix, D target) {
    this.cssPrefix = cssPrefix;
    this.target = target;

    this.styleElement = (HTMLStyleElement) document.createElement("style");
    this.styleElement.type = "text/css";
    this.styleElement.id = target.getDominoId() + "styles";
    document.head.append(this.styleElement);
    this.styleSheet = (CSSStyleSheet) this.styleElement.sheet;

    target.addCss(cssPrefix + target.getDominoId());
    String rule = "." + cssPrefix + target.getDominoId() + " {" + "}";
    this.styleSheet.insertRule(rule, 0);

    target.onDetached(mutationRecord -> document.head.removeChild(this.styleElement));
  }

  public DynamicCssRule insertRule(String cssClass) {
    String ruleName = cssPrefix + cssClass;

    String selector = "." + cssPrefix + target.getDominoId() + " ." + ruleName;

    int index = styleSheet.insertRule(selector + "{}", styleSheet.cssRules.length);
    CSSRule rule = styleSheet.cssRules.item(index);

    return new DynamicCssRule(selector, ruleName, rule);
  }

  public void removeRule(CSSRule cssRule) {
    styleSheet.deleteRule(styleSheet.cssRules.asList().indexOf(cssRule));
  }

  public HTMLStyleElement getStyleElement() {
    return styleElement;
  }

  public CSSStyleSheet getStyleSheet() {
    return styleSheet;
  }

  public static class DynamicCssRule {
    private final String selector;
    private final String className;
    private final CSSRule cssRule;

    private DynamicCssRule(String selector, String className, CSSRule cssRule) {
      this.selector = selector;
      this.className = className;
      this.cssRule = cssRule;
    }

    public String getSelector() {
      return selector;
    }

    public String getClassName() {
      return className;
    }

    public CSSRule getCssRule() {
      return cssRule;
    }
  }
}
