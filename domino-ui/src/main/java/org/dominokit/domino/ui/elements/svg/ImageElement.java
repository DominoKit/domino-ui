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

import elemental2.svg.SVGImageElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGImageElement}, which represents an SVG image
 * element. The {@code ImageElement} class allows you to work with SVG images within the Domino UI
 * framework, making it easier to create and manipulate SVG images.
 *
 * @see BaseElement
 * @see SVGImageElement
 */
public class ImageElement extends BaseElement<SVGImageElement, ImageElement> {

  /**
   * Factory method for creating a new {@code ImageElement} instance from an existing {@code
   * SVGImageElement}. This method provides a standardized way of wrapping {@code SVGImageElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGImageElement} to wrap
   * @return a new instance of {@code ImageElement}
   */
  public static ImageElement of(SVGImageElement e) {
    return new ImageElement(e);
  }

  /**
   * Constructs a new {@code ImageElement} by encapsulating the provided {@code SVGImageElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGImageElement} to be wrapped
   */
  public ImageElement(SVGImageElement element) {
    super(element);
  }
}
