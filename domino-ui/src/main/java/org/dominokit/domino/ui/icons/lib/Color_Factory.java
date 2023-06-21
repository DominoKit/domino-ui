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
public class Color_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Color tagIcons = new Color(){};

  static {
    icons.add(()-> tagIcons.border_color_color());
    icons.add(()-> tagIcons.color_helper_color());
    icons.add(()-> tagIcons.eyedropper_color());
    icons.add(()-> tagIcons.eyedropper_variant_color());
    icons.add(()-> tagIcons.format_color_fill_color());
    icons.add(()-> tagIcons.format_color_highlight_color());
    icons.add(()-> tagIcons.format_color_marker_cancel_color());
    icons.add(()-> tagIcons.format_color_text_color());
    icons.add(()-> tagIcons.format_paint_color());
    icons.add(()-> tagIcons.invert_colors_color());
    icons.add(()-> tagIcons.invert_colors_off_color());
    icons.add(()-> tagIcons.looks_color());
    icons.add(()-> tagIcons.palette_color());
    icons.add(()-> tagIcons.palette_advanced_color());
    icons.add(()-> tagIcons.palette_outline_color());
    icons.add(()-> tagIcons.palette_swatch_color());
    icons.add(()-> tagIcons.palette_swatch_outline_color());
    icons.add(()-> tagIcons.palette_swatch_variant_color());
    icons.add(()-> tagIcons.select_color_color());
    icons.add(()-> tagIcons.spray_color());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
