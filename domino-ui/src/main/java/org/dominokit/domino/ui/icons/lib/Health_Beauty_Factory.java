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
public class Health_Beauty_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Health_Beauty tagIcons = new Health_Beauty(){};

  static {
    icons.add(()-> tagIcons.content_cut_health_beauty());
    icons.add(()-> tagIcons.face_man_shimmer_health_beauty());
    icons.add(()-> tagIcons.face_man_shimmer_outline_health_beauty());
    icons.add(()-> tagIcons.face_woman_shimmer_health_beauty());
    icons.add(()-> tagIcons.face_woman_shimmer_outline_health_beauty());
    icons.add(()-> tagIcons.hair_dryer_health_beauty());
    icons.add(()-> tagIcons.hair_dryer_outline_health_beauty());
    icons.add(()-> tagIcons.lipstick_health_beauty());
    icons.add(()-> tagIcons.lotion_health_beauty());
    icons.add(()-> tagIcons.lotion_outline_health_beauty());
    icons.add(()-> tagIcons.medication_health_beauty());
    icons.add(()-> tagIcons.medication_outline_health_beauty());
    icons.add(()-> tagIcons.razor_double_edge_health_beauty());
    icons.add(()-> tagIcons.water_health_beauty());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
