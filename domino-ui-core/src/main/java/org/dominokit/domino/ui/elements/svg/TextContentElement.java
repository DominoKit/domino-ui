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

import elemental2.svg.SVGTextContentElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTextContentElement}, which represents an SVG text
 * content element. The {@code TextContentElement} class allows you to work with text content
 * elements within the Domino UI framework, making it easier to create and manipulate text content
 * in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTextContentElement
 */
public class TextContentElement extends BaseElement<SVGTextContentElement, TextContentElement> {

  /**
   * Factory method for creating a new {@code TextContentElement} instance from an existing {@code
   * SVGTextContentElement}. This method provides a standardized way of wrapping {@code
   * SVGTextContentElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGTextContentElement} to wrap
   * @return a new instance of {@code TextContentElement}
   */
  public static TextContentElement of(SVGTextContentElement e) {
    return new TextContentElement(e);
  }

  /**
   * Constructs a new {@code TextContentElement} by encapsulating the provided {@code
   * SVGTextContentElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTextContentElement} to be wrapped
   */
  public TextContentElement(SVGTextContentElement element) {
    super(element);
  }
}
