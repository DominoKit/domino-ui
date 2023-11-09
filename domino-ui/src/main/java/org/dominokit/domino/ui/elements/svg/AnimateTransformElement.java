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

import elemental2.svg.SVGAnimateTransformElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGAnimateTransformElement} to provide a way to animate transformations
 * on SVG elements. Transformations could include scaling, rotating, moving, and skewing. This class
 * extends {@link BaseElement} to leverage the additional features and ease the integration with the
 * Domino UI framework's components and utilities.
 *
 * @see BaseElement
 * @see SVGAnimateTransformElement
 */
public class AnimateTransformElement
    extends BaseElement<SVGAnimateTransformElement, AnimateTransformElement> {

  /**
   * Factory method that returns a new {@code AnimateTransformElement} instance by wrapping an
   * {@code SVGAnimateTransformElement}. This method is the preferred way to create {@code
   * AnimateTransformElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGAnimateTransformElement} to wrap
   * @return a new instance of {@code AnimateTransformElement}
   */
  public static AnimateTransformElement of(SVGAnimateTransformElement e) {
    return new AnimateTransformElement(e);
  }

  /**
   * Constructor to create a new {@code AnimateTransformElement} by wrapping the provided {@code
   * SVGAnimateTransformElement}. It is protected to encourage usage of the factory method for
   * object creation.
   *
   * @param element the {@code SVGAnimateTransformElement} to be wrapped
   */
  public AnimateTransformElement(SVGAnimateTransformElement element) {
    super(element);
  }
}
