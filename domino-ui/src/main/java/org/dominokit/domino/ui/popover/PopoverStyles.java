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
package org.dominokit.domino.ui.popover;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link Popover} */
public interface PopoverStyles {

  CssClass dui_popover_arrow = () -> "dui-popover-arrow";
  CssClass dui_popover = () -> "dui-popover";
  CssClass dui_popover_wrapper = () -> "dui-popover-wrapper";
  CssClass dui_popover_header = () -> "dui-popover-header";
  CssClass dui_popover_body = () -> "dui-popover-body";

  CssClass dui_pop_top = () -> "dui-pop-top";
  CssClass dui_pop_right = () -> "dui-pop-right";
  CssClass dui_pop_bottom = () -> "dui-pop-bottom";
  CssClass dui_pop_left = () -> "dui-pop-left";
  CssClass dui_tooltip = () -> "dui-tooltip";
}
