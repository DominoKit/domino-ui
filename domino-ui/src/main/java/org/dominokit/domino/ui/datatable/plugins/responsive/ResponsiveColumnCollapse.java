/*
 * Copyright © 2019 Dominokit
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
package org.dominokit.domino.ui.datatable.plugins.responsive;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/** Calculates which secondary columns must move into row details to fit the available width. */
final class ResponsiveColumnCollapse {

  static final double DEFAULT_COLUMN_MIN_WIDTH = 132.0;

  private ResponsiveColumnCollapse() {}

  static double measuredContentWidth(double scrollWidth, double renderedWidth) {
    return Math.max(scrollWidth, renderedWidth);
  }

  static Set<String> determine(
      List<String> secondaryColumns,
      Map<String, Double> columnWidths,
      double fixedColumnsWidth,
      double availableWidth) {
    return determine(
        secondaryColumns,
        columnWidths,
        fixedColumnsWidth,
        availableWidth,
        DEFAULT_COLUMN_MIN_WIDTH);
  }

  static Set<String> determine(
      List<String> secondaryColumns,
      Map<String, Double> columnWidths,
      double fixedColumnsWidth,
      double availableWidth,
      double minimumColumnWidth) {
    Set<String> collapsed = new LinkedHashSet<>();
    double requiredWidth = fixedColumnsWidth;
    for (String column : secondaryColumns) {
      requiredWidth += widthOf(column, columnWidths, minimumColumnWidth);
    }

    // The last logical column is at the visual trailing edge in both directions:
    // rightmost in LTR and leftmost in RTL.
    int index = secondaryColumns.size() - 1;
    while (requiredWidth > availableWidth && index >= 0 && index < secondaryColumns.size()) {
      String column = secondaryColumns.get(index);
      collapsed.add(column);
      requiredWidth -= widthOf(column, columnWidths, minimumColumnWidth);
      index--;
    }
    return collapsed;
  }

  private static double widthOf(
      String column, Map<String, Double> columnWidths, double minimumColumnWidth) {
    Double width = columnWidths.get(column);
    return width == null || width < minimumColumnWidth ? minimumColumnWidth : width;
  }
}
