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
package org.dominokit.domino.ui.sliders;

import org.dominokit.domino.ui.style.CssClass;

/**
 * A constants class for Slider css classes names
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface SliderStyles {
  /** Constant <code>dui_slider</code> */
  CssClass dui_slider = () -> "dui-slider";
  /** Constant <code>dui_slider_input</code> */
  CssClass dui_slider_input = () -> "dui-slider-input";
  /** Constant <code>dui_slider_thumb</code> */
  CssClass dui_slider_thumb = () -> "dui-slider-thumb";
  /** Constant <code>dui_slider_value</code> */
  CssClass dui_slider_value = () -> "dui-slider-value";
}
