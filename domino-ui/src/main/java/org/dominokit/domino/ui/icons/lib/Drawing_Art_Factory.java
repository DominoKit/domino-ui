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
public class Drawing_Art_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Drawing_Art tagIcons = new Drawing_Art(){};

  static {
    icons.add(()-> tagIcons.artboard_drawing_art());
    icons.add(()-> tagIcons.brush_drawing_art());
    icons.add(()-> tagIcons.brush_outline_drawing_art());
    icons.add(()-> tagIcons.brush_variant_drawing_art());
    icons.add(()-> tagIcons.circle_opacity_drawing_art());
    icons.add(()-> tagIcons.draw_drawing_art());
    icons.add(()-> tagIcons.draw_pen_drawing_art());
    icons.add(()-> tagIcons.drawing_drawing_art());
    icons.add(()-> tagIcons.drawing_box_drawing_art());
    icons.add(()-> tagIcons.eyedropper_drawing_art());
    icons.add(()-> tagIcons.format_line_style_drawing_art());
    icons.add(()-> tagIcons.format_line_weight_drawing_art());
    icons.add(()-> tagIcons.format_paint_drawing_art());
    icons.add(()-> tagIcons.fountain_pen_drawing_art());
    icons.add(()-> tagIcons.fountain_pen_tip_drawing_art());
    icons.add(()-> tagIcons.gesture_drawing_art());
    icons.add(()-> tagIcons.gradient_horizontal_drawing_art());
    icons.add(()-> tagIcons.gradient_vertical_drawing_art());
    icons.add(()-> tagIcons.grease_pencil_drawing_art());
    icons.add(()-> tagIcons.lead_pencil_drawing_art());
    icons.add(()-> tagIcons.math_compass_drawing_art());
    icons.add(()-> tagIcons.palette_drawing_art());
    icons.add(()-> tagIcons.palette_advanced_drawing_art());
    icons.add(()-> tagIcons.palette_outline_drawing_art());
    icons.add(()-> tagIcons.palette_swatch_drawing_art());
    icons.add(()-> tagIcons.palette_swatch_outline_drawing_art());
    icons.add(()-> tagIcons.palette_swatch_variant_drawing_art());
    icons.add(()-> tagIcons.pen_drawing_art());
    icons.add(()-> tagIcons.pencil_drawing_art());
    icons.add(()-> tagIcons.pencil_box_drawing_art());
    icons.add(()-> tagIcons.pencil_box_outline_drawing_art());
    icons.add(()-> tagIcons.pencil_circle_drawing_art());
    icons.add(()-> tagIcons.pencil_circle_outline_drawing_art());
    icons.add(()-> tagIcons.pencil_outline_drawing_art());
    icons.add(()-> tagIcons.pencil_ruler_drawing_art());
    icons.add(()-> tagIcons.pencil_ruler_outline_drawing_art());
    icons.add(()-> tagIcons.ruler_drawing_art());
    icons.add(()-> tagIcons.ruler_square_drawing_art());
    icons.add(()-> tagIcons.spray_drawing_art());
    icons.add(()-> tagIcons.square_opacity_drawing_art());
    icons.add(()-> tagIcons.water_opacity_drawing_art());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
