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

import elemental2.svg.SVGLinearGradientElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGLinearGradientElement}, which represents an SVG
 * linear gradient element. The {@code LinearGradientElement} class allows you to work with SVG
 * linear gradients within the Domino UI framework, making it easier to create and manipulate linear
 * gradients in SVG graphics.
 *
 * @see BaseElement
 * @see SVGLinearGradientElement
 */
public class LinearGradientElement
    extends BaseElement<SVGLinearGradientElement, LinearGradientElement> {

  /**
   * Factory method for creating a new {@code LinearGradientElement} instance from an existing
   * {@code SVGLinearGradientElement}. This method provides a standardized way of wrapping {@code
   * SVGLinearGradientElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGLinearGradientElement} to wrap
   * @return a new instance of {@code LinearGradientElement}
   */
  public static LinearGradientElement of(SVGLinearGradientElement e) {
    return new LinearGradientElement(e);
  }

  /**
   * Constructs a new {@code LinearGradientElement} by encapsulating the provided {@code
   * SVGLinearGradientElement}. The constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring uniformity across the
   * framework.
   *
   * @param element the {@code SVGLinearGradientElement} to be wrapped
   */
  public LinearGradientElement(SVGLinearGradientElement element) {
    super(element);
  }
}
