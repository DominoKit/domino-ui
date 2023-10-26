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
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a composite of multiple CSS properties. This enables applying or removing multiple CSS
 * properties on a DOM {@link Element} in a single operation.
 */
public class CompositeCssProperty implements IsCssProperty {

  /** A set containing all the CSS properties of this composite */
  private Set<CssProperty> cssProperties = new HashSet<>();

  /**
   * Creates a new {@link CompositeCssProperty} instance with the specified collection of CSS
   * properties.
   *
   * @param cssProperties A collection of {@link CssProperty} objects.
   * @return A new {@link CompositeCssProperty} instance.
   */
  public static CompositeCssProperty of(Collection<CssProperty> cssProperties) {
    return new CompositeCssProperty(cssProperties);
  }

  /**
   * Creates a new {@link CompositeCssProperty} instance with the specified CSS properties.
   *
   * @param cssProperties The CSS properties to include in the composite.
   * @return A new {@link CompositeCssProperty} instance.
   */
  public static CompositeCssProperty of(CssProperty... cssProperties) {
    return new CompositeCssProperty(cssProperties);
  }

  /**
   * Constructs a {@link CompositeCssProperty} with a collection of CSS properties.
   *
   * @param cssProperties A collection of {@link CssProperty} objects to include in the composite.
   */
  public CompositeCssProperty(Collection<CssProperty> cssProperties) {
    this.cssProperties.addAll(cssProperties);
  }

  /**
   * Constructs a {@link CompositeCssProperty} with the specified CSS properties.
   *
   * @param cssProperties The CSS properties to include in the composite.
   */
  public CompositeCssProperty(CssProperty... cssProperties) {
    this(Arrays.asList(cssProperties));
  }

  /**
   * Applies all CSS properties of this composite to the specified DOM {@link Element}.
   *
   * @param element The DOM element to which the composite of CSS properties will be applied.
   */
  @Override
  public void apply(Element element) {
    cssProperties.forEach(cssProperty -> cssProperty.apply(element));
  }

  /**
   * Removes all CSS properties of this composite from the specified DOM {@link Element}.
   *
   * @param element The DOM element from which the composite of CSS properties will be removed.
   */
  @Override
  public void remove(Element element) {
    cssProperties.forEach(cssProperty -> cssProperty.remove(element));
  }
}
