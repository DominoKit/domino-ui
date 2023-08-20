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
package org.dominokit.domino.ui.button;

import org.dominokit.domino.ui.style.CssClass;

/** A constants class to reference css classes used in Button components */
public interface ButtonStyles {
  /** Constant <code>dui_button</code> */
  CssClass dui_button = () -> "dui-btn";
  /** Constant <code>dui_button_body</code> */
  CssClass dui_button_body = () -> "dui-btn-body";
  /** Constant <code>dui_button_text</code> */
  CssClass dui_button_text = () -> "dui-btn-text";
  /** Constant <code>dui_button_icon</code> */
  CssClass dui_button_icon = () -> "dui-btn-icon";
  /** Constant <code>dui_button_split</code> */
  CssClass dui_button_split = () -> "dui-btn-split";
  /** Constant <code>dui_button_group</code> */
  CssClass dui_button_group = () -> "dui-btn-group";
  /** Constant <code>dui_button_toolbar</code> */
  CssClass dui_button_toolbar = () -> "dui-btn-toolbar";
  /** Constant <code>dui_vertical</code> */
  CssClass dui_vertical = () -> "dui-vertical";
  /** Constant <code>dui_circle</code> */
  CssClass dui_circle = () -> "dui-circle";
  /** Constant <code>dui_button_reversed</code> */
  CssClass dui_button_reversed = () -> "dui-btn-reverse";

  /** Constant <code>dui_top_scroller</code> */
  CssClass dui_top_scroller = () -> "dui-top-scroller";
}
