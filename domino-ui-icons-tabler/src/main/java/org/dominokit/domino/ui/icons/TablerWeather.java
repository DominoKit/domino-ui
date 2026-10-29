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

/** Tabler Weather catalog category. */
public interface TablerWeather {
  enum OutlineIcon implements TablerIconDefinition {
    CLOUD(
        "cloud",
        "<path d=\"M6.657 18c-2.572 0 -4.657 -2.007 -4.657 -4.483c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.913 0 3.464 1.56 3.464 3.486c0 1.927 -1.551 3.487 -3.465 3.487h-11.878\" />"),
    CLOUD_BOLT(
        "cloud-bolt",
        "<path d=\"M13 18.004h-6.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.396 0 2.6 .831 3.148 2.03\" />\n  <path d=\"M19 16l-2 3h4l-2 3\" />"),
    CLOUD_CANCEL(
        "cloud-cancel",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99a3.45 3.45 0 0 1 2.756 1.373\" />\n  <path d=\"M16 19a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M17 21l4 -4\" />"),
    CLOUD_CHECK(
        "cloud-check",
        "<path d=\"M11 18.004h-4.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.388 0 2.585 .82 3.138 2.007\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    CLOUD_CODE(
        "cloud-code",
        "<path d=\"M11 18.004h-4.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99a3.468 3.468 0 0 1 3.307 2.444\" />\n  <path d=\"M20 21l2 -2l-2 -2\" />\n  <path d=\"M17 17l-2 2l2 2\" />"),
    CLOUD_COG(
        "cloud-cog",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c.956 0 1.822 .39 2.449 1.02\" />\n  <path d=\"M17.001 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M19.001 15.5v1.5\" />\n  <path d=\"M19.001 21v1.5\" />\n  <path d=\"M22.032 17.25l-1.299 .75\" />\n  <path d=\"M17.27 20l-1.3 .75\" />\n  <path d=\"M15.97 17.25l1.3 .75\" />\n  <path d=\"M20.733 20l1.3 .75\" />"),
    CLOUD_DOLLAR(
        "cloud-dollar",
        "<path d=\"M13.5 18.004h-6.843c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.28 1.023 1.957 2.51 1.873 4.027\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    CLOUD_DOWN(
        "cloud-down",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.38 0 2.573 .813 3.13 1.99\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M22 19l-3 3l-3 -3\" />"),
    CLOUD_EXCLAMATION(
        "cloud-exclamation",
        "<path d=\"M15 18.004h-8.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.374 0 2.562 .805 3.121 1.972\" />\n  <path d=\"M19 16v3\" />\n  <path d=\"M19 22v.01\" />"),
    CLOUD_FOG(
        "cloud-fog",
        "<path d=\"M7 16a4.6 4.4 0 0 1 0 -9a5 4.5 0 0 1 11 2h1a3.5 3.5 0 0 1 0 7h-12\" />\n  <path d=\"M5 20l14 0\" />"),
    CLOUD_HEART(
        "cloud-heart",
        "<path d=\"M10 18.004h-3.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99\" />\n  <path d=\"M18 22l3.35 -3.284a2.143 2.143 0 0 0 .005 -3.071a2.242 2.242 0 0 0 -3.129 -.006l-.224 .22l-.223 -.22a2.242 2.242 0 0 0 -3.128 -.006a2.143 2.143 0 0 0 -.006 3.071l3.355 3.296\" />"),
    CLOUD_MINUS(
        "cloud-minus",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.913 0 3.464 1.56 3.464 3.486c0 .186 -.015 .37 -.042 .548\" />\n  <path d=\"M16 19h6\" />"),
    CLOUD_OFF(
        "cloud-off",
        "<path d=\"M9.58 5.548c.24 -.11 .492 -.207 .752 -.286c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.913 0 3.464 1.56 3.464 3.486c0 .957 -.383 1.824 -1.003 2.454m-2.997 1.033h-11.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.13 -.582 .37 -1.128 .7 -1.62\" />\n  <path d=\"M3 3l18 18\" />"),
    CLOUD_PAUSE(
        "cloud-pause",
        "<path d=\"M13 18.004h-6.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.406 0 2.617 .843 3.16 2.055\" />\n  <path d=\"M17 17v5\" />\n  <path d=\"M21 17v5\" />"),
    CLOUD_PIN(
        "cloud-pin",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    CLOUD_PLUS(
        "cloud-plus",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99a3.46 3.46 0 0 1 3.085 1.9\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />"),
    CLOUD_QUESTION(
        "cloud-question",
        "<path d=\"M14.5 18.004h-7.843c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99\" />\n  <path d=\"M19 22v.01\" />\n  <path d=\"M19 19a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    CLOUD_RAIN(
        "cloud-rain",
        "<path d=\"M7 18a4.6 4.4 0 0 1 0 -9a5 4.5 0 0 1 11 2h1a3.5 3.5 0 0 1 0 7\" />\n  <path d=\"M11 13v2m0 3v2m4 -5v2m0 3v2\" />"),
    CLOUD_SEARCH(
        "cloud-search",
        "<path d=\"M11 18.004h-4.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    CLOUD_SHARE(
        "cloud-share",
        "<path d=\"M12.5 18.004h-5.843c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.41 0 2.624 .848 3.164 2.065\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    CLOUD_SNOW(
        "cloud-snow",
        "<path d=\"M7 18a4.6 4.4 0 0 1 0 -9a5 4.5 0 0 1 11 2h1a3.5 3.5 0 0 1 0 7\" />\n  <path d=\"M11 15v.01m0 3v.01m0 3v.01m4 -4v.01m0 3v.01\" />"),
    CLOUD_STAR(
        "cloud-star",
        "<path d=\"M9.5 18.004h-2.843c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.209 .967 1.88 2.347 1.88 3.776\" />\n  <path d=\"M17.8 20.817l-2.172 1.138a.392 .392 0 0 1 -.568 -.41l.415 -2.411l-1.757 -1.707a.389 .389 0 0 1 .217 -.665l2.428 -.352l1.086 -2.193a.392 .392 0 0 1 .702 0l1.086 2.193l2.428 .352a.39 .39 0 0 1 .217 .665l-1.757 1.707l.414 2.41a.39 .39 0 0 1 -.567 .411l-2.172 -1.138\" />"),
    CLOUD_STORM(
        "cloud-storm",
        "<path d=\"M7 18a4.6 4.4 0 0 1 0 -9a5 4.5 0 0 1 11 2h1a3.5 3.5 0 0 1 0 7h-1\" />\n  <path d=\"M13 14l-2 4l3 0l-2 4\" />"),
    CLOUD_UP(
        "cloud-up",
        "<path d=\"M12 18.004h-5.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.38 0 2.57 .811 3.128 1.986\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />"),
    CLOUD_X(
        "cloud-x",
        "<path d=\"M13 18.004h-6.343c-2.572 -.004 -4.657 -2.011 -4.657 -4.487c0 -2.475 2.085 -4.482 4.657 -4.482c.393 -1.762 1.794 -3.2 3.675 -3.773c1.88 -.572 3.956 -.193 5.444 1c1.488 1.19 2.162 3.007 1.77 4.769h.99c1.37 0 2.556 .8 3.117 1.964\" />\n  <path d=\"M22 22l-5 -5\" />\n  <path d=\"M17 22l5 -5\" />"),
    COMET(
        "comet",
        "<path d=\"M15.5 18.5l-3 1.5l.5 -3.5l-2 -2l3 -.5l1.5 -3l1.5 3l3 .5l-2 2l.5 3.5l-3 -1.5\" />\n  <path d=\"M4 4l7 7\" />\n  <path d=\"M9 4l3.5 3.5\" />\n  <path d=\"M4 9l3.5 3.5\" />"),
    FLARE("flare", "<path d=\"M12 3l3 6l6 3l-6 3l-3 6l-3 -6l-6 -3l6 -3l3 -6\" />"),
    FLOOD(
        "flood",
        "<path d=\"M3 10l9 -7l9 7\" />\n  <path d=\"M6 7.75v4.25m12 0v-4.25\" />\n  <path d=\"M3 20.75a2.4 2.4 0 0 0 1 .25a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 1 -.25\" />\n  <path d=\"M3 16.75a2.4 2.4 0 0 0 1 .25a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 2 -1a2.4 2.4 0 0 1 2 -1a2.4 2.4 0 0 1 2 1a2.4 2.4 0 0 0 2 1a2.4 2.4 0 0 0 1 -.25\" />"),
    HAZE(
        "haze",
        "<path d=\"M3 12h1\" />\n  <path d=\"M12 3v1\" />\n  <path d=\"M20 12h1\" />\n  <path d=\"M5.6 5.6l.7 .7\" />\n  <path d=\"M18.4 5.6l-.7 .7\" />\n  <path d=\"M8 12a4 4 0 1 1 8 0\" />\n  <path d=\"M3 16h18\" />\n  <path d=\"M3 20h18\" />"),
    MIST(
        "mist",
        "<path d=\"M5 5h3m4 0h9\" />\n  <path d=\"M3 10h11m4 0h1\" />\n  <path d=\"M5 15h5m4 0h7\" />\n  <path d=\"M3 20h9m4 0h3\" />"),
    MIST_OFF(
        "mist-off",
        "<path d=\"M12 5h9\" />\n  <path d=\"M3 10h7\" />\n  <path d=\"M18 10h1\" />\n  <path d=\"M5 15h5\" />\n  <path d=\"M14 15h1m4 0h2\" />\n  <path d=\"M3 20h9m4 0h3\" />\n  <path d=\"M3 3l18 18\" />"),
    MOON(
        "moon",
        "<path d=\"M12 3c.132 0 .263 0 .393 0a7.5 7.5 0 0 0 7.92 12.446a9 9 0 1 1 -8.313 -12.454l0 .008\" />"),
    MOON_2(
        "moon-2",
        "<path d=\"M16.418 4.157a8 8 0 0 0 0 15.686\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    MOON_OFF(
        "moon-off",
        "<path d=\"M7.962 3.949a8.97 8.97 0 0 1 4.038 -.957v.008h.393a7.478 7.478 0 0 0 -2.07 3.308m-.141 3.84c.186 .823 .514 1.626 .989 2.373a7.49 7.49 0 0 0 4.586 3.268m3.893 -.11c.223 -.067 .444 -.144 .663 -.233a9.088 9.088 0 0 1 -.274 .597m-1.695 2.337a9 9 0 0 1 -12.71 -12.749\" />\n  <path d=\"M3 3l18 18\" />"),
    MOON_STARS(
        "moon-stars",
        "<path d=\"M12 3c.132 0 .263 0 .393 0a7.5 7.5 0 0 0 7.92 12.446a9 9 0 1 1 -8.313 -12.454l0 .008\" />\n  <path d=\"M17 4a2 2 0 0 0 2 2a2 2 0 0 0 -2 2a2 2 0 0 0 -2 -2a2 2 0 0 0 2 -2\" />\n  <path d=\"M19 11h2m-1 -1v2\" />"),
    RAINBOW(
        "rainbow",
        "<path d=\"M22 17c0 -5.523 -4.477 -10 -10 -10c-5.523 0 -10 4.477 -10 10\" />\n  <path d=\"M18 17a6 6 0 1 0 -12 0\" />\n  <path d=\"M14 17a2 2 0 1 0 -4 0\" />"),
    RAINBOW_OFF(
        "rainbow-off",
        "<path d=\"M22 17c0 -5.523 -4.477 -10 -10 -10c-.308 0 -.613 .014 -.914 .041m-3.208 .845a10 10 0 0 0 -5.878 9.114\" />\n  <path d=\"M11.088 11.069a6 6 0 0 0 -5.088 5.931\" />\n  <path d=\"M14 17a2 2 0 1 0 -4 0\" />\n  <path d=\"M3 3l18 18\" />"),
    SNOWFLAKE(
        "snowflake",
        "<path d=\"M10 4l2 1l2 -1\" />\n  <path d=\"M12 2v6.5l3 1.72\" />\n  <path d=\"M17.928 6.268l.134 2.232l1.866 1.232\" />\n  <path d=\"M20.66 7l-5.629 3.25l.01 3.458\" />\n  <path d=\"M19.928 14.268l-1.866 1.232l-.134 2.232\" />\n  <path d=\"M20.66 17l-5.629 -3.25l-2.99 1.738\" />\n  <path d=\"M14 20l-2 -1l-2 1\" />\n  <path d=\"M12 22v-6.5l-3 -1.72\" />\n  <path d=\"M6.072 17.732l-.134 -2.232l-1.866 -1.232\" />\n  <path d=\"M3.34 17l5.629 -3.25l-.01 -3.458\" />\n  <path d=\"M4.072 9.732l1.866 -1.232l.134 -2.232\" />\n  <path d=\"M3.34 7l5.629 3.25l2.99 -1.738\" />"),
    SNOWFLAKE_OFF(
        "snowflake-off",
        "<path d=\"M10 4l2 1l2 -1\" />\n  <path d=\"M12 2v6m1.196 1.186l1.804 1.034\" />\n  <path d=\"M17.928 6.268l.134 2.232l1.866 1.232\" />\n  <path d=\"M20.66 7l-5.629 3.25l-.031 .75\" />\n  <path d=\"M19.928 14.268l-1.015 .67\" />\n  <path d=\"M14.212 14.226l-2.171 1.262\" />\n  <path d=\"M14 20l-2 -1l-2 1\" />\n  <path d=\"M12 22v-6.5l-3 -1.72\" />\n  <path d=\"M6.072 17.732l-.134 -2.232l-1.866 -1.232\" />\n  <path d=\"M3.34 17l5.629 -3.25l-.01 -3.458\" />\n  <path d=\"M4.072 9.732l1.866 -1.232l.134 -2.232\" />\n  <path d=\"M3.34 7l5.629 3.25l.802 -.466\" />\n  <path d=\"M3 3l18 18\" />"),
    STORM(
        "storm",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M5.369 14.236c-1.839 -3.929 -1.561 -7.616 -.704 -11.236\" />\n  <path d=\"M18.63 9.76c1.837 3.928 1.561 7.615 .703 11.236\" />"),
    STORM_OFF(
        "storm-off",
        "<path d=\"M9.884 9.874a3 3 0 1 0 4.24 4.246m.57 -3.441a3.012 3.012 0 0 0 -1.41 -1.39\" />\n  <path d=\"M7.037 7.063a7 7 0 0 0 9.907 9.892m1.585 -2.426a7 7 0 0 0 -9.058 -9.059\" />\n  <path d=\"M5.369 14.236c-1.605 -3.428 -1.597 -6.673 -1 -9.849\" />\n  <path d=\"M18.63 9.76a14.323 14.323 0 0 1 1.368 6.251m-.37 3.608c-.087 .46 -.187 .92 -.295 1.377\" />\n  <path d=\"M3 3l18 18\" />"),
    SUN(
        "sun",
        "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7\" />"),
    SUN_HIGH(
        "sun-high",
        "<path d=\"M14.828 14.828a4 4 0 1 0 -5.656 -5.656a4 4 0 0 0 5.656 5.656\" />\n  <path d=\"M6.343 17.657l-1.414 1.414\" />\n  <path d=\"M6.343 6.343l-1.414 -1.414\" />\n  <path d=\"M17.657 6.343l1.414 -1.414\" />\n  <path d=\"M17.657 17.657l1.414 1.414\" />\n  <path d=\"M4 12h-2\" />\n  <path d=\"M12 4v-2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"M12 20v2\" />"),
    SUN_LOW(
        "sun-low",
        "<path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M4 12h.01\" />\n  <path d=\"M12 4v.01\" />\n  <path d=\"M20 12h.01\" />\n  <path d=\"M12 20v.01\" />\n  <path d=\"M6.31 6.31l-.01 -.01\" />\n  <path d=\"M17.71 6.31l-.01 -.01\" />\n  <path d=\"M17.7 17.7l.01 .01\" />\n  <path d=\"M6.3 17.7l.01 .01\" />"),
    SUN_MOON(
        "sun-moon",
        "<path d=\"M9.173 14.83a4 4 0 1 1 5.657 -5.657\" />\n  <path d=\"M11.294 12.707l.174 .247a7.5 7.5 0 0 0 8.845 2.492a9 9 0 0 1 -14.671 2.914\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M12 3v1\" />\n  <path d=\"M5.6 5.6l.7 .7\" />\n  <path d=\"M3 21l18 -18\" />"),
    SUN_OFF(
        "sun-off",
        "<path d=\"M3 3l18 18\" />\n  <path d=\"M16 12a4 4 0 0 0 -4 -4m-2.834 1.177a4 4 0 0 0 5.66 5.654\" />\n  <path d=\"M3 12h1m8 -9v1m8 8h1m-9 8v1m-6.4 -15.4l.7 .7m12.1 -.7l-.7 .7m0 11.4l.7 .7m-12.1 -.7l-.7 .7\" />"),
    SUN_WIND(
        "sun-wind",
        "<path d=\"M14.468 10a4 4 0 1 0 -5.466 5.46\" />\n  <path d=\"M2 12h1\" />\n  <path d=\"M11 3v1\" />\n  <path d=\"M11 20v1\" />\n  <path d=\"M4.6 5.6l.7 .7\" />\n  <path d=\"M17.4 5.6l-.7 .7\" />\n  <path d=\"M5.3 17.7l-.7 .7\" />\n  <path d=\"M15 13h5a2 2 0 1 0 0 -4\" />\n  <path d=\"M12 16h5.714l.253 0a2 2 0 0 1 2.033 2a2 2 0 0 1 -2 2h-.286\" />"),
    SUNRISE(
        "sunrise",
        "<path d=\"M3 17h1m16 0h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7m-9.7 5.7a4 4 0 0 1 8 0\" />\n  <path d=\"M3 21l18 0\" />\n  <path d=\"M12 9v-6l3 3m-6 0l3 -3\" />"),
    SUNSET(
        "sunset",
        "<path d=\"M3 17h1m16 0h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7m-9.7 5.7a4 4 0 0 1 8 0\" />\n  <path d=\"M3 21l18 0\" />\n  <path d=\"M12 3v6l3 -3m-6 0l3 3\" />"),
    SUNSET_2(
        "sunset-2",
        "<path d=\"M3 13h1\" />\n  <path d=\"M20 13h1\" />\n  <path d=\"M5.6 6.6l.7 .7\" />\n  <path d=\"M18.4 6.6l-.7 .7\" />\n  <path d=\"M8 13a4 4 0 1 1 8 0\" />\n  <path d=\"M3 17h18\" />\n  <path d=\"M7 20h5\" />\n  <path d=\"M16 20h1\" />\n  <path d=\"M12 5v-1\" />"),
    TEMPERATURE(
        "temperature",
        "<path d=\"M10 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 0 0 -4 0v8.5\" />\n  <path d=\"M10 9l4 0\" />"),
    TEMPERATURE_CELSIUS(
        "temperature-celsius",
        "<path d=\"M4 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M20 9a3 3 0 0 0 -3 -3h-1a3 3 0 0 0 -3 3v6a3 3 0 0 0 3 3h1a3 3 0 0 0 3 -3\" />"),
    TEMPERATURE_FAHRENHEIT(
        "temperature-fahrenheit",
        "<path d=\"M4 8a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M13 12l5 0\" />\n  <path d=\"M20 6h-6a1 1 0 0 0 -1 1v11\" />"),
    TEMPERATURE_MINUS(
        "temperature-minus",
        "<path d=\"M8 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 0 0 -4 0v8.5\" />\n  <path d=\"M8 9l4 0\" />\n  <path d=\"M16 9l6 0\" />"),
    TEMPERATURE_OFF(
        "temperature-off",
        "<path d=\"M10 10v3.5a4 4 0 1 0 5.836 2.33m-1.836 -5.83v-5a2 2 0 1 0 -4 0v1\" />\n  <path d=\"M13 9h1\" />\n  <path d=\"M3 3l18 18\" />"),
    TEMPERATURE_PLUS(
        "temperature-plus",
        "<path d=\"M8 13.5a4 4 0 1 0 4 0v-8.5a2 2 0 0 0 -4 0v8.5\" />\n  <path d=\"M8 9l4 0\" />\n  <path d=\"M16 9l6 0\" />\n  <path d=\"M19 6l0 6\" />"),
    TORNADO(
        "tornado",
        "<path d=\"M21 4l-18 0\" />\n  <path d=\"M13 16l-6 0\" />\n  <path d=\"M11 20l4 0\" />\n  <path d=\"M6 8l14 0\" />\n  <path d=\"M4 12l12 0\" />"),
    UV_INDEX(
        "uv-index",
        "<path d=\"M3 12h1m16 0h1m-15.4 -6.4l.7 .7m12.1 -.7l-.7 .7m-9.7 5.7a4 4 0 1 1 8 0\" />\n  <path d=\"M12 4v-1\" />\n  <path d=\"M13 16l2 5h1l2 -5\" />\n  <path d=\"M6 16v3a2 2 0 1 0 4 0v-3\" />"),
    WHIRL(
        "whirl",
        "<path d=\"M14 12a2 2 0 1 0 -4 0a2 2 0 0 0 4 0\" />\n  <path d=\"M12 21c-3.314 0 -6 -2.462 -6 -5.5s2.686 -5.5 6 -5.5\" />\n  <path d=\"M21 12c0 3.314 -2.462 6 -5.5 6s-5.5 -2.686 -5.5 -6\" />\n  <path d=\"M12 14c3.314 0 6 -2.462 6 -5.5s-2.686 -5.5 -6 -5.5\" />\n  <path d=\"M14 12c0 -3.314 -2.462 -6 -5.5 -6s-5.5 2.686 -5.5 6\" />"),
    WIND(
        "wind",
        "<path d=\"M5 8h8.5a2.5 2.5 0 1 0 -2.34 -3.24\" />\n  <path d=\"M3 12h15.5a2.5 2.5 0 1 1 -2.34 3.24\" />\n  <path d=\"M4 16h5.5a2.5 2.5 0 1 1 -2.34 3.24\" />"),
    WIND_OFF(
        "wind-off",
        "<path d=\"M5 8h3m4 0h1.5a2.5 2.5 0 1 0 -2.34 -3.24\" />\n  <path d=\"M3 12h9\" />\n  <path d=\"M16 12h2.5a2.5 2.5 0 0 1 1.801 4.282\" />\n  <path d=\"M4 16h5.5a2.5 2.5 0 1 1 -2.34 3.24\" />\n  <path d=\"M3 3l18 18\" />");

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
    CLOUD(
        "cloud",
        "<path d=\"M10.04 4.305c2.195 -.667 4.615 -.224 6.36 1.176c1.386 1.108 2.188 2.686 2.252 4.34l.003 .212l.091 .003c2.3 .107 4.143 1.961 4.25 4.27l.004 .211c0 2.407 -1.885 4.372 -4.255 4.482l-.21 .005h-11.878l-.222 -.008c-2.94 -.11 -5.317 -2.399 -5.43 -5.263l-.005 -.216c0 -2.747 2.08 -5.01 4.784 -5.417l.114 -.016l.07 -.181c.663 -1.62 2.056 -2.906 3.829 -3.518l.244 -.08z\" />"),
    FLARE(
        "flare",
        "<path d=\"M11.106 2.553a1 1 0 0 1 1.788 0l2.851 5.701l5.702 2.852a1 1 0 0 1 .11 1.725l-.11 .063l-5.702 2.851l-2.85 5.702a1 1 0 0 1 -1.726 .11l-.063 -.11l-2.852 -5.702l-5.701 -2.85a1 1 0 0 1 -.11 -1.726l.11 -.063l5.701 -2.852z\" />"),
    MOON(
        "moon",
        "<path d=\"M12 1.992a10 10 0 1 0 9.236 13.838c.341 -.82 -.476 -1.644 -1.298 -1.31a6.5 6.5 0 0 1 -6.864 -10.787l.077 -.08c.551 -.63 .113 -1.653 -.758 -1.653h-.266l-.068 -.006l-.06 -.002z\" />"),
    SUN(
        "sun",
        "<path d=\"M12 19a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18.313 16.91l.094 .083l.7 .7a1 1 0 0 1 -1.32 1.497l-.094 -.083l-.7 -.7a1 1 0 0 1 1.218 -1.567l.102 .07z\" />\n  <path d=\"M7.007 16.993a1 1 0 0 1 .083 1.32l-.083 .094l-.7 .7a1 1 0 0 1 -1.497 -1.32l.083 -.094l.7 -.7a1 1 0 0 1 1.414 0z\" />\n  <path d=\"M4 11a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M21 11a1 1 0 0 1 .117 1.993l-.117 .007h-1a1 1 0 0 1 -.117 -1.993l.117 -.007h1z\" />\n  <path d=\"M6.213 4.81l.094 .083l.7 .7a1 1 0 0 1 -1.32 1.497l-.094 -.083l-.7 -.7a1 1 0 0 1 1.217 -1.567l.102 .07z\" />\n  <path d=\"M19.107 4.893a1 1 0 0 1 .083 1.32l-.083 .094l-.7 .7a1 1 0 0 1 -1.497 -1.32l.083 -.094l.7 -.7a1 1 0 0 1 1.414 0z\" />\n  <path d=\"M12 2a1 1 0 0 1 .993 .883l.007 .117v1a1 1 0 0 1 -1.993 .117l-.007 -.117v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 7a5 5 0 1 1 -4.995 5.217l-.005 -.217l.005 -.217a5 5 0 0 1 4.995 -4.783z\" />"),
    SUN_HIGH(
        "sun-high",
        "<path d=\"M12 19a1 1 0 0 1 1 1v2a1 1 0 0 1 -2 0v-2a1 1 0 0 1 1 -1m-4.95 -2.05a1 1 0 0 1 0 1.414l-1.414 1.414a1 1 0 1 1 -1.414 -1.414l1.414 -1.414a1 1 0 0 1 1.414 0m11.314 0l1.414 1.414a1 1 0 0 1 -1.414 1.414l-1.414 -1.414a1 1 0 0 1 1.414 -1.414m-5.049 -9.836a5 5 0 1 1 -2.532 9.674a5 5 0 0 1 2.532 -9.674m-9.315 3.886a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2zm18 0a1 1 0 0 1 0 2h-2a1 1 0 0 1 0 -2zm-16.364 -6.778l1.414 1.414a1 1 0 0 1 -1.414 1.414l-1.414 -1.414a1 1 0 0 1 1.414 -1.414m14.142 0a1 1 0 0 1 0 1.414l-1.414 1.414a1 1 0 0 1 -1.414 -1.414l1.414 -1.414a1 1 0 0 1 1.414 0m-7.778 -3.222a1 1 0 0 1 1 1v2a1 1 0 0 1 -2 0v-2a1 1 0 0 1 1 -1\" />"),
    SUN_LOW(
        "sun-low",
        "<path d=\"M18.407 16.993l.01 .01a1 1 0 0 1 -1.32 1.497l-.104 -.093a1 1 0 0 1 1.414 -1.414m-11.4 0l.01 .01a1 1 0 0 1 -1.32 1.497l-.104 -.093a1 1 0 0 1 1.414 -1.414m4.993 -9.993a5 5 0 1 1 -5 5l.005 -.217a5 5 0 0 1 4.995 -4.783m-4.993 -1.407l.01 .01a1 1 0 0 1 -1.32 1.497l-.104 -.093a1 1 0 0 1 1.414 -1.414m11.4 0l.01 .01a1 1 0 0 1 -1.32 1.497l-.104 -.093a1 1 0 1 1 1.414 -1.414m-14.397 5.407a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm7.99 -8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1m8.01 8a1 1 0 0 1 .117 1.993l-.127 .007a1 1 0 0 1 -.117 -1.993zm-8.01 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1\" />"),
    SUNRISE(
        "sunrise",
        "<path d=\"M4 16a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M12 12a5 5 0 0 1 5 5a1 1 0 0 1 -1 1h-8a1 1 0 0 1 -1 -1a5 5 0 0 1 5 -5\" />\n  <path d=\"M21 16a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M6.307 9.893l.7 .7a1 1 0 0 1 -1.414 1.414l-.7 -.7a1 1 0 0 1 1.414 -1.414\" />\n  <path d=\"M19.107 9.893a1 1 0 0 1 0 1.414l-.7 .7a1 1 0 0 1 -1.414 -1.414l.7 -.7a1 1 0 0 1 1.414 0\" />\n  <path d=\"M12.707 2.293l3 3a1 1 0 1 1 -1.414 1.414l-1.293 -1.292v3.585a1 1 0 0 1 -.883 .993l-.117 .007a1 1 0 0 1 -1 -1v-3.586l-1.293 1.293a1 1 0 0 1 -1.414 -1.414l2.958 -2.96a1 1 0 0 1 .15 -.135l.127 -.08l.068 -.033l.11 -.041l.12 -.029c.3 -.055 .627 .024 .881 .278\" />\n  <path d=\"M3 20h18a1 1 0 0 1 0 2h-18a1 1 0 0 1 0 -2\" />\n  <path d=\"M12 12a5 5 0 0 1 4.583 7.002h-9.166a5 5 0 0 1 4.583 -7.002\" />"),
    SUNSET(
        "sunset",
        "<path d=\"M4 16a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M21 16a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M6.307 9.893l.7 .7a1 1 0 0 1 -1.414 1.414l-.7 -.7a1 1 0 0 1 1.414 -1.414\" />\n  <path d=\"M19.107 9.893a1 1 0 0 1 0 1.414l-.7 .7a1 1 0 0 1 -1.414 -1.414l.7 -.7a1 1 0 0 1 1.414 0\" />\n  <path d=\"M12 2a1 1 0 0 1 1 1v3.584l1.293 -1.291a1 1 0 0 1 1.32 -.083l.094 .083a1 1 0 0 1 0 1.414l-3 3a.98 .98 0 0 1 -.767 .293l-.124 -.017l-.127 -.032l-.104 -.04l-.115 -.063a1 1 0 0 1 -.151 -.114l-3.026 -3.027a1 1 0 0 1 1.414 -1.414l1.293 1.292v-3.585a1 1 0 0 1 1 -1\" />\n  <path d=\"M3 20h18a1 1 0 0 1 0 2h-18a1 1 0 0 1 0 -2\" />\n  <path d=\"M12 12a5 5 0 0 1 4.583 7.002h-9.166a5 5 0 0 1 4.583 -7.002\" />"),
    SUNSET_2(
        "sunset-2",
        "<path d=\"M4 12a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M21 12a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />\n  <path d=\"M6.307 5.893l.7 .7a1 1 0 0 1 -1.414 1.414l-.7 -.7a1 1 0 0 1 1.414 -1.414\" />\n  <path d=\"M19.107 5.893a1 1 0 0 1 0 1.414l-.7 .7a1 1 0 0 1 -1.414 -1.414l.7 -.7a1 1 0 0 1 1.414 0\" />\n  <path d=\"M12 3a1 1 0 0 1 1 1v1a1 1 0 0 1 -2 0v-1a1 1 0 0 1 1 -1\" />\n  <path d=\"M3 16h18a1 1 0 0 1 0 2h-18a1 1 0 0 1 0 -2\" />\n  <path d=\"M12 8a5 5 0 0 1 4.583 7.002h-9.166a5 5 0 0 1 4.583 -7.002\" />\n  <path d=\"M12 19a1 1 0 0 1 0 2h-5a1 1 0 0 1 0 -2z\" />\n  <path d=\"M17 19a1 1 0 0 1 0 2h-1a1 1 0 0 1 0 -2z\" />"),
    TEMPERATURE_MINUS(
        "temperature-minus",
        "<path d=\"M10 2a3 3 0 0 1 3 3v7.965l.075 .056a5 5 0 0 1 1.81 5.01l-.055 .227a5 5 0 1 1 -7.905 -5.237l.075 -.056v-7.965a3 3 0 0 1 2.824 -2.995zm12 6a1 1 0 0 1 0 2h-6a1 1 0 0 1 0 -2zm-12 -4a1 1 0 0 0 -1 1v4h2v-4a1 1 0 0 0 -1 -1\" />"),
    TEMPERATURE_PLUS(
        "temperature-plus",
        "<path d=\"M10 2a3 3 0 0 1 3 3v7.965l.075 .056a5 5 0 0 1 1.81 5.01l-.055 .227a5 5 0 1 1 -7.905 -5.237l.075 -.056v-7.965a3 3 0 0 1 2.824 -2.995zm9 3a1 1 0 0 1 1 1v2h2a1 1 0 0 1 0 2h-2v2a1 1 0 0 1 -2 0v-2h-2a1 1 0 0 1 0 -2h2v-2a1 1 0 0 1 1 -1m-9 -1a1 1 0 0 0 -1 1v4h2v-4a1 1 0 0 0 -1 -1\" />");

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

  default TablerIcon cloud() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD);
  }

  default TablerIcon cloud_bolt() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_BOLT);
  }

  default TablerIcon cloud_cancel() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_CANCEL);
  }

  default TablerIcon cloud_check() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_CHECK);
  }

  default TablerIcon cloud_code() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_CODE);
  }

  default TablerIcon cloud_cog() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_COG);
  }

  default TablerIcon cloud_dollar() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_DOLLAR);
  }

  default TablerIcon cloud_down() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_DOWN);
  }

  default TablerIcon cloud_exclamation() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_EXCLAMATION);
  }

  default TablerIcon cloud_fog() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_FOG);
  }

  default TablerIcon cloud_heart() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_HEART);
  }

  default TablerIcon cloud_minus() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_MINUS);
  }

  default TablerIcon cloud_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_OFF);
  }

  default TablerIcon cloud_pause() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_PAUSE);
  }

  default TablerIcon cloud_pin() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_PIN);
  }

  default TablerIcon cloud_plus() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_PLUS);
  }

  default TablerIcon cloud_question() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_QUESTION);
  }

  default TablerIcon cloud_rain() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_RAIN);
  }

  default TablerIcon cloud_search() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_SEARCH);
  }

  default TablerIcon cloud_share() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_SHARE);
  }

  default TablerIcon cloud_snow() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_SNOW);
  }

  default TablerIcon cloud_star() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_STAR);
  }

  default TablerIcon cloud_storm() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_STORM);
  }

  default TablerIcon cloud_up() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_UP);
  }

  default TablerIcon cloud_x() {
    return TablerIcon.create(TablerWeather.OutlineIcon.CLOUD_X);
  }

  default TablerIcon comet() {
    return TablerIcon.create(TablerWeather.OutlineIcon.COMET);
  }

  default TablerIcon flare() {
    return TablerIcon.create(TablerWeather.OutlineIcon.FLARE);
  }

  default TablerIcon flood() {
    return TablerIcon.create(TablerWeather.OutlineIcon.FLOOD);
  }

  default TablerIcon haze() {
    return TablerIcon.create(TablerWeather.OutlineIcon.HAZE);
  }

  default TablerIcon mist() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MIST);
  }

  default TablerIcon mist_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MIST_OFF);
  }

  default TablerIcon moon() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MOON);
  }

  default TablerIcon moon_2() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MOON_2);
  }

  default TablerIcon moon_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MOON_OFF);
  }

  default TablerIcon moon_stars() {
    return TablerIcon.create(TablerWeather.OutlineIcon.MOON_STARS);
  }

  default TablerIcon rainbow() {
    return TablerIcon.create(TablerWeather.OutlineIcon.RAINBOW);
  }

  default TablerIcon rainbow_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.RAINBOW_OFF);
  }

  default TablerIcon snowflake() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SNOWFLAKE);
  }

  default TablerIcon snowflake_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SNOWFLAKE_OFF);
  }

  default TablerIcon storm() {
    return TablerIcon.create(TablerWeather.OutlineIcon.STORM);
  }

  default TablerIcon storm_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.STORM_OFF);
  }

  default TablerIcon sun() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN);
  }

  default TablerIcon sun_high() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN_HIGH);
  }

  default TablerIcon sun_low() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN_LOW);
  }

  default TablerIcon sun_moon() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN_MOON);
  }

  default TablerIcon sun_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN_OFF);
  }

  default TablerIcon sun_wind() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUN_WIND);
  }

  default TablerIcon sunrise() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUNRISE);
  }

  default TablerIcon sunset() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUNSET);
  }

  default TablerIcon sunset_2() {
    return TablerIcon.create(TablerWeather.OutlineIcon.SUNSET_2);
  }

  default TablerIcon temperature() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE);
  }

  default TablerIcon temperature_celsius() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE_CELSIUS);
  }

  default TablerIcon temperature_fahrenheit() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE_FAHRENHEIT);
  }

  default TablerIcon temperature_minus() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE_MINUS);
  }

  default TablerIcon temperature_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE_OFF);
  }

  default TablerIcon temperature_plus() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TEMPERATURE_PLUS);
  }

  default TablerIcon tornado() {
    return TablerIcon.create(TablerWeather.OutlineIcon.TORNADO);
  }

  default TablerIcon uv_index() {
    return TablerIcon.create(TablerWeather.OutlineIcon.UV_INDEX);
  }

  default TablerIcon whirl() {
    return TablerIcon.create(TablerWeather.OutlineIcon.WHIRL);
  }

  default TablerIcon wind() {
    return TablerIcon.create(TablerWeather.OutlineIcon.WIND);
  }

  default TablerIcon wind_off() {
    return TablerIcon.create(TablerWeather.OutlineIcon.WIND_OFF);
  }

  default TablerIcon cloud_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.CLOUD);
  }

  default TablerIcon flare_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.FLARE);
  }

  default TablerIcon moon_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.MOON);
  }

  default TablerIcon sun_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUN);
  }

  default TablerIcon sun_high_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUN_HIGH);
  }

  default TablerIcon sun_low_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUN_LOW);
  }

  default TablerIcon sunrise_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUNRISE);
  }

  default TablerIcon sunset_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUNSET);
  }

  default TablerIcon sunset_2_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.SUNSET_2);
  }

  default TablerIcon temperature_minus_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.TEMPERATURE_MINUS);
  }

  default TablerIcon temperature_plus_filled() {
    return TablerIcon.create(TablerWeather.FilledIcon.TEMPERATURE_PLUS);
  }
}
