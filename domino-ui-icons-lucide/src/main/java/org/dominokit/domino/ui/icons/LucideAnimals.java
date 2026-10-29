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

/** Lucide animals catalog category. */
public interface LucideAnimals {
  enum Icon implements LucideIconDefinition {
    BIRD(
        "bird",
        "<path d=\"M16 7h.01\" />\n  <path d=\"M3.4 18H12a8 8 0 0 0 8-8V7a4 4 0 0 0-7.28-2.3L2 20\" />\n  <path d=\"m20 7 2 .5-2 .5\" />\n  <path d=\"M10 18v3\" />\n  <path d=\"M14 17.75V21\" />\n  <path d=\"M7 18a6 6 0 0 0 3.84-10.61\" />"),
    BIRDHOUSE(
        "birdhouse",
        "<path d=\"M12 18v4\" />\n  <path d=\"m17 18 1.956-11.468\" />\n  <path d=\"m3 8 7.82-5.615a2 2 0 0 1 2.36 0L21 8\" />\n  <path d=\"M4 18h16\" />\n  <path d=\"M7 18 5.044 6.532\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    BONE(
        "bone",
        "<path d=\"M17 10c.7-.7 1.69 0 2.5 0a2.5 2.5 0 1 0 0-5 .5.5 0 0 1-.5-.5 2.5 2.5 0 1 0-5 0c0 .81.7 1.8 0 2.5l-7 7c-.7.7-1.69 0-2.5 0a2.5 2.5 0 0 0 0 5c.28 0 .5.22.5.5a2.5 2.5 0 1 0 5 0c0-.81-.7-1.8 0-2.5Z\" />"),
    BONE_FRACTURE(
        "bone-fracture",
        "<path d=\"M14 4.5a1 1 0 0 1 5 0 .5.5 0 0 0 .5.5 1 1 0 0 1 0 5c-.81 0-1.8-.7-2.5 0l-1.958 1.957a.15.15 0 0 1-.252-.072l-.493-2.07a.15.15 0 0 0-.111-.112l-2.072-.494a.15.15 0 0 1-.072-.252L14 7c.7-.7 0-1.69 0-2.5\" />\n  <path d=\"m16 20-1-2\" />\n  <path d=\"m20 16-2-1\" />\n  <path d=\"m4 8 2 1\" />\n  <path d=\"m8 4 1 2\" />\n  <path d=\"M9.698 14.19a.15.15 0 0 0 .112.112l2.074.489a.15.15 0 0 1 .072.252L10 17c-.7.7 0 1.69 0 2.5a1 1 0 0 1-5 0 .495.495 0 0 0-.5-.5 1 1 0 0 1 0-5c.81 0 1.8.7 2.5 0l1.956-1.957a.15.15 0 0 1 .252.072z\" />"),
    BUG(
        "bug",
        "<path d=\"M12 20v-9\" />\n  <path d=\"M14 7a4 4 0 0 1 4 4v3a6 6 0 0 1-12 0v-3a4 4 0 0 1 4-4z\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M21 21a4 4 0 0 0-3.81-4\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M22 13h-4\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9 7.13V6a3 3 0 1 1 6 0v1.13\" />"),
    BUG_OFF(
        "bug-off",
        "<path d=\"M12 20v-8\" />\n  <path d=\"M12.656 7H14a4 4 0 0 1 4 4v1.344\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M17.123 17.123A6 6 0 0 1 6 14v-3a4 4 0 0 1 1.72-3.287\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M22 13h-3.344\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9.712 4.06A3 3 0 0 1 15 6v1.13\" />"),
    BUG_PLAY(
        "bug-play",
        "<path d=\"M10 19.655A6 6 0 0 1 6 14v-3a4 4 0 0 1 4-4h4a4 4 0 0 1 4 3.97\" />\n  <path d=\"M14 15.003a1 1 0 0 1 1.517-.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1-1.517-.86z\" />\n  <path d=\"M14.12 3.88 16 2\" />\n  <path d=\"M21 5a4 4 0 0 1-3.55 3.97\" />\n  <path d=\"M3 21a4 4 0 0 1 3.81-4\" />\n  <path d=\"M3 5a4 4 0 0 0 3.55 3.97\" />\n  <path d=\"M6 13H2\" />\n  <path d=\"m8 2 1.88 1.88\" />\n  <path d=\"M9 7.13V6a3 3 0 1 1 6 0v1.13\" />"),
    CAT(
        "cat",
        "<path d=\"M12 5c.67 0 1.35.09 2 .26 1.78-2 5.03-2.84 6.42-2.26 1.4.58-.42 7-.42 7 .57 1.07 1 2.24 1 3.44C21 17.9 16.97 21 12 21s-9-3-9-7.56c0-1.25.5-2.4 1-3.44 0 0-1.89-6.42-.5-7 1.39-.58 4.72.23 6.5 2.23A9.04 9.04 0 0 1 12 5Z\" />\n  <path d=\"M8 14v.5\" />\n  <path d=\"M16 14v.5\" />\n  <path d=\"M11.25 16.25h1.5L12 17l-.75-.75Z\" />"),
    DOG(
        "dog",
        "<path d=\"M11.25 16.25h1.5L12 17z\" />\n  <path d=\"M16 14v.5\" />\n  <path d=\"M4.42 11.247A13.152 13.152 0 0 0 4 14.556C4 18.728 7.582 21 12 21s8-2.272 8-6.444a11.702 11.702 0 0 0-.493-3.309\" />\n  <path d=\"M8 14v.5\" />\n  <path d=\"M8.5 8.5c-.384 1.05-1.083 2.028-2.344 2.5-1.931.722-3.576-.297-3.656-1-.113-.994 1.177-6.53 4-7 1.923-.321 3.651.845 3.651 2.235A7.497 7.497 0 0 1 14 5.277c0-1.39 1.844-2.598 3.767-2.277 2.823.47 4.113 6.006 4 7-.08.703-1.725 1.722-3.656 1-1.261-.472-1.855-1.45-2.239-2.5\" />"),
    EGG("egg", "<path d=\"M12 2C8 2 4 8 4 14a8 8 0 0 0 16 0c0-6-4-12-8-12\" />"),
    FEATHER(
        "feather",
        "<path d=\"M14.086 18.412A2 2 0 0112.67 19H5v-7.672a2 2 0 01.586-1.414L11.75 3.75a6 6 0 118.49 8.49z\" />\n  <path d=\"M16 8 2 22\" />\n  <path d=\"M17.488 15H9\" />"),
    FISH(
        "fish",
        "<path d=\"M6.5 12c.94-3.46 4.94-6 8.5-6 3.56 0 6.06 2.54 7 6-.94 3.47-3.44 6-7 6s-7.56-2.53-8.5-6Z\" />\n  <path d=\"M18 12v.5\" />\n  <path d=\"M16 17.93a9.77 9.77 0 0 1 0-11.86\" />\n  <path d=\"M7 10.67C7 8 5.58 5.97 2.73 5.5c-1 1.5-1 5 .23 6.5-1.24 1.5-1.24 5-.23 6.5C5.58 18.03 7 16 7 13.33\" />\n  <path d=\"M10.46 7.26C10.2 5.88 9.17 4.24 8 3h5.8a2 2 0 0 1 1.98 1.67l.23 1.4\" />\n  <path d=\"m16.01 17.93-.23 1.4A2 2 0 0 1 13.8 21H9.5a5.96 5.96 0 0 0 1.49-3.98\" />"),
    FISH_OFF(
        "fish-off",
        "<path d=\"M18 12.47v.03m0-.5v.47m-.475 5.056A6.744 6.744 0 0 1 15 18c-3.56 0-7.56-2.53-8.5-6 .348-1.28 1.114-2.433 2.121-3.38m3.444-2.088A8.802 8.802 0 0 1 15 6c3.56 0 6.06 2.54 7 6-.309 1.14-.786 2.177-1.413 3.058\" />\n  <path d=\"M7 10.67C7 8 5.58 5.97 2.73 5.5c-1 1.5-1 5 .23 6.5-1.24 1.5-1.24 5-.23 6.5C5.58 18.03 7 16 7 13.33m7.48-4.372A9.77 9.77 0 0 1 16 6.07m0 11.86a9.77 9.77 0 0 1-1.728-3.618\" />\n  <path d=\"m16.01 17.93-.23 1.4A2 2 0 0 1 13.8 21H9.5a5.96 5.96 0 0 0 1.49-3.98M8.53 3h5.27a2 2 0 0 1 1.98 1.67l.23 1.4M2 2l20 20\" />"),
    FISH_SYMBOL("fish-symbol", "<path d=\"M2 16s9-15 20-4C11 23 2 8 2 8\" />"),
    ORIGAMI(
        "origami",
        "<path d=\"M12 12V4a1 1 0 0 1 1-1h6.297a1 1 0 0 1 .651 1.759l-4.696 4.025\" />\n  <path d=\"m12 21-7.414-7.414A2 2 0 0 1 4 12.172V6.415a1.002 1.002 0 0 1 1.707-.707L20 20.009\" />\n  <path d=\"m12.214 3.381 8.414 14.966a1 1 0 0 1-.167 1.199l-1.168 1.163a1 1 0 0 1-.706.291H6.351a1 1 0 0 1-.625-.219L3.25 18.8a1 1 0 0 1 .631-1.781l4.165.027\" />"),
    PANDA(
        "panda",
        "<path d=\"M11.25 17.25h1.5L12 18z\" />\n  <path d=\"m15 12 2 2\" />\n  <path d=\"M17.902 6.599a8 8 0 0 0-.5-.5\" />\n  <path d=\"M2 14.5C2 19.47 6.48 22 12 22s10-2.53 10-7.5a10 10 0 0 0-1.3-4.83 4.5 4.5 0 1 0-7.05-5.5 8 8 0 0 0-3.3 0 4.5 4.5 0 1 0-7.04 5.5A10 10 0 0 0 2 14.5\" />\n  <path d=\"M6.099 6.599a8 8 0 0 1 .5-.5\" />\n  <path d=\"m9 12-2 2\" />"),
    PAW_PRINT(
        "paw-print",
        "<circle cx=\"11\" cy=\"4\" r=\"2\" />\n  <circle cx=\"18\" cy=\"8\" r=\"2\" />\n  <circle cx=\"20\" cy=\"16\" r=\"2\" />\n  <path d=\"M9 10a5 5 0 0 1 5 5v3.5a3.5 3.5 0 0 1-6.84 1.045Q6.52 17.48 4.46 16.84A3.5 3.5 0 0 1 5.5 10Z\" />"),
    RABBIT(
        "rabbit",
        "<path d=\"M13 16a3 3 0 0 1 2.24 5\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M18 21h-8a4 4 0 0 1-4-4 7 7 0 0 1 7-7h.2L9.6 6.4a1 1 0 1 1 2.8-2.8L15.8 7h.2c3.3 0 6 2.7 6 6v1a2 2 0 0 1-2 2h-1a3 3 0 0 0-3 3\" />\n  <path d=\"M20 8.54V4a2 2 0 1 0-4 0v3\" />\n  <path d=\"M7.612 12.524a3 3 0 1 0-1.6 4.3\" />"),
    RAT(
        "rat",
        "<path d=\"M13 22H4a2 2 0 0 1 0-4h12\" />\n  <path d=\"M13.236 18a3 3 0 0 0-2.2-5\" />\n  <path d=\"M16 9h.01\" />\n  <path d=\"M16.82 3.94a3 3 0 1 1 3.237 4.868l1.815 2.587a1.5 1.5 0 0 1-1.5 2.1l-2.872-.453a3 3 0 0 0-3.5 3\" />\n  <path d=\"M17 4.988a3 3 0 1 0-5.2 2.052A7 7 0 0 0 4 14.015 4 4 0 0 0 8 18\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHRIMP(
        "shrimp",
        "<path d=\"M10 2a3.28 3.28 0 003.227 1.798l6.17-.561A1 1 0 1119.614 8H8.5a6.44 6.44 0 00-5.63 9.75A6.5 6.5 0 008.5 21c1.38 0 2-.5 2.5-1\" />\n  <path d=\"M10 8a8.5 8.5 0 000 8\" />\n  <path d=\"M11 22c-.5-.5-1.12-1-2.5-1a1 1 0 010-5H12a7 7 0 007-7V8\" />\n  <path d=\"M13 12h.01\" />\n  <path d=\"M8 16c-2 0-4.5-4-4-6\" />"),
    SHRIMP_OFF(
        "shrimp-off",
        "<path d=\"M10 2a3.28 3.28 0 003.227 1.798l6.17-.561A1 1 0 1119.614 8H13.5\" />\n  <path d=\"M11 20c-.5.5-1.12 1-2.5 1a1 1 0 010-5H12a7 7 0 003.283-.817\" />\n  <path d=\"M11 22c-.5-.5-1.12-1-2.5-1a6.5 6.5 0 01-5.63-3.25 6.44 6.44 0 015.236-9.744\" />\n  <path d=\"M18.04 12.54A7 7 0 0019 9V8\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8 16c-2 0-4.5-4-4-6\" />\n  <path d=\"M9.43 9.33A8.5 8.5 0 0010 16\" />"),
    SNAIL(
        "snail",
        "<path d=\"M2 13a6 6 0 1 0 12 0 4 4 0 1 0-8 0 2 2 0 0 0 4 0\" />\n  <circle cx=\"10\" cy=\"13\" r=\"8\" />\n  <path d=\"M2 21h12c4.4 0 8-3.6 8-8V7a2 2 0 1 0-4 0v6\" />\n  <path d=\"M18 3 19.1 5.2\" />\n  <path d=\"M22 3 20.9 5.2\" />"),
    SQUIRREL(
        "squirrel",
        "<path d=\"M15.236 22a3 3 0 0 0-2.2-5\" />\n  <path d=\"M16 20a3 3 0 0 1 3-3h1a2 2 0 0 0 2-2v-2a4 4 0 0 0-4-4V4\" />\n  <path d=\"M18 13h.01\" />\n  <path d=\"M18 6a4 4 0 0 0-4 4 7 7 0 0 0-7 7c0-5 4-5 4-10.5a4.5 4.5 0 1 0-9 0 2.5 2.5 0 0 0 5 0C7 10 3 11 3 17c0 2.8 2.2 5 5 5h10\" />"),
    TURTLE(
        "turtle",
        "<path d=\"m12 10 2 4v3a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-3a8 8 0 1 0-16 0v3a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-3l2-4h4Z\" />\n  <path d=\"M4.82 7.9 8 10\" />\n  <path d=\"M15.18 7.9 12 10\" />\n  <path d=\"M16.93 10H20a2 2 0 0 1 0 4H2\" />"),
    WORM(
        "worm",
        "<path d=\"m19 12-1.5 3\" />\n  <path d=\"M19.63 18.81 22 20\" />\n  <path d=\"M6.47 8.23a1.68 1.68 0 0 1 2.44 1.93l-.64 2.08a6.76 6.76 0 0 0 10.16 7.67l.42-.27a1 1 0 1 0-2.73-4.21l-.42.27a1.76 1.76 0 0 1-2.63-1.99l.64-2.08A6.66 6.66 0 0 0 3.94 3.9l-.7.4a1 1 0 1 0 2.55 4.34z\" />");

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
  default LucideIcon bird() {
    return LucideIcon.create(Icon.BIRD);
  }

  default LucideIcon birdhouse_animals() {
    return LucideIcon.create(Icon.BIRDHOUSE);
  }

  default LucideIcon bone_animals() {
    return LucideIcon.create(Icon.BONE);
  }

  default LucideIcon bone_fracture_animals() {
    return LucideIcon.create(Icon.BONE_FRACTURE);
  }

  default LucideIcon bug_animals() {
    return LucideIcon.create(Icon.BUG);
  }

  default LucideIcon bug_off_animals() {
    return LucideIcon.create(Icon.BUG_OFF);
  }

  default LucideIcon bug_play_animals() {
    return LucideIcon.create(Icon.BUG_PLAY);
  }

  default LucideIcon cat() {
    return LucideIcon.create(Icon.CAT);
  }

  default LucideIcon dog() {
    return LucideIcon.create(Icon.DOG);
  }

  default LucideIcon egg() {
    return LucideIcon.create(Icon.EGG);
  }

  default LucideIcon feather_animals() {
    return LucideIcon.create(Icon.FEATHER);
  }

  default LucideIcon fish() {
    return LucideIcon.create(Icon.FISH);
  }

  default LucideIcon fish_off() {
    return LucideIcon.create(Icon.FISH_OFF);
  }

  default LucideIcon fish_symbol() {
    return LucideIcon.create(Icon.FISH_SYMBOL);
  }

  default LucideIcon origami_animals() {
    return LucideIcon.create(Icon.ORIGAMI);
  }

  default LucideIcon panda() {
    return LucideIcon.create(Icon.PANDA);
  }

  default LucideIcon paw_print() {
    return LucideIcon.create(Icon.PAW_PRINT);
  }

  default LucideIcon rabbit() {
    return LucideIcon.create(Icon.RABBIT);
  }

  default LucideIcon rat() {
    return LucideIcon.create(Icon.RAT);
  }

  default LucideIcon shell_animals() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon shrimp() {
    return LucideIcon.create(Icon.SHRIMP);
  }

  default LucideIcon shrimp_off() {
    return LucideIcon.create(Icon.SHRIMP_OFF);
  }

  default LucideIcon snail() {
    return LucideIcon.create(Icon.SNAIL);
  }

  default LucideIcon squirrel() {
    return LucideIcon.create(Icon.SQUIRREL);
  }

  default LucideIcon turtle() {
    return LucideIcon.create(Icon.TURTLE);
  }

  default LucideIcon worm_animals() {
    return LucideIcon.create(Icon.WORM);
  }
}
