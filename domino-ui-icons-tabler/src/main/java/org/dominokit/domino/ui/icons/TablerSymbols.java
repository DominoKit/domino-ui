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

/** Tabler Symbols catalog category. */
public interface TablerSymbols {
  enum OutlineIcon implements TablerIconDefinition {
    ANKH(
        "ankh",
        "<path d=\"M6 13h12\" />\n  <path d=\"M12 21v-8l-.422 -.211a6.472 6.472 0 0 1 -3.578 -5.789a4 4 0 1 1 8 0a6.472 6.472 0 0 1 -3.578 5.789l-.422 .211\" />"),
    BIOHAZARD(
        "biohazard",
        "<path d=\"M10 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M11.939 14c0 .173 .048 .351 .056 .533l0 .217a4.75 4.75 0 0 1 -4.533 4.745l-.217 0m-4.75 -4.75a4.75 4.75 0 0 1 7.737 -3.693m6.513 8.443a4.75 4.75 0 0 1 -4.69 -5.503l-.06 0m1.764 -2.944a4.75 4.75 0 0 1 7.731 3.477l0 .217m-11.195 -3.813a4.75 4.75 0 0 1 -1.828 -7.624l.164 -.172m6.718 0a4.75 4.75 0 0 1 -1.665 7.798\" />"),
    BIOHAZARD_OFF(
        "biohazard-off",
        "<path d=\"M10.586 10.586a2 2 0 1 0 2.836 2.82\" />\n  <path d=\"M11.939 14c0 .173 .048 .351 .056 .533v.217a4.75 4.75 0 0 1 -4.533 4.745h-.217\" />\n  <path d=\"M2.495 14.745a4.75 4.75 0 0 1 7.737 -3.693\" />\n  <path d=\"M16.745 19.495a4.75 4.75 0 0 1 -4.69 -5.503h-.06\" />\n  <path d=\"M14.533 10.538a4.75 4.75 0 0 1 6.957 3.987v.217\" />\n  <path d=\"M10.295 10.929a4.75 4.75 0 0 1 -2.988 -3.64m.66 -3.324a4.75 4.75 0 0 1 .5 -.66l.164 -.172\" />\n  <path d=\"M15.349 3.133a4.75 4.75 0 0 1 -.836 7.385\" />\n  <path d=\"M3 3l18 18\" />"),
    CE(
        "ce",
        "<path d=\"M9 6a6 6 0 1 0 0 12\" />\n  <path d=\"M21 6a6 6 0 1 0 0 12\" />\n  <path d=\"M15 12h6\" />"),
    CE_OFF(
        "ce-off",
        "<path d=\"M6.53 6.53a6.001 6.001 0 0 0 2.47 11.47\" />\n  <path d=\"M21 6a6 6 0 0 0 -5.927 5.061l.927 .939\" />\n  <path d=\"M16 12h5\" />\n  <path d=\"M3 3l18 18\" />"),
    COMMAND(
        "command",
        "<path d=\"M7 9a2 2 0 1 1 2 -2v10a2 2 0 1 1 -2 -2h10a2 2 0 1 1 -2 2v-10a2 2 0 1 1 2 2h-10\" />"),
    COMMAND_OFF(
        "command-off",
        "<path d=\"M9 9v8a2 2 0 1 1 -2 -2h8m3.411 3.417a2 2 0 0 1 -3.411 -1.417v-2m0 -4v-4a2 2 0 1 1 2 2h-4m-4 0h-2a2 2 0 0 1 -1.417 -3.411\" />\n  <path d=\"M3 3l18 18\" />"),
    CONFUCIUS(
        "confucius",
        "<path d=\"M9 19l3 2v-18\" />\n  <path d=\"M4 10l8 -2\" />\n  <path d=\"M4 18l8 -10\" />\n  <path d=\"M20 18l-8 -8l8 -4\" />"),
    COPYLEFT(
        "copyleft",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 9.75a3.016 3.016 0 0 1 4.163 .173a2.993 2.993 0 0 1 0 4.154a3.016 3.016 0 0 1 -4.163 .173\" />"),
    COPYLEFT_OFF(
        "copyleft-off",
        "<path d=\"M13.303 9.3a3.01 3.01 0 0 1 1.405 1.406m-.586 3.413a3.016 3.016 0 0 1 -4.122 .131\" />\n  <path d=\"M20.042 16.045a9 9 0 0 0 -12.087 -12.087m-2.318 1.677a9 9 0 1 0 12.725 12.73\" />\n  <path d=\"M3 3l18 18\" />"),
    COPYRIGHT(
        "copyright",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14 9.75a3.016 3.016 0 0 0 -4.163 .173a2.993 2.993 0 0 0 0 4.154a3.016 3.016 0 0 0 4.163 .173\" />"),
    COPYRIGHT_OFF(
        "copyright-off",
        "<path d=\"M14 9.75a3.016 3.016 0 0 0 -.711 -.466m-3.41 .596a2.993 2.993 0 0 0 -.042 4.197a3.016 3.016 0 0 0 4.163 .173\" />\n  <path d=\"M20.042 16.045a9 9 0 0 0 -12.087 -12.087m-2.318 1.677a9 9 0 1 0 12.725 12.73\" />\n  <path d=\"M3 3l18 18\" />"),
    CROSS("cross", "<path d=\"M10 21h4v-9h5v-4h-5v-5h-4v5h-5v4h5l0 9\" />"),
    CROSS_OFF(
        "cross-off",
        "<path d=\"M16 12h3v-4h-5v-5h-4v3m-2 2h-3v4h5v9h4v-7\" />\n  <path d=\"M3 3l18 18\" />"),
    FISH_CHRISTIANITY(
        "fish-christianity",
        "<path d=\"M22 7s-5.646 10 -12.308 10c-3.226 .025 -6.194 -1.905 -7.692 -5c1.498 -3.095 4.466 -5.025 7.692 -5c6.662 0 12.308 10 12.308 10\" />"),
    MARS(
        "mars",
        "<path d=\"M5 14a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M19 5l-5.4 5.4\" />\n  <path d=\"M19 5l-5 0\" />\n  <path d=\"M19 5l0 5\" />"),
    MENORAH(
        "menorah",
        "<path d=\"M12 4v16\" />\n  <path d=\"M8 4v2a4 4 0 1 0 8 0v-2\" />\n  <path d=\"M4 4v2a8 8 0 1 0 16 0v-2\" />\n  <path d=\"M10 20h4\" />"),
    OM(
        "om",
        "<path d=\"M7 12c2.21 0 4 -1.567 4 -3.5s-1.79 -3.5 -4 -3.5c-1.594 0 -2.97 .816 -3.613 2\" />\n  <path d=\"M3.423 14.483a4.944 4.944 0 0 0 -.423 2.017c0 2.485 1.79 4.5 4 4.5s4 -2.015 4 -4.5s-1.79 -4.5 -4 -4.5\" />\n  <path d=\"M14.071 17.01c.327 2.277 1.739 3.99 3.429 3.99c1.933 0 3.5 -2.239 3.5 -5s-1.567 -5 -3.5 -5c-.96 0 -1.868 .606 -2.5 1.5c-.717 1.049 -1.76 1.7 -2.936 1.7c-.92 0 -1.766 -.406 -2.434 -1.087\" />\n  <path d=\"M17 3l2 2\" />\n  <path d=\"M12 3c1.667 3.667 4.667 5.333 9 5\" />"),
    OPTION("option", "<path d=\"M14 6h5m0 12h-5l-5 -12h-4\" />"),
    PARKING_CIRCLE(
        "parking-circle",
        "<path d=\"M10 16v-8h3.334c.92 0 1.666 .895 1.666 2s-.746 2 -1.666 2h-3.334\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 0 0 -18 0\" />"),
    PEACE(
        "peace",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 3l0 18\" />\n  <path d=\"M12 12l6.3 6.3\" />\n  <path d=\"M12 12l-6.3 6.3\" />"),
    RADIOACTIVE(
        "radioactive",
        "<path d=\"M13.5 14.6l3 5.19a9 9 0 0 0 4.5 -7.79h-6a3 3 0 0 1 -1.5 2.6\" />\n  <path d=\"M13.5 9.4l3 -5.19a9 9 0 0 0 -9 0l3 5.19a3 3 0 0 1 3 0\" />\n  <path d=\"M10.5 14.6l-3 5.19a9 9 0 0 1 -4.5 -7.79h6a3 3 0 0 0 1.5 2.6\" />"),
    RADIOACTIVE_OFF(
        "radioactive-off",
        "<path d=\"M14.118 14.127c-.182 .181 -.39 .341 -.618 .473l3 5.19a9 9 0 0 0 1.856 -1.423m1.68 -2.32a8.993 8.993 0 0 0 .964 -4.047h-5\" />\n  <path d=\"M13.5 9.4l3 -5.19a9 9 0 0 0 -8.536 -.25\" />\n  <path d=\"M10.5 14.6l-3 5.19a9 9 0 0 1 -4.5 -7.79h6a3 3 0 0 0 1.5 2.6\" />\n  <path d=\"M3 3l18 18\" />"),
    RATING_12_PLUS(
        "rating-12-plus",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M7 15v-6\" />\n  <path d=\"M15.5 12h3\" />\n  <path d=\"M17 10.5v3\" />\n  <path d=\"M10 10.5a1.5 1.5 0 0 1 3 0c0 .443 -.313 .989 -.612 1.393l-2.388 3.107h3\" />"),
    RATING_14_PLUS(
        "rating-14-plus",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M7 15v-6\" />\n  <path d=\"M15.5 12h3\" />\n  <path d=\"M17 10.5v3\" />\n  <path d=\"M12.5 15v-6m-2.5 0v4h3\" />"),
    RATING_16_PLUS(
        "rating-16-plus",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 13.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M7 15v-6\" />\n  <path d=\"M15.5 12h3\" />\n  <path d=\"M17 10.5v3\" />\n  <path d=\"M10 13.5v-3a1.5 1.5 0 0 1 1.5 -1.5h1\" />"),
    RATING_18_PLUS(
        "rating-18-plus",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 10.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M10 13.5a1.5 1.5 0 1 0 3 0a1.5 1.5 0 1 0 -3 0\" />\n  <path d=\"M7 15v-6\" />\n  <path d=\"M15.5 12h3\" />\n  <path d=\"M17 10.5v3\" />"),
    RATING_21_PLUS(
        "rating-21-plus",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M13 15v-6\" />\n  <path d=\"M15.5 12h3\" />\n  <path d=\"M17 10.5v3\" />\n  <path d=\"M7 10.5a1.5 1.5 0 0 1 3 0c0 .443 -.313 .989 -.612 1.393l-2.388 3.107h3\" />"),
    RECYCLE(
        "recycle",
        "<path d=\"M12 17l-2 2l2 2\" />\n  <path d=\"M10 19h9a2 2 0 0 0 1.75 -2.75l-.55 -1\" />\n  <path d=\"M8.536 11l-.732 -2.732l-2.732 .732\" />\n  <path d=\"M7.804 8.268l-4.5 7.794a2 2 0 0 0 1.506 2.89l1.141 .024\" />\n  <path d=\"M15.464 11l2.732 .732l.732 -2.732\" />\n  <path d=\"M18.196 11.732l-4.5 -7.794a2 2 0 0 0 -3.256 -.14l-.591 .976\" />"),
    RECYCLE_OFF(
        "recycle-off",
        "<path d=\"M12 17l-2 2l2 2m-2 -2h9m1.896 -2.071a2 2 0 0 0 -.146 -.679l-.55 -1\" />\n  <path d=\"M8.536 11l-.732 -2.732l-2.732 .732m2.732 -.732l-4.5 7.794a2 2 0 0 0 1.506 2.89l1.141 .024\" />\n  <path d=\"M15.464 11l2.732 .732l.732 -2.732m-.732 2.732l-4.5 -7.794a2 2 0 0 0 -3.256 -.14l-.591 .976\" />\n  <path d=\"M3 3l18 18\" />"),
    REGISTERED(
        "registered",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M10 15v-6h2a2 2 0 1 1 0 4h-2\" />\n  <path d=\"M14 15l-2 -2\" />"),
    RIBBON_HEALTH(
        "ribbon-health",
        "<path d=\"M7 21s9.286 -9.841 9.286 -13.841a3.864 3.864 0 0 0 -1.182 -3.008a4.13 4.13 0 0 0 -3.104 -1.144a4.13 4.13 0 0 0 -3.104 1.143a3.864 3.864 0 0 0 -1.182 3.01c0 4 9.286 13.84 9.286 13.84\" />"),
    SERVICEMARK(
        "servicemark",
        "<path d=\"M9 9h-2.5a1.5 1.5 0 0 0 0 3h1a1.5 1.5 0 0 1 0 3h-2.5\" />\n  <path d=\"M13 15v-6l3 4l3 -4v6\" />"),
    TORII(
        "torii",
        "<path d=\"M4 4c5.333 1.333 10.667 1.333 16 0\" />\n  <path d=\"M4 8h16\" />\n  <path d=\"M12 5v3\" />\n  <path d=\"M18 4.5v15.5\" />\n  <path d=\"M6 4.5v15.5\" />"),
    TRADEMARK(
        "trademark", "<path d=\"M4.5 9h5m-2.5 0v6\" />\n  <path d=\"M13 15v-6l3 4l3 -4v6\" />"),
    VENUS(
        "venus",
        "<path d=\"M7 9a5 5 0 1 0 10 0a5 5 0 1 0 -10 0\" />\n  <path d=\"M12 14l0 7\" />\n  <path d=\"M9 18l6 0\" />"),
    YIN_YANG(
        "yin-yang",
        "<path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 3a4.5 4.5 0 0 0 0 9a4.5 4.5 0 0 1 0 9\" />\n  <path d=\"M11.5 7.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />\n  <path d=\"M11.5 16.5a.5 .5 0 1 0 1 0a.5 .5 0 1 0 -1 0\" fill=\"currentColor\" />");

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
    BIOHAZARD(
        "biohazard",
        "<path d=\"M16.41 2.072a6.25 6.25 0 0 1 1.514 6.387l-.051 .137l.223 .044q .325 .072 .645 .18l.318 .117l.25 .105c2.155 .97 3.572 3.067 3.681 5.483v.217a1.5 1.5 0 1 1 -3 -.003l.002 -.145a3.25 3.25 0 0 0 -4.412 -2.886l-.091 .037l.004 .038l.007 .217a3.5 3.5 0 0 1 -1.817 3.07l-.16 .082l.014 .11c.082 .511 .285 .997 .595 1.416l.14 .175a3.25 3.25 0 0 0 2.27 1.136l.203 .006a1.5 1.5 0 0 1 0 3a6.25 6.25 0 0 1 -4.575 -1.991l-.177 -.199l-.078 .092a6.3 6.3 0 0 1 -3.921 2.054l-.273 .028l-.259 .016h-.217a1.5 1.5 0 1 1 .003 -3l.145 .002a3.25 3.25 0 0 0 3.074 -2.82l.003 -.03l-.161 -.083a3.5 3.5 0 0 1 -1.804 -2.883l-.005 -.195l.006 -.191l.003 -.043l-.075 -.032a3.25 3.25 0 0 0 -2.398 .008l-.191 .084a3.25 3.25 0 0 0 -1.85 2.933a1.5 1.5 0 0 1 -3 0a6.25 6.25 0 0 1 5.036 -6.13l.077 -.014l-.05 -.143l-.08 -.26l-.066 -.25a6.27 6.27 0 0 1 1.47 -5.678l.163 -.172a1.5 1.5 0 1 1 2.171 2.07l-.137 .143a3.25 3.25 0 0 0 .386 4.723l.084 .062l.05 -.034a3.5 3.5 0 0 1 1.673 -.555l.228 -.007c.683 0 1.336 .197 1.894 .556l.048 .033l.067 -.048a3.25 3.25 0 0 0 1.111 -1.669l.05 -.2a3.25 3.25 0 0 0 -.74 -2.828l-.141 -.15a1.5 1.5 0 1 1 2.12 -2.122\" />"),
    COPYLEFT(
        "copyleft",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2.117 5.889a4.016 4.016 0 0 0 -5.543 -.23a1 1 0 0 0 1.32 1.502a2.016 2.016 0 0 1 2.783 .116a1.993 1.993 0 0 1 0 2.766a2.016 2.016 0 0 1 -2.783 .116a1 1 0 0 0 -1.32 1.501a4.016 4.016 0 0 0 5.543 -.23a3.993 3.993 0 0 0 0 -5.542z\" />"),
    COPYRIGHT(
        "copyright",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-2.34 5.659a4.016 4.016 0 0 0 -5.543 .23a3.993 3.993 0 0 0 0 5.542a4.016 4.016 0 0 0 5.543 .23a1 1 0 0 0 -1.32 -1.502c-.81 .711 -2.035 .66 -2.783 -.116a1.993 1.993 0 0 1 0 -2.766a2.016 2.016 0 0 1 2.783 -.116a1 1 0 0 0 1.32 -1.501z\" />"),
    CROSS(
        "cross",
        "<path d=\"M10 2l-.117 .007a1 1 0 0 0 -.883 .993v4h-4a1 1 0 0 0 -1 1v4l.007 .117a1 1 0 0 0 .993 .883h4v8a1 1 0 0 0 1 1h4l.117 -.007a1 1 0 0 0 .883 -.993v-8h4a1 1 0 0 0 1 -1v-4l-.007 -.117a1 1 0 0 0 -.993 -.883h-4v-4a1 1 0 0 0 -1 -1h-4z\" />"),
    PARKING_CIRCLE(
        "parking-circle",
        "<path d=\"M12 2c5.523 0 10 4.477 10 10a10 10 0 0 1 -20 0l.004 -.28c.148 -5.393 4.566 -9.72 9.996 -9.72m1.334 5h-3.334a1 1 0 0 0 -1 1v8a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-3h2.334c1.516 0 2.666 -1.38 2.666 -3s-1.15 -3 -2.666 -3m0 2c.323 0 .666 .411 .666 1s-.343 1 -.666 1h-2.334v-2z\" />"),
    RADIOACTIVE(
        "radioactive",
        "<path d=\"M21 11a1 1 0 0 1 1 1a10 10 0 0 1 -5 8.656a1 1 0 0 1 -1.302 -.268l-.064 -.098l-3 -5.19a.995 .995 0 0 1 -.133 -.542l.01 -.11l.023 -.106l.034 -.106l.046 -.1l.056 -.094l.067 -.089a.994 .994 0 0 1 .165 -.155l.098 -.064a2 2 0 0 0 .993 -1.57l.007 -.163a1 1 0 0 1 .883 -.994l.117 -.007h6z\" />\n  <path d=\"M7 3.344a10 10 0 0 1 10 0a1 1 0 0 1 .418 1.262l-.052 .104l-3 5.19l-.064 .098a.994 .994 0 0 1 -.155 .165l-.089 .067a1 1 0 0 1 -.195 .102l-.105 .034l-.107 .022a1.003 1.003 0 0 1 -.547 -.07l-.104 -.052a2 2 0 0 0 -1.842 -.082l-.158 .082a1 1 0 0 1 -1.302 -.268l-.064 -.098l-3 -5.19a1 1 0 0 1 .366 -1.366z\" />\n  <path d=\"M9 11a1 1 0 0 1 .993 .884l.007 .117a2 2 0 0 0 .861 1.645l.237 .152a.994 .994 0 0 1 .165 .155l.067 .089l.056 .095l.045 .099c.014 .036 .026 .07 .035 .106l.022 .107l.011 .11a.994 .994 0 0 1 -.08 .437l-.053 .104l-3 5.19a1 1 0 0 1 -1.366 .366a10 10 0 0 1 -5 -8.656a1 1 0 0 1 .883 -.993l.117 -.007h6z\" />"),
    REGISTERED(
        "registered",
        "<path d=\"M17 3.34a10 10 0 1 1 -15 8.66l.005 -.324a10 10 0 0 1 14.995 -8.336m-5 4.66h-2a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1h.585l1.708 1.707a1 1 0 0 0 1.414 -1.414l-.9 -.899a3 3 0 0 0 -1.807 -5.394m0 2a1 1 0 0 1 0 2h-1v-2z\" />"),
    YIN_YANG(
        "yin-yang",
        "<path d=\"M17 3.34a10 10 0 1 1 -14.995 8.984l-.005 -.324l.005 -.324a10 10 0 0 1 14.995 -8.336zm-9 1.732a8 8 0 0 0 4 14.928l.2 -.005a4 4 0 0 0 0 -7.99l-.2 -.005a4 4 0 0 1 -.2 -7.995l.2 -.005a7.995 7.995 0 0 0 -4 1.072zm4 1.428a1.5 1.5 0 1 0 0 3a1.5 1.5 0 0 0 0 -3\" />\n  <path d=\"M12 14.5a1.5 1.5 0 1 1 0 3a1.5 1.5 0 0 1 0 -3\" />");

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

  default TablerIcon ankh() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.ANKH);
  }

  default TablerIcon biohazard() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.BIOHAZARD);
  }

  default TablerIcon biohazard_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.BIOHAZARD_OFF);
  }

  default TablerIcon ce() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.CE);
  }

  default TablerIcon ce_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.CE_OFF);
  }

  default TablerIcon command() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COMMAND);
  }

  default TablerIcon command_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COMMAND_OFF);
  }

  default TablerIcon confucius() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.CONFUCIUS);
  }

  default TablerIcon copyleft() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COPYLEFT);
  }

  default TablerIcon copyleft_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COPYLEFT_OFF);
  }

  default TablerIcon copyright() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COPYRIGHT);
  }

  default TablerIcon copyright_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.COPYRIGHT_OFF);
  }

  default TablerIcon cross() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.CROSS);
  }

  default TablerIcon cross_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.CROSS_OFF);
  }

  default TablerIcon fish_christianity() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.FISH_CHRISTIANITY);
  }

  default TablerIcon mars() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.MARS);
  }

  default TablerIcon menorah() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.MENORAH);
  }

  default TablerIcon om() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.OM);
  }

  default TablerIcon option() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.OPTION);
  }

  default TablerIcon parking_circle() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.PARKING_CIRCLE);
  }

  default TablerIcon peace() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.PEACE);
  }

  default TablerIcon radioactive() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RADIOACTIVE);
  }

  default TablerIcon radioactive_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RADIOACTIVE_OFF);
  }

  default TablerIcon rating_12_plus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RATING_12_PLUS);
  }

  default TablerIcon rating_14_plus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RATING_14_PLUS);
  }

  default TablerIcon rating_16_plus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RATING_16_PLUS);
  }

  default TablerIcon rating_18_plus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RATING_18_PLUS);
  }

  default TablerIcon rating_21_plus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RATING_21_PLUS);
  }

  default TablerIcon recycle() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RECYCLE);
  }

  default TablerIcon recycle_off() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RECYCLE_OFF);
  }

  default TablerIcon registered() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.REGISTERED);
  }

  default TablerIcon ribbon_health() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.RIBBON_HEALTH);
  }

  default TablerIcon servicemark() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.SERVICEMARK);
  }

  default TablerIcon torii() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.TORII);
  }

  default TablerIcon trademark() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.TRADEMARK);
  }

  default TablerIcon venus() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.VENUS);
  }

  default TablerIcon yin_yang() {
    return TablerIcon.create(TablerSymbols.OutlineIcon.YIN_YANG);
  }

  default TablerIcon biohazard_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.BIOHAZARD);
  }

  default TablerIcon copyleft_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.COPYLEFT);
  }

  default TablerIcon copyright_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.COPYRIGHT);
  }

  default TablerIcon cross_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.CROSS);
  }

  default TablerIcon parking_circle_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.PARKING_CIRCLE);
  }

  default TablerIcon radioactive_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.RADIOACTIVE);
  }

  default TablerIcon registered_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.REGISTERED);
  }

  default TablerIcon yin_yang_filled() {
    return TablerIcon.create(TablerSymbols.FilledIcon.YIN_YANG);
  }
}
