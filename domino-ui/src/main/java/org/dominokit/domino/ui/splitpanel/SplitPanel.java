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

import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * Represents a UI split panel that can be used alongside other split panels in a layout. It offers
 * functionalities to adjust its size constraints and to listen to resizing events.
 *
 * <p>Usage example:
 *
 * <pre>
 * SplitPanel splitPanel = SplitPanel.create()
 *      .setMinSize(100)
 *      .setMaxSize(500)
 *      .addResizeListener((panel, pixels, percent) -> {
 *           // Logic executed when the panel is resized
 *      });
 * </pre>
 *
 * @see BaseDominoElement
 * @see SplitStyles
 */
public class SplitPanel extends BaseDominoElement<HTMLDivElement, SplitPanel>
    implements SplitStyles {

  private final DivElement element;

  private int minSize = 1;
  private int maxSize = Integer.MAX_VALUE;

  private boolean isFirst = false;
  private boolean isLast = false;

  private double minPercent = 0;
  private double maxPercent = 100;
  private final List<ResizeListener> resizeListeners = new ArrayList<>();

  /** Creates a new SplitPanel instance with default styles and settings. */
  public SplitPanel() {
    element = div().addCss(dui_split_panel);
    init(this);
  }

  /**
   * Factory method to create a new SplitPanel instance.
   *
   * @return a new instance of SplitPanel
   */
  public static SplitPanel create() {
    return new SplitPanel();
  }

  /**
   * Returns the minimum size of the split panel.
   *
   * @return the minimum size of the panel
   */
  public int getMinSize() {
    return minSize;
  }

  /**
   * Sets the minimum size of the split panel.
   *
   * @param minSize the minimum size to set
   * @return the current instance for method chaining
   */
  public SplitPanel setMinSize(int minSize) {
    this.minSize = minSize;
    return this;
  }

  /**
   * Returns the maximum size of the split panel.
   *
   * @return the maximum size of the panel
   */
  public int getMaxSize() {
    return maxSize;
  }

  /**
   * Sets the maximum size of the split panel.
   *
   * @param maxSize the maximum size to set
   * @return the current instance for method chaining
   */
  public SplitPanel setMaxSize(int maxSize) {
    this.maxSize = maxSize;
    return this;
  }

  /**
   * Returns the minimum size of the split panel in percentage.
   *
   * @return the minimum size of the panel in percentage
   */
  public double getMinPercent() {
    return minPercent;
  }

  /**
   * Sets the minimum size of the split panel in percentage.
   *
   * <p>If the value is between 0 and 1, it's multiplied by 100. Values greater than 100 are set to
   * 100. Negative values are set to 0.
   *
   * @param minPercent the minimum size in percentage to set
   * @return the current instance for method chaining
   */
  public SplitPanel setMinPercent(double minPercent) {
    if (minPercent <= 0) {
      this.minPercent = 0;
    } else if (minPercent <= 1) {
      this.minPercent = minPercent * 100;
    } else if (minPercent >= 100) {
      this.minPercent = 100;
    } else {
      this.minPercent = minPercent;
    }
    return this;
  }

  /**
   * Returns the maximum size of the split panel in percentage.
   *
   * @return the maximum size of the panel in percentage
   */
  public double getMaxPercent() {
    return maxPercent;
  }

  /**
   * Sets the maximum size of the split panel in percentage.
   *
   * <p>If the value is between 0 and 1, it's multiplied by 100. Values greater than 100 are set to
   * 100. Negative values are set to 0.
   *
   * @param maxPercent the maximum size in percentage to set
   * @return the current instance for method chaining
   */
  public SplitPanel setMaxPercent(double maxPercent) {
    if (maxPercent <= 0) {
      this.maxPercent = 0;
    } else if (maxPercent <= 1) {
      this.maxPercent = maxPercent * 100;
    } else if (maxPercent >= 100) {
      this.maxPercent = 100;
    } else {
      this.maxPercent = maxPercent;
    }
    return this;
  }

  /**
   * Adds a {@link ResizeListener} to the split panel.
   *
   * @param resizeListener the listener to add
   * @return the current instance for method chaining
   */
  public SplitPanel addResizeListener(ResizeListener resizeListener) {
    if (nonNull(resizeListener)) {
      resizeListeners.add(resizeListener);
    }
    return this;
  }

  /**
   * Removes a {@link ResizeListener} from the split panel.
   *
   * @param resizeListener the listener to remove
   * @return the current instance for method chaining
   */
  public SplitPanel removeResizeListener(ResizeListener resizeListener) {
    if (nonNull(resizeListener)) {
      resizeListeners.remove(resizeListener);
    }
    return this;
  }

  /**
   * Checks if this panel is the first one in the split layout.
   *
   * @return {@code true} if this panel is the first, {@code false} otherwise
   */
  public boolean isFirst() {
    return isFirst;
  }

  /**
   * Sets this panel as the first one in the split layout.
   *
   * @param first {@code true} to set this panel as the first, {@code false} otherwise
   * @return the current instance for method chaining
   */
  public SplitPanel setFirst(boolean first) {
    isFirst = first;
    return this;
  }

  /**
   * Checks if this panel is the last one in the split layout.
   *
   * @return {@code true} if this panel is the last, {@code false} otherwise
   */
  public boolean isLast() {
    return isLast;
  }

  /**
   * Sets this panel as the last one in the split layout.
   *
   * @param last {@code true} to set this panel as the last, {@code false} otherwise
   * @return the current instance for method chaining
   */
  public SplitPanel setLast(boolean last) {
    isLast = last;
    return this;
  }

  /**
   * Internal method to handle the resize event.
   *
   * @param pixels the new size of the panel in pixels
   * @param percent the new size of the panel in percentage
   */
  void onResize(double pixels, double percent) {
    resizeListeners.forEach(
        resizeListener -> resizeListener.onResize(SplitPanel.this, pixels, percent));
  }

  /**
   * Returns the root HTMLDivElement of the SplitPanel.
   *
   * @return the root HTMLDivElement element of this split panel
   */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** Listener interface to track resize events of the SplitPanel. */
  @FunctionalInterface
  public interface ResizeListener {

    /**
     * Called when a SplitPanel is resized.
     *
     * @param panel the split panel that was resized
     * @param pixels the size of the panel in pixels after resizing
     * @param percent the size of the panel in percentage after resizing
     */
    void onResize(SplitPanel panel, double pixels, double percent);
  }
}
