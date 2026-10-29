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

import elemental2.svg.SVGFEMergeNodeElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class wraps the {@link SVGFEMergeNodeElement}, which corresponds to the {@code
 * <feMergeNode>} SVG element. The {@code feMergeNode} is used within an {@code <feMerge>} element
 * to reference an input image to be composited within the filter. Extending {@link BaseElement},
 * the {@code FEMergeNodeElement} provides a straightforward API for manipulating these merge nodes
 * within SVG documents, facilitated by the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEMergeNodeElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feMergeNode">MDN Web Docs
 *     - SVGFEMergeNodeElement</a>
 */
public class FEMergeNodeElement extends BaseElement<SVGFEMergeNodeElement, FEMergeNodeElement> {

  /**
   * Factory method for creating a new {@code FEMergeNodeElement} instance from an existing {@code
   * SVGFEMergeNodeElement}. This method abstracts the direct construction of objects and is the
   * preferred way to instantiate {@code FEMergeNodeElement} objects within the Domino UI framework.
   *
   * @param e the {@code SVGFEMergeNodeElement} to wrap
   * @return a new instance of {@code FEMergeNodeElement}
   */
  public static FEMergeNodeElement of(SVGFEMergeNodeElement e) {
    return new FEMergeNodeElement(e);
  }

  /**
   * Constructs a new {@code FEMergeNodeElement} by wrapping the provided {@code
   * SVGFEMergeNodeElement}. This constructor is protected to encourage the use of the static
   * factory method {@code of()} for creating new instances, promoting consistency and
   * maintainability within the framework.
   *
   * @param element the {@code SVGFEMergeNodeElement} to be wrapped
   */
  public FEMergeNodeElement(SVGFEMergeNodeElement element) {
    super(element);
  }
}
