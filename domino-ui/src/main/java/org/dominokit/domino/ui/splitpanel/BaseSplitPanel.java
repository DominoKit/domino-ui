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

import static org.jboss.elemento.Elements.div;

import elemental2.dom.HTMLDivElement;
import java.util.LinkedList;
import java.util.List;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.style.Unit;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

/**
 * Abstract implementation for a split panel
 *
 * @param <T> the type of the split panel
 * @param <S> the type of the splitter
 */
abstract class BaseSplitPanel<T extends BaseSplitPanel<T, S>, S extends BaseSplitter>
    extends BaseDominoElement<HTMLDivElement, T> implements HasSize {

  private final DominoElement<HTMLDivElement> element =
      DominoElement.of(div()).css(SplitStyles.SPLIT_PANEL);

  private final List<SplitPanel> panels = new LinkedList<>();
  private final List<S> splitters = new LinkedList<>();
  private ColorScheme colorScheme = ColorScheme.INDIGO;
  private int splitterSize = 10;

  public BaseSplitPanel(String splitterStyle) {
    element.addCss(splitterStyle);
    element.onAttached(mutationRecord -> updatePanelsSize());
  }

  private void updatePanelsSize() {
    double mainPanelSize = getSize();

    double totalPercent = (getSplitterSize() / mainPanelSize) * 100;
    for (SplitPanel panel : panels) {
      double panelSize = getPanelSize(panel);
      double sizePercent = (panelSize / mainPanelSize) * 100;
      double newTotalPercent = totalPercent + sizePercent;
      if (newTotalPercent >= 100) {
        sizePercent = sizePercent - (newTotalPercent - 100);
      }
      totalPercent = newTotalPercent;
      setPanelSize(
          panel,
          Calc.sub(
              Unit.percent.of(sizePercent),
              Unit.px.of(panel.isFirst() || panel.isLast() ? splitterSize / 2 : splitterSize)));
    }
  }

  protected abstract double getPanelSize(SplitPanel panel);

  protected abstract void setPanelSize(SplitPanel panel, String size);

  /**
   * Adds a new panel
   *
   * @param panel the {@link SplitPanel} to add
   * @return same instance
   */
  public T appendChild(SplitPanel panel) {
    panels.add(panel);
    if (panels.size() > 1) {
      S splitter = createSplitter(panels.get(panels.size() - 2), panel, this);
      splitter.setColorScheme(colorScheme);
      splitter.setSize(splitterSize);
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

  protected abstract S createSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel);

  /** @return The current color scheme applied */
  public ColorScheme getColorScheme() {
    return this.colorScheme;
  }

  /**
   * Sets a new color scheme
   *
   * @param colorScheme the {@link ColorScheme}
   * @return same instance
   */
  public T setColorScheme(ColorScheme colorScheme) {
    this.colorScheme = colorScheme;
    splitters.forEach(hSplitter -> hSplitter.setColorScheme(colorScheme));
    return (T) this;
  }

  /**
   * Sets the width of the splitter in pixels
   *
   * @param size the width in pixels
   * @return same instance
   */
  public T setSplitterSize(int size) {
    this.splitterSize = size;
    splitters.forEach(hSplitter -> hSplitter.setSize(size));
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public int getSplitterSize() {
    return splitterSize;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  /** {@inheritDoc} */
  @Override
  public double getSize() {
    return getBoundingClientRect().width;
  }
}
