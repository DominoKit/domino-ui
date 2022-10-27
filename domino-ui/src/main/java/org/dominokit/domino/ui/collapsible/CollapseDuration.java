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
package org.dominokit.domino.ui.collapsible;

import org.dominokit.domino.ui.style.CssClass;

public enum CollapseDuration implements CollapsibleStyles {
  _100ms(dui_height_collapsed_trans_100, 100),
  _200ms(dui_height_collapsed_trans_200, 200),
  _300ms(dui_height_collapsed_trans_300, 300),
  _400ms(dui_height_collapsed_trans_400, 400),
  _500ms(dui_height_collapsed_trans_500, 500),
  _600ms(dui_height_collapsed_trans_600, 600),
  _700ms(dui_height_collapsed_trans_700, 700),
  _800ms(dui_height_collapsed_trans_800, 800),
  _900ms(dui_height_collapsed_trans_900, 900),
  _1000ms(dui_height_collapsed_trans_1000, 1000);

  private final CssClass style;
  private final int duration;

  CollapseDuration(CssClass style, int duration) {
    this.style = style;
    this.duration = duration;
  }

  public CssClass getStyle() {
    return style;
  }

  public int getDuration() {
    return duration;
  }
}
