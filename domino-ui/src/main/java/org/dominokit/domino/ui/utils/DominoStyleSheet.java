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
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.CSSStyleSheet;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLStyleElement;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import jsinterop.base.Js;

/** Represents a style sheet containing CSS rules and provides methods to manipulate them. */
public class DominoStyleSheet {

  private Map<String, DominoCSSRule> cssRules = new HashMap<>();

  /**
   * Gets the map of CSS rules contained in this style sheet.
   *
   * @return The map of CSS rules.
   */
  public Map<String, DominoCSSRule> getCssRules() {
    return cssRules;
  }

  /**
   * Sets the map of CSS rules for this style sheet.
   *
   * @param cssRules The map of CSS rules to set.
   */
  public void setCssRules(Map<String, DominoCSSRule> cssRules) {
    this.cssRules = cssRules;
  }

  /**
   * Adds a CSS rule to this style sheet.
   *
   * @param rule The CSS rule to add.
   */
  public void addCssRule(DominoCSSRule rule) {
    cssRules.put(rule.getSelector(), rule);
  }

  /**
   * Removes a CSS rule from this style sheet.
   *
   * @param rule The CSS rule to remove.
   */
  public void removeRule(DominoCSSRule rule) {
    cssRules.remove(rule.getSelector());
  }

  /**
   * Gets a CSS rule by its selector.
   *
   * @param selector The CSS selector of the rule to retrieve.
   * @return An {@link Optional} containing the CSS rule if found, or empty if not found.
   */
  public Optional<DominoCSSRule> get(String selector) {
    return Optional.ofNullable(cssRules.get(selector));
  }

  /**
   * Flushes the CSS rules contained in this style sheet into an HTMLStyleElement.
   *
   * @param style The HTMLStyleElement to flush the CSS rules into.
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
