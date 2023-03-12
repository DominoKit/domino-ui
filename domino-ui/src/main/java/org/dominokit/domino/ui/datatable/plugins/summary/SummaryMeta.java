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
package org.dominokit.domino.ui.datatable.plugins.summary;

import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;

import java.util.Objects;
import java.util.Optional;

public class SummaryMeta<T, S> implements ComponentMeta {

  public static final String COLUMN_SUMMARY_META = "column-summary-meta";

  private SummaryCellRenderer<T, S> cellRenderer;
  private boolean skip = false;

  public static <T, S> SummaryMeta<T, S> of(SummaryCellRenderer<T, S> cellRenderer) {
    return new SummaryMeta<>(cellRenderer);
  }

  public SummaryMeta(SummaryCellRenderer<T, S> cellRenderer) {
    Objects.requireNonNull(cellRenderer, "Summary cell renderer cant be null.");
    this.cellRenderer = cellRenderer;
  }

  public static <T, S> Optional<SummaryMeta<T, S>> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_SUMMARY_META);
  }

  public SummaryCellRenderer<T, S> getCellRenderer() {
    return cellRenderer;
  }

  public SummaryMeta<T, S> setCellRenderer(SummaryCellRenderer<T, S> cellRenderer) {
    this.cellRenderer = cellRenderer;
    return this;
  }

  public boolean isSkip() {
    return skip;
  }

  public SummaryMeta<T, S> setSkip(boolean skip) {
    this.skip = skip;
    return this;
  }

  @Override
  public String getKey() {
    return COLUMN_SUMMARY_META;
  }
}
