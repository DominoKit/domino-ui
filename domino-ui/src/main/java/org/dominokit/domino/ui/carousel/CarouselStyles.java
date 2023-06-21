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

import org.dominokit.domino.ui.style.CssClass;

/**
 * Default CSS classes for {@link org.dominokit.domino.ui.carousel.Carousel}
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface CarouselStyles {

  /** Constant <code>carousel</code> */
  CssClass carousel = () -> "dui-carousel";
  /** Constant <code>carousel_indicators</code> */
  CssClass carousel_indicators = () -> "dui-carousel-indicators";
  /** Constant <code>slide_indicator</code> */
  CssClass slide_indicator = () -> "dui-slide-indicator";
  /** Constant <code>carousel_inner</code> */
  CssClass carousel_inner = () -> "dui-carousel-inner";
  /** Constant <code>slide</code> */
  CssClass slide = () -> "dui-slide";
  /** Constant <code>slide_next</code> */
  CssClass slide_next = () -> "dui-slide-next";
  /** Constant <code>slide_prev</code> */
  CssClass slide_prev = () -> "dui-slide-prev";
  /** Constant <code>slide_right</code> */
  CssClass slide_right = () -> "dui-slide-right";
  /** Constant <code>slide_left</code> */
  CssClass slide_left = () -> "dui-slide-left";
  /** Constant <code>carousel_control</code> */
  CssClass carousel_control = () -> "dui-carousel-control";
  /** Constant <code>slide_caption</code> */
  CssClass slide_caption = () -> "dui-slide-caption";
}
