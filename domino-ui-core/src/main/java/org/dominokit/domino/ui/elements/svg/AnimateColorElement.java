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

import elemental2.svg.SVGAnimateColorElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper for the {@link SVGAnimateColorElement} which is used to animate color
 * properties of SVG elements. This class extends {@link BaseElement} and provides additional
 * functionality tailored for the SVG 'animateColor' element within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGAnimateColorElement
 */
public class AnimateColorElement extends BaseElement<SVGAnimateColorElement, AnimateColorElement> {

  /**
   * Factory method to create a new {@code AnimateColorElement} instance based on the provided
   * {@code SVGAnimateColorElement}. This method allows for easy instantiation of {@code
   * AnimateColorElement} objects.
   *
   * @param e the {@code SVGAnimateColorElement} to wrap
   * @return a new instance of {@code AnimateColorElement}
   */
  public static AnimateColorElement of(SVGAnimateColorElement e) {
    return new AnimateColorElement(e);
  }

  /**
   * Constructs a new {@code AnimateColorElement} that wraps the specified {@code
   * SVGAnimateColorElement}. This constructor is protected to encourage instantiation through the
   * factory method.
   *
   * @param element the {@code SVGAnimateColorElement} to be wrapped
   */
  public AnimateColorElement(SVGAnimateColorElement element) {
    super(element);
  }
}
