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

import elemental2.svg.SVGAltGlyphItemElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper around the {@link SVGAltGlyphItemElement}, which is part of the SVG
 * specification for alternate glyph items. This class extends {@link BaseElement} to encapsulate
 * the functionality provided by {@code SVGAltGlyphItemElement} and expose it in a way that
 * integrates with the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGAltGlyphItemElement
 */
public class AltGlyphItemElement extends BaseElement<SVGAltGlyphItemElement, AltGlyphItemElement> {

  /**
   * Factory method to create an {@code AltGlyphItemElement} instance from a given {@code
   * SVGAltGlyphItemElement}. This method provides a convenient way to create an {@code
   * AltGlyphItemElement} without directly invoking the constructor.
   *
   * @param e the {@code SVGAltGlyphItemElement} that the new element will wrap
   * @return an {@code AltGlyphItemElement} instance that wraps the provided {@code
   *     SVGAltGlyphItemElement}
   */
  public static AltGlyphItemElement of(SVGAltGlyphItemElement e) {
    return new AltGlyphItemElement(e);
  }

  /**
   * Constructs a new {@code AltGlyphItemElement} by wrapping the specified {@code
   * SVGAltGlyphItemElement}. The constructor is package-private to enforce the use of the factory
   * method for creating new instances.
   *
   * @param element the {@code SVGAltGlyphItemElement} to be wrapped
   */
  public AltGlyphItemElement(SVGAltGlyphItemElement element) {
    super(element);
  }
}
