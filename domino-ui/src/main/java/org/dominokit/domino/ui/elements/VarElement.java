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
 * Represents an HTML <var> element wrapper.
 *
 * <p>The HTML <var> element represents the name of a variable in a mathematical expression or a
 * programming context. It is typically used to format variables or indicate that a particular text
 * or content represents a variable. Example usage:
 *
 * <pre>
 * HTMLElement varElement = ...;  // Obtain a <var> element from somewhere
 * VarElement var = VarElement.of(varElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/var">MDN Web Docs
 *     (var)</a>
 */
public class VarElement extends BaseElement<HTMLElement, VarElement> {

  /**
   * Creates a new {@link VarElement} instance by wrapping the provided HTML <var> element.
   *
   * @param e The HTML <var> element to wrap.
   * @return A new {@link VarElement} instance wrapping the provided element.
   */
  public static VarElement of(HTMLElement e) {
    return new VarElement(e);
  }

  /**
   * Constructs a {@link VarElement} instance by wrapping the provided HTML <var> element.
   *
   * @param element The HTML <var> element to wrap.
   */
  public VarElement(HTMLElement element) {
    super(element);
  }
}
