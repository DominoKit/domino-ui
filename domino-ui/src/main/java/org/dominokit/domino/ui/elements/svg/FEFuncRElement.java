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

import elemental2.svg.SVGFEFuncRElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * Encapsulates the {@link SVGFEFuncRElement}, linked to the {@code <feFuncR>} SVG element. This
 * element targets the red component within an {@code <feComponentTransfer>} filter primitive,
 * enabling detailed adjustment of the red channel of an image. The class extends {@link
 * BaseElement}, providing a user-friendly interface for creating and manipulating red channel
 * transfer functions within SVG documents as part of the Domino UI framework.
 *
 * @see BaseElement
 * @see SVGFEFuncRElement
 * @see <a href="https://developer.mozilla.org/en-US/docs/Web/SVG/Element/feFuncR">MDN Web Docs -
 *     SVGFEFuncRElement</a>
 */
public class FEFuncRElement extends BaseElement<SVGFEFuncRElement, FEFuncRElement> {

  /**
   * Factory method for creating a new {@code FEFuncRElement} instance from a given {@code
   * SVGFEFuncRElement}. This method offers a standardized way to instantiate {@code FEFuncRElement}
   * objects, simplifying their creation within the Domino UI framework.
   *
   * @param e the {@code SVGFEFuncRElement} to wrap
   * @return a new instance of {@code FEFuncRElement}
   */
  public static FEFuncRElement of(SVGFEFuncRElement e) {
    return new FEFuncRElement(e);
  }

  /**
   * Constructs a new {@code FEFuncRElement} by wrapping the specified {@code SVGFEFuncRElement}.
   * This constructor is protected to promote the use of the factory method {@code of()} for
   * creating new instances, maintaining consistency across the framework.
   *
   * @param element the {@code SVGFEFuncRElement} to be wrapped
   */
  public FEFuncRElement(SVGFEFuncRElement element) {
    super(element);
  }
}
