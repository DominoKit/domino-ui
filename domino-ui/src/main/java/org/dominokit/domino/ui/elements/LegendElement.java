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

import elemental2.dom.HTMLLegendElement;

/**
 * Represents an HTML <legend> element wrapper.
 *
 * <p>The HTML <legend> element represents a caption for the content of a <fieldset> element. This
 * class provides a convenient way to create, manipulate, and control the behavior of <legend>
 * elements in Java-based web applications. Example usage:
 *
 * <pre>
 * HTMLLegendElement legendElement = ...;  // Obtain a <legend> element from somewhere
 * LegendElement legend = LegendElement.of(legendElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/legend">MDN Web Docs
 *     (legend)</a>
 */
public class LegendElement extends BaseElement<HTMLLegendElement, LegendElement> {

  /**
   * Creates a new {@link LegendElement} instance by wrapping the provided HTML <legend> element.
   *
   * @param e The HTML <legend> element to wrap.
   * @return A new {@link LegendElement} instance wrapping the provided element.
   */
  public static LegendElement of(HTMLLegendElement e) {
    return new LegendElement(e);
  }

  /**
   * Constructs a {@link LegendElement} instance by wrapping the provided HTML <legend> element.
   *
   * @param element The HTML <legend> element to wrap.
   */
  public LegendElement(HTMLLegendElement element) {
    super(element);
  }
}
