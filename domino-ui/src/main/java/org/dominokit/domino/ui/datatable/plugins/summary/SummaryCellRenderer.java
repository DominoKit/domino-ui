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

import static org.dominokit.domino.ui.utils.Domino.*;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;

/**
 * The {@code SummaryCellRenderer} functional interface is used for rendering summary cells in a
 * DataTable's summary row.
 *
 * @param <T> The type of data in the DataTable.
 * @param <S> The type of data in the summary row.
 */
@FunctionalInterface
public interface SummaryCellRenderer<T, S> {

  /**
   * Renders a summary cell as a DOM Node based on the provided {@link SummaryCellInfo}.
   *
   * @param summaryCellInfo The information about the summary cell to be rendered.
   * @return The rendered summary cell as a DOM Node.
   */
  Node asElement(SummaryCellInfo<T, S> summaryCellInfo);

  /**
   * The {@code SummaryCellInfo} class encapsulates information about a summary cell in a
   * DataTable's summary row.
   *
   * @param <T> The type of data in the DataTable.
   * @param <S> The type of data in the summary row.
   */
  class SummaryCellInfo<T, S> {
    private final SummaryRow<T, S> summaryRow;
    private final HTMLTableCellElement element;

    /**
     * Creates a new instance of {@code SummaryCellInfo} with the provided summary row and HTML
     * table cell element.
     *
     * @param summaryRow The summary row containing the summary cell.
     * @param element The HTML table cell element representing the summary cell.
     */
    public SummaryCellInfo(SummaryRow<T, S> summaryRow, HTMLTableCellElement element) {
      this.summaryRow = summaryRow;
      this.element = element;
    }

    /**
     * Gets the summary row containing the summary cell.
     *
     * @return The summary row.
     */
    public SummaryRow<T, S> getSummaryRow() {
      return summaryRow;
    }

    /**
     * Gets the HTML table cell element representing the summary cell.
     *
     * @return The HTML table cell element.
     */
    public HTMLTableCellElement getElement() {
      return element;
    }

    /**
     * Gets the summary record associated with the summary cell.
     *
     * @return The summary record.
     */
    public S getRecord() {
      return summaryRow.getRecord();
    }
  }
}
