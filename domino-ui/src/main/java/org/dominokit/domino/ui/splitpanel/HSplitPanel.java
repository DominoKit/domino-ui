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

/**
 * A horizontal split panel implementation
 *
 * <p>For example:
 *
 * <pre>
 *     HSplitPanel.create()
 *                     .appendChild(
 *                         SplitPanel.create()
 *                             .appendChild(
 *                                 div()
 *                                     .css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground())))
 *                     .appendChild(
 *                         SplitPanel.create()
 *                             .appendChild(
 *                                 div()
 *                                     .css(
 *                                         "demo-split-div",
 *                                         Color.BLUE_GREY_LIGHTEN_5.getBackground())))
 *                     .setHeight("400px")
 * </pre>
 *
 * @see BaseSplitPanel
 * @see HasSize
 */
public class HSplitPanel extends BaseSplitPanel<HSplitPanel, HSplitter> implements HasSize {

  public HSplitPanel() {
    super(SplitStyles.HORIZONTAL);
    init(this);
  }

  @Override
  protected HSplitter createSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel) {
    return HSplitter.create(first, second, this);
  }

  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().width;
  }

  @Override
  protected void setPanelSize(SplitPanel panel, String size) {
    panel.style().setWidth(size);
  }

  /** @return new instance */
  public static HSplitPanel create() {
    return new HSplitPanel();
  }

  /** {@inheritDoc} */
  @Override
  public double getSize() {
    return getBoundingClientRect().width;
  }
}
