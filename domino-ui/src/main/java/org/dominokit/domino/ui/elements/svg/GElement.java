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

import elemental2.svg.SVGGElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGGElement}, which corresponds to the {@code <g>}
 * SVG element. The {@code <g>} element, also known as a group, is used to group SVG shapes
 * together. Grouping elements allows you to apply transformations, styles, or animations to
 * multiple elements at once. As an extension of {@link BaseElement}, {@code GElement} facilitates
 * the manipulation of grouped SVG elements within the Domino UI framework, making it easier to
 * manage complex SVG structures.
 *
 * @see BaseElement
 * @see SVGGElement
 */
public class GElement extends BaseElement<SVGGElement, GElement> {

  /**
   * Factory method for creating a new {@code GElement} instance from an existing {@code
   * SVGGElement}. This method provides a standardized way of wrapping {@code SVGGElement} objects
   * within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGGElement} to wrap
   * @return a new instance of {@code GElement}
   */
  public static GElement of(SVGGElement e) {
    return new GElement(e);
  }

  /**
   * Constructs a new {@code GElement} by encapsulating the provided {@code SVGGElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGGElement} to be wrapped
   */
  public GElement(SVGGElement element) {
    super(element);
  }
}
