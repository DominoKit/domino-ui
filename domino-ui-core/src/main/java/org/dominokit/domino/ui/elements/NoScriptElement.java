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
 * Represents an HTML <noscript> element wrapper.
 *
 * <p>The HTML <noscript> element defines a section of HTML to be inserted if a script type on the
 * page is unsupported or if scripting is currently turned off in the browser. This class provides a
 * convenient way to create, manipulate, and control the behavior of <noscript> elements in
 * Java-based web applications. Example usage:
 *
 * <pre>{@code
 * HTMLElement noScriptElement = ...;  // Obtain a <noscript> element from somewhere
 * NoScriptElement noScript = NoScriptElement.of(noScriptElement);
 * }</pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/noscript">MDN Web Docs
 *     (noscript)</a>
 */
public class NoScriptElement extends BaseElement<HTMLElement, NoScriptElement> {

  /**
   * Creates a new {@link NoScriptElement} instance by wrapping the provided HTML <noscript>
   * element.
   *
   * @param e The HTML <noscript> element to wrap.
   * @return A new {@link NoScriptElement} instance wrapping the provided element.
   */
  public static NoScriptElement of(HTMLElement e) {
    return new NoScriptElement(e);
  }

  /**
   * Constructs a {@link NoScriptElement} instance by wrapping the provided HTML <noscript> element.
   *
   * @param element The HTML <noscript> element to wrap.
   */
  public NoScriptElement(HTMLElement element) {
    super(element);
  }
}
