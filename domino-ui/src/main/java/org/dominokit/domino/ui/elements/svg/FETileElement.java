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

import elemental2.svg.SVGFETileElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that provides a wrapper for the {@link SVGFETileElement}, which corresponds to the {@code
 * <feTile>} SVG element. This filter primitive creates a pattern of tiles replicating the input
 * image. It extends {@link BaseElement}, providing a convenient API to apply tiling effects within
 * SVG graphics as part of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFETileElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feTile">MDN Web Docs -
 *     SVGFETileElement</a>
 */
public class FETileElement extends BaseElement<SVGFETileElement, FETileElement> {

  /**
   * Factory method for creating a new {@code FETileElement} instance from a provided {@code
   * SVGFETileElement}. This method abstracts the direct creation of objects, facilitating a
   * standardized way to instantiate {@code FETileElement} within the Domino UI framework.
   *
   * @param e the {@code SVGFETileElement} to wrap
   * @return a new instance of {@code FETileElement}
   */
  public static FETileElement of(SVGFETileElement e) {
    return new FETileElement(e);
  }

  /**
   * Constructs a new {@code FETileElement} by encapsulating the specified {@code SVGFETileElement}.
   * This constructor is protected to encourage the use of the static factory method {@code of()}
   * for creating new instances, promoting consistency and maintainability in object creation within
   * the framework.
   *
   * @param element the {@code SVGFETileElement} to be wrapped
   */
  public FETileElement(SVGFETileElement element) {
    super(element);
  }
}
