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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jsinterop.base.Js;
import jsinterop.base.JsPropertyMap;

/** CSSOM-backed stylesheet for document-global dynamic CSS utilities. */
final class CssomDynamicCssStyleSheet implements DynamicCssStyleSheet {

  private CSSStyleSheet styleSheet;
  private final Map<String, CSSStyleRule> ownedRules = new HashMap<>();
  private final Map<String, Map<String, String>> ownedPropertyValues = new HashMap<>();
  private boolean ownedRulesIndexed;
  private final Map<String, List<CSSStyleRule>> accessibleRules = new HashMap<>();
  private final Map<String, Set<CSSStyleRule>> accessiblePropertyRules = new HashMap<>();
  private long indexedStyleSheetFingerprint = Long.MIN_VALUE;

  @Override
  public boolean hasRule(String selector) {
    if (findOwnedRule(selector) != null) {
      return true;
    }
    return findAccessibleRule(selector) != null;
  }

  @Override
  public String getPropertyValue(String selector, String property) {
    CSSStyleRule ownedRule = findOwnedRule(selector);
    if (ownedRule != null) {
      Map<String, String> values = ownedPropertyValues.get(selector);
      if (values != null && values.containsKey(property)) {
        return values.get(property);
      }
      String value = ownedRule.style.getPropertyValue(property);
      cachePropertyValue(selector, property, value);
      return value;
    }

    List<CSSStyleRule> rules = accessibleRules(selector);
    if (rules != null) {
      for (CSSStyleRule rule : rules) {
        String value = rule.style.getPropertyValue(property);
        if (!value.isEmpty()) {
          return value;
        }
      }
    }
    return "";
  }

  @Override
  public boolean hasProperty(String property) {
    indexAccessibleRules();
    Set<CSSStyleRule> rulesWithProperty = accessiblePropertyRules.get(property);
    if (rulesWithProperty != null) {
      java.util.Iterator<CSSStyleRule> iterator = rulesWithProperty.iterator();
      while (iterator.hasNext()) {
        if (!iterator.next().style.getPropertyValue(property).isEmpty()) {
          return true;
        }
        iterator.remove();
      }
      accessiblePropertyRules.remove(property);
    }
    for (List<CSSStyleRule> rules : accessibleRules.values()) {
      for (CSSStyleRule rule : rules) {
        if (!rule.style.getPropertyValue(property).isEmpty()) {
          accessiblePropertyRules.computeIfAbsent(property, ignored -> new HashSet<>()).add(rule);
          return true;
        }
      }
    }
    return false;
  }

  private void indexAccessibleRules() {
    StyleSheetList styleSheets = styleSheets();
    long fingerprint = styleSheetFingerprint(styleSheets);
    if (indexedStyleSheetFingerprint == fingerprint) {
      return;
    }
    accessibleRules.clear();
    accessiblePropertyRules.clear();
    for (int index = 0; index < styleSheets.length; index++) {
      try {
        CSSStyleSheet styleSheet = Js.uncheckedCast(styleSheets.item(index));
        if (isOwnedStyleSheet(styleSheet)) {
          continue;
        }
        for (int ruleIndex = 0; ruleIndex < styleSheet.cssRules.length; ruleIndex++) {
          CSSRule rule = styleSheet.cssRules.item(ruleIndex);
          if (rule.type == CSSRule.STYLE_RULE) {
            CSSStyleRule styleRule = Js.uncheckedCast(rule);
            for (int propertyIndex = 0; propertyIndex < styleRule.style.length; propertyIndex++) {
              accessiblePropertyRules
                  .computeIfAbsent(styleRule.style.item(propertyIndex), ignored -> new HashSet<>())
                  .add(styleRule);
            }
            for (String selector : styleRule.selectorText.split(",")) {
              accessibleRules
                  .computeIfAbsent(selector.trim(), ignored -> new ArrayList<>())
                  .add(styleRule);
            }
          }
        }
      } catch (RuntimeException ignored) {
        // Cross-origin stylesheets may be unreadable. This adapter never modifies them.
      }
    }
    indexedStyleSheetFingerprint = fingerprint;
  }

  private long styleSheetFingerprint(StyleSheetList styleSheets) {
    long fingerprint = styleSheets.length;
    for (int index = 0; index < styleSheets.length; index++) {
      try {
        CSSStyleSheet sheet = Js.uncheckedCast(styleSheets.item(index));
        if (!isOwnedStyleSheet(sheet)) {
          fingerprint = 31 * fingerprint + sheet.cssRules.length;
        }
      } catch (RuntimeException ignored) {
        // Keep inaccessible cross-origin sheets in the fingerprint without reading their rules.
        fingerprint = 31 * fingerprint + 1;
      }
    }
    return fingerprint;
  }

  private boolean isOwnedStyleSheet(CSSStyleSheet sheet) {
    if (sheet.ownerNode == null) {
      return false;
    }
    String id = Js.<JsPropertyMap<String>>uncheckedCast(sheet.ownerNode).get("id");
    return DynamicCssRegistry.STYLE_ELEMENT_ID.equals(id);
  }

  private List<CSSStyleRule> accessibleRules(String selector) {
    indexAccessibleRules();
    return accessibleRules.get(selector);
  }

  @Override
  public void setProperty(String selector, String property, String value) {
    CSSStyleRule rule = findOwnedRule(selector);
    if (rule == null) {
      rule = insertRule(selector);
    }
    rule.style.setProperty(property, value);
    cachePropertyValue(selector, property, value);
  }

  @Override
  public void setProperties(String selector, Map<String, String> properties) {
    CSSStyleRule rule = findOwnedRule(selector);
    if (rule == null) {
      rule = insertRule(selector);
    }
    CSSStyleRule ownedRule = rule;
    properties.forEach(
        (property, value) -> {
          ownedRule.style.setProperty(property, value);
          cachePropertyValue(selector, property, value);
        });
  }

  private CSSStyleRule findAccessibleRule(String selector) {
    CSSStyleRule ownedRule = findOwnedRule(selector);
    if (ownedRule != null) {
      return ownedRule;
    }
    List<CSSStyleRule> rules = accessibleRules(selector);
    return rules == null || rules.isEmpty() ? null : rules.get(0);
  }

  private CSSStyleRule findOwnedRule(String selector) {
    indexOwnedRules();
    return ownedRules.get(selector);
  }

  private void indexOwnedRules() {
    if (ownedRulesIndexed) {
      return;
    }
    CSSStyleSheet sheet = styleSheet();
    for (int index = 0; index < sheet.cssRules.length; index++) {
      CSSRule rule = sheet.cssRules.item(index);
      if (rule.type == CSSRule.STYLE_RULE) {
        CSSStyleRule styleRule = Js.uncheckedCast(rule);
        for (String selector : styleRule.selectorText.split(",")) {
          ownedRules.put(selector.trim(), styleRule);
        }
      }
    }
    ownedRulesIndexed = true;
  }

  private void cachePropertyValue(String selector, String property, String value) {
    Map<String, String> values = ownedPropertyValues.get(selector);
    if (values == null) {
      values = new HashMap<>();
      ownedPropertyValues.put(selector, values);
    }
    values.put(property, value);
  }

  private CSSStyleRule insertRule(String selector) {
    CSSStyleSheet styleSheet = styleSheet();
    int index = styleSheet.insertRule(selector + " {}", styleSheet.cssRules.length);
    CSSStyleRule rule = Js.uncheckedCast(styleSheet.cssRules.item(index));
    ownedRules.put(selector, rule);
    return rule;
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
