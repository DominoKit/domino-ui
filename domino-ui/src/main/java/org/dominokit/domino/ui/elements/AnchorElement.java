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

import static java.util.Objects.isNull;

import elemental2.dom.HTMLAnchorElement;

/**
 * AnchorElement class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class AnchorElement extends BaseElement<HTMLAnchorElement, AnchorElement> {
  /**
   * of.
   *
   * @param e a {@link elemental2.dom.HTMLAnchorElement} object
   * @return a {@link org.dominokit.domino.ui.elements.AnchorElement} object
   */
  public static AnchorElement of(HTMLAnchorElement e) {
    return new AnchorElement(e);
  }

  /**
   * Constructor for AnchorElement.
   *
   * @param element a {@link elemental2.dom.HTMLAnchorElement} object
   */
  public AnchorElement(HTMLAnchorElement element) {
    super(element);
  }

  public AnchorElement setHref(String href) {
    if (isNull(href) || href.trim().isEmpty()) {
      removeAttribute("href");
    } else {
      setAttribute("href", href);
    }
    return this;
  }

  public AnchorElement removeHref() {
    removeAttribute("href");
    return this;
  }
}
