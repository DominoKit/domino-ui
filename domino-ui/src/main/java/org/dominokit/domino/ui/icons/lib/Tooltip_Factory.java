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
public class Tooltip_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Tooltip tagIcons = new Tooltip(){};

  static {
    icons.add(()-> tagIcons.tooltip_tooltip());
    icons.add(()-> tagIcons.tooltip_account_tooltip());
    icons.add(()-> tagIcons.tooltip_cellphone_tooltip());
    icons.add(()-> tagIcons.tooltip_check_tooltip());
    icons.add(()-> tagIcons.tooltip_check_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_edit_tooltip());
    icons.add(()-> tagIcons.tooltip_edit_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_image_tooltip());
    icons.add(()-> tagIcons.tooltip_image_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_minus_tooltip());
    icons.add(()-> tagIcons.tooltip_minus_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_plus_tooltip());
    icons.add(()-> tagIcons.tooltip_plus_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_question_tooltip());
    icons.add(()-> tagIcons.tooltip_question_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_remove_tooltip());
    icons.add(()-> tagIcons.tooltip_remove_outline_tooltip());
    icons.add(()-> tagIcons.tooltip_text_tooltip());
    icons.add(()-> tagIcons.tooltip_text_outline_tooltip());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
