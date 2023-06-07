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
package org.dominokit.domino.ui.dialogs;

import elemental2.dom.*;
import jsinterop.base.Js;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.layout.NavBar;
import org.dominokit.domino.ui.utils.PostfixAddOn;
import org.dominokit.domino.ui.events.EventType;

/**
 * A component that open a pop-up that acts like a window with close/maximize/minimize controls and
 * can be dragged across the page
 */
public class Window extends AbstractDialog<Window> {

  private final MdiIcon restoreIcon;
  private final MdiIcon maximizeIcon;
  private final MdiIcon closeIcon;
  private boolean maximized = false;

  private double mouseX;
  private double mouseY;

  private boolean startMoving = false;
  private double deltaX;
  private double deltaY;

  private final EventListener moveListener;
  private final EventListener stopMoveListener;

  private double windowLeft = -1;
  private double windowTop = -1;

  private boolean draggable = true;
  private boolean fixed;
  private boolean maximizing = false;

  private NavBar navHeader;

  /**
   * @param title String window title
   * @return new Window instance
   */
  public static Window create(String title) {
    return new Window(title);
  }

  /** @param title String window title */
  public Window(String title) {
    super();
    headerElement.get().appendChild(navHeader = NavBar.create(title).addCss(dui_dialog_nav));
    setModal(false);
    setAutoClose(false);
    addCss(dui_window);

    restoreIcon =
        Icons
            .window_restore()
                .addCss(dui_order_last_1)
            .clickable()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  restore();
                })
            .collapse();
    maximizeIcon =
        Icons
            .window_maximize()
                .addCss(dui_order_last_1)
            .clickable()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  maximize();
                });
    closeIcon =
        Icons
            .close()
                .addCss(dui_order_last_4)
            .clickable()
            .addClickListener(
                evt -> {
                  evt.stopPropagation();
                  close();
                });

    navHeader.appendChild(PostfixAddOn.of(maximizeIcon));
    navHeader.appendChild(PostfixAddOn.of(restoreIcon));
    navHeader.appendChild(PostfixAddOn.of(closeIcon));

    moveListener = this::onMove;
    stopMoveListener =
        evt -> {
          if (draggable) {
            modalElement.removeCss(dui_no_transition);
            startMoving = false;
          }
        };

    addExpandListener(component -> addMoveListeners());
    addCollapseListener(component -> removeMoveListeners());
    updatePosition();

    onResize((element1, observer, entries) -> updatePosition());
  }

  private void onMove(Event evt) {
    evt.preventDefault();
    if (draggable) {
      MouseEvent mouseEvent = Js.uncheckedCast(evt);
      if (startMoving && mouseEvent.button == 0 && !maximized) {

        mouseX = mouseEvent.clientX;
        mouseY = mouseEvent.clientY;

        double initialWidth = modalElement.element().offsetWidth;
        double initialHeight = modalElement.element().offsetHeight;

        double windowWidth = DomGlobal.window.innerWidth;
        double windowHeight = DomGlobal.window.innerHeight;

        double left = mouseX + deltaX;
        double top = mouseY + deltaY;

        if (left > 0 && left < (windowWidth - initialWidth)) {
          modalElement.element().style.left = left + "px";
          this.windowLeft = left;
        }

        if (top > 0 && top < (windowHeight - initialHeight)) {
          modalElement.element().style.top = top + "px";
          this.windowTop = top;
        }
      }
    }
  }

  private void updatePosition() {
    if (maximized) {
      modalElement.element().style.left = "0px";
      modalElement.element().style.top = "0px";
    } else {
      DOMRect windowRect = modalElement.element().getBoundingClientRect();
      double initialWidth = windowRect.width;
      double windowWidth = DomGlobal.window.innerWidth;
      double initialHeight = windowRect.height;
      double windowHeight = DomGlobal.window.innerHeight;

      if (windowLeft > 0) {
        if (windowLeft < (windowWidth - initialWidth)) {
          modalElement.element().style.left = windowLeft + "px";
        } else {
          modalElement.element().style.left =
              windowLeft
                  - ((windowLeft + initialWidth) - windowWidth - DomGlobal.window.pageXOffset)
                  + "px";
        }
      } else {
        modalElement.element().style.left =
            ((windowWidth - initialWidth) / 2)
                + ((fixed ? 0 : DomGlobal.window.pageXOffset))
                + "px";
      }

      if (windowTop > 0) {
        if (windowTop < (windowHeight - initialHeight)) {
          modalElement.element().style.top = windowTop + "px";
        } else {
          modalElement.element().style.left =
              windowTop
                  - ((windowLeft + initialHeight) - windowHeight - DomGlobal.window.pageYOffset)
                  + "px";
        }
      } else {
        modalElement.element().style.top =
            (fixed ? 0 : DomGlobal.window.pageYOffset)
                - ((initialHeight - windowHeight) / 2)
                + "px";
        ;
      }

      if (windowTop < 0) {
        modalElement.element().style.top =
            (fixed ? 0 : DomGlobal.window.pageYOffset)
                - ((initialHeight - windowHeight) / 2)
                + "px";
      } else {
        modalElement.element().style.top = windowTop + "px";
      }
    }
  }

  private void removeMoveListeners() {
    DomGlobal.document.body.removeEventListener(EventType.mouseup.getName(), stopMoveListener);
    DomGlobal.document.body.removeEventListener(EventType.touchend.getName(), stopMoveListener);
    DomGlobal.document.body.removeEventListener(EventType.mousemove.getName(), moveListener);
    DomGlobal.document.body.removeEventListener(EventType.touchmove.getName(), moveListener);
    headerElement.element().removeEventListener(EventType.mousemove.getName(), moveListener);
    headerElement.element().removeEventListener(EventType.touchmove.getName(), moveListener);
    headerElement.element().removeEventListener(EventType.mouseup.getName(), stopMoveListener);
    headerElement.element().removeEventListener(EventType.touchend.getName(), stopMoveListener);
  }

  private void addMoveListeners() {
    headerElement
        .get()
        .addEventsListener(
            evt -> {
              if (draggable) {
                MouseEvent mouseEvent = Js.uncheckedCast(evt);
                if (!startMoving && mouseEvent.button == 0) {
                  modalElement.addCss(dui_no_transition);
                  deltaX = modalElement.element().offsetLeft - mouseEvent.clientX;
                  deltaY = modalElement.element().offsetTop - mouseEvent.clientY;

                  startMoving = true;
                }
              }
            },
            true,
            "mousedown",
            "touchstart");

    headerElement.element().addEventsListener(stopMoveListener, true, "mouseup", "touchend");
    headerElement.element().addEventsListener(moveListener, true, "mousemove", "touchmove");
    body().addEventsListener(stopMoveListener, "mouseup", "touchend");
  }

  /** @return boolean, true if this window can be dragged across the screen */
  public boolean isDraggable() {
    return draggable;
  }

  /**
   * @param draggable boolean true to make this window instance draggable
   * @return same Window instance
   */
  public Window setDraggable(boolean draggable) {
    this.draggable = draggable;
    return this;
  }

  /**
   * Stretch the window to cover the full screen
   *
   * @return same Window instance
   */
  public Window maximize() {
    maximizing = true;
    maximizeIcon.collapse();
    restoreIcon.expand();
    maximized = true;
    updatePosition();
    addCss(dui_maximized);
    maximizing = false;
    return this;
  }

  /**
   * If maximized restore the Window to its original size
   *
   * @return same Window instance
   */
  public Window restore() {
    restoreIcon.collapse();
    maximizeIcon.expand();
    maximized = false;
    Window.this.removeCss("maximized");
    removeCss(dui_maximized);
    updatePosition();
    return this;
  }

  /**
   * Make the position of the Window fixed allowing the content of the page to scroll while the
   * window stay in its position
   *
   * @return same Window instance
   */
  public Window setFixed() {
    addCss(dui_fixed);
    this.fixed = true;
    updatePosition();
    return this;
  }

  /** @return boolean, true if the Window is maximized */
  public boolean isMaximized() {
    return maximized;
  }

  /** @return the double left position of the window */
  public double getWindowLeft() {
    return windowLeft;
  }

  /**
   * @param windowLeft double window left position
   * @return same Window instance
   */
  public Window setWindowLeft(double windowLeft) {
    this.windowLeft = windowLeft;
    return this;
  }

  /** @return double top position of the window */
  public double getWindowTop() {
    return windowTop;
  }

  /**
   * @param windowTop double top position of the window
   * @return same Window instance
   */
  public Window setWindowTop(double windowTop) {
    this.windowTop = windowTop;
    return this;
  }

  private void initPosition() {
    addExpandListener(component->updatePosition());
  }

  /**
   * Hides the resize controls from the title bar
   *
   * @return same Window instance
   */
  public Window hideResizing() {
    restoreIcon.collapse();
    maximizeIcon.collapse();
    return this;
  }

  public Window setTitle(String title) {
    navHeader.setTitle(title);
    return this;
  }

  /**
   * Show the resize controls in the title bar
   *
   * @return same Window instance
   */
  public Window showResizing() {
    if (maximized) {
      maximizeIcon.collapse();
      restoreIcon.expand();
    } else {
      maximizeIcon.expand();
      restoreIcon.collapse();
    }
    return this;
  }

  /**
   * Hides the close control from the title bar
   *
   * @return same Window instance
   */
  public Window hideClosing() {
    closeIcon.collapse();
    return this;
  }

  /**
   * Show the close control in the title bar
   *
   * @return same Window instance
   */
  public Window showClosing() {
    closeIcon.expand();
    return this;
  }

  /** @return the {@link MdiIcon} of the restore window size control */
  public MdiIcon getRestoreIcon() {
    return restoreIcon;
  }

  /** @return the {@link MdiIcon} of the maximize window size control */
  public MdiIcon getMaximizeIcon() {
    return maximizeIcon;
  }

  /** @return the {@link MdiIcon} of the close window control */
  public MdiIcon getCloseIcon() {
    return closeIcon;
  }
}
