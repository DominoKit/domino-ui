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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Describes a family of document-global dynamic CSS utilities.
 *
 * <p>A definition supplies the generated utility-class prefix, custom-property prefix, and the CSS
 * properties that consume the generated custom property. It does not validate or transform a
 * caller-provided CSS value.
 */
public final class DynamicCssDefinition {

  private final String classPrefix;
  private final String variablePrefix;
  private final List<String> cssProperties;

  private DynamicCssDefinition(
      String classPrefix, String variablePrefix, List<String> cssProperties) {
    this.classPrefix = classPrefix;
    this.variablePrefix = variablePrefix;
    this.cssProperties = cssProperties;
  }

  /**
   * Creates a definition for a dynamic CSS utility family.
   *
   * @param classPrefix the generated class prefix, for example {@code dui-p}
   * @param variablePrefix the generated custom-property prefix, for example {@code dui-spc}
   * @param cssProperties the CSS properties that reference the generated custom property
   * @return a new immutable dynamic CSS definition
   */
  public static DynamicCssDefinition of(
      String classPrefix, String variablePrefix, String... cssProperties) {
    return new DynamicCssDefinition(
        classPrefix,
        variablePrefix,
        Collections.unmodifiableList(new ArrayList<>(Arrays.asList(cssProperties))));
  }

  /**
   * Gets the generated CSS class prefix.
   *
   * @return the CSS class prefix
   */
  public String getClassPrefix() {
    return classPrefix;
  }

  /**
   * Gets the generated CSS custom-property prefix.
   *
   * @return the custom-property prefix
   */
  public String getVariablePrefix() {
    return variablePrefix;
  }

  /**
   * Gets the immutable CSS properties that consume the generated custom property.
   *
   * @return the CSS property names
   */
  public List<String> getCssProperties() {
    return cssProperties;
  }
}
