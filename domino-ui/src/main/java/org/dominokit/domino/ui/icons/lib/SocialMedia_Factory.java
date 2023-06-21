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
public class SocialMedia_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final SocialMedia tagIcons = new SocialMedia() {};

  static {
    icons.add(() -> tagIcons.facebook_socialmedia());
    icons.add(() -> tagIcons.facebook_messenger_socialmedia());
    icons.add(() -> tagIcons.facebook_workplace_socialmedia());
    icons.add(() -> tagIcons.google_plus_socialmedia());
    icons.add(() -> tagIcons.linkedin_socialmedia());
    icons.add(() -> tagIcons.microsoft_xbox_socialmedia());
    icons.add(() -> tagIcons.reddit_socialmedia());
    icons.add(() -> tagIcons.twitch_socialmedia());
    icons.add(() -> tagIcons.twitter_socialmedia());
    icons.add(() -> tagIcons.youtube_socialmedia());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
