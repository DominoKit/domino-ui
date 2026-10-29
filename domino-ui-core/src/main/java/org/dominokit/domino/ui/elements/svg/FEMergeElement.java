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

import elemental2.svg.SVGFEMergeElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGFEMergeElement}, associated with the {@code <feMerge>}
 * SVG element. This filter primitive composites input image layers on top of each other using the
 * simple over operator. It extends {@link BaseElement}, providing a convenient API for managing the
 * stacking of image layers within SVG filters as part of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEMergeElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feMerge">MDN Web Docs -
 *     SVGFEMergeElement</a>
 */
public class FEMergeElement extends BaseElement<SVGFEMergeElement, FEMergeElement> {

  /**
   * Factory method for creating a new {@code FEMergeElement} instance from an existing {@code
   * SVGFEMergeElement}. This method provides an abstracted way to instantiate {@code
   * FEMergeElement} objects, promoting a consistent method for creating these objects within the
   * Domino UI framework.
   *
   * @param e the {@code SVGFEMergeElement} to wrap
   * @return a new instance of {@code FEMergeElement}
   */
  public static FEMergeElement of(SVGFEMergeElement e) {
    return new FEMergeElement(e);
  }

  /**
   * Constructs a new {@code FEMergeElement} by wrapping the provided {@code SVGFEMergeElement}.
   * This constructor is protected to encourage the use of the static factory method {@code of()}
   * for creating new instances, ensuring uniform object creation strategy across the framework.
   *
   * @param element the {@code SVGFEMergeElement} to be wrapped
   */
  public FEMergeElement(SVGFEMergeElement element) {
    super(element);
  }
}
