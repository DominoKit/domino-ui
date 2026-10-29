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

/** Tabler Charts catalog category. */
public interface TablerCharts {
  enum OutlineIcon implements TablerIconDefinition {
    CHART_ARCS(
        "chart-arcs",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M16.924 11.132a5 5 0 1 0 -4.056 5.792\" />\n  <path d=\"M3 12a9 9 0 1 0 9 -9\" />"),
    CHART_ARCS_3(
        "chart-arcs-3",
        "<path d=\"M11 12a1 1 0 1 0 2 0a1 1 0 1 0 -2 0\" />\n  <path d=\"M7 12a5 5 0 1 0 5 -5\" />\n  <path d=\"M6.29 18.957a9 9 0 1 0 5.71 -15.957\" />"),
    CHART_AREA(
        "chart-area",
        "<path d=\"M4 19l16 0\" />\n  <path d=\"M4 15l4 -6l4 2l4 -5l4 4l0 5l-16 0\" />"),
    CHART_AREA_LINE(
        "chart-area-line",
        "<path d=\"M4 19l4 -6l4 2l4 -5l4 4l0 5l-16 0\" />\n  <path d=\"M4 12l3 -4l4 2l5 -6l4 4\" />"),
    CHART_ARROWS(
        "chart-arrows",
        "<path d=\"M3 18l14 0\" />\n  <path d=\"M9 9l3 3l-3 3\" />\n  <path d=\"M14 15l3 3l-3 3\" />\n  <path d=\"M3 3l0 18\" />\n  <path d=\"M3 12l9 0\" />\n  <path d=\"M18 3l3 3l-3 3\" />\n  <path d=\"M3 6l18 0\" />"),
    CHART_ARROWS_VERTICAL(
        "chart-arrows-vertical",
        "<path d=\"M18 21v-14\" />\n  <path d=\"M9 15l3 -3l3 3\" />\n  <path d=\"M15 10l3 -3l3 3\" />\n  <path d=\"M3 21l18 0\" />\n  <path d=\"M12 21l0 -9\" />\n  <path d=\"M3 6l3 -3l3 3\" />\n  <path d=\"M6 21v-18\" />"),
    CHART_BAR(
        "chart-bar",
        "<path d=\"M3 13a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M15 9a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -10\" />\n  <path d=\"M9 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M4 20h14\" />"),
    CHART_BAR_OFF(
        "chart-bar-off",
        "<path d=\"M3 13a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M12 8h2a1 1 0 0 1 1 1v2m0 4v4a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1v-10\" />\n  <path d=\"M15 11v-6a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v12m-1 3h-4a1 1 0 0 1 -1 -1v-4\" />\n  <path d=\"M4 20h14\" />\n  <path d=\"M3 3l18 18\" />"),
    CHART_BAR_POPULAR(
        "chart-bar-popular",
        "<path d=\"M3 13a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v6a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -6\" />\n  <path d=\"M9 9a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v10a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -10\" />\n  <path d=\"M15 5a1 1 0 0 1 1 -1h4a1 1 0 0 1 1 1v14a1 1 0 0 1 -1 1h-4a1 1 0 0 1 -1 -1l0 -14\" />\n  <path d=\"M4 20h14\" />"),
    CHART_BUBBLE(
        "chart-bubble",
        "<path d=\"M3 16a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M14 19a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10 7.5a4.5 4.5 0 1 0 9 0a4.5 4.5 0 1 0 -9 0\" />"),
    CHART_CANDLE(
        "chart-candle",
        "<path d=\"M4 7a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M6 4l0 2\" />\n  <path d=\"M6 11l0 9\" />\n  <path d=\"M10 15a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v3a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -3\" />\n  <path d=\"M12 4l0 10\" />\n  <path d=\"M12 19l0 1\" />\n  <path d=\"M16 6a1 1 0 0 1 1 -1h2a1 1 0 0 1 1 1v4a1 1 0 0 1 -1 1h-2a1 1 0 0 1 -1 -1l0 -4\" />\n  <path d=\"M18 4l0 1\" />\n  <path d=\"M18 11l0 9\" />"),
    CHART_CIRCLES(
        "chart-circles",
        "<path d=\"M4 9.5a5.5 5.5 0 1 0 11 0a5.5 5.5 0 1 0 -11 0\" />\n  <path d=\"M9 14.5a5.5 5.5 0 1 0 11 0a5.5 5.5 0 1 0 -11 0\" />"),
    CHART_COHORT(
        "chart-cohort", "<path d=\"M3 9h18v-6h-18v18h6v-18\" />\n  <path d=\"M3 15h12v-12\" />"),
    CHART_COLUMN(
        "chart-column",
        "<path d=\"M4 20h3\" />\n  <path d=\"M17 20h3\" />\n  <path d=\"M10.5 20h3\" />\n  <path d=\"M4 16h3\" />\n  <path d=\"M17 16h3\" />\n  <path d=\"M10.5 16h3\" />\n  <path d=\"M4 12h3\" />\n  <path d=\"M17 12h3\" />\n  <path d=\"M10.5 12h3\" />\n  <path d=\"M4 8h3\" />\n  <path d=\"M17 8h3\" />\n  <path d=\"M4 4h3\" />"),
    CHART_COVARIATE(
        "chart-covariate",
        "<path d=\"M18 11h.009\" />\n  <path d=\"M14 15h.009\" />\n  <path d=\"M12 6h.009\" />\n  <path d=\"M8 10h.009\" />\n  <path d=\"M3 21l17 -17\" />\n  <path d=\"M3 3v18h18\" />"),
    CHART_DONUT(
        "chart-donut",
        "<path d=\"M10 3.2a9 9 0 1 0 10.8 10.8a1 1 0 0 0 -1 -1h-3.8a4.1 4.1 0 1 1 -5 -5v-4a.9 .9 0 0 0 -1 -.8\" />\n  <path d=\"M15 3.5a9 9 0 0 1 5.5 5.5h-4.5a9 9 0 0 0 -1 -1v-4.5\" />"),
    CHART_DONUT_2(
        "chart-donut-2",
        "<path d=\"M12 3v5m4 4h5\" />\n  <path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CHART_DONUT_3(
        "chart-donut-3",
        "<path d=\"M12 3v5m4 4h5\" />\n  <path d=\"M8.929 14.582l-3.429 2.918\" />\n  <path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CHART_DONUT_4(
        "chart-donut-4",
        "<path d=\"M8.848 14.667l-3.348 2.833\" />\n  <path d=\"M12 3v5m4 4h5\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M14.219 15.328l2.781 4.172\" />\n  <path d=\"M8 12a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />"),
    CHART_DOTS(
        "chart-dots",
        "<path d=\"M3 3v18h18\" />\n  <path d=\"M7 9a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M17 7a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M12 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M10.16 10.62l2.34 2.88\" />\n  <path d=\"M15.088 13.328l2.837 -4.586\" />"),
    CHART_DOTS_2(
        "chart-dots-2",
        "<path d=\"M3 3v18h18\" />\n  <path d=\"M7 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M11 5a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M21 3l-6 1.5\" />\n  <path d=\"M14.113 6.65l2.771 3.695\" />\n  <path d=\"M16 12.5l-5 2\" />"),
    CHART_DOTS_3(
        "chart-dots-3",
        "<path d=\"M3 7a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M14 15a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M15 6a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M3 18a3 3 0 1 0 6 0a3 3 0 1 0 -6 0\" />\n  <path d=\"M9 17l5 -1.5\" />\n  <path d=\"M6.5 8.5l7.81 5.37\" />\n  <path d=\"M7 7l8 -1\" />"),
    CHART_FUNNEL(
        "chart-funnel",
        "<path d=\"M4.387 3h15.226a1 1 0 0 1 .948 1.316l-5.105 15.316a2 2 0 0 1 -1.898 1.368h-3.116a2 2 0 0 1 -1.898 -1.368l-5.104 -15.316a1 1 0 0 1 .947 -1.316\" />\n  <path d=\"M5 9h14\" />\n  <path d=\"M7 15h10\" />"),
    CHART_GRID_DOTS(
        "chart-grid-dots",
        "<path d=\"M16 6a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 12a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M4 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M16 18a2 2 0 1 0 4 0a2 2 0 1 0 -4 0\" />\n  <path d=\"M8 18h8\" />\n  <path d=\"M18 20v1\" />\n  <path d=\"M18 3v1\" />\n  <path d=\"M6 20v1\" />\n  <path d=\"M6 10v-7\" />\n  <path d=\"M12 3v18\" />\n  <path d=\"M18 8v8\" />\n  <path d=\"M8 12h13\" />\n  <path d=\"M21 6h-1\" />\n  <path d=\"M16 6h-13\" />\n  <path d=\"M3 12h1\" />\n  <path d=\"M20 18h1\" />\n  <path d=\"M3 18h1\" />\n  <path d=\"M6 14v2\" />"),
    CHART_HISTOGRAM(
        "chart-histogram",
        "<path d=\"M3 3v18h18\" />\n  <path d=\"M20 18v3\" />\n  <path d=\"M16 16v5\" />\n  <path d=\"M12 13v8\" />\n  <path d=\"M8 16v5\" />\n  <path d=\"M3 11c6 0 5 -5 9 -5s3 5 9 5\" />"),
    CHART_INFOGRAPHIC(
        "chart-infographic",
        "<path d=\"M3 7a4 4 0 1 0 8 0a4 4 0 1 0 -8 0\" />\n  <path d=\"M7 3v4h4\" />\n  <path d=\"M9 17l0 4\" />\n  <path d=\"M17 14l0 7\" />\n  <path d=\"M13 13l0 8\" />\n  <path d=\"M21 12l0 9\" />"),
    CHART_LINE("chart-line", "<path d=\"M4 19l16 0\" />\n  <path d=\"M4 15l4 -6l4 2l4 -5l4 4\" />"),
    CHART_PIE(
        "chart-pie",
        "<path d=\"M10 3.2a9 9 0 1 0 10.8 10.8a1 1 0 0 0 -1 -1h-6.8a2 2 0 0 1 -2 -2v-7a.9 .9 0 0 0 -1 -.8\" />\n  <path d=\"M15 3.5a9 9 0 0 1 5.5 5.5h-4.5a1 1 0 0 1 -1 -1v-4.5\" />"),
    CHART_PIE_2(
        "chart-pie-2",
        "<path d=\"M12 3v9h9\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CHART_PIE_3(
        "chart-pie-3",
        "<path d=\"M12 12l-6.5 5.5\" />\n  <path d=\"M12 3v9h9\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />"),
    CHART_PIE_4(
        "chart-pie-4",
        "<path d=\"M12 12l-6.5 5.5\" />\n  <path d=\"M12 3v9h9\" />\n  <path d=\"M3 12a9 9 0 1 0 18 0a9 9 0 1 0 -18 0\" />\n  <path d=\"M12 12l5 7.5\" />"),
    CHART_PIE_OFF(
        "chart-pie-off",
        "<path d=\"M5.63 5.643a9 9 0 0 0 12.742 12.715m1.674 -2.29a9.03 9.03 0 0 0 .754 -2.068a1 1 0 0 0 -1 -1h-2.8m-4 0a2 2 0 0 1 -2 -2m0 -4v-3a.9 .9 0 0 0 -1 -.8a9 9 0 0 0 -2.057 .749\" />\n  <path d=\"M15 3.5a9 9 0 0 1 5.5 5.5h-4.5a1 1 0 0 1 -1 -1v-4.5\" />\n  <path d=\"M3 3l18 18\" />"),
    CHART_PPF(
        "chart-ppf",
        "<path d=\"M19 17c0 -6.075 -5.373 -11 -12 -11\" />\n  <path d=\"M3 3v18h18\" />"),
    CHART_RADAR(
        "chart-radar",
        "<path d=\"M12 3l9.5 7l-3.5 11h-12l-3.5 -11l9.5 -7\" />\n  <path d=\"M12 7.5l5.5 4l-2.5 5.5h-6.5l-2 -5.5l5.5 -4\" />\n  <path d=\"M2.5 10l9.5 3l9.5 -3\" />\n  <path d=\"M12 3v10l6 8\" />\n  <path d=\"M6 21l6 -8\" />"),
    CHART_SANKEY(
        "chart-sankey",
        "<path d=\"M4 6c6.944 0 9.056 8 16 8\" />\n  <path d=\"M4 12c6.37 0 9.63 6 16 6\" />\n  <path d=\"M20 6c-7.526 0 -7.905 12 -16 12\" />"),
    CHART_SCATTER(
        "chart-scatter",
        "<path d=\"M3 3v18h18\" />\n  <path d=\"M8 15.015v.015\" />\n  <path d=\"M16 16.015v.015\" />\n  <path d=\"M8 7.03v.015\" />\n  <path d=\"M12 11.03v.015\" />\n  <path d=\"M19 11.03v.015\" />"),
    CHART_SCATTER_3D(
        "chart-scatter-3d",
        "<path d=\"M3 20l9 -7\" />\n  <path d=\"M12 3v10l9 7\" />\n  <path d=\"M17 12v.015\" />\n  <path d=\"M17 4.015v.015\" />\n  <path d=\"M21 8.015v.015\" />\n  <path d=\"M12 19.015v.015\" />\n  <path d=\"M3 12.015v.015\" />\n  <path d=\"M7 8.015v.015\" />\n  <path d=\"M3 4.015v.015\" />"),
    CHART_TREEMAP(
        "chart-treemap",
        "<path d=\"M4 6a2 2 0 0 1 2 -2h12a2 2 0 0 1 2 2v12a2 2 0 0 1 -2 2h-12a2 2 0 0 1 -2 -2l0 -12\" />\n  <path d=\"M12 4v16\" />\n  <path d=\"M4 15h8\" />\n  <path d=\"M12 12h8\" />\n  <path d=\"M16 12v8\" />\n  <path d=\"M16 16h4\" />"),
    TRENDING_UP_DOWN(
        "trending-up-down",
        "<path d=\"M2 14l6 -6l4 4l9 -9\" />\n  <path d=\"M15 3h6v6\" />\n  <path d=\"M15 21h6v-6\" />\n  <path d=\"M21 21l-6 -6\" />");

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
    CHART_AREA(
        "chart-area",
        "<path d=\"M20 18a1 1 0 0 1 .117 1.993l-.117 .007h-16a1 1 0 0 1 -.117 -1.993l.117 -.007h16z\" />\n  <path d=\"M15.22 5.375a1 1 0 0 1 1.393 -.165l.094 .083l4 4a1 1 0 0 1 .284 .576l.009 .131v5a1 1 0 0 1 -.883 .993l-.117 .007h-16.022l-.11 -.009l-.11 -.02l-.107 -.034l-.105 -.046l-.1 -.059l-.094 -.07l-.06 -.055l-.072 -.082l-.064 -.089l-.054 -.096l-.016 -.035l-.04 -.103l-.027 -.106l-.015 -.108l-.004 -.11l.009 -.11l.019 -.105c.01 -.04 .022 -.077 .035 -.112l.046 -.105l.059 -.1l4 -6a1 1 0 0 1 1.165 -.39l.114 .05l3.277 1.638l3.495 -4.369z\" />"),
    CHART_AREA_LINE(
        "chart-area-line",
        "<path d=\"M15.22 9.375a1 1 0 0 1 1.393 -.165l.094 .083l4 4a1 1 0 0 1 .284 .576l.009 .131v5a1 1 0 0 1 -.883 .993l-.117 .007h-16.022l-.11 -.009l-.11 -.02l-.107 -.034l-.105 -.046l-.1 -.059l-.094 -.07l-.06 -.055l-.072 -.082l-.064 -.089l-.054 -.096l-.016 -.035l-.04 -.103l-.027 -.106l-.015 -.108l-.004 -.11l.009 -.11l.019 -.105c.01 -.04 .022 -.077 .035 -.112l.046 -.105l.059 -.1l4 -6a1 1 0 0 1 1.165 -.39l.114 .05l3.277 1.638l3.495 -4.369z\" />\n  <path d=\"M15.232 3.36a1 1 0 0 1 1.382 -.15l.093 .083l4 4a1 1 0 0 1 -1.32 1.497l-.094 -.083l-3.226 -3.225l-4.299 5.158a1 1 0 0 1 -1.1 .303l-.115 -.049l-3.254 -1.626l-2.499 3.332a1 1 0 0 1 -1.295 .269l-.105 -.069a1 1 0 0 1 -.269 -1.295l.069 -.105l3 -4a1 1 0 0 1 1.137 -.341l.11 .047l3.291 1.645l4.494 -5.391z\" />"),
    CHART_BUBBLE(
        "chart-bubble",
        "<path d=\"M6 12a4 4 0 1 1 -3.995 4.2l-.005 -.2l.005 -.2a4 4 0 0 1 3.995 -3.8z\" />\n  <path d=\"M16 16a3 3 0 1 1 -2.995 3.176l-.005 -.176l.005 -.176a3 3 0 0 1 2.995 -2.824z\" />\n  <path d=\"M14.5 2a5.5 5.5 0 1 1 -5.496 5.721l-.004 -.221l.004 -.221a5.5 5.5 0 0 1 5.496 -5.279z\" />"),
    CHART_CANDLE(
        "chart-candle",
        "<path d=\"M6 3a1 1 0 0 1 .993 .883l.007 .117v1a2 2 0 0 1 1.995 1.85l.005 .15v3a2 2 0 0 1 -1.85 1.995l-.15 .005v8a1 1 0 0 1 -1.993 .117l-.007 -.117v-8a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-3a2 2 0 0 1 1.85 -1.995l.15 -.005v-1a1 1 0 0 1 1 -1z\" />\n  <path d=\"M12 3a1 1 0 0 1 .993 .883l.007 .117v9a2 2 0 0 1 1.995 1.85l.005 .15v3a2 2 0 0 1 -1.85 1.995l-.15 .005a1 1 0 0 1 -1.993 .117l-.007 -.117l-.15 -.005a2 2 0 0 1 -1.844 -1.838l-.006 -.157v-3a2 2 0 0 1 1.85 -1.995l.15 -.005v-9a1 1 0 0 1 1 -1z\" />\n  <path d=\"M18 3a1 1 0 0 1 .993 .883l.007 .117a2 2 0 0 1 1.995 1.85l.005 .15v4a2 2 0 0 1 -1.85 1.995l-.15 .005v8a1 1 0 0 1 -1.993 .117l-.007 -.117v-8a2 2 0 0 1 -1.995 -1.85l-.005 -.15v-4a2 2 0 0 1 1.85 -1.995l.15 -.005a1 1 0 0 1 1 -1z\" />"),
    CHART_DONUT(
        "chart-donut",
        "<path d=\"M11.292 2.61c.396 .318 .65 .78 .703 1.286l.005 .104v4a1 1 0 0 1 -.748 .968a3.1 3.1 0 1 0 3.78 3.78a1 1 0 0 1 .968 -.748h3.8a2 2 0 0 1 2 2a1 1 0 0 1 -.026 .226a10 10 0 1 1 -12 -12l.057 -.01l.052 -.01a1.9 1.9 0 0 1 1.409 .404m3.703 -.11l.045 .002l.067 .004l.081 .014l.032 .004l.072 .022l.04 .01a10 10 0 0 1 6.003 5.818l.108 .294a1 1 0 0 1 -.943 1.332h-4.5a1 1 0 0 1 -.76 -.35a8 8 0 0 0 -.89 -.89a1 1 0 0 1 -.35 -.76v-4.5q .001 -.119 .026 -.23l.03 -.102a1 1 0 0 1 .168 -.299l.03 -.033l.039 -.043a1 1 0 0 1 .089 -.08l.051 -.034l.03 -.023l.045 -.025l.052 -.03a1 1 0 0 1 .435 -.101\" />"),
    CHART_DOTS(
        "chart-dots",
        "<path d=\"M3 2a1 1 0 0 1 1 1v17h17a1 1 0 0 1 .993 .883l.007 .117a1 1 0 0 1 -1 1h-18a1 1 0 0 1 -1 -1v-18a1 1 0 0 1 1 -1z\" />\n  <path d=\"M19 4a3 3 0 1 1 -.651 5.93l-2.002 3.202a3 3 0 1 1 -4.927 .337l-1.378 -1.655a3 3 0 1 1 1.538 -1.282l1.378 1.654a2.994 2.994 0 0 1 1.693 -.115l2.002 -3.203a3 3 0 0 1 2.347 -4.868z\" />"),
    CHART_DOTS_2(
        "chart-dots-2",
        "<path d=\"M3 2a1 1 0 0 1 1 1v17h17a1 1 0 0 1 .993 .883l.007 .117a1 1 0 0 1 -1 1h-18a1 1 0 0 1 -1 -1v-18a1 1 0 0 1 1 -1m18.97 .757a1 1 0 0 1 -.727 1.213l-5.256 1.314a3 3 0 0 1 -.55 1.465l1.768 2.358a3.003 3.003 0 0 1 3.795 2.893a3 3 0 0 1 -5.436 1.751l-3.57 1.428a3 3 0 0 1 -5.994 -.179l.005 -.176a3 3 0 0 1 5.43 -1.576l3.57 -1.428l.015 -.17c.06 -.518 .253 -.996 .542 -1.4l-1.767 -2.357a3.003 3.003 0 0 1 -3.795 -2.893l.005 -.176a3 3 0 0 1 5.497 -1.48l5.255 -1.314a1 1 0 0 1 1.213 .727\" />"),
    CHART_DOTS_3(
        "chart-dots-3",
        "<path d=\"M18 2a4 4 0 1 1 -3.843 5.114l-6.295 .786a3 3 0 0 1 -.094 .257l6.446 4.431a3 3 0 1 1 -.695 4.099l-3.527 1.058q .008 .127 .008 .255a4 4 0 1 1 -8 0l.005 -.2a4 4 0 0 1 7.366 -1.954l3.64 -1.094l.01 -.102q .023 -.204 .074 -.4l-6.688 -4.6a3 3 0 0 1 -4.407 -2.65l.005 -.176a3 3 0 0 1 5.784 -.931l6.312 -.79a4 4 0 0 1 3.899 -3.103\" />"),
    CHART_FUNNEL(
        "chart-funnel",
        "<path d=\"M17.72 16l-1.315 3.948a3 3 0 0 1 -2.847 2.052h-3.116a3 3 0 0 1 -2.847 -2.052l-1.315 -3.948zm2 -6l-1.333 4h-12.774l-1.333 -4zm-.106 -8a2 2 0 0 1 1.896 2.632l-1.123 3.368h-16.774l-1.123 -3.368a2 2 0 0 1 1.72 -2.624l.177 -.008z\" />"),
    CHART_GRID_DOTS(
        "chart-grid-dots",
        "<path d=\"M18 2a1 1 0 0 1 1 1v.171a3.008 3.008 0 0 1 1.83 1.83l.17 -.001a1 1 0 0 1 0 2h-.171a3.008 3.008 0 0 1 -1.828 1.829l-.001 2.171h2a1 1 0 0 1 0 2h-2v2.171a3.008 3.008 0 0 1 1.83 1.83l.17 -.001a1 1 0 0 1 0 2h-.171a3.008 3.008 0 0 1 -1.828 1.829l-.001 .171a1 1 0 0 1 -2 0v-.17a3.008 3.008 0 0 1 -1.829 -1.83h-2.171v2a1 1 0 0 1 -2 0v-2h-2.171a3.008 3.008 0 0 1 -1.828 1.829l-.001 .171a1 1 0 0 1 -2 0v-.17a3.008 3.008 0 0 1 -1.829 -1.83h-.171a1 1 0 0 1 0 -2h.17a3.008 3.008 0 0 1 1.83 -1.83v-.34a3.008 3.008 0 0 1 -1.829 -1.83h-.171a1 1 0 0 1 0 -2h.17a3.008 3.008 0 0 1 1.83 -1.83v-2.17h-2a1 1 0 1 1 0 -2h2v-2a1 1 0 1 1 2 0v2h4v-2a1 1 0 0 1 2 0v2h2.17a3.008 3.008 0 0 1 1.83 -1.83v-.17a1 1 0 0 1 1 -1zm-7 11h-2.171a3.008 3.008 0 0 1 -1.828 1.829v.342a3.008 3.008 0 0 1 1.828 1.829h2.171v-4zm6 0h-4v4h2.17a3.008 3.008 0 0 1 1.83 -1.83v-2.17zm-6 -6h-4v2.171a3.008 3.008 0 0 1 1.83 1.83l2.17 -.001v-4zm4.171 0h-2.171v4h4v-2.17a3.008 3.008 0 0 1 -1.829 -1.83z\" />"),
    CHART_PIE(
        "chart-pie",
        "<path d=\"M9.883 2.207a1.9 1.9 0 0 1 2.087 1.522l.025 .167l.005 .104v7a1 1 0 0 0 .883 .993l.117 .007h6.8a2 2 0 0 1 2 2a1 1 0 0 1 -.026 .226a10 10 0 1 1 -12.27 -11.933l.27 -.067l.11 -.02z\" />\n  <path d=\"M14 3.5v5.5a1 1 0 0 0 1 1h5.5a1 1 0 0 0 .943 -1.332a10 10 0 0 0 -6.11 -6.111a1 1 0 0 0 -1.333 .943z\" />"),
    CHART_PIE_2(
        "chart-pie-2",
        "<path d=\"M11 2.05v9.95a1 1 0 0 0 1 1h9.95a10 10 0 0 1 -19.95 -1l.005 -.324a10 10 0 0 1 8.995 -9.626m6 1.29a10 10 0 0 1 4.95 7.66h-8.95v-8.95a10 10 0 0 1 4 1.29\" />"),
    CHART_PIE_3(
        "chart-pie-3",
        "<path d=\"M17 20.66a10 10 0 0 1 -11.328 -.917l6.742 -6.743h9.536a10 10 0 0 1 -4.95 7.66m-6 -18.61v9.534l-6.743 6.744a10 10 0 0 1 -2.257 -6.328l.005 -.324a10 10 0 0 1 8.995 -9.626m6 1.29a10 10 0 0 1 4.95 7.66h-8.95v-8.95a10 10 0 0 1 4 1.29\" />"),
    CHART_PIE_4(
        "chart-pie-4",
        "<path d=\"M11.844 13.57l4.843 7.264a10 10 0 0 1 -11.015 -1.09zm6.507 6.154l-4.481 -6.724h8.081a10 10 0 0 1 -3.348 6.511zm-7.35 -17.674v9.534l-6.744 6.744a10 10 0 0 1 -2.257 -6.328l.005 -.324a10 10 0 0 1 8.995 -9.626m6 1.29a10 10 0 0 1 4.95 7.66h-8.95v-8.95a10 10 0 0 1 4 1.29\" />");

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

  default TablerIcon chart_arcs() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_ARCS);
  }

  default TablerIcon chart_arcs_3() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_ARCS_3);
  }

  default TablerIcon chart_area() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_AREA);
  }

  default TablerIcon chart_area_line() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_AREA_LINE);
  }

  default TablerIcon chart_arrows() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_ARROWS);
  }

  default TablerIcon chart_arrows_vertical() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_ARROWS_VERTICAL);
  }

  default TablerIcon chart_bar() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_BAR);
  }

  default TablerIcon chart_bar_off() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_BAR_OFF);
  }

  default TablerIcon chart_bar_popular() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_BAR_POPULAR);
  }

  default TablerIcon chart_bubble() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_BUBBLE);
  }

  default TablerIcon chart_candle() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_CANDLE);
  }

  default TablerIcon chart_circles() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_CIRCLES);
  }

  default TablerIcon chart_cohort() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_COHORT);
  }

  default TablerIcon chart_column() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_COLUMN);
  }

  default TablerIcon chart_covariate() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_COVARIATE);
  }

  default TablerIcon chart_donut() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DONUT);
  }

  default TablerIcon chart_donut_2() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DONUT_2);
  }

  default TablerIcon chart_donut_3() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DONUT_3);
  }

  default TablerIcon chart_donut_4() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DONUT_4);
  }

  default TablerIcon chart_dots() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DOTS);
  }

  default TablerIcon chart_dots_2() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DOTS_2);
  }

  default TablerIcon chart_dots_3() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_DOTS_3);
  }

  default TablerIcon chart_funnel() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_FUNNEL);
  }

  default TablerIcon chart_grid_dots() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_GRID_DOTS);
  }

  default TablerIcon chart_histogram() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_HISTOGRAM);
  }

  default TablerIcon chart_infographic() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_INFOGRAPHIC);
  }

  default TablerIcon chart_line() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_LINE);
  }

  default TablerIcon chart_pie() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PIE);
  }

  default TablerIcon chart_pie_2() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PIE_2);
  }

  default TablerIcon chart_pie_3() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PIE_3);
  }

  default TablerIcon chart_pie_4() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PIE_4);
  }

  default TablerIcon chart_pie_off() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PIE_OFF);
  }

  default TablerIcon chart_ppf() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_PPF);
  }

  default TablerIcon chart_radar() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_RADAR);
  }

  default TablerIcon chart_sankey() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_SANKEY);
  }

  default TablerIcon chart_scatter() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_SCATTER);
  }

  default TablerIcon chart_scatter_3d() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_SCATTER_3D);
  }

  default TablerIcon chart_treemap() {
    return TablerIcon.create(TablerCharts.OutlineIcon.CHART_TREEMAP);
  }

  default TablerIcon trending_up_down() {
    return TablerIcon.create(TablerCharts.OutlineIcon.TRENDING_UP_DOWN);
  }

  default TablerIcon chart_area_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_AREA);
  }

  default TablerIcon chart_area_line_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_AREA_LINE);
  }

  default TablerIcon chart_bubble_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_BUBBLE);
  }

  default TablerIcon chart_candle_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_CANDLE);
  }

  default TablerIcon chart_donut_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_DONUT);
  }

  default TablerIcon chart_dots_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_DOTS);
  }

  default TablerIcon chart_dots_2_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_DOTS_2);
  }

  default TablerIcon chart_dots_3_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_DOTS_3);
  }

  default TablerIcon chart_funnel_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_FUNNEL);
  }

  default TablerIcon chart_grid_dots_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_GRID_DOTS);
  }

  default TablerIcon chart_pie_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_PIE);
  }

  default TablerIcon chart_pie_2_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_PIE_2);
  }

  default TablerIcon chart_pie_3_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_PIE_3);
  }

  default TablerIcon chart_pie_4_filled() {
    return TablerIcon.create(TablerCharts.FilledIcon.CHART_PIE_4);
  }
}
