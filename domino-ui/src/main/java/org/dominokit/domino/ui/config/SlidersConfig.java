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
package org.dominokit.domino.ui.config;

import org.dominokit.domino.ui.sliders.SliderStyles;
import org.dominokit.domino.ui.style.CssClass;

public interface SlidersConfig extends ComponentConfig {

  /**
   * @return the default sliders thumb style, one of {@link SliderStyles#dui_slider_thumb_rounded}
   *     or {@link SliderStyles#dui_slider_thumb_flat}
   */
  default CssClass getDefaultSliderThumbStyle() {
    return SliderStyles.dui_slider_thumb_rounded;
  }

  /**
   * @return a boolean to set if the slider thumb disappears or not after finishes dragging the
   *     slider
   */
  default boolean autoHideThumb() {
    return true;
  }
}
