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

import static org.dominokit.domino.ui.utils.Domino.*;

/**
 * Represents a vertical split panel which contains two panels separated by a vertical splitter.
 *
 * <p>This is an extension of the base split panel with specific behavior for vertical layout.
 */
public class VSplitPanel extends BaseSplitPanel<VSplitPanel, VSplitter>
    implements HasSplitPanels, SplitStyles {

  /** Creates a new vertical split panel. */
  public VSplitPanel() {
    addCss(dui_vertical);
  }

  /**
   * Creates a vertical splitter for this split panel.
   *
   * @param first the first panel in the split layout
   * @param second the second panel in the split layout
   * @param mainPanel the main split panel that holds the two sub-panels
   * @return a new instance of {@link VSplitter}
   */
  @Override
  protected VSplitter createSplitter(
      SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
    return VSplitter.create(first, second, this);
  }

  /**
   * Gets the height of the provided split panel.
   *
   * @param panel the split panel whose height is to be retrieved
   * @return the height of the panel
   */
  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().height;
  }

  /**
   * Sets the height of the provided split panel.
   *
   * @param panel the split panel whose height is to be set
   * @param size the height to be set for the panel
   */
  @Override
  protected void setPanelSize(SplitPanel panel, String size) {
    panel.style().setHeight(size);
    panel.setCssProperty("--dui-split-panel-dynamic-size", size);
  }

  /**
   * Factory method to create a new instance of {@link VSplitPanel}.
   *
   * @return a new instance of VSplitPanel
   */
  public static VSplitPanel create() {
    return new VSplitPanel();
  }

  /**
   * Gets the height of this vertical split panel.
   *
   * @return the height of the split panel
   */
  @Override
  public double getSize() {
    return getBoundingClientRect().height;
  }
}
