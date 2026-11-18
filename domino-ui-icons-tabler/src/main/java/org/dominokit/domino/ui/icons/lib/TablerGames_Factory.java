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
import org.dominokit.domino.ui.icons.TablerGames;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Games category. */
public final class TablerGames_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerGames tagIcons = new TablerGames() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "archery-arrow", "TablerIcons.archery_arrow()", tagIcons::archery_arrow));
    icons.add(new IconCatalogEntry<>("axe", "TablerIcons.axe()", tagIcons::axe));
    icons.add(new IconCatalogEntry<>("dice", "TablerIcons.dice()", tagIcons::dice));
    icons.add(new IconCatalogEntry<>("dice-1", "TablerIcons.dice_1()", tagIcons::dice_1));
    icons.add(new IconCatalogEntry<>("dice-2", "TablerIcons.dice_2()", tagIcons::dice_2));
    icons.add(new IconCatalogEntry<>("dice-3", "TablerIcons.dice_3()", tagIcons::dice_3));
    icons.add(new IconCatalogEntry<>("dice-4", "TablerIcons.dice_4()", tagIcons::dice_4));
    icons.add(new IconCatalogEntry<>("dice-5", "TablerIcons.dice_5()", tagIcons::dice_5));
    icons.add(new IconCatalogEntry<>("dice-6", "TablerIcons.dice_6()", tagIcons::dice_6));
    icons.add(new IconCatalogEntry<>("ghost", "TablerIcons.ghost()", tagIcons::ghost));
    icons.add(
        new IconCatalogEntry<>("ghost-2", "TablerIcons.ghost_2()", tagIcons::ghost_2));
    icons.add(
        new IconCatalogEntry<>("ghost-3", "TablerIcons.ghost_3()", tagIcons::ghost_3));
    icons.add(
        new IconCatalogEntry<>(
            "ghost-off", "TablerIcons.ghost_off()", tagIcons::ghost_off));
    icons.add(
        new IconCatalogEntry<>("go-game", "TablerIcons.go_game()", tagIcons::go_game));
    icons.add(
        new IconCatalogEntry<>(
            "horse-toy", "TablerIcons.horse_toy()", tagIcons::horse_toy));
    icons.add(new IconCatalogEntry<>("joker", "TablerIcons.joker()", tagIcons::joker));
    icons.add(new IconCatalogEntry<>("pacman", "TablerIcons.pacman()", tagIcons::pacman));
    icons.add(new IconCatalogEntry<>("piano", "TablerIcons.piano()", tagIcons::piano));
    icons.add(new IconCatalogEntry<>("pick", "TablerIcons.pick()", tagIcons::pick));
    icons.add(
        new IconCatalogEntry<>(
            "play-card", "TablerIcons.play_card()", tagIcons::play_card));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-1", "TablerIcons.play_card_1()", tagIcons::play_card_1));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-10", "TablerIcons.play_card_10()", tagIcons::play_card_10));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-2", "TablerIcons.play_card_2()", tagIcons::play_card_2));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-3", "TablerIcons.play_card_3()", tagIcons::play_card_3));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-4", "TablerIcons.play_card_4()", tagIcons::play_card_4));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-5", "TablerIcons.play_card_5()", tagIcons::play_card_5));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-6", "TablerIcons.play_card_6()", tagIcons::play_card_6));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-7", "TablerIcons.play_card_7()", tagIcons::play_card_7));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-8", "TablerIcons.play_card_8()", tagIcons::play_card_8));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-9", "TablerIcons.play_card_9()", tagIcons::play_card_9));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-a", "TablerIcons.play_card_a()", tagIcons::play_card_a));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-j", "TablerIcons.play_card_j()", tagIcons::play_card_j));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-k", "TablerIcons.play_card_k()", tagIcons::play_card_k));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-off", "TablerIcons.play_card_off()", tagIcons::play_card_off));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-q", "TablerIcons.play_card_q()", tagIcons::play_card_q));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-star", "TablerIcons.play_card_star()", tagIcons::play_card_star));
    icons.add(
        new IconCatalogEntry<>(
            "poker-chip", "TablerIcons.poker_chip()", tagIcons::poker_chip));
    icons.add(
        new IconCatalogEntry<>(
            "pumpkin-scary", "TablerIcons.pumpkin_scary()", tagIcons::pumpkin_scary));
    icons.add(new IconCatalogEntry<>("puzzle", "TablerIcons.puzzle()", tagIcons::puzzle));
    icons.add(
        new IconCatalogEntry<>("puzzle-2", "TablerIcons.puzzle_2()", tagIcons::puzzle_2));
    icons.add(
        new IconCatalogEntry<>(
            "puzzle-off", "TablerIcons.puzzle_off()", tagIcons::puzzle_off));
    icons.add(new IconCatalogEntry<>("robot", "TablerIcons.robot()", tagIcons::robot));
    icons.add(
        new IconCatalogEntry<>("roulette", "TablerIcons.roulette()", tagIcons::roulette));
    icons.add(new IconCatalogEntry<>("sword", "TablerIcons.sword()", tagIcons::sword));
    icons.add(
        new IconCatalogEntry<>(
            "sword-off", "TablerIcons.sword_off()", tagIcons::sword_off));
    icons.add(new IconCatalogEntry<>("swords", "TablerIcons.swords()", tagIcons::swords));
    icons.add(
        new IconCatalogEntry<>(
            "treasure-chest", "TablerIcons.treasure_chest()", tagIcons::treasure_chest));
    icons.add(new IconCatalogEntry<>("ufo", "TablerIcons.ufo()", tagIcons::ufo));
    icons.add(
        new IconCatalogEntry<>(
            "dice", "TablerIcons.dice_filled()", tagIcons::dice_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-1", "TablerIcons.dice_1_filled()", tagIcons::dice_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-2", "TablerIcons.dice_2_filled()", tagIcons::dice_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-3", "TablerIcons.dice_3_filled()", tagIcons::dice_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-4", "TablerIcons.dice_4_filled()", tagIcons::dice_4_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-5", "TablerIcons.dice_5_filled()", tagIcons::dice_5_filled));
    icons.add(
        new IconCatalogEntry<>(
            "dice-6", "TablerIcons.dice_6_filled()", tagIcons::dice_6_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ghost", "TablerIcons.ghost_filled()", tagIcons::ghost_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ghost-2", "TablerIcons.ghost_2_filled()", tagIcons::ghost_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ghost-3", "TablerIcons.ghost_3_filled()", tagIcons::ghost_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "pacman", "TablerIcons.pacman_filled()", tagIcons::pacman_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card", "TablerIcons.play_card_filled()", tagIcons::play_card_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-1",
            "TablerIcons.play_card_1_filled()",
            tagIcons::play_card_1_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-10",
            "TablerIcons.play_card_10_filled()",
            tagIcons::play_card_10_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-2",
            "TablerIcons.play_card_2_filled()",
            tagIcons::play_card_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-3",
            "TablerIcons.play_card_3_filled()",
            tagIcons::play_card_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-4",
            "TablerIcons.play_card_4_filled()",
            tagIcons::play_card_4_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-5",
            "TablerIcons.play_card_5_filled()",
            tagIcons::play_card_5_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-6",
            "TablerIcons.play_card_6_filled()",
            tagIcons::play_card_6_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-7",
            "TablerIcons.play_card_7_filled()",
            tagIcons::play_card_7_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-8",
            "TablerIcons.play_card_8_filled()",
            tagIcons::play_card_8_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-9",
            "TablerIcons.play_card_9_filled()",
            tagIcons::play_card_9_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-a",
            "TablerIcons.play_card_a_filled()",
            tagIcons::play_card_a_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-j",
            "TablerIcons.play_card_j_filled()",
            tagIcons::play_card_j_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-k",
            "TablerIcons.play_card_k_filled()",
            tagIcons::play_card_k_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-q",
            "TablerIcons.play_card_q_filled()",
            tagIcons::play_card_q_filled));
    icons.add(
        new IconCatalogEntry<>(
            "play-card-star",
            "TablerIcons.play_card_star_filled()",
            tagIcons::play_card_star_filled));
    icons.add(
        new IconCatalogEntry<>(
            "puzzle", "TablerIcons.puzzle_filled()", tagIcons::puzzle_filled));
    icons.add(
        new IconCatalogEntry<>("ufo", "TablerIcons.ufo_filled()", tagIcons::ufo_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
