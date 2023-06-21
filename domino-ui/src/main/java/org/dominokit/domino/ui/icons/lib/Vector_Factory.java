package org.dominokit.domino.ui.icons.lib;

import java.lang.Override;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import org.dominokit.domino.ui.icons.MdiIcon;
import org.dominokit.domino.ui.icons.MdiIconsByTagFactory;

/**
 * This is a generated class, please don't modify
 */
public class Vector_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Vector tagIcons = new Vector(){};

  static {
    icons.add(()-> tagIcons.vector_arrange_above_vector());
    icons.add(()-> tagIcons.vector_arrange_below_vector());
    icons.add(()-> tagIcons.vector_bezier_vector());
    icons.add(()-> tagIcons.vector_circle_vector());
    icons.add(()-> tagIcons.vector_circle_variant_vector());
    icons.add(()-> tagIcons.vector_combine_vector());
    icons.add(()-> tagIcons.vector_curve_vector());
    icons.add(()-> tagIcons.vector_difference_vector());
    icons.add(()-> tagIcons.vector_difference_ab_vector());
    icons.add(()-> tagIcons.vector_difference_ba_vector());
    icons.add(()-> tagIcons.vector_ellipse_vector());
    icons.add(()-> tagIcons.vector_intersection_vector());
    icons.add(()-> tagIcons.vector_line_vector());
    icons.add(()-> tagIcons.vector_link_vector());
    icons.add(()-> tagIcons.vector_point_vector());
    icons.add(()-> tagIcons.vector_point_edit_vector());
    icons.add(()-> tagIcons.vector_point_minus_vector());
    icons.add(()-> tagIcons.vector_point_plus_vector());
    icons.add(()-> tagIcons.vector_point_select_vector());
    icons.add(()-> tagIcons.vector_polygon_vector());
    icons.add(()-> tagIcons.vector_polygon_variant_vector());
    icons.add(()-> tagIcons.vector_polyline_vector());
    icons.add(()-> tagIcons.vector_radius_vector());
    icons.add(()-> tagIcons.vector_rectangle_vector());
    icons.add(()-> tagIcons.vector_selection_vector());
    icons.add(()-> tagIcons.vector_square_vector());
    icons.add(()-> tagIcons.vector_square_close_vector());
    icons.add(()-> tagIcons.vector_square_edit_vector());
    icons.add(()-> tagIcons.vector_square_minus_vector());
    icons.add(()-> tagIcons.vector_square_open_vector());
    icons.add(()-> tagIcons.vector_square_plus_vector());
    icons.add(()-> tagIcons.vector_square_remove_vector());
    icons.add(()-> tagIcons.vector_triangle_vector());
    icons.add(()-> tagIcons.vector_union_vector());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
