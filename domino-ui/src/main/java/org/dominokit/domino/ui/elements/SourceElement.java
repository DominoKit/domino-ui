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

import elemental2.dom.HTMLSourceElement;

/**
 * Represents an HTML <source> element wrapper.
 *
 * <p>The HTML <source> element is used to specify multiple media resources for media elements like
 * <audio> and <video>. It allows you to specify different video or audio files to be used based on
 * factors such as the browser's video codec support or screen size. This class provides a
 * Java-based way to create, manipulate, and control the behavior of <source> elements in web
 * applications. Example usage:
 *
 * <pre>
 * HTMLSourceElement sourceElement = ...;  // Obtain a <source> element from somewhere
 * SourceElement source = SourceElement.of(sourceElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/source">MDN Web Docs
 *     (source)</a>
 */
public class SourceElement extends BaseElement<HTMLSourceElement, SourceElement> {

  /**
   * Creates a new {@link SourceElement} instance by wrapping the provided HTML <source> element.
   *
   * @param e The HTML <source> element to wrap.
   * @return A new {@link SourceElement} instance wrapping the provided element.
   */
  public static SourceElement of(HTMLSourceElement e) {
    return new SourceElement(e);
  }

  /**
   * Constructs a {@link SourceElement} instance by wrapping the provided HTML <source> element.
   *
   * @param element The HTML <source> element to wrap.
   */
  public SourceElement(HTMLSourceElement element) {
    super(element);
  }
}
