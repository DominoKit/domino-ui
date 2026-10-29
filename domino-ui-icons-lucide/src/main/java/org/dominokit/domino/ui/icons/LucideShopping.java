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

/** Lucide shopping catalog category. */
public interface LucideShopping {
  enum Icon implements LucideIconDefinition {
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
    BARCODE(
        "barcode",
        "<path d=\"M3 5v14\" />\n  <path d=\"M8 5v14\" />\n  <path d=\"M12 5v14\" />\n  <path d=\"M17 5v14\" />\n  <path d=\"M21 5v14\" />"),
    BELARUSIAN_RUBLE(
        "belarusian-ruble",
        "<path d=\"M3 16 L13 16\" />\n  <path d=\"M6 12h9a4 4 0 0 1 0 8H7a1 1 0 0 1-1-1V5a1 1 0 0 1 1-1h7\" />"),
    BOOK_IMAGE(
        "book-image",
        "<path d=\"m20 13.7-2.1-2.1a2 2 0 0 0-2.8 0L9.7 17\" />\n  <path d=\"M4 19.5v-15A2.5 2.5 0 0 1 6.5 2H19a1 1 0 0 1 1 1v18a1 1 0 0 1-1 1H6.5a1 1 0 0 1 0-5H20\" />\n  <circle cx=\"10\" cy=\"8\" r=\"2\" />"),
    CIRCLE_EURO(
        "circle-euro",
        "<path d=\"M15 9.4a4 4 0 1 0 0 5.2\" />\n  <path d=\"M7 12h5\" />\n  <circle cx=\"12\" cy=\"12\" r=\"10\" />"),
    CIRCLE_PERCENT(
        "circle-percent",
        "<circle cx=\"12\" cy=\"12\" r=\"10\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
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
    DIAMOND_PERCENT(
        "diamond-percent",
        "<path d=\"M2.7 10.3a2.41 2.41 0 0 0 0 3.41l7.59 7.59a2.41 2.41 0 0 0 3.41 0l7.59-7.59a2.41 2.41 0 0 0 0-3.41L13.7 2.71a2.41 2.41 0 0 0-3.41 0Z\" />\n  <path d=\"M9.2 9.2h.01\" />\n  <path d=\"m14.5 9.5-5 5\" />\n  <path d=\"M14.7 14.8h.01\" />"),
    HANDBAG(
        "handbag",
        "<path d=\"M2.048 18.566A2 2 0 0 0 4 21h16a2 2 0 0 0 1.952-2.434l-2-9A2 2 0 0 0 18 8H6a2 2 0 0 0-1.952 1.566z\" />\n  <path d=\"M8 11V6a4 4 0 0 1 8 0v5\" />"),
    NEPALI_RUPEE(
        "nepali-rupee",
        "<path d=\"M18 16.173 A4.74 4.74 0 0 0 13.496 8.005\" />\n  <path d=\"M4 3 L20 3\" />\n  <path d=\"M5 13 L13.5 21\" />\n  <path d=\"M5 13 L9 13\" />\n  <path d=\"M8 13 C15.5 13 14.667 3 8 3\" />"),
    PAPER_BAG(
        "paper-bag",
        "<path d=\"M5.364 3.848C4 6 3 9.652 3 12.652V19a2 2 0 002 2h14a2 2 0 002-2v-5c0-2.334-1.816-4.668-2.622-7.002\" />\n  <path d=\"M7 3h11.379a2 2 0 011.789 1.106l.723 1.447A1 1 0 0119.997 7h-8.525a2 2 0 01-1.789-1.106L8.79 4.105a2 2 0 10-3.579 1.789l2.261 4.522A5 5 0 018 12.652V21\" />"),
    PERCENT(
        "percent",
        "<line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />\n  <circle cx=\"6.5\" cy=\"6.5\" r=\"2.5\" />\n  <circle cx=\"17.5\" cy=\"17.5\" r=\"2.5\" />"),
    PERFUME_BOTTLE(
        "perfume-bottle",
        "<path d=\"M 5 22 H 11.072\" />\n  <path d=\"M15 5 C 23 4 23.328 12.676 20 14.536\" />\n  <path d=\"M15.802 10.308 C 14.776 9.465 14 8.496 14 7\" />\n  <path d=\"M2 2h.01\" />\n  <path d=\"M2 7h.01\" />\n  <path d=\"M5 4.5h.01\" />\n  <path d=\"M8.127 22 A 8 8 0 0 1 4 15 3 3 0 0 1 4.879 12.879C 6.879 10.879 10 10 10 7\" />\n  <circle cx=\"18\" cy=\"18\" r=\"4\" />\n  <rect x=\"9\" y=\"2\" width=\"6\" height=\"5\" rx=\"1\" />"),
    SCAN(
        "scan",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />"),
    SCAN_BARCODE(
        "scan-barcode",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M8 7v10\" />\n  <path d=\"M12 7v10\" />\n  <path d=\"M17 7v10\" />"),
    SCAN_BOX(
        "scan-box",
        "<path d=\"M12 12v5.5\" />\n  <path d=\"M17 3h2a2 2 0 012 2v2\" />\n  <path d=\"M21 17v2a2 2 0 01-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 012-2h2\" />\n  <path d=\"M7 21H5a2 2 0 01-2-2v-2\" />\n  <path d=\"M7.264 9.252 12 12l4.737-2.748\" />\n  <path d=\"M7.995 8.514A2 2 0 007 10.244v3.516a2 2 0 00.996 1.73l3 1.74a2 2 0 002.008 0l3-1.74A2 2 0 0017 13.76v-3.517a2 2 0 00-.995-1.73l-3-1.742a2 2 0 00-1.892-.064z\" />"),
    SCAN_LINE(
        "scan-line",
        "<path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <path d=\"M7 12h10\" />"),
    SCAN_QR_CODE(
        "scan-qr-code",
        "<path d=\"M17 12v4a1 1 0 0 1-1 1h-4\" />\n  <path d=\"M17 3h2a2 2 0 0 1 2 2v2\" />\n  <path d=\"M17 8V7\" />\n  <path d=\"M21 17v2a2 2 0 0 1-2 2h-2\" />\n  <path d=\"M3 7V5a2 2 0 0 1 2-2h2\" />\n  <path d=\"M7 17h.01\" />\n  <path d=\"M7 21H5a2 2 0 0 1-2-2v-2\" />\n  <rect x=\"7\" y=\"7\" width=\"5\" height=\"5\" rx=\"1\" />"),
    SHIRT(
        "shirt",
        "<path d=\"M20.38 3.46 16 2a4 4 0 0 1-8 0L3.62 3.46a2 2 0 0 0-1.34 2.23l.58 3.47a1 1 0 0 0 .99.84H6v10c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2V10h2.15a1 1 0 0 0 .99-.84l.58-3.47a2 2 0 0 0-1.34-2.23z\" />"),
    SHOPPING_BAG(
        "shopping-bag",
        "<path d=\"M16 10a4 4 0 0 1-8 0\" />\n  <path d=\"M3.103 6.034h17.794\" />\n  <path d=\"M3.4 5.467a2 2 0 0 0-.4 1.2V20a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6.667a2 2 0 0 0-.4-1.2l-2-2.667A2 2 0 0 0 17 2H7a2 2 0 0 0-1.6.8z\" />"),
    SHOPPING_BASKET(
        "shopping-basket",
        "<path d=\"m15 11-1 9\" />\n  <path d=\"m19 11-4-7\" />\n  <path d=\"M2 11h20\" />\n  <path d=\"m3.5 11 1.6 7.4a2 2 0 0 0 2 1.6h9.8a2 2 0 0 0 2-1.6l1.7-7.4\" />\n  <path d=\"M4.5 15.5h15\" />\n  <path d=\"m5 11 4-7\" />\n  <path d=\"m9 11 1 9\" />"),
    SHOPPING_CART(
        "shopping-cart",
        "<path d=\"m2.05 2.05 1.099-.028a1 1 0 0 1 1.008.815l2.69 14.347A1 1 0 0 0 7.83 18H18\" />\n  <path d=\"M4.563 5h16.435a1 1 0 0 1 .981 1.204l-1.026 6.226A2 2 0 0 1 18.962 14H6.25\" />\n  <circle cx=\"18\" cy=\"20\" r=\"2\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    SHOPPING_CART_MINUS(
        "shopping-cart-minus",
        "<path d=\"M16 5h6\" />\n  <path d=\"m2.05 2.05 1.099-.028a1 1 0 011.008.815l2.69 14.347A1 1 0 007.83 18H18\" />\n  <path d=\"M4.564 5H12\" />\n  <path d=\"M6.25 14h12.712a2 2 0 001.991-1.57l.514-3.113\" />\n  <circle cx=\"18\" cy=\"20\" r=\"2\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    SHOPPING_CART_PLUS(
        "shopping-cart-plus",
        "<path d=\"M16 5h6\" />\n  <path d=\"M19 2v6\" />\n  <path d=\"m2.05 2.05 1.099-.028a1 1 0 011.008.815l2.69 14.347A1 1 0 007.83 18H18\" />\n  <path d=\"M4.564 5H12\" />\n  <path d=\"M6.25 14h12.712a2 2 0 001.991-1.57l.172-1.041\" />\n  <circle cx=\"18\" cy=\"20\" r=\"2\" />\n  <circle cx=\"8\" cy=\"20\" r=\"2\" />"),
    SQUARE_PERCENT(
        "square-percent",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"M15 15h.01\" />"),
    STORE(
        "store",
        "<path d=\"M15 21v-5a1 1 0 0 0-1-1h-4a1 1 0 0 0-1 1v5\" />\n  <path d=\"M17.774 10.31a1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.451 0 1.12 1.12 0 0 0-1.548 0 2.5 2.5 0 0 1-3.452 0 1.12 1.12 0 0 0-1.549 0 2.5 2.5 0 0 1-3.77-3.248l2.889-4.184A2 2 0 0 1 7 2h10a2 2 0 0 1 1.653.873l2.895 4.192a2.5 2.5 0 0 1-3.774 3.244\" />\n  <path d=\"M4 10.95V19a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2v-8.05\" />"),
    TICKET_PERCENT(
        "ticket-percent",
        "<path d=\"M2 9a3 3 0 1 1 0 6v2a2 2 0 0 0 2 2h16a2 2 0 0 0 2-2v-2a3 3 0 1 1 0-6V7a2 2 0 0 0-2-2H4a2 2 0 0 0-2 2Z\" />\n  <path d=\"M9 9h.01\" />\n  <path d=\"m15 9-6 6\" />\n  <path d=\"M15 15h.01\" />"),
    TUBE_LOTION(
        "tube-lotion",
        "<path d=\"M15 18v3a1 1 0 0 1-1 1h-4a1 1 0 0 1-1-1v-3\" />\n  <path d=\"M17 2a2 2 0 0 1 1.6 3.2A8 8 0 0 0 17 10v6a2 2 0 0 1-2 2H9a2 2 0 0 1-2-2v-6a8 8 0 0 0-1.6-4.8A2 2 0 0 1 7 2z\" />\n  <path d=\"M7 10a6.47 6.47 0 0 1 5 0 6.47 6.47 0 0 0 5 0\" />");

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
  default LucideIcon badge_cent_shopping() {
    return LucideIcon.create(Icon.BADGE_CENT);
  }

  default LucideIcon badge_dollar_sign_shopping() {
    return LucideIcon.create(Icon.BADGE_DOLLAR_SIGN);
  }

  default LucideIcon badge_euro_shopping() {
    return LucideIcon.create(Icon.BADGE_EURO);
  }

  default LucideIcon badge_indian_rupee_shopping() {
    return LucideIcon.create(Icon.BADGE_INDIAN_RUPEE);
  }

  default LucideIcon badge_japanese_yen_shopping() {
    return LucideIcon.create(Icon.BADGE_JAPANESE_YEN);
  }

  default LucideIcon badge_percent_shopping() {
    return LucideIcon.create(Icon.BADGE_PERCENT);
  }

  default LucideIcon badge_pound_sterling_shopping() {
    return LucideIcon.create(Icon.BADGE_POUND_STERLING);
  }

  default LucideIcon badge_russian_ruble_shopping() {
    return LucideIcon.create(Icon.BADGE_RUSSIAN_RUBLE);
  }

  default LucideIcon badge_swiss_franc_shopping() {
    return LucideIcon.create(Icon.BADGE_SWISS_FRANC);
  }

  default LucideIcon badge_turkish_lira_shopping() {
    return LucideIcon.create(Icon.BADGE_TURKISH_LIRA);
  }

  default LucideIcon bangladeshi_taka_shopping() {
    return LucideIcon.create(Icon.BANGLADESHI_TAKA);
  }

  default LucideIcon barcode() {
    return LucideIcon.create(Icon.BARCODE);
  }

  default LucideIcon belarusian_ruble_shopping() {
    return LucideIcon.create(Icon.BELARUSIAN_RUBLE);
  }

  default LucideIcon book_image_shopping() {
    return LucideIcon.create(Icon.BOOK_IMAGE);
  }

  default LucideIcon circle_euro_shopping() {
    return LucideIcon.create(Icon.CIRCLE_EURO);
  }

  default LucideIcon circle_percent_shopping() {
    return LucideIcon.create(Icon.CIRCLE_PERCENT);
  }

  default LucideIcon credit_card_check_shopping() {
    return LucideIcon.create(Icon.CREDIT_CARD_CHECK);
  }

  default LucideIcon credit_card_minus_shopping() {
    return LucideIcon.create(Icon.CREDIT_CARD_MINUS);
  }

  default LucideIcon credit_card_plus_shopping() {
    return LucideIcon.create(Icon.CREDIT_CARD_PLUS);
  }

  default LucideIcon credit_card_reader_shopping() {
    return LucideIcon.create(Icon.CREDIT_CARD_READER);
  }

  default LucideIcon credit_card_x_shopping() {
    return LucideIcon.create(Icon.CREDIT_CARD_X);
  }

  default LucideIcon diamond_percent_shopping() {
    return LucideIcon.create(Icon.DIAMOND_PERCENT);
  }

  default LucideIcon handbag_shopping() {
    return LucideIcon.create(Icon.HANDBAG);
  }

  default LucideIcon nepali_rupee_shopping() {
    return LucideIcon.create(Icon.NEPALI_RUPEE);
  }

  default LucideIcon paper_bag() {
    return LucideIcon.create(Icon.PAPER_BAG);
  }

  default LucideIcon percent_shopping() {
    return LucideIcon.create(Icon.PERCENT);
  }

  default LucideIcon perfume_bottle_shopping() {
    return LucideIcon.create(Icon.PERFUME_BOTTLE);
  }

  default LucideIcon scan_shopping() {
    return LucideIcon.create(Icon.SCAN);
  }

  default LucideIcon scan_barcode_shopping() {
    return LucideIcon.create(Icon.SCAN_BARCODE);
  }

  default LucideIcon scan_box_shopping() {
    return LucideIcon.create(Icon.SCAN_BOX);
  }

  default LucideIcon scan_line_shopping() {
    return LucideIcon.create(Icon.SCAN_LINE);
  }

  default LucideIcon scan_qr_code_shopping() {
    return LucideIcon.create(Icon.SCAN_QR_CODE);
  }

  default LucideIcon shirt() {
    return LucideIcon.create(Icon.SHIRT);
  }

  default LucideIcon shopping_bag() {
    return LucideIcon.create(Icon.SHOPPING_BAG);
  }

  default LucideIcon shopping_basket() {
    return LucideIcon.create(Icon.SHOPPING_BASKET);
  }

  default LucideIcon shopping_cart() {
    return LucideIcon.create(Icon.SHOPPING_CART);
  }

  default LucideIcon shopping_cart_minus() {
    return LucideIcon.create(Icon.SHOPPING_CART_MINUS);
  }

  default LucideIcon shopping_cart_plus() {
    return LucideIcon.create(Icon.SHOPPING_CART_PLUS);
  }

  default LucideIcon square_percent_shopping() {
    return LucideIcon.create(Icon.SQUARE_PERCENT);
  }

  default LucideIcon store_shopping() {
    return LucideIcon.create(Icon.STORE);
  }

  default LucideIcon ticket_percent_shopping() {
    return LucideIcon.create(Icon.TICKET_PERCENT);
  }

  default LucideIcon tube_lotion_shopping() {
    return LucideIcon.create(Icon.TUBE_LOTION);
  }
}
