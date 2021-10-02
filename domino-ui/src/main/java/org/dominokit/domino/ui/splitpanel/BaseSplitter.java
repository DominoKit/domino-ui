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

import static elemental2.dom.DomGlobal.document;
import static org.jboss.elemento.Elements.div;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

abstract class BaseSplitter<T extends BaseSplitter<?>>
    extends BaseDominoElement<HTMLDivElement, T> {

  private static final int LEFT_BUTTON = 1;

  protected DominoElement<HTMLDivElement> element =
      DominoElement.of(div().css(SplitStyles.SPLITTER));
  private final DominoElement<HTMLDivElement> handleElement =
      DominoElement.of(div().css(SplitStyles.SPLIT_HANDLE));

  private double fullSize = 0;
  private double initialStartPosition = 0;
  private double firstSize = 0;
  private double secondSize = 0;

  private ColorScheme colorScheme = ColorScheme.INDIGO;

  private static final boolean LEFT = true;
  private static final boolean RIGHT = false;

  BaseSplitter(SplitPanel first, SplitPanel second, HasSize mainPanel) {
    element.appendChild(handleElement);

    EventListener resizeListener =
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);

          if (LEFT_BUTTON == mouseEvent.buttons) {
            double currentPosition = mousePosition(mouseEvent);
            resize(first, second, currentPosition, mainPanel);
          }
        };

    EventListener touchResizeListener =
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          TouchEvent touchEvent = Js.uncheckedCast(evt);
          double currentPosition = touchPosition(touchEvent);
          resize(first, second, currentPosition, mainPanel);
        };

    element.addEventListener(
        EventType.mousedown.getName(),
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);
          initialStartPosition = mousePosition(mouseEvent);
          startResize(first, second, mainPanel);
          document.body.addEventListener(EventType.mousemove.getName(), resizeListener);
        });

    element.addEventListener(
        EventType.touchstart.getName(),
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          TouchEvent touchEvent = Js.uncheckedCast(evt);
          initialStartPosition = touchPosition(touchEvent);
          startResize(first, second, mainPanel);
          document.body.addEventListener(EventType.touchmove.getName(), touchResizeListener);
        });

    element.addEventListener(
        EventType.mouseup.getName(),
        evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
    element.addEventListener(
        EventType.touchend.getName(),
        evt ->
            document.body.removeEventListener(EventType.touchmove.getName(), touchResizeListener));

    document.body.addEventListener(
        EventType.mouseup.getName(),
        evt -> document.body.removeEventListener(EventType.mousemove.getName(), resizeListener));
    document.body.addEventListener(
        EventType.touchend.getName(),
        evt ->
            document.body.removeEventListener(EventType.touchmove.getName(), touchResizeListener));
  }

  private void resize(
      SplitPanel first, SplitPanel second, double currentPosition, HasSize mainPanel) {
    double diff = currentPosition - initialStartPosition;

    double firstSizeDiff =
        first.isFirst()
            ? this.firstSize + diff + (double) mainPanel.getSplitterSize() / 2
            : this.firstSize + diff + mainPanel.getSplitterSize();
    double secondSizeDiff =
        second.isLast()
            ? this.secondSize - diff + (double) mainPanel.getSplitterSize() / 2
            : this.secondSize - diff + mainPanel.getSplitterSize();

    double firstPercent = (firstSizeDiff / fullSize * 100);
    double secondPercent = (secondSizeDiff / fullSize * 100);
    double splitterPercent = mainPanel.getSplitterSize() / fullSize * 100;

    firstPercent = adjustPercent(firstPercent, splitterPercent);
    secondPercent = adjustPercent(secondPercent, splitterPercent);

    if (withinPanelLimits(first, firstSize, firstPercent, diff, LEFT)
        && withinPanelLimits(second, secondSize, secondPercent, diff, RIGHT)) {
      setNewSizes(first, second, firstPercent, secondPercent, mainPanel);
      first.onResize(firstSize, firstPercent);
      second.onResize(secondSize, secondPercent);
    }
  }

  static double adjustPercent(double percent, double splitterPercent) {
    double splitterShare = (splitterPercent / 2);
    if (percent < 0) {
      return 0;
    }
    if (percent > (100 - splitterShare)) {
      return 100 - splitterShare;
    }
    return percent;
  }

  private void startResize(SplitPanel first, SplitPanel second, HasSize mainPanel) {
    firstSize = getPanelSize(first);
    secondSize = getPanelSize(second);
    fullSize = getFullSize(mainPanel);
  }

  private double getFullSize(HasSize mainPanel) {
    return mainPanel.getSize();
  }

  protected abstract double getPanelSize(SplitPanel panel);

  protected abstract void setNewSizes(
      SplitPanel first,
      SplitPanel second,
      double firstPercent,
      double secondPercent,
      HasSize mainPanel);

  protected abstract double mousePosition(MouseEvent event);

  protected abstract double touchPosition(TouchEvent event);

  private boolean withinPanelLimits(
      SplitPanel panel, double topSize, double topPercent, double diff, boolean left) {
    return withinPanelSize(panel, topSize, diff, left)
        && withinPanelPercent(panel, topPercent, diff, left);
  }

  private boolean withinPanelSize(SplitPanel panel, double newSize, double diff, boolean left) {
    return (newSize > panel.getMinSize() || ((diff > 0 && left) || (diff < 0 && !left)))
        && (((panel.getMaxSize() > -1) && newSize < panel.getMaxSize()) || panel.getMaxSize() < 0);
  }

  private boolean withinPanelPercent(SplitPanel panel, double percent, double diff, boolean left) {
    return (percent > panel.getMinPercent() || ((diff > 0 && left) || (diff < 0 && !left)))
        && (((panel.getMaxPercent() > -1) && percent < panel.getMaxPercent())
            || panel.getMaxPercent() < 0);
  }

  public ColorScheme getColorScheme() {
    return colorScheme;
  }

  public T setColorScheme(ColorScheme colorScheme) {
    element
        .removeCss(this.colorScheme.lighten_4().getBackground())
        .addCss(colorScheme.lighten_4().getBackground());
    handleElement
        .removeCss(this.colorScheme.color().getBackground())
        .addCss(colorScheme.color().getBackground());

    this.colorScheme = colorScheme;
    return (T) this;
  }

  @Override
  public HTMLDivElement element() {
    return element.element();
  }

  public double getSize() {
    return element.getBoundingClientRect().height;
  }

  protected abstract void setSize(int size);
}
