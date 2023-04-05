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
package org.dominokit.domino.ui.datatable.events;

import java.util.List;
import org.dominokit.domino.ui.datatable.ColumnConfig;

/**
 * This event will be fired when a column has been marked as sticky column from {@link
 * StickyColumnsPlugin}
 *
 * @param <T> the type of the table records
 */
public class StickyColumnsEvent<T> implements TableEvent {

  public static final String STICKY_COLUMNS = "sticky-columns";

  private final List<ColumnConfig<T>> columns;

  public StickyColumnsEvent(List<ColumnConfig<T>> columns) {
    this.columns = columns;
  }

  /** {@inheritDoc} */
  @Override
  public String getType() {
    return STICKY_COLUMNS;
  }

  /** @return the sticky columns */
  public List<ColumnConfig<T>> getColumns() {
    return columns;
  }
}
