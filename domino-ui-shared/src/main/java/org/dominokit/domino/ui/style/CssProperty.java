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

package org.dominokit.domino.ui.style;

import elemental2.dom.Element;

/**
 * Represents a single CSS property which consists of a name and its associated value. The property
 * can be applied or removed from a DOM {@link Element}.
 */
public class CssProperty implements IsCssProperty {

  /** The name of the CSS property */
  private final String name;

  /** The value of the CSS property */
  private final String value;

  /**
   * Creates a new {@link CssProperty} instance with the specified name and value.
   *
   * @param name The name of the CSS property.
   * @param value The value of the CSS property.
   * @return A new {@link CssProperty} instance.
   */
  public static CssProperty of(String name, String value) {
    return new CssProperty(name, value);
  }

  /**
   * Constructs a {@link CssProperty} with a specified name and value.
   *
   * @param name The name of the CSS property.
   * @param value The value of the CSS property.
   */
  private CssProperty(String name, String value) {
    this.name = name;
    this.value = value;
  }

  /**
   * Returns the name of the CSS property.
   *
   * @return The name of the CSS property.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the value of the CSS property.
   *
   * @return The value of the CSS property.
   */
  public String getValue() {
    return value;
  }

  /**
   * Applies this CSS property to the specified DOM {@link Element}.
   *
   * @param element The DOM element to which the CSS property will be applied.
   */
  public void apply(Element element) {
    Style.of(element).setCssProperty(name, value);
  }

  /**
   * Removes this CSS property from the specified DOM {@link Element}.
   *
   * @param element The DOM element from which the CSS property will be removed.
   */
  @Override
  public void remove(Element element) {
    Style.of(element).removeCssProperty(name);
  }
}
