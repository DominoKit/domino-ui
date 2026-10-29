/*
 * Copyright © 2026 Dominokit
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

final class MaterialSymbolNames {
  private MaterialSymbolNames() {}

  static String ligature(IconName name) {
    switch (name) {
      case ARROW_COLLAPSE_VERTICAL:
        return "unfold_less";
      case ARROW_EXPAND_VERTICAL:
        return "unfold_more";
      case ARROW_UPWARD:
        return "arrow_upward";
      case BLOCK:
        return "block";
      case BLUR:
        return "blur_on";
      case BLUR_OFF:
        return "blur_off";
      case BORDER_NONE:
        return "border_clear";
      case BORDER_VERTICAL:
        return "border_vertical";
      case CANCEL:
        return "cancel";
      case CHECK:
        return "check";
      case CHECK_CIRCLE:
        return "check_circle";
      case CALENDAR:
        return "calendar_month";
      case CHEVRON_DOWN:
        return "keyboard_arrow_down";
      case CHEVRON_LEFT:
        return "chevron_left";
      case CHEVRON_RIGHT:
        return "chevron_right";
      case CHEVRON_UP:
        return "keyboard_arrow_up";
      case CIRCLE_MEDIUM:
        return "circle";
      case CLOSE:
        return "close";
      case CLOCK_OUTLINE:
        return "schedule";
      case CODE_TAGS:
        return "code";
      case CONTENT_COPY:
        return "content_copy";
      case CONTENT_CUT:
        return "content_cut";
      case CONTENT_PASTE:
        return "content_paste";
      case DELETE:
        return "delete";
      case DOCK_LEFT:
        return "dock_to_left";
      case DOCK_RIGHT:
        return "dock_to_right";
      case DOTS_HORIZONTAL:
        return "more_horiz";
      case DOTS_VERTICAL:
        return "more_vert";
      case EXCLAMATION:
        return "priority_high";
      case FILE_UPLOAD:
        return "file_upload";
      case FILTER_OFF:
        return "filter_alt_off";
      case FORMAT_ALIGN_CENTER:
        return "format_align_center";
      case FORMAT_ALIGN_JUSTIFY:
        return "format_align_justify";
      case FORMAT_ALIGN_LEFT:
        return "format_align_left";
      case FORMAT_ALIGN_RIGHT:
        return "format_align_right";
      case FORMAT_BOLD:
        return "format_bold";
      case FORMAT_COLOR_HIGHLIGHT:
        return "format_ink_highlighter";
      case FORMAT_COLOR_MARKER_CANCEL:
        return "format_color_reset";
      case FORMAT_COLOR_TEXT:
        return "format_color_text";
      case FORMAT_FONT_SIZE_DECREASE:
        return "format_size";
      case FORMAT_FONT_SIZE_INCREASE:
        return "format_size";
      case FORMAT_HEADER_1:
        return "format_h1";
      case FORMAT_HEADER_2:
        return "format_h2";
      case FORMAT_HEADER_3:
        return "format_h3";
      case FORMAT_HEADER_4:
        return "format_h4";
      case FORMAT_HEADER_5:
        return "format_h5";
      case FORMAT_HEADER_6:
        return "format_h6";
      case FORMAT_INDENT_DECREASE:
        return "format_indent_decrease";
      case FORMAT_INDENT_INCREASE:
        return "format_indent_increase";
      case FORMAT_ITALIC:
        return "format_italic";
      case FORMAT_LIST_BULLETED:
        return "format_list_bulleted";
      case FORMAT_LIST_NUMBERED:
        return "format_list_numbered";
      case FORMAT_PARAGRAPH:
        return "format_paragraph";
      case FORMAT_STRIKETHROUGH:
        return "format_strikethrough";
      case FORMAT_SUBSCRIPT:
        return "subscript";
      case FORMAT_SUPERSCRIPT:
        return "superscript";
      case FORMAT_UNDERLINE:
        return "format_underlined";
      case FULLSCREEN:
        return "fullscreen";
      case FULLSCREEN_EXIT:
        return "fullscreen_exit";
      case IMAGE:
        return "image";
      case KEYBOARD_BACKSPACE:
        return "keyboard_backspace";
      case LINK:
        return "link";
      case LINK_OFF:
        return "link_off";
      case MAGNIFY:
        return "search";
      case MENU:
        return "menu";
      case MENU_DOWN:
        return "keyboard_arrow_down";
      case MENU_LEFT:
        return "keyboard_arrow_left";
      case MENU_OPEN:
        return "menu_open";
      case MENU_RIGHT:
        return "keyboard_arrow_right";
      case MINUS:
        return "remove";
      case MINUS_BOX:
        return "indeterminate_check_box";
      case PAGE_FIRST:
        return "first_page";
      case PAGE_LAST:
        return "last_page";
      case PIN:
        return "push_pin";
      case PIN_OFF:
        return "keep_off";
      case PLUS_BOX:
        return "add_box";
      case REDO:
        return "redo";
      case SHARE:
        return "share";
      case SKIP_NEXT:
        return "skip_next";
      case SKIP_PREVIOUS:
        return "skip_previous";
      case STAR:
        return "star";
      case STAR_BORDER:
        return "star_border";
      case TRASH_CAN:
        return "delete";
      case UNDO:
        return "undo";
      case UPLOAD:
        return "upload";
      case VIEW_COLUMN:
        return "view_column";
      case VIEW_DAY:
        return "view_day";
      case VIEW_DAY_OUTLINE:
        return "view_day";
      case WARNING:
        return "warning";
      case WINDOW_CLOSE:
        return "close";
      case WINDOW_MAXIMIZE:
        return "open_in_full";
      case WINDOW_RESTORE:
        return "close_fullscreen";
      case DRAG_VERTICAL:
        return "drag_indicator";
      case SORT:
        return "sort";
      case SORT_ASCENDING:
        return "sort_by_alpha";
      case SORT_DESCENDING:
        return "sort";
      case VECTOR_POINT_PLUS:
        return "add_location_alt";
      default:
        return name.value();
    }
  }
}
