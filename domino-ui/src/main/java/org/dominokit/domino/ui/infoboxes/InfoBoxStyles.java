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

/**
 * Default CSS classes for {@link InfoBox}
 */
public interface InfoBoxStyles {

    CssClass dui_info_box = () -> "dui-info-box";
    CssClass dui_info_flipped = () -> "dui-info-flipped";
    CssClass dui_info_icon = () -> "dui-info-icon";
    CssClass dui_info_content = () -> "dui-info-content";
    CssClass dui_info_title = () -> "dui-info-title";
    CssClass dui_info_value = () -> "dui-info-value";
    CssClass dui_info_hover_zoom = () -> "dui-info-hover-zoom";
    CssClass dui_info_hover_expand = () -> "dui-info-hover-expand";
}
