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
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Bounce pulse loader implementation
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class BouncePulseLoader extends BaseLoader<BouncePulseLoader>
    implements IsElement<HTMLDivElement> {

  private final DivElement progress1 = div().addCss(wait_me_progress_elem_1, dui_bg_black);
  private final DivElement progress2 = div().addCss(wait_me_progress_elem_2, dui_bg_black);
  private final DivElement progress3 = div().addCss(wait_me_progress_elem_3, dui_bg_black);

  private final DivElement loader =
      div()
          .addCss(wait_me_progress, bounce_pulse)
          .appendChild(progress1)
          .appendChild(progress2)
          .appendChild(progress3);

  private final DivElement content =
      div()
          .addCss(wait_me_content, dui_vertical_center, vertical)
          .appendChild(loader)
          .appendChild(loadingText);

  private final DivElement element =
      div().addCss(wait_me).style("background: rgba(255, 255, 255, 0.7);").appendChild(content);

  /** Constructor for BouncePulseLoader. */
  public BouncePulseLoader() {
    init(this);
  }

  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.loaders.BouncePulseLoader} object
   */
  public static BouncePulseLoader create() {
    return new BouncePulseLoader();
  }

  /** {@inheritDoc} */
  @Override
  public void setLoadingText(String text) {
    loadingText.textContent = text;
  }

  /** {@inheritDoc} */
  @Override
  public void setSize(String width, String height) {
    onAttached(mutationRecord -> loader.setWidth(width).setHeight(height));
  }

  /** {@inheritDoc} */
  @Override
  public void removeLoadingText() {
    onAttached(mutationRecord -> loadingText.remove());
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getContentElement() {
    return content.toDominoElement();
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
