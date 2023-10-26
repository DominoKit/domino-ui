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

import elemental2.dom.HTMLFormElement;

/**
 * Represents a <form> HTML element wrapper.
 *
 * <p>The <form> tag is used to create an HTML form for user input. Forms are commonly used for
 * collecting user input, such as login forms, registration forms, and search forms. This class
 * provides a convenient way to create, manipulate, and control the behavior of <form> elements,
 * making it easier to use them in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLFormElement formElement = ...;  // Obtain a <form> element from somewhere
 * FormElement form = FormElement.of(formElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/form">MDN Web Docs (form
 *     element)</a>
 */
public class FormElement extends BaseElement<HTMLFormElement, FormElement> {

  /**
   * Creates a new {@link FormElement} instance by wrapping the provided HTML <form> element.
   *
   * @param e The HTML <form> element.
   * @return A new {@link FormElement} instance wrapping the provided element.
   */
  public static FormElement of(HTMLFormElement e) {
    return new FormElement(e);
  }

  /**
   * Constructs a {@link FormElement} instance by wrapping the provided HTML <form> element.
   *
   * @param element The HTML <form> element to wrap.
   */
  public FormElement(HTMLFormElement element) {
    super(element);
  }
}
