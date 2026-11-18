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
package org.dominokit.domino.ui.icons.lib;

import java.util.ArrayList;
import java.util.List;
import org.dominokit.domino.ui.icons.IconCatalogEntry;
import org.dominokit.domino.ui.icons.TablerCharts;
import org.dominokit.domino.ui.icons.TablerIcon;

/** Static icon factory for the Tabler Charts category. */
public final class TablerCharts_Factory {
  private static final List<IconCatalogEntry<TablerIcon>> icons = new ArrayList<>();
  private static final TablerCharts tagIcons = new TablerCharts() {};

  static {
    addIcons0();
  }

  private static void addIcons0() {
    icons.add(
        new IconCatalogEntry<>(
            "chart-arcs", "TablerIcons.chart_arcs()", tagIcons::chart_arcs));
    icons.add(
        new IconCatalogEntry<>(
            "chart-arcs-3", "TablerIcons.chart_arcs_3()", tagIcons::chart_arcs_3));
    icons.add(
        new IconCatalogEntry<>(
            "chart-area", "TablerIcons.chart_area()", tagIcons::chart_area));
    icons.add(
        new IconCatalogEntry<>(
            "chart-area-line",
            "TablerIcons.chart_area_line()",
            tagIcons::chart_area_line));
    icons.add(
        new IconCatalogEntry<>(
            "chart-arrows", "TablerIcons.chart_arrows()", tagIcons::chart_arrows));
    icons.add(
        new IconCatalogEntry<>(
            "chart-arrows-vertical",
            "TablerIcons.chart_arrows_vertical()",
            tagIcons::chart_arrows_vertical));
    icons.add(
        new IconCatalogEntry<>(
            "chart-bar", "TablerIcons.chart_bar()", tagIcons::chart_bar));
    icons.add(
        new IconCatalogEntry<>(
            "chart-bar-off", "TablerIcons.chart_bar_off()", tagIcons::chart_bar_off));
    icons.add(
        new IconCatalogEntry<>(
            "chart-bar-popular",
            "TablerIcons.chart_bar_popular()",
            tagIcons::chart_bar_popular));
    icons.add(
        new IconCatalogEntry<>(
            "chart-bubble", "TablerIcons.chart_bubble()", tagIcons::chart_bubble));
    icons.add(
        new IconCatalogEntry<>(
            "chart-candle", "TablerIcons.chart_candle()", tagIcons::chart_candle));
    icons.add(
        new IconCatalogEntry<>(
            "chart-circles", "TablerIcons.chart_circles()", tagIcons::chart_circles));
    icons.add(
        new IconCatalogEntry<>(
            "chart-cohort", "TablerIcons.chart_cohort()", tagIcons::chart_cohort));
    icons.add(
        new IconCatalogEntry<>(
            "chart-column", "TablerIcons.chart_column()", tagIcons::chart_column));
    icons.add(
        new IconCatalogEntry<>(
            "chart-covariate",
            "TablerIcons.chart_covariate()",
            tagIcons::chart_covariate));
    icons.add(
        new IconCatalogEntry<>(
            "chart-donut", "TablerIcons.chart_donut()", tagIcons::chart_donut));
    icons.add(
        new IconCatalogEntry<>(
            "chart-donut-2", "TablerIcons.chart_donut_2()", tagIcons::chart_donut_2));
    icons.add(
        new IconCatalogEntry<>(
            "chart-donut-3", "TablerIcons.chart_donut_3()", tagIcons::chart_donut_3));
    icons.add(
        new IconCatalogEntry<>(
            "chart-donut-4", "TablerIcons.chart_donut_4()", tagIcons::chart_donut_4));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots", "TablerIcons.chart_dots()", tagIcons::chart_dots));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots-2", "TablerIcons.chart_dots_2()", tagIcons::chart_dots_2));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots-3", "TablerIcons.chart_dots_3()", tagIcons::chart_dots_3));
    icons.add(
        new IconCatalogEntry<>(
            "chart-funnel", "TablerIcons.chart_funnel()", tagIcons::chart_funnel));
    icons.add(
        new IconCatalogEntry<>(
            "chart-grid-dots",
            "TablerIcons.chart_grid_dots()",
            tagIcons::chart_grid_dots));
    icons.add(
        new IconCatalogEntry<>(
            "chart-histogram",
            "TablerIcons.chart_histogram()",
            tagIcons::chart_histogram));
    icons.add(
        new IconCatalogEntry<>(
            "chart-infographic",
            "TablerIcons.chart_infographic()",
            tagIcons::chart_infographic));
    icons.add(
        new IconCatalogEntry<>(
            "chart-line", "TablerIcons.chart_line()", tagIcons::chart_line));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie", "TablerIcons.chart_pie()", tagIcons::chart_pie));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-2", "TablerIcons.chart_pie_2()", tagIcons::chart_pie_2));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-3", "TablerIcons.chart_pie_3()", tagIcons::chart_pie_3));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-4", "TablerIcons.chart_pie_4()", tagIcons::chart_pie_4));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-off", "TablerIcons.chart_pie_off()", tagIcons::chart_pie_off));
    icons.add(
        new IconCatalogEntry<>(
            "chart-ppf", "TablerIcons.chart_ppf()", tagIcons::chart_ppf));
    icons.add(
        new IconCatalogEntry<>(
            "chart-radar", "TablerIcons.chart_radar()", tagIcons::chart_radar));
    icons.add(
        new IconCatalogEntry<>(
            "chart-sankey", "TablerIcons.chart_sankey()", tagIcons::chart_sankey));
    icons.add(
        new IconCatalogEntry<>(
            "chart-scatter", "TablerIcons.chart_scatter()", tagIcons::chart_scatter));
    icons.add(
        new IconCatalogEntry<>(
            "chart-scatter-3d",
            "TablerIcons.chart_scatter_3d()",
            tagIcons::chart_scatter_3d));
    icons.add(
        new IconCatalogEntry<>(
            "chart-treemap", "TablerIcons.chart_treemap()", tagIcons::chart_treemap));
    icons.add(
        new IconCatalogEntry<>(
            "trending-up-down",
            "TablerIcons.trending_up_down()",
            tagIcons::trending_up_down));
    icons.add(
        new IconCatalogEntry<>(
            "chart-area", "TablerIcons.chart_area_filled()", tagIcons::chart_area_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-area-line",
            "TablerIcons.chart_area_line_filled()",
            tagIcons::chart_area_line_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-bubble",
            "TablerIcons.chart_bubble_filled()",
            tagIcons::chart_bubble_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-candle",
            "TablerIcons.chart_candle_filled()",
            tagIcons::chart_candle_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-donut",
            "TablerIcons.chart_donut_filled()",
            tagIcons::chart_donut_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots", "TablerIcons.chart_dots_filled()", tagIcons::chart_dots_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots-2",
            "TablerIcons.chart_dots_2_filled()",
            tagIcons::chart_dots_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-dots-3",
            "TablerIcons.chart_dots_3_filled()",
            tagIcons::chart_dots_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-funnel",
            "TablerIcons.chart_funnel_filled()",
            tagIcons::chart_funnel_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-grid-dots",
            "TablerIcons.chart_grid_dots_filled()",
            tagIcons::chart_grid_dots_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie", "TablerIcons.chart_pie_filled()", tagIcons::chart_pie_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-2",
            "TablerIcons.chart_pie_2_filled()",
            tagIcons::chart_pie_2_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-3",
            "TablerIcons.chart_pie_3_filled()",
            tagIcons::chart_pie_3_filled));
    icons.add(
        new IconCatalogEntry<>(
            "chart-pie-4",
            "TablerIcons.chart_pie_4_filled()",
            tagIcons::chart_pie_4_filled));
  }

  public List<IconCatalogEntry<TablerIcon>> icons() {
    return new ArrayList<>(icons);
  }
}
