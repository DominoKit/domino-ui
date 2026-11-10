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
package org.dominokit.domino.ui.config;

import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;
import jsinterop.base.Js;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.icons.lib.Icons;
import org.dominokit.domino.ui.popover.IsPopover;
import org.dominokit.domino.ui.popover.IsTooltip;
import org.dominokit.domino.ui.popover.Popover;
import org.dominokit.domino.ui.popover.Tooltip;

/** UIConfig interface. */
public interface UIConfig
    extends FormsFieldsConfig,
        DominoCoreConfig,
        AccordionConfig,
        CardConfig,
        ProgressBarConfig,
        SearchConfig,
        SpinConfig,
        TabsConfig,
        TreeConfig,
        UploadConfig,
        StepperConfig,
        CalendarConfig,
        TimePickerConfig,
        DelayedActionConfig,
        DatatableConfig,
        CarouselConfig,
        RichTextConfig,
        SlidersConfig,
        MenuConfig,
        NotificationConfig,
        PaginationConfig {

  default Icon<?> getArrowCollapseVerticalIcon() {
    return Icons.arrow_collapse_vertical();
  }

  default Icon<?> getArrowExpandVerticalIcon() {
    return Icons.arrow_expand_vertical();
  }

  default Icon<?> getArrowUpwardIcon() {
    return Icons.arrow_up();
  }

  default Icon<?> getBlockIcon() {
    return Icons.block_helper();
  }

  default Icon<?> getBlurIcon() {
    return Icons.blur();
  }

  default Icon<?> getBlurOffIcon() {
    return Icons.blur_off();
  }

  default Icon<?> getBorderNoneIcon() {
    return Icons.border_none();
  }

  default Icon<?> getBorderVerticalIcon() {
    return Icons.border_vertical();
  }

  default Icon<?> getCancelIcon() {
    return Icons.cancel();
  }

  default Icon<?> getCheckIcon() {
    return Icons.check();
  }

  default Icon<?> getCheckCircleIcon() {
    return Icons.check_circle();
  }

  default Icon<?> getCalendarIcon() {
    return Icons.calendar();
  }

  default Icon<?> getChevronDownIcon() {
    return Icons.chevron_down();
  }

  default Icon<?> getChevronLeftIcon() {
    return Icons.chevron_left();
  }

  default Icon<?> getChevronRightIcon() {
    return Icons.chevron_right();
  }

  default Icon<?> getChevronUpIcon() {
    return Icons.chevron_up();
  }

  default Icon<?> getCircleMediumIcon() {
    return Icons.circle_medium();
  }

  default Icon<?> getCloseIcon() {
    return Icons.close();
  }

  default Icon<?> getClockOutlineIcon() {
    return Icons.clock_outline();
  }

  default Icon<?> getCodeTagsIcon() {
    return Icons.code_tags();
  }

  default Icon<?> getContentCopyIcon() {
    return Icons.content_copy();
  }

  default Icon<?> getContentCutIcon() {
    return Icons.content_cut();
  }

  default Icon<?> getContentPasteIcon() {
    return Icons.content_paste();
  }

  default Icon<?> getDeleteIcon() {
    return Icons.delete();
  }

  default Icon<?> getDragVerticalIcon() {
    return Icons.drag_vertical();
  }

  default Icon<?> getDockLeftIcon() {
    return Icons.dock_left();
  }

  default Icon<?> getDockRightIcon() {
    return Icons.dock_right();
  }

  default Icon<?> getDotsHorizontalIcon() {
    return Icons.dots_horizontal();
  }

  default Icon<?> getDotsVerticalIcon() {
    return Icons.dots_vertical();
  }

  default Icon<?> getExclamationIcon() {
    return Icons.exclamation();
  }

  default Icon<?> getFileUploadIcon() {
    return Icons.file_upload();
  }

  default Icon<?> getFilterOffIcon() {
    return Icons.filter_off();
  }

  default Icon<?> getFormatAlignCenterIcon() {
    return Icons.format_align_center();
  }

  default Icon<?> getFormatAlignJustifyIcon() {
    return Icons.format_align_justify();
  }

  default Icon<?> getFormatAlignLeftIcon() {
    return Icons.format_align_left();
  }

  default Icon<?> getFormatAlignRightIcon() {
    return Icons.format_align_right();
  }

  default Icon<?> getFormatBoldIcon() {
    return Icons.format_bold();
  }

  default Icon<?> getFormatColorHighlightIcon() {
    return Icons.format_color_highlight();
  }

  default Icon<?> getFormatColorMarkerCancelIcon() {
    return Icons.format_color_marker_cancel();
  }

  default Icon<?> getFormatColorTextIcon() {
    return Icons.format_color_text();
  }

  default Icon<?> getFormatFontSizeDecreaseIcon() {
    return Icons.format_font_size_decrease();
  }

  default Icon<?> getFormatFontSizeIncreaseIcon() {
    return Icons.format_font_size_increase();
  }

  default Icon<?> getFormatHeader1Icon() {
    return Icons.format_header_1();
  }

  default Icon<?> getFormatHeader2Icon() {
    return Icons.format_header_2();
  }

  default Icon<?> getFormatHeader3Icon() {
    return Icons.format_header_3();
  }

  default Icon<?> getFormatHeader4Icon() {
    return Icons.format_header_4();
  }

  default Icon<?> getFormatHeader5Icon() {
    return Icons.format_header_5();
  }

  default Icon<?> getFormatHeader6Icon() {
    return Icons.format_header_6();
  }

  default Icon<?> getFormatIndentDecreaseIcon() {
    return Icons.format_indent_decrease();
  }

  default Icon<?> getFormatIndentIncreaseIcon() {
    return Icons.format_indent_increase();
  }

  default Icon<?> getFormatItalicIcon() {
    return Icons.format_italic();
  }

  default Icon<?> getFormatListBulletedIcon() {
    return Icons.format_list_bulleted();
  }

  default Icon<?> getFormatListNumberedIcon() {
    return Icons.format_list_numbered();
  }

  default Icon<?> getFormatParagraphIcon() {
    return Icons.format_paragraph();
  }

  default Icon<?> getFormatStrikethroughIcon() {
    return Icons.format_strikethrough();
  }

  default Icon<?> getFormatSubscriptIcon() {
    return Icons.format_subscript();
  }

  default Icon<?> getFormatSuperscriptIcon() {
    return Icons.format_superscript();
  }

  default Icon<?> getFormatUnderlineIcon() {
    return Icons.format_underline();
  }

  default Icon<?> getFullscreenIcon() {
    return Icons.fullscreen();
  }

  default Icon<?> getFullscreenExitIcon() {
    return Icons.fullscreen_exit();
  }

  default Icon<?> getImageIcon() {
    return Icons.image();
  }

  default Icon<?> getKeyboardBackspaceIcon() {
    return Icons.keyboard_backspace();
  }

  default Icon<?> getLinkIcon() {
    return Icons.link();
  }

  default Icon<?> getLinkOffIcon() {
    return Icons.link_off();
  }

  default Icon<?> getMagnifyIcon() {
    return Icons.magnify();
  }

  default Icon<?> getMenuIcon() {
    return Icons.menu();
  }

  default Icon<?> getMenuDownIcon() {
    return Icons.menu_down();
  }

  default Icon<?> getMenuLeftIcon() {
    return Icons.menu_left();
  }

  default Icon<?> getMenuOpenIcon() {
    return Icons.menu_open();
  }

  default Icon<?> getMenuRightIcon() {
    return Icons.menu_right();
  }

  default Icon<?> getMinusIcon() {
    return Icons.minus();
  }

  default Icon<?> getMinusBoxIcon() {
    return Icons.minus_box();
  }

  default Icon<?> getPageFirstIcon() {
    return Icons.page_first();
  }

  default Icon<?> getPageLastIcon() {
    return Icons.page_last();
  }

  default Icon<?> getPinIcon() {
    return Icons.pin();
  }

  default Icon<?> getPinOffIcon() {
    return Icons.pin_off();
  }

  default Icon<?> getPlusBoxIcon() {
    return Icons.plus_box();
  }

  default Icon<?> getRedoIcon() {
    return Icons.redo();
  }

  default Icon<?> getShareIcon() {
    return Icons.share();
  }

  default Icon<?> getSkipNextIcon() {
    return Icons.skip_next();
  }

  default Icon<?> getSkipPreviousIcon() {
    return Icons.skip_previous();
  }

  default Icon<?> getStarIcon() {
    return Icons.star();
  }

  default Icon<?> getStarBorderIcon() {
    return Icons.star_outline();
  }

  default Icon<?> getTrashCanIcon() {
    return Icons.trash_can();
  }

  default Icon<?> getUndoIcon() {
    return Icons.undo();
  }

  default Icon<?> getUploadIcon() {
    return Icons.upload();
  }

  default Icon<?> getSortIcon() {
    return Icons.sort();
  }

  default Icon<?> getSortAscendingIcon() {
    return Icons.sort_ascending();
  }

  default Icon<?> getSortDescendingIcon() {
    return Icons.sort_descending();
  }

  default Icon<?> getVectorPointPlusIcon() {
    return Icons.vector_point_plus();
  }

  default Icon<?> getViewColumnIcon() {
    return Icons.view_column();
  }

  default Icon<?> getViewDayIcon() {
    return Icons.view_day();
  }

  default Icon<?> getViewDayOutlineIcon() {
    return Icons.view_day_outline();
  }

  default Icon<?> getWarningIcon() {
    return Icons.alert();
  }

  default Icon<?> getWindowCloseIcon() {
    return Icons.window_close();
  }

  default Icon<?> getWindowMaximizeIcon() {
    return Icons.window_maximize();
  }

  default Icon<?> getWindowRestoreIcon() {
    return Icons.window_restore();
  }

  @Override
  default IsPopover<?, ?> createPopover(Element target) {
    return Popover.create(Js.<HTMLElement>uncheckedCast(target));
  }

  @Override
  default IsTooltip<?, ?> createTooltip(Element target, String text) {
    return Tooltip.create(target, text);
  }

  @Override
  default IsTooltip<?, ?> createTooltip(Element target, Node content) {
    return Tooltip.create(target, content);
  }
}
