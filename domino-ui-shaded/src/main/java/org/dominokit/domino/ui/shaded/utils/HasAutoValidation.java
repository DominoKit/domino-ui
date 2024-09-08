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
package org.dominokit.domino.ui.shaded.utils;

import org.gwtproject.editor.client.Editor;

/**
 * Components that need to use the auto validation feature should implement this interface
 *
 * @param <T> the type of the class implementing this interface
 */
@Deprecated
public interface HasAutoValidation<T> {

  /**
   * @param autoValidation boolean, true to enable auto validation, false to disable it
   * @return T the instance of the implementing class
   */
  @Editor.Ignore
  T setAutoValidation(boolean autoValidation);

  /** @return boolean, true if auto validation is enabled, otherwise false */
  @Editor.Ignore
  boolean isAutoValidation();
}
