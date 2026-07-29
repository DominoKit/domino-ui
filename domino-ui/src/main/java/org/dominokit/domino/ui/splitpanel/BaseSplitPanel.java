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

import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;
import org.dominokit.domino.ui.utils.Unit;

/**
 * Represents the base class for split panels which allow a UI to be divided into multiple panels
 * with resize capabilities.
 *
 * <p>Usage example:
 *
 * <pre>
 * BaseSplitPanel splitPanel = new YourConcreteSplitPanel();
 * splitPanel.appendChild(new YourSplitPanelType());
 * // ... additional configurations
 * </pre>
 *
 * @param <T> The specific type of the split panel
 * @param <S> The specific type of the splitter
 * @see BaseDominoElement
 */
abstract class BaseSplitPanel<T extends BaseSplitPanel<T, S>, S extends BaseSplitter<S>>
    extends BaseDominoElement<HTMLDivElement, T> implements HasSize, HasSplitPanels, SplitStyles {

  private final DivElement element;

  private final List<SplitPanel> panels = new LinkedList<>();
  private final List<S> splitters = new LinkedList<>();
  private double firstSize = 0;
  private double secondSize = 0;

  /** Creates a new base split panel. */
  public BaseSplitPanel() {
    element = div().addCss(dui_split_layout);
    init((T) this);
    element.onAttached(mutationRecord -> updatePanelsSize());
    onResize(
        (element1, observer, entries) -> {
          DomGlobal.requestAnimationFrame(
              timestamp -> {
                updatePanelsSize();
              });
        });
  }

  /**
   * Updates the sizes of the panels based on the current configuration. It calculates the required
   * size for each panel taking into account the splitter size share and sets the appropriate size.
   */
  public final void updatePanelsSize() {
    if (!panels.isEmpty()) {
      List<SplitPanel> visiblePanelsList =
          panels.stream().filter(BaseDominoElement::isVisible).collect(Collectors.toList());
      Iterator<SplitPanel> visiblePanels = visiblePanelsList.iterator();
      double hiddenPanelsSize =
          panels.stream().filter(BaseDominoElement::isHidden).mapToDouble(this::getPanelSize).sum();
      if (!visiblePanelsList.isEmpty()) {
        SplitPanel first = visiblePanels.next();
        if (hiddenPanelsSize > 0) {
          while (visiblePanels.hasNext()) {
            SplitPanel second = visiblePanels.next();
            onResizeStart(first, second);
            resizePanels(first, second, hiddenPanelsSize);
            first = second;
          }
        } else {
          if (visiblePanelsList.size() > 1) {
            while (visiblePanels.hasNext()) {
              SplitPanel second = visiblePanels.next();
              onResizeStart(first, second);
              resizePanels(first, second, 0);
              first = second;
            }
          } else {
            setPanelSize(first, Unit.px.of(getSize()));
          }
        }
      }
    }
  }

  /**
   * Calculates and returns the size share for the splitters based on the number of panels. The
   * calculation uses the CSS variable for the splitter size to determine how much space the
   * splitters occupy.
   *
   * @return the calculated size share in CSS format.
   */
  public String getSplittersSizeShare() {
    int n = panels.size();
    return "(var(--dui-split-layout-splitter-size)*" + (n - 1) + "/" + n + ")";
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation captures the starting sizes of the two provided panels which will be
   * resized.
   *
   * @param first The first panel involved in the resizing.
   * @param second The second panel involved in the resizing.
   */
  @Override
  public void onResizeStart(SplitPanel first, SplitPanel second) {
    this.firstSize = Math.round(getPanelSize(first));
    this.secondSize = Math.round(getPanelSize(second));
  }

  /**
   * {@inheritDoc}
   *
   * <p>This implementation performs the resizing of the two provided panels based on the specified
   * size difference. The resizing is subject to constraints such as minimum and maximum sizes or
   * percentages.
   *
   * @param first The first panel to be resized.
   * @param second The second panel to be resized.
   * @param sizeDiff The size difference used for resizing.
   */
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
   * Retrieves the size of the provided panel. The actual implementation will be provided by
   * subclasses.
   *
   * @param panel The panel whose size is to be retrieved.
   * @return the size of the panel.
   */
  protected abstract double getPanelSize(SplitPanel panel);

  /**
   * Sets the size of the provided panel. The actual implementation will be provided by subclasses.
   *
   * @param panel The panel whose size is to be set.
   * @param size The new size to be set, in CSS format.
   */
  protected abstract void setPanelSize(SplitPanel panel, String size);

  /**
   * Appends the given {@link SplitPanel} to the current split panel layout.
   *
   * @param panel the panel to append
   * @return the current instance of {@link T}
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

  public T appendChild(SplitPanel... panels) {
    Arrays.stream(panels).forEach(this::appendChild);
    return (T) this;
  }

  /**
   * Creates and returns a splitter element used between two panels. This method is intended to be
   * implemented by subclasses to provide a concrete representation and behavior for the splitter
   * based on the context in which it will be used.
   *
   * <p>Example Usage:
   *
   * <pre>
   * protected MySplitter createSplitter(SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
   *     return new MySplitter(first, second, mainPanel);
   * }
   * </pre>
   *
   * @param first The first panel that the splitter will be between.
   * @param second The second panel that the splitter will be between.
   * @param mainPanel The main panel in which both panels and the splitter reside.
   * @return the created splitter element.
   */
  protected abstract S createSplitter(
      SplitPanel first, SplitPanel second, HasSplitPanels mainPanel);

  /**
   * Allows customization of the splitters contained within this split panel.
   *
   * @param handler the handler to manipulate the splitters
   * @return the current instance of {@link T}
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
