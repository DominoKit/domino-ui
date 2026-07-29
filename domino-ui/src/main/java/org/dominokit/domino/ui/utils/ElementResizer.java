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
package org.dominokit.domino.ui.utils;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;
import static org.dominokit.domino.ui.utils.Unit.px;

import elemental2.dom.CSSStyleDeclaration;
import elemental2.dom.DOMRect;
import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import elemental2.dom.Touch;
import elemental2.dom.TouchEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.IsElement;
import org.dominokit.domino.ui.elements.DivElement;
import org.dominokit.domino.ui.events.EventType;

/**
 * Utility class to make any element resizable from top, bottom, left, right, and bottom-right
 * corner.
 *
 * <pre>
 * ElementResizer resizer = ElementResizer.create(divElement);
 * // ...
 * resizer.remove();
 * </pre>
 */
public class ElementResizer implements ElementResizerStyles {

  /**
   * Creates an {@link ElementResizer} for the given element.
   *
   * @param element the element to be made resizable
   * @return an {@link ElementResizer} instance
   */
  public static ElementResizer create(Element element) {
    if (isNull(element)) {
      return null;
    }
    ElementResizer resizer = new ElementResizer(Js.uncheckedCast(element));
    return resizer;
  }

  /**
   * Creates an {@link ElementResizer} for the given {@link IsElement}.
   *
   * @param element the element to be made resizable
   * @return an {@link ElementResizer} instance
   */
  public static ElementResizer create(IsElement<? extends Element> element) {
    if (isNull(element)) {
      return null;
    }
    return create(element.element());
  }

  private final DominoElement<HTMLElement> target;
  private final DivElement topHandle;
  private final DivElement bottomHandle;
  private final DivElement leftHandle;
  private final DivElement rightHandle;
  private final DivElement cornerHandle;

  private final EventListener moveListener;
  private final EventListener stopListener;

  private ResizeDirection activeDirection;
  private double startX;
  private double startY;
  private double startWidth;
  private double startHeight;
  private double startLeft;
  private double startTop;
  private double minWidth;
  private double minHeight;

  private String originalPosition;
  private String originalTransition;
  private boolean positionAdjusted;
  private boolean removed;

  private ElementResizer(HTMLElement element) {
    this.target = elements.wrap(element);
    this.moveListener = this::onResize;
    this.stopListener = evt -> stopResize();

    ensurePositioned();
    target.addCss(dui_element_resizer);

    this.topHandle = createHandle(ResizeDirection.TOP);
    this.bottomHandle = createHandle(ResizeDirection.BOTTOM);
    this.leftHandle = createHandle(ResizeDirection.LEFT);
    this.rightHandle = createHandle(ResizeDirection.RIGHT);
    this.cornerHandle = createHandle(ResizeDirection.BOTTOM_RIGHT);

    target.appendChild(topHandle, bottomHandle, leftHandle, rightHandle, cornerHandle);
  }

  /** Removes the resizer handles and related CSS classes from the target element. */
  public void remove() {
    if (removed) {
      return;
    }
    removed = true;
    stopResize();
    topHandle.remove();
    bottomHandle.remove();
    leftHandle.remove();
    rightHandle.remove();
    cornerHandle.remove();
    target.removeCss(dui_element_resizer);
    if (positionAdjusted) {
      target.element().style.position = originalPosition;
    }
  }

  /** Alias for {@link #remove()}. */
  public void clear() {
    remove();
  }

  /**
   * Checks if the element is currently being resized via this resizer.
   *
   * @return {@code true} if resizing is active, {@code false} otherwise
   */
  public boolean isResizing() {
    return nonNull(activeDirection) && !removed;
  }

  private DivElement createHandle(ResizeDirection direction) {
    DivElement handle = elements.div().addCss(dui_element_resizer_handle);
    switch (direction) {
      case TOP:
        handle.addCss(dui_element_resizer_top);
        break;
      case BOTTOM:
        handle.addCss(dui_element_resizer_bottom);
        break;
      case LEFT:
        handle.addCss(dui_element_resizer_left);
        break;
      case RIGHT:
        handle.addCss(dui_element_resizer_right);
        break;
      case BOTTOM_RIGHT:
        handle.addCss(dui_element_resizer_corner);
        break;
      default:
        break;
    }

    EventListener startListener = evt -> startResize(evt, direction);
    handle.addEventListener(EventType.mousedown, startListener);
    handle.addEventListener(EventType.touchstart, startListener);
    return handle;
  }

  private void startResize(Event event, ResizeDirection direction) {
    if (removed) {
      return;
    }
    if (nonNull(event) && nonNull(event.type) && event.type.startsWith("mouse")) {
      MouseEvent mouseEvent = Js.uncheckedCast(event);
      if (mouseEvent.button != 0) {
        return;
      }
    }
    event.stopPropagation();
    event.preventDefault();
    stopResize();
    activeDirection = direction;
    originalTransition = target.element().style.transition;
    target.element().style.transition = "none";
    captureStartState(event);

    if (nonNull(DominoDom.document) && nonNull(DominoDom.document.body)) {
      DominoDom.document.body.addEventListener(EventType.mousemove.getName(), moveListener);
      DominoDom.document.body.addEventListener(EventType.touchmove.getName(), moveListener);
      DominoDom.document.body.addEventListener(EventType.mouseup.getName(), stopListener);
      DominoDom.document.body.addEventListener(EventType.touchend.getName(), stopListener);
      DominoDom.document.body.addEventListener(EventType.touchcancel.getName(), stopListener);
    }
  }

  private void captureStartState(Event event) {
    startX = getClientX(event);
    startY = getClientY(event);

    DOMRect rect = target.element().getBoundingClientRect();
    startWidth = rect.width;
    startHeight = rect.height;

    CSSStyleDeclaration style = DominoDom.window.getComputedStyle(target.element());
    boolean relativeOffsets = "relative".equals(style.position);
    startLeft = resolveStartOffset(style.left, target.element().offsetLeft, relativeOffsets);
    startTop = resolveStartOffset(style.top, target.element().offsetTop, relativeOffsets);
    minWidth = parsePx(style.minWidth.asString(), 0);
    minHeight = parsePx(style.minHeight.asString(), 0);
  }

  private void onResize(Event event) {
    if (isNull(activeDirection) || removed) {
      return;
    }
    event.preventDefault();
    double dx = getClientX(event) - startX;
    double dy = getClientY(event) - startY;

    if (activeDirection.resizesRight()) {
      double nextWidth = Math.max(minWidth, startWidth + dx);
      target.setWidth(px.of(nextWidth));
    }

    if (activeDirection.resizesBottom()) {
      double nextHeight = Math.max(minHeight, startHeight + dy);
      target.setHeight(px.of(nextHeight));
    }

    if (activeDirection.resizesLeft()) {
      double nextWidth = Math.max(minWidth, startWidth - dx);
      double nextLeft = startLeft + (startWidth - nextWidth);
      target.setWidth(px.of(nextWidth));
      target.setLeft(px.of(nextLeft));
    }

    if (activeDirection.resizesTop()) {
      double nextHeight = Math.max(minHeight, startHeight - dy);
      double nextTop = startTop + (startHeight - nextHeight);
      target.setHeight(px.of(nextHeight));
      target.setTop(px.of(nextTop));
    }
  }

  private void stopResize() {
    activeDirection = null;
    if (nonNull(originalTransition)) {
      target.element().style.transition = originalTransition;
      originalTransition = null;
    }
    if (nonNull(DominoDom.document) && nonNull(DominoDom.document.body)) {
      DominoDom.document.body.removeEventListener(EventType.mousemove.getName(), moveListener);
      DominoDom.document.body.removeEventListener(EventType.touchmove.getName(), moveListener);
      DominoDom.document.body.removeEventListener(EventType.mouseup.getName(), stopListener);
      DominoDom.document.body.removeEventListener(EventType.touchend.getName(), stopListener);
      DominoDom.document.body.removeEventListener(EventType.touchcancel.getName(), stopListener);
    }
  }

  private void ensurePositioned() {
    CSSStyleDeclaration style = DominoDom.window.getComputedStyle(target.element());
    if ("static".equals(style.position)) {
      originalPosition = target.element().style.position;
      target.element().style.position = "relative";
      positionAdjusted = true;
    }
  }

  private static double parsePx(String value, double fallback) {
    if (isNull(value) || value.isEmpty() || "auto".equals(value)) {
      return fallback;
    }
    if (value.endsWith("px")) {
      try {
        return Double.parseDouble(value.substring(0, value.length() - 2));
      } catch (NumberFormatException ignored) {
        return fallback;
      }
    }
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException ignored) {
      return fallback;
    }
  }

  private static double resolveStartOffset(String value, double offsetFallback, boolean relative) {
    if (isNull(value) || value.isEmpty() || "auto".equals(value)) {
      return relative ? 0 : offsetFallback;
    }
    if (value.endsWith("px")) {
      try {
        return Double.parseDouble(value.substring(0, value.length() - 2));
      } catch (NumberFormatException ignored) {
        return relative ? 0 : offsetFallback;
      }
    }
    try {
      return Double.parseDouble(value);
    } catch (NumberFormatException ignored) {
      return relative ? 0 : offsetFallback;
    }
  }

  private static double getClientX(Event event) {
    if (isTouchEvent(event)) {
      TouchEvent touchEvent = Js.uncheckedCast(event);
      Touch touch = touchEvent.touches.length > 0 ? touchEvent.touches.item(0) : null;
      if (isNull(touch) && touchEvent.changedTouches.length > 0) {
        touch = touchEvent.changedTouches.item(0);
      }
      return nonNull(touch) ? touch.clientX : 0;
    }
    MouseEvent mouseEvent = Js.uncheckedCast(event);
    return mouseEvent.clientX;
  }

  private static double getClientY(Event event) {
    if (isTouchEvent(event)) {
      TouchEvent touchEvent = Js.uncheckedCast(event);
      Touch touch = touchEvent.touches.length > 0 ? touchEvent.touches.item(0) : null;
      if (isNull(touch) && touchEvent.changedTouches.length > 0) {
        touch = touchEvent.changedTouches.item(0);
      }
      return nonNull(touch) ? touch.clientY : 0;
    }
    MouseEvent mouseEvent = Js.uncheckedCast(event);
    return mouseEvent.clientY;
  }

  private static boolean isTouchEvent(Event event) {
    return nonNull(event) && nonNull(event.type) && event.type.startsWith("touch");
  }

  private enum ResizeDirection {
    TOP,
    BOTTOM,
    LEFT,
    RIGHT,
    BOTTOM_RIGHT;

    boolean resizesRight() {
      return this == RIGHT || this == BOTTOM_RIGHT;
    }

    boolean resizesBottom() {
      return this == BOTTOM || this == BOTTOM_RIGHT;
    }

    boolean resizesLeft() {
      return this == LEFT;
    }

    boolean resizesTop() {
      return this == TOP;
    }
  }
}
