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

import elemental2.svg.SVGClipPathElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Represents a wrapper for the {@link SVGClipPathElement} which is used within SVG graphics to
 * define a clipping path. A clipping path is utilized to delineate a region to which SVG content
 * rendering is confined, effectively controlling the visibility of parts of the SVG elements.
 * Extending {@link BaseElement}, this class provides a fluent interface and additional
 * functionality tailored for the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGClipPathElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/clipPath">MDN Web Docs -
 *     SVGClipPathElement</a>
 */
public class ClipPathElement extends BaseElement<SVGClipPathElement, ClipPathElement> {

  /**
   * Factory method that returns a new instance of {@code ClipPathElement} by wrapping an {@code
   * SVGClipPathElement}. This method simplifies the instantiation process and is the recommended
   * approach for creating {@code ClipPathElement} objects within the framework.
   *
   * @param e the {@code SVGClipPathElement} to wrap
   * @return a new instance of {@code ClipPathElement}
   */
  public static ClipPathElement of(SVGClipPathElement e) {
    return new ClipPathElement(e);
  }

  /**
   * Constructor for creating a new {@code ClipPathElement} instance that encapsulates the provided
   * {@code SVGClipPathElement}. It is protected to promote the use of the factory method {@code
   * of()} for creating new instances.
   *
   * @param element the {@code SVGClipPathElement} to wrap
   */
  public ClipPathElement(SVGClipPathElement element) {
    super(element);
  }
}
