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

import elemental2.svg.SVGAElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Provides a wrapper for SVG anchor elements within the Domino UI framework. This class extends the
 * generic {@link BaseElement} to provide specialized functionality through the {@link SVGAElement}
 * from the Elemental2 library.
 *
 * @see BaseElement
 * @see SVGAElement
 */
public class AElement extends BaseElement<SVGAElement, AElement> {

  /**
   * Creates a new {@code AElement} instance wrapping the provided {@code SVGAElement}. This is a
   * static factory method for creating instances of {@code AElement}.
   *
   * @param e the {@link SVGAElement} to wrap
   * @return a new instance of {@code AElement}
   */
  public static AElement of(SVGAElement e) {
    return new AElement(e);
  }

  /**
   * Constructs an {@code AElement} wrapping the given {@code SVGAElement}. The constructor is
   * protected to enforce instantiation through the static factory method.
   *
   * @param element the {@link SVGAElement} to be wrapped by this {@code AElement}
   */
  public AElement(SVGAElement element) {
    super(element);
  }
}
