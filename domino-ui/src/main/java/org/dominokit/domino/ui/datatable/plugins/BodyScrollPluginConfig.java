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
package org.dominokit.domino.ui.datatable.plugins;

/**
 * Configuration class for {@link BodyScrollPlugin} Allow the user to define the offset of pixels
 * the plugin will use to fire the event before it reach the bottom of the scroll.
 */
public class BodyScrollPluginConfig implements PluginConfig {

  private int offset;

  /**
   * creates a new instance with the specified scroll offset.
   *
   * @param offset number of pixels to be used as scroll offset.
   */
  public BodyScrollPluginConfig(int offset) {
    this.offset = offset;
  }

  /** @return int number of pixels to use as an offset for reaching the scroll bottom. */
  public int getOffset() {
    return offset;
  }

  /**
   * sets the number of pixels to use as an offset for reaching the scroll bottom.
   *
   * @return same configuration instance
   */
  public BodyScrollPluginConfig setOffset(int offset) {
    this.offset = offset;
    return this;
  }
}
