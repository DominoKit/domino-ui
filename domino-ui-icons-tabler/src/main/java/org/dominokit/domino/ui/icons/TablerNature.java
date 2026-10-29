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

/** Tabler Nature catalog category. */
public interface TablerNature {
  enum OutlineIcon implements TablerIconDefinition {
    ACORN(
        "acorn",
        "<path d=\"M18 10l-.45 4.1a8.36 8.36 0 0 1 -5.18 6.83a1 1 0 0 1 -.74 0a8.36 8.36 0 0 1 -5.18 -6.83l-.45 -4.1\" />\n  <path d=\"M13 3a4.9 4.9 0 0 0 -1 3\" />\n  <path d=\"M8 6h8a3 3 0 0 1 3 3a1 1 0 0 1 -1 1h-12a1 1 0 0 1 -1 -1a3 3 0 0 1 3 -3\" />"),
    ALIEN(
        "alien",
        "<path d=\"M11 17a2.5 2.5 0 0 0 2 0\" />\n  <path d=\"M12 3c-4.664 0 -7.396 2.331 -7.862 5.595a11.816 11.816 0 0 0 2 8.592a10.777 10.777 0 0 0 3.199 3.064c1.666 1 3.664 1 5.33 0a10.777 10.777 0 0 0 3.199 -3.064a11.89 11.89 0 0 0 2 -8.592c-.466 -3.265 -3.198 -5.595 -7.862 -5.595l-.004 0\" />\n  <path d=\"M8 11l2 2\" />\n  <path d=\"M16 11l-2 2\" />"),
    ATOM(
        "atom",
        "<path d=\"M12 12v.01\" />\n  <path d=\"M19.071 4.929c-1.562 -1.562 -6 .337 -9.9 4.243c-3.905 3.905 -5.804 8.337 -4.242 9.9c1.562 1.561 6 -.338 9.9 -4.244c3.905 -3.905 5.804 -8.337 4.242 -9.9\" />\n  <path d=\"M4.929 4.929c-1.562 1.562 .337 6 4.243 9.9c3.905 3.905 8.337 5.804 9.9 4.242c1.561 -1.562 -.338 -6 -4.244 -9.9c-3.905 -3.905 -8.337 -5.804 -9.9 -4.242\" />"),
    ATOM_2(
        "atom-2",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 21l0 .01\" />\n  <path d=\"M3 9l0 .01\" />\n  <path d=\"M21 9l0 .01\" />\n  <path d=\"M8 20.1a9 9 0 0 1 -5 -7.1\" />\n  <path d=\"M16 20.1a9 9 0 0 0 5 -7.1\" />\n  <path d=\"M6.2 5a9 9 0 0 1 11.4 0\" />"),
    ATOM_OFF(
        "atom-off",
        "<path d=\"M12 12v.01\" />\n  <path d=\"M9.172 9.172c-3.906 3.905 -5.805 8.337 -4.243 9.9c1.562 1.561 6 -.338 9.9 -4.244m1.884 -2.113c2.587 -3.277 3.642 -6.502 2.358 -7.786c-1.284 -1.284 -4.508 -.23 -7.784 2.357\" />\n  <path d=\"M4.929 4.929c-1.562 1.562 .337 6 4.243 9.9c3.905 3.905 8.337 5.804 9.9 4.242m-.072 -4.071c-.767 -1.794 -2.215 -3.872 -4.172 -5.828c-1.944 -1.945 -4.041 -3.402 -5.828 -4.172\" />\n  <path d=\"M3 3l18 18\" />"),
    BALLOON(
        "balloon",
        "<path d=\"M14 8a2 2 0 0 0 -2 -2\" />\n  <path d=\"M6 8a6 6 0 1 1 12 0c0 4.97 -2.686 9 -6 9s-6 -4.03 -6 -9\" />\n  <path d=\"M12 17v1a2 2 0 0 1 -2 2h-3a2 2 0 0 0 -2 2\" />"),
    BALLOON_OFF(
        "balloon-off",
        "<path d=\"M14 8a2 2 0 0 0 -2 -2\" />\n  <path d=\"M7.762 3.753a6 6 0 0 1 10.238 4.247c0 1.847 -.37 3.564 -1.007 4.993m-1.59 2.42c-.967 1 -2.14 1.587 -3.403 1.587c-3.314 0 -6 -4.03 -6 -9c0 -.593 .086 -1.166 .246 -1.707\" />\n  <path d=\"M12 17v1a2 2 0 0 1 -2 2h-3a2 2 0 0 0 -2 2\" />\n  <path d=\"M3 3l18 18\" />"),
    BUTTERFLY(
        "butterfly",
        "<path d=\"M12 18.176a3 3 0 1 1 -4.953 -2.449l-.025 .023a4.502 4.502 0 0 1 1.483 -8.75c1.414 0 2.675 .652 3.5 1.671a4.5 4.5 0 1 1 4.983 7.079a3 3 0 1 1 -4.983 2.25l-.005 .176\" />\n  <path d=\"M12 19v-10\" />\n  <path d=\"M9 3l3 2l3 -2\" />"),
    CACTUS(
        "cactus",
        "<path d=\"M6 9v1a3 3 0 0 0 3 3h1\" />\n  <path d=\"M18 8v5a3 3 0 0 1 -3 3h-1\" />\n  <path d=\"M10 21v-16a2 2 0 1 1 4 0v16\" />\n  <path d=\"M7 21h10\" />"),
    CACTUS_OFF(
        "cactus-off",
        "<path d=\"M6 9v1a3 3 0 0 0 3 3h1\" />\n  <path d=\"M18 8v5a3 3 0 0 1 -.129 .872m-2.014 2a3 3 0 0 1 -.857 .124h-1\" />\n  <path d=\"M10 21v-11m0 -4v-1a2 2 0 1 1 4 0v5m0 4v7\" />\n  <path d=\"M7 21h10\" />\n  <path d=\"M3 3l18 18\" />"),
    CANNABIS(
        "cannabis",
        "<path d=\"M7 20s0 -2 1 -3.5c-1.5 0 -2 -.5 -4 -1.5c0 0 1.839 -1.38 5 -1c-1.789 -.97 -3.279 -2.03 -5 -6c0 0 3.98 -.3 6.5 3.5c-2.284 -4.9 1.5 -9.5 1.5 -9.5c2.734 5.47 2.389 7.5 1.5 9.5c2.531 -3.77 6.5 -3.5 6.5 -3.5c-1.721 3.97 -3.211 5.03 -5 6c3.161 -.38 5 1 5 1c-2 1 -2.5 1.5 -4 1.5c1 1.5 1 3.5 1 3.5c-2 0 -4.438 -2.22 -5 -3c-.563 .78 -3 3 -5 3\" />\n  <path d=\"M12 22v-5\" />"),
    CHERRY(
        "cherry",
        "<path d=\"M4 16.5a3.5 3.5 0 1 0 7 0a3.5 3.5 0 1 0 -7 0\" />\n  <path d=\"M14 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 13c.366 -2 1.866 -3.873 4.5 -5.6\" />\n  <path d=\"M17 15c-1.333 -2.333 -2.333 -5.333 -1 -9\" />\n  <path d=\"M5 6c3.667 -2.667 7.333 -2.667 11 0c-3.667 2.667 -7.333 2.667 -11 0\" />"),
    CHRISTMAS_TREE(
        "christmas-tree",
        "<path d=\"M12 3l4 4l-2 1l4 4l-3 1l4 4h-14l4 -4l-3 -1l4 -4l-2 -1l4 -4\" />\n  <path d=\"M14 17v3a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-3\" />"),
    CHRISTMAS_TREE_OFF(
        "christmas-tree-off",
        "<path d=\"M9.5 5.5l2.5 -2.5l4 4l-2 1l4 4l-1.5 .5m.5 4.5h-12l4 -4l-3 -1l3 -3\" />\n  <path d=\"M14 17v3a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1v-3\" />\n  <path d=\"M3 3l18 18\" />"),
    CLOVER(
        "clover",
        "<path d=\"M12 10l-3.397 -3.44a2.104 2.104 0 0 1 0 -2.95a2.04 2.04 0 0 1 2.912 0l.485 .39l.485 -.39a2.04 2.04 0 0 1 2.912 0a2.104 2.104 0 0 1 0 2.95l-3.397 3.44\" />\n  <path d=\"M12 14l-3.397 3.44a2.104 2.104 0 0 0 0 2.95a2.04 2.04 0 0 0 2.912 0l.485 -.39l.485 .39a2.04 2.04 0 0 0 2.912 0a2.104 2.104 0 0 0 0 -2.95l-3.397 -3.44\" />\n  <path d=\"M14 12l3.44 -3.397a2.104 2.104 0 0 1 2.95 0a2.04 2.04 0 0 1 0 2.912l-.39 .485l.39 .485a2.04 2.04 0 0 1 0 2.912a2.104 2.104 0 0 1 -2.95 0l-3.44 -3.397\" />\n  <path d=\"M10 12l-3.44 -3.397a2.104 2.104 0 0 0 -2.95 0a2.04 2.04 0 0 0 0 2.912l.39 .485l-.39 .485a2.04 2.04 0 0 0 0 2.912a2.104 2.104 0 0 0 2.95 0l3.44 -3.397\" />"),
    CLOVER_2(
        "clover-2",
        "<path d=\"M11 11l-3.397 -3.44a2.104 2.104 0 0 1 0 -2.95a2.04 2.04 0 0 1 2.912 0l.485 .39l.485 -.39a2.04 2.04 0 0 1 2.912 0a2.104 2.104 0 0 1 0 2.95l-3.397 3.44\" />\n  <path d=\"M11 11l-3.397 3.44a2.104 2.104 0 0 0 0 2.95a2.04 2.04 0 0 0 2.912 0l.485 -.39l.485 .39a2.04 2.04 0 0 0 2.912 0a2.104 2.104 0 0 0 0 -2.95l-3.397 -3.44\" />\n  <path d=\"M14.44 7.603a2.104 2.104 0 0 1 2.95 0a2.04 2.04 0 0 1 0 2.912l-.39 .485l.39 .485a2.04 2.04 0 0 1 0 2.912a2.104 2.104 0 0 1 -2.95 0\" />\n  <path d=\"M7.56 7.603a2.104 2.104 0 0 0 -2.95 0a2.04 2.04 0 0 0 0 2.912l.39 .485l-.39 .485a2.04 2.04 0 0 0 0 2.912a2.104 2.104 0 0 0 2.95 0\" />\n  <path d=\"M15 15l6 6\" />"),
    CRYSTAL_BALL(
        "crystal-ball",
        "<path d=\"M6.73 17.018a8 8 0 1 1 10.54 0\" />\n  <path d=\"M5 19a2 2 0 0 0 2 2h10a2 2 0 1 0 0 -4h-10a2 2 0 0 0 -2 2\" />\n  <path d=\"M11 7a3 3 0 0 0 -3 3\" />"),
    DROP_CIRCLE(
        "drop-circle",
        "<path d=\"M10.07 15.34c1.115 .88 2.74 .88 3.855 0c1.115 -.88 1.398 -2.388 .671 -3.575l-2.596 -3.765l-2.602 3.765c-.726 1.187 -.443 2.694 .672 3.575\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    DROPLETS(
        "droplets",
        "<path d=\"M4.072 20.3a2.999 2.999 0 0 0 3.856 0a3.002 3.002 0 0 0 .67 -3.798l-2.095 -3.227a.6 .6 0 0 0 -1.005 0l-2.098 3.227a3.003 3.003 0 0 0 .671 3.798\" />\n  <path d=\"M16.072 20.3a2.999 2.999 0 0 0 3.856 0a3.002 3.002 0 0 0 .67 -3.798l-2.095 -3.227a.6 .6 0 0 0 -1.005 0l-2.098 3.227a3.003 3.003 0 0 0 .671 3.798\" />\n  <path d=\"M10.072 10.3a2.999 2.999 0 0 0 3.856 0a3.002 3.002 0 0 0 .67 -3.798l-2.095 -3.227a.6 .6 0 0 0 -1.005 0l-2.098 3.227a3.003 3.003 0 0 0 .671 3.798l.001 0\" />"),
    FEATHER(
        "feather",
        "<path d=\"M4 20l10 -10m0 -5v5h5m-9 -1v5h5m-9 -1v5h5m-5 -5l4 -4l4 -4\" />\n  <path d=\"M19 10c.638 -.636 1 -1.515 1 -2.486a3.515 3.515 0 0 0 -3.517 -3.514c-.97 0 -1.847 .367 -2.483 1m-3 13l4 -4l4 -4\" />"),
    FEATHER_OFF(
        "feather-off",
        "<path d=\"M4 20l8 -8\" />\n  <path d=\"M14 5v5h5\" />\n  <path d=\"M9 11v4h4\" />\n  <path d=\"M6 13v5h5\" />\n  <path d=\"M6 13l3.502 -3.502m2.023 -2.023l2.475 -2.475\" />\n  <path d=\"M19 10c.638 -.636 1 -1.515 1 -2.486a3.515 3.515 0 0 0 -3.517 -3.514c-.97 0 -1.847 .367 -2.483 1\" />\n  <path d=\"M11 18l3.499 -3.499m2.008 -2.008l2.493 -2.493\" />\n  <path d=\"M3 3l18 18\" />"),
    FLAME(
        "flame",
        "<path d=\"M12 10.941c2.333 -3.308 .167 -7.823 -1 -8.941c0 3.395 -2.235 5.299 -3.667 6.706c-1.43 1.408 -2.333 3.294 -2.333 5.588c0 3.704 3.134 6.706 7 6.706c3.866 0 7 -3.002 7 -6.706c0 -1.712 -1.232 -4.403 -2.333 -5.588c-2.084 3.353 -3.257 3.353 -4.667 2.235\" />"),
    FLAME_OFF(
        "flame-off",
        "<path d=\"M8.973 8.974c-.335 .378 -.67 .716 -.973 1.026c-1.226 1.26 -2 3.24 -2 5a6 6 0 0 0 11.472 2.466m.383 -3.597c-.32 -1.409 -1.122 -3.045 -1.855 -3.869c-.281 .472 -.543 .87 -.79 1.202m-2.358 -2.35c-.068 -2.157 -1.182 -4.184 -1.852 -4.852c0 .968 -.18 1.801 -.465 2.527\" />\n  <path d=\"M3 3l18 18\" />"),
    FLOWER(
        "flower",
        "<path d=\"M9 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M12 2a3 3 0 0 1 3 3c0 .562 -.259 1.442 -.776 2.64l-.724 1.36l1.76 -1.893c.499 -.6 .922 -1 1.27 -1.205a2.968 2.968 0 0 1 4.07 1.099a3.011 3.011 0 0 1 -1.09 4.098c-.374 .217 -.99 .396 -1.846 .535l-2.664 .366l2.4 .326c1 .145 1.698 .337 2.11 .576a3.011 3.011 0 0 1 1.09 4.098a2.968 2.968 0 0 1 -4.07 1.098c-.348 -.202 -.771 -.604 -1.27 -1.205l-1.76 -1.893l.724 1.36c.516 1.199 .776 2.079 .776 2.64a3 3 0 0 1 -6 0c0 -.562 .259 -1.442 .776 -2.64l.724 -1.36l-1.76 1.893c-.499 .601 -.922 1 -1.27 1.205a2.968 2.968 0 0 1 -4.07 -1.098a3.011 3.011 0 0 1 1.09 -4.098c.374 -.218 .99 -.396 1.846 -.536l2.664 -.366l-2.4 -.325c-1 -.145 -1.698 -.337 -2.11 -.576a3.011 3.011 0 0 1 -1.09 -4.099a2.968 2.968 0 0 1 4.07 -1.099c.348 .203 .771 .604 1.27 1.205l1.76 1.894c-1 -2.292 -1.5 -3.625 -1.5 -4a3 3 0 0 1 3 -3\" />"),
    FLOWER_OFF(
        "flower-off",
        "<path d=\"M9.875 9.882a3 3 0 0 0 4.247 4.238m.581 -3.423a3.012 3.012 0 0 0 -1.418 -1.409\" />\n  <path d=\"M9 5a3 3 0 0 1 6 0c0 .562 -.259 1.442 -.776 2.64l-.724 1.36l1.76 -1.893c.499 -.6 .922 -1 1.27 -1.205a2.968 2.968 0 0 1 4.07 1.099a3.011 3.011 0 0 1 -1.09 4.098c-.374 .217 -.99 .396 -1.846 .535l-1.779 .244m.292 .282l1.223 .166c1 .145 1.698 .337 2.11 .576a3.011 3.011 0 0 1 1.226 3.832m-2.277 1.733a2.968 2.968 0 0 1 -1.929 -.369c-.348 -.202 -.771 -.604 -1.27 -1.205l-1.76 -1.893l.724 1.36c.516 1.199 .776 2.079 .776 2.64a3 3 0 0 1 -6 0c0 -.562 .259 -1.442 .776 -2.64l.724 -1.36l-1.76 1.893c-.499 .601 -.922 1 -1.27 1.205a2.968 2.968 0 0 1 -4.07 -1.098a3.011 3.011 0 0 1 1.09 -4.098c.374 -.218 .99 -.396 1.846 -.536l2.664 -.366l-2.4 -.325c-1 -.145 -1.698 -.337 -2.11 -.576a3.011 3.011 0 0 1 -1.09 -4.099a2.968 2.968 0 0 1 2.134 -1.467\" />\n  <path d=\"M3 3l18 18\" />"),
    GROWTH(
        "growth",
        "<path d=\"M16.5 15a4.5 4.5 0 0 0 -4.5 4.5m4.5 -8.5a4.5 4.5 0 0 0 -4.5 4.5m4.5 -8.5a4.5 4.5 0 0 0 -4.5 4.5m-4 3.5c2.21 0 4 2.015 4 4.5m-4 -8.5c2.21 0 4 2.015 4 4.5m-4 -8.5c2.21 0 4 2.015 4 4.5m0 -7.5v6\" />"),
    ICEBERG(
        "iceberg",
        "<path d=\"M19 10l-2 9l-4 3l-3 -5l-3 -1l-2 -6l2 -5l3 -2l3 3l4 1l2 3\" />\n  <path d=\"M3 10h18\" />"),
    LEAF(
        "leaf",
        "<path d=\"M5 21c.5 -4.5 2.5 -8 7 -10\" />\n  <path d=\"M9 18c6.218 0 10.5 -3.288 11 -12v-2h-4.014c-9 0 -11.986 4 -12 9c0 1 0 3 2 5h3l.014 0\" />"),
    LEAF_2(
        "leaf-2",
        "<path d=\"M5 21c.5 -4.5 2.5 -8 7 -10\" />\n  <path d=\"M7.5 15q -3.5 0 -4.5 -6a8.4 8.4 0 0 1 3.438 .402a12 12 0 0 1 -.052 -.793c0 -3.606 3.204 -5.609 3.204 -5.609s2.003 1.252 2.842 3.557q 2.568 -1.557 6.568 -1.557q .396 3.775 -1.557 6.568c2.305 .839 3.557 2.842 3.557 2.842s-3 2.59 -7 2.59c0 1 0 1 .5 3q -6 0 -7 -5\" />"),
    LEAF_MAPLE(
        "leaf-maple",
        "<path d=\"M5 21c.5 -4.5 2.5 -8 7 -10\" />\n  <path d=\"M13 19c-2.733 0 -4.16 -3.11 -5 -5c-1.892 -.84 -4 -1.826 -4 -4.556c1.014 -.644 2.816 -.649 4 -.444c-.312 -2.071 -.37 -4.414 1 -6c2.364 .369 3 4 3 4c1.463 -1.368 4 -2 6 -2c0 2 -.63 4.538 -2 6q 3.687 .996 4 3c-1.586 1.36 -3.933 1.311 -6 1q .19 1.098 -1 4\" />"),
    LEAF_OFF(
        "leaf-off",
        "<path d=\"M5 21c.475 -4.27 2.3 -7.64 6.331 -9.683\" />\n  <path d=\"M6.618 6.623c-1.874 1.625 -2.625 3.877 -2.632 6.377c0 1 0 3 2 5h3.014c2.733 0 5.092 -.635 6.92 -2.087m1.899 -2.099c1.224 -1.872 1.987 -4.434 2.181 -7.814v-2h-4.014c-2.863 0 -5.118 .405 -6.861 1.118\" />\n  <path d=\"M3 3l18 18\" />"),
    METEOR(
        "meteor",
        "<path d=\"M21 3l-5 9h5l-6.891 7.086a6.5 6.5 0 1 1 -8.855 -9.506l7.746 -6.58l-1 5l9 -5\" />\n  <path d=\"M7 14.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />"),
    METEOR_OFF(
        "meteor-off",
        "<path d=\"M9.75 5.761l3.25 -2.761l-1 5l9 -5l-5 9h5l-2.467 2.536m-1.983 2.04l-2.441 2.51a6.5 6.5 0 1 1 -8.855 -9.506l2.322 -1.972\" />\n  <path d=\"M7 14.5a2.5 2.5 0 1 0 5 0a2.5 2.5 0 1 0 -5 0\" />\n  <path d=\"M3 3l18 18\" />"),
    MOUNTAIN(
        "mountain",
        "<path d=\"M3 20h18l-6.921 -14.612a2.3 2.3 0 0 0 -4.158 0l-6.921 14.612\" />\n  <path d=\"M7.5 11l2 2.5l2.5 -2.5l2 3l2.5 -2\" />"),
    MOUNTAIN_OFF(
        "mountain-off",
        "<path d=\"M18.281 14.26l-4.201 -8.872a2.3 2.3 0 0 0 -4.158 0l-.165 .349m-1.289 2.719l-5.468 11.544h17\" />\n  <path d=\"M7.5 11l2 2.5l2 -2\" />\n  <path d=\"M3 3l18 18\" />"),
    ORBIT(
        "orbit",
        "<path d=\"M7.628 7.629c-2.76 .854 -4.628 2.491 -4.628 4.371c0 2.761 4.03 5 9 5s9 -2.239 9 -5s-4.03 -5 -9 -5\" />\n  <path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    ORBIT_VERTICAL(
        "orbit-vertical",
        "<path d=\"M16.372 16.372c.4 -1.295 .628 -2.785 .628 -4.372c0 -4.97 -2.239 -9 -5 -9s-5 4.03 -5 9s2.239 9 5 9c.596 0 1.168 -.188 1.698 -.533\" />\n  <path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />"),
    ORBITS(
        "orbits",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7.628 7.629c-2.76 .854 -4.628 2.491 -4.628 4.371c0 2.761 4.03 5 9 5s9 -2.239 9 -5s-4.03 -5 -9 -5\" />\n  <path d=\"M16.372 16.372c.4 -1.295 .628 -2.785 .628 -4.372c0 -4.97 -2.239 -9 -5 -9s-5 4.03 -5 9s2.239 9 5 9c.596 0 1.168 -.188 1.698 -.533\" />"),
    PLANT(
        "plant",
        "<path d=\"M7 15h10v4a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2v-4\" />\n  <path d=\"M12 9a6 6 0 0 0 -6 -6h-3v2a6 6 0 0 0 6 6h3\" />\n  <path d=\"M12 11a6 6 0 0 1 6 -6h3v1a6 6 0 0 1 -6 6h-3\" />\n  <path d=\"M12 15l0 -6\" />"),
    PLANT_2(
        "plant-2",
        "<path d=\"M2 9a10 10 0 1 0 20 0\" />\n  <path d=\"M12 19a10 10 0 0 1 10 -10\" />\n  <path d=\"M2 9a10 10 0 0 1 10 10\" />\n  <path d=\"M12 4a9.7 9.7 0 0 1 2.99 7.5\" />\n  <path d=\"M9.01 11.5a9.7 9.7 0 0 1 2.99 -7.5\" />"),
    PLANT_2_OFF(
        "plant-2-off",
        "<path d=\"M2 9c0 5.523 4.477 10 10 10a9.953 9.953 0 0 0 5.418 -1.593m2.137 -1.855a9.961 9.961 0 0 0 2.445 -6.552\" />\n  <path d=\"M12 19c0 -1.988 .58 -3.84 1.58 -5.397m1.878 -2.167a9.961 9.961 0 0 1 6.542 -2.436\" />\n  <path d=\"M2 9a10 10 0 0 1 10 10\" />\n  <path d=\"M12 4a9.7 9.7 0 0 1 3 7.013\" />\n  <path d=\"M9.01 11.5a9.696 9.696 0 0 1 .163 -2.318m1.082 -2.942a9.696 9.696 0 0 1 1.745 -2.24\" />\n  <path d=\"M3 3l18 18\" />"),
    PLANT_OFF(
        "plant-off",
        "<path d=\"M17 17v2a2 2 0 0 1 -2 2h-6a2 2 0 0 1 -2 -2v-4h8\" />\n  <path d=\"M11.9 7.908a6 6 0 0 0 -4.79 -4.806m-4.11 -.102v2a6 6 0 0 0 6 6h2\" />\n  <path d=\"M12.531 8.528a6 6 0 0 1 5.469 -3.528h3v1a6 6 0 0 1 -5.037 5.923\" />\n  <path d=\"M12 15v-3\" />\n  <path d=\"M3 3l18 18\" />"),
    RIPPLE(
        "ripple",
        "<path d=\"M3 7c3 -2 6 -2 9 0s6 2 9 0\" />\n  <path d=\"M3 17c3 -2 6 -2 9 0s6 2 9 0\" />\n  <path d=\"M3 12c3 -2 6 -2 9 0s6 2 9 0\" />"),
    RIPPLE_OFF(
        "ripple-off",
        "<path d=\"M3 7c.915 -.61 1.83 -1.034 2.746 -1.272m4.212 .22c.68 .247 1.361 .598 2.042 1.052c3 2 6 2 9 0\" />\n  <path d=\"M3 17c3 -2 6 -2 9 0c2.092 1.395 4.184 1.817 6.276 1.266\" />\n  <path d=\"M3 12c3 -2 6 -2 9 0m5.482 1.429c1.173 -.171 2.345 -.647 3.518 -1.429\" />\n  <path d=\"M3 3l18 18\" />"),
    SEEDLING(
        "seedling",
        "<path d=\"M12 10a6 6 0 0 0 -6 -6h-3v2a6 6 0 0 0 6 6h3\" />\n  <path d=\"M12 14a6 6 0 0 1 6 -6h3v1a6 6 0 0 1 -6 6h-3\" />\n  <path d=\"M12 20l0 -10\" />"),
    SEEDLING_OFF(
        "seedling-off",
        "<path d=\"M11.412 7.407a6.025 6.025 0 0 0 -2.82 -2.82m-4.592 -.587h-1v2a6 6 0 0 0 6 6h3\" />\n  <path d=\"M12 14a6 6 0 0 1 .255 -1.736m1.51 -2.514a5.981 5.981 0 0 1 4.235 -1.75h3v1c0 2.158 -1.14 4.05 -2.85 5.107m-3.15 .893h-3\" />\n  <path d=\"M12 20v-8\" />\n  <path d=\"M3 3l18 18\" />"),
    SNOWMAN(
        "snowman",
        "<path d=\"M12 3a4 4 0 0 1 2.906 6.75a6 6 0 1 1 -5.81 0a4 4 0 0 1 2.904 -6.75\" />\n  <path d=\"M17.5 11.5l2.5 -1.5\" />\n  <path d=\"M6.5 11.5l-2.5 -1.5\" />\n  <path d=\"M12 13h.01\" />\n  <path d=\"M12 16h.01\" />"),
    SUN_ELECTRICITY(
        "sun-electricity",
        "<path d=\"M8 12a4 4 0 0 0 4 4m0 -8a4 4 0 0 0 -4 4\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M12 3v1\" />\n  <path d=\"M12 20v1\" />\n  <path d=\"M5.6 5.6l.7 .7\" />\n  <path d=\"M6.3 17.7l-.7 .7\" />\n  <path d=\"M20 7l-3 5h4l-3 5\" />"),
    TWIG(
        "twig",
        "<path d=\"M3 21l5 -4l3 -5l5 -2l5 -7\" />\n  <path d=\"M16 10h5\" />\n  <path d=\"M11 12v-8\" />\n  <path d=\"M8 17h7\" />"),
    WIND_ELECTRICITY(
        "wind-electricity",
        "<path d=\"M20 7l-3 5h4l-3 5\" />\n  <path d=\"M3 16h4a2 2 0 1 1 0 4\" />\n  <path d=\"M3 12h8a2 2 0 1 0 0 -4\" />\n  <path d=\"M3 8h3a2 2 0 1 0 0 -4\" />");

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
    ALIEN(
        "alien",
        "<path d=\"M12.004 2c4.942 0 8.288 2.503 8.85 6.444a12.884 12.884 0 0 1 -2.163 9.308a11.794 11.794 0 0 1 -3.51 3.356c-1.982 1.19 -4.376 1.19 -6.373 -.008a11.763 11.763 0 0 1 -3.489 -3.34a12.808 12.808 0 0 1 -2.171 -9.306c.564 -3.95 3.91 -6.454 8.856 -6.454zm1.913 14.6a1 1 0 0 0 -1.317 -.517l-.146 .055a1.5 1.5 0 0 1 -1.054 -.055l-.11 -.04a1 1 0 0 0 -.69 1.874a3.5 3.5 0 0 0 2.8 0a1 1 0 0 0 .517 -1.317zm-5.304 -6.39a1 1 0 0 0 -1.32 1.497l2 2l.094 .083a1 1 0 0 0 1.32 -1.497l-2 -2zm8.094 .083a1 1 0 0 0 -1.414 0l-2 2l-.083 .094a1 1 0 0 0 1.497 1.32l2 -2l.083 -.094a1 1 0 0 0 -.083 -1.32z\" />"),
    ATOM_2(
        "atom-2",
        "<path d=\"M12 8a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M12 20a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M3 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M21 8a1 1 0 0 1 .993 .883l.007 .127a1 1 0 0 1 -1.993 .117l-.007 -.127a1 1 0 0 1 1 -1z\" />\n  <path d=\"M2.89 12.006a1 1 0 0 1 1.104 .884a8 8 0 0 0 4.444 6.311a1 1 0 1 1 -.876 1.799a10 10 0 0 1 -5.556 -7.89a1 1 0 0 1 .884 -1.103z\" />\n  <path d=\"M20.993 12l.117 .006a1 1 0 0 1 .884 1.104a10 10 0 0 1 -5.556 7.889a1 1 0 1 1 -.876 -1.798a8 8 0 0 0 4.444 -6.31a1 1 0 0 1 .987 -.891z\" />\n  <path d=\"M5.567 4.226a10 10 0 0 1 12.666 0a1 1 0 1 1 -1.266 1.548a8 8 0 0 0 -10.134 0a1 1 0 1 1 -1.266 -1.548z\" />"),
    BALLOON(
        "balloon",
        "<path d=\"M12 1a7 7 0 0 1 7 7c0 5.457 -3.028 10 -7 10c-3.9 0 -6.89 -4.379 -6.997 -9.703l-.003 -.297l.004 -.24a7 7 0 0 1 6.996 -6.76zm0 4a1 1 0 0 0 0 2l.117 .007a1 1 0 0 1 .883 .993l.007 .117a1 1 0 0 0 1.993 -.117a3 3 0 0 0 -3 -3z\" />\n  <path d=\"M12 16a1 1 0 0 1 .993 .883l.007 .117v1a3 3 0 0 1 -2.824 2.995l-.176 .005h-3a1 1 0 0 0 -.993 .883l-.007 .117a1 1 0 0 1 -2 0a3 3 0 0 1 2.824 -2.995l.176 -.005h3a1 1 0 0 0 .993 -.883l.007 -.117v-1a1 1 0 0 1 1 -1z\" />"),
    BUTTERFLY(
        "butterfly",
        "<path d=\"M17.117 6.244l.228 .076a5.5 5.5 0 0 1 1.24 9.738l-.063 .039l.02 .034a4 4 0 0 1 .101 3.533l-.093 .19a4 4 0 0 1 -5.55 1.608v-14.857a5.5 5.5 0 0 1 4.118 -.36\" />\n  <path d=\"M8.505 6c.885 0 1.736 .21 2.495 .597v14.87a4 4 0 0 1 -1.012 .41l-.196 .045a4 4 0 0 1 -4.424 -5.587l.118 -.238l-.035 -.023a5.5 5.5 0 0 1 -2.397 -5.258l.034 -.233a5.5 5.5 0 0 1 5.417 -4.583\" />\n  <path d=\"M14.445 2.168a1 1 0 0 1 1.11 1.664l-3 2a1 1 0 0 1 -1.11 0l-3 -2a1 1 0 0 1 1.11 -1.664l2.444 1.63z\" />"),
    CACTUS(
        "cactus",
        "<path d=\"M7 22a1 1 0 0 1 -.117 -1.993l.117 -.007h2v-6a4 4 0 0 1 -3.995 -3.8l-.005 -.2v-1a1 1 0 0 1 1.993 -.117l.007 .117v1a2 2 0 0 0 1.85 1.995l.15 .005v-7a3 3 0 0 1 5.995 -.176l.005 .176v10a2 2 0 0 0 1.995 -1.85l.005 -.15v-5a1 1 0 0 1 1.993 -.117l.007 .117v5a4 4 0 0 1 -3.8 3.995l-.2 .005v3h2a1 1 0 0 1 .117 1.993l-.117 .007h-10z\" />"),
    CANNABIS(
        "cannabis",
        "<path d=\"M12.894 1.553c1.472 2.945 2.17 5.028 2.244 6.812l.001 .091l.032 -.022a8.7 8.7 0 0 1 2.73 -1.191l.352 -.079a8 8 0 0 1 1.562 -.169l.253 .007a1 1 0 0 1 .85 1.396c-.949 2.187 -1.818 3.595 -2.902 4.664l-.061 .058l.25 .055q .45 .108 .869 .259l.276 .104c.586 .235 1.006 .479 1.25 .662a1 1 0 0 1 -.042 1.63l-.199 .112l-1.133 .587c-.567 .289 -1.166 .584 -1.404 .67q -.123 .045 -.244 .083l-.074 .019l.016 .042c.327 .912 .456 1.789 .477 2.462l.003 .195a1 1 0 0 1 -1 1c-1.257 0 -2.77 -.729 -4.001 -1.647l.001 2.647a1 1 0 0 1 -2 0v-2.647c-1.16 .866 -2.57 1.563 -3.781 1.64l-.219 .007a1 1 0 0 1 -1 -1c0 -.624 .098 -1.464 .379 -2.358l.116 -.341l-.073 -.02l-.244 -.081c-.343 -.125 -1.442 -.686 -2.106 -1.032l-.52 -.274a1 1 0 0 1 -.152 -1.694c.244 -.183 .664 -.427 1.25 -.662a8 8 0 0 1 1.145 -.363l.249 -.055l-.06 -.058c-1.024 -1.01 -1.856 -2.322 -2.744 -4.307l-.157 -.357a1 1 0 0 1 .724 -1.38l.149 -.017l.058 -.003a7.5 7.5 0 0 1 1.744 .159a8.6 8.6 0 0 1 2.727 1.045l.27 .169v-.037c-.028 -1.594 .375 -3.18 1.095 -4.704l.139 -.285c.455 -.908 .914 -1.586 1.238 -1.98a1 1 0 0 1 1.666 .189\" />"),
    CHERRY(
        "cherry",
        "<path d=\"M16.588 5.191l.058 .045l.078 .074l.072 .084l.013 .018a.998 .998 0 0 1 .182 .727l-.022 .111l-.03 .092c-.99 2.725 -.666 5.158 .679 7.706a4 4 0 1 1 -4.613 4.152l-.005 -.2l.005 -.2a4.002 4.002 0 0 1 2.5 -3.511c-.947 -2.03 -1.342 -4.065 -1.052 -6.207c-.166 .077 -.332 .15 -.499 .218l.094 -.064c-2.243 1.47 -3.552 3.004 -3.98 4.57a4.5 4.5 0 1 1 -7.064 3.906l-.004 -.212l.005 -.212a4.5 4.5 0 0 1 5.2 -4.233c.332 -1.073 .945 -2.096 1.83 -3.069c-1.794 -.096 -3.586 -.759 -5.355 -1.986l-.268 -.19l-.051 -.04l-.046 -.04l-.044 -.044l-.04 -.046l-.04 -.05l-.032 -.047l-.035 -.06l-.053 -.11l-.038 -.116l-.023 -.117l-.005 -.042l-.005 -.118l.01 -.118l.023 -.117l.038 -.115l.03 -.066l.023 -.045l.035 -.06l.032 -.046l.04 -.051l.04 -.046l.044 -.044l.046 -.04l.05 -.04c4.018 -2.922 8.16 -2.922 12.177 0z\" />"),
    CHRISTMAS_TREE(
        "christmas-tree",
        "<path d=\"M15 19v1a2 2 0 0 1 -2 2h-2a2 2 0 0 1 -2 -2v-1zm-10 -1c-.89 0 -1.337 -1.077 -.707 -1.707l2.855 -2.857l-1.464 -.487a1 1 0 0 1 -.472 -1.565l.08 -.091l3.019 -3.02l-.758 -.379a1 1 0 0 1 -.343 -1.507l.083 -.094l4 -4a1 1 0 0 1 1.414 0l4 4a1 1 0 0 1 -.26 1.601l-.759 .379l3.02 3.02a1 1 0 0 1 -.279 1.61l-.113 .046l-1.465 .487l2.856 2.857c.603 .602 .22 1.614 -.593 1.701l-.114 .006z\" />"),
    CLOVER(
        "clover",
        "<path d=\"M12.712 13.297l3.398 3.442a3.104 3.104 0 0 1 0 4.351a3.04 3.04 0 0 1 -4.036 .27l-.075 -.062l-.073 .062a3.04 3.04 0 0 1 -1.664 .634l-.203 .007a3.04 3.04 0 0 1 -2.17 -.91a3.104 3.104 0 0 1 .002 -4.354l3.397 -3.44a1 1 0 0 1 1.424 0m8.378 -5.407a3.04 3.04 0 0 1 .27 4.037l-.062 .073l.062 .075a3.04 3.04 0 0 1 .634 1.664l.007 .203a3.04 3.04 0 0 1 -.91 2.17a3.104 3.104 0 0 1 -4.354 -.002l-3.44 -3.397a1 1 0 0 1 0 -1.424l3.443 -3.399a3.104 3.104 0 0 1 4.351 0m-13.827 .002l3.44 3.397a1 1 0 0 1 0 1.424l-3.444 3.397a3.104 3.104 0 0 1 -4.351 0a3.04 3.04 0 0 1 -.27 -4.036l.062 -.075l-.062 -.073a3.04 3.04 0 0 1 -.634 -1.664l-.007 -.203c0 -.816 .328 -1.598 .91 -2.17a3.104 3.104 0 0 1 4.354 .002m6.678 -5.891a3.04 3.04 0 0 1 2.17 .91a3.104 3.104 0 0 1 -.002 4.354l-3.397 3.44a1 1 0 0 1 -1.424 0l-3.397 -3.444a3.104 3.104 0 0 1 0 -4.351a3.04 3.04 0 0 1 4.036 -.27l.073 .062l.075 -.062a3.04 3.04 0 0 1 1.664 -.634z\" />"),
    DROP_CIRCLE(
        "drop-circle",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-4.177 4.092a1 1 0 0 0 -1.646 0l-2.602 3.764c-1.022 1.67 -.634 3.736 .875 4.929a4.144 4.144 0 0 0 5.095 0c1.51 -1.191 1.897 -3.26 .904 -4.882z\" />"),
    DROPLETS(
        "droplets",
        "<path d=\"M6 12.003c.541 0 1.045 .273 1.342 .727l2.122 3.273a3.999 3.999 0 0 1 -6.035 5.063c-1.487 -1.248 -1.864 -3.382 -.867 -5.11l2.098 -3.226a1.6 1.6 0 0 1 1.34 -.727\" />\n  <path d=\"M18 12.003c.541 0 1.045 .273 1.342 .727l2.122 3.273a3.999 3.999 0 0 1 -6.035 5.063c-1.487 -1.248 -1.864 -3.382 -.867 -5.11l2.098 -3.227a1.6 1.6 0 0 1 1.34 -.726\" />\n  <path d=\"M12 2.003c.541 0 1.045 .273 1.342 .727l2.122 3.273a3.999 3.999 0 0 1 -6.035 5.063c-1.487 -1.248 -1.864 -3.382 -.867 -5.11l2.098 -3.226a1.6 1.6 0 0 1 1.34 -.727\" />"),
    FEATHER(
        "feather",
        "<path d=\"M8 9.585v6.415h6.414l-2.707 2.707a1 1 0 0 1 -.112 .097l-.11 .071l-.114 .054l-.105 .035l-.149 .03l-.117 .006h-4.586l-1.707 1.707a1 1 0 1 1 -1.414 -1.414l1.707 -1.709v-4.584l.003 -.075l.017 -.126l.03 -.111l.044 -.111l.052 -.098l.067 -.096l.08 -.09z\" />\n  <path d=\"M19.414 11l-3 3h-4.914l2.914 -3z\" />\n  <path d=\"M13 4.586v4.998l-3 3v-4.999z\" />\n  <path d=\"M16.482 3a4.515 4.515 0 0 1 4.518 4.514a4.7 4.7 0 0 1 -.239 1.487l-5.761 -.001v-5.76c.469 -.158 .968 -.24 1.482 -.24\" />"),
    FLAME(
        "flame",
        "<path d=\"M10 2c0 -.88 1.056 -1.331 1.692 -.722c1.958 1.876 3.096 5.995 1.75 9.12l-.08 .174l.012 .003c.625 .133 1.203 -.43 2.303 -2.173l.14 -.224a1 1 0 0 1 1.582 -.153c1.334 1.435 2.601 4.377 2.601 6.27c0 4.265 -3.591 7.705 -8 7.705s-8 -3.44 -8 -7.706c0 -2.252 1.022 -4.716 2.632 -6.301l.605 -.589c.241 -.236 .434 -.43 .618 -.624c1.43 -1.512 2.145 -2.924 2.145 -4.78\" />"),
    FLOWER(
        "flower",
        "<path d=\"M12 1a4 4 0 0 1 4 4l-.002 .055l.03 -.018a3.97 3.97 0 0 1 2.79 -.455l.237 .056a3.97 3.97 0 0 1 2.412 1.865a4.01 4.01 0 0 1 -1.455 5.461l-.068 .036l.071 .039a4.01 4.01 0 0 1 1.555 5.27l-.101 .186a3.97 3.97 0 0 1 -5.441 1.468l-.03 -.02l.002 .057a4 4 0 0 1 -3.8 3.995l-.2 .005a4 4 0 0 1 -4 -4l.001 -.056l-.029 .019a3.97 3.97 0 0 1 -2.79 .456l-.236 -.056a3.97 3.97 0 0 1 -2.413 -1.865a4.01 4.01 0 0 1 1.453 -5.46l.07 -.038l-.071 -.038a4.01 4.01 0 0 1 -1.555 -5.27l.1 -.187a3.97 3.97 0 0 1 5.444 -1.468l.026 .018v-.055a4 4 0 0 1 3.8 -3.995zm0 8a3 3 0 1 0 0 6a3 3 0 0 0 0 -6\" />"),
    LEAF(
        "leaf",
        "<path d=\"M3.055 14.328l-.018 -.168l-.004 -.043a11 11 0 0 1 -.047 -1.12c.018 -6.29 4.29 -9.997 13 -9.997h4.014a1 1 0 0 1 1 1l-.002 2.057c-.498 8.701 -4.74 12.943 -11.998 12.943h-2.631a16 16 0 0 0 -.375 2.11a1 1 0 1 1 -1.988 -.22q .174 -1.568 .58 -2.947l-.118 -.146l-.208 -.28l-.157 -.229l-.182 -.293l-.098 -.171l-.065 -.122a6 6 0 0 1 -.397 -.941l-.072 -.237l-.085 -.327l-.057 -.268l-.043 -.242zm8.539 -4.242c-2.845 1.265 -4.854 3.13 -6.108 5.583q .098 .2 .218 .4l.185 .281l.07 .097q .12 .164 .258 .329l.197 .224h.649c1.037 -2.271 2.777 -3.946 5.343 -5.086a1 1 0 0 0 -.812 -1.828\" />"),
    METEOR(
        "meteor",
        "<path d=\"M21.874 3.486l-4.174 7.514h3.3c.846 0 1.293 .973 .791 1.612l-.074 .085l-6.9 7.095a7.5 7.5 0 1 1 -10.21 -10.974l7.746 -6.58c.722 -.614 1.814 .028 1.628 .958l-.577 2.879l7.11 -3.95c.88 -.488 1.849 .481 1.36 1.36m-12.374 7.515a3.5 3.5 0 0 0 -3.495 3.308l-.005 .192a3.5 3.5 0 1 0 3.5 -3.5\" />"),
    MOUNTAIN(
        "mountain",
        "<path d=\"M6.18 10.95l2.54 3.175l.084 .093a1 1 0 0 0 1.403 -.01l1.637 -1.638l1.324 1.985a1 1 0 0 0 1.457 .226l3.632 -2.906l3.647 7.697a1 1 0 0 1 -.904 1.428h-18a1 1 0 0 1 -.904 -1.428zm5.82 -7.878a3.3 3.3 0 0 1 2.983 1.888l2.394 5.057l-3.15 2.52l-1.395 -2.092l-.075 -.099a1 1 0 0 0 -1.464 -.053l-1.711 1.709l-1.301 -1.627l-1.151 -1.435l1.888 -3.98a3.3 3.3 0 0 1 2.982 -1.888\" />"),
    SEEDLING(
        "seedling",
        "<path d=\"M6 3a7 7 0 0 1 6.95 6.155a6.97 6.97 0 0 1 5.05 -2.155h3a1 1 0 0 1 1 1v1a7 7 0 0 1 -7 7h-2v4a1 1 0 0 1 -2 0v-7h-2a7 7 0 0 1 -7 -7v-2a1 1 0 0 1 1 -1z\" />");

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

  default TablerIcon acorn() {
    return TablerIcon.create(TablerNature.OutlineIcon.ACORN);
  }

  default TablerIcon alien() {
    return TablerIcon.create(TablerNature.OutlineIcon.ALIEN);
  }

  default TablerIcon atom() {
    return TablerIcon.create(TablerNature.OutlineIcon.ATOM);
  }

  default TablerIcon atom_2() {
    return TablerIcon.create(TablerNature.OutlineIcon.ATOM_2);
  }

  default TablerIcon atom_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.ATOM_OFF);
  }

  default TablerIcon balloon() {
    return TablerIcon.create(TablerNature.OutlineIcon.BALLOON);
  }

  default TablerIcon balloon_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.BALLOON_OFF);
  }

  default TablerIcon butterfly() {
    return TablerIcon.create(TablerNature.OutlineIcon.BUTTERFLY);
  }

  default TablerIcon cactus() {
    return TablerIcon.create(TablerNature.OutlineIcon.CACTUS);
  }

  default TablerIcon cactus_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.CACTUS_OFF);
  }

  default TablerIcon cannabis() {
    return TablerIcon.create(TablerNature.OutlineIcon.CANNABIS);
  }

  default TablerIcon cherry() {
    return TablerIcon.create(TablerNature.OutlineIcon.CHERRY);
  }

  default TablerIcon christmas_tree() {
    return TablerIcon.create(TablerNature.OutlineIcon.CHRISTMAS_TREE);
  }

  default TablerIcon christmas_tree_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.CHRISTMAS_TREE_OFF);
  }

  default TablerIcon clover() {
    return TablerIcon.create(TablerNature.OutlineIcon.CLOVER);
  }

  default TablerIcon clover_2() {
    return TablerIcon.create(TablerNature.OutlineIcon.CLOVER_2);
  }

  default TablerIcon crystal_ball() {
    return TablerIcon.create(TablerNature.OutlineIcon.CRYSTAL_BALL);
  }

  default TablerIcon drop_circle() {
    return TablerIcon.create(TablerNature.OutlineIcon.DROP_CIRCLE);
  }

  default TablerIcon droplets() {
    return TablerIcon.create(TablerNature.OutlineIcon.DROPLETS);
  }

  default TablerIcon feather() {
    return TablerIcon.create(TablerNature.OutlineIcon.FEATHER);
  }

  default TablerIcon feather_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.FEATHER_OFF);
  }

  default TablerIcon flame() {
    return TablerIcon.create(TablerNature.OutlineIcon.FLAME);
  }

  default TablerIcon flame_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.FLAME_OFF);
  }

  default TablerIcon flower() {
    return TablerIcon.create(TablerNature.OutlineIcon.FLOWER);
  }

  default TablerIcon flower_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.FLOWER_OFF);
  }

  default TablerIcon growth() {
    return TablerIcon.create(TablerNature.OutlineIcon.GROWTH);
  }

  default TablerIcon iceberg() {
    return TablerIcon.create(TablerNature.OutlineIcon.ICEBERG);
  }

  default TablerIcon leaf() {
    return TablerIcon.create(TablerNature.OutlineIcon.LEAF);
  }

  default TablerIcon leaf_2() {
    return TablerIcon.create(TablerNature.OutlineIcon.LEAF_2);
  }

  default TablerIcon leaf_maple() {
    return TablerIcon.create(TablerNature.OutlineIcon.LEAF_MAPLE);
  }

  default TablerIcon leaf_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.LEAF_OFF);
  }

  default TablerIcon meteor() {
    return TablerIcon.create(TablerNature.OutlineIcon.METEOR);
  }

  default TablerIcon meteor_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.METEOR_OFF);
  }

  default TablerIcon mountain() {
    return TablerIcon.create(TablerNature.OutlineIcon.MOUNTAIN);
  }

  default TablerIcon mountain_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.MOUNTAIN_OFF);
  }

  default TablerIcon orbit() {
    return TablerIcon.create(TablerNature.OutlineIcon.ORBIT);
  }

  default TablerIcon orbit_vertical() {
    return TablerIcon.create(TablerNature.OutlineIcon.ORBIT_VERTICAL);
  }

  default TablerIcon orbits() {
    return TablerIcon.create(TablerNature.OutlineIcon.ORBITS);
  }

  default TablerIcon plant() {
    return TablerIcon.create(TablerNature.OutlineIcon.PLANT);
  }

  default TablerIcon plant_2() {
    return TablerIcon.create(TablerNature.OutlineIcon.PLANT_2);
  }

  default TablerIcon plant_2_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.PLANT_2_OFF);
  }

  default TablerIcon plant_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.PLANT_OFF);
  }

  default TablerIcon ripple() {
    return TablerIcon.create(TablerNature.OutlineIcon.RIPPLE);
  }

  default TablerIcon ripple_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.RIPPLE_OFF);
  }

  default TablerIcon seedling() {
    return TablerIcon.create(TablerNature.OutlineIcon.SEEDLING);
  }

  default TablerIcon seedling_off() {
    return TablerIcon.create(TablerNature.OutlineIcon.SEEDLING_OFF);
  }

  default TablerIcon snowman() {
    return TablerIcon.create(TablerNature.OutlineIcon.SNOWMAN);
  }

  default TablerIcon sun_electricity() {
    return TablerIcon.create(TablerNature.OutlineIcon.SUN_ELECTRICITY);
  }

  default TablerIcon twig() {
    return TablerIcon.create(TablerNature.OutlineIcon.TWIG);
  }

  default TablerIcon wind_electricity() {
    return TablerIcon.create(TablerNature.OutlineIcon.WIND_ELECTRICITY);
  }

  default TablerIcon alien_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.ALIEN);
  }

  default TablerIcon atom_2_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.ATOM_2);
  }

  default TablerIcon balloon_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.BALLOON);
  }

  default TablerIcon butterfly_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.BUTTERFLY);
  }

  default TablerIcon cactus_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.CACTUS);
  }

  default TablerIcon cannabis_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.CANNABIS);
  }

  default TablerIcon cherry_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.CHERRY);
  }

  default TablerIcon christmas_tree_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.CHRISTMAS_TREE);
  }

  default TablerIcon clover_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.CLOVER);
  }

  default TablerIcon drop_circle_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.DROP_CIRCLE);
  }

  default TablerIcon droplets_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.DROPLETS);
  }

  default TablerIcon feather_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.FEATHER);
  }

  default TablerIcon flame_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.FLAME);
  }

  default TablerIcon flower_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.FLOWER);
  }

  default TablerIcon leaf_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.LEAF);
  }

  default TablerIcon meteor_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.METEOR);
  }

  default TablerIcon mountain_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.MOUNTAIN);
  }

  default TablerIcon seedling_filled() {
    return TablerIcon.create(TablerNature.FilledIcon.SEEDLING);
  }
}
