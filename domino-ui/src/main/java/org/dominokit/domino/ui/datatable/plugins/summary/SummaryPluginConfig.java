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

import org.dominokit.domino.ui.datatable.plugins.PluginConfig;

public class SummaryPluginConfig implements PluginConfig {

  private boolean removeOnEmptyData = false;

  /**
   * @return boolean, true will cause the plugin to remove the summary records for empty data
   *     tables, false will keep them, default to false
   */
  public boolean isRemoveOnEmptyData() {
    return removeOnEmptyData;
  }

  /**
   * Use this to configure the plugin to remove/keep the summary records when the datatable has no
   * records.
   *
   * @param removeOnEmptyData boolean, true to remove the records, false to keep them.
   * @return same config instance.
   */
  public SummaryPluginConfig setRemoveOnEmptyData(boolean removeOnEmptyData) {
    this.removeOnEmptyData = removeOnEmptyData;
    return this;
  }
}
