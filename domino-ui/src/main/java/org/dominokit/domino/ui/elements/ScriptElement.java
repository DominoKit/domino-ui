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

import elemental2.dom.HTMLScriptElement;

/**
 * Represents an HTML <script> element wrapper.
 *
 * <p>The HTML <script> element is used to embed or reference an executable script within an HTML or
 * XHTML document. This class provides a Java-based way to create, manipulate, and control the
 * behavior of <script> elements in web applications. Example usage:
 *
 * <pre>
 * HTMLScriptElement scriptElement = ...;  // Obtain a <script> element from somewhere
 * ScriptElement script = ScriptElement.of(scriptElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/script">MDN Web Docs
 *     (script)</a>
 */
public class ScriptElement extends BaseElement<HTMLScriptElement, ScriptElement> {

  /**
   * Creates a new {@link ScriptElement} instance by wrapping the provided HTML <script> element.
   *
   * @param e The HTML <script> element to wrap.
   * @return A new {@link ScriptElement} instance wrapping the provided element.
   */
  public static ScriptElement of(HTMLScriptElement e) {
    return new ScriptElement(e);
  }

  /**
   * Constructs a {@link ScriptElement} instance by wrapping the provided HTML <script> element.
   *
   * @param element The HTML <script> element to wrap.
   */
  public ScriptElement(HTMLScriptElement element) {
    super(element);
  }
}
