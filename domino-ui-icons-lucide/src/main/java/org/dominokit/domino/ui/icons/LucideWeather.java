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

/** Lucide weather catalog category. */
public interface LucideWeather {
  enum Icon implements LucideIconDefinition {
    BUBBLES(
        "bubbles",
        "<path d=\"M7.001 15.085A1.5 1.5 0 0 1 9 16.5\" />\n  <circle cx=\"18.5\" cy=\"8.5\" r=\"3.5\" />\n  <circle cx=\"7.5\" cy=\"16.5\" r=\"5.5\" />\n  <circle cx=\"7.5\" cy=\"4.5\" r=\"2.5\" />"),
    CLOUD("cloud", "<path d=\"M17.5 19H9a7 7 0 1 1 6.71-9h1.79a4.5 4.5 0 1 1 0 9Z\" />"),
    CLOUD_DRIZZLE(
        "cloud-drizzle",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"M8 19v1\" />\n  <path d=\"M8 14v1\" />\n  <path d=\"M16 19v1\" />\n  <path d=\"M16 14v1\" />\n  <path d=\"M12 21v1\" />\n  <path d=\"M12 16v1\" />"),
    CLOUD_FOG(
        "cloud-fog",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"M16 17H7\" />\n  <path d=\"M17 21H9\" />"),
    CLOUD_HAIL(
        "cloud-hail",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"M16 14v2\" />\n  <path d=\"M8 14v2\" />\n  <path d=\"M16 20h.01\" />\n  <path d=\"M8 20h.01\" />\n  <path d=\"M12 16v2\" />\n  <path d=\"M12 22h.01\" />"),
    CLOUD_LIGHTNING(
        "cloud-lightning",
        "<path d=\"M6 16.326A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 .5 8.973\" />\n  <path d=\"m13 12-3 5h4l-3 5\" />"),
    CLOUD_MOON(
        "cloud-moon",
        "<path d=\"M13 16a3 3 0 0 1 0 6H7a5 5 0 1 1 4.9-6z\" />\n  <path d=\"M18.376 14.512a6 6 0 0 0 3.461-4.127c.148-.625-.659-.97-1.248-.714a4 4 0 0 1-5.259-5.26c.255-.589-.09-1.395-.716-1.248a6 6 0 0 0-4.594 5.36\" />"),
    CLOUD_MOON_RAIN(
        "cloud-moon-rain",
        "<path d=\"M11 20v2\" />\n  <path d=\"M18.376 14.512a6 6 0 0 0 3.461-4.127c.148-.625-.659-.97-1.248-.714a4 4 0 0 1-5.259-5.26c.255-.589-.09-1.395-.716-1.248a6 6 0 0 0-4.594 5.36\" />\n  <path d=\"M3 20a5 5 0 1 1 8.9-4H13a3 3 0 0 1 2 5.24\" />\n  <path d=\"M7 19v2\" />"),
    CLOUD_OFF(
        "cloud-off",
        "<path d=\"M10.94 5.274A7 7 0 0 1 15.71 10h1.79a4.5 4.5 0 0 1 4.222 6.057\" />\n  <path d=\"M18.796 18.81A4.5 4.5 0 0 1 17.5 19H9A7 7 0 0 1 5.79 5.78\" />\n  <path d=\"m2 2 20 20\" />"),
    CLOUD_RAIN(
        "cloud-rain",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"M16 14v6\" />\n  <path d=\"M8 14v6\" />\n  <path d=\"M12 16v6\" />"),
    CLOUD_RAIN_WIND(
        "cloud-rain-wind",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"m9.2 22 3-7\" />\n  <path d=\"m9 13-3 7\" />\n  <path d=\"m17 13-3 7\" />"),
    CLOUD_SNOW(
        "cloud-snow",
        "<path d=\"M4 14.899A7 7 0 1 1 15.71 8h1.79a4.5 4.5 0 0 1 2.5 8.242\" />\n  <path d=\"M8 15h.01\" />\n  <path d=\"M8 19h.01\" />\n  <path d=\"M12 17h.01\" />\n  <path d=\"M12 21h.01\" />\n  <path d=\"M16 15h.01\" />\n  <path d=\"M16 19h.01\" />"),
    CLOUD_SUN(
        "cloud-sun",
        "<path d=\"M12 2v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />\n  <path d=\"M15.947 12.65a4 4 0 0 0-5.925-4.128\" />\n  <path d=\"M13 22H7a5 5 0 1 1 4.9-6H13a3 3 0 0 1 0 6Z\" />"),
    CLOUD_SUN_RAIN(
        "cloud-sun-rain",
        "<path d=\"M12 2v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />\n  <path d=\"M15.947 12.65a4 4 0 0 0-5.925-4.128\" />\n  <path d=\"M3 20a5 5 0 1 1 8.9-4H13a3 3 0 0 1 2 5.24\" />\n  <path d=\"M11 20v2\" />\n  <path d=\"M7 19v2\" />"),
    CLOUDY(
        "cloudy",
        "<path d=\"M17.5 12a1 1 0 1 1 0 9H9.006a7 7 0 1 1 6.702-9z\" />\n  <path d=\"M21.832 9A3 3 0 0 0 19 7h-2.207a5.5 5.5 0 0 0-10.72.61\" />"),
    DROPLET(
        "droplet",
        "<path d=\"M12 22a7 7 0 0 0 7-7c0-2-1-3.9-3-5.5s-3.5-4-4-6.5c-.5 2.5-2 4.9-4 6.5C6 11.1 5 13 5 15a7 7 0 0 0 7 7z\" />"),
    DROPLET_OFF(
        "droplet-off",
        "<path d=\"M18.715 13.186C18.29 11.858 17.384 10.607 16 9.5c-2-1.6-3.5-4-4-6.5a10.7 10.7 0 0 1-.884 2.586\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8.795 8.797A11 11 0 0 1 8 9.5C6 11.1 5 13 5 15a7 7 0 0 0 13.222 3.208\" />"),
    DROPLETS(
        "droplets",
        "<path d=\"M7 16.3c2.2 0 4-1.83 4-4.05 0-1.16-.57-2.26-1.71-3.19S7.29 6.75 7 5.3c-.29 1.45-1.14 2.84-2.29 3.76S3 11.1 3 12.25c0 2.22 1.8 4.05 4 4.05z\" />\n  <path d=\"M12.56 6.6A10.97 10.97 0 0 0 14 3.02c.5 2.5 2 4.9 4 6.5s3 3.5 3 5.5a6.98 6.98 0 0 1-11.91 4.97\" />"),
    FLAME(
        "flame",
        "<path d=\"M12 3q1 4 4 6.5t3 5.5a1 1 0 0 1-14 0 5 5 0 0 1 1-3 1 1 0 0 0 5 0c0-2-1.5-3-1.5-5q0-2 2.5-4\" />"),
    HAZE(
        "haze",
        "<path d=\"m5.2 6.2 1.4 1.4\" />\n  <path d=\"M2 13h2\" />\n  <path d=\"M20 13h2\" />\n  <path d=\"m17.4 7.6 1.4-1.4\" />\n  <path d=\"M22 17H2\" />\n  <path d=\"M22 21H2\" />\n  <path d=\"M16 13a4 4 0 0 0-8 0\" />\n  <path d=\"M12 5V2.5\" />"),
    MOON_STAR(
        "moon-star",
        "<path d=\"M18 5h4\" />\n  <path d=\"M20 3v4\" />\n  <path d=\"M20.985 12.486a9 9 0 1 1-9.473-9.472c.405-.022.617.46.402.803a6 6 0 0 0 8.268 8.268c.344-.215.825-.004.803.401\" />"),
    PARASOL(
        "parasol",
        "<path d=\"M12.5 11.134 18.196 21\" />\n  <path d=\"M20.425 5.299a10 10 0 0 0-16.941 9.78c.183.563.843.774 1.355.478L20.16 6.711c.512-.296.66-.973.264-1.413\" />\n  <path d=\"M21 21H3\" />"),
    RAINBOW(
        "rainbow",
        "<path d=\"M22 17a10 10 0 0 0-20 0\" />\n  <path d=\"M6 17a6 6 0 0 1 12 0\" />\n  <path d=\"M10 17a2 2 0 0 1 4 0\" />"),
    SNOWFLAKE(
        "snowflake",
        "<path d=\"m10 20-1.25-2.5L6 18\" />\n  <path d=\"M10 4 8.75 6.5 6 6\" />\n  <path d=\"m14 20 1.25-2.5L18 18\" />\n  <path d=\"m14 4 1.25 2.5L18 6\" />\n  <path d=\"m17 21-3-6h-4\" />\n  <path d=\"m17 3-3 6 1.5 3\" />\n  <path d=\"M2 12h6.5L10 9\" />\n  <path d=\"m20 10-1.5 2 1.5 2\" />\n  <path d=\"M22 12h-6.5L14 15\" />\n  <path d=\"m4 10 1.5 2L4 14\" />\n  <path d=\"m7 21 3-6-1.5-3\" />\n  <path d=\"m7 3 3 6h4\" />"),
    SOLAR_PANEL(
        "solar-panel",
        "<path d=\"M11 2h2\" />\n  <path d=\"m14.28 14-4.56 8\" />\n  <path d=\"m21 22-1.558-4H4.558\" />\n  <path d=\"M3 10v2\" />\n  <path d=\"M6.245 15.04A2 2 0 0 1 8 14h12a1 1 0 0 1 .864 1.505l-3.11 5.457A2 2 0 0 1 16 22H4a1 1 0 0 1-.863-1.506z\" />\n  <path d=\"M7 2a4 4 0 0 1-4 4\" />\n  <path d=\"m8.66 7.66 1.41 1.41\" />"),
    SPARKLES(
        "sparkles",
        "<path d=\"M11.017 2.814a1 1 0 0 1 1.966 0l1.051 5.558a2 2 0 0 0 1.594 1.594l5.558 1.051a1 1 0 0 1 0 1.966l-5.558 1.051a2 2 0 0 0-1.594 1.594l-1.051 5.558a1 1 0 0 1-1.966 0l-1.051-5.558a2 2 0 0 0-1.594-1.594l-5.558-1.051a1 1 0 0 1 0-1.966l5.558-1.051a2 2 0 0 0 1.594-1.594z\" />\n  <path d=\"M20 2v4\" />\n  <path d=\"M22 4h-4\" />\n  <circle cx=\"4\" cy=\"20\" r=\"2\" />"),
    STAR(
        "star",
        "<path d=\"M11.525 2.295a.53.53 0 0 1 .95 0l2.31 4.679a2.123 2.123 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904l-3.736 3.638a2.123 2.123 0 0 0-.611 1.878l.882 5.14a.53.53 0 0 1-.771.56l-4.618-2.428a2.122 2.122 0 0 0-1.973 0L6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.122 2.122 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.122 2.122 0 0 0 1.597-1.16z\" />"),
    STAR_CHECK(
        "star-check",
        "<path d=\"m19.06 12.501 2.78-2.707a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />\n  <path d=\"m15 18 2 2 4-4\" />"),
    STAR_MINUS(
        "star-minus",
        "<path d=\"M15 18h6\" />\n  <path d=\"M17.688 14a2.1 2.1 0 0 1 .416-.568l3.736-3.638a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428.027-.014\" />"),
    STAR_PLUS(
        "star-plus",
        "<path d=\"M11.013 18.582 6.396 21.01a.53.53 0 0 1-.77-.56l.881-5.139a2.12 2.12 0 0 0-.611-1.879L2.16 9.795a.53.53 0 0 1 .294-.906l5.165-.755a2.12 2.12 0 0 0 1.597-1.16l2.309-4.679a.53.53 0 0 1 .95 0l2.31 4.679a2.12 2.12 0 0 0 1.595 1.16l5.166.756a.53.53 0 0 1 .294.904L20 11.5\" />\n  <path d=\"M15 18h6\" />\n  <path d=\"M18 15v6\" />"),
    STAR_X(
        "star-x",
        "<path d=\"m15.5 15.5 5 5\" />\n  <path d=\"m20.063 11.525 1.777-1.731a.53.53 0 0 0-.294-.905l-5.166-.755a2.1 2.1 0 0 1-1.595-1.16l-2.31-4.68a.53.53 0 0 0-.95.001L9.216 6.974a2.1 2.1 0 0 1-1.597 1.16l-5.165.755a.53.53 0 0 0-.294.906l3.736 3.637a2.1 2.1 0 0 1 .611 1.879l-.88 5.139a.53.53 0 0 0 .769.56l4.617-2.428a2.1 2.1 0 0 1 .987-.243 2 2 0 0 1 .132.004\" />\n  <path d=\"m20.5 15.5-5 5\" />"),
    SUN(
        "sun",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M12 20v2\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"m17.66 17.66 1.41 1.41\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 12h2\" />\n  <path d=\"m6.34 17.66-1.41 1.41\" />\n  <path d=\"m19.07 4.93-1.41 1.41\" />"),
    SUN_DIM(
        "sun-dim",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 4h.01\" />\n  <path d=\"M20 12h.01\" />\n  <path d=\"M12 20h.01\" />\n  <path d=\"M4 12h.01\" />\n  <path d=\"M17.657 6.343h.01\" />\n  <path d=\"M17.657 17.657h.01\" />\n  <path d=\"M6.343 17.657h.01\" />\n  <path d=\"M6.343 6.343h.01\" />"),
    SUN_MEDIUM(
        "sun-medium",
        "<circle cx=\"12\" cy=\"12\" r=\"4\" />\n  <path d=\"M12 3v1\" />\n  <path d=\"M12 20v1\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M20 12h1\" />\n  <path d=\"m18.364 5.636-.707.707\" />\n  <path d=\"m6.343 17.657-.707.707\" />\n  <path d=\"m5.636 5.636.707.707\" />\n  <path d=\"m17.657 17.657.707.707\" />"),
    SUN_SNOW(
        "sun-snow",
        "<path d=\"M10 21v-1\" />\n  <path d=\"M10 4V3\" />\n  <path d=\"M10 9a3 3 0 0 0 0 6\" />\n  <path d=\"m14 20 1.25-2.5L18 18\" />\n  <path d=\"m14 4 1.25 2.5L18 6\" />\n  <path d=\"m17 21-3-6 1.5-3H22\" />\n  <path d=\"m17 3-3 6 1.5 3\" />\n  <path d=\"M2 12h1\" />\n  <path d=\"m20 10-1.5 2 1.5 2\" />\n  <path d=\"m3.64 18.36.7-.7\" />\n  <path d=\"m4.34 6.34-.7-.7\" />"),
    SUNRISE(
        "sunrise",
        "<path d=\"M12 2v8\" />\n  <path d=\"m4.93 10.93 1.41 1.41\" />\n  <path d=\"M2 18h2\" />\n  <path d=\"M20 18h2\" />\n  <path d=\"m19.07 10.93-1.41 1.41\" />\n  <path d=\"M22 22H2\" />\n  <path d=\"m8 6 4-4 4 4\" />\n  <path d=\"M16 18a4 4 0 0 0-8 0\" />"),
    SUNSET(
        "sunset",
        "<path d=\"M12 10V2\" />\n  <path d=\"m4.93 10.93 1.41 1.41\" />\n  <path d=\"M2 18h2\" />\n  <path d=\"M20 18h2\" />\n  <path d=\"m19.07 10.93-1.41 1.41\" />\n  <path d=\"M22 22H2\" />\n  <path d=\"m16 6-4 4-4-4\" />\n  <path d=\"M16 18a4 4 0 0 0-8 0\" />"),
    THERMOMETER("thermometer", "<path d=\"M14 4v10.54a4 4 0 1 1-4 0V4a2 2 0 0 1 4 0Z\" />"),
    THERMOMETER_SNOWFLAKE(
        "thermometer-snowflake",
        "<path d=\"m10 20-1.25-2.5L6 18\" />\n  <path d=\"M10 4 8.75 6.5 6 6\" />\n  <path d=\"M10.585 15H10\" />\n  <path d=\"M2 12h6.5L10 9\" />\n  <path d=\"M20 14.54a4 4 0 1 1-4 0V4a2 2 0 0 1 4 0z\" />\n  <path d=\"m4 10 1.5 2L4 14\" />\n  <path d=\"m7 21 3-6-1.5-3\" />\n  <path d=\"m7 3 3 6h2\" />"),
    THERMOMETER_SUN(
        "thermometer-sun",
        "<path d=\"M12 2v2\" />\n  <path d=\"M12 8a4 4 0 0 0-1.645 7.647\" />\n  <path d=\"M2 12h2\" />\n  <path d=\"M20 14.54a4 4 0 1 1-4 0V4a2 2 0 0 1 4 0z\" />\n  <path d=\"m4.93 4.93 1.41 1.41\" />\n  <path d=\"m6.34 17.66-1.41 1.41\" />"),
    TORNADO(
        "tornado",
        "<path d=\"M21 4H3\" />\n  <path d=\"M18 8H6\" />\n  <path d=\"M19 12H9\" />\n  <path d=\"M16 16h-6\" />\n  <path d=\"M11 20H9\" />"),
    UMBRELLA(
        "umbrella",
        "<path d=\"M12 13v7a2 2 0 0 0 4 0\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M20.992 13a1 1 0 0 0 .97-1.274 10.284 10.284 0 0 0-19.923 0A1 1 0 0 0 3 13z\" />"),
    UMBRELLA_OFF(
        "umbrella-off",
        "<path d=\"M12 13v7a2 2 0 0 0 4 0\" />\n  <path d=\"M12 2v2\" />\n  <path d=\"M18.656 13h2.336a1 1 0 0 0 .97-1.274 10.284 10.284 0 0 0-12.07-7.51\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M5.961 5.957a10.28 10.28 0 0 0-3.922 5.769A1 1 0 0 0 3 13h10\" />"),
    WAVES_ARROW_DOWN(
        "waves-arrow-down",
        "<path d=\"M12 10L12 2\" />\n  <path d=\"M16 6L12 10L8 6\" />\n  <path d=\"M2 15C2.6 15.5 3.2 16 4.5 16C7 16 7 14 9.5 14C12.1 14 11.9 16 14.5 16C17 16 17 14 19.5 14C20.8 14 21.4 14.5 22 15\" />\n  <path d=\"M2 21C2.6 21.5 3.2 22 4.5 22C7 22 7 20 9.5 20C12.1 20 11.9 22 14.5 22C17 22 17 20 19.5 20C20.8 20 21.4 20.5 22 21\" />"),
    WAVES_ARROW_UP(
        "waves-arrow-up",
        "<path d=\"M12 2v8\" />\n  <path d=\"M2 15c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"M2 21c.6.5 1.2 1 2.5 1 2.5 0 2.5-2 5-2 2.6 0 2.4 2 5 2 2.5 0 2.5-2 5-2 1.3 0 1.9.5 2.5 1\" />\n  <path d=\"m8 6 4-4 4 4\" />"),
    WAVES_HORIZONTAL(
        "waves-horizontal",
        "<path d=\"M2 12q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 19q2.5 2 5 0t5 0 5 0 5 0\" />\n  <path d=\"M2 5q2.5 2 5 0t5 0 5 0 5 0\" />"),
    WAVES_VERTICAL(
        "waves-vertical",
        "<path d=\"M12 2q2 2.5 0 5t0 5 0 5 0 5\" />\n  <path d=\"M19 2q2 2.5 0 5t0 5 0 5 0 5\" />\n  <path d=\"M5 2q2 2.5 0 5t0 5 0 5 0 5\" />"),
    WIND(
        "wind",
        "<path d=\"M12.8 19.6A2 2 0 1 0 14 16H2\" />\n  <path d=\"M17.5 8a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"M9.8 4.4A2 2 0 1 1 11 8H2\" />"),
    WIND_ARROW_DOWN(
        "wind-arrow-down",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 4 4-4\" />"),
    WIND_ARROW_UP(
        "wind-arrow-up",
        "<path d=\"M10 2v8\" />\n  <path d=\"M12.8 21.6A2 2 0 1 0 14 18H2\" />\n  <path d=\"M17.5 10a2.5 2.5 0 1 1 2 4H2\" />\n  <path d=\"m6 6 4 -4 4 4\" />"),
    ZAP(
        "zap",
        "<path d=\"M15.914 4a1.5 1.5 0 00-2.474-1.561l-9 9A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l9-9A1.5 1.5 0 0018.5 10h-3.997a.5.5 0 01-.472-.667z\" />"),
    ZAP_OFF(
        "zap-off",
        "<path d=\"M10.768 5.111 13.44 2.44a1.5 1.5 0 012.474 1.561l-1.633 4.625\" />\n  <path d=\"m18.889 13.232.672-.672A1.5 1.5 0 0018.5 10h-2.844\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m7.94 7.94-3.5 3.499A1.5 1.5 0 005.5 14h4.002a.5.5 0 01.471.666L8.086 20a1.5 1.5 0 002.475 1.56l5.5-5.5\" />");

    private final String catalogName;
    private final String svg;

    Icon(String catalogName, String svg) {
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

  // Icon factories for this category.
  default LucideIcon bubbles() {
    return LucideIcon.create(Icon.BUBBLES);
  }

  default LucideIcon cloud() {
    return LucideIcon.create(Icon.CLOUD);
  }

  default LucideIcon cloud_drizzle() {
    return LucideIcon.create(Icon.CLOUD_DRIZZLE);
  }

  default LucideIcon cloud_fog() {
    return LucideIcon.create(Icon.CLOUD_FOG);
  }

  default LucideIcon cloud_hail() {
    return LucideIcon.create(Icon.CLOUD_HAIL);
  }

  default LucideIcon cloud_lightning() {
    return LucideIcon.create(Icon.CLOUD_LIGHTNING);
  }

  default LucideIcon cloud_moon() {
    return LucideIcon.create(Icon.CLOUD_MOON);
  }

  default LucideIcon cloud_moon_rain() {
    return LucideIcon.create(Icon.CLOUD_MOON_RAIN);
  }

  default LucideIcon cloud_off_weather() {
    return LucideIcon.create(Icon.CLOUD_OFF);
  }

  default LucideIcon cloud_rain() {
    return LucideIcon.create(Icon.CLOUD_RAIN);
  }

  default LucideIcon cloud_rain_wind() {
    return LucideIcon.create(Icon.CLOUD_RAIN_WIND);
  }

  default LucideIcon cloud_snow() {
    return LucideIcon.create(Icon.CLOUD_SNOW);
  }

  default LucideIcon cloud_sun() {
    return LucideIcon.create(Icon.CLOUD_SUN);
  }

  default LucideIcon cloud_sun_rain() {
    return LucideIcon.create(Icon.CLOUD_SUN_RAIN);
  }

  default LucideIcon cloudy() {
    return LucideIcon.create(Icon.CLOUDY);
  }

  default LucideIcon droplet_weather() {
    return LucideIcon.create(Icon.DROPLET);
  }

  default LucideIcon droplet_off_weather() {
    return LucideIcon.create(Icon.DROPLET_OFF);
  }

  default LucideIcon droplets() {
    return LucideIcon.create(Icon.DROPLETS);
  }

  default LucideIcon flame_weather() {
    return LucideIcon.create(Icon.FLAME);
  }

  default LucideIcon haze() {
    return LucideIcon.create(Icon.HAZE);
  }

  default LucideIcon moon_star_weather() {
    return LucideIcon.create(Icon.MOON_STAR);
  }

  default LucideIcon parasol_weather() {
    return LucideIcon.create(Icon.PARASOL);
  }

  default LucideIcon rainbow() {
    return LucideIcon.create(Icon.RAINBOW);
  }

  default LucideIcon snowflake_weather() {
    return LucideIcon.create(Icon.SNOWFLAKE);
  }

  default LucideIcon solar_panel_weather() {
    return LucideIcon.create(Icon.SOLAR_PANEL);
  }

  default LucideIcon sparkles_weather() {
    return LucideIcon.create(Icon.SPARKLES);
  }

  default LucideIcon star_weather() {
    return LucideIcon.create(Icon.STAR);
  }

  default LucideIcon star_check_weather() {
    return LucideIcon.create(Icon.STAR_CHECK);
  }

  default LucideIcon star_minus_weather() {
    return LucideIcon.create(Icon.STAR_MINUS);
  }

  default LucideIcon star_plus_weather() {
    return LucideIcon.create(Icon.STAR_PLUS);
  }

  default LucideIcon star_x_weather() {
    return LucideIcon.create(Icon.STAR_X);
  }

  default LucideIcon sun_weather() {
    return LucideIcon.create(Icon.SUN);
  }

  default LucideIcon sun_dim_weather() {
    return LucideIcon.create(Icon.SUN_DIM);
  }

  default LucideIcon sun_medium_weather() {
    return LucideIcon.create(Icon.SUN_MEDIUM);
  }

  default LucideIcon sun_snow() {
    return LucideIcon.create(Icon.SUN_SNOW);
  }

  default LucideIcon sunrise_weather() {
    return LucideIcon.create(Icon.SUNRISE);
  }

  default LucideIcon sunset_weather() {
    return LucideIcon.create(Icon.SUNSET);
  }

  default LucideIcon thermometer() {
    return LucideIcon.create(Icon.THERMOMETER);
  }

  default LucideIcon thermometer_snowflake() {
    return LucideIcon.create(Icon.THERMOMETER_SNOWFLAKE);
  }

  default LucideIcon thermometer_sun() {
    return LucideIcon.create(Icon.THERMOMETER_SUN);
  }

  default LucideIcon tornado() {
    return LucideIcon.create(Icon.TORNADO);
  }

  default LucideIcon umbrella() {
    return LucideIcon.create(Icon.UMBRELLA);
  }

  default LucideIcon umbrella_off() {
    return LucideIcon.create(Icon.UMBRELLA_OFF);
  }

  default LucideIcon waves_arrow_down_weather() {
    return LucideIcon.create(Icon.WAVES_ARROW_DOWN);
  }

  default LucideIcon waves_arrow_up_weather() {
    return LucideIcon.create(Icon.WAVES_ARROW_UP);
  }

  default LucideIcon waves_horizontal_weather() {
    return LucideIcon.create(Icon.WAVES_HORIZONTAL);
  }

  default LucideIcon waves_vertical_weather() {
    return LucideIcon.create(Icon.WAVES_VERTICAL);
  }

  default LucideIcon wind_weather() {
    return LucideIcon.create(Icon.WIND);
  }

  default LucideIcon wind_arrow_down_weather() {
    return LucideIcon.create(Icon.WIND_ARROW_DOWN);
  }

  default LucideIcon wind_arrow_up_weather() {
    return LucideIcon.create(Icon.WIND_ARROW_UP);
  }

  default LucideIcon zap_weather() {
    return LucideIcon.create(Icon.ZAP);
  }

  default LucideIcon zap_off_weather() {
    return LucideIcon.create(Icon.ZAP_OFF);
  }
}
