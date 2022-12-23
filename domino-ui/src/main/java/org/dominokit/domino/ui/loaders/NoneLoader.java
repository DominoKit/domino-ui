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
import org.dominokit.domino.ui.style.GenericCss;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.IsElement;

/** A none loader implementation */
public class NoneLoader extends BaseLoader<NoneLoader> implements IsElement<HTMLDivElement> {

  private final DominoElement<HTMLDivElement> content =
      DominoElement.div()
          .addCss(wait_me_content, dui_vertical_center)
          .style("margin-top: -18px;")
          .appendChild(loadingText);

  private final DominoElement<HTMLDivElement> element =
      DominoElement.div()
          .addCss(wait_me)
          .style("background: rgba(255, 255, 255, 0.9);")
          .appendChild(content);

  public NoneLoader() {
    init(this);
  }

  public static NoneLoader create() {
    return new NoneLoader();
  }

  /** {@inheritDoc} */
  @Override
  public void setLoadingText(String text) {
    loadingText.textContent = text;
  }

  /** {@inheritDoc} */
  @Override
  public void setSize(String width, String height) {}

  /** {@inheritDoc} */
  @Override
  public void removeLoadingText() {
    onAttached(mutationRecord -> loadingText.remove());
  }

  /** {@inheritDoc} */
  @Override
  public DominoElement<HTMLDivElement> getContentElement() {
    return DominoElement.of(content);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
