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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerText;

/** Static icon factory for the Tabler Text category. */
public final class TablerText_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerText tagIcons = new TablerText() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "a-b-2 (outline)", "TablerIcon.create(TablerText.OutlineIcon.A_B_2)", tagIcons::a_b_2));
    icons.add(
        new IconCatalogEntry<>(
            "a-b-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.A_B_OFF)",
            tagIcons::a_b_off));
    icons.add(
        new IconCatalogEntry<>(
            "abc (outline)", "TablerIcon.create(TablerText.OutlineIcon.ABC)", tagIcons::abc));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-center (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_CENTER)",
            tagIcons::align_box_bottom_center));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-left (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_LEFT)",
            tagIcons::align_box_bottom_left));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-right (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_BOTTOM_RIGHT)",
            tagIcons::align_box_bottom_right));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-center-bottom (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_BOTTOM)",
            tagIcons::align_box_center_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-center-middle (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_MIDDLE)",
            tagIcons::align_box_center_middle));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-center-stretch (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_STRETCH)",
            tagIcons::align_box_center_stretch));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-center-top (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_CENTER_TOP)",
            tagIcons::align_box_center_top));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-bottom (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_BOTTOM)",
            tagIcons::align_box_left_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-middle (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_MIDDLE)",
            tagIcons::align_box_left_middle));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-stretch (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_STRETCH)",
            tagIcons::align_box_left_stretch));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-top (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_LEFT_TOP)",
            tagIcons::align_box_left_top));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-bottom (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_BOTTOM)",
            tagIcons::align_box_right_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-middle (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_MIDDLE)",
            tagIcons::align_box_right_middle));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-stretch (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_STRETCH)",
            tagIcons::align_box_right_stretch));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-top (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_RIGHT_TOP)",
            tagIcons::align_box_right_top));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-center (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_CENTER)",
            tagIcons::align_box_top_center));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-left (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_LEFT)",
            tagIcons::align_box_top_left));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-right (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_BOX_TOP_RIGHT)",
            tagIcons::align_box_top_right));
    icons.add(
        new IconCatalogEntry<>(
            "align-center (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_CENTER)",
            tagIcons::align_center));
    icons.add(
        new IconCatalogEntry<>(
            "align-justified (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_JUSTIFIED)",
            tagIcons::align_justified));
    icons.add(
        new IconCatalogEntry<>(
            "align-left (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_LEFT)",
            tagIcons::align_left));
    icons.add(
        new IconCatalogEntry<>(
            "align-left-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_LEFT_2)",
            tagIcons::align_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "align-right (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_RIGHT)",
            tagIcons::align_right));
    icons.add(
        new IconCatalogEntry<>(
            "align-right-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_RIGHT_2)",
            tagIcons::align_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-arabic (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_ARABIC)",
            tagIcons::alphabet_arabic));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-bangla (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_BANGLA)",
            tagIcons::alphabet_bangla));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-chinese (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_CHINESE)",
            tagIcons::alphabet_chinese));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-cyrillic (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_CYRILLIC)",
            tagIcons::alphabet_cyrillic));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-devanagari (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_DEVANAGARI)",
            tagIcons::alphabet_devanagari));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-ethiopic (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_ETHIOPIC)",
            tagIcons::alphabet_ethiopic));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-georgian (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_GEORGIAN)",
            tagIcons::alphabet_georgian));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-greek (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_GREEK)",
            tagIcons::alphabet_greek));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-hebrew (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_HEBREW)",
            tagIcons::alphabet_hebrew));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-japanese (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_JAPANESE)",
            tagIcons::alphabet_japanese));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-korean (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_KOREAN)",
            tagIcons::alphabet_korean));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-latin (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_LATIN)",
            tagIcons::alphabet_latin));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-polish (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_POLISH)",
            tagIcons::alphabet_polish));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-runes (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_RUNES)",
            tagIcons::alphabet_runes));
    icons.add(
        new IconCatalogEntry<>(
            "alphabet-thai (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALPHABET_THAI)",
            tagIcons::alphabet_thai));
    icons.add(
        new IconCatalogEntry<>(
            "asterisk (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ASTERISK)",
            tagIcons::asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "asterisk-simple (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ASTERISK_SIMPLE)",
            tagIcons::asterisk_simple));
    icons.add(
        new IconCatalogEntry<>(
            "at (outline)", "TablerIcon.create(TablerText.OutlineIcon.AT)", tagIcons::at));
    icons.add(
        new IconCatalogEntry<>(
            "at-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.AT_OFF)",
            tagIcons::at_off));
    icons.add(
        new IconCatalogEntry<>(
            "backspace (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BACKSPACE)",
            tagIcons::backspace));
    icons.add(
        new IconCatalogEntry<>(
            "ballpen (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BALLPEN)",
            tagIcons::ballpen));
    icons.add(
        new IconCatalogEntry<>(
            "ballpen-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BALLPEN_OFF)",
            tagIcons::ballpen_off));
    icons.add(
        new IconCatalogEntry<>(
            "baseline (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BASELINE)",
            tagIcons::baseline));
    icons.add(
        new IconCatalogEntry<>(
            "baseline-density-large (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_LARGE)",
            tagIcons::baseline_density_large));
    icons.add(
        new IconCatalogEntry<>(
            "baseline-density-medium (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_MEDIUM)",
            tagIcons::baseline_density_medium));
    icons.add(
        new IconCatalogEntry<>(
            "baseline-density-small (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BASELINE_DENSITY_SMALL)",
            tagIcons::baseline_density_small));
    icons.add(
        new IconCatalogEntry<>(
            "bible (outline)", "TablerIcon.create(TablerText.OutlineIcon.BIBLE)", tagIcons::bible));
    icons.add(
        new IconCatalogEntry<>(
            "blockquote (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BLOCKQUOTE)",
            tagIcons::blockquote));
    icons.add(
        new IconCatalogEntry<>(
            "bold (outline)", "TablerIcon.create(TablerText.OutlineIcon.BOLD)", tagIcons::bold));
    icons.add(
        new IconCatalogEntry<>(
            "bold-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BOLD_OFF)",
            tagIcons::bold_off));
    icons.add(
        new IconCatalogEntry<>(
            "clear-formatting (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CLEAR_FORMATTING)",
            tagIcons::clear_formatting));
    icons.add(
        new IconCatalogEntry<>(
            "code (outline)", "TablerIcon.create(TablerText.OutlineIcon.CODE)", tagIcons::code));
    icons.add(
        new IconCatalogEntry<>(
            "code-asterisk (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_ASTERISK)",
            tagIcons::code_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "code-circle (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_CIRCLE)",
            tagIcons::code_circle));
    icons.add(
        new IconCatalogEntry<>(
            "code-circle-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_CIRCLE_2)",
            tagIcons::code_circle_2));
    icons.add(
        new IconCatalogEntry<>(
            "code-dots (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_DOTS)",
            tagIcons::code_dots));
    icons.add(
        new IconCatalogEntry<>(
            "code-minus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_MINUS)",
            tagIcons::code_minus));
    icons.add(
        new IconCatalogEntry<>(
            "code-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_OFF)",
            tagIcons::code_off));
    icons.add(
        new IconCatalogEntry<>(
            "code-plus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE_PLUS)",
            tagIcons::code_plus));
    icons.add(
        new IconCatalogEntry<>(
            "columns (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS)",
            tagIcons::columns));
    icons.add(
        new IconCatalogEntry<>(
            "columns-1 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS_1)",
            tagIcons::columns_1));
    icons.add(
        new IconCatalogEntry<>(
            "columns-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS_2)",
            tagIcons::columns_2));
    icons.add(
        new IconCatalogEntry<>(
            "columns-3 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS_3)",
            tagIcons::columns_3));
    icons.add(
        new IconCatalogEntry<>(
            "columns-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS_OFF)",
            tagIcons::columns_off));
    icons.add(
        new IconCatalogEntry<>(
            "copy (outline)", "TablerIcon.create(TablerText.OutlineIcon.COPY)", tagIcons::copy));
    icons.add(
        new IconCatalogEntry<>(
            "copy-check (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY_CHECK)",
            tagIcons::copy_check));
    icons.add(
        new IconCatalogEntry<>(
            "copy-minus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY_MINUS)",
            tagIcons::copy_minus));
    icons.add(
        new IconCatalogEntry<>(
            "copy-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY_OFF)",
            tagIcons::copy_off));
    icons.add(
        new IconCatalogEntry<>(
            "copy-plus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY_PLUS)",
            tagIcons::copy_plus));
    icons.add(
        new IconCatalogEntry<>(
            "copy-x (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY_X)",
            tagIcons::copy_x));
    icons.add(
        new IconCatalogEntry<>(
            "cursor-text (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CURSOR_TEXT)",
            tagIcons::cursor_text));
    icons.add(
        new IconCatalogEntry<>(
            "duplicate (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.DUPLICATE)",
            tagIcons::duplicate));
    icons.add(
        new IconCatalogEntry<>(
            "emphasis (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.EMPHASIS)",
            tagIcons::emphasis));
    icons.add(
        new IconCatalogEntry<>(
            "eraser (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ERASER)",
            tagIcons::eraser));
    icons.add(
        new IconCatalogEntry<>(
            "eraser-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ERASER_OFF)",
            tagIcons::eraser_off));
    icons.add(
        new IconCatalogEntry<>(
            "float-center (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.FLOAT_CENTER)",
            tagIcons::float_center));
    icons.add(
        new IconCatalogEntry<>(
            "float-left (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.FLOAT_LEFT)",
            tagIcons::float_left));
    icons.add(
        new IconCatalogEntry<>(
            "float-none (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.FLOAT_NONE)",
            tagIcons::float_none));
    icons.add(
        new IconCatalogEntry<>(
            "float-right (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.FLOAT_RIGHT)",
            tagIcons::float_right));
    icons.add(
        new IconCatalogEntry<>(
            "forms (outline)", "TablerIcon.create(TablerText.OutlineIcon.FORMS)", tagIcons::forms));
    icons.add(
        new IconCatalogEntry<>(
            "h-1 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_1)", tagIcons::h_1));
    icons.add(
        new IconCatalogEntry<>(
            "h-2 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_2)", tagIcons::h_2));
    icons.add(
        new IconCatalogEntry<>(
            "h-3 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_3)", tagIcons::h_3));
    icons.add(
        new IconCatalogEntry<>(
            "h-4 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_4)", tagIcons::h_4));
    icons.add(
        new IconCatalogEntry<>(
            "h-5 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_5)", tagIcons::h_5));
    icons.add(
        new IconCatalogEntry<>(
            "h-6 (outline)", "TablerIcon.create(TablerText.OutlineIcon.H_6)", tagIcons::h_6));
    icons.add(
        new IconCatalogEntry<>(
            "heading (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.HEADING)",
            tagIcons::heading));
    icons.add(
        new IconCatalogEntry<>(
            "heading-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.HEADING_OFF)",
            tagIcons::heading_off));
    icons.add(
        new IconCatalogEntry<>(
            "highlight (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT)",
            tagIcons::highlight));
    icons.add(
        new IconCatalogEntry<>(
            "highlight-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT_OFF)",
            tagIcons::highlight_off));
    icons.add(
        new IconCatalogEntry<>(
            "indent-decrease (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.INDENT_DECREASE)",
            tagIcons::indent_decrease));
    icons.add(
        new IconCatalogEntry<>(
            "indent-increase (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.INDENT_INCREASE)",
            tagIcons::indent_increase));
    icons.add(
        new IconCatalogEntry<>(
            "input-search (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.INPUT_SEARCH)",
            tagIcons::input_search));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "italic (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ITALIC)",
            tagIcons::italic));
    icons.add(
        new IconCatalogEntry<>(
            "italic-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ITALIC_OFF)",
            tagIcons::italic_off));
    icons.add(
        new IconCatalogEntry<>(
            "kerning (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.KERNING)",
            tagIcons::kerning));
    icons.add(
        new IconCatalogEntry<>(
            "language (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LANGUAGE)",
            tagIcons::language));
    icons.add(
        new IconCatalogEntry<>(
            "language-hiragana (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_HIRAGANA)",
            tagIcons::language_hiragana));
    icons.add(
        new IconCatalogEntry<>(
            "language-katakana (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_KATAKANA)",
            tagIcons::language_katakana));
    icons.add(
        new IconCatalogEntry<>(
            "language-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LANGUAGE_OFF)",
            tagIcons::language_off));
    icons.add(
        new IconCatalogEntry<>(
            "letter-case (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE)",
            tagIcons::letter_case));
    icons.add(
        new IconCatalogEntry<>(
            "letter-case-lower (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_LOWER)",
            tagIcons::letter_case_lower));
    icons.add(
        new IconCatalogEntry<>(
            "letter-case-toggle (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_TOGGLE)",
            tagIcons::letter_case_toggle));
    icons.add(
        new IconCatalogEntry<>(
            "letter-case-upper (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LETTER_CASE_UPPER)",
            tagIcons::letter_case_upper));
    icons.add(
        new IconCatalogEntry<>(
            "letter-spacing (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LETTER_SPACING)",
            tagIcons::letter_spacing));
    icons.add(
        new IconCatalogEntry<>(
            "line-height (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LINE_HEIGHT)",
            tagIcons::line_height));
    icons.add(
        new IconCatalogEntry<>(
            "link (outline)", "TablerIcon.create(TablerText.OutlineIcon.LINK)", tagIcons::link));
    icons.add(
        new IconCatalogEntry<>(
            "link-minus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LINK_MINUS)",
            tagIcons::link_minus));
    icons.add(
        new IconCatalogEntry<>(
            "link-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LINK_OFF)",
            tagIcons::link_off));
    icons.add(
        new IconCatalogEntry<>(
            "link-plus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LINK_PLUS)",
            tagIcons::link_plus));
    icons.add(
        new IconCatalogEntry<>(
            "list (outline)", "TablerIcon.create(TablerText.OutlineIcon.LIST)", tagIcons::list));
    icons.add(
        new IconCatalogEntry<>(
            "list-check (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST_CHECK)",
            tagIcons::list_check));
    icons.add(
        new IconCatalogEntry<>(
            "list-details (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST_DETAILS)",
            tagIcons::list_details));
    icons.add(
        new IconCatalogEntry<>(
            "list-numbers (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST_NUMBERS)",
            tagIcons::list_numbers));
    icons.add(
        new IconCatalogEntry<>(
            "list-search (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST_SEARCH)",
            tagIcons::list_search));
    icons.add(
        new IconCatalogEntry<>(
            "markdown (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.MARKDOWN)",
            tagIcons::markdown));
    icons.add(
        new IconCatalogEntry<>(
            "markdown-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.MARKDOWN_OFF)",
            tagIcons::markdown_off));
    icons.add(
        new IconCatalogEntry<>(
            "notdef (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.NOTDEF)",
            tagIcons::notdef));
    icons.add(
        new IconCatalogEntry<>(
            "overline (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.OVERLINE)",
            tagIcons::overline));
    icons.add(
        new IconCatalogEntry<>(
            "pilcrow (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.PILCROW)",
            tagIcons::pilcrow));
    icons.add(
        new IconCatalogEntry<>(
            "pilcrow-left (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.PILCROW_LEFT)",
            tagIcons::pilcrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "pilcrow-right (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.PILCROW_RIGHT)",
            tagIcons::pilcrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "quote (outline)", "TablerIcon.create(TablerText.OutlineIcon.QUOTE)", tagIcons::quote));
    icons.add(
        new IconCatalogEntry<>(
            "quote-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.QUOTE_OFF)",
            tagIcons::quote_off));
    icons.add(
        new IconCatalogEntry<>(
            "quote-open (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.QUOTE_OPEN)",
            tagIcons::quote_open));
    icons.add(
        new IconCatalogEntry<>(
            "quotes (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.QUOTES)",
            tagIcons::quotes));
    icons.add(
        new IconCatalogEntry<>(
            "regex (outline)", "TablerIcon.create(TablerText.OutlineIcon.REGEX)", tagIcons::regex));
    icons.add(
        new IconCatalogEntry<>(
            "regex-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.REGEX_OFF)",
            tagIcons::regex_off));
    icons.add(
        new IconCatalogEntry<>(
            "scribble (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SCRIBBLE)",
            tagIcons::scribble));
    icons.add(
        new IconCatalogEntry<>(
            "scribble-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SCRIBBLE_OFF)",
            tagIcons::scribble_off));
    icons.add(
        new IconCatalogEntry<>(
            "section-sign (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SECTION_SIGN)",
            tagIcons::section_sign));
    icons.add(
        new IconCatalogEntry<>(
            "separator (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SEPARATOR)",
            tagIcons::separator));
    icons.add(
        new IconCatalogEntry<>(
            "separator-horizontal (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SEPARATOR_HORIZONTAL)",
            tagIcons::separator_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "separator-vertical (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SEPARATOR_VERTICAL)",
            tagIcons::separator_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "signature (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SIGNATURE)",
            tagIcons::signature));
    icons.add(
        new IconCatalogEntry<>(
            "signature-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SIGNATURE_OFF)",
            tagIcons::signature_off));
    icons.add(
        new IconCatalogEntry<>(
            "slideshow (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SLIDESHOW)",
            tagIcons::slideshow));
    icons.add(
        new IconCatalogEntry<>(
            "sort-0-9 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_0_9)",
            tagIcons::sort_0_9));
    icons.add(
        new IconCatalogEntry<>(
            "sort-9-0 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_9_0)",
            tagIcons::sort_9_0));
    icons.add(
        new IconCatalogEntry<>(
            "sort-a-z (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_A_Z)",
            tagIcons::sort_a_z));
    icons.add(
        new IconCatalogEntry<>(
            "sort-ascending (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING)",
            tagIcons::sort_ascending));
    icons.add(
        new IconCatalogEntry<>(
            "sort-ascending-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_2)",
            tagIcons::sort_ascending_2));
    icons.add(
        new IconCatalogEntry<>(
            "sort-ascending-letters (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_LETTERS)",
            tagIcons::sort_ascending_letters));
    icons.add(
        new IconCatalogEntry<>(
            "sort-ascending-numbers (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_ASCENDING_NUMBERS)",
            tagIcons::sort_ascending_numbers));
    icons.add(
        new IconCatalogEntry<>(
            "sort-descending (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING)",
            tagIcons::sort_descending));
    icons.add(
        new IconCatalogEntry<>(
            "sort-descending-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_2)",
            tagIcons::sort_descending_2));
    icons.add(
        new IconCatalogEntry<>(
            "sort-descending-letters (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_LETTERS)",
            tagIcons::sort_descending_letters));
    icons.add(
        new IconCatalogEntry<>(
            "sort-descending-numbers (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_DESCENDING_NUMBERS)",
            tagIcons::sort_descending_numbers));
    icons.add(
        new IconCatalogEntry<>(
            "sort-z-a (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SORT_Z_A)",
            tagIcons::sort_z_a));
    icons.add(
        new IconCatalogEntry<>(
            "space (outline)", "TablerIcon.create(TablerText.OutlineIcon.SPACE)", tagIcons::space));
    icons.add(
        new IconCatalogEntry<>(
            "space-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SPACE_OFF)",
            tagIcons::space_off));
    icons.add(
        new IconCatalogEntry<>(
            "strikethrough (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.STRIKETHROUGH)",
            tagIcons::strikethrough));
    icons.add(
        new IconCatalogEntry<>(
            "subscript (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SUBSCRIPT)",
            tagIcons::subscript));
    icons.add(
        new IconCatalogEntry<>(
            "superscript (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SUPERSCRIPT)",
            tagIcons::superscript));
    icons.add(
        new IconCatalogEntry<>(
            "tex (outline)", "TablerIcon.create(TablerText.OutlineIcon.TEX)", tagIcons::tex));
    icons.add(
        new IconCatalogEntry<>(
            "text-caption (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_CAPTION)",
            tagIcons::text_caption));
    icons.add(
        new IconCatalogEntry<>(
            "text-color (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_COLOR)",
            tagIcons::text_color));
    icons.add(
        new IconCatalogEntry<>(
            "text-decrease (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_DECREASE)",
            tagIcons::text_decrease));
    icons.add(
        new IconCatalogEntry<>(
            "text-direction-ltr (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_DIRECTION_LTR)",
            tagIcons::text_direction_ltr));
    icons.add(
        new IconCatalogEntry<>(
            "text-direction-rtl (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_DIRECTION_RTL)",
            tagIcons::text_direction_rtl));
    icons.add(
        new IconCatalogEntry<>(
            "text-grammar (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_GRAMMAR)",
            tagIcons::text_grammar));
    icons.add(
        new IconCatalogEntry<>(
            "text-increase (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_INCREASE)",
            tagIcons::text_increase));
    icons.add(
        new IconCatalogEntry<>(
            "text-orientation (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_ORIENTATION)",
            tagIcons::text_orientation));
    icons.add(
        new IconCatalogEntry<>(
            "text-outline (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_OUTLINE)",
            tagIcons::text_outline));
    icons.add(
        new IconCatalogEntry<>(
            "text-plus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_PLUS)",
            tagIcons::text_plus));
    icons.add(
        new IconCatalogEntry<>(
            "text-recognition (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_RECOGNITION)",
            tagIcons::text_recognition));
    icons.add(
        new IconCatalogEntry<>(
            "text-regex-asterisk (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_ASTERISK)",
            tagIcons::text_regex_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "text-regex-end (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_END)",
            tagIcons::text_regex_end));
    icons.add(
        new IconCatalogEntry<>(
            "text-regex-plus (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_PLUS)",
            tagIcons::text_regex_plus));
    icons.add(
        new IconCatalogEntry<>(
            "text-regex-question (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_QUESTION)",
            tagIcons::text_regex_question));
    icons.add(
        new IconCatalogEntry<>(
            "text-regex-start (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_REGEX_START)",
            tagIcons::text_regex_start));
    icons.add(
        new IconCatalogEntry<>(
            "text-size (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_SIZE)",
            tagIcons::text_size));
    icons.add(
        new IconCatalogEntry<>(
            "text-spellcheck (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_SPELLCHECK)",
            tagIcons::text_spellcheck));
    icons.add(
        new IconCatalogEntry<>(
            "text-wrap (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP)",
            tagIcons::text_wrap));
    icons.add(
        new IconCatalogEntry<>(
            "text-wrap-column (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP_COLUMN)",
            tagIcons::text_wrap_column));
    icons.add(
        new IconCatalogEntry<>(
            "text-wrap-disabled (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TEXT_WRAP_DISABLED)",
            tagIcons::text_wrap_disabled));
    icons.add(
        new IconCatalogEntry<>(
            "typography (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TYPOGRAPHY)",
            tagIcons::typography));
    icons.add(
        new IconCatalogEntry<>(
            "typography-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.TYPOGRAPHY_OFF)",
            tagIcons::typography_off));
    icons.add(
        new IconCatalogEntry<>(
            "underline (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.UNDERLINE)",
            tagIcons::underline));
    icons.add(
        new IconCatalogEntry<>(
            "underline-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.UNDERLINE_OFF)",
            tagIcons::underline_off));
    icons.add(
        new IconCatalogEntry<>(
            "unlink (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.UNLINK)",
            tagIcons::unlink));
    icons.add(
        new IconCatalogEntry<>(
            "vocabulary (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.VOCABULARY)",
            tagIcons::vocabulary));
    icons.add(
        new IconCatalogEntry<>(
            "vocabulary-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.VOCABULARY_OFF)",
            tagIcons::vocabulary_off));
    icons.add(
        new IconCatalogEntry<>(
            "writing (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.WRITING)",
            tagIcons::writing));
    icons.add(
        new IconCatalogEntry<>(
            "writing-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.WRITING_OFF)",
            tagIcons::writing_off));
    icons.add(
        new IconCatalogEntry<>(
            "writing-sign (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.WRITING_SIGN)",
            tagIcons::writing_sign));
    icons.add(
        new IconCatalogEntry<>(
            "writing-sign-off (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.WRITING_SIGN_OFF)",
            tagIcons::writing_sign_off));
    icons.add(
        new IconCatalogEntry<>(
            "code-tags (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.CODE)",
            tagIcons::code_tags));
    icons.add(
        new IconCatalogEntry<>(
            "content-copy (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COPY)",
            tagIcons::content_copy));
    icons.add(
        new IconCatalogEntry<>(
            "format-align-justify (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ALIGN_JUSTIFIED)",
            tagIcons::format_align_justify));
    icons.add(
        new IconCatalogEntry<>(
            "format-bold (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BOLD)",
            tagIcons::format_bold));
    icons.add(
        new IconCatalogEntry<>(
            "format-color-highlight (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.HIGHLIGHT)",
            tagIcons::format_color_highlight));
    icons.add(
        new IconCatalogEntry<>(
            "format-color-marker-cancel (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BACKSPACE)",
            tagIcons::format_color_marker_cancel));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "format-header-1 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_1)",
            tagIcons::format_header_1));
    icons.add(
        new IconCatalogEntry<>(
            "format-header-2 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_2)",
            tagIcons::format_header_2));
    icons.add(
        new IconCatalogEntry<>(
            "format-header-3 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_3)",
            tagIcons::format_header_3));
    icons.add(
        new IconCatalogEntry<>(
            "format-header-4 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_4)",
            tagIcons::format_header_4));
    icons.add(
        new IconCatalogEntry<>(
            "format-header-5 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_5)",
            tagIcons::format_header_5));
    icons.add(
        new IconCatalogEntry<>(
            "format-header-6 (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.H_6)",
            tagIcons::format_header_6));
    icons.add(
        new IconCatalogEntry<>(
            "format-indent-decrease (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.INDENT_DECREASE)",
            tagIcons::format_indent_decrease));
    icons.add(
        new IconCatalogEntry<>(
            "format-indent-increase (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.INDENT_INCREASE)",
            tagIcons::format_indent_increase));
    icons.add(
        new IconCatalogEntry<>(
            "format-italic (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.ITALIC)",
            tagIcons::format_italic));
    icons.add(
        new IconCatalogEntry<>(
            "format-list-bulleted (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST)",
            tagIcons::format_list_bulleted));
    icons.add(
        new IconCatalogEntry<>(
            "format-list-numbered (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.LIST_NUMBERS)",
            tagIcons::format_list_numbered));
    icons.add(
        new IconCatalogEntry<>(
            "format-paragraph (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.PILCROW)",
            tagIcons::format_paragraph));
    icons.add(
        new IconCatalogEntry<>(
            "format-strikethrough (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.STRIKETHROUGH)",
            tagIcons::format_strikethrough));
    icons.add(
        new IconCatalogEntry<>(
            "format-subscript (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SUBSCRIPT)",
            tagIcons::format_subscript));
    icons.add(
        new IconCatalogEntry<>(
            "format-superscript (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.SUPERSCRIPT)",
            tagIcons::format_superscript));
    icons.add(
        new IconCatalogEntry<>(
            "format-underline (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.UNDERLINE)",
            tagIcons::format_underline));
    icons.add(
        new IconCatalogEntry<>(
            "keyboard-backspace (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.BACKSPACE)",
            tagIcons::keyboard_backspace));
    icons.add(
        new IconCatalogEntry<>(
            "view-column (outline)",
            "TablerIcon.create(TablerText.OutlineIcon.COLUMNS_3)",
            tagIcons::view_column));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-center (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_CENTER)",
            tagIcons::align_box_bottom_center_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-left (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_LEFT)",
            tagIcons::align_box_bottom_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-bottom-right (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_BOTTOM_RIGHT)",
            tagIcons::align_box_bottom_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-center-middle (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_CENTER_MIDDLE)",
            tagIcons::align_box_center_middle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-bottom (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_BOTTOM)",
            tagIcons::align_box_left_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-middle (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_MIDDLE)",
            tagIcons::align_box_left_middle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-left-top (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_LEFT_TOP)",
            tagIcons::align_box_left_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-bottom (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_BOTTOM)",
            tagIcons::align_box_right_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-middle (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_MIDDLE)",
            tagIcons::align_box_right_middle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-right-top (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_RIGHT_TOP)",
            tagIcons::align_box_right_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-center (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_CENTER)",
            tagIcons::align_box_top_center_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-left (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_LEFT)",
            tagIcons::align_box_top_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "align-box-top-right (filled)",
            "TablerIcon.create(TablerText.FilledIcon.ALIGN_BOX_TOP_RIGHT)",
            tagIcons::align_box_top_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "backspace (filled)",
            "TablerIcon.create(TablerText.FilledIcon.BACKSPACE)",
            tagIcons::backspace_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ballpen (filled)",
            "TablerIcon.create(TablerText.FilledIcon.BALLPEN)",
            tagIcons::ballpen_filled));
    icons.add(
        new IconCatalogEntry<>(
            "code-circle (filled)",
            "TablerIcon.create(TablerText.FilledIcon.CODE_CIRCLE)",
            tagIcons::code_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "code-circle-2 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.CODE_CIRCLE_2)",
            tagIcons::code_circle_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "columns-1 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COLUMNS_1)",
            tagIcons::columns_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "columns-2 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COLUMNS_2)",
            tagIcons::columns_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "columns-3 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COLUMNS_3)",
            tagIcons::columns_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copy (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COPY)",
            tagIcons::copy_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copy-check (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COPY_CHECK)",
            tagIcons::copy_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copy-minus (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COPY_MINUS)",
            tagIcons::copy_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copy-plus (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COPY_PLUS)",
            tagIcons::copy_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "copy-x (filled)",
            "TablerIcon.create(TablerText.FilledIcon.COPY_X)",
            tagIcons::copy_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "link (filled)",
            "TablerIcon.create(TablerText.FilledIcon.LINK)",
            tagIcons::link_filled));
    icons.add(
        new IconCatalogEntry<>(
            "list (filled)",
            "TablerIcon.create(TablerText.FilledIcon.LIST)",
            tagIcons::list_filled));
    icons.add(
        new IconCatalogEntry<>(
            "list-check (filled)",
            "TablerIcon.create(TablerText.FilledIcon.LIST_CHECK)",
            tagIcons::list_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "list-details (filled)",
            "TablerIcon.create(TablerText.FilledIcon.LIST_DETAILS)",
            tagIcons::list_details_filled));
    icons.add(
        new IconCatalogEntry<>(
            "quote (filled)",
            "TablerIcon.create(TablerText.FilledIcon.QUOTE)",
            tagIcons::quote_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sort-ascending-2 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.SORT_ASCENDING_2)",
            tagIcons::sort_ascending_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sort-descending-2 (filled)",
            "TablerIcon.create(TablerText.FilledIcon.SORT_DESCENDING_2)",
            tagIcons::sort_descending_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "writing (filled)",
            "TablerIcon.create(TablerText.FilledIcon.WRITING)",
            tagIcons::writing_filled));
    icons.add(
        new IconCatalogEntry<>(
            "writing-sign (filled)",
            "TablerIcon.create(TablerText.FilledIcon.WRITING_SIGN)",
            tagIcons::writing_sign_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
