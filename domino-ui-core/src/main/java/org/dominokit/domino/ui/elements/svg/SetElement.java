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

import elemental2.svg.SVGSetElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGSetElement}, which represents an SVG set element.
 * The {@code SetElement} class allows you to work with set elements within the Domino UI framework,
 * making it easier to create and manipulate set elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGSetElement
 */
public class SetElement extends BaseElement<SVGSetElement, SetElement> {

  /**
   * Factory method for creating a new {@code SetElement} instance from an existing {@code
   * SVGSetElement}. This method provides a standardized way of wrapping {@code SVGSetElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGSetElement} to wrap
   * @return a new instance of {@code SetElement}
   */
  public static SetElement of(SVGSetElement e) {
    return new SetElement(e);
  }

  /**
   * Constructs a new {@code SetElement} by encapsulating the provided {@code SVGSetElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGSetElement} to be wrapped
   */
  public SetElement(SVGSetElement element) {
    super(element);
  }
}
