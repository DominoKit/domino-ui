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
import org.dominokit.domino.ui.icons.TablerPhotography;

/** Static icon factory for the Tabler Photography category. */
public final class TablerPhotography_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerPhotography tagIcons = new TablerPhotography() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>("aperture", "TablerIcons.aperture()", tagIcons::aperture));
    icons.add(
        new IconCatalogEntry<>(
            "aperture-off", "TablerIcons.aperture_off()", tagIcons::aperture_off));
    icons.add(
        new IconCatalogEntry<>(
            "brightness", "TablerIcons.brightness()", tagIcons::brightness));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-2", "TablerIcons.brightness_2()", tagIcons::brightness_2));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-auto",
            "TablerIcons.brightness_auto()",
            tagIcons::brightness_auto));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-down",
            "TablerIcons.brightness_down()",
            tagIcons::brightness_down));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-half",
            "TablerIcons.brightness_half()",
            tagIcons::brightness_half));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-off", "TablerIcons.brightness_off()", tagIcons::brightness_off));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-up", "TablerIcons.brightness_up()", tagIcons::brightness_up));
    icons.add(
        new IconCatalogEntry<>(
            "camera-rotate", "TablerIcons.camera_rotate()", tagIcons::camera_rotate));
    icons.add(
        new IconCatalogEntry<>(
            "camera-selfie", "TablerIcons.camera_selfie()", tagIcons::camera_selfie));
    icons.add(
        new IconCatalogEntry<>("contrast", "TablerIcons.contrast()", tagIcons::contrast));
    icons.add(
        new IconCatalogEntry<>(
            "contrast-2", "TablerIcons.contrast_2()", tagIcons::contrast_2));
    icons.add(
        new IconCatalogEntry<>(
            "contrast-2-off", "TablerIcons.contrast_2_off()", tagIcons::contrast_2_off));
    icons.add(
        new IconCatalogEntry<>(
            "contrast-off", "TablerIcons.contrast_off()", tagIcons::contrast_off));
    icons.add(
        new IconCatalogEntry<>("exposure", "TablerIcons.exposure()", tagIcons::exposure));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-0", "TablerIcons.exposure_0()", tagIcons::exposure_0));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-minus-1",
            "TablerIcons.exposure_minus_1()",
            tagIcons::exposure_minus_1));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-minus-2",
            "TablerIcons.exposure_minus_2()",
            tagIcons::exposure_minus_2));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-off", "TablerIcons.exposure_off()", tagIcons::exposure_off));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-plus-1",
            "TablerIcons.exposure_plus_1()",
            tagIcons::exposure_plus_1));
    icons.add(
        new IconCatalogEntry<>(
            "exposure-plus-2",
            "TablerIcons.exposure_plus_2()",
            tagIcons::exposure_plus_2));
    icons.add(new IconCatalogEntry<>("focus", "TablerIcons.focus()", tagIcons::focus));
    icons.add(
        new IconCatalogEntry<>("focus-2", "TablerIcons.focus_2()", tagIcons::focus_2));
    icons.add(
        new IconCatalogEntry<>(
            "focus-auto", "TablerIcons.focus_auto()", tagIcons::focus_auto));
    icons.add(new IconCatalogEntry<>("hdr", "TablerIcons.hdr()", tagIcons::hdr));
    icons.add(
        new IconCatalogEntry<>(
            "image-in-picture",
            "TablerIcons.image_in_picture()",
            tagIcons::image_in_picture));
    icons.add(
        new IconCatalogEntry<>(
            "lens-concave", "TablerIcons.lens_concave()", tagIcons::lens_concave));
    icons.add(
        new IconCatalogEntry<>(
            "lens-convex", "TablerIcons.lens_convex()", tagIcons::lens_convex));
    icons.add(
        new IconCatalogEntry<>(
            "live-photo", "TablerIcons.live_photo()", tagIcons::live_photo));
    icons.add(
        new IconCatalogEntry<>(
            "live-photo-off", "TablerIcons.live_photo_off()", tagIcons::live_photo_off));
    icons.add(new IconCatalogEntry<>("macro", "TablerIcons.macro()", tagIcons::macro));
    icons.add(
        new IconCatalogEntry<>(
            "macro-off", "TablerIcons.macro_off()", tagIcons::macro_off));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-horizontal",
            "TablerIcons.panorama_horizontal()",
            tagIcons::panorama_horizontal));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-horizontal-off",
            "TablerIcons.panorama_horizontal_off()",
            tagIcons::panorama_horizontal_off));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-vertical",
            "TablerIcons.panorama_vertical()",
            tagIcons::panorama_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-vertical-off",
            "TablerIcons.panorama_vertical_off()",
            tagIcons::panorama_vertical_off));
    icons.add(
        new IconCatalogEntry<>(
            "photo-bitcoin", "TablerIcons.photo_bitcoin()", tagIcons::photo_bitcoin));
    icons.add(
        new IconCatalogEntry<>(
            "photo-circle", "TablerIcons.photo_circle()", tagIcons::photo_circle));
    icons.add(
        new IconCatalogEntry<>(
            "photo-hexagon", "TablerIcons.photo_hexagon()", tagIcons::photo_hexagon));
    icons.add(
        new IconCatalogEntry<>(
            "photo-pentagon", "TablerIcons.photo_pentagon()", tagIcons::photo_pentagon));
    icons.add(
        new IconCatalogEntry<>(
            "photo-sensor", "TablerIcons.photo_sensor()", tagIcons::photo_sensor));
    icons.add(
        new IconCatalogEntry<>(
            "photo-sensor-2", "TablerIcons.photo_sensor_2()", tagIcons::photo_sensor_2));
    icons.add(
        new IconCatalogEntry<>(
            "photo-sensor-3", "TablerIcons.photo_sensor_3()", tagIcons::photo_sensor_3));
    icons.add(
        new IconCatalogEntry<>(
            "photo-square-rounded",
            "TablerIcons.photo_square_rounded()",
            tagIcons::photo_square_rounded));
    icons.add(
        new IconCatalogEntry<>(
            "photo-video", "TablerIcons.photo_video()", tagIcons::photo_video));
    icons.add(
        new IconCatalogEntry<>("polaroid", "TablerIcons.polaroid()", tagIcons::polaroid));
    icons.add(
        new IconCatalogEntry<>(
            "screenshot", "TablerIcons.screenshot()", tagIcons::screenshot));
    icons.add(new IconCatalogEntry<>("shadow", "TablerIcons.shadow()", tagIcons::shadow));
    icons.add(
        new IconCatalogEntry<>(
            "shadow-off", "TablerIcons.shadow_off()", tagIcons::shadow_off));
    icons.add(
        new IconCatalogEntry<>(
            "tilt-shift", "TablerIcons.tilt_shift()", tagIcons::tilt_shift));
    icons.add(
        new IconCatalogEntry<>(
            "tilt-shift-off", "TablerIcons.tilt_shift_off()", tagIcons::tilt_shift_off));
    icons.add(
        new IconCatalogEntry<>(
            "brightness", "TablerIcons.brightness_filled()", tagIcons::brightness_filled));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-auto",
            "TablerIcons.brightness_auto_filled()",
            tagIcons::brightness_auto_filled));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-down",
            "TablerIcons.brightness_down_filled()",
            tagIcons::brightness_down_filled));
    icons.add(
        new IconCatalogEntry<>(
            "brightness-up",
            "TablerIcons.brightness_up_filled()",
            tagIcons::brightness_up_filled));
    icons.add(
        new IconCatalogEntry<>(
            "contrast", "TablerIcons.contrast_filled()", tagIcons::contrast_filled));
    icons.add(
        new IconCatalogEntry<>(
            "contrast-2", "TablerIcons.contrast_2_filled()", tagIcons::contrast_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "exposure", "TablerIcons.exposure_filled()", tagIcons::exposure_filled));
    icons.add(
        new IconCatalogEntry<>(
            "live-photo", "TablerIcons.live_photo_filled()", tagIcons::live_photo_filled));
    icons.add(
        new IconCatalogEntry<>(
            "macro", "TablerIcons.macro_filled()", tagIcons::macro_filled));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-horizontal",
            "TablerIcons.panorama_horizontal_filled()",
            tagIcons::panorama_horizontal_filled));
    icons.add(
        new IconCatalogEntry<>(
            "panorama-vertical",
            "TablerIcons.panorama_vertical_filled()",
            tagIcons::panorama_vertical_filled));
    icons.add(
        new IconCatalogEntry<>(
            "polaroid", "TablerIcons.polaroid_filled()", tagIcons::polaroid_filled));
    icons.add(
        new IconCatalogEntry<>(
            "tilt-shift", "TablerIcons.tilt_shift_filled()", tagIcons::tilt_shift_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
