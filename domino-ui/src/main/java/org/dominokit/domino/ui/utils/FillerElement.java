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
package org.dominokit.domino.ui.utils;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.elements.SpanElement;

/**
 * A utility class for creating a filler element to add spacing or fill space in UI layouts.
 *
 * <p>This class extends {@link BaseDominoElement} and provides a way to create a filler element
 * that can be used to add space or fill space in UI layouts.
 *
 * <p>Usage example:
 *
 * <pre>
 * // Create a filler element
 * FillerElement fillerElement = FillerElement.create();
 *
 * // Add the filler element to a container or layout
 * someContainer.appendChild(fillerElement.element());
 * </pre>
 *
 * @see BaseDominoElement
 */
public class FillerElement extends BaseDominoElement<HTMLElement, FillerElement> {

  private SpanElement element;

  /**
   * Creates and returns a new {@code FillerElement} instance.
   *
   * @return A new {@code FillerElement} instance.
   */
  public static FillerElement create() {
    return new FillerElement();
  }

  /** Creates a new {@code FillerElement}. */
  public FillerElement() {
    element = span().addCss(dui_grow_1);
    init(this);
  }

  /**
   * @dominokit-site-ignore {@inheritDoc}
   *     <p>Gets the underlying {@link HTMLElement} of the filler element.
   * @return The underlying {@link HTMLElement}.
   */
  @Override
  public HTMLElement element() {
    return element.element();
  }
}
