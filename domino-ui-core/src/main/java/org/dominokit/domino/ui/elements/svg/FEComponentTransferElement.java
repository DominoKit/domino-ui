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

import elemental2.svg.SVGFEComponentTransferElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * A class that serves as a wrapper for the {@link SVGFEComponentTransferElement}, which corresponds
 * to the {@code <feComponentTransfer>} SVG element. This element allows for per-channel operations
 * to be performed on the input graphics to achieve a variety of graphical effects. By extending the
 * {@link BaseElement}, the {@code FEComponentTransferElement} class facilitates the use of
 * component transfer functionalities within the Domino UI framework's SVG manipulation
 * capabilities.
 *
 * @see BaseElement
 * @see SVGFEComponentTransferElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feComponentTransfer">MDN
 *     Web Docs - SVGFEComponentTransferElement</a>
 */
public class FEComponentTransferElement
    extends BaseElement<SVGFEComponentTransferElement, FEComponentTransferElement> {

  /**
   * Factory method for creating a new {@code FEComponentTransferElement} instance from an existing
   * {@code SVGFEComponentTransferElement}. This method abstracts the direct construction of
   * objects, providing a more convenient approach to creating {@code FEComponentTransferElement}
   * instances within the Domino UI framework.
   *
   * @param e the {@code SVGFEComponentTransferElement} to wrap
   * @return a new {@code FEComponentTransferElement} instance
   */
  public static FEComponentTransferElement of(SVGFEComponentTransferElement e) {
    return new FEComponentTransferElement(e);
  }

  /**
   * Constructs a new {@code FEComponentTransferElement} by encapsulating the specified {@code
   * SVGFEComponentTransferElement}. This constructor is protected to encourage the use of the
   * factory method {@code of()} for creating instances, which ensures a consistent construction
   * methodology across the framework.
   *
   * @param element the {@code SVGFEComponentTransferElement} to be wrapped
   */
  public FEComponentTransferElement(SVGFEComponentTransferElement element) {
    super(element);
  }
}
