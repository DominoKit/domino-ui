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
package org.dominokit.domino.ui.utils;

import org.gwtproject.editor.client.Editor;

public interface Clearable<T> {

  /**
   * Clears the field value and trigger the change handlers
   *
   * @return same implementing component instance
   */
  @Editor.Ignore
  T clear();

  /**
   * Clears the field value and only triggers the change handlers if silent flag is true
   *
   * @param silent boolean, if false clear the value without triggering the change handlers
   * @return same implementing component instance
   */
  @Editor.Ignore
  T clear(boolean silent);
}
