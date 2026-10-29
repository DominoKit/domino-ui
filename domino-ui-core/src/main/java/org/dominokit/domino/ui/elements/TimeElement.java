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

import elemental2.dom.HTMLElement;

/**
 * Represents an HTML <time> element wrapper.
 *
 * <p>The HTML <time> element represents a specific period in time or a range of time. It is used to
 * define the machine-readable date and time format for web content. This class provides a
 * Java-based way to create, manipulate, and control the behavior of <time> elements in web
 * applications. Example usage:
 *
 * <pre>
 * HTMLElement timeElement = ...;  // Obtain a <time> element from somewhere
 * TimeElement time = TimeElement.of(timeElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/time">MDN Web Docs
 *     (time)</a>
 */
public class TimeElement extends BaseElement<HTMLElement, TimeElement> {

  /**
   * Creates a new {@link TimeElement} instance by wrapping the provided HTML <time> element.
   *
   * @param e The HTML <time> element to wrap.
   * @return A new {@link TimeElement} instance wrapping the provided element.
   */
  public static TimeElement of(HTMLElement e) {
    return new TimeElement(e);
  }

  /**
   * Constructs a {@link TimeElement} instance by wrapping the provided HTML <time> element.
   *
   * @param element The HTML <time> element to wrap.
   */
  public TimeElement(HTMLElement element) {
    super(element);
  }
}
