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

import static java.util.Objects.nonNull;

import elemental2.dom.CSSStyleSheet;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLStyleElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import jsinterop.base.Js;

/** DominoStyleSheet class. */
public class DominoStyleSheet {

  private Map<String, DominoCSSRule> cssRules = new HashMap<>();

  /**
   * Getter for the field <code>cssRules</code>.
   *
   * @return a {@link java.util.Map} object
   */
  public Map<String, DominoCSSRule> getCssRules() {
    return cssRules;
  }

  /**
   * Setter for the field <code>cssRules</code>.
   *
   * @param cssRules a {@link java.util.Map} object
   */
  public void setCssRules(Map<String, DominoCSSRule> cssRules) {
    this.cssRules = cssRules;
  }

  /**
   * addCssRule.
   *
   * @param rule a {@link org.dominokit.domino.ui.utils.DominoCSSRule} object
   */
  public void addCssRule(DominoCSSRule rule) {
    cssRules.put(rule.getSelector(), rule);
  }

  /**
   * removeRule.
   *
   * @param rule a {@link org.dominokit.domino.ui.utils.DominoCSSRule} object
   */
  public void removeRule(DominoCSSRule rule) {
    cssRules.remove(rule.getSelector());
  }

  /**
   * get.
   *
   * @param selector a {@link java.lang.String} object
   * @return a {@link java.util.Optional} object
   */
  public Optional<DominoCSSRule> get(String selector) {
    return Optional.ofNullable(cssRules.get(selector));
  }

  /**
   * flushInto.
   *
   * @param style a {@link elemental2.dom.HTMLStyleElement} object
   */
  public void flushInto(HTMLStyleElement style) {
    DomGlobal.setTimeout(
        p0 -> {
          if (nonNull(style)) {
            if (nonNull(style.sheet)) {
              CSSStyleSheet cssStyleSheet = Js.uncheckedCast(style.sheet);
              while (cssStyleSheet.cssRules.length > 0) {
                cssStyleSheet.deleteRule(cssStyleSheet.cssRules.length - 1);
              }
              cssRules.forEach(
                  (s, rule) -> {
                    String cssText = rule.cssText();
                    cssStyleSheet.insertRule(cssText, 0);
                  });
            }
          }
        },
        0);
  }
}
