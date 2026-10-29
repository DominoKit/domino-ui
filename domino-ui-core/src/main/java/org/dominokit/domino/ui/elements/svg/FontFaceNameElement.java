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

import elemental2.svg.SVGFontFaceNameElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFontFaceNameElement}, which corresponds to the {@code
 * <font-face-name>} SVG element. This element is used within a {@code <font-face-src>} to specify a
 * name for the remote font face to be used. As part of the {@link BaseElement} class hierarchy,
 * {@code FontFaceNameElement} provides a fluent interface for defining font face names within SVG
 * font specifications as part of the Domino UI framework.
 *
 * @deprecated As of SVG 2, the use of SVG fonts is deprecated in favor of CSS fonts.
 * @see BaseElement
 * @see SVGFontFaceNameElement
 */
public class FontFaceNameElement extends BaseElement<SVGFontFaceNameElement, FontFaceNameElement> {

  /**
   * Factory method for creating a new {@code FontFaceNameElement} instance from an existing {@code
   * SVGFontFaceNameElement}. This method provides an abstracted way to instantiate {@code
   * FontFaceNameElement} objects, facilitating a standardized and streamlined process within the
   * Domino UI framework.
   *
   * @param e the {@code SVGFontFaceNameElement} to wrap
   * @return a new instance of {@code FontFaceNameElement}
   */
  public static FontFaceNameElement of(SVGFontFaceNameElement e) {
    return new FontFaceNameElement(e);
  }

  /**
   * Constructs a new {@code FontFaceNameElement} by wrapping the provided {@code
   * SVGFontFaceNameElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring a consistent and manageable
   * object creation strategy within the framework.
   *
   * @param element the {@code SVGFontFaceNameElement} to be wrapped
   */
  public FontFaceNameElement(SVGFontFaceNameElement element) {
    super(element);
  }
}
