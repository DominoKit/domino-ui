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

/** Lucide food-beverage catalog category. */
public interface LucideFoodBeverage {
  enum Icon implements LucideIconDefinition {
    AMPHORA(
        "amphora",
        "<path d=\"M10 2v5.632c0 .424-.272.795-.653.982A6 6 0 0 0 6 14c.006 4 3 7 5 8\" />\n  <path d=\"M10 5H8a2 2 0 0 0 0 4h.68\" />\n  <path d=\"M14 2v5.632c0 .424.272.795.652.982A6 6 0 0 1 18 14c0 4-3 7-5 8\" />\n  <path d=\"M14 5h2a2 2 0 0 1 0 4h-.68\" />\n  <path d=\"M18 22H6\" />\n  <path d=\"M9 2h6\" />"),
    APPLE(
        "apple",
        "<path d=\"M12 6.528V3a1 1 0 0 1 1-1h0\" />\n  <path d=\"M18.237 21A15 15 0 0 0 22 11a6 6 0 0 0-10-4.472A6 6 0 0 0 2 11a15.1 15.1 0 0 0 3.763 10 3 3 0 0 0 3.648.648 5.5 5.5 0 0 1 5.178 0A3 3 0 0 0 18.237 21\" />"),
    AVOCADO(
        "avocado",
        "<path d=\"M13.465 3.464a5 5 0 017.07 0 5 5 0 010 7.072c-1.204 1.203-2.38 2.89-2.614 4.577A8 8 0 118.886 6.08c1.687-.235 3.375-1.41 4.579-2.615\" />\n  <circle cx=\"10\" cy=\"14\" r=\"3\" />"),
    BACON(
        "bacon",
        "<path d=\"M2.795 16.804c-.789-.79-1.09-2.018-.442-2.928 1.933-2.713 4.414-1.05 6.145-5.378 1.868-4.67 4.608-2.366 6.592-6.107.218-.412.78-.53 1.11-.2l5.005 5.005c.789.79 1.09 2.018.442 2.928-1.933 2.713-4.414 1.05-6.145 5.378-1.868 4.67-4.608 2.366-6.591 6.107-.22.412-.78.53-1.11.2z\" />\n  <path d=\"M4.5 18.5c2-5 5-2 7-7s5-2 7-7\" />"),
    BANANA(
        "banana",
        "<path d=\"M4 13c3.5-2 8-2 10 2a5.5 5.5 0 0 1 8 5\" />\n  <path d=\"M5.15 17.89c5.52-1.52 8.65-6.89 7-12C11.55 4 11.5 2 13 2c3.22 0 5 5.5 5 8 0 6.5-4.2 12-10.49 12C5.11 22 2 22 2 20c0-1.5 1.14-1.55 3.15-2.11Z\" />"),
    BARREL(
        "barrel",
        "<path d=\"M10.5 2a34.5 34.5 0 000 20\" />\n  <path d=\"M13.5 2a34.5 34.5 0 010 20\" />\n  <path d=\"M4.67 17h14.67\" />\n  <path d=\"M4.67 7h14.67\" />\n  <path d=\"M6.23 3.06a19 19 0 000 17.88A2 2 0 008 22h8a2 2 0 001.77-1.06 19 19 0 000-17.88A2 2 0 0016 2H8a2 2 0 00-1.77 1.06\" />"),
    BEAN(
        "bean",
        "<path d=\"M10.165 6.598C9.954 7.478 9.64 8.36 9 9c-.64.64-1.521.954-2.402 1.165A6 6 0 0 0 8 22c7.732 0 14-6.268 14-14a6 6 0 0 0-11.835-1.402Z\" />\n  <path d=\"M5.341 10.62a4 4 0 1 0 5.279-5.28\" />"),
    BEAN_OFF(
        "bean-off",
        "<path d=\"M9 9c-.64.64-1.521.954-2.402 1.165A6 6 0 0 0 8 22a13.96 13.96 0 0 0 9.9-4.1\" />\n  <path d=\"M10.75 5.093A6 6 0 0 1 22 8c0 2.411-.61 4.68-1.683 6.66\" />\n  <path d=\"M5.341 10.62a4 4 0 0 0 6.487 1.208M10.62 5.341a4.015 4.015 0 0 1 2.039 2.04\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    BEEF(
        "beef",
        "<path d=\"M16.4 13.7A6.5 6.5 0 1 0 6.28 6.6c-1.1 3.13-.78 3.9-3.18 6.08A3 3 0 0 0 5 18c4 0 8.4-1.8 11.4-4.3\" />\n  <path d=\"m18.5 6 1.754 3.5a6.48 6.48 0 0 1-1.854 8.2C15.4 20.2 11 22 7 22a3 3 0 0 1-2.68-1.66L2.4 16.5\" />\n  <circle cx=\"12.5\" cy=\"8.5\" r=\"2.5\" />"),
    BEEF_OFF(
        "beef-off",
        "<path d=\"M11.771 6.109a2.5 2.5 0 0 1 3.12 3.12\" />\n  <path d=\"M17.852 12.185a6.5 6.5 0 0 0-9.035-9.04\" />\n  <path d=\"M18.013 18.013C15.029 20.349 10.831 22 7 22a3 3 0 0 1-2.68-1.66L2.4 16.5\" />\n  <path d=\"m18.5 6 2.19 4.5a6.48 6.48 0 0 1-.139 4.393\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M6.355 6.37a7 7 0 0 0-.075.23c-1.1 3.13-.78 3.9-3.18 6.08A3 3 0 0 0 5 18c3.356 0 6.993-1.267 9.85-3.151\" />"),
    BEER(
        "beer",
        "<path d=\"M17 11h1a3 3 0 0 1 0 6h-1\" />\n  <path d=\"M9 12v6\" />\n  <path d=\"M13 12v6\" />\n  <path d=\"M14 7.5c-1 0-1.44.5-3 .5s-2-.5-3-.5-1.72.5-2.5.5a2.5 2.5 0 0 1 0-5c.78 0 1.57.5 2.5.5S9.44 2 11 2s2 1.5 3 1.5 1.72-.5 2.5-.5a2.5 2.5 0 0 1 0 5c-.78 0-1.5-.5-2.5-.5Z\" />\n  <path d=\"M5 8v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V8\" />"),
    BEER_OFF(
        "beer-off",
        "<path d=\"M13 13v5\" />\n  <path d=\"M17 11.47V8\" />\n  <path d=\"M17 11h1a3 3 0 0 1 2.745 4.211\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M5 8v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M7.536 7.535C6.766 7.649 6.154 8 5.5 8a2.5 2.5 0 0 1-1.768-4.268\" />\n  <path d=\"M8.727 3.204C9.306 2.767 9.885 2 11 2c1.56 0 2 1.5 3 1.5s1.72-.5 2.5-.5a1 1 0 1 1 0 5c-.78 0-1.5-.5-2.5-.5a3.149 3.149 0 0 0-.842.12\" />\n  <path d=\"M9 14.6V18\" />"),
    BLENDER(
        "blender",
        "<path d=\"M8 14a2 2 0 0 0-1.963 1.615l-1.018 5.193A1 1 0 0 0 6 22h12a1 1 0 0 0 .981-1.192l-1.018-5.193A2 2 0 0 0 16 14z\" />\n  <path d=\"m17 2-1 12\" />\n  <path d=\"M8.006 14 7 2\" />\n  <path d=\"M7.565 8.787A5 5 0 0 0 12 8a5 5 0 0 1 4.56-.75\" />\n  <path d=\"M19 2H5a2 2 0 0 0-2 2v5a2 2 0 0 0 .688 1.5\" />\n  <path d=\"M12 18h.01\" />"),
    BOTTLE_WINE(
        "bottle-wine",
        "<path d=\"M10 3a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1v2a6 6 0 0 0 1.2 3.6l.6.8A6 6 0 0 1 17 13v8a1 1 0 0 1-1 1H8a1 1 0 0 1-1-1v-8a6 6 0 0 1 1.2-3.6l.6-.8A6 6 0 0 0 10 5z\" />\n  <path d=\"M17 13h-4a1 1 0 0 0-1 1v3a1 1 0 0 0 1 1h4\" />"),
    BROCCOLI(
        "broccoli",
        "<path d=\"M10 13a3 3 0 01-2.121-5.121\" />\n  <path d=\"M15.606 14.204c-3.5 1.5-5.899 4.503-8.899 7.503A1 1 0 016 22c-2 0-4-2-4-4a1 1 0 01.293-.707c1.911-1.911 3.823-3.578 5.347-5.441\" />\n  <path d=\"M16.573 14.737A4 4 0 0114 11\" />\n  <path d=\"M7.14 10.907a4 4 0 112.756-7.43A4 4 0 0116.7 4.48a2 2 0 012.82 2.82 4 4 0 011.002 6.805 4 4 0 11-7.51 1.59\" />"),
    CAKE(
        "cake",
        "<path d=\"M20 21v-8a2 2 0 0 0-2-2H6a2 2 0 0 0-2 2v8\" />\n  <path d=\"M4 16s.5-1 2-1 2.5 2 4 2 2.5-2 4-2 2.5 2 4 2 2-1 2-1\" />\n  <path d=\"M2 21h20\" />\n  <path d=\"M7 8v3\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"M17 8v3\" />\n  <path d=\"M7 4h.01\" />\n  <path d=\"M12 4h.01\" />\n  <path d=\"M17 4h.01\" />"),
    CAKE_SLICE(
        "cake-slice",
        "<path d=\"M16 13H3\" />\n  <path d=\"M16 17H3\" />\n  <path d=\"m7.2 7.9-3.388 2.5A2 2 0 0 0 3 12.01V20a1 1 0 0 0 1 1h16a1 1 0 0 0 1-1v-8.654c0-2-2.44-6.026-6.44-8.026a1 1 0 0 0-1.082.057L10.4 5.6\" />\n  <circle cx=\"9\" cy=\"7\" r=\"2\" />"),
    CAN(
        "can",
        "<path d=\"M21 10.5a9 2.5 0 01-18 0v8a9 2.5 0 0018 0z\" />\n  <path d=\"M21 10.5A9 2.5 25.32 004.59 3.47 9 2.5 25.32 0021 10.5\" />\n  <path d=\"M3 10.5a9 2.5 0 016.527-2.405\" />\n  <path d=\"M9 16.858a31 31 0 006 0\" />"),
    CAN_SODA(
        "can-soda",
        "<path d=\"m17 22 1.664-2.496a2 2 0 00.336-1.11V5.606a2 2 0 00-.336-1.11L17 2\" />\n  <path d=\"M18 22H6\" />\n  <path d=\"M18 2H6\" />\n  <path d=\"M5 17h14\" />\n  <path d=\"M5 7h14\" />\n  <path d=\"m7 22-1.664-2.496A2 2 0 015 18.394V5.606a2 2 0 01.336-1.11L7 2\" />"),
    CANDY(
        "candy",
        "<path d=\"M10 7v10.9\" />\n  <path d=\"M14 6.1V17\" />\n  <path d=\"M16 7V3a1 1 0 0 1 1.707-.707 2.5 2.5 0 0 0 2.152.717 1 1 0 0 1 1.131 1.131 2.5 2.5 0 0 0 .717 2.152A1 1 0 0 1 21 8h-4\" />\n  <path d=\"M16.536 7.465a5 5 0 0 0-7.072 0l-2 2a5 5 0 0 0 0 7.07 5 5 0 0 0 7.072 0l2-2a5 5 0 0 0 0-7.07\" />\n  <path d=\"M8 17v4a1 1 0 0 1-1.707.707 2.5 2.5 0 0 0-2.152-.717 1 1 0 0 1-1.131-1.131 2.5 2.5 0 0 0-.717-2.152A1 1 0 0 1 3 16h4\" />"),
    CANDY_CANE(
        "candy-cane",
        "<path d=\"m10.8 5 2.111 4.223\" />\n  <path d=\"M17.75 7 15 2.1\" />\n  <path d=\"m4.874 14.647 2.12 4.24\" />\n  <path d=\"M5.7 21a2 2 0 0 1-3.5-2l8.6-14a6 6 0 0 1 10.4 6 2 2 0 1 1-3.464-2 2 2 0 1 0-3.464-2z\" />\n  <path d=\"m7.906 9.712 2.005 4.411\" />"),
    CANDY_OFF(
        "candy-off",
        "<path d=\"M10 10v7.9\" />\n  <path d=\"M11.802 6.145a5 5 0 0 1 6.053 6.053\" />\n  <path d=\"M14 6.1v2.243\" />\n  <path d=\"m15.5 15.571-.964.964a5 5 0 0 1-7.071 0 5 5 0 0 1 0-7.07l.964-.965\" />\n  <path d=\"M16 7V3a1 1 0 0 1 1.707-.707 2.5 2.5 0 0 0 2.152.717 1 1 0 0 1 1.131 1.131 2.5 2.5 0 0 0 .717 2.152A1 1 0 0 1 21 8h-4\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8 17v4a1 1 0 0 1-1.707.707 2.5 2.5 0 0 0-2.152-.717 1 1 0 0 1-1.131-1.131 2.5 2.5 0 0 0-.717-2.152A1 1 0 0 1 3 16h4\" />"),
    CARROT(
        "carrot",
        "<path d=\"M15 16a1 1 0 0 0-7-7q-4 4-5.987 12.385a.5.5 0 0 0 .602.602Q11 20 15 16l-3-3\" />\n  <path d=\"M15 9q4 4 7 0-3-4-7 0 4-4 0-7-4 3 0 7\" />\n  <path d=\"m8 15-2.58-2.58\" />"),
    CARTON(
        "carton",
        "<path d=\"M13 22V10a2 2 0 01.539-1.367L16 6H8L5.539 8.633A2 2 0 005 10v10a2 2 0 002 2h10a2 2 0 002-2V10a2 2 0 00-.539-1.367L16 6V3a1 1 0 00-1-1H9a1 1 0 00-1 1v3\" />\n  <path d=\"M5 10h8\" />"),
    CARTON_OFF(
        "carton-off",
        "<path d=\"M10 10H5v10a2 2 0 002 2h10a2 2 0 002-2v-1\" />\n  <path d=\"M13 22v-9\" />\n  <path d=\"M13.902 8.245 16 6h-4.343\" />\n  <path d=\"M19 13.343V10a2 2 0 00-.539-1.367L16 6V3a1 1 0 00-1-1H9a1 1 0 00-.857.486\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M7.034 7.034 5.539 8.633A2 2 0 005 10\" />"),
    CHEF_HAT(
        "chef-hat",
        "<path d=\"M17 21a1 1 0 0 0 1-1v-5.35c0-.457.316-.844.727-1.041a4 4 0 0 0-2.134-7.589 5 5 0 0 0-9.186 0 4 4 0 0 0-2.134 7.588c.411.198.727.585.727 1.041V20a1 1 0 0 0 1 1Z\" />\n  <path d=\"M6 17h12\" />"),
    CHERRY(
        "cherry",
        "<path d=\"M2 17a5 5 0 0 0 10 0c0-2.76-2.5-5-5-3-2.5-2-5 .24-5 3Z\" />\n  <path d=\"M12 17a5 5 0 0 0 10 0c0-2.76-2.5-5-5-3-2.5-2-5 .24-5 3Z\" />\n  <path d=\"M7 14c3.22-2.91 4.29-8.75 5-12 1.66 2.38 4.94 9 5 12\" />\n  <path d=\"M22 9c-4.29 0-7.14-2.33-10-7 5.71 0 10 4.67 10 7Z\" />"),
    CITRUS(
        "citrus",
        "<path d=\"M21.66 17.67a1.08 1.08 0 0 1-.04 1.6A12 12 0 0 1 4.73 2.38a1.1 1.1 0 0 1 1.61-.04z\" />\n  <path d=\"M19.65 15.66A8 8 0 0 1 8.35 4.34\" />\n  <path d=\"m14 10-5.5 5.5\" />\n  <path d=\"M14 17.85V10H6.15\" />"),
    COFFEE(
        "coffee",
        "<path d=\"M10 2v2\" />\n  <path d=\"M14 2v2\" />\n  <path d=\"M16 8a1 1 0 0 1 1 1v8a4 4 0 0 1-4 4H7a4 4 0 0 1-4-4V9a1 1 0 0 1 1-1h14a4 4 0 1 1 0 8h-1\" />\n  <path d=\"M6 2v2\" />"),
    COOKIE(
        "cookie",
        "<path d=\"M11 17h.01\" />\n  <path d=\"M11.496 2c.324-.016.558.292.529.615a4 4 0 004.235 4.368.713.713 0 01.758.757 4 4 0 004.366 4.237c.323-.03.63.204.614.527a10 10 0 01-2.915 6.566A1 1 0 114.93 4.918 10 10 0 0111.496 2\" />\n  <path d=\"M12 12h.01\" />\n  <path d=\"M16 16h.01\" />\n  <path d=\"M16 3h.01\" />\n  <path d=\"M21 4h.01\" />\n  <path d=\"M21 8h.01\" />\n  <path d=\"M7 14h.01\" />\n  <path d=\"M9 8h.01\" />"),
    COOKING_POT(
        "cooking-pot",
        "<path d=\"M2 12h20\" />\n  <path d=\"M20 12v8a2 2 0 0 1-2 2H6a2 2 0 0 1-2-2v-8\" />\n  <path d=\"m4 8 16-4\" />\n  <path d=\"m8.86 6.78-.45-1.81a2 2 0 0 1 1.45-2.43l1.94-.48a2 2 0 0 1 2.43 1.46l.45 1.8\" />"),
    CROISSANT(
        "croissant",
        "<path d=\"M10.2 18H4.774a1.5 1.5 0 0 1-1.352-.97 11 11 0 0 1 .132-6.487\" />\n  <path d=\"M18 10.2V4.774a1.5 1.5 0 0 0-.97-1.352 11 11 0 0 0-6.486.132\" />\n  <path d=\"M18 5a4 3 0 0 1 4 3 2 2 0 0 1-2 2 10 10 0 0 0-5.139 1.42\" />\n  <path d=\"M5 18a3 4 0 0 0 3 4 2 2 0 0 0 2-2 10 10 0 0 1 1.42-5.14\" />\n  <path d=\"M8.709 2.554a10 10 0 0 0-6.155 6.155 1.5 1.5 0 0 0 .676 1.626l9.807 5.42a2 2 0 0 0 2.718-2.718l-5.42-9.807a1.5 1.5 0 0 0-1.626-.676\" />"),
    CUBOID(
        "cuboid",
        "<path d=\"M10 22v-8\" />\n  <path d=\"M2.336 8.89 10 14l11.715-7.029\" />\n  <path d=\"M22 14a2 2 0 0 1-.971 1.715l-10 6a2 2 0 0 1-2.138-.05l-6-4A2 2 0 0 1 2 16v-6a2 2 0 0 1 .971-1.715l10-6a2 2 0 0 1 2.138.05l6 4A2 2 0 0 1 22 8z\" />"),
    CUP_SODA(
        "cup-soda",
        "<path d=\"m6 8 1.75 12.28a2 2 0 0 0 2 1.72h4.54a2 2 0 0 0 2-1.72L18 8\" />\n  <path d=\"M5 8h14\" />\n  <path d=\"M7 15a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />\n  <path d=\"m12 8 1-6h2\" />"),
    CUPCAKE(
        "cupcake",
        "<path d=\"M12 22v-9\" />\n  <path d=\"M14 4h1a3 3 0 013 3l-.004.125A4 4 0 0121 11v2\" />\n  <path d=\"m15.5 22 1.5-9\" />\n  <path d=\"M21 13a1 1 0 01.919 1.394l-2.74 6.394A2 2 0 0117.34 22H6.659a2 2 0 01-1.838-1.212l-2.74-6.394A1 1 0 013 13z\" />\n  <path d=\"M3 13v-2a4 4 0 013.003-3.875L6 7a3 3 0 013-3h1\" />\n  <path d=\"M8.5 22 7 13\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />"),
    DESSERT(
        "dessert",
        "<path d=\"M10.162 3.167A10 10 0 0 0 2 13a2 2 0 0 0 4 0v-1a2 2 0 0 1 4 0v4a2 2 0 0 0 4 0v-4a2 2 0 0 1 4 0v1a2 2 0 0 0 4-.006 10 10 0 0 0-8.161-9.826\" />\n  <path d=\"M20.804 14.869a9 9 0 0 1-17.608 0\" />\n  <circle cx=\"12\" cy=\"4\" r=\"2\" />"),
    DNA_OFF(
        "dna-off",
        "<path d=\"M15 2c-1.35 1.5-2.092 3-2.5 4.5L14 8\" />\n  <path d=\"m17 6-2.891-2.891\" />\n  <path d=\"M2 15c3.333-3 6.667-3 10-3\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"m20 9 .891.891\" />\n  <path d=\"M22 9c-1.5 1.35-3 2.092-4.5 2.5l-1-1\" />\n  <path d=\"M3.109 14.109 4 15\" />\n  <path d=\"m6.5 12.5 1 1\" />\n  <path d=\"m7 18 2.891 2.891\" />\n  <path d=\"M9 22c1.35-1.5 2.092-3 2.5-4.5L10 16\" />"),
    DONUT(
        "donut",
        "<path d=\"M20.5 10a2.5 2.5 0 0 1-2.4-3H18a2.95 2.95 0 0 1-2.6-4.4 10 10 0 1 0 6.3 7.1c-.3.2-.8.3-1.2.3\" />\n  <circle cx=\"12\" cy=\"12\" r=\"3\" />"),
    DOOR_CLOSED_PACKAGE(
        "door-closed-package",
        "<path d=\"M18 13v3\" />\n  <path d=\"M19 9V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16\" />\n  <path d=\"M2 21h8\" />\n  <path d=\"M9 12h.01\" />\n  <rect x=\"14\" y=\"13\" width=\"8\" height=\"8\" rx=\"1\" />"),
    DRUMSTICK(
        "drumstick",
        "<path d=\"M15.4 15.63a7.875 6 135 1 1 6.23-6.23 4.5 3.43 135 0 0-6.23 6.23\" />\n  <path d=\"m8.29 12.71-2.6 2.6a2.5 2.5 0 1 0-1.65 4.65A2.5 2.5 0 1 0 8.7 18.3l2.59-2.59\" />"),
    EGG("egg", "<path d=\"M12 2C8 2 4 8 4 14a8 8 0 0 0 16 0c0-6-4-12-8-12\" />"),
    EGG_FRIED(
        "egg-fried",
        "<circle cx=\"11.5\" cy=\"12.5\" r=\"3.5\" />\n  <path d=\"M3 8c0-3.5 2.5-6 6.5-6 5 0 4.83 3 7.5 5s5 2 5 6c0 4.5-2.5 6.5-7 6.5-2.5 0-2.5 2.5-6 2.5s-7-2-7-5.5c0-3 1.5-3 1.5-5C3.5 10 3 9 3 8Z\" />"),
    EGG_OFF(
        "egg-off",
        "<path d=\"m2 2 20 20\" />\n  <path d=\"M20 14.347V14c0-6-4-12-8-12-1.078 0-2.157.436-3.157 1.19\" />\n  <path d=\"M6.206 6.21C4.871 8.4 4 11.2 4 14a8 8 0 0 0 14.568 4.568\" />"),
    FAUCET(
        "faucet",
        "<path d=\"M10.083 5.428 5.57 4.083a2 2 0 10.001 3.834l4.512-1.345\" />\n  <path d=\"M12 8v3\" />\n  <path d=\"m13.917 5.428 4.511-1.345a2 2 0 110 3.834l-4.51-1.345\" />\n  <path d=\"M18 17v-4.006\" />\n  <path d=\"M22 11v8\" />\n  <path d=\"M22 12h-3a1 1 0 00-1 .994h-2.539a4 4 0 00-6.915-.012L7 13a5 5 0 00-5 5v1a1 1 0 001 1h2a1 1 0 001-1v-1a1 1 0 01.995-1l1.552.018a4 4 0 006.907 0L18 17a1 1 0 001 1h3\" />\n  <circle cx=\"12\" cy=\"6\" r=\"2\" />"),
    FISH(
        "fish",
        "<path d=\"M6.5 12c.94-3.46 4.94-6 8.5-6 3.56 0 6.06 2.54 7 6-.94 3.47-3.44 6-7 6s-7.56-2.53-8.5-6Z\" />\n  <path d=\"M18 12v.5\" />\n  <path d=\"M16 17.93a9.77 9.77 0 0 1 0-11.86\" />\n  <path d=\"M7 10.67C7 8 5.58 5.97 2.73 5.5c-1 1.5-1 5 .23 6.5-1.24 1.5-1.24 5-.23 6.5C5.58 18.03 7 16 7 13.33\" />\n  <path d=\"M10.46 7.26C10.2 5.88 9.17 4.24 8 3h5.8a2 2 0 0 1 1.98 1.67l.23 1.4\" />\n  <path d=\"m16.01 17.93-.23 1.4A2 2 0 0 1 13.8 21H9.5a5.96 5.96 0 0 0 1.49-3.98\" />"),
    FISH_OFF(
        "fish-off",
        "<path d=\"M18 12.47v.03m0-.5v.47m-.475 5.056A6.744 6.744 0 0 1 15 18c-3.56 0-7.56-2.53-8.5-6 .348-1.28 1.114-2.433 2.121-3.38m3.444-2.088A8.802 8.802 0 0 1 15 6c3.56 0 6.06 2.54 7 6-.309 1.14-.786 2.177-1.413 3.058\" />\n  <path d=\"M7 10.67C7 8 5.58 5.97 2.73 5.5c-1 1.5-1 5 .23 6.5-1.24 1.5-1.24 5-.23 6.5C5.58 18.03 7 16 7 13.33m7.48-4.372A9.77 9.77 0 0 1 16 6.07m0 11.86a9.77 9.77 0 0 1-1.728-3.618\" />\n  <path d=\"m16.01 17.93-.23 1.4A2 2 0 0 1 13.8 21H9.5a5.96 5.96 0 0 0 1.49-3.98M8.53 3h5.27a2 2 0 0 1 1.98 1.67l.23 1.4M2 2l20 20\" />"),
    FISH_SYMBOL("fish-symbol", "<path d=\"M2 16s9-15 20-4C11 23 2 8 2 8\" />"),
    GLASS_WATER(
        "glass-water",
        "<path d=\"M5.116 4.104A1 1 0 0 1 6.11 3h11.78a1 1 0 0 1 .994 1.105L17.19 20.21A2 2 0 0 1 15.2 22H8.8a2 2 0 0 1-2-1.79z\" />\n  <path d=\"M6 12a5 5 0 0 1 6 0 5 5 0 0 0 6 0\" />"),
    GRAPE(
        "grape",
        "<path d=\"M22 5V2l-5.89 5.89\" />\n  <circle cx=\"16.6\" cy=\"15.89\" r=\"3\" />\n  <circle cx=\"8.11\" cy=\"7.4\" r=\"3\" />\n  <circle cx=\"12.35\" cy=\"11.65\" r=\"3\" />\n  <circle cx=\"13.91\" cy=\"5.85\" r=\"3\" />\n  <circle cx=\"18.15\" cy=\"10.09\" r=\"3\" />\n  <circle cx=\"6.56\" cy=\"13.2\" r=\"3\" />\n  <circle cx=\"10.8\" cy=\"17.44\" r=\"3\" />\n  <circle cx=\"5\" cy=\"19\" r=\"3\" />"),
    GROCERIES(
        "groceries",
        "<path d=\"M10 15h4\" />\n  <path d=\"M19.424 11.095a2.5 2.5 0 00.471-2.309 2 2 0 00.424-3.286 2 2 0 00-2.143-3.322 2 2 0 00-.676.502 2 2 0 00-3.287.424 2.5 2.5 0 00-3.189 2.06A3 3 0 0012 11l4-4\" />\n  <path d=\"M4 12.006A1 1 0 014.994 11H19a1 1 0 011 1v7a2 2 0 01-2 2H6a2 2 0 01-2-2z\" />\n  <path d=\"M7 11a4 4 0 01-4-4V5a1 1 0 011-1h2a4 4 0 013.584 2.222\" />"),
    HAM(
        "ham",
        "<path d=\"M13.144 21.144A7.274 10.445 45 1 0 2.856 10.856\" />\n  <path d=\"M13.144 21.144A7.274 4.365 45 0 0 2.856 10.856a7.274 4.365 45 0 0 10.288 10.288\" />\n  <path d=\"M16.565 10.435 18.6 8.4a2.501 2.501 0 1 0 1.65-4.65 2.5 2.5 0 1 0-4.66 1.66l-2.024 2.025\" />\n  <path d=\"m8.5 16.5-1-1\" />"),
    HAMBURGER(
        "hamburger",
        "<path d=\"M12 16H4a2 2 0 1 1 0-4h16a2 2 0 1 1 0 4h-4.25\" />\n  <path d=\"M5 12a2 2 0 0 1-2-2 9 7 0 0 1 18 0 2 2 0 0 1-2 2\" />\n  <path d=\"M5 16a2 2 0 0 0-2 2 3 3 0 0 0 3 3h12a3 3 0 0 0 3-3 2 2 0 0 0-2-2q0 0 0 0\" />\n  <path d=\"m6.67 12 6.13 4.6a2 2 0 0 0 2.8-.4l3.15-4.2\" />"),
    HAND_PLATTER(
        "hand-platter",
        "<path d=\"M12 3V2\" />\n  <path d=\"m15.4 17.4 3.2-2.8a2 2 0 1 1 2.8 2.9l-3.6 3.3c-.7.8-1.7 1.2-2.8 1.2h-4c-1.1 0-2.1-.4-2.8-1.2l-1.302-1.464A1 1 0 0 0 6.151 19H5\" />\n  <path d=\"M2 14h12a2 2 0 0 1 0 4h-2\" />\n  <path d=\"M4 10h16\" />\n  <path d=\"M5 10a7 7 0 0 1 14 0\" />\n  <path d=\"M5 14v6a1 1 0 0 1-1 1H2\" />"),
    HOP(
        "hop",
        "<path d=\"M10.82 16.12c1.69.6 3.91.79 5.18.85.55.03 1-.42.97-.97-.06-1.27-.26-3.5-.85-5.18\" />\n  <path d=\"M11.5 6.5c1.64 0 5-.38 6.71-1.07.52-.2.55-.82.12-1.17A10 10 0 0 0 4.26 18.33c.35.43.96.4 1.17-.12.69-1.71 1.07-5.07 1.07-6.71 1.34.45 3.1.9 4.88.62a.88.88 0 0 0 .73-.74c.3-2.14-.15-3.5-.61-4.88\" />\n  <path d=\"M15.62 16.95c.2.85.62 2.76.5 4.28a.77.77 0 0 1-.9.7 16.64 16.64 0 0 1-4.08-1.36\" />\n  <path d=\"M16.13 21.05c1.65.63 3.68.84 4.87.91a.9.9 0 0 0 .96-.96 17.68 17.68 0 0 0-.9-4.87\" />\n  <path d=\"M16.94 15.62c.86.2 2.77.62 4.29.5a.77.77 0 0 0 .7-.9 16.64 16.64 0 0 0-1.36-4.08\" />\n  <path d=\"M17.99 5.52a20.82 20.82 0 0 1 3.15 4.5.8.8 0 0 1-.68 1.13c-2.33.2-5.3-.32-8.27-1.57\" />\n  <path d=\"M4.93 4.93 3 3a.7.7 0 0 1 0-1\" />\n  <path d=\"M9.58 12.18c1.24 2.98 1.77 5.95 1.57 8.28a.8.8 0 0 1-1.13.68 20.82 20.82 0 0 1-4.5-3.15\" />"),
    HOP_OFF(
        "hop-off",
        "<path d=\"M10.82 16.12c1.69.6 3.91.79 5.18.85.28.01.53-.09.7-.27\" />\n  <path d=\"M11.14 20.57c.52.24 2.44 1.12 4.08 1.37.46.06.86-.25.9-.71.12-1.52-.3-3.43-.5-4.28\" />\n  <path d=\"M16.13 21.05c1.65.63 3.68.84 4.87.91a.9.9 0 0 0 .7-.26\" />\n  <path d=\"M17.99 5.52a20.83 20.83 0 0 1 3.15 4.5.8.8 0 0 1-.68 1.13c-1.17.1-2.5.02-3.9-.25\" />\n  <path d=\"M20.57 11.14c.24.52 1.12 2.44 1.37 4.08.04.3-.08.59-.31.75\" />\n  <path d=\"M4.93 4.93a10 10 0 0 0-.67 13.4c.35.43.96.4 1.17-.12.69-1.71 1.07-5.07 1.07-6.71 1.34.45 3.1.9 4.88.62a.85.85 0 0 0 .48-.24\" />\n  <path d=\"M5.52 17.99c1.05.95 2.91 2.42 4.5 3.15a.8.8 0 0 0 1.13-.68c.2-2.34-.33-5.3-1.57-8.28\" />\n  <path d=\"M8.35 2.68a10 10 0 0 1 9.98 1.58c.43.35.4.96-.12 1.17-1.5.6-4.3.98-6.07 1.05\" />\n  <path d=\"m2 2 20 20\" />"),
    ICE_CREAM_BOWL(
        "ice-cream-bowl",
        "<path d=\"M12 17c5 0 8-2.69 8-6H4c0 3.31 3 6 8 6m-4 4h8m-4-3v3M5.14 11a3.5 3.5 0 1 1 6.71 0\" />\n  <path d=\"M12.14 11a3.5 3.5 0 1 1 6.71 0\" />\n  <path d=\"M15.5 6.5a3.5 3.5 0 1 0-7 0\" />"),
    ICE_CREAM_CONE(
        "ice-cream-cone",
        "<path d=\"m7 11 4.08 10.35a1 1 0 0 0 1.84 0L17 11\" />\n  <path d=\"M17 7A5 5 0 0 0 7 7\" />\n  <path d=\"M17 7a2 2 0 0 1 0 4H7a2 2 0 0 1 0-4\" />"),
    LEAFY_GREEN(
        "leafy-green",
        "<path d=\"M2 22c1.25-.987 2.27-1.975 3.9-2.2a5.56 5.56 0 0 1 3.8 1.5 4 4 0 0 0 6.187-2.353 3.5 3.5 0 0 0 3.69-5.116A3.5 3.5 0 0 0 20.95 8 3.5 3.5 0 1 0 16 3.05a3.5 3.5 0 0 0-5.831 1.373 3.5 3.5 0 0 0-5.116 3.69 4 4 0 0 0-2.348 6.155C3.499 15.42 4.409 16.712 4.2 18.1 3.926 19.743 3.014 20.732 2 22\" />\n  <path d=\"M2 22 17 7\" />"),
    LOLLIPOP(
        "lollipop",
        "<circle cx=\"11\" cy=\"11\" r=\"8\" />\n  <path d=\"m21 21-4.3-4.3\" />\n  <path d=\"M11 11a2 2 0 0 0 4 0 4 4 0 0 0-8 0 6 6 0 0 0 12 0\" />"),
    MARTINI(
        "martini",
        "<path d=\"M12 12 4.207 4.207A.707.707 0 0 1 4.707 3h14.586a.707.707 0 0 1 .5 1.207z\" />\n  <path d=\"M12 12v10\" />\n  <path d=\"M7 22h10\" />"),
    MICROWAVE(
        "microwave",
        "<rect width=\"20\" height=\"15\" x=\"2\" y=\"4\" rx=\"2\" />\n  <rect width=\"8\" height=\"7\" x=\"6\" y=\"8\" rx=\"1\" />\n  <path d=\"M18 8v7\" />\n  <path d=\"M6 19v2\" />\n  <path d=\"M18 19v2\" />"),
    MILK(
        "milk",
        "<path d=\"M8 2h8\" />\n  <path d=\"M9 2v2.789a4 4 0 0 1-.672 2.219l-.656.984A4 4 0 0 0 7 10.212V20a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-9.789a4 4 0 0 0-.672-2.219l-.656-.984A4 4 0 0 1 15 4.788V2\" />\n  <path d=\"M7 15a6.472 6.472 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />"),
    MILK_OFF(
        "milk-off",
        "<path d=\"M8 2h8\" />\n  <path d=\"M9 2v1.343M15 2v2.789a4 4 0 0 0 .672 2.219l.656.984a4 4 0 0 1 .672 2.22v1.131M7.8 7.8l-.128.192A4 4 0 0 0 7 10.212V20a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2v-3\" />\n  <path d=\"M7 15a6.47 6.47 0 0 1 5 0 6.472 6.472 0 0 0 3.435.435\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    NUT(
        "nut",
        "<path d=\"M16.847 5.847 20 9a7.23 7.23 0 011.551 7.516C21.241 17.352 21 17.932 21 19v1a1 1 0 01-1 1h-1c-1.069 0-1.648.242-2.485.552A7.2 7.2 0 019.002 20l-3.155-3.153\" />\n  <path d=\"M18.21 5.43c-1.71.69-5.07 1.07-6.71 1.07.46 1.38.91 2.74.61 4.88a.88.88 0 01-.73.74c-1.78.28-3.54-.17-4.88-.62 0 1.64-.38 5-1.07 6.71-.21.52-.82.55-1.17.12A10 10 0 0118.33 4.26c.43.35.4.97-.12 1.17\" />\n  <path d=\"M4.93 4.93 3 3a.7.7 0 010-1\" />"),
    NUT_OFF(
        "nut-off",
        "<path d=\"M11.868 11.868a.88.88 0 01-.488.252c-1.78.28-3.54-.17-4.88-.62 0 1.272-.229 3.578-.653 5.347a10 10 0 01-.417 1.363c-.21.52-.82.55-1.17.12a10 10 0 01.677-13.393\" />\n  <path d=\"M12.14 6.485a27.4 27.4 0 004.707-.638L20 9a7.23 7.23 0 011.706 7.05\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M20.707 20.707A1 1 0 0120 21h-1c-1.069 0-1.648.242-2.485.552A7.2 7.2 0 019.002 20l-3.155-3.153\" />\n  <path d=\"M8.356 2.7a10 10 0 019.974 1.56c.43.35.4.97-.12 1.17a10 10 0 01-1.363.417\" />"),
    PAPER_BAG(
        "paper-bag",
        "<path d=\"M5.364 3.848C4 6 3 9.652 3 12.652V19a2 2 0 002 2h14a2 2 0 002-2v-5c0-2.334-1.816-4.668-2.622-7.002\" />\n  <path d=\"M7 3h11.379a2 2 0 011.789 1.106l.723 1.447A1 1 0 0119.997 7h-8.525a2 2 0 01-1.789-1.106L8.79 4.105a2 2 0 10-3.579 1.789l2.261 4.522A5 5 0 018 12.652V21\" />"),
    PIZZA(
        "pizza",
        "<path d=\"m12 14-1 1\" />\n  <path d=\"m13.75 18.25-1.25 1.42\" />\n  <path d=\"M17.775 5.654a15.68 15.68 0 0 0-12.121 12.12\" />\n  <path d=\"M18.8 9.3a1 1 0 0 0 2.1 7.7\" />\n  <path d=\"M21.964 20.732a1 1 0 0 1-1.232 1.232l-18-5a1 1 0 0 1-.695-1.232A19.68 19.68 0 0 1 15.732 2.037a1 1 0 0 1 1.232.695z\" />"),
    POPCORN(
        "popcorn",
        "<path d=\"M18 8a2 2 0 0 0 0-4 2 2 0 0 0-4 0 2 2 0 0 0-4 0 2 2 0 0 0-4 0 2 2 0 0 0 0 4\" />\n  <path d=\"M10 22 9 8\" />\n  <path d=\"m14 22 1-14\" />\n  <path d=\"M20 8c.5 0 .9.4.8 1l-2.6 12c-.1.5-.7 1-1.2 1H7c-.6 0-1.1-.4-1.2-1L3.2 9c-.1-.6.3-1 .8-1Z\" />"),
    POPSICLE(
        "popsicle",
        "<path d=\"M18.6 14.4c.8-.8.8-2 0-2.8l-8.1-8.1a4.95 4.95 0 1 0-7.1 7.1l8.1 8.1c.9.7 2.1.7 2.9-.1Z\" />\n  <path d=\"m22 22-5.5-5.5\" />"),
    REFRIGERATOR(
        "refrigerator",
        "<path d=\"M5 6a4 4 0 0 1 4-4h6a4 4 0 0 1 4 4v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6Z\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M15 7v6\" />"),
    SALAD(
        "salad",
        "<path d=\"M19.496 12a2.5 2.5 0 00.399-2.214A2 2 0 0020.32 6.5 2 2 0 0019 3a2 2 0 00-1.5.68 2 2 0 00-3.287.424 2.5 2.5 0 00-3.189 2.06A3 3 0 0012 12l4-4\" />\n  <path d=\"M4 12a1 1 0 00-.99 1.133A9 9 0 0012 21a9 9 0 008.99-7.867A1 1 0 0020 12z\" />\n  <path d=\"M7 21h10\" />\n  <path d=\"M9.85 6.907A3.5 3.5 0 005.05 12\" />"),
    SANDWICH(
        "sandwich",
        "<path d=\"m2.37 11.223 8.372-6.777a2 2 0 0 1 2.516 0l8.371 6.777\" />\n  <path d=\"M21 15a1 1 0 0 1 1 1v2a1 1 0 0 1-1 1h-5.25\" />\n  <path d=\"M3 15a1 1 0 0 0-1 1v2a1 1 0 0 0 1 1h9\" />\n  <path d=\"m6.67 15 6.13 4.6a2 2 0 0 0 2.8-.4l3.15-4.2\" />\n  <rect width=\"20\" height=\"4\" x=\"2\" y=\"11\" rx=\"1\" />"),
    SHELL(
        "shell",
        "<path d=\"M14 11a2 2 0 1 1-4 0 4 4 0 0 1 8 0 6 6 0 0 1-12 0 8 8 0 0 1 16 0 10 10 0 1 1-20 0 11.93 11.93 0 0 1 2.42-7.22 2 2 0 1 1 3.16 2.44\" />"),
    SHRIMP(
        "shrimp",
        "<path d=\"M10 2a3.28 3.28 0 003.227 1.798l6.17-.561A1 1 0 1119.614 8H8.5a6.44 6.44 0 00-5.63 9.75A6.5 6.5 0 008.5 21c1.38 0 2-.5 2.5-1\" />\n  <path d=\"M10 8a8.5 8.5 0 000 8\" />\n  <path d=\"M11 22c-.5-.5-1.12-1-2.5-1a1 1 0 010-5H12a7 7 0 007-7V8\" />\n  <path d=\"M13 12h.01\" />\n  <path d=\"M8 16c-2 0-4.5-4-4-6\" />"),
    SHRIMP_OFF(
        "shrimp-off",
        "<path d=\"M10 2a3.28 3.28 0 003.227 1.798l6.17-.561A1 1 0 1119.614 8H13.5\" />\n  <path d=\"M11 20c-.5.5-1.12 1-2.5 1a1 1 0 010-5H12a7 7 0 003.283-.817\" />\n  <path d=\"M11 22c-.5-.5-1.12-1-2.5-1a6.5 6.5 0 01-5.63-3.25 6.44 6.44 0 015.236-9.744\" />\n  <path d=\"M18.04 12.54A7 7 0 0019 9V8\" />\n  <path d=\"m2 2 20 20\" />\n  <path d=\"M8 16c-2 0-4.5-4-4-6\" />\n  <path d=\"M9.43 9.33A8.5 8.5 0 0010 16\" />"),
    SNAIL(
        "snail",
        "<path d=\"M2 13a6 6 0 1 0 12 0 4 4 0 1 0-8 0 2 2 0 0 0 4 0\" />\n  <circle cx=\"10\" cy=\"13\" r=\"8\" />\n  <path d=\"M2 21h12c4.4 0 8-3.6 8-8V7a2 2 0 1 0-4 0v6\" />\n  <path d=\"M18 3 19.1 5.2\" />\n  <path d=\"M22 3 20.9 5.2\" />"),
    SOUP(
        "soup",
        "<path d=\"M11.248 3c.273.1.808.53.747 1.36-.05.83-.938 1.2-.989 2.02-.06.78.333 1.24.727 1.62\" />\n  <path d=\"M16.252 3c.268.1.794.53.745 1.36-.06.83-.923 1.2-.993 2.02-.05.78.338 1.24.725 1.62\" />\n  <path d=\"M19.5 12 22 6\" />\n  <path d=\"M4 12a1 1 0 00-.99 1.133A9 9 0 0012 21a9 9 0 008.99-7.867A1 1 0 0020 12z\" />\n  <path d=\"M6.252 3c.268.1.794.53.745 1.36-.06.83-.923 1.2-.993 2.02-.05.78.338 1.24.735 1.62\" />\n  <path d=\"M7 21h10\" />"),
    TORUS(
        "torus",
        "<ellipse cx=\"12\" cy=\"11\" rx=\"3\" ry=\"2\" />\n  <ellipse cx=\"12\" cy=\"12.5\" rx=\"10\" ry=\"8.5\" />"),
    TRACTOR(
        "tractor",
        "<path d=\"m10 11 11 .9a1 1 0 0 1 .8 1.1l-.665 4.158a1 1 0 0 1-.988.842H20\" />\n  <path d=\"M16 18h-5\" />\n  <path d=\"M18 5a1 1 0 0 0-1 1v5.573\" />\n  <path d=\"M3 4h8.129a1 1 0 0 1 .99.863L13 11.246\" />\n  <path d=\"M4 11V4\" />\n  <path d=\"M7 15h.01\" />\n  <path d=\"M8 10.1V4\" />\n  <circle cx=\"18\" cy=\"18\" r=\"2\" />\n  <circle cx=\"7\" cy=\"15\" r=\"5\" />"),
    UTENSILS(
        "utensils",
        "<path d=\"M3 2v7c0 1.1.9 2 2 2h4a2 2 0 0 0 2-2V2\" />\n  <path d=\"M7 2v20\" />\n  <path d=\"M21 15V2a5 5 0 0 0-5 5v6c0 1.1.9 2 2 2h3Zm0 0v7\" />"),
    UTENSILS_CROSSED(
        "utensils-crossed",
        "<path d=\"m16 2-2.3 2.3a3 3 0 0 0 0 4.2l1.8 1.8a3 3 0 0 0 4.2 0L22 8\" />\n  <path d=\"M15 15 3.3 3.3a4.2 4.2 0 0 0 0 6l7.3 7.3c.7.7 2 .7 2.8 0L15 15Zm0 0 7 7\" />\n  <path d=\"m2.1 21.8 6.4-6.3\" />\n  <path d=\"m19 5-7 7\" />"),
    VEGAN(
        "vegan",
        "<path d=\"M16 8q6 0 6-6-6 0-6 6\" />\n  <path d=\"M17.41 3.59a10 10 0 1 0 3 3\" />\n  <path d=\"M2 2a26.6 26.6 0 0 1 10 20c.9-6.82 1.5-9.5 4-14\" />"),
    WHEAT(
        "wheat",
        "<path d=\"M2 22 16 8\" />\n  <path d=\"M3.47 12.53 5 11l1.53 1.53a3.5 3.5 0 0 1 0 4.94L5 19l-1.53-1.53a3.5 3.5 0 0 1 0-4.94Z\" />\n  <path d=\"M7.47 8.53 9 7l1.53 1.53a3.5 3.5 0 0 1 0 4.94L9 15l-1.53-1.53a3.5 3.5 0 0 1 0-4.94Z\" />\n  <path d=\"M11.47 4.53 13 3l1.53 1.53a3.5 3.5 0 0 1 0 4.94L13 11l-1.53-1.53a3.5 3.5 0 0 1 0-4.94Z\" />\n  <path d=\"M20 2h2v2a4 4 0 0 1-4 4h-2V6a4 4 0 0 1 4-4Z\" />\n  <path d=\"M11.47 17.47 13 19l-1.53 1.53a3.5 3.5 0 0 1-4.94 0L5 19l1.53-1.53a3.5 3.5 0 0 1 4.94 0Z\" />\n  <path d=\"M15.47 13.47 17 15l-1.53 1.53a3.5 3.5 0 0 1-4.94 0L9 15l1.53-1.53a3.5 3.5 0 0 1 4.94 0Z\" />\n  <path d=\"M19.47 9.47 21 11l-1.53 1.53a3.5 3.5 0 0 1-4.94 0L13 11l1.53-1.53a3.5 3.5 0 0 1 4.94 0Z\" />"),
    WHEAT_OFF(
        "wheat-off",
        "<path d=\"m2 22 10-10\" />\n  <path d=\"m16 8-1.17 1.17\" />\n  <path d=\"M3.47 12.53 5 11l1.53 1.53a3.5 3.5 0 0 1 0 4.94L5 19l-1.53-1.53a3.5 3.5 0 0 1 0-4.94Z\" />\n  <path d=\"m8 8-.53.53a3.5 3.5 0 0 0 0 4.94L9 15l1.53-1.53c.55-.55.88-1.25.98-1.97\" />\n  <path d=\"M10.91 5.26c.15-.26.34-.51.56-.73L13 3l1.53 1.53a3.5 3.5 0 0 1 .28 4.62\" />\n  <path d=\"M20 2h2v2a4 4 0 0 1-4 4h-2V6a4 4 0 0 1 4-4Z\" />\n  <path d=\"M11.47 17.47 13 19l-1.53 1.53a3.5 3.5 0 0 1-4.94 0L5 19l1.53-1.53a3.5 3.5 0 0 1 4.94 0Z\" />\n  <path d=\"m16 16-.53.53a3.5 3.5 0 0 1-4.94 0L9 15l1.53-1.53a3.49 3.49 0 0 1 1.97-.98\" />\n  <path d=\"M18.74 13.09c.26-.15.51-.34.73-.56L21 11l-1.53-1.53a3.5 3.5 0 0 0-4.62-.28\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />"),
    WINE(
        "wine",
        "<path d=\"M8 22h8\" />\n  <path d=\"M7 10h10\" />\n  <path d=\"M12 15v7\" />\n  <path d=\"M12 15a5 5 0 0 0 5-5c0-2-.5-4-2-8H9c-1.5 4-2 6-2 8a5 5 0 0 0 5 5Z\" />"),
    WINE_OFF(
        "wine-off",
        "<path d=\"M8 22h8\" />\n  <path d=\"M7 10h3m7 0h-1.343\" />\n  <path d=\"M12 15v7\" />\n  <path d=\"M7.307 7.307A12.33 12.33 0 0 0 7 10a5 5 0 0 0 7.391 4.391M8.638 2.981C8.75 2.668 8.872 2.34 9 2h6c1.5 4 2 6 2 8 0 .407-.05.809-.145 1.198\" />\n  <line x1=\"2\" x2=\"22\" y1=\"2\" y2=\"22\" />");

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
  default LucideIcon amphora_food_beverage() {
    return LucideIcon.create(Icon.AMPHORA);
  }

  default LucideIcon apple_food_beverage() {
    return LucideIcon.create(Icon.APPLE);
  }

  default LucideIcon avocado_food_beverage() {
    return LucideIcon.create(Icon.AVOCADO);
  }

  default LucideIcon bacon_food_beverage() {
    return LucideIcon.create(Icon.BACON);
  }

  default LucideIcon banana_food_beverage() {
    return LucideIcon.create(Icon.BANANA);
  }

  default LucideIcon barrel_food_beverage() {
    return LucideIcon.create(Icon.BARREL);
  }

  default LucideIcon bean_food_beverage() {
    return LucideIcon.create(Icon.BEAN);
  }

  default LucideIcon bean_off_food_beverage() {
    return LucideIcon.create(Icon.BEAN_OFF);
  }

  default LucideIcon beef_food_beverage() {
    return LucideIcon.create(Icon.BEEF);
  }

  default LucideIcon beef_off_food_beverage() {
    return LucideIcon.create(Icon.BEEF_OFF);
  }

  default LucideIcon beer_food_beverage() {
    return LucideIcon.create(Icon.BEER);
  }

  default LucideIcon beer_off_food_beverage() {
    return LucideIcon.create(Icon.BEER_OFF);
  }

  default LucideIcon blender_food_beverage() {
    return LucideIcon.create(Icon.BLENDER);
  }

  default LucideIcon bottle_wine_food_beverage() {
    return LucideIcon.create(Icon.BOTTLE_WINE);
  }

  default LucideIcon broccoli_food_beverage() {
    return LucideIcon.create(Icon.BROCCOLI);
  }

  default LucideIcon cake_food_beverage() {
    return LucideIcon.create(Icon.CAKE);
  }

  default LucideIcon cake_slice_food_beverage() {
    return LucideIcon.create(Icon.CAKE_SLICE);
  }

  default LucideIcon can_food_beverage() {
    return LucideIcon.create(Icon.CAN);
  }

  default LucideIcon can_soda_food_beverage() {
    return LucideIcon.create(Icon.CAN_SODA);
  }

  default LucideIcon candy_food_beverage() {
    return LucideIcon.create(Icon.CANDY);
  }

  default LucideIcon candy_cane_food_beverage() {
    return LucideIcon.create(Icon.CANDY_CANE);
  }

  default LucideIcon candy_off_food_beverage() {
    return LucideIcon.create(Icon.CANDY_OFF);
  }

  default LucideIcon carrot_food_beverage() {
    return LucideIcon.create(Icon.CARROT);
  }

  default LucideIcon carton_food_beverage() {
    return LucideIcon.create(Icon.CARTON);
  }

  default LucideIcon carton_off_food_beverage() {
    return LucideIcon.create(Icon.CARTON_OFF);
  }

  default LucideIcon chef_hat_food_beverage() {
    return LucideIcon.create(Icon.CHEF_HAT);
  }

  default LucideIcon cherry_food_beverage() {
    return LucideIcon.create(Icon.CHERRY);
  }

  default LucideIcon citrus_food_beverage() {
    return LucideIcon.create(Icon.CITRUS);
  }

  default LucideIcon coffee_food_beverage() {
    return LucideIcon.create(Icon.COFFEE);
  }

  default LucideIcon cookie_food_beverage() {
    return LucideIcon.create(Icon.COOKIE);
  }

  default LucideIcon cooking_pot_food_beverage() {
    return LucideIcon.create(Icon.COOKING_POT);
  }

  default LucideIcon croissant_food_beverage() {
    return LucideIcon.create(Icon.CROISSANT);
  }

  default LucideIcon cuboid_food_beverage() {
    return LucideIcon.create(Icon.CUBOID);
  }

  default LucideIcon cup_soda_food_beverage() {
    return LucideIcon.create(Icon.CUP_SODA);
  }

  default LucideIcon cupcake_food_beverage() {
    return LucideIcon.create(Icon.CUPCAKE);
  }

  default LucideIcon dessert_food_beverage() {
    return LucideIcon.create(Icon.DESSERT);
  }

  default LucideIcon dna_off_food_beverage() {
    return LucideIcon.create(Icon.DNA_OFF);
  }

  default LucideIcon donut_food_beverage() {
    return LucideIcon.create(Icon.DONUT);
  }

  default LucideIcon door_closed_package_food_beverage() {
    return LucideIcon.create(Icon.DOOR_CLOSED_PACKAGE);
  }

  default LucideIcon drumstick_food_beverage() {
    return LucideIcon.create(Icon.DRUMSTICK);
  }

  default LucideIcon egg_food_beverage() {
    return LucideIcon.create(Icon.EGG);
  }

  default LucideIcon egg_fried_food_beverage() {
    return LucideIcon.create(Icon.EGG_FRIED);
  }

  default LucideIcon egg_off_food_beverage() {
    return LucideIcon.create(Icon.EGG_OFF);
  }

  default LucideIcon faucet_food_beverage() {
    return LucideIcon.create(Icon.FAUCET);
  }

  default LucideIcon fish_food_beverage() {
    return LucideIcon.create(Icon.FISH);
  }

  default LucideIcon fish_off_food_beverage() {
    return LucideIcon.create(Icon.FISH_OFF);
  }

  default LucideIcon fish_symbol_food_beverage() {
    return LucideIcon.create(Icon.FISH_SYMBOL);
  }

  default LucideIcon glass_water_food_beverage() {
    return LucideIcon.create(Icon.GLASS_WATER);
  }

  default LucideIcon grape_food_beverage() {
    return LucideIcon.create(Icon.GRAPE);
  }

  default LucideIcon groceries_food_beverage() {
    return LucideIcon.create(Icon.GROCERIES);
  }

  default LucideIcon ham_food_beverage() {
    return LucideIcon.create(Icon.HAM);
  }

  default LucideIcon hamburger_food_beverage() {
    return LucideIcon.create(Icon.HAMBURGER);
  }

  default LucideIcon hand_platter_food_beverage() {
    return LucideIcon.create(Icon.HAND_PLATTER);
  }

  default LucideIcon hop_food_beverage() {
    return LucideIcon.create(Icon.HOP);
  }

  default LucideIcon hop_off_food_beverage() {
    return LucideIcon.create(Icon.HOP_OFF);
  }

  default LucideIcon ice_cream_bowl_food_beverage() {
    return LucideIcon.create(Icon.ICE_CREAM_BOWL);
  }

  default LucideIcon ice_cream_cone_food_beverage() {
    return LucideIcon.create(Icon.ICE_CREAM_CONE);
  }

  default LucideIcon leafy_green_food_beverage() {
    return LucideIcon.create(Icon.LEAFY_GREEN);
  }

  default LucideIcon lollipop_food_beverage() {
    return LucideIcon.create(Icon.LOLLIPOP);
  }

  default LucideIcon martini_food_beverage() {
    return LucideIcon.create(Icon.MARTINI);
  }

  default LucideIcon microwave_food_beverage() {
    return LucideIcon.create(Icon.MICROWAVE);
  }

  default LucideIcon milk_food_beverage() {
    return LucideIcon.create(Icon.MILK);
  }

  default LucideIcon milk_off_food_beverage() {
    return LucideIcon.create(Icon.MILK_OFF);
  }

  default LucideIcon nut_food_beverage() {
    return LucideIcon.create(Icon.NUT);
  }

  default LucideIcon nut_off_food_beverage() {
    return LucideIcon.create(Icon.NUT_OFF);
  }

  default LucideIcon paper_bag_food_beverage() {
    return LucideIcon.create(Icon.PAPER_BAG);
  }

  default LucideIcon pizza_food_beverage() {
    return LucideIcon.create(Icon.PIZZA);
  }

  default LucideIcon popcorn_food_beverage() {
    return LucideIcon.create(Icon.POPCORN);
  }

  default LucideIcon popsicle_food_beverage() {
    return LucideIcon.create(Icon.POPSICLE);
  }

  default LucideIcon refrigerator_food_beverage() {
    return LucideIcon.create(Icon.REFRIGERATOR);
  }

  default LucideIcon salad_food_beverage() {
    return LucideIcon.create(Icon.SALAD);
  }

  default LucideIcon sandwich_food_beverage() {
    return LucideIcon.create(Icon.SANDWICH);
  }

  default LucideIcon shell_food_beverage() {
    return LucideIcon.create(Icon.SHELL);
  }

  default LucideIcon shrimp_food_beverage() {
    return LucideIcon.create(Icon.SHRIMP);
  }

  default LucideIcon shrimp_off_food_beverage() {
    return LucideIcon.create(Icon.SHRIMP_OFF);
  }

  default LucideIcon snail_food_beverage() {
    return LucideIcon.create(Icon.SNAIL);
  }

  default LucideIcon soup_food_beverage() {
    return LucideIcon.create(Icon.SOUP);
  }

  default LucideIcon torus_food_beverage() {
    return LucideIcon.create(Icon.TORUS);
  }

  default LucideIcon tractor_food_beverage() {
    return LucideIcon.create(Icon.TRACTOR);
  }

  default LucideIcon utensils_food_beverage() {
    return LucideIcon.create(Icon.UTENSILS);
  }

  default LucideIcon utensils_crossed_food_beverage() {
    return LucideIcon.create(Icon.UTENSILS_CROSSED);
  }

  default LucideIcon vegan_food_beverage() {
    return LucideIcon.create(Icon.VEGAN);
  }

  default LucideIcon wheat_food_beverage() {
    return LucideIcon.create(Icon.WHEAT);
  }

  default LucideIcon wheat_off_food_beverage() {
    return LucideIcon.create(Icon.WHEAT_OFF);
  }

  default LucideIcon wine_food_beverage() {
    return LucideIcon.create(Icon.WINE);
  }

  default LucideIcon wine_off_food_beverage() {
    return LucideIcon.create(Icon.WINE_OFF);
  }
}
