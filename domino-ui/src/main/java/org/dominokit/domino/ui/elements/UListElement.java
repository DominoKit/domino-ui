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

import elemental2.dom.HTMLUListElement;

/**
 * Represents an HTML
 *
 * <ul>
 *   element wrapper.
 *   <p>The HTML
 *   <ul>
 *     element is used to create an unordered list of items. Each item in the list is represented by
 *     an
 *     <li>(list item) element, which can contain text, images, links, or other HTML elements.
 *         Example usage:
 *         <pre>
 * HTMLUListElement ulElement = ...;  // Obtain a <ul> element from somewhere
 * UListElement ulList = UListElement.of(ulElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/ul">MDN Web Docs (ul)</a>
 */
public class UListElement extends BaseElement<HTMLUListElement, UListElement> {

  /**
   * Creates a new {@link UListElement} instance by wrapping the provided HTML
   *
   * <ul>
   *   element.
   *
   * @param e The HTML
   *     <ul>
   *       element to wrap.
   * @return A new {@link UListElement} instance wrapping the provided element.
   */
  public static UListElement of(HTMLUListElement e) {
    return new UListElement(e);
  }

  /**
   * Constructs a {@link UListElement} instance by wrapping the provided HTML
   *
   * <ul>
   *   element.
   *
   * @param element The HTML
   *     <ul>
   *       element to wrap.
   */
  public UListElement(HTMLUListElement element) {
    super(element);
  }
}
