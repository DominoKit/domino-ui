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
 * A vertical split panel implementation
 *
 * @see BaseSplitPanel
 * @see HasSplitPanels
 * @author vegegoku
 * @version $Id: $Id
 */
public class VSplitPanel extends BaseSplitPanel<VSplitPanel, VSplitter>
    implements HasSplitPanels, SplitStyles {

  /** Constructor for VSplitPanel. */
  public VSplitPanel() {
    addCss(dui_vertical);
  }

  /** {@inheritDoc} */
  @Override
  protected VSplitter createSplitter(
      SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
    return VSplitter.create(first, second, this);
  }

  /** {@inheritDoc} */
  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().height;
  }

  /** {@inheritDoc} */
  @Override
  protected void setPanelSize(SplitPanel panel, String size) {
    panel.style().setHeight(size);
  }

  /** @return new instance */
  /**
   * create.
   *
   * @return a {@link org.dominokit.domino.ui.splitpanel.VSplitPanel} object
   */
  public static VSplitPanel create() {
    return new VSplitPanel();
  }

  /** {@inheritDoc} */
  @Override
  public double getSize() {
    return getBoundingClientRect().height;
  }
}
