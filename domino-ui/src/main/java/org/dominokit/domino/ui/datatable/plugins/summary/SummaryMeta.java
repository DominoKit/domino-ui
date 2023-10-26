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

import java.util.Objects;
import java.util.Optional;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * The {@code SummaryMeta} class represents metadata associated with a summary column in a
 * DataTable. It contains information about the summary cell renderer and whether the summary should
 * be skipped.
 *
 * @param <T> The type of data in the DataTable.
 * @param <S> The type of data in the summary row.
 */
public class SummaryMeta<T, S> implements ComponentMeta {

  /** The unique key for identifying summary metadata associated with a column. */
  public static final String COLUMN_SUMMARY_META = "column-summary-meta";

  private SummaryCellRenderer<T, S> cellRenderer;
  private boolean skip = false;

  /**
   * Creates a new instance of {@code SummaryMeta} with the provided summary cell renderer.
   *
   * @param cellRenderer The summary cell renderer to be associated with the summary column.
   * @param <T> The type of data in the DataTable.
   * @param <S> The type of data in the summary row.
   * @return A new instance of {@code SummaryMeta} with the specified summary cell renderer.
   * @throws NullPointerException if {@code cellRenderer} is {@code null}.
   */
  public static <T, S> SummaryMeta<T, S> of(SummaryCellRenderer<T, S> cellRenderer) {
    return new SummaryMeta<>(cellRenderer);
  }

  /**
   * Creates a new instance of {@code SummaryMeta} with the provided summary cell renderer.
   *
   * @param cellRenderer The summary cell renderer to be associated with the summary column.
   * @throws NullPointerException if {@code cellRenderer} is {@code null}.
   */
  public SummaryMeta(SummaryCellRenderer<T, S> cellRenderer) {
    Objects.requireNonNull(cellRenderer, "Summary cell renderer cant be null.");
    this.cellRenderer = cellRenderer;
  }

  /**
   * Retrieves the summary metadata associated with a given column configuration.
   *
   * @param <T> The type of data in the DataTable.
   * @param <S> The type of data in the summary row.
   * @param column The {@link ColumnConfig} for which to retrieve the summary metadata.
   * @return An {@link Optional} containing the {@code SummaryMeta} if found, or an empty {@code
   *     Optional} if not found.
   */
  public static <T, S> Optional<SummaryMeta<T, S>> get(ColumnConfig<?> column) {
    return column.getMeta(COLUMN_SUMMARY_META);
  }

  /**
   * Retrieves the summary cell renderer associated with the summary column.
   *
   * @return The summary cell renderer.
   */
  public SummaryCellRenderer<T, S> getCellRenderer() {
    return cellRenderer;
  }

  /**
   * Sets the summary cell renderer for the summary column.
   *
   * @param cellRenderer The summary cell renderer to be associated with the summary column.
   * @return This {@code SummaryMeta} instance for method chaining.
   */
  public SummaryMeta<T, S> setCellRenderer(SummaryCellRenderer<T, S> cellRenderer) {
    this.cellRenderer = cellRenderer;
    return this;
  }

  /**
   * Checks if the summary column should be skipped.
   *
   * @return {@code true} if the summary column should be skipped, {@code false} otherwise.
   */
  public boolean isSkip() {
    return skip;
  }

  /**
   * Sets whether the summary column should be skipped.
   *
   * @param skip {@code true} to skip the summary column, {@code false} to include it.
   * @return This {@code SummaryMeta} instance for method chaining.
   */
  public SummaryMeta<T, S> setSkip(boolean skip) {
    this.skip = skip;
    return this;
  }

  /**
   * {@inheritDoc}
   *
   * @return The unique key for identifying summary metadata associated with a column.
   */
  @Override
  public String getKey() {
    return COLUMN_SUMMARY_META;
  }
}
