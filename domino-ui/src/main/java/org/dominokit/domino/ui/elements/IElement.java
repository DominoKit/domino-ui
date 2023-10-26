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

import elemental2.dom.HTMLElement;

/**
 * Represents an HTML IElement element (<i>) wrapper.
 *
 * <p>The HTML <i> element represents a span of text in an alternate voice or mood, or otherwise
 * offset from the normal prose in a manner indicating a different quality of text. This class
 * provides a convenient way to create, manipulate, and control the behavior of <i> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLElement iElement = ...;  // Obtain an <i> element from somewhere
 * IElement i = IElement.of(iElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/i">MDN Web Docs (i)</a>
 */
public class IElement extends BaseElement<HTMLElement, IElement> {

  /**
   * Creates a new {@link IElement} instance by wrapping the provided HTML <i> element.
   *
   * @param e The HTML <i> element.
   * @return A new {@link IElement} instance wrapping the provided element.
   */
  public static IElement of(HTMLElement e) {
    return new IElement(e);
  }

  /**
   * Constructs a {@link IElement} instance by wrapping the provided HTML <i> element.
   *
   * @param element The HTML <i> element to wrap.
   */
  public IElement(HTMLElement element) {
    super(element);
  }
}
