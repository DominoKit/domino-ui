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

import elemental2.svg.SVGFontFaceElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class encapsulates the {@link SVGFontFaceElement}, which corresponds to the {@code
 * <font-face>} SVG element. The {@code <font-face>} element is used within SVG fonts to describe
 * the typeface and to define font-related properties. Extending {@link BaseElement}, {@code
 * FontFaceElement} enables the definition and customization of font properties for use with text in
 * SVG documents within the Domino UI framework.
 *
 * @deprecated As of SVG 2, the use of SVG fonts and related elements is deprecated in favor of CSS
 *     fonts.
 * @see BaseElement
 * @see SVGFontFaceElement
 */
public class FontFaceElement extends BaseElement<SVGFontFaceElement, FontFaceElement> {

  /**
   * Factory method for creating a new {@code FontFaceElement} instance from an existing {@code
   * SVGFontFaceElement}. This method provides a convenient way to instantiate {@code
   * FontFaceElement} objects, ensuring standardized object creation and integration within the
   * Domino UI framework.
   *
   * @param e the {@code SVGFontFaceElement} to wrap
   * @return a new instance of {@code FontFaceElement}
   */
  public static FontFaceElement of(SVGFontFaceElement e) {
    return new FontFaceElement(e);
  }

  /**
   * Constructs a new {@code FontFaceElement} by wrapping the provided {@code SVGFontFaceElement}.
   * This constructor is protected to encourage the use of the static factory method {@code of()}
   * for creating new instances, promoting consistency and ease of use across the framework.
   *
   * @param element the {@code SVGFontFaceElement} to be wrapped
   */
  public FontFaceElement(SVGFontFaceElement element) {
    super(element);
  }
}
