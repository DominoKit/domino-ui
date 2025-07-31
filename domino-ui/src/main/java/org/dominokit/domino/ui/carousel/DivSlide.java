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
package org.dominokit.domino.ui.carousel;

import org.dominokit.domino.ui.utils.BaseDominoElement;

import elemental2.dom.HTMLElement;

/**
 * A slide component used with {@link org.dominokit.domino.ui.carousel.Carousel}
 *
 * <p>The component provide the means to create an image slide with different types of image
 * elements or components
 *
 * @see BaseDominoElement
 */
public class DivSlide extends Slide {

  public DivSlide(HTMLElement element) {
    super(element);
  }


  /**
   * Factory method to create a slide from the provided component
   *
   * @param el The {@link HTMLElement} element to be used for the slide.
   * @return new instance
   */
  public static DivSlide create(HTMLElement el) {
    return new DivSlide(el);
  }

}
