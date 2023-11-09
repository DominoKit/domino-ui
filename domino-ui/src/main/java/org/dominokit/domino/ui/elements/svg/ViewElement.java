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

import elemental2.svg.SVGViewElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGViewElement}, which represents an SVG view
 * element. The {@code ViewElement} class allows you to work with view elements within the Domino UI
 * framework, making it easier to create and manipulate view elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGViewElement
 */
public class ViewElement extends BaseElement<SVGViewElement, ViewElement> {

  /**
   * Factory method for creating a new {@code ViewElement} instance from an existing {@code
   * SVGViewElement}. This method provides a standardized way of wrapping {@code SVGViewElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGViewElement} to wrap
   * @return a new instance of {@code ViewElement}
   */
  public static ViewElement of(SVGViewElement e) {
    return new ViewElement(e);
  }

  /**
   * Constructs a new {@code ViewElement} by encapsulating the provided {@code SVGViewElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGViewElement} to be wrapped
   */
  public ViewElement(SVGViewElement element) {
    super(element);
  }
}
