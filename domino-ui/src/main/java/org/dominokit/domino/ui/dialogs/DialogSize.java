package org.dominokit.domino.ui.dialogs;

import org.dominokit.domino.ui.style.CssClass;

import static org.dominokit.domino.ui.style.GenericCss.*;

/** An enum to list modal possible zises */
  public enum DialogSize {
    /** Very small modal with smaller width */
    VERY_SMALL(dui_w_xsmall, dui_h_xsmall),
    /** Small modal with small width */
    SMALL(dui_w_small, dui_h_small),
    /** Medium modal with moderate width */
    MEDIUM(dui_w_medium, dui_h_medium),
    /** Large modal with wide width */
    LARGE(dui_w_large, dui_h_large),
    /** Very large modal with wider width */
    VERY_LARGE(dui_w_xlarge, dui_h_xlarge);

    CssClass widthStyle;
    CssClass heightStyle;

  /** @param widthStyle String css style name */
    DialogSize(CssClass widthStyle, CssClass heightStyle) {
      this.widthStyle = widthStyle;
      this.heightStyle = heightStyle;
    }
  }