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
import org.dominokit.domino.ui.icons.TablerArrows;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Arrows category. */
public final class TablerArrows_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerArrows tagIcons = new TablerArrows() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
    addIcons3();
    addIcons4();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-content (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_CONTENT)",
            tagIcons::arrow_autofit_content));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_DOWN)",
            tagIcons::arrow_autofit_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-height (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_HEIGHT)",
            tagIcons::arrow_autofit_height));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_LEFT)",
            tagIcons::arrow_autofit_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_RIGHT)",
            tagIcons::arrow_autofit_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_UP)",
            tagIcons::arrow_autofit_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-width (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_AUTOFIT_WIDTH)",
            tagIcons::arrow_autofit_width));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK)",
            tagIcons::arrow_back));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP)",
            tagIcons::arrow_back_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back-up-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP_DOUBLE)",
            tagIcons::arrow_back_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_DOWN)",
            tagIcons::arrow_badge_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_LEFT)",
            tagIcons::arrow_badge_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_RIGHT)",
            tagIcons::arrow_badge_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BADGE_UP)",
            tagIcons::arrow_badge_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-both (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_BOTH)",
            tagIcons::arrow_bar_both));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_DOWN)",
            tagIcons::arrow_bar_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_LEFT)",
            tagIcons::arrow_bar_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_RIGHT)",
            tagIcons::arrow_bar_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_DOWN)",
            tagIcons::arrow_bar_to_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-down-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_DOWN_DASHED)",
            tagIcons::arrow_bar_to_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_LEFT)",
            tagIcons::arrow_bar_to_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-left-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_LEFT_DASHED)",
            tagIcons::arrow_bar_to_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_RIGHT)",
            tagIcons::arrow_bar_to_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-right-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_RIGHT_DASHED)",
            tagIcons::arrow_bar_to_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_UP)",
            tagIcons::arrow_bar_to_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-up-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_TO_UP_DASHED)",
            tagIcons::arrow_bar_to_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BAR_UP)",
            tagIcons::arrow_bar_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_LEFT)",
            tagIcons::arrow_bear_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-left-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_LEFT_2)",
            tagIcons::arrow_bear_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_RIGHT)",
            tagIcons::arrow_bear_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-right-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BEAR_RIGHT_2)",
            tagIcons::arrow_bear_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN)",
            tagIcons::arrow_big_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-line (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN_LINE)",
            tagIcons::arrow_big_down_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-lines (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_DOWN_LINES)",
            tagIcons::arrow_big_down_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT)",
            tagIcons::arrow_big_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-line (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT_LINE)",
            tagIcons::arrow_big_left_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-lines (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_LEFT_LINES)",
            tagIcons::arrow_big_left_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT)",
            tagIcons::arrow_big_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-line (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT_LINE)",
            tagIcons::arrow_big_right_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-lines (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_RIGHT_LINES)",
            tagIcons::arrow_big_right_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP)",
            tagIcons::arrow_big_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-line (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP_LINE)",
            tagIcons::arrow_big_up_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-lines (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BIG_UP_LINES)",
            tagIcons::arrow_big_up_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bounce (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BOUNCE)",
            tagIcons::arrow_bounce));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-capsule (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CAPSULE)",
            tagIcons::arrow_capsule));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-curve-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CURVE_LEFT)",
            tagIcons::arrow_curve_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-curve-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_CURVE_RIGHT)",
            tagIcons::arrow_curve_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN)",
            tagIcons::arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-bar (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_BAR)",
            tagIcons::arrow_down_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_CIRCLE)",
            tagIcons::arrow_down_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_DASHED)",
            tagIcons::arrow_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-from-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_FROM_ARC)",
            tagIcons::arrow_down_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_LEFT)",
            tagIcons::arrow_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-left-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_LEFT_CIRCLE)",
            tagIcons::arrow_down_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-rhombus (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RHOMBUS)",
            tagIcons::arrow_down_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RIGHT)",
            tagIcons::arrow_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-right-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_RIGHT_CIRCLE)",
            tagIcons::arrow_down_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-square (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_SQUARE)",
            tagIcons::arrow_down_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-tail (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_TAIL)",
            tagIcons::arrow_down_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-to-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_DOWN_TO_ARC)",
            tagIcons::arrow_down_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-elbow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ELBOW_LEFT)",
            tagIcons::arrow_elbow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-elbow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ELBOW_RIGHT)",
            tagIcons::arrow_elbow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-fork (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORK)",
            tagIcons::arrow_fork));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-fork-triple (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORK_TRIPLE)",
            tagIcons::arrow_fork_triple));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD)",
            tagIcons::arrow_forward));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD_UP)",
            tagIcons::arrow_forward_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward-up-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_FORWARD_UP_DOUBLE)",
            tagIcons::arrow_forward_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-guide (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_GUIDE)",
            tagIcons::arrow_guide));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-iteration (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ITERATION)",
            tagIcons::arrow_iteration));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT)",
            tagIcons::arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-bar (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_BAR)",
            tagIcons::arrow_left_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_CIRCLE)",
            tagIcons::arrow_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_DASHED)",
            tagIcons::arrow_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-from-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_FROM_ARC)",
            tagIcons::arrow_left_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-rhombus (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_RHOMBUS)",
            tagIcons::arrow_left_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_RIGHT)",
            tagIcons::arrow_left_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-square (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_SQUARE)",
            tagIcons::arrow_left_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-tail (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_TAIL)",
            tagIcons::arrow_left_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-to-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LEFT_TO_ARC)",
            tagIcons::arrow_left_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_LEFT)",
            tagIcons::arrow_loop_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-left-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_LEFT_2)",
            tagIcons::arrow_loop_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_RIGHT)",
            tagIcons::arrow_loop_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-right-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_LOOP_RIGHT_2)",
            tagIcons::arrow_loop_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE)",
            tagIcons::arrow_merge));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-alt-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_ALT_LEFT)",
            tagIcons::arrow_merge_alt_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-alt-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_ALT_RIGHT)",
            tagIcons::arrow_merge_alt_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-both (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_BOTH)",
            tagIcons::arrow_merge_both));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_LEFT)",
            tagIcons::arrow_merge_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MERGE_RIGHT)",
            tagIcons::arrow_merge_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_DOWN)",
            tagIcons::arrow_move_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_LEFT)",
            tagIcons::arrow_move_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_RIGHT)",
            tagIcons::arrow_move_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_MOVE_UP)",
            tagIcons::arrow_move_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_DOWN)",
            tagIcons::arrow_narrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-down-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_DOWN_DASHED)",
            tagIcons::arrow_narrow_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_LEFT)",
            tagIcons::arrow_narrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-left-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_LEFT_DASHED)",
            tagIcons::arrow_narrow_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_RIGHT)",
            tagIcons::arrow_narrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-right-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_RIGHT_DASHED)",
            tagIcons::arrow_narrow_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_UP)",
            tagIcons::arrow_narrow_up));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-up-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_NARROW_UP_DASHED)",
            tagIcons::arrow_narrow_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT)",
            tagIcons::arrow_ramp_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT_2)",
            tagIcons::arrow_ramp_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_LEFT_3)",
            tagIcons::arrow_ramp_left_3));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT)",
            tagIcons::arrow_ramp_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT_2)",
            tagIcons::arrow_ramp_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RAMP_RIGHT_3)",
            tagIcons::arrow_ramp_right_3));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT)",
            tagIcons::arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-bar (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_BAR)",
            tagIcons::arrow_right_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_CIRCLE)",
            tagIcons::arrow_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_DASHED)",
            tagIcons::arrow_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-from-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_FROM_ARC)",
            tagIcons::arrow_right_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-rhombus (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_RHOMBUS)",
            tagIcons::arrow_right_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-square (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_SQUARE)",
            tagIcons::arrow_right_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-tail (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_TAIL)",
            tagIcons::arrow_right_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-to-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_RIGHT_TO_ARC)",
            tagIcons::arrow_right_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-first-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_FIRST_LEFT)",
            tagIcons::arrow_rotary_first_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-first-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_FIRST_RIGHT)",
            tagIcons::arrow_rotary_first_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-last-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LAST_LEFT)",
            tagIcons::arrow_rotary_last_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-last-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LAST_RIGHT)",
            tagIcons::arrow_rotary_last_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_LEFT)",
            tagIcons::arrow_rotary_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_RIGHT)",
            tagIcons::arrow_rotary_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-straight (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROTARY_STRAIGHT)",
            tagIcons::arrow_rotary_straight));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-roundabout-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROUNDABOUT_LEFT)",
            tagIcons::arrow_roundabout_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-roundabout-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ROUNDABOUT_RIGHT)",
            tagIcons::arrow_roundabout_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-sharp-turn-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_SHARP_TURN_LEFT)",
            tagIcons::arrow_sharp_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-sharp-turn-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_SHARP_TURN_RIGHT)",
            tagIcons::arrow_sharp_turn_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP)",
            tagIcons::arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-bar (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_BAR)",
            tagIcons::arrow_up_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_CIRCLE)",
            tagIcons::arrow_up_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-dashed (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_DASHED)",
            tagIcons::arrow_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-from-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_FROM_ARC)",
            tagIcons::arrow_up_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_LEFT)",
            tagIcons::arrow_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-left-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_LEFT_CIRCLE)",
            tagIcons::arrow_up_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-rhombus (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RHOMBUS)",
            tagIcons::arrow_up_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RIGHT)",
            tagIcons::arrow_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-right-circle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_RIGHT_CIRCLE)",
            tagIcons::arrow_up_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-square (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_SQUARE)",
            tagIcons::arrow_up_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-tail (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_TAIL)",
            tagIcons::arrow_up_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-to-arc (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP_TO_ARC)",
            tagIcons::arrow_up_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-left-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_LEFT_DOWN)",
            tagIcons::arrow_wave_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-left-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_LEFT_UP)",
            tagIcons::arrow_wave_left_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-right-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_RIGHT_DOWN)",
            tagIcons::arrow_wave_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-right-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_WAVE_RIGHT_UP)",
            tagIcons::arrow_wave_right_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-zig-zag (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_ZIG_ZAG)",
            tagIcons::arrow_zig_zag));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-cross (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_CROSS)",
            tagIcons::arrows_cross));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL)",
            tagIcons::arrows_diagonal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_2)",
            tagIcons::arrows_diagonal_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-minimize (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_MINIMIZE)",
            tagIcons::arrows_diagonal_minimize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-minimize-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIAGONAL_MINIMIZE_2)",
            tagIcons::arrows_diagonal_minimize_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diff (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DIFF)",
            tagIcons::arrows_diff));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-ne-sw (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_NE_SW)",
            tagIcons::arrows_double_ne_sw));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-nw-se (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_NW_SE)",
            tagIcons::arrows_double_nw_se));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-se-nw (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_SE_NW)",
            tagIcons::arrows_double_se_nw));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-sw-ne (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOUBLE_SW_NE)",
            tagIcons::arrows_double_sw_ne));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOWN)",
            tagIcons::arrows_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-down-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_DOWN_UP)",
            tagIcons::arrows_down_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-exchange (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_EXCHANGE)",
            tagIcons::arrows_exchange));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-exchange-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_EXCHANGE_2)",
            tagIcons::arrows_exchange_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-horizontal (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_HORIZONTAL)",
            tagIcons::arrows_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-join (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_JOIN)",
            tagIcons::arrows_join));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-join-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_JOIN_2)",
            tagIcons::arrows_join_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT)",
            tagIcons::arrows_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT_DOWN)",
            tagIcons::arrows_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_LEFT_RIGHT)",
            tagIcons::arrows_left_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-maximize (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MAXIMIZE)",
            tagIcons::arrows_maximize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-minimize (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MINIMIZE)",
            tagIcons::arrows_minimize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE)",
            tagIcons::arrows_move));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move-horizontal (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE_HORIZONTAL)",
            tagIcons::arrows_move_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move-vertical (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MOVE_VERTICAL)",
            tagIcons::arrows_move_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-random (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RANDOM)",
            tagIcons::arrows_random));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT)",
            tagIcons::arrows_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT_DOWN)",
            tagIcons::arrows_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_RIGHT_LEFT)",
            tagIcons::arrows_right_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-shuffle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SHUFFLE)",
            tagIcons::arrows_shuffle));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-shuffle-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SHUFFLE_2)",
            tagIcons::arrows_shuffle_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-sort (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SORT)",
            tagIcons::arrows_sort));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-split (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SPLIT)",
            tagIcons::arrows_split));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-split-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_SPLIT_2)",
            tagIcons::arrows_split_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_DOWN)",
            tagIcons::arrows_transfer_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_UP)",
            tagIcons::arrows_transfer_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-up-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_TRANSFER_UP_DOWN)",
            tagIcons::arrows_transfer_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP)",
            tagIcons::arrows_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_DOWN)",
            tagIcons::arrows_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_LEFT)",
            tagIcons::arrows_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_UP_RIGHT)",
            tagIcons::arrows_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-vertical (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_VERTICAL)",
            tagIcons::arrows_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "axis-x (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.AXIS_X)",
            tagIcons::axis_x));
    icons.add(
        new IconCatalogEntry<>(
            "axis-y (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.AXIS_Y)",
            tagIcons::axis_y));
    icons.add(
        new IconCatalogEntry<>(
            "caret-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CARET_DOWN)",
            tagIcons::caret_down));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CARET_LEFT)",
            tagIcons::caret_left));
    icons.add(
        new IconCatalogEntry<>(
            "caret-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CARET_RIGHT)",
            tagIcons::caret_right));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CARET_UP)",
            tagIcons::caret_up));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CARET_UP_DOWN)",
            tagIcons::caret_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_DOWN)",
            tagIcons::chevron_compact_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_LEFT)",
            tagIcons::chevron_compact_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_RIGHT)",
            tagIcons::chevron_compact_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_COMPACT_UP)",
            tagIcons::chevron_compact_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN)",
            tagIcons::chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN_LEFT)",
            tagIcons::chevron_down_left));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN_RIGHT)",
            tagIcons::chevron_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT)",
            tagIcons::chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-left-pipe (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT_PIPE)",
            tagIcons::chevron_left_pipe));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT)",
            tagIcons::chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right-pipe (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT_PIPE)",
            tagIcons::chevron_right_pipe));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP)",
            tagIcons::chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP_LEFT)",
            tagIcons::chevron_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_UP_RIGHT)",
            tagIcons::chevron_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN)",
            tagIcons::chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN_LEFT)",
            tagIcons::chevrons_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_DOWN_RIGHT)",
            tagIcons::chevrons_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_LEFT)",
            tagIcons::chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_RIGHT)",
            tagIcons::chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP)",
            tagIcons::chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP_LEFT)",
            tagIcons::chevrons_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRONS_UP_RIGHT)",
            tagIcons::chevrons_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN)",
            tagIcons::circle_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN_LEFT)",
            tagIcons::circle_arrow_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_DOWN_RIGHT)",
            tagIcons::circle_arrow_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_LEFT)",
            tagIcons::circle_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_RIGHT)",
            tagIcons::circle_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP)",
            tagIcons::circle_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP_LEFT)",
            tagIcons::circle_arrow_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_ARROW_UP_RIGHT)",
            tagIcons::circle_arrow_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_DOWN)",
            tagIcons::circle_caret_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_LEFT)",
            tagIcons::circle_caret_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_RIGHT)",
            tagIcons::circle_caret_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CARET_UP)",
            tagIcons::circle_caret_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_DOWN)",
            tagIcons::circle_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_LEFT)",
            tagIcons::circle_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_RIGHT)",
            tagIcons::circle_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRON_UP)",
            tagIcons::circle_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_DOWN)",
            tagIcons::circle_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_LEFT)",
            tagIcons::circle_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_RIGHT)",
            tagIcons::circle_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_CHEVRONS_UP)",
            tagIcons::circle_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_DOWN)",
            tagIcons::circle_open_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_LEFT)",
            tagIcons::circle_open_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_RIGHT)",
            tagIcons::circle_open_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CIRCLE_OPEN_ARROW_UP)",
            tagIcons::circle_open_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_LEFT)",
            tagIcons::corner_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-left-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_LEFT_DOUBLE)",
            tagIcons::corner_down_left_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_RIGHT)",
            tagIcons::corner_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-right-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_DOWN_RIGHT_DOUBLE)",
            tagIcons::corner_down_right_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_DOWN)",
            tagIcons::corner_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-down-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_DOWN_DOUBLE)",
            tagIcons::corner_left_down_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_UP)",
            tagIcons::corner_left_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-up-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_LEFT_UP_DOUBLE)",
            tagIcons::corner_left_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_DOWN)",
            tagIcons::corner_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-down-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_DOWN_DOUBLE)",
            tagIcons::corner_right_down_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_UP)",
            tagIcons::corner_right_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-up-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_RIGHT_UP_DOUBLE)",
            tagIcons::corner_right_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_LEFT)",
            tagIcons::corner_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-left-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_LEFT_DOUBLE)",
            tagIcons::corner_up_left_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_RIGHT)",
            tagIcons::corner_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-right-double (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CORNER_UP_RIGHT_DOUBLE)",
            tagIcons::corner_up_right_double));
    icons.add(
        new IconCatalogEntry<>(
            "download (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.DOWNLOAD)",
            tagIcons::download));
    icons.add(
        new IconCatalogEntry<>(
            "download-off (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.DOWNLOAD_OFF)",
            tagIcons::download_off));
    icons.add(
        new IconCatalogEntry<>(
            "fold (outline)", "TablerIcon.create(TablerArrows.OutlineIcon.FOLD)", tagIcons::fold));
    icons.add(
        new IconCatalogEntry<>(
            "fold-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.FOLD_DOWN)",
            tagIcons::fold_down));
    icons.add(
        new IconCatalogEntry<>(
            "fold-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.FOLD_UP)",
            tagIcons::fold_up));
    icons.add(
        new IconCatalogEntry<>(
            "login (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.LOGIN)",
            tagIcons::login));
    icons.add(
        new IconCatalogEntry<>(
            "login-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.LOGIN_2)",
            tagIcons::login_2));
    icons.add(
        new IconCatalogEntry<>(
            "refresh (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.REFRESH)",
            tagIcons::refresh));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-alert (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_ALERT)",
            tagIcons::refresh_alert));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-dot (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_DOT)",
            tagIcons::refresh_dot));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-off (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.REFRESH_OFF)",
            tagIcons::refresh_off));
    icons.add(
        new IconCatalogEntry<>(
            "reload (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.RELOAD)",
            tagIcons::reload));
    icons.add(
        new IconCatalogEntry<>(
            "ripple-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.RIPPLE_DOWN)",
            tagIcons::ripple_down));
    icons.add(
        new IconCatalogEntry<>(
            "ripple-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.RIPPLE_UP)",
            tagIcons::ripple_up));
    icons.add(
        new IconCatalogEntry<>(
            "rotate (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE)",
            tagIcons::rotate));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_2)",
            tagIcons::rotate_2));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-360 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_360)",
            tagIcons::rotate_360));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-clockwise (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_CLOCKWISE)",
            tagIcons::rotate_clockwise));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-clockwise-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_CLOCKWISE_2)",
            tagIcons::rotate_clockwise_2));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-dot (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_DOT)",
            tagIcons::rotate_dot));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-rectangle (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ROTATE_RECTANGLE)",
            tagIcons::rotate_rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_DOWN)",
            tagIcons::s_turn_down));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_LEFT)",
            tagIcons::s_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_RIGHT)",
            tagIcons::s_turn_right));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.S_TURN_UP)",
            tagIcons::s_turn_up));
    icons.add(
        new IconCatalogEntry<>(
            "select (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SELECT)",
            tagIcons::select));
    icons.add(
        new IconCatalogEntry<>(
            "selector (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SELECTOR)",
            tagIcons::selector));
    icons.add(
        new IconCatalogEntry<>(
            "share-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SHARE_2)",
            tagIcons::share_2));
    icons.add(
        new IconCatalogEntry<>(
            "share-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SHARE_3)",
            tagIcons::share_3));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_DOWN)",
            tagIcons::square_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_LEFT)",
            tagIcons::square_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_RIGHT)",
            tagIcons::square_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ARROW_UP)",
            tagIcons::square_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_DOWN)",
            tagIcons::square_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_LEFT)",
            tagIcons::square_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_RIGHT)",
            tagIcons::square_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRON_UP)",
            tagIcons::square_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_DOWN)",
            tagIcons::square_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_LEFT)",
            tagIcons::square_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_RIGHT)",
            tagIcons::square_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_CHEVRONS_UP)",
            tagIcons::square_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_DOWN)",
            tagIcons::square_rounded_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_LEFT)",
            tagIcons::square_rounded_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_RIGHT)",
            tagIcons::square_rounded_arrow_right));
  }

  private static void addIcons3() {
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_ARROW_UP)",
            tagIcons::square_rounded_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_DOWN)",
            tagIcons::square_rounded_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_LEFT)",
            tagIcons::square_rounded_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_RIGHT)",
            tagIcons::square_rounded_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRON_UP)",
            tagIcons::square_rounded_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_DOWN)",
            tagIcons::square_rounded_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_LEFT)",
            tagIcons::square_rounded_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_RIGHT)",
            tagIcons::square_rounded_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SQUARE_ROUNDED_CHEVRONS_UP)",
            tagIcons::square_rounded_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "step-into (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.STEP_INTO)",
            tagIcons::step_into));
    icons.add(
        new IconCatalogEntry<>(
            "step-out (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.STEP_OUT)",
            tagIcons::step_out));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_DOWN)",
            tagIcons::swipe_down));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_LEFT)",
            tagIcons::swipe_left));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_RIGHT)",
            tagIcons::swipe_right));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWIPE_UP)",
            tagIcons::swipe_up));
    icons.add(
        new IconCatalogEntry<>(
            "switch-icon (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWITCH)",
            tagIcons::switch_icon));
    icons.add(
        new IconCatalogEntry<>(
            "switch-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_2)",
            tagIcons::switch_2));
    icons.add(
        new IconCatalogEntry<>(
            "switch-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_3)",
            tagIcons::switch_3));
    icons.add(
        new IconCatalogEntry<>(
            "switch-horizontal (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_HORIZONTAL)",
            tagIcons::switch_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "switch-vertical (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.SWITCH_VERTICAL)",
            tagIcons::switch_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "transition-bottom (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_BOTTOM)",
            tagIcons::transition_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "transition-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_LEFT)",
            tagIcons::transition_left));
    icons.add(
        new IconCatalogEntry<>(
            "transition-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_RIGHT)",
            tagIcons::transition_right));
    icons.add(
        new IconCatalogEntry<>(
            "transition-top (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRANSITION_TOP)",
            tagIcons::transition_top));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN)",
            tagIcons::trending_down));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN_2)",
            tagIcons::trending_down_2));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_DOWN_3)",
            tagIcons::trending_down_3));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP)",
            tagIcons::trending_up));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up-2 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP_2)",
            tagIcons::trending_up_2));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up-3 (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.TRENDING_UP_3)",
            tagIcons::trending_up_3));
    icons.add(
        new IconCatalogEntry<>(
            "u-turn-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.U_TURN_LEFT)",
            tagIcons::u_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "u-turn-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.U_TURN_RIGHT)",
            tagIcons::u_turn_right));
    icons.add(
        new IconCatalogEntry<>(
            "upload (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.UPLOAD)",
            tagIcons::upload));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-upward (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_UP)",
            tagIcons::arrow_upward));
    icons.add(
        new IconCatalogEntry<>(
            "fullscreen (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MAXIMIZE)",
            tagIcons::fullscreen));
    icons.add(
        new IconCatalogEntry<>(
            "fullscreen-exit (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROWS_MINIMIZE)",
            tagIcons::fullscreen_exit));
    icons.add(
        new IconCatalogEntry<>(
            "menu-down (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_DOWN)",
            tagIcons::menu_down));
    icons.add(
        new IconCatalogEntry<>(
            "menu-left (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_LEFT)",
            tagIcons::menu_left));
    icons.add(
        new IconCatalogEntry<>(
            "menu-right (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.CHEVRON_RIGHT)",
            tagIcons::menu_right));
    icons.add(
        new IconCatalogEntry<>(
            "undo (outline)",
            "TablerIcon.create(TablerArrows.OutlineIcon.ARROW_BACK_UP)",
            tagIcons::undo));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-content (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_CONTENT)",
            tagIcons::arrow_autofit_content_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_DOWN)",
            tagIcons::arrow_autofit_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-height (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_HEIGHT)",
            tagIcons::arrow_autofit_height_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_LEFT)",
            tagIcons::arrow_autofit_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_RIGHT)",
            tagIcons::arrow_autofit_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_UP)",
            tagIcons::arrow_autofit_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-width (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_AUTOFIT_WIDTH)",
            tagIcons::arrow_autofit_width_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_DOWN)",
            tagIcons::arrow_badge_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_LEFT)",
            tagIcons::arrow_badge_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_RIGHT)",
            tagIcons::arrow_badge_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BADGE_UP)",
            tagIcons::arrow_badge_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN)",
            tagIcons::arrow_big_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-line (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN_LINE)",
            tagIcons::arrow_big_down_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-lines (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_DOWN_LINES)",
            tagIcons::arrow_big_down_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT)",
            tagIcons::arrow_big_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-line (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT_LINE)",
            tagIcons::arrow_big_left_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-lines (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_LEFT_LINES)",
            tagIcons::arrow_big_left_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT)",
            tagIcons::arrow_big_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-line (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT_LINE)",
            tagIcons::arrow_big_right_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-lines (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_RIGHT_LINES)",
            tagIcons::arrow_big_right_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP)",
            tagIcons::arrow_big_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-line (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP_LINE)",
            tagIcons::arrow_big_up_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-lines (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_BIG_UP_LINES)",
            tagIcons::arrow_big_up_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-circle (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_CIRCLE)",
            tagIcons::arrow_down_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-rhombus (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_RHOMBUS)",
            tagIcons::arrow_down_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-square (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_DOWN_SQUARE)",
            tagIcons::arrow_down_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-guide (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_GUIDE)",
            tagIcons::arrow_guide_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-circle (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_CIRCLE)",
            tagIcons::arrow_left_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-rhombus (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_RHOMBUS)",
            tagIcons::arrow_left_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-square (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_LEFT_SQUARE)",
            tagIcons::arrow_left_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_DOWN)",
            tagIcons::arrow_move_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_LEFT)",
            tagIcons::arrow_move_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_RIGHT)",
            tagIcons::arrow_move_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_MOVE_UP)",
            tagIcons::arrow_move_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-circle (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_CIRCLE)",
            tagIcons::arrow_right_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-rhombus (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_RHOMBUS)",
            tagIcons::arrow_right_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-square (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_RIGHT_SQUARE)",
            tagIcons::arrow_right_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-circle (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_CIRCLE)",
            tagIcons::arrow_up_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-rhombus (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_RHOMBUS)",
            tagIcons::arrow_up_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-square (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.ARROW_UP_SQUARE)",
            tagIcons::arrow_up_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CARET_DOWN)",
            tagIcons::caret_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CARET_LEFT)",
            tagIcons::caret_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CARET_RIGHT)",
            tagIcons::caret_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CARET_UP)",
            tagIcons::caret_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CARET_UP_DOWN)",
            tagIcons::caret_up_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CHEVRON_DOWN)",
            tagIcons::chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CHEVRON_RIGHT)",
            tagIcons::chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN)",
            tagIcons::circle_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN_LEFT)",
            tagIcons::circle_arrow_down_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_DOWN_RIGHT)",
            tagIcons::circle_arrow_down_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_LEFT)",
            tagIcons::circle_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_RIGHT)",
            tagIcons::circle_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP)",
            tagIcons::circle_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP_LEFT)",
            tagIcons::circle_arrow_up_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_ARROW_UP_RIGHT)",
            tagIcons::circle_arrow_up_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_DOWN)",
            tagIcons::circle_caret_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_LEFT)",
            tagIcons::circle_caret_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_RIGHT)",
            tagIcons::circle_caret_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CARET_UP)",
            tagIcons::circle_caret_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_DOWN)",
            tagIcons::circle_chevron_down_filled));
  }

  private static void addIcons4() {
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_LEFT)",
            tagIcons::circle_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_RIGHT)",
            tagIcons::circle_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRON_UP)",
            tagIcons::circle_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_DOWN)",
            tagIcons::circle_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_LEFT)",
            tagIcons::circle_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_RIGHT)",
            tagIcons::circle_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.CIRCLE_CHEVRONS_UP)",
            tagIcons::circle_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "download (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.DOWNLOAD)",
            tagIcons::download_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_DOWN)",
            tagIcons::square_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_LEFT)",
            tagIcons::square_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_RIGHT)",
            tagIcons::square_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ARROW_UP)",
            tagIcons::square_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_DOWN)",
            tagIcons::square_chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_LEFT)",
            tagIcons::square_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_RIGHT)",
            tagIcons::square_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRON_UP)",
            tagIcons::square_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_DOWN)",
            tagIcons::square_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_LEFT)",
            tagIcons::square_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_RIGHT)",
            tagIcons::square_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_CHEVRONS_UP)",
            tagIcons::square_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_DOWN)",
            tagIcons::square_rounded_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_LEFT)",
            tagIcons::square_rounded_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_RIGHT)",
            tagIcons::square_rounded_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_ARROW_UP)",
            tagIcons::square_rounded_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_DOWN)",
            tagIcons::square_rounded_chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_LEFT)",
            tagIcons::square_rounded_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_RIGHT)",
            tagIcons::square_rounded_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRON_UP)",
            tagIcons::square_rounded_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_DOWN)",
            tagIcons::square_rounded_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_LEFT)",
            tagIcons::square_rounded_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_RIGHT)",
            tagIcons::square_rounded_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SQUARE_ROUNDED_CHEVRONS_UP)",
            tagIcons::square_rounded_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-down (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SWIPE_DOWN)",
            tagIcons::swipe_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SWIPE_LEFT)",
            tagIcons::swipe_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SWIPE_RIGHT)",
            tagIcons::swipe_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-up (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.SWIPE_UP)",
            tagIcons::swipe_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-bottom (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_BOTTOM)",
            tagIcons::transition_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-left (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_LEFT)",
            tagIcons::transition_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-right (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_RIGHT)",
            tagIcons::transition_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-top (filled)",
            "TablerIcon.create(TablerArrows.FilledIcon.TRANSITION_TOP)",
            tagIcons::transition_top_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
