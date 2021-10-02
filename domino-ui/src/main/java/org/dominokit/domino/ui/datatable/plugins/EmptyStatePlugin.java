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

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.icons.BaseIcon;
import org.dominokit.domino.ui.layout.EmptyState;
import org.dominokit.domino.ui.style.Color;
import org.dominokit.domino.ui.style.Styles;

/**
 * This plugin attache a pre-defined {@link EmptyState} component elements to the data table when
 * the data table has no records, and remove it when there is records
 *
 * @param <T> the type of the data table records
 */
public class EmptyStatePlugin<T> implements DataTablePlugin<T> {

  private EmptyState emptyState;

  /**
   * Create an instance with custom icon and title
   *
   * @param emptyStateIcon the {@link BaseIcon} of the empty state
   * @param title String, the title of the empty state
   */
  public EmptyStatePlugin(BaseIcon<?> emptyStateIcon, String title) {
    emptyState =
        EmptyState.create(emptyStateIcon)
            .setTitle(title)
            .setIconColor(Color.GREY)
            .setTitleColor(Color.GREY)
            .removeCss(Styles.vertical_center);
  }

  /** {@inheritDoc} */
  @Override
  public void onAfterAddTable(DataTable dataTable) {
    dataTable.addTableEventListener(
        TableDataUpdatedEvent.DATA_UPDATED,
        event -> {
          TableDataUpdatedEvent tableDataUpdatedEvent = (TableDataUpdatedEvent) event;
          if (tableDataUpdatedEvent.getTotalCount() == 0) {
            emptyState.show();
          } else {
            emptyState.hide();
          }
        });
    dataTable.element().appendChild(emptyState.element());
  }

  /** @return the {@link EmptyState} component instance of this plugin */
  public EmptyState getEmptyState() {
    return emptyState;
  }
}
