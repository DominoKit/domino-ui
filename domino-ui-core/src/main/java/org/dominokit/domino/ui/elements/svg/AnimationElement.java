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

import elemental2.svg.SVGAnimationElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that provides a wrapper for the {@link SVGAnimationElement} interface of the SVG DOM API,
 * which is the base interface for all SVG animation elements. It extends the {@link BaseElement} to
 * integrate smoothly with Domino UI components, providing a fluent API for working with SVG
 * animations.
 *
 * @see BaseElement
 * @see SVGAnimationElement
 */
public class AnimationElement extends BaseElement<SVGAnimationElement, AnimationElement> {

  /**
   * Factory method for creating an {@code AnimationElement} instance from the provided {@code
   * SVGAnimationElement}. This approach abstracts the instantiation process and is preferred for
   * creating {@code AnimationElement} objects.
   *
   * @param e the {@code SVGAnimationElement} to wrap
   * @return a new instance of {@code AnimationElement}
   */
  public static AnimationElement of(SVGAnimationElement e) {
    return new AnimationElement(e);
  }

  /**
   * Constructor for the {@code AnimationElement} that wraps the given {@code SVGAnimationElement}.
   * This is protected to encourage the use of the factory method {@code of()} for creating new
   * instances.
   *
   * @param element the {@code SVGAnimationElement} to be wrapped
   */
  public AnimationElement(SVGAnimationElement element) {
    super(element);
  }
}
