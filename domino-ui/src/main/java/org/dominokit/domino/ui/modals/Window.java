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
package org.dominokit.domino.ui.modals;

import static org.dominokit.domino.ui.style.Unit.px;

import elemental2.dom.DOMRect;
import elemental2.dom.DomGlobal;
import elemental2.dom.Event;
import elemental2.dom.EventListener;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;
import org.dominokit.domino.ui.dropdown.DropDownMenu;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.style.Calc;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.EventType;

/**
 * A component that open a pop-up that acts like a window with close/maximize/minimize controls and
 * can be dragged across the page
 */
@Deprecated
public class Window extends BaseModal<Window> {

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

  private String headerBackGround = Color.THEME.getBackground();

  private boolean draggable = true;
  private boolean fixed;
  private boolean maximizing = false;

  /**
   * @param title String window title
   * @return new Window instance
   */
  public static Window create(String title) {
    return new Window(title);
  }

  /** @param title String window title */
  public Window(String title) {
    super(title);
    init(this);
    elevate(10);
    setModal(false);
    css("window");
    modalElement.getModalHeader().css(headerBackGround);
    modalElement.getModalTitle().styler(style -> style.setFloat("left").setPadding(px.of(8)));

    restoreIcon = Icons.ALL.window_restore_mdi();
    maximizeIcon = Icons.ALL.window_maximize_mdi();
    closeIcon = Icons.ALL.close_mdi();
    modalElement
        .getModalHeader()
        .appendChild(
            FlexLayout.create()
                .styler(style -> style.setFloat("right"))
                .appendChild(
                    FlexItem.create()
                        .appendChild(
                            restoreIcon
                                .hide()
                                .size18()
                                .clickable()
                                .addClickListener(evt -> restore()))
                        .appendChild(
                            maximizeIcon.size18().clickable().addClickListener(evt -> maximize()))
                        .appendChild(
                            closeIcon.size18().clickable().addClickListener(evt -> close()))));

    moveListener = this::onMove;
    stopMoveListener =
        evt -> {
          if (draggable) {
            startMoving = false;
          }
        };

    addOpenListener(this::addMoveListeners);
    addCloseListener(this::removeMoveListeners);

    onResize(
        (element1, observer, entries) -> {
          double top = modalElement.element().offsetTop - deltaY;
          if (!maximizing) {
            DominoElement.of(modalElement.element()).setMaxHeight(Calc.sub("100vh", top + "px"));
            modalElement.getModalDialog().setMaxHeight(Calc.sub("100vh", top + "px"));
            modalElement.getModalContent().setMaxHeight(Calc.sub("100vh", top + "px"));
          } else {
            DominoElement.of(modalElement.element()).setMaxHeight(Calc.of("100vh"));
            modalElement.getModalDialog().setMaxHeight(Calc.of("100vh"));
            modalElement.getModalContent().setMaxHeight(Calc.of("100vh"));
          }
        });

    addBeforeShowListener(this::updatePosition);
    //    initPosition();
  }

  private void onMove(Event evt) {
    if (draggable) {
      MouseEvent mouseEvent = Js.uncheckedCast(evt);

      if (startMoving && mouseEvent.button == 0 && !maximized) {
        evt.preventDefault();
        deltaX = mouseX - mouseEvent.clientX;
        deltaY = mouseY - mouseEvent.clientY;
        mouseX = mouseEvent.clientX;
        mouseY = mouseEvent.clientY;

        double left = modalElement.element().offsetLeft - deltaX;
        double top = modalElement.element().offsetTop - deltaY;

        DOMRect windowRect = modalElement.getModalDialog().element().getBoundingClientRect();
        double initialWidth = windowRect.width;
        double initialHeight = windowRect.height;

        double windowWidth = DomGlobal.window.innerWidth;
        double windowHeight = DomGlobal.window.innerHeight;

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
    maximizeIcon.hide();
    restoreIcon.show();
    maximized = true;
    updatePosition();
    Window.this.css("maximized");
    ModalBackDrop.INSTANCE.showHideBodyScrolls();
    maximizing = false;
    return this;
  }

  /**
   * If maximized restore the Window to its original size
   *
   * @return same Window instance
   */
  public Window restore() {
    restoreIcon.hide();
    maximizeIcon.show();
    maximized = false;
    Window.this.removeCss("maximized");
    updatePosition();
    ModalBackDrop.INSTANCE.showHideBodyScrolls();
    return this;
  }

  /**
   * @param color {@link Color} of the window title bar
   * @return same Window instance
   */
  public Window setHeaderBackground(Color color) {
    modalElement.getModalHeader().removeCss(headerBackGround);
    modalElement.getModalHeader().css(color.getBackground());
    this.headerBackGround = color.getBackground();

    return this;
  }

  /**
   * Make the position of the Window fixed allowing the content of the page to scroll while the
   * window stay in its position
   *
   * @return same Window instance
   */
  public Window setFixed() {
    css("fixed");
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

  private void updatePosition() {
    if (maximized) {
      modalElement.element().style.left = "0px";
      modalElement.element().style.top = "0px";
    } else {
      DOMRect windowRect = modalElement.element().getBoundingClientRect();
      double initialWidth = windowRect.width;
      double windowWidth = DomGlobal.window.innerWidth;

      if (windowLeft < 0) {
        modalElement.element().style.left =
            ((windowWidth - initialWidth) / 2)
                + ((fixed ? 0 : DomGlobal.window.pageXOffset))
                + "px";
      } else {
        modalElement.element().style.left = windowLeft + "px";
      }

      if (windowTop < 0) {
        if (isCenteredVertically()) {
          modalElement.element().style.top = "50%";
        } else {
          modalElement.element().style.top =
              100 + (fixed ? 0 : DomGlobal.window.pageYOffset) + "px";
        }
      } else {
        modalElement.element().style.top = windowTop + "px";
      }
    }
  }

  private void removeMoveListeners() {
    DomGlobal.document.body.removeEventListener(EventType.mouseup.getName(), stopMoveListener);
    DomGlobal.document.body.removeEventListener(EventType.mousemove.getName(), moveListener);
    modalElement.getModalHeader().removeEventListener(EventType.mousemove.getName(), moveListener);
    modalElement
        .getModalHeader()
        .removeEventListener(EventType.mouseup.getName(), stopMoveListener);
  }

  public void addMoveListeners() {
    modalElement
        .getModalHeader()
        .addEventListener(
            EventType.mousedown,
            evt -> {
              if (draggable) {
                DropDownMenu.closeAllMenus();
                POPUPS_CLOSER.close();
                MouseEvent mouseEvent = Js.uncheckedCast(evt);
                if (!startMoving && mouseEvent.button == 0) {
                  mouseEvent.stopPropagation();
                  mouseEvent.preventDefault();

                  mouseX = mouseEvent.clientX;
                  mouseY = mouseEvent.clientY;

                  startMoving = true;
                }
              }
            });

    modalElement.getModalHeader().addEventListener(EventType.mouseup, stopMoveListener);
    DomGlobal.document.body.addEventListener(EventType.mousemove.getName(), moveListener);
    DomGlobal.document.body.addEventListener(EventType.mouseup.getName(), stopMoveListener);
  }

  /**
   * Hides the resize controls from the title bar
   *
   * @return same Window instance
   */
  public Window hideResizing() {
    restoreIcon.hide();
    maximizeIcon.hide();
    return this;
  }

  /**
   * Show the resize controls in the title bar
   *
   * @return same Window instance
   */
  public Window showResizing() {
    if (maximized) {
      maximizeIcon.hide();
      restoreIcon.show();
    } else {
      maximizeIcon.show();
      restoreIcon.hide();
    }
    return this;
  }

  /**
   * Hides the close control from the title bar
   *
   * @return same Window instance
   */
  public Window hideClosing() {
    closeIcon.hide();
    return this;
  }

  /**
   * Show the close control in the title bar
   *
   * @return same Window instance
   */
  public Window showClosing() {
    closeIcon.show();
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
