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

import elemental2.svg.SVGTRefElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGTRefElement}, which represents an SVG tref
 * element. The {@code TRefElement} class allows you to work with tref elements within the Domino UI
 * framework, making it easier to create and manipulate tref elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGTRefElement
 */
public class TRefElement extends BaseElement<SVGTRefElement, TRefElement> {

  /**
   * Factory method for creating a new {@code TRefElement} instance from an existing {@code
   * SVGTRefElement}. This method provides a standardized way of wrapping {@code SVGTRefElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGTRefElement} to wrap
   * @return a new instance of {@code TRefElement}
   */
  public static TRefElement of(SVGTRefElement e) {
    return new TRefElement(e);
  }

  /**
   * Constructs a new {@code TRefElement} by encapsulating the provided {@code SVGTRefElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGTRefElement} to be wrapped
   */
  public TRefElement(SVGTRefElement element) {
    super(element);
  }
}
