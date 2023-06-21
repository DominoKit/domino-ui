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
public class Clothing_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Clothing tagIcons = new Clothing(){};

  static {
    icons.add(()-> tagIcons.bow_tie_clothing());
    icons.add(()-> tagIcons.chef_hat_clothing());
    icons.add(()-> tagIcons.coat_rack_clothing());
    icons.add(()-> tagIcons.face_mask_clothing());
    icons.add(()-> tagIcons.face_mask_outline_clothing());
    icons.add(()-> tagIcons.glasses_clothing());
    icons.add(()-> tagIcons.hanger_clothing());
    icons.add(()-> tagIcons.hard_hat_clothing());
    icons.add(()-> tagIcons.hat_fedora_clothing());
    icons.add(()-> tagIcons.iron_clothing());
    icons.add(()-> tagIcons.iron_board_clothing());
    icons.add(()-> tagIcons.iron_outline_clothing());
    icons.add(()-> tagIcons.lingerie_clothing());
    icons.add(()-> tagIcons.necklace_clothing());
    icons.add(()-> tagIcons.shoe_ballet_clothing());
    icons.add(()-> tagIcons.shoe_cleat_clothing());
    icons.add(()-> tagIcons.shoe_formal_clothing());
    icons.add(()-> tagIcons.shoe_heel_clothing());
    icons.add(()-> tagIcons.shoe_sneaker_clothing());
    icons.add(()-> tagIcons.sunglasses_clothing());
    icons.add(()-> tagIcons.tie_clothing());
    icons.add(()-> tagIcons.tshirt_crew_clothing());
    icons.add(()-> tagIcons.tshirt_crew_outline_clothing());
    icons.add(()-> tagIcons.tshirt_v_clothing());
    icons.add(()-> tagIcons.tshirt_v_outline_clothing());
    icons.add(()-> tagIcons.wizard_hat_clothing());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
