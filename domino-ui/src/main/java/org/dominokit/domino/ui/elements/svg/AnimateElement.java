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

import elemental2.svg.SVGAnimateElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that serves as a wrapper for {@link SVGAnimateElement} which is an element in SVG used to
 * animate the attributes or properties of SVG elements over time. This class extends the generic
 * {@link BaseElement} to provide enhanced SVG animation capabilities within the Domino UI
 * framework.
 *
 * @see BaseElement
 * @see SVGAnimateElement
 */
public class AnimateElement extends BaseElement<SVGAnimateElement, AnimateElement> {

  /**
   * Factory method for creating a new {@code AnimateElement} instance from a given {@code
   * SVGAnimateElement}. This method provides a convenient interface for constructing {@code
   * AnimateElement} objects.
   *
   * @param e the {@code SVGAnimateElement} to wrap
   * @return a new instance of {@code AnimateElement}
   */
  public static AnimateElement of(SVGAnimateElement e) {
    return new AnimateElement(e);
  }

  /**
   * Constructor for creating a new {@code AnimateElement} that wraps the provided {@code
   * SVGAnimateElement}. The constructor is not intended for direct use; instances should be created
   * through the static factory method.
   *
   * @param element the {@code SVGAnimateElement} to be wrapped
   */
  public AnimateElement(SVGAnimateElement element) {
    super(element);
  }
}
