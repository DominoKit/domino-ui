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

/**
 * The {@code TableEventListener} interface defines a contract for classes that can handle table
 * events. Implementing classes should provide an implementation for the {@code handleEvent} method.
 */
public interface TableEventListener {

  /**
   * Handles a table event.
   *
   * @param event the table event to handle
   */
  void handleEvent(TableEvent event);
}
