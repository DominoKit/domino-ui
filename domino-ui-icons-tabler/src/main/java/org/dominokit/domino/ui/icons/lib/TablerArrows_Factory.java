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
            "arrow-autofit-content",
            "TablerIcons.arrow_autofit_content()",
            tagIcons::arrow_autofit_content));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-down",
            "TablerIcons.arrow_autofit_down()",
            tagIcons::arrow_autofit_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-height",
            "TablerIcons.arrow_autofit_height()",
            tagIcons::arrow_autofit_height));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-left",
            "TablerIcons.arrow_autofit_left()",
            tagIcons::arrow_autofit_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-right",
            "TablerIcons.arrow_autofit_right()",
            tagIcons::arrow_autofit_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-up",
            "TablerIcons.arrow_autofit_up()",
            tagIcons::arrow_autofit_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-width",
            "TablerIcons.arrow_autofit_width()",
            tagIcons::arrow_autofit_width));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back", "TablerIcons.arrow_back()", tagIcons::arrow_back));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back-up", "TablerIcons.arrow_back_up()", tagIcons::arrow_back_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-back-up-double",
            "TablerIcons.arrow_back_up_double()",
            tagIcons::arrow_back_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-down",
            "TablerIcons.arrow_badge_down()",
            tagIcons::arrow_badge_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-left",
            "TablerIcons.arrow_badge_left()",
            tagIcons::arrow_badge_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-right",
            "TablerIcons.arrow_badge_right()",
            tagIcons::arrow_badge_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-up", "TablerIcons.arrow_badge_up()", tagIcons::arrow_badge_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-both", "TablerIcons.arrow_bar_both()", tagIcons::arrow_bar_both));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-down", "TablerIcons.arrow_bar_down()", tagIcons::arrow_bar_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-left", "TablerIcons.arrow_bar_left()", tagIcons::arrow_bar_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-right",
            "TablerIcons.arrow_bar_right()",
            tagIcons::arrow_bar_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-down",
            "TablerIcons.arrow_bar_to_down()",
            tagIcons::arrow_bar_to_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-down-dashed",
            "TablerIcons.arrow_bar_to_down_dashed()",
            tagIcons::arrow_bar_to_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-left",
            "TablerIcons.arrow_bar_to_left()",
            tagIcons::arrow_bar_to_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-left-dashed",
            "TablerIcons.arrow_bar_to_left_dashed()",
            tagIcons::arrow_bar_to_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-right",
            "TablerIcons.arrow_bar_to_right()",
            tagIcons::arrow_bar_to_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-right-dashed",
            "TablerIcons.arrow_bar_to_right_dashed()",
            tagIcons::arrow_bar_to_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-up",
            "TablerIcons.arrow_bar_to_up()",
            tagIcons::arrow_bar_to_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-to-up-dashed",
            "TablerIcons.arrow_bar_to_up_dashed()",
            tagIcons::arrow_bar_to_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bar-up", "TablerIcons.arrow_bar_up()", tagIcons::arrow_bar_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-left",
            "TablerIcons.arrow_bear_left()",
            tagIcons::arrow_bear_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-left-2",
            "TablerIcons.arrow_bear_left_2()",
            tagIcons::arrow_bear_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-right",
            "TablerIcons.arrow_bear_right()",
            tagIcons::arrow_bear_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bear-right-2",
            "TablerIcons.arrow_bear_right_2()",
            tagIcons::arrow_bear_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down", "TablerIcons.arrow_big_down()", tagIcons::arrow_big_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-line",
            "TablerIcons.arrow_big_down_line()",
            tagIcons::arrow_big_down_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-lines",
            "TablerIcons.arrow_big_down_lines()",
            tagIcons::arrow_big_down_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left", "TablerIcons.arrow_big_left()", tagIcons::arrow_big_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-line",
            "TablerIcons.arrow_big_left_line()",
            tagIcons::arrow_big_left_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-lines",
            "TablerIcons.arrow_big_left_lines()",
            tagIcons::arrow_big_left_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right",
            "TablerIcons.arrow_big_right()",
            tagIcons::arrow_big_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-line",
            "TablerIcons.arrow_big_right_line()",
            tagIcons::arrow_big_right_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-lines",
            "TablerIcons.arrow_big_right_lines()",
            tagIcons::arrow_big_right_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up", "TablerIcons.arrow_big_up()", tagIcons::arrow_big_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-line",
            "TablerIcons.arrow_big_up_line()",
            tagIcons::arrow_big_up_line));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-lines",
            "TablerIcons.arrow_big_up_lines()",
            tagIcons::arrow_big_up_lines));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-bounce", "TablerIcons.arrow_bounce()", tagIcons::arrow_bounce));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-capsule", "TablerIcons.arrow_capsule()", tagIcons::arrow_capsule));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-curve-left",
            "TablerIcons.arrow_curve_left()",
            tagIcons::arrow_curve_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-curve-right",
            "TablerIcons.arrow_curve_right()",
            tagIcons::arrow_curve_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down", "TablerIcons.arrow_down()", tagIcons::arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-bar", "TablerIcons.arrow_down_bar()", tagIcons::arrow_down_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-circle",
            "TablerIcons.arrow_down_circle()",
            tagIcons::arrow_down_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-dashed",
            "TablerIcons.arrow_down_dashed()",
            tagIcons::arrow_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-from-arc",
            "TablerIcons.arrow_down_from_arc()",
            tagIcons::arrow_down_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-left",
            "TablerIcons.arrow_down_left()",
            tagIcons::arrow_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-left-circle",
            "TablerIcons.arrow_down_left_circle()",
            tagIcons::arrow_down_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-rhombus",
            "TablerIcons.arrow_down_rhombus()",
            tagIcons::arrow_down_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-right",
            "TablerIcons.arrow_down_right()",
            tagIcons::arrow_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-right-circle",
            "TablerIcons.arrow_down_right_circle()",
            tagIcons::arrow_down_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-square",
            "TablerIcons.arrow_down_square()",
            tagIcons::arrow_down_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-tail",
            "TablerIcons.arrow_down_tail()",
            tagIcons::arrow_down_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-to-arc",
            "TablerIcons.arrow_down_to_arc()",
            tagIcons::arrow_down_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-elbow-left",
            "TablerIcons.arrow_elbow_left()",
            tagIcons::arrow_elbow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-elbow-right",
            "TablerIcons.arrow_elbow_right()",
            tagIcons::arrow_elbow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-fork", "TablerIcons.arrow_fork()", tagIcons::arrow_fork));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-fork-triple",
            "TablerIcons.arrow_fork_triple()",
            tagIcons::arrow_fork_triple));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward", "TablerIcons.arrow_forward()", tagIcons::arrow_forward));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward-up",
            "TablerIcons.arrow_forward_up()",
            tagIcons::arrow_forward_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-forward-up-double",
            "TablerIcons.arrow_forward_up_double()",
            tagIcons::arrow_forward_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-guide", "TablerIcons.arrow_guide()", tagIcons::arrow_guide));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-iteration",
            "TablerIcons.arrow_iteration()",
            tagIcons::arrow_iteration));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left", "TablerIcons.arrow_left()", tagIcons::arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-bar", "TablerIcons.arrow_left_bar()", tagIcons::arrow_left_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-circle",
            "TablerIcons.arrow_left_circle()",
            tagIcons::arrow_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-dashed",
            "TablerIcons.arrow_left_dashed()",
            tagIcons::arrow_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-from-arc",
            "TablerIcons.arrow_left_from_arc()",
            tagIcons::arrow_left_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-rhombus",
            "TablerIcons.arrow_left_rhombus()",
            tagIcons::arrow_left_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-right",
            "TablerIcons.arrow_left_right()",
            tagIcons::arrow_left_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-square",
            "TablerIcons.arrow_left_square()",
            tagIcons::arrow_left_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-tail",
            "TablerIcons.arrow_left_tail()",
            tagIcons::arrow_left_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-to-arc",
            "TablerIcons.arrow_left_to_arc()",
            tagIcons::arrow_left_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-left",
            "TablerIcons.arrow_loop_left()",
            tagIcons::arrow_loop_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-left-2",
            "TablerIcons.arrow_loop_left_2()",
            tagIcons::arrow_loop_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-right",
            "TablerIcons.arrow_loop_right()",
            tagIcons::arrow_loop_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-loop-right-2",
            "TablerIcons.arrow_loop_right_2()",
            tagIcons::arrow_loop_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge", "TablerIcons.arrow_merge()", tagIcons::arrow_merge));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-alt-left",
            "TablerIcons.arrow_merge_alt_left()",
            tagIcons::arrow_merge_alt_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-alt-right",
            "TablerIcons.arrow_merge_alt_right()",
            tagIcons::arrow_merge_alt_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-both",
            "TablerIcons.arrow_merge_both()",
            tagIcons::arrow_merge_both));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-left",
            "TablerIcons.arrow_merge_left()",
            tagIcons::arrow_merge_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-merge-right",
            "TablerIcons.arrow_merge_right()",
            tagIcons::arrow_merge_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-down",
            "TablerIcons.arrow_move_down()",
            tagIcons::arrow_move_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-left",
            "TablerIcons.arrow_move_left()",
            tagIcons::arrow_move_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-right",
            "TablerIcons.arrow_move_right()",
            tagIcons::arrow_move_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-up", "TablerIcons.arrow_move_up()", tagIcons::arrow_move_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-down",
            "TablerIcons.arrow_narrow_down()",
            tagIcons::arrow_narrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-down-dashed",
            "TablerIcons.arrow_narrow_down_dashed()",
            tagIcons::arrow_narrow_down_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-left",
            "TablerIcons.arrow_narrow_left()",
            tagIcons::arrow_narrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-left-dashed",
            "TablerIcons.arrow_narrow_left_dashed()",
            tagIcons::arrow_narrow_left_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-right",
            "TablerIcons.arrow_narrow_right()",
            tagIcons::arrow_narrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-right-dashed",
            "TablerIcons.arrow_narrow_right_dashed()",
            tagIcons::arrow_narrow_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-up",
            "TablerIcons.arrow_narrow_up()",
            tagIcons::arrow_narrow_up));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "arrow-narrow-up-dashed",
            "TablerIcons.arrow_narrow_up_dashed()",
            tagIcons::arrow_narrow_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left",
            "TablerIcons.arrow_ramp_left()",
            tagIcons::arrow_ramp_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left-2",
            "TablerIcons.arrow_ramp_left_2()",
            tagIcons::arrow_ramp_left_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-left-3",
            "TablerIcons.arrow_ramp_left_3()",
            tagIcons::arrow_ramp_left_3));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right",
            "TablerIcons.arrow_ramp_right()",
            tagIcons::arrow_ramp_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right-2",
            "TablerIcons.arrow_ramp_right_2()",
            tagIcons::arrow_ramp_right_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-ramp-right-3",
            "TablerIcons.arrow_ramp_right_3()",
            tagIcons::arrow_ramp_right_3));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right", "TablerIcons.arrow_right()", tagIcons::arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-bar",
            "TablerIcons.arrow_right_bar()",
            tagIcons::arrow_right_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-circle",
            "TablerIcons.arrow_right_circle()",
            tagIcons::arrow_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-dashed",
            "TablerIcons.arrow_right_dashed()",
            tagIcons::arrow_right_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-from-arc",
            "TablerIcons.arrow_right_from_arc()",
            tagIcons::arrow_right_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-rhombus",
            "TablerIcons.arrow_right_rhombus()",
            tagIcons::arrow_right_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-square",
            "TablerIcons.arrow_right_square()",
            tagIcons::arrow_right_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-tail",
            "TablerIcons.arrow_right_tail()",
            tagIcons::arrow_right_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-to-arc",
            "TablerIcons.arrow_right_to_arc()",
            tagIcons::arrow_right_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-first-left",
            "TablerIcons.arrow_rotary_first_left()",
            tagIcons::arrow_rotary_first_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-first-right",
            "TablerIcons.arrow_rotary_first_right()",
            tagIcons::arrow_rotary_first_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-last-left",
            "TablerIcons.arrow_rotary_last_left()",
            tagIcons::arrow_rotary_last_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-last-right",
            "TablerIcons.arrow_rotary_last_right()",
            tagIcons::arrow_rotary_last_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-left",
            "TablerIcons.arrow_rotary_left()",
            tagIcons::arrow_rotary_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-right",
            "TablerIcons.arrow_rotary_right()",
            tagIcons::arrow_rotary_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-rotary-straight",
            "TablerIcons.arrow_rotary_straight()",
            tagIcons::arrow_rotary_straight));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-roundabout-left",
            "TablerIcons.arrow_roundabout_left()",
            tagIcons::arrow_roundabout_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-roundabout-right",
            "TablerIcons.arrow_roundabout_right()",
            tagIcons::arrow_roundabout_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-sharp-turn-left",
            "TablerIcons.arrow_sharp_turn_left()",
            tagIcons::arrow_sharp_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-sharp-turn-right",
            "TablerIcons.arrow_sharp_turn_right()",
            tagIcons::arrow_sharp_turn_right));
    icons.add(
        new IconCatalogEntry<>("arrow-up", "TablerIcons.arrow_up()", tagIcons::arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-bar", "TablerIcons.arrow_up_bar()", tagIcons::arrow_up_bar));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-circle",
            "TablerIcons.arrow_up_circle()",
            tagIcons::arrow_up_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-dashed",
            "TablerIcons.arrow_up_dashed()",
            tagIcons::arrow_up_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-from-arc",
            "TablerIcons.arrow_up_from_arc()",
            tagIcons::arrow_up_from_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-left", "TablerIcons.arrow_up_left()", tagIcons::arrow_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-left-circle",
            "TablerIcons.arrow_up_left_circle()",
            tagIcons::arrow_up_left_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-rhombus",
            "TablerIcons.arrow_up_rhombus()",
            tagIcons::arrow_up_rhombus));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-right", "TablerIcons.arrow_up_right()", tagIcons::arrow_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-right-circle",
            "TablerIcons.arrow_up_right_circle()",
            tagIcons::arrow_up_right_circle));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-square",
            "TablerIcons.arrow_up_square()",
            tagIcons::arrow_up_square));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-tail", "TablerIcons.arrow_up_tail()", tagIcons::arrow_up_tail));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-to-arc",
            "TablerIcons.arrow_up_to_arc()",
            tagIcons::arrow_up_to_arc));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-left-down",
            "TablerIcons.arrow_wave_left_down()",
            tagIcons::arrow_wave_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-left-up",
            "TablerIcons.arrow_wave_left_up()",
            tagIcons::arrow_wave_left_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-right-down",
            "TablerIcons.arrow_wave_right_down()",
            tagIcons::arrow_wave_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-wave-right-up",
            "TablerIcons.arrow_wave_right_up()",
            tagIcons::arrow_wave_right_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-zig-zag", "TablerIcons.arrow_zig_zag()", tagIcons::arrow_zig_zag));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-cross", "TablerIcons.arrows_cross()", tagIcons::arrows_cross));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal",
            "TablerIcons.arrows_diagonal()",
            tagIcons::arrows_diagonal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-2",
            "TablerIcons.arrows_diagonal_2()",
            tagIcons::arrows_diagonal_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-minimize",
            "TablerIcons.arrows_diagonal_minimize()",
            tagIcons::arrows_diagonal_minimize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diagonal-minimize-2",
            "TablerIcons.arrows_diagonal_minimize_2()",
            tagIcons::arrows_diagonal_minimize_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-diff", "TablerIcons.arrows_diff()", tagIcons::arrows_diff));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-ne-sw",
            "TablerIcons.arrows_double_ne_sw()",
            tagIcons::arrows_double_ne_sw));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-nw-se",
            "TablerIcons.arrows_double_nw_se()",
            tagIcons::arrows_double_nw_se));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-se-nw",
            "TablerIcons.arrows_double_se_nw()",
            tagIcons::arrows_double_se_nw));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-double-sw-ne",
            "TablerIcons.arrows_double_sw_ne()",
            tagIcons::arrows_double_sw_ne));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-down", "TablerIcons.arrows_down()", tagIcons::arrows_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-down-up", "TablerIcons.arrows_down_up()", tagIcons::arrows_down_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-exchange",
            "TablerIcons.arrows_exchange()",
            tagIcons::arrows_exchange));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-exchange-2",
            "TablerIcons.arrows_exchange_2()",
            tagIcons::arrows_exchange_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-horizontal",
            "TablerIcons.arrows_horizontal()",
            tagIcons::arrows_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-join", "TablerIcons.arrows_join()", tagIcons::arrows_join));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-join-2", "TablerIcons.arrows_join_2()", tagIcons::arrows_join_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left", "TablerIcons.arrows_left()", tagIcons::arrows_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left-down",
            "TablerIcons.arrows_left_down()",
            tagIcons::arrows_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-left-right",
            "TablerIcons.arrows_left_right()",
            tagIcons::arrows_left_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-maximize",
            "TablerIcons.arrows_maximize()",
            tagIcons::arrows_maximize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-minimize",
            "TablerIcons.arrows_minimize()",
            tagIcons::arrows_minimize));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move", "TablerIcons.arrows_move()", tagIcons::arrows_move));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move-horizontal",
            "TablerIcons.arrows_move_horizontal()",
            tagIcons::arrows_move_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-move-vertical",
            "TablerIcons.arrows_move_vertical()",
            tagIcons::arrows_move_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-random", "TablerIcons.arrows_random()", tagIcons::arrows_random));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right", "TablerIcons.arrows_right()", tagIcons::arrows_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right-down",
            "TablerIcons.arrows_right_down()",
            tagIcons::arrows_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-right-left",
            "TablerIcons.arrows_right_left()",
            tagIcons::arrows_right_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-shuffle", "TablerIcons.arrows_shuffle()", tagIcons::arrows_shuffle));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-shuffle-2",
            "TablerIcons.arrows_shuffle_2()",
            tagIcons::arrows_shuffle_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-sort", "TablerIcons.arrows_sort()", tagIcons::arrows_sort));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-split", "TablerIcons.arrows_split()", tagIcons::arrows_split));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-split-2", "TablerIcons.arrows_split_2()", tagIcons::arrows_split_2));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-down",
            "TablerIcons.arrows_transfer_down()",
            tagIcons::arrows_transfer_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-up",
            "TablerIcons.arrows_transfer_up()",
            tagIcons::arrows_transfer_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-transfer-up-down",
            "TablerIcons.arrows_transfer_up_down()",
            tagIcons::arrows_transfer_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up", "TablerIcons.arrows_up()", tagIcons::arrows_up));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-down", "TablerIcons.arrows_up_down()", tagIcons::arrows_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-left", "TablerIcons.arrows_up_left()", tagIcons::arrows_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-up-right",
            "TablerIcons.arrows_up_right()",
            tagIcons::arrows_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "arrows-vertical",
            "TablerIcons.arrows_vertical()",
            tagIcons::arrows_vertical));
    icons.add(new IconCatalogEntry<>("axis-x", "TablerIcons.axis_x()", tagIcons::axis_x));
    icons.add(new IconCatalogEntry<>("axis-y", "TablerIcons.axis_y()", tagIcons::axis_y));
    icons.add(
        new IconCatalogEntry<>(
            "caret-down", "TablerIcons.caret_down()", tagIcons::caret_down));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left", "TablerIcons.caret_left()", tagIcons::caret_left));
    icons.add(
        new IconCatalogEntry<>(
            "caret-right", "TablerIcons.caret_right()", tagIcons::caret_right));
    icons.add(
        new IconCatalogEntry<>("caret-up", "TablerIcons.caret_up()", tagIcons::caret_up));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up-down", "TablerIcons.caret_up_down()", tagIcons::caret_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-down",
            "TablerIcons.chevron_compact_down()",
            tagIcons::chevron_compact_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-left",
            "TablerIcons.chevron_compact_left()",
            tagIcons::chevron_compact_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-right",
            "TablerIcons.chevron_compact_right()",
            tagIcons::chevron_compact_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-compact-up",
            "TablerIcons.chevron_compact_up()",
            tagIcons::chevron_compact_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down", "TablerIcons.chevron_down()", tagIcons::chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down-left",
            "TablerIcons.chevron_down_left()",
            tagIcons::chevron_down_left));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down-right",
            "TablerIcons.chevron_down_right()",
            tagIcons::chevron_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-left", "TablerIcons.chevron_left()", tagIcons::chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-left-pipe",
            "TablerIcons.chevron_left_pipe()",
            tagIcons::chevron_left_pipe));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right", "TablerIcons.chevron_right()", tagIcons::chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right-pipe",
            "TablerIcons.chevron_right_pipe()",
            tagIcons::chevron_right_pipe));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up", "TablerIcons.chevron_up()", tagIcons::chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up-left",
            "TablerIcons.chevron_up_left()",
            tagIcons::chevron_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-up-right",
            "TablerIcons.chevron_up_right()",
            tagIcons::chevron_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down", "TablerIcons.chevrons_down()", tagIcons::chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down-left",
            "TablerIcons.chevrons_down_left()",
            tagIcons::chevrons_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-down-right",
            "TablerIcons.chevrons_down_right()",
            tagIcons::chevrons_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-left", "TablerIcons.chevrons_left()", tagIcons::chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-right", "TablerIcons.chevrons_right()", tagIcons::chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up", "TablerIcons.chevrons_up()", tagIcons::chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up-left",
            "TablerIcons.chevrons_up_left()",
            tagIcons::chevrons_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "chevrons-up-right",
            "TablerIcons.chevrons_up_right()",
            tagIcons::chevrons_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down",
            "TablerIcons.circle_arrow_down()",
            tagIcons::circle_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-left",
            "TablerIcons.circle_arrow_down_left()",
            tagIcons::circle_arrow_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-right",
            "TablerIcons.circle_arrow_down_right()",
            tagIcons::circle_arrow_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-left",
            "TablerIcons.circle_arrow_left()",
            tagIcons::circle_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-right",
            "TablerIcons.circle_arrow_right()",
            tagIcons::circle_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up",
            "TablerIcons.circle_arrow_up()",
            tagIcons::circle_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-left",
            "TablerIcons.circle_arrow_up_left()",
            tagIcons::circle_arrow_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-right",
            "TablerIcons.circle_arrow_up_right()",
            tagIcons::circle_arrow_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-down",
            "TablerIcons.circle_caret_down()",
            tagIcons::circle_caret_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-left",
            "TablerIcons.circle_caret_left()",
            tagIcons::circle_caret_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-right",
            "TablerIcons.circle_caret_right()",
            tagIcons::circle_caret_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-up",
            "TablerIcons.circle_caret_up()",
            tagIcons::circle_caret_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-down",
            "TablerIcons.circle_chevron_down()",
            tagIcons::circle_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-left",
            "TablerIcons.circle_chevron_left()",
            tagIcons::circle_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-right",
            "TablerIcons.circle_chevron_right()",
            tagIcons::circle_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-up",
            "TablerIcons.circle_chevron_up()",
            tagIcons::circle_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-down",
            "TablerIcons.circle_chevrons_down()",
            tagIcons::circle_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-left",
            "TablerIcons.circle_chevrons_left()",
            tagIcons::circle_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-right",
            "TablerIcons.circle_chevrons_right()",
            tagIcons::circle_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-up",
            "TablerIcons.circle_chevrons_up()",
            tagIcons::circle_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-down",
            "TablerIcons.circle_open_arrow_down()",
            tagIcons::circle_open_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-left",
            "TablerIcons.circle_open_arrow_left()",
            tagIcons::circle_open_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-right",
            "TablerIcons.circle_open_arrow_right()",
            tagIcons::circle_open_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "circle-open-arrow-up",
            "TablerIcons.circle_open_arrow_up()",
            tagIcons::circle_open_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-left",
            "TablerIcons.corner_down_left()",
            tagIcons::corner_down_left));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-left-double",
            "TablerIcons.corner_down_left_double()",
            tagIcons::corner_down_left_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-right",
            "TablerIcons.corner_down_right()",
            tagIcons::corner_down_right));
    icons.add(
        new IconCatalogEntry<>(
            "corner-down-right-double",
            "TablerIcons.corner_down_right_double()",
            tagIcons::corner_down_right_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-down",
            "TablerIcons.corner_left_down()",
            tagIcons::corner_left_down));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-down-double",
            "TablerIcons.corner_left_down_double()",
            tagIcons::corner_left_down_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-up", "TablerIcons.corner_left_up()", tagIcons::corner_left_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-left-up-double",
            "TablerIcons.corner_left_up_double()",
            tagIcons::corner_left_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-down",
            "TablerIcons.corner_right_down()",
            tagIcons::corner_right_down));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-down-double",
            "TablerIcons.corner_right_down_double()",
            tagIcons::corner_right_down_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-up",
            "TablerIcons.corner_right_up()",
            tagIcons::corner_right_up));
    icons.add(
        new IconCatalogEntry<>(
            "corner-right-up-double",
            "TablerIcons.corner_right_up_double()",
            tagIcons::corner_right_up_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-left", "TablerIcons.corner_up_left()", tagIcons::corner_up_left));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-left-double",
            "TablerIcons.corner_up_left_double()",
            tagIcons::corner_up_left_double));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-right",
            "TablerIcons.corner_up_right()",
            tagIcons::corner_up_right));
    icons.add(
        new IconCatalogEntry<>(
            "corner-up-right-double",
            "TablerIcons.corner_up_right_double()",
            tagIcons::corner_up_right_double));
    icons.add(
        new IconCatalogEntry<>("download", "TablerIcons.download()", tagIcons::download));
    icons.add(
        new IconCatalogEntry<>(
            "download-off", "TablerIcons.download_off()", tagIcons::download_off));
    icons.add(new IconCatalogEntry<>("fold", "TablerIcons.fold()", tagIcons::fold));
    icons.add(
        new IconCatalogEntry<>(
            "fold-down", "TablerIcons.fold_down()", tagIcons::fold_down));
    icons.add(
        new IconCatalogEntry<>("fold-up", "TablerIcons.fold_up()", tagIcons::fold_up));
    icons.add(new IconCatalogEntry<>("login", "TablerIcons.login()", tagIcons::login));
    icons.add(
        new IconCatalogEntry<>("login-2", "TablerIcons.login_2()", tagIcons::login_2));
    icons.add(
        new IconCatalogEntry<>("refresh", "TablerIcons.refresh()", tagIcons::refresh));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-alert", "TablerIcons.refresh_alert()", tagIcons::refresh_alert));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-dot", "TablerIcons.refresh_dot()", tagIcons::refresh_dot));
    icons.add(
        new IconCatalogEntry<>(
            "refresh-off", "TablerIcons.refresh_off()", tagIcons::refresh_off));
    icons.add(new IconCatalogEntry<>("reload", "TablerIcons.reload()", tagIcons::reload));
    icons.add(
        new IconCatalogEntry<>(
            "ripple-down", "TablerIcons.ripple_down()", tagIcons::ripple_down));
    icons.add(
        new IconCatalogEntry<>(
            "ripple-up", "TablerIcons.ripple_up()", tagIcons::ripple_up));
    icons.add(new IconCatalogEntry<>("rotate", "TablerIcons.rotate()", tagIcons::rotate));
    icons.add(
        new IconCatalogEntry<>("rotate-2", "TablerIcons.rotate_2()", tagIcons::rotate_2));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-360", "TablerIcons.rotate_360()", tagIcons::rotate_360));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-clockwise",
            "TablerIcons.rotate_clockwise()",
            tagIcons::rotate_clockwise));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-clockwise-2",
            "TablerIcons.rotate_clockwise_2()",
            tagIcons::rotate_clockwise_2));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-dot", "TablerIcons.rotate_dot()", tagIcons::rotate_dot));
    icons.add(
        new IconCatalogEntry<>(
            "rotate-rectangle",
            "TablerIcons.rotate_rectangle()",
            tagIcons::rotate_rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-down", "TablerIcons.s_turn_down()", tagIcons::s_turn_down));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-left", "TablerIcons.s_turn_left()", tagIcons::s_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-right", "TablerIcons.s_turn_right()", tagIcons::s_turn_right));
    icons.add(
        new IconCatalogEntry<>(
            "s-turn-up", "TablerIcons.s_turn_up()", tagIcons::s_turn_up));
    icons.add(new IconCatalogEntry<>("select", "TablerIcons.select()", tagIcons::select));
    icons.add(
        new IconCatalogEntry<>("selector", "TablerIcons.selector()", tagIcons::selector));
    icons.add(
        new IconCatalogEntry<>("share-2", "TablerIcons.share_2()", tagIcons::share_2));
    icons.add(
        new IconCatalogEntry<>("share-3", "TablerIcons.share_3()", tagIcons::share_3));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-down",
            "TablerIcons.square_arrow_down()",
            tagIcons::square_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-left",
            "TablerIcons.square_arrow_left()",
            tagIcons::square_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-right",
            "TablerIcons.square_arrow_right()",
            tagIcons::square_arrow_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-up",
            "TablerIcons.square_arrow_up()",
            tagIcons::square_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-down",
            "TablerIcons.square_chevron_down()",
            tagIcons::square_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-left",
            "TablerIcons.square_chevron_left()",
            tagIcons::square_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-right",
            "TablerIcons.square_chevron_right()",
            tagIcons::square_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-up",
            "TablerIcons.square_chevron_up()",
            tagIcons::square_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-down",
            "TablerIcons.square_chevrons_down()",
            tagIcons::square_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-left",
            "TablerIcons.square_chevrons_left()",
            tagIcons::square_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-right",
            "TablerIcons.square_chevrons_right()",
            tagIcons::square_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-up",
            "TablerIcons.square_chevrons_up()",
            tagIcons::square_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-down",
            "TablerIcons.square_rounded_arrow_down()",
            tagIcons::square_rounded_arrow_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-left",
            "TablerIcons.square_rounded_arrow_left()",
            tagIcons::square_rounded_arrow_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-right",
            "TablerIcons.square_rounded_arrow_right()",
            tagIcons::square_rounded_arrow_right));
  }

  private static void addIcons3() {
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-up",
            "TablerIcons.square_rounded_arrow_up()",
            tagIcons::square_rounded_arrow_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-down",
            "TablerIcons.square_rounded_chevron_down()",
            tagIcons::square_rounded_chevron_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-left",
            "TablerIcons.square_rounded_chevron_left()",
            tagIcons::square_rounded_chevron_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-right",
            "TablerIcons.square_rounded_chevron_right()",
            tagIcons::square_rounded_chevron_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-up",
            "TablerIcons.square_rounded_chevron_up()",
            tagIcons::square_rounded_chevron_up));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-down",
            "TablerIcons.square_rounded_chevrons_down()",
            tagIcons::square_rounded_chevrons_down));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-left",
            "TablerIcons.square_rounded_chevrons_left()",
            tagIcons::square_rounded_chevrons_left));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-right",
            "TablerIcons.square_rounded_chevrons_right()",
            tagIcons::square_rounded_chevrons_right));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-up",
            "TablerIcons.square_rounded_chevrons_up()",
            tagIcons::square_rounded_chevrons_up));
    icons.add(
        new IconCatalogEntry<>(
            "step-into", "TablerIcons.step_into()", tagIcons::step_into));
    icons.add(
        new IconCatalogEntry<>("step-out", "TablerIcons.step_out()", tagIcons::step_out));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-down", "TablerIcons.swipe_down()", tagIcons::swipe_down));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-left", "TablerIcons.swipe_left()", tagIcons::swipe_left));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-right", "TablerIcons.swipe_right()", tagIcons::swipe_right));
    icons.add(
        new IconCatalogEntry<>("swipe-up", "TablerIcons.swipe_up()", tagIcons::swipe_up));
    icons.add(
        new IconCatalogEntry<>(
            "switch-icon", "TablerIcons.switch_icon()", tagIcons::switch_icon));
    icons.add(
        new IconCatalogEntry<>("switch-2", "TablerIcons.switch_2()", tagIcons::switch_2));
    icons.add(
        new IconCatalogEntry<>("switch-3", "TablerIcons.switch_3()", tagIcons::switch_3));
    icons.add(
        new IconCatalogEntry<>(
            "switch-horizontal",
            "TablerIcons.switch_horizontal()",
            tagIcons::switch_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "switch-vertical",
            "TablerIcons.switch_vertical()",
            tagIcons::switch_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "transition-bottom",
            "TablerIcons.transition_bottom()",
            tagIcons::transition_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "transition-left",
            "TablerIcons.transition_left()",
            tagIcons::transition_left));
    icons.add(
        new IconCatalogEntry<>(
            "transition-right",
            "TablerIcons.transition_right()",
            tagIcons::transition_right));
    icons.add(
        new IconCatalogEntry<>(
            "transition-top", "TablerIcons.transition_top()", tagIcons::transition_top));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down", "TablerIcons.trending_down()", tagIcons::trending_down));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down-2",
            "TablerIcons.trending_down_2()",
            tagIcons::trending_down_2));
    icons.add(
        new IconCatalogEntry<>(
            "trending-down-3",
            "TablerIcons.trending_down_3()",
            tagIcons::trending_down_3));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up", "TablerIcons.trending_up()", tagIcons::trending_up));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up-2", "TablerIcons.trending_up_2()", tagIcons::trending_up_2));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up-3", "TablerIcons.trending_up_3()", tagIcons::trending_up_3));
    icons.add(
        new IconCatalogEntry<>(
            "u-turn-left", "TablerIcons.u_turn_left()", tagIcons::u_turn_left));
    icons.add(
        new IconCatalogEntry<>(
            "u-turn-right", "TablerIcons.u_turn_right()", tagIcons::u_turn_right));
    icons.add(new IconCatalogEntry<>("upload", "TablerIcons.upload()", tagIcons::upload));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-upward", "TablerIcons.arrow_up()", tagIcons::arrow_upward));
    icons.add(
        new IconCatalogEntry<>(
            "fullscreen", "TablerIcons.arrows_maximize()", tagIcons::fullscreen));
    icons.add(
        new IconCatalogEntry<>(
            "fullscreen-exit",
            "TablerIcons.arrows_minimize()",
            tagIcons::fullscreen_exit));
    icons.add(
        new IconCatalogEntry<>(
            "menu-down", "TablerIcons.chevron_down()", tagIcons::menu_down));
    icons.add(
        new IconCatalogEntry<>(
            "menu-left", "TablerIcons.chevron_left()", tagIcons::menu_left));
    icons.add(
        new IconCatalogEntry<>(
            "menu-right", "TablerIcons.chevron_right()", tagIcons::menu_right));
    icons.add(
        new IconCatalogEntry<>("undo", "TablerIcons.arrow_back_up()", tagIcons::undo));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-content",
            "TablerIcons.arrow_autofit_content_filled()",
            tagIcons::arrow_autofit_content_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-down",
            "TablerIcons.arrow_autofit_down_filled()",
            tagIcons::arrow_autofit_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-height",
            "TablerIcons.arrow_autofit_height_filled()",
            tagIcons::arrow_autofit_height_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-left",
            "TablerIcons.arrow_autofit_left_filled()",
            tagIcons::arrow_autofit_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-right",
            "TablerIcons.arrow_autofit_right_filled()",
            tagIcons::arrow_autofit_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-up",
            "TablerIcons.arrow_autofit_up_filled()",
            tagIcons::arrow_autofit_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-autofit-width",
            "TablerIcons.arrow_autofit_width_filled()",
            tagIcons::arrow_autofit_width_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-down",
            "TablerIcons.arrow_badge_down_filled()",
            tagIcons::arrow_badge_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-left",
            "TablerIcons.arrow_badge_left_filled()",
            tagIcons::arrow_badge_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-right",
            "TablerIcons.arrow_badge_right_filled()",
            tagIcons::arrow_badge_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-badge-up",
            "TablerIcons.arrow_badge_up_filled()",
            tagIcons::arrow_badge_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down",
            "TablerIcons.arrow_big_down_filled()",
            tagIcons::arrow_big_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-line",
            "TablerIcons.arrow_big_down_line_filled()",
            tagIcons::arrow_big_down_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-down-lines",
            "TablerIcons.arrow_big_down_lines_filled()",
            tagIcons::arrow_big_down_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left",
            "TablerIcons.arrow_big_left_filled()",
            tagIcons::arrow_big_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-line",
            "TablerIcons.arrow_big_left_line_filled()",
            tagIcons::arrow_big_left_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-left-lines",
            "TablerIcons.arrow_big_left_lines_filled()",
            tagIcons::arrow_big_left_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right",
            "TablerIcons.arrow_big_right_filled()",
            tagIcons::arrow_big_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-line",
            "TablerIcons.arrow_big_right_line_filled()",
            tagIcons::arrow_big_right_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-right-lines",
            "TablerIcons.arrow_big_right_lines_filled()",
            tagIcons::arrow_big_right_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up",
            "TablerIcons.arrow_big_up_filled()",
            tagIcons::arrow_big_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-line",
            "TablerIcons.arrow_big_up_line_filled()",
            tagIcons::arrow_big_up_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-big-up-lines",
            "TablerIcons.arrow_big_up_lines_filled()",
            tagIcons::arrow_big_up_lines_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-circle",
            "TablerIcons.arrow_down_circle_filled()",
            tagIcons::arrow_down_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-rhombus",
            "TablerIcons.arrow_down_rhombus_filled()",
            tagIcons::arrow_down_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-down-square",
            "TablerIcons.arrow_down_square_filled()",
            tagIcons::arrow_down_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-guide",
            "TablerIcons.arrow_guide_filled()",
            tagIcons::arrow_guide_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-circle",
            "TablerIcons.arrow_left_circle_filled()",
            tagIcons::arrow_left_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-rhombus",
            "TablerIcons.arrow_left_rhombus_filled()",
            tagIcons::arrow_left_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-left-square",
            "TablerIcons.arrow_left_square_filled()",
            tagIcons::arrow_left_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-down",
            "TablerIcons.arrow_move_down_filled()",
            tagIcons::arrow_move_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-left",
            "TablerIcons.arrow_move_left_filled()",
            tagIcons::arrow_move_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-right",
            "TablerIcons.arrow_move_right_filled()",
            tagIcons::arrow_move_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-move-up",
            "TablerIcons.arrow_move_up_filled()",
            tagIcons::arrow_move_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-circle",
            "TablerIcons.arrow_right_circle_filled()",
            tagIcons::arrow_right_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-rhombus",
            "TablerIcons.arrow_right_rhombus_filled()",
            tagIcons::arrow_right_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-right-square",
            "TablerIcons.arrow_right_square_filled()",
            tagIcons::arrow_right_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-circle",
            "TablerIcons.arrow_up_circle_filled()",
            tagIcons::arrow_up_circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-rhombus",
            "TablerIcons.arrow_up_rhombus_filled()",
            tagIcons::arrow_up_rhombus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "arrow-up-square",
            "TablerIcons.arrow_up_square_filled()",
            tagIcons::arrow_up_square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-down", "TablerIcons.caret_down_filled()", tagIcons::caret_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left", "TablerIcons.caret_left_filled()", tagIcons::caret_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-right",
            "TablerIcons.caret_right_filled()",
            tagIcons::caret_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up", "TablerIcons.caret_up_filled()", tagIcons::caret_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-up-down",
            "TablerIcons.caret_up_down_filled()",
            tagIcons::caret_up_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-down",
            "TablerIcons.chevron_down_filled()",
            tagIcons::chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chevron-right",
            "TablerIcons.chevron_right_filled()",
            tagIcons::chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down",
            "TablerIcons.circle_arrow_down_filled()",
            tagIcons::circle_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-left",
            "TablerIcons.circle_arrow_down_left_filled()",
            tagIcons::circle_arrow_down_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-down-right",
            "TablerIcons.circle_arrow_down_right_filled()",
            tagIcons::circle_arrow_down_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-left",
            "TablerIcons.circle_arrow_left_filled()",
            tagIcons::circle_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-right",
            "TablerIcons.circle_arrow_right_filled()",
            tagIcons::circle_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up",
            "TablerIcons.circle_arrow_up_filled()",
            tagIcons::circle_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-left",
            "TablerIcons.circle_arrow_up_left_filled()",
            tagIcons::circle_arrow_up_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-arrow-up-right",
            "TablerIcons.circle_arrow_up_right_filled()",
            tagIcons::circle_arrow_up_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-down",
            "TablerIcons.circle_caret_down_filled()",
            tagIcons::circle_caret_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-left",
            "TablerIcons.circle_caret_left_filled()",
            tagIcons::circle_caret_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-right",
            "TablerIcons.circle_caret_right_filled()",
            tagIcons::circle_caret_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-caret-up",
            "TablerIcons.circle_caret_up_filled()",
            tagIcons::circle_caret_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-down",
            "TablerIcons.circle_chevron_down_filled()",
            tagIcons::circle_chevron_down_filled));
  }

  private static void addIcons4() {
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-left",
            "TablerIcons.circle_chevron_left_filled()",
            tagIcons::circle_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-right",
            "TablerIcons.circle_chevron_right_filled()",
            tagIcons::circle_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevron-up",
            "TablerIcons.circle_chevron_up_filled()",
            tagIcons::circle_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-down",
            "TablerIcons.circle_chevrons_down_filled()",
            tagIcons::circle_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-left",
            "TablerIcons.circle_chevrons_left_filled()",
            tagIcons::circle_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-right",
            "TablerIcons.circle_chevrons_right_filled()",
            tagIcons::circle_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-chevrons-up",
            "TablerIcons.circle_chevrons_up_filled()",
            tagIcons::circle_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "download", "TablerIcons.download_filled()", tagIcons::download_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-down",
            "TablerIcons.square_arrow_down_filled()",
            tagIcons::square_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-left",
            "TablerIcons.square_arrow_left_filled()",
            tagIcons::square_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-right",
            "TablerIcons.square_arrow_right_filled()",
            tagIcons::square_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-arrow-up",
            "TablerIcons.square_arrow_up_filled()",
            tagIcons::square_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-down",
            "TablerIcons.square_chevron_down_filled()",
            tagIcons::square_chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-left",
            "TablerIcons.square_chevron_left_filled()",
            tagIcons::square_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-right",
            "TablerIcons.square_chevron_right_filled()",
            tagIcons::square_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevron-up",
            "TablerIcons.square_chevron_up_filled()",
            tagIcons::square_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-down",
            "TablerIcons.square_chevrons_down_filled()",
            tagIcons::square_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-left",
            "TablerIcons.square_chevrons_left_filled()",
            tagIcons::square_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-right",
            "TablerIcons.square_chevrons_right_filled()",
            tagIcons::square_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-chevrons-up",
            "TablerIcons.square_chevrons_up_filled()",
            tagIcons::square_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-down",
            "TablerIcons.square_rounded_arrow_down_filled()",
            tagIcons::square_rounded_arrow_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-left",
            "TablerIcons.square_rounded_arrow_left_filled()",
            tagIcons::square_rounded_arrow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-right",
            "TablerIcons.square_rounded_arrow_right_filled()",
            tagIcons::square_rounded_arrow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-arrow-up",
            "TablerIcons.square_rounded_arrow_up_filled()",
            tagIcons::square_rounded_arrow_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-down",
            "TablerIcons.square_rounded_chevron_down_filled()",
            tagIcons::square_rounded_chevron_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-left",
            "TablerIcons.square_rounded_chevron_left_filled()",
            tagIcons::square_rounded_chevron_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-right",
            "TablerIcons.square_rounded_chevron_right_filled()",
            tagIcons::square_rounded_chevron_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevron-up",
            "TablerIcons.square_rounded_chevron_up_filled()",
            tagIcons::square_rounded_chevron_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-down",
            "TablerIcons.square_rounded_chevrons_down_filled()",
            tagIcons::square_rounded_chevrons_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-left",
            "TablerIcons.square_rounded_chevrons_left_filled()",
            tagIcons::square_rounded_chevrons_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-right",
            "TablerIcons.square_rounded_chevrons_right_filled()",
            tagIcons::square_rounded_chevrons_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-chevrons-up",
            "TablerIcons.square_rounded_chevrons_up_filled()",
            tagIcons::square_rounded_chevrons_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-down", "TablerIcons.swipe_down_filled()", tagIcons::swipe_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-left", "TablerIcons.swipe_left_filled()", tagIcons::swipe_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-right",
            "TablerIcons.swipe_right_filled()",
            tagIcons::swipe_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "swipe-up", "TablerIcons.swipe_up_filled()", tagIcons::swipe_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-bottom",
            "TablerIcons.transition_bottom_filled()",
            tagIcons::transition_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-left",
            "TablerIcons.transition_left_filled()",
            tagIcons::transition_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-right",
            "TablerIcons.transition_right_filled()",
            tagIcons::transition_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "transition-top",
            "TablerIcons.transition_top_filled()",
            tagIcons::transition_top_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
