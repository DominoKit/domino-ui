/*
 * Copyright © 2026 Dominokit
 * Licensed under the Apache License, Version 2.0.
 */
package org.dominokit.domino.ui.utils;

import static elemental2.dom.DomGlobal.document;

import elemental2.dom.CSSRule;
import elemental2.dom.CSSStyleRule;
import elemental2.dom.CSSStyleSheet;
import elemental2.dom.HTMLStyleElement;
import jsinterop.base.Js;

final class CssomDynamicColorStyleSheet implements DynamicColorStyleSheet {
  private CSSStyleSheet styleSheet;

  @Override
  public boolean hasRule(String selector) {
    return findRule(styleSheet(), selector) != null;
  }

  @Override
  public String getPropertyValue(String selector, String property) {
    CSSStyleRule rule = findRule(styleSheet(), selector);
    return rule == null ? "" : rule.style.getPropertyValue(property);
  }

  @Override
  public void setProperty(String selector, String property, String value) {
    CSSStyleRule rule = findRule(styleSheet(), selector);
    if (rule == null) {
      int index = styleSheet().insertRule(selector + " {}", styleSheet().cssRules.length);
      rule = Js.uncheckedCast(styleSheet().cssRules.item(index));
    }
    rule.style.setProperty(property, value);
  }

  private CSSStyleRule findRule(CSSStyleSheet sheet, String selector) {
    for (int index = 0; index < sheet.cssRules.length; index++) {
      CSSRule rule = sheet.cssRules.item(index);
      if (rule.type == CSSRule.STYLE_RULE) {
        CSSStyleRule styleRule = Js.uncheckedCast(rule);
        if (selector.equals(styleRule.selectorText)) return styleRule;
      }
    }
    return null;
  }

  private CSSStyleSheet styleSheet() {
    if (styleSheet == null) {
      HTMLStyleElement element =
          Js.uncheckedCast(document.getElementById(DynamicColorRegistry.STYLE_ELEMENT_ID));
      if (element == null) {
        element = Js.uncheckedCast(document.createElement("style"));
        element.id = DynamicColorRegistry.STYLE_ELEMENT_ID;
        element.type = "text/css";
        document.head.appendChild(element);
      }
      styleSheet = Js.uncheckedCast(element.sheet);
    }
    return styleSheet;
  }
}
