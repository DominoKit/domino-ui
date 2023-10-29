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
package org.dominokit.domino.ui.datatable.plugins;

import elemental2.core.JsMath;
import elemental2.dom.HTMLTableElement;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.BodyScrollEvent;

/**
 * This plugin fires {@link BodyScrollEvent} whenever the table body scroll reaches the top of the
 * bottom
 *
 * @param <T> the type of the data table records
 */
public class BodyScrollPlugin<T>
    implements DataTablePlugin<T>, HasPluginConfig<T, BodyScrollPlugin<T>, BodyScrollPluginConfig> {

  private BodyScrollPluginConfig config = new BodyScrollPluginConfig(0);

  /** {@inheritDoc} */
  @Override
  public void onBodyAdded(DataTable<T> dataTable) {
    HTMLTableElement scrollElement = dataTable.tableElement().element();
    scrollElement.addEventListener(
        "scroll",
        evt -> {
          double scrollTop = new Double(scrollElement.scrollTop).intValue();
          if (scrollTop == 0) {
            dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.TOP));
          }
          int offsetHeight = new Double(scrollElement.offsetHeight).intValue();
          int scrollHeight = new Double(scrollElement.scrollHeight).intValue();
          int clientHeight = new Double(scrollElement.clientHeight).intValue();

          if (JsMath.abs(offsetHeight) + JsMath.abs(scrollTop)
              >= new Double(scrollHeight + (offsetHeight - clientHeight)).intValue()
                  - config.getOffset()) {
            dataTable.fireTableEvent(new BodyScrollEvent(ScrollPosition.BOTTOM));
          }
        });
  }

  /**
   * Sets up the plugin configuration.
   *
   * @param config The plugin configuration.
   */
  @Override
  public BodyScrollPlugin<T> setConfig(BodyScrollPluginConfig config) {
    this.config = config;
    return this;
  }

  /** @return the plugin configuration */
  @Override
  public BodyScrollPluginConfig getConfig() {
    return this.config;
  }

  /** An enum to specify the postion of the scroll */
  public enum ScrollPosition {
    /** The scroll reached the top */
    TOP,
    /** The scroll reached the bottom */
    BOTTOM
  }
}
