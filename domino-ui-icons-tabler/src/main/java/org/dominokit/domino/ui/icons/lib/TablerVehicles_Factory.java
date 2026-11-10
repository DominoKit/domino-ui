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
            "aerial-lift (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.AERIAL_LIFT)",
            tagIcons::aerial_lift));
    icons.add(
        new IconCatalogEntry<>(
            "air-balloon (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.AIR_BALLOON)",
            tagIcons::air_balloon));
    icons.add(
        new IconCatalogEntry<>(
            "ambulance (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.AMBULANCE)",
            tagIcons::ambulance));
    icons.add(
        new IconCatalogEntry<>(
            "automatic-gearbox (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.AUTOMATIC_GEARBOX)",
            tagIcons::automatic_gearbox));
    icons.add(
        new IconCatalogEntry<>(
            "backhoe (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BACKHOE)",
            tagIcons::backhoe));
    icons.add(
        new IconCatalogEntry<>(
            "battery-automotive (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BATTERY_AUTOMOTIVE)",
            tagIcons::battery_automotive));
    icons.add(
        new IconCatalogEntry<>(
            "bike (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BIKE)",
            tagIcons::bike));
    icons.add(
        new IconCatalogEntry<>(
            "bike-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BIKE_OFF)",
            tagIcons::bike_off));
    icons.add(
        new IconCatalogEntry<>(
            "bulldozer (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BULLDOZER)",
            tagIcons::bulldozer));
    icons.add(
        new IconCatalogEntry<>(
            "bus (outline)", "TablerIcon.create(TablerVehicles.OutlineIcon.BUS)", tagIcons::bus));
    icons.add(
        new IconCatalogEntry<>(
            "bus-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BUS_OFF)",
            tagIcons::bus_off));
    icons.add(
        new IconCatalogEntry<>(
            "bus-stop (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.BUS_STOP)",
            tagIcons::bus_stop));
    icons.add(
        new IconCatalogEntry<>(
            "camper (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAMPER)",
            tagIcons::camper));
    icons.add(
        new IconCatalogEntry<>(
            "car (outline)", "TablerIcon.create(TablerVehicles.OutlineIcon.CAR)", tagIcons::car));
    icons.add(
        new IconCatalogEntry<>(
            "car-4wd (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_4WD)",
            tagIcons::car_4wd));
    icons.add(
        new IconCatalogEntry<>(
            "car-crane (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_CRANE)",
            tagIcons::car_crane));
    icons.add(
        new IconCatalogEntry<>(
            "car-crash (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_CRASH)",
            tagIcons::car_crash));
    icons.add(
        new IconCatalogEntry<>(
            "car-door (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_DOOR)",
            tagIcons::car_door));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_FAN)",
            tagIcons::car_fan));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-1 (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_FAN_1)",
            tagIcons::car_fan_1));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-2 (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_FAN_2)",
            tagIcons::car_fan_2));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-3 (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_FAN_3)",
            tagIcons::car_fan_3));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan-auto (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_FAN_AUTO)",
            tagIcons::car_fan_auto));
    icons.add(
        new IconCatalogEntry<>(
            "car-lifter (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_LIFTER)",
            tagIcons::car_lifter));
    icons.add(
        new IconCatalogEntry<>(
            "car-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_OFF)",
            tagIcons::car_off));
    icons.add(
        new IconCatalogEntry<>(
            "car-off-road (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_OFF_ROAD)",
            tagIcons::car_off_road));
    icons.add(
        new IconCatalogEntry<>(
            "car-suspension (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_SUSPENSION)",
            tagIcons::car_suspension));
    icons.add(
        new IconCatalogEntry<>(
            "car-suv (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_SUV)",
            tagIcons::car_suv));
    icons.add(
        new IconCatalogEntry<>(
            "car-turbine (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CAR_TURBINE)",
            tagIcons::car_turbine));
    icons.add(
        new IconCatalogEntry<>(
            "caravan (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CARAVAN)",
            tagIcons::caravan));
    icons.add(
        new IconCatalogEntry<>(
            "charging-pile (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CHARGING_PILE)",
            tagIcons::charging_pile));
    icons.add(
        new IconCatalogEntry<>(
            "crane (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CRANE)",
            tagIcons::crane));
    icons.add(
        new IconCatalogEntry<>(
            "crane-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.CRANE_OFF)",
            tagIcons::crane_off));
    icons.add(
        new IconCatalogEntry<>(
            "drone (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.DRONE)",
            tagIcons::drone));
    icons.add(
        new IconCatalogEntry<>(
            "drone-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.DRONE_OFF)",
            tagIcons::drone_off));
    icons.add(
        new IconCatalogEntry<>(
            "engine (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ENGINE)",
            tagIcons::engine));
    icons.add(
        new IconCatalogEntry<>(
            "engine-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ENGINE_OFF)",
            tagIcons::engine_off));
    icons.add(
        new IconCatalogEntry<>(
            "ferry (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.FERRY)",
            tagIcons::ferry));
    icons.add(
        new IconCatalogEntry<>(
            "firetruck (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.FIRETRUCK)",
            tagIcons::firetruck));
    icons.add(
        new IconCatalogEntry<>(
            "forklift (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.FORKLIFT)",
            tagIcons::forklift));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.GARDEN_CART)",
            tagIcons::garden_cart));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.GARDEN_CART_OFF)",
            tagIcons::garden_cart_off));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.GAS_STATION)",
            tagIcons::gas_station));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.GAS_STATION_OFF)",
            tagIcons::gas_station_off));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.HELICOPTER)",
            tagIcons::helicopter));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter-landing (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.HELICOPTER_LANDING)",
            tagIcons::helicopter_landing));
    icons.add(
        new IconCatalogEntry<>(
            "jetski (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.JETSKI)",
            tagIcons::jetski));
    icons.add(
        new IconCatalogEntry<>(
            "moped (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.MOPED)",
            tagIcons::moped));
    icons.add(
        new IconCatalogEntry<>(
            "motorbike (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.MOTORBIKE)",
            tagIcons::motorbike));
    icons.add(
        new IconCatalogEntry<>(
            "parachute (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PARACHUTE)",
            tagIcons::parachute));
    icons.add(
        new IconCatalogEntry<>(
            "parachute-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PARACHUTE_OFF)",
            tagIcons::parachute_off));
    icons.add(
        new IconCatalogEntry<>(
            "plane (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE)",
            tagIcons::plane));
    icons.add(
        new IconCatalogEntry<>(
            "plane-arrival (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE_ARRIVAL)",
            tagIcons::plane_arrival));
    icons.add(
        new IconCatalogEntry<>(
            "plane-departure (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE_DEPARTURE)",
            tagIcons::plane_departure));
    icons.add(
        new IconCatalogEntry<>(
            "plane-inflight (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE_INFLIGHT)",
            tagIcons::plane_inflight));
    icons.add(
        new IconCatalogEntry<>(
            "plane-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE_OFF)",
            tagIcons::plane_off));
    icons.add(
        new IconCatalogEntry<>(
            "plane-tilt (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.PLANE_TILT)",
            tagIcons::plane_tilt));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ROLLERCOASTER)",
            tagIcons::rollercoaster));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ROLLERCOASTER_OFF)",
            tagIcons::rollercoaster_off));
    icons.add(
        new IconCatalogEntry<>(
            "sailboat (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SAILBOAT)",
            tagIcons::sailboat));
    icons.add(
        new IconCatalogEntry<>(
            "sailboat-2 (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SAILBOAT_2)",
            tagIcons::sailboat_2));
    icons.add(
        new IconCatalogEntry<>(
            "sailboat-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SAILBOAT_OFF)",
            tagIcons::sailboat_off));
    icons.add(
        new IconCatalogEntry<>(
            "scooter (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SCOOTER)",
            tagIcons::scooter));
    icons.add(
        new IconCatalogEntry<>(
            "scooter-electric (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SCOOTER_ELECTRIC)",
            tagIcons::scooter_electric));
    icons.add(
        new IconCatalogEntry<>(
            "segway (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SEGWAY)",
            tagIcons::segway));
    icons.add(
        new IconCatalogEntry<>(
            "ship (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SHIP)",
            tagIcons::ship));
    icons.add(
        new IconCatalogEntry<>(
            "ship-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SHIP_OFF)",
            tagIcons::ship_off));
    icons.add(
        new IconCatalogEntry<>(
            "skateboard (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SKATEBOARD)",
            tagIcons::skateboard));
    icons.add(
        new IconCatalogEntry<>(
            "skateboard-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SKATEBOARD_OFF)",
            tagIcons::skateboard_off));
    icons.add(
        new IconCatalogEntry<>(
            "sleigh (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SLEIGH)",
            tagIcons::sleigh));
    icons.add(
        new IconCatalogEntry<>(
            "speedboat (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SPEEDBOAT)",
            tagIcons::speedboat));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.STEERING_WHEEL)",
            tagIcons::steering_wheel));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.STEERING_WHEEL_OFF)",
            tagIcons::steering_wheel_off));
    icons.add(
        new IconCatalogEntry<>(
            "submarine (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.SUBMARINE)",
            tagIcons::submarine));
    icons.add(
        new IconCatalogEntry<>(
            "tank (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TANK)",
            tagIcons::tank));
    icons.add(
        new IconCatalogEntry<>(
            "tir (outline)", "TablerIcon.create(TablerVehicles.OutlineIcon.TIR)", tagIcons::tir));
    icons.add(
        new IconCatalogEntry<>(
            "track (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TRACK)",
            tagIcons::track));
    icons.add(
        new IconCatalogEntry<>(
            "tractor (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TRACTOR)",
            tagIcons::tractor));
    icons.add(
        new IconCatalogEntry<>(
            "train (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TRAIN)",
            tagIcons::train));
    icons.add(
        new IconCatalogEntry<>(
            "trolley (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TROLLEY)",
            tagIcons::trolley));
    icons.add(
        new IconCatalogEntry<>(
            "truck (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TRUCK)",
            tagIcons::truck));
    icons.add(
        new IconCatalogEntry<>(
            "truck-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.TRUCK_OFF)",
            tagIcons::truck_off));
    icons.add(
        new IconCatalogEntry<>(
            "unicycle (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.UNICYCLE)",
            tagIcons::unicycle));
    icons.add(
        new IconCatalogEntry<>(
            "wheelchair (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.WHEELCHAIR)",
            tagIcons::wheelchair));
    icons.add(
        new IconCatalogEntry<>(
            "wheelchair-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.WHEELCHAIR_OFF)",
            tagIcons::wheelchair_off));
    icons.add(
        new IconCatalogEntry<>(
            "wiper (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.WIPER)",
            tagIcons::wiper));
    icons.add(
        new IconCatalogEntry<>(
            "wiper-wash (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.WIPER_WASH)",
            tagIcons::wiper_wash));
    icons.add(
        new IconCatalogEntry<>(
            "wrecking-ball (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.WRECKING_BALL)",
            tagIcons::wrecking_ball));
    icons.add(
        new IconCatalogEntry<>(
            "zeppelin (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ZEPPELIN)",
            tagIcons::zeppelin));
    icons.add(
        new IconCatalogEntry<>(
            "zeppelin-off (outline)",
            "TablerIcon.create(TablerVehicles.OutlineIcon.ZEPPELIN_OFF)",
            tagIcons::zeppelin_off));
    icons.add(
        new IconCatalogEntry<>(
            "aerial-lift (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.AERIAL_LIFT)",
            tagIcons::aerial_lift_filled));
    icons.add(
        new IconCatalogEntry<>(
            "air-balloon (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.AIR_BALLOON)",
            tagIcons::air_balloon_filled));
    icons.add(
        new IconCatalogEntry<>(
            "automatic-gearbox (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.AUTOMATIC_GEARBOX)",
            tagIcons::automatic_gearbox_filled));
    icons.add(
        new IconCatalogEntry<>(
            "battery-automotive (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.BATTERY_AUTOMOTIVE)",
            tagIcons::battery_automotive_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bike (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.BIKE)",
            tagIcons::bike_filled));
    icons.add(
        new IconCatalogEntry<>(
            "bus (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.BUS)",
            tagIcons::bus_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CAR)",
            tagIcons::car_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-4wd (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CAR_4WD)",
            tagIcons::car_4wd_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-crane (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CAR_CRANE)",
            tagIcons::car_crane_filled));
    icons.add(
        new IconCatalogEntry<>(
            "car-fan (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CAR_FAN)",
            tagIcons::car_fan_filled));
  }

  private static void addIcons1() {
    icons.add(
        new IconCatalogEntry<>(
            "car-suv (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CAR_SUV)",
            tagIcons::car_suv_filled));
    icons.add(
        new IconCatalogEntry<>(
            "caravan (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CARAVAN)",
            tagIcons::caravan_filled));
    icons.add(
        new IconCatalogEntry<>(
            "charging-pile (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.CHARGING_PILE)",
            tagIcons::charging_pile_filled));
    icons.add(
        new IconCatalogEntry<>(
            "engine (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.ENGINE)",
            tagIcons::engine_filled));
    icons.add(
        new IconCatalogEntry<>(
            "ferry (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.FERRY)",
            tagIcons::ferry_filled));
    icons.add(
        new IconCatalogEntry<>(
            "garden-cart (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.GARDEN_CART)",
            tagIcons::garden_cart_filled));
    icons.add(
        new IconCatalogEntry<>(
            "gas-station (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.GAS_STATION)",
            tagIcons::gas_station_filled));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.HELICOPTER)",
            tagIcons::helicopter_filled));
    icons.add(
        new IconCatalogEntry<>(
            "helicopter-landing (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.HELICOPTER_LANDING)",
            tagIcons::helicopter_landing_filled));
    icons.add(
        new IconCatalogEntry<>(
            "motorbike (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.MOTORBIKE)",
            tagIcons::motorbike_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.PLANE)",
            tagIcons::plane_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-arrival (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.PLANE_ARRIVAL)",
            tagIcons::plane_arrival_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-departure (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.PLANE_DEPARTURE)",
            tagIcons::plane_departure_filled));
    icons.add(
        new IconCatalogEntry<>(
            "plane-tilt (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.PLANE_TILT)",
            tagIcons::plane_tilt_filled));
    icons.add(
        new IconCatalogEntry<>(
            "rollercoaster (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.ROLLERCOASTER)",
            tagIcons::rollercoaster_filled));
    icons.add(
        new IconCatalogEntry<>(
            "speedboat (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.SPEEDBOAT)",
            tagIcons::speedboat_filled));
    icons.add(
        new IconCatalogEntry<>(
            "steering-wheel (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.STEERING_WHEEL)",
            tagIcons::steering_wheel_filled));
    icons.add(
        new IconCatalogEntry<>(
            "train (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.TRAIN)",
            tagIcons::train_filled));
    icons.add(
        new IconCatalogEntry<>(
            "trolley (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.TROLLEY)",
            tagIcons::trolley_filled));
    icons.add(
        new IconCatalogEntry<>(
            "truck (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.TRUCK)",
            tagIcons::truck_filled));
    icons.add(
        new IconCatalogEntry<>(
            "zeppelin (filled)",
            "TablerIcon.create(TablerVehicles.FilledIcon.ZEPPELIN)",
            tagIcons::zeppelin_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
