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

import elemental2.svg.SVGStopElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGStopElement}, which represents an SVG stop
 * element. The {@code StopElement} class allows you to work with stop elements within the Domino UI
 * framework, making it easier to create and manipulate stop elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGStopElement
 */
public class StopElement extends BaseElement<SVGStopElement, StopElement> {

  /**
   * Factory method for creating a new {@code StopElement} instance from an existing {@code
   * SVGStopElement}. This method provides a standardized way of wrapping {@code SVGStopElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGStopElement} to wrap
   * @return a new instance of {@code StopElement}
   */
  public static StopElement of(SVGStopElement e) {
    return new StopElement(e);
  }

  /**
   * Constructs a new {@code StopElement} by encapsulating the provided {@code SVGStopElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGStopElement} to be wrapped
   */
  public StopElement(SVGStopElement element) {
    super(element);
  }
}
