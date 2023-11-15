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
 * Represents an HTML <section> element wrapper.
 *
 * <p>The HTML <section> element represents a thematic grouping of content, and typically contains a
 * heading. It is used to organize the content on a webpage into sections, chapters, or other
 * thematic groupings. This class provides a Java-based way to create, manipulate, and control the
 * behavior of <section> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLElement sectionElement = ...;  // Obtain a <section> element from somewhere
 * SectionElement section = SectionElement.of(sectionElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/section">MDN Web Docs
 *     (section)</a>
 */
public class SectionElement extends BaseElement<HTMLElement, SectionElement> {

  /**
   * Creates a new {@link SectionElement} instance by wrapping the provided HTML <section> element.
   *
   * @param e The HTML <section> element to wrap.
   * @return A new {@link SectionElement} instance wrapping the provided element.
   */
  public static SectionElement of(HTMLElement e) {
    return new SectionElement(e);
  }

  /**
   * Constructs a {@link SectionElement} instance by wrapping the provided HTML <section> element.
   *
   * @param element The HTML <section> element to wrap.
   */
  public SectionElement(HTMLElement element) {
    super(element);
  }
}
