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

import elemental2.dom.HTMLLabelElement;

/**
 * Represents an HTML <label> element wrapper.
 *
 * <p>The HTML <label> element represents a label for an <input>, <textarea>, or <button> element.
 * This class provides a convenient way to create, manipulate, and control the behavior of <label>
 * elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLLabelElement labelElement = ...;  // Obtain a <label> element from somewhere
 * LabelElement label = LabelElement.of(labelElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/label">MDN Web Docs
 *     (label)</a>
 */
public class LabelElement extends BaseElement<HTMLLabelElement, LabelElement> {

  /**
   * Creates a new {@link LabelElement} instance by wrapping the provided HTML <label> element.
   *
   * @param e The HTML <label> element to wrap.
   * @return A new {@link LabelElement} instance wrapping the provided element.
   */
  public static LabelElement of(HTMLLabelElement e) {
    return new LabelElement(e);
  }

  /**
   * Constructs a {@link LabelElement} instance by wrapping the provided HTML <label> element.
   *
   * @param element The HTML <label> element to wrap.
   */
  public LabelElement(HTMLLabelElement element) {
    super(element);
  }
}
