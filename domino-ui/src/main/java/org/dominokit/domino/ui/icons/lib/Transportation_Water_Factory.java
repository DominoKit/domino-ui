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

/** This is a generated class, please don't modify */
public class Transportation_Water_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Transportation_Water tagIcons = new Transportation_Water() {};

  static {
    icons.add(() -> tagIcons.anchor_transportation_water());
    icons.add(() -> tagIcons.ferry_transportation_water());
    icons.add(() -> tagIcons.lifebuoy_transportation_water());
    icons.add(() -> tagIcons.pier_transportation_water());
    icons.add(() -> tagIcons.pier_crane_transportation_water());
    icons.add(() -> tagIcons.rowing_transportation_water());
    icons.add(() -> tagIcons.sail_boat_transportation_water());
    icons.add(() -> tagIcons.sail_boat_sink_transportation_water());
    icons.add(() -> tagIcons.ship_wheel_transportation_water());
    icons.add(() -> tagIcons.ski_water_transportation_water());
    icons.add(() -> tagIcons.wave_transportation_water());
    icons.add(() -> tagIcons.waves_transportation_water());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
