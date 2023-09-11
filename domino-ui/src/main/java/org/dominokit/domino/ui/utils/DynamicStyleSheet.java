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

import elemental2.dom.CSSStyleSheet;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLStyleElement;
import java.util.Optional;

/** DynamicStyleSheet class. */
public class DynamicStyleSheet<E extends HTMLElement, D extends BaseDominoElement<E, D>> {

  private final String cssPrefix;
  private final D target;
  private final HTMLStyleElement styleElement;
  private CSSStyleSheet styleSheet;
  private DominoStyleSheet dominoStyleSheet = new DominoStyleSheet();

  /**
   * Constructor for DynamicStyleSheet.
   *
   * @param cssPrefix a {@link java.lang.String} object
   * @param target a D object
   */
  public DynamicStyleSheet(String cssPrefix, D target) {
    this.cssPrefix = cssPrefix;
    this.target = target;

    this.styleElement = (HTMLStyleElement) document.createElement("style");
    this.styleElement.type = "text/css";
    this.styleElement.id = target.getDominoId() + "styles";
    target.appendChild(this.styleElement);
    target.addCss(cssPrefix + target.getDominoId());
  }

  /** flush. */
  public void flush() {
    dominoStyleSheet.flushInto(styleElement);
  }

  /**
   * insertRule.
   *
   * @param cssClass a {@link java.lang.String} object
   * @return a {@link org.dominokit.domino.ui.utils.DominoCSSRule} object
   */
  public DominoCSSRule insertRule(String cssClass) {
    String ruleName = cssPrefix + cssClass;
    String selector =
        "." + cssPrefix + target.getDominoId() + " ." + cssPrefix + DomGlobal.CSS.escape(cssClass);

    DominoCSSRule dominoCSSRule = new DominoCSSRule(selector, ruleName);
    dominoStyleSheet.addCssRule(dominoCSSRule);
    return dominoCSSRule;
  }

  /**
   * removeRule.
   *
   * @param cssRule a {@link org.dominokit.domino.ui.utils.DominoCSSRule} object
   */
  public void removeRule(DominoCSSRule cssRule) {
    dominoStyleSheet.removeRule(cssRule);
  }

  /**
   * Getter for the field <code>styleElement</code>.
   *
   * @return a {@link elemental2.dom.HTMLStyleElement} object
   */
  public HTMLStyleElement getStyleElement() {
    return styleElement;
  }

  /**
   * Getter for the field <code>styleSheet</code>.
   *
   * @return a {@link elemental2.dom.CSSStyleSheet} object
   */
  public CSSStyleSheet getStyleSheet() {
    return styleSheet;
  }

  /**
   * getCssStyleRule.
   *
   * @param selector a {@link java.lang.String} object
   * @return a {@link java.util.Optional} object
   */
  public Optional<DominoCSSRule> getCssStyleRule(String selector) {
    return dominoStyleSheet.get(selector);
  }
}
