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
public class Arrange_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Arrange tagIcons = new Arrange(){};

  static {
    icons.add(()-> tagIcons.arrange_bring_forward_arrange());
    icons.add(()-> tagIcons.arrange_bring_to_front_arrange());
    icons.add(()-> tagIcons.arrange_send_backward_arrange());
    icons.add(()-> tagIcons.arrange_send_to_back_arrange());
    icons.add(()-> tagIcons.flip_horizontal_arrange());
    icons.add(()-> tagIcons.flip_to_back_arrange());
    icons.add(()-> tagIcons.flip_to_front_arrange());
    icons.add(()-> tagIcons.flip_vertical_arrange());
    icons.add(()-> tagIcons.vector_arrange_above_arrange());
    icons.add(()-> tagIcons.vector_arrange_below_arrange());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
