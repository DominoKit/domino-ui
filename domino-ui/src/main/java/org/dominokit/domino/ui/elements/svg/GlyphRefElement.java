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

import elemental2.svg.SVGGlyphRefElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGGlyphRefElement}, which corresponds to the {@code
 * <glyphRef>} SVG element. The {@code <glyphRef>} element is used to reference a specific glyph
 * within an SVG font for rendering text. It represents a reference to a glyph within a font and is
 * commonly used in SVG fonts. As an extension of {@link BaseElement}, {@code GlyphRefElement}
 * facilitates the manipulation of glyph reference elements within the Domino UI framework, making
 * it easier to work with SVG fonts and text.
 *
 * @see BaseElement
 * @see SVGGlyphRefElement
 */
public class GlyphRefElement extends BaseElement<SVGGlyphRefElement, GlyphRefElement> {

  /**
   * Factory method for creating a new {@code GlyphRefElement} instance from an existing {@code
   * SVGGlyphRefElement}. This method provides a standardized way of wrapping {@code
   * SVGGlyphRefElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGGlyphRefElement} to wrap
   * @return a new instance of {@code GlyphRefElement}
   */
  public static GlyphRefElement of(SVGGlyphRefElement e) {
    return new GlyphRefElement(e);
  }

  /**
   * Constructs a new {@code GlyphRefElement} by encapsulating the provided {@code
   * SVGGlyphRefElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGGlyphRefElement} to be wrapped
   */
  public GlyphRefElement(SVGGlyphRefElement element) {
    super(element);
  }
}
