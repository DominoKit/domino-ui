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
public class SocialMedia_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final SocialMedia tagIcons = new SocialMedia(){};

  static {
    icons.add(()-> tagIcons.facebook_socialmedia());
    icons.add(()-> tagIcons.facebook_messenger_socialmedia());
    icons.add(()-> tagIcons.facebook_workplace_socialmedia());
    icons.add(()-> tagIcons.google_plus_socialmedia());
    icons.add(()-> tagIcons.linkedin_socialmedia());
    icons.add(()-> tagIcons.microsoft_xbox_socialmedia());
    icons.add(()-> tagIcons.reddit_socialmedia());
    icons.add(()-> tagIcons.twitch_socialmedia());
    icons.add(()-> tagIcons.twitter_socialmedia());
    icons.add(()-> tagIcons.youtube_socialmedia());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
