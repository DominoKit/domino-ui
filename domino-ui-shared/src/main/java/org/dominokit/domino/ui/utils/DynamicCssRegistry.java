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

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.dominokit.domino.ui.style.CssClass;

/**
 * Owns the document-global stylesheet used by {@link DynamicCss}.
 *
 * <p>The registry intentionally does not use {@link DynamicStyleSheet} or {@link DominoStyleSheet}.
 * Generated variables are scoped to {@code body.dui}, and generated utility selectors require the
 * {@code dui} class in addition to their generated class.
 */
final class DynamicCssRegistry {

  static final String STYLE_ELEMENT_ID = "dui-dynamic-css";
  private static final String VARIABLES_SELECTOR = "body.dui";
  private static DynamicCssRegistry instance;

  private final Map<String, CssClass> cssClasses = new HashMap<>();
  private final Map<String, String> variableValues = new HashMap<>();
  private final Map<String, String> tokenOwners = new HashMap<>();
  private final DynamicCssStyleSheet styleSheet;
  private boolean staticUtilitiesPreloaded;

  private DynamicCssRegistry() {
    this(new CssomDynamicCssStyleSheet());
  }

  DynamicCssRegistry(DynamicCssStyleSheet styleSheet) {
    this.styleSheet = styleSheet;
  }

  static DynamicCssRegistry get() {
    if (instance == null) {
      instance = new DynamicCssRegistry();
    }
    return instance;
  }

  static void reset() {
    instance = null;
  }

  CssClass cssClass(DynamicCssDefinition definition, String rawValue) {
    String definitionKey = definitionKey(definition);
    String requestKey = definitionKey + "\u0000" + rawValue;
    CssClass existing = cssClasses.get(requestKey);
    if (existing != null) {
      return existing;
    }

    CssClass staticUtility = StaticDynamicCssUtility.resolveStaticValue(this, definition, rawValue);
    if (staticUtility != null) {
      cssClasses.put(requestKey, staticUtility);
      return staticUtility;
    }

    if (referencesCssVariable(rawValue)) {
      String className = availableVariableExpressionClassName(definition, definitionKey, rawValue);
      ensureVariableExpressionRule(definition, className, rawValue);
      CssClass cssClass = () -> className;
      cssClasses.put(requestKey, cssClass);
      return cssClass;
    }

    String token = availableToken(definition, definitionKey, rawValue);
    String variableName = "--" + definition.getVariablePrefix() + "-" + token;
    String className = definition.getClassPrefix() + "-" + token;
    String selector = ".dui." + className;

    if (hasCompatibleRawValueRule(definition, selector, rawValue)) {
      CssClass cssClass = () -> className;
      cssClasses.put(requestKey, cssClass);
      return cssClass;
    }

    ensureVariable(variableName, rawValue);
    ensureUtilityRule(definition, className, variableName);

    CssClass cssClass = () -> className;
    cssClasses.put(requestKey, cssClass);
    return cssClass;
  }

  CssClass lazyCssClass(DynamicCssDefinition definition, String classToken, String cssValue) {
    return new LazyDynamicCssClass(() -> cssClass(definition, classToken, cssValue));
  }

  CssClass lazyCssClass(String staticClassName) {
    return StaticDynamicCssUtility.resolve(this, staticClassName);
  }

  void preloadStaticUtilities() {
    if (!staticUtilitiesPreloaded) {
      StaticDynamicCssUtility.preloadAll(this);
      staticUtilitiesPreloaded = true;
    }
  }

  private CssClass cssClass(DynamicCssDefinition definition, String classToken, String cssValue) {
    String definitionKey = definitionKey(definition);
    String requestKey = definitionKey + "\u0000canonical\u0000" + classToken;
    CssClass existing = cssClasses.get(requestKey);
    if (existing != null) {
      return existing;
    }

    String className = definition.getClassPrefix() + "-" + classToken;
    String selector = ".dui." + className;
    if (!hasCompatibleRawValueRule(definition, selector, cssValue)) {
      for (String property : definition.getCssProperties()) {
        styleSheet.setProperty(selector, property, cssValue);
      }
    }

    CssClass cssClass = () -> className;
    cssClasses.put(requestKey, cssClass);
    if (cssValue.equals("var(--" + definition.getVariablePrefix() + "-" + classToken + ")")) {
      cssClasses.putIfAbsent(definitionKey + "\u0000" + classToken, cssClass);
    }
    return cssClass;
  }

  private void ensureVariableExpressionRule(
      DynamicCssDefinition definition, String className, String expression) {
    String selector = ".dui." + className;
    if (!hasCompatibleRawValueRule(definition, selector, expression)) {
      for (String property : definition.getCssProperties()) {
        styleSheet.setProperty(selector, property, expression);
      }
    }
  }

  private void ensureVariable(String variableName, String rawValue) {
    if (!variableValues.containsKey(variableName)) {
      if (!styleSheet.hasProperty(variableName)) {
        styleSheet.setProperty(VARIABLES_SELECTOR, variableName, rawValue);
      }
      variableValues.put(variableName, rawValue);
    }
  }

  private void ensureUtilityRule(
      DynamicCssDefinition definition, String className, String variableName) {
    String selector = ".dui." + className;
    if (!hasCompatibleUtilityRule(definition, selector, variableName)) {
      for (String property : definition.getCssProperties()) {
        styleSheet.setProperty(selector, property, "var(" + variableName + ")");
      }
    }
  }

  private boolean hasCompatibleUtilityRule(
      DynamicCssDefinition definition, String selector, String variableName) {
    if (!styleSheet.hasRule(selector)) {
      return false;
    }
    String expectedValue = "var(" + variableName + ")";
    for (String property : definition.getCssProperties()) {
      if (!expectedValue.equals(styleSheet.getPropertyValue(selector, property))) {
        return false;
      }
    }
    return true;
  }

  private boolean hasCompatibleRawValueRule(
      DynamicCssDefinition definition, String selector, String value) {
    if (!styleSheet.hasRule(selector)) {
      return false;
    }
    for (String property : definition.getCssProperties()) {
      if (!value.equals(styleSheet.getPropertyValue(selector, property))) {
        return false;
      }
    }
    return true;
  }

  private String availableVariableExpressionClassName(
      DynamicCssDefinition definition, String definitionKey, String expression) {
    String baseClassName =
        definition.getClassPrefix() + "-var-" + hashToken(definitionKey, expression);
    String className = baseClassName;
    int suffix = 2;
    while (!isVariableExpressionClassAvailable(definition, className, expression)) {
      className = baseClassName + "-" + suffix++;
    }
    return className;
  }

  private boolean isVariableExpressionClassAvailable(
      DynamicCssDefinition definition, String className, String expression) {
    String selector = ".dui." + className;
    return !styleSheet.hasRule(selector)
        || hasCompatibleRawValueRule(definition, selector, expression);
  }

  private String availableToken(
      DynamicCssDefinition definition, String definitionKey, String rawValue) {
    String readableToken = readableToken(rawValue);
    String token = readableToken == null ? fallbackToken(definitionKey, rawValue) : readableToken;
    int suffix = 2;
    while (!isAvailable(definition, token, rawValue)) {
      token = fallbackToken(definitionKey, rawValue) + "-" + suffix++;
    }
    String tokenKey = definitionKey + "\u0000" + token;
    String owner = tokenOwners.get(tokenKey);
    while ((owner != null && !Objects.equals(owner, rawValue))
        || !isAvailable(definition, token, rawValue)) {
      token = fallbackToken(definitionKey, rawValue) + "-" + suffix++;
      tokenKey = definitionKey + "\u0000" + token;
      owner = tokenOwners.get(tokenKey);
    }
    tokenOwners.put(tokenKey, rawValue);
    return token;
  }

  private boolean isAvailable(DynamicCssDefinition definition, String token, String rawValue) {
    String selector = ".dui." + definition.getClassPrefix() + "-" + token;
    String variableName = "--" + definition.getVariablePrefix() + "-" + token;
    return !styleSheet.hasRule(selector)
        || hasCompatibleUtilityRule(definition, selector, variableName)
        || hasCompatibleRawValueRule(definition, selector, rawValue);
  }

  private String readableToken(String rawValue) {
    if (rawValue != null && rawValue.matches("[A-Za-z0-9_-]+")) {
      return rawValue;
    }
    if (rawValue != null && rawValue.matches("[A-Za-z0-9_-]*\\.[A-Za-z0-9_-]+")) {
      return rawValue.replace('.', '_');
    }
    return null;
  }

  private String fallbackToken(String definitionKey, String rawValue) {
    return "dyn-" + hashToken(definitionKey, rawValue);
  }

  private String hashToken(String definitionKey, String rawValue) {
    String token = Integer.toString((definitionKey + "\u0000" + rawValue).hashCode(), 36);
    return token.replace('-', 'n');
  }

  private boolean referencesCssVariable(String rawValue) {
    return rawValue != null && rawValue.contains("var(");
  }

  private String definitionKey(DynamicCssDefinition definition) {
    return definition.getClassPrefix()
        + "\u0000"
        + definition.getVariablePrefix()
        + "\u0000"
        + String.join("\u0000", definition.getCssProperties());
  }
}
