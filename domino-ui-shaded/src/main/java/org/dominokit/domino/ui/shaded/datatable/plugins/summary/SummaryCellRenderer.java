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
package org.dominokit.domino.ui.shaded.datatable.plugins.summary;

import elemental2.dom.HTMLTableCellElement;
import elemental2.dom.Node;

/**
 * An implementation of this interface will determine in how a table cell content will be displayed
 * and rendered in the table
 *
 * @param <T> the type of the data table records
 */
@FunctionalInterface
@Deprecated
public interface SummaryCellRenderer<T, S> {
  /**
   * Takes a cell info to determine what content to append to the cell element
   *
   * @param summaryCellInfo {@link SummaryCellInfo}
   * @return the {@link Node} to be appended to the table cell element
   */
  Node asElement(SummaryCellInfo<T, S> summaryCellInfo);

  /**
   * A class containing all information required about a cell in a data table
   *
   * @param <T> the type of the data table records
   */
  class SummaryCellInfo<T, S> {
    private final SummaryRow<T, S> summaryRow;
    private final HTMLTableCellElement element;

    /**
     * Creates an instance with the row that the belongs to and the cell html element
     *
     * @param summaryRow {@link SummaryRow}
     * @param element {@link HTMLTableCellElement} the td element
     */
    public SummaryCellInfo(SummaryRow<T, S> summaryRow, HTMLTableCellElement element) {
      this.summaryRow = summaryRow;
      this.element = element;
    }

    /** @return the {@link SummaryRow} the cell belongs to */
    public SummaryRow<T, S> getSummaryRow() {
      return summaryRow;
    }

    /** @return the {@link HTMLTableCellElement}, the td element */
    public HTMLTableCellElement getElement() {
      return element;
    }

    /** @return T the record instance being rendered on the row this belongs to. */
    public S getRecord() {
      return summaryRow.getRecord();
    }
  }
}
