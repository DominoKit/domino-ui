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
import org.dominokit.domino.ui.icons.LucideIcon;

/** Lookup for the Lucide catalog grouped by category. */
public final class LucideByCategoryFactory {
  private LucideByCategoryFactory() {}

  public static List<String> categories() {
    return LucideCategories.CATEGORIES;
  }

  public static List<IconCatalogEntry<LucideIcon>> get(String category) {
    return switch (category) {
      case LucideCategories.ACCESSIBILITY -> new LucideAccessibility_Factory().icons();
      case LucideCategories.ACCOUNT -> new LucideAccount_Factory().icons();
      case LucideCategories.ANIMALS -> new LucideAnimals_Factory().icons();
      case LucideCategories.ARROWS -> new LucideArrows_Factory().icons();
      case LucideCategories.BUILDINGS -> new LucideBuildings_Factory().icons();
      case LucideCategories.CHARTS -> new LucideCharts_Factory().icons();
      case LucideCategories.COMMUNICATION -> new LucideCommunication_Factory().icons();
      case LucideCategories.CONNECTIVITY -> new LucideConnectivity_Factory().icons();
      case LucideCategories.CURSORS -> new LucideCursors_Factory().icons();
      case LucideCategories.DESIGN -> new LucideDesign_Factory().icons();
      case LucideCategories.DEVELOPMENT -> new LucideDevelopment_Factory().icons();
      case LucideCategories.DEVICES -> new LucideDevices_Factory().icons();
      case LucideCategories.EMOJI -> new LucideEmoji_Factory().icons();
      case LucideCategories.FILES -> new LucideFiles_Factory().icons();
      case LucideCategories.FINANCE -> new LucideFinance_Factory().icons();
      case LucideCategories.FOOD_BEVERAGE -> new LucideFoodBeverage_Factory().icons();
      case LucideCategories.GAMING -> new LucideGaming_Factory().icons();
      case LucideCategories.HOME -> new LucideHome_Factory().icons();
      case LucideCategories.LAYOUT -> new LucideLayout_Factory().icons();
      case LucideCategories.MAIL -> new LucideMail_Factory().icons();
      case LucideCategories.MATH -> new LucideMath_Factory().icons();
      case LucideCategories.MEDICAL -> new LucideMedical_Factory().icons();
      case LucideCategories.MULTIMEDIA -> new LucideMultimedia_Factory().icons();
      case LucideCategories.NATURE -> new LucideNature_Factory().icons();
      case LucideCategories.NAVIGATION -> new LucideNavigation_Factory().icons();
      case LucideCategories.NOTIFICATIONS -> new LucideNotifications_Factory().icons();
      case LucideCategories.PEOPLE -> new LucidePeople_Factory().icons();
      case LucideCategories.PHOTOGRAPHY -> new LucidePhotography_Factory().icons();
      case LucideCategories.SCIENCE -> new LucideScience_Factory().icons();
      case LucideCategories.SEASONS -> new LucideSeasons_Factory().icons();
      case LucideCategories.SECURITY -> new LucideSecurity_Factory().icons();
      case LucideCategories.SHAPES -> new LucideShapes_Factory().icons();
      case LucideCategories.SHOPPING -> new LucideShopping_Factory().icons();
      case LucideCategories.SOCIAL -> new LucideSocial_Factory().icons();
      case LucideCategories.SPORTS -> new LucideSports_Factory().icons();
      case LucideCategories.SUSTAINABILITY -> new LucideSustainability_Factory().icons();
      case LucideCategories.TEXT -> new LucideText_Factory().icons();
      case LucideCategories.TIME -> new LucideTime_Factory().icons();
      case LucideCategories.TOOLS -> new LucideTools_Factory().icons();
      case LucideCategories.TRANSPORTATION -> new LucideTransportation_Factory().icons();
      case LucideCategories.TRAVEL -> new LucideTravel_Factory().icons();
      case LucideCategories.WEATHER -> new LucideWeather_Factory().icons();
      default -> throw new IllegalArgumentException(category);
    };
  }
}
