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

import elemental2.svg.SVGAnimateMotionElement;
import org.dominokit.domino.ui.elements.BaseElement;

/**
 * This class provides a wrapper for the {@link SVGAnimateMotionElement} which is used within SVG to
 * animate an element along a defined path. By extending the {@link BaseElement}, it integrates
 * seamlessly with the Domino UI framework, allowing for fluent animations within SVG graphics.
 *
 * @see BaseElement
 * @see SVGAnimateMotionElement
 */
public class AnimateMotionElement
    extends BaseElement<SVGAnimateMotionElement, AnimateMotionElement> {

  /**
   * Factory method that creates a new {@code AnimateMotionElement} instance by wrapping an existing
   * {@code SVGAnimateMotionElement}. This provides a more convenient way to work with SVG animation
   * of motion within the Domino UI framework.
   *
   * @param e the {@code SVGAnimateMotionElement} to wrap
   * @return a new {@code AnimateMotionElement} instance
   */
  public static AnimateMotionElement of(SVGAnimateMotionElement e) {
    return new AnimateMotionElement(e);
  }

  /**
   * Constructs a new {@code AnimateMotionElement} instance that encapsulates the given {@code
   * SVGAnimateMotionElement}. This constructor is designed to be used internally and should
   * generally not be called directly; instead, use the static factory method.
   *
   * @param element the {@code SVGAnimateMotionElement} to be wrapped
   */
  public AnimateMotionElement(SVGAnimateMotionElement element) {
    super(element);
  }
}
