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
package org.dominokit.domino.ui.elements.svg;

import elemental2.svg.SVGDescElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class representing a wrapper for the {@link SVGDescElement}, which is an SVG container used to
 * describe the containing element or its children. The {@code DescElement} is often used to provide
 * descriptions accessible to assistive technologies. Extending {@link BaseElement}, this class
 * enables the construction and manipulation of description elements within SVG graphics, following
 * the conventions of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGDescElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/desc">MDN Web Docs -
 *     SVGDescElement</a>
 */
public class DescElement extends BaseElement<SVGDescElement, DescElement> {

  /**
   * Factory method to create a new {@code DescElement} instance from an existing {@code
   * SVGDescElement}. This method abstracts the instantiation process and is the recommended way to
   * generate {@code DescElement} objects within the framework.
   *
   * @param e the {@code SVGDescElement} to wrap
   * @return a new {@code DescElement} instance
   */
  public static DescElement of(SVGDescElement e) {
    return new DescElement(e);
  }

  /**
   * Constructs a new {@code DescElement} that wraps the provided {@code SVGDescElement}. This
   * constructor is protected to encourage the use of the factory method {@code of()} for creating
   * new instances.
   *
   * @param element the {@code SVGDescElement} to be wrapped
   */
  public DescElement(SVGDescElement element) {
    super(element);
  }
}
