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

import elemental2.svg.SVGMetadataElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGMetadataElement}, which represents an SVG
 * metadata element. The {@code MetadataElement} class allows you to work with SVG metadata within
 * the Domino UI framework, making it easier to create and manipulate metadata elements in SVG
 * graphics.
 *
 * @see BaseElement
 * @see SVGMetadataElement
 */
public class MetadataElement extends BaseElement<SVGMetadataElement, MetadataElement> {

  /**
   * Factory method for creating a new {@code MetadataElement} instance from an existing {@code
   * SVGMetadataElement}. This method provides a standardized way of wrapping {@code
   * SVGMetadataElement} objects within the Domino UI framework, promoting a consistent object
   * creation pattern.
   *
   * @param e the {@code SVGMetadataElement} to wrap
   * @return a new instance of {@code MetadataElement}
   */
  public static MetadataElement of(SVGMetadataElement e) {
    return new MetadataElement(e);
  }

  /**
   * Constructs a new {@code MetadataElement} by encapsulating the provided {@code
   * SVGMetadataElement}. The constructor is protected to encourage the use of the static factory
   * method {@code of()} for creating new instances, ensuring uniformity across the framework.
   *
   * @param element the {@code SVGMetadataElement} to be wrapped
   */
  public MetadataElement(SVGMetadataElement element) {
    super(element);
  }
}
