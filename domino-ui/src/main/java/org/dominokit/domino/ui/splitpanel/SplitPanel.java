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

import elemental2.dom.HTMLDivElement;
import java.util.ArrayList;
import java.util.List;

import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * A wrapper component for split panels
 *
 * <p>For example:
 *
 * <pre>
 *     SplitPanel.create()
 *                             .appendChild(
 *                                 div()
 *                                     .css("demo-split-div", Color.INDIGO_LIGHTEN_5.getBackground()))
 * </pre>
 *
 * @see BaseDominoElement
 */
public class SplitPanel extends BaseDominoElement<HTMLDivElement, SplitPanel> implements SplitStyles {

  private final DivElement element;

  private int minSize = 1;
  private int maxSize = Integer.MAX_VALUE;

  private boolean isFirst = false;
  private boolean isLast = false;

  private double minPercent = 0;
  private double maxPercent = 100;
  private final List<ResizeListener> resizeListeners = new ArrayList<>();

  public SplitPanel() {
    element = div().addCss(dui_split_panel);
    init(this);
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** @return new instance */
  public static SplitPanel create() {
    return new SplitPanel();
  }

  /** @return the minimum size of this panel */
  public int getMinSize() {
    return minSize;
  }

  /**
   * Sets the minimum size of the panel
   *
   * @param minSize the minimum size
   * @return same instance
   */
  public SplitPanel setMinSize(int minSize) {
    this.minSize = minSize;
    return this;
  }

  /** @return the maximum size */
  public int getMaxSize() {
    return maxSize;
  }

  /**
   * Sets the maximum size of the panel
   *
   * @param maxSize the maximum size
   * @return same instance
   */
  public SplitPanel setMaxSize(int maxSize) {
    this.maxSize = maxSize;
    return this;
  }

  /** @return the minimum size percentage */
  public double getMinPercent() {
    return minPercent;
  }

  /**
   * Sets the minimum size in percentage
   *
   * @param minPercent the percentage of the minimum size
   * @return same instance
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

  /** @return the maximum size percentage */
  public double getMaxPercent() {
    return maxPercent;
  }

  /**
   * Sets the maximum size in percentage
   *
   * @param maxPercent the percentage of the maximum size
   * @return same instance
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
   * Adds a listener which will be called when the panel is resized
   *
   * @param resizeListener A {@link ResizeListener} to add
   * @return same instance
   */
  public SplitPanel addResizeListener(ResizeListener resizeListener) {
    if (nonNull(resizeListener)) {
      resizeListeners.add(resizeListener);
    }
    return this;
  }

  /**
   * Removes a resize listener
   *
   * @param resizeListener A {@link ResizeListener} to remove
   * @return same instance
   */
  public SplitPanel removeResizeListener(ResizeListener resizeListener) {
    if (nonNull(resizeListener)) {
      resizeListeners.remove(resizeListener);
    }
    return this;
  }

  /** @return true if this panel is the first one in its container */
  public boolean isFirst() {
    return isFirst;
  }

  /**
   * Sets this panel as the first panel
   *
   * @param first true for marking it as first
   * @return same instance
   */
  public SplitPanel setFirst(boolean first) {
    isFirst = first;
    return this;
  }

  /** @return true if this panel is the last one in its container */
  public boolean isLast() {
    return isLast;
  }

  /**
   * Sets this panel as the last panel
   *
   * @param last true for marking it as last
   * @return same instance
   */
  public SplitPanel setLast(boolean last) {
    isLast = last;
    return this;
  }

  void onResize(double pixels, double percent) {
    resizeListeners.forEach(
        resizeListener -> resizeListener.onResize(SplitPanel.this, pixels, percent));
  }

  /** A listener which will be called when panel is resized */
  @FunctionalInterface
  public interface ResizeListener {
    /**
     * @param panel the panel
     * @param pixels the new size in pixels
     * @param percent the new size in percentage
     */
    void onResize(SplitPanel panel, double pixels, double percent);
  }
}
