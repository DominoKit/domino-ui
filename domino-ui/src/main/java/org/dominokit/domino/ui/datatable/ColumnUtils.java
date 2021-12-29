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
package org.dominokit.domino.ui.datatable;

import static java.util.Objects.nonNull;

import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.style.Style;

public class ColumnUtils {

  public static <T> void fixElementWidth(
      ColumnConfig<T> column, HTMLElement element, String fixedDefaultColumnWidth) {
    String fixedWidth = bestFitWidth(column, fixedDefaultColumnWidth);
    Style.of(element)
        .setWidth(fixedWidth)
        .setMinWidth(fixedWidth)
        .setMaxWidth(fixedWidth)
        .addCss(DataTableStyles.FIXED_WIDTH);
  }

  /**
   * @param columnConfig String value of preferred width to be used for a column from its width.
   *     min-width, max-width or default fixedDefaultColumnWidth
   * @param fixedDefaultColumnWidth
   * @return same TableConfig instance
   */
  private static <T> String bestFitWidth(
      ColumnConfig<T> columnConfig, String fixedDefaultColumnWidth) {
    if (nonNull(columnConfig.getWidth()) && !columnConfig.getWidth().isEmpty()) {
      return columnConfig.getWidth();
    } else if (nonNull(columnConfig.getMinWidth()) && !columnConfig.getMinWidth().isEmpty()) {
      return columnConfig.getMinWidth();
    } else if (nonNull(columnConfig.getMaxWidth()) && !columnConfig.getMaxWidth().isEmpty()) {
      return columnConfig.getMaxWidth();
    } else {
      return fixedDefaultColumnWidth;
    }
  }
}
