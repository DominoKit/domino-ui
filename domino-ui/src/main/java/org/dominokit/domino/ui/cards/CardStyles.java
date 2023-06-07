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
package org.dominokit.domino.ui.cards;

import org.dominokit.domino.ui.style.CssClass;

/** Default CSS classes for {@link Card} */
public interface CardStyles {

  CssClass dui_card = () -> "dui-card";
  CssClass dui_card_header_bottom = () -> "dui-card-header-bottom";
  CssClass dui_card_main_title = () -> "dui-card-main-title";
  CssClass dui_card_title = () -> "dui-card-title";
  CssClass dui_card_description = () -> "dui-card-description";
  CssClass dui_card_header = () -> "dui-card-header";
  CssClass dui_card_main_header = () -> "dui-card-main-header";
  CssClass dui_card_sub_header = () -> "dui-card-subheader";
  CssClass dui_card_logo = () -> "dui-card-logo";
  CssClass dui_card_icon = () -> "dui-card-icon";
  CssClass dui_card_body = () -> "dui-card-body";
  CssClass dui_card_header_filler = () -> "dui-card-header-filler";

}
