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
package org.dominokit.domino.ui.icons;

/** Semantic icon roles used by Domino UI components for their built-in defaults. */
public enum IconName {
  ARROW_COLLAPSE_VERTICAL("arrow_collapse_vertical"),
  ARROW_EXPAND_VERTICAL("arrow_expand_vertical"),
  ARROW_UPWARD("arrow_upward"),
  BLOCK("block"),
  BLUR("blur"),
  BLUR_OFF("blur_off"),
  BORDER_NONE("border_none"),
  BORDER_VERTICAL("border_vertical"),
  CANCEL("cancel"),
  CHECK("check"),
  CHECK_CIRCLE("check_circle"),
  CALENDAR("calendar"),
  CHEVRON_DOWN("chevron_down"),
  CHEVRON_LEFT("chevron_left"),
  CHEVRON_RIGHT("chevron_right"),
  CHEVRON_UP("chevron_up"),
  CIRCLE_MEDIUM("circle_medium"),
  CLOSE("close"),
  CLOCK_OUTLINE("clock_outline"),
  CODE_TAGS("code_tags"),
  CONTENT_COPY("content_copy"),
  CONTENT_CUT("content_cut"),
  CONTENT_PASTE("content_paste"),
  DELETE("delete"),
  DRAG_VERTICAL("drag_vertical"),
  DOCK_LEFT("dock_left"),
  DOCK_RIGHT("dock_right"),
  DOTS_HORIZONTAL("dots_horizontal"),
  DOTS_VERTICAL("dots_vertical"),
  EXCLAMATION("exclamation"),
  FILE_UPLOAD("file_upload"),
  FILTER_OFF("filter_off"),
  FORMAT_ALIGN_CENTER("format_align_center"),
  FORMAT_ALIGN_JUSTIFY("format_align_justify"),
  FORMAT_ALIGN_LEFT("format_align_left"),
  FORMAT_ALIGN_RIGHT("format_align_right"),
  FORMAT_BOLD("format_bold"),
  FORMAT_COLOR_HIGHLIGHT("format_color_highlight"),
  FORMAT_COLOR_MARKER_CANCEL("format_color_marker_cancel"),
  FORMAT_COLOR_TEXT("format_color_text"),
  FORMAT_FONT_SIZE_DECREASE("format_font_size_decrease"),
  FORMAT_FONT_SIZE_INCREASE("format_font_size_increase"),
  FORMAT_HEADER_1("format_header_1"),
  FORMAT_HEADER_2("format_header_2"),
  FORMAT_HEADER_3("format_header_3"),
  FORMAT_HEADER_4("format_header_4"),
  FORMAT_HEADER_5("format_header_5"),
  FORMAT_HEADER_6("format_header_6"),
  FORMAT_INDENT_DECREASE("format_indent_decrease"),
  FORMAT_INDENT_INCREASE("format_indent_increase"),
  FORMAT_ITALIC("format_italic"),
  FORMAT_LIST_BULLETED("format_list_bulleted"),
  FORMAT_LIST_NUMBERED("format_list_numbered"),
  FORMAT_PARAGRAPH("format_paragraph"),
  FORMAT_STRIKETHROUGH("format_strikethrough"),
  FORMAT_SUBSCRIPT("format_subscript"),
  FORMAT_SUPERSCRIPT("format_superscript"),
  FORMAT_UNDERLINE("format_underline"),
  FULLSCREEN("fullscreen"),
  FULLSCREEN_EXIT("fullscreen_exit"),
  IMAGE("image"),
  KEYBOARD_BACKSPACE("keyboard_backspace"),
  LINK("link"),
  LINK_OFF("link_off"),
  MAGNIFY("magnify"),
  MENU("menu"),
  MENU_DOWN("menu_down"),
  MENU_LEFT("menu_left"),
  MENU_OPEN("menu_open"),
  MENU_RIGHT("menu_right"),
  MINUS("minus"),
  MINUS_BOX("minus_box"),
  PAGE_FIRST("page_first"),
  PAGE_LAST("page_last"),
  PIN("pin"),
  PIN_OFF("pin_off"),
  PLUS_BOX("plus_box"),
  REDO("redo"),
  SHARE("share"),
  SKIP_NEXT("skip_next"),
  SKIP_PREVIOUS("skip_previous"),
  STAR("star"),
  STAR_BORDER("star_border"),
  TRASH_CAN("trash_can"),
  UNDO("undo"),
  UPLOAD("upload"),
  SORT("sort"),
  SORT_ASCENDING("sort_ascending"),
  SORT_DESCENDING("sort_descending"),
  VECTOR_POINT_PLUS("vector_point_plus"),
  VIEW_COLUMN("view_column"),
  VIEW_DAY("view_day"),
  VIEW_DAY_OUTLINE("view_day_outline"),
  WARNING("warning"),
  WINDOW_CLOSE("window_close"),
  WINDOW_MAXIMIZE("window_maximize"),
  WINDOW_RESTORE("window_restore");

  private final String value;

  IconName(String value) {
    this.value = value;
  }

  /** Returns the stable semantic identifier used when mapping this role to a pack catalog. */
  public String value() {
    return value;
  }
}
