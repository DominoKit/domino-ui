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
  CssClass dui_button = () -> "dui-btn";
  CssClass dui_button_body = () -> "dui-btn-body";
  CssClass dui_button_text = () -> "dui-btn-text";
  CssClass dui_button_icon = () -> "dui-btn-icon";
  CssClass dui_button_split = () -> "dui-btn-split";
  CssClass dui_button_group = () -> "dui-btn-group";
  CssClass dui_button_toolbar = () -> "dui-btn-toolbar";
  CssClass dui_vertical = () -> "dui-vertical";
  CssClass dui_circle = () -> "dui-circle";
  CssClass dui_button_reversed = () -> "dui-btn-reverse";
}
