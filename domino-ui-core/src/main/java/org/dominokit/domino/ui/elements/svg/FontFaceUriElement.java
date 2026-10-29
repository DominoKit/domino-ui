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

import elemental2.svg.SVGFontFaceUriElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that wraps the {@link SVGFontFaceUriElement}, related to the {@code <font-face-uri>} SVG
 * element. This element is used within the {@code <font-face-src>} to reference an external font
 * resource by its URI. The {@code FontFaceUriElement} extends {@link BaseElement} to enable the
 * integration of remote fonts within SVG documents, leveraging the capabilities of the Domino UI
 * framework.
 *
 * @deprecated The use of SVG fonts is deprecated in SVG 2 in favor of CSS fonts.
 * @see BaseElement
 * @see SVGFontFaceUriElement
 */
public class FontFaceUriElement extends BaseElement<SVGFontFaceUriElement, FontFaceUriElement> {

  /**
   * Factory method for creating a new {@code FontFaceUriElement} instance from a provided {@code
   * SVGFontFaceUriElement}. This method offers a streamlined, abstracted approach for constructing
   * {@code FontFaceUriElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGFontFaceUriElement} to wrap
   * @return a new instance of {@code FontFaceUriElement}
   */
  public static FontFaceUriElement of(SVGFontFaceUriElement e) {
    return new FontFaceUriElement(e);
  }

  /**
   * Constructs a new {@code FontFaceUriElement} by encapsulating the specified {@code
   * SVGFontFaceUriElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, thus ensuring consistent and
   * maintainable object creation strategy across the framework.
   *
   * @param element the {@code SVGFontFaceUriElement} to be wrapped
   */
  public FontFaceUriElement(SVGFontFaceUriElement element) {
    super(element);
  }
}
