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

@Deprecated
public class DominoStyleSheet {

  private Map<String, DominoCSSRule> cssRules = new HashMap<>();

  public Map<String, DominoCSSRule> getCssRules() {
    return cssRules;
  }

  public void setCssRules(Map<String, DominoCSSRule> cssRules) {
    this.cssRules = cssRules;
  }

  public void addCssRule(DominoCSSRule rule) {
    cssRules.put(rule.getSelector(), rule);
  }

  public void removeRule(DominoCSSRule rule) {
    cssRules.remove(rule.getSelector());
  }

  public Optional<DominoCSSRule> get(String selector) {
    return Optional.ofNullable(cssRules.get(selector));
  }

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
