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

@Deprecated
public class DominoCSSRule {

  private final String selector;
  private final String cssClass;
  private Map<String, String> cssProperties = new HashMap<>();

  public DominoCSSRule(String selector, String cssClass) {
    this.selector = selector;
    this.cssClass = cssClass;
  }

  public String getSelector() {
    return selector;
  }

  public String getCssClass() {
    return cssClass;
  }

  public DominoCSSRule clear() {
    cssProperties.clear();
    return this;
  }

  public DominoCSSRule setProperty(String key, String value) {
    cssProperties.put(key, value);
    return this;
  }

  public DominoCSSRule removeProperty(String key) {
    cssProperties.remove(key);
    return this;
  }

  public String cssText() {
    return selector
        + "{"
        + cssProperties.entrySet().stream()
            .map(entry -> entry.getKey() + ": " + entry.getValue())
            .collect(Collectors.joining(";"))
        + "}";
  }
}
