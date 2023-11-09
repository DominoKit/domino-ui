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

import elemental2.dom.HTMLSelectElement;

/**
 * Represents an HTML <select> element wrapper.
 *
 * <p>The HTML <select> element is used to create a drop-down list of options that users can select
 * from. It allows users to choose one or more options from the list, depending on the select
 * element's configuration. This class provides a Java-based way to create, manipulate, and control
 * the behavior of <select> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLSelectElement selectElement = ...;  // Obtain a <select> element from somewhere
 * SelectElement select = SelectElement.of(selectElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/select">MDN Web Docs
 *     (select)</a>
 */
public class SelectElement extends BaseElement<HTMLSelectElement, SelectElement> {

  /**
   * Creates a new {@link SelectElement} instance by wrapping the provided HTML <select> element.
   *
   * @param e The HTML <select> element to wrap.
   * @return A new {@link SelectElement} instance wrapping the provided element.
   */
  public static SelectElement of(HTMLSelectElement e) {
    return new SelectElement(e);
  }

  /**
   * Constructs a {@link SelectElement} instance by wrapping the provided HTML <select> element.
   *
   * @param element The HTML <select> element to wrap.
   */
  public SelectElement(HTMLSelectElement element) {
    super(element);
  }
}
