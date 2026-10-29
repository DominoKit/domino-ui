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

import elemental2.svg.SVGForeignObjectElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGForeignObjectElement}, corresponding to the {@code
 * <foreignObject>} SVG element. This element provides a way to include external graphical content
 * in an SVG document, allowing for the incorporation of HTML and other XML namespaces within an
 * SVG. By extending {@link BaseElement}, {@code ForeignObjectElement} offers a convenient API to
 * work with complex application structures and mixed-namespace content within SVG, complemented by
 * the capabilities of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGForeignObjectElement
 */
public class ForeignObjectElement
    extends BaseElement<SVGForeignObjectElement, ForeignObjectElement> {

  /**
   * Factory method for creating a new {@code ForeignObjectElement} instance from an existing {@code
   * SVGForeignObjectElement}. This method provides an abstracted way to instantiate {@code
   * ForeignObjectElement} objects, facilitating their use within the Domino UI framework.
   *
   * @param e the {@code SVGForeignObjectElement} to wrap
   * @return a new instance of {@code ForeignObjectElement}
   */
  public static ForeignObjectElement of(SVGForeignObjectElement e) {
    return new ForeignObjectElement(e);
  }

  /**
   * Constructs a new {@code ForeignObjectElement} by wrapping the specified {@code
   * SVGForeignObjectElement}. This constructor is protected to promote the use of the static
   * factory method {@code of()} for creating new instances, ensuring a consistent approach to
   * object creation across the framework.
   *
   * @param element the {@code SVGForeignObjectElement} to be wrapped
   */
  public ForeignObjectElement(SVGForeignObjectElement element) {
    super(element);
  }
}
