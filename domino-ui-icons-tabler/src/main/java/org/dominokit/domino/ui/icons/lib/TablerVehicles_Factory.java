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
import org.dominokit.domino.ui.icons.TablerIcon;
import org.dominokit.domino.ui.icons.TablerVehicles;

/** Static icon factory for the Tabler Vehicles category. */
public final class TablerVehicles_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerVehicles tagIcons = new TablerVehicles() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "aerial-lift", "TablerIcons.aerial_lift()", tagIcons::aerial_lift));
    icons.add(
        new IconCatalogEntry<>(
            "air-balloon", "TablerIcons.air_balloon()", tagIcons::air_balloon));
    icons.add(
        new IconCatalogEntry<>(
            "ambulance", "TablerIcons.ambulance()", tagIcons::ambulance));
    icons.add(
        new IconCatalogEntry<>(
            "automatic-gearbox",
            "TablerIcons.automatic_gearbox()",
            tagIcons::automatic_gearbox));
    icons.add(
        new IconCatalogEntry<>("backhoe", "TablerIcons.backhoe()", tagIcons::backhoe));
    icons.add(
        new IconCatalogEntry<>(
            "battery-automotive",
            "TablerIcons.battery_automotive()",
            tagIcons::battery_automotive));
    icons.add(new IconCatalogEntry<>("bike", "TablerIcons.bike()", tagIcons::bike));
    icons.add(
        new IconCatalogEntry<>("bike-off", "TablerIcons.bike_off()", tagIcons::bike_off));
    icons.add(
        new IconCatalogEntry<>(
            "bulldozer", "TablerIcons.bulldozer()", tagIcons::bulldozer));
    icons.add(new IconCatalogEntry<>("bus", "TablerIcons.bus()", tagIcons::bus));
    icons.add(
        new IconCatalogEntry<>("bus-off", "TablerIcons.bus_off()", tagIcons::bus_off));
    icons.add(
        new IconCatalogEntry<>("bus-stop", "TablerIcons.bus_stop()", tagIcons::bus_stop));
    icons.add(new IconCatalogEntry<>("camper", "TablerIcons.camper()", tagIcons::camper));
    icons.add(new IconCatalogEntry<>("car", "TablerIcons.car()", tagIcons::car));
    icons.add(
        new IconCatalogEntry<>("car-4wd", "TablerIcons.car_4wd()", tagIcons::car_4wd));
    icons.add(
        new IconCatalogEntry<>(
            "car-crane", "TablerIcons.car_crane()", tagIcons::car_crane));
    icons.add(
        new IconCatalogEntry<>(
            "car-crash", "TablerIcons.car_crash()", tagIcons::car_crash));
    icons.add(
        new IconCatalogEntry<>("car-door", "TablerIcons.car_door()", tagIcons::car_door));
    icons.add(
        new IconCatalogEntry<>("car-fan", "TablerIcons.car_fan()", tagIcons::car_fan));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-1", "TablerIcons.car_fan_1()", tagIcons::car_fan_1));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-2", "TablerIcons.car_fan_2()", tagIcons::car_fan_2));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-3", "TablerIcons.car_fan_3()", tagIcons::car_fan_3));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-auto", "TablerIcons.car_fan_auto()", tagIcons::car_fan_auto));
    icons.add(
        new IconCatalogEntry<>(
            "car-lifter", "TablerIcons.car_lifter()", tagIcons::car_lifter));
    icons.add(
        new IconCatalogEntry<>("car-off", "TablerIcons.car_off()", tagIcons::car_off));
    icons.add(
        new IconCatalogEntry<>(
            "car-off-road", "TablerIcons.car_off_road()", tagIcons::car_off_road));
    icons.add(
        new IconCatalogEntry<>(
            "car-suspension", "TablerIcons.car_suspension()", tagIcons::car_suspension));
    icons.add(
        new IconCatalogEntry<>("car-suv", "TablerIcons.car_suv()", tagIcons::car_suv));
    icons.add(
        new IconCatalogEntry<>(
            "car-turbine", "TablerIcons.car_turbine()", tagIcons::car_turbine));
    icons.add(
        new IconCatalogEntry<>("caravan", "TablerIcons.caravan()", tagIcons::caravan));
    icons.add(
        new IconCatalogEntry<>(
            "charging-pile", "TablerIcons.charging_pile()", tagIcons::charging_pile));
    icons.add(new IconCatalogEntry<>("crane", "TablerIcons.crane()", tagIcons::crane));
    icons.add(
        new IconCatalogEntry<>(
            "crane-off", "TablerIcons.crane_off()", tagIcons::crane_off));
    icons.add(new IconCatalogEntry<>("drone", "TablerIcons.drone()", tagIcons::drone));
    icons.add(
        new IconCatalogEntry<>(
            "drone-off", "TablerIcons.drone_off()", tagIcons::drone_off));
    icons.add(new IconCatalogEntry<>("engine", "TablerIcons.engine()", tagIcons::engine));
    icons.add(
        new IconCatalogEntry<>(
            "engine-off", "TablerIcons.engine_off()", tagIcons::engine_off));
    icons.add(new IconCatalogEntry<>("ferry", "TablerIcons.ferry()", tagIcons::ferry));
    icons.add(
        new IconCatalogEntry<>(
            "firetruck", "TablerIcons.firetruck()", tagIcons::firetruck));
    icons.add(
        new IconCatalogEntry<>("forklift", "TablerIcons.forklift()", tagIcons::forklift));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart", "TablerIcons.garden_cart()", tagIcons::garden_cart));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart-off",
            "TablerIcons.garden_cart_off()",
            tagIcons::garden_cart_off));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station", "TablerIcons.gas_station()", tagIcons::gas_station));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station-off",
            "TablerIcons.gas_station_off()",
            tagIcons::gas_station_off));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter", "TablerIcons.helicopter()", tagIcons::helicopter));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter-landing",
            "TablerIcons.helicopter_landing()",
            tagIcons::helicopter_landing));
    icons.add(new IconCatalogEntry<>("jetski", "TablerIcons.jetski()", tagIcons::jetski));
    icons.add(new IconCatalogEntry<>("moped", "TablerIcons.moped()", tagIcons::moped));
    icons.add(
        new IconCatalogEntry<>(
            "motorbike", "TablerIcons.motorbike()", tagIcons::motorbike));
    icons.add(
        new IconCatalogEntry<>(
            "parachute", "TablerIcons.parachute()", tagIcons::parachute));
    icons.add(
        new IconCatalogEntry<>(
            "parachute-off", "TablerIcons.parachute_off()", tagIcons::parachute_off));
    icons.add(new IconCatalogEntry<>("plane", "TablerIcons.plane()", tagIcons::plane));
    icons.add(
        new IconCatalogEntry<>(
            "plane-arrival", "TablerIcons.plane_arrival()", tagIcons::plane_arrival));
    icons.add(
        new IconCatalogEntry<>(
            "plane-departure",
            "TablerIcons.plane_departure()",
            tagIcons::plane_departure));
    icons.add(
        new IconCatalogEntry<>(
            "plane-inflight", "TablerIcons.plane_inflight()", tagIcons::plane_inflight));
    icons.add(
        new IconCatalogEntry<>(
            "plane-off", "TablerIcons.plane_off()", tagIcons::plane_off));
    icons.add(
        new IconCatalogEntry<>(
            "plane-tilt", "TablerIcons.plane_tilt()", tagIcons::plane_tilt));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster", "TablerIcons.rollercoaster()", tagIcons::rollercoaster));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster-off",
            "TablerIcons.rollercoaster_off()",
            tagIcons::rollercoaster_off));
    icons.add(
        new IconCatalogEntry<>("sailboat", "TablerIcons.sailboat()", tagIcons::sailboat));
    icons.add(
        new IconCatalogEntry<>(
            "sailboat-2", "TablerIcons.sailboat_2()", tagIcons::sailboat_2));
    icons.add(
        new IconCatalogEntry<>(
            "sailboat-off", "TablerIcons.sailboat_off()", tagIcons::sailboat_off));
    icons.add(
        new IconCatalogEntry<>("scooter", "TablerIcons.scooter()", tagIcons::scooter));
    icons.add(
        new IconCatalogEntry<>(
            "scooter-electric",
            "TablerIcons.scooter_electric()",
            tagIcons::scooter_electric));
    icons.add(new IconCatalogEntry<>("segway", "TablerIcons.segway()", tagIcons::segway));
    icons.add(new IconCatalogEntry<>("ship", "TablerIcons.ship()", tagIcons::ship));
    icons.add(
        new IconCatalogEntry<>("ship-off", "TablerIcons.ship_off()", tagIcons::ship_off));
    icons.add(
        new IconCatalogEntry<>(
            "skateboard", "TablerIcons.skateboard()", tagIcons::skateboard));
    icons.add(
        new IconCatalogEntry<>(
            "skateboard-off", "TablerIcons.skateboard_off()", tagIcons::skateboard_off));
    icons.add(new IconCatalogEntry<>("sleigh", "TablerIcons.sleigh()", tagIcons::sleigh));
    icons.add(
        new IconCatalogEntry<>(
            "speedboat", "TablerIcons.speedboat()", tagIcons::speedboat));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel", "TablerIcons.steering_wheel()", tagIcons::steering_wheel));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel-off",
            "TablerIcons.steering_wheel_off()",
            tagIcons::steering_wheel_off));
    icons.add(
        new IconCatalogEntry<>(
            "submarine", "TablerIcons.submarine()", tagIcons::submarine));
    icons.add(new IconCatalogEntry<>("tank", "TablerIcons.tank()", tagIcons::tank));
    icons.add(new IconCatalogEntry<>("tir", "TablerIcons.tir()", tagIcons::tir));
    icons.add(new IconCatalogEntry<>("track", "TablerIcons.track()", tagIcons::track));
    icons.add(
        new IconCatalogEntry<>("tractor", "TablerIcons.tractor()", tagIcons::tractor));
    icons.add(new IconCatalogEntry<>("train", "TablerIcons.train()", tagIcons::train));
    icons.add(
        new IconCatalogEntry<>("trolley", "TablerIcons.trolley()", tagIcons::trolley));
    icons.add(new IconCatalogEntry<>("truck", "TablerIcons.truck()", tagIcons::truck));
    icons.add(
        new IconCatalogEntry<>(
            "truck-off", "TablerIcons.truck_off()", tagIcons::truck_off));
    icons.add(
        new IconCatalogEntry<>("unicycle", "TablerIcons.unicycle()", tagIcons::unicycle));
    icons.add(
        new IconCatalogEntry<>(
            "wheelchair", "TablerIcons.wheelchair()", tagIcons::wheelchair));
    icons.add(
        new IconCatalogEntry<>(
            "wheelchair-off", "TablerIcons.wheelchair_off()", tagIcons::wheelchair_off));
    icons.add(new IconCatalogEntry<>("wiper", "TablerIcons.wiper()", tagIcons::wiper));
    icons.add(
        new IconCatalogEntry<>(
            "wiper-wash", "TablerIcons.wiper_wash()", tagIcons::wiper_wash));
    icons.add(
        new IconCatalogEntry<>(
            "wrecking-ball", "TablerIcons.wrecking_ball()", tagIcons::wrecking_ball));
    icons.add(
        new IconCatalogEntry<>("zeppelin", "TablerIcons.zeppelin()", tagIcons::zeppelin));
    icons.add(
        new IconCatalogEntry<>(
            "zeppelin-off", "TablerIcons.zeppelin_off()", tagIcons::zeppelin_off));
    icons.add(
        new IconCatalogEntry<>(
            "aerial-lift",
            "TablerIcons.aerial_lift_filled()",
            tagIcons::aerial_lift_filled));
    icons.add(
        new IconCatalogEntry<>(
            "air-balloon",
            "TablerIcons.air_balloon_filled()",
            tagIcons::air_balloon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "automatic-gearbox",
            "TablerIcons.automatic_gearbox_filled()",
            tagIcons::automatic_gearbox_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-automotive",
            "TablerIcons.battery_automotive_filled()",
            tagIcons::battery_automotive_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bike", "TablerIcons.bike_filled()", tagIcons::bike_filled));
    icons.add(
        new IconCatalogEntry<>("bus", "TablerIcons.bus_filled()", tagIcons::bus_filled));
    icons.add(
        new IconCatalogEntry<>("car", "TablerIcons.car_filled()", tagIcons::car_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-4wd", "TablerIcons.car_4wd_filled()", tagIcons::car_4wd_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-crane", "TablerIcons.car_crane_filled()", tagIcons::car_crane_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan", "TablerIcons.car_fan_filled()", tagIcons::car_fan_filled));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "car-suv", "TablerIcons.car_suv_filled()", tagIcons::car_suv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caravan", "TablerIcons.caravan_filled()", tagIcons::caravan_filled));
    icons.add(
        new IconCatalogEntry<>(
            "charging-pile",
            "TablerIcons.charging_pile_filled()",
            tagIcons::charging_pile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "engine", "TablerIcons.engine_filled()", tagIcons::engine_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ferry", "TablerIcons.ferry_filled()", tagIcons::ferry_filled));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart",
            "TablerIcons.garden_cart_filled()",
            tagIcons::garden_cart_filled));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station",
            "TablerIcons.gas_station_filled()",
            tagIcons::gas_station_filled));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter", "TablerIcons.helicopter_filled()", tagIcons::helicopter_filled));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter-landing",
            "TablerIcons.helicopter_landing_filled()",
            tagIcons::helicopter_landing_filled));
    icons.add(
        new IconCatalogEntry<>(
            "motorbike", "TablerIcons.motorbike_filled()", tagIcons::motorbike_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane", "TablerIcons.plane_filled()", tagIcons::plane_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-arrival",
            "TablerIcons.plane_arrival_filled()",
            tagIcons::plane_arrival_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-departure",
            "TablerIcons.plane_departure_filled()",
            tagIcons::plane_departure_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-tilt", "TablerIcons.plane_tilt_filled()", tagIcons::plane_tilt_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster",
            "TablerIcons.rollercoaster_filled()",
            tagIcons::rollercoaster_filled));
    icons.add(
        new IconCatalogEntry<>(
            "speedboat", "TablerIcons.speedboat_filled()", tagIcons::speedboat_filled));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel",
            "TablerIcons.steering_wheel_filled()",
            tagIcons::steering_wheel_filled));
    icons.add(
        new IconCatalogEntry<>(
            "train", "TablerIcons.train_filled()", tagIcons::train_filled));
    icons.add(
        new IconCatalogEntry<>(
            "trolley", "TablerIcons.trolley_filled()", tagIcons::trolley_filled));
    icons.add(
        new IconCatalogEntry<>(
            "truck", "TablerIcons.truck_filled()", tagIcons::truck_filled));
    icons.add(
        new IconCatalogEntry<>(
            "zeppelin", "TablerIcons.zeppelin_filled()", tagIcons::zeppelin_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
