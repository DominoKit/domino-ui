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
package org.dominokit.domino.ui.icons;

/** Tabler Gestures catalog category. */
public interface TablerGestures {
  enum OutlineIcon implements TablerIconDefinition {
    HAND_CLICK(
        "hand-click",
        "<path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />\n  <path d=\"M11 11.5v-2a1.5 1.5 0 0 1 3 0v2.5\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7l-.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M5 3l-1 -1\" />\n  <path d=\"M4 7h-1\" />\n  <path d=\"M14 3l1 -1\" />\n  <path d=\"M15 6h1\" />"),
    HAND_CLICK_OFF(
        "hand-click-off",
        "<path d=\"M8 13v-5\" />\n  <path d=\"M8.06 4.077a1.5 1.5 0 0 1 2.94 .423v2.5m0 4v1\" />\n  <path d=\"M12.063 8.065a1.5 1.5 0 0 1 1.937 1.435v.5\" />\n  <path d=\"M14.06 10.082a1.5 1.5 0 0 1 2.94 .418v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5m-.88 3.129a6 6 0 0 1 -5.12 2.871h-2h.208a6 6 0 0 1 -5.012 -2.7l-.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M3 3l18 18\" />\n  <path d=\"M4 7h-1\" />\n  <path d=\"M14 3l1 -1\" />\n  <path d=\"M15 6h1\" />"),
    HAND_FINGER(
        "hand-finger",
        "<path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />\n  <path d=\"M11 11.5v-2a1.5 1.5 0 1 1 3 0v2.5\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />"),
    HAND_FINGER_DOWN(
        "hand-finger-down",
        "<path d=\"M8 12v8.5a1.5 1.5 0 0 0 3 0v-7.5\" />\n  <path d=\"M11 13.5v2a1.5 1.5 0 0 0 3 0v-2.5\" />\n  <path d=\"M14 14.5a1.5 1.5 0 0 0 3 0v-1.5\" />\n  <path d=\"M17 13.5a1.5 1.5 0 0 0 3 0v-4.5a6 6 0 0 0 -6 -6h-2h.208a6 6 0 0 0 -5.012 2.7l-.196 .3q -.468 .718 -3.286 5.728a1.5 1.5 0 0 0 .536 2.022c.734 .44 1.674 .325 2.28 -.28l1.47 -1.47\" />"),
    HAND_FINGER_LEFT(
        "hand-finger-left",
        "<path d=\"M12 8h-8.5a1.5 1.5 0 0 0 0 3h7.5\" />\n  <path d=\"M10.5 11h-2a1.5 1.5 0 1 0 0 3h2.5\" />\n  <path d=\"M9.5 14a1.5 1.5 0 0 0 0 3h1.5\" />\n  <path d=\"M10.5 17a1.5 1.5 0 0 0 0 3h4.5a6 6 0 0 0 6 -6v-2v.208a6 6 0 0 0 -2.7 -5.012l-.3 -.196q -.718 -.468 -5.728 -3.286a1.5 1.5 0 0 0 -2.022 .536a1.87 1.87 0 0 0 .28 2.28l1.47 1.47\" />"),
    HAND_FINGER_OFF(
        "hand-finger-off",
        "<path d=\"M8 13v-5\" />\n  <path d=\"M8.06 4.077a1.5 1.5 0 0 1 2.94 .423v2.5m0 4v1\" />\n  <path d=\"M12.063 8.065a1.5 1.5 0 0 1 1.937 1.435v.5\" />\n  <path d=\"M14.06 10.082a1.5 1.5 0 0 1 2.94 .418v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5m-.88 3.129a6 6 0 0 1 -5.12 2.871h-2h.208a6 6 0 0 1 -5.012 -2.7l-.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M3 3l18 18\" />"),
    HAND_FINGER_RIGHT(
        "hand-finger-right",
        "<path d=\"M12 8h8.5a1.5 1.5 0 0 1 0 3h-7.5\" />\n  <path d=\"M13.5 11h2a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M14.5 14a1.5 1.5 0 0 1 0 3h-1.5\" />\n  <path d=\"M13.5 17a1.5 1.5 0 1 1 0 3h-4.5a6 6 0 0 1 -6 -6v-2v.208a6 6 0 0 1 2.7 -5.012l.3 -.196q .718 -.468 5.728 -3.286a1.5 1.5 0 0 1 2.022 .536c.44 .734 .325 1.674 -.28 2.28l-1.47 1.47\" />"),
    HAND_GRAB(
        "hand-grab",
        "<path d=\"M8 11v-3.5a1.5 1.5 0 0 1 3 0v2.5\" />\n  <path d=\"M11 9.5v-3a1.5 1.5 0 0 1 3 0v3.5\" />\n  <path d=\"M14 7.5a1.5 1.5 0 0 1 3 0v2.5\" />\n  <path d=\"M17 9.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7l-.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />"),
    HAND_LITTLE_FINGER(
        "hand-little-finger",
        "<path d=\"M8 13v-2.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M11 11.5v-1a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 12v-5.5a1.5 1.5 0 0 1 3 0v9.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />"),
    HAND_LOVE_YOU(
        "hand-love-you",
        "<path d=\"M11 11.5v-1a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 12v-6.5a1.5 1.5 0 0 1 3 0v10.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />"),
    HAND_MIDDLE_FINGER(
        "hand-middle-finger",
        "<path d=\"M8 13v-2.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M11 11.5v-8a1.5 1.5 0 1 1 3 0v8.5\" />"),
    HAND_MOVE(
        "hand-move",
        "<path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />\n  <path d=\"M11 11.5v-2a1.5 1.5 0 0 1 3 0v2.5\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7l-.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M2.541 5.594a13.487 13.487 0 0 1 2.46 -1.427\" />\n  <path d=\"M14 3.458c1.32 .354 2.558 .902 3.685 1.612\" />"),
    HAND_OFF(
        "hand-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M8 13.5v-5.5m.44 -3.562a1.5 1.5 0 0 1 2.56 1.062v1.5m0 4.008v.992m0 -6.5v-2a1.5 1.5 0 1 1 3 0v6.5m0 -4.5a1.5 1.5 0 0 1 3 0v6.5m0 -4.5a1.5 1.5 0 0 1 3 0v8.5a6 6 0 0 1 -6 6h-2c-2.114 -.292 -3.956 -1.397 -5 -3l-2.7 -5.25a1.7 1.7 0 0 1 2.75 -2l.9 1.75\" />"),
    HAND_RING_FINGER(
        "hand-ring-finger",
        "<path d=\"M8 13v-2.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M11 11.5v-2a1.5 1.5 0 1 1 3 0v2.5\" />\n  <path d=\"M14 12v-6.5a1.5 1.5 0 0 1 3 0v6.5\" />"),
    HAND_STOP(
        "hand-stop",
        "<path d=\"M8 13v-7.5a1.5 1.5 0 0 1 3 0v6.5\" />\n  <path d=\"M11 5.5v-2a1.5 1.5 0 1 1 3 0v8.5\" />\n  <path d=\"M14 5.5a1.5 1.5 0 0 1 3 0v6.5\" />\n  <path d=\"M17 7.5a1.5 1.5 0 0 1 3 0v8.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />"),
    HAND_THREE_FINGERS(
        "hand-three-fingers",
        "<path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M11 5.5v-2a1.5 1.5 0 1 1 3 0v8.5\" />\n  <path d=\"M14 5.5a1.5 1.5 0 0 1 3 0v6.5\" />"),
    HAND_TWO_FINGERS(
        "hand-two-fingers",
        "<path d=\"M8 13v-8.5a1.5 1.5 0 0 1 3 0v7.5\" />\n  <path d=\"M17 11.5a1.5 1.5 0 0 1 3 0v4.5a6 6 0 0 1 -6 6h-2h.208a6 6 0 0 1 -5.012 -2.7a69.74 69.74 0 0 1 -.196 -.3c-.312 -.479 -1.407 -2.388 -3.286 -5.728a1.5 1.5 0 0 1 .536 -2.022a1.867 1.867 0 0 1 2.28 .28l1.47 1.47\" />\n  <path d=\"M14 10.5a1.5 1.5 0 0 1 3 0v1.5\" />\n  <path d=\"M11 5.5v-2a1.5 1.5 0 1 1 3 0v8.5\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "outline";
    }
  }

  enum FilledIcon implements TablerIconDefinition {
    ;

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
      this.catalogName = catalogName;
      this.svg = svg;
    }

    @Override
    public String catalogName() {
      return catalogName;
    }

    @Override
    public String svg() {
      return svg;
    }

    @Override
    public String variant() {
      return "filled";
    }
  }

  default TablerIcon hand_click() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_CLICK);
  }

  default TablerIcon hand_click_off() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_CLICK_OFF);
  }

  default TablerIcon hand_finger() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER);
  }

  default TablerIcon hand_finger_down() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_DOWN);
  }

  default TablerIcon hand_finger_left() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_LEFT);
  }

  default TablerIcon hand_finger_off() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_OFF);
  }

  default TablerIcon hand_finger_right() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_FINGER_RIGHT);
  }

  default TablerIcon hand_grab() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_GRAB);
  }

  default TablerIcon hand_little_finger() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_LITTLE_FINGER);
  }

  default TablerIcon hand_love_you() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_LOVE_YOU);
  }

  default TablerIcon hand_middle_finger() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_MIDDLE_FINGER);
  }

  default TablerIcon hand_move() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_MOVE);
  }

  default TablerIcon hand_off() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_OFF);
  }

  default TablerIcon hand_ring_finger() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_RING_FINGER);
  }

  default TablerIcon hand_stop() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_STOP);
  }

  default TablerIcon hand_three_fingers() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_THREE_FINGERS);
  }

  default TablerIcon hand_two_fingers() {
    return TablerIcon.create(TablerGestures.OutlineIcon.HAND_TWO_FINGERS);
  }
}
