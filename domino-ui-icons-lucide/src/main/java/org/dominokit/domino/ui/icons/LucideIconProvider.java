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

/** Default semantic icon provider backed by Lucide. */
public final class LucideIconProvider implements IconProvider {
  public static final LucideIconProvider INSTANCE = new LucideIconProvider();

  private LucideIconProvider() {}

  @Override
  public LucideIcon icon(IconName role) {
    switch (role) {
      case ARROW_COLLAPSE_VERTICAL:
        return LucideIcon.create(LucideArrows.Icon.MINIMIZE_2);
      case ARROW_EXPAND_VERTICAL:
        return LucideIcon.create(LucideArrows.Icon.MAXIMIZE_2);
      case ARROW_UPWARD:
        return LucideIcon.create(LucideArrows.Icon.ARROW_UP);
      case BLOCK:
        return LucideIcon.create(LucideAccount.Icon.BAN);
      case BLUR:
        return LucideIcon.create(LucideAccessibility.Icon.SCAN_EYE);
      case BLUR_OFF:
        return LucideIcon.create(LucideAccessibility.Icon.EYE_OFF);
      case BORDER_NONE:
        return LucideIcon.create(LucideMultimedia.Icon.SQUARE);
      case BORDER_VERTICAL:
        return LucideIcon.create(LucideDesign.Icon.COLUMNS_2);
      case CANCEL:
        return LucideIcon.create(LucideDevelopment.Icon.CIRCLE_X);
      case CHECK:
        return LucideIcon.create(LucideNotifications.Icon.CHECK);
      case CHECK_CIRCLE:
        return LucideIcon.create(LucideNotifications.Icon.CIRCLE_CHECK);
      case CALENDAR:
        return LucideIcon.create(LucideTime.Icon.CALENDAR);
      case CHEVRON_DOWN:
        return LucideIcon.create(LucideArrows.Icon.CHEVRON_DOWN);
      case CHEVRON_LEFT:
        return LucideIcon.create(LucideArrows.Icon.CHEVRON_LEFT);
      case CHEVRON_RIGHT:
        return LucideIcon.create(LucideArrows.Icon.CHEVRON_RIGHT);
      case CHEVRON_UP:
        return LucideIcon.create(LucideArrows.Icon.CHEVRON_UP);
      case CIRCLE_MEDIUM:
        return LucideIcon.create(LucideShapes.Icon.CIRCLE);
      case CLOSE:
        return LucideIcon.create(LucideMath.Icon.X);
      case CLOCK_OUTLINE:
        return LucideIcon.create(LucideTime.Icon.CLOCK);
      case CODE_TAGS:
        return LucideIcon.create(LucideDevelopment.Icon.CODE_XML);
      case CONTENT_COPY:
        return LucideIcon.create(LucideText.Icon.COPY);
      case CONTENT_CUT:
        return LucideIcon.create(LucideDesign.Icon.SCISSORS);
      case CONTENT_PASTE:
        return LucideIcon.create(LucideArrows.Icon.CLIPBOARD_PASTE);
      case DELETE:
        return LucideIcon.create(LucideFiles.Icon.TRASH);
      case DRAG_VERTICAL:
        return LucideIcon.create(LucideLayout.Icon.GRIP_VERTICAL);
      case DOCK_LEFT:
        return LucideIcon.create(LucideLayout.Icon.PANEL_LEFT);
      case DOCK_RIGHT:
        return LucideIcon.create(LucideLayout.Icon.PANEL_RIGHT);
      case DOTS_HORIZONTAL:
        return LucideIcon.create(LucideDevelopment.Icon.ELLIPSIS);
      case DOTS_VERTICAL:
        return LucideIcon.create(LucideLayout.Icon.ELLIPSIS_VERTICAL);
      case EXCLAMATION:
        return LucideIcon.create(LucideNotifications.Icon.CIRCLE_ALERT);
      case FILE_UPLOAD:
        return LucideIcon.create(LucideArrows.Icon.UPLOAD);
      case FILTER_OFF:
        return LucideIcon.create(LucideText.Icon.LIST_FILTER);
      case FORMAT_ALIGN_CENTER:
        return LucideIcon.create(LucideText.Icon.TEXT_ALIGN_CENTER);
      case FORMAT_ALIGN_JUSTIFY:
        return LucideIcon.create(LucideText.Icon.TEXT_ALIGN_JUSTIFY);
      case FORMAT_ALIGN_LEFT:
        return LucideIcon.create(LucideText.Icon.TEXT_ALIGN_START);
      case FORMAT_ALIGN_RIGHT:
        return LucideIcon.create(LucideText.Icon.TEXT_ALIGN_END);
      case FORMAT_BOLD:
        return LucideIcon.create(LucideText.Icon.BOLD);
      case FORMAT_COLOR_HIGHLIGHT:
        return LucideIcon.create(LucideDesign.Icon.HIGHLIGHTER);
      case FORMAT_COLOR_MARKER_CANCEL:
        return LucideIcon.create(LucideText.Icon.ERASER);
      case FORMAT_COLOR_TEXT:
        return LucideIcon.create(LucideText.Icon.CASE_SENSITIVE);
      case FORMAT_FONT_SIZE_DECREASE:
        return LucideIcon.create(LucideDesign.Icon.A_ARROW_DOWN);
      case FORMAT_FONT_SIZE_INCREASE:
        return LucideIcon.create(LucideDesign.Icon.A_ARROW_UP);
      case FORMAT_HEADER_1:
        return LucideIcon.create(LucideText.Icon.HEADING_1);
      case FORMAT_HEADER_2:
        return LucideIcon.create(LucideText.Icon.HEADING_2);
      case FORMAT_HEADER_3:
        return LucideIcon.create(LucideText.Icon.HEADING_3);
      case FORMAT_HEADER_4:
        return LucideIcon.create(LucideText.Icon.HEADING_4);
      case FORMAT_HEADER_5:
        return LucideIcon.create(LucideText.Icon.HEADING_5);
      case FORMAT_HEADER_6:
        return LucideIcon.create(LucideText.Icon.HEADING_6);
      case FORMAT_INDENT_DECREASE:
        return LucideIcon.create(LucideDevelopment.Icon.LIST_INDENT_DECREASE);
      case FORMAT_INDENT_INCREASE:
        return LucideIcon.create(LucideDevelopment.Icon.LIST_INDENT_INCREASE);
      case FORMAT_ITALIC:
        return LucideIcon.create(LucideText.Icon.ITALIC);
      case FORMAT_LIST_BULLETED:
        return LucideIcon.create(LucideText.Icon.LIST);
      case FORMAT_LIST_NUMBERED:
        return LucideIcon.create(LucideText.Icon.LIST_ORDERED);
      case FORMAT_PARAGRAPH:
        return LucideIcon.create(LucideText.Icon.PILCROW);
      case FORMAT_STRIKETHROUGH:
        return LucideIcon.create(LucideText.Icon.STRIKETHROUGH);
      case FORMAT_SUBSCRIPT:
        return LucideIcon.create(LucideText.Icon.SUBSCRIPT);
      case FORMAT_SUPERSCRIPT:
        return LucideIcon.create(LucideText.Icon.SUPERSCRIPT);
      case FORMAT_UNDERLINE:
        return LucideIcon.create(LucideText.Icon.UNDERLINE);
      case FULLSCREEN:
        return LucideIcon.create(LucideDesign.Icon.MAXIMIZE);
      case FULLSCREEN_EXIT:
        return LucideIcon.create(LucideDesign.Icon.MINIMIZE);
      case IMAGE:
        return LucideIcon.create(LucideFiles.Icon.IMAGE);
      case KEYBOARD_BACKSPACE:
        return LucideIcon.create(LucideArrows.Icon.DELETE);
      case LINK:
        return LucideIcon.create(LucideAccount.Icon.LINK);
      case LINK_OFF:
        return LucideIcon.create(LucideText.Icon.UNLINK);
      case MAGNIFY:
        return LucideIcon.create(LucideSocial.Icon.SEARCH);
      case MENU:
        return LucideIcon.create(LucideAccount.Icon.MENU);
      case MENU_DOWN:
        return LucideIcon.create(LucideArrows.Icon.CHEVRON_DOWN);
      case MENU_LEFT:
        return LucideIcon.create(LucideArrows.Icon.ARROW_LEFT);
      case MENU_OPEN:
        return LucideIcon.create(LucideArrows.Icon.PANEL_LEFT_OPEN);
      case MENU_RIGHT:
        return LucideIcon.create(LucideArrows.Icon.ARROW_RIGHT);
      case MINUS:
        return LucideIcon.create(LucideDevelopment.Icon.MINUS);
      case MINUS_BOX:
        return LucideIcon.create(LucideDevelopment.Icon.SQUARE_MINUS);
      case PAGE_FIRST:
        return LucideIcon.create(LucideArrows.Icon.SKIP_BACK);
      case PAGE_LAST:
        return LucideIcon.create(LucideArrows.Icon.SKIP_FORWARD);
      case PIN:
        return LucideIcon.create(LucideAccount.Icon.PIN);
      case PIN_OFF:
        return LucideIcon.create(LucideNavigation.Icon.PIN_OFF);
      case PLUS_BOX:
        return LucideIcon.create(LucideDevelopment.Icon.SQUARE_PLUS);
      case REDO:
        return LucideIcon.create(LucideArrows.Icon.REDO_2);
      case SHARE:
        return LucideIcon.create(LucideAccount.Icon.SHARE);
      case SKIP_NEXT:
        return LucideIcon.create(LucideArrows.Icon.SKIP_FORWARD);
      case SKIP_PREVIOUS:
        return LucideIcon.create(LucideArrows.Icon.SKIP_BACK);
      case STAR:
        return LucideIcon.create(LucideAccount.Icon.STAR);
      case STAR_BORDER:
        return LucideIcon.create(LucideAccount.Icon.STAR);
      case TRASH_CAN:
        return LucideIcon.create(LucideFiles.Icon.TRASH);
      case UNDO:
        return LucideIcon.create(LucideArrows.Icon.UNDO_2);
      case UPLOAD:
        return LucideIcon.create(LucideArrows.Icon.UPLOAD);
      case SORT:
        return LucideIcon.create(LucideText.Icon.LIST_FILTER);
      case SORT_ASCENDING:
        return LucideIcon.create(LucideText.Icon.LIST_ORDERED);
      case SORT_DESCENDING:
        return LucideIcon.create(LucideText.Icon.LIST_ORDERED);
      case VECTOR_POINT_PLUS:
        return LucideIcon.create(LucidePhotography.Icon.CROSSHAIR);
      case VIEW_COLUMN:
        return LucideIcon.create(LucideDesign.Icon.COLUMNS_3);
      case VIEW_DAY:
        return LucideIcon.create(LucideTime.Icon.CALENDAR_DAYS);
      case VIEW_DAY_OUTLINE:
        return LucideIcon.create(LucideTime.Icon.CALENDAR_DAYS);
      case WARNING:
        return LucideIcon.create(LucideDevelopment.Icon.TRIANGLE_ALERT);
      case WINDOW_CLOSE:
        return LucideIcon.create(LucideMath.Icon.X);
      case WINDOW_MAXIMIZE:
        return LucideIcon.create(LucideMultimedia.Icon.SQUARE);
      case WINDOW_RESTORE:
        return LucideIcon.create(LucideText.Icon.COPY);
      default:
        throw new IllegalArgumentException("No Lucide icon for role: " + role);
    }
  }
}
