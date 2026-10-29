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

/** Tabler Media catalog category. */
public interface TablerMedia {
  enum OutlineIcon implements TablerIconDefinition {
    ALBUM(
        "album",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M12 4v7l2 -2l2 2v-7\" />"),
    ALBUM_OFF(
        "album-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.581 3.41c-.362 .364 -.864 .59 -1.419 .59h-12a2 2 0 0 1 -2 -2v-12c0 -.552 .224 -1.052 .585 -1.413\" />\n  <path d=\"M12 4v4m1.503 1.497l.497 -.497l2 2v-7\" />\n  <path d=\"M3 3l18 18\" />"),
    ASPECT_RATIO(
        "aspect-ratio",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 12v-3h3\" />\n  <path d=\"M17 12v3h-3\" />"),
    ASPECT_RATIO_OFF(
        "aspect-ratio-off",
        "<path d=\"M9 5h10a2 2 0 0 1 2 2v10m-2 2h-14a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2\" />\n  <path d=\"M7 12v-3h2\" />\n  <path d=\"M17 12v1m-2 2h-1\" />\n  <path d=\"M3 3l18 18\" />"),
    CAMERA(
        "camera",
        "<path d=\"M5 7h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v9a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    CAMERA_AI(
        "camera-ai",
        "<path d=\"M10 20h-5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2\" />\n  <path d=\"M14.362 11.15a3 3 0 1 0 -4.144 4.263\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    CAMERA_BITCOIN(
        "camera-bitcoin",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v1\" />\n  <path d=\"M14.477 11.307a3 3 0 1 0 -2.477 4.693\" />\n  <path d=\"M17 21v-6\" />\n  <path d=\"M19 15v-1.5\" />\n  <path d=\"M19 22.5v-1.5\" />\n  <path d=\"M17 18h3\" />\n  <path d=\"M19 18h.5a1.5 1.5 0 0 1 0 3h-3.5\" />\n  <path d=\"M19 18h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />"),
    CAMERA_BOLT(
        "camera-bolt",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    CAMERA_CANCEL(
        "camera-cancel",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M14.984 13.307a3 3 0 1 0 -2.32 2.62\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    CAMERA_CHECK(
        "camera-check",
        "<path d=\"M11 20h-6a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v4\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    CAMERA_CODE(
        "camera-code",
        "<path d=\"M11 20h-6a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14.948 13.559a3 3 0 1 0 -2.58 2.419\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    CAMERA_COG(
        "camera-cog",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3\" />\n  <path d=\"M14.973 13.406a3 3 0 1 0 -2.973 2.594\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    CAMERA_DOLLAR(
        "camera-dollar",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v1.5\" />\n  <path d=\"M14.935 12.375a3.001 3.001 0 1 0 -1.902 3.442\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    CAMERA_DOWN(
        "camera-down",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    CAMERA_EXCLAMATION(
        "camera-exclamation",
        "<path d=\"M15 20h-10a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    CAMERA_HEART(
        "camera-heart",
        "<path d=\"M10.5 20h-5.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2\" />\n  <path d=\"M14.41 11.212a3 3 0 1 0 -4.15 4.231\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    CAMERA_MINUS(
        "camera-minus",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v6\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    CAMERA_MOON(
        "camera-moon",
        "<path d=\"M11.5 20h-6.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M14.815 11.96a3.001 3.001 0 1 0 -3.398 3.983\" />\n  <path d=\"M18.62 22c-2 0 -3.62 -1.58 -3.62 -3.53c0 -1.727 1.273 -3.165 2.954 -3.47a3.4 3.4 0 0 0 -.24 1.264c0 1.95 1.621 3.53 3.62 3.53q .342 0 .666 -.06c-.521 1.326 -1.838 2.266 -3.38 2.266\" />"),
    CAMERA_OFF(
        "camera-off",
        "<path d=\"M8.297 4.289a.997 .997 0 0 1 .703 -.289h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v8m-1.187 2.828c-.249 .11 -.524 .172 -.813 .172h-14a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1c.298 0 .58 -.065 .834 -.181\" />\n  <path d=\"M10.422 10.448a3 3 0 1 0 4.15 4.098\" />\n  <path d=\"M3 3l18 18\" />"),
    CAMERA_PAUSE(
        "camera-pause",
        "<path d=\"M13 20h-8a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14.958 13.506a3 3 0 1 0 -1.735 2.235\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    CAMERA_PIN(
        "camera-pin",
        "<path d=\"M12.5 20h-7.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2\" />\n  <path d=\"M14.933 12.366a3.001 3.001 0 1 0 -2.933 3.634\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    CAMERA_PLUS(
        "camera-plus",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />"),
    CAMERA_QUESTION(
        "camera-question",
        "<path d=\"M15 20h-10a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M14.975 12.612a3 3 0 1 0 -1.507 3.005\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    CAMERA_SEARCH(
        "camera-search",
        "<path d=\"M11.5 20h-6.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M14.757 11.815a3 3 0 1 0 -3.431 4.109\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    CAMERA_SHARE(
        "camera-share",
        "<path d=\"M12.5 20h-7.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14.98 13.347a3 3 0 1 0 -2.39 2.595\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    CAMERA_SPARK(
        "camera-spark",
        "<path d=\"M11.5 20h-6.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    CAMERA_STAR(
        "camera-star",
        "<path d=\"M10.5 20h-5.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v2.5\" />\n  <path d=\"M14.569 11.45a3 3 0 1 0 -4.518 3.83\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    CAMERA_UP(
        "camera-up",
        "<path d=\"M12 20h-7a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v3.5\" />\n  <path d=\"M12 16a3 3 0 1 0 0 -6a3 3 0 0 0 0 6\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    CAMERA_X(
        "camera-x",
        "<path d=\"M13.5 20h-8.5a2 2 0 0 1 -2 -2v-9a2 2 0 0 1 2 -2h1a2 2 0 0 0 2 -2a1 1 0 0 1 1 -1h6a1 1 0 0 1 1 1a2 2 0 0 0 2 2h1a2 2 0 0 1 2 2v4\" />\n  <path d=\"M9 13a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    CAPTURE(
        "capture",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />\n  <path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />"),
    CAPTURE_OFF(
        "capture-off",
        "<path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2c.554 0 1.055 -.225 1.417 -.589\" />\n  <path d=\"M9.87 9.887a3 3 0 0 0 4.255 4.23m.58 -3.416a3.012 3.012 0 0 0 -1.4 -1.403\" />\n  <path d=\"M4 8v-2c0 -.548 .22 -1.044 .577 -1.405\" />\n  <path d=\"M3 3l18 18\" />"),
    CAST(
        "cast",
        "<path d=\"M3 19l.01 0\" />\n  <path d=\"M7 19a4 4 0 0 0 -4 -4\" />\n  <path d=\"M11 19a8 8 0 0 0 -8 -8\" />\n  <path d=\"M15 19h3a3 3 0 0 0 3 -3v-8a3 3 0 0 0 -3 -3h-12a3 3 0 0 0 -2.8 2\" />"),
    CAST_OFF(
        "cast-off",
        "<path d=\"M3 19h.01\" />\n  <path d=\"M7 19a4 4 0 0 0 -4 -4\" />\n  <path d=\"M11 19a8 8 0 0 0 -8 -8\" />\n  <path d=\"M15 19h3a3 3 0 0 0 .875 -.13m2 -2a3 3 0 0 0 .128 -.868v-8a3 3 0 0 0 -3 -3h-9m-3.865 .136a3 3 0 0 0 -1.935 1.864\" />\n  <path d=\"M3 3l18 18\" />"),
    CIRCLE_PAUSE(
        "circle-pause",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 15v-6\" />\n  <path d=\"M14 15v-6\" />"),
    CIRCLE_PLAY(
        "circle-play",
        "<path d=\"M9 9.003a1 1 0 0 1 1.517 -.859l4.997 2.997a1 1 0 0 1 0 1.718l-4.997 2.997a1 1 0 0 1 -1.517 -.86v-5.993\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CIRCLE_STOP(
        "circle-stop",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-4\" />"),
    CLEF(
        "clef",
        "<path d=\"M16 12a4.16 4.16 0 0 1 -5.62 3.89a3.78 3.78 0 0 1 -2.38 -3.39a3.42 3.42 0 0 1 2.34 -3.38l3.79 -1.42a2.89 2.89 0 0 0 1.87 -2.7a2 2 0 1 0 -4 0v14a2 2 0 1 1 -4 0\" />"),
    CLEF_STAFF(
        "clef-staff",
        "<path d=\"M15 15h6\" />\n  <path d=\"M15 11h6\" />\n  <path d=\"M11 19h10\" />\n  <path d=\"M11 12a4.16 4.16 0 0 1 -5.62 3.89a3.78 3.78 0 0 1 -2.38 -3.39a3.42 3.42 0 0 1 2.34 -3.38l3.79 -1.42a2.89 2.89 0 0 0 1.87 -2.7a2 2 0 0 0 -2 -2a2 2 0 0 0 -2 2v14a2 2 0 0 1 -2 2a2 2 0 0 1 -2 -2\" />"),
    HEADPHONES(
        "headphones",
        "<path d=\"M4 15a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M15 15a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M4 15v-3a8 8 0 0 1 16 0v3\" />"),
    HEADPHONES_OFF(
        "headphones-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M4 15a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2l0 -3\" />\n  <path d=\"M17 13h1a2 2 0 0 1 2 2v1m-.589 3.417c-.361 .36 -.86 .583 -1.411 .583h-1a2 2 0 0 1 -2 -2v-3\" />\n  <path d=\"M4 15v-3c0 -2.21 .896 -4.21 2.344 -5.658m2.369 -1.638a8 8 0 0 1 11.287 7.296v3\" />"),
    HEADSET(
        "headset",
        "<path d=\"M4 14v-3a8 8 0 1 1 16 0v3\" />\n  <path d=\"M18 19c0 1.657 -2.686 3 -6 3\" />\n  <path d=\"M4 14a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2v-3\" />\n  <path d=\"M15 14a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2v-3\" />"),
    HEADSET_OFF(
        "headset-off",
        "<path d=\"M4 14v-3c0 -1.953 .7 -3.742 1.862 -5.13m2.182 -1.825a8 8 0 0 1 11.956 6.955v3\" />\n  <path d=\"M18 19c0 1.657 -2.686 3 -6 3\" />\n  <path d=\"M4 14a2 2 0 0 1 2 -2h1a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-1a2 2 0 0 1 -2 -2v-3\" />\n  <path d=\"M16.169 12.18c.253 -.115 .534 -.18 .831 -.18h1a2 2 0 0 1 2 2v2m-1.183 2.826c-.25 .112 -.526 .174 -.817 .174h-1a2 2 0 0 1 -2 -2v-2\" />\n  <path d=\"M3 3l18 18\" />"),
    KEYFRAME(
        "keyframe",
        "<path d=\"M13.225 18.412a1.595 1.595 0 0 1 -1.225 .588c-.468 0 -.914 -.214 -1.225 -.588l-4.361 -5.248a1.844 1.844 0 0 1 0 -2.328l4.361 -5.248a1.595 1.595 0 0 1 1.225 -.588c.468 0 .914 .214 1.225 .588l4.361 5.248a1.844 1.844 0 0 1 0 2.328l-4.361 5.248\" />"),
    KEYFRAME_ALIGN_CENTER(
        "keyframe-align-center",
        "<path d=\"M12 20v2\" />\n  <path d=\"M12.816 16.58c-.207 .267 -.504 .42 -.816 .42c-.312 0 -.61 -.153 -.816 -.42l-2.908 -3.748a1.39 1.39 0 0 1 0 -1.664l2.908 -3.748c.207 -.267 .504 -.42 .816 -.42c.312 0 .61 .153 .816 .42l2.908 3.748a1.39 1.39 0 0 1 0 1.664l-2.908 3.748\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M3 12h2\" />\n  <path d=\"M19 12h2\" />"),
    KEYFRAME_ALIGN_HORIZONTAL(
        "keyframe-align-horizontal",
        "<path d=\"M12.816 16.58c-.207 .267 -.504 .42 -.816 .42c-.312 0 -.61 -.153 -.816 -.42l-2.908 -3.748a1.39 1.39 0 0 1 0 -1.664l2.908 -3.748c.207 -.267 .504 -.42 .816 -.42c.312 0 .61 .153 .816 .42l2.908 3.748a1.39 1.39 0 0 1 0 1.664l-2.908 3.748\" />\n  <path d=\"M3 12h2\" />\n  <path d=\"M19 12h2\" />"),
    KEYFRAME_ALIGN_VERTICAL(
        "keyframe-align-vertical",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12.816 16.58c-.207 .267 -.504 .42 -.816 .42c-.312 0 -.61 -.153 -.816 -.42l-2.908 -3.748a1.39 1.39 0 0 1 0 -1.664l2.908 -3.748c.207 -.267 .504 -.42 .816 -.42c.312 0 .61 .153 .816 .42l2.908 3.748a1.39 1.39 0 0 1 0 1.664l-2.908 3.748\" />\n  <path d=\"M12 20v2\" />"),
    KEYFRAMES(
        "keyframes",
        "<path d=\"M9.225 18.412a1.595 1.595 0 0 1 -1.225 .588c-.468 0 -.914 -.214 -1.225 -.588l-4.361 -5.248a1.844 1.844 0 0 1 0 -2.328l4.361 -5.248a1.595 1.595 0 0 1 1.225 -.588c.468 0 .914 .214 1.225 .588l4.361 5.248a1.844 1.844 0 0 1 0 2.328l-4.361 5.248\" />\n  <path d=\"M17 5l4.586 5.836a1.844 1.844 0 0 1 0 2.328l-4.586 5.836\" />\n  <path d=\"M13 5l4.586 5.836a1.844 1.844 0 0 1 0 2.328l-4.586 5.836\" />"),
    MAXIMIZE(
        "maximize",
        "<path d=\"M4 8v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2a2 2 0 0 0 2 -2v-2\" />"),
    MAXIMIZE_OFF(
        "maximize-off",
        "<path d=\"M4 8v-2c0 -.551 .223 -1.05 .584 -1.412\" />\n  <path d=\"M4 16v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M16 4h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M16 20h2c.545 0 1.04 -.218 1.4 -.572\" />\n  <path d=\"M3 3l18 18\" />"),
    MICROPHONE(
        "microphone",
        "<path d=\"M9 5a3 3 0 0 1 3 -3a3 3 0 0 1 3 3v5a3 3 0 0 1 -3 3a3 3 0 0 1 -3 -3l0 -5\" />\n  <path d=\"M5 10a7 7 0 0 0 14 0\" />\n  <path d=\"M8 21l8 0\" />\n  <path d=\"M12 17l0 4\" />"),
    MICROPHONE_2(
        "microphone-2",
        "<path d=\"M15 12.9a5 5 0 1 0 -3.902 -3.9\" />\n  <path d=\"M15 12.9l-3.902 -3.899l-7.513 8.584a2 2 0 1 0 2.827 2.83l8.588 -7.515\" />"),
    MICROPHONE_2_OFF(
        "microphone-2-off",
        "<path d=\"M16.908 12.917a5 5 0 1 0 -5.827 -5.819\" />\n  <path d=\"M10.116 10.125l-6.529 7.46a2 2 0 1 0 2.827 2.83l7.461 -6.529\" />\n  <path d=\"M3 3l18 18\" />"),
    MICROPHONE_OFF(
        "microphone-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M9 5a3 3 0 0 1 6 0v5a3 3 0 0 1 -.13 .874m-2 2a3 3 0 0 1 -3.87 -2.872v-1\" />\n  <path d=\"M5 10a7 7 0 0 0 10.846 5.85m2 -2a6.967 6.967 0 0 0 1.152 -3.85\" />\n  <path d=\"M8 21l8 0\" />\n  <path d=\"M12 17l0 4\" />"),
    MINIMIZE(
        "minimize",
        "<path d=\"M15 19v-2a2 2 0 0 1 2 -2h2\" />\n  <path d=\"M15 5v2a2 2 0 0 0 2 2h2\" />\n  <path d=\"M5 15h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M5 9h2a2 2 0 0 0 2 -2v-2\" />"),
    MOVIE(
        "movie",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M8 4l0 16\" />\n  <path d=\"M16 4l0 16\" />\n  <path d=\"M4 8l4 0\" />\n  <path d=\"M4 16l4 0\" />\n  <path d=\"M4 12l16 0\" />\n  <path d=\"M16 8l4 0\" />\n  <path d=\"M16 16l4 0\" />"),
    MOVIE_OFF(
        "movie-off",
        "<path d=\"M8 4h10a2 2 0 0 1 2 2v10m-.592 3.42c-.362 .359 -.859 .58 -1.408 .58h-12a2 2 0 0 1 -2 -2v-12c0 -.539 .213 -1.028 .56 -1.388\" />\n  <path d=\"M8 8v12\" />\n  <path d=\"M16 4v8m0 4v4\" />\n  <path d=\"M4 8h4\" />\n  <path d=\"M4 16h4\" />\n  <path d=\"M4 12h8m4 0h4\" />\n  <path d=\"M16 8h4\" />\n  <path d=\"M3 3l18 18\" />"),
    MUSIC(
        "music",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M13 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v13\" />\n  <path d=\"M9 8h10\" />"),
    MUSIC_BOLT(
        "music-bolt",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    MUSIC_CANCEL(
        "music-cancel",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    MUSIC_CHECK(
        "music-check",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9.5\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    MUSIC_CODE(
        "music-code",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    MUSIC_COG(
        "music-cog",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v7.5\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    MUSIC_DOLLAR(
        "music-dollar",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v6\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    MUSIC_DOWN(
        "music-down",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    MUSIC_EXCLAMATION(
        "music-exclamation",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    MUSIC_HEART(
        "music-heart",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v7\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    MUSIC_MINUS(
        "music-minus",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v11\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M16 19h6\" />"),
    MUSIC_OFF(
        "music-off",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14.42 14.45a3 3 0 1 0 4.138 4.119\" />\n  <path d=\"M9 17v-8m0 -4v-1h10v11\" />\n  <path d=\"M12 8h7\" />\n  <path d=\"M3 3l18 18\" />"),
    MUSIC_PAUSE(
        "music-pause",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    MUSIC_PIN(
        "music-pin",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v7\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    MUSIC_PLUS(
        "music-plus",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    MUSIC_QUESTION(
        "music-question",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v7\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    MUSIC_SEARCH(
        "music-search",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v7\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    MUSIC_SHARE(
        "music-share",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    MUSIC_STAR(
        "music-star",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v6\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    MUSIC_UP(
        "music-up",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v8\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    MUSIC_X(
        "music-x",
        "<path d=\"M3 17a3 3 0 1 0 6 0a3 3 0 0 0 -6 0\" />\n  <path d=\"M9 17v-13h10v9\" />\n  <path d=\"M9 8h10\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    PHOTO(
        "photo",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l3 3\" />"),
    PHOTO_AI(
        "photo-ai",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M10 21h-4a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l1 1\" />\n  <path d=\"M14 21v-4a2 2 0 1 1 4 0v4\" />\n  <path d=\"M14 19h4\" />\n  <path d=\"M21 15v6\" />"),
    PHOTO_ALT(
        "photo-alt",
        "<path d=\"M6 18h5\" />\n  <path d=\"M14 18h4\" />\n  <path d=\"M15 7h.01\" />\n  <path d=\"M3 6a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v12a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-12\" />\n  <path d=\"M3 15l5 -5c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M14 13l1 -1c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M3 15h18\" />"),
    PHOTO_BOLT(
        "photo-bolt",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M13.5 21h-7.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.669 -.643 1.45 -.823 2.18 -.54\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    PHOTO_CANCEL(
        "photo-cancel",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.616 -.593 1.328 -.792 2.008 -.598\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    PHOTO_CHECK(
        "photo-check",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11.5 21h-5.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v7\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l.5 .5\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    PHOTO_CIRCLE_MINUS(
        "photo-circle-minus",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M20.475 15.035a9 9 0 0 0 -8.475 -12.035a9 9 0 0 0 -9 9a9 9 0 0 0 9.525 8.985\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2 2\" />\n  <path d=\"M16 19h6\" />"),
    PHOTO_CIRCLE_PLUS(
        "photo-circle-plus",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M20.964 12.806a9 9 0 0 0 -8.964 -9.806a9 9 0 0 0 -9 9a9 9 0 0 0 9.397 8.991\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0\" />\n  <path d=\"M16 19.33h6\" />\n  <path d=\"M19 16.33v6\" />"),
    PHOTO_CODE(
        "photo-code",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11.5 21h-5.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v7\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    PHOTO_COG(
        "photo-cog",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12 21h-6a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.48 -.461 1.016 -.684 1.551 -.67\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    PHOTO_DOLLAR(
        "photo-dollar",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M13 21h-7a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v4.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l2.5 2.5\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    PHOTO_DOWN(
        "photo-down",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.653 -.629 1.413 -.815 2.13 -.559\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    PHOTO_EDIT(
        "photo-edit",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11 20h-4a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v4\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.31 -.298 .644 -.497 .987 -.596\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    PHOTO_EXCLAMATION(
        "photo-exclamation",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M15 21h-9a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.665 -.64 1.44 -.821 2.167 -.545\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    PHOTO_HEART(
        "photo-heart",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11.5 21h-5.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l1.5 1.5\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    PHOTO_MINUS(
        "photo-minus",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v9\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0l2 2\" />\n  <path d=\"M16 19h6\" />"),
    PHOTO_OFF(
        "photo-off",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M7 3h11a3 3 0 0 1 3 3v11m-.856 3.099a2.991 2.991 0 0 1 -2.144 .901h-12a3 3 0 0 1 -3 -3v-12c0 -.845 .349 -1.608 .91 -2.153\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l5 5\" />\n  <path d=\"M16.33 12.338c.574 -.054 1.155 .166 1.67 .662l3 3\" />\n  <path d=\"M3 3l18 18\" />"),
    PHOTO_PAUSE(
        "photo-pause",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M13 21h-7a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v7\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    PHOTO_PIN(
        "photo-pin",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l2.5 2.5\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    PHOTO_PLUS(
        "photo-plus",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l4 4\" />\n  <path d=\"M14 14l1 -1c.67 -.644 1.45 -.824 2.182 -.54\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    PHOTO_QUESTION(
        "photo-question",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M15 21h-9a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    PHOTO_SEARCH(
        "photo-search",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11.5 21h-5.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5.5\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l2 2\" />"),
    PHOTO_SHARE(
        "photo-share",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12 21h-6a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v7\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    PHOTO_SHIELD(
        "photo-shield",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11.5 20h-4.5a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3h10a3 3 0 0 1 3 3v4\" />\n  <path d=\"M4 15l4 -4c.928 -.893 2.072 -.893 3 0l1.5 1.5\" />\n  <path d=\"M22 16c0 4 -2.5 6 -3.5 6s-3.5 -2 -3.5 -6c1 0 2.5 -.5 3.5 -1.5c1 1 2.5 1.5 3.5 1.5\" />"),
    PHOTO_SPARK(
        "photo-spark",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12 21h-6a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3.993 3.993\" />\n  <path d=\"M14 14l1 -1c.47 -.452 .995 -.675 1.52 -.67\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    PHOTO_STAR(
        "photo-star",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M11 21h-5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v5.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l2 2\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    PHOTO_UP(
        "photo-up",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M12.5 21h-6.5a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v6.5\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3.5 3.5\" />\n  <path d=\"M14 14l1 -1c.679 -.653 1.473 -.829 2.214 -.526\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    PHOTO_X(
        "photo-x",
        "<path d=\"M15 8h.01\" />\n  <path d=\"M13 21h-7a3 3 0 0 1 -3 -3v-12a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v7\" />\n  <path d=\"M3 16l5 -5c.928 -.893 2.072 -.893 3 0l3 3\" />\n  <path d=\"M14 14l1 -1c.928 -.893 2.072 -.893 3 0\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    PICTURE_IN_PICTURE(
        "picture-in-picture",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14 15a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1l0 -3\" />"),
    PICTURE_IN_PICTURE_OFF(
        "picture-in-picture-off",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14 15a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M7 9l4 4\" />\n  <path d=\"M7 12v-3h3\" />"),
    PICTURE_IN_PICTURE_ON(
        "picture-in-picture-on",
        "<path d=\"M11 19h-6a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v4\" />\n  <path d=\"M14 15a1 1 0 0 1 1 -1h5a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-5a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M7 9l4 4\" />\n  <path d=\"M8 13h3v-3\" />"),
    PICTURE_IN_PICTURE_TOP(
        "picture-in-picture-top",
        "<path d=\"M11 5h-6a2 2 0 0 0 -2 2v10a2 2 0 0 0 2 2h14a2 2 0 0 0 2 -2v-4\" />\n  <path d=\"M15 10h5a1 1 0 0 0 1 -1v-3a1 1 0 0 0 -1 -1h-5a1 1 0 0 0 -1 1v3a1 1 0 0 0 1 1\" />"),
    PLAYER_EJECT(
        "player-eject",
        "<path d=\"M5 12h14l-7 -8l-7 8\" />\n  <path d=\"M5 17a1 1 0 0 1 1 -1h12a1 1 0 0 1 1 1v2a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1l0 -2\" />"),
    PLAYER_PAUSE(
        "player-pause",
        "<path d=\"M6 6a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -12\" />\n  <path d=\"M14 6a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v12a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -12\" />"),
    PLAYER_PLAY("player-play", "<path d=\"M7 4v16l13 -8l-13 -8\" />"),
    PLAYER_RECORD("player-record", "<path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />"),
    PLAYER_SKIP_BACK(
        "player-skip-back", "<path d=\"M20 5v14l-12 -7l12 -7\" />\n  <path d=\"M4 5l0 14\" />"),
    PLAYER_SKIP_FORWARD(
        "player-skip-forward", "<path d=\"M4 5v14l12 -7l-12 -7\" />\n  <path d=\"M20 5l0 14\" />"),
    PLAYER_STOP(
        "player-stop",
        "<path d=\"M5 7a2 2 0 0 1 2 -2h10a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-10a2 2 0 0 1 -2 -2l0 -10\" />"),
    PLAYER_TRACK_NEXT(
        "player-track-next",
        "<path d=\"M3 5v14l8 -7l-8 -7\" />\n  <path d=\"M14 5v14l8 -7l-8 -7\" />"),
    PLAYER_TRACK_PREV(
        "player-track-prev",
        "<path d=\"M21 5v14l-8 -7l8 -7\" />\n  <path d=\"M10 5v14l-8 -7l8 -7\" />"),
    PLAYLIST(
        "playlist",
        "<path d=\"M11 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 17v-13h4\" />\n  <path d=\"M13 5h-10\" />\n  <path d=\"M3 9l10 0\" />\n  <path d=\"M9 13h-6\" />"),
    PLAYLIST_OFF(
        "playlist-off",
        "<path d=\"M14 14a3 3 0 1 0 3 3\" />\n  <path d=\"M17 13v-9h4\" />\n  <path d=\"M13 5h-4m-4 0h-2\" />\n  <path d=\"M3 9h6\" />\n  <path d=\"M9 13h-6\" />\n  <path d=\"M3 3l18 18\" />"),
    PLAYLIST_X(
        "playlist-x",
        "<path d=\"M19 8h-14\" />\n  <path d=\"M5 12h7\" />\n  <path d=\"M12 16h-7\" />\n  <path d=\"M16 14l4 4\" />\n  <path d=\"M20 14l-4 4\" />"),
    RADIO(
        "radio",
        "<path d=\"M14 3l-9.371 3.749a1 1 0 0 0 -.629 .928v11.323a1 1 0 0 0 1 1h14a1 1 0 0 0 1 -1v-11a1 1 0 0 0 -1 -1h-14.5\" />\n  <path d=\"M4 12h16\" />\n  <path d=\"M7 12v-2\" />\n  <path d=\"M17 16v.01\" />\n  <path d=\"M13 16v.01\" />"),
    RADIO_OFF(
        "radio-off",
        "<path d=\"M14 3l-4.986 2m-2.875 1.15l-1.51 .604a1 1 0 0 0 -.629 .928v11.323a1 1 0 0 0 1 1h14a1 1 0 0 0 .708 -.294m.292 -3.706v-8a1 1 0 0 0 -1 -1h-8m-4 0h-2.5\" />\n  <path d=\"M4 12h8m4 0h4\" />\n  <path d=\"M7 12v-2\" />\n  <path d=\"M13 16v.01\" />\n  <path d=\"M3 3l18 18\" />"),
    REPEAT(
        "repeat",
        "<path d=\"M4 12v-3a3 3 0 0 1 3 -3h13m-3 -3l3 3l-3 3\" />\n  <path d=\"M20 12v3a3 3 0 0 1 -3 3h-13m3 3l-3 -3l3 -3\" />"),
    REPEAT_OFF(
        "repeat-off",
        "<path d=\"M4 12v-3c0 -1.336 .873 -2.468 2.08 -2.856m3.92 -.144h10m-3 -3l3 3l-3 3\" />\n  <path d=\"M20 12v3a3 3 0 0 1 -.133 .886m-1.99 1.984a3 3 0 0 1 -.877 .13h-13m3 3l-3 -3l3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    REPEAT_ONCE(
        "repeat-once",
        "<path d=\"M4 12v-3a3 3 0 0 1 3 -3h13m-3 -3l3 3l-3 3\" />\n  <path d=\"M20 12v3a3 3 0 0 1 -3 3h-13m3 3l-3 -3l3 -3\" />\n  <path d=\"M11 11l1 -1v4\" />"),
    REWIND_BACKWARD_10(
        "rewind-backward-10",
        "<path d=\"M7 9l-3 -3l3 -3\" />\n  <path d=\"M15.997 17.918a6.002 6.002 0 0 0 -.997 -11.918h-11\" />\n  <path d=\"M6 14v6\" />\n  <path d=\"M9 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />"),
    REWIND_BACKWARD_15(
        "rewind-backward-15",
        "<path d=\"M8 20h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M15 18a6 6 0 1 0 0 -12h-11\" />\n  <path d=\"M5 14v6\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />"),
    REWIND_BACKWARD_20(
        "rewind-backward-20",
        "<path d=\"M19.007 16.466a6 6 0 0 0 -4.007 -10.466h-11\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />\n  <path d=\"M12 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M6 14h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />"),
    REWIND_BACKWARD_30(
        "rewind-backward-30",
        "<path d=\"M19.007 16.466a6 6 0 0 0 -4.007 -10.466h-11\" />\n  <path d=\"M12 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M6 14h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />"),
    REWIND_BACKWARD_40(
        "rewind-backward-40",
        "<path d=\"M19.007 16.466a6 6 0 0 0 -4.007 -10.466h-11\" />\n  <path d=\"M12 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M6 14v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M9 14v6\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />"),
    REWIND_BACKWARD_5(
        "rewind-backward-5",
        "<path d=\"M15 18a6 6 0 1 0 0 -12h-11\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />\n  <path d=\"M8 20h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />"),
    REWIND_BACKWARD_50(
        "rewind-backward-50",
        "<path d=\"M19.007 16.466a6 6 0 0 0 -4.007 -10.466h-11\" />\n  <path d=\"M12 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M6 20h1.5a1.5 1.5 0 0 0 0 -3h-1.5v-3h3\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />"),
    REWIND_BACKWARD_60(
        "rewind-backward-60",
        "<path d=\"M19.007 16.466a6 6 0 0 0 -4.007 -10.466h-11\" />\n  <path d=\"M7 9l-3 -3l3 -3\" />\n  <path d=\"M12 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M9 14h-2a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2\" />"),
    REWIND_FORWARD_10(
        "rewind-forward-10",
        "<path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M8 17.918a5.997 5.997 0 0 1 -5 -5.918a6 6 0 0 1 6 -6h11\" />\n  <path d=\"M12 14v6\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />"),
    REWIND_FORWARD_15(
        "rewind-forward-15",
        "<path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M9 18a6 6 0 1 1 0 -12h11\" />\n  <path d=\"M16 20h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M13 14v6\" />"),
    REWIND_FORWARD_20(
        "rewind-forward-20",
        "<path d=\"M5.007 16.478a6 6 0 0 1 3.993 -10.478h11\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M9 14h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />"),
    REWIND_FORWARD_30(
        "rewind-forward-30",
        "<path d=\"M5.007 16.478a6 6 0 0 1 3.993 -10.478h11\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M9 14h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />"),
    REWIND_FORWARD_40(
        "rewind-forward-40",
        "<path d=\"M5.007 16.478a6 6 0 0 1 3.993 -10.478h11\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M9 14v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M12 14v6\" />"),
    REWIND_FORWARD_5(
        "rewind-forward-5",
        "<path d=\"M9 18a6 6 0 1 1 0 -12h11\" />\n  <path d=\"M13 20h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />"),
    REWIND_FORWARD_50(
        "rewind-forward-50",
        "<path d=\"M5.007 16.478a6 6 0 0 1 3.993 -10.478h11\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M9 20h1.5a1.5 1.5 0 0 0 0 -3h-1.5v-3h3\" />"),
    REWIND_FORWARD_60(
        "rewind-forward-60",
        "<path d=\"M5.007 16.478a6 6 0 0 1 3.993 -10.478h11\" />\n  <path d=\"M15 15.5v3a1.5 1.5 0 0 0 3 0v-3a1.5 1.5 0 0 0 -3 0\" />\n  <path d=\"M17 9l3 -3l-3 -3\" />\n  <path d=\"M12 14h-2a1 1 0 0 0 -1 1v4a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2\" />"),
    SHAREPLAY(
        "shareplay",
        "<path d=\"M18 18a3 3 0 0 0 3 -3v-8a3 3 0 0 0 -3 -3h-12a3 3 0 0 0 -3 3v8a3 3 0 0 0 3 3\" />\n  <path d=\"M9 20h6l-3 -5l-3 5\" />"),
    SPEAKERPHONE(
        "speakerphone",
        "<path d=\"M18 8a3 3 0 0 1 0 6\" />\n  <path d=\"M10 8v11a1 1 0 0 1 -1 1h-1a1 1 0 0 1 -1 -1v-5\" />\n  <path d=\"M12 8l4.524 -3.77a.9 .9 0 0 1 1.476 .692v12.156a.9 .9 0 0 1 -1.476 .692l-4.524 -3.77h-8a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h8\" />"),
    SUBTITLES(
        "subtitles",
        "<path d=\"M18 5a3 3 0 0 1 3 3v8a3 3 0 0 1 -3 3h-12a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3l12 0\" />\n  <path d=\"M7 15h5\" />\n  <path d=\"M15 15h2\" />\n  <path d=\"M17 12h-3\" />\n  <path d=\"M11 12h-1\" />"),
    SUBTITLES_AI(
        "subtitles-ai",
        "<path d=\"M11.5 19h-5.5a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v4\" />\n  <path d=\"M7 15h5\" />\n  <path d=\"M17 12h-3\" />\n  <path d=\"M11 12h-1\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    SUBTITLES_EDIT(
        "subtitles-edit",
        "<path d=\"M11.5 19h-5.5a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3h12a3 3 0 0 1 3 3v3\" />\n  <path d=\"M7 15h5\" />\n  <path d=\"M17 12h-3\" />\n  <path d=\"M11 12h-1\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    SUBTITLES_OFF(
        "subtitles-off",
        "<path d=\"M9 5h9a3 3 0 0 1 3 3v8a3 3 0 0 1 -.13 .874m-2.006 2a3 3 0 0 1 -.864 .126h-12a3 3 0 0 1 -3 -3v-8c0 -1.35 .893 -2.493 2.12 -2.869\" />\n  <path d=\"M7 15h5\" />\n  <path d=\"M17 12h-1\" />\n  <path d=\"M12 12h-2\" />\n  <path d=\"M3 3l18 18\" />"),
    USER_SCREEN(
        "user-screen",
        "<path d=\"M19.03 17.818a3 3 0 0 0 1.97 -2.818v-8a3 3 0 0 0 -3 -3h-12a3 3 0 0 0 -3 3v8c0 1.317 .85 2.436 2.03 2.84\" />\n  <path d=\"M10 14a2 2 0 1 0 4 0a2 2 0 0 0 -4 0\" />\n  <path d=\"M8 21a2 2 0 0 1 2 -2h4a2 2 0 0 1 2 2\" />"),
    VIDEO(
        "video",
        "<path d=\"M15 10l4.553 -2.276a1 1 0 0 1 1.447 .894v6.764a1 1 0 0 1 -1.447 .894l-4.553 -2.276v-4\" />\n  <path d=\"M3 8a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />"),
    VIDEO_MINUS(
        "video-minus",
        "<path d=\"M15 10l4.553 -2.276a1 1 0 0 1 1.447 .894v6.764a1 1 0 0 1 -1.447 .894l-4.553 -2.276v-4\" />\n  <path d=\"M3 8a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M7 12l4 0\" />"),
    VIDEO_OFF(
        "video-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M15 11v-1l4.553 -2.276a1 1 0 0 1 1.447 .894v6.764a1 1 0 0 1 -.675 .946\" />\n  <path d=\"M10 6h3a2 2 0 0 1 2 2v3m0 4v1a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2v-8a2 2 0 0 1 2 -2h1\" />"),
    VIDEO_PLUS(
        "video-plus",
        "<path d=\"M15 10l4.553 -2.276a1 1 0 0 1 1.447 .894v6.764a1 1 0 0 1 -1.447 .894l-4.553 -2.276v-4\" />\n  <path d=\"M3 8a2 2 0 0 1 2 -2h8a2 2 0 0 1 2 2v8a2 2 0 0 1 -2 2h-8a2 2 0 0 1 -2 -2l0 -8\" />\n  <path d=\"M7 12l4 0\" />\n  <path d=\"M9 10l0 4\" />"),
    VOICE(
        "voice",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M3 12c4 0 9.647 8.23 14.4 7.092\" />\n  <path d=\"M4.8 17.4c5.85 0 9.617 -7.2 15.3 -7.2\" />"),
    VOICE_2(
        "voice-2",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M3.429 14.571c9 -15.857 10.134 8.908 17.143 0\" />\n  <path d=\"M4.03 16.286c5.469 -3.939 8.68 3.635 13.541 2.79\" />"),
    VOLUME(
        "volume",
        "<path d=\"M15 8a5 5 0 0 1 0 8\" />\n  <path d=\"M17.7 5a9 9 0 0 1 0 14\" />\n  <path d=\"M6 15h-2a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h2l3.5 -4.5a.8 .8 0 0 1 1.5 .5v14a.8 .8 0 0 1 -1.5 .5l-3.5 -4.5\" />"),
    VOLUME_2(
        "volume-2",
        "<path d=\"M15 8a5 5 0 0 1 0 8\" />\n  <path d=\"M6 15h-2a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h2l3.5 -4.5a.8 .8 0 0 1 1.5 .5v14a.8 .8 0 0 1 -1.5 .5l-3.5 -4.5\" />"),
    VOLUME_3(
        "volume-3",
        "<path d=\"M6 15h-2a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h2l3.5 -4.5a.8 .8 0 0 1 1.5 .5v14a.8 .8 0 0 1 -1.5 .5l-3.5 -4.5\" />\n  <path d=\"M16 10l4 4m0 -4l-4 4\" />"),
    VOLUME_4(
        "volume-4",
        "<path d=\"M9.5 15h-2a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h2l3.5 -4.5a.8 .8 0 0 1 1.5 .5v14a.8 .8 0 0 1 -1.5 .5l-3.5 -4.5\" />"),
    VOLUME_OFF(
        "volume-off",
        "<path d=\"M15 8a5 5 0 0 1 1.912 4.934m-1.377 2.602a5 5 0 0 1 -.535 .464\" />\n  <path d=\"M17.7 5a9 9 0 0 1 2.362 11.086m-1.676 2.299a9 9 0 0 1 -.686 .615\" />\n  <path d=\"M9.069 5.054l.431 -.554a.8 .8 0 0 1 1.5 .5v2m0 4v8a.8 .8 0 0 1 -1.5 .5l-3.5 -4.5h-2a1 1 0 0 1 -1 -1v-4a1 1 0 0 1 1 -1h2l1.294 -1.664\" />\n  <path d=\"M3 3l18 18\" />");

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
    ASPECT_RATIO(
        "aspect-ratio",
        "<path d=\"M19 4h-14a3 3 0 0 0 -3 3v10a3 3 0 0 0 3 3h14a3 3 0 0 0 3 -3v-10a3 3 0 0 0 -3 -3zm-10 3a1 1 0 0 1 .117 1.993l-.117 .007h-2v2a1 1 0 0 1 -.883 .993l-.117 .007a1 1 0 0 1 -.993 -.883l-.007 -.117v-3a1 1 0 0 1 .883 -.993l.117 -.007h3zm9 5a1 1 0 0 1 .993 .883l.007 .117v3a1 1 0 0 1 -.883 .993l-.117 .007h-3a1 1 0 0 1 -.117 -1.993l.117 -.007h2v-2a1 1 0 0 1 .883 -.993l.117 -.007z\" />"),
    CAMERA(
        "camera",
        "<path d=\"M15 3a2 2 0 0 1 1.995 1.85l.005 .15a1 1 0 0 0 .883 .993l.117 .007h1a3 3 0 0 1 2.995 2.824l.005 .176v9a3 3 0 0 1 -2.824 2.995l-.176 .005h-14a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-9a3 3 0 0 1 2.824 -2.995l.176 -.005h1a1 1 0 0 0 1 -1a2 2 0 0 1 1.85 -1.995l.15 -.005h6zm-3 7a3 3 0 0 0 -2.985 2.698l-.011 .152l-.004 .15l.004 .15a3 3 0 1 0 2.996 -3.15z\" />"),
    CAPTURE(
        "capture",
        "<path d=\"M8 3a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 0 -.993 .883l-.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a3 3 0 0 1 2.824 -2.995l.176 -.005h2z\" />\n  <path d=\"M4 15a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 0 .883 .993l.117 .007h2a1 1 0 0 1 .117 1.993l-.117 .007h-2a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 3a3 3 0 0 1 2.995 2.824l.005 .176v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 0 -.883 -.993l-.117 -.007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />\n  <path d=\"M20 15a1 1 0 0 1 .993 .883l.007 .117v2a3 3 0 0 1 -2.824 2.995l-.176 .005h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2a1 1 0 0 0 .993 -.883l.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 8a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />"),
    HEADPHONES(
        "headphones",
        "<path d=\"M21 18a3 3 0 0 1 -2.824 2.995l-.176 .005h-1a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-3a3 3 0 0 1 2.824 -2.995l.176 -.005h1c.351 0 .688 .06 1 .171v-.171a7 7 0 0 0 -13.996 -.24l-.004 .24v.17c.25 -.088 .516 -.144 .791 -.163l.209 -.007h1a3 3 0 0 1 2.995 2.824l.005 .176v3a3 3 0 0 1 -2.824 2.995l-.176 .005h-1a3 3 0 0 1 -2.995 -2.824l-.005 -.176v-6a9 9 0 0 1 17.996 -.265l.004 .265v6z\" />"),
    HEADSET(
        "headset",
        "<path d=\"M12 2a9 9 0 0 1 9 9v6a3 3 0 0 1 -2.152 2.879c-.678 1.901 -3.538 3.121 -6.848 3.121a1 1 0 0 1 0 -2c1.889 0 3.482 -.482 4.334 -1.075a3 3 0 0 1 -2.334 -2.925l.001 -3.051l.004 -.051a2.995 2.995 0 0 1 2.995 -2.898h1c.351 0 .688 .06 1 .171v-.171a7 7 0 0 0 -13.996 -.24l-.004 .41c.313 -.11 .65 -.17 1 -.17h1a3 3 0 0 1 3 3v3a3 3 0 0 1 -3 3h-1a3 3 0 0 1 -3 -3v-6a9 9 0 0 1 9 -9\" />"),
    KEYFRAME(
        "keyframe",
        "<path d=\"M12 4a2.599 2.599 0 0 0 -2 .957l-4.355 5.24a2.847 2.847 0 0 0 -.007 3.598l4.368 5.256c.499 .6 1.225 .949 1.994 .949a2.599 2.599 0 0 0 2 -.957l4.355 -5.24a2.847 2.847 0 0 0 .007 -3.598l-4.368 -5.256a2.593 2.593 0 0 0 -1.994 -.949z\" />"),
    KEYFRAME_ALIGN_CENTER(
        "keyframe-align-center",
        "<path d=\"M12 19a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 6c-.629 0 -1.214 .301 -1.606 .807l-2.908 3.748a2.395 2.395 0 0 0 -.011 2.876l2.919 3.762c.39 .505 .977 .807 1.606 .807c.629 0 1.214 -.301 1.606 -.807l2.908 -3.748a2.395 2.395 0 0 0 .011 -2.876l-2.919 -3.762a2.032 2.032 0 0 0 -1.606 -.807z\" />\n  <path d=\"M12 1a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M5 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />\n  <path d=\"M21 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />"),
    KEYFRAME_ALIGN_HORIZONTAL(
        "keyframe-align-horizontal",
        "<path d=\"M12 6c-.629 0 -1.214 .301 -1.606 .807l-2.908 3.748a2.395 2.395 0 0 0 -.011 2.876l2.919 3.762c.39 .505 .977 .807 1.606 .807c.629 0 1.214 -.301 1.606 -.807l2.908 -3.748a2.395 2.395 0 0 0 .011 -2.876l-2.919 -3.762a2.032 2.032 0 0 0 -1.606 -.807z\" />\n  <path d=\"M5 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />\n  <path d=\"M21 11a1 1 0 0 1 .117 1.993l-.117 .007h-2a1 1 0 0 1 -.117 -1.993l.117 -.007h2z\" />"),
    KEYFRAME_ALIGN_VERTICAL(
        "keyframe-align-vertical",
        "<path d=\"M12 1a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 6c-.629 0 -1.214 .301 -1.606 .807l-2.908 3.748a2.395 2.395 0 0 0 -.011 2.876l2.919 3.762c.39 .505 .977 .807 1.606 .807c.629 0 1.214 -.301 1.606 -.807l2.908 -3.748a2.395 2.395 0 0 0 .011 -2.876l-2.919 -3.762a2.032 2.032 0 0 0 -1.606 -.807z\" />\n  <path d=\"M12 19a1 1 0 0 1 .993 .883l.007 .117v2a1 1 0 0 1 -1.993 .117l-.007 -.117v-2a1 1 0 0 1 1 -1z\" />"),
    KEYFRAMES(
        "keyframes",
        "<path d=\"M8 4a2.599 2.599 0 0 0 -2 .957l-4.355 5.24a2.847 2.847 0 0 0 -.007 3.598l4.368 5.256c.499 .6 1.224 .949 1.994 .949a2.599 2.599 0 0 0 2 -.957l4.355 -5.24a2.847 2.847 0 0 0 .007 -3.598l-4.368 -5.256a2.593 2.593 0 0 0 -1.994 -.949z\" />\n  <path d=\"M16.382 4.214a1 1 0 0 1 1.32 .074l.084 .094l4.576 5.823c.808 .993 .848 2.396 .13 3.419l-.12 .158l-4.586 5.836a1 1 0 0 1 -1.644 -1.132l.072 -.104l4.596 -5.85a.845 .845 0 0 0 .06 -.978l-.07 -.1l-4.586 -5.836a1 1 0 0 1 .168 -1.404z\" />\n  <path d=\"M12.382 4.214a1 1 0 0 1 1.32 .074l.084 .094l4.576 5.823c.808 .993 .848 2.396 .13 3.419l-.12 .158l-4.586 5.836a1 1 0 0 1 -1.644 -1.132l.072 -.104l4.596 -5.85a.845 .845 0 0 0 .06 -.978l-.07 -.1l-4.586 -5.836a1 1 0 0 1 .168 -1.404z\" />"),
    MICROPHONE(
        "microphone",
        "<path d=\"M19 9a1 1 0 0 1 1 1a8 8 0 0 1 -6.999 7.938l-.001 2.062h3a1 1 0 0 1 0 2h-8a1 1 0 0 1 0 -2h3v-2.062a8 8 0 0 1 -7 -7.938a1 1 0 1 1 2 0a6 6 0 0 0 12 0a1 1 0 0 1 1 -1m-7 -8a4 4 0 0 1 4 4v5a4 4 0 1 1 -8 0v-5a4 4 0 0 1 4 -4\" />"),
    PHOTO(
        "photo",
        "<path d=\"M8.813 11.612c.457 -.38 .918 -.38 1.386 .011l.108 .098l4.986 4.986l.094 .083a1 1 0 0 0 1.403 -1.403l-.083 -.094l-1.292 -1.293l.292 -.293l.106 -.095c.457 -.38 .918 -.38 1.386 .011l.108 .098l4.674 4.675a4 4 0 0 1 -3.775 3.599l-.206 .005h-12a4 4 0 0 1 -3.98 -3.603l6.687 -6.69l.106 -.095zm9.187 -9.612a4 4 0 0 1 3.995 3.8l.005 .2v9.585l-3.293 -3.292l-.15 -.137c-1.256 -1.095 -2.85 -1.097 -4.096 -.017l-.154 .14l-.307 .306l-2.293 -2.292l-.15 -.137c-1.256 -1.095 -2.85 -1.097 -4.096 -.017l-.154 .14l-5.307 5.306v-9.585a4 4 0 0 1 3.8 -3.995l.2 -.005h12zm-2.99 5l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    PICTURE_IN_PICTURE(
        "picture-in-picture",
        "<path d=\"M19 4a3 3 0 0 1 3 3v4a1 1 0 0 1 -2 0v-4a1 1 0 0 0 -1 -1h-14a1 1 0 0 0 -1 1v10a1 1 0 0 0 1 1h6a1 1 0 0 1 0 2h-6a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3z\" />\n  <path d=\"M20 13a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-5a2 2 0 0 1 -2 -2v-3a2 2 0 0 1 2 -2z\" />"),
    PICTURE_IN_PICTURE_TOP(
        "picture-in-picture-top",
        "<path d=\"M11 4a1 1 0 0 1 0 2h-6a1 1 0 0 0 -1 1v10a1 1 0 0 0 1 1h14a1 1 0 0 0 1 -1v-4a1 1 0 0 1 2 0v4a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3z\" />\n  <path d=\"M20 4a2 2 0 0 1 2 2v3a2 2 0 0 1 -2 2h-5a2 2 0 0 1 -2 -2v-3a2 2 0 0 1 2 -2z\" />"),
    PLAYER_EJECT(
        "player-eject",
        "<path d=\"M11.247 3.341l-7 8c-.565 .647 -.106 1.659 .753 1.659h14c.86 0 1.318 -1.012 .753 -1.659l-7 -8a1 1 0 0 0 -1.506 0z\" />\n  <path d=\"M18 15h-12a2 2 0 0 0 -2 2v2a2 2 0 0 0 2 2h12a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2z\" />"),
    PLAYER_PAUSE(
        "player-pause",
        "<path d=\"M9 4h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2z\" />\n  <path d=\"M17 4h-2a2 2 0 0 0 -2 2v12a2 2 0 0 0 2 2h2a2 2 0 0 0 2 -2v-12a2 2 0 0 0 -2 -2z\" />"),
    PLAYER_PLAY(
        "player-play",
        "<path d=\"M6 4v16a1 1 0 0 0 1.524 .852l13 -8a1 1 0 0 0 0 -1.704l-13 -8a1 1 0 0 0 -1.524 .852z\" />"),
    PLAYER_RECORD(
        "player-record",
        "<path d=\"M8 5.072a8 8 0 1 1 -3.995 7.213l-.005 -.285l.005 -.285a8 8 0 0 1 3.995 -6.643z\" />"),
    PLAYER_SKIP_BACK(
        "player-skip-back",
        "<path d=\"M19.496 4.136l-12 7a1 1 0 0 0 0 1.728l12 7a1 1 0 0 0 1.504 -.864v-14a1 1 0 0 0 -1.504 -.864z\" />\n  <path d=\"M4 4a1 1 0 0 1 .993 .883l.007 .117v14a1 1 0 0 1 -1.993 .117l-.007 -.117v-14a1 1 0 0 1 1 -1z\" />"),
    PLAYER_SKIP_FORWARD(
        "player-skip-forward",
        "<path d=\"M3 5v14a1 1 0 0 0 1.504 .864l12 -7a1 1 0 0 0 0 -1.728l-12 -7a1 1 0 0 0 -1.504 .864z\" />\n  <path d=\"M20 4a1 1 0 0 1 .993 .883l.007 .117v14a1 1 0 0 1 -1.993 .117l-.007 -.117v-14a1 1 0 0 1 1 -1z\" />"),
    PLAYER_STOP(
        "player-stop",
        "<path d=\"M17 4h-10a3 3 0 0 0 -3 3v10a3 3 0 0 0 3 3h10a3 3 0 0 0 3 -3v-10a3 3 0 0 0 -3 -3z\" />"),
    PLAYER_TRACK_NEXT(
        "player-track-next",
        "<path d=\"M2 5v14c0 .86 1.012 1.318 1.659 .753l8 -7a1 1 0 0 0 0 -1.506l-8 -7c-.647 -.565 -1.659 -.106 -1.659 .753z\" />\n  <path d=\"M13 5v14c0 .86 1.012 1.318 1.659 .753l8 -7a1 1 0 0 0 0 -1.506l-8 -7c-.647 -.565 -1.659 -.106 -1.659 .753z\" />"),
    PLAYER_TRACK_PREV(
        "player-track-prev",
        "<path d=\"M20.341 4.247l-8 7a1 1 0 0 0 0 1.506l8 7c.647 .565 1.659 .106 1.659 -.753v-14c0 -.86 -1.012 -1.318 -1.659 -.753z\" />\n  <path d=\"M9.341 4.247l-8 7a1 1 0 0 0 0 1.506l8 7c.647 .565 1.659 .106 1.659 -.753v-14c0 -.86 -1.012 -1.318 -1.659 -.753z\" />"),
    PLAYLIST(
        "playlist",
        "<path d=\"M21 3a1 1 0 0 1 0 2h-3v12a4 4 0 1 1 -2.001 -3.465l.001 -9.535a1 1 0 0 1 1 -1z\" />\n  <path d=\"M14 5a1 1 0 0 1 -1 1h-10a1 1 0 1 1 0 -2h10a1 1 0 0 1 1 1\" />\n  <path d=\"M14 9a1 1 0 0 1 -1 1h-10a1 1 0 1 1 0 -2h10a1 1 0 0 1 1 1\" />\n  <path d=\"M10 13a1 1 0 0 1 -1 1h-6a1 1 0 0 1 0 -2h6a1 1 0 0 1 1 1\" />"),
    VIDEO(
        "video",
        "<path d=\"M20.117 7.625a1 1 0 0 0 -.564 .1l-4.553 2.275v4l4.553 2.275a1 1 0 0 0 1.447 -.892v-6.766a1 1 0 0 0 -.883 -.992z\" />\n  <path d=\"M5 5c-1.645 0 -3 1.355 -3 3v8c0 1.645 1.355 3 3 3h8c1.645 0 3 -1.355 3 -3v-8c0 -1.645 -1.355 -3 -3 -3z\" />"),
    VIDEO_MINUS(
        "video-minus",
        "<path d=\"M13 5a3 3 0 0 1 3 3v.381l3.106 -1.552a2 2 0 0 1 2.894 1.789v6.765a2 2 0 0 1 -2.894 1.787l-3.106 -1.552v.382a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3zm-2 6h-4a1 1 0 0 0 0 2h4a1 1 0 0 0 0 -2\" />"),
    VIDEO_PLUS(
        "video-plus",
        "<path d=\"M13 5a3 3 0 0 1 3 3v.381l3.106 -1.552a2 2 0 0 1 2.894 1.789v6.765a2 2 0 0 1 -2.894 1.787l-3.106 -1.552v.382a3 3 0 0 1 -3 3h-8a3 3 0 0 1 -3 -3v-8a3 3 0 0 1 3 -3zm-4 4a1 1 0 0 0 -1 1v1h-1a1 1 0 0 0 0 2h1v1a1 1 0 0 0 2 0v-1h1a1 1 0 0 0 0 -2h-1v-1a1 1 0 0 0 -1 -1\" />");

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

  default TablerIcon album() {
    return TablerIcon.create(TablerMedia.OutlineIcon.ALBUM);
  }

  default TablerIcon album_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.ALBUM_OFF);
  }

  default TablerIcon aspect_ratio() {
    return TablerIcon.create(TablerMedia.OutlineIcon.ASPECT_RATIO);
  }

  default TablerIcon aspect_ratio_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.ASPECT_RATIO_OFF);
  }

  default TablerIcon camera() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA);
  }

  default TablerIcon camera_ai() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_AI);
  }

  default TablerIcon camera_bitcoin() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_BITCOIN);
  }

  default TablerIcon camera_bolt() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_BOLT);
  }

  default TablerIcon camera_cancel() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CANCEL);
  }

  default TablerIcon camera_check() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CHECK);
  }

  default TablerIcon camera_code() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_CODE);
  }

  default TablerIcon camera_cog() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_COG);
  }

  default TablerIcon camera_dollar() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_DOLLAR);
  }

  default TablerIcon camera_down() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_DOWN);
  }

  default TablerIcon camera_exclamation() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_EXCLAMATION);
  }

  default TablerIcon camera_heart() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_HEART);
  }

  default TablerIcon camera_minus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_MINUS);
  }

  default TablerIcon camera_moon() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_MOON);
  }

  default TablerIcon camera_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_OFF);
  }

  default TablerIcon camera_pause() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PAUSE);
  }

  default TablerIcon camera_pin() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PIN);
  }

  default TablerIcon camera_plus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_PLUS);
  }

  default TablerIcon camera_question() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_QUESTION);
  }

  default TablerIcon camera_search() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SEARCH);
  }

  default TablerIcon camera_share() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SHARE);
  }

  default TablerIcon camera_spark() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_SPARK);
  }

  default TablerIcon camera_star() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_STAR);
  }

  default TablerIcon camera_up() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_UP);
  }

  default TablerIcon camera_x() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAMERA_X);
  }

  default TablerIcon capture() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAPTURE);
  }

  default TablerIcon capture_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAPTURE_OFF);
  }

  default TablerIcon cast() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAST);
  }

  default TablerIcon cast_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CAST_OFF);
  }

  default TablerIcon circle_pause() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_PAUSE);
  }

  default TablerIcon circle_play() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_PLAY);
  }

  default TablerIcon circle_stop() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CIRCLE_STOP);
  }

  default TablerIcon clef() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CLEF);
  }

  default TablerIcon clef_staff() {
    return TablerIcon.create(TablerMedia.OutlineIcon.CLEF_STAFF);
  }

  default TablerIcon headphones() {
    return TablerIcon.create(TablerMedia.OutlineIcon.HEADPHONES);
  }

  default TablerIcon headphones_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.HEADPHONES_OFF);
  }

  default TablerIcon headset() {
    return TablerIcon.create(TablerMedia.OutlineIcon.HEADSET);
  }

  default TablerIcon headset_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.HEADSET_OFF);
  }

  default TablerIcon keyframe() {
    return TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME);
  }

  default TablerIcon keyframe_align_center() {
    return TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_CENTER);
  }

  default TablerIcon keyframe_align_horizontal() {
    return TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_HORIZONTAL);
  }

  default TablerIcon keyframe_align_vertical() {
    return TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAME_ALIGN_VERTICAL);
  }

  default TablerIcon keyframes() {
    return TablerIcon.create(TablerMedia.OutlineIcon.KEYFRAMES);
  }

  default TablerIcon maximize() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MAXIMIZE);
  }

  default TablerIcon maximize_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MAXIMIZE_OFF);
  }

  default TablerIcon microphone() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE);
  }

  default TablerIcon microphone_2() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_2);
  }

  default TablerIcon microphone_2_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_2_OFF);
  }

  default TablerIcon microphone_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MICROPHONE_OFF);
  }

  default TablerIcon minimize() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MINIMIZE);
  }

  default TablerIcon movie() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MOVIE);
  }

  default TablerIcon movie_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MOVIE_OFF);
  }

  default TablerIcon music() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC);
  }

  default TablerIcon music_bolt() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_BOLT);
  }

  default TablerIcon music_cancel() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CANCEL);
  }

  default TablerIcon music_check() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CHECK);
  }

  default TablerIcon music_code() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_CODE);
  }

  default TablerIcon music_cog() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_COG);
  }

  default TablerIcon music_dollar() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_DOLLAR);
  }

  default TablerIcon music_down() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_DOWN);
  }

  default TablerIcon music_exclamation() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_EXCLAMATION);
  }

  default TablerIcon music_heart() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_HEART);
  }

  default TablerIcon music_minus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_MINUS);
  }

  default TablerIcon music_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_OFF);
  }

  default TablerIcon music_pause() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PAUSE);
  }

  default TablerIcon music_pin() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PIN);
  }

  default TablerIcon music_plus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_PLUS);
  }

  default TablerIcon music_question() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_QUESTION);
  }

  default TablerIcon music_search() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_SEARCH);
  }

  default TablerIcon music_share() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_SHARE);
  }

  default TablerIcon music_star() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_STAR);
  }

  default TablerIcon music_up() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_UP);
  }

  default TablerIcon music_x() {
    return TablerIcon.create(TablerMedia.OutlineIcon.MUSIC_X);
  }

  default TablerIcon photo() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO);
  }

  default TablerIcon photo_ai() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_AI);
  }

  default TablerIcon photo_alt() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_ALT);
  }

  default TablerIcon photo_bolt() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_BOLT);
  }

  default TablerIcon photo_cancel() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CANCEL);
  }

  default TablerIcon photo_check() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CHECK);
  }

  default TablerIcon photo_circle_minus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CIRCLE_MINUS);
  }

  default TablerIcon photo_circle_plus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CIRCLE_PLUS);
  }

  default TablerIcon photo_code() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_CODE);
  }

  default TablerIcon photo_cog() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_COG);
  }

  default TablerIcon photo_dollar() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_DOLLAR);
  }

  default TablerIcon photo_down() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_DOWN);
  }

  default TablerIcon photo_edit() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_EDIT);
  }

  default TablerIcon photo_exclamation() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_EXCLAMATION);
  }

  default TablerIcon photo_heart() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_HEART);
  }

  default TablerIcon photo_minus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_MINUS);
  }

  default TablerIcon photo_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_OFF);
  }

  default TablerIcon photo_pause() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PAUSE);
  }

  default TablerIcon photo_pin() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PIN);
  }

  default TablerIcon photo_plus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_PLUS);
  }

  default TablerIcon photo_question() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_QUESTION);
  }

  default TablerIcon photo_search() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SEARCH);
  }

  default TablerIcon photo_share() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SHARE);
  }

  default TablerIcon photo_shield() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SHIELD);
  }

  default TablerIcon photo_spark() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_SPARK);
  }

  default TablerIcon photo_star() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_STAR);
  }

  default TablerIcon photo_up() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_UP);
  }

  default TablerIcon photo_x() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO_X);
  }

  default TablerIcon picture_in_picture() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE);
  }

  default TablerIcon picture_in_picture_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_OFF);
  }

  default TablerIcon picture_in_picture_on() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_ON);
  }

  default TablerIcon picture_in_picture_top() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PICTURE_IN_PICTURE_TOP);
  }

  default TablerIcon player_eject() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_EJECT);
  }

  default TablerIcon player_pause() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_PAUSE);
  }

  default TablerIcon player_play() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_PLAY);
  }

  default TablerIcon player_record() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_RECORD);
  }

  default TablerIcon player_skip_back() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK);
  }

  default TablerIcon player_skip_forward() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD);
  }

  default TablerIcon player_stop() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_STOP);
  }

  default TablerIcon player_track_next() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_TRACK_NEXT);
  }

  default TablerIcon player_track_prev() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_TRACK_PREV);
  }

  default TablerIcon playlist() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST);
  }

  default TablerIcon playlist_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST_OFF);
  }

  default TablerIcon playlist_x() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYLIST_X);
  }

  default TablerIcon radio() {
    return TablerIcon.create(TablerMedia.OutlineIcon.RADIO);
  }

  default TablerIcon radio_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.RADIO_OFF);
  }

  default TablerIcon repeat() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REPEAT);
  }

  default TablerIcon repeat_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REPEAT_OFF);
  }

  default TablerIcon repeat_once() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REPEAT_ONCE);
  }

  default TablerIcon rewind_backward_10() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_10);
  }

  default TablerIcon rewind_backward_15() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_15);
  }

  default TablerIcon rewind_backward_20() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_20);
  }

  default TablerIcon rewind_backward_30() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_30);
  }

  default TablerIcon rewind_backward_40() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_40);
  }

  default TablerIcon rewind_backward_5() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_5);
  }

  default TablerIcon rewind_backward_50() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_50);
  }

  default TablerIcon rewind_backward_60() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_BACKWARD_60);
  }

  default TablerIcon rewind_forward_10() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_10);
  }

  default TablerIcon rewind_forward_15() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_15);
  }

  default TablerIcon rewind_forward_20() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_20);
  }

  default TablerIcon rewind_forward_30() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_30);
  }

  default TablerIcon rewind_forward_40() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_40);
  }

  default TablerIcon rewind_forward_5() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_5);
  }

  default TablerIcon rewind_forward_50() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_50);
  }

  default TablerIcon rewind_forward_60() {
    return TablerIcon.create(TablerMedia.OutlineIcon.REWIND_FORWARD_60);
  }

  default TablerIcon shareplay() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SHAREPLAY);
  }

  default TablerIcon speakerphone() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SPEAKERPHONE);
  }

  default TablerIcon subtitles() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES);
  }

  default TablerIcon subtitles_ai() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_AI);
  }

  default TablerIcon subtitles_edit() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_EDIT);
  }

  default TablerIcon subtitles_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.SUBTITLES_OFF);
  }

  default TablerIcon user_screen() {
    return TablerIcon.create(TablerMedia.OutlineIcon.USER_SCREEN);
  }

  default TablerIcon video() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VIDEO);
  }

  default TablerIcon video_minus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_MINUS);
  }

  default TablerIcon video_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_OFF);
  }

  default TablerIcon video_plus() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VIDEO_PLUS);
  }

  default TablerIcon voice() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOICE);
  }

  default TablerIcon voice_2() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOICE_2);
  }

  default TablerIcon volume() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOLUME);
  }

  default TablerIcon volume_2() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_2);
  }

  default TablerIcon volume_3() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_3);
  }

  default TablerIcon volume_4() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_4);
  }

  default TablerIcon volume_off() {
    return TablerIcon.create(TablerMedia.OutlineIcon.VOLUME_OFF);
  }

  default TablerIcon image() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PHOTO);
  }

  default TablerIcon page_first() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK);
  }

  default TablerIcon page_last() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD);
  }

  default TablerIcon skip_next() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_FORWARD);
  }

  default TablerIcon skip_previous() {
    return TablerIcon.create(TablerMedia.OutlineIcon.PLAYER_SKIP_BACK);
  }

  default TablerIcon aspect_ratio_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.ASPECT_RATIO);
  }

  default TablerIcon camera_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.CAMERA);
  }

  default TablerIcon capture_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.CAPTURE);
  }

  default TablerIcon headphones_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.HEADPHONES);
  }

  default TablerIcon headset_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.HEADSET);
  }

  default TablerIcon keyframe_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME);
  }

  default TablerIcon keyframe_align_center_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_CENTER);
  }

  default TablerIcon keyframe_align_horizontal_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_HORIZONTAL);
  }

  default TablerIcon keyframe_align_vertical_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.KEYFRAME_ALIGN_VERTICAL);
  }

  default TablerIcon keyframes_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.KEYFRAMES);
  }

  default TablerIcon microphone_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.MICROPHONE);
  }

  default TablerIcon photo_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PHOTO);
  }

  default TablerIcon picture_in_picture_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PICTURE_IN_PICTURE);
  }

  default TablerIcon picture_in_picture_top_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PICTURE_IN_PICTURE_TOP);
  }

  default TablerIcon player_eject_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_EJECT);
  }

  default TablerIcon player_pause_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_PAUSE);
  }

  default TablerIcon player_play_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_PLAY);
  }

  default TablerIcon player_record_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_RECORD);
  }

  default TablerIcon player_skip_back_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_SKIP_BACK);
  }

  default TablerIcon player_skip_forward_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_SKIP_FORWARD);
  }

  default TablerIcon player_stop_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_STOP);
  }

  default TablerIcon player_track_next_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_TRACK_NEXT);
  }

  default TablerIcon player_track_prev_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYER_TRACK_PREV);
  }

  default TablerIcon playlist_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.PLAYLIST);
  }

  default TablerIcon video_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.VIDEO);
  }

  default TablerIcon video_minus_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.VIDEO_MINUS);
  }

  default TablerIcon video_plus_filled() {
    return TablerIcon.create(TablerMedia.FilledIcon.VIDEO_PLUS);
  }
}
