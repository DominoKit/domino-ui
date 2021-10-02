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

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.jboss.elemento.IsElement;

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
    implements IsElement<HTMLDivElement> {

  private final HTMLDivElement root;
  private final HTMLDivElement spinnerLayer;

  private Size size = Size.large;
  private Color color = Color.RED;

  /** */
  public Preloader() {
    this.root =
        div()
            .css("preloader", "pl-size-l")
            .add(
                spinnerLayer =
                    div()
                        .css("spinner-layer", "pl-red")
                        .add(div().css("circle-clipper", "left").add(div().css("circle")))
                        .add(div().css("circle-clipper", "right").add(div().css("circle")))
                        .element())
            .element();
    init(this);
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return root;
  }

  /** @return new Preloader instance */
  public static Preloader create() {
    return new Preloader();
  }

  /**
   * @param size {@link Size}
   * @return same Preloader instance
   */
  public Preloader setSize(Size size) {
    removeCss(this.size.style);
    this.size = size;
    addCss(this.size.style);
    return this;
  }

  /**
   * @param color {@link Color}
   * @return same Preloader instance
   */
  public Preloader setColor(Color color) {
    spinnerStyle().removeCss(this.color.getStyle().replace("col-", "pl-"));
    this.color = color;
    spinnerStyle().addCss(this.color.getStyle().replace("col-", "pl-"));
    return this;
  }

  private Style<HTMLDivElement, IsElement<HTMLDivElement>> spinnerStyle() {
    return Style.of(spinnerLayer);
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

  /** An enum to list preloader sizes */
  public enum Size {
    xLarge(PreloaderStyles.pl_size_xl),
    large(PreloaderStyles.pl_size_l),
    medium(PreloaderStyles.pl_size_md),
    small(PreloaderStyles.pl_size_sm),
    xSmall(PreloaderStyles.pl_size_xs);

    private String style;

    /** @param style String css class for the loader size */
    Size(String style) {
      this.style = style;
    }
  }
}
