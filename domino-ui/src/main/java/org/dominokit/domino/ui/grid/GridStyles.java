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

/**
 * The {@code GridStyles} interface provides CSS classes for styling grid elements.
 *
 * <p>You can use the provided CSS classes to apply styles to various parts of a grid layout.
 *
 * <p>Example usage:
 *
 * <pre>
 * // Apply a grid column style
 * CssClass gridColumnStyle = GridStyles.dui_grid_col;
 * </pre>
 */
public interface GridStyles {
  /** Represents the CSS class for a grid column. */
  CssClass dui_grid_col = () -> "dui-grid-col";

  /** Represents the CSS class for a layout grid. */
  CssClass dui_layout_grid = () -> "dui-layout-grid";

  /** Represents the CSS class for grid content. */
  CssClass dui_grid_content = () -> "dui-grid-content";

  /** Represents the CSS class for grid header. */
  CssClass dui_grid_header = () -> "dui-grid-header";

  /** Represents the CSS class for grid footer. */
  CssClass dui_grid_footer = () -> "dui-grid-footer";

  /** Represents the CSS class for the left grid. */
  CssClass dui_grid_left = () -> "dui-grid-left";

  /** Represents the CSS class for the right grid. */
  CssClass dui_grid_right = () -> "dui-grid-right";

  /** Represents the CSS class for a grid row. */
  CssClass dui_grid_row = () -> "dui-grid-row";

  /** Represents the CSS class for an auto-sized grid. */
  CssClass dui_auto_grid = () -> "dui-auto-grid";
}
