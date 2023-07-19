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
public class Notification_Factory implements MdiIconsByTagFactory {
  private static final List<Supplier<MdiIcon>> icons = new ArrayList();

  private static final Notification tagIcons = new Notification() {};

  static {
    icons.add(() -> tagIcons.alarm_bell_notification());
    icons.add(() -> tagIcons.bell_notification());
    icons.add(() -> tagIcons.bell_alert_notification());
    icons.add(() -> tagIcons.bell_alert_outline_notification());
    icons.add(() -> tagIcons.bell_badge_notification());
    icons.add(() -> tagIcons.bell_badge_outline_notification());
    icons.add(() -> tagIcons.bell_cancel_notification());
    icons.add(() -> tagIcons.bell_cancel_outline_notification());
    icons.add(() -> tagIcons.bell_check_notification());
    icons.add(() -> tagIcons.bell_check_outline_notification());
    icons.add(() -> tagIcons.bell_circle_notification());
    icons.add(() -> tagIcons.bell_circle_outline_notification());
    icons.add(() -> tagIcons.bell_cog_notification());
    icons.add(() -> tagIcons.bell_cog_outline_notification());
    icons.add(() -> tagIcons.bell_minus_notification());
    icons.add(() -> tagIcons.bell_minus_outline_notification());
    icons.add(() -> tagIcons.bell_off_notification());
    icons.add(() -> tagIcons.bell_off_outline_notification());
    icons.add(() -> tagIcons.bell_outline_notification());
    icons.add(() -> tagIcons.bell_plus_notification());
    icons.add(() -> tagIcons.bell_plus_outline_notification());
    icons.add(() -> tagIcons.bell_remove_notification());
    icons.add(() -> tagIcons.bell_remove_outline_notification());
    icons.add(() -> tagIcons.bell_ring_notification());
    icons.add(() -> tagIcons.bell_ring_outline_notification());
    icons.add(() -> tagIcons.bell_sleep_notification());
    icons.add(() -> tagIcons.bell_sleep_outline_notification());
    icons.add(() -> tagIcons.checkbox_blank_badge_notification());
    icons.add(() -> tagIcons.checkbox_blank_badge_outline_notification());
    icons.add(() -> tagIcons.message_badge_notification());
    icons.add(() -> tagIcons.message_badge_outline_notification());
    icons.add(() -> tagIcons.notification_clear_all_notification());
    icons.add(() -> tagIcons.square_rounded_badge_notification());
    icons.add(() -> tagIcons.square_rounded_badge_outline_notification());
  }

  @Override
  public List<Supplier<MdiIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
