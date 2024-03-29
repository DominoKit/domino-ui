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
 * Configuration class for the ResizeColumnsPlugin, which allows users to configure the behavior of
 * column resizing.
 */
public class ResizeColumnsConfig implements PluginConfig {

  private boolean clipContent = false;

  /**
   * Checks if content clipping is enabled for column resizing.
   *
   * @return {@code true} if content clipping is enabled, {@code false} otherwise.
   */
  public boolean isClipContent() {
    return clipContent;
  }

  /**
   * Sets whether to enable content clipping during column resizing.
   *
   * @param clipContent {@code true} to enable content clipping, {@code false} to disable it.
   * @return The ResizeColumnsConfig instance with the updated configuration.
   */
  public ResizeColumnsConfig setClipContent(boolean clipContent) {
    this.clipContent = clipContent;
    return this;
  }
}
