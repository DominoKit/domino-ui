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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a visual preloader or spinner used to indicate the loading state of a component or
 * page.
 *
 * <p>Usage example:
 *
 * <pre>
 * Preloader preloader = Preloader.create();
 * </pre>
 *
 * @see BaseDominoElement
 */
public class Preloader extends BaseDominoElement<HTMLDivElement, Preloader>
    implements IsElement<HTMLDivElement>, PreloaderStyles {

  private final DivElement root;

  /** Default constructor creating a new instance of the preloader. */
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

  /**
   * Returns the root HTMLDivElement for this preloader.
   *
   * @return The root HTMLDivElement.
   */
  @Override
  public HTMLDivElement element() {
    return root.element();
  }

  /**
   * Factory method to create a new instance of the preloader.
   *
   * @return A new Preloader instance.
   */
  public static Preloader create() {
    return new Preloader();
  }

  /**
   * Stops and removes the preloader from the DOM.
   *
   * @return The current preloader instance.
   */
  public Preloader stop() {
    element().remove();
    return this;
  }
}
