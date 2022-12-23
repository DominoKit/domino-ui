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

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/** Win8 loader implementation */
public class Win8Loader extends BaseLoader<Win8Loader> implements IsElement<HTMLDivElement> {

  private final DominoElement<HTMLDivElement> progress1 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_1)
          .appendChild(DominoElement.div().addCss(dui_bg_grey_d_2));
  private final DominoElement<HTMLDivElement> progress2 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_2)
          .appendChild(DominoElement.div().addCss(dui_bg_grey_d_2));
  private final DominoElement<HTMLDivElement> progress3 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_3)
          .appendChild(DominoElement.div().addCss(dui_bg_grey_d_2));
  private final DominoElement<HTMLDivElement> progress4 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_4)
          .appendChild(DominoElement.div().addCss(dui_bg_grey_d_2));
  private final DominoElement<HTMLDivElement> progress5 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_5)
          .appendChild(DominoElement.div().addCss(dui_bg_grey_d_2));

  private final DominoElement<HTMLDivElement> loader =
      DominoElement.div()
          .addCss(wait_me_progress, win_8)
          .appendChild(progress1)
          .appendChild(progress2)
          .appendChild(progress3)
          .appendChild(progress4)
          .appendChild(progress5);

  private final DominoElement<HTMLDivElement> content =
      DominoElement.div()
          .addCss(wait_me_content, dui_vertical_center)
          .appendChild(loader)
          .appendChild(loadingText);

  private final DominoElement<HTMLDivElement> element =
      DominoElement.div()
          .addCss(wait_me)
          .style("background: rgba(255, 255, 255, 0.9);")
          .appendChild(content);

  public Win8Loader() {
    init(this);
  }

  public static Win8Loader create() {
    return new Win8Loader();
  }

  /** {@inheritDoc} */
  @Override
  public void setLoadingText(String text) {
    loadingText.textContent = text;
  }

  /** {@inheritDoc} */
  @Override
  public void setSize(String width, String height) {
    onAttached(
        mutationRecord -> loader
                .setWidth(width)
                .setHeight(height));
  }

  /** {@inheritDoc} */
  @Override
  public void removeLoadingText() {
    onAttached(mutationRecord -> loadingText.remove());
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getContentElement() {
    return content;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
