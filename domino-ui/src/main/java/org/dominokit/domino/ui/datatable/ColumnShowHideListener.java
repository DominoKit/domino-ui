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
package org.dominokit.domino.ui.datatable;

/**
 * Implementations of this interface can listen to columns show/hide events
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public interface ColumnShowHideListener {
  /** @param visible boolean, if true the column has become visible, otherwise it is hidden */
  /**
   * onShowHide.
   *
   * @param visible a boolean
   */
  void onShowHide(boolean visible);

  /**
   * isPermanent.
   *
   * @return boolean, if true the listener wont be removed if the listeners of the column are
   *     cleared.
   */
  boolean isPermanent();
}
