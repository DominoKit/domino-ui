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

import elemental2.svg.SVGComponentTransferFunctionElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGComponentTransferFunctionElement}, which represents the
 * feComponentTransfer's <funcR>, <funcG>, <funcB>, and <funcA> primitive SVG elements used for
 * component-wise remapping of data in color channels. This class extends {@link BaseElement} to
 * integrate with the Domino UI framework, providing a fluent interface for manipulating these
 * functions within an SVG.
 *
 * @see BaseElement
 * @see SVGComponentTransferFunctionElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feComponentTransfer">MDN
 *     Web Docs - SVGComponentTransferFunctionElement</a>
 */
public class ComponentTransferFunctionElement
    extends BaseElement<SVGComponentTransferFunctionElement, ComponentTransferFunctionElement> {

  /**
   * Factory method for creating a new {@code ComponentTransferFunctionElement} instance by wrapping
   * an existing {@code SVGComponentTransferFunctionElement}. This provides an abstracted way to
   * instantiate {@code ComponentTransferFunctionElement} objects, preferred within the Domino UI
   * framework.
   *
   * @param e the {@code SVGComponentTransferFunctionElement} to wrap
   * @return a new instance of {@code ComponentTransferFunctionElement}
   */
  public static ComponentTransferFunctionElement of(SVGComponentTransferFunctionElement e) {
    return new ComponentTransferFunctionElement(e);
  }

  /**
   * Constructs a new {@code ComponentTransferFunctionElement} that encapsulates the specified
   * {@code SVGComponentTransferFunctionElement}. This constructor is protected to encourage the use
   * of the factory method {@code of()} for object creation.
   *
   * @param element the {@code SVGComponentTransferFunctionElement} to be wrapped
   */
  public ComponentTransferFunctionElement(SVGComponentTransferFunctionElement element) {
    super(element);
  }
}
