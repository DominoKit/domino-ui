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
 * Represents an HTML <u> element wrapper.
 *
 * <p>The HTML <u> element is used to render text with an underline. However, it's important to note
 * that the use of underlines for non-hyperlink text is generally discouraged in modern web design,
 * as it can be confusing for users who may mistake underlined text for hyperlinks. It's recommended
 * to use CSS styles to achieve underlining or other text formatting effects instead. Example usage:
 *
 * <pre>
 * HTMLElement uElement = ...;  // Obtain a <u> element from somewhere
 * UElement u = UElement.of(uElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/u">MDN Web Docs (u)</a>
 */
public class UElement extends BaseElement<HTMLElement, UElement> {

  /**
   * Creates a new {@link UElement} instance by wrapping the provided HTML <u> element.
   *
   * @param e The HTML <u> element to wrap.
   * @return A new {@link UElement} instance wrapping the provided element.
   */
  public static UElement of(HTMLElement e) {
    return new UElement(e);
  }

  /**
   * Constructs a {@link UElement} instance by wrapping the provided HTML <u> element.
   *
   * @param element The HTML <u> element to wrap.
   */
  public UElement(HTMLElement element) {
    super(element);
  }
}
