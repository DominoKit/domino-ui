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

package org.dominokit.domino.ui.datatable.plugins.marker;

import java.util.Optional;
import org.dominokit.domino.ui.datatable.TableRow;
import org.dominokit.domino.ui.style.CssClass;
import org.dominokit.domino.ui.utils.ComponentMeta;

/**
 * A meta-information class that holds the marker CSS class for a table row in the DataTable.
 *
 * @param <T> The type of data in the DataTable.
 */
public class RowMarkerMeta<T> implements ComponentMeta {

  /** The key used to identify this meta-information in the TableRow. */
  public static final String DOMINO_ROW_MARKER_META = "domino-row-marker-meta";

  private CssClass markerCssClass;

  /**
   * Creates a new {@link RowMarkerMeta} instance with the specified marker CSS class.
   *
   * @param markerCssClass The CSS class representing the row marker.
   */
  public RowMarkerMeta(CssClass markerCssClass) {
    this.markerCssClass = markerCssClass;
  }

  /**
   * Static factory method to create a new {@link RowMarkerMeta} instance with the specified marker
   * CSS class.
   *
   * @param <T> The type of data in the DataTable.
   * @param markerCssClass The CSS class representing the row marker.
   * @return A new {@link RowMarkerMeta} instance.
   */
  public static <T> RowMarkerMeta<T> of(CssClass markerCssClass) {
    return new RowMarkerMeta<>(markerCssClass);
  }

  /**
   * {@inheritDoc}
   *
   * <p>Returns the key used to identify this meta-information.
   *
   * @return The key, which is {@link #DOMINO_ROW_MARKER_META}.
   */
  @Override
  public String getKey() {
    return DOMINO_ROW_MARKER_META;
  }

  /**
   * Retrieves the {@link RowMarkerMeta} instance associated with the specified table row.
   *
   * @param <T> The type of data in the DataTable.
   * @param row The TableRow for which to retrieve the marker meta-information.
   * @return An {@link Optional} containing the {@link RowMarkerMeta} instance if present, or empty
   *     otherwise.
   */
  public static <T> Optional<RowMarkerMeta<T>> get(TableRow<T> row) {
    return row.getMeta(DOMINO_ROW_MARKER_META);
  }

  /**
   * Gets the CSS class representing the row marker.
   *
   * @return The CSS class representing the row marker.
   */
  public CssClass getMarkerCssClass() {
    return markerCssClass;
  }
}
