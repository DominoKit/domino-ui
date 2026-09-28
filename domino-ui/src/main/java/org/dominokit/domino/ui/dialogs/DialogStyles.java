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
import org.dominokit.domino.ui.style.LimitOneOfCssClass;
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

  /** Scoped size styling for the header navigation bar of standard dialogs. */
  CssClass dui_standard_dialog_nav = () -> "dui-standard-dialog-nav";

  /** Applies the shared minimum width for a standard dialog action. */
  CssClass dui_dialog_action = () -> "dui-dialog-action";

  /** Styles a standard dialog's secondary action as a link-style button. */
  CssClass dui_dialog_secondary_action = () -> "dui-dialog-secondary-action";

  /** Constant <code>dui_window</code> */
  CssClass dui_window = () -> "dui-window";

  /** Constant <code>dui_maximized</code> */
  CssClass dui_maximized = () -> "dui-maximized";

  CssClass dui_side_sheet =
      LimitOneOfCssClass.of(() -> "dui-side-sheet", () -> "dui-horizontal-sheet")
          .use(() -> "dui-side-sheet");
  CssClass dui_horizontal_sheet =
      LimitOneOfCssClass.of(() -> "dui-side-sheet", () -> "dui-horizontal-sheet")
          .use(() -> "dui-horizontal-sheet");

  CssClass dui_right_sheet =
      CompositeCssClass.of(
          dui_side_sheet,
          LimitOneOfCssClass.of(
                  () -> "dui-right-sheet",
                  () -> "dui-top-sheet",
                  () -> "dui-bottom-sheet",
                  () -> "dui-left-sheet")
              .use(() -> "dui-right-sheet"));

  CssClass dui_left_sheet =
      CompositeCssClass.of(
          dui_side_sheet,
          LimitOneOfCssClass.of(
                  () -> "dui-right-sheet",
                  () -> "dui-top-sheet",
                  () -> "dui-bottom-sheet",
                  () -> "dui-left-sheet")
              .use(() -> "dui-left-sheet"));

  CssClass dui_top_sheet =
      CompositeCssClass.of(
          dui_horizontal_sheet,
          LimitOneOfCssClass.of(
                  () -> "dui-right-sheet",
                  () -> "dui-top-sheet",
                  () -> "dui-bottom-sheet",
                  () -> "dui-left-sheet")
              .use(() -> "dui-top-sheet"));

  CssClass dui_bottom_sheet =
      CompositeCssClass.of(
          dui_horizontal_sheet,
          LimitOneOfCssClass.of(
                  () -> "dui-right-sheet",
                  () -> "dui-top-sheet",
                  () -> "dui-bottom-sheet",
                  () -> "dui-left-sheet")
              .use(() -> "dui-bottom-sheet"));

  CssClass dui_no_sheet =
      ReplaceCssClass.of(
              CompositeCssClass.of(
                  dui_side_sheet,
                  dui_horizontal_sheet,
                  dui_right_sheet,
                  dui_left_sheet,
                  dui_bottom_sheet,
                  dui_top_sheet))
          .replaceWith(CssClass.NONE);
}
