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

import elemental2.svg.SVGFontElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Wraps the {@link SVGFontElement}, representing the SVG {@code <font>} element. The {@code <font>}
 * element is used in SVG to define a font to be used for text layout. Extending {@link
 * BaseElement}, {@code FontElement} provides the necessary functionalities to work with custom SVG
 * fonts within the Domino UI framework, allowing for a more versatile and detailed text styling and
 * manipulation.
 *
 * @deprecated As of SVG 2, the use of SVG fonts is deprecated in favor of CSS fonts.
 * @see BaseElement
 * @see SVGFontElement
 */
public class FontElement extends BaseElement<SVGFontElement, FontElement> {

  /**
   * Factory method for creating a new {@code FontElement} instance from an existing {@code
   * SVGFontElement}. This method provides a standardized way to instantiate {@code FontElement}
   * objects, recommended for use within the Domino UI framework.
   *
   * @param e the {@code SVGFontElement} to wrap
   * @return a new instance of {@code FontElement}
   */
  public static FontElement of(SVGFontElement e) {
    return new FontElement(e);
  }

  /**
   * Constructs a new {@code FontElement} by encapsulating the specified {@code SVGFontElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, thus maintaining consistent object creation throughout the framework.
   *
   * @param element the {@code SVGFontElement} to be wrapped
   */
  public FontElement(SVGFontElement element) {
    super(element);
  }
}
