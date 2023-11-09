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

import elemental2.svg.SVGHKernElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGHKernElement}, which represents a horizontal
 * kerning pair in an SVG font. Kerning is the adjustment of space between pairs of characters in
 * typography to improve the visual appearance of the text. The {@code HKernElement} class allows
 * you to work with horizontal kerning pairs within the Domino UI framework, making it easier to
 * create and manipulate SVG fonts.
 *
 * @see BaseElement
 * @see SVGHKernElement
 */
public class HKernElement extends BaseElement<SVGHKernElement, HKernElement> {

  /**
   * Factory method for creating a new {@code HKernElement} instance from an existing {@code
   * SVGHKernElement}. This method provides a standardized way of wrapping {@code SVGHKernElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGHKernElement} to wrap
   * @return a new instance of {@code HKernElement}
   */
  public static HKernElement of(SVGHKernElement e) {
    return new HKernElement(e);
  }

  /**
   * Constructs a new {@code HKernElement} by encapsulating the provided {@code SVGHKernElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGHKernElement} to be wrapped
   */
  public HKernElement(SVGHKernElement element) {
    super(element);
  }
}
