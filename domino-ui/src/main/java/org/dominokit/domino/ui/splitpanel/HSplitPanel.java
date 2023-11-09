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
 * Represents a horizontal split panel which contains two panels separated by a horizontal splitter.
 *
 * <p>This is an extension of the base split panel with specific behavior for horizontal layout.
 */
public class HSplitPanel extends BaseSplitPanel<HSplitPanel, HSplitter>
    implements HasSplitPanels, SplitStyles {

  /** Creates a new horizontal split panel. */
  public HSplitPanel() {
    addCss(dui_horizontal);
  }

  /**
   * Creates a horizontal splitter for this split panel.
   *
   * @param first the first panel in the split layout
   * @param second the second panel in the split layout
   * @param mainPanel the main split panel that holds the two sub-panels
   * @return a new instance of {@link HSplitter}
   */
  @Override
  protected HSplitter createSplitter(
      SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
    return HSplitter.create(first, second, this);
  }

  /**
   * Gets the width of the provided split panel.
   *
   * @param panel the split panel whose width is to be retrieved
   * @return the width of the panel
   */
  @Override
  protected double getPanelSize(SplitPanel panel) {
    return panel.getBoundingClientRect().width;
  }

  /**
   * Sets the width of the provided split panel.
   *
   * @param panel the split panel whose width is to be set
   * @param size the width to be set for the panel
   */
  @Override
  protected void setPanelSize(SplitPanel panel, String size) {
    panel.style().setWidth(size);
  }

  /**
   * Factory method to create a new instance of {@link HSplitPanel}.
   *
   * @return a new instance of HSplitPanel
   */
  public static HSplitPanel create() {
    return new HSplitPanel();
  }

  /**
   * Gets the width of this horizontal split panel.
   *
   * @return the width of the split panel
   */
  @Override
  public double getSize() {
    return getBoundingClientRect().width;
  }
}
