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

import elemental2.svg.SVGTextPositioningElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTextPositioningElement}, which represents an SVG
 * text positioning element. The {@code TextPositioningElement} class allows you to work with text
 * positioning elements within the Domino UI framework, making it easier to create and manipulate
 * text positioning in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTextPositioningElement
 */
public class TextPositioningElement
    extends BaseElement<SVGTextPositioningElement, TextPositioningElement> {

  /**
   * Factory method for creating a new {@code TextPositioningElement} instance from an existing
   * {@code SVGTextPositioningElement}. This method provides a standardized way of wrapping {@code
   * SVGTextPositioningElement} objects within the Domino UI framework, promoting a consistent
   * object creation pattern.
   *
   * @param e the {@code SVGTextPositioningElement} to wrap
   * @return a new instance of {@code TextPositioningElement}
   */
  public static TextPositioningElement of(SVGTextPositioningElement e) {
    return new TextPositioningElement(e);
  }

  /**
   * Constructs a new {@code TextPositioningElement} by encapsulating the provided {@code
   * SVGTextPositioningElement}. The constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring uniformity across the
   * framework.
   *
   * @param element the {@code SVGTextPositioningElement} to be wrapped
   */
  public TextPositioningElement(SVGTextPositioningElement element) {
    super(element);
  }
}
