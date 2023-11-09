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

import elemental2.svg.SVGSymbolElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGSymbolElement}, which represents an SVG symbol
 * element. The {@code SymbolElement} class allows you to work with symbol elements within the
 * Domino UI framework, making it easier to create and manipulate symbol elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGSymbolElement
 */
public class SymbolElement extends BaseElement<SVGSymbolElement, SymbolElement> {

  /**
   * Factory method for creating a new {@code SymbolElement} instance from an existing {@code
   * SVGSymbolElement}. This method provides a standardized way of wrapping {@code SVGSymbolElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGSymbolElement} to wrap
   * @return a new instance of {@code SymbolElement}
   */
  public static SymbolElement of(SVGSymbolElement e) {
    return new SymbolElement(e);
  }

  /**
   * Constructs a new {@code SymbolElement} by encapsulating the provided {@code SVGSymbolElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGSymbolElement} to be wrapped
   */
  public SymbolElement(SVGSymbolElement element) {
    super(element);
  }
}
