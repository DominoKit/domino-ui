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

import elemental2.svg.SVGAltGlyphElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper for the {@link SVGAltGlyphElement}, which is an SVG element that provides a
 * way to reference alternate glyph definitions. This is typically used when multiple glyphs are
 * available for a single character, like in the case of font variants. This class extends {@link
 * BaseElement} and provides additional functionality specific to the SVG 'altGlyph' element.
 *
 * @see BaseElement
 * @see SVGAltGlyphElement
 */
public class AltGlyphElement extends BaseElement<SVGAltGlyphElement, AltGlyphElement> {

  /**
   * Creates an {@code AltGlyphElement} instance that wraps an {@code SVGAltGlyphElement}. This
   * factory method facilitates the creation of {@code AltGlyphElement} instances.
   *
   * @param e the {@code SVGAltGlyphElement} to wrap
   * @return an {@code AltGlyphElement} instance
   */
  public static AltGlyphElement of(SVGAltGlyphElement e) {
    return new AltGlyphElement(e);
  }

  /**
   * Constructs an {@code AltGlyphElement} that wraps the specified {@code SVGAltGlyphElement}. The
   * constructor is protected to encourage the use of the factory method for instance creation.
   *
   * @param element the {@code SVGAltGlyphElement} to be wrapped
   */
  public AltGlyphElement(SVGAltGlyphElement element) {
    super(element);
  }
}
