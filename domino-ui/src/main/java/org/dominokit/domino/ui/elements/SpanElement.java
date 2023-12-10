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

import elemental2.dom.HTMLElement;

/**
 * Represents an HTML <span> element wrapper.
 *
 * <p>The HTML <span> element is a generic inline container for phrasing content, which does not
 * inherently represent anything. It can be used to group elements for styling purposes or to apply
 * CSS styles and classes to a specific portion of text. This class provides a Java-based way to
 * create, manipulate, and control the behavior of <span> elements in web applications. Example
 * usage:
 *
 * <pre>
 * HTMLElement spanElement = ...;  // Obtain a <span> element from somewhere
 * SpanElement span = SpanElement.of(spanElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/span">MDN Web Docs
 *     (span)</a>
 */
public class SpanElement extends BaseElement<HTMLElement, SpanElement> {

  /**
   * Creates a new {@link SpanElement} instance by wrapping the provided HTML <span> element.
   *
   * @param e The HTML <span> element to wrap.
   * @return A new {@link SpanElement} instance wrapping the provided element.
   */
  public static SpanElement of(HTMLElement e) {
    return new SpanElement(e);
  }

  /**
   * Constructs a {@link SpanElement} instance by wrapping the provided HTML <span> element.
   *
   * @param element The HTML <span> element to wrap.
   */
  public SpanElement(HTMLElement element) {
    super(element);
  }
}
