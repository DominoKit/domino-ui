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

/** Lucide charts catalog category. */
public interface LucideCharts {
  enum Icon implements LucideIconDefinition {
    CHART_AREA(
        "chart-area",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 11.207a.5.5 0 0 1 .146-.353l2-2a.5.5 0 0 1 .708 0l3.292 3.292a.5.5 0 0 0 .708 0l4.292-4.292a.5.5 0 0 1 .854.353V16a1 1 0 0 1-1 1H8a1 1 0 0 1-1-1z\" />"),
    CHART_BAR(
        "chart-bar",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 16h8\" />\n  <path d=\"M7 11h12\" />\n  <path d=\"M7 6h3\" />"),
    CHART_BAR_BIG(
        "chart-bar-big",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <rect x=\"7\" y=\"13\" width=\"9\" height=\"4\" rx=\"1\" />\n  <rect x=\"7\" y=\"5\" width=\"12\" height=\"4\" rx=\"1\" />"),
    CHART_BAR_DECREASING(
        "chart-bar-decreasing",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 11h8\" />\n  <path d=\"M7 16h3\" />\n  <path d=\"M7 6h12\" />"),
    CHART_BAR_INCREASING(
        "chart-bar-increasing",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 11h8\" />\n  <path d=\"M7 16h12\" />\n  <path d=\"M7 6h3\" />"),
    CHART_BAR_STACKED(
        "chart-bar-stacked",
        "<path d=\"M11 13v4\" />\n  <path d=\"M15 5v4\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <rect x=\"7\" y=\"13\" width=\"9\" height=\"4\" rx=\"1\" />\n  <rect x=\"7\" y=\"5\" width=\"12\" height=\"4\" rx=\"1\" />"),
    CHART_CANDLESTICK(
        "chart-candlestick",
        "<path d=\"M9 5v4\" />\n  <rect width=\"4\" height=\"6\" x=\"7\" y=\"9\" rx=\"1\" />\n  <path d=\"M9 15v2\" />\n  <path d=\"M17 3v2\" />\n  <rect width=\"4\" height=\"8\" x=\"15\" y=\"5\" rx=\"1\" />\n  <path d=\"M17 13v3\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />"),
    CHART_COLUMN(
        "chart-column",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M18 17V9\" />\n  <path d=\"M13 17V5\" />\n  <path d=\"M8 17v-3\" />"),
    CHART_COLUMN_BIG(
        "chart-column-big",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <rect x=\"15\" y=\"5\" width=\"4\" height=\"12\" rx=\"1\" />\n  <rect x=\"7\" y=\"8\" width=\"4\" height=\"9\" rx=\"1\" />"),
    CHART_COLUMN_DECREASING(
        "chart-column-decreasing",
        "<path d=\"M13 17V9\" />\n  <path d=\"M18 17v-3\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M8 17V5\" />"),
    CHART_COLUMN_INCREASING(
        "chart-column-increasing",
        "<path d=\"M13 17V9\" />\n  <path d=\"M18 17V5\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M8 17v-3\" />"),
    CHART_COLUMN_STACKED(
        "chart-column-stacked",
        "<path d=\"M11 13H7\" />\n  <path d=\"M19 9h-4\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <rect x=\"15\" y=\"5\" width=\"4\" height=\"12\" rx=\"1\" />\n  <rect x=\"7\" y=\"8\" width=\"4\" height=\"9\" rx=\"1\" />"),
    CHART_GANTT(
        "chart-gantt",
        "<path d=\"M10 6h8\" />\n  <path d=\"M12 16h6\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M8 11h7\" />"),
    CHART_LINE(
        "chart-line",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"m19 9-5 5-4-4-3 3\" />"),
    CHART_NETWORK(
        "chart-network",
        "<path d=\"m13.11 7.664 1.78 2.672\" />\n  <path d=\"m14.162 12.788-3.324 1.424\" />\n  <path d=\"m20 4-6.06 1.515\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <circle cx=\"12\" cy=\"6\" r=\"2\" />\n  <circle cx=\"16\" cy=\"12\" r=\"2\" />\n  <circle cx=\"9\" cy=\"15\" r=\"2\" />"),
    CHART_NO_AXES_COLUMN(
        "chart-no-axes-column",
        "<path d=\"M5 21v-6\" />\n  <path d=\"M12 21V3\" />\n  <path d=\"M19 21V9\" />"),
    CHART_NO_AXES_COLUMN_DECREASING(
        "chart-no-axes-column-decreasing",
        "<path d=\"M5 21V3\" />\n  <path d=\"M12 21V9\" />\n  <path d=\"M19 21v-6\" />"),
    CHART_NO_AXES_COLUMN_INCREASING(
        "chart-no-axes-column-increasing",
        "<path d=\"M5 21v-6\" />\n  <path d=\"M12 21V9\" />\n  <path d=\"M19 21V3\" />"),
    CHART_NO_AXES_COMBINED(
        "chart-no-axes-combined",
        "<path d=\"M12 16v5\" />\n  <path d=\"M16 14.639V21\" />\n  <path d=\"M20 10.656V21\" />\n  <path d=\"m22 3-8.646 8.646a.5.5 0 0 1-.708 0L9.354 8.354a.5.5 0 0 0-.707 0L2 15\" />\n  <path d=\"M4 18.463V21\" />\n  <path d=\"M8 14.656V21\" />"),
    CHART_NO_AXES_GANTT(
        "chart-no-axes-gantt",
        "<path d=\"M6 5h12\" />\n  <path d=\"M4 12h10\" />\n  <path d=\"M12 19h8\" />"),
    CHART_PIE(
        "chart-pie",
        "<path d=\"M21 12c.552 0 1.005-.449.95-.998a10 10 0 0 0-8.953-8.951c-.55-.055-.998.398-.998.95v8a1 1 0 0 0 1 1z\" />\n  <path d=\"M21.21 15.89A10 10 0 1 1 8 2.83\" />"),
    CHART_SCATTER(
        "chart-scatter",
        "<circle cx=\"7.5\" cy=\"7.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"18.5\" cy=\"5.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"11.5\" cy=\"11.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"7.5\" cy=\"16.5\" r=\".5\" fill=\"currentColor\" />\n  <circle cx=\"17.5\" cy=\"14.5\" r=\".5\" fill=\"currentColor\" />\n  <path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />"),
    CHART_SPLINE(
        "chart-spline",
        "<path d=\"M3 3v16a2 2 0 0 0 2 2h16\" />\n  <path d=\"M7 16c.5-2 1.5-7 4-7 2 0 2 3 4 3 2.5 0 4.5-5 5-7\" />"),
    EQUAL_APPROXIMATELY_NOT(
        "equal-approximately-not",
        "<path d=\"M5 15a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <path d=\"M5 9a6.5 6.5 0 0 1 7 0 6.5 6.5 0 0 0 7 0\" />\n  <line x1=\"19\" x2=\"5\" y1=\"5\" y2=\"19\" />"),
    FOLDER_KANBAN(
        "folder-kanban",
        "<path d=\"M4 20h16a2 2 0 0 0 2-2V8a2 2 0 0 0-2-2h-7.93a2 2 0 0 1-1.66-.9l-.82-1.2A2 2 0 0 0 7.93 3H4a2 2 0 0 0-2 2v13c0 1.1.9 2 2 2Z\" />\n  <path d=\"M8 10v4\" />\n  <path d=\"M12 10v2\" />\n  <path d=\"M16 10v6\" />"),
    GRAPH_STAR(
        "graph-star",
        "<path d=\"m12.342 9.316 1.764-3.527\" />\n  <path d=\"m12.59 14.545 2.35 3.759\" />\n  <path d=\"m13.982 12.332 4.03.447\" />\n  <path d=\"M5.414 17.586 8.88 14.12\" />\n  <path d=\"M9.025 9.742 5.317 5.505\" />\n  <circle cx=\"11\" cy=\"12\" r=\"3\" />\n  <circle cx=\"15\" cy=\"4\" r=\"2\" />\n  <circle cx=\"16\" cy=\"20\" r=\"2\" />\n  <circle cx=\"20\" cy=\"13\" r=\"2\" />\n  <circle cx=\"4\" cy=\"19\" r=\"2\" />\n  <circle cx=\"4\" cy=\"4\" r=\"2\" />"),
    KANBAN("kanban", "<path d=\"M5 3v14\" />\n  <path d=\"M12 3v8\" />\n  <path d=\"M19 3v18\" />"),
    SQUARE_CHART_GANTT(
        "square-chart-gantt",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M9 8h7\" />\n  <path d=\"M8 12h6\" />\n  <path d=\"M11 16h5\" />"),
    SQUARE_DASHED_KANBAN(
        "square-dashed-kanban",
        "<path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />\n  <path d=\"M5 3a2 2 0 0 0-2 2\" />\n  <path d=\"M9 3h1\" />\n  <path d=\"M14 3h1\" />\n  <path d=\"M19 3a2 2 0 0 1 2 2\" />\n  <path d=\"M21 9v1\" />\n  <path d=\"M21 14v1\" />\n  <path d=\"M21 19a2 2 0 0 1-2 2\" />\n  <path d=\"M14 21h1\" />\n  <path d=\"M9 21h1\" />\n  <path d=\"M5 21a2 2 0 0 1-2-2\" />\n  <path d=\"M3 14v1\" />\n  <path d=\"M3 9v1\" />"),
    SQUARE_KANBAN(
        "square-kanban",
        "<rect width=\"18\" height=\"18\" x=\"3\" y=\"3\" rx=\"2\" />\n  <path d=\"M8 7v7\" />\n  <path d=\"M12 7v4\" />\n  <path d=\"M16 7v9\" />"),
    TRENDING_DOWN(
        "trending-down", "<path d=\"M16 17h6v-6\" />\n  <path d=\"m22 17-8.5-8.5-5 5L2 7\" />"),
    TRENDING_UP("trending-up", "<path d=\"M16 7h6v6\" />\n  <path d=\"m22 7-8.5 8.5-5-5L2 17\" />"),
    TRENDING_UP_DOWN(
        "trending-up-down",
        "<path d=\"M14.828 14.828 21 21\" />\n  <path d=\"M21 16v5h-5\" />\n  <path d=\"m21 3-9 9-4-4-6 6\" />\n  <path d=\"M21 8V3h-5\" />");

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
  default LucideIcon chart_area() {
    return LucideIcon.create(Icon.CHART_AREA);
  }

  default LucideIcon chart_bar() {
    return LucideIcon.create(Icon.CHART_BAR);
  }

  default LucideIcon chart_bar_big() {
    return LucideIcon.create(Icon.CHART_BAR_BIG);
  }

  default LucideIcon chart_bar_decreasing() {
    return LucideIcon.create(Icon.CHART_BAR_DECREASING);
  }

  default LucideIcon chart_bar_increasing() {
    return LucideIcon.create(Icon.CHART_BAR_INCREASING);
  }

  default LucideIcon chart_bar_stacked() {
    return LucideIcon.create(Icon.CHART_BAR_STACKED);
  }

  default LucideIcon chart_candlestick_charts() {
    return LucideIcon.create(Icon.CHART_CANDLESTICK);
  }

  default LucideIcon chart_column() {
    return LucideIcon.create(Icon.CHART_COLUMN);
  }

  default LucideIcon chart_column_big() {
    return LucideIcon.create(Icon.CHART_COLUMN_BIG);
  }

  default LucideIcon chart_column_decreasing() {
    return LucideIcon.create(Icon.CHART_COLUMN_DECREASING);
  }

  default LucideIcon chart_column_increasing() {
    return LucideIcon.create(Icon.CHART_COLUMN_INCREASING);
  }

  default LucideIcon chart_column_stacked() {
    return LucideIcon.create(Icon.CHART_COLUMN_STACKED);
  }

  default LucideIcon chart_gantt() {
    return LucideIcon.create(Icon.CHART_GANTT);
  }

  default LucideIcon chart_line() {
    return LucideIcon.create(Icon.CHART_LINE);
  }

  default LucideIcon chart_network() {
    return LucideIcon.create(Icon.CHART_NETWORK);
  }

  default LucideIcon chart_no_axes_column() {
    return LucideIcon.create(Icon.CHART_NO_AXES_COLUMN);
  }

  default LucideIcon chart_no_axes_column_decreasing() {
    return LucideIcon.create(Icon.CHART_NO_AXES_COLUMN_DECREASING);
  }

  default LucideIcon chart_no_axes_column_increasing() {
    return LucideIcon.create(Icon.CHART_NO_AXES_COLUMN_INCREASING);
  }

  default LucideIcon chart_no_axes_combined() {
    return LucideIcon.create(Icon.CHART_NO_AXES_COMBINED);
  }

  default LucideIcon chart_no_axes_gantt_charts() {
    return LucideIcon.create(Icon.CHART_NO_AXES_GANTT);
  }

  default LucideIcon chart_pie_charts() {
    return LucideIcon.create(Icon.CHART_PIE);
  }

  default LucideIcon chart_scatter() {
    return LucideIcon.create(Icon.CHART_SCATTER);
  }

  default LucideIcon chart_spline() {
    return LucideIcon.create(Icon.CHART_SPLINE);
  }

  default LucideIcon equal_approximately_not_charts() {
    return LucideIcon.create(Icon.EQUAL_APPROXIMATELY_NOT);
  }

  default LucideIcon folder_kanban_charts() {
    return LucideIcon.create(Icon.FOLDER_KANBAN);
  }

  default LucideIcon graph_star_charts() {
    return LucideIcon.create(Icon.GRAPH_STAR);
  }

  default LucideIcon kanban_charts() {
    return LucideIcon.create(Icon.KANBAN);
  }

  default LucideIcon square_chart_gantt_charts() {
    return LucideIcon.create(Icon.SQUARE_CHART_GANTT);
  }

  default LucideIcon square_dashed_kanban_charts() {
    return LucideIcon.create(Icon.SQUARE_DASHED_KANBAN);
  }

  default LucideIcon square_kanban_charts() {
    return LucideIcon.create(Icon.SQUARE_KANBAN);
  }

  default LucideIcon trending_down_charts() {
    return LucideIcon.create(Icon.TRENDING_DOWN);
  }

  default LucideIcon trending_up_charts() {
    return LucideIcon.create(Icon.TRENDING_UP);
  }

  default LucideIcon trending_up_down_charts() {
    return LucideIcon.create(Icon.TRENDING_UP_DOWN);
  }
}
