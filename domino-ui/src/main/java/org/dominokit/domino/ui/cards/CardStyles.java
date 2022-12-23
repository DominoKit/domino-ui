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

  CssClass card = () -> "dui-card";
  CssClass card_reversed = () -> "dui-card-reversed";
  CssClass card_main_title = () -> "dui-card-main-title";
  CssClass card_title = () -> "dui-card-title";
  CssClass card_description = () -> "dui-card-description";
  CssClass card_header = () -> "dui-card-header";
  CssClass card_main_header = () -> "dui-card-main-header";
  CssClass card_sub_header = () -> "dui-card-subheader";
  CssClass card_logo = () -> "dui-card-logo";
  CssClass card_icon = () -> "dui-card-icon";
  CssClass card_utility = () -> "dui-card-utility";
  CssClass card_body = () -> "dui-card-body";
  CssClass dui_card_header_filler = () -> "dui-card-header-filler";

  /** CSS class for card */
  String CARD = "card";
  /** CSS class for card header */
  String HEADER = "header";
  /** CSS class for card header actions */
  String HEADER_ACTIONS = "header-actions";
  /** CSS class for card body */
  String BODY = "body";
  /** CSS class for card header action icon */
  String ACTION_ICON = "action-icon";
  /** CSS class for card to fit its content */
  String FIT_CONTENT = "fit-content";
}
