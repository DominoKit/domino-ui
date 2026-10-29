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

import elemental2.svg.SVGStyleElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGStyleElement}, which represents an SVG style
 * element. The {@code StyleElement} class allows you to work with style elements within the Domino
 * UI framework, making it easier to create and manipulate style elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGStyleElement
 */
public class StyleElement extends BaseElement<SVGStyleElement, StyleElement> {

  /**
   * Factory method for creating a new {@code StyleElement} instance from an existing {@code
   * SVGStyleElement}. This method provides a standardized way of wrapping {@code SVGStyleElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGStyleElement} to wrap
   * @return a new instance of {@code StyleElement}
   */
  public static StyleElement of(SVGStyleElement e) {
    return new StyleElement(e);
  }

  /**
   * Constructs a new {@code StyleElement} by encapsulating the provided {@code SVGStyleElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGStyleElement} to be wrapped
   */
  public StyleElement(SVGStyleElement element) {
    super(element);
  }
}
