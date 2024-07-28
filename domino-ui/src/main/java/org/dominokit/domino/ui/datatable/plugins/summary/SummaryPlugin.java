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

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.events.TableEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.datatable.plugins.HasPluginConfig;
import org.dominokit.domino.ui.elements.TFootElement;
import org.dominokit.domino.ui.utils.BaseDominoElement;

/**
 * The {@code SummaryPlugin} class is used to display summary rows in a {@link DataTable}. Summary
 * rows provide aggregate information about the data in the table.
 *
 * <p>Usage Example:
 *
 * <pre><code>
 * DataTable&lt;Employee&gt; dataTable = DataTable.create(dataList);
 * SummaryPlugin&lt;Employee, SummaryData&gt; summaryPlugin = new SummaryPlugin&lt;&gt;();
 * dataTable.addPlugin(summaryPlugin);
 * summaryPlugin.setSummaryRecords(summaryDataList);
 * </code></pre>
 *
 * @param <T> The type of data in the DataTable.
 * @param <S> The type of data in the summary row.
 */
public class SummaryPlugin<T, S>
    implements DataTablePlugin<T>, HasPluginConfig<T, SummaryPlugin<T, S>, SummaryPluginConfig> {

  private List<SummaryRow<T, S>> summaryRows = new ArrayList<>();
  private DataTable<T> dataTable;
  private TFootElement footer;
  private SummaryPluginConfig config = SummaryPluginConfig.of();

  /**
   * Initializes the SummaryPlugin with the DataTable.
   *
   * @param dataTable The DataTable to which this plugin is added.
   */
  @Override
  public void init(DataTable<T> dataTable) {
    this.dataTable = dataTable;
  }

  /**
   * Invoked when the footer is added to the DataTable.
   *
   * @param datatable The DataTable to which the footer is added.
   */
  @Override
  public void onFooterAdded(DataTable<T> datatable) {
    this.footer = datatable.footerElement();
  }

  /**
   * Sets the summary records to be displayed in the DataTable. Any existing summary rows are
   * removed and replaced with new ones based on the provided records.
   *
   * @param records A collection of summary records.
   * @return This SummaryPlugin instance.
   */
  public SummaryPlugin<T, S> setSummaryRecords(Collection<S> records) {
    removeSummaryRecords();
    if (this.config.isRemoveOnEmptyData() && this.dataTable.getRecords().isEmpty()) {
      return this;
    }
    List<S> recordsList = new ArrayList<>(records);
    for (int i = 0; i < recordsList.size(); i++) {
      SummaryRow<T, S> summaryRow = new SummaryRow<>(recordsList.get(i), i, this.dataTable);
      summaryRow.render();
      footer.appendChild(summaryRow);
      summaryRows.add(summaryRow);
    }
    return this;
  }

  public void removeSummaryRecords() {
    summaryRows.forEach(BaseDominoElement::remove);
    summaryRows.clear();
  }

  @Override
  public void handleEvent(TableEvent event) {
    if (TableDataUpdatedEvent.DATA_UPDATED.equals(event.getType())) {
      if (config.isRemoveOnEmptyData() && ((TableDataUpdatedEvent<T>) event).getData().isEmpty()) {
        removeSummaryRecords();
      }
    }
  }

  /**
   * Sets the configuration for the SummaryPlugin.
   *
   * @param config The SummaryPlugin to set.
   * @return The SummaryPlugin instance.
   */
  @Override
  public SummaryPlugin<T, S> setConfig(SummaryPluginConfig config) {
    if (isNull(config)) {
      this.config = SummaryPluginConfig.of();
    } else {
      this.config = config;
    }
    return this;
  }

  /**
   * Gets the current configuration of the SummaryPlugin.
   *
   * @return The current SummaryPluginConfig.
   */
  @Override
  public SummaryPluginConfig getConfig() {
    return config;
  }

  /**
   * Specifies the order in which this plugin should be applied relative to other plugins. Plugins
   * with lower order values are applied first.
   *
   * @return The order value for this plugin.
   */
  @Override
  public int order() {
    return 10;
  }
}
