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

/**
 * Default CSS classes for {@link org.dominokit.domino.ui.spin.SpinSelect} and {@link
 * org.dominokit.domino.ui.spin.SpinItem}
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface SpinStyles {

  /** Constant <code>dui_spin</code> */
  CssClass dui_spin = () -> "dui-spin";
  /** Constant <code>dui_spin_prev</code> */
  CssClass dui_spin_prev = () -> "dui-spin-prev";
  /** Constant <code>dui_spin_next</code> */
  CssClass dui_spin_next = () -> "dui-spin-next";
  /** Constant <code>dui_spin_content</code> */
  CssClass dui_spin_content = () -> "dui-spin-content";
  /** Constant <code>dui_spin_horizontal</code> */
  CssClass dui_spin_horizontal = () -> "dui-spin-horizontal";
  /** Constant <code>dui_spin_vertical</code> */
  CssClass dui_spin_vertical = () -> "dui-spin-vertical";
  /** Constant <code>dui_spin_item</code> */
  CssClass dui_spin_item = () -> "dui-spin-item";
  /** Constant <code>spinActivating</code> */
  CssClass spinActivating = () -> "dui-spin-item-activating";
  /** Constant <code>spinExiting</code> */
  CssClass spinExiting = () -> "dui-spin-item-exiting";
  /** Constant <code>dui_spin_exit_forward</code> */
  CssClass dui_spin_exit_forward = () -> "dui-spin-exit-forward";
  /** Constant <code>dui_spin_exit_backward</code> */
  CssClass dui_spin_exit_backward = () -> "dui-spin-exit-backward";
  /** Constant <code>dui_spin_animate</code> */
  CssClass dui_spin_animate = () -> "dui-spin-animate";
}
