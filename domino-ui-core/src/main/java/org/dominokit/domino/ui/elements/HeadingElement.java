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

import elemental2.dom.HTMLHeadingElement;

/**
 * Represents an HTML heading element (e.g.,
 *
 * <h1>,
 *
 * <h2>,
 *
 * <h3>,
 *
 * <h4>,
 *
 * <h5>,
 *
 * <h6>) wrapper.
 *
 * <p>HTML heading elements are used to define headings for sections of a document or webpage. They
 * are used to provide structure and hierarchy to the content. This class provides a convenient way
 * to create, manipulate, and control the behavior of heading elements in Java-based web
 * applications. Example usage:
 *
 * <pre>
 * HTMLHeadingElement headingElement = ...;  // Obtain an HTML heading element from somewhere
 * HeadingElement heading = HeadingElement.of(headingElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/Heading_Elements">MDN Web
 *     Docs (Heading Elements)</a>
 */
public class HeadingElement extends BaseElement<HTMLHeadingElement, HeadingElement> {

  /**
   * Creates a new {@link HeadingElement} instance by wrapping the provided HTML heading element.
   *
   * @param e The HTML heading element (e.g.,
   *     <h1>,
   *     <h2>,
   *     <h3>,
   *     <h4>,
   *     <h5>,
   *     <h6>).
   * @return A new {@link HeadingElement} instance wrapping the provided element.
   */
  public static HeadingElement of(HTMLHeadingElement e) {
    return new HeadingElement(e);
  }

  /**
   * Constructs a {@link HeadingElement} instance by wrapping the provided HTML heading element.
   *
   * @param element The HTML heading element (e.g.,
   *     <h1>,
   *     <h2>,
   *     <h3>,
   *     <h4>,
   *     <h5>,
   *     <h6>) to wrap.
   */
  public HeadingElement(HTMLHeadingElement element) {
    super(element);
  }
}
