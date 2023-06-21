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
public class Emoji_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Emoji tagIcons = new Emoji(){};

  static {
    icons.add(()-> tagIcons.emoticon_emoji());
    icons.add(()-> tagIcons.emoticon_angry_emoji());
    icons.add(()-> tagIcons.emoticon_angry_outline_emoji());
    icons.add(()-> tagIcons.emoticon_confused_emoji());
    icons.add(()-> tagIcons.emoticon_confused_outline_emoji());
    icons.add(()-> tagIcons.emoticon_cool_emoji());
    icons.add(()-> tagIcons.emoticon_cool_outline_emoji());
    icons.add(()-> tagIcons.emoticon_cry_emoji());
    icons.add(()-> tagIcons.emoticon_cry_outline_emoji());
    icons.add(()-> tagIcons.emoticon_dead_emoji());
    icons.add(()-> tagIcons.emoticon_dead_outline_emoji());
    icons.add(()-> tagIcons.emoticon_devil_emoji());
    icons.add(()-> tagIcons.emoticon_devil_outline_emoji());
    icons.add(()-> tagIcons.emoticon_excited_emoji());
    icons.add(()-> tagIcons.emoticon_excited_outline_emoji());
    icons.add(()-> tagIcons.emoticon_frown_emoji());
    icons.add(()-> tagIcons.emoticon_frown_outline_emoji());
    icons.add(()-> tagIcons.emoticon_happy_emoji());
    icons.add(()-> tagIcons.emoticon_happy_outline_emoji());
    icons.add(()-> tagIcons.emoticon_kiss_emoji());
    icons.add(()-> tagIcons.emoticon_kiss_outline_emoji());
    icons.add(()-> tagIcons.emoticon_lol_emoji());
    icons.add(()-> tagIcons.emoticon_lol_outline_emoji());
    icons.add(()-> tagIcons.emoticon_neutral_emoji());
    icons.add(()-> tagIcons.emoticon_neutral_outline_emoji());
    icons.add(()-> tagIcons.emoticon_outline_emoji());
    icons.add(()-> tagIcons.emoticon_poop_emoji());
    icons.add(()-> tagIcons.emoticon_poop_outline_emoji());
    icons.add(()-> tagIcons.emoticon_sad_emoji());
    icons.add(()-> tagIcons.emoticon_sad_outline_emoji());
    icons.add(()-> tagIcons.emoticon_sick_emoji());
    icons.add(()-> tagIcons.emoticon_sick_outline_emoji());
    icons.add(()-> tagIcons.emoticon_tongue_emoji());
    icons.add(()-> tagIcons.emoticon_tongue_outline_emoji());
    icons.add(()-> tagIcons.emoticon_wink_emoji());
    icons.add(()-> tagIcons.emoticon_wink_outline_emoji());
    icons.add(()-> tagIcons.sticker_emoji_emoji());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
