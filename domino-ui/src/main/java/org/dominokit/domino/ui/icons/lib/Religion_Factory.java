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
public class Religion_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Religion tagIcons = new Religion(){};

  static {
    icons.add(()-> tagIcons.book_cross_religion());
    icons.add(()-> tagIcons.church_religion());
    icons.add(()-> tagIcons.church_outline_religion());
    icons.add(()-> tagIcons.cross_religion());
    icons.add(()-> tagIcons.cross_bolnisi_religion());
    icons.add(()-> tagIcons.cross_celtic_religion());
    icons.add(()-> tagIcons.cross_outline_religion());
    icons.add(()-> tagIcons.dharmachakra_religion());
    icons.add(()-> tagIcons.khanda_religion());
    icons.add(()-> tagIcons.menorah_religion());
    icons.add(()-> tagIcons.menorah_fire_religion());
    icons.add(()-> tagIcons.mosque_religion());
    icons.add(()-> tagIcons.mosque_outline_religion());
    icons.add(()-> tagIcons.om_religion());
    icons.add(()-> tagIcons.shield_cross_religion());
    icons.add(()-> tagIcons.shield_cross_outline_religion());
    icons.add(()-> tagIcons.star_crescent_religion());
    icons.add(()-> tagIcons.star_david_religion());
    icons.add(()-> tagIcons.synagogue_religion());
    icons.add(()-> tagIcons.synagogue_outline_religion());
    icons.add(()-> tagIcons.temple_buddhist_religion());
    icons.add(()-> tagIcons.temple_buddhist_outline_religion());
    icons.add(()-> tagIcons.temple_hindu_religion());
    icons.add(()-> tagIcons.temple_hindu_outline_religion());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
