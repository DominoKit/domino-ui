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

/** Tabler Badges catalog category. */
public interface TablerBadges {
  enum OutlineIcon implements TablerIconDefinition {
    AWARD(
        "award",
        "<path d=\"M6 9a6 6 0 1 0 12 0a6 6 0 1 0 -12 0\" />\n  <path d=\"M12 15l3.4 5.89l1.598 -3.233l3.598 .232l-3.4 -5.889\" />\n  <path d=\"M6.802 12l-3.4 5.89l3.598 -.233l1.598 3.232l3.4 -5.889\" />"),
    AWARD_OFF(
        "award-off",
        "<path d=\"M16.72 12.704a6 6 0 0 0 -8.433 -8.418m-1.755 2.24a6 6 0 0 0 7.936 7.944\" />\n  <path d=\"M12 15l3.4 5.89l1.598 -3.233l.707 .046m1.108 -2.902l-1.617 -2.8\" />\n  <path d=\"M6.802 12l-3.4 5.89l3.598 -.233l1.598 3.232l3.4 -5.889\" />\n  <path d=\"M3 3l18 18\" />"),
    BADGE("badge", "<path d=\"M17 17v-13l-5 3l-5 -3v13l5 3l5 -3\" />"),
    BADGE_2K(
        "badge-2k",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M17 9l-2 3l2 3\" />\n  <path d=\"M15 12h-1\" />\n  <path d=\"M7 9h2a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h2\" />"),
    BADGE_3D(
        "badge-3d",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M7 9h1.5a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1.5\" />\n  <path d=\"M14 9v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2l-1 0\" />"),
    BADGE_3K(
        "badge-3k",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M17 9l-2 3l2 3\" />\n  <path d=\"M15 12h-1\" />\n  <path d=\"M7 9.5a.5 .5 0 0 1 .5 -.5h1a1.5 1.5 0 0 1 0 3h-.5h.5a1.5 1.5 0 0 1 0 3h-1a.5 .5 0 0 1 -.5 -.5\" />"),
    BADGE_4K(
        "badge-4k",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 9v2a1 1 0 0 0 1 1h1\" />\n  <path d=\"M10 9v6\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M17 9l-2 3l2 3\" />\n  <path d=\"M15 12h-1\" />"),
    BADGE_5K(
        "badge-5k",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M17 9l-2 3l2 3\" />\n  <path d=\"M15 12h-1\" />\n  <path d=\"M7 15h2a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-2v-3h3\" />"),
    BADGE_8K(
        "badge-8k",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2l0 -10\" />\n  <path d=\"M14 9v6\" />\n  <path d=\"M17 9l-2 3l2 3\" />\n  <path d=\"M15 12h-1\" />\n  <path d=\"M8.5 12h-.5a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1a1 1 0 0 1 1 1v1a1 1 0 0 1 -1 1h-1a1 1 0 0 0 -1 1v1a1 1 0 0 0 1 1h1a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1\" />"),
    BADGE_AD(
        "badge-ad",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M14 9v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M7 15v-4.5a1.5 1.5 0 0 1 3 0v4.5\" />\n  <path d=\"M7 13h3\" />"),
    BADGE_AD_OFF(
        "badge-ad-off",
        "<path d=\"M9 5h10a2 2 0 0 1 2 2v10m-2 2h-14a2 2 0 0 1 -2 -2v-10a2 2 0 0 1 2 -2\" />\n  <path d=\"M14 14v1h1m2 -2v-2a2 2 0 0 0 -2 -2h-1v1\" />\n  <path d=\"M7 15v-4.5a1.5 1.5 0 0 1 2.077 -1.385m.788 .762c.087 .19 .135 .4 .135 .623v4.5\" />\n  <path d=\"M7 13h3\" />\n  <path d=\"M3 3l18 18\" />"),
    BADGE_AR(
        "badge-ar",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 15v-4.5a1.5 1.5 0 0 1 3 0v4.5\" />\n  <path d=\"M7 13h3\" />\n  <path d=\"M14 12h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6m3 0l-2 -3\" />"),
    BADGE_CC(
        "badge-cc",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M10 10.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />\n  <path d=\"M17 10.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />"),
    BADGE_HD(
        "badge-hd",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M14 9v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M7 15v-6\" />\n  <path d=\"M10 15v-6\" />\n  <path d=\"M7 12h3\" />"),
    BADGE_OFF(
        "badge-off",
        "<path d=\"M7 7v10l5 3l5 -3m0 -4v-9l-5 3l-2.496 -1.497\" />\n  <path d=\"M3 3l18 18\" />"),
    BADGE_SD(
        "badge-sd",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M14 9v6h1a2 2 0 0 0 2 -2v-2a2 2 0 0 0 -2 -2h-1\" />\n  <path d=\"M7 14.25c0 .414 .336 .75 .75 .75h1.25a1 1 0 0 0 1 -1v-1a1 1 0 0 0 -1 -1h-1a1 1 0 0 1 -1 -1v-1a1 1 0 0 1 1 -1h1.25a.75 .75 0 0 1 .75 .75\" />"),
    BADGE_TM(
        "badge-tm",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6 9h4\" />\n  <path d=\"M8 9v6\" />\n  <path d=\"M13 15v-6l2 3l2 -3v6\" />"),
    BADGE_VO(
        "badge-vo",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M7 9l2 6l2 -6\" />\n  <path d=\"M15.5 9a1.5 1.5 0 0 1 1.5 1.5v3a1.5 1.5 0 0 1 -3 0v-3a1.5 1.5 0 0 1 1.5 -1.5\" />"),
    BADGE_VR(
        "badge-vr",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M14 12h1.5a1.5 1.5 0 0 0 0 -3h-1.5v6m3 0l-2 -3\" />\n  <path d=\"M7 9l2 6l2 -6\" />"),
    BADGE_WC(
        "badge-wc",
        "<path d=\"M3 7a2 2 0 0 1 2 -2h14a2 2 0 0 1 2 2v10a2 2 0 0 1 -2 2h-14a2 2 0 0 1 -2 -2v-10\" />\n  <path d=\"M6.5 9l.5 6l2 -4l2 4l.5 -6\" />\n  <path d=\"M17 10.5a1.5 1.5 0 0 0 -3 0v3a1.5 1.5 0 0 0 3 0\" />"),
    BADGES(
        "badges",
        "<path d=\"M17 17v-4l-5 3l-5 -3v4l5 3l5 -3\" />\n  <path d=\"M17 8v-4l-5 3l-5 -3v4l5 3l5 -3\" />"),
    BADGES_OFF(
        "badges-off",
        "<path d=\"M14.505 14.497l-2.505 1.503l-5 -3v4l5 3l5 -3\" />\n  <path d=\"M13.873 9.876l3.127 -1.876v-4l-5 3l-2.492 -1.495m-2.508 1.495v1l2.492 1.495\" />\n  <path d=\"M3 3l18 18\" />");

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
    AWARD(
        "award",
        "<path d=\"M19.496 13.983l1.966 3.406a1.001 1.001 0 0 1 -.705 1.488l-.113 .011l-.112 -.001l-2.933 -.19l-1.303 2.636a1.001 1.001 0 0 1 -1.608 .26l-.082 -.094l-.072 -.11l-1.968 -3.407a8.994 8.994 0 0 0 6.93 -3.999z\" />\n  <path d=\"M11.43 17.982l-1.966 3.408a1.001 1.001 0 0 1 -1.622 .157l-.076 -.1l-.064 -.114l-1.304 -2.635l-2.931 .19a1.001 1.001 0 0 1 -1.022 -1.29l.04 -.107l.05 -.1l1.968 -3.409a8.994 8.994 0 0 0 6.927 4.001z\" />\n  <path d=\"M12 2l.24 .004a7 7 0 0 1 6.76 6.996l-.003 .193l-.007 .192l-.018 .245l-.026 .242l-.024 .178a6.985 6.985 0 0 1 -.317 1.268l-.116 .308l-.153 .348a7.001 7.001 0 0 1 -12.688 -.028l-.13 -.297l-.052 -.133l-.08 -.217l-.095 -.294a6.96 6.96 0 0 1 -.093 -.344l-.06 -.271l-.049 -.271l-.02 -.139l-.039 -.323l-.024 -.365l-.006 -.292a7 7 0 0 1 6.76 -6.996l.24 -.004z\" />"),
    BADGE(
        "badge",
        "<path d=\"M16.486 3.143l-4.486 2.69l-4.486 -2.69a1 1 0 0 0 -1.514 .857v13a1 1 0 0 0 .486 .857l5 3a1 1 0 0 0 1.028 0l5 -3a1 1 0 0 0 .486 -.857v-13a1 1 0 0 0 -1.514 -.857z\" />"),
    BADGE_3D(
        "badge-3d",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-10.5 4h-1.5a1 1 0 1 0 0 2h1.5a.5 .5 0 0 1 .09 .992l-.09 .008h-.5c-1.287 0 -1.332 1.864 -.133 1.993l.133 .007h.5a.5 .5 0 1 1 0 1h-1.5a1 1 0 0 0 0 2h1.5a2.5 2.5 0 0 0 2.5 -2.5l-.005 -.164a2.5 2.5 0 0 0 -.477 -1.312l-.019 -.024l.019 -.024a2.5 2.5 0 0 0 -2.018 -3.976m6.5 0h-1a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h1a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3m0 2a1 1 0 0 1 1 1v2a1 1 0 0 1 -.883 .993l-.117 .007z\" />"),
    BADGE_4K(
        "badge-4k",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-9 4a1 1 0 0 0 -1 1v2h-1v-2a1 1 0 1 0 -2 0v2a2 2 0 0 0 2 2h1v2a1 1 0 0 0 2 0v-6a1 1 0 0 0 -1 -1m7.555 .168a1 1 0 0 0 -1.387 .277l-1.168 1.751v-1.196a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v6a1 1 0 0 0 2 0v-1.196l1.168 1.75a1 1 0 0 0 1.286 .337l.1 -.059l.094 -.07a1 1 0 0 0 .184 -1.317l-1.63 -2.445l1.63 -2.445a1 1 0 0 0 -.277 -1.387\" />"),
    BADGE_8K(
        "badge-8k",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-1.445 4.168a1 1 0 0 0 -1.387 .277l-1.168 1.751v-1.196a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v6a1 1 0 0 0 2 0v-1.196l1.168 1.75a1 1 0 0 0 1.286 .337l.1 -.059l.094 -.07a1 1 0 0 0 .184 -1.317l-1.63 -2.445l1.63 -2.445a1 1 0 0 0 -.277 -1.387m-8.555 -.168h-1a2 2 0 0 0 -2 2v1l.005 .15c.022 .295 .108 .573 .245 .819l.019 .031l-.02 .031a2 2 0 0 0 -.249 .969v1a2 2 0 0 0 2 2h1a2 2 0 0 0 2 -2v-1l-.005 -.15a2 2 0 0 0 -.245 -.819l-.019 -.031l.02 -.031c.158 -.287 .249 -.618 .249 -.969v-1a2 2 0 0 0 -2 -2m0 5v1h-1v-1zm0 -3v1h-1v-1z\" />"),
    BADGE_AD(
        "badge-ad",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-4 4h-1a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h1a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3m-6.5 0a2.5 2.5 0 0 0 -2.5 2.5v4.5a1 1 0 0 0 2 0v-1h1v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-4.5a2.5 2.5 0 0 0 -2.5 -2.5m6.5 2a1 1 0 0 1 1 1v2a1 1 0 0 1 -.883 .993l-.117 .007zm-6.5 0a.5 .5 0 0 1 .5 .5v1.5h-1v-1.5a.5 .5 0 0 1 .41 -.492z\" />"),
    BADGE_AR(
        "badge-ar",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-10.5 4a2.5 2.5 0 0 0 -2.5 2.5v4.5a1 1 0 0 0 2 0v-1h1v1a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-4.5a2.5 2.5 0 0 0 -2.5 -2.5m7 0h-1.5a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1.196l1.168 1.75a1 1 0 0 0 1.387 .278l.093 -.07a1 1 0 0 0 .184 -1.317l-1.159 -1.738l.044 -.023a2.5 2.5 0 0 0 -1.217 -4.684m-7 2a.5 .5 0 0 1 .5 .5v1.5h-1v-1.5a.5 .5 0 0 1 .41 -.492zm7 0a.5 .5 0 1 1 0 1h-.5v-1z\" />"),
    BADGE_CC(
        "badge-cc",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-10.5 4a2.5 2.5 0 0 0 -2.5 2.5v3a2.5 2.5 0 1 0 5 0a1 1 0 0 0 -2 0a.5 .5 0 1 1 -1 0v-3a.5 .5 0 1 1 1 0a1 1 0 0 0 2 0a2.5 2.5 0 0 0 -2.5 -2.5m7 0a2.5 2.5 0 0 0 -2.5 2.5v3a2.5 2.5 0 1 0 5 0a1 1 0 0 0 -2 0a.5 .5 0 1 1 -1 0v-3a.5 .5 0 1 1 1 0a1 1 0 0 0 2 0a2.5 2.5 0 0 0 -2.5 -2.5\" />"),
    BADGE_HD(
        "badge-hd",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-4 4h-1a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h1a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3m-5 0a1 1 0 0 0 -1 1v2h-1v-2a1 1 0 0 0 -.883 -.993l-.117 -.007a1 1 0 0 0 -1 1v6a1 1 0 0 0 2 0v-2h1v2a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-6a1 1 0 0 0 -1 -1m5 2a1 1 0 0 1 1 1v2a1 1 0 0 1 -.883 .993l-.117 .007z\" />"),
    BADGE_SD(
        "badge-sd",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-4 4h-1a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1h1a3 3 0 0 0 3 -3v-2a3 3 0 0 0 -3 -3m-5.75 0h-1.25a2 2 0 0 0 -2 2v1a2 2 0 0 0 2 2h1v1h-1.033l-.025 -.087a1 1 0 0 0 -1.942 .337c0 .966 .784 1.75 1.75 1.75h1.25a2 2 0 0 0 2 -2v-1a2 2 0 0 0 -2 -2h-1v-1h1.032l.026 .087a1 1 0 0 0 1.942 -.337a1.75 1.75 0 0 0 -1.75 -1.75m5.75 2a1 1 0 0 1 1 1v2a1 1 0 0 1 -.883 .993l-.117 .007z\" />"),
    BADGE_TM(
        "badge-tm",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-9 4h-4a1 1 0 1 0 0 2h1v5a1 1 0 0 0 .883 .993l.117 .007a1 1 0 0 0 1 -1v-5h1a1 1 0 0 0 .993 -.883l.007 -.117a1 1 0 0 0 -1 -1m8 1c0 -.99 -1.283 -1.378 -1.832 -.555l-1.168 1.752l-1.168 -1.752c-.549 -.823 -1.832 -.434 -1.832 .555v6a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-2.697l.168 .252l.08 .104a1 1 0 0 0 1.584 -.104l.168 -.253v2.698a1 1 0 0 0 2 0z\" />"),
    BADGE_VO(
        "badge-vo",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-3.5 4a2.5 2.5 0 0 0 -2.5 2.5v3a2.5 2.5 0 1 0 5 0v-3a2.5 2.5 0 0 0 -2.5 -2.5m-4.184 .051a1 1 0 0 0 -1.265 .633l-1.051 3.154l-1.051 -3.154a1 1 0 0 0 -1.898 .632l2 6c.304 .912 1.594 .912 1.898 0l2 -6a1 1 0 0 0 -.633 -1.265m4.184 1.949a.5 .5 0 0 1 .5 .5v3a.5 .5 0 1 1 -1 0v-3a.5 .5 0 0 1 .5 -.5\" />"),
    BADGE_VR(
        "badge-vr",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-3.5 4h-1.5a1 1 0 0 0 -1 1v6a1 1 0 0 0 1 1l.117 -.007a1 1 0 0 0 .883 -.993v-1.196l1.168 1.75a1 1 0 0 0 1.387 .278l.093 -.07a1 1 0 0 0 .184 -1.317l-1.159 -1.738l.044 -.023a2.5 2.5 0 0 0 -1.217 -4.684m-4.184 .051a1 1 0 0 0 -1.265 .633l-1.051 3.154l-1.051 -3.154a1 1 0 0 0 -1.898 .632l2 6c.304 .912 1.594 .912 1.898 0l2 -6a1 1 0 0 0 -.633 -1.265m4.184 1.949a.5 .5 0 1 1 0 1h-.5v-1z\" />"),
    BADGE_WC(
        "badge-wc",
        "<path d=\"M19 4a3 3 0 0 1 3 3v10a3 3 0 0 1 -3 3h-14a3 3 0 0 1 -3 -3v-10a3 3 0 0 1 3 -3zm-7.534 4a1 1 0 0 0 -.963 .917l-.204 2.445l-.405 -.81l-.063 -.11a1 1 0 0 0 -1.725 .11l-.406 .81l-.203 -2.445a1 1 0 0 0 -.963 -.917l-.117 .003a1 1 0 0 0 -.914 1.08l.5 6l.016 .117c.175 .91 1.441 1.115 1.875 .247l1.106 -2.211l1.106 2.211c.452 .904 1.807 .643 1.89 -.364l.5 -6a1 1 0 0 0 -.913 -1.08zm4.034 0a2.5 2.5 0 0 0 -2.5 2.5v3a2.5 2.5 0 1 0 5 0a1 1 0 0 0 -2 0a.5 .5 0 1 1 -1 0v-3a.5 .5 0 1 1 1 0a1 1 0 0 0 2 0a2.5 2.5 0 0 0 -2.5 -2.5\" />"),
    BADGES(
        "badges",
        "<path d=\"M16.486 12.143l-4.486 2.69l-4.486 -2.69a1 1 0 0 0 -1.514 .857v4a1 1 0 0 0 .486 .857l5 3a1 1 0 0 0 1.028 0l5 -3a1 1 0 0 0 .486 -.857v-4a1 1 0 0 0 -1.514 -.857z\" />\n  <path d=\"M16.486 3.143l-4.486 2.69l-4.486 -2.69a1 1 0 0 0 -1.514 .857v4a1 1 0 0 0 .486 .857l5 3a1 1 0 0 0 1.028 0l5 -3a1 1 0 0 0 .486 -.857v-4a1 1 0 0 0 -1.514 -.857z\" />");

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

  default TablerIcon award() {
    return TablerIcon.create(TablerBadges.OutlineIcon.AWARD);
  }

  default TablerIcon award_off() {
    return TablerIcon.create(TablerBadges.OutlineIcon.AWARD_OFF);
  }

  default TablerIcon badge() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE);
  }

  default TablerIcon badge_2k() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_2K);
  }

  default TablerIcon badge_3d() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_3D);
  }

  default TablerIcon badge_3k() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_3K);
  }

  default TablerIcon badge_4k() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_4K);
  }

  default TablerIcon badge_5k() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_5K);
  }

  default TablerIcon badge_8k() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_8K);
  }

  default TablerIcon badge_ad() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_AD);
  }

  default TablerIcon badge_ad_off() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_AD_OFF);
  }

  default TablerIcon badge_ar() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_AR);
  }

  default TablerIcon badge_cc() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_CC);
  }

  default TablerIcon badge_hd() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_HD);
  }

  default TablerIcon badge_off() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_OFF);
  }

  default TablerIcon badge_sd() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_SD);
  }

  default TablerIcon badge_tm() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_TM);
  }

  default TablerIcon badge_vo() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_VO);
  }

  default TablerIcon badge_vr() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_VR);
  }

  default TablerIcon badge_wc() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGE_WC);
  }

  default TablerIcon badges() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGES);
  }

  default TablerIcon badges_off() {
    return TablerIcon.create(TablerBadges.OutlineIcon.BADGES_OFF);
  }

  default TablerIcon award_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.AWARD);
  }

  default TablerIcon badge_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE);
  }

  default TablerIcon badge_3d_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_3D);
  }

  default TablerIcon badge_4k_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_4K);
  }

  default TablerIcon badge_8k_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_8K);
  }

  default TablerIcon badge_ad_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_AD);
  }

  default TablerIcon badge_ar_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_AR);
  }

  default TablerIcon badge_cc_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_CC);
  }

  default TablerIcon badge_hd_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_HD);
  }

  default TablerIcon badge_sd_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_SD);
  }

  default TablerIcon badge_tm_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_TM);
  }

  default TablerIcon badge_vo_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_VO);
  }

  default TablerIcon badge_vr_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_VR);
  }

  default TablerIcon badge_wc_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGE_WC);
  }

  default TablerIcon badges_filled() {
    return TablerIcon.create(TablerBadges.FilledIcon.BADGES);
  }
}
