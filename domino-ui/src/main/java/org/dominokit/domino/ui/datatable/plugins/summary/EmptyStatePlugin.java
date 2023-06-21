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

import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.events.TableDataUpdatedEvent;
import org.dominokit.domino.ui.datatable.plugins.DataTablePlugin;
import org.dominokit.domino.ui.icons.Icon;
import org.dominokit.domino.ui.layout.EmptyState;
import org.dominokit.domino.ui.utils.ChildHandler;

/**
 * This plugin attache a pre-defined {@link org.dominokit.domino.ui.layout.EmptyState} component
 * elements to the data table when the data table has no records, and remove it when there is
 * records
 *
 * @param <T> the type of the data table records
 * @author vegegoku
 * @version $Id: $Id
 */
public class EmptyStatePlugin<T> implements DataTablePlugin<T> {

  private EmptyState emptyState;

  /**
   * create.
   *
   * @param icon a {@link org.dominokit.domino.ui.icons.Icon} object
   * @param title a {@link java.lang.String} object
   * @param <T> a T class
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.summary.EmptyStatePlugin} object
   */
  public static <T> EmptyStatePlugin<T> create(Icon<?> icon, String title) {
    return new EmptyStatePlugin<>(icon, title);
  }

  /**
   * Create an instance with custom icon and title
   *
   * @param emptyStateIcon the {@link org.dominokit.domino.ui.icons.Icon} of the empty state
   * @param title String, the title of the empty state
   */
  public EmptyStatePlugin(Icon<?> emptyStateIcon, String title) {
    emptyState = EmptyState.create(emptyStateIcon).setTitle(title).addCss(dui_accent_grey);
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
  /**
   * Getter for the field <code>emptyState</code>.
   *
   * @return a {@link org.dominokit.domino.ui.layout.EmptyState} object
   */
  public EmptyState getEmptyState() {
    return emptyState;
  }

  /**
   * withEmptyState.
   *
   * @param handler a {@link org.dominokit.domino.ui.utils.ChildHandler} object
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.summary.EmptyStatePlugin} object
   */
  public EmptyStatePlugin<T> withEmptyState(ChildHandler<EmptyStatePlugin<T>, EmptyState> handler) {
    handler.apply(this, emptyState);
    return this;
  }
}
