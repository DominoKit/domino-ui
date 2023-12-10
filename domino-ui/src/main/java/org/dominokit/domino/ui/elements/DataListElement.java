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

import elemental2.dom.HTMLDataListElement;

/**
 * Represents a `<datalist>` HTML element wrapper.
 *
 * <p>The `<datalist>` tag specifies a list of pre-defined options for an `<input>` element. Users
 * will see a drop-down list of pre-defined options as they input data. This class provides a
 * convenient way to create, manipulate, and control the behavior of `<datalist>` elements, making
 * it easier to use them in Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLDataListElement htmlElement = ...;  // Obtain a <datalist> element from somewhere
 * DataListElement dataListElement = DataListElement.of(htmlElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/datalist">MDN Web Docs
 *     (datalist element)</a>
 */
public class DataListElement extends BaseElement<HTMLDataListElement, DataListElement> {

  /**
   * Creates a new {@link DataListElement} instance by wrapping the provided HTML `<datalist>`
   * element.
   *
   * @param e The HTML `<datalist>` element.
   * @return A new {@link DataListElement} instance wrapping the provided element.
   */
  public static DataListElement of(HTMLDataListElement e) {
    return new DataListElement(e);
  }

  /**
   * Constructs a {@link DataListElement} instance by wrapping the provided HTML `<datalist>`
   * element.
   *
   * @param element The HTML `<datalist>` element to wrap.
   */
  public DataListElement(HTMLDataListElement element) {
    super(element);
  }
}
