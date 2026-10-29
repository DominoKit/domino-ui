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

/** Tabler Mood catalog category. */
public interface TablerMood {
  enum OutlineIcon implements TablerIconDefinition {
    MOOD_ANGRY(
        "mood-angry",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M8 9l2 1\" />\n  <path d=\"M16 9l-2 1\" />\n  <path d=\"M14.5 16.05a3.5 3.5 0 0 0 -5 0\" />"),
    MOOD_ANNOYED(
        "mood-annoyed",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M15 14c-2 0 -3 1 -3.5 2.05\" />\n  <path d=\"M9 10h-.01\" />\n  <path d=\"M15 10h-.01\" />"),
    MOOD_ANNOYED_2(
        "mood-annoyed-2",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M15 14c-2 0 -3 1 -3.5 2.05\" />\n  <path d=\"M10 9.25c-.5 1 -2.5 1 -3 0\" />\n  <path d=\"M17 9.25c-.5 1 -2.5 1 -3 0\" />"),
    MOOD_BITCOIN(
        "mood-bitcoin",
        "<path d=\"M17 21v-6m2 0v-1.5m0 9v-1.5m-2 -3h3m-1 0h.5a1.5 1.5 0 0 1 0 3h-3.5m3 -3h.5a1.5 1.5 0 0 0 0 -3h-3.5\" />\n  <path d=\"M20.87 10.48a9 9 0 1 0 -7.876 10.465\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1c.357 0 .709 -.052 1.043 -.151\" />"),
    MOOD_BOY(
        "mood-boy",
        "<path d=\"M17 4.5a9 9 0 0 1 3.864 5.89a2.5 2.5 0 0 1 -.29 4.36a9 9 0 0 1 -17.137 0a2.5 2.5 0 0 1 -.29 -4.36a9 9 0 0 1 3.746 -5.81\" />\n  <path d=\"M9.5 16a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M8.5 2c1.5 1 2.5 3.5 2.5 5\" />\n  <path d=\"M12.5 2c1.5 2 2 3.5 2 5\" />\n  <path d=\"M9 12l.01 0\" />\n  <path d=\"M15 12l.01 0\" />"),
    MOOD_CHECK(
        "mood-check",
        "<path d=\"M20.925 13.163a8.998 8.998 0 0 0 -8.925 -10.163a9 9 0 0 0 0 18\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1s1.842 -.36 2.5 -1\" />\n  <path d=\"M15 19l2 2l4 -4\" />"),
    MOOD_COG(
        "mood-cog",
        "<path d=\"M21 12a9 9 0 1 0 -8.983 9\" />\n  <path d=\"M16.001 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M18.001 14.5v1.5\" />\n  <path d=\"M18.001 20v1.5\" />\n  <path d=\"M21.032 16.25l-1.299 .75\" />\n  <path d=\"M16.27 19l-1.3 .75\" />\n  <path d=\"M14.97 16.25l1.3 .75\" />\n  <path d=\"M19.733 19l1.3 .75\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1\" />"),
    MOOD_CONFUSED(
        "mood-confused",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 16a10 10 0 0 1 6 -1.5\" />"),
    MOOD_CRAZY_HAPPY(
        "mood-crazy-happy",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M7 8.5l3 3\" />\n  <path d=\"M7 11.5l3 -3\" />\n  <path d=\"M14 8.5l3 3\" />\n  <path d=\"M14 11.5l3 -3\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />"),
    MOOD_CRY(
        "mood-cry",
        "<path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 15.25a3.5 3.5 0 0 1 5 0\" />\n  <path d=\"M17.566 17.606a2 2 0 1 0 2.897 .03l-1.463 -1.636l-1.434 1.606\" />\n  <path d=\"M20.865 13.517a8.937 8.937 0 0 0 .135 -1.517a9 9 0 1 0 -9 9c.69 0 1.36 -.076 2 -.222\" />"),
    MOOD_DOLLAR(
        "mood-dollar",
        "<path d=\"M20.87 10.48a9 9 0 1 0 -7.876 10.465\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1c.357 0 .709 -.052 1.043 -.151\" />\n  <path d=\"M21 15h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M19 21v1m0 -8v1\" />"),
    MOOD_EDIT(
        "mood-edit",
        "<path d=\"M20.955 11.104a9 9 0 1 0 -9.895 9.847\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .672 1.56 1 2.5 1c.126 0 .251 -.006 .376 -.018\" />\n  <path d=\"M18.42 15.61a2.1 2.1 0 0 1 2.97 2.97l-3.39 3.42h-3v-3l3.42 -3.39\" />"),
    MOOD_EMPTY(
        "mood-empty",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9 15l6 0\" />"),
    MOOD_HAPPY(
        "mood-happy",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 9l.01 0\" />\n  <path d=\"M15 9l.01 0\" />\n  <path d=\"M8 13a4 4 0 1 0 8 0h-8\" />"),
    MOOD_HEART(
        "mood-heart",
        "<path d=\"M21 12a9 9 0 1 0 -8.012 8.946\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15a3.59 3.59 0 0 0 2.774 .99\" />\n  <path d=\"M18.994 21.5l2.518 -2.58a1.74 1.74 0 0 0 .004 -2.413a1.627 1.627 0 0 0 -2.346 -.005l-.168 .172l-.168 -.172a1.627 1.627 0 0 0 -2.346 -.004a1.74 1.74 0 0 0 -.004 2.412l2.51 2.59\" />"),
    MOOD_KID(
        "mood-kid",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M12 3a2 2 0 0 0 0 4\" />"),
    MOOD_LOOK_DOWN(
        "mood-look-down",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M9 13h.01\" />\n  <path d=\"M15 13h.01\" />\n  <path d=\"M11 17h2\" />"),
    MOOD_LOOK_LEFT(
        "mood-look-left",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M4 15h4\" />"),
    MOOD_LOOK_RIGHT(
        "mood-look-right",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M15 9h-.01\" />\n  <path d=\"M20 15h-4\" />"),
    MOOD_LOOK_UP(
        "mood-look-up",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M9 8h.01\" />\n  <path d=\"M15 8h.01\" />\n  <path d=\"M11 12h2\" />"),
    MOOD_MINUS(
        "mood-minus",
        "<path d=\"M20.48 15.014a9 9 0 1 0 -7.956 5.97\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1s1.842 -.36 2.5 -1\" />"),
    MOOD_NERD(
        "mood-nerd",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M6 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 10a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M3.5 9h2.5\" />\n  <path d=\"M18 9h2.5\" />\n  <path d=\"M10 9.5c1.333 -1.333 2.667 -1.333 4 0\" />"),
    MOOD_NERVOUS(
        "mood-nervous",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M8 16l2 -2l2 2l2 -2l2 2\" />"),
    MOOD_NEUTRAL(
        "mood-neutral",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />"),
    MOOD_OFF(
        "mood-off",
        "<path d=\"M5.634 5.638a9 9 0 0 0 12.732 12.724m1.679 -2.322a9 9 0 0 0 -12.08 -12.086\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M3 3l18 18\" />"),
    MOOD_PIN(
        "mood-pin",
        "<path d=\"M21 12a9 9 0 1 0 -8.352 8.977\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .672 1.56 1 2.5 1c.102 0 .203 -.004 .304 -.012\" />\n  <path d=\"M21.121 20.121a3 3 0 1 0 -4.242 0c.418 .419 1.125 1.045 2.121 1.879c1.051 -.89 1.759 -1.516 2.121 -1.879\" />\n  <path d=\"M19 18v.01\" />"),
    MOOD_PLUS(
        "mood-plus",
        "<path d=\"M20.985 12.528a9 9 0 1 0 -8.45 8.456\" />\n  <path d=\"M16 19h6\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1s1.842 -.36 2.5 -1\" />"),
    MOOD_PUZZLED(
        "mood-puzzled",
        "<path d=\"M14.986 3.51a9 9 0 1 0 1.514 16.284c2.489 -1.437 4.181 -3.978 4.5 -6.794\" />\n  <path d=\"M10 10h.01\" />\n  <path d=\"M14 8h.01\" />\n  <path d=\"M12 15c1 -1.333 2 -2 3 -2\" />\n  <path d=\"M20 9v.01\" />\n  <path d=\"M20 6a2.003 2.003 0 0 0 .914 -3.782a1.98 1.98 0 0 0 -2.414 .483\" />"),
    MOOD_SAD(
        "mood-sad",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 15.25a3.5 3.5 0 0 1 5 0\" />"),
    MOOD_SAD_2(
        "mood-sad-2",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14.5 16.05a3.5 3.5 0 0 0 -5 0\" />\n  <path d=\"M10 9.25c-.5 1 -2.5 1 -3 0\" />\n  <path d=\"M17 9.25c-.5 1 -2.5 1 -3 0\" />"),
    MOOD_SAD_DIZZY(
        "mood-sad-dizzy",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14.5 16.05a3.5 3.5 0 0 0 -5 0\" />\n  <path d=\"M8 9l2 2\" />\n  <path d=\"M10 9l-2 2\" />\n  <path d=\"M14 9l2 2\" />\n  <path d=\"M16 9l-2 2\" />"),
    MOOD_SAD_SQUINT(
        "mood-sad-squint",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14.5 16.05a3.5 3.5 0 0 0 -5 0\" />\n  <path d=\"M8.5 11.5l1.5 -1.5l-1.5 -1.5\" />\n  <path d=\"M15.5 11.5l-1.5 -1.5l1.5 -1.5\" />"),
    MOOD_SEARCH(
        "mood-search",
        "<path d=\"M21 12a9 9 0 1 0 -9 9\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .672 1.56 1 2.5 1\" />\n  <path d=\"M15 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M20.2 20.2l1.8 1.8\" />"),
    MOOD_SHARE(
        "mood-share",
        "<path d=\"M20.942 13.018a9 9 0 1 0 -8.942 7.982\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .672 1.56 1 2.5 1c.213 0 .424 -.017 .63 -.05\" />\n  <path d=\"M16 22l5 -5\" />\n  <path d=\"M21 21.5v-4.5h-4.5\" />"),
    MOOD_SICK(
        "mood-sick",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M9 10h-.01\" />\n  <path d=\"M15 10h-.01\" />\n  <path d=\"M8 16l1 -1l1.5 1l1.5 -1l1.5 1l1.5 -1l1 1\" />"),
    MOOD_SILENCE(
        "mood-silence",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M9 10h-.01\" />\n  <path d=\"M15 10h-.01\" />\n  <path d=\"M8 15h8\" />\n  <path d=\"M9 14v2\" />\n  <path d=\"M12 14v2\" />\n  <path d=\"M15 14v2\" />"),
    MOOD_SING(
        "mood-sing",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 9h.01\" />\n  <path d=\"M13 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    MOOD_SMILE(
        "mood-smile",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />"),
    MOOD_SMILE_BEAM(
        "mood-smile-beam",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M10 10c-.5 -1 -2.5 -1 -3 0\" />\n  <path d=\"M17 10c-.5 -1 -2.5 -1 -3 0\" />\n  <path d=\"M14.5 15a3.5 3.5 0 0 1 -5 0\" />"),
    MOOD_SMILE_DIZZY(
        "mood-smile-dizzy",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14.5 15a3.5 3.5 0 0 1 -5 0\" />\n  <path d=\"M8 9l2 2\" />\n  <path d=\"M10 9l-2 2\" />\n  <path d=\"M14 9l2 2\" />\n  <path d=\"M16 9l-2 2\" />"),
    MOOD_SPARK(
        "mood-spark",
        "<path d=\"M21 12a9 9 0 1 0 -8.994 9\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M19 22.5a4.75 4.75 0 0 1 3.5 -3.5a4.75 4.75 0 0 1 -3.5 -3.5a4.75 4.75 0 0 1 -3.5 3.5a4.75 4.75 0 0 1 3.5 3.5\" />"),
    MOOD_SURPRISED(
        "mood-surprised",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 9l.01 0\" />\n  <path d=\"M15 9l.01 0\" />\n  <path d=\"M10 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    MOOD_TONGUE(
        "mood-tongue",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10l.01 0\" />\n  <path d=\"M15 10l.01 0\" />\n  <path d=\"M10 14v2a2 2 0 0 0 4 0v-2m1.5 0h-7\" />"),
    MOOD_TONGUE_WINK(
        "mood-tongue-wink",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M10 14v2a2 2 0 0 0 4 0v-2\" />\n  <path d=\"M15.5 14h-7\" />\n  <path d=\"M17 10c-.5 -1 -2.5 -1 -3 0\" />"),
    MOOD_TONGUE_WINK_2(
        "mood-tongue-wink-2",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M15 10h-.01\" />\n  <path d=\"M10 14v2a2 2 0 1 0 4 0v-2m1.5 0h-7\" />\n  <path d=\"M7 10c.5 -1 2.5 -1 3 0\" />"),
    MOOD_UNAMUSED(
        "mood-unamused",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M11 16l4 -1.5\" />\n  <path d=\"M10 10c-.5 -1 -2.5 -1 -3 0\" />\n  <path d=\"M17 10c-.5 -1 -2.5 -1 -3 0\" />"),
    MOOD_UP(
        "mood-up",
        "<path d=\"M20.984 12.536a9 9 0 1 0 -8.463 8.449\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"M22 19l-3 -3l-3 3\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1s1.842 -.36 2.5 -1\" />"),
    MOOD_WINK(
        "mood-wink",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15a3.5 3.5 0 0 0 5 0\" />\n  <path d=\"M8.5 8.5l1.5 1.5l-1.5 1.5\" />"),
    MOOD_WINK_2(
        "mood-wink-2",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M9 10h-.01\" />\n  <path d=\"M14.5 15a3.5 3.5 0 0 1 -5 0\" />\n  <path d=\"M15.5 8.5l-1.5 1.5l1.5 1.5\" />"),
    MOOD_WRRR(
        "mood-wrrr",
        "<path d=\"M12 21a9 9 0 1 1 0 -18a9 9 0 0 1 0 18\" />\n  <path d=\"M8 16l1 -1l1.5 1l1.5 -1l1.5 1l1.5 -1l1 1\" />\n  <path d=\"M8.5 11.5l1.5 -1.5l-1.5 -1.5\" />\n  <path d=\"M15.5 11.5l-1.5 -1.5l1.5 -1.5\" />"),
    MOOD_X(
        "mood-x",
        "<path d=\"M20.983 12.556a9 9 0 1 0 -8.433 8.427\" />\n  <path d=\"M9 10h.01\" />\n  <path d=\"M15 10h.01\" />\n  <path d=\"M9.5 15c.658 .64 1.56 1 2.5 1c.194 0 .386 -.015 .574 -.045\" />\n  <path d=\"M21.5 21.5l-5 -5\" />\n  <path d=\"M16.5 21.5l5 -5\" />"),
    MOOD_XD(
        "mood-xd",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />\n  <path d=\"M9 14h6a3 3 0 0 1 -6 0\" />\n  <path d=\"M9 8l6 3\" />\n  <path d=\"M9 11l6 -3\" />");

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
    MOOD_ANGRY(
        "mood-angry",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10a10 10 0 1 1 0 -20m0 12a4.5 4.5 0 0 0 -3.214 1.35a1 1 0 1 0 1.428 1.4a2.5 2.5 0 0 1 3.572 0a1 1 0 0 0 1.428 -1.4a4.5 4.5 0 0 0 -3.214 -1.35m-3.553 -5.895a1 1 0 0 0 -.894 1.788l2 1a1 1 0 0 0 .894 -1.788zm8.447 .447a1 1 0 0 0 -1.341 -.447l-2 1a1 1 0 0 0 .894 1.788l2 -1a1 1 0 0 0 .447 -1.341\" />"),
    MOOD_CONFUSED(
        "mood-confused",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.43 10.162a11 11 0 0 0 -6.6 1.65a1 1 0 0 0 1.06 1.696a9 9 0 0 1 5.4 -1.35a1 1 0 0 0 .14 -1.996zm-6.56 -4.502l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm6 0l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    MOOD_CRAZY_HAPPY(
        "mood-crazy-happy",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-1.8 10.946a1 1 0 0 0 -1.414 .014a2.5 2.5 0 0 1 -3.572 0a1 1 0 0 0 -1.428 1.4a4.5 4.5 0 0 0 6.428 0a1 1 0 0 0 -.014 -1.414m-7.493 -6.493a1 1 0 0 0 -1.414 1.414l.792 .793l-.792 .793a1 1 0 0 0 1.414 1.414l.793 -.792l.793 .792a1 1 0 1 0 1.414 -1.414l-.792 -.793l.792 -.793a1 1 0 1 0 -1.414 -1.414l-.793 .792zm7 0a1 1 0 0 0 -1.414 1.414l.792 .793l-.792 .793a1 1 0 0 0 1.414 1.414l.793 -.792l.793 .792a1 1 0 0 0 1.414 -1.414l-.792 -.793l.792 -.793a1 1 0 1 0 -1.414 -1.414l-.793 .792z\" />"),
    MOOD_EMPTY(
        "mood-empty",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2 10.66h-6l-.117 .007a1 1 0 0 0 0 1.986l.117 .007h6l.117 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm-5.99 -5l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm6 0l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    MOOD_HAPPY(
        "mood-happy",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2 9.66h-6a1 1 0 0 0 -1 1v.05a3.975 3.975 0 0 0 3.777 3.97l.227 .005a4.026 4.026 0 0 0 3.99 -3.79l.006 -.206a1 1 0 0 0 -1 -1.029zm-5.99 -5l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993zm6 0l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    MOOD_KID(
        "mood-kid",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 7.046 -9.232a3 3 0 0 0 2.949 3.556a1 1 0 0 0 0 -2l-.117 -.007a1 1 0 0 1 .117 -1.993c1.726 0 3.453 .447 5 1.34zm-1.8 10.946a1 1 0 0 0 -1.414 .014a2.5 2.5 0 0 1 -3.572 0a1 1 0 0 0 -1.428 1.4a4.5 4.5 0 0 0 6.428 0a1 1 0 0 0 -.014 -1.414zm-6.19 -5.286l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993zm6 0l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    MOOD_NEUTRAL(
        "mood-neutral",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-7.99 5.66l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm6 0l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    MOOD_SAD(
        "mood-sad",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-5 9.86a4.5 4.5 0 0 0 -3.214 1.35a1 1 0 1 0 1.428 1.4a2.5 2.5 0 0 1 3.572 0a1 1 0 0 0 1.428 -1.4a4.5 4.5 0 0 0 -3.214 -1.35zm-2.99 -4.2l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007zm6 0l-.127 .007a1 1 0 0 0 0 1.986l.117 .007l.127 -.007a1 1 0 0 0 0 -1.986l-.117 -.007z\" />"),
    MOOD_SMILE(
        "mood-smile",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-1.8 10.946a1 1 0 0 0 -1.414 .014a2.5 2.5 0 0 1 -3.572 0a1 1 0 0 0 -1.428 1.4a4.5 4.5 0 0 0 6.428 0a1 1 0 0 0 -.014 -1.414zm-6.19 -5.286l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993zm6 0l-.127 .007a1 1 0 0 0 .117 1.993l.127 -.007a1 1 0 0 0 -.117 -1.993z\" />"),
    MOOD_WRRR(
        "mood-wrrr",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10s-4.477 10 -10 10a10 10 0 1 1 0 -20m3.707 12.293a1 1 0 0 0 -1.262 -.125l-.945 .63l-.945 -.63l-.116 -.066a1 1 0 0 0 -.994 .066l-.945 .63l-.945 -.63a1 1 0 0 0 -1.262 .125l-1 1a1 1 0 0 0 0 1.414l.094 .083a1 1 0 0 0 1.32 -.083l.42 -.42l.818 .545l.116 .066a1 1 0 0 0 .994 -.066l.945 -.63l.945 .63l.116 .066a1 1 0 0 0 .994 -.066l.817 -.545l.42 .42a1 1 0 0 0 1.415 -1.414zm-6.5 -6.5a1 1 0 0 0 -1.414 0l-.083 .094a1 1 0 0 0 .083 1.32l.792 .793l-.792 .793a1 1 0 0 0 1.414 1.414l1.5 -1.5a1 1 0 0 0 0 -1.414zm7 0a1 1 0 0 0 -1.414 0l-1.5 1.5a1 1 0 0 0 0 1.414l1.5 1.5a1 1 0 0 0 1.414 0l.083 -.094a1 1 0 0 0 -.083 -1.32l-.792 -.793l.792 -.793a1 1 0 0 0 0 -1.414\" />");

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

  default TablerIcon mood_angry() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_ANGRY);
  }

  default TablerIcon mood_annoyed() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_ANNOYED);
  }

  default TablerIcon mood_annoyed_2() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_ANNOYED_2);
  }

  default TablerIcon mood_bitcoin() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_BITCOIN);
  }

  default TablerIcon mood_boy() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_BOY);
  }

  default TablerIcon mood_check() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_CHECK);
  }

  default TablerIcon mood_cog() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_COG);
  }

  default TablerIcon mood_confused() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_CONFUSED);
  }

  default TablerIcon mood_crazy_happy() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_CRAZY_HAPPY);
  }

  default TablerIcon mood_cry() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_CRY);
  }

  default TablerIcon mood_dollar() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_DOLLAR);
  }

  default TablerIcon mood_edit() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_EDIT);
  }

  default TablerIcon mood_empty() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_EMPTY);
  }

  default TablerIcon mood_happy() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_HAPPY);
  }

  default TablerIcon mood_heart() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_HEART);
  }

  default TablerIcon mood_kid() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_KID);
  }

  default TablerIcon mood_look_down() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_LOOK_DOWN);
  }

  default TablerIcon mood_look_left() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_LOOK_LEFT);
  }

  default TablerIcon mood_look_right() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_LOOK_RIGHT);
  }

  default TablerIcon mood_look_up() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_LOOK_UP);
  }

  default TablerIcon mood_minus() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_MINUS);
  }

  default TablerIcon mood_nerd() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_NERD);
  }

  default TablerIcon mood_nervous() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_NERVOUS);
  }

  default TablerIcon mood_neutral() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_NEUTRAL);
  }

  default TablerIcon mood_off() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_OFF);
  }

  default TablerIcon mood_pin() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_PIN);
  }

  default TablerIcon mood_plus() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_PLUS);
  }

  default TablerIcon mood_puzzled() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_PUZZLED);
  }

  default TablerIcon mood_sad() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SAD);
  }

  default TablerIcon mood_sad_2() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SAD_2);
  }

  default TablerIcon mood_sad_dizzy() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SAD_DIZZY);
  }

  default TablerIcon mood_sad_squint() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SAD_SQUINT);
  }

  default TablerIcon mood_search() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SEARCH);
  }

  default TablerIcon mood_share() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SHARE);
  }

  default TablerIcon mood_sick() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SICK);
  }

  default TablerIcon mood_silence() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SILENCE);
  }

  default TablerIcon mood_sing() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SING);
  }

  default TablerIcon mood_smile() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SMILE);
  }

  default TablerIcon mood_smile_beam() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SMILE_BEAM);
  }

  default TablerIcon mood_smile_dizzy() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SMILE_DIZZY);
  }

  default TablerIcon mood_spark() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SPARK);
  }

  default TablerIcon mood_surprised() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_SURPRISED);
  }

  default TablerIcon mood_tongue() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_TONGUE);
  }

  default TablerIcon mood_tongue_wink() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_TONGUE_WINK);
  }

  default TablerIcon mood_tongue_wink_2() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_TONGUE_WINK_2);
  }

  default TablerIcon mood_unamused() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_UNAMUSED);
  }

  default TablerIcon mood_up() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_UP);
  }

  default TablerIcon mood_wink() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_WINK);
  }

  default TablerIcon mood_wink_2() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_WINK_2);
  }

  default TablerIcon mood_wrrr() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_WRRR);
  }

  default TablerIcon mood_x() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_X);
  }

  default TablerIcon mood_xd() {
    return TablerIcon.create(TablerMood.OutlineIcon.MOOD_XD);
  }

  default TablerIcon mood_angry_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_ANGRY);
  }

  default TablerIcon mood_confused_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_CONFUSED);
  }

  default TablerIcon mood_crazy_happy_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_CRAZY_HAPPY);
  }

  default TablerIcon mood_empty_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_EMPTY);
  }

  default TablerIcon mood_happy_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_HAPPY);
  }

  default TablerIcon mood_kid_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_KID);
  }

  default TablerIcon mood_neutral_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_NEUTRAL);
  }

  default TablerIcon mood_sad_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_SAD);
  }

  default TablerIcon mood_smile_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_SMILE);
  }

  default TablerIcon mood_wrrr_filled() {
    return TablerIcon.create(TablerMood.FilledIcon.MOOD_WRRR);
  }
}
