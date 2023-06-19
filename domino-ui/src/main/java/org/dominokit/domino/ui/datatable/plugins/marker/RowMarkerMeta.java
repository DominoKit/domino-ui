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

public class RowMarkerMeta<T> implements ComponentMeta {

  public static final String DOMINO_ROW_MARKER_META = "domino-row-marker-meta";

  private CssClass markerCssClass;

  public RowMarkerMeta(CssClass markerCssClass) {
    this.markerCssClass = markerCssClass;
  }

  public static <T> RowMarkerMeta<T> of(CssClass markerCssClass) {
    return new RowMarkerMeta<>(markerCssClass);
  }

  @Override
  public String getKey() {
    return DOMINO_ROW_MARKER_META;
  }

  public static <T> Optional<RowMarkerMeta<T>> get(TableRow<T> row) {
    return row.getMeta(DOMINO_ROW_MARKER_META);
  }

  public CssClass getMarkerCssClass() {
    return markerCssClass;
  }
}
