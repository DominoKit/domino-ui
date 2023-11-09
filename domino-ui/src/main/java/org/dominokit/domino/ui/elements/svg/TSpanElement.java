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

import elemental2.svg.SVGTSpanElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTSpanElement}, which represents an SVG tspan
 * element. The {@code TSpanElement} class allows you to work with tspan elements within the Domino
 * UI framework, making it easier to create and manipulate tspan elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTSpanElement
 */
public class TSpanElement extends BaseElement<SVGTSpanElement, TSpanElement> {

  /**
   * Factory method for creating a new {@code TSpanElement} instance from an existing {@code
   * SVGTSpanElement}. This method provides a standardized way of wrapping {@code SVGTSpanElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGTSpanElement} to wrap
   * @return a new instance of {@code TSpanElement}
   */
  public static TSpanElement of(SVGTSpanElement e) {
    return new TSpanElement(e);
  }

  /**
   * Constructs a new {@code TSpanElement} by encapsulating the provided {@code SVGTSpanElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTSpanElement} to be wrapped
   */
  public TSpanElement(SVGTSpanElement element) {
    super(element);
  }
}
