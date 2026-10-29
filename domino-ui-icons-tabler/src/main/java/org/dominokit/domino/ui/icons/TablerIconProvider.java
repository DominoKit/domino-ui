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

/** Default semantic icon provider backed by Tabler. */
public final class TablerIconProvider implements IconProvider {
  public static final TablerIconProvider INSTANCE = new TablerIconProvider();

  private TablerIconProvider() {}

  @Override
  public TablerIcon icon(IconName role) {
    switch (role) {
      case ARROW_COLLAPSE_VERTICAL:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case ARROW_EXPAND_VERTICAL:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case ARROW_UPWARD:
        return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP);
      case BLOCK:
        return TablerIcon.create(TablerSystem.OutlineIcon.BAN);
      case BLUR:
        return TablerIcon.create(TablerDesign.OutlineIcon.BLUR);
      case BLUR_OFF:
        return TablerIcon.create(TablerDesign.OutlineIcon.BLUR_OFF);
      case BORDER_NONE:
        return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_NONE);
      case BORDER_VERTICAL:
        return TablerIcon.create(TablerDesign.OutlineIcon.BORDER_VERTICAL);
      case CANCEL:
        return TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_X);
      case CHECK:
        return TablerIcon.create(TablerSystem.OutlineIcon.CHECK);
      case CHECK_CIRCLE:
        return TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_CHECK);
      case CALENDAR:
        return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
      case CHEVRON_DOWN:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN);
      case CHEVRON_LEFT:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT);
      case CHEVRON_RIGHT:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT);
      case CHEVRON_UP:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP);
      case CIRCLE_MEDIUM:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case CLOSE:
        return TablerIcon.create(TablerSystem.OutlineIcon.X);
      case CLOCK_OUTLINE:
        return TablerIcon.create(TablerSystem.OutlineIcon.CLOCK);
      case CODE_TAGS:
        return TablerIcon.create(TablerText.OutlineIcon.CODE);
      case CONTENT_COPY:
        return TablerIcon.create(TablerText.OutlineIcon.COPY);
      case CONTENT_CUT:
        return TablerIcon.create(TablerDesign.OutlineIcon.CUT);
      case CONTENT_PASTE:
        return TablerIcon.create(TablerDocument.OutlineIcon.CLIPBOARD);
      case DELETE:
        return TablerIcon.create(TablerSystem.OutlineIcon.TRASH);
      case DRAG_VERTICAL:
        return TablerIcon.create(TablerSystem.OutlineIcon.GRIP_VERTICAL);
      case DOCK_LEFT:
        return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_COLLAPSE);
      case DOCK_RIGHT:
        return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_RIGHT_COLLAPSE);
      case DOTS_HORIZONTAL:
        return TablerIcon.create(TablerSystem.OutlineIcon.DOTS);
      case DOTS_VERTICAL:
        return TablerIcon.create(TablerSystem.OutlineIcon.DOTS_VERTICAL);
      case EXCLAMATION:
        return TablerIcon.create(TablerSystem.OutlineIcon.EXCLAMATION_MARK);
      case FILE_UPLOAD:
        return TablerIcon.create(TablerDocument.OutlineIcon.FILE_UPLOAD);
      case FILTER_OFF:
        return TablerIcon.create(TablerSystem.OutlineIcon.FILTER_OFF);
      case FORMAT_ALIGN_CENTER:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case FORMAT_ALIGN_JUSTIFY:
        return TablerIcon.create(TablerText.OutlineIcon.ALIGN_JUSTIFIED);
      case FORMAT_ALIGN_LEFT:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case FORMAT_ALIGN_RIGHT:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case FORMAT_BOLD:
        return TablerIcon.create(TablerText.OutlineIcon.BOLD);
      case FORMAT_COLOR_HIGHLIGHT:
        return TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT);
      case FORMAT_COLOR_MARKER_CANCEL:
        return TablerIcon.create(TablerText.OutlineIcon.BACKSPACE);
      case FORMAT_COLOR_TEXT:
        return TablerIcon.create(TablerDesign.OutlineIcon.COLOR_SWATCH);
      case FORMAT_FONT_SIZE_DECREASE:
        return TablerIcon.create(TablerMap.OutlineIcon.ZOOM_OUT);
      case FORMAT_FONT_SIZE_INCREASE:
        return TablerIcon.create(TablerMap.OutlineIcon.ZOOM_IN);
      case FORMAT_HEADER_1:
        return TablerIcon.create(TablerText.OutlineIcon.H_1);
      case FORMAT_HEADER_2:
        return TablerIcon.create(TablerText.OutlineIcon.H_2);
      case FORMAT_HEADER_3:
        return TablerIcon.create(TablerText.OutlineIcon.H_3);
      case FORMAT_HEADER_4:
        return TablerIcon.create(TablerText.OutlineIcon.H_4);
      case FORMAT_HEADER_5:
        return TablerIcon.create(TablerText.OutlineIcon.H_5);
      case FORMAT_HEADER_6:
        return TablerIcon.create(TablerText.OutlineIcon.H_6);
      case FORMAT_INDENT_DECREASE:
        return TablerIcon.create(TablerText.OutlineIcon.INDENT_DECREASE);
      case FORMAT_INDENT_INCREASE:
        return TablerIcon.create(TablerText.OutlineIcon.INDENT_INCREASE);
      case FORMAT_ITALIC:
        return TablerIcon.create(TablerText.OutlineIcon.ITALIC);
      case FORMAT_LIST_BULLETED:
        return TablerIcon.create(TablerText.OutlineIcon.LIST);
      case FORMAT_LIST_NUMBERED:
        return TablerIcon.create(TablerText.OutlineIcon.LIST_NUMBERS);
      case FORMAT_PARAGRAPH:
        return TablerIcon.create(TablerText.OutlineIcon.PILCROW);
      case FORMAT_STRIKETHROUGH:
        return TablerIcon.create(TablerText.OutlineIcon.STRIKETHROUGH);
      case FORMAT_SUBSCRIPT:
        return TablerIcon.create(TablerText.OutlineIcon.SUBSCRIPT);
      case FORMAT_SUPERSCRIPT:
        return TablerIcon.create(TablerText.OutlineIcon.SUPERSCRIPT);
      case FORMAT_UNDERLINE:
        return TablerIcon.create(TablerText.OutlineIcon.UNDERLINE);
      case FULLSCREEN:
        return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MAXIMIZE);
      case FULLSCREEN_EXIT:
        return TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MINIMIZE);
      case IMAGE:
        return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO);
      case KEYBOARD_BACKSPACE:
        return TablerIcon.create(TablerText.OutlineIcon.BACKSPACE);
      case LINK:
        return TablerIcon.create(TablerText.OutlineIcon.LINK);
      case LINK_OFF:
        return TablerIcon.create(TablerText.OutlineIcon.LINK_OFF);
      case MAGNIFY:
        return TablerIcon.create(TablerMap.OutlineIcon.ZOOM);
      case MENU:
        return TablerIcon.create(TablerSystem.OutlineIcon.MENU);
      case MENU_DOWN:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN);
      case MENU_LEFT:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT);
      case MENU_OPEN:
        return TablerIcon.create(TablerDesign.OutlineIcon.LAYOUT_SIDEBAR_LEFT_EXPAND);
      case MENU_RIGHT:
        return TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT);
      case MINUS:
        return TablerIcon.create(TablerMath.OutlineIcon.MINUS);
      case MINUS_BOX:
        return TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_MINUS);
      case PAGE_FIRST:
        return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK);
      case PAGE_LAST:
        return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD);
      case PIN:
        return TablerIcon.create(TablerMap.OutlineIcon.PIN);
      case PIN_OFF:
        return TablerIcon.create(TablerMap.OutlineIcon.PINNED_OFF);
      case PLUS_BOX:
        return TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_PLUS);
      case REDO:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case SHARE:
        return TablerIcon.create(TablerSystem.OutlineIcon.SHARE);
      case SKIP_NEXT:
        return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD);
      case SKIP_PREVIOUS:
        return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK);
      case STAR:
        return TablerIcon.create(TablerSystem.OutlineIcon.STAR);
      case STAR_BORDER:
        return TablerIcon.create(TablerSystem.OutlineIcon.STAR);
      case TRASH_CAN:
        return TablerIcon.create(TablerSystem.OutlineIcon.TRASH);
      case UNDO:
        return TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP);
      case UPLOAD:
        return TablerIcon.create(TablerArrows.OutlineIcon.UPLOAD);
      case SORT:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case SORT_ASCENDING:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case SORT_DESCENDING:
        return TablerIcon.create(TablerSystem.OutlineIcon.HELP_CIRCLE);
      case VECTOR_POINT_PLUS:
        return TablerIcon.create(TablerSystem.OutlineIcon.CROSSHAIR);
      case VIEW_COLUMN:
        return TablerIcon.create(TablerText.OutlineIcon.COLUMNS_3);
      case VIEW_DAY:
        return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
      case VIEW_DAY_OUTLINE:
        return TablerIcon.create(TablerSystem.OutlineIcon.CALENDAR);
      case WARNING:
        return TablerIcon.create(TablerSystem.OutlineIcon.ALERT_TRIANGLE);
      case WINDOW_CLOSE:
        return TablerIcon.create(TablerSystem.OutlineIcon.X);
      case WINDOW_MAXIMIZE:
        return TablerIcon.create(TablerMedia.OutlineIcon.MAXIMIZE);
      case WINDOW_RESTORE:
        return TablerIcon.create(TablerSystem.OutlineIcon.RESTORE);
      default:
        throw new IllegalArgumentException("No Tabler icon for role: " + role);
    }
  }
}
