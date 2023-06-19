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
package org.dominokit.domino.ui.splitpanel;

import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;

class HSplitter extends BaseSplitter<HSplitter> {

  HSplitter(SplitPanel left, SplitPanel right, HasSplitPanels hSplitPanel) {
    super(left, right, hSplitPanel);
    init(this);
    addCss(dui_horizontal);
    handleElement.addCss(dui_horizontal);
  }

  static HSplitter create(SplitPanel left, SplitPanel right, HSplitPanel hSplitPanel) {
    return new HSplitter(left, right, hSplitPanel);
  }

  @Override
  protected double touchPosition(TouchEvent event) {
    return event.touches.getAt(0).clientX;
  }

  @Override
  protected double mousePosition(MouseEvent event) {
    return event.clientX;
  }

  @Override
  public double getSize() {
    return element.getBoundingClientRect().width;
  }
}
