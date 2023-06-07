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
package org.dominokit.domino.ui.grid;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link GridLayout} */
public interface GridStyles {
  /** CSS style for a grid column */
  CssClass dui_grid_col = () -> "dui-grid-col";

  /** CSS style for grid layout */
  CssClass dui_layout_grid = () -> "dui-layout-grid";
  /** CSS style for grid layout content */
  CssClass dui_grid_content = () -> "dui-grid-content";
  /** CSS style for grid layout header */
  CssClass dui_grid_header = () -> "dui-grid-header";
  /** CSS style for grid layout footer */
  CssClass dui_grid_footer = () -> "dui-grid-footer";
  /** CSS style for grid layout left section */
  CssClass dui_grid_left = () -> "dui-grid-left";
  /** CSS style for grid layout right section */
  CssClass dui_grid_right = () -> "dui-grid-right";
  /** CSS style for grid row */
  CssClass dui_grid_row = () -> "dui-grid-row";
}
