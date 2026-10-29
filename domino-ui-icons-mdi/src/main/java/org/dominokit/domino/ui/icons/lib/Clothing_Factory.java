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
public class Clothing_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Clothing tagIcons = new Clothing() {};

  static {
    icons.add(() -> tagIcons.bow_tie_clothing());
    icons.add(() -> tagIcons.chef_hat_clothing());
    icons.add(() -> tagIcons.coat_rack_clothing());
    icons.add(() -> tagIcons.diaper_outline_clothing());
    icons.add(() -> tagIcons.face_mask_clothing());
    icons.add(() -> tagIcons.face_mask_outline_clothing());
    icons.add(() -> tagIcons.glasses_clothing());
    icons.add(() -> tagIcons.hanger_clothing());
    icons.add(() -> tagIcons.hard_hat_clothing());
    icons.add(() -> tagIcons.hat_fedora_clothing());
    icons.add(() -> tagIcons.iron_clothing());
    icons.add(() -> tagIcons.iron_board_clothing());
    icons.add(() -> tagIcons.iron_outline_clothing());
    icons.add(() -> tagIcons.lingerie_clothing());
    icons.add(() -> tagIcons.necklace_clothing());
    icons.add(() -> tagIcons.shoe_ballet_clothing());
    icons.add(() -> tagIcons.shoe_cleat_clothing());
    icons.add(() -> tagIcons.shoe_formal_clothing());
    icons.add(() -> tagIcons.shoe_heel_clothing());
    icons.add(() -> tagIcons.shoe_sneaker_clothing());
    icons.add(() -> tagIcons.sunglasses_clothing());
    icons.add(() -> tagIcons.tie_clothing());
    icons.add(() -> tagIcons.tshirt_crew_clothing());
    icons.add(() -> tagIcons.tshirt_crew_outline_clothing());
    icons.add(() -> tagIcons.tshirt_v_clothing());
    icons.add(() -> tagIcons.tshirt_v_outline_clothing());
    icons.add(() -> tagIcons.underwear_outline_clothing());
    icons.add(() -> tagIcons.wizard_hat_clothing());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
