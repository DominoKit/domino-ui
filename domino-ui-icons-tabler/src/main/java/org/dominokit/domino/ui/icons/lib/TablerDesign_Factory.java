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
import org.dominokit.domino.ui.icons.TablerDesign;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Design category. */
public final class TablerDesign_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerDesign tagIcons = new TablerDesign() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
    addIcons3();
    addIcons4();
  }

  private static void addIcons0() {
    icons.add(new IconCatalogEntry<>("ad", "TablerIcons.ad()", tagIcons::ad));
    icons.add(new IconCatalogEntry<>("ad-2", "TablerIcons.ad_2()", tagIcons::ad_2));
    icons.add(new IconCatalogEntry<>("ad-off", "TablerIcons.ad_off()", tagIcons::ad_off));
    icons.add(new IconCatalogEntry<>("angle", "TablerIcons.angle()", tagIcons::angle));
    icons.add(
        new IconCatalogEntry<>("artboard", "TablerIcons.artboard()", tagIcons::artboard));
    icons.add(
        new IconCatalogEntry<>(
            "artboard-off", "TablerIcons.artboard_off()", tagIcons::artboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "background", "TablerIcons.background()", tagIcons::background));
    icons.add(new IconCatalogEntry<>("barrel", "TablerIcons.barrel()", tagIcons::barrel));
    icons.add(
        new IconCatalogEntry<>(
            "barrel-off", "TablerIcons.barrel_off()", tagIcons::barrel_off));
    icons.add(
        new IconCatalogEntry<>(
            "barrier-block", "TablerIcons.barrier_block()", tagIcons::barrier_block));
    icons.add(
        new IconCatalogEntry<>(
            "barrier-block-off",
            "TablerIcons.barrier_block_off()",
            tagIcons::barrier_block_off));
    icons.add(
        new IconCatalogEntry<>(
            "binoculars", "TablerIcons.binoculars()", tagIcons::binoculars));
    icons.add(new IconCatalogEntry<>("blade", "TablerIcons.blade()", tagIcons::blade));
    icons.add(
        new IconCatalogEntry<>(
            "blend-mode", "TablerIcons.blend_mode()", tagIcons::blend_mode));
    icons.add(new IconCatalogEntry<>("blur", "TablerIcons.blur()", tagIcons::blur));
    icons.add(
        new IconCatalogEntry<>("blur-off", "TablerIcons.blur_off()", tagIcons::blur_off));
    icons.add(new IconCatalogEntry<>("bolt", "TablerIcons.bolt()", tagIcons::bolt));
    icons.add(
        new IconCatalogEntry<>("bolt-off", "TablerIcons.bolt_off()", tagIcons::bolt_off));
    icons.add(new IconCatalogEntry<>("bomb", "TablerIcons.bomb()", tagIcons::bomb));
    icons.add(new IconCatalogEntry<>("bong", "TablerIcons.bong()", tagIcons::bong));
    icons.add(
        new IconCatalogEntry<>("bong-off", "TablerIcons.bong_off()", tagIcons::bong_off));
    icons.add(new IconCatalogEntry<>("boom", "TablerIcons.boom()", tagIcons::boom));
    icons.add(
        new IconCatalogEntry<>(
            "border-all", "TablerIcons.border_all()", tagIcons::border_all));
    icons.add(
        new IconCatalogEntry<>(
            "border-bottom", "TablerIcons.border_bottom()", tagIcons::border_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "border-bottom-plus",
            "TablerIcons.border_bottom_plus()",
            tagIcons::border_bottom_plus));
    icons.add(
        new IconCatalogEntry<>(
            "border-corner-pill",
            "TablerIcons.border_corner_pill()",
            tagIcons::border_corner_pill));
    icons.add(
        new IconCatalogEntry<>(
            "border-corner-rounded",
            "TablerIcons.border_corner_rounded()",
            tagIcons::border_corner_rounded));
    icons.add(
        new IconCatalogEntry<>(
            "border-corner-square",
            "TablerIcons.border_corner_square()",
            tagIcons::border_corner_square));
    icons.add(
        new IconCatalogEntry<>(
            "border-corners", "TablerIcons.border_corners()", tagIcons::border_corners));
    icons.add(
        new IconCatalogEntry<>(
            "border-horizontal",
            "TablerIcons.border_horizontal()",
            tagIcons::border_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "border-inner", "TablerIcons.border_inner()", tagIcons::border_inner));
    icons.add(
        new IconCatalogEntry<>(
            "border-left", "TablerIcons.border_left()", tagIcons::border_left));
    icons.add(
        new IconCatalogEntry<>(
            "border-left-plus",
            "TablerIcons.border_left_plus()",
            tagIcons::border_left_plus));
    icons.add(
        new IconCatalogEntry<>(
            "border-none", "TablerIcons.border_none()", tagIcons::border_none));
    icons.add(
        new IconCatalogEntry<>(
            "border-outer", "TablerIcons.border_outer()", tagIcons::border_outer));
    icons.add(
        new IconCatalogEntry<>(
            "border-radius", "TablerIcons.border_radius()", tagIcons::border_radius));
    icons.add(
        new IconCatalogEntry<>(
            "border-right", "TablerIcons.border_right()", tagIcons::border_right));
    icons.add(
        new IconCatalogEntry<>(
            "border-right-plus",
            "TablerIcons.border_right_plus()",
            tagIcons::border_right_plus));
    icons.add(
        new IconCatalogEntry<>(
            "border-sides", "TablerIcons.border_sides()", tagIcons::border_sides));
    icons.add(
        new IconCatalogEntry<>(
            "border-style", "TablerIcons.border_style()", tagIcons::border_style));
    icons.add(
        new IconCatalogEntry<>(
            "border-style-2", "TablerIcons.border_style_2()", tagIcons::border_style_2));
    icons.add(
        new IconCatalogEntry<>(
            "border-top", "TablerIcons.border_top()", tagIcons::border_top));
    icons.add(
        new IconCatalogEntry<>(
            "border-top-plus",
            "TablerIcons.border_top_plus()",
            tagIcons::border_top_plus));
    icons.add(
        new IconCatalogEntry<>(
            "border-vertical",
            "TablerIcons.border_vertical()",
            tagIcons::border_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "bounce-left", "TablerIcons.bounce_left()", tagIcons::bounce_left));
    icons.add(
        new IconCatalogEntry<>(
            "bounce-right", "TablerIcons.bounce_right()", tagIcons::bounce_right));
    icons.add(new IconCatalogEntry<>("box", "TablerIcons.box()", tagIcons::box));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom",
            "TablerIcons.box_align_bottom()",
            tagIcons::box_align_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom-left",
            "TablerIcons.box_align_bottom_left()",
            tagIcons::box_align_bottom_left));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom-right",
            "TablerIcons.box_align_bottom_right()",
            tagIcons::box_align_bottom_right));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-left", "TablerIcons.box_align_left()", tagIcons::box_align_left));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-right",
            "TablerIcons.box_align_right()",
            tagIcons::box_align_right));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top", "TablerIcons.box_align_top()", tagIcons::box_align_top));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top-left",
            "TablerIcons.box_align_top_left()",
            tagIcons::box_align_top_left));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top-right",
            "TablerIcons.box_align_top_right()",
            tagIcons::box_align_top_right));
    icons.add(
        new IconCatalogEntry<>(
            "box-margin", "TablerIcons.box_margin()", tagIcons::box_margin));
    icons.add(
        new IconCatalogEntry<>(
            "box-model", "TablerIcons.box_model()", tagIcons::box_model));
    icons.add(
        new IconCatalogEntry<>(
            "box-model-2", "TablerIcons.box_model_2()", tagIcons::box_model_2));
    icons.add(
        new IconCatalogEntry<>(
            "box-model-2-off",
            "TablerIcons.box_model_2_off()",
            tagIcons::box_model_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "box-model-off", "TablerIcons.box_model_off()", tagIcons::box_model_off));
    icons.add(
        new IconCatalogEntry<>(
            "box-multiple", "TablerIcons.box_multiple()", tagIcons::box_multiple));
    icons.add(
        new IconCatalogEntry<>("box-off", "TablerIcons.box_off()", tagIcons::box_off));
    icons.add(
        new IconCatalogEntry<>(
            "box-padding", "TablerIcons.box_padding()", tagIcons::box_padding));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-angle", "TablerIcons.brackets_angle()", tagIcons::brackets_angle));
    icons.add(
        new IconCatalogEntry<>(
            "brackets-angle-off",
            "TablerIcons.brackets_angle_off()",
            tagIcons::brackets_angle_off));
    icons.add(
        new IconCatalogEntry<>(
            "briefcase", "TablerIcons.briefcase()", tagIcons::briefcase));
    icons.add(
        new IconCatalogEntry<>(
            "briefcase-2", "TablerIcons.briefcase_2()", tagIcons::briefcase_2));
    icons.add(
        new IconCatalogEntry<>(
            "briefcase-off", "TablerIcons.briefcase_off()", tagIcons::briefcase_off));
    icons.add(new IconCatalogEntry<>("brush", "TablerIcons.brush()", tagIcons::brush));
    icons.add(
        new IconCatalogEntry<>(
            "brush-off", "TablerIcons.brush_off()", tagIcons::brush_off));
    icons.add(new IconCatalogEntry<>("bucket", "TablerIcons.bucket()", tagIcons::bucket));
    icons.add(
        new IconCatalogEntry<>(
            "bucket-droplet", "TablerIcons.bucket_droplet()", tagIcons::bucket_droplet));
    icons.add(
        new IconCatalogEntry<>(
            "bucket-off", "TablerIcons.bucket_off()", tagIcons::bucket_off));
    icons.add(new IconCatalogEntry<>("bulb", "TablerIcons.bulb()", tagIcons::bulb));
    icons.add(
        new IconCatalogEntry<>("bulb-off", "TablerIcons.bulb_off()", tagIcons::bulb_off));
    icons.add(new IconCatalogEntry<>("candle", "TablerIcons.candle()", tagIcons::candle));
    icons.add(
        new IconCatalogEntry<>(
            "cap-projecting", "TablerIcons.cap_projecting()", tagIcons::cap_projecting));
    icons.add(
        new IconCatalogEntry<>(
            "cap-rounded", "TablerIcons.cap_rounded()", tagIcons::cap_rounded));
    icons.add(
        new IconCatalogEntry<>(
            "cap-straight", "TablerIcons.cap_straight()", tagIcons::cap_straight));
    icons.add(new IconCatalogEntry<>("cards", "TablerIcons.cards()", tagIcons::cards));
    icons.add(
        new IconCatalogEntry<>(
            "carousel-horizontal",
            "TablerIcons.carousel_horizontal()",
            tagIcons::carousel_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "carousel-vertical",
            "TablerIcons.carousel_vertical()",
            tagIcons::carousel_vertical));
    icons.add(new IconCatalogEntry<>("cell", "TablerIcons.cell()", tagIcons::cell));
    icons.add(
        new IconCatalogEntry<>(
            "chair-director", "TablerIcons.chair_director()", tagIcons::chair_director));
    icons.add(new IconCatalogEntry<>("chisel", "TablerIcons.chisel()", tagIcons::chisel));
    icons.add(
        new IconCatalogEntry<>(
            "christmas-ball", "TablerIcons.christmas_ball()", tagIcons::christmas_ball));
    icons.add(new IconCatalogEntry<>("coffin", "TablerIcons.coffin()", tagIcons::coffin));
    icons.add(
        new IconCatalogEntry<>(
            "color-filter", "TablerIcons.color_filter()", tagIcons::color_filter));
    icons.add(
        new IconCatalogEntry<>(
            "color-picker", "TablerIcons.color_picker()", tagIcons::color_picker));
    icons.add(
        new IconCatalogEntry<>(
            "color-picker-off",
            "TablerIcons.color_picker_off()",
            tagIcons::color_picker_off));
    icons.add(
        new IconCatalogEntry<>(
            "color-swatch", "TablerIcons.color_swatch()", tagIcons::color_swatch));
    icons.add(
        new IconCatalogEntry<>(
            "color-swatch-off",
            "TablerIcons.color_swatch_off()",
            tagIcons::color_swatch_off));
    icons.add(
        new IconCatalogEntry<>(
            "components", "TablerIcons.components()", tagIcons::components));
    icons.add(
        new IconCatalogEntry<>(
            "components-off", "TablerIcons.components_off()", tagIcons::components_off));
    icons.add(
        new IconCatalogEntry<>("confetti", "TablerIcons.confetti()", tagIcons::confetti));
    icons.add(
        new IconCatalogEntry<>(
            "confetti-off", "TablerIcons.confetti_off()", tagIcons::confetti_off));
    icons.add(
        new IconCatalogEntry<>(
            "container", "TablerIcons.container()", tagIcons::container));
    icons.add(
        new IconCatalogEntry<>(
            "container-off", "TablerIcons.container_off()", tagIcons::container_off));
    icons.add(
        new IconCatalogEntry<>(
            "cookie-man", "TablerIcons.cookie_man()", tagIcons::cookie_man));
    icons.add(new IconCatalogEntry<>("crop", "TablerIcons.crop()", tagIcons::crop));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>("crop-1-1", "TablerIcons.crop_1_1()", tagIcons::crop_1_1));
    icons.add(
        new IconCatalogEntry<>(
            "crop-16-9", "TablerIcons.crop_16_9()", tagIcons::crop_16_9));
    icons.add(
        new IconCatalogEntry<>("crop-3-2", "TablerIcons.crop_3_2()", tagIcons::crop_3_2));
    icons.add(
        new IconCatalogEntry<>("crop-5-4", "TablerIcons.crop_5_4()", tagIcons::crop_5_4));
    icons.add(
        new IconCatalogEntry<>("crop-7-5", "TablerIcons.crop_7_5()", tagIcons::crop_7_5));
    icons.add(
        new IconCatalogEntry<>(
            "crop-landscape", "TablerIcons.crop_landscape()", tagIcons::crop_landscape));
    icons.add(
        new IconCatalogEntry<>(
            "crop-portrait", "TablerIcons.crop_portrait()", tagIcons::crop_portrait));
    icons.add(new IconCatalogEntry<>("crown", "TablerIcons.crown()", tagIcons::crown));
    icons.add(
        new IconCatalogEntry<>(
            "crown-off", "TablerIcons.crown_off()", tagIcons::crown_off));
    icons.add(new IconCatalogEntry<>("cut", "TablerIcons.cut()", tagIcons::cut));
    icons.add(
        new IconCatalogEntry<>(
            "dimensions", "TablerIcons.dimensions()", tagIcons::dimensions));
    icons.add(
        new IconCatalogEntry<>(
            "drag-drop", "TablerIcons.drag_drop()", tagIcons::drag_drop));
    icons.add(
        new IconCatalogEntry<>(
            "drag-drop-2", "TablerIcons.drag_drop_2()", tagIcons::drag_drop_2));
    icons.add(
        new IconCatalogEntry<>("droplet", "TablerIcons.droplet()", tagIcons::droplet));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-bolt", "TablerIcons.droplet_bolt()", tagIcons::droplet_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-cancel", "TablerIcons.droplet_cancel()", tagIcons::droplet_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-check", "TablerIcons.droplet_check()", tagIcons::droplet_check));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-code", "TablerIcons.droplet_code()", tagIcons::droplet_code));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-cog", "TablerIcons.droplet_cog()", tagIcons::droplet_cog));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-dollar", "TablerIcons.droplet_dollar()", tagIcons::droplet_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-down", "TablerIcons.droplet_down()", tagIcons::droplet_down));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-exclamation",
            "TablerIcons.droplet_exclamation()",
            tagIcons::droplet_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-half", "TablerIcons.droplet_half()", tagIcons::droplet_half));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-half-2", "TablerIcons.droplet_half_2()", tagIcons::droplet_half_2));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-heart", "TablerIcons.droplet_heart()", tagIcons::droplet_heart));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-minus", "TablerIcons.droplet_minus()", tagIcons::droplet_minus));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-off", "TablerIcons.droplet_off()", tagIcons::droplet_off));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-pause", "TablerIcons.droplet_pause()", tagIcons::droplet_pause));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-pin", "TablerIcons.droplet_pin()", tagIcons::droplet_pin));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-plus", "TablerIcons.droplet_plus()", tagIcons::droplet_plus));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-question",
            "TablerIcons.droplet_question()",
            tagIcons::droplet_question));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-search", "TablerIcons.droplet_search()", tagIcons::droplet_search));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-share", "TablerIcons.droplet_share()", tagIcons::droplet_share));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-star", "TablerIcons.droplet_star()", tagIcons::droplet_star));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-up", "TablerIcons.droplet_up()", tagIcons::droplet_up));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-x", "TablerIcons.droplet_x()", tagIcons::droplet_x));
    icons.add(
        new IconCatalogEntry<>("ease-in", "TablerIcons.ease_in()", tagIcons::ease_in));
    icons.add(
        new IconCatalogEntry<>(
            "ease-in-control-point",
            "TablerIcons.ease_in_control_point()",
            tagIcons::ease_in_control_point));
    icons.add(
        new IconCatalogEntry<>(
            "ease-in-out", "TablerIcons.ease_in_out()", tagIcons::ease_in_out));
    icons.add(
        new IconCatalogEntry<>(
            "ease-in-out-control-points",
            "TablerIcons.ease_in_out_control_points()",
            tagIcons::ease_in_out_control_points));
    icons.add(
        new IconCatalogEntry<>("ease-out", "TablerIcons.ease_out()", tagIcons::ease_out));
    icons.add(
        new IconCatalogEntry<>(
            "ease-out-control-point",
            "TablerIcons.ease_out_control_point()",
            tagIcons::ease_out_control_point));
    icons.add(new IconCatalogEntry<>("edit", "TablerIcons.edit()", tagIcons::edit));
    icons.add(
        new IconCatalogEntry<>(
            "edit-bulk", "TablerIcons.edit_bulk()", tagIcons::edit_bulk));
    icons.add(
        new IconCatalogEntry<>(
            "edit-circle", "TablerIcons.edit_circle()", tagIcons::edit_circle));
    icons.add(
        new IconCatalogEntry<>(
            "edit-circle-off",
            "TablerIcons.edit_circle_off()",
            tagIcons::edit_circle_off));
    icons.add(
        new IconCatalogEntry<>("edit-off", "TablerIcons.edit_off()", tagIcons::edit_off));
    icons.add(
        new IconCatalogEntry<>("favicon", "TablerIcons.favicon()", tagIcons::favicon));
    icons.add(
        new IconCatalogEntry<>(
            "flip-horizontal",
            "TablerIcons.flip_horizontal()",
            tagIcons::flip_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "flip-vertical", "TablerIcons.flip_vertical()", tagIcons::flip_vertical));
    icons.add(new IconCatalogEntry<>("frame", "TablerIcons.frame()", tagIcons::frame));
    icons.add(
        new IconCatalogEntry<>(
            "frame-off", "TablerIcons.frame_off()", tagIcons::frame_off));
    icons.add(
        new IconCatalogEntry<>(
            "freeze-column", "TablerIcons.freeze_column()", tagIcons::freeze_column));
    icons.add(
        new IconCatalogEntry<>(
            "freeze-row", "TablerIcons.freeze_row()", tagIcons::freeze_row));
    icons.add(
        new IconCatalogEntry<>(
            "freeze-row-column",
            "TablerIcons.freeze_row_column()",
            tagIcons::freeze_row_column));
    icons.add(new IconCatalogEntry<>("gizmo", "TablerIcons.gizmo()", tagIcons::gizmo));
    icons.add(
        new IconCatalogEntry<>(
            "gradienter", "TablerIcons.gradienter()", tagIcons::gradienter));
    icons.add(new IconCatalogEntry<>("grain", "TablerIcons.grain()", tagIcons::grain));
    icons.add(
        new IconCatalogEntry<>("grid-3x3", "TablerIcons.grid_3x3()", tagIcons::grid_3x3));
    icons.add(
        new IconCatalogEntry<>("grid-4x4", "TablerIcons.grid_4x4()", tagIcons::grid_4x4));
    icons.add(
        new IconCatalogEntry<>(
            "grid-goldenratio",
            "TablerIcons.grid_goldenratio()",
            tagIcons::grid_goldenratio));
    icons.add(
        new IconCatalogEntry<>(
            "guitar-pick", "TablerIcons.guitar_pick()", tagIcons::guitar_pick));
    icons.add(new IconCatalogEntry<>("hammer", "TablerIcons.hammer()", tagIcons::hammer));
    icons.add(
        new IconCatalogEntry<>(
            "hammer-off", "TablerIcons.hammer_off()", tagIcons::hammer_off));
    icons.add(new IconCatalogEntry<>("hash", "TablerIcons.hash()", tagIcons::hash));
    icons.add(
        new IconCatalogEntry<>(
            "hierarchy", "TablerIcons.hierarchy()", tagIcons::hierarchy));
    icons.add(
        new IconCatalogEntry<>(
            "hierarchy-2", "TablerIcons.hierarchy_2()", tagIcons::hierarchy_2));
    icons.add(
        new IconCatalogEntry<>(
            "hierarchy-3", "TablerIcons.hierarchy_3()", tagIcons::hierarchy_3));
    icons.add(
        new IconCatalogEntry<>(
            "hierarchy-off", "TablerIcons.hierarchy_off()", tagIcons::hierarchy_off));
    icons.add(
        new IconCatalogEntry<>(
            "icosahedron", "TablerIcons.icosahedron()", tagIcons::icosahedron));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom",
            "TablerIcons.inner_shadow_bottom()",
            tagIcons::inner_shadow_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom-left",
            "TablerIcons.inner_shadow_bottom_left()",
            tagIcons::inner_shadow_bottom_left));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom-right",
            "TablerIcons.inner_shadow_bottom_right()",
            tagIcons::inner_shadow_bottom_right));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-left",
            "TablerIcons.inner_shadow_left()",
            tagIcons::inner_shadow_left));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-right",
            "TablerIcons.inner_shadow_right()",
            tagIcons::inner_shadow_right));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top",
            "TablerIcons.inner_shadow_top()",
            tagIcons::inner_shadow_top));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top-left",
            "TablerIcons.inner_shadow_top_left()",
            tagIcons::inner_shadow_top_left));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top-right",
            "TablerIcons.inner_shadow_top_right()",
            tagIcons::inner_shadow_top_right));
    icons.add(new IconCatalogEntry<>("key", "TablerIcons.key()", tagIcons::key));
    icons.add(
        new IconCatalogEntry<>("key-off", "TablerIcons.key_off()", tagIcons::key_off));
    icons.add(new IconCatalogEntry<>("ladle", "TablerIcons.ladle()", tagIcons::ladle));
    icons.add(new IconCatalogEntry<>("lamp", "TablerIcons.lamp()", tagIcons::lamp));
    icons.add(new IconCatalogEntry<>("lamp-2", "TablerIcons.lamp_2()", tagIcons::lamp_2));
    icons.add(
        new IconCatalogEntry<>("lamp-off", "TablerIcons.lamp_off()", tagIcons::lamp_off));
    icons.add(new IconCatalogEntry<>("lasso", "TablerIcons.lasso()", tagIcons::lasso));
    icons.add(
        new IconCatalogEntry<>(
            "lasso-off", "TablerIcons.lasso_off()", tagIcons::lasso_off));
    icons.add(
        new IconCatalogEntry<>(
            "lasso-polygon", "TablerIcons.lasso_polygon()", tagIcons::lasso_polygon));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath", "TablerIcons.laurel_wreath()", tagIcons::laurel_wreath));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-1",
            "TablerIcons.laurel_wreath_1()",
            tagIcons::laurel_wreath_1));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-2",
            "TablerIcons.laurel_wreath_2()",
            tagIcons::laurel_wreath_2));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-3",
            "TablerIcons.laurel_wreath_3()",
            tagIcons::laurel_wreath_3));
    icons.add(
        new IconCatalogEntry<>(
            "layers-difference",
            "TablerIcons.layers_difference()",
            tagIcons::layers_difference));
    icons.add(
        new IconCatalogEntry<>(
            "layers-intersect",
            "TablerIcons.layers_intersect()",
            tagIcons::layers_intersect));
    icons.add(
        new IconCatalogEntry<>(
            "layers-intersect-2",
            "TablerIcons.layers_intersect_2()",
            tagIcons::layers_intersect_2));
    icons.add(
        new IconCatalogEntry<>(
            "layers-linked", "TablerIcons.layers_linked()", tagIcons::layers_linked));
    icons.add(
        new IconCatalogEntry<>(
            "layers-off", "TablerIcons.layers_off()", tagIcons::layers_off));
    icons.add(
        new IconCatalogEntry<>(
            "layers-selected",
            "TablerIcons.layers_selected()",
            tagIcons::layers_selected));
    icons.add(
        new IconCatalogEntry<>(
            "layers-selected-bottom",
            "TablerIcons.layers_selected_bottom()",
            tagIcons::layers_selected_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "layers-subtract",
            "TablerIcons.layers_subtract()",
            tagIcons::layers_subtract));
    icons.add(
        new IconCatalogEntry<>(
            "layers-union", "TablerIcons.layers_union()", tagIcons::layers_union));
  }

  private static void addIcons2() {
    icons.add(new IconCatalogEntry<>("layout", "TablerIcons.layout()", tagIcons::layout));
    icons.add(
        new IconCatalogEntry<>("layout-2", "TablerIcons.layout_2()", tagIcons::layout_2));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-bottom",
            "TablerIcons.layout_align_bottom()",
            tagIcons::layout_align_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-center",
            "TablerIcons.layout_align_center()",
            tagIcons::layout_align_center));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-left",
            "TablerIcons.layout_align_left()",
            tagIcons::layout_align_left));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-middle",
            "TablerIcons.layout_align_middle()",
            tagIcons::layout_align_middle));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-right",
            "TablerIcons.layout_align_right()",
            tagIcons::layout_align_right));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-top",
            "TablerIcons.layout_align_top()",
            tagIcons::layout_align_top));
    icons.add(
        new IconCatalogEntry<>(
            "layout-board", "TablerIcons.layout_board()", tagIcons::layout_board));
    icons.add(
        new IconCatalogEntry<>(
            "layout-board-split",
            "TablerIcons.layout_board_split()",
            tagIcons::layout_board_split));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar",
            "TablerIcons.layout_bottombar()",
            tagIcons::layout_bottombar));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar-collapse",
            "TablerIcons.layout_bottombar_collapse()",
            tagIcons::layout_bottombar_collapse));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar-expand",
            "TablerIcons.layout_bottombar_expand()",
            tagIcons::layout_bottombar_expand));
    icons.add(
        new IconCatalogEntry<>(
            "layout-cards", "TablerIcons.layout_cards()", tagIcons::layout_cards));
    icons.add(
        new IconCatalogEntry<>(
            "layout-collage", "TablerIcons.layout_collage()", tagIcons::layout_collage));
    icons.add(
        new IconCatalogEntry<>(
            "layout-columns", "TablerIcons.layout_columns()", tagIcons::layout_columns));
    icons.add(
        new IconCatalogEntry<>(
            "layout-dashboard",
            "TablerIcons.layout_dashboard()",
            tagIcons::layout_dashboard));
    icons.add(
        new IconCatalogEntry<>(
            "layout-distribute-horizontal",
            "TablerIcons.layout_distribute_horizontal()",
            tagIcons::layout_distribute_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "layout-distribute-vertical",
            "TablerIcons.layout_distribute_vertical()",
            tagIcons::layout_distribute_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "layout-grid", "TablerIcons.layout_grid()", tagIcons::layout_grid));
    icons.add(
        new IconCatalogEntry<>(
            "layout-grid-add",
            "TablerIcons.layout_grid_add()",
            tagIcons::layout_grid_add));
    icons.add(
        new IconCatalogEntry<>(
            "layout-grid-remove",
            "TablerIcons.layout_grid_remove()",
            tagIcons::layout_grid_remove));
    icons.add(
        new IconCatalogEntry<>(
            "layout-kanban", "TablerIcons.layout_kanban()", tagIcons::layout_kanban));
    icons.add(
        new IconCatalogEntry<>(
            "layout-list", "TablerIcons.layout_list()", tagIcons::layout_list));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar", "TablerIcons.layout_navbar()", tagIcons::layout_navbar));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar-collapse",
            "TablerIcons.layout_navbar_collapse()",
            tagIcons::layout_navbar_collapse));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar-expand",
            "TablerIcons.layout_navbar_expand()",
            tagIcons::layout_navbar_expand));
    icons.add(
        new IconCatalogEntry<>(
            "layout-off", "TablerIcons.layout_off()", tagIcons::layout_off));
    icons.add(
        new IconCatalogEntry<>(
            "layout-rows", "TablerIcons.layout_rows()", tagIcons::layout_rows));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar", "TablerIcons.layout_sidebar()", tagIcons::layout_sidebar));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-left-collapse",
            "TablerIcons.layout_sidebar_left_collapse()",
            tagIcons::layout_sidebar_left_collapse));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-left-expand",
            "TablerIcons.layout_sidebar_left_expand()",
            tagIcons::layout_sidebar_left_expand));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right",
            "TablerIcons.layout_sidebar_right()",
            tagIcons::layout_sidebar_right));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right-collapse",
            "TablerIcons.layout_sidebar_right_collapse()",
            tagIcons::layout_sidebar_right_collapse));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right-expand",
            "TablerIcons.layout_sidebar_right_expand()",
            tagIcons::layout_sidebar_right_expand));
    icons.add(new IconCatalogEntry<>("line", "TablerIcons.line()", tagIcons::line));
    icons.add(
        new IconCatalogEntry<>(
            "line-dashed", "TablerIcons.line_dashed()", tagIcons::line_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "line-dotted", "TablerIcons.line_dotted()", tagIcons::line_dotted));
    icons.add(new IconCatalogEntry<>("magnet", "TablerIcons.magnet()", tagIcons::magnet));
    icons.add(
        new IconCatalogEntry<>(
            "magnet-off", "TablerIcons.magnet_off()", tagIcons::magnet_off));
    icons.add(
        new IconCatalogEntry<>("magnetic", "TablerIcons.magnetic()", tagIcons::magnetic));
    icons.add(new IconCatalogEntry<>("mask", "TablerIcons.mask()", tagIcons::mask));
    icons.add(
        new IconCatalogEntry<>("mask-off", "TablerIcons.mask_off()", tagIcons::mask_off));
    icons.add(new IconCatalogEntry<>("mesh", "TablerIcons.mesh()", tagIcons::mesh));
    icons.add(new IconCatalogEntry<>("mickey", "TablerIcons.mickey()", tagIcons::mickey));
    icons.add(
        new IconCatalogEntry<>(
            "moustache", "TablerIcons.moustache()", tagIcons::moustache));
    icons.add(new IconCatalogEntry<>("needle", "TablerIcons.needle()", tagIcons::needle));
    icons.add(
        new IconCatalogEntry<>(
            "needle-thread", "TablerIcons.needle_thread()", tagIcons::needle_thread));
    icons.add(
        new IconCatalogEntry<>(
            "noise-reduction",
            "TablerIcons.noise_reduction()",
            tagIcons::noise_reduction));
    icons.add(new IconCatalogEntry<>("paint", "TablerIcons.paint()", tagIcons::paint));
    icons.add(
        new IconCatalogEntry<>(
            "paint-off", "TablerIcons.paint_off()", tagIcons::paint_off));
    icons.add(
        new IconCatalogEntry<>("palette", "TablerIcons.palette()", tagIcons::palette));
    icons.add(
        new IconCatalogEntry<>(
            "palette-off", "TablerIcons.palette_off()", tagIcons::palette_off));
    icons.add(new IconCatalogEntry<>("pencil", "TablerIcons.pencil()", tagIcons::pencil));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-ai", "TablerIcons.pencil_ai()", tagIcons::pencil_ai));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-bolt", "TablerIcons.pencil_bolt()", tagIcons::pencil_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-cancel", "TablerIcons.pencil_cancel()", tagIcons::pencil_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-check", "TablerIcons.pencil_check()", tagIcons::pencil_check));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-code", "TablerIcons.pencil_code()", tagIcons::pencil_code));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-cog", "TablerIcons.pencil_cog()", tagIcons::pencil_cog));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-discount",
            "TablerIcons.pencil_discount()",
            tagIcons::pencil_discount));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-dollar", "TablerIcons.pencil_dollar()", tagIcons::pencil_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-down", "TablerIcons.pencil_down()", tagIcons::pencil_down));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-exclamation",
            "TablerIcons.pencil_exclamation()",
            tagIcons::pencil_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-heart", "TablerIcons.pencil_heart()", tagIcons::pencil_heart));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-minus", "TablerIcons.pencil_minus()", tagIcons::pencil_minus));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-off", "TablerIcons.pencil_off()", tagIcons::pencil_off));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-pause", "TablerIcons.pencil_pause()", tagIcons::pencil_pause));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-pin", "TablerIcons.pencil_pin()", tagIcons::pencil_pin));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-plus", "TablerIcons.pencil_plus()", tagIcons::pencil_plus));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-question",
            "TablerIcons.pencil_question()",
            tagIcons::pencil_question));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-search", "TablerIcons.pencil_search()", tagIcons::pencil_search));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-share", "TablerIcons.pencil_share()", tagIcons::pencil_share));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-star", "TablerIcons.pencil_star()", tagIcons::pencil_star));
    icons.add(
        new IconCatalogEntry<>(
            "pencil-up", "TablerIcons.pencil_up()", tagIcons::pencil_up));
    icons.add(
        new IconCatalogEntry<>("pencil-x", "TablerIcons.pencil_x()", tagIcons::pencil_x));
    icons.add(
        new IconCatalogEntry<>(
            "pentagram", "TablerIcons.pentagram()", tagIcons::pentagram));
    icons.add(
        new IconCatalogEntry<>(
            "placeholder", "TablerIcons.placeholder()", tagIcons::placeholder));
    icons.add(
        new IconCatalogEntry<>("polygon", "TablerIcons.polygon()", tagIcons::polygon));
    icons.add(
        new IconCatalogEntry<>(
            "polygon-off", "TablerIcons.polygon_off()", tagIcons::polygon_off));
    icons.add(new IconCatalogEntry<>("prong", "TablerIcons.prong()", tagIcons::prong));
    icons.add(
        new IconCatalogEntry<>(
            "radius-bottom-left",
            "TablerIcons.radius_bottom_left()",
            tagIcons::radius_bottom_left));
    icons.add(
        new IconCatalogEntry<>(
            "radius-bottom-right",
            "TablerIcons.radius_bottom_right()",
            tagIcons::radius_bottom_right));
    icons.add(
        new IconCatalogEntry<>(
            "radius-top-left",
            "TablerIcons.radius_top_left()",
            tagIcons::radius_top_left));
    icons.add(
        new IconCatalogEntry<>(
            "radius-top-right",
            "TablerIcons.radius_top_right()",
            tagIcons::radius_top_right));
    icons.add(
        new IconCatalogEntry<>(
            "reference-image",
            "TablerIcons.reference_image()",
            tagIcons::reference_image));
    icons.add(new IconCatalogEntry<>("resize", "TablerIcons.resize()", tagIcons::resize));
    icons.add(new IconCatalogEntry<>("ruler", "TablerIcons.ruler()", tagIcons::ruler));
    icons.add(
        new IconCatalogEntry<>("ruler-2", "TablerIcons.ruler_2()", tagIcons::ruler_2));
    icons.add(
        new IconCatalogEntry<>(
            "ruler-2-off", "TablerIcons.ruler_2_off()", tagIcons::ruler_2_off));
    icons.add(
        new IconCatalogEntry<>("ruler-3", "TablerIcons.ruler_3()", tagIcons::ruler_3));
    icons.add(
        new IconCatalogEntry<>(
            "ruler-measure", "TablerIcons.ruler_measure()", tagIcons::ruler_measure));
    icons.add(
        new IconCatalogEntry<>(
            "ruler-measure-2",
            "TablerIcons.ruler_measure_2()",
            tagIcons::ruler_measure_2));
    icons.add(
        new IconCatalogEntry<>(
            "ruler-off", "TablerIcons.ruler_off()", tagIcons::ruler_off));
    icons.add(
        new IconCatalogEntry<>("scissors", "TablerIcons.scissors()", tagIcons::scissors));
    icons.add(
        new IconCatalogEntry<>(
            "scissors-off", "TablerIcons.scissors_off()", tagIcons::scissors_off));
    icons.add(
        new IconCatalogEntry<>("section", "TablerIcons.section()", tagIcons::section));
    icons.add(new IconCatalogEntry<>("shape", "TablerIcons.shape()", tagIcons::shape));
    icons.add(
        new IconCatalogEntry<>("shape-2", "TablerIcons.shape_2()", tagIcons::shape_2));
    icons.add(
        new IconCatalogEntry<>("shape-3", "TablerIcons.shape_3()", tagIcons::shape_3));
  }

  private static void addIcons3() {
    icons.add(
        new IconCatalogEntry<>(
            "shape-off", "TablerIcons.shape_off()", tagIcons::shape_off));
    icons.add(new IconCatalogEntry<>("shovel", "TablerIcons.shovel()", tagIcons::shovel));
    icons.add(
        new IconCatalogEntry<>(
            "shovel-pitchforks",
            "TablerIcons.shovel_pitchforks()",
            tagIcons::shovel_pitchforks));
    icons.add(
        new IconCatalogEntry<>(
            "sketching", "TablerIcons.sketching()", tagIcons::sketching));
    icons.add(new IconCatalogEntry<>("slice", "TablerIcons.slice()", tagIcons::slice));
    icons.add(
        new IconCatalogEntry<>("sparkle", "TablerIcons.sparkle()", tagIcons::sparkle));
    icons.add(
        new IconCatalogEntry<>(
            "sparkle-2", "TablerIcons.sparkle_2()", tagIcons::sparkle_2));
    icons.add(
        new IconCatalogEntry<>(
            "sparkle-highlight",
            "TablerIcons.sparkle_highlight()",
            tagIcons::sparkle_highlight));
    icons.add(
        new IconCatalogEntry<>(
            "sparkles-2", "TablerIcons.sparkles_2()", tagIcons::sparkles_2));
    icons.add(
        new IconCatalogEntry<>(
            "sparkles-2-off", "TablerIcons.sparkles_2_off()", tagIcons::sparkles_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "square-half", "TablerIcons.square_half()", tagIcons::square_half));
    icons.add(
        new IconCatalogEntry<>(
            "square-toggle", "TablerIcons.square_toggle()", tagIcons::square_toggle));
    icons.add(
        new IconCatalogEntry<>(
            "square-toggle-horizontal",
            "TablerIcons.square_toggle_horizontal()",
            tagIcons::square_toggle_horizontal));
    icons.add(
        new IconCatalogEntry<>("squares", "TablerIcons.squares()", tagIcons::squares));
    icons.add(
        new IconCatalogEntry<>(
            "squares-diagonal",
            "TablerIcons.squares_diagonal()",
            tagIcons::squares_diagonal));
    icons.add(new IconCatalogEntry<>("stack", "TablerIcons.stack()", tagIcons::stack));
    icons.add(
        new IconCatalogEntry<>("stack-2", "TablerIcons.stack_2()", tagIcons::stack_2));
    icons.add(
        new IconCatalogEntry<>("stack-3", "TablerIcons.stack_3()", tagIcons::stack_3));
    icons.add(
        new IconCatalogEntry<>(
            "stack-check", "TablerIcons.stack_check()", tagIcons::stack_check));
    icons.add(
        new IconCatalogEntry<>(
            "stack-minus", "TablerIcons.stack_minus()", tagIcons::stack_minus));
    icons.add(
        new IconCatalogEntry<>(
            "stack-plus", "TablerIcons.stack_plus()", tagIcons::stack_plus));
    icons.add(
        new IconCatalogEntry<>(
            "stack-pop", "TablerIcons.stack_pop()", tagIcons::stack_pop));
    icons.add(
        new IconCatalogEntry<>(
            "stack-push", "TablerIcons.stack_push()", tagIcons::stack_push));
    icons.add(
        new IconCatalogEntry<>("stack-x", "TablerIcons.stack_x()", tagIcons::stack_x));
    icons.add(
        new IconCatalogEntry<>("sticker", "TablerIcons.sticker()", tagIcons::sticker));
    icons.add(
        new IconCatalogEntry<>(
            "sticker-2", "TablerIcons.sticker_2()", tagIcons::sticker_2));
    icons.add(
        new IconCatalogEntry<>(
            "sticker-smile", "TablerIcons.sticker_smile()", tagIcons::sticker_smile));
    icons.add(
        new IconCatalogEntry<>(
            "stroke-curved", "TablerIcons.stroke_curved()", tagIcons::stroke_curved));
    icons.add(
        new IconCatalogEntry<>(
            "stroke-dynamic", "TablerIcons.stroke_dynamic()", tagIcons::stroke_dynamic));
    icons.add(
        new IconCatalogEntry<>(
            "stroke-straight",
            "TablerIcons.stroke_straight()",
            tagIcons::stroke_straight));
    icons.add(
        new IconCatalogEntry<>("template", "TablerIcons.template()", tagIcons::template));
    icons.add(
        new IconCatalogEntry<>(
            "template-off", "TablerIcons.template_off()", tagIcons::template_off));
    icons.add(
        new IconCatalogEntry<>(
            "text-resize", "TablerIcons.text_resize()", tagIcons::text_resize));
    icons.add(new IconCatalogEntry<>("tools", "TablerIcons.tools()", tagIcons::tools));
    icons.add(
        new IconCatalogEntry<>(
            "tools-off", "TablerIcons.tools_off()", tagIcons::tools_off));
    icons.add(
        new IconCatalogEntry<>("trident", "TablerIcons.trident()", tagIcons::trident));
    icons.add(
        new IconCatalogEntry<>("typeface", "TablerIcons.typeface()", tagIcons::typeface));
    icons.add(
        new IconCatalogEntry<>(
            "ux-circle", "TablerIcons.ux_circle()", tagIcons::ux_circle));
    icons.add(new IconCatalogEntry<>("vector", "TablerIcons.vector()", tagIcons::vector));
    icons.add(
        new IconCatalogEntry<>(
            "vector-bezier", "TablerIcons.vector_bezier()", tagIcons::vector_bezier));
    icons.add(
        new IconCatalogEntry<>(
            "vector-bezier-2",
            "TablerIcons.vector_bezier_2()",
            tagIcons::vector_bezier_2));
    icons.add(
        new IconCatalogEntry<>(
            "vector-bezier-arc",
            "TablerIcons.vector_bezier_arc()",
            tagIcons::vector_bezier_arc));
    icons.add(
        new IconCatalogEntry<>(
            "vector-bezier-circle",
            "TablerIcons.vector_bezier_circle()",
            tagIcons::vector_bezier_circle));
    icons.add(
        new IconCatalogEntry<>(
            "vector-off", "TablerIcons.vector_off()", tagIcons::vector_off));
    icons.add(
        new IconCatalogEntry<>(
            "vector-spline", "TablerIcons.vector_spline()", tagIcons::vector_spline));
    icons.add(
        new IconCatalogEntry<>(
            "vector-triangle",
            "TablerIcons.vector_triangle()",
            tagIcons::vector_triangle));
    icons.add(
        new IconCatalogEntry<>(
            "vector-triangle-off",
            "TablerIcons.vector_triangle_off()",
            tagIcons::vector_triangle_off));
    icons.add(
        new IconCatalogEntry<>("vignette", "TablerIcons.vignette()", tagIcons::vignette));
    icons.add(new IconCatalogEntry<>("wheel", "TablerIcons.wheel()", tagIcons::wheel));
    icons.add(new IconCatalogEntry<>("yarn", "TablerIcons.yarn()", tagIcons::yarn));
    icons.add(
        new IconCatalogEntry<>(
            "content-cut", "TablerIcons.cut()", tagIcons::content_cut));
    icons.add(
        new IconCatalogEntry<>(
            "dock-left",
            "TablerIcons.layout_sidebar_left_collapse()",
            tagIcons::dock_left));
    icons.add(
        new IconCatalogEntry<>(
            "dock-right",
            "TablerIcons.layout_sidebar_right_collapse()",
            tagIcons::dock_right));
    icons.add(
        new IconCatalogEntry<>(
            "format-color-text",
            "TablerIcons.color_swatch()",
            tagIcons::format_color_text));
    icons.add(
        new IconCatalogEntry<>(
            "menu-open",
            "TablerIcons.layout_sidebar_left_expand()",
            tagIcons::menu_open));
    icons.add(
        new IconCatalogEntry<>("ad", "TablerIcons.ad_filled()", tagIcons::ad_filled));
    icons.add(
        new IconCatalogEntry<>(
            "artboard", "TablerIcons.artboard_filled()", tagIcons::artboard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "barrier-block",
            "TablerIcons.barrier_block_filled()",
            tagIcons::barrier_block_filled));
    icons.add(
        new IconCatalogEntry<>(
            "binoculars", "TablerIcons.binoculars_filled()", tagIcons::binoculars_filled));
    icons.add(
        new IconCatalogEntry<>(
            "blade", "TablerIcons.blade_filled()", tagIcons::blade_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bolt", "TablerIcons.bolt_filled()", tagIcons::bolt_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bomb", "TablerIcons.bomb_filled()", tagIcons::bomb_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bong", "TablerIcons.bong_filled()", tagIcons::bong_filled));
    icons.add(
        new IconCatalogEntry<>(
            "boom", "TablerIcons.boom_filled()", tagIcons::boom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bounce-left",
            "TablerIcons.bounce_left_filled()",
            tagIcons::bounce_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bounce-right",
            "TablerIcons.bounce_right_filled()",
            tagIcons::bounce_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom",
            "TablerIcons.box_align_bottom_filled()",
            tagIcons::box_align_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom-left",
            "TablerIcons.box_align_bottom_left_filled()",
            tagIcons::box_align_bottom_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-bottom-right",
            "TablerIcons.box_align_bottom_right_filled()",
            tagIcons::box_align_bottom_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-left",
            "TablerIcons.box_align_left_filled()",
            tagIcons::box_align_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-right",
            "TablerIcons.box_align_right_filled()",
            tagIcons::box_align_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top",
            "TablerIcons.box_align_top_filled()",
            tagIcons::box_align_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top-left",
            "TablerIcons.box_align_top_left_filled()",
            tagIcons::box_align_top_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-align-top-right",
            "TablerIcons.box_align_top_right_filled()",
            tagIcons::box_align_top_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "box-multiple",
            "TablerIcons.box_multiple_filled()",
            tagIcons::box_multiple_filled));
    icons.add(
        new IconCatalogEntry<>(
            "briefcase", "TablerIcons.briefcase_filled()", tagIcons::briefcase_filled));
    icons.add(
        new IconCatalogEntry<>(
            "briefcase-2",
            "TablerIcons.briefcase_2_filled()",
            tagIcons::briefcase_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bulb", "TablerIcons.bulb_filled()", tagIcons::bulb_filled));
    icons.add(
        new IconCatalogEntry<>(
            "candle", "TablerIcons.candle_filled()", tagIcons::candle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cards", "TablerIcons.cards_filled()", tagIcons::cards_filled));
    icons.add(
        new IconCatalogEntry<>(
            "carousel-horizontal",
            "TablerIcons.carousel_horizontal_filled()",
            tagIcons::carousel_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "carousel-vertical",
            "TablerIcons.carousel_vertical_filled()",
            tagIcons::carousel_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "confetti", "TablerIcons.confetti_filled()", tagIcons::confetti_filled));
    icons.add(
        new IconCatalogEntry<>(
            "container", "TablerIcons.container_filled()", tagIcons::container_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cookie-man", "TablerIcons.cookie_man_filled()", tagIcons::cookie_man_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-1-1", "TablerIcons.crop_1_1_filled()", tagIcons::crop_1_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-16-9", "TablerIcons.crop_16_9_filled()", tagIcons::crop_16_9_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-3-2", "TablerIcons.crop_3_2_filled()", tagIcons::crop_3_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-5-4", "TablerIcons.crop_5_4_filled()", tagIcons::crop_5_4_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-7-5", "TablerIcons.crop_7_5_filled()", tagIcons::crop_7_5_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-landscape",
            "TablerIcons.crop_landscape_filled()",
            tagIcons::crop_landscape_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crop-portrait",
            "TablerIcons.crop_portrait_filled()",
            tagIcons::crop_portrait_filled));
    icons.add(
        new IconCatalogEntry<>(
            "crown", "TablerIcons.crown_filled()", tagIcons::crown_filled));
    icons.add(
        new IconCatalogEntry<>(
            "droplet", "TablerIcons.droplet_filled()", tagIcons::droplet_filled));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-half",
            "TablerIcons.droplet_half_filled()",
            tagIcons::droplet_half_filled));
    icons.add(
        new IconCatalogEntry<>(
            "droplet-half-2",
            "TablerIcons.droplet_half_2_filled()",
            tagIcons::droplet_half_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ease-in-control-point",
            "TablerIcons.ease_in_control_point_filled()",
            tagIcons::ease_in_control_point_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ease-in-out-control-points",
            "TablerIcons.ease_in_out_control_points_filled()",
            tagIcons::ease_in_out_control_points_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ease-out-control-point",
            "TablerIcons.ease_out_control_point_filled()",
            tagIcons::ease_out_control_point_filled));
    icons.add(
        new IconCatalogEntry<>(
            "edit", "TablerIcons.edit_filled()", tagIcons::edit_filled));
  }

  private static void addIcons4() {
    icons.add(
        new IconCatalogEntry<>(
            "favicon", "TablerIcons.favicon_filled()", tagIcons::favicon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "guitar-pick",
            "TablerIcons.guitar_pick_filled()",
            tagIcons::guitar_pick_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom",
            "TablerIcons.inner_shadow_bottom_filled()",
            tagIcons::inner_shadow_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom-left",
            "TablerIcons.inner_shadow_bottom_left_filled()",
            tagIcons::inner_shadow_bottom_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-bottom-right",
            "TablerIcons.inner_shadow_bottom_right_filled()",
            tagIcons::inner_shadow_bottom_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-left",
            "TablerIcons.inner_shadow_left_filled()",
            tagIcons::inner_shadow_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-right",
            "TablerIcons.inner_shadow_right_filled()",
            tagIcons::inner_shadow_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top",
            "TablerIcons.inner_shadow_top_filled()",
            tagIcons::inner_shadow_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top-left",
            "TablerIcons.inner_shadow_top_left_filled()",
            tagIcons::inner_shadow_top_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "inner-shadow-top-right",
            "TablerIcons.inner_shadow_top_right_filled()",
            tagIcons::inner_shadow_top_right_filled));
    icons.add(
        new IconCatalogEntry<>("key", "TablerIcons.key_filled()", tagIcons::key_filled));
    icons.add(
        new IconCatalogEntry<>(
            "lasso-polygon",
            "TablerIcons.lasso_polygon_filled()",
            tagIcons::lasso_polygon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath",
            "TablerIcons.laurel_wreath_filled()",
            tagIcons::laurel_wreath_filled));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-1",
            "TablerIcons.laurel_wreath_1_filled()",
            tagIcons::laurel_wreath_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-2",
            "TablerIcons.laurel_wreath_2_filled()",
            tagIcons::laurel_wreath_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "laurel-wreath-3",
            "TablerIcons.laurel_wreath_3_filled()",
            tagIcons::laurel_wreath_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout", "TablerIcons.layout_filled()", tagIcons::layout_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-2", "TablerIcons.layout_2_filled()", tagIcons::layout_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-bottom",
            "TablerIcons.layout_align_bottom_filled()",
            tagIcons::layout_align_bottom_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-center",
            "TablerIcons.layout_align_center_filled()",
            tagIcons::layout_align_center_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-left",
            "TablerIcons.layout_align_left_filled()",
            tagIcons::layout_align_left_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-middle",
            "TablerIcons.layout_align_middle_filled()",
            tagIcons::layout_align_middle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-right",
            "TablerIcons.layout_align_right_filled()",
            tagIcons::layout_align_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-align-top",
            "TablerIcons.layout_align_top_filled()",
            tagIcons::layout_align_top_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-board",
            "TablerIcons.layout_board_filled()",
            tagIcons::layout_board_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-board-split",
            "TablerIcons.layout_board_split_filled()",
            tagIcons::layout_board_split_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar",
            "TablerIcons.layout_bottombar_filled()",
            tagIcons::layout_bottombar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar-collapse",
            "TablerIcons.layout_bottombar_collapse_filled()",
            tagIcons::layout_bottombar_collapse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-bottombar-expand",
            "TablerIcons.layout_bottombar_expand_filled()",
            tagIcons::layout_bottombar_expand_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-cards",
            "TablerIcons.layout_cards_filled()",
            tagIcons::layout_cards_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-dashboard",
            "TablerIcons.layout_dashboard_filled()",
            tagIcons::layout_dashboard_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-distribute-horizontal",
            "TablerIcons.layout_distribute_horizontal_filled()",
            tagIcons::layout_distribute_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-distribute-vertical",
            "TablerIcons.layout_distribute_vertical_filled()",
            tagIcons::layout_distribute_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-grid",
            "TablerIcons.layout_grid_filled()",
            tagIcons::layout_grid_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-kanban",
            "TablerIcons.layout_kanban_filled()",
            tagIcons::layout_kanban_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-list",
            "TablerIcons.layout_list_filled()",
            tagIcons::layout_list_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar",
            "TablerIcons.layout_navbar_filled()",
            tagIcons::layout_navbar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar-collapse",
            "TablerIcons.layout_navbar_collapse_filled()",
            tagIcons::layout_navbar_collapse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-navbar-expand",
            "TablerIcons.layout_navbar_expand_filled()",
            tagIcons::layout_navbar_expand_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar",
            "TablerIcons.layout_sidebar_filled()",
            tagIcons::layout_sidebar_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-left-collapse",
            "TablerIcons.layout_sidebar_left_collapse_filled()",
            tagIcons::layout_sidebar_left_collapse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-left-expand",
            "TablerIcons.layout_sidebar_left_expand_filled()",
            tagIcons::layout_sidebar_left_expand_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right",
            "TablerIcons.layout_sidebar_right_filled()",
            tagIcons::layout_sidebar_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right-collapse",
            "TablerIcons.layout_sidebar_right_collapse_filled()",
            tagIcons::layout_sidebar_right_collapse_filled));
    icons.add(
        new IconCatalogEntry<>(
            "layout-sidebar-right-expand",
            "TablerIcons.layout_sidebar_right_expand_filled()",
            tagIcons::layout_sidebar_right_expand_filled));
    icons.add(
        new IconCatalogEntry<>(
            "magnet", "TablerIcons.magnet_filled()", tagIcons::magnet_filled));
    icons.add(
        new IconCatalogEntry<>(
            "mickey", "TablerIcons.mickey_filled()", tagIcons::mickey_filled));
    icons.add(
        new IconCatalogEntry<>(
            "paint", "TablerIcons.paint_filled()", tagIcons::paint_filled));
    icons.add(
        new IconCatalogEntry<>(
            "palette", "TablerIcons.palette_filled()", tagIcons::palette_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pencil", "TablerIcons.pencil_filled()", tagIcons::pencil_filled));
    icons.add(
        new IconCatalogEntry<>(
            "section", "TablerIcons.section_filled()", tagIcons::section_filled));
    icons.add(
        new IconCatalogEntry<>(
            "sparkles-2", "TablerIcons.sparkles_2_filled()", tagIcons::sparkles_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "squares", "TablerIcons.squares_filled()", tagIcons::squares_filled));
    icons.add(
        new IconCatalogEntry<>(
            "stack", "TablerIcons.stack_filled()", tagIcons::stack_filled));
    icons.add(
        new IconCatalogEntry<>(
            "stack-2", "TablerIcons.stack_2_filled()", tagIcons::stack_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "stack-3", "TablerIcons.stack_3_filled()", tagIcons::stack_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "template", "TablerIcons.template_filled()", tagIcons::template_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
