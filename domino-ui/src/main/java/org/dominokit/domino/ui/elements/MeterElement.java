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

import elemental2.dom.HTMLMeterElement;

/**
 * Represents an HTML <meter> element wrapper.
 *
 * <p>The HTML <meter> element represents a scalar measurement within a known range or a fractional
 * value. This class provides a convenient way to create, manipulate, and control the behavior of
 * <meter> elements in Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLMeterElement meterElement = ...;  // Obtain a <meter> element from somewhere
 * MeterElement meter = MeterElement.of(meterElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/meter">MDN Web Docs
 *     (meter)</a>
 */
public class MeterElement extends BaseElement<HTMLMeterElement, MeterElement> {

  /**
   * Creates a new {@link MeterElement} instance by wrapping the provided HTML <meter> element.
   *
   * @param e The HTML <meter> element to wrap.
   * @return A new {@link MeterElement} instance wrapping the provided element.
   */
  public static MeterElement of(HTMLMeterElement e) {
    return new MeterElement(e);
  }

  /**
   * Constructs a {@link MeterElement} instance by wrapping the provided HTML <meter> element.
   *
   * @param element The HTML <meter> element to wrap.
   */
  public MeterElement(HTMLMeterElement element) {
    super(element);
  }
}
