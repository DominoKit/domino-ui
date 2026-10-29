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

/** Lucide sustainability catalog category. */
public interface LucideSustainability {
  enum Icon implements LucideIconDefinition {
    DAM(
        "dam",
        "<path d=\"M11 11.31c1.17.56 1.54 1.69 3.5 1.69 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M11.75 18c.35.5 1.45 1 2.75 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <path d=\"M2 6h4\" />\n  <path d=\"M7 3a1 1 0 0 0-1 1v16a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1L10 4a1 1 0 0 0-1-1z\" />"),
    FLOWER(
        "flower",
        "<circle cx=\"12\" cy=\"12\" r=\"3\" />\n  <path d=\"M12 16.5A4.5 4.5 0 1 1 7.5 12 4.5 4.5 0 1 1 12 7.5a4.5 4.5 0 1 1 4.5 4.5 4.5 4.5 0 1 1-4.5 4.5\" />\n  <path d=\"M12 7.5V9\" />\n  <path d=\"M7.5 12H9\" />\n  <path d=\"M16.5 12H15\" />\n  <path d=\"M12 16.5V15\" />\n  <path d=\"m8 8 1.88 1.88\" />\n  <path d=\"M14.12 9.88 16 8\" />\n  <path d=\"m8 16 1.88-1.88\" />\n  <path d=\"M14.12 14.12 16 16\" />"),
    FLOWER_2(
        "flower-2",
        "<path d=\"M12 5a3 3 0 1 1 3 3m-3-3a3 3 0 1 0-3 3m3-3v1M9 8a3 3 0 1 0 3 3M9 8h1m5 0a3 3 0 1 1-3 3m3-3h-1m-2 3v-1\" />\n  <circle cx=\"12\" cy=\"8\" r=\"2\" />\n  <path d=\"M12 10v12\" />\n  <path d=\"M12 22c4.2 0 7-1.667 7-5-4.2 0-7 1.667-7 5Z\" />\n  <path d=\"M12 22c-4.2 0-7-1.667-7-5 4.2 0 7 1.667 7 5Z\" />"),
    HOUSE_PLUG(
        "house-plug",
        "<path d=\"M10 12V8.964\" />\n  <path d=\"M14 12V8.964\" />\n  <path d=\"M15 12a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2h-4a2 2 0 0 1-2-2v-2a1 1 0 0 1 1-1z\" />\n  <path d=\"M8.5 21H5a2 2 0 0 1-2-2v-9a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2h-5a2 2 0 0 1-2-2v-2\" />"),
    LEAF(
        "leaf",
        "<path d=\"M11 20a10 10 0 0010-10 25.9 25.9 0 00-1.04-7.281 1 1 0 00-1.755-.325C15.833 5.5 13 5.5 9.8 6.1A7 7 0 0011 20\" />\n  <path d=\"M2 21a5 5 0 012.911-4.544C7.613 15.212 8.351 15.24 11 13\" />"),
    LEAFY_GREEN(
        "leafy-green",
        "<path d=\"M2 22c1.25-.987 2.27-1.975 3.9-2.2a5.56 5.56 0 0 1 3.8 1.5 4 4 0 0 0 6.187-2.353 3.5 3.5 0 0 0 3.69-5.116A3.5 3.5 0 0 0 20.95 8 3.5 3.5 0 1 0 16 3.05a3.5 3.5 0 0 0-5.831 1.373 3.5 3.5 0 0 0-5.116 3.69 4 4 0 0 0-2.348 6.155C3.499 15.42 4.409 16.712 4.2 18.1 3.926 19.743 3.014 20.732 2 22\" />\n  <path d=\"M2 22 17 7\" />"),
    RECYCLE(
        "recycle",
        "<path d=\"M7 19H4.815a1.83 1.83 0 0 1-1.57-.881 1.785 1.785 0 0 1-.004-1.784L7.196 9.5\" />\n  <path d=\"M11 19h8.203a1.83 1.83 0 0 0 1.556-.89 1.784 1.784 0 0 0 0-1.775l-1.226-2.12\" />\n  <path d=\"m14 16-3 3 3 3\" />\n  <path d=\"M8.293 13.596 7.196 9.5 3.1 10.598\" />\n  <path d=\"m9.344 5.811 1.093-1.892A1.83 1.83 0 0 1 11.985 3a1.784 1.784 0 0 1 1.546.888l3.943 6.843\" />\n  <path d=\"m13.378 9.633 4.096 1.098 1.097-4.096\" />"),
    ROSE(
        "rose",
        "<path d=\"M17 10h-1a4 4 0 1 1 4-4v.534\" />\n  <path d=\"M17 6h1a4 4 0 0 1 1.42 7.74l-2.29.87a6 6 0 0 1-5.339-10.68l2.069-1.31\" />\n  <path d=\"M4.5 17c2.8-.5 4.4 0 5.5.8s1.8 2.2 2.3 3.7c-2 .4-3.5.4-4.8-.3-1.2-.6-2.3-1.9-3-4.2\" />\n  <path d=\"M9.77 12C4 15 2 22 2 22\" />\n  <circle cx=\"17\" cy=\"8\" r=\"2\" />"),
    SOLAR_PANEL(
        "solar-panel",
        "<path d=\"M11 2h2\" />\n  <path d=\"m14.28 14-4.56 8\" />\n  <path d=\"m21 22-1.558-4H4.558\" />\n  <path d=\"M3 10v2\" />\n  <path d=\"M6.245 15.04A2 2 0 0 1 8 14h12a1 1 0 0 1 .864 1.505l-3.11 5.457A2 2 0 0 1 16 22H4a1 1 0 0 1-.863-1.506z\" />\n  <path d=\"M7 2a4 4 0 0 1-4 4\" />\n  <path d=\"m8.66 7.66 1.41 1.41\" />"),
    SPROUT(
        "sprout",
        "<path d=\"M14 9.536V7a4 4 0 0 1 4-4h1.5a.5.5 0 0 1 .5.5V5a4 4 0 0 1-4 4 4 4 0 0 0-4 4c0 2 1 3 1 5a5 5 0 0 1-1 3\" />\n  <path d=\"M4 9a5 5 0 0 1 8 4 5 5 0 0 1-8-4\" />\n  <path d=\"M5 21h14\" />"),
    SUN(
        "sun",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"m17.66 17.66 1.41 1.41\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m6.34 17.66-1.41 1.41\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />"),
    TENT(
        "tent",
        "<path d=\"M3.5 21 14 3\" />\n  <path d=\"M20.5 21 10 3\" />\n  <path d=\"M15.5 21 12 15l-3.5 6\" />\n  <path d=\"M2 21h20\" />"),
    TRACTOR(
        "tractor",
        "<path d=\"m10 11 11 .9a1 1 0 0 1 .8 1.1l-.665 4.158a1 1 0 0 1-.988.842H20\" />\n  <path d=\"M16 18h-5\" />\n  <path d=\"M18 5a1 1 0 0 0-1 1v5.573\" />\n  <path d=\"M3 4h8.129a1 1 0 0 1 .99.863L13 11.246\" />\n  <path d=\"M4 11V4\" />\n  <path d=\"M7 15h.01\" />\n  <path d=\"M8 10.1V4\" />\n  <circle cx=\"18\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"15\" r=\"5\" />"),
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
        "<path d=\"M10 10v.2A3 3 0 0 1 8.9 16H5a3 3 0 0 1-1-5.8V10a3 3 0 0 1 6 0Z\" />\n  <path d=\"M7 16v6\" />\n  <path d=\"M13 19v3\" />\n  <path d=\"M12 19h8.3a1 1 0 0 0 .7-1.7L18 14h.3a1 1 0 0 0 .7-1.7L16 9h.2a1 1 0 0 0 .8-1.7L13 3l-1.4 1.5\" />"),
    UTILITY_POLE(
        "utility-pole",
        "<path d=\"M12 2v20\" />\n  <path d=\"M2 5h20\" />\n  <path d=\"M3 3v2\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M17 3v2\" />\n  <path d=\"M21 3v2\" />\n  <path d=\"m19 5-7 7-7-7\" />"),
    VEGAN(
        "vegan",
        "<path d=\"M16 8q6 0 6-6-6 0-6 6\" />\n  <path d=\"M17.41 3.59a10 10 0 1 0 3 3\" />\n  <path d=\"M2 2a26.6 26.6 0 0 1 10 20c.9-6.82 1.5-9.5 4-14\" />"),
    WAVES_ARROW_DOWN(
        "waves-arrow-down",
        "<path d=\"M12 10L12 2\" />\n  <path d=\"M16 6L12 10L8 6\" />\n  <path d=\"M2 15C2.6 15.5 3.2 16 4.5 16C7 16 7 14 9.5 14C12.1 14 11.9 16 14.5 16C17 16 17 14 19.5 14C20.8 14 21.4 14.5 22 15\" />\n  <path d=\"M2 21C2.6 21.5 3.2 22 4.5 22C7 22 7 20 9.5 20C12.1 20 11.9 22 14.5 22C17 22 17 20 19.5 20C20.8 20 21.4 20.5 22 21\" />"),
    WAVES_ARROW_UP(
        "waves-arrow-up",
        "<path d=\"M12 2v8\" />\n  <path d=\"M2 15c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M2 21c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"m8 6 4-4 4 4\" />"),
    WAVES_HORIZONTAL(
        "waves-horizontal",
        "<path d=\"M2 12q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 19q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 5q2.5 2 5 0t5 0 5 0 5 0\" />"),
    WAVES_VERTICAL(
        "waves-vertical",
        "<path d=\"M12 2q2 2.5 0 5t0 5 0 5 0 5\" />\n  <path d=\"M19 2q2 2.5 0 5t0 5 0 5 0 5\" />\n  <path d=\"M5 2q2 2.5 0 5t0 5 0 5 0 5\" />"),
    WIND(
        "wind",
        "<path d=\"M12.8 19.6A2 2 0 1 0 14 16H2\" />\n  <path d=\"M17.5 8a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"M9.8 4.4A2 2 0 1 1 11 8H2\" />"),
    WIND_ARROW_DOWN(
        "wind-arrow-down",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 4 4-4\" />"),
    WIND_ARROW_UP(
        "wind-arrow-up",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 -4 4 4\" />");

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
  default LucideIcon dam_sustainability() {
    return LucideIcon.create(Icon.DAM);
  }

  default LucideIcon flower_sustainability() {
    return LucideIcon.create(Icon.FLOWER);
  }

  default LucideIcon flower_2_sustainability() {
    return LucideIcon.create(Icon.FLOWER_2);
  }

  default LucideIcon house_plug_sustainability() {
    return LucideIcon.create(Icon.HOUSE_PLUG);
  }

  default LucideIcon leaf_sustainability() {
    return LucideIcon.create(Icon.LEAF);
  }

  default LucideIcon leafy_green_sustainability() {
    return LucideIcon.create(Icon.LEAFY_GREEN);
  }

  default LucideIcon recycle() {
    return LucideIcon.create(Icon.RECYCLE);
  }

  default LucideIcon rose_sustainability() {
    return LucideIcon.create(Icon.ROSE);
  }

  default LucideIcon solar_panel_sustainability() {
    return LucideIcon.create(Icon.SOLAR_PANEL);
  }

  default LucideIcon sprout_sustainability() {
    return LucideIcon.create(Icon.SPROUT);
  }

  default LucideIcon sun_sustainability() {
    return LucideIcon.create(Icon.SUN);
  }

  default LucideIcon tent_sustainability() {
    return LucideIcon.create(Icon.TENT);
  }

  default LucideIcon tractor_sustainability() {
    return LucideIcon.create(Icon.TRACTOR);
  }

  default LucideIcon tree_deciduous_sustainability() {
    return LucideIcon.create(Icon.TREE_DECIDUOUS);
  }

  default LucideIcon tree_palm_sustainability() {
    return LucideIcon.create(Icon.TREE_PALM);
  }

  default LucideIcon tree_pine_sustainability() {
    return LucideIcon.create(Icon.TREE_PINE);
  }

  default LucideIcon trees_sustainability() {
    return LucideIcon.create(Icon.TREES);
  }

  default LucideIcon utility_pole_sustainability() {
    return LucideIcon.create(Icon.UTILITY_POLE);
  }

  default LucideIcon vegan() {
    return LucideIcon.create(Icon.VEGAN);
  }

  default LucideIcon waves_arrow_down_sustainability() {
    return LucideIcon.create(Icon.WAVES_ARROW_DOWN);
  }

  default LucideIcon waves_arrow_up_sustainability() {
    return LucideIcon.create(Icon.WAVES_ARROW_UP);
  }

  default LucideIcon waves_horizontal_sustainability() {
    return LucideIcon.create(Icon.WAVES_HORIZONTAL);
  }

  default LucideIcon waves_vertical_sustainability() {
    return LucideIcon.create(Icon.WAVES_VERTICAL);
  }

  default LucideIcon wind_sustainability() {
    return LucideIcon.create(Icon.WIND);
  }

  default LucideIcon wind_arrow_down_sustainability() {
    return LucideIcon.create(Icon.WIND_ARROW_DOWN);
  }

  default LucideIcon wind_arrow_up_sustainability() {
    return LucideIcon.create(Icon.WIND_ARROW_UP);
  }
}
