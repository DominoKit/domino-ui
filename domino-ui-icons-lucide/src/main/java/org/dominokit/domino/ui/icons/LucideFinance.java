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

/** Lucide finance catalog category. */
public interface LucideFinance {
  enum Icon implements LucideIconDefinition {
    ARMENIAN_DRAM(
        "armenian-dram",
        "<path d=\"M11 10h8\" />\n  <path d=\"M11 14h8\" />\n  <path d=\"M17 20V10a6 6 0 0 0-12 0\" />"),
    BADGE_CENT(
        "badge-cent",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M12 7v10\" />\n  <path d=\"M15.4 10a4 4 0 1 0 0 4\" />"),
    BADGE_DOLLAR_SIGN(
        "badge-dollar-sign",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M16 8h-6a2 2 0 1 0 0 4h4a2 2 0 1 1 0 4H8\" />\n  <path d=\"M12 18V6\" />"),
    BADGE_EURO(
        "badge-euro",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M7 12h5\" />\n  <path d=\"M15 9.4a4 4 0 1 0 0 5.2\" />"),
    BADGE_INDIAN_RUPEE(
        "badge-indian-rupee",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M8 8h8\" />\n  <path d=\"M8 12h8\" />\n  <path d=\"m13 17-5-1h1a4 4 0 0 0 0-8\" />"),
    BADGE_JAPANESE_YEN(
        "badge-japanese-yen",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"m9 8 3 3v7\" />\n  <path d=\"m12 11 3-3\" />\n  <path d=\"M9 12h6\" />\n  <path d=\"M9 16h6\" />"),
    BADGE_PERCENT(
        "badge-percent",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    BADGE_POUND_STERLING(
        "badge-pound-sterling",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M8 12h4\" />\n  <path d=\"M10 16V9.5a2.5 2.5 0 0 1 5 0\" />\n  <path d=\"M8 16h7\" />"),
    BADGE_RUSSIAN_RUBLE(
        "badge-russian-ruble",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M9 16h5\" />\n  <path d=\"M9 12h5a2 2 0 1 0 0-4h-3v9\" />"),
    BADGE_SWISS_FRANC(
        "badge-swiss-franc",
        "<path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76Z\" />\n  <path d=\"M11 17V8h4\" />\n  <path d=\"M11 12h3\" />\n  <path d=\"M9 16h4\" />"),
    BADGE_TURKISH_LIRA(
        "badge-turkish-lira",
        "<path d=\"M11 7v10a5 5 0 0 0 5-5\" />\n  <path d=\"m15 8-6 3\" />\n  <path d=\"M3.85 8.62a4 4 0 0 1 4.78-4.77 4 4 0 0 1 6.74 0 4 4 0 0 1 4.78 4.78 4 4 0 0 1 0 6.74 4 4 0 0 1-4.77 4.78 4 4 0 0 1-6.75 0 4 4 0 0 1-4.78-4.77 4 4 0 0 1 0-6.76\" />"),
    BANGLADESHI_TAKA(
        "bangladeshi-taka",
        "<path d=\"M6 5a2 2 0 0 1 4 0v12a4 4 0 0 0 8 0 2 2 0 0 0-4 0\" />\n  <path d=\"M6 9h12\" />"),
    BANKNOTE(
        "banknote",
        "<rect width=\"20\" height=\"12\" x=\"2\" y=\"6\" rx=\"2\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />\n  <path d=\"M6 12h.01M18 12h.01\" />"),
    BANKNOTE_ARROW_DOWN(
        "banknote-arrow-down",
        "<path d=\"M12 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5\" />\n  <path d=\"m16 19 3 3 3-3\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M19 16v6\" />\n  <path d=\"M6 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    BANKNOTE_ARROW_UP(
        "banknote-arrow-up",
        "<path d=\"M12 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M19 22v-6\" />\n  <path d=\"m22 19-3-3-3 3\" />\n  <path d=\"M6 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    BANKNOTE_CHECK(
        "banknote-check",
        "<path d=\"M11.748 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v4.875\" />\n  <path d=\"m16 19 2 2 4-4\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"M6 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    BANKNOTE_X(
        "banknote-x",
        "<path d=\"M13 18H4a2 2 0 0 1-2-2V8a2 2 0 0 1 2-2h16a2 2 0 0 1 2 2v5\" />\n  <path d=\"m17 17 5 5\" />\n  <path d=\"M18 12h.01\" />\n  <path d=\"m22 17-5 5\" />\n  <path d=\"M6 12h.01\" />\n  <circle cx=\"12\" cy=\"12\" r=\"2\" />"),
    BELARUSIAN_RUBLE(
        "belarusian-ruble",
        "<path d=\"M3 16 L13 16\" />\n  <path d=\"M6 12h9a4 4 0 0 1 0 8H7a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1h7\" />"),
    BITCOIN(
        "bitcoin",
        "<path d=\"M11.767 19.089c4.924.868 6.14-6.025 1.216-6.894m-1.216 6.894L5.86 18.047m5.908 1.042-.347 1.97m1.563-8.864c4.924.869 6.14-6.025 1.215-6.893m-1.215 6.893-3.94-.694m5.155-6.2L8.29 4.26m5.908 1.042.348-1.97M7.48 20.364l3.126-17.727\" />"),
    CHART_CANDLESTICK(
        "chart-candlestick",
        "<path d=\"M9 5v4\" />\n  <rect width=\"4\" height=\"6\" x=\"7\" y=\"9\" rx=\"1\" />\n  <path d=\"M9 15v2\" />\n  <path d=\"M17 3v2\" />\n  <rect width=\"4\" height=\"8\" x=\"15\" y=\"5\" rx=\"1\" />\n  <path d=\"M17 13v3\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />"),
    CIRCLE_DOLLAR_SIGN(
        "circle-dollar-sign",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M16 8h-6a2 2 0 1 0 0 4h4a2 2 0 1 1 0 4H8\" />\n  <path d=\"M12 18V6\" />"),
    CIRCLE_EURO(
        "circle-euro",
        "<path d=\"M15 9.4a4 4 0 1 0 0 5.2\" />\n  <path d=\"M7 12h5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_PERCENT(
        "circle-percent",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    CIRCLE_POUND_STERLING(
        "circle-pound-sterling",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"M10 16V9.5a1 1 0 0 1 5 0\" />\n  <path d=\"M8 12h4\" />\n  <path d=\"M8 16h7\" />"),
    CREDIT_CARD(
        "credit-card",
        "<rect width=\"20\" height=\"14\" x=\"2\" y=\"5\" rx=\"2\" />\n  <line x1=\"2\" x2=\"22\" y1=\"10\" y2=\"10\" />\n  <path d=\"M6 14h2\" />"),
    CREDIT_CARD_CHECK(
        "credit-card-check",
        "<path d=\"M12.5 19H4a2 2 0 01-2-2V7a2 2 0 012-2h16a2 2 0 012 2v4\" />\n  <path d=\"M2 10h20\" />\n  <path d=\"M6 14h2\" />\n  <path d=\"m16 17 2 2 4-4\" />"),
    CREDIT_CARD_MINUS(
        "credit-card-minus",
        "<path d=\"M22 13V7a2 2 0 00-2-2H4a2 2 0 00-2 2v10a2 2 0 002 2h8.536\" />\n  <path d=\"M22 10H2\" />\n  <path d=\"M6 14h2\" />\n  <path d=\"M16 17h6\" />"),
    CREDIT_CARD_PLUS(
        "credit-card-plus",
        "<path d=\"M22 11.354V7a2 2 0 00-2-2H4a2 2 0 00-2 2v10a2 2 0 002 2h8.536\" />\n  <path d=\"M22 10H2\" />\n  <path d=\"M6 14h2\" />\n  <path d=\"M16 17h6\" />\n  <path d=\"M19 14v6\" />"),
    CREDIT_CARD_READER(
        "credit-card-reader",
        "<path d=\"M15 16v1\" />\n  <path d=\"M16.963 7.734A1 1 0 0015.999 7H8.003a1 1 0 00-.964.734L4.073 18.467A2 2 0 006 21h12a2 2 0 001.927-2.532z\" />\n  <path d=\"M2.678 8.5A2 2 0 012 7V5a2 2 0 012-2h16a2 2 0 012 2v2a2 2 0 01-.676 1.499\" />\n  <path d=\"m9 21 2-14\" />"),
    CREDIT_CARD_X(
        "credit-card-x",
        "<path d=\"M12.5 19H4a2 2 0 01-2-2V7a2 2 0 012-2h16a2 2 0 012 2v3.5\" />\n  <path d=\"M2 10h20\" />\n  <path d=\"M6 14h2\" />\n  <path d=\"m16.5 14.5 5 5\" />\n  <path d=\"m21.5 14.5-5 5\" />"),
    CURRENCY(
        "currency",
        "<circle cx=\"12\" cy=\"12\" r=\"8\" />\n  <line x1=\"3\" x2=\"6\" y1=\"3\" y2=\"6\" />\n  <line x1=\"21\" x2=\"18\" y1=\"3\" y2=\"6\" />\n  <line x1=\"3\" x2=\"6\" y1=\"21\" y2=\"18\" />\n  <line x1=\"21\" x2=\"18\" y1=\"21\" y2=\"18\" />"),
    DIAMOND_PERCENT(
        "diamond-percent",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0Z\" />\n  <path d=\"M9.2 9.2h.01\" />\n  <path d=\"m14.5 9.5-5 5\" />\n  <path d=\"M14.7 14.8h.01\" />"),
    DOLLAR_SIGN(
        "dollar-sign",
        "<line x1=\"12\" x2=\"12\" y1=\"2\" y2=\"22\" />\n  <path d=\"M17 5H9.5a3.5 3.5 0 0 0 0 7h5a3.5 3.5 0 0 1 0 7H6\" />"),
    EURO(
        "euro",
        "<path d=\"M4 10h12\" />\n  <path d=\"M4 14h9\" />\n  <path d=\"M19 6a7.7 7.7 0 0 0-5.2-2A7.9 7.9 0 0 0 6 12c0 4.4 3.5 8 7.8 8 2 0 3.8-.8 5.2-2\" />"),
    GEM(
        "gem",
        "<path d=\"M10.5 3 8 9l4 13 4-13-2.5-6\" />\n  <path d=\"M17 3a2 2 0 0 1 1.6.8l3 4a2 2 0 0 1 .013 2.382l-7.99 10.986a2 2 0 0 1-3.247 0l-7.99-10.986A2 2 0 0 1 2.4 7.8l2.998-3.997A2 2 0 0 1 7 3z\" />\n  <path d=\"M2 9h20\" />"),
    GEORGIAN_LARI(
        "georgian-lari",
        "<path d=\"M11.5 21a7.5 7.5 0 1 1 7.35-9\" />\n  <path d=\"M13 12V3\" />\n  <path d=\"M4 21h16\" />\n  <path d=\"M9 12V3\" />"),
    HAND_COINS(
        "hand-coins",
        "<path d=\"M11 15h2a2 2 0 1 0 0-4h-3c-.6 0-1.1.2-1.4.6L3 17\" />\n  <path d=\"m7 21 1.6-1.4c.3-.4.8-.6 1.4-.6h4c1.1 0 2.1-.4 2.8-1.2l4.6-4.4a2 2 0 0 0-2.75-2.91l-4.2 3.9\" />\n  <path d=\"m2 16 6 6\" />\n  <circle cx=\"16\" cy=\"9\" r=\"2.9\" />\n  <circle cx=\"6\" cy=\"5\" r=\"3\" />"),
    HANDSHAKE(
        "handshake",
        "<path d=\"m11 17 2 2a1 1 0 1 0 3-3\" />\n  <path d=\"m14 14 2.5 2.5a1 1 0 1 0 3-3l-3.88-3.88a3 3 0 0 0-4.24 0l-.88.88a1 1 0 1 1-3-3l2.81-2.81a5.79 5.79 0 0 1 7.06-.87l.47.28a2 2 0 0 0 1.42.25L21 4\" />\n  <path d=\"m21 3 1 11h-2\" />\n  <path d=\"M3 3 2 14l6.5 6.5a1 1 0 1 0 3-3\" />\n  <path d=\"M3 4h8\" />"),
    INDIAN_RUPEE(
        "indian-rupee",
        "<path d=\"M6 3h12\" />\n  <path d=\"M6 8h12\" />\n  <path d=\"m6 13 8.5 8\" />\n  <path d=\"M6 13h3\" />\n  <path d=\"M9 13c6.667 0 6.667-10 0-10\" />"),
    JAPANESE_YEN(
        "japanese-yen",
        "<path d=\"M12 9.5V21m0-11.5L6 3m6 6.5L18 3\" />\n  <path d=\"M6 15h12\" />\n  <path d=\"M6 11h12\" />"),
    KAZAKH_TENGE(
        "kazakh-tenge",
        "<path d=\"M12 8v12\" />\n  <path d=\"M6 4h12\" />\n  <path d=\"M6 8h12\" />"),
    LANDMARK(
        "landmark",
        "<path d=\"M10 18v-7\" />\n  <path d=\"M11.119 2.205a2 2 0 0 1 1.762 0l7.84 3.846A.5.5 0 0 1 20.5 7h-17a.5.5 0 0 1-.22-.949z\" />\n  <path d=\"M14 18v-7\" />\n  <path d=\"M18 18v-7\" />\n  <path d=\"M3 22h18\" />\n  <path d=\"M6 18v-7\" />"),
    NEPALI_RUPEE(
        "nepali-rupee",
        "<path d=\"M18 16.173 A4.74 4.74 0 0 0 13.496 8.005\" />\n  <path d=\"M4 3 L20 3\" />\n  <path d=\"M5 13 L13.5 21\" />\n  <path d=\"M5 13 L9 13\" />\n  <path d=\"M8 13 C15.5 13 14.667 3 8 3\" />"),
    NFC(
        "nfc",
        "<path d=\"M6 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M9.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M12.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />\n  <path d=\"M16.37 2a20.16 20.16 0 0 1 0 20\" />"),
    PERCENT(
        "percent",
        "<line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"2.5\" />\n  <circle cx=\"17.5\" cy=\"17.5\" r=\"2.5\" />"),
    PHILIPPINE_PESO(
        "philippine-peso",
        "<path d=\"M20 11H4\" />\n  <path d=\"M20 7H4\" />\n  <path d=\"M7 21V4a1 1 0 0 1 1-1h4a1 1 0 0 1 0 12H7\" />"),
    PIGGY_BANK(
        "piggy-bank",
        "<path d=\"M11 17h3v2a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1v-3a3.16 3.16 0 0 0 2-2h1a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1h-1a5 5 0 0 0-2-4V3a4 4 0 0 0-3.2 1.6l-.3.4H11a6 6 0 0 0-6 6v1a5 5 0 0 0 2 4v3a1 1 0 0 0 1 1h2a1 1 0 0 0 1-1z\" />\n  <path d=\"M16 10h.01\" />\n  <path d=\"M2 8v1a2 2 0 0 0 2 2h1\" />"),
    POUND_STERLING(
        "pound-sterling",
        "<path d=\"M18 7c0-5.333-8-5.333-8 0\" />\n  <path d=\"M10 7v14\" />\n  <path d=\"M6 21h12\" />\n  <path d=\"M6 13h10\" />"),
    RECEIPT(
        "receipt",
        "<path d=\"M12 17V7\" />\n  <path d=\"M16 8h-6a2 2 0 0 0 0 4h4a2 2 0 0 1 0 4H8\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_CENT(
        "receipt-cent",
        "<path d=\"M12 7v10\" />\n  <path d=\"M14.828 14.829a4 4 0 0 1-5.656 0 4 4 0 0 1 0-5.657 4 4 0 0 1 5.656 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_EURO(
        "receipt-euro",
        "<path d=\"M15.828 14.829a4 4 0 0 1-5.656 0 4 4 0 0 1 0-5.657 4 4 0 0 1 5.656 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 12h5\" />"),
    RECEIPT_INDIAN_RUPEE(
        "receipt-indian-rupee",
        "<path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 11h8\" />\n  <path d=\"M8 7h8\" />\n  <path d=\"M9 7a4 4 0 0 1 0 8H8l3 2\" />"),
    RECEIPT_JAPANESE_YEN(
        "receipt-japanese-yen",
        "<path d=\"m12 10 3-3\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M9 11h6\" />\n  <path d=\"M9 15h6\" />\n  <path d=\"m9 7 3 3v7\" />"),
    RECEIPT_POUND_STERLING(
        "receipt-pound-sterling",
        "<path d=\"M10 17V9.5a1 1 0 0 1 5 0\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 13h5\" />\n  <path d=\"M8 17h7\" />"),
    RECEIPT_RUSSIAN_RUBLE(
        "receipt-russian-ruble",
        "<path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 11h5a2 2 0 0 0 0-4h-3v10\" />\n  <path d=\"M8 15h5\" />"),
    RECEIPT_SWISS_FRANC(
        "receipt-swiss-franc",
        "<path d=\"M10 11h4\" />\n  <path d=\"M10 17V7h5\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />\n  <path d=\"M8 15h5\" />"),
    RECEIPT_TEXT(
        "receipt-text",
        "<path d=\"M13 16H8\" />\n  <path d=\"M14 8H8\" />\n  <path d=\"M16 12H8\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RECEIPT_TURKISH_LIRA(
        "receipt-turkish-lira",
        "<path d=\"M10 7v10a5 5 0 0 0 5-5\" />\n  <path d=\"m14 8-6 3\" />\n  <path d=\"M4 3a1 1 0 0 1 1-1 1.3 1.3 0 0 1 .7.2l.933.6a1.3 1.3 0 0 0 1.4 0l.934-.6a1.3 1.3 0 0 1 1.4 0l.933.6a1.3 1.3 0 0 0 1.4 0l.933-.6a1.3 1.3 0 0 1 1.4 0l.934.6a1.3 1.3 0 0 0 1.4 0l.933-.6A1.3 1.3 0 0 1 19 2a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1 1.3 1.3 0 0 1-.7-.2l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.934.6a1.3 1.3 0 0 1-1.4 0l-.933-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-1.4 0l-.934-.6a1.3 1.3 0 0 0-1.4 0l-.933.6a1.3 1.3 0 0 1-.7.2 1 1 0 0 1-1-1z\" />"),
    RUSSIAN_RUBLE(
        "russian-ruble", "<path d=\"M6 11h8a4 4 0 0 0 0-8H9v18\" />\n  <path d=\"M6 15h8\" />"),
    SAUDI_RIYAL(
        "saudi-riyal",
        "<path d=\"m20 19.5-5.5 1.2\" />\n  <path d=\"M14.5 4v11.22a1 1 0 0 0 1.242.97L20 15.2\" />\n  <path d=\"m2.978 19.351 5.549-1.363A2 2 0 0 0 10 16V2\" />\n  <path d=\"M20 10 4 13.5\" />"),
    SCALE(
        "scale",
        "<path d=\"M12 3v18\" />\n  <path d=\"m19 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M3 7h1a17 17 0 0 0 8-2 17 17 0 0 0 8 2h1\" />\n  <path d=\"m5 8 3 8a5 5 0 0 1-6 0zV7\" />\n  <path d=\"M7 21h10\" />"),
    SMARTPHONE_NFC(
        "smartphone-nfc",
        "<rect width=\"7\" height=\"12\" x=\"2\" y=\"6\" rx=\"1\" />\n  <path d=\"M13 8.32a7.43 7.43 0 0 1 0 7.36\" />\n  <path d=\"M16.46 6.21a11.76 11.76 0 0 1 0 11.58\" />\n  <path d=\"M19.91 4.1a15.91 15.91 0 0 1 .01 15.8\" />"),
    SQUARE_PERCENT(
        "square-percent",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    SWISS_FRANC(
        "swiss-franc",
        "<path d=\"M10 21V3h8\" />\n  <path d=\"M6 16h9\" />\n  <path d=\"M10 9.5h7\" />"),
    TURKISH_LIRA(
        "turkish-lira",
        "<path d=\"M15 4 5 9\" />\n  <path d=\"m15 8.5-10 5\" />\n  <path d=\"M18 12a9 9 0 0 1-9 9V3\" />"),
    WALLET(
        "wallet",
        "<path d=\"M19 7V4a1 1 0 0 0-1-1H5a2 2 0 0 0 0 4h15a1 1 0 0 1 1 1v4h-3a2 2 0 0 0 0 4h3a1 1 0 0 0 1-1v-2a1 1 0 0 0-1-1\" />\n  <path d=\"M3 5v14a2 2 0 0 0 2 2h15a1 1 0 0 0 1-1v-4\" />"),
    WALLET_CARDS(
        "wallet-cards",
        "<path d=\"M3 11h3.75a2 2 0 0 1 1.6.8l.45.6a4 4 0 0 0 6.4 0l.45-.6a2 2 0 0 1 1.6-.8H21\" />\n  <path d=\"M3 7h18\" />\n  <rect x=\"3\" y=\"3\" width=\"18\" height=\"18\" rx=\"2\" />"),
    WALLET_MINIMAL(
        "wallet-minimal",
        "<path d=\"M17 14h.01\" />\n  <path d=\"M7 7h12a2 2 0 0 1 2 2v10a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h14\" />");

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
  default LucideIcon armenian_dram() {
    return LucideIcon.create(Icon.ARMENIAN_DRAM);
  }

  default LucideIcon badge_cent_finance() {
    return LucideIcon.create(Icon.BADGE_CENT);
  }

  default LucideIcon badge_dollar_sign_finance() {
    return LucideIcon.create(Icon.BADGE_DOLLAR_SIGN);
  }

  default LucideIcon badge_euro_finance() {
    return LucideIcon.create(Icon.BADGE_EURO);
  }

  default LucideIcon badge_indian_rupee_finance() {
    return LucideIcon.create(Icon.BADGE_INDIAN_RUPEE);
  }

  default LucideIcon badge_japanese_yen_finance() {
    return LucideIcon.create(Icon.BADGE_JAPANESE_YEN);
  }

  default LucideIcon badge_percent_finance() {
    return LucideIcon.create(Icon.BADGE_PERCENT);
  }

  default LucideIcon badge_pound_sterling_finance() {
    return LucideIcon.create(Icon.BADGE_POUND_STERLING);
  }

  default LucideIcon badge_russian_ruble_finance() {
    return LucideIcon.create(Icon.BADGE_RUSSIAN_RUBLE);
  }

  default LucideIcon badge_swiss_franc_finance() {
    return LucideIcon.create(Icon.BADGE_SWISS_FRANC);
  }

  default LucideIcon badge_turkish_lira_finance() {
    return LucideIcon.create(Icon.BADGE_TURKISH_LIRA);
  }

  default LucideIcon bangladeshi_taka_finance() {
    return LucideIcon.create(Icon.BANGLADESHI_TAKA);
  }

  default LucideIcon banknote() {
    return LucideIcon.create(Icon.BANKNOTE);
  }

  default LucideIcon banknote_arrow_down() {
    return LucideIcon.create(Icon.BANKNOTE_ARROW_DOWN);
  }

  default LucideIcon banknote_arrow_up() {
    return LucideIcon.create(Icon.BANKNOTE_ARROW_UP);
  }

  default LucideIcon banknote_check() {
    return LucideIcon.create(Icon.BANKNOTE_CHECK);
  }

  default LucideIcon banknote_x() {
    return LucideIcon.create(Icon.BANKNOTE_X);
  }

  default LucideIcon belarusian_ruble_finance() {
    return LucideIcon.create(Icon.BELARUSIAN_RUBLE);
  }

  default LucideIcon bitcoin_finance() {
    return LucideIcon.create(Icon.BITCOIN);
  }

  default LucideIcon chart_candlestick_finance() {
    return LucideIcon.create(Icon.CHART_CANDLESTICK);
  }

  default LucideIcon circle_dollar_sign() {
    return LucideIcon.create(Icon.CIRCLE_DOLLAR_SIGN);
  }

  default LucideIcon circle_euro_finance() {
    return LucideIcon.create(Icon.CIRCLE_EURO);
  }

  default LucideIcon circle_percent_finance() {
    return LucideIcon.create(Icon.CIRCLE_PERCENT);
  }

  default LucideIcon circle_pound_sterling() {
    return LucideIcon.create(Icon.CIRCLE_POUND_STERLING);
  }

  default LucideIcon credit_card_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD);
  }

  default LucideIcon credit_card_check_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD_CHECK);
  }

  default LucideIcon credit_card_minus_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD_MINUS);
  }

  default LucideIcon credit_card_plus_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD_PLUS);
  }

  default LucideIcon credit_card_reader_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD_READER);
  }

  default LucideIcon credit_card_x_finance() {
    return LucideIcon.create(Icon.CREDIT_CARD_X);
  }

  default LucideIcon currency() {
    return LucideIcon.create(Icon.CURRENCY);
  }

  default LucideIcon diamond_percent_finance() {
    return LucideIcon.create(Icon.DIAMOND_PERCENT);
  }

  default LucideIcon dollar_sign() {
    return LucideIcon.create(Icon.DOLLAR_SIGN);
  }

  default LucideIcon euro() {
    return LucideIcon.create(Icon.EURO);
  }

  default LucideIcon gem_finance() {
    return LucideIcon.create(Icon.GEM);
  }

  default LucideIcon georgian_lari() {
    return LucideIcon.create(Icon.GEORGIAN_LARI);
  }

  default LucideIcon hand_coins_finance() {
    return LucideIcon.create(Icon.HAND_COINS);
  }

  default LucideIcon handshake_finance() {
    return LucideIcon.create(Icon.HANDSHAKE);
  }

  default LucideIcon indian_rupee() {
    return LucideIcon.create(Icon.INDIAN_RUPEE);
  }

  default LucideIcon japanese_yen() {
    return LucideIcon.create(Icon.JAPANESE_YEN);
  }

  default LucideIcon kazakh_tenge() {
    return LucideIcon.create(Icon.KAZAKH_TENGE);
  }

  default LucideIcon landmark_finance() {
    return LucideIcon.create(Icon.LANDMARK);
  }

  default LucideIcon nepali_rupee_finance() {
    return LucideIcon.create(Icon.NEPALI_RUPEE);
  }

  default LucideIcon nfc_finance() {
    return LucideIcon.create(Icon.NFC);
  }

  default LucideIcon percent_finance() {
    return LucideIcon.create(Icon.PERCENT);
  }

  default LucideIcon philippine_peso() {
    return LucideIcon.create(Icon.PHILIPPINE_PESO);
  }

  default LucideIcon piggy_bank() {
    return LucideIcon.create(Icon.PIGGY_BANK);
  }

  default LucideIcon pound_sterling() {
    return LucideIcon.create(Icon.POUND_STERLING);
  }

  default LucideIcon receipt_finance() {
    return LucideIcon.create(Icon.RECEIPT);
  }

  default LucideIcon receipt_cent_finance() {
    return LucideIcon.create(Icon.RECEIPT_CENT);
  }

  default LucideIcon receipt_euro_finance() {
    return LucideIcon.create(Icon.RECEIPT_EURO);
  }

  default LucideIcon receipt_indian_rupee_finance() {
    return LucideIcon.create(Icon.RECEIPT_INDIAN_RUPEE);
  }

  default LucideIcon receipt_japanese_yen_finance() {
    return LucideIcon.create(Icon.RECEIPT_JAPANESE_YEN);
  }

  default LucideIcon receipt_pound_sterling_finance() {
    return LucideIcon.create(Icon.RECEIPT_POUND_STERLING);
  }

  default LucideIcon receipt_russian_ruble_finance() {
    return LucideIcon.create(Icon.RECEIPT_RUSSIAN_RUBLE);
  }

  default LucideIcon receipt_swiss_franc_finance() {
    return LucideIcon.create(Icon.RECEIPT_SWISS_FRANC);
  }

  default LucideIcon receipt_text_finance() {
    return LucideIcon.create(Icon.RECEIPT_TEXT);
  }

  default LucideIcon receipt_turkish_lira_finance() {
    return LucideIcon.create(Icon.RECEIPT_TURKISH_LIRA);
  }

  default LucideIcon russian_ruble() {
    return LucideIcon.create(Icon.RUSSIAN_RUBLE);
  }

  default LucideIcon saudi_riyal() {
    return LucideIcon.create(Icon.SAUDI_RIYAL);
  }

  default LucideIcon scale_finance() {
    return LucideIcon.create(Icon.SCALE);
  }

  default LucideIcon smartphone_nfc_finance() {
    return LucideIcon.create(Icon.SMARTPHONE_NFC);
  }

  default LucideIcon square_percent_finance() {
    return LucideIcon.create(Icon.SQUARE_PERCENT);
  }

  default LucideIcon swiss_franc() {
    return LucideIcon.create(Icon.SWISS_FRANC);
  }

  default LucideIcon turkish_lira() {
    return LucideIcon.create(Icon.TURKISH_LIRA);
  }

  default LucideIcon wallet_finance() {
    return LucideIcon.create(Icon.WALLET);
  }

  default LucideIcon wallet_cards_finance() {
    return LucideIcon.create(Icon.WALLET_CARDS);
  }

  default LucideIcon wallet_minimal_finance() {
    return LucideIcon.create(Icon.WALLET_MINIMAL);
  }
}
