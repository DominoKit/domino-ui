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
public class CardStyles {

    public static final CssClass card = () -> "dui-card";
    public static final CssClass card_reversed = () -> "dui-card-reversed";
    public static final CssClass card_main_title = () -> "dui-card-main-title";
    public static final CssClass card_title = () -> "dui-card-title";
    public static final CssClass card_description = () -> "dui-card-description";
    public static final CssClass card_header = () -> "dui-card-header";
    public static final CssClass card_main_header = () -> "dui-card-main-header";
    public static final CssClass card_sub_header = () -> "dui-card-subheader";
    public static final CssClass card_logo = () -> "dui-card-logo";
    public static final CssClass card_icon = () -> "dui-card-icon";
    public static final CssClass card_utility = () -> "dui-card-utility";
    public static final CssClass card_body = () -> "dui-card-body";


    /** CSS class for card */
  public static final String CARD = "card";
  /** CSS class for card header */
  public static final String HEADER = "header";
  /** CSS class for card header actions */
  public static final String HEADER_ACTIONS = "header-actions";
  /** CSS class for card body */
  public static final String BODY = "body";
  /** CSS class for card header action icon */
  public static final String ACTION_ICON = "action-icon";
  /** CSS class for card to fit its content */
  public static final String FIT_CONTENT = "fit-content";
}
