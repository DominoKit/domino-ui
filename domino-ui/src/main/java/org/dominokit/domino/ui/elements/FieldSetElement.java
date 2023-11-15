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

import elemental2.dom.HTMLFieldSetElement;

/**
 * Represents a <fieldset> HTML element wrapper.
 *
 * <p>The <fieldset> tag is used to group related form elements within a web form. This class
 * provides a convenient way to create, manipulate, and control the behavior of <fieldset> elements,
 * making it easier to use them in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLFieldSetElement fieldSetElement = ...;  // Obtain a <fieldset> element from somewhere
 * FieldSetElement fieldSet = FieldSetElement.of(fieldSetElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/fieldset">MDN Web Docs
 *     (fieldset element)</a>
 */
public class FieldSetElement extends BaseElement<HTMLFieldSetElement, FieldSetElement> {

  /**
   * Creates a new {@link FieldSetElement} instance by wrapping the provided HTML <fieldset>
   * element.
   *
   * @param e The HTML <fieldset> element.
   * @return A new {@link FieldSetElement} instance wrapping the provided element.
   */
  public static FieldSetElement of(HTMLFieldSetElement e) {
    return new FieldSetElement(e);
  }

  /**
   * Constructs a {@link FieldSetElement} instance by wrapping the provided HTML <fieldset> element.
   *
   * @param element The HTML <fieldset> element to wrap.
   */
  public FieldSetElement(HTMLFieldSetElement element) {
    super(element);
  }
}
