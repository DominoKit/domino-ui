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

import elemental2.dom.HTMLTableSectionElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.utils.BaseDominoElement;
import org.dominokit.domino.ui.utils.DominoElement;

@Deprecated
public class SummaryPlugin<T, S> implements DataTablePlugin<T> {

  private List<TableRow<S>> summaryRows = new ArrayList<>();
  private DataTable<T> dataTable;
  private DominoElement<HTMLTableSectionElement> footer;

  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  @Override
  public void onFooterAdded(DataTable<T> datatable) {
    this.footer = datatable.footerElement();
  }

  public SummaryPlugin<T, S> setSummaryRecords(Collection<S> records) {
    summaryRows.forEach(BaseDominoElement::remove);
    summaryRows.clear();
    List<S> recordsList = new ArrayList<>(records);
    for (int i = 0; i < recordsList.size(); i++) {
      SummaryRow<T, S> summaryRow = new SummaryRow<>(recordsList.get(i), i, this.dataTable);
      summaryRow.render();
      footer.appendChild(summaryRow);
    }
    return this;
  }

  @Override
  public int order() {
    return 10;
  }
}
