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

import elemental2.svg.SVGTextPathElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTextPathElement}, which represents an SVG text
 * path element. The {@code TextPathElement} class allows you to work with text path elements within
 * the Domino UI framework, making it easier to create and manipulate text paths in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTextPathElement
 */
public class TextPathElement extends BaseElement<SVGTextPathElement, TextPathElement> {

  /**
   * Factory method for creating a new {@code TextPathElement} instance from an existing {@code
   * SVGTextPathElement}. This method provides a standardized way of wrapping {@code
   * SVGTextPathElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGTextPathElement} to wrap
   * @return a new instance of {@code TextPathElement}
   */
  public static TextPathElement of(SVGTextPathElement e) {
    return new TextPathElement(e);
  }

  /**
   * Constructs a new {@code TextPathElement} by encapsulating the provided {@code
   * SVGTextPathElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTextPathElement} to be wrapped
   */
  public TextPathElement(SVGTextPathElement element) {
    super(element);
  }
}
