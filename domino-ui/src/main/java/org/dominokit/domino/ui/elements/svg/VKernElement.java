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

import elemental2.svg.SVGVKernElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGVKernElement}, which represents an SVG vertical
 * kerning element. The {@code VKernElement} class allows you to work with vertical kerning elements
 * within the Domino UI framework, making it easier to create and manipulate vertical kerning in SVG
 * graphics.
 *
 * @see BaseElement
 * @see SVGVKernElement
 */
public class VKernElement extends BaseElement<SVGVKernElement, VKernElement> {

  /**
   * Factory method for creating a new {@code VKernElement} instance from an existing {@code
   * SVGVKernElement}. This method provides a standardized way of wrapping {@code SVGVKernElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGVKernElement} to wrap
   * @return a new instance of {@code VKernElement}
   */
  public static VKernElement of(SVGVKernElement e) {
    return new VKernElement(e);
  }

  /**
   * Constructs a new {@code VKernElement} by encapsulating the provided {@code SVGVKernElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGVKernElement} to be wrapped
   */
  public VKernElement(SVGVKernElement element) {
    super(element);
  }
}
