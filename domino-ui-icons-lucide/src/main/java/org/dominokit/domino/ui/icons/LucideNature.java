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

/** Lucide nature catalog category. */
public interface LucideNature {
  enum Icon implements LucideIconDefinition {
    BINOCULARS(
        "binoculars",
        "<path d=\"M10 10h4\" />\n  <path d=\"M19 7V4a1 1 0 0 0-1-1h-2a1 1 0 0 0-1 1v3\" />\n  <path d=\"M20 21a2 2 0 0 0 2-2v-3.851c0-1.39-2-2.962-2-4.829V8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v11a2 2 0 0 0 2 2z\" />\n  <path d=\"M 22 16 L 2 16\" />\n  <path d=\"M4 21a2 2 0 0 1-2-2v-3.851c0-1.39 2-2.962 2-4.829V8a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v11a2 2 0 0 1-2 2z\" />\n  <path d=\"M9 7V4a1 1 0 0 0-1-1H6a1 1 0 0 0-1 1v3\" />"),
    BIRDHOUSE(
        "birdhouse",
        "<path d=\"M12 18v4\" />\n  <path d=\"m17 18 1.956-11.468\" />\n  <path d=\"m3 8 7.82-5.615a2 2 0 0 1 2.36 0L21 8\" />\n  <path d=\"M4 18h16\" />\n  <path d=\"M7 18 5.044 6.532\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    CANNABIS(
        "cannabis",
        "<path d=\"M12 22v-4\" />\n  <path d=\"M7 12c-1.5 0-4.5 1.5-5 3 3.5 1.5 6 1 6 1-1.5 1.5-2 3.5-2 5 2.5 0 4.5-1.5 6-3 1.5 1.5 3.5 3 6 3 0-1.5-.5-3.5-2-5 0 0 2.5.5 6-1-.5-1.5-3.5-3-5-3 1.5-1 4-4 4-6-2.5 0-5.5 1.5-7 3 0-2.5-.5-5-2-7-1.5 2-2 4.5-2 7-1.5-1.5-4.5-3-7-3 0 2 2.5 5 4 6\" />"),
    CANNABIS_OFF(
        "cannabis-off",
        "<path d=\"M12 22v-4c1.5 1.5 3.5 3 6 3 0-1.5-.5-3.5-2-5\" />\n  <path d=\"M13.988 8.327C13.902 6.054 13.365 3.82 12 2a9.3 9.3 0 0 0-1.445 2.9\" />\n  <path d=\"M17.375 11.725C18.882 10.53 21 7.841 21 6c-2.324 0-5.08 1.296-6.662 2.684\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21.024 15.378A15 15 0 0 0 22 15c-.426-1.279-2.67-2.557-4.25-2.907\" />\n  <path d=\"M6.995 6.992C5.714 6.4 4.29 6 3 6c0 2 2.5 5 4 6-1.5 0-4.5 1.5-5 3 3.5 1.5 6 1 6 1-1.5 1.5-2 3.5-2 5 2.5 0 4.5-1.5 6-3\" />"),
    CARAVAN(
        "caravan",
        "<path d=\"M18 19V9a4 4 0 0 0-4-4H6a4 4 0 0 0-4 4v8a2 2 0 0 0 2 2h2\" />\n  <path d=\"M2 9h3a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1H2\" />\n  <path d=\"M22 17v1a1 1 0 0 1-1 1H10v-9a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v9\" />\n  <circle cx=\"8\" cy=\"19\" r=\"2\" />"),
    FEATHER(
        "feather",
        "<path d=\"M14.086 18.412A2 2 0 0112.67 19H5v-7.672a2 2 0 01.586-1.414L11.75 3.75a6 6 0 118.49 8.49z\" />\n  <path d=\"M16 8 2 22\" />\n  <path d=\"M17.488 15H9\" />"),
    FLAME_KINDLING(
        "flame-kindling",
        "<path d=\"M12 2c1 3 2.5 3.5 3.5 4.5A5 5 0 0 1 17 10a5 5 0 1 1-10 0c0-.3 0-.6.1-.9a2 2 0 1 0 3.3-2C8 4.5 11 2 12 2Z\" />\n  <path d=\"m5 22 14-4\" />\n  <path d=\"m5 18 14 4\" />"),
    FLOWER(
        "flower",
        "<circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"M12 16.5A4.5 4.5 0 1 1 7.5 12 4.5 4.5 0 1 1 12 7.5a4.5 4.5 0 1 1 4.5 4.5 4.5 4.5 0 1 1-4.5 4.5\" />\n  <path d=\"M12 7.5V9\" />\n  <path d=\"M7.5 12H9\" />\n  <path d=\"M16.5 12H15\" />\n  <path d=\"M12 16.5V15\" />\n  <path d=\"m8 8 1.88 1.88\" />\n  <path d=\"M14.12 9.88 16 8\" />\n  <path d=\"m8 16 1.88-1.88\" />\n  <path d=\"M14.12 14.12 16 16\" />"),
    FLOWER_2(
        "flower-2",
        "<path d=\"M12 5a3 3 0 1 1 3 3m-3-3a3 3 0 1 0-3 3m3-3v1M9 8a3 3 0 1 0 3 3M9 8h1m5 0a3 3 0 1 1-3 3m3-3h-1m-2 3v-1\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />\n  <path d=\"M12 10v12\" />\n  <path d=\"M12 22c4.2 0 7-1.667 7-5-4.2 0-7 1.667-7 5Z\" />\n  <path d=\"M12 22c-4.2 0-7-1.667-7-5 4.2 0 7 1.667 7 5Z\" />"),
    HIKING_STICK(
        "hiking-stick",
        "<path d=\"M13.5 10.5 2 22\" />\n  <path d=\"M16.352 11.648a1.205 1.205 0 01-1.704 0l-2.296-2.296a1.205 1.205 0 010-1.704l.72-.72a2 2 0 011.022-.546l.599-.12a2 2 0 001.569-1.57l.12-.598a2 2 0 01.546-1.022l.72-.72a1.205 1.205 0 011.704 0l2.296 2.296a1.205 1.205 0 010 1.704l-6.02 6.02a1 1 0 103 3l.201-.201A7.4 7.4 0 0021 9.93V7\" />\n  <path d=\"m6 21-3-3\" />"),
    LEAF(
        "leaf",
        "<path d=\"M11 20a10 10 0 0010-10 25.9 25.9 0 00-1.04-7.281 1 1 0 00-1.755-.325C15.833 5.5 13 5.5 9.8 6.1A7 7 0 0011 20\" />\n  <path d=\"M2 21a5 5 0 012.911-4.544C7.613 15.212 8.351 15.24 11 13\" />"),
    MOUNTAIN("mountain", "<path d=\"m8 3 4 8 5-5 5 15H2L8 3z\" />"),
    MOUNTAIN_SNOW(
        "mountain-snow",
        "<path d=\"m8 3 4 8 5-5 5 15H2L8 3z\" />\n  <path d=\"M4.14 15.08c2.62-1.57 5.24-1.43 7.86.42 2.74 1.94 5.49 2 8.23.19\" />"),
    PARK(
        "park",
        "<path d=\"M12 18h10\" />\n  <path d=\"M13.248 9.998A4.5 4.5 0 0 0 11.75 8.6V8a1 1 0 0 0-7.5 0 4.9 4.9 0 0 0 2.25 9H8\" />\n  <path d=\"m15 14-2 6\" />\n  <path d=\"m19 14 2 6\" />\n  <path d=\"M21 14h-8\" />\n  <path d=\"M8 20v-5.922a2 2 0 0 0-.586-1.414L6.5 11.75\" />\n  <path d=\"M9.205 12.795 8 14\" />\n  <circle cx=\"19\" cy=\"6\" r=\"2\" />"),
    PLANT_POT(
        "plant-pot",
        "<path d=\"M14 8.536V6a4 4 0 014-4h1.5a.5.5 0 01.5.5V4a4 4 0 01-4 4 4 4 0 00-4 4 5 5 0 01-8-4 5 5 0 018 4c0 2 1 3 1 5\" />\n  <path d=\"m18 17-1.085 3.58A2 2 0 0115 22H9.002a2 2 0 01-1.913-1.418L6 17\" />\n  <path d=\"M5 17h14\" />"),
    ROSE(
        "rose",
        "<path d=\"M17 10h-1a4 4 0 1 1 4-4v.534\" />\n  <path d=\"M17 6h1a4 4 0 0 1 1.42 7.74l-2.29.87a6 6 0 0 1-5.339-10.68l2.069-1.31\" />\n  <path d=\"M4.5 17c2.8-.5 4.4 0 5.5.8s1.8 2.2 2.3 3.7c-2 .4-3.5.4-4.8-.3-1.2-.6-2.3-1.9-3-4.2\" />\n  <path d=\"M9.77 12C4 15 2 22 2 22\" />\n  <circle cx=\"17\" cy=\"8\" r=\"2\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHOVEL(
        "shovel",
        "<path d=\"M21.56 4.56a1.5 1.5 0 0 1 0 2.122l-.47.47a3 3 0 0 1-4.212-.03 3 3 0 0 1 0-4.243l.44-.44a1.5 1.5 0 0 1 2.121 0z\" />\n  <path d=\"M3 22a1 1 0 0 1-1-1v-3.586a1 1 0 0 1 .293-.707l3.355-3.355a1.205 1.205 0 0 1 1.704 0l3.296 3.296a1.205 1.205 0 0 1 0 1.704l-3.355 3.355a1 1 0 0 1-.707.293z\" />\n  <path d=\"m9 15 7.879-7.878\" />"),
    SHRUB(
        "shrub",
        "<path d=\"M12 22v-5.172a2 2 0 0 0-.586-1.414L9.5 13.5\" />\n  <path d=\"M14.5 14.5 12 17\" />\n  <path d=\"M17 8.8A6 6 0 0 1 13.8 20H10A6.5 6.5 0 0 1 7 8a5 5 0 0 1 10 0z\" />"),
    SPROUT(
        "sprout",
        "<path d=\"M14 9.536V7a4 4 0 0 1 4-4h1.5a.5.5 0 0 1 .5.5V5a4 4 0 0 1-4 4 4 4 0 0 0-4 4c0 2 1 3 1 5a5 5 0 0 1-1 3\" />\n  <path d=\"M4 9a5 5 0 0 1 8 4 5 5 0 0 1-8-4\" />\n  <path d=\"M5 21h14\" />"),
    STONE(
        "stone",
        "<path d=\"M11.264 2.205A4 4 0 0 0 6.42 4.211l-4 8a4 4 0 0 0 1.359 5.117l6 4a4 4 0 0 0 4.438 0l6-4a4 4 0 0 0 1.576-4.592l-2-6a4 4 0 0 0-2.53-2.53z\" />\n  <path d=\"M11.99 22 14 12l7.822 3.184\" />\n  <path d=\"M14 12 8.47 2.302\" />"),
    TENT(
        "tent",
        "<path d=\"M3.5 21 14 3\" />\n  <path d=\"M20.5 21 10 3\" />\n  <path d=\"M15.5 21 12 15l-3.5 6\" />\n  <path d=\"M2 21h20\" />"),
    TENT_TREE(
        "tent-tree",
        "<circle cx=\"4\" cy=\"4\" r=\"2\" />\n  <path d=\"m14 5 3-3 3 3\" />\n  <path d=\"m14 10 3-3 3 3\" />\n  <path d=\"M17 14V2\" />\n  <path d=\"M17 14H7l-5 8h20Z\" />\n  <path d=\"M8 14v8\" />\n  <path d=\"m9 14 5 8\" />"),
    TREE_DECIDUOUS(
        "tree-deciduous",
        "<path d=\"M8 19a4 4 0 0 1-2.24-7.32A3.5 3.5 0 0 1 9 6.03V6a3 3 0 1 1 6 0v.04a3.5 3.5 0 0 1 3.24 5.65A4 4 0 0 1 16 19Z\" />\n  <path d=\"M12 19v3\" />"),
    TREE_PALM(
        "tree-palm",
        "<path d=\"M13 8c0-2.76-2.46-5-5.5-5S2 5.24 2 8h2l1-1 1 1h4\" />\n  <path d=\"M13 7.14A5.82 5.82 0 0 1 16.5 6c3.04 0 5.5 2.24 5.5 5h-3l-1-1-1 1h-3\" />\n  <path d=\"M5.89 9.71c-2.15 2.15-2.3 5.47-.35 7.43l4.24-4.25.7-.7.71-.71 2.12-2.12c-1.95-1.96-5.27-1.8-7.42.35\" />\n  <path d=\"M11 15.5c.5 2.5-.17 4.5-1 6.5h4c2-5.5-.5-12-1-14\" />"),
    TREE_PINE(
        "tree-pine",
        "<path d=\"m17 14 3 3.3a1 1 0 0 1-.7 1.7H4.7a1 1 0 0 1-.7-1.7L7 14h-.3a1 1 0 0 1-.7-1.7L9 9h-.2A1 1 0 0 1 8 7.3L12 3l4 4.3a1 1 0 0 1-.8 1.7H15l3 3.3a1 1 0 0 1-.7 1.7H17Z\" />\n  <path d=\"M12 22v-3\" />"),
    TREES(
        "trees",
        "<path d=\"M10 10v.2A3 3 0 0 1 8.9 16H5a3 3 0 0 1-1-5.8V10a3 3 0 0 1 6 0Z\" />\n  <path d=\"M7 16v6\" />\n  <path d=\"M13 19v3\" />\n  <path d=\"M12 19h8.3a1 1 0 0 0 .7-1.7L18 14h.3a1 1 0 0 0 .7-1.7L16 9h.2a1 1 0 0 0 .8-1.7L13 3l-1.4 1.5\" />");

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
  default LucideIcon binoculars_nature() {
    return LucideIcon.create(Icon.BINOCULARS);
  }

  default LucideIcon birdhouse_nature() {
    return LucideIcon.create(Icon.BIRDHOUSE);
  }

  default LucideIcon cannabis() {
    return LucideIcon.create(Icon.CANNABIS);
  }

  default LucideIcon cannabis_off() {
    return LucideIcon.create(Icon.CANNABIS_OFF);
  }

  default LucideIcon caravan_nature() {
    return LucideIcon.create(Icon.CARAVAN);
  }

  default LucideIcon feather_nature() {
    return LucideIcon.create(Icon.FEATHER);
  }

  default LucideIcon flame_kindling_nature() {
    return LucideIcon.create(Icon.FLAME_KINDLING);
  }

  default LucideIcon flower_nature() {
    return LucideIcon.create(Icon.FLOWER);
  }

  default LucideIcon flower_2_nature() {
    return LucideIcon.create(Icon.FLOWER_2);
  }

  default LucideIcon hiking_stick_nature() {
    return LucideIcon.create(Icon.HIKING_STICK);
  }

  default LucideIcon leaf_nature() {
    return LucideIcon.create(Icon.LEAF);
  }

  default LucideIcon mountain_nature() {
    return LucideIcon.create(Icon.MOUNTAIN);
  }

  default LucideIcon mountain_snow() {
    return LucideIcon.create(Icon.MOUNTAIN_SNOW);
  }

  default LucideIcon park_nature() {
    return LucideIcon.create(Icon.PARK);
  }

  default LucideIcon plant_pot_nature() {
    return LucideIcon.create(Icon.PLANT_POT);
  }

  default LucideIcon rose_nature() {
    return LucideIcon.create(Icon.ROSE);
  }

  default LucideIcon shell_nature() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon shovel_nature() {
    return LucideIcon.create(Icon.SHOVEL);
  }

  default LucideIcon shrub() {
    return LucideIcon.create(Icon.SHRUB);
  }

  default LucideIcon sprout_nature() {
    return LucideIcon.create(Icon.SPROUT);
  }

  default LucideIcon stone() {
    return LucideIcon.create(Icon.STONE);
  }

  default LucideIcon tent_nature() {
    return LucideIcon.create(Icon.TENT);
  }

  default LucideIcon tent_tree_nature() {
    return LucideIcon.create(Icon.TENT_TREE);
  }

  default LucideIcon tree_deciduous_nature() {
    return LucideIcon.create(Icon.TREE_DECIDUOUS);
  }

  default LucideIcon tree_palm_nature() {
    return LucideIcon.create(Icon.TREE_PALM);
  }

  default LucideIcon tree_pine_nature() {
    return LucideIcon.create(Icon.TREE_PINE);
  }

  default LucideIcon trees_nature() {
    return LucideIcon.create(Icon.TREES);
  }
}
