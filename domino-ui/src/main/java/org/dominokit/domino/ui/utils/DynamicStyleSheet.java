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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CSSStyleSheet;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLStyleElement;
import java.util.Optional;

/**
 * Represents a dynamic style sheet that can be used to create and manage CSS rules dynamically.
 *
 * @param <E> The type of the HTML element.
 * @param <D> The type of the Domino UI element.
 */
public class DynamicStyleSheet<E extends HTMLElement, D extends BaseDominoElement<E, D>> {

  private final String cssPrefix;
  private final D target;
  private final HTMLStyleElement styleElement;
  private CSSStyleSheet styleSheet;
  private DominoStyleSheet dominoStyleSheet = new DominoStyleSheet();

  /**
   * Constructs a new {@code DynamicStyleSheet} instance.
   *
   * @param cssPrefix The CSS prefix to use for the dynamic stylesheet.
   * @param target The target Domino UI element to associate the stylesheet with.
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

  /** Flushes the dynamic stylesheet into the associated {@code HTMLStyleElement}. */
  public void flush() {
    dominoStyleSheet.flushInto(styleElement);
  }

  /**
   * Inserts a new CSS rule into the dynamic stylesheet.
   *
   * @param cssClass The CSS class name for the rule.
   * @return The {@code DominoCSSRule} instance representing the inserted rule.
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
   * Removes a CSS rule from the dynamic stylesheet.
   *
   * @param cssRule The {@code DominoCSSRule} instance representing the rule to remove.
   */
  public void removeRule(DominoCSSRule cssRule) {
    dominoStyleSheet.removeRule(cssRule);
  }

  /**
   * Gets the {@code HTMLStyleElement} associated with this dynamic stylesheet.
   *
   * @return The {@code HTMLStyleElement} instance.
   */
  public HTMLStyleElement getStyleElement() {
    return styleElement;
  }

  /**
   * Gets the {@code CSSStyleSheet} associated with this dynamic stylesheet.
   *
   * @return The {@code CSSStyleSheet} instance.
   */
  public CSSStyleSheet getStyleSheet() {
    return styleSheet;
  }

  /**
   * Retrieves a CSS rule from the dynamic stylesheet based on its selector.
   *
   * @param selector The CSS selector to search for.
   * @return An optional {@code DominoCSSRule} instance representing the found rule (if any).
   */
  public Optional<DominoCSSRule> getCssStyleRule(String selector) {
    return dominoStyleSheet.get(selector);
  }
}
