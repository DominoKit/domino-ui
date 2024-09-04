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
package org.dominokit.domino.ui.menu.direction;

import static elemental2.dom.DomGlobal.window;
import static org.dominokit.domino.ui.style.Unit.px;

import elemental2.dom.DOMRect;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import elemental2.dom.MouseEvent;
import jsinterop.base.Js;

/** Positions the menu on the bottom right of the mouse click location */
public class MouseBestFitDirection implements DropDirection {

  private MouseEvent mouseEvent;

  @Override
  public DropDirection init(Event event) {
    this.mouseEvent = Js.uncheckedCast(event);
    return this;
  }

  /** {@inheritDoc} */
  @Override
  public void position(HTMLElement source, HTMLElement target) {
    DOMRect sourceRect = source.getBoundingClientRect();
    int innerWidth = window.innerWidth;
    int innerHeight = window.innerHeight;

    double sourceHeight = sourceRect.height;
    double downSpace = innerHeight - mouseEvent.clientY;
    double sourceWidth = sourceRect.width;
    double rightSpace = innerWidth - mouseEvent.clientX;

    if (hasSpaceOnRightSide(sourceWidth, rightSpace)) {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        positionBottomRight(source, sourceHeight);
      } else {
        positionTopRight(source, sourceHeight);
      }
    } else {
      if (hasSpaceBelow(sourceHeight, downSpace)) {
        positionBottomLeft(source, sourceHeight, sourceWidth);
      } else {
        positionTopLeft(source, sourceHeight, sourceWidth);
      }
    }
  }

  private void positionBottomRight(HTMLElement source, double sourceHeight) {
    double delta = 0;
    double availableSpace = window.innerHeight - mouseEvent.clientY;
    if (availableSpace < sourceHeight) {
      delta = sourceHeight - availableSpace;
    }

    source.style.setProperty("top", px.of(mouseEvent.clientY - delta + window.pageYOffset));
    source.style.setProperty("left", px.of(mouseEvent.clientX + window.pageXOffset));
  }

  private void positionBottomLeft(HTMLElement source, double sourceHeight, double sourceWidth) {
    double delta = 0;
    double availableSpace = window.innerHeight - mouseEvent.clientY;
    if (availableSpace < sourceHeight) {
      delta = sourceHeight - availableSpace;
    }
    source.style.setProperty("top", px.of(mouseEvent.clientY - delta + window.pageYOffset));
    source.style.setProperty("left", px.of(mouseEvent.clientX - sourceWidth + window.pageXOffset));
  }

  private void positionTopRight(HTMLElement source, double sourceHeight) {
    double delta = 0;
    double availableSpace = mouseEvent.clientY;
    if (availableSpace < sourceHeight) {
      delta = sourceHeight - availableSpace;
    }
    source.style.setProperty(
        "top", px.of(mouseEvent.clientY - sourceHeight + delta + window.pageYOffset));
    source.style.setProperty("left", px.of(mouseEvent.clientX + window.pageXOffset));
  }

  private void positionTopLeft(HTMLElement source, double sourceHeight, double sourceWidth) {
    double delta = 0;
    double availableSpace = mouseEvent.clientY;
    if (availableSpace < sourceHeight) {
      delta = sourceHeight - availableSpace;
    }
    source.style.setProperty(
        "top", px.of(mouseEvent.clientY - sourceHeight + delta + window.pageYOffset));
    source.style.setProperty("left", px.of(mouseEvent.clientX - sourceWidth + window.pageXOffset));
  }

  private boolean hasSpaceBelow(double sourceHeight, double downSpace) {
    return downSpace > sourceHeight;
  }

  private boolean hasSpaceOnRightSide(double sourceWidth, double rightSpace) {
    return rightSpace > sourceWidth;
  }
}
