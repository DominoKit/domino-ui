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

/**
 * This is a generated class, please don't modify
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class Emoji_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Emoji tagIcons = new Emoji() {};

  static {
    icons.add(() -> tagIcons.emoticon_emoji());
    icons.add(() -> tagIcons.emoticon_angry_emoji());
    icons.add(() -> tagIcons.emoticon_angry_outline_emoji());
    icons.add(() -> tagIcons.emoticon_confused_emoji());
    icons.add(() -> tagIcons.emoticon_confused_outline_emoji());
    icons.add(() -> tagIcons.emoticon_cool_emoji());
    icons.add(() -> tagIcons.emoticon_cool_outline_emoji());
    icons.add(() -> tagIcons.emoticon_cry_emoji());
    icons.add(() -> tagIcons.emoticon_cry_outline_emoji());
    icons.add(() -> tagIcons.emoticon_dead_emoji());
    icons.add(() -> tagIcons.emoticon_dead_outline_emoji());
    icons.add(() -> tagIcons.emoticon_devil_emoji());
    icons.add(() -> tagIcons.emoticon_devil_outline_emoji());
    icons.add(() -> tagIcons.emoticon_excited_emoji());
    icons.add(() -> tagIcons.emoticon_excited_outline_emoji());
    icons.add(() -> tagIcons.emoticon_frown_emoji());
    icons.add(() -> tagIcons.emoticon_frown_outline_emoji());
    icons.add(() -> tagIcons.emoticon_happy_emoji());
    icons.add(() -> tagIcons.emoticon_happy_outline_emoji());
    icons.add(() -> tagIcons.emoticon_kiss_emoji());
    icons.add(() -> tagIcons.emoticon_kiss_outline_emoji());
    icons.add(() -> tagIcons.emoticon_lol_emoji());
    icons.add(() -> tagIcons.emoticon_lol_outline_emoji());
    icons.add(() -> tagIcons.emoticon_neutral_emoji());
    icons.add(() -> tagIcons.emoticon_neutral_outline_emoji());
    icons.add(() -> tagIcons.emoticon_outline_emoji());
    icons.add(() -> tagIcons.emoticon_poop_emoji());
    icons.add(() -> tagIcons.emoticon_poop_outline_emoji());
    icons.add(() -> tagIcons.emoticon_sad_emoji());
    icons.add(() -> tagIcons.emoticon_sad_outline_emoji());
    icons.add(() -> tagIcons.emoticon_sick_emoji());
    icons.add(() -> tagIcons.emoticon_sick_outline_emoji());
    icons.add(() -> tagIcons.emoticon_tongue_emoji());
    icons.add(() -> tagIcons.emoticon_tongue_outline_emoji());
    icons.add(() -> tagIcons.emoticon_wink_emoji());
    icons.add(() -> tagIcons.emoticon_wink_outline_emoji());
    icons.add(() -> tagIcons.sticker_emoji_emoji());
  }

  /** {@inheritDoc} */
  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
