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
            "border-corner-ios (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.BORDER_CORNER_IOS)",
            tagIcons::border_corner_ios));
    icons.add(
        new IconCatalogEntry<>(
            "cancel (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CANCEL)",
            tagIcons::cancel));
    icons.add(
        new IconCatalogEntry<>(
            "capsule (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CAPSULE)",
            tagIcons::capsule));
    icons.add(
        new IconCatalogEntry<>(
            "capsule-horizontal (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CAPSULE_HORIZONTAL)",
            tagIcons::capsule_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left-right (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CARET_LEFT_RIGHT)",
            tagIcons::caret_left_right));
    icons.add(
        new IconCatalogEntry<>(
            "category (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CATEGORY)",
            tagIcons::category));
    icons.add(
        new IconCatalogEntry<>(
            "category-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CATEGORY_2)",
            tagIcons::category_2));
    icons.add(
        new IconCatalogEntry<>(
            "category-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CATEGORY_MINUS)",
            tagIcons::category_minus));
    icons.add(
        new IconCatalogEntry<>(
            "category-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CATEGORY_PLUS)",
            tagIcons::category_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE)",
            tagIcons::circle));
    icons.add(
        new IconCatalogEntry<>(
            "circle-asterisk (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_ASTERISK)",
            tagIcons::circle_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "circle-check (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_CHECK)",
            tagIcons::circle_check));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED)",
            tagIcons::circle_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-check (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED_CHECK)",
            tagIcons::circle_dashed_check));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED_MINUS)",
            tagIcons::circle_dashed_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-percentage (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED_PERCENTAGE)",
            tagIcons::circle_dashed_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED_PLUS)",
            tagIcons::circle_dashed_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dashed-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DASHED_X)",
            tagIcons::circle_dashed_x));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dot (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DOT)",
            tagIcons::circle_dot));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dotted (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_DOTTED)",
            tagIcons::circle_dotted));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_HALF)",
            tagIcons::circle_half));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_HALF_2)",
            tagIcons::circle_half_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-half-vertical (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_HALF_VERTICAL)",
            tagIcons::circle_half_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "circle-heart (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_HEART)",
            tagIcons::circle_heart));
    icons.add(
        new IconCatalogEntry<>(
            "circle-key (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_KEY)",
            tagIcons::circle_key));
    icons.add(
        new IconCatalogEntry<>(
            "circle-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_MINUS)",
            tagIcons::circle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_MINUS_2)",
            tagIcons::circle_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_OFF)",
            tagIcons::circle_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-percentage (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_PERCENTAGE)",
            tagIcons::circle_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_PLUS)",
            tagIcons::circle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_PLUS_2)",
            tagIcons::circle_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_PLUS_MINUS)",
            tagIcons::circle_plus_minus));
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_RECTANGLE)",
            tagIcons::circle_rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_RECTANGLE_OFF)",
            tagIcons::circle_rectangle_off));
    icons.add(
        new IconCatalogEntry<>(
            "circle-square (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_SQUARE)",
            tagIcons::circle_square));
    icons.add(
        new IconCatalogEntry<>(
            "circle-triangle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_TRIANGLE)",
            tagIcons::circle_triangle));
    icons.add(
        new IconCatalogEntry<>(
            "circle-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_X)",
            tagIcons::circle_x));
    icons.add(
        new IconCatalogEntry<>(
            "circles (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLES)",
            tagIcons::circles));
    icons.add(
        new IconCatalogEntry<>(
            "circles-relation (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLES_RELATION)",
            tagIcons::circles_relation));
    icons.add(
        new IconCatalogEntry<>(
            "clubs (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CLUBS)",
            tagIcons::clubs));
    icons.add(
        new IconCatalogEntry<>(
            "cone (outline)", "TablerIcon.create(TablerShapes.OutlineIcon.CONE)", tagIcons::cone));
    icons.add(
        new IconCatalogEntry<>(
            "cone-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CONE_2)",
            tagIcons::cone_2));
    icons.add(
        new IconCatalogEntry<>(
            "cone-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CONE_OFF)",
            tagIcons::cone_off));
    icons.add(
        new IconCatalogEntry<>(
            "cone-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CONE_PLUS)",
            tagIcons::cone_plus));
    icons.add(
        new IconCatalogEntry<>(
            "cube (outline)", "TablerIcon.create(TablerShapes.OutlineIcon.CUBE)", tagIcons::cube));
    icons.add(
        new IconCatalogEntry<>(
            "cube-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CUBE_OFF)",
            tagIcons::cube_off));
    icons.add(
        new IconCatalogEntry<>(
            "cube-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CUBE_PLUS)",
            tagIcons::cube_plus));
    icons.add(
        new IconCatalogEntry<>(
            "cube-spark (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CUBE_SPARK)",
            tagIcons::cube_spark));
    icons.add(
        new IconCatalogEntry<>(
            "cylinder (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CYLINDER)",
            tagIcons::cylinder));
    icons.add(
        new IconCatalogEntry<>(
            "cylinder-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CYLINDER_OFF)",
            tagIcons::cylinder_off));
    icons.add(
        new IconCatalogEntry<>(
            "cylinder-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CYLINDER_PLUS)",
            tagIcons::cylinder_plus));
    icons.add(
        new IconCatalogEntry<>(
            "diabolo (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIABOLO)",
            tagIcons::diabolo));
    icons.add(
        new IconCatalogEntry<>(
            "diabolo-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIABOLO_OFF)",
            tagIcons::diabolo_off));
    icons.add(
        new IconCatalogEntry<>(
            "diabolo-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIABOLO_PLUS)",
            tagIcons::diabolo_plus));
    icons.add(
        new IconCatalogEntry<>(
            "diamond (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIAMOND)",
            tagIcons::diamond));
    icons.add(
        new IconCatalogEntry<>(
            "diamond-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIAMOND_OFF)",
            tagIcons::diamond_off));
    icons.add(
        new IconCatalogEntry<>(
            "diamonds (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.DIAMONDS)",
            tagIcons::diamonds));
    icons.add(
        new IconCatalogEntry<>(
            "frustum (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.FRUSTUM)",
            tagIcons::frustum));
    icons.add(
        new IconCatalogEntry<>(
            "frustum-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.FRUSTUM_OFF)",
            tagIcons::frustum_off));
    icons.add(
        new IconCatalogEntry<>(
            "frustum-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.FRUSTUM_PLUS)",
            tagIcons::frustum_plus));
    icons.add(
        new IconCatalogEntry<>(
            "heart (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART)",
            tagIcons::heart));
    icons.add(
        new IconCatalogEntry<>(
            "heart-bolt (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_BOLT)",
            tagIcons::heart_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "heart-cancel (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_CANCEL)",
            tagIcons::heart_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "heart-check (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_CHECK)",
            tagIcons::heart_check));
    icons.add(
        new IconCatalogEntry<>(
            "heart-code (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_CODE)",
            tagIcons::heart_code));
    icons.add(
        new IconCatalogEntry<>(
            "heart-cog (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_COG)",
            tagIcons::heart_cog));
    icons.add(
        new IconCatalogEntry<>(
            "heart-dollar (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_DOLLAR)",
            tagIcons::heart_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "heart-down (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_DOWN)",
            tagIcons::heart_down));
    icons.add(
        new IconCatalogEntry<>(
            "heart-exclamation (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_EXCLAMATION)",
            tagIcons::heart_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "heart-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_MINUS)",
            tagIcons::heart_minus));
    icons.add(
        new IconCatalogEntry<>(
            "heart-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_OFF)",
            tagIcons::heart_off));
    icons.add(
        new IconCatalogEntry<>(
            "heart-pause (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_PAUSE)",
            tagIcons::heart_pause));
    icons.add(
        new IconCatalogEntry<>(
            "heart-pin (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_PIN)",
            tagIcons::heart_pin));
    icons.add(
        new IconCatalogEntry<>(
            "heart-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_PLUS)",
            tagIcons::heart_plus));
    icons.add(
        new IconCatalogEntry<>(
            "heart-question (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_QUESTION)",
            tagIcons::heart_question));
    icons.add(
        new IconCatalogEntry<>(
            "heart-search (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_SEARCH)",
            tagIcons::heart_search));
    icons.add(
        new IconCatalogEntry<>(
            "heart-share (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_SHARE)",
            tagIcons::heart_share));
    icons.add(
        new IconCatalogEntry<>(
            "heart-spark (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_SPARK)",
            tagIcons::heart_spark));
    icons.add(
        new IconCatalogEntry<>(
            "heart-star (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_STAR)",
            tagIcons::heart_star));
    icons.add(
        new IconCatalogEntry<>(
            "heart-up (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_UP)",
            tagIcons::heart_up));
    icons.add(
        new IconCatalogEntry<>(
            "heart-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEART_X)",
            tagIcons::heart_x));
    icons.add(
        new IconCatalogEntry<>(
            "hearts (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEARTS)",
            tagIcons::hearts));
    icons.add(
        new IconCatalogEntry<>(
            "hearts-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEARTS_OFF)",
            tagIcons::hearts_off));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEMISPHERE)",
            tagIcons::hemisphere));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEMISPHERE_OFF)",
            tagIcons::hemisphere_off));
    icons.add(
        new IconCatalogEntry<>(
            "hemisphere-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEMISPHERE_PLUS)",
            tagIcons::hemisphere_plus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON)",
            tagIcons::hexagon));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-3d (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_3D)",
            tagIcons::hexagon_3d));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-asterisk (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_ASTERISK)",
            tagIcons::hexagon_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_MINUS)",
            tagIcons::hexagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_MINUS_2)",
            tagIcons::hexagon_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_OFF)",
            tagIcons::hexagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_PLUS)",
            tagIcons::hexagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGON_PLUS_2)",
            tagIcons::hexagon_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PRISM)",
            tagIcons::hexagonal_prism));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PRISM_OFF)",
            tagIcons::hexagonal_prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-prism-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PRISM_PLUS)",
            tagIcons::hexagonal_prism_plus));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PYRAMID)",
            tagIcons::hexagonal_pyramid));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PYRAMID_OFF)",
            tagIcons::hexagonal_pyramid_off));
    icons.add(
        new IconCatalogEntry<>(
            "hexagonal-pyramid-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONAL_PYRAMID_PLUS)",
            tagIcons::hexagonal_pyramid_plus));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "hexagons (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONS)",
            tagIcons::hexagons));
    icons.add(
        new IconCatalogEntry<>(
            "hexagons-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.HEXAGONS_OFF)",
            tagIcons::hexagons_off));
    icons.add(
        new IconCatalogEntry<>(
            "icons (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.ICONS)",
            tagIcons::icons));
    icons.add(
        new IconCatalogEntry<>(
            "icons-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.ICONS_OFF)",
            tagIcons::icons_off));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.IRREGULAR_POLYHEDRON)",
            tagIcons::irregular_polyhedron));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.IRREGULAR_POLYHEDRON_OFF)",
            tagIcons::irregular_polyhedron_off));
    icons.add(
        new IconCatalogEntry<>(
            "irregular-polyhedron-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.IRREGULAR_POLYHEDRON_PLUS)",
            tagIcons::irregular_polyhedron_plus));
    icons.add(
        new IconCatalogEntry<>(
            "jewish-star (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.JEWISH_STAR)",
            tagIcons::jewish_star));
    icons.add(
        new IconCatalogEntry<>(
            "octagon (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON)",
            tagIcons::octagon));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON_MINUS)",
            tagIcons::octagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON_MINUS_2)",
            tagIcons::octagon_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON_OFF)",
            tagIcons::octagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON_PLUS)",
            tagIcons::octagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAGON_PLUS_2)",
            tagIcons::octagon_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAHEDRON)",
            tagIcons::octahedron));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAHEDRON_OFF)",
            tagIcons::octahedron_off));
    icons.add(
        new IconCatalogEntry<>(
            "octahedron-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OCTAHEDRON_PLUS)",
            tagIcons::octahedron_plus));
    icons.add(
        new IconCatalogEntry<>(
            "oval (outline)", "TablerIcon.create(TablerShapes.OutlineIcon.OVAL)", tagIcons::oval));
    icons.add(
        new IconCatalogEntry<>(
            "oval-vertical (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.OVAL_VERTICAL)",
            tagIcons::oval_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PENTAGON)",
            tagIcons::pentagon));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PENTAGON_MINUS)",
            tagIcons::pentagon_minus));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PENTAGON_OFF)",
            tagIcons::pentagon_off));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PENTAGON_PLUS)",
            tagIcons::pentagon_plus));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PENTAGON_X)",
            tagIcons::pentagon_x));
    icons.add(
        new IconCatalogEntry<>(
            "perspective (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PERSPECTIVE)",
            tagIcons::perspective));
    icons.add(
        new IconCatalogEntry<>(
            "perspective-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PERSPECTIVE_OFF)",
            tagIcons::perspective_off));
    icons.add(
        new IconCatalogEntry<>(
            "prism (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PRISM)",
            tagIcons::prism));
    icons.add(
        new IconCatalogEntry<>(
            "prism-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PRISM_OFF)",
            tagIcons::prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "prism-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PRISM_PLUS)",
            tagIcons::prism_plus));
    icons.add(
        new IconCatalogEntry<>(
            "pyramid (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PYRAMID)",
            tagIcons::pyramid));
    icons.add(
        new IconCatalogEntry<>(
            "pyramid-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PYRAMID_OFF)",
            tagIcons::pyramid_off));
    icons.add(
        new IconCatalogEntry<>(
            "pyramid-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.PYRAMID_PLUS)",
            tagIcons::pyramid_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGLE)",
            tagIcons::rectangle));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-rounded-bottom (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGLE_ROUNDED_BOTTOM)",
            tagIcons::rectangle_rounded_bottom));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-rounded-top (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGLE_ROUNDED_TOP)",
            tagIcons::rectangle_rounded_top));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-vertical (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGLE_VERTICAL)",
            tagIcons::rectangle_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGULAR_PRISM)",
            tagIcons::rectangular_prism));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGULAR_PRISM_OFF)",
            tagIcons::rectangular_prism_off));
    icons.add(
        new IconCatalogEntry<>(
            "rectangular-prism-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.RECTANGULAR_PRISM_PLUS)",
            tagIcons::rectangular_prism_plus));
    icons.add(
        new IconCatalogEntry<>(
            "rosette (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.ROSETTE)",
            tagIcons::rosette));
    icons.add(
        new IconCatalogEntry<>(
            "rosette-asterisk (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.ROSETTE_ASTERISK)",
            tagIcons::rosette_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "spade (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SPADE)",
            tagIcons::spade));
    icons.add(
        new IconCatalogEntry<>(
            "sphere (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SPHERE)",
            tagIcons::sphere));
    icons.add(
        new IconCatalogEntry<>(
            "sphere-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SPHERE_2)",
            tagIcons::sphere_2));
    icons.add(
        new IconCatalogEntry<>(
            "sphere-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SPHERE_OFF)",
            tagIcons::sphere_off));
    icons.add(
        new IconCatalogEntry<>(
            "sphere-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SPHERE_PLUS)",
            tagIcons::sphere_plus));
    icons.add(
        new IconCatalogEntry<>(
            "square (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE)",
            tagIcons::square));
    icons.add(
        new IconCatalogEntry<>(
            "square-asterisk (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ASTERISK)",
            tagIcons::square_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "square-check (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_CHECK)",
            tagIcons::square_check));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_DASHED)",
            tagIcons::square_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed-top-solid (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_DASHED_TOP_SOLID)",
            tagIcons::square_dashed_top_solid));
    icons.add(
        new IconCatalogEntry<>(
            "square-dashed-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_DASHED_X)",
            tagIcons::square_dashed_x));
    icons.add(
        new IconCatalogEntry<>(
            "square-dot (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_DOT)",
            tagIcons::square_dot));
    icons.add(
        new IconCatalogEntry<>(
            "square-forbid (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_FORBID)",
            tagIcons::square_forbid));
    icons.add(
        new IconCatalogEntry<>(
            "square-forbid-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_FORBID_2)",
            tagIcons::square_forbid_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-key (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_KEY)",
            tagIcons::square_key));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_MINUS)",
            tagIcons::square_minus));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_MINUS_2)",
            tagIcons::square_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_OFF)",
            tagIcons::square_off));
    icons.add(
        new IconCatalogEntry<>(
            "square-percentage (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_PERCENTAGE)",
            tagIcons::square_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "square-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_PLUS)",
            tagIcons::square_plus));
    icons.add(
        new IconCatalogEntry<>(
            "square-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_PLUS_2)",
            tagIcons::square_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROTATED)",
            tagIcons::square_rotated));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-asterisk (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROTATED_ASTERISK)",
            tagIcons::square_rotated_asterisk));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-forbid (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROTATED_FORBID)",
            tagIcons::square_rotated_forbid));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-forbid-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROTATED_FORBID_2)",
            tagIcons::square_rotated_forbid_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROTATED_OFF)",
            tagIcons::square_rotated_off));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED)",
            tagIcons::square_rounded));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-check (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_CHECK)",
            tagIcons::square_rounded_check));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_MINUS)",
            tagIcons::square_rounded_minus));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_MINUS_2)",
            tagIcons::square_rounded_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-percentage (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_PERCENTAGE)",
            tagIcons::square_rounded_percentage));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_PLUS)",
            tagIcons::square_rounded_plus));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_PLUS_2)",
            tagIcons::square_rounded_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_ROUNDED_X)",
            tagIcons::square_rounded_x));
    icons.add(
        new IconCatalogEntry<>(
            "square-x (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_X)",
            tagIcons::square_x));
    icons.add(
        new IconCatalogEntry<>(
            "squares-selected (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARES_SELECTED)",
            tagIcons::squares_selected));
    icons.add(
        new IconCatalogEntry<>(
            "triangle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE)",
            tagIcons::triangle));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-dashed (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_DASHED)",
            tagIcons::triangle_dashed));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-inverted (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_INVERTED)",
            tagIcons::triangle_inverted));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-minus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_MINUS)",
            tagIcons::triangle_minus));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-minus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_MINUS_2)",
            tagIcons::triangle_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-off (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_OFF)",
            tagIcons::triangle_off));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-plus (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_PLUS)",
            tagIcons::triangle_plus));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-plus-2 (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_PLUS_2)",
            tagIcons::triangle_plus_2));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-square-circle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLE_SQUARE_CIRCLE)",
            tagIcons::triangle_square_circle));
    icons.add(
        new IconCatalogEntry<>(
            "triangles (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.TRIANGLES)",
            tagIcons::triangles));
    icons.add(
        new IconCatalogEntry<>(
            "check-circle (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.CIRCLE_CHECK)",
            tagIcons::check_circle));
    icons.add(
        new IconCatalogEntry<>(
            "minus-box (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_MINUS)",
            tagIcons::minus_box));
    icons.add(
        new IconCatalogEntry<>(
            "plus-box (outline)",
            "TablerIcon.create(TablerShapes.OutlineIcon.SQUARE_PLUS)",
            tagIcons::plus_box));
    icons.add(
        new IconCatalogEntry<>(
            "capsule (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CAPSULE)",
            tagIcons::capsule_filled));
    icons.add(
        new IconCatalogEntry<>(
            "capsule-horizontal (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CAPSULE_HORIZONTAL)",
            tagIcons::capsule_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caret-left-right (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CARET_LEFT_RIGHT)",
            tagIcons::caret_left_right_filled));
    icons.add(
        new IconCatalogEntry<>(
            "category (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CATEGORY)",
            tagIcons::category_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE)",
            tagIcons::circle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-check (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_CHECK)",
            tagIcons::circle_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-dot (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_DOT)",
            tagIcons::circle_dot_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-key (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_KEY)",
            tagIcons::circle_key_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-percentage (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_PERCENTAGE)",
            tagIcons::circle_percentage_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-plus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_PLUS)",
            tagIcons::circle_plus_filled));
  }

  private static void addIcons2() {
    icons.add(
        new IconCatalogEntry<>(
            "circle-rectangle (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_RECTANGLE)",
            tagIcons::circle_rectangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circle-x (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLE_X)",
            tagIcons::circle_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "circles (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CIRCLES)",
            tagIcons::circles_filled));
    icons.add(
        new IconCatalogEntry<>(
            "clubs (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CLUBS)",
            tagIcons::clubs_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cone (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CONE)",
            tagIcons::cone_filled));
    icons.add(
        new IconCatalogEntry<>(
            "cone-2 (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.CONE_2)",
            tagIcons::cone_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "diamond (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.DIAMOND)",
            tagIcons::diamond_filled));
    icons.add(
        new IconCatalogEntry<>(
            "diamonds (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.DIAMONDS)",
            tagIcons::diamonds_filled));
    icons.add(
        new IconCatalogEntry<>(
            "heart (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.HEART)",
            tagIcons::heart_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.HEXAGON)",
            tagIcons::hexagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-minus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.HEXAGON_MINUS)",
            tagIcons::hexagon_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "hexagon-plus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.HEXAGON_PLUS)",
            tagIcons::hexagon_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "icons (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.ICONS)",
            tagIcons::icons_filled));
    icons.add(
        new IconCatalogEntry<>(
            "jewish-star (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.JEWISH_STAR)",
            tagIcons::jewish_star_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.OCTAGON)",
            tagIcons::octagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-minus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.OCTAGON_MINUS)",
            tagIcons::octagon_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "octagon-plus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.OCTAGON_PLUS)",
            tagIcons::octagon_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "oval (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.OVAL)",
            tagIcons::oval_filled));
    icons.add(
        new IconCatalogEntry<>(
            "oval-vertical (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.OVAL_VERTICAL)",
            tagIcons::oval_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pentagon (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.PENTAGON)",
            tagIcons::pentagon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.RECTANGLE)",
            tagIcons::rectangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rectangle-vertical (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.RECTANGLE_VERTICAL)",
            tagIcons::rectangle_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rosette (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.ROSETTE)",
            tagIcons::rosette_filled));
    icons.add(
        new IconCatalogEntry<>(
            "spade (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SPADE)",
            tagIcons::spade_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE)",
            tagIcons::square_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-asterisk (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ASTERISK)",
            tagIcons::square_asterisk_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-check (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_CHECK)",
            tagIcons::square_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-dot (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_DOT)",
            tagIcons::square_dot_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-minus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_MINUS)",
            tagIcons::square_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rotated (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROTATED)",
            tagIcons::square_rotated_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROUNDED)",
            tagIcons::square_rounded_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-check (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROUNDED_CHECK)",
            tagIcons::square_rounded_check_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-minus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROUNDED_MINUS)",
            tagIcons::square_rounded_minus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-plus (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROUNDED_PLUS)",
            tagIcons::square_rounded_plus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-rounded-x (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_ROUNDED_X)",
            tagIcons::square_rounded_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "square-x (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.SQUARE_X)",
            tagIcons::square_x_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.TRIANGLE)",
            tagIcons::triangle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-inverted (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.TRIANGLE_INVERTED)",
            tagIcons::triangle_inverted_filled));
    icons.add(
        new IconCatalogEntry<>(
            "triangle-square-circle (filled)",
            "TablerIcon.create(TablerShapes.FilledIcon.TRIANGLE_SQUARE_CIRCLE)",
            tagIcons::triangle_square_circle_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
