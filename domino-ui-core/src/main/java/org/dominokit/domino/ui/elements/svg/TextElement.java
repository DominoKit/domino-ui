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

import elemental2.svg.SVGTextElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTextElement}, which represents an SVG text
 * element. The {@code TextElement} class allows you to work with text elements within the Domino UI
 * framework, making it easier to create and manipulate text in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTextElement
 */
public class TextElement extends BaseElement<SVGTextElement, TextElement> {

  /**
   * Factory method for creating a new {@code TextElement} instance from an existing {@code
   * SVGTextElement}. This method provides a standardized way of wrapping {@code SVGTextElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGTextElement} to wrap
   * @return a new instance of {@code TextElement}
   */
  public static TextElement of(SVGTextElement e) {
    return new TextElement(e);
  }

  /**
   * Constructs a new {@code TextElement} by encapsulating the provided {@code SVGTextElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTextElement} to be wrapped
   */
  public TextElement(SVGTextElement element) {
    super(element);
  }
}
