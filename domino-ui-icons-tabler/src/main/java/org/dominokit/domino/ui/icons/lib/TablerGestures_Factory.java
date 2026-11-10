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
            "hand-click (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_CLICK)",
            tagIcons::hand_click));
    icons.add(
        new IconCatalogEntry<>(
            "hand-click-off (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_CLICK_OFF)",
            tagIcons::hand_click_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER)",
            tagIcons::hand_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-down (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_DOWN)",
            tagIcons::hand_finger_down));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-left (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_LEFT)",
            tagIcons::hand_finger_left));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-off (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_OFF)",
            tagIcons::hand_finger_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-finger-right (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_RIGHT)",
            tagIcons::hand_finger_right));
    icons.add(
        new IconCatalogEntry<>(
            "hand-grab (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_GRAB)",
            tagIcons::hand_grab));
    icons.add(
        new IconCatalogEntry<>(
            "hand-little-finger (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_LITTLE_FINGER)",
            tagIcons::hand_little_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-love-you (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_LOVE_YOU)",
            tagIcons::hand_love_you));
    icons.add(
        new IconCatalogEntry<>(
            "hand-middle-finger (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_MIDDLE_FINGER)",
            tagIcons::hand_middle_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-move (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_MOVE)",
            tagIcons::hand_move));
    icons.add(
        new IconCatalogEntry<>(
            "hand-off (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_OFF)",
            tagIcons::hand_off));
    icons.add(
        new IconCatalogEntry<>(
            "hand-ring-finger (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_RING_FINGER)",
            tagIcons::hand_ring_finger));
    icons.add(
        new IconCatalogEntry<>(
            "hand-stop (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_STOP)",
            tagIcons::hand_stop));
    icons.add(
        new IconCatalogEntry<>(
            "hand-three-fingers (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_THREE_FINGERS)",
            tagIcons::hand_three_fingers));
    icons.add(
        new IconCatalogEntry<>(
            "hand-two-fingers (outline)",
            "TablerIcon.create(TablerGestures.OutlineIcon.HAND_TWO_FINGERS)",
            tagIcons::hand_two_fingers));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
