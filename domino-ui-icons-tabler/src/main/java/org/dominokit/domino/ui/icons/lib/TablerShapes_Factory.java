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
import org.dominokit.domino.ui.icons.TablerShapes;

/** Static icon factory for the Tabler Shapes category. */
public final class TablerShapes_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerShapes tagIcons = new TablerShapes() {};

  static {
    addIcons0();
    addIcons1();
    addIcons2();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "border-corner-ios",
            "TablerIcons.border_corner_ios()",
            tagIcons::border_corner_ios));
    icons.add(new IconCatalogEntry<>("cancel", "TablerIcons.cancel()", tagIcons::cancel));
    icons.add(
        new IconCatalogEntry<>("capsule", "TablerIcons.capsule()", tagIcons::capsule));
    icons.add(
        new IconCatalogEntry<>(
            "capsule-horizontal",
            "TablerIcons.capsule_horizontal()",
            tagIcons::capsule_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left-right",
            "TablerIcons.caret_left_right()",
            tagIcons::caret_left_right));
    icons.add(
        new IconCatalogEntry<>("category", "TablerIcons.category()", tagIcons::category));
    icons.add(
        new IconCatalogEntry<>(
            "category-2", "TablerIcons.category_2()", tagIcons::category_2));
    icons.add(
        new IconCatalogEntry<>(
            "category-minus", "TablerIcons.category_minus()", tagIcons::category_minus));
    icons.add(
        new IconCatalogEntry<>(
            "category-plus", "TablerIcons.category_plus()", tagIcons::category_plus));
    icons.add(new IconCatalogEntry<>("circle", "TablerIcons.circle()", tagIcons::circle));
    icons.add(
        new IconCatalogEntry<>(
            "circle-asterisk",
            "TablerIcons.circle_asterisk()",
            tagIcons::circle_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "circle-check", "TablerIcons.circle_check()", tagIcons::circle_check));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed", "TablerIcons.circle_dashed()", tagIcons::circle_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-check",
            "TablerIcons.circle_dashed_check()",
            tagIcons::circle_dashed_check));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-minus",
            "TablerIcons.circle_dashed_minus()",
            tagIcons::circle_dashed_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-percentage",
            "TablerIcons.circle_dashed_percentage()",
            tagIcons::circle_dashed_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-plus",
            "TablerIcons.circle_dashed_plus()",
            tagIcons::circle_dashed_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-x",
            "TablerIcons.circle_dashed_x()",
            tagIcons::circle_dashed_x));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dot", "TablerIcons.circle_dot()", tagIcons::circle_dot));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dotted", "TablerIcons.circle_dotted()", tagIcons::circle_dotted));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half", "TablerIcons.circle_half()", tagIcons::circle_half));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half-2", "TablerIcons.circle_half_2()", tagIcons::circle_half_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half-vertical",
            "TablerIcons.circle_half_vertical()",
            tagIcons::circle_half_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "circle-heart", "TablerIcons.circle_heart()", tagIcons::circle_heart));
    icons.add(
        new IconCatalogEntry<>(
            "circle-key", "TablerIcons.circle_key()", tagIcons::circle_key));
    icons.add(
        new IconCatalogEntry<>(
            "circle-minus", "TablerIcons.circle_minus()", tagIcons::circle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-minus-2", "TablerIcons.circle_minus_2()", tagIcons::circle_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-off", "TablerIcons.circle_off()", tagIcons::circle_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-percentage",
            "TablerIcons.circle_percentage()",
            tagIcons::circle_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus", "TablerIcons.circle_plus()", tagIcons::circle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus-2", "TablerIcons.circle_plus_2()", tagIcons::circle_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus-minus",
            "TablerIcons.circle_plus_minus()",
            tagIcons::circle_plus_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle",
            "TablerIcons.circle_rectangle()",
            tagIcons::circle_rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle-off",
            "TablerIcons.circle_rectangle_off()",
            tagIcons::circle_rectangle_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-square", "TablerIcons.circle_square()", tagIcons::circle_square));
    icons.add(
        new IconCatalogEntry<>(
            "circle-triangle",
            "TablerIcons.circle_triangle()",
            tagIcons::circle_triangle));
    icons.add(
        new IconCatalogEntry<>("circle-x", "TablerIcons.circle_x()", tagIcons::circle_x));
    icons.add(
        new IconCatalogEntry<>("circles", "TablerIcons.circles()", tagIcons::circles));
    icons.add(
        new IconCatalogEntry<>(
            "circles-relation",
            "TablerIcons.circles_relation()",
            tagIcons::circles_relation));
    icons.add(new IconCatalogEntry<>("clubs", "TablerIcons.clubs()", tagIcons::clubs));
    icons.add(new IconCatalogEntry<>("cone", "TablerIcons.cone()", tagIcons::cone));
    icons.add(new IconCatalogEntry<>("cone-2", "TablerIcons.cone_2()", tagIcons::cone_2));
    icons.add(
        new IconCatalogEntry<>("cone-off", "TablerIcons.cone_off()", tagIcons::cone_off));
    icons.add(
        new IconCatalogEntry<>(
            "cone-plus", "TablerIcons.cone_plus()", tagIcons::cone_plus));
    icons.add(new IconCatalogEntry<>("cube", "TablerIcons.cube()", tagIcons::cube));
    icons.add(
        new IconCatalogEntry<>("cube-off", "TablerIcons.cube_off()", tagIcons::cube_off));
    icons.add(
        new IconCatalogEntry<>(
            "cube-plus", "TablerIcons.cube_plus()", tagIcons::cube_plus));
    icons.add(
        new IconCatalogEntry<>(
            "cube-spark", "TablerIcons.cube_spark()", tagIcons::cube_spark));
    icons.add(
        new IconCatalogEntry<>("cylinder", "TablerIcons.cylinder()", tagIcons::cylinder));
    icons.add(
        new IconCatalogEntry<>(
            "cylinder-off", "TablerIcons.cylinder_off()", tagIcons::cylinder_off));
    icons.add(
        new IconCatalogEntry<>(
            "cylinder-plus", "TablerIcons.cylinder_plus()", tagIcons::cylinder_plus));
    icons.add(
        new IconCatalogEntry<>("diabolo", "TablerIcons.diabolo()", tagIcons::diabolo));
    icons.add(
        new IconCatalogEntry<>(
            "diabolo-off", "TablerIcons.diabolo_off()", tagIcons::diabolo_off));
    icons.add(
        new IconCatalogEntry<>(
            "diabolo-plus", "TablerIcons.diabolo_plus()", tagIcons::diabolo_plus));
    icons.add(
        new IconCatalogEntry<>("diamond", "TablerIcons.diamond()", tagIcons::diamond));
    icons.add(
        new IconCatalogEntry<>(
            "diamond-off", "TablerIcons.diamond_off()", tagIcons::diamond_off));
    icons.add(
        new IconCatalogEntry<>("diamonds", "TablerIcons.diamonds()", tagIcons::diamonds));
    icons.add(
        new IconCatalogEntry<>("frustum", "TablerIcons.frustum()", tagIcons::frustum));
    icons.add(
        new IconCatalogEntry<>(
            "frustum-off", "TablerIcons.frustum_off()", tagIcons::frustum_off));
    icons.add(
        new IconCatalogEntry<>(
            "frustum-plus", "TablerIcons.frustum_plus()", tagIcons::frustum_plus));
    icons.add(new IconCatalogEntry<>("heart", "TablerIcons.heart()", tagIcons::heart));
    icons.add(
        new IconCatalogEntry<>(
            "heart-bolt", "TablerIcons.heart_bolt()", tagIcons::heart_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "heart-cancel", "TablerIcons.heart_cancel()", tagIcons::heart_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "heart-check", "TablerIcons.heart_check()", tagIcons::heart_check));
    icons.add(
        new IconCatalogEntry<>(
            "heart-code", "TablerIcons.heart_code()", tagIcons::heart_code));
    icons.add(
        new IconCatalogEntry<>(
            "heart-cog", "TablerIcons.heart_cog()", tagIcons::heart_cog));
    icons.add(
        new IconCatalogEntry<>(
            "heart-dollar", "TablerIcons.heart_dollar()", tagIcons::heart_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "heart-down", "TablerIcons.heart_down()", tagIcons::heart_down));
    icons.add(
        new IconCatalogEntry<>(
            "heart-exclamation",
            "TablerIcons.heart_exclamation()",
            tagIcons::heart_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "heart-minus", "TablerIcons.heart_minus()", tagIcons::heart_minus));
    icons.add(
        new IconCatalogEntry<>(
            "heart-off", "TablerIcons.heart_off()", tagIcons::heart_off));
    icons.add(
        new IconCatalogEntry<>(
            "heart-pause", "TablerIcons.heart_pause()", tagIcons::heart_pause));
    icons.add(
        new IconCatalogEntry<>(
            "heart-pin", "TablerIcons.heart_pin()", tagIcons::heart_pin));
    icons.add(
        new IconCatalogEntry<>(
            "heart-plus", "TablerIcons.heart_plus()", tagIcons::heart_plus));
    icons.add(
        new IconCatalogEntry<>(
            "heart-question", "TablerIcons.heart_question()", tagIcons::heart_question));
    icons.add(
        new IconCatalogEntry<>(
            "heart-search", "TablerIcons.heart_search()", tagIcons::heart_search));
    icons.add(
        new IconCatalogEntry<>(
            "heart-share", "TablerIcons.heart_share()", tagIcons::heart_share));
    icons.add(
        new IconCatalogEntry<>(
            "heart-spark", "TablerIcons.heart_spark()", tagIcons::heart_spark));
    icons.add(
        new IconCatalogEntry<>(
            "heart-star", "TablerIcons.heart_star()", tagIcons::heart_star));
    icons.add(
        new IconCatalogEntry<>("heart-up", "TablerIcons.heart_up()", tagIcons::heart_up));
    icons.add(
        new IconCatalogEntry<>("heart-x", "TablerIcons.heart_x()", tagIcons::heart_x));
    icons.add(new IconCatalogEntry<>("hearts", "TablerIcons.hearts()", tagIcons::hearts));
    icons.add(
        new IconCatalogEntry<>(
            "hearts-off", "TablerIcons.hearts_off()", tagIcons::hearts_off));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere", "TablerIcons.hemisphere()", tagIcons::hemisphere));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere-off", "TablerIcons.hemisphere_off()", tagIcons::hemisphere_off));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere-plus",
            "TablerIcons.hemisphere_plus()",
            tagIcons::hemisphere_plus));
    icons.add(
        new IconCatalogEntry<>("hexagon", "TablerIcons.hexagon()", tagIcons::hexagon));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-3d", "TablerIcons.hexagon_3d()", tagIcons::hexagon_3d));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-asterisk",
            "TablerIcons.hexagon_asterisk()",
            tagIcons::hexagon_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus", "TablerIcons.hexagon_minus()", tagIcons::hexagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus-2",
            "TablerIcons.hexagon_minus_2()",
            tagIcons::hexagon_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-off", "TablerIcons.hexagon_off()", tagIcons::hexagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus", "TablerIcons.hexagon_plus()", tagIcons::hexagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus-2", "TablerIcons.hexagon_plus_2()", tagIcons::hexagon_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism",
            "TablerIcons.hexagonal_prism()",
            tagIcons::hexagonal_prism));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism-off",
            "TablerIcons.hexagonal_prism_off()",
            tagIcons::hexagonal_prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism-plus",
            "TablerIcons.hexagonal_prism_plus()",
            tagIcons::hexagonal_prism_plus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid",
            "TablerIcons.hexagonal_pyramid()",
            tagIcons::hexagonal_pyramid));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid-off",
            "TablerIcons.hexagonal_pyramid_off()",
            tagIcons::hexagonal_pyramid_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid-plus",
            "TablerIcons.hexagonal_pyramid_plus()",
            tagIcons::hexagonal_pyramid_plus));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>("hexagons", "TablerIcons.hexagons()", tagIcons::hexagons));
    icons.add(
        new IconCatalogEntry<>(
            "hexagons-off", "TablerIcons.hexagons_off()", tagIcons::hexagons_off));
    icons.add(new IconCatalogEntry<>("icons", "TablerIcons.icons()", tagIcons::icons));
    icons.add(
        new IconCatalogEntry<>(
            "icons-off", "TablerIcons.icons_off()", tagIcons::icons_off));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron",
            "TablerIcons.irregular_polyhedron()",
            tagIcons::irregular_polyhedron));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron-off",
            "TablerIcons.irregular_polyhedron_off()",
            tagIcons::irregular_polyhedron_off));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron-plus",
            "TablerIcons.irregular_polyhedron_plus()",
            tagIcons::irregular_polyhedron_plus));
    icons.add(
        new IconCatalogEntry<>(
            "jewish-star", "TablerIcons.jewish_star()", tagIcons::jewish_star));
    icons.add(
        new IconCatalogEntry<>("octagon", "TablerIcons.octagon()", tagIcons::octagon));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus", "TablerIcons.octagon_minus()", tagIcons::octagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus-2",
            "TablerIcons.octagon_minus_2()",
            tagIcons::octagon_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-off", "TablerIcons.octagon_off()", tagIcons::octagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus", "TablerIcons.octagon_plus()", tagIcons::octagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus-2", "TablerIcons.octagon_plus_2()", tagIcons::octagon_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron", "TablerIcons.octahedron()", tagIcons::octahedron));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron-off", "TablerIcons.octahedron_off()", tagIcons::octahedron_off));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron-plus",
            "TablerIcons.octahedron_plus()",
            tagIcons::octahedron_plus));
    icons.add(new IconCatalogEntry<>("oval", "TablerIcons.oval()", tagIcons::oval));
    icons.add(
        new IconCatalogEntry<>(
            "oval-vertical", "TablerIcons.oval_vertical()", tagIcons::oval_vertical));
    icons.add(
        new IconCatalogEntry<>("pentagon", "TablerIcons.pentagon()", tagIcons::pentagon));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-minus", "TablerIcons.pentagon_minus()", tagIcons::pentagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-off", "TablerIcons.pentagon_off()", tagIcons::pentagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-plus", "TablerIcons.pentagon_plus()", tagIcons::pentagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-x", "TablerIcons.pentagon_x()", tagIcons::pentagon_x));
    icons.add(
        new IconCatalogEntry<>(
            "perspective", "TablerIcons.perspective()", tagIcons::perspective));
    icons.add(
        new IconCatalogEntry<>(
            "perspective-off",
            "TablerIcons.perspective_off()",
            tagIcons::perspective_off));
    icons.add(new IconCatalogEntry<>("prism", "TablerIcons.prism()", tagIcons::prism));
    icons.add(
        new IconCatalogEntry<>(
            "prism-off", "TablerIcons.prism_off()", tagIcons::prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "prism-plus", "TablerIcons.prism_plus()", tagIcons::prism_plus));
    icons.add(
        new IconCatalogEntry<>("pyramid", "TablerIcons.pyramid()", tagIcons::pyramid));
    icons.add(
        new IconCatalogEntry<>(
            "pyramid-off", "TablerIcons.pyramid_off()", tagIcons::pyramid_off));
    icons.add(
        new IconCatalogEntry<>(
            "pyramid-plus", "TablerIcons.pyramid_plus()", tagIcons::pyramid_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle", "TablerIcons.rectangle()", tagIcons::rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-rounded-bottom",
            "TablerIcons.rectangle_rounded_bottom()",
            tagIcons::rectangle_rounded_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-rounded-top",
            "TablerIcons.rectangle_rounded_top()",
            tagIcons::rectangle_rounded_top));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-vertical",
            "TablerIcons.rectangle_vertical()",
            tagIcons::rectangle_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism",
            "TablerIcons.rectangular_prism()",
            tagIcons::rectangular_prism));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism-off",
            "TablerIcons.rectangular_prism_off()",
            tagIcons::rectangular_prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism-plus",
            "TablerIcons.rectangular_prism_plus()",
            tagIcons::rectangular_prism_plus));
    icons.add(
        new IconCatalogEntry<>("rosette", "TablerIcons.rosette()", tagIcons::rosette));
    icons.add(
        new IconCatalogEntry<>(
            "rosette-asterisk",
            "TablerIcons.rosette_asterisk()",
            tagIcons::rosette_asterisk));
    icons.add(new IconCatalogEntry<>("spade", "TablerIcons.spade()", tagIcons::spade));
    icons.add(new IconCatalogEntry<>("sphere", "TablerIcons.sphere()", tagIcons::sphere));
    icons.add(
        new IconCatalogEntry<>("sphere-2", "TablerIcons.sphere_2()", tagIcons::sphere_2));
    icons.add(
        new IconCatalogEntry<>(
            "sphere-off", "TablerIcons.sphere_off()", tagIcons::sphere_off));
    icons.add(
        new IconCatalogEntry<>(
            "sphere-plus", "TablerIcons.sphere_plus()", tagIcons::sphere_plus));
    icons.add(new IconCatalogEntry<>("square", "TablerIcons.square()", tagIcons::square));
    icons.add(
        new IconCatalogEntry<>(
            "square-asterisk",
            "TablerIcons.square_asterisk()",
            tagIcons::square_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "square-check", "TablerIcons.square_check()", tagIcons::square_check));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed", "TablerIcons.square_dashed()", tagIcons::square_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed-top-solid",
            "TablerIcons.square_dashed_top_solid()",
            tagIcons::square_dashed_top_solid));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed-x",
            "TablerIcons.square_dashed_x()",
            tagIcons::square_dashed_x));
    icons.add(
        new IconCatalogEntry<>(
            "square-dot", "TablerIcons.square_dot()", tagIcons::square_dot));
    icons.add(
        new IconCatalogEntry<>(
            "square-forbid", "TablerIcons.square_forbid()", tagIcons::square_forbid));
    icons.add(
        new IconCatalogEntry<>(
            "square-forbid-2",
            "TablerIcons.square_forbid_2()",
            tagIcons::square_forbid_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-key", "TablerIcons.square_key()", tagIcons::square_key));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus", "TablerIcons.square_minus()", tagIcons::square_minus));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus-2", "TablerIcons.square_minus_2()", tagIcons::square_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-off", "TablerIcons.square_off()", tagIcons::square_off));
    icons.add(
        new IconCatalogEntry<>(
            "square-percentage",
            "TablerIcons.square_percentage()",
            tagIcons::square_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "square-plus", "TablerIcons.square_plus()", tagIcons::square_plus));
    icons.add(
        new IconCatalogEntry<>(
            "square-plus-2", "TablerIcons.square_plus_2()", tagIcons::square_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated", "TablerIcons.square_rotated()", tagIcons::square_rotated));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-asterisk",
            "TablerIcons.square_rotated_asterisk()",
            tagIcons::square_rotated_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-forbid",
            "TablerIcons.square_rotated_forbid()",
            tagIcons::square_rotated_forbid));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-forbid-2",
            "TablerIcons.square_rotated_forbid_2()",
            tagIcons::square_rotated_forbid_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-off",
            "TablerIcons.square_rotated_off()",
            tagIcons::square_rotated_off));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded", "TablerIcons.square_rounded()", tagIcons::square_rounded));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-check",
            "TablerIcons.square_rounded_check()",
            tagIcons::square_rounded_check));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus",
            "TablerIcons.square_rounded_minus()",
            tagIcons::square_rounded_minus));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus-2",
            "TablerIcons.square_rounded_minus_2()",
            tagIcons::square_rounded_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-percentage",
            "TablerIcons.square_rounded_percentage()",
            tagIcons::square_rounded_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus",
            "TablerIcons.square_rounded_plus()",
            tagIcons::square_rounded_plus));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus-2",
            "TablerIcons.square_rounded_plus_2()",
            tagIcons::square_rounded_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-x",
            "TablerIcons.square_rounded_x()",
            tagIcons::square_rounded_x));
    icons.add(
        new IconCatalogEntry<>("square-x", "TablerIcons.square_x()", tagIcons::square_x));
    icons.add(
        new IconCatalogEntry<>(
            "squares-selected",
            "TablerIcons.squares_selected()",
            tagIcons::squares_selected));
    icons.add(
        new IconCatalogEntry<>("triangle", "TablerIcons.triangle()", tagIcons::triangle));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-dashed",
            "TablerIcons.triangle_dashed()",
            tagIcons::triangle_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-inverted",
            "TablerIcons.triangle_inverted()",
            tagIcons::triangle_inverted));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-minus", "TablerIcons.triangle_minus()", tagIcons::triangle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-minus-2",
            "TablerIcons.triangle_minus_2()",
            tagIcons::triangle_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-off", "TablerIcons.triangle_off()", tagIcons::triangle_off));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-plus", "TablerIcons.triangle_plus()", tagIcons::triangle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-plus-2",
            "TablerIcons.triangle_plus_2()",
            tagIcons::triangle_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-square-circle",
            "TablerIcons.triangle_square_circle()",
            tagIcons::triangle_square_circle));
    icons.add(
        new IconCatalogEntry<>(
            "triangles", "TablerIcons.triangles()", tagIcons::triangles));
    icons.add(
        new IconCatalogEntry<>(
            "check-circle", "TablerIcons.circle_check()", tagIcons::check_circle));
    icons.add(
        new IconCatalogEntry<>(
            "minus-box", "TablerIcons.square_minus()", tagIcons::minus_box));
    icons.add(
        new IconCatalogEntry<>(
            "plus-box", "TablerIcons.square_plus()", tagIcons::plus_box));
    icons.add(
        new IconCatalogEntry<>(
            "capsule", "TablerIcons.capsule_filled()", tagIcons::capsule_filled));
    icons.add(
        new IconCatalogEntry<>(
            "capsule-horizontal",
            "TablerIcons.capsule_horizontal_filled()",
            tagIcons::capsule_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left-right",
            "TablerIcons.caret_left_right_filled()",
            tagIcons::caret_left_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "category", "TablerIcons.category_filled()", tagIcons::category_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle", "TablerIcons.circle_filled()", tagIcons::circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-check",
            "TablerIcons.circle_check_filled()",
            tagIcons::circle_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dot", "TablerIcons.circle_dot_filled()", tagIcons::circle_dot_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-key", "TablerIcons.circle_key_filled()", tagIcons::circle_key_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-percentage",
            "TablerIcons.circle_percentage_filled()",
            tagIcons::circle_percentage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus",
            "TablerIcons.circle_plus_filled()",
            tagIcons::circle_plus_filled));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle",
            "TablerIcons.circle_rectangle_filled()",
            tagIcons::circle_rectangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-x", "TablerIcons.circle_x_filled()", tagIcons::circle_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circles", "TablerIcons.circles_filled()", tagIcons::circles_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clubs", "TablerIcons.clubs_filled()", tagIcons::clubs_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cone", "TablerIcons.cone_filled()", tagIcons::cone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cone-2", "TablerIcons.cone_2_filled()", tagIcons::cone_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "diamond", "TablerIcons.diamond_filled()", tagIcons::diamond_filled));
    icons.add(
        new IconCatalogEntry<>(
            "diamonds", "TablerIcons.diamonds_filled()", tagIcons::diamonds_filled));
    icons.add(
        new IconCatalogEntry<>(
            "heart", "TablerIcons.heart_filled()", tagIcons::heart_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon", "TablerIcons.hexagon_filled()", tagIcons::hexagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus",
            "TablerIcons.hexagon_minus_filled()",
            tagIcons::hexagon_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus",
            "TablerIcons.hexagon_plus_filled()",
            tagIcons::hexagon_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "icons", "TablerIcons.icons_filled()", tagIcons::icons_filled));
    icons.add(
        new IconCatalogEntry<>(
            "jewish-star",
            "TablerIcons.jewish_star_filled()",
            tagIcons::jewish_star_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon", "TablerIcons.octagon_filled()", tagIcons::octagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus",
            "TablerIcons.octagon_minus_filled()",
            tagIcons::octagon_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus",
            "TablerIcons.octagon_plus_filled()",
            tagIcons::octagon_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "oval", "TablerIcons.oval_filled()", tagIcons::oval_filled));
    icons.add(
        new IconCatalogEntry<>(
            "oval-vertical",
            "TablerIcons.oval_vertical_filled()",
            tagIcons::oval_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon", "TablerIcons.pentagon_filled()", tagIcons::pentagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle", "TablerIcons.rectangle_filled()", tagIcons::rectangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-vertical",
            "TablerIcons.rectangle_vertical_filled()",
            tagIcons::rectangle_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rosette", "TablerIcons.rosette_filled()", tagIcons::rosette_filled));
    icons.add(
        new IconCatalogEntry<>(
            "spade", "TablerIcons.spade_filled()", tagIcons::spade_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square", "TablerIcons.square_filled()", tagIcons::square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-asterisk",
            "TablerIcons.square_asterisk_filled()",
            tagIcons::square_asterisk_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-check",
            "TablerIcons.square_check_filled()",
            tagIcons::square_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-dot", "TablerIcons.square_dot_filled()", tagIcons::square_dot_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus",
            "TablerIcons.square_minus_filled()",
            tagIcons::square_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated",
            "TablerIcons.square_rotated_filled()",
            tagIcons::square_rotated_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded",
            "TablerIcons.square_rounded_filled()",
            tagIcons::square_rounded_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-check",
            "TablerIcons.square_rounded_check_filled()",
            tagIcons::square_rounded_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus",
            "TablerIcons.square_rounded_minus_filled()",
            tagIcons::square_rounded_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus",
            "TablerIcons.square_rounded_plus_filled()",
            tagIcons::square_rounded_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-x",
            "TablerIcons.square_rounded_x_filled()",
            tagIcons::square_rounded_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-x", "TablerIcons.square_x_filled()", tagIcons::square_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle", "TablerIcons.triangle_filled()", tagIcons::triangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-inverted",
            "TablerIcons.triangle_inverted_filled()",
            tagIcons::triangle_inverted_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-square-circle",
            "TablerIcons.triangle_square_circle_filled()",
            tagIcons::triangle_square_circle_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
