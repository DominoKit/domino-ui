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
package org.dominokit.domino.ui.elements;

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLPictureElement;

/**
 * Represents an HTML <picture> element wrapper.
 *
 * <p>The HTML <picture> element is used to include multiple sources for an image element. It allows
 * you to specify different image sources based on factors like screen size or pixel density. This
 * class provides a Java-based way to create, manipulate, and control the behavior of <picture>
 * elements in web applications. Example usage:
 *
 * <pre>{@code
 * HTMLPictureElement pictureElement = ...;  // Obtain a <picture> element from somewhere
 * PictureElement picture = PictureElement.of(pictureElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/picture">MDN Web Docs
 *     (picture)</a>
 */
public class PictureElement extends BaseElement<HTMLPictureElement, PictureElement> {

  /**
   * Creates a new {@link PictureElement} instance by wrapping the provided HTML <picture> element.
   *
   * @param e The HTML <picture> element to wrap.
   * @return A new {@link PictureElement} instance wrapping the provided element.
   */
  public static PictureElement of(HTMLPictureElement e) {
    return new PictureElement(e);
  }

  /**
   * Constructs a {@link PictureElement} instance by wrapping the provided HTML <picture> element.
   *
   * @param element The HTML <picture> element to wrap.
   */
  public PictureElement(HTMLPictureElement element) {
    super(element);
  }
}
