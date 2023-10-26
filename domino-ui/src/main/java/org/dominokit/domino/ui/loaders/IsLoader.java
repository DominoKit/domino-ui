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
package org.dominokit.domino.ui.loaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * The interface for loader components that provide loading animations. Loaders are visual elements
 * that indicate the progress of an operation or task.
 *
 * <p>Usage example:
 *
 * <pre>
 * IsLoader loader = new SomeLoaderImplementation();
 * loader.setSize("50px", "50px");
 * DOM.appendChild(loader.getElement());
 * </pre>
 */
public interface IsLoader {

  /**
   * Sets the loading text for the loader.
   *
   * @param text The text to display as loading text.
   */
  default void setLoadingText(String text) {}

  /**
   * Gets the HTMLDivElement element associated with this loader.
   *
   * @return The HTMLDivElement element of the loader.
   */
  HTMLDivElement getElement();

  /**
   * Sets the size of the loader element.
   *
   * @param width The width of the loader.
   * @param height The height of the loader.
   */
  void setSize(String width, String height);

  /** Removes the loading text from the loader. */
  void removeLoadingText();

  /**
   * Gets the content element of the loader wrapped in a DominoElement.
   *
   * @return The content element of the loader.
   */
  DominoElement<HTMLDivElement> getContentElement();
}
