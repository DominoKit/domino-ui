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
import org.dominokit.domino.ui.icons.MaterialSymbolsHousehold;
import org.dominokit.domino.ui.icons.MaterialSymbolsIcon;

/** Static icon factory for the Material Symbols Household category. */
public final class MaterialSymbolsHousehold_Factory {
  private static final List<IconCatalogEntry<MaterialSymbolsIcon>> icons = new ArrayList<>();
  private static final MaterialSymbolsHousehold tagIcons = new MaterialSymbolsHousehold() {};

  static {
    addIcons0();
    addIcons1();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "ac_unit", "MaterialSymbols.ac_unit()", tagIcons::ac_unit_household));
    icons.add(
        new IconCatalogEntry<>(
            "air_freshener", "MaterialSymbols.air_freshener()", tagIcons::air_freshener_household));
    icons.add(
        new IconCatalogEntry<>(
            "air_purifier", "MaterialSymbols.air_purifier()", tagIcons::air_purifier_household));
    icons.add(
        new IconCatalogEntry<>(
            "air_purifier_gen",
            "MaterialSymbols.air_purifier_gen()",
            tagIcons::air_purifier_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "apparel", "MaterialSymbols.apparel()", tagIcons::apparel_household));
    icons.add(
        new IconCatalogEntry<>(
            "back_hand", "MaterialSymbols.back_hand()", tagIcons::back_hand_household));
    icons.add(
        new IconCatalogEntry<>(
            "balcony", "MaterialSymbols.balcony()", tagIcons::balcony_household));
    icons.add(
        new IconCatalogEntry<>(
            "bath_soak", "MaterialSymbols.bath_soak()", tagIcons::bath_soak_household));
    icons.add(
        new IconCatalogEntry<>(
            "bathroom", "MaterialSymbols.bathroom()", tagIcons::bathroom_household));
    icons.add(
        new IconCatalogEntry<>(
            "bathtub", "MaterialSymbols.bathtub()", tagIcons::bathtub_household));
    icons.add(new IconCatalogEntry<>("bed", "MaterialSymbols.bed()", tagIcons::bed_household));
    icons.add(
        new IconCatalogEntry<>(
            "bedroom_baby", "MaterialSymbols.bedroom_baby()", tagIcons::bedroom_baby_household));
    icons.add(
        new IconCatalogEntry<>(
            "bedroom_child", "MaterialSymbols.bedroom_child()", tagIcons::bedroom_child_household));
    icons.add(
        new IconCatalogEntry<>(
            "bedroom_parent",
            "MaterialSymbols.bedroom_parent()",
            tagIcons::bedroom_parent_household));
    icons.add(
        new IconCatalogEntry<>(
            "blanket", "MaterialSymbols.blanket()", tagIcons::blanket_household));
    icons.add(
        new IconCatalogEntry<>(
            "blender", "MaterialSymbols.blender()", tagIcons::blender_household));
    icons.add(
        new IconCatalogEntry<>("blinds", "MaterialSymbols.blinds()", tagIcons::blinds_household));
    icons.add(
        new IconCatalogEntry<>(
            "blinds_2", "MaterialSymbols.blinds_2()", tagIcons::blinds_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "blinds_2_closed",
            "MaterialSymbols.blinds_2_closed()",
            tagIcons::blinds_2_closed_household));
    icons.add(
        new IconCatalogEntry<>(
            "blinds_closed", "MaterialSymbols.blinds_closed()", tagIcons::blinds_closed_household));
    icons.add(
        new IconCatalogEntry<>(
            "camera_indoor", "MaterialSymbols.camera_indoor()", tagIcons::camera_indoor_household));
    icons.add(
        new IconCatalogEntry<>(
            "camera_outdoor",
            "MaterialSymbols.camera_outdoor()",
            tagIcons::camera_outdoor_household));
    icons.add(
        new IconCatalogEntry<>("chair", "MaterialSymbols.chair()", tagIcons::chair_household));
    icons.add(
        new IconCatalogEntry<>(
            "chair_alt", "MaterialSymbols.chair_alt()", tagIcons::chair_alt_household));
    icons.add(
        new IconCatalogEntry<>(
            "chair_counter", "MaterialSymbols.chair_counter()", tagIcons::chair_counter_household));
    icons.add(
        new IconCatalogEntry<>(
            "chair_fireplace",
            "MaterialSymbols.chair_fireplace()",
            tagIcons::chair_fireplace_household));
    icons.add(
        new IconCatalogEntry<>(
            "chair_umbrella",
            "MaterialSymbols.chair_umbrella()",
            tagIcons::chair_umbrella_household));
    icons.add(
        new IconCatalogEntry<>(
            "checkroom", "MaterialSymbols.checkroom()", tagIcons::checkroom_household));
    icons.add(
        new IconCatalogEntry<>(
            "child_care", "MaterialSymbols.child_care()", tagIcons::child_care_household));
    icons.add(
        new IconCatalogEntry<>("coffee", "MaterialSymbols.coffee()", tagIcons::coffee_household));
    icons.add(
        new IconCatalogEntry<>(
            "coffee_maker", "MaterialSymbols.coffee_maker()", tagIcons::coffee_maker_household));
    icons.add(
        new IconCatalogEntry<>(
            "controller_gen",
            "MaterialSymbols.controller_gen()",
            tagIcons::controller_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "cooking", "MaterialSymbols.cooking()", tagIcons::cooking_household));
    icons.add(
        new IconCatalogEntry<>(
            "countertops", "MaterialSymbols.countertops()", tagIcons::countertops_household));
    icons.add(new IconCatalogEntry<>("crib", "MaterialSymbols.crib()", tagIcons::crib_household));
    icons.add(
        new IconCatalogEntry<>(
            "curtains", "MaterialSymbols.curtains()", tagIcons::curtains_household));
    icons.add(
        new IconCatalogEntry<>(
            "curtains_closed",
            "MaterialSymbols.curtains_closed()",
            tagIcons::curtains_closed_household));
    icons.add(new IconCatalogEntry<>("deck", "MaterialSymbols.deck()", tagIcons::deck_household));
    icons.add(new IconCatalogEntry<>("desk", "MaterialSymbols.desk()", tagIcons::desk_household));
    icons.add(
        new IconCatalogEntry<>(
            "detector_smoke",
            "MaterialSymbols.detector_smoke()",
            tagIcons::detector_smoke_household));
    icons.add(
        new IconCatalogEntry<>(
            "dine_heart", "MaterialSymbols.dine_heart()", tagIcons::dine_heart_household));
    icons.add(
        new IconCatalogEntry<>(
            "dine_lamp", "MaterialSymbols.dine_lamp()", tagIcons::dine_lamp_household));
    icons.add(
        new IconCatalogEntry<>("dining", "MaterialSymbols.dining()", tagIcons::dining_household));
    icons.add(
        new IconCatalogEntry<>(
            "dishwasher", "MaterialSymbols.dishwasher()", tagIcons::dishwasher_household));
    icons.add(
        new IconCatalogEntry<>(
            "dishwasher_gen",
            "MaterialSymbols.dishwasher_gen()",
            tagIcons::dishwasher_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "door_back", "MaterialSymbols.door_back()", tagIcons::door_back_household));
    icons.add(
        new IconCatalogEntry<>(
            "door_front", "MaterialSymbols.door_front()", tagIcons::door_front_household));
    icons.add(
        new IconCatalogEntry<>(
            "door_sliding", "MaterialSymbols.door_sliding()", tagIcons::door_sliding_household));
    icons.add(
        new IconCatalogEntry<>(
            "doorbell", "MaterialSymbols.doorbell()", tagIcons::doorbell_household));
    icons.add(
        new IconCatalogEntry<>(
            "doorbell_3p", "MaterialSymbols.doorbell_3p()", tagIcons::doorbell_3p_household));
    icons.add(
        new IconCatalogEntry<>(
            "dresser", "MaterialSymbols.dresser()", tagIcons::dresser_household));
    icons.add(new IconCatalogEntry<>("dry", "MaterialSymbols.dry()", tagIcons::dry_household));
    icons.add(
        new IconCatalogEntry<>(
            "electric_bolt", "MaterialSymbols.electric_bolt()", tagIcons::electric_bolt_household));
    icons.add(
        new IconCatalogEntry<>(
            "electric_meter",
            "MaterialSymbols.electric_meter()",
            tagIcons::electric_meter_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_heat",
            "MaterialSymbols.emergency_heat()",
            tagIcons::emergency_heat_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_heat_2",
            "MaterialSymbols.emergency_heat_2()",
            tagIcons::emergency_heat_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_home",
            "MaterialSymbols.emergency_home()",
            tagIcons::emergency_home_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_recording",
            "MaterialSymbols.emergency_recording()",
            tagIcons::emergency_recording_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_share",
            "MaterialSymbols.emergency_share()",
            tagIcons::emergency_share_household));
    icons.add(
        new IconCatalogEntry<>(
            "emergency_share_off",
            "MaterialSymbols.emergency_share_off()",
            tagIcons::emergency_share_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "energy_program_saving",
            "MaterialSymbols.energy_program_saving()",
            tagIcons::energy_program_saving_household));
    icons.add(
        new IconCatalogEntry<>(
            "energy_program_time_used",
            "MaterialSymbols.energy_program_time_used()",
            tagIcons::energy_program_time_used_household));
    icons.add(
        new IconCatalogEntry<>(
            "energy_savings_leaf",
            "MaterialSymbols.energy_savings_leaf()",
            tagIcons::energy_savings_leaf_household));
    icons.add(
        new IconCatalogEntry<>(
            "event_seat", "MaterialSymbols.event_seat()", tagIcons::event_seat_household));
    icons.add(
        new IconCatalogEntry<>(
            "family_home", "MaterialSymbols.family_home()", tagIcons::family_home_household));
    icons.add(
        new IconCatalogEntry<>("faucet", "MaterialSymbols.faucet()", tagIcons::faucet_household));
    icons.add(
        new IconCatalogEntry<>("fence", "MaterialSymbols.fence()", tagIcons::fence_household));
    icons.add(
        new IconCatalogEntry<>(
            "fire_check", "MaterialSymbols.fire_check()", tagIcons::fire_check_household));
    icons.add(
        new IconCatalogEntry<>(
            "fire_extinguisher",
            "MaterialSymbols.fire_extinguisher()",
            tagIcons::fire_extinguisher_household));
    icons.add(
        new IconCatalogEntry<>(
            "fireplace", "MaterialSymbols.fireplace()", tagIcons::fireplace_household));
    icons.add(
        new IconCatalogEntry<>(
            "flatware", "MaterialSymbols.flatware()", tagIcons::flatware_household));
    icons.add(
        new IconCatalogEntry<>(
            "fork_spoon", "MaterialSymbols.fork_spoon()", tagIcons::fork_spoon_household));
    icons.add(
        new IconCatalogEntry<>(
            "foundation", "MaterialSymbols.foundation()", tagIcons::foundation_household));
    icons.add(
        new IconCatalogEntry<>(
            "fragrance", "MaterialSymbols.fragrance()", tagIcons::fragrance_household));
    icons.add(
        new IconCatalogEntry<>("garage", "MaterialSymbols.garage()", tagIcons::garage_household));
    icons.add(
        new IconCatalogEntry<>(
            "garage_door", "MaterialSymbols.garage_door()", tagIcons::garage_door_household));
    icons.add(
        new IconCatalogEntry<>(
            "garage_door_open",
            "MaterialSymbols.garage_door_open()",
            tagIcons::garage_door_open_household));
    icons.add(
        new IconCatalogEntry<>(
            "garage_home", "MaterialSymbols.garage_home()", tagIcons::garage_home_household));
    icons.add(
        new IconCatalogEntry<>(
            "gas_meter", "MaterialSymbols.gas_meter()", tagIcons::gas_meter_household));
    icons.add(new IconCatalogEntry<>("gate", "MaterialSymbols.gate()", tagIcons::gate_household));
    icons.add(
        new IconCatalogEntry<>("grass", "MaterialSymbols.grass()", tagIcons::grass_household));
    icons.add(
        new IconCatalogEntry<>(
            "grocery", "MaterialSymbols.grocery()", tagIcons::grocery_household));
    icons.add(
        new IconCatalogEntry<>(
            "hallway", "MaterialSymbols.hallway()", tagIcons::hallway_household));
    icons.add(
        new IconCatalogEntry<>(
            "hardware", "MaterialSymbols.hardware()", tagIcons::hardware_household));
    icons.add(
        new IconCatalogEntry<>(
            "health_and_beauty",
            "MaterialSymbols.health_and_beauty()",
            tagIcons::health_and_beauty_household));
    icons.add(
        new IconCatalogEntry<>(
            "heat_pump", "MaterialSymbols.heat_pump()", tagIcons::heat_pump_household));
    icons.add(
        new IconCatalogEntry<>(
            "high_chair", "MaterialSymbols.high_chair()", tagIcons::high_chair_household));
    icons.add(
        new IconCatalogEntry<>(
            "highlight", "MaterialSymbols.highlight()", tagIcons::highlight_household));
    icons.add(
        new IconCatalogEntry<>(
            "home_and_garden",
            "MaterialSymbols.home_and_garden()",
            tagIcons::home_and_garden_household));
    icons.add(
        new IconCatalogEntry<>(
            "home_improvement_and_tools",
            "MaterialSymbols.home_improvement_and_tools()",
            tagIcons::home_improvement_and_tools_household));
    icons.add(
        new IconCatalogEntry<>(
            "home_iot_device",
            "MaterialSymbols.home_iot_device()",
            tagIcons::home_iot_device_household));
    icons.add(
        new IconCatalogEntry<>(
            "hot_tub", "MaterialSymbols.hot_tub()", tagIcons::hot_tub_household));
    icons.add(
        new IconCatalogEntry<>("house", "MaterialSymbols.house()", tagIcons::house_household));
    icons.add(
        new IconCatalogEntry<>(
            "house_siding", "MaterialSymbols.house_siding()", tagIcons::house_siding_household));
    icons.add(
        new IconCatalogEntry<>(
            "household_supplies",
            "MaterialSymbols.household_supplies()",
            tagIcons::household_supplies_household));
    icons.add(
        new IconCatalogEntry<>(
            "humidity_high", "MaterialSymbols.humidity_high()", tagIcons::humidity_high_household));
    icons.add(
        new IconCatalogEntry<>(
            "humidity_low", "MaterialSymbols.humidity_low()", tagIcons::humidity_low_household));
    icons.add(
        new IconCatalogEntry<>(
            "humidity_mid", "MaterialSymbols.humidity_mid()", tagIcons::humidity_mid_household));
    icons.add(new IconCatalogEntry<>("hvac", "MaterialSymbols.hvac()", tagIcons::hvac_household));
    icons.add(
        new IconCatalogEntry<>(
            "in_home_mode", "MaterialSymbols.in_home_mode()", tagIcons::in_home_mode_household));
  }

  private static void addIcons1() {
    icons.add(new IconCatalogEntry<>("iron", "MaterialSymbols.iron()", tagIcons::iron_household));
    icons.add(
        new IconCatalogEntry<>("kettle", "MaterialSymbols.kettle()", tagIcons::kettle_household));
    icons.add(
        new IconCatalogEntry<>(
            "king_bed", "MaterialSymbols.king_bed()", tagIcons::king_bed_household));
    icons.add(
        new IconCatalogEntry<>(
            "kitchen", "MaterialSymbols.kitchen()", tagIcons::kitchen_household));
    icons.add(
        new IconCatalogEntry<>("light", "MaterialSymbols.light()", tagIcons::light_household));
    icons.add(
        new IconCatalogEntry<>(
            "light_group_2", "MaterialSymbols.light_group_2()", tagIcons::light_group_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "light_off", "MaterialSymbols.light_off()", tagIcons::light_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "lightbulb_2", "MaterialSymbols.lightbulb_2()", tagIcons::lightbulb_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "lightstrip", "MaterialSymbols.lightstrip()", tagIcons::lightstrip_household));
    icons.add(
        new IconCatalogEntry<>("living", "MaterialSymbols.living()", tagIcons::living_household));
    icons.add(
        new IconCatalogEntry<>("matter", "MaterialSymbols.matter()", tagIcons::matter_household));
    icons.add(
        new IconCatalogEntry<>(
            "microwave", "MaterialSymbols.microwave()", tagIcons::microwave_household));
    icons.add(
        new IconCatalogEntry<>(
            "microwave_gen", "MaterialSymbols.microwave_gen()", tagIcons::microwave_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_cool", "MaterialSymbols.mode_cool()", tagIcons::mode_cool_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_cool_off", "MaterialSymbols.mode_cool_off()", tagIcons::mode_cool_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_fan", "MaterialSymbols.mode_fan()", tagIcons::mode_fan_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_fan_2", "MaterialSymbols.mode_fan_2()", tagIcons::mode_fan_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_fan_off", "MaterialSymbols.mode_fan_off()", tagIcons::mode_fan_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_heat", "MaterialSymbols.mode_heat()", tagIcons::mode_heat_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_heat_cool",
            "MaterialSymbols.mode_heat_cool()",
            tagIcons::mode_heat_cool_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_heat_off", "MaterialSymbols.mode_heat_off()", tagIcons::mode_heat_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_night", "MaterialSymbols.mode_night()", tagIcons::mode_night_household));
    icons.add(
        new IconCatalogEntry<>(
            "mode_off_on", "MaterialSymbols.mode_off_on()", tagIcons::mode_off_on_household));
    icons.add(new IconCatalogEntry<>("mop", "MaterialSymbols.mop()", tagIcons::mop_household));
    icons.add(
        new IconCatalogEntry<>(
            "multicooker", "MaterialSymbols.multicooker()", tagIcons::multicooker_household));
    icons.add(
        new IconCatalogEntry<>(
            "outdoor_grill", "MaterialSymbols.outdoor_grill()", tagIcons::outdoor_grill_household));
    icons.add(
        new IconCatalogEntry<>("outlet", "MaterialSymbols.outlet()", tagIcons::outlet_household));
    icons.add(new IconCatalogEntry<>("oven", "MaterialSymbols.oven()", tagIcons::oven_household));
    icons.add(
        new IconCatalogEntry<>(
            "oven_gen", "MaterialSymbols.oven_gen()", tagIcons::oven_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "propane", "MaterialSymbols.propane()", tagIcons::propane_household));
    icons.add(
        new IconCatalogEntry<>(
            "propane_tank", "MaterialSymbols.propane_tank()", tagIcons::propane_tank_household));
    icons.add(
        new IconCatalogEntry<>(
            "range_hood", "MaterialSymbols.range_hood()", tagIcons::range_hood_household));
    icons.add(
        new IconCatalogEntry<>(
            "remote_gen", "MaterialSymbols.remote_gen()", tagIcons::remote_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "roller_shades", "MaterialSymbols.roller_shades()", tagIcons::roller_shades_household));
    icons.add(
        new IconCatalogEntry<>(
            "roller_shades_closed",
            "MaterialSymbols.roller_shades_closed()",
            tagIcons::roller_shades_closed_household));
    icons.add(
        new IconCatalogEntry<>(
            "roofing", "MaterialSymbols.roofing()", tagIcons::roofing_household));
    icons.add(
        new IconCatalogEntry<>("scene", "MaterialSymbols.scene()", tagIcons::scene_household));
    icons.add(
        new IconCatalogEntry<>(
            "sensor_door", "MaterialSymbols.sensor_door()", tagIcons::sensor_door_household));
    icons.add(
        new IconCatalogEntry<>(
            "sensor_occupied",
            "MaterialSymbols.sensor_occupied()",
            tagIcons::sensor_occupied_household));
    icons.add(
        new IconCatalogEntry<>(
            "sensor_window", "MaterialSymbols.sensor_window()", tagIcons::sensor_window_household));
    icons.add(
        new IconCatalogEntry<>(
            "sensors", "MaterialSymbols.sensors()", tagIcons::sensors_household));
    icons.add(
        new IconCatalogEntry<>(
            "sensors_off", "MaterialSymbols.sensors_off()", tagIcons::sensors_off_household));
    icons.add(
        new IconCatalogEntry<>("shades", "MaterialSymbols.shades()", tagIcons::shades_household));
    icons.add(
        new IconCatalogEntry<>(
            "shades_closed", "MaterialSymbols.shades_closed()", tagIcons::shades_closed_household));
    icons.add(
        new IconCatalogEntry<>(
            "shelves", "MaterialSymbols.shelves()", tagIcons::shelves_household));
    icons.add(
        new IconCatalogEntry<>(
            "shield_moon", "MaterialSymbols.shield_moon()", tagIcons::shield_moon_household));
    icons.add(
        new IconCatalogEntry<>("shower", "MaterialSymbols.shower()", tagIcons::shower_household));
    icons.add(
        new IconCatalogEntry<>(
            "single_bed", "MaterialSymbols.single_bed()", tagIcons::single_bed_household));
    icons.add(
        new IconCatalogEntry<>(
            "skillet", "MaterialSymbols.skillet()", tagIcons::skillet_household));
    icons.add(
        new IconCatalogEntry<>(
            "skillet_cooktop",
            "MaterialSymbols.skillet_cooktop()",
            tagIcons::skillet_cooktop_household));
    icons.add(
        new IconCatalogEntry<>(
            "smart_outlet", "MaterialSymbols.smart_outlet()", tagIcons::smart_outlet_household));
    icons.add(new IconCatalogEntry<>("soap", "MaterialSymbols.soap()", tagIcons::soap_household));
    icons.add(
        new IconCatalogEntry<>(
            "soundbar", "MaterialSymbols.soundbar()", tagIcons::soundbar_household));
    icons.add(
        new IconCatalogEntry<>(
            "speaker_2", "MaterialSymbols.speaker_2()", tagIcons::speaker_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "sprinkler", "MaterialSymbols.sprinkler()", tagIcons::sprinkler_household));
    icons.add(
        new IconCatalogEntry<>(
            "stockpot", "MaterialSymbols.stockpot()", tagIcons::stockpot_household));
    icons.add(
        new IconCatalogEntry<>(
            "stroller", "MaterialSymbols.stroller()", tagIcons::stroller_household));
    icons.add(
        new IconCatalogEntry<>("styler", "MaterialSymbols.styler()", tagIcons::styler_household));
    icons.add(
        new IconCatalogEntry<>(
            "subwoofer", "MaterialSymbols.subwoofer()", tagIcons::subwoofer_household));
    icons.add(
        new IconCatalogEntry<>(
            "switch", "MaterialSymbols.switch_icon()", tagIcons::switch_icon_household));
    icons.add(
        new IconCatalogEntry<>(
            "switch_off", "MaterialSymbols.switch_off()", tagIcons::switch_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "table_bar", "MaterialSymbols.table_bar()", tagIcons::table_bar_household));
    icons.add(
        new IconCatalogEntry<>(
            "table_large", "MaterialSymbols.table_large()", tagIcons::table_large_household));
    icons.add(
        new IconCatalogEntry<>(
            "table_restaurant",
            "MaterialSymbols.table_restaurant()",
            tagIcons::table_restaurant_household));
    icons.add(
        new IconCatalogEntry<>(
            "tamper_detection_off",
            "MaterialSymbols.tamper_detection_off()",
            tagIcons::tamper_detection_off_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer", "MaterialSymbols.thermometer()", tagIcons::thermometer_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer_add",
            "MaterialSymbols.thermometer_add()",
            tagIcons::thermometer_add_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer_alert",
            "MaterialSymbols.thermometer_alert()",
            tagIcons::thermometer_alert_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer_gain",
            "MaterialSymbols.thermometer_gain()",
            tagIcons::thermometer_gain_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer_loss",
            "MaterialSymbols.thermometer_loss()",
            tagIcons::thermometer_loss_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermometer_minus",
            "MaterialSymbols.thermometer_minus()",
            tagIcons::thermometer_minus_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermostat_auto",
            "MaterialSymbols.thermostat_auto()",
            tagIcons::thermostat_auto_household));
    icons.add(
        new IconCatalogEntry<>(
            "thermostat_carbon",
            "MaterialSymbols.thermostat_carbon()",
            tagIcons::thermostat_carbon_household));
    icons.add(
        new IconCatalogEntry<>("tv_gen", "MaterialSymbols.tv_gen()", tagIcons::tv_gen_household));
    icons.add(
        new IconCatalogEntry<>(
            "tv_with_assistant",
            "MaterialSymbols.tv_with_assistant()",
            tagIcons::tv_with_assistant_household));
    icons.add(
        new IconCatalogEntry<>(
            "umbrella", "MaterialSymbols.umbrella()", tagIcons::umbrella_household));
    icons.add(
        new IconCatalogEntry<>("vacuum", "MaterialSymbols.vacuum()", tagIcons::vacuum_household));
    icons.add(
        new IconCatalogEntry<>(
            "vacuum_2", "MaterialSymbols.vacuum_2()", tagIcons::vacuum_2_household));
    icons.add(
        new IconCatalogEntry<>(
            "vacuum_2_on", "MaterialSymbols.vacuum_2_on()", tagIcons::vacuum_2_on_household));
    icons.add(
        new IconCatalogEntry<>("valve", "MaterialSymbols.valve()", tagIcons::valve_household));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_shades",
            "MaterialSymbols.vertical_shades()",
            tagIcons::vertical_shades_household));
    icons.add(
        new IconCatalogEntry<>(
            "vertical_shades_closed",
            "MaterialSymbols.vertical_shades_closed()",
            tagIcons::vertical_shades_closed_household));
    icons.add(
        new IconCatalogEntry<>(
            "wall_art", "MaterialSymbols.wall_art()", tagIcons::wall_art_household));
    icons.add(new IconCatalogEntry<>("wash", "MaterialSymbols.wash()", tagIcons::wash_household));
    icons.add(
        new IconCatalogEntry<>(
            "water_damage", "MaterialSymbols.water_damage()", tagIcons::water_damage_household));
    icons.add(
        new IconCatalogEntry<>(
            "water_heater", "MaterialSymbols.water_heater()", tagIcons::water_heater_household));
    icons.add(
        new IconCatalogEntry<>(
            "weekend", "MaterialSymbols.weekend()", tagIcons::weekend_household));
    icons.add(
        new IconCatalogEntry<>("window", "MaterialSymbols.window()", tagIcons::window_household));
    icons.add(new IconCatalogEntry<>("yard", "MaterialSymbols.yard()", tagIcons::yard_household));
  }

  public List<IconCatalogEntry<MaterialSymbolsIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
