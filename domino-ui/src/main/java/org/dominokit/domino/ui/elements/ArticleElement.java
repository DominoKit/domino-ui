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

import elemental2.dom.HTMLElement;

/**
 * Represents an article HTML element (`<article>`) wrapper.
 *
 * <p>The class provides a convenient way to create, manipulate, and control the behavior of article
 * HTML elements. Example usage:
 *
 * <pre>
 * HTMLElement htmlElement = ...;  // Obtain an article element from somewhere
 * ArticleElement articleElement = ArticleElement.of(htmlElement);
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/article">MDN Web Docs
 *     (article element)</a>
 */
public class ArticleElement extends BaseElement<HTMLElement, ArticleElement> {

  /**
   * Creates a new {@link ArticleElement} by wrapping the provided article HTML element.
   *
   * @param e The article HTML element.
   * @return A new {@link ArticleElement} that wraps the provided element.
   */
  public static ArticleElement of(HTMLElement e) {
    return new ArticleElement(e);
  }

  /**
   * Constructs an {@link ArticleElement} by wrapping the provided article HTML element.
   *
   * @param element The article HTML element to wrap.
   */
  public ArticleElement(HTMLElement element) {
    super(element);
  }
}
