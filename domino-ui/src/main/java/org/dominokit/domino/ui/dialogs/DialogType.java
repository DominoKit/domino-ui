package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.style.CssClass;

/** An enum to list modal types */
public enum DialogType implements DialogStyles{
  /** A modal that show up from the bottom of screen and spread to match the screen width */
  BOTTOM_SHEET(dui_dialog_bottom_sheet),
  /** A modal that show up from the top of screen and spread to match the screen width */
  TOP_SHEET(dui_dialog_top_sheet),
  /** A modal that show up from the left of screen and spread to match the screen height */
  LEFT_SHEET(dui_dialog_left_sheet),
  /** A modal that show up from the right of screen and spread to match the screen height */
  RIGHT_SHEET(dui_dialog_right_sheet),
  /** Set the modal type to default and show in the middle of the screen */
  DEFAULT(CssClass.NONE);

  CssClass style;

  /** @param style String css style name */
  DialogType(CssClass style) {
    this.style = style;
  }
}