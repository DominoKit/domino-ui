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
package org.dominokit.domino.ui.forms;

import org.dominokit.domino.ui.utils.*;
import org.gwtproject.editor.client.Editor;

/**
 * Components that can be grouped by a {@link FieldsGrouping} should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 */
public interface HasGrouping<T>
    extends AcceptDisable<T>, AcceptReadOnly<T>, IsRequired<T>, HasValidation<T>, Clearable<T> {

  /**
   * Adds the component to the specified fields group
   *
   * @param fieldsGrouping {@link FieldsGrouping}
   * @return same implementing component instance
   */
  @Editor.Ignore
  T groupBy(FieldsGrouping fieldsGrouping);

  /**
   * remove the component from the specified fields group
   *
   * @param fieldsGrouping {@link FieldsGrouping}
   * @return same implementing component instance
   */
  @Editor.Ignore
  T ungroup(FieldsGrouping fieldsGrouping);

  /** @return boolean, true if the component value is empty */
  @Editor.Ignore
  boolean isEmpty();

  /** @return boolean, true if the component value is empty after trimming spaces */
  @Editor.Ignore
  boolean isEmptyIgnoreSpaces();

  @Editor.Ignore
  T fixErrorsPosition(boolean fixErrorsPosition);
}
