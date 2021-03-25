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
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Unit;

class HSplitter extends BaseSplitter<HSplitter> {

  HSplitter(SplitPanel left, SplitPanel right, HasSize hSplitPanel) {
    super(left, right, hSplitPanel);
    init(this);
  }

  static HSplitter create(SplitPanel left, SplitPanel right, HSplitPanel hSplitPanel) {
    return new HSplitter(left, right, hSplitPanel);
  }

  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().width;
  }

  @Override
  protected void setNewSizes(
      SplitPanel first,
      SplitPanel second,
      double firstPercent,
      double secondPercent,
      HasSize mainPanel) {
    first
        .style()
        .setWidth(
            Calc.sub(
                Unit.percent.of(firstPercent),
                Unit.px.of(
                    first.isFirst()
                        ? mainPanel.getSplitterSize() / 2
                        : mainPanel.getSplitterSize())));
    second
        .style()
        .setWidth(
            Calc.sub(
                Unit.percent.of(secondPercent),
                Unit.px.of(
                    second.isLast()
                        ? mainPanel.getSplitterSize() / 2
                        : mainPanel.getSplitterSize())));
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

  public void setSize(int size) {
    setWidth(Unit.px.of(size));
  }
}
