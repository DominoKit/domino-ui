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
import org.dominokit.domino.ui.icons.TablerBuildings;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Buildings category. */
public final class TablerBuildings_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerBuildings tagIcons = new TablerBuildings() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "armchair (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR)",
            tagIcons::armchair));
    icons.add(
        new IconCatalogEntry<>(
            "armchair-2 (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_2)",
            tagIcons::armchair_2));
    icons.add(
        new IconCatalogEntry<>(
            "armchair-2-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_2_OFF)",
            tagIcons::armchair_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "armchair-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.ARMCHAIR_OFF)",
            tagIcons::armchair_off));
    icons.add(
        new IconCatalogEntry<>(
            "bath (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BATH)",
            tagIcons::bath));
    icons.add(
        new IconCatalogEntry<>(
            "bath-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BATH_OFF)",
            tagIcons::bath_off));
    icons.add(
        new IconCatalogEntry<>(
            "bed-flat (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BED_FLAT)",
            tagIcons::bed_flat));
    icons.add(
        new IconCatalogEntry<>(
            "bell-school (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BELL_SCHOOL)",
            tagIcons::bell_school));
    icons.add(
        new IconCatalogEntry<>(
            "building (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING)",
            tagIcons::building));
    icons.add(
        new IconCatalogEntry<>(
            "building-airport (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_AIRPORT)",
            tagIcons::building_airport));
    icons.add(
        new IconCatalogEntry<>(
            "building-arch (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_ARCH)",
            tagIcons::building_arch));
    icons.add(
        new IconCatalogEntry<>(
            "building-bank (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BANK)",
            tagIcons::building_bank));
    icons.add(
        new IconCatalogEntry<>(
            "building-bridge (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BRIDGE)",
            tagIcons::building_bridge));
    icons.add(
        new IconCatalogEntry<>(
            "building-bridge-2 (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BRIDGE_2)",
            tagIcons::building_bridge_2));
    icons.add(
        new IconCatalogEntry<>(
            "building-broadcast-tower (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BROADCAST_TOWER)",
            tagIcons::building_broadcast_tower));
    icons.add(
        new IconCatalogEntry<>(
            "building-burj-al-arab (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_BURJ_AL_ARAB)",
            tagIcons::building_burj_al_arab));
    icons.add(
        new IconCatalogEntry<>(
            "building-carousel (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CAROUSEL)",
            tagIcons::building_carousel));
    icons.add(
        new IconCatalogEntry<>(
            "building-castle (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CASTLE)",
            tagIcons::building_castle));
    icons.add(
        new IconCatalogEntry<>(
            "building-church (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CHURCH)",
            tagIcons::building_church));
    icons.add(
        new IconCatalogEntry<>(
            "building-circus (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_CIRCUS)",
            tagIcons::building_circus));
    icons.add(
        new IconCatalogEntry<>(
            "building-cog (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COG)",
            tagIcons::building_cog));
    icons.add(
        new IconCatalogEntry<>(
            "building-community (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COMMUNITY)",
            tagIcons::building_community));
    icons.add(
        new IconCatalogEntry<>(
            "building-cottage (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_COTTAGE)",
            tagIcons::building_cottage));
    icons.add(
        new IconCatalogEntry<>(
            "building-eiffel-tower (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_EIFFEL_TOWER)",
            tagIcons::building_eiffel_tower));
    icons.add(
        new IconCatalogEntry<>(
            "building-estate (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_ESTATE)",
            tagIcons::building_estate));
    icons.add(
        new IconCatalogEntry<>(
            "building-factory (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FACTORY)",
            tagIcons::building_factory));
    icons.add(
        new IconCatalogEntry<>(
            "building-factory-2 (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FACTORY_2)",
            tagIcons::building_factory_2));
    icons.add(
        new IconCatalogEntry<>(
            "building-fortress (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_FORTRESS)",
            tagIcons::building_fortress));
    icons.add(
        new IconCatalogEntry<>(
            "building-hospital (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_HOSPITAL)",
            tagIcons::building_hospital));
    icons.add(
        new IconCatalogEntry<>(
            "building-lighthouse (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_LIGHTHOUSE)",
            tagIcons::building_lighthouse));
    icons.add(
        new IconCatalogEntry<>(
            "building-minus (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MINUS)",
            tagIcons::building_minus));
    icons.add(
        new IconCatalogEntry<>(
            "building-monument (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MONUMENT)",
            tagIcons::building_monument));
    icons.add(
        new IconCatalogEntry<>(
            "building-mosque (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_MOSQUE)",
            tagIcons::building_mosque));
    icons.add(
        new IconCatalogEntry<>(
            "building-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_OFF)",
            tagIcons::building_off));
    icons.add(
        new IconCatalogEntry<>(
            "building-pavilion (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_PAVILION)",
            tagIcons::building_pavilion));
    icons.add(
        new IconCatalogEntry<>(
            "building-plus (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_PLUS)",
            tagIcons::building_plus));
    icons.add(
        new IconCatalogEntry<>(
            "building-skyscraper (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_SKYSCRAPER)",
            tagIcons::building_skyscraper));
    icons.add(
        new IconCatalogEntry<>(
            "building-stadium (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_STADIUM)",
            tagIcons::building_stadium));
    icons.add(
        new IconCatalogEntry<>(
            "building-store (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_STORE)",
            tagIcons::building_store));
    icons.add(
        new IconCatalogEntry<>(
            "building-tunnel (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_TUNNEL)",
            tagIcons::building_tunnel));
    icons.add(
        new IconCatalogEntry<>(
            "building-warehouse (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_WAREHOUSE)",
            tagIcons::building_warehouse));
    icons.add(
        new IconCatalogEntry<>(
            "building-wind-turbine (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDING_WIND_TURBINE)",
            tagIcons::building_wind_turbine));
    icons.add(
        new IconCatalogEntry<>(
            "buildings (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.BUILDINGS)",
            tagIcons::buildings));
    icons.add(
        new IconCatalogEntry<>(
            "car-garage (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.CAR_GARAGE)",
            tagIcons::car_garage));
    icons.add(
        new IconCatalogEntry<>(
            "chalkboard-teacher (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.CHALKBOARD_TEACHER)",
            tagIcons::chalkboard_teacher));
    icons.add(
        new IconCatalogEntry<>(
            "door-hanger (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.DOOR_HANGER)",
            tagIcons::door_hanger));
    icons.add(
        new IconCatalogEntry<>(
            "fence (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.FENCE)",
            tagIcons::fence));
    icons.add(
        new IconCatalogEntry<>(
            "fence-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.FENCE_OFF)",
            tagIcons::fence_off));
    icons.add(
        new IconCatalogEntry<>(
            "home (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME)",
            tagIcons::home));
    icons.add(
        new IconCatalogEntry<>(
            "home-2 (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_2)",
            tagIcons::home_2));
    icons.add(
        new IconCatalogEntry<>(
            "home-bitcoin (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_BITCOIN)",
            tagIcons::home_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "home-bolt (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_BOLT)",
            tagIcons::home_bolt));
    icons.add(
        new IconCatalogEntry<>(
            "home-cancel (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_CANCEL)",
            tagIcons::home_cancel));
    icons.add(
        new IconCatalogEntry<>(
            "home-check (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_CHECK)",
            tagIcons::home_check));
    icons.add(
        new IconCatalogEntry<>(
            "home-cog (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_COG)",
            tagIcons::home_cog));
    icons.add(
        new IconCatalogEntry<>(
            "home-dollar (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOLLAR)",
            tagIcons::home_dollar));
    icons.add(
        new IconCatalogEntry<>(
            "home-dot (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOT)",
            tagIcons::home_dot));
    icons.add(
        new IconCatalogEntry<>(
            "home-down (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_DOWN)",
            tagIcons::home_down));
    icons.add(
        new IconCatalogEntry<>(
            "home-eco (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_ECO)",
            tagIcons::home_eco));
    icons.add(
        new IconCatalogEntry<>(
            "home-edit (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_EDIT)",
            tagIcons::home_edit));
    icons.add(
        new IconCatalogEntry<>(
            "home-exclamation (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_EXCLAMATION)",
            tagIcons::home_exclamation));
    icons.add(
        new IconCatalogEntry<>(
            "home-hand (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_HAND)",
            tagIcons::home_hand));
    icons.add(
        new IconCatalogEntry<>(
            "home-heart (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_HEART)",
            tagIcons::home_heart));
    icons.add(
        new IconCatalogEntry<>(
            "home-infinity (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_INFINITY)",
            tagIcons::home_infinity));
    icons.add(
        new IconCatalogEntry<>(
            "home-link (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_LINK)",
            tagIcons::home_link));
    icons.add(
        new IconCatalogEntry<>(
            "home-lock (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_LOCK)",
            tagIcons::home_lock));
    icons.add(
        new IconCatalogEntry<>(
            "home-minus (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_MINUS)",
            tagIcons::home_minus));
    icons.add(
        new IconCatalogEntry<>(
            "home-move (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_MOVE)",
            tagIcons::home_move));
    icons.add(
        new IconCatalogEntry<>(
            "home-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_OFF)",
            tagIcons::home_off));
    icons.add(
        new IconCatalogEntry<>(
            "home-plus (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_PLUS)",
            tagIcons::home_plus));
    icons.add(
        new IconCatalogEntry<>(
            "home-question (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_QUESTION)",
            tagIcons::home_question));
    icons.add(
        new IconCatalogEntry<>(
            "home-ribbon (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_RIBBON)",
            tagIcons::home_ribbon));
    icons.add(
        new IconCatalogEntry<>(
            "home-search (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SEARCH)",
            tagIcons::home_search));
    icons.add(
        new IconCatalogEntry<>(
            "home-share (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SHARE)",
            tagIcons::home_share));
    icons.add(
        new IconCatalogEntry<>(
            "home-shield (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SHIELD)",
            tagIcons::home_shield));
    icons.add(
        new IconCatalogEntry<>(
            "home-signal (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SIGNAL)",
            tagIcons::home_signal));
    icons.add(
        new IconCatalogEntry<>(
            "home-spark (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_SPARK)",
            tagIcons::home_spark));
    icons.add(
        new IconCatalogEntry<>(
            "home-star (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_STAR)",
            tagIcons::home_star));
    icons.add(
        new IconCatalogEntry<>(
            "home-stats (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_STATS)",
            tagIcons::home_stats));
    icons.add(
        new IconCatalogEntry<>(
            "home-up (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_UP)",
            tagIcons::home_up));
    icons.add(
        new IconCatalogEntry<>(
            "home-x (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOME_X)",
            tagIcons::home_x));
    icons.add(
        new IconCatalogEntry<>(
            "hotel-service (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.HOTEL_SERVICE)",
            tagIcons::hotel_service));
    icons.add(
        new IconCatalogEntry<>(
            "mosque (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.MOSQUE)",
            tagIcons::mosque));
    icons.add(
        new IconCatalogEntry<>(
            "podium (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.PODIUM)",
            tagIcons::podium));
    icons.add(
        new IconCatalogEntry<>(
            "podium-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.PODIUM_OFF)",
            tagIcons::podium_off));
    icons.add(
        new IconCatalogEntry<>(
            "rocking-chair (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.ROCKING_CHAIR)",
            tagIcons::rocking_chair));
    icons.add(
        new IconCatalogEntry<>(
            "school-bell (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.SCHOOL_BELL)",
            tagIcons::school_bell));
    icons.add(
        new IconCatalogEntry<>(
            "smart-home (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.SMART_HOME)",
            tagIcons::smart_home));
    icons.add(
        new IconCatalogEntry<>(
            "smart-home-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.SMART_HOME_OFF)",
            tagIcons::smart_home_off));
    icons.add(
        new IconCatalogEntry<>(
            "tower (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.TOWER)",
            tagIcons::tower));
    icons.add(
        new IconCatalogEntry<>(
            "tower-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.TOWER_OFF)",
            tagIcons::tower_off));
    icons.add(
        new IconCatalogEntry<>(
            "wall (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.WALL)",
            tagIcons::wall));
    icons.add(
        new IconCatalogEntry<>(
            "wall-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.WALL_OFF)",
            tagIcons::wall_off));
    icons.add(
        new IconCatalogEntry<>(
            "window (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.WINDOW)",
            tagIcons::window));
    icons.add(
        new IconCatalogEntry<>(
            "window-off (outline)",
            "TablerIcon.create(TablerBuildings.OutlineIcon.WINDOW_OFF)",
            tagIcons::window_off));
    icons.add(
        new IconCatalogEntry<>(
            "bath (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.BATH)",
            tagIcons::bath_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bed-flat (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.BED_FLAT)",
            tagIcons::bed_flat_filled));
    icons.add(
        new IconCatalogEntry<>(
            "building-bridge-2 (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.BUILDING_BRIDGE_2)",
            tagIcons::building_bridge_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "building-broadcast-tower (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.BUILDING_BROADCAST_TOWER)",
            tagIcons::building_broadcast_tower_filled));
    icons.add(
        new IconCatalogEntry<>(
            "fence (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.FENCE)",
            tagIcons::fence_filled));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "home (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.HOME)",
            tagIcons::home_filled));
    icons.add(
        new IconCatalogEntry<>(
            "home-2 (filled)",
            "TablerIcon.create(TablerBuildings.FilledIcon.HOME_2)",
            tagIcons::home_2_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
