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

import elemental2.dom.HTMLParamElement;

/**
 * Represents an HTML <param> element wrapper.
 *
 * <p>The HTML <param> element is used to define parameters for an <object> element. It provides
 * additional information about the object, such as its source, width, height, and more. This class
 * allows you to create, manipulate, and control the behavior of <param> elements in Java-based web
 * applications. Example usage:
 *
 * <pre>{@code
 * HTMLParamElement paramElement = ...;  // Obtain a <param> element from somewhere
 * ParamElement param = ParamElement.of(paramElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/param">MDN Web Docs
 *     (param)</a>
 */
public class ParamElement extends BaseElement<HTMLParamElement, ParamElement> {

  /**
   * Creates a new {@link ParamElement} instance by wrapping the provided HTML <param> element.
   *
   * @param e The HTML <param> element to wrap.
   * @return A new {@link ParamElement} instance wrapping the provided element.
   */
  public static ParamElement of(HTMLParamElement e) {
    return new ParamElement(e);
  }

  /**
   * Constructs a {@link ParamElement} instance by wrapping the provided HTML <param> element.
   *
   * @param element The HTML <param> element to wrap.
   */
  public ParamElement(HTMLParamElement element) {
    super(element);
  }
}
