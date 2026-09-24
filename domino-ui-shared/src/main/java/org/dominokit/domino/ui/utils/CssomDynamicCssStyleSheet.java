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
import elemental2.dom.CSSStyleRule;
import elemental2.dom.CSSStyleSheet;
import elemental2.dom.HTMLStyleElement;
import elemental2.dom.StyleSheetList;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/** CSSOM-backed stylesheet for document-global dynamic CSS utilities. */
final class CssomDynamicCssStyleSheet implements DynamicCssStyleSheet {

  private CSSStyleSheet styleSheet;

  @Override
  public boolean hasRule(String selector) {
    return findAccessibleRule(selector) != null;
  }

  @Override
  public String getPropertyValue(String selector, String property) {
    StyleSheetList styleSheets = styleSheets();
    for (int index = 0; index < styleSheets.length; index++) {
      try {
        CSSStyleRule rule = findRule(Js.uncheckedCast(styleSheets.item(index)), selector);
        if (rule != null) {
          String value = rule.style.getPropertyValue(property);
          if (!value.isEmpty()) {
            return value;
          }
        }
      } catch (RuntimeException ignored) {
        // Cross-origin stylesheets may be unreadable. This adapter never modifies them.
      }
    }
    return "";
  }

  @Override
  public boolean hasProperty(String property) {
    StyleSheetList styleSheets = styleSheets();
    for (int index = 0; index < styleSheets.length; index++) {
      try {
        CSSStyleSheet styleSheet = Js.uncheckedCast(styleSheets.item(index));
        for (int ruleIndex = 0; ruleIndex < styleSheet.cssRules.length; ruleIndex++) {
          CSSRule rule = styleSheet.cssRules.item(ruleIndex);
          if (rule.type == CSSRule.STYLE_RULE) {
            CSSStyleRule styleRule = Js.uncheckedCast(rule);
            if (!styleRule.style.getPropertyValue(property).isEmpty()) {
              return true;
            }
          }
        }
      } catch (RuntimeException ignored) {
        // Cross-origin stylesheets may be unreadable. This adapter never modifies them.
      }
    }
    return false;
  }

  @Override
  public void setProperty(String selector, String property, String value) {
    CSSStyleRule rule = findOwnedRule(selector);
    if (rule == null) {
      rule = insertRule(selector);
    }
    rule.style.setProperty(property, value);
  }

  private CSSStyleRule findAccessibleRule(String selector) {
    StyleSheetList styleSheets = styleSheets();
    for (int index = 0; index < styleSheets.length; index++) {
      try {
        CSSStyleRule rule = findRule(Js.uncheckedCast(styleSheets.item(index)), selector);
        if (rule != null) {
          return rule;
        }
      } catch (RuntimeException ignored) {
        // Cross-origin stylesheets may be unreadable. This adapter never modifies them.
      }
    }
    return null;
  }

  private CSSStyleRule findOwnedRule(String selector) {
    return findRule(styleSheet(), selector);
  }

  private CSSStyleRule findRule(CSSStyleSheet styleSheet, String selector) {
    for (int index = 0; index < styleSheet.cssRules.length; index++) {
      CSSRule rule = styleSheet.cssRules.item(index);
      if (rule.type == CSSRule.STYLE_RULE) {
        CSSStyleRule styleRule = Js.uncheckedCast(rule);
        if (matchesSelector(styleRule.selectorText, selector)) {
          return styleRule;
        }
      }
    }
    return null;
  }

  private boolean matchesSelector(String selectorText, String selector) {
    for (String candidate : selectorText.split(",")) {
      if (selector.equals(candidate.trim())) {
        return true;
      }
    }
    return false;
  }

  private CSSStyleRule insertRule(String selector) {
    CSSStyleSheet styleSheet = styleSheet();
    int index = styleSheet.insertRule(selector + " {}", styleSheet.cssRules.length);
    return Js.uncheckedCast(styleSheet.cssRules.item(index));
  }

  private CSSStyleSheet styleSheet() {
    if (styleSheet == null) {
      HTMLStyleElement styleElement =
          Js.uncheckedCast(document.getElementById(DynamicCssRegistry.STYLE_ELEMENT_ID));
      if (styleElement == null) {
        styleElement = Js.uncheckedCast(document.createElement("style"));
        styleElement.id = DynamicCssRegistry.STYLE_ELEMENT_ID;
        styleElement.type = "text/css";
        document.head.appendChild(styleElement);
      }
      styleSheet = Js.uncheckedCast(styleElement.sheet);
    }
    return styleSheet;
  }

  private StyleSheetList styleSheets() {
    return Js.uncheckedCast(Js.<JsPropertyMap<Object>>uncheckedCast(document).get("styleSheets"));
  }
}
