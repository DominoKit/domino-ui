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

/** An interface represents loader effect implementation */
public interface IsLoader {

  /** @param text the loading text to set */
  /**
   * setLoadingText.
   *
   * @param text a {@link java.lang.String} object
   */
  default void setLoadingText(String text) {}

  /** @return The root loader element */
  /**
   * getElement.
   *
   * @return a {@link elemental2.dom.HTMLDivElement} object
   */
  HTMLDivElement getElement();

  /**
   * Sets the size of the loader
   *
   * @param width the width css property
   * @param height the height css property
   */
  void setSize(String width, String height);

  /** Removes the loading text */
  void removeLoadingText();

  /** @return The content element */
  /**
   * getContentElement.
   *
   * @return a {@link org.dominokit.domino.ui.utils.DominoElement} object
   */
  DominoElement<HTMLDivElement> getContentElement();
}
