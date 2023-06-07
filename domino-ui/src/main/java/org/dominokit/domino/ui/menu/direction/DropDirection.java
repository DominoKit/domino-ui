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

import elemental2.dom.Element;
import elemental2.dom.Event;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.style.HasCssClass;

import java.util.function.Supplier;

public interface DropDirection  {
  default DropDirection init(Event event) {
    return this;
  }

  void position(Element source, Element target);

  default void cleanup(Element source){

  }

  DropDirection BEST_FIT_SIDE  = new BestFitSideDropDirection();
  DropDirection BEST_MIDDLE_SIDE  = new BestMiddleSideDropDirection();
  DropDirection BEST_MIDDLE_UP_DOWN  = new BestMiddleUpDownDropDirection();
  DropDirection BEST_SIDE_UP_DOWN  = new BestSideUpDownDropDirection();
  DropDirection BOTTOM_LEFT  = new BottomLeftDropDirection();
  DropDirection BOTTOM_MIDDLE  = new BottomMiddleDropDirection();
  DropDirection BOTTOM_RIGHT  = new BottomRightDropDirection();
  DropDirection LEFT_DOWN  = new LeftDownDropDirection();
  DropDirection LEFT_MIDDLE  = new LeftMiddleDropDirection();
  DropDirection LEFT_UP  = new LeftUpDropDirection();
  DropDirection MIDDLE_SCREEN  = new MiddleOfScreenDropDirection();
  DropDirection BEST_MOUSE_FIT  = new MouseBestFitDirection();
  DropDirection RIGHT_DOWN  = new RightDownDropDirection();
  DropDirection RIGHT_MIDDLE  = new RightMiddleDropDirection();
  DropDirection RIGHT_UP  = new RightUpDropDirection();
  DropDirection TOP_LEFT  = new TopLeftDropDirection();
  DropDirection TOP_MIDDLE  = new TopMiddleDropDirection();

  DropDirection TOP_RIGHT  = new TopRightDropDirection();

  //-------------------------

  CssClass dui_dd_bottom_left  = ()->"dui-dd-bottom-left";
  CssClass dui_dd_bottom_middle  = ()->"dui-dd-bottom-middle";
  CssClass dui_dd_bottom_right  = ()->"dui-dd-bottom-right";
  CssClass dui_dd_left_down  = ()->"dui-dd-left-down";
  CssClass dui_dd_left_middle  = ()->"dui-dd-left-middle";
  CssClass dui_dd_left_up  = ()->"dui-dd-left-up";
  CssClass dui_dd_middle_screen  = ()->"dui-dd-middle-screen";
  CssClass dui_dd_best_mouse_fit  = ()->"dui-dd-best-mouse-fit";
  CssClass dui_dd_right_down  = ()->"dui-dd-right-down";
  CssClass dui_dd_right_middle  = ()->"dui-dd-right-middle";
  CssClass dui_dd_right_up  = ()->"dui-dd-right-up";
  CssClass dui_dd_top_left  = ()->"dui-dd-top-left";
  CssClass dui_dd_top_middle  = ()->"dui-dd-top-middle";
  CssClass dui_dd_top_right  = ()->"dui-dd-top-right";
}
