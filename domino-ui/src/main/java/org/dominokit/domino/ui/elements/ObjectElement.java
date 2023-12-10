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

import elemental2.dom.HTMLObjectElement;

/**
 * Represents an HTML <object> element wrapper.
 *
 * <p>The HTML <object> element is used to embed external resources such as images, videos, audio,
 * or other multimedia content into an HTML document. This class provides a convenient way to
 * create, manipulate, and control the behavior of <object> elements in Java-based web applications.
 * Example usage:
 *
 * <pre>
 * HTMLObjectElement objectElement = ...;  // Obtain an <object> element from somewhere
 * ObjectElement object = ObjectElement.of(objectElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/object">MDN Web Docs
 *     (object)</a>
 */
public class ObjectElement extends BaseElement<HTMLObjectElement, ObjectElement> {

  /**
   * Creates a new {@link ObjectElement} instance by wrapping the provided HTML <object> element.
   *
   * @param e The HTML <object> element to wrap.
   * @return A new {@link ObjectElement} instance wrapping the provided element.
   */
  public static ObjectElement of(HTMLObjectElement e) {
    return new ObjectElement(e);
  }

  /**
   * Constructs a {@link ObjectElement} instance by wrapping the provided HTML <object> element.
   *
   * @param element The HTML <object> element to wrap.
   */
  public ObjectElement(HTMLObjectElement element) {
    super(element);
  }
}
