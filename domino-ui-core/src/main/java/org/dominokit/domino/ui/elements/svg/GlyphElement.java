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

import elemental2.svg.SVGGlyphElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGGlyphElement}, which corresponds to the {@code
 * <glyph>} SVG element. The {@code <glyph>} element is used to define a single glyph in a font used
 * for rendering SVG text. It represents a specific graphical symbol within a font and is commonly
 * used in SVG fonts. As an extension of {@link BaseElement}, {@code GlyphElement} facilitates the
 * manipulation of glyph elements within the Domino UI framework, making it easier to work with SVG
 * fonts and text.
 *
 * @see BaseElement
 * @see SVGGlyphElement
 */
public class GlyphElement extends BaseElement<SVGGlyphElement, GlyphElement> {

  /**
   * Factory method for creating a new {@code GlyphElement} instance from an existing {@code
   * SVGGlyphElement}. This method provides a standardized way of wrapping {@code SVGGlyphElement}
   * objects within the Domino UI framework, promoting a consistent object creation pattern.
   *
   * @param e the {@code SVGGlyphElement} to wrap
   * @return a new instance of {@code GlyphElement}
   */
  public static GlyphElement of(SVGGlyphElement e) {
    return new GlyphElement(e);
  }

  /**
   * Constructs a new {@code GlyphElement} by encapsulating the provided {@code SVGGlyphElement}.
   * The constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGGlyphElement} to be wrapped
   */
  public GlyphElement(SVGGlyphElement element) {
    super(element);
  }
}
