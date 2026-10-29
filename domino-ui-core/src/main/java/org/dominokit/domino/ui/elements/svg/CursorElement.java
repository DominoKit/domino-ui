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

import elemental2.svg.SVGCursorElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Provides a wrapper for the {@link SVGCursorElement} which is an SVG element used to define a
 * custom cursor. By extending {@link BaseElement}, this class allows for easy integration and
 * manipulation of cursor properties within SVG content, facilitated by the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGCursorElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/cursor">MDN Web Docs -
 *     SVGCursorElement</a>
 */
public class CursorElement extends BaseElement<SVGCursorElement, CursorElement> {

  /**
   * Factory method to create a new {@code CursorElement} instance from an existing {@code
   * SVGCursorElement}. This method is the preferred means of instantiation, offering an abstracted
   * approach to working with SVG cursors within the Domino UI framework.
   *
   * @param e the {@code SVGCursorElement} to wrap
   * @return a new {@code CursorElement} instance
   */
  public static CursorElement of(SVGCursorElement e) {
    return new CursorElement(e);
  }

  /**
   * Constructs a new {@code CursorElement} that encapsulates the given {@code SVGCursorElement}.
   * This constructor is protected to promote the use of the factory method for creating instances.
   *
   * @param element the {@code SVGCursorElement} to be wrapped
   */
  public CursorElement(SVGCursorElement element) {
    super(element);
  }
}
