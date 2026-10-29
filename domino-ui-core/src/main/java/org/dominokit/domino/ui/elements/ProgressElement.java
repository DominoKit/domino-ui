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

import elemental2.dom.HTMLProgressElement;

/**
 * Represents an HTML <progress> element wrapper.
 *
 * <p>The HTML <progress> element is used to view the completion progress of a task. It is often
 * used to represent the progress of a download/upload operation, file processing, or any task that
 * has a measurable progress. This class provides a Java-based way to create, manipulate, and
 * control the behavior of <progress> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLProgressElement progressElement = ...;  // Obtain a <progress> element from somewhere
 * ProgressElement progress = ProgressElement.of(progressElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/progress">MDN Web Docs
 *     (progress)</a>
 */
public class ProgressElement extends BaseElement<HTMLProgressElement, ProgressElement> {

  /**
   * Creates a new {@link ProgressElement} instance by wrapping the provided HTML <progress>
   * element.
   *
   * @param e The HTML <progress> element to wrap.
   * @return A new {@link ProgressElement} instance wrapping the provided element.
   */
  public static ProgressElement of(HTMLProgressElement e) {
    return new ProgressElement(e);
  }

  /**
   * Constructs a {@link ProgressElement} instance by wrapping the provided HTML <progress> element.
   *
   * @param element The HTML <progress> element to wrap.
   */
  public ProgressElement(HTMLProgressElement element) {
    super(element);
  }
}
