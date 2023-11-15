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

import elemental2.dom.HTMLTableSectionElement;

/**
 * Represents an HTML <thead> element wrapper.
 * <p>
 * The HTML <thead> element defines a header for an HTML <table> element. It contains information about the table's
 * column headers. Typically, the content inside a <thead> element consists of one or more <tr> (table row) elements,
 * each containing <th> (table header cell) elements representing the column headers.
 * This class provides a Java-based way to create, manipulate, and control the behavior of <thead> elements in web
 * applications.
 * </p>
 *
 * Example usage:
 * <pre>
 * {@code
 * HTMLTableSectionElement theadElement = ...;  // Obtain a <thead> element from somewhere
 * THeadElement thead = THeadElement.of(theadElement);
 * }
 * </pre>
 *
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/HTML/Element/thead">MDN Web Docs (thead)</a>
 */
public class THeadElement extends BaseElement<HTMLTableSectionElement, THeadElement> {

  /**
   * Creates a new {@link THeadElement} instance by wrapping the provided HTML <thead> element.
   *
   * @param e The HTML <thead> element to wrap.
   * @return A new {@link THeadElement} instance wrapping the provided element.
   */
  public static THeadElement of(HTMLTableSectionElement e) {
    return new THeadElement(e);
  }

  /**
   * Constructs a {@link THeadElement} instance by wrapping the provided HTML <thead> element.
   *
   * @param element The HTML <thead> element to wrap.
   */
  public THeadElement(HTMLTableSectionElement element) {
    super(element);
  }
}
