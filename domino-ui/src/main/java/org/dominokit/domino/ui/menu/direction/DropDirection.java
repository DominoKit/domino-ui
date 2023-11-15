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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.Element;
import elemental2.dom.Event;
import org.dominokit.domino.ui.style.CssClass;

/** DropDirection interface. */
public interface DropDirection {
  /**
   * init.
   *
   * @param event a {@link elemental2.dom.Event} object
   * @return a {@link org.dominokit.domino.ui.menu.direction.DropDirection} object
   */
  default DropDirection init(Event event) {
    return this;
  }

  /**
   * position.
   *
   * @param source a {@link elemental2.dom.Element} object
   * @param target a {@link elemental2.dom.Element} object
   */
  void position(Element source, Element target);

  /**
   * cleanup.
   *
   * @param source a {@link elemental2.dom.Element} object
   */
  default void cleanup(Element source) {}

  /** Constant <code>BEST_FIT_SIDE</code> */
  DropDirection BEST_FIT_SIDE = new BestFitSideDropDirection();
  /** Constant <code>BEST_MIDDLE_SIDE</code> */
  DropDirection BEST_MIDDLE_SIDE = new BestMiddleSideDropDirection();
  /** Constant <code>BEST_MIDDLE_UP_DOWN</code> */
  DropDirection BEST_MIDDLE_UP_DOWN = new BestMiddleUpDownDropDirection();
  /** Constant <code>BEST_MIDDLE_DOWN_UP</code> */
  DropDirection BEST_MIDDLE_DOWN_UP = new BestMiddleDownUpDropDirection();
  /** Constant <code>BEST_SIDE_UP_DOWN</code> */
  DropDirection BEST_SIDE_UP_DOWN = new BestSideUpDownDropDirection();
  /** Constant <code>BOTTOM_LEFT</code> */
  DropDirection BOTTOM_LEFT = new BottomLeftDropDirection();
  /** Constant <code>BOTTOM_MIDDLE</code> */
  DropDirection BOTTOM_MIDDLE = new BottomMiddleDropDirection();
  /** Constant <code>BOTTOM_RIGHT</code> */
  DropDirection BOTTOM_RIGHT = new BottomRightDropDirection();
  /** Constant <code>LEFT_DOWN</code> */
  DropDirection LEFT_DOWN = new LeftDownDropDirection();
  /** Constant <code>LEFT_MIDDLE</code> */
  DropDirection LEFT_MIDDLE = new LeftMiddleDropDirection();
  /** Constant <code>LEFT_UP</code> */
  DropDirection LEFT_UP = new LeftUpDropDirection();
  /** Constant <code>MIDDLE_SCREEN</code> */
  DropDirection MIDDLE_SCREEN = new MiddleOfScreenDropDirection();
  /** Constant <code>BEST_MOUSE_FIT</code> */
  DropDirection BEST_MOUSE_FIT = new MouseBestFitDirection();
  /** Constant <code>RIGHT_DOWN</code> */
  DropDirection RIGHT_DOWN = new RightDownDropDirection();
  /** Constant <code>RIGHT_MIDDLE</code> */
  DropDirection RIGHT_MIDDLE = new RightMiddleDropDirection();
  /** Constant <code>RIGHT_UP</code> */
  DropDirection RIGHT_UP = new RightUpDropDirection();
  /** Constant <code>TOP_LEFT</code> */
  DropDirection TOP_LEFT = new TopLeftDropDirection();
  /** Constant <code>TOP_MIDDLE</code> */
  DropDirection TOP_MIDDLE = new TopMiddleDropDirection();

  /** Constant <code>TOP_RIGHT</code> */
  DropDirection TOP_RIGHT = new TopRightDropDirection();

  /** Constant <code>dui_dd_bottom_left</code> */
  CssClass dui_dd_bottom_left = () -> "dui-dd-bottom-left";
  /** Constant <code>dui_dd_bottom_middle</code> */
  CssClass dui_dd_bottom_middle = () -> "dui-dd-bottom-middle";
  /** Constant <code>dui_dd_bottom_right</code> */
  CssClass dui_dd_bottom_right = () -> "dui-dd-bottom-right";
  /** Constant <code>dui_dd_left_down</code> */
  CssClass dui_dd_left_down = () -> "dui-dd-left-down";
  /** Constant <code>dui_dd_left_middle</code> */
  CssClass dui_dd_left_middle = () -> "dui-dd-left-middle";
  /** Constant <code>dui_dd_left_up</code> */
  CssClass dui_dd_left_up = () -> "dui-dd-left-up";
  /** Constant <code>dui_dd_middle_screen</code> */
  CssClass dui_dd_middle_screen = () -> "dui-dd-middle-screen";
  /** Constant <code>dui_dd_best_mouse_fit</code> */
  CssClass dui_dd_best_mouse_fit = () -> "dui-dd-best-mouse-fit";
  /** Constant <code>dui_dd_right_down</code> */
  CssClass dui_dd_right_down = () -> "dui-dd-right-down";
  /** Constant <code>dui_dd_right_middle</code> */
  CssClass dui_dd_right_middle = () -> "dui-dd-right-middle";
  /** Constant <code>dui_dd_right_up</code> */
  CssClass dui_dd_right_up = () -> "dui-dd-right-up";
  /** Constant <code>dui_dd_top_left</code> */
  CssClass dui_dd_top_left = () -> "dui-dd-top-left";
  /** Constant <code>dui_dd_top_middle</code> */
  CssClass dui_dd_top_middle = () -> "dui-dd-top-middle";
  /** Constant <code>dui_dd_top_right</code> */
  CssClass dui_dd_top_right = () -> "dui-dd-top-right";
}
