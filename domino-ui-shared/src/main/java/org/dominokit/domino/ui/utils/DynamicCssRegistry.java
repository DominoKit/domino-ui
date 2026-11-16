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
import java.util.Iterator;
import java.util.LinkedHashMap;
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
  static final int SYNC_DECLARATION_BUDGET = 128;
  static final int FRAME_DECLARATION_BUDGET = 256;
  private static final String VARIABLES_SELECTOR = "body.dui";
  private static DynamicCssRegistry instance;

  private final Map<String, CssClass> cssClasses = new HashMap<>();
  private final Map<String, String> variableValues = new HashMap<>();
  private final Map<String, String> tokenOwners = new HashMap<>();
  private final DynamicCssStyleSheet styleSheet;
  private final DynamicCssFrameScheduler frameScheduler;
  private final Map<String, LinkedHashMap<String, String>> pendingDeclarations =
      new LinkedHashMap<>();
  private int synchronousDeclarations;
  private boolean frameCallbackScheduled;
  private boolean staticUtilitiesPreloaded;

  private DynamicCssRegistry() {
    this(new CssomDynamicCssStyleSheet(), DynamicCssFrameScheduler.browser());
  }

  DynamicCssRegistry(DynamicCssStyleSheet styleSheet) {
    this(styleSheet, DynamicCssFrameScheduler.browser());
  }

  DynamicCssRegistry(DynamicCssStyleSheet styleSheet, DynamicCssFrameScheduler frameScheduler) {
    this.styleSheet = styleSheet;
    this.frameScheduler = frameScheduler;
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
    String selector = classSelector(className);

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

  void setProperty(String selector, String property, String value) {
    LinkedHashMap<String, String> pendingForSelector = pendingDeclarations.get(selector);
    if (pendingForSelector != null && pendingForSelector.containsKey(property)) {
      pendingForSelector.put(property, value);
      return;
    }
    if (value.equals(styleSheet.getPropertyValue(selector, property))) {
      return;
    }
    if (synchronousDeclarations < SYNC_DECLARATION_BUDGET) {
      styleSheet.setProperty(selector, property, value);
      synchronousDeclarations++;
      scheduleFrame();
      return;
    }
    if (pendingForSelector == null) {
      pendingForSelector = new LinkedHashMap<>();
      pendingDeclarations.put(selector, pendingForSelector);
    }
    pendingForSelector.put(property, value);
    scheduleFrame();
  }

  void setProperties(String selector, Map<String, String> properties) {
    Map<String, String> applyNow = new LinkedHashMap<>();
    LinkedHashMap<String, String> pendingForSelector = pendingDeclarations.get(selector);
    for (Map.Entry<String, String> entry : properties.entrySet()) {
      String property = entry.getKey();
      String value = entry.getValue();
      if (pendingForSelector != null && pendingForSelector.containsKey(property)) {
        pendingForSelector.put(property, value);
        continue;
      }
      if (value.equals(styleSheet.getPropertyValue(selector, property))) {
        continue;
      }
      if (synchronousDeclarations < SYNC_DECLARATION_BUDGET) {
        applyNow.put(property, value);
        synchronousDeclarations++;
      } else {
        if (pendingForSelector == null) {
          pendingForSelector = new LinkedHashMap<>();
          pendingDeclarations.put(selector, pendingForSelector);
        }
        pendingForSelector.put(property, value);
      }
    }
    if (!applyNow.isEmpty()) {
      styleSheet.setProperties(selector, applyNow);
      scheduleFrame();
    }
    if (pendingForSelector != null) {
      scheduleFrame();
    }
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
    String selector = classSelector(className);
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
    String selector = classSelector(className);
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
    String selector = classSelector(className);
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
    String selector = classSelector(className);
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
    String selector = classSelector(definition.getClassPrefix() + "-" + token);
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

  private String classSelector(String className) {
    return ".dui." + className.replace(".", "\\.");
  }

  private void scheduleFrame() {
    if (!frameCallbackScheduled) {
      frameCallbackScheduled = true;
      frameScheduler.scheduleFrame(this::onFrame);
    }
  }

  private void onFrame() {
    frameCallbackScheduled = false;
    synchronousDeclarations = 0;
    flushPendingDeclarations();
    if (pendingDeclarations.isEmpty()) {
      synchronousDeclarations = 0;
    } else {
      scheduleFrame();
    }
  }

  private void flushPendingDeclarations() {
    int processed = 0;
    Iterator<Map.Entry<String, LinkedHashMap<String, String>>> selectors =
        pendingDeclarations.entrySet().iterator();
    while (selectors.hasNext() && processed < FRAME_DECLARATION_BUDGET) {
      Map.Entry<String, LinkedHashMap<String, String>> selectorEntry = selectors.next();
      String selector = selectorEntry.getKey();
      LinkedHashMap<String, String> pendingForSelector = selectorEntry.getValue();
      Iterator<Map.Entry<String, String>> properties = pendingForSelector.entrySet().iterator();
      Map<String, String> applyForSelector = new LinkedHashMap<>();
      while (properties.hasNext() && processed < FRAME_DECLARATION_BUDGET) {
        Map.Entry<String, String> propertyEntry = properties.next();
        String property = propertyEntry.getKey();
        String value = propertyEntry.getValue();
        properties.remove();
        processed++;
        if (!value.equals(styleSheet.getPropertyValue(selector, property))) {
          applyForSelector.put(property, value);
        }
      }
      if (!applyForSelector.isEmpty()) {
        styleSheet.setProperties(selector, applyForSelector);
      }
      if (pendingForSelector.isEmpty()) {
        selectors.remove();
      }
    }

    synchronousDeclarations += processed;
  }

}
