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

import elemental2.svg.SVGGraphicsElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGGraphicsElement}, which represents a wide range
 * of SVG graphical elements. SVG graphics elements include shapes, text, images, and other visual
 * elements that can be displayed in an SVG document. As an extension of {@link BaseElement}, {@code
 * GraphicsElement} facilitates the manipulation of graphical elements within the Domino UI
 * framework, making it easier to work with SVG graphics for rendering and styling purposes.
 *
 * @see BaseElement
 * @see SVGGraphicsElement
 */
public class GraphicsElement extends BaseElement<SVGGraphicsElement, GraphicsElement> {

  /**
   * Factory method for creating a new {@code GraphicsElement} instance from an existing {@code
   * SVGGraphicsElement}. This method provides a standardized way of wrapping {@code
   * SVGGraphicsElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGGraphicsElement} to wrap
   * @return a new instance of {@code GraphicsElement}
   */
  public static GraphicsElement of(SVGGraphicsElement e) {
    return new GraphicsElement(e);
  }

  /**
   * Constructs a new {@code GraphicsElement} by encapsulating the provided {@code
   * SVGGraphicsElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGGraphicsElement} to be wrapped
   */
  public GraphicsElement(SVGGraphicsElement element) {
    super(element);
  }
}
