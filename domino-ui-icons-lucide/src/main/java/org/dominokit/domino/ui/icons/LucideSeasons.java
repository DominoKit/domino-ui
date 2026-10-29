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

/** Lucide seasons catalog category. */
public interface LucideSeasons {
  enum Icon implements LucideIconDefinition {
    FLOWER_2(
        "flower-2",
        "<path d=\"M12 5a3 3 0 1 1 3 3m-3-3a3 3 0 1 0-3 3m3-3v1M9 8a3 3 0 1 0 3 3M9 8h1m5 0a3 3 0 1 1-3 3m3-3h-1m-2 3v-1\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />\n  <path d=\"M12 10v12\" />\n  <path d=\"M12 22c4.2 0 7-1.667 7-5-4.2 0-7 1.667-7 5Z\" />\n  <path d=\"M12 22c-4.2 0-7-1.667-7-5 4.2 0 7 1.667 7 5Z\" />"),
    LEAF(
        "leaf",
        "<path d=\"M11 20a10 10 0 0010-10 25.9 25.9 0 00-1.04-7.281 1 1 0 00-1.755-.325C15.833 5.5 13 5.5 9.8 6.1A7 7 0 0011 20\" />\n  <path d=\"M2 21a5 5 0 012.911-4.544C7.613 15.212 8.351 15.24 11 13\" />"),
    ROSE(
        "rose",
        "<path d=\"M17 10h-1a4 4 0 1 1 4-4v.534\" />\n  <path d=\"M17 6h1a4 4 0 0 1 1.42 7.74l-2.29.87a6 6 0 0 1-5.339-10.68l2.069-1.31\" />\n  <path d=\"M4.5 17c2.8-.5 4.4 0 5.5.8s1.8 2.2 2.3 3.7c-2 .4-3.5.4-4.8-.3-1.2-.6-2.3-1.9-3-4.2\" />\n  <path d=\"M9.77 12C4 15 2 22 2 22\" />\n  <circle cx=\"17\" cy=\"8\" r=\"2\" />"),
    SNOWFLAKE(
        "snowflake",
        "<path d=\"m10 20-1.25-2.5L6 18\" />\n  <path d=\"M10 4 8.75 6.5 6 6\" />\n  <path d=\"m14 20 1.25-2.5L18 18\" />\n  <path d=\"m14 4 1.25 2.5L18 6\" />\n  <path d=\"m17 21-3-6h-4\" />\n  <path d=\"m17 3-3 6 1.5 3\" />\n  <path d=\"M2 12h6.5L10 9\" />\n  <path d=\"m20 10-1.5 2 1.5 2\" />\n  <path d=\"M22 12h-6.5L14 15\" />\n  <path d=\"m4 10 1.5 2L4 14\" />\n  <path d=\"m7 21 3-6-1.5-3\" />\n  <path d=\"m7 3 3 6h4\" />"),
    SUN(
        "sun",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"m17.66 17.66 1.41 1.41\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m6.34 17.66-1.41 1.41\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />"),
    TUBE_LOTION(
        "tube-lotion",
        "<path d=\"M15 18v3a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-3\" />\n  <path d=\"M17 2a2 2 0 0 1 1.6 3.2A8 8 0 0 0 17 10v6a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2v-6a8 8 0 0 0-1.6-4.8A2 2 0 0 1 7 2z\" />\n  <path d=\"M7 10a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />");

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
  default LucideIcon flower_2_seasons() {
    return LucideIcon.create(Icon.FLOWER_2);
  }

  default LucideIcon leaf_seasons() {
    return LucideIcon.create(Icon.LEAF);
  }

  default LucideIcon rose_seasons() {
    return LucideIcon.create(Icon.ROSE);
  }

  default LucideIcon snowflake_seasons() {
    return LucideIcon.create(Icon.SNOWFLAKE);
  }

  default LucideIcon sun_seasons() {
    return LucideIcon.create(Icon.SUN);
  }

  default LucideIcon tube_lotion_seasons() {
    return LucideIcon.create(Icon.TUBE_LOTION);
  }
}
