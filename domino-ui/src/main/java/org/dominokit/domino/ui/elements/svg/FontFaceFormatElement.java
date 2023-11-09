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

import elemental2.svg.SVGFontFaceFormatElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that provides a wrapper for the {@link SVGFontFaceFormatElement}, which is linked to the
 * {@code <font-face-format>} SVG element. This element is used within a {@code <font-face-uri>} to
 * describe the format of the font referenced by the URI. While SVG fonts provide a way to describe
 * the font's data within the SVG document, the {@code <font-face-format>} element facilitates the
 * specification of external font formats. As an extension of {@link BaseElement}, {@code
 * FontFaceFormatElement} simplifies the integration and manipulation of font format information
 * within SVG documents in the Domino UI framework.
 *
 * @deprecated The usage of SVG fonts is deprecated in favor of CSS fonts in SVG 2.
 * @see BaseElement
 * @see SVGFontFaceFormatElement
 */
public class FontFaceFormatElement
    extends BaseElement<SVGFontFaceFormatElement, FontFaceFormatElement> {

  /**
   * Factory method for creating a new {@code FontFaceFormatElement} instance from an existing
   * {@code SVGFontFaceFormatElement}. This method provides a standardized approach to constructing
   * {@code FontFaceFormatElement} objects, streamlining their creation within the Domino UI
   * framework.
   *
   * @param e the {@code SVGFontFaceFormatElement} to wrap
   * @return a new instance of {@code FontFaceFormatElement}
   */
  public static FontFaceFormatElement of(SVGFontFaceFormatElement e) {
    return new FontFaceFormatElement(e);
  }

  /**
   * Constructs a new {@code FontFaceFormatElement} by encapsulating the specified {@code
   * SVGFontFaceFormatElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, thus promoting a consistent and
   * maintainable object creation strategy throughout the framework.
   *
   * @param element the {@code SVGFontFaceFormatElement} to be wrapped
   */
  public FontFaceFormatElement(SVGFontFaceFormatElement element) {
    super(element);
  }
}
