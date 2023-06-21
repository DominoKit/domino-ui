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

/**
 * Components that can be enabled/disabled should implement this interface
 *
 * @param <T> the type of the component implementing this interface
 * @author vegegoku
 * @version $Id: $Id
 */
public interface AcceptDisable<T> {

  /**
   * Set the component as enabled
   *
   * @return same implementing component
   */
  @Editor.Ignore
  T enable();

  /**
   * Set the component as disabled
   *
   * @return same implementing component
   */
  @Editor.Ignore
  T disable();

  /** @return boolean, true if component is enabled else false */
  /**
   * isEnabled.
   *
   * @return a boolean
   */
  @Editor.Ignore
  boolean isEnabled();
}
