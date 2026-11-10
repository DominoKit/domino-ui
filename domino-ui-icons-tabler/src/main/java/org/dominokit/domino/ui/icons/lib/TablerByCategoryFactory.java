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

import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Lookup for the Tabler catalog grouped by category. */
public final class TablerByCategoryFactory {
  private TablerByCategoryFactory() {}

  public static List<String> categories() {
    return TablerCategories.CATEGORIES;
  }

  public static List<IconCatalogEntry<TablerIcon>> get(String category) {
    return switch (category) {
      case TablerCategories.ANIMALS -> new TablerAnimals_Factory().icons();
      case TablerCategories.ARROWS -> new TablerArrows_Factory().icons();
      case TablerCategories.BADGES -> new TablerBadges_Factory().icons();
      case TablerCategories.BRAND -> new TablerBrand_Factory().icons();
      case TablerCategories.BUILDINGS -> new TablerBuildings_Factory().icons();
      case TablerCategories.CHARTS -> new TablerCharts_Factory().icons();
      case TablerCategories.COMMUNICATION -> new TablerCommunication_Factory().icons();
      case TablerCategories.COMPUTERS -> new TablerComputers_Factory().icons();
      case TablerCategories.CURRENCIES -> new TablerCurrencies_Factory().icons();
      case TablerCategories.DATABASE -> new TablerDatabase_Factory().icons();
      case TablerCategories.DESIGN -> new TablerDesign_Factory().icons();
      case TablerCategories.DEVELOPMENT -> new TablerDevelopment_Factory().icons();
      case TablerCategories.DEVICES -> new TablerDevices_Factory().icons();
      case TablerCategories.DOCUMENT -> new TablerDocument_Factory().icons();
      case TablerCategories.ECOMMERCE -> new TablerECommerce_Factory().icons();
      case TablerCategories.ELECTRICAL -> new TablerElectrical_Factory().icons();
      case TablerCategories.EXTENSIONS -> new TablerExtensions_Factory().icons();
      case TablerCategories.FOOD -> new TablerFood_Factory().icons();
      case TablerCategories.GAMES -> new TablerGames_Factory().icons();
      case TablerCategories.GENDER -> new TablerGender_Factory().icons();
      case TablerCategories.GESTURES -> new TablerGestures_Factory().icons();
      case TablerCategories.HEALTH -> new TablerHealth_Factory().icons();
      case TablerCategories.LAUNDRY -> new TablerLaundry_Factory().icons();
      case TablerCategories.LETTERS -> new TablerLetters_Factory().icons();
      case TablerCategories.LOGIC -> new TablerLogic_Factory().icons();
      case TablerCategories.MAP -> new TablerMap_Factory().icons();
      case TablerCategories.MATH -> new TablerMath_Factory().icons();
      case TablerCategories.MEDIA -> new TablerMedia_Factory().icons();
      case TablerCategories.MOOD -> new TablerMood_Factory().icons();
      case TablerCategories.NATURE -> new TablerNature_Factory().icons();
      case TablerCategories.NUMBERS -> new TablerNumbers_Factory().icons();
      case TablerCategories.PHOTOGRAPHY -> new TablerPhotography_Factory().icons();
      case TablerCategories.SHAPES -> new TablerShapes_Factory().icons();
      case TablerCategories.SPORT -> new TablerSport_Factory().icons();
      case TablerCategories.SYMBOLS -> new TablerSymbols_Factory().icons();
      case TablerCategories.SYSTEM -> new TablerSystem_Factory().icons();
      case TablerCategories.TEXT -> new TablerText_Factory().icons();
      case TablerCategories.VEHICLES -> new TablerVehicles_Factory().icons();
      case TablerCategories.VERSION_CONTROL -> new TablerVersionControl_Factory().icons();
      case TablerCategories.WEATHER -> new TablerWeather_Factory().icons();
      case TablerCategories.ZODIAC -> new TablerZodiac_Factory().icons();
      default -> throw new IllegalArgumentException(category);
    };
  }
}
