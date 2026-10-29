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

import elemental2.svg.SVGFEFloodElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class wraps the {@link SVGFEFloodElement}, which corresponds to the {@code <feFlood>} SVG
 * element. The {@code feFlood} element fills the filter subregion with the color provided in the
 * {@code flood-color} and {@code flood-opacity} attributes, effectively rendering a rectangle of
 * solid color. Extending {@link BaseElement}, {@code FEFloodElement} enables the easy application
 * of flood effects within SVG documents, utilizing the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEFloodElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feFlood">MDN Web Docs -
 *     SVGFEFloodElement</a>
 */
public class FEFloodElement extends BaseElement<SVGFEFloodElement, FEFloodElement> {

  /**
   * Factory method for creating a new {@code FEFloodElement} instance from an existing {@code
   * SVGFEFloodElement}. This method provides an abstracted way to instantiate {@code
   * FEFloodElement} objects, simplifying integration within the Domino UI framework.
   *
   * @param e the {@code SVGFEFloodElement} to wrap
   * @return a new instance of {@code FEFloodElement}
   */
  public static FEFloodElement of(SVGFEFloodElement e) {
    return new FEFloodElement(e);
  }

  /**
   * Constructs a new {@code FEFloodElement} by encapsulating the specified {@code
   * SVGFEFloodElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating instances, which helps maintain consistency and ease of object
   * creation within the framework.
   *
   * @param element the {@code SVGFEFloodElement} to be wrapped
   */
  public FEFloodElement(SVGFEFloodElement element) {
    super(element);
  }
}
