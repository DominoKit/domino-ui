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
import static org.dominokit.domino.ui.utils.ElementsFactory.elements;

import elemental2.dom.HTMLElement;
import java.util.Optional;
import org.dominokit.domino.ui.style.Style;
import org.dominokit.domino.ui.utils.DominoCSSRule;

public class ColumnUtils {

  public static <T> void fixElementWidth(ColumnConfig<T> column, HTMLElement element) {
    bestFitWidth(column)
        .ifPresent(
            fixedWidth -> {
              ColumnCssRuleMeta.get(column)
                  .ifPresent(
                      meta ->
                          meta.getColumnCssRule(ColumnCssRuleMeta.DEFAULT_RULE)
                              .ifPresent(
                                  columnCssRule -> {
                                    DominoCSSRule cssRule = columnCssRule.getCssRule();
                                    cssRule.setProperty("width", fixedWidth);
                                    if (nonNull(column.getMinWidth())
                                        && !column.getMinWidth().isEmpty()) {
                                      cssRule.setProperty("min-width", column.getMinWidth());
                                    } else {
                                      cssRule.setProperty("min-width", fixedWidth);
                                    }
                                    if (nonNull(column.getMaxWidth())
                                        && !column.getMaxWidth().isEmpty()) {
                                      cssRule.setProperty("max-width", column.getMaxWidth());
                                    } else {
                                      cssRule.setProperty("max-width", fixedWidth);
                                    }
                                  }));
              Style.of(element).addCss(DataTableStyles.fixed_width);
            });
    ;
  }

  public static <T> void fixElementWidth(DataTable<T> table, HTMLElement element) {

    TableConfig<T> config = table.getTableConfig();
    if (nonNull(config.getWidth()) && !config.getWidth().isEmpty()) {
      elements.elementOf(element).setWidth(config.getWidth());
    }
    if (nonNull(config.getMinWidth()) && !config.getMinWidth().isEmpty()) {
      elements.elementOf(element).setMinWidth(config.getMinWidth());
    }
    if (nonNull(config.getMaxWidth()) && !config.getMaxWidth().isEmpty()) {
      elements.elementOf(element).setMaxWidth(config.getMaxWidth());
    }
  }

  /**
   * @param columnConfig String value of preferred width to be used for a column from its width.
   *     min-width, max-width or default none
   * @return same TableConfig instance
   */
  private static <T> Optional<String> bestFitWidth(ColumnConfig<T> columnConfig) {
    if (nonNull(columnConfig.getWidth()) && !columnConfig.getWidth().isEmpty()) {
      return Optional.of(columnConfig.getWidth());
    } else if (nonNull(columnConfig.getMinWidth()) && !columnConfig.getMinWidth().isEmpty()) {
      return Optional.of(columnConfig.getMinWidth());
    } else if (nonNull(columnConfig.getMaxWidth()) && !columnConfig.getMaxWidth().isEmpty()) {
      return Optional.of(columnConfig.getMaxWidth());
    } else {
      return Optional.empty();
    }
  }
}
