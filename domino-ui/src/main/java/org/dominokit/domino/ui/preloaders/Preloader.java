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
package org.dominokit.domino.ui.preloaders;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * A component to show a loading indicator with different sizes and colors
 *
 * <p>example
 *
 * <pre>
 * DominoElement.body()
 *         .appendChild(Preloader.create()
 *                 .setSize(Preloader.Size.large)
 *                 .setColor(Color.GREEN));
 * </pre>
 */
public class Preloader extends BaseDominoElement<HTMLDivElement, Preloader>
    implements IsElement<HTMLDivElement>, PreloaderStyles {

  private final DivElement root;

  /** */
  public Preloader() {
    this.root =
        div()
            .addCss(dui_preloader, dui_small)
            .appendChild(
                div()
                    .addCss(dui_pl_spinner_layer)
                    .appendChild(
                        div()
                            .addCss(dui_pl_circle_clipper)
                            .appendChild(div().addCss(dui_pl_circle_left)))
                    .appendChild(
                        div()
                            .addCss(dui_pl_circle_clipper, dui_pl_right)
                            .appendChild(div().addCss(dui_pl_circle_right))));
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /** @return new Preloader instance */
  public static Preloader create() {
    return new Preloader();
  }

  /**
   * removes the loader from the dom tree
   *
   * @return same Preloader instance
   */
  public Preloader stop() {
    element().remove();
    return this;
  }
}
