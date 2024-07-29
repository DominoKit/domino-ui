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

import elemental2.dom.HTMLImageElement;

/**
 * Represents an HTML ImageElement element (<img>) wrapper.
 *
 * <p>The HTML <img> element represents an image on a web page. This class provides a convenient way
 * to create, manipulate, and control the behavior of <img> elements in Java-based web applications.
 * Example usage:
 *
 * <pre>
 * HTMLImageElement imageElement = ...;  // Obtain an <img> element from somewhere
 * ImageElement image = ImageElement.of(imageElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/img">MDN Web Docs
 *     (img)</a>
 */
public class ImageElement extends BaseElement<HTMLImageElement, ImageElement> {

  /**
   * Creates a new {@link ImageElement} instance by wrapping the provided HTML <img> element.
   *
   * @param e The HTML <img> element.
   * @return A new {@link ImageElement} instance wrapping the provided element.
   */
  public static ImageElement of(HTMLImageElement e) {
    return new ImageElement(e);
  }

  /**
   * Constructs an {@link ImageElement} instance by wrapping the provided HTML <img> element.
   *
   * @param element The HTML <img> element to wrap.
   */
  public ImageElement(HTMLImageElement element) {
    super(element);
  }

  /**
   * Sets the src for the image element
   *
   * @param src String image source
   * @return same component
   */
  public ImageElement src(String src) {
    setAttribute("src", src);
    return this;
  }
}
