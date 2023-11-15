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

import elemental2.dom.HTMLOListElement;

/**
 * Represents an HTML
 *
 * <ol>
 *   (ordered list) element wrapper.
 *   <p>The HTML
 *   <ol>
 *     element is used to create ordered lists, where list items are numbered sequentially. This
 *     class provides a convenient way to create, manipulate, and control the behavior of
 *     <ol>
 *       elements in Java-based web applications. Example usage:
 *       <pre>{@code
 * HTMLOListElement olElement = ...;  // Obtain an <ol> element from somewhere
 * OListElement olList = OListElement.of(olElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/ol">MDN Web Docs (ol)</a>
 */
public class OListElement extends BaseElement<HTMLOListElement, OListElement> {

  /**
   * Creates a new {@link OListElement} instance by wrapping the provided HTML
   *
   * <ol>
   *   element.
   *
   * @param e The HTML
   *     <ol>
   *       element to wrap.
   * @return A new {@link OListElement} instance wrapping the provided element.
   */
  public static OListElement of(HTMLOListElement e) {
    return new OListElement(e);
  }

  /**
   * Constructs a {@link OListElement} instance by wrapping the provided HTML
   *
   * <ol>
   *   element.
   *
   * @param element The HTML
   *     <ol>
   *       element to wrap.
   */
  public OListElement(HTMLOListElement element) {
    super(element);
  }
}
