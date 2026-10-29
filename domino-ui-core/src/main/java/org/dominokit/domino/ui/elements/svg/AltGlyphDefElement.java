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

import elemental2.svg.SVGAltGlyphDefElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper around the {@link SVGAltGlyphDefElement} which is used to define an
 * alternative glyph definition for characters in an SVG document. This class extends {@link
 * BaseElement} to provide enhanced features specific to SVG Alt Glyph Definition Elements.
 *
 * @see BaseElement
 * @see SVGAltGlyphDefElement
 */
public class AltGlyphDefElement extends BaseElement<SVGAltGlyphDefElement, AltGlyphDefElement> {

  /**
   * Factory method to create an instance of {@code AltGlyphDefElement} based on the provided {@code
   * SVGAltGlyphDefElement}. This method serves as an alternative to the constructor for creating
   * {@code AltGlyphDefElement} instances.
   *
   * @param e the {@code SVGAltGlyphDefElement} to wrap
   * @return an instance of {@code AltGlyphDefElement}
   */
  public static AltGlyphDefElement of(SVGAltGlyphDefElement e) {
    return new AltGlyphDefElement(e);
  }

  /**
   * Constructs an instance of {@code AltGlyphDefElement} by wrapping the given {@code
   * SVGAltGlyphDefElement}. The constructor is not intended for public use; instances should be
   * created via the static factory method.
   *
   * @param element the {@code SVGAltGlyphDefElement} to be wrapped
   */
  public AltGlyphDefElement(SVGAltGlyphDefElement element) {
    super(element);
  }
}
