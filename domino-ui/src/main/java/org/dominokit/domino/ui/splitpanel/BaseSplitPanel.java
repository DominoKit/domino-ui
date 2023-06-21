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
import java.util.LinkedList;
import java.util.List;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Abstract implementation for a split panel
 *
 * @param <T> the type of the split panel
 * @param <S> the type of the splitter
 */
abstract class BaseSplitPanel<T extends BaseSplitPanel<T, S>, S extends BaseSplitter>
    extends BaseDominoElement<HTMLDivElement, T> implements HasSize, HasSplitPanels, SplitStyles {

  private final DivElement element;

  private final List<SplitPanel> panels = new LinkedList<>();
  private final List<S> splitters = new LinkedList<>();
  private double firstSize = 0;
  private double secondSize = 0;

  /** Constructor for BaseSplitPanel. */
  public BaseSplitPanel() {
    element = div().addCss(dui_split_layout);
    init((T) this);
    element.onAttached(mutationRecord -> updatePanelsSize());
  }

  private void updatePanelsSize() {
    double mainPanelSize = getSize();
    String splitterPanelShare = getSplittersSizeShare();

    for (SplitPanel panel : panels) {
      double panelSize = getPanelSize(panel);
      double sizePercent = (panelSize / mainPanelSize) * 100;
      setPanelSize(panel, "calc(" + sizePercent + "% - " + splitterPanelShare + ")");
    }
  }

  /**
   * getSplittersSizeShare.
   *
   * @return a {@link java.lang.String} object
   */
  public String getSplittersSizeShare() {
    int n = panels.size();
    return "(var(--dui-split-layout-splitter-size)*" + (n - 1) + "/" + n + ")";
  }

  /** {@inheritDoc} */
  @Override
  public void onResizeStart(SplitPanel first, SplitPanel second) {
    this.firstSize = Math.round(getPanelSize(first));
    this.secondSize = Math.round(getPanelSize(second));
  }

  /** {@inheritDoc} */
  @Override
  public void resizePanels(SplitPanel first, SplitPanel second, double sizeDiff) {

    double maxSize = getSize();

    double current1stSize = getPanelSize(first);

    double new1stSize = this.firstSize + sizeDiff;
    double new1stPercent = (new1stSize / maxSize) * 100;

    double new2ndSize = this.secondSize - sizeDiff;
    double new2ndPercent = (new2ndSize / maxSize) * 100;

    boolean right = new1stSize > current1stSize;
    boolean left = !right;
    if (right && ((new2ndSize < second.getMinSize() || new2ndPercent < second.getMinPercent()))
        || right
            && ((new1stSize > first.getMaxSize()) || (new1stPercent > first.getMaxPercent()))) {
      return;
    }

    if (left && ((new1stSize < first.getMinSize() || new1stPercent < first.getMinPercent()))
        || left
            && ((new2ndSize > second.getMaxSize()) || (new2ndPercent > second.getMaxPercent()))) {
      return;
    }

    setPanelSize(first, (new1stSize) + "px");
    setPanelSize(second, (new2ndSize) + "px");

    double panelsTotalSize = panels.stream().mapToDouble(this::getPanelSize).sum();
    double splittersSize = splitters.stream().mapToDouble(BaseSplitter::getSize).sum();

    double totalElementsSize = panelsTotalSize + splittersSize;
    double diff = maxSize - totalElementsSize;
    setPanelSize(second, (new2ndSize + diff) + "px");
  }

  /**
   * getPanelSize.
   *
   * @param panel a {@link org.dominokit.domino.ui.splitpanel.SplitPanel} object
   * @return a double
   */
  protected abstract double getPanelSize(SplitPanel panel);

  /**
   * setPanelSize.
   *
   * @param panel a {@link org.dominokit.domino.ui.splitpanel.SplitPanel} object
   * @param size a {@link java.lang.String} object
   */
  protected abstract void setPanelSize(SplitPanel panel, String size);

  /**
   * Adds a new panel
   *
   * @param panel the {@link org.dominokit.domino.ui.splitpanel.SplitPanel} to add
   * @return same instance
   */
  public T appendChild(SplitPanel panel) {
    panels.add(panel);
    if (panels.size() > 1) {
      S splitter = createSplitter(panels.get(panels.size() - 2), panel, this);
      splitters.add(splitter);
      element.appendChild(splitter);
      element.appendChild(panel);

      SplitPanel secondLast = panels.get(panels.size() - 1);
      secondLast.setLast(false);
      panel.setLast(true);

    } else {
      panel.setFirst(true);
      element.appendChild(panel);
    }
    return (T) this;
  }

  /**
   * createSplitter.
   *
   * @param first a {@link org.dominokit.domino.ui.splitpanel.SplitPanel} object
   * @param second a {@link org.dominokit.domino.ui.splitpanel.SplitPanel} object
   * @param mainPanel a {@link org.dominokit.domino.ui.splitpanel.HasSplitPanels} object
   * @return a S object
   */
  protected abstract S createSplitter(
      SplitPanel first, SplitPanel second, HasSplitPanels mainPanel);

  /**
   * withSplitters.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a T object
   */
  public T withSplitters(ChildHandler<T, List<S>> handler) {
    handler.apply((T) this, splitters);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
