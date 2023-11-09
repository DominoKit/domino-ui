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

import elemental2.svg.SVGTitleElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTitleElement}, which represents an SVG title
 * element. The {@code TitleElement} class allows you to work with title elements within the Domino
 * UI framework, making it easier to create and manipulate titles in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTitleElement
 */
public class TitleElement extends BaseElement<SVGTitleElement, TitleElement> {

  /**
   * Factory method for creating a new {@code TitleElement} instance from an existing {@code
   * SVGTitleElement}. This method provides a standardized way of wrapping {@code SVGTitleElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGTitleElement} to wrap
   * @return a new instance of {@code TitleElement}
   */
  public static TitleElement of(SVGTitleElement e) {
    return new TitleElement(e);
  }

  /**
   * Constructs a new {@code TitleElement} by encapsulating the provided {@code SVGTitleElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTitleElement} to be wrapped
   */
  public TitleElement(SVGTitleElement element) {
    super(element);
  }
}
