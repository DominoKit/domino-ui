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

import elemental2.dom.EventListener;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.TouchEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * Represents the base splitter that allows for dynamic resizing of split panels.
 *
 * <p>Usage example:
 *
 * <pre>
 * BaseSplitter splitter = new MyConcreteSplitter(panel1, panel2, mainPanel);
 * splitter.withHandle((splitterInstance, handle) -> handle.addCss("my-handle-css"));
 * </pre>
 *
 * <p>Note: This is an abstract class and must be subclassed to provide specific splitter behavior.
 *
 * @param <T> the specific type of splitter extending this base class
 * @see BaseDominoElement
 */
abstract class BaseSplitter<T extends BaseSplitter<?>> extends BaseDominoElement<HTMLDivElement, T>
    implements HasSize, SplitStyles {

  private static final int LEFT_BUTTON = 1;

  protected DivElement element;
  protected final DivElement handleElement;
  private double initialStartPosition = 0;

  /**
   * Constructor to create a BaseSplitter.
   *
   * @param first the first split panel
   * @param second the second split panel
   * @param mainPanel the main panel containing the split panels
   */
  BaseSplitter(SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
    element =
        div()
            .addCss(dui_split_layout_splitter)
            .appendChild(handleElement = div().addCss(dui_splitter_handle));

    init((T) this);
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

    addEventListener(
        EventType.mousedown.getName(),
        evt -> {
          MouseEvent mouseEvent = Js.uncheckedCast(evt);
          initialStartPosition = mousePosition(mouseEvent);
          startResize(first, second, mainPanel);
          body().addEventListener(EventType.mousemove.getName(), resizeListener);
        });

    addEventListener(
        EventType.touchstart.getName(),
        evt -> {
          evt.preventDefault();
          evt.stopPropagation();
          TouchEvent touchEvent = Js.uncheckedCast(evt);
          initialStartPosition = touchPosition(touchEvent);
          startResize(first, second, mainPanel);
          body().addEventListener(EventType.touchmove.getName(), touchResizeListener);
        });

    addEventListener(
        EventType.mouseup.getName(),
        evt -> body().removeEventListener(EventType.mousemove.getName(), resizeListener));
    addEventListener(
        EventType.touchend.getName(),
        evt -> body().removeEventListener(EventType.touchmove.getName(), touchResizeListener));

    document.body.addEventListener(
        EventType.mouseup.getName(),
        evt -> body().removeEventListener(EventType.mousemove.getName(), resizeListener));
    document.body.addEventListener(
        EventType.touchend.getName(),
        evt -> body().removeEventListener(EventType.touchmove.getName(), touchResizeListener));
  }

  /**
   * Resizes the panels based on the given position.
   *
   * @param first the first split panel
   * @param second the second split panel
   * @param currentPosition the current mouse or touch position
   * @param mainPanel the main panel containing the split panels
   */
  private void resize(
      SplitPanel first, SplitPanel second, double currentPosition, HasSplitPanels mainPanel) {
    double diff = currentPosition - initialStartPosition;

    mainPanel.resizePanels(first, second, diff);
  }

  /**
   * Initiates the resize action for the panels.
   *
   * @param first the first split panel
   * @param second the second split panel
   * @param mainPanel the main panel containing the split panels
   */
  private void startResize(SplitPanel first, SplitPanel second, HasSplitPanels mainPanel) {
    mainPanel.onResizeStart(first, second);
  }

  /**
   * Extracts the mouse position from a mouse event. Must be implemented by subclasses.
   *
   * @param event the mouse event
   * @return the mouse position
   */
  protected abstract double mousePosition(MouseEvent event);

  /**
   * Extracts the touch position from a touch event. Must be implemented by subclasses.
   *
   * @param event the touch event
   * @return the touch position
   */
  protected abstract double touchPosition(TouchEvent event);

  /**
   * Allows for customization of the splitter's handle.
   *
   * @param handler a child handler to customize the handle
   * @return the instance of the splitter for method chaining
   */
  public T withHandle(ChildHandler<T, DivElement> handler) {
    handler.apply((T) this, handleElement);
    return (T) this;
  }

  /** {@inheritDoc} */
  @Override
  public HTMLDivElement element() {
    return element.element();
  }
}
