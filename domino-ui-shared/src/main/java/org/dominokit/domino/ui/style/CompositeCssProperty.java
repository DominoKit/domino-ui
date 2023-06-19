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

public class CompositeCssProperty implements IsCssProperty {

  private Set<CssProperty> cssProperties = new HashSet<>();

  public static CompositeCssProperty of(Collection<CssProperty> cssProperties) {
    return new CompositeCssProperty(cssProperties);
  }

  public static CompositeCssProperty of(CssProperty... cssProperties) {
    return new CompositeCssProperty(cssProperties);
  }

  public CompositeCssProperty(Collection<CssProperty> cssProperties) {
    this.cssProperties.addAll(cssProperties);
  }

  public CompositeCssProperty(CssProperty... cssProperties) {
    this(Arrays.asList(cssProperties));
  }

  @Override
  public void apply(Element element) {
    cssProperties.forEach(cssProperty -> cssProperty.apply(element));
  }

  @Override
  public void remove(Element element) {
    cssProperties.forEach(cssProperty -> cssProperty.remove(element));
  }
}
