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

/** Lucide people catalog category. */
public interface LucidePeople {
  enum Icon implements LucideIconDefinition {
    BABY(
        "baby",
        "<path d=\"M10 16c.5.3 1.2.5 2 .5s1.5-.2 2-.5\" />\n  <path d=\"M15 12h.01\" />\n  <path d=\"M19.38 6.813A9 9 0 0 1 20.8 10.2a2 2 0 0 1 0 3.6 9 9 0 0 1-17.6 0 2 2 0 0 1 0-3.6A9 9 0 0 1 12 3c2 0 3.5 1.1 3.5 2.5s-.9 2.5-2 2.5c-.8 0-1.5-.4-1.5-1\" />\n  <path d=\"M9 12h.01\" />"),
    CLOCK_ARROW_RIGHT(
        "clock-arrow-right",
        "<path d=\"M12 6v6l2 1\" />\n  <path d=\"M13.5 21.885A10 10 0 1 1 22 12\" />\n  <path d=\"M14 18h8\" />\n  <path d=\"m18 22 4-4-4-4\" />"),
    FOLDER_USER(
        "folder-user",
        "<path d=\"M10.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <path d=\"M22 22a4 4 0 0 0-8 0\" />\n  <circle cx=\"18\" cy=\"15\" r=\"3\" />"),
    FOLDER_USERS(
        "folder-users",
        "<path d=\"M5.254 20H4a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h3.9a2 2 0 0 1 1.69.9l.81 1.2a2 2 0 0 0 1.67.9H20a2 2 0 0 1 2 2V9.255\" />\n  <circle cx=\"13\" cy=\"15\" r=\"3\" />\n  <path d=\"M17 22a4 4 0 0 0-8 0\" />\n  <path d=\"M22 22A4 4 0 0 0 20.24 18.686 1 1 0 0 1 20.1 17.143 3 3 0 0 0 19.5 12.402\" />"),
    HAND_PLATTER(
        "hand-platter",
        "<path d=\"M12 3V2\" />\n  <path d=\"m15.4 17.4 3.2-2.8a2 2 0 1 1 2.8 2.9l-3.6 3.3c-.7.8-1.7 1.2-2.8 1.2h-4c-1.1 0-2.1-.4-2.8-1.2l-1.302-1.464A1 1 0 0 0 6.151 19H5\" />\n  <path d=\"M2 14h12a2 2 0 0 1 0 4h-2\" />\n  <path d=\"M4 10h16\" />\n  <path d=\"M5 10a7 7 0 0 1 14 0\" />\n  <path d=\"M5 14v6a1 1 0 0 1-1 1H2\" />"),
    PERSON_STANDING(
        "person-standing",
        "<circle cx=\"12\" cy=\"5\" r=\"1\" />\n  <path d=\"m9 20 3-6 3 6\" />\n  <path d=\"m6 8 6 2 6-2\" />\n  <path d=\"M12 10v4\" />"),
    SMARTPHONE_USER_ROUND(
        "smartphone-user-round",
        "<path d=\"M10 22H6a2 2 0 01-2-2V4a2 2 0 012-2h10a2 2 0 012 2v4\" />\n  <path d=\"M11 18h.01\" />\n  <path d=\"M22 22a4 4 0 00-8 0\" />\n  <circle cx=\"18\" cy=\"15\" r=\"3\" />"),
    TOMBSTONE(
        "tombstone",
        "<path d=\"M11 10h2\" />\n  <path d=\"M19 21V10a7 7 0 00-14 0v11\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M9 14h6\" />"),
    USER_GROUP(
        "user-group",
        "<path d=\"M17 21v-1a2 2 0 00-2-2H9a2 2 0 00-2 2v1\" />\n  <path d=\"M19 10h1a2 2 0 012 2v1\" />\n  <path d=\"M5 10H4a2 2 0 00-2 2v1\" />\n  <circle cx=\"12\" cy=\"11\" r=\"3\" />\n  <circle cx=\"18\" cy=\"4\" r=\"2\" />\n  <circle cx=\"6\" cy=\"4\" r=\"2\" />"),
    USER_ROUND_ARROW_LEFT(
        "user-round-arrow-left",
        "<path d=\"m19 16-3 3\" />\n  <path d=\"M2 21a8 8 0 0 1 12.664-6.5\" />\n  <path d=\"M22 19h-6l3 3\" />\n  <circle cx=\"10\" cy=\"8\" r=\"5\" />"),
    USER_ROUND_GROUP(
        "user-round-group",
        "<path d=\"M17 21a5 5 0 00-10 0\" />\n  <path d=\"M22 10.5a3.5 3.5 0 00-5.507-2.868\" />\n  <path d=\"M7.507 7.632A3.5 3.5 0 002 10.5\" />\n  <circle cx=\"12\" cy=\"13\" r=\"3\" />\n  <circle cx=\"18.5\" cy=\"4.5\" r=\"2.5\" />\n  <circle cx=\"5.5\" cy=\"4.5\" r=\"2.5\" />"),
    USER_SHIELD(
        "user-shield",
        "<path d=\"M10 15H6a4 4 0 0 0-4 4v2\" />\n  <path d=\"M22 17.5c0 2.499-1.75 3.749-3.83 4.474a.5.5 0 0 1-.335-.005c-2.085-.72-3.835-1.97-3.835-4.47V14a.5.5 0 0 1 .5-.499c1 0 2.25-.6 3.12-1.36a.6.6 0 0 1 .76-.001c.875.765 2.12 1.36 3.12 1.36a.5.5 0 0 1 .5.5z\" />\n  <circle cx=\"9\" cy=\"7\" r=\"4\" />"),
    USERS_COLLABORATION(
        "users-collaboration",
        "<path d=\"M12.925 3.047a9 9 0 017.616 6.11\" />\n  <path d=\"M13 22a2 2 0 012-2h4a2 2 0 012 2\" />\n  <path d=\"M3 12a2 2 0 012-2h4a2 2 0 012 2\" />\n  <path d=\"M3.889 15.9a9 9 0 005.247 4.632\" />\n  <circle cx=\"17\" cy=\"14\" r=\"2\" />\n  <circle cx=\"7\" cy=\"4\" r=\"2\" />"),
    USERS_ROUND_COLLABORATION(
        "users-round-collaboration",
        "<path d=\"M20.453 8.911a9 9 0 00-6.696-5.738\" />\n  <path d=\"M21 22a4 4 0 00-8 0\" />\n  <path d=\"M3 12a4 4 0 017.963-.543\" />\n  <path d=\"M3.889 15.9a9 9 0 005.247 4.632\" />\n  <circle cx=\"17\" cy=\"15\" r=\"3\" />\n  <circle cx=\"7\" cy=\"5\" r=\"3\" />");

    private final String catalogName;
    private final String svg;

    Icon(String catalogName, String svg) {
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

  // Icon factories for this category.
  default LucideIcon baby_people() {
    return LucideIcon.create(Icon.BABY);
  }

  default LucideIcon clock_arrow_right_people() {
    return LucideIcon.create(Icon.CLOCK_ARROW_RIGHT);
  }

  default LucideIcon folder_user_people() {
    return LucideIcon.create(Icon.FOLDER_USER);
  }

  default LucideIcon folder_users_people() {
    return LucideIcon.create(Icon.FOLDER_USERS);
  }

  default LucideIcon hand_platter() {
    return LucideIcon.create(Icon.HAND_PLATTER);
  }

  default LucideIcon person_standing_people() {
    return LucideIcon.create(Icon.PERSON_STANDING);
  }

  default LucideIcon smartphone_user_round_people() {
    return LucideIcon.create(Icon.SMARTPHONE_USER_ROUND);
  }

  default LucideIcon tombstone_people() {
    return LucideIcon.create(Icon.TOMBSTONE);
  }

  default LucideIcon user_group_people() {
    return LucideIcon.create(Icon.USER_GROUP);
  }

  default LucideIcon user_round_arrow_left_people() {
    return LucideIcon.create(Icon.USER_ROUND_ARROW_LEFT);
  }

  default LucideIcon user_round_group_people() {
    return LucideIcon.create(Icon.USER_ROUND_GROUP);
  }

  default LucideIcon user_shield_people() {
    return LucideIcon.create(Icon.USER_SHIELD);
  }

  default LucideIcon users_collaboration_people() {
    return LucideIcon.create(Icon.USERS_COLLABORATION);
  }

  default LucideIcon users_round_collaboration_people() {
    return LucideIcon.create(Icon.USERS_ROUND_COLLABORATION);
  }
}
