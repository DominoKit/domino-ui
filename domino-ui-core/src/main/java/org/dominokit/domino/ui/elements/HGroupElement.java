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
 * Represents an HTML HGroup element (<hgroup>) wrapper.
 *
 * <p>The HTML <hgroup> element represents the heading of a section. It groups a set of
 *
 * <h1>–
 *
 * <h6>elements and displays them as one single heading. This class provides a convenient way to
 * create, manipulate, and control the behavior of <hgroup> elements in Java-based web applications.
 * Example usage:
 *
 * <pre>
 * HTMLElement hgroupElement = ...;  // Obtain an <hgroup> element from somewhere
 * HGroupElement hgroup = HGroupElement.of(hgroupElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/hgroup">MDN Web Docs
 *     (hgroup)</a>
 */
public class HGroupElement extends BaseElement<HTMLElement, HGroupElement> {

  /**
   * Creates a new {@link HGroupElement} instance by wrapping the provided HTML <hgroup> element.
   *
   * @param e The HTML <hgroup> element.
   * @return A new {@link HGroupElement} instance wrapping the provided element.
   */
  public static HGroupElement of(HTMLElement e) {
    return new HGroupElement(e);
  }

  /**
   * Constructs a {@link HGroupElement} instance by wrapping the provided HTML <hgroup> element.
   *
   * @param element The HTML <hgroup> element to wrap.
   */
  public HGroupElement(HTMLElement element) {
    super(element);
  }
}
