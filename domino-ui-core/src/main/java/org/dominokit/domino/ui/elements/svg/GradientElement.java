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

import elemental2.svg.SVGGradientElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGGradientElement}, which corresponds to various
 * SVG gradient elements such as {@code <linearGradient>} and {@code <radialGradient>}. Gradients in
 * SVG are used to fill or stroke shapes with smoothly changing colors. As an extension of {@link
 * BaseElement}, {@code GradientElement} facilitates the manipulation of gradient elements within
 * the Domino UI framework, making it easier to work with SVG gradients for styling and rendering
 * purposes.
 *
 * @see BaseElement
 * @see SVGGradientElement
 */
public class GradientElement extends BaseElement<SVGGradientElement, GradientElement> {

  /**
   * Factory method for creating a new {@code GradientElement} instance from an existing {@code
   * SVGGradientElement}. This method provides a standardized way of wrapping {@code
   * SVGGradientElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGGradientElement} to wrap
   * @return a new instance of {@code GradientElement}
   */
  public static GradientElement of(SVGGradientElement e) {
    return new GradientElement(e);
  }

  /**
   * Constructs a new {@code GradientElement} by encapsulating the provided {@code
   * SVGGradientElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGGradientElement} to be wrapped
   */
  public GradientElement(SVGGradientElement element) {
    super(element);
  }
}
