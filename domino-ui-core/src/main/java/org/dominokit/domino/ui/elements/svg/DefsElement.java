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

import elemental2.svg.SVGDefsElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that encapsulates the {@link SVGDefsElement}, which is used in SVG to define graphical
 * objects that can be used later within the document. This element is typically used to store
 * graphical elements that will be used at multiple places, such as masks, patterns, or gradients.
 * Extending {@link BaseElement}, this class provides a convenient way to interact with the SVG
 * 'defs' element within the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGDefsElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/defs">MDN Web Docs -
 *     SVGDefsElement</a>
 */
public class DefsElement extends BaseElement<SVGDefsElement, DefsElement> {

  /**
   * Factory method for creating a new {@code DefsElement} instance that wraps an existing {@code
   * SVGDefsElement}. This method facilitates the instantiation of {@code DefsElement} objects,
   * providing a more abstract interface within the Domino UI framework.
   *
   * @param e the {@code SVGDefsElement} to wrap
   * @return a new {@code DefsElement} instance
   */
  public static DefsElement of(SVGDefsElement e) {
    return new DefsElement(e);
  }

  /**
   * Constructs a new {@code DefsElement} by encapsulating the specified {@code SVGDefsElement}. The
   * constructor is protected to encourage the use of the static factory method {@code of()} for
   * creating new instances.
   *
   * @param element the {@code SVGDefsElement} to be wrapped
   */
  public DefsElement(SVGDefsElement element) {
    super(element);
  }
}
