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

import elemental2.svg.SVGMissingGlyphElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGMissingGlyphElement}, which represents an SVG
 * missing-glyph element. The {@code MissingGlyphElement} class allows you to work with
 * missing-glyph elements within the Domino UI framework, making it easier to create and manipulate
 * missing-glyph elements in SVG graphics.
 *
 * @see BaseElement
 * @see SVGMissingGlyphElement
 */
public class MissingGlyphElement extends BaseElement<SVGMissingGlyphElement, MissingGlyphElement> {

  /**
   * Factory method for creating a new {@code MissingGlyphElement} instance from an existing {@code
   * SVGMissingGlyphElement}. This method provides a standardized way of wrapping {@code
   * SVGMissingGlyphElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGMissingGlyphElement} to wrap
   * @return a new instance of {@code MissingGlyphElement}
   */
  public static MissingGlyphElement of(SVGMissingGlyphElement e) {
    return new MissingGlyphElement(e);
  }

  /**
   * Constructs a new {@code MissingGlyphElement} by encapsulating the provided {@code
   * SVGMissingGlyphElement}. The constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, ensuring uniformity across the
   * framework.
   *
   * @param element the {@code SVGMissingGlyphElement} to be wrapped
   */
  public MissingGlyphElement(SVGMissingGlyphElement element) {
    super(element);
  }
}
