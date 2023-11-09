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
package org.dominokit.domino.ui.elements.svg;

import elemental2.svg.SVGFilterElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGFilterElement}, associated with the {@code <filter>} SVG
 * element. This container element is used to define a filter that can be applied to SVG elements,
 * thereby producing a range of graphical effects. Extending {@link BaseElement}, {@code
 * FilterElement} provides a straightforward interface for creating and managing SVG filters within
 * the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFilterElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/filter">MDN Web Docs -
 *     SVGFilterElement</a>
 */
public class FilterElement extends BaseElement<SVGFilterElement, FilterElement> {

  /**
   * Factory method for creating a new {@code FilterElement} instance from an existing {@code
   * SVGFilterElement}. This method simplifies the instantiation process and is the recommended
   * approach for constructing {@code FilterElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGFilterElement} to wrap
   * @return a new instance of {@code FilterElement}
   */
  public static FilterElement of(SVGFilterElement e) {
    return new FilterElement(e);
  }

  /**
   * Constructs a new {@code FilterElement} by wrapping the provided {@code SVGFilterElement}. This
   * constructor is protected to promote the use of the static factory method {@code of()} for
   * creating new instances, ensuring a consistent method for object creation across the framework.
   *
   * @param element the {@code SVGFilterElement} to be wrapped
   */
  public FilterElement(SVGFilterElement element) {
    super(element);
  }
}
