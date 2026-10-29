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

/** Tabler Photography catalog category. */
public interface TablerPhotography {
  enum OutlineIcon implements TablerIconDefinition {
    APERTURE(
        "aperture",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M3.6 15h10.55\" />\n  <path d=\"M6.551 4.938l3.26 10.034\" />\n  <path d=\"M17.032 4.636l-8.535 6.201\" />\n  <path d=\"M20.559 14.51l-8.535 -6.201\" />\n  <path d=\"M12.257 20.916l3.261 -10.034\" />"),
    APERTURE_OFF(
        "aperture-off",
        "<path d=\"M3.6 15h10.55\" />\n  <path d=\"M5.641 5.631a9 9 0 1 0 12.719 12.738m1.68 -2.318a9 9 0 0 0 -12.074 -12.098\" />\n  <path d=\"M7.395 7.534l2.416 7.438\" />\n  <path d=\"M17.032 4.636l-4.852 3.526m-2.334 1.695l-1.349 .98\" />\n  <path d=\"M20.559 14.51l-8.535 -6.201\" />\n  <path d=\"M12.257 20.916l2.123 -6.533m.984 -3.028l.154 -.473\" />\n  <path d=\"M3 3l18 18\" />"),
    BRIGHTNESS(
        "brightness",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 3l0 18\" />\n  <path d=\"M12 9l4.65 -4.65\" />\n  <path d=\"M12 14.3l7.37 -7.37\" />\n  <path d=\"M12 19.6l8.85 -8.85\" />"),
    BRIGHTNESS_2(
        "brightness-2",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M6 6h3.5l2.5 -2.5l2.5 2.5h3.5v3.5l2.5 2.5l-2.5 2.5v3.5h-3.5l-2.5 2.5l-2.5 -2.5h-3.5v-3.5l-2.5 -2.5l2.5 -2.5l0 -3.5\" />"),
    BRIGHTNESS_AUTO(
        "brightness-auto",
        "<path d=\"M6 6h3.5l2.5 -2.5l2.5 2.5h3.5v3.5l2.5 2.5l-2.5 2.5v3.5h-3.5l-2.5 2.5l-2.5 -2.5h-3.5v-3.5l-2.5 -2.5l2.5 -2.5l0 -3.5\" />\n  <path d=\"M10 14.5v-3.5a2 2 0 1 1 4 0v3.5\" />\n  <path d=\"M10 13h4\" />"),
    BRIGHTNESS_DOWN(
        "brightness-down",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 5l0 .01\" />\n  <path d=\"M17 7l0 .01\" />\n  <path d=\"M19 12l0 .01\" />\n  <path d=\"M17 17l0 .01\" />\n  <path d=\"M12 19l0 .01\" />\n  <path d=\"M7 17l0 .01\" />\n  <path d=\"M5 12l0 .01\" />\n  <path d=\"M7 7l0 .01\" />"),
    BRIGHTNESS_HALF(
        "brightness-half",
        "<path d=\"M12 9a3 3 0 0 0 0 6v-6\" />\n  <path d=\"M6 6h3.5l2.5 -2.5l2.5 2.5h3.5v3.5l2.5 2.5l-2.5 2.5v3.5h-3.5l-2.5 2.5l-2.5 -2.5h-3.5v-3.5l-2.5 -2.5l2.5 -2.5l0 -3.5\" />"),
    BRIGHTNESS_OFF(
        "brightness-off",
        "<path d=\"M12 3v5m0 4v9\" />\n  <path d=\"M5.641 5.631a9 9 0 1 0 12.719 12.738m1.68 -2.318a9 9 0 0 0 -12.074 -12.098\" />\n  <path d=\"M12.5 8.5l4.15 -4.15\" />\n  <path d=\"M12 14l1.025 -.983m2.065 -1.981l4.28 -4.106\" />\n  <path d=\"M12 19.6l3.79 -3.79m2 -2l3.054 -3.054\" />\n  <path d=\"M3 3l18 18\" />"),
    BRIGHTNESS_UP(
        "brightness-up",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 5l0 -2\" />\n  <path d=\"M17 7l1.4 -1.4\" />\n  <path d=\"M19 12l2 0\" />\n  <path d=\"M17 17l1.4 1.4\" />\n  <path d=\"M12 19l0 2\" />\n  <path d=\"M7 17l-1.4 1.4\" />\n  <path d=\"M6 12l-2 0\" />\n  <path d=\"M7 7l-1.4 -1.4\" />"),
    CAMERA_ROTATE(
        "camera-rotate",
        "<path d=\"M5 7h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2\" />\n  <path d=\"M11.245 15.904a3 3 0 0 0 3.755 -2.904m-2.25 -2.905a3 3 0 0 0 -3.75 2.905\" />\n  <path d=\"M14 13h2v2\" />\n  <path d=\"M10 13h-2v-2\" />"),
    CAMERA_SELFIE(
        "camera-selfie",
        "<path d=\"M5 7h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M15 11l.01 0\" />\n  <path d=\"M9 11l.01 0\" />"),
    CONTRAST(
        "contrast",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 17a5 5 0 0 0 0 -10v10\" />"),
    CONTRAST_2(
        "contrast-2",
        "<path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -14\" />\n  <path d=\"M3 19h2.25c3.728 0 6.75 -3.134 6.75 -7s3.022 -7 6.75 -7h2.25\" />"),
    CONTRAST_2_OFF(
        "contrast-2-off",
        "<path d=\"M4 18h2a6 6 0 0 0 6 -6m.878 -3.126a6 6 0 0 1 5.122 -2.874h2\" />\n  <path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.586 3.414a2 2 0 0 1 -1.414 .586h-12a2 2 0 0 1 -2 -2v-12c0 -.547 .22 -1.043 .576 -1.405\" />\n  <path d=\"M3 3l18 18\" />"),
    CONTRAST_OFF(
        "contrast-off",
        "<path d=\"M12 12v5a4.984 4.984 0 0 0 3.522 -1.45m1.392 -2.623a5 5 0 0 0 -4.914 -5.927v1\" />\n  <path d=\"M5.641 5.631a9 9 0 1 0 12.719 12.738m1.68 -2.318a9 9 0 0 0 -12.074 -12.098\" />\n  <path d=\"M3 3l18 18\" />"),
    EXPOSURE(
        "exposure",
        "<path d=\"M3.6 20.4l16.8 -16.8\" />\n  <path d=\"M6 8h4m-2 -2v4\" />\n  <path d=\"M14 16h4\" />\n  <path d=\"M3 5a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v14a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -14\" />"),
    EXPOSURE_0(
        "exposure-0", "<path d=\"M12 19a4 4 0 0 0 4 -4v-6a4 4 0 1 0 -8 0v6a4 4 0 0 0 4 4\" />"),
    EXPOSURE_MINUS_1(
        "exposure-minus-1", "<path d=\"M3 12h6\" />\n  <path d=\"M18 19v-14l-4 4\" />"),
    EXPOSURE_MINUS_2(
        "exposure-minus-2",
        "<path d=\"M12 9a4 4 0 1 1 8 0c0 1.098 -.564 2.025 -1.159 2.815l-6.841 7.185h8\" />\n  <path d=\"M3 12h6\" />"),
    EXPOSURE_OFF(
        "exposure-off",
        "<path d=\"M3.6 20.4l8.371 -8.371m2.04 -2.04l6.389 -6.389\" />\n  <path d=\"M6 8h2m0 0v2\" />\n  <path d=\"M14 16h2\" />\n  <path d=\"M7 3h12a2 2 0 0 1 2 2v12m-.5 3.5c-.362 .36 -.95 .5 -1.5 .5h-14a2 2 0 0 1 -2 -2v-14c0 -.541 .215 -1.033 .565 -1.393\" />\n  <path d=\"M3 3l18 18\" />"),
    EXPOSURE_PLUS_1(
        "exposure-plus-1",
        "<path d=\"M3 12h6\" />\n  <path d=\"M6 9v6\" />\n  <path d=\"M18 19v-14l-4 4\" />"),
    EXPOSURE_PLUS_2(
        "exposure-plus-2",
        "<path d=\"M12 9a4 4 0 1 1 8 0c0 1.098 -.564 2.025 -1.159 2.815l-6.841 7.185h8\" />\n  <path d=\"M3 12h6\" />\n  <path d=\"M6 9v6\" />"),
    FOCUS(
        "focus",
        "<path d=\"M11.5 12a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    FOCUS_2(
        "focus-2",
        "<path d=\"M11.5 12a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M12 3l0 2\" />\n  <path d=\"M3 12l2 0\" />\n  <path d=\"M12 19l0 2\" />\n  <path d=\"M19 12l2 0\" />"),
    FOCUS_AUTO(
        "focus-auto",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M10 15v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M10 13h4\" />"),
    HDR(
        "hdr",
        "<path d=\"M3 16v-8\" />\n  <path d=\"M7 8v8\" />\n  <path d=\"M3 12h4\" />\n  <path d=\"M10 8v8h2a2 2 0 0 0 2 -2v-4a2 2 0 0 0 -2 -2h-2\" />\n  <path d=\"M17 12h2a2 2 0 1 0 0 -4h-2v8m4 0l-3 -4\" />"),
    IMAGE_IN_PICTURE(
        "image-in-picture",
        "<path d=\"M13 15c-2 0 -5 1 -5 5\" />\n  <path d=\"M4 13a2 2 0 0 1 2 -2h5a2 2 0 0 1 2 2v5a2 2 0 0 1 -2 2h-5a2 2 0 0 1 -2 -2l0 -5\" />\n  <path d=\"M4 7v-2a1 1 0 0 1 1 -1h2\" />\n  <path d=\"M11 4h2\" />\n  <path d=\"M17 4h2a1 1 0 0 1 1 1v2\" />\n  <path d=\"M20 11v2\" />\n  <path d=\"M20 17v2a1 1 0 0 1 -1 1h-2\" />"),
    LENS_CONCAVE(
        "lens-concave",
        "<path d=\"M7.9 3a.9 .9 0 0 0 -.72 1.44a12.6 12.6 0 0 1 0 15.12a.9 .9 0 0 0 .72 1.44h9a.9 .9 0 0 0 .72 -1.44a12.6 12.6 0 0 1 0 -15.12a.9 .9 0 0 0 -.72 -1.44h-9\" />"),
    LENS_CONVEX(
        "lens-convex",
        "<path d=\"M12.79 3a.9 .9 0 0 1 .742 .403a16.2 16.2 0 0 1 0 17.194a.9 .9 0 0 1 -.742 .403h-2.58a.9 .9 0 0 1 -.74 -.403a16.2 16.2 0 0 1 0 -17.194a.9 .9 0 0 1 .74 -.403h2.58\" />"),
    LIVE_PHOTO(
        "live-photo",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 12a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M15.9 20.11l0 .01\" />\n  <path d=\"M19.04 17.61l0 .01\" />\n  <path d=\"M20.77 14l0 .01\" />\n  <path d=\"M20.77 10l0 .01\" />\n  <path d=\"M19.04 6.39l0 .01\" />\n  <path d=\"M15.9 3.89l0 .01\" />\n  <path d=\"M12 3l0 .01\" />\n  <path d=\"M8.1 3.89l0 .01\" />\n  <path d=\"M4.96 6.39l0 .01\" />\n  <path d=\"M3.23 10l0 .01\" />\n  <path d=\"M3.23 14l0 .01\" />\n  <path d=\"M4.96 17.61l0 .01\" />\n  <path d=\"M8.1 20.11l0 .01\" />\n  <path d=\"M12 21l0 .01\" />"),
    LIVE_PHOTO_OFF(
        "live-photo-off",
        "<path d=\"M11.296 11.29a1 1 0 1 0 1.414 1.415\" />\n  <path d=\"M8.473 8.456a5 5 0 1 0 7.076 7.066m1.365 -2.591a5 5 0 0 0 -5.807 -5.851\" />\n  <path d=\"M15.9 20.11v.01\" />\n  <path d=\"M19.04 17.61v.01\" />\n  <path d=\"M20.77 14v.01\" />\n  <path d=\"M20.77 10v.01\" />\n  <path d=\"M19.04 6.39v.01\" />\n  <path d=\"M15.9 3.89v.01\" />\n  <path d=\"M12 3v.01\" />\n  <path d=\"M8.1 3.89v.01\" />\n  <path d=\"M4.96 6.39v.01\" />\n  <path d=\"M3.23 10v.01\" />\n  <path d=\"M3.23 14v.01\" />\n  <path d=\"M4.96 17.61v.01\" />\n  <path d=\"M8.1 20.11v.01\" />\n  <path d=\"M12 21v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    MACRO(
        "macro",
        "<path d=\"M6 15a6 6 0 1 0 12 0\" />\n  <path d=\"M18 15a6 6 0 0 0 -6 6\" />\n  <path d=\"M12 21a6 6 0 0 0 -6 -6\" />\n  <path d=\"M12 21v-10\" />\n  <path d=\"M12 11a5 5 0 0 1 -5 -5v-3l3 2l2 -2l2 2l3 -2v3a5 5 0 0 1 -5 5\" />"),
    MACRO_OFF(
        "macro-off",
        "<path d=\"M6 15a6 6 0 0 0 11.47 2.467\" />\n  <path d=\"M15.53 15.53a6 6 0 0 0 -3.53 5.47\" />\n  <path d=\"M12 21a6 6 0 0 0 -6 -6\" />\n  <path d=\"M12 21v-10\" />\n  <path d=\"M10.866 10.87a5.007 5.007 0 0 1 -3.734 -3.723m-.132 -4.147l3 2l2 -2l2 2l3 -2v3a5 5 0 0 1 -2.604 4.389\" />\n  <path d=\"M3 3l18 18\" />"),
    PANORAMA_HORIZONTAL(
        "panorama-horizontal",
        "<path d=\"M4.338 5.53c5.106 1.932 10.211 1.932 15.317 0a1 1 0 0 1 1.345 .934v11c0 .692 -.692 1.2 -1.34 .962c-5.107 -1.932 -10.214 -1.932 -15.321 0c-.648 .246 -1.339 -.242 -1.339 -.935v-11.027a1 1 0 0 1 1.338 -.935l0 .001\" />"),
    PANORAMA_HORIZONTAL_OFF(
        "panorama-horizontal-off",
        "<path d=\"M10.95 6.952c2.901 .15 5.803 -.323 8.705 -1.42a1 1 0 0 1 1.345 .934v10.534m-3.212 .806c-4.483 -1.281 -8.966 -1.074 -13.449 .622a.993 .993 0 0 1 -1.339 -.935v-11.027a1 1 0 0 1 1.338 -.935c.588 .221 1.176 .418 1.764 .59\" />\n  <path d=\"M3 3l18 18\" />"),
    PANORAMA_VERTICAL(
        "panorama-vertical",
        "<path d=\"M18.463 4.338c-1.932 5.106 -1.932 10.211 0 15.317a1 1 0 0 1 -.934 1.345h-11c-.692 0 -1.208 -.692 -.962 -1.34c1.932 -5.107 1.932 -10.214 0 -15.321c-.246 -.648 .243 -1.339 .935 -1.339h11.028c.693 0 1.18 .691 .935 1.338l-.002 0\" />"),
    PANORAMA_VERTICAL_OFF(
        "panorama-vertical-off",
        "<path d=\"M7 3h10.53c.693 0 1.18 .691 .935 1.338c-1.098 2.898 -1.573 5.795 -1.425 8.692m.828 4.847c.172 .592 .37 1.185 .595 1.778a1 1 0 0 1 -.934 1.345h-11c-.692 0 -1.208 -.692 -.962 -1.34c1.697 -4.486 1.903 -8.973 .619 -13.46\" />\n  <path d=\"M3 3l18 18\" />"),
    PHOTO_BITCOIN(
        "photo-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M15 8h.01\" />\n  <path d=\"M13 21h-7a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l2.5 2.5\" />"),
    PHOTO_CIRCLE(
        "photo-circle",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2 2\" />\n  <path d=\"M3 12a9 9 0 0 0 9 9a9 9 0 0 0 9 -9a9 9 0 0 0 -9 -9a9 9 0 0 0 -9 9\" />"),
    PHOTO_HEXAGON(
        "photo-hexagon",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M19.875 6.27c.7 .398 1.13 1.143 1.125 1.948v7.284c0 .809 -.443 1.555 -1.158 1.948l-6.75 4.27a2.269 2.269 0 0 1 -2.184 0l-6.75 -4.27a2.225 2.225 0 0 1 -1.158 -1.948v-7.285c0 -.809 .443 -1.554 1.158 -1.947l6.75 -3.98a2.33 2.33 0 0 1 2.25 0l6.75 3.98h-.033\" />\n  <path d=\"M3.5 15.5l4.5 -4.5c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2.5 2.5\" />"),
    PHOTO_PENTAGON(
        "photo-pentagon",
        "<path d=\"M13.163 2.168l8.021 5.828c.694 .504 .984 1.397 .719 2.212l-3.064 9.43a1.978 1.978 0 0 1 -1.881 1.367h-9.916a1.978 1.978 0 0 1 -1.881 -1.367l-3.064 -9.43a1.978 1.978 0 0 1 .719 -2.212l8.021 -5.828a1.978 1.978 0 0 1 2.326 0\" />\n  <path d=\"M15 8h.01\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2 2\" />"),
    PHOTO_SENSOR(
        "photo-sensor",
        "<path d=\"M17 5h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 15v2a2 2 0 0 1 -2 2h-2\" />\n  <path d=\"M7 19h-2a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M3 9v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M7 10a1 1 0 0 1 1 -1h8a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1l0 -4\" />"),
    PHOTO_SENSOR_2(
        "photo-sensor-2",
        "<path d=\"M17 5h2a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-2\" />\n  <path d=\"M7 19h-2a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />"),
    PHOTO_SENSOR_3(
        "photo-sensor-3",
        "<path d=\"M17 4h1a2 2 0 0 1 2 2v1\" />\n  <path d=\"M20 17v1a2 2 0 0 1 -2 2h-1\" />\n  <path d=\"M7 20h-1a2 2 0 0 1 -2 -2v-1\" />\n  <path d=\"M4 7v-1a2 2 0 0 1 2 -2h1\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 18v2\" />\n  <path d=\"M4 12h2\" />\n  <path d=\"M12 4v2\" />\n  <path d=\"M20 12h-2\" />"),
    PHOTO_SQUARE_ROUNDED(
        "photo-square-rounded",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12 3c7.2 0 9 1.8 9 9c0 7.2 -1.8 9 -9 9c-7.2 0 -9 -1.8 -9 -9c0 -7.2 1.8 -9 9 -9\" />\n  <path d=\"M3.5 15.5l4.5 -4.5c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2.5 2.5\" />"),
    PHOTO_VIDEO(
        "photo-video",
        "<path d=\"M9 15h-3a3 3 0 0 1 -3 -3v-6a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v3\" />\n  <path d=\"M9 12a3 3 0 0 1 3 -3h6a3 3 0 0 1 3 3v6a3 3 0 0 1 -3 3h-6a3 3 0 0 1 -3 -3l0 -6\" />\n  <path d=\"M3 12l2.296 -2.296a2.41 2.41 0 0 1 3.408 0l.296 .296\" />\n  <path d=\"M14 13.5v3l2.5 -1.5l-2.5 -1.5\" />\n  <path d=\"M7 6v.01\" />"),
    POLAROID(
        "polaroid",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M4 16l16 0\" />\n  <path d=\"M4 12l3 -3c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M13 12l2 -2c.928 -.893 2.072 -.893 3 0l2 2\" />\n  <path d=\"M14 7l.01 0\" />"),
    SCREENSHOT(
        "screenshot",
        "<path d=\"M7 19a2 2 0 0 1 -2 -2\" />\n  <path d=\"M5 13v-2\" />\n  <path d=\"M5 7a2 2 0 0 1 2 -2\" />\n  <path d=\"M11 5h2\" />\n  <path d=\"M17 5a2 2 0 0 1 2 2\" />\n  <path d=\"M19 11v2\" />\n  <path d=\"M19 17v4\" />\n  <path d=\"M21 19h-4\" />\n  <path d=\"M13 19h-2\" />"),
    SHADOW(
        "shadow",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M13 12h5\" />\n  <path d=\"M13 15h4\" />\n  <path d=\"M13 18h1\" />\n  <path d=\"M13 9h4\" />\n  <path d=\"M13 6h1\" />"),
    SHADOW_OFF(
        "shadow-off",
        "<path d=\"M5.634 5.638a9 9 0 0 0 12.728 12.727m1.68 -2.32a9 9 0 0 0 -12.086 -12.088\" />\n  <path d=\"M16 12h2\" />\n  <path d=\"M13 15h2\" />\n  <path d=\"M13 18h1\" />\n  <path d=\"M13 9h4\" />\n  <path d=\"M13 6h1\" />\n  <path d=\"M3 3l18 18\" />"),
    TILT_SHIFT(
        "tilt-shift",
        "<path d=\"M8.56 3.69a9 9 0 0 0 -2.92 1.95\" />\n  <path d=\"M3.69 8.56a9 9 0 0 0 -.69 3.44\" />\n  <path d=\"M3.69 15.44a9 9 0 0 0 1.95 2.92\" />\n  <path d=\"M8.56 20.31a9 9 0 0 0 3.44 .69\" />\n  <path d=\"M15.44 20.31a9 9 0 0 0 2.92 -1.95\" />\n  <path d=\"M20.31 15.44a9 9 0 0 0 .69 -3.44\" />\n  <path d=\"M20.31 8.56a9 9 0 0 0 -1.95 -2.92\" />\n  <path d=\"M15.44 3.69a9 9 0 0 0 -3.44 -.69\" />\n  <path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    TILT_SHIFT_OFF(
        "tilt-shift-off",
        "<path d=\"M8.56 3.69a9 9 0 0 0 -.577 .263\" />\n  <path d=\"M3.69 8.56a9 9 0 0 0 -.69 3.44\" />\n  <path d=\"M3.69 15.44a9 9 0 0 0 1.95 2.92\" />\n  <path d=\"M8.56 20.31a9 9 0 0 0 3.44 .69\" />\n  <path d=\"M15.44 20.31a9 9 0 0 0 2.92 -1.95\" />\n  <path d=\"M20.31 15.44a9 9 0 0 0 .69 -3.44\" />\n  <path d=\"M20.31 8.56a9 9 0 0 0 -1.95 -2.92\" />\n  <path d=\"M15.44 3.69a9 9 0 0 0 -3.44 -.69\" />\n  <path d=\"M10.57 10.602a2 2 0 0 0 2.862 2.795\" />\n  <path d=\"M3 3l18 18\" />");

    private final String catalogName;
    private final String svg;

    OutlineIcon(String catalogName, String svg) {
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

  enum FilledIcon implements TablerIconDefinition {
    BRIGHTNESS(
        "brightness",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-9 1.732a8 8 0 0 0 4.001 14.928l-.001 -16a8 8 0 0 0 -4 1.072\" />"),
    BRIGHTNESS_AUTO(
        "brightness-auto",
        "<path d=\"M12.707 2.793l2.208 2.207h3.085a1 1 0 0 1 .993 .883l.007 .117v3.085l2.207 2.208a1 1 0 0 1 .083 1.32l-.083 .094l-2.207 2.207v3.086a1 1 0 0 1 -.883 .993l-.117 .007h-3.086l-2.207 2.207a1 1 0 0 1 -1.32 .083l-.094 -.083l-2.208 -2.207h-3.085a1 1 0 0 1 -.993 -.883l-.007 -.117v-3.085l-2.207 -2.208a1 1 0 0 1 -.083 -1.32l.083 -.094l2.207 -2.209v-3.084a1 1 0 0 1 .883 -.993l.117 -.007h3.084l2.209 -2.207a1 1 0 0 1 1.414 0m-.707 5.207a3 3 0 0 0 -3 3v3.5a1 1 0 0 0 2 0v-.5h2v.5a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-3.5a3 3 0 0 0 -3 -3m0 2a1 1 0 0 1 1 1v1h-2v-1a1 1 0 0 1 .883 -.993z\" />"),
    BRIGHTNESS_DOWN(
        "brightness-down",
        "<path d=\"M12 8a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M12 4a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M17 6a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M19 11a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M17 16a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 18a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M7 16a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M5 11a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M7 6a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />"),
    BRIGHTNESS_UP(
        "brightness-up",
        "<path d=\"M12 8a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M12 2a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M17.693 4.893a1 1 0 0 1 1.497 1.32l-.083 .094l-1.4 1.4a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.4 -1.4z\" />\n  <path d=\"M21 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />\n  <path d=\"M16.293 16.293a1 1 0 0 1 1.32 -.083l.094 .083l1.4 1.4a1 1 0 0 1 -1.32 1.497l-.094 -.083l-1.4 -1.4a1 1 0 0 1 0 -1.414z\" />\n  <path d=\"M12 18a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M6.293 16.293a1 1 0 0 1 1.497 1.32l-.083 .094l-1.4 1.4a1 1 0 0 1 -1.497 -1.32l.083 -.094l1.4 -1.4z\" />\n  <path d=\"M6 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />\n  <path d=\"M4.893 4.893a1 1 0 0 1 1.32 -.083l.094 .083l1.4 1.4a1 1 0 0 1 -1.32 1.497l-.094 -.083l-1.4 -1.4a1 1 0 0 1 0 -1.414z\" />"),
    CONTRAST(
        "contrast",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-9 1.732a8 8 0 0 0 4.001 14.928l-.001 -16a8 8 0 0 0 -4 1.072\" />"),
    CONTRAST_2(
        "contrast-2",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm0 2h-14a1 1 0 0 0 -1 1v14a1 1 0 0 0 .769 .973c3.499 -.347 7.082 -4.127 7.226 -7.747l.005 -.226c0 -3.687 3.66 -7.619 7.232 -7.974a1 1 0 0 0 -.232 -.026\" />"),
    EXPOSURE(
        "exposure",
        "<path d=\"M19 2a3 3 0 0 1 3 3v14a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-14a3 3 0 0 1 3 -3zm0 2h-14a1 1 0 0 0 -1 1v14c0 .29 .123 .55 .321 .732l1.61 -1.584a973 973 0 0 0 6.69 -6.675l7.094 -7.173a1 1 0 0 0 -.715 -.3m-1 11h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2m-10 -10a1 1 0 0 1 1 1v1h1a1 1 0 0 1 .993 .883l.007 .117a1 1 0 0 1 -1 1h-1v1a1 1 0 0 1 -.883 .993l-.117 .007a1 1 0 0 1 -1 -1v-1h-1a1 1 0 0 1 -.993 -.883l-.007 -.117a1 1 0 0 1 1 -1h1v-1a1 1 0 0 1 .883 -.993z\" />"),
    LIVE_PHOTO(
        "live-photo",
        "<path d=\"M12 6a6 6 0 1 1 -6 6l.004 -.225a6 6 0 0 1 5.996 -5.775m0 4a2 2 0 0 0 -1.995 1.85l-.005 .15a2 2 0 1 0 2 -2m3.9 9.11a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m3.14 -2.5a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m1.73 -3.61a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m0 -4a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m-1.73 -3.61a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m-3.14 -2.5a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m-3.9 -.89a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m-3.9 .89a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m-3.14 2.5a1 1 0 0 1 1 1a1 1 0 1 1 -2 .01c0 -.562 .448 -1.01 1 -1.01m-1.73 3.61a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m0 4a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m1.73 3.61a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m3.14 2.5a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m3.9 .89a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1\" />"),
    MACRO(
        "macro",
        "<path d=\"M17.994 2.888l.006 .112v3a6 6 0 0 1 -5 5.916v4.186a6.98 6.98 0 0 1 5 -2.102a1 1 0 0 1 1 1a7 7 0 0 1 -14 0a1 1 0 0 1 1 -1c1.96 0 3.731 .805 5.002 2.103l-.002 -4.186a6 6 0 0 1 -5 -5.917v-3a1 1 0 0 1 1.555 -.832l2.317 1.544l1.42 -1.42a1 1 0 0 1 1.32 -.082l.095 .083l1.42 1.419l2.318 -1.544a1 1 0 0 1 1.55 .72m-10.865 13.24l.03 .134a5.01 5.01 0 0 0 3.71 3.61a5 5 0 0 0 -3.74 -3.744m9.742 .002l-.134 .03a5.01 5.01 0 0 0 -3.61 3.71a5 5 0 0 0 3.744 -3.74\" />"),
    PANORAMA_HORIZONTAL(
        "panorama-horizontal",
        "<path d=\"M19.31 4.591a2 2 0 0 1 2.69 1.873v11c0 1.382 -1.38 2.38 -2.694 1.897c-4.879 -1.845 -9.734 -1.845 -14.612 0c-1.304 .495 -2.694 -.481 -2.694 -1.871v-11.032a2 2 0 0 1 2.676 -1.87l.025 .012l.448 .162c4.572 1.623 9.123 1.622 13.703 -.003z\" />"),
    PANORAMA_VERTICAL(
        "panorama-vertical",
        "<path d=\"M17.53 2c1.39 0 2.364 1.389 1.87 2.692l-.013 .026l-.156 .431c-1.623 4.572 -1.622 9.123 .003 13.703l.168 .458a2 2 0 0 1 -1.873 2.69h-11c-1.386 0 -2.394 -1.386 -1.897 -2.694c1.845 -4.879 1.845 -9.734 0 -14.612c-.495 -1.304 .48 -2.694 1.87 -2.694z\" />"),
    POLAROID(
        "polaroid",
        "<path d=\"M9.199 9.623l.108 .098l3.986 3.986l.094 .083a1 1 0 0 0 1.403 -1.403l-.083 -.094l-.292 -.293l1.292 -1.293l.106 -.095c.457 -.38 .918 -.38 1.386 .011l.108 .098l4.502 4.503a4.003 4.003 0 0 1 -3.596 2.77l-.213 .006h-12a4.002 4.002 0 0 1 -3.809 -2.775l5.516 -5.518l.106 -.095c.457 -.38 .918 -.38 1.386 .011zm8.801 -7.623a4 4 0 0 1 3.995 3.8l.005 .2v6.585l-3.293 -3.292l-.15 -.137c-1.256 -1.095 -2.85 -1.097 -4.096 -.017l-.154 .14l-1.307 1.306l-2.293 -2.292l-.15 -.137c-1.256 -1.095 -2.85 -1.097 -4.096 -.017l-.154 .14l-4.307 4.306v-6.585a4 4 0 0 1 3.8 -3.995l.2 -.005h12zm-2.99 3l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />\n  <path d=\"M8.01 20a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M12.01 20a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />\n  <path d=\"M16.01 20a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993l.127 -.007z\" />"),
    TILT_SHIFT(
        "tilt-shift",
        "<path d=\"M8.178 2.766a1 1 0 1 1 .764 1.848a8 8 0 0 0 -2.595 1.733a1 1 0 1 1 -1.414 -1.414a10 10 0 0 1 3.245 -2.167\" />\n  <path d=\"M2.767 8.176a1 1 0 1 1 1.846 .768a8 8 0 0 0 -.613 3.058a1 1 0 0 1 -2 -.004a10 10 0 0 1 .767 -3.822\" />\n  <path d=\"M3.308 14.516a1 1 0 0 1 1.306 .542a8 8 0 0 0 1.733 2.595a1 1 0 1 1 -1.414 1.414a10 10 0 0 1 -2.167 -3.245a1 1 0 0 1 .542 -1.306\" />\n  <path d=\"M7.637 19.926a1 1 0 0 1 1.307 -.54a8 8 0 0 0 3.058 .614a1 1 0 0 1 -.004 2a10 10 0 0 1 -3.822 -.767a1 1 0 0 1 -.54 -1.307\" />\n  <path d=\"M17.653 17.653a1 1 0 1 1 1.414 1.414a10 10 0 0 1 -3.245 2.167a1 1 0 1 1 -.764 -1.848a8 8 0 0 0 2.595 -1.733\" />\n  <path d=\"M21.002 11a1 1 0 0 1 .998 1.002a10 10 0 0 1 -.767 3.822a1 1 0 1 1 -1.846 -.768a8 8 0 0 0 .613 -3.058a1 1 0 0 1 1.002 -.998\" />\n  <path d=\"M17.653 4.933a1 1 0 0 1 1.414 0a10 10 0 0 1 2.167 3.245a1 1 0 1 1 -1.848 .764a8 8 0 0 0 -1.733 -2.595a1 1 0 0 1 0 -1.414\" />\n  <path d=\"M12.002 2a10 10 0 0 1 3.822 .767a1 1 0 1 1 -.768 1.846a8 8 0 0 0 -3.058 -.613a1 1 0 0 1 .004 -2\" />\n  <path d=\"M12 9a3 3 0 1 1 -3 3l.005 -.176a3 3 0 0 1 2.995 -2.824\" />");

    private final String catalogName;
    private final String svg;

    FilledIcon(String catalogName, String svg) {
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
      return "filled";
    }
  }

  default TablerIcon aperture() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.APERTURE);
  }

  default TablerIcon aperture_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.APERTURE_OFF);
  }

  default TablerIcon brightness() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS);
  }

  default TablerIcon brightness_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_2);
  }

  default TablerIcon brightness_auto() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_AUTO);
  }

  default TablerIcon brightness_down() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_DOWN);
  }

  default TablerIcon brightness_half() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_HALF);
  }

  default TablerIcon brightness_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_OFF);
  }

  default TablerIcon brightness_up() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.BRIGHTNESS_UP);
  }

  default TablerIcon camera_rotate() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CAMERA_ROTATE);
  }

  default TablerIcon camera_selfie() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CAMERA_SELFIE);
  }

  default TablerIcon contrast() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CONTRAST);
  }

  default TablerIcon contrast_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CONTRAST_2);
  }

  default TablerIcon contrast_2_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CONTRAST_2_OFF);
  }

  default TablerIcon contrast_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.CONTRAST_OFF);
  }

  default TablerIcon exposure() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE);
  }

  default TablerIcon exposure_0() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_0);
  }

  default TablerIcon exposure_minus_1() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_MINUS_1);
  }

  default TablerIcon exposure_minus_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_MINUS_2);
  }

  default TablerIcon exposure_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_OFF);
  }

  default TablerIcon exposure_plus_1() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_PLUS_1);
  }

  default TablerIcon exposure_plus_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.EXPOSURE_PLUS_2);
  }

  default TablerIcon focus() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.FOCUS);
  }

  default TablerIcon focus_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.FOCUS_2);
  }

  default TablerIcon focus_auto() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.FOCUS_AUTO);
  }

  default TablerIcon hdr() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.HDR);
  }

  default TablerIcon image_in_picture() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.IMAGE_IN_PICTURE);
  }

  default TablerIcon lens_concave() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.LENS_CONCAVE);
  }

  default TablerIcon lens_convex() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.LENS_CONVEX);
  }

  default TablerIcon live_photo() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.LIVE_PHOTO);
  }

  default TablerIcon live_photo_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.LIVE_PHOTO_OFF);
  }

  default TablerIcon macro() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.MACRO);
  }

  default TablerIcon macro_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.MACRO_OFF);
  }

  default TablerIcon panorama_horizontal() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PANORAMA_HORIZONTAL);
  }

  default TablerIcon panorama_horizontal_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PANORAMA_HORIZONTAL_OFF);
  }

  default TablerIcon panorama_vertical() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PANORAMA_VERTICAL);
  }

  default TablerIcon panorama_vertical_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PANORAMA_VERTICAL_OFF);
  }

  default TablerIcon photo_bitcoin() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_BITCOIN);
  }

  default TablerIcon photo_circle() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_CIRCLE);
  }

  default TablerIcon photo_hexagon() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_HEXAGON);
  }

  default TablerIcon photo_pentagon() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_PENTAGON);
  }

  default TablerIcon photo_sensor() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_SENSOR);
  }

  default TablerIcon photo_sensor_2() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_SENSOR_2);
  }

  default TablerIcon photo_sensor_3() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_SENSOR_3);
  }

  default TablerIcon photo_square_rounded() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_SQUARE_ROUNDED);
  }

  default TablerIcon photo_video() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.PHOTO_VIDEO);
  }

  default TablerIcon polaroid() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.POLAROID);
  }

  default TablerIcon screenshot() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.SCREENSHOT);
  }

  default TablerIcon shadow() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.SHADOW);
  }

  default TablerIcon shadow_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.SHADOW_OFF);
  }

  default TablerIcon tilt_shift() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.TILT_SHIFT);
  }

  default TablerIcon tilt_shift_off() {
    return TablerIcon.create(TablerPhotography.OutlineIcon.TILT_SHIFT_OFF);
  }

  default TablerIcon brightness_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.BRIGHTNESS);
  }

  default TablerIcon brightness_auto_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.BRIGHTNESS_AUTO);
  }

  default TablerIcon brightness_down_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.BRIGHTNESS_DOWN);
  }

  default TablerIcon brightness_up_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.BRIGHTNESS_UP);
  }

  default TablerIcon contrast_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.CONTRAST);
  }

  default TablerIcon contrast_2_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.CONTRAST_2);
  }

  default TablerIcon exposure_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.EXPOSURE);
  }

  default TablerIcon live_photo_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.LIVE_PHOTO);
  }

  default TablerIcon macro_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.MACRO);
  }

  default TablerIcon panorama_horizontal_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.PANORAMA_HORIZONTAL);
  }

  default TablerIcon panorama_vertical_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.PANORAMA_VERTICAL);
  }

  default TablerIcon polaroid_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.POLAROID);
  }

  default TablerIcon tilt_shift_filled() {
    return TablerIcon.create(TablerPhotography.FilledIcon.TILT_SHIFT);
  }
}
