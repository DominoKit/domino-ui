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

/** Tabler Currencies catalog category. */
public interface TablerCurrencies {
  enum OutlineIcon implements TablerIconDefinition {
    CURRENCY(
        "currency",
        "<path d=\"M5 12a7 7 0 1 0 14 0a7 7 0 1 0 -14 0\" />\n  <path d=\"M4 4l3 3\" />\n  <path d=\"M20 4l-3 3\" />\n  <path d=\"M4 20l3 -3\" />\n  <path d=\"M20 20l-3 -3\" />"),
    CURRENCY_AFGHANI(
        "currency-afghani",
        "<path d=\"M15 13h-3.5a3.5 3.5 0 1 1 3.5 -3.5v6.5h-7\" />\n  <path d=\"M12 3v.01\" />\n  <path d=\"M12 19v2\" />"),
    CURRENCY_BAHRAINI(
        "currency-bahraini",
        "<path d=\"M3 10v1a4 4 0 0 0 4 4h2a2 2 0 0 0 2 -2v-3\" />\n  <path d=\"M7 19.01v-.01\" />\n  <path d=\"M14 15.01v-.01\" />\n  <path d=\"M17 15h2a2 2 0 0 0 1.649 -3.131l-2.653 -3.869\" />"),
    CURRENCY_BAHT(
        "currency-baht",
        "<path d=\"M8 6h5a3 3 0 0 1 3 3v.143a2.857 2.857 0 0 1 -2.857 2.857h-5.143\" />\n  <path d=\"M8 12h5a3 3 0 0 1 3 3v.143a2.857 2.857 0 0 1 -2.857 2.857h-5.143\" />\n  <path d=\"M8 6v12\" />\n  <path d=\"M11 4v2\" />\n  <path d=\"M11 18v2\" />"),
    CURRENCY_BITCOIN(
        "currency-bitcoin",
        "<path d=\"M6 6h8a3 3 0 0 1 0 6a3 3 0 0 1 0 6h-8\" />\n  <path d=\"M8 6l0 12\" />\n  <path d=\"M8 12l6 0\" />\n  <path d=\"M9 3l0 3\" />\n  <path d=\"M13 3l0 3\" />\n  <path d=\"M9 18l0 3\" />\n  <path d=\"M13 18l0 3\" />"),
    CURRENCY_CENT(
        "currency-cent",
        "<path d=\"M16.007 7.54a5.965 5.965 0 0 0 -4.008 -1.54a6 6 0 0 0 -5.992 6c0 3.314 2.682 6 5.992 6a5.965 5.965 0 0 0 4 -1.536\" />\n  <path d=\"M12 20v-2\" />\n  <path d=\"M12 6v-2\" />"),
    CURRENCY_DINAR(
        "currency-dinar",
        "<path d=\"M14 20.01v-.01\" />\n  <path d=\"M6 13l2.386 -.9a1 1 0 0 0 -.095 -1.902l-1.514 -.404a1 1 0 0 1 -.102 -1.9l2.325 -.894\" />\n  <path d=\"M3 14v1a3 3 0 0 0 3 3h4.161a3 3 0 0 0 2.983 -3.32l-1.144 -10.68\" />\n  <path d=\"M16 17l1 1h2a2 2 0 0 0 1.649 -3.131l-2.653 -3.869\" />"),
    CURRENCY_DIRHAM(
        "currency-dirham",
        "<path d=\"M8.5 19h-3.5\" />\n  <path d=\"M8.599 16.479a1.5 1.5 0 1 0 -1.099 2.521\" />\n  <path d=\"M7 4v9\" />\n  <path d=\"M15 13h1.888a1.5 1.5 0 0 0 1.296 -2.256l-2.184 -3.744\" />\n  <path d=\"M11 13.01v-.01\" />"),
    CURRENCY_DOGECOIN(
        "currency-dogecoin",
        "<path d=\"M6 12h6\" />\n  <path d=\"M9 6v12\" />\n  <path d=\"M6 18h6a6 6 0 1 0 0 -12h-6\" />"),
    CURRENCY_DOLLAR(
        "currency-dollar",
        "<path d=\"M16.7 8a3 3 0 0 0 -2.7 -2h-4a3 3 0 0 0 0 6h4a3 3 0 0 1 0 6h-4a3 3 0 0 1 -2.7 -2\" />\n  <path d=\"M12 3v3m0 12v3\" />"),
    CURRENCY_DOLLAR_AUSTRALIAN(
        "currency-dollar-australian",
        "<path d=\"M3 18l3.279 -11.476a.75 .75 0 0 1 1.442 0l3.279 11.476\" />\n  <path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />\n  <path d=\"M4.5 14h5\" />"),
    CURRENCY_DOLLAR_BRUNEI(
        "currency-dollar-brunei",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />\n  <path d=\"M3 6v12h4a3 3 0 0 0 0 -6h-4h4a3 3 0 0 0 0 -6h-4\" />"),
    CURRENCY_DOLLAR_CANADIAN(
        "currency-dollar-canadian",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M10 18h-1a6 6 0 1 1 0 -12h1\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />"),
    CURRENCY_DOLLAR_GUYANESE(
        "currency-dollar-guyanese",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M10 6h-3a4 4 0 0 0 -4 4v4a4 4 0 0 0 4 4h3v-6h-2\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />"),
    CURRENCY_DOLLAR_OFF(
        "currency-dollar-off",
        "<path d=\"M16.7 8a3 3 0 0 0 -2.7 -2h-4m-2.557 1.431a3 3 0 0 0 2.557 4.569h2m4.564 4.558a3 3 0 0 1 -2.564 1.442h-4a3 3 0 0 1 -2.7 -2\" />\n  <path d=\"M12 3v3m0 12v3\" />\n  <path d=\"M3 3l18 18\" />"),
    CURRENCY_DOLLAR_SINGAPORE(
        "currency-dollar-singapore",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M10 6h-4a3 3 0 1 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />"),
    CURRENCY_DOLLAR_ZIMBABWEAN(
        "currency-dollar-zimbabwean",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />\n  <path d=\"M3 6h7l-7 12h7\" />"),
    CURRENCY_DONG(
        "currency-dong",
        "<path d=\"M8 20h8\" />\n  <path d=\"M15 13a3 3 0 0 1 -3 3a3 3 0 0 1 -3 -3a3 3 0 0 1 3 -3a3 3 0 0 1 3 3\" />\n  <path d=\"M15 4v12\" />\n  <path d=\"M13 6h4\" />"),
    CURRENCY_DRAM(
        "currency-dram",
        "<path d=\"M4 10a6 6 0 1 1 12 0v10\" />\n  <path d=\"M12 16h8\" />\n  <path d=\"M12 12h8\" />"),
    CURRENCY_ETHEREUM(
        "currency-ethereum",
        "<path d=\"M6 12l6 -9l6 9l-6 9l-6 -9\" />\n  <path d=\"M6 12l6 -3l6 3l-6 2l-6 -2\" />"),
    CURRENCY_EURO(
        "currency-euro", "<path d=\"M17.2 7a6 7 0 1 0 0 10\" />\n  <path d=\"M13 10h-8m0 4h8\" />"),
    CURRENCY_EURO_OFF(
        "currency-euro-off",
        "<path d=\"M17.2 7c-1.977 -2.26 -4.954 -2.602 -7.234 -1.04m-1.913 2.079c-1.604 2.72 -1.374 6.469 .69 8.894c2.292 2.691 6 2.758 8.356 .18\" />\n  <path d=\"M10 10h-5m0 4h8\" />\n  <path d=\"M3 3l18 18\" />"),
    CURRENCY_FLORIN(
        "currency-florin",
        "<path d=\"M8 12h8\" />\n  <path d=\"M7 19c1.213 0 2.31 -.723 2.788 -1.838l4.424 -10.324a3.033 3.033 0 0 1 2.788 -1.838\" />"),
    CURRENCY_FORINT(
        "currency-forint",
        "<path d=\"M11 4h-4a3 3 0 0 0 -3 3v12\" />\n  <path d=\"M10 11h-6\" />\n  <path d=\"M16 4v13a2 2 0 0 0 2 2h2\" />\n  <path d=\"M19 9h-5\" />"),
    CURRENCY_FRANK(
        "currency-frank",
        "<path d=\"M17 5h-6a2 2 0 0 0 -2 2v12\" />\n  <path d=\"M7 15h4\" />\n  <path d=\"M9 11h7\" />"),
    CURRENCY_GUARANI(
        "currency-guarani",
        "<path d=\"M16.007 7.54a5.965 5.965 0 0 0 -4.008 -1.54a6 6 0 0 0 -5.992 6c0 3.314 2.682 6 5.992 6a5.965 5.965 0 0 0 4 -1.536c.732 -.66 1.064 -2.148 1 -4.464h-5\" />\n  <path d=\"M12 20v-16\" />"),
    CURRENCY_HRYVNIA(
        "currency-hryvnia",
        "<path d=\"M8 7a2.64 2.64 0 0 1 2.562 -2h3.376a2.64 2.64 0 0 1 2.562 2a2.57 2.57 0 0 1 -1.344 2.922l-5.876 2.938a3.338 3.338 0 0 0 -1.78 3.64a3.11 3.11 0 0 0 3.05 2.5h2.888a2.64 2.64 0 0 0 2.562 -2\" />\n  <path d=\"M6 10h12\" />\n  <path d=\"M6 14h12\" />"),
    CURRENCY_HUSD(
        "currency-husd",
        "<path d=\"M7 20v-5\" />\n  <path d=\"M17 9v-5\" />\n  <path d=\"M17 20v-6a2 2 0 0 0 -2 -2h-6a2 2 0 0 1 -2 -2v-6\" />"),
    CURRENCY_IRANIAN_RIAL(
        "currency-iranian-rial",
        "<path d=\"M9 4v9a2 2 0 0 1 -2 2h-1a3 3 0 0 1 -3 -3v-1\" />\n  <path d=\"M12 5v8a1 1 0 0 0 1 1h1a2 2 0 0 0 2 -2v-1\" />\n  <path d=\"M21 14v1.096a5 5 0 0 1 -3.787 4.85l-.213 .054\" />\n  <path d=\"M11 18h.01\" />\n  <path d=\"M14 18h.01\" />"),
    CURRENCY_KIP(
        "currency-kip",
        "<path d=\"M6 12h12\" />\n  <path d=\"M9 5v14\" />\n  <path d=\"M16 19a7 7 0 0 0 -7 -7a7 7 0 0 0 7 -7\" />"),
    CURRENCY_KRONE_CZECH(
        "currency-krone-czech",
        "<path d=\"M5 6v12\" />\n  <path d=\"M5 12c3.5 0 6 -3 6 -6\" />\n  <path d=\"M5 12c3.5 0 6 3 6 6\" />\n  <path d=\"M19 6l-2 2l-2 -2\" />\n  <path d=\"M19 12h-2a3 3 0 0 0 0 6h2\" />"),
    CURRENCY_KRONE_DANISH(
        "currency-krone-danish",
        "<path d=\"M5 6v12\" />\n  <path d=\"M5 12c3.5 0 6 -3 6 -6\" />\n  <path d=\"M5 12c3.5 0 6 3 6 6\" />\n  <path d=\"M15 10v8\" />\n  <path d=\"M19 10a4 4 0 0 0 -4 4\" />\n  <path d=\"M20 18.01v-.01\" />"),
    CURRENCY_KRONE_SWEDISH(
        "currency-krone-swedish",
        "<path d=\"M5 6v12\" />\n  <path d=\"M5 12c3.5 0 6 -3 6 -6\" />\n  <path d=\"M5 12c3.5 0 6 3 6 6\" />\n  <path d=\"M15 10v8\" />\n  <path d=\"M19 10a4 4 0 0 0 -4 4\" />"),
    CURRENCY_LARI(
        "currency-lari",
        "<path d=\"M18 13a6 6 0 1 0 -6 6\" />\n  <path d=\"M6 19h12\" />\n  <path d=\"M10 5v7\" />\n  <path d=\"M14 12v-7\" />"),
    CURRENCY_LEU("currency-leu", "<path d=\"M17 18h-7a3 3 0 0 1 -3 -3v-10\" />"),
    CURRENCY_LIRA(
        "currency-lira",
        "<path d=\"M10 5v15a7 7 0 0 0 7 -7\" />\n  <path d=\"M6 15l8 -4\" />\n  <path d=\"M14 7l-8 4\" />"),
    CURRENCY_LITECOIN(
        "currency-litecoin",
        "<path d=\"M18 19h-8.194a2 2 0 0 1 -1.98 -2.283l1.674 -11.717\" />\n  <path d=\"M14 9l-9 4\" />"),
    CURRENCY_LYD(
        "currency-lyd",
        "<path d=\"M11 15h.01\" />\n  <path d=\"M21 5v10a2 2 0 0 1 -2 2h-2.764a2 2 0 0 1 -1.789 -1.106l-.447 -.894\" />\n  <path d=\"M5 8l2.773 4.687c.427 .697 .234 1.626 -.43 2.075a1.38 1.38 0 0 1 -.773 .238h-2.224a.93 .93 0 0 1 -.673 -.293l-.673 -.707\" />"),
    CURRENCY_MANAT(
        "currency-manat", "<path d=\"M7 19v-7a5 5 0 1 1 10 0v7\" />\n  <path d=\"M12 5v14\" />"),
    CURRENCY_MONERO("currency-monero", "<path d=\"M3 18h3v-11l6 7l6 -7v11h3\" />"),
    CURRENCY_NAIRA(
        "currency-naira",
        "<path d=\"M7 18v-10.948a1.05 1.05 0 0 1 1.968 -.51l6.064 10.916a1.05 1.05 0 0 0 1.968 -.51v-10.948\" />\n  <path d=\"M5 10h14\" />\n  <path d=\"M5 14h14\" />"),
    CURRENCY_NANO(
        "currency-nano",
        "<path d=\"M7 20l10 -16\" />\n  <path d=\"M7 12h10\" />\n  <path d=\"M7 16h10\" />\n  <path d=\"M17 20l-10 -16\" />"),
    CURRENCY_OFF(
        "currency-off",
        "<path d=\"M18.531 14.524a7 7 0 0 0 -9.06 -9.053m-2.422 1.582a7 7 0 0 0 9.903 9.896\" />\n  <path d=\"M4 4l3 3\" />\n  <path d=\"M20 4l-3 3\" />\n  <path d=\"M4 20l3 -3\" />\n  <path d=\"M20 20l-3 -3\" />\n  <path d=\"M3 3l18 18\" />"),
    CURRENCY_PAANGA(
        "currency-paanga",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M17 20v-2\" />\n  <path d=\"M18 6v-2\" />\n  <path d=\"M3 6h8\" />\n  <path d=\"M7 6v12\" />"),
    CURRENCY_PESO(
        "currency-peso",
        "<path d=\"M8 19v-14h3.5a4.5 4.5 0 1 1 0 9h-3.5\" />\n  <path d=\"M18 8h-12\" />\n  <path d=\"M18 11h-12\" />"),
    CURRENCY_POUND(
        "currency-pound",
        "<path d=\"M17 18.5a6 6 0 0 1 -5 0a6 6 0 0 0 -5 .5a3 3 0 0 0 2 -2.5v-7.5a4 4 0 0 1 7.45 -2m-2.55 6h-7\" />"),
    CURRENCY_POUND_OFF(
        "currency-pound-off",
        "<path d=\"M17 18.5a6 6 0 0 1 -5 0a6 6 0 0 0 -5 .5a3 3 0 0 0 2 -2.5v-7.5m1.192 -2.825a4 4 0 0 1 6.258 .825m-3.45 6h-6\" />\n  <path d=\"M3 3l18 18\" />"),
    CURRENCY_QUETZAL(
        "currency-quetzal",
        "<path d=\"M6 12a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M13 13l5 5\" />"),
    CURRENCY_REAL(
        "currency-real",
        "<path d=\"M21 6h-4a3 3 0 0 0 0 6h1a3 3 0 0 1 0 6h-4\" />\n  <path d=\"M4 18v-12h3a3 3 0 1 1 0 6h-3c5.5 0 5 4 6 6\" />\n  <path d=\"M18 6v-2\" />\n  <path d=\"M17 20v-2\" />"),
    CURRENCY_RENMINBI(
        "currency-renminbi",
        "<path d=\"M15 9v8a2 2 0 1 0 4 0\" />\n  <path d=\"M19 9h-14\" />\n  <path d=\"M19 5h-14\" />\n  <path d=\"M9 9v4c0 2.5 -.667 4 -2 6\" />"),
    CURRENCY_RIPPLE(
        "currency-ripple",
        "<path d=\"M4 12a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 7a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 17a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M10 12h3l2 -2.5\" />\n  <path d=\"M15 14.5l-2 -2.5\" />"),
    CURRENCY_RIYAL(
        "currency-riyal",
        "<path d=\"M15 9v2a2 2 0 1 1 -4 0v-1v1a2 2 0 1 1 -4 0v-1v4a2 2 0 1 1 -4 0v-2\" />\n  <path d=\"M18 12.01v-.01\" />\n  <path d=\"M22 10v1a5 5 0 0 1 -5 5\" />"),
    CURRENCY_RUBLE(
        "currency-ruble",
        "<path d=\"M8 19v-14h6a3 3 0 0 1 0 6h-8\" />\n  <path d=\"M14 15h-8\" />"),
    CURRENCY_RUFIYAA(
        "currency-rufiyaa",
        "<path d=\"M20 16h.01\" />\n  <path d=\"M4 16c9.5 -4 11.5 -8 14 -9\" />\n  <path d=\"M12 8l5 3\" />"),
    CURRENCY_RUPEE(
        "currency-rupee",
        "<path d=\"M18 5h-11h3a4 4 0 0 1 0 8h-3l6 6\" />\n  <path d=\"M7 9l11 0\" />"),
    CURRENCY_RUPEE_NEPALESE(
        "currency-rupee-nepalese",
        "<path d=\"M15 5h-11h3a4 4 0 1 1 0 8h-3l6 6\" />\n  <path d=\"M21 17l-4.586 -4.414a2 2 0 0 0 -2.828 2.828l.707 .707\" />"),
    CURRENCY_SHEKEL(
        "currency-shekel",
        "<path d=\"M6 18v-12h4a4 4 0 0 1 4 4v4\" />\n  <path d=\"M18 6v12h-4a4 4 0 0 1 -4 -4v-4\" />"),
    CURRENCY_SOLANA(
        "currency-solana",
        "<path d=\"M4 18h12l4 -4h-12l-4 4\" />\n  <path d=\"M8 14l-4 -4h12l4 4\" />\n  <path d=\"M16 10l4 -4h-12l-4 4\" />"),
    CURRENCY_SOM(
        "currency-som",
        "<path d=\"M10 18v-12h-5v10a2 2 0 0 1 -2 2\" />\n  <path d=\"M14 6v12h4a3 3 0 0 0 0 -6h-4h4a3 3 0 0 0 0 -6h-4\" />"),
    CURRENCY_TAKA(
        "currency-taka",
        "<path d=\"M15.5 15.5a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 7a2 2 0 1 1 4 0v9a3 3 0 0 0 6 0v-.5\" />\n  <path d=\"M8 11h6\" />"),
    CURRENCY_TENGE(
        "currency-tenge",
        "<path d=\"M6 5h12\" />\n  <path d=\"M6 9h12\" />\n  <path d=\"M12 9v10\" />"),
    CURRENCY_TETHER(
        "currency-tether",
        "<path d=\"M4 11a8 2 0 1 0 16 0a8 2 0 1 0 -16 0\" />\n  <path d=\"M12 20v-16\" />\n  <path d=\"M4 4h16\" />"),
    CURRENCY_TUGRIK(
        "currency-tugrik",
        "<path d=\"M7 6h10\" />\n  <path d=\"M12 6v13\" />\n  <path d=\"M8 17l8 -3\" />\n  <path d=\"M16 10l-8 3\" />"),
    CURRENCY_WON(
        "currency-won",
        "<path d=\"M4 6l3.245 11.358a.85 .85 0 0 0 1.624 .035l3.131 -9.393l3.131 9.393a.85 .85 0 0 0 1.624 -.035l3.245 -11.358\" />\n  <path d=\"M21 10h-18\" />\n  <path d=\"M21 14h-18\" />"),
    CURRENCY_XRP(
        "currency-xrp",
        "<path d=\"M5 5l3.585 3.585a4.83 4.83 0 0 0 6.83 0l3.585 -3.585\" />\n  <path d=\"M5 19l3.585 -3.585a4.83 4.83 0 0 1 6.83 0l3.585 3.584\" />"),
    CURRENCY_YEN(
        "currency-yen",
        "<path d=\"M12 19v-7l-5 -7m10 0l-5 7\" />\n  <path d=\"M8 17l8 0\" />\n  <path d=\"M8 13l8 0\" />"),
    CURRENCY_YEN_OFF(
        "currency-yen-off",
        "<path d=\"M12 19v-7m5 -7l-3.328 4.66\" />\n  <path d=\"M8 17h8\" />\n  <path d=\"M8 13h5\" />\n  <path d=\"M3 3l18 18\" />"),
    CURRENCY_YUAN(
        "currency-yuan",
        "<path d=\"M12 19v-7l-5 -7\" />\n  <path d=\"M17 5l-5 7\" />\n  <path d=\"M8 13h8\" />"),
    CURRENCY_ZCASH(
        "currency-zcash",
        "<path d=\"M7 6h10l-10 12h10\" />\n  <path d=\"M12 4v2\" />\n  <path d=\"M12 18v2\" />"),
    CURRENCY_ZLOTY(
        "currency-zloty",
        "<path d=\"M12 18h-7l7 -7h-7\" />\n  <path d=\"M17 18v-13\" />\n  <path d=\"M14 14.5l6 -3.5\" />"),
    TAIWAN_DOLLAR(
        "taiwan-dollar",
        "<path d=\"M6 19a4 4 0 0 0 4 -4v-7\" />\n  <path d=\"M14 8v10a1 1 0 0 0 1.45 .89l2.55 -1.27\" />\n  <path d=\"M6 5h12\" />\n  <path d=\"M6 8h12\" />"),
    TAX(
        "tax",
        "<path d=\"M8.487 21h7.026a4 4 0 0 0 3.808 -5.224l-1.706 -5.306a5 5 0 0 0 -4.76 -3.47h-1.71a5 5 0 0 0 -4.76 3.47l-1.706 5.306a4 4 0 0 0 3.808 5.224\" />\n  <path d=\"M15 3q -1 4 -3 4t -3 -4l6 0\" />\n  <path d=\"M14 11h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M12 10v1\" />\n  <path d=\"M12 17v1\" />"),
    TAX_EURO(
        "tax-euro",
        "<path d=\"M8.487 21h7.026a4 4 0 0 0 3.808 -5.224l-1.706 -5.306a5 5 0 0 0 -4.76 -3.47h-1.71a5 5 0 0 0 -4.76 3.47l-1.706 5.306a4 4 0 0 0 3.808 5.224\" />\n  <path d=\"M15 3q -1 4 -3 4t -3 -4l6 0\" />\n  <path d=\"M12 14h-3\" />\n  <path d=\"M14 11.172a3 3 0 1 0 0 5.656\" />"),
    TAX_POUND(
        "tax-pound",
        "<path d=\"M8.487 21h7.026a4 4 0 0 0 3.808 -5.224l-1.706 -5.306a5 5 0 0 0 -4.76 -3.47h-1.71a5 5 0 0 0 -4.76 3.47l-1.706 5.306a4 4 0 0 0 3.808 5.224\" />\n  <path d=\"M15 3q -1 4 -3 4t -3 -4l6 0\" />\n  <path d=\"M14 11h-1a2 2 0 0 0 -2 2v2c0 1.105 -.395 2 -1.5 2h4.5\" />\n  <path d=\"M10 14h3\" />"),
    TRANSACTION_BITCOIN(
        "transaction-bitcoin",
        "<path d=\"M15 12h4.09c1.055 0 1.91 .895 1.91 2s-.855 2 -1.91 2c1.055 0 1.91 .895 1.91 2s-.855 2 -1.91 2h-4.09\" />\n  <path d=\"M16 16h4\" />\n  <path d=\"M16 11v10v-9\" />\n  <path d=\"M19 11v1\" />\n  <path d=\"M19 20v1\" />\n  <path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 5h8\" />\n  <path d=\"M7 5v8a3 3 0 0 0 3 3h1\" />"),
    TRANSACTION_RUPEE(
        "transaction-rupee",
        "<path d=\"M21 12h-6h1a3 3 0 0 1 0 6h-1l3 3\" />\n  <path d=\"M15 15h6\" />\n  <path d=\"M3 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M7 5h8\" />\n  <path d=\"M7 5v8a3 3 0 0 0 3 3h1\" />");

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
    ;

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

  default TablerIcon currency() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY);
  }

  default TablerIcon currency_afghani() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_AFGHANI);
  }

  default TablerIcon currency_bahraini() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_BAHRAINI);
  }

  default TablerIcon currency_baht() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_BAHT);
  }

  default TablerIcon currency_bitcoin() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_BITCOIN);
  }

  default TablerIcon currency_cent() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_CENT);
  }

  default TablerIcon currency_dinar() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DINAR);
  }

  default TablerIcon currency_dirham() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DIRHAM);
  }

  default TablerIcon currency_dogecoin() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOGECOIN);
  }

  default TablerIcon currency_dollar() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR);
  }

  default TablerIcon currency_dollar_australian() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_AUSTRALIAN);
  }

  default TablerIcon currency_dollar_brunei() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_BRUNEI);
  }

  default TablerIcon currency_dollar_canadian() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_CANADIAN);
  }

  default TablerIcon currency_dollar_guyanese() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_GUYANESE);
  }

  default TablerIcon currency_dollar_off() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_OFF);
  }

  default TablerIcon currency_dollar_singapore() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_SINGAPORE);
  }

  default TablerIcon currency_dollar_zimbabwean() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DOLLAR_ZIMBABWEAN);
  }

  default TablerIcon currency_dong() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DONG);
  }

  default TablerIcon currency_dram() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_DRAM);
  }

  default TablerIcon currency_ethereum() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_ETHEREUM);
  }

  default TablerIcon currency_euro() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_EURO);
  }

  default TablerIcon currency_euro_off() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_EURO_OFF);
  }

  default TablerIcon currency_florin() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_FLORIN);
  }

  default TablerIcon currency_forint() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_FORINT);
  }

  default TablerIcon currency_frank() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_FRANK);
  }

  default TablerIcon currency_guarani() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_GUARANI);
  }

  default TablerIcon currency_hryvnia() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_HRYVNIA);
  }

  default TablerIcon currency_husd() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_HUSD);
  }

  default TablerIcon currency_iranian_rial() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_IRANIAN_RIAL);
  }

  default TablerIcon currency_kip() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_KIP);
  }

  default TablerIcon currency_krone_czech() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_KRONE_CZECH);
  }

  default TablerIcon currency_krone_danish() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_KRONE_DANISH);
  }

  default TablerIcon currency_krone_swedish() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_KRONE_SWEDISH);
  }

  default TablerIcon currency_lari() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_LARI);
  }

  default TablerIcon currency_leu() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_LEU);
  }

  default TablerIcon currency_lira() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_LIRA);
  }

  default TablerIcon currency_litecoin() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_LITECOIN);
  }

  default TablerIcon currency_lyd() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_LYD);
  }

  default TablerIcon currency_manat() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_MANAT);
  }

  default TablerIcon currency_monero() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_MONERO);
  }

  default TablerIcon currency_naira() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_NAIRA);
  }

  default TablerIcon currency_nano() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_NANO);
  }

  default TablerIcon currency_off() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_OFF);
  }

  default TablerIcon currency_paanga() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_PAANGA);
  }

  default TablerIcon currency_peso() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_PESO);
  }

  default TablerIcon currency_pound() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_POUND);
  }

  default TablerIcon currency_pound_off() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_POUND_OFF);
  }

  default TablerIcon currency_quetzal() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_QUETZAL);
  }

  default TablerIcon currency_real() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_REAL);
  }

  default TablerIcon currency_renminbi() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RENMINBI);
  }

  default TablerIcon currency_ripple() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RIPPLE);
  }

  default TablerIcon currency_riyal() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RIYAL);
  }

  default TablerIcon currency_ruble() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RUBLE);
  }

  default TablerIcon currency_rufiyaa() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RUFIYAA);
  }

  default TablerIcon currency_rupee() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RUPEE);
  }

  default TablerIcon currency_rupee_nepalese() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_RUPEE_NEPALESE);
  }

  default TablerIcon currency_shekel() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_SHEKEL);
  }

  default TablerIcon currency_solana() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_SOLANA);
  }

  default TablerIcon currency_som() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_SOM);
  }

  default TablerIcon currency_taka() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_TAKA);
  }

  default TablerIcon currency_tenge() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_TENGE);
  }

  default TablerIcon currency_tether() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_TETHER);
  }

  default TablerIcon currency_tugrik() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_TUGRIK);
  }

  default TablerIcon currency_won() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_WON);
  }

  default TablerIcon currency_xrp() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_XRP);
  }

  default TablerIcon currency_yen() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_YEN);
  }

  default TablerIcon currency_yen_off() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_YEN_OFF);
  }

  default TablerIcon currency_yuan() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_YUAN);
  }

  default TablerIcon currency_zcash() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_ZCASH);
  }

  default TablerIcon currency_zloty() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.CURRENCY_ZLOTY);
  }

  default TablerIcon taiwan_dollar() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TAIWAN_DOLLAR);
  }

  default TablerIcon tax() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TAX);
  }

  default TablerIcon tax_euro() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TAX_EURO);
  }

  default TablerIcon tax_pound() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TAX_POUND);
  }

  default TablerIcon transaction_bitcoin() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TRANSACTION_BITCOIN);
  }

  default TablerIcon transaction_rupee() {
    return TablerIcon.create(TablerCurrencies.OutlineIcon.TRANSACTION_RUPEE);
  }
}
