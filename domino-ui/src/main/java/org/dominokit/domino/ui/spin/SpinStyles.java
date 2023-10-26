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
package org.dominokit.domino.ui.spin;

import org.dominokit.domino.ui.style.CssClass;

public interface SpinStyles {

  CssClass dui_spin = () -> "dui-spin";
  CssClass dui_spin_prev = () -> "dui-spin-prev";
  CssClass dui_spin_next = () -> "dui-spin-next";
  CssClass dui_spin_content = () -> "dui-spin-content";
  CssClass dui_spin_horizontal = () -> "dui-spin-horizontal";
  CssClass dui_spin_vertical = () -> "dui-spin-vertical";
  CssClass dui_spin_item = () -> "dui-spin-item";
  CssClass spinActivating = () -> "dui-spin-item-activating";
  CssClass spinExiting = () -> "dui-spin-item-exiting";
  CssClass dui_spin_exit_forward = () -> "dui-spin-exit-forward";
  CssClass dui_spin_exit_backward = () -> "dui-spin-exit-backward";
  CssClass dui_spin_animate = () -> "dui-spin-animate";
}
