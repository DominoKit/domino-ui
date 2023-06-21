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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.MdiIconsByTagFactory;

/**
 * This is a generated class, please don't modify
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Vector_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Vector tagIcons = new Vector() {};

  static {
    icons.add(() -> tagIcons.vector_arrange_above_vector());
    icons.add(() -> tagIcons.vector_arrange_below_vector());
    icons.add(() -> tagIcons.vector_bezier_vector());
    icons.add(() -> tagIcons.vector_circle_vector());
    icons.add(() -> tagIcons.vector_circle_variant_vector());
    icons.add(() -> tagIcons.vector_combine_vector());
    icons.add(() -> tagIcons.vector_curve_vector());
    icons.add(() -> tagIcons.vector_difference_vector());
    icons.add(() -> tagIcons.vector_difference_ab_vector());
    icons.add(() -> tagIcons.vector_difference_ba_vector());
    icons.add(() -> tagIcons.vector_ellipse_vector());
    icons.add(() -> tagIcons.vector_intersection_vector());
    icons.add(() -> tagIcons.vector_line_vector());
    icons.add(() -> tagIcons.vector_link_vector());
    icons.add(() -> tagIcons.vector_point_vector());
    icons.add(() -> tagIcons.vector_point_edit_vector());
    icons.add(() -> tagIcons.vector_point_minus_vector());
    icons.add(() -> tagIcons.vector_point_plus_vector());
    icons.add(() -> tagIcons.vector_point_select_vector());
    icons.add(() -> tagIcons.vector_polygon_vector());
    icons.add(() -> tagIcons.vector_polygon_variant_vector());
    icons.add(() -> tagIcons.vector_polyline_vector());
    icons.add(() -> tagIcons.vector_radius_vector());
    icons.add(() -> tagIcons.vector_rectangle_vector());
    icons.add(() -> tagIcons.vector_selection_vector());
    icons.add(() -> tagIcons.vector_square_vector());
    icons.add(() -> tagIcons.vector_square_close_vector());
    icons.add(() -> tagIcons.vector_square_edit_vector());
    icons.add(() -> tagIcons.vector_square_minus_vector());
    icons.add(() -> tagIcons.vector_square_open_vector());
    icons.add(() -> tagIcons.vector_square_plus_vector());
    icons.add(() -> tagIcons.vector_square_remove_vector());
    icons.add(() -> tagIcons.vector_triangle_vector());
    icons.add(() -> tagIcons.vector_union_vector());
  }

  /** {@inheritDoc} */
  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
