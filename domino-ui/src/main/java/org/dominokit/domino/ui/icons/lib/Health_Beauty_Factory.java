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
public class Health_Beauty_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Health_Beauty tagIcons = new Health_Beauty() {};

  static {
    icons.add(() -> tagIcons.content_cut_health_beauty());
    icons.add(() -> tagIcons.face_man_shimmer_health_beauty());
    icons.add(() -> tagIcons.face_man_shimmer_outline_health_beauty());
    icons.add(() -> tagIcons.face_woman_shimmer_health_beauty());
    icons.add(() -> tagIcons.face_woman_shimmer_outline_health_beauty());
    icons.add(() -> tagIcons.hair_dryer_health_beauty());
    icons.add(() -> tagIcons.hair_dryer_outline_health_beauty());
    icons.add(() -> tagIcons.lipstick_health_beauty());
    icons.add(() -> tagIcons.lotion_health_beauty());
    icons.add(() -> tagIcons.lotion_outline_health_beauty());
    icons.add(() -> tagIcons.medication_health_beauty());
    icons.add(() -> tagIcons.medication_outline_health_beauty());
    icons.add(() -> tagIcons.razor_double_edge_health_beauty());
    icons.add(() -> tagIcons.water_health_beauty());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
