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
package org.dominokit.domino.ui.infoboxes;

import org.dominokit.domino.ui.style.CssClass;

/** The interface containing CSS classes for styling InfoBoxes. */
public interface InfoBoxStyles {

  /** Represents the CSS class for the root InfoBox element. */
  CssClass dui_info_box = () -> "dui-info-box";

  /** Represents the CSS class for the flipped InfoBox. */
  CssClass dui_info_flipped = () -> "dui-info-flipped";

  /** Represents the CSS class for the icon container in the InfoBox. */
  CssClass dui_info_icon = () -> "dui-info-icon";

  /** Represents the CSS class for the content container in the InfoBox. */
  CssClass dui_info_content = () -> "dui-info-content";

  /** Represents the CSS class for the title container in the InfoBox. */
  CssClass dui_info_title = () -> "dui-info-title";

  /** Represents the CSS class for the value container in the InfoBox. */
  CssClass dui_info_value = () -> "dui-info-value";

  /** Represents the CSS class for the zoom hover effect in the InfoBox. */
  CssClass dui_info_hover_zoom = () -> "dui-info-hover-zoom";

  /** Represents the CSS class for the expand hover effect in the InfoBox. */
  CssClass dui_info_hover_expand = () -> "dui-info-hover-expand";
}
