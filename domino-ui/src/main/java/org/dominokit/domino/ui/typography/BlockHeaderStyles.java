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
package org.dominokit.domino.ui.typography;

import org.dominokit.domino.ui.style.CssClass;

/**
 * Default CSS classes for {@link org.dominokit.domino.ui.typography.BlockHeader}
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface BlockHeaderStyles {

  /** CSS class for a block header */
  CssClass dui_block_header = () -> "dui-block-header";

  /** Constant <code>dui_block_header_title</code> */
  CssClass dui_block_header_title = () -> "dui-block-header-title";
  /** Constant <code>dui_block_header_description</code> */
  CssClass dui_block_header_description = () -> "dui-block-header-description";
  /** Constant <code>dui_block_header_reversed</code> */
  CssClass dui_block_header_reversed = () -> "dui-block-header-reversed";
}