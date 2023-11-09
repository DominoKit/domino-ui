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
import java.util.stream.Collectors;

/**
 * Represents a CSS rule that can be applied to HTML elements.
 *
 * <p>This class allows you to create and manage CSS rules with a specified selector and CSS class.
 * You can add, remove, or clear CSS properties associated with the rule and generate CSS text for
 * applying the rule.
 *
 * <p>Usage example:
 *
 * <pre>
 * DominoCSSRule cssRule = new DominoCSSRule(".my-selector", "my-css-class");
 * cssRule.setProperty("color", "blue");
 * cssRule.setProperty("font-size", "16px");
 * String cssText = cssRule.cssText(); // ".my-selector{color: blue; font-size: 16px;}"
 * </pre>
 */
public class DominoCSSRule {

  private final String selector;
  private final String cssClass;
  private Map<String, String> cssProperties = new HashMap<>();

  /**
   * Constructs a new DominoCSSRule with the specified selector and CSS class.
   *
   * @param selector The CSS selector for the rule, including any necessary HTML tags or IDs.
   * @param cssClass The CSS class to be applied to elements matching the selector.
   */
  public DominoCSSRule(String selector, String cssClass) {
    this.selector = selector;
    this.cssClass = cssClass;
  }

  /**
   * Gets the CSS selector associated with this rule.
   *
   * @return The CSS selector.
   */
  public String getSelector() {
    return selector;
  }

  /**
   * Gets the CSS class associated with this rule.
   *
   * @return The CSS class.
   */
  public String getCssClass() {
    return cssClass;
  }

  /**
   * Clears all CSS properties associated with this rule.
   *
   * @return This DominoCSSRule instance for method chaining.
   */
  public DominoCSSRule clear() {
    cssProperties.clear();
    return this;
  }

  /**
   * Sets a CSS property for this rule.
   *
   * @param key The name of the CSS property.
   * @param value The value to be assigned to the CSS property.
   * @return This DominoCSSRule instance for method chaining.
   */
  public DominoCSSRule setProperty(String key, String value) {
    cssProperties.put(key, value);
    return this;
  }

  /**
   * Removes a CSS property from this rule.
   *
   * @param key The name of the CSS property to be removed.
   * @return This DominoCSSRule instance for method chaining.
   */
  public DominoCSSRule removeProperty(String key) {
    cssProperties.remove(key);
    return this;
  }

  /**
   * Generates the CSS text for this rule, including all associated CSS properties.
   *
   * @return The CSS text representation of this rule.
   */
  public String cssText() {
    return selector
        + "{"
        + cssProperties.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue())
            .collect(Collectors.joining(";"))
        + "}";
  }
}
