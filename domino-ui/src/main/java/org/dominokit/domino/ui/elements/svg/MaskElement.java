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

import elemental2.svg.SVGMaskElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGMaskElement}, which represents an SVG mask
 * element. The {@code MaskElement} class allows you to work with SVG masks within the Domino UI
 * framework, making it easier to create and manipulate mask elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGMaskElement
 */
public class MaskElement extends BaseElement<SVGMaskElement, MaskElement> {

  /**
   * Factory method for creating a new {@code MaskElement} instance from an existing {@code
   * SVGMaskElement}. This method provides a standardized way of wrapping {@code SVGMaskElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGMaskElement} to wrap
   * @return a new instance of {@code MaskElement}
   */
  public static MaskElement of(SVGMaskElement e) {
    return new MaskElement(e);
  }

  /**
   * Constructs a new {@code MaskElement} by encapsulating the provided {@code SVGMaskElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGMaskElement} to be wrapped
   */
  public MaskElement(SVGMaskElement element) {
    super(element);
  }
}
