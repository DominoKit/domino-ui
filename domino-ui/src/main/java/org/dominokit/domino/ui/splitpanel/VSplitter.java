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

class VSplitter extends BaseSplitter<VSplitter> {

  VSplitter(SplitPanel top, SplitPanel bottom, HasSplitPanels vSplitPanel) {
    super(top, bottom, vSplitPanel);
    init(this);
    handleElement.addCss(dui_vertical);
  }

  static VSplitter create(SplitPanel top, SplitPanel bottom, HasSplitPanels vSplitPanel) {
    return new VSplitter(top, bottom, vSplitPanel);
  }

  public double mousePosition(MouseEvent event) {
    return event.clientY;
  }

  @Override
  protected double touchPosition(TouchEvent event) {
    return event.touches.getAt(0).clientY;
  }

  @Override
  public double getSize() {
    return element.getBoundingClientRect().height;
  }
}
