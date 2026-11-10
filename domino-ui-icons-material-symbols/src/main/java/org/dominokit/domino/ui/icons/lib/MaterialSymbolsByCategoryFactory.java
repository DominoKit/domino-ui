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
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Lookup for the MaterialSymbols catalog grouped by category. */
public final class MaterialSymbolsByCategoryFactory {
  private MaterialSymbolsByCategoryFactory() {}

  public static List<String> categories() {
    return MaterialSymbolsCategories.CATEGORIES;
  }

  public static List<IconCatalogEntry<MaterialSymbolsIcon>> get(String category) {
    return switch (category) {
      case MaterialSymbolsCategories.ACTIONS -> new MaterialSymbolsActions_Factory().icons();
      case MaterialSymbolsCategories.ACTIVITIES -> new MaterialSymbolsActivities_Factory().icons();
      case MaterialSymbolsCategories.ANDROID -> new MaterialSymbolsAndroid_Factory().icons();
      case MaterialSymbolsCategories.AUDIO_VIDEO -> new MaterialSymbolsAudioVideo_Factory().icons();
      case MaterialSymbolsCategories.BUSINESS -> new MaterialSymbolsBusiness_Factory().icons();
      case MaterialSymbolsCategories.COMMUNICATE ->
          new MaterialSymbolsCommunicate_Factory().icons();
      case MaterialSymbolsCategories.HARDWARE -> new MaterialSymbolsHardware_Factory().icons();
      case MaterialSymbolsCategories.HOME -> new MaterialSymbolsHome_Factory().icons();
      case MaterialSymbolsCategories.HOUSEHOLD -> new MaterialSymbolsHousehold_Factory().icons();
      case MaterialSymbolsCategories.IMAGES -> new MaterialSymbolsImages_Factory().icons();
      case MaterialSymbolsCategories.MAPS -> new MaterialSymbolsMaps_Factory().icons();
      case MaterialSymbolsCategories.OTHER -> new MaterialSymbolsOther_Factory().icons();
      case MaterialSymbolsCategories.PRIVACY -> new MaterialSymbolsPrivacy_Factory().icons();
      case MaterialSymbolsCategories.SOCIAL -> new MaterialSymbolsSocial_Factory().icons();
      case MaterialSymbolsCategories.TEXT -> new MaterialSymbolsText_Factory().icons();
      case MaterialSymbolsCategories.TRANSIT -> new MaterialSymbolsTransit_Factory().icons();
      case MaterialSymbolsCategories.TRAVEL -> new MaterialSymbolsTravel_Factory().icons();
      case MaterialSymbolsCategories.UIACTIONS -> new MaterialSymbolsUIActions_Factory().icons();
      default -> throw new IllegalArgumentException(category);
    };
  }
}
