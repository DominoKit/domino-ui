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

/** IOS loader implementation */
public class IosLoader extends BaseLoader<IosLoader> implements IsElement<HTMLDivElement> {

  private final DominoElement<HTMLDivElement> progress1 =
      DominoElement.div().addCss(wait_me_progress_elem_1, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress2 =
      DominoElement.div().addCss(wait_me_progress_elem_2, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress3 =
      DominoElement.div().addCss(wait_me_progress_elem_3, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress4 =
      DominoElement.div().addCss(wait_me_progress_elem_4, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress5 =
      DominoElement.div().addCss(wait_me_progress_elem_5, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress6 =
      DominoElement.div().addCss(wait_me_progress_elem_6, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress7 =
      DominoElement.div().addCss(wait_me_progress_elem_7, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress8 =
      DominoElement.div().addCss(wait_me_progress_elem_8, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress9 =
      DominoElement.div().addCss(wait_me_progress_elem_9, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress10 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_10, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress11 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_11, dui_bg_grey_d_2);
  private final DominoElement<HTMLDivElement> progress12 =
      DominoElement.div()
          .addCss(wait_me_progress_elem_12, dui_bg_grey_d_2);

  private final DominoElement<HTMLDivElement> loader =
      DominoElement.div()
          .addCss(wait_me_progress, ios)
          .appendChild(progress1)
          .appendChild(progress2)
          .appendChild(progress3)
          .appendChild(progress4)
          .appendChild(progress5)
          .appendChild(progress6)
          .appendChild(progress7)
          .appendChild(progress8)
          .appendChild(progress9)
          .appendChild(progress10)
          .appendChild(progress11)
          .appendChild(progress12);

  private final DominoElement<HTMLDivElement> content =
      DominoElement.div()
          .addCss(wait_me_content, GenericCss.dui_vertical_center)
          .appendChild(DominoElement.div()
                  .appendChild(loader)
                  .appendChild(loadingText)
          );

  private final DominoElement<HTMLDivElement> element =
      DominoElement.div()
          .addCss(wait_me)
          .style("background: rgba(255, 255, 255, 0.9);")
          .appendChild(content);

  public IosLoader() {
    init(this);
  }

  public static IosLoader create() {
    return new IosLoader();
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
