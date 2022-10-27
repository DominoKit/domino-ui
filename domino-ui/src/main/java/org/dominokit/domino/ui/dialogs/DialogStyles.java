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
package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.style.CompositeCssClass;
import org.dominokit.domino.ui.style.CssClass;

/** Constants for dialogs css classes names */
public interface DialogStyles {
  String MESSAGE_DIALOG = "message-dialog";
  String DIALOG_BUTTON = "dialog-button";
  String MESSAGE_ICON = "message-icon";

  CssClass dui_modal = ()->"dui-dialog";
  CssClass dui_modal_box = ()->"dui-dialog-box";
  CompositeCssClass dui_dialog_left_sheet = CompositeCssClass.of(()->"dui-side-sheet", ()->"dui-left-sheet");
  CompositeCssClass dui_dialog_right_sheet = CompositeCssClass.of(()->"dui-side-sheet", ()->"dui-right-sheet");
  CompositeCssClass dui_dialog_top_sheet = CompositeCssClass.of(()->"dui-horizontal-sheet", ()->"dui-top-sheet");
  CompositeCssClass dui_dialog_bottom_sheet = CompositeCssClass.of(()->"dui-horizontal-sheet", ()->"dui-bottom-sheet");
  CssClass dui_no_transition = ()-> "dui-no-transition";

  CssClass dui_dialog_header = ()-> "dui-dialog-header";
  CssClass dui_dialog_content_header = ()-> "dui-dialog-content-header";
  CssClass dui_dialog_icon = ()-> "dui-dialog-icon";
  CssClass dui_dialog_title = ()-> "dui-dialog-title";
  CssClass dui_dialog_utility = ()-> "dui-dialog-utility";
  CssClass dui_dialog_content = ()-> "dui-dialog-content";
  CssClass dui_dialog_body = ()-> "dui-dialog-body";
  CssClass dui_dialog_footer = ()-> "dui-dialog-footer";

  CssClass dui_window = () -> "dui-window";
  CssClass dui_maximized = ()-> "dui-maximized";
}
