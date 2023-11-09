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

import elemental2.dom.HTMLTextAreaElement;

/**
 * Represents an HTML <textarea> element wrapper.
 *
 * <p>The HTML <textarea> element defines a multi-line text input control that allows users to enter
 * plain text or multiline text data. It is often used within HTML forms to collect user input. The
 * content inside a <textarea> element is typically displayed in a multiline text box where users
 * can enter or edit text. This class provides a Java-based way to create, manipulate, and control
 * the behavior of <textarea> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLTextAreaElement textareaElement = ...;  // Obtain a <textarea> element from somewhere
 * TextAreaElement textarea = TextAreaElement.of(textareaElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/textarea">MDN Web Docs
 *     (textarea)</a>
 */
public class TextAreaElement extends BaseElement<HTMLTextAreaElement, TextAreaElement> {

  /**
   * Creates a new {@link TextAreaElement} instance by wrapping the provided HTML <textarea>
   * element.
   *
   * @param e The HTML <textarea> element to wrap.
   * @return A new {@link TextAreaElement} instance wrapping the provided element.
   */
  public static TextAreaElement of(HTMLTextAreaElement e) {
    return new TextAreaElement(e);
  }

  /**
   * Constructs a {@link TextAreaElement} instance by wrapping the provided HTML <textarea> element.
   *
   * @param element The HTML <textarea> element to wrap.
   */
  public TextAreaElement(HTMLTextAreaElement element) {
    super(element);
  }
}
