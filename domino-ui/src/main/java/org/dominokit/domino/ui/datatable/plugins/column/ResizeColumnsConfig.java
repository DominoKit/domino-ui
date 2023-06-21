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
package org.dominokit.domino.ui.datatable.plugins.column;

import org.dominokit.domino.ui.datatable.plugins.PluginConfig;

/**
 * ResizeColumnsConfig class.
 *
 * @author vegegoku
 * @version $Id: $Id
 */
public class ResizeColumnsConfig implements PluginConfig {

  private boolean clipContent = false;

  /**
   * isClipContent.
   *
   * @return a boolean
   */
  public boolean isClipContent() {
    return clipContent;
  }

  /**
   * Setter for the field <code>clipContent</code>.
   *
   * @param clipContent a boolean
   * @return a {@link org.dominokit.domino.ui.datatable.plugins.column.ResizeColumnsConfig} object
   */
  public ResizeColumnsConfig setClipContent(boolean clipContent) {
    this.clipContent = clipContent;
    return this;
  }
}
