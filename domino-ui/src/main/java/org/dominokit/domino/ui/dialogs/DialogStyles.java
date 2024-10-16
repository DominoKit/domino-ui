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
import org.dominokit.domino.ui.style.ReplaceCssClass;

/** Constants for dialogs css classes names */
public interface DialogStyles {

  /** Constant <code>dui_modal</code> */
  CssClass dui_dialog = () -> "dui-dialog";
  /** Constant <code>dui_modal_box</code> */
  CssClass dui_modal_box = () -> "dui-dialog-box";

  /** Constant <code>dui_no_transition</code> */
  CssClass dui_no_transition = () -> "dui-no-transition";

  /** Constant <code>dui_dialog_header</code> */
  CssClass dui_dialog_header = () -> "dui-dialog-header";
  /** Constant <code>dui_dialog_content_header</code> */
  CssClass dui_dialog_content_header = () -> "dui-dialog-content-header";
  /** Constant <code>dui_dialog_icon</code> */
  CssClass dui_dialog_icon = () -> "dui-dialog-icon";
  /** Constant <code>dui_dialog_title</code> */
  CssClass dui_dialog_title = () -> "dui-dialog-title";
  /** Constant <code>dui_dialog_utility</code> */
  CssClass dui_dialog_utility = () -> "dui-dialog-utility";
  /** Constant <code>dui_dialog_content</code> */
  CssClass dui_dialog_content = () -> "dui-dialog-content";
  /** Constant <code>dui_dialog_body</code> */
  CssClass dui_dialog_body = () -> "dui-dialog-body";
  /** Constant <code>dui_dialog_footer</code> */
  CssClass dui_dialog_footer = () -> "dui-dialog-footer";
  /** Constant <code>dui_dialog_nav</code> */
  CssClass dui_dialog_nav = () -> "dui-dialog-nav";

  /** Constant <code>dui_window</code> */
  CssClass dui_window = () -> "dui-window";
  /** Constant <code>dui_maximized</code> */
  CssClass dui_maximized = () -> "dui-maximized";

  CssClass dui_left_sheet =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-right-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-top-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-bottom-sheet")))
          .replaceWith(CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-left-sheet"));

  CssClass dui_right_sheet =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-left-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-top-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-bottom-sheet")))
          .replaceWith(CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-right-sheet"));
  CssClass dui_top_sheet =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-left-sheet"),
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-right-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-bottom-sheet")))
          .replaceWith(CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-top-sheet"));
  CssClass dui_bottom_sheet =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-left-sheet"),
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-right-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-top-sheet")))
          .replaceWith(
              CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-bottom-sheet"));
  CssClass dui_no_sheet =
      new ReplaceCssClass(
              CompositeCssClass.of(
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-left-sheet"),
                  CompositeCssClass.of(() -> "dui-side-sheet", () -> "dui-right-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-bottom-sheet"),
                  CompositeCssClass.of(() -> "dui-horizontal-sheet", () -> "dui-top-sheet")))
          .replaceWith(CssClass.NONE);
}
