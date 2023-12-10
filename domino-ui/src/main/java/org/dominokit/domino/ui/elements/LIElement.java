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

import elemental2.dom.HTMLLIElement;

/**
 * Represents an HTML
 * <li>(list item) element wrapper.
 *
 *     <p>The HTML
 * <li>element represents a list item within an ordered list (
 *
 *     <ol>
 *       ), an unordered list (
 *       <ul>
 *         ), or a menu list (<menu>). This class provides a convenient way to create, manipulate,
 *         and control the behavior of
 *         <li>elements in Java-based web applications. Example usage:
 *             <pre>
 * HTMLLIElement liElement = ...;  // Obtain an <li> element from somewhere
 * LIElement li = LIElement.of(liElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/li">MDN Web Docs (li)</a>
 */
public class LIElement extends BaseElement<HTMLLIElement, LIElement> {

  /**
   * Creates a new {@link LIElement} instance by wrapping the provided HTML
   * <li>element.
   *
   * @param e The HTML
   *     <li>element to wrap.
   * @return A new {@link LIElement} instance wrapping the provided element.
   */
  public static LIElement of(HTMLLIElement e) {
    return new LIElement(e);
  }

  /**
   * Constructs a {@link LIElement} instance by wrapping the provided HTML
   * <li>element.
   *
   * @param element The HTML
   *     <li>element to wrap.
   */
  public LIElement(HTMLLIElement element) {
    super(element);
  }
}
