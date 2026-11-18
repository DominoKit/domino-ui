/*
 * Copyright © 2026 Dominokit
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
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerGestures;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Gestures category. */
public final class TablerGestures_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerGestures tagIcons = new TablerGestures() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "hand-click", "TablerIcons.hand_click()", tagIcons::hand_click));
    icons.add(
        new IconCatalogEntry<>(
            "hand-click-off", "TablerIcons.hand_click_off()", tagIcons::hand_click_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger", "TablerIcons.hand_finger()", tagIcons::hand_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-down",
            "TablerIcons.hand_finger_down()",
            tagIcons::hand_finger_down));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-left",
            "TablerIcons.hand_finger_left()",
            tagIcons::hand_finger_left));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-off",
            "TablerIcons.hand_finger_off()",
            tagIcons::hand_finger_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-right",
            "TablerIcons.hand_finger_right()",
            tagIcons::hand_finger_right));
    icons.add(
        new IconCatalogEntry<>(
            "hand-grab", "TablerIcons.hand_grab()", tagIcons::hand_grab));
    icons.add(
        new IconCatalogEntry<>(
            "hand-little-finger",
            "TablerIcons.hand_little_finger()",
            tagIcons::hand_little_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-love-you", "TablerIcons.hand_love_you()", tagIcons::hand_love_you));
    icons.add(
        new IconCatalogEntry<>(
            "hand-middle-finger",
            "TablerIcons.hand_middle_finger()",
            tagIcons::hand_middle_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-move", "TablerIcons.hand_move()", tagIcons::hand_move));
    icons.add(
        new IconCatalogEntry<>("hand-off", "TablerIcons.hand_off()", tagIcons::hand_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-ring-finger",
            "TablerIcons.hand_ring_finger()",
            tagIcons::hand_ring_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-stop", "TablerIcons.hand_stop()", tagIcons::hand_stop));
    icons.add(
        new IconCatalogEntry<>(
            "hand-three-fingers",
            "TablerIcons.hand_three_fingers()",
            tagIcons::hand_three_fingers));
    icons.add(
        new IconCatalogEntry<>(
            "hand-two-fingers",
            "TablerIcons.hand_two_fingers()",
            tagIcons::hand_two_fingers));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
