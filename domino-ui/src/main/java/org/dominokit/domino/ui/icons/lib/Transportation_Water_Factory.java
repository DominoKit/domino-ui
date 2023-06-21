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
public class Transportation_Water_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Transportation_Water tagIcons = new Transportation_Water(){};

  static {
    icons.add(()-> tagIcons.anchor_transportation_water());
    icons.add(()-> tagIcons.ferry_transportation_water());
    icons.add(()-> tagIcons.lifebuoy_transportation_water());
    icons.add(()-> tagIcons.pier_transportation_water());
    icons.add(()-> tagIcons.pier_crane_transportation_water());
    icons.add(()-> tagIcons.rowing_transportation_water());
    icons.add(()-> tagIcons.sail_boat_transportation_water());
    icons.add(()-> tagIcons.sail_boat_sink_transportation_water());
    icons.add(()-> tagIcons.ship_wheel_transportation_water());
    icons.add(()-> tagIcons.ski_water_transportation_water());
    icons.add(()-> tagIcons.wave_transportation_water());
    icons.add(()-> tagIcons.waves_transportation_water());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
