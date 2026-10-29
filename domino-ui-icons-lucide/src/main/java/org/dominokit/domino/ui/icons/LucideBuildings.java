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

/** Lucide buildings catalog category. */
public interface LucideBuildings {
  enum Icon implements LucideIconDefinition {
    ANVIL(
        "anvil",
        "<path d=\"M7 10H6a4 4 0 0 1-4-4 1 1 0 0 1 1-1h4\" />\n  <path d=\"M7 5a1 1 0 0 1 1-1h13a1 1 0 0 1 1 1 7 7 0 0 1-7 7H8a1 1 0 0 1-1-1z\" />\n  <path d=\"M9 12v5\" />\n  <path d=\"M15 12v5\" />\n  <path d=\"M5 20a3 3 0 0 1 3-3h8a3 3 0 0 1 3 3 1 1 0 0 1-1 1H6a1 1 0 0 1-1-1\" />"),
    BRICK_WALL(
        "brick-wall",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M12 9v6\" />\n  <path d=\"M16 15v6\" />\n  <path d=\"M16 3v6\" />\n  <path d=\"M3 15h18\" />\n  <path d=\"M3 9h18\" />\n  <path d=\"M8 15v6\" />\n  <path d=\"M8 3v6\" />"),
    BRIDGE(
        "bridge",
        "<path d=\"M10 9.728V16\" />\n  <path d=\"M14 9.728V16\" />\n  <path d=\"M18 20V4\" />\n  <path d=\"m22 11-4-4A7.5 7.5 0 0 1 6 7l-4 4\" />\n  <path d=\"M22 16H2\" />\n  <path d=\"M6 20V4\" />"),
    BUILDING(
        "building",
        "<path d=\"M12 10h.01\" />\n  <path d=\"M12 14h.01\" />\n  <path d=\"M12 6h.01\" />\n  <path d=\"M16 10h.01\" />\n  <path d=\"M16 14h.01\" />\n  <path d=\"M16 6h.01\" />\n  <path d=\"M8 10h.01\" />\n  <path d=\"M8 14h.01\" />\n  <path d=\"M8 6h.01\" />\n  <path d=\"M9 22v-3a1 1 0 0 1 1-1h4a1 1 0 0 1 1 1v3\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    BUILDING_COMPLEX(
        "building-complex",
        "<path d=\"M10 12h4\" />\n  <path d=\"M10 8h4\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M6 10H4a2 2 0 0 0-2 2v7a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2V9a2 2 0 0 0-2-2h-2\" />\n  <path d=\"M6 21V5a2 2 0 0 1 2-2h8a2 2 0 0 1 2 2v16\" />"),
    BUILDING_COMPLEX_PLUS(
        "building-complex-plus",
        "<path d=\"M10 12h4\" />\n  <path d=\"M10 21v-3a2 2 0 013.05-1.702\" />\n  <path d=\"M10 8h4\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M18 7h2a2 2 0 012 2v4.355\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M6 10H4a2 2 0 00-2 2v7a2 2 0 002 2h8.535\" />\n  <path d=\"M6 21V5a2 2 0 012-2h8a2 2 0 012 2v7.126\" />"),
    CASTLE(
        "castle",
        "<path d=\"M10 5V3\" />\n  <path d=\"M14 5V3\" />\n  <path d=\"M15 21v-3a3 3 0 0 0-6 0v3\" />\n  <path d=\"M18 3v8\" />\n  <path d=\"M18 5H6\" />\n  <path d=\"M22 11H2\" />\n  <path d=\"M22 9v10a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V9\" />\n  <path d=\"M6 3v8\" />"),
    CHURCH(
        "church",
        "<path d=\"M10 9h4\" />\n  <path d=\"M12 7v5\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"m18 9 3.52 2.147a1 1 0 0 1 .48.854V19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-6.999a1 1 0 0 1 .48-.854L6 9\" />\n  <path d=\"M6 21V7a1 1 0 0 1 .376-.782l5-3.999a1 1 0 0 1 1.249.001l5 4A1 1 0 0 1 18 7v14\" />"),
    DAM(
        "dam",
        "<path d=\"M11 11.31c1.17.56 1.54 1.69 3.5 1.69 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M11.75 18c.35.5 1.45 1 2.75 1 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M2 10h4\" />\n  <path d=\"M2 14h4\" />\n  <path d=\"M2 18h4\" />\n  <path d=\"M2 6h4\" />\n  <path d=\"M7 3a1 1 0 0 0-1 1v16a1 1 0 0 0 1 1h4a1 1 0 0 0 1-1L10 4a1 1 0 0 0-1-1z\" />"),
    DOME(
        "dome",
        "<path d=\"M10 21v-3a2 2 0 014 0v3\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M18 12v9\" />\n  <path d=\"M22 19a2 2 0 01-2 2H4a2 2 0 01-2-2v-6a1 1 0 011-1h18a1 1 0 011 1z\" />\n  <path d=\"M4 12a8 8 0 0116 0\" />\n  <path d=\"M6 12v9\" />"),
    FACTORY(
        "factory",
        "<path d=\"M12 16h.01\" />\n  <path d=\"M16 16h.01\" />\n  <path d=\"M3 19a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V8.5a.5.5 0 0 0-.769-.422l-4.462 2.844A.5.5 0 0 1 15 10.5v-2a.5.5 0 0 0-.769-.422L9.77 10.922A.5.5 0 0 1 9 10.5V5a2 2 0 0 0-2-2H5a2 2 0 0 0-2 2z\" />\n  <path d=\"M8 16h.01\" />"),
    FENCE(
        "fence",
        "<path d=\"M4 3 2 5v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />\n  <path d=\"M6 8h4\" />\n  <path d=\"M6 18h4\" />\n  <path d=\"m12 3-2 2v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />\n  <path d=\"M14 8h4\" />\n  <path d=\"M14 18h4\" />\n  <path d=\"m20 3-2 2v15c0 .6.4 1 1 1h2c.6 0 1-.4 1-1V5Z\" />"),
    GRADUATION_CAP(
        "graduation-cap",
        "<path d=\"M21.42 10.922a1 1 0 0 0-.019-1.838L12.83 5.18a2 2 0 0 0-1.66 0L2.6 9.08a1 1 0 0 0 0 1.832l8.57 3.908a2 2 0 0 0 1.66 0z\" />\n  <path d=\"M22 10v6\" />\n  <path d=\"M6 12.5V16a6 3 0 0 0 12 0v-3.5\" />"),
    HOSPITAL(
        "hospital",
        "<path d=\"M12 7v4\" />\n  <path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M14 9h-4\" />\n  <path d=\"M18 11h2a2 2 0 0 1 2 2v6a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2v-9a2 2 0 0 1 2-2h2\" />\n  <path d=\"M18 21V5a2 2 0 0 0-2-2H8a2 2 0 0 0-2 2v16\" />"),
    HOTEL(
        "hotel",
        "<path d=\"M10 22v-6.57\" />\n  <path d=\"M12 11h.01\" />\n  <path d=\"M12 7h.01\" />\n  <path d=\"M14 15.43V22\" />\n  <path d=\"M15 16a5 5 0 0 0-6 0\" />\n  <path d=\"M16 11h.01\" />\n  <path d=\"M16 7h.01\" />\n  <path d=\"M8 11h.01\" />\n  <path d=\"M8 7h.01\" />\n  <rect x=\"4\" y=\"2\" width=\"16\" height=\"20\" rx=\"2\" />"),
    HOUSE(
        "house",
        "<path d=\"M15 21v-8a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v8\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    HOUSE_COG(
        "house-cog",
        "<path d=\"M10.584 21H5a2 2 0 01-2-2v-9a2 2 0 01.709-1.527l7-6a2 2 0 012.582 0l7 6A2 2 0 0121 10.001v.583\" />\n  <path d=\"M14 12H10a1 1 0 00-1 1v8\" />\n  <path d=\"m14.305 19.53.923-.382\" />\n  <path d=\"m15.229 16.852-.924-.383\" />\n  <path d=\"m16.852 15.228-.383-.923\" />\n  <path d=\"m16.852 20.773-.383.924\" />\n  <path d=\"m19.148 15.228.383-.923\" />\n  <path d=\"m19.53 21.697-.382-.924\" />\n  <path d=\"m20.773 16.852.922-.383\" />\n  <path d=\"m20.773 19.148.922.383\" />\n  <circle cx=\"18\" cy=\"18\" r=\"3\" />"),
    HOUSE_HEART(
        "house-heart",
        "<path d=\"M8.62 13.8A2.25 2.25 0 1 1 12 10.836a2.25 2.25 0 1 1 3.38 2.966l-2.626 2.856a.998.998 0 0 1-1.507 0z\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />"),
    HOUSE_PLUG(
        "house-plug",
        "<path d=\"M10 12V8.964\" />\n  <path d=\"M14 12V8.964\" />\n  <path d=\"M15 12a1 1 0 0 1 1 1v2a2 2 0 0 1-2 2h-4a2 2 0 0 1-2-2v-2a1 1 0 0 1 1-1z\" />\n  <path d=\"M8.5 21H5a2 2 0 0 1-2-2v-9a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2h-5a2 2 0 0 1-2-2v-2\" />"),
    HOUSE_PLUS(
        "house-plus",
        "<path d=\"M12.35 21H5a2 2 0 0 1-2-2v-9a2 2 0 0 1 .71-1.53l7-6a2 2 0 0 1 2.58 0l7 6A2 2 0 0 1 21 10v2.35\" />\n  <path d=\"M14.8 12.4A1 1 0 0 0 14 12h-4a1 1 0 0 0-1 1v8\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    HOUSE_WIFI(
        "house-wifi",
        "<path d=\"M9.5 13.866a4 4 0 0 1 5 .01\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M3 10a2 2 0 0 1 .709-1.528l7-6a2 2 0 0 1 2.582 0l7 6A2 2 0 0 1 21 10v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z\" />\n  <path d=\"M7 10.754a8 8 0 0 1 10 0\" />"),
    HOUSES(
        "houses",
        "<path d=\"m12.681 4.24.834-.715a1.45 1.45 0 011.88 0l5.09 4.364A1.45 1.45 0 0121 9v6.546a1.45 1.45 0 01-1 1.381\" />\n  <path d=\"M15.485 11.889A1.45 1.45 0 0116 13v6.546A1.454 1.454 0 0114.546 21H4.364a1.454 1.454 0 01-1.454-1.454V13a1.45 1.45 0 01.515-1.111l5.09-4.364a1.45 1.45 0 011.88 0z\" />\n  <path d=\"M7.41 20.546v-4a1 1 0 011-1h2a1 1 0 011 1v4\" />"),
    LANDMARK(
        "landmark",
        "<path d=\"M10 18v-7\" />\n  <path d=\"M11.119 2.205a2 2 0 0 1 1.762 0l7.84 3.846A.5.5 0 0 1 20.5 7h-17a.5.5 0 0 1-.22-.949z\" />\n  <path d=\"M14 18v-7\" />\n  <path d=\"M18 18v-7\" />\n  <path d=\"M3 22h18\" />\n  <path d=\"M6 18v-7\" />"),
    LIGHTHOUSE(
        "lighthouse",
        "<path d=\"M12 3V2\" />\n  <path d=\"M16.066 16.865 7 22l2-11V6a3 3 0 016 0v5l2 11\" />\n  <path d=\"m19.792 4.5.866-.5\" />\n  <path d=\"m19.797 13.5.866.5\" />\n  <path d=\"M21 9h1\" />\n  <path d=\"M3 9H2\" />\n  <path d=\"m4.203 13.5-.866.5\" />\n  <path d=\"M4.208 4.5 3.342 4\" />\n  <path d=\"M5.5 22h13\" />\n  <path d=\"m7.932 16.875 7.377-4.178\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h8\" />"),
    MOSQUE(
        "mosque",
        "<path d=\"M12.268 2a2 2 0 003.465 2\" />\n  <path d=\"M14 5 L14 8\" />\n  <path d=\"M16 22v-3a2 2 0 00-4 0v3\" />\n  <path d=\"M21 13c-.662-1.497-1.666-2.753-2.9-3.63C16.825 8.47 15.422 8 14 8s-2.826.47-4.1 1.37C8.668 10.248 7.663 11.504 7 13z\" />\n  <path d=\"M3 9h4\" />\n  <path d=\"M7 22V6a5 5 0 00-2-4 5 5 0 00-2 4v14a2 2 0 002 2h14a2 2 0 002-2v-7\" />"),
    SCHOOL(
        "school",
        "<path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M18 4.933V21\" />\n  <path d=\"m4 6 7.106-3.79a2 2 0 0 1 1.788 0L20 6\" />\n  <path d=\"m6 11-3.52 2.147a1 1 0 0 0-.48.854V19a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-5a1 1 0 0 0-.48-.853L18 11\" />\n  <path d=\"M6 4.933V21\" />\n  <circle cx=\"12\" cy=\"9\" r=\"2\" />"),
    STORE(
        "store",
        "<path d=\"M15 21v-5a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v5\" />\n  <path d=\"M17.774 10.31a1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.451 0 1.12 1.12 0 0 0-1.548 0 2.5 2.5 0 0 1-3.452 0 1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.77-3.248l2.889-4.184A2 2 0 0 1 7 2h10a2 2 0 0 1 1.653.873l2.895 4.192a2.5 2.5 0 0 1-3.774 3.244\" />\n  <path d=\"M4 10.95V19a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8.05\" />"),
    THEATER(
        "theater",
        "<path d=\"M2 10s3-3 3-8\" />\n  <path d=\"M22 10s-3-3-3-8\" />\n  <path d=\"M10 2c0 4.4-3.6 8-8 8\" />\n  <path d=\"M14 2c0 4.4 3.6 8 8 8\" />\n  <path d=\"M2 10s2 2 2 5\" />\n  <path d=\"M22 10s-2 2-2 5\" />\n  <path d=\"M8 15h8\" />\n  <path d=\"M2 22v-1a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v1\" />\n  <path d=\"M14 22v-1a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v1\" />"),
    UNIVERSITY(
        "university",
        "<path d=\"M14 21v-3a2 2 0 0 0-4 0v3\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M18 16h.01\" />\n  <path d=\"M22 7a1 1 0 0 0-1-1h-2a2 2 0 0 1-1.143-.359L13.143 2.36a2 2 0 0 0-2.286-.001L6.143 5.64A2 2 0 0 1 5 6H3a1 1 0 0 0-1 1v12a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2z\" />\n  <path d=\"M6 12h.01\" />\n  <path d=\"M6 16h.01\" />\n  <circle cx=\"12\" cy=\"10\" r=\"2\" />"),
    UTILITY_POLE(
        "utility-pole",
        "<path d=\"M12 2v20\" />\n  <path d=\"M2 5h20\" />\n  <path d=\"M3 3v2\" />\n  <path d=\"M7 3v2\" />\n  <path d=\"M17 3v2\" />\n  <path d=\"M21 3v2\" />\n  <path d=\"m19 5-7 7-7-7\" />"),
    WAREHOUSE(
        "warehouse",
        "<path d=\"M18 21V10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1v11\" />\n  <path d=\"M22 19a2 2 0 0 1-2 2H4a2 2 0 0 1-2-2V8a2 2 0 0 1 1.132-1.803l7.95-3.974a2 2 0 0 1 1.837 0l7.948 3.974A2 2 0 0 1 22 8z\" />\n  <path d=\"M6 13h12\" />\n  <path d=\"M6 17h12\" />");

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
  default LucideIcon anvil_buildings() {
    return LucideIcon.create(Icon.ANVIL);
  }

  default LucideIcon brick_wall_buildings() {
    return LucideIcon.create(Icon.BRICK_WALL);
  }

  default LucideIcon bridge_buildings() {
    return LucideIcon.create(Icon.BRIDGE);
  }

  default LucideIcon building_buildings() {
    return LucideIcon.create(Icon.BUILDING);
  }

  default LucideIcon building_complex_buildings() {
    return LucideIcon.create(Icon.BUILDING_COMPLEX);
  }

  default LucideIcon building_complex_plus_buildings() {
    return LucideIcon.create(Icon.BUILDING_COMPLEX_PLUS);
  }

  default LucideIcon castle_buildings() {
    return LucideIcon.create(Icon.CASTLE);
  }

  default LucideIcon church_buildings() {
    return LucideIcon.create(Icon.CHURCH);
  }

  default LucideIcon dam_buildings() {
    return LucideIcon.create(Icon.DAM);
  }

  default LucideIcon dome_buildings() {
    return LucideIcon.create(Icon.DOME);
  }

  default LucideIcon factory_buildings() {
    return LucideIcon.create(Icon.FACTORY);
  }

  default LucideIcon fence_buildings() {
    return LucideIcon.create(Icon.FENCE);
  }

  default LucideIcon graduation_cap() {
    return LucideIcon.create(Icon.GRADUATION_CAP);
  }

  default LucideIcon hospital_buildings() {
    return LucideIcon.create(Icon.HOSPITAL);
  }

  default LucideIcon hotel_buildings() {
    return LucideIcon.create(Icon.HOTEL);
  }

  default LucideIcon house_buildings() {
    return LucideIcon.create(Icon.HOUSE);
  }

  default LucideIcon house_cog_buildings() {
    return LucideIcon.create(Icon.HOUSE_COG);
  }

  default LucideIcon house_heart_buildings() {
    return LucideIcon.create(Icon.HOUSE_HEART);
  }

  default LucideIcon house_plug_buildings() {
    return LucideIcon.create(Icon.HOUSE_PLUG);
  }

  default LucideIcon house_plus_buildings() {
    return LucideIcon.create(Icon.HOUSE_PLUS);
  }

  default LucideIcon house_wifi_buildings() {
    return LucideIcon.create(Icon.HOUSE_WIFI);
  }

  default LucideIcon houses_buildings() {
    return LucideIcon.create(Icon.HOUSES);
  }

  default LucideIcon landmark_buildings() {
    return LucideIcon.create(Icon.LANDMARK);
  }

  default LucideIcon lighthouse_buildings() {
    return LucideIcon.create(Icon.LIGHTHOUSE);
  }

  default LucideIcon mosque_buildings() {
    return LucideIcon.create(Icon.MOSQUE);
  }

  default LucideIcon school_buildings() {
    return LucideIcon.create(Icon.SCHOOL);
  }

  default LucideIcon store_buildings() {
    return LucideIcon.create(Icon.STORE);
  }

  default LucideIcon theater_buildings() {
    return LucideIcon.create(Icon.THEATER);
  }

  default LucideIcon university_buildings() {
    return LucideIcon.create(Icon.UNIVERSITY);
  }

  default LucideIcon utility_pole_buildings() {
    return LucideIcon.create(Icon.UTILITY_POLE);
  }

  default LucideIcon warehouse_buildings() {
    return LucideIcon.create(Icon.WAREHOUSE);
  }
}
