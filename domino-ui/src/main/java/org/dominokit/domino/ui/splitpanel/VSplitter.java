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

import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Unit;

class VSplitter extends BaseSplitter<VSplitter> {

  VSplitter(SplitPanel top, SplitPanel bottom, HasSize vSplitPanel) {
    super(top, bottom, vSplitPanel);
    init(this);
  }

  static VSplitter create(SplitPanel top, SplitPanel right, HasSize vSplitPanel) {
    return new VSplitter(top, right, vSplitPanel);
  }

  protected void setNewSizes(
      SplitPanel top,
      SplitPanel bottom,
      double topPercent,
      double bottomPercent,
      HasSize mainPanel) {
    top.style()
        .setHeight(
            Calc.sub(
                Unit.percent.of(topPercent),
                Unit.px.of(
                    top.isFirst()
                        ? mainPanel.getSplitterSize() / 2
                        : mainPanel.getSplitterSize())));
    bottom
        .style()
        .setHeight(
            Calc.sub(
                Unit.percent.of(bottomPercent),
                Unit.px.of(
                    bottom.isLast()
                        ? mainPanel.getSplitterSize() / 2
                        : mainPanel.getSplitterSize())));
  }

  public double mousePosition(MouseEvent event) {
    return event.clientY;
  }

  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().height;
  }

  @Override
  protected double touchPosition(TouchEvent event) {
    return event.touches.getAt(0).clientY;
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  @Override
  public double getSize() {
    return element.getBoundingClientRect().height;
  }

  public void setSize(int size) {
    setHeight(Unit.px.of(size));
  }
}
